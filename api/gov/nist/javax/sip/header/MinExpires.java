package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.*;
import javax.sip.header.*;

public class MinExpires extends SIPHeader implements MinExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.604 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.605 -0400", hash_original_method = "E220E899B716906991999B2A4C081552", hash_generated_method = "CD25F29B29CDBECA1004AA69954293B5")
    public  MinExpires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.607 -0400", hash_original_method = "D42EEF06048E7D77F00EA781D2005D33", hash_generated_method = "31A1ED42966656B7C08255F420F0F061")
    public String encodeBody() {
String varBE908F9C17F4396AECDF00850C15BBA8_1929881859 =         Integer.toString(expires);
        varBE908F9C17F4396AECDF00850C15BBA8_1929881859.addTaint(taint);
        return varBE908F9C17F4396AECDF00850C15BBA8_1929881859;
        // ---------- Original Method ----------
        //return Integer.toString(expires);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.608 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "9AC194B4CD541C1284F40CEEC2451EBD")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_1236228943 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886499503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886499503;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.609 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "1FB11C66178F3E3C2EDAB16340C8FA5C")
    public void setExpires(int expires) throws InvalidArgumentException {
    if(expires < 0)        
        {
        InvalidArgumentException var0A30DEF68A266FAAF2201026044A20DF_1409976592 = new InvalidArgumentException("bad argument " + expires);
        var0A30DEF68A266FAAF2201026044A20DF_1409976592.addTaint(taint);
        throw var0A30DEF68A266FAAF2201026044A20DF_1409976592;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.609 -0400", hash_original_field = "D2AF3D0B8A0546A777A14BAF32F484A1", hash_generated_field = "54DFFD072C6FF45C93B222EE008E242A")

    private static final long serialVersionUID = 7001828209606095801L;
}

