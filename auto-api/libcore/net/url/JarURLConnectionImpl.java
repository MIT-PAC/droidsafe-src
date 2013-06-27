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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.235 -0400", hash_original_field = "7513C8779F857C1C660563D5E54D3D36", hash_generated_field = "07485ED06E2A407A7D38E89DF7EA433B")

    private URL jarFileURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.235 -0400", hash_original_field = "DDBC57471C69D842DAA229CFE3EAB08B", hash_generated_field = "2FDA65A94865AD8BD0FCF44E4CEE7E9C")

    private InputStream jarInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.235 -0400", hash_original_field = "29B8F3F088E7BAC9A2455C7D8BE5803D", hash_generated_field = "A1544DC796279D75E8EFE7D422D11F29")

    private JarFile jarFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.235 -0400", hash_original_field = "95B3778B54474AA489670F015A01BC7C", hash_generated_field = "AC8BC8520BF86140D134B22CF6FB9C16")

    private JarEntry jarEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.235 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "52C99699A476D9ED1506978946DA0E51")

    private boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.236 -0400", hash_original_method = "5F30611EBB0C16B95EA706518FA3E093", hash_generated_method = "4E3A6A1D10125B957F5C5FE6BCB0286B")
    public  JarURLConnectionImpl(URL url) throws MalformedURLException,
            IOException {
        super(url);
        jarFileURL = getJarFileURL();
        jarFileURLConnection = jarFileURL.openConnection();
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //jarFileURL = getJarFileURL();
        //jarFileURLConnection = jarFileURL.openConnection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.240 -0400", hash_original_method = "0D95FCCAA7871FCD5DE5E8081721F47B", hash_generated_method = "926B22BA5526EACA5468913246024D03")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.241 -0400", hash_original_method = "BAB8781FAD6151E9B45BF4A1B941497D", hash_generated_method = "4C5695EF72D9EA0D0CE5962B551E7813")
    @Override
    public JarFile getJarFile() throws IOException {
        JarFile varB4EAC82CA7396A68D541C85D26508E83_2017775674 = null; //Variable for return #1
        connect();
        varB4EAC82CA7396A68D541C85D26508E83_2017775674 = jarFile;
        varB4EAC82CA7396A68D541C85D26508E83_2017775674.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2017775674;
        // ---------- Original Method ----------
        //connect();
        //return jarFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.242 -0400", hash_original_method = "E0D7867F43E3325F58427586B81262FC", hash_generated_method = "AE7FAB96B4ECA8F2338270BA4CBB679B")
    private void findJarFile() throws IOException {
        JarFile jar;
        jar = null;
        {
            boolean var4488D7339955339089D556491FAB9F35_2053276819 = (getUseCaches());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.243 -0400", hash_original_method = "AF67425F611C6CCEA6B4F36EBE571AB2", hash_generated_method = "08237F533CBC31D9260BF1752C03C9E1")
     JarFile openJarFile() throws IOException {
        JarFile varB4EAC82CA7396A68D541C85D26508E83_103756259 = null; //Variable for return #1
        JarFile varB4EAC82CA7396A68D541C85D26508E83_1960831754 = null; //Variable for return #2
        JarFile varB4EAC82CA7396A68D541C85D26508E83_671900869 = null; //Variable for return #3
        JarFile varB4EAC82CA7396A68D541C85D26508E83_1222047105 = null; //Variable for return #4
        {
            boolean var4905B00C7F001BF20E914C34E673ABA2_181229583 = (jarFileURL.getProtocol().equals("file"));
            {
                String decodedFile;
                decodedFile = UriCodec.decode(jarFileURL.getFile());
                varB4EAC82CA7396A68D541C85D26508E83_103756259 = new JarFile(new File(decodedFile), true, ZipFile.OPEN_READ);
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
                            boolean var884A04FD9ADAFCF2F0817BF3B474DB07_1736902255 = ((nbytes = is.read(buf)) > -1);
                            {
                                fos.write(buf, 0, nbytes);
                            } //End block
                        } //End collapsed parenthetic
                        fos.close();
                        varB4EAC82CA7396A68D541C85D26508E83_1960831754 = new JarFile(tempJar, true, ZipFile.OPEN_READ | ZipFile.OPEN_DELETE);
                    } //End block
                    catch (IOException e)
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_671900869 = null;
                    } //End block
                    finally 
                    {
                        {
                            try 
                            {
                                fos.close();
                            } //End block
                            catch (IOException ex)
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1222047105 = null;
                            } //End block
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
        JarFile varA7E53CE21691AB073D9660D615818899_2031576882; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2031576882 = varB4EAC82CA7396A68D541C85D26508E83_103756259;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2031576882 = varB4EAC82CA7396A68D541C85D26508E83_1960831754;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2031576882 = varB4EAC82CA7396A68D541C85D26508E83_671900869;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2031576882 = varB4EAC82CA7396A68D541C85D26508E83_1222047105;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2031576882.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2031576882;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.255 -0400", hash_original_method = "4969FA075748EE67279B88C22279B5EB", hash_generated_method = "F9224207B7A2005E7EBD83CB4954800A")
    @Override
    public JarEntry getJarEntry() throws IOException {
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_826490527 = null; //Variable for return #1
        connect();
        varB4EAC82CA7396A68D541C85D26508E83_826490527 = jarEntry;
        varB4EAC82CA7396A68D541C85D26508E83_826490527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_826490527;
        // ---------- Original Method ----------
        //connect();
        //return jarEntry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.256 -0400", hash_original_method = "47E7331F0B55D0071578FE2F3BE66635", hash_generated_method = "589212D203F4D899C5BEC5BDE8B193B3")
    private void findJarEntry() throws IOException {
        {
            boolean varE49F2B7FF91F623F4C37CC04186E7780_203335152 = (getEntryName() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.256 -0400", hash_original_method = "96C498B69E21157D37D76B9902545F24", hash_generated_method = "E7B9E5175EFA9E81DDB5B9DD1EB56392")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1021755359 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1873656999 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("JarURLConnection InputStream has been closed");
        } //End block
        connect();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1021755359 = jarInput;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Jar entry not specified");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1873656999 = jarInput = new JarURLConnectionInputStream(jarFile
                .getInputStream(jarEntry), jarFile);
        InputStream varA7E53CE21691AB073D9660D615818899_2145995467; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2145995467 = varB4EAC82CA7396A68D541C85D26508E83_1021755359;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2145995467 = varB4EAC82CA7396A68D541C85D26508E83_1873656999;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2145995467.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2145995467;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.257 -0400", hash_original_method = "626D247225A5C5A729C002EF0C988C29", hash_generated_method = "C96E161168B2CA16F5D0F3E0C37BA4EB")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_84401322 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_358374905 = null; //Variable for return #2
        {
            boolean var5A4D7A486C11D5F49AB1CA63C5A4886E_809988622 = (url.getFile().endsWith("!/"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_84401322 = "x-java/jar";
            } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_358374905 = cType;
        String varA7E53CE21691AB073D9660D615818899_1511298115; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1511298115 = varB4EAC82CA7396A68D541C85D26508E83_84401322;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1511298115 = varB4EAC82CA7396A68D541C85D26508E83_358374905;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1511298115.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1511298115;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.272 -0400", hash_original_method = "C82FBA290AE26D875C8865E2241D6919", hash_generated_method = "E7C7D764A8177A5E1D70EB321B577D85")
    @Override
    public int getContentLength() {
        try 
        {
            connect();
            {
                int var1758F21177BADAC1F67FFD78824D606B_341640707 = (jarFileURLConnection.getContentLength());
            } //End block
            int var2BB2A25985BB5B3A4266161AB3B248B5_1472477985 = ((int) getJarEntry().getSize());
        } //End block
        catch (IOException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1377533289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1377533289;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.277 -0400", hash_original_method = "277EA8603145BCD9B1620E5B0867C76D", hash_generated_method = "C5F380EBB6B4077B5AB6BE48D17DCA3E")
    @Override
    public Object getContent() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_245441427 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_212297564 = null; //Variable for return #2
        connect();
        {
            varB4EAC82CA7396A68D541C85D26508E83_245441427 = jarFile;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_212297564 = super.getContent();
        Object varA7E53CE21691AB073D9660D615818899_564969563; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_564969563 = varB4EAC82CA7396A68D541C85D26508E83_245441427;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_564969563 = varB4EAC82CA7396A68D541C85D26508E83_212297564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_564969563.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_564969563;
        // ---------- Original Method ----------
        //connect();
        //if (jarEntry == null) {
            //return jarFile;
        //}
        //return super.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.278 -0400", hash_original_method = "32AB82048771397A8F2D1AACD6751885", hash_generated_method = "67EB00DC238481632094EAE3586554F7")
    @Override
    public Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_295908787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_295908787 = jarFileURLConnection.getPermission();
        varB4EAC82CA7396A68D541C85D26508E83_295908787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_295908787;
        // ---------- Original Method ----------
        //return jarFileURLConnection.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.279 -0400", hash_original_method = "89E1132CC6620CB971998873757D9D18", hash_generated_method = "DDF0A0E40CE1391455DF08D6DF050AD6")
    @Override
    public boolean getUseCaches() {
        boolean var24AD89541BD4FCF17459EB4AA48D1E1F_615753964 = (jarFileURLConnection.getUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984546988 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_984546988;
        // ---------- Original Method ----------
        //return jarFileURLConnection.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.279 -0400", hash_original_method = "B4491CDE2E10F000A5909671FFF7BF11", hash_generated_method = "9012379D981C6911267996B7CBEFE2D8")
    @Override
    public void setUseCaches(boolean usecaches) {
        jarFileURLConnection.setUseCaches(usecaches);
        addTaint(usecaches);
        // ---------- Original Method ----------
        //jarFileURLConnection.setUseCaches(usecaches);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.279 -0400", hash_original_method = "E32A55AFDD8C878EAFF3633240EF835D", hash_generated_method = "CD995114B253082FBF4F43B7B1816AFC")
    @Override
    public boolean getDefaultUseCaches() {
        boolean varA32B484A43B8F81923B7FBB94AE29B5F_331070166 = (jarFileURLConnection.getDefaultUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087637860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087637860;
        // ---------- Original Method ----------
        //return jarFileURLConnection.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.288 -0400", hash_original_method = "9B53AD37225976042371B5DBF82602F6", hash_generated_method = "E507CCE9B13C0BBB46BC63084E0088EB")
    @Override
    public void setDefaultUseCaches(boolean defaultusecaches) {
        jarFileURLConnection.setDefaultUseCaches(defaultusecaches);
        addTaint(defaultusecaches);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.288 -0400", hash_original_field = "29B8F3F088E7BAC9A2455C7D8BE5803D", hash_generated_field = "B339322987345D78E0B630D63AE8DAC1")

        JarFile jarFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.288 -0400", hash_original_method = "6E5813E713394C12219CB12B24913AED", hash_generated_method = "D6547B1D6BCBF7B7FDAC42A64ED30763")
        protected  JarURLConnectionInputStream(InputStream in, JarFile file) {
            super(in);
            jarFile = file;
            addTaint(in.getTaint());
            // ---------- Original Method ----------
            //jarFile = file;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.289 -0400", hash_original_method = "C19810B5404F297C56A9BC5E0816E19A", hash_generated_method = "1E95F1F66B47A6CD47B7F4EB538E09E0")
        @Override
        public void close() throws IOException {
            super.close();
            {
                boolean var908365283E6AA49B16DF86C623F3001E_609730348 = (!getUseCaches());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.289 -0400", hash_original_field = "4AD44567C61A0DAC8B86E875DE00C2F1", hash_generated_field = "DAFAEFD0112EA423D0DE3AF30FA2DDE9")

    static HashMap<URL, JarFile> jarCache = new HashMap<URL, JarFile>();
}

