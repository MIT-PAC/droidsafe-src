package java.lang;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class Exception extends Throwable {
	@DSModeled(DSC.SAFE)
	public Exception() {
    }
	
	@DSModeled(DSC.SAFE)
	public Exception(String detailMessage) {
        super(detailMessage);
    }
	
	@DSModeled(DSC.SAFE)
	public Exception(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
