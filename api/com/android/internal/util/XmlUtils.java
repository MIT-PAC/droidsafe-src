package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;

public class XmlUtils {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.528 -0500", hash_original_method = "AAAAEA56462AF9647E1BBB323C7E0DC3", hash_generated_method = "BF6C3D6BE0175CB56641BBB5BD104A0E")
    
public static void skipCurrentTag(XmlPullParser parser)
            throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.530 -0500", hash_original_method = "CEA4F2349B1AF02E53BDCE47DAEA0832", hash_generated_method = "18579B65D4C88824A5262ECC09CB6905")
    
public static final int
    convertValueToList(CharSequence value, String[] options, int defaultValue)
    {
        if (null != value) {
            for (int i = 0; i < options.length; i++) {
                if (value.equals(options[i]))
                    return i;
            }
        }

        return defaultValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.533 -0500", hash_original_method = "3FF7585B3B7CE0B0EE1E2CE21C873C38", hash_generated_method = "E911B9BB6D4FFC396E28FED90EBC72D0")
    
public static final boolean
    convertValueToBoolean(CharSequence value, boolean defaultValue)
    {
        boolean result = false;

        if (null == value)
            return defaultValue;

        if (value.equals("1")
        ||  value.equals("true")
        ||  value.equals("TRUE"))
            result = true;

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.535 -0500", hash_original_method = "2E04B7905BBBF700C063C4642034E5CE", hash_generated_method = "0455A111A0281A0123EC3C585183EFB8")
    
public static final int
    convertValueToInt(CharSequence charSeq, int defaultValue)
    {
        if (null == charSeq)
            return defaultValue;

        String nm = charSeq.toString();

        // XXX This code is copied from Integer.decode() so we don't
        // have to instantiate an Integer!

        int value;
        int sign = 1;
        int index = 0;
        int len = nm.length();
        int base = 10;

        if ('-' == nm.charAt(0)) {
            sign = -1;
            index++;
        }

        if ('0' == nm.charAt(index)) {
            //  Quick check for a zero by itself
            if (index == (len - 1))
                return 0;

            char    c = nm.charAt(index + 1);

            if ('x' == c || 'X' == c) {
                index += 2;
                base = 16;
            } else {
                index++;
                base = 8;
            }
        }
        else if ('#' == nm.charAt(index))
        {
            index++;
            base = 16;
        }

        return Integer.parseInt(nm.substring(index), base) * sign;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.538 -0500", hash_original_method = "310351CE76B02D900E15BA3893E99AAD", hash_generated_method = "77A80CDC3EFAA054166C7585805D36C7")
    
public static final int
    convertValueToUnsignedInt(String value, int defaultValue)
    {
        if (null == value)
            return defaultValue;

        return parseUnsignedIntAttribute(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.541 -0500", hash_original_method = "8EEFD3D2E773D28D0CAF601396FACD8F", hash_generated_method = "B70ED499640E8EB70622DEF6E6E5A112")
    
public static final int
    parseUnsignedIntAttribute(CharSequence charSeq)
    {
        String  value = charSeq.toString();

        long    bits;
        int     index = 0;
        int     len = value.length();
        int     base = 10;

        if ('0' == value.charAt(index)) {
            //  Quick check for zero by itself
            if (index == (len - 1))
                return 0;

            char    c = value.charAt(index + 1);

            if ('x' == c || 'X' == c) {     //  check for hex
                index += 2;
                base = 16;
            } else {                        //  check for octal
                index++;
                base = 8;
            }
        } else if ('#' == value.charAt(index)) {
            index++;
            base = 16;
        }

        return (int) Long.parseLong(value.substring(index), base);
    }

    /**
     * Flatten a Map into an output stream as XML.  The map can later be
     * read back with readMapXml().
     *
     * @param val The map to be flattened.
     * @param out Where to write the XML data.
     *
     * @see #writeMapXml(Map, String, XmlSerializer)
     * @see #writeListXml
     * @see #writeValueXml
     * @see #readMapXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.544 -0500", hash_original_method = "B316983EB04CDCEC233C22D8AF7B448C", hash_generated_method = "A3AD6319741F8351F483F49E450B8FDE")
    
public static final void writeMapXml(Map val, OutputStream out)
            throws XmlPullParserException, java.io.IOException {
        XmlSerializer serializer = new FastXmlSerializer();
        serializer.setOutput(out, "utf-8");
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(val, null, serializer);
        serializer.endDocument();
    }

    /**
     * Flatten a List into an output stream as XML.  The list can later be
     * read back with readListXml().
     *
     * @param val The list to be flattened.
     * @param out Where to write the XML data.
     *
     * @see #writeListXml(List, String, XmlSerializer)
     * @see #writeMapXml
     * @see #writeValueXml
     * @see #readListXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.547 -0500", hash_original_method = "CB5459F72CC236BB18EA772A3D0183C5", hash_generated_method = "6B68E47CC3AEC199022B116C7B53404D")
    
public static final void writeListXml(List val, OutputStream out)
    throws XmlPullParserException, java.io.IOException
    {
        XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput(out, "utf-8");
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(val, null, serializer);
        serializer.endDocument();
    }

    /**
     * Flatten a Map into an XmlSerializer.  The map can later be read back
     * with readThisMapXml().
     *
     * @param val The map to be flattened.
     * @param name Name attribute to include with this list's tag, or null for
     *             none.
     * @param out XmlSerializer to write the map into.
     *
     * @see #writeMapXml(Map, OutputStream)
     * @see #writeListXml
     * @see #writeValueXml
     * @see #readMapXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.549 -0500", hash_original_method = "1F52FCAAB51DEA0E76EDD9355166CAE1", hash_generated_method = "40C3CF3F8DFF4C81E9E075CCE96C2488")
    
public static final void writeMapXml(Map val, String name, XmlSerializer out)
    throws XmlPullParserException, java.io.IOException
    {
        if (val == null) {
            out.startTag(null, "null");
            out.endTag(null, "null");
            return;
        }

        Set s = val.entrySet();
        Iterator i = s.iterator();

        out.startTag(null, "map");
        if (name != null) {
            out.attribute(null, "name", name);
        }

        while (i.hasNext()) {
            Map.Entry e = (Map.Entry)i.next();
            writeValueXml(e.getValue(), (String)e.getKey(), out);
        }

        out.endTag(null, "map");
    }

    /**
     * Flatten a List into an XmlSerializer.  The list can later be read back
     * with readThisListXml().
     *
     * @param val The list to be flattened.
     * @param name Name attribute to include with this list's tag, or null for
     *             none.
     * @param out XmlSerializer to write the list into.
     *
     * @see #writeListXml(List, OutputStream)
     * @see #writeMapXml
     * @see #writeValueXml
     * @see #readListXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.552 -0500", hash_original_method = "4666B536C7E29DA76F907E136B605459", hash_generated_method = "28AE349BF3C72FCB010F5933B5A32B1C")
    
public static final void writeListXml(List val, String name, XmlSerializer out)
    throws XmlPullParserException, java.io.IOException
    {
        if (val == null) {
            out.startTag(null, "null");
            out.endTag(null, "null");
            return;
        }

        out.startTag(null, "list");
        if (name != null) {
            out.attribute(null, "name", name);
        }

        int N = val.size();
        int i=0;
        while (i < N) {
            writeValueXml(val.get(i), null, out);
            i++;
        }

        out.endTag(null, "list");
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.555 -0500", hash_original_method = "A2C1C26CCC3813840932FEF29BA390A5", hash_generated_method = "A44F3D2EA745E7EA7B801D4586126E0E")
    
public static final void writeSetXml(Set val, String name, XmlSerializer out)
            throws XmlPullParserException, java.io.IOException {
        if (val == null) {
            out.startTag(null, "null");
            out.endTag(null, "null");
            return;
        }
        
        out.startTag(null, "set");
        if (name != null) {
            out.attribute(null, "name", name);
        }
        
        for (Object v : val) {
            writeValueXml(v, null, out);
        }
        
        out.endTag(null, "set");
    }

    /**
     * Flatten a byte[] into an XmlSerializer.  The list can later be read back
     * with readThisByteArrayXml().
     *
     * @param val The byte array to be flattened.
     * @param name Name attribute to include with this array's tag, or null for
     *             none.
     * @param out XmlSerializer to write the array into.
     *
     * @see #writeMapXml
     * @see #writeValueXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.558 -0500", hash_original_method = "A07009E9A7F898B8C8462F16115B27B1", hash_generated_method = "4875565CCE8D6061402A1696DEC4F9F1")
    
public static final void writeByteArrayXml(byte[] val, String name,
            XmlSerializer out)
            throws XmlPullParserException, java.io.IOException {

        if (val == null) {
            out.startTag(null, "null");
            out.endTag(null, "null");
            return;
        }

        out.startTag(null, "byte-array");
        if (name != null) {
            out.attribute(null, "name", name);
        }

        final int N = val.length;
        out.attribute(null, "num", Integer.toString(N));

        StringBuilder sb = new StringBuilder(val.length*2);
        for (int i=0; i<N; i++) {
            int b = val[i];
            int h = b>>4;
            sb.append(h >= 10 ? ('a'+h-10) : ('0'+h));
            h = b&0xff;
            sb.append(h >= 10 ? ('a'+h-10) : ('0'+h));
        }

        out.text(sb.toString());

        out.endTag(null, "byte-array");
    }

    /**
     * Flatten an int[] into an XmlSerializer.  The list can later be read back
     * with readThisIntArrayXml().
     *
     * @param val The int array to be flattened.
     * @param name Name attribute to include with this array's tag, or null for
     *             none.
     * @param out XmlSerializer to write the array into.
     *
     * @see #writeMapXml
     * @see #writeValueXml
     * @see #readThisIntArrayXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.561 -0500", hash_original_method = "315921815F3785081F27F3FE625DBCCB", hash_generated_method = "AE064EEE3C35883093FB37E32995DB8A")
    
public static final void writeIntArrayXml(int[] val, String name,
            XmlSerializer out)
            throws XmlPullParserException, java.io.IOException {

        if (val == null) {
            out.startTag(null, "null");
            out.endTag(null, "null");
            return;
        }

        out.startTag(null, "int-array");
        if (name != null) {
            out.attribute(null, "name", name);
        }

        final int N = val.length;
        out.attribute(null, "num", Integer.toString(N));

        for (int i=0; i<N; i++) {
            out.startTag(null, "item");
            out.attribute(null, "value", Integer.toString(val[i]));
            out.endTag(null, "item");
        }

        out.endTag(null, "int-array");
    }

    /**
     * Flatten an object's value into an XmlSerializer.  The value can later
     * be read back with readThisValueXml().
     *
     * Currently supported value types are: null, String, Integer, Long,
     * Float, Double Boolean, Map, List.
     *
     * @param v The object to be flattened.
     * @param name Name attribute to include with this value's tag, or null
     *             for none.
     * @param out XmlSerializer to write the object into.
     *
     * @see #writeMapXml
     * @see #writeListXml
     * @see #readValueXml
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.564 -0500", hash_original_method = "82F216345EA52FCB5807D6A46DE8445B", hash_generated_method = "A9262B0D84E883AEAED8396C5245AE70")
    
public static final void writeValueXml(Object v, String name, XmlSerializer out)
    throws XmlPullParserException, java.io.IOException
    {
        String typeStr;
        if (v == null) {
            out.startTag(null, "null");
            if (name != null) {
                out.attribute(null, "name", name);
            }
            out.endTag(null, "null");
            return;
        } else if (v instanceof String) {
            out.startTag(null, "string");
            if (name != null) {
                out.attribute(null, "name", name);
            }
            out.text(v.toString());
            out.endTag(null, "string");
            return;
        } else if (v instanceof Integer) {
            typeStr = "int";
        } else if (v instanceof Long) {
            typeStr = "long";
        } else if (v instanceof Float) {
            typeStr = "float";
        } else if (v instanceof Double) {
            typeStr = "double";
        } else if (v instanceof Boolean) {
            typeStr = "boolean";
        } else if (v instanceof byte[]) {
            writeByteArrayXml((byte[])v, name, out);
            return;
        } else if (v instanceof int[]) {
            writeIntArrayXml((int[])v, name, out);
            return;
        } else if (v instanceof Map) {
            writeMapXml((Map)v, name, out);
            return;
        } else if (v instanceof List) {
            writeListXml((List)v, name, out);
            return;
        } else if (v instanceof Set) {
            writeSetXml((Set)v, name, out);
            return;
        } else if (v instanceof CharSequence) {
            // XXX This is to allow us to at least write something if
            // we encounter styled text...  but it means we will drop all
            // of the styling information. :(
            out.startTag(null, "string");
            if (name != null) {
                out.attribute(null, "name", name);
            }
            out.text(v.toString());
            out.endTag(null, "string");
            return;
        } else {
            throw new RuntimeException("writeValueXml: unable to write value " + v);
        }

        out.startTag(null, typeStr);
        if (name != null) {
            out.attribute(null, "name", name);
        }
        out.attribute(null, "value", v.toString());
        out.endTag(null, typeStr);
    }

    /**
     * Read a HashMap from an InputStream containing XML.  The stream can
     * previously have been written by writeMapXml().
     *
     * @param in The InputStream from which to read.
     *
     * @return HashMap The resulting map.
     *
     * @see #readListXml
     * @see #readValueXml
     * @see #readThisMapXml
     * #see #writeMapXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.568 -0500", hash_original_method = "451981095A31CF98AA2EA47B21E89F45", hash_generated_method = "C2609DB0CA95220C32D6204568743EA7")
    
public static final HashMap readMapXml(InputStream in)
    throws XmlPullParserException, java.io.IOException
    {
        XmlPullParser   parser = Xml.newPullParser();
        parser.setInput(in, null);
        return (HashMap)readValueXml(parser, new String[1]);
    }

    /**
     * Read an ArrayList from an InputStream containing XML.  The stream can
     * previously have been written by writeListXml().
     *
     * @param in The InputStream from which to read.
     *
     * @return ArrayList The resulting list.
     *
     * @see #readMapXml
     * @see #readValueXml
     * @see #readThisListXml
     * @see #writeListXml
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.571 -0500", hash_original_method = "19DDCF7A36CDD152C7A6B2FBD995EBB5", hash_generated_method = "9FD32910B0D0512DCF2D5BDEF96DEF28")
    
public static final ArrayList readListXml(InputStream in)
    throws XmlPullParserException, java.io.IOException
    {
        XmlPullParser   parser = Xml.newPullParser();
        parser.setInput(in, null);
        return (ArrayList)readValueXml(parser, new String[1]);
    }
    
    /**
     * Read a HashSet from an InputStream containing XML. The stream can
     * previously have been written by writeSetXml().
     * 
     * @param in The InputStream from which to read.
     * 
     * @return HashSet The resulting set.
     * 
     * @throws XmlPullParserException
     * @throws java.io.IOException
     * 
     * @see #readValueXml
     * @see #readThisSetXml
     * @see #writeSetXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.573 -0500", hash_original_method = "02FA7C1768B1D5902CFE928A1217987E", hash_generated_method = "284C1DF475CEF71A0B1EFDF0CC6151DE")
    
public static final HashSet readSetXml(InputStream in)
            throws XmlPullParserException, java.io.IOException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, null);
        return (HashSet) readValueXml(parser, new String[1]);
    }

    /**
     * Read a HashMap object from an XmlPullParser.  The XML data could
     * previously have been generated by writeMapXml().  The XmlPullParser
     * must be positioned <em>after</em> the tag that begins the map.
     *
     * @param parser The XmlPullParser from which to read the map data.
     * @param endTag Name of the tag that will end the map, usually "map".
     * @param name An array of one string, used to return the name attribute
     *             of the map's tag.
     *
     * @return HashMap The newly generated map.
     *
     * @see #readMapXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.576 -0500", hash_original_method = "B94D225452D6F3859CEDE3BC9422CB6B", hash_generated_method = "CF2E1B56DF5258E57EC81EEA67BEFCED")
    
public static final HashMap readThisMapXml(XmlPullParser parser, String endTag, String[] name)
    throws XmlPullParserException, java.io.IOException
    {
        HashMap map = new HashMap();

        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                Object val = readThisValueXml(parser, name);
                if (name[0] != null) {
                    //System.out.println("Adding to map: " + name + " -> " + val);
                    map.put(name[0], val);
                } else {
                    throw new XmlPullParserException(
                        "Map value without name attribute: " + parser.getName());
                }
            } else if (eventType == parser.END_TAG) {
                if (parser.getName().equals(endTag)) {
                    return map;
                }
                throw new XmlPullParserException(
                    "Expected " + endTag + " end tag at: " + parser.getName());
            }
            eventType = parser.next();
        } while (eventType != parser.END_DOCUMENT);

        throw new XmlPullParserException(
            "Document ended before " + endTag + " end tag");
    }

    /**
     * Read an ArrayList object from an XmlPullParser.  The XML data could
     * previously have been generated by writeListXml().  The XmlPullParser
     * must be positioned <em>after</em> the tag that begins the list.
     *
     * @param parser The XmlPullParser from which to read the list data.
     * @param endTag Name of the tag that will end the list, usually "list".
     * @param name An array of one string, used to return the name attribute
     *             of the list's tag.
     *
     * @return HashMap The newly generated list.
     *
     * @see #readListXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.579 -0500", hash_original_method = "B65038280E8BB44BE238AA107D896C14", hash_generated_method = "2042234321E502ABF3FAEB2D5827D8D3")
    
public static final ArrayList readThisListXml(XmlPullParser parser, String endTag, String[] name)
    throws XmlPullParserException, java.io.IOException
    {
        ArrayList list = new ArrayList();

        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                Object val = readThisValueXml(parser, name);
                list.add(val);
                //System.out.println("Adding to list: " + val);
            } else if (eventType == parser.END_TAG) {
                if (parser.getName().equals(endTag)) {
                    return list;
                }
                throw new XmlPullParserException(
                    "Expected " + endTag + " end tag at: " + parser.getName());
            }
            eventType = parser.next();
        } while (eventType != parser.END_DOCUMENT);

        throw new XmlPullParserException(
            "Document ended before " + endTag + " end tag");
    }
    
    /**
     * Read a HashSet object from an XmlPullParser. The XML data could previously
     * have been generated by writeSetXml(). The XmlPullParser must be positioned
     * <em>after</em> the tag that begins the set.
     * 
     * @param parser The XmlPullParser from which to read the set data.
     * @param endTag Name of the tag that will end the set, usually "set".
     * @param name An array of one string, used to return the name attribute
     *             of the set's tag.
     *
     * @return HashSet The newly generated set.
     * 
     * @throws XmlPullParserException
     * @throws java.io.IOException
     * 
     * @see #readSetXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.581 -0500", hash_original_method = "6B9B1F7769DAE5AF421D5FA08BCA9A98", hash_generated_method = "449E8B21CEE3A99021CC17A6ED943528")
    
public static final HashSet readThisSetXml(XmlPullParser parser, String endTag, String[] name)
            throws XmlPullParserException, java.io.IOException {
        HashSet set = new HashSet();
        
        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                Object val = readThisValueXml(parser, name);
                set.add(val);
                //System.out.println("Adding to set: " + val);
            } else if (eventType == parser.END_TAG) {
                if (parser.getName().equals(endTag)) {
                    return set;
                }
                throw new XmlPullParserException(
                        "Expected " + endTag + " end tag at: " + parser.getName());
            }
            eventType = parser.next();
        } while (eventType != parser.END_DOCUMENT);
        
        throw new XmlPullParserException(
                "Document ended before " + endTag + " end tag");
    }

    /**
     * Read an int[] object from an XmlPullParser.  The XML data could
     * previously have been generated by writeIntArrayXml().  The XmlPullParser
     * must be positioned <em>after</em> the tag that begins the list.
     *
     * @param parser The XmlPullParser from which to read the list data.
     * @param endTag Name of the tag that will end the list, usually "list".
     * @param name An array of one string, used to return the name attribute
     *             of the list's tag.
     *
     * @return Returns a newly generated int[].
     *
     * @see #readListXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.585 -0500", hash_original_method = "59A4CBE51FAECBB8E991947ECCA70099", hash_generated_method = "D12E2A5527E75FF44873F1FD8DA7F714")
    
public static final int[] readThisIntArrayXml(XmlPullParser parser,
            String endTag, String[] name)
            throws XmlPullParserException, java.io.IOException {

        int num;
        try {
            num = Integer.parseInt(parser.getAttributeValue(null, "num"));
        } catch (NullPointerException e) {
            throw new XmlPullParserException(
                    "Need num attribute in byte-array");
        } catch (NumberFormatException e) {
            throw new XmlPullParserException(
                    "Not a number in num attribute in byte-array");
        }

        int[] array = new int[num];
        int i = 0;

        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                if (parser.getName().equals("item")) {
                    try {
                        array[i] = Integer.parseInt(
                                parser.getAttributeValue(null, "value"));
                    } catch (NullPointerException e) {
                        throw new XmlPullParserException(
                                "Need value attribute in item");
                    } catch (NumberFormatException e) {
                        throw new XmlPullParserException(
                                "Not a number in value attribute in item");
                    }
                } else {
                    throw new XmlPullParserException(
                            "Expected item tag at: " + parser.getName());
                }
            } else if (eventType == parser.END_TAG) {
                if (parser.getName().equals(endTag)) {
                    return array;
                } else if (parser.getName().equals("item")) {
                    i++;
                } else {
                    throw new XmlPullParserException(
                        "Expected " + endTag + " end tag at: "
                        + parser.getName());
                }
            }
            eventType = parser.next();
        } while (eventType != parser.END_DOCUMENT);

        throw new XmlPullParserException(
            "Document ended before " + endTag + " end tag");
    }

    /**
     * Read a flattened object from an XmlPullParser.  The XML data could
     * previously have been written with writeMapXml(), writeListXml(), or
     * writeValueXml().  The XmlPullParser must be positioned <em>at</em> the
     * tag that defines the value.
     *
     * @param parser The XmlPullParser from which to read the object.
     * @param name An array of one string, used to return the name attribute
     *             of the value's tag.
     *
     * @return Object The newly generated value object.
     *
     * @see #readMapXml
     * @see #readListXml
     * @see #writeValueXml
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.588 -0500", hash_original_method = "0ED240205957B5EB6254FD7A63F6E825", hash_generated_method = "8F4EA45266DAC1BF7A58EC1925D492DD")
    
public static final Object readValueXml(XmlPullParser parser, String[] name)
    throws XmlPullParserException, java.io.IOException
    {
        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                return readThisValueXml(parser, name);
            } else if (eventType == parser.END_TAG) {
                throw new XmlPullParserException(
                    "Unexpected end tag at: " + parser.getName());
            } else if (eventType == parser.TEXT) {
                throw new XmlPullParserException(
                    "Unexpected text: " + parser.getText());
            }
            eventType = parser.next();
        } while (eventType != parser.END_DOCUMENT);

        throw new XmlPullParserException(
            "Unexpected end of document");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.593 -0500", hash_original_method = "16BF65FFEAF4EB8C9C23A818A2EB822A", hash_generated_method = "9A7552BAFD7DED8D03BC1253A78B5B0C")
    
private static final Object readThisValueXml(XmlPullParser parser, String[] name)
    throws XmlPullParserException, java.io.IOException
    {
        final String valueName = parser.getAttributeValue(null, "name");
        final String tagName = parser.getName();

        //System.out.println("Reading this value tag: " + tagName + ", name=" + valueName);

        Object res;

        if (tagName.equals("null")) {
            res = null;
        } else if (tagName.equals("string")) {
            String value = "";
            int eventType;
            while ((eventType = parser.next()) != parser.END_DOCUMENT) {
                if (eventType == parser.END_TAG) {
                    if (parser.getName().equals("string")) {
                        name[0] = valueName;
                        //System.out.println("Returning value for " + valueName + ": " + value);
                        return value;
                    }
                    throw new XmlPullParserException(
                        "Unexpected end tag in <string>: " + parser.getName());
                } else if (eventType == parser.TEXT) {
                    value += parser.getText();
                } else if (eventType == parser.START_TAG) {
                    throw new XmlPullParserException(
                        "Unexpected start tag in <string>: " + parser.getName());
                }
            }
            throw new XmlPullParserException(
                "Unexpected end of document in <string>");
        } else if (tagName.equals("int")) {
            res = Integer.parseInt(parser.getAttributeValue(null, "value"));
        } else if (tagName.equals("long")) {
            res = Long.valueOf(parser.getAttributeValue(null, "value"));
        } else if (tagName.equals("float")) {
            res = new Float(parser.getAttributeValue(null, "value"));
        } else if (tagName.equals("double")) {
            res = new Double(parser.getAttributeValue(null, "value"));
        } else if (tagName.equals("boolean")) {
            res = Boolean.valueOf(parser.getAttributeValue(null, "value"));
        } else if (tagName.equals("int-array")) {
            parser.next();
            res = readThisIntArrayXml(parser, "int-array", name);
            name[0] = valueName;
            //System.out.println("Returning value for " + valueName + ": " + res);
            return res;
        } else if (tagName.equals("map")) {
            parser.next();
            res = readThisMapXml(parser, "map", name);
            name[0] = valueName;
            //System.out.println("Returning value for " + valueName + ": " + res);
            return res;
        } else if (tagName.equals("list")) {
            parser.next();
            res = readThisListXml(parser, "list", name);
            name[0] = valueName;
            //System.out.println("Returning value for " + valueName + ": " + res);
            return res;
        } else if (tagName.equals("set")) {
            parser.next();
            res = readThisSetXml(parser, "set", name);
            name[0] = valueName;
            //System.out.println("Returning value for " + valueName + ": " + res);
            return res;
        } else {
            throw new XmlPullParserException(
                "Unknown tag: " + tagName);
        }

        // Skip through to end tag.
        int eventType;
        while ((eventType = parser.next()) != parser.END_DOCUMENT) {
            if (eventType == parser.END_TAG) {
                if (parser.getName().equals(tagName)) {
                    name[0] = valueName;
                    //System.out.println("Returning value for " + valueName + ": " + res);
                    return res;
                }
                throw new XmlPullParserException(
                    "Unexpected end tag in <" + tagName + ">: " + parser.getName());
            } else if (eventType == parser.TEXT) {
                throw new XmlPullParserException(
                "Unexpected text in <" + tagName + ">: " + parser.getName());
            } else if (eventType == parser.START_TAG) {
                throw new XmlPullParserException(
                    "Unexpected start tag in <" + tagName + ">: " + parser.getName());
            }
        }
        throw new XmlPullParserException(
            "Unexpected end of document in <" + tagName + ">");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.596 -0500", hash_original_method = "2250E45F489CDF629FB35C26D8361AB6", hash_generated_method = "2E2921BAAE83F0A7976E0CD91CC590E4")
    
public static final void beginDocument(XmlPullParser parser, String firstElementName) throws XmlPullParserException, IOException
    {
        int type;
        while ((type=parser.next()) != parser.START_TAG
                   && type != parser.END_DOCUMENT) {
            ;
        }

        if (type != parser.START_TAG) {
            throw new XmlPullParserException("No start tag found");
        }

        if (!parser.getName().equals(firstElementName)) {
            throw new XmlPullParserException("Unexpected start tag: found " + parser.getName() +
                    ", expected " + firstElementName);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.598 -0500", hash_original_method = "517AA30663FDFFE58192CA2D8B409F2D", hash_generated_method = "E51EB2080B57A8C42BE0C6BC762A9968")
    
public static final void nextElement(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        int type;
        while ((type=parser.next()) != parser.START_TAG
                   && type != parser.END_DOCUMENT) {
            ;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.090 -0400", hash_original_method = "76C216707CDD38D546F63E977F5F31C4", hash_generated_method = "76C216707CDD38D546F63E977F5F31C4")
    public XmlUtils ()
    {
        //Synthesized constructor
    }
    
}

