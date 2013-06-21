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
    private String token;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.585 -0400", hash_original_method = "33816D631C77F21B21E54BBEFDA2795C", hash_generated_method = "1DDFAEE2CC3B34FAA95C12E411F347A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PMediaAuthorization() {
        super(P_MEDIA_AUTHORIZATION);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.586 -0400", hash_original_method = "F23C2C2B4085CBC596D4F9DFFD38C718", hash_generated_method = "316B270A18B77B5B9D272565CB07A6E8")
    @DSModeled(DSC.SAFE)
    public String getToken() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.586 -0400", hash_original_method = "0F12B8FB487852A4D61415942AC9447A", hash_generated_method = "39301470E6754AA7F80576057198AE28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMediaAuthorizationToken(String token) throws InvalidArgumentException {
        dsTaint.addTaint(token);
        {
            boolean var0BBA6FD42C5738A08365C8D887AF0F63_744880265 = (token == null || token.length() == 0);
            if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (token == null || token.length() == 0)
            //throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        //this.token = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.586 -0400", hash_original_method = "724D317C37CE304AAB82EB39D5595B30", hash_generated_method = "7211E9257CEB472AF550B8710AC0C2D3")
    @DSModeled(DSC.SAFE)
    protected String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.586 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.587 -0400", hash_original_method = "5CA94E0EC768C322B947B50479A5582B", hash_generated_method = "03EF48A05B42001BCB8D7453434C2E4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            PMediaAuthorizationHeader o;
            o = (PMediaAuthorizationHeader) other;
            boolean var055F3006672A34EB761F0ABF2C2D3D0C_2130647250 = (this.getToken().equals(o.getToken()));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other instanceof PMediaAuthorizationHeader)
        //{
            //final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            //return this.getToken().equals(o.getToken());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.587 -0400", hash_original_method = "8A557E19577FD47CE8C49FDC6C46D11C", hash_generated_method = "943E02DEAA0D630EF9848B8B6AE54994")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PMediaAuthorization retval;
        retval = (PMediaAuthorization) super.clone();
        retval.token = this.token;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        //if (this.token != null)
            //retval.token = this.token;
        //return retval;
    }

    
    private static final long serialVersionUID = -6463630258703731133L;
}

