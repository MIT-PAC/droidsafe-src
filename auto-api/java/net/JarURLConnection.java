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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.401 -0400", hash_original_field = "00173AD4681FE4F9D267E8220DCD34D1", hash_generated_field = "90997F9D911A1D629EE88BADE98B7D58")

    protected URLConnection jarFileURLConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.401 -0400", hash_original_field = "30C6BF44CEEFFD9DF5233F58C3AA14FD", hash_generated_field = "6BE422D483C01C72CCB99BCB485E4E38")

    private String entryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.402 -0400", hash_original_field = "8E0F935426BCD4A3C27768F13B50EC39", hash_generated_field = "82E66C9916EFB4902E3AF0806E62A3D4")

    private URL fileURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.409 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.409 -0400", hash_original_method = "E4DD2BF7117B0709966B99D66AA37CA9", hash_generated_method = "7C2CD7B39BCADE3BCD6E0DF0653FEB05")
    protected  JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        file = url.getFile();
        int sepIdx;
        {
            boolean varD83DE5777A84DCBEF56B9057EB297FEB_278498657 = ((sepIdx = file.indexOf("!/")) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedURLException();
            } //End block
        } //End collapsed parenthetic
        fileURL = new URL(url.getFile().substring(0,sepIdx));
        sepIdx += 2;
        {
            boolean var3F125B501FD84D25621DF427F753492C_818288118 = (file.length() == sepIdx);
        } //End collapsed parenthetic
        entryName = file.substring(sepIdx, file.length());
        {
            boolean var781724A4DF6A4E51A4EC378374B31BA5_988540927 = (url.getRef() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.410 -0400", hash_original_method = "42C141A19D7A99858D326914023176B3", hash_generated_method = "A349D256A7582EB4DF97706A022EAF92")
    public Attributes getAttributes() throws java.io.IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_501411778 = null; //Variable for return #1
        JarEntry jEntry;
        jEntry = getJarEntry();
        varB4EAC82CA7396A68D541C85D26508E83_501411778 = (jEntry == null) ? null : jEntry.getAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_501411778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_501411778;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //return (jEntry == null) ? null : jEntry.getAttributes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.416 -0400", hash_original_method = "D9106FD6CB62E572A0AA8ED3E04C3C09", hash_generated_method = "719B930E7FE66EE6B6811009EA4FD5D4")
    public Certificate[] getCertificates() throws java.io.IOException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_526011229 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1480817916 = null; //Variable for return #2
        JarEntry jEntry;
        jEntry = getJarEntry();
        {
            varB4EAC82CA7396A68D541C85D26508E83_526011229 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1480817916 = jEntry.getCertificates();
        Certificate[] varA7E53CE21691AB073D9660D615818899_137200952; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_137200952 = varB4EAC82CA7396A68D541C85D26508E83_526011229;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_137200952 = varB4EAC82CA7396A68D541C85D26508E83_1480817916;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_137200952.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_137200952;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //if (jEntry == null) {
            //return null;
        //}
        //return jEntry.getCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.428 -0400", hash_original_method = "DAD1125851C16B3E7BCEFC2CE4B21F94", hash_generated_method = "514AA76B458AAAE107273FBDECAD2E5A")
    public String getEntryName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1473710192 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1473710192 = entryName;
        varB4EAC82CA7396A68D541C85D26508E83_1473710192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1473710192;
        // ---------- Original Method ----------
        //return entryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.442 -0400", hash_original_method = "61250D8DAC5E4F2D4FA4FA4B1B6B705C", hash_generated_method = "889C33A3F7B85CFFF7B7F8CABBE346A6")
    public JarEntry getJarEntry() throws IOException {
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_924556840 = null; //Variable for return #1
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_1562028997 = null; //Variable for return #2
        {
            connect();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_924556840 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1562028997 = getJarFile().getJarEntry(entryName);
        JarEntry varA7E53CE21691AB073D9660D615818899_1031174015; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1031174015 = varB4EAC82CA7396A68D541C85D26508E83_924556840;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1031174015 = varB4EAC82CA7396A68D541C85D26508E83_1562028997;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1031174015.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1031174015;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if (entryName == null) {
            //return null;
        //}
        //return getJarFile().getJarEntry(entryName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.442 -0400", hash_original_method = "EC6192B3278FED11B844B429A38C32F1", hash_generated_method = "9550F3D763B459A847AE6CB6CEE6CAF9")
    public Manifest getManifest() throws java.io.IOException {
        Manifest varB4EAC82CA7396A68D541C85D26508E83_475614766 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_475614766 = (Manifest)getJarFile().getManifest().clone();
        varB4EAC82CA7396A68D541C85D26508E83_475614766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_475614766;
        // ---------- Original Method ----------
        //return (Manifest)getJarFile().getManifest().clone();
    }

    
    public abstract JarFile getJarFile() throws java.io.IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.443 -0400", hash_original_method = "35923E0EC1A4B6746505AC2CF9BCB1E8", hash_generated_method = "0CB7840010093E4F63E612D37F852793")
    public URL getJarFileURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_109843564 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_109843564 = fileURL;
        varB4EAC82CA7396A68D541C85D26508E83_109843564.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_109843564;
        // ---------- Original Method ----------
        //return fileURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.443 -0400", hash_original_method = "392ECCC5BDE098E1298FE9F5D5A5083C", hash_generated_method = "F5E1349D801FFC0FB77C36382ADFD469")
    public Attributes getMainAttributes() throws java.io.IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_10036073 = null; //Variable for return #1
        Manifest m;
        m = getJarFile().getManifest();
        varB4EAC82CA7396A68D541C85D26508E83_10036073 = (m == null) ? null : m.getMainAttributes();
        varB4EAC82CA7396A68D541C85D26508E83_10036073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_10036073;
        // ---------- Original Method ----------
        //Manifest m = getJarFile().getManifest();
        //return (m == null) ? null : m.getMainAttributes();
    }

    
}

