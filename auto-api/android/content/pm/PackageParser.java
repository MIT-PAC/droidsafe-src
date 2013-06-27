package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Slog;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PackageParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.308 -0400", hash_original_field = "6D55A934CD0311CDA3B2E6B59509DD26", hash_generated_field = "57425F83C121F61E241FD46B0ED62373")

    private String mArchiveSourcePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.308 -0400", hash_original_field = "49409C19162E9FEBA7D85BFAB66D22AB", hash_generated_field = "642D094C7AB0E1931029DBA1482587AA")

    private String[] mSeparateProcesses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.308 -0400", hash_original_field = "60FF333954B30D97597289A5E3F0D829", hash_generated_field = "7D4097DC031AD87620CBAE061A799BA0")

    private boolean mOnlyCoreApps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.308 -0400", hash_original_field = "2D2D1647C1F507DD0C69815A9B70EBB5", hash_generated_field = "809C28E1E054CBEE627F51452F62162E")

    private int mParseError = PackageManager.INSTALL_SUCCEEDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.308 -0400", hash_original_field = "30AFEEC03E0FC67FC72AC27E4D75F515", hash_generated_field = "5C8F41F6CF659609357D809C60CDDF3A")

    private ParsePackageItemArgs mParseInstrumentationArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.308 -0400", hash_original_field = "13625980AC052E44D25BE6F44D68FA9A", hash_generated_field = "65DE09F18AF72BEAF7CDD76662D74019")

    private ParseComponentArgs mParseActivityArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.309 -0400", hash_original_field = "807D2C9E81D3006A4C06D98BCBA1C937", hash_generated_field = "ACF41630823F563A230447D3D7E52494")

    private ParseComponentArgs mParseActivityAliasArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.319 -0400", hash_original_field = "0959A33D19686EFBEFC0AABD5F448A57", hash_generated_field = "9225E738D789335DA1CFA407299C2B0D")

    private ParseComponentArgs mParseServiceArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.320 -0400", hash_original_field = "A70EF10C819504A5FBF4E1F538F4B1E6", hash_generated_field = "319560D498F8EDD3EA50CA6B89B5AD1B")

    private ParseComponentArgs mParseProviderArgs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.321 -0400", hash_original_method = "DDBED2CCEF7CE747A37B4CF69A21D51E", hash_generated_method = "E69DDF97EF9C8A4CD053936837CFE800")
    public  PackageParser(String archiveSourcePath) {
        mArchiveSourcePath = archiveSourcePath;
        // ---------- Original Method ----------
        //mArchiveSourcePath = archiveSourcePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.322 -0400", hash_original_method = "65A62D9388B66A4D9595CDAEE2873A09", hash_generated_method = "103DD5B4DFB0483919E33AB133A239C0")
    public void setSeparateProcesses(String[] procs) {
        mSeparateProcesses = procs;
        // ---------- Original Method ----------
        //mSeparateProcesses = procs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.335 -0400", hash_original_method = "14C9699FDDD05F8B9AF1818DB0942037", hash_generated_method = "109C581621376AE52DD74733E1366244")
    public void setOnlyCoreApps(boolean onlyCoreApps) {
        mOnlyCoreApps = onlyCoreApps;
        // ---------- Original Method ----------
        //mOnlyCoreApps = onlyCoreApps;
    }

    
        private static final boolean isPackageFilename(String name) {
        return name.endsWith(".apk");
    }

    
        public static PackageInfo generatePackageInfo(PackageParser.Package p,
            int gids[], int flags, long firstInstallTime, long lastUpdateTime) {
        PackageInfo pi = new PackageInfo();
        pi.packageName = p.packageName;
        pi.versionCode = p.mVersionCode;
        pi.versionName = p.mVersionName;
        pi.sharedUserId = p.mSharedUserId;
        pi.sharedUserLabel = p.mSharedUserLabel;
        pi.applicationInfo = generateApplicationInfo(p, flags);
        pi.installLocation = p.installLocation;
        pi.firstInstallTime = firstInstallTime;
        pi.lastUpdateTime = lastUpdateTime;
        if ((flags&PackageManager.GET_GIDS) != 0) {
            pi.gids = gids;
        }
        if ((flags&PackageManager.GET_CONFIGURATIONS) != 0) {
            int N = p.configPreferences.size();
            if (N > 0) {
                pi.configPreferences = new ConfigurationInfo[N];
                p.configPreferences.toArray(pi.configPreferences);
            }
            N = p.reqFeatures != null ? p.reqFeatures.size() : 0;
            if (N > 0) {
                pi.reqFeatures = new FeatureInfo[N];
                p.reqFeatures.toArray(pi.reqFeatures);
            }
        }
        if ((flags&PackageManager.GET_ACTIVITIES) != 0) {
            int N = p.activities.size();
            if (N > 0) {
                if ((flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                    pi.activities = new ActivityInfo[N];
                } else {
                    int num = 0;
                    for (int i=0; i<N; i++) {
                        if (p.activities.get(i).info.enabled) num++;
                    }
                    pi.activities = new ActivityInfo[num];
                }
                for (int i=0, j=0; i<N; i++) {
                    final Activity activity = p.activities.get(i);
                    if (activity.info.enabled
                        || (flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                        pi.activities[j++] = generateActivityInfo(p.activities.get(i), flags);
                    }
                }
            }
        }
        if ((flags&PackageManager.GET_RECEIVERS) != 0) {
            int N = p.receivers.size();
            if (N > 0) {
                if ((flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                    pi.receivers = new ActivityInfo[N];
                } else {
                    int num = 0;
                    for (int i=0; i<N; i++) {
                        if (p.receivers.get(i).info.enabled) num++;
                    }
                    pi.receivers = new ActivityInfo[num];
                }
                for (int i=0, j=0; i<N; i++) {
                    final Activity activity = p.receivers.get(i);
                    if (activity.info.enabled
                        || (flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                        pi.receivers[j++] = generateActivityInfo(p.receivers.get(i), flags);
                    }
                }
            }
        }
        if ((flags&PackageManager.GET_SERVICES) != 0) {
            int N = p.services.size();
            if (N > 0) {
                if ((flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                    pi.services = new ServiceInfo[N];
                } else {
                    int num = 0;
                    for (int i=0; i<N; i++) {
                        if (p.services.get(i).info.enabled) num++;
                    }
                    pi.services = new ServiceInfo[num];
                }
                for (int i=0, j=0; i<N; i++) {
                    final Service service = p.services.get(i);
                    if (service.info.enabled
                        || (flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                        pi.services[j++] = generateServiceInfo(p.services.get(i), flags);
                    }
                }
            }
        }
        if ((flags&PackageManager.GET_PROVIDERS) != 0) {
            int N = p.providers.size();
            if (N > 0) {
                if ((flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                    pi.providers = new ProviderInfo[N];
                } else {
                    int num = 0;
                    for (int i=0; i<N; i++) {
                        if (p.providers.get(i).info.enabled) num++;
                    }
                    pi.providers = new ProviderInfo[num];
                }
                for (int i=0, j=0; i<N; i++) {
                    final Provider provider = p.providers.get(i);
                    if (provider.info.enabled
                        || (flags&PackageManager.GET_DISABLED_COMPONENTS) != 0) {
                        pi.providers[j++] = generateProviderInfo(p.providers.get(i), flags);
                    }
                }
            }
        }
        if ((flags&PackageManager.GET_INSTRUMENTATION) != 0) {
            int N = p.instrumentation.size();
            if (N > 0) {
                pi.instrumentation = new InstrumentationInfo[N];
                for (int i=0; i<N; i++) {
                    pi.instrumentation[i] = generateInstrumentationInfo(
                            p.instrumentation.get(i), flags);
                }
            }
        }
        if ((flags&PackageManager.GET_PERMISSIONS) != 0) {
            int N = p.permissions.size();
            if (N > 0) {
                pi.permissions = new PermissionInfo[N];
                for (int i=0; i<N; i++) {
                    pi.permissions[i] = generatePermissionInfo(p.permissions.get(i), flags);
                }
            }
            N = p.requestedPermissions.size();
            if (N > 0) {
                pi.requestedPermissions = new String[N];
                for (int i=0; i<N; i++) {
                    pi.requestedPermissions[i] = p.requestedPermissions.get(i);
                }
            }
        }
        if ((flags&PackageManager.GET_SIGNATURES) != 0) {
           int N = (p.mSignatures != null) ? p.mSignatures.length : 0;
           if (N > 0) {
                pi.signatures = new Signature[N];
                System.arraycopy(p.mSignatures, 0, pi.signatures, 0, N);
            }
        }
        return pi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.363 -0400", hash_original_method = "83F32E741E7740326FB3ACF1CABD2263", hash_generated_method = "F7556C1F23EF7DB64B365C19D92E71EE")
    private Certificate[] loadCertificates(JarFile jarFile, JarEntry je,
            byte[] readBuffer) {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_900718701 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1467025127 = null; //Variable for return #2
        try 
        {
            InputStream is;
            is = new BufferedInputStream(jarFile.getInputStream(je));
            {
                boolean var7C3826F57E2B97B3B91292A259636CBB_2134832686 = (is.read(readBuffer, 0, readBuffer.length) != -1);
            } //End collapsed parenthetic
            is.close();
            varB4EAC82CA7396A68D541C85D26508E83_900718701 = je != null ? je.getCertificates() : null;
        } //End block
        catch (IOException e)
        { }
        catch (RuntimeException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1467025127 = null;
        addTaint(jarFile.getTaint());
        addTaint(je.getTaint());
        addTaint(readBuffer[0]);
        Certificate[] varA7E53CE21691AB073D9660D615818899_427093404; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_427093404 = varB4EAC82CA7396A68D541C85D26508E83_900718701;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_427093404 = varB4EAC82CA7396A68D541C85D26508E83_1467025127;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_427093404.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_427093404;
        // ---------- Original Method ----------
        //try {
            //InputStream is = new BufferedInputStream(jarFile.getInputStream(je));
            //while (is.read(readBuffer, 0, readBuffer.length) != -1) {
            //}
            //is.close();
            //return je != null ? je.getCertificates() : null;
        //} catch (IOException e) {
            //Slog.w(TAG, "Exception reading " + je.getName() + " in "
                    //+ jarFile.getName(), e);
        //} catch (RuntimeException e) {
            //Slog.w(TAG, "Exception reading " + je.getName() + " in "
                    //+ jarFile.getName(), e);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.364 -0400", hash_original_method = "043AC7F11A9C5FD11FB43AEF955AD87D", hash_generated_method = "C1E7FD692570675EE41E017CD6510D79")
    public int getParseError() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332804845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332804845;
        // ---------- Original Method ----------
        //return mParseError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.428 -0400", hash_original_method = "F8C0CFF9FE003FD5724E792D5942913B", hash_generated_method = "66B5FD47AD27224222D1CAB9A90862B4")
    public Package parsePackage(File sourceFile, String destCodePath,
            DisplayMetrics metrics, int flags) {
        Package varB4EAC82CA7396A68D541C85D26508E83_1134601952 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_379836716 = null; //Variable for return #2
        Package varB4EAC82CA7396A68D541C85D26508E83_610683542 = null; //Variable for return #3
        Package varB4EAC82CA7396A68D541C85D26508E83_1439753261 = null; //Variable for return #4
        Package varB4EAC82CA7396A68D541C85D26508E83_1880902697 = null; //Variable for return #5
        mParseError = PackageManager.INSTALL_SUCCEEDED;
        mArchiveSourcePath = sourceFile.getPath();
        {
            boolean var2116955FB837CE636F98A7918949A04E_1633999511 = (!sourceFile.isFile());
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
                varB4EAC82CA7396A68D541C85D26508E83_1134601952 = null;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE987AF766FA74B3AD459FB1E585029DA_997553360 = (!isPackageFilename(sourceFile.getName())
                && (flags&PARSE_MUST_BE_APK) != 0);
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
                varB4EAC82CA7396A68D541C85D26508E83_379836716 = null;
            } //End block
        } //End collapsed parenthetic
        Slog.d(TAG, "Scanning package: " + mArchiveSourcePath);
        XmlResourceParser parser;
        parser = null;
        AssetManager assmgr;
        assmgr = null;
        Resources res;
        res = null;
        boolean assetError;
        assetError = true;
        try 
        {
            assmgr = new AssetManager();
            int cookie;
            cookie = assmgr.addAssetPath(mArchiveSourcePath);
            {
                res = new Resources(assmgr, metrics, null);
                assmgr.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        Build.VERSION.RESOURCES_SDK_INT);
                parser = assmgr.openXmlResourceParser(cookie, ANDROID_MANIFEST_FILENAME);
                assetError = false;
            } //End block
        } //End block
        catch (Exception e)
        { }
        {
            assmgr.close();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST;
            varB4EAC82CA7396A68D541C85D26508E83_610683542 = null;
        } //End block
        String[] errorText;
        errorText = new String[1];
        Package pkg;
        pkg = null;
        Exception errorException;
        errorException = null;
        try 
        {
            pkg = parsePackage(res, parser, flags, errorText);
        } //End block
        catch (Exception e)
        {
            errorException = e;
            mParseError = PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
        } //End block
        {
            {
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                } //End block
            } //End block
            parser.close();
            assmgr.close();
            varB4EAC82CA7396A68D541C85D26508E83_1439753261 = null;
        } //End block
        parser.close();
        assmgr.close();
        pkg.mPath = destCodePath;
        pkg.mScanPath = mArchiveSourcePath;
        pkg.mSignatures = null;
        varB4EAC82CA7396A68D541C85D26508E83_1880902697 = pkg;
        addTaint(destCodePath.getTaint());
        addTaint(metrics.getTaint());
        addTaint(flags);
        Package varA7E53CE21691AB073D9660D615818899_65178404; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_65178404 = varB4EAC82CA7396A68D541C85D26508E83_1134601952;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_65178404 = varB4EAC82CA7396A68D541C85D26508E83_379836716;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_65178404 = varB4EAC82CA7396A68D541C85D26508E83_610683542;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_65178404 = varB4EAC82CA7396A68D541C85D26508E83_1439753261;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_65178404 = varB4EAC82CA7396A68D541C85D26508E83_1880902697;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_65178404.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_65178404;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.503 -0400", hash_original_method = "19D0E628AA10FC207BA0D548739FDEDB", hash_generated_method = "AAAC94283CCF2CF5806363D433BB3DD8")
    public boolean collectCertificates(Package pkg, int flags) {
        pkg.mSignatures = null;
        WeakReference<byte[]> readBufferRef;
        byte[] readBuffer;
        readBuffer = null;
        {
            readBufferRef = mReadBuffer;
            {
                mReadBuffer = null;
                readBuffer = readBufferRef.get();
            } //End block
            {
                readBuffer = new byte[8192];
                readBufferRef = new WeakReference<byte[]>(readBuffer);
            } //End block
        } //End block
        try 
        {
            JarFile jarFile;
            jarFile = new JarFile(mArchiveSourcePath);
            Certificate[] certs;
            certs = null;
            {
                JarEntry jarEntry;
                jarEntry = jarFile.getJarEntry(ANDROID_MANIFEST_FILENAME);
                certs = loadCertificates(jarFile, jarEntry, readBuffer);
                {
                    jarFile.close();
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                } //End block
                {
                    {
                        int N;
                        N = certs.length;
                        {
                            int i;
                            i = 0;
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
            {
                Enumeration<JarEntry> entries;
                entries = jarFile.entries();
                Manifest manifest;
                manifest = jarFile.getManifest();
                {
                    boolean var66E70F3459E5CCB8614D20E01A26E86F_1892717857 = (entries.hasMoreElements());
                    {
                        JarEntry je;
                        je = entries.nextElement();
                        {
                            boolean var65B8E195C8AA7059C67BF79286782095_510441883 = (je.isDirectory());
                        } //End collapsed parenthetic
                        String name;
                        name = je.getName();
                        {
                            boolean var12A901F777A40C9D283732267E266735_1755758850 = (name.startsWith("META-INF/"));
                        } //End collapsed parenthetic
                        {
                            boolean varD99F64D135246231C00791AFEBF1DD6F_1193442571 = (ANDROID_MANIFEST_FILENAME.equals(name));
                            {
                                Attributes attributes;
                                attributes = manifest.getAttributes(name);
                                pkg.manifestDigest = ManifestDigest.fromAttributes(attributes);
                            } //End block
                        } //End collapsed parenthetic
                        Certificate[] localCerts;
                        localCerts = loadCertificates(jarFile, je, readBuffer);
                        {
                            jarFile.close();
                            mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                        } //End block
                        {
                            certs = localCerts;
                        } //End block
                        {
                            {
                                int i;
                                i = 0;
                                {
                                    boolean found;
                                    found = false;
                                    {
                                        int j;
                                        j = 0;
                                        {
                                            {
                                                boolean var22FC5E2CA793FEEACF89DAB3AB42E666_2024721961 = (certs[i] != null &&
                                        certs[i].equals(localCerts[j]));
                                                {
                                                    found = true;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        jarFile.close();
                                        mParseError = PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES;
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            jarFile.close();
            {
                mReadBuffer = readBufferRef;
            } //End block
            {
                int N;
                N = certs.length;
                pkg.mSignatures = new Signature[certs.length];
                {
                    int i;
                    i = 0;
                    {
                        pkg.mSignatures[i] = new Signature(
                            certs[i].getEncoded());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
            } //End block
        } //End block
        catch (CertificateEncodingException e)
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
        } //End block
        catch (IOException e)
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
        } //End block
        catch (RuntimeException e)
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
        } //End block
        addTaint(pkg.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424977541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424977541;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static PackageLite parsePackageLite(String packageFilePath, int flags) {
        AssetManager assmgr = null;
        final XmlResourceParser parser;
        final Resources res;
        try {
            assmgr = new AssetManager();
            assmgr.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    Build.VERSION.RESOURCES_SDK_INT);
            int cookie = assmgr.addAssetPath(packageFilePath);
            if (cookie == 0) {
                return null;
            }
            final DisplayMetrics metrics = new DisplayMetrics();
            metrics.setToDefaults();
            res = new Resources(assmgr, metrics, null);
            parser = assmgr.openXmlResourceParser(cookie, ANDROID_MANIFEST_FILENAME);
        } catch (Exception e) {
            if (assmgr != null) assmgr.close();
            Slog.w(TAG, "Unable to read AndroidManifest.xml of "
                    + packageFilePath, e);
            return null;
        }
        final AttributeSet attrs = parser;
        final String errors[] = new String[1];
        PackageLite packageLite = null;
        try {
            packageLite = parsePackageLite(res, parser, attrs, flags, errors);
        } catch (IOException e) {
            Slog.w(TAG, packageFilePath, e);
        } catch (XmlPullParserException e) {
            Slog.w(TAG, packageFilePath, e);
        } finally {
            if (parser != null) parser.close();
            if (assmgr != null) assmgr.close();
        }
        if (packageLite == null) {
            Slog.e(TAG, "parsePackageLite error: " + errors[0]);
            return null;
        }
        return packageLite;
    }

    
        private static String validateName(String name, boolean requiresSeparator) {
        final int N = name.length();
        boolean hasSep = false;
        boolean front = true;
        for (int i=0; i<N; i++) {
            final char c = name.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                front = false;
                continue;
            }
            if (!front) {
                if ((c >= '0' && c <= '9') || c == '_') {
                    continue;
                }
            }
            if (c == '.') {
                hasSep = true;
                front = true;
                continue;
            }
            return "bad character '" + c + "'";
        }
        return hasSep || !requiresSeparator
                ? null : "must have at least one '.' separator";
    }

    
        private static String parsePackageName(XmlPullParser parser,
            AttributeSet attrs, int flags, String[] outError) throws IOException, XmlPullParserException {
        int type;
        while ((type = parser.next()) != XmlPullParser.START_TAG
                && type != XmlPullParser.END_DOCUMENT) {
            ;
        }
        if (type != XmlPullParser.START_TAG) {
            outError[0] = "No start tag found";
            return null;
        }
        if (DEBUG_PARSER)
            Slog.v(TAG, "Root element name: '" + parser.getName() + "'");
        if (!parser.getName().equals("manifest")) {
            outError[0] = "No <manifest> tag";
            return null;
        }
        String pkgName = attrs.getAttributeValue(null, "package");
        if (pkgName == null || pkgName.length() == 0) {
            outError[0] = "<manifest> does not specify package";
            return null;
        }
        String nameError = validateName(pkgName, true);
        if (nameError != null && !"android".equals(pkgName)) {
            outError[0] = "<manifest> specifies bad package name \""
                + pkgName + "\": " + nameError;
            return null;
        }
        return pkgName.intern();
    }

    
        private static PackageLite parsePackageLite(Resources res, XmlPullParser parser,
            AttributeSet attrs, int flags, String[] outError) throws IOException,
            XmlPullParserException {
        int type;
        while ((type = parser.next()) != XmlPullParser.START_TAG
                && type != XmlPullParser.END_DOCUMENT) {
            ;
        }
        if (type != XmlPullParser.START_TAG) {
            outError[0] = "No start tag found";
            return null;
        }
        if (DEBUG_PARSER)
            Slog.v(TAG, "Root element name: '" + parser.getName() + "'");
        if (!parser.getName().equals("manifest")) {
            outError[0] = "No <manifest> tag";
            return null;
        }
        String pkgName = attrs.getAttributeValue(null, "package");
        if (pkgName == null || pkgName.length() == 0) {
            outError[0] = "<manifest> does not specify package";
            return null;
        }
        String nameError = validateName(pkgName, true);
        if (nameError != null && !"android".equals(pkgName)) {
            outError[0] = "<manifest> specifies bad package name \""
                + pkgName + "\": " + nameError;
            return null;
        }
        int installLocation = PARSE_DEFAULT_INSTALL_LOCATION;
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            String attr = attrs.getAttributeName(i);
            if (attr.equals("installLocation")) {
                installLocation = attrs.getAttributeIntValue(i,
                        PARSE_DEFAULT_INSTALL_LOCATION);
                break;
            }
        }
        final int searchDepth = parser.getDepth() + 1;
        final List<VerifierInfo> verifiers = new ArrayList<VerifierInfo>();
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() >= searchDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }
            if (parser.getDepth() == searchDepth && "package-verifier".equals(parser.getName())) {
                final VerifierInfo verifier = parseVerifier(res, parser, attrs, flags, outError);
                if (verifier != null) {
                    verifiers.add(verifier);
                }
            }
        }
        return new PackageLite(pkgName.intern(), installLocation, verifiers);
    }

    
        static public Signature stringToSignature(String str) {
        final int N = str.length();
        byte[] sig = new byte[N];
        for (int i=0; i<N; i++) {
            sig[i] = (byte)str.charAt(i);
        }
        return new Signature(sig);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.940 -0400", hash_original_method = "91CC6CEE84025557458760F97B90CD2F", hash_generated_method = "3DF502A416555D28548F946A269DF584")
    private Package parsePackage(
        Resources res, XmlResourceParser parser, int flags, String[] outError) throws XmlPullParserException, IOException {
        Package varB4EAC82CA7396A68D541C85D26508E83_143183937 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_1999892314 = null; //Variable for return #2
        Package varB4EAC82CA7396A68D541C85D26508E83_1396936926 = null; //Variable for return #3
        Package varB4EAC82CA7396A68D541C85D26508E83_1111128747 = null; //Variable for return #4
        Package varB4EAC82CA7396A68D541C85D26508E83_1995785742 = null; //Variable for return #5
        Package varB4EAC82CA7396A68D541C85D26508E83_595598814 = null; //Variable for return #6
        Package varB4EAC82CA7396A68D541C85D26508E83_2136264453 = null; //Variable for return #7
        Package varB4EAC82CA7396A68D541C85D26508E83_863561651 = null; //Variable for return #8
        Package varB4EAC82CA7396A68D541C85D26508E83_456547128 = null; //Variable for return #9
        Package varB4EAC82CA7396A68D541C85D26508E83_1365060278 = null; //Variable for return #10
        Package varB4EAC82CA7396A68D541C85D26508E83_382608965 = null; //Variable for return #11
        Package varB4EAC82CA7396A68D541C85D26508E83_848327078 = null; //Variable for return #12
        Package varB4EAC82CA7396A68D541C85D26508E83_1435340829 = null; //Variable for return #13
        Package varB4EAC82CA7396A68D541C85D26508E83_791549716 = null; //Variable for return #14
        AttributeSet attrs;
        attrs = parser;
        mParseInstrumentationArgs = null;
        mParseActivityArgs = null;
        mParseServiceArgs = null;
        mParseProviderArgs = null;
        String pkgName;
        pkgName = parsePackageName(parser, attrs, flags, outError);
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME;
            varB4EAC82CA7396A68D541C85D26508E83_143183937 = null;
        } //End block
        int type;
        {
            boolean core;
            core = attrs.getAttributeBooleanValue(null, "coreApp", false);
            {
                mParseError = PackageManager.INSTALL_SUCCEEDED;
                varB4EAC82CA7396A68D541C85D26508E83_1999892314 = null;
            } //End block
        } //End block
        Package pkg;
        pkg = new Package(pkgName);
        boolean foundApp;
        foundApp = false;
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifest);
        pkg.mVersionCode = sa.getInteger(
                com.android.internal.R.styleable.AndroidManifest_versionCode, 0);
        pkg.mVersionName = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifest_versionName, 0);
        {
            pkg.mVersionName = pkg.mVersionName.intern();
        } //End block
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifest_sharedUserId, 0);
        {
            boolean var848F079761698AAA15DA481349AE4E2C_14390096 = (str != null && str.length() > 0);
            {
                String nameError;
                nameError = validateName(str, true);
                {
                    boolean var3584BEC91545D68DD465FD5F522C42C6_1174878501 = (nameError != null && !"android".equals(pkgName));
                    {
                        outError[0] = "<manifest> specifies bad sharedUserId name \""
                    + str + "\": " + nameError;
                        mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID;
                        varB4EAC82CA7396A68D541C85D26508E83_1396936926 = null;
                    } //End block
                } //End collapsed parenthetic
                pkg.mSharedUserId = str.intern();
                pkg.mSharedUserLabel = sa.getResourceId(
                    com.android.internal.R.styleable.AndroidManifest_sharedUserLabel, 0);
            } //End block
        } //End collapsed parenthetic
        sa.recycle();
        pkg.installLocation = sa.getInteger(
                com.android.internal.R.styleable.AndroidManifest_installLocation,
                PARSE_DEFAULT_INSTALL_LOCATION);
        pkg.applicationInfo.installLocation = pkg.installLocation;
        int supportsSmallScreens;
        supportsSmallScreens = 1;
        int supportsNormalScreens;
        supportsNormalScreens = 1;
        int supportsLargeScreens;
        supportsLargeScreens = 1;
        int supportsXLargeScreens;
        supportsXLargeScreens = 1;
        int resizeable;
        resizeable = 1;
        int anyDensity;
        anyDensity = 1;
        int outerDepth;
        outerDepth = parser.getDepth();
        {
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_508231440 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String tagName;
                tagName = parser.getName();
                {
                    boolean varF8EAF590C1B64C9ECDBBED748B7E5C90_235846339 = (tagName.equals("application"));
                    {
                        {
                            {
                                outError[0] = "<manifest> has more than one <application>";
                                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                varB4EAC82CA7396A68D541C85D26508E83_1111128747 = null;
                            } //End block
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                        } //End block
                        foundApp = true;
                        {
                            boolean var3F08D3B967070ABA06096CA5595722C6_2121837269 = (!parseApplication(pkg, res, parser, attrs, flags, outError));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1995785742 = null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var88F37FCC2212880098EC750FD7FA678E_1451821559 = (tagName.equals("permission-group"));
                        {
                            {
                                boolean varA3A061F96EC4ABDE7DF00644D4DC4F07_1756354993 = (parsePermissionGroup(pkg, res, parser, attrs, outError) == null);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_595598814 = null;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varA9E2A3737C0FBDF0991489F6DD343AFF_1765843120 = (tagName.equals("permission"));
                            {
                                {
                                    boolean var031D0486BD05B9C0D2042849F5F3141A_1826203380 = (parsePermission(pkg, res, parser, attrs, outError) == null);
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_2136264453 = null;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var836521A07EF0241F200539CA3EAEBB53_504258545 = (tagName.equals("permission-tree"));
                                {
                                    {
                                        boolean var80E4FF566B617B00A711B29F5C1E1757_1749641252 = (parsePermissionTree(pkg, res, parser, attrs, outError) == null);
                                        {
                                            varB4EAC82CA7396A68D541C85D26508E83_863561651 = null;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varA169552B3D4E050C516F6D3C5EF2DCCF_368943182 = (tagName.equals("uses-permission"));
                                    {
                                        sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesPermission);
                                        String name;
                                        name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesPermission_name);
                                        sa.recycle();
                                        {
                                            boolean var082B823035F8549A56F9D48448C4F285_1449971991 = (name != null && !pkg.requestedPermissions.contains(name));
                                            {
                                                pkg.requestedPermissions.add(name.intern());
                                            } //End block
                                        } //End collapsed parenthetic
                                        XmlUtils.skipCurrentTag(parser);
                                    } //End block
                                    {
                                        boolean varA84278BF88B46415D3BE370CFBFD451C_803216130 = (tagName.equals("uses-configuration"));
                                        {
                                            ConfigurationInfo cPref;
                                            cPref = new ConfigurationInfo();
                                            sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration);
                                            cPref.reqTouchScreen = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqTouchScreen,
                        Configuration.TOUCHSCREEN_UNDEFINED);
                                            cPref.reqKeyboardType = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqKeyboardType,
                        Configuration.KEYBOARD_UNDEFINED);
                                            {
                                                boolean var924E4F92F1FFCDA9F61F59577D850520_1555969741 = (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqHardKeyboard,
                        false));
                                                {
                                                    cPref.reqInputFeatures |= ConfigurationInfo.INPUT_FEATURE_HARD_KEYBOARD;
                                                } //End block
                                            } //End collapsed parenthetic
                                            cPref.reqNavigation = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqNavigation,
                        Configuration.NAVIGATION_UNDEFINED);
                                            {
                                                boolean var8CB04F871EC31574AA19A06D968517C9_235940106 = (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqFiveWayNav,
                        false));
                                                {
                                                    cPref.reqInputFeatures |= ConfigurationInfo.INPUT_FEATURE_FIVE_WAY_NAV;
                                                } //End block
                                            } //End collapsed parenthetic
                                            sa.recycle();
                                            pkg.configPreferences.add(cPref);
                                            XmlUtils.skipCurrentTag(parser);
                                        } //End block
                                        {
                                            boolean varF2200A6E80C65CE9764A5AB44448B694_1968924776 = (tagName.equals("uses-feature"));
                                            {
                                                FeatureInfo fi;
                                                fi = new FeatureInfo();
                                                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesFeature);
                                                fi.name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesFeature_name);
                                                {
                                                    fi.reqGlEsVersion = sa.getInt(
                            com.android.internal.R.styleable.AndroidManifestUsesFeature_glEsVersion,
                            FeatureInfo.GL_ES_VERSION_UNDEFINED);
                                                } //End block
                                                {
                                                    boolean varD9C467CCB2BCF1D250FD1CF0D09CC347_1555017583 = (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesFeature_required,
                        true));
                                                    {
                                                        fi.flags |= FeatureInfo.FLAG_REQUIRED;
                                                    } //End block
                                                } //End collapsed parenthetic
                                                sa.recycle();
                                                {
                                                    pkg.reqFeatures = new ArrayList<FeatureInfo>();
                                                } //End block
                                                pkg.reqFeatures.add(fi);
                                                {
                                                    ConfigurationInfo cPref;
                                                    cPref = new ConfigurationInfo();
                                                    cPref.reqGlEsVersion = fi.reqGlEsVersion;
                                                    pkg.configPreferences.add(cPref);
                                                } //End block
                                                XmlUtils.skipCurrentTag(parser);
                                            } //End block
                                            {
                                                boolean varFD3F13DA5EFB9E6C614B2570E348634E_2077127551 = (tagName.equals("uses-sdk"));
                                                {
                                                    {
                                                        sa = res.obtainAttributes(attrs,
                            com.android.internal.R.styleable.AndroidManifestUsesSdk);
                                                        int minVers;
                                                        minVers = 0;
                                                        String minCode;
                                                        minCode = null;
                                                        int targetVers;
                                                        targetVers = 0;
                                                        String targetCode;
                                                        targetCode = null;
                                                        TypedValue val;
                                                        val = sa.peekValue(
                            com.android.internal.R.styleable.AndroidManifestUsesSdk_minSdkVersion);
                                                        {
                                                            {
                                                                targetCode = minCode = val.string.toString();
                                                            } //End block
                                                            {
                                                                targetVers = minVers = val.data;
                                                            } //End block
                                                        } //End block
                                                        val = sa.peekValue(
                            com.android.internal.R.styleable.AndroidManifestUsesSdk_targetSdkVersion);
                                                        {
                                                            {
                                                                targetCode = minCode = val.string.toString();
                                                            } //End block
                                                            {
                                                                targetVers = val.data;
                                                            } //End block
                                                        } //End block
                                                        sa.recycle();
                                                        {
                                                            {
                                                                boolean var6D10D58F2AC3EADED3903025E0345117_1923912521 = (!minCode.equals(SDK_CODENAME));
                                                                {
                                                                    {
                                                                        outError[0] = "Requires development platform " + minCode
                                        + " (current platform is " + SDK_CODENAME + ")";
                                                                    } //End block
                                                                    {
                                                                        outError[0] = "Requires development platform " + minCode
                                        + " but this is a release platform.";
                                                                    } //End block
                                                                    mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
                                                                    varB4EAC82CA7396A68D541C85D26508E83_456547128 = null;
                                                                } //End block
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            outError[0] = "Requires newer sdk version #" + minVers
                                + " (current version is #" + SDK_VERSION + ")";
                                                            mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
                                                            varB4EAC82CA7396A68D541C85D26508E83_1365060278 = null;
                                                        } //End block
                                                        {
                                                            {
                                                                boolean varEB85D163C2686178E9072A154F2B1017_357038041 = (!targetCode.equals(SDK_CODENAME));
                                                                {
                                                                    {
                                                                        outError[0] = "Requires development platform " + targetCode
                                        + " (current platform is " + SDK_CODENAME + ")";
                                                                    } //End block
                                                                    {
                                                                        outError[0] = "Requires development platform " + targetCode
                                        + " but this is a release platform.";
                                                                    } //End block
                                                                    mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
                                                                    varB4EAC82CA7396A68D541C85D26508E83_382608965 = null;
                                                                } //End block
                                                            } //End collapsed parenthetic
                                                            pkg.applicationInfo.targetSdkVersion
                                = android.os.Build.VERSION_CODES.CUR_DEVELOPMENT;
                                                        } //End block
                                                        {
                                                            pkg.applicationInfo.targetSdkVersion = targetVers;
                                                        } //End block
                                                    } //End block
                                                    XmlUtils.skipCurrentTag(parser);
                                                } //End block
                                                {
                                                    boolean var2AD21980A6F7F6AA6C25A37BEDBD96B9_1249912443 = (tagName.equals("supports-screens"));
                                                    {
                                                        sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens);
                                                        pkg.applicationInfo.requiresSmallestWidthDp = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_requiresSmallestWidthDp,
                        0);
                                                        pkg.applicationInfo.compatibleWidthLimitDp = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_compatibleWidthLimitDp,
                        0);
                                                        pkg.applicationInfo.largestWidthLimitDp = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_largestWidthLimitDp,
                        0);
                                                        supportsSmallScreens = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_smallScreens,
                        supportsSmallScreens);
                                                        supportsNormalScreens = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_normalScreens,
                        supportsNormalScreens);
                                                        supportsLargeScreens = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_largeScreens,
                        supportsLargeScreens);
                                                        supportsXLargeScreens = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_xlargeScreens,
                        supportsXLargeScreens);
                                                        resizeable = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_resizeable,
                        resizeable);
                                                        anyDensity = sa.getInteger(
                        com.android.internal.R.styleable.AndroidManifestSupportsScreens_anyDensity,
                        anyDensity);
                                                        sa.recycle();
                                                        XmlUtils.skipCurrentTag(parser);
                                                    } //End block
                                                    {
                                                        boolean varF9A9EABB9F0DF8DD018A4B0AD7880A8B_2145683254 = (tagName.equals("protected-broadcast"));
                                                        {
                                                            sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestProtectedBroadcast);
                                                            String name;
                                                            name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestProtectedBroadcast_name);
                                                            sa.recycle();
                                                            {
                                                                {
                                                                    pkg.protectedBroadcasts = new ArrayList<String>();
                                                                } //End block
                                                                {
                                                                    boolean varB4E798A338C4A451F12E37DD5381CB93_163417078 = (!pkg.protectedBroadcasts.contains(name));
                                                                    {
                                                                        pkg.protectedBroadcasts.add(name.intern());
                                                                    } //End block
                                                                } //End collapsed parenthetic
                                                            } //End block
                                                            XmlUtils.skipCurrentTag(parser);
                                                        } //End block
                                                        {
                                                            boolean var5291B256BFE37755CFF9CE20B217D3AC_1374422893 = (tagName.equals("instrumentation"));
                                                            {
                                                                {
                                                                    boolean var3222D9132D95E509061C76EA54FCD97A_184825495 = (parseInstrumentation(pkg, res, parser, attrs, outError) == null);
                                                                    {
                                                                        varB4EAC82CA7396A68D541C85D26508E83_848327078 = null;
                                                                    } //End block
                                                                } //End collapsed parenthetic
                                                            } //End block
                                                            {
                                                                boolean varDB43EE5FBAE0090DBC136B39A4F7A029_1075208497 = (tagName.equals("original-package"));
                                                                {
                                                                    sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage);
                                                                    String orig;
                                                                    orig = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage_name, 0);
                                                                    {
                                                                        boolean varC5BA37D72C0CA59EA36C3742F7338E76_454704901 = (!pkg.packageName.equals(orig));
                                                                        {
                                                                            {
                                                                                pkg.mOriginalPackages = new ArrayList<String>();
                                                                                pkg.mRealPackage = pkg.packageName;
                                                                            } //End block
                                                                            pkg.mOriginalPackages.add(orig);
                                                                        } //End block
                                                                    } //End collapsed parenthetic
                                                                    sa.recycle();
                                                                    XmlUtils.skipCurrentTag(parser);
                                                                } //End block
                                                                {
                                                                    boolean var6865D9016C481EF68D6684F63BF7A11C_733903333 = (tagName.equals("adopt-permissions"));
                                                                    {
                                                                        sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage);
                                                                        String name;
                                                                        name = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage_name, 0);
                                                                        sa.recycle();
                                                                        {
                                                                            {
                                                                                pkg.mAdoptPermissions = new ArrayList<String>();
                                                                            } //End block
                                                                            pkg.mAdoptPermissions.add(name);
                                                                        } //End block
                                                                        XmlUtils.skipCurrentTag(parser);
                                                                    } //End block
                                                                    {
                                                                        boolean var46DB0BC9C1C1FE67FF2F47E40DD7773E_1912277008 = (tagName.equals("uses-gl-texture"));
                                                                        {
                                                                            XmlUtils.skipCurrentTag(parser);
                                                                        } //End block
                                                                        {
                                                                            boolean var66D0A46FD130C7E340121E79ACF5C0AA_1547716905 = (tagName.equals("compatible-screens"));
                                                                            {
                                                                                XmlUtils.skipCurrentTag(parser);
                                                                            } //End block
                                                                            {
                                                                                boolean varF501100954D0EBDDED0D103F0C602535_2101506289 = (tagName.equals("eat-comment"));
                                                                                {
                                                                                    XmlUtils.skipCurrentTag(parser);
                                                                                } //End block
                                                                                {
                                                                                    outError[0] = "Bad element under <manifest>: "
                    + parser.getName();
                                                                                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                                                                    varB4EAC82CA7396A68D541C85D26508E83_1435340829 = null;
                                                                                } //End block
                                                                                {
                                                                                    XmlUtils.skipCurrentTag(parser);
                                                                                } //End block
                                                                            } //End collapsed parenthetic
                                                                        } //End collapsed parenthetic
                                                                    } //End collapsed parenthetic
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var656CE6E53C04C7019D91D9C819F1B4B5_1050258742 = (!foundApp && pkg.instrumentation.size() == 0);
            {
                outError[0] = "<manifest> does not contain an <application> or <instrumentation>";
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_EMPTY;
            } //End block
        } //End collapsed parenthetic
        int NP;
        NP = PackageParser.NEW_PERMISSIONS.length;
        StringBuilder implicitPerms;
        implicitPerms = null;
        {
            int ip;
            ip = 0;
            {
                PackageParser.NewPermissionInfo npi;
                npi = PackageParser.NEW_PERMISSIONS[ip];
                {
                    boolean var992143486215F1959F9E138F82FD3565_760951097 = (!pkg.requestedPermissions.contains(npi.name));
                    {
                        {
                            implicitPerms = new StringBuilder(128);
                            implicitPerms.append(pkg.packageName);
                            implicitPerms.append(": compat added ");
                        } //End block
                        {
                            implicitPerms.append(' ');
                        } //End block
                        implicitPerms.append(npi.name);
                        pkg.requestedPermissions.add(npi.name);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_SMALL_SCREENS;
        } //End block
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_NORMAL_SCREENS;
        } //End block
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS;
        } //End block
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS;
        } //End block
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_RESIZEABLE_FOR_SCREENS;
        } //End block
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_791549716 = pkg;
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(flags);
        addTaint(outError[0].getTaint());
        Package varA7E53CE21691AB073D9660D615818899_454702864; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_143183937;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_1999892314;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_1396936926;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_1111128747;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_1995785742;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_595598814;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_2136264453;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_863561651;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_456547128;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_1365060278;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_382608965;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_848327078;
                break;
            case 13: //Assign result for return ordinal #13
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_1435340829;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_454702864 = varB4EAC82CA7396A68D541C85D26508E83_791549716;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_454702864.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_454702864;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static String buildClassName(String pkg, CharSequence clsSeq,
            String[] outError) {
        if (clsSeq == null || clsSeq.length() <= 0) {
            outError[0] = "Empty class name in package " + pkg;
            return null;
        }
        String cls = clsSeq.toString();
        char c = cls.charAt(0);
        if (c == '.') {
            return (pkg + cls).intern();
        }
        if (cls.indexOf('.') < 0) {
            StringBuilder b = new StringBuilder(pkg);
            b.append('.');
            b.append(cls);
            return b.toString().intern();
        }
        if (c >= 'a' && c <= 'z') {
            return cls.intern();
        }
        outError[0] = "Bad class name " + cls + " in package " + pkg;
        return null;
    }

    
        private static String buildCompoundName(String pkg,
            CharSequence procSeq, String type, String[] outError) {
        String proc = procSeq.toString();
        char c = proc.charAt(0);
        if (pkg != null && c == ':') {
            if (proc.length() < 2) {
                outError[0] = "Bad " + type + " name " + proc + " in package " + pkg
                        + ": must be at least two characters";
                return null;
            }
            String subName = proc.substring(1);
            String nameError = validateName(subName, false);
            if (nameError != null) {
                outError[0] = "Invalid " + type + " name " + proc + " in package "
                        + pkg + ": " + nameError;
                return null;
            }
            return (pkg + proc).intern();
        }
        String nameError = validateName(proc, true);
        if (nameError != null && !"system".equals(proc)) {
            outError[0] = "Invalid " + type + " name " + proc + " in package "
                    + pkg + ": " + nameError;
            return null;
        }
        return proc.intern();
    }

    
        private static String buildProcessName(String pkg, String defProc,
            CharSequence procSeq, int flags, String[] separateProcesses,
            String[] outError) {
        if ((flags&PARSE_IGNORE_PROCESSES) != 0 && !"system".equals(procSeq)) {
            return defProc != null ? defProc : pkg;
        }
        if (separateProcesses != null) {
            for (int i=separateProcesses.length-1; i>=0; i--) {
                String sp = separateProcesses[i];
                if (sp.equals(pkg) || sp.equals(defProc) || sp.equals(procSeq)) {
                    return pkg;
                }
            }
        }
        if (procSeq == null || procSeq.length() <= 0) {
            return defProc;
        }
        return buildCompoundName(pkg, procSeq, "process", outError);
    }

    
        private static String buildTaskAffinityName(String pkg, String defProc,
            CharSequence procSeq, String[] outError) {
        if (procSeq == null) {
            return defProc;
        }
        if (procSeq.length() <= 0) {
            return null;
        }
        return buildCompoundName(pkg, procSeq, "taskAffinity", outError);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:08.981 -0400", hash_original_method = "E3395575DA3BE4CF83D20AFB0193668F", hash_generated_method = "1960B83804417120F24982BFB6AA4733")
    private PermissionGroup parsePermissionGroup(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        PermissionGroup varB4EAC82CA7396A68D541C85D26508E83_1888490927 = null; //Variable for return #1
        PermissionGroup varB4EAC82CA7396A68D541C85D26508E83_1101092848 = null; //Variable for return #2
        PermissionGroup varB4EAC82CA7396A68D541C85D26508E83_2107508999 = null; //Variable for return #3
        PermissionGroup perm;
        perm = new PermissionGroup(owner);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup);
        {
            boolean var9E2AF09338E745C2FAF713E73B46A2FD_228374363 = (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-group>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_name,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_label,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_logo));
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                varB4EAC82CA7396A68D541C85D26508E83_1888490927 = null;
            } //End block
        } //End collapsed parenthetic
        perm.info.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_description,
                0);
        sa.recycle();
        {
            boolean var72A93BDEF638BC31E81E8D057EEDC5F2_884059604 = (!parseAllMetaData(res, parser, attrs, "<permission-group>", perm,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                varB4EAC82CA7396A68D541C85D26508E83_1101092848 = null;
            } //End block
        } //End collapsed parenthetic
        owner.permissionGroups.add(perm);
        varB4EAC82CA7396A68D541C85D26508E83_2107508999 = perm;
        addTaint(owner.getTaint());
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(outError[0].getTaint());
        PermissionGroup varA7E53CE21691AB073D9660D615818899_1443514118; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1443514118 = varB4EAC82CA7396A68D541C85D26508E83_1888490927;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1443514118 = varB4EAC82CA7396A68D541C85D26508E83_1101092848;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1443514118 = varB4EAC82CA7396A68D541C85D26508E83_2107508999;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1443514118.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1443514118;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.019 -0400", hash_original_method = "1D11570A32C6A271E593822206F9BD54", hash_generated_method = "01565FD870E5C39CFFEEFB2DACD398DA")
    private Permission parsePermission(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1604933943 = null; //Variable for return #1
        Permission varB4EAC82CA7396A68D541C85D26508E83_1219002609 = null; //Variable for return #2
        Permission varB4EAC82CA7396A68D541C85D26508E83_1871707917 = null; //Variable for return #3
        Permission varB4EAC82CA7396A68D541C85D26508E83_1104212808 = null; //Variable for return #4
        Permission perm;
        perm = new Permission(owner);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermission);
        {
            boolean var0DD909B519CC387E5C9EA83C899B39D0_1228644935 = (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission>", sa,
                com.android.internal.R.styleable.AndroidManifestPermission_name,
                com.android.internal.R.styleable.AndroidManifestPermission_label,
                com.android.internal.R.styleable.AndroidManifestPermission_icon,
                com.android.internal.R.styleable.AndroidManifestPermission_logo));
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                varB4EAC82CA7396A68D541C85D26508E83_1604933943 = null;
            } //End block
        } //End collapsed parenthetic
        perm.info.group = sa.getNonResourceString(
                com.android.internal.R.styleable.AndroidManifestPermission_permissionGroup);
        {
            perm.info.group = perm.info.group.intern();
        } //End block
        perm.info.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestPermission_description,
                0);
        perm.info.protectionLevel = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestPermission_protectionLevel,
                PermissionInfo.PROTECTION_NORMAL);
        sa.recycle();
        {
            outError[0] = "<permission> does not specify protectionLevel";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            varB4EAC82CA7396A68D541C85D26508E83_1219002609 = null;
        } //End block
        {
            boolean var2A0B3F43EBF50AFBE5CFD9DAED89DDE6_592981552 = (!parseAllMetaData(res, parser, attrs, "<permission>", perm,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                varB4EAC82CA7396A68D541C85D26508E83_1871707917 = null;
            } //End block
        } //End collapsed parenthetic
        owner.permissions.add(perm);
        varB4EAC82CA7396A68D541C85D26508E83_1104212808 = perm;
        addTaint(owner.getTaint());
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(outError[0].getTaint());
        Permission varA7E53CE21691AB073D9660D615818899_870835520; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_870835520 = varB4EAC82CA7396A68D541C85D26508E83_1604933943;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_870835520 = varB4EAC82CA7396A68D541C85D26508E83_1219002609;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_870835520 = varB4EAC82CA7396A68D541C85D26508E83_1871707917;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_870835520 = varB4EAC82CA7396A68D541C85D26508E83_1104212808;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_870835520.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_870835520;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.058 -0400", hash_original_method = "BAA3C6F5A9B5CEE097497C276EDD624D", hash_generated_method = "23DC8DE5E360B757A8A424EEC21A3984")
    private Permission parsePermissionTree(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1858015716 = null; //Variable for return #1
        Permission varB4EAC82CA7396A68D541C85D26508E83_1603210627 = null; //Variable for return #2
        Permission varB4EAC82CA7396A68D541C85D26508E83_1478839557 = null; //Variable for return #3
        Permission varB4EAC82CA7396A68D541C85D26508E83_178287343 = null; //Variable for return #4
        Permission perm;
        perm = new Permission(owner);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionTree);
        {
            boolean varD42E96DB3FE92B943E062DCA246DD395_499711638 = (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-tree>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_name,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_label,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_logo));
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                varB4EAC82CA7396A68D541C85D26508E83_1858015716 = null;
            } //End block
        } //End collapsed parenthetic
        sa.recycle();
        int index;
        index = perm.info.name.indexOf('.');
        {
            index = perm.info.name.indexOf('.', index+1);
        } //End block
        {
            outError[0] = "<permission-tree> name has less than three segments: "
                + perm.info.name;
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            varB4EAC82CA7396A68D541C85D26508E83_1603210627 = null;
        } //End block
        perm.info.descriptionRes = 0;
        perm.info.protectionLevel = PermissionInfo.PROTECTION_NORMAL;
        perm.tree = true;
        {
            boolean var6929934279609305F522DA245D911766_2024655919 = (!parseAllMetaData(res, parser, attrs, "<permission-tree>", perm,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                varB4EAC82CA7396A68D541C85D26508E83_1478839557 = null;
            } //End block
        } //End collapsed parenthetic
        owner.permissions.add(perm);
        varB4EAC82CA7396A68D541C85D26508E83_178287343 = perm;
        addTaint(owner.getTaint());
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(outError[0].getTaint());
        Permission varA7E53CE21691AB073D9660D615818899_973343954; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_973343954 = varB4EAC82CA7396A68D541C85D26508E83_1858015716;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_973343954 = varB4EAC82CA7396A68D541C85D26508E83_1603210627;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_973343954 = varB4EAC82CA7396A68D541C85D26508E83_1478839557;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_973343954 = varB4EAC82CA7396A68D541C85D26508E83_178287343;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_973343954.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_973343954;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.095 -0400", hash_original_method = "77B98478A5AAF7EC4E5B725BE9FDC9E7", hash_generated_method = "6EAC018EB1DDCE2D827D1520C20F1C76")
    private Instrumentation parseInstrumentation(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        Instrumentation varB4EAC82CA7396A68D541C85D26508E83_1864564125 = null; //Variable for return #1
        Instrumentation varB4EAC82CA7396A68D541C85D26508E83_1683365346 = null; //Variable for return #2
        Instrumentation varB4EAC82CA7396A68D541C85D26508E83_1293344816 = null; //Variable for return #3
        Instrumentation varB4EAC82CA7396A68D541C85D26508E83_1997700246 = null; //Variable for return #4
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestInstrumentation);
        {
            mParseInstrumentationArgs = new ParsePackageItemArgs(owner, outError,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_name,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_label,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_icon,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_logo);
            mParseInstrumentationArgs.tag = "<instrumentation>";
        } //End block
        mParseInstrumentationArgs.sa = sa;
        Instrumentation a;
        a = new Instrumentation(mParseInstrumentationArgs,
                new InstrumentationInfo());
        {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            varB4EAC82CA7396A68D541C85D26508E83_1864564125 = null;
        } //End block
        String str;
        str = sa.getNonResourceString(
                com.android.internal.R.styleable.AndroidManifestInstrumentation_targetPackage);
        a.info.targetPackage = str != null ? str.intern() : null;
        a.info.handleProfiling = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestInstrumentation_handleProfiling,
                false);
        a.info.functionalTest = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestInstrumentation_functionalTest,
                false);
        sa.recycle();
        {
            outError[0] = "<instrumentation> does not specify targetPackage";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            varB4EAC82CA7396A68D541C85D26508E83_1683365346 = null;
        } //End block
        {
            boolean var8EF4E0F1A82EA6AFCA94A4D8598E7664_2029928730 = (!parseAllMetaData(res, parser, attrs, "<instrumentation>", a,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                varB4EAC82CA7396A68D541C85D26508E83_1293344816 = null;
            } //End block
        } //End collapsed parenthetic
        owner.instrumentation.add(a);
        varB4EAC82CA7396A68D541C85D26508E83_1997700246 = a;
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        Instrumentation varA7E53CE21691AB073D9660D615818899_278587076; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_278587076 = varB4EAC82CA7396A68D541C85D26508E83_1864564125;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_278587076 = varB4EAC82CA7396A68D541C85D26508E83_1683365346;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_278587076 = varB4EAC82CA7396A68D541C85D26508E83_1293344816;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_278587076 = varB4EAC82CA7396A68D541C85D26508E83_1997700246;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_278587076.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_278587076;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.255 -0400", hash_original_method = "3784AF975EC3AF37D03EE1A91A900A73", hash_generated_method = "F10A7423080D9505466847481EBE9AC2")
    private boolean parseApplication(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        ApplicationInfo ai;
        ai = owner.applicationInfo;
        String pkgName;
        pkgName = owner.applicationInfo.packageName;
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestApplication);
        String name;
        name = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_name, 0);
        {
            ai.className = buildClassName(pkgName, name, outError);
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            } //End block
        } //End block
        String manageSpaceActivity;
        manageSpaceActivity = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_manageSpaceActivity, 0);
        {
            ai.manageSpaceActivityName = buildClassName(pkgName, manageSpaceActivity,
                    outError);
        } //End block
        boolean allowBackup;
        allowBackup = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowBackup, true);
        {
            ai.flags |= ApplicationInfo.FLAG_ALLOW_BACKUP;
            String backupAgent;
            backupAgent = sa.getNonConfigurationString(
                    com.android.internal.R.styleable.AndroidManifestApplication_backupAgent, 0);
            {
                ai.backupAgentName = buildClassName(pkgName, backupAgent, outError);
                {
                    boolean var3781D282DB322A26549149946193414D_238028679 = (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_killAfterRestore,
                        true));
                    {
                        ai.flags |= ApplicationInfo.FLAG_KILL_AFTER_RESTORE;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEEF38F5B7F8DA558BCCE1D69A87ED5BD_890742568 = (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_restoreAnyVersion,
                        false));
                    {
                        ai.flags |= ApplicationInfo.FLAG_RESTORE_ANY_VERSION;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        TypedValue v;
        v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestApplication_label);
        {
            boolean var9092B245FCF833ED50175702D269F387_892682250 = (v != null && (ai.labelRes=v.resourceId) == 0);
            {
                ai.nonLocalizedLabel = v.coerceToString();
            } //End block
        } //End collapsed parenthetic
        ai.icon = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_icon, 0);
        ai.logo = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_logo, 0);
        ai.theme = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_theme, 0);
        ai.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_description, 0);
        {
            {
                boolean var87812553007A723CD6A5FC98D1BDC5B2_1428933619 = (sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestApplication_persistent,
                    false));
                {
                    ai.flags |= ApplicationInfo.FLAG_PERSISTENT;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            ai.flags |= ApplicationInfo.FLAG_FORWARD_LOCK;
        } //End block
        {
            ai.flags |= ApplicationInfo.FLAG_EXTERNAL_STORAGE;
        } //End block
        {
            boolean varA8E17EE0B66711E9FDEA3E8ACA2BFBEA_269612743 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_debuggable,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_DEBUGGABLE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCD872D55821622672581E8A3AE831EB4_182002803 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_vmSafeMode,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_VM_SAFE_MODE;
            } //End block
        } //End collapsed parenthetic
        boolean hardwareAccelerated;
        hardwareAccelerated = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_hardwareAccelerated,
                owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.ICE_CREAM_SANDWICH);
        {
            boolean var251C511CB0A0C29B4D5934FED89A22F9_320464464 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_hasCode,
                true));
            {
                ai.flags |= ApplicationInfo.FLAG_HAS_CODE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD15BA2820092392C9A70DEA1022BD860_1430891002 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowTaskReparenting,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var64DB4E16C417947EC00DA3B28C61802C_1991947360 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowClearUserData,
                true));
            {
                ai.flags |= ApplicationInfo.FLAG_ALLOW_CLEAR_USER_DATA;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1583D122D9A058ED6BE19A3237333EA0_231532112 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_testOnly,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_TEST_ONLY;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4AFC6550135025488E8A90F0D243D683_1114728357 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_largeHeap,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_LARGE_HEAP;
            } //End block
        } //End collapsed parenthetic
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_permission, 0);
        ai.permission = (str != null && str.length() > 0) ? str.intern() : null;
        {
            str = sa.getNonConfigurationString(
                    com.android.internal.R.styleable.AndroidManifestApplication_taskAffinity, 0);
        } //End block
        {
            str = sa.getNonResourceString(
                    com.android.internal.R.styleable.AndroidManifestApplication_taskAffinity);
        } //End block
        ai.taskAffinity = buildTaskAffinityName(ai.packageName, ai.packageName,
                str, outError);
        {
            CharSequence pname;
            {
                pname = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestApplication_process, 0);
            } //End block
            {
                pname = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestApplication_process);
            } //End block
            ai.processName = buildProcessName(ai.packageName, null, pname,
                    flags, mSeparateProcesses, outError);
            ai.enabled = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestApplication_enabled, true);
            {
                {
                    boolean varEBA33D9E3C6F99BD9035DB8C8CBC9431_63694321 = (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_cantSaveState,
                        false));
                    {
                        ai.flags |= ApplicationInfo.FLAG_CANT_SAVE_STATE;
                        {
                            outError[0] = "cantSaveState applications can not use custom processes";
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        ai.uiOptions = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestApplication_uiOptions, 0);
        sa.recycle();
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
        } //End block
        int innerDepth;
        innerDepth = parser.getDepth();
        int type;
        {
            boolean varC66FE93CD4CE831A2BA43B64A992D597_1572858932 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth));
            {
                String tagName;
                tagName = parser.getName();
                {
                    boolean varCEA39CC7DD315AF5DD9CF498474F6A04_1499468651 = (tagName.equals("activity"));
                    {
                        Activity a;
                        a = parseActivity(owner, res, parser, attrs, flags, outError, false,
                        hardwareAccelerated);
                        {
                            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        } //End block
                        owner.activities.add(a);
                    } //End block
                    {
                        boolean varBFC5A7632401121A805E0B8C8BD62B81_937824374 = (tagName.equals("receiver"));
                        {
                            Activity a;
                            a = parseActivity(owner, res, parser, attrs, flags, outError, true, false);
                            {
                                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                            } //End block
                            owner.receivers.add(a);
                        } //End block
                        {
                            boolean var21E9802D4101B46F2076E1671DBB2E7E_958455216 = (tagName.equals("service"));
                            {
                                Service s;
                                s = parseService(owner, res, parser, attrs, flags, outError);
                                {
                                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                } //End block
                                owner.services.add(s);
                            } //End block
                            {
                                boolean varEFE1204453EBD024E72F8F8FEA9421C6_1275089301 = (tagName.equals("provider"));
                                {
                                    Provider p;
                                    p = parseProvider(owner, res, parser, attrs, flags, outError);
                                    {
                                        mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                    } //End block
                                    owner.providers.add(p);
                                } //End block
                                {
                                    boolean var5A497C595CAF1DB300BAE058439CF8DB_771467966 = (tagName.equals("activity-alias"));
                                    {
                                        Activity a;
                                        a = parseActivityAlias(owner, res, parser, attrs, flags, outError);
                                        {
                                            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                        } //End block
                                        owner.activities.add(a);
                                    } //End block
                                    {
                                        boolean var91AADB0FFDCA4B3CD7737D6304F15B05_1488618070 = (parser.getName().equals("meta-data"));
                                        {
                                            {
                                                boolean varB1F8175B799EE9DC06601F6EE00285D6_572828242 = ((owner.mAppMetaData = parseMetaData(res, parser, attrs, owner.mAppMetaData,
                        outError)) == null);
                                                {
                                                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var31400F483E6E601672F212C83EBEF810_1741751047 = (tagName.equals("uses-library"));
                                            {
                                                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary);
                                                String lname;
                                                lname = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary_name);
                                                boolean req;
                                                req = sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary_required,
                        true);
                                                sa.recycle();
                                                {
                                                    {
                                                        {
                                                            owner.usesLibraries = new ArrayList<String>();
                                                        } //End block
                                                        {
                                                            boolean var6A1106BAA5BD5B3974BACBAD9BF1AAFE_505899447 = (!owner.usesLibraries.contains(lname));
                                                            {
                                                                owner.usesLibraries.add(lname.intern());
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        {
                                                            owner.usesOptionalLibraries = new ArrayList<String>();
                                                        } //End block
                                                        {
                                                            boolean var2EF7D28E9E6284E9A73DE8FDBB80D772_1920995559 = (!owner.usesOptionalLibraries.contains(lname));
                                                            {
                                                                owner.usesOptionalLibraries.add(lname.intern());
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                } //End block
                                                XmlUtils.skipCurrentTag(parser);
                                            } //End block
                                            {
                                                boolean varCD7EAA3A97E9E0F8C954B188A8E0E51A_1853745917 = (tagName.equals("uses-package"));
                                                {
                                                    XmlUtils.skipCurrentTag(parser);
                                                } //End block
                                                {
                                                    {
                                                        XmlUtils.skipCurrentTag(parser);
                                                    } //End block
                                                    {
                                                        outError[0] = "Bad element under <application>: " + tagName;
                                                        mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                                    } //End block
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(owner.getTaint());
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(flags);
        addTaint(outError[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564084656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_564084656;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.274 -0400", hash_original_method = "63CFF58BE3C03EE3AAF09BEB17B3529D", hash_generated_method = "4BE71940DEC4FFE714B2E32883915DAE")
    private boolean parsePackageItemInfo(Package owner, PackageItemInfo outInfo,
            String[] outError, String tag, TypedArray sa,
            int nameRes, int labelRes, int iconRes, int logoRes) {
        String name;
        name = sa.getNonConfigurationString(nameRes, 0);
        {
            outError[0] = tag + " does not specify android:name";
        } //End block
        outInfo.name
            = buildClassName(owner.applicationInfo.packageName, name, outError);
        int iconVal;
        iconVal = sa.getResourceId(iconRes, 0);
        {
            outInfo.icon = iconVal;
            outInfo.nonLocalizedLabel = null;
        } //End block
        int logoVal;
        logoVal = sa.getResourceId(logoRes, 0);
        {
            outInfo.logo = logoVal;
        } //End block
        TypedValue v;
        v = sa.peekValue(labelRes);
        {
            boolean var91D75606D26FF6CB57581960C4C28D7F_267574174 = (v != null && (outInfo.labelRes=v.resourceId) == 0);
            {
                outInfo.nonLocalizedLabel = v.coerceToString();
            } //End block
        } //End collapsed parenthetic
        outInfo.packageName = owner.packageName;
        addTaint(owner.getTaint());
        addTaint(outInfo.getTaint());
        addTaint(outError[0].getTaint());
        addTaint(tag.getTaint());
        addTaint(sa.getTaint());
        addTaint(nameRes);
        addTaint(labelRes);
        addTaint(iconRes);
        addTaint(logoRes);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341642073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341642073;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.421 -0400", hash_original_method = "5541C23C630FF3AC70030479982C4C1F", hash_generated_method = "863731816C7C71F575B51448333EF4E9")
    private Activity parseActivity(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError,
            boolean receiver, boolean hardwareAccelerated) throws XmlPullParserException, IOException {
        Activity varB4EAC82CA7396A68D541C85D26508E83_543441261 = null; //Variable for return #1
        Activity varB4EAC82CA7396A68D541C85D26508E83_2067660416 = null; //Variable for return #2
        Activity varB4EAC82CA7396A68D541C85D26508E83_1343358993 = null; //Variable for return #3
        Activity varB4EAC82CA7396A68D541C85D26508E83_848861426 = null; //Variable for return #4
        Activity varB4EAC82CA7396A68D541C85D26508E83_235948118 = null; //Variable for return #5
        Activity varB4EAC82CA7396A68D541C85D26508E83_2083348442 = null; //Variable for return #6
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestActivity);
        {
            mParseActivityArgs = new ParseComponentArgs(owner, outError,
                    com.android.internal.R.styleable.AndroidManifestActivity_name,
                    com.android.internal.R.styleable.AndroidManifestActivity_label,
                    com.android.internal.R.styleable.AndroidManifestActivity_icon,
                    com.android.internal.R.styleable.AndroidManifestActivity_logo,
                    mSeparateProcesses,
                    com.android.internal.R.styleable.AndroidManifestActivity_process,
                    com.android.internal.R.styleable.AndroidManifestActivity_description,
                    com.android.internal.R.styleable.AndroidManifestActivity_enabled);
        } //End block
        mParseActivityArgs.tag = receiver ? "<receiver>" : "<activity>";
        mParseActivityArgs.sa = sa;
        mParseActivityArgs.flags = flags;
        Activity a;
        a = new Activity(mParseActivityArgs, new ActivityInfo());
        {
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_543441261 = null;
        } //End block
        boolean setExported;
        setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestActivity_exported);
        {
            a.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivity_exported, false);
        } //End block
        a.info.theme = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestActivity_theme, 0);
        a.info.uiOptions = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestActivity_uiOptions,
                a.info.applicationInfo.uiOptions);
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivity_permission, 0);
        {
            a.info.permission = owner.applicationInfo.permission;
        } //End block
        {
            a.info.permission = str.length() > 0 ? str.toString().intern() : null;
        } //End block
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivity_taskAffinity, 0);
        a.info.taskAffinity = buildTaskAffinityName(owner.applicationInfo.packageName,
                owner.applicationInfo.taskAffinity, str, outError);
        a.info.flags = 0;
        {
            boolean varB5936475D75C10D27B26C2B758CCBE38_1984698617 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_multiprocess,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_MULTIPROCESS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBB9A814CD2F977B8CFFDF8586685D888_986380218 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnTaskLaunch,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_FINISH_ON_TASK_LAUNCH;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7214B1B3D1A30323865BB90BD536D99D_1479520013 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_clearTaskOnLaunch,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_CLEAR_TASK_ON_LAUNCH;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var525C5644769ECBECA90106BBD7CCA891_837999987 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_noHistory,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_NO_HISTORY;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var535A315BC7455B82982DBDF6ABB43639_360631122 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_alwaysRetainTaskState,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_ALWAYS_RETAIN_TASK_STATE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var310848EB8D34ABFD2902FA9D1E21F30A_837127127 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_stateNotNeeded,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_STATE_NOT_NEEDED;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB2D249AFE74887A225B4B48E465BA00_1084071204 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_excludeFromRecents,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_EXCLUDE_FROM_RECENTS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3E6FBC876B6E16D44BA233F203FA6701_87195947 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_allowTaskReparenting,
                (owner.applicationInfo.flags&ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING) != 0));
            {
                a.info.flags |= ActivityInfo.FLAG_ALLOW_TASK_REPARENTING;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varACE1D7FED9CA8DF00B89E18D2CE99755_1693336235 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnCloseSystemDialogs,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBF9E0FF7BB8F35A6FAA707C99AAECC66_38033662 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_immersive,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_IMMERSIVE;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var27FB7917CF2CF95A3EBC55BEC12A3B99_305793806 = (sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivity_hardwareAccelerated,
                    hardwareAccelerated));
                {
                    a.info.flags |= ActivityInfo.FLAG_HARDWARE_ACCELERATED;
                } //End block
            } //End collapsed parenthetic
            a.info.launchMode = sa.getInt(
                    com.android.internal.R.styleable.AndroidManifestActivity_launchMode,
                    ActivityInfo.LAUNCH_MULTIPLE);
            a.info.screenOrientation = sa.getInt(
                    com.android.internal.R.styleable.AndroidManifestActivity_screenOrientation,
                    ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            a.info.configChanges = sa.getInt(
                    com.android.internal.R.styleable.AndroidManifestActivity_configChanges,
                    0);
            a.info.softInputMode = sa.getInt(
                    com.android.internal.R.styleable.AndroidManifestActivity_windowSoftInputMode,
                    0);
        } //End block
        {
            a.info.launchMode = ActivityInfo.LAUNCH_MULTIPLE;
            a.info.configChanges = 0;
        } //End block
        sa.recycle();
        {
            {
                outError[0] = "Heavy-weight applications can not have receivers in main process";
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2067660416 = null;
        } //End block
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1391553563 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var558A80433485A0A91069570FE0753ABC_1744849720 = (parser.getName().equals("intent-filter"));
                    {
                        ActivityIntentInfo intent;
                        intent = new ActivityIntentInfo(a);
                        {
                            boolean varFEEAE359197455E997D8AE11C5F84F28_890329157 = (!parseIntent(res, parser, attrs, flags, intent, outError, !receiver));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1343358993 = null;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var33C0360B5D0DAC6FE381109188142C53_522442922 = (intent.countActions() == 0);
                            {
                                a.intents.add(intent);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var19E08DB77AFC65B1C7EB49759BAD99AF_281308026 = (parser.getName().equals("meta-data"));
                        {
                            {
                                boolean var0FC654D04193EA7E4A5364F21B1F8D9E_1669845898 = ((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_848861426 = null;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                {
                                    outError[0] = "Bad element under <receiver>: " + parser.getName();
                                } //End block
                                {
                                    outError[0] = "Bad element under <activity>: " + parser.getName();
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_235948118 = null;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            a.info.exported = a.intents.size() > 0;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2083348442 = a;
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(hardwareAccelerated);
        Activity varA7E53CE21691AB073D9660D615818899_1054640709; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1054640709 = varB4EAC82CA7396A68D541C85D26508E83_543441261;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1054640709 = varB4EAC82CA7396A68D541C85D26508E83_2067660416;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1054640709 = varB4EAC82CA7396A68D541C85D26508E83_1343358993;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1054640709 = varB4EAC82CA7396A68D541C85D26508E83_848861426;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1054640709 = varB4EAC82CA7396A68D541C85D26508E83_235948118;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1054640709 = varB4EAC82CA7396A68D541C85D26508E83_2083348442;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1054640709.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1054640709;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.509 -0400", hash_original_method = "2C553740AE22C20570EEFC51EEC11A38", hash_generated_method = "C4C89902D3CFA7AD91799465A489EA69")
    private Activity parseActivityAlias(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1304710115 = null; //Variable for return #1
        Activity varB4EAC82CA7396A68D541C85D26508E83_916644573 = null; //Variable for return #2
        Activity varB4EAC82CA7396A68D541C85D26508E83_527227398 = null; //Variable for return #3
        Activity varB4EAC82CA7396A68D541C85D26508E83_1675961898 = null; //Variable for return #4
        Activity varB4EAC82CA7396A68D541C85D26508E83_1446214673 = null; //Variable for return #5
        Activity varB4EAC82CA7396A68D541C85D26508E83_1908769562 = null; //Variable for return #6
        Activity varB4EAC82CA7396A68D541C85D26508E83_1103817074 = null; //Variable for return #7
        Activity varB4EAC82CA7396A68D541C85D26508E83_1781540852 = null; //Variable for return #8
        Activity varB4EAC82CA7396A68D541C85D26508E83_1236100677 = null; //Variable for return #9
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestActivityAlias);
        String targetActivity;
        targetActivity = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_targetActivity, 0);
        {
            outError[0] = "<activity-alias> does not specify android:targetActivity";
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_1304710115 = null;
        } //End block
        targetActivity = buildClassName(owner.applicationInfo.packageName,
                targetActivity, outError);
        {
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_916644573 = null;
        } //End block
        {
            mParseActivityAliasArgs = new ParseComponentArgs(owner, outError,
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_name,
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_label,
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_icon,
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_logo,
                    mSeparateProcesses,
                    0,
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_description,
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_enabled);
            mParseActivityAliasArgs.tag = "<activity-alias>";
        } //End block
        mParseActivityAliasArgs.sa = sa;
        mParseActivityAliasArgs.flags = flags;
        Activity target;
        target = null;
        int NA;
        NA = owner.activities.size();
        {
            int i;
            i = 0;
            {
                Activity t;
                t = owner.activities.get(i);
                {
                    boolean varCA2334A46342BD5024FA8928036F4FB7_148757373 = (targetActivity.equals(t.info.name));
                    {
                        target = t;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            outError[0] = "<activity-alias> target activity " + targetActivity
                    + " not found in manifest";
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_527227398 = null;
        } //End block
        ActivityInfo info;
        info = new ActivityInfo();
        info.targetActivity = targetActivity;
        info.configChanges = target.info.configChanges;
        info.flags = target.info.flags;
        info.icon = target.info.icon;
        info.logo = target.info.logo;
        info.labelRes = target.info.labelRes;
        info.nonLocalizedLabel = target.info.nonLocalizedLabel;
        info.launchMode = target.info.launchMode;
        info.processName = target.info.processName;
        {
            info.descriptionRes = target.info.descriptionRes;
        } //End block
        info.screenOrientation = target.info.screenOrientation;
        info.taskAffinity = target.info.taskAffinity;
        info.theme = target.info.theme;
        info.softInputMode = target.info.softInputMode;
        info.uiOptions = target.info.uiOptions;
        Activity a;
        a = new Activity(mParseActivityAliasArgs, info);
        {
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_1675961898 = null;
        } //End block
        boolean setExported;
        setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_exported);
        {
            a.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_exported, false);
        } //End block
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_permission, 0);
        {
            a.info.permission = str.length() > 0 ? str.toString().intern() : null;
        } //End block
        sa.recycle();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1446214673 = null;
        } //End block
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1656877286 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var558A80433485A0A91069570FE0753ABC_104453991 = (parser.getName().equals("intent-filter"));
                    {
                        ActivityIntentInfo intent;
                        intent = new ActivityIntentInfo(a);
                        {
                            boolean varBDA471758B32D3069E5A9AA8CF08294F_1466301474 = (!parseIntent(res, parser, attrs, flags, intent, outError, true));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1908769562 = null;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var33C0360B5D0DAC6FE381109188142C53_618919119 = (intent.countActions() == 0);
                            {
                                a.intents.add(intent);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var19E08DB77AFC65B1C7EB49759BAD99AF_84027417 = (parser.getName().equals("meta-data"));
                        {
                            {
                                boolean var0FC654D04193EA7E4A5364F21B1F8D9E_713890558 = ((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1103817074 = null;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                outError[0] = "Bad element under <activity-alias>: " + parser.getName();
                                varB4EAC82CA7396A68D541C85D26508E83_1781540852 = null;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            a.info.exported = a.intents.size() > 0;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1236100677 = a;
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        Activity varA7E53CE21691AB073D9660D615818899_1305815730; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_1304710115;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_916644573;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_527227398;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_1675961898;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_1446214673;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_1908769562;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_1103817074;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_1781540852;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1305815730 = varB4EAC82CA7396A68D541C85D26508E83_1236100677;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1305815730.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1305815730;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.588 -0400", hash_original_method = "CC761DF5515ACB2817B0A6BEDC12031E", hash_generated_method = "763FC4E9B2876483BF886AA3BB8FBE47")
    private Provider parseProvider(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        Provider varB4EAC82CA7396A68D541C85D26508E83_2081243394 = null; //Variable for return #1
        Provider varB4EAC82CA7396A68D541C85D26508E83_389891004 = null; //Variable for return #2
        Provider varB4EAC82CA7396A68D541C85D26508E83_1621847849 = null; //Variable for return #3
        Provider varB4EAC82CA7396A68D541C85D26508E83_1945089853 = null; //Variable for return #4
        Provider varB4EAC82CA7396A68D541C85D26508E83_860043183 = null; //Variable for return #5
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestProvider);
        {
            mParseProviderArgs = new ParseComponentArgs(owner, outError,
                    com.android.internal.R.styleable.AndroidManifestProvider_name,
                    com.android.internal.R.styleable.AndroidManifestProvider_label,
                    com.android.internal.R.styleable.AndroidManifestProvider_icon,
                    com.android.internal.R.styleable.AndroidManifestProvider_logo,
                    mSeparateProcesses,
                    com.android.internal.R.styleable.AndroidManifestProvider_process,
                    com.android.internal.R.styleable.AndroidManifestProvider_description,
                    com.android.internal.R.styleable.AndroidManifestProvider_enabled);
            mParseProviderArgs.tag = "<provider>";
        } //End block
        mParseProviderArgs.sa = sa;
        mParseProviderArgs.flags = flags;
        Provider p;
        p = new Provider(mParseProviderArgs, new ProviderInfo());
        {
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_2081243394 = null;
        } //End block
        p.info.exported = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestProvider_exported, true);
        String cpname;
        cpname = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_authorities, 0);
        p.info.isSyncable = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestProvider_syncable,
                false);
        String permission;
        permission = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_permission, 0);
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_readPermission, 0);
        {
            str = permission;
        } //End block
        {
            p.info.readPermission = owner.applicationInfo.permission;
        } //End block
        {
            p.info.readPermission =
                str.length() > 0 ? str.toString().intern() : null;
        } //End block
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_writePermission, 0);
        {
            str = permission;
        } //End block
        {
            p.info.writePermission = owner.applicationInfo.permission;
        } //End block
        {
            p.info.writePermission =
                str.length() > 0 ? str.toString().intern() : null;
        } //End block
        p.info.grantUriPermissions = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestProvider_grantUriPermissions,
                false);
        p.info.multiprocess = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestProvider_multiprocess,
                false);
        p.info.initOrder = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestProvider_initOrder,
                0);
        sa.recycle();
        {
            {
                outError[0] = "Heavy-weight applications can not have providers in main process";
                varB4EAC82CA7396A68D541C85D26508E83_389891004 = null;
            } //End block
        } //End block
        {
            outError[0] = "<provider> does not incude authorities attribute";
            varB4EAC82CA7396A68D541C85D26508E83_1621847849 = null;
        } //End block
        p.info.authority = cpname.intern();
        {
            boolean var4FDB5E1EC3E9C441BD9FB9F3A9CEE2E9_1124999765 = (!parseProviderTags(res, parser, attrs, p, outError));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1945089853 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_860043183 = p;
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        Provider varA7E53CE21691AB073D9660D615818899_159676649; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_159676649 = varB4EAC82CA7396A68D541C85D26508E83_2081243394;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_159676649 = varB4EAC82CA7396A68D541C85D26508E83_389891004;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_159676649 = varB4EAC82CA7396A68D541C85D26508E83_1621847849;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_159676649 = varB4EAC82CA7396A68D541C85D26508E83_1945089853;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_159676649 = varB4EAC82CA7396A68D541C85D26508E83_860043183;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_159676649.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_159676649;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.732 -0400", hash_original_method = "05A16AA66DEB0B6B5120CEC23FE33532", hash_generated_method = "628A15A91672DBE7DC7FF6055E9E99DC")
    private boolean parseProviderTags(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Provider outInfo, String[] outError) throws XmlPullParserException, IOException {
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1953937867 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var679A61A305D6D9AF7A442CDA01AE2C28_1272905739 = (parser.getName().equals("meta-data"));
                    {
                        {
                            boolean var989A6F06E5BD6363C928806CC7D69345_1705999072 = ((outInfo.metaData=parseMetaData(res, parser, attrs,
                        outInfo.metaData, outError)) == null);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varF06E7B1138273C400578FF82FA2DB071_555006153 = (parser.getName().equals("grant-uri-permission"));
                        {
                            TypedArray sa;
                            sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission);
                            PatternMatcher pa;
                            pa = null;
                            String str;
                            str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_path, 0);
                            {
                                pa = new PatternMatcher(str, PatternMatcher.PATTERN_LITERAL);
                            } //End block
                            str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_pathPrefix, 0);
                            {
                                pa = new PatternMatcher(str, PatternMatcher.PATTERN_PREFIX);
                            } //End block
                            str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_pathPattern, 0);
                            {
                                pa = new PatternMatcher(str, PatternMatcher.PATTERN_SIMPLE_GLOB);
                            } //End block
                            sa.recycle();
                            {
                                {
                                    outInfo.info.uriPermissionPatterns = new PatternMatcher[1];
                                    outInfo.info.uriPermissionPatterns[0] = pa;
                                } //End block
                                {
                                    int N;
                                    N = outInfo.info.uriPermissionPatterns.length;
                                    PatternMatcher[] newp;
                                    newp = new PatternMatcher[N+1];
                                    System.arraycopy(outInfo.info.uriPermissionPatterns, 0, newp, 0, N);
                                    newp[N] = pa;
                                    outInfo.info.uriPermissionPatterns = newp;
                                } //End block
                                outInfo.info.grantUriPermissions = true;
                            } //End block
                            {
                                {
                                    XmlUtils.skipCurrentTag(parser);
                                } //End block
                                {
                                    outError[0] = "No path, pathPrefix, or pathPattern for <path-permission>";
                                } //End block
                            } //End block
                            XmlUtils.skipCurrentTag(parser);
                        } //End block
                        {
                            boolean var6F38308E8F6BF3E7F05F9A7A5771E51E_1848907738 = (parser.getName().equals("path-permission"));
                            {
                                TypedArray sa;
                                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestPathPermission);
                                PathPermission pa;
                                pa = null;
                                String permission;
                                permission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_permission, 0);
                                String readPermission;
                                readPermission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_readPermission, 0);
                                {
                                    readPermission = permission;
                                } //End block
                                String writePermission;
                                writePermission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_writePermission, 0);
                                {
                                    writePermission = permission;
                                } //End block
                                boolean havePerm;
                                havePerm = false;
                                {
                                    readPermission = readPermission.intern();
                                    havePerm = true;
                                } //End block
                                {
                                    writePermission = writePermission.intern();
                                    havePerm = true;
                                } //End block
                                {
                                    {
                                        XmlUtils.skipCurrentTag(parser);
                                    } //End block
                                    {
                                        outError[0] = "No readPermission or writePermssion for <path-permission>";
                                    } //End block
                                } //End block
                                String path;
                                path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_path, 0);
                                {
                                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_LITERAL, readPermission, writePermission);
                                } //End block
                                path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_pathPrefix, 0);
                                {
                                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_PREFIX, readPermission, writePermission);
                                } //End block
                                path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_pathPattern, 0);
                                {
                                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_SIMPLE_GLOB, readPermission, writePermission);
                                } //End block
                                sa.recycle();
                                {
                                    {
                                        outInfo.info.pathPermissions = new PathPermission[1];
                                        outInfo.info.pathPermissions[0] = pa;
                                    } //End block
                                    {
                                        int N;
                                        N = outInfo.info.pathPermissions.length;
                                        PathPermission[] newp;
                                        newp = new PathPermission[N+1];
                                        System.arraycopy(outInfo.info.pathPermissions, 0, newp, 0, N);
                                        newp[N] = pa;
                                        outInfo.info.pathPermissions = newp;
                                    } //End block
                                } //End block
                                {
                                    {
                                        XmlUtils.skipCurrentTag(parser);
                                    } //End block
                                    outError[0] = "No path, pathPrefix, or pathPattern for <path-permission>";
                                } //End block
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                {
                                    XmlUtils.skipCurrentTag(parser);
                                } //End block
                                {
                                    outError[0] = "Bad element under <provider>: " + parser.getName();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(outInfo.getTaint());
        addTaint(outError[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104141218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104141218;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.790 -0400", hash_original_method = "1B6E257916FE773842F0B213D728DC29", hash_generated_method = "8C88D29EA41BBC3323730C18F852E08A")
    private Service parseService(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        Service varB4EAC82CA7396A68D541C85D26508E83_1185011766 = null; //Variable for return #1
        Service varB4EAC82CA7396A68D541C85D26508E83_1802945410 = null; //Variable for return #2
        Service varB4EAC82CA7396A68D541C85D26508E83_1370454205 = null; //Variable for return #3
        Service varB4EAC82CA7396A68D541C85D26508E83_1311723338 = null; //Variable for return #4
        Service varB4EAC82CA7396A68D541C85D26508E83_159998869 = null; //Variable for return #5
        Service varB4EAC82CA7396A68D541C85D26508E83_1435900481 = null; //Variable for return #6
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestService);
        {
            mParseServiceArgs = new ParseComponentArgs(owner, outError,
                    com.android.internal.R.styleable.AndroidManifestService_name,
                    com.android.internal.R.styleable.AndroidManifestService_label,
                    com.android.internal.R.styleable.AndroidManifestService_icon,
                    com.android.internal.R.styleable.AndroidManifestService_logo,
                    mSeparateProcesses,
                    com.android.internal.R.styleable.AndroidManifestService_process,
                    com.android.internal.R.styleable.AndroidManifestService_description,
                    com.android.internal.R.styleable.AndroidManifestService_enabled);
            mParseServiceArgs.tag = "<service>";
        } //End block
        mParseServiceArgs.sa = sa;
        mParseServiceArgs.flags = flags;
        Service s;
        s = new Service(mParseServiceArgs, new ServiceInfo());
        {
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_1185011766 = null;
        } //End block
        boolean setExported;
        setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestService_exported);
        {
            s.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestService_exported, false);
        } //End block
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestService_permission, 0);
        {
            s.info.permission = owner.applicationInfo.permission;
        } //End block
        {
            s.info.permission = str.length() > 0 ? str.toString().intern() : null;
        } //End block
        s.info.flags = 0;
        {
            boolean var48D9F4C063A4D64D9CBE4D757774C4E4_227150807 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestService_stopWithTask,
                false));
            {
                s.info.flags |= ServiceInfo.FLAG_STOP_WITH_TASK;
            } //End block
        } //End collapsed parenthetic
        sa.recycle();
        {
            {
                outError[0] = "Heavy-weight applications can not have services in main process";
                varB4EAC82CA7396A68D541C85D26508E83_1802945410 = null;
            } //End block
        } //End block
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_715623358 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var558A80433485A0A91069570FE0753ABC_1927019930 = (parser.getName().equals("intent-filter"));
                    {
                        ServiceIntentInfo intent;
                        intent = new ServiceIntentInfo(s);
                        {
                            boolean var8E3CB1B64FDFADDC5A768494AEBFAFDC_1053701753 = (!parseIntent(res, parser, attrs, flags, intent, outError, false));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1370454205 = null;
                            } //End block
                        } //End collapsed parenthetic
                        s.intents.add(intent);
                    } //End block
                    {
                        boolean var19E08DB77AFC65B1C7EB49759BAD99AF_732446076 = (parser.getName().equals("meta-data"));
                        {
                            {
                                boolean var2E64325FDEBB3D259469D65D24853448_1724583560 = ((s.metaData=parseMetaData(res, parser, attrs, s.metaData,
                        outError)) == null);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1311723338 = null;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                outError[0] = "Bad element under <service>: " + parser.getName();
                                varB4EAC82CA7396A68D541C85D26508E83_159998869 = null;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            s.info.exported = s.intents.size() > 0;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1435900481 = s;
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        Service varA7E53CE21691AB073D9660D615818899_254001338; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_254001338 = varB4EAC82CA7396A68D541C85D26508E83_1185011766;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_254001338 = varB4EAC82CA7396A68D541C85D26508E83_1802945410;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_254001338 = varB4EAC82CA7396A68D541C85D26508E83_1370454205;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_254001338 = varB4EAC82CA7396A68D541C85D26508E83_1311723338;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_254001338 = varB4EAC82CA7396A68D541C85D26508E83_159998869;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_254001338 = varB4EAC82CA7396A68D541C85D26508E83_1435900481;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_254001338.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_254001338;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.811 -0400", hash_original_method = "99FE3F7E654A8DB168806DBE6C913C62", hash_generated_method = "7D0C0DA5A69036CEC49B34EBE2B4A3BC")
    private boolean parseAllMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs, String tag,
            Component outInfo, String[] outError) throws XmlPullParserException, IOException {
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1874275472 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var679A61A305D6D9AF7A442CDA01AE2C28_2101881382 = (parser.getName().equals("meta-data"));
                    {
                        {
                            boolean var989A6F06E5BD6363C928806CC7D69345_1139700904 = ((outInfo.metaData=parseMetaData(res, parser, attrs,
                        outInfo.metaData, outError)) == null);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            XmlUtils.skipCurrentTag(parser);
                        } //End block
                        {
                            outError[0] = "Bad element under " + tag + ": " + parser.getName();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(tag.getTaint());
        addTaint(outInfo.getTaint());
        addTaint(outError[0].getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650558057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_650558057;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.869 -0400", hash_original_method = "714C7ED1FC52C32A41D3A8C089BB2BEC", hash_generated_method = "A7FEC6EF03DB8F927C9DAB80769F1182")
    private Bundle parseMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Bundle data, String[] outError) throws XmlPullParserException, IOException {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1517189834 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_430670349 = null; //Variable for return #2
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestMetaData);
        {
            data = new Bundle();
        } //End block
        String name;
        name = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestMetaData_name, 0);
        {
            outError[0] = "<meta-data> requires an android:name attribute";
            sa.recycle();
            varB4EAC82CA7396A68D541C85D26508E83_1517189834 = null;
        } //End block
        name = name.intern();
        TypedValue v;
        v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestMetaData_resource);
        {
            data.putInt(name, v.resourceId);
        } //End block
        {
            v = sa.peekValue(
                    com.android.internal.R.styleable.AndroidManifestMetaData_value);
            {
                {
                    CharSequence cs;
                    cs = v.coerceToString();
                    data.putString(name, cs != null ? cs.toString().intern() : null);
                } //End block
                {
                    data.putBoolean(name, v.data != 0);
                } //End block
                {
                    data.putInt(name, v.data);
                } //End block
                {
                    data.putFloat(name, v.getFloat());
                } //End block
                {
                    {
                        outError[0] = "<meta-data> only supports string, integer, float, color, boolean, and resource reference types";
                        data = null;
                    } //End block
                } //End block
            } //End block
            {
                outError[0] = "<meta-data> requires an android:value or android:resource attribute";
                data = null;
            } //End block
        } //End block
        sa.recycle();
        XmlUtils.skipCurrentTag(parser);
        varB4EAC82CA7396A68D541C85D26508E83_430670349 = data;
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(data.getTaint());
        addTaint(outError[0].getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_398820516; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_398820516 = varB4EAC82CA7396A68D541C85D26508E83_1517189834;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_398820516 = varB4EAC82CA7396A68D541C85D26508E83_430670349;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_398820516.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_398820516;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static VerifierInfo parseVerifier(Resources res, XmlPullParser parser,
            AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException,
            IOException {
        final TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPackageVerifier);
        final String packageName = sa.getNonResourceString(
                com.android.internal.R.styleable.AndroidManifestPackageVerifier_name);
        final String encodedPublicKey = sa.getNonResourceString(
                com.android.internal.R.styleable.AndroidManifestPackageVerifier_publicKey);
        sa.recycle();
        if (packageName == null || packageName.length() == 0) {
            Slog.i(TAG, "verifier package name was null; skipping");
            return null;
        } else if (encodedPublicKey == null) {
            Slog.i(TAG, "verifier " + packageName + " public key was null; skipping");
        }
        EncodedKeySpec keySpec;
        try {
            final byte[] encoded = Base64.decode(encodedPublicKey, Base64.DEFAULT);
            keySpec = new X509EncodedKeySpec(encoded);
        } catch (IllegalArgumentException e) {
            Slog.i(TAG, "Could not parse verifier " + packageName + " public key; invalid Base64");
            return null;
        }
        try {
            final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            final PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return new VerifierInfo(packageName, publicKey);
        } catch (NoSuchAlgorithmException e) {
            Log.wtf(TAG, "Could not parse public key because RSA isn't included in build");
            return null;
        } catch (InvalidKeySpecException e) {
        }
        try {
            final KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            final PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return new VerifierInfo(packageName, publicKey);
        } catch (NoSuchAlgorithmException e) {
            Log.wtf(TAG, "Could not parse public key because DSA isn't included in build");
            return null;
        } catch (InvalidKeySpecException e) {
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.027 -0400", hash_original_method = "B28F171FD6C00B48F648DC5DCFE3EFC1", hash_generated_method = "FA62D253CF0C1D653808933C6C68B297")
    private boolean parseIntent(Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags,
            IntentInfo outInfo, String[] outError, boolean isActivity) throws XmlPullParserException, IOException {
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestIntentFilter);
        int priority;
        priority = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_priority, 0);
        outInfo.setPriority(priority);
        TypedValue v;
        v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_label);
        {
            boolean var91D75606D26FF6CB57581960C4C28D7F_1929761303 = (v != null && (outInfo.labelRes=v.resourceId) == 0);
            {
                outInfo.nonLocalizedLabel = v.coerceToString();
            } //End block
        } //End collapsed parenthetic
        outInfo.icon = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_icon, 0);
        outInfo.logo = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_logo, 0);
        sa.recycle();
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_552209507 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String nodeName;
                nodeName = parser.getName();
                {
                    boolean varACA9F240F9ACEB0B60DCF0209B3C5B8B_2054808326 = (nodeName.equals("action"));
                    {
                        String value;
                        value = attrs.getAttributeValue(
                        ANDROID_RESOURCES, "name");
                        {
                            outError[0] = "No value supplied for <android:name>";
                        } //End block
                        XmlUtils.skipCurrentTag(parser);
                        outInfo.addAction(value);
                    } //End block
                    {
                        boolean var355168E41EBBD793F28449F985564D32_869811434 = (nodeName.equals("category"));
                        {
                            String value;
                            value = attrs.getAttributeValue(
                        ANDROID_RESOURCES, "name");
                            {
                                outError[0] = "No value supplied for <android:name>";
                            } //End block
                            XmlUtils.skipCurrentTag(parser);
                            outInfo.addCategory(value);
                        } //End block
                        {
                            boolean var623CB09FAE2071E98D47E3836399E32F_830125446 = (nodeName.equals("data"));
                            {
                                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestData);
                                String str;
                                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_mimeType, 0);
                                {
                                    try 
                                    {
                                        outInfo.addDataType(str);
                                    } //End block
                                    catch (IntentFilter.MalformedMimeTypeException e)
                                    {
                                        outError[0] = e.toString();
                                        sa.recycle();
                                    } //End block
                                } //End block
                                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_scheme, 0);
                                {
                                    outInfo.addDataScheme(str);
                                } //End block
                                String host;
                                host = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_host, 0);
                                String port;
                                port = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_port, 0);
                                {
                                    outInfo.addDataAuthority(host, port);
                                } //End block
                                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_path, 0);
                                {
                                    outInfo.addDataPath(str, PatternMatcher.PATTERN_LITERAL);
                                } //End block
                                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_pathPrefix, 0);
                                {
                                    outInfo.addDataPath(str, PatternMatcher.PATTERN_PREFIX);
                                } //End block
                                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_pathPattern, 0);
                                {
                                    outInfo.addDataPath(str, PatternMatcher.PATTERN_SIMPLE_GLOB);
                                } //End block
                                sa.recycle();
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                outError[0] = "Bad element under <intent-filter>: " + parser.getName();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        outInfo.hasDefault = outInfo.hasCategory(Intent.CATEGORY_DEFAULT);
        {
            StringBuilder cats;
            cats = new StringBuilder("Intent d=");
            cats.append(outInfo.hasDefault);
            cats.append(", cat=");
            Iterator<String> it;
            it = outInfo.categoriesIterator();
            {
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_258180555 = (it.hasNext());
                    {
                        cats.append(' ');
                        cats.append(it.next());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            Slog.d(TAG, cats.toString());
        } //End block
        addTaint(res.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(flags);
        addTaint(outInfo.getTaint());
        addTaint(outError[0].getTaint());
        addTaint(isActivity);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527752664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527752664;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean copyNeeded(int flags, Package p, Bundle metaData) {
        if (p.mSetEnabled != PackageManager.COMPONENT_ENABLED_STATE_DEFAULT) {
            boolean enabled = p.mSetEnabled == PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
            if (p.applicationInfo.enabled != enabled) {
                return true;
            }
        }
        if ((flags & PackageManager.GET_META_DATA) != 0
                && (metaData != null || p.mAppMetaData != null)) {
            return true;
        }
        if ((flags & PackageManager.GET_SHARED_LIBRARY_FILES) != 0
                && p.usesLibraryFiles != null) {
            return true;
        }
        return false;
    }

    
        public static ApplicationInfo generateApplicationInfo(Package p, int flags) {
        if (p == null) return null;
        if (!copyNeeded(flags, p, null)) {
            if (!sCompatibilityModeEnabled) {
                p.applicationInfo.disableCompatibilityMode();
            }
            if (p.mSetStopped) {
                p.applicationInfo.flags |= ApplicationInfo.FLAG_STOPPED;
            } else {
                p.applicationInfo.flags &= ~ApplicationInfo.FLAG_STOPPED;
            }
            return p.applicationInfo;
        }
        ApplicationInfo ai = new ApplicationInfo(p.applicationInfo);
        if ((flags & PackageManager.GET_META_DATA) != 0) {
            ai.metaData = p.mAppMetaData;
        }
        if ((flags & PackageManager.GET_SHARED_LIBRARY_FILES) != 0) {
            ai.sharedLibraryFiles = p.usesLibraryFiles;
        }
        if (!sCompatibilityModeEnabled) {
            ai.disableCompatibilityMode();
        }
        if (p.mSetStopped) {
            p.applicationInfo.flags |= ApplicationInfo.FLAG_STOPPED;
        } else {
            p.applicationInfo.flags &= ~ApplicationInfo.FLAG_STOPPED;
        }
        if (p.mSetEnabled == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
            ai.enabled = true;
        } else if (p.mSetEnabled == PackageManager.COMPONENT_ENABLED_STATE_DISABLED
                || p.mSetEnabled == PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER) {
            ai.enabled = false;
        }
        ai.enabledSetting = p.mSetEnabled;
        return ai;
    }

    
        public static final PermissionInfo generatePermissionInfo(
            Permission p, int flags) {
        if (p == null) return null;
        if ((flags&PackageManager.GET_META_DATA) == 0) {
            return p.info;
        }
        PermissionInfo pi = new PermissionInfo(p.info);
        pi.metaData = p.metaData;
        return pi;
    }

    
        public static final PermissionGroupInfo generatePermissionGroupInfo(
            PermissionGroup pg, int flags) {
        if (pg == null) return null;
        if ((flags&PackageManager.GET_META_DATA) == 0) {
            return pg.info;
        }
        PermissionGroupInfo pgi = new PermissionGroupInfo(pg.info);
        pgi.metaData = pg.metaData;
        return pgi;
    }

    
        public static final ActivityInfo generateActivityInfo(Activity a,
            int flags) {
        if (a == null) return null;
        if (!copyNeeded(flags, a.owner, a.metaData)) {
            return a.info;
        }
        ActivityInfo ai = new ActivityInfo(a.info);
        ai.metaData = a.metaData;
        ai.applicationInfo = generateApplicationInfo(a.owner, flags);
        return ai;
    }

    
        public static final ServiceInfo generateServiceInfo(Service s, int flags) {
        if (s == null) return null;
        if (!copyNeeded(flags, s.owner, s.metaData)) {
            return s.info;
        }
        ServiceInfo si = new ServiceInfo(s.info);
        si.metaData = s.metaData;
        si.applicationInfo = generateApplicationInfo(s.owner, flags);
        return si;
    }

    
        public static final ProviderInfo generateProviderInfo(Provider p,
            int flags) {
        if (p == null) return null;
        if (!copyNeeded(flags, p.owner, p.metaData)
                && ((flags & PackageManager.GET_URI_PERMISSION_PATTERNS) != 0
                        || p.info.uriPermissionPatterns == null)) {
            return p.info;
        }
        ProviderInfo pi = new ProviderInfo(p.info);
        pi.metaData = p.metaData;
        if ((flags & PackageManager.GET_URI_PERMISSION_PATTERNS) == 0) {
            pi.uriPermissionPatterns = null;
        }
        pi.applicationInfo = generateApplicationInfo(p.owner, flags);
        return pi;
    }

    
        public static final InstrumentationInfo generateInstrumentationInfo(
            Instrumentation i, int flags) {
        if (i == null) return null;
        if ((flags&PackageManager.GET_META_DATA) == 0) {
            return i.info;
        }
        InstrumentationInfo ii = new InstrumentationInfo(i.info);
        ii.metaData = i.metaData;
        return ii;
    }

    
        public static void setCompatibilityModeEnabled(boolean compatibilityModeEnabled) {
        sCompatibilityModeEnabled = compatibilityModeEnabled;
    }

    
    public static class NewPermissionInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.048 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.048 -0400", hash_original_field = "A79022BDE85A3E1291F6F337747F3E2D", hash_generated_field = "BC6F74C41FF51DC8E932B8D548DFA77F")

        public int sdkVersion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.048 -0400", hash_original_field = "350A62B40A7F6336F2BC471A19CDE2C6", hash_generated_field = "110F458F9380E184018D0C29262B9616")

        public int fileVersion;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.049 -0400", hash_original_method = "2CD4C5E2A660B34C44D0A141A2AEA4A5", hash_generated_method = "F5F4FF09A35908459A08AD63049CA1FA")
        public  NewPermissionInfo(String name, int sdkVersion, int fileVersion) {
            this.name = name;
            this.sdkVersion = sdkVersion;
            this.fileVersion = fileVersion;
            // ---------- Original Method ----------
            //this.name = name;
            //this.sdkVersion = sdkVersion;
            //this.fileVersion = fileVersion;
        }

        
    }


    
    static class ParsePackageItemArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.050 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "63E7E49220BEC65CFB906D3D26FF5320")

        Package owner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.050 -0400", hash_original_field = "266BA65C37D1B10AC4F3EE7791B9B445", hash_generated_field = "291217E682224D693BB6F37B520F9B6C")

        String[] outError;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.050 -0400", hash_original_field = "261A7CEA666F15E06CB2A73C0E88BF46", hash_generated_field = "0B58898276367165952073A704F8E936")

        int nameRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.050 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "72766807210949DB14E0A53D32EEFA42")

        int labelRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.050 -0400", hash_original_field = "1AFA68AAD1FD9765C18E4975F512B2FD", hash_generated_field = "16A2D6444BA4128F5DED925DDCED14C3")

        int iconRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.063 -0400", hash_original_field = "CD3A164FB9162CB1BED1A6A6D503D919", hash_generated_field = "9076C14F4A6A5083F7B4331FB7F68DE2")

        int logoRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.064 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FFCA994A2F44B678330E924D8C87385D")

        String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.064 -0400", hash_original_field = "C12E01F2A13FF5587E1E9E4AEDB8242D", hash_generated_field = "F31D05FD6AB3B23194ACB45C1F7F8DB9")

        TypedArray sa;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.066 -0400", hash_original_method = "FEBED5B917290B280BC232B6F93C8DA6", hash_generated_method = "55548C9D938CBB68771CEA96F9BC74DD")
          ParsePackageItemArgs(Package _owner, String[] _outError,
                int _nameRes, int _labelRes, int _iconRes, int _logoRes) {
            owner = _owner;
            outError = _outError;
            nameRes = _nameRes;
            labelRes = _labelRes;
            iconRes = _iconRes;
            logoRes = _logoRes;
            // ---------- Original Method ----------
            //owner = _owner;
            //outError = _outError;
            //nameRes = _nameRes;
            //labelRes = _labelRes;
            //iconRes = _iconRes;
            //logoRes = _logoRes;
        }

        
    }


    
    static class ParseComponentArgs extends ParsePackageItemArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.067 -0400", hash_original_field = "1DE38A6C4DA32AC30AF07D8811642A87", hash_generated_field = "52628BA19847DEC6DD967DC512B6341E")

        String[] sepProcesses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.067 -0400", hash_original_field = "7D1048C7C2C5A6919C87079377EE65DA", hash_generated_field = "98EAE5992470306073D805F3DE4D2B98")

        int processRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.067 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "1C23F3ABB5154D4340D3FAF2DBF4B754")

        int descriptionRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.067 -0400", hash_original_field = "460E3C30A98BC2FD8F0331AB402C5AA2", hash_generated_field = "DBC8C6552821B500EDF219C9444E5014")

        int enabledRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.067 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

        int flags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.086 -0400", hash_original_method = "A5B17BCC2B409C42234E0A16A22942F4", hash_generated_method = "AE64BB6CAE187DBBC809A3F0E63B9CFE")
          ParseComponentArgs(Package _owner, String[] _outError,
                int _nameRes, int _labelRes, int _iconRes, int _logoRes,
                String[] _sepProcesses, int _processRes,
                int _descriptionRes, int _enabledRes) {
            super(_owner, _outError, _nameRes, _labelRes, _iconRes, _logoRes);
            sepProcesses = _sepProcesses;
            processRes = _processRes;
            descriptionRes = _descriptionRes;
            enabledRes = _enabledRes;
            addTaint(_owner.getTaint());
            addTaint(_outError[0].getTaint());
            addTaint(_nameRes);
            addTaint(_labelRes);
            addTaint(_iconRes);
            addTaint(_logoRes);
            // ---------- Original Method ----------
            //sepProcesses = _sepProcesses;
            //processRes = _processRes;
            //descriptionRes = _descriptionRes;
            //enabledRes = _enabledRes;
        }

        
    }


    
    public static class PackageLite {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.086 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.086 -0400", hash_original_field = "BEA549FC87D184BC2179F71B62DAB91F", hash_generated_field = "30578A504DDEAA8F4E71E08EEE4589B5")

        public int installLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.087 -0400", hash_original_field = "68D3768AD0645CE6E56B550E3ECEE8FD", hash_generated_field = "547B5BDAEDA540976776CD453D2E9834")

        public VerifierInfo[] verifiers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.110 -0400", hash_original_method = "7A496B905B539B1321EA9EDB02EF9EB7", hash_generated_method = "26B62457834513FCB559BD6BBE921F67")
        public  PackageLite(String packageName, int installLocation, List<VerifierInfo> verifiers) {
            this.packageName = packageName;
            this.installLocation = installLocation;
            this.verifiers = verifiers.toArray(new VerifierInfo[verifiers.size()]);
            // ---------- Original Method ----------
            //this.packageName = packageName;
            //this.installLocation = installLocation;
            //this.verifiers = verifiers.toArray(new VerifierInfo[verifiers.size()]);
        }

        
    }


    
    public final static class Package {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.117 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.117 -0400", hash_original_field = "69AB4388F5986AD3252147A346061D42", hash_generated_field = "F542184EF3E793E15F9CB85E916760D0")

        public ApplicationInfo applicationInfo = new ApplicationInfo();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.117 -0400", hash_original_field = "1232531D566254375A360E48EF41D648", hash_generated_field = "A3B5C957A26B6C474B4D92E340A988A7")

        public ArrayList<Permission> permissions = new ArrayList<Permission>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.117 -0400", hash_original_field = "AF9C9DB8F55B4E887D008C390EC683B9", hash_generated_field = "2A5BA7AF720F23062ED1A89F2F4C7B5D")

        public ArrayList<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.117 -0400", hash_original_field = "E168DD652573C5ADAB6897D04E579B5E", hash_generated_field = "D25E6161B95ACF14453DC25AF195F157")

        public ArrayList<Activity> activities = new ArrayList<Activity>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.117 -0400", hash_original_field = "A20C9FE9911B60F28CA43D678FD7B573", hash_generated_field = "81889FA0BA9353758C1C674D11474A27")

        public ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.117 -0400", hash_original_field = "CA3E9C0D88D726CB52B3450F7C6DE1AC", hash_generated_field = "6B4B0133DBD94B91EC34FEA60D181A82")

        public ArrayList<Provider> providers = new ArrayList<Provider>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.118 -0400", hash_original_field = "E57E587DC11FA870F65E4A50D948E88D", hash_generated_field = "6629291E7A3666E4DA6ACC9770B066DD")

        public ArrayList<Service> services = new ArrayList<Service>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.118 -0400", hash_original_field = "C8AA2D33F07DB1102094F07AD34B6C55", hash_generated_field = "DD1DD33A721BC78F91CAB6EE7E2F24DE")

        public ArrayList<Instrumentation> instrumentation = new ArrayList<Instrumentation>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.118 -0400", hash_original_field = "295D74C5EA62402E8079B176D6994C5F", hash_generated_field = "78017901B0F4508886795AE1AC5ACEBD")

        public ArrayList<String> requestedPermissions = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.118 -0400", hash_original_field = "D2F2E3902A1EEA274B17DCCFC5B21B56", hash_generated_field = "08EEF0A6E1D22D736BF2E545A29D8138")

        public ArrayList<String> protectedBroadcasts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.127 -0400", hash_original_field = "7BB75B5E891F374B093E25AB194C5D1D", hash_generated_field = "38B8DDE984ADCEFBD679BD148096C90B")

        public ArrayList<String> usesLibraries = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.127 -0400", hash_original_field = "AC38B32CCC9A99E87CDDACB2B4134529", hash_generated_field = "B4E5B43916326236F7AC60FB6AA30ED0")

        public ArrayList<String> usesOptionalLibraries = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.135 -0400", hash_original_field = "972D60BACDDB321FD5BF3141CE25C6EF", hash_generated_field = "E256E3F26B890CB645F141CE43A19B9C")

        public String[] usesLibraryFiles = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "D4AF4457503CFB20CEDA7DA3A415725B", hash_generated_field = "E6599044F06DEA0FBD755EB8BE240A8E")

        public ArrayList<String> mOriginalPackages = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "77DFC50314330BC0CE5D97BCF4142E67", hash_generated_field = "04EBB67E52CE8E75294355C009EB60C1")

        public String mRealPackage = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "5409226BD4ABABE6DFC5D019D88E0347", hash_generated_field = "AEFDC3F9A7F5911D385620280B7625C2")

        public ArrayList<String> mAdoptPermissions = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "7536359808A247F780211CEFB8BCB220", hash_generated_field = "07357F002FB731C049A7E8EF93488FAB")

        public Bundle mAppMetaData = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "305B7716861981204869144DBD3A202B")

        public String mPath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "4C41D55D7E893B47CB2EB7473840A4CE", hash_generated_field = "2D25A57F98AA26067BCE62362DE0AEEE")

        public int mVersionCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "5EC2E990478CB2C1E53C8720FE789C1D", hash_generated_field = "AD0666B617F8EB374F674D223A151BE8")

        public String mVersionName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.136 -0400", hash_original_field = "1CDFFD0994D8A9956EDE5093BA49B467", hash_generated_field = "1BA8548AD03E92E8907935F23C7EC7DC")

        public String mSharedUserId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.137 -0400", hash_original_field = "BD7476C55BF7FEC76EBEF2CF99D574DB", hash_generated_field = "E426A46C5F8600102F790613EDFE2FA5")

        public int mSharedUserLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.137 -0400", hash_original_field = "0863C94B433E3584B6DB08F8A2AED72E", hash_generated_field = "D0A761ADB8F3D08D19028AF26464A727")

        public Signature mSignatures[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.137 -0400", hash_original_field = "BEC3C63CC04DE0A4383218FE553B0E8A", hash_generated_field = "CA2013AD22FC45C00B31AC00F892C7F7")

        public int mPreferredOrder = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.137 -0400", hash_original_field = "118923A78B8874C01208738CD281B567", hash_generated_field = "33A1C46140465710909573B6E270AD39")

        public String mScanPath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.137 -0400", hash_original_field = "32F5D530A8DA97268EB9B2890B2C7131", hash_generated_field = "7D697318734FF4FCAC89EE6F12A79BBA")

        public boolean mDidDexOpt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.137 -0400", hash_original_field = "F7F25A0F75E8398BAB75854C31581A1B", hash_generated_field = "01E3EC227D5D4747BBF3C8E007B87A8C")

        public int mSetEnabled = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.137 -0400", hash_original_field = "254DE6C78B0F26849EEAF7B6D672C5CD", hash_generated_field = "F2AF2DCB7F1AF550D0120E8A8EC3076A")

        public boolean mSetStopped = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.138 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "31FF094E094B19A5172EF65F93099B80")

        public Object mExtras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.146 -0400", hash_original_field = "CB5C8D73EAA190766AF047FE4800181D", hash_generated_field = "006EB022C9A35AC652457AFB4C61156A")

        public boolean mOperationPending;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.147 -0400", hash_original_field = "D5CDEEF499FD2D936E2F6D7D1848D4CE", hash_generated_field = "CF76E9D5B2332F3D3A80DD5FF4EFB7DD")

        public ArrayList<ConfigurationInfo> configPreferences = new ArrayList<ConfigurationInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.147 -0400", hash_original_field = "48A101D55DB93F225A77D458DEA9C170", hash_generated_field = "56739470CD23739123AD6639F0ED5CDC")

        public ArrayList<FeatureInfo> reqFeatures = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.147 -0400", hash_original_field = "BEA549FC87D184BC2179F71B62DAB91F", hash_generated_field = "30578A504DDEAA8F4E71E08EEE4589B5")

        public int installLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.147 -0400", hash_original_field = "A679F1BF343DC0C0C50467BD18C8E320", hash_generated_field = "7CE719961EFE13A323B2F3853261CD27")

        public ManifestDigest manifestDigest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.156 -0400", hash_original_method = "8954AF7805FA48686FD1C5CD1B4EC95C", hash_generated_method = "7D4DBC5FA92B3E51FD3593495D906C93")
        public  Package(String _name) {
            packageName = _name;
            applicationInfo.packageName = _name;
            applicationInfo.uid = -1;
            // ---------- Original Method ----------
            //packageName = _name;
            //applicationInfo.packageName = _name;
            //applicationInfo.uid = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.188 -0400", hash_original_method = "B05A09470669E629F210442116CDFAC5", hash_generated_method = "34784A8A70D9E3C90E785722B4E8D09D")
        public void setPackageName(String newName) {
            packageName = newName;
            applicationInfo.packageName = newName;
            {
                int i;
                i = permissions.size()-1;
                {
                    permissions.get(i).setPackageName(newName);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = permissionGroups.size()-1;
                {
                    permissionGroups.get(i).setPackageName(newName);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = activities.size()-1;
                {
                    activities.get(i).setPackageName(newName);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = receivers.size()-1;
                {
                    receivers.get(i).setPackageName(newName);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = providers.size()-1;
                {
                    providers.get(i).setPackageName(newName);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = services.size()-1;
                {
                    services.get(i).setPackageName(newName);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = instrumentation.size()-1;
                {
                    instrumentation.get(i).setPackageName(newName);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.189 -0400", hash_original_method = "7DFEBE5DF638D8804915FD110C0E2540", hash_generated_method = "81194FEC65CE8FC0858698A776FB5804")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_466622219 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_466622219 = "Package{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + packageName + "}";
            varB4EAC82CA7396A68D541C85D26508E83_466622219.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_466622219;
            // ---------- Original Method ----------
            //return "Package{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + packageName + "}";
        }

        
    }


    
    public static class Component<II extends IntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.190 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "B7B17A6D136295F4EF656A6C2B786D1E")

        public Package owner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.190 -0400", hash_original_field = "99F399B171645B449364ED937DFD6F10", hash_generated_field = "D8DEE06C2E494DBB6667E43B6FBC365D")

        public ArrayList<II> intents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.190 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "868D31C10A710A0DF272DC0EA267B5A9")

        public String className;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.190 -0400", hash_original_field = "F39B17E1DA2AF1CD34AAE99B867A1C61", hash_generated_field = "94B83340D21CBE8DE8F4A432223AA875")

        public Bundle metaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.190 -0400", hash_original_field = "FE439837C9D0340925B5F19E11F6264D", hash_generated_field = "E3D849549355C126FFF6430112CFAA0A")

        ComponentName componentName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.203 -0400", hash_original_field = "077960F927379A99EEEF4099F19C70A6", hash_generated_field = "A35E7838F783416409F7A19252F30415")

        String componentShortName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.204 -0400", hash_original_method = "B544BED1308F0633C32173E605BDF8E5", hash_generated_method = "D740BCDFFC25F96008F5E3E0E4F9606C")
        public  Component(Package _owner) {
            owner = _owner;
            intents = null;
            className = null;
            // ---------- Original Method ----------
            //owner = _owner;
            //intents = null;
            //className = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.255 -0400", hash_original_method = "A43E20CDE8CCB4A62D1450265CBDCEF5", hash_generated_method = "B9715F28254D52C1413E176FD0A839B7")
        public  Component(final ParsePackageItemArgs args, final PackageItemInfo outInfo) {
            owner = args.owner;
            intents = new ArrayList<II>(0);
            String name;
            name = args.sa.getNonConfigurationString(args.nameRes, 0);
            {
                className = null;
                args.outError[0] = args.tag + " does not specify android:name";
            } //End block
            outInfo.name
                = buildClassName(owner.applicationInfo.packageName, name, args.outError);
            {
                className = null;
                args.outError[0] = args.tag + " does not have valid android:name";
            } //End block
            className = outInfo.name;
            int iconVal;
            iconVal = args.sa.getResourceId(args.iconRes, 0);
            {
                outInfo.icon = iconVal;
                outInfo.nonLocalizedLabel = null;
            } //End block
            int logoVal;
            logoVal = args.sa.getResourceId(args.logoRes, 0);
            {
                outInfo.logo = logoVal;
            } //End block
            TypedValue v;
            v = args.sa.peekValue(args.labelRes);
            {
                boolean varB057AD3DC46BBD8375817931442BCC5C_977301836 = (v != null && (outInfo.labelRes=v.resourceId) == 0);
                {
                    outInfo.nonLocalizedLabel = v.coerceToString();
                } //End block
            } //End collapsed parenthetic
            outInfo.packageName = owner.packageName;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.265 -0400", hash_original_method = "D9B47963B1B8ABE0F2CDFAC0BBD1CAD2", hash_generated_method = "009B3EA3C834FCBF4A464CB774E73636")
        public  Component(final ParseComponentArgs args, final ComponentInfo outInfo) {
            this(args, (PackageItemInfo)outInfo);
            {
                CharSequence pname;
                {
                    pname = args.sa.getNonConfigurationString(args.processRes, 0);
                } //End block
                {
                    pname = args.sa.getNonResourceString(args.processRes);
                } //End block
                outInfo.processName = buildProcessName(owner.applicationInfo.packageName,
                        owner.applicationInfo.processName, pname,
                        args.flags, args.sepProcesses, args.outError);
            } //End block
            {
                outInfo.descriptionRes = args.sa.getResourceId(args.descriptionRes, 0);
            } //End block
            outInfo.enabled = args.sa.getBoolean(args.enabledRes, true);
            addTaint(args.getTaint());
            addTaint(outInfo.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.296 -0400", hash_original_method = "7A30742503E7124B050658D7B849B524", hash_generated_method = "E4D8C37F23A69E539A009A28BE32977E")
        public  Component(Component<II> clone) {
            owner = clone.owner;
            intents = clone.intents;
            className = clone.className;
            componentName = clone.componentName;
            componentShortName = clone.componentShortName;
            // ---------- Original Method ----------
            //owner = clone.owner;
            //intents = clone.intents;
            //className = clone.className;
            //componentName = clone.componentName;
            //componentShortName = clone.componentShortName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.299 -0400", hash_original_method = "BF1ED0A6C0ACE1EE7610EB0D74F5C800", hash_generated_method = "137E46FDEA474D31B53BFD11FB26DD29")
        public ComponentName getComponentName() {
            ComponentName varB4EAC82CA7396A68D541C85D26508E83_106544002 = null; //Variable for return #1
            ComponentName varB4EAC82CA7396A68D541C85D26508E83_299650999 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_106544002 = componentName;
            } //End block
            {
                componentName = new ComponentName(owner.applicationInfo.packageName,
                        className);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_299650999 = componentName;
            ComponentName varA7E53CE21691AB073D9660D615818899_1130558561; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1130558561 = varB4EAC82CA7396A68D541C85D26508E83_106544002;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1130558561 = varB4EAC82CA7396A68D541C85D26508E83_299650999;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1130558561.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1130558561;
            // ---------- Original Method ----------
            //if (componentName != null) {
                //return componentName;
            //}
            //if (className != null) {
                //componentName = new ComponentName(owner.applicationInfo.packageName,
                        //className);
            //}
            //return componentName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.306 -0400", hash_original_method = "3A4D7499A9518F3ABB20BEBAE6816B9D", hash_generated_method = "43BB86830CFF312241E866A037A479F3")
        public String getComponentShortName() {
            String varB4EAC82CA7396A68D541C85D26508E83_382014941 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_573402218 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_382014941 = componentShortName;
            } //End block
            ComponentName component;
            component = getComponentName();
            {
                componentShortName = component.flattenToShortString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_573402218 = componentShortName;
            String varA7E53CE21691AB073D9660D615818899_646742127; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_646742127 = varB4EAC82CA7396A68D541C85D26508E83_382014941;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_646742127 = varB4EAC82CA7396A68D541C85D26508E83_573402218;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_646742127.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_646742127;
            // ---------- Original Method ----------
            //if (componentShortName != null) {
                //return componentShortName;
            //}
            //ComponentName component = getComponentName();
            //if (component != null) {
                //componentShortName = component.flattenToShortString();
            //}
            //return componentShortName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.324 -0400", hash_original_method = "AFFE8B7215C15E45738BCB365FA520F8", hash_generated_method = "3F64AB8F1AD7923F2CDDDC8010C0F739")
        public void setPackageName(String packageName) {
            componentName = null;
            componentShortName = null;
            addTaint(packageName.getTaint());
            // ---------- Original Method ----------
            //componentName = null;
            //componentShortName = null;
        }

        
    }


    
    public final static class Permission extends Component<IntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.324 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "44FAE9A36D6EBA187A54E941C96BA855")

        public PermissionInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.324 -0400", hash_original_field = "C0AF77CF8294FF93A5CDB2963CA9F038", hash_generated_field = "EF09DBC8B27A53D0E48DDC50B1CFE266")

        public boolean tree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.324 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "81FA9670466619AF97D2F0A37093F67B")

        public PermissionGroup group;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.337 -0400", hash_original_method = "28D7021527B7BC8061929232C0A668B9", hash_generated_method = "404D10937E8F9066272A61792717DCEF")
        public  Permission(Package _owner) {
            super(_owner);
            info = new PermissionInfo();
            addTaint(_owner.getTaint());
            // ---------- Original Method ----------
            //info = new PermissionInfo();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.338 -0400", hash_original_method = "37E156160FC75CB3C9E2BA72594B754D", hash_generated_method = "84CA1DE560DDB83AE65BE025A522E57C")
        public  Permission(Package _owner, PermissionInfo _info) {
            super(_owner);
            info = _info;
            addTaint(_owner.getTaint());
            // ---------- Original Method ----------
            //info = _info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.339 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.340 -0400", hash_original_method = "D70298090C91BEA7F3B1C7F9C9416449", hash_generated_method = "FA2329BAF57BE1B6E072C3DC53B74DD0")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_595543667 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_595543667 = "Permission{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_595543667.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_595543667;
            // ---------- Original Method ----------
            //return "Permission{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + info.name + "}";
        }

        
    }


    
    public final static class PermissionGroup extends Component<IntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.341 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "4AEC0127E51446670A8F6715545F2FFD")

        public PermissionGroupInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.341 -0400", hash_original_method = "19A5AAAA7728282CABC960AB069F9E98", hash_generated_method = "C72C854306855CE166AEE1662F919A84")
        public  PermissionGroup(Package _owner) {
            super(_owner);
            info = new PermissionGroupInfo();
            addTaint(_owner.getTaint());
            // ---------- Original Method ----------
            //info = new PermissionGroupInfo();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.361 -0400", hash_original_method = "8FB9374E9D85DC0253F34BC909070B56", hash_generated_method = "EF4B68D8D27982A0EBB6BFA78B9944DC")
        public  PermissionGroup(Package _owner, PermissionGroupInfo _info) {
            super(_owner);
            info = _info;
            addTaint(_owner.getTaint());
            // ---------- Original Method ----------
            //info = _info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.363 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.378 -0400", hash_original_method = "5B6E9035FB2F0E9673597108CCAFFCEF", hash_generated_method = "864220B9D855D0195F6E5222D5F55B32")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_50446397 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_50446397 = "PermissionGroup{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_50446397.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_50446397;
            // ---------- Original Method ----------
            //return "PermissionGroup{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + info.name + "}";
        }

        
    }


    
    public final static class Activity extends Component<ActivityIntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.378 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "31C563E0B9BB4DA4F801727DD7960E99")

        public ActivityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.379 -0400", hash_original_method = "2916F6991906FCE3DAEE226AB756275F", hash_generated_method = "C5644F879FB9CA9E6C46626AFFCC6523")
        public  Activity(final ParseComponentArgs args, final ActivityInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
            // ---------- Original Method ----------
            //info = _info;
            //info.applicationInfo = args.owner.applicationInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.380 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.381 -0400", hash_original_method = "3ED5BAD5E29B5F8C3FFE202D917D91C6", hash_generated_method = "BBD0B569F9395CA65325B5AB526ACC5D")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_83809973 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_83809973 = "Activity{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
            varB4EAC82CA7396A68D541C85D26508E83_83809973.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_83809973;
            // ---------- Original Method ----------
            //return "Activity{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + getComponentShortName() + "}";
        }

        
    }


    
    public final static class Service extends Component<ServiceIntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.399 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "44442782625E786E51B742A3D7D5DE80")

        public ServiceInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.401 -0400", hash_original_method = "2742F060EFDB78FDF4E4BA2659F1DC82", hash_generated_method = "E6E889FECE4BAD756F1CCD77DCFEFAE8")
        public  Service(final ParseComponentArgs args, final ServiceInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
            // ---------- Original Method ----------
            //info = _info;
            //info.applicationInfo = args.owner.applicationInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.432 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.434 -0400", hash_original_method = "983F0C4312E41963E910123205C22323", hash_generated_method = "099BFE1DB1852FBF023D02E716AA9FDE")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2141061795 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2141061795 = "Service{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
            varB4EAC82CA7396A68D541C85D26508E83_2141061795.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2141061795;
            // ---------- Original Method ----------
            //return "Service{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + getComponentShortName() + "}";
        }

        
    }


    
    public final static class Provider extends Component {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.434 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "BF776B364C73D31E6B3B31185D6DF955")

        public ProviderInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.434 -0400", hash_original_field = "BB5ED03A2B1CAD35E912B9A1FBB4B102", hash_generated_field = "8DCC80DE4F5A821BFB32172415658FEA")

        public boolean syncable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.450 -0400", hash_original_method = "EAE8B6AC135EBC96C8D24D047B180DE5", hash_generated_method = "343B3653CFEC536617399565A9DBD70E")
        public  Provider(final ParseComponentArgs args, final ProviderInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
            syncable = false;
            // ---------- Original Method ----------
            //info = _info;
            //info.applicationInfo = args.owner.applicationInfo;
            //syncable = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.451 -0400", hash_original_method = "7DA675634165C06E74013727D919E49C", hash_generated_method = "150CC3EFD195162CC132E1D5F85237A7")
        public  Provider(Provider existingProvider) {
            super(existingProvider);
            this.info = existingProvider.info;
            this.syncable = existingProvider.syncable;
            // ---------- Original Method ----------
            //this.info = existingProvider.info;
            //this.syncable = existingProvider.syncable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.472 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.473 -0400", hash_original_method = "68549008F1EBCA6BA1DE59DAB2FE7E3C", hash_generated_method = "3D31709A9A0A4F0B32057D3D63C8C22E")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1073156721 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1073156721 = "Provider{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1073156721.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1073156721;
            // ---------- Original Method ----------
            //return "Provider{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + info.name + "}";
        }

        
    }


    
    public final static class Instrumentation extends Component {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.473 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "9E4A99D8D40782E1B858164167767C21")

        public InstrumentationInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.474 -0400", hash_original_method = "CAE763D5DCD2DC693DEEA83AE92F98C5", hash_generated_method = "334B79EAF08AE8130544D04BECC6B165")
        public  Instrumentation(final ParsePackageItemArgs args, final InstrumentationInfo _info) {
            super(args, _info);
            info = _info;
            addTaint(args.getTaint());
            // ---------- Original Method ----------
            //info = _info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.475 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.494 -0400", hash_original_method = "CB405027A6A70334D830F0B5C698645E", hash_generated_method = "57F19E58EA93A87E9F6808CC84B9D1F7")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1658023122 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1658023122 = "Instrumentation{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1658023122.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1658023122;
            // ---------- Original Method ----------
            //return "Instrumentation{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + getComponentShortName() + "}";
        }

        
    }


    
    public static class IntentInfo extends IntentFilter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.514 -0400", hash_original_field = "4A519AFAA26CDED890B9053870E60EE0", hash_generated_field = "27741E2F90129BA4D13424CA3120F0CA")

        public boolean hasDefault;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.514 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

        public int labelRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.515 -0400", hash_original_field = "C217EC6D87004328FDE9713C8BDFACF1", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

        public CharSequence nonLocalizedLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.515 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.515 -0400", hash_original_field = "96D6F2E7E1F705AB5E59C84A6DC009B2", hash_generated_field = "922885A8A44FD4A4B2D8F0B49A2EDED6")

        public int logo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.515 -0400", hash_original_method = "351B7321F95DEA4A1F6C5D218D4A2DB8", hash_generated_method = "351B7321F95DEA4A1F6C5D218D4A2DB8")
        public IntentInfo ()
        {
            //Synthesized constructor
        }


    }


    
    public final static class ActivityIntentInfo extends IntentInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.516 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "8EB481EDAD2FDE318A05890E655F5C10")

        public Activity activity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.517 -0400", hash_original_method = "4F41670063BD951D72DDB0235971893F", hash_generated_method = "0462B156AB73AD83F3A7439B178E9A79")
        public  ActivityIntentInfo(Activity _activity) {
            activity = _activity;
            // ---------- Original Method ----------
            //activity = _activity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.520 -0400", hash_original_method = "7C91146E1C4D7077E2D0C55B0D43BF57", hash_generated_method = "33B141FE3682EBB9DED324D57A2A24FD")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_999311700 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_999311700 = "ActivityIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + activity.info.name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_999311700.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_999311700;
            // ---------- Original Method ----------
            //return "ActivityIntentInfo{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + activity.info.name + "}";
        }

        
    }


    
    public final static class ServiceIntentInfo extends IntentInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.521 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "6630E432AFBDE1086EB9C8736D3C1E75")

        public Service service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.530 -0400", hash_original_method = "2C256432D4530E0F15F4AED85D9A44A0", hash_generated_method = "61FE60C3F8E05F8F2F3135BC3B31D794")
        public  ServiceIntentInfo(Service _service) {
            service = _service;
            // ---------- Original Method ----------
            //service = _service;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.531 -0400", hash_original_method = "32EA4E8A8FC07DAD01188F341ACB2C51", hash_generated_method = "886C6B67EE3CFDCDCBCDD4CC59D8E6B2")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_269176219 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_269176219 = "ServiceIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + service.info.name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_269176219.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_269176219;
            // ---------- Original Method ----------
            //return "ServiceIntentInfo{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + service.info.name + "}";
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.531 -0400", hash_original_field = "DF32A01F1FE4B2A11EE5A767A1DCD552", hash_generated_field = "2E085EE0958A5322F72B34A56EF9BF5D")

    private static boolean DEBUG_JAR = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.532 -0400", hash_original_field = "2C3E9FD0BD054C424AC0B88DD61CF722", hash_generated_field = "59B797B4FD6C1EB60C74B783BA71A706")

    private static boolean DEBUG_PARSER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.532 -0400", hash_original_field = "913A503348F076CE40FF70939F52E21D", hash_generated_field = "A45EE584C55F0F4473CCE822BD40D676")

    private static boolean DEBUG_BACKUP = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.532 -0400", hash_original_field = "67E7CF7E198C33B841936D6E63E6EDE6", hash_generated_field = "07EEBD3555436C8548B77611193A540A")

    private static String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.532 -0400", hash_original_field = "DAF8613F9A421919597993B9BB9712C9", hash_generated_field = "4E7CCA62AA0883D7BED63D0B9D564192")

    public static final PackageParser.NewPermissionInfo NEW_PERMISSIONS[] =
        new PackageParser.NewPermissionInfo[] {
            new PackageParser.NewPermissionInfo(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.os.Build.VERSION_CODES.DONUT, 0),
            new PackageParser.NewPermissionInfo(android.Manifest.permission.READ_PHONE_STATE,
                    android.os.Build.VERSION_CODES.DONUT, 0)
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.532 -0400", hash_original_field = "6D5D7CA40886C0578E6E1B6029816C0A", hash_generated_field = "10C49EEA7E41716329145A63264B13E2")

    private static int SDK_VERSION = Build.VERSION.SDK_INT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.532 -0400", hash_original_field = "6DAB7D8ACE498068F8FC2A32149CE97B", hash_generated_field = "6307C2F156F076C36FAEB457B4390DF5")

    private static String SDK_CODENAME = "REL".equals(Build.VERSION.CODENAME)
            ? null : Build.VERSION.CODENAME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.532 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "970570067DE920513CAE0F2F1EADAB71")

    private static Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.540 -0400", hash_original_field = "270CD8B630C808D6EB383BF510F99004", hash_generated_field = "C91A03D8C0281FD6FE8F7562B14775C4")

    private static WeakReference<byte[]> mReadBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.541 -0400", hash_original_field = "CBEF5DB12FFFB461F3C4D3FC457C23AE", hash_generated_field = "23A0E0B3C74959CD54FEA5BC7440ADA6")

    private static boolean sCompatibilityModeEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.541 -0400", hash_original_field = "0B016151FBE3216EBBE16B193D5653DA", hash_generated_field = "35C72DA0305A12DF06B89CC7622BAF57")

    private static int PARSE_DEFAULT_INSTALL_LOCATION = PackageInfo.INSTALL_LOCATION_UNSPECIFIED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.541 -0400", hash_original_field = "6F33513A583DE10D0C82FE4E1558B70F", hash_generated_field = "8411B8A9B6E09730F7B00164AAA8809D")

    private static boolean RIGID_PARSER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.541 -0400", hash_original_field = "B6B26328D0AF58045609750A8B7ADC87", hash_generated_field = "CFF5DD7B37950F19345F49BC4E87B046")

    private static String TAG = "PackageParser";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.542 -0400", hash_original_field = "68F6206F996CB412F857963D11B7A32D", hash_generated_field = "4B52CDD8E5ADCA354868822A64689A48")

    public final static int PARSE_IS_SYSTEM = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.542 -0400", hash_original_field = "A79C5A5D953DF9B12E4BDE6E62BEC1FF", hash_generated_field = "D16481D6B9C894AA8F9AD72D6FF3BE41")

    public final static int PARSE_CHATTY = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.542 -0400", hash_original_field = "EDFF4D39F335C2167F0E9CC96620C90B", hash_generated_field = "D85F2CA29F944D705DACCE7CFE1CCC41")

    public final static int PARSE_MUST_BE_APK = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.542 -0400", hash_original_field = "552E0FAF6FF6F37C9E44411963C4429C", hash_generated_field = "28588A534392FDDD099636AF774A3125")

    public final static int PARSE_IGNORE_PROCESSES = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.542 -0400", hash_original_field = "326B35AE4CA29ADCD45422E9FB0C9C13", hash_generated_field = "55AEA484B033A779430356E4D8F71309")

    public final static int PARSE_FORWARD_LOCK = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.542 -0400", hash_original_field = "F474095F0973F733CAF1E2E7B4FF3A07", hash_generated_field = "E1C3B202E87D4E3614B1E66CD70ED663")

    public final static int PARSE_ON_SDCARD = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.542 -0400", hash_original_field = "F5E0411EB76EA9B316F7FECD7812427B", hash_generated_field = "3D41C84BD91D95AD71586AAACE412C36")

    public final static int PARSE_IS_SYSTEM_DIR = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.543 -0400", hash_original_field = "7A09AF7826D2C4F40EE97D33D975F54E", hash_generated_field = "B0F798145879C1393D1D292CD1B05328")

    private static String ANDROID_RESOURCES = "http://schemas.android.com/apk/res/android";
}

