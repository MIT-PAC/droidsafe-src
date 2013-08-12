package java.util.jar;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import libcore.io.Streams;


public class JarFile extends ZipFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.890 -0400", hash_original_field = "7F5CB74AF5D7F4B82200738FDBDC5A45", hash_generated_field = "261709621967406C2758961F4730EA20")

    private Manifest manifest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.890 -0400", hash_original_field = "E7B53329F4E7143315B5B9E1E35716BA", hash_generated_field = "A4D7622C7D5230CEA74D7E274931C68D")

    private ZipEntry manifestEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.890 -0400", hash_original_field = "0B5F8F06BAFB3828F619F6F96FC6ADB2", hash_generated_field = "15838C298A89AE0514754B108BF02A73")

    JarVerifier verifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.890 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.890 -0400", hash_original_method = "B9B0355AAF6860849CDAA93CC073B40D", hash_generated_method = "578AF9C3F617699204D04C3678122D01")
    public  JarFile(File file) throws IOException {
        this(file, true);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.891 -0400", hash_original_method = "5EB6670431246E3B0105DDAC48B26AC0", hash_generated_method = "F27BD785C475148DBA18D67EEBD1DD82")
    public  JarFile(File file, boolean verify) throws IOException {
        super(file);
        addTaint(verify);
        if(verify)        
        {
            verifier = new JarVerifier(file.getPath());
        } //End block
        readMetaEntries();
        // ---------- Original Method ----------
        //if (verify) {
            //verifier = new JarVerifier(file.getPath());
        //}
        //readMetaEntries();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.891 -0400", hash_original_method = "793A8CDEEB3B1480C6CD4A5DE140B86D", hash_generated_method = "B7120D9445F831CED71B55D0A99530C4")
    public  JarFile(File file, boolean verify, int mode) throws IOException {
        super(file, mode);
        addTaint(mode);
        addTaint(verify);
        if(verify)        
        {
            verifier = new JarVerifier(file.getPath());
        } //End block
        readMetaEntries();
        // ---------- Original Method ----------
        //if (verify) {
            //verifier = new JarVerifier(file.getPath());
        //}
        //readMetaEntries();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.892 -0400", hash_original_method = "7A554CED3F155E72368E52962D72B4D7", hash_generated_method = "E206C57A5C98E6791FFDF685273E8DFA")
    public  JarFile(String filename) throws IOException {
        this(filename, true);
        addTaint(filename.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.892 -0400", hash_original_method = "54E668354AB021AFE09898CE1915F8B2", hash_generated_method = "ACEA1C52250F23B1AD376EDAADE9643C")
    public  JarFile(String filename, boolean verify) throws IOException {
        super(filename);
        addTaint(verify);
        if(verify)        
        {
            verifier = new JarVerifier(filename);
        } //End block
        readMetaEntries();
        // ---------- Original Method ----------
        //if (verify) {
            //verifier = new JarVerifier(filename);
        //}
        //readMetaEntries();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.894 -0400", hash_original_method = "DDF115034FADFE53A1FD9BC36D36CE25", hash_generated_method = "28390275337A046A4F073DB9C9A54D85")
    @Override
    public Enumeration<JarEntry> entries() {
        class JarFileEnumerator implements Enumeration<JarEntry> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.893 -0400", hash_original_field = "98B456A0723FA616284A632D9D31821B", hash_generated_field = "BD6898769B3BC196CD1C8BCB2FCBB517")
            Enumeration<? extends ZipEntry> ze;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.893 -0400", hash_original_field = "FE0EC43CC4200E777AA2190ACE58E7B4", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")
            JarFile jf;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.893 -0400", hash_original_method = "C7F3ED49203A5BDA1D49193B6084B2BE", hash_generated_method = "BC00F704C0A9EFA63CDD07B4B4E22805")
              JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
                ze = zenum;
                this.jf = jf;
                // ---------- Original Method ----------
                //ze = zenum;
                //this.jf = jf;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.893 -0400", hash_original_method = "9E60B2163115C0F4A5143AACEF20F301", hash_generated_method = "A9BD8A1B106036F6DBD99AA6F97568BA")
            public boolean hasMoreElements() {
                boolean var93A4AF90B366B42C637BBBFD28A84EA0_1761813638 = (ze.hasMoreElements());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753898332 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_753898332;
                // ---------- Original Method ----------
                //return ze.hasMoreElements();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.894 -0400", hash_original_method = "5675597FFA2F5C3F421325DE8580ECC3", hash_generated_method = "D81DE2A599219AF7E7410538E353F5A5")
            public JarEntry nextElement() {
                JarEntry je = new JarEntry(ze.nextElement());
                je.parentJar = jf;
JarEntry var8426B46703D579116B5F4E1AE17ACF98_156965630 =                 je;
                var8426B46703D579116B5F4E1AE17ACF98_156965630.addTaint(taint);
                return var8426B46703D579116B5F4E1AE17ACF98_156965630;
                // ---------- Original Method ----------
                //JarEntry je = new JarEntry(ze.nextElement());
                //je.parentJar = jf;
                //return je;
            }
        }
Enumeration<JarEntry> varFD6D5513D1E96AE9B20DD26D8EAB087D_1778760700 =         new JarFileEnumerator(super.entries(), this);
        varFD6D5513D1E96AE9B20DD26D8EAB087D_1778760700.addTaint(taint);
        return varFD6D5513D1E96AE9B20DD26D8EAB087D_1778760700;
        // ---------- Original Method ----------
        //class JarFileEnumerator implements Enumeration<JarEntry> {
            //Enumeration<? extends ZipEntry> ze;
            //JarFile jf;
            //JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
                //ze = zenum;
                //this.jf = jf;
            //}
            //public boolean hasMoreElements() {
                //return ze.hasMoreElements();
            //}
            //public JarEntry nextElement() {
                //JarEntry je = new JarEntry(ze.nextElement());
                //je.parentJar = jf;
                //return je;
            //}
        //}
        //return new JarFileEnumerator(super.entries(), this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.895 -0400", hash_original_method = "C114B7C700B8AEF8B2BF9DB9E2302906", hash_generated_method = "D2D29D96814AF30B63C90DE3224790E2")
    public JarEntry getJarEntry(String name) {
        addTaint(name.getTaint());
JarEntry var591DE7427C125FF4E677E1BD603E2794_2100022556 =         (JarEntry) getEntry(name);
        var591DE7427C125FF4E677E1BD603E2794_2100022556.addTaint(taint);
        return var591DE7427C125FF4E677E1BD603E2794_2100022556;
        // ---------- Original Method ----------
        //return (JarEntry) getEntry(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.896 -0400", hash_original_method = "E67D102DBF269AEACB3865BB39A89C99", hash_generated_method = "7855417D7802E2AF5029F5D5DC200316")
    public Manifest getManifest() throws IOException {
        if(closed)        
        {
            IllegalStateException var1CF6646D6F623573E00BC152483F0CDA_1781305573 = new IllegalStateException("JarFile has been closed");
            var1CF6646D6F623573E00BC152483F0CDA_1781305573.addTaint(taint);
            throw var1CF6646D6F623573E00BC152483F0CDA_1781305573;
        } //End block
        if(manifest != null)        
        {
Manifest var1E3066E1404CD0BB62AB3E2DCB96B149_1097039238 =             manifest;
            var1E3066E1404CD0BB62AB3E2DCB96B149_1097039238.addTaint(taint);
            return var1E3066E1404CD0BB62AB3E2DCB96B149_1097039238;
        } //End block
        try 
        {
            InputStream is = super.getInputStream(manifestEntry);
            if(verifier != null)            
            {
                verifier.addMetaEntry(manifestEntry.getName(), Streams.readFully(is));
                is = super.getInputStream(manifestEntry);
            } //End block
            try 
            {
                manifest = new Manifest(is, verifier != null);
            } //End block
            finally 
            {
                is.close();
            } //End block
            manifestEntry = null;
        } //End block
        catch (NullPointerException e)
        {
            manifestEntry = null;
        } //End block
Manifest var1E3066E1404CD0BB62AB3E2DCB96B149_756282419 =         manifest;
        var1E3066E1404CD0BB62AB3E2DCB96B149_756282419.addTaint(taint);
        return var1E3066E1404CD0BB62AB3E2DCB96B149_756282419;
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IllegalStateException("JarFile has been closed");
        //}
        //if (manifest != null) {
            //return manifest;
        //}
        //try {
            //InputStream is = super.getInputStream(manifestEntry);
            //if (verifier != null) {
                //verifier.addMetaEntry(manifestEntry.getName(), Streams.readFully(is));
                //is = super.getInputStream(manifestEntry);
            //}
            //try {
                //manifest = new Manifest(is, verifier != null);
            //} finally {
                //is.close();
            //}
            //manifestEntry = null;  
        //} catch (NullPointerException e) {
            //manifestEntry = null;
        //}
        //return manifest;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.897 -0400", hash_original_method = "388F847516FC198A1371FF54043E7729", hash_generated_method = "1C91A8755396C4C973ECE2989A2E289D")
    private void readMetaEntries() throws IOException {
        ZipEntry[] metaEntries = getMetaEntriesImpl();
        if(metaEntries == null)        
        {
            verifier = null;
            return;
        } //End block
        boolean signed = false;
for(ZipEntry entry : metaEntries)
        {
            String entryName = entry.getName();
            if(manifestEntry == null && entryName.equalsIgnoreCase(MANIFEST_NAME))            
            {
                manifestEntry = entry;
                if(verifier == null)                
                {
                    break;
                } //End block
            } //End block
            else
            {
                if(verifier != null
                        && (endsWithIgnoreCase(entryName, ".SF")
                                || endsWithIgnoreCase(entryName, ".DSA")
                                || endsWithIgnoreCase(entryName, ".RSA")))                
                {
                    signed = true;
                    InputStream is = super.getInputStream(entry);
                    verifier.addMetaEntry(entryName, Streams.readFully(is));
                } //End block
            } //End block
        } //End block
        if(!signed)        
        {
            verifier = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean endsWithIgnoreCase(String s, String suffix) {
        return s.regionMatches(true, s.length() - suffix.length(), suffix, 0, suffix.length());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.898 -0400", hash_original_method = "53CBE19CD54AC9FA27355C4D3916E5DE", hash_generated_method = "CD4ADC7FC44C30C6A0E4C5EA5F5AAFD4")
    @Override
    public InputStream getInputStream(ZipEntry ze) throws IOException {
        addTaint(ze.getTaint());
        if(manifestEntry != null)        
        {
            getManifest();
        } //End block
        if(verifier != null)        
        {
            verifier.setManifest(getManifest());
            if(manifest != null)            
            {
                verifier.mainAttributesEnd = manifest.getMainAttributesEnd();
            } //End block
            if(verifier.readCertificates())            
            {
                verifier.removeMetaEntries();
                if(manifest != null)                
                {
                    manifest.removeChunks();
                } //End block
                if(!verifier.isSignedJar())                
                {
                    verifier = null;
                } //End block
            } //End block
        } //End block
        InputStream in = super.getInputStream(ze);
        if(in == null)        
        {
InputStream var540C13E9E156B687226421B24F2DF178_693272024 =             null;
            var540C13E9E156B687226421B24F2DF178_693272024.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_693272024;
        } //End block
        if(verifier == null || ze.getSize() == -1)        
        {
InputStream var091D3B9C0C9CE73F019D8ED2F738F1B8_2140892806 =             in;
            var091D3B9C0C9CE73F019D8ED2F738F1B8_2140892806.addTaint(taint);
            return var091D3B9C0C9CE73F019D8ED2F738F1B8_2140892806;
        } //End block
        JarVerifier.VerifierEntry entry = verifier.initEntry(ze.getName());
        if(entry == null)        
        {
InputStream var091D3B9C0C9CE73F019D8ED2F738F1B8_758077860 =             in;
            var091D3B9C0C9CE73F019D8ED2F738F1B8_758077860.addTaint(taint);
            return var091D3B9C0C9CE73F019D8ED2F738F1B8_758077860;
        } //End block
InputStream var4CAB468FFDADC030160DE961725CED91_1173689780 =         new JarFileInputStream(in, ze, entry);
        var4CAB468FFDADC030160DE961725CED91_1173689780.addTaint(taint);
        return var4CAB468FFDADC030160DE961725CED91_1173689780;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.899 -0400", hash_original_method = "B825DECF198E8D2309850EFFE99C9789", hash_generated_method = "311EB72DE688904D8E5E13E53637E1CE")
    @Override
    public ZipEntry getEntry(String name) {
        addTaint(name.getTaint());
        ZipEntry ze = super.getEntry(name);
        if(ze == null)        
        {
ZipEntry var73C8562FB105FA2AE4E182CC2B2A6163_1704255516 =             ze;
            var73C8562FB105FA2AE4E182CC2B2A6163_1704255516.addTaint(taint);
            return var73C8562FB105FA2AE4E182CC2B2A6163_1704255516;
        } //End block
        JarEntry je = new JarEntry(ze);
        je.parentJar = this;
ZipEntry var8426B46703D579116B5F4E1AE17ACF98_1367943438 =         je;
        var8426B46703D579116B5F4E1AE17ACF98_1367943438.addTaint(taint);
        return var8426B46703D579116B5F4E1AE17ACF98_1367943438;
        // ---------- Original Method ----------
        //ZipEntry ze = super.getEntry(name);
        //if (ze == null) {
            //return ze;
        //}
        //JarEntry je = new JarEntry(ze);
        //je.parentJar = this;
        //return je;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.900 -0400", hash_original_method = "4B8F98994A94A2FEBED0E4C85A619A5C", hash_generated_method = "9F320233CB91246127EF2841371880FD")
    private ZipEntry[] getMetaEntriesImpl() {
        List<ZipEntry> list = new ArrayList<ZipEntry>(8);
        Enumeration<? extends ZipEntry> allEntries = entries();
        while
(allEntries.hasMoreElements())        
        {
            ZipEntry ze = allEntries.nextElement();
            if(ze.getName().startsWith(META_DIR)
                    && ze.getName().length() > META_DIR.length())            
            {
                list.add(ze);
            } //End block
        } //End block
        if(list.size() == 0)        
        {
ZipEntry[] var540C13E9E156B687226421B24F2DF178_215127891 =             null;
            var540C13E9E156B687226421B24F2DF178_215127891.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_215127891;
        } //End block
        ZipEntry[] result = new ZipEntry[list.size()];
        list.toArray(result);
ZipEntry[] varDC838461EE2FA0CA4C9BBB70A15456B0_840320944 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_840320944.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_840320944;
        // ---------- Original Method ----------
        //List<ZipEntry> list = new ArrayList<ZipEntry>(8);
        //Enumeration<? extends ZipEntry> allEntries = entries();
        //while (allEntries.hasMoreElements()) {
            //ZipEntry ze = allEntries.nextElement();
            //if (ze.getName().startsWith(META_DIR)
                    //&& ze.getName().length() > META_DIR.length()) {
                //list.add(ze);
            //}
        //}
        //if (list.size() == 0) {
            //return null;
        //}
        //ZipEntry[] result = new ZipEntry[list.size()];
        //list.toArray(result);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.900 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "DCC0D06E7F79ED3EAE0E8D99DD76C5B5")
    @Override
    public void close() throws IOException {
        super.close();
        closed = true;
        // ---------- Original Method ----------
        //super.close();
        //closed = true;
    }

    
    static final class JarFileInputStream extends FilterInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.901 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "96817EEF83FA1C93DC2A9F8452312BE5")

        private long count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.901 -0400", hash_original_field = "A984E853B1E1D85D70B1FBA492B2E542", hash_generated_field = "97423CF71E793626D5B9FCF841E2156D")

        private ZipEntry zipEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.901 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "D893B68F418C2812B051677DEAD7BC47")

        private JarVerifier.VerifierEntry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.902 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "9C759896300CD7D902BE34CCDA83590B")

        private boolean done = false;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.902 -0400", hash_original_method = "C5D82B21AC1025C83393044900E9B5C1", hash_generated_method = "DE86F2A3471707EF9C411B0441E54CCC")
          JarFileInputStream(InputStream is, ZipEntry ze,
                JarVerifier.VerifierEntry e) {
            super(is);
            addTaint(is.getTaint());
            zipEntry = ze;
            count = zipEntry.getSize();
            entry = e;
            // ---------- Original Method ----------
            //zipEntry = ze;
            //count = zipEntry.getSize();
            //entry = e;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.903 -0400", hash_original_method = "89CF4CB391CD9E8B348E579506073CE6", hash_generated_method = "9D9D8586BDE564EA1F20795ADABF64F8")
        @Override
        public int read() throws IOException {
            if(done)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_93710163 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846580474 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846580474;
            } //End block
            if(count > 0)            
            {
                int r = super.read();
                if(r != -1)                
                {
                    entry.write(r);
                    count--;
                } //End block
                else
                {
                    count = 0;
                } //End block
                if(count == 0)                
                {
                    done = true;
                    entry.verify();
                } //End block
                int var4B43B0AEE35624CD95B910189B3DC231_24287925 = (r);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1020219939 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1020219939;
            } //End block
            else
            {
                done = true;
                entry.verify();
                int var6BB61E3B7BCE0931DA574D19D1D82C88_913995330 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798516604 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798516604;
            } //End block
            // ---------- Original Method ----------
            //if (done) {
                //return -1;
            //}
            //if (count > 0) {
                //int r = super.read();
                //if (r != -1) {
                    //entry.write(r);
                    //count--;
                //} else {
                    //count = 0;
                //}
                //if (count == 0) {
                    //done = true;
                    //entry.verify();
                //}
                //return r;
            //} else {
                //done = true;
                //entry.verify();
                //return -1;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.905 -0400", hash_original_method = "A2A36F60816A3448608DD8EC3FE6DD7B", hash_generated_method = "FA7AC5894CC24637917B04793936362B")
        @Override
        public int read(byte[] buf, int off, int nbytes) throws IOException {
            addTaint(nbytes);
            addTaint(off);
            addTaint(buf[0]);
            if(done)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_252273792 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754179201 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754179201;
            } //End block
            if(count > 0)            
            {
                int r = super.read(buf, off, nbytes);
                if(r != -1)                
                {
                    int size = r;
                    if(count < size)                    
                    {
                        size = (int) count;
                    } //End block
                    entry.write(buf, off, size);
                    count -= size;
                } //End block
                else
                {
                    count = 0;
                } //End block
                if(count == 0)                
                {
                    done = true;
                    entry.verify();
                } //End block
                int var4B43B0AEE35624CD95B910189B3DC231_1712309984 = (r);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265283333 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265283333;
            } //End block
            else
            {
                done = true;
                entry.verify();
                int var6BB61E3B7BCE0931DA574D19D1D82C88_637352682 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599253828 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599253828;
            } //End block
            // ---------- Original Method ----------
            //if (done) {
                //return -1;
            //}
            //if (count > 0) {
                //int r = super.read(buf, off, nbytes);
                //if (r != -1) {
                    //int size = r;
                    //if (count < size) {
                        //size = (int) count;
                    //}
                    //entry.write(buf, off, size);
                    //count -= size;
                //} else {
                    //count = 0;
                //}
                //if (count == 0) {
                    //done = true;
                    //entry.verify();
                //}
                //return r;
            //} else {
                //done = true;
                //entry.verify();
                //return -1;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.906 -0400", hash_original_method = "F5DF26793DC8C27B5E93038A2CA57A87", hash_generated_method = "DFDF6D5423E27E102478563E797B51EE")
        @Override
        public int available() throws IOException {
            if(done)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_519559437 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837691776 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837691776;
            } //End block
            int varCCBDC8EC9CFFD338AA68EE17A00D45BD_147295672 = (super.available());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330045661 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330045661;
            // ---------- Original Method ----------
            //if (done) {
                //return 0;
            //}
            //return super.available();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.907 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "128C946BF2DAD2BE4728E6D001D4AC0D")
        @Override
        public long skip(long byteCount) throws IOException {
            addTaint(byteCount);
            long var905193B4CE519E6DD3D91E1E370ADA87_1348393423 = (Streams.skipByReading(this, byteCount));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1068107703 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1068107703;
            // ---------- Original Method ----------
            //return Streams.skipByReading(this, byteCount);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.907 -0400", hash_original_field = "1C9A50699E6FAC136026CC053D74C06D", hash_generated_field = "1B54FEE38023C23CFBDF6F59EE98F3A8")

    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.907 -0400", hash_original_field = "0D653D1212A0A8510D5C0DF1F47F7B17", hash_generated_field = "4C54F1EB005D1336C5DED8B80F4F7160")

    static final String META_DIR = "META-INF/";
}

