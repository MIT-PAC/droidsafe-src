package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class TransformerFactoryConfigurationError extends Error {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.080 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.080 -0400", hash_original_method = "B5236C2B50936EBB19164E0470E786D0", hash_generated_method = "4FA1D40EBB8466CB6249FD2FE24764E4")
    public  TransformerFactoryConfigurationError() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.081 -0400", hash_original_method = "A106770FA0B10D144DFE1AE3A1F6A82D", hash_generated_method = "84BFA6ECB6E9329CC583EC0220DE413A")
    public  TransformerFactoryConfigurationError(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.082 -0400", hash_original_method = "F49E93B07FF8266081C24B5E6A3F5360", hash_generated_method = "3A733ED36B8D74FA3EFA3777A0AFBF3A")
    public  TransformerFactoryConfigurationError(Exception e) {
        super(e.toString());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.082 -0400", hash_original_method = "1312292D5A501DBED2FE9598863C16EA", hash_generated_method = "3AA0EC502B73CBFEE0670605213B9CDB")
    public  TransformerFactoryConfigurationError(Exception e, String msg) {
        super(msg);
        addTaint(msg.getTaint());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.083 -0400", hash_original_method = "87F4B9D5A318C1C88AAC3D2F1A6663D7", hash_generated_method = "A777AC980A034F793368FB3221427C84")
    public String getMessage() {
        String message = super.getMessage();
    if((message == null) && (exception != null))        
        {
String var56A9A9C4DE0617B8FC85BA86A88F5292_1097530725 =             exception.getMessage();
            var56A9A9C4DE0617B8FC85BA86A88F5292_1097530725.addTaint(taint);
            return var56A9A9C4DE0617B8FC85BA86A88F5292_1097530725;
        } //End block
String varFD182D7074F3848E773A38B067BBB880_357021919 =         message;
        varFD182D7074F3848E773A38B067BBB880_357021919.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_357021919;
        // ---------- Original Method ----------
        //String message = super.getMessage();
        //if ((message == null) && (exception != null)) {
            //return exception.getMessage();
        //}
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.083 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "FCC4CBAA80A02950527E83B03A6EBE10")
    public Exception getException() {
Exception varB0A8CAD4B1C89FFC19A72F5757E92C21_1430152313 =         exception;
        varB0A8CAD4B1C89FFC19A72F5757E92C21_1430152313.addTaint(taint);
        return varB0A8CAD4B1C89FFC19A72F5757E92C21_1430152313;
        // ---------- Original Method ----------
        //return exception;
    }

    
}

