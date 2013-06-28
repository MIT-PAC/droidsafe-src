package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class SecureClassLoader extends ClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.681 -0400", hash_original_field = "CDA6120B02721B2C89DF90FE24C43375", hash_generated_field = "5AEEF9DE5247CD1DA3548B4951AB4FCC")

    private HashMap<CodeSource, ProtectionDomain> pds = new HashMap<CodeSource, ProtectionDomain>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.682 -0400", hash_original_method = "4B4D46642D8CC55D099820C8C7F949EC", hash_generated_method = "F33F32C5443B11E0B33E5408E6D01F7D")
    protected  SecureClassLoader() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.682 -0400", hash_original_method = "9D746C0AE16D6D5D82FB26506F642408", hash_generated_method = "602CAB949FBFE57951864ABE0A9400E5")
    protected  SecureClassLoader(ClassLoader parent) {
        super(parent);
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.682 -0400", hash_original_method = "687B8C8ED2D113CC62A09D76E8EA258D", hash_generated_method = "F0384D29B43361C850C9037511760C07")
    protected PermissionCollection getPermissions(CodeSource codesource) {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_238014864 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_238014864 = new Permissions();
        addTaint(codesource.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_238014864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_238014864;
        // ---------- Original Method ----------
        //return new Permissions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.683 -0400", hash_original_method = "40E81C2563CEEFA6E4058B73A14AC8A3", hash_generated_method = "49E0442F2CBA42CB7BB1FB0C7829ED5D")
    protected final Class<?> defineClass(String name, byte[] b, int off, int len,
            CodeSource cs) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_392990498 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_392990498 = cs == null ? defineClass(name, b, off, len) : defineClass(name,
                b, off, len, getPD(cs));
        addTaint(name.getTaint());
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_392990498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_392990498;
        // ---------- Original Method ----------
        //return cs == null ? defineClass(name, b, off, len) : defineClass(name,
                //b, off, len, getPD(cs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.683 -0400", hash_original_method = "7247AFD090E75B25728578AC141286D1", hash_generated_method = "75995496B8C7EC6F8FEA4963342FA830")
    protected final Class<?> defineClass(String name, ByteBuffer b, CodeSource cs) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1749029130 = null; //Variable for return #1
        byte[] data = b.array();
        varB4EAC82CA7396A68D541C85D26508E83_1749029130 = cs == null ? defineClass(name, data, 0, data.length)
                : defineClass(name, data, 0, data.length, getPD(cs));
        addTaint(name.getTaint());
        addTaint(b.getTaint());
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1749029130.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749029130;
        // ---------- Original Method ----------
        //byte[] data = b.array();
        //return cs == null ? defineClass(name, data, 0, data.length)
                //: defineClass(name, data, 0, data.length, getPD(cs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.684 -0400", hash_original_method = "281D0E5C46C64A601A9A047C7C498882", hash_generated_method = "8F6CA512A3EA68D8E6D97011630BF19D")
    private ProtectionDomain getPD(CodeSource cs) {
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_20331092 = null; //Variable for return #1
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_1091167756 = null; //Variable for return #2
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_1693566770 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_20331092 = null;
        } //End block
        ProtectionDomain pd;
        {
            {
                boolean varB287AEF521A3F0E4AFDB53B05113D42B_1700741866 = ((pd = pds.get(cs)) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1091167756 = pd;
                } //End block
            } //End collapsed parenthetic
            PermissionCollection perms = getPermissions(cs);
            pd = new ProtectionDomain(cs, perms, this, null);
            pds.put(cs, pd);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1693566770 = pd;
        addTaint(cs.getTaint());
        ProtectionDomain varA7E53CE21691AB073D9660D615818899_1649910934; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1649910934 = varB4EAC82CA7396A68D541C85D26508E83_20331092;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1649910934 = varB4EAC82CA7396A68D541C85D26508E83_1091167756;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1649910934 = varB4EAC82CA7396A68D541C85D26508E83_1693566770;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1649910934.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1649910934;
        // ---------- Original Method ----------
        //if (cs == null) {
            //return null;
        //}
        //ProtectionDomain pd;
        //synchronized (pds) {
            //if ((pd = pds.get(cs)) != null) {
                //return pd;
            //}
            //PermissionCollection perms = getPermissions(cs);
            //pd = new ProtectionDomain(cs, perms, this, null);
            //pds.put(cs, pd);
        //}
        //return pd;
    }

    
}

