package org.apache.http.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;






public class VersionInfo {


    /**
     * Loads version information for a list of packages.
     *
     * @param pckgs     the packages for which to load version info
     * @param clsldr    the classloader to load from, or
     *                  <code>null</code> for the thread context classloader
     *
     * @return  the version information for all packages found,
     *          never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.543 -0500", hash_original_method = "30B86613A1A86863CB3CC06881524D96", hash_generated_method = "79A44A5945DF7BD54D84D1E861FA1CD1")
    public final static VersionInfo[] loadVersionInfo(String[] pckgs,
                                                      ClassLoader clsldr) {
        if (pckgs == null) {
            throw new IllegalArgumentException
                ("Package identifier list must not be null.");
        }

        ArrayList vil = new ArrayList(pckgs.length);
        for (int i=0; i<pckgs.length; i++) {
            VersionInfo vi = loadVersionInfo(pckgs[i], clsldr);
            if (vi != null)
                vil.add(vi);
        }

        return (VersionInfo[]) vil.toArray(new VersionInfo[vil.size()]);
    }


    /**
     * Loads version information for a package.
     *
     * @param pckg      the package for which to load version information,
     *                  for example "org.apache.http".
     *                  The package name should NOT end with a dot.
     * @param clsldr    the classloader to load from, or
     *                  <code>null</code> for the thread context classloader
     *
     * @return  the version information for the argument package, or
     *          <code>null</code> if not available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.544 -0500", hash_original_method = "25D0039F966FF4332DD9B5E2415DB39B", hash_generated_method = "F48DB99B681DDF490E22197D3DBE5DCB")
    public final static VersionInfo loadVersionInfo(final String pckg,
                                                    ClassLoader clsldr) {
        if (pckg == null) {
            throw new IllegalArgumentException
                ("Package identifier must not be null.");
        }

        if (clsldr == null)
            clsldr = Thread.currentThread().getContextClassLoader();

        Properties vip = null; // version info properties, if available
        try {
            // org.apache.http      becomes
            // org/apache/http/version.properties
            InputStream is = clsldr.getResourceAsStream
                (pckg.replace('.', '/') + "/" + VERSION_PROPERTY_FILE);
            if (is != null) {
                try {
                    Properties props = new Properties();
                    props.load(is);
                    vip = props;
                } finally {
                    is.close();
                }
            }
        } catch (IOException ex) {
            // shamelessly munch this exception
        }

        VersionInfo result = null;
        if (vip != null)
            result = fromMap(pckg, vip, clsldr);

        return result;
    }


    /**
     * Instantiates version information from properties.
     *
     * @param pckg      the package for the version information
     * @param info      the map from string keys to string values,
     *                  for example {@link java.util.Properties}
     * @param clsldr    the classloader, or <code>null</code>
     *
     * @return  the version information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.546 -0500", hash_original_method = "3A633183B8FA74E726B48B3496916A31", hash_generated_method = "57F4C06037F48066098DE384581B21F8")
    protected final static VersionInfo fromMap(String pckg, Map info,
                                               ClassLoader clsldr) {
        if (pckg == null) {
            throw new IllegalArgumentException
                ("Package identifier must not be null.");
        }

        String module = null;
        String release = null;
        String timestamp = null;

        if (info != null) {
            module = (String) info.get(PROPERTY_MODULE);
            if ((module != null) && (module.length() < 1))
                module = null;

            release = (String) info.get(PROPERTY_RELEASE);
            if ((release != null) && ((release.length() < 1) ||
                                      (release.equals("${pom.version}"))))
                release = null;

            timestamp = (String) info.get(PROPERTY_TIMESTAMP);
            if ((timestamp != null) &&
                ((timestamp.length() < 1) ||
                 (timestamp.equals("${mvn.timestamp}")))
                )
                timestamp = null;
        } // if info

        String clsldrstr = null;
        if (clsldr != null)
            clsldrstr = clsldr.toString();

        return new VersionInfo(pckg, module, release, timestamp, clsldrstr);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.529 -0500", hash_original_field = "7D34649CF977B0FA198B6582E05DC9B9", hash_generated_field = "AFAF2F28F05D4061200FCFA3487DA249")

    public final static String UNAVAILABLE = "UNAVAILABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.530 -0500", hash_original_field = "AAFED1EDB53DAF77F1A6F4B8F2DE7A61", hash_generated_field = "0594314A1812329E1C3DCDC2FB3A25A4")

    public final static String VERSION_PROPERTY_FILE = "version.properties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.530 -0500", hash_original_field = "2C011340FAC253D65BFB1EBD865AD143", hash_generated_field = "41E29EFD75D15AF6B8FD255DC62C3536")

    public final static String PROPERTY_MODULE    = "info.module";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.531 -0500", hash_original_field = "B8DA41DF6609B0D8CB875682963E7A9A", hash_generated_field = "7651AC9A1406175E054F8B0C10C0345A")

    public final static String PROPERTY_RELEASE   = "info.release";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.532 -0500", hash_original_field = "122464028823C63B623ED60FF883E082", hash_generated_field = "ADDFC93497C4D56A7904659C216B56D5")

    public final static String PROPERTY_TIMESTAMP = "info.timestamp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.533 -0500", hash_original_field = "72C947509ED331F2427D14E6186357AB", hash_generated_field = "B4EE0AE6CDFC7729E2DF3959619B27C8")

    private  String infoPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.534 -0500", hash_original_field = "86CDFEB4B77B4D13A3922B0AE4964191", hash_generated_field = "7870583402D1236432A6F7D41D68C373")

    private  String infoModule;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.535 -0500", hash_original_field = "E7F14D382E3E4FEB0CF1132C3967531C", hash_generated_field = "74D9C07996ADE3E83000645DFD186109")

    private  String infoRelease;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.535 -0500", hash_original_field = "A7839D44F95D43372A625F487F062C47", hash_generated_field = "EA392AC69F638BDF62EBE0A6225718A4")

    private  String infoTimestamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.536 -0500", hash_original_field = "E0A3181AA485FEDD5C157DF76892BFC9", hash_generated_field = "CFCBDAB909290EB8EDE48215C3716785")

    private  String infoClassloader;


    /**
     * Instantiates version information.
     *
     * @param pckg      the package
     * @param module    the module, or <code>null</code>
     * @param release   the release, or <code>null</code>
     * @param time      the build time, or <code>null</code>
     * @param clsldr    the class loader, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.537 -0500", hash_original_method = "A021B9E0131A2ECDBAD4FC090EED8BCD", hash_generated_method = "73299216F663CE86B75D1ECD0099BE6B")
    protected VersionInfo(String pckg, String module,
                          String release, String time, String clsldr) {
        if (pckg == null) {
            throw new IllegalArgumentException
                ("Package identifier must not be null.");
        }

        infoPackage     = pckg;
        infoModule      = (module  != null) ? module  : UNAVAILABLE;
        infoRelease     = (release != null) ? release : UNAVAILABLE;
        infoTimestamp   = (time    != null) ? time    : UNAVAILABLE;
        infoClassloader = (clsldr  != null) ? clsldr  : UNAVAILABLE;
    }


    /**
     * Obtains the package name.
     * The package name identifies the module or informal unit.
     *
     * @return  the package name, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.538 -0500", hash_original_method = "252EB5EFBA4DF288F0FE3B9299593BCD", hash_generated_method = "22F39F471E7BA917155E3ABEDD21124D")
    public final String getPackage() {
        return infoPackage;
    }

    /**
     * Obtains the name of the versioned module or informal unit.
     * This data is read from the version information for the package.
     *
     * @return  the module name, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.539 -0500", hash_original_method = "817D4ED1C3BFE1B9928E002CE96AD55A", hash_generated_method = "9FA70497A0B568272C22E2D7D1465604")
    public final String getModule() {
        return infoModule;
    }

    /**
     * Obtains the release of the versioned module or informal unit.
     * This data is read from the version information for the package.
     *
     * @return  the release version, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.540 -0500", hash_original_method = "DAD9A741167B359FF642D16AB5684AA5", hash_generated_method = "6625A1159AB2C732AF45A1AD0A5184FE")
    public final String getRelease() {
        return infoRelease;
    }

    /**
     * Obtains the timestamp of the versioned module or informal unit.
     * This data is read from the version information for the package.
     *
     * @return  the timestamp, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.541 -0500", hash_original_method = "02D289A8C155EDCB8F2FF743050BA3A2", hash_generated_method = "BB0926950B351A88284E2CEE066CD9E2")
    public final String getTimestamp() {
        return infoTimestamp;
    }

    /**
     * Obtains the classloader used to read the version information.
     * This is just the <code>toString</code> output of the classloader,
     * since the version information should not keep a reference to
     * the classloader itself. That could prevent garbage collection.
     *
     * @return  the classloader description, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.542 -0500", hash_original_method = "8670EE78560EBB156BF6A930F22A1F67", hash_generated_method = "6B971157873DE5616535678624C164ED")
    public final String getClassloader() {
        return infoClassloader;
    }


    /**
     * Provides the version information in human-readable format.
     *
     * @return  a string holding this version information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.543 -0500", hash_original_method = "8C041823EF127A6F9DCC25E0329C5A09", hash_generated_method = "E6994078FCA41404F2ACCD485CC61315")
    public String toString() {
        StringBuffer sb = new StringBuffer
            (20 + infoPackage.length() + infoModule.length() +
             infoRelease.length() + infoTimestamp.length() +
             infoClassloader.length());

        sb.append("VersionInfo(")
            .append(infoPackage).append(':').append(infoModule);

        // If version info is missing, a single "UNAVAILABLE" for the module
        // is sufficient. Everything else just clutters the output.
        if (!UNAVAILABLE.equals(infoRelease))
            sb.append(':').append(infoRelease);
        if (!UNAVAILABLE.equals(infoTimestamp))
            sb.append(':').append(infoTimestamp);

        sb.append(')');

        if (!UNAVAILABLE.equals(infoClassloader))
            sb.append('@').append(infoClassloader);

        return sb.toString();
    }
}

