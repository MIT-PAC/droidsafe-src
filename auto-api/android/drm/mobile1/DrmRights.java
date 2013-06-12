package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class DrmRights {
    public static final int DRM_PERMISSION_PLAY = 1;
    public static final int DRM_PERMISSION_DISPLAY = 2;
    public static final int DRM_PERMISSION_EXECUTE = 3;
    public static final int DRM_PERMISSION_PRINT = 4;
    private static final int JNI_DRM_SUCCESS = 0;
    private static final int JNI_DRM_FAILURE = -1;
    private String roId = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.860 -0400", hash_original_method = "C823F603778B510E6D7C1D7E58C253FF", hash_generated_method = "6ED530D23264665DE98F568213E20B15")
    @DSModeled(DSC.SAFE)
    public DrmRights() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.860 -0400", hash_original_method = "152D385AF6C62DBFBF9806B7902609F0", hash_generated_method = "D6ED791CB33DCAD2946F07E32394AEE0")
    @DSModeled(DSC.SAFE)
    public DrmConstraintInfo getConstraint(int permission) {
        dsTaint.addTaint(permission);
        DrmConstraintInfo c;
        c = new DrmConstraintInfo();
        int res;
        res = nativeGetConstraintInfo(permission, c);
        return (DrmConstraintInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DrmConstraintInfo c = new DrmConstraintInfo();
        //int res = nativeGetConstraintInfo(permission, c);
        //if (JNI_DRM_FAILURE == res)
            //return null;
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.860 -0400", hash_original_method = "C0A81B9ED58B964194A74C6FBD15C07F", hash_generated_method = "81C293D50D8554267CA353EDF3A2ED25")
    @DSModeled(DSC.SAFE)
    public boolean consumeRights(int permission) {
        dsTaint.addTaint(permission);
        int res;
        res = nativeConsumeRights(permission);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int res = nativeConsumeRights(permission);
        //if (JNI_DRM_FAILURE == res)
            //return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.860 -0400", hash_original_method = "38AB17DDC792736F5CB32D23FA6E92BF", hash_generated_method = "5C40A9B3C5248E245087D91F078B00C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetConstraintInfo(int permission, DrmConstraintInfo constraint) {
        dsTaint.addTaint(constraint.dsTaint);
        dsTaint.addTaint(permission);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.861 -0400", hash_original_method = "B7050C2592D973CE5B8DCBBE60AC7282", hash_generated_method = "8BF66F55869DBA627C79E100A1AB4B4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeConsumeRights(int permission) {
        dsTaint.addTaint(permission);
        return dsTaint.getTaintInt();
    }

    
    static {
        try {
            System.loadLibrary("drm1_jni");
        }
        catch (UnsatisfiedLinkError ule) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
    
}


