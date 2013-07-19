package android.content.res;

// Droidsafe Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import android.os.ParcelFileDescriptor;
import android.util.TypedValue;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class AssetManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.992 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "184B6A2C79F6E655DC652C734EA9E31F")

    private final TypedValue mValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.992 -0400", hash_original_field = "726DCB6228C12E2D638881A1E45E904A", hash_generated_field = "427FE67122035B768BAE648A2E98CFF3")

    private final long[] mOffsets = new long[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.993 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "2791292652EE289D4D904A77FF17FBF6")

    private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.993 -0400", hash_original_field = "68D076ED220BAD43118C707808DC8CD0", hash_generated_field = "CC3C82762AC73E1C6FA469CFF14F9939")

    private int mNObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.993 -0400", hash_original_field = "E4AA04FA1027E6EAB6839BD0E48E31F5", hash_generated_field = "EC37C879DC6C6530C4627CE0DC66498D")

    private StringBlock mStringBlocks[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.993 -0400", hash_original_field = "2BFF3BD7B921429FFC5CFB18F72B0EC1", hash_generated_field = "32DC8A24B3C6E9B83A49CEC09007226E")

    private int mNumRefs = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.993 -0400", hash_original_field = "FA3F9A9DA0C13C19A5EFA6211E2FE7F3", hash_generated_field = "A2271578EE597A5B87471FA73E6D159F")

    private boolean mOpen = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.993 -0400", hash_original_field = "A38CAF679723AF33722554F6AF6CB3DB", hash_generated_field = "057DB168549C247D4E5C64EC3B4E7B98")

    private HashMap<Integer, RuntimeException> mRefStacks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.994 -0400", hash_original_method = "59A199C9627818EA5BC55C2223B1B671", hash_generated_method = "F6A2FF377C5B97CB030AC199B929F026")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.994 -0400", hash_original_method = "517E3FEC19C254F005880DBF363FE7AF", hash_generated_method = "D5A8F5A0591D64A570A79AD2A6A1E787")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.995 -0400", hash_original_method = "2C3B764DDE8F79C85110BA90D40DB7B8", hash_generated_method = "CEA6B3A0235F81D5425A90ED368996FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.996 -0400", hash_original_method = "CB81F9A1A3C0416B5CF420A3F62514E3", hash_generated_method = "F96373037409228AD69AC35B4A86E697")
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
CharSequence var09B760A53753A9A5EC67FF338BD5B918_2133501399 =                     mStringBlocks[block].get(tmpValue.data);
                    var09B760A53753A9A5EC67FF338BD5B918_2133501399.addTaint(taint);
                    return var09B760A53753A9A5EC67FF338BD5B918_2133501399;
                } //End block
CharSequence var143A8D8DAA05C02C1D1E29D098E2AB03_1233593655 =                 tmpValue.coerceToString();
                var143A8D8DAA05C02C1D1E29D098E2AB03_1233593655.addTaint(taint);
                return var143A8D8DAA05C02C1D1E29D098E2AB03_1233593655;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1669628495 =         null;
        var540C13E9E156B687226421B24F2DF178_1669628495.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1669628495;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.997 -0400", hash_original_method = "2C5FA72B5D3C88AECCC2C4639A2FC63C", hash_generated_method = "C1CCF8F7AD319F06E45EB42040180B19")
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
CharSequence var09B760A53753A9A5EC67FF338BD5B918_1339230231 =                     mStringBlocks[block].get(tmpValue.data);
                    var09B760A53753A9A5EC67FF338BD5B918_1339230231.addTaint(taint);
                    return var09B760A53753A9A5EC67FF338BD5B918_1339230231;
                } //End block
CharSequence var143A8D8DAA05C02C1D1E29D098E2AB03_143780837 =                 tmpValue.coerceToString();
                var143A8D8DAA05C02C1D1E29D098E2AB03_143780837.addTaint(taint);
                return var143A8D8DAA05C02C1D1E29D098E2AB03_143780837;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_537136920 =         null;
        var540C13E9E156B687226421B24F2DF178_537136920.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_537136920;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.998 -0400", hash_original_method = "15AFE30CDC312B3891A5A8072BD8524F", hash_generated_method = "AF8C4C4D9DC8C74C69019246D21ABC0A")
    final String[] getResourceStringArray(final int id) {
        addTaint(id);
        String[] retArray = getArrayStringResource(id);
String[] var99D8976FAB8D6731FEC3A476C186DDE3_1272587601 =         retArray;
        var99D8976FAB8D6731FEC3A476C186DDE3_1272587601.addTaint(taint);
        return var99D8976FAB8D6731FEC3A476C186DDE3_1272587601;
        // ---------- Original Method ----------
        //String[] retArray = getArrayStringResource(id);
        //return retArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.999 -0400", hash_original_method = "880DADF9021E8E0236DAC9AB890DE1A9", hash_generated_method = "67F389F36C034407B2DBA78BABC9D90F")
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
                boolean varB326B5062B2F0E69046810717534CB09_576945813 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128025617 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128025617;
            } //End block
            outValue.string = mStringBlocks[block].get(outValue.data);
            boolean varB326B5062B2F0E69046810717534CB09_133977947 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1297215701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1297215701;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_988577457 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640752409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640752409;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.000 -0400", hash_original_method = "5C4180581403390570CBF3420B87F392", hash_generated_method = "EBEC8F5A0611F07F77B32D600361A014")
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
CharSequence[] var99D8976FAB8D6731FEC3A476C186DDE3_1018074946 =         retArray;
        var99D8976FAB8D6731FEC3A476C186DDE3_1018074946.addTaint(taint);
        return var99D8976FAB8D6731FEC3A476C186DDE3_1018074946;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.002 -0400", hash_original_method = "257E397E5CF934BBA53C0ACDE849DFE1", hash_generated_method = "9B9DE0F3D21BEF43A0D803FDA24EC4F4")
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
                boolean varB326B5062B2F0E69046810717534CB09_466303930 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761733279 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761733279;
            } //End block
            StringBlock[] blocks = mStringBlocks;
            if(blocks == null)            
            {
                ensureStringBlocks();
                blocks = mStringBlocks;
            } //End block
            outValue.string = blocks[block].get(outValue.data);
            boolean varB326B5062B2F0E69046810717534CB09_600964397 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133822615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_133822615;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_681220951 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752196608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_752196608;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.002 -0400", hash_original_method = "BC550AAFCB31C90ECB8DB7C3E260076C", hash_generated_method = "DCE89788C7EB9773956D81D513DB3B6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.003 -0400", hash_original_method = "EDCC94234F08B09DDE56D32F4E25BC85", hash_generated_method = "552332AC010B9B3B79EFA96D1303AC58")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.004 -0400", hash_original_method = "148EA8945A31568904B22E1C4951294F", hash_generated_method = "D510D207287ECE8F3E0CA4A387497007")
    final CharSequence getPooledString(int block, int id) {
        addTaint(id);
        addTaint(block);
CharSequence varCFF2C0E2848EAAE639F8AE3BB2CBAC82_1234610401 =         mStringBlocks[block-1].get(id);
        varCFF2C0E2848EAAE639F8AE3BB2CBAC82_1234610401.addTaint(taint);
        return varCFF2C0E2848EAAE639F8AE3BB2CBAC82_1234610401;
        // ---------- Original Method ----------
        //return mStringBlocks[block-1].get(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.004 -0400", hash_original_method = "7E1B14522C484E4F1B470AEA16F877D6", hash_generated_method = "EDA9BE7F297E0916EDE82CBF373FEA2A")
    public final InputStream open(String fileName) throws IOException {
        addTaint(fileName.getTaint());
InputStream var92A3B81455F572F39D40F8415AC5486E_109831350 =         open(fileName, ACCESS_STREAMING);
        var92A3B81455F572F39D40F8415AC5486E_109831350.addTaint(taint);
        return var92A3B81455F572F39D40F8415AC5486E_109831350;
        // ---------- Original Method ----------
        //return open(fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.005 -0400", hash_original_method = "EB9FEA0B2CEADB65FF0921C2B52A13F4", hash_generated_method = "87D56D48B04EBE76CE4D68D6162C11F2")
    public final InputStream open(String fileName, int accessMode) throws IOException {
        addTaint(accessMode);
        addTaint(fileName.getTaint());
        synchronized
(this)        {
            if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_2065341558 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_2065341558.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_2065341558;
            } //End block
            int asset = openAsset(fileName, accessMode);
            if(asset != 0)            
            {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
InputStream varB5053E025797B3BF768F5C37934C244D_2027235759 =                 res;
                varB5053E025797B3BF768F5C37934C244D_2027235759.addTaint(taint);
                return varB5053E025797B3BF768F5C37934C244D_2027235759;
            } //End block
        } //End block
        FileNotFoundException var01F0E0AF88D5794F91300289D5B4F5BD_1525464090 = new FileNotFoundException("Asset file: " + fileName);
        var01F0E0AF88D5794F91300289D5B4F5BD_1525464090.addTaint(taint);
        throw var01F0E0AF88D5794F91300289D5B4F5BD_1525464090;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.005 -0400", hash_original_method = "66D3D468B1706A8E526F268E61D6D3C7", hash_generated_method = "1E9F20BB6CC2401A6C33C0938128C947")
    public final AssetFileDescriptor openFd(String fileName) throws IOException {
        addTaint(fileName.getTaint());
        synchronized
(this)        {
            if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_662012897 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_662012897.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_662012897;
            } //End block
            ParcelFileDescriptor pfd = openAssetFd(fileName, mOffsets);
            if(pfd != null)            
            {
AssetFileDescriptor varBF59062CA5609D0A51AB7CA763EFD373_1903399915 =                 new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
                varBF59062CA5609D0A51AB7CA763EFD373_1903399915.addTaint(taint);
                return varBF59062CA5609D0A51AB7CA763EFD373_1903399915;
            } //End block
        } //End block
        FileNotFoundException var01F0E0AF88D5794F91300289D5B4F5BD_1587864433 = new FileNotFoundException("Asset file: " + fileName);
        var01F0E0AF88D5794F91300289D5B4F5BD_1587864433.addTaint(taint);
        throw var01F0E0AF88D5794F91300289D5B4F5BD_1587864433;
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
    @DSModeled(DSC.SAFE)
    public final String[] list(String path) throws IOException {
    	String[] ret = {path};
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.006 -0400", hash_original_method = "B416CA2D934FFC444AFFEA95F80C0673", hash_generated_method = "F691DA631962E4003892C665A9FF6475")
    public final InputStream openNonAsset(String fileName) throws IOException {
        addTaint(fileName.getTaint());
InputStream var1978765D6D5CAEBB79282DC978C7C36C_1178174065 =         openNonAsset(0, fileName, ACCESS_STREAMING);
        var1978765D6D5CAEBB79282DC978C7C36C_1178174065.addTaint(taint);
        return var1978765D6D5CAEBB79282DC978C7C36C_1178174065;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.006 -0400", hash_original_method = "6F98937B657C3DF287FD2A6608D5C403", hash_generated_method = "C12809F2FA58A1D7AC561580BC7C5913")
    public final InputStream openNonAsset(String fileName, int accessMode) throws IOException {
        addTaint(accessMode);
        addTaint(fileName.getTaint());
InputStream varB0D157343C35C04E44909221F6AD2640_622697741 =         openNonAsset(0, fileName, accessMode);
        varB0D157343C35C04E44909221F6AD2640_622697741.addTaint(taint);
        return varB0D157343C35C04E44909221F6AD2640_622697741;
        // ---------- Original Method ----------
        //return openNonAsset(0, fileName, accessMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.007 -0400", hash_original_method = "DECD09E6B1808DA43562160A03482F49", hash_generated_method = "4D4216FDC09D5507C43ACBFF73A3D70F")
    public final InputStream openNonAsset(int cookie, String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
InputStream var80B26222AE1DD66F85CDD73D459781A0_1829670611 =         openNonAsset(cookie, fileName, ACCESS_STREAMING);
        var80B26222AE1DD66F85CDD73D459781A0_1829670611.addTaint(taint);
        return var80B26222AE1DD66F85CDD73D459781A0_1829670611;
        // ---------- Original Method ----------
        //return openNonAsset(cookie, fileName, ACCESS_STREAMING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.008 -0400", hash_original_method = "5BC280B3003CA7B8CFB3A2FB67C4E385", hash_generated_method = "C7A371E22F7ADA6667B22E80EA55AD05")
    public final InputStream openNonAsset(int cookie, String fileName, int accessMode) throws IOException {
        addTaint(accessMode);
        addTaint(fileName.getTaint());
        addTaint(cookie);
        synchronized
(this)        {
            if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_607252044 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_607252044.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_607252044;
            } //End block
            int asset = openNonAssetNative(cookie, fileName, accessMode);
            if(asset != 0)            
            {
                AssetInputStream res = new AssetInputStream(asset);
                incRefsLocked(res.hashCode());
InputStream varB5053E025797B3BF768F5C37934C244D_1347627152 =                 res;
                varB5053E025797B3BF768F5C37934C244D_1347627152.addTaint(taint);
                return varB5053E025797B3BF768F5C37934C244D_1347627152;
            } //End block
        } //End block
        FileNotFoundException varDEF76FF6EB2B6BD3A247F1248FD6001E_1043835264 = new FileNotFoundException("Asset absolute file: " + fileName);
        varDEF76FF6EB2B6BD3A247F1248FD6001E_1043835264.addTaint(taint);
        throw varDEF76FF6EB2B6BD3A247F1248FD6001E_1043835264;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.009 -0400", hash_original_method = "E6C638BB28F04E787E5711BF8F421102", hash_generated_method = "C28C3C83C8DA5F50D99600E1A86E3760")
    public final AssetFileDescriptor openNonAssetFd(String fileName) throws IOException {
        addTaint(fileName.getTaint());
AssetFileDescriptor varD680C72B1E420D2B21AECBC55E301903_1911663289 =         openNonAssetFd(0, fileName);
        varD680C72B1E420D2B21AECBC55E301903_1911663289.addTaint(taint);
        return varD680C72B1E420D2B21AECBC55E301903_1911663289;
        // ---------- Original Method ----------
        //return openNonAssetFd(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.009 -0400", hash_original_method = "A0DC944B46306DDC2CA1031D9C43AC47", hash_generated_method = "C492F7C43DE868460CF169CFBCA33135")
    public final AssetFileDescriptor openNonAssetFd(int cookie,
            String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
        synchronized
(this)        {
            if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_261020733 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_261020733.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_261020733;
            } //End block
            ParcelFileDescriptor pfd = openNonAssetFdNative(cookie,
                    fileName, mOffsets);
            if(pfd != null)            
            {
AssetFileDescriptor varBF59062CA5609D0A51AB7CA763EFD373_1142187427 =                 new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
                varBF59062CA5609D0A51AB7CA763EFD373_1142187427.addTaint(taint);
                return varBF59062CA5609D0A51AB7CA763EFD373_1142187427;
            } //End block
        } //End block
        FileNotFoundException varDEF76FF6EB2B6BD3A247F1248FD6001E_1270599331 = new FileNotFoundException("Asset absolute file: " + fileName);
        varDEF76FF6EB2B6BD3A247F1248FD6001E_1270599331.addTaint(taint);
        throw varDEF76FF6EB2B6BD3A247F1248FD6001E_1270599331;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.010 -0400", hash_original_method = "602B0A8D272774ACD0101F14F2575F17", hash_generated_method = "9E7776025CFF83B285301902B7E05459")
    public final XmlResourceParser openXmlResourceParser(String fileName) throws IOException {
        addTaint(fileName.getTaint());
XmlResourceParser var4EB7981FF5CDF306906BF8D2C643895A_1035212697 =         openXmlResourceParser(0, fileName);
        var4EB7981FF5CDF306906BF8D2C643895A_1035212697.addTaint(taint);
        return var4EB7981FF5CDF306906BF8D2C643895A_1035212697;
        // ---------- Original Method ----------
        //return openXmlResourceParser(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.010 -0400", hash_original_method = "06F5CBF51BDA69D9C47BB01131F079C4", hash_generated_method = "1A1B3BB47D736E5A615D9B71605C52FB")
    public final XmlResourceParser openXmlResourceParser(int cookie,
            String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
        XmlBlock block = openXmlBlockAsset(cookie, fileName);
        XmlResourceParser rp = block.newParser();
        block.close();
XmlResourceParser var94881A9110223122354D848EDB699834_1042753953 =         rp;
        var94881A9110223122354D848EDB699834_1042753953.addTaint(taint);
        return var94881A9110223122354D848EDB699834_1042753953;
        // ---------- Original Method ----------
        //XmlBlock block = openXmlBlockAsset(cookie, fileName);
        //XmlResourceParser rp = block.newParser();
        //block.close();
        //return rp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.010 -0400", hash_original_method = "675415F1EB93293576759C69BAEA6DCB", hash_generated_method = "8CF4462D764A6D142FD60469263E0365")
    final XmlBlock openXmlBlockAsset(String fileName) throws IOException {
        addTaint(fileName.getTaint());
XmlBlock varD782855715D61EF8E08F4443A4672770_928822721 =         openXmlBlockAsset(0, fileName);
        varD782855715D61EF8E08F4443A4672770_928822721.addTaint(taint);
        return varD782855715D61EF8E08F4443A4672770_928822721;
        // ---------- Original Method ----------
        //return openXmlBlockAsset(0, fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.011 -0400", hash_original_method = "9588BC172FA11EB2767F6277EAB2B09E", hash_generated_method = "0C62CA0CE8E01B2B6DDA65664D351E29")
    final XmlBlock openXmlBlockAsset(int cookie, String fileName) throws IOException {
        addTaint(fileName.getTaint());
        addTaint(cookie);
        synchronized
(this)        {
            if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_1843007554 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_1843007554.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_1843007554;
            } //End block
            int xmlBlock = openXmlAssetNative(cookie, fileName);
            if(xmlBlock != 0)            
            {
                XmlBlock res = new XmlBlock(this, xmlBlock);
                incRefsLocked(res.hashCode());
XmlBlock varB5053E025797B3BF768F5C37934C244D_38034061 =                 res;
                varB5053E025797B3BF768F5C37934C244D_38034061.addTaint(taint);
                return varB5053E025797B3BF768F5C37934C244D_38034061;
            } //End block
        } //End block
        FileNotFoundException var9DA950BB293223EDCA2C990E69AC6509_296867657 = new FileNotFoundException("Asset XML file: " + fileName);
        var9DA950BB293223EDCA2C990E69AC6509_296867657.addTaint(taint);
        throw var9DA950BB293223EDCA2C990E69AC6509_296867657;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.012 -0400", hash_original_method = "30EAECC95AEB342DDD14100667205DCF", hash_generated_method = "DA7D70306325438936D48906C1143FC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.012 -0400", hash_original_method = "9AD5347899C2D862F4815C023E5977D1", hash_generated_method = "359446657D4A7DD57D93A8F488D35CF5")
    final int createTheme() {
        synchronized
(this)        {
            if(!mOpen)            
            {
                RuntimeException varE42575155A0C2DE5DFF4A5F9340BD4F8_1170267284 = new RuntimeException("Assetmanager has been closed");
                varE42575155A0C2DE5DFF4A5F9340BD4F8_1170267284.addTaint(taint);
                throw varE42575155A0C2DE5DFF4A5F9340BD4F8_1170267284;
            } //End block
            int res = newTheme();
            incRefsLocked(res);
            int var9B207167E5381C47682C6B4F58A623FB_1638270226 = (res);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437094567 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437094567;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.013 -0400", hash_original_method = "0E7F795DABC0415CCAB4CA5A0005DBB0", hash_generated_method = "B9AFC236AE094409A2B703ACA83EF73A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.014 -0400", hash_original_method = "C1D87D935BC2D519032BCC6CD9CB5D9B", hash_generated_method = "6B30BE53736F045BBA179891F59ED85B")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.015 -0400", hash_original_method = "18B8C5816FBF862D1286972549E79177", hash_generated_method = "6216652761DFDE75251284C6669B244F")
    public final int addAssetPath(String path) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214364667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214364667;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.016 -0400", hash_original_method = "22EE91EE70E10361F8012967A8F2990A", hash_generated_method = "8E05735C1459B74A16B52FF1833E8B8F")
    public final int[] addAssetPaths(String[] paths) {
        addTaint(paths[0].getTaint());
        if(paths == null)        
        {
            int[] var37A6259CC0C1DAE299A7866489DFF0BD_1942246187 = (null);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1676197296 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1676197296;
        } //End block
        int[] cookies = new int[paths.length];
for(int i = 0;i < paths.length;i++)
        {
            cookies[i] = addAssetPath(paths[i]);
        } //End block
        int[] var55E7DD3016CE4AC57B9A0F56AF12F7C2_1154997428 = (cookies);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_119708210 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_119708210;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.016 -0400", hash_original_method = "6E60478B72DEC0ABE7A87F31E1844E8F", hash_generated_method = "A61B6145FA6017B375138F80D8CD0E18")
    public final boolean isUpToDate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114331951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114331951;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.016 -0400", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "E69921EE5BD0C2E8AB59F1AA37229149")
    public final void setLocale(String locale) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.349 -0400", hash_original_method = "3CB696CCF0EE1BB70EEADB93E6432982", hash_generated_method = "2A1885B1024F713A5324E14BAEA805ED")
    public final String[] getLocales() {
    	String[] mockArray = {""};
    	return mockArray;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.018 -0400", hash_original_method = "0D7945B64E12882B3ACBA2198421753F", hash_generated_method = "78BC2DBE0FC59033588CFB86A02BD2F9")
    public final void setConfiguration(int mcc, int mnc, String locale,
            int orientation, int touchscreen, int density, int keyboard,
            int keyboardHidden, int navigation, int screenWidth, int screenHeight,
            int smallestScreenWidthDp, int screenWidthDp, int screenHeightDp,
            int screenLayout, int uiMode, int majorVersion) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.019 -0400", hash_original_method = "09A813727514834940DA6C6317E3DBCE", hash_generated_method = "9FB107021AE595F0ABBB050E9B3ED746")
    final int getResourceIdentifier(String type,
                                                       String name,
                                                       String defPackage) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276945655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276945655;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.021 -0400", hash_original_method = "CCB6CD4213F7E59AA2D59934C9160368", hash_generated_method = "A40759E222B1A21CF63630F3F29A26AB")
    private final int openAsset(String fileName, int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627561239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627561239;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.374 -0400", hash_original_method = "9CBF0316C59A074D9238537266A4CF39", hash_generated_method = "1E5C5B867FCBA6692FC4FC36ABE4480B")
    @DSModeled(DSC.SAFE)
    private final ParcelFileDescriptor openAssetFd(String fileName,
            long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.022 -0400", hash_original_method = "81CCCE789A5081BAF563B4B2EE08FF05", hash_generated_method = "510D2840327ED39EE37A7A4931F8A585")
    private final int openNonAssetNative(int cookie, String fileName,
            int accessMode) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252373836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252373836;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.391 -0400", hash_original_method = "05F1691565177C2AFF700A7C71F6F6CD", hash_generated_method = "3A7AF2AA82D95CB2D761B5108753F113")
    private ParcelFileDescriptor openNonAssetFdNative(int cookie,
            String fileName, long[] outOffsets) throws IOException {
    	return ParcelFileDescriptor.open(new File(fileName), ParcelFileDescriptor.MODE_READ_WRITE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.024 -0400", hash_original_method = "97A034179950872E547C89DFB8D9E922", hash_generated_method = "7C837E96C8BBDC9D87F899C6B59F14DF")
    private final void destroyAsset(int asset) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.024 -0400", hash_original_method = "5F1E2DF7C91A7E126E188B382F4854C7", hash_generated_method = "F8D817B30F35E7B6C690A8A8FF554FFB")
    private final int readAssetChar(int asset) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293213739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293213739;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.024 -0400", hash_original_method = "47F4B97BBBCCF733A9E22BF028AA8D70", hash_generated_method = "6DD810D6515179507BA08313C78D7C1C")
    private final int readAsset(int asset, byte[] b, int off, int len) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_834253144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_834253144;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.025 -0400", hash_original_method = "B3BCAF9697DD27514E76657171CAECEC", hash_generated_method = "D92B1A5ADA273C5F269010CCEAB588A9")
    private final long seekAsset(int asset, long offset, int whence) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1752765527 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1752765527;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.025 -0400", hash_original_method = "A83D0C436C33F4BEE2F972AC578D7A68", hash_generated_method = "8FD1CBCFBD3E988052143BDD2630E325")
    private final long getAssetLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1053764240 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1053764240;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.026 -0400", hash_original_method = "7F3AC582AA5F20EF55343463044A3085", hash_generated_method = "85008B39E1689919F4D015DEE662E4A0")
    private final long getAssetRemainingLength(int asset) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1780099642 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1780099642;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.026 -0400", hash_original_method = "27B70155371A7D816D4F089317C25CF6", hash_generated_method = "15E3B6BF9F549C626B53230B279F9F3B")
    private final int loadResourceValue(int ident, short density, TypedValue outValue,
            boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878931291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878931291;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.027 -0400", hash_original_method = "F08D438D948FB59FEDF35DA42629554E", hash_generated_method = "A75D9C8DCB0AEB8ACDDB03FB34695CD8")
    private final int loadResourceBagValue(int ident, int bagEntryId, TypedValue outValue,
                                               boolean resolve) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222875599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222875599;
    }

    
    @DSModeled(DSC.SAFE)
    static final boolean applyStyle(int theme,
            int defStyleAttr, int defStyleRes, int xmlParser,
            int[] inAttrs, int[] outValues, int[] outIndices) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.028 -0400", hash_original_method = "12B5557C9EEBFED6DAC54E4D9FC20DDD", hash_generated_method = "5E0D98E49E5D70432C2D2FBEC3CF885B")
    final boolean retrieveAttributes(
            int xmlParser, int[] inAttrs, int[] outValues, int[] outIndices) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1602276716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1602276716;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.028 -0400", hash_original_method = "34A3EC70D4ACE5655FFEE77E96A0F3BC", hash_generated_method = "6065B936320D52FA0007567A01B35803")
    final int getArraySize(int resource) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370251662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370251662;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.028 -0400", hash_original_method = "6AA3B6ADCA3DD4B26249D05025D281C3", hash_generated_method = "326720A43176CF85C37FBE6F403EECE6")
    final int retrieveArray(int resource, int[] outValues) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085686726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085686726;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.028 -0400", hash_original_method = "8643075126929A48F7EB079E8C4278DD", hash_generated_method = "4F37F8AB22AF36B276DA6CC622D5AF9E")
    private final int getStringBlockCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45133732 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45133732;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.029 -0400", hash_original_method = "FB0E199BF31B4B98A791A0A97B553C67", hash_generated_method = "B397F9224D7B0ADBC2D77FCC12EF4B97")
    private final int getNativeStringBlock(int block) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244029255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244029255;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.442 -0400", hash_original_method = "4BCE1B9C1615D4EB059442B0FC3D8208", hash_generated_method = "B12B3AC485F057CA49E8D0EDA1BD9B08")
    @DSModeled(DSC.SAFE)
    public final String getCookieName(int cookie) {
    	return "";
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.030 -0400", hash_original_method = "4A1BDBE10C6D7479DE706205ED3F0C83", hash_generated_method = "979B27F64DE61FBB05CD831FE72E608F")
    private final int newTheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611431378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611431378;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.030 -0400", hash_original_method = "CA31B66AC1745FBADC98731EBEE7AB46", hash_generated_method = "B5983DB9C7B891CB2391E729342FB143")
    private final void deleteTheme(int theme) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.032 -0400", hash_original_method = "F8A041F054DE87147DC380F35C857F31", hash_generated_method = "6A90B444D0C55CB191A3934A8FB1F93B")
    private final int openXmlAssetNative(int cookie, String fileName) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888464920 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888464920;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:07.457 -0400", hash_original_method = "8CA605217ABF9ACD4B0F75B79941D8AD", hash_generated_method = "5F37EF7284C2ED80B62ED2FD114F081D")
    private final String[] getArrayStringResource(int arrayRes) {
    	String[] ret = {""};
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.034 -0400", hash_original_method = "341A9383D92FC9E302B0B298621A3766", hash_generated_method = "77F99831F777B58AB7D1550486BE3D2B")
    private final int[] getArrayStringInfo(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1139777469 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1139777469;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.034 -0400", hash_original_method = "BCA05693B8244B417FF82C9EDF7FB611", hash_generated_method = "60509EA3DD5E9DC33893E8C680C6A0F7")
    final int[] getArrayIntResource(int arrayRes) {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_55174861 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_55174861;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.034 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "9921D3E675F5E10CBA9EBD66FA021538")
    private final void init() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.035 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "15731F8D3959A4577DA5453E16C6C563")
    private final void destroy() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.035 -0400", hash_original_method = "8CCD44610E895D23EA7CFE3FA359ACA0", hash_generated_method = "DE1751660204E7F09A57FDCA36D93D5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.035 -0400", hash_original_method = "5BE87735DD6C438E2E8B68210C5CE018", hash_generated_method = "E8EF9F6E959871F8E8B796CA487874EB")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.036 -0400", hash_original_field = "8D5507884B6C9BEABDB04A59A4DBA58B", hash_generated_field = "8F8029B3259B8B1BA6498538453FCD52")

        private int mAsset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.036 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "56354C84F68C232CB4A6660E662F1AD3")

        private long mLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.036 -0400", hash_original_field = "701807B36A85F65CF98EE46A24804A8D", hash_generated_field = "FF38BF9EEDA38C273195A50BE5B2B402")

        private long mMarkPos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.036 -0400", hash_original_method = "73FC7BCEFA9398CB2657C7ECCED60E53", hash_generated_method = "AB67641127F6ADC8DDF0A94D33BF8BC7")
        private  AssetInputStream(int asset) {
            mAsset = asset;
            mLength = getAssetLength(asset);
            // ---------- Original Method ----------
            //mAsset = asset;
            //mLength = getAssetLength(asset);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.037 -0400", hash_original_method = "E464EBBB8C3DAC741E7C7914FE6096F4", hash_generated_method = "789B1071DFE643346C65920EA8E303D2")
        public final int getAssetInt() {
            int var8D5507884B6C9BEABDB04A59A4DBA58B_1574985218 = (mAsset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699774943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699774943;
            // ---------- Original Method ----------
            //return mAsset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.037 -0400", hash_original_method = "C81989D37BD2D192408FD3EC31DA3DAD", hash_generated_method = "FE7DA12B8B85AA113AA5075A9491A53D")
        public final int read() throws IOException {
            int varA3E4FEF8659A951EAED9491FC4AE3BAB_1322167384 = (readAssetChar(mAsset));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553942943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553942943;
            // ---------- Original Method ----------
            //return readAssetChar(mAsset);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.037 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "1FABE2962E167CDD2DA85D7F0FF16FFE")
        public final boolean markSupported() {
            boolean varB326B5062B2F0E69046810717534CB09_1136450817 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975589949 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975589949;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.038 -0400", hash_original_method = "A5BC52EF5476CDC51345AEEDA1CB06B3", hash_generated_method = "57D5E534FD75CD11FF7F523F2FEF82E6")
        public final int available() throws IOException {
            long len = getAssetRemainingLength(mAsset);
            int varA0026651D2865D206B2BDD4F1F26B8CD_1750769125 = (len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594293652 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594293652;
            // ---------- Original Method ----------
            //long len = getAssetRemainingLength(mAsset);
            //return len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.038 -0400", hash_original_method = "DCE38A6652895F3698A02DE5A8538C09", hash_generated_method = "1FD3F8F431101B02B329DF8125F7C1E1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.038 -0400", hash_original_method = "7D579BCE4EC4312918D553C49FF13AB2", hash_generated_method = "2556AD44B879D133D7F3F2469C71DBDF")
        public final void mark(int readlimit) {
            addTaint(readlimit);
            mMarkPos = seekAsset(mAsset, 0, 0);
            // ---------- Original Method ----------
            //mMarkPos = seekAsset(mAsset, 0, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.039 -0400", hash_original_method = "659AE57C7CC5071324BF80AF83D49F86", hash_generated_method = "0CAF64AFA3C71A633C3AE770A153F1FF")
        public final void reset() throws IOException {
            seekAsset(mAsset, mMarkPos, -1);
            // ---------- Original Method ----------
            //seekAsset(mAsset, mMarkPos, -1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.039 -0400", hash_original_method = "5E34804727014E6FD2F3F87A050AF853", hash_generated_method = "5A0E069D8A379A1B84AFCD4E702265C1")
        public final int read(byte[] b) throws IOException {
            addTaint(b[0]);
            int var823A4CE1D2F4F36EB9B0F1AA949BD23C_268829296 = (readAsset(mAsset, b, 0, b.length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220921516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220921516;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.039 -0400", hash_original_method = "AA634A995A76E648DEC57A4EAA0F35C1", hash_generated_method = "AA1A78BD344F19D3D8A8FF3E7EBA403A")
        public final int read(byte[] b, int off, int len) throws IOException {
            addTaint(len);
            addTaint(off);
            addTaint(b[0]);
            int varB0C4AC9768BF98E63A0C50FC439F0659_963017999 = (readAsset(mAsset, b, off, len));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916865389 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916865389;
            // ---------- Original Method ----------
            //return readAsset(mAsset, b, off, len);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.040 -0400", hash_original_method = "A27B064C1368239357036D853D73FA32", hash_generated_method = "55C0C052F98EF31528DC34710EE5AAF9")
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
            long var7B8B965AD4BCA0E41AB51DE7B31363A1_2063272144 = (n);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1342828355 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1342828355;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "D49A6EC8D8327F8E6A58054E448C9AAB")
        protected void finalize() throws Throwable {
            close();
            // ---------- Original Method ----------
            //close();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "70F19D02757ECE0694C4C3146D60FC20", hash_generated_field = "C0398846D11F78001E9A1CEACD42B3FD")

    public static final int ACCESS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "8A3909BE7F24687785B8C38BEF1C309B", hash_generated_field = "44C384B355164335E174FF87C9A455A1")

    public static final int ACCESS_RANDOM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "61598E8AE300677EC81F29425A4FCD50", hash_generated_field = "941FA2852A6DCA461D7B2054ECA3EFEA")

    public static final int ACCESS_STREAMING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "601DD6C8A67C19B8F8985DFCC5D065E3", hash_generated_field = "9117C55B3A01E0F8EFB362B3FB5152BD")

    public static final int ACCESS_BUFFER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "D32CE489FB85E2EA1BB422AEDC40B577", hash_generated_field = "FDC75AE01ED37E059BA4F54E9509C8D2")

    private static final String TAG = "AssetManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "81A92DF01F23C5A9AD1A3D7A55CE01D7", hash_generated_field = "776D75E65C0F716B6889BA4A8C683647")

    private static final boolean localLOGV = false || false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "6C66171C47DCB3FC9A5E7CDD49987FEE", hash_generated_field = "C4EDA31E106597348022664C2B4AE055")

    private static final boolean DEBUG_REFS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.041 -0400", hash_original_field = "2F49D49D71E16DE6B9E03ABB51788CD5", hash_generated_field = "589A8BDF0C7416090F474EA4E832C9BC")

    private static final Object sSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "F21E422E1FCE8D53399A12EF40F632E2", hash_generated_field = "D0731D8853FB150972B9C951A1F661AE")

    static AssetManager sSystem = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "D9B9B3EA290DF73D834C2D4B93657BD0", hash_generated_field = "9A482EFAAC5EAFE41C22AFB2C4AFCFEB")

    static final int STYLE_NUM_ENTRIES = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "C92BDF2E95BBF2CAE0E9A342859D0CC1", hash_generated_field = "329269D64B272BF04010F03C4C06F535")

    static final int STYLE_TYPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "C3CA2AC53788C65ACA81CA7F70114FC8", hash_generated_field = "FC17F8F67F5BAEB1FD0402C771D270B0")

    static final int STYLE_DATA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "EFE681D5FC7019383C4D0AD28787ADD8", hash_generated_field = "05C07F6EAB5B9D635D03781B6890450C")

    static final int STYLE_ASSET_COOKIE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "26131FD5FA231BF60E5E380AF4A04E09", hash_generated_field = "0505900C52E965C0B90E9A9386CD8DAB")

    static final int STYLE_RESOURCE_ID = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "9FCC225808D06F6DD67618D933EA867D", hash_generated_field = "7EF09BBF875A3B7CE09ACBE50176137C")

    static final int STYLE_CHANGING_CONFIGURATIONS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:06.042 -0400", hash_original_field = "2A826FFA45B8957E369040F1324F0CCD", hash_generated_field = "9B74378301FF8622581D308549021E80")

    static final int STYLE_DENSITY = 5;
}

