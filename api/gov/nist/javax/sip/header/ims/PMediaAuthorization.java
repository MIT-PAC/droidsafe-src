package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.SIPHeader;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;

public class PMediaAuthorization extends SIPHeader implements PMediaAuthorizationHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.990 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "630027C1E843254DD22AA3F89157CD43")

    private String token;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.990 -0400", hash_original_method = "33816D631C77F21B21E54BBEFDA2795C", hash_generated_method = "1DDFAEE2CC3B34FAA95C12E411F347A6")
    public  PMediaAuthorization() {
        super(P_MEDIA_AUTHORIZATION);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.991 -0400", hash_original_method = "F23C2C2B4085CBC596D4F9DFFD38C718", hash_generated_method = "E8ACE36B966CA029FF70F4BA456265FE")
    public String getToken() {
String var84AE1F94A3CF2A5D8DE4571F3693A75E_1268260021 =         token;
        var84AE1F94A3CF2A5D8DE4571F3693A75E_1268260021.addTaint(taint);
        return var84AE1F94A3CF2A5D8DE4571F3693A75E_1268260021;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.991 -0400", hash_original_method = "0F12B8FB487852A4D61415942AC9447A", hash_generated_method = "4445B0AC632DF696948D696C9E4CC85C")
    public void setMediaAuthorizationToken(String token) throws InvalidArgumentException {
    if(token == null || token.length() == 0)        
        {
        InvalidArgumentException var56D3082022A16E24CCCE1D9BFE8B50A6_571985690 = new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        var56D3082022A16E24CCCE1D9BFE8B50A6_571985690.addTaint(taint);
        throw var56D3082022A16E24CCCE1D9BFE8B50A6_571985690;
        }
        this.token = token;
        // ---------- Original Method ----------
        //if (token == null || token.length() == 0)
            //throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        //this.token = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.992 -0400", hash_original_method = "724D317C37CE304AAB82EB39D5595B30", hash_generated_method = "43349C24805A9938842D705C98DE7EA0")
    protected String encodeBody() {
String var84AE1F94A3CF2A5D8DE4571F3693A75E_1206867403 =         token;
        var84AE1F94A3CF2A5D8DE4571F3693A75E_1206867403.addTaint(taint);
        return var84AE1F94A3CF2A5D8DE4571F3693A75E_1206867403;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.992 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "66C2B704504B0137EB5AFFF7570C2B25")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1849182476 = new ParseException (value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1849182476.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1849182476;
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.993 -0400", hash_original_method = "5CA94E0EC768C322B947B50479A5582B", hash_generated_method = "7C625FFD6E5C8141FE308E817C738B39")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof PMediaAuthorizationHeader)        
        {
            final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            boolean var8D046F12F8218E7BB85C50C05C4768EC_1759589134 = (this.getToken().equals(o.getToken()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85833492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_85833492;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1362647855 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897387252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897387252;
        // ---------- Original Method ----------
        //if (other instanceof PMediaAuthorizationHeader)
        //{
            //final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            //return this.getToken().equals(o.getToken());
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.993 -0400", hash_original_method = "8A557E19577FD47CE8C49FDC6C46D11C", hash_generated_method = "774C95BC36EAEA11DE11BDF41F4DA289")
    public Object clone() {
        PMediaAuthorization retval = (PMediaAuthorization) super.clone();
    if(this.token != null)        
        retval.token = this.token;
Object varF9E19AD6135C970F387F77C6F3DE4477_892304567 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_892304567.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_892304567;
        // ---------- Original Method ----------
        //PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        //if (this.token != null)
            //retval.token = this.token;
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.994 -0400", hash_original_field = "9DA309663EC39F7889D490CF1B81FFF2", hash_generated_field = "C8D1FC4D9437199DDCE4D93F76EFB759")

    private static final long serialVersionUID = -6463630258703731133L;
}

