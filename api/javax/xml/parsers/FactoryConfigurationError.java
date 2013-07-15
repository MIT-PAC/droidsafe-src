package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class FactoryConfigurationError extends Error {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.449 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.449 -0400", hash_original_method = "6620C9D65D7B9B8AED04F1E2286BE37D", hash_generated_method = "3197EEE679B539DCD98F16DC71478ECF")
    public  FactoryConfigurationError() {
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.449 -0400", hash_original_method = "48F1E682C4A714972A38A39D612B5275", hash_generated_method = "BA7E26A4B501BE659DD2B1554937B270")
    public  FactoryConfigurationError(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        this.exception = null;
        // ---------- Original Method ----------
        //this.exception = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.450 -0400", hash_original_method = "50F0E936640865FC69642EB9E9B7DACD", hash_generated_method = "DECEA99A83213F9667E844B2E4FA90A5")
    public  FactoryConfigurationError(Exception e) {
        super(e.toString());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.450 -0400", hash_original_method = "6DA0E2DE853AFE92CEEE23D7625EA5CB", hash_generated_method = "657D61BA3640D975C04CF28B971A83F3")
    public  FactoryConfigurationError(Exception e, String msg) {
        super(msg);
        addTaint(msg.getTaint());
        this.exception = e;
        // ---------- Original Method ----------
        //this.exception = e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.451 -0400", hash_original_method = "3CFCD04CF304E9364ADFC7DBDB377B80", hash_generated_method = "D9827DE94C7D2E14574310EEF5F8A956")
    public String getMessage() {
        String message = super.getMessage ();
    if(message == null && exception != null)        
        {
String var56A9A9C4DE0617B8FC85BA86A88F5292_1649808506 =             exception.getMessage();
            var56A9A9C4DE0617B8FC85BA86A88F5292_1649808506.addTaint(taint);
            return var56A9A9C4DE0617B8FC85BA86A88F5292_1649808506;
        } //End block
String varFD182D7074F3848E773A38B067BBB880_1135176042 =         message;
        varFD182D7074F3848E773A38B067BBB880_1135176042.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_1135176042;
        // ---------- Original Method ----------
        //String message = super.getMessage ();
        //if (message == null && exception != null) {
            //return exception.getMessage();
        //}
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.451 -0400", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "CEEC7A77742B2BAF047C765C39AAFD82")
    public Exception getException() {
Exception varB0A8CAD4B1C89FFC19A72F5757E92C21_964972947 =         exception;
        varB0A8CAD4B1C89FFC19A72F5757E92C21_964972947.addTaint(taint);
        return varB0A8CAD4B1C89FFC19A72F5757E92C21_964972947;
        // ---------- Original Method ----------
        //return exception;
    }

    
}

