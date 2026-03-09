package Logger.Logger;

import Logger.Base.Logger;

public class InfoLogger extends Logger {
    private static int level = 2;

    public InfoLogger() {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Info: " + message);
    }

}
