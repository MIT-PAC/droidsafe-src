package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import libcore.io.IoUtils;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ext.LexicalHandler;





import droidsafe.helpers.DSUtils;

class ExpatParser {

    
    @DSModeled(DSC.SAFE)
    private static int createEntityParser(int parentPointer, String context) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void releaseParser(int pointer) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void staticInitialize(String emptyString) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int line(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int column(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int cloneAttributes(int pointer, int attributeCount) {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Opens an InputStream for the given URL.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.370 -0500", hash_original_method = "58E4A281E06F713A765399D511C2B585", hash_generated_method = "CDCAFDD275A693A2543A5DF9E786274C")
    
static InputStream openUrl(String url) throws IOException {
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.setConnectTimeout(TIMEOUT);
            urlConnection.setReadTimeout(TIMEOUT);
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(false);
            return urlConnection.getInputStream();
        } catch (Exception e) {
            IOException ioe = new IOException("Couldn't open " + url);
            ioe.initCause(e);
            throw ioe;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.152 -0500", hash_original_field = "78D8EC56D336F89A6014B039F0C2BF38", hash_generated_field = "A64DAE236D33721DE2FB44FFC0928678")


    private static final int BUFFER_SIZE = 8096;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.178 -0500", hash_original_field = "3B7617F29A6438A457F851ED22816624", hash_generated_field = "A08506C5912D951D1976A5B09A1419D6")


    private static final String OUTSIDE_START_ELEMENT
            = "Attributes can only be used within the scope of startElement().";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.181 -0500", hash_original_field = "5660948E44B63FC73A55AD401702B233", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.183 -0500", hash_original_field = "EC278A59BD4ADCCB5BAD3A8238DF2C9D", hash_generated_field = "A5A56EA46292250B311AC8B2F5A3016C")

    /*package*/ static final String CHARACTER_ENCODING = "UTF-16";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.185 -0500", hash_original_field = "B1D346D87DD320E0ED26252DE507E6A2", hash_generated_field = "8F4372ADE8F9F81D831F4EBF1AAB89E5")

    private static final int TIMEOUT = 20 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.155 -0500", hash_original_field = "AB07E4221CA20C9A461D941058B9A5BE", hash_generated_field = "73E4D9A47F5F138CD4D128E1EA14902F")


    /** Pointer to XML_Parser instance. */
    private int pointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.157 -0500", hash_original_field = "0E9848D6D30DA7AACB5B6B5BA5A1B1C3", hash_generated_field = "7AE5C3866E266124176520F985884913")


    private boolean inStartElement = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.159 -0500", hash_original_field = "3E65C4577E8EDD126DE0C57010978492", hash_generated_field = "7130FCC160E4FC4EA6A7052FB1FDD986")

    private int attributeCount = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.161 -0500", hash_original_field = "914ECE23066139183A3FBA83A4333C14", hash_generated_field = "6903FA8331974EA5B8786753E4D814EB")

    private int attributePointer = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.163 -0500", hash_original_field = "AB8B6DE975C24CE67BCB33C20D21DF2E", hash_generated_field = "831B23B1055E5A04D60D35B3B396FFC8")


    private final Locator locator = new ExpatLocator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.166 -0500", hash_original_field = "2F984065B6308DC7EE31E580785E5F98", hash_generated_field = "703C38EABA8EBF65E6BC35CB8C8EF9C3")


    private  ExpatReader xmlReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.168 -0500", hash_original_field = "A787D4782D28CB658656F9CEA39140B8", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")


    private  String publicId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.171 -0500", hash_original_field = "EA33D5D9FADC1DE12A306FAB26B3A5DA", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private  String systemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.173 -0500", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")


    private  String encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.176 -0500", hash_original_field = "136D7AF3EFC0289E090FCAAF885FEC7E", hash_generated_field = "F3F026228715567E77DB92EA66C8CF66")


    private final ExpatAttributes attributes = new CurrentAttributes();

    /**
     * Constructs a new parser with the specified encoding.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.188 -0500", hash_original_method = "08191F20EE47B985A8EBB31C0BB98A5A", hash_generated_method = "D632B6A54660D3E9782C6BB45A6F40D1")
    
ExpatParser(String encoding, ExpatReader xmlReader,
            boolean processNamespaces, String publicId, String systemId) {
        this.publicId = publicId;
        this.systemId = systemId;

        this.xmlReader = xmlReader;

        /*
         * TODO: Let Expat try to guess the encoding instead of defaulting.
         * Unfortunately, I don't know how to tell which encoding Expat picked,
         * so I won't know how to encode "<externalEntity>" below. The solution
         * I think is to fix Expat to not require the "<externalEntity>"
         * workaround.
         */
        this.encoding = encoding == null ? DEFAULT_ENCODING : encoding;
        this.pointer = initialize(
            this.encoding,
            processNamespaces
        );
    }

    /**
     * Used by {@link EntityParser}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.191 -0500", hash_original_method = "289A44034A9CB52BBF40849A78C9DFF1", hash_generated_method = "58816C27FB48CF39F778629A14AA2AC3")
    
private ExpatParser(String encoding, ExpatReader xmlReader, int pointer,
            String publicId, String systemId) {
        this.encoding = encoding;
        this.xmlReader = xmlReader;
        this.pointer = pointer;
        this.systemId = systemId;
        this.publicId = publicId;
    }

    /**
     * Initializes native resources.
     *
     * @return the pointer to the native parser
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.196 -0500", hash_original_method = "650F081790BC185B19FA56BA8A79A45A", hash_generated_method = "D5439BB5B45E268FEFC3CCEEDFFC3DC6")
    
    private int initialize(String encoding, boolean namespacesEnabled){
    	//Formerly a native method
    	addTaint(encoding.getTaint());
    	addTaint(namespacesEnabled);
    	return getTaintInt();
    }


    /**
     * Called at the start of an element.
     *
     * @param uri namespace URI of element or "" if namespace processing is
     *  disabled
     * @param localName local name of element or "" if namespace processing is
     *  disabled
     * @param qName qualified name or "" if namespace processing is enabled
     * @param attributePointer pointer to native attribute char*--we keep
     *  a separate pointer so we can detach it from the parser instance
     * @param attributeCount number of attributes
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.198 -0500", hash_original_method = "6539B8063CABFAD0D8EBA84883A1CF66", hash_generated_method = "6539B8063CABFAD0D8EBA84883A1CF66")
    
void startElement(String uri, String localName, String qName,
            int attributePointer, int attributeCount) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        if (contentHandler == null) {
            return;
        }

        try {
            inStartElement = true;
            this.attributePointer = attributePointer;
            this.attributeCount = attributeCount;

            contentHandler.startElement(
                    uri, localName, qName, this.attributes);
        } finally {
            inStartElement = false;
            this.attributeCount = -1;
            this.attributePointer = 0;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.200 -0500", hash_original_method = "50FE3627F5F6FDC1AED1DF8ACC8DE2FD", hash_generated_method = "50FE3627F5F6FDC1AED1DF8ACC8DE2FD")
    
void endElement(String uri, String localName, String qName)
            throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.endElement(uri, localName, qName);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.202 -0500", hash_original_method = "79BE0B0DC27CFEFE439A5FDC5A1CA160", hash_generated_method = "79BE0B0DC27CFEFE439A5FDC5A1CA160")
    
void text(char[] text, int length) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.characters(text, 0, length);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.204 -0500", hash_original_method = "6B257C024B729A7D66F9A83E533EB63B", hash_generated_method = "6B257C024B729A7D66F9A83E533EB63B")
    
void comment(char[] text, int length) throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.comment(text, 0, length);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.206 -0500", hash_original_method = "93DE4882575147F90A7802ED6EFEB9E6", hash_generated_method = "93DE4882575147F90A7802ED6EFEB9E6")
    
void startCdata() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startCDATA();
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.208 -0500", hash_original_method = "B0BCA5163C38A135047EC44559B3E39B", hash_generated_method = "B0BCA5163C38A135047EC44559B3E39B")
    
void endCdata() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endCDATA();
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.210 -0500", hash_original_method = "C8BFB5467C9B61347AC273E622412632", hash_generated_method = "C8BFB5467C9B61347AC273E622412632")
    
void startNamespace(String prefix, String uri)
            throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.startPrefixMapping(prefix, uri);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.212 -0500", hash_original_method = "386BB3F5F69DADA0341AED81D1A7D2AD", hash_generated_method = "386BB3F5F69DADA0341AED81D1A7D2AD")
    
void endNamespace(String prefix) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.endPrefixMapping(prefix);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.215 -0500", hash_original_method = "08337DADA79B09679000AC18FB47E35A", hash_generated_method = "08337DADA79B09679000AC18FB47E35A")
    
void startDtd(String name, String publicId, String systemId)
            throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startDTD(name, publicId, systemId);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.217 -0500", hash_original_method = "3F3F92A9168E402E1B573BC06B982B7C", hash_generated_method = "3F3F92A9168E402E1B573BC06B982B7C")
    
void endDtd() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endDTD();
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.219 -0500", hash_original_method = "4656A390E6416859EC1D4943284352B2", hash_generated_method = "4656A390E6416859EC1D4943284352B2")
    
void processingInstruction(String target, String data)
            throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.processingInstruction(target, data);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.221 -0500", hash_original_method = "4F245ABB6EDD8047A0954DBD28029CF8", hash_generated_method = "4F245ABB6EDD8047A0954DBD28029CF8")
    
void notationDecl(String name, String publicId, String systemId) throws SAXException {
        DTDHandler dtdHandler = xmlReader.dtdHandler;
        if (dtdHandler != null) {
            dtdHandler.notationDecl(name, publicId, systemId);
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.224 -0500", hash_original_method = "E5C69ABE155B5E114D9566A25B0FC75A", hash_generated_method = "E5C69ABE155B5E114D9566A25B0FC75A")
    
void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) throws SAXException {
        DTDHandler dtdHandler = xmlReader.dtdHandler;
        if (dtdHandler != null) {
            dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        }
    }

    /**
     * Handles an external entity.
     *
     * @param context to be passed back to Expat when we parse the entity
     * @param publicId the publicId of the entity
     * @param systemId the systemId of the entity
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.227 -0500", hash_original_method = "DBF93F6482092FD1B1DD0B14B0D97B21", hash_generated_method = "52F16005BD1B2C063C973E495CF61BDB")
    
void handleExternalEntity(String context, String publicId,
            String systemId) throws SAXException, IOException {
        EntityResolver entityResolver = xmlReader.entityResolver;
        if (entityResolver == null) {
            return;
        }

        /*
         * The spec. is terribly under-specified here. It says that if the
         * systemId is a URL, we should try to resolve it, but it doesn't
         * specify how to tell whether or not the systemId is a URL let alone
         * how to resolve it.
         *
         * Other implementations do various insane things. We try to keep it
         * simple: if the systemId parses as a URI and it's relative, we try to
         * resolve it against the parent document's systemId. If anything goes
         * wrong, we go with the original systemId. If crazybob had designed
         * the API, he would have left all resolving to the EntityResolver.
         */
        if (this.systemId != null) {
            try {
                URI systemUri = new URI(systemId);
                if (!systemUri.isAbsolute() && !systemUri.isOpaque()) {
                    // It could be relative (or it may not be a URI at all!)
                    URI baseUri = new URI(this.systemId);
                    systemUri = baseUri.resolve(systemUri);

                    // Replace systemId w/ resolved URI
                    systemId = systemUri.toString();
                }
            } catch (Exception e) {
                System.logI("Could not resolve '" + systemId + "' relative to"
                        + " '" + this.systemId + "' at " + locator, e);
            }
        }

        InputSource inputSource = entityResolver.resolveEntity(
                publicId, systemId);
        if (inputSource == null) {
            /*
             * The spec. actually says that we should try to treat systemId
             * as a URL and download and parse its contents here, but an
             * entity resolver can easily accomplish the same by returning
             * new InputSource(systemId).
             *
             * Downloading external entities by default would result in several
             * unwanted DTD downloads, not to mention pose a security risk
             * when parsing untrusted XML -- see for example
             * http://archive.cert.uni-stuttgart.de/bugtraq/2002/10/msg00421.html --
             * so we just do nothing instead. This also enables the user to
             * opt out of entity parsing when using
             * {@link org.xml.sax.helpers.DefaultHandler}, something that
             * wouldn't be possible otherwise.
             */
            return;
        }

        String encoding = pickEncoding(inputSource);
        int pointer = createEntityParser(this.pointer, context);
        try {
            EntityParser entityParser = new EntityParser(encoding, xmlReader,
                    pointer, inputSource.getPublicId(),
                    inputSource.getSystemId());

            parseExternalEntity(entityParser, inputSource);
        } finally {
            releaseParser(pointer);
        }
    }

    /**
     * Picks an encoding for an external entity. Defaults to UTF-8.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.230 -0500", hash_original_method = "0D6C1F8897C50F2325542C54551DAF6A", hash_generated_method = "C0F44909E0B5955DCDF981ADDD47B6F6")
    
private String pickEncoding(InputSource inputSource) {
        Reader reader = inputSource.getCharacterStream();
        if (reader != null) {
            return CHARACTER_ENCODING;
        }

        String encoding = inputSource.getEncoding();
        return encoding == null ? DEFAULT_ENCODING : encoding;
    }

    /**
     * Parses the the external entity provided by the input source.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.233 -0500", hash_original_method = "43999A16FC6A2BCB60CE78FA610F37AD", hash_generated_method = "CAA6FAED36ECA1054AC22F42FB17400E")
    
private void parseExternalEntity(ExpatParser entityParser,
            InputSource inputSource) throws IOException, SAXException {
        /*
         * Expat complains if the external entity isn't wrapped with a root
         * element so we add one and ignore it later on during parsing.
         */

        // Try the character stream.
        Reader reader = inputSource.getCharacterStream();
        if (reader != null) {
            try {
                entityParser.append("<externalEntity>");
                entityParser.parseFragment(reader);
                entityParser.append("</externalEntity>");
            } finally {
                IoUtils.closeQuietly(reader);
            }
            return;
        }

        // Try the byte stream.
        InputStream in = inputSource.getByteStream();
        if (in != null) {
            try {
                entityParser.append("<externalEntity>"
                        .getBytes(entityParser.encoding));
                entityParser.parseFragment(in);
                entityParser.append("</externalEntity>"
                        .getBytes(entityParser.encoding));
            } finally {
                IoUtils.closeQuietly(in);
            }
            return;
        }

        // Make sure we use the user-provided systemId.
        String systemId = inputSource.getSystemId();
        if (systemId == null) {
            // TODO: We could just try our systemId here.
            throw new ParseException("No input specified.", locator);
        }

        // Try the system id.
        in = openUrl(systemId);
        try {
            entityParser.append("<externalEntity>"
                    .getBytes(entityParser.encoding));
            entityParser.parseFragment(in);
            entityParser.append("</externalEntity>"
                    .getBytes(entityParser.encoding));
        } finally {
            IoUtils.closeQuietly(in);
        }
    }

    /**
     * Appends part of an XML document. This parser will parse the given XML to
     * the extent possible and dispatch to the appropriate methods.
     *
     * @param xml a whole or partial snippet of XML
     * @throws SAXException if an error occurs during parsing
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.239 -0500", hash_original_method = "DD8A0FE95AA726B14C9A7464570F0B95", hash_generated_method = "DD8A0FE95AA726B14C9A7464570F0B95")
    
void append(String xml) throws SAXException {
        try {
            appendString(this.pointer, xml, false);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.242 -0500", hash_original_method = "9EF978047B32CC4B7F73DD218F12B5B2", hash_generated_method = "EF6D58A448768C451021CB234A498E12")
    
    private void appendString(int pointer, String xml, boolean isFinal)
                throws SAXException, ExpatException{
    	//Formerly a native method
    	addTaint(pointer);
    	addTaint(xml.getTaint());
    	addTaint(isFinal);
    }


    /**
     * Appends part of an XML document. This parser will parse the given XML to
     * the extent possible and dispatch to the appropriate methods.
     *
     * @param xml a whole or partial snippet of XML
     * @param offset into the char[]
     * @param length of characters to use
     * @throws SAXException if an error occurs during parsing
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.244 -0500", hash_original_method = "E534E6CFFABE07F7DCCE5DEDEA13040B", hash_generated_method = "E534E6CFFABE07F7DCCE5DEDEA13040B")
    
void append(char[] xml, int offset, int length)
            throws SAXException {
        try {
            appendChars(this.pointer, xml, offset, length);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.249 -0500", hash_original_method = "49A4641A93DAB70A1876B4EB02B18B5D", hash_generated_method = "2E42AA5BAC3097585CF7831F05DDD24C")
    
    private void appendChars(int pointer, char[] xml, int offset,
                int length) throws SAXException, ExpatException{
    	//Formerly a native method
    	addTaint(pointer);
    	addTaint(xml[0]);
    	addTaint(offset);
    	addTaint(length);
    }


    /**
     * Appends part of an XML document. This parser will parse the given XML to
     * the extent possible and dispatch to the appropriate methods.
     *
     * @param xml a whole or partial snippet of XML
     * @throws SAXException if an error occurs during parsing
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.251 -0500", hash_original_method = "DB127BCAFE6AA42D44BF28FF8E448923", hash_generated_method = "DB127BCAFE6AA42D44BF28FF8E448923")
    
void append(byte[] xml) throws SAXException {
        append(xml, 0, xml.length);
    }

    /**
     * Appends part of an XML document. This parser will parse the given XML to
     * the extent possible and dispatch to the appropriate methods.
     *
     * @param xml a whole or partial snippet of XML
     * @param offset into the byte[]
     * @param length of bytes to use
     * @throws SAXException if an error occurs during parsing
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.254 -0500", hash_original_method = "6B7A6AA30AC9918948A2664C57D48C07", hash_generated_method = "6B7A6AA30AC9918948A2664C57D48C07")
    
void append(byte[] xml, int offset, int length)
            throws SAXException {
        try {
            appendBytes(this.pointer, xml, offset, length);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.258 -0500", hash_original_method = "F0951DAA750D508CD972B921A6749C41", hash_generated_method = "FA744DB6076EBFF512EC6F6434C88B18")
    
    private void appendBytes(int pointer, byte[] xml, int offset,
                int length) throws SAXException, ExpatException{
    	//Formerly a native method
    	addTaint(pointer);
    	addTaint(xml[0]);
    	addTaint(offset);
    	addTaint(length);
    }


    /**
     * Parses an XML document from the given input stream.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.260 -0500", hash_original_method = "4F86C73792633F9CAFFD2414652E6044", hash_generated_method = "4F86C73792633F9CAFFD2414652E6044")
    
void parseDocument(InputStream in) throws IOException,
            SAXException {
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
    }

    /**
     * Parses an XML Document from the given reader.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.262 -0500", hash_original_method = "D0C956420A79FC95538314A79FE6EF55", hash_generated_method = "D0C956420A79FC95538314A79FE6EF55")
    
void parseDocument(Reader in) throws IOException, SAXException {
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
    }

    /**
     * Parses XML from the given Reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.265 -0500", hash_original_method = "0C2DA7F13CAAE321089EB28883C484D4", hash_generated_method = "9D1C96C4E29944823F49260ADAD8981D")
    
private void parseFragment(Reader in) throws IOException, SAXException {
        char[] buffer = new char[BUFFER_SIZE / 2];
        int length;
        while ((length = in.read(buffer)) != -1) {
            try {
                appendChars(this.pointer, buffer, 0, length);
            } catch (ExpatException e) {
                throw new ParseException(e.getMessage(), locator);
            }
        }
    }

    /**
     * Parses XML from the given input stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.267 -0500", hash_original_method = "3CA57F292A4B96862265187DF8ED7F28", hash_generated_method = "B7D6D593ACA01293CE82D91E7B242D5B")
    
private void parseFragment(InputStream in)
            throws IOException, SAXException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while ((length = in.read(buffer)) != -1) {
            try {
                appendBytes(this.pointer, buffer, 0, length);
            } catch (ExpatException e) {
                throw new ParseException(e.getMessage(), this.locator);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.270 -0500", hash_original_method = "E29A8B5517BB7A594660A4782169D49D", hash_generated_method = "BB82E8B7C2003DFF3FEC3105C910E8EF")
    
private void startDocument() throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.setDocumentLocator(this.locator);
            contentHandler.startDocument();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.272 -0500", hash_original_method = "539A01ACC13B65DFCB758F0CE94D0284", hash_generated_method = "CF01E74AFC536561279BADBE1A08B889")
    
private void endDocument() throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        if (contentHandler != null) {
            contentHandler.endDocument();
        }
    }

    /**
     * Indicate that we're finished parsing.
     *
     * @throws SAXException if the xml is incomplete
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.274 -0500", hash_original_method = "BFCC6911ABBE3458CCFB4AC68FA2CC36", hash_generated_method = "BFCC6911ABBE3458CCFB4AC68FA2CC36")
    
void finish() throws SAXException {
        try {
            appendString(this.pointer, "", true);
        } catch (ExpatException e) {
            throw new ParseException(e.getMessage(), this.locator);
        }
    }

    
    private static class ClonedAttributes extends ExpatAttributes {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.310 -0500", hash_original_field = "9C7FE2EDC7BBB91A509A3E65C3C4981F", hash_generated_field = "9EEF20496C35220A780FB0DBE8DDDF03")


        private static final Attributes EMPTY = new ClonedAttributes(0, 0, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.313 -0500", hash_original_field = "585CBF428290485D7A9A443087F4DAAB", hash_generated_field = "F1200750FD64399CAB1B5625087F1715")


        private  int parserPointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.315 -0500", hash_original_field = "AB07E4221CA20C9A461D941058B9A5BE", hash_generated_field = "0AC27A3F0A4FBCD5C9DE4F17ACD0E1AC")

        private int pointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.318 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private  int length;

        /**
         * Constructs a Java wrapper for native attributes.
         *
         * @param parserPointer pointer to the parse, can be 0 if length is 0.
         * @param pointer pointer to the attributes array, can be 0 if the
         *  length is 0.
         * @param length number of attributes
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.321 -0500", hash_original_method = "045E6201A2106A3289C0B2900185AAE3", hash_generated_method = "FEDE9724C2C0685BF0392B60ED6AFB46")
        
private ClonedAttributes(int parserPointer, int pointer, int length) {
            this.parserPointer = parserPointer;
            this.pointer = pointer;
            this.length = length;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.323 -0500", hash_original_method = "81345E38E6C55A28DE606E0BCA6E5F93", hash_generated_method = "681017A548FEFA432FE739F64FA9E25D")
        
@Override
        public int getParserPointer() {
            return this.parserPointer;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.325 -0500", hash_original_method = "8BF0A90E7356097362ADB7AB9898D2BC", hash_generated_method = "C6E9E158EB44C108284F5F33B4C4AA0F")
        
@Override
        public int getPointer() {
            return pointer;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.328 -0500", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "10FC3BA0162E7D76668B0A5170B92D2D")
        
@Override
        public int getLength() {
            return length;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.330 -0500", hash_original_method = "BE4737CBAA88C90057E40AE694FFCC80", hash_generated_method = "05FA1C2566D62A79E4742E0D82B6BBCF")
        
@Override protected synchronized void finalize() throws Throwable {
            try {
                if (pointer != 0) {
                    freeAttributes(pointer);
                    pointer = 0;
                }
            } finally {
                super.finalize();
            }
        }
    }


    
    private class ExpatLocator implements Locator {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.086 -0400", hash_original_method = "64DD51F37170009BB48F8E01805F6CAF", hash_generated_method = "64DD51F37170009BB48F8E01805F6CAF")
        public ExpatLocator ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.335 -0500", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "C2B64346C205A83C958059FEF62D1E97")
        
public String getPublicId() {
            return publicId;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.337 -0500", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6A03DC8D49FB90AC37FD320CD622E272")
        
public String getSystemId() {
            return systemId;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.340 -0500", hash_original_method = "9A9541F7496758CF9181B7D5DBEDC898", hash_generated_method = "7790210D08DC90491F85751219830EFB")
        
public int getLineNumber() {
            return line();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.343 -0500", hash_original_method = "4EEF522BB99544999D89F5949A6FB044", hash_generated_method = "9420ACC58BCBBC9CFF044EC9217F2F43")
        
public int getColumnNumber() {
            return column();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.345 -0500", hash_original_method = "DD8FF3BEAAEB603642876DC8691E0663", hash_generated_method = "3F921D37E9C49AA7FDF9B0B5DB8CD029")
        
@Override
        public String toString() {
            return "Locator[publicId: " + publicId + ", systemId: " + systemId
                + ", line: " + getLineNumber()
                + ", column: " + getColumnNumber() + "]";
        }

        
    }


    
    private class CurrentAttributes extends ExpatAttributes {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.087 -0400", hash_original_method = "ACF7E0CCF646D645B704B296EF29F814", hash_generated_method = "ACF7E0CCF646D645B704B296EF29F814")
        public CurrentAttributes ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.350 -0500", hash_original_method = "A89638ADC5A1EBA87157983FC792900F", hash_generated_method = "F217EF76DE30015EAE3E935AEF47C123")
        
@Override
        public int getParserPointer() {
            return pointer;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.353 -0500", hash_original_method = "13948788E535A0F103A62D341F619BEF", hash_generated_method = "19A171051D6E81FFD2B0A6075AAD56E5")
        
@Override
        public int getPointer() {
            if (!inStartElement) {
                throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            }
            return attributePointer;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.355 -0500", hash_original_method = "27A61DE39F4EE665DACE4F17911F194F", hash_generated_method = "0EADB694A9EE889EDB586ABA927BD81E")
        
@Override
        public int getLength() {
            if (!inStartElement) {
                throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            }
            return attributeCount;
        }

        
    }


    
    private static class ParseException extends SAXParseException {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.363 -0500", hash_original_method = "58C60C87914EC8E24D1E75365C1B903C", hash_generated_method = "ED3EC96E4DF27595066398114C7ADB19")
        
private static String makeMessage(String message, Locator locator) {
            return makeMessage(message, locator.getLineNumber(),
                    locator.getColumnNumber());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.366 -0500", hash_original_method = "F00EFB085E12A09282C8F737567E696F", hash_generated_method = "08B0896A5C1670A1B59FB88E7D05EE65")
        
private static String makeMessage(
                String message, int line, int column) {
            return "At line " + line + ", column "
                    + column + ": " + message;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.360 -0500", hash_original_method = "35DD174A2C7D975B531B73E3C242E751", hash_generated_method = "A6E5ACC35C298CBAFE052F41E0AB63C8")
        
private ParseException(String message, Locator locator) {
            super(makeMessage(message, locator), locator);
        }

        
    }


    
    private static class EntityParser extends ExpatParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.372 -0500", hash_original_field = "CEA439F7416EC0580A35885BBE14AEF7", hash_generated_field = "1AF6664FDB28F42A843891FCC46FCB20")


        private int depth = 0;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.375 -0500", hash_original_method = "CA2C59BC199DD9BEE0B3FBB1838981DE", hash_generated_method = "E0C851129EA4B3DDB2E5DA63E0589CF7")
        
private EntityParser(String encoding, ExpatReader xmlReader,
                int pointer, String publicId, String systemId) {
            super(encoding, xmlReader, pointer, publicId, systemId);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.377 -0500", hash_original_method = "046BB8109CA52E8AB8C918C4992DC8E2", hash_generated_method = "8096A34B427AF4FCCD3AC387A564BBB1")
        
@Override
        void startElement(String uri, String localName, String qName,
                int attributePointer, int attributeCount) throws SAXException {
            /*
             * Skip topmost element generated by our workaround in
             * {@link #handleExternalEntity}.
             */
            if (depth++ > 0) {
                super.startElement(uri, localName, qName, attributePointer,
                        attributeCount);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.380 -0500", hash_original_method = "FFAA25EB14485D022C0B9C6B4C164D1D", hash_generated_method = "067C780E683275AE619C60881B06E755")
        
@Override
        void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (--depth > 0) {
                super.endElement(uri, localName, qName);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.383 -0500", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "94A4DBEA4F6F86977A5D34092AE563E3")
        
@Override
        @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
        protected synchronized void finalize() throws Throwable {
            /*
             * Don't release our native resources. We do so explicitly in
             * {@link #handleExternalEntity} and we don't want to release the
             * parsing context--our parent is using it.
             */
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.277 -0500", hash_original_method = "F20474D747FC599F8D46ABC255AE3ED8", hash_generated_method = "CEBA9F0D7466BCE459F1B33EF55E5ED0")
    
@Override protected synchronized void finalize() throws Throwable {
        try {
            if (this.pointer != 0) {
                release(this.pointer);
                this.pointer = 0;
            }
        } finally {
            super.finalize();
        }
    }

    /**
     * Releases all native objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.280 -0500", hash_original_method = "B8FAFDCBEF6ED1DBF49858CA951E344D", hash_generated_method = "8AA59EA901BC30D3E50F0E3A0F1E227C")
    
    private void release(int pointer){
    	//Formerly a native method
    	addTaint(pointer);
    }


    /**
     * Gets the current line number within the XML file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.290 -0500", hash_original_method = "06014D7BF95F9BC6196F9727E94F85D2", hash_generated_method = "E9517494F4BC21001B2B7B8478CB61B4")
    
private int line() {
        return line(this.pointer);
    }

    /**
     * Gets the current column number within the XML file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.297 -0500", hash_original_method = "F3C5081F1B5CC0FD86B00194F6A2466A", hash_generated_method = "648FAF5C1249CCF2DF0A74AC1A625A7A")
    
private int column() {
        return column(this.pointer);
    }

    /**
     * Clones the current attributes so they can be used outside of
     * startElement().
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.303 -0500", hash_original_method = "657780C747B6551FC5B90D954C172ACE", hash_generated_method = "657780C747B6551FC5B90D954C172ACE")
    
Attributes cloneAttributes() {
        if (!inStartElement) {
            throw new IllegalStateException(OUTSIDE_START_ELEMENT);
        }

        if (attributeCount == 0) {
            return ClonedAttributes.EMPTY;
        }

        int clonePointer
                = cloneAttributes(this.attributePointer, this.attributeCount);
        return new ClonedAttributes(pointer, clonePointer, attributeCount);
    }
    static {
        staticInitialize("");
    }
    
}

