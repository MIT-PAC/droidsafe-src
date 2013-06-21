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
    String fileName;
    private InputStream is;
    private int length = -1;
    private boolean isDir;
    private FilePermission permission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.577 -0400", hash_original_method = "ECDCE15AD3E40A66FECAA373F1AD69DD", hash_generated_method = "25354344EFD314709817AF9B3B65DDA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileURLConnection(URL url) {
        super(url);
        dsTaint.addTaint(url.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.577 -0400", hash_original_method = "9A475DD1FCE4CCB36A5D73E904D3A34C", hash_generated_method = "B79A6D293EBF69AC68EC6758E0C5283E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect() throws IOException {
        File f;
        f = new File(fileName);
        {
            boolean varA97259D5C3642C5738EE6A4F81981B2D_476741290 = (f.isDirectory());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.577 -0400", hash_original_method = "686027F78C1D594BA8DD041F116549D4", hash_generated_method = "63EF3F5D45F824EE662F1028F878643F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //if (!connected) {
                //connect();
            //}
        //} catch (IOException e) {
        //}
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.578 -0400", hash_original_method = "72F889733CD7FE79958D9F6D8BD5D3FB", hash_generated_method = "91BB0187E2189C593064B5B54B9E3904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getContentType() {
        try 
        {
            {
                connect();
            } //End block
        } //End block
        catch (IOException e)
        { }
        String result;
        result = guessContentTypeFromName(url.getFile());
        try 
        {
            result = guessContentTypeFromStream(is);
        } //End block
        catch (IOException e)
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.578 -0400", hash_original_method = "D31BC01A8E6F1896A7501EEF99417267", hash_generated_method = "46DD45211629ED6F3FD13BA0771EB3D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InputStream getDirectoryListing(File f) {
        dsTaint.addTaint(f.dsTaint);
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
        InputStream varDC2238851298B71D6325D27D381A61A5_1423962160 = (new ByteArrayInputStream(bytes.toByteArray()));
        return (InputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.578 -0400", hash_original_method = "632E8A34CACC91F3F004CEC65E6938CD", hash_generated_method = "E0BD4D58F9E9402653F01D9E140F0CD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getInputStream() throws IOException {
        {
            connect();
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //return is;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.578 -0400", hash_original_method = "FD3C5E750D9B5BE3AE6CD98B1BC8C55C", hash_generated_method = "16813564F068A477A34C19A9919F3D59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public java.security.Permission getPermission() throws IOException {
        {
            String path;
            path = fileName;
            {
                path = path.replace('/', File.separatorChar);
            } //End block
            permission = new FilePermission(path, "read");
        } //End block
        return (java.security.Permission)dsTaint.getTaint();
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

