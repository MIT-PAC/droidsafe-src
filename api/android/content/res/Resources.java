package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.330 -0400", hash_original_field = "161FA5687A7D7AC4B9C9A80AF829FBD9", hash_generated_field = "F4896FA60EAF46F89D1B23DB39A94469")

    final TypedValue mTmpValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.330 -0400", hash_original_field = "202292E83A615D844E11CCD7CCF1A376", hash_generated_field = "914D1123EB75F882952E0A98C7FB0DC2")

    final Configuration mTmpConfig = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.330 -0400", hash_original_field = "9D7B0F08FC7C54174743A4521FC043A2", hash_generated_field = "2497447FAB09A4CFB8FC865DC436A822")

    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mDrawableCache = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.330 -0400", hash_original_field = "51DD046E9AC370C2103D758104B80E50", hash_generated_field = "933772720D2EC5433FC43B2D14875AB3")

    private final SparseArray<WeakReference<ColorStateList> > mColorStateListCache = new SparseArray<WeakReference<ColorStateList> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.330 -0400", hash_original_field = "F161DDA26EE5ED9793C135FC39BE9C6F", hash_generated_field = "7B6BE91A39836F0EC0472965B013125A")

    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mColorDrawableCache = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "0BC1DFF6AFE13C970EF49F2E9FA5C4FD", hash_generated_field = "5259D7DBB68DFBC3AE42A15C0065F5F7")

    private boolean mPreloading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "89D3F63738C9A724185EC448004916DC", hash_generated_field = "7F4C1E655952669DB05D0D7D3EE40E92")

    TypedArray mCachedStyledAttributes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "E5D49A5A4CDDE1AFCA06E51894FF0368", hash_generated_field = "BB3486733E348C9268582EB8BBF07AF9")

    RuntimeException mLastRetrievedAttrs = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "97A118D20A0FE40FC781A018B8438459", hash_generated_field = "D7E7153558BB8F6EF13392C958C199F3")

    private int mLastCachedXmlBlockIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "93C6B32254224CA9474A2A3759E456B6", hash_generated_field = "279259CEA3B9EA7BE3315FDEF65F4C2B")

    private final int[] mCachedXmlBlockIds = { 0, 0, 0, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "28DE9458A56FFD64BDF6B0C7224854C3", hash_generated_field = "8B8D941C6918446EE4A5194B99D8AA93")

    private final XmlBlock[] mCachedXmlBlocks = new XmlBlock[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "4C5448F642D7E098FE1B989A50398568")

    AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "31DF163B31592D80065FABA8640DBF8D", hash_generated_field = "A59DFC0CAA3A3B58227151AEDB308CC4")

    private final Configuration mConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "D1926DAC9E8C0201638CA444B8D6B3EC", hash_generated_field = "67B89A314350924017B72D96E300AA50")

    final DisplayMetrics mMetrics = new DisplayMetrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.331 -0400", hash_original_field = "D36951E710CA961467B9F91283823B0B", hash_generated_field = "818136B22260098E65F6ED2716C3D72D")

    private NativePluralRules mPluralRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.332 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "D59F4BA3BF864567D7F711BF240A9A65")

    private CompatibilityInfo mCompatibilityInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.332 -0400", hash_original_method = "A1A5E1FE4CAABF0AED8ED513B68BEBB1", hash_generated_method = "B4A87B330D0E2D6F616D5A826AF30A0A")
    public  Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config) {
        this(assets, metrics, config, (CompatibilityInfo) null);
        addTaint(config.getTaint());
        addTaint(metrics.getTaint());
        addTaint(assets.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.333 -0400", hash_original_method = "2B8ADFD0988160303F3DB857A23CF093", hash_generated_method = "A32A77B7C62ADFD325F23EA9ECAD704E")
    public  Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config, CompatibilityInfo compInfo) {
        addTaint(config.getTaint());
        addTaint(metrics.getTaint());
        mAssets = assets;
        mMetrics.setToDefaults();
        mCompatibilityInfo = compInfo;
        updateConfiguration(config, metrics);
        assets.ensureStringBlocks();
        // ---------- Original Method ----------
        //mAssets = assets;
        //mMetrics.setToDefaults();
        //mCompatibilityInfo = compInfo;
        //updateConfiguration(config, metrics);
        //assets.ensureStringBlocks();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.334 -0400", hash_original_method = "647BD0141CFE00480058A00B761B8E30", hash_generated_method = "E7B264666C51F87CBE8DFE8E5E5422AA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.336 -0400", hash_original_method = "ACC5D7202FC5E62E31E1054DCF0E5FCD", hash_generated_method = "BB1F9C1D0CBA43B4DF94A0A98D3955B8")
    public CharSequence getText(int id) throws NotFoundException {
        addTaint(id);
        CharSequence res = mAssets.getResourceText(id);
    if(res != null)        
        {
CharSequence varB5053E025797B3BF768F5C37934C244D_2143839192 =             res;
            varB5053E025797B3BF768F5C37934C244D_2143839192.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_2143839192;
        } //End block
        NotFoundException varE0085D40392FB2613DAEF3934068E026_811957216 = new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        varE0085D40392FB2613DAEF3934068E026_811957216.addTaint(taint);
        throw varE0085D40392FB2613DAEF3934068E026_811957216;
        // ---------- Original Method ----------
        //CharSequence res = mAssets.getResourceText(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("String resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.336 -0400", hash_original_method = "78A3DFDF860E06736217D448EF07FADF", hash_generated_method = "047CF7FEA9DF857314FD821176ADEE70")
    public CharSequence getQuantityText(int id, int quantity) throws NotFoundException {
        addTaint(quantity);
        addTaint(id);
        NativePluralRules rule = getPluralRule();
        CharSequence res = mAssets.getResourceBagText(id,
                attrForQuantityCode(rule.quantityForInt(quantity)));
    if(res != null)        
        {
CharSequence varB5053E025797B3BF768F5C37934C244D_1877167152 =             res;
            varB5053E025797B3BF768F5C37934C244D_1877167152.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_1877167152;
        } //End block
        res = mAssets.getResourceBagText(id, ID_OTHER);
    if(res != null)        
        {
CharSequence varB5053E025797B3BF768F5C37934C244D_1783272470 =             res;
            varB5053E025797B3BF768F5C37934C244D_1783272470.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_1783272470;
        } //End block
        NotFoundException var4BA47AC02A8A9389851CB1F47DA6C53F_1102358653 = new NotFoundException("Plural resource ID #0x" + Integer.toHexString(id)
                + " quantity=" + quantity
                + " item=" + stringForQuantityCode(rule.quantityForInt(quantity)));
        var4BA47AC02A8A9389851CB1F47DA6C53F_1102358653.addTaint(taint);
        throw var4BA47AC02A8A9389851CB1F47DA6C53F_1102358653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.337 -0400", hash_original_method = "1BFA20E87FBD429BB566BA0632D0EE62", hash_generated_method = "FB73901FB43667F4735A81AC1F17FF84")
    private NativePluralRules getPluralRule() {
        synchronized
(mSync)        {
    if(mPluralRule == null)            
            {
                mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
            } //End block
NativePluralRules var745A77A9F3BF173FE40F422A3E58ECD9_1752090615 =             mPluralRule;
            var745A77A9F3BF173FE40F422A3E58ECD9_1752090615.addTaint(taint);
            return var745A77A9F3BF173FE40F422A3E58ECD9_1752090615;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.338 -0400", hash_original_method = "537EFC002B8A40B3B7F76596758B9963", hash_generated_method = "75E70AA3D76934DF49D1751EC912A2AC")
    public String getString(int id) throws NotFoundException {
        addTaint(id);
        CharSequence res = getText(id);
    if(res != null)        
        {
String varEC7EB75EF3C7FA633C54FC66A0358174_1685034216 =             res.toString();
            varEC7EB75EF3C7FA633C54FC66A0358174_1685034216.addTaint(taint);
            return varEC7EB75EF3C7FA633C54FC66A0358174_1685034216;
        } //End block
        NotFoundException varE0085D40392FB2613DAEF3934068E026_1326143524 = new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        varE0085D40392FB2613DAEF3934068E026_1326143524.addTaint(taint);
        throw varE0085D40392FB2613DAEF3934068E026_1326143524;
        // ---------- Original Method ----------
        //CharSequence res = getText(id);
        //if (res != null) {
            //return res.toString();
        //}
        //throw new NotFoundException("String resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.338 -0400", hash_original_method = "2EEC36CFDBF61FC5501B8B9376C5F95E", hash_generated_method = "9977637E3F9B06C27AE99F8DB55E5D74")
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        addTaint(formatArgs[0].getTaint());
        addTaint(id);
        String raw = getString(id);
String var33B19924FA3F9D0E8B5FFBC42817D886_1020820910 =         String.format(mConfiguration.locale, raw, formatArgs);
        var33B19924FA3F9D0E8B5FFBC42817D886_1020820910.addTaint(taint);
        return var33B19924FA3F9D0E8B5FFBC42817D886_1020820910;
        // ---------- Original Method ----------
        //String raw = getString(id);
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.339 -0400", hash_original_method = "3050F7A6F3C08BB33AB97951F94A1A35", hash_generated_method = "4A3D1622923A8F2C2FD1E9B12D27D54C")
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws NotFoundException {
        addTaint(formatArgs[0].getTaint());
        addTaint(quantity);
        addTaint(id);
        String raw = getQuantityText(id, quantity).toString();
String var33B19924FA3F9D0E8B5FFBC42817D886_304133799 =         String.format(mConfiguration.locale, raw, formatArgs);
        var33B19924FA3F9D0E8B5FFBC42817D886_304133799.addTaint(taint);
        return var33B19924FA3F9D0E8B5FFBC42817D886_304133799;
        // ---------- Original Method ----------
        //String raw = getQuantityText(id, quantity).toString();
        //return String.format(mConfiguration.locale, raw, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.339 -0400", hash_original_method = "81877842C4E2FEF0D9FCD2095374BD66", hash_generated_method = "5FD6B865A0525487AE9143FC6F570166")
    public String getQuantityString(int id, int quantity) throws NotFoundException {
        addTaint(quantity);
        addTaint(id);
String var724E61EC080BBFF977358DDD6A3D5CFA_180376338 =         getQuantityText(id, quantity).toString();
        var724E61EC080BBFF977358DDD6A3D5CFA_180376338.addTaint(taint);
        return var724E61EC080BBFF977358DDD6A3D5CFA_180376338;
        // ---------- Original Method ----------
        //return getQuantityText(id, quantity).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.339 -0400", hash_original_method = "9E76804CDFB0982D016B6CE6163D7455", hash_generated_method = "F8A9492A3911DD170437D0C09A095B82")
    public CharSequence getText(int id, CharSequence def) {
        addTaint(def.getTaint());
        addTaint(id);
        CharSequence res = id != 0 ? mAssets.getResourceText(id) : null;
CharSequence varA3751E1BC5C02A90C35BA3618166E18D_1074463723 =         res != null ? res : def;
        varA3751E1BC5C02A90C35BA3618166E18D_1074463723.addTaint(taint);
        return varA3751E1BC5C02A90C35BA3618166E18D_1074463723;
        // ---------- Original Method ----------
        //CharSequence res = id != 0 ? mAssets.getResourceText(id) : null;
        //return res != null ? res : def;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.340 -0400", hash_original_method = "2FECA5C28D9DC41170E2F1E5700277A0", hash_generated_method = "13481085FA4B8BD3175A831445924962")
    public CharSequence[] getTextArray(int id) throws NotFoundException {
        addTaint(id);
        CharSequence[] res = mAssets.getResourceTextArray(id);
    if(res != null)        
        {
CharSequence[] varB5053E025797B3BF768F5C37934C244D_1512228008 =             res;
            varB5053E025797B3BF768F5C37934C244D_1512228008.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_1512228008;
        } //End block
        NotFoundException var5965039A559935BFCA88FA708EA1E1C6_294779293 = new NotFoundException("Text array resource ID #0x"
                                    + Integer.toHexString(id));
        var5965039A559935BFCA88FA708EA1E1C6_294779293.addTaint(taint);
        throw var5965039A559935BFCA88FA708EA1E1C6_294779293;
        // ---------- Original Method ----------
        //CharSequence[] res = mAssets.getResourceTextArray(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("Text array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.340 -0400", hash_original_method = "426431DC420CF2DD39FFAF8B295D8654", hash_generated_method = "64F7FACAFDA86B9F16601E9EE6F8575A")
    public String[] getStringArray(int id) throws NotFoundException {
        addTaint(id);
        String[] res = mAssets.getResourceStringArray(id);
    if(res != null)        
        {
String[] varB5053E025797B3BF768F5C37934C244D_1173643059 =             res;
            varB5053E025797B3BF768F5C37934C244D_1173643059.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_1173643059;
        } //End block
        NotFoundException varE0433E8524EC13EA9C297BAF1B89BF41_1476228296 = new NotFoundException("String array resource ID #0x"
                                    + Integer.toHexString(id));
        varE0433E8524EC13EA9C297BAF1B89BF41_1476228296.addTaint(taint);
        throw varE0433E8524EC13EA9C297BAF1B89BF41_1476228296;
        // ---------- Original Method ----------
        //String[] res = mAssets.getResourceStringArray(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("String array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.341 -0400", hash_original_method = "65AEFB7747626FD934E6275803D2C392", hash_generated_method = "4D73BE01DC8489B750C658B8F3FF4282")
    public int[] getIntArray(int id) throws NotFoundException {
        addTaint(id);
        int[] res = mAssets.getArrayIntResource(id);
    if(res != null)        
        {
            int[] var9B207167E5381C47682C6B4F58A623FB_1219399412 = (res);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1086467011 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1086467011;
        } //End block
        NotFoundException var6713FAC2C958BD66CD3EA57ABAC2539F_551347200 = new NotFoundException("Int array resource ID #0x"
                                    + Integer.toHexString(id));
        var6713FAC2C958BD66CD3EA57ABAC2539F_551347200.addTaint(taint);
        throw var6713FAC2C958BD66CD3EA57ABAC2539F_551347200;
        // ---------- Original Method ----------
        //int[] res = mAssets.getArrayIntResource(id);
        //if (res != null) {
            //return res;
        //}
        //throw new NotFoundException("Int array resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.341 -0400", hash_original_method = "8E5AB34336560F1D8FA12EC65FB34D2E", hash_generated_method = "183F8E5F4E19534AB199F002D4E7E757")
    public TypedArray obtainTypedArray(int id) throws NotFoundException {
        addTaint(id);
        int len = mAssets.getArraySize(id);
    if(len < 0)        
        {
            NotFoundException var5C69B6F37BC93B802AC1196D54057F11_1646320774 = new NotFoundException("Array resource ID #0x"
                                        + Integer.toHexString(id));
            var5C69B6F37BC93B802AC1196D54057F11_1646320774.addTaint(taint);
            throw var5C69B6F37BC93B802AC1196D54057F11_1646320774;
        } //End block
        TypedArray array = getCachedStyledAttributes(len);
        array.mLength = mAssets.retrieveArray(id, array.mData);
        array.mIndices[0] = 0;
TypedArray var1270D5B74B756F17D644A15D775499D9_1373708778 =         array;
        var1270D5B74B756F17D644A15D775499D9_1373708778.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_1373708778;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.342 -0400", hash_original_method = "179671F1A37C23E822373A76E19D42EA", hash_generated_method = "FC912077233B8C0AC32458B66F3CAD8D")
    public float getDimension(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type == TypedValue.TYPE_DIMENSION)            
            {
                float varF91680FE3907B1ABB421D771E28EB660_822668121 = (TypedValue.complexToDimension(value.data, mMetrics));
                                float var546ADE640B6EDFBC8A086EF31347E768_1453736100 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1453736100;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_1261935495 = new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_1261935495.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_1261935495;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.342 -0400", hash_original_method = "1833FD2ED6DCA9CF6DFDBF7D9BC0478B", hash_generated_method = "10D2867BBC68B186FEE2992E5FDD9CBF")
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type == TypedValue.TYPE_DIMENSION)            
            {
                int varCC0C1F384589CECCD0D384825FE3C447_613236172 = (TypedValue.complexToDimensionPixelOffset(
                        value.data, mMetrics));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722474733 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722474733;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_1084018451 = new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_1084018451.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_1084018451;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.343 -0400", hash_original_method = "E2B2A30088D0238C29DEA7CD0218F3E5", hash_generated_method = "08569E7AA695CCBAE354B81052AB4686")
    public int getDimensionPixelSize(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type == TypedValue.TYPE_DIMENSION)            
            {
                int var3AA299EC98BEBFB79D0D183AE6613AE3_470163054 = (TypedValue.complexToDimensionPixelSize(
                        value.data, mMetrics));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_858656446 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_858656446;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_1458346992 = new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_1458346992.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_1458346992;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.344 -0400", hash_original_method = "A2DCBF1A3DEF525CC233A65EC473B403", hash_generated_method = "55F038FA89D5F6C6A358132469B0E5B2")
    public float getFraction(int id, int base, int pbase) {
        addTaint(pbase);
        addTaint(base);
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type == TypedValue.TYPE_FRACTION)            
            {
                float varB5A3603C30C7E89CF66B55CD9B09D0C0_1320856230 = (TypedValue.complexToFraction(value.data, base, pbase));
                                float var546ADE640B6EDFBC8A086EF31347E768_1446560476 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1446560476;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_345308445 = new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_345308445.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_345308445;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.344 -0400", hash_original_method = "40531A8693FC775C03E22F5835EB733B", hash_generated_method = "7BC670C8F8210D0913BC9B3D5083B335")
    public Drawable getDrawable(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
Drawable var8273798533EF7C8CE47A48774686B041_1495391045 =             loadDrawable(value, id);
            var8273798533EF7C8CE47A48774686B041_1495391045.addTaint(taint);
            return var8273798533EF7C8CE47A48774686B041_1495391045;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadDrawable(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.346 -0400", hash_original_method = "D08D33B833687D530F432098EC5CCB38", hash_generated_method = "7C1B3EC080C39BAC516CE7A27F83B19B")
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        addTaint(density);
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValueForDensity(id, density, value, true);
    if(value.density > 0 && value.density != TypedValue.DENSITY_NONE)            
            {
    if(value.density == density)                
                {
                    value.density = DisplayMetrics.DENSITY_DEVICE;
                } //End block
                else
                {
                    value.density = (value.density * DisplayMetrics.DENSITY_DEVICE) / density;
                } //End block
            } //End block
Drawable var8273798533EF7C8CE47A48774686B041_1535339167 =             loadDrawable(value, id);
            var8273798533EF7C8CE47A48774686B041_1535339167.addTaint(taint);
            return var8273798533EF7C8CE47A48774686B041_1535339167;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.346 -0400", hash_original_method = "973C0EDB6E14C8355746DA3A02A0EBD1", hash_generated_method = "22A1168EAC7B4CA50A0720BDAA42CE07")
    public Movie getMovie(int id) throws NotFoundException {
        addTaint(id);
        InputStream is = openRawResource(id);
        Movie movie = Movie.decodeStream(is);
        try 
        {
            is.close();
        } //End block
        catch (java.io.IOException e)
        {
        } //End block
Movie var3EEC64298AA85EC99C654E377AAC0920_1496456820 =         movie;
        var3EEC64298AA85EC99C654E377AAC0920_1496456820.addTaint(taint);
        return var3EEC64298AA85EC99C654E377AAC0920_1496456820;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.347 -0400", hash_original_method = "CDFC75613D2F871DC3B09D1CE60F98A4", hash_generated_method = "14E32EB34FE2CA5A8C8C5FAF9B870107")
    public int getColor(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT)            
            {
                int var9EA7D1AE0B8AB85DCFC0E9C1CA360621_2116487119 = (value.data);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676308393 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_676308393;
            } //End block
            else
    if(value.type == TypedValue.TYPE_STRING)            
            {
                ColorStateList csl = loadColorStateList(mTmpValue, id);
                int var90DA607A89399855C664ACB81336CEB7_2006730122 = (csl.getDefaultColor());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860168451 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860168451;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_650927871 = new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_650927871.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_650927871;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.348 -0400", hash_original_method = "F237EF4FA0AE2D448FCC64592DABDD8D", hash_generated_method = "376EDB6F9D9F1C84BA7B99150A778B81")
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
ColorStateList var8F0C404272DDD9BC21D5C9ECE71B2946_1781575653 =             loadColorStateList(value, id);
            var8F0C404272DDD9BC21D5C9ECE71B2946_1781575653.addTaint(taint);
            return var8F0C404272DDD9BC21D5C9ECE71B2946_1781575653;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //TypedValue value = mTmpValue;
            //getValue(id, value, true);
            //return loadColorStateList(value, id);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.348 -0400", hash_original_method = "5C68CA666BA42061546BF98D8883861D", hash_generated_method = "61EF4C36FA22401ECDEDA9FF2856BB35")
    public boolean getBoolean(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT)            
            {
                boolean varD493A58600CCEFA959CE59A2D99DAC9A_918040907 = (value.data != 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301376410 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_301376410;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_704632292 = new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_704632292.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_704632292;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.349 -0400", hash_original_method = "CB2B32F0600F2299579C79C7526A8896", hash_generated_method = "BF0DC76EAA498823148D8266C5D152B6")
    public int getInteger(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT)            
            {
                int var9EA7D1AE0B8AB85DCFC0E9C1CA360621_1013571597 = (value.data);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185218091 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185218091;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_371063833 = new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_371063833.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_371063833;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.349 -0400", hash_original_method = "53A788F1DE83214BAFCB022ED9363AAC", hash_generated_method = "1E22E9C39084A6316CC5BAA2DAAE1435")
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        addTaint(id);
XmlResourceParser var6DD4D2CF915780284DEA58D4D0825D56_1553343660 =         loadXmlResourceParser(id, "layout");
        var6DD4D2CF915780284DEA58D4D0825D56_1553343660.addTaint(taint);
        return var6DD4D2CF915780284DEA58D4D0825D56_1553343660;
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "layout");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.350 -0400", hash_original_method = "C3417F93CB7498AF5B43E94B98075C78", hash_generated_method = "E81B106C56866ACCBE601E7865559102")
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        addTaint(id);
XmlResourceParser var88FEBEC60FCAA9E9B7093A5C94ED312C_296910453 =         loadXmlResourceParser(id, "anim");
        var88FEBEC60FCAA9E9B7093A5C94ED312C_296910453.addTaint(taint);
        return var88FEBEC60FCAA9E9B7093A5C94ED312C_296910453;
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "anim");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.350 -0400", hash_original_method = "66568C58C76DE1C95FED15C8056E4335", hash_generated_method = "8388320D2ECB4D8C3078D360728396E6")
    public XmlResourceParser getXml(int id) throws NotFoundException {
        addTaint(id);
XmlResourceParser var55A3A1C774FCD88CFA6C7AED76ED12F3_1244772515 =         loadXmlResourceParser(id, "xml");
        var55A3A1C774FCD88CFA6C7AED76ED12F3_1244772515.addTaint(taint);
        return var55A3A1C774FCD88CFA6C7AED76ED12F3_1244772515;
        // ---------- Original Method ----------
        //return loadXmlResourceParser(id, "xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.351 -0400", hash_original_method = "2A38C8042909AD0B3921F8B41C50BFD0", hash_generated_method = "75EEA16BD23EB78533C72AF111FD7F13")
    public InputStream openRawResource(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
InputStream var88537B797D5D9430D1F565B1E6499441_301687808 =             openRawResource(id, mTmpValue);
            var88537B797D5D9430D1F565B1E6499441_301687808.addTaint(taint);
            return var88537B797D5D9430D1F565B1E6499441_301687808;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mTmpValue) {
            //return openRawResource(id, mTmpValue);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.351 -0400", hash_original_method = "2E256A4CBCC4636EC939F62266AB39BC", hash_generated_method = "CE0EC914B163DBCB0A1BDE49BAD1BF11")
    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        addTaint(value.getTaint());
        addTaint(id);
        getValue(id, value, true);
        try 
        {
InputStream var4BD66E3715CE0A3782D091D65F0C6E2B_456570427 =             mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    AssetManager.ACCESS_STREAMING);
            var4BD66E3715CE0A3782D091D65F0C6E2B_456570427.addTaint(taint);
            return var4BD66E3715CE0A3782D091D65F0C6E2B_456570427;
        } //End block
        catch (Exception e)
        {
            NotFoundException rnf = new NotFoundException("File " + value.string.toString() +
                    " from drawable resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(e);
            rnf.addTaint(taint);
            throw rnf;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.352 -0400", hash_original_method = "7A496359623417DAF484E4884A244E4E", hash_generated_method = "100F20D1A1E5B66F22A9840CB0B46F25")
    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            try 
            {
AssetFileDescriptor varDAEC0B14551BAA3E5AD806065109B0A4_1259816327 =                 mAssets.openNonAssetFd(
                    value.assetCookie, value.string.toString());
                varDAEC0B14551BAA3E5AD806065109B0A4_1259816327.addTaint(taint);
                return varDAEC0B14551BAA3E5AD806065109B0A4_1259816327;
            } //End block
            catch (Exception e)
            {
                NotFoundException rnf = new NotFoundException(
                    "File " + value.string.toString()
                    + " from drawable resource ID #0x"
                    + Integer.toHexString(id));
                rnf.initCause(e);
                rnf.addTaint(taint);
                throw rnf;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.353 -0400", hash_original_method = "286538764BE9255E72B90D7B13646A2E", hash_generated_method = "3278968553D0EE906D4FB355C0D8F56F")
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        addTaint(resolveRefs);
        addTaint(outValue.getTaint());
        addTaint(id);
        boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
    if(found)        
        {
            return;
        } //End block
        NotFoundException var192E803D6E4375132692991BED2E791A_31950387 = new NotFoundException("Resource ID #0x"
                                    + Integer.toHexString(id));
        var192E803D6E4375132692991BED2E791A_31950387.addTaint(taint);
        throw var192E803D6E4375132692991BED2E791A_31950387;
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x"
                                    //+ Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.353 -0400", hash_original_method = "FF0649F49CF780958319F2862D12B017", hash_generated_method = "57C6AC87E924DC873A9825540741057F")
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        addTaint(resolveRefs);
        addTaint(outValue.getTaint());
        addTaint(density);
        addTaint(id);
        boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
    if(found)        
        {
            return;
        } //End block
        NotFoundException var192E803D6E4375132692991BED2E791A_1274255795 = new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
        var192E803D6E4375132692991BED2E791A_1274255795.addTaint(taint);
        throw var192E803D6E4375132692991BED2E791A_1274255795;
        // ---------- Original Method ----------
        //boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        //if (found) {
            //return;
        //}
        //throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.354 -0400", hash_original_method = "A4F8C6B97749A99408C92371916352C6", hash_generated_method = "16EB2ECB1911A6E323D349134F969AE6")
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        addTaint(resolveRefs);
        addTaint(outValue.getTaint());
        addTaint(name.getTaint());
        int id = getIdentifier(name, "string", null);
    if(id != 0)        
        {
            getValue(id, outValue, resolveRefs);
            return;
        } //End block
        NotFoundException var9C1F2AE561F64ECA13FDBF67D784551C_1364176497 = new NotFoundException("String resource name " + name);
        var9C1F2AE561F64ECA13FDBF67D784551C_1364176497.addTaint(taint);
        throw var9C1F2AE561F64ECA13FDBF67D784551C_1364176497;
        // ---------- Original Method ----------
        //int id = getIdentifier(name, "string", null);
        //if (id != 0) {
            //getValue(id, outValue, resolveRefs);
            //return;
        //}
        //throw new NotFoundException("String resource name " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.354 -0400", hash_original_method = "89EA817324C2BD92A04D61539A7DF9A0", hash_generated_method = "7C19AAEE8A4697756BE9E7F7E5564FFF")
    public final Theme newTheme() {
Theme varD97DE1EDF4CB09EC31717782729C6A86_1721396563 =         new Theme();
        varD97DE1EDF4CB09EC31717782729C6A86_1721396563.addTaint(taint);
        return varD97DE1EDF4CB09EC31717782729C6A86_1721396563;
        // ---------- Original Method ----------
        //return new Theme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.356 -0400", hash_original_method = "D166D2286995B941AEE6CFA36445D894", hash_generated_method = "C5E18BA1D163B84025F18AC985A43BF9")
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        addTaint(attrs[0]);
        addTaint(set.getTaint());
        int len = attrs.length;
        TypedArray array = getCachedStyledAttributes(len);
        XmlBlock.Parser parser = (XmlBlock.Parser)set;
        mAssets.retrieveAttributes(parser.mParseState, attrs,
                array.mData, array.mIndices);
        array.mRsrcs = attrs;
        array.mXml = parser;
TypedArray var1270D5B74B756F17D644A15D775499D9_247879279 =         array;
        var1270D5B74B756F17D644A15D775499D9_247879279.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_247879279;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.356 -0400", hash_original_method = "FADFD61D7F3DC00CFE83DECA8FAB375D", hash_generated_method = "23878DB7A92B4FD8CB65FD129DD64E80")
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        addTaint(config.getTaint());
        updateConfiguration(config, metrics, null);
        // ---------- Original Method ----------
        //updateConfiguration(config, metrics, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.359 -0400", hash_original_method = "FB9A4AAA762C456F245AEDCFD4C4194A", hash_generated_method = "51AF4D4A138CB70D2C5E61F473DE95BC")
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics, CompatibilityInfo compat) {
        addTaint(metrics.getTaint());
        synchronized
(mTmpValue)        {
    if(false)            
            {
            } //End block
    if(compat != null)            
            {
                mCompatibilityInfo = compat;
            } //End block
    if(metrics != null)            
            {
                mMetrics.setTo(metrics);
            } //End block
    if(mCompatibilityInfo != null)            
            {
                mCompatibilityInfo.applyToDisplayMetrics(mMetrics);
            } //End block
            int configChanges = 0xfffffff;
    if(config != null)            
            {
                mTmpConfig.setTo(config);
    if(mCompatibilityInfo != null)                
                {
                    mCompatibilityInfo.applyToConfiguration(mTmpConfig);
                } //End block
    if(mTmpConfig.locale == null)                
                {
                    mTmpConfig.locale = Locale.getDefault();
                } //End block
                configChanges = mConfiguration.updateFrom(mTmpConfig);
                configChanges = ActivityInfo.activityInfoConfigToNative(configChanges);
            } //End block
    if(mConfiguration.locale == null)            
            {
                mConfiguration.locale = Locale.getDefault();
            } //End block
            mMetrics.scaledDensity = mMetrics.density * mConfiguration.fontScale;
            String locale = null;
    if(mConfiguration.locale != null)            
            {
                locale = mConfiguration.locale.getLanguage();
    if(mConfiguration.locale.getCountry() != null)                
                {
                    locale += "-" + mConfiguration.locale.getCountry();
                } //End block
            } //End block
            int width;
            int height;
    if(mMetrics.widthPixels >= mMetrics.heightPixels)            
            {
                width = mMetrics.widthPixels;
                height = mMetrics.heightPixels;
            } //End block
            else
            {
                width = mMetrics.heightPixels;
                height = mMetrics.widthPixels;
            } //End block
            int keyboardHidden = mConfiguration.keyboardHidden;
    if(keyboardHidden == Configuration.KEYBOARDHIDDEN_NO
                    && mConfiguration.hardKeyboardHidden
                            == Configuration.HARDKEYBOARDHIDDEN_YES)            
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
    if(DEBUG_CONFIG)            
            {
            } //End block
            clearDrawableCache(mDrawableCache, configChanges);
            clearDrawableCache(mColorDrawableCache, configChanges);
            mColorStateListCache.clear();
            flushLayoutCache();
        } //End block
        synchronized
(mSync)        {
    if(mPluralRule != null)            
            {
                mPluralRule = NativePluralRules.forLocale(config.locale);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.360 -0400", hash_original_method = "6418DB8B9640192CDF0630899692D8E1", hash_generated_method = "742FD403781A1C5A3EFD09232270A898")
    private void clearDrawableCache(
            LongSparseArray<WeakReference<ConstantState>> cache,
            int configChanges) {
        addTaint(configChanges);
        addTaint(cache.getTaint());
        int N = cache.size();
    if(DEBUG_CONFIG)        
        {
            Log.d(TAG, "Cleaning up drawables config changes: 0x"
                    + Integer.toHexString(configChanges));
        } //End block
for(int i=0;i<N;i++)
        {
            WeakReference<Drawable.ConstantState> ref = cache.valueAt(i);
    if(ref != null)            
            {
                Drawable.ConstantState cs = ref.get();
    if(cs != null)                
                {
    if(Configuration.needNewResources(
                            configChanges, cs.getChangingConfigurations()))                    
                    {
    if(DEBUG_CONFIG)                        
                        {
                            Log.d(TAG, "FLUSHING #0x"
                                    + Long.toHexString(mDrawableCache.keyAt(i))
                                    + " / " + cs + " with changes: 0x"
                                    + Integer.toHexString(cs.getChangingConfigurations()));
                        } //End block
                        cache.setValueAt(i, null);
                    } //End block
                    else
    if(DEBUG_CONFIG)                    
                    {
                        Log.d(TAG, "(Keeping #0x"
                                + Long.toHexString(cache.keyAt(i))
                                + " / " + cs + " with changes: 0x"
                                + Integer.toHexString(cs.getChangingConfigurations())
                                + ")");
                    } //End block
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.362 -0400", hash_original_method = "7F0483A9A445222C6F2291914FFD169A", hash_generated_method = "62558D8DBE4C3307CA4C16CE63AD1A06")
    public DisplayMetrics getDisplayMetrics() {
    if(DEBUG_CONFIG){ }DisplayMetrics var7D82C48E7ECD2A8DB0DA9FEEC5DB0C59_1417474414 =         mMetrics;
        var7D82C48E7ECD2A8DB0DA9FEEC5DB0C59_1417474414.addTaint(taint);
        return var7D82C48E7ECD2A8DB0DA9FEEC5DB0C59_1417474414;
        // ---------- Original Method ----------
        //if (DEBUG_CONFIG) Slog.v(TAG, "Returning DisplayMetrics: " + mMetrics.widthPixels
                //+ "x" + mMetrics.heightPixels + " " + mMetrics.density);
        //return mMetrics;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.363 -0400", hash_original_method = "11CE3ED49D23B920A1DF6398548CD42B", hash_generated_method = "61D32F0B5343DAF89F90BA3BCF6DD6F7")
    public Configuration getConfiguration() {
Configuration var759BB2CF8ED035A2ACBBD9EB4DC189C3_1184008746 =         mConfiguration;
        var759BB2CF8ED035A2ACBBD9EB4DC189C3_1184008746.addTaint(taint);
        return var759BB2CF8ED035A2ACBBD9EB4DC189C3_1184008746;
        // ---------- Original Method ----------
        //return mConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.364 -0400", hash_original_method = "5C840D5EBF5D0071E35FFCF10BAAC7BF", hash_generated_method = "C98EC9BB8F40DF4AB2A340BBAD1FB791")
    public CompatibilityInfo getCompatibilityInfo() {
CompatibilityInfo var39F9338B9ED8B06ACC5A64055D628208_1811547646 =         mCompatibilityInfo != null ? mCompatibilityInfo
                : CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        var39F9338B9ED8B06ACC5A64055D628208_1811547646.addTaint(taint);
        return var39F9338B9ED8B06ACC5A64055D628208_1811547646;
        // ---------- Original Method ----------
        //return mCompatibilityInfo != null ? mCompatibilityInfo
                //: CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.364 -0400", hash_original_method = "E88B36858B95AF9A2C7AEA9BE51A197A", hash_generated_method = "19A0C189ADB691DEF289F2CC535C7437")
    public void setCompatibilityInfo(CompatibilityInfo ci) {
        mCompatibilityInfo = ci;
        updateConfiguration(mConfiguration, mMetrics);
        // ---------- Original Method ----------
        //mCompatibilityInfo = ci;
        //updateConfiguration(mConfiguration, mMetrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.365 -0400", hash_original_method = "5502AEB950C0AF2288FDD25C0479AC75", hash_generated_method = "EAFDAF9783E1D25791701ED16FFA3555")
    public int getIdentifier(String name, String defType, String defPackage) {
        addTaint(defPackage.getTaint());
        addTaint(defType.getTaint());
        addTaint(name.getTaint());
        try 
        {
            int var461AF9086F764A239F4A6B9685131E8A_1366595802 = (Integer.parseInt(name));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410387041 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410387041;
        } //End block
        catch (Exception e)
        {
        } //End block
        int varAD6C93906772B0B900F5483EB09D4DCC_1691821469 = (mAssets.getResourceIdentifier(name, defType, defPackage));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_614537163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_614537163;
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(name);
        //} catch (Exception e) {
        //}
        //return mAssets.getResourceIdentifier(name, defType, defPackage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.366 -0400", hash_original_method = "DE13C1A04BA835F16961D1CBF28A7683", hash_generated_method = "A5E47597177AD1B3E80BC3976F33B866")
    public String getResourceName(int resid) throws NotFoundException {
        addTaint(resid);
        String str = mAssets.getResourceName(resid);
    if(str != null)        
        {
String var061B89662D09DE43FE2A2D88636258A2_574861184 =         str;
        var061B89662D09DE43FE2A2D88636258A2_574861184.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_574861184;
        }
        NotFoundException varCEF2B78468B350541C0BD8B0112664D5_2117848866 = new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        varCEF2B78468B350541C0BD8B0112664D5_2117848866.addTaint(taint);
        throw varCEF2B78468B350541C0BD8B0112664D5_2117848866;
        // ---------- Original Method ----------
        //String str = mAssets.getResourceName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.366 -0400", hash_original_method = "B498C391BD57BD64150A95598D85C5A0", hash_generated_method = "47A0231345E9CA6D0D1FD45E4FCA179C")
    public String getResourcePackageName(int resid) throws NotFoundException {
        addTaint(resid);
        String str = mAssets.getResourcePackageName(resid);
    if(str != null)        
        {
String var061B89662D09DE43FE2A2D88636258A2_1437040881 =         str;
        var061B89662D09DE43FE2A2D88636258A2_1437040881.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_1437040881;
        }
        NotFoundException varCEF2B78468B350541C0BD8B0112664D5_828756133 = new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        varCEF2B78468B350541C0BD8B0112664D5_828756133.addTaint(taint);
        throw varCEF2B78468B350541C0BD8B0112664D5_828756133;
        // ---------- Original Method ----------
        //String str = mAssets.getResourcePackageName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.367 -0400", hash_original_method = "29427E6B381809C5EA97546233CF8A82", hash_generated_method = "7FE59D7F78B727372AC6CFD46FB79321")
    public String getResourceTypeName(int resid) throws NotFoundException {
        addTaint(resid);
        String str = mAssets.getResourceTypeName(resid);
    if(str != null)        
        {
String var061B89662D09DE43FE2A2D88636258A2_205662253 =         str;
        var061B89662D09DE43FE2A2D88636258A2_205662253.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_205662253;
        }
        NotFoundException varCEF2B78468B350541C0BD8B0112664D5_1005989517 = new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        varCEF2B78468B350541C0BD8B0112664D5_1005989517.addTaint(taint);
        throw varCEF2B78468B350541C0BD8B0112664D5_1005989517;
        // ---------- Original Method ----------
        //String str = mAssets.getResourceTypeName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.368 -0400", hash_original_method = "5ED2928930BE3B5AB199F5456042FBFD", hash_generated_method = "5EEA16AC3B07B9FBBFC54B83CF5A03A0")
    public String getResourceEntryName(int resid) throws NotFoundException {
        addTaint(resid);
        String str = mAssets.getResourceEntryName(resid);
    if(str != null)        
        {
String var061B89662D09DE43FE2A2D88636258A2_1266603644 =         str;
        var061B89662D09DE43FE2A2D88636258A2_1266603644.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_1266603644;
        }
        NotFoundException varCEF2B78468B350541C0BD8B0112664D5_120948682 = new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        varCEF2B78468B350541C0BD8B0112664D5_120948682.addTaint(taint);
        throw varCEF2B78468B350541C0BD8B0112664D5_120948682;
        // ---------- Original Method ----------
        //String str = mAssets.getResourceEntryName(resid);
        //if (str != null) return str;
        //throw new NotFoundException("Unable to find resource ID #0x"
                //+ Integer.toHexString(resid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.370 -0400", hash_original_method = "545D8F55664B33539EC622970F1D1819", hash_generated_method = "54883DA5776CFA273BAF110FBF75EF99")
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        addTaint(outBundle.getTaint());
        addTaint(parser.getTaint());
        int outerDepth = parser.getDepth();
        int type;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } //End block
            String nodeName = parser.getName();
    if(nodeName.equals("extra"))            
            {
                parseBundleExtra("extra", parser, outBundle);
                XmlUtils.skipCurrentTag(parser);
            } //End block
            else
            {
                XmlUtils.skipCurrentTag(parser);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.371 -0400", hash_original_method = "A47660356021C86DB26B06C4FCD54400", hash_generated_method = "9B6864C41F3179DD83EFFD6271907047")
    public void parseBundleExtra(String tagName, AttributeSet attrs,
            Bundle outBundle) throws XmlPullParserException {
        addTaint(outBundle.getTaint());
        addTaint(attrs.getTaint());
        addTaint(tagName.getTaint());
        TypedArray sa = obtainAttributes(attrs,
                com.android.internal.R.styleable.Extra);
        String name = sa.getString(
                com.android.internal.R.styleable.Extra_name);
    if(name == null)        
        {
            sa.recycle();
            XmlPullParserException var1FB3CD31D0C3ACF2DB379BAFF599FF16_1116828077 = new XmlPullParserException("<" + tagName
                    + "> requires an android:name attribute at "
                    + attrs.getPositionDescription());
            var1FB3CD31D0C3ACF2DB379BAFF599FF16_1116828077.addTaint(taint);
            throw var1FB3CD31D0C3ACF2DB379BAFF599FF16_1116828077;
        } //End block
        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.Extra_value);
    if(v != null)        
        {
    if(v.type == TypedValue.TYPE_STRING)            
            {
                CharSequence cs = v.coerceToString();
                outBundle.putCharSequence(name, cs);
            } //End block
            else
    if(v.type == TypedValue.TYPE_INT_BOOLEAN)            
            {
                outBundle.putBoolean(name, v.data != 0);
            } //End block
            else
    if(v.type >= TypedValue.TYPE_FIRST_INT
                    && v.type <= TypedValue.TYPE_LAST_INT)            
            {
                outBundle.putInt(name, v.data);
            } //End block
            else
    if(v.type == TypedValue.TYPE_FLOAT)            
            {
                outBundle.putFloat(name, v.getFloat());
            } //End block
            else
            {
                sa.recycle();
                XmlPullParserException varA30D50841671A34896883C68DEE0FC89_591449427 = new XmlPullParserException("<" + tagName
                        + "> only supports string, integer, float, color, and boolean at "
                        + attrs.getPositionDescription());
                varA30D50841671A34896883C68DEE0FC89_591449427.addTaint(taint);
                throw varA30D50841671A34896883C68DEE0FC89_591449427;
            } //End block
        } //End block
        else
        {
            sa.recycle();
            XmlPullParserException varE8E7F16E403D292EC96B7FC841D40C17_1703957507 = new XmlPullParserException("<" + tagName
                    + "> requires an android:value or android:resource attribute at "
                    + attrs.getPositionDescription());
            varE8E7F16E403D292EC96B7FC841D40C17_1703957507.addTaint(taint);
            throw varE8E7F16E403D292EC96B7FC841D40C17_1703957507;
        } //End block
        sa.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.372 -0400", hash_original_method = "B655DEE21C3816C25C0AC2AC9EDD1950", hash_generated_method = "ABD22371DE32CB9BF1EE31FB9716F778")
    public final AssetManager getAssets() {
AssetManager var21520AA84C01698557E63CB551651EC9_849196038 =         mAssets;
        var21520AA84C01698557E63CB551651EC9_849196038.addTaint(taint);
        return var21520AA84C01698557E63CB551651EC9_849196038;
        // ---------- Original Method ----------
        //return mAssets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.394 -0400", hash_original_method = "5E0B191196DA287D9E0DBDD23155512B", hash_generated_method = "6D0C7E5DD250D751C8B49319B6D23E2A")
    public final void flushLayoutCache() {
        synchronized
(mCachedXmlBlockIds)        {
            final int num = mCachedXmlBlockIds.length;
for(int i=0;i<num;i++)
            {
                mCachedXmlBlockIds[i] = -0;
                XmlBlock oldBlock = mCachedXmlBlocks[i];
    if(oldBlock != null)                
                {
                    oldBlock.close();
                } //End block
                mCachedXmlBlocks[i] = null;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.395 -0400", hash_original_method = "EFB6118AC43FED1C4435A31DA78431FB", hash_generated_method = "FF8FCA78A13A03F3811B2CFEACC44018")
    public final void startPreloading() {
        synchronized
(mSync)        {
    if(mPreloaded)            
            {
                IllegalStateException var1DFDD7E9794F613852829682C043F836_450169040 = new IllegalStateException("Resources already preloaded");
                var1DFDD7E9794F613852829682C043F836_450169040.addTaint(taint);
                throw var1DFDD7E9794F613852829682C043F836_450169040;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.395 -0400", hash_original_method = "FF66D3DC188460C4E673EECA31B8D29B", hash_generated_method = "97C6E0FA4800F9B4A84D598232C9352E")
    public final void finishPreloading() {
    if(mPreloading)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.396 -0400", hash_original_method = "2F02B67F3FD30AAC12B7734E2B09423F", hash_generated_method = "15738465BADD7229F6E239B9DF461EE4")
     Drawable loadDrawable(TypedValue value, int id) throws NotFoundException {
        addTaint(id);
        addTaint(value.getTaint());
    if(TRACE_FOR_PRELOAD)        
        {
    if((id >>> 24) == 0x1)            
            {
                final String name = getResourceName(id);
    if(name != null)                
                android.util.Log.d("PreloadDrawable", name);
            } //End block
        } //End block
        final long key = (((long) value.assetCookie) << 32) | value.data;
        boolean isColorDrawable = false;
    if(value.type >= TypedValue.TYPE_FIRST_COLOR_INT &&
                value.type <= TypedValue.TYPE_LAST_COLOR_INT)        
        {
            isColorDrawable = true;
        } //End block
        Drawable dr = getCachedDrawable(isColorDrawable ? mColorDrawableCache : mDrawableCache, key);
    if(dr != null)        
        {
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1253184476 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1253184476.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1253184476;
        } //End block
        Drawable.ConstantState cs = isColorDrawable ? sPreloadedColorDrawables.get(key) : sPreloadedDrawables.get(key);
    if(cs != null)        
        {
            dr = cs.newDrawable(this);
        } //End block
        else
        {
    if(value.type >= TypedValue.TYPE_FIRST_COLOR_INT &&
                    value.type <= TypedValue.TYPE_LAST_COLOR_INT)            
            {
                dr = new ColorDrawable(value.data);
            } //End block
    if(dr == null)            
            {
    if(value.string == null)                
                {
                    NotFoundException var38B01C36DC4EE49C04A5A4AF63162270_170747895 = new NotFoundException(
                            "Resource is not a Drawable (color or path): " + value);
                    var38B01C36DC4EE49C04A5A4AF63162270_170747895.addTaint(taint);
                    throw var38B01C36DC4EE49C04A5A4AF63162270_170747895;
                } //End block
                String file = value.string.toString();
    if(TRACE_FOR_MISS_PRELOAD)                
                {
    if((id >>> 24) == 0x1)                    
                    {
                        final String name = getResourceName(id);
    if(name != null)                        
                        android.util.Log.d(TAG, "Loading framework drawable #"
                                + Integer.toHexString(id) + ": " + name
                                + " at " + file);
                    } //End block
                } //End block
    if(DEBUG_LOAD){ }    if(file.endsWith(".xml"))                
                {
                    try 
                    {
                        XmlResourceParser rp = loadXmlResourceParser(
                                file, id, value.assetCookie, "drawable");
                        dr = Drawable.createFromXml(this, rp);
                        rp.close();
                    } //End block
                    catch (Exception e)
                    {
                        NotFoundException rnf = new NotFoundException(
                            "File " + file + " from drawable resource ID #0x"
                            + Integer.toHexString(id));
                        rnf.initCause(e);
                        rnf.addTaint(taint);
                        throw rnf;
                    } //End block
                } //End block
                else
                {
                    try 
                    {
                        InputStream is = mAssets.openNonAsset(
                                value.assetCookie, file, AssetManager.ACCESS_STREAMING);
                        dr = Drawable.createFromResourceStream(this, value, is,
                                file, null);
                        is.close();
                    } //End block
                    catch (Exception e)
                    {
                        NotFoundException rnf = new NotFoundException(
                            "File " + file + " from drawable resource ID #0x"
                            + Integer.toHexString(id));
                        rnf.initCause(e);
                        rnf.addTaint(taint);
                        throw rnf;
                    } //End block
                } //End block
            } //End block
        } //End block
    if(dr != null)        
        {
            dr.setChangingConfigurations(value.changingConfigurations);
            cs = dr.getConstantState();
    if(cs != null)            
            {
    if(mPreloading)                
                {
    if(isColorDrawable)                    
                    {
                        sPreloadedColorDrawables.put(key, cs);
                    } //End block
                    else
                    {
                        sPreloadedDrawables.put(key, cs);
                    } //End block
                } //End block
                else
                {
                    synchronized
(mTmpValue)                    {
    if(isColorDrawable)                        
                        {
                            mColorDrawableCache.put(key, new WeakReference<Drawable.ConstantState>(cs));
                        } //End block
                        else
                        {
                            mDrawableCache.put(key, new WeakReference<Drawable.ConstantState>(cs));
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1402594185 =         dr;
        varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1402594185.addTaint(taint);
        return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1402594185;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.397 -0400", hash_original_method = "134BDC10D8442526D2E686E53BA1531C", hash_generated_method = "B7626E108D82AEC0E37A7C5D1315F5AD")
    private Drawable getCachedDrawable(
            LongSparseArray<WeakReference<ConstantState>> drawableCache,
            long key) {
        addTaint(key);
        addTaint(drawableCache.getTaint());
        synchronized
(mTmpValue)        {
            WeakReference<Drawable.ConstantState> wr = drawableCache.get(key);
    if(wr != null)            
            {
                Drawable.ConstantState entry = wr.get();
    if(entry != null)                
                {
Drawable var3F3F71B5900FB2B8365F51D5FEB46BF7_1689568392 =                     entry.newDrawable(this);
                    var3F3F71B5900FB2B8365F51D5FEB46BF7_1689568392.addTaint(taint);
                    return var3F3F71B5900FB2B8365F51D5FEB46BF7_1689568392;
                } //End block
                else
                {
                    drawableCache.delete(key);
                } //End block
            } //End block
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_677369697 =         null;
        var540C13E9E156B687226421B24F2DF178_677369697.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_677369697;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.398 -0400", hash_original_method = "035DC5FC794E074E6FAA3F20B34AB858", hash_generated_method = "99C012D9A0486AFF10E05DC85FCB3413")
     ColorStateList loadColorStateList(TypedValue value, int id) throws NotFoundException {
        addTaint(id);
        addTaint(value.getTaint());
    if(TRACE_FOR_PRELOAD)        
        {
    if((id >>> 24) == 0x1)            
            {
                final String name = getResourceName(id);
    if(name != null)                
                android.util.Log.d("PreloadColorStateList", name);
            } //End block
        } //End block
        final int key = (value.assetCookie << 24) | value.data;
        ColorStateList csl;
    if(value.type >= TypedValue.TYPE_FIRST_COLOR_INT &&
                value.type <= TypedValue.TYPE_LAST_COLOR_INT)        
        {
            csl = mPreloadedColorStateLists.get(key);
    if(csl != null)            
            {
ColorStateList var73252CFE466A87C0059D9DDE2D74562A_951740529 =                 csl;
                var73252CFE466A87C0059D9DDE2D74562A_951740529.addTaint(taint);
                return var73252CFE466A87C0059D9DDE2D74562A_951740529;
            } //End block
            csl = ColorStateList.valueOf(value.data);
    if(mPreloading)            
            {
                mPreloadedColorStateLists.put(key, csl);
            } //End block
ColorStateList var73252CFE466A87C0059D9DDE2D74562A_1956205597 =             csl;
            var73252CFE466A87C0059D9DDE2D74562A_1956205597.addTaint(taint);
            return var73252CFE466A87C0059D9DDE2D74562A_1956205597;
        } //End block
        csl = getCachedColorStateList(key);
    if(csl != null)        
        {
ColorStateList var73252CFE466A87C0059D9DDE2D74562A_1257646798 =             csl;
            var73252CFE466A87C0059D9DDE2D74562A_1257646798.addTaint(taint);
            return var73252CFE466A87C0059D9DDE2D74562A_1257646798;
        } //End block
        csl = mPreloadedColorStateLists.get(key);
    if(csl != null)        
        {
ColorStateList var73252CFE466A87C0059D9DDE2D74562A_1146466719 =             csl;
            var73252CFE466A87C0059D9DDE2D74562A_1146466719.addTaint(taint);
            return var73252CFE466A87C0059D9DDE2D74562A_1146466719;
        } //End block
    if(value.string == null)        
        {
            NotFoundException var1447AE78AF8AFCD497FD317C63303A36_1811109698 = new NotFoundException(
                    "Resource is not a ColorStateList (color or path): " + value);
            var1447AE78AF8AFCD497FD317C63303A36_1811109698.addTaint(taint);
            throw var1447AE78AF8AFCD497FD317C63303A36_1811109698;
        } //End block
        String file = value.string.toString();
    if(file.endsWith(".xml"))        
        {
            try 
            {
                XmlResourceParser rp = loadXmlResourceParser(
                        file, id, value.assetCookie, "colorstatelist");
                csl = ColorStateList.createFromXml(this, rp);
                rp.close();
            } //End block
            catch (Exception e)
            {
                NotFoundException rnf = new NotFoundException(
                    "File " + file + " from color state list resource ID #0x"
                    + Integer.toHexString(id));
                rnf.initCause(e);
                rnf.addTaint(taint);
                throw rnf;
            } //End block
        } //End block
        else
        {
            NotFoundException var39208F01AE2F14527613A26EB3C5F654_2267638 = new NotFoundException(
                    "File " + file + " from drawable resource ID #0x"
                    + Integer.toHexString(id) + ": .xml extension required");
            var39208F01AE2F14527613A26EB3C5F654_2267638.addTaint(taint);
            throw var39208F01AE2F14527613A26EB3C5F654_2267638;
        } //End block
    if(csl != null)        
        {
    if(mPreloading)            
            {
                mPreloadedColorStateLists.put(key, csl);
            } //End block
            else
            {
                synchronized
(mTmpValue)                {
                    mColorStateListCache.put(
                        key, new WeakReference<ColorStateList>(csl));
                } //End block
            } //End block
        } //End block
ColorStateList var73252CFE466A87C0059D9DDE2D74562A_1531020253 =         csl;
        var73252CFE466A87C0059D9DDE2D74562A_1531020253.addTaint(taint);
        return var73252CFE466A87C0059D9DDE2D74562A_1531020253;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.399 -0400", hash_original_method = "B7AA5737FC7D8937CDF4D069CBD3DB14", hash_generated_method = "2060D7B9B7FB9004251454D29849094C")
    private ColorStateList getCachedColorStateList(int key) {
        addTaint(key);
        synchronized
(mTmpValue)        {
            WeakReference<ColorStateList> wr = mColorStateListCache.get(key);
    if(wr != null)            
            {
                ColorStateList entry = wr.get();
    if(entry != null)                
                {
ColorStateList varF26DBE38545460D6F6AE1D948FF53869_1133897193 =                     entry;
                    varF26DBE38545460D6F6AE1D948FF53869_1133897193.addTaint(taint);
                    return varF26DBE38545460D6F6AE1D948FF53869_1133897193;
                } //End block
                else
                {
                    mColorStateListCache.delete(key);
                } //End block
            } //End block
        } //End block
ColorStateList var540C13E9E156B687226421B24F2DF178_1949428019 =         null;
        var540C13E9E156B687226421B24F2DF178_1949428019.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1949428019;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.399 -0400", hash_original_method = "4C55C30B9C50C80710A05CFD192F83DB", hash_generated_method = "2B4B334FA4B0068FA18AF6CCDDB3B986")
     XmlResourceParser loadXmlResourceParser(int id, String type) throws NotFoundException {
        addTaint(type.getTaint());
        addTaint(id);
        synchronized
(mTmpValue)        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
    if(value.type == TypedValue.TYPE_STRING)            
            {
XmlResourceParser var5A1964FB864D0B76333E0937BC48734C_1472605494 =                 loadXmlResourceParser(value.string.toString(), id,
                        value.assetCookie, type);
                var5A1964FB864D0B76333E0937BC48734C_1472605494.addTaint(taint);
                return var5A1964FB864D0B76333E0937BC48734C_1472605494;
            } //End block
            NotFoundException var8FC17B893E6776CFA62500DAC96BC722_1611605125 = new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
            var8FC17B893E6776CFA62500DAC96BC722_1611605125.addTaint(taint);
            throw var8FC17B893E6776CFA62500DAC96BC722_1611605125;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.400 -0400", hash_original_method = "B570E59A2D87535635D1C6300E407B49", hash_generated_method = "7A90D52424ED1D2B02EF98CB9266F36E")
     XmlResourceParser loadXmlResourceParser(String file, int id,
            int assetCookie, String type) throws NotFoundException {
        addTaint(type.getTaint());
        addTaint(assetCookie);
        addTaint(file.getTaint());
    if(id != 0)        
        {
            try 
            {
                synchronized
(mCachedXmlBlockIds)                {
                    final int num = mCachedXmlBlockIds.length;
for(int i=0;i<num;i++)
                    {
    if(mCachedXmlBlockIds[i] == id)                        
                        {
XmlResourceParser var3C13EC1A42D4C79CB82E641A6123546A_472143078 =                             mCachedXmlBlocks[i].newParser();
                            var3C13EC1A42D4C79CB82E641A6123546A_472143078.addTaint(taint);
                            return var3C13EC1A42D4C79CB82E641A6123546A_472143078;
                        } //End block
                    } //End block
                    XmlBlock block = mAssets.openXmlBlockAsset(
                            assetCookie, file);
    if(block != null)                    
                    {
                        int pos = mLastCachedXmlBlockIndex+1;
    if(pos >= num)                        
                        pos = 0;
                        mLastCachedXmlBlockIndex = pos;
                        XmlBlock oldBlock = mCachedXmlBlocks[pos];
    if(oldBlock != null)                        
                        {
                            oldBlock.close();
                        } //End block
                        mCachedXmlBlockIds[pos] = id;
                        mCachedXmlBlocks[pos] = block;
XmlResourceParser varC97A15B3F861A68CEB0DE9056EEA1B90_1458679634 =                         block.newParser();
                        varC97A15B3F861A68CEB0DE9056EEA1B90_1458679634.addTaint(taint);
                        return varC97A15B3F861A68CEB0DE9056EEA1B90_1458679634;
                    } //End block
                } //End block
            } //End block
            catch (Exception e)
            {
                NotFoundException rnf = new NotFoundException(
                        "File " + file + " from xml type " + type + " resource ID #0x"
                        + Integer.toHexString(id));
                rnf.initCause(e);
                rnf.addTaint(taint);
                throw rnf;
            } //End block
        } //End block
        NotFoundException var980DAB7E230D94BBBC7E35C8DBB79C2A_1407632378 = new NotFoundException(
                "File " + file + " from xml type " + type + " resource ID #0x"
                + Integer.toHexString(id));
        var980DAB7E230D94BBBC7E35C8DBB79C2A_1407632378.addTaint(taint);
        throw var980DAB7E230D94BBBC7E35C8DBB79C2A_1407632378;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.400 -0400", hash_original_method = "EFFE2C2D7E798E7ABE4C38D3A3D2ED16", hash_generated_method = "E6B4079364E8699778692BD8A085DAC4")
    private TypedArray getCachedStyledAttributes(int len) {
        addTaint(len);
        synchronized
(mTmpValue)        {
            TypedArray attrs = mCachedStyledAttributes;
    if(attrs != null)            
            {
                mCachedStyledAttributes = null;
    if(DEBUG_ATTRIBUTES_CACHE)                
                {
                    mLastRetrievedAttrs = new RuntimeException("here");
                    mLastRetrievedAttrs.fillInStackTrace();
                } //End block
                attrs.mLength = len;
                int fullLen = len * AssetManager.STYLE_NUM_ENTRIES;
    if(attrs.mData.length >= fullLen)                
                {
TypedArray varBFF3B3B688186C8D554F24EB09DDFCD8_1349693637 =                     attrs;
                    varBFF3B3B688186C8D554F24EB09DDFCD8_1349693637.addTaint(taint);
                    return varBFF3B3B688186C8D554F24EB09DDFCD8_1349693637;
                } //End block
                attrs.mData = new int[fullLen];
                attrs.mIndices = new int[1+len];
TypedArray varBFF3B3B688186C8D554F24EB09DDFCD8_774401387 =                 attrs;
                varBFF3B3B688186C8D554F24EB09DDFCD8_774401387.addTaint(taint);
                return varBFF3B3B688186C8D554F24EB09DDFCD8_774401387;
            } //End block
    if(DEBUG_ATTRIBUTES_CACHE)            
            {
                RuntimeException here = new RuntimeException("here");
                here.fillInStackTrace();
    if(mLastRetrievedAttrs != null)                
                {
                } //End block
                mLastRetrievedAttrs = here;
            } //End block
TypedArray varF1C1FAAA36C382AE0BBF6422D8E63F84_658277601 =             new TypedArray(this,
                    new int[len*AssetManager.STYLE_NUM_ENTRIES],
                    new int[1+len], len);
            varF1C1FAAA36C382AE0BBF6422D8E63F84_658277601.addTaint(taint);
            return varF1C1FAAA36C382AE0BBF6422D8E63F84_658277601;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class NotFoundException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.400 -0400", hash_original_method = "16646BE2B605A836CC81C1207D23548C", hash_generated_method = "57BD6F9AE62C00D5DA005539BF3270C7")
        public  NotFoundException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.401 -0400", hash_original_method = "4E6E00F1F6EDF0AE5B66F6F35CDBCBD1", hash_generated_method = "3B0DADC8F2E02A2F21624EB7BCDA9AFB")
        public  NotFoundException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public final class Theme {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.401 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

        private AssetManager mAssets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.401 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.401 -0400", hash_original_method = "795E489BE8D614A2CE03C4AA3DA2CC6B", hash_generated_method = "DE2990E2EA434BEC4D2996B4934FFFEF")
          Theme() {
            mAssets = Resources.this.mAssets;
            mTheme = mAssets.createTheme();
            // ---------- Original Method ----------
            //mAssets = Resources.this.mAssets;
            //mTheme = mAssets.createTheme();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.401 -0400", hash_original_method = "DC72D253295A0467BBA777314F2243D9", hash_generated_method = "BE55612522AFCBF831EEFC26AAA7E4C2")
        public void applyStyle(int resid, boolean force) {
            addTaint(force);
            addTaint(resid);
            AssetManager.applyThemeStyle(mTheme, resid, force);
            // ---------- Original Method ----------
            //AssetManager.applyThemeStyle(mTheme, resid, force);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.401 -0400", hash_original_method = "16C1EE1974E6C30AE0CF98F33344DBAC", hash_generated_method = "0A4EF52A932D7442FE31148DC8C64265")
        public void setTo(Theme other) {
            addTaint(other.getTaint());
            AssetManager.copyTheme(mTheme, other.mTheme);
            // ---------- Original Method ----------
            //AssetManager.copyTheme(mTheme, other.mTheme);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.402 -0400", hash_original_method = "810F63867177324D3683F3630D8FEF5A", hash_generated_method = "E7212E5A24DA7432ACC49D5121844418")
        public TypedArray obtainStyledAttributes(int[] attrs) {
            addTaint(attrs[0]);
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    array.mData, array.mIndices);
TypedArray var1270D5B74B756F17D644A15D775499D9_734466024 =             array;
            var1270D5B74B756F17D644A15D775499D9_734466024.addTaint(taint);
            return var1270D5B74B756F17D644A15D775499D9_734466024;
            // ---------- Original Method ----------
            //int len = attrs.length;
            //TypedArray array = getCachedStyledAttributes(len);
            //array.mRsrcs = attrs;
            //AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    //array.mData, array.mIndices);
            //return array;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.402 -0400", hash_original_method = "09973A74CD9EB62806AFBCC15CD74823", hash_generated_method = "1075C0BE4A49AE173DEE7E3D18577D9D")
        public TypedArray obtainStyledAttributes(int resid, int[] attrs) throws NotFoundException {
            addTaint(attrs[0]);
            addTaint(resid);
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, resid, 0, attrs,
                    array.mData, array.mIndices);
    if(false)            
            {
                int[] data = array.mData;
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("Attributes:");
                String s = "  Attrs:";
                int i;
for(i=0;i<attrs.length;i++)
                {
                    s = s + " 0x" + Integer.toHexString(attrs[i]);
                } //End block
                System.out.println(s);
                s = "  Found:";
                TypedValue value = new TypedValue();
for(i=0;i<attrs.length;i++)
                {
                    int d = i*AssetManager.STYLE_NUM_ENTRIES;
                    value.type = data[d+AssetManager.STYLE_TYPE];
                    value.data = data[d+AssetManager.STYLE_DATA];
                    value.assetCookie = data[d+AssetManager.STYLE_ASSET_COOKIE];
                    value.resourceId = data[d+AssetManager.STYLE_RESOURCE_ID];
                    s = s + " 0x" + Integer.toHexString(attrs[i])
                        + "=" + value;
                } //End block
                System.out.println(s);
            } //End block
TypedArray var1270D5B74B756F17D644A15D775499D9_923969235 =             array;
            var1270D5B74B756F17D644A15D775499D9_923969235.addTaint(taint);
            return var1270D5B74B756F17D644A15D775499D9_923969235;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.403 -0400", hash_original_method = "1F1D15615A0F17B362A611476D650DBA", hash_generated_method = "B678CB67E66BBBF0E8CFD599E0C87403")
        public TypedArray obtainStyledAttributes(AttributeSet set,
                int[] attrs, int defStyleAttr, int defStyleRes) {
            addTaint(defStyleRes);
            addTaint(defStyleAttr);
            addTaint(attrs[0]);
            addTaint(set.getTaint());
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            XmlBlock.Parser parser = (XmlBlock.Parser)set;
            AssetManager.applyStyle(
                mTheme, defStyleAttr, defStyleRes,
                parser != null ? parser.mParseState : 0, attrs,
                        array.mData, array.mIndices);
            array.mRsrcs = attrs;
            array.mXml = parser;
    if(false)            
            {
                int[] data = array.mData;
                System.out.println("Attributes:");
                String s = "  Attrs:";
                int i;
for(i=0;i<set.getAttributeCount();i++)
                {
                    s = s + " " + set.getAttributeName(i);
                    int id = set.getAttributeNameResource(i);
    if(id != 0)                    
                    {
                        s = s + "(0x" + Integer.toHexString(id) + ")";
                    } //End block
                    s = s + "=" + set.getAttributeValue(i);
                } //End block
                System.out.println(s);
                s = "  Found:";
                TypedValue value = new TypedValue();
for(i=0;i<attrs.length;i++)
                {
                    int d = i*AssetManager.STYLE_NUM_ENTRIES;
                    value.type = data[d+AssetManager.STYLE_TYPE];
                    value.data = data[d+AssetManager.STYLE_DATA];
                    value.assetCookie = data[d+AssetManager.STYLE_ASSET_COOKIE];
                    value.resourceId = data[d+AssetManager.STYLE_RESOURCE_ID];
                    s = s + " 0x" + Integer.toHexString(attrs[i])
                        + "=" + value;
                } //End block
                System.out.println(s);
            } //End block
TypedArray var1270D5B74B756F17D644A15D775499D9_862449831 =             array;
            var1270D5B74B756F17D644A15D775499D9_862449831.addTaint(taint);
            return var1270D5B74B756F17D644A15D775499D9_862449831;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.404 -0400", hash_original_method = "CD4F3944F9E3B620EE3ED57C21E36085", hash_generated_method = "A8590602C4264074882B98266176E098")
        public boolean resolveAttribute(int resid, TypedValue outValue,
                boolean resolveRefs) {
            addTaint(resolveRefs);
            addTaint(outValue.getTaint());
            addTaint(resid);
            boolean got = mAssets.getThemeValue(mTheme, resid, outValue, resolveRefs);
    if(false)            
            {
                System.out.println(
                    "resolveAttribute #" + Integer.toHexString(resid)
                    + " got=" + got + ", type=0x" + Integer.toHexString(outValue.type)
                    + ", data=0x" + Integer.toHexString(outValue.data));
            } //End block
            boolean var4A1A27296188C273F6733EAD4FE4EFF6_1968139385 = (got);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857445956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857445956;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.404 -0400", hash_original_method = "AE42D7A6EFA93EEFF71D2B911A492F1C", hash_generated_method = "2D878B421D27D52738A8BE60EB21D52F")
        public void dump(int priority, String tag, String prefix) {
            addTaint(prefix.getTaint());
            addTaint(tag.getTaint());
            addTaint(priority);
            AssetManager.dumpTheme(mTheme, priority, tag, prefix);
            // ---------- Original Method ----------
            //AssetManager.dumpTheme(mTheme, priority, tag, prefix);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.404 -0400", hash_original_method = "E91350A0CB8175C6CA6A8BD390A0B4B8", hash_generated_method = "DD94C395EE3AEC455738317133548F9E")
        protected void finalize() throws Throwable {
            super.finalize();
            mAssets.releaseTheme(mTheme);
            // ---------- Original Method ----------
            //super.finalize();
            //mAssets.releaseTheme(mTheme);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.404 -0400", hash_original_field = "FBDDF25CA08C49699D946174E1D868F3", hash_generated_field = "5C5F00C441325249E30C64C6E802A217")

    static final String TAG = "Resources";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.404 -0400", hash_original_field = "2138514A04DE3271E8E9762F986419AB", hash_generated_field = "AF24F38B7F7C1BFCBE31FAF56BF34CB6")

    private static final boolean DEBUG_LOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.404 -0400", hash_original_field = "C01A6DA6C0D699DBFE9F550B03D3AA4B", hash_generated_field = "131175486DA42E2C78B20447DB22788A")

    private static final boolean DEBUG_CONFIG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "C9B635C9AE5915C59B3A508759AB54C2", hash_generated_field = "ED55101D7A3C371E9777857F76A372CF")

    private static final boolean DEBUG_ATTRIBUTES_CACHE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "06CFFA21769AA1FA0FE0B7C5AF8F4325", hash_generated_field = "FE0143F1FA8AEE992FE6EE3E360B86DA")

    private static final boolean TRACE_FOR_PRELOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "87FE77338788D21010DBC3495A87EB5C", hash_generated_field = "4CD3842605BE6EE30BF77207C2F75B29")

    private static final boolean TRACE_FOR_MISS_PRELOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "15DFB0BA3D576A15F2D6FA24B909E58F", hash_generated_field = "C862CC81028DD3AA6BB9CABD701825FB")

    private static final int ID_OTHER = 0x01000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "F668D47897E28620543685D1E68BB2A5")

    private static final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "F4CCCEAC2DC610511BAB2E064360578D", hash_generated_field = "B0DD5DC72B0C526323B11A6CF67A9E4F")

    static Resources mSystem = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "28D6C8EDE085F2666953D9B90C99AD3C", hash_generated_field = "8013F7294F789DCD4E42A5967435E1AC")

    private static final LongSparseArray<Drawable.ConstantState> sPreloadedDrawables = new LongSparseArray<Drawable.ConstantState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "3053E35008A7FD238184E0C03BA1EE61", hash_generated_field = "7BD9FC30967896FB869451238EE23A0C")

    private static final SparseArray<ColorStateList> mPreloadedColorStateLists = new SparseArray<ColorStateList>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "8E30D292A97994C9D3BC6014424134D6", hash_generated_field = "235E8CAB2CC01C0FEFA2A60D1BF91B25")

    private static final LongSparseArray<Drawable.ConstantState> sPreloadedColorDrawables = new LongSparseArray<Drawable.ConstantState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.405 -0400", hash_original_field = "95F22ABFA5F2E9DF18A53D3B9A50C37A", hash_generated_field = "C895D84621E3994464E604D55CAE67F1")

    private static boolean mPreloaded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.129 -0400", hash_original_field = "0A7FD3BBEB39B9BB1CCAF8BFE6DFE873", hash_generated_field = "1E55E928205255DF2AC737257AA5BE27")

    private static final LongSparseArray<Object> EMPTY_ARRAY = new LongSparseArray<Object>(0) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.128 -0400", hash_original_method = "EC6F1588621E6A8924E2C6C8C57E5DB6", hash_generated_method = "274A5DB79B96D2D45ACCFE2BB16172BF")
        @Override
        public void put(long k, Object o) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(k);
            addTaint(o.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.129 -0400", hash_original_method = "2174303CAFCCF4D833BEBE6A819B3E43", hash_generated_method = "8B6A2668BF9A3FED75E8A97AC129C9EE")
        @Override
        public void append(long k, Object o) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(k);
            addTaint(o.getTaint());
            
            
        }

        
};
}

