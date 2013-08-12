package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;






public class PMediaAuthorization extends SIPHeader implements PMediaAuthorizationHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.194 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "630027C1E843254DD22AA3F89157CD43")

    private String token;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.195 -0400", hash_original_method = "33816D631C77F21B21E54BBEFDA2795C", hash_generated_method = "1DDFAEE2CC3B34FAA95C12E411F347A6")
    public  PMediaAuthorization() {
        super(P_MEDIA_AUTHORIZATION);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.195 -0400", hash_original_method = "F23C2C2B4085CBC596D4F9DFFD38C718", hash_generated_method = "4E691A7766B0B22EE7DB6BFD54756696")
    public String getToken() {
String var84AE1F94A3CF2A5D8DE4571F3693A75E_1197511287 =         token;
        var84AE1F94A3CF2A5D8DE4571F3693A75E_1197511287.addTaint(taint);
        return var84AE1F94A3CF2A5D8DE4571F3693A75E_1197511287;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.196 -0400", hash_original_method = "0F12B8FB487852A4D61415942AC9447A", hash_generated_method = "DD761AACC0BCBD255F952786FFEC9F19")
    public void setMediaAuthorizationToken(String token) throws InvalidArgumentException {
        if(token == null || token.length() == 0)        
        {
        InvalidArgumentException var56D3082022A16E24CCCE1D9BFE8B50A6_1295978281 = new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        var56D3082022A16E24CCCE1D9BFE8B50A6_1295978281.addTaint(taint);
        throw var56D3082022A16E24CCCE1D9BFE8B50A6_1295978281;
        }
        this.token = token;
        // ---------- Original Method ----------
        //if (token == null || token.length() == 0)
            //throw new InvalidArgumentException(" the Media-Authorization-Token parameter is null or empty");
        //this.token = token;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.196 -0400", hash_original_method = "724D317C37CE304AAB82EB39D5595B30", hash_generated_method = "5029C5872BCCA8E91B974D2012591B8B")
    protected String encodeBody() {
String var84AE1F94A3CF2A5D8DE4571F3693A75E_58058872 =         token;
        var84AE1F94A3CF2A5D8DE4571F3693A75E_58058872.addTaint(taint);
        return var84AE1F94A3CF2A5D8DE4571F3693A75E_58058872;
        // ---------- Original Method ----------
        //return token;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.196 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "11A86BDBEAB8AECAFBC0109054DE3E40")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_278167068 = new ParseException (value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_278167068.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_278167068;
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.196 -0400", hash_original_method = "5CA94E0EC768C322B947B50479A5582B", hash_generated_method = "5EDBD4843E766AB0E7C724614DB4D6FE")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other instanceof PMediaAuthorizationHeader)        
        {
            final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            boolean var8D046F12F8218E7BB85C50C05C4768EC_829089835 = (this.getToken().equals(o.getToken()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557662833 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557662833;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_450937636 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849376265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849376265;
        // ---------- Original Method ----------
        //if (other instanceof PMediaAuthorizationHeader)
        //{
            //final PMediaAuthorizationHeader o = (PMediaAuthorizationHeader) other;
            //return this.getToken().equals(o.getToken());
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.197 -0400", hash_original_method = "8A557E19577FD47CE8C49FDC6C46D11C", hash_generated_method = "4D100774BBC0140BDC3AE8392F18752E")
    public Object clone() {
        PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        if(this.token != null)        
        retval.token = this.token;
Object varF9E19AD6135C970F387F77C6F3DE4477_1706801600 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1706801600.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1706801600;
        // ---------- Original Method ----------
        //PMediaAuthorization retval = (PMediaAuthorization) super.clone();
        //if (this.token != null)
            //retval.token = this.token;
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.197 -0400", hash_original_field = "9DA309663EC39F7889D490CF1B81FFF2", hash_generated_field = "C8D1FC4D9437199DDCE4D93F76EFB759")

    private static final long serialVersionUID = -6463630258703731133L;
}

