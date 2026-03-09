package Logger;

import Logger.Base.Level;
import Logger.Base.Logger;
import Logger.Logger.ErrorLogger;
import Logger.Logger.InfoLogger;
import Logger.Logger.WarnLogger;
import Logger.Logger.DebugLogger;

public class Main {
    private static Logger buildChain() {
        Logger debug = new DebugLogger();
        Logger info  = new InfoLogger();
        Logger warn  = new WarnLogger();
        Logger error = new ErrorLogger();

        // Chain: DEBUG → INFO → WARN → ERROR
        debug.setNext(info)
             .setNext(warn)
             .setNext(error);

        return debug; // head of chain
    }

    public static void main(String[] args) {
        Logger logger = buildChain();

        System.out.println("--- Logging DEBUG ---");
        logger.log(Level.Debug, "Entering method calculateTotal()");

        System.out.println("\n--- Logging INFO ---");
        logger.log(Level.Info, "User 'alice' logged in successfully");

        System.out.println("\n--- Logging WARN ---");
        logger.log(Level.Warning, "Disk usage above 80%");

        System.out.println("\n--- Logging ERROR ---");
        logger.log(Level.Error, "Database connection failed!");
    }
}
