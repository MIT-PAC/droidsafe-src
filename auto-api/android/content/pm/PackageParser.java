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
    private String mArchiveSourcePath;
    private String[] mSeparateProcesses;
    private boolean mOnlyCoreApps;
    private int mParseError = PackageManager.INSTALL_SUCCEEDED;
    private ParsePackageItemArgs mParseInstrumentationArgs;
    private ParseComponentArgs mParseActivityArgs;
    private ParseComponentArgs mParseActivityAliasArgs;
    private ParseComponentArgs mParseServiceArgs;
    private ParseComponentArgs mParseProviderArgs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.541 -0400", hash_original_method = "DDBED2CCEF7CE747A37B4CF69A21D51E", hash_generated_method = "0CBC87CF4408CFC295598332880C1045")
    @DSModeled(DSC.SAFE)
    public PackageParser(String archiveSourcePath) {
        dsTaint.addTaint(archiveSourcePath);
        // ---------- Original Method ----------
        //mArchiveSourcePath = archiveSourcePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.541 -0400", hash_original_method = "65A62D9388B66A4D9595CDAEE2873A09", hash_generated_method = "B1752D90BD3A93D7E266E974E615CF62")
    @DSModeled(DSC.SAFE)
    public void setSeparateProcesses(String[] procs) {
        dsTaint.addTaint(procs[0]);
        // ---------- Original Method ----------
        //mSeparateProcesses = procs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.541 -0400", hash_original_method = "14C9699FDDD05F8B9AF1818DB0942037", hash_generated_method = "1DEAB66112084481C34B0EA998D79E09")
    @DSModeled(DSC.SAFE)
    public void setOnlyCoreApps(boolean onlyCoreApps) {
        dsTaint.addTaint(onlyCoreApps);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.542 -0400", hash_original_method = "83F32E741E7740326FB3ACF1CABD2263", hash_generated_method = "249C3938B0C08713AA39F1B959C14DC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Certificate[] loadCertificates(JarFile jarFile, JarEntry je,
            byte[] readBuffer) {
        dsTaint.addTaint(jarFile.dsTaint);
        dsTaint.addTaint(je.dsTaint);
        dsTaint.addTaint(readBuffer[0]);
        try 
        {
            InputStream is;
            is = new BufferedInputStream(jarFile.getInputStream(je));
            {
                boolean var7C3826F57E2B97B3B91292A259636CBB_1352769763 = (is.read(readBuffer, 0, readBuffer.length) != -1);
            } //End collapsed parenthetic
            is.close();
            {
                Object var6BB68DA2E7E49D70F5A33DE63081DBF1_1987380323 = (je.getCertificates());
            } //End flattened ternary
        } //End block
        catch (IOException e)
        { }
        catch (RuntimeException e)
        { }
        return (Certificate[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.543 -0400", hash_original_method = "043AC7F11A9C5FD11FB43AEF955AD87D", hash_generated_method = "39B4EF1F25E92F2C85592CA7A05470B3")
    @DSModeled(DSC.SAFE)
    public int getParseError() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mParseError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.553 -0400", hash_original_method = "F8C0CFF9FE003FD5724E792D5942913B", hash_generated_method = "DE83E362C60D97BCEF770189E615D7CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Package parsePackage(File sourceFile, String destCodePath,
            DisplayMetrics metrics, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(sourceFile.dsTaint);
        dsTaint.addTaint(metrics.dsTaint);
        dsTaint.addTaint(destCodePath);
        mParseError = PackageManager.INSTALL_SUCCEEDED;
        mArchiveSourcePath = sourceFile.getPath();
        {
            boolean var2116955FB837CE636F98A7918949A04E_721558140 = (!sourceFile.isFile());
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE987AF766FA74B3AD459FB1E585029DA_1082810055 = (!isPackageFilename(sourceFile.getName())
                && (flags&PARSE_MUST_BE_APK) != 0);
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
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
        } //End block
        parser.close();
        assmgr.close();
        pkg.mPath = destCodePath;
        pkg.mScanPath = mArchiveSourcePath;
        pkg.mSignatures = null;
        return (Package)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.557 -0400", hash_original_method = "19D0E628AA10FC207BA0D548739FDEDB", hash_generated_method = "25F18F43ED50EF8A6B5EBC5DB704C4A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean collectCertificates(Package pkg, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(pkg.dsTaint);
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
                    boolean var66E70F3459E5CCB8614D20E01A26E86F_1703567552 = (entries.hasMoreElements());
                    {
                        JarEntry je;
                        je = entries.nextElement();
                        {
                            boolean var65B8E195C8AA7059C67BF79286782095_2078711748 = (je.isDirectory());
                        } //End collapsed parenthetic
                        String name;
                        name = je.getName();
                        {
                            boolean var12A901F777A40C9D283732267E266735_514530602 = (name.startsWith("META-INF/"));
                        } //End collapsed parenthetic
                        {
                            boolean varD99F64D135246231C00791AFEBF1DD6F_1717143271 = (ANDROID_MANIFEST_FILENAME.equals(name));
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
                                                boolean var22FC5E2CA793FEEACF89DAB3AB42E666_972891893 = (certs[i] != null &&
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.583 -0400", hash_original_method = "91CC6CEE84025557458760F97B90CD2F", hash_generated_method = "55F2C24F0588A716F661683E125D565F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Package parsePackage(
        Resources res, XmlResourceParser parser, int flags, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
        } //End block
        int type;
        {
            boolean core;
            core = attrs.getAttributeBooleanValue(null, "coreApp", false);
            {
                mParseError = PackageManager.INSTALL_SUCCEEDED;
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
            boolean var848F079761698AAA15DA481349AE4E2C_637602563 = (str != null && str.length() > 0);
            {
                String nameError;
                nameError = validateName(str, true);
                {
                    boolean var3584BEC91545D68DD465FD5F522C42C6_966724320 = (nameError != null && !"android".equals(pkgName));
                    {
                        outError[0] = "<manifest> specifies bad sharedUserId name \""
                    + str + "\": " + nameError;
                        mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID;
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
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_1137750446 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String tagName;
                tagName = parser.getName();
                {
                    boolean varF8EAF590C1B64C9ECDBBED748B7E5C90_1081551811 = (tagName.equals("application"));
                    {
                        {
                            {
                                outError[0] = "<manifest> has more than one <application>";
                                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                            } //End block
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                        } //End block
                        foundApp = true;
                        {
                            boolean var3F08D3B967070ABA06096CA5595722C6_421350047 = (!parseApplication(pkg, res, parser, attrs, flags, outError));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var88F37FCC2212880098EC750FD7FA678E_186676679 = (tagName.equals("permission-group"));
                        {
                            {
                                boolean varA3A061F96EC4ABDE7DF00644D4DC4F07_1141647720 = (parsePermissionGroup(pkg, res, parser, attrs, outError) == null);
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varA9E2A3737C0FBDF0991489F6DD343AFF_456260599 = (tagName.equals("permission"));
                            {
                                {
                                    boolean var031D0486BD05B9C0D2042849F5F3141A_1047489815 = (parsePermission(pkg, res, parser, attrs, outError) == null);
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var836521A07EF0241F200539CA3EAEBB53_336273742 = (tagName.equals("permission-tree"));
                                {
                                    {
                                        boolean var80E4FF566B617B00A711B29F5C1E1757_59157804 = (parsePermissionTree(pkg, res, parser, attrs, outError) == null);
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varA169552B3D4E050C516F6D3C5EF2DCCF_182203025 = (tagName.equals("uses-permission"));
                                    {
                                        sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesPermission);
                                        String name;
                                        name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesPermission_name);
                                        sa.recycle();
                                        {
                                            boolean var082B823035F8549A56F9D48448C4F285_1776227923 = (name != null && !pkg.requestedPermissions.contains(name));
                                            {
                                                pkg.requestedPermissions.add(name.intern());
                                            } //End block
                                        } //End collapsed parenthetic
                                        XmlUtils.skipCurrentTag(parser);
                                    } //End block
                                    {
                                        boolean varA84278BF88B46415D3BE370CFBFD451C_723781278 = (tagName.equals("uses-configuration"));
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
                                                boolean var924E4F92F1FFCDA9F61F59577D850520_338821870 = (sa.getBoolean(
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
                                                boolean var8CB04F871EC31574AA19A06D968517C9_1829902300 = (sa.getBoolean(
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
                                            boolean varF2200A6E80C65CE9764A5AB44448B694_220028131 = (tagName.equals("uses-feature"));
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
                                                    boolean varD9C467CCB2BCF1D250FD1CF0D09CC347_1836489736 = (sa.getBoolean(
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
                                                boolean varFD3F13DA5EFB9E6C614B2570E348634E_1171863569 = (tagName.equals("uses-sdk"));
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
                                                                boolean var6D10D58F2AC3EADED3903025E0345117_1982756296 = (!minCode.equals(SDK_CODENAME));
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
                                                                } //End block
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                        {
                                                            outError[0] = "Requires newer sdk version #" + minVers
                                + " (current version is #" + SDK_VERSION + ")";
                                                            mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
                                                        } //End block
                                                        {
                                                            {
                                                                boolean varEB85D163C2686178E9072A154F2B1017_824479696 = (!targetCode.equals(SDK_CODENAME));
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
                                                    boolean var2AD21980A6F7F6AA6C25A37BEDBD96B9_198070273 = (tagName.equals("supports-screens"));
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
                                                        boolean varF9A9EABB9F0DF8DD018A4B0AD7880A8B_1163336309 = (tagName.equals("protected-broadcast"));
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
                                                                    boolean varB4E798A338C4A451F12E37DD5381CB93_45224410 = (!pkg.protectedBroadcasts.contains(name));
                                                                    {
                                                                        pkg.protectedBroadcasts.add(name.intern());
                                                                    } //End block
                                                                } //End collapsed parenthetic
                                                            } //End block
                                                            XmlUtils.skipCurrentTag(parser);
                                                        } //End block
                                                        {
                                                            boolean var5291B256BFE37755CFF9CE20B217D3AC_2005669454 = (tagName.equals("instrumentation"));
                                                            {
                                                                {
                                                                    boolean var3222D9132D95E509061C76EA54FCD97A_1423338968 = (parseInstrumentation(pkg, res, parser, attrs, outError) == null);
                                                                } //End collapsed parenthetic
                                                            } //End block
                                                            {
                                                                boolean varDB43EE5FBAE0090DBC136B39A4F7A029_1140015139 = (tagName.equals("original-package"));
                                                                {
                                                                    sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage);
                                                                    String orig;
                                                                    orig = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage_name, 0);
                                                                    {
                                                                        boolean varC5BA37D72C0CA59EA36C3742F7338E76_1768694873 = (!pkg.packageName.equals(orig));
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
                                                                    boolean var6865D9016C481EF68D6684F63BF7A11C_2074265801 = (tagName.equals("adopt-permissions"));
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
                                                                        boolean var46DB0BC9C1C1FE67FF2F47E40DD7773E_771405970 = (tagName.equals("uses-gl-texture"));
                                                                        {
                                                                            XmlUtils.skipCurrentTag(parser);
                                                                        } //End block
                                                                        {
                                                                            boolean var66D0A46FD130C7E340121E79ACF5C0AA_1405622069 = (tagName.equals("compatible-screens"));
                                                                            {
                                                                                XmlUtils.skipCurrentTag(parser);
                                                                            } //End block
                                                                            {
                                                                                boolean varF501100954D0EBDDED0D103F0C602535_209959698 = (tagName.equals("eat-comment"));
                                                                                {
                                                                                    XmlUtils.skipCurrentTag(parser);
                                                                                } //End block
                                                                                {
                                                                                    outError[0] = "Bad element under <manifest>: "
                    + parser.getName();
                                                                                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
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
            boolean var656CE6E53C04C7019D91D9C819F1B4B5_1749835177 = (!foundApp && pkg.instrumentation.size() == 0);
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
                    boolean var992143486215F1959F9E138F82FD3565_1073554417 = (!pkg.requestedPermissions.contains(npi.name));
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
        return (Package)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.591 -0400", hash_original_method = "E3395575DA3BE4CF83D20AFB0193668F", hash_generated_method = "EBF1A9E3B0A4EBAF2CE66DC6B53E0D3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PermissionGroup parsePermissionGroup(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
        PermissionGroup perm;
        perm = new PermissionGroup(owner);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup);
        {
            boolean var9E2AF09338E745C2FAF713E73B46A2FD_1331544648 = (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-group>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_name,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_label,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_logo));
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            } //End block
        } //End collapsed parenthetic
        perm.info.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_description,
                0);
        sa.recycle();
        {
            boolean var72A93BDEF638BC31E81E8D057EEDC5F2_1816554323 = (!parseAllMetaData(res, parser, attrs, "<permission-group>", perm,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            } //End block
        } //End collapsed parenthetic
        owner.permissionGroups.add(perm);
        return (PermissionGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.592 -0400", hash_original_method = "1D11570A32C6A271E593822206F9BD54", hash_generated_method = "6DFC6BFA2C601D39D096E0C1AEB89B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Permission parsePermission(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
        Permission perm;
        perm = new Permission(owner);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermission);
        {
            boolean var0DD909B519CC387E5C9EA83C899B39D0_1843343967 = (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission>", sa,
                com.android.internal.R.styleable.AndroidManifestPermission_name,
                com.android.internal.R.styleable.AndroidManifestPermission_label,
                com.android.internal.R.styleable.AndroidManifestPermission_icon,
                com.android.internal.R.styleable.AndroidManifestPermission_logo));
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
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
        } //End block
        {
            boolean var2A0B3F43EBF50AFBE5CFD9DAED89DDE6_682206008 = (!parseAllMetaData(res, parser, attrs, "<permission>", perm,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            } //End block
        } //End collapsed parenthetic
        owner.permissions.add(perm);
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.593 -0400", hash_original_method = "BAA3C6F5A9B5CEE097497C276EDD624D", hash_generated_method = "C856DE4DE1636A38275131D97014D001")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Permission parsePermissionTree(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
        Permission perm;
        perm = new Permission(owner);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionTree);
        {
            boolean varD42E96DB3FE92B943E062DCA246DD395_890447208 = (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-tree>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_name,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_label,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_logo));
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
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
        } //End block
        perm.info.descriptionRes = 0;
        perm.info.protectionLevel = PermissionInfo.PROTECTION_NORMAL;
        perm.tree = true;
        {
            boolean var6929934279609305F522DA245D911766_1909720150 = (!parseAllMetaData(res, parser, attrs, "<permission-tree>", perm,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            } //End block
        } //End collapsed parenthetic
        owner.permissions.add(perm);
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.594 -0400", hash_original_method = "77B98478A5AAF7EC4E5B725BE9FDC9E7", hash_generated_method = "14A3E04CCEAD8D441CA041A3A3757015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Instrumentation parseInstrumentation(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
        } //End block
        {
            boolean var8EF4E0F1A82EA6AFCA94A4D8598E7664_543158231 = (!parseAllMetaData(res, parser, attrs, "<instrumentation>", a,
                outError));
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            } //End block
        } //End collapsed parenthetic
        owner.instrumentation.add(a);
        return (Instrumentation)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.597 -0400", hash_original_method = "3784AF975EC3AF37D03EE1A91A900A73", hash_generated_method = "6BF362B0DAD0182C3248B51D42520437")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean parseApplication(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
                    boolean var3781D282DB322A26549149946193414D_1377496452 = (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_killAfterRestore,
                        true));
                    {
                        ai.flags |= ApplicationInfo.FLAG_KILL_AFTER_RESTORE;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEEF38F5B7F8DA558BCCE1D69A87ED5BD_2032554127 = (sa.getBoolean(
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
            boolean var9092B245FCF833ED50175702D269F387_810367703 = (v != null && (ai.labelRes=v.resourceId) == 0);
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
                boolean var87812553007A723CD6A5FC98D1BDC5B2_1985294509 = (sa.getBoolean(
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
            boolean varA8E17EE0B66711E9FDEA3E8ACA2BFBEA_156936646 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_debuggable,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_DEBUGGABLE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCD872D55821622672581E8A3AE831EB4_1718473019 = (sa.getBoolean(
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
            boolean var251C511CB0A0C29B4D5934FED89A22F9_365240299 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_hasCode,
                true));
            {
                ai.flags |= ApplicationInfo.FLAG_HAS_CODE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD15BA2820092392C9A70DEA1022BD860_994074908 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowTaskReparenting,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var64DB4E16C417947EC00DA3B28C61802C_1510793364 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowClearUserData,
                true));
            {
                ai.flags |= ApplicationInfo.FLAG_ALLOW_CLEAR_USER_DATA;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1583D122D9A058ED6BE19A3237333EA0_991755792 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_testOnly,
                false));
            {
                ai.flags |= ApplicationInfo.FLAG_TEST_ONLY;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4AFC6550135025488E8A90F0D243D683_480006123 = (sa.getBoolean(
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
                    boolean varEBA33D9E3C6F99BD9035DB8C8CBC9431_86759121 = (sa.getBoolean(
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
            boolean varC66FE93CD4CE831A2BA43B64A992D597_1135152768 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth));
            {
                String tagName;
                tagName = parser.getName();
                {
                    boolean varCEA39CC7DD315AF5DD9CF498474F6A04_1297335182 = (tagName.equals("activity"));
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
                        boolean varBFC5A7632401121A805E0B8C8BD62B81_1825965710 = (tagName.equals("receiver"));
                        {
                            Activity a;
                            a = parseActivity(owner, res, parser, attrs, flags, outError, true, false);
                            {
                                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                            } //End block
                            owner.receivers.add(a);
                        } //End block
                        {
                            boolean var21E9802D4101B46F2076E1671DBB2E7E_2053291641 = (tagName.equals("service"));
                            {
                                Service s;
                                s = parseService(owner, res, parser, attrs, flags, outError);
                                {
                                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                } //End block
                                owner.services.add(s);
                            } //End block
                            {
                                boolean varEFE1204453EBD024E72F8F8FEA9421C6_877844717 = (tagName.equals("provider"));
                                {
                                    Provider p;
                                    p = parseProvider(owner, res, parser, attrs, flags, outError);
                                    {
                                        mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                    } //End block
                                    owner.providers.add(p);
                                } //End block
                                {
                                    boolean var5A497C595CAF1DB300BAE058439CF8DB_2091772397 = (tagName.equals("activity-alias"));
                                    {
                                        Activity a;
                                        a = parseActivityAlias(owner, res, parser, attrs, flags, outError);
                                        {
                                            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                        } //End block
                                        owner.activities.add(a);
                                    } //End block
                                    {
                                        boolean var91AADB0FFDCA4B3CD7737D6304F15B05_304410242 = (parser.getName().equals("meta-data"));
                                        {
                                            {
                                                boolean varB1F8175B799EE9DC06601F6EE00285D6_367177421 = ((owner.mAppMetaData = parseMetaData(res, parser, attrs, owner.mAppMetaData,
                        outError)) == null);
                                                {
                                                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var31400F483E6E601672F212C83EBEF810_1251758054 = (tagName.equals("uses-library"));
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
                                                            boolean var6A1106BAA5BD5B3974BACBAD9BF1AAFE_1220541523 = (!owner.usesLibraries.contains(lname));
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
                                                            boolean var2EF7D28E9E6284E9A73DE8FDBB80D772_1441699975 = (!owner.usesOptionalLibraries.contains(lname));
                                                            {
                                                                owner.usesOptionalLibraries.add(lname.intern());
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                } //End block
                                                XmlUtils.skipCurrentTag(parser);
                                            } //End block
                                            {
                                                boolean varCD7EAA3A97E9E0F8C954B188A8E0E51A_999807429 = (tagName.equals("uses-package"));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.598 -0400", hash_original_method = "63CFF58BE3C03EE3AAF09BEB17B3529D", hash_generated_method = "770AB07B03C19329D483F8C559487C18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean parsePackageItemInfo(Package owner, PackageItemInfo outInfo,
            String[] outError, String tag, TypedArray sa,
            int nameRes, int labelRes, int iconRes, int logoRes) {
        dsTaint.addTaint(labelRes);
        dsTaint.addTaint(logoRes);
        dsTaint.addTaint(nameRes);
        dsTaint.addTaint(outInfo.dsTaint);
        dsTaint.addTaint(sa.dsTaint);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(iconRes);
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
            boolean var91D75606D26FF6CB57581960C4C28D7F_841685174 = (v != null && (outInfo.labelRes=v.resourceId) == 0);
            {
                outInfo.nonLocalizedLabel = v.coerceToString();
            } //End block
        } //End collapsed parenthetic
        outInfo.packageName = owner.packageName;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.600 -0400", hash_original_method = "5541C23C630FF3AC70030479982C4C1F", hash_generated_method = "6F11BC4769EB9B4C0338E2ED34FED679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Activity parseActivity(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError,
            boolean receiver, boolean hardwareAccelerated) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(receiver);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(hardwareAccelerated);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
            boolean varB5936475D75C10D27B26C2B758CCBE38_1434418586 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_multiprocess,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_MULTIPROCESS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBB9A814CD2F977B8CFFDF8586685D888_1068449594 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnTaskLaunch,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_FINISH_ON_TASK_LAUNCH;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7214B1B3D1A30323865BB90BD536D99D_836809492 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_clearTaskOnLaunch,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_CLEAR_TASK_ON_LAUNCH;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var525C5644769ECBECA90106BBD7CCA891_49284793 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_noHistory,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_NO_HISTORY;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var535A315BC7455B82982DBDF6ABB43639_1108524835 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_alwaysRetainTaskState,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_ALWAYS_RETAIN_TASK_STATE;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var310848EB8D34ABFD2902FA9D1E21F30A_164648072 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_stateNotNeeded,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_STATE_NOT_NEEDED;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCB2D249AFE74887A225B4B48E465BA00_241438094 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_excludeFromRecents,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_EXCLUDE_FROM_RECENTS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3E6FBC876B6E16D44BA233F203FA6701_163151675 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_allowTaskReparenting,
                (owner.applicationInfo.flags&ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING) != 0));
            {
                a.info.flags |= ActivityInfo.FLAG_ALLOW_TASK_REPARENTING;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varACE1D7FED9CA8DF00B89E18D2CE99755_159512339 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnCloseSystemDialogs,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBF9E0FF7BB8F35A6FAA707C99AAECC66_1943516468 = (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_immersive,
                false));
            {
                a.info.flags |= ActivityInfo.FLAG_IMMERSIVE;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var27FB7917CF2CF95A3EBC55BEC12A3B99_842529034 = (sa.getBoolean(
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
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_2112132660 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var558A80433485A0A91069570FE0753ABC_167382761 = (parser.getName().equals("intent-filter"));
                    {
                        ActivityIntentInfo intent;
                        intent = new ActivityIntentInfo(a);
                        {
                            boolean varFEEAE359197455E997D8AE11C5F84F28_835504765 = (!parseIntent(res, parser, attrs, flags, intent, outError, !receiver));
                        } //End collapsed parenthetic
                        {
                            boolean var33C0360B5D0DAC6FE381109188142C53_898698512 = (intent.countActions() == 0);
                            {
                                a.intents.add(intent);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var19E08DB77AFC65B1C7EB49759BAD99AF_479898269 = (parser.getName().equals("meta-data"));
                        {
                            {
                                boolean var0FC654D04193EA7E4A5364F21B1F8D9E_1222008952 = ((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null);
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
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            a.info.exported = a.intents.size() > 0;
        } //End block
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.603 -0400", hash_original_method = "2C553740AE22C20570EEFC51EEC11A38", hash_generated_method = "DBF6F7E46B2A3850B1E323DB294B8AFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Activity parseActivityAlias(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestActivityAlias);
        String targetActivity;
        targetActivity = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_targetActivity, 0);
        {
            outError[0] = "<activity-alias> does not specify android:targetActivity";
            sa.recycle();
        } //End block
        targetActivity = buildClassName(owner.applicationInfo.packageName,
                targetActivity, outError);
        {
            sa.recycle();
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
                    boolean varCA2334A46342BD5024FA8928036F4FB7_1292608875 = (targetActivity.equals(t.info.name));
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
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1813651532 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var558A80433485A0A91069570FE0753ABC_844954373 = (parser.getName().equals("intent-filter"));
                    {
                        ActivityIntentInfo intent;
                        intent = new ActivityIntentInfo(a);
                        {
                            boolean varBDA471758B32D3069E5A9AA8CF08294F_1596114020 = (!parseIntent(res, parser, attrs, flags, intent, outError, true));
                        } //End collapsed parenthetic
                        {
                            boolean var33C0360B5D0DAC6FE381109188142C53_908592910 = (intent.countActions() == 0);
                            {
                                a.intents.add(intent);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var19E08DB77AFC65B1C7EB49759BAD99AF_1979721490 = (parser.getName().equals("meta-data"));
                        {
                            {
                                boolean var0FC654D04193EA7E4A5364F21B1F8D9E_1469422284 = ((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null);
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                outError[0] = "Bad element under <activity-alias>: " + parser.getName();
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            a.info.exported = a.intents.size() > 0;
        } //End block
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.604 -0400", hash_original_method = "CC761DF5515ACB2817B0A6BEDC12031E", hash_generated_method = "EF42A012BD7220C12842F3C8F492E366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Provider parseProvider(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
            } //End block
        } //End block
        {
            outError[0] = "<provider> does not incude authorities attribute";
        } //End block
        p.info.authority = cpname.intern();
        {
            boolean var4FDB5E1EC3E9C441BD9FB9F3A9CEE2E9_289650864 = (!parseProviderTags(res, parser, attrs, p, outError));
        } //End collapsed parenthetic
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.606 -0400", hash_original_method = "05A16AA66DEB0B6B5120CEC23FE33532", hash_generated_method = "CB31B62A43FDB1ADBA4C2316836D39DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean parseProviderTags(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Provider outInfo, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(outInfo.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_2102973179 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var679A61A305D6D9AF7A442CDA01AE2C28_2068745041 = (parser.getName().equals("meta-data"));
                    {
                        {
                            boolean var989A6F06E5BD6363C928806CC7D69345_1302256330 = ((outInfo.metaData=parseMetaData(res, parser, attrs,
                        outInfo.metaData, outError)) == null);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varF06E7B1138273C400578FF82FA2DB071_2004486998 = (parser.getName().equals("grant-uri-permission"));
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
                            boolean var6F38308E8F6BF3E7F05F9A7A5771E51E_2096304350 = (parser.getName().equals("path-permission"));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.609 -0400", hash_original_method = "1B6E257916FE773842F0B213D728DC29", hash_generated_method = "2AD46A331245678D6E57720E276A16A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Service parseService(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(owner.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
            boolean var48D9F4C063A4D64D9CBE4D757774C4E4_2042675032 = (sa.getBoolean(
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
            } //End block
        } //End block
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_648380748 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var558A80433485A0A91069570FE0753ABC_1632775922 = (parser.getName().equals("intent-filter"));
                    {
                        ServiceIntentInfo intent;
                        intent = new ServiceIntentInfo(s);
                        {
                            boolean var8E3CB1B64FDFADDC5A768494AEBFAFDC_1840220723 = (!parseIntent(res, parser, attrs, flags, intent, outError, false));
                        } //End collapsed parenthetic
                        s.intents.add(intent);
                    } //End block
                    {
                        boolean var19E08DB77AFC65B1C7EB49759BAD99AF_597206383 = (parser.getName().equals("meta-data"));
                        {
                            {
                                boolean var2E64325FDEBB3D259469D65D24853448_222061764 = ((s.metaData=parseMetaData(res, parser, attrs, s.metaData,
                        outError)) == null);
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                XmlUtils.skipCurrentTag(parser);
                            } //End block
                            {
                                outError[0] = "Bad element under <service>: " + parser.getName();
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            s.info.exported = s.intents.size() > 0;
        } //End block
        return (Service)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.610 -0400", hash_original_method = "99FE3F7E654A8DB168806DBE6C913C62", hash_generated_method = "82BBBD2A7A1CAD53750EE9F0EF7A4C52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean parseAllMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs, String tag,
            Component outInfo, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(outInfo.dsTaint);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
        int outerDepth;
        outerDepth = parser.getDepth();
        int type;
        {
            boolean var003C1B2273232C3B7B27A28F0A982195_1668503648 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth));
            {
                {
                    boolean var679A61A305D6D9AF7A442CDA01AE2C28_362706087 = (parser.getName().equals("meta-data"));
                    {
                        {
                            boolean var989A6F06E5BD6363C928806CC7D69345_596839055 = ((outInfo.metaData=parseMetaData(res, parser, attrs,
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.611 -0400", hash_original_method = "714C7ED1FC52C32A41D3A8C089BB2BEC", hash_generated_method = "33FA278D9A90937F6A62885F6285E51A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Bundle parseMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Bundle data, String[] outError) throws XmlPullParserException, IOException {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
        return (Bundle)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.614 -0400", hash_original_method = "B28F171FD6C00B48F648DC5DCFE3EFC1", hash_generated_method = "7DDEAB8F5FB7F27D33FED3C0712CDEE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean parseIntent(Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags,
            IntentInfo outInfo, String[] outError, boolean isActivity) throws XmlPullParserException, IOException {
        dsTaint.addTaint(isActivity);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(outInfo.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(outError[0]);
        dsTaint.addTaint(parser.dsTaint);
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
            boolean var91D75606D26FF6CB57581960C4C28D7F_879068057 = (v != null && (outInfo.labelRes=v.resourceId) == 0);
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
            boolean var09B6D7ADFBD75C31FC39E543D494D2B2_1828933937 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String nodeName;
                nodeName = parser.getName();
                {
                    boolean varACA9F240F9ACEB0B60DCF0209B3C5B8B_1120709710 = (nodeName.equals("action"));
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
                        boolean var355168E41EBBD793F28449F985564D32_626580384 = (nodeName.equals("category"));
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
                            boolean var623CB09FAE2071E98D47E3836399E32F_316039771 = (nodeName.equals("data"));
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
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1148985726 = (it.hasNext());
                    {
                        cats.append(' ');
                        cats.append(it.next());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            Slog.d(TAG, cats.toString());
        } //End block
        return dsTaint.getTaintBoolean();
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
        public String name;
        public int sdkVersion;
        public int fileVersion;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.619 -0400", hash_original_method = "2CD4C5E2A660B34C44D0A141A2AEA4A5", hash_generated_method = "C878EEDCE08ADE5B6BA6A4DC0B88AE23")
        @DSModeled(DSC.SAFE)
        public NewPermissionInfo(String name, int sdkVersion, int fileVersion) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(fileVersion);
            dsTaint.addTaint(sdkVersion);
            // ---------- Original Method ----------
            //this.name = name;
            //this.sdkVersion = sdkVersion;
            //this.fileVersion = fileVersion;
        }

        
    }


    
    static class ParsePackageItemArgs {
        Package owner;
        String[] outError;
        int nameRes;
        int labelRes;
        int iconRes;
        int logoRes;
        String tag;
        TypedArray sa;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.619 -0400", hash_original_method = "FEBED5B917290B280BC232B6F93C8DA6", hash_generated_method = "7C91F5E21B7B71F203D1E853F017AF8C")
        @DSModeled(DSC.SAFE)
         ParsePackageItemArgs(Package _owner, String[] _outError,
                int _nameRes, int _labelRes, int _iconRes, int _logoRes) {
            dsTaint.addTaint(_logoRes);
            dsTaint.addTaint(_outError[0]);
            dsTaint.addTaint(_labelRes);
            dsTaint.addTaint(_owner.dsTaint);
            dsTaint.addTaint(_iconRes);
            dsTaint.addTaint(_nameRes);
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
        String[] sepProcesses;
        int processRes;
        int descriptionRes;
        int enabledRes;
        int flags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.620 -0400", hash_original_method = "A5B17BCC2B409C42234E0A16A22942F4", hash_generated_method = "8ECC133CBB99527D44038BF5AD63396E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ParseComponentArgs(Package _owner, String[] _outError,
                int _nameRes, int _labelRes, int _iconRes, int _logoRes,
                String[] _sepProcesses, int _processRes,
                int _descriptionRes, int _enabledRes) {
            super(_owner, _outError, _nameRes, _labelRes, _iconRes, _logoRes);
            dsTaint.addTaint(_logoRes);
            dsTaint.addTaint(_outError[0]);
            dsTaint.addTaint(_processRes);
            dsTaint.addTaint(_labelRes);
            dsTaint.addTaint(_owner.dsTaint);
            dsTaint.addTaint(_descriptionRes);
            dsTaint.addTaint(_sepProcesses[0]);
            dsTaint.addTaint(_iconRes);
            dsTaint.addTaint(_nameRes);
            dsTaint.addTaint(_enabledRes);
            // ---------- Original Method ----------
            //sepProcesses = _sepProcesses;
            //processRes = _processRes;
            //descriptionRes = _descriptionRes;
            //enabledRes = _enabledRes;
        }

        
    }


    
    public static class PackageLite {
        public String packageName;
        public int installLocation;
        public VerifierInfo[] verifiers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.622 -0400", hash_original_method = "7A496B905B539B1321EA9EDB02EF9EB7", hash_generated_method = "F7EB7D7428D7092CA2DA93AF7B4611F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PackageLite(String packageName, int installLocation, List<VerifierInfo> verifiers) {
            dsTaint.addTaint(verifiers.dsTaint);
            dsTaint.addTaint(packageName);
            dsTaint.addTaint(installLocation);
            this.verifiers = verifiers.toArray(new VerifierInfo[verifiers.size()]);
            // ---------- Original Method ----------
            //this.packageName = packageName;
            //this.installLocation = installLocation;
            //this.verifiers = verifiers.toArray(new VerifierInfo[verifiers.size()]);
        }

        
    }


    
    public final static class Package {
        public String packageName;
        public ApplicationInfo applicationInfo = new ApplicationInfo();
        public ArrayList<Permission> permissions = new ArrayList<Permission>(0);
        public ArrayList<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>(0);
        public ArrayList<Activity> activities = new ArrayList<Activity>(0);
        public ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        public ArrayList<Provider> providers = new ArrayList<Provider>(0);
        public ArrayList<Service> services = new ArrayList<Service>(0);
        public ArrayList<Instrumentation> instrumentation = new ArrayList<Instrumentation>(0);
        public ArrayList<String> requestedPermissions = new ArrayList<String>();
        public ArrayList<String> protectedBroadcasts;
        public ArrayList<String> usesLibraries = null;
        public ArrayList<String> usesOptionalLibraries = null;
        public String[] usesLibraryFiles = null;
        public ArrayList<String> mOriginalPackages = null;
        public String mRealPackage = null;
        public ArrayList<String> mAdoptPermissions = null;
        public Bundle mAppMetaData = null;
        public String mPath;
        public int mVersionCode;
        public String mVersionName;
        public String mSharedUserId;
        public int mSharedUserLabel;
        public Signature mSignatures[];
        public int mPreferredOrder = 0;
        public String mScanPath;
        public boolean mDidDexOpt;
        public int mSetEnabled = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
        public boolean mSetStopped = false;
        public Object mExtras;
        public boolean mOperationPending;
        public ArrayList<ConfigurationInfo> configPreferences =
                new ArrayList<ConfigurationInfo>();
        public ArrayList<FeatureInfo> reqFeatures = null;
        public int installLocation;
        public ManifestDigest manifestDigest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.623 -0400", hash_original_method = "8954AF7805FA48686FD1C5CD1B4EC95C", hash_generated_method = "8B56417E3FC0B872BBD54C08FDDBF414")
        @DSModeled(DSC.SAFE)
        public Package(String _name) {
            dsTaint.addTaint(_name);
            applicationInfo.packageName = _name;
            applicationInfo.uid = -1;
            // ---------- Original Method ----------
            //packageName = _name;
            //applicationInfo.packageName = _name;
            //applicationInfo.uid = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.624 -0400", hash_original_method = "B05A09470669E629F210442116CDFAC5", hash_generated_method = "87805D49E0786076CC04566F26FEE7A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setPackageName(String newName) {
            dsTaint.addTaint(newName);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.624 -0400", hash_original_method = "7DFEBE5DF638D8804915FD110C0E2540", hash_generated_method = "0F60C1EFCADC60E1FB112FDB1399A7BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var5B70A7E9887B96D429AF0D75A7870466_2071379056 = ("Package{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + packageName + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Package{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + packageName + "}";
        }

        
    }


    
    public static class Component<II extends IntentInfo> {
        public Package owner;
        public ArrayList<II> intents;
        public String className;
        public Bundle metaData;
        ComponentName componentName;
        String componentShortName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.625 -0400", hash_original_method = "B544BED1308F0633C32173E605BDF8E5", hash_generated_method = "8DC974C9CDAD361BB20C65206ECD7A27")
        @DSModeled(DSC.SAFE)
        public Component(Package _owner) {
            dsTaint.addTaint(_owner.dsTaint);
            intents = null;
            className = null;
            // ---------- Original Method ----------
            //owner = _owner;
            //intents = null;
            //className = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.625 -0400", hash_original_method = "A43E20CDE8CCB4A62D1450265CBDCEF5", hash_generated_method = "16DCC55D70FC0A0589B5F6E321DE4C6D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Component(final ParsePackageItemArgs args, final PackageItemInfo outInfo) {
            dsTaint.addTaint(outInfo.dsTaint);
            dsTaint.addTaint(args.dsTaint);
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
                boolean varB057AD3DC46BBD8375817931442BCC5C_737448008 = (v != null && (outInfo.labelRes=v.resourceId) == 0);
                {
                    outInfo.nonLocalizedLabel = v.coerceToString();
                } //End block
            } //End collapsed parenthetic
            outInfo.packageName = owner.packageName;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.626 -0400", hash_original_method = "D9B47963B1B8ABE0F2CDFAC0BBD1CAD2", hash_generated_method = "62C36FFC60F912351E74F8AA69902848")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Component(final ParseComponentArgs args, final ComponentInfo outInfo) {
            this(args, (PackageItemInfo)outInfo);
            dsTaint.addTaint(outInfo.dsTaint);
            dsTaint.addTaint(args.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.626 -0400", hash_original_method = "7A30742503E7124B050658D7B849B524", hash_generated_method = "8E14C92D24B1E732575DF12F59F932B1")
        @DSModeled(DSC.SAFE)
        public Component(Component<II> clone) {
            dsTaint.addTaint(clone.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.627 -0400", hash_original_method = "BF1ED0A6C0ACE1EE7610EB0D74F5C800", hash_generated_method = "11469AC1F3E4F277C15E484DBD4F2810")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ComponentName getComponentName() {
            {
                componentName = new ComponentName(owner.applicationInfo.packageName,
                        className);
            } //End block
            return (ComponentName)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.627 -0400", hash_original_method = "3A4D7499A9518F3ABB20BEBAE6816B9D", hash_generated_method = "A22371EF137C1BAA4F8655BAD7447877")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getComponentShortName() {
            ComponentName component;
            component = getComponentName();
            {
                componentShortName = component.flattenToShortString();
            } //End block
            return dsTaint.getTaintString();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.627 -0400", hash_original_method = "AFFE8B7215C15E45738BCB365FA520F8", hash_generated_method = "3E2AE52BB6A6096C1F0B779E26D8D70C")
        @DSModeled(DSC.SAFE)
        public void setPackageName(String packageName) {
            dsTaint.addTaint(packageName);
            componentName = null;
            componentShortName = null;
            // ---------- Original Method ----------
            //componentName = null;
            //componentShortName = null;
        }

        
    }


    
    public final static class Permission extends Component<IntentInfo> {
        public PermissionInfo info;
        public boolean tree;
        public PermissionGroup group;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.628 -0400", hash_original_method = "28D7021527B7BC8061929232C0A668B9", hash_generated_method = "FFF80EA563EC639ADC3E3795484941E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Permission(Package _owner) {
            super(_owner);
            dsTaint.addTaint(_owner.dsTaint);
            info = new PermissionInfo();
            // ---------- Original Method ----------
            //info = new PermissionInfo();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.635 -0400", hash_original_method = "37E156160FC75CB3C9E2BA72594B754D", hash_generated_method = "DF9D109C6D69FED0DC6EF98C2EAE9E51")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Permission(Package _owner, PermissionInfo _info) {
            super(_owner);
            dsTaint.addTaint(_owner.dsTaint);
            dsTaint.addTaint(_info.dsTaint);
            // ---------- Original Method ----------
            //info = _info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.636 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "8F0F4F5ADCE8D25D600938A5997F78DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setPackageName(String packageName) {
            dsTaint.addTaint(packageName);
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.639 -0400", hash_original_method = "D70298090C91BEA7F3B1C7F9C9416449", hash_generated_method = "A4E69DCC411CE95377234BDA79AF65B6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var51314677E5DAF755F1B3CC81EB4B59A0_1166962466 = ("Permission{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Permission{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + info.name + "}";
        }

        
    }


    
    public final static class PermissionGroup extends Component<IntentInfo> {
        public PermissionGroupInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.642 -0400", hash_original_method = "19A5AAAA7728282CABC960AB069F9E98", hash_generated_method = "657898C77692AACC46CE9E0D47CAC414")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PermissionGroup(Package _owner) {
            super(_owner);
            dsTaint.addTaint(_owner.dsTaint);
            info = new PermissionGroupInfo();
            // ---------- Original Method ----------
            //info = new PermissionGroupInfo();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.642 -0400", hash_original_method = "8FB9374E9D85DC0253F34BC909070B56", hash_generated_method = "7465E75420211148C1E256F96D312A17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PermissionGroup(Package _owner, PermissionGroupInfo _info) {
            super(_owner);
            dsTaint.addTaint(_owner.dsTaint);
            dsTaint.addTaint(_info.dsTaint);
            // ---------- Original Method ----------
            //info = _info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.643 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "8F0F4F5ADCE8D25D600938A5997F78DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setPackageName(String packageName) {
            dsTaint.addTaint(packageName);
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.643 -0400", hash_original_method = "5B6E9035FB2F0E9673597108CCAFFCEF", hash_generated_method = "D2CE2C77FBCC07CAAF3B6E2FD001B1F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var7D0459AFEE7792A7E4FB6D95BD5F0944_1744739486 = ("PermissionGroup{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "PermissionGroup{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + info.name + "}";
        }

        
    }


    
    public final static class Activity extends Component<ActivityIntentInfo> {
        public ActivityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.644 -0400", hash_original_method = "2916F6991906FCE3DAEE226AB756275F", hash_generated_method = "466EC8BE0026C35AD0EA243B19BD343D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Activity(final ParseComponentArgs args, final ActivityInfo _info) {
            super(args, _info);
            dsTaint.addTaint(args.dsTaint);
            dsTaint.addTaint(_info.dsTaint);
            info.applicationInfo = args.owner.applicationInfo;
            // ---------- Original Method ----------
            //info = _info;
            //info.applicationInfo = args.owner.applicationInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.644 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "8F0F4F5ADCE8D25D600938A5997F78DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setPackageName(String packageName) {
            dsTaint.addTaint(packageName);
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.645 -0400", hash_original_method = "3ED5BAD5E29B5F8C3FFE202D917D91C6", hash_generated_method = "F447FEC16C7777CC9CB29C45A945AA76")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String varA74CFA3283A934B3D6B3961D28743C56_1505965709 = ("Activity{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Activity{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + getComponentShortName() + "}";
        }

        
    }


    
    public final static class Service extends Component<ServiceIntentInfo> {
        public ServiceInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.646 -0400", hash_original_method = "2742F060EFDB78FDF4E4BA2659F1DC82", hash_generated_method = "2E17787CA3AE653F0D5B86B2CAE03487")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Service(final ParseComponentArgs args, final ServiceInfo _info) {
            super(args, _info);
            dsTaint.addTaint(args.dsTaint);
            dsTaint.addTaint(_info.dsTaint);
            info.applicationInfo = args.owner.applicationInfo;
            // ---------- Original Method ----------
            //info = _info;
            //info.applicationInfo = args.owner.applicationInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.648 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "8F0F4F5ADCE8D25D600938A5997F78DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setPackageName(String packageName) {
            dsTaint.addTaint(packageName);
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.649 -0400", hash_original_method = "983F0C4312E41963E910123205C22323", hash_generated_method = "891DCA42BAEA5B39E035E52601E1A646")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var68EB16208D512127E004074616F3ED20_1173958751 = ("Service{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Service{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + getComponentShortName() + "}";
        }

        
    }


    
    public final static class Provider extends Component {
        public ProviderInfo info;
        public boolean syncable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.649 -0400", hash_original_method = "EAE8B6AC135EBC96C8D24D047B180DE5", hash_generated_method = "45A6FCF9AF40B1681F4333BC485AA981")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Provider(final ParseComponentArgs args, final ProviderInfo _info) {
            super(args, _info);
            dsTaint.addTaint(args.dsTaint);
            dsTaint.addTaint(_info.dsTaint);
            info.applicationInfo = args.owner.applicationInfo;
            syncable = false;
            // ---------- Original Method ----------
            //info = _info;
            //info.applicationInfo = args.owner.applicationInfo;
            //syncable = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.650 -0400", hash_original_method = "7DA675634165C06E74013727D919E49C", hash_generated_method = "CDCD3A287603F085DBA97CAE21F9387E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Provider(Provider existingProvider) {
            super(existingProvider);
            dsTaint.addTaint(existingProvider.dsTaint);
            this.info = existingProvider.info;
            this.syncable = existingProvider.syncable;
            // ---------- Original Method ----------
            //this.info = existingProvider.info;
            //this.syncable = existingProvider.syncable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.650 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "8F0F4F5ADCE8D25D600938A5997F78DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setPackageName(String packageName) {
            dsTaint.addTaint(packageName);
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.650 -0400", hash_original_method = "68549008F1EBCA6BA1DE59DAB2FE7E3C", hash_generated_method = "F58680E360936C08FA25AEC1B111158F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String varE81DAC60D36DC8A4C3EF2002ACAAB266_1696606312 = ("Provider{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Provider{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + info.name + "}";
        }

        
    }


    
    public final static class Instrumentation extends Component {
        public InstrumentationInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.651 -0400", hash_original_method = "CAE763D5DCD2DC693DEEA83AE92F98C5", hash_generated_method = "B0950D29B60E23A5639B41C00C3249C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Instrumentation(final ParsePackageItemArgs args, final InstrumentationInfo _info) {
            super(args, _info);
            dsTaint.addTaint(args.dsTaint);
            dsTaint.addTaint(_info.dsTaint);
            // ---------- Original Method ----------
            //info = _info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.651 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "8F0F4F5ADCE8D25D600938A5997F78DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setPackageName(String packageName) {
            dsTaint.addTaint(packageName);
            super.setPackageName(packageName);
            info.packageName = packageName;
            // ---------- Original Method ----------
            //super.setPackageName(packageName);
            //info.packageName = packageName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.653 -0400", hash_original_method = "CB405027A6A70334D830F0B5C698645E", hash_generated_method = "DBDA8A2713032D57D51E0223C3E6B813")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String varCBD85A27A7685CBB5644D335D6274AC4_421194337 = ("Instrumentation{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Instrumentation{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + getComponentShortName() + "}";
        }

        
    }


    
    public static class IntentInfo extends IntentFilter {
        public boolean hasDefault;
        public int labelRes;
        public CharSequence nonLocalizedLabel;
        public int icon;
        public int logo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.654 -0400", hash_original_method = "19540F28344653CC4775F8B7220E09BF", hash_generated_method = "19540F28344653CC4775F8B7220E09BF")
                public IntentInfo ()
        {
        }


    }


    
    public final static class ActivityIntentInfo extends IntentInfo {
        public Activity activity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.655 -0400", hash_original_method = "4F41670063BD951D72DDB0235971893F", hash_generated_method = "47064D186C5903398729AB09B5BD68DA")
        @DSModeled(DSC.SAFE)
        public ActivityIntentInfo(Activity _activity) {
            dsTaint.addTaint(_activity.dsTaint);
            // ---------- Original Method ----------
            //activity = _activity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.656 -0400", hash_original_method = "7C91146E1C4D7077E2D0C55B0D43BF57", hash_generated_method = "3F8EB7D246C1BB4DC8A71BEB18BD48BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var7508B3AB1A0C8789A2CC834D32B4C634_1709378143 = ("ActivityIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + activity.info.name + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "ActivityIntentInfo{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + activity.info.name + "}";
        }

        
    }


    
    public final static class ServiceIntentInfo extends IntentInfo {
        public Service service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.656 -0400", hash_original_method = "2C256432D4530E0F15F4AED85D9A44A0", hash_generated_method = "8C490637531FA55340D37FEA96BC5227")
        @DSModeled(DSC.SAFE)
        public ServiceIntentInfo(Service _service) {
            dsTaint.addTaint(_service.dsTaint);
            // ---------- Original Method ----------
            //service = _service;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.657 -0400", hash_original_method = "32EA4E8A8FC07DAD01188F341ACB2C51", hash_generated_method = "810217A837FCCF06BE9E7C7D302D174C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var4142F6F1201FA178D70ED47B81948C5B_22293548 = ("ServiceIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + service.info.name + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "ServiceIntentInfo{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " " + service.info.name + "}";
        }

        
    }


    
    private static final boolean DEBUG_JAR = false;
    private static final boolean DEBUG_PARSER = false;
    private static final boolean DEBUG_BACKUP = false;
    private static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    public static final PackageParser.NewPermissionInfo NEW_PERMISSIONS[] =
        new PackageParser.NewPermissionInfo[] {
            new PackageParser.NewPermissionInfo(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.os.Build.VERSION_CODES.DONUT, 0),
            new PackageParser.NewPermissionInfo(android.Manifest.permission.READ_PHONE_STATE,
                    android.os.Build.VERSION_CODES.DONUT, 0)
    };
    private static final int SDK_VERSION = Build.VERSION.SDK_INT;
    private static final String SDK_CODENAME = "REL".equals(Build.VERSION.CODENAME)
            ? null : Build.VERSION.CODENAME;
    private static final Object mSync = new Object();
    private static WeakReference<byte[]> mReadBuffer;
    private static boolean sCompatibilityModeEnabled = true;
    private static final int PARSE_DEFAULT_INSTALL_LOCATION = PackageInfo.INSTALL_LOCATION_UNSPECIFIED;
    private static final boolean RIGID_PARSER = false;
    private static final String TAG = "PackageParser";
    public final static int PARSE_IS_SYSTEM = 1<<0;
    public final static int PARSE_CHATTY = 1<<1;
    public final static int PARSE_MUST_BE_APK = 1<<2;
    public final static int PARSE_IGNORE_PROCESSES = 1<<3;
    public final static int PARSE_FORWARD_LOCK = 1<<4;
    public final static int PARSE_ON_SDCARD = 1<<5;
    public final static int PARSE_IS_SYSTEM_DIR = 1<<6;
    private static final String ANDROID_RESOURCES
            = "http://schemas.android.com/apk/res/android";
}

