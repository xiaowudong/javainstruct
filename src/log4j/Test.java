package log4j;


import org.apache.log4j.Logger;

public class Test {
	static Logger logger = Logger.getLogger(Test.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.debug("debugger");
		logger.info("info");
		logger.warn("warn");
		logger.error("err");
		logger.fatal("fatal");
	}

}
