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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.411 -0400", hash_original_field = "00173AD4681FE4F9D267E8220DCD34D1", hash_generated_field = "90997F9D911A1D629EE88BADE98B7D58")

    protected URLConnection jarFileURLConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.411 -0400", hash_original_field = "30C6BF44CEEFFD9DF5233F58C3AA14FD", hash_generated_field = "6BE422D483C01C72CCB99BCB485E4E38")

    private String entryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.411 -0400", hash_original_field = "8E0F935426BCD4A3C27768F13B50EC39", hash_generated_field = "82E66C9916EFB4902E3AF0806E62A3D4")

    private URL fileURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.411 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.412 -0400", hash_original_method = "E4DD2BF7117B0709966B99D66AA37CA9", hash_generated_method = "5DC6232E2E1EDB5174CD06043DAA47C7")
    protected  JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        file = url.getFile();
        int sepIdx;
        {
            boolean varD83DE5777A84DCBEF56B9057EB297FEB_149333494 = ((sepIdx = file.indexOf("!/")) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedURLException();
            } //End block
        } //End collapsed parenthetic
        fileURL = new URL(url.getFile().substring(0,sepIdx));
        sepIdx += 2;
        {
            boolean var3F125B501FD84D25621DF427F753492C_13451849 = (file.length() == sepIdx);
        } //End collapsed parenthetic
        entryName = file.substring(sepIdx, file.length());
        {
            boolean var781724A4DF6A4E51A4EC378374B31BA5_793034651 = (url.getRef() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.412 -0400", hash_original_method = "42C141A19D7A99858D326914023176B3", hash_generated_method = "D3CCFFF9012259F96498D68C61819ABD")
    public Attributes getAttributes() throws java.io.IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_775459833 = null; //Variable for return #1
        JarEntry jEntry = getJarEntry();
        varB4EAC82CA7396A68D541C85D26508E83_775459833 = (jEntry == null) ? null : jEntry.getAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_775459833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_775459833;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //return (jEntry == null) ? null : jEntry.getAttributes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.413 -0400", hash_original_method = "D9106FD6CB62E572A0AA8ED3E04C3C09", hash_generated_method = "0E347FAD74AEFAA5FCE28E8C2A216E3A")
    public Certificate[] getCertificates() throws java.io.IOException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1484791562 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1922604747 = null; //Variable for return #2
        JarEntry jEntry = getJarEntry();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1484791562 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1922604747 = jEntry.getCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_1879786462; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1879786462 = varB4EAC82CA7396A68D541C85D26508E83_1484791562;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1879786462 = varB4EAC82CA7396A68D541C85D26508E83_1922604747;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1879786462.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1879786462;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //if (jEntry == null) {
            //return null;
        //}
        //return jEntry.getCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.414 -0400", hash_original_method = "DAD1125851C16B3E7BCEFC2CE4B21F94", hash_generated_method = "74FC6FD862F51A6653FB2F653F693510")
    public String getEntryName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2077694413 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2077694413 = entryName;
        varB4EAC82CA7396A68D541C85D26508E83_2077694413.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2077694413;
        // ---------- Original Method ----------
        //return entryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.415 -0400", hash_original_method = "61250D8DAC5E4F2D4FA4FA4B1B6B705C", hash_generated_method = "AFB580F346B6F4FCF2690C4587E8A8DB")
    public JarEntry getJarEntry() throws IOException {
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_832786048 = null; //Variable for return #1
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_618665340 = null; //Variable for return #2
        {
            connect();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_832786048 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_618665340 = getJarFile().getJarEntry(entryName);
        JarEntry varA7E53CE21691AB073D9660D615818899_2091725383; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2091725383 = varB4EAC82CA7396A68D541C85D26508E83_832786048;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2091725383 = varB4EAC82CA7396A68D541C85D26508E83_618665340;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2091725383.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2091725383;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if (entryName == null) {
            //return null;
        //}
        //return getJarFile().getJarEntry(entryName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.416 -0400", hash_original_method = "EC6192B3278FED11B844B429A38C32F1", hash_generated_method = "25850B007C7543F125804D115EB2FD91")
    public Manifest getManifest() throws java.io.IOException {
        Manifest varB4EAC82CA7396A68D541C85D26508E83_1360655921 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1360655921 = (Manifest)getJarFile().getManifest().clone();
        varB4EAC82CA7396A68D541C85D26508E83_1360655921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1360655921;
        // ---------- Original Method ----------
        //return (Manifest)getJarFile().getManifest().clone();
    }

    
    public abstract JarFile getJarFile() throws java.io.IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.419 -0400", hash_original_method = "35923E0EC1A4B6746505AC2CF9BCB1E8", hash_generated_method = "A971E0535D680B5AA41EF4EE611B439B")
    public URL getJarFileURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_2122332115 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2122332115 = fileURL;
        varB4EAC82CA7396A68D541C85D26508E83_2122332115.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2122332115;
        // ---------- Original Method ----------
        //return fileURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.421 -0400", hash_original_method = "392ECCC5BDE098E1298FE9F5D5A5083C", hash_generated_method = "8CB3B366C89D389CD4FCCF0B234859D7")
    public Attributes getMainAttributes() throws java.io.IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_1175848621 = null; //Variable for return #1
        Manifest m = getJarFile().getManifest();
        varB4EAC82CA7396A68D541C85D26508E83_1175848621 = (m == null) ? null : m.getMainAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_1175848621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1175848621;
        // ---------- Original Method ----------
        //Manifest m = getJarFile().getManifest();
        //return (m == null) ? null : m.getMainAttributes();
    }

    
}

