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

class ExpatParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "CCAC8A66D468E2522611BE86933CC0D9", hash_generated_field = "0AC27A3F0A4FBCD5C9DE4F17ACD0E1AC")

    private int pointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "BBA2C2FA8EE593F30DDE09FEE9455626", hash_generated_field = "7AE5C3866E266124176520F985884913")

    private boolean inStartElement = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "A7359E703C9699E1C0D9B2AF618B89A9", hash_generated_field = "7130FCC160E4FC4EA6A7052FB1FDD986")

    private int attributeCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "024A6A458368E658B7DFD5954E138515", hash_generated_field = "6903FA8331974EA5B8786753E4D814EB")

    private int attributePointer = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "198B7C01C675EB6928DC01592CBAA81A", hash_generated_field = "FCAB2BEF156BF821E8161DDF2A368D3A")

    private Locator locator = new ExpatLocator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "DF703C2D84F1FAD52D3A9BD1A6B25FFE", hash_generated_field = "703C38EABA8EBF65E6BC35CB8C8EF9C3")

    private ExpatReader xmlReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.416 -0400", hash_original_field = "2F1C9E3A270284EFF337A3A6A35E2214", hash_generated_field = "F5A544CBFA32ABA389CE7C751D5458AD")

    private ExpatAttributes attributes = new CurrentAttributes();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.421 -0400", hash_original_method = "08191F20EE47B985A8EBB31C0BB98A5A", hash_generated_method = "2E1C9E2A0E90DEE6B2FE54A2DA7B381B")
      ExpatParser(String encoding, ExpatReader xmlReader,
            boolean processNamespaces, String publicId, String systemId) {
        this.publicId = publicId;
        this.systemId = systemId;
        this.xmlReader = xmlReader;
        this.encoding = encoding == null ? DEFAULT_ENCODING : encoding;
        this.pointer = initialize(
            this.encoding,
            processNamespaces
        );
        // ---------- Original Method ----------
        //this.publicId = publicId;
        //this.systemId = systemId;
        //this.xmlReader = xmlReader;
        //this.encoding = encoding == null ? DEFAULT_ENCODING : encoding;
        //this.pointer = initialize(
            //this.encoding,
            //processNamespaces
        //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.432 -0400", hash_original_method = "289A44034A9CB52BBF40849A78C9DFF1", hash_generated_method = "47EBBABB3D8A8C4F0157E597541AEEB9")
    private  ExpatParser(String encoding, ExpatReader xmlReader, int pointer,
            String publicId, String systemId) {
        this.encoding = encoding;
        this.xmlReader = xmlReader;
        this.pointer = pointer;
        this.systemId = systemId;
        this.publicId = publicId;
        // ---------- Original Method ----------
        //this.encoding = encoding;
        //this.xmlReader = xmlReader;
        //this.pointer = pointer;
        //this.systemId = systemId;
        //this.publicId = publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.432 -0400", hash_original_method = "650F081790BC185B19FA56BA8A79A45A", hash_generated_method = "22B46ECBACBECAD9D9FE8268843F7FCE")
    private int initialize(String encoding, boolean namespacesEnabled) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307852934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307852934;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.436 -0400", hash_original_method = "6539B8063CABFAD0D8EBA84883A1CF66", hash_generated_method = "A3B491164F77B1F53FD29CC0439F6162")
     void startElement(String uri, String localName, String qName,
            int attributePointer, int attributeCount) throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        try 
        {
            inStartElement = true;
            this.attributePointer = attributePointer;
            this.attributeCount = attributeCount;
            contentHandler.startElement(
                    uri, localName, qName, this.attributes);
        } //End block
        finally 
        {
            inStartElement = false;
            this.attributeCount = -1;
            this.attributePointer = 0;
        } //End block
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler == null) {
            //return;
        //}
        //try {
            //inStartElement = true;
            //this.attributePointer = attributePointer;
            //this.attributeCount = attributeCount;
            //contentHandler.startElement(
                    //uri, localName, qName, this.attributes);
        //} finally {
            //inStartElement = false;
            //this.attributeCount = -1;
            //this.attributePointer = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.437 -0400", hash_original_method = "50FE3627F5F6FDC1AED1DF8ACC8DE2FD", hash_generated_method = "3FA59645B85E226A161F9372E062C805")
     void endElement(String uri, String localName, String qName) throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endElement(uri, localName, qName);
        } //End block
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.endElement(uri, localName, qName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.437 -0400", hash_original_method = "79BE0B0DC27CFEFE439A5FDC5A1CA160", hash_generated_method = "B5DAE6A36C8A5DE9DB58E54843FBAA80")
     void text(char[] text, int length) throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.characters(text, 0, length);
        } //End block
        addTaint(text[0]);
        addTaint(length);
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.characters(text, 0, length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.437 -0400", hash_original_method = "6B257C024B729A7D66F9A83E533EB63B", hash_generated_method = "147CD746BBB1116B649F028184969328")
     void comment(char[] text, int length) throws SAXException {
        LexicalHandler lexicalHandler;
        lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.comment(text, 0, length);
        } //End block
        addTaint(text[0]);
        addTaint(length);
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.comment(text, 0, length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.438 -0400", hash_original_method = "93DE4882575147F90A7802ED6EFEB9E6", hash_generated_method = "35B49ADDCDCCFBAD6E0A5EE5EF03819D")
     void startCdata() throws SAXException {
        LexicalHandler lexicalHandler;
        lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.startCDATA();
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.startCDATA();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.438 -0400", hash_original_method = "B0BCA5163C38A135047EC44559B3E39B", hash_generated_method = "A1143E195A1D1721761777BF0200E9E0")
     void endCdata() throws SAXException {
        LexicalHandler lexicalHandler;
        lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.endCDATA();
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.endCDATA();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.438 -0400", hash_original_method = "C8BFB5467C9B61347AC273E622412632", hash_generated_method = "1CFC3F47DACC1B306D4472A1D2FAC5CF")
     void startNamespace(String prefix, String uri) throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.startPrefixMapping(prefix, uri);
        } //End block
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.startPrefixMapping(prefix, uri);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.439 -0400", hash_original_method = "386BB3F5F69DADA0341AED81D1A7D2AD", hash_generated_method = "A0A116EA86F0DBE0B8B5496F9DD332ED")
     void endNamespace(String prefix) throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endPrefixMapping(prefix);
        } //End block
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.endPrefixMapping(prefix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.439 -0400", hash_original_method = "08337DADA79B09679000AC18FB47E35A", hash_generated_method = "ACF71B577BD4C3BF3B84004AA9DD48EA")
     void startDtd(String name, String publicId, String systemId) throws SAXException {
        LexicalHandler lexicalHandler;
        lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.startDTD(name, publicId, systemId);
        } //End block
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.startDTD(name, publicId, systemId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.439 -0400", hash_original_method = "3F3F92A9168E402E1B573BC06B982B7C", hash_generated_method = "87B63527AB3125891AE6C34BF126424B")
     void endDtd() throws SAXException {
        LexicalHandler lexicalHandler;
        lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.endDTD();
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.endDTD();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.439 -0400", hash_original_method = "4656A390E6416859EC1D4943284352B2", hash_generated_method = "EE3839F1657AADABDF4A85176BE3C425")
     void processingInstruction(String target, String data) throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.processingInstruction(target, data);
        } //End block
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.processingInstruction(target, data);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.440 -0400", hash_original_method = "4F245ABB6EDD8047A0954DBD28029CF8", hash_generated_method = "08CA45D6DE97709C851E041B2A39A863")
     void notationDecl(String name, String publicId, String systemId) throws SAXException {
        DTDHandler dtdHandler;
        dtdHandler = xmlReader.dtdHandler;
        {
            dtdHandler.notationDecl(name, publicId, systemId);
        } //End block
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
        //DTDHandler dtdHandler = xmlReader.dtdHandler;
        //if (dtdHandler != null) {
            //dtdHandler.notationDecl(name, publicId, systemId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.440 -0400", hash_original_method = "E5C69ABE155B5E114D9566A25B0FC75A", hash_generated_method = "49067CFAFD168283720F707FCB6CAA29")
     void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) throws SAXException {
        DTDHandler dtdHandler;
        dtdHandler = xmlReader.dtdHandler;
        {
            dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        } //End block
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        addTaint(notationName.getTaint());
        // ---------- Original Method ----------
        //DTDHandler dtdHandler = xmlReader.dtdHandler;
        //if (dtdHandler != null) {
            //dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.442 -0400", hash_original_method = "DBF93F6482092FD1B1DD0B14B0D97B21", hash_generated_method = "ACC39ED502AF59C0566597159465A189")
     void handleExternalEntity(String context, String publicId,
            String systemId) throws SAXException, IOException {
        EntityResolver entityResolver;
        entityResolver = xmlReader.entityResolver;
        {
            try 
            {
                URI systemUri;
                systemUri = new URI(systemId);
                {
                    boolean varB98430A78B48AFD3644FD702AB63144B_1640953898 = (!systemUri.isAbsolute() && !systemUri.isOpaque());
                    {
                        URI baseUri;
                        baseUri = new URI(this.systemId);
                        systemUri = baseUri.resolve(systemUri);
                        systemId = systemUri.toString();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (Exception e)
            {
                System.logI("Could not resolve '" + systemId + "' relative to"
                        + " '" + this.systemId + "' at " + locator, e);
            } //End block
        } //End block
        InputSource inputSource;
        inputSource = entityResolver.resolveEntity(
                publicId, systemId);
        String encoding;
        encoding = pickEncoding(inputSource);
        int pointer;
        pointer = createEntityParser(this.pointer, context);
        try 
        {
            EntityParser entityParser;
            entityParser = new EntityParser(encoding, xmlReader,
                    pointer, inputSource.getPublicId(),
                    inputSource.getSystemId());
            parseExternalEntity(entityParser, inputSource);
        } //End block
        finally 
        {
            releaseParser(pointer);
        } //End block
        addTaint(context.getTaint());
        addTaint(publicId.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.442 -0400", hash_original_method = "0D6C1F8897C50F2325542C54551DAF6A", hash_generated_method = "CACBAD5F63EE3CDD8CCA9AEE45A7230E")
    private String pickEncoding(InputSource inputSource) {
        String varB4EAC82CA7396A68D541C85D26508E83_872642630 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1899323936 = null; //Variable for return #2
        Reader reader;
        reader = inputSource.getCharacterStream();
        {
            varB4EAC82CA7396A68D541C85D26508E83_872642630 = CHARACTER_ENCODING;
        } //End block
        String encoding;
        encoding = inputSource.getEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_1899323936 = encoding == null ? DEFAULT_ENCODING : encoding;
        addTaint(inputSource.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1579566539; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1579566539 = varB4EAC82CA7396A68D541C85D26508E83_872642630;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1579566539 = varB4EAC82CA7396A68D541C85D26508E83_1899323936;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1579566539.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1579566539;
        // ---------- Original Method ----------
        //Reader reader = inputSource.getCharacterStream();
        //if (reader != null) {
            //return CHARACTER_ENCODING;
        //}
        //String encoding = inputSource.getEncoding();
        //return encoding == null ? DEFAULT_ENCODING : encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.443 -0400", hash_original_method = "43999A16FC6A2BCB60CE78FA610F37AD", hash_generated_method = "FB6E1EB2CAD073D287F5F66D2BC90B79")
    private void parseExternalEntity(ExpatParser entityParser,
            InputSource inputSource) throws IOException, SAXException {
        Reader reader;
        reader = inputSource.getCharacterStream();
        {
            try 
            {
                entityParser.append("<externalEntity>");
                entityParser.parseFragment(reader);
                entityParser.append("</externalEntity>");
            } //End block
            finally 
            {
                IoUtils.closeQuietly(reader);
            } //End block
        } //End block
        InputStream in;
        in = inputSource.getByteStream();
        {
            try 
            {
                entityParser.append("<externalEntity>"
                        .getBytes(entityParser.encoding));
                entityParser.parseFragment(in);
                entityParser.append("</externalEntity>"
                        .getBytes(entityParser.encoding));
            } //End block
            finally 
            {
                IoUtils.closeQuietly(in);
            } //End block
        } //End block
        String systemId;
        systemId = inputSource.getSystemId();
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("No input specified.", locator);
        } //End block
        in = openUrl(systemId);
        try 
        {
            entityParser.append("<externalEntity>"
                    .getBytes(entityParser.encoding));
            entityParser.parseFragment(in);
            entityParser.append("</externalEntity>"
                    .getBytes(entityParser.encoding));
        } //End block
        finally 
        {
            IoUtils.closeQuietly(in);
        } //End block
        addTaint(entityParser.getTaint());
        addTaint(inputSource.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static int createEntityParser(int parentPointer, String context) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.467 -0400", hash_original_method = "DD8A0FE95AA726B14C9A7464570F0B95", hash_generated_method = "0C9C0C4346E3BD25BD785891D26C16EA")
     void append(String xml) throws SAXException {
        try 
        {
            appendString(this.pointer, xml, false);
        } //End block
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } //End block
        addTaint(xml.getTaint());
        // ---------- Original Method ----------
        //try {
            //appendString(this.pointer, xml, false);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.468 -0400", hash_original_method = "9EF978047B32CC4B7F73DD218F12B5B2", hash_generated_method = "0CB3CD0452C02B8947B440EA2E3A4CB7")
    private void appendString(int pointer, String xml, boolean isFinal) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.468 -0400", hash_original_method = "E534E6CFFABE07F7DCCE5DEDEA13040B", hash_generated_method = "7C4B8B14C1357141E99987D2EC2DEBF1")
     void append(char[] xml, int offset, int length) throws SAXException {
        try 
        {
            appendChars(this.pointer, xml, offset, length);
        } //End block
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } //End block
        addTaint(xml[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //try {
            //appendChars(this.pointer, xml, offset, length);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.468 -0400", hash_original_method = "49A4641A93DAB70A1876B4EB02B18B5D", hash_generated_method = "B6F7ED5CE0B1C737647F06F2C3F6738B")
    private void appendChars(int pointer, char[] xml, int offset,
            int length) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.469 -0400", hash_original_method = "DB127BCAFE6AA42D44BF28FF8E448923", hash_generated_method = "A99AE25EAF234234D0489DC727242762")
     void append(byte[] xml) throws SAXException {
        append(xml, 0, xml.length);
        addTaint(xml[0]);
        // ---------- Original Method ----------
        //append(xml, 0, xml.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.469 -0400", hash_original_method = "6B7A6AA30AC9918948A2664C57D48C07", hash_generated_method = "A1F82B23237EA952E5753278F323CA29")
     void append(byte[] xml, int offset, int length) throws SAXException {
        try 
        {
            appendBytes(this.pointer, xml, offset, length);
        } //End block
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } //End block
        addTaint(xml[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //try {
            //appendBytes(this.pointer, xml, offset, length);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.469 -0400", hash_original_method = "F0951DAA750D508CD972B921A6749C41", hash_generated_method = "5BC4C72BC665C8EA47A950E46B17C0AF")
    private void appendBytes(int pointer, byte[] xml, int offset,
            int length) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.469 -0400", hash_original_method = "4F86C73792633F9CAFFD2414652E6044", hash_generated_method = "998E4D129523E8CE886F300BB3F117F6")
     void parseDocument(InputStream in) throws IOException,
            SAXException {
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //startDocument();
        //parseFragment(in);
        //finish();
        //endDocument();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.470 -0400", hash_original_method = "D0C956420A79FC95538314A79FE6EF55", hash_generated_method = "5683271EDAB556F935DED07869FC3AFE")
     void parseDocument(Reader in) throws IOException, SAXException {
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //startDocument();
        //parseFragment(in);
        //finish();
        //endDocument();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.471 -0400", hash_original_method = "0C2DA7F13CAAE321089EB28883C484D4", hash_generated_method = "9BBD68E2A1D96EE05AC118C1EDED7E2F")
    private void parseFragment(Reader in) throws IOException, SAXException {
        char[] buffer;
        buffer = new char[BUFFER_SIZE / 2];
        int length;
        {
            boolean var36785B752BCA31C802E8EDD226F672CD_590241521 = ((length = in.read(buffer)) != -1);
            {
                try 
                {
                    appendChars(this.pointer, buffer, 0, length);
                } //End block
                catch (ExpatException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), locator);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //char[] buffer = new char[BUFFER_SIZE / 2];
        //int length;
        //while ((length = in.read(buffer)) != -1) {
            //try {
                //appendChars(this.pointer, buffer, 0, length);
            //} catch (ExpatException e) {
                //throw new ParseException(e.getMessage(), locator);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.471 -0400", hash_original_method = "3CA57F292A4B96862265187DF8ED7F28", hash_generated_method = "2F0AC462B4EE0BBC85395CBEC403D1D2")
    private void parseFragment(InputStream in) throws IOException, SAXException {
        byte[] buffer;
        buffer = new byte[BUFFER_SIZE];
        int length;
        {
            boolean var36785B752BCA31C802E8EDD226F672CD_238380744 = ((length = in.read(buffer)) != -1);
            {
                try 
                {
                    appendBytes(this.pointer, buffer, 0, length);
                } //End block
                catch (ExpatException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //byte[] buffer = new byte[BUFFER_SIZE];
        //int length;
        //while ((length = in.read(buffer)) != -1) {
            //try {
                //appendBytes(this.pointer, buffer, 0, length);
            //} catch (ExpatException e) {
                //throw new ParseException(e.getMessage(), this.locator);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.472 -0400", hash_original_method = "E29A8B5517BB7A594660A4782169D49D", hash_generated_method = "A8827980D9A2D57A902CA2C3FE4A038E")
    private void startDocument() throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.setDocumentLocator(this.locator);
            contentHandler.startDocument();
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.setDocumentLocator(this.locator);
            //contentHandler.startDocument();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.473 -0400", hash_original_method = "539A01ACC13B65DFCB758F0CE94D0284", hash_generated_method = "A59994027B0CCEBE6B818E7394535CD0")
    private void endDocument() throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endDocument();
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler;
        //contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.endDocument();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.473 -0400", hash_original_method = "BFCC6911ABBE3458CCFB4AC68FA2CC36", hash_generated_method = "00038FE98166591B598193CD75409DE0")
     void finish() throws SAXException {
        try 
        {
            appendString(this.pointer, "", true);
        } //End block
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendString(this.pointer, "", true);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.479 -0400", hash_original_method = "F20474D747FC599F8D46ABC255AE3ED8", hash_generated_method = "F24D061DFFBC1D3472A38C357930670F")
    @Override
    protected synchronized void finalize() throws Throwable {
        try 
        {
            {
                release(this.pointer);
                this.pointer = 0;
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (this.pointer != 0) {
                //release(this.pointer);
                //this.pointer = 0;
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.487 -0400", hash_original_method = "B8FAFDCBEF6ED1DBF49858CA951E344D", hash_generated_method = "FD20D872DD983AFC02175B6A41CA789F")
    private void release(int pointer) {
    }

    
        private static void releaseParser(int pointer) {
    }

    
        private static void staticInitialize(String emptyString) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.488 -0400", hash_original_method = "06014D7BF95F9BC6196F9727E94F85D2", hash_generated_method = "3D09D514CED44255C7450B59FB3F60C1")
    private int line() {
        int varB027B083F3C5A0885E0646529B3C5E8A_417026313 = (line(this.pointer));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203986120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203986120;
        // ---------- Original Method ----------
        //return line(this.pointer);
    }

    
        private static int line(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.489 -0400", hash_original_method = "F3C5081F1B5CC0FD86B00194F6A2466A", hash_generated_method = "BB75E55FC9593E252DF8E7337CD374A0")
    private int column() {
        int var6A1EB5916311F41E371AEFB0BB5747DC_1361769627 = (column(this.pointer));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18946574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18946574;
        // ---------- Original Method ----------
        //return column(this.pointer);
    }

    
        private static int column(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.489 -0400", hash_original_method = "657780C747B6551FC5B90D954C172ACE", hash_generated_method = "DCBEACBEB0B5916C5FCF8FF622223C17")
     Attributes cloneAttributes() {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_1368700123 = null; //Variable for return #1
        Attributes varB4EAC82CA7396A68D541C85D26508E83_1600322445 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1368700123 = ClonedAttributes.EMPTY;
        } //End block
        int clonePointer;
        clonePointer = cloneAttributes(this.attributePointer, this.attributeCount);
        varB4EAC82CA7396A68D541C85D26508E83_1600322445 = new ClonedAttributes(pointer, clonePointer, attributeCount);
        Attributes varA7E53CE21691AB073D9660D615818899_1598486969; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1598486969 = varB4EAC82CA7396A68D541C85D26508E83_1368700123;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1598486969 = varB4EAC82CA7396A68D541C85D26508E83_1600322445;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1598486969.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1598486969;
        // ---------- Original Method ----------
        //if (!inStartElement) {
            //throw new IllegalStateException(OUTSIDE_START_ELEMENT);
        //}
        //if (attributeCount == 0) {
            //return ClonedAttributes.EMPTY;
        //}
        //int clonePointer
                //= cloneAttributes(this.attributePointer, this.attributeCount);
        //return new ClonedAttributes(pointer, clonePointer, attributeCount);
    }

    
        private static int cloneAttributes(int pointer, int attributeCount) {
        return DSUtils.UNKNOWN_INT;
    }

    
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

    
    private static class ClonedAttributes extends ExpatAttributes {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.504 -0400", hash_original_field = "57C470EAFF78CE82BDB0B0BCF5B1D6B9", hash_generated_field = "F1200750FD64399CAB1B5625087F1715")

        private int parserPointer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.504 -0400", hash_original_field = "CCAC8A66D468E2522611BE86933CC0D9", hash_generated_field = "0AC27A3F0A4FBCD5C9DE4F17ACD0E1AC")

        private int pointer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.504 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private int length;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.504 -0400", hash_original_method = "045E6201A2106A3289C0B2900185AAE3", hash_generated_method = "6C77683241D4DF0E15710C2B79C48263")
        private  ClonedAttributes(int parserPointer, int pointer, int length) {
            this.parserPointer = parserPointer;
            this.pointer = pointer;
            this.length = length;
            // ---------- Original Method ----------
            //this.parserPointer = parserPointer;
            //this.pointer = pointer;
            //this.length = length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.505 -0400", hash_original_method = "81345E38E6C55A28DE606E0BCA6E5F93", hash_generated_method = "B23F6704563FDD7DA8D33E2ECBC8E28C")
        @Override
        public int getParserPointer() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027354767 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027354767;
            // ---------- Original Method ----------
            //return this.parserPointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.505 -0400", hash_original_method = "8BF0A90E7356097362ADB7AB9898D2BC", hash_generated_method = "A8E21864B70F51DBA8169E88CA5271A9")
        @Override
        public int getPointer() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199031159 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199031159;
            // ---------- Original Method ----------
            //return pointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.506 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "CDCE621A9C7E20FA12878404874086A5")
        @Override
        public int getLength() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945375234 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945375234;
            // ---------- Original Method ----------
            //return length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.506 -0400", hash_original_method = "BE4737CBAA88C90057E40AE694FFCC80", hash_generated_method = "B353C1C02E5C8698B08474D159335CFB")
        @Override
        protected synchronized void finalize() throws Throwable {
            try 
            {
                {
                    freeAttributes(pointer);
                    pointer = 0;
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //if (pointer != 0) {
                    //freeAttributes(pointer);
                    //pointer = 0;
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.506 -0400", hash_original_field = "700247905712A6607B3DE75A4996CE96", hash_generated_field = "A8310139767688158454986332DFEAFE")

        private static Attributes EMPTY = new ClonedAttributes(0, 0, 0);
    }


    
    private class ExpatLocator implements Locator {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.506 -0400", hash_original_method = "64DD51F37170009BB48F8E01805F6CAF", hash_generated_method = "64DD51F37170009BB48F8E01805F6CAF")
        public ExpatLocator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.507 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "A95696DE74EFA997F30CC8314ECE6B7E")
        public String getPublicId() {
            String varB4EAC82CA7396A68D541C85D26508E83_316003334 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_316003334 = publicId;
            varB4EAC82CA7396A68D541C85D26508E83_316003334.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_316003334;
            // ---------- Original Method ----------
            //return publicId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.507 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "E51C4F70014063A3AAD4D34112D11BC0")
        public String getSystemId() {
            String varB4EAC82CA7396A68D541C85D26508E83_53026248 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_53026248 = systemId;
            varB4EAC82CA7396A68D541C85D26508E83_53026248.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_53026248;
            // ---------- Original Method ----------
            //return systemId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.507 -0400", hash_original_method = "9A9541F7496758CF9181B7D5DBEDC898", hash_generated_method = "013FBBCC5F72F1BF30902261B27B65A8")
        public int getLineNumber() {
            int var78B80DE15B827CB15322EE6FADEF2857_709123104 = (line());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040113589 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040113589;
            // ---------- Original Method ----------
            //return line();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.508 -0400", hash_original_method = "4EEF522BB99544999D89F5949A6FB044", hash_generated_method = "E7BA2ACC1EE8EC1A2078FAC391FB73A9")
        public int getColumnNumber() {
            int varF98B0285246D9CEBDB8B20DABABB1178_1783778539 = (column());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599412745 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599412745;
            // ---------- Original Method ----------
            //return column();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.517 -0400", hash_original_method = "DD8FF3BEAAEB603642876DC8691E0663", hash_generated_method = "77841F2C191A5B96003F9C7C45E75CF0")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_423476590 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_423476590 = "Locator[publicId: " + publicId + ", systemId: " + systemId
                + ", line: " + getLineNumber()
                + ", column: " + getColumnNumber() + "]";
            varB4EAC82CA7396A68D541C85D26508E83_423476590.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_423476590;
            // ---------- Original Method ----------
            //return "Locator[publicId: " + publicId + ", systemId: " + systemId
                //+ ", line: " + getLineNumber()
                //+ ", column: " + getColumnNumber() + "]";
        }

        
    }


    
    private class CurrentAttributes extends ExpatAttributes {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.518 -0400", hash_original_method = "ACF7E0CCF646D645B704B296EF29F814", hash_generated_method = "ACF7E0CCF646D645B704B296EF29F814")
        public CurrentAttributes ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.518 -0400", hash_original_method = "A89638ADC5A1EBA87157983FC792900F", hash_generated_method = "66A934BE73AFEE9E443C9458D965C9C5")
        @Override
        public int getParserPointer() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696073941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696073941;
            // ---------- Original Method ----------
            //return pointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.519 -0400", hash_original_method = "13948788E535A0F103A62D341F619BEF", hash_generated_method = "284CF84338DFD9142644434D3A687234")
        @Override
        public int getPointer() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323108510 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1323108510;
            // ---------- Original Method ----------
            //if (!inStartElement) {
                //throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            //}
            //return attributePointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.519 -0400", hash_original_method = "27A61DE39F4EE665DACE4F17911F194F", hash_generated_method = "DC84AE46CF1E91231244DB486248BC8D")
        @Override
        public int getLength() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572444269 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572444269;
            // ---------- Original Method ----------
            //if (!inStartElement) {
                //throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            //}
            //return attributeCount;
        }

        
    }


    
    private static class ParseException extends SAXParseException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.519 -0400", hash_original_method = "35DD174A2C7D975B531B73E3C242E751", hash_generated_method = "1D8CB5B12AF2DD855192354C818DB648")
        private  ParseException(String message, Locator locator) {
            super(makeMessage(message, locator), locator);
            addTaint(message.getTaint());
            addTaint(locator.getTaint());
            // ---------- Original Method ----------
        }

        
                private static String makeMessage(String message, Locator locator) {
            return makeMessage(message, locator.getLineNumber(),
                    locator.getColumnNumber());
        }

        
                private static String makeMessage(
                String message, int line, int column) {
            return "At line " + line + ", column "
                    + column + ": " + message;
        }

        
    }


    
    private static class EntityParser extends ExpatParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.526 -0400", hash_original_field = "15D3B3BC83D22BFDC9621FBC12908E23", hash_generated_field = "1AF6664FDB28F42A843891FCC46FCB20")

        private int depth = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.526 -0400", hash_original_method = "CA2C59BC199DD9BEE0B3FBB1838981DE", hash_generated_method = "55A0CC41B097A76835356B169F44E784")
        private  EntityParser(String encoding, ExpatReader xmlReader,
                int pointer, String publicId, String systemId) {
            super(encoding, xmlReader, pointer, publicId, systemId);
            addTaint(encoding.getTaint());
            addTaint(xmlReader.getTaint());
            addTaint(pointer);
            addTaint(publicId.getTaint());
            addTaint(systemId.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.531 -0400", hash_original_method = "046BB8109CA52E8AB8C918C4992DC8E2", hash_generated_method = "E8EF164F1D99DDCDBC6CE145A155D399")
        @Override
         void startElement(String uri, String localName, String qName,
                int attributePointer, int attributeCount) throws SAXException {
            {
                super.startElement(uri, localName, qName, attributePointer,
                        attributeCount);
            } //End block
            addTaint(uri.getTaint());
            addTaint(localName.getTaint());
            addTaint(qName.getTaint());
            addTaint(attributePointer);
            addTaint(attributeCount);
            // ---------- Original Method ----------
            //if (depth++ > 0) {
                //super.startElement(uri, localName, qName, attributePointer,
                        //attributeCount);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.531 -0400", hash_original_method = "FFAA25EB14485D022C0B9C6B4C164D1D", hash_generated_method = "60197009BAD07AD7AE607B77D2627CAA")
        @Override
         void endElement(String uri, String localName, String qName) throws SAXException {
            {
                super.endElement(uri, localName, qName);
            } //End block
            addTaint(uri.getTaint());
            addTaint(localName.getTaint());
            addTaint(qName.getTaint());
            // ---------- Original Method ----------
            //if (--depth > 0) {
                //super.endElement(uri, localName, qName);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.532 -0400", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "A2D881C6AFC253ADFFDC806313520307")
        @Override
        @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
        protected synchronized void finalize() throws Throwable {
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.532 -0400", hash_original_field = "2032E4039B91BC85B7A501DEE5489FA4", hash_generated_field = "6B0CF6C2BD71DFD51A48656BB9D52CE1")

    private static int BUFFER_SIZE = 8096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.532 -0400", hash_original_field = "354F5AD75AD9DAD24F8C6778F0DC8414", hash_generated_field = "1DDDC26A83BBE3A938A778216B38F96F")

    private static String OUTSIDE_START_ELEMENT = "Attributes can only be used within the scope of startElement().";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.532 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "E5701ADC5E89D5E641FA37F5A19EB33A")

    private static String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.533 -0400", hash_original_field = "A609BB9851E2BA55E539883176CA598F", hash_generated_field = "2D2669722888A2D61C0C47A50AAF5E03")

    static String CHARACTER_ENCODING = "UTF-16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.533 -0400", hash_original_field = "F436B5D505D1D653959A1932252FBCD4", hash_generated_field = "C4F81D59C5C5311CCE86C2CA0191E11E")

    private static int TIMEOUT = 20 * 1000;
    static {
        staticInitialize("");
    }
    
}

