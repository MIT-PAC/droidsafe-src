package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class ParserAdapter implements XMLReader, DocumentHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.272 -0500", hash_original_field = "7C62AE9A20150A42A26A5AD7B14A845B", hash_generated_field = "1096644F71EDD67B690E4CE87AE1DE5B")

    // Implementation of org.xml.sax.XMLReader.
    ////////////////////////////////////////////////////////////////////

    //
    // Internal constants for the sake of convenience.
    //
    private static final String FEATURES = "http://xml.org/sax/features/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.274 -0500", hash_original_field = "E786AB5E1BC47C2A1870396F29B3DC84", hash_generated_field = "01CA2984D11D1EEDC7EEEBDF3608A189")

    private static final String NAMESPACES = FEATURES + "namespaces";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.277 -0500", hash_original_field = "B1A8D8BE48CB1C3B713D7838253F8D0F", hash_generated_field = "1DB4D9F63D53A2D85BBF1DD847F0B1EE")

    private static final String NAMESPACE_PREFIXES = FEATURES + "namespace-prefixes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.280 -0500", hash_original_field = "0B8F97223CE649220EA9B0775F522787", hash_generated_field = "117F3EAB9BE6F30784F4A30F1BDC845B")

    private static final String XMLNS_URIs = FEATURES + "xmlns-uris";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.346 -0500", hash_original_field = "B6AF1ABCD12D0ADFE7A536A2B5B9C160", hash_generated_field = "4D21145F84F9776E3FC6F208EE529FDA")

    // Internal state.
    ////////////////////////////////////////////////////////////////////

    private NamespaceSupport nsSupport;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.349 -0500", hash_original_field = "35CCAF5FF0269D32C9F075FFE70337F2", hash_generated_field = "995A52C4CFBC84030E5C3B84FDD67C5A")

    private AttributeListAdapter attAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.351 -0500", hash_original_field = "4B9C3C20092D8C4E8F2E8C12AA6B8CAD", hash_generated_field = "B2B6F03C3323CC2E5DF880878C6AD064")

    private boolean parsing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.353 -0500", hash_original_field = "7F5631DA40AFEA02D23B50F414B774CA", hash_generated_field = "9D06BBFBDDCCC6F79C4828C391273388")

    private String nameParts[] = new String[3];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.355 -0500", hash_original_field = "78998326B0DF34C103DE9D9688C73EBE", hash_generated_field = "C1941098165849B9BB09C918699765BA")

    private Parser parser = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.357 -0500", hash_original_field = "1E7E98FB612B7958E6D5EE79CDF5B4A2", hash_generated_field = "1C437322B74865B450A5CD9EA125241E")

    private AttributesImpl atts = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.359 -0500", hash_original_field = "487D36470CC197CE32401A3EEE7C0D76", hash_generated_field = "F2647CFF1692834895465A43B4FBE112")

    private boolean namespaces = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.361 -0500", hash_original_field = "ADB565F6608C94EE5469F65EAD573E36", hash_generated_field = "3042A72B16E92F646AF269C47B7B0A4D")

    private boolean prefixes = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.364 -0500", hash_original_field = "0FF76D81A4C49922F2B637E335924D89", hash_generated_field = "96E23C17D2742D7559D0E0D31EA42D80")

    private boolean uris = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.366 -0500", hash_original_field = "ACD7A3294F45ACE61F205E17A82EF3B3", hash_generated_field = "1D90ADA9EBB71DCE474548B241946332")

                // Handlers
    Locator locator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.368 -0500", hash_original_field = "85A3C4DFDDC2E8B053733750B1AEDE7A", hash_generated_field = "85A3C4DFDDC2E8B053733750B1AEDE7A")

    EntityResolver entityResolver = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.371 -0500", hash_original_field = "36C16184E94517BCEA93A1000BB15E7B", hash_generated_field = "36C16184E94517BCEA93A1000BB15E7B")

    DTDHandler dtdHandler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.373 -0500", hash_original_field = "F44EFA80D2ED728EA2AFD1A415E0F220", hash_generated_field = "F44EFA80D2ED728EA2AFD1A415E0F220")

    ContentHandler contentHandler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.375 -0500", hash_original_field = "B6B9BEC6A9AF54860C9708100871418D", hash_generated_field = "B6B9BEC6A9AF54860C9708100871418D")

    ErrorHandler errorHandler = null;

    ////////////////////////////////////////////////////////////////////
    // Constructors.
    ////////////////////////////////////////////////////////////////////

    /**
     * Construct a new parser adapter.
     *
     * <p>Use the "org.xml.sax.parser" property to locate the
     * embedded SAX1 driver.</p>
     *
     * @exception SAXException If the embedded driver
     *            cannot be instantiated or if the
     *            org.xml.sax.parser property is not specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.265 -0500", hash_original_method = "6A3B211FACF5438B3BC1ECD3BFD1BA43", hash_generated_method = "544C0D3DAB56E3314810F0B4B486C230")
    
public ParserAdapter ()
      throws SAXException
    {

    String driver = System.getProperty("org.xml.sax.parser");

    try {
        setup(ParserFactory.makeParser());
    } catch (ClassNotFoundException e1) {
        throw new
        SAXException("Cannot find SAX1 driver class " +
                 driver, e1);
    } catch (IllegalAccessException e2) {
        throw new
        SAXException("SAX1 driver class " +
                 driver +
                 " found but cannot be loaded", e2);
    } catch (InstantiationException e3) {
        throw new
        SAXException("SAX1 driver class " +
                 driver +
                 " loaded but cannot be instantiated", e3);
    } catch (ClassCastException e4) {
        throw new
        SAXException("SAX1 driver class " +
                 driver +
                 " does not implement org.xml.sax.Parser");
    } catch (NullPointerException e5) {
        throw new
        SAXException("System property org.xml.sax.parser not specified");
    }
    }

    /**
     * Construct a new parser adapter.
     *
     * <p>Note that the embedded parser cannot be changed once the
     * adapter is created; to embed a different parser, allocate
     * a new ParserAdapter.</p>
     *
     * @param parser The SAX1 parser to embed.
     * @exception java.lang.NullPointerException If the parser parameter
     *            is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.268 -0500", hash_original_method = "4DBB6701F2EF3CA3BC7975B2574ABC06", hash_generated_method = "59C1B7C22F494966CF38AEC727F696D0")
    
public ParserAdapter (Parser parser)
    {
    setup(parser);
    }

    /**
     * Internal setup method.
     *
     * @param parser The embedded parser.
     * @exception java.lang.NullPointerException If the parser parameter
     *            is null.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.270 -0500", hash_original_method = "9AA60727AB1204C604E2657D93003A43", hash_generated_method = "6B109218C9EB16016D1B5C2BB2E7807F")
    
private void setup (Parser parser)
    {
    if (parser == null) {
        throw new
        NullPointerException("Parser argument must not be null");
    }
    this.parser = parser;
    atts = new AttributesImpl();
    nsSupport = new NamespaceSupport();
    attAdapter = new AttributeListAdapter();
    }

    /**
     * Set a feature flag for the parser.
     *
     * <p>The only features recognized are namespaces and
     * namespace-prefixes.</p>
     *
     * @param name The feature name, as a complete URI.
     * @param value The requested feature value.
     * @exception SAXNotRecognizedException If the feature
     *            can't be assigned or retrieved.
     * @exception SAXNotSupportedException If the feature
     *            can't be assigned that value.
     * @see org.xml.sax.XMLReader#setFeature
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.283 -0500", hash_original_method = "A3A2E58BF53A687D411A2644B8AA8600", hash_generated_method = "142412234960A9F44D0071D6C24F5F79")
    
public void setFeature (String name, boolean value)
    throws SAXNotRecognizedException, SAXNotSupportedException
    {
    if (name.equals(NAMESPACES)) {
        checkNotParsing("feature", name);
        namespaces = value;
        if (!namespaces && !prefixes) {
        prefixes = true;
        }
    } else if (name.equals(NAMESPACE_PREFIXES)) {
        checkNotParsing("feature", name);
        prefixes = value;
        if (!prefixes && !namespaces) {
        namespaces = true;
        }
    } else if (name.equals(XMLNS_URIs)) {
        checkNotParsing("feature", name);
        uris = value;
    } else {
        throw new SAXNotRecognizedException("Feature: " + name);
    }
    }

    /**
     * Check a parser feature flag.
     *
     * <p>The only features recognized are namespaces and
     * namespace-prefixes.</p>
     *
     * @param name The feature name, as a complete URI.
     * @return The current feature value.
     * @exception SAXNotRecognizedException If the feature
     *            value can't be assigned or retrieved.
     * @exception SAXNotSupportedException If the
     *            feature is not currently readable.
     * @see org.xml.sax.XMLReader#setFeature
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.285 -0500", hash_original_method = "894FAC8B5FEFDB9322A454DD3740A469", hash_generated_method = "06969D059221598EA10252945D4C698B")
    
public boolean getFeature (String name)
    throws SAXNotRecognizedException, SAXNotSupportedException
    {
    if (name.equals(NAMESPACES)) {
        return namespaces;
    } else if (name.equals(NAMESPACE_PREFIXES)) {
        return prefixes;
    } else if (name.equals(XMLNS_URIs)) {
        return uris;
    } else {
        throw new SAXNotRecognizedException("Feature: " + name);
    }
    }

    /**
     * Set a parser property.
     *
     * <p>No properties are currently recognized.</p>
     *
     * @param name The property name.
     * @param value The property value.
     * @exception SAXNotRecognizedException If the property
     *            value can't be assigned or retrieved.
     * @exception SAXNotSupportedException If the property
     *            can't be assigned that value.
     * @see org.xml.sax.XMLReader#setProperty
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.287 -0500", hash_original_method = "EE8A541C22360A747253892239DA9935", hash_generated_method = "1734503BC1D2DC5B0A93E8F9C40C564C")
    
public void setProperty (String name, Object value)
    throws SAXNotRecognizedException, SAXNotSupportedException
    {
    throw new SAXNotRecognizedException("Property: " + name);
    }

    /**
     * Get a parser property.
     *
     * <p>No properties are currently recognized.</p>
     *
     * @param name The property name.
     * @return The property value.
     * @exception SAXNotRecognizedException If the property
     *            value can't be assigned or retrieved.
     * @exception SAXNotSupportedException If the property
     *            value is not currently readable.
     * @see org.xml.sax.XMLReader#getProperty
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.289 -0500", hash_original_method = "C44A70A290987077F2BE17BCA485ED98", hash_generated_method = "CC2ADCA125CB5A6D2AD99DB025EEB530")
    
public Object getProperty (String name)
    throws SAXNotRecognizedException, SAXNotSupportedException
    {
    throw new SAXNotRecognizedException("Property: " + name);
    }

    /**
     * Set the entity resolver.
     *
     * @param resolver The new entity resolver.
     * @see org.xml.sax.XMLReader#setEntityResolver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.291 -0500", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "27847D4529848B5E29D14A0E2D346FC8")
    
public void setEntityResolver (EntityResolver resolver)
    {
    entityResolver = resolver;
    }

    /**
     * Return the current entity resolver.
     *
     * @return The current entity resolver, or null if none was supplied.
     * @see org.xml.sax.XMLReader#getEntityResolver
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.294 -0500", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "21235A3EAE7DB933DABF4A20E9939299")
    
public EntityResolver getEntityResolver ()
    {
    return entityResolver;
    }

    /**
     * Set the DTD handler.
     *
     * @param handler the new DTD handler
     * @see org.xml.sax.XMLReader#setEntityResolver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.296 -0500", hash_original_method = "119A8AEB4875146983459E145CF644BE", hash_generated_method = "557F1528C5E4EF62FB32AFAB119AC302")
    
public void setDTDHandler (DTDHandler handler)
    {
    dtdHandler = handler;
    }

    /**
     * Return the current DTD handler.
     *
     * @return the current DTD handler, or null if none was supplied
     * @see org.xml.sax.XMLReader#getEntityResolver
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.298 -0500", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "59B05D24F37BFA393F25F99590382F55")
    
public DTDHandler getDTDHandler ()
    {
    return dtdHandler;
    }

    /**
     * Set the content handler.
     *
     * @param handler the new content handler
     * @see org.xml.sax.XMLReader#setEntityResolver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.300 -0500", hash_original_method = "D8A0D6D3310208C2BEAFD8789BB430C2", hash_generated_method = "1AE1242D9F3749D44BECA443064942F5")
    
public void setContentHandler (ContentHandler handler)
    {
    contentHandler = handler;
    }

    /**
     * Return the current content handler.
     *
     * @return The current content handler, or null if none was supplied.
     * @see org.xml.sax.XMLReader#getEntityResolver
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.303 -0500", hash_original_method = "0648A0EF88EB44B7C03930DFF59893AE", hash_generated_method = "1D002E4F644B3971DAC0310E795E4A0B")
    
public ContentHandler getContentHandler ()
    {
    return contentHandler;
    }

    /**
     * Set the error handler.
     *
     * @param handler The new error handler.
     * @see org.xml.sax.XMLReader#setEntityResolver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.305 -0500", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "D1953B188756F0AC9A45CB7EDCB24830")
    
public void setErrorHandler (ErrorHandler handler)
    {
    errorHandler = handler;
    }

    /**
     * Return the current error handler.
     *
     * @return The current error handler, or null if none was supplied.
     * @see org.xml.sax.XMLReader#getEntityResolver
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.307 -0500", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "DB848F72598F990979C28BB722D11B1F")
    
public ErrorHandler getErrorHandler ()
    {
    return errorHandler;
    }

    /**
     * Parse an XML document.
     *
     * @param systemId The absolute URL of the document.
     * @exception java.io.IOException If there is a problem reading
     *            the raw content of the document.
     * @exception SAXException If there is a problem
     *            processing the document.
     * @see #parse(org.xml.sax.InputSource)
     * @see org.xml.sax.Parser#parse(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.310 -0500", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "10CE462B07C3B7D01E1AC1F092312A2E")
    
public void parse (String systemId)
    throws IOException, SAXException
    {
    parse(new InputSource(systemId));
    }

    /**
     * Parse an XML document.
     *
     * @param input An input source for the document.
     * @exception java.io.IOException If there is a problem reading
     *            the raw content of the document.
     * @exception SAXException If there is a problem
     *            processing the document.
     * @see #parse(java.lang.String)
     * @see org.xml.sax.Parser#parse(org.xml.sax.InputSource)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.312 -0500", hash_original_method = "8D1EDF001F7865BC335C47DEAA91DF87", hash_generated_method = "E14DDB94C15002F5A3CE15B1428EB074")
    
public void parse (InputSource input)
    throws IOException, SAXException
    {
    if (parsing) {
        throw new SAXException("Parser is already in use");
    }
    setupParser();
    parsing = true;
    try {
        parser.parse(input);
    } finally {
        parsing = false;
    }
    parsing = false;
    }

    ////////////////////////////////////////////////////////////////////
    // Implementation of org.xml.sax.DocumentHandler.
    ////////////////////////////////////////////////////////////////////

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 document locator event.
     *
     * @param locator A document locator.
     * @see org.xml.sax.ContentHandler#setDocumentLocator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.314 -0500", hash_original_method = "88280AABBB79C1920DB5BD8874CDE919", hash_generated_method = "B27B4B093EED39A2B8B5BFE1ECB0DD74")
    
public void setDocumentLocator (Locator locator)
    {
    this.locator = locator;
    if (contentHandler != null) {
        contentHandler.setDocumentLocator(locator);
    }
    }

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 start document event.
     *
     * @exception SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.DocumentHandler#startDocument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.316 -0500", hash_original_method = "37B6C1FF254D8E50BAF9132487F1B989", hash_generated_method = "3DE600CDC9146E206D3FBB07098CC288")
    
public void startDocument ()
    throws SAXException
    {
    if (contentHandler != null) {
        contentHandler.startDocument();
    }
    }

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 end document event.
     *
     * @exception SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.DocumentHandler#endDocument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.318 -0500", hash_original_method = "B39D6D1260080244B44CBF7BC9D51D96", hash_generated_method = "F9AB658D9C1B1CE59DBA818F156F2BB9")
    
public void endDocument ()
    throws SAXException
    {
    if (contentHandler != null) {
        contentHandler.endDocument();
    }
    }

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 startElement event.
     *
     * <p>If necessary, perform Namespace processing.</p>
     *
     * @param qName The qualified (prefixed) name.
     * @param qAtts The XML attribute list (with qnames).
     * @exception SAXException The client may raise a
     *            processing exception.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.323 -0500", hash_original_method = "41EBA2EAF373C2E18FF1DC39DB5B0A24", hash_generated_method = "4BC37B5677B6027DE42CCB7478AA9851")
    
public void startElement (String qName, AttributeList qAtts) throws SAXException {
        // These are exceptions from the
        // first pass; they should be
        // ignored if there's a second pass,
        // but reported otherwise.
        ArrayList<SAXParseException> exceptions = null;

                // If we're not doing Namespace
                // processing, dispatch this quickly.
    if (!namespaces) {
        if (contentHandler != null) {
        attAdapter.setAttributeList(qAtts);
        contentHandler.startElement("", "", qName.intern(),
                        attAdapter);
        }
        return;
    }

                // OK, we're doing Namespace processing.
    nsSupport.pushContext();
    int length = qAtts.getLength();

                // First pass:  handle NS decls
    for (int i = 0; i < length; i++) {
        String attQName = qAtts.getName(i);

        if (!attQName.startsWith("xmlns"))
        continue;
                // Could be a declaration...
        String prefix;
        int n = attQName.indexOf(':');

                    // xmlns=...
        if (n == -1 && attQName.length () == 5) {
        prefix = "";
        } else if (n != 5) {
        // XML namespaces spec doesn't discuss "xmlnsf:oo"
        // (and similarly named) attributes ... at most, warn
        continue;
        } else         // xmlns:foo=...
        prefix = attQName.substring(n+1);

        String value = qAtts.getValue(i);
        if (!nsSupport.declarePrefix(prefix, value)) {
        reportError("Illegal Namespace prefix: " + prefix);
        continue;
        }
        if (contentHandler != null)
        contentHandler.startPrefixMapping(prefix, value);
    }

                // Second pass: copy all relevant
                // attributes into the SAX2 AttributeList
                // using updated prefix bindings
    atts.clear();
    for (int i = 0; i < length; i++) {
        String attQName = qAtts.getName(i);
        String type = qAtts.getType(i);
        String value = qAtts.getValue(i);

                // Declaration?
        if (attQName.startsWith("xmlns")) {
        String prefix;
        int n = attQName.indexOf(':');

        if (n == -1 && attQName.length () == 5) {
            prefix = "";
        } else if (n != 5) {
            // XML namespaces spec doesn't discuss "xmlnsf:oo"
            // (and similarly named) attributes ... ignore
            prefix = null;
        } else {
            prefix = attQName.substring(6);
        }
                // Yes, decl:  report or prune
        if (prefix != null) {
            if (prefixes) {
            if (uris)
                // note funky case:  localname can be null
                // when declaring the default prefix, and
                // yet the uri isn't null.
                atts.addAttribute (nsSupport.XMLNS, prefix,
                    attQName.intern(), type, value);
            else
                atts.addAttribute ("", "",
                    attQName.intern(), type, value);
            }
            continue;
        }
        }

                // Not a declaration -- report
        try {
        String attName[] = processName(attQName, true, true);
        atts.addAttribute(attName[0], attName[1], attName[2],
                  type, value);
        } catch (SAXException e) {
            if (exceptions == null) {
                exceptions = new ArrayList<SAXParseException>();
            }
            exceptions.add((SAXParseException) e);
            atts.addAttribute("", attQName, attQName, type, value);
        }
    }

    // now handle the deferred exception reports
    if (exceptions != null && errorHandler != null) {
        for (SAXParseException ex : exceptions) {
            errorHandler.error(ex);
        }
    }

                // OK, finally report the event.
    if (contentHandler != null) {
        String name[] = processName(qName, false, false);
        contentHandler.startElement(name[0], name[1], name[2], atts);
    }
    }

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 end element event.
     *
     * @param qName The qualified (prefixed) name.
     * @exception SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.DocumentHandler#endElement
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.325 -0500", hash_original_method = "85074EE9682A2A9BF13F64A0DA58B9BC", hash_generated_method = "B138EB5B93DA05A5788C8DE0A12B3A73")
    
public void endElement (String qName)
    throws SAXException
    {
                // If we're not doing Namespace
                // processing, dispatch this quickly.
    if (!namespaces) {
        if (contentHandler != null) {
        contentHandler.endElement("", "", qName.intern());
        }
        return;
    }

                // Split the name.
    String names[] = processName(qName, false, false);
    if (contentHandler != null) {
        contentHandler.endElement(names[0], names[1], names[2]);
        Enumeration prefixes = nsSupport.getDeclaredPrefixes();
        while (prefixes.hasMoreElements()) {
        String prefix = (String)prefixes.nextElement();
        contentHandler.endPrefixMapping(prefix);
        }
    }
    nsSupport.popContext();
    }

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 characters event.
     *
     * @param ch An array of characters.
     * @param start The starting position in the array.
     * @param length The number of characters to use.
     * @exception SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.DocumentHandler#characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.327 -0500", hash_original_method = "C666B3AD5E916677AE6610DC5A0840E2", hash_generated_method = "332ECFB013A8F91084B6B4B5CC989D3B")
    
public void characters (char ch[], int start, int length)
    throws SAXException
    {
    if (contentHandler != null) {
        contentHandler.characters(ch, start, length);
    }
    }

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 ignorable whitespace event.
     *
     * @param ch An array of characters.
     * @param start The starting position in the array.
     * @param length The number of characters to use.
     * @exception SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.DocumentHandler#ignorableWhitespace
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.330 -0500", hash_original_method = "89B5E71C200F956D34BEB259DC06F56D", hash_generated_method = "04506C65091FE957E3D075DA59A54A05")
    
public void ignorableWhitespace (char ch[], int start, int length)
    throws SAXException
    {
    if (contentHandler != null) {
        contentHandler.ignorableWhitespace(ch, start, length);
    }
    }

    /**
     * Adapter implementation method; do not call.
     * Adapt a SAX1 processing instruction event.
     *
     * @param target The processing instruction target.
     * @param data The remainder of the processing instruction
     * @exception SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.DocumentHandler#processingInstruction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.332 -0500", hash_original_method = "A537A06A51D1B98674021AAB895861DD", hash_generated_method = "9473E555FD0E729E909574712BAAF604")
    
public void processingInstruction (String target, String data)
    throws SAXException
    {
    if (contentHandler != null) {
        contentHandler.processingInstruction(target, data);
    }
    }

    ////////////////////////////////////////////////////////////////////
    // Internal utility methods.
    ////////////////////////////////////////////////////////////////////

    /**
     * Initialize the parser before each run.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.334 -0500", hash_original_method = "43648C78921975CBE3898500F19AF8D8", hash_generated_method = "9F1F2C486D2A19A1E8416EFED0962777")
    
private void setupParser ()
    {
    // catch an illegal "nonsense" state.
    if (!prefixes && !namespaces)
        throw new IllegalStateException ();

    nsSupport.reset();
    if (uris)
        nsSupport.setNamespaceDeclUris (true);

    if (entityResolver != null) {
        parser.setEntityResolver(entityResolver);
    }
    if (dtdHandler != null) {
        parser.setDTDHandler(dtdHandler);
    }
    if (errorHandler != null) {
        parser.setErrorHandler(errorHandler);
    }
    parser.setDocumentHandler(this);
    locator = null;
    }
    
    final class AttributeListAdapter implements Attributes {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.410 -0500", hash_original_field = "CC06505CCCFB5DA974CBD3100BF339C4", hash_generated_field = "05A4A4B78CD79FD60575BA538F5EFA68")

    private AttributeList qAtts;

    /**
     * Construct a new adapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.378 -0500", hash_original_method = "C1264636A1B4EA8B9B687011C8022954", hash_generated_method = "C1264636A1B4EA8B9B687011C8022954")
        
AttributeListAdapter ()
    {
    }

    /**
     * Set the embedded AttributeList.
     *
     * <p>This method must be invoked before any of the others
     * can be used.</p>
     *
     * @param The SAX1 attribute list (with qnames).
     */
    @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.380 -0500", hash_original_method = "5931F172E3791972ECDA205EAC9CCB14", hash_generated_method = "5931F172E3791972ECDA205EAC9CCB14")
        
void setAttributeList (AttributeList qAtts)
    {
        this.qAtts = qAtts;
    }

    /**
     * Return the length of the attribute list.
     *
     * @return The number of attributes in the list.
     * @see org.xml.sax.Attributes#getLength
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.382 -0500", hash_original_method = "B156048BB95084F4BF5D28EF31B66C03", hash_generated_method = "BB20AE79DB45D67F0F3D2CAAE7AB4AF8")
        
public int getLength ()
    {
        return qAtts.getLength();
    }

    /**
     * Return the Namespace URI of the specified attribute.
     *
     * @param The attribute's index.
     * @return Always the empty string.
     * @see org.xml.sax.Attributes#getURI
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.385 -0500", hash_original_method = "20CEB246971EBBCECBF2ACA441CBBECD", hash_generated_method = "12493DA6D8A53DEB8E0C0336711DA59E")
        
public String getURI (int i)
    {
        return "";
    }

    /**
     * Return the local name of the specified attribute.
     *
     * @param The attribute's index.
     * @return Always the empty string.
     * @see org.xml.sax.Attributes#getLocalName
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.387 -0500", hash_original_method = "FEDFFD9A667A49103BC32EE7ED61A0BB", hash_generated_method = "653E3788236731D8C6F4042D9D754641")
        
public String getLocalName (int i)
    {
        return "";
    }

    /**
     * Return the qualified (prefixed) name of the specified attribute.
     *
     * @param The attribute's index.
     * @return The attribute's qualified name, internalized.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.390 -0500", hash_original_method = "A764D8ED68137C2EBCBCEF1CD153F6C1", hash_generated_method = "5AB18488028B84E4036A93C3452EE29A")
        
public String getQName (int i)
    {
        return qAtts.getName(i).intern();
    }

    /**
     * Return the type of the specified attribute.
     *
     * @param The attribute's index.
     * @return The attribute's type as an internalized string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.392 -0500", hash_original_method = "27E76BA5C0D6AD663690DDCFFED2A8A3", hash_generated_method = "193D661C4E791CE613D2F492C39B89C9")
        
public String getType (int i)
    {
        return qAtts.getType(i).intern();
    }

    /**
     * Return the value of the specified attribute.
     *
     * @param The attribute's index.
     * @return The attribute's value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.394 -0500", hash_original_method = "F0679796EDFA7C65CB4AD5C7F9CBE1FC", hash_generated_method = "59CFC8024232ED8BA11D0FF2A002F6A6")
        
public String getValue (int i)
    {
        return qAtts.getValue(i);
    }

    /**
     * Look up an attribute index by Namespace name.
     *
     * @param uri The Namespace URI or the empty string.
     * @param localName The local name.
     * @return The attributes index, or -1 if none was found.
     * @see org.xml.sax.Attributes#getIndex(java.lang.String,java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.397 -0500", hash_original_method = "696F42D8785320084719A8378B03A3E8", hash_generated_method = "D2D5493D836847193C5E4EDE9C680A79")
        
public int getIndex (String uri, String localName)
    {
        return -1;
    }

    /**
     * Look up an attribute index by qualified (prefixed) name.
     *
     * @param qName The qualified name.
     * @return The attributes index, or -1 if none was found.
     * @see org.xml.sax.Attributes#getIndex(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.399 -0500", hash_original_method = "9B76649071044C2724A0BCBC3CC4F1FF", hash_generated_method = "759A194268FE9C9AD4F1D6AE804DB391")
        
public int getIndex (String qName)
    {
        int max = atts.getLength();
        for (int i = 0; i < max; i++) {
        if (qAtts.getName(i).equals(qName)) {
            return i;
        }
        }
        return -1;
    }

    /**
     * Look up the type of an attribute by Namespace name.
     *
     * @param uri The Namespace URI
     * @param localName The local name.
     * @return The attribute's type as an internalized string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.401 -0500", hash_original_method = "DB45F41F9C44849C439912CF28FC6F39", hash_generated_method = "880C294A7EAE6D836392E2BE5ECC821A")
        
public String getType (String uri, String localName)
    {
        return null;
    }

    /**
     * Look up the type of an attribute by qualified (prefixed) name.
     *
     * @param qName The qualified name.
     * @return The attribute's type as an internalized string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.403 -0500", hash_original_method = "20D0A7881E2746A3B90C82673591E46C", hash_generated_method = "7FAD01855AFB4E51EBA5E4D04C5795C8")
        
public String getType (String qName)
    {
        return qAtts.getType(qName).intern();
    }

    /**
     * Look up the value of an attribute by Namespace name.
     *
     * @param uri The Namespace URI
     * @param localName The local name.
     * @return The attribute's value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.406 -0500", hash_original_method = "A923F17E07DEE910B88DBEE5B2421501", hash_generated_method = "F23C4745139D5FB53F0FBCBD0566CDFA")
        
public String getValue (String uri, String localName)
    {
        return null;
    }

    /**
     * Look up the value of an attribute by qualified (prefixed) name.
     *
     * @param qName The qualified name.
     * @return The attribute's value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.408 -0500", hash_original_method = "E305D94D7DAD816250B349D4183FD8D8", hash_generated_method = "D9A2660789A3C908966C2DA35937C9E0")
        
public String getValue (String qName)
    {
        return qAtts.getValue(qName);
    }
        
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.544 -0400", hash_original_method = "295B884B2E4E1E5DF2659FCF14AB7437", hash_generated_method = "A63E40ABA0ADB07D109396D7430691CA")
    private String [] processName(String qName, boolean isAttribute,
                   boolean useException) throws SAXException {
        addTaint(useException);
        addTaint(isAttribute);
        addTaint(qName.getTaint());
        String parts[] = nsSupport.processName(qName, nameParts,
                           isAttribute);
    if(parts == null)        
        {
    if(useException)            
            {
            SAXParseException var854AD97C008FC0C49293EF8835D8E041_564975120 = makeException("Undeclared prefix: " + qName);
            var854AD97C008FC0C49293EF8835D8E041_564975120.addTaint(taint);
            throw var854AD97C008FC0C49293EF8835D8E041_564975120;
            }
            reportError("Undeclared prefix: " + qName);
            parts = new String[3];
            parts[0] = parts[1] = "";
            parts[2] = qName.intern();
        } //End block
String [] var6651EAC2994005EE903B8D00ACB7442E_128503195 =         parts;
        var6651EAC2994005EE903B8D00ACB7442E_128503195.addTaint(taint);
        return var6651EAC2994005EE903B8D00ACB7442E_128503195;
        // ---------- Original Method ----------
        //String parts[] = nsSupport.processName(qName, nameParts,
                           //isAttribute);
        //if (parts == null) {
        //if (useException)
        //throw makeException("Undeclared prefix: " + qName);
        //reportError("Undeclared prefix: " + qName);
        //parts = new String[3];
        //parts[0] = parts[1] = "";
        //parts[2] = qName.intern();
    //}
        //return parts;
    }

    /**
     * Report a non-fatal error.
     *
     * @param message The error message.
     * @exception SAXException The client may throw
     *            an exception.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.339 -0500", hash_original_method = "FBBB3C346433F99D88D798BC2E1AE3CE", hash_generated_method = "FBBB3C346433F99D88D798BC2E1AE3CE")
    
void reportError (String message)
    throws SAXException
    {
    if (errorHandler != null)
        errorHandler.error(makeException(message));
    }

    /**
     * Construct an exception for the current context.
     *
     * @param message The error message.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.341 -0500", hash_original_method = "E1E473BD4A5E19C1B1699A01EEA95F9A", hash_generated_method = "9454753F528D595880A1AA56F6EBAA6D")
    
private SAXParseException makeException (String message)
    {
    if (locator != null) {
        return new SAXParseException(message, locator);
    } else {
        return new SAXParseException(message, null, null, -1, -1);
    }
    }

    /**
     * Throw an exception if we are parsing.
     *
     * <p>Use this method to detect illegal feature or
     * property changes.</p>
     *
     * @param type The type of thing (feature or property).
     * @param name The feature or property name.
     * @exception SAXNotSupportedException If a
     *            document is currently being parsed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.343 -0500", hash_original_method = "2915748C93DEC7F425A1836D3BEC9D20", hash_generated_method = "AFF8CCDD36BE6B6DEE077BD930AED755")
    
private void checkNotParsing (String type, String name)
    throws SAXNotSupportedException
    {
    if (parsing) {
        throw new SAXNotSupportedException("Cannot change " +
                           type + ' ' +
                           name + " while parsing");

    }
    }
}

