package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExtensionHeaderImpl extends SIPHeader implements javax.sip.header.ExtensionHeader {
    protected String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.936 -0400", hash_original_method = "0D428BF693BC145CE79E697041FDBB13", hash_generated_method = "E16B4249E7E1D0E0C17B6F77DF99E8B5")
    @DSModeled(DSC.SAFE)
    public ExtensionHeaderImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.937 -0400", hash_original_method = "A937839923AA8BCCDCCEAF20D9D52A8A", hash_generated_method = "98A74A8247EE6DAC6FC2EA1165AC2902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtensionHeaderImpl(String headerName) {
        super(headerName);
        dsTaint.addTaint(headerName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.937 -0400", hash_original_method = "484F8876E72CD5E2F0338DF99C79D0F8", hash_generated_method = "3FEB09DC25C75021C4CCC94B306E9C6F")
    @DSModeled(DSC.SAFE)
    public void setName(String headerName) {
        dsTaint.addTaint(headerName);
        this.headerName = headerName;
        // ---------- Original Method ----------
        //this.headerName = headerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.937 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "4F4F7F37856EA1BF8C0BF221B2AF5ABB")
    @DSModeled(DSC.SAFE)
    public void setValue(String value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.937 -0400", hash_original_method = "1D785F814110552974451EFCFA0C5F26", hash_generated_method = "5D689E0CA0047F7F27DFE1FA2B72F4A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHeaderValue() {
        {
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
                boolean varEBE4927262008ED3958A3F76EC2D70F1_888636032 = (buffer.length() > 0 && buffer.charAt(0) != ':');
                {
                    buffer.deleteCharAt(0);
                } //End block
            } //End collapsed parenthetic
            buffer.deleteCharAt(0);
            this.value = buffer.toString().trim();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (this.value != null) {
            //return this.value;
        //} else {
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
            //buffer.deleteCharAt(0);
            //this.value = buffer.toString().trim();
            //return this.value;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.938 -0400", hash_original_method = "AC75BAF5D25E8A26F15256B1C5A7867F", hash_generated_method = "67D43E02920BDEA94AE38275F8CC9341")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String var6D1EA6D23A4503A384E64E7C090F7B37_1942415102 = (new StringBuffer(this.headerName)
            .append(COLON)
            .append(SP)
            .append(this.value)
            .append(NEWLINE)
            .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new StringBuffer(this.headerName)
            //.append(COLON)
            //.append(SP)
            //.append(this.value)
            //.append(NEWLINE)
            //.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.938 -0400", hash_original_method = "0A0703D799D76E700F53E1DA99AB2D69", hash_generated_method = "F0B0F9417445674936E95217A2642BB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var4D45CD817DD0BDA51687185ABB14F2AE_1216739653 = (this.getHeaderValue());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getHeaderValue();
    }

    
    private static final long serialVersionUID = -8693922839612081849L;
}

