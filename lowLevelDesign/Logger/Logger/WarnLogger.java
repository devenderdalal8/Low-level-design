package Logger.Logger;

public class WarnLogger extends Logger.Base.Logger {
    private static int level = 3;

    public WarnLogger() {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Warn: " + message);
    }
}
