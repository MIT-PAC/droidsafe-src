package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemProperties;
import android.util.Log;

public class PluginManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.400 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.400 -0400", hash_original_field = "25569E57E3655F1C6751374E0D20B917", hash_generated_field = "F51EF617CB965624F997697237656B33")

    private ArrayList<PackageInfo> mPackageInfoCache;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.400 -0400", hash_original_method = "0D07D19E48ED71562BE80BC3DA9E707F", hash_generated_method = "3E4B2E71D1B71C8750E5BBC7C1095F8E")
    private  PluginManager(Context context) {
        mContext = context;
        mPackageInfoCache = new ArrayList<PackageInfo>();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.401 -0400", hash_original_method = "2EF75139857ED5BD518FA65C3602E9EA", hash_generated_method = "05985CC9F408B07F1F8611EFFF46C4D9")
    public void refreshPlugins(boolean reloadOpenPages) {
        BrowserFrame.sJavaBridge.obtainMessage(
                JWebCoreJavaBridge.REFRESH_PLUGINS, reloadOpenPages)
                .sendToTarget();
        addTaint(reloadOpenPages);
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.436 -0400", hash_original_method = "7B4BF60DDCCCE0391FC04EA9A7E517B7", hash_generated_method = "9EF100C77C4F577FB20F400519CF7102")
     String[] getPluginDirectories() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1908964469 = null; 
        ArrayList<String> directories = new ArrayList<String>();
        PackageManager pm = mContext.getPackageManager();
        List<ResolveInfo> plugins = pm.queryIntentServices(new Intent(PLUGIN_ACTION),
                PackageManager.GET_SERVICES | PackageManager.GET_META_DATA);
        {
            mPackageInfoCache.clear();
            {
                Iterator<ResolveInfo> var8A2D23B813CDF90B9AB363F41DBCEF8F_2067923416 = (plugins).iterator();
                var8A2D23B813CDF90B9AB363F41DBCEF8F_2067923416.hasNext();
                ResolveInfo info = var8A2D23B813CDF90B9AB363F41DBCEF8F_2067923416.next();
                {
                    ServiceInfo serviceInfo = info.serviceInfo;
                    PackageInfo pkgInfo = null;
                    try 
                    {
                        pkgInfo = pm.getPackageInfo(serviceInfo.packageName,
                                    PackageManager.GET_PERMISSIONS
                                    | PackageManager.GET_SIGNATURES);
                    } 
                    catch (NameNotFoundException e)
                    { }
                    String directory = pkgInfo.applicationInfo.dataDir + "/lib";
                    final int appFlags = pkgInfo.applicationInfo.flags;
                    final int updatedSystemFlags = ApplicationInfo.FLAG_SYSTEM |
                                               ApplicationInfo.FLAG_UPDATED_SYSTEM_APP;
                    {
                        directory = PLUGIN_SYSTEM_LIB + pkgInfo.packageName;
                    } 
                    {
                        boolean varC34CED7255E4F66272956533B1F4DB84_1491832428 = (!containsPluginPermissionAndSignatures(pkgInfo));
                    } 
                    String pluginType = serviceInfo.metaData.getString(PLUGIN_TYPE);
                    {
                        boolean varD2DD2F3113E57D574CC1B16E8971FF6C_1279236253 = (!TYPE_NATIVE.equals(pluginType));
                    } 
                    try 
                    {
                        Class<?> cls = getPluginClass(serviceInfo.packageName, serviceInfo.name);
                        boolean classFound = true;
                    } 
                    catch (NameNotFoundException e)
                    { }
                    catch (ClassNotFoundException e)
                    { }
                    mPackageInfoCache.add(pkgInfo);
                    directories.add(directory);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1908964469 = directories.toArray(new String[directories.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1908964469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1908964469;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.436 -0400", hash_original_method = "A1FA8B166BFF0FCEB8723AD1FF203538", hash_generated_method = "CC3FE893E25EA4E3F1D2CA03162559C0")
     boolean containsPluginPermissionAndSignatures(String pluginAPKName) {
        PackageManager pm = mContext.getPackageManager();
        try 
        {
            PackageInfo pkgInfo = pm.getPackageInfo(pluginAPKName, PackageManager.GET_PERMISSIONS
                    | PackageManager.GET_SIGNATURES);
            {
                boolean varC0E81DB484948B5C94808B5E2CE78946_318250921 = (containsPluginPermissionAndSignatures(pkgInfo));
            } 
        } 
        catch (NameNotFoundException e)
        { }
        addTaint(pluginAPKName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709109618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709109618;
        
        
        
            
                    
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.441 -0400", hash_original_method = "E90FACC8787C376685A6D80F188924B0", hash_generated_method = "54CD78EB6232B7CD92D31E6899C88D64")
     String getPluginsAPKName(String pluginLib) {
        String varB4EAC82CA7396A68D541C85D26508E83_2090120568 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2075707415 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2129606041 = null; 
        {
            boolean var8BBC88CA95106D8C748EF2FA1AB0EED4_1277406173 = (pluginLib == null || pluginLib.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2090120568 = null;
            } 
        } 
        {
            {
                Iterator<PackageInfo> var54046F698D00E60D944A050A8C0248DB_479818324 = (mPackageInfoCache).iterator();
                var54046F698D00E60D944A050A8C0248DB_479818324.hasNext();
                PackageInfo pkgInfo = var54046F698D00E60D944A050A8C0248DB_479818324.next();
                {
                    {
                        boolean var5D8FC7ADB9C637A94C85FD123CC4E43E_1730140094 = (pluginLib.contains(pkgInfo.packageName));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_2075707415 = pkgInfo.packageName;
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2129606041 = null;
        addTaint(pluginLib.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1941899230; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1941899230 = varB4EAC82CA7396A68D541C85D26508E83_2090120568;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1941899230 = varB4EAC82CA7396A68D541C85D26508E83_2075707415;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1941899230 = varB4EAC82CA7396A68D541C85D26508E83_2129606041;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1941899230.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1941899230;
        
        
            
        
        
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.442 -0400", hash_original_method = "FC2E28857813BB5E17C54D889AE237C7", hash_generated_method = "7DA33D354CD16440B34291B0E85918DF")
     String getPluginSharedDataDirectory() {
        String varB4EAC82CA7396A68D541C85D26508E83_1138868506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1138868506 = mContext.getDir("plugins", 0).getPath();
        varB4EAC82CA7396A68D541C85D26508E83_1138868506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1138868506;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_method = "44FD7B6877FFF90B805F430598983AE5", hash_generated_method = "8B9B30C9414A3DFBB87041606D39AB4E")
     Class<?> getPluginClass(String packageName, String className) throws NameNotFoundException, ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1690603813 = null; 
        Context pluginContext = mContext.createPackageContext(packageName,
                Context.CONTEXT_INCLUDE_CODE |
                Context.CONTEXT_IGNORE_SECURITY);
        ClassLoader pluginCL = pluginContext.getClassLoader();
        varB4EAC82CA7396A68D541C85D26508E83_1690603813 = pluginCL.loadClass(className);
        addTaint(packageName.getTaint());
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1690603813.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1690603813;
        
        
                
                
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "46EC1704F1A4C88CB94F49A9A733A416", hash_generated_field = "6E15386A17519D626F4838D22857E2A2")

    @SdkConstant(SdkConstantType.SERVICE_ACTION)
    public static final String PLUGIN_ACTION = "android.webkit.PLUGIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "BFEB5800114B258FCC5B3BF9F3F66A10", hash_generated_field = "17F7A5EE2472141729A21AD58242A187")

    public static final String PLUGIN_PERMISSION = "android.webkit.permission.PLUGIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "C6EB288CD28414A9517919DACDDB140D", hash_generated_field = "31E92E593D20E890370A7DD8B012F438")

    private static final String LOGTAG = "PluginManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "459C8BE30B58EBB6A66BA2B0B44EA239", hash_generated_field = "0A0D72223090514A20C76888486C2FEE")

    private static final String PLUGIN_SYSTEM_LIB = "/system/lib/plugins/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "CD219D9A233EDF58175953823386B327", hash_generated_field = "2B8365BB4C16192D52C420A337ED7292")

    private static final String PLUGIN_TYPE = "type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "1A633ED7E957F732E927CEDBDFFB2601", hash_generated_field = "8E54E18A1F0B7AC7E443DA9A131C5B3E")

    private static final String TYPE_NATIVE = "native";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "BB5542AD4EE4FC87B3BF30A334DCA037", hash_generated_field = "8E17831FC52DAA414D0DF8F93D5347D9")

    private static PluginManager mInstance = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.444 -0400", hash_original_field = "C3A200BC2D6EB0C6298D26CDA24D0EF6", hash_generated_field = "4017DA39CF87F3CCBA44EB77709FBAA6")

    private static final String SIGNATURE_1 = "308204c5308203ada003020102020900d7cb412f75f4887e300d06092a864886f70d010105050030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564301e170d3039313030313030323331345a170d3337303231363030323331345a30819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f726174656430820120300d06092a864886f70d01010105000382010d0030820108028201010099724f3e05bbd78843794f357776e04b340e13cb1c9ccb3044865180d7d8fec8166c5bbd876da8b80aa71eb6ba3d4d3455c9a8de162d24a25c4c1cd04c9523affd06a279fc8f0d018f242486bdbb2dbfbf6fcb21ed567879091928b876f7ccebc7bccef157366ebe74e33ae1d7e9373091adab8327482154afc0693a549522f8c796dd84d16e24bb221f5dbb809ca56dd2b6e799c5fa06b6d9c5c09ada54ea4c5db1523a9794ed22a3889e5e05b29f8ee0a8d61efe07ae28f65dece2ff7edc5b1416d7c7aad7f0d35e8f4a4b964dbf50ae9aa6d620157770d974131b3e7e3abd6d163d65758e2f0822db9c88598b9db6263d963d13942c91fc5efe34fc1e06e3020103a382010630820102301d0603551d0e041604145af418e419a639e1657db960996364a37ef20d403081d20603551d230481ca3081c780145af418e419a639e1657db960996364a37ef20d40a181a3a481a030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564820900d7cb412f75f4887e300c0603551d13040530030101ff300d06092a864886f70d0101050500038201010076c2a11fe303359689c2ebc7b2c398eff8c3f9ad545cdbac75df63bf7b5395b6988d1842d6aa1556d595b5692e08224d667a4c9c438f05e74906c53dd8016dde7004068866f01846365efd146e9bfaa48c9ecf657f87b97c757da11f225c4a24177bf2d7188e6cce2a70a1e8a841a14471eb51457398b8a0addd8b6c8c1538ca8f1e40b4d8b960009ea22c188d28924813d2c0b4a4d334b7cf05507e1fcf0a06fe946c7ffc435e173af6fc3e3400643710acc806f830a14788291d46f2feed9fb5c70423ca747ed1572d752894ac1f19f93989766308579393fabb43649aa8806a313b1ab9a50922a44c2467b9062037f2da0d484d9ffd8fe628eeea629ba637";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.445 -0400", hash_original_field = "7096CD658F853E588FD298B5DF9CD48F", hash_generated_field = "DF4BF47628B1E5D523B71D6861D9C5BA")

    private static final Signature[] SIGNATURES = new Signature[] {
        new Signature(SIGNATURE_1)
    };
}

