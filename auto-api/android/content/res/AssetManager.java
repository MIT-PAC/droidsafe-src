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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "184B6A2C79F6E655DC652C734EA9E31F")

    private final TypedValue mValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "726DCB6228C12E2D638881A1E45E904A", hash_generated_field = "427FE67122035B768BAE648A2E98CFF3")

    private final long[] mOffsets = new long[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "68D076ED220BAD43118C707808DC8CD0", hash_generated_field = "CC3C82762AC73E1C6FA469CFF14F9939")

    private int mNObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "E4AA04FA1027E6EAB6839BD0E48E31F5", hash_generated_field = "EC37C879DC6C6530C4627CE0DC66498D")

    private StringBlock mStringBlocks[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "2BFF3BD7B921429FFC5CFB18F72B0EC1", hash_generated_field = "32DC8A24B3C6E9B83A49CEC09007226E")

    private int mNumRefs = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.388 -0400", hash_original_field = "A38CAF679723AF33722554F6AF6CB3DB", hash_generated_field = "057DB168549C247D4E5C64EC3B4E7B98")

    private HashMap<Integer, RuntimeException> mRefStacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.389 -0400", hash_original_method = "59A199C9627818EA5BC55C2223B1B671", hash_generated_method = "A69DA3E8689F58726543D9DBEDBA3F73")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.389 -0400", hash_original_method = "517E3FEC19C254F005880DBF363FE7AF", hash_generated_method = "EE48D865FDC2F85257C75A310843F066")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.391 -0400", hash_original_method = "2C3B764DDE8F79C85110BA90D40DB7B8", hash_generated_method = "A6501E83B35ABE6A99FFC47B746745BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.392 -0400", hash_original_method = "CB81F9A1A3C0416B5CF420A3F62514E3", hash_generated_method = "4551868CDDFBB8D0EE4A6BC969ADB0BD")
    final CharSequence getResourceText(int ident) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1967970680 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1055486125 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_791026370 = null; //Variable for return #3
        {
            TypedValue tmpValue = mValue;
            int block = loadResourceValue(ident, (short) 0, tmpValue, true);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1967970680 = mStringBlocks[block].get(tmpValue.data);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1055486125 = tmpValue.coerceToString();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_791026370 = null;
        addTaint(ident);
        CharSequence varA7E53CE21691AB073D9660D615818899_369474662; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_369474662 = varB4EAC82CA7396A68D541C85D26508E83_1967970680;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_369474662 = varB4EAC82CA7396A68D541C85D26508E83_1055486125;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_369474662 = varB4EAC82CA7396A68D541C85D26508E83_791026370;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_369474662.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_369474662;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.394 -0400", hash_original_method = "2C5FA72B5D3C88AECCC2C4639A2FC63C", hash_generated_method = "005878BA9B785AF7CB3652D0B3B880F3")
    final CharSequence getResourceBagText(int ident, int bagEntryId) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_104820888 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_615153485 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_436127915 = null; //Variable for return #3
        {
            TypedValue tmpValue = mValue;
            int block = loadResourceBagValue(ident, bagEntryId, tmpValue, true);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_104820888 = mStringBlocks[block].get(tmpValue.data);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_615153485 = tmpValue.coerceToString();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_436127915 = null;
        addTaint(ident);
        addTaint(bagEntryId);
        CharSequence varA7E53CE21691AB073D9660D615818899_1410160018; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1410160018 = varB4EAC82CA7396A68D541C85D26508E83_104820888;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1410160018 = varB4EAC82CA7396A68D541C85D26508E83_615153485;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1410160018 = varB4EAC82CA7396A68D541C85D26508E83_436127915;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1410160018.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1410160018;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.395 -0400", hash_original_method = "15AFE30CDC312B3891A5A8072BD8524F", hash_generated_method = "9AE02B6BD52A8F6BCCCD92B8C6CBD114")
    final String[] getResourceStringArray(final int id) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1042256637 = null; //Variable for return #1
        String[] retArray = getArrayStringResource(id);
        varB4EAC82CA7396A68D541C85D26508E83_1042256637 = retArray;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1042256637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1042256637;
        // ---------- Original Method ----------
        //String[] retArray = getArrayStringResource(id);
        //return retArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.396 -0400", hash_original_method = "880DADF9021E8E0236DAC9AB890DE1A9", hash_generated_method = "92439B741107EEE62D550E7FE14EB897")
    final boolean getResourceValue(int ident,
                                               int density,
                                               TypedValue outValue,
                                               boolean resolveRefs) {
        int block = loadResourceValue(ident, (short) density, outValue, resolveRefs);
        {
            outValue.string = mStringBlocks[block].get(outValue.data);
        } //End block
        addTaint(ident);
        addTaint(density);
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_589346282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_589346282;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.397 -0400", hash_original_method = "5C4180581403390570CBF3420B87F392", hash_generated_method = "105C50905ADC7AA65B1403BC727C01C4")
    final CharSequence[] getResourceTextArray(final int id) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_1216972681 = null; //Variable for return #1
        int[] rawInfoArray = getArrayStringInfo(id);
        int rawInfoArrayLen = rawInfoArray.length;
        final int infoArrayLen = rawInfoArrayLen / 2;
        int block;
        int index;
        CharSequence[] retArray = new CharSequence[infoArrayLen];
        {
            int i = 0;
            int j = 0;
            i = i + 2;
            {
                block = rawInfoArray[i];
                index = rawInfoArray[i + 1];
                retArray[j] = index >= 0 ? mStringBlocks[block].get(index) : null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1216972681 = retArray;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1216972681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1216972681;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.397 -0400", hash_original_method = "257E397E5CF934BBA53C0ACDE849DFE1", hash_generated_method = "40F289607E50FAD587D5AB5C44EF2CB3")
    final boolean getThemeValue(int theme, int ident,
            TypedValue outValue, boolean resolveRefs) {
        int block = loadThemeAttributeValue(theme, ident, outValue, resolveRefs);
        {
            StringBlock[] blocks = mStringBlocks;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_800562152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_800562152;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.398 -0400", hash_original_method = "BC550AAFCB31C90ECB8DB7C3E260076C", hash_generated_method = "6435128ECE7F4777C0BFB994BF67EDBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.399 -0400", hash_original_method = "EDCC94234F08B09DDE56D32F4E25BC85", hash_generated_method = "75718054D35E3FBB8C6890BF252E54F1")
    final void makeStringBlocks(boolean copyFromSystem) {
        int sysNum;
        sysNum = sSystem.mStringBlocks.length;
        sysNum = 0;
        final int num = getStringBlockCount();
        mStringBlocks = new StringBlock[num];
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.399 -0400", hash_original_method = "148EA8945A31568904B22E1C4951294F", hash_generated_method = "832AB40E0CB14E0FF9864E4E748CDC65")
    final CharSequence getPooledString(int block, int id) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1507898348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1507898348 = mStringBlocks[block-1].get(id);
        addTaint(block);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1507898348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1507898348;
        // ---------- Original Method ----------
        //return mStringBlocks[block-1].get(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.400 -0400", hash_original_method = "7E1B14522C484E4F1B470AEA16F877D6", hash_generated_method = "52489E979F3C930EBC608CFCF5C3C3C2")
    public final InputStream open(String fileName) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1393111849 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1393111849 = open(fileName, ACCESS_STREAMING);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1393111849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393111849;
        // ---------- Original Method ----------
        //return open(fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.402 -0400", hash_original_method = "EB9FEA0B2CEADB65FF0921C2B52A13F4", hash_generated_method = "014455135984042A5DF8C1B5014767E2")
    public final InputStream open(String fileName, int accessMode) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1671940773 = null; //Variable for return #1
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int asset = openAsset(fileName, accessMode);
            {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
                varB4EAC82CA7396A68D541C85D26508E83_1671940773 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset file: " + fileName);
        addTaint(fileName.getTaint());
        addTaint(accessMode);
        varB4EAC82CA7396A68D541C85D26508E83_1671940773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1671940773;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.405 -0400", hash_original_method = "66D3D468B1706A8E526F268E61D6D3C7", hash_generated_method = "BFF344F9C15CACAAA64A5AE441DCDAA0")
    public final AssetFileDescriptor openFd(String fileName) throws IOException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1979646457 = null; //Variable for return #1
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            ParcelFileDescriptor pfd = openAssetFd(fileName, mOffsets);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1979646457 = new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset file: " + fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1979646457.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1979646457;
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
    @DSModeled(DSC.SPEC)
    public final String[] list(String path) throws IOException {
    	String[] ret = {path};
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.407 -0400", hash_original_method = "B416CA2D934FFC444AFFEA95F80C0673", hash_generated_method = "EF8D8B419938C219E0EE98A124C9517B")
    public final InputStream openNonAsset(String fileName) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_978495432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_978495432 = openNonAsset(0, fileName, ACCESS_STREAMING);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_978495432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978495432;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.408 -0400", hash_original_method = "6F98937B657C3DF287FD2A6608D5C403", hash_generated_method = "0B2876353FDBAA44B0FBE909259F3F34")
    public final InputStream openNonAsset(String fileName, int accessMode) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1372102632 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1372102632 = openNonAsset(0, fileName, accessMode);
        addTaint(fileName.getTaint());
        addTaint(accessMode);
        varB4EAC82CA7396A68D541C85D26508E83_1372102632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1372102632;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, accessMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.409 -0400", hash_original_method = "DECD09E6B1808DA43562160A03482F49", hash_generated_method = "050CCB267DCFBDA449C5ED7FA9258DEF")
    public final InputStream openNonAsset(int cookie, String fileName) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1321455835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1321455835 = openNonAsset(cookie, fileName, ACCESS_STREAMING);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1321455835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1321455835;
        // ---------- Original Method ----------
        //return openNonAsset(cookie, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.410 -0400", hash_original_method = "5BC280B3003CA7B8CFB3A2FB67C4E385", hash_generated_method = "5A1423C896EF8BF01D7ACB50724E10C1")
    public final InputStream openNonAsset(int cookie, String fileName, int accessMode) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_100615535 = null; //Variable for return #1
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int asset = openNonAssetNative(cookie, fileName, accessMode);
            {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
                varB4EAC82CA7396A68D541C85D26508E83_100615535 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset absolute file: " + fileName);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        addTaint(accessMode);
        varB4EAC82CA7396A68D541C85D26508E83_100615535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_100615535;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.411 -0400", hash_original_method = "E6C638BB28F04E787E5711BF8F421102", hash_generated_method = "88A9F494187D518F6E8A8B47ADA8894B")
    public final AssetFileDescriptor openNonAssetFd(String fileName) throws IOException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1866855624 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1866855624 = openNonAssetFd(0, fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1866855624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1866855624;
        // ---------- Original Method ----------
        //return openNonAssetFd(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.414 -0400", hash_original_method = "A0DC944B46306DDC2CA1031D9C43AC47", hash_generated_method = "5633DD16082CAC7FCE8C33141A73BB8F")
    public final AssetFileDescriptor openNonAssetFd(int cookie,
            String fileName) throws IOException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1287112297 = null; //Variable for return #1
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            ParcelFileDescriptor pfd = openNonAssetFdNative(cookie,
                    fileName, mOffsets);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1287112297 = new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset absolute file: " + fileName);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1287112297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1287112297;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.416 -0400", hash_original_method = "602B0A8D272774ACD0101F14F2575F17", hash_generated_method = "0D4303F455F6F6C6294A2A6947984C87")
    public final XmlResourceParser openXmlResourceParser(String fileName) throws IOException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1799777358 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1799777358 = openXmlResourceParser(0, fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1799777358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1799777358;
        // ---------- Original Method ----------
        //return openXmlResourceParser(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.417 -0400", hash_original_method = "06F5CBF51BDA69D9C47BB01131F079C4", hash_generated_method = "A3DB1981A906671D4C1EB3852F6F1466")
    public final XmlResourceParser openXmlResourceParser(int cookie,
            String fileName) throws IOException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1642797786 = null; //Variable for return #1
        XmlBlock block = openXmlBlockAsset(cookie, fileName);
        XmlResourceParser rp = block.newParser();
        block.close();
        varB4EAC82CA7396A68D541C85D26508E83_1642797786 = rp;
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1642797786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1642797786;
        // ---------- Original Method ----------
        //XmlBlock block = openXmlBlockAsset(cookie, fileName);
        //XmlResourceParser rp = block.newParser();
        //block.close();
        //return rp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.419 -0400", hash_original_method = "675415F1EB93293576759C69BAEA6DCB", hash_generated_method = "ED8BD201EF62CD49867F875B16893000")
    final XmlBlock openXmlBlockAsset(String fileName) throws IOException {
        XmlBlock varB4EAC82CA7396A68D541C85D26508E83_508992678 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_508992678 = openXmlBlockAsset(0, fileName);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_508992678.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_508992678;
        // ---------- Original Method ----------
        //return openXmlBlockAsset(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.420 -0400", hash_original_method = "9588BC172FA11EB2767F6277EAB2B09E", hash_generated_method = "5AB6C091A79CC0CE4EC75EBD22CC925D")
    final XmlBlock openXmlBlockAsset(int cookie, String fileName) throws IOException {
        XmlBlock varB4EAC82CA7396A68D541C85D26508E83_949400178 = null; //Variable for return #1
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int xmlBlock = openXmlAssetNative(cookie, fileName);
            {
                XmlBlock res = new XmlBlock(this, xmlBlock);
                incRefsLocked(res.hashCode());
                varB4EAC82CA7396A68D541C85D26508E83_949400178 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException("Asset XML file: " + fileName);
        addTaint(cookie);
        addTaint(fileName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_949400178.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_949400178;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.421 -0400", hash_original_method = "30EAECC95AEB342DDD14100667205DCF", hash_generated_method = "E858B5DBB168F2210844BBF8DBAE154B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.422 -0400", hash_original_method = "9AD5347899C2D862F4815C023E5977D1", hash_generated_method = "2507584905072A348729AFCBFE029839")
    final int createTheme() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Assetmanager has been closed");
            } //End block
            int res = newTheme();
            incRefsLocked(res);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123990618 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123990618;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.423 -0400", hash_original_method = "0E7F795DABC0415CCAB4CA5A0005DBB0", hash_generated_method = "1F24F669295B54523149AEF470C29439")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.431 -0400", hash_original_method = "C1D87D935BC2D519032BCC6CD9CB5D9B", hash_generated_method = "354542E6F9F60830EFE5565A4C3EF18A")
    protected void finalize() throws Throwable {
        try 
        {
            {
                {
                    {
                        Iterator<RuntimeException> var6A8D9EF0A851170F32FF1EDD9601BB79_781528082 = (mRefStacks.values()).iterator();
                        var6A8D9EF0A851170F32FF1EDD9601BB79_781528082.hasNext();
                        RuntimeException e = var6A8D9EF0A851170F32FF1EDD9601BB79_781528082.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.432 -0400", hash_original_method = "18B8C5816FBF862D1286972549E79177", hash_generated_method = "98B1369B91633AE6C3E4B064D4F1B696")
    public final int addAssetPath(String path) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725036647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725036647;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.433 -0400", hash_original_method = "22EE91EE70E10361F8012967A8F2990A", hash_generated_method = "8A439EAB6A0625E6D4D052BBFE8BC2A0")
    public final int[] addAssetPaths(String[] paths) {
        int[] cookies = new int[paths.length];
        {
            int i = 0;
            {
                cookies[i] = addAssetPath(paths[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(paths[0].getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1077900862 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1077900862;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.435 -0400", hash_original_method = "6E60478B72DEC0ABE7A87F31E1844E8F", hash_generated_method = "3AE913C86D8728BEBD8A3616FA4441D9")
    public final boolean isUpToDate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523503946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523503946;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.436 -0400", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "E69921EE5BD0C2E8AB59F1AA37229149")
    public final void setLocale(String locale) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.349 -0400", hash_original_method = "3CB696CCF0EE1BB70EEADB93E6432982", hash_generated_method = "2A1885B1024F713A5324E14BAEA805ED")
    public final String[] getLocales() {
    	String[] mockArray = {""};
    	return mockArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.437 -0400", hash_original_method = "0D7945B64E12882B3ACBA2198421753F", hash_generated_method = "78BC2DBE0FC59033588CFB86A02BD2F9")
    public final void setConfiguration(int mcc, int mnc, String locale,
            int orientation, int touchscreen, int density, int keyboard,
            int keyboardHidden, int navigation, int screenWidth, int screenHeight,
            int smallestScreenWidthDp, int screenWidthDp, int screenHeightDp,
            int screenLayout, int uiMode, int majorVersion) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.438 -0400", hash_original_method = "09A813727514834940DA6C6317E3DBCE", hash_generated_method = "7FC04459002CDB7B19CF9B77A18A4239")
    final int getResourceIdentifier(String type,
                                                       String name,
                                                       String defPackage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745322181 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745322181;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.368 -0400", hash_original_method = "A5876C7E6082BC9F857AB889162EC8D3", hash_generated_method = "FBAAE168C828C7BA370F62A92E8BDE92")
    @DSModeled(DSC.BAN)
    final String getResourceName(int resid) {
    	return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.369 -0400", hash_original_method = "B7E19874BAD16ADDD401F7BE2B2EFFAD", hash_generated_method = "1B222EBFB81E92383980BFED3C95FEF1")
    @DSModeled(DSC.BAN)
    final String getResourcePackageName(int resid) {
    	return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.369 -0400", hash_original_method = "D3A87104246875F54A734A7CED9F3792", hash_generated_method = "FB0BED0BADF159555D7AAA9D63E79093")
    @DSModeled(DSC.BAN)
    final String getResourceTypeName(int resid) {
    	return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.370 -0400", hash_original_method = "7C2D2224C9B46B19401BE8615244E9F1", hash_generated_method = "DCC8904351055C288FCFF6D931A8C8F9")
    @DSModeled(DSC.BAN)
    final String getResourceEntryName(int resid) {
    	return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.439 -0400", hash_original_method = "CCB6CD4213F7E59AA2D59934C9160368", hash_generated_method = "82B905CD5C9B7BF03B9BD4A0A8023C9C")
    private final int openAsset(String fileName, int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735702849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735702849;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.374 -0400", hash_original_method = "9CBF0316C59A074D9238537266A4CF39", hash_generated_method = "1E5C5B867FCBA6692FC4FC36ABE4480B")
    @DSModeled(DSC.BAN)
    private final ParcelFileDescriptor openAssetFd(String fileName,
            long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.440 -0400", hash_original_method = "81CCCE789A5081BAF563B4B2EE08FF05", hash_generated_method = "7D3837FA28854D125751026A625954D3")
    private final int openNonAssetNative(int cookie, String fileName,
            int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883819429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883819429;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.391 -0400", hash_original_method = "05F1691565177C2AFF700A7C71F6F6CD", hash_generated_method = "3A7AF2AA82D95CB2D761B5108753F113")
    private ParcelFileDescriptor openNonAssetFdNative(int cookie,
            String fileName, long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.441 -0400", hash_original_method = "97A034179950872E547C89DFB8D9E922", hash_generated_method = "7C837E96C8BBDC9D87F899C6B59F14DF")
    private final void destroyAsset(int asset) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.442 -0400", hash_original_method = "5F1E2DF7C91A7E126E188B382F4854C7", hash_generated_method = "CF13DFC5688B23705AFB08C5E8B86494")
    private final int readAssetChar(int asset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282457521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282457521;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.443 -0400", hash_original_method = "47F4B97BBBCCF733A9E22BF028AA8D70", hash_generated_method = "33AF4A808106EDDF00295715E27873C9")
    private final int readAsset(int asset, byte[] b, int off, int len) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069008241 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069008241;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.444 -0400", hash_original_method = "B3BCAF9697DD27514E76657171CAECEC", hash_generated_method = "02B6F7F056E2DC24E97E6B2D4BF0FFB6")
    private final long seekAsset(int asset, long offset, int whence) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1389478491 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1389478491;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.445 -0400", hash_original_method = "A83D0C436C33F4BEE2F972AC578D7A68", hash_generated_method = "0FD9A61885BD829EA3B98C39966E16EA")
    private final long getAssetLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1309238904 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1309238904;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.446 -0400", hash_original_method = "7F3AC582AA5F20EF55343463044A3085", hash_generated_method = "7196A8BD141D0ED9F0CCD571CFA43E99")
    private final long getAssetRemainingLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_329889475 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_329889475;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.446 -0400", hash_original_method = "27B70155371A7D816D4F089317C25CF6", hash_generated_method = "07E8ABEB1861C9E41958C2783C402B6B")
    private final int loadResourceValue(int ident, short density, TypedValue outValue,
            boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769004120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769004120;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.447 -0400", hash_original_method = "F08D438D948FB59FEDF35DA42629554E", hash_generated_method = "50FEE45D456783430B2C36F305C1F113")
    private final int loadResourceBagValue(int ident, int bagEntryId, TypedValue outValue,
                                               boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855236222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855236222;
    }

    
    static final boolean applyStyle(int theme,
            int defStyleAttr, int defStyleRes, int xmlParser,
            int[] inAttrs, int[] outValues, int[] outIndices) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.447 -0400", hash_original_method = "12B5557C9EEBFED6DAC54E4D9FC20DDD", hash_generated_method = "692999F715C2B39369183EB23E1AE16B")
    final boolean retrieveAttributes(
            int xmlParser, int[] inAttrs, int[] outValues, int[] outIndices) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23712006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_23712006;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.448 -0400", hash_original_method = "34A3EC70D4ACE5655FFEE77E96A0F3BC", hash_generated_method = "C6880A118A0F498CFC383E32C9DE6ECC")
    final int getArraySize(int resource) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621909743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621909743;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.449 -0400", hash_original_method = "6AA3B6ADCA3DD4B26249D05025D281C3", hash_generated_method = "92948C7C8AB6E2382B18C936A71CC8D6")
    final int retrieveArray(int resource, int[] outValues) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198141079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198141079;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.449 -0400", hash_original_method = "8643075126929A48F7EB079E8C4278DD", hash_generated_method = "41A7AFF7BE5F0731AC6177434CC57549")
    private final int getStringBlockCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401249605 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401249605;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.450 -0400", hash_original_method = "FB0E199BF31B4B98A791A0A97B553C67", hash_generated_method = "6B1813F5E1F324B941F2B5514BDCF21F")
    private final int getNativeStringBlock(int block) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017460228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017460228;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.442 -0400", hash_original_method = "4BCE1B9C1615D4EB059442B0FC3D8208", hash_generated_method = "B12B3AC485F057CA49E8D0EDA1BD9B08")
    @DSModeled(DSC.BAN)
    public final String getCookieName(int cookie) {
    	return "";
    }

    
    public static final int getGlobalAssetCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static final String getAssetAllocations() {
        	return "";
    }

    
    public static final int getGlobalAssetManagerCount() {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.451 -0400", hash_original_method = "4A1BDBE10C6D7479DE706205ED3F0C83", hash_generated_method = "55EBBA71470CFC7C3F748E86E1B620F0")
    private final int newTheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272599052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272599052;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.452 -0400", hash_original_method = "CA31B66AC1745FBADC98731EBEE7AB46", hash_generated_method = "B5983DB9C7B891CB2391E729342FB143")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.455 -0400", hash_original_method = "F8A041F054DE87147DC380F35C857F31", hash_generated_method = "385CB14DABAD9B8269E8C84B8CDAB565")
    private final int openXmlAssetNative(int cookie, String fileName) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291140216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291140216;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.457 -0400", hash_original_method = "8CA605217ABF9ACD4B0F75B79941D8AD", hash_generated_method = "5F37EF7284C2ED80B62ED2FD114F081D")
    private final String[] getArrayStringResource(int arrayRes) {
    	String[] ret = {""};
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.457 -0400", hash_original_method = "341A9383D92FC9E302B0B298621A3766", hash_generated_method = "EEE1C4C680685C0EA5161DD124A7849D")
    private final int[] getArrayStringInfo(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1928389877 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1928389877;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.457 -0400", hash_original_method = "BCA05693B8244B417FF82C9EDF7FB611", hash_generated_method = "96E74B1028AF03DBC2FBEBBE2C194F82")
    final int[] getArrayIntResource(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1882569707 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1882569707;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.458 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.458 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.459 -0400", hash_original_method = "8CCD44610E895D23EA7CFE3FA359ACA0", hash_generated_method = "A33FCFE180F236B6B23F639CDBEF049E")
    private final void incRefsLocked(int id) {
        {
            {
                mRefStacks = new HashMap<Integer, RuntimeException>();
                RuntimeException ex = new RuntimeException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.460 -0400", hash_original_method = "5BE87735DD6C438E2E8B68210C5CE018", hash_generated_method = "0D3FF57A7B8A1B5C9BF18554B4060274")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.460 -0400", hash_original_field = "8D5507884B6C9BEABDB04A59A4DBA58B", hash_generated_field = "8F8029B3259B8B1BA6498538453FCD52")

        private int mAsset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.460 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

        private long mLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.460 -0400", hash_original_field = "701807B36A85F65CF98EE46A24804A8D", hash_generated_field = "FF38BF9EEDA38C273195A50BE5B2B402")

        private long mMarkPos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.461 -0400", hash_original_method = "73FC7BCEFA9398CB2657C7ECCED60E53", hash_generated_method = "AB67641127F6ADC8DDF0A94D33BF8BC7")
        private  AssetInputStream(int asset) {
            mAsset = asset;
            mLength = getAssetLength(asset);
            // ---------- Original Method ----------
            //mAsset = asset;
            //mLength = getAssetLength(asset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.461 -0400", hash_original_method = "E464EBBB8C3DAC741E7C7914FE6096F4", hash_generated_method = "FC4B3B0D493C8116250C8208CE586636")
        public final int getAssetInt() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901200399 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901200399;
            // ---------- Original Method ----------
            //return mAsset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.462 -0400", hash_original_method = "C81989D37BD2D192408FD3EC31DA3DAD", hash_generated_method = "DCCF69D0B9363E77D869B5FFE004ED50")
        public final int read() throws IOException {
            int varE1E0B1D2F32964F8EA30248A4FEDD33A_1895275773 = (readAssetChar(mAsset));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733716455 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733716455;
            // ---------- Original Method ----------
            //return readAssetChar(mAsset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.463 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "15E892350113A459F890AED1995F3E45")
        public final boolean markSupported() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160098277 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_160098277;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.464 -0400", hash_original_method = "A5BC52EF5476CDC51345AEEDA1CB06B3", hash_generated_method = "788FA2A6B6361F310431D669A46E0569")
        public final int available() throws IOException {
            long len = getAssetRemainingLength(mAsset);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828251346 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828251346;
            // ---------- Original Method ----------
            //long len = getAssetRemainingLength(mAsset);
            //return len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.465 -0400", hash_original_method = "DCE38A6652895F3698A02DE5A8538C09", hash_generated_method = "A52B24BA683B97080B390D49AAC22D24")
        public final void close() throws IOException {
            {
                Object var06E55DA388AD25C0173B0EDB061FCE4D_215033050 = (AssetManager.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.466 -0400", hash_original_method = "7D579BCE4EC4312918D553C49FF13AB2", hash_generated_method = "3431555A8CBA21D30C7ABC8DBE40C7A2")
        public final void mark(int readlimit) {
            mMarkPos = seekAsset(mAsset, 0, 0);
            addTaint(readlimit);
            // ---------- Original Method ----------
            //mMarkPos = seekAsset(mAsset, 0, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.467 -0400", hash_original_method = "659AE57C7CC5071324BF80AF83D49F86", hash_generated_method = "0CAF64AFA3C71A633C3AE770A153F1FF")
        public final void reset() throws IOException {
            seekAsset(mAsset, mMarkPos, -1);
            // ---------- Original Method ----------
            //seekAsset(mAsset, mMarkPos, -1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.467 -0400", hash_original_method = "5E34804727014E6FD2F3F87A050AF853", hash_generated_method = "5DEFB7164C573461D2A40026FFB50EC9")
        public final int read(byte[] b) throws IOException {
            int var3CAE9971BC75CFC378BD3B49F33BE480_439363627 = (readAsset(mAsset, b, 0, b.length));
            addTaint(b[0]);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538660928 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538660928;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.468 -0400", hash_original_method = "AA634A995A76E648DEC57A4EAA0F35C1", hash_generated_method = "33A237FAB1BA6CB86652B3E31AAD330A")
        public final int read(byte[] b, int off, int len) throws IOException {
            int var1CBB9CD65705D33AD4651F0428BDA301_2104801633 = (readAsset(mAsset, b, off, len));
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353392710 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353392710;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, off, len);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.469 -0400", hash_original_method = "A27B064C1368239357036D853D73FA32", hash_generated_method = "F2BFE59ECF3D50BD89D359654928C72B")
        public final long skip(long n) throws IOException {
            long pos = seekAsset(mAsset, 0, 0);
            {
                n = mLength-pos;
            } //End block
            {
                seekAsset(mAsset, n, 0);
            } //End block
            addTaint(n);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_761063447 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_761063447;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.469 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.469 -0400", hash_original_field = "70F19D02757ECE0694C4C3146D60FC20", hash_generated_field = "C0398846D11F78001E9A1CEACD42B3FD")

    public static final int ACCESS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.469 -0400", hash_original_field = "8A3909BE7F24687785B8C38BEF1C309B", hash_generated_field = "44C384B355164335E174FF87C9A455A1")

    public static final int ACCESS_RANDOM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.469 -0400", hash_original_field = "61598E8AE300677EC81F29425A4FCD50", hash_generated_field = "941FA2852A6DCA461D7B2054ECA3EFEA")

    public static final int ACCESS_STREAMING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "601DD6C8A67C19B8F8985DFCC5D065E3", hash_generated_field = "9117C55B3A01E0F8EFB362B3FB5152BD")

    public static final int ACCESS_BUFFER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "D32CE489FB85E2EA1BB422AEDC40B577", hash_generated_field = "FDC75AE01ED37E059BA4F54E9509C8D2")

    private static final String TAG = "AssetManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "81A92DF01F23C5A9AD1A3D7A55CE01D7", hash_generated_field = "776D75E65C0F716B6889BA4A8C683647")

    private static final boolean localLOGV = false || false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "6C66171C47DCB3FC9A5E7CDD49987FEE", hash_generated_field = "C4EDA31E106597348022664C2B4AE055")

    private static final boolean DEBUG_REFS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    private static final Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "F21E422E1FCE8D53399A12EF40F632E2", hash_generated_field = "D0731D8853FB150972B9C951A1F661AE")

    static AssetManager sSystem = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "D9B9B3EA290DF73D834C2D4B93657BD0", hash_generated_field = "9A482EFAAC5EAFE41C22AFB2C4AFCFEB")

    static final int STYLE_NUM_ENTRIES = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "C92BDF2E95BBF2CAE0E9A342859D0CC1", hash_generated_field = "329269D64B272BF04010F03C4C06F535")

    static final int STYLE_TYPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "C3CA2AC53788C65ACA81CA7F70114FC8", hash_generated_field = "FC17F8F67F5BAEB1FD0402C771D270B0")

    static final int STYLE_DATA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "EFE681D5FC7019383C4D0AD28787ADD8", hash_generated_field = "05C07F6EAB5B9D635D03781B6890450C")

    static final int STYLE_ASSET_COOKIE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.470 -0400", hash_original_field = "26131FD5FA231BF60E5E380AF4A04E09", hash_generated_field = "0505900C52E965C0B90E9A9386CD8DAB")

    static final int STYLE_RESOURCE_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.471 -0400", hash_original_field = "9FCC225808D06F6DD67618D933EA867D", hash_generated_field = "7EF09BBF875A3B7CE09ACBE50176137C")

    static final int STYLE_CHANGING_CONFIGURATIONS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.471 -0400", hash_original_field = "2A826FFA45B8957E369040F1324F0CCD", hash_generated_field = "9B74378301FF8622581D308549021E80")

    static final int STYLE_DENSITY = 5;
}

