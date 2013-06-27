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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.152 -0400", hash_original_field = "CDA6120B02721B2C89DF90FE24C43375", hash_generated_field = "5AEEF9DE5247CD1DA3548B4951AB4FCC")

    private HashMap<CodeSource, ProtectionDomain> pds = new HashMap<CodeSource, ProtectionDomain>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.154 -0400", hash_original_method = "4B4D46642D8CC55D099820C8C7F949EC", hash_generated_method = "F33F32C5443B11E0B33E5408E6D01F7D")
    protected  SecureClassLoader() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.154 -0400", hash_original_method = "9D746C0AE16D6D5D82FB26506F642408", hash_generated_method = "602CAB949FBFE57951864ABE0A9400E5")
    protected  SecureClassLoader(ClassLoader parent) {
        super(parent);
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.155 -0400", hash_original_method = "687B8C8ED2D113CC62A09D76E8EA258D", hash_generated_method = "24D592347D188613150D6B7926AE2EE9")
    protected PermissionCollection getPermissions(CodeSource codesource) {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_1438195313 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1438195313 = new Permissions();
        addTaint(codesource.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1438195313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1438195313;
        // ---------- Original Method ----------
        //return new Permissions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.166 -0400", hash_original_method = "40E81C2563CEEFA6E4058B73A14AC8A3", hash_generated_method = "AE5A0DCA76FA2DD0E88E31E5F85F455C")
    protected final Class<?> defineClass(String name, byte[] b, int off, int len,
            CodeSource cs) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1752948517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1752948517 = cs == null ? defineClass(name, b, off, len) : defineClass(name,
                b, off, len, getPD(cs));
        addTaint(name.getTaint());
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1752948517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1752948517;
        // ---------- Original Method ----------
        //return cs == null ? defineClass(name, b, off, len) : defineClass(name,
                //b, off, len, getPD(cs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.166 -0400", hash_original_method = "7247AFD090E75B25728578AC141286D1", hash_generated_method = "5AC4A7E1575AEF66DA5F53C0C9E4E0F6")
    protected final Class<?> defineClass(String name, ByteBuffer b, CodeSource cs) {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1584991675 = null; //Variable for return #1
        byte[] data;
        data = b.array();
        varB4EAC82CA7396A68D541C85D26508E83_1584991675 = cs == null ? defineClass(name, data, 0, data.length)
                : defineClass(name, data, 0, data.length, getPD(cs));
        addTaint(name.getTaint());
        addTaint(b.getTaint());
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1584991675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1584991675;
        // ---------- Original Method ----------
        //byte[] data = b.array();
        //return cs == null ? defineClass(name, data, 0, data.length)
                //: defineClass(name, data, 0, data.length, getPD(cs));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.167 -0400", hash_original_method = "281D0E5C46C64A601A9A047C7C498882", hash_generated_method = "53D67A2286CEEC2DCDE1D743BCE817F5")
    private ProtectionDomain getPD(CodeSource cs) {
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_2119348414 = null; //Variable for return #1
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_2131187994 = null; //Variable for return #2
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_837807571 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_2119348414 = null;
        } //End block
        ProtectionDomain pd;
        {
            {
                boolean varB287AEF521A3F0E4AFDB53B05113D42B_1872794729 = ((pd = pds.get(cs)) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2131187994 = pd;
                } //End block
            } //End collapsed parenthetic
            PermissionCollection perms;
            perms = getPermissions(cs);
            pd = new ProtectionDomain(cs, perms, this, null);
            pds.put(cs, pd);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_837807571 = pd;
        addTaint(cs.getTaint());
        ProtectionDomain varA7E53CE21691AB073D9660D615818899_359657060; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_359657060 = varB4EAC82CA7396A68D541C85D26508E83_2119348414;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_359657060 = varB4EAC82CA7396A68D541C85D26508E83_2131187994;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_359657060 = varB4EAC82CA7396A68D541C85D26508E83_837807571;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_359657060.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_359657060;
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

