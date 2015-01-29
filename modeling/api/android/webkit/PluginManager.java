package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

public class PluginManager {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.805 -0500", hash_original_method = "78BC95C2D75C09A2754B8CD721EB7D79", hash_generated_method = "CB40E21303FAA5057204A063AB07A4BB")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.817 -0500", hash_original_method = "CE52C054A8C04EA6394487C6A1F756D1", hash_generated_method = "FD0C96C6B8F2A648D6E2E6CF90C90B2C")
    
private static boolean containsPluginPermissionAndSignatures(PackageInfo pkgInfo) {

        // check if the plugin has the required permissions
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

        // check to ensure the plugin is properly signed
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.776 -0500", hash_original_field = "F23951934BC5A0A8E6FE17CA047C0F64", hash_generated_field = "6E15386A17519D626F4838D22857E2A2")

    @SdkConstant(SdkConstantType.SERVICE_ACTION)
    public static final String PLUGIN_ACTION = "android.webkit.PLUGIN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.779 -0500", hash_original_field = "169AF0F764B554B2397DF97725C42926", hash_generated_field = "17F7A5EE2472141729A21AD58242A187")

    public static final String PLUGIN_PERMISSION = "android.webkit.permission.PLUGIN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.781 -0500", hash_original_field = "7013E7F52D54DC121308B83EE9714B58", hash_generated_field = "31E92E593D20E890370A7DD8B012F438")

    private static final String LOGTAG = "PluginManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.783 -0500", hash_original_field = "1B1B708122954C7815D6E30B01A59164", hash_generated_field = "0A0D72223090514A20C76888486C2FEE")

    private static final String PLUGIN_SYSTEM_LIB = "/system/lib/plugins/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.786 -0500", hash_original_field = "930957D9117E0C0645B99BA8D348EEEA", hash_generated_field = "2B8365BB4C16192D52C420A337ED7292")

    private static final String PLUGIN_TYPE = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.788 -0500", hash_original_field = "C5C03F4D59FCF76B822BB849F6DEC420", hash_generated_field = "8E54E18A1F0B7AC7E443DA9A131C5B3E")

    private static final String TYPE_NATIVE = "native";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.790 -0500", hash_original_field = "70980EF359A86D9BD4D5FFEFB84DF776", hash_generated_field = "8E17831FC52DAA414D0DF8F93D5347D9")

    private static PluginManager mInstance = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.798 -0500", hash_original_field = "BEA1E72EE400B3ABFBAC99AD8189EA90", hash_generated_field = "21B9DEE34E9377F024A7C7F5C94AFB83")

    // inside the WebView process
    private static final String SIGNATURE_1 = "308204c5308203ada003020102020900d7cb412f75f4887e300d06092a864886f70d010105050030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564301e170d3039313030313030323331345a170d3337303231363030323331345a30819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f726174656430820120300d06092a864886f70d01010105000382010d0030820108028201010099724f3e05bbd78843794f357776e04b340e13cb1c9ccb3044865180d7d8fec8166c5bbd876da8b80aa71eb6ba3d4d3455c9a8de162d24a25c4c1cd04c9523affd06a279fc8f0d018f242486bdbb2dbfbf6fcb21ed567879091928b876f7ccebc7bccef157366ebe74e33ae1d7e9373091adab8327482154afc0693a549522f8c796dd84d16e24bb221f5dbb809ca56dd2b6e799c5fa06b6d9c5c09ada54ea4c5db1523a9794ed22a3889e5e05b29f8ee0a8d61efe07ae28f65dece2ff7edc5b1416d7c7aad7f0d35e8f4a4b964dbf50ae9aa6d620157770d974131b3e7e3abd6d163d65758e2f0822db9c88598b9db6263d963d13942c91fc5efe34fc1e06e3020103a382010630820102301d0603551d0e041604145af418e419a639e1657db960996364a37ef20d403081d20603551d230481ca3081c780145af418e419a639e1657db960996364a37ef20d40a181a3a481a030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564820900d7cb412f75f4887e300c0603551d13040530030101ff300d06092a864886f70d0101050500038201010076c2a11fe303359689c2ebc7b2c398eff8c3f9ad545cdbac75df63bf7b5395b6988d1842d6aa1556d595b5692e08224d667a4c9c438f05e74906c53dd8016dde7004068866f01846365efd146e9bfaa48c9ecf657f87b97c757da11f225c4a24177bf2d7188e6cce2a70a1e8a841a14471eb51457398b8a0addd8b6c8c1538ca8f1e40b4d8b960009ea22c188d28924813d2c0b4a4d334b7cf05507e1fcf0a06fe946c7ffc435e173af6fc3e3400643710acc806f830a14788291d46f2feed9fb5c70423ca747ed1572d752894ac1f19f93989766308579393fabb43649aa8806a313b1ab9a50922a44c2467b9062037f2da0d484d9ffd8fe628eeea629ba637";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.800 -0500", hash_original_field = "30B0D3496BF1F6A87821E676E3546F56", hash_generated_field = "DF4BF47628B1E5D523B71D6861D9C5BA")

    private static final Signature[] SIGNATURES = new Signature[] {
        new Signature(SIGNATURE_1)
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.792 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.794 -0500", hash_original_field = "C076407CBEDD5A489CBF1D08293B081D", hash_generated_field = "F51EF617CB965624F997697237656B33")

    private ArrayList<PackageInfo> mPackageInfoCache;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.802 -0500", hash_original_method = "0D07D19E48ED71562BE80BC3DA9E707F", hash_generated_method = "75E4F754C582D1180C09EA86ADE78688")
    
private PluginManager(Context context) {
        mContext = context;
        mPackageInfoCache = new ArrayList<PackageInfo>();
    }

    /**
     * Signal the WebCore thread to refresh its list of plugins. Use this if the
     * directory contents of one of the plugin directories has been modified and
     * needs its changes reflecting. May cause plugin load and/or unload.
     * 
     * @param reloadOpenPages Set to true to reload all open pages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.807 -0500", hash_original_method = "2EF75139857ED5BD518FA65C3602E9EA", hash_generated_method = "4540CE8C9203346F3D761BE6AF8DA95C")
    
public void refreshPlugins(boolean reloadOpenPages) {
        BrowserFrame.sJavaBridge.obtainMessage(
                JWebCoreJavaBridge.REFRESH_PLUGINS, reloadOpenPages)
                .sendToTarget();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.811 -0500", hash_original_method = "7B4BF60DDCCCE0391FC04EA9A7E517B7", hash_generated_method = "C68C0207D9228A1B69B5998F30FFE87C")
    
String[] getPluginDirectories() {

        ArrayList<String> directories = new ArrayList<String>();
        PackageManager pm = mContext.getPackageManager();
        List<ResolveInfo> plugins = pm.queryIntentServices(new Intent(PLUGIN_ACTION),
                PackageManager.GET_SERVICES | PackageManager.GET_META_DATA);

        synchronized(mPackageInfoCache) {

            // clear the list of existing packageInfo objects
            mPackageInfoCache.clear();

            for (ResolveInfo info : plugins) {

                // retrieve the plugin's service information
                ServiceInfo serviceInfo = info.serviceInfo;
                if (serviceInfo == null) {
                    Log.w(LOGTAG, "Ignore bad plugin");
                    continue;
                }

                // retrieve information from the plugin's manifest
                PackageInfo pkgInfo;
                try {
                    pkgInfo = pm.getPackageInfo(serviceInfo.packageName,
                                    PackageManager.GET_PERMISSIONS
                                    | PackageManager.GET_SIGNATURES);
                } catch (NameNotFoundException e) {
                    Log.w(LOGTAG, "Can't find plugin: " + serviceInfo.packageName);
                    continue;
                }
                if (pkgInfo == null) {
                    continue;
                }

                /*
                 * find the location of the plugin's shared library. The default
                 * is to assume the app is either a user installed app or an
                 * updated system app. In both of these cases the library is
                 * stored in the app's data directory.
                 */
                String directory = pkgInfo.applicationInfo.dataDir + "/lib";
                final int appFlags = pkgInfo.applicationInfo.flags;
                final int updatedSystemFlags = ApplicationInfo.FLAG_SYSTEM |
                                               ApplicationInfo.FLAG_UPDATED_SYSTEM_APP;
                // preloaded system app with no user updates
                if ((appFlags & updatedSystemFlags) == ApplicationInfo.FLAG_SYSTEM) {
                    directory = PLUGIN_SYSTEM_LIB + pkgInfo.packageName;
                }

                // check if the plugin has the required permissions and
                // signatures
                if (!containsPluginPermissionAndSignatures(pkgInfo)) {
                    continue;
                }

                // determine the type of plugin from the manifest
                if (serviceInfo.metaData == null) {
                    Log.e(LOGTAG, "The plugin '" + serviceInfo.name + "' has no type defined");
                    continue;
                }

                String pluginType = serviceInfo.metaData.getString(PLUGIN_TYPE);
                if (!TYPE_NATIVE.equals(pluginType)) {
                    Log.e(LOGTAG, "Unrecognized plugin type: " + pluginType);
                    continue;
                }

                try {
                    Class<?> cls = getPluginClass(serviceInfo.packageName, serviceInfo.name);

                    //TODO implement any requirements of the plugin class here!
                    boolean classFound = true;

                    if (!classFound) {
                        Log.e(LOGTAG, "The plugin's class' " + serviceInfo.name + "' does not extend the appropriate class.");
                        continue;
                    }

                } catch (NameNotFoundException e) {
                    Log.e(LOGTAG, "Can't find plugin: " + serviceInfo.packageName);
                    continue;
                } catch (ClassNotFoundException e) {
                    Log.e(LOGTAG, "Can't find plugin's class: " + serviceInfo.name);
                    continue;
                }

                // if all checks have passed then make the plugin available
                mPackageInfoCache.add(pkgInfo);
                directories.add(directory);
            }
        }

        return directories.toArray(new String[directories.size()]);
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.814 -0500", hash_original_method = "A1FA8B166BFF0FCEB8723AD1FF203538", hash_generated_method = "8611B7743D3918B2A437DB6D5406CF83")
    
boolean containsPluginPermissionAndSignatures(String pluginAPKName) {
        PackageManager pm = mContext.getPackageManager();

        // retrieve information from the plugin's manifest
        try {
            PackageInfo pkgInfo = pm.getPackageInfo(pluginAPKName, PackageManager.GET_PERMISSIONS
                    | PackageManager.GET_SIGNATURES);
            if (pkgInfo != null) {
                return containsPluginPermissionAndSignatures(pkgInfo);
            }
        } catch (NameNotFoundException e) {
            Log.w(LOGTAG, "Can't find plugin: " + pluginAPKName);
        }
        return false;
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.819 -0500", hash_original_method = "E90FACC8787C376685A6D80F188924B0", hash_generated_method = "39540C50D30C48AA4A5DAB3D03AFA36B")
    
String getPluginsAPKName(String pluginLib) {

        // basic error checking on input params
        if (pluginLib == null || pluginLib.length() == 0) {
            return null;
        }

        // must be synchronized to ensure the consistency of the cache
        synchronized(mPackageInfoCache) {
            for (PackageInfo pkgInfo : mPackageInfoCache) {
                if (pluginLib.contains(pkgInfo.packageName)) {
                    return pkgInfo.packageName;
                }
            }
        }

        // if no apk was found then return null
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.821 -0500", hash_original_method = "FC2E28857813BB5E17C54D889AE237C7", hash_generated_method = "FC2E28857813BB5E17C54D889AE237C7")
    
String getPluginSharedDataDirectory() {
        return mContext.getDir("plugins", 0).getPath();
    }

    /* package */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:05.823 -0500", hash_original_method = "44FD7B6877FFF90B805F430598983AE5", hash_generated_method = "44FD7B6877FFF90B805F430598983AE5")
    
Class<?> getPluginClass(String packageName, String className)
            throws NameNotFoundException, ClassNotFoundException {
        Context pluginContext = mContext.createPackageContext(packageName,
                Context.CONTEXT_INCLUDE_CODE |
                Context.CONTEXT_IGNORE_SECURITY);
        ClassLoader pluginCL = pluginContext.getClassLoader();
        return pluginCL.loadClass(className);
    }
}

