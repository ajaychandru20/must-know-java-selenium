package Log4jExamples;

import org.apache.log4j.Logger;

public class PropertyFileConfigClass {

    static Logger logger = Logger.getLogger(PropertyFileConfigClass.class);

    public static void main(String[] args) {

            logger.info("This is info logger");
            logger.debug("This is debugger logger");
            logger.warn("This is warn logger");
            logger.error("This is error logger");
            logger.fatal("This is fatel logger");
    }

}
