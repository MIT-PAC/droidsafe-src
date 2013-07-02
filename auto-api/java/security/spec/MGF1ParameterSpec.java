package java.security.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class MGF1ParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.099 -0400", hash_original_field = "77C63DEF22F4DDAC72D34C48EA710C30", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private String mdName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.100 -0400", hash_original_method = "D3C3EAC31B08596AB735332742664A5B", hash_generated_method = "660BCC5A357F3BF90980691E44268F2E")
    public  MGF1ParameterSpec(String mdName) {
        this.mdName = mdName;
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mdName == null");
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.101 -0400", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "8108BF1B9AB5D71E18A1CED160C67AAA")
    public String getDigestAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1160475775 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1160475775 = mdName;
        varB4EAC82CA7396A68D541C85D26508E83_1160475775.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1160475775;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.101 -0400", hash_original_field = "208892F609BFEA14FBEB3E3672A3B212", hash_generated_field = "BFB08E237C9505534F2E92030BD73DDC")

    public static final MGF1ParameterSpec SHA1 =
        new MGF1ParameterSpec("SHA-1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.101 -0400", hash_original_field = "0A5AAFB5D52DD58429AEB24A3EFA1247", hash_generated_field = "D057F24800CD8427CC225CA34AE84819")

    public static final MGF1ParameterSpec SHA256 =
        new MGF1ParameterSpec("SHA-256");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.101 -0400", hash_original_field = "BCDB4D47591DD0E81874BE0BB4223083", hash_generated_field = "5A063E49D9C9031786762780E1DD8C95")

    public static final MGF1ParameterSpec SHA384 =
        new MGF1ParameterSpec("SHA-384");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.101 -0400", hash_original_field = "4D785B5032F83430EC9D9D0834380F92", hash_generated_field = "5C7C155C8D3D2252E2FDF04D3F5A55B9")

    public static final MGF1ParameterSpec SHA512 =
        new MGF1ParameterSpec("SHA-512");
}

