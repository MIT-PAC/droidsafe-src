package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

import libcore.net.http.HttpHandler;
import libcore.net.http.HttpsHandler;
import libcore.net.url.FileHandler;
import libcore.net.url.FtpHandler;
import libcore.net.url.JarHandler;
import libcore.net.url.UrlUtils;

public final class URL implements Serializable {

    /**
     * Sets the stream handler factory for this VM.
     *
     * @throws Error if a URLStreamHandlerFactory has already been installed
     *     for the current VM.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.773 -0500", hash_original_method = "E264CD67F28CEB420BDFAF4955BAAC34", hash_generated_method = "D41B6D48B40FB3DCB088E4959FD81241")
    
public static synchronized void setURLStreamHandlerFactory(URLStreamHandlerFactory factory) {
        if (streamHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        streamHandlers.clear();
        streamHandlerFactory = factory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.739 -0500", hash_original_field = "6827AAAC87B591CEC175FEC8C111BA73", hash_generated_field = "8D4046C0B22D26C3D18782292CFAEA41")

    private static final long serialVersionUID = -7627629688361524110L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.741 -0500", hash_original_field = "C1802D278A338655A9B7C39728F4AFD1", hash_generated_field = "7C5EE8C1A882C933CC017CE2A46222A0")

    private static URLStreamHandlerFactory streamHandlerFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.744 -0500", hash_original_field = "6456377C042EB67ED985FD40E1A4A79C", hash_generated_field = "16539CC8BECB892A33EEA156DBF8E5B0")

    private static final Hashtable<String, URLStreamHandler> streamHandlers
            = new Hashtable<String, URLStreamHandler>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.747 -0500", hash_original_field = "DE3F28962485CE99CA97D0A480B93596", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    @DSVAModeled
    private String protocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.749 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "AC50B8E8CEC0F955316DE9A8EC0AB5AE")

    @DSVAModeled
    private String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.752 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    @DSVAModeled
    private String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.754 -0500", hash_original_field = "BAF684EECB20D799A434AFCF1B13F01D", hash_generated_field = "F51DF048A4B5B6B4A61A3652544F4757")

    private int port = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.756 -0500", hash_original_field = "71FDB50C85529723B422EF50FDC30702", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    @DSVAModeled
    private String file;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.758 -0500", hash_original_field = "F33091824EB9F51BA1B1D156BD282F5F", hash_generated_field = "4B296BDB98B3E9CBEDF6971A25928318")

    @DSVAModeled
    private String ref;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.761 -0500", hash_original_field = "10F5F4BA00300524BD223470F05A568F", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    @DSVAModeled
    private transient String userInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.763 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    @DSVAModeled
    private transient String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.765 -0500", hash_original_field = "088250EB717186C03CE550061F0A72FD", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    @DSVAModeled
    private transient String query;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.768 -0500", hash_original_field = "3EC59952C66038F01917A6F0E7AE443B", hash_generated_field = "9DB4BB741418299310AFA5D983E7DA2C")

    transient URLStreamHandler streamHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.770 -0500", hash_original_field = "5A19588B577A4926772CAE314F19FADE", hash_generated_field = "24254DF41EE7E0D088838123A7BE5D39")

    private transient int hashCode;

    /**
     * Creates a new URL instance by parsing {@code spec}.
     *
     * @throws MalformedURLException if {@code spec} could not be parsed as a
     *     URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.776 -0500", hash_original_method = "121BE8263BD1C356B2FE90A678407E92", hash_generated_method = "957AACC1D575B1FFFB563B71D8404E20")
    
public URL(String spec) throws MalformedURLException {
        this((URL) null, spec, null);
    }

    /**
     * Creates a new URL by resolving {@code spec} relative to {@code context}.
     *
     * @param context the URL to which {@code spec} is relative, or null for
     *     no context in which case {@code spec} must be an absolute URL.
     * @throws MalformedURLException if {@code spec} could not be parsed as a
     *     URL or has an unsupported protocol.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.779 -0500", hash_original_method = "472053565B13D456EDCEBEA98F287F95", hash_generated_method = "214AF839F51D69EA16CC67A7694133C0")
    
public URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, null);
    }

    /**
     * Creates a new URL by resolving {@code spec} relative to {@code context}.
     *
     * @param context the URL to which {@code spec} is relative, or null for
     *     no context in which case {@code spec} must be an absolute URL.
     * @param handler the stream handler for this URL, or null for the
     *     protocol's default stream handler.
     * @throws MalformedURLException if the given string {@code spec} could not
     *     be parsed as a URL or an invalid protocol has been found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.782 -0500", hash_original_method = "D8E146F1F2E4ED207D7672129A3654D5", hash_generated_method = "81FB4A355BD0EB1A21C30E10A91F8FA2")
    
public URL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        if (spec == null) {
            throw new MalformedURLException();
        }
        if (handler != null) {
            streamHandler = handler;
        }
        spec = spec.trim();

        protocol = UrlUtils.getSchemePrefix(spec);
        int schemeSpecificPartStart = protocol != null ? (protocol.length() + 1) : 0;

        // If the context URL has a different protocol, discard it because we can't use it.
        if (protocol != null && context != null && !protocol.equals(context.protocol)) {
            context = null;
        }

        // Inherit from the context URL if it exists.
        if (context != null) {
            set(context.protocol, context.getHost(), context.getPort(), context.getAuthority(),
                    context.getUserInfo(), context.getPath(), context.getQuery(),
                    context.getRef());
            if (streamHandler == null) {
                streamHandler = context.streamHandler;
            }
        } else if (protocol == null) {
            throw new MalformedURLException("Protocol not found: " + spec);
        }

        if (streamHandler == null) {
            setupStreamHandler();
            if (streamHandler == null) {
                throw new MalformedURLException("Unknown protocol: " + protocol);
            }
        }

        // Parse the URL. If the handler throws any exception, throw MalformedURLException instead.
        try {
            streamHandler.parseURL(this, spec, schemeSpecificPartStart, spec.length());
        } catch (Exception e) {
            throw new MalformedURLException(e.toString());
        }
    }

    /**
     * Creates a new URL of the given component parts. The URL uses the
     * protocol's default port.
     *
     * @throws MalformedURLException if the combination of all arguments do not
     *     represent a valid URL or if the protocol is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.785 -0500", hash_original_method = "216BAC89605FCA377BB0AADBB6E2A8AC", hash_generated_method = "3077633676B6AE40756F1F933FD918E4")
    
public URL(String protocol, String host, String file) throws MalformedURLException {
        this(protocol, host, -1, file, null);
    }

    /**
     * Creates a new URL of the given component parts. The URL uses the
     * protocol's default port.
     *
     * @param host the host name or IP address of the new URL.
     * @param port the port, or {@code -1} for the protocol's default port.
     * @param file the name of the resource.
     * @throws MalformedURLException if the combination of all arguments do not
     *     represent a valid URL or if the protocol is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.787 -0500", hash_original_method = "9AD76E183D70EDC4767A9EAC128427AE", hash_generated_method = "7F84BB36FF6A492699D9A50DEDC1FED1")
    
public URL(String protocol, String host, int port, String file) throws MalformedURLException {
        this(protocol, host, port, file, null);
    }

    /**
     * Creates a new URL of the given component parts. The URL uses the
     * protocol's default port.
     *
     * @param host the host name or IP address of the new URL.
     * @param port the port, or {@code -1} for the protocol's default port.
     * @param file the name of the resource.
     * @param handler the stream handler for this URL, or null for the
     *     protocol's default stream handler.
     * @throws MalformedURLException if the combination of all arguments do not
     *     represent a valid URL or if the protocol is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.791 -0500", hash_original_method = "D56485CA0554FF67A28005CBDB936EDB", hash_generated_method = "43F03066ACCDCA13567DF29511D1C59A")
    
public URL(String protocol, String host, int port, String file,
            URLStreamHandler handler) throws MalformedURLException {
        if (port < -1) {
            throw new MalformedURLException("port < -1: " + port);
        }
        if (protocol == null) {
            throw new NullPointerException("protocol == null");
        }

        // Wrap IPv6 addresses in square brackets if they aren't already.
        if (host != null && host.contains(":") && host.charAt(0) != '[') {
            host = "[" + host + "]";
        }

        this.protocol = protocol;
        this.host = host;
        this.port = port;

        file = UrlUtils.authoritySafePath(host, file);

        // Set the fields from the arguments. Handle the case where the
        // passed in "file" includes both a file and a reference part.
        int hash = file.indexOf("#");
        if (hash != -1) {
            this.file = file.substring(0, hash);
            this.ref = file.substring(hash + 1);
        } else {
            this.file = file;
        }
        fixURL(false);

        // Set the stream handler for the URL either to the handler
        // argument if it was specified, or to the default for the
        // receiver's protocol if the handler was null.
        if (handler == null) {
            setupStreamHandler();
            if (streamHandler == null) {
                throw new MalformedURLException("Unknown protocol: " + protocol);
            }
        } else {
            streamHandler = handler;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.793 -0500", hash_original_method = "0200B051ED19728512FC68E42BCAEC0F", hash_generated_method = "0200B051ED19728512FC68E42BCAEC0F")
    
void fixURL(boolean fixHost) {
        int index;
        if (host != null && host.length() > 0) {
            authority = host;
            if (port != -1) {
                authority = authority + ":" + port;
            }
        }
        if (fixHost) {
            if (host != null && (index = host.lastIndexOf('@')) > -1) {
                userInfo = host.substring(0, index);
                host = host.substring(index + 1);
            } else {
                userInfo = null;
            }
        }
        if (file != null && (index = file.indexOf('?')) > -1) {
            query = file.substring(index + 1);
            path = file.substring(0, index);
        } else {
            query = null;
            path = file;
        }
    }

    /**
     * Sets the properties of this URL using the provided arguments. Only a
     * {@code URLStreamHandler} can use this method to set fields of the
     * existing URL instance. A URL is generally constant.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.796 -0500", hash_original_method = "2A0889AB616D5EC9F0D1FFB4406777A2", hash_generated_method = "AC21E5CF7CF0190B72BBA713681621AB")
    
protected void set(String protocol, String host, int port, String file, String ref) {
        if (this.protocol == null) {
            this.protocol = protocol;
        }
        this.host = host;
        this.file = file;
        this.port = port;
        this.ref = ref;
        hashCode = 0;
        fixURL(true);
    }

    /**
     * Returns true if this URL equals {@code o}. URLs are equal if they have
     * the same protocol, host, port, file, and reference.
     *
     * <h3>Network I/O Warning</h3>
     * <p>Some implementations of URL.equals() resolve host names over the
     * network. This is problematic:
     * <ul>
     * <li><strong>The network may be slow.</strong> Many classes, including
     * core collections like {@link java.util.Map Map} and {@link java.util.Set
     * Set} expect that {@code equals} and {@code hashCode} will return quickly.
     * By violating this assumption, this method posed potential performance
     * problems.
     * <li><strong>Equal IP addresses do not imply equal content.</strong>
     * Virtual hosting permits unrelated sites to share an IP address. This
     * method could report two otherwise unrelated URLs to be equal because
     * they're hosted on the same server.</li>
     * <li><strong>The network many not be available.</strong> Two URLs could be
     * equal when a network is available and unequal otherwise.</li>
     * <li><strong>The network may change.</strong> The IP address for a given
     * host name varies by network and over time. This is problematic for mobile
     * devices. Two URLs could be equal on some networks and unequal on
     * others.</li>
     * </ul>
     * <p>This problem is fixed in Android in the Ice Cream Sandwich release. In
     * that release, URLs are only equal if their host names are equal (ignoring
     * case).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.799 -0500", hash_original_method = "90B240523657DD4FC87B9440FE931EC1", hash_generated_method = "E74F9CB753CD3DB5F05CA87211C5ED9B")
    
@Override public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        return streamHandler.equals(this, (URL) o);
    }

    /**
     * Returns true if this URL refers to the same resource as {@code otherURL}.
     * All URL components except the reference field are compared.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.801 -0500", hash_original_method = "0A94C2599C7A34FBFDE0162C017FE126", hash_generated_method = "FA892CC0A5F854B974AF09B0080B2936")
    
public boolean sameFile(URL otherURL) {
        return streamHandler.sameFile(this, otherURL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.804 -0500", hash_original_method = "83584D9C6686BC529C911ABE882D39AB", hash_generated_method = "231C6ADC153005536655917E91567525")
    
@Override public int hashCode() {
        if (hashCode == 0) {
            hashCode = streamHandler.hashCode(this);
        }
        return hashCode;
    }

    /**
     * Sets the receiver's stream handler to one which is appropriate for its
     * protocol.
     *
     * <p>Note that this will overwrite any existing stream handler with the new
     * one. Senders must check if the streamHandler is null before calling the
     * method if they do not want this behavior (a speed optimization).
     *
     * @throws MalformedURLException if no reasonable handler is available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.807 -0500", hash_original_method = "7ED1A4A4DB26C9983DC69C2C091F1C50", hash_generated_method = "E036A7AC84D6D8EE280C732DEE29FF50")
    
void setupStreamHandler() {
        // Check for a cached (previously looked up) handler for
        // the requested protocol.
        streamHandler = streamHandlers.get(protocol);
        if (streamHandler != null) {
            return;
        }

        // If there is a stream handler factory, then attempt to
        // use it to create the handler.
        if (streamHandlerFactory != null) {
            streamHandler = streamHandlerFactory.createURLStreamHandler(protocol);
            if (streamHandler != null) {
                streamHandlers.put(protocol, streamHandler);
                return;
            }
        }

        // Check if there is a list of packages which can provide handlers.
        // If so, then walk this list looking for an applicable one.
        String packageList = System.getProperty("java.protocol.handler.pkgs");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (packageList != null && contextClassLoader != null) {
            for (String packageName : packageList.split("\\|")) {
                String className = packageName + "." + protocol + ".Handler";
                try {
                    Class<?> c = contextClassLoader.loadClass(className);
                    streamHandler = (URLStreamHandler) c.newInstance();
                    if (streamHandler != null) {
                        streamHandlers.put(protocol, streamHandler);
                    }
                    return;
                } catch (IllegalAccessException ignored) {
                } catch (InstantiationException ignored) {
                } catch (ClassNotFoundException ignored) {
                }
            }
        }

        // Fall back to a built-in stream handler if the user didn't supply one
        if (protocol.equals("file")) {
            streamHandler = new FileHandler();
        } else if (protocol.equals("ftp")) {
            streamHandler = new FtpHandler();
        } else if (protocol.equals("http")) {
            streamHandler = new HttpHandler();
        } else if (protocol.equals("https")) {
            streamHandler = new HttpsHandler();
        } else if (protocol.equals("jar")) {
            streamHandler = new JarHandler();
        }
        if (streamHandler != null) {
            streamHandlers.put(protocol, streamHandler);
        }
    }

    /**
     * Returns the content of the resource which is referred by this URL. By
     * default this returns an {@code InputStream}, or null if the content type
     * of the response is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.809 -0500", hash_original_method = "D20F85DA45DCC6A1B9E0395104EBE2B6", hash_generated_method = "87CD5158EDA208789878ECB26921E749")
    
public final Object getContent() throws IOException {
        return openConnection().getContent();
    }

    /**
     * Equivalent to {@code openConnection().getContent(types)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.811 -0500", hash_original_method = "D92AC8AC4808B4044341B9D346CCCA3C", hash_generated_method = "2449522D744084AA01B4B412F82BEEE0")
    
@SuppressWarnings("unchecked") // Param not generic in spec
    public final Object getContent(Class[] types) throws IOException {
        return openConnection().getContent(types);
    }

    /**
     * Equivalent to {@code openConnection().getInputStream(types)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.814 -0500", hash_original_method = "EA6B256CF4DB87F83CFE1379BEA78831", hash_generated_method = "20204A59BCA9CBCE334EE2309DE1C2D7")
    
public final InputStream openStream() throws IOException {
        return openConnection().getInputStream();
    }

    /**
     * Returns a new connection to the resource referred to by this URL.
     *
     * @throws IOException if an error occurs while opening the connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.817 -0500", hash_original_method = "DDCF57687ACF51357E563F1083DC4261", hash_generated_method = "28C15B77EC7816C10902E4F13397C53B")
    
public URLConnection openConnection() throws IOException {
        return streamHandler.openConnection(this);
    }

    /**
     * Returns a new connection to the resource referred to by this URL.
     *
     * @param proxy the proxy through which the connection will be established.
     * @throws IOException if an I/O error occurs while opening the connection.
     * @throws IllegalArgumentException if the argument proxy is null or of is
     *     an invalid type.
     * @throws UnsupportedOperationException if the protocol handler does not
     *     support opening connections through proxies.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.819 -0500", hash_original_method = "CB72409718452D46955A0A85FC179645", hash_generated_method = "9FFC82767BCEE2CD44BAA6101C4AB2EB")
    
public URLConnection openConnection(Proxy proxy) throws IOException {
        if (proxy == null) {
            throw new IllegalArgumentException("proxy == null");
        }
        return streamHandler.openConnection(this, proxy);
    }

    /**
     * Returns the URI equivalent to this URL.
     *
     * @throws URISyntaxException if this URL cannot be converted into a URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.822 -0500", hash_original_method = "1E43ADB2B24E4AEE234C287749830ABE", hash_generated_method = "BF31A384C12F3C95702A05E5A660934A")
    
public URI toURI() throws URISyntaxException {
        return new URI(toExternalForm());
    }

    /**
     * Encodes this URL to the equivalent URI after escaping characters that are
     * not permitted by URI.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.824 -0500", hash_original_method = "9819CA3EECC28CF10D8C0CAB99E6CDCB", hash_generated_method = "D55A4A5BF8356B88C6FCC1D691E3DDF7")
    
public URI toURILenient() throws URISyntaxException {
        if (streamHandler == null) {
            throw new IllegalStateException(protocol);
        }
        return new URI(streamHandler.toExternalForm(this, true));
    }

    /**
     * Returns a string containing a concise, human-readable representation of
     * this URL. The returned string is the same as the result of the method
     * {@code toExternalForm()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.827 -0500", hash_original_method = "9D75BD75136BEBAB4AE2F806E85803AD", hash_generated_method = "F41EB6D03A99F60D56FE9D7C7FCBDF03")
    
@Override public String toString() {
        return toExternalForm();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.975 -0400", hash_original_method = "6763BB94BC9C65378EF7195BF94F5BED", hash_generated_method = "ACF3E5B31DE51D0A38B73B367D8CC436")
    public String toExternalForm() {
        if(streamHandler == null)        
        {
String var4719CC78653EB410AA0D53C0ADA4DFAC_317018758 =             "unknown protocol(" + protocol + ")://" + host + file;
            var4719CC78653EB410AA0D53C0ADA4DFAC_317018758.addTaint(taint);
            return var4719CC78653EB410AA0D53C0ADA4DFAC_317018758;
        } //End block
String varDCCA36446C90D2AF904BB9935AD90339_445251136 =         streamHandler.toExternalForm(this);
        varDCCA36446C90D2AF904BB9935AD90339_445251136.addTaint(taint);
        return varDCCA36446C90D2AF904BB9935AD90339_445251136;
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //return "unknown protocol(" + protocol + ")://" + host + file;
        //}
        //return streamHandler.toExternalForm(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.832 -0500", hash_original_method = "75E256B9492C6227D987E1CACFC70E15", hash_generated_method = "D9AF24E0BCDF7E6260DB709F2833ED63")
    
private void readObject(ObjectInputStream stream) throws IOException {
        try {
            stream.defaultReadObject();
            if (host != null && authority == null) {
                fixURL(true);
            } else if (authority != null) {
                int index;
                if ((index = authority.lastIndexOf('@')) > -1) {
                    userInfo = authority.substring(0, index);
                }
                if (file != null && (index = file.indexOf('?')) > -1) {
                    query = file.substring(index + 1);
                    path = file.substring(0, index);
                } else {
                    path = file;
                }
            }
            setupStreamHandler();
            if (streamHandler == null) {
                throw new IOException("Unknown protocol: " + protocol);
            }
            hashCode = 0; // necessary until http://b/4471249 is fixed
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.834 -0500", hash_original_method = "CCBF13D66B2182AA6C1A2589205C2944", hash_generated_method = "C4FE349242269BA033E70DA693229D12")
    
private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.836 -0500", hash_original_method = "89A7E9DBD8F7AF35FA9A39C4922A8C55", hash_generated_method = "6213020F1E5035EB15F334A843DC1554")
    
public int getEffectivePort() {
        return URI.getEffectivePort(protocol, port);
    }

    /**
     * Returns the protocol of this URL like "http" or "file". This is also
     * known as the scheme. The returned string is lower case.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.839 -0500", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "777D707579F7653F7954BDBD83E0BBF8")
    
public String getProtocol() {
        return protocol;
    }

    /**
     * Returns the authority part of this URL, or null if this URL has no
     * authority.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.841 -0500", hash_original_method = "36971585CF0AC7121D34C5DBA5E7B5AD", hash_generated_method = "E75FA61151DC0C76513A5196E9624AC4")
    
public String getAuthority() {
        return authority;
    }

    /**
     * Returns the user info of this URL, or null if this URL has no user info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.844 -0500", hash_original_method = "C7599F6C2A9D16B1F9E84177D4C93D75", hash_generated_method = "17BDDCE7A19516BB15D091E4C2A176CA")
    
public String getUserInfo() {
        return userInfo;
    }

    /**
     * Returns the host name or IP address of this URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.846 -0500", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "1B655222E0C0F88C57DF58BCA9BFA498")
    
public String getHost() {
        return host;
    }

    /**
     * Returns the port number of this URL or {@code -1} if this URL has no
     * explicit port.
     *
     * <p>If this URL has no explicit port, connections opened using this URL
     * will use its {@link #getDefaultPort() default port}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.848 -0500", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8D4984D37D0017078DF4701090E35F25")
    
public int getPort() {
        return port;
    }

    /**
     * Returns the default port number of the protocol used by this URL. If no
     * default port is defined by the protocol or the {@code URLStreamHandler},
     * {@code -1} will be returned.
     *
     * @see URLStreamHandler#getDefaultPort
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.851 -0500", hash_original_method = "7E7EF83BCD62492BD0A03823F89518D0", hash_generated_method = "0A09D8AE5151E369189C0C7B0C29D562")
    
public int getDefaultPort() {
        return streamHandler.getDefaultPort();
    }

    /**
     * Returns the file of this URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.853 -0500", hash_original_method = "D4C7450F6A022BC4DF89D66487C9A55A", hash_generated_method = "D8CD1E2528FA75545C0B44B1301B41F0")
    
public String getFile() {
        return file;
    }

    /**
     * Returns the path part of this URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.855 -0500", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "685DA06B3205BF0988B63E7E0C7CEB6C")
    
public String getPath() {
        return path;
    }

    /**
     * Returns the query part of this URL, or null if this URL has no query.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.857 -0500", hash_original_method = "1E279BC97111B7B33A732EF157351512", hash_generated_method = "2AAA8449DD21269C5BC425219F6CEB5A")
    
public String getQuery() {
        return query;
    }

    /**
     * Returns the value of the reference part of this URL, or null if this URL
     * has no reference part. This is also known as the fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.859 -0500", hash_original_method = "3AAC0179CDFA195C747754E7ED20A392", hash_generated_method = "348A7746E1620891E45DA4B06A2F61A1")
    
public String getRef() {
        return ref;
    }

    /**
     * Sets the properties of this URL using the provided arguments. Only a
     * {@code URLStreamHandler} can use this method to set fields of the
     * existing URL instance. A URL is generally constant.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:10.861 -0500", hash_original_method = "1BAF8E8ECD99ADEA9022FFFFA6473F49", hash_generated_method = "8FCC00B35BBD4936BCDD3B32C3A18E99")
    
protected void set(String protocol, String host, int port, String authority, String userInfo,
            String path, String query, String ref) {
        String file = path;
        if (query != null && !query.isEmpty()) {
            file += "?" + query;
        }
        set(protocol, host, port, file, ref);
        this.authority = authority;
        this.userInfo = userInfo;
        this.path = path;
        this.query = query;
    }
}

