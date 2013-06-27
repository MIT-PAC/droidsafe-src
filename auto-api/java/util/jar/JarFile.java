package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.616 -0400", hash_original_field = "7F5CB74AF5D7F4B82200738FDBDC5A45", hash_generated_field = "261709621967406C2758961F4730EA20")

    private Manifest manifest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.616 -0400", hash_original_field = "E7B53329F4E7143315B5B9E1E35716BA", hash_generated_field = "A4D7622C7D5230CEA74D7E274931C68D")

    private ZipEntry manifestEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.616 -0400", hash_original_field = "0B5F8F06BAFB3828F619F6F96FC6ADB2", hash_generated_field = "15838C298A89AE0514754B108BF02A73")

    JarVerifier verifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.616 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.623 -0400", hash_original_method = "B9B0355AAF6860849CDAA93CC073B40D", hash_generated_method = "578AF9C3F617699204D04C3678122D01")
    public  JarFile(File file) throws IOException {
        this(file, true);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.624 -0400", hash_original_method = "5EB6670431246E3B0105DDAC48B26AC0", hash_generated_method = "EA75DEB84CC4E5DC2CC3254DC8530324")
    public  JarFile(File file, boolean verify) throws IOException {
        super(file);
        {
            verifier = new JarVerifier(file.getPath());
        } //End block
        readMetaEntries();
        addTaint(verify);
        // ---------- Original Method ----------
        //if (verify) {
            //verifier = new JarVerifier(file.getPath());
        //}
        //readMetaEntries();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.625 -0400", hash_original_method = "793A8CDEEB3B1480C6CD4A5DE140B86D", hash_generated_method = "82604CA112368B43D6711AC6C7FCA5A3")
    public  JarFile(File file, boolean verify, int mode) throws IOException {
        super(file, mode);
        {
            verifier = new JarVerifier(file.getPath());
        } //End block
        readMetaEntries();
        addTaint(verify);
        addTaint(mode);
        // ---------- Original Method ----------
        //if (verify) {
            //verifier = new JarVerifier(file.getPath());
        //}
        //readMetaEntries();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.625 -0400", hash_original_method = "7A554CED3F155E72368E52962D72B4D7", hash_generated_method = "E206C57A5C98E6791FFDF685273E8DFA")
    public  JarFile(String filename) throws IOException {
        this(filename, true);
        addTaint(filename.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.641 -0400", hash_original_method = "54E668354AB021AFE09898CE1915F8B2", hash_generated_method = "5F4C2BF87C522AD86F73EA49DE4BFAE9")
    public  JarFile(String filename, boolean verify) throws IOException {
        super(filename);
        {
            verifier = new JarVerifier(filename);
        } //End block
        readMetaEntries();
        addTaint(verify);
        // ---------- Original Method ----------
        //if (verify) {
            //verifier = new JarVerifier(filename);
        //}
        //readMetaEntries();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.665 -0400", hash_original_method = "DDF115034FADFE53A1FD9BC36D36CE25", hash_generated_method = "0FE44427A6333A755530CC07F9E31B75")
    @Override
    public Enumeration<JarEntry> entries() {
        Enumeration<JarEntry> varB4EAC82CA7396A68D541C85D26508E83_1651608792 = null; //Variable for return #1
        class JarFileEnumerator implements Enumeration<JarEntry> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.642 -0400", hash_original_field = "98B456A0723FA616284A632D9D31821B", hash_generated_field = "BD6898769B3BC196CD1C8BCB2FCBB517")
            Enumeration<? extends ZipEntry> ze;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.642 -0400", hash_original_field = "FE0EC43CC4200E777AA2190ACE58E7B4", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")
            JarFile jf;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.663 -0400", hash_original_method = "C7F3ED49203A5BDA1D49193B6084B2BE", hash_generated_method = "BC00F704C0A9EFA63CDD07B4B4E22805")
              JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
                ze = zenum;
                this.jf = jf;
                // ---------- Original Method ----------
                //ze = zenum;
                //this.jf = jf;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.663 -0400", hash_original_method = "9E60B2163115C0F4A5143AACEF20F301", hash_generated_method = "DA4653EE41FB13394FDF389485950387")
            public boolean hasMoreElements() {
                boolean varFF0952AD3583A4D6021B234385B302D9_1920287157 = (ze.hasMoreElements());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829896933 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_829896933;
                // ---------- Original Method ----------
                //return ze.hasMoreElements();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.664 -0400", hash_original_method = "5675597FFA2F5C3F421325DE8580ECC3", hash_generated_method = "731200EBB9F7AFCE43FD2147DBAE65B6")
            public JarEntry nextElement() {
                JarEntry varB4EAC82CA7396A68D541C85D26508E83_1540847374 = null; //Variable for return #1
                JarEntry je;
                je = new JarEntry(ze.nextElement());
                je.parentJar = jf;
                varB4EAC82CA7396A68D541C85D26508E83_1540847374 = je;
                varB4EAC82CA7396A68D541C85D26508E83_1540847374.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1540847374;
                // ---------- Original Method ----------
                //JarEntry je = new JarEntry(ze.nextElement());
                //je.parentJar = jf;
                //return je;
            }
        }
        varB4EAC82CA7396A68D541C85D26508E83_1651608792 = new JarFileEnumerator(super.entries(), this);
        varB4EAC82CA7396A68D541C85D26508E83_1651608792.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1651608792;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.666 -0400", hash_original_method = "C114B7C700B8AEF8B2BF9DB9E2302906", hash_generated_method = "49DD6253855222F6A9257BB03932D7DF")
    public JarEntry getJarEntry(String name) {
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_308164125 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_308164125 = (JarEntry) getEntry(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_308164125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_308164125;
        // ---------- Original Method ----------
        //return (JarEntry) getEntry(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.677 -0400", hash_original_method = "E67D102DBF269AEACB3865BB39A89C99", hash_generated_method = "FEC40FC9A4B004DEB29684DD443BED34")
    public Manifest getManifest() throws IOException {
        Manifest varB4EAC82CA7396A68D541C85D26508E83_1574669537 = null; //Variable for return #1
        Manifest varB4EAC82CA7396A68D541C85D26508E83_1120006333 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("JarFile has been closed");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1574669537 = manifest;
        } //End block
        try 
        {
            InputStream is;
            is = super.getInputStream(manifestEntry);
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
        varB4EAC82CA7396A68D541C85D26508E83_1120006333 = manifest;
        Manifest varA7E53CE21691AB073D9660D615818899_943201455; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_943201455 = varB4EAC82CA7396A68D541C85D26508E83_1574669537;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_943201455 = varB4EAC82CA7396A68D541C85D26508E83_1120006333;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_943201455.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_943201455;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.771 -0400", hash_original_method = "388F847516FC198A1371FF54043E7729", hash_generated_method = "CBE1F8630C9677795F6599087DB94256")
    private void readMetaEntries() throws IOException {
        ZipEntry[] metaEntries;
        metaEntries = getMetaEntriesImpl();
        {
            verifier = null;
        } //End block
        boolean signed;
        signed = false;
        {
            Iterator<ZipEntry> var6D0A34D60B8C79C46D77A3FAE8BFE594_964573705 = (metaEntries).iterator();
            var6D0A34D60B8C79C46D77A3FAE8BFE594_964573705.hasNext();
            ZipEntry entry = var6D0A34D60B8C79C46D77A3FAE8BFE594_964573705.next();
            {
                String entryName;
                entryName = entry.getName();
                {
                    boolean var225934D646BDE3C078A758A5F36FB6DA_1549150366 = (manifestEntry == null && entryName.equalsIgnoreCase(MANIFEST_NAME));
                    {
                        manifestEntry = entry;
                    } //End block
                    {
                        {
                            boolean var389DD4FDD6BA5DDB0A85AEEA57B7C2C6_1738011479 = (verifier != null
                        && (endsWithIgnoreCase(entryName, ".SF")
                                || endsWithIgnoreCase(entryName, ".DSA")
                                || endsWithIgnoreCase(entryName, ".RSA")));
                            {
                                signed = true;
                                InputStream is;
                                is = super.getInputStream(entry);
                                verifier.addMetaEntry(entryName, Streams.readFully(is));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            verifier = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean endsWithIgnoreCase(String s, String suffix) {
        return s.regionMatches(true, s.length() - suffix.length(), suffix, 0, suffix.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.789 -0400", hash_original_method = "53CBE19CD54AC9FA27355C4D3916E5DE", hash_generated_method = "40454C9565372D474B2E89A5187F2009")
    @Override
    public InputStream getInputStream(ZipEntry ze) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_518614361 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_297564517 = null; //Variable for return #2
        InputStream varB4EAC82CA7396A68D541C85D26508E83_502738166 = null; //Variable for return #3
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1152721036 = null; //Variable for return #4
        {
            getManifest();
        } //End block
        {
            verifier.setManifest(getManifest());
            {
                verifier.mainAttributesEnd = manifest.getMainAttributesEnd();
            } //End block
            {
                boolean varC8A59060D93D59BF577276953C85D279_854610564 = (verifier.readCertificates());
                {
                    verifier.removeMetaEntries();
                    {
                        manifest.removeChunks();
                    } //End block
                    {
                        boolean var8293A0C85FDB7E6035589279E774449B_2091583030 = (!verifier.isSignedJar());
                        {
                            verifier = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        InputStream in;
        in = super.getInputStream(ze);
        {
            varB4EAC82CA7396A68D541C85D26508E83_518614361 = null;
        } //End block
        {
            boolean var2F684FA4AC00559BDF766C694C20B2C5_1834267538 = (verifier == null || ze.getSize() == -1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_297564517 = in;
            } //End block
        } //End collapsed parenthetic
        JarVerifier.VerifierEntry entry;
        entry = verifier.initEntry(ze.getName());
        {
            varB4EAC82CA7396A68D541C85D26508E83_502738166 = in;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1152721036 = new JarFileInputStream(in, ze, entry);
        addTaint(ze.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1240080896; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1240080896 = varB4EAC82CA7396A68D541C85D26508E83_518614361;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1240080896 = varB4EAC82CA7396A68D541C85D26508E83_297564517;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1240080896 = varB4EAC82CA7396A68D541C85D26508E83_502738166;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1240080896 = varB4EAC82CA7396A68D541C85D26508E83_1152721036;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1240080896.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1240080896;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.801 -0400", hash_original_method = "B825DECF198E8D2309850EFFE99C9789", hash_generated_method = "940CE42039F82B8B90CC807F64A110F1")
    @Override
    public ZipEntry getEntry(String name) {
        ZipEntry varB4EAC82CA7396A68D541C85D26508E83_2016996344 = null; //Variable for return #1
        ZipEntry varB4EAC82CA7396A68D541C85D26508E83_1526167838 = null; //Variable for return #2
        ZipEntry ze;
        ze = super.getEntry(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2016996344 = ze;
        } //End block
        JarEntry je;
        je = new JarEntry(ze);
        je.parentJar = this;
        varB4EAC82CA7396A68D541C85D26508E83_1526167838 = je;
        addTaint(name.getTaint());
        ZipEntry varA7E53CE21691AB073D9660D615818899_796127714; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_796127714 = varB4EAC82CA7396A68D541C85D26508E83_2016996344;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_796127714 = varB4EAC82CA7396A68D541C85D26508E83_1526167838;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_796127714.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_796127714;
        // ---------- Original Method ----------
        //ZipEntry ze = super.getEntry(name);
        //if (ze == null) {
            //return ze;
        //}
        //JarEntry je = new JarEntry(ze);
        //je.parentJar = this;
        //return je;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.803 -0400", hash_original_method = "4B8F98994A94A2FEBED0E4C85A619A5C", hash_generated_method = "F31E4E78F65721AEB24FAF412346AB03")
    private ZipEntry[] getMetaEntriesImpl() {
        ZipEntry[] varB4EAC82CA7396A68D541C85D26508E83_501948382 = null; //Variable for return #1
        ZipEntry[] varB4EAC82CA7396A68D541C85D26508E83_210043092 = null; //Variable for return #2
        List<ZipEntry> list;
        list = new ArrayList<ZipEntry>(8);
        Enumeration<? extends ZipEntry> allEntries;
        allEntries = entries();
        {
            boolean varC33966517FE272D25A9689F102B7D7DF_331723319 = (allEntries.hasMoreElements());
            {
                ZipEntry ze;
                ze = allEntries.nextElement();
                {
                    boolean var9BACBC07C960934D5A5FCBB74870F6A9_1972831624 = (ze.getName().startsWith(META_DIR)
                    && ze.getName().length() > META_DIR.length());
                    {
                        list.add(ze);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8D5789A37F50667ED0EB03D7F7D9B0AE_1987585156 = (list.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_501948382 = null;
            } //End block
        } //End collapsed parenthetic
        ZipEntry[] result;
        result = new ZipEntry[list.size()];
        list.toArray(result);
        varB4EAC82CA7396A68D541C85D26508E83_210043092 = result;
        ZipEntry[] varA7E53CE21691AB073D9660D615818899_1685294105; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1685294105 = varB4EAC82CA7396A68D541C85D26508E83_501948382;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1685294105 = varB4EAC82CA7396A68D541C85D26508E83_210043092;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1685294105.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1685294105;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.816 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "DCC0D06E7F79ED3EAE0E8D99DD76C5B5")
    @Override
    public void close() throws IOException {
        super.close();
        closed = true;
        // ---------- Original Method ----------
        //super.close();
        //closed = true;
    }

    
    static final class JarFileInputStream extends FilterInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.816 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "96817EEF83FA1C93DC2A9F8452312BE5")

        private long count;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.816 -0400", hash_original_field = "A984E853B1E1D85D70B1FBA492B2E542", hash_generated_field = "97423CF71E793626D5B9FCF841E2156D")

        private ZipEntry zipEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.816 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "D893B68F418C2812B051677DEAD7BC47")

        private JarVerifier.VerifierEntry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.817 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "9C759896300CD7D902BE34CCDA83590B")

        private boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.818 -0400", hash_original_method = "C5D82B21AC1025C83393044900E9B5C1", hash_generated_method = "35926C0AE1BC8134DE905FEF9C6484F6")
          JarFileInputStream(InputStream is, ZipEntry ze,
                JarVerifier.VerifierEntry e) {
            super(is);
            zipEntry = ze;
            count = zipEntry.getSize();
            entry = e;
            addTaint(is.getTaint());
            // ---------- Original Method ----------
            //zipEntry = ze;
            //count = zipEntry.getSize();
            //entry = e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.827 -0400", hash_original_method = "89CF4CB391CD9E8B348E579506073CE6", hash_generated_method = "E9AE584BB82D9C7DCA2D4A574DA03B59")
        @Override
        public int read() throws IOException {
            {
                int r;
                r = super.read();
                {
                    entry.write(r);
                } //End block
                {
                    count = 0;
                } //End block
                {
                    done = true;
                    entry.verify();
                } //End block
            } //End block
            {
                done = true;
                entry.verify();
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284041192 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284041192;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.836 -0400", hash_original_method = "A2A36F60816A3448608DD8EC3FE6DD7B", hash_generated_method = "63DF84BD93FA9780B49F7C82F26C2CF0")
        @Override
        public int read(byte[] buf, int off, int nbytes) throws IOException {
            {
                int r;
                r = super.read(buf, off, nbytes);
                {
                    int size;
                    size = r;
                    {
                        size = (int) count;
                    } //End block
                    entry.write(buf, off, size);
                    count -= size;
                } //End block
                {
                    count = 0;
                } //End block
                {
                    done = true;
                    entry.verify();
                } //End block
            } //End block
            {
                done = true;
                entry.verify();
            } //End block
            addTaint(buf[0]);
            addTaint(off);
            addTaint(nbytes);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636192573 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636192573;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.837 -0400", hash_original_method = "F5DF26793DC8C27B5E93038A2CA57A87", hash_generated_method = "5F3763CC6E58FA370287955E9143CB85")
        @Override
        public int available() throws IOException {
            int varBA26BD6C2684B5A5EC942BA7C9C20D72_1200899397 = (super.available());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733855081 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733855081;
            // ---------- Original Method ----------
            //if (done) {
                //return 0;
            //}
            //return super.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.838 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "B4069CD61BEF7B8D3FC8FC40F0F49C77")
        @Override
        public long skip(long byteCount) throws IOException {
            long var302C584A2DF1E0FB3C344FD3955C3746_2051660754 = (Streams.skipByReading(this, byteCount));
            addTaint(byteCount);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1809105071 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1809105071;
            // ---------- Original Method ----------
            //return Streams.skipByReading(this, byteCount);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.853 -0400", hash_original_field = "1C9A50699E6FAC136026CC053D74C06D", hash_generated_field = "1B54FEE38023C23CFBDF6F59EE98F3A8")

    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.853 -0400", hash_original_field = "0D653D1212A0A8510D5C0DF1F47F7B17", hash_generated_field = "84D20D16894E554382451901C2E12165")

    static String META_DIR = "META-INF/";
}

