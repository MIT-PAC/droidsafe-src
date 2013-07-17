package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;

public class ProxyRequire extends SIPHeader implements ProxyRequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.756 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.757 -0400", hash_original_method = "313262BBE47BF259092F8848A4D13338", hash_generated_method = "8A94E0C1BEC1D37D30D767A123DE1038")
    public  ProxyRequire() {
        super(PROXY_REQUIRE);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.757 -0400", hash_original_method = "3BC392B937FA3D9900D8752B431D0DD9", hash_generated_method = "F3EFD4D914FF90D265B07632E0366FF6")
    public  ProxyRequire(String s) {
        super(PROXY_REQUIRE);
        optionTag = s;
        // ---------- Original Method ----------
        //optionTag = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.757 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "134E037903120FD19B71C855FE3F688F")
    public String encodeBody() {
String var05FAD6E650FDF64778D62F7CDA67F749_917480371 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_917480371.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_917480371;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.758 -0400", hash_original_method = "DE0D7BEB729218B451469620CB6256C4", hash_generated_method = "DCD8A8A3334A8B7CEF8917D772AB627B")
    public void setOptionTag(String optionTag) throws ParseException {
        if(optionTag == null)        
        {
        NullPointerException var00B4EC6108EE40C7D058C430CB5F37BA_28937334 = new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        var00B4EC6108EE40C7D058C430CB5F37BA_28937334.addTaint(taint);
        throw var00B4EC6108EE40C7D058C430CB5F37BA_28937334;
        }
        this.optionTag = optionTag;
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.758 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "D076420083176096E22D318B36D73468")
    public String getOptionTag() {
String var05FAD6E650FDF64778D62F7CDA67F749_505007218 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_505007218.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_505007218;
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.758 -0400", hash_original_field = "975F50328F4FE764CD0D0C999A356DC0", hash_generated_field = "EA994B24C6A518D84FF4C741C559C547")

    private static final long serialVersionUID = -3269274234851067893L;
}

