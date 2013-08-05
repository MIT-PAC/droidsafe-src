package com.android.internal.util;

// Droidsafe Imports
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
import droidsafe.annotations.*;

public class XmlUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.090 -0400", hash_original_method = "76C216707CDD38D546F63E977F5F31C4", hash_generated_method = "76C216707CDD38D546F63E977F5F31C4")
    public XmlUtils ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    public static void skipCurrentTag(XmlPullParser parser) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG
                       || parser.getDepth() > outerDepth)) {
        }
    }

    
    @DSModeled(DSC.BAN)
    public static final int convertValueToList(CharSequence value, String[] options, int defaultValue) {
        if (null != value) {
            for (int i = 0; i < options.length; i++) {
                if (value.equals(options[i]))
                    return i;
            }
        }
        return defaultValue;
    }

    
    @DSModeled(DSC.BAN)
    public static final boolean convertValueToBoolean(CharSequence value, boolean defaultValue) {
        boolean result = false;
        if (null == value)
            return defaultValue;
        if (value.equals("1")
        ||  value.equals("true")
        ||  value.equals("TRUE"))
            result = true;
        return result;
    }

    
    @DSModeled(DSC.BAN)
    public static final int convertValueToInt(CharSequence charSeq, int defaultValue) {
        if (null == charSeq)
            return defaultValue;
        String nm = charSeq.toString();
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

    
    @DSModeled(DSC.BAN)
    public static final int convertValueToUnsignedInt(String value, int defaultValue) {
        if (null == value)
            return defaultValue;
        return parseUnsignedIntAttribute(value);
    }

    
    @DSModeled(DSC.BAN)
    public static final int parseUnsignedIntAttribute(CharSequence charSeq) {
        String  value = charSeq.toString();
        long    bits;
        int     index = 0;
        int     len = value.length();
        int     base = 10;
        if ('0' == value.charAt(index)) {
            if (index == (len - 1))
                return 0;
            char    c = value.charAt(index + 1);
            if ('x' == c || 'X' == c) {     
                index += 2;
                base = 16;
            } else {                        
                index++;
                base = 8;
            }
        } else if ('#' == value.charAt(index)) {
            index++;
            base = 16;
        }
        return (int) Long.parseLong(value.substring(index), base);
    }

    
    @DSModeled(DSC.BAN)
    public static final void writeMapXml(Map val, OutputStream out) throws XmlPullParserException, java.io.IOException {
        XmlSerializer serializer = new FastXmlSerializer();
        serializer.setOutput(out, "utf-8");
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(val, null, serializer);
        serializer.endDocument();
    }

    
    @DSModeled(DSC.BAN)
    public static final void writeListXml(List val, OutputStream out) throws XmlPullParserException, java.io.IOException {
        XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput(out, "utf-8");
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(val, null, serializer);
        serializer.endDocument();
    }

    
    @DSModeled(DSC.BAN)
    public static final void writeMapXml(Map val, String name, XmlSerializer out) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final void writeListXml(List val, String name, XmlSerializer out) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final void writeSetXml(Set val, String name, XmlSerializer out) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final void writeByteArrayXml(byte[] val, String name,
            XmlSerializer out) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final void writeIntArrayXml(int[] val, String name,
            XmlSerializer out) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final void writeValueXml(Object v, String name, XmlSerializer out) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final HashMap readMapXml(InputStream in) throws XmlPullParserException, java.io.IOException {
        XmlPullParser   parser = Xml.newPullParser();
        parser.setInput(in, null);
        return (HashMap)readValueXml(parser, new String[1]);
    }

    
    @DSModeled(DSC.BAN)
    public static final ArrayList readListXml(InputStream in) throws XmlPullParserException, java.io.IOException {
        XmlPullParser   parser = Xml.newPullParser();
        parser.setInput(in, null);
        return (ArrayList)readValueXml(parser, new String[1]);
    }

    
    @DSModeled(DSC.BAN)
    public static final HashSet readSetXml(InputStream in) throws XmlPullParserException, java.io.IOException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, null);
        return (HashSet) readValueXml(parser, new String[1]);
    }

    
    @DSModeled(DSC.BAN)
    public static final HashMap readThisMapXml(XmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, java.io.IOException {
        HashMap map = new HashMap();
        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                Object val = readThisValueXml(parser, name);
                if (name[0] != null) {
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

    
    @DSModeled(DSC.BAN)
    public static final ArrayList readThisListXml(XmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, java.io.IOException {
        ArrayList list = new ArrayList();
        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                Object val = readThisValueXml(parser, name);
                list.add(val);
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

    
    @DSModeled(DSC.BAN)
    public static final HashSet readThisSetXml(XmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, java.io.IOException {
        HashSet set = new HashSet();
        int eventType = parser.getEventType();
        do {
            if (eventType == parser.START_TAG) {
                Object val = readThisValueXml(parser, name);
                set.add(val);
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

    
    @DSModeled(DSC.BAN)
    public static final int[] readThisIntArrayXml(XmlPullParser parser,
            String endTag, String[] name) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final Object readValueXml(XmlPullParser parser, String[] name) throws XmlPullParserException, java.io.IOException {
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

    
    @DSModeled(DSC.BAN)
    private static final Object readThisValueXml(XmlPullParser parser, String[] name) throws XmlPullParserException, java.io.IOException {
        final String valueName = parser.getAttributeValue(null, "name");
        final String tagName = parser.getName();
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
            return res;
        } else if (tagName.equals("map")) {
            parser.next();
            res = readThisMapXml(parser, "map", name);
            name[0] = valueName;
            return res;
        } else if (tagName.equals("list")) {
            parser.next();
            res = readThisListXml(parser, "list", name);
            name[0] = valueName;
            return res;
        } else if (tagName.equals("set")) {
            parser.next();
            res = readThisSetXml(parser, "set", name);
            name[0] = valueName;
            return res;
        } else {
            throw new XmlPullParserException(
                "Unknown tag: " + tagName);
        }
        int eventType;
        while ((eventType = parser.next()) != parser.END_DOCUMENT) {
            if (eventType == parser.END_TAG) {
                if (parser.getName().equals(tagName)) {
                    name[0] = valueName;
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

    
    @DSModeled(DSC.BAN)
    public static final void beginDocument(XmlPullParser parser, String firstElementName) throws XmlPullParserException, IOException {
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

    
    @DSModeled(DSC.BAN)
    public static final void nextElement(XmlPullParser parser) throws XmlPullParserException, IOException {
        int type;
        while ((type=parser.next()) != parser.START_TAG
                   && type != parser.END_DOCUMENT) {
            ;
        }
    }

    
}

