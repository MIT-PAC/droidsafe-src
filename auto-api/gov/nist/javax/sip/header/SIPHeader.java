package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class SIPHeader extends SIPObject implements SIPHeaderNames, javax.sip.header.Header, HeaderExt {
    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.278 -0400", hash_original_method = "FE673D693BAC70694CA41EF39D92900D", hash_generated_method = "3087C18B0FF633114BC1F0C8633838F9")
    @DSModeled(DSC.SAFE)
    protected SIPHeader(String hname) {
        dsTaint.addTaint(hname);
        // ---------- Original Method ----------
        //headerName = hname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.278 -0400", hash_original_method = "1EA533F6110BBCB8F937FFE2E4A5C224", hash_generated_method = "944F6867AF0E885EC31D94410F55FE87")
    @DSModeled(DSC.SAFE)
    public SIPHeader() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.278 -0400", hash_original_method = "62BB7D98AC3AE2D1B44BF4A9C83BFCEA", hash_generated_method = "CB03654A6667D79FBDEC6BA9FA59ED9E")
    @DSModeled(DSC.SAFE)
    public String getHeaderName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.278 -0400", hash_original_method = "5A8D65821D08B5534EF9F59F256EB0ED", hash_generated_method = "D08943AA2502BFC3B901E809ADE0ED44")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.278 -0400", hash_original_method = "B4EB4BB0337C6A7359D4335CEE5552C5", hash_generated_method = "D0BC7C2727D52F777E6FF9CD8D17548A")
    @DSModeled(DSC.SAFE)
    public void setHeaderName(String hdrname) {
        dsTaint.addTaint(hdrname);
        // ---------- Original Method ----------
        //headerName = hdrname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.279 -0400", hash_original_method = "4978FCECCFF9CE458180DF94EDCE0642", hash_generated_method = "B8E69463DC6A80EC1FEB246EA28123E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHeaderValue() {
        String encodedHdr;
        encodedHdr = null;
        try 
        {
            encodedHdr = this.encode();
        } //End block
        catch (Exception ex)
        { }
        StringBuffer buffer;
        buffer = new StringBuffer(encodedHdr);
        {
            boolean var8ED0ECD51D0EE01B77341FFB604DA0BF_129961778 = (buffer.length() > 0 && buffer.charAt(0) != ':');
            {
                buffer.deleteCharAt(0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA6481F2DD37075F8497C4FE156A6F563_1085629287 = (buffer.length() > 0);
            buffer.deleteCharAt(0);
        } //End collapsed parenthetic
        String varEF78F5DC3F1190CD4D4FD935F0A11750_1736110360 = (buffer.toString().trim());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.279 -0400", hash_original_method = "1CB55F4681FA88A1D00C1CC7A8265E42", hash_generated_method = "981B7596B40CA71B5E19793375BF3E84")
    @DSModeled(DSC.SAFE)
    public boolean isHeaderList() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.279 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "07DF61662C96B5882E283D812D300D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_1392619267 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.279 -0400", hash_original_method = "D602371A78852934DC2C93C46C0FD81D", hash_generated_method = "ACABD38086ED3E8F7DE85D7E2D06910B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(this.headerName).append(COLON).append(SP);
        this.encodeBody(buffer);
        buffer.append(NEWLINE);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //buffer.append(this.headerName).append(COLON).append(SP);
        //this.encodeBody(buffer);
        //buffer.append(NEWLINE);
        //return buffer;
    }

    
    protected abstract String encodeBody();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.280 -0400", hash_original_method = "112FD4376D79389C2460FE6A980E7021", hash_generated_method = "0C238128BBBF17CD1AA717AB6FA5DA1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        StringBuffer varFE6F7703638DBD48ABD13BB5FF8765EB_860329482 = (buffer.append(encodeBody()));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buffer.append(encodeBody());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.280 -0400", hash_original_method = "B7F53CD18FD7F00B77483EF4A0589C59", hash_generated_method = "85D37436D2055D13C8337915C9D15C85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue() {
        String var4D45CD817DD0BDA51687185ABB14F2AE_564912098 = (this.getHeaderValue());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.280 -0400", hash_original_method = "78242797F449E5EBFB278CC5A6BC56D0", hash_generated_method = "2C66286129FE03CAE5CD123A8ADB3805")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int var4B8D37533CC12365BECFAB730FC9EDC2_1233421872 = (this.headerName.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.headerName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.280 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "818E0C870676A3AAC3603B3E4926872F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_210139681 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
}

