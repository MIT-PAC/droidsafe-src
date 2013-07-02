package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.923 -0400", hash_original_field = "7513C8779F857C1C660563D5E54D3D36", hash_generated_field = "07485ED06E2A407A7D38E89DF7EA433B")

    private URL jarFileURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.923 -0400", hash_original_field = "DDBC57471C69D842DAA229CFE3EAB08B", hash_generated_field = "2FDA65A94865AD8BD0FCF44E4CEE7E9C")

    private InputStream jarInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.923 -0400", hash_original_field = "29B8F3F088E7BAC9A2455C7D8BE5803D", hash_generated_field = "A1544DC796279D75E8EFE7D422D11F29")

    private JarFile jarFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.923 -0400", hash_original_field = "95B3778B54474AA489670F015A01BC7C", hash_generated_field = "AC8BC8520BF86140D134B22CF6FB9C16")

    private JarEntry jarEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.923 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "52C99699A476D9ED1506978946DA0E51")

    private boolean closed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.923 -0400", hash_original_method = "5F30611EBB0C16B95EA706518FA3E093", hash_generated_method = "4E3A6A1D10125B957F5C5FE6BCB0286B")
    public  JarURLConnectionImpl(URL url) throws MalformedURLException,
            IOException {
        super(url);
        jarFileURL = getJarFileURL();
        jarFileURLConnection = jarFileURL.openConnection();
        addTaint(url.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.924 -0400", hash_original_method = "0D95FCCAA7871FCD5DE5E8081721F47B", hash_generated_method = "926B22BA5526EACA5468913246024D03")
    @Override
    public void connect() throws IOException {
        {
            findJarFile();
            findJarEntry();
            connected = true;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.924 -0400", hash_original_method = "BAB8781FAD6151E9B45BF4A1B941497D", hash_generated_method = "E91088E2D6837BFEB6505BD26F8FF4AE")
    @Override
    public JarFile getJarFile() throws IOException {
        JarFile varB4EAC82CA7396A68D541C85D26508E83_600736004 = null; 
        connect();
        varB4EAC82CA7396A68D541C85D26508E83_600736004 = jarFile;
        varB4EAC82CA7396A68D541C85D26508E83_600736004.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_600736004;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.924 -0400", hash_original_method = "E0D7867F43E3325F58427586B81262FC", hash_generated_method = "6D2CF7B2A40F9FA8830B02F6B1E91F5A")
    private void findJarFile() throws IOException {
        JarFile jar = null;
        {
            boolean var4488D7339955339089D556491FAB9F35_986260002 = (getUseCaches());
            {
                {
                    jarFile = jarCache.get(jarFileURL);
                } 
                {
                    jar = openJarFile();
                    {
                        jarFile = jarCache.get(jarFileURL);
                        {
                            jarCache.put(jarFileURL, jar);
                            jarFile = jar;
                        } 
                        {
                            jar.close();
                        } 
                    } 
                } 
            } 
            {
                jarFile = openJarFile();
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } 
        
        
        
            
                
            
            
                
                
                    
                    
                        
                        
                    
                        
                    
                
            
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.926 -0400", hash_original_method = "AF67425F611C6CCEA6B4F36EBE571AB2", hash_generated_method = "658AB3E2E016A25E36C69F5DB63746F9")
     JarFile openJarFile() throws IOException {
        JarFile varB4EAC82CA7396A68D541C85D26508E83_2076210258 = null; 
        JarFile varB4EAC82CA7396A68D541C85D26508E83_2117681865 = null; 
        JarFile varB4EAC82CA7396A68D541C85D26508E83_1596736629 = null; 
        JarFile varB4EAC82CA7396A68D541C85D26508E83_366283455 = null; 
        {
            boolean var4905B00C7F001BF20E914C34E673ABA2_1098527829 = (jarFileURL.getProtocol().equals("file"));
            {
                String decodedFile = UriCodec.decode(jarFileURL.getFile());
                varB4EAC82CA7396A68D541C85D26508E83_2076210258 = new JarFile(new File(decodedFile), true, ZipFile.OPEN_READ);
            } 
            {
                final InputStream is = jarFileURL.openConnection().getInputStream();
                try 
                {
                    FileOutputStream fos = null;
                    JarFile result = null;
                    try 
                    {
                        File tempJar = File.createTempFile("hyjar_", ".tmp", null);
                        tempJar.deleteOnExit();
                        fos = new FileOutputStream(tempJar);
                        byte[] buf = new byte[4096];
                        int nbytes = 0;
                        {
                            boolean var884A04FD9ADAFCF2F0817BF3B474DB07_205704305 = ((nbytes = is.read(buf)) > -1);
                            {
                                fos.write(buf, 0, nbytes);
                            } 
                        } 
                        fos.close();
                        varB4EAC82CA7396A68D541C85D26508E83_2117681865 = new JarFile(tempJar, true, ZipFile.OPEN_READ | ZipFile.OPEN_DELETE);
                    } 
                    catch (IOException e)
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1596736629 = null;
                    } 
                    finally 
                    {
                        {
                            try 
                            {
                                fos.close();
                            } 
                            catch (IOException ex)
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_366283455 = null;
                            } 
                        } 
                    } 
                } 
                finally 
                {
                    {
                        is.close();
                    } 
                } 
            } 
        } 
        JarFile varA7E53CE21691AB073D9660D615818899_1909037744; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1909037744 = varB4EAC82CA7396A68D541C85D26508E83_2076210258;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1909037744 = varB4EAC82CA7396A68D541C85D26508E83_2117681865;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1909037744 = varB4EAC82CA7396A68D541C85D26508E83_1596736629;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1909037744 = varB4EAC82CA7396A68D541C85D26508E83_366283455;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1909037744.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1909037744;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.926 -0400", hash_original_method = "4969FA075748EE67279B88C22279B5EB", hash_generated_method = "7FA758A2E4BF01A52539432A0C3E7344")
    @Override
    public JarEntry getJarEntry() throws IOException {
        JarEntry varB4EAC82CA7396A68D541C85D26508E83_1264151094 = null; 
        connect();
        varB4EAC82CA7396A68D541C85D26508E83_1264151094 = jarEntry;
        varB4EAC82CA7396A68D541C85D26508E83_1264151094.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1264151094;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.927 -0400", hash_original_method = "47E7331F0B55D0071578FE2F3BE66635", hash_generated_method = "AD9A49F16BB7D1DC7D5051AE68590071")
    private void findJarEntry() throws IOException {
        {
            boolean varE49F2B7FF91F623F4C37CC04186E7780_917859429 = (getEntryName() == null);
        } 
        jarEntry = jarFile.getJarEntry(getEntryName());
        {
            if (DroidSafeAndroidRuntime.control) throw new FileNotFoundException(getEntryName());
        } 
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.927 -0400", hash_original_method = "96C498B69E21157D37D76B9902545F24", hash_generated_method = "0650C2C1CC5918DED9C91348BA60D256")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_627025502 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_720852489 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("JarURLConnection InputStream has been closed");
        } 
        connect();
        {
            varB4EAC82CA7396A68D541C85D26508E83_627025502 = jarInput;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Jar entry not specified");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_720852489 = jarInput = new JarURLConnectionInputStream(jarFile
                .getInputStream(jarEntry), jarFile);
        InputStream varA7E53CE21691AB073D9660D615818899_1525063783; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1525063783 = varB4EAC82CA7396A68D541C85D26508E83_627025502;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1525063783 = varB4EAC82CA7396A68D541C85D26508E83_720852489;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1525063783.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1525063783;
        
        
            
        
        
        
            
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.928 -0400", hash_original_method = "626D247225A5C5A729C002EF0C988C29", hash_generated_method = "044D283BF7EE1C54E8E8C08C0820973B")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_102510648 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_459145972 = null; 
        {
            boolean var5A4D7A486C11D5F49AB1CA63C5A4886E_1412531606 = (url.getFile().endsWith("!/"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_102510648 = "x-java/jar";
            } 
        } 
        String cType = null;
        String entryName = getEntryName();
        {
            cType = guessContentTypeFromName(entryName);
        } 
        {
            try 
            {
                connect();
                cType = jarFileURLConnection.getContentType();
            } 
            catch (IOException ioe)
            { }
        } 
        {
            cType = "content/unknown";
        } 
        varB4EAC82CA7396A68D541C85D26508E83_459145972 = cType;
        String varA7E53CE21691AB073D9660D615818899_1752693537; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1752693537 = varB4EAC82CA7396A68D541C85D26508E83_102510648;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1752693537 = varB4EAC82CA7396A68D541C85D26508E83_459145972;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1752693537.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1752693537;
        
        
            
        
        
        
        
            
        
            
                
                
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.928 -0400", hash_original_method = "C82FBA290AE26D875C8865E2241D6919", hash_generated_method = "9D640E82446EC3E199474A0F534EB357")
    @Override
    public int getContentLength() {
        try 
        {
            connect();
            {
                int var1758F21177BADAC1F67FFD78824D606B_297464002 = (jarFileURLConnection.getContentLength());
            } 
            int var2BB2A25985BB5B3A4266161AB3B248B5_28608162 = ((int) getJarEntry().getSize());
        } 
        catch (IOException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593346350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593346350;
        
        
            
            
                
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.929 -0400", hash_original_method = "277EA8603145BCD9B1620E5B0867C76D", hash_generated_method = "709E8360FBDA21E82808083C9CEB4A24")
    @Override
    public Object getContent() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1363328224 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1195041943 = null; 
        connect();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1363328224 = jarFile;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1195041943 = super.getContent();
        Object varA7E53CE21691AB073D9660D615818899_389889130; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_389889130 = varB4EAC82CA7396A68D541C85D26508E83_1363328224;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_389889130 = varB4EAC82CA7396A68D541C85D26508E83_1195041943;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_389889130.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_389889130;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.929 -0400", hash_original_method = "32AB82048771397A8F2D1AACD6751885", hash_generated_method = "99883F8D9F8579BC2BFD28A504C87F8E")
    @Override
    public Permission getPermission() throws IOException {
        Permission varB4EAC82CA7396A68D541C85D26508E83_1506361939 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1506361939 = jarFileURLConnection.getPermission();
        varB4EAC82CA7396A68D541C85D26508E83_1506361939.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1506361939;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.930 -0400", hash_original_method = "89E1132CC6620CB971998873757D9D18", hash_generated_method = "6BE221698FE156C3003BFB249BE22228")
    @Override
    public boolean getUseCaches() {
        boolean var24AD89541BD4FCF17459EB4AA48D1E1F_128133922 = (jarFileURLConnection.getUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174934836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174934836;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.930 -0400", hash_original_method = "B4491CDE2E10F000A5909671FFF7BF11", hash_generated_method = "9012379D981C6911267996B7CBEFE2D8")
    @Override
    public void setUseCaches(boolean usecaches) {
        jarFileURLConnection.setUseCaches(usecaches);
        addTaint(usecaches);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.930 -0400", hash_original_method = "E32A55AFDD8C878EAFF3633240EF835D", hash_generated_method = "10EDF3D28EE7FEE990778CCE25CD1042")
    @Override
    public boolean getDefaultUseCaches() {
        boolean varA32B484A43B8F81923B7FBB94AE29B5F_2063103697 = (jarFileURLConnection.getDefaultUseCaches());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120510226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120510226;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.931 -0400", hash_original_method = "9B53AD37225976042371B5DBF82602F6", hash_generated_method = "E507CCE9B13C0BBB46BC63084E0088EB")
    @Override
    public void setDefaultUseCaches(boolean defaultusecaches) {
        jarFileURLConnection.setDefaultUseCaches(defaultusecaches);
        addTaint(defaultusecaches);
        
        
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.931 -0400", hash_original_field = "29B8F3F088E7BAC9A2455C7D8BE5803D", hash_generated_field = "B339322987345D78E0B630D63AE8DAC1")

        JarFile jarFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.931 -0400", hash_original_method = "6E5813E713394C12219CB12B24913AED", hash_generated_method = "D6547B1D6BCBF7B7FDAC42A64ED30763")
        protected  JarURLConnectionInputStream(InputStream in, JarFile file) {
            super(in);
            jarFile = file;
            addTaint(in.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.932 -0400", hash_original_method = "C19810B5404F297C56A9BC5E0816E19A", hash_generated_method = "3AC0AD26868835DD58CF4742EC9A82C2")
        @Override
        public void close() throws IOException {
            super.close();
            {
                boolean var908365283E6AA49B16DF86C623F3001E_2115967076 = (!getUseCaches());
                {
                    closed = true;
                    jarFile.close();
                } 
            } 
            
            
            
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.932 -0400", hash_original_field = "4AD44567C61A0DAC8B86E875DE00C2F1", hash_generated_field = "DAFAEFD0112EA423D0DE3AF30FA2DDE9")

    static HashMap<URL, JarFile> jarCache = new HashMap<URL, JarFile>();
}

