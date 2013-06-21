package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.pm.ActivityInfo;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.LongSparseArray;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import libcore.icu.NativePluralRules;

public class Resources {
    TypedValue mTmpValue = new TypedValue();
    Configuration mTmpConfig = new Configuration();
    private LongSparseArray<WeakReference<Drawable.ConstantState> > mDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    private SparseArray<WeakReference<ColorStateList> > mColorStateListCache
            = new SparseArray<WeakReference<ColorStateList> >();
    private LongSparseArray<WeakReference<Drawable.ConstantState> > mColorDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    private boolean mPreloading;
    TypedArray mCachedStyledAttributes = null;
    RuntimeException mLastRetrievedAttrs = null;
    private int mLastCachedXmlBlockIndex = -1;
    private int[] mCachedXmlBlockIds = { 0, 0, 0, 0 };
    private XmlBlock[] mCachedXmlBlocks = new XmlBlock[4];
    AssetManager mAssets;
    private Configuration mConfiguration = new Configuration();
    DisplayMetrics mMetrics = new DisplayMetrics();
    private NativePluralRules mPluralRule;
    private CompatibilityInfo mCompatibilityInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.424 -0400", hash_original_method = "A1A5E1FE4CAABF0AED8ED513B68BEBB1", hash_generated_method = "FBD1938DF05E11DAFF4C9B1A97AF4E0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config) {
        this(assets, metrics, config, (CompatibilityInfo) null);
        dsTaint.addTaint(assets.dsTaint);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.425 -0400", hash_original_method = "2B8ADFD0988160303F3DB857A23CF093", hash_generated_method = "EF2DF451EF76B46EB4D2C70A7BB8AF66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config, CompatibilityInfo compInfo) {
        dsTaint.addTaint(assets.dsTaint);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(compInfo.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        mMetrics.setToDefaults();
        updateConfiguration(config, metrics);
        assets.ensureStringBlocks();
        // ---------- Original Method ----------
        //mAssets = assets;
        //mMetrics.setToDefaults();
        //mCompatibilityInfo = compInfo;
        //updateConfiguration(config, metrics);
        //assets.ensureStringBlocks();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.425 -0400", hash_original_method = "647BD0141CFE00480058A00B761B8E30", hash_generated_method = "E7B264666C51F87CBE8DFE8E5E5422AA")
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

    
        @SuppressWarnings("unchecked")
    private static <T> LongSparseArray<T> emptySparseArray() {
        return (LongSparseArray<T>) EMPTY_ARRAY;
    }

    
        public static int selectDefaultTheme(int curTheme, int targetSdkVersion) {
        return selectSystemTheme(curTheme, targetSdkVersion,
                com.android.internal.R.style.Theme,
                com.android.internal.R.style.Theme_Holo,
                com.android.internal.R.style.Theme_DeviceDefault);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.426 -0400", hash_original_method = "ACC5D7202FC5E62E31E1054DCF0E5FCD", hash_generated_method = "DC87E0F99228EFFD38DB7B066F73D1CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getText(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        CharSequence res;
        res = mAssets.getResourceText(id);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource ID #0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.427 -0400", hash_original_method = "78A3DFDF860E06736217D448EF07FADF", hash_generated_method = "AAD9F9FCA8A6DA5E2777F8DCCCB7C06C")
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
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Plural resource ID #0x" + Integer.toHexString(id)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.427 -0400", hash_original_method = "1BFA20E87FBD429BB566BA0632D0EE62", hash_generated_method = "9D7A6C590223D434A78857F91B923C07")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.428 -0400", hash_original_method = "537EFC002B8A40B3B7F76596758B9963", hash_generated_method = "91A882C30FB60C20C9C52F305A5CEE0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        CharSequence res;
        res = getText(id);
        {
            String varC80A1DDFE3E52DD547813302DB81FF7B_345700380 = (res.toString());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource ID #0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.428 -0400", hash_original_method = "2EEC36CFDBF61FC5501B8B9376C5F95E", hash_generated_method = "B4059A57D118329A5C85182373CDD4C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(formatArgs[0].dsTaint);
        String raw;
        raw = getString(id);
        String var86E36E1F578ADCC1CCCFE04E2F22FF68_301332264 = (String.format(mConfiguration.locale, raw, formatArgs));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String raw = getString(id);
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.429 -0400", hash_original_method = "3050F7A6F3C08BB33AB97951F94A1A35", hash_generated_method = "D03560BE2D8DB90B48C7C13EF1AB5EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(quantity);
        dsTaint.addTaint(formatArgs[0].dsTaint);
        String raw;
        raw = getQuantityText(id, quantity).toString();
        String var86E36E1F578ADCC1CCCFE04E2F22FF68_1721413342 = (String.format(mConfiguration.locale, raw, formatArgs));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String raw = getQuantityText(id, quantity).toString();
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.429 -0400", hash_original_method = "81877842C4E2FEF0D9FCD2095374BD66", hash_generated_method = "8BD0D1B9E04792EB5437732865110F0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQuantityString(int id, int quantity) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(quantity);
        String varBB2640B589517EDA6683FD4E4C01FC4F_1121857537 = (getQuantityText(id, quantity).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getQuantityText(id, quantity).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.429 -0400", hash_original_method = "9E76804CDFB0982D016B6CE6163D7455", hash_generated_method = "48C412E3CD32C7A4327C243FB3099DE6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.430 -0400", hash_original_method = "2FECA5C28D9DC41170E2F1E5700277A0", hash_generated_method = "072B1131CE8E4F953A78371CFB3453CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence[] getTextArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        CharSequence[] res;
        res = mAssets.getResourceTextArray(id);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Text array resource ID #0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.430 -0400", hash_original_method = "426431DC420CF2DD39FFAF8B295D8654", hash_generated_method = "25769ADD3A1D7F94B231A4F1BD85DFA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getStringArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        String[] res;
        res = mAssets.getResourceStringArray(id);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String array resource ID #0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.430 -0400", hash_original_method = "65AEFB7747626FD934E6275803D2C392", hash_generated_method = "E920366967C88BD9359BBC724D657586")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getIntArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        int[] res;
        res = mAssets.getArrayIntResource(id);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Int array resource ID #0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.431 -0400", hash_original_method = "8E5AB34336560F1D8FA12EC65FB34D2E", hash_generated_method = "BCC744D738B55102F4A1363525CB5E18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypedArray obtainTypedArray(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        int len;
        len = mAssets.getArraySize(id);
        {
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Array resource ID #0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.431 -0400", hash_original_method = "179671F1A37C23E822373A76E19D42EA", hash_generated_method = "1F439E96B44CB65413AF40AFBB7BC8CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getDimension(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                float var3D1EF52544C26367510F308FBFEC9AF2_1737944481 = (TypedValue.complexToDimension(value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.431 -0400", hash_original_method = "1833FD2ED6DCA9CF6DFDBF7D9BC0478B", hash_generated_method = "AC1C52796182B84DA917E2ACE48779B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                int varC10E6C7CE4C18B2E8240388CE0B9D4D5_328068831 = (TypedValue.complexToDimensionPixelOffset(
                        value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.432 -0400", hash_original_method = "E2B2A30088D0238C29DEA7CD0218F3E5", hash_generated_method = "4663B774C1CB4807B6F0DD75D6DAB604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelSize(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                int var618929EFC759B1CAECEF2B8755B3C586_1567927925 = (TypedValue.complexToDimensionPixelSize(
                        value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.432 -0400", hash_original_method = "A2DCBF1A3DEF525CC233A65EC473B403", hash_generated_method = "165A242A4FD5D88B5C10A95A802D94C3")
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
                float var32E1DB9737EBC4A230505D9C45C6217C_1686782518 = (TypedValue.complexToFraction(value.data, base, pbase));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.433 -0400", hash_original_method = "40531A8693FC775C03E22F5835EB733B", hash_generated_method = "24F442890B487B958BABE1D7A3D2211D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getDrawable(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            Drawable var484E9D75953D8C3E9E8C8035FF58E738_389814185 = (loadDrawable(value, id));
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadDrawable(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.433 -0400", hash_original_method = "D08D33B833687D530F432098EC5CCB38", hash_generated_method = "E95432F759B976440A581CCAD88A989D")
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
            Drawable var484E9D75953D8C3E9E8C8035FF58E738_2028352461 = (loadDrawable(value, id));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.433 -0400", hash_original_method = "973C0EDB6E14C8355746DA3A02A0EBD1", hash_generated_method = "2078A6EDBB27FA343B94E6215645F233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.434 -0400", hash_original_method = "CDFC75613D2F871DC3B09D1CE60F98A4", hash_generated_method = "E6453E6D8672615F6587BD046197094C")
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
                int var0BE21B049075D2C5C0B5387A1C4FC3D4_1349350570 = (csl.getDefaultColor());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.434 -0400", hash_original_method = "F237EF4FA0AE2D448FCC64592DABDD8D", hash_generated_method = "0A9E24F7129C71E3A5D0C971E3F89CD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            ColorStateList var2DD4B07A29C83DB18C241B731CACA3D6_154288162 = (loadColorStateList(value, id));
        } //End block
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadColorStateList(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.436 -0400", hash_original_method = "5C68CA666BA42061546BF98D8883861D", hash_generated_method = "5EB03EC6E9557106E443CF8A3752766A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.436 -0400", hash_original_method = "CB2B32F0600F2299579C79C7526A8896", hash_generated_method = "22698C2B0DD395B18A61EBE9E231CA2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInteger(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.437 -0400", hash_original_method = "53A788F1DE83214BAFCB022ED9363AAC", hash_generated_method = "FA970F6E0039C152DC1F00C9CE9E9CEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        XmlResourceParser var8BCBF72B8FED622ABE8608E776A438DE_1367092703 = (loadXmlResourceParser(id, "layout"));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "layout");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.437 -0400", hash_original_method = "C3417F93CB7498AF5B43E94B98075C78", hash_generated_method = "F620EA89E1C7E27ADD85F195D13B7C98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        XmlResourceParser var4AAEDEA00858286EE3ED8DFDF6003A75_116638597 = (loadXmlResourceParser(id, "anim"));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "anim");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.439 -0400", hash_original_method = "66568C58C76DE1C95FED15C8056E4335", hash_generated_method = "EE0907764CDCE6C49A56E94A4724A838")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser getXml(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        XmlResourceParser var1C9ABC5B2AE2BBBA8F4FEFD6210129DF_65596445 = (loadXmlResourceParser(id, "xml"));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.439 -0400", hash_original_method = "2A38C8042909AD0B3921F8B41C50BFD0", hash_generated_method = "039FCA01D3023A324878D53C4A922AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream openRawResource(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            InputStream varFD96ECD68ABB190E248FDBF387C1A904_1713179706 = (openRawResource(id, mTmpValue));
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //return openRawResource(id, mTmpValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.440 -0400", hash_original_method = "2E256A4CBCC4636EC939F62266AB39BC", hash_generated_method = "B628DB9D8993FC99D2E3D46086A5BD14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(value.dsTaint);
        getValue(id, value, true);
        try 
        {
            InputStream var481BB9AEE7CD808C6866F4641B64622B_1538097688 = (mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    AssetManager.ACCESS_STREAMING));
        } //End block
        catch (Exception e)
        {
            NotFoundException rnf;
            rnf = new NotFoundException("File " + value.string.toString() +
                    " from drawable resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw rnf;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.441 -0400", hash_original_method = "7A496359623417DAF484E4884A244E4E", hash_generated_method = "2F497213831D11B4725663364FFEBE93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        dsTaint.addTaint(id);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            try 
            {
                AssetFileDescriptor varCF85803C663599342E4C64C4DFBB0264_274709784 = (mAssets.openNonAssetFd(
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
                if (DroidSafeAndroidRuntime.control) throw rnf;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.442 -0400", hash_original_method = "286538764BE9255E72B90D7B13646A2E", hash_generated_method = "C6613F1F456EA36406459016B5D662D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(resolveRefs);
        boolean found;
        found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Resource ID #0x"
                                    + Integer.toHexString(id));
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.442 -0400", hash_original_method = "FF0649F49CF780958319F2862D12B017", hash_generated_method = "8405990BD4E31FCFF1F7B35FD63F5EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(density);
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(resolveRefs);
        boolean found;
        found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.442 -0400", hash_original_method = "A4F8C6B97749A99408C92371916352C6", hash_generated_method = "E6A23AB4B42DC98CF6A9D7DC55CF10A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        dsTaint.addTaint(outValue.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(resolveRefs);
        int id;
        id = getIdentifier(name, "string", null);
        {
            getValue(id, outValue, resolveRefs);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource name " + name);
        // ---------- Original Method ----------
        //int id = getIdentifier(name, "string", null);
        //if (id != 0) {
            //getValue(id, outValue, resolveRefs);
            //return;
        //}
        //throw new NotFoundException("String resource name " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.442 -0400", hash_original_method = "89EA817324C2BD92A04D61539A7DF9A0", hash_generated_method = "7BEDBCCAB0CAC115FA4CD8A813DFB572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Theme newTheme() {
        Theme varE789E20695EE2D480A2F509B55F518F0_999501629 = (new Theme());
        return (Theme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Theme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.443 -0400", hash_original_method = "D166D2286995B941AEE6CFA36445D894", hash_generated_method = "4D60565C2DC92F5E2934FB2663BC4495")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        dsTaint.addTaint(attrs[0]);
        dsTaint.addTaint(set.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.443 -0400", hash_original_method = "FADFD61D7F3DC00CFE83DECA8FAB375D", hash_generated_method = "3D74090464D8EA141C0237AE0C4A0A3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        updateConfiguration(config, metrics, null);
        // ---------- Original Method ----------
        //updateConfiguration(config, metrics, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.444 -0400", hash_original_method = "FB9A4AAA762C456F245AEDCFD4C4194A", hash_generated_method = "5F718D89CBF68895C0CBEB907B716AEE")
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
                    boolean varC89ED4BF7AB2BEFA099B67803FBEFA7B_658322215 = (mConfiguration.locale.getCountry() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.445 -0400", hash_original_method = "6418DB8B9640192CDF0630899692D8E1", hash_generated_method = "7902530F7FF0631A6DF9D99823E0EF4A")
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
                            boolean var9C0F2EE920A6529CD11D682CB4806601_783321536 = (Configuration.needNewResources(
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

    
        public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics,
            CompatibilityInfo compat) {
        if (mSystem != null) {
            mSystem.updateConfiguration(config, metrics, compat);
        }
    }

    
        public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics) {
        updateSystemConfiguration(config, metrics, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.446 -0400", hash_original_method = "7F0483A9A445222C6F2291914FFD169A", hash_generated_method = "F99515BE27A54C417D73187D57DC0ACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DisplayMetrics getDisplayMetrics() {
        return (DisplayMetrics)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DEBUG_CONFIG) Slog.v(TAG, "Returning DisplayMetrics: " + mMetrics.widthPixels
                //+ "x" + mMetrics.heightPixels + " " + mMetrics.density);
        //return mMetrics;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.446 -0400", hash_original_method = "11CE3ED49D23B920A1DF6398548CD42B", hash_generated_method = "EA92E0C129CAC5C2771B9A2B35F23F7D")
    @DSModeled(DSC.SAFE)
    public Configuration getConfiguration() {
        return (Configuration)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.447 -0400", hash_original_method = "5C840D5EBF5D0071E35FFCF10BAAC7BF", hash_generated_method = "501D5F319D8AD64205F056183BAF780E")
    @DSModeled(DSC.SAFE)
    public CompatibilityInfo getCompatibilityInfo() {
        return (CompatibilityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCompatibilityInfo != null ? mCompatibilityInfo
                //: CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.447 -0400", hash_original_method = "E88B36858B95AF9A2C7AEA9BE51A197A", hash_generated_method = "BBE9A6B991FF558A78A6EA0750CC28A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompatibilityInfo(CompatibilityInfo ci) {
        dsTaint.addTaint(ci.dsTaint);
        updateConfiguration(mConfiguration, mMetrics);
        // ---------- Original Method ----------
        //mCompatibilityInfo = ci;
        //updateConfiguration(mConfiguration, mMetrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.447 -0400", hash_original_method = "5502AEB950C0AF2288FDD25C0479AC75", hash_generated_method = "7C23694E86C2F6899A3E2C806C390608")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIdentifier(String name, String defType, String defPackage) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defPackage);
        dsTaint.addTaint(defType);
        try 
        {
            int var0C5B23BCF8D28A28F4CE8567896762AC_1136134252 = (Integer.parseInt(name));
        } //End block
        catch (Exception e)
        { }
        int var90A48CBEB3A052E5337E8C53FA9D4855_1926714188 = (mAssets.getResourceIdentifier(name, defType, defPackage));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(name);
        //} catch (Exception e) {
        //}
        //return mAssets.getResourceIdentifier(name, defType, defPackage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.447 -0400", hash_original_method = "DE13C1A04BA835F16961D1CBF28A7683", hash_generated_method = "9DFB7015F4538A3504D90ADB49040C06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResourceName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourceName(resid);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourceName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.448 -0400", hash_original_method = "B498C391BD57BD64150A95598D85C5A0", hash_generated_method = "5A2DBB2616A65831AFA1040E923EFFCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResourcePackageName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourcePackageName(resid);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourcePackageName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.448 -0400", hash_original_method = "29427E6B381809C5EA97546233CF8A82", hash_generated_method = "D9206AA45B180DD9FB627841492D5B38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResourceTypeName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourceTypeName(resid);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourceTypeName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.448 -0400", hash_original_method = "5ED2928930BE3B5AB199F5456042FBFD", hash_generated_method = "9108F86248FBBA2C678B0866A7C8AE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getResourceEntryName(int resid) throws NotFoundException {
        dsTaint.addTaint(resid);
        String str;
        str = mAssets.getResourceEntryName(resid);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String str = mAssets.getResourceEntryName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.449 -0400", hash_original_method = "545D8F55664B33539EC622970F1D1819", hash_generated_method = "F01716CD1223EA86E7252E20C29BF828")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        dsTaint.addTaint(outBundle.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var49BAE650CF2F44016B0E4A15ECAD0A92_718909157 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String nodeName;
                nodeName = parser.getName();
                {
                    boolean var9B462BCA6AFE78346945C1C798AAB22C_774389943 = (nodeName.equals("extra"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.450 -0400", hash_original_method = "A47660356021C86DB26B06C4FCD54400", hash_generated_method = "F786A1FD033CE85DE61EC0324CB8ECE0")
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
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("<" + tagName
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
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("<" + tagName
                        + "> only supports string, integer, float, color, and boolean at "
                        + attrs.getPositionDescription());
            } //End block
        } //End block
        {
            sa.recycle();
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("<" + tagName
                    + "> requires an android:value or android:resource attribute at "
                    + attrs.getPositionDescription());
        } //End block
        sa.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.460 -0400", hash_original_method = "B655DEE21C3816C25C0AC2AC9EDD1950", hash_generated_method = "0D85B7515EA1405829970F45AE173C10")
    @DSModeled(DSC.SAFE)
    public final AssetManager getAssets() {
        return (AssetManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAssets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.460 -0400", hash_original_method = "5E0B191196DA287D9E0DBDD23155512B", hash_generated_method = "87AD7C658E4503965A5E565EA2BFBB99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void flushLayoutCache() {
        {
            int num;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.463 -0400", hash_original_method = "EFB6118AC43FED1C4435A31DA78431FB", hash_generated_method = "10F9907BD716A3B118F283BB2C069C41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void startPreloading() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Resources already preloaded");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.463 -0400", hash_original_method = "FF66D3DC188460C4E673EECA31B8D29B", hash_generated_method = "8F83DA2BD6ACD94787540573A1998010")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.465 -0400", hash_original_method = "2F02B67F3FD30AAC12B7734E2B09423F", hash_generated_method = "08C1F036309389E4F34A12153D894E80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Drawable loadDrawable(TypedValue value, int id) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(value.dsTaint);
        {
            {
                String name;
                name = getResourceName(id);
                android.util.Log.d("PreloadDrawable", name);
            } //End block
        } //End block
        long key;
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
                    if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                            "Resource is not a Drawable (color or path): " + value);
                } //End block
                String file;
                file = value.string.toString();
                {
                    {
                        String name;
                        name = getResourceName(id);
                        android.util.Log.d(TAG, "Loading framework drawable #"
                                + Integer.toHexString(id) + ": " + name
                                + " at " + file);
                    } //End block
                } //End block
                {
                    boolean varE0987C6B5CC3DA09C3EAA5CE0FE23DAC_1615160333 = (file.endsWith(".xml"));
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
                            if (DroidSafeAndroidRuntime.control) throw rnf;
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
                            if (DroidSafeAndroidRuntime.control) throw rnf;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.466 -0400", hash_original_method = "134BDC10D8442526D2E686E53BA1531C", hash_generated_method = "785F2BF1E7828695F6C8C8D245E93683")
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
                    Drawable var670EF86F5AB73E97AD78E9A4151C6D16_1105274525 = (entry.newDrawable(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.468 -0400", hash_original_method = "035DC5FC794E074E6FAA3F20B34AB858", hash_generated_method = "73DCFD6BC6227699A2DADD08CA819C4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ColorStateList loadColorStateList(TypedValue value, int id) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(value.dsTaint);
        {
            {
                String name;
                name = getResourceName(id);
                android.util.Log.d("PreloadColorStateList", name);
            } //End block
        } //End block
        int key;
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
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource is not a ColorStateList (color or path): " + value);
        } //End block
        String file;
        file = value.string.toString();
        {
            boolean varD5B89D7D99AA05BDEB10746CCC3A990F_973384371 = (file.endsWith(".xml"));
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
                    if (DroidSafeAndroidRuntime.control) throw rnf;
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.469 -0400", hash_original_method = "B7AA5737FC7D8937CDF4D069CBD3DB14", hash_generated_method = "1390440092735F8F9E6B429BE7FAD73B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.469 -0400", hash_original_method = "4C55C30B9C50C80710A05CFD192F83DB", hash_generated_method = "A85F8138C4E2C3D54671F65BF22C1D6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     XmlResourceParser loadXmlResourceParser(int id, String type) throws NotFoundException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(type);
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                XmlResourceParser var8F6806D1C41B0FA6861A827062543D89_1084921431 = (loadXmlResourceParser(value.string.toString(), id,
                        value.assetCookie, type));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.470 -0400", hash_original_method = "B570E59A2D87535635D1C6300E407B49", hash_generated_method = "94A536933DFC8E0182767B2DAC026975")
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
                    int num;
                    num = mCachedXmlBlockIds.length;
                    {
                        int i;
                        i = 0;
                        {
                            {
                                XmlResourceParser var1961AADBD1B651335C853A6F5C78868A_1325342007 = (mCachedXmlBlocks[i].newParser());
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
                        XmlResourceParser var59F14A7225D9DBCCB7CEC471B05C174E_1817662535 = (block.newParser());
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
                if (DroidSafeAndroidRuntime.control) throw rnf;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "File " + file + " from xml type " + type + " resource ID #0x"
                + Integer.toHexString(id));
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.471 -0400", hash_original_method = "EFFE2C2D7E798E7ABE4C38D3A3D2ED16", hash_generated_method = "D8E26E0348B45988C48D89061CC0E221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            TypedArray varD8767301E353947746F0AA0279A6025E_636578288 = (new TypedArray(this,
                    new int[len*AssetManager.STYLE_NUM_ENTRIES],
                    new int[1+len], len));
        } //End block
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class NotFoundException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.471 -0400", hash_original_method = "16646BE2B605A836CC81C1207D23548C", hash_generated_method = "57BD6F9AE62C00D5DA005539BF3270C7")
        @DSModeled(DSC.SAFE)
        public NotFoundException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.471 -0400", hash_original_method = "4E6E00F1F6EDF0AE5B66F6F35CDBCBD1", hash_generated_method = "BDB857E13D90869A58E677611C9633BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NotFoundException(String name) {
            super(name);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
        }

        
    }


    
    public final class Theme {
        private AssetManager mAssets;
        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.472 -0400", hash_original_method = "795E489BE8D614A2CE03C4AA3DA2CC6B", hash_generated_method = "DE2990E2EA434BEC4D2996B4934FFFEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Theme() {
            mAssets = Resources.this.mAssets;
            mTheme = mAssets.createTheme();
            // ---------- Original Method ----------
            //mAssets = Resources.this.mAssets;
            //mTheme = mAssets.createTheme();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.472 -0400", hash_original_method = "DC72D253295A0467BBA777314F2243D9", hash_generated_method = "40EC05FD193E92A656E9727BC7193955")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void applyStyle(int resid, boolean force) {
            dsTaint.addTaint(resid);
            dsTaint.addTaint(force);
            AssetManager.applyThemeStyle(mTheme, resid, force);
            // ---------- Original Method ----------
            //AssetManager.applyThemeStyle(mTheme, resid, force);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.472 -0400", hash_original_method = "16C1EE1974E6C30AE0CF98F33344DBAC", hash_generated_method = "E974144424EFB3CB0DB3C01FD2F716E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setTo(Theme other) {
            dsTaint.addTaint(other.dsTaint);
            AssetManager.copyTheme(mTheme, other.mTheme);
            // ---------- Original Method ----------
            //AssetManager.copyTheme(mTheme, other.mTheme);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.472 -0400", hash_original_method = "810F63867177324D3683F3630D8FEF5A", hash_generated_method = "C3E7F125E0195F7E5DF52E42FAB298C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TypedArray obtainStyledAttributes(int[] attrs) {
            dsTaint.addTaint(attrs[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.473 -0400", hash_original_method = "09973A74CD9EB62806AFBCC15CD74823", hash_generated_method = "2231C31FC51C4E815FD30C94054E35C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TypedArray obtainStyledAttributes(int resid, int[] attrs) throws NotFoundException {
            dsTaint.addTaint(resid);
            dsTaint.addTaint(attrs[0]);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.474 -0400", hash_original_method = "1F1D15615A0F17B362A611476D650DBA", hash_generated_method = "2060DD678E132F2E9DC48F0697470463")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TypedArray obtainStyledAttributes(AttributeSet set,
                int[] attrs, int defStyleAttr, int defStyleRes) {
            dsTaint.addTaint(defStyleRes);
            dsTaint.addTaint(defStyleAttr);
            dsTaint.addTaint(attrs[0]);
            dsTaint.addTaint(set.dsTaint);
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
                    boolean var7FD042E7695005AA0C740C5D0A4B897B_330908203 = (i<set.getAttributeCount());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.475 -0400", hash_original_method = "CD4F3944F9E3B620EE3ED57C21E36085", hash_generated_method = "D1A17CF352487D3B01D768200B65E18D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.475 -0400", hash_original_method = "AE42D7A6EFA93EEFF71D2B911A492F1C", hash_generated_method = "202B18CB2B1A6DB4FBF606F5F9D696E0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dump(int priority, String tag, String prefix) {
            dsTaint.addTaint(tag);
            dsTaint.addTaint(priority);
            dsTaint.addTaint(prefix);
            AssetManager.dumpTheme(mTheme, priority, tag, prefix);
            // ---------- Original Method ----------
            //AssetManager.dumpTheme(mTheme, priority, tag, prefix);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.475 -0400", hash_original_method = "E91350A0CB8175C6CA6A8BD390A0B4B8", hash_generated_method = "DD94C395EE3AEC455738317133548F9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void finalize() throws Throwable {
            super.finalize();
            mAssets.releaseTheme(mTheme);
            // ---------- Original Method ----------
            //super.finalize();
            //mAssets.releaseTheme(mTheme);
        }

        
    }


    
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
    private static final LongSparseArray<Object> EMPTY_ARRAY = new LongSparseArray<Object>(0) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.475 -0400", hash_original_method = "EC6F1588621E6A8924E2C6C8C57E5DB6", hash_generated_method = "2CEB1BBDB1866C1C5EF1CDA76CE7C0CF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void put(long k, Object o) {
            dsTaint.addTaint(o.dsTaint);
            dsTaint.addTaint(k);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.476 -0400", hash_original_method = "2174303CAFCCF4D833BEBE6A819B3E43", hash_generated_method = "1F8B3E6C621122B2861BBA3A6BDA46B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void append(long k, Object o) {
            dsTaint.addTaint(o.dsTaint);
            dsTaint.addTaint(k);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
}; //Transformed anonymous class
}

