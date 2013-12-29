package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Parses the given xml string and fires events on the given SAX handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.953 -0500", hash_original_method = "743B7F44AE6EDBA9CE3D53907777320F", hash_generated_method = "8F6E83335C00A917FA8553D78AA1F253")
    public static void parse(String xml, ContentHandler contentHandler)
            throws SAXException {
        try {
            XMLReader reader = new ExpatReader();
            reader.setContentHandler(contentHandler);
            reader.parse(new InputSource(new StringReader(xml)));
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Parses xml from the given reader and fires events on the given SAX
     * handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.954 -0500", hash_original_method = "82BCADC868B280559F217E3557A725A7", hash_generated_method = "422FFC525900FA0AAD1FCE2F59538D50")
    public static void parse(Reader in, ContentHandler contentHandler)
            throws IOException, SAXException {
        XMLReader reader = new ExpatReader();
        reader.setContentHandler(contentHandler);
        reader.parse(new InputSource(in));
    }

    /**
     * Parses xml from the given input stream and fires events on the given SAX
     * handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.955 -0500", hash_original_method = "1D6F662958C1BDF1FC8B33D262C45E26", hash_generated_method = "06E099A51E41BDFBEEA6871660A43A37")
    public static void parse(InputStream in, Encoding encoding,
            ContentHandler contentHandler) throws IOException, SAXException {
        XMLReader reader = new ExpatReader();
        reader.setContentHandler(contentHandler);
        InputSource source = new InputSource(in);
        source.setEncoding(encoding.expatName);
        reader.parse(source);
    }

    /**
     * Returns a new pull parser with namespace support.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.956 -0500", hash_original_method = "F9ED2F3CC1A3E5AAFC55A34E4134AE5C", hash_generated_method = "3042A9D3F410CF5B615273264EA8BCBD")
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

    /**
     * Creates a new xml serializer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.957 -0500", hash_original_method = "01B773645C99A4A75AE8FF989ECB51E3", hash_generated_method = "B92B51CE45AEE8F572792599DBFF4411")
    public static XmlSerializer newSerializer() {
        try {
            return XmlSerializerFactory.instance.newSerializer();
        } catch (XmlPullParserException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Finds an encoding by name. Returns UTF-8 if you pass {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.967 -0500", hash_original_method = "EF4D773788368022CD555E81AFE1410D", hash_generated_method = "D970F4A8BF93E81B1B19C74531A1F140")
    public static Encoding findEncodingByName(String encodingName)
            throws UnsupportedEncodingException {
        if (encodingName == null) {
            return Encoding.UTF_8;
        }

        for (Encoding encoding : Encoding.values()) {
            if (encoding.expatName.equalsIgnoreCase(encodingName))
                return encoding;
        }
        throw new UnsupportedEncodingException(encodingName);
    }

    /**
     * Return an AttributeSet interface for use with the given XmlPullParser.
     * If the given parser itself implements AttributeSet, that implementation
     * is simply returned.  Otherwise a wrapper class is
     * instantiated on top of the XmlPullParser, as a proxy for retrieving its
     * attributes, and returned to you.
     *
     * @param parser The existing parser for which you would like an
     *               AttributeSet.
     *
     * @return An AttributeSet you can use to retrieve the
     *         attribute values at each of the tags as the parser moves
     *         through its XML document.
     *
     * @see AttributeSet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.968 -0500", hash_original_method = "5DC1275450A355C1DC130895BF0B045F", hash_generated_method = "E048853307992D93F474B7024676B12D")
    public static AttributeSet asAttributeSet(XmlPullParser parser) {
        return (parser instanceof AttributeSet)
                ? (AttributeSet) parser
                : new XmlPullAttributes(parser);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.953 -0500", hash_original_field = "AC931071D95E82345B9DC68F28085490", hash_generated_field = "21348723A34C602952749C00F7C301A8")

    public static String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";

    
    static class XmlSerializerFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.958 -0500", hash_original_field = "63CAAA423D36124FC0D7AB38D10C8F15", hash_generated_field = "9CE64B1BB229C601E95DA1B9B95DEB0E")

        static final String TYPE
                = "org.kxml2.io.KXmlParser,org.kxml2.io.KXmlSerializer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.959 -0500", hash_original_field = "CD9A6279660DB2464F29E73FE906AE77", hash_generated_field = "15959610877C4FD5EF3381E3547B65EC")

        static  XmlPullParserFactory instance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.349 -0400", hash_original_method = "C9EFF15750F86CC83530A41F4DEECEE2", hash_generated_method = "C9EFF15750F86CC83530A41F4DEECEE2")
        public XmlSerializerFactory ()
        {
            //Synthesized constructor
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.961 -0500", hash_original_field = "D2C19659B9B437333207087E9CF9E18E", hash_generated_field = "D2C19659B9B437333207087E9CF9E18E")


         String expatName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.962 -0500", hash_original_method = "5552248FA492761C4B2A155E60D42D33", hash_generated_method = "5552248FA492761C4B2A155E60D42D33")
            Encoding(String expatName) {
            this.expatName = expatName;
        }
    }
    /** @hide */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.952 -0500", hash_original_method = "6C88D7BAFDCBAE4F23C5F1A45165C3FD", hash_generated_method = "08859956CBF946AC287CC885505E1037")
    public Xml() {}
}

