package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.net.URL;
import java.security.cert.Certificate;

public class CodeSource implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.911 -0400", hash_original_method = "D4C876668FE9471607615AC9FAAE5380", hash_generated_method = "7A4F375DB1084AA2F86A797B96BD5566")
    public  CodeSource(URL location, Certificate[] certs) {
        addTaint(location.getTaint());
        addTaint(certs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.911 -0400", hash_original_method = "6BB9DB68AFF3AD3D92949D5AEF316C19", hash_generated_method = "BA16FDC6992BDF62BC56B03EDAB7EC87")
    public  CodeSource(URL location, CodeSigner[] signers) {
        addTaint(location.getTaint());
        addTaint(signers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.912 -0400", hash_original_method = "6020A065662221000E3F20D70138382C", hash_generated_method = "31F5418FD73BA1DAF8B014D122EBC297")
    public final Certificate[] getCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1193515812 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1193515812 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1193515812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1193515812;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.913 -0400", hash_original_method = "38815E69C10DF8AAA74DCF93B8EB81FB", hash_generated_method = "403B5F66E5A13C9D680C27F2DD7A2DC3")
    public final CodeSigner[] getCodeSigners() {
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_2144568324 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2144568324 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2144568324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2144568324;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.913 -0400", hash_original_method = "7F43974786C9B6766E0F06D3AFC89834", hash_generated_method = "EB362F0B261BA89140481B6916899AEC")
    public final URL getLocation() {
        URL varB4EAC82CA7396A68D541C85D26508E83_190840194 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_190840194 = null;
        varB4EAC82CA7396A68D541C85D26508E83_190840194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_190840194;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.913 -0400", hash_original_method = "4B9CE524AB17149E2583F1CD133D00E2", hash_generated_method = "0DC8D3FCD4428E123331B9969915E369")
    public boolean implies(CodeSource cs) {
        addTaint(cs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349559289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349559289;
        // ---------- Original Method ----------
        //return true;
    }

    
}

