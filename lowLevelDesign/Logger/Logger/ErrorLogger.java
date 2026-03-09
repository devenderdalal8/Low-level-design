package Logger.Logger;

public class ErrorLogger extends Logger.Base.Logger {

    private static int level = 4;

    public ErrorLogger() {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error: " + message);
    }
    
}
