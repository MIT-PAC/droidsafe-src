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
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.319 -0400", hash_original_method = "E276758190DBE13181DF9330ABF915FA", hash_generated_method = "6145D7FE46C386D8D28B6AEC9E359BF6")
    @DSModeled(DSC.SAFE)
    public TtsEngines(Context ctx) {
        dsTaint.addTaint(ctx.dsTaint);
        // ---------- Original Method ----------
        //mContext = ctx;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.320 -0400", hash_original_method = "F86D04A99B76CBDE409709AB3B031B49", hash_generated_method = "EC3D66EF55B3F2C98D69C595E986C2BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDefaultEngine() {
        String engine;
        engine = getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_SYNTH);
        {
            boolean var9538A4676FEC13A175D516BF2251DC39_262403305 = (isEngineInstalled(engine));
            Object varB4227454D5741B9F2B453FDC09A05EF3_873033139 = (getHighestRankedEngineName());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String engine = getString(mContext.getContentResolver(),
                //Settings.Secure.TTS_DEFAULT_SYNTH);
        //return isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.320 -0400", hash_original_method = "19A7DAF08EA8F2C03F3D1884DA46504A", hash_generated_method = "C6E75C193725DC8E6FD9B20FF1778EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHighestRankedEngineName() {
        List<EngineInfo> engines;
        engines = getEngines();
        {
            boolean var1819F7731113A3DEF2529EB7CF4499F7_2074847515 = (engines.size() > 0 && engines.get(0).system);
            {
                String var0BFF37135A710890C76674D003A29F87_935754801 = (engines.get(0).name);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final List<EngineInfo> engines = getEngines();
        //if (engines.size() > 0 && engines.get(0).system) {
            //return engines.get(0).name;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.320 -0400", hash_original_method = "A5DBD894AAA6A5E1130078152956054E", hash_generated_method = "98F7E18D7B3B4A2EAD07C933FC5F13AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EngineInfo getEngineInfo(String packageName) {
        dsTaint.addTaint(packageName);
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(packageName);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_1602204032 = (resolveInfos != null && resolveInfos.size() == 1);
            {
                EngineInfo var7068D374A62755451A0F33DD2E9E8328_1792844380 = (getEngineInfo(resolveInfos.get(0), pm));
            } //End block
        } //End collapsed parenthetic
        return (EngineInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.322 -0400", hash_original_method = "DACAAA1F42C7CE1B11C8FF369696D83F", hash_generated_method = "E20F65E58A8B3F3B9F61D58950EC5B09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<EngineInfo> getEngines() {
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent, PackageManager.MATCH_DEFAULT_ONLY);
        List<EngineInfo> varDA6BCEB8474C9FFEA13E4E44889D7138_1768719839 = (Collections.emptyList());
        List<EngineInfo> engines;
        engines = new ArrayList<EngineInfo>(resolveInfos.size());
        {
            Iterator<ResolveInfo> varA26DD4CAE8F7472DF523963F56C59876_958748114 = (resolveInfos).iterator();
            varA26DD4CAE8F7472DF523963F56C59876_958748114.hasNext();
            ResolveInfo resolveInfo = varA26DD4CAE8F7472DF523963F56C59876_958748114.next();
            {
                EngineInfo engine;
                engine = getEngineInfo(resolveInfo, pm);
                {
                    engines.add(engine);
                } //End block
            } //End block
        } //End collapsed parenthetic
        Collections.sort(engines, EngineInfoComparator.INSTANCE);
        return (List<EngineInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.328 -0400", hash_original_method = "096C3576F274D5610E35106CC045EF53", hash_generated_method = "AD86ABFB60EA54C44E6B5A55FC767278")
    @DSModeled(DSC.SAFE)
    private boolean isSystemEngine(ServiceInfo info) {
        dsTaint.addTaint(info.dsTaint);
        ApplicationInfo appInfo;
        appInfo = info.applicationInfo;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final ApplicationInfo appInfo = info.applicationInfo;
        //return appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.328 -0400", hash_original_method = "6576B103C8DDCA7E7096DC36C32D66CE", hash_generated_method = "4285169CE96375405275A81B09CE72D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEngineInstalled(String engine) {
        dsTaint.addTaint(engine);
        boolean varD11D9232D99EE58E44DC1B185B61381D_307425076 = (getEngineInfo(engine) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (engine == null) {
            //return false;
        //}
        //return getEngineInfo(engine) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.329 -0400", hash_original_method = "081B98AA3A6A550A7C51DCB59AD3D4CC", hash_generated_method = "C10DD44C0422410024080C659F979DB3")
    @DSModeled(DSC.SPEC)
    public Intent getSettingsIntent(String engine) {
        dsTaint.addTaint(engine);
        PackageManager pm;
        pm = mContext.getPackageManager();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        List<ResolveInfo> resolveInfos;
        resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_META_DATA);
        {
            boolean var9DD3933FB7A2F34140789DF644619074_800786360 = (resolveInfos != null && resolveInfos.size() == 1);
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
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Intent)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.331 -0400", hash_original_method = "9D4652ECD9FA23521B324D3DE279FEF6", hash_generated_method = "BDA3A8A3EA9E45F7CFD66875F7D396D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String settingsActivityFromServiceInfo(ServiceInfo si, PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        dsTaint.addTaint(si.dsTaint);
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, TextToSpeech.Engine.SERVICE_META_DATA);
            Resources res;
            res = pm.getResourcesForApplication(si.applicationInfo);
            int type;
            {
                boolean var670879A2F0FFF8F0B25FD974769B483B_1961887742 = ((type = parser.next()) != XmlResourceParser.END_DOCUMENT);
                {
                    {
                        {
                            boolean varFA11C2F42D95D261E4941ADF07065428_2052645222 = (!XML_TAG_NAME.equals(parser.getName()));
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
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (NameNotFoundException e)
        { }
        catch (XmlPullParserException e)
        { }
        catch (IOException e)
        { }
        finally 
        {
            {
                parser.close();
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.332 -0400", hash_original_method = "AAFB3DF5C9862013F914C97CA1EC4890", hash_generated_method = "AEBDEA321C0CC35EF05FE5E2BF99E534")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private EngineInfo getEngineInfo(ResolveInfo resolve, PackageManager pm) {
        dsTaint.addTaint(resolve.dsTaint);
        dsTaint.addTaint(pm.dsTaint);
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
        } //End block
        return (EngineInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.333 -0400", hash_original_method = "18ECF8DE6689127C36214444D644F0A3", hash_generated_method = "D2FFD2742BD624459C534347387D1A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLocalePrefForEngine(String engineName) {
        dsTaint.addTaint(engineName);
        String locale;
        locale = parseEnginePrefFromList(
                getString(mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE),
                engineName);
        {
            boolean var687197B3D19FCF75669D4532E67850C1_1162255627 = (TextUtils.isEmpty(locale));
            {
                locale = getV1Locale();
            } //End block
        } //End collapsed parenthetic
        Log.d(TAG, "getLocalePrefForEngine(" + engineName + ")= " + locale);
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.333 -0400", hash_original_method = "610702C4AF37E3C5EE6AAD794DF1E7DF", hash_generated_method = "1BDD673B33415D2CF8C4AF398B3313B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getV1Locale() {
        ContentResolver cr;
        cr = mContext.getContentResolver();
        String lang;
        lang = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_LANG);
        String country;
        country = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_COUNTRY);
        String variant;
        variant = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_VARIANT);
        {
            boolean var1A8AF987D7090BF21E59CC020666928D_1834464444 = (TextUtils.isEmpty(lang));
            {
                String varF326C9AFEE79273EE38F0CED07FC599A_160697460 = (getDefaultLocale());
            } //End block
        } //End collapsed parenthetic
        String v1Locale;
        v1Locale = lang;
        {
            boolean var1131EEE25553582BB000C21570B7E530_621257064 = (!TextUtils.isEmpty(country));
            {
                v1Locale += LOCALE_DELIMITER + country;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2AE2FA07CFAC0698DFBA08380E8EE573_1029211104 = (!TextUtils.isEmpty(variant));
            {
                v1Locale += LOCALE_DELIMITER + variant;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.334 -0400", hash_original_method = "DCEE8BF4C9B6F52F0B0F667E0393B18E", hash_generated_method = "C1CF6C00D8F2954AE153FD13D5C4F72E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getDefaultLocale() {
        Locale locale;
        locale = Locale.getDefault();
        String defaultLocale;
        defaultLocale = locale.getISO3Language();
        {
            boolean varB133EB656C0D5A870AC3D0136962B7D0_1313311101 = (TextUtils.isEmpty(defaultLocale));
        } //End collapsed parenthetic
        {
            boolean var1D637D5D98C12045DF81F123BBBAD5ED_3611121 = (!TextUtils.isEmpty(locale.getISO3Country()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getISO3Country();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3A36AF7705C26D85B1613F262B79562C_650801639 = (!TextUtils.isEmpty(locale.getVariant()));
            {
                defaultLocale += LOCALE_DELIMITER + locale.getVariant();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.334 -0400", hash_original_method = "9D847C860A473B48E829C1EE33625F6B", hash_generated_method = "24E268AFC94FF8CC36C6CCD74C39041F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void updateLocalePrefForEngine(String name, String newLocale) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(newLocale);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.343 -0400", hash_original_method = "00BF6BD14B34E2134A0C0EF2661B3919", hash_generated_method = "62D66AAD78C1ADC99B9017A2207FDB9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String updateValueInCommaSeparatedList(String list, String key,
            String newValue) {
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(list);
        dsTaint.addTaint(key);
        StringBuilder newPrefList;
        newPrefList = new StringBuilder();
        {
            boolean varE09F2D7ADA4E79BF05A28AAF80E5C108_58017044 = (TextUtils.isEmpty(list));
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
                                boolean var83DE1D06394DC0CDFCF59CED90A2B2B3_1221283139 = (key.equals(value.substring(0, delimiter)));
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
        String varD2DC0DB16698C2B55BC20AE8967E13BC_540164635 = (newPrefList.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class EngineInfoComparator implements Comparator<EngineInfo> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.344 -0400", hash_original_method = "81257836895CDB49D308B7B95E17876A", hash_generated_method = "046E030CC996B69833C1997F8A404D60")
        @DSModeled(DSC.SAFE)
        private EngineInfoComparator() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.344 -0400", hash_original_method = "E919388D461770C5E68C050C2BB6D626", hash_generated_method = "337AD3AAB8969282F26BB1F5F2BD7D31")
        @DSModeled(DSC.SAFE)
        @Override
        public int compare(EngineInfo lhs, EngineInfo rhs) {
            dsTaint.addTaint(rhs.dsTaint);
            dsTaint.addTaint(lhs.dsTaint);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (lhs.system && !rhs.system) {
                //return -1;
            //} else if (rhs.system && !lhs.system) {
                //return 1;
            //} else {
                //return rhs.priority - lhs.priority;
            //}
        }

        
        static EngineInfoComparator INSTANCE = new EngineInfoComparator();
    }


    
    private static final String TAG = "TtsEngines";
    private static final boolean DBG = false;
    private static final String LOCALE_DELIMITER = "-";
    private static final String XML_TAG_NAME = "tts-engine";
}

