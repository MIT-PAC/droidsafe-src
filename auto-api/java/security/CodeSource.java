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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.132 -0400", hash_original_method = "D4C876668FE9471607615AC9FAAE5380", hash_generated_method = "7A4F375DB1084AA2F86A797B96BD5566")
    public  CodeSource(URL location, Certificate[] certs) {
        addTaint(location.getTaint());
        addTaint(certs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.133 -0400", hash_original_method = "6BB9DB68AFF3AD3D92949D5AEF316C19", hash_generated_method = "BA16FDC6992BDF62BC56B03EDAB7EC87")
    public  CodeSource(URL location, CodeSigner[] signers) {
        addTaint(location.getTaint());
        addTaint(signers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.134 -0400", hash_original_method = "6020A065662221000E3F20D70138382C", hash_generated_method = "B29F5045323D37BEBD2D658BE0A119BC")
    public final Certificate[] getCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_84801351 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_84801351 = null;
        varB4EAC82CA7396A68D541C85D26508E83_84801351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_84801351;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.135 -0400", hash_original_method = "38815E69C10DF8AAA74DCF93B8EB81FB", hash_generated_method = "A6F0D08C2388E1A4E3CBF48D65D76F4D")
    public final CodeSigner[] getCodeSigners() {
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_1244806072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1244806072 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1244806072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1244806072;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.135 -0400", hash_original_method = "7F43974786C9B6766E0F06D3AFC89834", hash_generated_method = "2FE7719384E1506482B004D91411B271")
    public final URL getLocation() {
        URL varB4EAC82CA7396A68D541C85D26508E83_2110668391 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2110668391 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2110668391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2110668391;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.135 -0400", hash_original_method = "4B9CE524AB17149E2583F1CD133D00E2", hash_generated_method = "230DCCF338435C38D88B7CADA3055E0B")
    public boolean implies(CodeSource cs) {
        addTaint(cs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089531278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089531278;
        // ---------- Original Method ----------
        //return true;
    }

    
}

