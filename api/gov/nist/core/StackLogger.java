package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Properties;

public interface StackLogger extends LogLevels {

    
	public void logStackTrace();
	
	
	public void logStackTrace(int traceLevel);
	
	
	public int getLineCount();
	
	
    public void logException(Throwable ex);
    
    public void logDebug(String message);
    
    public void logTrace(String message);
    
    public void logFatalError(String message);
    
    public void logError(String message);
    
    public boolean isLoggingEnabled();
    
    public boolean isLoggingEnabled(int logLevel);
    
    public void logError(String message, Exception ex);
    
    public void logWarning(String string);
    
    public void logInfo(String string);
    
   
    
    public void disableLogging();

    
    public void enableLogging();
    
    
    public void setBuildTimeStamp(String buildTimeStamp);
    
    
    
    public void setStackProperties(Properties stackProperties);
    
    
    public String getLoggerName();
    
    
   
}
