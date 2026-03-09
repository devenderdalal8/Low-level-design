package Logger.Logger;

import Logger.Base.Logger;

public class DebugLogger extends Logger {
    private static int level = 1;

    public DebugLogger() {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug: " + message);
    }
}
