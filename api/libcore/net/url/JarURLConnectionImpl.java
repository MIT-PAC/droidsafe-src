package libcore.net.url;

// Droidsafe Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class JarURLConnectionImpl extends JarURLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.356 -0400", hash_original_field = "7513C8779F857C1C660563D5E54D3D36", hash_generated_field = "07485ED06E2A407A7D38E89DF7EA433B")

    private URL jarFileURL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.356 -0400", hash_original_field = "DDBC57471C69D842DAA229CFE3EAB08B", hash_generated_field = "2FDA65A94865AD8BD0FCF44E4CEE7E9C")

    private InputStream jarInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.356 -0400", hash_original_field = "29B8F3F088E7BAC9A2455C7D8BE5803D", hash_generated_field = "A1544DC796279D75E8EFE7D422D11F29")

    private JarFile jarFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.356 -0400", hash_original_field = "95B3778B54474AA489670F015A01BC7C", hash_generated_field = "AC8BC8520BF86140D134B22CF6FB9C16")

    private JarEntry jarEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.357 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "52C99699A476D9ED1506978946DA0E51")

    private boolean closed;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.357 -0400", hash_original_method = "5F30611EBB0C16B95EA706518FA3E093", hash_generated_method = "9DDDBFF77E65873874F1A576049EEF40")
    public  JarURLConnectionImpl(URL url) throws MalformedURLException,
            IOException {
        super(url);
        addTaint(url.getTaint());
        jarFileURL = getJarFileURL();
        jarFileURLConnection = jarFileURL.openConnection();
        // ---------- Original Method ----------
        //jarFileURL = getJarFileURL();
        //jarFileURLConnection = jarFileURL.openConnection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.358 -0400", hash_original_method = "0D95FCCAA7871FCD5DE5E8081721F47B", hash_generated_method = "8B3D84B6AAE954FF50A9F78D86E66D39")
    @Override
    public void connect() throws IOException {
        if(!connected)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.358 -0400", hash_original_method = "BAB8781FAD6151E9B45BF4A1B941497D", hash_generated_method = "091AD63394C4F972EE7157A6ED10F164")
    @Override
    public JarFile getJarFile() throws IOException {
        connect();
JarFile var8E1F414344626BA4FB59E50115387315_2102347690 =         jarFile;
        var8E1F414344626BA4FB59E50115387315_2102347690.addTaint(taint);
        return var8E1F414344626BA4FB59E50115387315_2102347690;
        // ---------- Original Method ----------
        //connect();
        //return jarFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.359 -0400", hash_original_method = "E0D7867F43E3325F58427586B81262FC", hash_generated_method = "17CECF61D0E9A3E8901B06FA680C7162")
    private void findJarFile() throws IOException {
        JarFile jar = null;
        if(getUseCaches())        
        {
            synchronized
(jarCache)            {
                jarFile = jarCache.get(jarFileURL);
            } //End block
            if(jarFile == null)            
            {
                jar = openJarFile();
                synchronized
(jarCache)                {
                    jarFile = jarCache.get(jarFileURL);
                    if(jarFile == null)                    
                    {
                        jarCache.put(jarFileURL, jar);
                        jarFile = jar;
                    } //End block
                    else
                    {
                        jar.close();
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        {
            jarFile = openJarFile();
        } //End block
        if(jarFile == null)        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_872359629 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_872359629.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_872359629;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.360 -0400", hash_original_method = "AF67425F611C6CCEA6B4F36EBE571AB2", hash_generated_method = "BFC51FBB5F2E612B75CB26B4967A9A86")
     JarFile openJarFile() throws IOException {
        if(jarFileURL.getProtocol().equals("file"))        
        {
            String decodedFile = UriCodec.decode(jarFileURL.getFile());
JarFile var60CBEDF93F3F084D3E758164F022ECD0_1953182269 =             new JarFile(new File(decodedFile), true, ZipFile.OPEN_READ);
            var60CBEDF93F3F084D3E758164F022ECD0_1953182269.addTaint(taint);
            return var60CBEDF93F3F084D3E758164F022ECD0_1953182269;
        } //End block
        else
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
                    while
((nbytes = is.read(buf)) > -1)                    
                    {
                        fos.write(buf, 0, nbytes);
                    } //End block
                    fos.close();
JarFile varD5C2CCA69C95AF526785A0BF2E1F0B8E_1798575203 =                     new JarFile(tempJar, true, ZipFile.OPEN_READ | ZipFile.OPEN_DELETE);
                    varD5C2CCA69C95AF526785A0BF2E1F0B8E_1798575203.addTaint(taint);
                    return varD5C2CCA69C95AF526785A0BF2E1F0B8E_1798575203;
                } //End block
                catch (IOException e)
                {
JarFile var540C13E9E156B687226421B24F2DF178_352927375 =                     null;
                    var540C13E9E156B687226421B24F2DF178_352927375.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_352927375;
                } //End block
                finally 
                {
                    if(fos != null)                    
                    {
                        try 
                        {
                            fos.close();
                        } //End block
                        catch (IOException ex)
                        {
JarFile var540C13E9E156B687226421B24F2DF178_269575024 =                             null;
                            var540C13E9E156B687226421B24F2DF178_269575024.addTaint(taint);
                            return var540C13E9E156B687226421B24F2DF178_269575024;
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
                if(is != null)                
                {
                    is.close();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.361 -0400", hash_original_method = "4969FA075748EE67279B88C22279B5EB", hash_generated_method = "C82C8068FF6B44F3345965F94B9E7DA9")
    @Override
    public JarEntry getJarEntry() throws IOException {
        connect();
JarEntry varAD3A77394289B6D52417AADF8827369A_1717278875 =         jarEntry;
        varAD3A77394289B6D52417AADF8827369A_1717278875.addTaint(taint);
        return varAD3A77394289B6D52417AADF8827369A_1717278875;
        // ---------- Original Method ----------
        //connect();
        //return jarEntry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.362 -0400", hash_original_method = "47E7331F0B55D0071578FE2F3BE66635", hash_generated_method = "E465B88CFA3B12B90F70837AC3543A89")
    private void findJarEntry() throws IOException {
        if(getEntryName() == null)        
        {
            return;
        } //End block
        jarEntry = jarFile.getJarEntry(getEntryName());
        if(jarEntry == null)        
        {
            FileNotFoundException varE9EBD5111E02D6931B6EC88CCE7B02C4_1173302968 = new FileNotFoundException(getEntryName());
            varE9EBD5111E02D6931B6EC88CCE7B02C4_1173302968.addTaint(taint);
            throw varE9EBD5111E02D6931B6EC88CCE7B02C4_1173302968;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.363 -0400", hash_original_method = "96C498B69E21157D37D76B9902545F24", hash_generated_method = "94E1E630EB7534EB9A0C26F34E4FD15D")
    @Override
    public InputStream getInputStream() throws IOException {
        if(closed)        
        {
            IllegalStateException var8C57BC4CCCB8C46C370EC2051897113D_734016489 = new IllegalStateException("JarURLConnection InputStream has been closed");
            var8C57BC4CCCB8C46C370EC2051897113D_734016489.addTaint(taint);
            throw var8C57BC4CCCB8C46C370EC2051897113D_734016489;
        } //End block
        connect();
        if(jarInput != null)        
        {
InputStream varAA75B6884B588FE6E78A9C056B314C4E_1424839498 =             jarInput;
            varAA75B6884B588FE6E78A9C056B314C4E_1424839498.addTaint(taint);
            return varAA75B6884B588FE6E78A9C056B314C4E_1424839498;
        } //End block
        if(jarEntry == null)        
        {
            IOException varC4D3A291675ADD4532ED1A1E739EEEBF_117168438 = new IOException("Jar entry not specified");
            varC4D3A291675ADD4532ED1A1E739EEEBF_117168438.addTaint(taint);
            throw varC4D3A291675ADD4532ED1A1E739EEEBF_117168438;
        } //End block
InputStream var633EF97C7E21EA794417A3B390707D41_1881543837 =         jarInput = new JarURLConnectionInputStream(jarFile
                .getInputStream(jarEntry), jarFile);
        var633EF97C7E21EA794417A3B390707D41_1881543837.addTaint(taint);
        return var633EF97C7E21EA794417A3B390707D41_1881543837;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.363 -0400", hash_original_method = "626D247225A5C5A729C002EF0C988C29", hash_generated_method = "2E3C57964D38F1FB6D353C04C9AAD776")
    @Override
    public String getContentType() {
        if(url.getFile().endsWith("!/"))        
        {
String varD3FF7AB088AF6C94102389F4B8998E56_1539293928 =             "x-java/jar";
            varD3FF7AB088AF6C94102389F4B8998E56_1539293928.addTaint(taint);
            return varD3FF7AB088AF6C94102389F4B8998E56_1539293928;
        } //End block
        String cType = null;
        String entryName = getEntryName();
        if(entryName != null)        
        {
            cType = guessContentTypeFromName(entryName);
        } //End block
        else
        {
            try 
            {
                connect();
                cType = jarFileURLConnection.getContentType();
            } //End block
            catch (IOException ioe)
            {
            } //End block
        } //End block
        if(cType == null)        
        {
            cType = "content/unknown";
        } //End block
String var09A62FBC65BE187AFF76DDFD23EE82F2_502952705 =         cType;
        var09A62FBC65BE187AFF76DDFD23EE82F2_502952705.addTaint(taint);
        return var09A62FBC65BE187AFF76DDFD23EE82F2_502952705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.364 -0400", hash_original_method = "C82FBA290AE26D875C8865E2241D6919", hash_generated_method = "B6BBD3925655AF337A063C7BEA687C1D")
    @Override
    public int getContentLength() {
        try 
        {
            connect();
            if(jarEntry == null)            
            {
                int var8BA33FEA49B7A860D11101013AE858F6_1709371301 = (jarFileURLConnection.getContentLength());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769110301 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769110301;
            } //End block
            int var856AFBFC5554D4B0FB3082D671166F0B_713277009 = ((int) getJarEntry().getSize());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991381860 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991381860;
        } //End block
        catch (IOException e)
        {
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1679727601 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897678469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897678469;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.365 -0400", hash_original_method = "277EA8603145BCD9B1620E5B0867C76D", hash_generated_method = "90247A2BF8F68398E6E91E6EAA0BB576")
    @Override
    public Object getContent() throws IOException {
        connect();
        if(jarEntry == null)        
        {
Object var8E1F414344626BA4FB59E50115387315_2123509874 =             jarFile;
            var8E1F414344626BA4FB59E50115387315_2123509874.addTaint(taint);
            return var8E1F414344626BA4FB59E50115387315_2123509874;
        } //End block
Object varB48A5BF7E69A931886E4CE799B44A3F6_905580853 =         super.getContent();
        varB48A5BF7E69A931886E4CE799B44A3F6_905580853.addTaint(taint);
        return varB48A5BF7E69A931886E4CE799B44A3F6_905580853;
        // ---------- Original Method ----------
        //connect();
        //if (jarEntry == null) {
            //return jarFile;
        //}
        //return super.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.365 -0400", hash_original_method = "32AB82048771397A8F2D1AACD6751885", hash_generated_method = "83CD3FF6631B34F3FD173518B33C6E31")
    @Override
    public Permission getPermission() throws IOException {
Permission var07D66FDEC9384D2F09F1D7451056F3DA_137890211 =         jarFileURLConnection.getPermission();
        var07D66FDEC9384D2F09F1D7451056F3DA_137890211.addTaint(taint);
        return var07D66FDEC9384D2F09F1D7451056F3DA_137890211;
        // ---------- Original Method ----------
        //return jarFileURLConnection.getPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.366 -0400", hash_original_method = "89E1132CC6620CB971998873757D9D18", hash_generated_method = "363CF346BB5C035540B4D884B280422C")
    @Override
    public boolean getUseCaches() {
        boolean var55EFAAC5B6D81843C363E6B7A62F01CA_2017758840 = (jarFileURLConnection.getUseCaches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574198098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_574198098;
        // ---------- Original Method ----------
        //return jarFileURLConnection.getUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.366 -0400", hash_original_method = "B4491CDE2E10F000A5909671FFF7BF11", hash_generated_method = "47EBBDD6105628C32D0FE97394DD9E8F")
    @Override
    public void setUseCaches(boolean usecaches) {
        addTaint(usecaches);
        jarFileURLConnection.setUseCaches(usecaches);
        // ---------- Original Method ----------
        //jarFileURLConnection.setUseCaches(usecaches);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.366 -0400", hash_original_method = "E32A55AFDD8C878EAFF3633240EF835D", hash_generated_method = "FA3D3489E7FFBD99F00E723273352026")
    @Override
    public boolean getDefaultUseCaches() {
        boolean var056150D29F12DE292B68008CAFA7BCC7_661790539 = (jarFileURLConnection.getDefaultUseCaches());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376394425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376394425;
        // ---------- Original Method ----------
        //return jarFileURLConnection.getDefaultUseCaches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.366 -0400", hash_original_method = "9B53AD37225976042371B5DBF82602F6", hash_generated_method = "4C84D93F472CED094086033658EC15C2")
    @Override
    public void setDefaultUseCaches(boolean defaultusecaches) {
        addTaint(defaultusecaches);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.367 -0400", hash_original_field = "29B8F3F088E7BAC9A2455C7D8BE5803D", hash_generated_field = "B339322987345D78E0B630D63AE8DAC1")

        JarFile jarFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.367 -0400", hash_original_method = "6E5813E713394C12219CB12B24913AED", hash_generated_method = "E125CDB3DA807FC148E23519EBBE4EF5")
        protected  JarURLConnectionInputStream(InputStream in, JarFile file) {
            super(in);
            addTaint(in.getTaint());
            jarFile = file;
            // ---------- Original Method ----------
            //jarFile = file;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.367 -0400", hash_original_method = "C19810B5404F297C56A9BC5E0816E19A", hash_generated_method = "710260A35875A7F3968A128DDA4A88CC")
        @Override
        public void close() throws IOException {
            super.close();
            if(!getUseCaches())            
            {
                closed = true;
                jarFile.close();
            } //End block
            // ---------- Original Method ----------
            //super.close();
            //if (!getUseCaches()) {
                //closed = true;
                //jarFile.close();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.367 -0400", hash_original_field = "4AD44567C61A0DAC8B86E875DE00C2F1", hash_generated_field = "DAFAEFD0112EA423D0DE3AF30FA2DDE9")

    static HashMap<URL, JarFile> jarCache = new HashMap<URL, JarFile>();
}

