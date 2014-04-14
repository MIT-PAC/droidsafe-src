package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import android.util.Slog;
import droidsafe.annotations.*;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import libcore.icu.NativePluralRules;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;

import android.R;

public class Resources {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @SuppressWarnings("unchecked")
    private static <T> LongSparseArray<T> emptySparseArray() {
        return (LongSparseArray<T>) EMPTY_ARRAY;
    }
    
    public static int selectDefaultTheme(int curTheme, int targetSdkVersion){
		// Original method
		/*
		{
        return selectSystemTheme(curTheme, targetSdkVersion,
                com.android.internal.R.style.Theme,
                com.android.internal.R.style.Theme_Holo,
                com.android.internal.R.style.Theme_DeviceDefault);
    }
		*/
		return 0;
	}
    
    public static int selectSystemTheme(int curTheme, int targetSdkVersion,
            int orig, int holo, int deviceDefault){
		// Original method
		/*
		{
        if (curTheme != 0) {
            return curTheme;
        }
        if (targetSdkVersion < Build.VERSION_CODES.HONEYCOMB) {
            return orig;
        }
        if (targetSdkVersion < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return holo;
        }
        return deviceDefault;
    }
		*/
		return 0;
	}
    
	@DSComment("System resources")
    @DSSpec(DSCat.SYSTEM)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public static Resources getSystem(){
	    if (mSystem == null)
	        mSystem = new Resources();
	    return mSystem;
	}
    
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int attrForQuantityCode(int quantityCode){
		// Original method
		/*
		{
        switch (quantityCode) {
            case NativePluralRules.ZERO: return 0x01000005;
            case NativePluralRules.ONE:  return 0x01000006;
            case NativePluralRules.TWO:  return 0x01000007;
            case NativePluralRules.FEW:  return 0x01000008;
            case NativePluralRules.MANY: return 0x01000009;
            default:                     return ID_OTHER;
        }
    }
		*/
		return 0;
	}
    
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String stringForQuantityCode(int quantityCode){
    	String str = new String();
		str.addTaint(quantityCode);
		return str;

	}
    
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics,
            CompatibilityInfo compat){
		// Original method
		/*
		{
        if (mSystem != null) {
            mSystem.updateConfiguration(config, metrics, compat);
        }
    }
		*/
		//Return nothing
	}
    
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics){
		// Original method
		/*
		{
        updateSystemConfiguration(config, metrics, null);
    }
		*/
		//Return nothing
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.208 -0500", hash_original_field = "E26F9411AF04540E7F8A629F86F8CC50", hash_generated_field = "5C5F00C441325249E30C64C6E802A217")

    static final String TAG = "Resources";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.211 -0500", hash_original_field = "5C480BABD4D983BC732ACE8DE1F28D24", hash_generated_field = "AF24F38B7F7C1BFCBE31FAF56BF34CB6")

    private static final boolean DEBUG_LOAD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.213 -0500", hash_original_field = "213A17133C5D24030072519BA98B7C42", hash_generated_field = "131175486DA42E2C78B20447DB22788A")

    private static final boolean DEBUG_CONFIG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.216 -0500", hash_original_field = "CDFFE01919EB427E474F0463DF60058C", hash_generated_field = "ED55101D7A3C371E9777857F76A372CF")

    private static final boolean DEBUG_ATTRIBUTES_CACHE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.218 -0500", hash_original_field = "9045193D3112C823411A5E917FD8B531", hash_generated_field = "FE0143F1FA8AEE992FE6EE3E360B86DA")

    private static final boolean TRACE_FOR_PRELOAD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.221 -0500", hash_original_field = "8F29DF0FE1722971037E487B7FD1D63D", hash_generated_field = "4CD3842605BE6EE30BF77207C2F75B29")

    private static final boolean TRACE_FOR_MISS_PRELOAD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.223 -0500", hash_original_field = "C9CA7C26E8EB9FE4811FE950D2640279", hash_generated_field = "C862CC81028DD3AA6BB9CABD701825FB")

    private static final int ID_OTHER = 0x01000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.225 -0500", hash_original_field = "349D1EAD6A3DD6EDFBBB76E7AC55FC2F", hash_generated_field = "F668D47897E28620543685D1E68BB2A5")

    private static final Object mSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.228 -0500", hash_original_field = "2B10381FAC408B00D7EEB9F47F3BA009", hash_generated_field = "B0DD5DC72B0C526323B11A6CF67A9E4F")
 static Resources mSystem = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.230 -0500", hash_original_field = "D431C2F709CB1E937443230B6EA54F75", hash_generated_field = "2B5D012CFA7A004E497CE506CF5AD619")

    // protected by a lock, because while preloading in zygote we are all
    // single-threaded, and after that these are immutable.
    private static final LongSparseArray<Drawable.ConstantState> sPreloadedDrawables
            = new LongSparseArray<Drawable.ConstantState>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.233 -0500", hash_original_field = "5601BAA9C3F19C65D800B3301467DA51", hash_generated_field = "7BD9FC30967896FB869451238EE23A0C")

    private static final SparseArray<ColorStateList> mPreloadedColorStateLists
            = new SparseArray<ColorStateList>();

    private static class MyEmptyArray extends LongSparseArray<Object> {
        
        public MyEmptyArray(int size) {
            //super(size);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.235 -0500", hash_original_field = "9099E42B2BF11313F2D793DD368CD27E", hash_generated_field = "235E8CAB2CC01C0FEFA2A60D1BF91B25")

    private static final LongSparseArray<Drawable.ConstantState> sPreloadedColorDrawables
            = new LongSparseArray<Drawable.ConstantState>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.237 -0500", hash_original_field = "91D7834328963FA66F96844F0C5FE85F", hash_generated_field = "C895D84621E3994464E604D55CAE67F1")

    private static boolean mPreloaded;
    private static final LongSparseArray<Object> EMPTY_ARRAY = new MyEmptyArray(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.239 -0500", hash_original_field = "3E9DE2CC62973C980770A1C51776F761", hash_generated_field = "F4896FA60EAF46F89D1B23DB39A94469")
 final TypedValue mTmpValue = new TypedValue();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.241 -0500", hash_original_field = "9D24B7F34F84AC01BB0E89B30BBD1790", hash_generated_field = "914D1123EB75F882952E0A98C7FB0DC2")
 final Configuration mTmpConfig = new Configuration();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.244 -0500", hash_original_field = "A8A412581C53DE1E92331A7A2342642F", hash_generated_field = "2497447FAB09A4CFB8FC865DC436A822")

    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.246 -0500", hash_original_field = "2A70ACFE3CA39CC9D47B2F426EDC20F3", hash_generated_field = "933772720D2EC5433FC43B2D14875AB3")

    private final SparseArray<WeakReference<ColorStateList> > mColorStateListCache
            = new SparseArray<WeakReference<ColorStateList> >();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.248 -0500", hash_original_field = "D8425D2288D0FBFD7EEA253DF7C08ED4", hash_generated_field = "7B6BE91A39836F0EC0472965B013125A")

    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mColorDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.251 -0500", hash_original_field = "77C83110B6565866F474BD7941A8BA75", hash_generated_field = "5259D7DBB68DFBC3AE42A15C0065F5F7")

    private boolean mPreloading;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.253 -0500", hash_original_field = "7F4C1E655952669DB05D0D7D3EE40E92", hash_generated_field = "7F4C1E655952669DB05D0D7D3EE40E92")
 TypedArray mCachedStyledAttributes = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.255 -0500", hash_original_field = "BB3486733E348C9268582EB8BBF07AF9", hash_generated_field = "BB3486733E348C9268582EB8BBF07AF9")

    RuntimeException mLastRetrievedAttrs = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.257 -0500", hash_original_field = "A4A22804FE49495B5F278DEBA7A03C59", hash_generated_field = "D7E7153558BB8F6EF13392C958C199F3")

    private int mLastCachedXmlBlockIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.259 -0500", hash_original_field = "7A670BEAB8E9FBBA8553AF66CADA72C6", hash_generated_field = "279259CEA3B9EA7BE3315FDEF65F4C2B")

    private final int[] mCachedXmlBlockIds = { 0, 0, 0, 0 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.261 -0500", hash_original_field = "B9E7CC3A90DC133D911CD28FFFCADAC1", hash_generated_field = "8B8D941C6918446EE4A5194B99D8AA93")

    private final XmlBlock[] mCachedXmlBlocks = new XmlBlock[4];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.263 -0500", hash_original_field = "4C5448F642D7E098FE1B989A50398568", hash_generated_field = "4C5448F642D7E098FE1B989A50398568")
  AssetManager mAssets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.266 -0500", hash_original_field = "3C4DD425CF8419EC4E2481AF19CC253D", hash_generated_field = "A59DFC0CAA3A3B58227151AEDB308CC4")

    private final Configuration mConfiguration = new Configuration();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.268 -0500", hash_original_field = "86B3BC57B90084EEB437023CD43EAEE3", hash_generated_field = "67B89A314350924017B72D96E300AA50")
 final DisplayMetrics mMetrics = new DisplayMetrics();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.270 -0500", hash_original_field = "654E5071906E3AA77B36C631DC4D739E", hash_generated_field = "818136B22260098E65F6ED2716C3D72D")

    private NativePluralRules mPluralRule;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.272 -0500", hash_original_field = "EC831B49FC8A431DBFEE3F5043766966", hash_generated_field = "D59F4BA3BF864567D7F711BF240A9A65")
    
    private CompatibilityInfo mCompatibilityInfo;

    /**
     * Create a new Resources object on top of an existing set of assets in an
     * AssetManager.
     * 
     * @param assets Previously created AssetManager. 
     * @param metrics Current display metrics to consider when 
     *                selecting/computing resource values.
     * @param config Desired device configuration to consider when 
     *               selecting/computing resource values (optional).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.297 -0500", hash_original_method = "A1A5E1FE4CAABF0AED8ED513B68BEBB1", hash_generated_method = "19A8799E1FA0C65A24990C8EC07E917D")
    
public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config) {
        this(assets, metrics, config, (CompatibilityInfo) null);
    }
    
    public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config, CompatibilityInfo compInfo){
		//addTaint(assets.getTaint());
		mAssets = assets;  //Preserved
		//addTaint(compInfo.getTaint());
		mCompatibilityInfo = compInfo;  //Preserved
		/*
		mAssets = assets;
		mMetrics.setToDefaults();
		mCompatibilityInfo = compInfo;
		updateConfiguration(config, metrics);
		assets.ensureStringBlocks();
		*/
	}
    
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    public Resources() {
	    mAssets = null;
	}
	
	@DSComment("Accessing App Resource")
    @DSSpec(DSCat.APP_RESOURCE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final String getString(int resId) {
		String str = new String();
        str.addTaint(resId);
        return str;
	}
	
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final CharSequence getText(int resId) {
        String str = new String();
        str.addTaint(resId);
        return str;
	}
	 
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CharSequence getQuantityText(int id, int quantity){
		
		String str = new String();
		str.addTaint(id);
		str.addTaint(quantity);
		str.addTaint(getTaint());
		return str;
	}
	  
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private NativePluralRules getPluralRule(){
		// Original method
        synchronized (mSync) {
            if (mPluralRule == null) {
                mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
            }
            return mPluralRule;
        }
	}
	
	@DSComment("Accessing App Resource")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getString(int id, Object... formatArgs){
		String str = new String();
		str.addTaint(id);
		//str.addTaint(formatArgs[0]);
		return str;
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getQuantityString(int id, int quantity, Object... formatArgs){
    	String str = new String();
		str.addTaint(id);
		str.addTaint(quantity);
		str.addTaint(getTaint());
		return str;
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getQuantityString(int id, int quantity){
    	String str = new String();
		str.addTaint(id);
		str.addTaint(quantity);
		str.addTaint(getTaint());
		return str;
	}
    
	@DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CharSequence getText(int id, CharSequence def){
    	String str = new String();
		str.addTaint(id);
		str.addTaint(def.getTaint());
		str.addTaint(getTaint());
		return str;
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CharSequence[] getTextArray(int id){
		// Original method
		/*
		{
        CharSequence[] res = mAssets.getResourceTextArray(id);
        if (res != null) {
            return res;
        }
        throw new NotFoundException("Text array resource ID #0x"
                                    + Integer.toHexString(id));
    }
		*/
		CharSequence[] obj = new CharSequence[1];
        obj.addTaint(id);
        obj.addTaint(getTaint());
        return obj;
	}
    
	@DSComment("Accessing App Resource")
    @DSSpec(DSCat.APP_RESOURCE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String[] getStringArray(int id){
		// Original method
		/*
		{
        String[] res = mAssets.getResourceStringArray(id);
        if (res != null) {
            return res;
        }
        throw new NotFoundException("String array resource ID #0x"
                                    + Integer.toHexString(id));
    }
		*/
		
        String[] str = new String[10];
        str.addTaint(id);
        str.addTaint(getTaint());
        return str;
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int[] getIntArray(int id){
		// Original method
		/*
		{
        int[] res = mAssets.getArrayIntResource(id);
        if (res != null) {
            return res;
        }
        throw new NotFoundException("Int array resource ID #0x"
                                    + Integer.toHexString(id));
    }
		*/
        int[] obj = new int[10];
        obj.addTaint(id);
        obj.addTaint(getTaint());
		return obj;
	}
    
	@DSComment("seemed harmless")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public TypedArray obtainTypedArray(int id){
		// Original method
		/*
		{
        int len = mAssets.getArraySize(id);
        if (len < 0) {
            throw new NotFoundException("Array resource ID #0x"
                                        + Integer.toHexString(id));
        }
        TypedArray array = getCachedStyledAttributes(len);
        array.mLength = mAssets.retrieveArray(id, array.mData);
        array.mIndices[0] = 0;
        return array;
    }
		*/
        TypedArray arr = new TypedArray(DSOnlyType.DONTCARE);
        arr.addTaint(id);
        arr.addTaint(getTaint());
		return arr;

	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getDimension(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_DIMENSION) {
                return TypedValue.complexToDimension(value.data, mMetrics);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}
    
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDimensionPixelOffset(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_DIMENSION) {
                return TypedValue.complexToDimensionPixelOffset(
                        value.data, mMetrics);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDimensionPixelSize(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_DIMENSION) {
                return TypedValue.complexToDimensionPixelSize(
                        value.data, mMetrics);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}
    
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getFraction(int id, int base, int pbase){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_FRACTION) {
                return TypedValue.complexToFraction(value.data, base, pbase);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Drawable getDrawable(int id){
        return loadDrawable(null, id);
	}
    
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Drawable getDrawableForDensity(int id, int density){
		// Original method
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValueForDensity(id, density, value, true);
            if (value.density > 0 && value.density != TypedValue.DENSITY_NONE) {
                if (value.density == density) {
                    value.density = DisplayMetrics.DENSITY_DEVICE;
                } else {
                    value.density = (value.density * DisplayMetrics.DENSITY_DEVICE) / density;
                }
            }
            return loadDrawable(value, id);
        }
	}
    
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Movie getMovie(int id){
		// Original method
        InputStream is = openRawResource(id);
        Movie movie = Movie.decodeStream(is);
        try {
            is.close();
        }
        catch (java.io.IOException e) {
        }
        return movie;
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getColor(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT) {
                return value.data;
            } else if (value.type == TypedValue.TYPE_STRING) {
                ColorStateList csl = loadColorStateList(mTmpValue, id);
                return csl.getDefaultColor();
            }
            throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}
    
	@DSComment("ColorSttatList is not too significant")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public ColorStateList getColorStateList(int id){
		// Original method
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            return loadColorStateList(value, id);
        }
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean getBoolean(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT) {
                return value.data != 0;
            }
            throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return toTaintBoolean(id + getTaintInt());
	}
    
	@DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getInteger(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT) {
                return value.data;
            }
            throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}
    
	@DSComment("seemed harmless")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public XmlResourceParser getLayout(int id){
		// Original method
        return loadXmlResourceParser(id, "layout");
	}
    
	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public XmlResourceParser getAnimation(int id){
		// Original method
        return loadXmlResourceParser(id, "anim");
	}
    
	@DSComment("seemed harmless")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public XmlResourceParser getXml(int id){
		// Original method
        return loadXmlResourceParser(id, "xml");
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    public InputStream openRawResource(int id){
		// Original method
        synchronized (mTmpValue) {
            return openRawResource(id, mTmpValue);
        }
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    public InputStream openRawResource(int id, TypedValue value){
		// Original method
        getValue(id, value, true);
        try {
            return mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    AssetManager.ACCESS_STREAMING);
        } catch (Exception e) {
            NotFoundException rnf = new NotFoundException("File " + value.string.toString() +
                    " from drawable resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(e);
            throw rnf;
        }
	}
    
	@DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    public AssetFileDescriptor openRawResourceFd(int id){
		// Original method
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            try {
                return mAssets.openNonAssetFd(
                    value.assetCookie, value.string.toString());
            } catch (Exception e) {
                NotFoundException rnf = new NotFoundException(
                    "File " + value.string.toString()
                    + " from drawable resource ID #0x"
                    + Integer.toHexString(id));
                rnf.initCause(e);
                throw rnf;
            }
        }
	}
    
	@DSComment("Resource is a data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public void getValue(int id, TypedValue outValue, boolean resolveRefs){
        boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        if (found) {
            return;
        }
        throw new NotFoundException("Resource ID #0x"
                                    + Integer.toHexString(id));
	}
    
	public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs){
		// Original method
        boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        if (found) {
            return;
        }
        throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
	}
    
	public void getValue(String name, TypedValue outValue, boolean resolveRefs){
		// Original method
		/*
		{
        int id = getIdentifier(name, "string", null);
        if (id != 0) {
            getValue(id, outValue, resolveRefs);
            return;
        }
        throw new NotFoundException("String resource name " + name);
    }
		*/
		//Return nothing
	}
    
    public final Theme newTheme(){
		// Original method
        return new Theme();
	}
    
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs){
		// Original method
        int len = attrs.length;
        TypedArray array = getCachedStyledAttributes(len);
        XmlBlock.Parser parser = (XmlBlock.Parser)set;
        mAssets.retrieveAttributes(parser.mParseState, attrs,
                array.mData, array.mIndices);
        array.mRsrcs = attrs;
        array.mXml = parser;
        return array;
	}
    
    @DSComment("update system configuration")
    @DSSpec(DSCat.SYSTEM)
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics){
		// Original method
        updateConfiguration(config, metrics, null);
	}
    
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics, CompatibilityInfo compat){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void clearDrawableCache(
            LongSparseArray<WeakReference<ConstantState>> cache,
            int configChanges){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("seemed harmless")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public DisplayMetrics getDisplayMetrics(){
		return mMetrics;
		// Original method
		/*
		{
        if (DEBUG_CONFIG) Slog.v(TAG, "Returning DisplayMetrics: " + mMetrics.widthPixels
                + "x" + mMetrics.heightPixels + " " + mMetrics.density);
        return mMetrics;
    }
		*/
	}

    /**
     * Return the current configuration that is in effect for this resource 
     * object.  The returned object should be treated as read-only.
     * 
     * @return The resource's current configuration. 
     */
    @DSComment("System resources")
    @DSSpec(DSCat.SYSTEM)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.440 -0500", hash_original_method = "11CE3ED49D23B920A1DF6398548CD42B", hash_generated_method = "EE9863339B6D3DC9E206378BA342F32D")
    
public Configuration getConfiguration() {
        return mConfiguration;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CompatibilityInfo getCompatibilityInfo(){
		// Original method
        return mCompatibilityInfo != null ? mCompatibilityInfo
                : CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
	}
    
    public void setCompatibilityInfo(CompatibilityInfo ci){
		//addTaint(ci.getTaint());
		mCompatibilityInfo = ci;  //Preserved
		// Original method
		/*
		{
        mCompatibilityInfo = ci;
        updateConfiguration(mConfiguration, mMetrics);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getIdentifier(String name, String defType, String defPackage){
		// Original method
		/*
		{
        try {
            return Integer.parseInt(name);
        } catch (Exception e) {
        }
        return mAssets.getResourceIdentifier(name, defType, defPackage);
    }
		*/
		return 0;
	}
    
    @DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getResourceName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourceName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}
    
    @DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getResourcePackageName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourcePackageName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}
    
    @DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getResourceTypeName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourceTypeName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}
    
    public static class NotFoundException extends RuntimeException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.291 -0500", hash_original_method = "16646BE2B605A836CC81C1207D23548C", hash_generated_method = "6D902CC3B723F053FD21F8F6EC56EB38")
        
public NotFoundException() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.294 -0500", hash_original_method = "4E6E00F1F6EDF0AE5B66F6F35CDBCBD1", hash_generated_method = "CC1F9D086F58D5BFF08FBA17AA171A6F")
        
public NotFoundException(String name) {
            super(name);
        }
        
    }
    
    public final class Theme {
        private final AssetManager mAssets = null;
        private final int mTheme = 0;
        
        Theme(){
			/*
			mAssets = Resources.this.mAssets;
			mTheme = mAssets.createTheme();
			*/
		}
        
        public void applyStyle(int resid, boolean force){
			// Original method
			/*
			{
            AssetManager.applyThemeStyle(mTheme, resid, force);
        }
			*/
			//Return nothing
		}
        
        public void setTo(Theme other){
			// Original method
			/*
			{
            AssetManager.copyTheme(mTheme, other.mTheme);
        }
			*/
			//Return nothing
		}
        
        @DSComment("data structure class")
        @DSSafe(DSCat.DATA_STRUCTURE)
        public TypedArray obtainStyledAttributes(int[] attrs){
			// Original method
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    array.mData, array.mIndices);
            return array;
		}
        
        public TypedArray obtainStyledAttributes(int resid, int[] attrs){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
            TypedArray typeArray = new TypedArray(DSOnlyType.DONTCARE);
            typeArray.addTaint(resid);
            typeArray.addTaint(attrs[0]);
            typeArray.addTaint(attrs.getTaint());
            typeArray.addTaint(getTaint());
            return typeArray;
		}
        
        public TypedArray obtainStyledAttributes(AttributeSet set,
                int[] attrs, int defStyleAttr, int defStyleRes){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
            TypedArray typeArray = new TypedArray(DSOnlyType.DONTCARE);
            typeArray.addTaint(attrs[0]);
            typeArray.addTaint(attrs.getTaint());
            typeArray.addTaint(getTaint());
            return typeArray;
		}
        
        @DSComment("data structure class")
        @DSSafe(DSCat.DATA_STRUCTURE)
        public boolean resolveAttribute(int resid, TypedValue outValue,
                boolean resolveRefs){
			// Original method
			/*
			{
            boolean got = mAssets.getThemeValue(mTheme, resid, outValue, resolveRefs);
            if (false) {
                System.out.println(
                    "resolveAttribute #" + Integer.toHexString(resid)
                    + " got=" + got + ", type=0x" + Integer.toHexString(outValue.type)
                    + ", data=0x" + Integer.toHexString(outValue.data));
            }
            return got;
        }
			*/
			return false;
		}
        
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        public void dump(int priority, String tag, String prefix){
			// Original method
			/*
			{
            AssetManager.dumpTheme(mTheme, priority, tag, prefix);
        }
			*/
			//Return nothing
		}
        
        protected void finalize(){
			// Original method
			/*
			{
            super.finalize();
            mAssets.releaseTheme(mTheme);
        }
			*/
			//Return nothing
		}
        
    }
    
    @DSComment("Resource is a data structure, getting system resource is spec")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getResourceEntryName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourceEntryName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}
    
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle){
		// Original method
		/*
		{
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }
            String nodeName = parser.getName();
            if (nodeName.equals("extra")) {
                parseBundleExtra("extra", parser, outBundle);
                XmlUtils.skipCurrentTag(parser);
            } else {
                XmlUtils.skipCurrentTag(parser);
            }
        }        
    }
		*/
		//Return nothing
	}
    
    public void parseBundleExtra(String tagName, AttributeSet attrs,
            Bundle outBundle){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    /**
     * Retrieve underlying AssetManager storage for these resources.
     */
    @DSComment("not sensitive, delagated to Resources")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:06.464 -0500", hash_original_method = "B655DEE21C3816C25C0AC2AC9EDD1950", hash_generated_method = "8214F1367B54F9887420B22D5E3D96C5")
    
public final AssetManager getAssets() {
        return mAssets;
    }
    
    public final void flushLayoutCache(){
		// Original method
		/*
		{
        synchronized (mCachedXmlBlockIds) {
            final int num = mCachedXmlBlockIds.length;
            for (int i=0; i<num; i++) {
                mCachedXmlBlockIds[i] = -0;
                XmlBlock oldBlock = mCachedXmlBlocks[i];
                if (oldBlock != null) {
                    oldBlock.close();
                }
                mCachedXmlBlocks[i] = null;
            }
        }
    }
		*/
		//Return nothing
	}
    
    public final void startPreloading(){
		// Original method
		/*
		{
        synchronized (mSync) {
            if (mPreloaded) {
                throw new IllegalStateException("Resources already preloaded");
            }
            mPreloaded = true;
            mPreloading = true;
        }
    }
		*/
		//Return nothing
	}
    
    public final void finishPreloading(){
		// Original method
		/*
		{
        if (mPreloading) {
            mPreloading = false;
            flushLayoutCache();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    Drawable loadDrawable(TypedValue value, int id){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
        Drawable ret = new ColorDrawable();
        ret.addTaint(getTaint());
        return ret;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private Drawable getCachedDrawable(
            LongSparseArray<WeakReference<ConstantState>> drawableCache,
            long key){
		// Original method
        synchronized (mTmpValue) {
            WeakReference<Drawable.ConstantState> wr = drawableCache.get(key);
            if (wr != null) {   
                Drawable.ConstantState entry = wr.get();
                if (entry != null) {
                    return entry.newDrawable(this);
                }
                else {  
                    drawableCache.delete(key);
                }
            }
            Drawable ret = new ColorDrawable();
            ret.addTaint(key);
            ret.addTaint(drawableCache.getTaint());
            ret.addTaint(getTaint());
            return ret;
        }
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    ColorStateList loadColorStateList(TypedValue value, int id){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
        ColorStateList stateList = ColorStateList.valueOf(getTaintInt());
        addTaint(value.getTaint());
        addTaint(id);
        stateList.addTaint(getTaint());
		return stateList;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private ColorStateList getCachedColorStateList(int key){
		// Original method
        synchronized (mTmpValue) {
            WeakReference<ColorStateList> wr = mColorStateListCache.get(key);
            if (wr != null) {   
                ColorStateList entry = wr.get();
                if (entry != null) {
                    return entry;
                }
                else {  
                    mColorStateListCache.delete(key);
                }
            }
        }
		return null;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    XmlResourceParser loadXmlResourceParser(int id, String type){
		// Original method
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_STRING) {
                return loadXmlResourceParser(value.string.toString(), id,
                        value.assetCookie, type);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
   /*     
        XmlResourceParser parser = new XmlResourceParser(); 
        obj.addTaint(id);
        obj.addTaint(type);
        obj.addTaint(getTaint());
		return obj;
    */

		//return null;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    XmlResourceParser loadXmlResourceParser(String file, int id,
            int assetCookie, String type){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
        return loadXmlResourceParser(file, id, assetCookie, type);
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private TypedArray getCachedStyledAttributes(int len){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
        TypedArray arr = new TypedArray(DSOnlyType.DONTCARE);
        arr.addTaint(len);
        arr.addTaint(getTaint());
		return arr;
	}
}

