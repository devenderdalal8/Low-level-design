package Locker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents a Locker system that manages multiple storage containers.
 * Handles package deposition, retrieval via access tokens, and maintenance of expired containers.
 */
public class Locker {
    List<Container> containers;
    Map<String, AccessToken> accessTokenMap;
    private Random random;

    /**
     * Initializes the locker with a list of available containers.
     */
    Locker(List<Container> containers) {
        this.containers = containers;
        accessTokenMap = new HashMap<String, AccessToken>();
        random = new Random();
    }

    /**
     * Deposits a package into an available container of the specified size.
     * @param size The required size of the container.
     * @return A unique access code if successful, or an error message if no container is available.
     */
    String depositPackage(ContainerSize size) {
        //add container
        Container container = getAvailableContainer(size);
        if (container == null) {
            System.err.println("No available container");
            return "No available container";
        }
        //open -> place -> get access code -> close
        container.open();
        container.markOccupied();
        AccessToken accessToken = generateAccessToken(container);
        accessTokenMap.put(accessToken.getCode(), accessToken);
        return accessToken.getCode();
    }

    /**
     * Generates a 6-digit random access token valid for 7 days.
     * @param container The container to be associated with the token.
     * @return A new AccessToken instance.
     */
    private AccessToken generateAccessToken(Container container) {
        String code = String.format("%6d", random.nextInt(1000000));
        long expiryTime = System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000);
        return new AccessToken(code, expiryTime, container);
    }

    /**
     * Facilitates package pickup using a valid access code.
     * @param code The access code provided at the time of deposit.
     */
    void pickUp(String code) {
        // check access code
        //check code -> open locker -> take package -> markfree -> close
        if (code == null || code.isEmpty()) {
            throw new RuntimeException("Invalid access token code");
        }
        if (!accessTokenMap.containsKey(code)) {
            System.err.println("Invalid access code");
            return;
        }
        AccessToken token = accessTokenMap.get(code);
        if (token.isExpire()) {
            System.err.println("Access token expired");
            throw new RuntimeException("Expired access token code");
        }
        Container container = token.getContainer();
        container.open();
        clearDeposit(token);
    }

    /**
     * Cleans up the container state and removes the token after a successful pickup.
     * @param token The token used for pickup.
     */
    private void clearDeposit(AccessToken token) {
        //take money -> give package -> mark as free
        token.getContainer().close();
        token.getContainer().markFree();
        accessTokenMap.remove(token.getCode());
    }

    /**
     * Iterates through all active tokens and frees containers that have exceeded their expiry time.
     */
    void openExpiredContainer() {
        //open all expired Container
        // open all contianer -> check expired time -> make it available -> close
        for(AccessToken token : accessTokenMap.values()){
            if(token.isExpire()){
                Container container = token.getContainer();
                container.open();
                container.markFree();
                container.close();
            }
        }
    }

    /**
     * Finds the first available container matching the requested size.
     * @param size The desired ContainerSize.
     * @return An available Container or null if none match.
     */
    private Container getAvailableContainer(ContainerSize size) {
        for (Container container : containers) {
            if (container.getSize() == size && container.getStatus() == Status.IS_AVAILABLE) {
                return container;
            }
        }
        return null;
    }

}
