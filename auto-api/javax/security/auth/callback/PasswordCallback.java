package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.Arrays;

public class PasswordCallback implements Callback, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.776 -0400", hash_original_field = "4AE35DBB42614D2429B7D6D181A950BB", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.776 -0400", hash_original_field = "34D9638C7D1B78E7942D447C721B97E1", hash_generated_field = "085E002B7F9684AE04B61B19556E3A7A")

    boolean echoOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.776 -0400", hash_original_field = "07E26BD19D43DD0987D334D6C67742DC", hash_generated_field = "F66C98CBF0A43E25F25A4C8C5C084787")

    private char[] inputPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.776 -0400", hash_original_method = "FF9C282CA0D3F4D89988C18610E5667F", hash_generated_method = "C99AB9D5A0AD4DAEF777C783481C13B5")
    public  PasswordCallback(String prompt, boolean echoOn) {
        setPrompt(prompt);
        this.echoOn = echoOn;
        addTaint(prompt.getTaint());
        // ---------- Original Method ----------
        //setPrompt(prompt);
        //this.echoOn = echoOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.776 -0400", hash_original_method = "3C861E594BCF1170EC69D71F98E7DC21", hash_generated_method = "4781F04A51EC267F75238B3F07C401CA")
    private void setPrompt(String prompt) throws IllegalArgumentException {
        {
            boolean varACACCA92E3E1C5825288AD8E673DCE66_1968739072 = (prompt == null || prompt.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid prompt");
            } //End block
        } //End collapsed parenthetic
        this.prompt = prompt;
        // ---------- Original Method ----------
        //if (prompt == null || prompt.length() == 0) {
            //throw new IllegalArgumentException("Invalid prompt");
        //}
        //this.prompt = prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.777 -0400", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "39781FD10F52EF196E6BCC756440A633")
    public String getPrompt() {
        String varB4EAC82CA7396A68D541C85D26508E83_1557250766 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1557250766 = prompt;
        varB4EAC82CA7396A68D541C85D26508E83_1557250766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1557250766;
        // ---------- Original Method ----------
        //return prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.777 -0400", hash_original_method = "A27AE4B1B247F3C75C8013A45B07AFAD", hash_generated_method = "4176186D21719A98C7C2E037E17BB229")
    public boolean isEchoOn() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_714035029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_714035029;
        // ---------- Original Method ----------
        //return echoOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.778 -0400", hash_original_method = "A602CEA65D3FCE1A9999A6860447F09F", hash_generated_method = "6CDDAFFDD76900A9EB906D4CEDA8866C")
    public void setPassword(char[] password) {
        {
            this.inputPassword = password;
        } //End block
        {
            inputPassword = new char[password.length];
            System.arraycopy(password, 0, inputPassword, 0, inputPassword.length);
        } //End block
        // ---------- Original Method ----------
        //if (password == null) {
            //this.inputPassword = password;
        //} else {
            //inputPassword = new char[password.length];
            //System.arraycopy(password, 0, inputPassword, 0, inputPassword.length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.778 -0400", hash_original_method = "5EC08C3E76624CC9F22EE28EB19509D9", hash_generated_method = "A2FB830C77AD8F56D7365B73B3A06636")
    public char[] getPassword() {
        {
            char[] tmp = new char[inputPassword.length];
            System.arraycopy(inputPassword, 0, tmp, 0, tmp.length);
        } //End block
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_2085980224 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_2085980224;
        // ---------- Original Method ----------
        //if (inputPassword != null) {
            //char[] tmp = new char[inputPassword.length];
            //System.arraycopy(inputPassword, 0, tmp, 0, tmp.length);
            //return tmp;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.779 -0400", hash_original_method = "C115B79B56D59F71CAFFFA3A677E976D", hash_generated_method = "BF44141C0C533F6BFE56CEB0714DE3A4")
    public void clearPassword() {
        {
            Arrays.fill(inputPassword, '\u0000');
        } //End block
        // ---------- Original Method ----------
        //if (inputPassword != null) {
            //Arrays.fill(inputPassword, '\u0000');
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.779 -0400", hash_original_field = "3CFBDCD2AF2072AC7FA08166D6E41399", hash_generated_field = "D3C30598DA322C32BB3F1988E72B00C5")

    private static final long serialVersionUID = 2267422647454909926L;
}

