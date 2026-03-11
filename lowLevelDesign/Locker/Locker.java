package Locker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Locker {
    List<Container> containers;
    Map<String, AccessToken> accessTokenMap;
    private Random random;

    Locker(List<Container> containers) {
        this.containers = containers;
        accessTokenMap = new HashMap<String, AccessToken>();
        random = new Random();
    }

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

    private AccessToken generateAccessToken(Container container) {
        String code = String.format("%6d", random.nextInt(1000000));
        long expiryTime = System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000);
        return new AccessToken(code, expiryTime, container);
    }

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

    private void clearDeposit(AccessToken token) {
        //take money -> give package -> mark as free
        token.getContainer().close();
        token.getContainer().markFree();
        accessTokenMap.remove(token.getCode());
    }

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

    private Container getAvailableContainer(ContainerSize size) {
        for (Container container : containers) {
            if (container.getSize() == size && container.getStatus() == Status.IS_AVAILABLE) {
                return container;
            }
        }
        return null;
    }

}
