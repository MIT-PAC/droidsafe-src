package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String LEXICAL_HANDLER_PROPERTY
            = "http://xml.org/sax/properties/lexical-handler";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.943 -0400", hash_original_method = "783B372D10B457C55DE61BCE252421E8", hash_generated_method = "02E4F8639E022261C2CF5DE740B8A79D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        {
            throw new NullPointerException("name == null");
        } //End block
        {
            boolean var095945B358BCA21A047D05C123414089_1039974698 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
        } //End collapsed parenthetic
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_210767951 = (name.equals(Feature.NAMESPACES));
        } //End collapsed parenthetic
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_1122858072 = (name.equals(Feature.NAMESPACE_PREFIXES));
        } //End collapsed parenthetic
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_510596547 = (name.equals(Feature.STRING_INTERNING));
        } //End collapsed parenthetic
        throw new SAXNotRecognizedException(name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "6C812262457371E1512166CE4A83ADE9", hash_generated_method = "74D07BE336CCD8029B1947C19F84B0AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            throw new NullPointerException("name == null");
        } //End block
        {
            boolean var095945B358BCA21A047D05C123414089_1739722393 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
            {
                {
                    throw new SAXNotSupportedException("Cannot enable " + name);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_846178467 = (name.equals(Feature.NAMESPACES));
        } //End collapsed parenthetic
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_2057125871 = (name.equals(Feature.NAMESPACE_PREFIXES));
        } //End collapsed parenthetic
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_1420801524 = (name.equals(Feature.STRING_INTERNING));
            {
                {
                    throw new SAXNotSupportedException("Cannot disable " + name);
                } //End block
            } //End block
        } //End collapsed parenthetic
        throw new SAXNotRecognizedException(name);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "22B8A6F31FF28964E09EDBCB1671EC65", hash_generated_method = "5EC51115939511FF72B3146EC2CCF4AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        {
            throw new NullPointerException("name == null");
        } //End block
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_1132698145 = (name.equals(LEXICAL_HANDLER_PROPERTY));
        } //End collapsed parenthetic
        throw new SAXNotRecognizedException(name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "77A0661FD735F31D3304DC28B022498D", hash_generated_method = "A539FBCC3010FDCD2F6D53B60B189F00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        {
            throw new NullPointerException("name == null");
        } //End block
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_1966271043 = (name.equals(LEXICAL_HANDLER_PROPERTY));
            {
                {
                    this.lexicalHandler = (LexicalHandler) value;
                } //End block
                throw new SAXNotSupportedException("value doesn't implement " +
                    "org.xml.sax.ext.LexicalHandler");
            } //End block
        } //End collapsed parenthetic
        throw new SAXNotRecognizedException(name);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "4AC4E6C4007D28BC651CD7E6B362DD6C", hash_generated_method = "D790A284DF3814FA2184007D0625E835")
    @DSModeled(DSC.SAFE)
    public void setEntityResolver(EntityResolver resolver) {
        dsTaint.addTaint(resolver.dsTaint);
        // ---------- Original Method ----------
        //this.entityResolver = resolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "CF4D864E5A832951F3E283EE8FBE40C4")
    @DSModeled(DSC.SAFE)
    public EntityResolver getEntityResolver() {
        return (EntityResolver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return entityResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "C5C8FE4AAF9C21A7CE3D34FBCBA58D65", hash_generated_method = "3CBF1314D58E2B34AF706BC299FEA7CC")
    @DSModeled(DSC.SAFE)
    public void setDTDHandler(DTDHandler dtdHandler) {
        dsTaint.addTaint(dtdHandler.dsTaint);
        // ---------- Original Method ----------
        //this.dtdHandler = dtdHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "67BAA8648D15E614270A348C252FB892")
    @DSModeled(DSC.SAFE)
    public DTDHandler getDTDHandler() {
        return (DTDHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dtdHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "2FAFDB8E70CAAF64BA45E64983BDD69F", hash_generated_method = "D1CFC21D14D30972AA882F67466187C3")
    @DSModeled(DSC.SAFE)
    public void setContentHandler(ContentHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //this.contentHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "E04698427463FF6147E1A918B2D0CE2E", hash_generated_method = "08EE3D69BF93334427A342CCCE55F219")
    @DSModeled(DSC.SAFE)
    public ContentHandler getContentHandler() {
        return (ContentHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.contentHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "7B962796A6AC5EDA23D64E3C68EF714F", hash_generated_method = "15475C350DE13A393B70D450055DF7CF")
    @DSModeled(DSC.SAFE)
    public void setErrorHandler(ErrorHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //this.errorHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "2B883339575145D408E9EA225CC02B06")
    @DSModeled(DSC.SAFE)
    public ErrorHandler getErrorHandler() {
        return (ErrorHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return errorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "6DC1F08FFDA197EBCFE51BBDA6091085", hash_generated_method = "D76179BEDA511B367EF3C843E5664320")
    @DSModeled(DSC.SAFE)
    public LexicalHandler getLexicalHandler() {
        return (LexicalHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lexicalHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "46969CCBA4951230BBEE4D65C754FA21", hash_generated_method = "B0125D0B361867C3F22312CDC0E9840A")
    @DSModeled(DSC.SAFE)
    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        dsTaint.addTaint(lexicalHandler.dsTaint);
        // ---------- Original Method ----------
        //this.lexicalHandler = lexicalHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "8B578359B2B86A936D64E613060A616F", hash_generated_method = "2A3CB31A6D89776D1A1A6B028031DAA9")
    @DSModeled(DSC.SAFE)
    public boolean isNamespaceProcessingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return processNamespaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "B86489F53C66FA94BF60F43E844ECD38", hash_generated_method = "D2B9CBBE5C51372CDC4BC2D75B9B8613")
    @DSModeled(DSC.SAFE)
    public void setNamespaceProcessingEnabled(boolean processNamespaces) {
        dsTaint.addTaint(processNamespaces);
        // ---------- Original Method ----------
        //this.processNamespaces = processNamespaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.944 -0400", hash_original_method = "685D8DAF72E9C67A08F397F1EDD26DDB", hash_generated_method = "30C830ECA6C246147BE25684890197A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parse(InputSource input) throws IOException, SAXException {
        dsTaint.addTaint(input.dsTaint);
        {
            throw new SAXNotSupportedException("The 'namespace-prefix' " +
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
            throw new SAXException("No input specified.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.945 -0400", hash_original_method = "B98792032D9978680A85667A6250DD52", hash_generated_method = "F96F250D9A3674FF0E708571A66E44CB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.945 -0400", hash_original_method = "9D71B5A1B65775D1A1A09DC689E8FD0F", hash_generated_method = "AA39D2D81CDDC11EE3BD9F8D3F02C9AF")
    @DSModeled(DSC.SAFE)
    private void parse(InputStream in, String encoding, String publicId,
            String systemId) throws IOException, SAXException {
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(publicId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.945 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "73AEAC2B69C9A759F6EE1011A1723D11")
    @DSModeled(DSC.SAFE)
    public void parse(String systemId) throws IOException, SAXException {
        dsTaint.addTaint(systemId);
        parse(new InputSource(systemId));
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    private static class Feature {
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


    
}


