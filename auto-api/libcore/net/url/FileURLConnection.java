package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.810 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.810 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.810 -0400", hash_original_field = "37DD3CB77D31BF2E80399C3B748B5F16", hash_generated_field = "99508BAC072434E4BF52703BB1174C03")

    private int length = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.810 -0400", hash_original_field = "F0F18990052D31406E964D776FD3A36D", hash_generated_field = "3949ABAC0B1DE58EC6BD730E294BB79C")

    private boolean isDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.810 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "96BA6FFE95348C93D489804764910CBE")

    private FilePermission permission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.811 -0400", hash_original_method = "ECDCE15AD3E40A66FECAA373F1AD69DD", hash_generated_method = "7CCDA583CEB42F317B5916AC796DE1FC")
    public  FileURLConnection(URL url) {
        super(url);
        fileName = url.getFile();
        {
            fileName = "";
        } //End block
        fileName = UriCodec.decode(fileName);
        // ---------- Original Method ----------
        //fileName = url.getFile();
        //if (fileName == null) {
            //fileName = "";
        //}
        //fileName = UriCodec.decode(fileName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.812 -0400", hash_original_method = "9A475DD1FCE4CCB36A5D73E904D3A34C", hash_generated_method = "A2A6E1EE6597A2FC0939A244831CC122")
    @Override
    public void connect() throws IOException {
        File f;
        f = new File(fileName);
        {
            boolean varA97259D5C3642C5738EE6A4F81981B2D_441363977 = (f.isDirectory());
            {
                isDir = true;
                is = getDirectoryListing(f);
            } //End block
            {
                is = new BufferedInputStream(new FileInputStream(f));
                long lengthAsLong;
                lengthAsLong = f.length();
                length = lengthAsLong <= Integer.MAX_VALUE ? (int) lengthAsLong : Integer.MAX_VALUE;
            } //End block
        } //End collapsed parenthetic
        connected = true;
        // ---------- Original Method ----------
        //File f = new File(fileName);
        //if (f.isDirectory()) {
            //isDir = true;
            //is = getDirectoryListing(f);
        //} else {
            //is = new BufferedInputStream(new FileInputStream(f));
            //long lengthAsLong = f.length();
            //length = lengthAsLong <= Integer.MAX_VALUE ? (int) lengthAsLong : Integer.MAX_VALUE;
        //}
        //connected = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.822 -0400", hash_original_method = "686027F78C1D594BA8DD041F116549D4", hash_generated_method = "ABE160359B597EF218EE94B657C22741")
    @Override
    public int getContentLength() {
        try 
        {
            {
                connect();
            } //End block
        } //End block
        catch (IOException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57411987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57411987;
        // ---------- Original Method ----------
        //try {
            //if (!connected) {
                //connect();
            //}
        //} catch (IOException e) {
        //}
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.823 -0400", hash_original_method = "72F889733CD7FE79958D9F6D8BD5D3FB", hash_generated_method = "E092D8758C8861BE56E7067F105C5ADB")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_228140220 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1886046013 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1001334723 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_419019500 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_2022154744 = null; //Variable for return #5
        try 
        {
            {
                connect();
            } //End block
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_228140220 = "content/unknown";
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1886046013 = "text/plain";
        } //End block
        String result;
        result = guessContentTypeFromName(url.getFile());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1001334723 = result;
        } //End block
        try 
        {
            result = guessContentTypeFromStream(is);
        } //End block
        catch (IOException e)
        { }
        {
            varB4EAC82CA7396A68D541C85D26508E83_419019500 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2022154744 = "content/unknown";
        String varA7E53CE21691AB073D9660D615818899_1731261640; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1731261640 = varB4EAC82CA7396A68D541C85D26508E83_228140220;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1731261640 = varB4EAC82CA7396A68D541C85D26508E83_1886046013;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1731261640 = varB4EAC82CA7396A68D541C85D26508E83_1001334723;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1731261640 = varB4EAC82CA7396A68D541C85D26508E83_419019500;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1731261640 = varB4EAC82CA7396A68D541C85D26508E83_2022154744;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1731261640.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1731261640;
        // ---------- Original Method ----------
        //try {
            //if (!connected) {
                //connect();
            //}
        //} catch (IOException e) {
            //return "content/unknown";
        //}
        //if (isDir) {
            //return "text/plain";
        //}
        //String result = guessContentTypeFromName(url.getFile());
        //if (result != null) {
            //return result;
        //}
        //try {
            //result = guessContentTypeFromStream(is);
        //} catch (IOException e) {
        //}
        //if (result != null) {
            //return result;
        //}
        //return "content/unknown";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.837 -0400", hash_original_method = "D31BC01A8E6F1896A7501EEF99417267", hash_generated_method = "FA34A67E1BD6BABC074F81E06977559A")
    private InputStream getDirectoryListing(File f) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1793168033 = null; //Variable for return #1
        String fileList[];
        fileList = f.list();
        ByteArrayOutputStream bytes;
        bytes = new java.io.ByteArrayOutputStream();
        PrintStream out;
        out = new PrintStream(bytes);
        out.print("<title>Directory Listing</title>\n");
        out.print("<base href=\"file:");
        out.print(f.getPath().replace('\\', '/') + "/\"><h1>" + f.getPath()
                + "</h1>\n<hr>\n");
        int i;
        {
            i = 0;
            {
                out.print(fileList[i] + "<br>\n");
            } //End block
        } //End collapsed parenthetic
        out.close();
        varB4EAC82CA7396A68D541C85D26508E83_1793168033 = new ByteArrayInputStream(bytes.toByteArray());
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1793168033.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1793168033;
        // ---------- Original Method ----------
        //String fileList[] = f.list();
        //ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        //PrintStream out = new PrintStream(bytes);
        //out.print("<title>Directory Listing</title>\n");
        //out.print("<base href=\"file:");
        //out.print(f.getPath().replace('\\', '/') + "/\"><h1>" + f.getPath()
                //+ "</h1>\n<hr>\n");
        //int i;
        //for (i = 0; i < fileList.length; i++) {
            //out.print(fileList[i] + "<br>\n");
        //}
        //out.close();
        //return new ByteArrayInputStream(bytes.toByteArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.838 -0400", hash_original_method = "632E8A34CACC91F3F004CEC65E6938CD", hash_generated_method = "60960C7F0AD5A5D06EEE572B42738138")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1854838429 = null; //Variable for return #1
        {
            connect();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1854838429 = is;
        varB4EAC82CA7396A68D541C85D26508E83_1854838429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1854838429;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return is;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.839 -0400", hash_original_method = "FD3C5E750D9B5BE3AE6CD98B1BC8C55C", hash_generated_method = "2E7E2C6F4E0B6396293EFC89D7A2DF0F")
    @Override
    public java.security.Permission getPermission() throws IOException {
        java.security.Permission varB4EAC82CA7396A68D541C85D26508E83_1393226877 = null; //Variable for return #1
        {
            String path;
            path = fileName;
            {
                path = path.replace('/', File.separatorChar);
            } //End block
            permission = new FilePermission(path, "read");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1393226877 = permission;
        varB4EAC82CA7396A68D541C85D26508E83_1393226877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393226877;
        // ---------- Original Method ----------
        //if (permission == null) {
            //String path = fileName;
            //if (File.separatorChar != '/') {
                //path = path.replace('/', File.separatorChar);
            //}
            //permission = new FilePermission(path, "read");
        //}
        //return permission;
    }

    
}

