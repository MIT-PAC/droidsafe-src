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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.257 -0400", hash_original_field = "161FA5687A7D7AC4B9C9A80AF829FBD9", hash_generated_field = "3E9DE2CC62973C980770A1C51776F761")

    TypedValue mTmpValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.258 -0400", hash_original_field = "202292E83A615D844E11CCD7CCF1A376", hash_generated_field = "9D24B7F34F84AC01BB0E89B30BBD1790")

    Configuration mTmpConfig = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.258 -0400", hash_original_field = "9D7B0F08FC7C54174743A4521FC043A2", hash_generated_field = "7093A68C4FB20971BC57E41F4C1D5643")

    private LongSparseArray<WeakReference<Drawable.ConstantState> > mDrawableCache = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.258 -0400", hash_original_field = "51DD046E9AC370C2103D758104B80E50", hash_generated_field = "3884F8E47AC531FAA0750510FF2AF5A2")

    private SparseArray<WeakReference<ColorStateList> > mColorStateListCache = new SparseArray<WeakReference<ColorStateList> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.258 -0400", hash_original_field = "F161DDA26EE5ED9793C135FC39BE9C6F", hash_generated_field = "A4F42951342EE3E9717E4CBF74F8C9AC")

    private LongSparseArray<WeakReference<Drawable.ConstantState> > mColorDrawableCache = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.258 -0400", hash_original_field = "0BC1DFF6AFE13C970EF49F2E9FA5C4FD", hash_generated_field = "5259D7DBB68DFBC3AE42A15C0065F5F7")

    private boolean mPreloading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.258 -0400", hash_original_field = "89D3F63738C9A724185EC448004916DC", hash_generated_field = "7F4C1E655952669DB05D0D7D3EE40E92")

    TypedArray mCachedStyledAttributes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.258 -0400", hash_original_field = "E5D49A5A4CDDE1AFCA06E51894FF0368", hash_generated_field = "BB3486733E348C9268582EB8BBF07AF9")

    RuntimeException mLastRetrievedAttrs = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.259 -0400", hash_original_field = "97A118D20A0FE40FC781A018B8438459", hash_generated_field = "D7E7153558BB8F6EF13392C958C199F3")

    private int mLastCachedXmlBlockIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.259 -0400", hash_original_field = "93C6B32254224CA9474A2A3759E456B6", hash_generated_field = "40D793B9C0D667CC94631654C5F4C0A1")

    private int[] mCachedXmlBlockIds = { 0, 0, 0, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.259 -0400", hash_original_field = "28DE9458A56FFD64BDF6B0C7224854C3", hash_generated_field = "7A37676A79653CA9A6EF76D77895B3A8")

    private XmlBlock[] mCachedXmlBlocks = new XmlBlock[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.259 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "4C5448F642D7E098FE1B989A50398568")

    AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.259 -0400", hash_original_field = "31DF163B31592D80065FABA8640DBF8D", hash_generated_field = "3B723CFEE67B2FB67DE07D34DB4C294B")

    private Configuration mConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.259 -0400", hash_original_field = "D1926DAC9E8C0201638CA444B8D6B3EC", hash_generated_field = "86B3BC57B90084EEB437023CD43EAEE3")

    DisplayMetrics mMetrics = new DisplayMetrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.260 -0400", hash_original_field = "D36951E710CA961467B9F91283823B0B", hash_generated_field = "818136B22260098E65F6ED2716C3D72D")

    private NativePluralRules mPluralRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.260 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "D59F4BA3BF864567D7F711BF240A9A65")

    private CompatibilityInfo mCompatibilityInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.264 -0400", hash_original_method = "A1A5E1FE4CAABF0AED8ED513B68BEBB1", hash_generated_method = "AB3083BF23E0E878F9319E1FEBD9239D")
    public  Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config) {
        this(assets, metrics, config, (CompatibilityInfo) null);
        addTaint(assets.getTaint());
        addTaint(metrics.getTaint());
        addTaint(config.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.280 -0400", hash_original_method = "2B8ADFD0988160303F3DB857A23CF093", hash_generated_method = "7214819AEC9F2E48BFA69DC51A622BDC")
    public  Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config, CompatibilityInfo compInfo) {
        mAssets = assets;
        mMetrics.setToDefaults();
        mCompatibilityInfo = compInfo;
        updateConfiguration(config, metrics);
        assets.ensureStringBlocks();
        addTaint(metrics.getTaint());
        addTaint(config.getTaint());
        // ---------- Original Method ----------
        //mAssets = assets;
        //mMetrics.setToDefaults();
        //mCompatibilityInfo = compInfo;
        //updateConfiguration(config, metrics);
        //assets.ensureStringBlocks();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.295 -0400", hash_original_method = "647BD0141CFE00480058A00B761B8E30", hash_generated_method = "E7B264666C51F87CBE8DFE8E5E5422AA")
    private  Resources() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.311 -0400", hash_original_method = "ACC5D7202FC5E62E31E1054DCF0E5FCD", hash_generated_method = "4160B417E2D0F7D5ECBCBD279EA11A36")
    public CharSequence getText(int id) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_384259161 = null; //Variable for return #1
        CharSequence res;
        res = mAssets.getResourceText(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_384259161 = res;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_384259161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_384259161;
        // ---------- Original Method ----------
        //CharSequence res = mAssets.getResourceText(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("String resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.333 -0400", hash_original_method = "78A3DFDF860E06736217D448EF07FADF", hash_generated_method = "B490D81A9C860D8E4C205D1CCFAD50D0")
    public CharSequence getQuantityText(int id, int quantity) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1369648152 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2131660161 = null; //Variable for return #2
        NativePluralRules rule;
        rule = getPluralRule();
        CharSequence res;
        res = mAssets.getResourceBagText(id,
                attrForQuantityCode(rule.quantityForInt(quantity)));
        {
            varB4EAC82CA7396A68D541C85D26508E83_1369648152 = res;
        } //End block
        res = mAssets.getResourceBagText(id, ID_OTHER);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2131660161 = res;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Plural resource ID #0x" + Integer.toHexString(id)
                + " quantity=" + quantity
                + " item=" + stringForQuantityCode(rule.quantityForInt(quantity)));
        addTaint(id);
        addTaint(quantity);
        CharSequence varA7E53CE21691AB073D9660D615818899_326432715; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_326432715 = varB4EAC82CA7396A68D541C85D26508E83_1369648152;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_326432715 = varB4EAC82CA7396A68D541C85D26508E83_2131660161;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_326432715.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_326432715;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.352 -0400", hash_original_method = "1BFA20E87FBD429BB566BA0632D0EE62", hash_generated_method = "8E4F0D11526B0E3F15DB0F55E65E05BA")
    private NativePluralRules getPluralRule() {
        NativePluralRules varB4EAC82CA7396A68D541C85D26508E83_554255320 = null; //Variable for return #1
        {
            {
                mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_554255320 = mPluralRule;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_554255320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_554255320;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.358 -0400", hash_original_method = "537EFC002B8A40B3B7F76596758B9963", hash_generated_method = "6E78EF35F085DE081DF05F76F4689803")
    public String getString(int id) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1414364392 = null; //Variable for return #1
        CharSequence res;
        res = getText(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1414364392 = res.toString();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1414364392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1414364392;
        // ---------- Original Method ----------
        //CharSequence res = getText(id);
        //if (res != null) {
            //return res.toString();
        //}
        //throw new NotFoundException("String resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.371 -0400", hash_original_method = "2EEC36CFDBF61FC5501B8B9376C5F95E", hash_generated_method = "1288EDF001DEC6FB8E239546C4AAB16D")
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1490544506 = null; //Variable for return #1
        String raw;
        raw = getString(id);
        varB4EAC82CA7396A68D541C85D26508E83_1490544506 = String.format(mConfiguration.locale, raw, formatArgs);
        addTaint(id);
        addTaint(formatArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1490544506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1490544506;
        // ---------- Original Method ----------
        //String raw = getString(id);
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.390 -0400", hash_original_method = "3050F7A6F3C08BB33AB97951F94A1A35", hash_generated_method = "5EAEAAB6B7C67D4ACF4D1D6690D3E581")
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1574722451 = null; //Variable for return #1
        String raw;
        raw = getQuantityText(id, quantity).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1574722451 = String.format(mConfiguration.locale, raw, formatArgs);
        addTaint(id);
        addTaint(quantity);
        addTaint(formatArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1574722451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1574722451;
        // ---------- Original Method ----------
        //String raw = getQuantityText(id, quantity).toString();
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.392 -0400", hash_original_method = "81877842C4E2FEF0D9FCD2095374BD66", hash_generated_method = "496C508C5AFB0EB376EF5F5E0C71E15B")
    public String getQuantityString(int id, int quantity) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1032803208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1032803208 = getQuantityText(id, quantity).toString();
        addTaint(id);
        addTaint(quantity);
        varB4EAC82CA7396A68D541C85D26508E83_1032803208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1032803208;
        // ---------- Original Method ----------
        //return getQuantityText(id, quantity).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.411 -0400", hash_original_method = "9E76804CDFB0982D016B6CE6163D7455", hash_generated_method = "0E8CA8AF098EF7870E66B0EA4C8E1058")
    public CharSequence getText(int id, CharSequence def) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1396066638 = null; //Variable for return #1
        CharSequence res;
        res = mAssets.getResourceText(id);
        res = null;
        varB4EAC82CA7396A68D541C85D26508E83_1396066638 = res != null ? res : def;
        addTaint(id);
        addTaint(def.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1396066638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1396066638;
        // ---------- Original Method ----------
        //CharSequence res = id != 0 ? mAssets.getResourceText(id) : null;
        //return res != null ? res : def;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.417 -0400", hash_original_method = "2FECA5C28D9DC41170E2F1E5700277A0", hash_generated_method = "097607C2C95B7ABC317AF68E135630A8")
    public CharSequence[] getTextArray(int id) throws NotFoundException {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_2096411024 = null; //Variable for return #1
        CharSequence[] res;
        res = mAssets.getResourceTextArray(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2096411024 = res;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Text array resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_2096411024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2096411024;
        // ---------- Original Method ----------
        //CharSequence[] res = mAssets.getResourceTextArray(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("Text array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.418 -0400", hash_original_method = "426431DC420CF2DD39FFAF8B295D8654", hash_generated_method = "82FC12BF3400B6132B64B125F4DCD2A8")
    public String[] getStringArray(int id) throws NotFoundException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1679684328 = null; //Variable for return #1
        String[] res;
        res = mAssets.getResourceStringArray(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1679684328 = res;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String array resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1679684328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1679684328;
        // ---------- Original Method ----------
        //String[] res = mAssets.getResourceStringArray(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("String array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.439 -0400", hash_original_method = "65AEFB7747626FD934E6275803D2C392", hash_generated_method = "4AB8A77BB4CC2BE3881603D4DCF025FA")
    public int[] getIntArray(int id) throws NotFoundException {
        int[] res;
        res = mAssets.getArrayIntResource(id);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Int array resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1725818903 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1725818903;
        // ---------- Original Method ----------
        //int[] res = mAssets.getArrayIntResource(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("Int array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.458 -0400", hash_original_method = "8E5AB34336560F1D8FA12EC65FB34D2E", hash_generated_method = "52CA4039DA097CD399B0290B20F28537")
    public TypedArray obtainTypedArray(int id) throws NotFoundException {
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_1195845433 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1195845433 = array;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1195845433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1195845433;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.476 -0400", hash_original_method = "179671F1A37C23E822373A76E19D42EA", hash_generated_method = "93043C46B8868870444C1B68BD66FADE")
    public float getDimension(int id) throws NotFoundException {
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                float var3D1EF52544C26367510F308FBFEC9AF2_779636413 = (TypedValue.complexToDimension(value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        float var546ADE640B6EDFBC8A086EF31347E768_318794908 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_318794908;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.478 -0400", hash_original_method = "1833FD2ED6DCA9CF6DFDBF7D9BC0478B", hash_generated_method = "58A0901A3CB5139AABFC7CFBACA9DAF4")
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                int varC10E6C7CE4C18B2E8240388CE0B9D4D5_2110977421 = (TypedValue.complexToDimensionPixelOffset(
                        value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495533958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495533958;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.499 -0400", hash_original_method = "E2B2A30088D0238C29DEA7CD0218F3E5", hash_generated_method = "D90A514B8D46862C12D5FFD22293A696")
    public int getDimensionPixelSize(int id) throws NotFoundException {
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                int var618929EFC759B1CAECEF2B8755B3C586_796073394 = (TypedValue.complexToDimensionPixelSize(
                        value.data, mMetrics));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900248469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900248469;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.525 -0400", hash_original_method = "A2DCBF1A3DEF525CC233A65EC473B403", hash_generated_method = "13DD91CC52F34A63EFA3DAF5E739334D")
    public float getFraction(int id, int base, int pbase) {
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                float var32E1DB9737EBC4A230505D9C45C6217C_1677478593 = (TypedValue.complexToFraction(value.data, base, pbase));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        addTaint(base);
        addTaint(pbase);
        float var546ADE640B6EDFBC8A086EF31347E768_1009289075 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1009289075;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.527 -0400", hash_original_method = "40531A8693FC775C03E22F5835EB733B", hash_generated_method = "0E544747FB50E3ABF9F303FD4E69934D")
    public Drawable getDrawable(int id) throws NotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1675058362 = null; //Variable for return #1
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            varB4EAC82CA7396A68D541C85D26508E83_1675058362 = loadDrawable(value, id);
        } //End block
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1675058362.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1675058362;
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadDrawable(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.542 -0400", hash_original_method = "D08D33B833687D530F432098EC5CCB38", hash_generated_method = "8372AA7908E61E7EC322468BBAF88913")
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_616679199 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_616679199 = loadDrawable(value, id);
        } //End block
        addTaint(id);
        addTaint(density);
        varB4EAC82CA7396A68D541C85D26508E83_616679199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_616679199;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.563 -0400", hash_original_method = "973C0EDB6E14C8355746DA3A02A0EBD1", hash_generated_method = "28EB4998E126A2A0670C938836F1B4A8")
    public Movie getMovie(int id) throws NotFoundException {
        Movie varB4EAC82CA7396A68D541C85D26508E83_51657690 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_51657690 = movie;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_51657690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51657690;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.568 -0400", hash_original_method = "CDFC75613D2F871DC3B09D1CE60F98A4", hash_generated_method = "A2BE59ABCED84D4BCCCF9F07020D41A5")
    public int getColor(int id) throws NotFoundException {
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                ColorStateList csl;
                csl = loadColorStateList(mTmpValue, id);
                int var0BE21B049075D2C5C0B5387A1C4FC3D4_1350293010 = (csl.getDefaultColor());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799231098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799231098;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.587 -0400", hash_original_method = "F237EF4FA0AE2D448FCC64592DABDD8D", hash_generated_method = "5E1FDB83988568546638B3A8FE2128F8")
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1567685620 = null; //Variable for return #1
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            varB4EAC82CA7396A68D541C85D26508E83_1567685620 = loadColorStateList(value, id);
        } //End block
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1567685620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1567685620;
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadColorStateList(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.589 -0400", hash_original_method = "5C68CA666BA42061546BF98D8883861D", hash_generated_method = "065F4545FA9A3E35D045A0980E5BB6D6")
    public boolean getBoolean(int id) throws NotFoundException {
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176251070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_176251070;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.640 -0400", hash_original_method = "CB2B32F0600F2299579C79C7526A8896", hash_generated_method = "2E3E307CFF2266F70914BD8684AFFBD7")
    public int getInteger(int id) throws NotFoundException {
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013012821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013012821;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.648 -0400", hash_original_method = "53A788F1DE83214BAFCB022ED9363AAC", hash_generated_method = "AA9E9B01301E3616D8C645D06FA40586")
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1115286266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1115286266 = loadXmlResourceParser(id, "layout");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1115286266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1115286266;
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "layout");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.661 -0400", hash_original_method = "C3417F93CB7498AF5B43E94B98075C78", hash_generated_method = "CE79C732573ED4C951141DC21FDF1C66")
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_632615888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_632615888 = loadXmlResourceParser(id, "anim");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_632615888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_632615888;
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "anim");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.663 -0400", hash_original_method = "66568C58C76DE1C95FED15C8056E4335", hash_generated_method = "59BAD580A40782B00AA4AADBDC323FF5")
    public XmlResourceParser getXml(int id) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_5977386 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_5977386 = loadXmlResourceParser(id, "xml");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_5977386.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_5977386;
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.664 -0400", hash_original_method = "2A38C8042909AD0B3921F8B41C50BFD0", hash_generated_method = "ED3468D94C0543CDA72F7E2866C24396")
    public InputStream openRawResource(int id) throws NotFoundException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_16782559 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_16782559 = openRawResource(id, mTmpValue);
        } //End block
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_16782559.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_16782559;
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //return openRawResource(id, mTmpValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.673 -0400", hash_original_method = "2E256A4CBCC4636EC939F62266AB39BC", hash_generated_method = "48A84EF12EDCB17002C8DE450B535C8E")
    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_440593218 = null; //Variable for return #1
        getValue(id, value, true);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_440593218 = mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    AssetManager.ACCESS_STREAMING);
        } //End block
        catch (Exception e)
        {
            NotFoundException rnf;
            rnf = new NotFoundException("File " + value.string.toString() +
                    " from drawable resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw rnf;
        } //End block
        addTaint(id);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_440593218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_440593218;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.685 -0400", hash_original_method = "7A496359623417DAF484E4884A244E4E", hash_generated_method = "0CD7CA82AECF9D97946121745ED68F2F")
    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_632248070 = null; //Variable for return #1
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_632248070 = mAssets.openNonAssetFd(
                    value.assetCookie, value.string.toString());
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
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_632248070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_632248070;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.689 -0400", hash_original_method = "286538764BE9255E72B90D7B13646A2E", hash_generated_method = "EB4B0F9ECB9F802B654257A470B49A50")
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        boolean found;
        found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.700 -0400", hash_original_method = "FF0649F49CF780958319F2862D12B017", hash_generated_method = "91EBDC34D3B1F67CC3987DB971F7FA57")
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        boolean found;
        found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
        addTaint(id);
        addTaint(density);
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.701 -0400", hash_original_method = "A4F8C6B97749A99408C92371916352C6", hash_generated_method = "5185FDAE845C40C5F0BFACE862F949F9")
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        int id;
        id = getIdentifier(name, "string", null);
        {
            getValue(id, outValue, resolveRefs);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource name " + name);
        addTaint(name.getTaint());
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        // ---------- Original Method ----------
        //int id = getIdentifier(name, "string", null);
        //if (id != 0) {
            //getValue(id, outValue, resolveRefs);
            //return;
        //}
        //throw new NotFoundException("String resource name " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.708 -0400", hash_original_method = "89EA817324C2BD92A04D61539A7DF9A0", hash_generated_method = "6E8888A7B8B56D1F994BA05A1660E2CF")
    public final Theme newTheme() {
        Theme varB4EAC82CA7396A68D541C85D26508E83_1770179150 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1770179150 = new Theme();
        varB4EAC82CA7396A68D541C85D26508E83_1770179150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1770179150;
        // ---------- Original Method ----------
        //return new Theme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.728 -0400", hash_original_method = "D166D2286995B941AEE6CFA36445D894", hash_generated_method = "7BD30662D4CC9D084E2CAB3C10F4DFBB")
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_1538796478 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1538796478 = array;
        addTaint(set.getTaint());
        addTaint(attrs[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1538796478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1538796478;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.729 -0400", hash_original_method = "FADFD61D7F3DC00CFE83DECA8FAB375D", hash_generated_method = "E94702199A1A902DB0E98CCEE70C0FA8")
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics) {
        updateConfiguration(config, metrics, null);
        addTaint(config.getTaint());
        addTaint(metrics.getTaint());
        // ---------- Original Method ----------
        //updateConfiguration(config, metrics, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.797 -0400", hash_original_method = "FB9A4AAA762C456F245AEDCFD4C4194A", hash_generated_method = "F7B54FC1BFB40F39788DE042851B91BE")
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics, CompatibilityInfo compat) {
        {
            {
                mCompatibilityInfo = compat;
            } //End block
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
                    boolean varC89ED4BF7AB2BEFA099B67803FBEFA7B_1212367806 = (mConfiguration.locale.getCountry() != null);
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
        addTaint(metrics.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.816 -0400", hash_original_method = "6418DB8B9640192CDF0630899692D8E1", hash_generated_method = "032DB09DDC0271218AD1C98B7B41A18E")
    private void clearDrawableCache(
            LongSparseArray<WeakReference<ConstantState>> cache,
            int configChanges) {
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
                            boolean var9C0F2EE920A6529CD11D682CB4806601_651403572 = (Configuration.needNewResources(
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
        addTaint(cache.getTaint());
        addTaint(configChanges);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.822 -0400", hash_original_method = "7F0483A9A445222C6F2291914FFD169A", hash_generated_method = "E36B25A6F3AF225E505BEE19FC044062")
    public DisplayMetrics getDisplayMetrics() {
        DisplayMetrics varB4EAC82CA7396A68D541C85D26508E83_1294402479 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1294402479 = mMetrics;
        varB4EAC82CA7396A68D541C85D26508E83_1294402479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1294402479;
        // ---------- Original Method ----------
        //if (DEBUG_CONFIG) Slog.v(TAG, "Returning DisplayMetrics: " + mMetrics.widthPixels
                //+ "x" + mMetrics.heightPixels + " " + mMetrics.density);
        //return mMetrics;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.823 -0400", hash_original_method = "11CE3ED49D23B920A1DF6398548CD42B", hash_generated_method = "F396D66414DE10244C339864E9FFF6F5")
    public Configuration getConfiguration() {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_952478297 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_952478297 = mConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_952478297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_952478297;
        // ---------- Original Method ----------
        //return mConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.841 -0400", hash_original_method = "5C840D5EBF5D0071E35FFCF10BAAC7BF", hash_generated_method = "AC544784E64A546C536922C931F2FF45")
    public CompatibilityInfo getCompatibilityInfo() {
        CompatibilityInfo varB4EAC82CA7396A68D541C85D26508E83_214369473 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_214369473 = mCompatibilityInfo != null ? mCompatibilityInfo
                : CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_214369473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_214369473;
        // ---------- Original Method ----------
        //return mCompatibilityInfo != null ? mCompatibilityInfo
                //: CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.842 -0400", hash_original_method = "E88B36858B95AF9A2C7AEA9BE51A197A", hash_generated_method = "19A0C189ADB691DEF289F2CC535C7437")
    public void setCompatibilityInfo(CompatibilityInfo ci) {
        mCompatibilityInfo = ci;
        updateConfiguration(mConfiguration, mMetrics);
        // ---------- Original Method ----------
        //mCompatibilityInfo = ci;
        //updateConfiguration(mConfiguration, mMetrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.843 -0400", hash_original_method = "5502AEB950C0AF2288FDD25C0479AC75", hash_generated_method = "902FE0B8136C302D14A08A3258F9BD6A")
    public int getIdentifier(String name, String defType, String defPackage) {
        try 
        {
            int var0C5B23BCF8D28A28F4CE8567896762AC_45400371 = (Integer.parseInt(name));
        } //End block
        catch (Exception e)
        { }
        int var90A48CBEB3A052E5337E8C53FA9D4855_1257493015 = (mAssets.getResourceIdentifier(name, defType, defPackage));
        addTaint(name.getTaint());
        addTaint(defType.getTaint());
        addTaint(defPackage.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737962465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737962465;
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(name);
        //} catch (Exception e) {
        //}
        //return mAssets.getResourceIdentifier(name, defType, defPackage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.852 -0400", hash_original_method = "DE13C1A04BA835F16961D1CBF28A7683", hash_generated_method = "529365F35B6AB18E15FEA4F78C7C8667")
    public String getResourceName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_301361103 = null; //Variable for return #1
        String str;
        str = mAssets.getResourceName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_301361103 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_301361103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_301361103;
        // ---------- Original Method ----------
        //String str = mAssets.getResourceName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.865 -0400", hash_original_method = "B498C391BD57BD64150A95598D85C5A0", hash_generated_method = "7DCFA12C6DC74E626939735F668168F8")
    public String getResourcePackageName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1325133004 = null; //Variable for return #1
        String str;
        str = mAssets.getResourcePackageName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_1325133004 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_1325133004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1325133004;
        // ---------- Original Method ----------
        //String str = mAssets.getResourcePackageName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.866 -0400", hash_original_method = "29427E6B381809C5EA97546233CF8A82", hash_generated_method = "882D67FF2FBBBE8F24E3C69060A918EE")
    public String getResourceTypeName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1901867937 = null; //Variable for return #1
        String str;
        str = mAssets.getResourceTypeName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_1901867937 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_1901867937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1901867937;
        // ---------- Original Method ----------
        //String str = mAssets.getResourceTypeName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.880 -0400", hash_original_method = "5ED2928930BE3B5AB199F5456042FBFD", hash_generated_method = "90BDCDA697526576E684674EBC68B650")
    public String getResourceEntryName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_148109962 = null; //Variable for return #1
        String str;
        str = mAssets.getResourceEntryName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_148109962 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_148109962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_148109962;
        // ---------- Original Method ----------
        //String str = mAssets.getResourceEntryName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.907 -0400", hash_original_method = "545D8F55664B33539EC622970F1D1819", hash_generated_method = "8BDD24BD2D73B2C80DE8ABDB50C469AC")
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var49BAE650CF2F44016B0E4A15ECAD0A92_447396874 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String nodeName;
                nodeName = parser.getName();
                {
                    boolean var9B462BCA6AFE78346945C1C798AAB22C_198535732 = (nodeName.equals("extra"));
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
        addTaint(parser.getTaint());
        addTaint(outBundle.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.920 -0400", hash_original_method = "A47660356021C86DB26B06C4FCD54400", hash_generated_method = "D6E436029E39E94128A56C4237B698C8")
    public void parseBundleExtra(String tagName, AttributeSet attrs,
            Bundle outBundle) throws XmlPullParserException {
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
        addTaint(tagName.getTaint());
        addTaint(attrs.getTaint());
        addTaint(outBundle.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.921 -0400", hash_original_method = "B655DEE21C3816C25C0AC2AC9EDD1950", hash_generated_method = "D4FAE910B6B0F3ACF081734889EDD19D")
    public final AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_1318685094 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1318685094 = mAssets;
        varB4EAC82CA7396A68D541C85D26508E83_1318685094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1318685094;
        // ---------- Original Method ----------
        //return mAssets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.016 -0400", hash_original_method = "5E0B191196DA287D9E0DBDD23155512B", hash_generated_method = "87AD7C658E4503965A5E565EA2BFBB99")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.018 -0400", hash_original_method = "EFB6118AC43FED1C4435A31DA78431FB", hash_generated_method = "10F9907BD716A3B118F283BB2C069C41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.019 -0400", hash_original_method = "FF66D3DC188460C4E673EECA31B8D29B", hash_generated_method = "8F83DA2BD6ACD94787540573A1998010")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.096 -0400", hash_original_method = "2F02B67F3FD30AAC12B7734E2B09423F", hash_generated_method = "F7249316EF9820B4B45AA86E85979CD5")
     Drawable loadDrawable(TypedValue value, int id) throws NotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1959098776 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_493960626 = null; //Variable for return #2
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_1959098776 = dr;
        } //End block
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
                    boolean varE0987C6B5CC3DA09C3EAA5CE0FE23DAC_1922691544 = (file.endsWith(".xml"));
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
        varB4EAC82CA7396A68D541C85D26508E83_493960626 = dr;
        addTaint(value.getTaint());
        addTaint(id);
        Drawable varA7E53CE21691AB073D9660D615818899_1919431442; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1919431442 = varB4EAC82CA7396A68D541C85D26508E83_1959098776;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1919431442 = varB4EAC82CA7396A68D541C85D26508E83_493960626;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1919431442.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1919431442;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.109 -0400", hash_original_method = "134BDC10D8442526D2E686E53BA1531C", hash_generated_method = "9690D67CEB68CB8B4A26385F2B6949E0")
    private Drawable getCachedDrawable(
            LongSparseArray<WeakReference<ConstantState>> drawableCache,
            long key) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_987674624 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_531448936 = null; //Variable for return #2
        {
            WeakReference<Drawable.ConstantState> wr;
            wr = drawableCache.get(key);
            {
                Drawable.ConstantState entry;
                entry = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_987674624 = entry.newDrawable(this);
                } //End block
                {
                    drawableCache.delete(key);
                } //End block
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_531448936 = null;
        addTaint(drawableCache.getTaint());
        addTaint(key);
        Drawable varA7E53CE21691AB073D9660D615818899_644142591; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_644142591 = varB4EAC82CA7396A68D541C85D26508E83_987674624;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_644142591 = varB4EAC82CA7396A68D541C85D26508E83_531448936;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_644142591.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_644142591;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.144 -0400", hash_original_method = "035DC5FC794E074E6FAA3F20B34AB858", hash_generated_method = "2757AAB367435A372D430E640ACF64B6")
     ColorStateList loadColorStateList(TypedValue value, int id) throws NotFoundException {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_788863857 = null; //Variable for return #1
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_172093992 = null; //Variable for return #2
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_473615193 = null; //Variable for return #3
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1527203148 = null; //Variable for return #4
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_396807604 = null; //Variable for return #5
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
            {
                varB4EAC82CA7396A68D541C85D26508E83_788863857 = csl;
            } //End block
            csl = ColorStateList.valueOf(value.data);
            {
                mPreloadedColorStateLists.put(key, csl);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_172093992 = csl;
        } //End block
        csl = getCachedColorStateList(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_473615193 = csl;
        } //End block
        csl = mPreloadedColorStateLists.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1527203148 = csl;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource is not a ColorStateList (color or path): " + value);
        } //End block
        String file;
        file = value.string.toString();
        {
            boolean varD5B89D7D99AA05BDEB10746CCC3A990F_1333994566 = (file.endsWith(".xml"));
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
        varB4EAC82CA7396A68D541C85D26508E83_396807604 = csl;
        addTaint(value.getTaint());
        addTaint(id);
        ColorStateList varA7E53CE21691AB073D9660D615818899_577449631; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_577449631 = varB4EAC82CA7396A68D541C85D26508E83_788863857;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_577449631 = varB4EAC82CA7396A68D541C85D26508E83_172093992;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_577449631 = varB4EAC82CA7396A68D541C85D26508E83_473615193;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_577449631 = varB4EAC82CA7396A68D541C85D26508E83_1527203148;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_577449631 = varB4EAC82CA7396A68D541C85D26508E83_396807604;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_577449631.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_577449631;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.167 -0400", hash_original_method = "B7AA5737FC7D8937CDF4D069CBD3DB14", hash_generated_method = "C39F13C3B6594FA7BEC3C3514B032197")
    private ColorStateList getCachedColorStateList(int key) {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1330610209 = null; //Variable for return #1
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1534731370 = null; //Variable for return #2
        {
            WeakReference<ColorStateList> wr;
            wr = mColorStateListCache.get(key);
            {
                ColorStateList entry;
                entry = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1330610209 = entry;
                } //End block
                {
                    mColorStateListCache.delete(key);
                } //End block
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1534731370 = null;
        addTaint(key);
        ColorStateList varA7E53CE21691AB073D9660D615818899_1129375779; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1129375779 = varB4EAC82CA7396A68D541C85D26508E83_1330610209;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1129375779 = varB4EAC82CA7396A68D541C85D26508E83_1534731370;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1129375779.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1129375779;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.169 -0400", hash_original_method = "4C55C30B9C50C80710A05CFD192F83DB", hash_generated_method = "4CB0B44B0518CB3100C63D8BF966D3D0")
     XmlResourceParser loadXmlResourceParser(int id, String type) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1576737682 = null; //Variable for return #1
        {
            TypedValue value;
            value = mTmpValue;
            getValue(id, value, true);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1576737682 = loadXmlResourceParser(value.string.toString(), id,
                        value.assetCookie, type);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } //End block
        addTaint(id);
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1576737682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576737682;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.189 -0400", hash_original_method = "B570E59A2D87535635D1C6300E407B49", hash_generated_method = "8501A33C63156115EF3FF07C1BC4268F")
     XmlResourceParser loadXmlResourceParser(String file, int id,
            int assetCookie, String type) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1611245006 = null; //Variable for return #1
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_767248351 = null; //Variable for return #2
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
                                varB4EAC82CA7396A68D541C85D26508E83_1611245006 = mCachedXmlBlocks[i].newParser();
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
                        varB4EAC82CA7396A68D541C85D26508E83_767248351 = block.newParser();
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
        addTaint(file.getTaint());
        addTaint(assetCookie);
        addTaint(type.getTaint());
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_231188723; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_231188723 = varB4EAC82CA7396A68D541C85D26508E83_1611245006;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_231188723 = varB4EAC82CA7396A68D541C85D26508E83_767248351;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_231188723.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_231188723;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.213 -0400", hash_original_method = "EFFE2C2D7E798E7ABE4C38D3A3D2ED16", hash_generated_method = "B6B8E6107EA92D6BD90C16DA8D1CD1BC")
    private TypedArray getCachedStyledAttributes(int len) {
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_1441071164 = null; //Variable for return #1
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_826331451 = null; //Variable for return #2
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_1011466916 = null; //Variable for return #3
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
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1441071164 = attrs;
                } //End block
                attrs.mData = new int[fullLen];
                attrs.mIndices = new int[1+len];
                varB4EAC82CA7396A68D541C85D26508E83_826331451 = attrs;
            } //End block
            {
                RuntimeException here;
                here = new RuntimeException("here");
                here.fillInStackTrace();
                mLastRetrievedAttrs = here;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1011466916 = new TypedArray(this,
                    new int[len*AssetManager.STYLE_NUM_ENTRIES],
                    new int[1+len], len);
        } //End block
        addTaint(len);
        TypedArray varA7E53CE21691AB073D9660D615818899_1885526409; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1885526409 = varB4EAC82CA7396A68D541C85D26508E83_1441071164;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1885526409 = varB4EAC82CA7396A68D541C85D26508E83_826331451;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1885526409 = varB4EAC82CA7396A68D541C85D26508E83_1011466916;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1885526409.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1885526409;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class NotFoundException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.222 -0400", hash_original_method = "16646BE2B605A836CC81C1207D23548C", hash_generated_method = "57BD6F9AE62C00D5DA005539BF3270C7")
        public  NotFoundException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.223 -0400", hash_original_method = "4E6E00F1F6EDF0AE5B66F6F35CDBCBD1", hash_generated_method = "3B0DADC8F2E02A2F21624EB7BCDA9AFB")
        public  NotFoundException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public final class Theme {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.223 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

        private AssetManager mAssets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.223 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.228 -0400", hash_original_method = "795E489BE8D614A2CE03C4AA3DA2CC6B", hash_generated_method = "DE2990E2EA434BEC4D2996B4934FFFEF")
          Theme() {
            mAssets = Resources.this.mAssets;
            mTheme = mAssets.createTheme();
            // ---------- Original Method ----------
            //mAssets = Resources.this.mAssets;
            //mTheme = mAssets.createTheme();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.229 -0400", hash_original_method = "DC72D253295A0467BBA777314F2243D9", hash_generated_method = "6F00089DAD9B5AC538F6180D964E8265")
        public void applyStyle(int resid, boolean force) {
            AssetManager.applyThemeStyle(mTheme, resid, force);
            addTaint(resid);
            addTaint(force);
            // ---------- Original Method ----------
            //AssetManager.applyThemeStyle(mTheme, resid, force);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.236 -0400", hash_original_method = "16C1EE1974E6C30AE0CF98F33344DBAC", hash_generated_method = "DBC280FD1510E20895624E9132E857E0")
        public void setTo(Theme other) {
            AssetManager.copyTheme(mTheme, other.mTheme);
            addTaint(other.getTaint());
            // ---------- Original Method ----------
            //AssetManager.copyTheme(mTheme, other.mTheme);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.258 -0400", hash_original_method = "810F63867177324D3683F3630D8FEF5A", hash_generated_method = "28347DFA9BC19DDB6B01A48E07A229EB")
        public TypedArray obtainStyledAttributes(int[] attrs) {
            TypedArray varB4EAC82CA7396A68D541C85D26508E83_2058080695 = null; //Variable for return #1
            int len;
            len = attrs.length;
            TypedArray array;
            array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    array.mData, array.mIndices);
            varB4EAC82CA7396A68D541C85D26508E83_2058080695 = array;
            addTaint(attrs[0]);
            varB4EAC82CA7396A68D541C85D26508E83_2058080695.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2058080695;
            // ---------- Original Method ----------
            //int len = attrs.length;
            //TypedArray array = getCachedStyledAttributes(len);
            //array.mRsrcs = attrs;
            //AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    //array.mData, array.mIndices);
            //return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.296 -0400", hash_original_method = "09973A74CD9EB62806AFBCC15CD74823", hash_generated_method = "A5EEAAF3699A01685E6E44DD80F2AF5A")
        public TypedArray obtainStyledAttributes(int resid, int[] attrs) throws NotFoundException {
            TypedArray varB4EAC82CA7396A68D541C85D26508E83_390430005 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_390430005 = array;
            addTaint(resid);
            addTaint(attrs[0]);
            varB4EAC82CA7396A68D541C85D26508E83_390430005.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_390430005;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.351 -0400", hash_original_method = "1F1D15615A0F17B362A611476D650DBA", hash_generated_method = "5FD051687A1FA93A54D1BE91999B796B")
        public TypedArray obtainStyledAttributes(AttributeSet set,
                int[] attrs, int defStyleAttr, int defStyleRes) {
            TypedArray varB4EAC82CA7396A68D541C85D26508E83_1089350625 = null; //Variable for return #1
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
                    boolean var7FD042E7695005AA0C740C5D0A4B897B_410313041 = (i<set.getAttributeCount());
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
            varB4EAC82CA7396A68D541C85D26508E83_1089350625 = array;
            addTaint(set.getTaint());
            addTaint(attrs[0]);
            addTaint(defStyleAttr);
            addTaint(defStyleRes);
            varB4EAC82CA7396A68D541C85D26508E83_1089350625.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1089350625;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.368 -0400", hash_original_method = "CD4F3944F9E3B620EE3ED57C21E36085", hash_generated_method = "3854F4D569FE6E36952F4577FE07EF3E")
        public boolean resolveAttribute(int resid, TypedValue outValue,
                boolean resolveRefs) {
            boolean got;
            got = mAssets.getThemeValue(mTheme, resid, outValue, resolveRefs);
            {
                System.out.println(
                    "resolveAttribute #" + Integer.toHexString(resid)
                    + " got=" + got + ", type=0x" + Integer.toHexString(outValue.type)
                    + ", data=0x" + Integer.toHexString(outValue.data));
            } //End block
            addTaint(resid);
            addTaint(outValue.getTaint());
            addTaint(resolveRefs);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131135163 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131135163;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.369 -0400", hash_original_method = "AE42D7A6EFA93EEFF71D2B911A492F1C", hash_generated_method = "B281D1650257C007A55ABD7B29DD7B5A")
        public void dump(int priority, String tag, String prefix) {
            AssetManager.dumpTheme(mTheme, priority, tag, prefix);
            addTaint(priority);
            addTaint(tag.getTaint());
            addTaint(prefix.getTaint());
            // ---------- Original Method ----------
            //AssetManager.dumpTheme(mTheme, priority, tag, prefix);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.370 -0400", hash_original_method = "E91350A0CB8175C6CA6A8BD390A0B4B8", hash_generated_method = "DD94C395EE3AEC455738317133548F9E")
        protected void finalize() throws Throwable {
            super.finalize();
            mAssets.releaseTheme(mTheme);
            // ---------- Original Method ----------
            //super.finalize();
            //mAssets.releaseTheme(mTheme);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.370 -0400", hash_original_field = "FBDDF25CA08C49699D946174E1D868F3", hash_generated_field = "96372FF6BD72DC8C38A4F296AE86F213")

    static String TAG = "Resources";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.370 -0400", hash_original_field = "2138514A04DE3271E8E9762F986419AB", hash_generated_field = "5B59AF46D5CEF04694118A144D8DBEB6")

    private static boolean DEBUG_LOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "C01A6DA6C0D699DBFE9F550B03D3AA4B", hash_generated_field = "C9CBF9F56764DA1A37465C620388FF3E")

    private static boolean DEBUG_CONFIG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "C9B635C9AE5915C59B3A508759AB54C2", hash_generated_field = "352F269EFFECC25ED3730895CD29944C")

    private static boolean DEBUG_ATTRIBUTES_CACHE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "06CFFA21769AA1FA0FE0B7C5AF8F4325", hash_generated_field = "EC5670C8AA774A6EA9BD4CC861ED1821")

    private static boolean TRACE_FOR_PRELOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "87FE77338788D21010DBC3495A87EB5C", hash_generated_field = "DF39E62D76DA272E56145EA5CC2B9703")

    private static boolean TRACE_FOR_MISS_PRELOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "15DFB0BA3D576A15F2D6FA24B909E58F", hash_generated_field = "4B97B5683684E69D106F3D2B45B27D87")

    private static int ID_OTHER = 0x01000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "970570067DE920513CAE0F2F1EADAB71")

    private static Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "F4CCCEAC2DC610511BAB2E064360578D", hash_generated_field = "B0DD5DC72B0C526323B11A6CF67A9E4F")

    static Resources mSystem = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "28D6C8EDE085F2666953D9B90C99AD3C", hash_generated_field = "FF24E51221D1ACA88320F9F9ACD5C2B6")

    private static LongSparseArray<Drawable.ConstantState> sPreloadedDrawables = new LongSparseArray<Drawable.ConstantState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.371 -0400", hash_original_field = "3053E35008A7FD238184E0C03BA1EE61", hash_generated_field = "0612070051C7BE543C93F7F0113679C4")

    private static SparseArray<ColorStateList> mPreloadedColorStateLists = new SparseArray<ColorStateList>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.372 -0400", hash_original_field = "8E30D292A97994C9D3BC6014424134D6", hash_generated_field = "5B6E76327E8CA797FF0E6D13DADF718D")

    private static LongSparseArray<Drawable.ConstantState> sPreloadedColorDrawables = new LongSparseArray<Drawable.ConstantState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.372 -0400", hash_original_field = "95F22ABFA5F2E9DF18A53D3B9A50C37A", hash_generated_field = "C895D84621E3994464E604D55CAE67F1")

    private static boolean mPreloaded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.395 -0400", hash_original_field = "0A7FD3BBEB39B9BB1CCAF8BFE6DFE873", hash_generated_field = "7C235ACE2CCB48DF238707B6349F0A1B")

    private static LongSparseArray<Object> EMPTY_ARRAY = new LongSparseArray<Object>(0) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.372 -0400", hash_original_method = "EC6F1588621E6A8924E2C6C8C57E5DB6", hash_generated_method = "274A5DB79B96D2D45ACCFE2BB16172BF")
        @Override
        public void put(long k, Object o) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(k);
            addTaint(o.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.395 -0400", hash_original_method = "2174303CAFCCF4D833BEBE6A819B3E43", hash_generated_method = "8B6A2668BF9A3FED75E8A97AC129C9EE")
        @Override
        public void append(long k, Object o) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(k);
            addTaint(o.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
};
}

