package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public abstract class JarURLConnection extends URLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.548 -0400", hash_original_field = "00173AD4681FE4F9D267E8220DCD34D1", hash_generated_field = "90997F9D911A1D629EE88BADE98B7D58")

    protected URLConnection jarFileURLConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.548 -0400", hash_original_field = "30C6BF44CEEFFD9DF5233F58C3AA14FD", hash_generated_field = "6BE422D483C01C72CCB99BCB485E4E38")

    private String entryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.548 -0400", hash_original_field = "8E0F935426BCD4A3C27768F13B50EC39", hash_generated_field = "82E66C9916EFB4902E3AF0806E62A3D4")

    private URL fileURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.548 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.549 -0400", hash_original_method = "E4DD2BF7117B0709966B99D66AA37CA9", hash_generated_method = "C36115E7D6F4C2821AF6DE905E9F4434")
    protected  JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        file = url.getFile();
        int sepIdx;
        {
            boolean varD83DE5777A84DCBEF56B9057EB297FEB_631187117 = ((sepIdx = file.indexOf("!/")) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedURLException();
            } //End block
        } //End collapsed parenthetic
        fileURL = new URL(url.getFile().substring(0,sepIdx));
        sepIdx += 2;
        {
            boolean var3F125B501FD84D25621DF427F753492C_820221644 = (file.length() == sepIdx);
        } //End collapsed parenthetic
        entryName = file.substring(sepIdx, file.length());
        {
            boolean var781724A4DF6A4E51A4EC378374B31BA5_1741498338 = (url.getRef() != null);
            {
                entryName += "#" + url.getRef();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //file = url.getFile();
        //int sepIdx;
        //if ((sepIdx = file.indexOf("!/")) < 0) {
            //throw new MalformedURLException();
        //}
        //fileURL = new URL(url.getFile().substring(0,sepIdx));
        //sepIdx += 2;
        //if (file.length() == sepIdx) {
            //return;
        //}
        //entryName = file.substring(sepIdx, file.length());
        //if (url.getRef() != null) {
            //entryName += "#" + url.getRef();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.555 -0400", hash_original_method = "42C141A19D7A99858D326914023176B3", hash_generated_method = "18121B4FF8566BDD5DDC52055D47B1DA")
    public Attributes getAttributes() throws java.io.IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_1759740636 = null; //Variable for return #1
        JarEntry jEntry;
        jEntry = getJarEntry();
        varB4EAC82CA7396A68D541C85D26508E83_1759740636 = (jEntry == null) ? null : jEntry.getAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_1759740636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1759740636;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //return (jEntry == null) ? null : jEntry.getAttributes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.570 -0400", hash_original_method = "D9106FD6CB62E572A0AA8ED3E04C3C09", hash_generated_method = "311BE61953D5B0FCAFC28A75CC3A24F1")
    public Certificate[] getCertificates() throws java.io.IOException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1223741125 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_747322695 = null; //Variable for return #2
        JarEntry jEntry;
        jEntry = getJarEntry();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1223741125 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_747322695 = jEntry.getCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_546139165; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_546139165 = varB4EAC82CA7396A68D541C85D26508E83_1223741125;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_546139165 = varB4EAC82CA7396A68D541C85D26508E83_747322695;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_546139165.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_546139165;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //if (jEntry == null) {
            //return null;
        //}
        //return jEntry.getCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.571 -0400", hash_original_method = "DAD1125851C16B3E7BCEFC2CE4B21F94", hash_generated_method = "A95B9163057AD665AE4CECA9EDDD4220")
    public String getEntryName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1947695166 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1947695166 = entryName;
        varB4EAC82CA7396A68D541C85D26508E83_1947695166.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1947695166;
        // ---------- Original Method ----------
        //return entryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.572 -0400", hash_original_method = "61250D8DAC5E4F2D4FA4FA4B1B6B705C", hash_generated_method = "AA419214B1B995A14B9CEA96A15AE88E")
    public JarEntry getJarEntry() throws IOException {
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_1154879472 = null; //Variable for return #1
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_199251090 = null; //Variable for return #2
        {
            connect();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1154879472 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_199251090 = getJarFile().getJarEntry(entryName);
        JarEntry varA7E53CE21691AB073D9660D615818899_1819093707; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1819093707 = varB4EAC82CA7396A68D541C85D26508E83_1154879472;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1819093707 = varB4EAC82CA7396A68D541C85D26508E83_199251090;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1819093707.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1819093707;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if (entryName == null) {
            //return null;
        //}
        //return getJarFile().getJarEntry(entryName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.572 -0400", hash_original_method = "EC6192B3278FED11B844B429A38C32F1", hash_generated_method = "EDC9E073685D71B558A10A3C30757224")
    public Manifest getManifest() throws java.io.IOException {
        Manifest varB4EAC82CA7396A68D541C85D26508E83_408304707 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_408304707 = (Manifest)getJarFile().getManifest().clone();
        varB4EAC82CA7396A68D541C85D26508E83_408304707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_408304707;
        // ---------- Original Method ----------
        //return (Manifest)getJarFile().getManifest().clone();
    }

    
    public abstract JarFile getJarFile() throws java.io.IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.573 -0400", hash_original_method = "35923E0EC1A4B6746505AC2CF9BCB1E8", hash_generated_method = "425181411415B869CB60C76337E582C1")
    public URL getJarFileURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_506997628 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_506997628 = fileURL;
        varB4EAC82CA7396A68D541C85D26508E83_506997628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_506997628;
        // ---------- Original Method ----------
        //return fileURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.574 -0400", hash_original_method = "392ECCC5BDE098E1298FE9F5D5A5083C", hash_generated_method = "01628170E251B4485BA0C5644E3FAD8F")
    public Attributes getMainAttributes() throws java.io.IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_436727973 = null; //Variable for return #1
        Manifest m;
        m = getJarFile().getManifest();
        varB4EAC82CA7396A68D541C85D26508E83_436727973 = (m == null) ? null : m.getMainAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_436727973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_436727973;
        // ---------- Original Method ----------
        //Manifest m = getJarFile().getManifest();
        //return (m == null) ? null : m.getMainAttributes();
    }

    
}

