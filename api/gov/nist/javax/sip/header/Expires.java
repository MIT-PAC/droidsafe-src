package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.*;

public class Expires extends SIPHeader implements javax.sip.header.ExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.370 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.370 -0400", hash_original_method = "0542B72E4A4F7744BB9DEA78B33603A7", hash_generated_method = "2BE5D43F7C2297EF5B98693F09A128A4")
    public  Expires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.370 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "F837986475421916D7DB3B6295FADDBF")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_633136069 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_633136069.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_633136069;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.370 -0400", hash_original_method = "D18BC4E3774CF43CFCD5002AEFE6A6EE", hash_generated_method = "1018F9DBCDFE5D74CB49A838FC4355E0")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer var2D4C6DA37C2038198A6258A0D8515114_1119038708 =         buffer.append(expires);
        var2D4C6DA37C2038198A6258A0D8515114_1119038708.addTaint(taint);
        return var2D4C6DA37C2038198A6258A0D8515114_1119038708;
        // ---------- Original Method ----------
        //return buffer.append(expires);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.371 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "3406A3A3B48CAF03E1828896ACD42252")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_261892979 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011546870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011546870;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.371 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "BE649DFC153417A006EEF4B33FF63CED")
    public void setExpires(int expires) throws InvalidArgumentException {
    if(expires < 0)        
        {
        InvalidArgumentException var0A30DEF68A266FAAF2201026044A20DF_1039206807 = new InvalidArgumentException("bad argument " + expires);
        var0A30DEF68A266FAAF2201026044A20DF_1039206807.addTaint(taint);
        throw var0A30DEF68A266FAAF2201026044A20DF_1039206807;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.371 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
}

