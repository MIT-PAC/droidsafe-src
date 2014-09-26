package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.validation.Schema;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class DocumentBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.089 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;

    /** Protected constructor */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.092 -0500", hash_original_method = "A55CBA234E1648A7F9C09E5B63DC560C", hash_generated_method = "985F276AAC414AEC932C0CE826CF4F41")
    
protected DocumentBuilder () {
    }

    /**
      * <p>Reset this <code>DocumentBuilder</code> to its original configuration.</p>
      *
      * <p><code>DocumentBuilder</code> is reset to the same state as when it was created with
      * {@link DocumentBuilderFactory#newDocumentBuilder()}.
      * <code>reset()</code> is designed to allow the reuse of existing <code>DocumentBuilder</code>s
      * thus saving resources associated with the creation of new <code>DocumentBuilder</code>s.</p>
      *
      * <p>The reset <code>DocumentBuilder</code> is not guaranteed to have the same {@link EntityResolver} or {@link ErrorHandler}
      * <code>Object</code>s, e.g. {@link Object#equals(Object obj)}.  It is guaranteed to have a functionally equal
      * <code>EntityResolver</code> and <code>ErrorHandler</code>.</p>
      *
      * @since 1.5
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.095 -0500", hash_original_method = "B05B5D751774CA5E926948E22CD07EE8", hash_generated_method = "8DC1CC2370E5AB02D0572E4E6E2168AF")
    
public void reset() {

        // implementors should override this method
        throw new UnsupportedOperationException(
            "This DocumentBuilder, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
    }

    /**
     * Parse the content of the given <code>InputStream</code> as an XML
     * document and return a new DOM {@link Document} object.
     * An <code>IllegalArgumentException</code> is thrown if the
     * <code>InputStream</code> is null.
     *
     * @param is InputStream containing the content to be parsed.
     * @return <code>Document</code> result of parsing the
     *  <code>InputStream</code>
     * @exception IOException If any IO errors occur.
     * @exception SAXException If any parse errors occur.
     * @see org.xml.sax.DocumentHandler
     */

    @DSComment("input is io InputStream")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.097 -0500", hash_original_method = "95E59CF6F0A1DFE242840282B735E195", hash_generated_method = "D801F974BA0202307AC902C635182E61")
    
public Document parse(InputStream is)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        InputSource in = new InputSource(is);
        return parse(in);
    }

    /**
     * Parse the content of the given <code>InputStream</code> as an
     * XML document and return a new DOM {@link Document} object.
     * An <code>IllegalArgumentException</code> is thrown if the
     * <code>InputStream</code> is null.
     *
     * @param is InputStream containing the content to be parsed.
     * @param systemId Provide a base for resolving relative URIs.
     * @return A new DOM Document object.
     * @exception IOException If any IO errors occur.
     * @exception SAXException If any parse errors occur.
     * @see org.xml.sax.DocumentHandler
     */

    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.100 -0500", hash_original_method = "EA811CE95A08B04D15381504F667910C", hash_generated_method = "70C97B542BC1EB5B9903552A3D2ED761")
    
public Document parse(InputStream is, String systemId)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        InputSource in = new InputSource(is);
        in.setSystemId(systemId);
        return parse(in);
    }

    /**
     * Parse the content of the given URI as an XML document
     * and return a new DOM {@link Document} object.
     * An <code>IllegalArgumentException</code> is thrown if the
     * URI is <code>null</code> null.
     *
     * @param uri The location of the content to be parsed.
     * @return A new DOM Document object.
     * @exception IOException If any IO errors occur.
     * @exception SAXException If any parse errors occur.
     * @see org.xml.sax.DocumentHandler
     */

    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.103 -0500", hash_original_method = "595BF8AC63AB584AD723E5F0FBAE035E", hash_generated_method = "70E399953BEC569388820A7375896695")
    
public Document parse(String uri)
        throws SAXException, IOException {
        if (uri == null) {
            throw new IllegalArgumentException("URI cannot be null");
        }

        InputSource in = new InputSource(uri);
        return parse(in);
    }

    /**
     * Parse the content of the given file as an XML document
     * and return a new DOM {@link Document} object.
     * An <code>IllegalArgumentException</code> is thrown if the
     * <code>File</code> is <code>null</code> null.
     *
     * @param f The file containing the XML to parse.
     * @exception IOException If any IO errors occur.
     * @exception SAXException If any parse errors occur.
     * @see org.xml.sax.DocumentHandler
     * @return A new DOM Document object.
     */

    @DSComment("input is io file object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.105 -0500", hash_original_method = "F95298F4448DE156B1C85F49780E514D", hash_generated_method = "BD38C4001589DF85E06DF2B6CFF70AAF")
    
public Document parse(File f) throws SAXException, IOException {
        if (f == null) {
            throw new IllegalArgumentException("File cannot be null");
        }

        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());

        if (DEBUG) {
            System.out.println("Escaped URI = " + escapedURI);
        }

        InputSource in = new InputSource(escapedURI);
        return parse(in);
    }

    /**
     * Parse the content of the given input source as an XML document
     * and return a new DOM {@link Document} object.
     * An <code>IllegalArgumentException</code> is thrown if the
     * <code>InputSource</code> is <code>null</code> null.
     *
     * @param is InputSource containing the content to be parsed.
     * @exception IOException If any IO errors occur.
     * @exception SAXException If any parse errors occur.
     * @see org.xml.sax.DocumentHandler
     * @return A new DOM Document object.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.107 -0500", hash_original_method = "34848998765D4A28285495E765F5578C", hash_generated_method = "3378BF159BC7F100B945A22A43DFCD5F")
    
public abstract Document parse(InputSource is)
        throws  SAXException, IOException;

    /**
     * Indicates whether or not this parser is configured to
     * understand namespaces.
     *
     * @return true if this parser is configured to understand
     *         namespaces; false otherwise.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.109 -0500", hash_original_method = "0C20300A9407A97F92B793E805D98086", hash_generated_method = "C069C8335C3E94893ADF95CE4452F34C")
    
public abstract boolean isNamespaceAware();

    /**
     * Indicates whether or not this parser is configured to
     * validate XML documents.
     *
     * @return true if this parser is configured to validate
     *         XML documents; false otherwise.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.112 -0500", hash_original_method = "B128693C9551D41070A4A0D64F8C0627", hash_generated_method = "89D797F47244E86E3C28FB7197668A45")
    
public abstract boolean isValidating();

    /**
     * Specify the {@link EntityResolver} to be used to resolve
     * entities present in the XML document to be parsed. Setting
     * this to <code>null</code> will result in the underlying
     * implementation using it's own default implementation and
     * behavior.
     *
     * @param er The <code>EntityResolver</code> to be used to resolve entities
     *           present in the XML document to be parsed.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.114 -0500", hash_original_method = "1CC9636D2AC6AC959BBC778E61CA8DF6", hash_generated_method = "769949358DFB300D7ACAAF6C7224E44F")
    
public abstract void setEntityResolver(EntityResolver er);

    /**
     * Specify the {@link ErrorHandler} to be used by the parser.
     * Setting this to <code>null</code> will result in the underlying
     * implementation using it's own default implementation and
     * behavior.
     *
     * @param eh The <code>ErrorHandler</code> to be used by the parser.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.116 -0500", hash_original_method = "B60831D7C2F41C83EDF30B69ED2E25B6", hash_generated_method = "B179A571E00CDB3760A26762C521A028")
    
public abstract void setErrorHandler(ErrorHandler eh);

    /**
     * Obtain a new instance of a DOM {@link Document} object
     * to build a DOM tree with.
     *
     * @return A new instance of a DOM Document object.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.119 -0500", hash_original_method = "53C13FA54B20168A8C4E72F2E7F90DDD", hash_generated_method = "550BA59ED5400AA25A091E985E307EFF")
    
public abstract Document newDocument();

    /**
     * Obtain an instance of a {@link DOMImplementation} object.
     *
     * @return A new instance of a <code>DOMImplementation</code>.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.121 -0500", hash_original_method = "02B1A67F0E725EA787B7E8D701D27373", hash_generated_method = "3CDB6E7F1CE404F67D3F85AF23794147")
    
public abstract DOMImplementation getDOMImplementation();

    /** <p>Get a reference to the the {@link Schema} being used by
     * the XML processor.</p>
     *
     * <p>If no schema is being used, <code>null</code> is returned.</p>
     *
     * @return {@link Schema} being used or <code>null</code>
     *  if none in use
     *
     * @throws UnsupportedOperationException
     *      For backward compatibility, when implementations for
     *      earlier versions of JAXP is used, this exception will be
     *      thrown.
     *
     * @since 1.5
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.123 -0500", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "C60ED8DAAB20A1D1EE8BC81FA5C06DA4")
    
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
     * <p>Get the XInclude processing mode for this parser.</p>
     *
     * @return
     *      the return value of
     *      the {@link DocumentBuilderFactory#isXIncludeAware()}
     *      when this parser was created from factory.
     *
     * @throws UnsupportedOperationException
     *      For backward compatibility, when implementations for
     *      earlier versions of JAXP is used, this exception will be
     *      thrown.
     *
     * @since 1.5
     *
     * @see DocumentBuilderFactory#setXIncludeAware(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.125 -0500", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "30D8B6618B1E7FCEA2BE47013700840C")
    
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

