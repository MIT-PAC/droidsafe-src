package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

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
