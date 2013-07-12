package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.UnknownHostException;
import libcore.io.OsConstants;

public final class GaiException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.584 -0400", hash_original_field = "18B5CA8CBD35BC4F1D1B026A63E1062E", hash_generated_field = "3A7419DC5D02B665865D1D41C31D2769")

    private String functionName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.585 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "BB4B5831C4D0D33F468CF74A7B49F52F")

    public int error;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.585 -0400", hash_original_method = "BA53EB307FD31FC241DD4C6044D04AD1", hash_generated_method = "E8AF62B805AA6C835F1A36515273810B")
    public  GaiException(String functionName, int error) {
        this.functionName = functionName;
        this.error = error;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.586 -0400", hash_original_method = "845DC588FB53DD48B2B7818DC3F43C36", hash_generated_method = "5105B9C32E595851BB1A8B27DCDF6C46")
    public  GaiException(String functionName, int error, Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        this.functionName = functionName;
        this.error = error;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.586 -0400", hash_original_method = "6B923BF9D17AE00E606BE15037C1D30D", hash_generated_method = "5F010F15FB3DEA3FF61F8B1471549320")
    @Override
    public String getMessage() {
        String gaiName = OsConstants.gaiName(error);
    if(gaiName == null)        
        {
            gaiName = "GAI_ error " + error;
        } 
        String description = Libcore.os.gai_strerror(error);
String var701BE8BF919F58E6C9A5E8912E1F0ED7_1425765131 =         functionName + " failed: " + gaiName + " (" + description + ")";
        var701BE8BF919F58E6C9A5E8912E1F0ED7_1425765131.addTaint(taint);
        return var701BE8BF919F58E6C9A5E8912E1F0ED7_1425765131;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.587 -0400", hash_original_method = "5B589888D552552C8BEA12CEE384825F", hash_generated_method = "69E64AF536E7E9C1F97746E4595E030C")
    public UnknownHostException rethrowAsUnknownHostException(String detailMessage) throws UnknownHostException {
        addTaint(detailMessage.getTaint());
        UnknownHostException newException = new UnknownHostException(detailMessage);
        newException.initCause(this);
        newException.addTaint(taint);
        throw newException;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.589 -0400", hash_original_method = "81B83C8D72DB912D679B4B84F9977C22", hash_generated_method = "8A54E541A56524DBD6034352A06D678E")
    public UnknownHostException rethrowAsUnknownHostException() throws UnknownHostException {
        java.net.UnknownHostException var5F7B19AF1BB87D36470BEC0E68B99E1A_1500317859 = rethrowAsUnknownHostException(getMessage());
        var5F7B19AF1BB87D36470BEC0E68B99E1A_1500317859.addTaint(taint);
        throw var5F7B19AF1BB87D36470BEC0E68B99E1A_1500317859;
        
        
    }

    
}

