package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;






public class Expires extends SIPHeader implements javax.sip.header.ExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.365 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.365 -0400", hash_original_method = "0542B72E4A4F7744BB9DEA78B33603A7", hash_generated_method = "2BE5D43F7C2297EF5B98693F09A128A4")
    public  Expires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.366 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "A6352615545BB6BB1A6EB488172FD033")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1055431860 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1055431860.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1055431860;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.366 -0400", hash_original_method = "D18BC4E3774CF43CFCD5002AEFE6A6EE", hash_generated_method = "CF575238BD6100C41B170896A0EAD282")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer var2D4C6DA37C2038198A6258A0D8515114_91034604 =         buffer.append(expires);
        var2D4C6DA37C2038198A6258A0D8515114_91034604.addTaint(taint);
        return var2D4C6DA37C2038198A6258A0D8515114_91034604;
        // ---------- Original Method ----------
        //return buffer.append(expires);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.366 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "311763E590A8F829F7390AB14447F791")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_1674770392 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357026416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_357026416;
        // ---------- Original Method ----------
        //return expires;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.367 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "E0A061F5674C7F65A40A3B8CDCFC680B")
    public void setExpires(int expires) throws InvalidArgumentException {
        if(expires < 0)        
        {
        InvalidArgumentException var0A30DEF68A266FAAF2201026044A20DF_159104220 = new InvalidArgumentException("bad argument " + expires);
        var0A30DEF68A266FAAF2201026044A20DF_159104220.addTaint(taint);
        throw var0A30DEF68A266FAAF2201026044A20DF_159104220;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.367 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
}

