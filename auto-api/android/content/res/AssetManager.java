package android.content.res;

// Droidsafe Imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.ParcelFileDescriptor;
import android.util.TypedValue;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class AssetManager {
	public static final int ACCESS_UNKNOWN = 0;
	public static final int ACCESS_RANDOM = 1;
	public static final int ACCESS_STREAMING = 2;
	public static final int ACCESS_BUFFER = 3;
	private static final String TAG = "AssetManager";
	private static final boolean localLOGV = false || false;
	private static final boolean DEBUG_REFS = false;
	private static final Object sSync = new Object();
	static AssetManager sSystem = null;
	private final TypedValue mValue = new TypedValue();
	private final long[] mOffsets = new long[2];
	private int mObject;
	private int mNObject;
	private StringBlock mStringBlocks[] = null;
	private int mNumRefs = 1;
	private boolean mOpen = true;
	private HashMap<Integer, RuntimeException> mRefStacks;
	static final int STYLE_NUM_ENTRIES = 6;
	static final int STYLE_TYPE = 0;
	static final int STYLE_DATA = 1;
	static final int STYLE_ASSET_COOKIE = 2;
	static final int STYLE_RESOURCE_ID = 3;
	static final int STYLE_CHANGING_CONFIGURATIONS = 4;
	static final int STYLE_DENSITY = 5;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.206 -0400", hash_original_method = "59A199C9627818EA5BC55C2223B1B671", hash_generated_method = "ACA0D4FBCD29BE47C61A3B709C2D8486")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public AssetManager() {
		{
			{
				mNumRefs = 0;
				incRefsLocked(this.hashCode());
			} // End block
			init();
			ensureSystemAssets();
		} // End block
			// ---------- Original Method ----------
			// synchronized (this) {
			// if (DEBUG_REFS) {
			// mNumRefs = 0;
			// incRefsLocked(this.hashCode());
		// }
		// init();
		// if (localLOGV) Log.v(TAG, "New asset manager: " + this);
		// ensureSystemAssets();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.206 -0400", hash_original_method = "517E3FEC19C254F005880DBF363FE7AF", hash_generated_method = "D1EA9020459F3C3895C4F7E12FFEA426")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private AssetManager(boolean isSystem) {
		dsTaint.addTaint(isSystem);
		{
			{
				mNumRefs = 0;
				incRefsLocked(this.hashCode());
			} // End block
		} // End block
		init();
		// ---------- Original Method ----------
		// if (DEBUG_REFS) {
		// synchronized (this) {
		// mNumRefs = 0;
		// incRefsLocked(this.hashCode());
		// }
		// }
		// init();
		// if (localLOGV) Log.v(TAG, "New asset manager: " + this);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.206 -0400", hash_original_method = "A821F17F12E0306B831CCEB4175C42F9", hash_generated_method = "92BE533538642ACCDEB5612A7DC60FD5")
	private static void ensureSystemAssets() {
		synchronized (sSync) {
			if (sSystem == null) {
				AssetManager system = new AssetManager(true);
				system.makeStringBlocks(false);
				sSystem = system;
			}
		}
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.206 -0400", hash_original_method = "2E03DF1E56EAF45D52AE236031E99A60", hash_generated_method = "F2D62EEBC23D93EF792674B4D7052CF7")
	public static AssetManager getSystem() {
		ensureSystemAssets();
		return sSystem;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.206 -0400", hash_original_method = "2C3B764DDE8F79C85110BA90D40DB7B8", hash_generated_method = "C9AB9116DF1142842971EEC33FFF5244")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public void close() {
		{
			{
				mOpen = false;
				decRefsLocked(this.hashCode());
			} // End block
		} // End block
			// ---------- Original Method ----------
			// synchronized(this) {
			// if (mOpen) {
			// mOpen = false;
			// decRefsLocked(this.hashCode());
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.207 -0400", hash_original_method = "CB81F9A1A3C0416B5CF420A3F62514E3", hash_generated_method = "2F63E24C5FDF419CDFB43D9E0F976944")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final CharSequence getResourceText(int ident) {
		dsTaint.addTaint(ident);
		{
			TypedValue tmpValue;
			tmpValue = mValue;
			int block;
			block = loadResourceValue(ident, (short) 0, tmpValue, true);
			{
				{
					CharSequence var747A6D32C3D82F99223EF45CF3A73B35_908349664 = (mStringBlocks[block]
							.get(tmpValue.data));
				} // End block
				CharSequence var5200720FC65BCF35BAA60FEC9418BD99_192952946 = (tmpValue
						.coerceToString());
			} // End block
		} // End block
		return dsTaint.getTaintString();
		// ---------- Original Method ----------
		// synchronized (this) {
		// TypedValue tmpValue = mValue;
		// int block = loadResourceValue(ident, (short) 0, tmpValue, true);
		// if (block >= 0) {
		// if (tmpValue.type == TypedValue.TYPE_STRING) {
		// return mStringBlocks[block].get(tmpValue.data);
		// }
		// return tmpValue.coerceToString();
		// }
		// }
		// return null;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.207 -0400", hash_original_method = "2C5FA72B5D3C88AECCC2C4639A2FC63C", hash_generated_method = "CD967CD2CC38C27A772A373E108CE275")
	// DSFIXME: CODE0002: Requires DSC value to be set
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
					CharSequence var747A6D32C3D82F99223EF45CF3A73B35_1979198788 = (mStringBlocks[block]
							.get(tmpValue.data));
				} // End block
				CharSequence var5200720FC65BCF35BAA60FEC9418BD99_485005715 = (tmpValue
						.coerceToString());
			} // End block
		} // End block
		return dsTaint.getTaintString();
		// ---------- Original Method ----------
		// synchronized (this) {
		// TypedValue tmpValue = mValue;
		// int block = loadResourceBagValue(ident, bagEntryId, tmpValue, true);
		// if (block >= 0) {
		// if (tmpValue.type == TypedValue.TYPE_STRING) {
		// return mStringBlocks[block].get(tmpValue.data);
		// }
		// return tmpValue.coerceToString();
		// }
		// }
		// return null;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.207 -0400", hash_original_method = "15AFE30CDC312B3891A5A8072BD8524F", hash_generated_method = "87BA99A0934C17384B10FD08DFD447F8")
	@DSModeled(DSC.SAFE)
	final String[] getResourceStringArray(final int id) {
		dsTaint.addTaint(id);
		String[] retArray;
		retArray = getArrayStringResource(id);
		String[] retVal = new String[1];
		retVal[0] = dsTaint.getTaintString();
		return retVal;
		// ---------- Original Method ----------
		// String[] retArray = getArrayStringResource(id);
		// return retArray;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.208 -0400", hash_original_method = "880DADF9021E8E0236DAC9AB890DE1A9", hash_generated_method = "6E6DD0BF13B3272562D53CB6989CA40E")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final boolean getResourceValue(int ident, int density, TypedValue outValue,
			boolean resolveRefs) {
		dsTaint.addTaint(ident);
		dsTaint.addTaint(density);
		dsTaint.addTaint(outValue.dsTaint);
		dsTaint.addTaint(resolveRefs);
		int block;
		block = loadResourceValue(ident, (short) density, outValue, resolveRefs);
		{
			outValue.string = mStringBlocks[block].get(outValue.data);
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// int block = loadResourceValue(ident, (short) density, outValue,
		// resolveRefs);
		// if (block >= 0) {
		// if (outValue.type != TypedValue.TYPE_STRING) {
		// return true;
		// }
		// outValue.string = mStringBlocks[block].get(outValue.data);
		// return true;
		// }
		// return false;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.208 -0400", hash_original_method = "5C4180581403390570CBF3420B87F392", hash_generated_method = "5BFA1953D612CED6F3EEFE1D28D7B0F3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final CharSequence[] getResourceTextArray(final int id) {
		dsTaint.addTaint(id);
		int[] rawInfoArray;
		rawInfoArray = getArrayStringInfo(id);
		int rawInfoArrayLen;
		rawInfoArrayLen = rawInfoArray.length;
		final int infoArrayLen;
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
				retArray[j] = index >= 0 ? mStringBlocks[block].get(index)
						: null;
			} // End block
		} // End collapsed parenthetic
		CharSequence[] retVal = new CharSequence[1];
		retVal[0] = dsTaint.getTaintString();
		return retVal;
		// ---------- Original Method ----------
		// int[] rawInfoArray = getArrayStringInfo(id);
		// int rawInfoArrayLen = rawInfoArray.length;
		// final int infoArrayLen = rawInfoArrayLen / 2;
		// int block;
		// int index;
		// CharSequence[] retArray = new CharSequence[infoArrayLen];
		// for (int i = 0, j = 0; i < rawInfoArrayLen; i = i + 2, j++) {
		// block = rawInfoArray[i];
		// index = rawInfoArray[i + 1];
		// retArray[j] = index >= 0 ? mStringBlocks[block].get(index) : null;
		// }
		// return retArray;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.208 -0400", hash_original_method = "257E397E5CF934BBA53C0ACDE849DFE1", hash_generated_method = "BB65EA4AC68455DDEDFC9348066C7D7A")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final boolean getThemeValue(int theme, int ident, TypedValue outValue,
			boolean resolveRefs) {
		dsTaint.addTaint(ident);
		dsTaint.addTaint(theme);
		dsTaint.addTaint(outValue.dsTaint);
		dsTaint.addTaint(resolveRefs);
		int block;
		block = loadThemeAttributeValue(theme, ident, outValue, resolveRefs);
		{
			StringBlock[] blocks;
			blocks = mStringBlocks;
			{
				ensureStringBlocks();
				blocks = mStringBlocks;
			} // End block
			outValue.string = blocks[block].get(outValue.data);
		} // End block
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// int block = loadThemeAttributeValue(theme, ident, outValue,
		// resolveRefs);
		// if (block >= 0) {
		// if (outValue.type != TypedValue.TYPE_STRING) {
		// return true;
		// }
		// StringBlock[] blocks = mStringBlocks;
		// if (blocks == null) {
		// ensureStringBlocks();
		// blocks = mStringBlocks;
		// }
		// outValue.string = blocks[block].get(outValue.data);
		// return true;
		// }
		// return false;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.208 -0400", hash_original_method = "BC550AAFCB31C90ECB8DB7C3E260076C", hash_generated_method = "CDDF1C19086319FB205D18788289A33D")
	@DSModeled(DSC.SAFE)
	final void ensureStringBlocks() {
		{
			{
				{
					makeStringBlocks(true);
				} // End block
			} // End block
		} // End block
			// ---------- Original Method ----------
			// if (mStringBlocks == null) {
			// synchronized (this) {
			// if (mStringBlocks == null) {
			// makeStringBlocks(true);
		// }
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.209 -0400", hash_original_method = "EDCC94234F08B09DDE56D32F4E25BC85", hash_generated_method = "D45852285817FDD6E4E6DF121CA76972")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final void makeStringBlocks(boolean copyFromSystem) {
		dsTaint.addTaint(copyFromSystem);
		final int sysNum;
		sysNum = sSystem.mStringBlocks.length;
		final int num;
		num = getStringBlockCount();
		mStringBlocks = new StringBlock[num];
		{
			int i;
			i = 0;
			{
				{
					mStringBlocks[i] = sSystem.mStringBlocks[i];
				} // End block
				{
					mStringBlocks[i] = new StringBlock(getNativeStringBlock(i),
							true);
				} // End block
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// final int sysNum = copyFromSystem ? sSystem.mStringBlocks.length
			// : 0;
			// final int num = getStringBlockCount();
			// mStringBlocks = new StringBlock[num];
			// if (localLOGV) Log.v(TAG, "Making string blocks for " + this
			// + ": " + num);
		// for (int i=0; i<num; i++) {
		// if (i < sysNum) {
		// mStringBlocks[i] = sSystem.mStringBlocks[i];
		// } else {
		// mStringBlocks[i] = new StringBlock(getNativeStringBlock(i), true);
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.209 -0400", hash_original_method = "148EA8945A31568904B22E1C4951294F", hash_generated_method = "46D9A5FDB3516B86E7FAD0D930D2FD51")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final CharSequence getPooledString(int block, int id) {
		dsTaint.addTaint(id);
		dsTaint.addTaint(block);
		CharSequence var2FB0EBD01C989B705B8AA64E1D1A9B7D_1340910356 = (mStringBlocks[block - 1]
				.get(id));
		return dsTaint.getTaintString();
		// ---------- Original Method ----------
		// return mStringBlocks[block-1].get(id);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.209 -0400", hash_original_method = "7E1B14522C484E4F1B470AEA16F877D6", hash_generated_method = "2626B6000A49F4CDB37F6972F4CCBC22")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final InputStream open(String fileName) throws IOException {
		dsTaint.addTaint(fileName);
		InputStream varAB31E48FA16E0E586786604F8F82CDBD_1601911570 = (open(
				fileName, ACCESS_STREAMING));
		return (InputStream) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return open(fileName, ACCESS_STREAMING);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.209 -0400", hash_original_method = "EB9FEA0B2CEADB65FF0921C2B52A13F4", hash_generated_method = "F3D23D933FC0BB60D138A38A72D0AFCB")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final InputStream open(String fileName, int accessMode)
			throws IOException {
		dsTaint.addTaint(accessMode);
		dsTaint.addTaint(fileName);
		{
			{
				if (DroidSafeAndroidRuntime.control)
					throw new RuntimeException("Assetmanager has been closed");
			} // End block
			int asset;
			asset = openAsset(fileName, accessMode);
			{
				AssetInputStream res;
				res = new AssetInputStream(asset);
				incRefsLocked(res.hashCode());
			} // End block
		} // End block
		if (DroidSafeAndroidRuntime.control)
			throw new FileNotFoundException("Asset file: " + fileName);
		return (InputStream) dsTaint.getTaint();
		// ---------- Original Method ----------
		// synchronized (this) {
		// if (!mOpen) {
		// throw new RuntimeException("Assetmanager has been closed");
		// }
		// int asset = openAsset(fileName, accessMode);
		// if (asset != 0) {
		// AssetInputStream res = new AssetInputStream(asset);
		// incRefsLocked(res.hashCode());
		// return res;
		// }
		// }
		// throw new FileNotFoundException("Asset file: " + fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.210 -0400", hash_original_method = "66D3D468B1706A8E526F268E61D6D3C7", hash_generated_method = "FE2BDA989BC1137B9C997CA1E2F46A22")
	@DSModeled(DSC.SAFE)
	public final AssetFileDescriptor openFd(String fileName) throws IOException {
		dsTaint.addTaint(fileName);
		{
			{
				if (DroidSafeAndroidRuntime.control)
					throw new RuntimeException("Assetmanager has been closed");
			} // End block
			ParcelFileDescriptor pfd;
			pfd = openAssetFd(fileName, mOffsets);
		} // End block
		if (DroidSafeAndroidRuntime.control)
			throw new FileNotFoundException("Asset file: " + fileName);
		return (AssetFileDescriptor) dsTaint.getTaint();
		// ---------- Original Method ----------
		// synchronized (this) {
		// if (!mOpen) {
		// throw new RuntimeException("Assetmanager has been closed");
		// }
		// ParcelFileDescriptor pfd = openAssetFd(fileName, mOffsets);
		// if (pfd != null) {
		// return new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
		// }
		// }
		// throw new FileNotFoundException("Asset file: " + fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.210 -0400", hash_original_method = "BFE0DD4127D11EE8C7DC2AF7F1625EB3", hash_generated_method = "61086DFDF64B3C59BCD727ADD4671388")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final String[] list(String path) throws IOException {
		dsTaint.addTaint(path);
		return (String[])dsTaint.getTaintArray();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.210 -0400", hash_original_method = "B416CA2D934FFC444AFFEA95F80C0673", hash_generated_method = "021DFD397E2CE6C6000A4C017D2725C9")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final InputStream openNonAsset(String fileName) throws IOException {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(fileName);
		InputStream var9605422D6A5365A30A544F5BC8368736_699785084 = (openNonAsset(
				0, fileName, ACCESS_STREAMING));
		return (InputStream) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return openNonAsset(0, fileName, ACCESS_STREAMING);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.210 -0400", hash_original_method = "6F98937B657C3DF287FD2A6608D5C403", hash_generated_method = "7A9C7BF466992723955DC0EBA8337AD2")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final InputStream openNonAsset(String fileName, int accessMode)
			throws IOException {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(accessMode);
		dsTaint.addTaint(fileName);
		InputStream var211B711A11721A99A7A9A4493EFF5C8A_2137703916 = (openNonAsset(
				0, fileName, accessMode));
		return (InputStream) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return openNonAsset(0, fileName, accessMode);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.211 -0400", hash_original_method = "DECD09E6B1808DA43562160A03482F49", hash_generated_method = "EDA568EBDA3CAB749472BE4D195ACA7C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final InputStream openNonAsset(int cookie, String fileName)
			throws IOException {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(fileName);
		InputStream var2A361830EC5B7807729DAC3457304EB9_1277340770 = (openNonAsset(
				cookie, fileName, ACCESS_STREAMING));
		return (InputStream) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return openNonAsset(cookie, fileName, ACCESS_STREAMING);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.211 -0400", hash_original_method = "5BC280B3003CA7B8CFB3A2FB67C4E385", hash_generated_method = "13E9A7C64DCBC50BD35A5F86B7C1CA4D")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final InputStream openNonAsset(int cookie, String fileName,
			int accessMode) throws IOException {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(accessMode);
		dsTaint.addTaint(fileName);
		{
			{
				if (DroidSafeAndroidRuntime.control)
					throw new RuntimeException("Assetmanager has been closed");
			} // End block
			int asset;
			asset = openNonAssetNative(cookie, fileName, accessMode);
			{
				AssetInputStream res;
				res = new AssetInputStream(asset);
				incRefsLocked(res.hashCode());
			} // End block
		} // End block
		if (DroidSafeAndroidRuntime.control)
			throw new FileNotFoundException("Asset absolute file: " + fileName);
		return (InputStream) dsTaint.getTaint();
		// ---------- Original Method ----------
		// synchronized (this) {
		// if (!mOpen) {
		// throw new RuntimeException("Assetmanager has been closed");
		// }
		// int asset = openNonAssetNative(cookie, fileName, accessMode);
		// if (asset != 0) {
		// AssetInputStream res = new AssetInputStream(asset);
		// incRefsLocked(res.hashCode());
		// return res;
		// }
		// }
		// throw new FileNotFoundException("Asset absolute file: " + fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.211 -0400", hash_original_method = "E6C638BB28F04E787E5711BF8F421102", hash_generated_method = "0962576F7DEA73847CEB8E5A64EF6BCC")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final AssetFileDescriptor openNonAssetFd(String fileName)
			throws IOException {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(fileName);
		AssetFileDescriptor var8DF85496AD417EDB3C857E07FCD09E5E_1864916810 = (openNonAssetFd(
				0, fileName));
		return (AssetFileDescriptor) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return openNonAssetFd(0, fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.211 -0400", hash_original_method = "A0DC944B46306DDC2CA1031D9C43AC47", hash_generated_method = "252812256CAAB34E3C88DF29D499B260")
	@DSModeled(DSC.SAFE)
	public final AssetFileDescriptor openNonAssetFd(int cookie, String fileName)
			throws IOException {
		// DSFIXME: CODE0009: Possible callback target function detected
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(fileName);
		{
			{
				if (DroidSafeAndroidRuntime.control)
					throw new RuntimeException("Assetmanager has been closed");
			} // End block
			ParcelFileDescriptor pfd;
			pfd = openNonAssetFdNative(cookie, fileName, mOffsets);
		} // End block
		if (DroidSafeAndroidRuntime.control)
			throw new FileNotFoundException("Asset absolute file: " + fileName);
		return (AssetFileDescriptor) dsTaint.getTaint();
		// ---------- Original Method ----------
		// synchronized (this) {
		// if (!mOpen) {
		// throw new RuntimeException("Assetmanager has been closed");
		// }
		// ParcelFileDescriptor pfd = openNonAssetFdNative(cookie,
		// fileName, mOffsets);
		// if (pfd != null) {
		// return new AssetFileDescriptor(pfd, mOffsets[0], mOffsets[1]);
		// }
		// }
		// throw new FileNotFoundException("Asset absolute file: " + fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.212 -0400", hash_original_method = "602B0A8D272774ACD0101F14F2575F17", hash_generated_method = "F3D27EE76DEE9E97F357357184460BC5")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final XmlResourceParser openXmlResourceParser(String fileName)
			throws IOException {
		dsTaint.addTaint(fileName);
		XmlResourceParser varB3244557841A22C57996A99C43B66DE3_1261018421 = (openXmlResourceParser(
				0, fileName));
		return (XmlResourceParser) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return openXmlResourceParser(0, fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.212 -0400", hash_original_method = "06F5CBF51BDA69D9C47BB01131F079C4", hash_generated_method = "2203462F2DCD1EB01B42203074C1016D")
	@DSModeled(DSC.SAFE)
	public final XmlResourceParser openXmlResourceParser(int cookie,
			String fileName) throws IOException {
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(fileName);
		XmlBlock block;
		block = openXmlBlockAsset(cookie, fileName);
		XmlResourceParser rp;
		rp = block.newParser();
		block.close();
		return (XmlResourceParser) dsTaint.getTaint();
		// ---------- Original Method ----------
		// XmlBlock block = openXmlBlockAsset(cookie, fileName);
		// XmlResourceParser rp = block.newParser();
		// block.close();
		// return rp;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.212 -0400", hash_original_method = "675415F1EB93293576759C69BAEA6DCB", hash_generated_method = "95169D9242DC1CF35622B63AFF69B373")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final XmlBlock openXmlBlockAsset(String fileName) throws IOException {
		dsTaint.addTaint(fileName);
		XmlBlock varC0FD185D2A2B5D1F9928F67BA2682B32_1110428166 = (openXmlBlockAsset(
				0, fileName));
		return (XmlBlock) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return openXmlBlockAsset(0, fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.212 -0400", hash_original_method = "9588BC172FA11EB2767F6277EAB2B09E", hash_generated_method = "9015ACB0BD3C3F9B9119F7A5149073E3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final XmlBlock openXmlBlockAsset(int cookie, String fileName)
			throws IOException {
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(fileName);
		{
			{
				if (DroidSafeAndroidRuntime.control)
					throw new RuntimeException("Assetmanager has been closed");
			} // End block
			int xmlBlock;
			xmlBlock = openXmlAssetNative(cookie, fileName);
			{
				XmlBlock res;
				res = new XmlBlock(this, xmlBlock);
				incRefsLocked(res.hashCode());
			} // End block
		} // End block
		if (DroidSafeAndroidRuntime.control)
			throw new FileNotFoundException("Asset XML file: " + fileName);
		return (XmlBlock) dsTaint.getTaint();
		// ---------- Original Method ----------
		// synchronized (this) {
		// if (!mOpen) {
		// throw new RuntimeException("Assetmanager has been closed");
		// }
		// int xmlBlock = openXmlAssetNative(cookie, fileName);
		// if (xmlBlock != 0) {
		// XmlBlock res = new XmlBlock(this, xmlBlock);
		// incRefsLocked(res.hashCode());
		// return res;
		// }
		// }
		// throw new FileNotFoundException("Asset XML file: " + fileName);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.212 -0400", hash_original_method = "30EAECC95AEB342DDD14100667205DCF", hash_generated_method = "16440925D7DFC3E87290E18D2538ECC6")
	@DSModeled(DSC.SAFE)
	void xmlBlockGone(int id) {
		dsTaint.addTaint(id);
		{
			decRefsLocked(id);
		} // End block
			// ---------- Original Method ----------
			// synchronized (this) {
			// decRefsLocked(id);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.213 -0400", hash_original_method = "9AD5347899C2D862F4815C023E5977D1", hash_generated_method = "D653F36BE6935557296498FEDEB49664")
	@DSModeled(DSC.SAFE)
	final int createTheme() {
		{
			{
				if (DroidSafeAndroidRuntime.control)throw new RuntimeException("Assetmanager has been closed");
			} // End block
			int res;
			res = newTheme();
			incRefsLocked(res);
		} // End block
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// synchronized (this) {
		// if (!mOpen) {
		// throw new RuntimeException("Assetmanager has been closed");
		// }
		// int res = newTheme();
		// incRefsLocked(res);
		// return res;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.213 -0400", hash_original_method = "0E7F795DABC0415CCAB4CA5A0005DBB0", hash_generated_method = "1B8C56E09A5E344E922DB7C406F43691")
	@DSModeled(DSC.SAFE)
	final void releaseTheme(int theme) {
		dsTaint.addTaint(theme);
		{
			deleteTheme(theme);
			decRefsLocked(theme);
		} // End block
			// ---------- Original Method ----------
			// synchronized (this) {
			// deleteTheme(theme);
			// decRefsLocked(theme);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.213 -0400", hash_original_method = "C1D87D935BC2D519032BCC6CD9CB5D9B", hash_generated_method = "AC84D7AACEFDABC57D76DA01738F00AF")
	// DSFIXME: CODE0002: Requires DSC value to be set
	protected void finalize() throws Throwable {
		try {
			{
				{
					{
						Iterator<RuntimeException> seatecAstronomy42 = mRefStacks
								.values().iterator();
						seatecAstronomy42.hasNext();
						RuntimeException e = seatecAstronomy42.next();
					} // End collapsed parenthetic
				} // End block
			} // End block
			destroy();
		} // End block
		finally {
			super.finalize();
		} // End block
			// ---------- Original Method ----------
			// try {
			// if (DEBUG_REFS && mNumRefs != 0) {
			// Log.w(TAG, "AssetManager " + this
			// + " finalized with non-zero refs: " + mNumRefs);
		// if (mRefStacks != null) {
		// for (RuntimeException e : mRefStacks.values()) {
		// Log.w(TAG, "Reference from here", e);
		// }
		// }
		// }
		// destroy();
		// } finally {
		// super.finalize();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.213 -0400", hash_original_method = "18B8C5816FBF862D1286972549E79177", hash_generated_method = "EC043D50ABD42C9744033F0C53ABADD8")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final int addAssetPath(String path) {
		dsTaint.addTaint(path);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.213 -0400", hash_original_method = "22EE91EE70E10361F8012967A8F2990A", hash_generated_method = "AD7A4AECCA58B8D7A6979350011418B2")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final int[] addAssetPaths(String[] paths) {
		dsTaint.addTaint(paths);
		int[] cookies;
		cookies = new int[paths.length];
		{
			int i;
			i = 0;
			{
				cookies[i] = addAssetPath(paths[i]);
			} // End block
		} // End collapsed parenthetic
		int[] retVal = new int[1];
		retVal[0] = dsTaint.getTaintInt();
		return retVal;
		// ---------- Original Method ----------
		// if (paths == null) {
		// return null;
		// }
		// int[] cookies = new int[paths.length];
		// for (int i = 0; i < paths.length; i++) {
		// cookies[i] = addAssetPath(paths[i]);
		// }
		// return cookies;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.214 -0400", hash_original_method = "6E60478B72DEC0ABE7A87F31E1844E8F", hash_generated_method = "20DB979150A293FEB367F5C9E47D74FA")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final boolean isUpToDate() {
		return dsTaint.getTaintBoolean();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.214 -0400", hash_original_method = "14770B9914BD8F1A300B2311A4083869", hash_generated_method = "26ED2277B81B0DE0EEDF325743DB2A2F")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final void setLocale(String locale) {
		dsTaint.addTaint(locale);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.214 -0400", hash_original_method = "3CB696CCF0EE1BB70EEADB93E6432982", hash_generated_method = "D8FFE6127A936470619AD432F56A91B6")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final String[] getLocales() {
		return (String[])dsTaint.getTaintArray();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.214 -0400", hash_original_method = "0D7945B64E12882B3ACBA2198421753F", hash_generated_method = "9DA48C15BD6DCC2E15897915215B6D15")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final void setConfiguration(int mcc, int mnc, String locale,
			int orientation, int touchscreen, int density, int keyboard,
			int keyboardHidden, int navigation, int screenWidth,
			int screenHeight, int smallestScreenWidthDp, int screenWidthDp,
			int screenHeightDp, int screenLayout, int uiMode, int majorVersion) {
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
		dsTaint.addTaint(smallestScreenWidthDp);
		dsTaint.addTaint(screenWidth);
		dsTaint.addTaint(navigation);
		dsTaint.addTaint(keyboardHidden);
		dsTaint.addTaint(mnc);
		dsTaint.addTaint(touchscreen);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.214 -0400", hash_original_method = "09A813727514834940DA6C6317E3DBCE", hash_generated_method = "C3FB081AFD4B33C341A521BCAD8180C3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final int getResourceIdentifier(String type, String name, String defPackage) {
		dsTaint.addTaint(name);
		dsTaint.addTaint(type);
		dsTaint.addTaint(defPackage);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.215 -0400", hash_original_method = "A5876C7E6082BC9F857AB889162EC8D3", hash_generated_method = "EF663BF7E6FFDB4DAA7D00D18B14DB7E")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final String getResourceName(int resid) {
		dsTaint.addTaint(resid);
		return dsTaint.getTaintString();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.215 -0400", hash_original_method = "B7E19874BAD16ADDD401F7BE2B2EFFAD", hash_generated_method = "A20F42A5064CA1361352BEB0AD061F48")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final String getResourcePackageName(int resid) {
		dsTaint.addTaint(resid);
		return dsTaint.getTaintString();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.215 -0400", hash_original_method = "D3A87104246875F54A734A7CED9F3792", hash_generated_method = "05CEC9A9F93538F6F3B01A3D94C09126")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final String getResourceTypeName(int resid) {
		dsTaint.addTaint(resid);
		return dsTaint.getTaintString();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.215 -0400", hash_original_method = "7C2D2224C9B46B19401BE8615244E9F1", hash_generated_method = "F48928B168B34FB96E15234F52F2A786")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final String getResourceEntryName(int resid) {
		dsTaint.addTaint(resid);
		return dsTaint.getTaintString();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.215 -0400", hash_original_method = "CCB6CD4213F7E59AA2D59934C9160368", hash_generated_method = "C02B30D65E6E69FC3D58EA79F8F6618A")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int openAsset(String fileName, int accessMode) {
		dsTaint.addTaint(accessMode);
		dsTaint.addTaint(fileName);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.215 -0400", hash_original_method = "9CBF0316C59A074D9238537266A4CF39", hash_generated_method = "3158E4A24E468D67190BB7D73094018C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final ParcelFileDescriptor openAssetFd(String fileName,
			long[] outOffsets) throws IOException {
		dsTaint.addTaint(fileName);
		dsTaint.addTaint(outOffsets);
		return (ParcelFileDescriptor)dsTaint.getTaint();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.215 -0400", hash_original_method = "81CCCE789A5081BAF563B4B2EE08FF05", hash_generated_method = "4E76E16B86E8D41F1AC9B0B0E40C15F5")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int openNonAssetNative(int cookie, String fileName,
			int accessMode) {
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(accessMode);
		dsTaint.addTaint(fileName);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.216 -0400", hash_original_method = "05F1691565177C2AFF700A7C71F6F6CD", hash_generated_method = "68EC641ADFECE96391C40BC16424EF2A")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private ParcelFileDescriptor openNonAssetFdNative(int cookie,
			String fileName, long[] outOffsets) throws IOException {
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(fileName);
		dsTaint.addTaint(outOffsets);
		return (ParcelFileDescriptor)dsTaint.getTaint();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.216 -0400", hash_original_method = "97A034179950872E547C89DFB8D9E922", hash_generated_method = "DDFF2E6A7E8F182C8844652859E758BF")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final void destroyAsset(int asset) {
		dsTaint.addTaint(asset);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.216 -0400", hash_original_method = "5F1E2DF7C91A7E126E188B382F4854C7", hash_generated_method = "2063C7044DBCA9A1C2DAD71A95AC2F54")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int readAssetChar(int asset) {
		dsTaint.addTaint(asset);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.216 -0400", hash_original_method = "47F4B97BBBCCF733A9E22BF028AA8D70", hash_generated_method = "A89DAE479A8DD72E71BB83632126A89A")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int readAsset(int asset, byte[] b, int off, int len) {
		dsTaint.addTaint(asset);
		dsTaint.addTaint(b);
		dsTaint.addTaint(off);
		dsTaint.addTaint(len);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.216 -0400", hash_original_method = "B3BCAF9697DD27514E76657171CAECEC", hash_generated_method = "3A003AAAAB65E04761C6C5AE7183712F")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final long seekAsset(int asset, long offset, int whence) {
		dsTaint.addTaint(whence);
		dsTaint.addTaint(asset);
		dsTaint.addTaint(offset);
		return dsTaint.getTaintLong();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.216 -0400", hash_original_method = "A83D0C436C33F4BEE2F972AC578D7A68", hash_generated_method = "8CE17D1EA48645FD1A31A7CB3FCFA3E2")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final long getAssetLength(int asset) {
		dsTaint.addTaint(asset);
		return dsTaint.getTaintLong();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.217 -0400", hash_original_method = "7F3AC582AA5F20EF55343463044A3085", hash_generated_method = "44E795E42CACA31A4CE33DB35E82AEED")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final long getAssetRemainingLength(int asset) {
		dsTaint.addTaint(asset);
		return dsTaint.getTaintLong();
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.217 -0400", hash_original_method = "27B70155371A7D816D4F089317C25CF6", hash_generated_method = "A6001488EC5549F05466B49F4ECE66F6")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int loadResourceValue(int ident, short density,
			TypedValue outValue, boolean resolve) {
		dsTaint.addTaint(resolve);
		dsTaint.addTaint(ident);
		dsTaint.addTaint(density);
		dsTaint.addTaint(outValue.dsTaint);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.217 -0400", hash_original_method = "F08D438D948FB59FEDF35DA42629554E", hash_generated_method = "6F53C07ED77F3181726FF1DC32CFEF93")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int loadResourceBagValue(int ident, int bagEntryId,
			TypedValue outValue, boolean resolve) {
		dsTaint.addTaint(resolve);
		dsTaint.addTaint(ident);
		dsTaint.addTaint(bagEntryId);
		dsTaint.addTaint(outValue.dsTaint);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.217 -0400", hash_original_method = "C30634D7F2E9C3AE6606B39DC0565BFD", hash_generated_method = "31795F3A4E8605C816B547453068C26B")
	static final boolean applyStyle(int theme, int defStyleAttr,
			int defStyleRes, int xmlParser, int[] inAttrs, int[] outValues,
			int[] outIndices) {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.217 -0400", hash_original_method = "12B5557C9EEBFED6DAC54E4D9FC20DDD", hash_generated_method = "E0511320CA5AE84F99C16DCCC8A7FB61")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final boolean retrieveAttributes(int xmlParser, int[] inAttrs,
			int[] outValues, int[] outIndices) {
		dsTaint.addTaint(outValues);
		dsTaint.addTaint(inAttrs);
		dsTaint.addTaint(outIndices);
		dsTaint.addTaint(xmlParser);
		return dsTaint.getTaintBoolean();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.217 -0400", hash_original_method = "34A3EC70D4ACE5655FFEE77E96A0F3BC", hash_generated_method = "CA0D918543F3320010DB308A0EB80177")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final int getArraySize(int resource) {
		dsTaint.addTaint(resource);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.217 -0400", hash_original_method = "6AA3B6ADCA3DD4B26249D05025D281C3", hash_generated_method = "49A1C81D5262F91B35244E5D8C69B640")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final int retrieveArray(int resource, int[] outValues) {
		dsTaint.addTaint(outValues);
		dsTaint.addTaint(resource);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.218 -0400", hash_original_method = "8643075126929A48F7EB079E8C4278DD", hash_generated_method = "702F08A83F8484BA675EA139AD755C0F")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int getStringBlockCount() {
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.218 -0400", hash_original_method = "FB0E199BF31B4B98A791A0A97B553C67", hash_generated_method = "A058F63885232E48132FEA318A54A80A")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int getNativeStringBlock(int block) {
		dsTaint.addTaint(block);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.218 -0400", hash_original_method = "4BCE1B9C1615D4EB059442B0FC3D8208", hash_generated_method = "28DF7B0F037AE47E4D8C549B4D9352E8")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public final String getCookieName(int cookie) {
		dsTaint.addTaint(cookie);
		return dsTaint.getTaintString();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.218 -0400", hash_original_method = "4370EC96871443F23670974D847AE56F", hash_generated_method = "C2EE1B036C415D9F3588AF483F8C99D2")
	public static final int getGlobalAssetCount() {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.218 -0400", hash_original_method = "8EC963245880F3B82084024EE6EBB66E", hash_generated_method = "799477ED008F458B0BE10AF5B6757053")
	public static final String getAssetAllocations() {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.218 -0400", hash_original_method = "96D21C1C6F19D08B5E8ECFE50806F964", hash_generated_method = "FD05191E2D1179F762DED88E9AF77C8F")
	public static final int getGlobalAssetManagerCount() {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.218 -0400", hash_original_method = "4A1BDBE10C6D7479DE706205ED3F0C83", hash_generated_method = "B3EB492D5F5E484D97CD001832D9F72E")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int newTheme() {
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.219 -0400", hash_original_method = "CA31B66AC1745FBADC98731EBEE7AB46", hash_generated_method = "31CC61F03663A3D02C2A721776BF24A0")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final void deleteTheme(int theme) {
		dsTaint.addTaint(theme);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.219 -0400", hash_original_method = "3A117D6866461E8856A20B1EEDEB2ADD", hash_generated_method = "3482D9BBF68AD0149C9AF1AF5C102FD1")
	static final void applyThemeStyle(int theme, int styleRes, boolean force) {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.219 -0400", hash_original_method = "6BB93CFEA8230EA066D24BFDAE799BE2", hash_generated_method = "B31A26AED95D2CB6C90C9B2EAA59A203")
	static final void copyTheme(int dest, int source) {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.219 -0400", hash_original_method = "1932D5CD42A4E656246AC7DF27312BF2", hash_generated_method = "56509CFDBB44DC64C1710F74FF0AD16B")
	static final int loadThemeAttributeValue(int theme, int ident,
			TypedValue outValue, boolean resolve) {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.219 -0400", hash_original_method = "1B2023275471B112E1A505915EFCF1D8", hash_generated_method = "C503CD2402C390FC57CF45D8CAC56B80")
	static final void dumpTheme(int theme, int priority, String tag,
			String prefix) {
		// DSFIXME: CODE0010: Native static method requires manual modeling
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.219 -0400", hash_original_method = "F8A041F054DE87147DC380F35C857F31", hash_generated_method = "76EBE47D137F71C8732F6118EA374521")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int openXmlAssetNative(int cookie, String fileName) {
		dsTaint.addTaint(cookie);
		dsTaint.addTaint(fileName);
		return dsTaint.getTaintInt();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.219 -0400", hash_original_method = "8CA605217ABF9ACD4B0F75B79941D8AD", hash_generated_method = "8C685CA2E9C809910B6EB3F01CC4369C")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final String[] getArrayStringResource(int arrayRes) {
		dsTaint.addTaint(arrayRes);
		return (String[])dsTaint.getTaintArray();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.220 -0400", hash_original_method = "341A9383D92FC9E302B0B298621A3766", hash_generated_method = "316C57AA567AAD2F9EC7293F0B065E45")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final int[] getArrayStringInfo(int arrayRes) {
		dsTaint.addTaint(arrayRes);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.220 -0400", hash_original_method = "BCA05693B8244B417FF82C9EDF7FB611", hash_generated_method = "8D82FEFF05D426EAE37AFB768C8A3549")
	// DSFIXME: CODE0002: Requires DSC value to be set
	final int[] getArrayIntResource(int arrayRes) {
		dsTaint.addTaint(arrayRes);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.220 -0400", hash_original_method = "0DE93EF32C53D091768788DCA0E281FD", hash_generated_method = "4B1E98977D3F64984DAB4C3850F81BB6")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final void init() {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.220 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "69B84BC3B1EA0628B8FAFB6B271248C1")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final void destroy() {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.220 -0400", hash_original_method = "8CCD44610E895D23EA7CFE3FA359ACA0", hash_generated_method = "B4B51885D3137BBA8091AC2F9D2CC07D")
	// DSFIXME: CODE0002: Requires DSC value to be set
	private final void incRefsLocked(int id) {
		dsTaint.addTaint(id);
		{
			{
				mRefStacks = new HashMap<Integer, RuntimeException>();
				RuntimeException ex;
				ex = new RuntimeException();
				ex.fillInStackTrace();
				mRefStacks.put(this.hashCode(), ex);
			} // End block
		} // End block
		mNumRefs++;
		// ---------- Original Method ----------
		// if (DEBUG_REFS) {
		// if (mRefStacks == null) {
		// mRefStacks = new HashMap<Integer, RuntimeException>();
		// RuntimeException ex = new RuntimeException();
		// ex.fillInStackTrace();
		// mRefStacks.put(this.hashCode(), ex);
		// }
		// }
		// mNumRefs++;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.221 -0400", hash_original_method = "5BE87735DD6C438E2E8B68210C5CE018", hash_generated_method = "F9B64B14C180DEB8EEE063B41F15415B")
	@DSModeled(DSC.SAFE)
	private final void decRefsLocked(int id) {
		dsTaint.addTaint(id);
		{
			mRefStacks.remove(id);
		} // End block
		mNumRefs--;
		{
			destroy();
		} // End block
			// ---------- Original Method ----------
			// if (DEBUG_REFS && mRefStacks != null) {
			// mRefStacks.remove(id);
		// }
		// mNumRefs--;
		// if (mNumRefs == 0) {
		// destroy();
		// }
	}

	public final class AssetInputStream extends InputStream {
		private int mAsset;
		private long mLength;
		private long mMarkPos;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.221 -0400", hash_original_method = "73FC7BCEFA9398CB2657C7ECCED60E53", hash_generated_method = "35F4F4269CAA503D1013D725BA4B0998")
		// DSFIXME: CODE0002: Requires DSC value to be set
		private AssetInputStream(int asset) {
			dsTaint.addTaint(asset);
			mLength = getAssetLength(asset);
			// ---------- Original Method ----------
			// mAsset = asset;
			// mLength = getAssetLength(asset);
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.221 -0400", hash_original_method = "E464EBBB8C3DAC741E7C7914FE6096F4", hash_generated_method = "E746FEE3EEE265FAAEED43C645680519")
		@DSModeled(DSC.SAFE)
		public final int getAssetInt() {
			return dsTaint.getTaintInt();
			// ---------- Original Method ----------
			// return mAsset;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.221 -0400", hash_original_method = "C81989D37BD2D192408FD3EC31DA3DAD", hash_generated_method = "3AE8A4BDFA9ADB7B90CF45B99FE019D2")
		// DSFIXME: CODE0002: Requires DSC value to be set
		public final int read() throws IOException {
			int varE1E0B1D2F32964F8EA30248A4FEDD33A_693919947 = (readAssetChar(mAsset));
			return dsTaint.getTaintInt();
			// ---------- Original Method ----------
			// return readAssetChar(mAsset);
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.222 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "27789AA51E84D42634ABF462CF56B55E")
		@DSModeled(DSC.SAFE)
		public final boolean markSupported() {
			return dsTaint.getTaintBoolean();
			// ---------- Original Method ----------
			// return true;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.222 -0400", hash_original_method = "A5BC52EF5476CDC51345AEEDA1CB06B3", hash_generated_method = "3B4EA7F9B944A01520C68F1F9A89CC1B")
		@DSModeled(DSC.SAFE)
		public final int available() throws IOException {
			long len;
			len = getAssetRemainingLength(mAsset);
			return dsTaint.getTaintInt();
			// ---------- Original Method ----------
			// long len = getAssetRemainingLength(mAsset);
			// return len > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)len;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.222 -0400", hash_original_method = "DCE38A6652895F3698A02DE5A8538C09", hash_generated_method = "0F847841F8B4BF49FDC6B1C97F07FDD7")
		// DSFIXME: CODE0002: Requires DSC value to be set
		public final void close() throws IOException {
			{
				{
					destroyAsset(mAsset);
					mAsset = 0;
					decRefsLocked(hashCode());
				} // End block
			} // End block
				// ---------- Original Method ----------
				// synchronized (AssetManager.this) {
				// if (mAsset != 0) {
				// destroyAsset(mAsset);
				// mAsset = 0;
				// decRefsLocked(hashCode());
			// }
			// }
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.222 -0400", hash_original_method = "7D579BCE4EC4312918D553C49FF13AB2", hash_generated_method = "9608BE090E142D1321ED1CD7128AB58D")
		// DSFIXME: CODE0002: Requires DSC value to be set
		public final void mark(int readlimit) {
			dsTaint.addTaint(readlimit);
			mMarkPos = seekAsset(mAsset, 0, 0);
			// ---------- Original Method ----------
			// mMarkPos = seekAsset(mAsset, 0, 0);
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.223 -0400", hash_original_method = "659AE57C7CC5071324BF80AF83D49F86", hash_generated_method = "CDEAC41A5CBAA364CFF5E0813EA5E8BE")
		@DSModeled(DSC.SAFE)
		public final void reset() throws IOException {
			seekAsset(mAsset, mMarkPos, -1);
			// ---------- Original Method ----------
			// seekAsset(mAsset, mMarkPos, -1);
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.223 -0400", hash_original_method = "5E34804727014E6FD2F3F87A050AF853", hash_generated_method = "1EE07E2F52E832D3D6EE4E0323C50818")
		// DSFIXME: CODE0002: Requires DSC value to be set
		public final int read(byte[] b) throws IOException {
			dsTaint.addTaint(b);
			int var3CAE9971BC75CFC378BD3B49F33BE480_224390218 = (readAsset(
					mAsset, b, 0, b.length));
			return dsTaint.getTaintInt();
			// ---------- Original Method ----------
			// return readAsset(mAsset, b, 0, b.length);
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.223 -0400", hash_original_method = "AA634A995A76E648DEC57A4EAA0F35C1", hash_generated_method = "65D0AB91FA7CF9FBAABECE5B7445901C")
		// DSFIXME: CODE0002: Requires DSC value to be set
		public final int read(byte[] b, int off, int len) throws IOException {
			dsTaint.addTaint(b);
			dsTaint.addTaint(off);
			dsTaint.addTaint(len);
			int var1CBB9CD65705D33AD4651F0428BDA301_376728318 = (readAsset(
					mAsset, b, off, len));
			return dsTaint.getTaintInt();
			// ---------- Original Method ----------
			// return readAsset(mAsset, b, off, len);
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.223 -0400", hash_original_method = "A27B064C1368239357036D853D73FA32", hash_generated_method = "8E4237DF6D5619D81F119DCBCEE1D309")
		@DSModeled(DSC.SAFE)
		public final long skip(long n) throws IOException {
			dsTaint.addTaint(n);
			long pos;
			pos = seekAsset(mAsset, 0, 0);
			{
				n = mLength - pos;
			} // End block
			{
				seekAsset(mAsset, n, 0);
			} // End block
			return dsTaint.getTaintLong();
			// ---------- Original Method ----------
			// long pos = seekAsset(mAsset, 0, 0);
			// if ((pos+n) > mLength) {
			// n = mLength-pos;
			// }
			// if (n > 0) {
			// seekAsset(mAsset, n, 0);
			// }
			// return n;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.224 -0400", hash_original_method = "4D47F0EAA663BB7736165BE426E6C1B2", hash_generated_method = "6285AF0AE727099F1EB230D562F4091F")
		@DSModeled(DSC.SAFE)
		protected void finalize() throws Throwable {
			close();
			// ---------- Original Method ----------
			// close();
		}

	}

}
