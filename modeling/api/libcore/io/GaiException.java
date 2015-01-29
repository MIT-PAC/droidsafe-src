package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.UnknownHostException;

public final class GaiException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.496 -0500", hash_original_field = "4E55026DE98CFA86DA317EEAE8A270FB", hash_generated_field = "3A7419DC5D02B665865D1D41C31D2769")

    private  String functionName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.498 -0500", hash_original_field = "8D5B8432C9E461718BA68901CB1951D3", hash_generated_field = "BB4B5831C4D0D33F468CF74A7B49F52F")

    public  int error;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.500 -0500", hash_original_method = "BA53EB307FD31FC241DD4C6044D04AD1", hash_generated_method = "ADCA2525BC8011653F669987686C1184")
    
public GaiException(String functionName, int error) {
        this.functionName = functionName;
        this.error = error;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.503 -0500", hash_original_method = "845DC588FB53DD48B2B7818DC3F43C36", hash_generated_method = "7215DDFBEAF5D8F4348C63619FEE8316")
    
public GaiException(String functionName, int error, Throwable cause) {
        super(cause);
        this.functionName = functionName;
        this.error = error;
    }

    /**
     * Converts the stashed function name and error value to a human-readable string.
     * We do this here rather than in the constructor so that callers only pay for
     * this if they need it.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.505 -0500", hash_original_method = "6B923BF9D17AE00E606BE15037C1D30D", hash_generated_method = "A242F936DA6CF917011C6A1A869A0BDF")
    
@Override public String getMessage() {
        String gaiName = OsConstants.gaiName(error);
        if (gaiName == null) {
            gaiName = "GAI_ error " + error;
        }
        String description = Libcore.os.gai_strerror(error);
        return functionName + " failed: " + gaiName + " (" + description + ")";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.508 -0500", hash_original_method = "5B589888D552552C8BEA12CEE384825F", hash_generated_method = "E455F61100C451C637015DD3A5BC34CA")
    
public UnknownHostException rethrowAsUnknownHostException(String detailMessage) throws UnknownHostException {
        UnknownHostException newException = new UnknownHostException(detailMessage);
        newException.initCause(this);
        throw newException;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.510 -0500", hash_original_method = "81B83C8D72DB912D679B4B84F9977C22", hash_generated_method = "39620885A1861BF89E9872FB2E54F3CC")
    
public UnknownHostException rethrowAsUnknownHostException() throws UnknownHostException {
        throw rethrowAsUnknownHostException(getMessage());
    }
    
}

