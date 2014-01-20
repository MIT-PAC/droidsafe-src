package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

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

public class PackageParser {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.480 -0500", hash_original_method = "72C97BC0A6F7F87BCA4FBB5B5356EA82", hash_generated_method = "F68BEDE219F72447698AE74F287EF92B")
    
private static final boolean isPackageFilename(String name) {
        return name.endsWith(".apk");
    }

    /**
     * Generate and return the {@link PackageInfo} for a parsed package.
     *
     * @param p the parsed package.
     * @param flags indicating which optional information is included.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.485 -0500", hash_original_method = "38A030F4DF6BC8DFDE06E024DE0CEB08", hash_generated_method = "0AEBBD1AB1E3468215DF364F5F23F6C5")
    
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

    /*
     * Utility method that retrieves just the package name and install
     * location from the apk location at the given file path.
     * @param packageFilePath file location of the apk
     * @param flags Special parse flags
     * @return PackageLite object with package information or null on failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.521 -0500", hash_original_method = "7D7BCAA297C61EC26138540C898FB792", hash_generated_method = "BEA49D3AA463F054A325D7AC0CE82A31")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.524 -0500", hash_original_method = "374948F6F76AAA09931A96A787759CD2", hash_generated_method = "062D1F11700DE49E41477C0CBC302FF0")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.527 -0500", hash_original_method = "6B3D563B58D4F96DE33030FBF66A336A", hash_generated_method = "1B3BF268BDA96E13F5C88CE2B6B983B8")
    
private static String parsePackageName(XmlPullParser parser,
            AttributeSet attrs, int flags, String[] outError)
            throws IOException, XmlPullParserException {

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.531 -0500", hash_original_method = "903802580AFCCC0E0C0C83CC7450AE55", hash_generated_method = "C0481480429C41A4578A3687B007D765")
    
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

        // Only search the tree when the tag is directly below <manifest>
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

    /**
     * Temporary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.534 -0500", hash_original_method = "72E471693D850A0BFE1FD60B22ACF701", hash_generated_method = "80391645FBEB741B513F9B9FA0266C30")
    
static public Signature stringToSignature(String str) {
        final int N = str.length();
        byte[] sig = new byte[N];
        for (int i=0; i<N; i++) {
            sig[i] = (byte)str.charAt(i);
        }
        return new Signature(sig);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.548 -0500", hash_original_method = "BE6ACE39D7338BA32068799FDBB53169", hash_generated_method = "5114AB970AF376188D02B9F79EE2AB72")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.551 -0500", hash_original_method = "B7A874DF1AB738544036771E9904B7D1", hash_generated_method = "0A340A4B44ED0BAA744122050A73F05C")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.554 -0500", hash_original_method = "F79F0069E41E7C1875AB943D60951387", hash_generated_method = "CB8A37C87D653C1260C9B8C8377D325B")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.557 -0500", hash_original_method = "32096F88962FEB57039D62B42E8373BE", hash_generated_method = "E1E60AE288F83B30A24DF59607635C7F")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.619 -0500", hash_original_method = "111FA512C44DA33ADE25A2DFFE0A4F74", hash_generated_method = "03EED201C006A36FFC98370A1D6C4245")
    
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

        /* First try the key as an RSA key. */
        try {
            final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            final PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return new VerifierInfo(packageName, publicKey);
        } catch (NoSuchAlgorithmException e) {
            Log.wtf(TAG, "Could not parse public key because RSA isn't included in build");
            return null;
        } catch (InvalidKeySpecException e) {
            // Not a RSA public key.
        }

        /* Now try it as a DSA key. */
        try {
            final KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            final PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return new VerifierInfo(packageName, publicKey);
        } catch (NoSuchAlgorithmException e) {
            Log.wtf(TAG, "Could not parse public key because DSA isn't included in build");
            return null;
        } catch (InvalidKeySpecException e) {
            // Not a DSA public key.
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.799 -0500", hash_original_method = "CAD140A669B97EA92CBF60BA355D73F0", hash_generated_method = "D62D34A6B8005972C60E01E93BD1BB92")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.803 -0500", hash_original_method = "18A902B290E2E89AC881C8EFCD66A2AB", hash_generated_method = "2FE73977995964B6EF67C354794C3EF5")
    
public static ApplicationInfo generateApplicationInfo(Package p, int flags) {
        if (p == null) return null;
        if (!copyNeeded(flags, p, null)) {
            // CompatibilityMode is global state. It's safe to modify the instance
            // of the package.
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

        // Make shallow copy so we can store the metadata/libraries safely
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.805 -0500", hash_original_method = "4F16162E163F3F1B8686121130365841", hash_generated_method = "C1B245AF3DED7F35C4C7A6D063520B49")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.807 -0500", hash_original_method = "9F51850244FF4B7691C7FEFF9F6F1B1B", hash_generated_method = "EA25FEE9B4AF24DBE4C8384DE95DBB98")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.828 -0500", hash_original_method = "8ED61B4C8FEFF188F2AE75668973FBE7", hash_generated_method = "C1DD9B6327681A6162B462CA0C52C937")
    
public static final ActivityInfo generateActivityInfo(Activity a,
            int flags) {
        if (a == null) return null;
        if (!copyNeeded(flags, a.owner, a.metaData)) {
            return a.info;
        }
        // Make shallow copies so we can store the metadata safely
        ActivityInfo ai = new ActivityInfo(a.info);
        ai.metaData = a.metaData;
        ai.applicationInfo = generateApplicationInfo(a.owner, flags);
        return ai;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.843 -0500", hash_original_method = "B2C9CF84770AAE8BF4EE944BF63601B9", hash_generated_method = "31672A183F7C4BDFD822156BD5FBC39A")
    
public static final ServiceInfo generateServiceInfo(Service s, int flags) {
        if (s == null) return null;
        if (!copyNeeded(flags, s.owner, s.metaData)) {
            return s.info;
        }
        // Make shallow copies so we can store the metadata safely
        ServiceInfo si = new ServiceInfo(s.info);
        si.metaData = s.metaData;
        si.applicationInfo = generateApplicationInfo(s.owner, flags);
        return si;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.864 -0500", hash_original_method = "324803AE93E479FD09C8CA1655E1A106", hash_generated_method = "B14D632DFD5C0CF9B136C25C935E42D8")
    
public static final ProviderInfo generateProviderInfo(Provider p,
            int flags) {
        if (p == null) return null;
        if (!copyNeeded(flags, p.owner, p.metaData)
                && ((flags & PackageManager.GET_URI_PERMISSION_PATTERNS) != 0
                        || p.info.uriPermissionPatterns == null)) {
            return p.info;
        }
        // Make shallow copies so we can store the metadata safely
        ProviderInfo pi = new ProviderInfo(p.info);
        pi.metaData = p.metaData;
        if ((flags & PackageManager.GET_URI_PERMISSION_PATTERNS) == 0) {
            pi.uriPermissionPatterns = null;
        }
        pi.applicationInfo = generateApplicationInfo(p.owner, flags);
        return pi;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.879 -0500", hash_original_method = "CDA3E7B404E43C4B1A6AB9F993E84DFF", hash_generated_method = "0E5941F7F793D070DCF06E1BA20B98C3")
    
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

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.915 -0500", hash_original_method = "F4D7076C32CD297FD655BA18A652F524", hash_generated_method = "64241781A3A13653B04D34555A2FABAF")
    
public static void setCompatibilityModeEnabled(boolean compatibilityModeEnabled) {
        sCompatibilityModeEnabled = compatibilityModeEnabled;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.354 -0500", hash_original_field = "680A313F6F4646E328FAB8F0A1753A64", hash_generated_field = "252B27621B0C95282FCD74EADD1D3B06")

    private static final boolean DEBUG_JAR = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.357 -0500", hash_original_field = "1F510A5666FCC900F68E713014FEF0E9", hash_generated_field = "74CDFDDFB4ADEE936A3A2D224333889E")

    private static final boolean DEBUG_PARSER = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.359 -0500", hash_original_field = "14C5B4DAD51835B9D1CAC112FA9E96CD", hash_generated_field = "E528C7EA12190339B7B5F859330E06A3")

    private static final boolean DEBUG_BACKUP = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.362 -0500", hash_original_field = "5C950020DA9370B657965E3DE42F3AE4", hash_generated_field = "4F97594385EB4442B91157C93FC88149")

    private static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.377 -0500", hash_original_field = "2CEFD5049C237C64DF0797080F7B36D6", hash_generated_field = "4E7CCA62AA0883D7BED63D0B9D564192")

    public static final PackageParser.NewPermissionInfo NEW_PERMISSIONS[] =
        new PackageParser.NewPermissionInfo[] {
            new PackageParser.NewPermissionInfo(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.os.Build.VERSION_CODES.DONUT, 0),
            new PackageParser.NewPermissionInfo(android.Manifest.permission.READ_PHONE_STATE,
                    android.os.Build.VERSION_CODES.DONUT, 0)
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.387 -0500", hash_original_field = "BF3301EF6D31C786401AD1D2EFADE93C", hash_generated_field = "905C38351D97D12004B7C4F50D80A9E2")

    private static final int SDK_VERSION = Build.VERSION.SDK_INT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.389 -0500", hash_original_field = "5BA6892AD660FFBF674095E829F436D3", hash_generated_field = "F491825EC7555754BC21523DA68EFCCB")

    private static final String SDK_CODENAME = "REL".equals(Build.VERSION.CODENAME)
            ? null : Build.VERSION.CODENAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.394 -0500", hash_original_field = "349D1EAD6A3DD6EDFBBB76E7AC55FC2F", hash_generated_field = "F668D47897E28620543685D1E68BB2A5")

    private static final Object mSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.396 -0500", hash_original_field = "AA4CA85B0A9FDAAA8AA5E18A1DAB542E", hash_generated_field = "C91A03D8C0281FD6FE8F7562B14775C4")

    private static WeakReference<byte[]> mReadBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.399 -0500", hash_original_field = "F7CDB5046ED291FCCD30C88E8D784F10", hash_generated_field = "23A0E0B3C74959CD54FEA5BC7440ADA6")

    private static boolean sCompatibilityModeEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.401 -0500", hash_original_field = "1F051C1B338C25A1719CB53D59B339BE", hash_generated_field = "1FDCA6654F70EEBFD65FBF1AF519E5AA")

    private static final int PARSE_DEFAULT_INSTALL_LOCATION = PackageInfo.INSTALL_LOCATION_UNSPECIFIED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.468 -0500", hash_original_field = "A6DE6C9FE2681C7700168264C3725113", hash_generated_field = "9B95BCC659E00681D48AF406E80790EA")

    private static final boolean RIGID_PARSER = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.470 -0500", hash_original_field = "932DCC841B95F57B0DA182694B3E0EE9", hash_generated_field = "DD8609BA0B76A819C8573C819B7348A6")

    private static final String TAG = "PackageParser";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.490 -0500", hash_original_field = "E7BAC5E9490EC58238EC4C79E12B07D1", hash_generated_field = "4B52CDD8E5ADCA354868822A64689A48")

    public final static int PARSE_IS_SYSTEM = 1<<0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.492 -0500", hash_original_field = "2913D5634054C90EA1807E9EFA77B6CF", hash_generated_field = "D16481D6B9C894AA8F9AD72D6FF3BE41")

    public final static int PARSE_CHATTY = 1<<1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.495 -0500", hash_original_field = "EE39DF329D11FABA0A34223FADC0AD24", hash_generated_field = "D85F2CA29F944D705DACCE7CFE1CCC41")

    public final static int PARSE_MUST_BE_APK = 1<<2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.498 -0500", hash_original_field = "0D4D81EC06D8EF24373CC0512646031F", hash_generated_field = "28588A534392FDDD099636AF774A3125")

    public final static int PARSE_IGNORE_PROCESSES = 1<<3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.501 -0500", hash_original_field = "9826C91C24F75D3D514083E02269041C", hash_generated_field = "55AEA484B033A779430356E4D8F71309")

    public final static int PARSE_FORWARD_LOCK = 1<<4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.503 -0500", hash_original_field = "1CBC5BFE02FAD2CF3A837BA190963F9C", hash_generated_field = "E1C3B202E87D4E3614B1E66CD70ED663")

    public final static int PARSE_ON_SDCARD = 1<<5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.505 -0500", hash_original_field = "4AC215700D1C395D8D52A35730EE7DBA", hash_generated_field = "3D41C84BD91D95AD71586AAACE412C36")

    public final static int PARSE_IS_SYSTEM_DIR = 1<<6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.621 -0500", hash_original_field = "59A90DB5D87AFDE3F77EBA16A5271315", hash_generated_field = "1E8F77612F2ACC70744F2BEF9D03FB1E")

    private static final String ANDROID_RESOURCES
            = "http://schemas.android.com/apk/res/android";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.379 -0500", hash_original_field = "5E985BE30D34F2E0FE7988CAAB75FF22", hash_generated_field = "57425F83C121F61E241FD46B0ED62373")

    private String mArchiveSourcePath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.382 -0500", hash_original_field = "E6B9EAEA02C9911B8AFDEDB52C3E24D9", hash_generated_field = "642D094C7AB0E1931029DBA1482587AA")

    private String[] mSeparateProcesses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.384 -0500", hash_original_field = "ECD0FF8120A340F61DE545FF6F5422A9", hash_generated_field = "7D4097DC031AD87620CBAE061A799BA0")

    private boolean mOnlyCoreApps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.392 -0500", hash_original_field = "1787F62A32F37AC744CB4C7C3DE0D384", hash_generated_field = "809C28E1E054CBEE627F51452F62162E")

    private int mParseError = PackageManager.INSTALL_SUCCEEDED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.456 -0500", hash_original_field = "0865FE81994682067F2D744C146263FF", hash_generated_field = "5C8F41F6CF659609357D809C60CDDF3A")

    private ParsePackageItemArgs mParseInstrumentationArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.459 -0500", hash_original_field = "EF8B3B9722DB40E9C36202B3E409B82A", hash_generated_field = "65DE09F18AF72BEAF7CDD76662D74019")

    private ParseComponentArgs mParseActivityArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.461 -0500", hash_original_field = "8A6E260BB8FADC1D1B084A7815ABB25B", hash_generated_field = "ACF41630823F563A230447D3D7E52494")

    private ParseComponentArgs mParseActivityAliasArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.463 -0500", hash_original_field = "6A80C6B81848AB1394AA3B49050DBC18", hash_generated_field = "9225E738D789335DA1CFA407299C2B0D")

    private ParseComponentArgs mParseServiceArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.465 -0500", hash_original_field = "80375BBFF3AC5BBA1CE69D4FA2DD3883", hash_generated_field = "319560D498F8EDD3EA50CA6B89B5AD1B")

    private ParseComponentArgs mParseProviderArgs;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.472 -0500", hash_original_method = "DDBED2CCEF7CE747A37B4CF69A21D51E", hash_generated_method = "1CC80E319B65BA017C53BE22DCB8F351")
    
public PackageParser(String archiveSourcePath) {
        mArchiveSourcePath = archiveSourcePath;
    }
    
    public static class NewPermissionInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.365 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.367 -0500", hash_original_field = "851A374D8B206493A1DDEF73226FFD67", hash_generated_field = "BC6F74C41FF51DC8E932B8D548DFA77F")

        public  int sdkVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.370 -0500", hash_original_field = "8C61D5D73EEB7790DC6637F2CCDFEEDC", hash_generated_field = "110F458F9380E184018D0C29262B9616")

        public  int fileVersion;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.373 -0500", hash_original_method = "2CD4C5E2A660B34C44D0A141A2AEA4A5", hash_generated_method = "1455C509D2BB56A5C40367EA2EBB32FF")
        
public NewPermissionInfo(String name, int sdkVersion, int fileVersion) {
            this.name = name;
            this.sdkVersion = sdkVersion;
            this.fileVersion = fileVersion;
        }
        
    }
    
    static class ParsePackageItemArgs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.403 -0500", hash_original_field = "63E7E49220BEC65CFB906D3D26FF5320", hash_generated_field = "63E7E49220BEC65CFB906D3D26FF5320")

         Package owner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.407 -0500", hash_original_field = "291217E682224D693BB6F37B520F9B6C", hash_generated_field = "291217E682224D693BB6F37B520F9B6C")

         String[] outError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.409 -0500", hash_original_field = "0B58898276367165952073A704F8E936", hash_generated_field = "0B58898276367165952073A704F8E936")

         int nameRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.411 -0500", hash_original_field = "72766807210949DB14E0A53D32EEFA42", hash_generated_field = "72766807210949DB14E0A53D32EEFA42")

         int labelRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.414 -0500", hash_original_field = "16A2D6444BA4128F5DED925DDCED14C3", hash_generated_field = "16A2D6444BA4128F5DED925DDCED14C3")

         int iconRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.416 -0500", hash_original_field = "9076C14F4A6A5083F7B4331FB7F68DE2", hash_generated_field = "9076C14F4A6A5083F7B4331FB7F68DE2")

         int logoRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.418 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "FFCA994A2F44B678330E924D8C87385D")
        
        String tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.420 -0500", hash_original_field = "F31D05FD6AB3B23194ACB45C1F7F8DB9", hash_generated_field = "F31D05FD6AB3B23194ACB45C1F7F8DB9")

        TypedArray sa;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.423 -0500", hash_original_method = "FEBED5B917290B280BC232B6F93C8DA6", hash_generated_method = "FEBED5B917290B280BC232B6F93C8DA6")
        
ParsePackageItemArgs(Package _owner, String[] _outError,
                int _nameRes, int _labelRes, int _iconRes, int _logoRes) {
            owner = _owner;
            outError = _outError;
            nameRes = _nameRes;
            labelRes = _labelRes;
            iconRes = _iconRes;
            logoRes = _logoRes;
        }
        
    }
    
    static class ParseComponentArgs extends ParsePackageItemArgs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.427 -0500", hash_original_field = "52628BA19847DEC6DD967DC512B6341E", hash_generated_field = "52628BA19847DEC6DD967DC512B6341E")

         String[] sepProcesses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.429 -0500", hash_original_field = "98EAE5992470306073D805F3DE4D2B98", hash_generated_field = "98EAE5992470306073D805F3DE4D2B98")

         int processRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.432 -0500", hash_original_field = "1C23F3ABB5154D4340D3FAF2DBF4B754", hash_generated_field = "1C23F3ABB5154D4340D3FAF2DBF4B754")

         int descriptionRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.434 -0500", hash_original_field = "DBC8C6552821B500EDF219C9444E5014", hash_generated_field = "DBC8C6552821B500EDF219C9444E5014")

         int enabledRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.437 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

        int flags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.439 -0500", hash_original_method = "A5B17BCC2B409C42234E0A16A22942F4", hash_generated_method = "A5B17BCC2B409C42234E0A16A22942F4")
        
ParseComponentArgs(Package _owner, String[] _outError,
                int _nameRes, int _labelRes, int _iconRes, int _logoRes,
                String[] _sepProcesses, int _processRes,
                int _descriptionRes, int _enabledRes) {
            super(_owner, _outError, _nameRes, _labelRes, _iconRes, _logoRes);
            sepProcesses = _sepProcesses;
            processRes = _processRes;
            descriptionRes = _descriptionRes;
            enabledRes = _enabledRes;
        }
        
    }
    
    public static class PackageLite {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.444 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public  String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.446 -0500", hash_original_field = "BF693F839564E9279728D50BEF7E118B", hash_generated_field = "30578A504DDEAA8F4E71E08EEE4589B5")

        public  int installLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.448 -0500", hash_original_field = "D633311B091C9DED3FD1539C654F3395", hash_generated_field = "547B5BDAEDA540976776CD453D2E9834")

        public  VerifierInfo[] verifiers;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.452 -0500", hash_original_method = "7A496B905B539B1321EA9EDB02EF9EB7", hash_generated_method = "EAE25EB1C7AE8C5C91C0B71E3C8FBDFA")
        
public PackageLite(String packageName, int installLocation, List<VerifierInfo> verifiers) {
            this.packageName = packageName;
            this.installLocation = installLocation;
            this.verifiers = verifiers.toArray(new VerifierInfo[verifiers.size()]);
        }
        
    }
    
    public final static class Package {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.630 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.632 -0500", hash_original_field = "1722FDB63F23A7F35DB3563CE76FB0CC", hash_generated_field = "4036EBD0249B46B198C5B885936F9FD5")

        public final ApplicationInfo applicationInfo = new ApplicationInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.635 -0500", hash_original_field = "47B4A3B931CA77844EF31DD547DFA859", hash_generated_field = "9F287DA06540EF72A4AA2C12FCA47D9D")

        public final ArrayList<Permission> permissions = new ArrayList<Permission>(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.638 -0500", hash_original_field = "DCE1DFEDDABF7519DDB7D8448576BC07", hash_generated_field = "44F464774678F54DEC4F24FE42619000")

        public final ArrayList<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.640 -0500", hash_original_field = "A658F9195304A9CD7D019BBA5B079455", hash_generated_field = "FA37560F9C65320DAA508260F22AE66D")

        public final ArrayList<Activity> activities = new ArrayList<Activity>(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.642 -0500", hash_original_field = "82F88F2B1EBE00F033DB18F62F1A387A", hash_generated_field = "9593D48EBFB86307D900AA7594B7FB40")

        public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.645 -0500", hash_original_field = "CC7FEF311A44F400C25AF05C23751A86", hash_generated_field = "BC5EE090E89F224AA377168513277DFC")

        public final ArrayList<Provider> providers = new ArrayList<Provider>(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.648 -0500", hash_original_field = "8D59DB826C9FFDDBD9A245313BC41397", hash_generated_field = "442AF6E4956588BEC9D95A4B568FDF37")

        public final ArrayList<Service> services = new ArrayList<Service>(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.650 -0500", hash_original_field = "B39D952B8C8A85FF0758DD181613C93A", hash_generated_field = "3F24774E8DFC500EA6EF7CB14E2DAE81")

        public final ArrayList<Instrumentation> instrumentation = new ArrayList<Instrumentation>(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.652 -0500", hash_original_field = "63327953C5F8F95F591E69BA4245C045", hash_generated_field = "7D1FBB8E91439EB14277D7D8BA33F0DA")

        public final ArrayList<String> requestedPermissions = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.655 -0500", hash_original_field = "59AA6FD5BD3953B1A109F5899F927F46", hash_generated_field = "08EEF0A6E1D22D736BF2E545A29D8138")

        public ArrayList<String> protectedBroadcasts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.657 -0500", hash_original_field = "2104ADE4423C190CC2AB868FB34DAD86", hash_generated_field = "38B8DDE984ADCEFBD679BD148096C90B")
        
        public ArrayList<String> usesLibraries = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.659 -0500", hash_original_field = "5A0FEAB2E786609C044623E4050A7E13", hash_generated_field = "B4E5B43916326236F7AC60FB6AA30ED0")

        public ArrayList<String> usesOptionalLibraries = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.662 -0500", hash_original_field = "CA48390E00F96BED80B29872962FEC16", hash_generated_field = "E256E3F26B890CB645F141CE43A19B9C")

        public String[] usesLibraryFiles = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.664 -0500", hash_original_field = "B54303611DA8B5FCAE76312932648A79", hash_generated_field = "E6599044F06DEA0FBD755EB8BE240A8E")

        public ArrayList<String> mOriginalPackages = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.667 -0500", hash_original_field = "31396CEB1467C7077D0CD3C972D994B3", hash_generated_field = "04EBB67E52CE8E75294355C009EB60C1")

        public String mRealPackage = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.669 -0500", hash_original_field = "99961B864715B7E5A04A013564B0BA19", hash_generated_field = "AEFDC3F9A7F5911D385620280B7625C2")

        public ArrayList<String> mAdoptPermissions = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.671 -0500", hash_original_field = "D513F11A2EAC2CF5E4DECD5266720C89", hash_generated_field = "07357F002FB731C049A7E8EF93488FAB")

        public Bundle mAppMetaData = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.674 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "305B7716861981204869144DBD3A202B")

        public String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.676 -0500", hash_original_field = "1E960C258E2A4355A370C5C64F4FF504", hash_generated_field = "2D25A57F98AA26067BCE62362DE0AEEE")

        public int mVersionCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.679 -0500", hash_original_field = "23DAA84A9C6026B24FE3860316B486A1", hash_generated_field = "AD0666B617F8EB374F674D223A151BE8")

        public String mVersionName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.681 -0500", hash_original_field = "ED1645516EE038D3DB78DCBA1689F0B7", hash_generated_field = "1BA8548AD03E92E8907935F23C7EC7DC")

        public String mSharedUserId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.684 -0500", hash_original_field = "06C514DD9FB957B20F43BA7587125E41", hash_generated_field = "E426A46C5F8600102F790613EDFE2FA5")

        public int mSharedUserLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.686 -0500", hash_original_field = "225AF11886E9640A2B12CA1E79D051F9", hash_generated_field = "D0A761ADB8F3D08D19028AF26464A727")

        public Signature mSignatures[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.688 -0500", hash_original_field = "B406165913C2803A6EE477C3DAA2E26C", hash_generated_field = "DEE6C9BA5015D1DCFE4C7FA83DD7AD5C")

        // preferred up order.
        public int mPreferredOrder = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.691 -0500", hash_original_field = "69D8AFB75553068A044A2C94D7C3AE03", hash_generated_field = "CC051FFA341F8CBB3F12D6D4A09F66CF")

        // file an app came from.
        public String mScanPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.693 -0500", hash_original_field = "63C12BF4ACFB916BB44A4D615929D107", hash_generated_field = "7D697318734FF4FCAC89EE6F12A79BBA")

        public boolean mDidDexOpt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.695 -0500", hash_original_field = "B5AED6A0DBF577E28C24DFE9A18EC6E2", hash_generated_field = "01E3EC227D5D4747BBF3C8E007B87A8C")

        public int mSetEnabled = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.697 -0500", hash_original_field = "67B7BD5F6C6585F57ED4C687E55056A2", hash_generated_field = "F2AF2DCB7F1AF550D0120E8A8EC3076A")

        public boolean mSetStopped = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.700 -0500", hash_original_field = "9BDA8385E65123CE41EA2C3036B5A57A", hash_generated_field = "31FF094E094B19A5172EF65F93099B80")

        public Object mExtras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.702 -0500", hash_original_field = "DEBBE89FBB722DD6C604AD3AAF734AED", hash_generated_field = "006EB022C9A35AC652457AFB4C61156A")

        public boolean mOperationPending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.704 -0500", hash_original_field = "B9BB599F0225EB2391F41B3287C92FCC", hash_generated_field = "4E89D4689FD45B6957FE611B20917965")

        public final ArrayList<ConfigurationInfo> configPreferences =
                new ArrayList<ConfigurationInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.707 -0500", hash_original_field = "C7466FC6905E5AC275F0B3B8D371A788", hash_generated_field = "56739470CD23739123AD6639F0ED5CDC")

        public ArrayList<FeatureInfo> reqFeatures = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.709 -0500", hash_original_field = "BF693F839564E9279728D50BEF7E118B", hash_generated_field = "30578A504DDEAA8F4E71E08EEE4589B5")

        public int installLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.712 -0500", hash_original_field = "F09F502EBB949BAD3574E5F6C55E02A2", hash_generated_field = "7CE719961EFE13A323B2F3853261CD27")

        public ManifestDigest manifestDigest;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.714 -0500", hash_original_method = "8954AF7805FA48686FD1C5CD1B4EC95C", hash_generated_method = "65151307437E83AE24BCA52F2264E5AA")
        
public Package(String _name) {
            packageName = _name;
            applicationInfo.packageName = _name;
            applicationInfo.uid = -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.718 -0500", hash_original_method = "B05A09470669E629F210442116CDFAC5", hash_generated_method = "1F1AE6F6E025C5AB40ED6E2DFE704EF4")
        
public void setPackageName(String newName) {
            packageName = newName;
            applicationInfo.packageName = newName;
            for (int i=permissions.size()-1; i>=0; i--) {
                permissions.get(i).setPackageName(newName);
            }
            for (int i=permissionGroups.size()-1; i>=0; i--) {
                permissionGroups.get(i).setPackageName(newName);
            }
            for (int i=activities.size()-1; i>=0; i--) {
                activities.get(i).setPackageName(newName);
            }
            for (int i=receivers.size()-1; i>=0; i--) {
                receivers.get(i).setPackageName(newName);
            }
            for (int i=providers.size()-1; i>=0; i--) {
                providers.get(i).setPackageName(newName);
            }
            for (int i=services.size()-1; i>=0; i--) {
                services.get(i).setPackageName(newName);
            }
            for (int i=instrumentation.size()-1; i>=0; i--) {
                instrumentation.get(i).setPackageName(newName);
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.721 -0500", hash_original_method = "7DFEBE5DF638D8804915FD110C0E2540", hash_generated_method = "D1144C82B8112237A29A16751CC92459")
        
public String toString() {
            return "Package{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + packageName + "}";
        }
        
    }
    
    public static class Component<II extends IntentInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.726 -0500", hash_original_field = "63E7E49220BEC65CFB906D3D26FF5320", hash_generated_field = "B7B17A6D136295F4EF656A6C2B786D1E")

        public  Package owner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.729 -0500", hash_original_field = "C5329E3826FFAE51ACC45345B1E460B9", hash_generated_field = "D8DEE06C2E494DBB6667E43B6FBC365D")

        public  ArrayList<II> intents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.731 -0500", hash_original_field = "CA6BE7A479C5F3E68F3687DBA3A4A48F", hash_generated_field = "868D31C10A710A0DF272DC0EA267B5A9")

        public  String className;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.734 -0500", hash_original_field = "28705BB70A2AE2760BB13E62CB7CCF68", hash_generated_field = "94B83340D21CBE8DE8F4A432223AA875")

        public Bundle metaData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.736 -0500", hash_original_field = "E3D849549355C126FFF6430112CFAA0A", hash_generated_field = "E3D849549355C126FFF6430112CFAA0A")

        ComponentName componentName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.738 -0500", hash_original_field = "A35E7838F783416409F7A19252F30415", hash_generated_field = "A35E7838F783416409F7A19252F30415")

        String componentShortName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.740 -0500", hash_original_method = "B544BED1308F0633C32173E605BDF8E5", hash_generated_method = "9DBDADADCE31B012143415ABB7971914")
        
public Component(Package _owner) {
            owner = _owner;
            intents = null;
            className = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.744 -0500", hash_original_method = "A43E20CDE8CCB4A62D1450265CBDCEF5", hash_generated_method = "29A4E0554219706CA3A529236BD6DF1C")
        
public Component(final ParsePackageItemArgs args, final PackageItemInfo outInfo) {
            owner = args.owner;
            intents = new ArrayList<II>(0);
            String name = args.sa.getNonConfigurationString(args.nameRes, 0);
            if (name == null) {
                className = null;
                args.outError[0] = args.tag + " does not specify android:name";
                return;
            }

            outInfo.name
                = buildClassName(owner.applicationInfo.packageName, name, args.outError);
            if (outInfo.name == null) {
                className = null;
                args.outError[0] = args.tag + " does not have valid android:name";
                return;
            }

            className = outInfo.name;

            int iconVal = args.sa.getResourceId(args.iconRes, 0);
            if (iconVal != 0) {
                outInfo.icon = iconVal;
                outInfo.nonLocalizedLabel = null;
            }
            
            int logoVal = args.sa.getResourceId(args.logoRes, 0);
            if (logoVal != 0) {
                outInfo.logo = logoVal;
            }

            TypedValue v = args.sa.peekValue(args.labelRes);
            if (v != null && (outInfo.labelRes=v.resourceId) == 0) {
                outInfo.nonLocalizedLabel = v.coerceToString();
            }

            outInfo.packageName = owner.packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.748 -0500", hash_original_method = "D9B47963B1B8ABE0F2CDFAC0BBD1CAD2", hash_generated_method = "883FEE44CB440155B5D452EEB5D3FD03")
        
public Component(final ParseComponentArgs args, final ComponentInfo outInfo) {
            this(args, (PackageItemInfo)outInfo);
            if (args.outError[0] != null) {
                return;
            }

            if (args.processRes != 0) {
                CharSequence pname;
                if (owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.FROYO) {
                    pname = args.sa.getNonConfigurationString(args.processRes, 0);
                } else {
                    // Some older apps have been seen to use a resource reference
                    // here that on older builds was ignored (with a warning).  We
                    // need to continue to do this for them so they don't break.
                    pname = args.sa.getNonResourceString(args.processRes);
                }
                outInfo.processName = buildProcessName(owner.applicationInfo.packageName,
                        owner.applicationInfo.processName, pname,
                        args.flags, args.sepProcesses, args.outError);
            }
            
            if (args.descriptionRes != 0) {
                outInfo.descriptionRes = args.sa.getResourceId(args.descriptionRes, 0);
            }
            
            outInfo.enabled = args.sa.getBoolean(args.enabledRes, true);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.750 -0500", hash_original_method = "7A30742503E7124B050658D7B849B524", hash_generated_method = "C83035846845601BB3398AD0D1362102")
        
public Component(Component<II> clone) {
            owner = clone.owner;
            intents = clone.intents;
            className = clone.className;
            componentName = clone.componentName;
            componentShortName = clone.componentShortName;
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.753 -0500", hash_original_method = "BF1ED0A6C0ACE1EE7610EB0D74F5C800", hash_generated_method = "853DE9A1A7830A59FF04A72BC4DF77DA")
        
public ComponentName getComponentName() {
            if (componentName != null) {
                return componentName;
            }
            if (className != null) {
                componentName = new ComponentName(owner.applicationInfo.packageName,
                        className);
            }
            return componentName;
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.755 -0500", hash_original_method = "3A4D7499A9518F3ABB20BEBAE6816B9D", hash_generated_method = "66AA47B485B4E3BFCC20DAE6203B219A")
        
public String getComponentShortName() {
            if (componentShortName != null) {
                return componentShortName;
            }
            ComponentName component = getComponentName();
            if (component != null) {
                componentShortName = component.flattenToShortString();
            }
            return componentShortName;
        }
        
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.759 -0500", hash_original_method = "AFFE8B7215C15E45738BCB365FA520F8", hash_generated_method = "6CE8DD4518E7BC84467932004B12946D")
        
public void setPackageName(String packageName) {
            componentName = null;
            componentShortName = null;
        }
        
    }
    
    public final static class Permission extends Component<IntentInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.765 -0500", hash_original_field = "4241C73A320D988CEDA8D0AE82D7ADA4", hash_generated_field = "44FAE9A36D6EBA187A54E941C96BA855")

        public  PermissionInfo info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.767 -0500", hash_original_field = "CB67E74A3CBC7C2266EC717F79263849", hash_generated_field = "EF09DBC8B27A53D0E48DDC50B1CFE266")

        public boolean tree;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.769 -0500", hash_original_field = "1EFD468F8D4D2602A3DECFB32E972F0F", hash_generated_field = "81FA9670466619AF97D2F0A37093F67B")

        public PermissionGroup group;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.772 -0500", hash_original_method = "28D7021527B7BC8061929232C0A668B9", hash_generated_method = "E53F5C6B458AA36B104CB637B3C0A552")
        
public Permission(Package _owner) {
            super(_owner);
            info = new PermissionInfo();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.775 -0500", hash_original_method = "37E156160FC75CB3C9E2BA72594B754D", hash_generated_method = "1A345D54C71A0CC4DAD78AB38AE178D6")
        
public Permission(Package _owner, PermissionInfo _info) {
            super(_owner);
            info = _info;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.777 -0500", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "9889EAAFF7D9E6E2D0F0F02C8308AF2A")
        
public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.780 -0500", hash_original_method = "D70298090C91BEA7F3B1C7F9C9416449", hash_generated_method = "3E56225E2F2712FE7981B0CB083160F7")
        
public String toString() {
            return "Permission{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
        }
        
    }
    
    public final static class PermissionGroup extends Component<IntentInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.785 -0500", hash_original_field = "8CC233C9F6CFC43C7F4E1C98E681317A", hash_generated_field = "4AEC0127E51446670A8F6715545F2FFD")

        public  PermissionGroupInfo info;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.787 -0500", hash_original_method = "19A5AAAA7728282CABC960AB069F9E98", hash_generated_method = "0CE5244AE69F166813A6E14BEC97EE5B")
        
public PermissionGroup(Package _owner) {
            super(_owner);
            info = new PermissionGroupInfo();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.790 -0500", hash_original_method = "8FB9374E9D85DC0253F34BC909070B56", hash_generated_method = "4504C25C2C0AE8BF8978FBBBF33DD5F8")
        
public PermissionGroup(Package _owner, PermissionGroupInfo _info) {
            super(_owner);
            info = _info;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.792 -0500", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "9889EAAFF7D9E6E2D0F0F02C8308AF2A")
        
public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.794 -0500", hash_original_method = "5B6E9035FB2F0E9673597108CCAFFCEF", hash_generated_method = "E42B26C25273063D7962DB183E8E8149")
        
public String toString() {
            return "PermissionGroup{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
        }
        
    }
    
    public final static class Activity extends Component<ActivityIntentInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.812 -0500", hash_original_field = "D6562EB0A3FC9B94476A16D5F303F058", hash_generated_field = "31C563E0B9BB4DA4F801727DD7960E99")

        public  ActivityInfo info;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.816 -0500", hash_original_method = "2916F6991906FCE3DAEE226AB756275F", hash_generated_method = "6CA386A7766CE9673988802FCF84C6A7")
        
public Activity(final ParseComponentArgs args, final ActivityInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.818 -0500", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "9889EAAFF7D9E6E2D0F0F02C8308AF2A")
        
public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.821 -0500", hash_original_method = "3ED5BAD5E29B5F8C3FFE202D917D91C6", hash_generated_method = "7CE213452BF93C3CE1C519974BF0AFC8")
        
public String toString() {
            return "Activity{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
        }
        
    }
    
    public final static class Service extends Component<ServiceIntentInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.831 -0500", hash_original_field = "4AEE41877C99C71A9296A5C433E71F7C", hash_generated_field = "44442782625E786E51B742A3D7D5DE80")

        public  ServiceInfo info;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.833 -0500", hash_original_method = "2742F060EFDB78FDF4E4BA2659F1DC82", hash_generated_method = "164CB682681EA3DC7CFCDDF8D9DA9C96")
        
public Service(final ParseComponentArgs args, final ServiceInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
        }
        
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.835 -0500", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "9889EAAFF7D9E6E2D0F0F02C8308AF2A")
        
public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.837 -0500", hash_original_method = "983F0C4312E41963E910123205C22323", hash_generated_method = "20088CC99BD071A59D9E33F497EDFF1F")
        
public String toString() {
            return "Service{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
        }
        
    }
    
    public final static class Provider extends Component {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.846 -0500", hash_original_field = "5CDA2FBF2554178EE653F2BC5EB08EC7", hash_generated_field = "BF776B364C73D31E6B3B31185D6DF955")

        public  ProviderInfo info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.849 -0500", hash_original_field = "EE06816A8A51C4265B5577A9981B83CD", hash_generated_field = "8DCC80DE4F5A821BFB32172415658FEA")

        public boolean syncable;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.852 -0500", hash_original_method = "EAE8B6AC135EBC96C8D24D047B180DE5", hash_generated_method = "A000375F699A81AD0EAC1F0703279BE0")
        
public Provider(final ParseComponentArgs args, final ProviderInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
            syncable = false;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.855 -0500", hash_original_method = "7DA675634165C06E74013727D919E49C", hash_generated_method = "985457745BC38E0AF038AC58F528E846")
        
public Provider(Provider existingProvider) {
            super(existingProvider);
            this.info = existingProvider.info;
            this.syncable = existingProvider.syncable;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.857 -0500", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "9889EAAFF7D9E6E2D0F0F02C8308AF2A")
        
public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.859 -0500", hash_original_method = "68549008F1EBCA6BA1DE59DAB2FE7E3C", hash_generated_method = "7456EF1BE421AF203ED4C0B86DA93B62")
        
public String toString() {
            return "Provider{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
        }
        
    }
    
    public final static class Instrumentation extends Component {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.867 -0500", hash_original_field = "AC2380494E7629FC05F61CD5269FE09A", hash_generated_field = "9E4A99D8D40782E1B858164167767C21")

        public  InstrumentationInfo info;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.871 -0500", hash_original_method = "CAE763D5DCD2DC693DEEA83AE92F98C5", hash_generated_method = "6F2641CF5E854BD1F2B782A855874529")
        
public Instrumentation(final ParsePackageItemArgs args, final InstrumentationInfo _info) {
            super(args, _info);
            info = _info;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.873 -0500", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "9889EAAFF7D9E6E2D0F0F02C8308AF2A")
        
public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.876 -0500", hash_original_method = "CB405027A6A70334D830F0B5C698645E", hash_generated_method = "8AF7C2F06339D5FDF9CD9BEDED5D9B01")
        
public String toString() {
            return "Instrumentation{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
        }
        
    }
    
    public static class IntentInfo extends IntentFilter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.882 -0500", hash_original_field = "FE46C49B5E51D32E88C8BD46819E9489", hash_generated_field = "27741E2F90129BA4D13424CA3120F0CA")

        public boolean hasDefault;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.884 -0500", hash_original_field = "72766807210949DB14E0A53D32EEFA42", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

        public int labelRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.887 -0500", hash_original_field = "E41FD8D985C7C7980A3E63475B8D976E", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

        public CharSequence nonLocalizedLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.890 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.892 -0500", hash_original_field = "40F1731F6DDC59241C091ACC1EFBC7B2", hash_generated_field = "922885A8A44FD4A4B2D8F0B49A2EDED6")

        public int logo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.198 -0400", hash_original_method = "351B7321F95DEA4A1F6C5D218D4A2DB8", hash_generated_method = "351B7321F95DEA4A1F6C5D218D4A2DB8")
        public IntentInfo ()
        {
            //Synthesized constructor
        }

    }
    
    public final static class ActivityIntentInfo extends IntentInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.896 -0500", hash_original_field = "A63B0916BD4AC2611D1AF746A2DF045C", hash_generated_field = "8EB481EDAD2FDE318A05890E655F5C10")

        public  Activity activity;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.899 -0500", hash_original_method = "4F41670063BD951D72DDB0235971893F", hash_generated_method = "C2A3F3A48843D2319495A781014EB5D7")
        
public ActivityIntentInfo(Activity _activity) {
            activity = _activity;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.901 -0500", hash_original_method = "7C91146E1C4D7077E2D0C55B0D43BF57", hash_generated_method = "A24CD2F8FC6E076CDD69BB140A302B53")
        
public String toString() {
            return "ActivityIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + activity.info.name + "}";
        }
        
    }
    
    public final static class ServiceIntentInfo extends IntentInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.906 -0500", hash_original_field = "DAF7782A22985FD2AACE76C8B2915B0A", hash_generated_field = "6630E432AFBDE1086EB9C8736D3C1E75")

        public  Service service;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.909 -0500", hash_original_method = "2C256432D4530E0F15F4AED85D9A44A0", hash_generated_method = "8EF5E3E54913D94DA3A92574C6AB0AE5")
        
public ServiceIntentInfo(Service _service) {
            service = _service;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.911 -0500", hash_original_method = "32EA4E8A8FC07DAD01188F341ACB2C51", hash_generated_method = "6DBC2C25F40C263EE60C3F88A91AEA89")
        
public String toString() {
            return "ServiceIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + service.info.name + "}";
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.475 -0500", hash_original_method = "65A62D9388B66A4D9595CDAEE2873A09", hash_generated_method = "CC71CA105151E3A0E7A4629E80ADA1A8")
    
public void setSeparateProcesses(String[] procs) {
        mSeparateProcesses = procs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.477 -0500", hash_original_method = "14C9699FDDD05F8B9AF1818DB0942037", hash_generated_method = "29C23CEBD9882AF24DFDB89D5E196F86")
    
public void setOnlyCoreApps(boolean onlyCoreApps) {
        mOnlyCoreApps = onlyCoreApps;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.488 -0500", hash_original_method = "83F32E741E7740326FB3ACF1CABD2263", hash_generated_method = "EA7E84D1A3E04766A30C1A10508EB1C5")
    
private Certificate[] loadCertificates(JarFile jarFile, JarEntry je,
            byte[] readBuffer) {
        try {
            // We must read the stream for the JarEntry to retrieve
            // its certificates.
            InputStream is = new BufferedInputStream(jarFile.getInputStream(je));
            while (is.read(readBuffer, 0, readBuffer.length) != -1) {
                // not using
            }
            is.close();
            return je != null ? je.getCertificates() : null;
        } catch (IOException e) {
            Slog.w(TAG, "Exception reading " + je.getName() + " in "
                    + jarFile.getName(), e);
        } catch (RuntimeException e) {
            Slog.w(TAG, "Exception reading " + je.getName() + " in "
                    + jarFile.getName(), e);
        }
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.507 -0500", hash_original_method = "043AC7F11A9C5FD11FB43AEF955AD87D", hash_generated_method = "DE8BF7F7DCE49FE7538FB3BCFB426F39")
    
public int getParseError() {
        return mParseError;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.512 -0500", hash_original_method = "F8C0CFF9FE003FD5724E792D5942913B", hash_generated_method = "A47DDA58449A40160CE7B72AA0A61BBD")
    
public Package parsePackage(File sourceFile, String destCodePath,
            DisplayMetrics metrics, int flags) {
        mParseError = PackageManager.INSTALL_SUCCEEDED;

        mArchiveSourcePath = sourceFile.getPath();
        if (!sourceFile.isFile()) {
            Slog.w(TAG, "Skipping dir: " + mArchiveSourcePath);
            mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
            return null;
        }
        if (!isPackageFilename(sourceFile.getName())
                && (flags&PARSE_MUST_BE_APK) != 0) {
            if ((flags&PARSE_IS_SYSTEM) == 0) {
                // We expect to have non-.apk files in the system dir,
                // so don't warn about them.
                Slog.w(TAG, "Skipping non-package file: " + mArchiveSourcePath);
            }
            mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
            return null;
        }

        if (DEBUG_JAR)
            Slog.d(TAG, "Scanning package: " + mArchiveSourcePath);

        XmlResourceParser parser = null;
        AssetManager assmgr = null;
        Resources res = null;
        boolean assetError = true;
        try {
            assmgr = new AssetManager();
            int cookie = assmgr.addAssetPath(mArchiveSourcePath);
            if (cookie != 0) {
                res = new Resources(assmgr, metrics, null);
                assmgr.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        Build.VERSION.RESOURCES_SDK_INT);
                parser = assmgr.openXmlResourceParser(cookie, ANDROID_MANIFEST_FILENAME);
                assetError = false;
            } else {
                Slog.w(TAG, "Failed adding asset path:"+mArchiveSourcePath);
            }
        } catch (Exception e) {
            Slog.w(TAG, "Unable to read AndroidManifest.xml of "
                    + mArchiveSourcePath, e);
        }
        if (assetError) {
            if (assmgr != null) assmgr.close();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST;
            return null;
        }
        String[] errorText = new String[1];
        Package pkg = null;
        Exception errorException = null;
        try {
            // XXXX todo: need to figure out correct configuration.
            pkg = parsePackage(res, parser, flags, errorText);
        } catch (Exception e) {
            errorException = e;
            mParseError = PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
        }

        if (pkg == null) {
            // If we are only parsing core apps, then a null with INSTALL_SUCCEEDED
            // just means to skip this app so don't make a fuss about it.
            if (!mOnlyCoreApps || mParseError != PackageManager.INSTALL_SUCCEEDED) {
                if (errorException != null) {
                    Slog.w(TAG, mArchiveSourcePath, errorException);
                } else {
                    Slog.w(TAG, mArchiveSourcePath + " (at "
                            + parser.getPositionDescription()
                            + "): " + errorText[0]);
                }
                if (mParseError == PackageManager.INSTALL_SUCCEEDED) {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                }
            }
            parser.close();
            assmgr.close();
            return null;
        }

        parser.close();
        assmgr.close();

        // Set code and resource paths
        pkg.mPath = destCodePath;
        pkg.mScanPath = mArchiveSourcePath;
        //pkg.applicationInfo.sourceDir = destCodePath;
        //pkg.applicationInfo.publicSourceDir = destRes;
        pkg.mSignatures = null;

        return pkg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.517 -0500", hash_original_method = "19D0E628AA10FC207BA0D548739FDEDB", hash_generated_method = "21AB05D8E5D5949D816C1714D943A498")
    
public boolean collectCertificates(Package pkg, int flags) {
        pkg.mSignatures = null;

        WeakReference<byte[]> readBufferRef;
        byte[] readBuffer = null;
        synchronized (mSync) {
            readBufferRef = mReadBuffer;
            if (readBufferRef != null) {
                mReadBuffer = null;
                readBuffer = readBufferRef.get();
            }
            if (readBuffer == null) {
                readBuffer = new byte[8192];
                readBufferRef = new WeakReference<byte[]>(readBuffer);
            }
        }

        try {
            JarFile jarFile = new JarFile(mArchiveSourcePath);

            Certificate[] certs = null;

            if ((flags&PARSE_IS_SYSTEM) != 0) {
                // If this package comes from the system image, then we
                // can trust it...  we'll just use the AndroidManifest.xml
                // to retrieve its signatures, not validating all of the
                // files.
                JarEntry jarEntry = jarFile.getJarEntry(ANDROID_MANIFEST_FILENAME);
                certs = loadCertificates(jarFile, jarEntry, readBuffer);
                if (certs == null) {
                    Slog.e(TAG, "Package " + pkg.packageName
                            + " has no certificates at entry "
                            + jarEntry.getName() + "; ignoring!");
                    jarFile.close();
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                    return false;
                }
                if (DEBUG_JAR) {
                    Slog.i(TAG, "File " + mArchiveSourcePath + ": entry=" + jarEntry
                            + " certs=" + (certs != null ? certs.length : 0));
                    if (certs != null) {
                        final int N = certs.length;
                        for (int i=0; i<N; i++) {
                            Slog.i(TAG, "  Public key: "
                                    + certs[i].getPublicKey().getEncoded()
                                    + " " + certs[i].getPublicKey());
                        }
                    }
                }
            } else {
                Enumeration<JarEntry> entries = jarFile.entries();
                final Manifest manifest = jarFile.getManifest();
                while (entries.hasMoreElements()) {
                    final JarEntry je = entries.nextElement();
                    if (je.isDirectory()) continue;

                    final String name = je.getName();

                    if (name.startsWith("META-INF/"))
                        continue;

                    if (ANDROID_MANIFEST_FILENAME.equals(name)) {
                        final Attributes attributes = manifest.getAttributes(name);
                        pkg.manifestDigest = ManifestDigest.fromAttributes(attributes);
                    }

                    final Certificate[] localCerts = loadCertificates(jarFile, je, readBuffer);
                    if (DEBUG_JAR) {
                        Slog.i(TAG, "File " + mArchiveSourcePath + " entry " + je.getName()
                                + ": certs=" + certs + " ("
                                + (certs != null ? certs.length : 0) + ")");
                    }

                    if (localCerts == null) {
                        Slog.e(TAG, "Package " + pkg.packageName
                                + " has no certificates at entry "
                                + je.getName() + "; ignoring!");
                        jarFile.close();
                        mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                        return false;
                    } else if (certs == null) {
                        certs = localCerts;
                    } else {
                        // Ensure all certificates match.
                        for (int i=0; i<certs.length; i++) {
                            boolean found = false;
                            for (int j=0; j<localCerts.length; j++) {
                                if (certs[i] != null &&
                                        certs[i].equals(localCerts[j])) {
                                    found = true;
                                    break;
                                }
                            }
                            if (!found || certs.length != localCerts.length) {
                                Slog.e(TAG, "Package " + pkg.packageName
                                        + " has mismatched certificates at entry "
                                        + je.getName() + "; ignoring!");
                                jarFile.close();
                                mParseError = PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES;
                                return false;
                            }
                        }
                    }
                }
            }
            jarFile.close();

            synchronized (mSync) {
                mReadBuffer = readBufferRef;
            }

            if (certs != null && certs.length > 0) {
                final int N = certs.length;
                pkg.mSignatures = new Signature[certs.length];
                for (int i=0; i<N; i++) {
                    pkg.mSignatures[i] = new Signature(
                            certs[i].getEncoded());
                }
            } else {
                Slog.e(TAG, "Package " + pkg.packageName
                        + " has no certificates; ignoring!");
                mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                return false;
            }
        } catch (CertificateEncodingException e) {
            Slog.w(TAG, "Exception reading " + mArchiveSourcePath, e);
            mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
            return false;
        } catch (IOException e) {
            Slog.w(TAG, "Exception reading " + mArchiveSourcePath, e);
            mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
            return false;
        } catch (RuntimeException e) {
            Slog.w(TAG, "Exception reading " + mArchiveSourcePath, e);
            mParseError = PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
            return false;
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.545 -0500", hash_original_method = "91CC6CEE84025557458760F97B90CD2F", hash_generated_method = "C733FE6A9F635C74B2195608DF6B6962")
    
private Package parsePackage(
        Resources res, XmlResourceParser parser, int flags, String[] outError)
        throws XmlPullParserException, IOException {
        AttributeSet attrs = parser;

        mParseInstrumentationArgs = null;
        mParseActivityArgs = null;
        mParseServiceArgs = null;
        mParseProviderArgs = null;
        
        String pkgName = parsePackageName(parser, attrs, flags, outError);
        if (pkgName == null) {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME;
            return null;
        }
        int type;

        if (mOnlyCoreApps) {
            boolean core = attrs.getAttributeBooleanValue(null, "coreApp", false);
            if (!core) {
                mParseError = PackageManager.INSTALL_SUCCEEDED;
                return null;
            }
        }

        final Package pkg = new Package(pkgName);
        boolean foundApp = false;
        
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifest);
        pkg.mVersionCode = sa.getInteger(
                com.android.internal.R.styleable.AndroidManifest_versionCode, 0);
        pkg.mVersionName = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifest_versionName, 0);
        if (pkg.mVersionName != null) {
            pkg.mVersionName = pkg.mVersionName.intern();
        }
        String str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifest_sharedUserId, 0);
        if (str != null && str.length() > 0) {
            String nameError = validateName(str, true);
            if (nameError != null && !"android".equals(pkgName)) {
                outError[0] = "<manifest> specifies bad sharedUserId name \""
                    + str + "\": " + nameError;
                mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID;
                return null;
            }
            pkg.mSharedUserId = str.intern();
            pkg.mSharedUserLabel = sa.getResourceId(
                    com.android.internal.R.styleable.AndroidManifest_sharedUserLabel, 0);
        }
        sa.recycle();

        pkg.installLocation = sa.getInteger(
                com.android.internal.R.styleable.AndroidManifest_installLocation,
                PARSE_DEFAULT_INSTALL_LOCATION);
        pkg.applicationInfo.installLocation = pkg.installLocation;
        
        // Resource boolean are -1, so 1 means we don't know the value.
        int supportsSmallScreens = 1;
        int supportsNormalScreens = 1;
        int supportsLargeScreens = 1;
        int supportsXLargeScreens = 1;
        int resizeable = 1;
        int anyDensity = 1;
        
        int outerDepth = parser.getDepth();
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            String tagName = parser.getName();
            if (tagName.equals("application")) {
                if (foundApp) {
                    if (RIGID_PARSER) {
                        outError[0] = "<manifest> has more than one <application>";
                        mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return null;
                    } else {
                        Slog.w(TAG, "<manifest> has more than one <application>");
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    }
                }

                foundApp = true;
                if (!parseApplication(pkg, res, parser, attrs, flags, outError)) {
                    return null;
                }
            } else if (tagName.equals("permission-group")) {
                if (parsePermissionGroup(pkg, res, parser, attrs, outError) == null) {
                    return null;
                }
            } else if (tagName.equals("permission")) {
                if (parsePermission(pkg, res, parser, attrs, outError) == null) {
                    return null;
                }
            } else if (tagName.equals("permission-tree")) {
                if (parsePermissionTree(pkg, res, parser, attrs, outError) == null) {
                    return null;
                }
            } else if (tagName.equals("uses-permission")) {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesPermission);

                // Note: don't allow this value to be a reference to a resource
                // that may change.
                String name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesPermission_name);

                sa.recycle();

                if (name != null && !pkg.requestedPermissions.contains(name)) {
                    pkg.requestedPermissions.add(name.intern());
                }

                XmlUtils.skipCurrentTag(parser);

            } else if (tagName.equals("uses-configuration")) {
                ConfigurationInfo cPref = new ConfigurationInfo();
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration);
                cPref.reqTouchScreen = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqTouchScreen,
                        Configuration.TOUCHSCREEN_UNDEFINED);
                cPref.reqKeyboardType = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqKeyboardType,
                        Configuration.KEYBOARD_UNDEFINED);
                if (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqHardKeyboard,
                        false)) {
                    cPref.reqInputFeatures |= ConfigurationInfo.INPUT_FEATURE_HARD_KEYBOARD;
                }
                cPref.reqNavigation = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqNavigation,
                        Configuration.NAVIGATION_UNDEFINED);
                if (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqFiveWayNav,
                        false)) {
                    cPref.reqInputFeatures |= ConfigurationInfo.INPUT_FEATURE_FIVE_WAY_NAV;
                }
                sa.recycle();
                pkg.configPreferences.add(cPref);

                XmlUtils.skipCurrentTag(parser);

            } else if (tagName.equals("uses-feature")) {
                FeatureInfo fi = new FeatureInfo();
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesFeature);
                // Note: don't allow this value to be a reference to a resource
                // that may change.
                fi.name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesFeature_name);
                if (fi.name == null) {
                    fi.reqGlEsVersion = sa.getInt(
                            com.android.internal.R.styleable.AndroidManifestUsesFeature_glEsVersion,
                            FeatureInfo.GL_ES_VERSION_UNDEFINED);
                }
                if (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesFeature_required,
                        true)) {
                    fi.flags |= FeatureInfo.FLAG_REQUIRED;
                }
                sa.recycle();
                if (pkg.reqFeatures == null) {
                    pkg.reqFeatures = new ArrayList<FeatureInfo>();
                }
                pkg.reqFeatures.add(fi);
                
                if (fi.name == null) {
                    ConfigurationInfo cPref = new ConfigurationInfo();
                    cPref.reqGlEsVersion = fi.reqGlEsVersion;
                    pkg.configPreferences.add(cPref);
                }

                XmlUtils.skipCurrentTag(parser);

            } else if (tagName.equals("uses-sdk")) {
                if (SDK_VERSION > 0) {
                    sa = res.obtainAttributes(attrs,
                            com.android.internal.R.styleable.AndroidManifestUsesSdk);

                    int minVers = 0;
                    String minCode = null;
                    int targetVers = 0;
                    String targetCode = null;
                    
                    TypedValue val = sa.peekValue(
                            com.android.internal.R.styleable.AndroidManifestUsesSdk_minSdkVersion);
                    if (val != null) {
                        if (val.type == TypedValue.TYPE_STRING && val.string != null) {
                            targetCode = minCode = val.string.toString();
                        } else {
                            // If it's not a string, it's an integer.
                            targetVers = minVers = val.data;
                        }
                    }
                    
                    val = sa.peekValue(
                            com.android.internal.R.styleable.AndroidManifestUsesSdk_targetSdkVersion);
                    if (val != null) {
                        if (val.type == TypedValue.TYPE_STRING && val.string != null) {
                            targetCode = minCode = val.string.toString();
                        } else {
                            // If it's not a string, it's an integer.
                            targetVers = val.data;
                        }
                    }
                    
                    sa.recycle();

                    if (minCode != null) {
                        if (!minCode.equals(SDK_CODENAME)) {
                            if (SDK_CODENAME != null) {
                                outError[0] = "Requires development platform " + minCode
                                        + " (current platform is " + SDK_CODENAME + ")";
                            } else {
                                outError[0] = "Requires development platform " + minCode
                                        + " but this is a release platform.";
                            }
                            mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
                            return null;
                        }
                    } else if (minVers > SDK_VERSION) {
                        outError[0] = "Requires newer sdk version #" + minVers
                                + " (current version is #" + SDK_VERSION + ")";
                        mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
                        return null;
                    }
                    
                    if (targetCode != null) {
                        if (!targetCode.equals(SDK_CODENAME)) {
                            if (SDK_CODENAME != null) {
                                outError[0] = "Requires development platform " + targetCode
                                        + " (current platform is " + SDK_CODENAME + ")";
                            } else {
                                outError[0] = "Requires development platform " + targetCode
                                        + " but this is a release platform.";
                            }
                            mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
                            return null;
                        }
                        // If the code matches, it definitely targets this SDK.
                        pkg.applicationInfo.targetSdkVersion
                                = android.os.Build.VERSION_CODES.CUR_DEVELOPMENT;
                    } else {
                        pkg.applicationInfo.targetSdkVersion = targetVers;
                    }
                }

                XmlUtils.skipCurrentTag(parser);

            } else if (tagName.equals("supports-screens")) {
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

                // This is a trick to get a boolean and still able to detect
                // if a value was actually set.
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
                
            } else if (tagName.equals("protected-broadcast")) {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestProtectedBroadcast);

                // Note: don't allow this value to be a reference to a resource
                // that may change.
                String name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestProtectedBroadcast_name);

                sa.recycle();

                if (name != null && (flags&PARSE_IS_SYSTEM) != 0) {
                    if (pkg.protectedBroadcasts == null) {
                        pkg.protectedBroadcasts = new ArrayList<String>();
                    }
                    if (!pkg.protectedBroadcasts.contains(name)) {
                        pkg.protectedBroadcasts.add(name.intern());
                    }
                }

                XmlUtils.skipCurrentTag(parser);
                
            } else if (tagName.equals("instrumentation")) {
                if (parseInstrumentation(pkg, res, parser, attrs, outError) == null) {
                    return null;
                }
                
            } else if (tagName.equals("original-package")) {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage);

                String orig =sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage_name, 0);
                if (!pkg.packageName.equals(orig)) {
                    if (pkg.mOriginalPackages == null) {
                        pkg.mOriginalPackages = new ArrayList<String>();
                        pkg.mRealPackage = pkg.packageName;
                    }
                    pkg.mOriginalPackages.add(orig);
                }

                sa.recycle();

                XmlUtils.skipCurrentTag(parser);
                
            } else if (tagName.equals("adopt-permissions")) {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage);

                String name = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage_name, 0);

                sa.recycle();

                if (name != null) {
                    if (pkg.mAdoptPermissions == null) {
                        pkg.mAdoptPermissions = new ArrayList<String>();
                    }
                    pkg.mAdoptPermissions.add(name);
                }

                XmlUtils.skipCurrentTag(parser);
                
            } else if (tagName.equals("uses-gl-texture")) {
                // Just skip this tag
                XmlUtils.skipCurrentTag(parser);
                continue;
                
            } else if (tagName.equals("compatible-screens")) {
                // Just skip this tag
                XmlUtils.skipCurrentTag(parser);
                continue;
                
            } else if (tagName.equals("eat-comment")) {
                // Just skip this tag
                XmlUtils.skipCurrentTag(parser);
                continue;
                
            } else if (RIGID_PARSER) {
                outError[0] = "Bad element under <manifest>: "
                    + parser.getName();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                return null;

            } else {
                Slog.w(TAG, "Unknown element under <manifest>: " + parser.getName()
                        + " at " + mArchiveSourcePath + " "
                        + parser.getPositionDescription());
                XmlUtils.skipCurrentTag(parser);
                continue;
            }
        }

        if (!foundApp && pkg.instrumentation.size() == 0) {
            outError[0] = "<manifest> does not contain an <application> or <instrumentation>";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_EMPTY;
        }

        final int NP = PackageParser.NEW_PERMISSIONS.length;
        StringBuilder implicitPerms = null;
        for (int ip=0; ip<NP; ip++) {
            final PackageParser.NewPermissionInfo npi
                    = PackageParser.NEW_PERMISSIONS[ip];
            if (pkg.applicationInfo.targetSdkVersion >= npi.sdkVersion) {
                break;
            }
            if (!pkg.requestedPermissions.contains(npi.name)) {
                if (implicitPerms == null) {
                    implicitPerms = new StringBuilder(128);
                    implicitPerms.append(pkg.packageName);
                    implicitPerms.append(": compat added ");
                } else {
                    implicitPerms.append(' ');
                }
                implicitPerms.append(npi.name);
                pkg.requestedPermissions.add(npi.name);
            }
        }
        if (implicitPerms != null) {
            Slog.i(TAG, implicitPerms.toString());
        }
        
        if (supportsSmallScreens < 0 || (supportsSmallScreens > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT)) {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_SMALL_SCREENS;
        }
        if (supportsNormalScreens != 0) {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_NORMAL_SCREENS;
        }
        if (supportsLargeScreens < 0 || (supportsLargeScreens > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT)) {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS;
        }
        if (supportsXLargeScreens < 0 || (supportsXLargeScreens > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.GINGERBREAD)) {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS;
        }
        if (resizeable < 0 || (resizeable > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT)) {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_RESIZEABLE_FOR_SCREENS;
        }
        if (anyDensity < 0 || (anyDensity > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT)) {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES;
        }

        return pkg;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.559 -0500", hash_original_method = "E3395575DA3BE4CF83D20AFB0193668F", hash_generated_method = "5118BC338C07A7BCCD50EDD033433D16")
    
private PermissionGroup parsePermissionGroup(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError)
        throws XmlPullParserException, IOException {
        PermissionGroup perm = new PermissionGroup(owner);

        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup);

        if (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-group>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_name,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_label,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_logo)) {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        perm.info.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_description,
                0);

        sa.recycle();
        
        if (!parseAllMetaData(res, parser, attrs, "<permission-group>", perm,
                outError)) {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        owner.permissionGroups.add(perm);

        return perm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.562 -0500", hash_original_method = "1D11570A32C6A271E593822206F9BD54", hash_generated_method = "B48AB1A7DC848D7C286E3798A1BD5884")
    
private Permission parsePermission(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError)
        throws XmlPullParserException, IOException {
        Permission perm = new Permission(owner);

        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermission);

        if (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission>", sa,
                com.android.internal.R.styleable.AndroidManifestPermission_name,
                com.android.internal.R.styleable.AndroidManifestPermission_label,
                com.android.internal.R.styleable.AndroidManifestPermission_icon,
                com.android.internal.R.styleable.AndroidManifestPermission_logo)) {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        // Note: don't allow this value to be a reference to a resource
        // that may change.
        perm.info.group = sa.getNonResourceString(
                com.android.internal.R.styleable.AndroidManifestPermission_permissionGroup);
        if (perm.info.group != null) {
            perm.info.group = perm.info.group.intern();
        }
        
        perm.info.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestPermission_description,
                0);

        perm.info.protectionLevel = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestPermission_protectionLevel,
                PermissionInfo.PROTECTION_NORMAL);

        sa.recycle();
        
        if (perm.info.protectionLevel == -1) {
            outError[0] = "<permission> does not specify protectionLevel";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
        
        if (!parseAllMetaData(res, parser, attrs, "<permission>", perm,
                outError)) {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        owner.permissions.add(perm);

        return perm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.565 -0500", hash_original_method = "BAA3C6F5A9B5CEE097497C276EDD624D", hash_generated_method = "9A3462B2AAB00D8B345E60990E32D35A")
    
private Permission parsePermissionTree(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError)
        throws XmlPullParserException, IOException {
        Permission perm = new Permission(owner);

        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionTree);

        if (!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-tree>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_name,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_label,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_logo)) {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        sa.recycle();
        
        int index = perm.info.name.indexOf('.');
        if (index > 0) {
            index = perm.info.name.indexOf('.', index+1);
        }
        if (index < 0) {
            outError[0] = "<permission-tree> name has less than three segments: "
                + perm.info.name;
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        perm.info.descriptionRes = 0;
        perm.info.protectionLevel = PermissionInfo.PROTECTION_NORMAL;
        perm.tree = true;

        if (!parseAllMetaData(res, parser, attrs, "<permission-tree>", perm,
                outError)) {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        owner.permissions.add(perm);

        return perm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.569 -0500", hash_original_method = "77B98478A5AAF7EC4E5B725BE9FDC9E7", hash_generated_method = "6F529F66FF8E579C76ED8B1597ED6FF8")
    
private Instrumentation parseInstrumentation(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError)
        throws XmlPullParserException, IOException {
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestInstrumentation);

        if (mParseInstrumentationArgs == null) {
            mParseInstrumentationArgs = new ParsePackageItemArgs(owner, outError,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_name,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_label,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_icon,
                    com.android.internal.R.styleable.AndroidManifestInstrumentation_logo);
            mParseInstrumentationArgs.tag = "<instrumentation>";
        }
        
        mParseInstrumentationArgs.sa = sa;
        
        Instrumentation a = new Instrumentation(mParseInstrumentationArgs,
                new InstrumentationInfo());
        if (outError[0] != null) {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        String str;
        // Note: don't allow this value to be a reference to a resource
        // that may change.
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

        if (a.info.targetPackage == null) {
            outError[0] = "<instrumentation> does not specify targetPackage";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        if (!parseAllMetaData(res, parser, attrs, "<instrumentation>", a,
                outError)) {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }

        owner.instrumentation.add(a);

        return a;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.577 -0500", hash_original_method = "3784AF975EC3AF37D03EE1A91A900A73", hash_generated_method = "FA2001D6A612F74029CB0AB0E4C30083")
    
private boolean parseApplication(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError)
        throws XmlPullParserException, IOException {
        final ApplicationInfo ai = owner.applicationInfo;
        final String pkgName = owner.applicationInfo.packageName;

        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestApplication);

        String name = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_name, 0);
        if (name != null) {
            ai.className = buildClassName(pkgName, name, outError);
            if (ai.className == null) {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                return false;
            }
        }

        String manageSpaceActivity = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_manageSpaceActivity, 0);
        if (manageSpaceActivity != null) {
            ai.manageSpaceActivityName = buildClassName(pkgName, manageSpaceActivity,
                    outError);
        }

        boolean allowBackup = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowBackup, true);
        if (allowBackup) {
            ai.flags |= ApplicationInfo.FLAG_ALLOW_BACKUP;

            // backupAgent, killAfterRestore, and restoreAnyVersion are only relevant
            // if backup is possible for the given application.
            String backupAgent = sa.getNonConfigurationString(
                    com.android.internal.R.styleable.AndroidManifestApplication_backupAgent, 0);
            if (backupAgent != null) {
                ai.backupAgentName = buildClassName(pkgName, backupAgent, outError);
                if (DEBUG_BACKUP) {
                    Slog.v(TAG, "android:backupAgent = " + ai.backupAgentName
                            + " from " + pkgName + "+" + backupAgent);
                }

                if (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_killAfterRestore,
                        true)) {
                    ai.flags |= ApplicationInfo.FLAG_KILL_AFTER_RESTORE;
                }
                if (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_restoreAnyVersion,
                        false)) {
                    ai.flags |= ApplicationInfo.FLAG_RESTORE_ANY_VERSION;
                }
            }
        }

        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestApplication_label);
        if (v != null && (ai.labelRes=v.resourceId) == 0) {
            ai.nonLocalizedLabel = v.coerceToString();
        }

        ai.icon = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_icon, 0);
        ai.logo = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_logo, 0);
        ai.theme = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_theme, 0);
        ai.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestApplication_description, 0);

        if ((flags&PARSE_IS_SYSTEM) != 0) {
            if (sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestApplication_persistent,
                    false)) {
                ai.flags |= ApplicationInfo.FLAG_PERSISTENT;
            }
        }

        if ((flags & PARSE_FORWARD_LOCK) != 0) {
            ai.flags |= ApplicationInfo.FLAG_FORWARD_LOCK;
        }

        if ((flags & PARSE_ON_SDCARD) != 0) {
            ai.flags |= ApplicationInfo.FLAG_EXTERNAL_STORAGE;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_debuggable,
                false)) {
            ai.flags |= ApplicationInfo.FLAG_DEBUGGABLE;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_vmSafeMode,
                false)) {
            ai.flags |= ApplicationInfo.FLAG_VM_SAFE_MODE;
        }

        boolean hardwareAccelerated = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_hardwareAccelerated,
                owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.ICE_CREAM_SANDWICH);

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_hasCode,
                true)) {
            ai.flags |= ApplicationInfo.FLAG_HAS_CODE;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowTaskReparenting,
                false)) {
            ai.flags |= ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowClearUserData,
                true)) {
            ai.flags |= ApplicationInfo.FLAG_ALLOW_CLEAR_USER_DATA;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_testOnly,
                false)) {
            ai.flags |= ApplicationInfo.FLAG_TEST_ONLY;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_largeHeap,
                false)) {
            ai.flags |= ApplicationInfo.FLAG_LARGE_HEAP;
        }

        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_permission, 0);
        ai.permission = (str != null && str.length() > 0) ? str.intern() : null;

        if (owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.FROYO) {
            str = sa.getNonConfigurationString(
                    com.android.internal.R.styleable.AndroidManifestApplication_taskAffinity, 0);
        } else {
            // Some older apps have been seen to use a resource reference
            // here that on older builds was ignored (with a warning).  We
            // need to continue to do this for them so they don't break.
            str = sa.getNonResourceString(
                    com.android.internal.R.styleable.AndroidManifestApplication_taskAffinity);
        }
        ai.taskAffinity = buildTaskAffinityName(ai.packageName, ai.packageName,
                str, outError);

        if (outError[0] == null) {
            CharSequence pname;
            if (owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.FROYO) {
                pname = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestApplication_process, 0);
            } else {
                // Some older apps have been seen to use a resource reference
                // here that on older builds was ignored (with a warning).  We
                // need to continue to do this for them so they don't break.
                pname = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestApplication_process);
            }
            ai.processName = buildProcessName(ai.packageName, null, pname,
                    flags, mSeparateProcesses, outError);
    
            ai.enabled = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestApplication_enabled, true);
            
            if (false) {
                if (sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_cantSaveState,
                        false)) {
                    ai.flags |= ApplicationInfo.FLAG_CANT_SAVE_STATE;

                    // A heavy-weight application can not be in a custom process.
                    // We can do direct compare because we intern all strings.
                    if (ai.processName != null && ai.processName != ai.packageName) {
                        outError[0] = "cantSaveState applications can not use custom processes";
                    }
                }
            }
        }

        ai.uiOptions = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestApplication_uiOptions, 0);

        sa.recycle();

        if (outError[0] != null) {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return false;
        }

        final int innerDepth = parser.getDepth();

        int type;
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            String tagName = parser.getName();
            if (tagName.equals("activity")) {
                Activity a = parseActivity(owner, res, parser, attrs, flags, outError, false,
                        hardwareAccelerated);
                if (a == null) {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    return false;
                }

                owner.activities.add(a);

            } else if (tagName.equals("receiver")) {
                Activity a = parseActivity(owner, res, parser, attrs, flags, outError, true, false);
                if (a == null) {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    return false;
                }

                owner.receivers.add(a);

            } else if (tagName.equals("service")) {
                Service s = parseService(owner, res, parser, attrs, flags, outError);
                if (s == null) {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    return false;
                }

                owner.services.add(s);

            } else if (tagName.equals("provider")) {
                Provider p = parseProvider(owner, res, parser, attrs, flags, outError);
                if (p == null) {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    return false;
                }

                owner.providers.add(p);

            } else if (tagName.equals("activity-alias")) {
                Activity a = parseActivityAlias(owner, res, parser, attrs, flags, outError);
                if (a == null) {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    return false;
                }

                owner.activities.add(a);

            } else if (parser.getName().equals("meta-data")) {
                // note: application meta-data is stored off to the side, so it can
                // remain null in the primary copy (we like to avoid extra copies because
                // it can be large)
                if ((owner.mAppMetaData = parseMetaData(res, parser, attrs, owner.mAppMetaData,
                        outError)) == null) {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    return false;
                }

            } else if (tagName.equals("uses-library")) {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary);

                // Note: don't allow this value to be a reference to a resource
                // that may change.
                String lname = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary_name);
                boolean req = sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary_required,
                        true);

                sa.recycle();

                if (lname != null) {
                    if (req) {
                        if (owner.usesLibraries == null) {
                            owner.usesLibraries = new ArrayList<String>();
                        }
                        if (!owner.usesLibraries.contains(lname)) {
                            owner.usesLibraries.add(lname.intern());
                        }
                    } else {
                        if (owner.usesOptionalLibraries == null) {
                            owner.usesOptionalLibraries = new ArrayList<String>();
                        }
                        if (!owner.usesOptionalLibraries.contains(lname)) {
                            owner.usesOptionalLibraries.add(lname.intern());
                        }
                    }
                }

                XmlUtils.skipCurrentTag(parser);

            } else if (tagName.equals("uses-package")) {
                // Dependencies for app installers; we don't currently try to
                // enforce this.
                XmlUtils.skipCurrentTag(parser);

            } else {
                if (!RIGID_PARSER) {
                    Slog.w(TAG, "Unknown element under <application>: " + tagName
                            + " at " + mArchiveSourcePath + " "
                            + parser.getPositionDescription());
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } else {
                    outError[0] = "Bad element under <application>: " + tagName;
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    return false;
                }
            }
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.581 -0500", hash_original_method = "63CFF58BE3C03EE3AAF09BEB17B3529D", hash_generated_method = "4A9A9E645FDBE614932224E799649AE5")
    
private boolean parsePackageItemInfo(Package owner, PackageItemInfo outInfo,
            String[] outError, String tag, TypedArray sa,
            int nameRes, int labelRes, int iconRes, int logoRes) {
        String name = sa.getNonConfigurationString(nameRes, 0);
        if (name == null) {
            outError[0] = tag + " does not specify android:name";
            return false;
        }

        outInfo.name
            = buildClassName(owner.applicationInfo.packageName, name, outError);
        if (outInfo.name == null) {
            return false;
        }

        int iconVal = sa.getResourceId(iconRes, 0);
        if (iconVal != 0) {
            outInfo.icon = iconVal;
            outInfo.nonLocalizedLabel = null;
        }
        
        int logoVal = sa.getResourceId(logoRes, 0);
        if (logoVal != 0) {
            outInfo.logo = logoVal;
        }

        TypedValue v = sa.peekValue(labelRes);
        if (v != null && (outInfo.labelRes=v.resourceId) == 0) {
            outInfo.nonLocalizedLabel = v.coerceToString();
        }

        outInfo.packageName = owner.packageName;

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.587 -0500", hash_original_method = "5541C23C630FF3AC70030479982C4C1F", hash_generated_method = "61B2ABEDD1EBE5D9CA873F6DA7F29935")
    
private Activity parseActivity(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError,
            boolean receiver, boolean hardwareAccelerated)
            throws XmlPullParserException, IOException {
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestActivity);

        if (mParseActivityArgs == null) {
            mParseActivityArgs = new ParseComponentArgs(owner, outError,
                    com.android.internal.R.styleable.AndroidManifestActivity_name,
                    com.android.internal.R.styleable.AndroidManifestActivity_label,
                    com.android.internal.R.styleable.AndroidManifestActivity_icon,
                    com.android.internal.R.styleable.AndroidManifestActivity_logo,
                    mSeparateProcesses,
                    com.android.internal.R.styleable.AndroidManifestActivity_process,
                    com.android.internal.R.styleable.AndroidManifestActivity_description,
                    com.android.internal.R.styleable.AndroidManifestActivity_enabled);
        }
        
        mParseActivityArgs.tag = receiver ? "<receiver>" : "<activity>";
        mParseActivityArgs.sa = sa;
        mParseActivityArgs.flags = flags;
        
        Activity a = new Activity(mParseActivityArgs, new ActivityInfo());
        if (outError[0] != null) {
            sa.recycle();
            return null;
        }

        final boolean setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestActivity_exported);
        if (setExported) {
            a.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivity_exported, false);
        }

        a.info.theme = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestActivity_theme, 0);

        a.info.uiOptions = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestActivity_uiOptions,
                a.info.applicationInfo.uiOptions);

        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivity_permission, 0);
        if (str == null) {
            a.info.permission = owner.applicationInfo.permission;
        } else {
            a.info.permission = str.length() > 0 ? str.toString().intern() : null;
        }

        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivity_taskAffinity, 0);
        a.info.taskAffinity = buildTaskAffinityName(owner.applicationInfo.packageName,
                owner.applicationInfo.taskAffinity, str, outError);

        a.info.flags = 0;
        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_multiprocess,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_MULTIPROCESS;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnTaskLaunch,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_FINISH_ON_TASK_LAUNCH;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_clearTaskOnLaunch,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_CLEAR_TASK_ON_LAUNCH;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_noHistory,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_NO_HISTORY;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_alwaysRetainTaskState,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_ALWAYS_RETAIN_TASK_STATE;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_stateNotNeeded,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_STATE_NOT_NEEDED;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_excludeFromRecents,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_EXCLUDE_FROM_RECENTS;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_allowTaskReparenting,
                (owner.applicationInfo.flags&ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING) != 0)) {
            a.info.flags |= ActivityInfo.FLAG_ALLOW_TASK_REPARENTING;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnCloseSystemDialogs,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS;
        }

        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_immersive,
                false)) {
            a.info.flags |= ActivityInfo.FLAG_IMMERSIVE;
        }
        
        if (!receiver) {
            if (sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivity_hardwareAccelerated,
                    hardwareAccelerated)) {
                a.info.flags |= ActivityInfo.FLAG_HARDWARE_ACCELERATED;
            }

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
        } else {
            a.info.launchMode = ActivityInfo.LAUNCH_MULTIPLE;
            a.info.configChanges = 0;
        }

        sa.recycle();

        if (receiver && (owner.applicationInfo.flags&ApplicationInfo.FLAG_CANT_SAVE_STATE) != 0) {
            // A heavy-weight application can not have receives in its main process
            // We can do direct compare because we intern all strings.
            if (a.info.processName == owner.packageName) {
                outError[0] = "Heavy-weight applications can not have receivers in main process";
            }
        }
        
        if (outError[0] != null) {
            return null;
        }

        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            if (parser.getName().equals("intent-filter")) {
                ActivityIntentInfo intent = new ActivityIntentInfo(a);
                if (!parseIntent(res, parser, attrs, flags, intent, outError, !receiver)) {
                    return null;
                }
                if (intent.countActions() == 0) {
                    Slog.w(TAG, "No actions in intent filter at "
                            + mArchiveSourcePath + " "
                            + parser.getPositionDescription());
                } else {
                    a.intents.add(intent);
                }
            } else if (parser.getName().equals("meta-data")) {
                if ((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null) {
                    return null;
                }
            } else {
                if (!RIGID_PARSER) {
                    Slog.w(TAG, "Problem in package " + mArchiveSourcePath + ":");
                    if (receiver) {
                        Slog.w(TAG, "Unknown element under <receiver>: " + parser.getName()
                                + " at " + mArchiveSourcePath + " "
                                + parser.getPositionDescription());
                    } else {
                        Slog.w(TAG, "Unknown element under <activity>: " + parser.getName()
                                + " at " + mArchiveSourcePath + " "
                                + parser.getPositionDescription());
                    }
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } else {
                    if (receiver) {
                        outError[0] = "Bad element under <receiver>: " + parser.getName();
                    } else {
                        outError[0] = "Bad element under <activity>: " + parser.getName();
                    }
                    return null;
                }
            }
        }

        if (!setExported) {
            a.info.exported = a.intents.size() > 0;
        }

        return a;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.593 -0500", hash_original_method = "2C553740AE22C20570EEFC51EEC11A38", hash_generated_method = "9B2C06CB9B32DFE92715E54D0C94747E")
    
private Activity parseActivityAlias(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError)
            throws XmlPullParserException, IOException {
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestActivityAlias);

        String targetActivity = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_targetActivity, 0);
        if (targetActivity == null) {
            outError[0] = "<activity-alias> does not specify android:targetActivity";
            sa.recycle();
            return null;
        }

        targetActivity = buildClassName(owner.applicationInfo.packageName,
                targetActivity, outError);
        if (targetActivity == null) {
            sa.recycle();
            return null;
        }

        if (mParseActivityAliasArgs == null) {
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
        }
        
        mParseActivityAliasArgs.sa = sa;
        mParseActivityAliasArgs.flags = flags;
        
        Activity target = null;

        final int NA = owner.activities.size();
        for (int i=0; i<NA; i++) {
            Activity t = owner.activities.get(i);
            if (targetActivity.equals(t.info.name)) {
                target = t;
                break;
            }
        }

        if (target == null) {
            outError[0] = "<activity-alias> target activity " + targetActivity
                    + " not found in manifest";
            sa.recycle();
            return null;
        }

        ActivityInfo info = new ActivityInfo();
        info.targetActivity = targetActivity;
        info.configChanges = target.info.configChanges;
        info.flags = target.info.flags;
        info.icon = target.info.icon;
        info.logo = target.info.logo;
        info.labelRes = target.info.labelRes;
        info.nonLocalizedLabel = target.info.nonLocalizedLabel;
        info.launchMode = target.info.launchMode;
        info.processName = target.info.processName;
        if (info.descriptionRes == 0) {
            info.descriptionRes = target.info.descriptionRes;
        }
        info.screenOrientation = target.info.screenOrientation;
        info.taskAffinity = target.info.taskAffinity;
        info.theme = target.info.theme;
        info.softInputMode = target.info.softInputMode;
        info.uiOptions = target.info.uiOptions;
        
        Activity a = new Activity(mParseActivityAliasArgs, info);
        if (outError[0] != null) {
            sa.recycle();
            return null;
        }

        final boolean setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_exported);
        if (setExported) {
            a.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_exported, false);
        }

        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_permission, 0);
        if (str != null) {
            a.info.permission = str.length() > 0 ? str.toString().intern() : null;
        }

        sa.recycle();

        if (outError[0] != null) {
            return null;
        }

        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            if (parser.getName().equals("intent-filter")) {
                ActivityIntentInfo intent = new ActivityIntentInfo(a);
                if (!parseIntent(res, parser, attrs, flags, intent, outError, true)) {
                    return null;
                }
                if (intent.countActions() == 0) {
                    Slog.w(TAG, "No actions in intent filter at "
                            + mArchiveSourcePath + " "
                            + parser.getPositionDescription());
                } else {
                    a.intents.add(intent);
                }
            } else if (parser.getName().equals("meta-data")) {
                if ((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null) {
                    return null;
                }
            } else {
                if (!RIGID_PARSER) {
                    Slog.w(TAG, "Unknown element under <activity-alias>: " + parser.getName()
                            + " at " + mArchiveSourcePath + " "
                            + parser.getPositionDescription());
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } else {
                    outError[0] = "Bad element under <activity-alias>: " + parser.getName();
                    return null;
                }
            }
        }

        if (!setExported) {
            a.info.exported = a.intents.size() > 0;
        }

        return a;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.597 -0500", hash_original_method = "CC761DF5515ACB2817B0A6BEDC12031E", hash_generated_method = "C3AEA733098AE437186D5A46D33CEBFA")
    
private Provider parseProvider(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError)
            throws XmlPullParserException, IOException {
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestProvider);

        if (mParseProviderArgs == null) {
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
        }
        
        mParseProviderArgs.sa = sa;
        mParseProviderArgs.flags = flags;
        
        Provider p = new Provider(mParseProviderArgs, new ProviderInfo());
        if (outError[0] != null) {
            sa.recycle();
            return null;
        }

        p.info.exported = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestProvider_exported, true);

        String cpname = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_authorities, 0);

        p.info.isSyncable = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestProvider_syncable,
                false);

        String permission = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_permission, 0);
        String str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_readPermission, 0);
        if (str == null) {
            str = permission;
        }
        if (str == null) {
            p.info.readPermission = owner.applicationInfo.permission;
        } else {
            p.info.readPermission =
                str.length() > 0 ? str.toString().intern() : null;
        }
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_writePermission, 0);
        if (str == null) {
            str = permission;
        }
        if (str == null) {
            p.info.writePermission = owner.applicationInfo.permission;
        } else {
            p.info.writePermission =
                str.length() > 0 ? str.toString().intern() : null;
        }

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

        if ((owner.applicationInfo.flags&ApplicationInfo.FLAG_CANT_SAVE_STATE) != 0) {
            // A heavy-weight application can not have providers in its main process
            // We can do direct compare because we intern all strings.
            if (p.info.processName == owner.packageName) {
                outError[0] = "Heavy-weight applications can not have providers in main process";
                return null;
            }
        }
        
        if (cpname == null) {
            outError[0] = "<provider> does not incude authorities attribute";
            return null;
        }
        p.info.authority = cpname.intern();

        if (!parseProviderTags(res, parser, attrs, p, outError)) {
            return null;
        }

        return p;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.603 -0500", hash_original_method = "05A16AA66DEB0B6B5120CEC23FE33532", hash_generated_method = "E70591A1E3D0FC13C8C615179A470058")
    
private boolean parseProviderTags(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Provider outInfo, String[] outError)
            throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            if (parser.getName().equals("meta-data")) {
                if ((outInfo.metaData=parseMetaData(res, parser, attrs,
                        outInfo.metaData, outError)) == null) {
                    return false;
                }
                
            } else if (parser.getName().equals("grant-uri-permission")) {
                TypedArray sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission);

                PatternMatcher pa = null;

                String str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_path, 0);
                if (str != null) {
                    pa = new PatternMatcher(str, PatternMatcher.PATTERN_LITERAL);
                }

                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_pathPrefix, 0);
                if (str != null) {
                    pa = new PatternMatcher(str, PatternMatcher.PATTERN_PREFIX);
                }

                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_pathPattern, 0);
                if (str != null) {
                    pa = new PatternMatcher(str, PatternMatcher.PATTERN_SIMPLE_GLOB);
                }
                
                sa.recycle();

                if (pa != null) {
                    if (outInfo.info.uriPermissionPatterns == null) {
                        outInfo.info.uriPermissionPatterns = new PatternMatcher[1];
                        outInfo.info.uriPermissionPatterns[0] = pa;
                    } else {
                        final int N = outInfo.info.uriPermissionPatterns.length;
                        PatternMatcher[] newp = new PatternMatcher[N+1];
                        System.arraycopy(outInfo.info.uriPermissionPatterns, 0, newp, 0, N);
                        newp[N] = pa;
                        outInfo.info.uriPermissionPatterns = newp;
                    }
                    outInfo.info.grantUriPermissions = true;
                } else {
                    if (!RIGID_PARSER) {
                        Slog.w(TAG, "Unknown element under <path-permission>: "
                                + parser.getName() + " at " + mArchiveSourcePath + " "
                                + parser.getPositionDescription());
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    } else {
                        outError[0] = "No path, pathPrefix, or pathPattern for <path-permission>";
                        return false;
                    }
                }
                XmlUtils.skipCurrentTag(parser);

            } else if (parser.getName().equals("path-permission")) {
                TypedArray sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestPathPermission);

                PathPermission pa = null;

                String permission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_permission, 0);
                String readPermission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_readPermission, 0);
                if (readPermission == null) {
                    readPermission = permission;
                }
                String writePermission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_writePermission, 0);
                if (writePermission == null) {
                    writePermission = permission;
                }
                
                boolean havePerm = false;
                if (readPermission != null) {
                    readPermission = readPermission.intern();
                    havePerm = true;
                }
                if (writePermission != null) {
                    writePermission = writePermission.intern();
                    havePerm = true;
                }

                if (!havePerm) {
                    if (!RIGID_PARSER) {
                        Slog.w(TAG, "No readPermission or writePermssion for <path-permission>: "
                                + parser.getName() + " at " + mArchiveSourcePath + " "
                                + parser.getPositionDescription());
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    } else {
                        outError[0] = "No readPermission or writePermssion for <path-permission>";
                        return false;
                    }
                }
                
                String path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_path, 0);
                if (path != null) {
                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_LITERAL, readPermission, writePermission);
                }

                path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_pathPrefix, 0);
                if (path != null) {
                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_PREFIX, readPermission, writePermission);
                }

                path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_pathPattern, 0);
                if (path != null) {
                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_SIMPLE_GLOB, readPermission, writePermission);
                }

                sa.recycle();

                if (pa != null) {
                    if (outInfo.info.pathPermissions == null) {
                        outInfo.info.pathPermissions = new PathPermission[1];
                        outInfo.info.pathPermissions[0] = pa;
                    } else {
                        final int N = outInfo.info.pathPermissions.length;
                        PathPermission[] newp = new PathPermission[N+1];
                        System.arraycopy(outInfo.info.pathPermissions, 0, newp, 0, N);
                        newp[N] = pa;
                        outInfo.info.pathPermissions = newp;
                    }
                } else {
                    if (!RIGID_PARSER) {
                        Slog.w(TAG, "No path, pathPrefix, or pathPattern for <path-permission>: "
                                + parser.getName() + " at " + mArchiveSourcePath + " "
                                + parser.getPositionDescription());
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    }
                    outError[0] = "No path, pathPrefix, or pathPattern for <path-permission>";
                    return false;
                }
                XmlUtils.skipCurrentTag(parser);

            } else {
                if (!RIGID_PARSER) {
                    Slog.w(TAG, "Unknown element under <provider>: "
                            + parser.getName() + " at " + mArchiveSourcePath + " "
                            + parser.getPositionDescription());
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } else {
                    outError[0] = "Bad element under <provider>: " + parser.getName();
                    return false;
                }
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.607 -0500", hash_original_method = "1B6E257916FE773842F0B213D728DC29", hash_generated_method = "5D1DB58F3656CCEEAF6C8D3FC2B0679F")
    
private Service parseService(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError)
            throws XmlPullParserException, IOException {
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestService);

        if (mParseServiceArgs == null) {
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
        }
        
        mParseServiceArgs.sa = sa;
        mParseServiceArgs.flags = flags;
        
        Service s = new Service(mParseServiceArgs, new ServiceInfo());
        if (outError[0] != null) {
            sa.recycle();
            return null;
        }

        final boolean setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestService_exported);
        if (setExported) {
            s.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestService_exported, false);
        }

        String str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestService_permission, 0);
        if (str == null) {
            s.info.permission = owner.applicationInfo.permission;
        } else {
            s.info.permission = str.length() > 0 ? str.toString().intern() : null;
        }

        s.info.flags = 0;
        if (sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestService_stopWithTask,
                false)) {
            s.info.flags |= ServiceInfo.FLAG_STOP_WITH_TASK;
        }

        sa.recycle();

        if ((owner.applicationInfo.flags&ApplicationInfo.FLAG_CANT_SAVE_STATE) != 0) {
            // A heavy-weight application can not have services in its main process
            // We can do direct compare because we intern all strings.
            if (s.info.processName == owner.packageName) {
                outError[0] = "Heavy-weight applications can not have services in main process";
                return null;
            }
        }
        
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            if (parser.getName().equals("intent-filter")) {
                ServiceIntentInfo intent = new ServiceIntentInfo(s);
                if (!parseIntent(res, parser, attrs, flags, intent, outError, false)) {
                    return null;
                }

                s.intents.add(intent);
            } else if (parser.getName().equals("meta-data")) {
                if ((s.metaData=parseMetaData(res, parser, attrs, s.metaData,
                        outError)) == null) {
                    return null;
                }
            } else {
                if (!RIGID_PARSER) {
                    Slog.w(TAG, "Unknown element under <service>: "
                            + parser.getName() + " at " + mArchiveSourcePath + " "
                            + parser.getPositionDescription());
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } else {
                    outError[0] = "Bad element under <service>: " + parser.getName();
                    return null;
                }
            }
        }

        if (!setExported) {
            s.info.exported = s.intents.size() > 0;
        }

        return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.611 -0500", hash_original_method = "99FE3F7E654A8DB168806DBE6C913C62", hash_generated_method = "C3733E937DF0E226D98FFAA94CCFCB95")
    
private boolean parseAllMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs, String tag,
            Component outInfo, String[] outError)
            throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            if (parser.getName().equals("meta-data")) {
                if ((outInfo.metaData=parseMetaData(res, parser, attrs,
                        outInfo.metaData, outError)) == null) {
                    return false;
                }
            } else {
                if (!RIGID_PARSER) {
                    Slog.w(TAG, "Unknown element under " + tag + ": "
                            + parser.getName() + " at " + mArchiveSourcePath + " "
                            + parser.getPositionDescription());
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } else {
                    outError[0] = "Bad element under " + tag + ": " + parser.getName();
                    return false;
                }
            }
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.614 -0500", hash_original_method = "714C7ED1FC52C32A41D3A8C089BB2BEC", hash_generated_method = "9457877F7A7FC17587DF2BC9C919C113")
    
private Bundle parseMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Bundle data, String[] outError)
            throws XmlPullParserException, IOException {

        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestMetaData);

        if (data == null) {
            data = new Bundle();
        }

        String name = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestMetaData_name, 0);
        if (name == null) {
            outError[0] = "<meta-data> requires an android:name attribute";
            sa.recycle();
            return null;
        }

        name = name.intern();
        
        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestMetaData_resource);
        if (v != null && v.resourceId != 0) {
            //Slog.i(TAG, "Meta data ref " + name + ": " + v);
            data.putInt(name, v.resourceId);
        } else {
            v = sa.peekValue(
                    com.android.internal.R.styleable.AndroidManifestMetaData_value);
            //Slog.i(TAG, "Meta data " + name + ": " + v);
            if (v != null) {
                if (v.type == TypedValue.TYPE_STRING) {
                    CharSequence cs = v.coerceToString();
                    data.putString(name, cs != null ? cs.toString().intern() : null);
                } else if (v.type == TypedValue.TYPE_INT_BOOLEAN) {
                    data.putBoolean(name, v.data != 0);
                } else if (v.type >= TypedValue.TYPE_FIRST_INT
                        && v.type <= TypedValue.TYPE_LAST_INT) {
                    data.putInt(name, v.data);
                } else if (v.type == TypedValue.TYPE_FLOAT) {
                    data.putFloat(name, v.getFloat());
                } else {
                    if (!RIGID_PARSER) {
                        Slog.w(TAG, "<meta-data> only supports string, integer, float, color, boolean, and resource reference types: "
                                + parser.getName() + " at " + mArchiveSourcePath + " "
                                + parser.getPositionDescription());
                    } else {
                        outError[0] = "<meta-data> only supports string, integer, float, color, boolean, and resource reference types";
                        data = null;
                    }
                }
            } else {
                outError[0] = "<meta-data> requires an android:value or android:resource attribute";
                data = null;
            }
        }

        sa.recycle();

        XmlUtils.skipCurrentTag(parser);

        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:53.626 -0500", hash_original_method = "B28F171FD6C00B48F648DC5DCFE3EFC1", hash_generated_method = "A9356700B66F9372A103C88AA36CA357")
    
private boolean parseIntent(Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags,
            IntentInfo outInfo, String[] outError, boolean isActivity)
            throws XmlPullParserException, IOException {

        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestIntentFilter);

        int priority = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_priority, 0);
        outInfo.setPriority(priority);

        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_label);
        if (v != null && (outInfo.labelRes=v.resourceId) == 0) {
            outInfo.nonLocalizedLabel = v.coerceToString();
        }

        outInfo.icon = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_icon, 0);
        
        outInfo.logo = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_logo, 0);

        sa.recycle();

        int outerDepth = parser.getDepth();
        int type;
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }

            String nodeName = parser.getName();
            if (nodeName.equals("action")) {
                String value = attrs.getAttributeValue(
                        ANDROID_RESOURCES, "name");
                if (value == null || value == "") {
                    outError[0] = "No value supplied for <android:name>";
                    return false;
                }
                XmlUtils.skipCurrentTag(parser);

                outInfo.addAction(value);
            } else if (nodeName.equals("category")) {
                String value = attrs.getAttributeValue(
                        ANDROID_RESOURCES, "name");
                if (value == null || value == "") {
                    outError[0] = "No value supplied for <android:name>";
                    return false;
                }
                XmlUtils.skipCurrentTag(parser);

                outInfo.addCategory(value);

            } else if (nodeName.equals("data")) {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestData);

                String str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_mimeType, 0);
                if (str != null) {
                    try {
                        outInfo.addDataType(str);
                    } catch (IntentFilter.MalformedMimeTypeException e) {
                        outError[0] = e.toString();
                        sa.recycle();
                        return false;
                    }
                }

                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_scheme, 0);
                if (str != null) {
                    outInfo.addDataScheme(str);
                }

                String host = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_host, 0);
                String port = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_port, 0);
                if (host != null) {
                    outInfo.addDataAuthority(host, port);
                }

                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_path, 0);
                if (str != null) {
                    outInfo.addDataPath(str, PatternMatcher.PATTERN_LITERAL);
                }

                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_pathPrefix, 0);
                if (str != null) {
                    outInfo.addDataPath(str, PatternMatcher.PATTERN_PREFIX);
                }

                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_pathPattern, 0);
                if (str != null) {
                    outInfo.addDataPath(str, PatternMatcher.PATTERN_SIMPLE_GLOB);
                }

                sa.recycle();
                XmlUtils.skipCurrentTag(parser);
            } else if (!RIGID_PARSER) {
                Slog.w(TAG, "Unknown element under <intent-filter>: "
                        + parser.getName() + " at " + mArchiveSourcePath + " "
                        + parser.getPositionDescription());
                XmlUtils.skipCurrentTag(parser);
            } else {
                outError[0] = "Bad element under <intent-filter>: " + parser.getName();
                return false;
            }
        }

        outInfo.hasDefault = outInfo.hasCategory(Intent.CATEGORY_DEFAULT);

        if (DEBUG_PARSER) {
            final StringBuilder cats = new StringBuilder("Intent d=");
            cats.append(outInfo.hasDefault);
            cats.append(", cat=");

            final Iterator<String> it = outInfo.categoriesIterator();
            if (it != null) {
                while (it.hasNext()) {
                    cats.append(' ');
                    cats.append(it.next());
                }
            }
            Slog.d(TAG, cats.toString());
        }

        return true;
    }
}

