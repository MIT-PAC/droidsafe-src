package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class IllegalArgumentException extends RuntimeException {
    
    @DSModeled(DSC.SAFE)
    public  IllegalArgumentException() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public  IllegalArgumentException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    public  IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    public  IllegalArgumentException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        addTaint(cause.getTaint());
        
    }

    
    private static final long serialVersionUID = -5365630128856068164L;
}

