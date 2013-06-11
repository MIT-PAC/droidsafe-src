package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.apache.http.util.ExceptionUtils;

public class HttpException extends Exception {
    private static final long serialVersionUID = -5437299376222011036L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.018 -0400", hash_original_method = "CE1042B423C0576E9C85D621B7EA3FF6", hash_generated_method = "F8DC01E7793318AF7775A1B310184381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.018 -0400", hash_original_method = "999797B071E81E9F9DCCEA8ACDA6E65E", hash_generated_method = "951C14F1D9EDE652B10271AD647076F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpException(final String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.018 -0400", hash_original_method = "6034895F301B6A7B932D0B171C9F2AB8", hash_generated_method = "D3275DC4046DC435F0FCEC104A54A520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpException(final String message, final Throwable cause) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        ExceptionUtils.initCause(this, cause);
        // ---------- Original Method ----------
        //ExceptionUtils.initCause(this, cause);
    }

    
}


