package ssxlog4j;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLog4j {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TestLog4j.class.getName());
        logger.setLevel(Level.INFO);

        logger.info("info1111");
        logger.warning("waring");
    }
}
