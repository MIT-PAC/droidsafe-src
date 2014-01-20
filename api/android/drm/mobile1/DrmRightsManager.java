package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DrmRightsManager {

    /**
     * Get the DrmRightsManager instance.
     *
     * @return the instance of DrmRightsManager.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.773 -0500", hash_original_method = "095E7D0D739AFBC4C7C2B3342244FF59", hash_generated_method = "31B289F91CC273E0691212480DDBC7FD")
    
public static synchronized DrmRightsManager getInstance() {
        if (singleton == null) {
            singleton = new DrmRightsManager();
        }

        return singleton;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.749 -0500", hash_original_field = "052F9E2BD9DFC69066986C9CB59ECAE5", hash_generated_field = "1EAF9F8DECDC64797BB05E1A169CAC24")

    public static final String DRM_MIMETYPE_RIGHTS_XML_STRING = "application/vnd.oma.drm.rights+xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.752 -0500", hash_original_field = "21322726C015C273138E9002D75636CC", hash_generated_field = "BE36C549B145E602BDD829C5969968B5")

    public static final String DRM_MIMETYPE_RIGHTS_WBXML_STRING = "application/vnd.oma.drm.rights+wbxml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.754 -0500", hash_original_field = "0B26FE1945E993620179B5D6462DCB9D", hash_generated_field = "B106663AE8ED1953C5BF784F74A2A420")

    private static final int DRM_MIMETYPE_RIGHTS_XML = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.757 -0500", hash_original_field = "077D59C3A04301805E47CAA43FFDA456", hash_generated_field = "8E46F7773E206BB642294E13FBD439A6")

    private static final int DRM_MIMETYPE_RIGHTS_WBXML = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.760 -0500", hash_original_field = "D345246C87E6D4404981829D98CE75C3", hash_generated_field = "98083C2F2BCD6A089C4D9DF2D1E75981")

    private static final int DRM_MIMETYPE_MESSAGE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.763 -0500", hash_original_field = "FF738810C6AC45A69932287AFA098725", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.765 -0500", hash_original_field = "37BEA82E28CB1C34F8EBE2B3C4DE18F8", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

    private static final int JNI_DRM_FAILURE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.768 -0500", hash_original_field = "61747838A2865E117001D42957B69319", hash_generated_field = "B789093F93ED21BAFF0E4A55290D04C6")

    private static DrmRightsManager singleton = null;

    /**
     * Construct a DrmRightsManager
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.770 -0500", hash_original_method = "9CECCAD6D8D5F2E74B9B1C7CC1642036", hash_generated_method = "2905FE266121C8BB7EB4FAF5BE38823B")
    
protected DrmRightsManager() {
    }

    /**
     * Install one DRM rights and return one instance of DrmRights.
     *
     * @param rightsData    raw rights data.
     * @param mimeTypeStr   the mime type of the rights object.
     *
     * @return the instance of the installed DrmRights.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.776 -0500", hash_original_method = "DFEBA1171CC4BD5C340A5F7D201F4250", hash_generated_method = "610FFE162E37F945B00BEE3FEF30478F")
    
public synchronized DrmRights installRights(InputStream rightsData, int len, String mimeTypeStr) throws DrmException, IOException {
        int mimeType = 0;

        if (DRM_MIMETYPE_RIGHTS_XML_STRING.equals(mimeTypeStr))
            mimeType = DRM_MIMETYPE_RIGHTS_XML;
        else if (DRM_MIMETYPE_RIGHTS_WBXML_STRING.equals(mimeTypeStr))
            mimeType = DRM_MIMETYPE_RIGHTS_WBXML;
        else if (DrmRawContent.DRM_MIMETYPE_MESSAGE_STRING.equals(mimeTypeStr))
            mimeType = DRM_MIMETYPE_MESSAGE;
        else
            throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE");

        if (len <= 0)
            return null;

        DrmRights rights = new DrmRights();

        /* call native method to install this rights object. */
        int res = nativeInstallDrmRights(rightsData, len, mimeType, rights);

        if (JNI_DRM_FAILURE == res)
            throw new DrmException("nativeInstallDrmRights() returned JNI_DRM_FAILURE");

        return rights;
    }

    /**
     * Query DRM rights of specified DRM raw content.
     *
     * @param content       raw content object.
     *
     * @return the instance of DrmRights, or null if there is no rights.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.779 -0500", hash_original_method = "F869914CDBD46FC071FA033F543D25F0", hash_generated_method = "7A5DCEBD865AAB901EC83FAE4998317C")
    
public synchronized DrmRights queryRights(DrmRawContent content) {
        DrmRights rights = new DrmRights();

        /* call native method to query the rights */
        int res = nativeQueryRights(content, rights);

        if (JNI_DRM_FAILURE == res)
            return null;

        return rights;
    }

    /**
     * Get the list of all DRM rights saved in local client.
     *
     * @return the list of all the rights object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.782 -0500", hash_original_method = "2F13CE15153AB575E5C66B8C7F8BCB6B", hash_generated_method = "2CE4D9CFC038DCB7907C246976D7299E")
    
public synchronized List getRightsList() {
        List rightsList = new ArrayList();

        /* call native method to get how many rights object in current agent */
        int num = nativeGetNumOfRights();

        if (JNI_DRM_FAILURE == num)
            return null;

        if (num > 0) {
            DrmRights[] rightsArray = new DrmRights[num];
            int i;

            for (i = 0; i < num; i++)
                rightsArray[i] = new DrmRights();

            /* call native method to get all the rights information */
            num = nativeGetRightsList(rightsArray, num);

            if (JNI_DRM_FAILURE == num)
                return null;

            /* add all rights informations to ArrayList */
            for (i = 0; i < num; i++)
                rightsList.add(rightsArray[i]);
        }

        return rightsList;
    }

    /**
     * Delete the specified DRM rights object.
     *
     * @param rights    the specified rights object to be deleted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.784 -0500", hash_original_method = "017D692B38F8FD212CF524C82FCE2BD9", hash_generated_method = "CA820402C5228EA8399842E1F8EBE838")
    
public synchronized void deleteRights(DrmRights rights) {
        /* call native method to delete the specified rights object */
        int res = nativeDeleteRights(rights);

        if (JNI_DRM_FAILURE == res)
            return;
    }

    /**
     * native method: install rights object to local client.
     *
     * @param data      input DRM rights object data to be installed.
     * @param len       the length of the data.
     * @param mimeType  the mime type of this DRM rights object. the value of this field includes:
     *                      #DRM_MIMETYPE_RIGHTS_XML
     *                      #DRM_MIMETYPE_RIGHTS_WBXML
     * @parma rights    the instance of DRMRights to be filled.
     *
     * @return #JNI_DRM_SUCCESS if succeed.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.788 -0500", hash_original_method = "4EFCC19418AEA2B988CE34DFC9464C6A", hash_generated_method = "8EA966CE9514042DD600884BE7C307E9")
    
    private int nativeInstallDrmRights(InputStream data, int len, int mimeType, DrmRights rights){
    	//Formerly a native method
    	addTaint(data.getTaint());
    	addTaint(len);
    	addTaint(mimeType);
    	addTaint(rights.getTaint());
    	return getTaintInt();
    }

    /**
     * native method: query the given DRM content's rights object.
     *
     * @param content   the given DRM content.
     * @param rights    the instance of rights to set if have.
     *
     * @return #JNI_DRM_SUCCESS if succeed.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.792 -0500", hash_original_method = "D2E0FD9FD256FCE483409E8A0B1A737B", hash_generated_method = "D3F1E1CC2C1AFF2CBF00F1155854E280")
    
    private int nativeQueryRights(DrmRawContent content, DrmRights rights){
    	//Formerly a native method
    	addTaint(content.getTaint());
    	addTaint(rights.getTaint());
    	return getTaintInt();
    }

    /**
     * native method: get how many rights object in current DRM agent.
     *
     * @return the number of the rights object.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.796 -0500", hash_original_method = "53C2DF882AFDD7A7897768491F6FD437", hash_generated_method = "DBCE59F40D10F7323AA9FD03BBF4D83A")
    
    private int nativeGetNumOfRights(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * native method: get all the rights object in current local agent.
     *
     * @param rights    the array instance of rights object.
     * @param numRights how many rights can be saved.
     *
     * @return the number of the rights object has been gotten.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.800 -0500", hash_original_method = "D10F41EFD32E726343E3CA8A142B1A5C", hash_generated_method = "7B2AD6982289DBBA5D12226CFF0E7842")
    
    private int nativeGetRightsList(DrmRights[] rights, int numRights){
    	//Formerly a native method
    	addTaint(rights[0].getTaint());
    	addTaint(numRights);
    	return getTaintInt();
    }

    /**
     * native method: delete a specified rights object.
     *
     * @param rights    the specified rights object to be deleted.
     *
     * @return #JNI_DRM_SUCCESS if succeed.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.805 -0500", hash_original_method = "75A731730EAFA84E0B65F7039A32C61B", hash_generated_method = "DC75A733962790116C4354C7F58C1294")
    
    private int nativeDeleteRights(DrmRights rights){
    	//Formerly a native method
    	addTaint(rights.getTaint());
    	return getTaintInt();
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

