package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Parameters;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.header.SIPHeader;

public class Privacy extends SIPHeader implements PrivacyHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.137 -0400", hash_original_field = "21CEC257FEB15BCC84E0ACD5B0773883", hash_generated_field = "66940D25B8669AE19E240042C82974B1")

    private String privacy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.137 -0400", hash_original_method = "A1E2C85381DFB17E59FB5DEA35C141AD", hash_generated_method = "F41CC28F77299CAB879B24173C4441D3")
    public  Privacy() {
        super(PRIVACY);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.137 -0400", hash_original_method = "B120CF39D581439EB005580774DE8E96", hash_generated_method = "70A02CA92965B26C83EFFD5CBEE38258")
    public  Privacy(String privacy) {
        this();
        this.privacy = privacy;
        // ---------- Original Method ----------
        //this.privacy = privacy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.138 -0400", hash_original_method = "C66B8514DBF734E1693DCAFADDDE494C", hash_generated_method = "567E769EFCEC87927440D5034E10632F")
    public String encodeBody() {
String var6932BE00DA66F3539044D415EA3CA312_1609484036 =         this.privacy;
        var6932BE00DA66F3539044D415EA3CA312_1609484036.addTaint(taint);
        return var6932BE00DA66F3539044D415EA3CA312_1609484036;
        // ---------- Original Method ----------
        //return this.privacy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.138 -0400", hash_original_method = "1BCFC01DA9502F608C910A07D4A75A00", hash_generated_method = "30201C459AAFC640A441996920E70107")
    public String getPrivacy() {
String var28A65DCE41136C6290258CACACAD7232_976587399 =         privacy;
        var28A65DCE41136C6290258CACACAD7232_976587399.addTaint(taint);
        return var28A65DCE41136C6290258CACACAD7232_976587399;
        // ---------- Original Method ----------
        //return privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.139 -0400", hash_original_method = "B856482BE8E8039B726BD615DE62F5D9", hash_generated_method = "F0D5A103AE1F8D99C002D1B031E9BFA2")
    public void setPrivacy(String privacy) throws ParseException {
    if(privacy == null || privacy == "")        
        {
        NullPointerException varBF82EF3A6D958D54118F331D56044E49_744530595 = new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Privacy, setPrivacy(), privacy value is null or empty");
        varBF82EF3A6D958D54118F331D56044E49_744530595.addTaint(taint);
        throw varBF82EF3A6D958D54118F331D56044E49_744530595;
        }
        this.privacy = privacy;
        // ---------- Original Method ----------
        //if (privacy == null || privacy == "")
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Privacy, setPrivacy(), privacy value is null or empty");
        //this.privacy = privacy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.140 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "E7E8BF81E8C99CDF4B1E28C54371998D")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_2053184768 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_2053184768.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_2053184768;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.140 -0400", hash_original_method = "DB811FF594B6D6915B4D573130CCABF1", hash_generated_method = "973069F33BAA614C2452A8A655E5B1EE")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof PrivacyHeader)        
        {
            PrivacyHeader o = (PrivacyHeader) other;
            boolean var2B136F925D89FEC240AAEDBB70DFC641_185674610 = ((this.getPrivacy().equals( o.getPrivacy() )));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719631614 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719631614;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_24756419 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084665662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084665662;
        // ---------- Original Method ----------
        //if (other instanceof PrivacyHeader)
        //{
            //PrivacyHeader o = (PrivacyHeader) other;
            //return (this.getPrivacy().equals( o.getPrivacy() ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.141 -0400", hash_original_method = "6120A3F29636BB071828910A14D394C6", hash_generated_method = "BA4A2415EA21CB4D307E1B5E85979F1D")
    public Object clone() {
        Privacy retval = (Privacy) super.clone();
    if(this.privacy != null)        
        retval.privacy = this.privacy;
Object varF9E19AD6135C970F387F77C6F3DE4477_145922274 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_145922274.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_145922274;
        // ---------- Original Method ----------
        //Privacy retval = (Privacy) super.clone();
        //if (this.privacy != null)
            //retval.privacy = this.privacy;
        //return retval;
    }

    
}

