package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.util.Arrays;

public class PasswordCallback implements Callback, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.006 -0400", hash_original_field = "4AE35DBB42614D2429B7D6D181A950BB", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.006 -0400", hash_original_field = "34D9638C7D1B78E7942D447C721B97E1", hash_generated_field = "085E002B7F9684AE04B61B19556E3A7A")

    boolean echoOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.006 -0400", hash_original_field = "07E26BD19D43DD0987D334D6C67742DC", hash_generated_field = "F66C98CBF0A43E25F25A4C8C5C084787")

    private char[] inputPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.007 -0400", hash_original_method = "FF9C282CA0D3F4D89988C18610E5667F", hash_generated_method = "2DC202BDD00C9FC4676F34D1DFBC6A5A")
    public  PasswordCallback(String prompt, boolean echoOn) {
        addTaint(prompt.getTaint());
        setPrompt(prompt);
        this.echoOn = echoOn;
        // ---------- Original Method ----------
        //setPrompt(prompt);
        //this.echoOn = echoOn;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.008 -0400", hash_original_method = "3C861E594BCF1170EC69D71F98E7DC21", hash_generated_method = "3D7C63B0A337986962084DDDA2CA4F52")
    private void setPrompt(String prompt) throws IllegalArgumentException {
    if(prompt == null || prompt.length() == 0)        
        {
            IllegalArgumentException var9C7DF5DEE6C51CD9AF5DC49C6F784BE1_1106240745 = new IllegalArgumentException("Invalid prompt");
            var9C7DF5DEE6C51CD9AF5DC49C6F784BE1_1106240745.addTaint(taint);
            throw var9C7DF5DEE6C51CD9AF5DC49C6F784BE1_1106240745;
        } //End block
        this.prompt = prompt;
        // ---------- Original Method ----------
        //if (prompt == null || prompt.length() == 0) {
            //throw new IllegalArgumentException("Invalid prompt");
        //}
        //this.prompt = prompt;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.008 -0400", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "9A9BFB7C0B89F10E633FA9F76DCBDD58")
    public String getPrompt() {
String varE4FB060A074D4292A4C6C936BB93312C_1415375218 =         prompt;
        varE4FB060A074D4292A4C6C936BB93312C_1415375218.addTaint(taint);
        return varE4FB060A074D4292A4C6C936BB93312C_1415375218;
        // ---------- Original Method ----------
        //return prompt;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.008 -0400", hash_original_method = "A27AE4B1B247F3C75C8013A45B07AFAD", hash_generated_method = "0A9FB1F3537F4A39F615D4E456A2C07D")
    public boolean isEchoOn() {
        boolean var34D9638C7D1B78E7942D447C721B97E1_1945511141 = (echoOn);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153884138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_153884138;
        // ---------- Original Method ----------
        //return echoOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.009 -0400", hash_original_method = "A602CEA65D3FCE1A9999A6860447F09F", hash_generated_method = "CE313029BCA82AE20353D370D081B811")
    public void setPassword(char[] password) {
    if(password == null)        
        {
            this.inputPassword = password;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.021 -0400", hash_original_method = "5EC08C3E76624CC9F22EE28EB19509D9", hash_generated_method = "121EB35ADC9EBCA9C4CAD003851F9D65")
    public char[] getPassword() {
    if(inputPassword != null)        
        {
            char[] tmp = new char[inputPassword.length];
            System.arraycopy(inputPassword, 0, tmp, 0, tmp.length);
            char[] varFA816EDB83E95BF0C8DA580BDFD491EF_247579037 = (tmp);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_602191349 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_602191349;
        } //End block
        char[] var37A6259CC0C1DAE299A7866489DFF0BD_303467467 = (null);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1529331429 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1529331429;
        // ---------- Original Method ----------
        //if (inputPassword != null) {
            //char[] tmp = new char[inputPassword.length];
            //System.arraycopy(inputPassword, 0, tmp, 0, tmp.length);
            //return tmp;
        //}
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.021 -0400", hash_original_method = "C115B79B56D59F71CAFFFA3A677E976D", hash_generated_method = "3D63DBB9F303C4EB0A15E157DA32C4C7")
    public void clearPassword() {
    if(inputPassword != null)        
        {
            Arrays.fill(inputPassword, '\u0000');
        } //End block
        // ---------- Original Method ----------
        //if (inputPassword != null) {
            //Arrays.fill(inputPassword, '\u0000');
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.021 -0400", hash_original_field = "3CFBDCD2AF2072AC7FA08166D6E41399", hash_generated_field = "D3C30598DA322C32BB3F1988E72B00C5")

    private static final long serialVersionUID = 2267422647454909926L;
}

