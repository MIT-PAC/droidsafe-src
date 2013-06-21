package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.ContentHandlerFactory;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Permission;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;
import libcore.net.UriCodec;

public class JarURLConnectionImpl extends JarURLConnection {
    private URL jarFileURL;
    private InputStream jarInput;
    private JarFile jarFile;
    private JarEntry jarEntry;
    private boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.646 -0400", hash_original_method = "5F30611EBB0C16B95EA706518FA3E093", hash_generated_method = "3443D1079FD53138A089212B57460717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarURLConnectionImpl(URL url) throws MalformedURLException,
            IOException {
        super(url);
        dsTaint.addTaint(url.dsTaint);
        jarFileURL = getJarFileURL();
        jarFileURLConnection = jarFileURL.openConnection();
        // ---------- Original Method ----------
        //jarFileURL = getJarFileURL();
        //jarFileURLConnection = jarFileURL.openConnection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.646 -0400", hash_original_method = "0D95FCCAA7871FCD5DE5E8081721F47B", hash_generated_method = "926B22BA5526EACA5468913246024D03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect() throws IOException {
        {
            findJarFile();
            findJarEntry();
            connected = true;
        } //End block
        // ---------- Original Method ----------
        //if (!connected) {
            //findJarFile(); 
            //findJarEntry(); 
            //connected = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.646 -0400", hash_original_method = "BAB8781FAD6151E9B45BF4A1B941497D", hash_generated_method = "38E1094EC4FFA9E8F18CE2C9B9C7030E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public JarFile getJarFile() throws IOException {
        connect();
        return (JarFile)dsTaint.getTaint();
        // ---------- Original Method ----------
        //connect();
        //return jarFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.647 -0400", hash_original_method = "E0D7867F43E3325F58427586B81262FC", hash_generated_method = "C29872FA49882A2B77F6EFDBD01BF573")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void findJarFile() throws IOException {
        JarFile jar;
        jar = null;
        {
            boolean var4488D7339955339089D556491FAB9F35_372544527 = (getUseCaches());
            {
                {
                    jarFile = jarCache.get(jarFileURL);
                } //End block
                {
                    jar = openJarFile();
                    {
                        jarFile = jarCache.get(jarFileURL);
                        {
                            jarCache.put(jarFileURL, jar);
                            jarFile = jar;
                        } //End block
                        {
                            jar.close();
                        } //End block
                    } //End block
                } //End block
            } //End block
            {
                jarFile = openJarFile();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } //End block
        // ---------- Original Method ----------
        //JarFile jar = null;
        //if (getUseCaches()) {
            //synchronized (jarCache) {
                //jarFile = jarCache.get(jarFileURL);
            //}
            //if (jarFile == null) {
                //jar = openJarFile();
                //synchronized (jarCache) {
                    //jarFile = jarCache.get(jarFileURL);
                    //if (jarFile == null) {
                        //jarCache.put(jarFileURL, jar);
                        //jarFile = jar;
                    //} else {
                        //jar.close();
                    //}
                //}
            //}
        //} else {
            //jarFile = openJarFile();
        //}
        //if (jarFile == null) {
            //throw new IOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.647 -0400", hash_original_method = "AF67425F611C6CCEA6B4F36EBE571AB2", hash_generated_method = "5CAB64C1C2D7AF14E0552A87324E9BBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     JarFile openJarFile() throws IOException {
        {
            boolean var4905B00C7F001BF20E914C34E673ABA2_2023046619 = (jarFileURL.getProtocol().equals("file"));
            {
                String decodedFile;
                decodedFile = UriCodec.decode(jarFileURL.getFile());
                JarFile varB0F0CB3F9828574FE8AB46A8E4F4D0CB_7018003 = (new JarFile(new File(decodedFile), true, ZipFile.OPEN_READ));
            } //End block
            {
                InputStream is;
                is = jarFileURL.openConnection().getInputStream();
                try 
                {
                    FileOutputStream fos;
                    fos = null;
                    JarFile result;
                    result = null;
                    try 
                    {
                        File tempJar;
                        tempJar = File.createTempFile("hyjar_", ".tmp", null);
                        tempJar.deleteOnExit();
                        fos = new FileOutputStream(tempJar);
                        byte[] buf;
                        buf = new byte[4096];
                        int nbytes;
                        nbytes = 0;
                        {
                            boolean var884A04FD9ADAFCF2F0817BF3B474DB07_354998156 = ((nbytes = is.read(buf)) > -1);
                            {
                                fos.write(buf, 0, nbytes);
                            } //End block
                        } //End collapsed parenthetic
                        fos.close();
                        JarFile var4C0B96F130EBFCA1DFADA567EC2EEA5F_1935729396 = (new JarFile(tempJar, true, ZipFile.OPEN_READ | ZipFile.OPEN_DELETE));
                    } //End block
                    catch (IOException e)
                    { }
                    finally 
                    {
                        {
                            try 
                            {
                                fos.close();
                            } //End block
                            catch (IOException ex)
                            { }
                        } //End block
                    } //End block
                } //End block
                finally 
                {
                    {
                        is.close();
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (JarFile)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.647 -0400", hash_original_method = "4969FA075748EE67279B88C22279B5EB", hash_generated_method = "C591130742FA8536A7E5D4C913AF72AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public JarEntry getJarEntry() throws IOException {
        connect();
        return (JarEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //connect();
        //return jarEntry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.648 -0400", hash_original_method = "47E7331F0B55D0071578FE2F3BE66635", hash_generated_method = "C8C0F7A3E967A890A475D95473857C74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void findJarEntry() throws IOException {
        {
            boolean varE49F2B7FF91F623F4C37CC04186E7780_1964561157 = (getEntryName() == null);
        } //End collapsed parenthetic
        jarEntry = jarFile.getJarEntry(getEntryName());
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException(getEntryName());
        } //End block
        // ---------- Original Method ----------
        //if (getEntryName() == null) {
            //return;
        //}
        //jarEntry = jarFile.getJarEntry(getEntryName());
        //if (jarEntry == null) {
            //throw new FileNotFoundException(getEntryName());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.648 -0400", hash_original_method = "96C498B69E21157D37D76B9902545F24", hash_generated_method = "CFA4107DE9FD7A7B8A082C219E906255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getInputStream() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("JarURLConnection InputStream has been closed");
        } //End block
        connect();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Jar entry not specified");
        } //End block
        InputStream var4487BD74E805B40821996F6BB2123151_457683214 = (jarInput = new JarURLConnectionInputStream(jarFile
                .getInputStream(jarEntry), jarFile));
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IllegalStateException("JarURLConnection InputStream has been closed");
        //}
        //connect();
        //if (jarInput != null) {
            //return jarInput;
        //}
        //if (jarEntry == null) {
            //throw new IOException("Jar entry not specified");
        //}
        //return jarInput = new JarURLConnectionInputStream(jarFile
                //.getInputStream(jarEntry), jarFile);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.648 -0400", hash_original_method = "626D247225A5C5A729C002EF0C988C29", hash_generated_method = "2870A7C312B08961BEC15785549C1D48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getContentType() {
        {
            boolean var5A4D7A486C11D5F49AB1CA63C5A4886E_345044527 = (url.getFile().endsWith("!/"));
        } //End collapsed parenthetic
        String cType;
        cType = null;
        String entryName;
        entryName = getEntryName();
        {
            cType = guessContentTypeFromName(entryName);
        } //End block
        {
            try 
            {
                connect();
                cType = jarFileURLConnection.getContentType();
            } //End block
            catch (IOException ioe)
            { }
        } //End block
        {
            cType = "content/unknown";
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (url.getFile().endsWith("!/")) {
            //return "x-java/jar";
        //}
        //String cType = null;
        //String entryName = getEntryName();
        //if (entryName != null) {
            //cType = guessContentTypeFromName(entryName);
        //} else {
            //try {
                //connect();
                //cType = jarFileURLConnection.getContentType();
            //} catch (IOException ioe) {
            //}
        //}
        //if (cType == null) {
            //cType = "content/unknown";
        //}
        //return cType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.648 -0400", hash_original_method = "C82FBA290AE26D875C8865E2241D6919", hash_generated_method = "B358A23867EA28F08011E2F8C9F7D39D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getContentLength() {
        try 
        {
            connect();
            {
                int var1758F21177BADAC1F67FFD78824D606B_1637510319 = (jarFileURLConnection.getContentLength());
            } //End block
            int var2BB2A25985BB5B3A4266161AB3B248B5_730287642 = ((int) getJarEntry().getSize());
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //connect();
            //if (jarEntry == null) {
                //return jarFileURLConnection.getContentLength();
            //}
            //return (int) getJarEntry().getSize();
        //} catch (IOException e) {
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.649 -0400", hash_original_method = "277EA8603145BCD9B1620E5B0867C76D", hash_generated_method = "818991B11AE7A67BD094A325F57761DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getContent() throws IOException {
        connect();
        Object var43513ECE1BA4BC60B27D2C498D13FB34_183494812 = (super.getContent());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //connect();
        //if (jarEntry == null) {
            //return jarFile;
        //}
        //return super.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.649 -0400", hash_original_method = "32AB82048771397A8F2D1AACD6751885", hash_generated_method = "DA4339BD72CBF2A1BB41B8FD23BC631F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Permission getPermission() throws IOException {
        Permission var53B7CD91C6D6BB67990A718C9D6D8879_422557555 = (jarFileURLConnection.getPermission());
        return (Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return jarFileURLConnection.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.649 -0400", hash_original_method = "89E1132CC6620CB971998873757D9D18", hash_generated_method = "8B5D3FCB8CE81860AC54FCE59843EE15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getUseCaches() {
        boolean var24AD89541BD4FCF17459EB4AA48D1E1F_717027360 = (jarFileURLConnection.getUseCaches());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return jarFileURLConnection.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.649 -0400", hash_original_method = "B4491CDE2E10F000A5909671FFF7BF11", hash_generated_method = "658C07DC7A225E8B964C44FC002F82BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setUseCaches(boolean usecaches) {
        dsTaint.addTaint(usecaches);
        jarFileURLConnection.setUseCaches(usecaches);
        // ---------- Original Method ----------
        //jarFileURLConnection.setUseCaches(usecaches);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.650 -0400", hash_original_method = "E32A55AFDD8C878EAFF3633240EF835D", hash_generated_method = "B351B46FE7C8331B23AD759A04FB0B70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getDefaultUseCaches() {
        boolean varA32B484A43B8F81923B7FBB94AE29B5F_473605589 = (jarFileURLConnection.getDefaultUseCaches());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return jarFileURLConnection.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.651 -0400", hash_original_method = "9B53AD37225976042371B5DBF82602F6", hash_generated_method = "D57179000D6CDE7012D5111B3EF257AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDefaultUseCaches(boolean defaultusecaches) {
        dsTaint.addTaint(defaultusecaches);
        jarFileURLConnection.setDefaultUseCaches(defaultusecaches);
        // ---------- Original Method ----------
        //jarFileURLConnection.setDefaultUseCaches(defaultusecaches);
    }

    
        public static void closeCachedFiles() {
        Set<Map.Entry<URL, JarFile>> s = jarCache.entrySet();
        synchronized (jarCache) {
            Iterator<Map.Entry<URL, JarFile>> i = s.iterator();
            while (i.hasNext()) {
                try {
                    ZipFile zip = i.next().getValue();
                    if (zip != null) {
                        zip.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    
    private class JarURLConnectionInputStream extends FilterInputStream {
        JarFile jarFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.653 -0400", hash_original_method = "6E5813E713394C12219CB12B24913AED", hash_generated_method = "B6680EE1843A349F0C58AAA9D316D593")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected JarURLConnectionInputStream(InputStream in, JarFile file) {
            super(in);
            dsTaint.addTaint(file.dsTaint);
            dsTaint.addTaint(in.dsTaint);
            // ---------- Original Method ----------
            //jarFile = file;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.654 -0400", hash_original_method = "C19810B5404F297C56A9BC5E0816E19A", hash_generated_method = "10D32452CC9E983415DDE9E41CF51DB6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            super.close();
            {
                boolean var908365283E6AA49B16DF86C623F3001E_2019227111 = (!getUseCaches());
                {
                    closed = true;
                    jarFile.close();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //super.close();
            //if (!getUseCaches()) {
                //closed = true;
                //jarFile.close();
            //}
        }

        
    }


    
    static HashMap<URL, JarFile> jarCache = new HashMap<URL, JarFile>();
}

