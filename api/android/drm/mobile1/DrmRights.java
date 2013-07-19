package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DrmRights {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.427 -0400", hash_original_field = "F9B547329FB20099DE7762080521F120", hash_generated_field = "DA0C8A6494BF372551AC2E66A8F01069")

    private String roId = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.427 -0400", hash_original_method = "C823F603778B510E6D7C1D7E58C253FF", hash_generated_method = "7747E3FF1838963B8DAE3D1FE5AF77B8")
    public  DrmRights() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.429 -0400", hash_original_method = "152D385AF6C62DBFBF9806B7902609F0", hash_generated_method = "AF1AEC75E62C16427C124C103C791116")
    public DrmConstraintInfo getConstraint(int permission) {
        addTaint(permission);
        DrmConstraintInfo c = new DrmConstraintInfo();
        int res = nativeGetConstraintInfo(permission, c);
        if(JNI_DRM_FAILURE == res)        
        {
DrmConstraintInfo var540C13E9E156B687226421B24F2DF178_197889759 =         null;
        var540C13E9E156B687226421B24F2DF178_197889759.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_197889759;
        }
DrmConstraintInfo var807FB10045EE51C06BDB74744A6714DF_1014936100 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1014936100.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1014936100;
        // ---------- Original Method ----------
        //DrmConstraintInfo c = new DrmConstraintInfo();
        //int res = nativeGetConstraintInfo(permission, c);
        //if (JNI_DRM_FAILURE == res)
            //return null;
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.430 -0400", hash_original_method = "C0A81B9ED58B964194A74C6FBD15C07F", hash_generated_method = "BD6841D5F4713671CBEC4EE7025C9F76")
    public boolean consumeRights(int permission) {
        addTaint(permission);
        int res = nativeConsumeRights(permission);
        if(JNI_DRM_FAILURE == res)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2018788220 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255078342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_255078342;
        }
        boolean varB326B5062B2F0E69046810717534CB09_1840652692 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185694461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185694461;
        // ---------- Original Method ----------
        //int res = nativeConsumeRights(permission);
        //if (JNI_DRM_FAILURE == res)
            //return false;
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.431 -0400", hash_original_method = "38AB17DDC792736F5CB32D23FA6E92BF", hash_generated_method = "24A3A59DACD9048A9B8DF9EACF7A73E4")
    private int nativeGetConstraintInfo(int permission, DrmConstraintInfo constraint) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861927379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861927379;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.431 -0400", hash_original_method = "B7050C2592D973CE5B8DCBBE60AC7282", hash_generated_method = "852539859B3A47FD85228F82DFB18B3E")
    private int nativeConsumeRights(int permission) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238647718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238647718;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.432 -0400", hash_original_field = "DE8FD0503A2FDB2AA7BE3D4E99B96CA6", hash_generated_field = "B09DC62ED5056D05FD7AAC60079335E1")

    public static final int DRM_PERMISSION_PLAY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.432 -0400", hash_original_field = "B3A9A50EE91559FB0469B90C99C00B8C", hash_generated_field = "BDEE5A85AE10A04DAF5DB8B90357B6CE")

    public static final int DRM_PERMISSION_DISPLAY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.432 -0400", hash_original_field = "7A5236715F6AA8EB0AD6E33C473751A9", hash_generated_field = "E9CE3DB78FAB9635A454D0B9C6A455C7")

    public static final int DRM_PERMISSION_EXECUTE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.432 -0400", hash_original_field = "04D3F454D04C84D8EF86A45901924D57", hash_generated_field = "2BAC2E6BE4A76929371D96DA2E18632F")

    public static final int DRM_PERMISSION_PRINT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.432 -0400", hash_original_field = "F927EA5B26734A5B21BABCBBE2780573", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.432 -0400", hash_original_field = "8AA00AA09B306612E26D7EEB1735511B", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

    private static final int JNI_DRM_FAILURE = -1;
    static {
        try {
            System.loadLibrary("drm1_jni");
        }
        catch (UnsatisfiedLinkError ule) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
    
}

