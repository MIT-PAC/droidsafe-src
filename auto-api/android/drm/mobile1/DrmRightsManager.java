package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.*;
import java.util.*;

public class DrmRightsManager {
    public static final String DRM_MIMETYPE_RIGHTS_XML_STRING = "application/vnd.oma.drm.rights+xml";
    public static final String DRM_MIMETYPE_RIGHTS_WBXML_STRING = "application/vnd.oma.drm.rights+wbxml";
    private static final int DRM_MIMETYPE_RIGHTS_XML = 3;
    private static final int DRM_MIMETYPE_RIGHTS_WBXML = 4;
    private static final int DRM_MIMETYPE_MESSAGE = 1;
    private static final int JNI_DRM_SUCCESS = 0;
    private static final int JNI_DRM_FAILURE = -1;
    private static DrmRightsManager singleton = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.866 -0400", hash_original_method = "9CECCAD6D8D5F2E74B9B1C7CC1642036", hash_generated_method = "92A2C237627FFE3FC7CE51AC588D17F1")
    @DSModeled(DSC.SAFE)
    protected DrmRightsManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.866 -0400", hash_original_method = "095E7D0D739AFBC4C7C2B3342244FF59", hash_generated_method = "31B289F91CC273E0691212480DDBC7FD")
    public static synchronized DrmRightsManager getInstance() {
        if (singleton == null) {
            singleton = new DrmRightsManager();
        }
        return singleton;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.866 -0400", hash_original_method = "DFEBA1171CC4BD5C340A5F7D201F4250", hash_generated_method = "B631EA8F83E782E1935955BE25F6A638")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized DrmRights installRights(InputStream rightsData, int len, String mimeTypeStr) throws DrmException, IOException {
        dsTaint.addTaint(len);
        dsTaint.addTaint(rightsData.dsTaint);
        dsTaint.addTaint(mimeTypeStr);
        int mimeType;
        mimeType = 0;
        {
            boolean varEEACE11B81601650A1669378AD868CE7_1229362963 = (DRM_MIMETYPE_RIGHTS_XML_STRING.equals(mimeTypeStr));
            mimeType = DRM_MIMETYPE_RIGHTS_XML;
            {
                boolean var153861F76AEB88AFFEC070D5454972D1_1804930717 = (DRM_MIMETYPE_RIGHTS_WBXML_STRING.equals(mimeTypeStr));
                mimeType = DRM_MIMETYPE_RIGHTS_WBXML;
                {
                    boolean var1523E3042FF28A6189BF8D8D034F098A_2004837897 = (DrmRawContent.DRM_MIMETYPE_MESSAGE_STRING.equals(mimeTypeStr));
                    mimeType = DRM_MIMETYPE_MESSAGE;
                    throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        DrmRights rights;
        rights = new DrmRights();
        int res;
        res = nativeInstallDrmRights(rightsData, len, mimeType, rights);
        throw new DrmException("nativeInstallDrmRights() returned JNI_DRM_FAILURE");
        return (DrmRights)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.867 -0400", hash_original_method = "F869914CDBD46FC071FA033F543D25F0", hash_generated_method = "F7502AE363A6B463ED59C1EC0BBBD9D2")
    @DSModeled(DSC.SAFE)
    public synchronized DrmRights queryRights(DrmRawContent content) {
        dsTaint.addTaint(content.dsTaint);
        DrmRights rights;
        rights = new DrmRights();
        int res;
        res = nativeQueryRights(content, rights);
        return (DrmRights)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DrmRights rights = new DrmRights();
        //int res = nativeQueryRights(content, rights);
        //if (JNI_DRM_FAILURE == res)
            //return null;
        //return rights;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.867 -0400", hash_original_method = "2F13CE15153AB575E5C66B8C7F8BCB6B", hash_generated_method = "72655B1ECAF636122C72C68179AD0D2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized List getRightsList() {
        List rightsList;
        rightsList = new ArrayList();
        int num;
        num = nativeGetNumOfRights();
        {
            DrmRights[] rightsArray;
            rightsArray = new DrmRights[num];
            int i;
            {
                i = 0;
                rightsArray[i] = new DrmRights();
            } //End collapsed parenthetic
            num = nativeGetRightsList(rightsArray, num);
            {
                i = 0;
                rightsList.add(rightsArray[i]);
            } //End collapsed parenthetic
        } //End block
        return (List)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.868 -0400", hash_original_method = "017D692B38F8FD212CF524C82FCE2BD9", hash_generated_method = "26B600AD6FF7CA8A86C25CB454EA0AC9")
    @DSModeled(DSC.SAFE)
    public synchronized void deleteRights(DrmRights rights) {
        dsTaint.addTaint(rights.dsTaint);
        int res;
        res = nativeDeleteRights(rights);
        // ---------- Original Method ----------
        //int res = nativeDeleteRights(rights);
        //if (JNI_DRM_FAILURE == res)
            //return;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.868 -0400", hash_original_method = "4EFCC19418AEA2B988CE34DFC9464C6A", hash_generated_method = "977FA6BC7730F679F802479DA88D79E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeInstallDrmRights(InputStream data, int len, int mimeType, DrmRights rights) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(rights.dsTaint);
        dsTaint.addTaint(len);
        dsTaint.addTaint(mimeType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.868 -0400", hash_original_method = "D2E0FD9FD256FCE483409E8A0B1A737B", hash_generated_method = "304F49D594D5C3FDBFB4930A719335CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeQueryRights(DrmRawContent content, DrmRights rights) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(rights.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.868 -0400", hash_original_method = "53C2DF882AFDD7A7897768491F6FD437", hash_generated_method = "C485E592725B22B62CAC1B4DAAED41E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetNumOfRights() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.868 -0400", hash_original_method = "D10F41EFD32E726343E3CA8A142B1A5C", hash_generated_method = "BF6644EB0E4A4424C04D8FA1E1E9A474")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeGetRightsList(DrmRights[] rights, int numRights) {
        dsTaint.addTaint(numRights);
        dsTaint.addTaint(rights.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.868 -0400", hash_original_method = "75A731730EAFA84E0B65F7039A32C61B", hash_generated_method = "8DA0FC363B177863C697E803CE68F0D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int nativeDeleteRights(DrmRights rights) {
        dsTaint.addTaint(rights.dsTaint);
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


