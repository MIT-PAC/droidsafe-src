package android.content.res;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "161FA5687A7D7AC4B9C9A80AF829FBD9", hash_generated_field = "F4896FA60EAF46F89D1B23DB39A94469")

    final TypedValue mTmpValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "202292E83A615D844E11CCD7CCF1A376", hash_generated_field = "914D1123EB75F882952E0A98C7FB0DC2")

    final Configuration mTmpConfig = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "9D7B0F08FC7C54174743A4521FC043A2", hash_generated_field = "2497447FAB09A4CFB8FC865DC436A822")

    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mDrawableCache = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "51DD046E9AC370C2103D758104B80E50", hash_generated_field = "933772720D2EC5433FC43B2D14875AB3")

    private final SparseArray<WeakReference<ColorStateList> > mColorStateListCache = new SparseArray<WeakReference<ColorStateList> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "F161DDA26EE5ED9793C135FC39BE9C6F", hash_generated_field = "7B6BE91A39836F0EC0472965B013125A")

    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mColorDrawableCache = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "0BC1DFF6AFE13C970EF49F2E9FA5C4FD", hash_generated_field = "5259D7DBB68DFBC3AE42A15C0065F5F7")

    private boolean mPreloading;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "89D3F63738C9A724185EC448004916DC", hash_generated_field = "7F4C1E655952669DB05D0D7D3EE40E92")

    TypedArray mCachedStyledAttributes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "E5D49A5A4CDDE1AFCA06E51894FF0368", hash_generated_field = "BB3486733E348C9268582EB8BBF07AF9")

    RuntimeException mLastRetrievedAttrs = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "97A118D20A0FE40FC781A018B8438459", hash_generated_field = "D7E7153558BB8F6EF13392C958C199F3")

    private int mLastCachedXmlBlockIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "93C6B32254224CA9474A2A3759E456B6", hash_generated_field = "279259CEA3B9EA7BE3315FDEF65F4C2B")

    private final int[] mCachedXmlBlockIds = { 0, 0, 0, 0 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.055 -0400", hash_original_field = "28DE9458A56FFD64BDF6B0C7224854C3", hash_generated_field = "8B8D941C6918446EE4A5194B99D8AA93")

    private final XmlBlock[] mCachedXmlBlocks = new XmlBlock[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.056 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "4C5448F642D7E098FE1B989A50398568")

    AssetManager mAssets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.056 -0400", hash_original_field = "31DF163B31592D80065FABA8640DBF8D", hash_generated_field = "A59DFC0CAA3A3B58227151AEDB308CC4")

    private final Configuration mConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.056 -0400", hash_original_field = "D1926DAC9E8C0201638CA444B8D6B3EC", hash_generated_field = "67B89A314350924017B72D96E300AA50")

    final DisplayMetrics mMetrics = new DisplayMetrics();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.056 -0400", hash_original_field = "D36951E710CA961467B9F91283823B0B", hash_generated_field = "818136B22260098E65F6ED2716C3D72D")

    private NativePluralRules mPluralRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.056 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "D59F4BA3BF864567D7F711BF240A9A65")

    private CompatibilityInfo mCompatibilityInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.057 -0400", hash_original_method = "A1A5E1FE4CAABF0AED8ED513B68BEBB1", hash_generated_method = "AB3083BF23E0E878F9319E1FEBD9239D")
    public  Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config) {
        this(assets, metrics, config, (CompatibilityInfo) null);
        addTaint(assets.getTaint());
        addTaint(metrics.getTaint());
        addTaint(config.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.057 -0400", hash_original_method = "2B8ADFD0988160303F3DB857A23CF093", hash_generated_method = "7214819AEC9F2E48BFA69DC51A622BDC")
    public  Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config, CompatibilityInfo compInfo) {
        mAssets = assets;
        mMetrics.setToDefaults();
        mCompatibilityInfo = compInfo;
        updateConfiguration(config, metrics);
        assets.ensureStringBlocks();
        addTaint(metrics.getTaint());
        addTaint(config.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.057 -0400", hash_original_method = "647BD0141CFE00480058A00B761B8E30", hash_generated_method = "E7B264666C51F87CBE8DFE8E5E5422AA")
    private  Resources() {
        mAssets = AssetManager.getSystem();
        mConfiguration.setToDefaults();
        mMetrics.setToDefaults();
        updateConfiguration(null, null);
        mAssets.ensureStringBlocks();
        mCompatibilityInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    private static <T> LongSparseArray<T> emptySparseArray() {
        return (LongSparseArray<T>) EMPTY_ARRAY;
    }

    
    @DSModeled(DSC.SAFE)
    public static int selectDefaultTheme(int curTheme, int targetSdkVersion) {
        return selectSystemTheme(curTheme, targetSdkVersion,
                com.android.internal.R.style.Theme,
                com.android.internal.R.style.Theme_Holo,
                com.android.internal.R.style.Theme_DeviceDefault);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.060 -0400", hash_original_method = "ACC5D7202FC5E62E31E1054DCF0E5FCD", hash_generated_method = "E5B6F505D2FA5F98FC4944BBDEAB5213")
    public CharSequence getText(int id) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1302725832 = null; 
        CharSequence res = mAssets.getResourceText(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1302725832 = res;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1302725832.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1302725832;
        
        
        
            
        
        
                                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.061 -0400", hash_original_method = "78A3DFDF860E06736217D448EF07FADF", hash_generated_method = "809C5BC7A7A1746EDCE07BDCC4B94C33")
    public CharSequence getQuantityText(int id, int quantity) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_861650075 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1031515867 = null; 
        NativePluralRules rule = getPluralRule();
        CharSequence res = mAssets.getResourceBagText(id,
                attrForQuantityCode(rule.quantityForInt(quantity)));
        {
            varB4EAC82CA7396A68D541C85D26508E83_861650075 = res;
        } 
        res = mAssets.getResourceBagText(id, ID_OTHER);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1031515867 = res;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Plural resource ID #0x" + Integer.toHexString(id)
                + " quantity=" + quantity
                + " item=" + stringForQuantityCode(rule.quantityForInt(quantity)));
        addTaint(id);
        addTaint(quantity);
        CharSequence varA7E53CE21691AB073D9660D615818899_880850045; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_880850045 = varB4EAC82CA7396A68D541C85D26508E83_861650075;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_880850045 = varB4EAC82CA7396A68D541C85D26508E83_1031515867;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_880850045.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_880850045;
        
        
        
                
        
            
        
        
        
            
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.062 -0400", hash_original_method = "1BFA20E87FBD429BB566BA0632D0EE62", hash_generated_method = "B1582A1C890CE940EEE59D2E943722DE")
    private NativePluralRules getPluralRule() {
        NativePluralRules varB4EAC82CA7396A68D541C85D26508E83_10513623 = null; 
        {
            {
                mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_10513623 = mPluralRule;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_10513623.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_10513623;
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.063 -0400", hash_original_method = "537EFC002B8A40B3B7F76596758B9963", hash_generated_method = "C2A8FADA32D3CD5F08976ED5D63C8564")
    public String getString(int id) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_231141683 = null; 
        CharSequence res = getText(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_231141683 = res.toString();
        } 
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_231141683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_231141683;
        
        
        
            
        
        
                                    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.064 -0400", hash_original_method = "2EEC36CFDBF61FC5501B8B9376C5F95E", hash_generated_method = "22134274FC0710EFB610ED3CB1A08354")
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_875299362 = null; 
        String raw = getString(id);
        varB4EAC82CA7396A68D541C85D26508E83_875299362 = String.format(mConfiguration.locale, raw, formatArgs);
        addTaint(id);
        addTaint(formatArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_875299362.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_875299362;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.065 -0400", hash_original_method = "3050F7A6F3C08BB33AB97951F94A1A35", hash_generated_method = "45580B67904C3F5CCCDB21ED1184C4CB")
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1060952448 = null; 
        String raw = getQuantityText(id, quantity).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1060952448 = String.format(mConfiguration.locale, raw, formatArgs);
        addTaint(id);
        addTaint(quantity);
        addTaint(formatArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1060952448.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1060952448;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.065 -0400", hash_original_method = "81877842C4E2FEF0D9FCD2095374BD66", hash_generated_method = "DC6329391258BC15CC06EB08821053A5")
    public String getQuantityString(int id, int quantity) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1645291545 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1645291545 = getQuantityText(id, quantity).toString();
        addTaint(id);
        addTaint(quantity);
        varB4EAC82CA7396A68D541C85D26508E83_1645291545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1645291545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.066 -0400", hash_original_method = "9E76804CDFB0982D016B6CE6163D7455", hash_generated_method = "B047CDB75A4585EC975FF38DE713EF29")
    public CharSequence getText(int id, CharSequence def) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2062336342 = null; 
        CharSequence res;
        res = mAssets.getResourceText(id);
        res = null;
        varB4EAC82CA7396A68D541C85D26508E83_2062336342 = res != null ? res : def;
        addTaint(id);
        addTaint(def.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2062336342.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2062336342;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.067 -0400", hash_original_method = "2FECA5C28D9DC41170E2F1E5700277A0", hash_generated_method = "26AE5C1E635097F8C5664450889C9712")
    public CharSequence[] getTextArray(int id) throws NotFoundException {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_474453483 = null; 
        CharSequence[] res = mAssets.getResourceTextArray(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_474453483 = res;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Text array resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_474453483.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_474453483;
        
        
        
            
        
        
                                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.068 -0400", hash_original_method = "426431DC420CF2DD39FFAF8B295D8654", hash_generated_method = "9646B119AF1C463BFE9D14B9A4A7E00E")
    public String[] getStringArray(int id) throws NotFoundException {
        String[] varB4EAC82CA7396A68D541C85D26508E83_596620813 = null; 
        String[] res = mAssets.getResourceStringArray(id);
        {
            varB4EAC82CA7396A68D541C85D26508E83_596620813 = res;
        } 
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String array resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_596620813.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_596620813;
        
        
        
            
        
        
                                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.068 -0400", hash_original_method = "65AEFB7747626FD934E6275803D2C392", hash_generated_method = "0933C120024FB1F2685ACE27ED3C373B")
    public int[] getIntArray(int id) throws NotFoundException {
        int[] res = mAssets.getArrayIntResource(id);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Int array resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1515513801 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1515513801;
        
        
        
            
        
        
                                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.069 -0400", hash_original_method = "8E5AB34336560F1D8FA12EC65FB34D2E", hash_generated_method = "473C3CD4626B4D6FC9717A3D1BC0563A")
    public TypedArray obtainTypedArray(int id) throws NotFoundException {
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_52265442 = null; 
        int len = mAssets.getArraySize(id);
        {
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Array resource ID #0x"
                                        + Integer.toHexString(id));
        } 
        TypedArray array = getCachedStyledAttributes(len);
        array.mLength = mAssets.retrieveArray(id, array.mData);
        array.mIndices[0] = 0;
        varB4EAC82CA7396A68D541C85D26508E83_52265442 = array;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_52265442.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_52265442;
        
        
        
            
                                        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.070 -0400", hash_original_method = "179671F1A37C23E822373A76E19D42EA", hash_generated_method = "21541EDD265B53548E6A28BE61C596A6")
    public float getDimension(int id) throws NotFoundException {
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            {
                float var3D1EF52544C26367510F308FBFEC9AF2_619399867 = (TypedValue.complexToDimension(value.data, mMetrics));
            } 
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        float var546ADE640B6EDFBC8A086EF31347E768_111213766 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_111213766;
        
        
            
            
            
                
            
            
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.072 -0400", hash_original_method = "1833FD2ED6DCA9CF6DFDBF7D9BC0478B", hash_generated_method = "882E51D627F0C323AE19C475DDBD5C40")
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            {
                int varC10E6C7CE4C18B2E8240388CE0B9D4D5_553321675 = (TypedValue.complexToDimensionPixelOffset(
                        value.data, mMetrics));
            } 
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404039539 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404039539;
        
        
            
            
            
                
                        
            
            
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.073 -0400", hash_original_method = "E2B2A30088D0238C29DEA7CD0218F3E5", hash_generated_method = "94826B987A4503955C546A0FD36624EC")
    public int getDimensionPixelSize(int id) throws NotFoundException {
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            {
                int var618929EFC759B1CAECEF2B8755B3C586_1732945085 = (TypedValue.complexToDimensionPixelSize(
                        value.data, mMetrics));
            } 
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781695270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_781695270;
        
        
            
            
            
                
                        
            
            
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.074 -0400", hash_original_method = "A2DCBF1A3DEF525CC233A65EC473B403", hash_generated_method = "3E535B9649478F4A1B129685F000086C")
    public float getFraction(int id, int base, int pbase) {
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            {
                float var32E1DB9737EBC4A230505D9C45C6217C_1013963107 = (TypedValue.complexToFraction(value.data, base, pbase));
            } 
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        addTaint(base);
        addTaint(pbase);
        float var546ADE640B6EDFBC8A086EF31347E768_281439522 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_281439522;
        
        
            
            
            
                
            
            
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.074 -0400", hash_original_method = "40531A8693FC775C03E22F5835EB733B", hash_generated_method = "C1D77609F72881AAED7EAA7079F06C7E")
    public Drawable getDrawable(int id) throws NotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_116814547 = null; 
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            varB4EAC82CA7396A68D541C85D26508E83_116814547 = loadDrawable(value, id);
        } 
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_116814547.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_116814547;
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.075 -0400", hash_original_method = "D08D33B833687D530F432098EC5CCB38", hash_generated_method = "C369F8CCF223B0495BE97DFEA342378A")
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1291814995 = null; 
        {
            TypedValue value = mTmpValue;
            getValueForDensity(id, density, value, true);
            {
                {
                    value.density = DisplayMetrics.DENSITY_DEVICE;
                } 
                {
                    value.density = (value.density * DisplayMetrics.DENSITY_DEVICE) / density;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1291814995 = loadDrawable(value, id);
        } 
        addTaint(id);
        addTaint(density);
        varB4EAC82CA7396A68D541C85D26508E83_1291814995.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1291814995;
        
        
            
            
            
                
                    
                
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.076 -0400", hash_original_method = "973C0EDB6E14C8355746DA3A02A0EBD1", hash_generated_method = "5DAB5EAA3A458DA72699C12E2B4BC9F1")
    public Movie getMovie(int id) throws NotFoundException {
        Movie varB4EAC82CA7396A68D541C85D26508E83_1537325320 = null; 
        InputStream is = openRawResource(id);
        Movie movie = Movie.decodeStream(is);
        try 
        {
            is.close();
        } 
        catch (java.io.IOException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1537325320 = movie;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1537325320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1537325320;
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.077 -0400", hash_original_method = "CDFC75613D2F871DC3B09D1CE60F98A4", hash_generated_method = "10CA2796A48220C6E24961383E019054")
    public int getColor(int id) throws NotFoundException {
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            {
                ColorStateList csl = loadColorStateList(mTmpValue, id);
                int var0BE21B049075D2C5C0B5387A1C4FC3D4_2045167906 = (csl.getDefaultColor());
            } 
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925907138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925907138;
        
        
            
            
            
                
                
            
                
                
            
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.077 -0400", hash_original_method = "F237EF4FA0AE2D448FCC64592DABDD8D", hash_generated_method = "23E2461D3D5141E6B1A6B741883C8DA2")
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_252504383 = null; 
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            varB4EAC82CA7396A68D541C85D26508E83_252504383 = loadColorStateList(value, id);
        } 
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_252504383.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_252504383;
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.078 -0400", hash_original_method = "5C68CA666BA42061546BF98D8883861D", hash_generated_method = "28F074199A19A96A60A49B4016C7D783")
    public boolean getBoolean(int id) throws NotFoundException {
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661833322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661833322;
        
        
            
            
            
                
                
            
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.079 -0400", hash_original_method = "CB2B32F0600F2299579C79C7526A8896", hash_generated_method = "850A97E1D8E41CA27322AAA9902657EF")
    public int getInteger(int id) throws NotFoundException {
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463357708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1463357708;
        
        
            
            
            
                
                
            
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.080 -0400", hash_original_method = "53A788F1DE83214BAFCB022ED9363AAC", hash_generated_method = "39C12C7415B26F3F6BB2AB4CC32973E0")
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_943124862 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_943124862 = loadXmlResourceParser(id, "layout");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_943124862.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_943124862;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.081 -0400", hash_original_method = "C3417F93CB7498AF5B43E94B98075C78", hash_generated_method = "EAACE7DF2112FA24C76B2430FD782836")
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1016013292 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1016013292 = loadXmlResourceParser(id, "anim");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1016013292.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1016013292;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.082 -0400", hash_original_method = "66568C58C76DE1C95FED15C8056E4335", hash_generated_method = "D3B925CABF18A9680DFA5D0210DA8D8F")
    public XmlResourceParser getXml(int id) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_257692194 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_257692194 = loadXmlResourceParser(id, "xml");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_257692194.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_257692194;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.083 -0400", hash_original_method = "2A38C8042909AD0B3921F8B41C50BFD0", hash_generated_method = "BA157CA13B6118AA71E48EE01CC6FB2C")
    public InputStream openRawResource(int id) throws NotFoundException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1236304224 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1236304224 = openRawResource(id, mTmpValue);
        } 
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1236304224.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1236304224;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.084 -0400", hash_original_method = "2E256A4CBCC4636EC939F62266AB39BC", hash_generated_method = "0FBAE9A2B3F4CAF6A602628DF9D02D47")
    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_331329981 = null; 
        getValue(id, value, true);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_331329981 = mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    AssetManager.ACCESS_STREAMING);
        } 
        catch (Exception e)
        {
            NotFoundException rnf = new NotFoundException("File " + value.string.toString() +
                    " from drawable resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw rnf;
        } 
        addTaint(id);
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_331329981.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_331329981;
        
        
        
            
                    
        
            
                    
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.085 -0400", hash_original_method = "7A496359623417DAF484E4884A244E4E", hash_generated_method = "8EF6B380E97D7C804F028108EE437E4E")
    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        AssetFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1407726974 = null; 
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1407726974 = mAssets.openNonAssetFd(
                    value.assetCookie, value.string.toString());
            } 
            catch (Exception e)
            {
                NotFoundException rnf = new NotFoundException(
                    "File " + value.string.toString()
                    + " from drawable resource ID #0x"
                    + Integer.toHexString(id));
                rnf.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw rnf;
            } 
        } 
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1407726974.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1407726974;
        
        
            
            
            
                
                    
            
                
                    
                    
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.085 -0400", hash_original_method = "286538764BE9255E72B90D7B13646A2E", hash_generated_method = "6A9C0C7A710193F18BA6B12FC73358F3")
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Resource ID #0x"
                                    + Integer.toHexString(id));
        addTaint(id);
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        
        
        
            
        
        
                                    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.086 -0400", hash_original_method = "FF0649F49CF780958319F2862D12B017", hash_generated_method = "37A5A89CED13F6F67F6BF45D5ECD7EF8")
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
        addTaint(id);
        addTaint(density);
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.086 -0400", hash_original_method = "A4F8C6B97749A99408C92371916352C6", hash_generated_method = "2A8DB9C23C77D945E9BB417C6463BB15")
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        int id = getIdentifier(name, "string", null);
        {
            getValue(id, outValue, resolveRefs);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("String resource name " + name);
        addTaint(name.getTaint());
        addTaint(outValue.getTaint());
        addTaint(resolveRefs);
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.087 -0400", hash_original_method = "89EA817324C2BD92A04D61539A7DF9A0", hash_generated_method = "6D42077C7D8C500A72240B7760A7E2A7")
    public final Theme newTheme() {
        Theme varB4EAC82CA7396A68D541C85D26508E83_662461706 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_662461706 = new Theme();
        varB4EAC82CA7396A68D541C85D26508E83_662461706.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_662461706;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.088 -0400", hash_original_method = "D166D2286995B941AEE6CFA36445D894", hash_generated_method = "E919FDBA9A692BD411EE43FF2FD81624")
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_1951244345 = null; 
        int len = attrs.length;
        TypedArray array = getCachedStyledAttributes(len);
        XmlBlock.Parser parser = (XmlBlock.Parser)set;
        mAssets.retrieveAttributes(parser.mParseState, attrs,
                array.mData, array.mIndices);
        array.mRsrcs = attrs;
        array.mXml = parser;
        varB4EAC82CA7396A68D541C85D26508E83_1951244345 = array;
        addTaint(set.getTaint());
        addTaint(attrs[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1951244345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1951244345;
        
        
        
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.089 -0400", hash_original_method = "FADFD61D7F3DC00CFE83DECA8FAB375D", hash_generated_method = "E94702199A1A902DB0E98CCEE70C0FA8")
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics) {
        updateConfiguration(config, metrics, null);
        addTaint(config.getTaint());
        addTaint(metrics.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.091 -0400", hash_original_method = "FB9A4AAA762C456F245AEDCFD4C4194A", hash_generated_method = "0CC0C597DA9BB920E7BA92D0B44CE42F")
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics, CompatibilityInfo compat) {
        {
            {
                mCompatibilityInfo = compat;
            } 
            {
                mMetrics.setTo(metrics);
            } 
            {
                mCompatibilityInfo.applyToDisplayMetrics(mMetrics);
            } 
            int configChanges = 0xfffffff;
            {
                mTmpConfig.setTo(config);
                {
                    mCompatibilityInfo.applyToConfiguration(mTmpConfig);
                } 
                {
                    mTmpConfig.locale = Locale.getDefault();
                } 
                configChanges = mConfiguration.updateFrom(mTmpConfig);
                configChanges = ActivityInfo.activityInfoConfigToNative(configChanges);
            } 
            {
                mConfiguration.locale = Locale.getDefault();
            } 
            mMetrics.scaledDensity = mMetrics.density * mConfiguration.fontScale;
            String locale = null;
            {
                locale = mConfiguration.locale.getLanguage();
                {
                    boolean varC89ED4BF7AB2BEFA099B67803FBEFA7B_1163015997 = (mConfiguration.locale.getCountry() != null);
                    {
                        locale += "-" + mConfiguration.locale.getCountry();
                    } 
                } 
            } 
            int width;
            int height;
            {
                width = mMetrics.widthPixels;
                height = mMetrics.heightPixels;
            } 
            {
                width = mMetrics.heightPixels;
                height = mMetrics.widthPixels;
            } 
            int keyboardHidden = mConfiguration.keyboardHidden;
            {
                keyboardHidden = Configuration.KEYBOARDHIDDEN_SOFT;
            } 
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
        } 
        {
            {
                mPluralRule = NativePluralRules.forLocale(config.locale);
            } 
        } 
        addTaint(metrics.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.093 -0400", hash_original_method = "6418DB8B9640192CDF0630899692D8E1", hash_generated_method = "5B4966C394813D224EE93194C6B37F95")
    private void clearDrawableCache(
            LongSparseArray<WeakReference<ConstantState>> cache,
            int configChanges) {
        int N = cache.size();
        {
            Log.d(TAG, "Cleaning up drawables config changes: 0x"
                    + Integer.toHexString(configChanges));
        } 
        {
            int i = 0;
            {
                WeakReference<Drawable.ConstantState> ref = cache.valueAt(i);
                {
                    Drawable.ConstantState cs = ref.get();
                    {
                        {
                            boolean var9C0F2EE920A6529CD11D682CB4806601_319450675 = (Configuration.needNewResources(
                            configChanges, cs.getChangingConfigurations()));
                            {
                                {
                                    Log.d(TAG, "FLUSHING #0x"
                                    + Long.toHexString(mDrawableCache.keyAt(i))
                                    + " / " + cs + " with changes: 0x"
                                    + Integer.toHexString(cs.getChangingConfigurations()));
                                } 
                                cache.setValueAt(i, null);
                            } 
                            {
                                Log.d(TAG, "(Keeping #0x"
                                + Long.toHexString(cache.keyAt(i))
                                + " / " + cs + " with changes: 0x"
                                + Integer.toHexString(cs.getChangingConfigurations())
                                + ")");
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(cache.getTaint());
        addTaint(configChanges);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics,
            CompatibilityInfo compat) {
        if (mSystem != null) {
            mSystem.updateConfiguration(config, metrics, compat);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics) {
        updateSystemConfiguration(config, metrics, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.094 -0400", hash_original_method = "7F0483A9A445222C6F2291914FFD169A", hash_generated_method = "E73716B3467A0F6EAF992767631D5364")
    public DisplayMetrics getDisplayMetrics() {
        DisplayMetrics varB4EAC82CA7396A68D541C85D26508E83_468165093 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_468165093 = mMetrics;
        varB4EAC82CA7396A68D541C85D26508E83_468165093.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_468165093;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.095 -0400", hash_original_method = "11CE3ED49D23B920A1DF6398548CD42B", hash_generated_method = "568C08AACF2061E3E055331DC2070462")
    public Configuration getConfiguration() {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_857336594 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_857336594 = mConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_857336594.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_857336594;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.095 -0400", hash_original_method = "5C840D5EBF5D0071E35FFCF10BAAC7BF", hash_generated_method = "E7196BA4071014B0F77C2608872D5C3C")
    public CompatibilityInfo getCompatibilityInfo() {
        CompatibilityInfo varB4EAC82CA7396A68D541C85D26508E83_2126251590 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2126251590 = mCompatibilityInfo != null ? mCompatibilityInfo
                : CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_2126251590.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2126251590;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.096 -0400", hash_original_method = "E88B36858B95AF9A2C7AEA9BE51A197A", hash_generated_method = "19A0C189ADB691DEF289F2CC535C7437")
    public void setCompatibilityInfo(CompatibilityInfo ci) {
        mCompatibilityInfo = ci;
        updateConfiguration(mConfiguration, mMetrics);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.096 -0400", hash_original_method = "5502AEB950C0AF2288FDD25C0479AC75", hash_generated_method = "86E50FBFD365BDFC7E411555D46E62A5")
    public int getIdentifier(String name, String defType, String defPackage) {
        try 
        {
            int var0C5B23BCF8D28A28F4CE8567896762AC_1926767153 = (Integer.parseInt(name));
        } 
        catch (Exception e)
        { }
        int var90A48CBEB3A052E5337E8C53FA9D4855_436794901 = (mAssets.getResourceIdentifier(name, defType, defPackage));
        addTaint(name.getTaint());
        addTaint(defType.getTaint());
        addTaint(defPackage.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222082362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222082362;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.097 -0400", hash_original_method = "DE13C1A04BA835F16961D1CBF28A7683", hash_generated_method = "68B35E34053AD0830F4536F1AF45502D")
    public String getResourceName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_311699 = null; 
        String str = mAssets.getResourceName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_311699 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_311699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_311699;
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.098 -0400", hash_original_method = "B498C391BD57BD64150A95598D85C5A0", hash_generated_method = "4B2FC177993FAFCA643F965138906999")
    public String getResourcePackageName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_122064934 = null; 
        String str = mAssets.getResourcePackageName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_122064934 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_122064934.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_122064934;
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.098 -0400", hash_original_method = "29427E6B381809C5EA97546233CF8A82", hash_generated_method = "83BB4F3824FC503A2605EA2177C1067B")
    public String getResourceTypeName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_2112311926 = null; 
        String str = mAssets.getResourceTypeName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_2112311926 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_2112311926.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2112311926;
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.099 -0400", hash_original_method = "5ED2928930BE3B5AB199F5456042FBFD", hash_generated_method = "A3C22DB09D5456275351C52C1E919417")
    public String getResourceEntryName(int resid) throws NotFoundException {
        String varB4EAC82CA7396A68D541C85D26508E83_1640190808 = null; 
        String str = mAssets.getResourceEntryName(resid);
        varB4EAC82CA7396A68D541C85D26508E83_1640190808 = str;
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
        addTaint(resid);
        varB4EAC82CA7396A68D541C85D26508E83_1640190808.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1640190808;
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.100 -0400", hash_original_method = "545D8F55664B33539EC622970F1D1819", hash_generated_method = "646AD3FA1B393B17F7A545C660CCD19D")
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        int type;
        {
            boolean var49BAE650CF2F44016B0E4A15ECAD0A92_1074383941 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String nodeName = parser.getName();
                {
                    boolean var9B462BCA6AFE78346945C1C798AAB22C_354626593 = (nodeName.equals("extra"));
                    {
                        parseBundleExtra("extra", parser, outBundle);
                        XmlUtils.skipCurrentTag(parser);
                    } 
                    {
                        XmlUtils.skipCurrentTag(parser);
                    } 
                } 
            } 
        } 
        addTaint(parser.getTaint());
        addTaint(outBundle.getTaint());
        
        
        
        
               
            
                
            
            
            
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.102 -0400", hash_original_method = "A47660356021C86DB26B06C4FCD54400", hash_generated_method = "225EBC844416853C6E445E461A23603F")
    public void parseBundleExtra(String tagName, AttributeSet attrs,
            Bundle outBundle) throws XmlPullParserException {
        TypedArray sa = obtainAttributes(attrs,
                com.android.internal.R.styleable.Extra);
        String name = sa.getString(
                com.android.internal.R.styleable.Extra_name);
        {
            sa.recycle();
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("<" + tagName
                    + "> requires an android:name attribute at "
                    + attrs.getPositionDescription());
        } 
        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.Extra_value);
        {
            {
                CharSequence cs = v.coerceToString();
                outBundle.putCharSequence(name, cs);
            } 
            {
                outBundle.putBoolean(name, v.data != 0);
            } 
            {
                outBundle.putInt(name, v.data);
            } 
            {
                outBundle.putFloat(name, v.getFloat());
            } 
            {
                sa.recycle();
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("<" + tagName
                        + "> only supports string, integer, float, color, and boolean at "
                        + attrs.getPositionDescription());
            } 
        } 
        {
            sa.recycle();
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("<" + tagName
                    + "> requires an android:value or android:resource attribute at "
                    + attrs.getPositionDescription());
        } 
        sa.recycle();
        addTaint(tagName.getTaint());
        addTaint(attrs.getTaint());
        addTaint(outBundle.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.103 -0400", hash_original_method = "B655DEE21C3816C25C0AC2AC9EDD1950", hash_generated_method = "CBCA5E6265099326D6CB06153FBBFBF0")
    public final AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_1039730545 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1039730545 = mAssets;
        varB4EAC82CA7396A68D541C85D26508E83_1039730545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1039730545;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.104 -0400", hash_original_method = "5E0B191196DA287D9E0DBDD23155512B", hash_generated_method = "7521112F22E795CB317C7934E558E18C")
    public final void flushLayoutCache() {
        {
            final int num = mCachedXmlBlockIds.length;
            {
                int i = 0;
                {
                    mCachedXmlBlockIds[i] = -0;
                    XmlBlock oldBlock = mCachedXmlBlocks[i];
                    {
                        oldBlock.close();
                    } 
                    mCachedXmlBlocks[i] = null;
                } 
            } 
        } 
        
        
            
            
                
                
                
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.104 -0400", hash_original_method = "EFB6118AC43FED1C4435A31DA78431FB", hash_generated_method = "10F9907BD716A3B118F283BB2C069C41")
    public final void startPreloading() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Resources already preloaded");
            } 
            mPreloaded = true;
            mPreloading = true;
        } 
        
        
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.105 -0400", hash_original_method = "FF66D3DC188460C4E673EECA31B8D29B", hash_generated_method = "8F83DA2BD6ACD94787540573A1998010")
    public final void finishPreloading() {
        {
            mPreloading = false;
            flushLayoutCache();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.107 -0400", hash_original_method = "2F02B67F3FD30AAC12B7734E2B09423F", hash_generated_method = "5ACA01D29425DC907D6C4862C4BBBF40")
     Drawable loadDrawable(TypedValue value, int id) throws NotFoundException {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_648926752 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1641759759 = null; 
        {
            {
                final String name = getResourceName(id);
                android.util.Log.d("PreloadDrawable", name);
            } 
        } 
        final long key = (((long) value.assetCookie) << 32) | value.data;
        boolean isColorDrawable = false;
        {
            isColorDrawable = true;
        } 
        Drawable dr = getCachedDrawable(isColorDrawable ? mColorDrawableCache : mDrawableCache, key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_648926752 = dr;
        } 
        Drawable.ConstantState cs;
        cs = sPreloadedColorDrawables.get(key);
        cs = sPreloadedDrawables.get(key);
        {
            dr = cs.newDrawable(this);
        } 
        {
            {
                dr = new ColorDrawable(value.data);
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                            "Resource is not a Drawable (color or path): " + value);
                } 
                String file = value.string.toString();
                {
                    {
                        final String name = getResourceName(id);
                        android.util.Log.d(TAG, "Loading framework drawable #"
                                + Integer.toHexString(id) + ": " + name
                                + " at " + file);
                    } 
                } 
                {
                    boolean varE0987C6B5CC3DA09C3EAA5CE0FE23DAC_1212815519 = (file.endsWith(".xml"));
                    {
                        try 
                        {
                            XmlResourceParser rp = loadXmlResourceParser(
                                file, id, value.assetCookie, "drawable");
                            dr = Drawable.createFromXml(this, rp);
                            rp.close();
                        } 
                        catch (Exception e)
                        {
                            NotFoundException rnf = new NotFoundException(
                            "File " + file + " from drawable resource ID #0x"
                            + Integer.toHexString(id));
                            rnf.initCause(e);
                            if (DroidSafeAndroidRuntime.control) throw rnf;
                        } 
                    } 
                    {
                        try 
                        {
                            InputStream is = mAssets.openNonAsset(
                                value.assetCookie, file, AssetManager.ACCESS_STREAMING);
                            dr = Drawable.createFromResourceStream(this, value, is,
                                file, null);
                            is.close();
                        } 
                        catch (Exception e)
                        {
                            NotFoundException rnf = new NotFoundException(
                            "File " + file + " from drawable resource ID #0x"
                            + Integer.toHexString(id));
                            rnf.initCause(e);
                            if (DroidSafeAndroidRuntime.control) throw rnf;
                        } 
                    } 
                } 
            } 
        } 
        {
            dr.setChangingConfigurations(value.changingConfigurations);
            cs = dr.getConstantState();
            {
                {
                    {
                        sPreloadedColorDrawables.put(key, cs);
                    } 
                    {
                        sPreloadedDrawables.put(key, cs);
                    } 
                } 
                {
                    {
                        {
                            mColorDrawableCache.put(key, new WeakReference<Drawable.ConstantState>(cs));
                        } 
                        {
                            mDrawableCache.put(key, new WeakReference<Drawable.ConstantState>(cs));
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1641759759 = dr;
        addTaint(value.getTaint());
        addTaint(id);
        Drawable varA7E53CE21691AB073D9660D615818899_609424493; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_609424493 = varB4EAC82CA7396A68D541C85D26508E83_648926752;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_609424493 = varB4EAC82CA7396A68D541C85D26508E83_1641759759;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_609424493.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_609424493;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.108 -0400", hash_original_method = "134BDC10D8442526D2E686E53BA1531C", hash_generated_method = "28F60C9D4C1C5540AB206E9AACE1BF89")
    private Drawable getCachedDrawable(
            LongSparseArray<WeakReference<ConstantState>> drawableCache,
            long key) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1356440465 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_107505203 = null; 
        {
            WeakReference<Drawable.ConstantState> wr = drawableCache.get(key);
            {
                Drawable.ConstantState entry = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1356440465 = entry.newDrawable(this);
                } 
                {
                    drawableCache.delete(key);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_107505203 = null;
        addTaint(drawableCache.getTaint());
        addTaint(key);
        Drawable varA7E53CE21691AB073D9660D615818899_1613976048; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1613976048 = varB4EAC82CA7396A68D541C85D26508E83_1356440465;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1613976048 = varB4EAC82CA7396A68D541C85D26508E83_107505203;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1613976048.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1613976048;
        
        
            
            
                
                
                    
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.110 -0400", hash_original_method = "035DC5FC794E074E6FAA3F20B34AB858", hash_generated_method = "875551A2B1D9D536DB9DBD7D150B75CE")
     ColorStateList loadColorStateList(TypedValue value, int id) throws NotFoundException {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1041063178 = null; 
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_63105012 = null; 
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_573922164 = null; 
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_998401492 = null; 
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1722257042 = null; 
        {
            {
                final String name = getResourceName(id);
                android.util.Log.d("PreloadColorStateList", name);
            } 
        } 
        final int key = (value.assetCookie << 24) | value.data;
        ColorStateList csl;
        {
            csl = mPreloadedColorStateLists.get(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1041063178 = csl;
            } 
            csl = ColorStateList.valueOf(value.data);
            {
                mPreloadedColorStateLists.put(key, csl);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_63105012 = csl;
        } 
        csl = getCachedColorStateList(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_573922164 = csl;
        } 
        csl = mPreloadedColorStateLists.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_998401492 = csl;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource is not a ColorStateList (color or path): " + value);
        } 
        String file = value.string.toString();
        {
            boolean varD5B89D7D99AA05BDEB10746CCC3A990F_362453652 = (file.endsWith(".xml"));
            {
                try 
                {
                    XmlResourceParser rp = loadXmlResourceParser(
                        file, id, value.assetCookie, "colorstatelist");
                    csl = ColorStateList.createFromXml(this, rp);
                    rp.close();
                } 
                catch (Exception e)
                {
                    NotFoundException rnf = new NotFoundException(
                    "File " + file + " from color state list resource ID #0x"
                    + Integer.toHexString(id));
                    rnf.initCause(e);
                    if (DroidSafeAndroidRuntime.control) throw rnf;
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "File " + file + " from drawable resource ID #0x"
                    + Integer.toHexString(id) + ": .xml extension required");
            } 
        } 
        {
            {
                mPreloadedColorStateLists.put(key, csl);
            } 
            {
                {
                    mColorStateListCache.put(
                        key, new WeakReference<ColorStateList>(csl));
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1722257042 = csl;
        addTaint(value.getTaint());
        addTaint(id);
        ColorStateList varA7E53CE21691AB073D9660D615818899_1839920524; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1839920524 = varB4EAC82CA7396A68D541C85D26508E83_1041063178;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1839920524 = varB4EAC82CA7396A68D541C85D26508E83_63105012;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1839920524 = varB4EAC82CA7396A68D541C85D26508E83_573922164;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1839920524 = varB4EAC82CA7396A68D541C85D26508E83_998401492;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1839920524 = varB4EAC82CA7396A68D541C85D26508E83_1722257042;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1839920524.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1839920524;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.113 -0400", hash_original_method = "B7AA5737FC7D8937CDF4D069CBD3DB14", hash_generated_method = "1F73CFEAE2032A4B3A2071331DF1758C")
    private ColorStateList getCachedColorStateList(int key) {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1539318609 = null; 
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_2104196231 = null; 
        {
            WeakReference<ColorStateList> wr = mColorStateListCache.get(key);
            {
                ColorStateList entry = wr.get();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1539318609 = entry;
                } 
                {
                    mColorStateListCache.delete(key);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2104196231 = null;
        addTaint(key);
        ColorStateList varA7E53CE21691AB073D9660D615818899_885953085; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_885953085 = varB4EAC82CA7396A68D541C85D26508E83_1539318609;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_885953085 = varB4EAC82CA7396A68D541C85D26508E83_2104196231;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_885953085.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_885953085;
        
        
            
            
                
                
                    
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.114 -0400", hash_original_method = "4C55C30B9C50C80710A05CFD192F83DB", hash_generated_method = "0E519AD26FA65FCDB8C237D0B92241CB")
     XmlResourceParser loadXmlResourceParser(int id, String type) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_267099759 = null; 
        {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            {
                varB4EAC82CA7396A68D541C85D26508E83_267099759 = loadXmlResourceParser(value.string.toString(), id,
                        value.assetCookie, type);
            } 
            if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        } 
        addTaint(id);
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_267099759.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_267099759;
        
        
            
            
            
                
                        
            
            
                    
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.116 -0400", hash_original_method = "B570E59A2D87535635D1C6300E407B49", hash_generated_method = "238A7DBB4E5D955EC0489785B7FF6287")
     XmlResourceParser loadXmlResourceParser(String file, int id,
            int assetCookie, String type) throws NotFoundException {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_176852266 = null; 
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_675437028 = null; 
        {
            try 
            {
                {
                    final int num = mCachedXmlBlockIds.length;
                    {
                        int i = 0;
                        {
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_176852266 = mCachedXmlBlocks[i].newParser();
                            } 
                        } 
                    } 
                    XmlBlock block = mAssets.openXmlBlockAsset(
                            assetCookie, file);
                    {
                        int pos = mLastCachedXmlBlockIndex+1;
                        pos = 0;
                        mLastCachedXmlBlockIndex = pos;
                        XmlBlock oldBlock = mCachedXmlBlocks[pos];
                        {
                            oldBlock.close();
                        } 
                        mCachedXmlBlockIds[pos] = id;
                        mCachedXmlBlocks[pos] = block;
                        varB4EAC82CA7396A68D541C85D26508E83_675437028 = block.newParser();
                    } 
                } 
            } 
            catch (Exception e)
            {
                NotFoundException rnf = new NotFoundException(
                        "File " + file + " from xml type " + type + " resource ID #0x"
                        + Integer.toHexString(id));
                rnf.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw rnf;
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException(
                "File " + file + " from xml type " + type + " resource ID #0x"
                + Integer.toHexString(id));
        addTaint(file.getTaint());
        addTaint(assetCookie);
        addTaint(type.getTaint());
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_251454839; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_251454839 = varB4EAC82CA7396A68D541C85D26508E83_176852266;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_251454839 = varB4EAC82CA7396A68D541C85D26508E83_675437028;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_251454839.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_251454839;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.117 -0400", hash_original_method = "EFFE2C2D7E798E7ABE4C38D3A3D2ED16", hash_generated_method = "B1105EC91AA12C75BA6A97DBB3058080")
    private TypedArray getCachedStyledAttributes(int len) {
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_575213919 = null; 
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_1950439986 = null; 
        TypedArray varB4EAC82CA7396A68D541C85D26508E83_1392786371 = null; 
        {
            TypedArray attrs = mCachedStyledAttributes;
            {
                mCachedStyledAttributes = null;
                {
                    mLastRetrievedAttrs = new RuntimeException("here");
                    mLastRetrievedAttrs.fillInStackTrace();
                } 
                attrs.mLength = len;
                int fullLen = len * AssetManager.STYLE_NUM_ENTRIES;
                {
                    varB4EAC82CA7396A68D541C85D26508E83_575213919 = attrs;
                } 
                attrs.mData = new int[fullLen];
                attrs.mIndices = new int[1+len];
                varB4EAC82CA7396A68D541C85D26508E83_1950439986 = attrs;
            } 
            {
                RuntimeException here = new RuntimeException("here");
                here.fillInStackTrace();
                mLastRetrievedAttrs = here;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1392786371 = new TypedArray(this,
                    new int[len*AssetManager.STYLE_NUM_ENTRIES],
                    new int[1+len], len);
        } 
        addTaint(len);
        TypedArray varA7E53CE21691AB073D9660D615818899_1507618177; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1507618177 = varB4EAC82CA7396A68D541C85D26508E83_575213919;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1507618177 = varB4EAC82CA7396A68D541C85D26508E83_1950439986;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1507618177 = varB4EAC82CA7396A68D541C85D26508E83_1392786371;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1507618177.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1507618177;
        
        
    }

    
    public static class NotFoundException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.118 -0400", hash_original_method = "16646BE2B605A836CC81C1207D23548C", hash_generated_method = "57BD6F9AE62C00D5DA005539BF3270C7")
        public  NotFoundException() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.118 -0400", hash_original_method = "4E6E00F1F6EDF0AE5B66F6F35CDBCBD1", hash_generated_method = "3B0DADC8F2E02A2F21624EB7BCDA9AFB")
        public  NotFoundException(String name) {
            super(name);
            addTaint(name.getTaint());
            
        }

        
    }


    
    public final class Theme {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.118 -0400", hash_original_field = "6B77D8F5873C91798F5C46B2D74971FD", hash_generated_field = "49B4A4B4F77DF85AA82FF83B2F894508")

        private AssetManager mAssets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.119 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.119 -0400", hash_original_method = "795E489BE8D614A2CE03C4AA3DA2CC6B", hash_generated_method = "DE2990E2EA434BEC4D2996B4934FFFEF")
          Theme() {
            mAssets = Resources.this.mAssets;
            mTheme = mAssets.createTheme();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.120 -0400", hash_original_method = "DC72D253295A0467BBA777314F2243D9", hash_generated_method = "6F00089DAD9B5AC538F6180D964E8265")
        public void applyStyle(int resid, boolean force) {
            AssetManager.applyThemeStyle(mTheme, resid, force);
            addTaint(resid);
            addTaint(force);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.120 -0400", hash_original_method = "16C1EE1974E6C30AE0CF98F33344DBAC", hash_generated_method = "DBC280FD1510E20895624E9132E857E0")
        public void setTo(Theme other) {
            AssetManager.copyTheme(mTheme, other.mTheme);
            addTaint(other.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.122 -0400", hash_original_method = "810F63867177324D3683F3630D8FEF5A", hash_generated_method = "64A4D3477539F014064F4793D1A6B0A7")
        public TypedArray obtainStyledAttributes(int[] attrs) {
            TypedArray varB4EAC82CA7396A68D541C85D26508E83_555565335 = null; 
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    array.mData, array.mIndices);
            varB4EAC82CA7396A68D541C85D26508E83_555565335 = array;
            addTaint(attrs[0]);
            varB4EAC82CA7396A68D541C85D26508E83_555565335.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_555565335;
            
            
            
            
            
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.124 -0400", hash_original_method = "09973A74CD9EB62806AFBCC15CD74823", hash_generated_method = "6C4E11F818CDD718A2814CEE0038C182")
        public TypedArray obtainStyledAttributes(int resid, int[] attrs) throws NotFoundException {
            TypedArray varB4EAC82CA7396A68D541C85D26508E83_1240590572 = null; 
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, resid, 0, attrs,
                    array.mData, array.mIndices);
            {
                int[] data = array.mData;
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("**********************************************************");
                System.out.println("Attributes:");
                String s = "  Attrs:";
                int i;
                {
                    i=0;
                    {
                        s = s + " 0x" + Integer.toHexString(attrs[i]);
                    } 
                } 
                System.out.println(s);
                s = "  Found:";
                TypedValue value = new TypedValue();
                {
                    i=0;
                    {
                        int d = i*AssetManager.STYLE_NUM_ENTRIES;
                        value.type = data[d+AssetManager.STYLE_TYPE];
                        value.data = data[d+AssetManager.STYLE_DATA];
                        value.assetCookie = data[d+AssetManager.STYLE_ASSET_COOKIE];
                        value.resourceId = data[d+AssetManager.STYLE_RESOURCE_ID];
                        s = s + " 0x" + Integer.toHexString(attrs[i])
                        + "=" + value;
                    } 
                } 
                System.out.println(s);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1240590572 = array;
            addTaint(resid);
            addTaint(attrs[0]);
            varB4EAC82CA7396A68D541C85D26508E83_1240590572.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1240590572;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.125 -0400", hash_original_method = "1F1D15615A0F17B362A611476D650DBA", hash_generated_method = "FE968EA178FE104A2476943E38E75F86")
        public TypedArray obtainStyledAttributes(AttributeSet set,
                int[] attrs, int defStyleAttr, int defStyleRes) {
            TypedArray varB4EAC82CA7396A68D541C85D26508E83_25192964 = null; 
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            XmlBlock.Parser parser = (XmlBlock.Parser)set;
            AssetManager.applyStyle(
                mTheme, defStyleAttr, defStyleRes,
                parser != null ? parser.mParseState : 0, attrs,
                        array.mData, array.mIndices);
            array.mRsrcs = attrs;
            array.mXml = parser;
            {
                int[] data = array.mData;
                System.out.println("Attributes:");
                String s = "  Attrs:";
                int i;
                {
                    i=0;
                    boolean var7FD042E7695005AA0C740C5D0A4B897B_1418646774 = (i<set.getAttributeCount());
                    {
                        s = s + " " + set.getAttributeName(i);
                        int id = set.getAttributeNameResource(i);
                        {
                            s = s + "(0x" + Integer.toHexString(id) + ")";
                        } 
                        s = s + "=" + set.getAttributeValue(i);
                    } 
                } 
                System.out.println(s);
                s = "  Found:";
                TypedValue value = new TypedValue();
                {
                    i=0;
                    {
                        int d = i*AssetManager.STYLE_NUM_ENTRIES;
                        value.type = data[d+AssetManager.STYLE_TYPE];
                        value.data = data[d+AssetManager.STYLE_DATA];
                        value.assetCookie = data[d+AssetManager.STYLE_ASSET_COOKIE];
                        value.resourceId = data[d+AssetManager.STYLE_RESOURCE_ID];
                        s = s + " 0x" + Integer.toHexString(attrs[i])
                        + "=" + value;
                    } 
                } 
                System.out.println(s);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_25192964 = array;
            addTaint(set.getTaint());
            addTaint(attrs[0]);
            addTaint(defStyleAttr);
            addTaint(defStyleRes);
            varB4EAC82CA7396A68D541C85D26508E83_25192964.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_25192964;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.126 -0400", hash_original_method = "CD4F3944F9E3B620EE3ED57C21E36085", hash_generated_method = "52F9E169E42DCDA2A8954BB92DB4E7ED")
        public boolean resolveAttribute(int resid, TypedValue outValue,
                boolean resolveRefs) {
            boolean got = mAssets.getThemeValue(mTheme, resid, outValue, resolveRefs);
            {
                System.out.println(
                    "resolveAttribute #" + Integer.toHexString(resid)
                    + " got=" + got + ", type=0x" + Integer.toHexString(outValue.type)
                    + ", data=0x" + Integer.toHexString(outValue.data));
            } 
            addTaint(resid);
            addTaint(outValue.getTaint());
            addTaint(resolveRefs);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806936252 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_806936252;
            
            
            
                
                    
                    
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_method = "AE42D7A6EFA93EEFF71D2B911A492F1C", hash_generated_method = "B281D1650257C007A55ABD7B29DD7B5A")
        public void dump(int priority, String tag, String prefix) {
            AssetManager.dumpTheme(mTheme, priority, tag, prefix);
            addTaint(priority);
            addTaint(tag.getTaint());
            addTaint(prefix.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_method = "E91350A0CB8175C6CA6A8BD390A0B4B8", hash_generated_method = "DD94C395EE3AEC455738317133548F9E")
        protected void finalize() throws Throwable {
            super.finalize();
            mAssets.releaseTheme(mTheme);
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_field = "FBDDF25CA08C49699D946174E1D868F3", hash_generated_field = "5C5F00C441325249E30C64C6E802A217")

    static final String TAG = "Resources";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_field = "2138514A04DE3271E8E9762F986419AB", hash_generated_field = "AF24F38B7F7C1BFCBE31FAF56BF34CB6")

    private static final boolean DEBUG_LOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_field = "C01A6DA6C0D699DBFE9F550B03D3AA4B", hash_generated_field = "131175486DA42E2C78B20447DB22788A")

    private static final boolean DEBUG_CONFIG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_field = "C9B635C9AE5915C59B3A508759AB54C2", hash_generated_field = "ED55101D7A3C371E9777857F76A372CF")

    private static final boolean DEBUG_ATTRIBUTES_CACHE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_field = "06CFFA21769AA1FA0FE0B7C5AF8F4325", hash_generated_field = "FE0143F1FA8AEE992FE6EE3E360B86DA")

    private static final boolean TRACE_FOR_PRELOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_field = "87FE77338788D21010DBC3495A87EB5C", hash_generated_field = "4CD3842605BE6EE30BF77207C2F75B29")

    private static final boolean TRACE_FOR_MISS_PRELOAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.127 -0400", hash_original_field = "15DFB0BA3D576A15F2D6FA24B909E58F", hash_generated_field = "C862CC81028DD3AA6BB9CABD701825FB")

    private static final int ID_OTHER = 0x01000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.128 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "F668D47897E28620543685D1E68BB2A5")

    private static final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.128 -0400", hash_original_field = "F4CCCEAC2DC610511BAB2E064360578D", hash_generated_field = "B0DD5DC72B0C526323B11A6CF67A9E4F")

    static Resources mSystem = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.128 -0400", hash_original_field = "28D6C8EDE085F2666953D9B90C99AD3C", hash_generated_field = "8013F7294F789DCD4E42A5967435E1AC")

    private static final LongSparseArray<Drawable.ConstantState> sPreloadedDrawables = new LongSparseArray<Drawable.ConstantState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.128 -0400", hash_original_field = "3053E35008A7FD238184E0C03BA1EE61", hash_generated_field = "7BD9FC30967896FB869451238EE23A0C")

    private static final SparseArray<ColorStateList> mPreloadedColorStateLists = new SparseArray<ColorStateList>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.128 -0400", hash_original_field = "8E30D292A97994C9D3BC6014424134D6", hash_generated_field = "235E8CAB2CC01C0FEFA2A60D1BF91B25")

    private static final LongSparseArray<Drawable.ConstantState> sPreloadedColorDrawables = new LongSparseArray<Drawable.ConstantState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.128 -0400", hash_original_field = "95F22ABFA5F2E9DF18A53D3B9A50C37A", hash_generated_field = "C895D84621E3994464E604D55CAE67F1")

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

