package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;


public class RuntimeException extends Exception {
	@DSModeled(DSC.SAFE)
	public RuntimeException(String detailMessage) {
        super(detailMessage);
    }
	
	@DSModeled(DSC.SAFE)
	public RuntimeException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
