package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.xml.validation.Schema;

import org.apache.harmony.xml.parsers.SAXParserFactoryImpl;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public abstract class SAXParserFactory {

    /**
     * Returns Android's implementation of {@code SAXParserFactory}. Unlike
     * other Java implementations, this method does not consult system
     * properties, property files, or the services API.
     *
     * @return a new SAXParserFactory.
     *
     * @exception FactoryConfigurationError never. Included for API
     *     compatibility with other Java implementations.
     */
    @DSComment("no suspicious activity, just creates objects")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.643 -0500", hash_original_method = "D6BFF54803293788CC40085FF209ED1E", hash_generated_method = "1BB62AC084791E5596A520819F0C0E7C")
    
public static SAXParserFactory newInstance() {
        // instantiate the class directly rather than using reflection
        return new SAXParserFactoryImpl();
    }

    /**
     * Returns an instance of the named implementation of {@code SAXParserFactory}.
     *
     * @throws FactoryConfigurationError if {@code factoryClassName} is not available or cannot be
     *     instantiated.
     * @since 1.6
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.646 -0500", hash_original_method = "4635D9FD80382B0050D4F08EB297A814", hash_generated_method = "E5CC350DF6C6B2A5E3DB57C453569107")
    
public static SAXParserFactory newInstance(String factoryClassName,
            ClassLoader classLoader) {
        if (factoryClassName == null) {
            throw new FactoryConfigurationError("factoryClassName == null");
        }
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            Class<?> type = classLoader != null
                    ? classLoader.loadClass(factoryClassName)
                    : Class.forName(factoryClassName);
            return (SAXParserFactory) type.newInstance();
        } catch (ClassNotFoundException e) {
            throw new FactoryConfigurationError(e);
        } catch (InstantiationException e) {
            throw new FactoryConfigurationError(e);
        } catch (IllegalAccessException e) {
            throw new FactoryConfigurationError(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.635 -0500", hash_original_field = "C056FD2FDA0F7E8A6B7443BDF09FC0F0", hash_generated_field = "5A58AB4C6A46398C035EC9B72D104783")

    private boolean validating = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.637 -0500", hash_original_field = "6BDE859F4B3849644ED8212C15F2301D", hash_generated_field = "5485D5F0CEEDFBCE5E10558A9D6EF469")

    private boolean namespaceAware = false;

    /**
     * <p>Protected constructor to force use of {@link #newInstance()}.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.641 -0500", hash_original_method = "5B4969E70C1A248827CF399EDBDC2A24", hash_generated_method = "C73DF4EC20E38CBE562282707D25088E")
    
protected SAXParserFactory () {

    }

    /**
     * <p>Creates a new instance of a SAXParser using the currently
     * configured factory parameters.</p>
     *
     * @return A new instance of a SAXParser.
     *
     * @exception ParserConfigurationException if a parser cannot
     *   be created which satisfies the requested configuration.
     * @exception SAXException for SAX errors.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.648 -0500", hash_original_method = "6A5BE2BD18213305F2D52F18BAB8AB70", hash_generated_method = "CFC46F7C8178EF9FFC1654D051B8FFF3")
    
public abstract SAXParser newSAXParser()
        throws ParserConfigurationException, SAXException;

    /**
     * Specifies that the parser produced by this code will
     * provide support for XML namespaces. By default the value of this is set
     * to <code>false</code>.
     *
     * @param awareness true if the parser produced by this code will
     *                  provide support for XML namespaces; false otherwise.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.651 -0500", hash_original_method = "6A0A7EFC1E675DD90B546C7A4C9B47EE", hash_generated_method = "4FD13D12045B2E9F47E39E40A44BDDEE")
    
public void setNamespaceAware(boolean awareness) {
        this.namespaceAware = awareness;
    }

    /**
     * Specifies that the parser produced by this code will
     * validate documents as they are parsed. By default the value of this is
     * set to <code>false</code>.
     *
     * <p>
     * Note that "the validation" here means
     * <a href="http://www.w3.org/TR/REC-xml#proc-types">a validating
     * parser</a> as defined in the XML recommendation.
     * In other words, it essentially just controls the DTD validation.
     * (except the legacy two properties defined in JAXP 1.2.
     * See <a href="#validationCompatibility">here</a> for more details.)
     * </p>
     *
     * <p>
     * To use modern schema languages such as W3C XML Schema or
     * RELAX NG instead of DTD, you can configure your parser to be
     * a non-validating parser by leaving the {@link #setValidating(boolean)}
     * method <tt>false</tt>, then use the {@link #setSchema(Schema)}
     * method to associate a schema to a parser.
     * </p>
     *
     * @param validating true if the parser produced by this code will
     *                   validate documents as they are parsed; false otherwise.
     */

    @DSComment("no suspicious activity")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.653 -0500", hash_original_method = "55B714FD0DC17953A4D0F6C9203268D6", hash_generated_method = "20A92CFBF84C6F5D289DA3B1FC978F63")
    
public void setValidating(boolean validating) {
        this.validating = validating;
    }

    /**
     * Indicates whether or not the factory is configured to produce
     * parsers which are namespace aware.
     *
     * @return true if the factory is configured to produce
     *         parsers which are namespace aware; false otherwise.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.655 -0500", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "05DE9B7AFEC5AD5DCD1C87ACF69282FD")
    
public boolean isNamespaceAware() {
        return namespaceAware;
    }

    /**
     * Indicates whether or not the factory is configured to produce
     * parsers which validate the XML content during parse.
     *
     * @return true if the factory is configured to produce parsers which validate
     *         the XML content during parse; false otherwise.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.657 -0500", hash_original_method = "758653C6211E875508A2CE7C0CB7DC93", hash_generated_method = "8FE35D4442248DC57AD51037BE262D1B")
    
public boolean isValidating() {
        return validating;
    }

    /**
     *
     * <p>Sets the particular feature in the underlying implementation of
     * org.xml.sax.XMLReader.
     * A list of the core features and properties can be found at
     * <a href="http://www.saxproject.org/">http://www.saxproject.org/</a></p>
     *
     * <p>All implementations are required to support the {@link javax.xml.XMLConstants#FEATURE_SECURE_PROCESSING} feature.
     * When the feature is</p>
     * <ul>
     *   <li>
     *     <code>true</code>: the implementation will limit XML processing to conform to implementation limits.
     *     Examples include entity expansion limits and XML Schema constructs that would consume large amounts of resources.
     *     If XML processing is limited for security reasons, it will be reported via a call to the registered
     *     {@link org.xml.sax.ErrorHandler#fatalError(SAXParseException exception)}.
     *     See {@link SAXParser} <code>parse</code> methods for handler specification.
     *   </li>
     *   <li>
     *     When the feature is <code>false</code>, the implementation will processing XML according to the XML specifications without
     *     regard to possible implementation limits.
     *   </li>
     * </ul>
     *
     * @param name The name of the feature to be set.
     * @param value The value of the feature to be set.
     *
     * @exception ParserConfigurationException if a parser cannot
     *     be created which satisfies the requested configuration.
     * @exception SAXNotRecognizedException When the underlying XMLReader does
     *            not recognize the property name.
     * @exception SAXNotSupportedException When the underlying XMLReader
     *            recognizes the property name but doesn't support the
     *            property.
     * @throws NullPointerException If the <code>name</code> parameter is null.
     *
     * @see org.xml.sax.XMLReader#setFeature
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.660 -0500", hash_original_method = "520C8619FD9C9B6AF88B265C6938B254", hash_generated_method = "DE080B47328125529352E5F5672BFBBB")
    
public abstract void setFeature(String name, boolean value)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    /**
     *
     * <p>Returns the particular property requested for in the underlying
     * implementation of org.xml.sax.XMLReader.</p>
     *
     * @param name The name of the property to be retrieved.
     *
     * @return Value of the requested property.
     *
     * @exception ParserConfigurationException if a parser cannot be created which satisfies the requested configuration.
     * @exception SAXNotRecognizedException When the underlying XMLReader does not recognize the property name.
     * @exception SAXNotSupportedException When the underlying XMLReader recognizes the property name but doesn't support the property.
     *
     * @see org.xml.sax.XMLReader#getProperty
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.662 -0500", hash_original_method = "DA680BE094D753B5194A0B62EF0B1C28", hash_generated_method = "0EF47D00AFE9E9437E3E7D1C425585AC")
    
public abstract boolean getFeature(String name)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    /**
     * Gets the {@link Schema} object specified through
     * the {@link #setSchema(Schema schema)} method.
     *
     *
     * @throws UnsupportedOperationException
     *      For backward compatibility, when implementations for
     *      earlier versions of JAXP is used, this exception will be
     *      thrown.
     *
     * @return
     *      the {@link Schema} object that was last set through
     *      the {@link #setSchema(Schema)} method, or null
     *      if the method was not invoked since a {@link SAXParserFactory}
     *      is created.
     *
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.664 -0500", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "C60ED8DAAB20A1D1EE8BC81FA5C06DA4")
    
public Schema getSchema() {
        throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
    }

    /**
     * <p>Set the {@link Schema} to be used by parsers created
     * from this factory.</p>
     *
     * <p>When a {@link Schema} is non-null, a parser will use a validator
     * created from it to validate documents before it passes information
     * down to the application.</p>
     *
     * <p>When warnings/errors/fatal errors are found by the validator, the parser must
     * handle them as if those errors were found by the parser itself.
     * In other words, if the user-specified {@link org.xml.sax.ErrorHandler}
     * is set, it must receive those errors, and if not, they must be
     * treated according to the implementation specific
     * default error handling rules.
     *
     * <p>A validator may modify the SAX event stream (for example by
     * adding default values that were missing in documents), and a parser
     * is responsible to make sure that the application will receive
     * those modified event stream.</p>
     *
     * <p>Initially, <code>null</code> is set as the {@link Schema}.</p>
     *
     * <p>This processing will take effect even if
     * the {@link #isValidating()} method returns <code>false</code>.
     *
     * <p>It is an error to use
     * the <code>http://java.sun.com/xml/jaxp/properties/schemaSource</code>
     * property and/or the <code>http://java.sun.com/xml/jaxp/properties/schemaLanguage</code>
     * property in conjunction with a non-null {@link Schema} object.
     * Such configuration will cause a {@link SAXException}
     * exception when those properties are set on a {@link SAXParser}.</p>
     *
     * <h4>Note for implementors</h4>
     * <p>
     * A parser must be able to work with any {@link Schema}
     * implementation. However, parsers and schemas are allowed
     * to use implementation-specific custom mechanisms
     * as long as they yield the result described in the specification.
     * </p>
     *
     * @param schema <code>Schema</code> to use, <code>null</code> to remove a schema.
     *
     * @throws UnsupportedOperationException
     *      For backward compatibility, when implementations for
     *      earlier versions of JAXP is used, this exception will be
     *      thrown.
     *
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.667 -0500", hash_original_method = "15A4A50F8E3104FAC414471F9078A720", hash_generated_method = "7F4E43F28FCAA4F27CDFFBBB38B303F1")
    
public void setSchema(Schema schema) {
        throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
    }

    /**
     * <p>Set state of XInclude processing.</p>
     *
     * <p>If XInclude markup is found in the document instance, should it be
     * processed as specified in <a href="http://www.w3.org/TR/xinclude/">
     * XML Inclusions (XInclude) Version 1.0</a>.</p>
     *
     * <p>XInclude processing defaults to <code>false</code>.</p>
     *
     * @param state Set XInclude processing to <code>true</code> or
     *   <code>false</code>
     *
     * @throws UnsupportedOperationException
     *      For backward compatibility, when implementations for
     *      earlier versions of JAXP is used, this exception will be
     *      thrown.
     *
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.670 -0500", hash_original_method = "7123F2F991682C288B1EB84DFD3ADE3C", hash_generated_method = "E4DD79361E7B88C281F51675955E6730")
    
public void setXIncludeAware(final boolean state) {
        throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
    }

    /**
     * <p>Get state of XInclude processing.</p>
     *
     * @return current state of XInclude processing
     *
     * @throws UnsupportedOperationException
     *      For backward compatibility, when implementations for
     *      earlier versions of JAXP is used, this exception will be
     *      thrown.
     *
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:57.672 -0500", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "30D8B6618B1E7FCEA2BE47013700840C")
    
public boolean isXIncludeAware() {
        throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
    }
    
}

