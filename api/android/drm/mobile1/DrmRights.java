package android.drm.mobile1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DrmRights {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.565 -0400", hash_original_field = "F9B547329FB20099DE7762080521F120", hash_generated_field = "DA0C8A6494BF372551AC2E66A8F01069")

    private String roId = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.566 -0400", hash_original_method = "C823F603778B510E6D7C1D7E58C253FF", hash_generated_method = "7747E3FF1838963B8DAE3D1FE5AF77B8")
    public  DrmRights() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.567 -0400", hash_original_method = "152D385AF6C62DBFBF9806B7902609F0", hash_generated_method = "DF4FC01513851270149CAB545038FFBC")
    public DrmConstraintInfo getConstraint(int permission) {
        addTaint(permission);
        DrmConstraintInfo c = new DrmConstraintInfo();
        int res = nativeGetConstraintInfo(permission, c);
    if(JNI_DRM_FAILURE == res)        
        {
DrmConstraintInfo var540C13E9E156B687226421B24F2DF178_589366723 =         null;
        var540C13E9E156B687226421B24F2DF178_589366723.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_589366723;
        }
DrmConstraintInfo var807FB10045EE51C06BDB74744A6714DF_834153785 =         c;
        var807FB10045EE51C06BDB74744A6714DF_834153785.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_834153785;
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.567 -0400", hash_original_method = "C0A81B9ED58B964194A74C6FBD15C07F", hash_generated_method = "6432687EF0D6C92CFC823FC2BCAF03CE")
    public boolean consumeRights(int permission) {
        addTaint(permission);
        int res = nativeConsumeRights(permission);
    if(JNI_DRM_FAILURE == res)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1656090785 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736526922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736526922;
        }
        boolean varB326B5062B2F0E69046810717534CB09_199511659 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658382495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658382495;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.568 -0400", hash_original_method = "38AB17DDC792736F5CB32D23FA6E92BF", hash_generated_method = "B9AD340E4FF305C666F3C04A624D445B")
    private int nativeGetConstraintInfo(int permission, DrmConstraintInfo constraint) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699849174 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699849174;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.569 -0400", hash_original_method = "B7050C2592D973CE5B8DCBBE60AC7282", hash_generated_method = "140B950E025F77C8C82EE1B1CE506B25")
    private int nativeConsumeRights(int permission) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747202387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747202387;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.569 -0400", hash_original_field = "DE8FD0503A2FDB2AA7BE3D4E99B96CA6", hash_generated_field = "B09DC62ED5056D05FD7AAC60079335E1")

    public static final int DRM_PERMISSION_PLAY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.569 -0400", hash_original_field = "B3A9A50EE91559FB0469B90C99C00B8C", hash_generated_field = "BDEE5A85AE10A04DAF5DB8B90357B6CE")

    public static final int DRM_PERMISSION_DISPLAY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.569 -0400", hash_original_field = "7A5236715F6AA8EB0AD6E33C473751A9", hash_generated_field = "E9CE3DB78FAB9635A454D0B9C6A455C7")

    public static final int DRM_PERMISSION_EXECUTE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.569 -0400", hash_original_field = "04D3F454D04C84D8EF86A45901924D57", hash_generated_field = "2BAC2E6BE4A76929371D96DA2E18632F")

    public static final int DRM_PERMISSION_PRINT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.570 -0400", hash_original_field = "F927EA5B26734A5B21BABCBBE2780573", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.570 -0400", hash_original_field = "8AA00AA09B306612E26D7EEB1735511B", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

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

