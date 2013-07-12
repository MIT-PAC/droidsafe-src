package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.TypedValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class AssetManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.630 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "184B6A2C79F6E655DC652C734EA9E31F")

    private final TypedValue mValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.630 -0400", hash_original_field = "726DCB6228C12E2D638881A1E45E904A", hash_generated_field = "427FE67122035B768BAE648A2E98CFF3")

    private final long[] mOffsets = new long[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.630 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.630 -0400", hash_original_field = "68D076ED220BAD43118C707808DC8CD0", hash_generated_field = "CC3C82762AC73E1C6FA469CFF14F9939")

    private int mNObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.630 -0400", hash_original_field = "E4AA04FA1027E6EAB6839BD0E48E31F5", hash_generated_field = "EC37C879DC6C6530C4627CE0DC66498D")

    private StringBlock mStringBlocks[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.631 -0400", hash_original_field = "2BFF3BD7B921429FFC5CFB18F72B0EC1", hash_generated_field = "32DC8A24B3C6E9B83A49CEC09007226E")

    private int mNumRefs = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.631 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.631 -0400", hash_original_field = "A38CAF679723AF33722554F6AF6CB3DB", hash_generated_field = "057DB168549C247D4E5C64EC3B4E7B98")

    private HashMap<Integer, RuntimeException> mRefStacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.631 -0400", hash_original_method = "59A199C9627818EA5BC55C2223B1B671", hash_generated_method = "F6A2FF377C5B97CB030AC199B929F026")
    public  AssetManager() {
        synchronized
(this)        {
    if(DEBUG_REFS)            
            {
                mNumRefs = 0;
                incRefsLocked(this.hashCode());
            } //End block
            init();
    if(localLOGV){ }            ensureSystemAssets();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.641 -0400", hash_original_method = "517E3FEC19C254F005880DBF363FE7AF", hash_generated_method = "D5A8F5A0591D64A570A79AD2A6A1E787")
    private  AssetManager(boolean isSystem) {
        addTaint(isSystem);
    if(DEBUG_REFS)        
        {
            synchronized
(this)            {
                mNumRefs = 0;
                incRefsLocked(this.hashCode());
            } //End block
        } //End block
        init();
    if(localLOGV){ }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.641 -0400", hash_original_method = "2C3B764DDE8F79C85110BA90D40DB7B8", hash_generated_method = "CEA6B3A0235F81D5425A90ED368996FC")
    public void close() {
        synchronized
(this)        {
    if(mOpen)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.642 -0400", hash_original_method = "CB81F9A1A3C0416B5CF420A3F62514E3", hash_generated_method = "645B4CFC57A8574A67587BF1F6860C17")
    final CharSequence getResourceText(int ident) {
        addTaint(ident);
        synchronized
(this)        {
            TypedValue tmpValue = mValue;
            int block = loadResourceValue(ident, (short) 0, tmpValue, true);
    if(block >= 0)            
            {
    if(tmpValue.type == TypedValue.TYPE_STRING)                
                {
CharSequence var09B760A53753A9A5EC67FF338BD5B918_1080119898 =                     mStringBlocks[block].get(tmpValue.data);
                    var09B760A53753A9A5EC67FF338BD5B918_1080119898.addTaint(taint);
                    return var09B760A53753A9A5EC67FF338BD5B918_1080119898;
                } //End block
CharSequence var143A8D8DAA05C02C1D1E29D098E2AB03_1210019493 =                 tmpValue.coerceToString();
                var143A8D8DAA05C02C1D1E29D098E2AB03_1210019493.addTaint(taint);
                return var143A8D8DAA05C02C1D1E29D098E2AB03_1210019493;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1916511784 =         null;
        var540C13E9E156B687226421B24F2DF178_1916511784.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1916511784;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.642 -0400", hash_original_method = "2C5FA72B5D3C88AECCC2C4639A2FC63C", hash_generated_method = "D50E4228633886356341DA2454E706E8")
    final CharSequence getResourceBagText(int ident, int bagEntryId) {
        addTaint(bagEntryId);
        addTaint(ident);
        synchronized
(this)        {
            TypedValue tmpValue = mValue;
            int block = loadResourceBagValue(ident, bagEntryId, tmpValue, true);
    if(block >= 0)            
            {
    if(tmpValue.type == TypedValue.TYPE_STRING)                
                {
CharSequence var09B760A53753A9A5EC67FF338BD5B918_1162766057 =                     mStringBlocks[block].get(tmpValue.data);
                    var09B760A53753A9A5EC67FF338BD5B918_1162766057.addTaint(taint);
                    return var09B760A53753A9A5EC67FF338BD5B918_1162766057;
                } //End block
CharSequence var143A8D8DAA05C02C1D1E29D098E2AB03_1331632864 =                 tmpValue.coerceToString();
                var143A8D8DAA05C02C1D1E29D098E2AB03_1331632864.addTaint(taint);
                return var143A8D8DAA05C02C1D1E29D098E2AB03_1331632864;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1813868486 =         null;
        var540C13E9E156B687226421B24F2DF178_1813868486.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1813868486;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.642 -0400", hash_original_method = "15AFE30CDC312B3891A5A8072BD8524F", hash_generated_method = "2976CBF4B1A3280297ADDAA585F2984E")
    final String[] getResourceStringArray(final int id) {
        addTaint(id);
        String[] retArray = getArrayStringResource(id);
String[] var99D8976FAB8D6731FEC3A476C186DDE3_1072370686 =         retArray;
        var99D8976FAB8D6731FEC3A476C186DDE3_1072370686.addTaint(taint);
        return var99D8976FAB8D6731FEC3A476C186DDE3_1072370686;
        // ---------- Original Method ----------
        //String[] retArray = getArrayStringResource(id);
        //return retArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.643 -0400", hash_original_method = "880DADF9021E8E0236DAC9AB890DE1A9", hash_generated_method = "197D1C5CA072514A9DF089E0B56343F3")
    final boolean getResourceValue(int ident,
                                               int density,
                                               TypedValue outValue,
                                               boolean resolveRefs) {
        addTaint(resolveRefs);
        addTaint(outValue.getTaint());
        addTaint(density);
        addTaint(ident);
        int block = loadResourceValue(ident, (short) density, outValue, resolveRefs);
    if(block >= 0)        
        {
    if(outValue.type != TypedValue.TYPE_STRING)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1273706021 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282108641 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282108641;
            } //End block
            outValue.string = mStringBlocks[block].get(outValue.data);
            boolean varB326B5062B2F0E69046810717534CB09_1756939041 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233527367 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233527367;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2032703136 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059522716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059522716;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.643 -0400", hash_original_method = "5C4180581403390570CBF3420B87F392", hash_generated_method = "45FF6D66197F9FC92E93A39813372B61")
    final CharSequence[] getResourceTextArray(final int id) {
        addTaint(id);
        int[] rawInfoArray = getArrayStringInfo(id);
        int rawInfoArrayLen = rawInfoArray.length;
        final int infoArrayLen = rawInfoArrayLen / 2;
        int block;
        int index;
        CharSequence[] retArray = new CharSequence[infoArrayLen];
for(int i = 0, j = 0;i < rawInfoArrayLen;i = i + 2,j++)
        {
            block = rawInfoArray[i];
            index = rawInfoArray[i + 1];
            retArray[j] = index >= 0 ? mStringBlocks[block].get(index) : null;
        } //End block
CharSequence[] var99D8976FAB8D6731FEC3A476C186DDE3_233350887 =         retArray;
        var99D8976FAB8D6731FEC3A476C186DDE3_233350887.addTaint(taint);
        return var99D8976FAB8D6731FEC3A476C186DDE3_233350887;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.643 -0400", hash_original_method = "257E397E5CF934BBA53C0ACDE849DFE1", hash_generated_method = "FB015FF512801DC2E01491814AB2838C")
    final boolean getThemeValue(int theme, int ident,
            TypedValue outValue, boolean resolveRefs) {
        addTaint(resolveRefs);
        addTaint(outValue.getTaint());
        addTaint(ident);
        addTaint(theme);
        int block = loadThemeAttributeValue(theme, ident, outValue, resolveRefs);
    if(block >= 0)        
        {
    if(outValue.type != TypedValue.TYPE_STRING)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1363756088 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002259525 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002259525;
            } //End block
            StringBlock[] blocks = mStringBlocks;
    if(blocks == null)            
            {
                ensureStringBlocks();
                blocks = mStringBlocks;
            } //End block
            outValue.string = blocks[block].get(outValue.data);
            boolean varB326B5062B2F0E69046810717534CB09_440463274 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884416358 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884416358;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_645132040 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680535869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680535869;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.644 -0400", hash_original_method = "BC550AAFCB31C90ECB8DB7C3E260076C", hash_generated_method = "DCE89788C7EB9773956D81D513DB3B6E")
    final void ensureStringBlocks() {
    if(mStringBlocks == null)        
        {
            synchronized
(this)            {
    if(mStringBlocks == null)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.644 -0400", hash_original_method = "EDCC94234F08B09DDE56D32F4E25BC85", hash_generated_method = "552332AC010B9B3B79EFA96D1303AC58")
    final void makeStringBlocks(boolean copyFromSystem) {
        addTaint(copyFromSystem);
        final int sysNum = copyFromSystem ? sSystem.mStringBlocks.length : 0;
        final int num = getStringBlockCount();
        mStringBlocks = new StringBlock[num];
    if(localLOGV){ }for(int i=0;i<num;i++)
        {
    if(i < sysNum)            
            {
                mStringBlocks[i] = sSystem.mStringBlocks[i];
            } //End block
            else
            {
                mStringBlocks[i] = new StringBlock(getNativeStringBlock(i), true);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.644 -0400", hash_original_method = "148EA8945A31568904B22E1C4951294F", hash_generated_method = "0911FD5E4793D89CE7EA1E38D1E8E7DE")
    final CharSequence getPooledString(int block, int id) {
        addTaint(id);
        addTaint(block);
CharSequence varCFF2C0E2848EAAE639F8AE3BB2CBAC82_390632383 =         mStringBlocks[block-1].get(id);
        varCFF2C0E2848EAAE639F8AE3BB2CBAC82_390632383.addTaint(taint);
        return varCFF2C0E2848EAAE639F8AE3BB2CBAC82_390632383;
        // ---------- Original Method ----------
        //return mStringBlocks[block-1].get(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.644 -0400", hash_original_method = "7E1B14522C484E4F1B470AEA16F877D6", hash_generated_method = "10B5CCE54F79D4CDFE6080625247FC54")
    public final InputStream open(String fileName) throws IOException {
        addTaint(fileName.getTaint());
InputStream var92A3B81455F572F39D40F8415AC5486E_2019608830 =         open(fileName, ACCESS_STREAMING);
        var92A3B81455F572F39D40F8415AC5486E_2019608830.addTaint(taint);
        return var92A3B81455F572F39D40F8415AC5486E_2019608830;
        // ---------- Original Method ----------
        //return open(fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.645 -0400", hash_original_method = "EB9FEA0B2CEADB65FF0921C2B52A13F4", hash_generated_method = "5DD81E9F4286B10BB0BA2E2134D44278")
    public final InputStream open(String fileName, int accessMode) throws IOException {
        addTaint(accessMode);
        addTaint(fileName.getTaint());
        synchronized
(this)        {
    if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_1831358130 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_1831358130.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_1831358130;
            } //End block
            int asset = openAsset(fileName, accessMode);
    if(asset != 0)            
            {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
InputStream varB5053E025797B3BF768F5C37934C244D_2144628950 =                 res;
                varB5053E025797B3BF768F5C37934C244D_2144628950.addTaint(taint);
                return varB5053E025797B3BF768F5C37934C244D_2144628950;
            } //End block
        } //End block
        FileNotFoundException var01F0E0AF88D5794F91300289D5B4F5BD_1070484861 = new FileNotFoundException("Asset file: " + fileName);
        var01F0E0AF88D5794F91300289D5B4F5BD_1070484861.addTaint(taint);
        throw var01F0E0AF88D5794F91300289D5B4F5BD_1070484861;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.645 -0400", hash_original_method = "66D3D468B1706A8E526F268E61D6D3C7", hash_generated_method = "76879C7B173882A380B32FD7A70CA75D")
    public final AssetFileDescriptor openFd(String fileName) throws IOException {
        addTaint(fileName.getTaint());
        synchronized
(this)        {
    if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_43961333 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_43961333.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_43961333;
            } //End block
            ParcelFileDescriptor pfd = openAssetFd(fileName, mOffsets);
    if(pfd != null)            
            {
AssetFileDescriptor varBF59062CA5609D0A51AB7CA763EFD373_2067045883 =                 new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
                varBF59062CA5609D0A51AB7CA763EFD373_2067045883.addTaint(taint);
                return varBF59062CA5609D0A51AB7CA763EFD373_2067045883;
            } //End block
        } //End block
        FileNotFoundException var01F0E0AF88D5794F91300289D5B4F5BD_1760479714 = new FileNotFoundException("Asset file: " + fileName);
        var01F0E0AF88D5794F91300289D5B4F5BD_1760479714.addTaint(taint);
        throw var01F0E0AF88D5794F91300289D5B4F5BD_1760479714;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.645 -0400", hash_original_method = "B416CA2D934FFC444AFFEA95F80C0673", hash_generated_method = "0FE6C394C5F90F5F86A159921F3A767E")
    public final InputStream openNonAsset(String fileName) throws IOException {
        addTaint(fileName.getTaint());
InputStream var1978765D6D5CAEBB79282DC978C7C36C_1173557269 =         openNonAsset(0, fileName, ACCESS_STREAMING);
        var1978765D6D5CAEBB79282DC978C7C36C_1173557269.addTaint(taint);
        return var1978765D6D5CAEBB79282DC978C7C36C_1173557269;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.645 -0400", hash_original_method = "6F98937B657C3DF287FD2A6608D5C403", hash_generated_method = "4398A58C91988906AA2C485E23D52E7C")
    public final InputStream openNonAsset(String fileName, int accessMode) throws IOException {
        addTaint(accessMode);
        addTaint(fileName.getTaint());
InputStream varB0D157343C35C04E44909221F6AD2640_1384121798 =         openNonAsset(0, fileName, accessMode);
        varB0D157343C35C04E44909221F6AD2640_1384121798.addTaint(taint);
        return varB0D157343C35C04E44909221F6AD2640_1384121798;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, accessMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.646 -0400", hash_original_method = "DECD09E6B1808DA43562160A03482F49", hash_generated_method = "F8533CF829AD7F19FD2A0C088B3384FE")
    public final InputStream openNonAsset(int cookie, String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
InputStream var80B26222AE1DD66F85CDD73D459781A0_519893641 =         openNonAsset(cookie, fileName, ACCESS_STREAMING);
        var80B26222AE1DD66F85CDD73D459781A0_519893641.addTaint(taint);
        return var80B26222AE1DD66F85CDD73D459781A0_519893641;
        // ---------- Original Method ----------
        //return openNonAsset(cookie, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.646 -0400", hash_original_method = "5BC280B3003CA7B8CFB3A2FB67C4E385", hash_generated_method = "D59E3B1D8E45C0F06D33A35DE4D4A3A1")
    public final InputStream openNonAsset(int cookie, String fileName, int accessMode) throws IOException {
        addTaint(accessMode);
        addTaint(fileName.getTaint());
        addTaint(cookie);
        synchronized
(this)        {
    if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_2035226603 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_2035226603.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_2035226603;
            } //End block
            int asset = openNonAssetNative(cookie, fileName, accessMode);
    if(asset != 0)            
            {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
InputStream varB5053E025797B3BF768F5C37934C244D_1344285818 =                 res;
                varB5053E025797B3BF768F5C37934C244D_1344285818.addTaint(taint);
                return varB5053E025797B3BF768F5C37934C244D_1344285818;
            } //End block
        } //End block
        FileNotFoundException varDEF76FF6EB2B6BD3A247F1248FD6001E_399044470 = new FileNotFoundException("Asset absolute file: " + fileName);
        varDEF76FF6EB2B6BD3A247F1248FD6001E_399044470.addTaint(taint);
        throw varDEF76FF6EB2B6BD3A247F1248FD6001E_399044470;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.646 -0400", hash_original_method = "E6C638BB28F04E787E5711BF8F421102", hash_generated_method = "4C9B82AABFF2BA611E9BF42F5DC5AA84")
    public final AssetFileDescriptor openNonAssetFd(String fileName) throws IOException {
        addTaint(fileName.getTaint());
AssetFileDescriptor varD680C72B1E420D2B21AECBC55E301903_1410306956 =         openNonAssetFd(0, fileName);
        varD680C72B1E420D2B21AECBC55E301903_1410306956.addTaint(taint);
        return varD680C72B1E420D2B21AECBC55E301903_1410306956;
        // ---------- Original Method ----------
        //return openNonAssetFd(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.647 -0400", hash_original_method = "A0DC944B46306DDC2CA1031D9C43AC47", hash_generated_method = "0F5E31B230B2C128C0BB14AAFE02A23A")
    public final AssetFileDescriptor openNonAssetFd(int cookie,
            String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
        synchronized
(this)        {
    if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_1183486776 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_1183486776.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_1183486776;
            } //End block
            ParcelFileDescriptor pfd = openNonAssetFdNative(cookie,
                    fileName, mOffsets);
    if(pfd != null)            
            {
AssetFileDescriptor varBF59062CA5609D0A51AB7CA763EFD373_1976476394 =                 new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
                varBF59062CA5609D0A51AB7CA763EFD373_1976476394.addTaint(taint);
                return varBF59062CA5609D0A51AB7CA763EFD373_1976476394;
            } //End block
        } //End block
        FileNotFoundException varDEF76FF6EB2B6BD3A247F1248FD6001E_273372195 = new FileNotFoundException("Asset absolute file: " + fileName);
        varDEF76FF6EB2B6BD3A247F1248FD6001E_273372195.addTaint(taint);
        throw varDEF76FF6EB2B6BD3A247F1248FD6001E_273372195;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.647 -0400", hash_original_method = "602B0A8D272774ACD0101F14F2575F17", hash_generated_method = "A91BC447C7FEE91D043A7A9D01FEEC4D")
    public final XmlResourceParser openXmlResourceParser(String fileName) throws IOException {
        addTaint(fileName.getTaint());
XmlResourceParser var4EB7981FF5CDF306906BF8D2C643895A_1276314089 =         openXmlResourceParser(0, fileName);
        var4EB7981FF5CDF306906BF8D2C643895A_1276314089.addTaint(taint);
        return var4EB7981FF5CDF306906BF8D2C643895A_1276314089;
        // ---------- Original Method ----------
        //return openXmlResourceParser(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.647 -0400", hash_original_method = "06F5CBF51BDA69D9C47BB01131F079C4", hash_generated_method = "C958EBB9FA2A6E33550ECC915E05091B")
    public final XmlResourceParser openXmlResourceParser(int cookie,
            String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
        XmlBlock block = openXmlBlockAsset(cookie, fileName);
        XmlResourceParser rp = block.newParser();
        block.close();
XmlResourceParser var94881A9110223122354D848EDB699834_1940707030 =         rp;
        var94881A9110223122354D848EDB699834_1940707030.addTaint(taint);
        return var94881A9110223122354D848EDB699834_1940707030;
        // ---------- Original Method ----------
        //XmlBlock block = openXmlBlockAsset(cookie, fileName);
        //XmlResourceParser rp = block.newParser();
        //block.close();
        //return rp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.648 -0400", hash_original_method = "675415F1EB93293576759C69BAEA6DCB", hash_generated_method = "F7CFD111A784E888516D1CCAB408075E")
    final XmlBlock openXmlBlockAsset(String fileName) throws IOException {
        addTaint(fileName.getTaint());
XmlBlock varD782855715D61EF8E08F4443A4672770_1611477406 =         openXmlBlockAsset(0, fileName);
        varD782855715D61EF8E08F4443A4672770_1611477406.addTaint(taint);
        return varD782855715D61EF8E08F4443A4672770_1611477406;
        // ---------- Original Method ----------
        //return openXmlBlockAsset(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.648 -0400", hash_original_method = "9588BC172FA11EB2767F6277EAB2B09E", hash_generated_method = "CF7D27AC1FCC8A740BBFED6AF737A790")
    final XmlBlock openXmlBlockAsset(int cookie, String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
        synchronized
(this)        {
    if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_1879294879 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_1879294879.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_1879294879;
            } //End block
            int xmlBlock = openXmlAssetNative(cookie, fileName);
    if(xmlBlock != 0)            
            {
                XmlBlock res = new XmlBlock(this, xmlBlock);
                incRefsLocked(res.hashCode());
XmlBlock varB5053E025797B3BF768F5C37934C244D_210366909 =                 res;
                varB5053E025797B3BF768F5C37934C244D_210366909.addTaint(taint);
                return varB5053E025797B3BF768F5C37934C244D_210366909;
            } //End block
        } //End block
        FileNotFoundException var9DA950BB293223EDCA2C990E69AC6509_1786913055 = new FileNotFoundException("Asset XML file: " + fileName);
        var9DA950BB293223EDCA2C990E69AC6509_1786913055.addTaint(taint);
        throw var9DA950BB293223EDCA2C990E69AC6509_1786913055;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.649 -0400", hash_original_method = "30EAECC95AEB342DDD14100667205DCF", hash_generated_method = "DA7D70306325438936D48906C1143FC7")
     void xmlBlockGone(int id) {
        addTaint(id);
        synchronized
(this)        {
            decRefsLocked(id);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //decRefsLocked(id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.649 -0400", hash_original_method = "9AD5347899C2D862F4815C023E5977D1", hash_generated_method = "97A29D213C14926B302356BE21075311")
    final int createTheme() {
        synchronized
(this)        {
    if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_1790263734 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_1790263734.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_1790263734;
            } //End block
            int res = newTheme();
            incRefsLocked(res);
            int var9B207167E5381C47682C6B4F58A623FB_222189679 = (res);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696947872 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1696947872;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.649 -0400", hash_original_method = "0E7F795DABC0415CCAB4CA5A0005DBB0", hash_generated_method = "B9AFC236AE094409A2B703ACA83EF73A")
    final void releaseTheme(int theme) {
        addTaint(theme);
        synchronized
(this)        {
            deleteTheme(theme);
            decRefsLocked(theme);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //deleteTheme(theme);
            //decRefsLocked(theme);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.649 -0400", hash_original_method = "C1D87D935BC2D519032BCC6CD9CB5D9B", hash_generated_method = "6B30BE53736F045BBA179891F59ED85B")
    protected void finalize() throws Throwable {
        try 
        {
    if(DEBUG_REFS && mNumRefs != 0)            
            {
    if(mRefStacks != null)                
                {
for(RuntimeException e : mRefStacks.values())
                    {
                    } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.649 -0400", hash_original_method = "18B8C5816FBF862D1286972549E79177", hash_generated_method = "3602CC5F39FD24626CEE221FD5D43258")
    public final int addAssetPath(String path) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575887461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575887461;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.650 -0400", hash_original_method = "22EE91EE70E10361F8012967A8F2990A", hash_generated_method = "1D53E5F36F88DB667DBF992259BCC469")
    public final int[] addAssetPaths(String[] paths) {
        addTaint(paths[0].getTaint());
    if(paths == null)        
        {
            int[] var37A6259CC0C1DAE299A7866489DFF0BD_378915099 = (null);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1701245929 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1701245929;
        } //End block
        int[] cookies = new int[paths.length];
for(int i = 0;i < paths.length;i++)
        {
            cookies[i] = addAssetPath(paths[i]);
        } //End block
        int[] var55E7DD3016CE4AC57B9A0F56AF12F7C2_571206033 = (cookies);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1963602440 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1963602440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.650 -0400", hash_original_method = "6E60478B72DEC0ABE7A87F31E1844E8F", hash_generated_method = "D1BDC5D2671BAFCB8A9A53B09585F647")
    public final boolean isUpToDate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548310492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_548310492;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.650 -0400", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "E69921EE5BD0C2E8AB59F1AA37229149")
    public final void setLocale(String locale) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.349 -0400", hash_original_method = "3CB696CCF0EE1BB70EEADB93E6432982", hash_generated_method = "2A1885B1024F713A5324E14BAEA805ED")
    public final String[] getLocales() {
    	String[] mockArray = {""};
    	return mockArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.651 -0400", hash_original_method = "0D7945B64E12882B3ACBA2198421753F", hash_generated_method = "78BC2DBE0FC59033588CFB86A02BD2F9")
    public final void setConfiguration(int mcc, int mnc, String locale,
            int orientation, int touchscreen, int density, int keyboard,
            int keyboardHidden, int navigation, int screenWidth, int screenHeight,
            int smallestScreenWidthDp, int screenWidthDp, int screenHeightDp,
            int screenLayout, int uiMode, int majorVersion) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.651 -0400", hash_original_method = "09A813727514834940DA6C6317E3DBCE", hash_generated_method = "34F00A301191B1FFEEB72669044F25A9")
    final int getResourceIdentifier(String type,
                                                       String name,
                                                       String defPackage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884235105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884235105;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.652 -0400", hash_original_method = "CCB6CD4213F7E59AA2D59934C9160368", hash_generated_method = "3DF65F74314BC00F9D95C2E38F79256C")
    private final int openAsset(String fileName, int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241237908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241237908;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.374 -0400", hash_original_method = "9CBF0316C59A074D9238537266A4CF39", hash_generated_method = "1E5C5B867FCBA6692FC4FC36ABE4480B")
    @DSModeled(DSC.BAN)
    private final ParcelFileDescriptor openAssetFd(String fileName,
            long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.652 -0400", hash_original_method = "81CCCE789A5081BAF563B4B2EE08FF05", hash_generated_method = "8C3BC82533A34AD7AD8914EB2EA02BA1")
    private final int openNonAssetNative(int cookie, String fileName,
            int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359301048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359301048;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.391 -0400", hash_original_method = "05F1691565177C2AFF700A7C71F6F6CD", hash_generated_method = "3A7AF2AA82D95CB2D761B5108753F113")
    private ParcelFileDescriptor openNonAssetFdNative(int cookie,
            String fileName, long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.652 -0400", hash_original_method = "97A034179950872E547C89DFB8D9E922", hash_generated_method = "7C837E96C8BBDC9D87F899C6B59F14DF")
    private final void destroyAsset(int asset) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.653 -0400", hash_original_method = "5F1E2DF7C91A7E126E188B382F4854C7", hash_generated_method = "893D1FEA3083B67311CAE4790671E105")
    private final int readAssetChar(int asset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354743671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354743671;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.653 -0400", hash_original_method = "47F4B97BBBCCF733A9E22BF028AA8D70", hash_generated_method = "9666BD1F7BAB7E3AA841D6DB48DA3FFE")
    private final int readAsset(int asset, byte[] b, int off, int len) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584086488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584086488;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.653 -0400", hash_original_method = "B3BCAF9697DD27514E76657171CAECEC", hash_generated_method = "674D45CCCA9BDE8FE91EE08229A795EA")
    private final long seekAsset(int asset, long offset, int whence) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_118869667 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_118869667;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.653 -0400", hash_original_method = "A83D0C436C33F4BEE2F972AC578D7A68", hash_generated_method = "56485B388DE018D1C91CF881CF9E20DF")
    private final long getAssetLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_512090184 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_512090184;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.653 -0400", hash_original_method = "7F3AC582AA5F20EF55343463044A3085", hash_generated_method = "D116CB099A3A7AC39D37D0B4DE294120")
    private final long getAssetRemainingLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1053445802 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1053445802;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.653 -0400", hash_original_method = "27B70155371A7D816D4F089317C25CF6", hash_generated_method = "69B27EB6C2AC3493AECFB9D3D1CE5D22")
    private final int loadResourceValue(int ident, short density, TypedValue outValue,
            boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_203773706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_203773706;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.653 -0400", hash_original_method = "F08D438D948FB59FEDF35DA42629554E", hash_generated_method = "8E7EE7569CFED4EED295683E14CE7579")
    private final int loadResourceBagValue(int ident, int bagEntryId, TypedValue outValue,
                                               boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268782561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268782561;
    }

    
    static final boolean applyStyle(int theme,
            int defStyleAttr, int defStyleRes, int xmlParser,
            int[] inAttrs, int[] outValues, int[] outIndices) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.654 -0400", hash_original_method = "12B5557C9EEBFED6DAC54E4D9FC20DDD", hash_generated_method = "A32821F156224EA96322712388BA63C2")
    final boolean retrieveAttributes(
            int xmlParser, int[] inAttrs, int[] outValues, int[] outIndices) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1504166103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1504166103;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.654 -0400", hash_original_method = "34A3EC70D4ACE5655FFEE77E96A0F3BC", hash_generated_method = "32C06EFE75C82CDA6FC24E6E01B00B58")
    final int getArraySize(int resource) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17385241 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17385241;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.654 -0400", hash_original_method = "6AA3B6ADCA3DD4B26249D05025D281C3", hash_generated_method = "81A50562FA626168A83CAF05B31D0D8F")
    final int retrieveArray(int resource, int[] outValues) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504623339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504623339;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.654 -0400", hash_original_method = "8643075126929A48F7EB079E8C4278DD", hash_generated_method = "9C37ED3DCD74C97A6796608D11045AD1")
    private final int getStringBlockCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385585819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385585819;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.654 -0400", hash_original_method = "FB0E199BF31B4B98A791A0A97B553C67", hash_generated_method = "F70AE4500DAA4906A166E13CFD1676AC")
    private final int getNativeStringBlock(int block) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764834598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764834598;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.655 -0400", hash_original_method = "4A1BDBE10C6D7479DE706205ED3F0C83", hash_generated_method = "3411B2116DE7973F399DB16969160DD5")
    private final int newTheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921263201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921263201;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.655 -0400", hash_original_method = "CA31B66AC1745FBADC98731EBEE7AB46", hash_generated_method = "B5983DB9C7B891CB2391E729342FB143")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.655 -0400", hash_original_method = "F8A041F054DE87147DC380F35C857F31", hash_generated_method = "915D6075054A0CDBA5B7E06AD49060A8")
    private final int openXmlAssetNative(int cookie, String fileName) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917921813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917921813;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.457 -0400", hash_original_method = "8CA605217ABF9ACD4B0F75B79941D8AD", hash_generated_method = "5F37EF7284C2ED80B62ED2FD114F081D")
    private final String[] getArrayStringResource(int arrayRes) {
    	String[] ret = {""};
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.656 -0400", hash_original_method = "341A9383D92FC9E302B0B298621A3766", hash_generated_method = "060BA50E819BC0E59DA46F711C013B58")
    private final int[] getArrayStringInfo(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_356144385 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_356144385;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.656 -0400", hash_original_method = "BCA05693B8244B417FF82C9EDF7FB611", hash_generated_method = "6124A451D39F1BD367E5C7245DD405ED")
    final int[] getArrayIntResource(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1104533107 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1104533107;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.656 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.656 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.656 -0400", hash_original_method = "8CCD44610E895D23EA7CFE3FA359ACA0", hash_generated_method = "DE1751660204E7F09A57FDCA36D93D5A")
    private final void incRefsLocked(int id) {
        addTaint(id);
    if(DEBUG_REFS)        
        {
    if(mRefStacks == null)            
            {
                mRefStacks = new HashMap<Integer, RuntimeException>();
                RuntimeException ex = new RuntimeException();
                ex.fillInStackTrace();
                mRefStacks.put(this.hashCode(), ex);
            } //End block
        } //End block
        mNumRefs++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.657 -0400", hash_original_method = "5BE87735DD6C438E2E8B68210C5CE018", hash_generated_method = "E8EF9F6E959871F8E8B796CA487874EB")
    private final void decRefsLocked(int id) {
        addTaint(id);
    if(DEBUG_REFS && mRefStacks != null)        
        {
            mRefStacks.remove(id);
        } //End block
        mNumRefs--;
    if(mNumRefs == 0)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.657 -0400", hash_original_field = "8D5507884B6C9BEABDB04A59A4DBA58B", hash_generated_field = "8F8029B3259B8B1BA6498538453FCD52")

        private int mAsset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.657 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

        private long mLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.657 -0400", hash_original_field = "701807B36A85F65CF98EE46A24804A8D", hash_generated_field = "FF38BF9EEDA38C273195A50BE5B2B402")

        private long mMarkPos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.657 -0400", hash_original_method = "73FC7BCEFA9398CB2657C7ECCED60E53", hash_generated_method = "AB67641127F6ADC8DDF0A94D33BF8BC7")
        private  AssetInputStream(int asset) {
            mAsset = asset;
            mLength = getAssetLength(asset);
            // ---------- Original Method ----------
            //mAsset = asset;
            //mLength = getAssetLength(asset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.658 -0400", hash_original_method = "E464EBBB8C3DAC741E7C7914FE6096F4", hash_generated_method = "65638D09E8D49BF82519DC5C5CF7286E")
        public final int getAssetInt() {
            int var8D5507884B6C9BEABDB04A59A4DBA58B_651141652 = (mAsset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295969922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295969922;
            // ---------- Original Method ----------
            //return mAsset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.658 -0400", hash_original_method = "C81989D37BD2D192408FD3EC31DA3DAD", hash_generated_method = "0FB16FB1B06B875897DC56B6BCE5D9FA")
        public final int read() throws IOException {
            int varA3E4FEF8659A951EAED9491FC4AE3BAB_1634940685 = (readAssetChar(mAsset));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791758541 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791758541;
            // ---------- Original Method ----------
            //return readAssetChar(mAsset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.658 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "0F5B2060817913CC9BCC687B30ED3FF2")
        public final boolean markSupported() {
            boolean varB326B5062B2F0E69046810717534CB09_1327783835 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845875058 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845875058;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.659 -0400", hash_original_method = "A5BC52EF5476CDC51345AEEDA1CB06B3", hash_generated_method = "A2E409B237B1C3D0CD2E85DAD1CDA876")
        public final int available() throws IOException {
            long len = getAssetRemainingLength(mAsset);
            int varA0026651D2865D206B2BDD4F1F26B8CD_1731955468 = (len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984169377 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984169377;
            // ---------- Original Method ----------
            //long len = getAssetRemainingLength(mAsset);
            //return len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.659 -0400", hash_original_method = "DCE38A6652895F3698A02DE5A8538C09", hash_generated_method = "1FD3F8F431101B02B329DF8125F7C1E1")
        public final void close() throws IOException {
            synchronized
(AssetManager.this)            {
    if(mAsset != 0)                
                {
                    destroyAsset(mAsset);
                    mAsset = 0;
                    decRefsLocked(hashCode());
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (AssetManager.this) {
                //if (mAsset != 0) {
                    //destroyAsset(mAsset);
                    //mAsset = 0;
                    //decRefsLocked(hashCode());
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.660 -0400", hash_original_method = "7D579BCE4EC4312918D553C49FF13AB2", hash_generated_method = "2556AD44B879D133D7F3F2469C71DBDF")
        public final void mark(int readlimit) {
            addTaint(readlimit);
            mMarkPos = seekAsset(mAsset, 0, 0);
            // ---------- Original Method ----------
            //mMarkPos = seekAsset(mAsset, 0, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.660 -0400", hash_original_method = "659AE57C7CC5071324BF80AF83D49F86", hash_generated_method = "0CAF64AFA3C71A633C3AE770A153F1FF")
        public final void reset() throws IOException {
            seekAsset(mAsset, mMarkPos, -1);
            // ---------- Original Method ----------
            //seekAsset(mAsset, mMarkPos, -1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.660 -0400", hash_original_method = "5E34804727014E6FD2F3F87A050AF853", hash_generated_method = "6C61BBC6344F6399AD35F4199153353E")
        public final int read(byte[] b) throws IOException {
            addTaint(b[0]);
            int var823A4CE1D2F4F36EB9B0F1AA949BD23C_820785560 = (readAsset(mAsset, b, 0, b.length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670856784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670856784;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.661 -0400", hash_original_method = "AA634A995A76E648DEC57A4EAA0F35C1", hash_generated_method = "A85862DE23AD9B10C5592414045079F1")
        public final int read(byte[] b, int off, int len) throws IOException {
            addTaint(len);
            addTaint(off);
            addTaint(b[0]);
            int varB0C4AC9768BF98E63A0C50FC439F0659_1791500657 = (readAsset(mAsset, b, off, len));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893227586 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893227586;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, off, len);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.661 -0400", hash_original_method = "A27B064C1368239357036D853D73FA32", hash_generated_method = "53DA0186538942F779C67043551A2BAA")
        public final long skip(long n) throws IOException {
            addTaint(n);
            long pos = seekAsset(mAsset, 0, 0);
    if((pos+n) > mLength)            
            {
                n = mLength-pos;
            } //End block
    if(n > 0)            
            {
                seekAsset(mAsset, n, 0);
            } //End block
            long var7B8B965AD4BCA0E41AB51DE7B31363A1_1456339679 = (n);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1996995697 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1996995697;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "70F19D02757ECE0694C4C3146D60FC20", hash_generated_field = "C0398846D11F78001E9A1CEACD42B3FD")

    public static final int ACCESS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "8A3909BE7F24687785B8C38BEF1C309B", hash_generated_field = "44C384B355164335E174FF87C9A455A1")

    public static final int ACCESS_RANDOM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "61598E8AE300677EC81F29425A4FCD50", hash_generated_field = "941FA2852A6DCA461D7B2054ECA3EFEA")

    public static final int ACCESS_STREAMING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "601DD6C8A67C19B8F8985DFCC5D065E3", hash_generated_field = "9117C55B3A01E0F8EFB362B3FB5152BD")

    public static final int ACCESS_BUFFER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "D32CE489FB85E2EA1BB422AEDC40B577", hash_generated_field = "FDC75AE01ED37E059BA4F54E9509C8D2")

    private static final String TAG = "AssetManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "81A92DF01F23C5A9AD1A3D7A55CE01D7", hash_generated_field = "776D75E65C0F716B6889BA4A8C683647")

    private static final boolean localLOGV = false || false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "6C66171C47DCB3FC9A5E7CDD49987FEE", hash_generated_field = "C4EDA31E106597348022664C2B4AE055")

    private static final boolean DEBUG_REFS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    private static final Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.662 -0400", hash_original_field = "F21E422E1FCE8D53399A12EF40F632E2", hash_generated_field = "D0731D8853FB150972B9C951A1F661AE")

    static AssetManager sSystem = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.663 -0400", hash_original_field = "D9B9B3EA290DF73D834C2D4B93657BD0", hash_generated_field = "9A482EFAAC5EAFE41C22AFB2C4AFCFEB")

    static final int STYLE_NUM_ENTRIES = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.663 -0400", hash_original_field = "C92BDF2E95BBF2CAE0E9A342859D0CC1", hash_generated_field = "329269D64B272BF04010F03C4C06F535")

    static final int STYLE_TYPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.663 -0400", hash_original_field = "C3CA2AC53788C65ACA81CA7F70114FC8", hash_generated_field = "FC17F8F67F5BAEB1FD0402C771D270B0")

    static final int STYLE_DATA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.663 -0400", hash_original_field = "EFE681D5FC7019383C4D0AD28787ADD8", hash_generated_field = "05C07F6EAB5B9D635D03781B6890450C")

    static final int STYLE_ASSET_COOKIE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.663 -0400", hash_original_field = "26131FD5FA231BF60E5E380AF4A04E09", hash_generated_field = "0505900C52E965C0B90E9A9386CD8DAB")

    static final int STYLE_RESOURCE_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.663 -0400", hash_original_field = "9FCC225808D06F6DD67618D933EA867D", hash_generated_field = "7EF09BBF875A3B7CE09ACBE50176137C")

    static final int STYLE_CHANGING_CONFIGURATIONS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.663 -0400", hash_original_field = "2A826FFA45B8957E369040F1324F0CCD", hash_generated_field = "9B74378301FF8622581D308549021E80")

    static final int STYLE_DENSITY = 5;
}

