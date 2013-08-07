package libcore.net.url;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.182 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.182 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.182 -0400", hash_original_field = "37DD3CB77D31BF2E80399C3B748B5F16", hash_generated_field = "99508BAC072434E4BF52703BB1174C03")

    private int length = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.182 -0400", hash_original_field = "F0F18990052D31406E964D776FD3A36D", hash_generated_field = "3949ABAC0B1DE58EC6BD730E294BB79C")

    private boolean isDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.182 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "96BA6FFE95348C93D489804764910CBE")

    private FilePermission permission;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.183 -0400", hash_original_method = "ECDCE15AD3E40A66FECAA373F1AD69DD", hash_generated_method = "4F166745F09965E9EE46DA91F5F6B516")
    public  FileURLConnection(URL url) {
        super(url);
        fileName = url.getFile();
        if(fileName == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.184 -0400", hash_original_method = "9A475DD1FCE4CCB36A5D73E904D3A34C", hash_generated_method = "CFA792195BF7265F672B928B6B86031F")
    @Override
    public void connect() throws IOException {
        File f = new File(fileName);
        if(f.isDirectory())        
        {
            isDir = true;
            is = getDirectoryListing(f);
        } //End block
        else
        {
            is = new BufferedInputStream(new FileInputStream(f));
            long lengthAsLong = f.length();
            length = lengthAsLong <= Integer.MAX_VALUE ? (int) lengthAsLong : Integer.MAX_VALUE;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.185 -0400", hash_original_method = "686027F78C1D594BA8DD041F116549D4", hash_generated_method = "3E25A212FE0FA2BB1FAC2FC2813EAEA4")
    @Override
    public int getContentLength() {
        try 
        {
            if(!connected)            
            {
                connect();
            } //End block
        } //End block
        catch (IOException e)
        {
        } //End block
        int var2FA47F7C65FEC19CC163B195725E3844_1881998606 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888271557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888271557;
        // ---------- Original Method ----------
        //try {
            //if (!connected) {
                //connect();
            //}
        //} catch (IOException e) {
        //}
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.185 -0400", hash_original_method = "72F889733CD7FE79958D9F6D8BD5D3FB", hash_generated_method = "77C77620F06DC1E8F2397EDFAD727B98")
    @Override
    public String getContentType() {
        try 
        {
            if(!connected)            
            {
                connect();
            } //End block
        } //End block
        catch (IOException e)
        {
String var74BE35FB698BCBEC5E595F7D368A5F61_885690067 =             "content/unknown";
            var74BE35FB698BCBEC5E595F7D368A5F61_885690067.addTaint(taint);
            return var74BE35FB698BCBEC5E595F7D368A5F61_885690067;
        } //End block
        if(isDir)        
        {
String varF583FE76B1E99A18DF158173F36BC8DC_1734824021 =             "text/plain";
            varF583FE76B1E99A18DF158173F36BC8DC_1734824021.addTaint(taint);
            return varF583FE76B1E99A18DF158173F36BC8DC_1734824021;
        } //End block
        String result = guessContentTypeFromName(url.getFile());
        if(result != null)        
        {
String varDC838461EE2FA0CA4C9BBB70A15456B0_1327523897 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1327523897.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1327523897;
        } //End block
        try 
        {
            result = guessContentTypeFromStream(is);
        } //End block
        catch (IOException e)
        {
        } //End block
        if(result != null)        
        {
String varDC838461EE2FA0CA4C9BBB70A15456B0_1927013700 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1927013700.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1927013700;
        } //End block
String var74BE35FB698BCBEC5E595F7D368A5F61_1929148891 =         "content/unknown";
        var74BE35FB698BCBEC5E595F7D368A5F61_1929148891.addTaint(taint);
        return var74BE35FB698BCBEC5E595F7D368A5F61_1929148891;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.186 -0400", hash_original_method = "D31BC01A8E6F1896A7501EEF99417267", hash_generated_method = "17A79D4062B04FAA1CC4B2FBB6778B64")
    private InputStream getDirectoryListing(File f) {
        addTaint(f.getTaint());
        String fileList[] = f.list();
        ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        out.print("<title>Directory Listing</title>\n");
        out.print("<base href=\"file:");
        out.print(f.getPath().replace('\\', '/') + "/\"><h1>" + f.getPath()
                + "</h1>\n<hr>\n");
        int i;
for(i = 0;i < fileList.length;i++)
        {
            out.print(fileList[i] + "<br>\n");
        } //End block
        out.close();
InputStream var3844484F7CAF8650F3CB9D0A65F2D71C_438544904 =         new ByteArrayInputStream(bytes.toByteArray());
        var3844484F7CAF8650F3CB9D0A65F2D71C_438544904.addTaint(taint);
        return var3844484F7CAF8650F3CB9D0A65F2D71C_438544904;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.187 -0400", hash_original_method = "632E8A34CACC91F3F004CEC65E6938CD", hash_generated_method = "DDC8CEEF8D57BEAF5D4C19C44BD84183")
    @Override
    public InputStream getInputStream() throws IOException {
        if(!connected)        
        {
            connect();
        } //End block
InputStream varFEDEDC0F36E8CADECC99C26A1426338D_192936026 =         is;
        varFEDEDC0F36E8CADECC99C26A1426338D_192936026.addTaint(taint);
        return varFEDEDC0F36E8CADECC99C26A1426338D_192936026;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return is;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.188 -0400", hash_original_method = "FD3C5E750D9B5BE3AE6CD98B1BC8C55C", hash_generated_method = "72D0BE0D080EEE7AF20F557290570F50")
    @Override
    public java.security.Permission getPermission() throws IOException {
        if(permission == null)        
        {
            String path = fileName;
            if(File.separatorChar != '/')            
            {
                path = path.replace('/', File.separatorChar);
            } //End block
            permission = new FilePermission(path, "read");
        } //End block
java.security.Permission varF950FF3A88BA107D0E5EEB7D5554678A_996978985 =         permission;
        varF950FF3A88BA107D0E5EEB7D5554678A_996978985.addTaint(taint);
        return varF950FF3A88BA107D0E5EEB7D5554678A_996978985;
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

