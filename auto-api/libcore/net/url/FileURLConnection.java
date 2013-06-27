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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.020 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.020 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.020 -0400", hash_original_field = "37DD3CB77D31BF2E80399C3B748B5F16", hash_generated_field = "99508BAC072434E4BF52703BB1174C03")

    private int length = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.020 -0400", hash_original_field = "F0F18990052D31406E964D776FD3A36D", hash_generated_field = "3949ABAC0B1DE58EC6BD730E294BB79C")

    private boolean isDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.020 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "96BA6FFE95348C93D489804764910CBE")

    private FilePermission permission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.021 -0400", hash_original_method = "ECDCE15AD3E40A66FECAA373F1AD69DD", hash_generated_method = "7CCDA583CEB42F317B5916AC796DE1FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.033 -0400", hash_original_method = "9A475DD1FCE4CCB36A5D73E904D3A34C", hash_generated_method = "400B67DF5CCF483085983936368FFB24")
    @Override
    public void connect() throws IOException {
        File f;
        f = new File(fileName);
        {
            boolean varA97259D5C3642C5738EE6A4F81981B2D_897952003 = (f.isDirectory());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.034 -0400", hash_original_method = "686027F78C1D594BA8DD041F116549D4", hash_generated_method = "A626C5234779EB93063B340276390715")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874331411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874331411;
        // ---------- Original Method ----------
        //try {
            //if (!connected) {
                //connect();
            //}
        //} catch (IOException e) {
        //}
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.037 -0400", hash_original_method = "72F889733CD7FE79958D9F6D8BD5D3FB", hash_generated_method = "7B0B016D8EA55239CD5A285406CCF132")
    @Override
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_350139979 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1373249767 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1910663802 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_2102733259 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_260096556 = null; //Variable for return #5
        try 
        {
            {
                connect();
            } //End block
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_350139979 = "content/unknown";
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1373249767 = "text/plain";
        } //End block
        String result;
        result = guessContentTypeFromName(url.getFile());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1910663802 = result;
        } //End block
        try 
        {
            result = guessContentTypeFromStream(is);
        } //End block
        catch (IOException e)
        { }
        {
            varB4EAC82CA7396A68D541C85D26508E83_2102733259 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_260096556 = "content/unknown";
        String varA7E53CE21691AB073D9660D615818899_342274065; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_342274065 = varB4EAC82CA7396A68D541C85D26508E83_350139979;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_342274065 = varB4EAC82CA7396A68D541C85D26508E83_1373249767;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_342274065 = varB4EAC82CA7396A68D541C85D26508E83_1910663802;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_342274065 = varB4EAC82CA7396A68D541C85D26508E83_2102733259;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_342274065 = varB4EAC82CA7396A68D541C85D26508E83_260096556;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_342274065.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_342274065;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.053 -0400", hash_original_method = "D31BC01A8E6F1896A7501EEF99417267", hash_generated_method = "C426E7B180F0EC16FFD8A54FD0A54611")
    private InputStream getDirectoryListing(File f) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_165078881 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_165078881 = new ByteArrayInputStream(bytes.toByteArray());
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_165078881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_165078881;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.054 -0400", hash_original_method = "632E8A34CACC91F3F004CEC65E6938CD", hash_generated_method = "A8E3E9CA19961F53763AE76A4556BEDA")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_528635873 = null; //Variable for return #1
        {
            connect();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_528635873 = is;
        varB4EAC82CA7396A68D541C85D26508E83_528635873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_528635873;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return is;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.066 -0400", hash_original_method = "FD3C5E750D9B5BE3AE6CD98B1BC8C55C", hash_generated_method = "1C2F009D1D377FA65B9BC759F744DCC2")
    @Override
    public java.security.Permission getPermission() throws IOException {
        java.security.Permission varB4EAC82CA7396A68D541C85D26508E83_233352100 = null; //Variable for return #1
        {
            String path;
            path = fileName;
            {
                path = path.replace('/', File.separatorChar);
            } //End block
            permission = new FilePermission(path, "read");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_233352100 = permission;
        varB4EAC82CA7396A68D541C85D26508E83_233352100.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_233352100;
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

