package android.speech.tts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import static android.provider.Settings.Secure.getString;
import android.provider.Settings;
import android.speech.tts.TextToSpeech.Engine;
import android.speech.tts.TextToSpeech.EngineInfo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class TtsEngines {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.444 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.445 -0400", hash_original_method = "E276758190DBE13181DF9330ABF915FA", hash_generated_method = "BBA0A4812D4E67B5F55600D1B9BB6415")
    public  TtsEngines(Context ctx) {
        mContext = ctx;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.445 -0400", hash_original_method = "F86D04A99B76CBDE409709AB3B031B49", hash_generated_method = "D643593D2B80A609089696EFB065B0B9")
    public String getDefaultEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1324162644 = null; 
        String engine = getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_SYNTH);
        varB4EAC82CA7396A68D541C85D26508E83_1324162644 = isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
        varB4EAC82CA7396A68D541C85D26508E83_1324162644.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1324162644;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.446 -0400", hash_original_method = "19A7DAF08EA8F2C03F3D1884DA46504A", hash_generated_method = "1415C61D89745054FC1C5A2EA7E64A34")
    public String getHighestRankedEngineName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2132121950 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_296480276 = null; 
        final List<EngineInfo> engines = getEngines();
        {
            boolean var1819F7731113A3DEF2529EB7CF4499F7_756545012 = (engines.size() > 0 && engines.get(0).system);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2132121950 = engines.get(0).name;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_296480276 = null;
        String varA7E53CE21691AB073D9660D615818899_1433199587; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1433199587 = varB4EAC82CA7396A68D541C85D26508E83_2132121950;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1433199587 = varB4EAC82CA7396A68D541C85D26508E83_296480276;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1433199587.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1433199587;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.447 -0400", hash_original_method = "A5DBD894AAA6A5E1130078152956054E", hash_generated_method = "652BB4545B4B6735325473C49F03EF8C")
    public EngineInfo getEngineInfo(String packageName) {
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_1966631029 = null; 
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_1392118279 = null; 
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(packageName);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_591534322 = (resolveInfos != null && resolveInfos.size() == 1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1966631029 = getEngineInfo(resolveInfos.get(0), pm);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1392118279 = null;
        addTaint(packageName.getTaint());
        EngineInfo varA7E53CE21691AB073D9660D615818899_1929516886; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1929516886 = varB4EAC82CA7396A68D541C85D26508E83_1966631029;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1929516886 = varB4EAC82CA7396A68D541C85D26508E83_1392118279;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1929516886.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1929516886;
        
        
        
        
        
                
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.450 -0400", hash_original_method = "DACAAA1F42C7CE1B11C8FF369696D83F", hash_generated_method = "BAF401A4389E1DC0D5C80BCAB0861E6B")
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_1917131985 = null; 
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_1164059735 = null; 
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent, PackageManager.MATCH_DEFAULT_ONLY);
        varB4EAC82CA7396A68D541C85D26508E83_1917131985 = Collections.emptyList();
        List<EngineInfo> engines = new ArrayList<EngineInfo>(resolveInfos.size());
        {
            Iterator<ResolveInfo> varA26DD4CAE8F7472DF523963F56C59876_15060555 = (resolveInfos).iterator();
            varA26DD4CAE8F7472DF523963F56C59876_15060555.hasNext();
            ResolveInfo resolveInfo = varA26DD4CAE8F7472DF523963F56C59876_15060555.next();
            {
                EngineInfo engine = getEngineInfo(resolveInfo, pm);
                {
                    engines.add(engine);
                } 
            } 
        } 
        Collections.sort(engines, EngineInfoComparator.INSTANCE);
        varB4EAC82CA7396A68D541C85D26508E83_1164059735 = engines;
        List<EngineInfo> varA7E53CE21691AB073D9660D615818899_935276861; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_935276861 = varB4EAC82CA7396A68D541C85D26508E83_1917131985;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_935276861 = varB4EAC82CA7396A68D541C85D26508E83_1164059735;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_935276861.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_935276861;
        
        
        
        
                
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.450 -0400", hash_original_method = "096C3576F274D5610E35106CC045EF53", hash_generated_method = "7983B7022CC8422F8943622F260715C4")
    private boolean isSystemEngine(ServiceInfo info) {
        final ApplicationInfo appInfo = info.applicationInfo;
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632401774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_632401774;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.451 -0400", hash_original_method = "6576B103C8DDCA7E7096DC36C32D66CE", hash_generated_method = "8511D648A415128570C115E168310EC3")
    public boolean isEngineInstalled(String engine) {
        boolean varD11D9232D99EE58E44DC1B185B61381D_462229730 = (getEngineInfo(engine) != null);
        addTaint(engine.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197516295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197516295;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.451 -0400", hash_original_method = "081B98AA3A6A550A7C51DCB59AD3D4CC", hash_generated_method = "7B28501A83D77AA53442E7E83AFA2B61")
    public Intent getSettingsIntent(String engine) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_650323356 = null; 
        Intent varB4EAC82CA7396A68D541C85D26508E83_2023708624 = null; 
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_META_DATA);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_446635137 = (resolveInfos != null && resolveInfos.size() == 1);
            {
                ServiceInfo service = resolveInfos.get(0).serviceInfo;
                {
                    final String settings = settingsActivityFromServiceInfo(service, pm);
                    {
                        Intent i = new Intent();
                        i.setClassName(engine, settings);
                        varB4EAC82CA7396A68D541C85D26508E83_650323356 = i;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2023708624 = null;
        addTaint(engine.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_482659564; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_482659564 = varB4EAC82CA7396A68D541C85D26508E83_650323356;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_482659564 = varB4EAC82CA7396A68D541C85D26508E83_2023708624;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_482659564.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_482659564;
        
        
        
        
        
                
        
            
            
                
                
                    
                    
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.453 -0400", hash_original_method = "9D4652ECD9FA23521B324D3DE279FEF6", hash_generated_method = "D11D5AB3988889F49DA856916DFEED20")
    private String settingsActivityFromServiceInfo(ServiceInfo si, PackageManager pm) {
        String varB4EAC82CA7396A68D541C85D26508E83_1838170410 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_638096543 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_991848534 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_887935284 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1488528848 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_740552779 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_60471548 = null; 
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, TextToSpeech.Engine.SERVICE_META_DATA);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1838170410 = null;
            } 
            final Resources res = pm.getResourcesForApplication(si.applicationInfo);
            int type;
            {
                boolean var670879A2F0FFF8F0B25FD974769B483B_481984128 = ((type = parser.next()) != XmlResourceParser.END_DOCUMENT);
                {
                    {
                        {
                            boolean varFA11C2F42D95D261E4941ADF07065428_1124716689 = (!XML_TAG_NAME.equals(parser.getName()));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_638096543 = null;
                            } 
                        } 
                        final AttributeSet attrs = Xml.asAttributeSet(parser);
                        final TypedArray array = res.obtainAttributes(attrs,
                            com.android.internal.R.styleable.TextToSpeechEngine);
                        final String settings = array.getString(
                            com.android.internal.R.styleable.TextToSpeechEngine_settingsActivity);
                        array.recycle();
                        varB4EAC82CA7396A68D541C85D26508E83_991848534 = settings;
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_887935284 = null;
        } 
        catch (NameNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1488528848 = null;
        } 
        catch (XmlPullParserException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_740552779 = null;
        } 
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_60471548 = null;
        } 
        finally 
        {
            {
                parser.close();
            } 
        } 
        addTaint(si.getTaint());
        addTaint(pm.getTaint());
        String varA7E53CE21691AB073D9660D615818899_394978232; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_394978232 = varB4EAC82CA7396A68D541C85D26508E83_1838170410;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_394978232 = varB4EAC82CA7396A68D541C85D26508E83_638096543;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_394978232 = varB4EAC82CA7396A68D541C85D26508E83_991848534;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_394978232 = varB4EAC82CA7396A68D541C85D26508E83_887935284;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_394978232 = varB4EAC82CA7396A68D541C85D26508E83_1488528848;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_394978232 = varB4EAC82CA7396A68D541C85D26508E83_740552779;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_394978232 = varB4EAC82CA7396A68D541C85D26508E83_60471548;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_394978232.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_394978232;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.454 -0400", hash_original_method = "AAFB3DF5C9862013F914C97CA1EC4890", hash_generated_method = "C3BBA2A6EAA2AACB41D6AE93A23F45E1")
    private EngineInfo getEngineInfo(ResolveInfo resolve, PackageManager pm) {
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_1743926769 = null; 
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_959249140 = null; 
        ServiceInfo service = resolve.serviceInfo;
        {
            EngineInfo engine = new EngineInfo();
            engine.name = service.packageName;
            CharSequence label = service.loadLabel(pm);
            engine.label = TextUtils.isEmpty(label) ? engine.name : label.toString();
            engine.icon = service.getIconResource();
            engine.priority = resolve.priority;
            engine.system = isSystemEngine(service);
            varB4EAC82CA7396A68D541C85D26508E83_1743926769 = engine;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_959249140 = null;
        addTaint(resolve.getTaint());
        addTaint(pm.getTaint());
        EngineInfo varA7E53CE21691AB073D9660D615818899_417452352; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_417452352 = varB4EAC82CA7396A68D541C85D26508E83_1743926769;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_417452352 = varB4EAC82CA7396A68D541C85D26508E83_959249140;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_417452352.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_417452352;
        
        
        
            
            
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.454 -0400", hash_original_method = "18ECF8DE6689127C36214444D644F0A3", hash_generated_method = "8C946801A182CED6F0C4773F49113909")
    public String getLocalePrefForEngine(String engineName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1983215070 = null; 
        String locale = parseEnginePrefFromList(
                getString(mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE),
                engineName);
        {
            boolean var687197B3D19FCF75669D4532E67850C1_888067568 = (TextUtils.isEmpty(locale));
            {
                locale = getV1Locale();
            } 
        } 
        Log.d(TAG, "getLocalePrefForEngine(" + engineName + ")= " + locale);
        varB4EAC82CA7396A68D541C85D26508E83_1983215070 = locale;
        addTaint(engineName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1983215070.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1983215070;
        
        
                
                
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] parseLocalePref(String pref) {
        String[] returnVal = new String[] { "", "", ""};
        if (!TextUtils.isEmpty(pref)) {
            String[] split = pref.split(LOCALE_DELIMITER);
            System.arraycopy(split, 0, returnVal, 0, split.length);
        }
        if (DBG) Log.d(TAG, "parseLocalePref(" + returnVal[0] + "," + returnVal[1] +
                "," + returnVal[2] +")");
        return returnVal;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.455 -0400", hash_original_method = "610702C4AF37E3C5EE6AAD794DF1E7DF", hash_generated_method = "32ACBAB2FA7340C5393340720AFB1D52")
    private String getV1Locale() {
        String varB4EAC82CA7396A68D541C85D26508E83_1617305565 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1638795011 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1276446575 = null; 
        final ContentResolver cr = mContext.getContentResolver();
        final String lang = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_LANG);
        final String country = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_COUNTRY);
        final String variant = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_VARIANT);
        {
            boolean var1A8AF987D7090BF21E59CC020666928D_210785737 = (TextUtils.isEmpty(lang));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1617305565 = getDefaultLocale();
            } 
        } 
        String v1Locale = lang;
        {
            boolean var1131EEE25553582BB000C21570B7E530_2075185196 = (!TextUtils.isEmpty(country));
            {
                v1Locale += LOCALE_DELIMITER + country;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1638795011 = v1Locale;
            } 
        } 
        {
            boolean var2AE2FA07CFAC0698DFBA08380E8EE573_267947361 = (!TextUtils.isEmpty(variant));
            {
                v1Locale += LOCALE_DELIMITER + variant;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1276446575 = v1Locale;
        String varA7E53CE21691AB073D9660D615818899_2064356527; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2064356527 = varB4EAC82CA7396A68D541C85D26508E83_1617305565;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2064356527 = varB4EAC82CA7396A68D541C85D26508E83_1638795011;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2064356527 = varB4EAC82CA7396A68D541C85D26508E83_1276446575;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2064356527.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2064356527;
        
        
        
        
        
        
            
        
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.457 -0400", hash_original_method = "DCEE8BF4C9B6F52F0B0F667E0393B18E", hash_generated_method = "5B88120D0D2E711C57A6C46623BACB75")
    private String getDefaultLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_1588904498 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2041742875 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2049835864 = null; 
        final Locale locale = Locale.getDefault();
        String defaultLocale = locale.getISO3Language();
        {
            boolean varB133EB656C0D5A870AC3D0136962B7D0_1747694694 = (TextUtils.isEmpty(defaultLocale));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1588904498 = "";
            } 
        } 
        {
            boolean var1D637D5D98C12045DF81F123BBBAD5ED_982828602 = (!TextUtils.isEmpty(locale.getISO3Country()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getISO3Country();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2041742875 = defaultLocale;
            } 
        } 
        {
            boolean var3A36AF7705C26D85B1613F262B79562C_1655571975 = (!TextUtils.isEmpty(locale.getVariant()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getVariant();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2049835864 = defaultLocale;
        String varA7E53CE21691AB073D9660D615818899_1616003651; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1616003651 = varB4EAC82CA7396A68D541C85D26508E83_1588904498;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1616003651 = varB4EAC82CA7396A68D541C85D26508E83_2041742875;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1616003651 = varB4EAC82CA7396A68D541C85D26508E83_2049835864;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1616003651.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1616003651;
        
        
        
        
            
            
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static String parseEnginePrefFromList(String prefValue, String engineName) {
        if (TextUtils.isEmpty(prefValue)) {
            return null;
        }
        String[] prefValues = prefValue.split(",");
        for (String value : prefValues) {
            final int delimiter = value.indexOf(':');
            if (delimiter > 0) {
                if (engineName.equals(value.substring(0, delimiter))) {
                    return value.substring(delimiter + 1);
                }
            }
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.458 -0400", hash_original_method = "9D847C860A473B48E829C1EE33625F6B", hash_generated_method = "62F204F625F7D16D47A06B163A0A1AED")
    public synchronized void updateLocalePrefForEngine(String name, String newLocale) {
        final String prefList = Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_LOCALE);
        {
            Log.d(TAG, "updateLocalePrefForEngine(" + name + ", " + newLocale +
                    "), originally: " + prefList);
        } 
        final String newPrefList = updateValueInCommaSeparatedList(prefList,
                name, newLocale);
        Log.d(TAG, "updateLocalePrefForEngine(), writing: " + newPrefList.toString());
        Settings.Secure.putString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_LOCALE, newPrefList.toString());
        addTaint(name.getTaint());
        addTaint(newLocale.getTaint());
        
        
                
        
            
                    
        
        
                
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.221 -0400", hash_original_method = "00BF6BD14B34E2134A0C0EF2661B3919", hash_generated_method = "B3465C14A1B8DA0210D2E760B7EF7DC3")
    private String updateValueInCommaSeparatedList(String list, String key,
            String newValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_551477658 = null; 
        StringBuilder newPrefList;
        newPrefList = new StringBuilder();
        {
            boolean varE09F2D7ADA4E79BF05A28AAF80E5C108_1108786309 = (TextUtils.isEmpty(list));
            {
                newPrefList.append(key).append(':').append(newValue);
            } 
            {
                String[] prefValues;
                prefValues = list.split(",");
                boolean first;
                first = true;
                boolean found;
                found = false;
                {
                    String value = prefValues[0];
                    {
                        int delimiter;
                        delimiter = value.indexOf(':');
                        {
                            {
                                boolean var83DE1D06394DC0CDFCF59CED90A2B2B3_1028199941 = (key.equals(value.substring(0, delimiter)));
                                {
                                    {
                                        first = false;
                                    } 
                                    {
                                        newPrefList.append(',');
                                    } 
                                    found = true;
                                    newPrefList.append(key).append(':').append(newValue);
                                } 
                                {
                                    {
                                        first = false;
                                    } 
                                    {
                                        newPrefList.append(',');
                                    } 
                                    newPrefList.append(value);
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    newPrefList.append(',');
                    newPrefList.append(key).append(':').append(newValue);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_551477658 = newPrefList.toString();
        addTaint(list.getTaint());
        addTaint(key.getTaint());
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_551477658.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_551477658;
        
        
    }

    
    private static class EngineInfoComparator implements Comparator<EngineInfo> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.460 -0400", hash_original_method = "81257836895CDB49D308B7B95E17876A", hash_generated_method = "046E030CC996B69833C1997F8A404D60")
        private  EngineInfoComparator() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.461 -0400", hash_original_method = "E919388D461770C5E68C050C2BB6D626", hash_generated_method = "F4A15AA138A2BD8631A1CC9679F16E93")
        @Override
        public int compare(EngineInfo lhs, EngineInfo rhs) {
            addTaint(lhs.getTaint());
            addTaint(rhs.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698220519 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698220519;
            
            
                
            
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.461 -0400", hash_original_field = "22942468BDA180222A2983F0C420C983", hash_generated_field = "0CA244E03083D2D3306A1733CBDEDA51")

        static EngineInfoComparator INSTANCE = new EngineInfoComparator();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.461 -0400", hash_original_field = "83DB52A3C8D0B140F75136D958DB3D67", hash_generated_field = "C4D788B9A30DB979B4B514CACCF1BB4B")

    private static final String TAG = "TtsEngines";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.461 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.461 -0400", hash_original_field = "861A0D790598FEE23451761E6E4C316A", hash_generated_field = "187C46D90E30A2E475FC964C28714A03")

    private static final String LOCALE_DELIMITER = "-";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.461 -0400", hash_original_field = "E761C2AF1B4C23BBB2D60DB5C2ADDF10", hash_generated_field = "FD63E60582DCF4480EDEA7A7945C3DEB")

    private static final String XML_TAG_NAME = "tts-engine";
}

