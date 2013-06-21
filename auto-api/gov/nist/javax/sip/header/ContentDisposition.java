package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.*;

public final class ContentDisposition extends ParametersHeader implements javax.sip.header.ContentDispositionHeader {
    protected String dispositionType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.891 -0400", hash_original_method = "43E6E51171C31AE017D057FA4552D811", hash_generated_method = "30697E61C2A62E132F1F2ECEC533B294")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentDisposition() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.891 -0400", hash_original_method = "A77142351A28E594907776BE9B73073E", hash_generated_method = "40A9212659BAC6C70FF1AD10CFED6F2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        StringBuffer encoding;
        encoding = new StringBuffer(dispositionType);
        {
            boolean var0D32F672AFA5F784DED3919887902299_2011874119 = (!this.parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        String varB81683B37658DAABB0D3F9E81B4869CA_988846080 = (encoding.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer(dispositionType);
        //if (!this.parameters.isEmpty()) {
            //encoding.append(SEMICOLON).append(parameters.encode());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.891 -0400", hash_original_method = "BC30AB325A2FD01EDD0A547607B8E8A1", hash_generated_method = "6C6B8947DC073CBFA072713301273A94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDispositionType(String dispositionType) throws ParseException {
        dsTaint.addTaint(dispositionType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        // ---------- Original Method ----------
        //if (dispositionType == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        //this.dispositionType = dispositionType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.891 -0400", hash_original_method = "D3ED1AFB699417969621FE1884F8C7FE", hash_generated_method = "1FD3B83986931411447B8799E5C8A54D")
    @DSModeled(DSC.SAFE)
    public String getDispositionType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.dispositionType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.892 -0400", hash_original_method = "0297698DA62A584BC408978A78677ED8", hash_generated_method = "00DBDFE0B4529AE23F058017CA10B86A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHandling() {
        String var68E23F28749B5B78D2A68F326197C5CB_589030423 = (this.getParameter("handling"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter("handling");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.892 -0400", hash_original_method = "B6C4C36D7665EDCFABC9BF782D2AADE0", hash_generated_method = "BEE9BA11CBA5D4F34ACDBA8B786854D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHandling(String handling) throws ParseException {
        dsTaint.addTaint(handling);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setHandling(), the handling parameter is null");
        this.setParameter("handling", handling);
        // ---------- Original Method ----------
        //if (handling == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", ContentDisposition, setHandling(), the handling parameter is null");
        //this.setParameter("handling", handling);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.892 -0400", hash_original_method = "C2FDE3A2DBDC43C0B4279ABCAA53BEFB", hash_generated_method = "A1BBD1C50533F0817A754888C9AD7283")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentDisposition() {
        String var7CD8161F9F63CECF143F9946FD49E225_442327929 = (this.encodeBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    private static final long serialVersionUID = 835596496276127003L;
}

