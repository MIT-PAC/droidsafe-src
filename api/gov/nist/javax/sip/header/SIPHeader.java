package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, javax.sip.header.Header, HeaderExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.169 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.170 -0400", hash_original_method = "FE673D693BAC70694CA41EF39D92900D", hash_generated_method = "65F96AA6876FD65CD5AC5D1ED00B8886")
    protected  SIPHeader(String hname) {
        headerName = hname;
        // ---------- Original Method ----------
        //headerName = hname;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.170 -0400", hash_original_method = "1EA533F6110BBCB8F937FFE2E4A5C224", hash_generated_method = "944F6867AF0E885EC31D94410F55FE87")
    public  SIPHeader() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.171 -0400", hash_original_method = "62BB7D98AC3AE2D1B44BF4A9C83BFCEA", hash_generated_method = "29BCE3D3186CD6C634F003A4E0BE6A7F")
    public String getHeaderName() {
String var39A6529A5A73FCA4F413DA93A90497DA_1940710438 =         headerName;
        var39A6529A5A73FCA4F413DA93A90497DA_1940710438.addTaint(taint);
        return var39A6529A5A73FCA4F413DA93A90497DA_1940710438;
        // ---------- Original Method ----------
        //return headerName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.171 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "7DD97741D71AE5E280B00F23EDE3A0BD")
    public String getName() {
String var2D0A9E749E9205038C7691483855DB68_1037910729 =         this.headerName;
        var2D0A9E749E9205038C7691483855DB68_1037910729.addTaint(taint);
        return var2D0A9E749E9205038C7691483855DB68_1037910729;
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.172 -0400", hash_original_method = "B4EB4BB0337C6A7359D4335CEE5552C5", hash_generated_method = "6CE49BAD21B0CDF875F602FC403D818D")
    public void setHeaderName(String hdrname) {
        headerName = hdrname;
        // ---------- Original Method ----------
        //headerName = hdrname;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.172 -0400", hash_original_method = "4978FCECCFF9CE458180DF94EDCE0642", hash_generated_method = "65717F0C840B35AB4934AC7F82E761B4")
    public String getHeaderValue() {
        String encodedHdr = null;
        try 
        {
            encodedHdr = this.encode();
        } //End block
        catch (Exception ex)
        {
String var540C13E9E156B687226421B24F2DF178_1764447796 =             null;
            var540C13E9E156B687226421B24F2DF178_1764447796.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1764447796;
        } //End block
        StringBuffer buffer = new StringBuffer(encodedHdr);
        while
(buffer.length() > 0 && buffer.charAt(0) != ':')        
        {
            buffer.deleteCharAt(0);
        } //End block
        if(buffer.length() > 0)        
        buffer.deleteCharAt(0);
String varF08EA8F86C2009CF17A86BBDF8DB2EA7_2023365013 =         buffer.toString().trim();
        varF08EA8F86C2009CF17A86BBDF8DB2EA7_2023365013.addTaint(taint);
        return varF08EA8F86C2009CF17A86BBDF8DB2EA7_2023365013;
        // ---------- Original Method ----------
        //String encodedHdr = null;
        //try {
            //encodedHdr = this.encode();
        //} catch (Exception ex) {
            //return null;
        //}
        //StringBuffer buffer = new StringBuffer(encodedHdr);
        //while (buffer.length() > 0 && buffer.charAt(0) != ':') {
            //buffer.deleteCharAt(0);
        //}
        //if (buffer.length() > 0)
            //buffer.deleteCharAt(0);
        //return buffer.toString().trim();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.173 -0400", hash_original_method = "1CB55F4681FA88A1D00C1CC7A8265E42", hash_generated_method = "BFA00576B79F2B487714AE84D215BA13")
    public boolean isHeaderList() {
        boolean var68934A3E9455FA72420237EB05902327_1820623803 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459395346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_459395346;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.173 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "65D174D40850BCDAF1E2A17027B0C536")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_472058002 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_472058002.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_472058002;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.174 -0400", hash_original_method = "D602371A78852934DC2C93C46C0FD81D", hash_generated_method = "A3821257CBFE9F82EFE9A8EBA78FC969")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(this.headerName).append(COLON).append(SP);
        this.encodeBody(buffer);
        buffer.append(NEWLINE);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_22930056 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_22930056.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_22930056;
        // ---------- Original Method ----------
        //buffer.append(this.headerName).append(COLON).append(SP);
        //this.encodeBody(buffer);
        //buffer.append(NEWLINE);
        //return buffer;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract String encodeBody();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.174 -0400", hash_original_method = "112FD4376D79389C2460FE6A980E7021", hash_generated_method = "0CA6EAA6CA2811D5DCEEF804AA6DC02B")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varABD6A1236808A2805884156E6801E996_90638861 =         buffer.append(encodeBody());
        varABD6A1236808A2805884156E6801E996_90638861.addTaint(taint);
        return varABD6A1236808A2805884156E6801E996_90638861;
        // ---------- Original Method ----------
        //return buffer.append(encodeBody());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.175 -0400", hash_original_method = "B7F53CD18FD7F00B77483EF4A0589C59", hash_generated_method = "0AA069D7D6C4575FB8EFAE3DD8608D47")
    public String getValue() {
String var650A235F8D00B3E802F034AA253BD873_424535335 =         this.getHeaderValue();
        var650A235F8D00B3E802F034AA253BD873_424535335.addTaint(taint);
        return var650A235F8D00B3E802F034AA253BD873_424535335;
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.175 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "0C9C2257603F71A5BEBD06B5C5353309")
    public int hashCode() {
        int var3CA62782399404389049138061B2C659_1526054721 = (this.headerName.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286932267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286932267;
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.175 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "D485AB06294436DE49EE45A91DA794A4")
    public final String toString() {
String varB17575D7C845B2C662583710539AAEBB_1239563342 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1239563342.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1239563342;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
}

