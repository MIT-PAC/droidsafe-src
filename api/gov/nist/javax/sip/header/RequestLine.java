package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.javax.sip.address.GenericURI;

import javax.sip.address.URI;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RequestLine extends SIPObject implements SipRequestLine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.915 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.915 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.915 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.915 -0400", hash_original_method = "E4B7F4B41910EC919E5F140217342F7C", hash_generated_method = "EAF4B8E6F66C463F263AD3BE32A3D88C")
    public  RequestLine() {
        sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //sipVersion = "SIP/2.0";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.916 -0400", hash_original_method = "FF0843F55ACEC2A8E2B69A1885A4A70E", hash_generated_method = "94E775391CAAE4815033C54C5EEE9CB9")
    public  RequestLine(GenericURI requestURI, String method) {
        this.uri = requestURI;
        this.method = method;
        this.sipVersion = "SIP/2.0";
        // ---------- Original Method ----------
        //this.uri = requestURI;
        //this.method = method;
        //this.sipVersion = "SIP/2.0";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.916 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "02244C213A84A9134A081CA0BE3058DF")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_485346227 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_485346227.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_485346227;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.917 -0400", hash_original_method = "4F6DB28D47CD31A53DCF9FC226D5B630", hash_generated_method = "A7E1BAE56D09FE19FB5E8C52BFF66EE5")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(method != null)        
        {
            buffer.append(method);
            buffer.append(SP);
        } //End block
        if(uri != null)        
        {
            uri.encode(buffer);
            buffer.append(SP);
        } //End block
        buffer.append(sipVersion);
        buffer.append(NEWLINE);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2106353518 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_2106353518.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2106353518;
        // ---------- Original Method ----------
        //if (method != null) {
            //buffer.append(method);
            //buffer.append(SP);
        //}
        //if (uri != null) {
            //uri.encode(buffer);
            //buffer.append(SP);
        //}
        //buffer.append(sipVersion);
        //buffer.append(NEWLINE);
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.917 -0400", hash_original_method = "F87CE2D8FFE3E61DA8A4BD8B0BDA0697", hash_generated_method = "5B238485AE1BD1839BB2908FD499D24E")
    public GenericURI getUri() {
GenericURI varD12B663A5EB2F9B068EED08B4C05ECCC_870084069 =         uri;
        varD12B663A5EB2F9B068EED08B4C05ECCC_870084069.addTaint(taint);
        return varD12B663A5EB2F9B068EED08B4C05ECCC_870084069;
        // ---------- Original Method ----------
        //return uri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.917 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "40F027D978A5F550762D805B07CCA102")
    public String getMethod() {
String var27E3C5B2D4A798771E5F53D6527EECD0_1024250555 =         method;
        var27E3C5B2D4A798771E5F53D6527EECD0_1024250555.addTaint(taint);
        return var27E3C5B2D4A798771E5F53D6527EECD0_1024250555;
        // ---------- Original Method ----------
        //return method;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.917 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "360390A49F1A7C6038CF57694C4FA55C")
    public String getSipVersion() {
String var6122000D007F950F5F6ADABFD883424A_1594488507 =         sipVersion;
        var6122000D007F950F5F6ADABFD883424A_1594488507.addTaint(taint);
        return var6122000D007F950F5F6ADABFD883424A_1594488507;
        // ---------- Original Method ----------
        //return sipVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.918 -0400", hash_original_method = "E1410A4CC0BAAD1440D0D1F349F6B893", hash_generated_method = "9490E77B55167E8C08B818C0A6425D28")
    public void setUri(URI uri) {
        this.uri = (GenericURI)uri;
        // ---------- Original Method ----------
        //this.uri = (GenericURI)uri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.918 -0400", hash_original_method = "190C52163DA3AE651D57D1F9409B666E", hash_generated_method = "0A32A302E12C16AB7BD122DBD89AC3B9")
    public void setMethod(String method) {
        this.method = method;
        // ---------- Original Method ----------
        //this.method = method;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.919 -0400", hash_original_method = "1D61DBA7A6626C97B8FBAF50D3DDD562", hash_generated_method = "5D5262EE7BD591D6E71A6ED43A58938F")
    public void setSipVersion(String version) {
        this.sipVersion = version;
        // ---------- Original Method ----------
        //this.sipVersion = version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.919 -0400", hash_original_method = "4D5FB483F06B9DEED18B900A5129C79B", hash_generated_method = "BBE038785D079FC5FC416857753B4B66")
    public String getVersionMajor() {
        if(sipVersion == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1971211891 =         null;
        var540C13E9E156B687226421B24F2DF178_1971211891.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1971211891;
        }
        String major = null;
        boolean slash = false;
for(int i = 0;i < sipVersion.length();i++)
        {
            if(sipVersion.charAt(i) == '.')            
            break;
            if(slash)            
            {
                if(major == null)                
                major = "" + sipVersion.charAt(i);
                else
                major += sipVersion.charAt(i);
            } //End block
            if(sipVersion.charAt(i) == '/')            
            slash = true;
        } //End block
String var8E02483E9748102D17FB12AAE8E4AFEA_1024355921 =         major;
        var8E02483E9748102D17FB12AAE8E4AFEA_1024355921.addTaint(taint);
        return var8E02483E9748102D17FB12AAE8E4AFEA_1024355921;
        // ---------- Original Method ----------
        //if (sipVersion == null)
            //return null;
        //String major = null;
        //boolean slash = false;
        //for (int i = 0; i < sipVersion.length(); i++) {
            //if (sipVersion.charAt(i) == '.')
                //break;
            //if (slash) {
                //if (major == null)
                    //major = "" + sipVersion.charAt(i);
                //else
                    //major += sipVersion.charAt(i);
            //}
            //if (sipVersion.charAt(i) == '/')
                //slash = true;
        //}
        //return major;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.920 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "996BE7EA70162ED759DB75FFB6E26A52")
    public String getVersionMinor() {
        if(sipVersion == null)        
        {
String var540C13E9E156B687226421B24F2DF178_433054369 =         null;
        var540C13E9E156B687226421B24F2DF178_433054369.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_433054369;
        }
        String minor = null;
        boolean dot = false;
for(int i = 0;i < sipVersion.length();i++)
        {
            if(dot)            
            {
                if(minor == null)                
                minor = "" + sipVersion.charAt(i);
                else
                minor += sipVersion.charAt(i);
            } //End block
            if(sipVersion.charAt(i) == '.')            
            dot = true;
        } //End block
String varEAA4AE06AD0186EF287EEA4C8E0F2076_371904162 =         minor;
        varEAA4AE06AD0186EF287EEA4C8E0F2076_371904162.addTaint(taint);
        return varEAA4AE06AD0186EF287EEA4C8E0F2076_371904162;
        // ---------- Original Method ----------
        //if (sipVersion == null)
            //return null;
        //String minor = null;
        //boolean dot = false;
        //for (int i = 0; i < sipVersion.length(); i++) {
            //if (dot) {
                //if (minor == null)
                    //minor = "" + sipVersion.charAt(i);
                //else
                    //minor += sipVersion.charAt(i);
            //}
            //if (sipVersion.charAt(i) == '.')
                //dot = true;
        //}
        //return minor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.922 -0400", hash_original_method = "1239840CE17889EA14CF87055D293638", hash_generated_method = "01245496FC243BFF889DD0FC45ED7721")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean retval;
        if(!other.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_127093431 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046287596 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046287596;
        } //End block
        RequestLine that = (RequestLine) other;
        try 
        {
            retval =
                this.method.equals(that.method)
                    && this.uri.equals(that.uri)
                    && this.sipVersion.equals(that.sipVersion);
        } //End block
        catch (NullPointerException ex)
        {
            retval = false;
        } //End block
        boolean var020B759ADEF679A47CB9AFE965BB2314_558955863 = (retval);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324223665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324223665;
        // ---------- Original Method ----------
        //boolean retval;
        //if (!other.getClass().equals(this.getClass())) {
            //return false;
        //}
        //RequestLine that = (RequestLine) other;
        //try {
            //retval =
                //this.method.equals(that.method)
                    //&& this.uri.equals(that.uri)
                    //&& this.sipVersion.equals(that.sipVersion);
        //} catch (NullPointerException ex) {
            //retval = false;
        //}
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.922 -0400", hash_original_method = "6B13CE61BDAF8DDF9CB0869D09E1BD0F", hash_generated_method = "CAABBD61BDC58586BA58D902A7B4F629")
    public Object clone() {
        RequestLine retval = (RequestLine) super.clone();
        if(this.uri != null)        
        retval.uri = (GenericURI) this.uri.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_567110254 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_567110254.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_567110254;
        // ---------- Original Method ----------
        //RequestLine retval = (RequestLine) super.clone();
        //if (this.uri != null)
            //retval.uri = (GenericURI) this.uri.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.923 -0400", hash_original_field = "BA6FC0007D7D0CFBD660D7DEE05A678D", hash_generated_field = "ED5F8AB740667ACC3F117C961E7750C6")

    private static final long serialVersionUID = -3286426172326043129L;
}

