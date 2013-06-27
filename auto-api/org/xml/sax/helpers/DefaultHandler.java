package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.163 -0400", hash_original_method = "C916F3EC761E0C154A1A9AFCDD294D40", hash_generated_method = "C916F3EC761E0C154A1A9AFCDD294D40")
    public DefaultHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.168 -0400", hash_original_method = "9EAB8438172711193BA945D78BF156AE", hash_generated_method = "1CCD2530208AC195BDC19B5F057B6926")
    public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
        InputSource varB4EAC82CA7396A68D541C85D26508E83_1758963974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1758963974 = null;
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1758963974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1758963974;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.168 -0400", hash_original_method = "E183481C16DEC5D87834DCD30C3A4B47", hash_generated_method = "AE9D8CCD1A5B098EDC4A2BB9CE2F76FB")
    public void notationDecl(String name, String publicId, String systemId) throws SAXException {
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.168 -0400", hash_original_method = "A4218B7445EF8022439A8D7DC57F2FF7", hash_generated_method = "E159BFAE5B0FB7056CD59BFA9D28EE62")
    public void unparsedEntityDecl(String name, String publicId,
                    String systemId, String notationName) throws SAXException {
        addTaint(name.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        addTaint(notationName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.169 -0400", hash_original_method = "764EC710ED4FDFB68C9E6FE9ED249649", hash_generated_method = "8982242C86C53DDD9F8374B3C93C1CFB")
    public void setDocumentLocator(Locator locator) {
        addTaint(locator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.169 -0400", hash_original_method = "FAA725B72A2ADC391C781CAB49B849AD", hash_generated_method = "F5ABC17320CB17FAFC02F6F62510312E")
    public void startDocument() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.170 -0400", hash_original_method = "08AD4CBC251CA96B103DE58FB6AA2921", hash_generated_method = "3ACBE0E14DE791A4A89F8374A54B4D72")
    public void endDocument() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.173 -0400", hash_original_method = "9A8DBFCDD6673580DBBCEDB8AE69733A", hash_generated_method = "D2DEDFEF366F67889D9FA3A94A552C63")
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.176 -0400", hash_original_method = "0E90E85A66154559EA3C98CC7177C34F", hash_generated_method = "5B3A24B5853AE441BDBBB759C4F775AE")
    public void endPrefixMapping(String prefix) throws SAXException {
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.196 -0400", hash_original_method = "4370BBADFC324ACBBC533D016E5331B9", hash_generated_method = "43E77D287F60C729BF0AADFA039A7EDF")
    public void startElement(String uri, String localName,
                  String qName, Attributes attributes) throws SAXException {
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        addTaint(attributes.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.196 -0400", hash_original_method = "D1BB65E44FB06EB911D3CDAFED8D37CD", hash_generated_method = "461437DE548D8E91A0A88BC9C725079C")
    public void endElement(String uri, String localName, String qName) throws SAXException {
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.196 -0400", hash_original_method = "62C2434D460BC8554CF92975C4745DF3", hash_generated_method = "BFF2AAD1678075D9CF3D8918862F3A6E")
    public void characters(char ch[], int start, int length) throws SAXException {
        addTaint(ch);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.197 -0400", hash_original_method = "9049C36C2683070F72629A8BA1D4C193", hash_generated_method = "AC4E906A96FAEDE3FB1F8423BA319DB8")
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
        addTaint(ch);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.197 -0400", hash_original_method = "D7C64873BD0FC0A0449628F53B089507", hash_generated_method = "F156EAF285B0C46B9FE32434ED0F4856")
    public void processingInstruction(String target, String data) throws SAXException {
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.197 -0400", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "78177C3306D49108B776A6C694C380AB")
    public void skippedEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.197 -0400", hash_original_method = "2057473EBAC4D7FF54AEDE0043F741F4", hash_generated_method = "E3D1BDD789EA8A16065134010FB3E5E9")
    public void warning(SAXParseException e) throws SAXException {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.198 -0400", hash_original_method = "3C476190220BFC4330D41CB0A7E5D96B", hash_generated_method = "A2F3CC24CEE024DB2C3C4D29E0C2AA9C")
    public void error(SAXParseException e) throws SAXException {
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.198 -0400", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "1D84BA36626C8B0851FA28A0702E4559")
    public void fatalError(SAXParseException e) throws SAXException {
        if (DroidSafeAndroidRuntime.control) throw e;
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //throw e;
    }

    
}

