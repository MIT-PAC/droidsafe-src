package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.URL;

import dalvik.system.VMStack;

public class Package implements AnnotatedElement {

    /**
     * Attempts to locate the requested package in the caller's class loader. If
     * no package information can be located, {@code null} is returned.
     *
     * @param packageName
     *            the name of the package to find.
     * @return the requested package, or {@code null}.
     * @see ClassLoader#getPackage(java.lang.String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.159 -0500", hash_original_method = "10159562E7C8BDDC782B1B1B486A12DE", hash_generated_method = "2F903CA5C20B82E314630C58709650B7")
    
public static Package getPackage(String packageName) {
        ClassLoader classloader = VMStack.getCallingClassLoader();
        if (classloader == null) {
            classloader = ClassLoader.getSystemClassLoader();
        }
        return classloader.getPackage(packageName);
    }

    /**
     * Returns all the packages known to the caller's class loader.
     *
     * @return all the packages known to the caller's class loader.
     * @see ClassLoader#getPackages
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.162 -0500", hash_original_method = "E96D25DC605E56517EDAA8421D2114F6", hash_generated_method = "47BBFCFD51DD607E08A11B0100E37F4D")
    
public static Package[] getPackages() {
        ClassLoader classloader = VMStack.getCallingClassLoader();
        if (classloader == null) {
            classloader = ClassLoader.getSystemClassLoader();
        }
        return classloader.getPackages();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.113 -0500", hash_original_field = "0C73BE0651CF116606278017BBAFA70A", hash_generated_field = "D584CD4D5524F6C731424F703C29B84F")

    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.116 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.119 -0500", hash_original_field = "9329AD5B2A0CEB786C4A9564E64F4187", hash_generated_field = "AE81573D9500136C0B4AD5C6FB30BF01")

    private  String specTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.121 -0500", hash_original_field = "0BDF4FC10D526FCE633543481DD62AB3", hash_generated_field = "8AC9ABDDED2DE61D44AD918D71798BCD")

    private  String specVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.124 -0500", hash_original_field = "D3F6EEA6B78DFA77F9AFCBE434B3B6DD", hash_generated_field = "09287EC9275D23DEE889105D11CDB13B")

    private  String specVendor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.126 -0500", hash_original_field = "FC3978EDCC62658BE59859801191DF4E", hash_generated_field = "85F560479896D7F78D6BB28FAF454380")

    private  String implTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.128 -0500", hash_original_field = "464BEF3FFC4F7C33EE53785987288A8B", hash_generated_field = "D5CDC04B85CD9B13DDD14861DBF2473C")

    private  String implVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.131 -0500", hash_original_field = "4A3CEF10B78E7804D3EAD96358D386BE", hash_generated_field = "3329CC794A5B24A56B07AB39A5F7B7A7")

    private  String implVendor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.133 -0500", hash_original_field = "39F51311234D72CC082A21B6047FFBC5", hash_generated_field = "E6323554A81EBA1D12B93E5F630D84CC")

    private  URL sealBase;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.136 -0500", hash_original_method = "374156791F3AAF85E275A2925DC8F66C", hash_generated_method = "374156791F3AAF85E275A2925DC8F66C")
    
Package(String name, String specTitle, String specVersion, String specVendor,
            String implTitle, String implVersion, String implVendor, URL sealBase) {
        this.name = name;
        this.specTitle = specTitle;
        this.specVersion = specVersion;
        this.specVendor = specVendor;
        this.implTitle = implTitle;
        this.implVersion = implVersion;
        this.implVendor = implVendor;
        this.sealBase = sealBase;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.415 -0400", hash_original_method = "1D0B4DB439BD39BE82415F0E494CFB63", hash_generated_method = "686D6C770160E2E9635418430D737165")
    @SuppressWarnings("unchecked")
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
for(Annotation annotation : getAnnotations())
        {
            if(annotationType.isInstance(annotation))            
            {
A var2A4302F2C71F8CB31F4FBBBA89DC4531_2117789764 =                 (A) annotation;
                var2A4302F2C71F8CB31F4FBBBA89DC4531_2117789764.addTaint(taint);
                return var2A4302F2C71F8CB31F4FBBBA89DC4531_2117789764;
            } //End block
        } //End block
A var540C13E9E156B687226421B24F2DF178_1222859646 =         null;
        var540C13E9E156B687226421B24F2DF178_1222859646.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1222859646;
        // ---------- Original Method ----------
        //for (Annotation annotation : getAnnotations()) {
            //if (annotationType.isInstance(annotation)) {
                //return (A) annotation;
            //}
        //}
        //return null;
    }

    /**
     * Returns an empty array. Package annotations are not supported on Android.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.141 -0500", hash_original_method = "CE9406711F7ECFD943F53415A91A4AFB", hash_generated_method = "CB29FE8C680345CB2328C2BD219C5B28")
    
public Annotation[] getAnnotations() {
        return NO_ANNOTATIONS;
    }

    /**
     * Returns an empty array. Package annotations are not supported on Android.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.143 -0500", hash_original_method = "85F9B8C255479693ABE2E35CFE49FA4D", hash_generated_method = "6CBAC098254AA46C825713EB23ADAD70")
    
public Annotation[] getDeclaredAnnotations() {
        return NO_ANNOTATIONS;
    }

    /**
     * Indicates whether the specified annotation is present.
     *
     * @param annotationType
     *            the annotation type to look for.
     * @return {@code true} if the annotation is present; {@code false}
     *         otherwise.
     * @see java.lang.reflect.AnnotatedElement#isAnnotationPresent(java.lang.Class)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.146 -0500", hash_original_method = "5232C7D94E7B41515E39CA253236284F", hash_generated_method = "225772F708D97128A8DAA5A4D24733D0")
    
public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        return getAnnotation(annotationType) != null;
    }

    /**
     * Returns the title of the implementation of this package, or {@code null}
     * if this is unknown. The format of this string is unspecified.
     *
     * @return the implementation title, may be {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.148 -0500", hash_original_method = "E42A840611E51BD44AB9A8F4763E49C9", hash_generated_method = "0FC7754DFEEEEFD9AE99629F95509E10")
    
public String getImplementationTitle() {
        return implTitle;
    }

    /**
     * Returns the name of the vendor or organization that provides this
     * implementation of the package, or {@code null} if this is unknown. The
     * format of this string is unspecified.
     *
     * @return the implementation vendor name, may be {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.151 -0500", hash_original_method = "D69197AE643082D750CA7D47C00F7B92", hash_generated_method = "CF0E3C9C03130A8D32D2CC9215AE7B81")
    
public String getImplementationVendor() {
        return implVendor;
    }

    /**
     * Returns the version of the implementation of this package, or {@code
     * null} if this is unknown. The format of this string is unspecified.
     *
     * @return the implementation version, may be {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.154 -0500", hash_original_method = "B250FD1AF223F79726E50E96D0BA0340", hash_generated_method = "55329D98772649FAC10085F7E5A19C24")
    
public String getImplementationVersion() {
        return implVersion;
    }

    /**
     * Returns the name of this package in the standard dot notation; for
     * example: "java.lang".
     *
     * @return the name of this package.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.156 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns the title of the specification this package implements, or
     * {@code null} if this is unknown.
     *
     * @return the specification title, may be {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.164 -0500", hash_original_method = "C2759232E597756D73053EF3F23A361A", hash_generated_method = "EEEBBADB40D376E8C7074DF9EB541A94")
    
public String getSpecificationTitle() {
        return specTitle;
    }

    /**
     * Returns the name of the vendor or organization that owns and maintains
     * the specification this package implements, or {@code null} if this is
     * unknown.
     *
     * @return the specification vendor name, may be {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.167 -0500", hash_original_method = "973AEF12B2769D423D9BB1FEC4D6C13E", hash_generated_method = "65DAAC27E879FA1D2D5E4C65B67E4EB8")
    
public String getSpecificationVendor() {
        return specVendor;
    }

    /**
     * Returns the version of the specification this package implements, or
     * {@code null} if this is unknown. The version string is a sequence of
     * non-negative integers separated by dots; for example: "1.2.3".
     *
     * @return the specification version string, may be {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.169 -0500", hash_original_method = "1669663C0689EAEF8399B71C607499D9", hash_generated_method = "F88B4A3035BA3CCD1ED01E8E42B8326D")
    
public String getSpecificationVersion() {
        return specVersion;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.171 -0500", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "79AB96931D4D2744C8AC02B11E3A7517")
    
@Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Indicates whether this package's specification version is compatible with
     * the specified version string. Version strings are compared by comparing
     * each dot separated part of the version as an integer.
     *
     * @param version
     *            the version string to compare against.
     * @return {@code true} if the package versions are compatible; {@code
     *         false} otherwise.
     * @throws NumberFormatException
     *             if this package's version string or the one provided are not
     *             in the correct format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.174 -0500", hash_original_method = "FB75035D423229FA706BBCEA41A373A6", hash_generated_method = "ECDA8D54C75B27EB12F90F5381C51966")
    
public boolean isCompatibleWith(String version) throws NumberFormatException {
        String[] requested = version.split("\\.");
        String[] provided = specVersion.split("\\.");

        for (int i = 0; i < Math.min(requested.length, provided.length); i++) {
            int reqNum = Integer.parseInt(requested[i]);
            int provNum = Integer.parseInt(provided[i]);

            if (reqNum > provNum) {
                return false;
            } else if (reqNum < provNum) {
                return true;
            }
        }

        if (requested.length > provided.length) {
            return false;
        }

        return true;
    }

    /**
     * Indicates whether this package is sealed.
     *
     * @return {@code true} if this package is sealed; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.176 -0500", hash_original_method = "8B9E9C35AFB855740620C92F002E4A38", hash_generated_method = "D93A43812A9CA0B98209947C6F6A18EE")
    
public boolean isSealed() {
        return sealBase != null;
    }

    /**
     * Indicates whether this package is sealed with respect to the specified
     * URL.
     *
     * @param url
     *            the URL to check.
     * @return {@code true} if this package is sealed with {@code url}; {@code
     *         false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.178 -0500", hash_original_method = "55B8ABCD808682E10A2965544061F7A5", hash_generated_method = "287EF2A604F94B823DCF0CE559604AFE")
    
public boolean isSealed(URL url) {
        return sealBase != null && sealBase.sameFile(url);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.181 -0500", hash_original_method = "8B76FC83381F276BB56C5A0620FC8DEC", hash_generated_method = "0BD90C291C1F2BCF1D5C382F021941D5")
    
@Override
    public String toString() {
        return "package " + name;
    }
}

