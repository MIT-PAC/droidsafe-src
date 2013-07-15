package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public abstract class JarURLConnection extends URLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.839 -0400", hash_original_field = "00173AD4681FE4F9D267E8220DCD34D1", hash_generated_field = "90997F9D911A1D629EE88BADE98B7D58")

    protected URLConnection jarFileURLConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.839 -0400", hash_original_field = "30C6BF44CEEFFD9DF5233F58C3AA14FD", hash_generated_field = "6BE422D483C01C72CCB99BCB485E4E38")

    private String entryName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.839 -0400", hash_original_field = "8E0F935426BCD4A3C27768F13B50EC39", hash_generated_field = "82E66C9916EFB4902E3AF0806E62A3D4")

    private URL fileURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.839 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.841 -0400", hash_original_method = "E4DD2BF7117B0709966B99D66AA37CA9", hash_generated_method = "E3727A35225122E090CF4B144886C6B7")
    protected  JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        file = url.getFile();
        int sepIdx;
    if((sepIdx = file.indexOf("!/")) < 0)        
        {
            MalformedURLException var21E10CD6C5DF9565D3549D417E79A72D_1864859686 = new MalformedURLException();
            var21E10CD6C5DF9565D3549D417E79A72D_1864859686.addTaint(taint);
            throw var21E10CD6C5DF9565D3549D417E79A72D_1864859686;
        } //End block
        fileURL = new URL(url.getFile().substring(0,sepIdx));
        sepIdx += 2;
    if(file.length() == sepIdx)        
        {
            return;
        } //End block
        entryName = file.substring(sepIdx, file.length());
    if(url.getRef() != null)        
        {
            entryName += "#" + url.getRef();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.843 -0400", hash_original_method = "42C141A19D7A99858D326914023176B3", hash_generated_method = "56DDEF42B3BE731E57D23AFC04FC86A4")
    public Attributes getAttributes() throws java.io.IOException {
        JarEntry jEntry = getJarEntry();
Attributes var397D1096BF67692CA492F7FA250DB59A_278424915 =         (jEntry == null) ? null : jEntry.getAttributes();
        var397D1096BF67692CA492F7FA250DB59A_278424915.addTaint(taint);
        return var397D1096BF67692CA492F7FA250DB59A_278424915;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //return (jEntry == null) ? null : jEntry.getAttributes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.844 -0400", hash_original_method = "D9106FD6CB62E572A0AA8ED3E04C3C09", hash_generated_method = "91DC226F47B3F108AC07E3C3F1272905")
    public Certificate[] getCertificates() throws java.io.IOException {
        JarEntry jEntry = getJarEntry();
    if(jEntry == null)        
        {
Certificate[] var540C13E9E156B687226421B24F2DF178_170402807 =             null;
            var540C13E9E156B687226421B24F2DF178_170402807.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_170402807;
        } //End block
Certificate[] var20D23548D5B29B039534CE2DC596F6FF_1816746442 =         jEntry.getCertificates();
        var20D23548D5B29B039534CE2DC596F6FF_1816746442.addTaint(taint);
        return var20D23548D5B29B039534CE2DC596F6FF_1816746442;
        // ---------- Original Method ----------
        //JarEntry jEntry = getJarEntry();
        //if (jEntry == null) {
            //return null;
        //}
        //return jEntry.getCertificates();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.844 -0400", hash_original_method = "DAD1125851C16B3E7BCEFC2CE4B21F94", hash_generated_method = "1299D2C6E4503E7C7D01A90BC0FA9100")
    public String getEntryName() {
String varF3E8D7D8476436F75D1BE6BA494262B0_301287445 =         entryName;
        varF3E8D7D8476436F75D1BE6BA494262B0_301287445.addTaint(taint);
        return varF3E8D7D8476436F75D1BE6BA494262B0_301287445;
        // ---------- Original Method ----------
        //return entryName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.845 -0400", hash_original_method = "61250D8DAC5E4F2D4FA4FA4B1B6B705C", hash_generated_method = "08B47839264CB33E7BA4B091FBE3C0E7")
    public JarEntry getJarEntry() throws IOException {
    if(!connected)        
        {
            connect();
        } //End block
    if(entryName == null)        
        {
JarEntry var540C13E9E156B687226421B24F2DF178_299297923 =             null;
            var540C13E9E156B687226421B24F2DF178_299297923.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_299297923;
        } //End block
JarEntry varF75877B5990554D5010042B3CE857FC6_1253634934 =         getJarFile().getJarEntry(entryName);
        varF75877B5990554D5010042B3CE857FC6_1253634934.addTaint(taint);
        return varF75877B5990554D5010042B3CE857FC6_1253634934;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if (entryName == null) {
            //return null;
        //}
        //return getJarFile().getJarEntry(entryName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.845 -0400", hash_original_method = "EC6192B3278FED11B844B429A38C32F1", hash_generated_method = "0A35D90B76D439B721FBDFFC96DD8564")
    public Manifest getManifest() throws java.io.IOException {
Manifest varD6A473F34A9B589697EE5BB39DA55A84_1762091243 =         (Manifest)getJarFile().getManifest().clone();
        varD6A473F34A9B589697EE5BB39DA55A84_1762091243.addTaint(taint);
        return varD6A473F34A9B589697EE5BB39DA55A84_1762091243;
        // ---------- Original Method ----------
        //return (Manifest)getJarFile().getManifest().clone();
    }

    
    public abstract JarFile getJarFile() throws java.io.IOException;

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.846 -0400", hash_original_method = "35923E0EC1A4B6746505AC2CF9BCB1E8", hash_generated_method = "A4CB7DF055302870C91AE6CC1ED9826C")
    public URL getJarFileURL() {
URL var8B7F9BD78C6186977C46D48EA3629742_1102297032 =         fileURL;
        var8B7F9BD78C6186977C46D48EA3629742_1102297032.addTaint(taint);
        return var8B7F9BD78C6186977C46D48EA3629742_1102297032;
        // ---------- Original Method ----------
        //return fileURL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.846 -0400", hash_original_method = "392ECCC5BDE098E1298FE9F5D5A5083C", hash_generated_method = "669D92E0DBA37D33AA0B1ED93CAB5031")
    public Attributes getMainAttributes() throws java.io.IOException {
        Manifest m = getJarFile().getManifest();
Attributes varEF0569FCE2C5DC98D21FE9C1CBEF240D_1756768882 =         (m == null) ? null : m.getMainAttributes();
        varEF0569FCE2C5DC98D21FE9C1CBEF240D_1756768882.addTaint(taint);
        return varEF0569FCE2C5DC98D21FE9C1CBEF240D_1756768882;
        // ---------- Original Method ----------
        //Manifest m = getJarFile().getManifest();
        //return (m == null) ? null : m.getMainAttributes();
    }

    
}

