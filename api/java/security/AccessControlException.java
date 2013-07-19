package java.security;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AccessControlException extends SecurityException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.727 -0400", hash_original_field = "CA659200663CF654DC4410ED494451EE", hash_generated_field = "0D97B5BAB4B6DEEFD11C532A3D968D06")

    private Permission perm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.727 -0400", hash_original_method = "A915208612B5792FCAB4EB90528BDE0E", hash_generated_method = "60BF9D6410DA7631A4C4D7B6548393BD")
    public  AccessControlException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.728 -0400", hash_original_method = "A181D272E1BB95B67E0A8B120C2E59F9", hash_generated_method = "D2F1C6A970BF1F841211E76350DFA9AB")
    public  AccessControlException(String message, Permission perm) {
        super(message);
        addTaint(message.getTaint());
        this.perm = perm;
        // ---------- Original Method ----------
        //this.perm = perm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.728 -0400", hash_original_method = "DFDCEBDA71EECDB1948D7EAD61470F05", hash_generated_method = "5F9AFD01F06D08879B49A03F8D49E834")
    public Permission getPermission() {
Permission var768916ECB5B80042EF41FFF6B22D9A06_103909434 =         perm;
        var768916ECB5B80042EF41FFF6B22D9A06_103909434.addTaint(taint);
        return var768916ECB5B80042EF41FFF6B22D9A06_103909434;
        // ---------- Original Method ----------
        //return perm;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.729 -0400", hash_original_field = "EBFCD6A160C456AB04995295838A0FCE", hash_generated_field = "4AA6B8D54659D529BB431D0B0283E12C")

    private static final long serialVersionUID = 5138225684096988535L;
}

