package org.apache.http.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;






public class VersionInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.583 -0400", hash_original_field = "5DC10C942C376F4D917341A8F6F35478", hash_generated_field = "B4EE0AE6CDFC7729E2DF3959619B27C8")

    private String infoPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.583 -0400", hash_original_field = "BA892CFE0935336DF5E973F2BE5269FA", hash_generated_field = "7870583402D1236432A6F7D41D68C373")

    private String infoModule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.583 -0400", hash_original_field = "2AC10596AA95DD9C7AED402610900006", hash_generated_field = "74D9C07996ADE3E83000645DFD186109")

    private String infoRelease;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.583 -0400", hash_original_field = "DFF8EFAF20F67E9BD2E5C73ED9544E0C", hash_generated_field = "EA392AC69F638BDF62EBE0A6225718A4")

    private String infoTimestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.583 -0400", hash_original_field = "5215DDB0C971D4489020CDF1892A02D4", hash_generated_field = "CFCBDAB909290EB8EDE48215C3716785")

    private String infoClassloader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.584 -0400", hash_original_method = "A021B9E0131A2ECDBAD4FC090EED8BCD", hash_generated_method = "7A93125B07271CF07DD4EAC6B926DCFA")
    protected  VersionInfo(String pckg, String module,
                          String release, String time, String clsldr) {
        if(pckg == null)        
        {
            IllegalArgumentException varCFB8741E3841429A4652974A36687704_351007285 = new IllegalArgumentException
                ("Package identifier must not be null.");
            varCFB8741E3841429A4652974A36687704_351007285.addTaint(taint);
            throw varCFB8741E3841429A4652974A36687704_351007285;
        } //End block
        infoPackage     = pckg;
        infoModule      = (module  != null) ? module  : UNAVAILABLE;
        infoRelease     = (release != null) ? release : UNAVAILABLE;
        infoTimestamp   = (time    != null) ? time    : UNAVAILABLE;
        infoClassloader = (clsldr  != null) ? clsldr  : UNAVAILABLE;
        // ---------- Original Method ----------
        //if (pckg == null) {
            //throw new IllegalArgumentException
                //("Package identifier must not be null.");
        //}
        //infoPackage     = pckg;
        //infoModule      = (module  != null) ? module  : UNAVAILABLE;
        //infoRelease     = (release != null) ? release : UNAVAILABLE;
        //infoTimestamp   = (time    != null) ? time    : UNAVAILABLE;
        //infoClassloader = (clsldr  != null) ? clsldr  : UNAVAILABLE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.584 -0400", hash_original_method = "252EB5EFBA4DF288F0FE3B9299593BCD", hash_generated_method = "F867F1FF9EABA242E4E5200825023057")
    public final String getPackage() {
String varAA055AF7498388EB82F572AD27B27479_432131374 =         infoPackage;
        varAA055AF7498388EB82F572AD27B27479_432131374.addTaint(taint);
        return varAA055AF7498388EB82F572AD27B27479_432131374;
        // ---------- Original Method ----------
        //return infoPackage;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.585 -0400", hash_original_method = "817D4ED1C3BFE1B9928E002CE96AD55A", hash_generated_method = "2F24B365F4939E79F8B5F24525BAD37E")
    public final String getModule() {
String var606B884BA5A756273394B916A155F040_2098416478 =         infoModule;
        var606B884BA5A756273394B916A155F040_2098416478.addTaint(taint);
        return var606B884BA5A756273394B916A155F040_2098416478;
        // ---------- Original Method ----------
        //return infoModule;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.585 -0400", hash_original_method = "DAD9A741167B359FF642D16AB5684AA5", hash_generated_method = "30238D31475B19B1E0290C1F9DD4FD65")
    public final String getRelease() {
String var6C4195C569DF6472690519AC429B94E4_256977449 =         infoRelease;
        var6C4195C569DF6472690519AC429B94E4_256977449.addTaint(taint);
        return var6C4195C569DF6472690519AC429B94E4_256977449;
        // ---------- Original Method ----------
        //return infoRelease;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.585 -0400", hash_original_method = "02D289A8C155EDCB8F2FF743050BA3A2", hash_generated_method = "1555CE11217CCC3C332C3C675227B472")
    public final String getTimestamp() {
String var7C48C24921EE033BF6772198C34357EE_1604392619 =         infoTimestamp;
        var7C48C24921EE033BF6772198C34357EE_1604392619.addTaint(taint);
        return var7C48C24921EE033BF6772198C34357EE_1604392619;
        // ---------- Original Method ----------
        //return infoTimestamp;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.585 -0400", hash_original_method = "8670EE78560EBB156BF6A930F22A1F67", hash_generated_method = "0283FCAA510FF75BBE73C3514C01FDF8")
    public final String getClassloader() {
String var36BEBB44E6CD616E742E932C9DA9302B_1323826450 =         infoClassloader;
        var36BEBB44E6CD616E742E932C9DA9302B_1323826450.addTaint(taint);
        return var36BEBB44E6CD616E742E932C9DA9302B_1323826450;
        // ---------- Original Method ----------
        //return infoClassloader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.586 -0400", hash_original_method = "8C041823EF127A6F9DCC25E0329C5A09", hash_generated_method = "E6CC2E7A58C9BB1513564668214397CC")
    public String toString() {
        StringBuffer sb = new StringBuffer
            (20 + infoPackage.length() + infoModule.length() +
             infoRelease.length() + infoTimestamp.length() +
             infoClassloader.length());
        sb.append("VersionInfo(")
            .append(infoPackage).append(':').append(infoModule);
        if(!UNAVAILABLE.equals(infoRelease))        
        sb.append(':').append(infoRelease);
        if(!UNAVAILABLE.equals(infoTimestamp))        
        sb.append(':').append(infoTimestamp);
        sb.append(')');
        if(!UNAVAILABLE.equals(infoClassloader))        
        sb.append('@').append(infoClassloader);
String var2460B846747F8B22185AD8BE722266A5_1894302844 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1894302844.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1894302844;
        // ---------- Original Method ----------
        //StringBuffer sb = new StringBuffer
            //(20 + infoPackage.length() + infoModule.length() +
             //infoRelease.length() + infoTimestamp.length() +
             //infoClassloader.length());
        //sb.append("VersionInfo(")
            //.append(infoPackage).append(':').append(infoModule);
        //if (!UNAVAILABLE.equals(infoRelease))
            //sb.append(':').append(infoRelease);
        //if (!UNAVAILABLE.equals(infoTimestamp))
            //sb.append(':').append(infoTimestamp);
        //sb.append(')');
        //if (!UNAVAILABLE.equals(infoClassloader))
            //sb.append('@').append(infoClassloader);
        //return sb.toString();
    }

    
    @DSModeled(DSC.BAN)
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

    
    public final static VersionInfo loadVersionInfo(final String pckg,
                                                    ClassLoader clsldr) {
        if (pckg == null) {
            throw new IllegalArgumentException
                ("Package identifier must not be null.");
        }
        if (clsldr == null)
            clsldr = Thread.currentThread().getContextClassLoader();
        Properties vip = null;
        try {
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
        }
        VersionInfo result = null;
        if (vip != null)
            result = fromMap(pckg, vip, clsldr);
        return result;
    }

    
    @DSModeled(DSC.BAN)
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
        }
        String clsldrstr = null;
        if (clsldr != null)
            clsldrstr = clsldr.toString();
        return new VersionInfo(pckg, module, release, timestamp, clsldrstr);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.587 -0400", hash_original_field = "B635CCE0A40F8F1EE4521FA0D3E9716F", hash_generated_field = "AFAF2F28F05D4061200FCFA3487DA249")

    public final static String UNAVAILABLE = "UNAVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.587 -0400", hash_original_field = "446166058F7865810E09BA231EA6BF9E", hash_generated_field = "0594314A1812329E1C3DCDC2FB3A25A4")

    public final static String VERSION_PROPERTY_FILE = "version.properties";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.587 -0400", hash_original_field = "C927DA1220424C71483A16BF17C774F9", hash_generated_field = "41E29EFD75D15AF6B8FD255DC62C3536")

    public final static String PROPERTY_MODULE    = "info.module";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.587 -0400", hash_original_field = "B66B46FB202D1A4007396DF1D63969D1", hash_generated_field = "7651AC9A1406175E054F8B0C10C0345A")

    public final static String PROPERTY_RELEASE   = "info.release";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.587 -0400", hash_original_field = "68B251BEE81E9CE5B4D4EDF6103A1A40", hash_generated_field = "ADDFC93497C4D56A7904659C216B56D5")

    public final static String PROPERTY_TIMESTAMP = "info.timestamp";
}

