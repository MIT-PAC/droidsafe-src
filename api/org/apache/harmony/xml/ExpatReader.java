package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import libcore.io.IoUtils;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;

public class ExpatReader implements XMLReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.909 -0500", hash_original_field = "D21F5EBFA260D1454028626166780495", hash_generated_field = "76D9E2DC4A0EBE3D6C94DF14707F99DB")

    private static final String LEXICAL_HANDLER_PROPERTY
            = "http://xml.org/sax/properties/lexical-handler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.893 -0500", hash_original_field = "F0B36C97F7B57E341954B85DB9C0C08E", hash_generated_field = "B810C7E3582651F6F9EFF1DC0B0536C8")

    /*package*/ ContentHandler contentHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.895 -0500", hash_original_field = "1DE4F92C3694DD72282E703A9C497860", hash_generated_field = "1DE4F92C3694DD72282E703A9C497860")
 DTDHandler dtdHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.897 -0500", hash_original_field = "0F20E0B3BF6506A85F7C0D2D3D40FE9D", hash_generated_field = "0F20E0B3BF6506A85F7C0D2D3D40FE9D")
 EntityResolver entityResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.899 -0500", hash_original_field = "D1E7497C7DFC94EB56211895742439AB", hash_generated_field = "D1E7497C7DFC94EB56211895742439AB")
 ErrorHandler errorHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.901 -0500", hash_original_field = "0A9AFAA2B0505C00F2ECAD506C3C72F7", hash_generated_field = "0A9AFAA2B0505C00F2ECAD506C3C72F7")
 LexicalHandler lexicalHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.903 -0500", hash_original_field = "54A4A3EB19F42CDA073264FCAA27B260", hash_generated_field = "DA06DC238CFD0DC0251460B8E2E7F05F")

    private boolean processNamespaces = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.906 -0500", hash_original_field = "A9925B994A6A2A865685842891CFAB8B", hash_generated_field = "571B94DE5D091BD853A513AE92780624")

    private boolean processNamespacePrefixes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.111 -0400", hash_original_method = "0527B9275A46E7773519FE6EE020706F", hash_generated_method = "0527B9275A46E7773519FE6EE020706F")
    public ExpatReader ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.933 -0500", hash_original_method = "783B372D10B457C55DE61BCE252421E8", hash_generated_method = "633186757CB29DE6CA782DFE0512D728")
    
public boolean getFeature(String name)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }

        if (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES)) {
            return false;
        }

        if (name.equals(Feature.NAMESPACES)) {
            return processNamespaces;
        }

        if (name.equals(Feature.NAMESPACE_PREFIXES)) {
            return processNamespacePrefixes;
        }

        if (name.equals(Feature.STRING_INTERNING)) {
            return true;
        }

        throw new SAXNotRecognizedException(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.936 -0500", hash_original_method = "6C812262457371E1512166CE4A83ADE9", hash_generated_method = "A9DA568B6C32E7065B737BD1CABC287E")
    
public void setFeature(String name, boolean value)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }

        if (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES)) {
            if (value) {
                throw new SAXNotSupportedException("Cannot enable " + name);
            } else {
                // Default.
                return;
            }
        }

        if (name.equals(Feature.NAMESPACES)) {
            processNamespaces = value;
            return;
        }

        if (name.equals(Feature.NAMESPACE_PREFIXES)) {
            processNamespacePrefixes = value;
            return;
        }

        if (name.equals(Feature.STRING_INTERNING)) {
            if (value) {
                // Default.
                return;
            } else {
                throw new SAXNotSupportedException("Cannot disable " + name);
            }
        }

        throw new SAXNotRecognizedException(name);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.938 -0500", hash_original_method = "22B8A6F31FF28964E09EDBCB1671EC65", hash_generated_method = "BB7642854414D86C54BD9B612ABE13A9")
    
public Object getProperty(String name)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }

        if (name.equals(LEXICAL_HANDLER_PROPERTY)) {
            return lexicalHandler;
        }

        throw new SAXNotRecognizedException(name);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.940 -0500", hash_original_method = "77A0661FD735F31D3304DC28B022498D", hash_generated_method = "2F14B85BCBD4C184AFD8D71AE577AE76")
    
public void setProperty(String name, Object value)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }

        if (name.equals(LEXICAL_HANDLER_PROPERTY)) {
            // The object must implement LexicalHandler
            if (value instanceof LexicalHandler || value == null) {
                this.lexicalHandler = (LexicalHandler) value;
                return;
            }
            throw new SAXNotSupportedException("value doesn't implement " +
                    "org.xml.sax.ext.LexicalHandler");
        }

        throw new SAXNotRecognizedException(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.943 -0500", hash_original_method = "4AC4E6C4007D28BC651CD7E6B362DD6C", hash_generated_method = "459DD8832E7CEA3271F38680D3FE34EA")
    
public void setEntityResolver(EntityResolver resolver) {
        this.entityResolver = resolver;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.945 -0500", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "21235A3EAE7DB933DABF4A20E9939299")
    
public EntityResolver getEntityResolver() {
        return entityResolver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.947 -0500", hash_original_method = "C5C8FE4AAF9C21A7CE3D34FBCBA58D65", hash_generated_method = "51B6DD96DEC92FC7479443BF0E2466DC")
    
public void setDTDHandler(DTDHandler dtdHandler) {
        this.dtdHandler = dtdHandler;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.949 -0500", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "59B05D24F37BFA393F25F99590382F55")
    
public DTDHandler getDTDHandler() {
        return dtdHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.951 -0500", hash_original_method = "2FAFDB8E70CAAF64BA45E64983BDD69F", hash_generated_method = "FF972C81393A2CCCD97F73AC07A0613C")
    
public void setContentHandler(ContentHandler handler) {
        this.contentHandler = handler;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.954 -0500", hash_original_method = "E04698427463FF6147E1A918B2D0CE2E", hash_generated_method = "EBED72EFADFDECD7CE352F24919248CE")
    
public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.956 -0500", hash_original_method = "7B962796A6AC5EDA23D64E3C68EF714F", hash_generated_method = "E453BAAF35F18B4289B86855B826123C")
    
public void setErrorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.958 -0500", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "DB848F72598F990979C28BB722D11B1F")
    
public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    /**
     * Returns the current lexical handler.
     *
     * @return the current lexical handler, or null if none has been registered
     * @see #setLexicalHandler
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.960 -0500", hash_original_method = "6DC1F08FFDA197EBCFE51BBDA6091085", hash_generated_method = "3FE1BA211FE1B97BC202645699DC16DB")
    
public LexicalHandler getLexicalHandler() {
        return lexicalHandler;
    }

    /**
     * Registers a lexical event handler. Supports neither
     * {@link LexicalHandler#startEntity(String)} nor
     * {@link LexicalHandler#endEntity(String)}.
     *
     * <p>If the application does not register a lexical handler, all
     * lexical events reported by the SAX parser will be silently
     * ignored.</p>
     *
     * <p>Applications may register a new or different handler in the
     * middle of a parse, and the SAX parser must begin using the new
     * handler immediately.</p>
     *
     * @param lexicalHandler listens for lexical events
     * @see #getLexicalHandler()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.963 -0500", hash_original_method = "46969CCBA4951230BBEE4D65C754FA21", hash_generated_method = "96350AE5EFCA7D88EFF10FDA5EC77B19")
    
public void setLexicalHandler(LexicalHandler lexicalHandler) {
        this.lexicalHandler = lexicalHandler;
    }

    /**
     * Returns true if this SAX parser processes namespaces.
     *
     * @see #setNamespaceProcessingEnabled(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.965 -0500", hash_original_method = "8B578359B2B86A936D64E613060A616F", hash_generated_method = "977FF06B6B5A2C0B3C866794A332C138")
    
public boolean isNamespaceProcessingEnabled() {
        return processNamespaces;
    }

    /**
     * Enables or disables namespace processing. Set to true by default. If you
     * enable namespace processing, the parser will invoke
     * {@link ContentHandler#startPrefixMapping(String, String)} and
     * {@link ContentHandler#endPrefixMapping(String)}, and it will filter
     * out namespace declarations from element attributes.
     *
     * @see #isNamespaceProcessingEnabled()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.968 -0500", hash_original_method = "B86489F53C66FA94BF60F43E844ECD38", hash_generated_method = "71D451075959794FCE26E569C695ED9E")
    
public void setNamespaceProcessingEnabled(boolean processNamespaces) {
        this.processNamespaces = processNamespaces;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.971 -0500", hash_original_method = "685D8DAF72E9C67A08F397F1EDD26DDB", hash_generated_method = "03562878558690996037D6B36E02000B")
    
public void parse(InputSource input) throws IOException, SAXException {
        if (processNamespacePrefixes && processNamespaces) {
            /*
             * Expat has XML_SetReturnNSTriplet, but that still doesn't
             * include xmlns attributes like this feature requires. We may
             * have to implement namespace processing ourselves if we want
             * this (not too difficult). We obviously "support" namespace
             * prefixes if namespaces are disabled.
             */
            throw new SAXNotSupportedException("The 'namespace-prefix' " +
                    "feature is not supported while the 'namespaces' " +
                    "feature is enabled.");
        }

        // Try the character stream.
        Reader reader = input.getCharacterStream();
        if (reader != null) {
            try {
                parse(reader, input.getPublicId(), input.getSystemId());
            } finally {
                IoUtils.closeQuietly(reader);
            }
            return;
        }

        // Try the byte stream.
        InputStream in = input.getByteStream();
        String encoding = input.getEncoding();
        if (in != null) {
            try {
                parse(in, encoding, input.getPublicId(), input.getSystemId());
            } finally {
                IoUtils.closeQuietly(in);
            }
            return;
        }

        String systemId = input.getSystemId();
        if (systemId == null) {
            throw new SAXException("No input specified.");
        }

        // Try the system id.
        in = ExpatParser.openUrl(systemId);
        try {
            parse(in, encoding, input.getPublicId(), systemId);
        } finally {
            IoUtils.closeQuietly(in);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.973 -0500", hash_original_method = "B98792032D9978680A85667A6250DD52", hash_generated_method = "DD60885E010FCC54219AB3188B57FFCC")
    
private void parse(Reader in, String publicId, String systemId)
            throws IOException, SAXException {
        ExpatParser parser = new ExpatParser(
                ExpatParser.CHARACTER_ENCODING,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.975 -0500", hash_original_method = "9D71B5A1B65775D1A1A09DC689E8FD0F", hash_generated_method = "8A306DE9A3ADC13651C9F1F971A3C8EC")
    
private void parse(InputStream in, String encoding, String publicId,
            String systemId) throws IOException, SAXException {
        ExpatParser parser = new ExpatParser(
                encoding,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
    }
    
    private static class Feature {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.912 -0500", hash_original_field = "7A51B37BA9FC508AEA058815F1BD52DE", hash_generated_field = "7A1D48E3BBF987F17CCDC77F6B0FAC95")

        private static final String BASE_URI = "http://xml.org/sax/features/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.915 -0500", hash_original_field = "13799AA22AC2D91AD9BB42C25C39C811", hash_generated_field = "30ED0C9BE4E702F74DA8CD69B4046727")

        private static final String VALIDATION = BASE_URI + "validation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.917 -0500", hash_original_field = "BA7515B6DB4A258CF5CBB9FF7C6C5F70", hash_generated_field = "7AABE7A0A06E4F7FE1E3519E1444EEDF")

        private static final String NAMESPACES = BASE_URI + "namespaces";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.920 -0500", hash_original_field = "43036C23F5B783EAC6B0CEDBDBF723F2", hash_generated_field = "AA97C004810B26F45B8D0816A31978BF")

        private static final String NAMESPACE_PREFIXES = BASE_URI + "namespace-prefixes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.923 -0500", hash_original_field = "1F1B839A9657A1124C9AB934D07D7E3C", hash_generated_field = "8C00EF5F799529D8A1E2F4DFCBF22CF4")

        private static final String STRING_INTERNING = BASE_URI + "string-interning";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.926 -0500", hash_original_field = "301E84EA7D833CAC1F7B40950513EA9C", hash_generated_field = "E9CAD9275128B3945C2FFA3643A4936A")

        private static final String EXTERNAL_GENERAL_ENTITIES
                = BASE_URI + "external-general-entities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.928 -0500", hash_original_field = "D3065ABDAA78AED31F104447EA198CF3", hash_generated_field = "AC036A8C71D0772DB976AF5182CABEE3")

        private static final String EXTERNAL_PARAMETER_ENTITIES
                = BASE_URI + "external-parameter-entities";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.123 -0400", hash_original_method = "0B4D9136485558B251EF1E44EE499FB7", hash_generated_method = "0B4D9136485558B251EF1E44EE499FB7")
        public Feature ()
        {
            //Synthesized constructor
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:24.978 -0500", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "10CE462B07C3B7D01E1AC1F092312A2E")
    
public void parse(String systemId) throws IOException, SAXException {
        parse(new InputSource(systemId));
    }
}

