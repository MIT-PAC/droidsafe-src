package android.webkit;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.SystemProperties;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PluginManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.816 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.816 -0400", hash_original_field = "25569E57E3655F1C6751374E0D20B917", hash_generated_field = "F51EF617CB965624F997697237656B33")

    private ArrayList<PackageInfo> mPackageInfoCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.817 -0400", hash_original_method = "0D07D19E48ED71562BE80BC3DA9E707F", hash_generated_method = "3E4B2E71D1B71C8750E5BBC7C1095F8E")
    private  PluginManager(Context context) {
        mContext = context;
        mPackageInfoCache = new ArrayList<PackageInfo>();
        // ---------- Original Method ----------
        //mContext = context;
        //mPackageInfoCache = new ArrayList<PackageInfo>();
    }

    
    public static synchronized PluginManager getInstance(Context context) {
        if (mInstance == null) {
            if (context == null) {
                throw new IllegalStateException(
                        "First call to PluginManager need a valid context.");
            }
            mInstance = new PluginManager(context.getApplicationContext());
        }
        return mInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.817 -0400", hash_original_method = "2EF75139857ED5BD518FA65C3602E9EA", hash_generated_method = "6A9D0DAF7E8200A02EE9C07AD9F3CE65")
    public void refreshPlugins(boolean reloadOpenPages) {
        addTaint(reloadOpenPages);
        BrowserFrame.sJavaBridge.obtainMessage(
                JWebCoreJavaBridge.REFRESH_PLUGINS, reloadOpenPages)
                .sendToTarget();
        // ---------- Original Method ----------
        //BrowserFrame.sJavaBridge.obtainMessage(
                //JWebCoreJavaBridge.REFRESH_PLUGINS, reloadOpenPages)
                //.sendToTarget();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.818 -0400", hash_original_method = "7B4BF60DDCCCE0391FC04EA9A7E517B7", hash_generated_method = "D273A9D3DA52E7A51128EB9F06D2ABD9")
     String[] getPluginDirectories() {
        ArrayList<String> directories = new ArrayList<String>();
        PackageManager pm = mContext.getPackageManager();
        List<ResolveInfo> plugins = pm.queryIntentServices(new Intent(PLUGIN_ACTION),
                PackageManager.GET_SERVICES | PackageManager.GET_META_DATA);
        synchronized
(mPackageInfoCache)        {
            mPackageInfoCache.clear();
for(ResolveInfo info : plugins)
            {
                ServiceInfo serviceInfo = info.serviceInfo;
                if(serviceInfo == null)                
                {
                    continue;
                } //End block
                PackageInfo pkgInfo;
                try 
                {
                    pkgInfo = pm.getPackageInfo(serviceInfo.packageName,
                                    PackageManager.GET_PERMISSIONS
                                    | PackageManager.GET_SIGNATURES);
                } //End block
                catch (NameNotFoundException e)
                {
                    continue;
                } //End block
                if(pkgInfo == null)                
                {
                    continue;
                } //End block
                String directory = pkgInfo.applicationInfo.dataDir + "/lib";
                final int appFlags = pkgInfo.applicationInfo.flags;
                final int updatedSystemFlags = ApplicationInfo.FLAG_SYSTEM |
                                               ApplicationInfo.FLAG_UPDATED_SYSTEM_APP;
                if((appFlags & updatedSystemFlags) == ApplicationInfo.FLAG_SYSTEM)                
                {
                    directory = PLUGIN_SYSTEM_LIB + pkgInfo.packageName;
                } //End block
                if(!containsPluginPermissionAndSignatures(pkgInfo))                
                {
                    continue;
                } //End block
                if(serviceInfo.metaData == null)                
                {
                    continue;
                } //End block
                String pluginType = serviceInfo.metaData.getString(PLUGIN_TYPE);
                if(!TYPE_NATIVE.equals(pluginType))                
                {
                    continue;
                } //End block
                try 
                {
                    Class<?> cls = getPluginClass(serviceInfo.packageName, serviceInfo.name);
                    boolean classFound = true;
                    if(!classFound)                    
                    {
                        continue;
                    } //End block
                } //End block
                catch (NameNotFoundException e)
                {
                    continue;
                } //End block
                catch (ClassNotFoundException e)
                {
                    continue;
                } //End block
                mPackageInfoCache.add(pkgInfo);
                directories.add(directory);
            } //End block
        } //End block
String[] varE0C2C4B802B12586A2E4ACEA1B32FB7F_818616627 =         directories.toArray(new String[directories.size()]);
        varE0C2C4B802B12586A2E4ACEA1B32FB7F_818616627.addTaint(taint);
        return varE0C2C4B802B12586A2E4ACEA1B32FB7F_818616627;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.819 -0400", hash_original_method = "A1FA8B166BFF0FCEB8723AD1FF203538", hash_generated_method = "2FB092884E517E3C0967BE2C3459FF16")
     boolean containsPluginPermissionAndSignatures(String pluginAPKName) {
        addTaint(pluginAPKName.getTaint());
        PackageManager pm = mContext.getPackageManager();
        try 
        {
            PackageInfo pkgInfo = pm.getPackageInfo(pluginAPKName, PackageManager.GET_PERMISSIONS
                    | PackageManager.GET_SIGNATURES);
            if(pkgInfo != null)            
            {
                boolean var7E9C4B361B32EAE359D1546AFEEC5371_1795933495 = (containsPluginPermissionAndSignatures(pkgInfo));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315656272 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_315656272;
            } //End block
        } //End block
        catch (NameNotFoundException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_759796371 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874884976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_874884976;
        // ---------- Original Method ----------
        //PackageManager pm = mContext.getPackageManager();
        //try {
            //PackageInfo pkgInfo = pm.getPackageInfo(pluginAPKName, PackageManager.GET_PERMISSIONS
                    //| PackageManager.GET_SIGNATURES);
            //if (pkgInfo != null) {
                //return containsPluginPermissionAndSignatures(pkgInfo);
            //}
        //} catch (NameNotFoundException e) {
            //Log.w(LOGTAG, "Can't find plugin: " + pluginAPKName);
        //}
        //return false;
    }

    
    private static boolean containsPluginPermissionAndSignatures(PackageInfo pkgInfo) {
        String permissions[] = pkgInfo.requestedPermissions;
        if (permissions == null) {
            return false;
        }
        boolean permissionOk = false;
        for (String permit : permissions) {
            if (PLUGIN_PERMISSION.equals(permit)) {
                permissionOk = true;
                break;
            }
        }
        if (!permissionOk) {
            return false;
        }
        Signature signatures[] = pkgInfo.signatures;
        if (signatures == null) {
            return false;
        }
        if (SystemProperties.getBoolean("ro.secure", false)) {
            boolean signatureMatch = false;
            for (Signature signature : signatures) {
                for (int i = 0; i < SIGNATURES.length; i++) {
                    if (SIGNATURES[i].equals(signature)) {
                        signatureMatch = true;
                        break;
                    }
                }
            }
            if (!signatureMatch) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_method = "E90FACC8787C376685A6D80F188924B0", hash_generated_method = "4DA9755C2940F4590E738E15752AD9D8")
     String getPluginsAPKName(String pluginLib) {
        addTaint(pluginLib.getTaint());
        if(pluginLib == null || pluginLib.length() == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_1276385347 =             null;
            var540C13E9E156B687226421B24F2DF178_1276385347.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1276385347;
        } //End block
        synchronized
(mPackageInfoCache)        {
for(PackageInfo pkgInfo : mPackageInfoCache)
            {
                if(pluginLib.contains(pkgInfo.packageName))                
                {
String var7514B34483602F51F303DF2FCD8A50B8_1431283042 =                     pkgInfo.packageName;
                    var7514B34483602F51F303DF2FCD8A50B8_1431283042.addTaint(taint);
                    return var7514B34483602F51F303DF2FCD8A50B8_1431283042;
                } //End block
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1065326639 =         null;
        var540C13E9E156B687226421B24F2DF178_1065326639.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1065326639;
        // ---------- Original Method ----------
        //if (pluginLib == null || pluginLib.length() == 0) {
            //return null;
        //}
        //synchronized(mPackageInfoCache) {
            //for (PackageInfo pkgInfo : mPackageInfoCache) {
                //if (pluginLib.contains(pkgInfo.packageName)) {
                    //return pkgInfo.packageName;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_method = "FC2E28857813BB5E17C54D889AE237C7", hash_generated_method = "363AFBA0379472AD99833CF0C0157FDB")
     String getPluginSharedDataDirectory() {
String var9DD7862E5AB9FDDCC7694533E6D60BB1_1057158247 =         mContext.getDir("plugins", 0).getPath();
        var9DD7862E5AB9FDDCC7694533E6D60BB1_1057158247.addTaint(taint);
        return var9DD7862E5AB9FDDCC7694533E6D60BB1_1057158247;
        // ---------- Original Method ----------
        //return mContext.getDir("plugins", 0).getPath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_method = "44FD7B6877FFF90B805F430598983AE5", hash_generated_method = "60022EB9EC070E9DE5D17FC3B8235BA8")
     Class<?> getPluginClass(String packageName, String className) throws NameNotFoundException, ClassNotFoundException {
        addTaint(className.getTaint());
        addTaint(packageName.getTaint());
        Context pluginContext = mContext.createPackageContext(packageName,
                Context.CONTEXT_INCLUDE_CODE |
                Context.CONTEXT_IGNORE_SECURITY);
        ClassLoader pluginCL = pluginContext.getClassLoader();
Class<?> var9D02688E720C112834603EB7198E6440_1235932007 =         pluginCL.loadClass(className);
        var9D02688E720C112834603EB7198E6440_1235932007.addTaint(taint);
        return var9D02688E720C112834603EB7198E6440_1235932007;
        // ---------- Original Method ----------
        //Context pluginContext = mContext.createPackageContext(packageName,
                //Context.CONTEXT_INCLUDE_CODE |
                //Context.CONTEXT_IGNORE_SECURITY);
        //ClassLoader pluginCL = pluginContext.getClassLoader();
        //return pluginCL.loadClass(className);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "46EC1704F1A4C88CB94F49A9A733A416", hash_generated_field = "6E15386A17519D626F4838D22857E2A2")

    @SdkConstant(SdkConstantType.SERVICE_ACTION)
    public static final String PLUGIN_ACTION = "android.webkit.PLUGIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "BFEB5800114B258FCC5B3BF9F3F66A10", hash_generated_field = "17F7A5EE2472141729A21AD58242A187")

    public static final String PLUGIN_PERMISSION = "android.webkit.permission.PLUGIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "C6EB288CD28414A9517919DACDDB140D", hash_generated_field = "31E92E593D20E890370A7DD8B012F438")

    private static final String LOGTAG = "PluginManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "459C8BE30B58EBB6A66BA2B0B44EA239", hash_generated_field = "0A0D72223090514A20C76888486C2FEE")

    private static final String PLUGIN_SYSTEM_LIB = "/system/lib/plugins/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "CD219D9A233EDF58175953823386B327", hash_generated_field = "2B8365BB4C16192D52C420A337ED7292")

    private static final String PLUGIN_TYPE = "type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "1A633ED7E957F732E927CEDBDFFB2601", hash_generated_field = "8E54E18A1F0B7AC7E443DA9A131C5B3E")

    private static final String TYPE_NATIVE = "native";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "BB5542AD4EE4FC87B3BF30A334DCA037", hash_generated_field = "8E17831FC52DAA414D0DF8F93D5347D9")

    private static PluginManager mInstance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "C3A200BC2D6EB0C6298D26CDA24D0EF6", hash_generated_field = "4017DA39CF87F3CCBA44EB77709FBAA6")

    private static final String SIGNATURE_1 = "308204c5308203ada003020102020900d7cb412f75f4887e300d06092a864886f70d010105050030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564301e170d3039313030313030323331345a170d3337303231363030323331345a30819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f726174656430820120300d06092a864886f70d01010105000382010d0030820108028201010099724f3e05bbd78843794f357776e04b340e13cb1c9ccb3044865180d7d8fec8166c5bbd876da8b80aa71eb6ba3d4d3455c9a8de162d24a25c4c1cd04c9523affd06a279fc8f0d018f242486bdbb2dbfbf6fcb21ed567879091928b876f7ccebc7bccef157366ebe74e33ae1d7e9373091adab8327482154afc0693a549522f8c796dd84d16e24bb221f5dbb809ca56dd2b6e799c5fa06b6d9c5c09ada54ea4c5db1523a9794ed22a3889e5e05b29f8ee0a8d61efe07ae28f65dece2ff7edc5b1416d7c7aad7f0d35e8f4a4b964dbf50ae9aa6d620157770d974131b3e7e3abd6d163d65758e2f0822db9c88598b9db6263d963d13942c91fc5efe34fc1e06e3020103a382010630820102301d0603551d0e041604145af418e419a639e1657db960996364a37ef20d403081d20603551d230481ca3081c780145af418e419a639e1657db960996364a37ef20d40a181a3a481a030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564820900d7cb412f75f4887e300c0603551d13040530030101ff300d06092a864886f70d0101050500038201010076c2a11fe303359689c2ebc7b2c398eff8c3f9ad545cdbac75df63bf7b5395b6988d1842d6aa1556d595b5692e08224d667a4c9c438f05e74906c53dd8016dde7004068866f01846365efd146e9bfaa48c9ecf657f87b97c757da11f225c4a24177bf2d7188e6cce2a70a1e8a841a14471eb51457398b8a0addd8b6c8c1538ca8f1e40b4d8b960009ea22c188d28924813d2c0b4a4d334b7cf05507e1fcf0a06fe946c7ffc435e173af6fc3e3400643710acc806f830a14788291d46f2feed9fb5c70423ca747ed1572d752894ac1f19f93989766308579393fabb43649aa8806a313b1ab9a50922a44c2467b9062037f2da0d484d9ffd8fe628eeea629ba637";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.835 -0400", hash_original_field = "7096CD658F853E588FD298B5DF9CD48F", hash_generated_field = "DF4BF47628B1E5D523B71D6861D9C5BA")

    private static final Signature[] SIGNATURES = new Signature[] {
        new Signature(SIGNATURE_1)
    };
}

