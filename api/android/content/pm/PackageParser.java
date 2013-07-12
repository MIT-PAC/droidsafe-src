package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.777 -0400", hash_original_field = "6D55A934CD0311CDA3B2E6B59509DD26", hash_generated_field = "57425F83C121F61E241FD46B0ED62373")

    private String mArchiveSourcePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.777 -0400", hash_original_field = "49409C19162E9FEBA7D85BFAB66D22AB", hash_generated_field = "642D094C7AB0E1931029DBA1482587AA")

    private String[] mSeparateProcesses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_field = "60FF333954B30D97597289A5E3F0D829", hash_generated_field = "7D4097DC031AD87620CBAE061A799BA0")

    private boolean mOnlyCoreApps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_field = "2D2D1647C1F507DD0C69815A9B70EBB5", hash_generated_field = "809C28E1E054CBEE627F51452F62162E")

    private int mParseError = PackageManager.INSTALL_SUCCEEDED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_field = "30AFEEC03E0FC67FC72AC27E4D75F515", hash_generated_field = "5C8F41F6CF659609357D809C60CDDF3A")

    private ParsePackageItemArgs mParseInstrumentationArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_field = "13625980AC052E44D25BE6F44D68FA9A", hash_generated_field = "65DE09F18AF72BEAF7CDD76662D74019")

    private ParseComponentArgs mParseActivityArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_field = "807D2C9E81D3006A4C06D98BCBA1C937", hash_generated_field = "ACF41630823F563A230447D3D7E52494")

    private ParseComponentArgs mParseActivityAliasArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_field = "0959A33D19686EFBEFC0AABD5F448A57", hash_generated_field = "9225E738D789335DA1CFA407299C2B0D")

    private ParseComponentArgs mParseServiceArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_field = "A70EF10C819504A5FBF4E1F538F4B1E6", hash_generated_field = "319560D498F8EDD3EA50CA6B89B5AD1B")

    private ParseComponentArgs mParseProviderArgs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_method = "DDBED2CCEF7CE747A37B4CF69A21D51E", hash_generated_method = "E69DDF97EF9C8A4CD053936837CFE800")
    public  PackageParser(String archiveSourcePath) {
        mArchiveSourcePath = archiveSourcePath;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.778 -0400", hash_original_method = "65A62D9388B66A4D9595CDAEE2873A09", hash_generated_method = "103DD5B4DFB0483919E33AB133A239C0")
    public void setSeparateProcesses(String[] procs) {
        mSeparateProcesses = procs;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.779 -0400", hash_original_method = "14C9699FDDD05F8B9AF1818DB0942037", hash_generated_method = "109C581621376AE52DD74733E1366244")
    public void setOnlyCoreApps(boolean onlyCoreApps) {
        mOnlyCoreApps = onlyCoreApps;
        
        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.780 -0400", hash_original_method = "83F32E741E7740326FB3ACF1CABD2263", hash_generated_method = "4D76A33CFAEF1A6AE977A33C7D39B347")
    private Certificate[] loadCertificates(JarFile jarFile, JarEntry je,
            byte[] readBuffer) {
        addTaint(readBuffer[0]);
        addTaint(je.getTaint());
        addTaint(jarFile.getTaint());
        try 
        {
            InputStream is = new BufferedInputStream(jarFile.getInputStream(je));
            while
(is.read(readBuffer, 0, readBuffer.length) != -1)            
            {
            } 
            is.close();
Certificate[] var19FA6D40133C822F7DDD1762B8931907_167540359 =             je != null ? je.getCertificates() : null;
            var19FA6D40133C822F7DDD1762B8931907_167540359.addTaint(taint);
            return var19FA6D40133C822F7DDD1762B8931907_167540359;
        } 
        catch (IOException e)
        {
        } 
        catch (RuntimeException e)
        {
        } 
Certificate[] var540C13E9E156B687226421B24F2DF178_369261181 =         null;
        var540C13E9E156B687226421B24F2DF178_369261181.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_369261181;
        
        
            
            
            
            
            
        
            
                    
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.780 -0400", hash_original_method = "043AC7F11A9C5FD11FB43AEF955AD87D", hash_generated_method = "4A36D9E05BA82521182DC07DC88C5B58")
    public int getParseError() {
        int varBDCAA77B0CE7BEBD0AAD5ADCACBCBA88_1350698324 = (mParseError);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218220143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1218220143;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.781 -0400", hash_original_method = "F8C0CFF9FE003FD5724E792D5942913B", hash_generated_method = "350C88704AFBE2F5657B3DD42DD64192")
    public Package parsePackage(File sourceFile, String destCodePath,
            DisplayMetrics metrics, int flags) {
        addTaint(flags);
        addTaint(metrics.getTaint());
        addTaint(destCodePath.getTaint());
        mParseError = PackageManager.INSTALL_SUCCEEDED;
        mArchiveSourcePath = sourceFile.getPath();
    if(!sourceFile.isFile())        
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
Package var540C13E9E156B687226421B24F2DF178_1983176669 =             null;
            var540C13E9E156B687226421B24F2DF178_1983176669.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1983176669;
        } 
    if(!isPackageFilename(sourceFile.getName())
                && (flags&PARSE_MUST_BE_APK) != 0)        
        {
    if((flags&PARSE_IS_SYSTEM) == 0)            
            {
            } 
            mParseError = PackageManager.INSTALL_PARSE_FAILED_NOT_APK;
Package var540C13E9E156B687226421B24F2DF178_122320184 =             null;
            var540C13E9E156B687226421B24F2DF178_122320184.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_122320184;
        } 
    if(DEBUG_JAR)        
        Slog.d(TAG, "Scanning package: " + mArchiveSourcePath);
        XmlResourceParser parser = null;
        AssetManager assmgr = null;
        Resources res = null;
        boolean assetError = true;
        try 
        {
            assmgr = new AssetManager();
            int cookie = assmgr.addAssetPath(mArchiveSourcePath);
    if(cookie != 0)            
            {
                res = new Resources(assmgr, metrics, null);
                assmgr.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        Build.VERSION.RESOURCES_SDK_INT);
                parser = assmgr.openXmlResourceParser(cookie, ANDROID_MANIFEST_FILENAME);
                assetError = false;
            } 
            else
            {
            } 
        } 
        catch (Exception e)
        {
        } 
    if(assetError)        
        {
    if(assmgr != null)            
            assmgr.close();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST;
Package var540C13E9E156B687226421B24F2DF178_1321971136 =             null;
            var540C13E9E156B687226421B24F2DF178_1321971136.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1321971136;
        } 
        String[] errorText = new String[1];
        Package pkg = null;
        Exception errorException = null;
        try 
        {
            pkg = parsePackage(res, parser, flags, errorText);
        } 
        catch (Exception e)
        {
            errorException = e;
            mParseError = PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
        } 
    if(pkg == null)        
        {
    if(!mOnlyCoreApps || mParseError != PackageManager.INSTALL_SUCCEEDED)            
            {
    if(errorException != null)                
                {
                } 
                else
                {
                } 
    if(mParseError == PackageManager.INSTALL_SUCCEEDED)                
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                } 
            } 
            parser.close();
            assmgr.close();
Package var540C13E9E156B687226421B24F2DF178_1402990364 =             null;
            var540C13E9E156B687226421B24F2DF178_1402990364.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1402990364;
        } 
        parser.close();
        assmgr.close();
        pkg.mPath = destCodePath;
        pkg.mScanPath = mArchiveSourcePath;
        pkg.mSignatures = null;
Package varED674789E18B51C56C5496E452A560E9_1037120164 =         pkg;
        varED674789E18B51C56C5496E452A560E9_1037120164.addTaint(taint);
        return varED674789E18B51C56C5496E452A560E9_1037120164;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.782 -0400", hash_original_method = "19D0E628AA10FC207BA0D548739FDEDB", hash_generated_method = "046B09EF9B8CF476481E97C3243AAF66")
    public boolean collectCertificates(Package pkg, int flags) {
        addTaint(flags);
        addTaint(pkg.getTaint());
        pkg.mSignatures = null;
        WeakReference<byte[]> readBufferRef;
        byte[] readBuffer = null;
        synchronized
(mSync)        {
            readBufferRef = mReadBuffer;
    if(readBufferRef != null)            
            {
                mReadBuffer = null;
                readBuffer = readBufferRef.get();
            } 
    if(readBuffer == null)            
            {
                readBuffer = new byte[8192];
                readBufferRef = new WeakReference<byte[]>(readBuffer);
            } 
        } 
        try 
        {
            JarFile jarFile = new JarFile(mArchiveSourcePath);
            Certificate[] certs = null;
    if((flags&PARSE_IS_SYSTEM) != 0)            
            {
                JarEntry jarEntry = jarFile.getJarEntry(ANDROID_MANIFEST_FILENAME);
                certs = loadCertificates(jarFile, jarEntry, readBuffer);
    if(certs == null)                
                {
                    jarFile.close();
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                    boolean var68934A3E9455FA72420237EB05902327_1529809558 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355279960 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355279960;
                } 
    if(DEBUG_JAR)                
                {
    if(certs != null)                    
                    {
                        final int N = certs.length;
for(int i=0;i<N;i++)
                        {
                        } 
                    } 
                } 
            } 
            else
            {
                Enumeration<JarEntry> entries = jarFile.entries();
                final Manifest manifest = jarFile.getManifest();
                while
(entries.hasMoreElements())                
                {
                    final JarEntry je = entries.nextElement();
    if(je.isDirectory())                    
                    continue;
                    final String name = je.getName();
    if(name.startsWith("META-INF/"))                    
                    continue;
    if(ANDROID_MANIFEST_FILENAME.equals(name))                    
                    {
                        final Attributes attributes = manifest.getAttributes(name);
                        pkg.manifestDigest = ManifestDigest.fromAttributes(attributes);
                    } 
                    final Certificate[] localCerts = loadCertificates(jarFile, je, readBuffer);
    if(DEBUG_JAR)                    
                    {
                    } 
    if(localCerts == null)                    
                    {
                        jarFile.close();
                        mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                        boolean var68934A3E9455FA72420237EB05902327_292303230 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067471995 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067471995;
                    } 
                    else
    if(certs == null)                    
                    {
                        certs = localCerts;
                    } 
                    else
                    {
for(int i=0;i<certs.length;i++)
                        {
                            boolean found = false;
for(int j=0;j<localCerts.length;j++)
                            {
    if(certs[i] != null &&
                                        certs[i].equals(localCerts[j]))                                
                                {
                                    found = true;
                                    break;
                                } 
                            } 
    if(!found || certs.length != localCerts.length)                            
                            {
                                jarFile.close();
                                mParseError = PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES;
                                boolean var68934A3E9455FA72420237EB05902327_726929772 = (false);
                                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068085643 = getTaintBoolean();
                                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068085643;
                            } 
                        } 
                    } 
                } 
            } 
            jarFile.close();
            synchronized
(mSync)            {
                mReadBuffer = readBufferRef;
            } 
    if(certs != null && certs.length > 0)            
            {
                final int N = certs.length;
                pkg.mSignatures = new Signature[certs.length];
for(int i=0;i<N;i++)
                {
                    pkg.mSignatures[i] = new Signature(
                            certs[i].getEncoded());
                } 
            } 
            else
            {
                mParseError = PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES;
                boolean var68934A3E9455FA72420237EB05902327_408304262 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1321370669 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1321370669;
            } 
        } 
        catch (CertificateEncodingException e)
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
            boolean var68934A3E9455FA72420237EB05902327_991693074 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801905371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801905371;
        } 
        catch (IOException e)
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
            boolean var68934A3E9455FA72420237EB05902327_1140561376 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681875733 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_681875733;
        } 
        catch (RuntimeException e)
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION;
            boolean var68934A3E9455FA72420237EB05902327_1885448913 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1521836643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1521836643;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_660167296 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772952008 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772952008;
        
        
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

    
        @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.789 -0400", hash_original_method = "91CC6CEE84025557458760F97B90CD2F", hash_generated_method = "BEF2F21CEC1CD0313A362573DB66B0B7")
    private Package parsePackage(
        Resources res, XmlResourceParser parser, int flags, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(flags);
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        AttributeSet attrs = parser;
        mParseInstrumentationArgs = null;
        mParseActivityArgs = null;
        mParseServiceArgs = null;
        mParseProviderArgs = null;
        String pkgName = parsePackageName(parser, attrs, flags, outError);
    if(pkgName == null)        
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME;
Package var540C13E9E156B687226421B24F2DF178_221115009 =             null;
            var540C13E9E156B687226421B24F2DF178_221115009.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_221115009;
        } 
        int type;
    if(mOnlyCoreApps)        
        {
            boolean core = attrs.getAttributeBooleanValue(null, "coreApp", false);
    if(!core)            
            {
                mParseError = PackageManager.INSTALL_SUCCEEDED;
Package var540C13E9E156B687226421B24F2DF178_554533814 =                 null;
                var540C13E9E156B687226421B24F2DF178_554533814.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_554533814;
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
    if(pkg.mVersionName != null)        
        {
            pkg.mVersionName = pkg.mVersionName.intern();
        } 
        String str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifest_sharedUserId, 0);
    if(str != null && str.length() > 0)        
        {
            String nameError = validateName(str, true);
    if(nameError != null && !"android".equals(pkgName))            
            {
                outError[0] = "<manifest> specifies bad sharedUserId name \""
                    + str + "\": " + nameError;
                mParseError = PackageManager.INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID;
Package var540C13E9E156B687226421B24F2DF178_693094063 =                 null;
                var540C13E9E156B687226421B24F2DF178_693094063.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_693094063;
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
        int supportsSmallScreens = 1;
        int supportsNormalScreens = 1;
        int supportsLargeScreens = 1;
        int supportsXLargeScreens = 1;
        int resizeable = 1;
        int anyDensity = 1;
        int outerDepth = parser.getDepth();
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
            String tagName = parser.getName();
    if(tagName.equals("application"))            
            {
    if(foundApp)                
                {
    if(RIGID_PARSER)                    
                    {
                        outError[0] = "<manifest> has more than one <application>";
                        mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Package var540C13E9E156B687226421B24F2DF178_2071508791 =                         null;
                        var540C13E9E156B687226421B24F2DF178_2071508791.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_2071508791;
                    } 
                    else
                    {
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    } 
                } 
                foundApp = true;
    if(!parseApplication(pkg, res, parser, attrs, flags, outError))                
                {
Package var540C13E9E156B687226421B24F2DF178_902591118 =                     null;
                    var540C13E9E156B687226421B24F2DF178_902591118.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_902591118;
                } 
            } 
            else
    if(tagName.equals("permission-group"))            
            {
    if(parsePermissionGroup(pkg, res, parser, attrs, outError) == null)                
                {
Package var540C13E9E156B687226421B24F2DF178_830985548 =                     null;
                    var540C13E9E156B687226421B24F2DF178_830985548.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_830985548;
                } 
            } 
            else
    if(tagName.equals("permission"))            
            {
    if(parsePermission(pkg, res, parser, attrs, outError) == null)                
                {
Package var540C13E9E156B687226421B24F2DF178_477420098 =                     null;
                    var540C13E9E156B687226421B24F2DF178_477420098.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_477420098;
                } 
            } 
            else
    if(tagName.equals("permission-tree"))            
            {
    if(parsePermissionTree(pkg, res, parser, attrs, outError) == null)                
                {
Package var540C13E9E156B687226421B24F2DF178_1875453118 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1875453118.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1875453118;
                } 
            } 
            else
    if(tagName.equals("uses-permission"))            
            {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesPermission);
                String name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesPermission_name);
                sa.recycle();
    if(name != null && !pkg.requestedPermissions.contains(name))                
                {
                    pkg.requestedPermissions.add(name.intern());
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("uses-configuration"))            
            {
                ConfigurationInfo cPref = new ConfigurationInfo();
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration);
                cPref.reqTouchScreen = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqTouchScreen,
                        Configuration.TOUCHSCREEN_UNDEFINED);
                cPref.reqKeyboardType = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqKeyboardType,
                        Configuration.KEYBOARD_UNDEFINED);
    if(sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqHardKeyboard,
                        false))                
                {
                    cPref.reqInputFeatures |= ConfigurationInfo.INPUT_FEATURE_HARD_KEYBOARD;
                } 
                cPref.reqNavigation = sa.getInt(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqNavigation,
                        Configuration.NAVIGATION_UNDEFINED);
    if(sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesConfiguration_reqFiveWayNav,
                        false))                
                {
                    cPref.reqInputFeatures |= ConfigurationInfo.INPUT_FEATURE_FIVE_WAY_NAV;
                } 
                sa.recycle();
                pkg.configPreferences.add(cPref);
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("uses-feature"))            
            {
                FeatureInfo fi = new FeatureInfo();
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesFeature);
                fi.name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesFeature_name);
    if(fi.name == null)                
                {
                    fi.reqGlEsVersion = sa.getInt(
                            com.android.internal.R.styleable.AndroidManifestUsesFeature_glEsVersion,
                            FeatureInfo.GL_ES_VERSION_UNDEFINED);
                } 
    if(sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesFeature_required,
                        true))                
                {
                    fi.flags |= FeatureInfo.FLAG_REQUIRED;
                } 
                sa.recycle();
    if(pkg.reqFeatures == null)                
                {
                    pkg.reqFeatures = new ArrayList<FeatureInfo>();
                } 
                pkg.reqFeatures.add(fi);
    if(fi.name == null)                
                {
                    ConfigurationInfo cPref = new ConfigurationInfo();
                    cPref.reqGlEsVersion = fi.reqGlEsVersion;
                    pkg.configPreferences.add(cPref);
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("uses-sdk"))            
            {
    if(SDK_VERSION > 0)                
                {
                    sa = res.obtainAttributes(attrs,
                            com.android.internal.R.styleable.AndroidManifestUsesSdk);
                    int minVers = 0;
                    String minCode = null;
                    int targetVers = 0;
                    String targetCode = null;
                    TypedValue val = sa.peekValue(
                            com.android.internal.R.styleable.AndroidManifestUsesSdk_minSdkVersion);
    if(val != null)                    
                    {
    if(val.type == TypedValue.TYPE_STRING && val.string != null)                        
                        {
                            targetCode = minCode = val.string.toString();
                        } 
                        else
                        {
                            targetVers = minVers = val.data;
                        } 
                    } 
                    val = sa.peekValue(
                            com.android.internal.R.styleable.AndroidManifestUsesSdk_targetSdkVersion);
    if(val != null)                    
                    {
    if(val.type == TypedValue.TYPE_STRING && val.string != null)                        
                        {
                            targetCode = minCode = val.string.toString();
                        } 
                        else
                        {
                            targetVers = val.data;
                        } 
                    } 
                    sa.recycle();
    if(minCode != null)                    
                    {
    if(!minCode.equals(SDK_CODENAME))                        
                        {
    if(SDK_CODENAME != null)                            
                            {
                                outError[0] = "Requires development platform " + minCode
                                        + " (current platform is " + SDK_CODENAME + ")";
                            } 
                            else
                            {
                                outError[0] = "Requires development platform " + minCode
                                        + " but this is a release platform.";
                            } 
                            mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
Package var540C13E9E156B687226421B24F2DF178_1918358415 =                             null;
                            var540C13E9E156B687226421B24F2DF178_1918358415.addTaint(taint);
                            return var540C13E9E156B687226421B24F2DF178_1918358415;
                        } 
                    } 
                    else
    if(minVers > SDK_VERSION)                    
                    {
                        outError[0] = "Requires newer sdk version #" + minVers
                                + " (current version is #" + SDK_VERSION + ")";
                        mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
Package var540C13E9E156B687226421B24F2DF178_1694132395 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1694132395.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1694132395;
                    } 
    if(targetCode != null)                    
                    {
    if(!targetCode.equals(SDK_CODENAME))                        
                        {
    if(SDK_CODENAME != null)                            
                            {
                                outError[0] = "Requires development platform " + targetCode
                                        + " (current platform is " + SDK_CODENAME + ")";
                            } 
                            else
                            {
                                outError[0] = "Requires development platform " + targetCode
                                        + " but this is a release platform.";
                            } 
                            mParseError = PackageManager.INSTALL_FAILED_OLDER_SDK;
Package var540C13E9E156B687226421B24F2DF178_258851647 =                             null;
                            var540C13E9E156B687226421B24F2DF178_258851647.addTaint(taint);
                            return var540C13E9E156B687226421B24F2DF178_258851647;
                        } 
                        pkg.applicationInfo.targetSdkVersion
                                = android.os.Build.VERSION_CODES.CUR_DEVELOPMENT;
                    } 
                    else
                    {
                        pkg.applicationInfo.targetSdkVersion = targetVers;
                    } 
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("supports-screens"))            
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
            } 
            else
    if(tagName.equals("protected-broadcast"))            
            {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestProtectedBroadcast);
                String name = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestProtectedBroadcast_name);
                sa.recycle();
    if(name != null && (flags&PARSE_IS_SYSTEM) != 0)                
                {
    if(pkg.protectedBroadcasts == null)                    
                    {
                        pkg.protectedBroadcasts = new ArrayList<String>();
                    } 
    if(!pkg.protectedBroadcasts.contains(name))                    
                    {
                        pkg.protectedBroadcasts.add(name.intern());
                    } 
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("instrumentation"))            
            {
    if(parseInstrumentation(pkg, res, parser, attrs, outError) == null)                
                {
Package var540C13E9E156B687226421B24F2DF178_1595365894 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1595365894.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1595365894;
                } 
            } 
            else
    if(tagName.equals("original-package"))            
            {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage);
                String orig = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage_name, 0);
    if(!pkg.packageName.equals(orig))                
                {
    if(pkg.mOriginalPackages == null)                    
                    {
                        pkg.mOriginalPackages = new ArrayList<String>();
                        pkg.mRealPackage = pkg.packageName;
                    } 
                    pkg.mOriginalPackages.add(orig);
                } 
                sa.recycle();
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("adopt-permissions"))            
            {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage);
                String name = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestOriginalPackage_name, 0);
                sa.recycle();
    if(name != null)                
                {
    if(pkg.mAdoptPermissions == null)                    
                    {
                        pkg.mAdoptPermissions = new ArrayList<String>();
                    } 
                    pkg.mAdoptPermissions.add(name);
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("uses-gl-texture"))            
            {
                XmlUtils.skipCurrentTag(parser);
                continue;
            } 
            else
    if(tagName.equals("compatible-screens"))            
            {
                XmlUtils.skipCurrentTag(parser);
                continue;
            } 
            else
    if(tagName.equals("eat-comment"))            
            {
                XmlUtils.skipCurrentTag(parser);
                continue;
            } 
            else
    if(RIGID_PARSER)            
            {
                outError[0] = "Bad element under <manifest>: "
                    + parser.getName();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Package var540C13E9E156B687226421B24F2DF178_1720734016 =                 null;
                var540C13E9E156B687226421B24F2DF178_1720734016.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1720734016;
            } 
            else
            {
                XmlUtils.skipCurrentTag(parser);
                continue;
            } 
        } 
    if(!foundApp && pkg.instrumentation.size() == 0)        
        {
            outError[0] = "<manifest> does not contain an <application> or <instrumentation>";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_EMPTY;
        } 
        final int NP = PackageParser.NEW_PERMISSIONS.length;
        StringBuilder implicitPerms = null;
for(int ip=0;ip<NP;ip++)
        {
            final PackageParser.NewPermissionInfo npi = PackageParser.NEW_PERMISSIONS[ip];
    if(pkg.applicationInfo.targetSdkVersion >= npi.sdkVersion)            
            {
                break;
            } 
    if(!pkg.requestedPermissions.contains(npi.name))            
            {
    if(implicitPerms == null)                
                {
                    implicitPerms = new StringBuilder(128);
                    implicitPerms.append(pkg.packageName);
                    implicitPerms.append(": compat added ");
                } 
                else
                {
                    implicitPerms.append(' ');
                } 
                implicitPerms.append(npi.name);
                pkg.requestedPermissions.add(npi.name);
            } 
        } 
    if(implicitPerms != null)        
        {
        } 
    if(supportsSmallScreens < 0 || (supportsSmallScreens > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT))        
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_SMALL_SCREENS;
        } 
    if(supportsNormalScreens != 0)        
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_NORMAL_SCREENS;
        } 
    if(supportsLargeScreens < 0 || (supportsLargeScreens > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT))        
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS;
        } 
    if(supportsXLargeScreens < 0 || (supportsXLargeScreens > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.GINGERBREAD))        
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS;
        } 
    if(resizeable < 0 || (resizeable > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT))        
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_RESIZEABLE_FOR_SCREENS;
        } 
    if(anyDensity < 0 || (anyDensity > 0
                && pkg.applicationInfo.targetSdkVersion
                        >= android.os.Build.VERSION_CODES.DONUT))        
        {
            pkg.applicationInfo.flags |= ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES;
        } 
Package varED674789E18B51C56C5496E452A560E9_79968263 =         pkg;
        varED674789E18B51C56C5496E452A560E9_79968263.addTaint(taint);
        return varED674789E18B51C56C5496E452A560E9_79968263;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.798 -0400", hash_original_method = "E3395575DA3BE4CF83D20AFB0193668F", hash_generated_method = "7FCF0414E9C12D35022FA70EC427D62A")
    private PermissionGroup parsePermissionGroup(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        addTaint(owner.getTaint());
        PermissionGroup perm = new PermissionGroup(owner);
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup);
    if(!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-group>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_name,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_label,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_logo))        
        {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
PermissionGroup var540C13E9E156B687226421B24F2DF178_470489847 =             null;
            var540C13E9E156B687226421B24F2DF178_470489847.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_470489847;
        } 
        perm.info.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestPermissionGroup_description,
                0);
        sa.recycle();
    if(!parseAllMetaData(res, parser, attrs, "<permission-group>", perm,
                outError))        
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
PermissionGroup var540C13E9E156B687226421B24F2DF178_2053019295 =             null;
            var540C13E9E156B687226421B24F2DF178_2053019295.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2053019295;
        } 
        owner.permissionGroups.add(perm);
PermissionGroup var768916ECB5B80042EF41FFF6B22D9A06_433656976 =         perm;
        var768916ECB5B80042EF41FFF6B22D9A06_433656976.addTaint(taint);
        return var768916ECB5B80042EF41FFF6B22D9A06_433656976;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.799 -0400", hash_original_method = "1D11570A32C6A271E593822206F9BD54", hash_generated_method = "5A1FFB9D91BAC62E18EA9E7C684FA268")
    private Permission parsePermission(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        addTaint(owner.getTaint());
        Permission perm = new Permission(owner);
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermission);
    if(!parsePackageItemInfo(owner, perm.info, outError,
                "<permission>", sa,
                com.android.internal.R.styleable.AndroidManifestPermission_name,
                com.android.internal.R.styleable.AndroidManifestPermission_label,
                com.android.internal.R.styleable.AndroidManifestPermission_icon,
                com.android.internal.R.styleable.AndroidManifestPermission_logo))        
        {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Permission var540C13E9E156B687226421B24F2DF178_1075866625 =             null;
            var540C13E9E156B687226421B24F2DF178_1075866625.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1075866625;
        } 
        perm.info.group = sa.getNonResourceString(
                com.android.internal.R.styleable.AndroidManifestPermission_permissionGroup);
    if(perm.info.group != null)        
        {
            perm.info.group = perm.info.group.intern();
        } 
        perm.info.descriptionRes = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestPermission_description,
                0);
        perm.info.protectionLevel = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestPermission_protectionLevel,
                PermissionInfo.PROTECTION_NORMAL);
        sa.recycle();
    if(perm.info.protectionLevel == -1)        
        {
            outError[0] = "<permission> does not specify protectionLevel";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Permission var540C13E9E156B687226421B24F2DF178_1108046687 =             null;
            var540C13E9E156B687226421B24F2DF178_1108046687.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1108046687;
        } 
    if(!parseAllMetaData(res, parser, attrs, "<permission>", perm,
                outError))        
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Permission var540C13E9E156B687226421B24F2DF178_1430244887 =             null;
            var540C13E9E156B687226421B24F2DF178_1430244887.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1430244887;
        } 
        owner.permissions.add(perm);
Permission var768916ECB5B80042EF41FFF6B22D9A06_2080377328 =         perm;
        var768916ECB5B80042EF41FFF6B22D9A06_2080377328.addTaint(taint);
        return var768916ECB5B80042EF41FFF6B22D9A06_2080377328;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.806 -0400", hash_original_method = "BAA3C6F5A9B5CEE097497C276EDD624D", hash_generated_method = "49331BEABE555A1D3144B168CD98B4CD")
    private Permission parsePermissionTree(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        addTaint(owner.getTaint());
        Permission perm = new Permission(owner);
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestPermissionTree);
    if(!parsePackageItemInfo(owner, perm.info, outError,
                "<permission-tree>", sa,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_name,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_label,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_icon,
                com.android.internal.R.styleable.AndroidManifestPermissionTree_logo))        
        {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Permission var540C13E9E156B687226421B24F2DF178_2135241275 =             null;
            var540C13E9E156B687226421B24F2DF178_2135241275.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2135241275;
        } 
        sa.recycle();
        int index = perm.info.name.indexOf('.');
    if(index > 0)        
        {
            index = perm.info.name.indexOf('.', index+1);
        } 
    if(index < 0)        
        {
            outError[0] = "<permission-tree> name has less than three segments: "
                + perm.info.name;
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Permission var540C13E9E156B687226421B24F2DF178_1160507543 =             null;
            var540C13E9E156B687226421B24F2DF178_1160507543.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1160507543;
        } 
        perm.info.descriptionRes = 0;
        perm.info.protectionLevel = PermissionInfo.PROTECTION_NORMAL;
        perm.tree = true;
    if(!parseAllMetaData(res, parser, attrs, "<permission-tree>", perm,
                outError))        
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Permission var540C13E9E156B687226421B24F2DF178_766313697 =             null;
            var540C13E9E156B687226421B24F2DF178_766313697.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_766313697;
        } 
        owner.permissions.add(perm);
Permission var768916ECB5B80042EF41FFF6B22D9A06_308791802 =         perm;
        var768916ECB5B80042EF41FFF6B22D9A06_308791802.addTaint(taint);
        return var768916ECB5B80042EF41FFF6B22D9A06_308791802;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.807 -0400", hash_original_method = "77B98478A5AAF7EC4E5B725BE9FDC9E7", hash_generated_method = "0018A6A315E47C14E6731863E5E88E73")
    private Instrumentation parseInstrumentation(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, String[] outError) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestInstrumentation);
    if(mParseInstrumentationArgs == null)        
        {
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
    if(outError[0] != null)        
        {
            sa.recycle();
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Instrumentation var540C13E9E156B687226421B24F2DF178_1238346414 =             null;
            var540C13E9E156B687226421B24F2DF178_1238346414.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1238346414;
        } 
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
    if(a.info.targetPackage == null)        
        {
            outError[0] = "<instrumentation> does not specify targetPackage";
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Instrumentation var540C13E9E156B687226421B24F2DF178_1419583779 =             null;
            var540C13E9E156B687226421B24F2DF178_1419583779.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1419583779;
        } 
    if(!parseAllMetaData(res, parser, attrs, "<instrumentation>", a,
                outError))        
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
Instrumentation var540C13E9E156B687226421B24F2DF178_790062820 =             null;
            var540C13E9E156B687226421B24F2DF178_790062820.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_790062820;
        } 
        owner.instrumentation.add(a);
Instrumentation var3F5343BF1D849954A73F0BB303805FFD_490662632 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_490662632.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_490662632;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.820 -0400", hash_original_method = "3784AF975EC3AF37D03EE1A91A900A73", hash_generated_method = "3D75A1ABFD8050885F2F2215B6000975")
    private boolean parseApplication(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(flags);
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        addTaint(owner.getTaint());
        final ApplicationInfo ai = owner.applicationInfo;
        final String pkgName = owner.applicationInfo.packageName;
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestApplication);
        String name = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_name, 0);
    if(name != null)        
        {
            ai.className = buildClassName(pkgName, name, outError);
    if(ai.className == null)            
            {
                sa.recycle();
                mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                boolean var68934A3E9455FA72420237EB05902327_1642736578 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830556337 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830556337;
            } 
        } 
        String manageSpaceActivity = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_manageSpaceActivity, 0);
    if(manageSpaceActivity != null)        
        {
            ai.manageSpaceActivityName = buildClassName(pkgName, manageSpaceActivity,
                    outError);
        } 
        boolean allowBackup = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowBackup, true);
    if(allowBackup)        
        {
            ai.flags |= ApplicationInfo.FLAG_ALLOW_BACKUP;
            String backupAgent = sa.getNonConfigurationString(
                    com.android.internal.R.styleable.AndroidManifestApplication_backupAgent, 0);
    if(backupAgent != null)            
            {
                ai.backupAgentName = buildClassName(pkgName, backupAgent, outError);
    if(DEBUG_BACKUP)                
                {
                } 
    if(sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_killAfterRestore,
                        true))                
                {
                    ai.flags |= ApplicationInfo.FLAG_KILL_AFTER_RESTORE;
                } 
    if(sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_restoreAnyVersion,
                        false))                
                {
                    ai.flags |= ApplicationInfo.FLAG_RESTORE_ANY_VERSION;
                } 
            } 
        } 
        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestApplication_label);
    if(v != null && (ai.labelRes=v.resourceId) == 0)        
        {
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
    if((flags&PARSE_IS_SYSTEM) != 0)        
        {
    if(sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestApplication_persistent,
                    false))            
            {
                ai.flags |= ApplicationInfo.FLAG_PERSISTENT;
            } 
        } 
    if((flags & PARSE_FORWARD_LOCK) != 0)        
        {
            ai.flags |= ApplicationInfo.FLAG_FORWARD_LOCK;
        } 
    if((flags & PARSE_ON_SDCARD) != 0)        
        {
            ai.flags |= ApplicationInfo.FLAG_EXTERNAL_STORAGE;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_debuggable,
                false))        
        {
            ai.flags |= ApplicationInfo.FLAG_DEBUGGABLE;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_vmSafeMode,
                false))        
        {
            ai.flags |= ApplicationInfo.FLAG_VM_SAFE_MODE;
        } 
        boolean hardwareAccelerated = sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_hardwareAccelerated,
                owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.ICE_CREAM_SANDWICH);
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_hasCode,
                true))        
        {
            ai.flags |= ApplicationInfo.FLAG_HAS_CODE;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowTaskReparenting,
                false))        
        {
            ai.flags |= ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_allowClearUserData,
                true))        
        {
            ai.flags |= ApplicationInfo.FLAG_ALLOW_CLEAR_USER_DATA;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_testOnly,
                false))        
        {
            ai.flags |= ApplicationInfo.FLAG_TEST_ONLY;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestApplication_largeHeap,
                false))        
        {
            ai.flags |= ApplicationInfo.FLAG_LARGE_HEAP;
        } 
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestApplication_permission, 0);
        ai.permission = (str != null && str.length() > 0) ? str.intern() : null;
    if(owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.FROYO)        
        {
            str = sa.getNonConfigurationString(
                    com.android.internal.R.styleable.AndroidManifestApplication_taskAffinity, 0);
        } 
        else
        {
            str = sa.getNonResourceString(
                    com.android.internal.R.styleable.AndroidManifestApplication_taskAffinity);
        } 
        ai.taskAffinity = buildTaskAffinityName(ai.packageName, ai.packageName,
                str, outError);
    if(outError[0] == null)        
        {
            CharSequence pname;
    if(owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.FROYO)            
            {
                pname = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestApplication_process, 0);
            } 
            else
            {
                pname = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestApplication_process);
            } 
            ai.processName = buildProcessName(ai.packageName, null, pname,
                    flags, mSeparateProcesses, outError);
            ai.enabled = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestApplication_enabled, true);
    if(false)            
            {
    if(sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestApplication_cantSaveState,
                        false))                
                {
                    ai.flags |= ApplicationInfo.FLAG_CANT_SAVE_STATE;
    if(ai.processName != null && ai.processName != ai.packageName)                    
                    {
                        outError[0] = "cantSaveState applications can not use custom processes";
                    } 
                } 
            } 
        } 
        ai.uiOptions = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestApplication_uiOptions, 0);
        sa.recycle();
    if(outError[0] != null)        
        {
            mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            boolean var68934A3E9455FA72420237EB05902327_590835755 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423665946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423665946;
        } 
        final int innerDepth = parser.getDepth();
        int type;
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
            String tagName = parser.getName();
    if(tagName.equals("activity"))            
            {
                Activity a = parseActivity(owner, res, parser, attrs, flags, outError, false,
                        hardwareAccelerated);
    if(a == null)                
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    boolean var68934A3E9455FA72420237EB05902327_358890885 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349412813 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349412813;
                } 
                owner.activities.add(a);
            } 
            else
    if(tagName.equals("receiver"))            
            {
                Activity a = parseActivity(owner, res, parser, attrs, flags, outError, true, false);
    if(a == null)                
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    boolean var68934A3E9455FA72420237EB05902327_1848385775 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208217718 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208217718;
                } 
                owner.receivers.add(a);
            } 
            else
    if(tagName.equals("service"))            
            {
                Service s = parseService(owner, res, parser, attrs, flags, outError);
    if(s == null)                
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    boolean var68934A3E9455FA72420237EB05902327_282064541 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149760160 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_149760160;
                } 
                owner.services.add(s);
            } 
            else
    if(tagName.equals("provider"))            
            {
                Provider p = parseProvider(owner, res, parser, attrs, flags, outError);
    if(p == null)                
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    boolean var68934A3E9455FA72420237EB05902327_205599591 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570813549 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_570813549;
                } 
                owner.providers.add(p);
            } 
            else
    if(tagName.equals("activity-alias"))            
            {
                Activity a = parseActivityAlias(owner, res, parser, attrs, flags, outError);
    if(a == null)                
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    boolean var68934A3E9455FA72420237EB05902327_1905393097 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3345380 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_3345380;
                } 
                owner.activities.add(a);
            } 
            else
    if(parser.getName().equals("meta-data"))            
            {
    if((owner.mAppMetaData = parseMetaData(res, parser, attrs, owner.mAppMetaData,
                        outError)) == null)                
                {
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    boolean var68934A3E9455FA72420237EB05902327_938143112 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794585047 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_794585047;
                } 
            } 
            else
    if(tagName.equals("uses-library"))            
            {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary);
                String lname = sa.getNonResourceString(
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary_name);
                boolean req = sa.getBoolean(
                        com.android.internal.R.styleable.AndroidManifestUsesLibrary_required,
                        true);
                sa.recycle();
    if(lname != null)                
                {
    if(req)                    
                    {
    if(owner.usesLibraries == null)                        
                        {
                            owner.usesLibraries = new ArrayList<String>();
                        } 
    if(!owner.usesLibraries.contains(lname))                        
                        {
                            owner.usesLibraries.add(lname.intern());
                        } 
                    } 
                    else
                    {
    if(owner.usesOptionalLibraries == null)                        
                        {
                            owner.usesOptionalLibraries = new ArrayList<String>();
                        } 
    if(!owner.usesOptionalLibraries.contains(lname))                        
                        {
                            owner.usesOptionalLibraries.add(lname.intern());
                        } 
                    } 
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(tagName.equals("uses-package"))            
            {
                XmlUtils.skipCurrentTag(parser);
            } 
            else
            {
    if(!RIGID_PARSER)                
                {
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } 
                else
                {
                    outError[0] = "Bad element under <application>: " + tagName;
                    mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                    boolean var68934A3E9455FA72420237EB05902327_1852613039 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817918543 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817918543;
                } 
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1681124715 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256500195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_256500195;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.826 -0400", hash_original_method = "63CFF58BE3C03EE3AAF09BEB17B3529D", hash_generated_method = "959D883505AE037C304500AC25091AA6")
    private boolean parsePackageItemInfo(Package owner, PackageItemInfo outInfo,
            String[] outError, String tag, TypedArray sa,
            int nameRes, int labelRes, int iconRes, int logoRes) {
        addTaint(logoRes);
        addTaint(iconRes);
        addTaint(labelRes);
        addTaint(nameRes);
        addTaint(sa.getTaint());
        addTaint(tag.getTaint());
        addTaint(outError[0].getTaint());
        addTaint(outInfo.getTaint());
        addTaint(owner.getTaint());
        String name = sa.getNonConfigurationString(nameRes, 0);
    if(name == null)        
        {
            outError[0] = tag + " does not specify android:name";
            boolean var68934A3E9455FA72420237EB05902327_1500799448 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192984983 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_192984983;
        } 
        outInfo.name
            = buildClassName(owner.applicationInfo.packageName, name, outError);
    if(outInfo.name == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_106704161 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481519082 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481519082;
        } 
        int iconVal = sa.getResourceId(iconRes, 0);
    if(iconVal != 0)        
        {
            outInfo.icon = iconVal;
            outInfo.nonLocalizedLabel = null;
        } 
        int logoVal = sa.getResourceId(logoRes, 0);
    if(logoVal != 0)        
        {
            outInfo.logo = logoVal;
        } 
        TypedValue v = sa.peekValue(labelRes);
    if(v != null && (outInfo.labelRes=v.resourceId) == 0)        
        {
            outInfo.nonLocalizedLabel = v.coerceToString();
        } 
        outInfo.packageName = owner.packageName;
        boolean varB326B5062B2F0E69046810717534CB09_227062359 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161766325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161766325;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.837 -0400", hash_original_method = "5541C23C630FF3AC70030479982C4C1F", hash_generated_method = "F4E7D588DEB7FCD4987B1F21BA95278F")
    private Activity parseActivity(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError,
            boolean receiver, boolean hardwareAccelerated) throws XmlPullParserException, IOException {
        addTaint(hardwareAccelerated);
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestActivity);
    if(mParseActivityArgs == null)        
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
        } 
        mParseActivityArgs.tag = receiver ? "<receiver>" : "<activity>";
        mParseActivityArgs.sa = sa;
        mParseActivityArgs.flags = flags;
        Activity a = new Activity(mParseActivityArgs, new ActivityInfo());
    if(outError[0] != null)        
        {
            sa.recycle();
Activity var540C13E9E156B687226421B24F2DF178_1260586753 =             null;
            var540C13E9E156B687226421B24F2DF178_1260586753.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1260586753;
        } 
        final boolean setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestActivity_exported);
    if(setExported)        
        {
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
    if(str == null)        
        {
            a.info.permission = owner.applicationInfo.permission;
        } 
        else
        {
            a.info.permission = str.length() > 0 ? str.toString().intern() : null;
        } 
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivity_taskAffinity, 0);
        a.info.taskAffinity = buildTaskAffinityName(owner.applicationInfo.packageName,
                owner.applicationInfo.taskAffinity, str, outError);
        a.info.flags = 0;
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_multiprocess,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_MULTIPROCESS;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnTaskLaunch,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_FINISH_ON_TASK_LAUNCH;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_clearTaskOnLaunch,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_CLEAR_TASK_ON_LAUNCH;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_noHistory,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_NO_HISTORY;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_alwaysRetainTaskState,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_ALWAYS_RETAIN_TASK_STATE;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_stateNotNeeded,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_STATE_NOT_NEEDED;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_excludeFromRecents,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_EXCLUDE_FROM_RECENTS;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_allowTaskReparenting,
                (owner.applicationInfo.flags&ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING) != 0))        
        {
            a.info.flags |= ActivityInfo.FLAG_ALLOW_TASK_REPARENTING;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_finishOnCloseSystemDialogs,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS;
        } 
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestActivity_immersive,
                false))        
        {
            a.info.flags |= ActivityInfo.FLAG_IMMERSIVE;
        } 
    if(!receiver)        
        {
    if(sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivity_hardwareAccelerated,
                    hardwareAccelerated))            
            {
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
        } 
        else
        {
            a.info.launchMode = ActivityInfo.LAUNCH_MULTIPLE;
            a.info.configChanges = 0;
        } 
        sa.recycle();
    if(receiver && (owner.applicationInfo.flags&ApplicationInfo.FLAG_CANT_SAVE_STATE) != 0)        
        {
    if(a.info.processName == owner.packageName)            
            {
                outError[0] = "Heavy-weight applications can not have receivers in main process";
            } 
        } 
    if(outError[0] != null)        
        {
Activity var540C13E9E156B687226421B24F2DF178_922146339 =             null;
            var540C13E9E156B687226421B24F2DF178_922146339.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_922146339;
        } 
        int outerDepth = parser.getDepth();
        int type;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
    if(parser.getName().equals("intent-filter"))            
            {
                ActivityIntentInfo intent = new ActivityIntentInfo(a);
    if(!parseIntent(res, parser, attrs, flags, intent, outError, !receiver))                
                {
Activity var540C13E9E156B687226421B24F2DF178_1658520572 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1658520572.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1658520572;
                } 
    if(intent.countActions() == 0)                
                {
                } 
                else
                {
                    a.intents.add(intent);
                } 
            } 
            else
    if(parser.getName().equals("meta-data"))            
            {
    if((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null)                
                {
Activity var540C13E9E156B687226421B24F2DF178_212556903 =                     null;
                    var540C13E9E156B687226421B24F2DF178_212556903.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_212556903;
                } 
            } 
            else
            {
    if(!RIGID_PARSER)                
                {
    if(receiver)                    
                    {
                    } 
                    else
                    {
                    } 
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } 
                else
                {
    if(receiver)                    
                    {
                        outError[0] = "Bad element under <receiver>: " + parser.getName();
                    } 
                    else
                    {
                        outError[0] = "Bad element under <activity>: " + parser.getName();
                    } 
Activity var540C13E9E156B687226421B24F2DF178_1798899961 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1798899961.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1798899961;
                } 
            } 
        } 
    if(!setExported)        
        {
            a.info.exported = a.intents.size() > 0;
        } 
Activity var3F5343BF1D849954A73F0BB303805FFD_1660692612 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_1660692612.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_1660692612;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.847 -0400", hash_original_method = "2C553740AE22C20570EEFC51EEC11A38", hash_generated_method = "90823F2F993A3A9AAD07FBE40DA44781")
    private Activity parseActivityAlias(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestActivityAlias);
        String targetActivity = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_targetActivity, 0);
    if(targetActivity == null)        
        {
            outError[0] = "<activity-alias> does not specify android:targetActivity";
            sa.recycle();
Activity var540C13E9E156B687226421B24F2DF178_1802968054 =             null;
            var540C13E9E156B687226421B24F2DF178_1802968054.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1802968054;
        } 
        targetActivity = buildClassName(owner.applicationInfo.packageName,
                targetActivity, outError);
    if(targetActivity == null)        
        {
            sa.recycle();
Activity var540C13E9E156B687226421B24F2DF178_1748716930 =             null;
            var540C13E9E156B687226421B24F2DF178_1748716930.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1748716930;
        } 
    if(mParseActivityAliasArgs == null)        
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
        } 
        mParseActivityAliasArgs.sa = sa;
        mParseActivityAliasArgs.flags = flags;
        Activity target = null;
        final int NA = owner.activities.size();
for(int i=0;i<NA;i++)
        {
            Activity t = owner.activities.get(i);
    if(targetActivity.equals(t.info.name))            
            {
                target = t;
                break;
            } 
        } 
    if(target == null)        
        {
            outError[0] = "<activity-alias> target activity " + targetActivity
                    + " not found in manifest";
            sa.recycle();
Activity var540C13E9E156B687226421B24F2DF178_263324761 =             null;
            var540C13E9E156B687226421B24F2DF178_263324761.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_263324761;
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
    if(info.descriptionRes == 0)        
        {
            info.descriptionRes = target.info.descriptionRes;
        } 
        info.screenOrientation = target.info.screenOrientation;
        info.taskAffinity = target.info.taskAffinity;
        info.theme = target.info.theme;
        info.softInputMode = target.info.softInputMode;
        info.uiOptions = target.info.uiOptions;
        Activity a = new Activity(mParseActivityAliasArgs, info);
    if(outError[0] != null)        
        {
            sa.recycle();
Activity var540C13E9E156B687226421B24F2DF178_105987031 =             null;
            var540C13E9E156B687226421B24F2DF178_105987031.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_105987031;
        } 
        final boolean setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_exported);
    if(setExported)        
        {
            a.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestActivityAlias_exported, false);
        } 
        String str;
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestActivityAlias_permission, 0);
    if(str != null)        
        {
            a.info.permission = str.length() > 0 ? str.toString().intern() : null;
        } 
        sa.recycle();
    if(outError[0] != null)        
        {
Activity var540C13E9E156B687226421B24F2DF178_631715722 =             null;
            var540C13E9E156B687226421B24F2DF178_631715722.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_631715722;
        } 
        int outerDepth = parser.getDepth();
        int type;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
    if(parser.getName().equals("intent-filter"))            
            {
                ActivityIntentInfo intent = new ActivityIntentInfo(a);
    if(!parseIntent(res, parser, attrs, flags, intent, outError, true))                
                {
Activity var540C13E9E156B687226421B24F2DF178_1422812564 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1422812564.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1422812564;
                } 
    if(intent.countActions() == 0)                
                {
                } 
                else
                {
                    a.intents.add(intent);
                } 
            } 
            else
    if(parser.getName().equals("meta-data"))            
            {
    if((a.metaData=parseMetaData(res, parser, attrs, a.metaData,
                        outError)) == null)                
                {
Activity var540C13E9E156B687226421B24F2DF178_989633138 =                     null;
                    var540C13E9E156B687226421B24F2DF178_989633138.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_989633138;
                } 
            } 
            else
            {
    if(!RIGID_PARSER)                
                {
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } 
                else
                {
                    outError[0] = "Bad element under <activity-alias>: " + parser.getName();
Activity var540C13E9E156B687226421B24F2DF178_1528060256 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1528060256.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1528060256;
                } 
            } 
        } 
    if(!setExported)        
        {
            a.info.exported = a.intents.size() > 0;
        } 
Activity var3F5343BF1D849954A73F0BB303805FFD_758615889 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_758615889.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_758615889;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.858 -0400", hash_original_method = "CC761DF5515ACB2817B0A6BEDC12031E", hash_generated_method = "15854B163A4687FE6318402B76170892")
    private Provider parseProvider(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestProvider);
    if(mParseProviderArgs == null)        
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
        } 
        mParseProviderArgs.sa = sa;
        mParseProviderArgs.flags = flags;
        Provider p = new Provider(mParseProviderArgs, new ProviderInfo());
    if(outError[0] != null)        
        {
            sa.recycle();
Provider var540C13E9E156B687226421B24F2DF178_1427369105 =             null;
            var540C13E9E156B687226421B24F2DF178_1427369105.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1427369105;
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
    if(str == null)        
        {
            str = permission;
        } 
    if(str == null)        
        {
            p.info.readPermission = owner.applicationInfo.permission;
        } 
        else
        {
            p.info.readPermission =
                str.length() > 0 ? str.toString().intern() : null;
        } 
        str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestProvider_writePermission, 0);
    if(str == null)        
        {
            str = permission;
        } 
    if(str == null)        
        {
            p.info.writePermission = owner.applicationInfo.permission;
        } 
        else
        {
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
    if((owner.applicationInfo.flags&ApplicationInfo.FLAG_CANT_SAVE_STATE) != 0)        
        {
    if(p.info.processName == owner.packageName)            
            {
                outError[0] = "Heavy-weight applications can not have providers in main process";
Provider var540C13E9E156B687226421B24F2DF178_1464106000 =                 null;
                var540C13E9E156B687226421B24F2DF178_1464106000.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1464106000;
            } 
        } 
    if(cpname == null)        
        {
            outError[0] = "<provider> does not incude authorities attribute";
Provider var540C13E9E156B687226421B24F2DF178_697624727 =             null;
            var540C13E9E156B687226421B24F2DF178_697624727.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_697624727;
        } 
        p.info.authority = cpname.intern();
    if(!parseProviderTags(res, parser, attrs, p, outError))        
        {
Provider var540C13E9E156B687226421B24F2DF178_78160104 =             null;
            var540C13E9E156B687226421B24F2DF178_78160104.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_78160104;
        } 
Provider var74E4690D9F2A026504928C017944E149_853853160 =         p;
        var74E4690D9F2A026504928C017944E149_853853160.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_853853160;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.868 -0400", hash_original_method = "05A16AA66DEB0B6B5120CEC23FE33532", hash_generated_method = "40271CFBA17D2136443C0B82E672811D")
    private boolean parseProviderTags(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Provider outInfo, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(outInfo.getTaint());
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        int outerDepth = parser.getDepth();
        int type;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
    if(parser.getName().equals("meta-data"))            
            {
    if((outInfo.metaData=parseMetaData(res, parser, attrs,
                        outInfo.metaData, outError)) == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_583832101 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098842886 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098842886;
                } 
            } 
            else
    if(parser.getName().equals("grant-uri-permission"))            
            {
                TypedArray sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission);
                PatternMatcher pa = null;
                String str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_path, 0);
    if(str != null)                
                {
                    pa = new PatternMatcher(str, PatternMatcher.PATTERN_LITERAL);
                } 
                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_pathPrefix, 0);
    if(str != null)                
                {
                    pa = new PatternMatcher(str, PatternMatcher.PATTERN_PREFIX);
                } 
                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestGrantUriPermission_pathPattern, 0);
    if(str != null)                
                {
                    pa = new PatternMatcher(str, PatternMatcher.PATTERN_SIMPLE_GLOB);
                } 
                sa.recycle();
    if(pa != null)                
                {
    if(outInfo.info.uriPermissionPatterns == null)                    
                    {
                        outInfo.info.uriPermissionPatterns = new PatternMatcher[1];
                        outInfo.info.uriPermissionPatterns[0] = pa;
                    } 
                    else
                    {
                        final int N = outInfo.info.uriPermissionPatterns.length;
                        PatternMatcher[] newp = new PatternMatcher[N+1];
                        System.arraycopy(outInfo.info.uriPermissionPatterns, 0, newp, 0, N);
                        newp[N] = pa;
                        outInfo.info.uriPermissionPatterns = newp;
                    } 
                    outInfo.info.grantUriPermissions = true;
                } 
                else
                {
    if(!RIGID_PARSER)                    
                    {
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    } 
                    else
                    {
                        outError[0] = "No path, pathPrefix, or pathPattern for <path-permission>";
                        boolean var68934A3E9455FA72420237EB05902327_770422858 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709156900 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709156900;
                    } 
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(parser.getName().equals("path-permission"))            
            {
                TypedArray sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestPathPermission);
                PathPermission pa = null;
                String permission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_permission, 0);
                String readPermission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_readPermission, 0);
    if(readPermission == null)                
                {
                    readPermission = permission;
                } 
                String writePermission = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_writePermission, 0);
    if(writePermission == null)                
                {
                    writePermission = permission;
                } 
                boolean havePerm = false;
    if(readPermission != null)                
                {
                    readPermission = readPermission.intern();
                    havePerm = true;
                } 
    if(writePermission != null)                
                {
                    writePermission = writePermission.intern();
                    havePerm = true;
                } 
    if(!havePerm)                
                {
    if(!RIGID_PARSER)                    
                    {
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    } 
                    else
                    {
                        outError[0] = "No readPermission or writePermssion for <path-permission>";
                        boolean var68934A3E9455FA72420237EB05902327_1350803293 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196112024 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196112024;
                    } 
                } 
                String path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_path, 0);
    if(path != null)                
                {
                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_LITERAL, readPermission, writePermission);
                } 
                path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_pathPrefix, 0);
    if(path != null)                
                {
                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_PREFIX, readPermission, writePermission);
                } 
                path = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestPathPermission_pathPattern, 0);
    if(path != null)                
                {
                    pa = new PathPermission(path,
                            PatternMatcher.PATTERN_SIMPLE_GLOB, readPermission, writePermission);
                } 
                sa.recycle();
    if(pa != null)                
                {
    if(outInfo.info.pathPermissions == null)                    
                    {
                        outInfo.info.pathPermissions = new PathPermission[1];
                        outInfo.info.pathPermissions[0] = pa;
                    } 
                    else
                    {
                        final int N = outInfo.info.pathPermissions.length;
                        PathPermission[] newp = new PathPermission[N+1];
                        System.arraycopy(outInfo.info.pathPermissions, 0, newp, 0, N);
                        newp[N] = pa;
                        outInfo.info.pathPermissions = newp;
                    } 
                } 
                else
                {
    if(!RIGID_PARSER)                    
                    {
                        XmlUtils.skipCurrentTag(parser);
                        continue;
                    } 
                    outError[0] = "No path, pathPrefix, or pathPattern for <path-permission>";
                    boolean var68934A3E9455FA72420237EB05902327_647793723 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492039053 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492039053;
                } 
                XmlUtils.skipCurrentTag(parser);
            } 
            else
            {
    if(!RIGID_PARSER)                
                {
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } 
                else
                {
                    outError[0] = "Bad element under <provider>: " + parser.getName();
                    boolean var68934A3E9455FA72420237EB05902327_1542329873 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496020474 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_496020474;
                } 
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1038914264 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755747416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_755747416;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.870 -0400", hash_original_method = "1B6E257916FE773842F0B213D728DC29", hash_generated_method = "2F3A1F4DDA44084DAA6B2FE00C8101F4")
    private Service parseService(Package owner, Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags, String[] outError) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestService);
    if(mParseServiceArgs == null)        
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
        } 
        mParseServiceArgs.sa = sa;
        mParseServiceArgs.flags = flags;
        Service s = new Service(mParseServiceArgs, new ServiceInfo());
    if(outError[0] != null)        
        {
            sa.recycle();
Service var540C13E9E156B687226421B24F2DF178_1287875578 =             null;
            var540C13E9E156B687226421B24F2DF178_1287875578.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1287875578;
        } 
        final boolean setExported = sa.hasValue(
                com.android.internal.R.styleable.AndroidManifestService_exported);
    if(setExported)        
        {
            s.info.exported = sa.getBoolean(
                    com.android.internal.R.styleable.AndroidManifestService_exported, false);
        } 
        String str = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestService_permission, 0);
    if(str == null)        
        {
            s.info.permission = owner.applicationInfo.permission;
        } 
        else
        {
            s.info.permission = str.length() > 0 ? str.toString().intern() : null;
        } 
        s.info.flags = 0;
    if(sa.getBoolean(
                com.android.internal.R.styleable.AndroidManifestService_stopWithTask,
                false))        
        {
            s.info.flags |= ServiceInfo.FLAG_STOP_WITH_TASK;
        } 
        sa.recycle();
    if((owner.applicationInfo.flags&ApplicationInfo.FLAG_CANT_SAVE_STATE) != 0)        
        {
    if(s.info.processName == owner.packageName)            
            {
                outError[0] = "Heavy-weight applications can not have services in main process";
Service var540C13E9E156B687226421B24F2DF178_926966333 =                 null;
                var540C13E9E156B687226421B24F2DF178_926966333.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_926966333;
            } 
        } 
        int outerDepth = parser.getDepth();
        int type;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
    if(parser.getName().equals("intent-filter"))            
            {
                ServiceIntentInfo intent = new ServiceIntentInfo(s);
    if(!parseIntent(res, parser, attrs, flags, intent, outError, false))                
                {
Service var540C13E9E156B687226421B24F2DF178_2007182218 =                     null;
                    var540C13E9E156B687226421B24F2DF178_2007182218.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_2007182218;
                } 
                s.intents.add(intent);
            } 
            else
    if(parser.getName().equals("meta-data"))            
            {
    if((s.metaData=parseMetaData(res, parser, attrs, s.metaData,
                        outError)) == null)                
                {
Service var540C13E9E156B687226421B24F2DF178_1022833416 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1022833416.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1022833416;
                } 
            } 
            else
            {
    if(!RIGID_PARSER)                
                {
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } 
                else
                {
                    outError[0] = "Bad element under <service>: " + parser.getName();
Service var540C13E9E156B687226421B24F2DF178_1611148244 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1611148244.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1611148244;
                } 
            } 
        } 
    if(!setExported)        
        {
            s.info.exported = s.intents.size() > 0;
        } 
Service var0478718F0636FB61899C13801CE9FE09_661151075 =         s;
        var0478718F0636FB61899C13801CE9FE09_661151075.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_661151075;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.872 -0400", hash_original_method = "99FE3F7E654A8DB168806DBE6C913C62", hash_generated_method = "1835A87CF1C394545FF8E6ABF9ED3E4B")
    private boolean parseAllMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs, String tag,
            Component outInfo, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(outInfo.getTaint());
        addTaint(tag.getTaint());
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        int outerDepth = parser.getDepth();
        int type;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
    if(parser.getName().equals("meta-data"))            
            {
    if((outInfo.metaData=parseMetaData(res, parser, attrs,
                        outInfo.metaData, outError)) == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1120176977 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579326791 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579326791;
                } 
            } 
            else
            {
    if(!RIGID_PARSER)                
                {
                    XmlUtils.skipCurrentTag(parser);
                    continue;
                } 
                else
                {
                    outError[0] = "Bad element under " + tag + ": " + parser.getName();
                    boolean var68934A3E9455FA72420237EB05902327_231285403 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1716686418 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1716686418;
                } 
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_534726277 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772885827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_772885827;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.874 -0400", hash_original_method = "714C7ED1FC52C32A41D3A8C089BB2BEC", hash_generated_method = "751FDBAD6C6C39B4498A352F01B277AE")
    private Bundle parseMetaData(Resources res,
            XmlPullParser parser, AttributeSet attrs,
            Bundle data, String[] outError) throws XmlPullParserException, IOException {
        addTaint(outError[0].getTaint());
        addTaint(data.getTaint());
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestMetaData);
    if(data == null)        
        {
            data = new Bundle();
        } 
        String name = sa.getNonConfigurationString(
                com.android.internal.R.styleable.AndroidManifestMetaData_name, 0);
    if(name == null)        
        {
            outError[0] = "<meta-data> requires an android:name attribute";
            sa.recycle();
Bundle var540C13E9E156B687226421B24F2DF178_114593980 =             null;
            var540C13E9E156B687226421B24F2DF178_114593980.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_114593980;
        } 
        name = name.intern();
        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestMetaData_resource);
    if(v != null && v.resourceId != 0)        
        {
            data.putInt(name, v.resourceId);
        } 
        else
        {
            v = sa.peekValue(
                    com.android.internal.R.styleable.AndroidManifestMetaData_value);
    if(v != null)            
            {
    if(v.type == TypedValue.TYPE_STRING)                
                {
                    CharSequence cs = v.coerceToString();
                    data.putString(name, cs != null ? cs.toString().intern() : null);
                } 
                else
    if(v.type == TypedValue.TYPE_INT_BOOLEAN)                
                {
                    data.putBoolean(name, v.data != 0);
                } 
                else
    if(v.type >= TypedValue.TYPE_FIRST_INT
                        && v.type <= TypedValue.TYPE_LAST_INT)                
                {
                    data.putInt(name, v.data);
                } 
                else
    if(v.type == TypedValue.TYPE_FLOAT)                
                {
                    data.putFloat(name, v.getFloat());
                } 
                else
                {
    if(!RIGID_PARSER)                    
                    {
                    } 
                    else
                    {
                        outError[0] = "<meta-data> only supports string, integer, float, color, boolean, and resource reference types";
                        data = null;
                    } 
                } 
            } 
            else
            {
                outError[0] = "<meta-data> requires an android:value or android:resource attribute";
                data = null;
            } 
        } 
        sa.recycle();
        XmlUtils.skipCurrentTag(parser);
Bundle var0C8B2C9585EB05DD9CD70726CF8CBC07_124163705 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_124163705.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_124163705;
        
        
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.876 -0400", hash_original_method = "B28F171FD6C00B48F648DC5DCFE3EFC1", hash_generated_method = "C3D0590CCE8DF9A7911AB7752CE08419")
    private boolean parseIntent(Resources res,
            XmlPullParser parser, AttributeSet attrs, int flags,
            IntentInfo outInfo, String[] outError, boolean isActivity) throws XmlPullParserException, IOException {
        addTaint(isActivity);
        addTaint(outError[0].getTaint());
        addTaint(outInfo.getTaint());
        addTaint(flags);
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.AndroidManifestIntentFilter);
        int priority = sa.getInt(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_priority, 0);
        outInfo.setPriority(priority);
        TypedValue v = sa.peekValue(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_label);
    if(v != null && (outInfo.labelRes=v.resourceId) == 0)        
        {
            outInfo.nonLocalizedLabel = v.coerceToString();
        } 
        outInfo.icon = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_icon, 0);
        outInfo.logo = sa.getResourceId(
                com.android.internal.R.styleable.AndroidManifestIntentFilter_logo, 0);
        sa.recycle();
        int outerDepth = parser.getDepth();
        int type;
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)            
            {
                continue;
            } 
            String nodeName = parser.getName();
    if(nodeName.equals("action"))            
            {
                String value = attrs.getAttributeValue(
                        ANDROID_RESOURCES, "name");
    if(value == null || value == "")                
                {
                    outError[0] = "No value supplied for <android:name>";
                    boolean var68934A3E9455FA72420237EB05902327_1290685624 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253803912 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253803912;
                } 
                XmlUtils.skipCurrentTag(parser);
                outInfo.addAction(value);
            } 
            else
    if(nodeName.equals("category"))            
            {
                String value = attrs.getAttributeValue(
                        ANDROID_RESOURCES, "name");
    if(value == null || value == "")                
                {
                    outError[0] = "No value supplied for <android:name>";
                    boolean var68934A3E9455FA72420237EB05902327_324349083 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253107294 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253107294;
                } 
                XmlUtils.skipCurrentTag(parser);
                outInfo.addCategory(value);
            } 
            else
    if(nodeName.equals("data"))            
            {
                sa = res.obtainAttributes(attrs,
                        com.android.internal.R.styleable.AndroidManifestData);
                String str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_mimeType, 0);
    if(str != null)                
                {
                    try 
                    {
                        outInfo.addDataType(str);
                    } 
                    catch (IntentFilter.MalformedMimeTypeException e)
                    {
                        outError[0] = e.toString();
                        sa.recycle();
                        boolean var68934A3E9455FA72420237EB05902327_889092864 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064853905 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064853905;
                    } 
                } 
                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_scheme, 0);
    if(str != null)                
                {
                    outInfo.addDataScheme(str);
                } 
                String host = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_host, 0);
                String port = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_port, 0);
    if(host != null)                
                {
                    outInfo.addDataAuthority(host, port);
                } 
                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_path, 0);
    if(str != null)                
                {
                    outInfo.addDataPath(str, PatternMatcher.PATTERN_LITERAL);
                } 
                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_pathPrefix, 0);
    if(str != null)                
                {
                    outInfo.addDataPath(str, PatternMatcher.PATTERN_PREFIX);
                } 
                str = sa.getNonConfigurationString(
                        com.android.internal.R.styleable.AndroidManifestData_pathPattern, 0);
    if(str != null)                
                {
                    outInfo.addDataPath(str, PatternMatcher.PATTERN_SIMPLE_GLOB);
                } 
                sa.recycle();
                XmlUtils.skipCurrentTag(parser);
            } 
            else
    if(!RIGID_PARSER)            
            {
                XmlUtils.skipCurrentTag(parser);
            } 
            else
            {
                outError[0] = "Bad element under <intent-filter>: " + parser.getName();
                boolean var68934A3E9455FA72420237EB05902327_124828457 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383192252 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_383192252;
            } 
        } 
        outInfo.hasDefault = outInfo.hasCategory(Intent.CATEGORY_DEFAULT);
    if(DEBUG_PARSER)        
        {
            final StringBuilder cats = new StringBuilder("Intent d=");
            cats.append(outInfo.hasDefault);
            cats.append(", cat=");
            final Iterator<String> it = outInfo.categoriesIterator();
    if(it != null)            
            {
                while
(it.hasNext())                
                {
                    cats.append(' ');
                    cats.append(it.next());
                } 
            } 
            Slog.d(TAG, cats.toString());
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1358661453 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111321170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111321170;
        
        
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SPEC)
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

    
        @DSModeled(DSC.SAFE)
    public static void setCompatibilityModeEnabled(boolean compatibilityModeEnabled) {
        sCompatibilityModeEnabled = compatibilityModeEnabled;
    }

    
    public static class NewPermissionInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.882 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.882 -0400", hash_original_field = "A79022BDE85A3E1291F6F337747F3E2D", hash_generated_field = "BC6F74C41FF51DC8E932B8D548DFA77F")

        public int sdkVersion;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.883 -0400", hash_original_field = "350A62B40A7F6336F2BC471A19CDE2C6", hash_generated_field = "110F458F9380E184018D0C29262B9616")

        public int fileVersion;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.883 -0400", hash_original_method = "2CD4C5E2A660B34C44D0A141A2AEA4A5", hash_generated_method = "F5F4FF09A35908459A08AD63049CA1FA")
        public  NewPermissionInfo(String name, int sdkVersion, int fileVersion) {
            this.name = name;
            this.sdkVersion = sdkVersion;
            this.fileVersion = fileVersion;
            
            
            
            
        }

        
    }


    
    static class ParsePackageItemArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.883 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "63E7E49220BEC65CFB906D3D26FF5320")

        Package owner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.883 -0400", hash_original_field = "266BA65C37D1B10AC4F3EE7791B9B445", hash_generated_field = "291217E682224D693BB6F37B520F9B6C")

        String[] outError;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.883 -0400", hash_original_field = "261A7CEA666F15E06CB2A73C0E88BF46", hash_generated_field = "0B58898276367165952073A704F8E936")

        int nameRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "72766807210949DB14E0A53D32EEFA42")

        int labelRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_field = "1AFA68AAD1FD9765C18E4975F512B2FD", hash_generated_field = "16A2D6444BA4128F5DED925DDCED14C3")

        int iconRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_field = "CD3A164FB9162CB1BED1A6A6D503D919", hash_generated_field = "9076C14F4A6A5083F7B4331FB7F68DE2")

        int logoRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FFCA994A2F44B678330E924D8C87385D")

        String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_field = "C12E01F2A13FF5587E1E9E4AEDB8242D", hash_generated_field = "F31D05FD6AB3B23194ACB45C1F7F8DB9")

        TypedArray sa;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_method = "FEBED5B917290B280BC232B6F93C8DA6", hash_generated_method = "55548C9D938CBB68771CEA96F9BC74DD")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_field = "1DE38A6C4DA32AC30AF07D8811642A87", hash_generated_field = "52628BA19847DEC6DD967DC512B6341E")

        String[] sepProcesses;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.884 -0400", hash_original_field = "7D1048C7C2C5A6919C87079377EE65DA", hash_generated_field = "98EAE5992470306073D805F3DE4D2B98")

        int processRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.885 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "1C23F3ABB5154D4340D3FAF2DBF4B754")

        int descriptionRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.885 -0400", hash_original_field = "460E3C30A98BC2FD8F0331AB402C5AA2", hash_generated_field = "DBC8C6552821B500EDF219C9444E5014")

        int enabledRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.885 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

        int flags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.886 -0400", hash_original_method = "A5B17BCC2B409C42234E0A16A22942F4", hash_generated_method = "4EB7544A320C49E073E5ADB595ADF15B")
          ParseComponentArgs(Package _owner, String[] _outError,
                int _nameRes, int _labelRes, int _iconRes, int _logoRes,
                String[] _sepProcesses, int _processRes,
                int _descriptionRes, int _enabledRes) {
            super(_owner, _outError, _nameRes, _labelRes, _iconRes, _logoRes);
            addTaint(_logoRes);
            addTaint(_iconRes);
            addTaint(_labelRes);
            addTaint(_nameRes);
            addTaint(_outError[0].getTaint());
            addTaint(_owner.getTaint());
            sepProcesses = _sepProcesses;
            processRes = _processRes;
            descriptionRes = _descriptionRes;
            enabledRes = _enabledRes;
            
            
            
            
            
        }

        
    }


    
    public static class PackageLite {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.886 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.887 -0400", hash_original_field = "BEA549FC87D184BC2179F71B62DAB91F", hash_generated_field = "30578A504DDEAA8F4E71E08EEE4589B5")

        public int installLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.887 -0400", hash_original_field = "68D3768AD0645CE6E56B550E3ECEE8FD", hash_generated_field = "547B5BDAEDA540976776CD453D2E9834")

        public VerifierInfo[] verifiers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.887 -0400", hash_original_method = "7A496B905B539B1321EA9EDB02EF9EB7", hash_generated_method = "26B62457834513FCB559BD6BBE921F67")
        public  PackageLite(String packageName, int installLocation, List<VerifierInfo> verifiers) {
            this.packageName = packageName;
            this.installLocation = installLocation;
            this.verifiers = verifiers.toArray(new VerifierInfo[verifiers.size()]);
            
            
            
            
        }

        
    }


    
    public final static class Package {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

        public String packageName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "69AB4388F5986AD3252147A346061D42", hash_generated_field = "4036EBD0249B46B198C5B885936F9FD5")

        public final ApplicationInfo applicationInfo = new ApplicationInfo();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "1232531D566254375A360E48EF41D648", hash_generated_field = "9F287DA06540EF72A4AA2C12FCA47D9D")

        public final ArrayList<Permission> permissions = new ArrayList<Permission>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "AF9C9DB8F55B4E887D008C390EC683B9", hash_generated_field = "44F464774678F54DEC4F24FE42619000")

        public final ArrayList<PermissionGroup> permissionGroups = new ArrayList<PermissionGroup>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "E168DD652573C5ADAB6897D04E579B5E", hash_generated_field = "FA37560F9C65320DAA508260F22AE66D")

        public final ArrayList<Activity> activities = new ArrayList<Activity>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "A20C9FE9911B60F28CA43D678FD7B573", hash_generated_field = "9593D48EBFB86307D900AA7594B7FB40")

        public final ArrayList<Activity> receivers = new ArrayList<Activity>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "CA3E9C0D88D726CB52B3450F7C6DE1AC", hash_generated_field = "BC5EE090E89F224AA377168513277DFC")

        public final ArrayList<Provider> providers = new ArrayList<Provider>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "E57E587DC11FA870F65E4A50D948E88D", hash_generated_field = "442AF6E4956588BEC9D95A4B568FDF37")

        public final ArrayList<Service> services = new ArrayList<Service>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "C8AA2D33F07DB1102094F07AD34B6C55", hash_generated_field = "3F24774E8DFC500EA6EF7CB14E2DAE81")

        public final ArrayList<Instrumentation> instrumentation = new ArrayList<Instrumentation>(0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.889 -0400", hash_original_field = "295D74C5EA62402E8079B176D6994C5F", hash_generated_field = "7D1FBB8E91439EB14277D7D8BA33F0DA")

        public final ArrayList<String> requestedPermissions = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "D2F2E3902A1EEA274B17DCCFC5B21B56", hash_generated_field = "08EEF0A6E1D22D736BF2E545A29D8138")

        public ArrayList<String> protectedBroadcasts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "7BB75B5E891F374B093E25AB194C5D1D", hash_generated_field = "38B8DDE984ADCEFBD679BD148096C90B")

        public ArrayList<String> usesLibraries = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "AC38B32CCC9A99E87CDDACB2B4134529", hash_generated_field = "B4E5B43916326236F7AC60FB6AA30ED0")

        public ArrayList<String> usesOptionalLibraries = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "972D60BACDDB321FD5BF3141CE25C6EF", hash_generated_field = "E256E3F26B890CB645F141CE43A19B9C")

        public String[] usesLibraryFiles = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "D4AF4457503CFB20CEDA7DA3A415725B", hash_generated_field = "E6599044F06DEA0FBD755EB8BE240A8E")

        public ArrayList<String> mOriginalPackages = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "77DFC50314330BC0CE5D97BCF4142E67", hash_generated_field = "04EBB67E52CE8E75294355C009EB60C1")

        public String mRealPackage = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "5409226BD4ABABE6DFC5D019D88E0347", hash_generated_field = "AEFDC3F9A7F5911D385620280B7625C2")

        public ArrayList<String> mAdoptPermissions = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "7536359808A247F780211CEFB8BCB220", hash_generated_field = "07357F002FB731C049A7E8EF93488FAB")

        public Bundle mAppMetaData = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "305B7716861981204869144DBD3A202B")

        public String mPath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "4C41D55D7E893B47CB2EB7473840A4CE", hash_generated_field = "2D25A57F98AA26067BCE62362DE0AEEE")

        public int mVersionCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "5EC2E990478CB2C1E53C8720FE789C1D", hash_generated_field = "AD0666B617F8EB374F674D223A151BE8")

        public String mVersionName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "1CDFFD0994D8A9956EDE5093BA49B467", hash_generated_field = "1BA8548AD03E92E8907935F23C7EC7DC")

        public String mSharedUserId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "BD7476C55BF7FEC76EBEF2CF99D574DB", hash_generated_field = "E426A46C5F8600102F790613EDFE2FA5")

        public int mSharedUserLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "0863C94B433E3584B6DB08F8A2AED72E", hash_generated_field = "D0A761ADB8F3D08D19028AF26464A727")

        public Signature mSignatures[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.890 -0400", hash_original_field = "BEC3C63CC04DE0A4383218FE553B0E8A", hash_generated_field = "CA2013AD22FC45C00B31AC00F892C7F7")

        public int mPreferredOrder = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.891 -0400", hash_original_field = "118923A78B8874C01208738CD281B567", hash_generated_field = "33A1C46140465710909573B6E270AD39")

        public String mScanPath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.891 -0400", hash_original_field = "32F5D530A8DA97268EB9B2890B2C7131", hash_generated_field = "7D697318734FF4FCAC89EE6F12A79BBA")

        public boolean mDidDexOpt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.891 -0400", hash_original_field = "F7F25A0F75E8398BAB75854C31581A1B", hash_generated_field = "01E3EC227D5D4747BBF3C8E007B87A8C")

        public int mSetEnabled = PackageManager.COMPONENT_ENABLED_STATE_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.891 -0400", hash_original_field = "254DE6C78B0F26849EEAF7B6D672C5CD", hash_generated_field = "F2AF2DCB7F1AF550D0120E8A8EC3076A")

        public boolean mSetStopped = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.891 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "31FF094E094B19A5172EF65F93099B80")

        public Object mExtras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.891 -0400", hash_original_field = "CB5C8D73EAA190766AF047FE4800181D", hash_generated_field = "006EB022C9A35AC652457AFB4C61156A")

        public boolean mOperationPending;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.893 -0400", hash_original_field = "D5CDEEF499FD2D936E2F6D7D1848D4CE", hash_generated_field = "4E89D4689FD45B6957FE611B20917965")

        public final ArrayList<ConfigurationInfo> configPreferences = new ArrayList<ConfigurationInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.893 -0400", hash_original_field = "48A101D55DB93F225A77D458DEA9C170", hash_generated_field = "56739470CD23739123AD6639F0ED5CDC")

        public ArrayList<FeatureInfo> reqFeatures = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.893 -0400", hash_original_field = "BEA549FC87D184BC2179F71B62DAB91F", hash_generated_field = "30578A504DDEAA8F4E71E08EEE4589B5")

        public int installLocation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.893 -0400", hash_original_field = "A679F1BF343DC0C0C50467BD18C8E320", hash_generated_field = "7CE719961EFE13A323B2F3853261CD27")

        public ManifestDigest manifestDigest;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.893 -0400", hash_original_method = "8954AF7805FA48686FD1C5CD1B4EC95C", hash_generated_method = "7D4DBC5FA92B3E51FD3593495D906C93")
        public  Package(String _name) {
            packageName = _name;
            applicationInfo.packageName = _name;
            applicationInfo.uid = -1;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.894 -0400", hash_original_method = "B05A09470669E629F210442116CDFAC5", hash_generated_method = "96A7635DAE33148C391664E05DF4A9F8")
        public void setPackageName(String newName) {
            packageName = newName;
            applicationInfo.packageName = newName;
for(int i=permissions.size()-1;i>=0;i--)
            {
                permissions.get(i).setPackageName(newName);
            } 
for(int i=permissionGroups.size()-1;i>=0;i--)
            {
                permissionGroups.get(i).setPackageName(newName);
            } 
for(int i=activities.size()-1;i>=0;i--)
            {
                activities.get(i).setPackageName(newName);
            } 
for(int i=receivers.size()-1;i>=0;i--)
            {
                receivers.get(i).setPackageName(newName);
            } 
for(int i=providers.size()-1;i>=0;i--)
            {
                providers.get(i).setPackageName(newName);
            } 
for(int i=services.size()-1;i>=0;i--)
            {
                services.get(i).setPackageName(newName);
            } 
for(int i=instrumentation.size()-1;i>=0;i--)
            {
                instrumentation.get(i).setPackageName(newName);
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.894 -0400", hash_original_method = "7DFEBE5DF638D8804915FD110C0E2540", hash_generated_method = "617F744BD45796FD25B748C60FBFA21B")
        public String toString() {
String var7225B3CC8914DF65BB421A6F179F031C_1823178289 =             "Package{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + packageName + "}";
            var7225B3CC8914DF65BB421A6F179F031C_1823178289.addTaint(taint);
            return var7225B3CC8914DF65BB421A6F179F031C_1823178289;
            
            
                
                
        }

        
    }


    
    public static class Component<II extends IntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.894 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "B7B17A6D136295F4EF656A6C2B786D1E")

        public Package owner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.894 -0400", hash_original_field = "99F399B171645B449364ED937DFD6F10", hash_generated_field = "D8DEE06C2E494DBB6667E43B6FBC365D")

        public ArrayList<II> intents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.895 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "868D31C10A710A0DF272DC0EA267B5A9")

        public String className;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.895 -0400", hash_original_field = "F39B17E1DA2AF1CD34AAE99B867A1C61", hash_generated_field = "94B83340D21CBE8DE8F4A432223AA875")

        public Bundle metaData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.895 -0400", hash_original_field = "FE439837C9D0340925B5F19E11F6264D", hash_generated_field = "E3D849549355C126FFF6430112CFAA0A")

        ComponentName componentName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.895 -0400", hash_original_field = "077960F927379A99EEEF4099F19C70A6", hash_generated_field = "A35E7838F783416409F7A19252F30415")

        String componentShortName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.895 -0400", hash_original_method = "B544BED1308F0633C32173E605BDF8E5", hash_generated_method = "D740BCDFFC25F96008F5E3E0E4F9606C")
        public  Component(Package _owner) {
            owner = _owner;
            intents = null;
            className = null;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.896 -0400", hash_original_method = "A43E20CDE8CCB4A62D1450265CBDCEF5", hash_generated_method = "3B9B007756A0F82A78CF4AE553A3C10A")
        public  Component(final ParsePackageItemArgs args, final PackageItemInfo outInfo) {
            owner = args.owner;
            intents = new ArrayList<II>(0);
            String name = args.sa.getNonConfigurationString(args.nameRes, 0);
    if(name == null)            
            {
                className = null;
                args.outError[0] = args.tag + " does not specify android:name";
                return;
            } 
            outInfo.name
                = buildClassName(owner.applicationInfo.packageName, name, args.outError);
    if(outInfo.name == null)            
            {
                className = null;
                args.outError[0] = args.tag + " does not have valid android:name";
                return;
            } 
            className = outInfo.name;
            int iconVal = args.sa.getResourceId(args.iconRes, 0);
    if(iconVal != 0)            
            {
                outInfo.icon = iconVal;
                outInfo.nonLocalizedLabel = null;
            } 
            int logoVal = args.sa.getResourceId(args.logoRes, 0);
    if(logoVal != 0)            
            {
                outInfo.logo = logoVal;
            } 
            TypedValue v = args.sa.peekValue(args.labelRes);
    if(v != null && (outInfo.labelRes=v.resourceId) == 0)            
            {
                outInfo.nonLocalizedLabel = v.coerceToString();
            } 
            outInfo.packageName = owner.packageName;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.896 -0400", hash_original_method = "D9B47963B1B8ABE0F2CDFAC0BBD1CAD2", hash_generated_method = "05E0E43ED97BA2AAD8F1B2B8B0B45F41")
        public  Component(final ParseComponentArgs args, final ComponentInfo outInfo) {
            this(args, (PackageItemInfo)outInfo);
            addTaint(outInfo.getTaint());
            addTaint(args.getTaint());
    if(args.outError[0] != null)            
            {
                return;
            } 
    if(args.processRes != 0)            
            {
                CharSequence pname;
    if(owner.applicationInfo.targetSdkVersion >= Build.VERSION_CODES.FROYO)                
                {
                    pname = args.sa.getNonConfigurationString(args.processRes, 0);
                } 
                else
                {
                    pname = args.sa.getNonResourceString(args.processRes);
                } 
                outInfo.processName = buildProcessName(owner.applicationInfo.packageName,
                        owner.applicationInfo.processName, pname,
                        args.flags, args.sepProcesses, args.outError);
            } 
    if(args.descriptionRes != 0)            
            {
                outInfo.descriptionRes = args.sa.getResourceId(args.descriptionRes, 0);
            } 
            outInfo.enabled = args.sa.getBoolean(args.enabledRes, true);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.897 -0400", hash_original_method = "7A30742503E7124B050658D7B849B524", hash_generated_method = "E4D8C37F23A69E539A009A28BE32977E")
        public  Component(Component<II> clone) {
            owner = clone.owner;
            intents = clone.intents;
            className = clone.className;
            componentName = clone.componentName;
            componentShortName = clone.componentShortName;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.897 -0400", hash_original_method = "BF1ED0A6C0ACE1EE7610EB0D74F5C800", hash_generated_method = "E3BEB8BB335B339C5D9597E511031E1B")
        public ComponentName getComponentName() {
    if(componentName != null)            
            {
ComponentName var7B6CF3BE908806ACB1532BFAD7EBF1F3_1171413687 =                 componentName;
                var7B6CF3BE908806ACB1532BFAD7EBF1F3_1171413687.addTaint(taint);
                return var7B6CF3BE908806ACB1532BFAD7EBF1F3_1171413687;
            } 
    if(className != null)            
            {
                componentName = new ComponentName(owner.applicationInfo.packageName,
                        className);
            } 
ComponentName var7B6CF3BE908806ACB1532BFAD7EBF1F3_1755401823 =             componentName;
            var7B6CF3BE908806ACB1532BFAD7EBF1F3_1755401823.addTaint(taint);
            return var7B6CF3BE908806ACB1532BFAD7EBF1F3_1755401823;
            
            
                
            
            
                
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.898 -0400", hash_original_method = "3A4D7499A9518F3ABB20BEBAE6816B9D", hash_generated_method = "C1824D542E717B2DCF36F94B110D8178")
        public String getComponentShortName() {
    if(componentShortName != null)            
            {
String varFA3F4C9635F1476C20031AA38480ED2D_418635972 =                 componentShortName;
                varFA3F4C9635F1476C20031AA38480ED2D_418635972.addTaint(taint);
                return varFA3F4C9635F1476C20031AA38480ED2D_418635972;
            } 
            ComponentName component = getComponentName();
    if(component != null)            
            {
                componentShortName = component.flattenToShortString();
            } 
String varFA3F4C9635F1476C20031AA38480ED2D_36651301 =             componentShortName;
            varFA3F4C9635F1476C20031AA38480ED2D_36651301.addTaint(taint);
            return varFA3F4C9635F1476C20031AA38480ED2D_36651301;
            
            
                
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.898 -0400", hash_original_method = "AFFE8B7215C15E45738BCB365FA520F8", hash_generated_method = "ED0B38A266C1BF393A5AE5820021118A")
        public void setPackageName(String packageName) {
            addTaint(packageName.getTaint());
            componentName = null;
            componentShortName = null;
            
            
            
        }

        
    }


    
    public final static class Permission extends Component<IntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.898 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "44FAE9A36D6EBA187A54E941C96BA855")

        public PermissionInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.899 -0400", hash_original_field = "C0AF77CF8294FF93A5CDB2963CA9F038", hash_generated_field = "EF09DBC8B27A53D0E48DDC50B1CFE266")

        public boolean tree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.899 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "81FA9670466619AF97D2F0A37093F67B")

        public PermissionGroup group;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.899 -0400", hash_original_method = "28D7021527B7BC8061929232C0A668B9", hash_generated_method = "8707512B571445C2CCA3E908C046D590")
        public  Permission(Package _owner) {
            super(_owner);
            addTaint(_owner.getTaint());
            info = new PermissionInfo();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.899 -0400", hash_original_method = "37E156160FC75CB3C9E2BA72594B754D", hash_generated_method = "E949AB2E0E0812B705A4BD6A0701D3BA")
        public  Permission(Package _owner, PermissionInfo _info) {
            super(_owner);
            addTaint(_owner.getTaint());
            info = _info;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.899 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.899 -0400", hash_original_method = "D70298090C91BEA7F3B1C7F9C9416449", hash_generated_method = "C8EE02DF4176DC286A6D5E2A883B81CC")
        public String toString() {
String varA4B73F78D64437A97BC4CB3FE2F19AAD_1729829481 =             "Permission{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
            varA4B73F78D64437A97BC4CB3FE2F19AAD_1729829481.addTaint(taint);
            return varA4B73F78D64437A97BC4CB3FE2F19AAD_1729829481;
            
            
                
                
        }

        
    }


    
    public final static class PermissionGroup extends Component<IntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.899 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "4AEC0127E51446670A8F6715545F2FFD")

        public PermissionGroupInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.900 -0400", hash_original_method = "19A5AAAA7728282CABC960AB069F9E98", hash_generated_method = "B5A5E2D4B3E639BF01CEC8D0362F5ECF")
        public  PermissionGroup(Package _owner) {
            super(_owner);
            addTaint(_owner.getTaint());
            info = new PermissionGroupInfo();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.900 -0400", hash_original_method = "8FB9374E9D85DC0253F34BC909070B56", hash_generated_method = "C6070FF59C068E97212414DCA5EB0187")
        public  PermissionGroup(Package _owner, PermissionGroupInfo _info) {
            super(_owner);
            addTaint(_owner.getTaint());
            info = _info;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.900 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.900 -0400", hash_original_method = "5B6E9035FB2F0E9673597108CCAFFCEF", hash_generated_method = "6BCF783EEAD382B47E594BBB10D2E714")
        public String toString() {
String var230D88132BCDB5C1EFFF3FA52025C2F5_1799364640 =             "PermissionGroup{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
            var230D88132BCDB5C1EFFF3FA52025C2F5_1799364640.addTaint(taint);
            return var230D88132BCDB5C1EFFF3FA52025C2F5_1799364640;
            
            
                
                
        }

        
    }


    
    public final static class Activity extends Component<ActivityIntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.900 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "31C563E0B9BB4DA4F801727DD7960E99")

        public ActivityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.900 -0400", hash_original_method = "2916F6991906FCE3DAEE226AB756275F", hash_generated_method = "C5644F879FB9CA9E6C46626AFFCC6523")
        public  Activity(final ParseComponentArgs args, final ActivityInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.901 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.901 -0400", hash_original_method = "3ED5BAD5E29B5F8C3FFE202D917D91C6", hash_generated_method = "F0D41D0BE3D7158E17E74597FC3DB58E")
        public String toString() {
String var7349656C7BD58594155B01DB7429F0FA_2050031672 =             "Activity{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
            var7349656C7BD58594155B01DB7429F0FA_2050031672.addTaint(taint);
            return var7349656C7BD58594155B01DB7429F0FA_2050031672;
            
            
                
                
        }

        
    }


    
    public final static class Service extends Component<ServiceIntentInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.901 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "44442782625E786E51B742A3D7D5DE80")

        public ServiceInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.902 -0400", hash_original_method = "2742F060EFDB78FDF4E4BA2659F1DC82", hash_generated_method = "E6E889FECE4BAD756F1CCD77DCFEFAE8")
        public  Service(final ParseComponentArgs args, final ServiceInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.903 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.903 -0400", hash_original_method = "983F0C4312E41963E910123205C22323", hash_generated_method = "6DB2CF948CFA2F2697CDD5874CE9D2A6")
        public String toString() {
String varE0BB0FB3650D73E43E1F3BF4E654C95D_1417534924 =             "Service{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
            varE0BB0FB3650D73E43E1F3BF4E654C95D_1417534924.addTaint(taint);
            return varE0BB0FB3650D73E43E1F3BF4E654C95D_1417534924;
            
            
                
                
        }

        
    }


    
    public final static class Provider extends Component {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.903 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "BF776B364C73D31E6B3B31185D6DF955")

        public ProviderInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.903 -0400", hash_original_field = "BB5ED03A2B1CAD35E912B9A1FBB4B102", hash_generated_field = "8DCC80DE4F5A821BFB32172415658FEA")

        public boolean syncable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.903 -0400", hash_original_method = "EAE8B6AC135EBC96C8D24D047B180DE5", hash_generated_method = "343B3653CFEC536617399565A9DBD70E")
        public  Provider(final ParseComponentArgs args, final ProviderInfo _info) {
            super(args, _info);
            info = _info;
            info.applicationInfo = args.owner.applicationInfo;
            syncable = false;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.903 -0400", hash_original_method = "7DA675634165C06E74013727D919E49C", hash_generated_method = "150CC3EFD195162CC132E1D5F85237A7")
        public  Provider(Provider existingProvider) {
            super(existingProvider);
            this.info = existingProvider.info;
            this.syncable = existingProvider.syncable;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.906 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.906 -0400", hash_original_method = "68549008F1EBCA6BA1DE59DAB2FE7E3C", hash_generated_method = "C2993D2A3D8B0E59714411E886252D1D")
        public String toString() {
String var57150B0931FFC28ACB80176BA213B66A_124666187 =             "Provider{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + info.name + "}";
            var57150B0931FFC28ACB80176BA213B66A_124666187.addTaint(taint);
            return var57150B0931FFC28ACB80176BA213B66A_124666187;
            
            
                
                
        }

        
    }


    
    public final static class Instrumentation extends Component {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.907 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "9E4A99D8D40782E1B858164167767C21")

        public InstrumentationInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.907 -0400", hash_original_method = "CAE763D5DCD2DC693DEEA83AE92F98C5", hash_generated_method = "581298DE305784FBB2B4E24A97D7CBBE")
        public  Instrumentation(final ParsePackageItemArgs args, final InstrumentationInfo _info) {
            super(args, _info);
            addTaint(args.getTaint());
            info = _info;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.907 -0400", hash_original_method = "A1B5C71CB6AEE57E256089FBBB6F3210", hash_generated_method = "10C7D0C53A4ED20F8E3E70EEE720E714")
        public void setPackageName(String packageName) {
            super.setPackageName(packageName);
            info.packageName = packageName;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.907 -0400", hash_original_method = "CB405027A6A70334D830F0B5C698645E", hash_generated_method = "484499E788420FBE32CD3103CE0EB871")
        public String toString() {
String varB0CB4174C45C34ACD15551F9B93A3408_1127556197 =             "Instrumentation{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + getComponentShortName() + "}";
            varB0CB4174C45C34ACD15551F9B93A3408_1127556197.addTaint(taint);
            return varB0CB4174C45C34ACD15551F9B93A3408_1127556197;
            
            
                
                
        }

        
    }


    
    public static class IntentInfo extends IntentFilter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_field = "4A519AFAA26CDED890B9053870E60EE0", hash_generated_field = "27741E2F90129BA4D13424CA3120F0CA")

        public boolean hasDefault;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

        public int labelRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_field = "C217EC6D87004328FDE9713C8BDFACF1", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

        public CharSequence nonLocalizedLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_field = "96D6F2E7E1F705AB5E59C84A6DC009B2", hash_generated_field = "922885A8A44FD4A4B2D8F0B49A2EDED6")

        public int logo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_method = "351B7321F95DEA4A1F6C5D218D4A2DB8", hash_generated_method = "351B7321F95DEA4A1F6C5D218D4A2DB8")
        public IntentInfo ()
        {
            
        }


    }


    
    public final static class ActivityIntentInfo extends IntentInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "8EB481EDAD2FDE318A05890E655F5C10")

        public Activity activity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_method = "4F41670063BD951D72DDB0235971893F", hash_generated_method = "0462B156AB73AD83F3A7439B178E9A79")
        public  ActivityIntentInfo(Activity _activity) {
            activity = _activity;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.908 -0400", hash_original_method = "7C91146E1C4D7077E2D0C55B0D43BF57", hash_generated_method = "1183D2B74FE012501FA63876DCBE3A72")
        public String toString() {
String var8C912E976DD3A09E794833615D8D03AB_1123383047 =             "ActivityIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + activity.info.name + "}";
            var8C912E976DD3A09E794833615D8D03AB_1123383047.addTaint(taint);
            return var8C912E976DD3A09E794833615D8D03AB_1123383047;
            
            
                
                
        }

        
    }


    
    public final static class ServiceIntentInfo extends IntentInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "6630E432AFBDE1086EB9C8736D3C1E75")

        public Service service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_method = "2C256432D4530E0F15F4AED85D9A44A0", hash_generated_method = "61FE60C3F8E05F8F2F3135BC3B31D794")
        public  ServiceIntentInfo(Service _service) {
            service = _service;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_method = "32EA4E8A8FC07DAD01188F341ACB2C51", hash_generated_method = "98141F9168956B494928DDA755B25887")
        public String toString() {
String var9772429D16BD47DBA31528978466C827_1420370459 =             "ServiceIntentInfo{"
                + Integer.toHexString(System.identityHashCode(this))
                + " " + service.info.name + "}";
            var9772429D16BD47DBA31528978466C827_1420370459.addTaint(taint);
            return var9772429D16BD47DBA31528978466C827_1420370459;
            
            
                
                
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "DF32A01F1FE4B2A11EE5A767A1DCD552", hash_generated_field = "252B27621B0C95282FCD74EADD1D3B06")

    private static final boolean DEBUG_JAR = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "2C3E9FD0BD054C424AC0B88DD61CF722", hash_generated_field = "74CDFDDFB4ADEE936A3A2D224333889E")

    private static final boolean DEBUG_PARSER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "913A503348F076CE40FF70939F52E21D", hash_generated_field = "E528C7EA12190339B7B5F859330E06A3")

    private static final boolean DEBUG_BACKUP = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "67E7CF7E198C33B841936D6E63E6EDE6", hash_generated_field = "4F97594385EB4442B91157C93FC88149")

    private static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "DAF8613F9A421919597993B9BB9712C9", hash_generated_field = "4E7CCA62AA0883D7BED63D0B9D564192")

    public static final PackageParser.NewPermissionInfo NEW_PERMISSIONS[] =
        new PackageParser.NewPermissionInfo[] {
            new PackageParser.NewPermissionInfo(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.os.Build.VERSION_CODES.DONUT, 0),
            new PackageParser.NewPermissionInfo(android.Manifest.permission.READ_PHONE_STATE,
                    android.os.Build.VERSION_CODES.DONUT, 0)
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "6D5D7CA40886C0578E6E1B6029816C0A", hash_generated_field = "905C38351D97D12004B7C4F50D80A9E2")

    private static final int SDK_VERSION = Build.VERSION.SDK_INT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "6DAB7D8ACE498068F8FC2A32149CE97B", hash_generated_field = "F491825EC7555754BC21523DA68EFCCB")

    private static final String SDK_CODENAME = "REL".equals(Build.VERSION.CODENAME)
            ? null : Build.VERSION.CODENAME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.909 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "F668D47897E28620543685D1E68BB2A5")

    private static final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "270CD8B630C808D6EB383BF510F99004", hash_generated_field = "C91A03D8C0281FD6FE8F7562B14775C4")

    private static WeakReference<byte[]> mReadBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "CBEF5DB12FFFB461F3C4D3FC457C23AE", hash_generated_field = "23A0E0B3C74959CD54FEA5BC7440ADA6")

    private static boolean sCompatibilityModeEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "0B016151FBE3216EBBE16B193D5653DA", hash_generated_field = "1FDCA6654F70EEBFD65FBF1AF519E5AA")

    private static final int PARSE_DEFAULT_INSTALL_LOCATION = PackageInfo.INSTALL_LOCATION_UNSPECIFIED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "6F33513A583DE10D0C82FE4E1558B70F", hash_generated_field = "9B95BCC659E00681D48AF406E80790EA")

    private static final boolean RIGID_PARSER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "B6B26328D0AF58045609750A8B7ADC87", hash_generated_field = "DD8609BA0B76A819C8573C819B7348A6")

    private static final String TAG = "PackageParser";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "68F6206F996CB412F857963D11B7A32D", hash_generated_field = "4B52CDD8E5ADCA354868822A64689A48")

    public final static int PARSE_IS_SYSTEM = 1<<0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "A79C5A5D953DF9B12E4BDE6E62BEC1FF", hash_generated_field = "D16481D6B9C894AA8F9AD72D6FF3BE41")

    public final static int PARSE_CHATTY = 1<<1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "EDFF4D39F335C2167F0E9CC96620C90B", hash_generated_field = "D85F2CA29F944D705DACCE7CFE1CCC41")

    public final static int PARSE_MUST_BE_APK = 1<<2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "552E0FAF6FF6F37C9E44411963C4429C", hash_generated_field = "28588A534392FDDD099636AF774A3125")

    public final static int PARSE_IGNORE_PROCESSES = 1<<3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "326B35AE4CA29ADCD45422E9FB0C9C13", hash_generated_field = "55AEA484B033A779430356E4D8F71309")

    public final static int PARSE_FORWARD_LOCK = 1<<4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "F474095F0973F733CAF1E2E7B4FF3A07", hash_generated_field = "E1C3B202E87D4E3614B1E66CD70ED663")

    public final static int PARSE_ON_SDCARD = 1<<5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "F5E0411EB76EA9B316F7FECD7812427B", hash_generated_field = "3D41C84BD91D95AD71586AAACE412C36")

    public final static int PARSE_IS_SYSTEM_DIR = 1<<6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:13.910 -0400", hash_original_field = "7A09AF7826D2C4F40EE97D33D975F54E", hash_generated_field = "1E8F77612F2ACC70744F2BEF9D03FB1E")

    private static final String ANDROID_RESOURCES = "http://schemas.android.com/apk/res/android";
}

