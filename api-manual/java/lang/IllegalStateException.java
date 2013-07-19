package java.lang;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
public class IllegalStateException extends RuntimeException {
    private static final long serialVersionUID = -1848914673093119416L;
    
	@DSModeled(DSC.SAFE)
    public IllegalStateException() {
	    super();
    }

	@DSModeled(DSC.SPEC)
    public IllegalStateException(String detailMessage) {
        super(detailMessage);
    }
	@DSModeled(DSC.SPEC)
    public IllegalStateException(String message, Throwable cause) {
        super(message, cause);
    }
	
	@DSModeled(DSC.SAFE)
    public IllegalStateException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
    }
}
