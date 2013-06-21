package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    ContentHandler contentHandler;
    DTDHandler dtdHandler;
    EntityResolver entityResolver;
    ErrorHandler errorHandler;
    LexicalHandler lexicalHandler;
    private boolean processNamespaces = true;
    private boolean processNamespacePrefixes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.106 -0400", hash_original_method = "7D626E45A255A749DB925F4DD2B7AEDB", hash_generated_method = "7D626E45A255A749DB925F4DD2B7AEDB")
        public ExpatReader ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.106 -0400", hash_original_method = "783B372D10B457C55DE61BCE252421E8", hash_generated_method = "469D9062B600DCE72698F2DEE2A3B36B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var095945B358BCA21A047D05C123414089_1660853748 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
        } //End collapsed parenthetic
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_339735243 = (name.equals(Feature.NAMESPACES));
        } //End collapsed parenthetic
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_1319580219 = (name.equals(Feature.NAMESPACE_PREFIXES));
        } //End collapsed parenthetic
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_1264048640 = (name.equals(Feature.STRING_INTERNING));
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if (name.equals(Feature.VALIDATION)
                //|| name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                //|| name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES)) {
            //return false;
        //}
        //if (name.equals(Feature.NAMESPACES)) {
            //return processNamespaces;
        //}
        //if (name.equals(Feature.NAMESPACE_PREFIXES)) {
            //return processNamespacePrefixes;
        //}
        //if (name.equals(Feature.STRING_INTERNING)) {
            //return true;
        //}
        //throw new SAXNotRecognizedException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.107 -0400", hash_original_method = "6C812262457371E1512166CE4A83ADE9", hash_generated_method = "1753599602523620267D5AE885B3577D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var095945B358BCA21A047D05C123414089_604163794 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Cannot enable " + name);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_749315701 = (name.equals(Feature.NAMESPACES));
        } //End collapsed parenthetic
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_1001976427 = (name.equals(Feature.NAMESPACE_PREFIXES));
        } //End collapsed parenthetic
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_1715373019 = (name.equals(Feature.STRING_INTERNING));
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Cannot disable " + name);
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.107 -0400", hash_original_method = "22B8A6F31FF28964E09EDBCB1671EC65", hash_generated_method = "54575FFD78820953128CE541C2EE9A9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_484395667 = (name.equals(LEXICAL_HANDLER_PROPERTY));
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if (name.equals(LEXICAL_HANDLER_PROPERTY)) {
            //return lexicalHandler;
        //}
        //throw new SAXNotRecognizedException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.107 -0400", hash_original_method = "77A0661FD735F31D3304DC28B022498D", hash_generated_method = "C80D6DCE925BFC41FEEA2EFD292E7975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_380853333 = (name.equals(LEXICAL_HANDLER_PROPERTY));
            {
                {
                    this.lexicalHandler = (LexicalHandler) value;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("value doesn't implement " +
                    "org.xml.sax.ext.LexicalHandler");
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if (name.equals(LEXICAL_HANDLER_PROPERTY)) {
            //if (value instanceof LexicalHandler || value == null) {
                //this.lexicalHandler = (LexicalHandler) value;
                //return;
            //}
            //throw new SAXNotSupportedException("value doesn't implement " +
                    //"org.xml.sax.ext.LexicalHandler");
        //}
        //throw new SAXNotRecognizedException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.107 -0400", hash_original_method = "4AC4E6C4007D28BC651CD7E6B362DD6C", hash_generated_method = "E1E2F99FE0CD23F12839CE2EC001DD16")
    @DSModeled(DSC.SAFE)
    public void setEntityResolver(EntityResolver resolver) {
        dsTaint.addTaint(resolver.dsTaint);
        // ---------- Original Method ----------
        //this.entityResolver = resolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.108 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "EED88FC8751171627C0911EE0D672322")
    @DSModeled(DSC.SAFE)
    public EntityResolver getEntityResolver() {
        return (EntityResolver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return entityResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.108 -0400", hash_original_method = "C5C8FE4AAF9C21A7CE3D34FBCBA58D65", hash_generated_method = "CC40A5D347D7A56719DDC8A051867522")
    @DSModeled(DSC.SAFE)
    public void setDTDHandler(DTDHandler dtdHandler) {
        dsTaint.addTaint(dtdHandler.dsTaint);
        // ---------- Original Method ----------
        //this.dtdHandler = dtdHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.108 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "E2DE0251F265D1F7190AAF23BEAF59CA")
    @DSModeled(DSC.SAFE)
    public DTDHandler getDTDHandler() {
        return (DTDHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dtdHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.108 -0400", hash_original_method = "2FAFDB8E70CAAF64BA45E64983BDD69F", hash_generated_method = "83090E68BA14EC47AB8E82D598D0C177")
    @DSModeled(DSC.SAFE)
    public void setContentHandler(ContentHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //this.contentHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.108 -0400", hash_original_method = "E04698427463FF6147E1A918B2D0CE2E", hash_generated_method = "BC40DDE935760ECD41B05FE30A7B651F")
    @DSModeled(DSC.SAFE)
    public ContentHandler getContentHandler() {
        return (ContentHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.contentHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.108 -0400", hash_original_method = "7B962796A6AC5EDA23D64E3C68EF714F", hash_generated_method = "CDC045DA9E39FBA6073ACED85C22C841")
    @DSModeled(DSC.SAFE)
    public void setErrorHandler(ErrorHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //this.errorHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.109 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "197402B3225BD2FC282FFFF138F667E4")
    @DSModeled(DSC.SAFE)
    public ErrorHandler getErrorHandler() {
        return (ErrorHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return errorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.109 -0400", hash_original_method = "6DC1F08FFDA197EBCFE51BBDA6091085", hash_generated_method = "9C62750E759EA34FF6C336AA2F49CA2F")
    @DSModeled(DSC.SAFE)
    public LexicalHandler getLexicalHandler() {
        return (LexicalHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lexicalHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.109 -0400", hash_original_method = "46969CCBA4951230BBEE4D65C754FA21", hash_generated_method = "B9601DB431ACA40C78E35B57BC489DED")
    @DSModeled(DSC.SAFE)
    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        dsTaint.addTaint(lexicalHandler.dsTaint);
        // ---------- Original Method ----------
        //this.lexicalHandler = lexicalHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.109 -0400", hash_original_method = "8B578359B2B86A936D64E613060A616F", hash_generated_method = "6930003EF6842226F189A60550E14DD9")
    @DSModeled(DSC.SAFE)
    public boolean isNamespaceProcessingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return processNamespaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.109 -0400", hash_original_method = "B86489F53C66FA94BF60F43E844ECD38", hash_generated_method = "C7703A09C5544591706C23AF25E4B317")
    @DSModeled(DSC.SAFE)
    public void setNamespaceProcessingEnabled(boolean processNamespaces) {
        dsTaint.addTaint(processNamespaces);
        // ---------- Original Method ----------
        //this.processNamespaces = processNamespaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.110 -0400", hash_original_method = "685D8DAF72E9C67A08F397F1EDD26DDB", hash_generated_method = "E676F1396C8318CA8940B53F14805DBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parse(InputSource input) throws IOException, SAXException {
        dsTaint.addTaint(input.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("The 'namespace-prefix' " +
                    "feature is not supported while the 'namespaces' " +
                    "feature is enabled.");
        } //End block
        Reader reader;
        reader = input.getCharacterStream();
        {
            try 
            {
                parse(reader, input.getPublicId(), input.getSystemId());
            } //End block
            finally 
            {
                IoUtils.closeQuietly(reader);
            } //End block
        } //End block
        InputStream in;
        in = input.getByteStream();
        String encoding;
        encoding = input.getEncoding();
        {
            try 
            {
                parse(in, encoding, input.getPublicId(), input.getSystemId());
            } //End block
            finally 
            {
                IoUtils.closeQuietly(in);
            } //End block
        } //End block
        String systemId;
        systemId = input.getSystemId();
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXException("No input specified.");
        } //End block
        in = ExpatParser.openUrl(systemId);
        try 
        {
            parse(in, encoding, input.getPublicId(), systemId);
        } //End block
        finally 
        {
            IoUtils.closeQuietly(in);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.110 -0400", hash_original_method = "B98792032D9978680A85667A6250DD52", hash_generated_method = "C256FF796B3A47A52D423BDBCF632C19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parse(Reader in, String publicId, String systemId) throws IOException, SAXException {
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(systemId);
        dsTaint.addTaint(in.dsTaint);
        ExpatParser parser;
        parser = new ExpatParser(
                ExpatParser.CHARACTER_ENCODING,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
        // ---------- Original Method ----------
        //ExpatParser parser = new ExpatParser(
                //ExpatParser.CHARACTER_ENCODING,
                //this,
                //processNamespaces,
                //publicId,
                //systemId
        //);
        //parser.parseDocument(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.111 -0400", hash_original_method = "9D71B5A1B65775D1A1A09DC689E8FD0F", hash_generated_method = "31A042E197CC0276EB886396A4B103A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parse(InputStream in, String encoding, String publicId,
            String systemId) throws IOException, SAXException {
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(systemId);
        dsTaint.addTaint(in.dsTaint);
        ExpatParser parser;
        parser = new ExpatParser(
                encoding,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
        // ---------- Original Method ----------
        //ExpatParser parser = new ExpatParser(
                //encoding,
                //this,
                //processNamespaces,
                //publicId,
                //systemId
        //);
        //parser.parseDocument(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.111 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "57AF62C35689F0CDC5E6514265C0D904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parse(String systemId) throws IOException, SAXException {
        dsTaint.addTaint(systemId);
        parse(new InputSource(systemId));
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    private static class Feature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.111 -0400", hash_original_method = "1BF3A8D624F899F1D0540E471FC49370", hash_generated_method = "1BF3A8D624F899F1D0540E471FC49370")
                public Feature ()
        {
        }


        private static final String BASE_URI = "http://xml.org/sax/features/";
        private static final String VALIDATION = BASE_URI + "validation";
        private static final String NAMESPACES = BASE_URI + "namespaces";
        private static final String NAMESPACE_PREFIXES = BASE_URI + "namespace-prefixes";
        private static final String STRING_INTERNING = BASE_URI + "string-interning";
        private static final String EXTERNAL_GENERAL_ENTITIES
                = BASE_URI + "external-general-entities";
        private static final String EXTERNAL_PARAMETER_ENTITIES
                = BASE_URI + "external-parameter-entities";
    }


    
    private static final String LEXICAL_HANDLER_PROPERTY
            = "http://xml.org/sax/properties/lexical-handler";
}

