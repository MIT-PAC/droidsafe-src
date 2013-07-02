package droidsafe.analyses.value.models.java.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.ValueAnalysisModelingSet;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;

public final class URL extends ValueAnalysisModeledObject {

    private Set<String> urlString = new ValueAnalysisModelingSet<String>();

    public URL(AllocNode allocNode) {
        super(allocNode);
    }

    /**
     * Creates a new URL instance by parsing {@code spec}.
     *
     * @throws MalformedURLException if {@code spec} could not be parsed as a
     *     URL.
     */
    public void _init_(Set<String> spec) throws MalformedURLException {
        this.urlString.addAll(spec);
        /*
        this((URL) null, spec, null);
        */
    }

    /**
     * Creates a new URL by resolving {@code spec} relative to {@code context}.
     *
     * @param context the URL to which {@code spec} is relative, or null for
     *     no context in which case {@code spec} must be an absolute URL.
     * @throws MalformedURLException if {@code spec} could not be parsed as a
     *     URL or has an unsupported protocol.
     */
    public void _init_(URL context, Set<String> spec) throws MalformedURLException {
        __ds__invalidate();
        /*
        this(context, spec, null);
        */
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
    public void _init_(URL context, Set<String> spec, URLStreamHandler handler) throws MalformedURLException {
        __ds__invalidate();
        /*
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
        */
    }

    /**
     * Creates a new URL of the given component parts. The URL uses the
     * protocol's default port.
     *
     * @throws MalformedURLException if the combination of all arguments do not
     *     represent a valid URL or if the protocol is invalid.
     */
    public void _init_(Set<String> protocol, Set<String> host, Set<String> file) throws MalformedURLException {
        __ds__invalidate();
        /*
        this(protocol, host, -1, file, null);
        */
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
    public void _init_(Set<String> protocol, Set<String> host, Set<ValueAnalysisInt> port, Set<String> file) throws MalformedURLException {
        __ds__invalidate();
        /*
        this(protocol, host, port, file, null);
        */
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
    public void _init_(Set<String> protocol, Set<String> host, Set<ValueAnalysisInt> port, Set<String> file, URLStreamHandler handler) throws MalformedURLException {
        __ds__invalidate();
        /*
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
        */
    }

    /**
     * Sets the stream handler factory for this VM.
     *
     * @throws Error if a URLStreamHandlerFactory has already been installed
     *     for the current VM.
     */
    public static synchronized void setURLStreamHandlerFactory(URLStreamHandlerFactory factory) {
        /*
        if (streamHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        streamHandlers.clear();
        streamHandlerFactory = factory;
        */
    }

    void fixURL(Set<ValueAnalysisBoolean> fixHost) {
        __ds__invalidate();
        /*
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
        */
    }

    /**
     * Sets the properties of this URL using the provided arguments. Only a
     * {@code URLStreamHandler} can use this method to set fields of the
     * existing URL instance. A URL is generally constant.
     */
    protected void set(Set<String> protocol, Set<String> host, Set<ValueAnalysisInt> port, Set<String> file, Set<String> ref) {
        __ds__invalidate();
        /*
        if (this.protocol == null) {
            this.protocol = protocol;
        }
        this.host = host;
        this.file = file;
        this.port = port;
        this.ref = ref;
        hashCode = 0;
        fixURL(true);
        */
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
    @Override
    public boolean equals(Object o) {
        __ds__invalidate();
        return false;
        /*
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
        */
    }

    /**
     * Returns true if this URL refers to the same resource as {@code otherURL}.
     * All URL components except the reference field are compared.
     */
    public boolean sameFile(URL otherURL) {
        __ds__invalidate();
        return false;
        /*
        return streamHandler.sameFile(this, otherURL);
        */
    }

    @Override
    public int hashCode() {
        __ds__invalidate();
        return 0;
        /*
        if (hashCode == 0) {
            hashCode = streamHandler.hashCode(this);
        }
        return hashCode;
        */
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
    void setupStreamHandler() {
        __ds__invalidate();
        /*
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
        */
    }

    /**
     * Returns the content of the resource which is referred by this URL. By
     * default this returns an {@code InputStream}, or null if the content type
     * of the response is unknown.
     */
    public final Object getContent() throws IOException {
        __ds__invalidate();
        return null;
        /*
        return openConnection().getContent();
        */
    }

    /**
     * Equivalent to {@code openConnection().getContent(types)}.
     */
    @SuppressWarnings("unchecked")
    public final Object getContent(Class[] types) throws IOException {
        __ds__invalidate();
        return null;
        /*
        return openConnection().getContent(types);
        */
    }

    /**
     * Equivalent to {@code openConnection().getInputStream(types)}.
     */
    public final InputStream openStream() throws IOException {
        __ds__invalidate();
        return null;
        /*
        return openConnection().getInputStream();
        */
    }

    /**
     * Returns a new connection to the resource referred to by this URL.
     *
     * @throws IOException if an error occurs while opening the connection.
     */
    public URLConnection openConnection() throws IOException {
        __ds__invalidate();
        return null;
        /*
        return streamHandler.openConnection(this);
        */
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
    public URLConnection openConnection(Proxy proxy) throws IOException {
        __ds__invalidate();
        return null;
        /*
        if (proxy == null) {
            throw new IllegalArgumentException("proxy == null");
        }
        return streamHandler.openConnection(this, proxy);
        */
    }

    /**
     * Returns the URI equivalent to this URL.
     *
     * @throws URISyntaxException if this URL cannot be converted into a URI.
     */
    public URI toURI() throws URISyntaxException {
        __ds__invalidate();
        return null;
        /*
        return new URI(toExternalForm());
        */
    }

    /**
     * Encodes this URL to the equivalent URI after escaping characters that are
     * not permitted by URI.
     *
     * @hide
     */
    public URI toURILenient() throws URISyntaxException {
        __ds__invalidate();
        return null;
        /*
        if (streamHandler == null) {
            throw new IllegalStateException(protocol);
        }
        return new URI(streamHandler.toExternalForm(this, true));
        */
    }

    /**
     * Returns a string containing a concise, human-readable representation of
     * this URL. The returned string is the same as the result of the method
     * {@code toExternalForm()}.
     */
    @Override
    public String toString() {
        __ds__invalidate();
        return null;
        /*
        return toExternalForm();
        */
    }

    /**
     * Returns a string containing a concise, human-readable representation of
     * this URL.
     */
    public String toExternalForm() {
        __ds__invalidate();
        return null;
        /*
        if (streamHandler == null) {
            return "unknown protocol(" + protocol + ")://" + host + file;
        }
        return streamHandler.toExternalForm(this);
        */
    }

    private void readObject(ObjectInputStream stream) throws IOException {
        __ds__invalidate();
        /*
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
        */
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        __ds__invalidate();
        /*
        s.defaultWriteObject();
        */
    }

    /** @hide */
    public int getEffectivePort() {
        __ds__invalidate();
        return 0;
        /*
        return URI.getEffectivePort(protocol, port);
        */
    }

    /**
     * Returns the protocol of this URL like "http" or "file". This is also
     * known as the scheme. The returned string is lower case.
     */
    public String getProtocol() {
        __ds__invalidate();
        return null;
        /*
        return protocol;
        */
    }

    /**
     * Returns the authority part of this URL, or null if this URL has no
     * authority.
     */
    public String getAuthority() {
        __ds__invalidate();
        return null;
        /*
        return authority;
        */
    }

    /**
     * Returns the user info of this URL, or null if this URL has no user info.
     */
    public String getUserInfo() {
        __ds__invalidate();
        return null;
        /*
        return userInfo;
        */
    }

    /**
     * Returns the host name or IP address of this URL.
     */
    public String getHost() {
        __ds__invalidate();
        return null;
        /*
        return host;
        */
    }

    /**
     * Returns the port number of this URL or {@code -1} if this URL has no
     * explicit port.
     *
     * <p>If this URL has no explicit port, connections opened using this URL
     * will use its {@link #getDefaultPort() default port}.
     */
    public int getPort() {
        __ds__invalidate();
        return 0;
        /*
        return port;
        */
    }

    /**
     * Returns the default port number of the protocol used by this URL. If no
     * default port is defined by the protocol or the {@code URLStreamHandler},
     * {@code -1} will be returned.
     *
     * @see URLStreamHandler#getDefaultPort
     */
    public int getDefaultPort() {
        __ds__invalidate();
        return 0;
        /*
        return streamHandler.getDefaultPort();
        */
    }

    /**
     * Returns the file of this URL.
     */
    public String getFile() {
        __ds__invalidate();
        return null;
        /*
        return file;
        */
    }

    /**
     * Returns the path part of this URL.
     */
    public String getPath() {
        __ds__invalidate();
        return null;
        /*
        return path;
        */
    }

    /**
     * Returns the query part of this URL, or null if this URL has no query.
     */
    public String getQuery() {
        __ds__invalidate();
        return null;
        /*
        return query;
        */
    }

    /**
     * Returns the value of the reference part of this URL, or null if this URL
     * has no reference part. This is also known as the fragment.
     */
    public String getRef() {
        __ds__invalidate();
        return null;
        /*
        return ref;
        */
    }

    /**
     * Sets the properties of this URL using the provided arguments. Only a
     * {@code URLStreamHandler} can use this method to set fields of the
     * existing URL instance. A URL is generally constant.
     */
    protected void set(Set<String> protocol, Set<String> host, Set<ValueAnalysisInt> port, Set<String> authority, Set<String> userInfo, Set<String> path, Set<String> query, Set<String> ref) {
        __ds__invalidate();
        /*
        String file = path;
        if (query != null && !query.isEmpty()) {
            file += "?" + query;
        }
        set(protocol, host, port, file, ref);
        this.authority = authority;
        this.userInfo = userInfo;
        this.path = path;
        this.query = query;
        */
    }
}
