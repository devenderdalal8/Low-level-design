package Logger.Base;

public abstract class Logger {
    public int level;
    public Logger nextLogger;

    public Logger(int level) {
        this.level = level;
    }

    public Logger setNext(Logger logger) {
        this.nextLogger = logger;
        return logger;
    }

    protected abstract void write(String message);

    public void log(Level level, String message) {
        if (this.level <= level.getLevel()) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.log(level, message);
        }
    }

}
