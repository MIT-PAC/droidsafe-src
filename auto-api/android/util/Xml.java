package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import org.apache.harmony.xml.ExpatReader;
import org.kxml2.io.KXmlParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class Xml {
    public static String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "6C88D7BAFDCBAE4F23C5F1A45165C3FD", hash_generated_method = "536A93971A4C41B34FE9D3432F4CD698")
    @DSModeled(DSC.SAFE)
    public Xml() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "743B7F44AE6EDBA9CE3D53907777320F", hash_generated_method = "8F6E83335C00A917FA8553D78AA1F253")
    public static void parse(String xml, ContentHandler contentHandler) throws SAXException {
        try {
            XMLReader reader = new ExpatReader();
            reader.setContentHandler(contentHandler);
            reader.parse(new InputSource(new StringReader(xml)));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "82BCADC868B280559F217E3557A725A7", hash_generated_method = "422FFC525900FA0AAD1FCE2F59538D50")
    public static void parse(Reader in, ContentHandler contentHandler) throws IOException, SAXException {
        XMLReader reader = new ExpatReader();
        reader.setContentHandler(contentHandler);
        reader.parse(new InputSource(in));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "1D6F662958C1BDF1FC8B33D262C45E26", hash_generated_method = "06E099A51E41BDFBEEA6871660A43A37")
    public static void parse(InputStream in, Encoding encoding,
            ContentHandler contentHandler) throws IOException, SAXException {
        XMLReader reader = new ExpatReader();
        reader.setContentHandler(contentHandler);
        InputSource source = new InputSource(in);
        source.setEncoding(encoding.expatName);
        reader.parse(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "F9ED2F3CC1A3E5AAFC55A34E4134AE5C", hash_generated_method = "3042A9D3F410CF5B615273264EA8BCBD")
    public static XmlPullParser newPullParser() {
        try {
            KXmlParser parser = new KXmlParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, true);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            return parser;
        } catch (XmlPullParserException e) {
            throw new AssertionError();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "01B773645C99A4A75AE8FF989ECB51E3", hash_generated_method = "B92B51CE45AEE8F572792599DBFF4411")
    public static XmlSerializer newSerializer() {
        try {
            return XmlSerializerFactory.instance.newSerializer();
        } catch (XmlPullParserException e) {
            throw new AssertionError(e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "EF4D773788368022CD555E81AFE1410D", hash_generated_method = "D970F4A8BF93E81B1B19C74531A1F140")
    public static Encoding findEncodingByName(String encodingName) throws UnsupportedEncodingException {
        if (encodingName == null) {
            return Encoding.UTF_8;
        }
        for (Encoding encoding : Encoding.values()) {
            if (encoding.expatName.equalsIgnoreCase(encodingName))
                return encoding;
        }
        throw new UnsupportedEncodingException(encodingName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.721 -0400", hash_original_method = "5DC1275450A355C1DC130895BF0B045F", hash_generated_method = "E048853307992D93F474B7024676B12D")
    public static AttributeSet asAttributeSet(XmlPullParser parser) {
        return (parser instanceof AttributeSet)
                ? (AttributeSet) parser
                : new XmlPullAttributes(parser);
    }

    
    static class XmlSerializerFactory {
        static final String TYPE
                = "org.kxml2.io.KXmlParser,org.kxml2.io.KXmlSerializer";
        static final XmlPullParserFactory instance;
        
        static {
            try {
                instance = XmlPullParserFactory.newInstance(TYPE, null);
            } catch (XmlPullParserException e) {
                throw new AssertionError(e);
            }
        }
        
    }


    
    public enum Encoding {
        US_ASCII("US-ASCII"),
        UTF_8("UTF-8"),
        UTF_16("UTF-16"),
        ISO_8859_1("ISO-8859-1");
        final String expatName;
        Encoding(String expatName) {
            this.expatName = expatName;
        }
    }

    
}


