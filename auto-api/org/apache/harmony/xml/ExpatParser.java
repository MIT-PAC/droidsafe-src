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
    private int pointer;
    private boolean inStartElement = false;
    private int attributeCount = -1;
    private int attributePointer = 0;
    private Locator locator = new ExpatLocator();
    private ExpatReader xmlReader;
    private String publicId;
    private String systemId;
    private String encoding;
    private ExpatAttributes attributes = new CurrentAttributes();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.081 -0400", hash_original_method = "08191F20EE47B985A8EBB31C0BB98A5A", hash_generated_method = "5271335530F4DED8F896B9613ADADFC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ExpatParser(String encoding, ExpatReader xmlReader,
            boolean processNamespaces, String publicId, String systemId) {
        dsTaint.addTaint(processNamespaces);
        dsTaint.addTaint(xmlReader.dsTaint);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(systemId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.081 -0400", hash_original_method = "289A44034A9CB52BBF40849A78C9DFF1", hash_generated_method = "444D743A019B8CFF27541DCD0823DE88")
    @DSModeled(DSC.SAFE)
    private ExpatParser(String encoding, ExpatReader xmlReader, int pointer,
            String publicId, String systemId) {
        dsTaint.addTaint(xmlReader.dsTaint);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(pointer);
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.encoding = encoding;
        //this.xmlReader = xmlReader;
        //this.pointer = pointer;
        //this.systemId = systemId;
        //this.publicId = publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.081 -0400", hash_original_method = "650F081790BC185B19FA56BA8A79A45A", hash_generated_method = "6F5F7C8F3F10F018DBEAA51C295D2581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int initialize(String encoding, boolean namespacesEnabled) {
        dsTaint.addTaint(namespacesEnabled);
        dsTaint.addTaint(encoding);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.082 -0400", hash_original_method = "6539B8063CABFAD0D8EBA84883A1CF66", hash_generated_method = "ADDE87956607942393B3C7B68335D95E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startElement(String uri, String localName, String qName,
            int attributePointer, int attributeCount) throws SAXException {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(attributeCount);
        dsTaint.addTaint(attributePointer);
        dsTaint.addTaint(qName);
        dsTaint.addTaint(uri);
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        try 
        {
            inStartElement = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.083 -0400", hash_original_method = "50FE3627F5F6FDC1AED1DF8ACC8DE2FD", hash_generated_method = "D9F3C7C6DBE0C7BFD63B3179A131331A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void endElement(String uri, String localName, String qName) throws SAXException {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(qName);
        dsTaint.addTaint(uri);
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endElement(uri, localName, qName);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.endElement(uri, localName, qName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.083 -0400", hash_original_method = "79BE0B0DC27CFEFE439A5FDC5A1CA160", hash_generated_method = "E9058DC29AD4B052A37321217995F20C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void text(char[] text, int length) throws SAXException {
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(length);
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.characters(text, 0, length);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.characters(text, 0, length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.084 -0400", hash_original_method = "6B257C024B729A7D66F9A83E533EB63B", hash_generated_method = "A985D9A783A7ADA5EAD1A6A1CA754239")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void comment(char[] text, int length) throws SAXException {
        dsTaint.addTaint(text[0]);
        dsTaint.addTaint(length);
        LexicalHandler lexicalHandler;
        lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.comment(text, 0, length);
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.comment(text, 0, length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.085 -0400", hash_original_method = "93DE4882575147F90A7802ED6EFEB9E6", hash_generated_method = "35B49ADDCDCCFBAD6E0A5EE5EF03819D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.085 -0400", hash_original_method = "B0BCA5163C38A135047EC44559B3E39B", hash_generated_method = "A1143E195A1D1721761777BF0200E9E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.086 -0400", hash_original_method = "C8BFB5467C9B61347AC273E622412632", hash_generated_method = "55E00ACBB1F8E9D2CEF30F091A1EF0A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startNamespace(String prefix, String uri) throws SAXException {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(uri);
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.startPrefixMapping(prefix, uri);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.startPrefixMapping(prefix, uri);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.086 -0400", hash_original_method = "386BB3F5F69DADA0341AED81D1A7D2AD", hash_generated_method = "D7010CA91DCC6FADD7C8F0E82C78837B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void endNamespace(String prefix) throws SAXException {
        dsTaint.addTaint(prefix);
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.endPrefixMapping(prefix);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.endPrefixMapping(prefix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.086 -0400", hash_original_method = "08337DADA79B09679000AC18FB47E35A", hash_generated_method = "83213963E40FA1641A829326CF661DD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startDtd(String name, String publicId, String systemId) throws SAXException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(systemId);
        LexicalHandler lexicalHandler;
        lexicalHandler = xmlReader.lexicalHandler;
        {
            lexicalHandler.startDTD(name, publicId, systemId);
        } //End block
        // ---------- Original Method ----------
        //LexicalHandler lexicalHandler = xmlReader.lexicalHandler;
        //if (lexicalHandler != null) {
            //lexicalHandler.startDTD(name, publicId, systemId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.087 -0400", hash_original_method = "3F3F92A9168E402E1B573BC06B982B7C", hash_generated_method = "87B63527AB3125891AE6C34BF126424B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.087 -0400", hash_original_method = "4656A390E6416859EC1D4943284352B2", hash_generated_method = "D0BC6ECCA97306D3B118F1B19540A852")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void processingInstruction(String target, String data) throws SAXException {
        dsTaint.addTaint(data);
        dsTaint.addTaint(target);
        ContentHandler contentHandler;
        contentHandler = xmlReader.contentHandler;
        {
            contentHandler.processingInstruction(target, data);
        } //End block
        // ---------- Original Method ----------
        //ContentHandler contentHandler = xmlReader.contentHandler;
        //if (contentHandler != null) {
            //contentHandler.processingInstruction(target, data);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.087 -0400", hash_original_method = "4F245ABB6EDD8047A0954DBD28029CF8", hash_generated_method = "5F20896D48A27A83DD94E96E0BCD7F60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notationDecl(String name, String publicId, String systemId) throws SAXException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(systemId);
        DTDHandler dtdHandler;
        dtdHandler = xmlReader.dtdHandler;
        {
            dtdHandler.notationDecl(name, publicId, systemId);
        } //End block
        // ---------- Original Method ----------
        //DTDHandler dtdHandler = xmlReader.dtdHandler;
        //if (dtdHandler != null) {
            //dtdHandler.notationDecl(name, publicId, systemId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.087 -0400", hash_original_method = "E5C69ABE155B5E114D9566A25B0FC75A", hash_generated_method = "256847DAD3D02CFA668255FB45591ACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) throws SAXException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(systemId);
        dsTaint.addTaint(notationName);
        DTDHandler dtdHandler;
        dtdHandler = xmlReader.dtdHandler;
        {
            dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        } //End block
        // ---------- Original Method ----------
        //DTDHandler dtdHandler = xmlReader.dtdHandler;
        //if (dtdHandler != null) {
            //dtdHandler.unparsedEntityDecl(name, publicId, systemId, notationName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.088 -0400", hash_original_method = "DBF93F6482092FD1B1DD0B14B0D97B21", hash_generated_method = "DDCEA12DF3A5C088775F907264552C21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void handleExternalEntity(String context, String publicId,
            String systemId) throws SAXException, IOException {
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(context);
        dsTaint.addTaint(systemId);
        EntityResolver entityResolver;
        entityResolver = xmlReader.entityResolver;
        {
            try 
            {
                URI systemUri;
                systemUri = new URI(systemId);
                {
                    boolean varB98430A78B48AFD3644FD702AB63144B_592736704 = (!systemUri.isAbsolute() && !systemUri.isOpaque());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.088 -0400", hash_original_method = "0D6C1F8897C50F2325542C54551DAF6A", hash_generated_method = "71BBA658F65956C55A3BEB0D00EA70AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String pickEncoding(InputSource inputSource) {
        dsTaint.addTaint(inputSource.dsTaint);
        Reader reader;
        reader = inputSource.getCharacterStream();
        String encoding;
        encoding = inputSource.getEncoding();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Reader reader = inputSource.getCharacterStream();
        //if (reader != null) {
            //return CHARACTER_ENCODING;
        //}
        //String encoding = inputSource.getEncoding();
        //return encoding == null ? DEFAULT_ENCODING : encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.089 -0400", hash_original_method = "43999A16FC6A2BCB60CE78FA610F37AD", hash_generated_method = "03C8DA50EE2548B0617E18B7B9533ECE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseExternalEntity(ExpatParser entityParser,
            InputSource inputSource) throws IOException, SAXException {
        dsTaint.addTaint(inputSource.dsTaint);
        dsTaint.addTaint(entityParser.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static int createEntityParser(int parentPointer, String context) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.089 -0400", hash_original_method = "DD8A0FE95AA726B14C9A7464570F0B95", hash_generated_method = "9C5F308C0DD15829AE790881751047B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void append(String xml) throws SAXException {
        dsTaint.addTaint(xml);
        try 
        {
            appendString(this.pointer, xml, false);
        } //End block
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendString(this.pointer, xml, false);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.089 -0400", hash_original_method = "9EF978047B32CC4B7F73DD218F12B5B2", hash_generated_method = "DDA05146482B0B7061DBA10B8C9BC727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendString(int pointer, String xml, boolean isFinal) throws SAXException, ExpatException {
        dsTaint.addTaint(pointer);
        dsTaint.addTaint(xml);
        dsTaint.addTaint(isFinal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.090 -0400", hash_original_method = "E534E6CFFABE07F7DCCE5DEDEA13040B", hash_generated_method = "3C0825D20AC5C536231A1991FCF671CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void append(char[] xml, int offset, int length) throws SAXException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(xml[0]);
        dsTaint.addTaint(offset);
        try 
        {
            appendChars(this.pointer, xml, offset, length);
        } //End block
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendChars(this.pointer, xml, offset, length);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.090 -0400", hash_original_method = "49A4641A93DAB70A1876B4EB02B18B5D", hash_generated_method = "BDE2AF47A22D1736F6EB613116366C66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendChars(int pointer, char[] xml, int offset,
            int length) throws SAXException, ExpatException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(pointer);
        dsTaint.addTaint(xml[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.090 -0400", hash_original_method = "DB127BCAFE6AA42D44BF28FF8E448923", hash_generated_method = "B18C46D312AC62C99BEB7D238E1A04FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void append(byte[] xml) throws SAXException {
        dsTaint.addTaint(xml[0]);
        append(xml, 0, xml.length);
        // ---------- Original Method ----------
        //append(xml, 0, xml.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.090 -0400", hash_original_method = "6B7A6AA30AC9918948A2664C57D48C07", hash_generated_method = "762AE8D37DC628BA9D0B025B611D7EC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void append(byte[] xml, int offset, int length) throws SAXException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(xml[0]);
        dsTaint.addTaint(offset);
        try 
        {
            appendBytes(this.pointer, xml, offset, length);
        } //End block
        catch (ExpatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(e.getMessage(), this.locator);
        } //End block
        // ---------- Original Method ----------
        //try {
            //appendBytes(this.pointer, xml, offset, length);
        //} catch (ExpatException e) {
            //throw new ParseException(e.getMessage(), this.locator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.090 -0400", hash_original_method = "F0951DAA750D508CD972B921A6749C41", hash_generated_method = "61D49D4E8A993F8E20FC799ABFCAA786")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendBytes(int pointer, byte[] xml, int offset,
            int length) throws SAXException, ExpatException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(pointer);
        dsTaint.addTaint(xml[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.091 -0400", hash_original_method = "4F86C73792633F9CAFFD2414652E6044", hash_generated_method = "EF5E977ADE34A165AF3F3994B0F324D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void parseDocument(InputStream in) throws IOException,
            SAXException {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.091 -0400", hash_original_method = "D0C956420A79FC95538314A79FE6EF55", hash_generated_method = "DB607A17D9C252B6A8D113ACE744CA4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void parseDocument(Reader in) throws IOException, SAXException {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.091 -0400", hash_original_method = "0C2DA7F13CAAE321089EB28883C484D4", hash_generated_method = "72A637A94F299A626AE5454CB5D74040")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseFragment(Reader in) throws IOException, SAXException {
        dsTaint.addTaint(in.dsTaint);
        char[] buffer;
        buffer = new char[BUFFER_SIZE / 2];
        int length;
        {
            boolean var36785B752BCA31C802E8EDD226F672CD_488221307 = ((length = in.read(buffer)) != -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.091 -0400", hash_original_method = "3CA57F292A4B96862265187DF8ED7F28", hash_generated_method = "8090F87EE587A9580672F3E9F97C408E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseFragment(InputStream in) throws IOException, SAXException {
        dsTaint.addTaint(in.dsTaint);
        byte[] buffer;
        buffer = new byte[BUFFER_SIZE];
        int length;
        {
            boolean var36785B752BCA31C802E8EDD226F672CD_97567741 = ((length = in.read(buffer)) != -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.092 -0400", hash_original_method = "E29A8B5517BB7A594660A4782169D49D", hash_generated_method = "A8827980D9A2D57A902CA2C3FE4A038E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.092 -0400", hash_original_method = "539A01ACC13B65DFCB758F0CE94D0284", hash_generated_method = "A59994027B0CCEBE6B818E7394535CD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.092 -0400", hash_original_method = "BFCC6911ABBE3458CCFB4AC68FA2CC36", hash_generated_method = "00038FE98166591B598193CD75409DE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.092 -0400", hash_original_method = "F20474D747FC599F8D46ABC255AE3ED8", hash_generated_method = "F24D061DFFBC1D3472A38C357930670F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.093 -0400", hash_original_method = "B8FAFDCBEF6ED1DBF49858CA951E344D", hash_generated_method = "F8F0C2200FA4B19EC7B81A3525F8C73D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void release(int pointer) {
        dsTaint.addTaint(pointer);
    }

    
        private static void releaseParser(int pointer) {
    }

    
        private static void staticInitialize(String emptyString) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.093 -0400", hash_original_method = "06014D7BF95F9BC6196F9727E94F85D2", hash_generated_method = "320F603A0521965945464C26DBA3B752")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int line() {
        int varB027B083F3C5A0885E0646529B3C5E8A_841733589 = (line(this.pointer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return line(this.pointer);
    }

    
        private static int line(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.094 -0400", hash_original_method = "F3C5081F1B5CC0FD86B00194F6A2466A", hash_generated_method = "A95C484FA66471A38C0B317C666953E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int column() {
        int var6A1EB5916311F41E371AEFB0BB5747DC_271382527 = (column(this.pointer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return column(this.pointer);
    }

    
        private static int column(int pointer) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.094 -0400", hash_original_method = "657780C747B6551FC5B90D954C172ACE", hash_generated_method = "E29D15B537D411AC4BF6BF290B827613")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Attributes cloneAttributes() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
        } //End block
        int clonePointer;
        clonePointer = cloneAttributes(this.attributePointer, this.attributeCount);
        Attributes var147B95CDE81D9105F08D0A1B783131AF_2129884360 = (new ClonedAttributes(pointer, clonePointer, attributeCount));
        return (Attributes)dsTaint.getTaint();
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
        private int parserPointer;
        private int pointer;
        private int length;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.095 -0400", hash_original_method = "045E6201A2106A3289C0B2900185AAE3", hash_generated_method = "D4480A876C4C190C34B6A1F5063209E4")
        @DSModeled(DSC.SAFE)
        private ClonedAttributes(int parserPointer, int pointer, int length) {
            dsTaint.addTaint(parserPointer);
            dsTaint.addTaint(length);
            dsTaint.addTaint(pointer);
            // ---------- Original Method ----------
            //this.parserPointer = parserPointer;
            //this.pointer = pointer;
            //this.length = length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.095 -0400", hash_original_method = "81345E38E6C55A28DE606E0BCA6E5F93", hash_generated_method = "53A10641BC3DD8AB6602CD9A12DF2830")
        @DSModeled(DSC.SAFE)
        @Override
        public int getParserPointer() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return this.parserPointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.095 -0400", hash_original_method = "8BF0A90E7356097362ADB7AB9898D2BC", hash_generated_method = "E6EA9B86497E8993FD3F3148770FDAD3")
        @DSModeled(DSC.SAFE)
        @Override
        public int getPointer() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.095 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "57C48D23664413D975117654CCF71E39")
        @DSModeled(DSC.SAFE)
        @Override
        public int getLength() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.096 -0400", hash_original_method = "BE4737CBAA88C90057E40AE694FFCC80", hash_generated_method = "B353C1C02E5C8698B08474D159335CFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        private static final Attributes EMPTY = new ClonedAttributes(0, 0, 0);
    }


    
    private class ExpatLocator implements Locator {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.096 -0400", hash_original_method = "D6E8C63C7583950D5FDBEE68610EAD30", hash_generated_method = "D6E8C63C7583950D5FDBEE68610EAD30")
                public ExpatLocator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.096 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "80E14D34056E183CC70BFA8E6AC62A29")
        @DSModeled(DSC.SAFE)
        public String getPublicId() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return publicId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.096 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "A23C365E1375B215042F45D99272D5FD")
        @DSModeled(DSC.SAFE)
        public String getSystemId() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return systemId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.096 -0400", hash_original_method = "9A9541F7496758CF9181B7D5DBEDC898", hash_generated_method = "C7080403D4703B2C0BB637B066EA0572")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getLineNumber() {
            int var78B80DE15B827CB15322EE6FADEF2857_576789431 = (line());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return line();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.096 -0400", hash_original_method = "4EEF522BB99544999D89F5949A6FB044", hash_generated_method = "B7888237D4D8E2901E9DF46963110F50")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getColumnNumber() {
            int varF98B0285246D9CEBDB8B20DABABB1178_730758085 = (column());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return column();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.097 -0400", hash_original_method = "DD8FF3BEAAEB603642876DC8691E0663", hash_generated_method = "376F3898AB92209D57A22F0CB7EC3571")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var7194BB62E60B497ED107D85345D2B9B1_723018649 = ("Locator[publicId: " + publicId + ", systemId: " + systemId
                + ", line: " + getLineNumber()
                + ", column: " + getColumnNumber() + "]");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Locator[publicId: " + publicId + ", systemId: " + systemId
                //+ ", line: " + getLineNumber()
                //+ ", column: " + getColumnNumber() + "]";
        }

        
    }


    
    private class CurrentAttributes extends ExpatAttributes {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.097 -0400", hash_original_method = "C228CB0831259CA033E98DA99A91135D", hash_generated_method = "C228CB0831259CA033E98DA99A91135D")
                public CurrentAttributes ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.097 -0400", hash_original_method = "A89638ADC5A1EBA87157983FC792900F", hash_generated_method = "371DD7CF21E07242B2BCDA2C7831811D")
        @DSModeled(DSC.SAFE)
        @Override
        public int getParserPointer() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.097 -0400", hash_original_method = "13948788E535A0F103A62D341F619BEF", hash_generated_method = "0843B71A46AFF58D0BABE415BBC400EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getPointer() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!inStartElement) {
                //throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            //}
            //return attributePointer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.097 -0400", hash_original_method = "27A61DE39F4EE665DACE4F17911F194F", hash_generated_method = "7D4DDD5CC4E7AA581B525A9B5DAE9B8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int getLength() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!inStartElement) {
                //throw new IllegalStateException(OUTSIDE_START_ELEMENT);
            //}
            //return attributeCount;
        }

        
    }


    
    private static class ParseException extends SAXParseException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.097 -0400", hash_original_method = "35DD174A2C7D975B531B73E3C242E751", hash_generated_method = "320843F145244E85C188651A80C92B32")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private ParseException(String message, Locator locator) {
            super(makeMessage(message, locator), locator);
            dsTaint.addTaint(message);
            dsTaint.addTaint(locator.dsTaint);
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
        private int depth = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.098 -0400", hash_original_method = "CA2C59BC199DD9BEE0B3FBB1838981DE", hash_generated_method = "7D552107BB5F9F9018859CB5FD03D3F4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private EntityParser(String encoding, ExpatReader xmlReader,
                int pointer, String publicId, String systemId) {
            super(encoding, xmlReader, pointer, publicId, systemId);
            dsTaint.addTaint(xmlReader.dsTaint);
            dsTaint.addTaint(publicId);
            dsTaint.addTaint(encoding);
            dsTaint.addTaint(pointer);
            dsTaint.addTaint(systemId);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.098 -0400", hash_original_method = "046BB8109CA52E8AB8C918C4992DC8E2", hash_generated_method = "C54BA9C3D1D3660563039DDBCB28709C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void startElement(String uri, String localName, String qName,
                int attributePointer, int attributeCount) throws SAXException {
            dsTaint.addTaint(localName);
            dsTaint.addTaint(attributeCount);
            dsTaint.addTaint(attributePointer);
            dsTaint.addTaint(qName);
            dsTaint.addTaint(uri);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.098 -0400", hash_original_method = "FFAA25EB14485D022C0B9C6B4C164D1D", hash_generated_method = "645BC5962FBA74D9D2BBB6F5612C0769")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
         void endElement(String uri, String localName, String qName) throws SAXException {
            dsTaint.addTaint(localName);
            dsTaint.addTaint(qName);
            dsTaint.addTaint(uri);
            {
                super.endElement(uri, localName, qName);
            } //End block
            // ---------- Original Method ----------
            //if (--depth > 0) {
                //super.endElement(uri, localName, qName);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.098 -0400", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "A2D881C6AFC253ADFFDC806313520307")
        @DSModeled(DSC.SAFE)
        @Override
        @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
        protected synchronized void finalize() throws Throwable {
            // ---------- Original Method ----------
        }

        
    }


    
    private static final int BUFFER_SIZE = 8096;
    private static final String OUTSIDE_START_ELEMENT
            = "Attributes can only be used within the scope of startElement().";
    private static final String DEFAULT_ENCODING = "UTF-8";
    static final String CHARACTER_ENCODING = "UTF-16";
    private static final int TIMEOUT = 20 * 1000;
    static {
        staticInitialize("");
    }
    
}

