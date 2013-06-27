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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.259 -0400", hash_original_field = "7FC2BCE87197C31953A120E8CD83179B", hash_generated_field = "3BF4E6C2E9BDDD28A6A0F84E1D29ABEE")

    public String TEXT = ParameterNames.TEXT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.260 -0400", hash_original_field = "584FC6002B6AFD83571AE617919A98D6", hash_generated_field = "6CA252780175B2E0ADFEDFBA33722DB3")

    public String CAUSE = ParameterNames.CAUSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.260 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.271 -0400", hash_original_method = "49B37C8425CF255FB1500AD2816C1ABC", hash_generated_method = "07F22BA75232C6AA162B9790FFFB6280")
    public  Reason() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.271 -0400", hash_original_method = "8E10C2A6776CBAA32EF7257A8A62ADDC", hash_generated_method = "30979DA24858BBEE1205BCEF2EAB395A")
    public int getCause() {
        int var5FA1DAF18101AFAD0127BAAE543D0DD5_1344940235 = (getParameterAsInt(CAUSE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404926067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404926067;
        // ---------- Original Method ----------
        //return getParameterAsInt(CAUSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.271 -0400", hash_original_method = "3B7AE3E82D120F32D14143BCEAA3D0F3", hash_generated_method = "9FE7FA56A5CB5B3F35546258683DCFBA")
    public void setCause(int cause) throws javax.sip.InvalidArgumentException {
        this.parameters.set("cause", Integer.valueOf(cause));
        addTaint(cause);
        // ---------- Original Method ----------
        //this.parameters.set("cause", Integer.valueOf(cause));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.271 -0400", hash_original_method = "70E0561C3515B6199EF81B19035663E5", hash_generated_method = "4C76BB115A08F7A5B416485065695A07")
    public void setProtocol(String protocol) throws ParseException {
        this.protocol = protocol;
        // ---------- Original Method ----------
        //this.protocol = protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.272 -0400", hash_original_method = "5EF709A41590C5E9760EDEDCACA5AD40", hash_generated_method = "2F132B8C70E661C2B9D6B6C84F1ED9BA")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1872395029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1872395029 = this.protocol;
        varB4EAC82CA7396A68D541C85D26508E83_1872395029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1872395029;
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.272 -0400", hash_original_method = "A59A90A2875E29D5E7D7A7D1C378A11A", hash_generated_method = "5EAA169A538304D09F3938FE68EBAB37")
    public void setText(String text) throws ParseException {
        {
            boolean varCE3BAA904F8E63ACB7106B27C55960EB_1419740922 = (text.charAt(0) != '"');
            {
                text = Utils.getQuotedString(text);
            } //End block
        } //End collapsed parenthetic
        this.parameters.set("text", text);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //if ( text.charAt(0) != '"' ) {
            //text = Utils.getQuotedString(text);
        //}
        //this.parameters.set("text", text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.273 -0400", hash_original_method = "E868EA376D386565EBAAF11DC1F8D010", hash_generated_method = "F036D8B2FBD0C532C957A640281AB8BF")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_800969944 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_800969944 = this.parameters.getParameter("text");
        varB4EAC82CA7396A68D541C85D26508E83_800969944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_800969944;
        // ---------- Original Method ----------
        //return this.parameters.getParameter("text");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.273 -0400", hash_original_method = "58D1ADCDFA9509486623D4E556DE8E64", hash_generated_method = "D6FB9AF8A50EAA5B2689C1064EA096FA")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1382969114 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1382969114 = NAME;
        varB4EAC82CA7396A68D541C85D26508E83_1382969114.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1382969114;
        // ---------- Original Method ----------
        //return NAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.274 -0400", hash_original_method = "F6A3921BF2DA3805D24A4DD375373A7E", hash_generated_method = "CDA90D47845ACFD8E80A21ADCD7DF5BA")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1870651522 = null; //Variable for return #1
        StringBuffer s;
        s = new StringBuffer();
        s.append(protocol);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1042804452 = (parameters != null && !parameters.isEmpty());
            s.append(SEMICOLON).append(parameters.encode());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1870651522 = s.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1870651522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870651522;
        // ---------- Original Method ----------
        //StringBuffer s = new StringBuffer();
        //s.append(protocol);
        //if (parameters != null && !parameters.isEmpty())
            //s.append(SEMICOLON).append(parameters.encode());
        //return s.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.274 -0400", hash_original_field = "E4C9B7DC021EE557504C75FFB2D6D7D6", hash_generated_field = "5C5FFD4155BF9D7AB97A65D9D268B9A3")

    private static long serialVersionUID = -8903376965568297388L;
}

