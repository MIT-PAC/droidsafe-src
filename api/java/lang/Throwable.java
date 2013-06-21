package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Throwable implements java.io.Serializable {
	
	public String getMessage() {
        return getTaintString();
    }
	
	@DSModeled(DSC.SAFE)
	public Throwable() {
		//Class into native methods to fill in the stack state (see below)s
        //fillInStackTrace();
    }
	
	/*
	public Throwable fillInStackTrace() {
        // Fill in the intermediate representation
        stackState = nativeFillInStackTrace();
        // Mark the full representation as empty
        stackTrace = null;
        return this;
    }
    */
	
	@DSModeled(DSC.SAFE)
	public Throwable(String detailMessage) {
        this();
        addTaint(detailMessage);
        //this.detailMessage = detailMessage;
    }
	
	@DSModeled(DSC.SAFE)
	public Throwable(String detailMessage, Throwable throwable) {
        this();
        addTaint(detailMessage);
        addTaint(throwable.getMessage());
        //this.detailMessage = detailMessage;
        //cause = throwable;
    }
}
