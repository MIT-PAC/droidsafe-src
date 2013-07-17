package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.*;
import java.util.*;

public class DrmRightsManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.448 -0400", hash_original_method = "9CECCAD6D8D5F2E74B9B1C7CC1642036", hash_generated_method = "1CEF2C7E391438AE02A6D7E3E97F0D9F")
    protected  DrmRightsManager() {
        // ---------- Original Method ----------
    }

    
    public static synchronized DrmRightsManager getInstance() {
        if (singleton == null) {
            singleton = new DrmRightsManager();
        }
        return singleton;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.450 -0400", hash_original_method = "DFEBA1171CC4BD5C340A5F7D201F4250", hash_generated_method = "3F072A233DE6B983CC24E5610E375889")
    public synchronized DrmRights installRights(InputStream rightsData, int len, String mimeTypeStr) throws DrmException, IOException {
        addTaint(mimeTypeStr.getTaint());
        addTaint(len);
        addTaint(rightsData.getTaint());
        int mimeType = 0;
        if(DRM_MIMETYPE_RIGHTS_XML_STRING.equals(mimeTypeStr))        
        mimeType = DRM_MIMETYPE_RIGHTS_XML;
        else
        if(DRM_MIMETYPE_RIGHTS_WBXML_STRING.equals(mimeTypeStr))        
        mimeType = DRM_MIMETYPE_RIGHTS_WBXML;
        else
        if(DrmRawContent.DRM_MIMETYPE_MESSAGE_STRING.equals(mimeTypeStr))        
        mimeType = DRM_MIMETYPE_MESSAGE;
        else
        {
        IllegalArgumentException var13F5C139C73907345F278AF21520602B_1585517195 = new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");
        var13F5C139C73907345F278AF21520602B_1585517195.addTaint(taint);
        throw var13F5C139C73907345F278AF21520602B_1585517195;
        }
        if(len <= 0)        
        {
DrmRights var540C13E9E156B687226421B24F2DF178_168148645 =         null;
        var540C13E9E156B687226421B24F2DF178_168148645.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_168148645;
        }
        DrmRights rights = new DrmRights();
        int res = nativeInstallDrmRights(rightsData, len, mimeType, rights);
        if(JNI_DRM_FAILURE == res)        
        {
        DrmException varCC96BF76A49A973978EE1F14D83EE6A8_2138533814 = new DrmException("nativeInstallDrmRights() returned JNI_DRM_FAILURE");
        varCC96BF76A49A973978EE1F14D83EE6A8_2138533814.addTaint(taint);
        throw varCC96BF76A49A973978EE1F14D83EE6A8_2138533814;
        }
DrmRights var770D803EEC850C2A47B729548E6F300C_791650130 =         rights;
        var770D803EEC850C2A47B729548E6F300C_791650130.addTaint(taint);
        return var770D803EEC850C2A47B729548E6F300C_791650130;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.450 -0400", hash_original_method = "F869914CDBD46FC071FA033F543D25F0", hash_generated_method = "3ABACC7DD6F26C661EDF3391702A362A")
    public synchronized DrmRights queryRights(DrmRawContent content) {
        addTaint(content.getTaint());
        DrmRights rights = new DrmRights();
        int res = nativeQueryRights(content, rights);
        if(JNI_DRM_FAILURE == res)        
        {
DrmRights var540C13E9E156B687226421B24F2DF178_1663217019 =         null;
        var540C13E9E156B687226421B24F2DF178_1663217019.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1663217019;
        }
DrmRights var770D803EEC850C2A47B729548E6F300C_1218421887 =         rights;
        var770D803EEC850C2A47B729548E6F300C_1218421887.addTaint(taint);
        return var770D803EEC850C2A47B729548E6F300C_1218421887;
        // ---------- Original Method ----------
        //DrmRights rights = new DrmRights();
        //int res = nativeQueryRights(content, rights);
        //if (JNI_DRM_FAILURE == res)
            //return null;
        //return rights;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.453 -0400", hash_original_method = "2F13CE15153AB575E5C66B8C7F8BCB6B", hash_generated_method = "902E29C2ACB95D98B1A876BB53CDDD20")
    public synchronized List getRightsList() {
        List rightsList = new ArrayList();
        int num = nativeGetNumOfRights();
        if(JNI_DRM_FAILURE == num)        
        {
List var540C13E9E156B687226421B24F2DF178_1429039398 =         null;
        var540C13E9E156B687226421B24F2DF178_1429039398.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1429039398;
        }
        if(num > 0)        
        {
            DrmRights[] rightsArray = new DrmRights[num];
            int i;
for(i = 0;i < num;i++)
            rightsArray[i] = new DrmRights();
            num = nativeGetRightsList(rightsArray, num);
            if(JNI_DRM_FAILURE == num)            
            {
List var540C13E9E156B687226421B24F2DF178_888553239 =             null;
            var540C13E9E156B687226421B24F2DF178_888553239.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_888553239;
            }
for(i = 0;i < num;i++)
            rightsList.add(rightsArray[i]);
        } //End block
List var9AD584CC2B54A36DD742B42DE81DBB32_2004193536 =         rightsList;
        var9AD584CC2B54A36DD742B42DE81DBB32_2004193536.addTaint(taint);
        return var9AD584CC2B54A36DD742B42DE81DBB32_2004193536;
        // ---------- Original Method ----------
        //List rightsList = new ArrayList();
        //int num = nativeGetNumOfRights();
        //if (JNI_DRM_FAILURE == num)
            //return null;
        //if (num > 0) {
            //DrmRights[] rightsArray = new DrmRights[num];
            //int i;
            //for (i = 0; i < num; i++)
                //rightsArray[i] = new DrmRights();
            //num = nativeGetRightsList(rightsArray, num);
            //if (JNI_DRM_FAILURE == num)
                //return null;
            //for (i = 0; i < num; i++)
                //rightsList.add(rightsArray[i]);
        //}
        //return rightsList;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.454 -0400", hash_original_method = "017D692B38F8FD212CF524C82FCE2BD9", hash_generated_method = "217C2B5EB2E5F2AE6FCACA9CA4D6C2C2")
    public synchronized void deleteRights(DrmRights rights) {
        addTaint(rights.getTaint());
        int res = nativeDeleteRights(rights);
        if(JNI_DRM_FAILURE == res)        
        return;
        // ---------- Original Method ----------
        //int res = nativeDeleteRights(rights);
        //if (JNI_DRM_FAILURE == res)
            //return;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.455 -0400", hash_original_method = "4EFCC19418AEA2B988CE34DFC9464C6A", hash_generated_method = "974A4A53E193803BBD51EAA180EF84D5")
    private int nativeInstallDrmRights(InputStream data, int len, int mimeType, DrmRights rights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157207621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157207621;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.456 -0400", hash_original_method = "D2E0FD9FD256FCE483409E8A0B1A737B", hash_generated_method = "F0710546B2BE076743B651993E3B2480")
    private int nativeQueryRights(DrmRawContent content, DrmRights rights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923498601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923498601;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.456 -0400", hash_original_method = "53C2DF882AFDD7A7897768491F6FD437", hash_generated_method = "DCAEA6BBD908C96AD280ACBA0B813BC5")
    private int nativeGetNumOfRights() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980418511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980418511;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.456 -0400", hash_original_method = "D10F41EFD32E726343E3CA8A142B1A5C", hash_generated_method = "AF133CCEAF5CE2E99DEC1A2A0AE497D0")
    private int nativeGetRightsList(DrmRights[] rights, int numRights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815950260 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815950260;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.457 -0400", hash_original_method = "75A731730EAFA84E0B65F7039A32C61B", hash_generated_method = "8413A173FC099DE0F0EAEF774514A8A9")
    private int nativeDeleteRights(DrmRights rights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413173444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413173444;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.457 -0400", hash_original_field = "33E1D5E11AC02E2C7B261772A9AA8CEF", hash_generated_field = "1EAF9F8DECDC64797BB05E1A169CAC24")

    public static final String DRM_MIMETYPE_RIGHTS_XML_STRING = "application/vnd.oma.drm.rights+xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.457 -0400", hash_original_field = "089CA7F5F3FDBF361F9F62D51A329A1B", hash_generated_field = "BE36C549B145E602BDD829C5969968B5")

    public static final String DRM_MIMETYPE_RIGHTS_WBXML_STRING = "application/vnd.oma.drm.rights+wbxml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.457 -0400", hash_original_field = "41C3F1A0E23B1599F3DDE96CAD1233C7", hash_generated_field = "B106663AE8ED1953C5BF784F74A2A420")

    private static final int DRM_MIMETYPE_RIGHTS_XML = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.457 -0400", hash_original_field = "1C3599F07E370B9BB11C6D38CAF84CE8", hash_generated_field = "8E46F7773E206BB642294E13FBD439A6")

    private static final int DRM_MIMETYPE_RIGHTS_WBXML = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.457 -0400", hash_original_field = "645447E2174388024FD7F54546325361", hash_generated_field = "98083C2F2BCD6A089C4D9DF2D1E75981")

    private static final int DRM_MIMETYPE_MESSAGE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.457 -0400", hash_original_field = "F927EA5B26734A5B21BABCBBE2780573", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.458 -0400", hash_original_field = "8AA00AA09B306612E26D7EEB1735511B", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

    private static final int JNI_DRM_FAILURE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.458 -0400", hash_original_field = "8467BBAD621256E2A89EB44BB40F04A8", hash_generated_field = "B789093F93ED21BAFF0E4A55290D04C6")

    private static DrmRightsManager singleton = null;
    static {
        try {
            System.loadLibrary("drm1_jni");
        }
        catch (UnsatisfiedLinkError ule) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
    
}

