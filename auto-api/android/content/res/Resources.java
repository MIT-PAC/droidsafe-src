package android.content.res;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;

import libcore.icu.NativePluralRules;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.pm.ActivityInfo;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;

import com.android.internal.util.XmlUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class Resources {
    static final String TAG = "Resources";
    private static final boolean DEBUG_LOAD = false;
    private static final boolean DEBUG_CONFIG = false;
    private static final boolean DEBUG_ATTRIBUTES_CACHE = false;
    private static final boolean TRACE_FOR_PRELOAD = false;
    private static final boolean TRACE_FOR_MISS_PRELOAD = false;
    private static final int ID_OTHER = 0x01000004;
    private static final Object mSync = new Object();
    static Resources mSystem = null;
    private static final LongSparseArray<Drawable.ConstantState> sPreloadedDrawables
            = new LongSparseArray<Drawable.ConstantState>();
    private static final SparseArray<ColorStateList> mPreloadedColorStateLists
            = new SparseArray<ColorStateList>();
    private static final LongSparseArray<Drawable.ConstantState> sPreloadedColorDrawables
            = new LongSparseArray<Drawable.ConstantState>();
    private static boolean mPreloaded;
    final TypedValue mTmpValue = new TypedValue();
    final Configuration mTmpConfig = new Configuration();
    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    private final SparseArray<WeakReference<ColorStateList> > mColorStateListCache
            = new SparseArray<WeakReference<ColorStateList> >();
    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mColorDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    private boolean mPreloading;
    TypedArray mCachedStyledAttributes = null;
    RuntimeException mLastRetrievedAttrs = null;
    private int mLastCachedXmlBlockIndex = -1;
    private final int[] mCachedXmlBlockIds = { 0, 0, 0, 0 };
    private final XmlBlock[] mCachedXmlBlocks = new XmlBlock[4];
    final AssetManager mAssets;
    private final Configuration mConfiguration = new Configuration();
    final DisplayMetrics mMetrics = new DisplayMetrics();
    private NativePluralRules mPluralRule;
    private CompatibilityInfo mCompatibilityInfo;
    private static final LongSparseArray<Object> EMPTY_ARRAY = new LongSparseArray<Object>(0) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.462 -0400", hash_original_method = "EC6F1588621E6A8924E2C6C8C57E5DB6", hash_generated_method = "C2BF4A57CD29A39539939F6A8869847E")
        @DSModeled(DSC.SAFE)
        @Override
        public void put(long k, Object o) {
            dsTaint.addTaint(o.dsTaint);
            dsTaint.addTaint(k);
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.462 -0400", hash_original_method = "2174303CAFCCF4D833BEBE6A819B3E43", hash_generated_method = "CAE92B99BDBFC99A4BF9F63D39F8EBEA")
        @DSModeled(DSC.SAFE)
        @Override
        public void append(long k, Object o) {
            dsTaint.addTaint(o.dsTaint);
            dsTaint.addTaint(k);
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.462 -0400", hash_original_method = "A1A5E1FE4CAABF0AED8ED513B68BEBB1", hash_generated_method = "2806F67E803AC0D1A4CD3395D54C83A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config) {
        this(assets, metrics, config, (CompatibilityInfo) null);
        dsTaint.addTaint(assets.dsTaint);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.462 -0400", hash_original_method = "2B8ADFD0988160303F3DB857A23CF093", hash_generated_method = "A258EEF7182AF3BD17F117151A4D124C")
    @DSModeled(DSC.SAFE)
    public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config, CompatibilityInfo compInfo) {
        dsTaint.addTaint(assets.dsTaint);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(compInfo.dsTaint);
        mMetrics.setToDefaults();
        updateConfiguration(config, metrics);
        assets.ensureStringBlocks();
        
        mAssets = assets;
        // ---------- Original Method ----------
        //mAssets = assets;
        //mMetrics.setToDefaults();
        //mCompatibilityInfo = compInfo;
        //updateConfiguration(config, metrics);
        //assets.ensureStringBlocks();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.463 -0400", hash_original_method = "647BD0141CFE00480058A00B761B8E30", hash_generated_method = "B15756CA5AF5B75C612CD153AD618575")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Resources() {
        mAssets = AssetManager.getSystem();
        mConfiguration.setToDefaults();
        mMetrics.setToDefaults();
        updateConfiguration(null, null);
        mAssets.ensureStringBlocks();
        mCompatibilityInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        // ---------- Original Method ----------
        //mAssets = AssetManager.getSystem();
        //mConfiguration.setToDefaults();
        //mMetrics.setToDefaults();
        //updateConfiguration(null, null);
        //mAssets.ensureStringBlocks();
        //mCompatibilityInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.463 -0400", hash_original_method = "E983800DD71556CC41FFC53C682788A0", hash_generated_method = "1EB12FBF8B801B5FF60AF5810E437915")
    @SuppressWarnings("unchecked")
    private static <T> LongSparseArray<T> emptySparseArray() {
        return (LongSparseArray<T>) EMPTY_ARRAY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.463 -0400", hash_original_method = "BFCB7F89C98094007B1D804E9A54D491", hash_generated_method = "57A6013BFCE4F22C287E5755860D50F0")
    public static int selectDefaultTheme(int curTheme, int targetSdkVersion) {
        return selectSystemTheme(curTheme, targetSdkVersion,
                com.android.internal.R.style.Theme,
                com.android.internal.R.style.Theme_Holo,
                com.android.internal.R.style.Theme_DeviceDefault);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.463 -0400", hash_original_method = "2EBA1565156D26B3292FB8B1E02C04ED", hash_generated_method = "D3958EC81A56D6CFD902683BED19B343")
    public static int selectSystemTheme(int curTheme, int targetSdkVersion,
            int orig, int holo, int deviceDefault) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.463 -0400", hash_original_method = "B1853ECFBDA972F3A5CD04731581AE0B", hash_generated_method = "BB02ACB3D2DDF170C0AAB280EB27A84B")
    public static Resources getSystem() {
        synchronized (mSync) {
            Resources ret = mSystem;
            if (ret == null) {
                ret = new Resources();
                mSystem = ret;
            }
            return ret;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.463 -0400", hash_original_method = "ACC5D7202FC5E62E31E1054DCF0E5FCD", hash_generated_method = "C8DEFC25161C71DFCC1B928E583F3523")
    @DSModeled(DSC.SAFE)
    public CharSequence getText(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        CharSequence res;
        res = mAssets.getResourceText(id);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //CharSequence res = mAssets.getResourceText(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("String resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.464 -0400", hash_original_method = "78A3DFDF860E06736217D448EF07FADF", hash_generated_method = "01A68467E2D6E6C268EA3228FC8CE9D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getQuantityText(int id, int quantity) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(quantity);
        NativePluralRules rule;
        rule = getPluralRule();
        CharSequence res;
        res = mAssets.getResourceBagText(id,
                attrForQuantityCode(rule.quantityForInt(quantity)));
        res = mAssets.getResourceBagText(id, ID_OTHER);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Plural resource ID #0x" + Integer.toHexString(id)
                + " quantity=" + quantity
                + " item=" + stringForQuantityCode(rule.quantityForInt(quantity)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //NativePluralRules rule = getPluralRule();
        //CharSequence res = mAssets.getResourceBagText(id,
                //attrForQuantityCode(rule.quantityForInt(quantity)));
        //if (res != null) {
            //return res;
        //}
        //res = mAssets.getResourceBagText(id, ID_OTHER);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("Plural resource ID #0x" + Integer.toHexString(id)
                //+ " quantity=" + quantity
                //+ " item=" + stringForQuantityCode(rule.quantityForInt(quantity)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.464 -0400", hash_original_method = "1BFA20E87FBD429BB566BA0632D0EE62", hash_generated_method = "894C6F47B6171D4625D701854234CC4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NativePluralRules getPluralRule() {
        {
            {
                mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
            } //End block
        } //End block
        return (NativePluralRules)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPluralRule == null) {
                //mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
            //}
            //return mPluralRule;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.464 -0400", hash_original_method = "1DBA7AD2CCE275D225D282972488DDB5", hash_generated_method = "0077035EAE66CCC242674900CD1CEE0B")
    private static int attrForQuantityCode(int quantityCode) {
        switch (quantityCode) {
            case NativePluralRules.ZERO: return 0x01000005;
            case NativePluralRules.ONE:  return 0x01000006;
            case NativePluralRules.TWO:  return 0x01000007;
            case NativePluralRules.FEW:  return 0x01000008;
            case NativePluralRules.MANY: return 0x01000009;
            default:                     return ID_OTHER;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.464 -0400", hash_original_method = "80C3C76E79048FBEB69FEA24DD6C6EC2", hash_generated_method = "791746C92979DFA2F092B84C026745F7")
    private static String stringForQuantityCode(int quantityCode) {
        switch (quantityCode) {
            case NativePluralRules.ZERO: return "zero";
            case NativePluralRules.ONE:  return "one";
            case NativePluralRules.TWO:  return "two";
            case NativePluralRules.FEW:  return "few";
            case NativePluralRules.MANY: return "many";
            default:                     return "other";
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.465 -0400", hash_original_method = "537EFC002B8A40B3B7F76596758B9963", hash_generated_method = "578BF022071C2EE79D57EF7C3C6EE61A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        CharSequence res;
        res = getText(id);
        {
            String varC80A1DDFE3E52DD547813302DB81FF7B_349082954 = (res.toString());
        } //End block
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //CharSequence res = getText(id);
        //if (res != null) {
            //return res.toString();
        //}
        //throw new NotFoundException("String resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.465 -0400", hash_original_method = "2EEC36CFDBF61FC5501B8B9376C5F95E", hash_generated_method = "3AFCA062F271085D057BC14F1929C63A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(formatArgs[0].dsTaint);
        String raw;
        raw = getString(id);
        String var86E36E1F578ADCC1CCCFE04E2F22FF68_1436858325 = (String.format(mConfiguration.locale, raw, formatArgs));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String raw = getString(id);
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.465 -0400", hash_original_method = "3050F7A6F3C08BB33AB97951F94A1A35", hash_generated_method = "0C5682063130041D640D35F8347AB63C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(quantity);
        dsTaint.addTaint(formatArgs[0].dsTaint);
        String raw;
        raw = getQuantityText(id, quantity).toString();
        String var86E36E1F578ADCC1CCCFE04E2F22FF68_1108620769 = (String.format(mConfiguration.locale, raw, formatArgs));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String raw = getQuantityText(id, quantity).toString();
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.465 -0400", hash_original_method = "81877842C4E2FEF0D9FCD2095374BD66", hash_generated_method = "8B8DE4948C99FBC353CAD49951BC8D81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQuantityString(int id, int quantity) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(quantity);
        String varBB2640B589517EDA6683FD4E4C01FC4F_769484417 = (getQuantityText(id, quantity).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getQuantityText(id, quantity).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.465 -0400", hash_original_method = "9E76804CDFB0982D016B6CE6163D7455", hash_generated_method = "16D036F04A27F9BB06324AA20BA771CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getText(int id, CharSequence def) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(def);
        CharSequence res;
        res = mAssets.getResourceText(id);
        res = null;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //CharSequence res = id != 0 ? mAssets.getResourceText(id) : null;
        //return res != null ? res : def;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.466 -0400", hash_original_method = "2FECA5C28D9DC41170E2F1E5700277A0", hash_generated_method = "CCCDB181F28E6E781206F52529C1FA1F")
    @DSModeled(DSC.SAFE)
    public CharSequence[] getTextArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        CharSequence[] res;
        res = mAssets.getResourceTextArray(id);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Text array resource ID #0x"
                                    + Integer.toHexString(id));
        CharSequence[] retVal = new CharSequence[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //CharSequence[] res = mAssets.getResourceTextArray(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("Text array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.466 -0400", hash_original_method = "426431DC420CF2DD39FFAF8B295D8654", hash_generated_method = "F582C12DBD8880F3D141B6B4C81723AB")
    @DSModeled(DSC.SAFE)
    public String[] getStringArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        String[] res;
        res = mAssets.getResourceStringArray(id);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("String array resource ID #0x"
                                    + Integer.toHexString(id));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //String[] res = mAssets.getResourceStringArray(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("String array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.466 -0400", hash_original_method = "65AEFB7747626FD934E6275803D2C392", hash_generated_method = "9060EFB73D775EAEB1C1E3A680980422")
    @DSModeled(DSC.SAFE)
    public int[] getIntArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        int[] res;
        res = mAssets.getArrayIntResource(id);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Int array resource ID #0x"
                                    + Integer.toHexString(id));
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //int[] res = mAssets.getArrayIntResource(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("Int array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.466 -0400", hash_original_method = "8E5AB34336560F1D8FA12EC65FB34D2E", hash_generated_method = "98271E65910B47B50D7B24A639F35D9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypedArray obtainTypedArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        int len;
        len = mAssets.getArraySize(id);
        {
        	if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Array resource ID #0x"
                                        + Integer.toHexString(id));
        } //End block
        TypedArray array;
        array = getCachedStyledAttributes(len);
        array.mLength = mAssets.retrieveArray(id, array.mData);
        array.mIndices[0] = 0;
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int len = mAssets.getArraySize(id);
        //if (len < 0) {
            //throw new NotFoundException("Array resource ID #0x"
                                        //+ Integer.toHexString(id));
        //}
        //TypedArray array = getCachedStyledAttributes(len);
        //array.mLength = mAssets.retrieveArray(id, array.mData);
        //array.mIndices[0] = 0;
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.467 -0400", hash_original_method = "179671F1A37C23E822373A76E19D42EA", hash_generated_method = "DDBF9DD2C41BB96781FFDE3ECFEB5D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getDimension(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                float var3D1EF52544C26367510F308FBFEC9AF2_305092230 = (TypedValue.complexToDimension(value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type == TypedValue.TYPE_DIMENSION) {
                //return TypedValue.complexToDimension(value.data, mMetrics);
            //}
            //throw new NotFoundException(
                    //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.467 -0400", hash_original_method = "1833FD2ED6DCA9CF6DFDBF7D9BC0478B", hash_generated_method = "BC6A70A925B1ED655B67D50216303815")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                int varC10E6C7CE4C18B2E8240388CE0B9D4D5_2050150612 = (TypedValue.complexToDimensionPixelOffset(
                        value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type == TypedValue.TYPE_DIMENSION) {
                //return TypedValue.complexToDimensionPixelOffset(
                        //value.data, mMetrics);
            //}
            //throw new NotFoundException(
                    //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.467 -0400", hash_original_method = "E2B2A30088D0238C29DEA7CD0218F3E5", hash_generated_method = "377B366791DCFA52D245974C2B04BD3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelSize(int id) throws NotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                int var618929EFC759B1CAECEF2B8755B3C586_2035364585 = (TypedValue.complexToDimensionPixelSize(
                        value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type == TypedValue.TYPE_DIMENSION) {
                //return TypedValue.complexToDimensionPixelSize(
                        //value.data, mMetrics);
            //}
            //throw new NotFoundException(
                    //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.467 -0400", hash_original_method = "A2DCBF1A3DEF525CC233A65EC473B403", hash_generated_method = "24E9FBBA5BF458B6FAEF6F77B33DC5D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFraction(int id, int base, int pbase) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(base);
        dsTaint.addTaint(pbase);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                float var32E1DB9737EBC4A230505D9C45C6217C_680733571 = (TypedValue.complexToFraction(value.data, base, pbase));
            } //End block
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type == TypedValue.TYPE_FRACTION) {
                //return TypedValue.complexToFraction(value.data, base, pbase);
            //}
            //throw new NotFoundException(
                    //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.468 -0400", hash_original_method = "40531A8693FC775C03E22F5835EB733B", hash_generated_method = "5FEF60C18A4A31E441D3F630DB563281")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getDrawable(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            Drawable var484E9D75953D8C3E9E8C8035FF58E738_1546150053 = (loadDrawable(value, id));
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadDrawable(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.468 -0400", hash_original_method = "D08D33B833687D530F432098EC5CCB38", hash_generated_method = "3DDBCED49BA2D53AD6B7C0DC1F612140")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(density);
        {
            TypedValue value;
            value = mTmpValue;
            getValueForDensity(id, density, value, true);
            {
                {
                    value.density = DisplayMetrics.DENSITY_DEVICE;
                } //End block
                {
                    value.density = (value.density * DisplayMetrics.DENSITY_DEVICE) / density;
                } //End block
            } //End block
            Drawable var484E9D75953D8C3E9E8C8035FF58E738_1578428083 = (loadDrawable(value, id));
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValueForDensity(id, density, value, true);
            //if (value.density > 0 && value.density != TypedValue.DENSITY_NONE) {
                //if (value.density == density) {
                    //value.density = DisplayMetrics.DENSITY_DEVICE;
                //} else {
                    //value.density = (value.density * DisplayMetrics.DENSITY_DEVICE) / density;
                //}
            //}
            //return loadDrawable(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.468 -0400", hash_original_method = "973C0EDB6E14C8355746DA3A02A0EBD1", hash_generated_method = "87946754634B89FC17703B55155A61C9")
    @DSModeled(DSC.SAFE)
    public Movie getMovie(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        InputStream is;
        is = openRawResource(id);
        Movie movie;
        movie = Movie.decodeStream(is);
        try 
        {
            is.close();
        } //End block
        catch (java.io.IOException e)
        { }
        return (Movie)dsTaint.getTaint();
        // ---------- Original Method ----------
        //InputStream is = openRawResource(id);
        //Movie movie = Movie.decodeStream(is);
        //try {
            //is.close();
        //}
        //catch (java.io.IOException e) {
        //}
        //return movie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.469 -0400", hash_original_method = "CDFC75613D2F871DC3B09D1CE60F98A4", hash_generated_method = "5578DCD343DB1FA5638F57033A3BCD0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColor(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                ColorStateList csl;
                csl = loadColorStateList(mTmpValue, id);
                int var0BE21B049075D2C5C0B5387A1C4FC3D4_1564529013 = (csl.getDefaultColor());
            } //End block
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type >= TypedValue.TYPE_FIRST_INT
                //&& value.type <= TypedValue.TYPE_LAST_INT) {
                //return value.data;
            //} else if (value.type == TypedValue.TYPE_STRING) {
                //ColorStateList csl = loadColorStateList(mTmpValue, id);
                //return csl.getDefaultColor();
            //}
            //throw new NotFoundException(
                //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.469 -0400", hash_original_method = "F237EF4FA0AE2D448FCC64592DABDD8D", hash_generated_method = "91B178B12C867EB95283CB76F27561FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            ColorStateList var2DD4B07A29C83DB18C241B731CACA3D6_11136305 = (loadColorStateList(value, id));
        } //End block
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadColorStateList(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.469 -0400", hash_original_method = "5C68CA666BA42061546BF98D8883861D", hash_generated_method = "71CE0F252F3AA0EC65F82DD19C6C2141")
    @DSModeled(DSC.SAFE)
    public boolean getBoolean(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type >= TypedValue.TYPE_FIRST_INT
                //&& value.type <= TypedValue.TYPE_LAST_INT) {
                //return value.data != 0;
            //}
            //throw new NotFoundException(
                //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.469 -0400", hash_original_method = "CB2B32F0600F2299579C79C7526A8896", hash_generated_method = "699C3CDE6F8A4BBE969EACB935F9AB60")
    @DSModeled(DSC.SAFE)
    public int getInteger(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type >= TypedValue.TYPE_FIRST_INT
                //&& value.type <= TypedValue.TYPE_LAST_INT) {
                //return value.data;
            //}
            //throw new NotFoundException(
                //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.469 -0400", hash_original_method = "53A788F1DE83214BAFCB022ED9363AAC", hash_generated_method = "A531C8529F5F3EFA00099AF8224CDD03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        XmlResourceParser var8BCBF72B8FED622ABE8608E776A438DE_1068109812 = (loadXmlResourceParser(id, "layout"));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "layout");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.470 -0400", hash_original_method = "C3417F93CB7498AF5B43E94B98075C78", hash_generated_method = "387E92D72D91A8B7E755D2281D238750")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        XmlResourceParser var4AAEDEA00858286EE3ED8DFDF6003A75_1897627931 = (loadXmlResourceParser(id, "anim"));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "anim");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.470 -0400", hash_original_method = "66568C58C76DE1C95FED15C8056E4335", hash_generated_method = "912BAEE0B04E7BF8DAB3AB4957118A59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser getXml(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        XmlResourceParser var1C9ABC5B2AE2BBBA8F4FEFD6210129DF_115256472 = (loadXmlResourceParser(id, "xml"));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.470 -0400", hash_original_method = "2A38C8042909AD0B3921F8B41C50BFD0", hash_generated_method = "22EB731B465269E4A67048C2E19841FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream openRawResource(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            InputStream varFD96ECD68ABB190E248FDBF387C1A904_1892321048 = (openRawResource(id, mTmpValue));
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //return openRawResource(id, mTmpValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.470 -0400", hash_original_method = "2E256A4CBCC4636EC939F62266AB39BC", hash_generated_method = "E59060A4D8C08492E69E647E5A3DD1B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(value.dsTaint);
        getValue(id, value, true);
        try 
        {
            InputStream var481BB9AEE7CD808C6866F4641B64622B_693419505 = (mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    AssetManager.ACCESS_STREAMING));
        } //End block
        catch (Exception e)
        {
            NotFoundException rnf;
            rnf = new NotFoundException("File " + value.string.toString() +
                    " from drawable resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(e);
            throw rnf;
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //getValue(id, value, true);
        //try {
            //return mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    //AssetManager.ACCESS_STREAMING);
        //} catch (Exception e) {
            //NotFoundException rnf = new NotFoundException("File " + value.string.toString() +
                    //" from drawable resource ID #0x" + Integer.toHexString(id));
            //rnf.initCause(e);
            //throw rnf;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.471 -0400", hash_original_method = "7A496359623417DAF484E4884A244E4E", hash_generated_method = "5BC9784CF336CCD74F233333585B9C41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            try 
            {
                AssetFileDescriptor varCF85803C663599342E4C64C4DFBB0264_611812995 = (mAssets.openNonAssetFd(
                    value.assetCookie, value.string.toString()));
            } //End block
            catch (Exception e)
            {
                NotFoundException rnf;
                rnf = new NotFoundException(
                    "File " + value.string.toString()
                    + " from drawable resource ID #0x"
                    + Integer.toHexString(id));
                rnf.initCause(e);
                throw rnf;
            } //End block
        } //End block
        return (AssetFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //try {
                //return mAssets.openNonAssetFd(
                    //value.assetCookie, value.string.toString());
            //} catch (Exception e) {
                //NotFoundException rnf = new NotFoundException(
                    //"File " + value.string.toString()
                    //+ " from drawable resource ID #0x"
                    //+ Integer.toHexString(id));
                //rnf.initCause(e);
                //throw rnf;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.471 -0400", hash_original_method = "286538764BE9255E72B90D7B13646A2E", hash_generated_method = "4E524D3A0338B1900A462E1B1C849FAF")
    @DSModeled(DSC.SAFE)
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(resolveRefs);
        boolean found;
        found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        throw new NotFoundException("Resource ID #0x"
                                    + Integer.toHexString(id));
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.471 -0400", hash_original_method = "FF0649F49CF780958319F2862D12B017", hash_generated_method = "3B285AB69A217281E344757C80F3374A")
    @DSModeled(DSC.SAFE)
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(density);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(resolveRefs);
        boolean found;
        found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.471 -0400", hash_original_method = "A4F8C6B97749A99408C92371916352C6", hash_generated_method = "8DD4F08ADA55CFF5D8BD7DFA0A0A4B3F")
    @DSModeled(DSC.SAFE)
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(resolveRefs);
        int id;
        id = getIdentifier(name, "string", null);
        {
            getValue(id, outValue, resolveRefs);
        } //End block
        throw new NotFoundException("String resource name " + name);
        // ---------- Original Method ----------
        //int id = getIdentifier(name, "string", null);
        //if (id != 0) {
            //getValue(id, outValue, resolveRefs);
            //return;
        //}
        //throw new NotFoundException("String resource name " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.472 -0400", hash_original_method = "89EA817324C2BD92A04D61539A7DF9A0", hash_generated_method = "C80D8B5C7399D19556CB7F94265810E6")
    @DSModeled(DSC.SAFE)
    public final Theme newTheme() {
        return (Theme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Theme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.472 -0400", hash_original_method = "D166D2286995B941AEE6CFA36445D894", hash_generated_method = "978C12FE3F9B578A8EFA1EA3CB181F36")
    @DSModeled(DSC.SAFE)
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        dsTaint.addTaint(set.dsTaint);
        dsTaint.addTaint(attrs);
        int len;
        len = attrs.length;
        TypedArray array;
        array = getCachedStyledAttributes(len);
        XmlBlock.Parser parser;
        parser = (XmlBlock.Parser)set;
        mAssets.retrieveAttributes(parser.mParseState, attrs,
                array.mData, array.mIndices);
        array.mRsrcs = attrs;
        array.mXml = parser;
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int len = attrs.length;
        //TypedArray array = getCachedStyledAttributes(len);
        //XmlBlock.Parser parser = (XmlBlock.Parser)set;
        //mAssets.retrieveAttributes(parser.mParseState, attrs,
                //array.mData, array.mIndices);
        //array.mRsrcs = attrs;
        //array.mXml = parser;
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.472 -0400", hash_original_method = "FADFD61D7F3DC00CFE83DECA8FAB375D", hash_generated_method = "DBBE6E298880AB1A3A89B1CCA819B40E")
    @DSModeled(DSC.SAFE)
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        updateConfiguration(config, metrics, null);
        // ---------- Original Method ----------
        //updateConfiguration(config, metrics, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.473 -0400", hash_original_method = "FB9A4AAA762C456F245AEDCFD4C4194A", hash_generated_method = "0927CA77AC69E8A944C09A0CC063F7FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics, CompatibilityInfo compat) {
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(compat.dsTaint);
        {
            {
                mMetrics.setTo(metrics);
            } //End block
            {
                mCompatibilityInfo.applyToDisplayMetrics(mMetrics);
            } //End block
            int configChanges;
            configChanges = 0xfffffff;
            {
                mTmpConfig.setTo(config);
                {
                    mCompatibilityInfo.applyToConfiguration(mTmpConfig);
                } //End block
                {
                    mTmpConfig.locale = Locale.getDefault();
                } //End block
                configChanges = mConfiguration.updateFrom(mTmpConfig);
                configChanges = ActivityInfo.activityInfoConfigToNative(configChanges);
            } //End block
            {
                mConfiguration.locale = Locale.getDefault();
            } //End block
            mMetrics.scaledDensity = mMetrics.density * mConfiguration.fontScale;
            String locale;
            locale = null;
            {
                locale = mConfiguration.locale.getLanguage();
                {
                    boolean varC89ED4BF7AB2BEFA099B67803FBEFA7B_711385099 = (mConfiguration.locale.getCountry() != null);
                    {
                        locale += "-" + mConfiguration.locale.getCountry();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            int width, height;
            {
                width = mMetrics.widthPixels;
                height = mMetrics.heightPixels;
            } //End block
            {
                width = mMetrics.heightPixels;
                height = mMetrics.widthPixels;
            } //End block
            int keyboardHidden;
            keyboardHidden = mConfiguration.keyboardHidden;
            {
                keyboardHidden = Configuration.KEYBOARDHIDDEN_SOFT;
            } //End block
            mAssets.setConfiguration(mConfiguration.mcc, mConfiguration.mnc,
                    locale, mConfiguration.orientation,
                    mConfiguration.touchscreen,
                    (int)(mMetrics.density*160), mConfiguration.keyboard,
                    keyboardHidden, mConfiguration.navigation, width, height,
                    mConfiguration.smallestScreenWidthDp,
                    mConfiguration.screenWidthDp, mConfiguration.screenHeightDp,
                    mConfiguration.screenLayout, mConfiguration.uiMode,
                    Build.VERSION.RESOURCES_SDK_INT);
            clearDrawableCache(mDrawableCache, configChanges);
            clearDrawableCache(mColorDrawableCache, configChanges);
            mColorStateListCache.clear();
            flushLayoutCache();
        } //End block
        {
            {
                mPluralRule = NativePluralRules.forLocale(config.locale);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.473 -0400", hash_original_method = "6418DB8B9640192CDF0630899692D8E1", hash_generated_method = "8300015232985AC9DC76B87D6A46CAFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearDrawableCache(
            LongSparseArray<WeakReference<ConstantState>> cache,
            int configChanges) {
        dsTaint.addTaint(cache.dsTaint);
        dsTaint.addTaint(configChanges);
        int N;
        N = cache.size();
        {
            Log.d(TAG, "Cleaning up drawables config changes: 0x"
                    + Integer.toHexString(configChanges));
        } //End block
        {
            int i;
            i = 0;
            {
                WeakReference<Drawable.ConstantState> ref;
                ref = cache.valueAt(i);
                {
                    Drawable.ConstantState cs;
                    cs = ref.get();
                    {
                        {
                            boolean var9C0F2EE920A6529CD11D682CB4806601_513586056 = (Configuration.needNewResources(
                            configChanges, cs.getChangingConfigurations()));
                            {
                                {
                                    Log.d(TAG, "FLUSHING #0x"
                                    + Long.toHexString(mDrawableCache.keyAt(i))
                                    + " / " + cs + " with changes: 0x"
                                    + Integer.toHexString(cs.getChangingConfigurations()));
                                } //End block
                                cache.setValueAt(i, null);
                            } //End block
                            {
                                Log.d(TAG, "(Keeping #0x"
                                + Long.toHexString(cache.keyAt(i))
                                + " / " + cs + " with changes: 0x"
                                + Integer.toHexString(cs.getChangingConfigurations())
                                + ")");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.474 -0400", hash_original_method = "5106C90EB2B39AE2EA718FCE3ADEE632", hash_generated_method = "3DE8852845761BAE5DC2278325C1733C")
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics,
            CompatibilityInfo compat) {
        if (mSystem != null) {
            mSystem.updateConfiguration(config, metrics, compat);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.474 -0400", hash_original_method = "FBAD8CC49F8DB14D02AD1DC5EF02872F", hash_generated_method = "B8366E7B0EF3D3BB8BA5A75B32FD5B02")
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics) {
        updateSystemConfiguration(config, metrics, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.474 -0400", hash_original_method = "7F0483A9A445222C6F2291914FFD169A", hash_generated_method = "5119563DF6E82350F5DA992FD743BAEC")
    @DSModeled(DSC.SAFE)
    public DisplayMetrics getDisplayMetrics() {
        return (DisplayMetrics)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DEBUG_CONFIG) Slog.v(TAG, "Returning DisplayMetrics: " + mMetrics.widthPixels
                //+ "x" + mMetrics.heightPixels + " " + mMetrics.density);
        //return mMetrics;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.474 -0400", hash_original_method = "11CE3ED49D23B920A1DF6398548CD42B", hash_generated_method = "691A161DF9EB88233A75D0C11F4B4FE2")
    @DSModeled(DSC.SAFE)
    public Configuration getConfiguration() {
        return (Configuration)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.474 -0400", hash_original_method = "5C840D5EBF5D0071E35FFCF10BAAC7BF", hash_generated_method = "E777708688951A7BC9247BB57081D553")
    @DSModeled(DSC.SAFE)
    public CompatibilityInfo getCompatibilityInfo() {
        return (CompatibilityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCompatibilityInfo != null ? mCompatibilityInfo
                //: CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.475 -0400", hash_original_method = "E88B36858B95AF9A2C7AEA9BE51A197A", hash_generated_method = "67C43C8AC53AA55D4650671559EE41E9")
    @DSModeled(DSC.SAFE)
    public void setCompatibilityInfo(CompatibilityInfo ci) {
        dsTaint.addTaint(ci.dsTaint);
        updateConfiguration(mConfiguration, mMetrics);
        // ---------- Original Method ----------
        //mCompatibilityInfo = ci;
        //updateConfiguration(mConfiguration, mMetrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.475 -0400", hash_original_method = "5502AEB950C0AF2288FDD25C0479AC75", hash_generated_method = "8D694826287E4A09F24758F528F51B4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIdentifier(String name, String defType, String defPackage) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defPackage);
        dsTaint.addTaint(defType);
        try 
        {
            int var0C5B23BCF8D28A28F4CE8567896762AC_872947798 = (Integer.parseInt(name));
        } //End block
        catch (Exception e)
        { }
        int var90A48CBEB3A052E5337E8C53FA9D4855_1274352728 = (mAssets.getResourceIdentifier(name, defType, defPackage));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(name);
        //} catch (Exception e) {
        //}
        //return mAssets.getResourceIdentifier(name, defType, defPackage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.475 -0400", hash_original_method = "DE13C1A04BA835F16961D1CBF28A7683", hash_generated_method = "D61E988F5EC022FC9CE75C5B2B4DD039")
    @DSModeled(DSC.SAFE)
    public String getResourceName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourceName(resid);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourceName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.475 -0400", hash_original_method = "B498C391BD57BD64150A95598D85C5A0", hash_generated_method = "D78803E0412A030C212ED2D653BCC79A")
    @DSModeled(DSC.SAFE)
    public String getResourcePackageName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourcePackageName(resid);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourcePackageName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.475 -0400", hash_original_method = "29427E6B381809C5EA97546233CF8A82", hash_generated_method = "9926BAE6EE4217743CB1C2D89092462C")
    @DSModeled(DSC.SAFE)
    public String getResourceTypeName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourceTypeName(resid);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourceTypeName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.476 -0400", hash_original_method = "5ED2928930BE3B5AB199F5456042FBFD", hash_generated_method = "5D3B979BEF0A8452FC1F182FB656B77E")
    @DSModeled(DSC.SAFE)
    public String getResourceEntryName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourceEntryName(resid);
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourceEntryName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.476 -0400", hash_original_method = "545D8F55664B33539EC622970F1D1819", hash_generated_method = "41073CD5EBD9FC89927CEA46AF47FF77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        dsTaint.addTaint(outBundle.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var49BAE650CF2F44016B0E4A15ECAD0A92_372958829 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String nodeName;
                nodeName = parser.getName();
                {
                    boolean var9B462BCA6AFE78346945C1C798AAB22C_1251384013 = (nodeName.equals("extra"));
                    {
                        parseBundleExtra("extra", parser, outBundle);
                        XmlUtils.skipCurrentTag(parser);
                    } //End block
                    {
                        XmlUtils.skipCurrentTag(parser);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int outerDepth = parser.getDepth();
        //int type;
        //while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               //&& (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            //if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                //continue;
            //}
            //String nodeName = parser.getName();
            //if (nodeName.equals("extra")) {
                //parseBundleExtra("extra", parser, outBundle);
                //XmlUtils.skipCurrentTag(parser);
            //} else {
                //XmlUtils.skipCurrentTag(parser);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.477 -0400", hash_original_method = "A47660356021C86DB26B06C4FCD54400", hash_generated_method = "FB9B4064CE0B2245A85365123B3F026D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseBundleExtra(String tagName, AttributeSet attrs,
            Bundle outBundle) throws XmlPullParserException {
        dsTaint.addTaint(outBundle.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(tagName);
        TypedArray sa;
        sa = obtainAttributes(attrs,
                com.android.internal.R.styleable.Extra);
        String name;
        name = sa.getString(
                com.android.internal.R.styleable.Extra_name);
        {
            sa.recycle();
            if (DroidSafeAndroidRuntime.control)throw new XmlPullParserException("<" + tagName
                    + "> requires an android:name attribute at "
                    + attrs.getPositionDescription());
        } //End block
        TypedValue v;
        v = sa.peekValue(
                com.android.internal.R.styleable.Extra_value);
        {
            {
                CharSequence cs;
                cs = v.coerceToString();
                outBundle.putCharSequence(name, cs);
            } //End block
            {
                outBundle.putBoolean(name, v.data != 0);
            } //End block
            {
                outBundle.putInt(name, v.data);
            } //End block
            {
                outBundle.putFloat(name, v.getFloat());
            } //End block
            {
                sa.recycle();
                if (DroidSafeAndroidRuntime.control)throw new XmlPullParserException("<" + tagName
                        + "> only supports string, integer, float, color, and boolean at "
                        + attrs.getPositionDescription());
            } //End block
        } //End block
        {
            sa.recycle();
            if (DroidSafeAndroidRuntime.control)throw new XmlPullParserException("<" + tagName
                    + "> requires an android:value or android:resource attribute at "
                    + attrs.getPositionDescription());
        } //End block
        sa.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.477 -0400", hash_original_method = "B655DEE21C3816C25C0AC2AC9EDD1950", hash_generated_method = "06B8C90B77C6ED5D5D5CCCACFCEE6A6C")
    @DSModeled(DSC.SAFE)
    public final AssetManager getAssets() {
        return (AssetManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAssets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.477 -0400", hash_original_method = "5E0B191196DA287D9E0DBDD23155512B", hash_generated_method = "4DC5AA4527560CB8F129B3C868D33A3C")
    @DSModeled(DSC.SAFE)
    public final void flushLayoutCache() {
        {
            final int num;
            num = mCachedXmlBlockIds.length;
            {
                int i;
                i = 0;
                {
                    mCachedXmlBlockIds[i] = -0;
                    XmlBlock oldBlock;
                    oldBlock = mCachedXmlBlocks[i];
                    {
                        oldBlock.close();
                    } //End block
                    mCachedXmlBlocks[i] = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCachedXmlBlockIds) {
            //final int num = mCachedXmlBlockIds.length;
            //for (int i=0; i<num; i++) {
                //mCachedXmlBlockIds[i] = -0;
                //XmlBlock oldBlock = mCachedXmlBlocks[i];
                //if (oldBlock != null) {
                    //oldBlock.close();
                //}
                //mCachedXmlBlocks[i] = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.477 -0400", hash_original_method = "EFB6118AC43FED1C4435A31DA78431FB", hash_generated_method = "05785A16C587BE513207546B0406CDCE")
    @DSModeled(DSC.SAFE)
    public final void startPreloading() {
        {
            {
            	if (DroidSafeAndroidRuntime.control)throw new IllegalStateException("Resources already preloaded");
            } //End block
            mPreloaded = true;
            mPreloading = true;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPreloaded) {
                //throw new IllegalStateException("Resources already preloaded");
            //}
            //mPreloaded = true;
            //mPreloading = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.477 -0400", hash_original_method = "FF66D3DC188460C4E673EECA31B8D29B", hash_generated_method = "637EEC29D83B2CB0A865E642FFFD3E4D")
    @DSModeled(DSC.SAFE)
    public final void finishPreloading() {
        {
            mPreloading = false;
            flushLayoutCache();
        } //End block
        // ---------- Original Method ----------
        //if (mPreloading) {
            //mPreloading = false;
            //flushLayoutCache();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.478 -0400", hash_original_method = "2F02B67F3FD30AAC12B7734E2B09423F", hash_generated_method = "EB3F09FF77FBA726CCB22D7B01D58DBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Drawable loadDrawable(TypedValue value, int id) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(value.dsTaint);
        {
            {
                final String name;
                name = getResourceName(id);
                android.util.Log.d("PreloadDrawable", name);
            } //End block
        } //End block
        final long key;
        key = (((long) value.assetCookie) << 32) | value.data;
        boolean isColorDrawable;
        isColorDrawable = false;
        {
            isColorDrawable = true;
        } //End block
        Drawable dr;
        dr = getCachedDrawable(isColorDrawable ? mColorDrawableCache : mDrawableCache, key);//DSFIXME:  CODE0008: Nested ternary operator in expression
        Drawable.ConstantState cs;
        cs = sPreloadedColorDrawables.get(key);
        cs = sPreloadedDrawables.get(key);
        {
            dr = cs.newDrawable(this);
        } //End block
        {
            {
                dr = new ColorDrawable(value.data);
            } //End block
            {
                {
                	if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                            "Resource is not a Drawable (color or path): " + value);
                } //End block
                String file;
                file = value.string.toString();
                {
                    {
                        final String name;
                        name = getResourceName(id);
                        android.util.Log.d(TAG, "Loading framework drawable #"
                                + Integer.toHexString(id) + ": " + name
                                + " at " + file);
                    } //End block
                } //End block
                {
                    boolean varE0987C6B5CC3DA09C3EAA5CE0FE23DAC_117725936 = (file.endsWith(".xml"));
                    {
                        try 
                        {
                            XmlResourceParser rp;
                            rp = loadXmlResourceParser(
                                file, id, value.assetCookie, "drawable");
                            dr = Drawable.createFromXml(this, rp);
                            rp.close();
                        } //End block
                        catch (Exception e)
                        {
                            NotFoundException rnf;
                            rnf = new NotFoundException(
                            "File " + file + " from drawable resource ID #0x"
                            + Integer.toHexString(id));
                            rnf.initCause(e);
                            throw rnf;
                        } //End block
                    } //End block
                    {
                        try 
                        {
                            InputStream is;
                            is = mAssets.openNonAsset(
                                value.assetCookie, file, AssetManager.ACCESS_STREAMING);
                            dr = Drawable.createFromResourceStream(this, value, is,
                                file, null);
                            is.close();
                        } //End block
                        catch (Exception e)
                        {
                            NotFoundException rnf;
                            rnf = new NotFoundException(
                            "File " + file + " from drawable resource ID #0x"
                            + Integer.toHexString(id));
                            rnf.initCause(e);
                            throw rnf;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            dr.setChangingConfigurations(value.changingConfigurations);
            cs = dr.getConstantState();
            {
                {
                    {
                        sPreloadedColorDrawables.put(key, cs);
                    } //End block
                    {
                        sPreloadedDrawables.put(key, cs);
                    } //End block
                } //End block
                {
                    {
                        {
                            mColorDrawableCache.put(key, new WeakReference<Drawable.ConstantState>(cs));
                        } //End block
                        {
                            mDrawableCache.put(key, new WeakReference<Drawable.ConstantState>(cs));
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.479 -0400", hash_original_method = "134BDC10D8442526D2E686E53BA1531C", hash_generated_method = "AB767D2033582E52CC1F40A32B55AFFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Drawable getCachedDrawable(
            LongSparseArray<WeakReference<ConstantState>> drawableCache,
            long key) {
        dsTaint.addTaint(drawableCache.dsTaint);
        dsTaint.addTaint(key);
        {
            WeakReference<Drawable.ConstantState> wr;
            wr = drawableCache.get(key);
            {
                Drawable.ConstantState entry;
                entry = wr.get();
                {
                    Drawable var670EF86F5AB73E97AD78E9A4151C6D16_900935715 = (entry.newDrawable(this));
                } //End block
                {
                    drawableCache.delete(key);
                } //End block
            } //End block
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //WeakReference<Drawable.ConstantState> wr = drawableCache.get(key);
            //if (wr != null) {   
                //Drawable.ConstantState entry = wr.get();
                //if (entry != null) {
                    //return entry.newDrawable(this);
                //}
                //else {  
                    //drawableCache.delete(key);
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.479 -0400", hash_original_method = "035DC5FC794E074E6FAA3F20B34AB858", hash_generated_method = "B14775F864BF33982A7B01308EDA5D9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ColorStateList loadColorStateList(TypedValue value, int id) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(value.dsTaint);
        {
            {
                final String name;
                name = getResourceName(id);
                android.util.Log.d("PreloadColorStateList", name);
            } //End block
        } //End block
        final int key;
        key = (value.assetCookie << 24) | value.data;
        ColorStateList csl;
        {
            csl = mPreloadedColorStateLists.get(key);
            csl = ColorStateList.valueOf(value.data);
            {
                mPreloadedColorStateLists.put(key, csl);
            } //End block
        } //End block
        csl = getCachedColorStateList(key);
        csl = mPreloadedColorStateLists.get(key);
        {
        	if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                    "Resource is not a ColorStateList (color or path): " + value);
        } //End block
        String file;
        file = value.string.toString();
        {
            boolean varD5B89D7D99AA05BDEB10746CCC3A990F_1397930257 = (file.endsWith(".xml"));
            {
                try 
                {
                    XmlResourceParser rp;
                    rp = loadXmlResourceParser(
                        file, id, value.assetCookie, "colorstatelist");
                    csl = ColorStateList.createFromXml(this, rp);
                    rp.close();
                } //End block
                catch (Exception e)
                {
                    NotFoundException rnf;
                    rnf = new NotFoundException(
                    "File " + file + " from color state list resource ID #0x"
                    + Integer.toHexString(id));
                    rnf.initCause(e);
                    throw rnf;
                } //End block
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                    "File " + file + " from drawable resource ID #0x"
                    + Integer.toHexString(id) + ": .xml extension required");
            } //End block
        } //End collapsed parenthetic
        {
            {
                mPreloadedColorStateLists.put(key, csl);
            } //End block
            {
                {
                    mColorStateListCache.put(
                        key, new WeakReference<ColorStateList>(csl));
                } //End block
            } //End block
        } //End block
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.480 -0400", hash_original_method = "B7AA5737FC7D8937CDF4D069CBD3DB14", hash_generated_method = "355D49860CE72D36CCD3878674A238F2")
    @DSModeled(DSC.SAFE)
    private ColorStateList getCachedColorStateList(int key) {
        dsTaint.addTaint(key);
        {
            WeakReference<ColorStateList> wr;
            wr = mColorStateListCache.get(key);
            {
                ColorStateList entry;
                entry = wr.get();
                {
                    mColorStateListCache.delete(key);
                } //End block
            } //End block
        } //End block
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //WeakReference<ColorStateList> wr = mColorStateListCache.get(key);
            //if (wr != null) {   
                //ColorStateList entry = wr.get();
                //if (entry != null) {
                    //return entry;
                //}
                //else {  
                    //mColorStateListCache.delete(key);
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.480 -0400", hash_original_method = "4C55C30B9C50C80710A05CFD192F83DB", hash_generated_method = "4F129B2DABC7779C2B325A81AF566D68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     XmlResourceParser loadXmlResourceParser(int id, String type) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(type);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                XmlResourceParser var8F6806D1C41B0FA6861A827062543D89_1757617520 = (loadXmlResourceParser(value.string.toString(), id,
                        value.assetCookie, type));
            } //End block
            if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //if (value.type == TypedValue.TYPE_STRING) {
                //return loadXmlResourceParser(value.string.toString(), id,
                        //value.assetCookie, type);
            //}
            //throw new NotFoundException(
                    //"Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    //+ Integer.toHexString(value.type) + " is not valid");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.481 -0400", hash_original_method = "B570E59A2D87535635D1C6300E407B49", hash_generated_method = "8800E7C7D39E6D830853C4ABDB968C58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     XmlResourceParser loadXmlResourceParser(String file, int id,
            int assetCookie, String type) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(file);
        dsTaint.addTaint(assetCookie);
        dsTaint.addTaint(type);
        {
            try 
            {
                {
                    final int num;
                    num = mCachedXmlBlockIds.length;
                    {
                        int i;
                        i = 0;
                        {
                            {
                                XmlResourceParser var1961AADBD1B651335C853A6F5C78868A_1305688228 = (mCachedXmlBlocks[i].newParser());
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    XmlBlock block;
                    block = mAssets.openXmlBlockAsset(
                            assetCookie, file);
                    {
                        int pos;
                        pos = mLastCachedXmlBlockIndex+1;
                        pos = 0;
                        mLastCachedXmlBlockIndex = pos;
                        XmlBlock oldBlock;
                        oldBlock = mCachedXmlBlocks[pos];
                        {
                            oldBlock.close();
                        } //End block
                        mCachedXmlBlockIds[pos] = id;
                        mCachedXmlBlocks[pos] = block;
                        XmlResourceParser var59F14A7225D9DBCCB7CEC471B05C174E_1083487823 = (block.newParser());
                    } //End block
                } //End block
            } //End block
            catch (Exception e)
            {
                NotFoundException rnf;
                rnf = new NotFoundException(
                        "File " + file + " from xml type " + type + " resource ID #0x"
                        + Integer.toHexString(id));
                rnf.initCause(e);
                throw rnf;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control)throw new NotFoundException(
                "File " + file + " from xml type " + type + " resource ID #0x"
                + Integer.toHexString(id));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.481 -0400", hash_original_method = "EFFE2C2D7E798E7ABE4C38D3A3D2ED16", hash_generated_method = "84DE0F251F1607CEDD74E12248A450B8")
    @DSModeled(DSC.SAFE)
    private TypedArray getCachedStyledAttributes(int len) {
        dsTaint.addTaint(len);
        {
            TypedArray attrs;
            attrs = mCachedStyledAttributes;
            {
                mCachedStyledAttributes = null;
                {
                    mLastRetrievedAttrs = new RuntimeException("here");
                    mLastRetrievedAttrs.fillInStackTrace();
                } //End block
                attrs.mLength = len;
                int fullLen;
                fullLen = len * AssetManager.STYLE_NUM_ENTRIES;
                attrs.mData = new int[fullLen];
                attrs.mIndices = new int[1+len];
            } //End block
            {
                RuntimeException here;
                here = new RuntimeException("here");
                here.fillInStackTrace();
                mLastRetrievedAttrs = here;
            } //End block
        } //End block
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class NotFoundException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.481 -0400", hash_original_method = "16646BE2B605A836CC81C1207D23548C", hash_generated_method = "6713BE0E26EFF7DC9D17B1A0A3007565")
        @DSModeled(DSC.SAFE)
        public NotFoundException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.482 -0400", hash_original_method = "4E6E00F1F6EDF0AE5B66F6F35CDBCBD1", hash_generated_method = "F16B5DC749036BD58E948D03931ABD69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NotFoundException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
    public final class Theme {
        private final AssetManager mAssets;
        private final int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.482 -0400", hash_original_method = "795E489BE8D614A2CE03C4AA3DA2CC6B", hash_generated_method = "666580061FFD5B79FFE35E422C41601F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Theme() {
            mAssets = Resources.this.mAssets;
            mTheme = mAssets.createTheme();
            // ---------- Original Method ----------
            //mAssets = Resources.this.mAssets;
            //mTheme = mAssets.createTheme();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.482 -0400", hash_original_method = "DC72D253295A0467BBA777314F2243D9", hash_generated_method = "DBDE8F40AAA3F9BCD594F0329E9B60C9")
        @DSModeled(DSC.SAFE)
        public void applyStyle(int resid, boolean force) {
            dsTaint.addTaint(resid);
            dsTaint.addTaint(force);
            AssetManager.applyThemeStyle(mTheme, resid, force);
            // ---------- Original Method ----------
            //AssetManager.applyThemeStyle(mTheme, resid, force);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.482 -0400", hash_original_method = "16C1EE1974E6C30AE0CF98F33344DBAC", hash_generated_method = "D279EA6E0B680062A1538481A12E5A4A")
        @DSModeled(DSC.SAFE)
        public void setTo(Theme other) {
            dsTaint.addTaint(other.dsTaint);
            AssetManager.copyTheme(mTheme, other.mTheme);
            // ---------- Original Method ----------
            //AssetManager.copyTheme(mTheme, other.mTheme);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.482 -0400", hash_original_method = "810F63867177324D3683F3630D8FEF5A", hash_generated_method = "074690399E0D31A5953906159415D518")
        @DSModeled(DSC.SAFE)
        public TypedArray obtainStyledAttributes(int[] attrs) {
            dsTaint.addTaint(attrs);
            int len;
            len = attrs.length;
            TypedArray array;
            array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    array.mData, array.mIndices);
            return (TypedArray)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int len = attrs.length;
            //TypedArray array = getCachedStyledAttributes(len);
            //array.mRsrcs = attrs;
            //AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    //array.mData, array.mIndices);
            //return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.483 -0400", hash_original_method = "09973A74CD9EB62806AFBCC15CD74823", hash_generated_method = "250A0184A3529A7C9E23D2A7A1D9418F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TypedArray obtainStyledAttributes(int resid, int[] attrs) throws NotFoundException {
            dsTaint.addTaint(resid);
            dsTaint.addTaint(attrs);
            int len;
            len = attrs.length;
            TypedArray array;
            array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, resid, 0, attrs,
                    array.mData, array.mIndices);
            {
                int[] data;
                data = array.mData;
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("Attributes:");
                String s;
                s = "  Attrs:";
                int i;
                {
                    i=0;
                    {
                        s = s + " 0x" + Integer.toHexString(attrs[i]);
                    } //End block
                } //End collapsed parenthetic
                System.out.println(s);
                s = "  Found:";
                TypedValue value;
                value = new TypedValue();
                {
                    i=0;
                    {
                        int d;
                        d = i*AssetManager.STYLE_NUM_ENTRIES;
                        value.type = data[d+AssetManager.STYLE_TYPE];
                        value.data = data[d+AssetManager.STYLE_DATA];
                        value.assetCookie = data[d+AssetManager.STYLE_ASSET_COOKIE];
                        value.resourceId = data[d+AssetManager.STYLE_RESOURCE_ID];
                        s = s + " 0x" + Integer.toHexString(attrs[i])
                        + "=" + value;
                    } //End block
                } //End collapsed parenthetic
                System.out.println(s);
            } //End block
            return (TypedArray)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.483 -0400", hash_original_method = "1F1D15615A0F17B362A611476D650DBA", hash_generated_method = "D5B297F05AAEAB311C31AE45479D1D65")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TypedArray obtainStyledAttributes(AttributeSet set,
                int[] attrs, int defStyleAttr, int defStyleRes) {
            dsTaint.addTaint(defStyleRes);
            dsTaint.addTaint(defStyleAttr);
            dsTaint.addTaint(set.dsTaint);
            dsTaint.addTaint(attrs);
            int len;
            len = attrs.length;
            TypedArray array;
            array = getCachedStyledAttributes(len);
            XmlBlock.Parser parser;
            parser = (XmlBlock.Parser)set;
            AssetManager.applyStyle(
                mTheme, defStyleAttr, defStyleRes,
                parser != null ? parser.mParseState : 0, attrs,
                        array.mData, array.mIndices);
            array.mRsrcs = attrs;
            array.mXml = parser;
            {
                int[] data;
                data = array.mData;
                System.out.println("Attributes:");
                String s;
                s = "  Attrs:";
                int i;
                {
                    i=0;
                    boolean var7FD042E7695005AA0C740C5D0A4B897B_22636766 = (i<set.getAttributeCount());
                    {
                        s = s + " " + set.getAttributeName(i);
                        int id;
                        id = set.getAttributeNameResource(i);
                        {
                            s = s + "(0x" + Integer.toHexString(id) + ")";
                        } //End block
                        s = s + "=" + set.getAttributeValue(i);
                    } //End block
                } //End collapsed parenthetic
                System.out.println(s);
                s = "  Found:";
                TypedValue value;
                value = new TypedValue();
                {
                    i=0;
                    {
                        int d;
                        d = i*AssetManager.STYLE_NUM_ENTRIES;
                        value.type = data[d+AssetManager.STYLE_TYPE];
                        value.data = data[d+AssetManager.STYLE_DATA];
                        value.assetCookie = data[d+AssetManager.STYLE_ASSET_COOKIE];
                        value.resourceId = data[d+AssetManager.STYLE_RESOURCE_ID];
                        s = s + " 0x" + Integer.toHexString(attrs[i])
                        + "=" + value;
                    } //End block
                } //End collapsed parenthetic
                System.out.println(s);
            } //End block
            return (TypedArray)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.484 -0400", hash_original_method = "CD4F3944F9E3B620EE3ED57C21E36085", hash_generated_method = "D64C8D706CD18866F9357307B92364B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean resolveAttribute(int resid, TypedValue outValue,
                boolean resolveRefs) {
            dsTaint.addTaint(resid);
            dsTaint.addTaint(outValue.dsTaint);
            dsTaint.addTaint(resolveRefs);
            boolean got;
            got = mAssets.getThemeValue(mTheme, resid, outValue, resolveRefs);
            {
                System.out.println(
                    "resolveAttribute #" + Integer.toHexString(resid)
                    + " got=" + got + ", type=0x" + Integer.toHexString(outValue.type)
                    + ", data=0x" + Integer.toHexString(outValue.data));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //boolean got = mAssets.getThemeValue(mTheme, resid, outValue, resolveRefs);
            //if (false) {
                //System.out.println(
                    //"resolveAttribute #" + Integer.toHexString(resid)
                    //+ " got=" + got + ", type=0x" + Integer.toHexString(outValue.type)
                    //+ ", data=0x" + Integer.toHexString(outValue.data));
            //}
            //return got;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.484 -0400", hash_original_method = "AE42D7A6EFA93EEFF71D2B911A492F1C", hash_generated_method = "D4214BA19D1EDA8A8E134E2437004D93")
        @DSModeled(DSC.SAFE)
        public void dump(int priority, String tag, String prefix) {
            dsTaint.addTaint(priority);
            dsTaint.addTaint(tag);
            dsTaint.addTaint(prefix);
            AssetManager.dumpTheme(mTheme, priority, tag, prefix);
            // ---------- Original Method ----------
            //AssetManager.dumpTheme(mTheme, priority, tag, prefix);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.484 -0400", hash_original_method = "E91350A0CB8175C6CA6A8BD390A0B4B8", hash_generated_method = "E0B8DA1E79B0238EC7B73F7AA5889B94")
        @DSModeled(DSC.SAFE)
        protected void finalize() throws Throwable {
            super.finalize();
            mAssets.releaseTheme(mTheme);
            // ---------- Original Method ----------
            //super.finalize();
            //mAssets.releaseTheme(mTheme);
        }

        
    }


    
}


