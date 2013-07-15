package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.463 -0400", hash_original_method = "6C88D7BAFDCBAE4F23C5F1A45165C3FD", hash_generated_method = "2C6DE3496EE724680E95E9E6CED96C9B")
    public  Xml() {
        // ---------- Original Method ----------
    }

    
        public static void parse(String xml, ContentHandler contentHandler) throws SAXException {
        try {
            XMLReader reader = new ExpatReader();
            reader.setContentHandler(contentHandler);
            reader.parse(new InputSource(new StringReader(xml)));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    
        public static void parse(Reader in, ContentHandler contentHandler) throws IOException, SAXException {
        XMLReader reader = new ExpatReader();
        reader.setContentHandler(contentHandler);
        reader.parse(new InputSource(in));
    }

    
        public static void parse(InputStream in, Encoding encoding,
            ContentHandler contentHandler) throws IOException, SAXException {
        XMLReader reader = new ExpatReader();
        reader.setContentHandler(contentHandler);
        InputSource source = new InputSource(in);
        source.setEncoding(encoding.expatName);
        reader.parse(source);
    }

    
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

    
        @DSModeled(DSC.SPEC)
    public static XmlSerializer newSerializer() {
        try {
            return XmlSerializerFactory.instance.newSerializer();
        } catch (XmlPullParserException e) {
            throw new AssertionError(e);
        }
    }

    
        @DSModeled(DSC.SPEC)
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

    
        public static AttributeSet asAttributeSet(XmlPullParser parser) {
        return (parser instanceof AttributeSet)
                ? (AttributeSet) parser
                : new XmlPullAttributes(parser);
    }

    
    static class XmlSerializerFactory {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.466 -0400", hash_original_method = "C9EFF15750F86CC83530A41F4DEECEE2", hash_generated_method = "C9EFF15750F86CC83530A41F4DEECEE2")
        public XmlSerializerFactory ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.466 -0400", hash_original_field = "02E7496A7669E1B9CCA733100DF17FC1", hash_generated_field = "9CE64B1BB229C601E95DA1B9B95DEB0E")

        static final String TYPE = "org.kxml2.io.KXmlParser,org.kxml2.io.KXmlSerializer";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.466 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "15959610877C4FD5EF3381E3547B65EC")

        static XmlPullParserFactory instance;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.467 -0400", hash_original_field = "34C1F6B518B9248A65D50F5DA60C6C55", hash_generated_field = "21348723A34C602952749C00F7C301A8")

    public static String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
}

