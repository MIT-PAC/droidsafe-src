package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;

public class PMediaAuthorization extends SIPHeader implements PMediaAuthorizationHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.270 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "630027C1E843254DD22AA3F89157CD43")

    private String token;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.270 -0400", hash_original_method = "33816D631C77F21B21E54BBEFDA2795C", hash_generated_method = "1DDFAEE2CC3B34FAA95C12E411F347A6")
    public  PMediaAuthorization() {
        super(P_MEDIA_AUTHORIZATION);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.271 -0400", hash_original_method = "F23C2C2B4085CBC596D4F9DFFD38C718", hash_generated_method = "2342D29FB71D27661C16920ABD8AC88C")
    public String getToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_26945723 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_26945723 = token;
        varB4EAC82CA7396A68D541C85D26508E83_26945723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_26945723;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.271 -0400", hash_original_method = "0F12B8FB487852A4D61415942AC9447A", hash_generated_method = "1560A83FB4076EB5082342936751D47A")
    public void setMediaAuthorizationToken(String token) throws InvalidArgumentException {
        {
            boolean var0BBA6FD42C5738A08365C8D887AF0F63_1380213254 = (token == null || token.length() == 0);
            if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        } //End collapsed parenthetic
        this.token = token;
        // ---------- Original Method ----------
        //if (token == null || token.length() == 0)
            //throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        //this.token = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.272 -0400", hash_original_method = "724D317C37CE304AAB82EB39D5595B30", hash_generated_method = "61837CCDE1E7098CE7BCDFD5D98CAAC7")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1929099580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1929099580 = token;
        varB4EAC82CA7396A68D541C85D26508E83_1929099580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929099580;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.284 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.284 -0400", hash_original_method = "5CA94E0EC768C322B947B50479A5582B", hash_generated_method = "CDDFD8DAC95290821C60E0CF7B81ACA0")
    public boolean equals(Object other) {
        {
            PMediaAuthorizationHeader o;
            o = (PMediaAuthorizationHeader) other;
            boolean var055F3006672A34EB761F0ABF2C2D3D0C_170650933 = (this.getToken().equals(o.getToken()));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452360425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452360425;
        // ---------- Original Method ----------
        //if (other instanceof PMediaAuthorizationHeader)
        //{
            //final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            //return this.getToken().equals(o.getToken());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.290 -0400", hash_original_method = "8A557E19577FD47CE8C49FDC6C46D11C", hash_generated_method = "095A2A7C03ED4105284DF0B167A09CD6")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1072702736 = null; //Variable for return #1
        PMediaAuthorization retval;
        retval = (PMediaAuthorization) super.clone();
        retval.token = this.token;
        varB4EAC82CA7396A68D541C85D26508E83_1072702736 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1072702736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1072702736;
        // ---------- Original Method ----------
        //PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        //if (this.token != null)
            //retval.token = this.token;
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.290 -0400", hash_original_field = "9DA309663EC39F7889D490CF1B81FFF2", hash_generated_field = "4B15F4D7F5E3B992BC2BBD1847974234")

    private static long serialVersionUID = -6463630258703731133L;
}

