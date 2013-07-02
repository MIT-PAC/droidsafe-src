package org.apache.harmony.xml;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "CCAC8A66D468E2522611BE86933CC0D9", hash_generated_field = "0AC27A3F0A4FBCD5C9DE4F17ACD0E1AC")

    private int pointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "BBA2C2FA8EE593F30DDE09FEE9455626", hash_generated_field = "7AE5C3866E266124176520F985884913")

    private boolean inStartElement = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "A7359E703C9699E1C0D9B2AF618B89A9", hash_generated_field = "7130FCC160E4FC4EA6A7052FB1FDD986")

    private int attributeCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "024A6A458368E658B7DFD5954E138515", hash_generated_field = "6903FA8331974EA5B8786753E4D814EB")

    private int attributePointer = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "198B7C01C675EB6928DC01592CBAA81A", hash_generated_field = "831B23B1055E5A04D60D35B3B396FFC8")

    private final Locator locator = new ExpatLocator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "DF703C2D84F1FAD52D3A9BD1A6B25FFE", hash_generated_field = "703C38EABA8EBF65E6BC35CB8C8EF9C3")

    private ExpatReader xmlReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.662 -0400", hash_original_field = "2F1C9E3A270284EFF337A3A6A35E2214", hash_generated_field = "F3F026228715567E77DB92EA66C8CF66")

    private final ExpatAttributes attributes = new CurrentAttributes();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.663 -0400", hash_original_method = "08191F20EE47B985A8EBB31C0BB98A5A", hash_generated_method = "2E1C9E2A0E90DEE6B2FE54A2DA7B381B")
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
        
        
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.663 -0400", hash_original_method = "289A44034A9CB52BBF40849A78C9DFF1", hash_generated_method = "47EBBABB3D8A8C4F0157E597541AEEB9")
    private  ExpatParser(String encoding, ExpatReader xmlReader, int pointer,
            String publicId, String systemId) {
        this.encoding = encoding;
        this.xmlReader = xmlReader;
        this.pointer = pointer;
        this.systemId = systemId;
        this.publicId = publicId;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.663 -0400", hash_original_method = "650F081790BC185B19FA56BA8A79A45A", hash_generated_method = "C8B5A00DF70BD77FEC5075E2BB199C65")
    private int initialize(String encoding, boolean namespacesEnabled) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482767621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482767621;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.664 -0400", hash_original_method = "6539B8063CABFAD0D8EBA84883A1CF66", hash_generated_method = "D31832CA48F338DAE2720C90B70A111A")
     void startElement(String uri, String localName, String qName,
            int attributePointer, int attributeCount) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        try 
        {
            inStartElement = true;
            this.attributePointer = attributePointer;
            this.attributeCount = attributeCount;
            contentHandler.startElement(
                    uri, localName, qName, this.attributes);
        } 
        finally 
        {
            inStartElement = false;
            this.attributeCount = -1;
            this.attributePointer = 0;
        } 
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        
        
        
            
        
        
            
            
            
            
                    
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.664 -0400", hash_original_method = "50FE3627F5F6FDC1AED1DF8ACC8DE2FD", hash_generated_method = "C3293862001FB47084CC3304D8E6488E")
     void endElement(String uri, String localName, String qName) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endElement(uri, localName, qName);
        } 
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.665 -0400", hash_original_method = "79BE0B0DC27CFEFE439A5FDC5A1CA160", hash_generated_method = "AE50920FA4DB69C1FAC66F5D9ED26E89")
     void text(char[] text, int length) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        {
            contentHandler.characters(text, 0, length);
        } 
        addTaint(text[0]);
        addTaint(length);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.666 -0400", hash_original_method = "6B257C024B729A7D66F9A83E533EB63B", hash_generated_method = "4FFFE1456E3D16A37166A4ABDE39B0AF")
     void comment(char[] text, int length) throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.comment(text, 0, length);
        } 
        addTaint(text[0]);
        addTaint(length);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.667 -0400", hash_original_method = "93DE4882575147F90A7802ED6EFEB9E6", hash_generated_method = "638EB1EDCBF718F15C0EF651BB9CF0FA")
     void startCdata() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.startCDATA();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.667 -0400", hash_original_method = "B0BCA5163C38A135047EC44559B3E39B", hash_generated_method = "22EED7814B99346EE69A210D495612EA")
     void endCdata() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.endCDATA();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.667 -0400", hash_original_method = "C8BFB5467C9B61347AC273E622412632", hash_generated_method = "B3713BFBB414239BA072186A5BFF1364")
     void startNamespace(String prefix, String uri) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        {
            contentHandler.startPrefixMapping(prefix, uri);
        } 
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.668 -0400", hash_original_method = "386BB3F5F69DADA0341AED81D1A7D2AD", hash_generated_method = "9AFF498DB4BFCE6B6452A1B4BE71B11D")
     void endNamespace(String prefix) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endPrefixMapping(prefix);
        } 
        addTaint(prefix.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.668 -0400", hash_original_method = "08337DADA79B09679000AC18FB47E35A", hash_generated_method = "8ED46D0369C18DD244D0E12267296B95")
     void startDtd(String name, String publicId, String systemId) throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.startDTD(name, publicId, systemId);
        } 
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.668 -0400", hash_original_method = "3F3F92A9168E402E1B573BC06B982B7C", hash_generated_method = "A1CA493419277ECBDBA086B4A5621B44")
     void endDtd() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.endDTD();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.669 -0400", hash_original_method = "4656A390E6416859EC1D4943284352B2", hash_generated_method = "97A9A371F115A494F890C93306AC69B6")
     void processingInstruction(String target, String data) throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        {
            contentHandler.processingInstruction(target, data);
        } 
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.669 -0400", hash_original_method = "4F245ABB6EDD8047A0954DBD28029CF8", hash_generated_method = "DD8579C7A5557EF276EE1B7CBF9143D2")
     void notationDecl(String name, String publicId, String systemId) throws SAXException {
        DTDHandler dtdHandler = xmlReader.dtdHandler;
        {
            dtdHandler.notationDecl(name, publicId, systemId);
        } 
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.669 -0400", hash_original_method = "E5C69ABE155B5E114D9566A25B0FC75A", hash_generated_method = "C451393675AE2D0644F6B20F7A3DE8F8")
     void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) throws SAXException {
        DTDHandler dtdHandler = xmlReader.dtdHandler;
        {
            dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        } 
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        addTaint(notationName.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.670 -0400", hash_original_method = "DBF93F6482092FD1B1DD0B14B0D97B21", hash_generated_method = "F3158170CBA14E453857FCF1A439BA8C")
     void handleExternalEntity(String context, String publicId,
            String systemId) throws SAXException, IOException {
        EntityResolver entityResolver = xmlReader.entityResolver;
        {
            try 
            {
                URI systemUri = new URI(systemId);
                {
                    boolean varB98430A78B48AFD3644FD702AB63144B_993839274 = (!systemUri.isAbsolute() && !systemUri.isOpaque());
                    {
                        URI baseUri = new URI(this.systemId);
                        systemUri = baseUri.resolve(systemUri);
                        systemId = systemUri.toString();
                    } 
                } 
            } 
            catch (Exception e)
            {
                System.logI("Could not resolve '" + systemId + "' relative to"
                        + " '" + this.systemId + "' at " + locator, e);
            } 
        } 
        InputSource inputSource = entityResolver.resolveEntity(
                publicId, systemId);
        String encoding = pickEncoding(inputSource);
        int pointer = createEntityParser(this.pointer, context);
        try 
        {
            EntityParser entityParser = new EntityParser(encoding, xmlReader,
                    pointer, inputSource.getPublicId(),
                    inputSource.getSystemId());
            parseExternalEntity(entityParser, inputSource);
        } 
        finally 
        {
            releaseParser(pointer);
        } 
        addTaint(context.getTaint());
        addTaint(publicId.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.671 -0400", hash_original_method = "0D6C1F8897C50F2325542C54551DAF6A", hash_generated_method = "75AFC635404E3B249260D09F5A588F7D")
    private String pickEncoding(InputSource inputSource) {
        String varB4EAC82CA7396A68D541C85D26508E83_159466187 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_344255312 = null; 
        Reader reader = inputSource.getCharacterStream();
        {
            varB4EAC82CA7396A68D541C85D26508E83_159466187 = CHARACTER_ENCODING;
        } 
        String encoding = inputSource.getEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_344255312 = encoding == null ? DEFAULT_ENCODING : encoding;
        addTaint(inputSource.getTaint());
        String varA7E53CE21691AB073D9660D615818899_153020463; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_153020463 = varB4EAC82CA7396A68D541C85D26508E83_159466187;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_153020463 = varB4EAC82CA7396A68D541C85D26508E83_344255312;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_153020463.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_153020463;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.671 -0400", hash_original_method = "43999A16FC6A2BCB60CE78FA610F37AD", hash_generated_method = "B26B210EFC1F80252376E16D67B0588D")
    private void parseExternalEntity(ExpatParser entityParser,
            InputSource inputSource) throws IOException, SAXException {
        Reader reader = inputSource.getCharacterStream();
        {
            try 
            {
                entityParser.append("<externalEntity>");
                entityParser.parseFragment(reader);
                entityParser.append("</externalEntity>");
            } 
            finally 
            {
                IoUtils.closeQuietly(reader);
            } 
        } 
        InputStream in = inputSource.getByteStream();
        {
            try 
            {
                entityParser.append("<externalEntity>"
                        .getBytes(entityParser.encoding));
                entityParser.parseFragment(in);
                entityParser.append("</externalEntity>"
                        .getBytes(entityParser.encoding));
            } 
            finally 
            {
                IoUtils.closeQuietly(in);
            } 
        } 
        String systemId = inputSource.getSystemId();
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("No input specified.", locator);
        } 
        in = openUrl(systemId);
        try 
        {
            entityParser.append("<externalEntity>"
                    .getBytes(entityParser.encoding));
            entityParser.parseFragment(in);
            entityParser.append("</externalEntity>"
                    .getBytes(entityParser.encoding));
        } 
        finally 
        {
            IoUtils.closeQuietly(in);
        } 
        addTaint(entityParser.getTaint());
        addTaint(inputSource.getTaint());
        
        
    }

    
    private static int createEntityParser(int parentPointer, String context) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.672 -0400", hash_original_method = "DD8A0FE95AA726B14C9A7464570F0B95", hash_generated_method = "0C9C0C4346E3BD25BD785891D26C16EA")
     void append(String xml) throws SAXException {
        try 
        {
            appendString(this.pointer, xml, false);
        } 
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } 
        addTaint(xml.getTaint());
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.672 -0400", hash_original_method = "9EF978047B32CC4B7F73DD218F12B5B2", hash_generated_method = "0CB3CD0452C02B8947B440EA2E3A4CB7")
    private void appendString(int pointer, String xml, boolean isFinal) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.673 -0400", hash_original_method = "E534E6CFFABE07F7DCCE5DEDEA13040B", hash_generated_method = "7C4B8B14C1357141E99987D2EC2DEBF1")
     void append(char[] xml, int offset, int length) throws SAXException {
        try 
        {
            appendChars(this.pointer, xml, offset, length);
        } 
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } 
        addTaint(xml[0]);
        addTaint(offset);
        addTaint(length);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.673 -0400", hash_original_method = "49A4641A93DAB70A1876B4EB02B18B5D", hash_generated_method = "B6F7ED5CE0B1C737647F06F2C3F6738B")
    private void appendChars(int pointer, char[] xml, int offset,
            int length) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.673 -0400", hash_original_method = "DB127BCAFE6AA42D44BF28FF8E448923", hash_generated_method = "A99AE25EAF234234D0489DC727242762")
     void append(byte[] xml) throws SAXException {
        append(xml, 0, xml.length);
        addTaint(xml[0]);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.674 -0400", hash_original_method = "6B7A6AA30AC9918948A2664C57D48C07", hash_generated_method = "A1F82B23237EA952E5753278F323CA29")
     void append(byte[] xml, int offset, int length) throws SAXException {
        try 
        {
            appendBytes(this.pointer, xml, offset, length);
        } 
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } 
        addTaint(xml[0]);
        addTaint(offset);
        addTaint(length);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.674 -0400", hash_original_method = "F0951DAA750D508CD972B921A6749C41", hash_generated_method = "5BC4C72BC665C8EA47A950E46B17C0AF")
    private void appendBytes(int pointer, byte[] xml, int offset,
            int length) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.674 -0400", hash_original_method = "4F86C73792633F9CAFFD2414652E6044", hash_generated_method = "998E4D129523E8CE886F300BB3F117F6")
     void parseDocument(InputStream in) throws IOException,
            SAXException {
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
        addTaint(in.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.674 -0400", hash_original_method = "D0C956420A79FC95538314A79FE6EF55", hash_generated_method = "5683271EDAB556F935DED07869FC3AFE")
     void parseDocument(Reader in) throws IOException, SAXException {
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
        addTaint(in.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.675 -0400", hash_original_method = "0C2DA7F13CAAE321089EB28883C484D4", hash_generated_method = "95E1AA965EAA1BE8C4960927DE9150D0")
    private void parseFragment(Reader in) throws IOException, SAXException {
        char[] buffer = new char[BUFFER_SIZE / 2];
        int length;
        {
            boolean var36785B752BCA31C802E8EDD226F672CD_2034977370 = ((length = in.read(buffer)) != -1);
            {
                try 
                {
                    appendChars(this.pointer, buffer, 0, length);
                } 
                catch (ExpatException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), locator);
                } 
            } 
        } 
        addTaint(in.getTaint());
        
        
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.675 -0400", hash_original_method = "3CA57F292A4B96862265187DF8ED7F28", hash_generated_method = "7D3036C8B0AF73B58D8B198B4C0B2F4C")
    private void parseFragment(InputStream in) throws IOException, SAXException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        {
            boolean var36785B752BCA31C802E8EDD226F672CD_1798158742 = ((length = in.read(buffer)) != -1);
            {
                try 
                {
                    appendBytes(this.pointer, buffer, 0, length);
                } 
                catch (ExpatException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
                } 
            } 
        } 
        addTaint(in.getTaint());
        
        
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.676 -0400", hash_original_method = "E29A8B5517BB7A594660A4782169D49D", hash_generated_method = "2AA4A15521DDF70D3202E7277015463E")
    private void startDocument() throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
        {
            contentHandler.setDocumentLocator(this.locator);
            contentHandler.startDocument();
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.676 -0400", hash_original_method = "539A01ACC13B65DFCB758F0CE94D0284", hash_generated_method = "A59994027B0CCEBE6B818E7394535CD0")
    private void endDocument() throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endDocument();
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.677 -0400", hash_original_method = "BFCC6911ABBE3458CCFB4AC68FA2CC36", hash_generated_method = "00038FE98166591B598193CD75409DE0")
     void finish() throws SAXException {
        try 
        {
            appendString(this.pointer, "", true);
        } 
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.678 -0400", hash_original_method = "F20474D747FC599F8D46ABC255AE3ED8", hash_generated_method = "F24D061DFFBC1D3472A38C357930670F")
    @Override
    protected synchronized void finalize() throws Throwable {
        try 
        {
            {
                release(this.pointer);
                this.pointer = 0;
            } 
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.678 -0400", hash_original_method = "B8FAFDCBEF6ED1DBF49858CA951E344D", hash_generated_method = "FD20D872DD983AFC02175B6A41CA789F")
    private void release(int pointer) {
    }

    
    private static void releaseParser(int pointer) {
    }

    
    private static void staticInitialize(String emptyString) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.679 -0400", hash_original_method = "06014D7BF95F9BC6196F9727E94F85D2", hash_generated_method = "BFC29F665A381FAD9DBC9A6985ABB287")
    private int line() {
        int varB027B083F3C5A0885E0646529B3C5E8A_805479220 = (line(this.pointer));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344378394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344378394;
        
        
    }

    
    private static int line(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.680 -0400", hash_original_method = "F3C5081F1B5CC0FD86B00194F6A2466A", hash_generated_method = "9BC2FB4DE08DBED847E0B07DC41826A9")
    private int column() {
        int var6A1EB5916311F41E371AEFB0BB5747DC_425937832 = (column(this.pointer));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995403790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995403790;
        
        
    }

    
    private static int column(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.681 -0400", hash_original_method = "657780C747B6551FC5B90D954C172ACE", hash_generated_method = "25A8E73A64CD38D4393571121F7061DC")
     Attributes cloneAttributes() {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_978114126 = null; 
        Attributes varB4EAC82CA7396A68D541C85D26508E83_109239561 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_978114126 = ClonedAttributes.EMPTY;
        } 
        int clonePointer = cloneAttributes(this.attributePointer, this.attributeCount);
        varB4EAC82CA7396A68D541C85D26508E83_109239561 = new ClonedAttributes(pointer, clonePointer, attributeCount);
        Attributes varA7E53CE21691AB073D9660D615818899_2085053382; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2085053382 = varB4EAC82CA7396A68D541C85D26508E83_978114126;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2085053382 = varB4EAC82CA7396A68D541C85D26508E83_109239561;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2085053382.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2085053382;
        
        
            
        
        
            
        
        
                
        
    }

    
    private static int cloneAttributes(int pointer, int attributeCount) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.682 -0400", hash_original_field = "57C470EAFF78CE82BDB0B0BCF5B1D6B9", hash_generated_field = "F1200750FD64399CAB1B5625087F1715")

        private int parserPointer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.682 -0400", hash_original_field = "CCAC8A66D468E2522611BE86933CC0D9", hash_generated_field = "0AC27A3F0A4FBCD5C9DE4F17ACD0E1AC")

        private int pointer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.682 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private int length;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.682 -0400", hash_original_method = "045E6201A2106A3289C0B2900185AAE3", hash_generated_method = "6C77683241D4DF0E15710C2B79C48263")
        private  ClonedAttributes(int parserPointer, int pointer, int length) {
            this.parserPointer = parserPointer;
            this.pointer = pointer;
            this.length = length;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.682 -0400", hash_original_method = "81345E38E6C55A28DE606E0BCA6E5F93", hash_generated_method = "D77BE0E57A56ED1673FBB8F0A5891CA1")
        @Override
        public int getParserPointer() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665484442 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665484442;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.683 -0400", hash_original_method = "8BF0A90E7356097362ADB7AB9898D2BC", hash_generated_method = "7D3ACED13C64D783938B16C168405F3C")
        @Override
        public int getPointer() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838470203 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838470203;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.683 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "5BAB4AE6DDA50F153CA8BC58F29E2500")
        @Override
        public int getLength() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163762178 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163762178;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.683 -0400", hash_original_method = "BE4737CBAA88C90057E40AE694FFCC80", hash_generated_method = "B353C1C02E5C8698B08474D159335CFB")
        @Override
        protected synchronized void finalize() throws Throwable {
            try 
            {
                {
                    freeAttributes(pointer);
                    pointer = 0;
                } 
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
                    
                    
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.683 -0400", hash_original_field = "700247905712A6607B3DE75A4996CE96", hash_generated_field = "9EEF20496C35220A780FB0DBE8DDDF03")

        private static final Attributes EMPTY = new ClonedAttributes(0, 0, 0);
    }


    
    private class ExpatLocator implements Locator {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.684 -0400", hash_original_method = "64DD51F37170009BB48F8E01805F6CAF", hash_generated_method = "64DD51F37170009BB48F8E01805F6CAF")
        public ExpatLocator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.684 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "5FB5CE03FB6CF862745A771A4E23112C")
        public String getPublicId() {
            String varB4EAC82CA7396A68D541C85D26508E83_506435035 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_506435035 = publicId;
            varB4EAC82CA7396A68D541C85D26508E83_506435035.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_506435035;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.685 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "8FE96B4DBC138D8C92587A8D743D8338")
        public String getSystemId() {
            String varB4EAC82CA7396A68D541C85D26508E83_370193793 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_370193793 = systemId;
            varB4EAC82CA7396A68D541C85D26508E83_370193793.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_370193793;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.685 -0400", hash_original_method = "9A9541F7496758CF9181B7D5DBEDC898", hash_generated_method = "983E43E044BFB86629D976F27B35131C")
        public int getLineNumber() {
            int var78B80DE15B827CB15322EE6FADEF2857_2039634891 = (line());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98832374 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98832374;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.685 -0400", hash_original_method = "4EEF522BB99544999D89F5949A6FB044", hash_generated_method = "3F6237394FEB7F95F6FFCFB4EC6B496F")
        public int getColumnNumber() {
            int varF98B0285246D9CEBDB8B20DABABB1178_1550804789 = (column());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162969262 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162969262;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.686 -0400", hash_original_method = "DD8FF3BEAAEB603642876DC8691E0663", hash_generated_method = "29132C2482568A76D87E7B76859369C3")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1623920125 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1623920125 = "Locator[publicId: " + publicId + ", systemId: " + systemId
                + ", line: " + getLineNumber()
                + ", column: " + getColumnNumber() + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1623920125.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1623920125;
            
            
                
                
        }

        
    }


    
    private class CurrentAttributes extends ExpatAttributes {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.686 -0400", hash_original_method = "ACF7E0CCF646D645B704B296EF29F814", hash_generated_method = "ACF7E0CCF646D645B704B296EF29F814")
        public CurrentAttributes ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.686 -0400", hash_original_method = "A89638ADC5A1EBA87157983FC792900F", hash_generated_method = "A13F6E86AC1792E5E1472935A61BA279")
        @Override
        public int getParserPointer() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391468573 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391468573;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.686 -0400", hash_original_method = "13948788E535A0F103A62D341F619BEF", hash_generated_method = "57F7511B9E579C6B1C82A6C9F358E38D")
        @Override
        public int getPointer() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889855827 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889855827;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.686 -0400", hash_original_method = "27A61DE39F4EE665DACE4F17911F194F", hash_generated_method = "FBD9DB9BA74D6A08A7D3363DC9CFB148")
        @Override
        public int getLength() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969596115 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969596115;
            
            
                
            
            
        }

        
    }


    
    private static class ParseException extends SAXParseException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.687 -0400", hash_original_method = "35DD174A2C7D975B531B73E3C242E751", hash_generated_method = "1D8CB5B12AF2DD855192354C818DB648")
        private  ParseException(String message, Locator locator) {
            super(makeMessage(message, locator), locator);
            addTaint(message.getTaint());
            addTaint(locator.getTaint());
            
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.687 -0400", hash_original_field = "15D3B3BC83D22BFDC9621FBC12908E23", hash_generated_field = "1AF6664FDB28F42A843891FCC46FCB20")

        private int depth = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.687 -0400", hash_original_method = "CA2C59BC199DD9BEE0B3FBB1838981DE", hash_generated_method = "55A0CC41B097A76835356B169F44E784")
        private  EntityParser(String encoding, ExpatReader xmlReader,
                int pointer, String publicId, String systemId) {
            super(encoding, xmlReader, pointer, publicId, systemId);
            addTaint(encoding.getTaint());
            addTaint(xmlReader.getTaint());
            addTaint(pointer);
            addTaint(publicId.getTaint());
            addTaint(systemId.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.688 -0400", hash_original_method = "046BB8109CA52E8AB8C918C4992DC8E2", hash_generated_method = "E8EF164F1D99DDCDBC6CE145A155D399")
        @Override
         void startElement(String uri, String localName, String qName,
                int attributePointer, int attributeCount) throws SAXException {
            {
                super.startElement(uri, localName, qName, attributePointer,
                        attributeCount);
            } 
            addTaint(uri.getTaint());
            addTaint(localName.getTaint());
            addTaint(qName.getTaint());
            addTaint(attributePointer);
            addTaint(attributeCount);
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.688 -0400", hash_original_method = "FFAA25EB14485D022C0B9C6B4C164D1D", hash_generated_method = "60197009BAD07AD7AE607B77D2627CAA")
        @Override
         void endElement(String uri, String localName, String qName) throws SAXException {
            {
                super.endElement(uri, localName, qName);
            } 
            addTaint(uri.getTaint());
            addTaint(localName.getTaint());
            addTaint(qName.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.688 -0400", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "A2D881C6AFC253ADFFDC806313520307")
        @Override
        @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
        protected synchronized void finalize() throws Throwable {
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.688 -0400", hash_original_field = "2032E4039B91BC85B7A501DEE5489FA4", hash_generated_field = "A64DAE236D33721DE2FB44FFC0928678")

    private static final int BUFFER_SIZE = 8096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.689 -0400", hash_original_field = "354F5AD75AD9DAD24F8C6778F0DC8414", hash_generated_field = "A08506C5912D951D1976A5B09A1419D6")

    private static final String OUTSIDE_START_ELEMENT = "Attributes can only be used within the scope of startElement().";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.689 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.689 -0400", hash_original_field = "A609BB9851E2BA55E539883176CA598F", hash_generated_field = "D93D3C416153ED09EDC966B36FEEC626")

    static final String CHARACTER_ENCODING = "UTF-16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.689 -0400", hash_original_field = "F436B5D505D1D653959A1932252FBCD4", hash_generated_field = "8F4372ADE8F9F81D831F4EBF1AAB89E5")

    private static final int TIMEOUT = 20 * 1000;
    static {
        staticInitialize("");
    }
    
}

