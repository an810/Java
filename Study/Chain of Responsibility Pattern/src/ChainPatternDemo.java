public class ChainPatternDemo {
    private static AbstractLogger getChainofLoggers(){

        AbstractLogger errorLogger = new ErrrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainofLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information");
    }
}
