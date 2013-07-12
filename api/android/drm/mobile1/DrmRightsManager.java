package android.drm.mobile1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.*;
import java.util.*;

public class DrmRightsManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.594 -0400", hash_original_method = "9CECCAD6D8D5F2E74B9B1C7CC1642036", hash_generated_method = "1CEF2C7E391438AE02A6D7E3E97F0D9F")
    protected  DrmRightsManager() {
        
    }

    
        public static synchronized DrmRightsManager getInstance() {
        if (singleton == null) {
            singleton = new DrmRightsManager();
        }
        return singleton;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.602 -0400", hash_original_method = "DFEBA1171CC4BD5C340A5F7D201F4250", hash_generated_method = "88A67A797715AB82D07C186EF19C2899")
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
        IllegalArgumentException var13F5C139C73907345F278AF21520602B_1724980532 = new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");
        var13F5C139C73907345F278AF21520602B_1724980532.addTaint(taint);
        throw var13F5C139C73907345F278AF21520602B_1724980532;
        }
    if(len <= 0)        
        {
DrmRights var540C13E9E156B687226421B24F2DF178_1607948041 =         null;
        var540C13E9E156B687226421B24F2DF178_1607948041.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1607948041;
        }
        DrmRights rights = new DrmRights();
        int res = nativeInstallDrmRights(rightsData, len, mimeType, rights);
    if(JNI_DRM_FAILURE == res)        
        {
        DrmException varCC96BF76A49A973978EE1F14D83EE6A8_1149535891 = new DrmException("nativeInstallDrmRights() returned JNI_DRM_FAILURE");
        varCC96BF76A49A973978EE1F14D83EE6A8_1149535891.addTaint(taint);
        throw varCC96BF76A49A973978EE1F14D83EE6A8_1149535891;
        }
DrmRights var770D803EEC850C2A47B729548E6F300C_1580863840 =         rights;
        var770D803EEC850C2A47B729548E6F300C_1580863840.addTaint(taint);
        return var770D803EEC850C2A47B729548E6F300C_1580863840;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.603 -0400", hash_original_method = "F869914CDBD46FC071FA033F543D25F0", hash_generated_method = "D181B014F5BE9BB184522076804032A0")
    public synchronized DrmRights queryRights(DrmRawContent content) {
        addTaint(content.getTaint());
        DrmRights rights = new DrmRights();
        int res = nativeQueryRights(content, rights);
    if(JNI_DRM_FAILURE == res)        
        {
DrmRights var540C13E9E156B687226421B24F2DF178_814009167 =         null;
        var540C13E9E156B687226421B24F2DF178_814009167.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_814009167;
        }
DrmRights var770D803EEC850C2A47B729548E6F300C_1392183814 =         rights;
        var770D803EEC850C2A47B729548E6F300C_1392183814.addTaint(taint);
        return var770D803EEC850C2A47B729548E6F300C_1392183814;
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.605 -0400", hash_original_method = "2F13CE15153AB575E5C66B8C7F8BCB6B", hash_generated_method = "3076C255D5171D4ADC5188934AD7C929")
    public synchronized List getRightsList() {
        List rightsList = new ArrayList();
        int num = nativeGetNumOfRights();
    if(JNI_DRM_FAILURE == num)        
        {
List var540C13E9E156B687226421B24F2DF178_451481425 =         null;
        var540C13E9E156B687226421B24F2DF178_451481425.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_451481425;
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
List var540C13E9E156B687226421B24F2DF178_1333975915 =             null;
            var540C13E9E156B687226421B24F2DF178_1333975915.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1333975915;
            }
for(i = 0;i < num;i++)
            rightsList.add(rightsArray[i]);
        } 
List var9AD584CC2B54A36DD742B42DE81DBB32_561150146 =         rightsList;
        var9AD584CC2B54A36DD742B42DE81DBB32_561150146.addTaint(taint);
        return var9AD584CC2B54A36DD742B42DE81DBB32_561150146;
        
        
        
        
            
        
            
            
            
                
            
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.607 -0400", hash_original_method = "017D692B38F8FD212CF524C82FCE2BD9", hash_generated_method = "217C2B5EB2E5F2AE6FCACA9CA4D6C2C2")
    public synchronized void deleteRights(DrmRights rights) {
        addTaint(rights.getTaint());
        int res = nativeDeleteRights(rights);
    if(JNI_DRM_FAILURE == res)        
        return;
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.608 -0400", hash_original_method = "4EFCC19418AEA2B988CE34DFC9464C6A", hash_generated_method = "B873EBD2223C20FD1E9D57B4192C6E32")
    private int nativeInstallDrmRights(InputStream data, int len, int mimeType, DrmRights rights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1274044244 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1274044244;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.609 -0400", hash_original_method = "D2E0FD9FD256FCE483409E8A0B1A737B", hash_generated_method = "3D8DC35378491975C1B05BF8750C6608")
    private int nativeQueryRights(DrmRawContent content, DrmRights rights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90511707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90511707;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.609 -0400", hash_original_method = "53C2DF882AFDD7A7897768491F6FD437", hash_generated_method = "F082C4460425858DA36B229E5859F493")
    private int nativeGetNumOfRights() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975170364 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975170364;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.610 -0400", hash_original_method = "D10F41EFD32E726343E3CA8A142B1A5C", hash_generated_method = "208677EB5A279740F0802A1F8BE149BC")
    private int nativeGetRightsList(DrmRights[] rights, int numRights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926767429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926767429;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.610 -0400", hash_original_method = "75A731730EAFA84E0B65F7039A32C61B", hash_generated_method = "B69C23F210D4759E838CFE47CA3AA9CC")
    private int nativeDeleteRights(DrmRights rights) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386163308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386163308;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.610 -0400", hash_original_field = "33E1D5E11AC02E2C7B261772A9AA8CEF", hash_generated_field = "1EAF9F8DECDC64797BB05E1A169CAC24")

    public static final String DRM_MIMETYPE_RIGHTS_XML_STRING = "application/vnd.oma.drm.rights+xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.611 -0400", hash_original_field = "089CA7F5F3FDBF361F9F62D51A329A1B", hash_generated_field = "BE36C549B145E602BDD829C5969968B5")

    public static final String DRM_MIMETYPE_RIGHTS_WBXML_STRING = "application/vnd.oma.drm.rights+wbxml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.611 -0400", hash_original_field = "41C3F1A0E23B1599F3DDE96CAD1233C7", hash_generated_field = "B106663AE8ED1953C5BF784F74A2A420")

    private static final int DRM_MIMETYPE_RIGHTS_XML = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.611 -0400", hash_original_field = "1C3599F07E370B9BB11C6D38CAF84CE8", hash_generated_field = "8E46F7773E206BB642294E13FBD439A6")

    private static final int DRM_MIMETYPE_RIGHTS_WBXML = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.611 -0400", hash_original_field = "645447E2174388024FD7F54546325361", hash_generated_field = "98083C2F2BCD6A089C4D9DF2D1E75981")

    private static final int DRM_MIMETYPE_MESSAGE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.611 -0400", hash_original_field = "F927EA5B26734A5B21BABCBBE2780573", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.611 -0400", hash_original_field = "8AA00AA09B306612E26D7EEB1735511B", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

    private static final int JNI_DRM_FAILURE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.611 -0400", hash_original_field = "8467BBAD621256E2A89EB44BB40F04A8", hash_generated_field = "B789093F93ED21BAFF0E4A55290D04C6")

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

