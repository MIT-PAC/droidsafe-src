package java.util.jar;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.078 -0400", hash_original_field = "7F5CB74AF5D7F4B82200738FDBDC5A45", hash_generated_field = "261709621967406C2758961F4730EA20")

    private Manifest manifest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.078 -0400", hash_original_field = "E7B53329F4E7143315B5B9E1E35716BA", hash_generated_field = "A4D7622C7D5230CEA74D7E274931C68D")

    private ZipEntry manifestEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.078 -0400", hash_original_field = "0B5F8F06BAFB3828F619F6F96FC6ADB2", hash_generated_field = "15838C298A89AE0514754B108BF02A73")

    JarVerifier verifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.078 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.078 -0400", hash_original_method = "B9B0355AAF6860849CDAA93CC073B40D", hash_generated_method = "578AF9C3F617699204D04C3678122D01")
    public  JarFile(File file) throws IOException {
        this(file, true);
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.078 -0400", hash_original_method = "5EB6670431246E3B0105DDAC48B26AC0", hash_generated_method = "EA75DEB84CC4E5DC2CC3254DC8530324")
    public  JarFile(File file, boolean verify) throws IOException {
        super(file);
        {
            verifier = new JarVerifier(file.getPath());
        } 
        readMetaEntries();
        addTaint(verify);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.079 -0400", hash_original_method = "793A8CDEEB3B1480C6CD4A5DE140B86D", hash_generated_method = "82604CA112368B43D6711AC6C7FCA5A3")
    public  JarFile(File file, boolean verify, int mode) throws IOException {
        super(file, mode);
        {
            verifier = new JarVerifier(file.getPath());
        } 
        readMetaEntries();
        addTaint(verify);
        addTaint(mode);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.079 -0400", hash_original_method = "7A554CED3F155E72368E52962D72B4D7", hash_generated_method = "E206C57A5C98E6791FFDF685273E8DFA")
    public  JarFile(String filename) throws IOException {
        this(filename, true);
        addTaint(filename.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.079 -0400", hash_original_method = "54E668354AB021AFE09898CE1915F8B2", hash_generated_method = "5F4C2BF87C522AD86F73EA49DE4BFAE9")
    public  JarFile(String filename, boolean verify) throws IOException {
        super(filename);
        {
            verifier = new JarVerifier(filename);
        } 
        readMetaEntries();
        addTaint(verify);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.081 -0400", hash_original_method = "DDF115034FADFE53A1FD9BC36D36CE25", hash_generated_method = "9D008B200137E9F5D3EAC1F745DD0BF7")
    @Override
    public Enumeration<JarEntry> entries() {
        Enumeration<JarEntry> varB4EAC82CA7396A68D541C85D26508E83_959442237 = null; 
        class JarFileEnumerator implements Enumeration<JarEntry> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.079 -0400", hash_original_field = "98B456A0723FA616284A632D9D31821B", hash_generated_field = "BD6898769B3BC196CD1C8BCB2FCBB517")
            Enumeration<? extends ZipEntry> ze;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.079 -0400", hash_original_field = "FE0EC43CC4200E777AA2190ACE58E7B4", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")
            JarFile jf;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.080 -0400", hash_original_method = "C7F3ED49203A5BDA1D49193B6084B2BE", hash_generated_method = "BC00F704C0A9EFA63CDD07B4B4E22805")
              JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
                ze = zenum;
                this.jf = jf;
                
                
                
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.080 -0400", hash_original_method = "9E60B2163115C0F4A5143AACEF20F301", hash_generated_method = "835CBCEE642DDABE1DDB876FE42327B5")
            public boolean hasMoreElements() {
                boolean varFF0952AD3583A4D6021B234385B302D9_40189722 = (ze.hasMoreElements());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163133039 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_163133039;
                
                
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.081 -0400", hash_original_method = "5675597FFA2F5C3F421325DE8580ECC3", hash_generated_method = "BF278404A62C105425171CF48889E1B5")
            public JarEntry nextElement() {
                JarEntry varB4EAC82CA7396A68D541C85D26508E83_455128691 = null; 
                JarEntry je = new JarEntry(ze.nextElement());
                je.parentJar = jf;
                varB4EAC82CA7396A68D541C85D26508E83_455128691 = je;
                varB4EAC82CA7396A68D541C85D26508E83_455128691.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_455128691;
                
                
                
                
            }
        }
        varB4EAC82CA7396A68D541C85D26508E83_959442237 = new JarFileEnumerator(super.entries(), this);
        varB4EAC82CA7396A68D541C85D26508E83_959442237.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_959442237;
        
        
            
            
            
                
                
            
            
                
            
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.082 -0400", hash_original_method = "C114B7C700B8AEF8B2BF9DB9E2302906", hash_generated_method = "94D1C1BE309FDBC2D764936B8BE4872E")
    public JarEntry getJarEntry(String name) {
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_968660351 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_968660351 = (JarEntry) getEntry(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_968660351.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_968660351;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.084 -0400", hash_original_method = "E67D102DBF269AEACB3865BB39A89C99", hash_generated_method = "AB9E65C52BD732AE8594BA465748F184")
    public Manifest getManifest() throws IOException {
        Manifest varB4EAC82CA7396A68D541C85D26508E83_298858043 = null; 
        Manifest varB4EAC82CA7396A68D541C85D26508E83_2055312698 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("JarFile has been closed");
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_298858043 = manifest;
        } 
        try 
        {
            InputStream is = super.getInputStream(manifestEntry);
            {
                verifier.addMetaEntry(manifestEntry.getName(), Streams.readFully(is));
                is = super.getInputStream(manifestEntry);
            } 
            try 
            {
                manifest = new Manifest(is, verifier != null);
            } 
            finally 
            {
                is.close();
            } 
            manifestEntry = null;
        } 
        catch (NullPointerException e)
        {
            manifestEntry = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2055312698 = manifest;
        Manifest varA7E53CE21691AB073D9660D615818899_1743562122; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1743562122 = varB4EAC82CA7396A68D541C85D26508E83_298858043;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1743562122 = varB4EAC82CA7396A68D541C85D26508E83_2055312698;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1743562122.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1743562122;
        
        
            
        
        
            
        
        
            
            
                
                
            
            
                
            
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.090 -0400", hash_original_method = "388F847516FC198A1371FF54043E7729", hash_generated_method = "00AFA0A2F8DB69283FC22B8A190E79D9")
    private void readMetaEntries() throws IOException {
        ZipEntry[] metaEntries = getMetaEntriesImpl();
        {
            verifier = null;
        } 
        boolean signed = false;
        {
            ZipEntry entry = metaEntries[0];
            {
                String entryName = entry.getName();
                {
                    boolean var225934D646BDE3C078A758A5F36FB6DA_736693183 = (manifestEntry == null && entryName.equalsIgnoreCase(MANIFEST_NAME));
                    {
                        manifestEntry = entry;
                    } 
                    {
                        {
                            boolean var389DD4FDD6BA5DDB0A85AEEA57B7C2C6_1581067372 = (verifier != null
                        && (endsWithIgnoreCase(entryName, ".SF")
                                || endsWithIgnoreCase(entryName, ".DSA")
                                || endsWithIgnoreCase(entryName, ".RSA")));
                            {
                                signed = true;
                                InputStream is = super.getInputStream(entry);
                                verifier.addMetaEntry(entryName, Streams.readFully(is));
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            verifier = null;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean endsWithIgnoreCase(String s, String suffix) {
        return s.regionMatches(true, s.length() - suffix.length(), suffix, 0, suffix.length());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.091 -0400", hash_original_method = "53CBE19CD54AC9FA27355C4D3916E5DE", hash_generated_method = "7A2FE9BAB679BB13D5160510D902BC08")
    @Override
    public InputStream getInputStream(ZipEntry ze) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1004255932 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1672848602 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_653320793 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1070860208 = null; 
        {
            getManifest();
        } 
        {
            verifier.setManifest(getManifest());
            {
                verifier.mainAttributesEnd = manifest.getMainAttributesEnd();
            } 
            {
                boolean varC8A59060D93D59BF577276953C85D279_1549448004 = (verifier.readCertificates());
                {
                    verifier.removeMetaEntries();
                    {
                        manifest.removeChunks();
                    } 
                    {
                        boolean var8293A0C85FDB7E6035589279E774449B_1878047862 = (!verifier.isSignedJar());
                        {
                            verifier = null;
                        } 
                    } 
                } 
            } 
        } 
        InputStream in = super.getInputStream(ze);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1004255932 = null;
        } 
        {
            boolean var2F684FA4AC00559BDF766C694C20B2C5_757458390 = (verifier == null || ze.getSize() == -1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1672848602 = in;
            } 
        } 
        JarVerifier.VerifierEntry entry = verifier.initEntry(ze.getName());
        {
            varB4EAC82CA7396A68D541C85D26508E83_653320793 = in;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1070860208 = new JarFileInputStream(in, ze, entry);
        addTaint(ze.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_201283804; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_201283804 = varB4EAC82CA7396A68D541C85D26508E83_1004255932;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_201283804 = varB4EAC82CA7396A68D541C85D26508E83_1672848602;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_201283804 = varB4EAC82CA7396A68D541C85D26508E83_653320793;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_201283804 = varB4EAC82CA7396A68D541C85D26508E83_1070860208;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_201283804.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_201283804;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.093 -0400", hash_original_method = "B825DECF198E8D2309850EFFE99C9789", hash_generated_method = "C7E854399BAEEE474FC94EA56AE5005B")
    @Override
    public ZipEntry getEntry(String name) {
        ZipEntry varB4EAC82CA7396A68D541C85D26508E83_2010709221 = null; 
        ZipEntry varB4EAC82CA7396A68D541C85D26508E83_244849769 = null; 
        ZipEntry ze = super.getEntry(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2010709221 = ze;
        } 
        JarEntry je = new JarEntry(ze);
        je.parentJar = this;
        varB4EAC82CA7396A68D541C85D26508E83_244849769 = je;
        addTaint(name.getTaint());
        ZipEntry varA7E53CE21691AB073D9660D615818899_310617393; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_310617393 = varB4EAC82CA7396A68D541C85D26508E83_2010709221;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_310617393 = varB4EAC82CA7396A68D541C85D26508E83_244849769;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_310617393.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_310617393;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.094 -0400", hash_original_method = "4B8F98994A94A2FEBED0E4C85A619A5C", hash_generated_method = "6FE3E9715C85989479C27D61063ED6A4")
    private ZipEntry[] getMetaEntriesImpl() {
        ZipEntry[] varB4EAC82CA7396A68D541C85D26508E83_1122470496 = null; 
        ZipEntry[] varB4EAC82CA7396A68D541C85D26508E83_1455577812 = null; 
        List<ZipEntry> list = new ArrayList<ZipEntry>(8);
        Enumeration<? extends ZipEntry> allEntries = entries();
        {
            boolean varC33966517FE272D25A9689F102B7D7DF_271760733 = (allEntries.hasMoreElements());
            {
                ZipEntry ze = allEntries.nextElement();
                {
                    boolean var9BACBC07C960934D5A5FCBB74870F6A9_869286690 = (ze.getName().startsWith(META_DIR)
                    && ze.getName().length() > META_DIR.length());
                    {
                        list.add(ze);
                    } 
                } 
            } 
        } 
        {
            boolean var8D5789A37F50667ED0EB03D7F7D9B0AE_91478724 = (list.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1122470496 = null;
            } 
        } 
        ZipEntry[] result = new ZipEntry[list.size()];
        list.toArray(result);
        varB4EAC82CA7396A68D541C85D26508E83_1455577812 = result;
        ZipEntry[] varA7E53CE21691AB073D9660D615818899_2105946827; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2105946827 = varB4EAC82CA7396A68D541C85D26508E83_1122470496;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2105946827 = varB4EAC82CA7396A68D541C85D26508E83_1455577812;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2105946827.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2105946827;
        
        
        
        
            
            
                    
                
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.094 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "DCC0D06E7F79ED3EAE0E8D99DD76C5B5")
    @Override
    public void close() throws IOException {
        super.close();
        closed = true;
        
        
        
    }

    
    static final class JarFileInputStream extends FilterInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.094 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "96817EEF83FA1C93DC2A9F8452312BE5")

        private long count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.094 -0400", hash_original_field = "A984E853B1E1D85D70B1FBA492B2E542", hash_generated_field = "97423CF71E793626D5B9FCF841E2156D")

        private ZipEntry zipEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.094 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "D893B68F418C2812B051677DEAD7BC47")

        private JarVerifier.VerifierEntry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.094 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "9C759896300CD7D902BE34CCDA83590B")

        private boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.095 -0400", hash_original_method = "C5D82B21AC1025C83393044900E9B5C1", hash_generated_method = "35926C0AE1BC8134DE905FEF9C6484F6")
          JarFileInputStream(InputStream is, ZipEntry ze,
                JarVerifier.VerifierEntry e) {
            super(is);
            zipEntry = ze;
            count = zipEntry.getSize();
            entry = e;
            addTaint(is.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.095 -0400", hash_original_method = "89CF4CB391CD9E8B348E579506073CE6", hash_generated_method = "1ACC8C8035B34A31EAC4E58B3E55EE85")
        @Override
        public int read() throws IOException {
            {
                int r = super.read();
                {
                    entry.write(r);
                } 
                {
                    count = 0;
                } 
                {
                    done = true;
                    entry.verify();
                } 
            } 
            {
                done = true;
                entry.verify();
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793537013 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793537013;
            
            
                
            
            
                
                
                    
                    
                
                    
                
                
                    
                    
                
                
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.096 -0400", hash_original_method = "A2A36F60816A3448608DD8EC3FE6DD7B", hash_generated_method = "3D148C46E046710DE6CB533EECA61C30")
        @Override
        public int read(byte[] buf, int off, int nbytes) throws IOException {
            {
                int r = super.read(buf, off, nbytes);
                {
                    int size = r;
                    {
                        size = (int) count;
                    } 
                    entry.write(buf, off, size);
                    count -= size;
                } 
                {
                    count = 0;
                } 
                {
                    done = true;
                    entry.verify();
                } 
            } 
            {
                done = true;
                entry.verify();
            } 
            addTaint(buf[0]);
            addTaint(off);
            addTaint(nbytes);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344280589 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344280589;
            
            
                
            
            
                
                
                    
                    
                        
                    
                    
                    
                
                    
                
                
                    
                    
                
                
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.098 -0400", hash_original_method = "F5DF26793DC8C27B5E93038A2CA57A87", hash_generated_method = "A09D9B22B3395F32017227003ABF5385")
        @Override
        public int available() throws IOException {
            int varBA26BD6C2684B5A5EC942BA7C9C20D72_855791636 = (super.available());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193889623 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193889623;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.099 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "66EA0535678DFB590E94D2CEC46CBA1C")
        @Override
        public long skip(long byteCount) throws IOException {
            long var302C584A2DF1E0FB3C344FD3955C3746_614661261 = (Streams.skipByReading(this, byteCount));
            addTaint(byteCount);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1396038097 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1396038097;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.099 -0400", hash_original_field = "1C9A50699E6FAC136026CC053D74C06D", hash_generated_field = "1B54FEE38023C23CFBDF6F59EE98F3A8")

    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.099 -0400", hash_original_field = "0D653D1212A0A8510D5C0DF1F47F7B17", hash_generated_field = "4C54F1EB005D1336C5DED8B80F4F7160")

    static final String META_DIR = "META-INF/";
}

