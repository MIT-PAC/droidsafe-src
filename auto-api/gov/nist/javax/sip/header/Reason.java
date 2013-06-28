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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.986 -0400", hash_original_field = "7FC2BCE87197C31953A120E8CD83179B", hash_generated_field = "0D9A1057F894C5C025812C805A74752D")

    public final String TEXT = ParameterNames.TEXT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.986 -0400", hash_original_field = "584FC6002B6AFD83571AE617919A98D6", hash_generated_field = "FB6C8196B2C2E307FFF20FE5A583FA8B")

    public final String CAUSE = ParameterNames.CAUSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.986 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.987 -0400", hash_original_method = "49B37C8425CF255FB1500AD2816C1ABC", hash_generated_method = "07F22BA75232C6AA162B9790FFFB6280")
    public  Reason() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.987 -0400", hash_original_method = "8E10C2A6776CBAA32EF7257A8A62ADDC", hash_generated_method = "5A716B3ED53E9C30D3F341D9F584E164")
    public int getCause() {
        int var5FA1DAF18101AFAD0127BAAE543D0DD5_1510474133 = (getParameterAsInt(CAUSE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919270238 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919270238;
        // ---------- Original Method ----------
        //return getParameterAsInt(CAUSE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.988 -0400", hash_original_method = "3B7AE3E82D120F32D14143BCEAA3D0F3", hash_generated_method = "9FE7FA56A5CB5B3F35546258683DCFBA")
    public void setCause(int cause) throws javax.sip.InvalidArgumentException {
        this.parameters.set("cause", Integer.valueOf(cause));
        addTaint(cause);
        // ---------- Original Method ----------
        //this.parameters.set("cause", Integer.valueOf(cause));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.988 -0400", hash_original_method = "70E0561C3515B6199EF81B19035663E5", hash_generated_method = "4C76BB115A08F7A5B416485065695A07")
    public void setProtocol(String protocol) throws ParseException {
        this.protocol = protocol;
        // ---------- Original Method ----------
        //this.protocol = protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.989 -0400", hash_original_method = "5EF709A41590C5E9760EDEDCACA5AD40", hash_generated_method = "52326A5535B8A7259D2E0D25C54FA463")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_622568544 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_622568544 = this.protocol;
        varB4EAC82CA7396A68D541C85D26508E83_622568544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_622568544;
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.989 -0400", hash_original_method = "A59A90A2875E29D5E7D7A7D1C378A11A", hash_generated_method = "559361999872BD0D7EE74F7E26534D7D")
    public void setText(String text) throws ParseException {
        {
            boolean varCE3BAA904F8E63ACB7106B27C55960EB_528055801 = (text.charAt(0) != '"');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.990 -0400", hash_original_method = "E868EA376D386565EBAAF11DC1F8D010", hash_generated_method = "FB91D2C1FEDE6DA7AB38F528372BDCD7")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_438145 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_438145 = this.parameters.getParameter("text");
        varB4EAC82CA7396A68D541C85D26508E83_438145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_438145;
        // ---------- Original Method ----------
        //return this.parameters.getParameter("text");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.991 -0400", hash_original_method = "58D1ADCDFA9509486623D4E556DE8E64", hash_generated_method = "8D2440B3A389921172A9D0E4CD21AF11")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_909370621 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_909370621 = NAME;
        varB4EAC82CA7396A68D541C85D26508E83_909370621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_909370621;
        // ---------- Original Method ----------
        //return NAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.992 -0400", hash_original_method = "F6A3921BF2DA3805D24A4DD375373A7E", hash_generated_method = "054967B84F5F3C7889638D5E37FC9DCA")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1277204976 = null; //Variable for return #1
        StringBuffer s = new StringBuffer();
        s.append(protocol);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1060968681 = (parameters != null && !parameters.isEmpty());
            s.append(SEMICOLON).append(parameters.encode());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1277204976 = s.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1277204976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277204976;
        // ---------- Original Method ----------
        //StringBuffer s = new StringBuffer();
        //s.append(protocol);
        //if (parameters != null && !parameters.isEmpty())
            //s.append(SEMICOLON).append(parameters.encode());
        //return s.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.992 -0400", hash_original_field = "E4C9B7DC021EE557504C75FFB2D6D7D6", hash_generated_field = "7D21FB644FECBA65363EF6F0D18662A5")

    private static final long serialVersionUID = -8903376965568297388L;
}

