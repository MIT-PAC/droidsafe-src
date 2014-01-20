package javax.xml.transform;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Properties;

public abstract class Transformer {

    /**
     * Default constructor is protected on purpose.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.879 -0500", hash_original_method = "962E0FC22D29E2A2CD7F27A68548CC24", hash_generated_method = "EB6A0141A976D3DFFAA6BC425289601A")
    
protected Transformer() { }

    /**
     * <p>Reset this <code>Transformer</code> to its original configuration.</p>
     *
     * <p><code>Transformer</code> is reset to the same state as when it was created with
     * {@link TransformerFactory#newTransformer()},
     * {@link TransformerFactory#newTransformer(Source source)} or
     * {@link Templates#newTransformer()}.
     * <code>reset()</code> is designed to allow the reuse of existing <code>Transformer</code>s
     * thus saving resources associated with the creation of new <code>Transformer</code>s.</p>
     *
     * <p>The reset <code>Transformer</code> is not guaranteed to have the same {@link URIResolver}
     * or {@link ErrorListener} <code>Object</code>s, e.g. {@link Object#equals(Object obj)}.
     * It is guaranteed to have a functionally equal <code>URIResolver</code>
     * and <code>ErrorListener</code>.</p>
     *
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.881 -0500", hash_original_method = "B0AC372F01A204B1818DEED996AF8866", hash_generated_method = "51E0ACD83DE530A9390A27E5EA07CFB8")
    
public void reset() {

        // implementors should override this method
        throw new UnsupportedOperationException(
            "This Transformer, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
    }

    /**
     * <p>Transform the XML <code>Source</code> to a <code>Result</code>.
     * Specific transformation behavior is determined by the settings of the
     * <code>TransformerFactory</code> in effect when the
     * <code>Transformer</code> was instantiated and any modifications made to
     * the <code>Transformer</code> instance.</p>
     *
     * <p>An empty <code>Source</code> is represented as an empty document
     * as constructed by {@link javax.xml.parsers.DocumentBuilder#newDocument()}.
     * The result of transforming an empty <code>Source</code> depends on
     * the transformation behavior; it is not always an empty
     * <code>Result</code>.</p>
     *
     * @param xmlSource The XML input to transform.
     * @param outputTarget The <code>Result</code> of transforming the
     *   <code>xmlSource</code>.
     *
     * @throws TransformerException If an unrecoverable error occurs
     *   during the course of the transformation.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.883 -0500", hash_original_method = "33C228496BDD152D22B0DC6DE2F86AAD", hash_generated_method = "D63A3F1222CF3EB3DAEEC505406D3AF7")
    
public abstract void transform(Source xmlSource, Result outputTarget)
        throws TransformerException;

    /**
     * Add a parameter for the transformation.
     *
     * <p>Pass a qualified name as a two-part string, the namespace URI
     * enclosed in curly braces ({}), followed by the local name. If the
     * name has a null URL, the String only contain the local name. An
     * application can safely check for a non-null URI by testing to see if the
     * first character of the name is a '{' character.</p>
     * <p>For example, if a URI and local name were obtained from an element
     * defined with &lt;xyz:foo
     * xmlns:xyz="http://xyz.foo.com/yada/baz.html"/&gt;,
     * then the qualified name would be "{http://xyz.foo.com/yada/baz.html}foo".
     * Note that no prefix is used.</p>
     *
     * @param name The name of the parameter, which may begin with a
     * namespace URI in curly braces ({}).
     * @param value The value object.  This can be any valid Java object. It is
     * up to the processor to provide the proper object coercion or to simply
     * pass the object on for use in an extension.
     *
     * @throws NullPointerException If value is null.
     */
     @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.886 -0500", hash_original_method = "4617D75F565D3F23658343BDB1B78A0F", hash_generated_method = "19B7CD98EAA87E3C615203DDEA4DBFD9")
    
public abstract void setParameter(String name, Object value);

    /**
     * Get a parameter that was explicitly set with setParameter.
     *
     * <p>This method does not return a default parameter value, which
     * cannot be determined until the node context is evaluated during
     * the transformation process.
     *
     * @param name of <code>Object</code> to get
     * @return A parameter that has been set with setParameter.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.888 -0500", hash_original_method = "EBA848080256242AF7FA4C8FD328F6CF", hash_generated_method = "801C9A495E18271236C14BE2D50EC71B")
    
public abstract Object getParameter(String name);

    /**
     * <p>Set a list of parameters.</p>
     *
     * <p>Note that the list of parameters is specified as a
     * <code>Properties</code> <code>Object</code> which limits the parameter
     * values to <code>String</code>s.  Multiple calls to
     * {@link #setParameter(String name, Object value)} should be used when the
     * desired values are non-<code>String</code> <code>Object</code>s.
     * The parameter names should conform as specified in
     * {@link #setParameter(String name, Object value)}.
     * An <code>IllegalArgumentException</code> is thrown if any names do not
     * conform.</p>
     *
     * <p>New parameters in the list are added to any existing parameters.
     * If the name of a new parameter is equal to the name of an existing
     * parameter as determined by {@link java.lang.Object#equals(Object obj)},
     *  the existing parameter is set to the new value.</p>
     *
     * @param params Parameters to set.
     *
     * @throws IllegalArgumentException If any parameter names do not conform
     *   to the naming rules.
     */

    /**
     * Clear all parameters set with setParameter.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.890 -0500", hash_original_method = "A8BE8B4A86317304D711EC5DFAAC8190", hash_generated_method = "EC21214511342F53173F7E7DDAB36CFC")
    
public abstract void clearParameters();

    /**
     * Set an object that will be used to resolve URIs used in
     * document().
     *
     * <p>If the resolver argument is null, the URIResolver value will
     * be cleared and the transformer will no longer have a resolver.</p>
     *
     * @param resolver An object that implements the URIResolver interface,
     * or null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.893 -0500", hash_original_method = "68C7DB370C1ABE5011980426FA88EE59", hash_generated_method = "E0850D782E0B8F1232A8CCE32737D8FE")
    
public abstract void setURIResolver(URIResolver resolver);

    /**
     * Get an object that will be used to resolve URIs used in
     * document().
     *
     * @return An object that implements the URIResolver interface,
     * or null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.895 -0500", hash_original_method = "44193455267193A7FE520C9B388F539C", hash_generated_method = "34A19FFFC82864A6AE939F9AE846EC5E")
    
public abstract URIResolver getURIResolver();

    /**
     * Set the output properties for the transformation.  These
     * properties will override properties set in the Templates
     * with xsl:output.
     *
     * <p>If argument to this function is null, any properties
     * previously set are removed, and the value will revert to the value
     * defined in the templates object.</p>
     *
     * <p>Pass a qualified property key name as a two-part string, the namespace
     * URI enclosed in curly braces ({}), followed by the local name. If the
     * name has a null URL, the String only contain the local name. An
     * application can safely check for a non-null URI by testing to see if the
     * first character of the name is a '{' character.</p>
     * <p>For example, if a URI and local name were obtained from an element
     * defined with &lt;xyz:foo
     * xmlns:xyz="http://xyz.foo.com/yada/baz.html"/&gt;,
     * then the qualified name would be "{http://xyz.foo.com/yada/baz.html}foo".
     * Note that no prefix is used.</p>
     * An <code>IllegalArgumentException</code> is thrown  if any of the
     * argument keys are not recognized and are not namespace qualified.
     *
     * @param oformat A set of output properties that will be
     * used to override any of the same properties in affect
     * for the transformation.
     *
     * @see javax.xml.transform.OutputKeys
     * @see java.util.Properties
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.897 -0500", hash_original_method = "293C8749140D51B39938D1F10C439719", hash_generated_method = "16CFD3EF37E85EE37555659320321688")
    
public abstract void setOutputProperties(Properties oformat);

    /**
     * <p>Get a copy of the output properties for the transformation.</p>
     *
     * <p>The properties returned should contain properties set by the user,
     * and properties set by the stylesheet, and these properties
     * are "defaulted" by default properties specified by
     * <a href="http://www.w3.org/TR/xslt#output">section 16 of the
     * XSL Transformations (XSLT) W3C Recommendation</a>.  The properties that
     * were specifically set by the user or the stylesheet should be in the base
     * Properties list, while the XSLT default properties that were not
     * specifically set should be the default Properties list.  Thus,
     * getOutputProperties().getProperty(String key) will obtain any
     * property in that was set by {@link #setOutputProperty},
     * {@link #setOutputProperties}, in the stylesheet, <em>or</em> the default
     * properties, while
     * getOutputProperties().get(String key) will only retrieve properties
     * that were explicitly set by {@link #setOutputProperty},
     * {@link #setOutputProperties}, or in the stylesheet.</p>
     *
     * <p>Note that mutation of the Properties object returned will not
     * effect the properties that the transformer contains.</p>
     *
     * <p>If any of the argument keys are not recognized and are not
     * namespace qualified, the property will be ignored and not returned.
     * In other words the behavior is not orthogonal with
     * {@link #setOutputProperties setOutputProperties}.</p>
     *
     * @return A copy of the set of output properties in effect for
     *   the next transformation.
     *
     * @see javax.xml.transform.OutputKeys
     * @see java.util.Properties
     * @see <a href="http://www.w3.org/TR/xslt#output">
     *   XSL Transformations (XSLT) Version 1.0</a>
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.900 -0500", hash_original_method = "FF2B0C5C06271136D8F7522CBD03503A", hash_generated_method = "F5FBECE635883B8B1505CE85E8E938E6")
    
public abstract Properties getOutputProperties();

    /**
     * Set an output property that will be in effect for the
     * transformation.
     *
     * <p>Pass a qualified property name as a two-part string, the namespace URI
     * enclosed in curly braces ({}), followed by the local name. If the
     * name has a null URL, the String only contain the local name. An
     * application can safely check for a non-null URI by testing to see if the
     * first character of the name is a '{' character.</p>
     * <p>For example, if a URI and local name were obtained from an element
     * defined with &lt;xyz:foo
     * xmlns:xyz="http://xyz.foo.com/yada/baz.html"/&gt;,
     * then the qualified name would be "{http://xyz.foo.com/yada/baz.html}foo".
     * Note that no prefix is used.</p>
     *
     * <p>The Properties object that was passed to {@link #setOutputProperties}
     * won't be effected by calling this method.</p>
     *
     * @param name A non-null String that specifies an output
     * property name, which may be namespace qualified.
     * @param value The non-null string value of the output property.
     *
     * @throws IllegalArgumentException If the property is not supported, and is
     * not qualified with a namespace.
     *
     * @see javax.xml.transform.OutputKeys
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.902 -0500", hash_original_method = "517900FBB6133EB1A6EEE79192704787", hash_generated_method = "4104694D5C8FA62DDE3D00AB10EF086B")
    
public abstract void setOutputProperty(String name, String value)
        throws IllegalArgumentException;

    /**
     * Get an output property that is in effect for the
     * transformer.  The property specified may be a property
     * that was set with setOutputProperty, or it may be a
     * property specified in the stylesheet.
     *
     * @param name A non-null String that specifies an output
     * property name, which may be namespace qualified.
     *
     * @return The string value of the output property, or null
     * if no property was found.
     *
     * @throws IllegalArgumentException If the property is not supported.
     *
     * @see javax.xml.transform.OutputKeys
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.904 -0500", hash_original_method = "99F778907ED49B7EA6697D53B59B34C0", hash_generated_method = "51174055F506B826532EB2A629C54ADC")
    
public abstract String getOutputProperty(String name)
        throws IllegalArgumentException;

    /**
     * Set the error event listener in effect for the transformation.
     *
     * @param listener The new error listener.
     * @throws IllegalArgumentException if listener is null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.906 -0500", hash_original_method = "504DEBC24127B79F5668A9D49B045FA5", hash_generated_method = "ACF232889D9B5F29501C695D17CC55C8")
    
public abstract void setErrorListener(ErrorListener listener)
        throws IllegalArgumentException;

    /**
     * Get the error event handler in effect for the transformation.
     * Implementations must provide a default error listener.
     *
     * @return The current error handler, which should never be null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.908 -0500", hash_original_method = "A69DC36A610F5E9CC88DC70E49C46EE7", hash_generated_method = "AE4BF0F77687929F0842F0F0E1A9FE70")
    
public abstract ErrorListener getErrorListener();
    
}

