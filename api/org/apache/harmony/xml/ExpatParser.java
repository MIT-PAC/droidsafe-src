package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.933 -0400", hash_original_field = "CCAC8A66D468E2522611BE86933CC0D9", hash_generated_field = "0AC27A3F0A4FBCD5C9DE4F17ACD0E1AC")

    private int pointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.933 -0400", hash_original_field = "BBA2C2FA8EE593F30DDE09FEE9455626", hash_generated_field = "7AE5C3866E266124176520F985884913")

    private boolean inStartElement = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.933 -0400", hash_original_field = "A7359E703C9699E1C0D9B2AF618B89A9", hash_generated_field = "7130FCC160E4FC4EA6A7052FB1FDD986")

    private int attributeCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.933 -0400", hash_original_field = "024A6A458368E658B7DFD5954E138515", hash_generated_field = "6903FA8331974EA5B8786753E4D814EB")

    private int attributePointer = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.934 -0400", hash_original_field = "198B7C01C675EB6928DC01592CBAA81A", hash_generated_field = "831B23B1055E5A04D60D35B3B396FFC8")

    private final Locator locator = new ExpatLocator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.934 -0400", hash_original_field = "DF703C2D84F1FAD52D3A9BD1A6B25FFE", hash_generated_field = "703C38EABA8EBF65E6BC35CB8C8EF9C3")

    private ExpatReader xmlReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.934 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.934 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.934 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.934 -0400", hash_original_field = "2F1C9E3A270284EFF337A3A6A35E2214", hash_generated_field = "F3F026228715567E77DB92EA66C8CF66")

    private final ExpatAttributes attributes = new CurrentAttributes();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.935 -0400", hash_original_method = "08191F20EE47B985A8EBB31C0BB98A5A", hash_generated_method = "2E1C9E2A0E90DEE6B2FE54A2DA7B381B")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.937 -0400", hash_original_method = "289A44034A9CB52BBF40849A78C9DFF1", hash_generated_method = "47EBBABB3D8A8C4F0157E597541AEEB9")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.937 -0400", hash_original_method = "650F081790BC185B19FA56BA8A79A45A", hash_generated_method = "9CE0A0CCED5D97504D911EB3DABE69D7")
    private int initialize(String encoding, boolean namespacesEnabled) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413621417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413621417;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.938 -0400", hash_original_method = "6539B8063CABFAD0D8EBA84883A1CF66", hash_generated_method = "F9A7DE41157CF7435B5B71BC9CAA187C")
     void startElement(String uri, String localName, String qName,
            int attributePointer, int attributeCount) throws SAXException {
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        ContentHandler contentHandler = xmlReader.contentHandler;
    if(contentHandler == null)        
        {
            return;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.939 -0400", hash_original_method = "50FE3627F5F6FDC1AED1DF8ACC8DE2FD", hash_generated_method = "4667BAB695BB2EF947A10801392C56CF")
     void endElement(String uri, String localName, String qName) throws SAXException {
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        ContentHandler contentHandler = xmlReader.contentHandler;
    if(contentHandler != null)        
        {
            contentHandler.endElement(uri, localName, qName);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.endElement(uri, localName, qName);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.939 -0400", hash_original_method = "79BE0B0DC27CFEFE439A5FDC5A1CA160", hash_generated_method = "4217586D1597C49E9806BB927B8E5D5D")
     void text(char[] text, int length) throws SAXException {
        addTaint(length);
        addTaint(text[0]);
        ContentHandler contentHandler = xmlReader.contentHandler;
    if(contentHandler != null)        
        {
            contentHandler.characters(text, 0, length);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.characters(text, 0, length);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.940 -0400", hash_original_method = "6B257C024B729A7D66F9A83E533EB63B", hash_generated_method = "0AFC8EC875DB48ECBB593635F64BB6CF")
     void comment(char[] text, int length) throws SAXException {
        addTaint(length);
        addTaint(text[0]);
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
    if(lexicalHandler != null)        
        {
            lexicalHandler.comment(text, 0, length);
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.comment(text, 0, length);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.940 -0400", hash_original_method = "93DE4882575147F90A7802ED6EFEB9E6", hash_generated_method = "4B5D1A83099B9FBE270A9CBA5D82DE7A")
     void startCdata() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
    if(lexicalHandler != null)        
        {
            lexicalHandler.startCDATA();
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.startCDATA();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.940 -0400", hash_original_method = "B0BCA5163C38A135047EC44559B3E39B", hash_generated_method = "4629A6AC97AF807B4F01257B2389A399")
     void endCdata() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
    if(lexicalHandler != null)        
        {
            lexicalHandler.endCDATA();
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.endCDATA();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.941 -0400", hash_original_method = "C8BFB5467C9B61347AC273E622412632", hash_generated_method = "DFE2AF19C4F126A9CA1D00134815C5FD")
     void startNamespace(String prefix, String uri) throws SAXException {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
        ContentHandler contentHandler = xmlReader.contentHandler;
    if(contentHandler != null)        
        {
            contentHandler.startPrefixMapping(prefix, uri);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.startPrefixMapping(prefix, uri);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.941 -0400", hash_original_method = "386BB3F5F69DADA0341AED81D1A7D2AD", hash_generated_method = "7C125B3A06483803B4D2EF0F4522E5A8")
     void endNamespace(String prefix) throws SAXException {
        addTaint(prefix.getTaint());
        ContentHandler contentHandler = xmlReader.contentHandler;
    if(contentHandler != null)        
        {
            contentHandler.endPrefixMapping(prefix);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.endPrefixMapping(prefix);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.941 -0400", hash_original_method = "08337DADA79B09679000AC18FB47E35A", hash_generated_method = "C2C66C199923B078A73D7C3C14BA4B20")
     void startDtd(String name, String publicId, String systemId) throws SAXException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(name.getTaint());
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
    if(lexicalHandler != null)        
        {
            lexicalHandler.startDTD(name, publicId, systemId);
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.startDTD(name, publicId, systemId);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.941 -0400", hash_original_method = "3F3F92A9168E402E1B573BC06B982B7C", hash_generated_method = "A2442579E3C7652E2B587A02F506DF06")
     void endDtd() throws SAXException {
        LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
    if(lexicalHandler != null)        
        {
            lexicalHandler.endDTD();
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.endDTD();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.942 -0400", hash_original_method = "4656A390E6416859EC1D4943284352B2", hash_generated_method = "5A865DF1ADE640157716A4FDE83478D0")
     void processingInstruction(String target, String data) throws SAXException {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
        ContentHandler contentHandler = xmlReader.contentHandler;
    if(contentHandler != null)        
        {
            contentHandler.processingInstruction(target, data);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.processingInstruction(target, data);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.942 -0400", hash_original_method = "4F245ABB6EDD8047A0954DBD28029CF8", hash_generated_method = "34005D83E0E8211E3283ED02F8C43DB2")
     void notationDecl(String name, String publicId, String systemId) throws SAXException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(name.getTaint());
        DTDHandler dtdHandler = xmlReader.dtdHandler;
    if(dtdHandler != null)        
        {
            dtdHandler.notationDecl(name, publicId, systemId);
        } //End block
        // ---------- Original Method ----------
        //DTDHandler dtdHandler = xmlReader.dtdHandler;
        //if (dtdHandler != null) {
            //dtdHandler.notationDecl(name, publicId, systemId);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.944 -0400", hash_original_method = "E5C69ABE155B5E114D9566A25B0FC75A", hash_generated_method = "D072507761014CCA65A22B4192C4F562")
     void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) throws SAXException {
        addTaint(notationName.getTaint());
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(name.getTaint());
        DTDHandler dtdHandler = xmlReader.dtdHandler;
    if(dtdHandler != null)        
        {
            dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        } //End block
        // ---------- Original Method ----------
        //DTDHandler dtdHandler = xmlReader.dtdHandler;
        //if (dtdHandler != null) {
            //dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.945 -0400", hash_original_method = "DBF93F6482092FD1B1DD0B14B0D97B21", hash_generated_method = "5F91E1FCC54A41C4943902574C2F51F9")
     void handleExternalEntity(String context, String publicId,
            String systemId) throws SAXException, IOException {
        addTaint(publicId.getTaint());
        addTaint(context.getTaint());
        EntityResolver entityResolver = xmlReader.entityResolver;
    if(entityResolver == null)        
        {
            return;
        } //End block
    if(this.systemId != null)        
        {
            try 
            {
                URI systemUri = new URI(systemId);
    if(!systemUri.isAbsolute() && !systemUri.isOpaque())                
                {
                    URI baseUri = new URI(this.systemId);
                    systemUri = baseUri.resolve(systemUri);
                    systemId = systemUri.toString();
                } //End block
            } //End block
            catch (Exception e)
            {
                System.logI("Could not resolve '" + systemId + "' relative to"
                        + " '" + this.systemId + "' at " + locator, e);
            } //End block
        } //End block
        InputSource inputSource = entityResolver.resolveEntity(
                publicId, systemId);
    if(inputSource == null)        
        {
            return;
        } //End block
        String encoding = pickEncoding(inputSource);
        int pointer = createEntityParser(this.pointer, context);
        try 
        {
            EntityParser entityParser = new EntityParser(encoding, xmlReader,
                    pointer, inputSource.getPublicId(),
                    inputSource.getSystemId());
            parseExternalEntity(entityParser, inputSource);
        } //End block
        finally 
        {
            releaseParser(pointer);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.946 -0400", hash_original_method = "0D6C1F8897C50F2325542C54551DAF6A", hash_generated_method = "CFC35ED00F5367EB303C272CBC90EF6A")
    private String pickEncoding(InputSource inputSource) {
        addTaint(inputSource.getTaint());
        Reader reader = inputSource.getCharacterStream();
    if(reader != null)        
        {
String varE5E4C40030DC8296471A4093D98EB493_963449037 =             CHARACTER_ENCODING;
            varE5E4C40030DC8296471A4093D98EB493_963449037.addTaint(taint);
            return varE5E4C40030DC8296471A4093D98EB493_963449037;
        } //End block
        String encoding = inputSource.getEncoding();
String var63AB6DEE6A7CCCFF82CECD1524ECBA7B_2146857706 =         encoding == null ? DEFAULT_ENCODING : encoding;
        var63AB6DEE6A7CCCFF82CECD1524ECBA7B_2146857706.addTaint(taint);
        return var63AB6DEE6A7CCCFF82CECD1524ECBA7B_2146857706;
        // ---------- Original Method ----------
        //Reader reader = inputSource.getCharacterStream();
        //if (reader != null) {
            //return CHARACTER_ENCODING;
        //}
        //String encoding = inputSource.getEncoding();
        //return encoding == null ? DEFAULT_ENCODING : encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.946 -0400", hash_original_method = "43999A16FC6A2BCB60CE78FA610F37AD", hash_generated_method = "E94107F1CED50AB349838AD807167654")
    private void parseExternalEntity(ExpatParser entityParser,
            InputSource inputSource) throws IOException, SAXException {
        addTaint(inputSource.getTaint());
        addTaint(entityParser.getTaint());
        Reader reader = inputSource.getCharacterStream();
    if(reader != null)        
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
            return;
        } //End block
        InputStream in = inputSource.getByteStream();
    if(in != null)        
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
            return;
        } //End block
        String systemId = inputSource.getSystemId();
    if(systemId == null)        
        {
            ParseException varC1AF1074593A63025EF38A6A32C8B37B_1136053295 = new ParseException("No input specified.", locator);
            varC1AF1074593A63025EF38A6A32C8B37B_1136053295.addTaint(taint);
            throw varC1AF1074593A63025EF38A6A32C8B37B_1136053295;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static int createEntityParser(int parentPointer, String context) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.947 -0400", hash_original_method = "DD8A0FE95AA726B14C9A7464570F0B95", hash_generated_method = "F51A8858665C9315D3659B25925EEAAA")
     void append(String xml) throws SAXException {
        addTaint(xml.getTaint());
        try 
        {
            appendString(this.pointer, xml, false);
        } //End block
        catch (ExpatException e)
        {
            ParseException var5874124DE183BF3C29151AAB74946606_677013104 = new ParseException(e.getMessage(), this.locator);
            var5874124DE183BF3C29151AAB74946606_677013104.addTaint(taint);
            throw var5874124DE183BF3C29151AAB74946606_677013104;
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendString(this.pointer, xml, false);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.947 -0400", hash_original_method = "9EF978047B32CC4B7F73DD218F12B5B2", hash_generated_method = "0CB3CD0452C02B8947B440EA2E3A4CB7")
    private void appendString(int pointer, String xml, boolean isFinal) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.947 -0400", hash_original_method = "E534E6CFFABE07F7DCCE5DEDEA13040B", hash_generated_method = "CD43F8D557581E182F694305492B0E08")
     void append(char[] xml, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(xml[0]);
        try 
        {
            appendChars(this.pointer, xml, offset, length);
        } //End block
        catch (ExpatException e)
        {
            ParseException var5874124DE183BF3C29151AAB74946606_1182327950 = new ParseException(e.getMessage(), this.locator);
            var5874124DE183BF3C29151AAB74946606_1182327950.addTaint(taint);
            throw var5874124DE183BF3C29151AAB74946606_1182327950;
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendChars(this.pointer, xml, offset, length);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.948 -0400", hash_original_method = "49A4641A93DAB70A1876B4EB02B18B5D", hash_generated_method = "B6F7ED5CE0B1C737647F06F2C3F6738B")
    private void appendChars(int pointer, char[] xml, int offset,
            int length) throws SAXException, ExpatException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.948 -0400", hash_original_method = "DB127BCAFE6AA42D44BF28FF8E448923", hash_generated_method = "1D7F2770C65BF986375A7EC0FEC92FEF")
     void append(byte[] xml) throws SAXException {
        addTaint(xml[0]);
        append(xml, 0, xml.length);
        // ---------- Original Method ----------
        //append(xml, 0, xml.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.948 -0400", hash_original_method = "6B7A6AA30AC9918948A2664C57D48C07", hash_generated_method = "066042BF3B295E4A5F9A2EEE5C401555")
     void append(byte[] xml, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(xml[0]);
        try 
        {
            appendBytes(this.pointer, xml, offset, length);
        } //End block
        catch (ExpatException e)
        {
            ParseException var5874124DE183BF3C29151AAB74946606_416254978 = new ParseException(e.getMessage(), this.locator);
            var5874124DE183BF3C29151AAB74946606_416254978.addTaint(taint);
            throw var5874124DE183BF3C29151AAB74946606_416254978;
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendBytes(this.pointer, xml, offset, length);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.948 -0400", hash_original_method = "F0951DAA750D508CD972B921A6749C41", hash_generated_method = "5BC4C72BC665C8EA47A950E46B17C0AF")
    private void appendBytes(int pointer, byte[] xml, int offset,
            int length) throws SAXException, ExpatException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.948 -0400", hash_original_method = "4F86C73792633F9CAFFD2414652E6044", hash_generated_method = "7E0EDC88311E5A3EEB43FA2F2690CD61")
     void parseDocument(InputStream in) throws IOException,
            SAXException {
        addTaint(in.getTaint());
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
        // ---------- Original Method ----------
        //startDocument();
        //parseFragment(in);
        //finish();
        //endDocument();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.948 -0400", hash_original_method = "D0C956420A79FC95538314A79FE6EF55", hash_generated_method = "D13CB185C1F100125A215E581DFCC0E8")
     void parseDocument(Reader in) throws IOException, SAXException {
        addTaint(in.getTaint());
        startDocument();
        parseFragment(in);
        finish();
        endDocument();
        // ---------- Original Method ----------
        //startDocument();
        //parseFragment(in);
        //finish();
        //endDocument();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.948 -0400", hash_original_method = "0C2DA7F13CAAE321089EB28883C484D4", hash_generated_method = "9FBD81F2370FE2B4A9DDA83AC66749CE")
    private void parseFragment(Reader in) throws IOException, SAXException {
        addTaint(in.getTaint());
        char[] buffer = new char[BUFFER_SIZE / 2];
        int length;
        while
((length = in.read(buffer)) != -1)        
        {
            try 
            {
                appendChars(this.pointer, buffer, 0, length);
            } //End block
            catch (ExpatException e)
            {
                ParseException var8F95C304B462C82240A1207A1D04123E_106895822 = new ParseException(e.getMessage(), locator);
                var8F95C304B462C82240A1207A1D04123E_106895822.addTaint(taint);
                throw var8F95C304B462C82240A1207A1D04123E_106895822;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.949 -0400", hash_original_method = "3CA57F292A4B96862265187DF8ED7F28", hash_generated_method = "A9F6CFC0EA58E107D5F864F18373361A")
    private void parseFragment(InputStream in) throws IOException, SAXException {
        addTaint(in.getTaint());
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while
((length = in.read(buffer)) != -1)        
        {
            try 
            {
                appendBytes(this.pointer, buffer, 0, length);
            } //End block
            catch (ExpatException e)
            {
                ParseException var5874124DE183BF3C29151AAB74946606_704171939 = new ParseException(e.getMessage(), this.locator);
                var5874124DE183BF3C29151AAB74946606_704171939.addTaint(taint);
                throw var5874124DE183BF3C29151AAB74946606_704171939;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.949 -0400", hash_original_method = "E29A8B5517BB7A594660A4782169D49D", hash_generated_method = "9082BB672490F86100BA9541DBCF9A01")
    private void startDocument() throws SAXException {
        ContentHandler contentHandler = xmlReader.contentHandler;
    if(contentHandler != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.949 -0400", hash_original_method = "539A01ACC13B65DFCB758F0CE94D0284", hash_generated_method = "BEED0EE47E42C45D151E9654AE49D61A")
    private void endDocument() throws SAXException {
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
    if(contentHandler != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.950 -0400", hash_original_method = "BFCC6911ABBE3458CCFB4AC68FA2CC36", hash_generated_method = "22BC4EB718C86BA32AE50573E943F1D4")
     void finish() throws SAXException {
        try 
        {
            appendString(this.pointer, "", true);
        } //End block
        catch (ExpatException e)
        {
            ParseException var5874124DE183BF3C29151AAB74946606_427803643 = new ParseException(e.getMessage(), this.locator);
            var5874124DE183BF3C29151AAB74946606_427803643.addTaint(taint);
            throw var5874124DE183BF3C29151AAB74946606_427803643;
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendString(this.pointer, "", true);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.950 -0400", hash_original_method = "F20474D747FC599F8D46ABC255AE3ED8", hash_generated_method = "7A19B7D11BB132D726F8F71E40493C08")
    @Override
    protected synchronized void finalize() throws Throwable {
        try 
        {
    if(this.pointer != 0)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.950 -0400", hash_original_method = "B8FAFDCBEF6ED1DBF49858CA951E344D", hash_generated_method = "FD20D872DD983AFC02175B6A41CA789F")
    private void release(int pointer) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void releaseParser(int pointer) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void staticInitialize(String emptyString) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.951 -0400", hash_original_method = "06014D7BF95F9BC6196F9727E94F85D2", hash_generated_method = "1DC3D9DE53333BA432985BFC026F5C0D")
    private int line() {
        int var2CF1EB87B15DEA47CFCC310700ADEDDC_298144702 = (line(this.pointer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077819702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077819702;
        // ---------- Original Method ----------
        //return line(this.pointer);
    }

    
    @DSModeled(DSC.SAFE)
    private static int line(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.951 -0400", hash_original_method = "F3C5081F1B5CC0FD86B00194F6A2466A", hash_generated_method = "C3D63C5A2D0E61A2E797751C9152B0AA")
    private int column() {
        int varA078BC8EBE234197D458536C795E9041_823110758 = (column(this.pointer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124776718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124776718;
        // ---------- Original Method ----------
        //return column(this.pointer);
    }

    
    @DSModeled(DSC.SAFE)
    private static int column(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.951 -0400", hash_original_method = "657780C747B6551FC5B90D954C172ACE", hash_generated_method = "86ED5CF418EF5066F0BCACFE365725AA")
     Attributes cloneAttributes() {
    if(!inStartElement)        
        {
            IllegalStateException var3A070C66A81B187C37978C67B8B6D132_827832931 = new IllegalStateException(OUTSIDE_START_ELEMENT);
            var3A070C66A81B187C37978C67B8B6D132_827832931.addTaint(taint);
            throw var3A070C66A81B187C37978C67B8B6D132_827832931;
        } //End block
    if(attributeCount == 0)        
        {
Attributes varF7DAA48B31E0CFA1B3B6BE9B1E4E7C5D_1430994432 =             ClonedAttributes.EMPTY;
            varF7DAA48B31E0CFA1B3B6BE9B1E4E7C5D_1430994432.addTaint(taint);
            return varF7DAA48B31E0CFA1B3B6BE9B1E4E7C5D_1430994432;
        } //End block
        int clonePointer = cloneAttributes(this.attributePointer, this.attributeCount);
Attributes varAB62AE6AE1553E675DECC258C6F54114_571399245 =         new ClonedAttributes(pointer, clonePointer, attributeCount);
        varAB62AE6AE1553E675DECC258C6F54114_571399245.addTaint(taint);
        return varAB62AE6AE1553E675DECC258C6F54114_571399245;
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

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.951 -0400", hash_original_field = "57C470EAFF78CE82BDB0B0BCF5B1D6B9", hash_generated_field = "F1200750FD64399CAB1B5625087F1715")

        private int parserPointer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_field = "CCAC8A66D468E2522611BE86933CC0D9", hash_generated_field = "0AC27A3F0A4FBCD5C9DE4F17ACD0E1AC")

        private int pointer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private int length;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_method = "045E6201A2106A3289C0B2900185AAE3", hash_generated_method = "6C77683241D4DF0E15710C2B79C48263")
        private  ClonedAttributes(int parserPointer, int pointer, int length) {
            this.parserPointer = parserPointer;
            this.pointer = pointer;
            this.length = length;
            // ---------- Original Method ----------
            //this.parserPointer = parserPointer;
            //this.pointer = pointer;
            //this.length = length;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_method = "81345E38E6C55A28DE606E0BCA6E5F93", hash_generated_method = "EC8D7AF00F2E5FF0026A8A010704B5F4")
        @Override
        public int getParserPointer() {
            int var9AA1C37CDAA556499B7A2E2FBA882768_2132522743 = (this.parserPointer);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422252702 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422252702;
            // ---------- Original Method ----------
            //return this.parserPointer;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_method = "8BF0A90E7356097362ADB7AB9898D2BC", hash_generated_method = "9CAB4A1BCB3438414EC6957E0DB0F5E2")
        @Override
        public int getPointer() {
            int varCCAC8A66D468E2522611BE86933CC0D9_1013945056 = (pointer);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117000297 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117000297;
            // ---------- Original Method ----------
            //return pointer;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "3A3B4CF36FFB9288A1F75BD1422E8C42")
        @Override
        public int getLength() {
            int var2FA47F7C65FEC19CC163B195725E3844_844362409 = (length);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814181448 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814181448;
            // ---------- Original Method ----------
            //return length;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_method = "BE4737CBAA88C90057E40AE694FFCC80", hash_generated_method = "A465936CAD538B53FC42BFB7418F91C2")
        @Override
        protected synchronized void finalize() throws Throwable {
            try 
            {
    if(pointer != 0)                
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_field = "700247905712A6607B3DE75A4996CE96", hash_generated_field = "9EEF20496C35220A780FB0DBE8DDDF03")

        private static final Attributes EMPTY = new ClonedAttributes(0, 0, 0);
    }


    
    private class ExpatLocator implements Locator {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.952 -0400", hash_original_method = "64DD51F37170009BB48F8E01805F6CAF", hash_generated_method = "64DD51F37170009BB48F8E01805F6CAF")
        public ExpatLocator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "ADE167FFF706F518E4A2278F31C33683")
        public String getPublicId() {
String var76991CCBEF027A0871CF61642EBA53AB_1532967467 =             publicId;
            var76991CCBEF027A0871CF61642EBA53AB_1532967467.addTaint(taint);
            return var76991CCBEF027A0871CF61642EBA53AB_1532967467;
            // ---------- Original Method ----------
            //return publicId;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "E52E93C5D7C5CB60012CDDE2710FB7C4")
        public String getSystemId() {
String varB7D0727ACC7388EA86587212DD1C6E9F_1621354621 =             systemId;
            varB7D0727ACC7388EA86587212DD1C6E9F_1621354621.addTaint(taint);
            return varB7D0727ACC7388EA86587212DD1C6E9F_1621354621;
            // ---------- Original Method ----------
            //return systemId;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "9A9541F7496758CF9181B7D5DBEDC898", hash_generated_method = "F2BC27709E10991264D06C5688BC96C9")
        public int getLineNumber() {
            int var0AA04E944161FE3CFAF27BB80AE27E09_1054484296 = (line());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832956288 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832956288;
            // ---------- Original Method ----------
            //return line();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "4EEF522BB99544999D89F5949A6FB044", hash_generated_method = "A49079A3876511DB5AE896EE755CD040")
        public int getColumnNumber() {
            int varB8C8ADC9B3962016014C4E201BD65129_1284327812 = (column());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799809435 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799809435;
            // ---------- Original Method ----------
            //return column();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "DD8FF3BEAAEB603642876DC8691E0663", hash_generated_method = "4E955F54685B9F5F67AF5F2C2517A996")
        @Override
        public String toString() {
String varA2481285DD560B3E99E863747DEB930A_1362308630 =             "Locator[publicId: " + publicId + ", systemId: " + systemId
                + ", line: " + getLineNumber()
                + ", column: " + getColumnNumber() + "]";
            varA2481285DD560B3E99E863747DEB930A_1362308630.addTaint(taint);
            return varA2481285DD560B3E99E863747DEB930A_1362308630;
            // ---------- Original Method ----------
            //return "Locator[publicId: " + publicId + ", systemId: " + systemId
                //+ ", line: " + getLineNumber()
                //+ ", column: " + getColumnNumber() + "]";
        }

        
    }


    
    private class CurrentAttributes extends ExpatAttributes {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "ACF7E0CCF646D645B704B296EF29F814", hash_generated_method = "ACF7E0CCF646D645B704B296EF29F814")
        public CurrentAttributes ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "A89638ADC5A1EBA87157983FC792900F", hash_generated_method = "8952EA2A46CEF7D1FEC76C68ACCD1421")
        @Override
        public int getParserPointer() {
            int varCCAC8A66D468E2522611BE86933CC0D9_441343659 = (pointer);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851212485 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851212485;
            // ---------- Original Method ----------
            //return pointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "13948788E535A0F103A62D341F619BEF", hash_generated_method = "846CE24235DCADD261490FE3F44E3176")
        @Override
        public int getPointer() {
    if(!inStartElement)            
            {
                IllegalStateException var3A070C66A81B187C37978C67B8B6D132_1281414535 = new IllegalStateException(OUTSIDE_START_ELEMENT);
                var3A070C66A81B187C37978C67B8B6D132_1281414535.addTaint(taint);
                throw var3A070C66A81B187C37978C67B8B6D132_1281414535;
            } //End block
            int var1264B9C21D560E7989A32741BC858885_1685967995 = (attributePointer);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451924480 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_451924480;
            // ---------- Original Method ----------
            //if (!inStartElement) {
                //throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            //}
            //return attributePointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "27A61DE39F4EE665DACE4F17911F194F", hash_generated_method = "279FDA794F412435D772ED4AA0C409CF")
        @Override
        public int getLength() {
    if(!inStartElement)            
            {
                IllegalStateException var3A070C66A81B187C37978C67B8B6D132_1635009534 = new IllegalStateException(OUTSIDE_START_ELEMENT);
                var3A070C66A81B187C37978C67B8B6D132_1635009534.addTaint(taint);
                throw var3A070C66A81B187C37978C67B8B6D132_1635009534;
            } //End block
            int varBB16AB716A8B7609C0ECC6FB65BADCBC_2066467583 = (attributeCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252251257 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1252251257;
            // ---------- Original Method ----------
            //if (!inStartElement) {
                //throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            //}
            //return attributeCount;
        }

        
    }


    
    private static class ParseException extends SAXParseException {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.953 -0400", hash_original_method = "35DD174A2C7D975B531B73E3C242E751", hash_generated_method = "F57BF8D512BAB9CF24877CE28ADF0506")
        private  ParseException(String message, Locator locator) {
            super(makeMessage(message, locator), locator);
            addTaint(locator.getTaint());
            addTaint(message.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
        private static String makeMessage(String message, Locator locator) {
            return makeMessage(message, locator.getLineNumber(),
                    locator.getColumnNumber());
        }

        
                @DSModeled(DSC.SAFE)
        private static String makeMessage(
                String message, int line, int column) {
            return "At line " + line + ", column "
                    + column + ": " + message;
        }

        
    }


    
    private static class EntityParser extends ExpatParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_field = "15D3B3BC83D22BFDC9621FBC12908E23", hash_generated_field = "1AF6664FDB28F42A843891FCC46FCB20")

        private int depth = 0;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_method = "CA2C59BC199DD9BEE0B3FBB1838981DE", hash_generated_method = "304F75BD6E09BF3F4296D90ADF901ECA")
        private  EntityParser(String encoding, ExpatReader xmlReader,
                int pointer, String publicId, String systemId) {
            super(encoding, xmlReader, pointer, publicId, systemId);
            addTaint(systemId.getTaint());
            addTaint(publicId.getTaint());
            addTaint(pointer);
            addTaint(xmlReader.getTaint());
            addTaint(encoding.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_method = "046BB8109CA52E8AB8C918C4992DC8E2", hash_generated_method = "E136758D657564AD03A662FBF966290C")
        @Override
         void startElement(String uri, String localName, String qName,
                int attributePointer, int attributeCount) throws SAXException {
            addTaint(attributeCount);
            addTaint(attributePointer);
            addTaint(qName.getTaint());
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
    if(depth++ > 0)            
            {
                super.startElement(uri, localName, qName, attributePointer,
                        attributeCount);
            } //End block
            // ---------- Original Method ----------
            //if (depth++ > 0) {
                //super.startElement(uri, localName, qName, attributePointer,
                        //attributeCount);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_method = "FFAA25EB14485D022C0B9C6B4C164D1D", hash_generated_method = "43602D9C25D1972E00E6C63C6D90235E")
        @Override
         void endElement(String uri, String localName, String qName) throws SAXException {
            addTaint(qName.getTaint());
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
    if(--depth > 0)            
            {
                super.endElement(uri, localName, qName);
            } //End block
            // ---------- Original Method ----------
            //if (--depth > 0) {
                //super.endElement(uri, localName, qName);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "A2D881C6AFC253ADFFDC806313520307")
        @Override
        @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
        protected synchronized void finalize() throws Throwable {
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_field = "2032E4039B91BC85B7A501DEE5489FA4", hash_generated_field = "A64DAE236D33721DE2FB44FFC0928678")

    private static final int BUFFER_SIZE = 8096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_field = "354F5AD75AD9DAD24F8C6778F0DC8414", hash_generated_field = "A08506C5912D951D1976A5B09A1419D6")

    private static final String OUTSIDE_START_ELEMENT = "Attributes can only be used within the scope of startElement().";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_field = "2D7FBEFE0E1B69A4322A3C2F72D1B945", hash_generated_field = "801ABCF993C84AFFC2A4DEC33E3ED2DF")

    private static final String DEFAULT_ENCODING = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_field = "A609BB9851E2BA55E539883176CA598F", hash_generated_field = "D93D3C416153ED09EDC966B36FEEC626")

    static final String CHARACTER_ENCODING = "UTF-16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:30.954 -0400", hash_original_field = "F436B5D505D1D653959A1932252FBCD4", hash_generated_field = "8F4372ADE8F9F81D831F4EBF1AAB89E5")

    private static final int TIMEOUT = 20 * 1000;
    static {
        staticInitialize("");
    }
    
}

