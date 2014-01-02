package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;






public abstract class URLConnection {

    /**
     * Returns the default setting whether this connection allows user interaction.
     *
     * @return the value of the default setting {@code
     *         defaultAllowUserInteraction}.
     * @see #allowUserInteraction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.098 -0500", hash_original_method = "67F858C73BD58BCF0CAF80EEB7D73D90", hash_generated_method = "3936BBC1DD5171A6137F084FBB8158D1")
    
public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    /**
     * Returns null.
     *
     * @deprecated Use {@link #getRequestProperty}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.100 -0500", hash_original_method = "B76126F7836136C8351610A389F2D654", hash_generated_method = "9C6117325CB6ACFF0010235F1E3C8499")
    
@Deprecated
    public static String getDefaultRequestProperty(String field) {
        return null;
    }

    /**
     * Returns the table which is used by all {@code URLConnection} instances to
     * determine the MIME-type according to a file extension.
     *
     * @return the file name map to determine the MIME-type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.113 -0500", hash_original_method = "29BA6BC9F5073139C26133751F95172D", hash_generated_method = "D75F508274D26B048BDA05E713F099FA")
    
public static FileNameMap getFileNameMap() {
        synchronized (URLConnection.class) {
            if (fileNameMap == null) {
                fileNameMap = new DefaultFileNameMap();
            }
            return fileNameMap;
        }
    }

    /**
     * Determines the MIME-type of the given resource {@code url} by resolving
     * the filename extension with the internal FileNameMap. Any fragment
     * identifier is removed before processing.
     *
     * @param url
     *            the URL with the filename to get the MIME type.
     * @return the guessed content type or {@code null} if the type could not be
     *         determined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.154 -0500", hash_original_method = "CA2040B3E0B7CAC084654E1B2D2F55A4", hash_generated_method = "BCBA41FE6FDB3DB2762019574161AC70")
    
public static String guessContentTypeFromName(String url) {
        return getFileNameMap().getContentTypeFor(url);
    }

    /**
     * Determines the MIME-type of the resource represented by the input stream
     * {@code is} by reading its first few characters.
     *
     * @param is
     *            the resource representing input stream to determine the
     *            content type.
     * @return the guessed content type or {@code null} if the type could not be
     *         determined.
     * @throws IOException
     *             if an I/O error occurs while reading from the input stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.159 -0500", hash_original_method = "788FE5A301E4424C703F6A133B8247C4", hash_generated_method = "DAE6DCDC95D139D4581772841B2A2EFC")
    
public static String guessContentTypeFromStream(InputStream is) throws IOException {
        if (!is.markSupported()) {
            return null;
        }
        // Look ahead up to 64 bytes for the longest encoded header
        is.mark(64);
        byte[] bytes = new byte[64];
        int length = is.read(bytes);
        is.reset();

        // If there is no data from the input stream, we can't determine content type.
        if (length == -1) {
            return null;
        }

        // Check for Unicode BOM encoding indicators
        String encoding = "US-ASCII";
        int start = 0;
        if (length > 1) {
            if ((bytes[0] == (byte) 0xFF) && (bytes[1] == (byte) 0xFE)) {
                encoding = "UTF-16LE";
                start = 2;
                length -= length & 1;
            }
            if ((bytes[0] == (byte) 0xFE) && (bytes[1] == (byte) 0xFF)) {
                encoding = "UTF-16BE";
                start = 2;
                length -= length & 1;
            }
            if (length > 2) {
                if ((bytes[0] == (byte) 0xEF) && (bytes[1] == (byte) 0xBB)
                        && (bytes[2] == (byte) 0xBF)) {
                    encoding = "UTF-8";
                    start = 3;
                }
                if (length > 3) {
                    if ((bytes[0] == (byte) 0x00) && (bytes[1] == (byte) 0x00)
                            && (bytes[2] == (byte) 0xFE)
                            && (bytes[3] == (byte) 0xFF)) {
                        encoding = "UTF-32BE";
                        start = 4;
                        length -= length & 3;
                    }
                    if ((bytes[0] == (byte) 0xFF) && (bytes[1] == (byte) 0xFE)
                            && (bytes[2] == (byte) 0x00)
                            && (bytes[3] == (byte) 0x00)) {
                        encoding = "UTF-32LE";
                        start = 4;
                        length -= length & 3;
                    }
                }
            }
        }

        String header = new String(bytes, start, length - start, encoding);

        // Check binary types
        if (header.startsWith("PK")) {
            return "application/zip";
        }
        if (header.startsWith("GI")) {
            return "image/gif";
        }

        // Check text types
        String textHeader = header.trim().toUpperCase(Locale.US);
        if (textHeader.startsWith("<!DOCTYPE HTML") ||
                textHeader.startsWith("<HTML") ||
                textHeader.startsWith("<HEAD") ||
                textHeader.startsWith("<BODY") ||
                textHeader.startsWith("<HEAD")) {
            return "text/html";
        }

        if (textHeader.startsWith("<?XML")) {
            return "application/xml";
        }

        // Give up
        return null;
    }

    /**
     * Sets the internally used content handler factory. The content factory can
     * only be set once during the lifetime of the application.
     *
     * @param contentFactory
     *            the content factory to be set.
     * @throws Error
     *             if the factory has been already set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.167 -0500", hash_original_method = "01C4B07DD183411E1616D228FCEA46F4", hash_generated_method = "70DFB3D550118FE8AEE561A0E357A32B")
    
public static synchronized void setContentHandlerFactory(ContentHandlerFactory contentFactory) {
        if (contentHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        contentHandlerFactory = contentFactory;
    }

    /**
     * Sets the default value for the flag indicating whether this connection
     * allows user interaction or not. Existing {@code URLConnection}s are
     * unaffected.
     *
     * @param allows
     *            the default value of the flag to be used for new connections.
     * @see #defaultAllowUserInteraction
     * @see #allowUserInteraction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.169 -0500", hash_original_method = "0619B46EA06FDDA3BE0AC0FE1EF06FA2", hash_generated_method = "4F9CF50B0F9EE0B89033BBD11414C670")
    
public static void setDefaultAllowUserInteraction(boolean allows) {
        defaultAllowUserInteraction = allows;
    }

    /**
     * Does nothing.
     *
     * @deprecated Use {@link URLConnection#setRequestProperty(String, String)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.172 -0500", hash_original_method = "C6165B081FA515B9B3060BC6E3911C85", hash_generated_method = "AD553A46666C9EA196877FE8233D039E")
    
@Deprecated
    public static void setDefaultRequestProperty(String field, String value) {
    }

    /**
     * Sets the internal map which is used by all {@code URLConnection}
     * instances to determine the MIME-type according to a filename extension.
     *
     * @param map
     *            the MIME table to be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.181 -0500", hash_original_method = "56CE34851CE4C12293D078BB294959F9", hash_generated_method = "B26DD18DA4BD0F1955EB9BE23F15CD93")
    
public static void setFileNameMap(FileNameMap map) {
        synchronized (URLConnection.class) {
            fileNameMap = map;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.037 -0500", hash_original_field = "8D5D028678AAF3CC459528BDAE282DFA", hash_generated_field = "1A52F999A308188068C76D38BA5615EF")


    private static boolean defaultAllowUserInteraction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.039 -0500", hash_original_field = "A5D58564F4CE88AFAC6558119A5489F5", hash_generated_field = "0745D91F58FAC663266DAFADF4C39A8B")


    private static boolean defaultUseCaches = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.060 -0500", hash_original_field = "080E869D8114D1C74C230DBF66231C2C", hash_generated_field = "D42218022B7E3DD64D7C74B810FC8B3D")


    private static ContentHandlerFactory contentHandlerFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.067 -0500", hash_original_field = "4FFC960D76E3B61CDC64E3621EBE8A6C", hash_generated_field = "B35CCA371471EC5184868CE09D94475C")

    static Hashtable<String, Object> contentHandlers = new Hashtable<String, Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.070 -0500", hash_original_field = "C655F3F2DF8929DC02684D7F2E3060C9", hash_generated_field = "E3E7D988476B274A9DF2166D8A8B4DFA")

    private static FileNameMap fileNameMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.032 -0500", hash_original_field = "D0C59163767519DDC23EEDD08636971F", hash_generated_field = "65BA9482E03BACCDBB5A2D08239D2205")

    protected URL url;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.034 -0500", hash_original_field = "EC00198C8901F4A46F11243ED4F82C3C", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")


    private String contentType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.041 -0500", hash_original_field = "AA6C99420A3EDFB143DFB7EA7C0B7623", hash_generated_field = "AA6C99420A3EDFB143DFB7EA7C0B7623")


    ContentHandler defaultHandler = new DefaultContentHandler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.044 -0500", hash_original_field = "C57F295716CFF89C00CC3061FA79AC83", hash_generated_field = "80AE10D08247476B02E38D0EE6A074A6")


    private long lastModified = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.047 -0500", hash_original_field = "AE6AA07017077DCFAE4963BA0D1DA99B", hash_generated_field = "CCFF3B6B851FE8AAC8BF953CAC3C257F")

    protected long ifModifiedSince;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.049 -0500", hash_original_field = "BE024EEF4D216F973C533E2862198DD4", hash_generated_field = "75210328E42DAA7308C7C0DA02D4ECC5")

    protected boolean useCaches = defaultUseCaches;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.051 -0500", hash_original_field = "F29BF14E2D06802EFFABC46F01FDE626", hash_generated_field = "34C8ABCCB96118D0E63480374F97C450")

    protected boolean connected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.053 -0500", hash_original_field = "2B2BC0E7C7E7F47BBAEF2F7DA1C171F4", hash_generated_field = "0588DDF6632243F20DFFAECC5F0C174F")

    protected boolean doOutput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.056 -0500", hash_original_field = "F00C2C13D0F4757D2ABC4CBED9A6C8F0", hash_generated_field = "9295E463A85C6D53795FA77F5F4990C8")

    protected boolean doInput = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.058 -0500", hash_original_field = "0A0B90DFC65C0EA355CF78A214E2AC51", hash_generated_field = "4EB96F0015DD5E6A1B47A0B69C90DCD0")

    protected boolean allowUserInteraction = defaultAllowUserInteraction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.063 -0500", hash_original_field = "BEB2F5AEFF407193A05CB107B9A4F798", hash_generated_field = "2D29EC4E724B4A9910DF5E47FBCFBD74")


    private int readTimeout = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.065 -0500", hash_original_field = "C4F50E01A2C9DBD63D4DB85F092A1128", hash_generated_field = "7C5462E35603097818B70A73FEBCE187")


    private int connectTimeout = 0;

    /**
     * Creates a new {@code URLConnection} instance pointing to the resource
     * specified by the given URL.
     *
     * @param url
     *            the URL which represents the resource this {@code
     *            URLConnection} will point to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.072 -0500", hash_original_method = "C1B78B989F00EEFB1B34CFF3211D8415", hash_generated_method = "CB378ED4328B27D48745A9EA2C99D999")
    
protected URLConnection(URL url) {
        this.url = url;
    }

    /**
     * Opens a connection to the resource. This method will <strong>not</strong>
     * reconnect to a resource after the initial connection has been closed.
     *
     * @throws IOException
     *             if an error occurs while connecting to the resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.074 -0500", hash_original_method = "E3B3D609A299C20BEA286BB272FDF5DD", hash_generated_method = "12E46584ED58D785D1E4DDAC8B414223")
    
public abstract void connect() throws IOException;

    /**
     * Returns the option value which indicates whether user interaction is allowed
     * on this {@code URLConnection}.
     *
     * @return the value of the option {@code allowUserInteraction}.
     * @see #allowUserInteraction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.077 -0500", hash_original_method = "C67DC5C525139049127B216E3212E5BD", hash_generated_method = "44B6C2B29A0D072811939A56A423B9EC")
    
public boolean getAllowUserInteraction() {
        return allowUserInteraction;
    }

    /**
     * Returns an object representing the content of the resource this {@code
     * URLConnection} is connected to. First, it attempts to get the content
     * type from the method {@code getContentType()} which looks at the response
     * header field "Content-Type". If none is found it will guess the content
     * type from the filename extension. If that fails the stream itself will be
     * used to guess the content type.
     *
     * @return the content representing object.
     * @throws IOException
     *             if an error occurs obtaining the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.079 -0500", hash_original_method = "2189DFB0457B899A3D415AD1ACECB1AB", hash_generated_method = "A8A625F791F192870378364A2A1B015F")
    
public Object getContent() throws java.io.IOException {
        if (!connected) {
            connect();
        }

        if ((contentType = getContentType()) == null) {
            if ((contentType = guessContentTypeFromName(url.getFile())) == null) {
                contentType = guessContentTypeFromStream(getInputStream());
            }
        }
        if (contentType != null) {
            return getContentHandler(contentType).getContent(this);
        }
        return null;
    }

    /**
     * Returns an object representing the content of the resource this {@code
     * URLConnection} is connected to. First, it attempts to get the content
     * type from the method {@code getContentType()} which looks at the response
     * header field "Content-Type". If none is found it will guess the content
     * type from the filename extension. If that fails the stream itself will be
     * used to guess the content type. The content type must match with one of
     * the list {@code types}.
     *
     * @param types
     *            the list of acceptable content types.
     * @return the content representing object or {@code null} if the content
     *         type does not match with one of the specified types.
     * @throws IOException
     *             if an error occurs obtaining the content.
     */
    // Param is not generic in spec
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.082 -0500", hash_original_method = "4564C020E5F3A695F95559B726D59F50", hash_generated_method = "17D6F8DB36F781EAF39BC1A6AA530256")
    
@SuppressWarnings("unchecked")
    public Object getContent(Class[] types) throws IOException {
        if (!connected) {
            connect();
        }

        if ((contentType = getContentType()) == null) {
            if ((contentType = guessContentTypeFromName(url.getFile())) == null) {
                contentType = guessContentTypeFromStream(getInputStream());
            }
        }
        if (contentType != null) {
            return getContentHandler(contentType).getContent(this, types);
        }
        return null;
    }

    /**
     * Returns the content encoding type specified by the response header field
     * {@code content-encoding} or {@code null} if this field is not set.
     *
     * @return the value of the response header field {@code content-encoding}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.085 -0500", hash_original_method = "F034FCCBCF276A401A79AE9D47D45859", hash_generated_method = "3DF4F3807A495B21CCDCE63CA735C4E0")
    
public String getContentEncoding() {
        return getHeaderField("Content-Encoding");
    }

    /**
     * Returns the specific ContentHandler that will handle the type {@code
     * contentType}.
     *
     * @param type
     *            The type that needs to be handled
     * @return An instance of the Content Handler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.089 -0500", hash_original_method = "F46F19D62AAF6AA8CA742989F38D6600", hash_generated_method = "D4E22395C8377B2AFB19B97EEC92AF49")
    
private ContentHandler getContentHandler(String type) throws IOException {
        // Replace all non-alphanumeric character by '_'
        final String typeString = parseTypeString(type.replace('/', '.'));

        // if there's a cached content handler, use it
        Object cHandler = contentHandlers.get(type);
        if (cHandler != null) {
            return (ContentHandler) cHandler;
        }

        if (contentHandlerFactory != null) {
            cHandler = contentHandlerFactory.createContentHandler(type);
            contentHandlers.put(type, cHandler);
            return (ContentHandler) cHandler;
        }

        // search through the package list for the right class for the Content Type
        String packageList = System.getProperty("java.content.handler.pkgs");
        if (packageList != null) {
            for (String packageName : packageList.split("\\|")) {
                String className = packageName + "." + typeString;
                try {
                    Class<?> klass = Class.forName(className, true, ClassLoader.getSystemClassLoader());
                    cHandler = klass.newInstance();
                } catch (ClassNotFoundException e) {
                } catch (IllegalAccessException e) {
                } catch (InstantiationException e) {
                }
            }
        }

        if (cHandler == null) {
            try {
                // Try looking up AWT image content handlers
                String className = "org.apache.harmony.awt.www.content." + typeString;
                cHandler = Class.forName(className).newInstance();
            } catch (ClassNotFoundException e) {
            } catch (IllegalAccessException e) {
            } catch (InstantiationException e) {
            }
        }
        if (cHandler != null) {
            if (!(cHandler instanceof ContentHandler)) {
                throw new UnknownServiceException();
            }
            contentHandlers.put(type, cHandler); // if we got the handler,
            // cache it for next time
            return (ContentHandler) cHandler;
        }

        return defaultHandler;
    }

    /**
     * Returns the content length in bytes specified by the response header field
     * {@code content-length} or {@code -1} if this field is not set.
     *
     * @return the value of the response header field {@code content-length}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.091 -0500", hash_original_method = "D3CB748394BDEDD2AA4B807728EDFBEF", hash_generated_method = "BB7604B8A1EBFBF17EA9C09701967F37")
    
public int getContentLength() {
        return getHeaderFieldInt("Content-Length", -1);
    }

    /**
     * Returns the MIME-type of the content specified by the response header field
     * {@code content-type} or {@code null} if type is unknown.
     *
     * @return the value of the response header field {@code content-type}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.093 -0500", hash_original_method = "7440B54E7BE94AE7F9BB4349A25246D4", hash_generated_method = "C174C05C0D4687BFF9AF1A822C8B8A7E")
    
public String getContentType() {
        return getHeaderField("Content-Type");
    }

    /**
     * Returns the timestamp when this response has been sent as a date in
     * milliseconds since January 1, 1970 GMT or {@code 0} if this timestamp is
     * unknown.
     *
     * @return the sending timestamp of the current response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.095 -0500", hash_original_method = "4C9F7702471FFCF16C0BDF48E7BD6750", hash_generated_method = "63BB99B520751EBD3E6EFACEF2F7AAEF")
    
public long getDate() {
        return getHeaderFieldDate("Date", 0);
    }

    /**
     * Returns the default setting whether this connection allows using caches.
     *
     * @return the value of the default setting {@code defaultUseCaches}.
     * @see #useCaches
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.103 -0500", hash_original_method = "08FC81CB612F586F4ABF44BAE872E3A8", hash_generated_method = "5272C3CEDB838F947AAD09BDA1864ED0")
    
public boolean getDefaultUseCaches() {
        return defaultUseCaches;
    }

    /**
     * Returns the value of the option {@code doInput} which specifies whether this
     * connection allows to receive data.
     *
     * @return {@code true} if this connection allows input, {@code false}
     *         otherwise.
     * @see #doInput
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.105 -0500", hash_original_method = "CCCD690FEDEDD1DE3F70C92A661DD993", hash_generated_method = "3419749DF1D1BE0D2DECCE4E860C3DCC")
    
public boolean getDoInput() {
        return doInput;
    }

    /**
     * Returns the value of the option {@code doOutput} which specifies whether
     * this connection allows to send data.
     *
     * @return {@code true} if this connection allows output, {@code false}
     *         otherwise.
     * @see #doOutput
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.107 -0500", hash_original_method = "15D6FCAAE0989BD58186FF458E57106D", hash_generated_method = "0363EA39333AA06ACFDF3AA0E4328239")
    
public boolean getDoOutput() {
        return doOutput;
    }

    /**
     * Returns the timestamp when this response will be expired in milliseconds
     * since January 1, 1970 GMT or {@code 0} if this timestamp is unknown.
     *
     * @return the value of the response header field {@code expires}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.110 -0500", hash_original_method = "C717C195610527A15AE106EB78FD0F84", hash_generated_method = "49B16C01CD07FB3DBBA04ADEB40B87DF")
    
public long getExpiration() {
        return getHeaderFieldDate("Expires", 0);
    }

    /**
     * Returns the header value at the field position {@code pos} or {@code null}
     * if the header has fewer than {@code pos} fields. The base
     * implementation of this method returns always {@code null}.
     *
     * <p>Some implementations (notably {@code HttpURLConnection}) include a mapping
     * for the null key; in HTTP's case, this maps to the HTTP status line and is
     * treated as being at position 0 when indexing into the header fields.
     *
     * @param pos
     *            the field position of the response header.
     * @return the value of the field at position {@code pos}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.115 -0500", hash_original_method = "4AACA905FA1278AAB35ED38439896081", hash_generated_method = "C41CD50CE2AC5FE72F79E6188B82872F")
    
public String getHeaderField(int pos) {
        return null;
    }

    /**
     * Returns an unmodifiable map of the response-header fields and values. The
     * response-header field names are the key values of the map. The map values
     * are lists of header field values associated with a particular key name.
     *
     * <p>Some implementations (notably {@code HttpURLConnection}) include a mapping
     * for the null key; in HTTP's case, this maps to the HTTP status line and is
     * treated as being at position 0 when indexing into the header fields.
     *
     * @return the response-header representing generic map.
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.117 -0500", hash_original_method = "C458EE5373FC7B6169E37A6DC44512AF", hash_generated_method = "773CAA9A39027054ACE0F93654886696")
    
public Map<String, List<String>> getHeaderFields() {
        return Collections.emptyMap();
    }

    /**
     * Returns an unmodifiable map of general request properties used by this
     * connection. The request property names are the key values of the map. The
     * map values are lists of property values of the corresponding key name.
     *
     * @return the request-property representing generic map.
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.119 -0500", hash_original_method = "04A4D958E6B53818E212E56DBBF1EB38", hash_generated_method = "0D7D1552A0D2D3F788EBC7C63F6318E0")
    
public Map<String, List<String>> getRequestProperties() {
        checkNotConnected();
        return Collections.emptyMap();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.121 -0500", hash_original_method = "B91416BA99E534CF967424CBFE2F2ACE", hash_generated_method = "593BF47F26E37099B137FDF96EDAB581")
    
private void checkNotConnected() {
        if (connected) {
            throw new IllegalStateException("Already connected");
        }
    }

    /**
     * Adds the given property to the request header. Existing properties with
     * the same name will not be overwritten by this method.
     *
     * @param field
     *            the request property field name to add.
     * @param newValue
     *            the value of the property which is to add.
     * @throws IllegalStateException
     *             if the connection has been already established.
     * @throws NullPointerException
     *             if the property name is {@code null}.
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.124 -0500", hash_original_method = "AA90A2DB0C71826C83D2E27C5299DE6D", hash_generated_method = "9A2054FF16C2C7295EC0F9342921BDF8")
    
public void addRequestProperty(String field, String newValue) {
        checkNotConnected();
        if (field == null) {
            throw new NullPointerException("field == null");
        }
    }

    /**
     * Returns the value of the header field specified by {@code key} or {@code
     * null} if there is no field with this name. The base implementation of
     * this method returns always {@code null}.
     *
     * <p>Some implementations (notably {@code HttpURLConnection}) include a mapping
     * for the null key; in HTTP's case, this maps to the HTTP status line and is
     * treated as being at position 0 when indexing into the header fields.
     *
     * @param key
     *            the name of the header field.
     * @return the value of the header field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.127 -0500", hash_original_method = "565CBD8C4BDCB5C201FDE1F2CB76B55D", hash_generated_method = "C805EF3131A22E118686C0E6E02FD1F4")
    
public String getHeaderField(String key) {
        return null;
    }

    /**
     * Returns the specified header value as a date in milliseconds since January
     * 1, 1970 GMT. Returns the {@code defaultValue} if no such header field
     * could be found.
     *
     * @param field
     *            the header field name whose value is needed.
     * @param defaultValue
     *            the default value if no field has been found.
     * @return the value of the specified header field as a date in
     *         milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.129 -0500", hash_original_method = "3BD57BE7E93B8CCFBCD5DB800D789765", hash_generated_method = "A700C7920290D5AF1FF380E36E6B74F0")
    
@SuppressWarnings("deprecation")
    public long getHeaderFieldDate(String field, long defaultValue) {
        String date = getHeaderField(field);
        if (date == null) {
            return defaultValue;
        }
        try {
            return Date.parse(date); // TODO: use HttpDate.parse()
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Returns the specified header value as a number. Returns the {@code
     * defaultValue} if no such header field could be found or the value could
     * not be parsed as an {@code Integer}.
     *
     * @param field
     *            the header field name whose value is needed.
     * @param defaultValue
     *            the default value if no field has been found.
     * @return the value of the specified header field as a number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.131 -0500", hash_original_method = "13117EC346BE33DF62C37EDAC186E83F", hash_generated_method = "24946A8539774F65FB494A2158B313F1")
    
public int getHeaderFieldInt(String field, int defaultValue) {
        try {
            return Integer.parseInt(getHeaderField(field));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * Returns the name of the header field at the given position {@code posn} or
     * {@code null} if there are fewer than {@code posn} fields. The base
     * implementation of this method returns always {@code null}.
     *
     * <p>Some implementations (notably {@code HttpURLConnection}) include a mapping
     * for the null key; in HTTP's case, this maps to the HTTP status line and is
     * treated as being at position 0 when indexing into the header fields.
     *
     * @param posn
     *            the position of the header field which has to be returned.
     * @return the header field name at the given position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.134 -0500", hash_original_method = "2E9FACF1BA93288E38DBB8CED1C2CF00", hash_generated_method = "59B95771F021B58797A1E53CC441ABF2")
    
public String getHeaderFieldKey(int posn) {
        return null;
    }

    /**
     * Returns the point of time since when the data must be modified to be
     * transmitted. Some protocols transmit data only if it has been modified
     * more recently than a particular time.
     *
     * @return the time in milliseconds since January 1, 1970 GMT.
     * @see #ifModifiedSince
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.136 -0500", hash_original_method = "3D630E318477F0341CC679CD7D029C3F", hash_generated_method = "A1F3BA8299293D7B6248E15B5535090E")
    
public long getIfModifiedSince() {
        return ifModifiedSince;
    }

    /**
     * Returns an {@code InputStream} for reading data from the resource pointed by
     * this {@code URLConnection}. It throws an UnknownServiceException by
     * default. This method must be overridden by its subclasses.
     *
     * @return the InputStream to read data from.
     * @throws IOException
     *             if no InputStream could be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.138 -0500", hash_original_method = "AC7495DD6573AA12A9CB49C509EE6FD0", hash_generated_method = "FAAEE0050218252D181324FD0AF4D174")
    
public InputStream getInputStream() throws IOException {
        throw new UnknownServiceException("Does not support writing to the input stream");
    }

    /**
     * Returns the value of the response header field {@code last-modified} or
     * {@code 0} if this value is not set.
     *
     * @return the value of the {@code last-modified} header field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.141 -0500", hash_original_method = "1B346D840CFCEDE13531D2A642CD424D", hash_generated_method = "6B3EA3444C599FCE98F9EC8766BA6312")
    
public long getLastModified() {
        if (lastModified != -1) {
            return lastModified;
        }
        return lastModified = getHeaderFieldDate("Last-Modified", 0);
    }

    /**
     * Returns an {@code OutputStream} for writing data to this {@code
     * URLConnection}. It throws an {@code UnknownServiceException} by default.
     * This method must be overridden by its subclasses.
     *
     * @return the OutputStream to write data.
     * @throws IOException
     *             if no OutputStream could be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.143 -0500", hash_original_method = "F613A2AA87619B352A0F7C7CAB39D3F5", hash_generated_method = "2FA7EE7D9906A5BB0CDD13F5908662C8")
    
public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException("Does not support writing to the output stream");
    }

    /**
     * Returns a {@code Permission} object representing all needed permissions to
     * open this connection. The returned permission object depends on the state
     * of the connection and will be {@code null} if no permissions are
     * necessary. By default, this method returns {@code AllPermission}.
     * Subclasses should overwrite this method to return an appropriate
     * permission object.
     *
     * @return the permission object representing the needed permissions to open
     *         this connection.
     * @throws IOException
     *             if an I/O error occurs while creating the permission object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.145 -0500", hash_original_method = "0312DFF81C6978A2908F9B8EFDA3EFD4", hash_generated_method = "3CE789F348ADA18776DC3737EA60F646")
    
public java.security.Permission getPermission() throws IOException {
        return new java.security.AllPermission();
    }

    /**
     * Returns the value of the request header property specified by {code field}
     * or {@code null} if there is no field with this name. The base
     * implementation of this method returns always {@code null}.
     *
     * @param field
     *            the name of the request header property.
     * @return the value of the property.
     * @throws IllegalStateException
     *             if the connection has been already established.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.148 -0500", hash_original_method = "9BF81D9E57E4C63EDA2E82E6CB1EEED2", hash_generated_method = "9C401C33868B07256EDDDAC1474F61D8")
    
public String getRequestProperty(String field) {
        checkNotConnected();
        return null;
    }

    /**
     * Returns the URL represented by this {@code URLConnection}.
     *
     * @return the URL of this connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.150 -0500", hash_original_method = "2F8DA67F8DE7FED0345BBAE8C82F68E5", hash_generated_method = "D6D7197D0CF613F7A230574C15135383")
    
public URL getURL() {
        return url;
    }

    /**
     * Returns the value of the flag which specifies whether this {@code
     * URLConnection} allows to use caches.
     *
     * @return {@code true} if using caches is allowed, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.152 -0500", hash_original_method = "2F69889B76EEFF99FBB9977BF19C64FC", hash_generated_method = "0BA3962F71E7EB9DB05E960AA948F4F3")
    
public boolean getUseCaches() {
        return useCaches;
    }

    /**
     * Performs any necessary string parsing on the input string such as
     * converting non-alphanumeric character into underscore.
     *
     * @param typeString
     *            the parsed string
     * @return the string to be parsed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.161 -0500", hash_original_method = "8088F9069DED191ECB9FB0409A3793EB", hash_generated_method = "8B4028A62C0D91E0490E02417DC6A5D8")
    
private String parseTypeString(String typeString) {
        StringBuilder result = new StringBuilder(typeString);
        for (int i = 0; i < result.length(); i++) {
            // if non-alphanumeric, replace it with '_'
            char c = result.charAt(i);
            if (!(Character.isLetter(c) || Character.isDigit(c) || c == '.')) {
                result.setCharAt(i, '_');
            }
        }
        return result.toString();
    }

    /**
     * Sets the flag indicating whether this connection allows user interaction
     * or not. This method can only be called prior to the connection
     * establishment.
     *
     * @param newValue
     *            the value of the flag to be set.
     * @throws IllegalStateException
     *             if this method attempts to change the flag after the
     *             connection has been established.
     * @see #allowUserInteraction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.164 -0500", hash_original_method = "701213F9DAF865C1E161CA61CF705A45", hash_generated_method = "1D3F55D60A00F61055B3C7DE5F5E9AA4")
    
public void setAllowUserInteraction(boolean newValue) {
        checkNotConnected();
        this.allowUserInteraction = newValue;
    }

    /**
     * Sets the default value for the flag indicating whether this connection
     * allows to use caches. Existing {@code URLConnection}s are unaffected.
     *
     * @param newValue
     *            the default value of the flag to be used for new connections.
     * @see #useCaches
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.174 -0500", hash_original_method = "850171EE0F333E1246D13E7B06ED7B4A", hash_generated_method = "B3B107E055283354A0EB84E1277B4C31")
    
public void setDefaultUseCaches(boolean newValue) {
        defaultUseCaches = newValue;
    }

    /**
     * Sets the flag indicating whether this {@code URLConnection} allows input.
     * It cannot be set after the connection is established.
     *
     * @param newValue
     *            the new value for the flag to be set.
     * @throws IllegalAccessError
     *             if this method attempts to change the value after the
     *             connection has been already established.
     * @see #doInput
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.176 -0500", hash_original_method = "3A49AB6E406CA8641E1DA3C376F73D42", hash_generated_method = "ABAEE1D791D99ACFDC3F90F8A4C41A99")
    
public void setDoInput(boolean newValue) {
        checkNotConnected();
        this.doInput = newValue;
    }

    /**
     * Sets the flag indicating whether this {@code URLConnection} allows
     * output. It cannot be set after the connection is established.
     *
     * @param newValue
     *            the new value for the flag to be set.
     * @throws IllegalAccessError
     *             if this method attempts to change the value after the
     *             connection has been already established.
     * @see #doOutput
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.178 -0500", hash_original_method = "F9A1D9CFB149787BC9250701CAC2EC3A", hash_generated_method = "9ACA71AFE5A19544236C2D71E8590085")
    
public void setDoOutput(boolean newValue) {
        checkNotConnected();
        this.doOutput = newValue;
    }

    /**
     * Sets the point of time since when the data must be modified to be
     * transmitted. Some protocols transmit data only if it has been modified
     * more recently than a particular time. The data will be transmitted
     * regardless of its timestamp if this option is set to {@code 0}.
     *
     * @param newValue
     *            the time in milliseconds since January 1, 1970 GMT.
     * @throws IllegalStateException
     *             if this {@code URLConnection} has already been connected.
     * @see #ifModifiedSince
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.183 -0500", hash_original_method = "6F8DD71404577B87171F4310ACFD9CB3", hash_generated_method = "D88E3DB5B072B85BA8940AA5AD01088E")
    
public void setIfModifiedSince(long newValue) {
        checkNotConnected();
        this.ifModifiedSince = newValue;
    }

    /**
     * Sets the value of the specified request header field. The value will only
     * be used by the current {@code URLConnection} instance. This method can
     * only be called before the connection is established.
     *
     * @param field
     *            the request header field to be set.
     * @param newValue
     *            the new value of the specified property.
     * @throws IllegalStateException
     *             if the connection has been already established.
     * @throws NullPointerException
     *             if the parameter {@code field} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.187 -0500", hash_original_method = "EB8A856B35FAF51399B9B389D895E434", hash_generated_method = "897791F44B5080C11972AA64B89EBE20")
    
public void setRequestProperty(String field, String newValue) {
        checkNotConnected();
        if (field == null) {
            throw new NullPointerException("field == null");
        }
    }

    /**
     * Sets the flag indicating whether this connection allows to use caches or
     * not. This method can only be called prior to the connection
     * establishment.
     *
     * @param newValue
     *            the value of the flag to be set.
     * @throws IllegalStateException
     *             if this method attempts to change the flag after the
     *             connection has been established.
     * @see #useCaches
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.189 -0500", hash_original_method = "36A4E65C2F0D12499DC505123F0CC423", hash_generated_method = "AF8D26B649C92DEC0A43D17876359183")
    
public void setUseCaches(boolean newValue) {
        checkNotConnected();
        this.useCaches = newValue;
    }

    
    static class DefaultContentHandler extends java.net.ContentHandler {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.078 -0400", hash_original_method = "D9C7FF4AC457B32D0DB70E56925850DE", hash_generated_method = "D9C7FF4AC457B32D0DB70E56925850DE")
        public DefaultContentHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.204 -0500", hash_original_method = "AE84E807F7FC8D1C4CC894407353562A", hash_generated_method = "7EB331B63AA77A45D6BC981A306722BD")
        
@Override
        public Object getContent(URLConnection u) throws IOException {
            return u.getInputStream();
        }

        
    }

    /**
     * Sets the timeout value in milliseconds for establishing the connection to
     * the resource pointed by this {@code URLConnection} instance. A {@code
     * SocketTimeoutException} is thrown if the connection could not be
     * established in this time. Default is {@code 0} which stands for an
     * infinite timeout.
     *
     * @param timeout
     *            the connecting timeout in milliseconds.
     * @throws IllegalArgumentException
     *             if the parameter {@code timeout} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.191 -0500", hash_original_method = "6A558E4FD6643B6A2C9B278FD394A062", hash_generated_method = "8599EBB3492B35B0013C3C655134CE9E")
    
public void setConnectTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        this.connectTimeout = timeout;
    }

    /**
     * Returns the configured connecting timeout.
     *
     * @return the connecting timeout value in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.194 -0500", hash_original_method = "70B18BFD6BA7B76980125453BE48C7D1", hash_generated_method = "B550ADD65BE4B42202500743AF55FB65")
    
public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Sets the timeout value in milliseconds for reading from the input stream
     * of an established connection to the resource. A {@code
     * SocketTimeoutException} is thrown if the connection could not be
     * established in this time. Default is {@code 0} which stands for an
     * infinite timeout.
     *
     * @param timeout
     *            the reading timeout in milliseconds.
     * @throws IllegalArgumentException
     *             if the parameter {@code timeout} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.196 -0500", hash_original_method = "AFADA452D3B07139A9E1C4690AAC11B3", hash_generated_method = "FE4D686C5AA5BFEF2289E9D40CE9435F")
    
public void setReadTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        this.readTimeout = timeout;
    }

    /**
     * Returns the configured timeout for reading from the input stream of an
     * established connection to the resource.
     *
     * @return the reading timeout value in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.198 -0500", hash_original_method = "D3F0467D6BAB1E0CB8F37756E837EDFD", hash_generated_method = "646B3E34ABF58EF7DAFEE9727765DDFF")
    
public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Returns the string representation containing the name of this class and
     * the URL.
     *
     * @return the string representation of this {@code URLConnection} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:06.201 -0500", hash_original_method = "C85D603FFD624A90EAB88172CE67727C", hash_generated_method = "00A4330AEE9AE3EEEA21DC02C53F22B7")
    
@Override
    public String toString() {
        return getClass().getName() + ":" + url.toString();
    }
}

