package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public final class AllowEvents extends SIPHeader implements javax.sip.header.AllowEventsHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.742 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.742 -0400", hash_original_method = "B300CC10915D88E488A895EA20EE2A09", hash_generated_method = "60A08C0FBE41C8160995AE7F013B9128")
    public  AllowEvents() {
        super(ALLOW_EVENTS);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.743 -0400", hash_original_method = "5D2656FB66C7C3040E5BEE12ACA7E341", hash_generated_method = "614CF3514F02380A9D78B1E9692E01B2")
    public  AllowEvents(String m) {
        super(ALLOW_EVENTS);
        eventType = m;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.743 -0400", hash_original_method = "A10AD710FF1C0BA35C48E4F204BD5CD1", hash_generated_method = "2E3876A46F8B418287F86E920C6DF270")
    public void setEventType(String eventType) throws ParseException {
    if(eventType == null)        
        {
        NullPointerException var287700AFB79AFA8D99AB46CD9FB31442_114044294 = new NullPointerException(
                "JAIN-SIP Exception,"
                    + "AllowEvents, setEventType(), the eventType parameter is null");
        var287700AFB79AFA8D99AB46CD9FB31442_114044294.addTaint(taint);
        throw var287700AFB79AFA8D99AB46CD9FB31442_114044294;
        }
        this.eventType = eventType;
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.744 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "8FB4FCFFEDE795E35FFF94841823EFCC")
    public String getEventType() {
String var9BA45280620AE5369B32F31629C1D3A0_25016783 =         eventType;
        var9BA45280620AE5369B32F31629C1D3A0_25016783.addTaint(taint);
        return var9BA45280620AE5369B32F31629C1D3A0_25016783;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.744 -0400", hash_original_method = "895FBB9B6BA00626F6F635DDC47F48B7", hash_generated_method = "A57A5724EEFA89602137DCE4689E80C6")
    protected String encodeBody() {
String var9BA45280620AE5369B32F31629C1D3A0_2007097555 =         eventType;
        var9BA45280620AE5369B32F31629C1D3A0_2007097555.addTaint(taint);
        return var9BA45280620AE5369B32F31629C1D3A0_2007097555;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.744 -0400", hash_original_field = "D26554E56E6998210017FC87B96E228A", hash_generated_field = "AC25BA32AE0E1E6630D2239F784D525D")

    private static final long serialVersionUID = 617962431813193114L;
}

