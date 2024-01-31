// Logger interface
interface Logger {
    void logMessage(LogLevel level, String message);
}

// Enum representing log levels
enum LogLevel {
    INFO,
    DEBUG,
    WARNING,
    ERROR
}

// Concrete logger handler
class ConsoleLogger implements Logger {
    private LogLevel logLevel;

    public ConsoleLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void logMessage(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            System.out.println("Console Logger - " + level + ": " + message);
        }
    }
}

// Concrete logger handler
class FileLogger implements Logger {
    private LogLevel logLevel;

    public FileLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void logMessage(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            System.out.println("File Logger - " + level + ": " + message);
        }
    }
}

// Logger chain of responsibility
class LoggerChain {
    private Logger chain;

    public LoggerChain() {
        buildChain();
    }

    private void buildChain() {
        Logger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        Logger fileLogger =
