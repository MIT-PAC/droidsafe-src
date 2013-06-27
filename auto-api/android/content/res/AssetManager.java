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

public class AssetManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.822 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "97A5417ECE5AA6B704C38FE64B891A45")

    private TypedValue mValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.845 -0400", hash_original_field = "726DCB6228C12E2D638881A1E45E904A", hash_generated_field = "F2FC176A91498B14AC663D6FD8C7B568")

    private long[] mOffsets = new long[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.845 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.845 -0400", hash_original_field = "68D076ED220BAD43118C707808DC8CD0", hash_generated_field = "CC3C82762AC73E1C6FA469CFF14F9939")

    private int mNObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.845 -0400", hash_original_field = "E4AA04FA1027E6EAB6839BD0E48E31F5", hash_generated_field = "EC37C879DC6C6530C4627CE0DC66498D")

    private StringBlock mStringBlocks[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.846 -0400", hash_original_field = "2BFF3BD7B921429FFC5CFB18F72B0EC1", hash_generated_field = "32DC8A24B3C6E9B83A49CEC09007226E")

    private int mNumRefs = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.846 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.846 -0400", hash_original_field = "A38CAF679723AF33722554F6AF6CB3DB", hash_generated_field = "057DB168549C247D4E5C64EC3B4E7B98")

    private HashMap<Integer, RuntimeException> mRefStacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.857 -0400", hash_original_method = "59A199C9627818EA5BC55C2223B1B671", hash_generated_method = "A69DA3E8689F58726543D9DBEDBA3F73")
    public  AssetManager() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.858 -0400", hash_original_method = "517E3FEC19C254F005880DBF363FE7AF", hash_generated_method = "EE48D865FDC2F85257C75A310843F066")
    private  AssetManager(boolean isSystem) {
        {
            {
                mNumRefs = 0;
                incRefsLocked(this.hashCode());
            } //End block
        } //End block
        init();
        addTaint(isSystem);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.868 -0400", hash_original_method = "2C3B764DDE8F79C85110BA90D40DB7B8", hash_generated_method = "A6501E83B35ABE6A99FFC47B746745BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.870 -0400", hash_original_method = "CB81F9A1A3C0416B5CF420A3F62514E3", hash_generated_method = "F08454C6C116C2520BB58BD431611BFB")
    final CharSequence getResourceText(int ident) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1344936130 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1784935051 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_22497987 = null; //Variable for return #3
        {
            TypedValue tmpValue;
            tmpValue = mValue;
            int block;
            block = loadResourceValue(ident, (short) 0, tmpValue, true);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1344936130 = mStringBlocks[block].get(tmpValue.data);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1784935051 = tmpValue.coerceToString();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_22497987 = null;
        addTaint(ident);
        CharSequence varA7E53CE21691AB073D9660D615818899_1760833481; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1760833481 = varB4EAC82CA7396A68D541C85D26508E83_1344936130;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1760833481 = varB4EAC82CA7396A68D541C85D26508E83_1784935051;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1760833481 = varB4EAC82CA7396A68D541C85D26508E83_22497987;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1760833481.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1760833481;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.884 -0400", hash_original_method = "2C5FA72B5D3C88AECCC2C4639A2FC63C", hash_generated_method = "F1EF37515257BFDE8834DCEB51310AF9")
    final CharSequence getResourceBagText(int ident, int bagEntryId) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_65151061 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1170803745 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_53650749 = null; //Variable for return #3
        {
            TypedValue tmpValue;
            tmpValue = mValue;
            int block;
            block = loadResourceBagValue(ident, bagEntryId, tmpValue, true);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_65151061 = mStringBlocks[block].get(tmpValue.data);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1170803745 = tmpValue.coerceToString();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_53650749 = null;
        addTaint(ident);
        addTaint(bagEntryId);
        CharSequence varA7E53CE21691AB073D9660D615818899_1936815050; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1936815050 = varB4EAC82CA7396A68D541C85D26508E83_65151061;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1936815050 = varB4EAC82CA7396A68D541C85D26508E83_1170803745;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1936815050 = varB4EAC82CA7396A68D541C85D26508E83_53650749;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1936815050.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1936815050;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.888 -0400", hash_original_method = "15AFE30CDC312B3891A5A8072BD8524F", hash_generated_method = "519D79DAF61451D125F32743FDF911DE")
    final String[] getResourceStringArray(final int id) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1077163746 = null; //Variable for return #1
        String[] retArray;
        retArray = getArrayStringResource(id);
        varB4EAC82CA7396A68D541C85D26508E83_1077163746 = retArray;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1077163746.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1077163746;
        // ---------- Original Method ----------
        //String[] retArray = getArrayStringResource(id);
        //return retArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.904 -0400", hash_original_method = "880DADF9021E8E0236DAC9AB890DE1A9", hash_generated_method = "2D7BB61854049AD2B48F9BC8B19A285F")
    final boolean getResourceValue(int ident,
                                               int density,
                                               TypedValue outValue,
                                               boolean resolveRefs) {
        int block;
        block = loadResourceValue(ident, (short) density, outValue, resolveRefs);
        {
            outValue.string = mStringBlocks[block].get(outValue.data);
        } //End block
        addTaint(ident);
        addTaint(density);
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693274109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693274109;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.907 -0400", hash_original_method = "5C4180581403390570CBF3420B87F392", hash_generated_method = "A2600BCE71380BA7074DE063099380CA")
    final CharSequence[] getResourceTextArray(final int id) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_1319436415 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1319436415 = retArray;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1319436415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319436415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.047 -0400", hash_original_method = "257E397E5CF934BBA53C0ACDE849DFE1", hash_generated_method = "3F5D12D426260A6664D5F276F7287721")
    final boolean getThemeValue(int theme, int ident,
            TypedValue outValue, boolean resolveRefs) {
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
        addTaint(theme);
        addTaint(ident);
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385108083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385108083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.049 -0400", hash_original_method = "BC550AAFCB31C90ECB8DB7C3E260076C", hash_generated_method = "6435128ECE7F4777C0BFB994BF67EDBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.051 -0400", hash_original_method = "EDCC94234F08B09DDE56D32F4E25BC85", hash_generated_method = "2AEEC9CFDC40FFC7E7351BD518541D3B")
    final void makeStringBlocks(boolean copyFromSystem) {
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
        addTaint(copyFromSystem);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.077 -0400", hash_original_method = "148EA8945A31568904B22E1C4951294F", hash_generated_method = "BE178BAE8947566D965F4B94D318888F")
    final CharSequence getPooledString(int block, int id) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1935199906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1935199906 = mStringBlocks[block-1].get(id);
        addTaint(block);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1935199906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1935199906;
        // ---------- Original Method ----------
        //return mStringBlocks[block-1].get(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.079 -0400", hash_original_method = "7E1B14522C484E4F1B470AEA16F877D6", hash_generated_method = "C41221817CE647D1ACDE0A1CD8EBD969")
    public final InputStream open(String fileName) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2145519874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2145519874 = open(fileName, ACCESS_STREAMING);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2145519874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145519874;
        // ---------- Original Method ----------
        //return open(fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.086 -0400", hash_original_method = "EB9FEA0B2CEADB65FF0921C2B52A13F4", hash_generated_method = "0E95976EA7877A922FAF3147CB7FE6C7")
    public final InputStream open(String fileName, int accessMode) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1623943316 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_1623943316 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset file: " + fileName);
        addTaint(fileName.getTaint());
        addTaint(accessMode);
        varB4EAC82CA7396A68D541C85D26508E83_1623943316.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1623943316;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.099 -0400", hash_original_method = "66D3D468B1706A8E526F268E61D6D3C7", hash_generated_method = "AC2205B5172D54F713C4B1990FC445F0")
    public final AssetFileDescriptor openFd(String fileName) throws IOException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1048458607 = null; //Variable for return #1
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            ParcelFileDescriptor pfd;
            pfd = openAssetFd(fileName, mOffsets);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1048458607 = new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset file: " + fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1048458607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048458607;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.101 -0400", hash_original_method = "BFE0DD4127D11EE8C7DC2AF7F1625EB3", hash_generated_method = "5671ABB042797CD529E276FD90C5DEDA")
    public final String[] list(String path) throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.121 -0400", hash_original_method = "B416CA2D934FFC444AFFEA95F80C0673", hash_generated_method = "B26705A09E760B729DC59F9DF65E17AC")
    public final InputStream openNonAsset(String fileName) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_332241019 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_332241019 = openNonAsset(0, fileName, ACCESS_STREAMING);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_332241019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_332241019;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.123 -0400", hash_original_method = "6F98937B657C3DF287FD2A6608D5C403", hash_generated_method = "DAFC137E291E377D8E5293983B42833E")
    public final InputStream openNonAsset(String fileName, int accessMode) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_677353529 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_677353529 = openNonAsset(0, fileName, accessMode);
        addTaint(fileName.getTaint());
        addTaint(accessMode);
        varB4EAC82CA7396A68D541C85D26508E83_677353529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_677353529;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, accessMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.135 -0400", hash_original_method = "DECD09E6B1808DA43562160A03482F49", hash_generated_method = "F553819447EEF1B00A63DC69AB81835D")
    public final InputStream openNonAsset(int cookie, String fileName) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_317017498 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_317017498 = openNonAsset(cookie, fileName, ACCESS_STREAMING);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_317017498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_317017498;
        // ---------- Original Method ----------
        //return openNonAsset(cookie, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.155 -0400", hash_original_method = "5BC280B3003CA7B8CFB3A2FB67C4E385", hash_generated_method = "7F8ABE2BA38605953A277718F2E78C5F")
    public final InputStream openNonAsset(int cookie, String fileName, int accessMode) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1908214452 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_1908214452 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset absolute file: " + fileName);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        addTaint(accessMode);
        varB4EAC82CA7396A68D541C85D26508E83_1908214452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1908214452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.165 -0400", hash_original_method = "E6C638BB28F04E787E5711BF8F421102", hash_generated_method = "465D99F4F4D8B9F2C3DEF49804765884")
    public final AssetFileDescriptor openNonAssetFd(String fileName) throws IOException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_983859003 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_983859003 = openNonAssetFd(0, fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_983859003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_983859003;
        // ---------- Original Method ----------
        //return openNonAssetFd(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.167 -0400", hash_original_method = "A0DC944B46306DDC2CA1031D9C43AC47", hash_generated_method = "8EC954DE58F45BCAB366100981990700")
    public final AssetFileDescriptor openNonAssetFd(int cookie,
            String fileName) throws IOException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_87987703 = null; //Variable for return #1
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            ParcelFileDescriptor pfd;
            pfd = openNonAssetFdNative(cookie,
                    fileName, mOffsets);
            {
                varB4EAC82CA7396A68D541C85D26508E83_87987703 = new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset absolute file: " + fileName);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_87987703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_87987703;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.168 -0400", hash_original_method = "602B0A8D272774ACD0101F14F2575F17", hash_generated_method = "59C2BE03D9D4FE4D6F615ADF2E934AB5")
    public final XmlResourceParser openXmlResourceParser(String fileName) throws IOException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_28876588 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_28876588 = openXmlResourceParser(0, fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_28876588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_28876588;
        // ---------- Original Method ----------
        //return openXmlResourceParser(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.188 -0400", hash_original_method = "06F5CBF51BDA69D9C47BB01131F079C4", hash_generated_method = "DC28635B3A7D87F8E4AB535B50BACFED")
    public final XmlResourceParser openXmlResourceParser(int cookie,
            String fileName) throws IOException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_461864860 = null; //Variable for return #1
        XmlBlock block;
        block = openXmlBlockAsset(cookie, fileName);
        XmlResourceParser rp;
        rp = block.newParser();
        block.close();
        varB4EAC82CA7396A68D541C85D26508E83_461864860 = rp;
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_461864860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_461864860;
        // ---------- Original Method ----------
        //XmlBlock block = openXmlBlockAsset(cookie, fileName);
        //XmlResourceParser rp = block.newParser();
        //block.close();
        //return rp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.189 -0400", hash_original_method = "675415F1EB93293576759C69BAEA6DCB", hash_generated_method = "C5B26E0FD7BC68D21B1ECAC2ECF6A060")
    final XmlBlock openXmlBlockAsset(String fileName) throws IOException {
        XmlBlock varB4EAC82CA7396A68D541C85D26508E83_1367352083 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1367352083 = openXmlBlockAsset(0, fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1367352083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1367352083;
        // ---------- Original Method ----------
        //return openXmlBlockAsset(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.190 -0400", hash_original_method = "9588BC172FA11EB2767F6277EAB2B09E", hash_generated_method = "34D2E5EA577876ACB338033794A307E8")
    final XmlBlock openXmlBlockAsset(int cookie, String fileName) throws IOException {
        XmlBlock varB4EAC82CA7396A68D541C85D26508E83_165635448 = null; //Variable for return #1
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
                varB4EAC82CA7396A68D541C85D26508E83_165635448 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset XML file: " + fileName);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_165635448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_165635448;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.194 -0400", hash_original_method = "30EAECC95AEB342DDD14100667205DCF", hash_generated_method = "E858B5DBB168F2210844BBF8DBAE154B")
     void xmlBlockGone(int id) {
        {
            decRefsLocked(id);
        } //End block
        addTaint(id);
        // ---------- Original Method ----------
        //synchronized (this) {
            //decRefsLocked(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.199 -0400", hash_original_method = "9AD5347899C2D862F4815C023E5977D1", hash_generated_method = "440C7A8C666790766A6D9E4F9D1CF39F")
    final int createTheme() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int res;
            res = newTheme();
            incRefsLocked(res);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694550431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694550431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.215 -0400", hash_original_method = "0E7F795DABC0415CCAB4CA5A0005DBB0", hash_generated_method = "1F24F669295B54523149AEF470C29439")
    final void releaseTheme(int theme) {
        {
            deleteTheme(theme);
            decRefsLocked(theme);
        } //End block
        addTaint(theme);
        // ---------- Original Method ----------
        //synchronized (this) {
            //deleteTheme(theme);
            //decRefsLocked(theme);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.307 -0400", hash_original_method = "C1D87D935BC2D519032BCC6CD9CB5D9B", hash_generated_method = "2A040EC13F7FC1DB2BBE5F677DE017D5")
    protected void finalize() throws Throwable {
        try 
        {
            {
                {
                    {
                        Iterator<RuntimeException> var6A8D9EF0A851170F32FF1EDD9601BB79_1986945669 = (mRefStacks.values()).iterator();
                        var6A8D9EF0A851170F32FF1EDD9601BB79_1986945669.hasNext();
                        RuntimeException e = var6A8D9EF0A851170F32FF1EDD9601BB79_1986945669.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.326 -0400", hash_original_method = "18B8C5816FBF862D1286972549E79177", hash_generated_method = "8BDC397921A7FE3CFF639E98D004ABE6")
    public final int addAssetPath(String path) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364660587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364660587;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.328 -0400", hash_original_method = "22EE91EE70E10361F8012967A8F2990A", hash_generated_method = "E21BB238C1F682E3E7CA4BF69BB04913")
    public final int[] addAssetPaths(String[] paths) {
        int[] cookies;
        cookies = new int[paths.length];
        {
            int i;
            i = 0;
            {
                cookies[i] = addAssetPath(paths[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(paths[0].getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1487109774 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1487109774;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.347 -0400", hash_original_method = "6E60478B72DEC0ABE7A87F31E1844E8F", hash_generated_method = "8A7230E9AC319CBC7BD374773B9D3D9D")
    public final boolean isUpToDate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333250483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333250483;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.348 -0400", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "E69921EE5BD0C2E8AB59F1AA37229149")
    public final void setLocale(String locale) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.349 -0400", hash_original_method = "3CB696CCF0EE1BB70EEADB93E6432982", hash_generated_method = "2A1885B1024F713A5324E14BAEA805ED")
    public final String[] getLocales() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.350 -0400", hash_original_method = "0D7945B64E12882B3ACBA2198421753F", hash_generated_method = "78BC2DBE0FC59033588CFB86A02BD2F9")
    public final void setConfiguration(int mcc, int mnc, String locale,
            int orientation, int touchscreen, int density, int keyboard,
            int keyboardHidden, int navigation, int screenWidth, int screenHeight,
            int smallestScreenWidthDp, int screenWidthDp, int screenHeightDp,
            int screenLayout, int uiMode, int majorVersion) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.350 -0400", hash_original_method = "09A813727514834940DA6C6317E3DBCE", hash_generated_method = "CAFB23CCBDBC156F2879F21C10396C74")
    final int getResourceIdentifier(String type,
                                                       String name,
                                                       String defPackage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814848047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814848047;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.368 -0400", hash_original_method = "A5876C7E6082BC9F857AB889162EC8D3", hash_generated_method = "FBAAE168C828C7BA370F62A92E8BDE92")
    final String getResourceName(int resid) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.369 -0400", hash_original_method = "B7E19874BAD16ADDD401F7BE2B2EFFAD", hash_generated_method = "1B222EBFB81E92383980BFED3C95FEF1")
    final String getResourcePackageName(int resid) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.369 -0400", hash_original_method = "D3A87104246875F54A734A7CED9F3792", hash_generated_method = "FB0BED0BADF159555D7AAA9D63E79093")
    final String getResourceTypeName(int resid) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.370 -0400", hash_original_method = "7C2D2224C9B46B19401BE8615244E9F1", hash_generated_method = "DCC8904351055C288FCFF6D931A8C8F9")
    final String getResourceEntryName(int resid) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.371 -0400", hash_original_method = "CCB6CD4213F7E59AA2D59934C9160368", hash_generated_method = "2EE08CDB743C0589B0C4FDC4FE796A7D")
    private final int openAsset(String fileName, int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558828251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558828251;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.374 -0400", hash_original_method = "9CBF0316C59A074D9238537266A4CF39", hash_generated_method = "1E5C5B867FCBA6692FC4FC36ABE4480B")
    private final ParcelFileDescriptor openAssetFd(String fileName,
            long[] outOffsets) throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.375 -0400", hash_original_method = "81CCCE789A5081BAF563B4B2EE08FF05", hash_generated_method = "CFE7D7A5662AC4FA6FF79D0DBEBFBC62")
    private final int openNonAssetNative(int cookie, String fileName,
            int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669712566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669712566;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.391 -0400", hash_original_method = "05F1691565177C2AFF700A7C71F6F6CD", hash_generated_method = "3A7AF2AA82D95CB2D761B5108753F113")
    private ParcelFileDescriptor openNonAssetFdNative(int cookie,
            String fileName, long[] outOffsets) throws IOException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.401 -0400", hash_original_method = "97A034179950872E547C89DFB8D9E922", hash_generated_method = "7C837E96C8BBDC9D87F899C6B59F14DF")
    private final void destroyAsset(int asset) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.401 -0400", hash_original_method = "5F1E2DF7C91A7E126E188B382F4854C7", hash_generated_method = "93AF846B511CF151642CD51E070DD4AC")
    private final int readAssetChar(int asset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383893955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383893955;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.404 -0400", hash_original_method = "47F4B97BBBCCF733A9E22BF028AA8D70", hash_generated_method = "F3BA24F36E8409D8F389AAC756A1F1AB")
    private final int readAsset(int asset, byte[] b, int off, int len) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952597351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952597351;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.404 -0400", hash_original_method = "B3BCAF9697DD27514E76657171CAECEC", hash_generated_method = "5DAD671ADB0C97BE0019F1CA3B6B3784")
    private final long seekAsset(int asset, long offset, int whence) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_318932052 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_318932052;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.405 -0400", hash_original_method = "A83D0C436C33F4BEE2F972AC578D7A68", hash_generated_method = "67C812AAF5173AB22A51974AA15883BF")
    private final long getAssetLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1913438172 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1913438172;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.405 -0400", hash_original_method = "7F3AC582AA5F20EF55343463044A3085", hash_generated_method = "33AB51209D8093D4513CE77DDA48FD34")
    private final long getAssetRemainingLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1328814132 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1328814132;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.406 -0400", hash_original_method = "27B70155371A7D816D4F089317C25CF6", hash_generated_method = "F533C745CB5EA5E76C02241C0073845E")
    private final int loadResourceValue(int ident, short density, TypedValue outValue,
            boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291157485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291157485;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.407 -0400", hash_original_method = "F08D438D948FB59FEDF35DA42629554E", hash_generated_method = "CD6634F3F5F722F9D5CDA5B69E675939")
    private final int loadResourceBagValue(int ident, int bagEntryId, TypedValue outValue,
                                               boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993065025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993065025;
    }

    
        static final boolean applyStyle(int theme,
            int defStyleAttr, int defStyleRes, int xmlParser,
            int[] inAttrs, int[] outValues, int[] outIndices) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.416 -0400", hash_original_method = "12B5557C9EEBFED6DAC54E4D9FC20DDD", hash_generated_method = "F4505C65B97F680A1E76E194DCD828A2")
    final boolean retrieveAttributes(
            int xmlParser, int[] inAttrs, int[] outValues, int[] outIndices) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147396182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147396182;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.420 -0400", hash_original_method = "34A3EC70D4ACE5655FFEE77E96A0F3BC", hash_generated_method = "746071FFADAA3B8FA8932FF1B6B9CC86")
    final int getArraySize(int resource) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330221658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330221658;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.421 -0400", hash_original_method = "6AA3B6ADCA3DD4B26249D05025D281C3", hash_generated_method = "2C26D69BD4D87A09CFCD0E6355F4F9A5")
    final int retrieveArray(int resource, int[] outValues) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146453322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146453322;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.440 -0400", hash_original_method = "8643075126929A48F7EB079E8C4278DD", hash_generated_method = "25C1C437F14263FE563676C78FA66C63")
    private final int getStringBlockCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958061647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958061647;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.441 -0400", hash_original_method = "FB0E199BF31B4B98A791A0A97B553C67", hash_generated_method = "2C5740C2333830D498E930C0868E5266")
    private final int getNativeStringBlock(int block) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475747243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475747243;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.442 -0400", hash_original_method = "4BCE1B9C1615D4EB059442B0FC3D8208", hash_generated_method = "B12B3AC485F057CA49E8D0EDA1BD9B08")
    public final String getCookieName(int cookie) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
        public static final int getGlobalAssetCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final String getAssetAllocations() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static final int getGlobalAssetManagerCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.448 -0400", hash_original_method = "4A1BDBE10C6D7479DE706205ED3F0C83", hash_generated_method = "C497E96F709E43B3AD0DAC6ECCE7BC52")
    private final int newTheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_190949178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_190949178;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.448 -0400", hash_original_method = "CA31B66AC1745FBADC98731EBEE7AB46", hash_generated_method = "B5983DB9C7B891CB2391E729342FB143")
    private final void deleteTheme(int theme) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.456 -0400", hash_original_method = "F8A041F054DE87147DC380F35C857F31", hash_generated_method = "1A4B0A56385171321BF51294932989CD")
    private final int openXmlAssetNative(int cookie, String fileName) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76690386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76690386;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.457 -0400", hash_original_method = "8CA605217ABF9ACD4B0F75B79941D8AD", hash_generated_method = "5F37EF7284C2ED80B62ED2FD114F081D")
    private final String[] getArrayStringResource(int arrayRes) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.457 -0400", hash_original_method = "341A9383D92FC9E302B0B298621A3766", hash_generated_method = "71B708A0985A4B77392AACF909CF4B03")
    private final int[] getArrayStringInfo(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_434582467 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_434582467;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.457 -0400", hash_original_method = "BCA05693B8244B417FF82C9EDF7FB611", hash_generated_method = "5FA5C4F9964AC816E41DB86635975C3A")
    final int[] getArrayIntResource(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1922873757 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1922873757;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.477 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.477 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.479 -0400", hash_original_method = "8CCD44610E895D23EA7CFE3FA359ACA0", hash_generated_method = "3EF160FD7E92B4DBAAC6937C45CA47B2")
    private final void incRefsLocked(int id) {
        {
            {
                mRefStacks = new HashMap<Integer, RuntimeException>();
                RuntimeException ex;
                ex = new RuntimeException();
                ex.fillInStackTrace();
                mRefStacks.put(this.hashCode(), ex);
            } //End block
        } //End block
        addTaint(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.491 -0400", hash_original_method = "5BE87735DD6C438E2E8B68210C5CE018", hash_generated_method = "0D3FF57A7B8A1B5C9BF18554B4060274")
    private final void decRefsLocked(int id) {
        {
            mRefStacks.remove(id);
        } //End block
        {
            destroy();
        } //End block
        addTaint(id);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.491 -0400", hash_original_field = "8D5507884B6C9BEABDB04A59A4DBA58B", hash_generated_field = "8F8029B3259B8B1BA6498538453FCD52")

        private int mAsset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.491 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

        private long mLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.492 -0400", hash_original_field = "701807B36A85F65CF98EE46A24804A8D", hash_generated_field = "FF38BF9EEDA38C273195A50BE5B2B402")

        private long mMarkPos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.495 -0400", hash_original_method = "73FC7BCEFA9398CB2657C7ECCED60E53", hash_generated_method = "AB67641127F6ADC8DDF0A94D33BF8BC7")
        private  AssetInputStream(int asset) {
            mAsset = asset;
            mLength = getAssetLength(asset);
            // ---------- Original Method ----------
            //mAsset = asset;
            //mLength = getAssetLength(asset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.496 -0400", hash_original_method = "E464EBBB8C3DAC741E7C7914FE6096F4", hash_generated_method = "524AD198860342F07080031F5AA17915")
        public final int getAssetInt() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565198371 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565198371;
            // ---------- Original Method ----------
            //return mAsset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.506 -0400", hash_original_method = "C81989D37BD2D192408FD3EC31DA3DAD", hash_generated_method = "90A5CBDFD5487814A93B42671BEAC257")
        public final int read() throws IOException {
            int varE1E0B1D2F32964F8EA30248A4FEDD33A_1661448657 = (readAssetChar(mAsset));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445866192 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445866192;
            // ---------- Original Method ----------
            //return readAssetChar(mAsset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.507 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "5F78C0687A82C88E7C3604532B7905CF")
        public final boolean markSupported() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554399550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_554399550;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.522 -0400", hash_original_method = "A5BC52EF5476CDC51345AEEDA1CB06B3", hash_generated_method = "807D4D45BA0462071724F89639B799C7")
        public final int available() throws IOException {
            long len;
            len = getAssetRemainingLength(mAsset);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577810267 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577810267;
            // ---------- Original Method ----------
            //long len = getAssetRemainingLength(mAsset);
            //return len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.523 -0400", hash_original_method = "DCE38A6652895F3698A02DE5A8538C09", hash_generated_method = "AB395756D30182E6DD5A86E7F9561E8D")
        public final void close() throws IOException {
            {
                Object var06E55DA388AD25C0173B0EDB061FCE4D_1357074283 = (AssetManager.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.524 -0400", hash_original_method = "7D579BCE4EC4312918D553C49FF13AB2", hash_generated_method = "3431555A8CBA21D30C7ABC8DBE40C7A2")
        public final void mark(int readlimit) {
            mMarkPos = seekAsset(mAsset, 0, 0);
            addTaint(readlimit);
            // ---------- Original Method ----------
            //mMarkPos = seekAsset(mAsset, 0, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.524 -0400", hash_original_method = "659AE57C7CC5071324BF80AF83D49F86", hash_generated_method = "0CAF64AFA3C71A633C3AE770A153F1FF")
        public final void reset() throws IOException {
            seekAsset(mAsset, mMarkPos, -1);
            // ---------- Original Method ----------
            //seekAsset(mAsset, mMarkPos, -1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.545 -0400", hash_original_method = "5E34804727014E6FD2F3F87A050AF853", hash_generated_method = "D988CF962436942BB631F516893D56E5")
        public final int read(byte[] b) throws IOException {
            int var3CAE9971BC75CFC378BD3B49F33BE480_1766660860 = (readAsset(mAsset, b, 0, b.length));
            addTaint(b[0]);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975074386 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975074386;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.546 -0400", hash_original_method = "AA634A995A76E648DEC57A4EAA0F35C1", hash_generated_method = "42F6A69F012797D254EA3D17F148C198")
        public final int read(byte[] b, int off, int len) throws IOException {
            int var1CBB9CD65705D33AD4651F0428BDA301_1968639604 = (readAsset(mAsset, b, off, len));
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896861049 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896861049;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, off, len);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.555 -0400", hash_original_method = "A27B064C1368239357036D853D73FA32", hash_generated_method = "C4D4616166C87278F58148DDBA7B80AD")
        public final long skip(long n) throws IOException {
            long pos;
            pos = seekAsset(mAsset, 0, 0);
            {
                n = mLength-pos;
            } //End block
            {
                seekAsset(mAsset, n, 0);
            } //End block
            addTaint(n);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_878957921 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_878957921;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.556 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.557 -0400", hash_original_field = "70F19D02757ECE0694C4C3146D60FC20", hash_generated_field = "C0398846D11F78001E9A1CEACD42B3FD")

    public static final int ACCESS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.572 -0400", hash_original_field = "8A3909BE7F24687785B8C38BEF1C309B", hash_generated_field = "44C384B355164335E174FF87C9A455A1")

    public static final int ACCESS_RANDOM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.572 -0400", hash_original_field = "61598E8AE300677EC81F29425A4FCD50", hash_generated_field = "941FA2852A6DCA461D7B2054ECA3EFEA")

    public static final int ACCESS_STREAMING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.572 -0400", hash_original_field = "601DD6C8A67C19B8F8985DFCC5D065E3", hash_generated_field = "9117C55B3A01E0F8EFB362B3FB5152BD")

    public static final int ACCESS_BUFFER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.572 -0400", hash_original_field = "D32CE489FB85E2EA1BB422AEDC40B577", hash_generated_field = "6D48B534225102BC2DE76BE9815C0974")

    private static String TAG = "AssetManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "81A92DF01F23C5A9AD1A3D7A55CE01D7", hash_generated_field = "8245CE740538380E2F10E4DC75D66BA1")

    private static boolean localLOGV = false || false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "6C66171C47DCB3FC9A5E7CDD49987FEE", hash_generated_field = "3C774353CBCECAFBFF0F776C734ED264")

    private static boolean DEBUG_REFS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "C134B13DBDEF193093808FEE63AE2EEC")

    private static Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "F21E422E1FCE8D53399A12EF40F632E2", hash_generated_field = "D0731D8853FB150972B9C951A1F661AE")

    static AssetManager sSystem = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "D9B9B3EA290DF73D834C2D4B93657BD0", hash_generated_field = "AC96D6F0F8FF35F1CDFEEC1955928A4C")

    static int STYLE_NUM_ENTRIES = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "C92BDF2E95BBF2CAE0E9A342859D0CC1", hash_generated_field = "DDD70B3EE468E8728C4C56FC4C74526F")

    static int STYLE_TYPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "C3CA2AC53788C65ACA81CA7F70114FC8", hash_generated_field = "E953F8D8CACDA2E3FE8623B3DE016A36")

    static int STYLE_DATA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.573 -0400", hash_original_field = "EFE681D5FC7019383C4D0AD28787ADD8", hash_generated_field = "D85D44A6F5BF1D6EA1AA943BD0B327D9")

    static int STYLE_ASSET_COOKIE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.574 -0400", hash_original_field = "26131FD5FA231BF60E5E380AF4A04E09", hash_generated_field = "4CE3B7C87FF629E81C478D2B09E89B28")

    static int STYLE_RESOURCE_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.574 -0400", hash_original_field = "9FCC225808D06F6DD67618D933EA867D", hash_generated_field = "808B20379B279F2BC5DDAE2A0D90C94E")

    static int STYLE_CHANGING_CONFIGURATIONS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.574 -0400", hash_original_field = "2A826FFA45B8957E369040F1324F0CCD", hash_generated_field = "9C916332E835C9BD09A45A96D2A1610D")

    static int STYLE_DENSITY = 5;
}

