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
    protected URLConnection jarFileURLConnection;
    private String entryName;
    private URL fileURL;
    private String file;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.930 -0400", hash_original_method = "E4DD2BF7117B0709966B99D66AA37CA9", hash_generated_method = "A03FEEDBFAB94A9E5BA27F4788BCA6D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        dsTaint.addTaint(url.dsTaint);
        file = url.getFile();
        int sepIdx;
        {
            boolean varD83DE5777A84DCBEF56B9057EB297FEB_528592378 = ((sepIdx = file.indexOf("!/")) < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedURLException();
            } //End block
        } //End collapsed parenthetic
        fileURL = new URL(url.getFile().substring(0,sepIdx));
        sepIdx += 2;
        {
            boolean var3F125B501FD84D25621DF427F753492C_275140443 = (file.length() == sepIdx);
        } //End collapsed parenthetic
        entryName = file.substring(sepIdx, file.length());
        {
            boolean var781724A4DF6A4E51A4EC378374B31BA5_554739314 = (url.getRef() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.931 -0400", hash_original_method = "42C141A19D7A99858D326914023176B3", hash_generated_method = "ABB3A9C394B38E99BE58CD0138007FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attributes getAttributes() throws java.io.IOException {
        JarEntry jEntry;
        jEntry = getJarEntry();
        {
            Object var29248AD3ACEB50A228317B9800B692C5_1234380345 = (jEntry.getAttributes());
        } //End flattened ternary
        return (Attributes)dsTaint.getTaint();
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //return (jEntry == null) ? null : jEntry.getAttributes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.931 -0400", hash_original_method = "D9106FD6CB62E572A0AA8ED3E04C3C09", hash_generated_method = "EE8CCBC08D088902C831CC9F6F2A3DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getCertificates() throws java.io.IOException {
        JarEntry jEntry;
        jEntry = getJarEntry();
        Certificate[] varC9C875C8336F3849769A23A20519A423_1146855828 = (jEntry.getCertificates());
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //if (jEntry == null) {
            //return null;
        //}
        //return jEntry.getCertificates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.931 -0400", hash_original_method = "DAD1125851C16B3E7BCEFC2CE4B21F94", hash_generated_method = "9DB65E4B7D3A5EB6194E05FDB47B2622")
    @DSModeled(DSC.SAFE)
    public String getEntryName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return entryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.931 -0400", hash_original_method = "61250D8DAC5E4F2D4FA4FA4B1B6B705C", hash_generated_method = "F1C8BE15F086769C326AD8959BE0B5AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarEntry getJarEntry() throws IOException {
        {
            connect();
        } //End block
        JarEntry var6773C078932CB44B2CA86BC8E58151FF_487611686 = (getJarFile().getJarEntry(entryName));
        return (JarEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if (entryName == null) {
            //return null;
        //}
        //return getJarFile().getJarEntry(entryName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.932 -0400", hash_original_method = "EC6192B3278FED11B844B429A38C32F1", hash_generated_method = "32EF8C94D5E246DDFB444087735DD388")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Manifest getManifest() throws java.io.IOException {
        Manifest varA117F0D45929E831E19751DB0FF28BE6_1346129257 = ((Manifest)getJarFile().getManifest().clone());
        return (Manifest)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Manifest)getJarFile().getManifest().clone();
    }

    
    public abstract JarFile getJarFile() throws java.io.IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.933 -0400", hash_original_method = "35923E0EC1A4B6746505AC2CF9BCB1E8", hash_generated_method = "69712A8B11A0603EB6EF34FC8DDAAA3D")
    @DSModeled(DSC.SAFE)
    public URL getJarFileURL() {
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fileURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.934 -0400", hash_original_method = "392ECCC5BDE098E1298FE9F5D5A5083C", hash_generated_method = "B44A263F24A6E31D350D3A7300499BB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attributes getMainAttributes() throws java.io.IOException {
        Manifest m;
        m = getJarFile().getManifest();
        {
            Object var04CFF661CCA9AA00FAD74C463D83CD51_198250981 = (m.getMainAttributes());
        } //End flattened ternary
        return (Attributes)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Manifest m = getJarFile().getManifest();
        //return (m == null) ? null : m.getMainAttributes();
    }

    
}

