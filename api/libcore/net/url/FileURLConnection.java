package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.733 -0500", hash_original_field = "90A7C14E9FDE747EFC2F1C95E470FF1A", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.736 -0500", hash_original_field = "B25CAE9BF82BA95FEFAA4B1FEB647560", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.738 -0500", hash_original_field = "D3B99DC683EC7129FDE7A2B083451139", hash_generated_field = "99508BAC072434E4BF52703BB1174C03")

    private int length = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.741 -0500", hash_original_field = "573F3B96CAE1F14BBB393D8A61A5FCF9", hash_generated_field = "3949ABAC0B1DE58EC6BD730E294BB79C")

    private boolean isDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.743 -0500", hash_original_field = "F5BE3F21BE616634ABE5A879B8634A13", hash_generated_field = "96BA6FFE95348C93D489804764910CBE")

    private FilePermission permission;

    /**
     * Creates an instance of <code>FileURLConnection</code> for establishing
     * a connection to the file pointed by this <code>URL<code>
     *
     * @param url The URL this connection is connected to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.746 -0500", hash_original_method = "ECDCE15AD3E40A66FECAA373F1AD69DD", hash_generated_method = "B6D4BCB8D87317739197DB0702F9771D")
    
public FileURLConnection(URL url) {
        super(url);
        fileName = url.getFile();
        if (fileName == null) {
            fileName = "";
        }
        fileName = UriCodec.decode(fileName);
    }

    /**
     * This methods will attempt to obtain the input stream of the file pointed
     * by this <code>URL</code>. If the file is a directory, it will return
     * that directory listing as an input stream.
     *
     * @throws IOException
     *             if an IO error occurs while connecting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.748 -0500", hash_original_method = "9A475DD1FCE4CCB36A5D73E904D3A34C", hash_generated_method = "7D1CD524014605854B17C58503824E09")
    
@Override
    public void connect() throws IOException {
        File f = new File(fileName);
        if (f.isDirectory()) {
            isDir = true;
            is = getDirectoryListing(f);
            // use -1 for the contentLength
        } else {
            is = new BufferedInputStream(new FileInputStream(f));
            long lengthAsLong = f.length();
            length = lengthAsLong <= Integer.MAX_VALUE ? (int) lengthAsLong : Integer.MAX_VALUE;
        }
        connected = true;
    }

    /**
     * Returns the length of the file in bytes.
     *
     * @return the length of the file
     *
     * @see #getContentType()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.751 -0500", hash_original_method = "686027F78C1D594BA8DD041F116549D4", hash_generated_method = "4491F4E7160E2DD1A82D3BE7C3F4358F")
    
@Override
    public int getContentLength() {
        try {
            if (!connected) {
                connect();
            }
        } catch (IOException e) {
            // default is -1
        }
        return length;
    }

    /**
     * Returns the content type of the resource. Just takes a guess based on the
     * name.
     *
     * @return the content type
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.753 -0500", hash_original_method = "72F889733CD7FE79958D9F6D8BD5D3FB", hash_generated_method = "F09D5D637327E65D0812C66AE5A178F1")
    
@Override
    public String getContentType() {
        try {
            if (!connected) {
                connect();
            }
        } catch (IOException e) {
            return "content/unknown";
        }
        if (isDir) {
            return "text/plain";
        }
        String result = guessContentTypeFromName(url.getFile());
        if (result != null) {
            return result;
        }

        try {
            result = guessContentTypeFromStream(is);
        } catch (IOException e) {
            // Ignore
        }
        if (result != null) {
            return result;
        }

        return "content/unknown";
    }

    /**
     * Returns the directory listing of the file component as an input stream.
     *
     * @return the input stream of the directory listing
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.755 -0500", hash_original_method = "D31BC01A8E6F1896A7501EEF99417267", hash_generated_method = "AA1A1EEA3CEC0EE1432CD48663B52191")
    
private InputStream getDirectoryListing(File f) {
        String fileList[] = f.list();
        ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        out.print("<title>Directory Listing</title>\n");
        out.print("<base href=\"file:");
        out.print(f.getPath().replace('\\', '/') + "/\"><h1>" + f.getPath()
                + "</h1>\n<hr>\n");
        int i;
        for (i = 0; i < fileList.length; i++) {
            out.print(fileList[i] + "<br>\n");
        }
        out.close();
        return new ByteArrayInputStream(bytes.toByteArray());
    }

    /**
     * Returns the input stream of the object referred to by this
     * <code>URLConnection</code>
     *
     * File Sample : "/ZIP211/+/harmony/tools/javac/resources/javac.properties"
     * Invalid File Sample:
     * "/ZIP/+/harmony/tools/javac/resources/javac.properties"
     * "ZIP211/+/harmony/tools/javac/resources/javac.properties"
     *
     * @return input stream of the object
     *
     * @throws IOException
     *             if an IO error occurs
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.758 -0500", hash_original_method = "632E8A34CACC91F3F004CEC65E6938CD", hash_generated_method = "ED2775841B5F9FBCF8526B5C47FF6631")
    
@Override
    public InputStream getInputStream() throws IOException {
        if (!connected) {
            connect();
        }
        return is;
    }

    /**
     * Returns the permission, in this case the subclass, FilePermission object
     * which represents the permission necessary for this URLConnection to
     * establish the connection.
     *
     * @return the permission required for this URLConnection.
     *
     * @throws IOException
     *             if an IO exception occurs while creating the permission.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.761 -0500", hash_original_method = "FD3C5E750D9B5BE3AE6CD98B1BC8C55C", hash_generated_method = "DC376D2D4AD943413E6FE605E18999B5")
    
@Override
    public java.security.Permission getPermission() throws IOException {
        if (permission == null) {
            String path = fileName;
            if (File.separatorChar != '/') {
                path = path.replace('/', File.separatorChar);
            }
            permission = new FilePermission(path, "read");
        }
        return permission;
    }
    
}

