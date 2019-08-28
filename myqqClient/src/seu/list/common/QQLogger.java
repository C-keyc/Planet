package seu.list.common;

import java.util.logging.Level;
import java.util.logging.Logger;

public class QQLogger {
	private static Logger logger = null;
	public static Logger clientLogger() {
		if (logger == null) {
			logger = Logger.getLogger("qqClient");
			logger.setLevel(Level.INFO);
		}
		return logger;		 
	}
	public static Logger serverLogger() {
		if (logger == null) {
			logger = Logger.getLogger("qqServer");
			logger.setLevel(Level.INFO);
		}
		return logger;		 
	}
}
