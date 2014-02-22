package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.validation.Schema;

import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public abstract class SAXParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.670 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;

    /**
     * <p>Protected constructor to prevent instantiation.
     * Use {@link javax.xml.parsers.SAXParserFactory#newSAXParser()}.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.672 -0500", hash_original_method = "60861A80C08610A003AEF9BD086AC67B", hash_generated_method = "956B7A546D3F4BF1BA883D180DA1FB4A")
    
protected SAXParser () {

    }

    /**
     * <p>Reset this <code>SAXParser</code> to its original configuration.</p>
     *
     * <p><code>SAXParser</code> is reset to the same state as when it was created with
     * {@link SAXParserFactory#newSAXParser()}.
     * <code>reset()</code> is designed to allow the reuse of existing <code>SAXParser</code>s
     * thus saving resources associated with the creation of new <code>SAXParser</code>s.</p>
     *
     * <p>The reset <code>SAXParser</code> is not guaranteed to have the same {@link Schema}
     * <code>Object</code>, e.g. {@link Object#equals(Object obj)}.  It is guaranteed to have a functionally equal
     * <code>Schema</code>.</p>
     *
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.675 -0500", hash_original_method = "EE92C6E107D176D208870C8A6C9502AF", hash_generated_method = "C15518AC6D3FFAD64907FEA3CF993635")
    
public void reset() {

        // implementors should override this method
        throw new UnsupportedOperationException(
            "This SAXParser, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
    }

    /**
     * <p>Parse the content of the given {@link java.io.InputStream}
     * instance as XML using the specified {@link org.xml.sax.HandlerBase}.
     * <i> Use of the DefaultHandler version of this method is recommended as
     * the HandlerBase class has been deprecated in SAX 2.0</i>.</p>
     *
     * @param is InputStream containing the content to be parsed.
     * @param hb The SAX HandlerBase to use.
     *
     * @throws IllegalArgumentException If the given InputStream is null.
     * @throws SAXException If parse produces a SAX error.
     * @throws IOException If an IO error occurs interacting with the
     *   <code>InputStream</code>.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.678 -0500", hash_original_method = "E0E7EFA387CE9D5F50CEC1024059C3F8", hash_generated_method = "BF8CFBBEA18A12A239BA0C8DB24F3656")
    
public void parse(InputStream is, HandlerBase hb)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        InputSource input = new InputSource(is);
        this.parse(input, hb);
    }

    /**
     * <p>Parse the content of the given {@link java.io.InputStream}
     * instance as XML using the specified {@link org.xml.sax.HandlerBase}.
     * <i> Use of the DefaultHandler version of this method is recommended as
     * the HandlerBase class has been deprecated in SAX 2.0</i>.</p>
     *
     * @param is InputStream containing the content to be parsed.
     * @param hb The SAX HandlerBase to use.
     * @param systemId The systemId which is needed for resolving relative URIs.
     *
     * @throws IllegalArgumentException If the given <code>InputStream</code> is
     *   <code>null</code>.
     * @throws IOException If any IO error occurs interacting with the
     *   <code>InputStream</code>.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler version of this method instead.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.680 -0500", hash_original_method = "E43A55A8544E4B0EB3A11D0317C825F2", hash_generated_method = "DFE97DBB075CEB43CC98933A412464B6")
    
public void parse(
        InputStream is,
        HandlerBase hb,
        String systemId)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        InputSource input = new InputSource(is);
        input.setSystemId(systemId);
        this.parse(input, hb);
    }

    /**
     * Parse the content of the given {@link java.io.InputStream}
     * instance as XML using the specified
     * {@link org.xml.sax.helpers.DefaultHandler}.
     *
     * @param is InputStream containing the content to be parsed.
     * @param dh The SAX DefaultHandler to use.
     *
     * @throws IllegalArgumentException If the given InputStream is null.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSComment("input is io InputSource")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.683 -0500", hash_original_method = "F19248E94372C80DC5D37D9D6B998C8A", hash_generated_method = "85E07A63C210923C558596017081C361")
    
public void parse(InputStream is, DefaultHandler dh)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        InputSource input = new InputSource(is);
        this.parse(input, dh);
    }

    /**
     * Parse the content of the given {@link java.io.InputStream}
     * instance as XML using the specified
     * {@link org.xml.sax.helpers.DefaultHandler}.
     *
     * @param is InputStream containing the content to be parsed.
     * @param dh The SAX DefaultHandler to use.
     * @param systemId The systemId which is needed for resolving relative URIs.
     *
     * @throws IllegalArgumentException If the given InputStream is null.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler version of this method instead.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.685 -0500", hash_original_method = "1FC33240EB3C018A09EA92FF8A96D1A8", hash_generated_method = "3C21E7953F5452067AA5A27C66419022")
    
public void parse(
        InputStream is,
        DefaultHandler dh,
        String systemId)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        InputSource input = new InputSource(is);
        input.setSystemId(systemId);
        this.parse(input, dh);
    }

    /**
     * Parse the content described by the giving Uniform Resource
     * Identifier (URI) as XML using the specified
     * {@link org.xml.sax.HandlerBase}.
     * <i> Use of the DefaultHandler version of this method is recommended as
     * the <code>HandlerBase</code> class has been deprecated in SAX 2.0</i>
     *
     * @param uri The location of the content to be parsed.
     * @param hb The SAX HandlerBase to use.
     *
     * @throws IllegalArgumentException If the uri is null.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.687 -0500", hash_original_method = "67AC143C34CF78ECFB000A375BF6460F", hash_generated_method = "43D13F5939334F2F10AB50C8971F6DF9")
    
public void parse(String uri, HandlerBase hb)
        throws SAXException, IOException {
        if (uri == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }

        InputSource input = new InputSource(uri);
        this.parse(input, hb);
    }

    /**
     * Parse the content described by the giving Uniform Resource
     * Identifier (URI) as XML using the specified
     * {@link org.xml.sax.helpers.DefaultHandler}.
     *
     * @param uri The location of the content to be parsed.
     * @param dh The SAX DefaultHandler to use.
     *
     * @throws IllegalArgumentException If the uri is null.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.689 -0500", hash_original_method = "9D1B9B5B338D189F5FEB6183087C0F90", hash_generated_method = "C9998E6A83F4A64846D1FFF9E7C51719")
    
public void parse(String uri, DefaultHandler dh)
        throws SAXException, IOException {
        if (uri == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }

        InputSource input = new InputSource(uri);
        this.parse(input, dh);
    }

    /**
     * Parse the content of the file specified as XML using the
     * specified {@link org.xml.sax.HandlerBase}.
     * <i> Use of the DefaultHandler version of this method is recommended as
     * the HandlerBase class has been deprecated in SAX 2.0</i>
     *
     * @param f The file containing the XML to parse
     * @param hb The SAX HandlerBase to use.
     *
     * @throws IllegalArgumentException If the File object is null.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.692 -0500", hash_original_method = "0F0EB1667ABEA41C60E7456F327FDB47", hash_generated_method = "E8EB618F55B4C3E8ABCCCEEC9CF3DDDD")
    
public void parse(File f, HandlerBase hb)
        throws SAXException, IOException {
        if (f == null) {
            throw new IllegalArgumentException("File cannot be null");
        }

        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());

        if (DEBUG) {
            System.out.println("Escaped URI = " + escapedURI);
        }

        InputSource input = new InputSource(escapedURI);
        this.parse(input, hb);
    }

    /**
     * Parse the content of the file specified as XML using the
     * specified {@link org.xml.sax.helpers.DefaultHandler}.
     *
     * @param f The file containing the XML to parse
     * @param dh The SAX DefaultHandler to use.
     *
     * @throws IllegalArgumentException If the File object is null.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.694 -0500", hash_original_method = "4E507AEF2C358B180E5AB169C6F8A741", hash_generated_method = "E1820870BC3407C75737C70D7558183D")
    
public void parse(File f, DefaultHandler dh)
        throws SAXException, IOException {
        if (f == null) {
            throw new IllegalArgumentException("File cannot be null");
        }

        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());

        if (DEBUG) {
            System.out.println("Escaped URI = " + escapedURI);
        }

        InputSource input = new InputSource(escapedURI);
        this.parse(input, dh);
    }

    /**
     * Parse the content given {@link org.xml.sax.InputSource}
     * as XML using the specified
     * {@link org.xml.sax.HandlerBase}.
     * <i> Use of the DefaultHandler version of this method is recommended as
     * the HandlerBase class has been deprecated in SAX 2.0</i>
     *
     * @param is The InputSource containing the content to be parsed.
     * @param hb The SAX HandlerBase to use.
     *
     * @throws IllegalArgumentException If the <code>InputSource</code> object
     *   is <code>null</code>.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.696 -0500", hash_original_method = "07160A7FD95C7E2FA31C88097829A206", hash_generated_method = "291FAAD7E7EF70DACDE5C2DC4FA54219")
    
public void parse(InputSource is, HandlerBase hb)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputSource cannot be null");
        }

        Parser parser = this.getParser();
        if (hb != null) {
            parser.setDocumentHandler(hb);
            parser.setEntityResolver(hb);
            parser.setErrorHandler(hb);
            parser.setDTDHandler(hb);
        }
        parser.parse(is);
    }

    /**
     * Parse the content given {@link org.xml.sax.InputSource}
     * as XML using the specified
     * {@link org.xml.sax.helpers.DefaultHandler}.
     *
     * @param is The InputSource containing the content to be parsed.
     * @param dh The SAX DefaultHandler to use.
     *
     * @throws IllegalArgumentException If the <code>InputSource</code> object
     *   is <code>null</code>.
     * @throws IOException If any IO errors occur.
     * @throws SAXException If any SAX errors occur during processing.
     *
     * @see org.xml.sax.DocumentHandler
     */
    @DSComment("input is io InputSource")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.699 -0500", hash_original_method = "8F425B137DCEBCB18BE581A6911D8EA7", hash_generated_method = "E6927473C62A9031C3B8A4697416E78F")
    
public void parse(InputSource is, DefaultHandler dh)
        throws SAXException, IOException {
        if (is == null) {
            throw new IllegalArgumentException("InputSource cannot be null");
        }

        XMLReader reader = this.getXMLReader();
        if (dh != null) {
            reader.setContentHandler(dh);
            reader.setEntityResolver(dh);
            reader.setErrorHandler(dh);
            reader.setDTDHandler(dh);
        }
        reader.parse(is);
    }

    /**
     * Returns the SAX parser that is encapsulated by the
     * implementation of this class.
     *
     * @return The SAX parser that is encapsulated by the
     *         implementation of this class.
     *
     * @throws SAXException If any SAX errors occur during processing.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.702 -0500", hash_original_method = "58C886207D8A58E2461E91D14CFC167C", hash_generated_method = "272E38E21040234908310753B49E4582")
    
public abstract org.xml.sax.Parser getParser() throws SAXException;

    /**
     * Returns the {@link org.xml.sax.XMLReader} that is encapsulated by the
     * implementation of this class.
     *
     * @return The XMLReader that is encapsulated by the
     *         implementation of this class.
     *
     * @throws SAXException If any SAX errors occur during processing.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.704 -0500", hash_original_method = "B62E96B0118EEB0E23EC3778F736AAE1", hash_generated_method = "388CF7B5AAE047FFAF40E11D2B1A57CC")
    
public abstract org.xml.sax.XMLReader getXMLReader() throws SAXException;

    /**
     * Indicates whether or not this parser is configured to
     * understand namespaces.
     *
     * @return true if this parser is configured to
     *         understand namespaces; false otherwise.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.707 -0500", hash_original_method = "0C20300A9407A97F92B793E805D98086", hash_generated_method = "C069C8335C3E94893ADF95CE4452F34C")
    
public abstract boolean isNamespaceAware();

    /**
     * Indicates whether or not this parser is configured to
     * validate XML documents.
     *
     * @return true if this parser is configured to
     *         validate XML documents; false otherwise.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.709 -0500", hash_original_method = "B128693C9551D41070A4A0D64F8C0627", hash_generated_method = "89D797F47244E86E3C28FB7197668A45")
    
public abstract boolean isValidating();

    /**
     * <p>Sets the particular property in the underlying implementation of
     * {@link org.xml.sax.XMLReader}.
     * A list of the core features and properties can be found at
     * <a href="http://sax.sourceforge.net/?selected=get-set">
     * http://sax.sourceforge.net/?selected=get-set</a>.</p>
     *
     * @param name The name of the property to be set.
     * @param value The value of the property to be set.
     *
     * @throws SAXNotRecognizedException When the underlying XMLReader does
     *   not recognize the property name.
     * @throws SAXNotSupportedException When the underlying XMLReader
     *  recognizes the property name but doesn't support the property.
     *
     * @see org.xml.sax.XMLReader#setProperty
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.712 -0500", hash_original_method = "4803E6F019B67995F2AFE024A185FC1E", hash_generated_method = "3D6939B3969A0F5AAE6AC1ED64A13B6C")
    
public abstract void setProperty(String name, Object value)
        throws SAXNotRecognizedException, SAXNotSupportedException;

    /**
     * <p>Returns the particular property requested for in the underlying
     * implementation of {@link org.xml.sax.XMLReader}.</p>
     *
     * @param name The name of the property to be retrieved.
     * @return Value of the requested property.
     *
     * @throws SAXNotRecognizedException When the underlying XMLReader does
     *    not recognize the property name.
     * @throws SAXNotSupportedException When the underlying XMLReader
     *  recognizes the property name but doesn't support the property.
     *
     * @see org.xml.sax.XMLReader#getProperty
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.715 -0500", hash_original_method = "A8F7E72A24ED70D88A263F42AB6331E0", hash_generated_method = "32023161F2DD5A4344FACE167186DC0F")
    
public abstract Object getProperty(String name)
        throws SAXNotRecognizedException, SAXNotSupportedException;

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.717 -0500", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "C60ED8DAAB20A1D1EE8BC81FA5C06DA4")
    
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
     *      the {@link SAXParserFactory#isXIncludeAware()}
     *      when this parser was created from factory.
     *
     * @throws UnsupportedOperationException
     *      For backward compatibility, when implementations for
     *      earlier versions of JAXP is used, this exception will be
     *      thrown.
     *
     * @since 1.5
     *
     * @see SAXParserFactory#setXIncludeAware(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.720 -0500", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "30D8B6618B1E7FCEA2BE47013700840C")
    
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

