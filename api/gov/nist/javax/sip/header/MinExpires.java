package gov.nist.javax.sip.header;

// Droidsafe Imports
import javax.sip.InvalidArgumentException;
import javax.sip.header.MinExpiresHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MinExpires extends SIPHeader implements MinExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.585 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.586 -0400", hash_original_method = "E220E899B716906991999B2A4C081552", hash_generated_method = "CD25F29B29CDBECA1004AA69954293B5")
    public  MinExpires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.586 -0400", hash_original_method = "D42EEF06048E7D77F00EA781D2005D33", hash_generated_method = "01D8FEFD1D287B519E2E8A6ABA0D9D31")
    public String encodeBody() {
String varBE908F9C17F4396AECDF00850C15BBA8_134594105 =         Integer.toString(expires);
        varBE908F9C17F4396AECDF00850C15BBA8_134594105.addTaint(taint);
        return varBE908F9C17F4396AECDF00850C15BBA8_134594105;
        // ---------- Original Method ----------
        //return Integer.toString(expires);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.586 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "06A47787585AFB1E55BCF49030B940C9")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_861993077 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353041470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353041470;
        // ---------- Original Method ----------
        //return expires;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.587 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "55314AA4CC469A9D9D9DA5206D3DFD2C")
    public void setExpires(int expires) throws InvalidArgumentException {
        if(expires < 0)        
        {
        InvalidArgumentException var0A30DEF68A266FAAF2201026044A20DF_2145416563 = new InvalidArgumentException("bad argument " + expires);
        var0A30DEF68A266FAAF2201026044A20DF_2145416563.addTaint(taint);
        throw var0A30DEF68A266FAAF2201026044A20DF_2145416563;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.587 -0400", hash_original_field = "D2AF3D0B8A0546A777A14BAF32F484A1", hash_generated_field = "54DFFD072C6FF45C93B222EE008E242A")

    private static final long serialVersionUID = 7001828209606095801L;
}

