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
    private String prompt;
    boolean echoOn;
    private char[] inputPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.127 -0400", hash_original_method = "FF9C282CA0D3F4D89988C18610E5667F", hash_generated_method = "B3F09022D081357E16BE2B31974A2168")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PasswordCallback(String prompt, boolean echoOn) {
        dsTaint.addTaint(echoOn);
        dsTaint.addTaint(prompt);
        setPrompt(prompt);
        // ---------- Original Method ----------
        //setPrompt(prompt);
        //this.echoOn = echoOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.128 -0400", hash_original_method = "3C861E594BCF1170EC69D71F98E7DC21", hash_generated_method = "8BB911A5874C73FC8CF4CF0E3CAD6983")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPrompt(String prompt) throws IllegalArgumentException {
        dsTaint.addTaint(prompt);
        {
            boolean varACACCA92E3E1C5825288AD8E673DCE66_1509473805 = (prompt == null || prompt.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid prompt");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (prompt == null || prompt.length() == 0) {
            //throw new IllegalArgumentException("Invalid prompt");
        //}
        //this.prompt = prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.129 -0400", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "015B5A54E3EF61A9400EF73396C77EA0")
    @DSModeled(DSC.SAFE)
    public String getPrompt() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.129 -0400", hash_original_method = "A27AE4B1B247F3C75C8013A45B07AFAD", hash_generated_method = "2F647B3953C4143162741DBEB2F9CC5C")
    @DSModeled(DSC.SAFE)
    public boolean isEchoOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return echoOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.130 -0400", hash_original_method = "A602CEA65D3FCE1A9999A6860447F09F", hash_generated_method = "D8D7EAB88B2A64375403D97994A3EB50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPassword(char[] password) {
        dsTaint.addTaint(password[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.130 -0400", hash_original_method = "5EC08C3E76624CC9F22EE28EB19509D9", hash_generated_method = "5A319D6AA62034DC8725EBF701713BAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] getPassword() {
        {
            char[] tmp;
            tmp = new char[inputPassword.length];
            System.arraycopy(inputPassword, 0, tmp, 0, tmp.length);
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //if (inputPassword != null) {
            //char[] tmp = new char[inputPassword.length];
            //System.arraycopy(inputPassword, 0, tmp, 0, tmp.length);
            //return tmp;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.130 -0400", hash_original_method = "C115B79B56D59F71CAFFFA3A677E976D", hash_generated_method = "BF44141C0C533F6BFE56CEB0714DE3A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearPassword() {
        {
            Arrays.fill(inputPassword, '\u0000');
        } //End block
        // ---------- Original Method ----------
        //if (inputPassword != null) {
            //Arrays.fill(inputPassword, '\u0000');
        //}
    }

    
    private static final long serialVersionUID = 2267422647454909926L;
}

