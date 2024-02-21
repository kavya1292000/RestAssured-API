package testHTTPmethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
public class Log4J2Demo {
	 Logger logger =  LogManager.getLogger(Log4J2Demo.class);
		
		
		
		@Test
		public void loggingmethod()
		{
			logger.trace("This is a Trace Log");
			
			logger.debug("This is to print an event execution");
			
			int a = 10;
			int b = 20;
			int sum = a+b;
			
			logger.error(" This log comes on error");
			
			
			logger.info("To print any information");
			
			logger.fatal("major issues has occured");
			
			logger.warn("error Warning");
			
			System.out.println(sum);
			
		}
	










}
