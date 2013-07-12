package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, javax.sip.header.Header, HeaderExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.148 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.148 -0400", hash_original_method = "FE673D693BAC70694CA41EF39D92900D", hash_generated_method = "65F96AA6876FD65CD5AC5D1ED00B8886")
    protected  SIPHeader(String hname) {
        headerName = hname;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.148 -0400", hash_original_method = "1EA533F6110BBCB8F937FFE2E4A5C224", hash_generated_method = "944F6867AF0E885EC31D94410F55FE87")
    public  SIPHeader() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.148 -0400", hash_original_method = "62BB7D98AC3AE2D1B44BF4A9C83BFCEA", hash_generated_method = "B85699B78DBF4050C82F4E4E9ACE739F")
    public String getHeaderName() {
String var39A6529A5A73FCA4F413DA93A90497DA_89515707 =         headerName;
        var39A6529A5A73FCA4F413DA93A90497DA_89515707.addTaint(taint);
        return var39A6529A5A73FCA4F413DA93A90497DA_89515707;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.149 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "A917C70AFF46BC532555EA1BF9F7ADD0")
    public String getName() {
String var2D0A9E749E9205038C7691483855DB68_309488485 =         this.headerName;
        var2D0A9E749E9205038C7691483855DB68_309488485.addTaint(taint);
        return var2D0A9E749E9205038C7691483855DB68_309488485;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.149 -0400", hash_original_method = "B4EB4BB0337C6A7359D4335CEE5552C5", hash_generated_method = "6CE49BAD21B0CDF875F602FC403D818D")
    public void setHeaderName(String hdrname) {
        headerName = hdrname;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.149 -0400", hash_original_method = "4978FCECCFF9CE458180DF94EDCE0642", hash_generated_method = "7E3B92B915BC87D2468DDA7EB56270E9")
    public String getHeaderValue() {
        String encodedHdr = null;
        try 
        {
            encodedHdr = this.encode();
        } 
        catch (Exception ex)
        {
String var540C13E9E156B687226421B24F2DF178_805196541 =             null;
            var540C13E9E156B687226421B24F2DF178_805196541.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_805196541;
        } 
        StringBuffer buffer = new StringBuffer(encodedHdr);
        while
(buffer.length() > 0 && buffer.charAt(0) != ':')        
        {
            buffer.deleteCharAt(0);
        } 
    if(buffer.length() > 0)        
        buffer.deleteCharAt(0);
String varF08EA8F86C2009CF17A86BBDF8DB2EA7_702338557 =         buffer.toString().trim();
        varF08EA8F86C2009CF17A86BBDF8DB2EA7_702338557.addTaint(taint);
        return varF08EA8F86C2009CF17A86BBDF8DB2EA7_702338557;
        
        
        
            
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.150 -0400", hash_original_method = "1CB55F4681FA88A1D00C1CC7A8265E42", hash_generated_method = "48D59B6C3CAF4C9586B23780B112654A")
    public boolean isHeaderList() {
        boolean var68934A3E9455FA72420237EB05902327_1428483826 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361724771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361724771;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.150 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "B7012055E62B76DDEEC9F4FD2FABB84B")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1525210025 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1525210025.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1525210025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.151 -0400", hash_original_method = "D602371A78852934DC2C93C46C0FD81D", hash_generated_method = "A6D03E7FE212CE8865EBC798054430D6")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(this.headerName).append(COLON).append(SP);
        this.encodeBody(buffer);
        buffer.append(NEWLINE);
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_829084806 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_829084806.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_829084806;
        
        
        
        
        
    }

    
    protected abstract String encodeBody();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.151 -0400", hash_original_method = "112FD4376D79389C2460FE6A980E7021", hash_generated_method = "C4B85B7CC8F0014328A6B4CFF3BB9B6D")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varABD6A1236808A2805884156E6801E996_834768714 =         buffer.append(encodeBody());
        varABD6A1236808A2805884156E6801E996_834768714.addTaint(taint);
        return varABD6A1236808A2805884156E6801E996_834768714;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.151 -0400", hash_original_method = "B7F53CD18FD7F00B77483EF4A0589C59", hash_generated_method = "74F9F41CC7022BEB8321BAE99B9304EA")
    public String getValue() {
String var650A235F8D00B3E802F034AA253BD873_1107538879 =         this.getHeaderValue();
        var650A235F8D00B3E802F034AA253BD873_1107538879.addTaint(taint);
        return var650A235F8D00B3E802F034AA253BD873_1107538879;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.152 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "A63FAC272F6CAFB8A82F1CA416401589")
    public int hashCode() {
        int var3CA62782399404389049138061B2C659_1909444289 = (this.headerName.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641387944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641387944;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.152 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "68CB6505A6C80FCC0B6AE1460FC56753")
    public final String toString() {
String varB17575D7C845B2C662583710539AAEBB_1095359469 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1095359469.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1095359469;
        
        
    }

    
}

