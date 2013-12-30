package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import android.os.ParcelFileDescriptor;
import android.util.TypedValue;




import droidsafe.helpers.DSUtils;

public class AssetManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.869 -0500", hash_original_method = "A821F17F12E0306B831CCEB4175C42F9", hash_generated_method = "92BE533538642ACCDEB5612A7DC60FD5")
    
private static void ensureSystemAssets() {
        synchronized (sSync) {
            if (sSystem == null) {
                AssetManager system = new AssetManager(true);
                system.makeStringBlocks(false);
                sSystem = system;
            }
        }
    }

    /**
     * Return a global shared asset manager that provides access to only
     * system assets (no application assets).
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.874 -0500", hash_original_method = "2E03DF1E56EAF45D52AE236031E99A60", hash_generated_method = "F2D62EEBC23D93EF792674B4D7052CF7")
    
public static AssetManager getSystem() {
        ensureSystemAssets();
        return sSystem;
    }

    
    @DSModeled(DSC.SAFE)
    static final boolean applyStyle(int theme,
            int defStyleAttr, int defStyleRes, int xmlParser,
            int[] inAttrs, int[] outValues, int[] outIndices) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getGlobalAssetCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static final String getAssetAllocations() {
        	return "";
    }

    
    @DSModeled(DSC.SAFE)
    public static final int getGlobalAssetManagerCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    static final void applyThemeStyle(int theme, int styleRes, boolean force) {
    }

    
    @DSModeled(DSC.SAFE)
    static final void copyTheme(int dest, int source) {
    }

    
    @DSModeled(DSC.SAFE)
    static final int loadThemeAttributeValue(int theme, int ident,
                                                                TypedValue outValue,
                                                                boolean resolve) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    static final void dumpTheme(int theme, int priority, String tag, String prefix) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.827 -0500", hash_original_field = "8596CD11A7036DFAE2B55A84F7B1821E", hash_generated_field = "F0F16F15C40F285B8A0645A0BC532026")


    /**
     * Mode for {@link #open(String, int)}: no specific information about how
     * data will be accessed.
     */
    public static final int ACCESS_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.829 -0500", hash_original_field = "D7BD86BF6B6E2A87862083D962189829", hash_generated_field = "44C384B355164335E174FF87C9A455A1")

    public static final int ACCESS_RANDOM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.832 -0500", hash_original_field = "79B5C3BA8BD44991158ED8AB1D81B502", hash_generated_field = "941FA2852A6DCA461D7B2054ECA3EFEA")

    public static final int ACCESS_STREAMING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.834 -0500", hash_original_field = "48A1D96C1A1BF3768E5A8A8BC1FA399D", hash_generated_field = "9117C55B3A01E0F8EFB362B3FB5152BD")

    public static final int ACCESS_BUFFER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.836 -0500", hash_original_field = "E972EA7E59D95929329EC1DEC67C521E", hash_generated_field = "FDC75AE01ED37E059BA4F54E9509C8D2")


    private static final String TAG = "AssetManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.838 -0500", hash_original_field = "E7B97A2CD2A2512D00373A5F856DE18B", hash_generated_field = "776D75E65C0F716B6889BA4A8C683647")

    private static final boolean localLOGV = false || false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.842 -0500", hash_original_field = "95CE7AF2D96DFE943A20EC8DD4F46B72", hash_generated_field = "C4EDA31E106597348022664C2B4AE055")

    
    private static final boolean DEBUG_REFS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.844 -0500", hash_original_field = "C9A89FF9952633C3C99E6CECFFFB823C", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    
    private static final Object sSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.846 -0500", hash_original_field = "5ED009B0F5F554186AF81AAAA3241365", hash_generated_field = "D0731D8853FB150972B9C951A1F661AE")
 static AssetManager sSystem = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.066 -0500", hash_original_field = "5B3E5FDD33C277E60D7E55113FF03887", hash_generated_field = "9A482EFAAC5EAFE41C22AFB2C4AFCFEB")
 static final int STYLE_NUM_ENTRIES = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.068 -0500", hash_original_field = "040B29D7F1F9EACA2D7760A6C2E48A32", hash_generated_field = "329269D64B272BF04010F03C4C06F535")
 static final int STYLE_TYPE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.070 -0500", hash_original_field = "022A567FFB2EC1315765460AE6740EEC", hash_generated_field = "FC17F8F67F5BAEB1FD0402C771D270B0")
 static final int STYLE_DATA = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.072 -0500", hash_original_field = "E233153AEC7297EAF6B035DA044A1576", hash_generated_field = "05C07F6EAB5B9D635D03781B6890450C")
 static final int STYLE_ASSET_COOKIE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.074 -0500", hash_original_field = "C7CF8F64D28DB07F3CD35B59D9060545", hash_generated_field = "0505900C52E965C0B90E9A9386CD8DAB")
 static final int STYLE_RESOURCE_ID = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.077 -0500", hash_original_field = "DE658922077A3FB828DADC100AFAEC2E", hash_generated_field = "7EF09BBF875A3B7CE09ACBE50176137C")
 static final int STYLE_CHANGING_CONFIGURATIONS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.079 -0500", hash_original_field = "F05DA5A2810A72D62F0F26C49318D22C", hash_generated_field = "9B74378301FF8622581D308549021E80")
 static final int STYLE_DENSITY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.848 -0500", hash_original_field = "654366000D5436FE48B31EFBD0B3756D", hash_generated_field = "184B6A2C79F6E655DC652C734EA9E31F")


    private final TypedValue mValue = new TypedValue();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.851 -0500", hash_original_field = "59ECEE1C2A1FB4549E5B598845357CC5", hash_generated_field = "427FE67122035B768BAE648A2E98CFF3")

    private final long[] mOffsets = new long[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.853 -0500", hash_original_field = "099BEA65529558F891E66B800CD4AD52", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.855 -0500", hash_original_field = "030B4805B647B5FD23BD895336C17472", hash_generated_field = "CC3C82762AC73E1C6FA469CFF14F9939")

    private int mNObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.857 -0500", hash_original_field = "6C1539D17F126AB4029EDA5DABC059CB", hash_generated_field = "EC37C879DC6C6530C4627CE0DC66498D")


    private StringBlock mStringBlocks[] = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.860 -0500", hash_original_field = "E99A23F0EC90447AD6B830636570319F", hash_generated_field = "32DC8A24B3C6E9B83A49CEC09007226E")

    
    private int mNumRefs = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.862 -0500", hash_original_field = "C88AEDA1700F461F9D03C7F9BF16FB2E", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.864 -0500", hash_original_field = "753A5D0F1D46E813F708908D07B1A3D1", hash_generated_field = "057DB168549C247D4E5C64EC3B4E7B98")

    private HashMap<Integer, RuntimeException> mRefStacks; 
 
    /**
     * Create a new AssetManager containing only the basic system assets.
     * Applications will not generally use this method, instead retrieving the
     * appropriate asset manager with {@link Resources#getAssets}.    Not for
     * use by applications.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.867 -0500", hash_original_method = "59A199C9627818EA5BC55C2223B1B671", hash_generated_method = "E88B08B9F7477CB197F9A4223A2ECB4B")
    
public AssetManager() {
        synchronized (this) {
            if (DEBUG_REFS) {
                mNumRefs = 0;
                incRefsLocked(this.hashCode());
            }
            init();
            if (localLOGV) Log.v(TAG, "New asset manager: " + this);
            ensureSystemAssets();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.872 -0500", hash_original_method = "517E3FEC19C254F005880DBF363FE7AF", hash_generated_method = "0AD68695B92B6C49406AD3CAB445259B")
    
private AssetManager(boolean isSystem) {
        if (DEBUG_REFS) {
            synchronized (this) {
                mNumRefs = 0;
                incRefsLocked(this.hashCode());
            }
        }
        init();
        if (localLOGV) Log.v(TAG, "New asset manager: " + this);
    }

    /**
     * Close this asset manager.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.876 -0500", hash_original_method = "2C3B764DDE8F79C85110BA90D40DB7B8", hash_generated_method = "4E23B7FF5032A5785CD3E7D3ECD4A70A")
    
public void close() {
        synchronized(this) {
            //System.out.println("Release: num=" + mNumRefs
            //                   + ", released=" + mReleased);
            if (mOpen) {
                mOpen = false;
                decRefsLocked(this.hashCode());
            }
        }
    }

    /**
     * Retrieve the string value associated with a particular resource
     * identifier for the current configuration / skin.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.878 -0500", hash_original_method = "CB81F9A1A3C0416B5CF420A3F62514E3", hash_generated_method = "566D02F833DEB90675A04751BE80B06E")
    
final CharSequence getResourceText(int ident) {
        synchronized (this) {
            TypedValue tmpValue = mValue;
            int block = loadResourceValue(ident, (short) 0, tmpValue, true);
            if (block >= 0) {
                if (tmpValue.type == TypedValue.TYPE_STRING) {
                    return mStringBlocks[block].get(tmpValue.data);
                }
                return tmpValue.coerceToString();
            }
        }
        return null;
    }

    /**
     * Retrieve the string value associated with a particular resource
     * identifier for the current configuration / skin.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.880 -0500", hash_original_method = "2C5FA72B5D3C88AECCC2C4639A2FC63C", hash_generated_method = "5990EC8BFC2A29BA9FF2C6D7D17ECF89")
    
final CharSequence getResourceBagText(int ident, int bagEntryId) {
        synchronized (this) {
            TypedValue tmpValue = mValue;
            int block = loadResourceBagValue(ident, bagEntryId, tmpValue, true);
            if (block >= 0) {
                if (tmpValue.type == TypedValue.TYPE_STRING) {
                    return mStringBlocks[block].get(tmpValue.data);
                }
                return tmpValue.coerceToString();
            }
        }
        return null;
    }

    /**
     * Retrieve the string array associated with a particular resource
     * identifier.
     * @param id Resource id of the string array
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.882 -0500", hash_original_method = "15AFE30CDC312B3891A5A8072BD8524F", hash_generated_method = "54E31ECC64BFA151348969DD9CDF174E")
    
final String[] getResourceStringArray(final int id) {
        String[] retArray = getArrayStringResource(id);
        return retArray;
    }


    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.885 -0500", hash_original_method = "880DADF9021E8E0236DAC9AB890DE1A9", hash_generated_method = "6635CC9A9B1559C72E90550A8A0A4FE6")
    
final boolean getResourceValue(int ident,
                                               int density,
                                               TypedValue outValue,
                                               boolean resolveRefs)
    {
        int block = loadResourceValue(ident, (short) density, outValue, resolveRefs);
        if (block >= 0) {
            if (outValue.type != TypedValue.TYPE_STRING) {
                return true;
            }
            outValue.string = mStringBlocks[block].get(outValue.data);
            return true;
        }
        return false;
    }

    /**
     * Retrieve the text array associated with a particular resource
     * identifier.
     * @param id Resource id of the string array
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.887 -0500", hash_original_method = "5C4180581403390570CBF3420B87F392", hash_generated_method = "54059C45E6BC7D40E7309DD9FCE34A6A")
    
final CharSequence[] getResourceTextArray(final int id) {
        int[] rawInfoArray = getArrayStringInfo(id);
        int rawInfoArrayLen = rawInfoArray.length;
        final int infoArrayLen = rawInfoArrayLen / 2;
        int block;
        int index;
        CharSequence[] retArray = new CharSequence[infoArrayLen];
        for (int i = 0, j = 0; i < rawInfoArrayLen; i = i + 2, j++) {
            block = rawInfoArray[i];
            index = rawInfoArray[i + 1];
            retArray[j] = index >= 0 ? mStringBlocks[block].get(index) : null;
        }
        return retArray;
    }
    
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.890 -0500", hash_original_method = "257E397E5CF934BBA53C0ACDE849DFE1", hash_generated_method = "158919A99B960BE9FE30781401A26982")
    
final boolean getThemeValue(int theme, int ident,
            TypedValue outValue, boolean resolveRefs) {
        int block = loadThemeAttributeValue(theme, ident, outValue, resolveRefs);
        if (block >= 0) {
            if (outValue.type != TypedValue.TYPE_STRING) {
                return true;
            }
            StringBlock[] blocks = mStringBlocks;
            if (blocks == null) {
                ensureStringBlocks();
                blocks = mStringBlocks;
            }
            outValue.string = blocks[block].get(outValue.data);
            return true;
        }
        return false;
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.892 -0500", hash_original_method = "BC550AAFCB31C90ECB8DB7C3E260076C", hash_generated_method = "654957354DACF310A05FEE109186629F")
    
final void ensureStringBlocks() {
        if (mStringBlocks == null) {
            synchronized (this) {
                if (mStringBlocks == null) {
                    makeStringBlocks(true);
                }
            }
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.895 -0500", hash_original_method = "EDCC94234F08B09DDE56D32F4E25BC85", hash_generated_method = "5DE0DF13CB5229BEC74F2E5B2CED9413")
    
final void makeStringBlocks(boolean copyFromSystem) {
        final int sysNum = copyFromSystem ? sSystem.mStringBlocks.length : 0;
        final int num = getStringBlockCount();
        mStringBlocks = new StringBlock[num];
        if (localLOGV) Log.v(TAG, "Making string blocks for " + this
                + ": " + num);
        for (int i=0; i<num; i++) {
            if (i < sysNum) {
                mStringBlocks[i] = sSystem.mStringBlocks[i];
            } else {
                mStringBlocks[i] = new StringBlock(getNativeStringBlock(i), true);
            }
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.897 -0500", hash_original_method = "148EA8945A31568904B22E1C4951294F", hash_generated_method = "39CF31C4D46770A3EC28E345B4DC4F39")
    
final CharSequence getPooledString(int block, int id) {
        //System.out.println("Get pooled: block=" + block
        //                   + ", id=#" + Integer.toHexString(id)
        //                   + ", blocks=" + mStringBlocks);
        return mStringBlocks[block-1].get(id);
    }

    /**
     * Open an asset using ACCESS_STREAMING mode.  This provides access to
     * files that have been bundled with an application as assets -- that is,
     * files placed in to the "assets" directory.
     * 
     * @param fileName The name of the asset to open.  This name can be
     *                 hierarchical.
     * 
     * @see #open(String, int)
     * @see #list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.900 -0500", hash_original_method = "7E1B14522C484E4F1B470AEA16F877D6", hash_generated_method = "30526FA7EE5BA7ADC855EA97F46AE7D4")
    
public final InputStream open(String fileName) throws IOException {
        return open(fileName, ACCESS_STREAMING);
    }

    /**
     * Open an asset using an explicit access mode, returning an InputStream to
     * read its contents.  This provides access to files that have been bundled
     * with an application as assets -- that is, files placed in to the
     * "assets" directory.
     * 
     * @param fileName The name of the asset to open.  This name can be
     *                 hierarchical.
     * @param accessMode Desired access mode for retrieving the data.
     * 
     * @see #ACCESS_UNKNOWN
     * @see #ACCESS_STREAMING
     * @see #ACCESS_RANDOM
     * @see #ACCESS_BUFFER
     * @see #open(String)
     * @see #list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.902 -0500", hash_original_method = "EB9FEA0B2CEADB65FF0921C2B52A13F4", hash_generated_method = "4BBF30831C3143B01679ADF8D444356C")
    
public final InputStream open(String fileName, int accessMode)
        throws IOException {
        synchronized (this) {
            if (!mOpen) {
                throw new RuntimeException("Assetmanager has been closed");
            }
            int asset = openAsset(fileName, accessMode);
            if (asset != 0) {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
                return res;
            }
        }
        throw new FileNotFoundException("Asset file: " + fileName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.904 -0500", hash_original_method = "66D3D468B1706A8E526F268E61D6D3C7", hash_generated_method = "ECB3AB95CCCC59180AB77038F82E2B1F")
    
public final AssetFileDescriptor openFd(String fileName)
            throws IOException {
        synchronized (this) {
            if (!mOpen) {
                throw new RuntimeException("Assetmanager has been closed");
            }
            ParcelFileDescriptor pfd = openAssetFd(fileName, mOffsets);
            if (pfd != null) {
                return new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            }
        }
        throw new FileNotFoundException("Asset file: " + fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.101 -0400", hash_original_method = "BFE0DD4127D11EE8C7DC2AF7F1625EB3", hash_generated_method = "5671ABB042797CD529E276FD90C5DEDA")
    @DSModeled(DSC.SAFE)
    public final String[] list(String path) throws IOException {
    	String[] ret = {path};
    	return ret;
    }

    /**
     * {@hide}
     * Open a non-asset file as an asset using ACCESS_STREAMING mode.  This
     * provides direct access to all of the files included in an application
     * package (not only its assets).  Applications should not normally use
     * this.
     * 
     * @see #open(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.910 -0500", hash_original_method = "B416CA2D934FFC444AFFEA95F80C0673", hash_generated_method = "4BF8A2093F77A1D39FA6B70B0C2DDF96")
    
public final InputStream openNonAsset(String fileName) throws IOException {
        return openNonAsset(0, fileName, ACCESS_STREAMING);
    }

    /**
     * {@hide}
     * Open a non-asset file as an asset using a specific access mode.  This
     * provides direct access to all of the files included in an application
     * package (not only its assets).  Applications should not normally use
     * this.
     * 
     * @see #open(String, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.913 -0500", hash_original_method = "6F98937B657C3DF287FD2A6608D5C403", hash_generated_method = "3CACD2BAF29F24FC8DFDD7EA79EBF8CA")
    
public final InputStream openNonAsset(String fileName, int accessMode)
        throws IOException {
        return openNonAsset(0, fileName, accessMode);
    }

    /**
     * {@hide}
     * Open a non-asset in a specified package.  Not for use by applications.
     * 
     * @param cookie Identifier of the package to be opened.
     * @param fileName Name of the asset to retrieve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.915 -0500", hash_original_method = "DECD09E6B1808DA43562160A03482F49", hash_generated_method = "E997C8EDB8BCF44311D659E44193E10E")
    
public final InputStream openNonAsset(int cookie, String fileName)
        throws IOException {
        return openNonAsset(cookie, fileName, ACCESS_STREAMING);
    }

    /**
     * {@hide}
     * Open a non-asset in a specified package.  Not for use by applications.
     * 
     * @param cookie Identifier of the package to be opened.
     * @param fileName Name of the asset to retrieve.
     * @param accessMode Desired access mode for retrieving the data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.918 -0500", hash_original_method = "5BC280B3003CA7B8CFB3A2FB67C4E385", hash_generated_method = "25718FA436B166B9973DFAB37FE16B1B")
    
public final InputStream openNonAsset(int cookie, String fileName, int accessMode)
        throws IOException {
        synchronized (this) {
            if (!mOpen) {
                throw new RuntimeException("Assetmanager has been closed");
            }
            int asset = openNonAssetNative(cookie, fileName, accessMode);
            if (asset != 0) {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
                return res;
            }
        }
        throw new FileNotFoundException("Asset absolute file: " + fileName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.920 -0500", hash_original_method = "E6C638BB28F04E787E5711BF8F421102", hash_generated_method = "E3DA2407F76513DC937ED3FC52F924CB")
    
public final AssetFileDescriptor openNonAssetFd(String fileName)
            throws IOException {
        return openNonAssetFd(0, fileName);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.922 -0500", hash_original_method = "A0DC944B46306DDC2CA1031D9C43AC47", hash_generated_method = "8E660ED09152CAF6A634784FAF881D7E")
    
public final AssetFileDescriptor openNonAssetFd(int cookie,
            String fileName) throws IOException {
        synchronized (this) {
            if (!mOpen) {
                throw new RuntimeException("Assetmanager has been closed");
            }
            ParcelFileDescriptor pfd = openNonAssetFdNative(cookie,
                    fileName, mOffsets);
            if (pfd != null) {
                return new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            }
        }
        throw new FileNotFoundException("Asset absolute file: " + fileName);
    }
    
    /**
     * Retrieve a parser for a compiled XML file.
     * 
     * @param fileName The name of the file to retrieve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.924 -0500", hash_original_method = "602B0A8D272774ACD0101F14F2575F17", hash_generated_method = "24AC78525D5C95BFCD6A262F72B1E55A")
    
public final XmlResourceParser openXmlResourceParser(String fileName)
            throws IOException {
        return openXmlResourceParser(0, fileName);
    }
    
    /**
     * Retrieve a parser for a compiled XML file.
     * 
     * @param cookie Identifier of the package to be opened.
     * @param fileName The name of the file to retrieve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.926 -0500", hash_original_method = "06F5CBF51BDA69D9C47BB01131F079C4", hash_generated_method = "2B96438F6D4AB5642FC14F03C275F180")
    
public final XmlResourceParser openXmlResourceParser(int cookie,
            String fileName) throws IOException {
        XmlBlock block = openXmlBlockAsset(cookie, fileName);
        XmlResourceParser rp = block.newParser();
        block.close();
        return rp;
    }

    /**
     * {@hide}
     * Retrieve a non-asset as a compiled XML file.  Not for use by
     * applications.
     * 
     * @param fileName The name of the file to retrieve.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.928 -0500", hash_original_method = "675415F1EB93293576759C69BAEA6DCB", hash_generated_method = "7C04A244E06F18F218E7F4B18CB646EC")
    
final XmlBlock openXmlBlockAsset(String fileName)
            throws IOException {
        return openXmlBlockAsset(0, fileName);
    }

    /**
     * {@hide}
     * Retrieve a non-asset as a compiled XML file.  Not for use by
     * applications.
     * 
     * @param cookie Identifier of the package to be opened.
     * @param fileName Name of the asset to retrieve.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.931 -0500", hash_original_method = "9588BC172FA11EB2767F6277EAB2B09E", hash_generated_method = "B417AC5747E8DFC21074CEE7B98F7D8D")
    
final XmlBlock openXmlBlockAsset(int cookie, String fileName)
        throws IOException {
        synchronized (this) {
            if (!mOpen) {
                throw new RuntimeException("Assetmanager has been closed");
            }
            int xmlBlock = openXmlAssetNative(cookie, fileName);
            if (xmlBlock != 0) {
                XmlBlock res = new XmlBlock(this, xmlBlock);
                incRefsLocked(res.hashCode());
                return res;
            }
        }
        throw new FileNotFoundException("Asset XML file: " + fileName);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.933 -0500", hash_original_method = "30EAECC95AEB342DDD14100667205DCF", hash_generated_method = "30EAECC95AEB342DDD14100667205DCF")
    
void xmlBlockGone(int id) {
        synchronized (this) {
            decRefsLocked(id);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.935 -0500", hash_original_method = "9AD5347899C2D862F4815C023E5977D1", hash_generated_method = "78A9B8EF59C085FBB43CBAAE822870BF")
    
final int createTheme() {
        synchronized (this) {
            if (!mOpen) {
                throw new RuntimeException("Assetmanager has been closed");
            }
            int res = newTheme();
            incRefsLocked(res);
            return res;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.937 -0500", hash_original_method = "0E7F795DABC0415CCAB4CA5A0005DBB0", hash_generated_method = "79DF717765ACB3C1408FA195C0FCABCC")
    
final void releaseTheme(int theme) {
        synchronized (this) {
            deleteTheme(theme);
            decRefsLocked(theme);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.941 -0500", hash_original_method = "C1D87D935BC2D519032BCC6CD9CB5D9B", hash_generated_method = "6DE91437B68837BFBE09E007C8377A2F")
    
protected void finalize() throws Throwable {
        try {
            if (DEBUG_REFS && mNumRefs != 0) {
                Log.w(TAG, "AssetManager " + this
                        + " finalized with non-zero refs: " + mNumRefs);
                if (mRefStacks != null) {
                    for (RuntimeException e : mRefStacks.values()) {
                        Log.w(TAG, "Reference from here", e);
                    }
                }
            }
            destroy();
        } finally {
            super.finalize();
        }
    }

    /**
     * Add an additional set of assets to the asset manager.  This can be
     * either a directory or ZIP file.  Not for use by applications.  Returns
     * the cookie of the added asset, or 0 on failure.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.982 -0500", hash_original_method = "18B8C5816FBF862D1286972549E79177", hash_generated_method = "934D5BF4778E1BDCA6060458CC2BF3D1")
    
    public final int addAssetPath(String path){
    	//Formerly a native method
    	addTaint(path.getTaint());
    	return getTaintInt();
    }


    /**
     * Add multiple sets of assets to the asset manager at once.  See
     * {@link #addAssetPath(String)} for more information.  Returns array of
     * cookies for each added asset with 0 indicating failure, or null if
     * the input array of paths is null.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.985 -0500", hash_original_method = "22EE91EE70E10361F8012967A8F2990A", hash_generated_method = "9793102FE05D78951E91395086DCBFE0")
    
public final int[] addAssetPaths(String[] paths) {
        if (paths == null) {
            return null;
        }

        int[] cookies = new int[paths.length];
        for (int i = 0; i < paths.length; i++) {
            cookies[i] = addAssetPath(paths[i]);
        }

        return cookies;
    }

    /**
     * Determine whether the state in this asset manager is up-to-date with
     * the files on the filesystem.  If false is returned, you need to
     * instantiate a new AssetManager class to see the new data.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.988 -0500", hash_original_method = "6E60478B72DEC0ABE7A87F31E1844E8F", hash_generated_method = "BFA421FA35DE8FC3F8DE5B81A4043C44")
    
    public final boolean isUpToDate(){
    	//Formerly a native method
    	return getTaintBoolean();
    }


    /**
     * Change the locale being used by this asset manager.  Not for use by
     * applications.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.992 -0500", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "B10831CBF66052D65665E1D3AAEA4C54")
    
    public final void setLocale(String locale){
    	//Formerly a native method
    	addTaint(locale.getTaint());
    }


    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.349 -0400", hash_original_method = "3CB696CCF0EE1BB70EEADB93E6432982", hash_generated_method = "2A1885B1024F713A5324E14BAEA805ED")
    public final String[] getLocales() {
    	String[] mockArray = {""};
    	return mockArray;
    }

    /**
     * Change the configuation used when retrieving resources.  Not for use by
     * applications.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.000 -0500", hash_original_method = "0D7945B64E12882B3ACBA2198421753F", hash_generated_method = "3B91012D856B5F21725F2887ABFC9E99")
    
    public final void setConfiguration(int mcc, int mnc, String locale,
                int orientation, int touchscreen, int density, int keyboard,
                int keyboardHidden, int navigation, int screenWidth, int screenHeight,
                int smallestScreenWidthDp, int screenWidthDp, int screenHeightDp,
                int screenLayout, int uiMode, int majorVersion){
    	//Formerly a native method
    	addTaint(mcc);
    	addTaint(mnc);
    	addTaint(locale.getTaint());
    	addTaint(orientation);
    	addTaint(touchscreen);
    	addTaint(density);
    	addTaint(keyboard);
    	addTaint(keyboardHidden);
    	addTaint(navigation);
    	addTaint(screenWidth);
    	addTaint(screenHeight);
    	addTaint(smallestScreenWidthDp);
    	addTaint(screenWidthDp);
    	addTaint(screenHeightDp);
    	addTaint(screenLayout);
    	addTaint(uiMode);
    	addTaint(majorVersion);
    }


    /**
     * Retrieve the resource identifier for the given resource name.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.004 -0500", hash_original_method = "09A813727514834940DA6C6317E3DBCE", hash_generated_method = "42DAF92CC99A835194C08355AE92A0B4")
    
    final int getResourceIdentifier(String type,
                                                           String name,
                                                           String defPackage){
    	//Formerly a native method
    	addTaint(type.getTaint());
    	addTaint(name.getTaint());
    	addTaint(defPackage.getTaint());
    	return getTaintInt();
    }


    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.368 -0400", hash_original_method = "A5876C7E6082BC9F857AB889162EC8D3", hash_generated_method = "FBAAE168C828C7BA370F62A92E8BDE92")
    @DSModeled(DSC.SAFE)
    final String getResourceName(int resid) {
    	return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.369 -0400", hash_original_method = "B7E19874BAD16ADDD401F7BE2B2EFFAD", hash_generated_method = "1B222EBFB81E92383980BFED3C95FEF1")
    @DSModeled(DSC.SAFE)
    final String getResourcePackageName(int resid) {
    	return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.369 -0400", hash_original_method = "D3A87104246875F54A734A7CED9F3792", hash_generated_method = "FB0BED0BADF159555D7AAA9D63E79093")
    @DSModeled(DSC.SAFE)
    final String getResourceTypeName(int resid) {
    	return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.370 -0400", hash_original_method = "7C2D2224C9B46B19401BE8615244E9F1", hash_generated_method = "DCC8904351055C288FCFF6D931A8C8F9")
    @DSModeled(DSC.SAFE)
    final String getResourceEntryName(int resid) {
    	return "";
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.022 -0500", hash_original_method = "CCB6CD4213F7E59AA2D59934C9160368", hash_generated_method = "4B54429074B3E82CB432A5C72154C8ED")
    
    private final int openAsset(String fileName, int accessMode){
    	//Formerly a native method
    	addTaint(fileName.getTaint());
    	addTaint(accessMode);
    	return getTaintInt();
    }


    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.374 -0400", hash_original_method = "9CBF0316C59A074D9238537266A4CF39", hash_generated_method = "1E5C5B867FCBA6692FC4FC36ABE4480B")
    @DSModeled(DSC.SAFE)
    private final ParcelFileDescriptor openAssetFd(String fileName,
            long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.030 -0500", hash_original_method = "81CCCE789A5081BAF563B4B2EE08FF05", hash_generated_method = "33C2CE1AD84620F5B594C345D4DA4457")
    
    private final int openNonAssetNative(int cookie, String fileName,
                int accessMode){
    	//Formerly a native method
    	addTaint(cookie);
    	addTaint(fileName.getTaint());
    	addTaint(accessMode);
    	return getTaintInt();
    }


    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.391 -0400", hash_original_method = "05F1691565177C2AFF700A7C71F6F6CD", hash_generated_method = "3A7AF2AA82D95CB2D761B5108753F113")
    private ParcelFileDescriptor openNonAssetFdNative(int cookie,
            String fileName, long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.037 -0500", hash_original_method = "97A034179950872E547C89DFB8D9E922", hash_generated_method = "DD455BCC0492E23D4DC8120367C8AB00")
    
    private final void destroyAsset(int asset){
    	//Formerly a native method
    	addTaint(asset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.040 -0500", hash_original_method = "5F1E2DF7C91A7E126E188B382F4854C7", hash_generated_method = "E9EC4872AAC130955E0CE2959BDD0FC8")
    
    private final int readAssetChar(int asset){
    	//Formerly a native method
    	addTaint(asset);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.044 -0500", hash_original_method = "47F4B97BBBCCF733A9E22BF028AA8D70", hash_generated_method = "9E00BA0526ECB2BFCA1A91C611C75AAC")
    
    private final int readAsset(int asset, byte[] b, int off, int len){
    	//Formerly a native method
    	addTaint(asset);
    	addTaint(b[0]);
    	addTaint(off);
    	addTaint(len);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.048 -0500", hash_original_method = "B3BCAF9697DD27514E76657171CAECEC", hash_generated_method = "D724FA50DBBCD7861E8DC84CE59DC905")
    
    private final long seekAsset(int asset, long offset, int whence){
    	//Formerly a native method
    	addTaint(asset);
    	addTaint(offset);
    	addTaint(whence);
    	return getTaintLong();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.052 -0500", hash_original_method = "A83D0C436C33F4BEE2F972AC578D7A68", hash_generated_method = "0DD76057179A72704CAAEE5FE8FF1605")
    
    private final long getAssetLength(int asset){
    	//Formerly a native method
    	addTaint(asset);
    	return getTaintLong();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.056 -0500", hash_original_method = "7F3AC582AA5F20EF55343463044A3085", hash_generated_method = "0E4C91FE4CACEF8701E8607E3D3EB177")
    
    private final long getAssetRemainingLength(int asset){
    	//Formerly a native method
    	addTaint(asset);
    	return getTaintLong();
    }


    /** Returns true if the resource was found, filling in mRetStringBlock and
     *  mRetData. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.059 -0500", hash_original_method = "27B70155371A7D816D4F089317C25CF6", hash_generated_method = "9613E116A4D58A04814824802D7E1A98")
    
    private final int loadResourceValue(int ident, short density, TypedValue outValue,
                boolean resolve){
    	//Formerly a native method
    	addTaint(ident);
    	addTaint(density);
    	addTaint(outValue.getTaint());
    	addTaint(resolve);
    	return getTaintInt();
    }

    /** Returns true if the resource was found, filling in mRetStringBlock and
     *  mRetData. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.063 -0500", hash_original_method = "F08D438D948FB59FEDF35DA42629554E", hash_generated_method = "262A6B89071B38C45E99B003057D519C")
    
    private final int loadResourceBagValue(int ident, int bagEntryId, TypedValue outValue,
                                                   boolean resolve){
    	//Formerly a native method
    	addTaint(ident);
    	addTaint(bagEntryId);
    	addTaint(outValue.getTaint());
    	addTaint(resolve);
    	return getTaintInt();
    }


    
    public final class AssetInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.971 -0500", hash_original_field = "28DD184F1EEC9ABCE76F5B13E84E33BA", hash_generated_field = "8F8029B3259B8B1BA6498538453FCD52")


        private int mAsset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.973 -0500", hash_original_field = "CAB3DDEC49B3F58AA21EC9312CA21C26", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

        private long mLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.977 -0500", hash_original_field = "726CF145CAB1B5C34EAE37C0B95FD365", hash_generated_field = "FF38BF9EEDA38C273195A50BE5B2B402")

        private long mMarkPos;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.946 -0500", hash_original_method = "73FC7BCEFA9398CB2657C7ECCED60E53", hash_generated_method = "EA4EF3007DA692CD2346025C4C34E6D4")
        
private AssetInputStream(int asset)
        {
            mAsset = asset;
            mLength = getAssetLength(asset);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.944 -0500", hash_original_method = "E464EBBB8C3DAC741E7C7914FE6096F4", hash_generated_method = "B70B280650FCD4984CEBBA2C295631C2")
        
public final int getAssetInt() {
            return mAsset;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.949 -0500", hash_original_method = "C81989D37BD2D192408FD3EC31DA3DAD", hash_generated_method = "EECD89DDF02DC68BD8CA9DA9F95437A0")
        
public final int read() throws IOException {
            return readAssetChar(mAsset);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.951 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "ECE1D6ECA75A8A8ED8EB2B04120D5135")
        
public final boolean markSupported() {
            return true;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.953 -0500", hash_original_method = "A5BC52EF5476CDC51345AEEDA1CB06B3", hash_generated_method = "9A118EF71C01252270807CF69ED2E9B3")
        
public final int available() throws IOException {
            long len = getAssetRemainingLength(mAsset);
            return len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.956 -0500", hash_original_method = "DCE38A6652895F3698A02DE5A8538C09", hash_generated_method = "7F98211E936CF3939DA38782C58B948D")
        
public final void close() throws IOException {
            synchronized (AssetManager.this) {
                if (mAsset != 0) {
                    destroyAsset(mAsset);
                    mAsset = 0;
                    decRefsLocked(hashCode());
                }
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.958 -0500", hash_original_method = "7D579BCE4EC4312918D553C49FF13AB2", hash_generated_method = "977D6F31208D48FB57BDC64B6E37A6A5")
        
public final void mark(int readlimit) {
            mMarkPos = seekAsset(mAsset, 0, 0);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.961 -0500", hash_original_method = "659AE57C7CC5071324BF80AF83D49F86", hash_generated_method = "3A811A990EBB42A09F40A22D83164D1C")
        
public final void reset() throws IOException {
            seekAsset(mAsset, mMarkPos, -1);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.963 -0500", hash_original_method = "5E34804727014E6FD2F3F87A050AF853", hash_generated_method = "FAB13CFE38B404055F48C43FA31E67F2")
        
public final int read(byte[] b) throws IOException {
            return readAsset(mAsset, b, 0, b.length);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.965 -0500", hash_original_method = "AA634A995A76E648DEC57A4EAA0F35C1", hash_generated_method = "F9A24935554623E12AC412D1B6AA4148")
        
public final int read(byte[] b, int off, int len) throws IOException {
            return readAsset(mAsset, b, off, len);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.967 -0500", hash_original_method = "A27B064C1368239357036D853D73FA32", hash_generated_method = "395A4373A1A2A3DCE0EE309C140EF460")
        
public final long skip(long n) throws IOException {
            long pos = seekAsset(mAsset, 0, 0);
            if ((pos+n) > mLength) {
                n = mLength-pos;
            }
            if (n > 0) {
                seekAsset(mAsset, n, 0);
            }
            return n;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:02.969 -0500", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "0BF8996A0A6FCACED5B5E8AA34F655BA")
        
protected void finalize() throws Throwable
        {
            close();
        }

        
    }
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.086 -0500", hash_original_method = "12B5557C9EEBFED6DAC54E4D9FC20DDD", hash_generated_method = "3587482D0B16DC1FDE364CD1782FA043")
    
    final boolean retrieveAttributes(
                int xmlParser, int[] inAttrs, int[] outValues, int[] outIndices){
    	//Formerly a native method
    	addTaint(xmlParser);
    	addTaint(inAttrs[0]);
    	addTaint(outValues[0]);
    	addTaint(outIndices[0]);
    	return getTaintBoolean();
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.090 -0500", hash_original_method = "34A3EC70D4ACE5655FFEE77E96A0F3BC", hash_generated_method = "0E256224C508FC760FE951A98AAA3064")
    
    final int getArraySize(int resource){
    	//Formerly a native method
    	addTaint(resource);
    	return getTaintInt();
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.094 -0500", hash_original_method = "6AA3B6ADCA3DD4B26249D05025D281C3", hash_generated_method = "9B06617068AC7DD50401F08FF26E4A44")
    
    final int retrieveArray(int resource, int[] outValues){
    	//Formerly a native method
    	addTaint(resource);
    	addTaint(outValues[0]);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.098 -0500", hash_original_method = "8643075126929A48F7EB079E8C4278DD", hash_generated_method = "85F34E6DC08510D34BC2CB3B7C0659AA")
    
    private final int getStringBlockCount(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.101 -0500", hash_original_method = "FB0E199BF31B4B98A791A0A97B553C67", hash_generated_method = "A03F7FD8383261188425D7BF1D947719")
    
    private final int getNativeStringBlock(int block){
    	//Formerly a native method
    	addTaint(block);
    	return getTaintInt();
    }


    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.442 -0400", hash_original_method = "4BCE1B9C1615D4EB059442B0FC3D8208", hash_generated_method = "B12B3AC485F057CA49E8D0EDA1BD9B08")
    @DSModeled(DSC.SAFE)
    public final String getCookieName(int cookie) {
    	return "";
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.120 -0500", hash_original_method = "4A1BDBE10C6D7479DE706205ED3F0C83", hash_generated_method = "BD1B64559154297AB2C8D63E5FA57C91")
    
    private final int newTheme(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.124 -0500", hash_original_method = "CA31B66AC1745FBADC98731EBEE7AB46", hash_generated_method = "4212C6AD97F6D8935AD6BE68323DDE50")
    
    private final void deleteTheme(int theme){
    	//Formerly a native method
    	addTaint(theme);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.142 -0500", hash_original_method = "F8A041F054DE87147DC380F35C857F31", hash_generated_method = "5F0B891DF945B3D6645BA50A72D74B67")
    
    private final int openXmlAssetNative(int cookie, String fileName){
    	//Formerly a native method
    	addTaint(cookie);
    	addTaint(fileName.getTaint());
    	return getTaintInt();
    }


    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.457 -0400", hash_original_method = "8CA605217ABF9ACD4B0F75B79941D8AD", hash_generated_method = "5F37EF7284C2ED80B62ED2FD114F081D")
    private final String[] getArrayStringResource(int arrayRes) {
    	String[] ret = {""};
    	return ret;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.149 -0500", hash_original_method = "341A9383D92FC9E302B0B298621A3766", hash_generated_method = "0B451BEDF512B4E06C0714E7C551A4B0")
    
    private final int[] getArrayStringInfo(int arrayRes){
    	//Formerly a native method
    	addTaint(arrayRes);
    	return new int[]{getTaintInt(),};
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.153 -0500", hash_original_method = "BCA05693B8244B417FF82C9EDF7FB611", hash_generated_method = "699B8CDEB6855C8A723437CCC5A97E63")
    
    final int[] getArrayIntResource(int arrayRes){
    	//Formerly a native method
    	addTaint(arrayRes);
    	return new int[]{getTaintInt(),};
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.157 -0500", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "63B40292B395EEA932919999AB750BE0")
    
    private final void init(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.160 -0500", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "3A9765D4DB060B4FEE0666AA04B388EF")
    
    private final void destroy(){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.163 -0500", hash_original_method = "8CCD44610E895D23EA7CFE3FA359ACA0", hash_generated_method = "7929C286026DADE24F3B7C87A664A348")
    
private final void incRefsLocked(int id) {
        if (DEBUG_REFS) {
            if (mRefStacks == null) {
                mRefStacks = new HashMap<Integer, RuntimeException>();
                RuntimeException ex = new RuntimeException();
                ex.fillInStackTrace();
                mRefStacks.put(this.hashCode(), ex);
            }
        }
        mNumRefs++;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:03.166 -0500", hash_original_method = "5BE87735DD6C438E2E8B68210C5CE018", hash_generated_method = "228C7FCA1DBDA649BCE37EF7BE67ABA4")
    
private final void decRefsLocked(int id) {
        if (DEBUG_REFS && mRefStacks != null) {
            mRefStacks.remove(id);
        }
        mNumRefs--;
        //System.out.println("Dec streams: mNumRefs=" + mNumRefs
        //                   + " mReleased=" + mReleased);
        if (mNumRefs == 0) {
            destroy();
        }
    }
}

