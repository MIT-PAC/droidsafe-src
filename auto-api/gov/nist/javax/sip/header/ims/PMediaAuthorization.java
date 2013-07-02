package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;

public class PMediaAuthorization extends SIPHeader implements PMediaAuthorizationHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.304 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "630027C1E843254DD22AA3F89157CD43")

    private String token;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.304 -0400", hash_original_method = "33816D631C77F21B21E54BBEFDA2795C", hash_generated_method = "1DDFAEE2CC3B34FAA95C12E411F347A6")
    public  PMediaAuthorization() {
        super(P_MEDIA_AUTHORIZATION);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.305 -0400", hash_original_method = "F23C2C2B4085CBC596D4F9DFFD38C718", hash_generated_method = "3700FBC581F1DEC72665495025B784F4")
    public String getToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1419375113 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1419375113 = token;
        varB4EAC82CA7396A68D541C85D26508E83_1419375113.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1419375113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.306 -0400", hash_original_method = "0F12B8FB487852A4D61415942AC9447A", hash_generated_method = "06BFB639469B847F25F51B55DFE7ED36")
    public void setMediaAuthorizationToken(String token) throws InvalidArgumentException {
        {
            boolean var0BBA6FD42C5738A08365C8D887AF0F63_1583482481 = (token == null || token.length() == 0);
            if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        } 
        this.token = token;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.306 -0400", hash_original_method = "724D317C37CE304AAB82EB39D5595B30", hash_generated_method = "138E80166BF527671205034190416457")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_2103802568 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2103802568 = token;
        varB4EAC82CA7396A68D541C85D26508E83_2103802568.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2103802568;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.307 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.307 -0400", hash_original_method = "5CA94E0EC768C322B947B50479A5582B", hash_generated_method = "CFCB75703AB522FD2AFD07691A360D51")
    public boolean equals(Object other) {
        {
            final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            boolean var055F3006672A34EB761F0ABF2C2D3D0C_1056816738 = (this.getToken().equals(o.getToken()));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138539484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138539484;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.308 -0400", hash_original_method = "8A557E19577FD47CE8C49FDC6C46D11C", hash_generated_method = "194B7686C2881298A94BFFD7BF634F53")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2013309089 = null; 
        PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        retval.token = this.token;
        varB4EAC82CA7396A68D541C85D26508E83_2013309089 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2013309089.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2013309089;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.309 -0400", hash_original_field = "9DA309663EC39F7889D490CF1B81FFF2", hash_generated_field = "C8D1FC4D9437199DDCE4D93F76EFB759")

    private static final long serialVersionUID = -6463630258703731133L;
}

