package android.speech.tts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.731 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.731 -0400", hash_original_method = "E276758190DBE13181DF9330ABF915FA", hash_generated_method = "BBA0A4812D4E67B5F55600D1B9BB6415")
    public  TtsEngines(Context ctx) {
        mContext = ctx;
        // ---------- Original Method ----------
        //mContext = ctx;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.746 -0400", hash_original_method = "F86D04A99B76CBDE409709AB3B031B49", hash_generated_method = "804C551891D21886E800EA5B75B07422")
    public String getDefaultEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_2140140107 = null; //Variable for return #1
        String engine;
        engine = getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_SYNTH);
        varB4EAC82CA7396A68D541C85D26508E83_2140140107 = isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
        varB4EAC82CA7396A68D541C85D26508E83_2140140107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2140140107;
        // ---------- Original Method ----------
        //String engine = getString(mContext.getContentResolver(),
                //Settings.Secure.TTS_DEFAULT_SYNTH);
        //return isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.751 -0400", hash_original_method = "19A7DAF08EA8F2C03F3D1884DA46504A", hash_generated_method = "90E0F17FB8771B34E3615858BD3CBF14")
    public String getHighestRankedEngineName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1193285110 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1982372150 = null; //Variable for return #2
        List<EngineInfo> engines;
        engines = getEngines();
        {
            boolean var1819F7731113A3DEF2529EB7CF4499F7_1002237765 = (engines.size() > 0 && engines.get(0).system);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1193285110 = engines.get(0).name;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1982372150 = null;
        String varA7E53CE21691AB073D9660D615818899_762285175; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_762285175 = varB4EAC82CA7396A68D541C85D26508E83_1193285110;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_762285175 = varB4EAC82CA7396A68D541C85D26508E83_1982372150;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_762285175.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_762285175;
        // ---------- Original Method ----------
        //final List<EngineInfo> engines = getEngines();
        //if (engines.size() > 0 && engines.get(0).system) {
            //return engines.get(0).name;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.770 -0400", hash_original_method = "A5DBD894AAA6A5E1130078152956054E", hash_generated_method = "EEA0E37E1F4E03DC36884B38F9EF2B59")
    public EngineInfo getEngineInfo(String packageName) {
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_1641244187 = null; //Variable for return #1
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_1283393834 = null; //Variable for return #2
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(packageName);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_1360903672 = (resolveInfos != null && resolveInfos.size() == 1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1641244187 = getEngineInfo(resolveInfos.get(0), pm);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1283393834 = null;
        addTaint(packageName.getTaint());
        EngineInfo varA7E53CE21691AB073D9660D615818899_484082098; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_484082098 = varB4EAC82CA7396A68D541C85D26508E83_1641244187;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_484082098 = varB4EAC82CA7396A68D541C85D26508E83_1283393834;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_484082098.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_484082098;
        // ---------- Original Method ----------
        //PackageManager pm = mContext.getPackageManager();
        //Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        //intent.setPackage(packageName);
        //List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                //PackageManager.MATCH_DEFAULT_ONLY);
        //if (resolveInfos != null && resolveInfos.size() == 1) {
            //return getEngineInfo(resolveInfos.get(0), pm);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.788 -0400", hash_original_method = "DACAAA1F42C7CE1B11C8FF369696D83F", hash_generated_method = "CAC471AFF4460FD111F69B00E95B5671")
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_397098582 = null; //Variable for return #1
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_632706362 = null; //Variable for return #2
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent, PackageManager.MATCH_DEFAULT_ONLY);
        varB4EAC82CA7396A68D541C85D26508E83_397098582 = Collections.emptyList();
        List<EngineInfo> engines;
        engines = new ArrayList<EngineInfo>(resolveInfos.size());
        {
            Iterator<ResolveInfo> varA26DD4CAE8F7472DF523963F56C59876_2077653072 = (resolveInfos).iterator();
            varA26DD4CAE8F7472DF523963F56C59876_2077653072.hasNext();
            ResolveInfo resolveInfo = varA26DD4CAE8F7472DF523963F56C59876_2077653072.next();
            {
                EngineInfo engine;
                engine = getEngineInfo(resolveInfo, pm);
                {
                    engines.add(engine);
                } //End block
            } //End block
        } //End collapsed parenthetic
        Collections.sort(engines, EngineInfoComparator.INSTANCE);
        varB4EAC82CA7396A68D541C85D26508E83_632706362 = engines;
        List<EngineInfo> varA7E53CE21691AB073D9660D615818899_629890078; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_629890078 = varB4EAC82CA7396A68D541C85D26508E83_397098582;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_629890078 = varB4EAC82CA7396A68D541C85D26508E83_632706362;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_629890078.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_629890078;
        // ---------- Original Method ----------
        //PackageManager pm = mContext.getPackageManager();
        //Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        //List<ResolveInfo> resolveInfos =
                //pm.queryIntentServices(intent, PackageManager.MATCH_DEFAULT_ONLY);
        //if (resolveInfos == null) return Collections.emptyList();
        //List<EngineInfo> engines = new ArrayList<EngineInfo>(resolveInfos.size());
        //for (ResolveInfo resolveInfo : resolveInfos) {
            //EngineInfo engine = getEngineInfo(resolveInfo, pm);
            //if (engine != null) {
                //engines.add(engine);
            //}
        //}
        //Collections.sort(engines, EngineInfoComparator.INSTANCE);
        //return engines;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.789 -0400", hash_original_method = "096C3576F274D5610E35106CC045EF53", hash_generated_method = "0A63F4A65ABC0F728E0E22D3D327FB2B")
    private boolean isSystemEngine(ServiceInfo info) {
        ApplicationInfo appInfo;
        appInfo = info.applicationInfo;
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1567637709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1567637709;
        // ---------- Original Method ----------
        //final ApplicationInfo appInfo = info.applicationInfo;
        //return appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.789 -0400", hash_original_method = "6576B103C8DDCA7E7096DC36C32D66CE", hash_generated_method = "F98AE85B21D95A4A64BE2787471510B3")
    public boolean isEngineInstalled(String engine) {
        boolean varD11D9232D99EE58E44DC1B185B61381D_1919179060 = (getEngineInfo(engine) != null);
        addTaint(engine.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732454921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_732454921;
        // ---------- Original Method ----------
        //if (engine == null) {
            //return false;
        //}
        //return getEngineInfo(engine) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.790 -0400", hash_original_method = "081B98AA3A6A550A7C51DCB59AD3D4CC", hash_generated_method = "0A70CE808AAEB2125A05D2D497DA706E")
    public Intent getSettingsIntent(String engine) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1765072509 = null; //Variable for return #1
        Intent varB4EAC82CA7396A68D541C85D26508E83_620569564 = null; //Variable for return #2
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_META_DATA);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_753322454 = (resolveInfos != null && resolveInfos.size() == 1);
            {
                ServiceInfo service;
                service = resolveInfos.get(0).serviceInfo;
                {
                    String settings;
                    settings = settingsActivityFromServiceInfo(service, pm);
                    {
                        Intent i;
                        i = new Intent();
                        i.setClassName(engine, settings);
                        varB4EAC82CA7396A68D541C85D26508E83_1765072509 = i;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_620569564 = null;
        addTaint(engine.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_1954721500; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1954721500 = varB4EAC82CA7396A68D541C85D26508E83_1765072509;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1954721500 = varB4EAC82CA7396A68D541C85D26508E83_620569564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1954721500.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1954721500;
        // ---------- Original Method ----------
        //PackageManager pm = mContext.getPackageManager();
        //Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        //intent.setPackage(engine);
        //List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                //PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_META_DATA);
        //if (resolveInfos != null && resolveInfos.size() == 1) {
            //ServiceInfo service = resolveInfos.get(0).serviceInfo;
            //if (service != null) {
                //final String settings = settingsActivityFromServiceInfo(service, pm);
                //if (settings != null) {
                    //Intent i = new Intent();
                    //i.setClassName(engine, settings);
                    //return i;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.821 -0400", hash_original_method = "9D4652ECD9FA23521B324D3DE279FEF6", hash_generated_method = "78F191C211F8DFE94496B3C8FC27038B")
    private String settingsActivityFromServiceInfo(ServiceInfo si, PackageManager pm) {
        String varB4EAC82CA7396A68D541C85D26508E83_1083667991 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_817789265 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1906968945 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_364178453 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_81018266 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_2034457826 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_533350979 = null; //Variable for return #7
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, TextToSpeech.Engine.SERVICE_META_DATA);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1083667991 = null;
            } //End block
            Resources res;
            res = pm.getResourcesForApplication(si.applicationInfo);
            int type;
            {
                boolean var670879A2F0FFF8F0B25FD974769B483B_39148274 = ((type = parser.next()) != XmlResourceParser.END_DOCUMENT);
                {
                    {
                        {
                            boolean varFA11C2F42D95D261E4941ADF07065428_1691307469 = (!XML_TAG_NAME.equals(parser.getName()));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_817789265 = null;
                            } //End block
                        } //End collapsed parenthetic
                        AttributeSet attrs;
                        attrs = Xml.asAttributeSet(parser);
                        TypedArray array;
                        array = res.obtainAttributes(attrs,
                            com.android.internal.R.styleable.TextToSpeechEngine);
                        String settings;
                        settings = array.getString(
                            com.android.internal.R.styleable.TextToSpeechEngine_settingsActivity);
                        array.recycle();
                        varB4EAC82CA7396A68D541C85D26508E83_1906968945 = settings;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_364178453 = null;
        } //End block
        catch (NameNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_81018266 = null;
        } //End block
        catch (XmlPullParserException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2034457826 = null;
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_533350979 = null;
        } //End block
        finally 
        {
            {
                parser.close();
            } //End block
        } //End block
        addTaint(si.getTaint());
        addTaint(pm.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2038417652; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2038417652 = varB4EAC82CA7396A68D541C85D26508E83_1083667991;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2038417652 = varB4EAC82CA7396A68D541C85D26508E83_817789265;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2038417652 = varB4EAC82CA7396A68D541C85D26508E83_1906968945;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2038417652 = varB4EAC82CA7396A68D541C85D26508E83_364178453;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2038417652 = varB4EAC82CA7396A68D541C85D26508E83_81018266;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_2038417652 = varB4EAC82CA7396A68D541C85D26508E83_2034457826;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2038417652 = varB4EAC82CA7396A68D541C85D26508E83_533350979;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2038417652.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2038417652;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.823 -0400", hash_original_method = "AAFB3DF5C9862013F914C97CA1EC4890", hash_generated_method = "3902640F157E0C92857E9893F4808D14")
    private EngineInfo getEngineInfo(ResolveInfo resolve, PackageManager pm) {
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_45442800 = null; //Variable for return #1
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_598617411 = null; //Variable for return #2
        ServiceInfo service;
        service = resolve.serviceInfo;
        {
            EngineInfo engine;
            engine = new EngineInfo();
            engine.name = service.packageName;
            CharSequence label;
            label = service.loadLabel(pm);
            engine.label = TextUtils.isEmpty(label) ? engine.name : label.toString();
            engine.icon = service.getIconResource();
            engine.priority = resolve.priority;
            engine.system = isSystemEngine(service);
            varB4EAC82CA7396A68D541C85D26508E83_45442800 = engine;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_598617411 = null;
        addTaint(resolve.getTaint());
        addTaint(pm.getTaint());
        EngineInfo varA7E53CE21691AB073D9660D615818899_928412407; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_928412407 = varB4EAC82CA7396A68D541C85D26508E83_45442800;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_928412407 = varB4EAC82CA7396A68D541C85D26508E83_598617411;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_928412407.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_928412407;
        // ---------- Original Method ----------
        //ServiceInfo service = resolve.serviceInfo;
        //if (service != null) {
            //EngineInfo engine = new EngineInfo();
            //engine.name = service.packageName;
            //CharSequence label = service.loadLabel(pm);
            //engine.label = TextUtils.isEmpty(label) ? engine.name : label.toString();
            //engine.icon = service.getIconResource();
            //engine.priority = resolve.priority;
            //engine.system = isSystemEngine(service);
            //return engine;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.824 -0400", hash_original_method = "18ECF8DE6689127C36214444D644F0A3", hash_generated_method = "14F9A28837DC18783AB1521F31C254A8")
    public String getLocalePrefForEngine(String engineName) {
        String varB4EAC82CA7396A68D541C85D26508E83_868839712 = null; //Variable for return #1
        String locale;
        locale = parseEnginePrefFromList(
                getString(mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE),
                engineName);
        {
            boolean var687197B3D19FCF75669D4532E67850C1_1706762163 = (TextUtils.isEmpty(locale));
            {
                locale = getV1Locale();
            } //End block
        } //End collapsed parenthetic
        Log.d(TAG, "getLocalePrefForEngine(" + engineName + ")= " + locale);
        varB4EAC82CA7396A68D541C85D26508E83_868839712 = locale;
        addTaint(engineName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_868839712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_868839712;
        // ---------- Original Method ----------
        //String locale = parseEnginePrefFromList(
                //getString(mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE),
                //engineName);
        //if (TextUtils.isEmpty(locale)) {
            //locale = getV1Locale();
        //}
        //if (DBG) Log.d(TAG, "getLocalePrefForEngine(" + engineName + ")= " + locale);
        //return locale;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.837 -0400", hash_original_method = "610702C4AF37E3C5EE6AAD794DF1E7DF", hash_generated_method = "035DE22473102AF6EC7ADC8473E0F2F7")
    private String getV1Locale() {
        String varB4EAC82CA7396A68D541C85D26508E83_1709758759 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_619733855 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_516219081 = null; //Variable for return #3
        ContentResolver cr;
        cr = mContext.getContentResolver();
        String lang;
        lang = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_LANG);
        String country;
        country = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_COUNTRY);
        String variant;
        variant = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_VARIANT);
        {
            boolean var1A8AF987D7090BF21E59CC020666928D_1071543738 = (TextUtils.isEmpty(lang));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1709758759 = getDefaultLocale();
            } //End block
        } //End collapsed parenthetic
        String v1Locale;
        v1Locale = lang;
        {
            boolean var1131EEE25553582BB000C21570B7E530_851681422 = (!TextUtils.isEmpty(country));
            {
                v1Locale += LOCALE_DELIMITER + country;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_619733855 = v1Locale;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2AE2FA07CFAC0698DFBA08380E8EE573_1788077307 = (!TextUtils.isEmpty(variant));
            {
                v1Locale += LOCALE_DELIMITER + variant;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_516219081 = v1Locale;
        String varA7E53CE21691AB073D9660D615818899_1822540594; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1822540594 = varB4EAC82CA7396A68D541C85D26508E83_1709758759;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1822540594 = varB4EAC82CA7396A68D541C85D26508E83_619733855;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1822540594 = varB4EAC82CA7396A68D541C85D26508E83_516219081;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1822540594.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1822540594;
        // ---------- Original Method ----------
        //final ContentResolver cr = mContext.getContentResolver();
        //final String lang = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_LANG);
        //final String country = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_COUNTRY);
        //final String variant = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_VARIANT);
        //if (TextUtils.isEmpty(lang)) {
            //return getDefaultLocale();
        //}
        //String v1Locale = lang;
        //if (!TextUtils.isEmpty(country)) {
            //v1Locale += LOCALE_DELIMITER + country;
        //} else {
            //return v1Locale;
        //}
        //if (!TextUtils.isEmpty(variant)) {
            //v1Locale += LOCALE_DELIMITER + variant;
        //}
        //return v1Locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.850 -0400", hash_original_method = "DCEE8BF4C9B6F52F0B0F667E0393B18E", hash_generated_method = "073857AD8ACD22FA35A873921E4CAB95")
    private String getDefaultLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_612217269 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1694302988 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1127209621 = null; //Variable for return #3
        Locale locale;
        locale = Locale.getDefault();
        String defaultLocale;
        defaultLocale = locale.getISO3Language();
        {
            boolean varB133EB656C0D5A870AC3D0136962B7D0_1695217158 = (TextUtils.isEmpty(defaultLocale));
            {
                varB4EAC82CA7396A68D541C85D26508E83_612217269 = "";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1D637D5D98C12045DF81F123BBBAD5ED_1063559424 = (!TextUtils.isEmpty(locale.getISO3Country()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getISO3Country();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1694302988 = defaultLocale;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3A36AF7705C26D85B1613F262B79562C_2066385181 = (!TextUtils.isEmpty(locale.getVariant()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getVariant();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1127209621 = defaultLocale;
        String varA7E53CE21691AB073D9660D615818899_942383048; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_942383048 = varB4EAC82CA7396A68D541C85D26508E83_612217269;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_942383048 = varB4EAC82CA7396A68D541C85D26508E83_1694302988;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_942383048 = varB4EAC82CA7396A68D541C85D26508E83_1127209621;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_942383048.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_942383048;
        // ---------- Original Method ----------
        //final Locale locale = Locale.getDefault();
        //String defaultLocale = locale.getISO3Language();
        //if (TextUtils.isEmpty(defaultLocale)) {
            //Log.w(TAG, "Default locale is empty.");
            //return "";
        //}
        //if (!TextUtils.isEmpty(locale.getISO3Country())) {
            //defaultLocale += LOCALE_DELIMITER + locale.getISO3Country();
        //} else {
            //return defaultLocale;
        //}
        //if (!TextUtils.isEmpty(locale.getVariant())) {
            //defaultLocale += LOCALE_DELIMITER + locale.getVariant();
        //}
        //return defaultLocale;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.852 -0400", hash_original_method = "9D847C860A473B48E829C1EE33625F6B", hash_generated_method = "8BB13425D875E68276D7A9F92D6880B6")
    public synchronized void updateLocalePrefForEngine(String name, String newLocale) {
        String prefList;
        prefList = Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_LOCALE);
        {
            Log.d(TAG, "updateLocalePrefForEngine(" + name + ", " + newLocale +
                    "), originally: " + prefList);
        } //End block
        String newPrefList;
        newPrefList = updateValueInCommaSeparatedList(prefList,
                name, newLocale);
        Log.d(TAG, "updateLocalePrefForEngine(), writing: " + newPrefList.toString());
        Settings.Secure.putString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_LOCALE, newPrefList.toString());
        addTaint(name.getTaint());
        addTaint(newLocale.getTaint());
        // ---------- Original Method ----------
        //final String prefList = Settings.Secure.getString(mContext.getContentResolver(),
                //Settings.Secure.TTS_DEFAULT_LOCALE);
        //if (DBG) {
            //Log.d(TAG, "updateLocalePrefForEngine(" + name + ", " + newLocale +
                    //"), originally: " + prefList);
        //}
        //final String newPrefList = updateValueInCommaSeparatedList(prefList,
                //name, newLocale);
        //if (DBG) Log.d(TAG, "updateLocalePrefForEngine(), writing: " + newPrefList.toString());
        //Settings.Secure.putString(mContext.getContentResolver(),
                //Settings.Secure.TTS_DEFAULT_LOCALE, newPrefList.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.077 -0400", hash_original_method = "00BF6BD14B34E2134A0C0EF2661B3919", hash_generated_method = "3CBCEA0A7DD3EB9033D7BCDA9BADF2A8")
    private String updateValueInCommaSeparatedList(String list, String key,
            String newValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_1127907196 = null; //Variable for return #1
        StringBuilder newPrefList;
        newPrefList = new StringBuilder();
        {
            boolean varE09F2D7ADA4E79BF05A28AAF80E5C108_1649899210 = (TextUtils.isEmpty(list));
            {
                newPrefList.append(key).append(':').append(newValue);
            } //End block
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
                                boolean var83DE1D06394DC0CDFCF59CED90A2B2B3_2135898296 = (key.equals(value.substring(0, delimiter)));
                                {
                                    {
                                        first = false;
                                    } //End block
                                    {
                                        newPrefList.append(',');
                                    } //End block
                                    found = true;
                                    newPrefList.append(key).append(':').append(newValue);
                                } //End block
                                {
                                    {
                                        first = false;
                                    } //End block
                                    {
                                        newPrefList.append(',');
                                    } //End block
                                    newPrefList.append(value);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    newPrefList.append(',');
                    newPrefList.append(key).append(':').append(newValue);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1127907196 = newPrefList.toString();
        addTaint(list.getTaint());
        addTaint(key.getTaint());
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1127907196.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1127907196;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class EngineInfoComparator implements Comparator<EngineInfo> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.077 -0400", hash_original_method = "81257836895CDB49D308B7B95E17876A", hash_generated_method = "046E030CC996B69833C1997F8A404D60")
        private  EngineInfoComparator() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.079 -0400", hash_original_method = "E919388D461770C5E68C050C2BB6D626", hash_generated_method = "14E9235AD94AF4D0E65608762D06DD77")
        @Override
        public int compare(EngineInfo lhs, EngineInfo rhs) {
            addTaint(lhs.getTaint());
            addTaint(rhs.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043316726 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043316726;
            // ---------- Original Method ----------
            //if (lhs.system && !rhs.system) {
                //return -1;
            //} else if (rhs.system && !lhs.system) {
                //return 1;
            //} else {
                //return rhs.priority - lhs.priority;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.079 -0400", hash_original_field = "22942468BDA180222A2983F0C420C983", hash_generated_field = "0CA244E03083D2D3306A1733CBDEDA51")

        static EngineInfoComparator INSTANCE = new EngineInfoComparator();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.079 -0400", hash_original_field = "83DB52A3C8D0B140F75136D958DB3D67", hash_generated_field = "7A1862742764B4648D563A7617011A7C")

    private static String TAG = "TtsEngines";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.079 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.079 -0400", hash_original_field = "861A0D790598FEE23451761E6E4C316A", hash_generated_field = "B965729B908854670B14941DD93392A6")

    private static String LOCALE_DELIMITER = "-";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.079 -0400", hash_original_field = "E761C2AF1B4C23BBB2D60DB5C2ADDF10", hash_generated_field = "5589CFFB76E299778DDAB0268CD87E9E")

    private static String XML_TAG_NAME = "tts-engine";
}

