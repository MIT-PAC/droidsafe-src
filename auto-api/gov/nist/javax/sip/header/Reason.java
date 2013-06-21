package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.Utils;
import java.text.ParseException;

public class Reason extends ParametersHeader implements javax.sip.header.ReasonHeader {
    public String TEXT = ParameterNames.TEXT;
    public String CAUSE = ParameterNames.CAUSE;
    protected String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.102 -0400", hash_original_method = "49B37C8425CF255FB1500AD2816C1ABC", hash_generated_method = "07F22BA75232C6AA162B9790FFFB6280")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Reason() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.102 -0400", hash_original_method = "8E10C2A6776CBAA32EF7257A8A62ADDC", hash_generated_method = "48534A681133FC1F7E3C1567B2A7A9A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCause() {
        int var5FA1DAF18101AFAD0127BAAE543D0DD5_1511128269 = (getParameterAsInt(CAUSE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getParameterAsInt(CAUSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.102 -0400", hash_original_method = "3B7AE3E82D120F32D14143BCEAA3D0F3", hash_generated_method = "55E459EF8A0441C4886D6C8D08A0DB8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCause(int cause) throws javax.sip.InvalidArgumentException {
        dsTaint.addTaint(cause);
        this.parameters.set("cause", Integer.valueOf(cause));
        // ---------- Original Method ----------
        //this.parameters.set("cause", Integer.valueOf(cause));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.102 -0400", hash_original_method = "70E0561C3515B6199EF81B19035663E5", hash_generated_method = "6A20F3B0BB16287D794A8027A9DC458D")
    @DSModeled(DSC.SAFE)
    public void setProtocol(String protocol) throws ParseException {
        dsTaint.addTaint(protocol);
        // ---------- Original Method ----------
        //this.protocol = protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.103 -0400", hash_original_method = "5EF709A41590C5E9760EDEDCACA5AD40", hash_generated_method = "F78A980ACB835949934414A7C89517C4")
    @DSModeled(DSC.SAFE)
    public String getProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.103 -0400", hash_original_method = "A59A90A2875E29D5E7D7A7D1C378A11A", hash_generated_method = "3E0DE5AEFB7578927C69513D6A8592BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(String text) throws ParseException {
        dsTaint.addTaint(text);
        {
            boolean varCE3BAA904F8E63ACB7106B27C55960EB_794061539 = (text.charAt(0) != '"');
            {
                text = Utils.getQuotedString(text);
            } //End block
        } //End collapsed parenthetic
        this.parameters.set("text", text);
        // ---------- Original Method ----------
        //if ( text.charAt(0) != '"' ) {
            //text = Utils.getQuotedString(text);
        //}
        //this.parameters.set("text", text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.103 -0400", hash_original_method = "E868EA376D386565EBAAF11DC1F8D010", hash_generated_method = "2A19B49BBCBB6C9D6E5B1DDF663A1152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getText() {
        String varCB3C5D274E763012742548530D14C89A_1465269994 = (this.parameters.getParameter("text"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.parameters.getParameter("text");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.103 -0400", hash_original_method = "58D1ADCDFA9509486623D4E556DE8E64", hash_generated_method = "C835A1B85981E83EAE9567361EB78083")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return NAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.104 -0400", hash_original_method = "F6A3921BF2DA3805D24A4DD375373A7E", hash_generated_method = "61DB3013DA5C9EC34F12A7D8FAC0A605")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer s;
        s = new StringBuffer();
        s.append(protocol);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1625715965 = (parameters != null && !parameters.isEmpty());
            s.append(SEMICOLON).append(parameters.encode());
        } //End collapsed parenthetic
        String var2C8CBC592926D123231717329230B287_1136883399 = (s.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer s = new StringBuffer();
        //s.append(protocol);
        //if (parameters != null && !parameters.isEmpty())
            //s.append(SEMICOLON).append(parameters.encode());
        //return s.toString();
    }

    
    private static final long serialVersionUID = -8903376965568297388L;
}

