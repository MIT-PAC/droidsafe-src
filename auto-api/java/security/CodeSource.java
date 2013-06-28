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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.136 -0400", hash_original_method = "D4C876668FE9471607615AC9FAAE5380", hash_generated_method = "7A4F375DB1084AA2F86A797B96BD5566")
    public  CodeSource(URL location, Certificate[] certs) {
        addTaint(location.getTaint());
        addTaint(certs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.136 -0400", hash_original_method = "6BB9DB68AFF3AD3D92949D5AEF316C19", hash_generated_method = "BA16FDC6992BDF62BC56B03EDAB7EC87")
    public  CodeSource(URL location, CodeSigner[] signers) {
        addTaint(location.getTaint());
        addTaint(signers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.136 -0400", hash_original_method = "6020A065662221000E3F20D70138382C", hash_generated_method = "B3192394A377EBB8D45C36F5EE0793A1")
    public final Certificate[] getCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1329956850 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1329956850 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1329956850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1329956850;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.137 -0400", hash_original_method = "38815E69C10DF8AAA74DCF93B8EB81FB", hash_generated_method = "C9F42EBFE541421E0D9FB3621234C406")
    public final CodeSigner[] getCodeSigners() {
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_1313254383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1313254383 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1313254383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1313254383;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.137 -0400", hash_original_method = "7F43974786C9B6766E0F06D3AFC89834", hash_generated_method = "44F47912EFC202D32C02F301638D5D50")
    public final URL getLocation() {
        URL varB4EAC82CA7396A68D541C85D26508E83_323026204 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_323026204 = null;
        varB4EAC82CA7396A68D541C85D26508E83_323026204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_323026204;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.137 -0400", hash_original_method = "4B9CE524AB17149E2583F1CD133D00E2", hash_generated_method = "A0433CE29F19DFD6EC5FD49B3E4325E6")
    public boolean implies(CodeSource cs) {
        addTaint(cs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661114270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_661114270;
        // ---------- Original Method ----------
        //return true;
    }

    
}

