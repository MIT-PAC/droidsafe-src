package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.TypedValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public final class AssetManager {
    private TypedValue mValue = new TypedValue();
    private long[] mOffsets = new long[2];
    private int mObject;
    private int mNObject;
    private StringBlock mStringBlocks[] = null;
    private int mNumRefs = 1;
    private boolean mOpen = true;
    private HashMap<Integer, RuntimeException> mRefStacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.054 -0400", hash_original_method = "59A199C9627818EA5BC55C2223B1B671", hash_generated_method = "A69DA3E8689F58726543D9DBEDBA3F73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssetManager() {
        {
            {
                mNumRefs = 0;
                incRefsLocked(this.hashCode());
            } //End block
            init();
            ensureSystemAssets();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (DEBUG_REFS) {
                //mNumRefs = 0;
                //incRefsLocked(this.hashCode());
            //}
            //init();
            //if (localLOGV) Log.v(TAG, "New asset manager: " + this);
            //ensureSystemAssets();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.055 -0400", hash_original_method = "517E3FEC19C254F005880DBF363FE7AF", hash_generated_method = "D566A64C4EB1657795C9F2E4444025F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AssetManager(boolean isSystem) {
        dsTaint.addTaint(isSystem);
        {
            {
                mNumRefs = 0;
                incRefsLocked(this.hashCode());
            } //End block
        } //End block
        init();
        // ---------- Original Method ----------
        //if (DEBUG_REFS) {
            //synchronized (this) {
                //mNumRefs = 0;
                //incRefsLocked(this.hashCode());
            //}
        //}
        //init();
        //if (localLOGV) Log.v(TAG, "New asset manager: " + this);
    }

    
        private static void ensureSystemAssets() {
        synchronized (sSync) {
            if (sSystem == null) {
                AssetManager system = new AssetManager(true);
                system.makeStringBlocks(false);
                sSystem = system;
            }
        }
    }

    
        public static AssetManager getSystem() {
        ensureSystemAssets();
        return sSystem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.057 -0400", hash_original_method = "2C3B764DDE8F79C85110BA90D40DB7B8", hash_generated_method = "A6501E83B35ABE6A99FFC47B746745BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        {
            {
                mOpen = false;
                decRefsLocked(this.hashCode());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //if (mOpen) {
                //mOpen = false;
                //decRefsLocked(this.hashCode());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.057 -0400", hash_original_method = "CB81F9A1A3C0416B5CF420A3F62514E3", hash_generated_method = "2A896ACA20D0A514091EE9A9187C2DF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final CharSequence getResourceText(int ident) {
        dsTaint.addTaint(ident);
        {
            TypedValue tmpValue;
            tmpValue = mValue;
            int block;
            block = loadResourceValue(ident, (short) 0, tmpValue, true);
            {
                {
                    CharSequence var747A6D32C3D82F99223EF45CF3A73B35_85958217 = (mStringBlocks[block].get(tmpValue.data));
                } //End block
                CharSequence var5200720FC65BCF35BAA60FEC9418BD99_1072588837 = (tmpValue.coerceToString());
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //TypedValue tmpValue = mValue;
            //int block = loadResourceValue(ident, (short) 0, tmpValue, true);
            //if (block >= 0) {
                //if (tmpValue.type == TypedValue.TYPE_STRING) {
                    //return mStringBlocks[block].get(tmpValue.data);
                //}
                //return tmpValue.coerceToString();
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.058 -0400", hash_original_method = "2C5FA72B5D3C88AECCC2C4639A2FC63C", hash_generated_method = "B70F6362A4F0C0C5028AF9DD1005B173")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final CharSequence getResourceBagText(int ident, int bagEntryId) {
        dsTaint.addTaint(ident);
        dsTaint.addTaint(bagEntryId);
        {
            TypedValue tmpValue;
            tmpValue = mValue;
            int block;
            block = loadResourceBagValue(ident, bagEntryId, tmpValue, true);
            {
                {
                    CharSequence var747A6D32C3D82F99223EF45CF3A73B35_1552463412 = (mStringBlocks[block].get(tmpValue.data));
                } //End block
                CharSequence var5200720FC65BCF35BAA60FEC9418BD99_1163475421 = (tmpValue.coerceToString());
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (this) {
            //TypedValue tmpValue = mValue;
            //int block = loadResourceBagValue(ident, bagEntryId, tmpValue, true);
            //if (block >= 0) {
                //if (tmpValue.type == TypedValue.TYPE_STRING) {
                    //return mStringBlocks[block].get(tmpValue.data);
                //}
                //return tmpValue.coerceToString();
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.058 -0400", hash_original_method = "15AFE30CDC312B3891A5A8072BD8524F", hash_generated_method = "EAECA902A093388D2C0355C5B9D28C8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final String[] getResourceStringArray(final int id) {
        dsTaint.addTaint(id);
        String[] retArray;
        retArray = getArrayStringResource(id);
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //String[] retArray = getArrayStringResource(id);
        //return retArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.059 -0400", hash_original_method = "880DADF9021E8E0236DAC9AB890DE1A9", hash_generated_method = "4584A3E408001584CD9D8515C40BFFFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean getResourceValue(int ident,
                                               int density,
                                               TypedValue outValue,
                                               boolean resolveRefs) {
        dsTaint.addTaint(density);
        dsTaint.addTaint(ident);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(resolveRefs);
        int block;
        block = loadResourceValue(ident, (short) density, outValue, resolveRefs);
        {
            outValue.string = mStringBlocks[block].get(outValue.data);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int block = loadResourceValue(ident, (short) density, outValue, resolveRefs);
        //if (block >= 0) {
            //if (outValue.type != TypedValue.TYPE_STRING) {
                //return true;
            //}
            //outValue.string = mStringBlocks[block].get(outValue.data);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.059 -0400", hash_original_method = "5C4180581403390570CBF3420B87F392", hash_generated_method = "8AEDB48554773B129413EDFD41374C62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final CharSequence[] getResourceTextArray(final int id) {
        dsTaint.addTaint(id);
        int[] rawInfoArray;
        rawInfoArray = getArrayStringInfo(id);
        int rawInfoArrayLen;
        rawInfoArrayLen = rawInfoArray.length;
        int infoArrayLen;
        infoArrayLen = rawInfoArrayLen / 2;
        int block;
        int index;
        CharSequence[] retArray;
        retArray = new CharSequence[infoArrayLen];
        {
            int i, j;
            i = 0;
            j = 0;
            i = i + 2;
            {
                block = rawInfoArray[i];
                index = rawInfoArray[i + 1];
                retArray[j] = index >= 0 ? mStringBlocks[block].get(index) : null;
            } //End block
        } //End collapsed parenthetic
        CharSequence[] retVal = new CharSequence[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //int[] rawInfoArray = getArrayStringInfo(id);
        //int rawInfoArrayLen = rawInfoArray.length;
        //final int infoArrayLen = rawInfoArrayLen / 2;
        //int block;
        //int index;
        //CharSequence[] retArray = new CharSequence[infoArrayLen];
        //for (int i = 0, j = 0; i < rawInfoArrayLen; i = i + 2, j++) {
            //block = rawInfoArray[i];
            //index = rawInfoArray[i + 1];
            //retArray[j] = index >= 0 ? mStringBlocks[block].get(index) : null;
        //}
        //return retArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.060 -0400", hash_original_method = "257E397E5CF934BBA53C0ACDE849DFE1", hash_generated_method = "AD0B4353B6CDAD59A732807C4B093368")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean getThemeValue(int theme, int ident,
            TypedValue outValue, boolean resolveRefs) {
        dsTaint.addTaint(ident);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(theme);
        dsTaint.addTaint(resolveRefs);
        int block;
        block = loadThemeAttributeValue(theme, ident, outValue, resolveRefs);
        {
            StringBlock[] blocks;
            blocks = mStringBlocks;
            {
                ensureStringBlocks();
                blocks = mStringBlocks;
            } //End block
            outValue.string = blocks[block].get(outValue.data);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int block = loadThemeAttributeValue(theme, ident, outValue, resolveRefs);
        //if (block >= 0) {
            //if (outValue.type != TypedValue.TYPE_STRING) {
                //return true;
            //}
            //StringBlock[] blocks = mStringBlocks;
            //if (blocks == null) {
                //ensureStringBlocks();
                //blocks = mStringBlocks;
            //}
            //outValue.string = blocks[block].get(outValue.data);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.060 -0400", hash_original_method = "BC550AAFCB31C90ECB8DB7C3E260076C", hash_generated_method = "6435128ECE7F4777C0BFB994BF67EDBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void ensureStringBlocks() {
        {
            {
                {
                    makeStringBlocks(true);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mStringBlocks == null) {
            //synchronized (this) {
                //if (mStringBlocks == null) {
                    //makeStringBlocks(true);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.060 -0400", hash_original_method = "EDCC94234F08B09DDE56D32F4E25BC85", hash_generated_method = "22BF192C1E21F94B2AA46158D6250D6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void makeStringBlocks(boolean copyFromSystem) {
        dsTaint.addTaint(copyFromSystem);
        int sysNum;
        sysNum = sSystem.mStringBlocks.length;
        sysNum = 0;
        int num;
        num = getStringBlockCount();
        mStringBlocks = new StringBlock[num];
        {
            int i;
            i = 0;
            {
                {
                    mStringBlocks[i] = sSystem.mStringBlocks[i];
                } //End block
                {
                    mStringBlocks[i] = new StringBlock(getNativeStringBlock(i), true);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int sysNum = copyFromSystem ? sSystem.mStringBlocks.length : 0;
        //final int num = getStringBlockCount();
        //mStringBlocks = new StringBlock[num];
        //if (localLOGV) Log.v(TAG, "Making string blocks for " + this
                //+ ": " + num);
        //for (int i=0; i<num; i++) {
            //if (i < sysNum) {
                //mStringBlocks[i] = sSystem.mStringBlocks[i];
            //} else {
                //mStringBlocks[i] = new StringBlock(getNativeStringBlock(i), true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.061 -0400", hash_original_method = "148EA8945A31568904B22E1C4951294F", hash_generated_method = "153CEC706D49FCBA3E19791925F296D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final CharSequence getPooledString(int block, int id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(block);
        CharSequence var2FB0EBD01C989B705B8AA64E1D1A9B7D_799328023 = (mStringBlocks[block-1].get(id));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mStringBlocks[block-1].get(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.061 -0400", hash_original_method = "7E1B14522C484E4F1B470AEA16F877D6", hash_generated_method = "B614B4380B9C3A4656FC5EC12D65FEEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream open(String fileName) throws IOException {
        dsTaint.addTaint(fileName);
        InputStream varAB31E48FA16E0E586786604F8F82CDBD_1481547524 = (open(fileName, ACCESS_STREAMING));
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return open(fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.061 -0400", hash_original_method = "EB9FEA0B2CEADB65FF0921C2B52A13F4", hash_generated_method = "0D4862DEE69495BA2B234D442217864D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream open(String fileName, int accessMode) throws IOException {
        dsTaint.addTaint(accessMode);
        dsTaint.addTaint(fileName);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int asset;
            asset = openAsset(fileName, accessMode);
            {
                AssetInputStream res;
                res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset file: " + fileName);
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mOpen) {
                //throw new RuntimeException("Assetmanager has been closed");
            //}
            //int asset = openAsset(fileName, accessMode);
            //if (asset != 0) {
                //AssetInputStream res = new AssetInputStream(asset);
                //incRefsLocked(res.hashCode());
                //return res;
            //}
        //}
        //throw new FileNotFoundException("Asset file: " + fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.062 -0400", hash_original_method = "66D3D468B1706A8E526F268E61D6D3C7", hash_generated_method = "F686282B6A4BF3FD2E1EA7A9CBEC0E5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AssetFileDescriptor openFd(String fileName) throws IOException {
        dsTaint.addTaint(fileName);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            ParcelFileDescriptor pfd;
            pfd = openAssetFd(fileName, mOffsets);
            {
                AssetFileDescriptor var7529102D9A276779C01302F9A9135AF2_179781937 = (new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]));
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset file: " + fileName);
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mOpen) {
                //throw new RuntimeException("Assetmanager has been closed");
            //}
            //ParcelFileDescriptor pfd = openAssetFd(fileName, mOffsets);
            //if (pfd != null) {
                //return new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            //}
        //}
        //throw new FileNotFoundException("Asset file: " + fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.062 -0400", hash_original_method = "BFE0DD4127D11EE8C7DC2AF7F1625EB3", hash_generated_method = "81BC26E9FD869EF3BB92B225E4740C82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String[] list(String path) throws IOException {
        dsTaint.addTaint(path);
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.062 -0400", hash_original_method = "B416CA2D934FFC444AFFEA95F80C0673", hash_generated_method = "B2984BD639F47E5A48D41F6DF2EEE9DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream openNonAsset(String fileName) throws IOException {
        dsTaint.addTaint(fileName);
        InputStream var9605422D6A5365A30A544F5BC8368736_270655485 = (openNonAsset(0, fileName, ACCESS_STREAMING));
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.063 -0400", hash_original_method = "6F98937B657C3DF287FD2A6608D5C403", hash_generated_method = "747A874E93D2421520E712F1B912D475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream openNonAsset(String fileName, int accessMode) throws IOException {
        dsTaint.addTaint(accessMode);
        dsTaint.addTaint(fileName);
        InputStream var211B711A11721A99A7A9A4493EFF5C8A_1650585158 = (openNonAsset(0, fileName, accessMode));
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, accessMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.063 -0400", hash_original_method = "DECD09E6B1808DA43562160A03482F49", hash_generated_method = "0D4314A92A7E2AF861A6FE1F00B23329")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream openNonAsset(int cookie, String fileName) throws IOException {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(fileName);
        InputStream var2A361830EC5B7807729DAC3457304EB9_1843082786 = (openNonAsset(cookie, fileName, ACCESS_STREAMING));
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openNonAsset(cookie, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.063 -0400", hash_original_method = "5BC280B3003CA7B8CFB3A2FB67C4E385", hash_generated_method = "3131DB21DD1FCA179F94E77454EB826C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream openNonAsset(int cookie, String fileName, int accessMode) throws IOException {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(accessMode);
        dsTaint.addTaint(fileName);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int asset;
            asset = openNonAssetNative(cookie, fileName, accessMode);
            {
                AssetInputStream res;
                res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset absolute file: " + fileName);
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mOpen) {
                //throw new RuntimeException("Assetmanager has been closed");
            //}
            //int asset = openNonAssetNative(cookie, fileName, accessMode);
            //if (asset != 0) {
                //AssetInputStream res = new AssetInputStream(asset);
                //incRefsLocked(res.hashCode());
                //return res;
            //}
        //}
        //throw new FileNotFoundException("Asset absolute file: " + fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.064 -0400", hash_original_method = "E6C638BB28F04E787E5711BF8F421102", hash_generated_method = "9ACEC9225C4A6FEF0A827CD1652CCDFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AssetFileDescriptor openNonAssetFd(String fileName) throws IOException {
        dsTaint.addTaint(fileName);
        AssetFileDescriptor var8DF85496AD417EDB3C857E07FCD09E5E_1955460813 = (openNonAssetFd(0, fileName));
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openNonAssetFd(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.064 -0400", hash_original_method = "A0DC944B46306DDC2CA1031D9C43AC47", hash_generated_method = "35E1048CC67977CA10B9B1163DC60BA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final AssetFileDescriptor openNonAssetFd(int cookie,
            String fileName) throws IOException {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(fileName);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            ParcelFileDescriptor pfd;
            pfd = openNonAssetFdNative(cookie,
                    fileName, mOffsets);
            {
                AssetFileDescriptor var7529102D9A276779C01302F9A9135AF2_1353695760 = (new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]));
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset absolute file: " + fileName);
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mOpen) {
                //throw new RuntimeException("Assetmanager has been closed");
            //}
            //ParcelFileDescriptor pfd = openNonAssetFdNative(cookie,
                    //fileName, mOffsets);
            //if (pfd != null) {
                //return new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            //}
        //}
        //throw new FileNotFoundException("Asset absolute file: " + fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.064 -0400", hash_original_method = "602B0A8D272774ACD0101F14F2575F17", hash_generated_method = "6839553F2F48BADE16D5771C174448A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final XmlResourceParser openXmlResourceParser(String fileName) throws IOException {
        dsTaint.addTaint(fileName);
        XmlResourceParser varB3244557841A22C57996A99C43B66DE3_416502450 = (openXmlResourceParser(0, fileName));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openXmlResourceParser(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.065 -0400", hash_original_method = "06F5CBF51BDA69D9C47BB01131F079C4", hash_generated_method = "AC4C76890E237E41F553B263425A0160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final XmlResourceParser openXmlResourceParser(int cookie,
            String fileName) throws IOException {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(fileName);
        XmlBlock block;
        block = openXmlBlockAsset(cookie, fileName);
        XmlResourceParser rp;
        rp = block.newParser();
        block.close();
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //XmlBlock block = openXmlBlockAsset(cookie, fileName);
        //XmlResourceParser rp = block.newParser();
        //block.close();
        //return rp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.065 -0400", hash_original_method = "675415F1EB93293576759C69BAEA6DCB", hash_generated_method = "8FDA52AB563922457F55F058A6039012")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final XmlBlock openXmlBlockAsset(String fileName) throws IOException {
        dsTaint.addTaint(fileName);
        XmlBlock varC0FD185D2A2B5D1F9928F67BA2682B32_1775580255 = (openXmlBlockAsset(0, fileName));
        return (XmlBlock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openXmlBlockAsset(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.066 -0400", hash_original_method = "9588BC172FA11EB2767F6277EAB2B09E", hash_generated_method = "B3D80BD9A254074125860B2221BA0735")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final XmlBlock openXmlBlockAsset(int cookie, String fileName) throws IOException {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(fileName);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int xmlBlock;
            xmlBlock = openXmlAssetNative(cookie, fileName);
            {
                XmlBlock res;
                res = new XmlBlock(this, xmlBlock);
                incRefsLocked(res.hashCode());
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset XML file: " + fileName);
        return (XmlBlock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mOpen) {
                //throw new RuntimeException("Assetmanager has been closed");
            //}
            //int xmlBlock = openXmlAssetNative(cookie, fileName);
            //if (xmlBlock != 0) {
                //XmlBlock res = new XmlBlock(this, xmlBlock);
                //incRefsLocked(res.hashCode());
                //return res;
            //}
        //}
        //throw new FileNotFoundException("Asset XML file: " + fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.066 -0400", hash_original_method = "30EAECC95AEB342DDD14100667205DCF", hash_generated_method = "3A658431817A563CBCCFF43E994EDE07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void xmlBlockGone(int id) {
        dsTaint.addTaint(id);
        {
            decRefsLocked(id);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //decRefsLocked(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.067 -0400", hash_original_method = "9AD5347899C2D862F4815C023E5977D1", hash_generated_method = "F7B1B2D4C682A4E5B96F0E1261C3CE38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final int createTheme() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int res;
            res = newTheme();
            incRefsLocked(res);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (!mOpen) {
                //throw new RuntimeException("Assetmanager has been closed");
            //}
            //int res = newTheme();
            //incRefsLocked(res);
            //return res;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.068 -0400", hash_original_method = "0E7F795DABC0415CCAB4CA5A0005DBB0", hash_generated_method = "5445ABE3D800B133DBDF2B5B7E4E4A05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void releaseTheme(int theme) {
        dsTaint.addTaint(theme);
        {
            deleteTheme(theme);
            decRefsLocked(theme);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //deleteTheme(theme);
            //decRefsLocked(theme);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.073 -0400", hash_original_method = "C1D87D935BC2D519032BCC6CD9CB5D9B", hash_generated_method = "933E787D92180FC76E17C55600F857F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        try 
        {
            {
                {
                    {
                        Iterator<RuntimeException> var6A8D9EF0A851170F32FF1EDD9601BB79_215943809 = (mRefStacks.values()).iterator();
                        var6A8D9EF0A851170F32FF1EDD9601BB79_215943809.hasNext();
                        RuntimeException e = var6A8D9EF0A851170F32FF1EDD9601BB79_215943809.next();
                    } //End collapsed parenthetic
                } //End block
            } //End block
            destroy();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (DEBUG_REFS && mNumRefs != 0) {
                //Log.w(TAG, "AssetManager " + this
                        //+ " finalized with non-zero refs: " + mNumRefs);
                //if (mRefStacks != null) {
                    //for (RuntimeException e : mRefStacks.values()) {
                        //Log.w(TAG, "Reference from here", e);
                    //}
                //}
            //}
            //destroy();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.073 -0400", hash_original_method = "18B8C5816FBF862D1286972549E79177", hash_generated_method = "6CBE89D6EE011D1A7D9F354A72A2130E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int addAssetPath(String path) {
        dsTaint.addTaint(path);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.073 -0400", hash_original_method = "22EE91EE70E10361F8012967A8F2990A", hash_generated_method = "E8D7F2FFB8065FD16B8532A8B40B586B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int[] addAssetPaths(String[] paths) {
        dsTaint.addTaint(paths[0]);
        int[] cookies;
        cookies = new int[paths.length];
        {
            int i;
            i = 0;
            {
                cookies[i] = addAssetPath(paths[i]);
            } //End block
        } //End collapsed parenthetic
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (paths == null) {
            //return null;
        //}
        //int[] cookies = new int[paths.length];
        //for (int i = 0; i < paths.length; i++) {
            //cookies[i] = addAssetPath(paths[i]);
        //}
        //return cookies;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.073 -0400", hash_original_method = "6E60478B72DEC0ABE7A87F31E1844E8F", hash_generated_method = "B0188479A7FF2865FC9FFDB3756893B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isUpToDate() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.074 -0400", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "A5ED7487A623B360685C26D9F3589951")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setLocale(String locale) {
        dsTaint.addTaint(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.074 -0400", hash_original_method = "3CB696CCF0EE1BB70EEADB93E6432982", hash_generated_method = "704F5DA3C58E120776A9ABAEED773D63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String[] getLocales() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.074 -0400", hash_original_method = "0D7945B64E12882B3ACBA2198421753F", hash_generated_method = "CBE52531A714825DC519A518F9F7E668")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setConfiguration(int mcc, int mnc, String locale,
            int orientation, int touchscreen, int density, int keyboard,
            int keyboardHidden, int navigation, int screenWidth, int screenHeight,
            int smallestScreenWidthDp, int screenWidthDp, int screenHeightDp,
            int screenLayout, int uiMode, int majorVersion) {
        dsTaint.addTaint(screenHeight);
        dsTaint.addTaint(orientation);
        dsTaint.addTaint(screenLayout);
        dsTaint.addTaint(keyboard);
        dsTaint.addTaint(majorVersion);
        dsTaint.addTaint(density);
        dsTaint.addTaint(mcc);
        dsTaint.addTaint(locale);
        dsTaint.addTaint(screenWidthDp);
        dsTaint.addTaint(uiMode);
        dsTaint.addTaint(screenHeightDp);
        dsTaint.addTaint(navigation);
        dsTaint.addTaint(screenWidth);
        dsTaint.addTaint(smallestScreenWidthDp);
        dsTaint.addTaint(keyboardHidden);
        dsTaint.addTaint(mnc);
        dsTaint.addTaint(touchscreen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.074 -0400", hash_original_method = "09A813727514834940DA6C6317E3DBCE", hash_generated_method = "4AD53698B42861C3CD4A76F643B1A631")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final int getResourceIdentifier(String type,
                                                       String name,
                                                       String defPackage) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(type);
        dsTaint.addTaint(defPackage);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.075 -0400", hash_original_method = "A5876C7E6082BC9F857AB889162EC8D3", hash_generated_method = "7254084E11978EA2B1A7E91DA9ABAE6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final String getResourceName(int resid) {
        dsTaint.addTaint(resid);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.075 -0400", hash_original_method = "B7E19874BAD16ADDD401F7BE2B2EFFAD", hash_generated_method = "039E6928463328DE6BCDDC09C0C14D51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final String getResourcePackageName(int resid) {
        dsTaint.addTaint(resid);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.075 -0400", hash_original_method = "D3A87104246875F54A734A7CED9F3792", hash_generated_method = "A8D29B73520DAE4B76713F32FAA00B82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final String getResourceTypeName(int resid) {
        dsTaint.addTaint(resid);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.075 -0400", hash_original_method = "7C2D2224C9B46B19401BE8615244E9F1", hash_generated_method = "5AB28D19E3F823CF565432D438C50EED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final String getResourceEntryName(int resid) {
        dsTaint.addTaint(resid);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.076 -0400", hash_original_method = "CCB6CD4213F7E59AA2D59934C9160368", hash_generated_method = "DD159F772FCBC4761C8B20B4B212C878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int openAsset(String fileName, int accessMode) {
        dsTaint.addTaint(accessMode);
        dsTaint.addTaint(fileName);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.076 -0400", hash_original_method = "9CBF0316C59A074D9238537266A4CF39", hash_generated_method = "6518BF8AD57A6B1A4B0F04A727875854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final ParcelFileDescriptor openAssetFd(String fileName,
            long[] outOffsets) throws IOException {
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(outOffsets[0]);
        return (ParcelFileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.076 -0400", hash_original_method = "81CCCE789A5081BAF563B4B2EE08FF05", hash_generated_method = "6B55D2D704BA310D29D1842415A41C32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int openNonAssetNative(int cookie, String fileName,
            int accessMode) {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(accessMode);
        dsTaint.addTaint(fileName);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.077 -0400", hash_original_method = "05F1691565177C2AFF700A7C71F6F6CD", hash_generated_method = "ABE12059B761377FD454173AA9DC3381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ParcelFileDescriptor openNonAssetFdNative(int cookie,
            String fileName, long[] outOffsets) throws IOException {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(outOffsets[0]);
        return (ParcelFileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.077 -0400", hash_original_method = "97A034179950872E547C89DFB8D9E922", hash_generated_method = "7F69D1D1031302843EC8FF712A0BC48E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void destroyAsset(int asset) {
        dsTaint.addTaint(asset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.077 -0400", hash_original_method = "5F1E2DF7C91A7E126E188B382F4854C7", hash_generated_method = "D4EA159D581B539EA8E6918736CF1145")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int readAssetChar(int asset) {
        dsTaint.addTaint(asset);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.078 -0400", hash_original_method = "47F4B97BBBCCF733A9E22BF028AA8D70", hash_generated_method = "50D01067C74A44646FD1C312B6A1CA18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int readAsset(int asset, byte[] b, int off, int len) {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(asset);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.078 -0400", hash_original_method = "B3BCAF9697DD27514E76657171CAECEC", hash_generated_method = "1EDD7EFE98F82D66513374350311F282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final long seekAsset(int asset, long offset, int whence) {
        dsTaint.addTaint(whence);
        dsTaint.addTaint(asset);
        dsTaint.addTaint(offset);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.078 -0400", hash_original_method = "A83D0C436C33F4BEE2F972AC578D7A68", hash_generated_method = "8554B8C5CB13915F083FC5D6B2AF1EA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final long getAssetLength(int asset) {
        dsTaint.addTaint(asset);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.078 -0400", hash_original_method = "7F3AC582AA5F20EF55343463044A3085", hash_generated_method = "9E75B9336DDD98739C35F1641688B0EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final long getAssetRemainingLength(int asset) {
        dsTaint.addTaint(asset);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.079 -0400", hash_original_method = "27B70155371A7D816D4F089317C25CF6", hash_generated_method = "0BA10BC68A17693094F16FFC8CD0423E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int loadResourceValue(int ident, short density, TypedValue outValue,
            boolean resolve) {
        dsTaint.addTaint(resolve);
        dsTaint.addTaint(density);
        dsTaint.addTaint(ident);
        dsTaint.addTaint(outValue.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.079 -0400", hash_original_method = "F08D438D948FB59FEDF35DA42629554E", hash_generated_method = "4D91F245C43FCA4A09E2590CFF8A40C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int loadResourceBagValue(int ident, int bagEntryId, TypedValue outValue,
                                               boolean resolve) {
        dsTaint.addTaint(resolve);
        dsTaint.addTaint(ident);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(bagEntryId);
        return dsTaint.getTaintInt();
    }

    
        static final boolean applyStyle(int theme,
            int defStyleAttr, int defStyleRes, int xmlParser,
            int[] inAttrs, int[] outValues, int[] outIndices) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.079 -0400", hash_original_method = "12B5557C9EEBFED6DAC54E4D9FC20DDD", hash_generated_method = "73FC14FEF4DE1DC8CF2201516F649762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean retrieveAttributes(
            int xmlParser, int[] inAttrs, int[] outValues, int[] outIndices) {
        dsTaint.addTaint(outValues[0]);
        dsTaint.addTaint(inAttrs[0]);
        dsTaint.addTaint(outIndices[0]);
        dsTaint.addTaint(xmlParser);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.079 -0400", hash_original_method = "34A3EC70D4ACE5655FFEE77E96A0F3BC", hash_generated_method = "0A1DFD44167FB71D950E77D6D5F9EA6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final int getArraySize(int resource) {
        dsTaint.addTaint(resource);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.080 -0400", hash_original_method = "6AA3B6ADCA3DD4B26249D05025D281C3", hash_generated_method = "AF748512EDFE777C894CF08ADAA43579")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final int retrieveArray(int resource, int[] outValues) {
        dsTaint.addTaint(outValues[0]);
        dsTaint.addTaint(resource);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.080 -0400", hash_original_method = "8643075126929A48F7EB079E8C4278DD", hash_generated_method = "89DD60B96305DC955E04A994F6D9FB0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int getStringBlockCount() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.080 -0400", hash_original_method = "FB0E199BF31B4B98A791A0A97B553C67", hash_generated_method = "5DDEBF480050364B4C5EFD00056B66C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int getNativeStringBlock(int block) {
        dsTaint.addTaint(block);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.080 -0400", hash_original_method = "4BCE1B9C1615D4EB059442B0FC3D8208", hash_generated_method = "A17E5B09358D50D7ACD9DC2918A302E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getCookieName(int cookie) {
        dsTaint.addTaint(cookie);
        return dsTaint.getTaintString();
    }

    
        public static final int getGlobalAssetCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final String getAssetAllocations() {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static final int getGlobalAssetManagerCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.081 -0400", hash_original_method = "4A1BDBE10C6D7479DE706205ED3F0C83", hash_generated_method = "D57D8FD32C36BC6D04FDDFFF4A3437C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int newTheme() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.081 -0400", hash_original_method = "CA31B66AC1745FBADC98731EBEE7AB46", hash_generated_method = "3584609A00204BB81F1237B8DD26DF00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void deleteTheme(int theme) {
        dsTaint.addTaint(theme);
    }

    
        static final void applyThemeStyle(int theme, int styleRes, boolean force) {
    }

    
        static final void copyTheme(int dest, int source) {
    }

    
        static final int loadThemeAttributeValue(int theme, int ident,
                                                                TypedValue outValue,
                                                                boolean resolve) {
        return DSUtils.UNKNOWN_INT;
    }

    
        static final void dumpTheme(int theme, int priority, String tag, String prefix) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.082 -0400", hash_original_method = "F8A041F054DE87147DC380F35C857F31", hash_generated_method = "4E8500B4ABB834034692F9DD4167FEF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int openXmlAssetNative(int cookie, String fileName) {
        dsTaint.addTaint(cookie);
        dsTaint.addTaint(fileName);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.082 -0400", hash_original_method = "8CA605217ABF9ACD4B0F75B79941D8AD", hash_generated_method = "D1AB4EDBAE74170325D371059F98D2BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final String[] getArrayStringResource(int arrayRes) {
        dsTaint.addTaint(arrayRes);
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.082 -0400", hash_original_method = "341A9383D92FC9E302B0B298621A3766", hash_generated_method = "CAC36AED9970FC3B5AF6133ED7877944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int[] getArrayStringInfo(int arrayRes) {
        dsTaint.addTaint(arrayRes);
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.083 -0400", hash_original_method = "BCA05693B8244B417FF82C9EDF7FB611", hash_generated_method = "6B9748FC12A3CC92CA1C3C0D4DC18BD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final int[] getArrayIntResource(int arrayRes) {
        dsTaint.addTaint(arrayRes);
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.083 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.083 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.084 -0400", hash_original_method = "8CCD44610E895D23EA7CFE3FA359ACA0", hash_generated_method = "004BA74CA4A70376906B3B5197784FE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void incRefsLocked(int id) {
        dsTaint.addTaint(id);
        {
            {
                mRefStacks = new HashMap<Integer, RuntimeException>();
                RuntimeException ex;
                ex = new RuntimeException();
                ex.fillInStackTrace();
                mRefStacks.put(this.hashCode(), ex);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG_REFS) {
            //if (mRefStacks == null) {
                //mRefStacks = new HashMap<Integer, RuntimeException>();
                //RuntimeException ex = new RuntimeException();
                //ex.fillInStackTrace();
                //mRefStacks.put(this.hashCode(), ex);
            //}
        //}
        //mNumRefs++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.084 -0400", hash_original_method = "5BE87735DD6C438E2E8B68210C5CE018", hash_generated_method = "6285952A29D8DE9C64AAEF24533B4749")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void decRefsLocked(int id) {
        dsTaint.addTaint(id);
        {
            mRefStacks.remove(id);
        } //End block
        {
            destroy();
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG_REFS && mRefStacks != null) {
            //mRefStacks.remove(id);
        //}
        //mNumRefs--;
        //if (mNumRefs == 0) {
            //destroy();
        //}
    }

    
    public final class AssetInputStream extends InputStream {
        private int mAsset;
        private long mLength;
        private long mMarkPos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.084 -0400", hash_original_method = "73FC7BCEFA9398CB2657C7ECCED60E53", hash_generated_method = "4EBF9A72DA498B23ACB5531B2EAD4092")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private AssetInputStream(int asset) {
            dsTaint.addTaint(asset);
            mLength = getAssetLength(asset);
            // ---------- Original Method ----------
            //mAsset = asset;
            //mLength = getAssetLength(asset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.085 -0400", hash_original_method = "E464EBBB8C3DAC741E7C7914FE6096F4", hash_generated_method = "FC631F9A7344DDD9CAFB530637C57508")
        @DSModeled(DSC.SAFE)
        public final int getAssetInt() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mAsset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.086 -0400", hash_original_method = "C81989D37BD2D192408FD3EC31DA3DAD", hash_generated_method = "C13588088F4C6561222CFD2B818FA6BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int read() throws IOException {
            int varE1E0B1D2F32964F8EA30248A4FEDD33A_1631351710 = (readAssetChar(mAsset));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return readAssetChar(mAsset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.087 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "D7333089A643E67D2F17C0437C9456A9")
        @DSModeled(DSC.SAFE)
        public final boolean markSupported() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.088 -0400", hash_original_method = "A5BC52EF5476CDC51345AEEDA1CB06B3", hash_generated_method = "7B7CB215E15E606C0F39E62EB298A3BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int available() throws IOException {
            long len;
            len = getAssetRemainingLength(mAsset);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //long len = getAssetRemainingLength(mAsset);
            //return len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.088 -0400", hash_original_method = "DCE38A6652895F3698A02DE5A8538C09", hash_generated_method = "71DF7957D705EC627EA69010F3B8ABED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void close() throws IOException {
            {
                Object var06E55DA388AD25C0173B0EDB061FCE4D_917792708 = (AssetManager.this);
                {
                    {
                        destroyAsset(mAsset);
                        mAsset = 0;
                        decRefsLocked(hashCode());
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //synchronized (AssetManager.this) {
                //if (mAsset != 0) {
                    //destroyAsset(mAsset);
                    //mAsset = 0;
                    //decRefsLocked(hashCode());
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.089 -0400", hash_original_method = "7D579BCE4EC4312918D553C49FF13AB2", hash_generated_method = "B6B4AF8A96873C35BEFCAF0D2A31F5FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void mark(int readlimit) {
            dsTaint.addTaint(readlimit);
            mMarkPos = seekAsset(mAsset, 0, 0);
            // ---------- Original Method ----------
            //mMarkPos = seekAsset(mAsset, 0, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.089 -0400", hash_original_method = "659AE57C7CC5071324BF80AF83D49F86", hash_generated_method = "0CAF64AFA3C71A633C3AE770A153F1FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void reset() throws IOException {
            seekAsset(mAsset, mMarkPos, -1);
            // ---------- Original Method ----------
            //seekAsset(mAsset, mMarkPos, -1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.090 -0400", hash_original_method = "5E34804727014E6FD2F3F87A050AF853", hash_generated_method = "0B548EB27292380FC9B58382F323F4E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int read(byte[] b) throws IOException {
            dsTaint.addTaint(b[0]);
            int var3CAE9971BC75CFC378BD3B49F33BE480_1302417962 = (readAsset(mAsset, b, 0, b.length));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.090 -0400", hash_original_method = "AA634A995A76E648DEC57A4EAA0F35C1", hash_generated_method = "87FE3C86A13ECA0E3ED5441DA1BD61BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int read(byte[] b, int off, int len) throws IOException {
            dsTaint.addTaint(b[0]);
            dsTaint.addTaint(off);
            dsTaint.addTaint(len);
            int var1CBB9CD65705D33AD4651F0428BDA301_1365159348 = (readAsset(mAsset, b, off, len));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, off, len);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.091 -0400", hash_original_method = "A27B064C1368239357036D853D73FA32", hash_generated_method = "BBBC001528AE6299CB6F1B867FFE839C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final long skip(long n) throws IOException {
            dsTaint.addTaint(n);
            long pos;
            pos = seekAsset(mAsset, 0, 0);
            {
                n = mLength-pos;
            } //End block
            {
                seekAsset(mAsset, n, 0);
            } //End block
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //long pos = seekAsset(mAsset, 0, 0);
            //if ((pos+n) > mLength) {
                //n = mLength-pos;
            //}
            //if (n > 0) {
                //seekAsset(mAsset, n, 0);
            //}
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.091 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
    }


    
    public static final int ACCESS_UNKNOWN = 0;
    public static final int ACCESS_RANDOM = 1;
    public static final int ACCESS_STREAMING = 2;
    public static final int ACCESS_BUFFER = 3;
    private static final String TAG = "AssetManager";
    private static final boolean localLOGV = false || false;
    private static final boolean DEBUG_REFS = false;
    private static final Object sSync = new Object();
    static AssetManager sSystem = null;
    static final int STYLE_NUM_ENTRIES = 6;
    static final int STYLE_TYPE = 0;
    static final int STYLE_DATA = 1;
    static final int STYLE_ASSET_COOKIE = 2;
    static final int STYLE_RESOURCE_ID = 3;
    static final int STYLE_CHANGING_CONFIGURATIONS = 4;
    static final int STYLE_DENSITY = 5;
}

