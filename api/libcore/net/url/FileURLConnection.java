package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import libcore.net.UriCodec;

public class FileURLConnection extends URLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.769 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.769 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.769 -0400", hash_original_field = "37DD3CB77D31BF2E80399C3B748B5F16", hash_generated_field = "99508BAC072434E4BF52703BB1174C03")

    private int length = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.769 -0400", hash_original_field = "F0F18990052D31406E964D776FD3A36D", hash_generated_field = "3949ABAC0B1DE58EC6BD730E294BB79C")

    private boolean isDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.769 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "96BA6FFE95348C93D489804764910CBE")

    private FilePermission permission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.770 -0400", hash_original_method = "ECDCE15AD3E40A66FECAA373F1AD69DD", hash_generated_method = "7CCDA583CEB42F317B5916AC796DE1FC")
    public  FileURLConnection(URL url) {
        super(url);
        fileName = url.getFile();
        {
            fileName = "";
        } 
        fileName = UriCodec.decode(fileName);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.770 -0400", hash_original_method = "9A475DD1FCE4CCB36A5D73E904D3A34C", hash_generated_method = "33E037FF51E9225151900B00DA00ECEE")
    @Override
    public void connect() throws IOException {
        File f = new File(fileName);
        {
            boolean varA97259D5C3642C5738EE6A4F81981B2D_1119087268 = (f.isDirectory());
            {
                isDir = true;
                is = getDirectoryListing(f);
            } 
            {
                is = new BufferedInputStream(new FileInputStream(f));
                long lengthAsLong = f.length();
                length = lengthAsLong <= Integer.MAX_VALUE ? (int) lengthAsLong : Integer.MAX_VALUE;
            } 
        } 
        connected = true;
        
        
        
            
            
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.771 -0400", hash_original_method = "686027F78C1D594BA8DD041F116549D4", hash_generated_method = "D79CC2478400793CB54F8B25CA41AB97")
    @Override
    public int getContentLength() {
        try 
        {
            {
                connect();
            } 
        } 
        catch (IOException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864837242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864837242;
        
        
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.772 -0400", hash_original_method = "72F889733CD7FE79958D9F6D8BD5D3FB", hash_generated_method = "4443B1D97B6AAB84E5BB35AFF43852DF")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1523249766 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1493968849 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_722681855 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_174325348 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1489478974 = null; 
        try 
        {
            {
                connect();
            } 
        } 
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1523249766 = "content/unknown";
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1493968849 = "text/plain";
        } 
        String result = guessContentTypeFromName(url.getFile());
        {
            varB4EAC82CA7396A68D541C85D26508E83_722681855 = result;
        } 
        try 
        {
            result = guessContentTypeFromStream(is);
        } 
        catch (IOException e)
        { }
        {
            varB4EAC82CA7396A68D541C85D26508E83_174325348 = result;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1489478974 = "content/unknown";
        String varA7E53CE21691AB073D9660D615818899_1023553544; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1023553544 = varB4EAC82CA7396A68D541C85D26508E83_1523249766;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1023553544 = varB4EAC82CA7396A68D541C85D26508E83_1493968849;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1023553544 = varB4EAC82CA7396A68D541C85D26508E83_722681855;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1023553544 = varB4EAC82CA7396A68D541C85D26508E83_174325348;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1023553544 = varB4EAC82CA7396A68D541C85D26508E83_1489478974;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1023553544.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1023553544;
        
        
            
                
            
        
            
        
        
            
        
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.773 -0400", hash_original_method = "D31BC01A8E6F1896A7501EEF99417267", hash_generated_method = "B4DD039AF4FD1438EE7107433A595A86")
    private InputStream getDirectoryListing(File f) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1272142285 = null; 
        String fileList[] = f.list();
        ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        out.print("<title>Directory Listing</title>\n");
        out.print("<base href=\"file:");
        out.print(f.getPath().replace('\\', '/') + "/\"><h1>" + f.getPath()
                + "</h1>\n<hr>\n");
        int i;
        {
            i = 0;
            {
                out.print(fileList[i] + "<br>\n");
            } 
        } 
        out.close();
        varB4EAC82CA7396A68D541C85D26508E83_1272142285 = new ByteArrayInputStream(bytes.toByteArray());
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1272142285.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1272142285;
        
        
        
        
        
        
        
                
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.774 -0400", hash_original_method = "632E8A34CACC91F3F004CEC65E6938CD", hash_generated_method = "CC88EB2AED828A4BFFA87DE9D0DEAFB2")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1189180926 = null; 
        {
            connect();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1189180926 = is;
        varB4EAC82CA7396A68D541C85D26508E83_1189180926.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1189180926;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.775 -0400", hash_original_method = "FD3C5E750D9B5BE3AE6CD98B1BC8C55C", hash_generated_method = "28CA34768200A1F84E30954A7BCCCD78")
    @Override
    public java.security.Permission getPermission() throws IOException {
        java.security.Permission varB4EAC82CA7396A68D541C85D26508E83_1676714503 = null; 
        {
            String path = fileName;
            {
                path = path.replace('/', File.separatorChar);
            } 
            permission = new FilePermission(path, "read");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1676714503 = permission;
        varB4EAC82CA7396A68D541C85D26508E83_1676714503.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1676714503;
        
        
            
            
                
            
            
        
        
    }

    
}

