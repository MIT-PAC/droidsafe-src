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
    private Manifest manifest;
    private ZipEntry manifestEntry;
    JarVerifier verifier;
    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.344 -0400", hash_original_method = "B9B0355AAF6860849CDAA93CC073B40D", hash_generated_method = "CFA78763DC116A801AB74163E27A498B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(File file) throws IOException {
        this(file, true);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.345 -0400", hash_original_method = "5EB6670431246E3B0105DDAC48B26AC0", hash_generated_method = "5CAE09583563C42C7060E0E22BC19047")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(File file, boolean verify) throws IOException {
        super(file);
        dsTaint.addTaint(verify);
        dsTaint.addTaint(file.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.346 -0400", hash_original_method = "793A8CDEEB3B1480C6CD4A5DE140B86D", hash_generated_method = "2873D39CFA4FC8A358DADDFE0CEA1E67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(File file, boolean verify, int mode) throws IOException {
        super(file, mode);
        dsTaint.addTaint(verify);
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.346 -0400", hash_original_method = "7A554CED3F155E72368E52962D72B4D7", hash_generated_method = "234963DE3D12514A0E34E84E0BB4E82C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(String filename) throws IOException {
        this(filename, true);
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.347 -0400", hash_original_method = "54E668354AB021AFE09898CE1915F8B2", hash_generated_method = "65FA052F19F8DE285625BD18EB49A314")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(String filename, boolean verify) throws IOException {
        super(filename);
        dsTaint.addTaint(verify);
        dsTaint.addTaint(filename);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.348 -0400", hash_original_method = "DDF115034FADFE53A1FD9BC36D36CE25", hash_generated_method = "659F41BE33A4D15DB54E0AC3EA6C144F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Enumeration<JarEntry> entries() {
        class JarFileEnumerator implements Enumeration<JarEntry> {
            Enumeration<? extends ZipEntry> ze;
            JarFile jf;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.347 -0400", hash_original_method = "C7F3ED49203A5BDA1D49193B6084B2BE", hash_generated_method = "D298247D984316EA5B79EC3D0ED7F9F5")
            @DSModeled(DSC.SAFE)
             JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
                dsTaint.addTaint(zenum.dsTaint);
                dsTaint.addTaint(jf.dsTaint);
                // ---------- Original Method ----------
                //ze = zenum;
                //this.jf = jf;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.347 -0400", hash_original_method = "9E60B2163115C0F4A5143AACEF20F301", hash_generated_method = "765FDC32297C38955F0FF2B05936A766")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean hasMoreElements() {
                boolean varFF0952AD3583A4D6021B234385B302D9_327495 = (ze.hasMoreElements());
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return ze.hasMoreElements();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.348 -0400", hash_original_method = "5675597FFA2F5C3F421325DE8580ECC3", hash_generated_method = "F0A80F23476F20F9069E2B9DEA4B3D62")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public JarEntry nextElement() {
                JarEntry je;
                je = new JarEntry(ze.nextElement());
                je.parentJar = jf;
                return (JarEntry)dsTaint.getTaint();
                // ---------- Original Method ----------
                //JarEntry je = new JarEntry(ze.nextElement());
                //je.parentJar = jf;
                //return je;
            }
        }
        Enumeration<JarEntry> var4B5F19EA680694127ABE844E7C973602_585031709 = (new JarFileEnumerator(super.entries(), this));
        return (Enumeration<JarEntry>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.348 -0400", hash_original_method = "C114B7C700B8AEF8B2BF9DB9E2302906", hash_generated_method = "0CC6EE03DA751DF7B4E7611EC3452364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarEntry getJarEntry(String name) {
        dsTaint.addTaint(name);
        JarEntry varBD3E9AFC11D257C307DE03BE60031DEA_718556385 = ((JarEntry) getEntry(name));
        return (JarEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (JarEntry) getEntry(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.348 -0400", hash_original_method = "E67D102DBF269AEACB3865BB39A89C99", hash_generated_method = "529F1627D45BB29884C767F44E256713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Manifest getManifest() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("JarFile has been closed");
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
        return (Manifest)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.355 -0400", hash_original_method = "388F847516FC198A1371FF54043E7729", hash_generated_method = "CEBD4D3200C1575EC505DD8652EDC0B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readMetaEntries() throws IOException {
        ZipEntry[] metaEntries;
        metaEntries = getMetaEntriesImpl();
        {
            verifier = null;
        } //End block
        boolean signed;
        signed = false;
        {
            ZipEntry entry = metaEntries[0];
            {
                String entryName;
                entryName = entry.getName();
                {
                    boolean var225934D646BDE3C078A758A5F36FB6DA_463749681 = (manifestEntry == null && entryName.equalsIgnoreCase(MANIFEST_NAME));
                    {
                        manifestEntry = entry;
                    } //End block
                    {
                        {
                            boolean var389DD4FDD6BA5DDB0A85AEEA57B7C2C6_1362641105 = (verifier != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.356 -0400", hash_original_method = "53CBE19CD54AC9FA27355C4D3916E5DE", hash_generated_method = "88732F4A54957460CBCAB1795944AE26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getInputStream(ZipEntry ze) throws IOException {
        dsTaint.addTaint(ze.dsTaint);
        {
            getManifest();
        } //End block
        {
            verifier.setManifest(getManifest());
            {
                verifier.mainAttributesEnd = manifest.getMainAttributesEnd();
            } //End block
            {
                boolean varC8A59060D93D59BF577276953C85D279_596449195 = (verifier.readCertificates());
                {
                    verifier.removeMetaEntries();
                    {
                        manifest.removeChunks();
                    } //End block
                    {
                        boolean var8293A0C85FDB7E6035589279E774449B_960968074 = (!verifier.isSignedJar());
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
            boolean var2F684FA4AC00559BDF766C694C20B2C5_1770730073 = (verifier == null || ze.getSize() == -1);
        } //End collapsed parenthetic
        JarVerifier.VerifierEntry entry;
        entry = verifier.initEntry(ze.getName());
        InputStream varE82DC6E049D68D6586AFD27C80A19BF8_66513496 = (new JarFileInputStream(in, ze, entry));
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.356 -0400", hash_original_method = "B825DECF198E8D2309850EFFE99C9789", hash_generated_method = "9D105171DD80D5F1DAEE117A93F87241")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ZipEntry getEntry(String name) {
        dsTaint.addTaint(name);
        ZipEntry ze;
        ze = super.getEntry(name);
        JarEntry je;
        je = new JarEntry(ze);
        je.parentJar = this;
        return (ZipEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ZipEntry ze = super.getEntry(name);
        //if (ze == null) {
            //return ze;
        //}
        //JarEntry je = new JarEntry(ze);
        //je.parentJar = this;
        //return je;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.356 -0400", hash_original_method = "4B8F98994A94A2FEBED0E4C85A619A5C", hash_generated_method = "FCE9FEC103B29A9ACEF1A5F6E116A143")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ZipEntry[] getMetaEntriesImpl() {
        List<ZipEntry> list;
        list = new ArrayList<ZipEntry>(8);
        Enumeration<? extends ZipEntry> allEntries;
        allEntries = entries();
        {
            boolean varC33966517FE272D25A9689F102B7D7DF_1090383902 = (allEntries.hasMoreElements());
            {
                ZipEntry ze;
                ze = allEntries.nextElement();
                {
                    boolean var9BACBC07C960934D5A5FCBB74870F6A9_659208613 = (ze.getName().startsWith(META_DIR)
                    && ze.getName().length() > META_DIR.length());
                    {
                        list.add(ze);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8D5789A37F50667ED0EB03D7F7D9B0AE_1608501084 = (list.size() == 0);
        } //End collapsed parenthetic
        ZipEntry[] result;
        result = new ZipEntry[list.size()];
        list.toArray(result);
        return (ZipEntry[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.357 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "DCC0D06E7F79ED3EAE0E8D99DD76C5B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        super.close();
        closed = true;
        // ---------- Original Method ----------
        //super.close();
        //closed = true;
    }

    
    static final class JarFileInputStream extends FilterInputStream {
        private long count;
        private ZipEntry zipEntry;
        private JarVerifier.VerifierEntry entry;
        private boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.357 -0400", hash_original_method = "C5D82B21AC1025C83393044900E9B5C1", hash_generated_method = "EC9BCFB980FA70D26227C78EA6E9EC9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         JarFileInputStream(InputStream is, ZipEntry ze,
                JarVerifier.VerifierEntry e) {
            super(is);
            dsTaint.addTaint(is.dsTaint);
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(ze.dsTaint);
            count = zipEntry.getSize();
            // ---------- Original Method ----------
            //zipEntry = ze;
            //count = zipEntry.getSize();
            //entry = e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.357 -0400", hash_original_method = "89CF4CB391CD9E8B348E579506073CE6", hash_generated_method = "CB69B2F0EBAA79F157CE92CC3C423AEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.358 -0400", hash_original_method = "A2A36F60816A3448608DD8EC3FE6DD7B", hash_generated_method = "2ED61E5E9ABE847A24AB09DB1033711C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buf, int off, int nbytes) throws IOException {
            dsTaint.addTaint(nbytes);
            dsTaint.addTaint(off);
            dsTaint.addTaint(buf[0]);
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
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.358 -0400", hash_original_method = "F5DF26793DC8C27B5E93038A2CA57A87", hash_generated_method = "B9BACE6FAE453F6A5EC5A570E6AAD824")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            int varBA26BD6C2684B5A5EC942BA7C9C20D72_1278420338 = (super.available());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (done) {
                //return 0;
            //}
            //return super.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.358 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "FBDC3393B70812DADF64958AEA29EB79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public long skip(long byteCount) throws IOException {
            dsTaint.addTaint(byteCount);
            long var302C584A2DF1E0FB3C344FD3955C3746_1344662577 = (Streams.skipByReading(this, byteCount));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return Streams.skipByReading(this, byteCount);
        }

        
    }


    
    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    static final String META_DIR = "META-INF/";
}

