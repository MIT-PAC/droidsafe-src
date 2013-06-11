package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    static final String META_DIR = "META-INF/";
    private Manifest manifest;
    private ZipEntry manifestEntry;
    JarVerifier verifier;
    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.467 -0400", hash_original_method = "B9B0355AAF6860849CDAA93CC073B40D", hash_generated_method = "09769DB9A851943F282A77BD33F751F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(File file) throws IOException {
        this(file, true);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.467 -0400", hash_original_method = "5EB6670431246E3B0105DDAC48B26AC0", hash_generated_method = "1259D54ADA108F62CCCAD84A3530ACBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(File file, boolean verify) throws IOException {
        super(file);
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(verify);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "793A8CDEEB3B1480C6CD4A5DE140B86D", hash_generated_method = "4695641167E7A2EC3DD4594FA70872D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(File file, boolean verify, int mode) throws IOException {
        super(file, mode);
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(verify);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "7A554CED3F155E72368E52962D72B4D7", hash_generated_method = "2A8BFA3E13D23F3DA9021DA1DC26420D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarFile(String filename) throws IOException {
        this(filename, true);
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "54E668354AB021AFE09898CE1915F8B2", hash_generated_method = "20D6B09E2DCBF0235F71EAC9FDF91DF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "DDF115034FADFE53A1FD9BC36D36CE25", hash_generated_method = "10258EF66DE1457889D30118448188E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Enumeration<JarEntry> entries() {
        //DSFIXME:  CODE0005: Class or interface declaration encountered but not expected
        class JarFileEnumerator implements Enumeration<JarEntry> {
            Enumeration<? extends ZipEntry> ze;
            JarFile jf;
            JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
				dsTaint.addTaint(zenum.dsTaint);
				dsTaint.addTaint(jf.dsTaint);
            }
            public boolean hasMoreElements() {
                return dsTaint.getTaintBoolean();
            }
            public JarEntry nextElement() {
                JarEntry je = new JarEntry(ze.nextElement());
                je.parentJar = jf;
                return (JarEntry)dsTaint.getTaint();
            }
        }
        Enumeration<JarEntry> var4B5F19EA680694127ABE844E7C973602_341170376 = (new JarFileEnumerator(super.entries(), this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "C114B7C700B8AEF8B2BF9DB9E2302906", hash_generated_method = "3F4AAE2A06BBDF16F4CAD02C3DE22BB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarEntry getJarEntry(String name) {
        dsTaint.addTaint(name);
        JarEntry varBD3E9AFC11D257C307DE03BE60031DEA_1431049521 = ((JarEntry) getEntry(name));
        return (JarEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (JarEntry) getEntry(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "E67D102DBF269AEACB3865BB39A89C99", hash_generated_method = "523FB27668FB971821420925A827458E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Manifest getManifest() throws IOException {
        {
            throw new IllegalStateException("JarFile has been closed");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "388F847516FC198A1371FF54043E7729", hash_generated_method = "48FAA31D3ADCD428919A83CF8AB1083A")
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
                    boolean var225934D646BDE3C078A758A5F36FB6DA_1952763218 = (manifestEntry == null && entryName.equalsIgnoreCase(MANIFEST_NAME));
                    {
                        manifestEntry = entry;
                    } //End block
                    {
                        {
                            boolean var389DD4FDD6BA5DDB0A85AEEA57B7C2C6_2074404739 = (verifier != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.468 -0400", hash_original_method = "56C76838D318C13C94DEE83CC11CDED9", hash_generated_method = "01AD61DC1B9389BE2B87C74510A04B5F")
    private static boolean endsWithIgnoreCase(String s, String suffix) {
        return s.regionMatches(true, s.length() - suffix.length(), suffix, 0, suffix.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "53CBE19CD54AC9FA27355C4D3916E5DE", hash_generated_method = "5271487C71AE09252758DCA20CBCD6D3")
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
                boolean varC8A59060D93D59BF577276953C85D279_725045604 = (verifier.readCertificates());
                {
                    verifier.removeMetaEntries();
                    {
                        manifest.removeChunks();
                    } //End block
                    {
                        boolean var8293A0C85FDB7E6035589279E774449B_2107688983 = (!verifier.isSignedJar());
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
            boolean var2F684FA4AC00559BDF766C694C20B2C5_196973172 = (verifier == null || ze.getSize() == -1);
        } //End collapsed parenthetic
        JarVerifier.VerifierEntry entry;
        entry = verifier.initEntry(ze.getName());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "B825DECF198E8D2309850EFFE99C9789", hash_generated_method = "F2E0D191AD72E2CDA1E164026AAEDF76")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "4B8F98994A94A2FEBED0E4C85A619A5C", hash_generated_method = "7AB2D93CD82644009708688D9B83E394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ZipEntry[] getMetaEntriesImpl() {
        List<ZipEntry> list;
        list = new ArrayList<ZipEntry>(8);
        Enumeration<? extends ZipEntry> allEntries;
        allEntries = entries();
        {
            boolean varC33966517FE272D25A9689F102B7D7DF_1510171818 = (allEntries.hasMoreElements());
            {
                ZipEntry ze;
                ze = allEntries.nextElement();
                {
                    boolean var9BACBC07C960934D5A5FCBB74870F6A9_557321303 = (ze.getName().startsWith(META_DIR)
                    && ze.getName().length() > META_DIR.length());
                    {
                        list.add(ze);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8D5789A37F50667ED0EB03D7F7D9B0AE_1234018857 = (list.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "BDB24D1C537D3E9E36DCA2F4C0ADA57E")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "C5D82B21AC1025C83393044900E9B5C1", hash_generated_method = "4A2F03C2D8336ABAFD053464A25D9F0D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "89CF4CB391CD9E8B348E579506073CE6", hash_generated_method = "3DF12C68578E5B59EF4612A68BB1051F")
        @DSModeled(DSC.SAFE)
        @Override
        public int read() throws IOException {
            {
                int r;
                r = super.read();
                {
                    entry.write(r);
                    count--;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "A2A36F60816A3448608DD8EC3FE6DD7B", hash_generated_method = "D6A7D0C82A56B7041005A8DA4DAF2459")
        @DSModeled(DSC.SAFE)
        @Override
        public int read(byte[] buf, int off, int nbytes) throws IOException {
            dsTaint.addTaint(nbytes);
            dsTaint.addTaint(off);
            dsTaint.addTaint(buf);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.469 -0400", hash_original_method = "F5DF26793DC8C27B5E93038A2CA57A87", hash_generated_method = "B3312A90BD9B09754B90B4B1530E5354")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            int varBA26BD6C2684B5A5EC942BA7C9C20D72_1267345683 = (super.available());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (done) {
                //return 0;
            //}
            //return super.available();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.470 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "52A00E01C2476E1361525D1AD8C52022")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public long skip(long byteCount) throws IOException {
            dsTaint.addTaint(byteCount);
            long var302C584A2DF1E0FB3C344FD3955C3746_463471514 = (Streams.skipByReading(this, byteCount));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return Streams.skipByReading(this, byteCount);
        }

        
    }


    
}


