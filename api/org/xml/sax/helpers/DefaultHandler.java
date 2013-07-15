package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DefaultHandler implements EntityResolver, DTDHandler, ContentHandler, ErrorHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.345 -0400", hash_original_method = "C916F3EC761E0C154A1A9AFCDD294D40", hash_generated_method = "C916F3EC761E0C154A1A9AFCDD294D40")
    public DefaultHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.345 -0400", hash_original_method = "9EAB8438172711193BA945D78BF156AE", hash_generated_method = "54FC8AC5EC43E2E67DB27DD488D9EABB")
    public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
InputSource var540C13E9E156B687226421B24F2DF178_48945252 =         null;
        var540C13E9E156B687226421B24F2DF178_48945252.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_48945252;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.346 -0400", hash_original_method = "E183481C16DEC5D87834DCD30C3A4B47", hash_generated_method = "DBA5510A270BE9D04EFE186FE796F9FD")
    public void notationDecl(String name, String publicId, String systemId) throws SAXException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.346 -0400", hash_original_method = "A4218B7445EF8022439A8D7DC57F2FF7", hash_generated_method = "11BEB082870EA57D656F4D60FBB99F22")
    public void unparsedEntityDecl(String name, String publicId,
                    String systemId, String notationName) throws SAXException {
        addTaint(notationName.getTaint());
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.347 -0400", hash_original_method = "764EC710ED4FDFB68C9E6FE9ED249649", hash_generated_method = "8982242C86C53DDD9F8374B3C93C1CFB")
    public void setDocumentLocator(Locator locator) {
        addTaint(locator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.347 -0400", hash_original_method = "FAA725B72A2ADC391C781CAB49B849AD", hash_generated_method = "F5ABC17320CB17FAFC02F6F62510312E")
    public void startDocument() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.347 -0400", hash_original_method = "08AD4CBC251CA96B103DE58FB6AA2921", hash_generated_method = "3ACBE0E14DE791A4A89F8374A54B4D72")
    public void endDocument() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.347 -0400", hash_original_method = "9A8DBFCDD6673580DBBCEDB8AE69733A", hash_generated_method = "20857BED78DD6479B3F78F4A256F1BE5")
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.348 -0400", hash_original_method = "0E90E85A66154559EA3C98CC7177C34F", hash_generated_method = "5B3A24B5853AE441BDBBB759C4F775AE")
    public void endPrefixMapping(String prefix) throws SAXException {
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.348 -0400", hash_original_method = "4370BBADFC324ACBBC533D016E5331B9", hash_generated_method = "2191E21FDD4E7FD66F1424B82364BB48")
    public void startElement(String uri, String localName,
                  String qName, Attributes attributes) throws SAXException {
        addTaint(attributes.getTaint());
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.349 -0400", hash_original_method = "D1BB65E44FB06EB911D3CDAFED8D37CD", hash_generated_method = "BFE49779406A7A401F6A5AB3A552B7D7")
    public void endElement(String uri, String localName, String qName) throws SAXException {
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.349 -0400", hash_original_method = "62C2434D460BC8554CF92975C4745DF3", hash_generated_method = "D43A2F493DE034DD2DA66C4C64375D7B")
    public void characters(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.349 -0400", hash_original_method = "9049C36C2683070F72629A8BA1D4C193", hash_generated_method = "E804F1D7B5EF34836B1823F580D6DE63")
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.350 -0400", hash_original_method = "D7C64873BD0FC0A0449628F53B089507", hash_generated_method = "BEB1DCA8CBE8BFAF869A1EA04F4CBAE4")
    public void processingInstruction(String target, String data) throws SAXException {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.350 -0400", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "78177C3306D49108B776A6C694C380AB")
    public void skippedEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.350 -0400", hash_original_method = "2057473EBAC4D7FF54AEDE0043F741F4", hash_generated_method = "E3D1BDD789EA8A16065134010FB3E5E9")
    public void warning(SAXParseException e) throws SAXException {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.350 -0400", hash_original_method = "3C476190220BFC4330D41CB0A7E5D96B", hash_generated_method = "A2F3CC24CEE024DB2C3C4D29E0C2AA9C")
    public void error(SAXParseException e) throws SAXException {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.351 -0400", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "0179C6E37915287522939865529DEE7D")
    public void fatalError(SAXParseException e) throws SAXException {
        addTaint(e.getTaint());
        e.addTaint(taint);
        throw e;
        // ---------- Original Method ----------
        //throw e;
    }

    
}

