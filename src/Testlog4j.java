import org.apache.log4j.Logger;


public class Testlog4j {
	static Logger logger = Logger.getLogger(Testlog4j.class); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		logger.debug("System бн..");
//		logger.info("System бн..");
		logger.debug("debugger");
		logger.info("info");
		logger.warn("warn");
		logger.error("err");
		logger.fatal("fatal");
	}

}
