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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.975 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.987 -0400", hash_original_method = "E276758190DBE13181DF9330ABF915FA", hash_generated_method = "BBA0A4812D4E67B5F55600D1B9BB6415")
    public  TtsEngines(Context ctx) {
        mContext = ctx;
        // ---------- Original Method ----------
        //mContext = ctx;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.987 -0400", hash_original_method = "F86D04A99B76CBDE409709AB3B031B49", hash_generated_method = "4C97BC354ECAF9DB136A32B8ABFF4E42")
    public String getDefaultEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1684510666 = null; //Variable for return #1
        String engine;
        engine = getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_SYNTH);
        varB4EAC82CA7396A68D541C85D26508E83_1684510666 = isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
        varB4EAC82CA7396A68D541C85D26508E83_1684510666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1684510666;
        // ---------- Original Method ----------
        //String engine = getString(mContext.getContentResolver(),
                //Settings.Secure.TTS_DEFAULT_SYNTH);
        //return isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.988 -0400", hash_original_method = "19A7DAF08EA8F2C03F3D1884DA46504A", hash_generated_method = "32CB0492379223D4293E57FD54301CEA")
    public String getHighestRankedEngineName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1159911283 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_723299969 = null; //Variable for return #2
        List<EngineInfo> engines;
        engines = getEngines();
        {
            boolean var1819F7731113A3DEF2529EB7CF4499F7_197757081 = (engines.size() > 0 && engines.get(0).system);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1159911283 = engines.get(0).name;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_723299969 = null;
        String varA7E53CE21691AB073D9660D615818899_842251788; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_842251788 = varB4EAC82CA7396A68D541C85D26508E83_1159911283;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_842251788 = varB4EAC82CA7396A68D541C85D26508E83_723299969;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_842251788.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_842251788;
        // ---------- Original Method ----------
        //final List<EngineInfo> engines = getEngines();
        //if (engines.size() > 0 && engines.get(0).system) {
            //return engines.get(0).name;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.989 -0400", hash_original_method = "A5DBD894AAA6A5E1130078152956054E", hash_generated_method = "A52540360D6056302F6F486EF2A0B7B4")
    public EngineInfo getEngineInfo(String packageName) {
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_137971039 = null; //Variable for return #1
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_2109348121 = null; //Variable for return #2
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(packageName);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_73391200 = (resolveInfos != null && resolveInfos.size() == 1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_137971039 = getEngineInfo(resolveInfos.get(0), pm);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2109348121 = null;
        addTaint(packageName.getTaint());
        EngineInfo varA7E53CE21691AB073D9660D615818899_1127838162; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1127838162 = varB4EAC82CA7396A68D541C85D26508E83_137971039;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1127838162 = varB4EAC82CA7396A68D541C85D26508E83_2109348121;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1127838162.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1127838162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.994 -0400", hash_original_method = "DACAAA1F42C7CE1B11C8FF369696D83F", hash_generated_method = "8B202EDE5961AA2D4DB269635392D726")
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_875395544 = null; //Variable for return #1
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_387111567 = null; //Variable for return #2
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent, PackageManager.MATCH_DEFAULT_ONLY);
        varB4EAC82CA7396A68D541C85D26508E83_875395544 = Collections.emptyList();
        List<EngineInfo> engines;
        engines = new ArrayList<EngineInfo>(resolveInfos.size());
        {
            Iterator<ResolveInfo> varA26DD4CAE8F7472DF523963F56C59876_1860743639 = (resolveInfos).iterator();
            varA26DD4CAE8F7472DF523963F56C59876_1860743639.hasNext();
            ResolveInfo resolveInfo = varA26DD4CAE8F7472DF523963F56C59876_1860743639.next();
            {
                EngineInfo engine;
                engine = getEngineInfo(resolveInfo, pm);
                {
                    engines.add(engine);
                } //End block
            } //End block
        } //End collapsed parenthetic
        Collections.sort(engines, EngineInfoComparator.INSTANCE);
        varB4EAC82CA7396A68D541C85D26508E83_387111567 = engines;
        List<EngineInfo> varA7E53CE21691AB073D9660D615818899_1983200616; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1983200616 = varB4EAC82CA7396A68D541C85D26508E83_875395544;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1983200616 = varB4EAC82CA7396A68D541C85D26508E83_387111567;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1983200616.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1983200616;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.994 -0400", hash_original_method = "096C3576F274D5610E35106CC045EF53", hash_generated_method = "1C54E78B1AD7FC12052A2816F312F22A")
    private boolean isSystemEngine(ServiceInfo info) {
        ApplicationInfo appInfo;
        appInfo = info.applicationInfo;
        addTaint(info.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1053319813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1053319813;
        // ---------- Original Method ----------
        //final ApplicationInfo appInfo = info.applicationInfo;
        //return appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.020 -0400", hash_original_method = "6576B103C8DDCA7E7096DC36C32D66CE", hash_generated_method = "1C49FA45686D955CAAFB0E71B5345F75")
    public boolean isEngineInstalled(String engine) {
        boolean varD11D9232D99EE58E44DC1B185B61381D_675278440 = (getEngineInfo(engine) != null);
        addTaint(engine.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_846102502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_846102502;
        // ---------- Original Method ----------
        //if (engine == null) {
            //return false;
        //}
        //return getEngineInfo(engine) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.021 -0400", hash_original_method = "081B98AA3A6A550A7C51DCB59AD3D4CC", hash_generated_method = "5EB5F0FCFAA635FCA29BBA135BACDB00")
    public Intent getSettingsIntent(String engine) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_619239144 = null; //Variable for return #1
        Intent varB4EAC82CA7396A68D541C85D26508E83_126098291 = null; //Variable for return #2
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_META_DATA);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_633871177 = (resolveInfos != null && resolveInfos.size() == 1);
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
                        varB4EAC82CA7396A68D541C85D26508E83_619239144 = i;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_126098291 = null;
        addTaint(engine.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_849780105; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_849780105 = varB4EAC82CA7396A68D541C85D26508E83_619239144;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_849780105 = varB4EAC82CA7396A68D541C85D26508E83_126098291;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_849780105.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_849780105;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.039 -0400", hash_original_method = "9D4652ECD9FA23521B324D3DE279FEF6", hash_generated_method = "1B4BB7522CC26C4A2F6DB809DF68853D")
    private String settingsActivityFromServiceInfo(ServiceInfo si, PackageManager pm) {
        String varB4EAC82CA7396A68D541C85D26508E83_936244219 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1021830410 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1532758148 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_738226027 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1102241141 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_1611372228 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_648678421 = null; //Variable for return #7
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, TextToSpeech.Engine.SERVICE_META_DATA);
            {
                varB4EAC82CA7396A68D541C85D26508E83_936244219 = null;
            } //End block
            Resources res;
            res = pm.getResourcesForApplication(si.applicationInfo);
            int type;
            {
                boolean var670879A2F0FFF8F0B25FD974769B483B_2022855485 = ((type = parser.next()) != XmlResourceParser.END_DOCUMENT);
                {
                    {
                        {
                            boolean varFA11C2F42D95D261E4941ADF07065428_1734522605 = (!XML_TAG_NAME.equals(parser.getName()));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1021830410 = null;
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
                        varB4EAC82CA7396A68D541C85D26508E83_1532758148 = settings;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_738226027 = null;
        } //End block
        catch (NameNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1102241141 = null;
        } //End block
        catch (XmlPullParserException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1611372228 = null;
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_648678421 = null;
        } //End block
        finally 
        {
            {
                parser.close();
            } //End block
        } //End block
        addTaint(si.getTaint());
        addTaint(pm.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2127331688; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2127331688 = varB4EAC82CA7396A68D541C85D26508E83_936244219;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2127331688 = varB4EAC82CA7396A68D541C85D26508E83_1021830410;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2127331688 = varB4EAC82CA7396A68D541C85D26508E83_1532758148;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2127331688 = varB4EAC82CA7396A68D541C85D26508E83_738226027;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2127331688 = varB4EAC82CA7396A68D541C85D26508E83_1102241141;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_2127331688 = varB4EAC82CA7396A68D541C85D26508E83_1611372228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2127331688 = varB4EAC82CA7396A68D541C85D26508E83_648678421;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2127331688.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2127331688;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.040 -0400", hash_original_method = "AAFB3DF5C9862013F914C97CA1EC4890", hash_generated_method = "81C3DF5D8A4A1BCCCDFD6AAB3AA5D46F")
    private EngineInfo getEngineInfo(ResolveInfo resolve, PackageManager pm) {
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_565401147 = null; //Variable for return #1
        EngineInfo varB4EAC82CA7396A68D541C85D26508E83_1320322603 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_565401147 = engine;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1320322603 = null;
        addTaint(resolve.getTaint());
        addTaint(pm.getTaint());
        EngineInfo varA7E53CE21691AB073D9660D615818899_681735249; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_681735249 = varB4EAC82CA7396A68D541C85D26508E83_565401147;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_681735249 = varB4EAC82CA7396A68D541C85D26508E83_1320322603;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_681735249.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_681735249;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.053 -0400", hash_original_method = "18ECF8DE6689127C36214444D644F0A3", hash_generated_method = "94B7DCF06487E1AE066E178F695619FA")
    public String getLocalePrefForEngine(String engineName) {
        String varB4EAC82CA7396A68D541C85D26508E83_502862167 = null; //Variable for return #1
        String locale;
        locale = parseEnginePrefFromList(
                getString(mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE),
                engineName);
        {
            boolean var687197B3D19FCF75669D4532E67850C1_1736345552 = (TextUtils.isEmpty(locale));
            {
                locale = getV1Locale();
            } //End block
        } //End collapsed parenthetic
        Log.d(TAG, "getLocalePrefForEngine(" + engineName + ")= " + locale);
        varB4EAC82CA7396A68D541C85D26508E83_502862167 = locale;
        addTaint(engineName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_502862167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_502862167;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.076 -0400", hash_original_method = "610702C4AF37E3C5EE6AAD794DF1E7DF", hash_generated_method = "C01106B0974563F9278593B6139A4CB3")
    private String getV1Locale() {
        String varB4EAC82CA7396A68D541C85D26508E83_797520991 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_336625171 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1371837613 = null; //Variable for return #3
        ContentResolver cr;
        cr = mContext.getContentResolver();
        String lang;
        lang = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_LANG);
        String country;
        country = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_COUNTRY);
        String variant;
        variant = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_VARIANT);
        {
            boolean var1A8AF987D7090BF21E59CC020666928D_56768303 = (TextUtils.isEmpty(lang));
            {
                varB4EAC82CA7396A68D541C85D26508E83_797520991 = getDefaultLocale();
            } //End block
        } //End collapsed parenthetic
        String v1Locale;
        v1Locale = lang;
        {
            boolean var1131EEE25553582BB000C21570B7E530_607288130 = (!TextUtils.isEmpty(country));
            {
                v1Locale += LOCALE_DELIMITER + country;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_336625171 = v1Locale;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2AE2FA07CFAC0698DFBA08380E8EE573_1967511558 = (!TextUtils.isEmpty(variant));
            {
                v1Locale += LOCALE_DELIMITER + variant;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1371837613 = v1Locale;
        String varA7E53CE21691AB073D9660D615818899_1378879132; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1378879132 = varB4EAC82CA7396A68D541C85D26508E83_797520991;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1378879132 = varB4EAC82CA7396A68D541C85D26508E83_336625171;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1378879132 = varB4EAC82CA7396A68D541C85D26508E83_1371837613;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1378879132.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1378879132;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.084 -0400", hash_original_method = "DCEE8BF4C9B6F52F0B0F667E0393B18E", hash_generated_method = "C30F69297A3A736402A4A291B9054B40")
    private String getDefaultLocale() {
        String varB4EAC82CA7396A68D541C85D26508E83_909742723 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1746503410 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_442774543 = null; //Variable for return #3
        Locale locale;
        locale = Locale.getDefault();
        String defaultLocale;
        defaultLocale = locale.getISO3Language();
        {
            boolean varB133EB656C0D5A870AC3D0136962B7D0_1640637902 = (TextUtils.isEmpty(defaultLocale));
            {
                varB4EAC82CA7396A68D541C85D26508E83_909742723 = "";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1D637D5D98C12045DF81F123BBBAD5ED_593001348 = (!TextUtils.isEmpty(locale.getISO3Country()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getISO3Country();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1746503410 = defaultLocale;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3A36AF7705C26D85B1613F262B79562C_122309675 = (!TextUtils.isEmpty(locale.getVariant()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getVariant();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_442774543 = defaultLocale;
        String varA7E53CE21691AB073D9660D615818899_1452935614; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1452935614 = varB4EAC82CA7396A68D541C85D26508E83_909742723;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1452935614 = varB4EAC82CA7396A68D541C85D26508E83_1746503410;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1452935614 = varB4EAC82CA7396A68D541C85D26508E83_442774543;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1452935614.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1452935614;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.088 -0400", hash_original_method = "9D847C860A473B48E829C1EE33625F6B", hash_generated_method = "8BB13425D875E68276D7A9F92D6880B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.221 -0400", hash_original_method = "00BF6BD14B34E2134A0C0EF2661B3919", hash_generated_method = "B3465C14A1B8DA0210D2E760B7EF7DC3")
    private String updateValueInCommaSeparatedList(String list, String key,
            String newValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_551477658 = null; //Variable for return #1
        StringBuilder newPrefList;
        newPrefList = new StringBuilder();
        {
            boolean varE09F2D7ADA4E79BF05A28AAF80E5C108_1108786309 = (TextUtils.isEmpty(list));
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
                    Iterator<String> varDE27625373240C1D73D7A1DA8ACFF196_1602869443 = (prefValues).iterator();
                    varDE27625373240C1D73D7A1DA8ACFF196_1602869443.hasNext();
                    String value = varDE27625373240C1D73D7A1DA8ACFF196_1602869443.next();
                    {
                        int delimiter;
                        delimiter = value.indexOf(':');
                        {
                            {
                                boolean var83DE1D06394DC0CDFCF59CED90A2B2B3_1028199941 = (key.equals(value.substring(0, delimiter)));
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
        varB4EAC82CA7396A68D541C85D26508E83_551477658 = newPrefList.toString();
        addTaint(list.getTaint());
        addTaint(key.getTaint());
        addTaint(newValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_551477658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_551477658;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class EngineInfoComparator implements Comparator<EngineInfo> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.222 -0400", hash_original_method = "81257836895CDB49D308B7B95E17876A", hash_generated_method = "046E030CC996B69833C1997F8A404D60")
        private  EngineInfoComparator() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.223 -0400", hash_original_method = "E919388D461770C5E68C050C2BB6D626", hash_generated_method = "6A127E750298FE6EFFCD7A1F51E120E1")
        @Override
        public int compare(EngineInfo lhs, EngineInfo rhs) {
            addTaint(lhs.getTaint());
            addTaint(rhs.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416281039 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416281039;
            // ---------- Original Method ----------
            //if (lhs.system && !rhs.system) {
                //return -1;
            //} else if (rhs.system && !lhs.system) {
                //return 1;
            //} else {
                //return rhs.priority - lhs.priority;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.223 -0400", hash_original_field = "22942468BDA180222A2983F0C420C983", hash_generated_field = "0CA244E03083D2D3306A1733CBDEDA51")

        static EngineInfoComparator INSTANCE = new EngineInfoComparator();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.223 -0400", hash_original_field = "83DB52A3C8D0B140F75136D958DB3D67", hash_generated_field = "7A1862742764B4648D563A7617011A7C")

    private static String TAG = "TtsEngines";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.223 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.223 -0400", hash_original_field = "861A0D790598FEE23451761E6E4C316A", hash_generated_field = "B965729B908854670B14941DD93392A6")

    private static String LOCALE_DELIMITER = "-";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.223 -0400", hash_original_field = "E761C2AF1B4C23BBB2D60DB5C2ADDF10", hash_generated_field = "5589CFFB76E299778DDAB0268CD87E9E")

    private static String XML_TAG_NAME = "tts-engine";
}

