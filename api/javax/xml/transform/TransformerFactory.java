package javax.xml.transform;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public abstract class TransformerFactory {


    /**
     * <p>Get current state of canonicalization.</p>
     *
     * @return current state canonicalization control
     */
    /*
    public boolean getCanonicalization() {
        return canonicalState;
    }
    */

    /**
     * <p>Set canonicalization control to <code>true</code> or
     * </code>false</code>.</p>
     *
     * @param state of canonicalization
     */
    /*
    public void setCanonicalization(boolean state) {
        canonicalState = state;
    }
    */

    /**
     * Returns Android's implementation of {@code TransformerFactory}. Unlike
     * other Java implementations, this method does not consult system
     * properties, properties files, or the services API.
     *
     * @throws TransformerFactoryConfigurationError never. Included for API
     *     compatibility with other Java implementations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.647 -0500", hash_original_method = "3E8CF5BE620708FB4FC89BA0D72DFBF3", hash_generated_method = "E9E99C08522096EAB8AEE9B1103F39F1")
    
public static TransformerFactory newInstance()
            throws TransformerFactoryConfigurationError {
        String className = "org.apache.xalan.processor.TransformerFactoryImpl";
        try {
            return (TransformerFactory) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new NoClassDefFoundError(className);
        }
    }

    /**
     * Returns an instance of the named implementation of {@code TransformerFactory}.
     *
     * @throws TransformerFactoryConfigurationError if {@code factoryClassName} is not available or
     *     cannot be instantiated.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.649 -0500", hash_original_method = "6FA4A0F1E073073328F38FFF57DD4777", hash_generated_method = "7D3E50DC537C6FEC101FA796E7EDD515")
    
public static TransformerFactory newInstance(String factoryClassName, ClassLoader classLoader)
            throws TransformerFactoryConfigurationError {
        if (factoryClassName == null) {
            throw new TransformerFactoryConfigurationError("factoryClassName == null");
        }
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            Class<?> type = classLoader != null
                    ? classLoader.loadClass(factoryClassName)
                    : Class.forName(factoryClassName);
            return (TransformerFactory) type.newInstance();
        } catch (ClassNotFoundException e) {
            throw new TransformerFactoryConfigurationError(e);
        } catch (InstantiationException e) {
            throw new TransformerFactoryConfigurationError(e);
        } catch (IllegalAccessException e) {
            throw new TransformerFactoryConfigurationError(e);
        }
    }

    /**
     * Default constructor is protected on purpose.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.644 -0500", hash_original_method = "882398A945C9CF8F9D3ABF21E7DFDBFC", hash_generated_method = "BA555873591AEA4A7BD8800DE10FD6DF")
    
protected TransformerFactory() { }

    /**
     * <p>Process the <code>Source</code> into a <code>Transformer</code>
     * <code>Object</code>.  The <code>Source</code> is an XSLT document that
     * conforms to <a href="http://www.w3.org/TR/xslt">
     * XSL Transformations (XSLT) Version 1.0</a>.  Care must
     * be taken not to use this <code>Transformer</code> in multiple
     * <code>Thread</code>s running concurrently.
     * Different <code>TransformerFactories</code> can be used concurrently by
     * different <code>Thread</code>s.</p>
     *
     * @param source <code>Source </code> of XSLT document used to create
     *   <code>Transformer</code>.
     *   Examples of XML <code>Source</code>s include
     *   {@link javax.xml.transform.stream.StreamSource StreamSource},
     *   {@link javax.xml.transform.sax.SAXSource SAXSource} and
     *   {@link javax.xml.transform.dom.DOMSource DOMSource}.
     *
     * @return A <code>Transformer</code> object that may be used to perform
     *   a transformation in a single <code>Thread</code>, never
     *   <code>null</code>.
     *
     * @throws TransformerConfigurationException Thrown if there are errors when
     *    parsing the <code>Source</code> or it is not possible to create a
     *   <code>Transformer</code> instance.
     *
     * @see <a href="http://www.w3.org/TR/xslt">
     *   XSL Transformations (XSLT) Version 1.0</a>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.652 -0500", hash_original_method = "7CFFE0D07DE19EFE36A2168B5E01BE0F", hash_generated_method = "7E298EB6618BE31C32B2A96DFF5964F5")
    
public abstract Transformer newTransformer(Source source)
        throws TransformerConfigurationException;

    /**
     * <p>Create a new <code>Transformer</code> that performs a copy
     * of the <code>Source</code> to the <code>Result</code>.
     * i.e. the "<em>identity transform</em>".</p>
     *
     * @return A Transformer object that may be used to perform a transformation
     * in a single thread, never null.
     *
     * @exception TransformerConfigurationException Thrown if it is not
     *   possible to create a <code>Transformer</code> instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.654 -0500", hash_original_method = "A7E101C00A1C217438F3BE7E289CE40B", hash_generated_method = "A1935FF0124FA744285AB7B7640F5A3C")
    
public abstract Transformer newTransformer()
        throws TransformerConfigurationException;

    /**
     * Process the Source into a Templates object, which is a
     * a compiled representation of the source. This Templates object
     * may then be used concurrently across multiple threads.  Creating
     * a Templates object allows the TransformerFactory to do detailed
     * performance optimization of transformation instructions, without
     * penalizing runtime transformation.
     *
     * @param source An object that holds a URL, input stream, etc.
     *
     * @return A Templates object capable of being used for transformation
     * purposes, never null.
     *
     * @exception TransformerConfigurationException May throw this during the
     * parse when it is constructing the Templates object and fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.656 -0500", hash_original_method = "6DDA9A6B38EBB085BA9246E69DC7D314", hash_generated_method = "C98609D8472335F319F5C31E8519E651")
    
public abstract Templates newTemplates(Source source)
        throws TransformerConfigurationException;

    /**
     * <p>Get the stylesheet specification(s) associated with the
     * XML <code>Source</code> document via the
     * <a href="http://www.w3.org/TR/xml-stylesheet/">
     * xml-stylesheet processing instruction</a> that match the given criteria.
     * Note that it is possible to return several stylesheets, in which case
     * they are applied as if they were a list of imports or cascades in a
     * single stylesheet.</p>
     *
     * @param source The XML source document.
     * @param media The media attribute to be matched.  May be null, in which
     *      case the preferred templates will be used (i.e. alternate = no).
     * @param title The value of the title attribute to match.  May be null.
     * @param charset The value of the charset attribute to match.  May be null.
     *
     * @return A <code>Source</code> <code>Object</code> suitable for passing
     *   to the <code>TransformerFactory</code>.
     *
     * @throws TransformerConfigurationException An <code>Exception</code>
     *   is thrown if an error occurs during parsing of the
     *   <code>source</code>.
     *
     * @see <a href="http://www.w3.org/TR/xml-stylesheet/">
     *   Associating Style Sheets with XML documents Version 1.0</a>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.658 -0500", hash_original_method = "AC64DFCF0A27375D6209F59A727182FD", hash_generated_method = "DCC4D85A37E001CFAD8CAA59DC5E4213")
    
public abstract Source getAssociatedStylesheet(
        Source source,
        String media,
        String title,
        String charset)
        throws TransformerConfigurationException;

    /**
     * Set an object that is used by default during the transformation
     * to resolve URIs used in document(), xsl:import, or xsl:include.
     *
     * @param resolver An object that implements the URIResolver interface,
     * or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.661 -0500", hash_original_method = "68C7DB370C1ABE5011980426FA88EE59", hash_generated_method = "E0850D782E0B8F1232A8CCE32737D8FE")
    
public abstract void setURIResolver(URIResolver resolver);

    /**
     * Get the object that is used by default during the transformation
     * to resolve URIs used in document(), xsl:import, or xsl:include.
     *
     * @return The URIResolver that was set with setURIResolver.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.663 -0500", hash_original_method = "44193455267193A7FE520C9B388F539C", hash_generated_method = "34A19FFFC82864A6AE939F9AE846EC5E")
    
public abstract URIResolver getURIResolver();

    //======= CONFIGURATION METHODS =======

    /**
     * <p>Set a feature for this <code>TransformerFactory</code> and <code>Transformer</code>s
     * or <code>Template</code>s created by this factory.</p>
     *
     * <p>
     * Feature names are fully qualified {@link java.net.URI}s.
     * Implementations may define their own features.
     * An {@link TransformerConfigurationException} is thrown if this <code>TransformerFactory</code> or the
     * <code>Transformer</code>s or <code>Template</code>s it creates cannot support the feature.
     * It is possible for an <code>TransformerFactory</code> to expose a feature value but be unable to change its state.
     * </p>
     *
     * <p>All implementations are required to support the {@link javax.xml.XMLConstants#FEATURE_SECURE_PROCESSING} feature.
     * When the feature is:</p>
     * <ul>
     *   <li>
     *     <code>true</code>: the implementation will limit XML processing to conform to implementation limits
     *     and behave in a secure fashion as defined by the implementation.
     *     Examples include resolving user defined style sheets and functions.
     *     If XML processing is limited for security reasons, it will be reported via a call to the registered
     *     {@link ErrorListener#fatalError(TransformerException exception)}.
     *     See {@link  #setErrorListener(ErrorListener listener)}.
     *   </li>
     *   <li>
     *     <code>false</code>: the implementation will processing XML according to the XML specifications without
     *     regard to possible implementation limits.
     *   </li>
     * </ul>
     *
     * @param name Feature name.
     * @param value Is feature state <code>true</code> or <code>false</code>.
     *
     * @throws TransformerConfigurationException if this <code>TransformerFactory</code>
     *   or the <code>Transformer</code>s or <code>Template</code>s it creates cannot support this feature.
     * @throws NullPointerException If the <code>name</code> parameter is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.666 -0500", hash_original_method = "40FCB3E3CD3FB013549732CEBE9C1204", hash_generated_method = "D34E0E0FA1D28E259D6538C3B1416EB0")
    
public abstract void setFeature(String name, boolean value)
        throws TransformerConfigurationException;

    /**
     * Look up the value of a feature.
     *
     * <p>
     * Feature names are fully qualified {@link java.net.URI}s.
     * Implementations may define their own features.
     * <code>false</code> is returned if this <code>TransformerFactory</code> or the
     * <code>Transformer</code>s or <code>Template</code>s it creates cannot support the feature.
     * It is possible for an <code>TransformerFactory</code> to expose a feature value but be unable to change its state.
     * </p>
     *
     * @param name Feature name.
     *
     * @return The current state of the feature, <code>true</code> or <code>false</code>.
     *
     * @throws NullPointerException If the <code>name</code> parameter is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.668 -0500", hash_original_method = "CD1E8A8E5BE38D8FE83E386A1AF3EF5D", hash_generated_method = "044D77551BF25958775D184470F6A817")
    
public abstract boolean getFeature(String name);

    /**
     * Allows the user to set specific attributes on the underlying
     * implementation.  An attribute in this context is defined to
     * be an option that the implementation provides.
     * An <code>IllegalArgumentException</code> is thrown if the underlying
     * implementation doesn't recognize the attribute.
     *
     * @param name The name of the attribute.
     * @param value The value of the attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.676 -0500", hash_original_method = "1F863C3C4F056307A6C164B0CC924493", hash_generated_method = "AFB2A798D58B4DB15FE29BA9093D5023")
    
public abstract void setAttribute(String name, Object value);

    /**
     * Allows the user to retrieve specific attributes on the underlying
     * implementation.
     * An <code>IllegalArgumentException</code> is thrown if the underlying
     * implementation doesn't recognize the attribute.
     *
     * @param name The name of the attribute.
     * @return value The value of the attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.678 -0500", hash_original_method = "FCC4022F9438D02A03EAF9E0461B0B3B", hash_generated_method = "9607117A4C58FE37636FB3C445473F6C")
    
public abstract Object getAttribute(String name);

    /**
     * Set the error event listener for the TransformerFactory, which
     * is used for the processing of transformation instructions,
     * and not for the transformation itself.
     * An <code>IllegalArgumentException</code> is thrown if the
     * <code>ErrorListener</code> listener is <code>null</code>.
     *
     * @param listener The new error listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.681 -0500", hash_original_method = "7CF8399D4B45816FFBAD8DB2D1BBD730", hash_generated_method = "8FF808FAAE24D38EC3BAD61ABE5FE9E5")
    
public abstract void setErrorListener(ErrorListener listener);

    /**
     * Get the error event handler for the TransformerFactory.
     *
     * @return The current error handler, which should never be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.683 -0500", hash_original_method = "A69DC36A610F5E9CC88DC70E49C46EE7", hash_generated_method = "AE4BF0F77687929F0842F0F0E1A9FE70")
    
public abstract ErrorListener getErrorListener();

    
}

