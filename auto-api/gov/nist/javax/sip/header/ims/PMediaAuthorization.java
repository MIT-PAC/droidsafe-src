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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.423 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "630027C1E843254DD22AA3F89157CD43")

    private String token;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.423 -0400", hash_original_method = "33816D631C77F21B21E54BBEFDA2795C", hash_generated_method = "1DDFAEE2CC3B34FAA95C12E411F347A6")
    public  PMediaAuthorization() {
        super(P_MEDIA_AUTHORIZATION);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.425 -0400", hash_original_method = "F23C2C2B4085CBC596D4F9DFFD38C718", hash_generated_method = "4A1DB5025CCA509BDA3CE998D27BAD23")
    public String getToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1117036008 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1117036008 = token;
        varB4EAC82CA7396A68D541C85D26508E83_1117036008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1117036008;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.425 -0400", hash_original_method = "0F12B8FB487852A4D61415942AC9447A", hash_generated_method = "3178D0BB9162D9ACF0F8D4003F690ECD")
    public void setMediaAuthorizationToken(String token) throws InvalidArgumentException {
        {
            boolean var0BBA6FD42C5738A08365C8D887AF0F63_1808877275 = (token == null || token.length() == 0);
            if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        } //End collapsed parenthetic
        this.token = token;
        // ---------- Original Method ----------
        //if (token == null || token.length() == 0)
            //throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        //this.token = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.425 -0400", hash_original_method = "724D317C37CE304AAB82EB39D5595B30", hash_generated_method = "6D10FBECAA15C940599ED77F65BB8CD2")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1157061070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1157061070 = token;
        varB4EAC82CA7396A68D541C85D26508E83_1157061070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1157061070;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.426 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.430 -0400", hash_original_method = "5CA94E0EC768C322B947B50479A5582B", hash_generated_method = "1F42CB535054F6A175B008C71B5038DA")
    public boolean equals(Object other) {
        {
            PMediaAuthorizationHeader o;
            o = (PMediaAuthorizationHeader) other;
            boolean var055F3006672A34EB761F0ABF2C2D3D0C_361864061 = (this.getToken().equals(o.getToken()));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649487341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649487341;
        // ---------- Original Method ----------
        //if (other instanceof PMediaAuthorizationHeader)
        //{
            //final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            //return this.getToken().equals(o.getToken());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.451 -0400", hash_original_method = "8A557E19577FD47CE8C49FDC6C46D11C", hash_generated_method = "E5E4953EABE56CFB338BD6B066EF00EC")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_71675966 = null; //Variable for return #1
        PMediaAuthorization retval;
        retval = (PMediaAuthorization) super.clone();
        retval.token = this.token;
        varB4EAC82CA7396A68D541C85D26508E83_71675966 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_71675966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_71675966;
        // ---------- Original Method ----------
        //PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        //if (this.token != null)
            //retval.token = this.token;
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.451 -0400", hash_original_field = "9DA309663EC39F7889D490CF1B81FFF2", hash_generated_field = "4B15F4D7F5E3B992BC2BBD1847974234")

    private static long serialVersionUID = -6463630258703731133L;
}

