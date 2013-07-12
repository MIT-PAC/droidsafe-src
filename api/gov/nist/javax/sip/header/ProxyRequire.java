package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;

public class ProxyRequire extends SIPHeader implements ProxyRequireHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.745 -0400", hash_original_field = "7215DE10AF39CFD62967156F13524AEE", hash_generated_field = "EA9E843EF6C95A0999AD8B5523E0E7B3")

    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.745 -0400", hash_original_method = "313262BBE47BF259092F8848A4D13338", hash_generated_method = "8A94E0C1BEC1D37D30D767A123DE1038")
    public  ProxyRequire() {
        super(PROXY_REQUIRE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.745 -0400", hash_original_method = "3BC392B937FA3D9900D8752B431D0DD9", hash_generated_method = "F3EFD4D914FF90D265B07632E0366FF6")
    public  ProxyRequire(String s) {
        super(PROXY_REQUIRE);
        optionTag = s;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.746 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "13D199B500AE8AD90EE291792B358D97")
    public String encodeBody() {
String var05FAD6E650FDF64778D62F7CDA67F749_989902278 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_989902278.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_989902278;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.746 -0400", hash_original_method = "DE0D7BEB729218B451469620CB6256C4", hash_generated_method = "6EE4FBC4D3D96EC0E776A3841E0CCE48")
    public void setOptionTag(String optionTag) throws ParseException {
    if(optionTag == null)        
        {
        NullPointerException var00B4EC6108EE40C7D058C430CB5F37BA_348582856 = new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        var00B4EC6108EE40C7D058C430CB5F37BA_348582856.addTaint(taint);
        throw var00B4EC6108EE40C7D058C430CB5F37BA_348582856;
        }
        this.optionTag = optionTag;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.746 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "8FEA6E5A33BC25E87ACB41669F55C761")
    public String getOptionTag() {
String var05FAD6E650FDF64778D62F7CDA67F749_1051343040 =         optionTag;
        var05FAD6E650FDF64778D62F7CDA67F749_1051343040.addTaint(taint);
        return var05FAD6E650FDF64778D62F7CDA67F749_1051343040;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.747 -0400", hash_original_field = "975F50328F4FE764CD0D0C999A356DC0", hash_generated_field = "EA994B24C6A518D84FF4C741C559C547")

    private static final long serialVersionUID = -3269274234851067893L;
}

