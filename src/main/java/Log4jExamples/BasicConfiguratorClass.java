package Log4jExamples;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicConfiguratorClass {

    static Logger logger = Logger.getLogger(BasicConfigurator.class); // Factory design pattern
    public static void main(String[] args) {

        BasicConfigurator.configure();
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

    }
}
