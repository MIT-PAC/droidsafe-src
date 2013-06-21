package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class PasswordAuthentication {
    private String userName;
    private char[] password;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.011 -0400", hash_original_method = "5D7214C35F0B8EFCD4776395D10A0F27", hash_generated_method = "DCF729D40CEB3E1B578A5C04176A51CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PasswordAuthentication(String userName, char[] password) {
        dsTaint.addTaint(userName);
        dsTaint.addTaint(password[0]);
        this.password = password.clone();
        // ---------- Original Method ----------
        //this.userName = userName;
        //this.password = password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.011 -0400", hash_original_method = "79A6CAB64FA4B390A39CA60FAD9B839D", hash_generated_method = "BFBCD1089F436F0428402AC3B3DE2A6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] getPassword() {
        char[] var69A284DF0CEA33951D475A52924F7393_1148653830 = (password.clone());
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return password.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.011 -0400", hash_original_method = "AE8C8ADC981355D9DAA86F7D72E53644", hash_generated_method = "D58461FBC21012294492751B39E79991")
    @DSModeled(DSC.SAFE)
    public String getUserName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return userName;
    }

    
}

