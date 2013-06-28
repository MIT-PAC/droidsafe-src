package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;

public class Warning extends SIPHeader implements WarningHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.977 -0400", hash_original_field = "C13367945D5D4C91047B3B50234AA7AB", hash_generated_field = "F5A70E4F98FA3F77B9B0CD95DEE2E30D")

    protected int code;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.977 -0400", hash_original_field = "B33AED8F3134996703DC39F9A7C95783", hash_generated_field = "14267456FD4CBBE9D66A8DE4A6C42A36")

    protected String agent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.977 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "66B33F01239E8E09E0B8D1D466F29BFA")

    protected String text;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.977 -0400", hash_original_method = "EC205AAA0E57D7457805C01D650D3D4C", hash_generated_method = "4BBA6FE432398CF7B15E3E65F123726B")
    public  Warning() {
        super(WARNING);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.978 -0400", hash_original_method = "F1B6F008CE79EB2FBE5188D2B8BB2F2C", hash_generated_method = "6A61BD818768483343BCE1B6BC145219")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_705789341 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_705789341 = text != null
            ? Integer.toString(code)
                + SP
                + agent
                + SP
                + DOUBLE_QUOTE
                + text
                + DOUBLE_QUOTE
            : Integer.toString(code) + SP + agent;
        varB4EAC82CA7396A68D541C85D26508E83_705789341.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705789341;
        // ---------- Original Method ----------
        //return text != null
            //? Integer.toString(code)
                //+ SP
                //+ agent
                //+ SP
                //+ DOUBLE_QUOTE
                //+ text
                //+ DOUBLE_QUOTE
            //: Integer.toString(code) + SP + agent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.978 -0400", hash_original_method = "0DCDBA7E30E559B2571A09070ED05380", hash_generated_method = "FFC54302418368DA1E41FE1D2D418141")
    public int getCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464857820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464857820;
        // ---------- Original Method ----------
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.979 -0400", hash_original_method = "7B2F86C2E403FA4426A7AF0306AE1B67", hash_generated_method = "031E64AD3BF50FF76C055EB726ADB840")
    public String getAgent() {
        String varB4EAC82CA7396A68D541C85D26508E83_518355566 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_518355566 = agent;
        varB4EAC82CA7396A68D541C85D26508E83_518355566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_518355566;
        // ---------- Original Method ----------
        //return agent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.979 -0400", hash_original_method = "C0F9B3C9D6FFAEB2F99491C721442157", hash_generated_method = "516DC96E7EE79D64340C679A085127AB")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_465976906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_465976906 = text;
        varB4EAC82CA7396A68D541C85D26508E83_465976906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_465976906;
        // ---------- Original Method ----------
        //return text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.980 -0400", hash_original_method = "741202B8F1CEFA0CCA05AB4A3FC24738", hash_generated_method = "31D212E5EF29FD1CCC704240FB7F030F")
    public void setCode(int code) throws InvalidArgumentException {
        {
            this.code = code;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "Code parameter in the Warning header is invalid: code="
                    + code);
        // ---------- Original Method ----------
        //if (code >99  && code < 1000) { 
            //this.code = code;
        //} else
            //throw new InvalidArgumentException(
                //"Code parameter in the Warning header is invalid: code="
                    //+ code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.980 -0400", hash_original_method = "25CC32B68A77A53B595C551260404BAA", hash_generated_method = "0AE30176A2C042C23F83F20B34F2A654")
    public void setAgent(String host) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the host parameter in the Warning header is null");
        {
            this.agent = host;
        } //End block
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException("the host parameter in the Warning header is null");
        //else {
            //this.agent = host;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.981 -0400", hash_original_method = "8DD43A4484C9753D191B662ECF9B8CD6", hash_generated_method = "1B3D01A069E0FCE32BE4580F74CBF798")
    public void setText(String text) throws ParseException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(
                "The text parameter in the Warning header is null",
                0);
        } //End block
        this.text = text;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new ParseException(
                //"The text parameter in the Warning header is null",
                //0);
        //} else
            //this.text = text;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.981 -0400", hash_original_field = "B9E067B1DFF38FD35FE190DEFEBC01C6", hash_generated_field = "04331AE451A81F964F3C29BAAEBC8E2A")

    private static final long serialVersionUID = -3433328864230783899L;
}

