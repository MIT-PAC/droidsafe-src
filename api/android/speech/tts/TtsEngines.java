package android.speech.tts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.563 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.564 -0400", hash_original_method = "E276758190DBE13181DF9330ABF915FA", hash_generated_method = "BBA0A4812D4E67B5F55600D1B9BB6415")
    public  TtsEngines(Context ctx) {
        mContext = ctx;
        // ---------- Original Method ----------
        //mContext = ctx;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.564 -0400", hash_original_method = "F86D04A99B76CBDE409709AB3B031B49", hash_generated_method = "E72E4F31E2E8084BAFF633BBB67D9304")
    public String getDefaultEngine() {
        String engine = getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_SYNTH);
String var0A296E2CD1BFADF641B85E5629D6007B_1628031147 =         isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
        var0A296E2CD1BFADF641B85E5629D6007B_1628031147.addTaint(taint);
        return var0A296E2CD1BFADF641B85E5629D6007B_1628031147;
        // ---------- Original Method ----------
        //String engine = getString(mContext.getContentResolver(),
                //Settings.Secure.TTS_DEFAULT_SYNTH);
        //return isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.564 -0400", hash_original_method = "19A7DAF08EA8F2C03F3D1884DA46504A", hash_generated_method = "FA396E144FBC359FC49B7C45516DECAD")
    public String getHighestRankedEngineName() {
        final List<EngineInfo> engines = getEngines();
        if(engines.size() > 0 && engines.get(0).system)        
        {
String var6BED7FC5928ECA947B6B6E7BFD3C595E_1911056370 =             engines.get(0).name;
            var6BED7FC5928ECA947B6B6E7BFD3C595E_1911056370.addTaint(taint);
            return var6BED7FC5928ECA947B6B6E7BFD3C595E_1911056370;
        } //End block
String var540C13E9E156B687226421B24F2DF178_115147683 =         null;
        var540C13E9E156B687226421B24F2DF178_115147683.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_115147683;
        // ---------- Original Method ----------
        //final List<EngineInfo> engines = getEngines();
        //if (engines.size() > 0 && engines.get(0).system) {
            //return engines.get(0).name;
        //}
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.564 -0400", hash_original_method = "A5DBD894AAA6A5E1130078152956054E", hash_generated_method = "FD4CF41E4A985993A5375D8FE829C148")
    public EngineInfo getEngineInfo(String packageName) {
        addTaint(packageName.getTaint());
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(packageName);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        if(resolveInfos != null && resolveInfos.size() == 1)        
        {
EngineInfo varCF953B8715DCED119F1C21179F0D6411_1261438045 =             getEngineInfo(resolveInfos.get(0), pm);
            varCF953B8715DCED119F1C21179F0D6411_1261438045.addTaint(taint);
            return varCF953B8715DCED119F1C21179F0D6411_1261438045;
        } //End block
EngineInfo var540C13E9E156B687226421B24F2DF178_1897287183 =         null;
        var540C13E9E156B687226421B24F2DF178_1897287183.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1897287183;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.565 -0400", hash_original_method = "DACAAA1F42C7CE1B11C8FF369696D83F", hash_generated_method = "3C18AE41BCA16703B85D071BC9AD80E9")
    public List<EngineInfo> getEngines() {
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if(resolveInfos == null)        
        {
List<EngineInfo> varB803AB532741AA7D5C2F301CCDDD25F2_875390168 =         Collections.emptyList();
        varB803AB532741AA7D5C2F301CCDDD25F2_875390168.addTaint(taint);
        return varB803AB532741AA7D5C2F301CCDDD25F2_875390168;
        }
        List<EngineInfo> engines = new ArrayList<EngineInfo>(resolveInfos.size());
for(ResolveInfo resolveInfo : resolveInfos)
        {
            EngineInfo engine = getEngineInfo(resolveInfo, pm);
            if(engine != null)            
            {
                engines.add(engine);
            } //End block
        } //End block
        Collections.sort(engines, EngineInfoComparator.INSTANCE);
List<EngineInfo> varC8BA3C6249E186ACF366B0F1A542730C_932055549 =         engines;
        varC8BA3C6249E186ACF366B0F1A542730C_932055549.addTaint(taint);
        return varC8BA3C6249E186ACF366B0F1A542730C_932055549;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.566 -0400", hash_original_method = "096C3576F274D5610E35106CC045EF53", hash_generated_method = "61DCBF2B1F856491B45883E97761426E")
    private boolean isSystemEngine(ServiceInfo info) {
        addTaint(info.getTaint());
        final ApplicationInfo appInfo = info.applicationInfo;
        boolean var40FC38E529199932DF2F88801573178A_1504043805 = (appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131778124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131778124;
        // ---------- Original Method ----------
        //final ApplicationInfo appInfo = info.applicationInfo;
        //return appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.566 -0400", hash_original_method = "6576B103C8DDCA7E7096DC36C32D66CE", hash_generated_method = "826DFB91BF6B324B39CC4113F232EA83")
    public boolean isEngineInstalled(String engine) {
        addTaint(engine.getTaint());
        if(engine == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1154474472 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156440007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_156440007;
        } //End block
        boolean var9E9CB0DDFA4170D59AD6A3580199C1B7_1273953342 = (getEngineInfo(engine) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94814184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94814184;
        // ---------- Original Method ----------
        //if (engine == null) {
            //return false;
        //}
        //return getEngineInfo(engine) != null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.567 -0400", hash_original_method = "081B98AA3A6A550A7C51DCB59AD3D4CC", hash_generated_method = "7A418261EF482C5E7059B1D08771C775")
    public Intent getSettingsIntent(String engine) {
        addTaint(engine.getTaint());
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_META_DATA);
        if(resolveInfos != null && resolveInfos.size() == 1)        
        {
            ServiceInfo service = resolveInfos.get(0).serviceInfo;
            if(service != null)            
            {
                final String settings = settingsActivityFromServiceInfo(service, pm);
                if(settings != null)                
                {
                    Intent i = new Intent();
                    i.setClassName(engine, settings);
Intent varD9A5948E3E870E6097B7023E4497FFEC_719676576 =                     i;
                    varD9A5948E3E870E6097B7023E4497FFEC_719676576.addTaint(taint);
                    return varD9A5948E3E870E6097B7023E4497FFEC_719676576;
                } //End block
            } //End block
        } //End block
Intent var540C13E9E156B687226421B24F2DF178_1715593601 =         null;
        var540C13E9E156B687226421B24F2DF178_1715593601.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1715593601;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.568 -0400", hash_original_method = "9D4652ECD9FA23521B324D3DE279FEF6", hash_generated_method = "8BF19D80EB9F726377B4F9550556F947")
    private String settingsActivityFromServiceInfo(ServiceInfo si, PackageManager pm) {
        addTaint(pm.getTaint());
        addTaint(si.getTaint());
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, TextToSpeech.Engine.SERVICE_META_DATA);
            if(parser == null)            
            {
String var540C13E9E156B687226421B24F2DF178_269186892 =                 null;
                var540C13E9E156B687226421B24F2DF178_269186892.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_269186892;
            } //End block
            final Resources res = pm.getResourcesForApplication(si.applicationInfo);
            int type;
            while
((type = parser.next()) != XmlResourceParser.END_DOCUMENT)            
            {
                if(type == XmlResourceParser.START_TAG)                
                {
                    if(!XML_TAG_NAME.equals(parser.getName()))                    
                    {
String var540C13E9E156B687226421B24F2DF178_753340489 =                         null;
                        var540C13E9E156B687226421B24F2DF178_753340489.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_753340489;
                    } //End block
                    final AttributeSet attrs = Xml.asAttributeSet(parser);
                    final TypedArray array = res.obtainAttributes(attrs,
                            com.android.internal.R.styleable.TextToSpeechEngine);
                    final String settings = array.getString(
                            com.android.internal.R.styleable.TextToSpeechEngine_settingsActivity);
                    array.recycle();
String varBA20C571BEAC4C90EA83B5222777AF06_2071268693 =                     settings;
                    varBA20C571BEAC4C90EA83B5222777AF06_2071268693.addTaint(taint);
                    return varBA20C571BEAC4C90EA83B5222777AF06_2071268693;
                } //End block
            } //End block
String var540C13E9E156B687226421B24F2DF178_1172331402 =             null;
            var540C13E9E156B687226421B24F2DF178_1172331402.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1172331402;
        } //End block
        catch (NameNotFoundException e)
        {
String var540C13E9E156B687226421B24F2DF178_2088798964 =             null;
            var540C13E9E156B687226421B24F2DF178_2088798964.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2088798964;
        } //End block
        catch (XmlPullParserException e)
        {
String var540C13E9E156B687226421B24F2DF178_1688109692 =             null;
            var540C13E9E156B687226421B24F2DF178_1688109692.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1688109692;
        } //End block
        catch (IOException e)
        {
String var540C13E9E156B687226421B24F2DF178_423272102 =             null;
            var540C13E9E156B687226421B24F2DF178_423272102.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_423272102;
        } //End block
        finally 
        {
            if(parser != null)            
            {
                parser.close();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.571 -0400", hash_original_method = "AAFB3DF5C9862013F914C97CA1EC4890", hash_generated_method = "54D0CD4625012698EBB246482064272D")
    private EngineInfo getEngineInfo(ResolveInfo resolve, PackageManager pm) {
        addTaint(pm.getTaint());
        addTaint(resolve.getTaint());
        ServiceInfo service = resolve.serviceInfo;
        if(service != null)        
        {
            EngineInfo engine = new EngineInfo();
            engine.name = service.packageName;
            CharSequence label = service.loadLabel(pm);
            engine.label = TextUtils.isEmpty(label) ? engine.name : label.toString();
            engine.icon = service.getIconResource();
            engine.priority = resolve.priority;
            engine.system = isSystemEngine(service);
EngineInfo var7972BCEBDA271965A23F8B80E328E98F_55413613 =             engine;
            var7972BCEBDA271965A23F8B80E328E98F_55413613.addTaint(taint);
            return var7972BCEBDA271965A23F8B80E328E98F_55413613;
        } //End block
EngineInfo var540C13E9E156B687226421B24F2DF178_387619575 =         null;
        var540C13E9E156B687226421B24F2DF178_387619575.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_387619575;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.572 -0400", hash_original_method = "18ECF8DE6689127C36214444D644F0A3", hash_generated_method = "36286A3BFEA3700ABBD2E118A9472455")
    public String getLocalePrefForEngine(String engineName) {
        addTaint(engineName.getTaint());
        String locale = parseEnginePrefFromList(
                getString(mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE),
                engineName);
        if(TextUtils.isEmpty(locale))        
        {
            locale = getV1Locale();
        } //End block
        if(DBG)        
        Log.d(TAG, "getLocalePrefForEngine(" + engineName + ")= " + locale);
String varB14E682FEAD06D8198D8ADBCBD62DEDB_1654725841 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_1654725841.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_1654725841;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.573 -0400", hash_original_method = "610702C4AF37E3C5EE6AAD794DF1E7DF", hash_generated_method = "43E47F70E63142765CC14E08CE4B3C08")
    private String getV1Locale() {
        final ContentResolver cr = mContext.getContentResolver();
        final String lang = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_LANG);
        final String country = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_COUNTRY);
        final String variant = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_VARIANT);
        if(TextUtils.isEmpty(lang))        
        {
String varC0648F38AF10EBF37E0A6072F880E2D6_193072804 =             getDefaultLocale();
            varC0648F38AF10EBF37E0A6072F880E2D6_193072804.addTaint(taint);
            return varC0648F38AF10EBF37E0A6072F880E2D6_193072804;
        } //End block
        String v1Locale = lang;
        if(!TextUtils.isEmpty(country))        
        {
            v1Locale += LOCALE_DELIMITER + country;
        } //End block
        else
        {
String var1B839A74781C84B9D1829F7923B05281_1809961461 =             v1Locale;
            var1B839A74781C84B9D1829F7923B05281_1809961461.addTaint(taint);
            return var1B839A74781C84B9D1829F7923B05281_1809961461;
        } //End block
        if(!TextUtils.isEmpty(variant))        
        {
            v1Locale += LOCALE_DELIMITER + variant;
        } //End block
String var1B839A74781C84B9D1829F7923B05281_388512219 =         v1Locale;
        var1B839A74781C84B9D1829F7923B05281_388512219.addTaint(taint);
        return var1B839A74781C84B9D1829F7923B05281_388512219;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.574 -0400", hash_original_method = "DCEE8BF4C9B6F52F0B0F667E0393B18E", hash_generated_method = "A1ABFBEEB408CA1F35992053CC06F60F")
    private String getDefaultLocale() {
        final Locale locale = Locale.getDefault();
        String defaultLocale = locale.getISO3Language();
        if(TextUtils.isEmpty(defaultLocale))        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1768881916 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1768881916.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1768881916;
        } //End block
        if(!TextUtils.isEmpty(locale.getISO3Country()))        
        {
            defaultLocale += LOCALE_DELIMITER + locale.getISO3Country();
        } //End block
        else
        {
String var793E9FCB8AF595162999BC610B5A4C5E_933138814 =             defaultLocale;
            var793E9FCB8AF595162999BC610B5A4C5E_933138814.addTaint(taint);
            return var793E9FCB8AF595162999BC610B5A4C5E_933138814;
        } //End block
        if(!TextUtils.isEmpty(locale.getVariant()))        
        {
            defaultLocale += LOCALE_DELIMITER + locale.getVariant();
        } //End block
String var793E9FCB8AF595162999BC610B5A4C5E_1258183013 =         defaultLocale;
        var793E9FCB8AF595162999BC610B5A4C5E_1258183013.addTaint(taint);
        return var793E9FCB8AF595162999BC610B5A4C5E_1258183013;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.575 -0400", hash_original_method = "9D847C860A473B48E829C1EE33625F6B", hash_generated_method = "4F26426A637DE7AD0FB371639A9B17D1")
    public synchronized void updateLocalePrefForEngine(String name, String newLocale) {
        addTaint(newLocale.getTaint());
        addTaint(name.getTaint());
        final String prefList = Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_LOCALE);
        if(DBG)        
        {
            Log.d(TAG, "updateLocalePrefForEngine(" + name + ", " + newLocale +
                    "), originally: " + prefList);
        } //End block
        final String newPrefList = updateValueInCommaSeparatedList(prefList,
                name, newLocale);
        if(DBG)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.577 -0400", hash_original_method = "00BF6BD14B34E2134A0C0EF2661B3919", hash_generated_method = "5C07B5C79542BDEFD836934AA8B07A0C")
    private String updateValueInCommaSeparatedList(String list, String key,
            String newValue) {
        addTaint(newValue.getTaint());
        addTaint(key.getTaint());
        addTaint(list.getTaint());
        StringBuilder newPrefList = new StringBuilder();
        if(TextUtils.isEmpty(list))        
        {
            newPrefList.append(key).append(':').append(newValue);
        } //End block
        else
        {
            String[] prefValues = list.split(",");
            boolean first = true;
            boolean found = false;
for(String value : prefValues)
            {
                final int delimiter = value.indexOf(':');
                if(delimiter > 0)                
                {
                    if(key.equals(value.substring(0, delimiter)))                    
                    {
                        if(first)                        
                        {
                            first = false;
                        } //End block
                        else
                        {
                            newPrefList.append(',');
                        } //End block
                        found = true;
                        newPrefList.append(key).append(':').append(newValue);
                    } //End block
                    else
                    {
                        if(first)                        
                        {
                            first = false;
                        } //End block
                        else
                        {
                            newPrefList.append(',');
                        } //End block
                        newPrefList.append(value);
                    } //End block
                } //End block
            } //End block
            if(!found)            
            {
                newPrefList.append(',');
                newPrefList.append(key).append(':').append(newValue);
            } //End block
        } //End block
String varFE312D2AD51B57E6FBC9C13A73F3868E_1432695256 =         newPrefList.toString();
        varFE312D2AD51B57E6FBC9C13A73F3868E_1432695256.addTaint(taint);
        return varFE312D2AD51B57E6FBC9C13A73F3868E_1432695256;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class EngineInfoComparator implements Comparator<EngineInfo> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.578 -0400", hash_original_method = "81257836895CDB49D308B7B95E17876A", hash_generated_method = "046E030CC996B69833C1997F8A404D60")
        private  EngineInfoComparator() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.578 -0400", hash_original_method = "E919388D461770C5E68C050C2BB6D626", hash_generated_method = "56A0A59B416B71CF5AD0CA88B308F7EC")
        @Override
        public int compare(EngineInfo lhs, EngineInfo rhs) {
            addTaint(rhs.getTaint());
            addTaint(lhs.getTaint());
            if(lhs.system && !rhs.system)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1957280966 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540096657 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540096657;
            } //End block
            else
            if(rhs.system && !lhs.system)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_497090198 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997942933 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997942933;
            } //End block
            else
            {
                int varBD6B4C782F175CCC0307B330097D3836_1721486173 = (rhs.priority - lhs.priority);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608222042 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608222042;
            } //End block
            // ---------- Original Method ----------
            //if (lhs.system && !rhs.system) {
                //return -1;
            //} else if (rhs.system && !lhs.system) {
                //return 1;
            //} else {
                //return rhs.priority - lhs.priority;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.578 -0400", hash_original_field = "22942468BDA180222A2983F0C420C983", hash_generated_field = "0CA244E03083D2D3306A1733CBDEDA51")

        static EngineInfoComparator INSTANCE = new EngineInfoComparator();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.578 -0400", hash_original_field = "83DB52A3C8D0B140F75136D958DB3D67", hash_generated_field = "C4D788B9A30DB979B4B514CACCF1BB4B")

    private static final String TAG = "TtsEngines";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.578 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.578 -0400", hash_original_field = "861A0D790598FEE23451761E6E4C316A", hash_generated_field = "187C46D90E30A2E475FC964C28714A03")

    private static final String LOCALE_DELIMITER = "-";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.578 -0400", hash_original_field = "E761C2AF1B4C23BBB2D60DB5C2ADDF10", hash_generated_field = "FD63E60582DCF4480EDEA7A7945C3DEB")

    private static final String XML_TAG_NAME = "tts-engine";
}

