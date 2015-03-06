/* Licensed to the Apache Software Foundation (ASF) under one or more
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.prefs;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import libcore.io.IoUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Utility class for the Preferences import/export from XML file.
 */
class XMLParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.432 -0400", hash_original_field = "05BD82011C0E2A2C5091E15C56459563", hash_generated_field = "F476EF323453CAE4232AC085D8C3B525")

    static final String PREFS_DTD_NAME = "http://java.sun.com/dtd/preferences.dtd";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.432 -0400", hash_original_field = "42F99AB7CBA4E13D71A4C0BCEEF4C58E", hash_generated_field = "E14AFFBA3B96B5BA44C047B815BF8FEC")

    static final String PREFS_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "    <!ELEMENT preferences (root)>"
        + "    <!ATTLIST preferences EXTERNAL_XML_VERSION CDATA \"0.0\" >"
        + "    <!ELEMENT root (map, node*) >"
        + "    <!ATTLIST root type (system|user) #REQUIRED >"
        + "    <!ELEMENT node (map, node*) >"
        + "    <!ATTLIST node name CDATA #REQUIRED >"
        + "    <!ELEMENT map (entry*) >"
        + "    <!ELEMENT entry EMPTY >"
        + "    <!ATTLIST entry key   CDATA #REQUIRED value CDATA #REQUIRED >";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.433 -0400", hash_original_field = "E008F667C21B4B5F55D7B7BFDF865479", hash_generated_field = "C99E88791A7EF4E2825EE178DB807AF4")

    static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.433 -0400", hash_original_field = "6ABE3ED158CA5A006D0E550167DBF116", hash_generated_field = "3C7688A9050BCCE58D15EF63185C5B86")

    static final String DOCTYPE = "<!DOCTYPE preferences SYSTEM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.434 -0400", hash_original_field = "E84F01094812D2EAA85371214412B955", hash_generated_field = "8596555F144064CAF2AFFD1AAE95EA1D")

    private static final String FILE_PREFS = "<!DOCTYPE map SYSTEM 'http://java.sun.com/dtd/preferences.dtd'>";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.434 -0400", hash_original_field = "945BB6F9BC3E8D1D45AB3B18361578E8", hash_generated_field = "C5962A96B2A0A5F323BE15DA6987DA7E")

    private static final float XML_VERSION = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.434 -0400", hash_original_field = "ED242E7404B4650FC0A44677EA000568", hash_generated_field = "10C7A8771DC85E1D1D6CF684604F246A")

    private static  DocumentBuilder builder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.435 -0400", hash_original_field = "DA22A84926E32A42F95FB3066AE45DA6", hash_generated_field = "9E407E491DE00A67607428800D72FE47")

    private static int indent = -1;

    /*
     * init DOM builder
     */
    static {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new Error(e);
        }
        builder.setEntityResolver(new EntityResolver() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.435 -0400", hash_original_method = "C2BB7EF6A883EE0D9F0AB143BBF32BCD", hash_generated_method = "1A8847DF9B74864D7F2209BD413F8BDE")
            
public InputSource resolveEntity(String publicId, String systemId)
            throws SAXException, IOException {
                if (systemId.equals(PREFS_DTD_NAME)) {
                    InputSource result = new InputSource(new StringReader(
                            PREFS_DTD));
                    result.setSystemId(PREFS_DTD_NAME);
                    return result;
                }
                throw new SAXException("Invalid DOCTYPE declaration " + systemId);
            }
        });
        builder.setErrorHandler(new ErrorHandler() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.436 -0400", hash_original_method = "A780B405018C6E806DD90859BE935681", hash_generated_method = "5DADC32ECCFAECCD4F18AF4B73111C38")
            
public void warning(SAXParseException e) throws SAXException {
                throw e;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.436 -0400", hash_original_method = "1BA627FA566198BCA8957A882673AC06", hash_generated_method = "D10193ADE3BD34266E46CB7EF385B5B4")
            
public void error(SAXParseException e) throws SAXException {
                throw e;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.436 -0400", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "8BE9290E5A78003CD3400FC7458B6660")
            
public void fatalError(SAXParseException e) throws SAXException {
                throw e;
            }
        });
    }

    /***************************************************************************
     * utilities for Preferences export
     **************************************************************************/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.438 -0400", hash_original_method = "39930FDA5342EF3BF594134D02427635", hash_generated_method = "BC4F21C4DD9B4A4F9A2DE81FDF98CDBB")
    
static void exportPrefs(Preferences prefs, OutputStream stream,
            boolean withSubTree) throws IOException, BackingStoreException {
        indent = -1;
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(stream, "UTF-8"));
        out.write(HEADER);
        out.newLine();
        out.newLine();

        out.write(DOCTYPE);
        out.write(" '");
        out.write(PREFS_DTD_NAME);
        out.write("'>");
        out.newLine();
        out.newLine();

        flushStartTag("preferences", new String[] { "EXTERNAL_XML_VERSION" },
                new String[] { String.valueOf(XML_VERSION) }, out);
        flushStartTag("root", new String[] { "type" },
                new String[] { prefs.isUserNode() ? "user" : "system" }, out);
        flushEmptyElement("map", out);

        StringTokenizer ancestors = new StringTokenizer(prefs.absolutePath(), "/");
        exportNode(ancestors, prefs, withSubTree, out);

        flushEndTag("root", out);
        flushEndTag("preferences", out);
        out.flush();
        out = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.439 -0400", hash_original_method = "FBF44372892CF977307163B6517D47EC", hash_generated_method = "D2822242C0D64AFB62A5801E4B221F6C")
    
private static void exportNode(StringTokenizer ancestors,
            Preferences prefs, boolean withSubTree, BufferedWriter out)
            throws IOException, BackingStoreException {
        if (ancestors.hasMoreTokens()) {
            String name = ancestors.nextToken();
            flushStartTag("node", new String[] { "name" }, new String[] { name }, out);
            if (ancestors.hasMoreTokens()) {
                flushEmptyElement("map", out);
                exportNode(ancestors, prefs, withSubTree, out);
            } else {
                exportEntries(prefs, out);
                if (withSubTree) {
                    exportSubTree(prefs, out);
                }
            }
            flushEndTag("node", out);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.440 -0400", hash_original_method = "09DE7294C9432B71319CA39B7A7619CD", hash_generated_method = "B809EB6FD08E8EDBA826AB499B6DD311")
    
private static void exportSubTree(Preferences prefs, BufferedWriter out)
    throws BackingStoreException, IOException {
        String[] names = prefs.childrenNames();
        if (names.length > 0) {
            for (int i = 0; i < names.length; i++) {
                Preferences child = prefs.node(names[i]);
                flushStartTag("node", new String[] { "name" }, new String[] { names[i] }, out);
                exportEntries(child, out);
                exportSubTree(child, out);
                flushEndTag("node", out);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.440 -0400", hash_original_method = "6BAA4865CC4B11263353C40B200BDEA9", hash_generated_method = "83B474523FBBE20868CC6E282039E449")
    
private static void exportEntries(Preferences prefs, BufferedWriter out)
    throws BackingStoreException, IOException {
        String[] keys = prefs.keys();
        String[] values = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
            values[i] = prefs.get(keys[i], null);
        }
        exportEntries(keys, values, out);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.441 -0400", hash_original_method = "E8DEB48FFC184425DC2D65069D845C18", hash_generated_method = "65BDB06D95518A2849152BC8AEAFD549")
    
private static void exportEntries(String[] keys, String[] values,
            BufferedWriter out) throws IOException {
        if (keys.length == 0) {
            flushEmptyElement("map", out);
            return;
        }
        flushStartTag("map", out);
        for (int i = 0; i < keys.length; i++) {
            if (values[i] != null) {
                flushEmptyElement("entry", new String[] { "key", "value" },
                        new String[] { keys[i], values[i] }, out);
            }
        }
        flushEndTag("map", out);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.442 -0400", hash_original_method = "9F77618B6DE23C40FBF2505BCC331F15", hash_generated_method = "A3C53D5DFF6E6B3E2B2B447F0C0F499B")
    
private static void flushEndTag(String tagName, BufferedWriter out)
    throws IOException {
        flushIndent(indent--, out);
        out.write("</");
        out.write(tagName);
        out.write(">");
        out.newLine();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.442 -0400", hash_original_method = "9C4EC788D47EEDDCE653ABCC0DF45803", hash_generated_method = "E99C08E5693F1D6889CFEC24ED9C9FF7")
    
private static void flushEmptyElement(String tagName, BufferedWriter out)
    throws IOException {
        flushIndent(++indent, out);
        out.write("<");
        out.write(tagName);
        out.write(" />");
        out.newLine();
        indent--;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.443 -0400", hash_original_method = "937CE354F481F649100695C1D0DEE444", hash_generated_method = "2707A71BA3BD1D98B59CEB6212DF7D41")
    
private static void flushEmptyElement(String tagName, String[] attrKeys,
            String[] attrValues, BufferedWriter out) throws IOException {
        flushIndent(++indent, out);
        out.write("<");
        out.write(tagName);
        flushPairs(attrKeys, attrValues, out);
        out.write(" />");
        out.newLine();
        indent--;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.443 -0400", hash_original_method = "5CC4807EA37A17FF86A8D76F33DBADDC", hash_generated_method = "84F21DA2DB9AB119A70BC1AC757E83E9")
    
private static void flushPairs(String[] attrKeys, String[] attrValues,
            BufferedWriter out) throws IOException {
        for (int i = 0; i < attrKeys.length; i++) {
            out.write(" ");
            out.write(attrKeys[i]);
            out.write("=\"");
            out.write(htmlEncode(attrValues[i]));
            out.write("\"");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.444 -0400", hash_original_method = "67B8DFDE15555318B8C1AB74AA916EEB", hash_generated_method = "D3272F6E48AF9A04236BB4CB4BB44F01")
    
private static void flushIndent(int ind, BufferedWriter out)
    throws IOException {
        for (int i = 0; i < ind; i++) {
            out.write("  ");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.444 -0400", hash_original_method = "B2F0537E2175E8E0E167071C79F02049", hash_generated_method = "44628A40785BC601D0D5146EE48E421C")
    
private static void flushStartTag(String tagName, String[] attrKeys,
            String[] attrValues, BufferedWriter out) throws IOException {
        flushIndent(++indent, out);
        out.write("<");
        out.write(tagName);
        flushPairs(attrKeys, attrValues, out);
        out.write(">");
        out.newLine();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.444 -0400", hash_original_method = "3E9C39B9A53762E5BAC5D4E7F746BE03", hash_generated_method = "331B556E4D575E89FDF1B16217DB7523")
    
private static void flushStartTag(String tagName, BufferedWriter out)
    throws IOException {
        flushIndent(++indent, out);
        out.write("<");
        out.write(tagName);
        out.write(">");
        out.newLine();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.445 -0400", hash_original_method = "3C0DB657E577620883F42E3C6ED0EDD8", hash_generated_method = "9E792CAFF11DB5D2829FB9A1D3091A4C")
    
private static String htmlEncode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            case '&':
                sb.append("&amp;");
                break;
            case '"':
                sb.append("&quot;");
                break;
            default:
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /***************************************************************************
     * utilities for Preferences import
     **************************************************************************/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.446 -0400", hash_original_method = "91F4F50BF9CC02B78775F74F7B17B8EB", hash_generated_method = "8CB94AE6640B04351961C88662F097E5")
    
static void importPrefs(InputStream in) throws IOException, InvalidPreferencesFormatException {
        try {
            // load XML document
            Document doc = builder.parse(new InputSource(in));

            // check preferences' export version
            Element preferences;
            preferences = doc.getDocumentElement();
            String version = preferences.getAttribute("EXTERNAL_XML_VERSION");
            if (version != null && Float.parseFloat(version) > XML_VERSION) {
                throw new InvalidPreferencesFormatException("Preferences version " + version +
                        " is not supported");
            }

            // check preferences root's type
            Element root = (Element) preferences
            .getElementsByTagName("root").item(0);
            Preferences prefsRoot = null;
            String type = root.getAttribute("type");
            if (type.equals("user")) {
                prefsRoot = Preferences.userRoot();
            } else {
                prefsRoot = Preferences.systemRoot();
            }

            // load node
            loadNode(prefsRoot, root);
        } catch (FactoryConfigurationError e) {
            throw new InvalidPreferencesFormatException(e);
        } catch (SAXException e) {
            throw new InvalidPreferencesFormatException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.447 -0400", hash_original_method = "8D34A340A4522AAEBA77DCB7561C1809", hash_generated_method = "CD1C4997F23EF258D0E0F4FB10423480")
    
private static void loadNode(Preferences prefs, Element node) {
        // load preferences
        NodeList children = selectNodeList(node, "node");
        NodeList entries = selectNodeList(node, "map/entry");
        int childNumber = children.getLength();
        Preferences[] prefChildren = new Preferences[childNumber];
        int entryNumber = entries.getLength();
        synchronized (((AbstractPreferences) prefs).lock) {
            if (((AbstractPreferences) prefs).isRemoved()) {
                return;
            }
            for (int i = 0; i < entryNumber; i++) {
                Element entry = (Element) entries.item(i);
                String key = entry.getAttribute("key");
                String value = entry.getAttribute("value");
                prefs.put(key, value);
            }
            // get children preferences node
            for (int i = 0; i < childNumber; i++) {
                Element child = (Element) children.item(i);
                String name = child.getAttribute("name");
                prefChildren[i] = prefs.node(name);
            }
        }

        // load children nodes after unlock
        for (int i = 0; i < childNumber; i++) {
            loadNode(prefChildren[i], (Element) children.item(i));
        }
    }

    // TODO dirty implementation of a method from javax.xml.xpath
    // should be replaced with a call to a good impl of this method
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.449 -0400", hash_original_method = "A03FB024E901D4DF467B92A3E6289297", hash_generated_method = "2AEE6C0A948226210284DFF64927A068")
    
private static NodeList selectNodeList(Element documentElement, String string) {

        NodeList result = null;

        ArrayList<Node> input = new ArrayList<Node>();

        String[] path = string.split("/");

        NodeList childNodes = documentElement.getChildNodes();

        if(path[0].equals("entry") || path[0].equals("node")) {
            for (int i = 0; i < childNodes.getLength(); i++) {
                Object next = childNodes.item(i);
                if(next instanceof Element) {
                    if(((Element) next).getNodeName().equals(path[0])) {
                        input.add((Node)next);
                    }
                }
            }
        } else if(path[0].equals("map") && path[1].equals("entry")) {
            for (int i = 0; i < childNodes.getLength(); i++) {
                Object next = childNodes.item(i);
                if(next instanceof Element) {
                    if(((Element) next).getNodeName().equals(path[0])) {
                        NodeList nextChildNodes = ((Node)next).getChildNodes();
                        for (int j = 0; j < nextChildNodes.getLength(); j++) {
                            Object subnext = nextChildNodes.item(j);
                            if(subnext instanceof Element) {
                                if(((Element)subnext).getNodeName().equals(path[1])) {
                                    input.add((Node)subnext);
                                }
                            }
                        }
                    }
                }
            }
        }

        result = new NodeSet(input.iterator());

        return result;
    }

    /**
     * Returns the preferences from {@code xmlFile}. Returns empty properties if
     * any errors occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.450 -0400", hash_original_method = "74EE24FBFAF8F7BA188F53AA531F1F6A", hash_generated_method = "4D8694D2657DABACF8C95E9CB0B9A70B")
    
static Properties readXmlPreferences(File xmlFile) {
        Properties result = new Properties();
        if (!xmlFile.exists()) {
            xmlFile.getParentFile().mkdirs();
        } else if (xmlFile.canRead()) {
            Reader reader = null;
            try {
                reader = new InputStreamReader(new FileInputStream(xmlFile), "UTF-8");
                Document document = builder.parse(new InputSource(reader));
                NodeList entries = selectNodeList(document.getDocumentElement(), "entry");
                int length = entries.getLength();
                for (int i = 0; i < length; i++) {
                    Element node = (Element) entries.item(i);
                    String key = node.getAttribute("key");
                    String value = node.getAttribute("value");
                    result.setProperty(key, value);
                }
            } catch (IOException ignored) {
            } catch (SAXException ignored) {
            } finally {
                IoUtils.closeQuietly(reader);
            }
        } else {
            // the prefs API requires this to be hostile towards pre-existing files
            xmlFile.delete();
        }
        return result;
    }

    /**
     * Writes the preferences to {@code xmlFile}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.451 -0400", hash_original_method = "324B430097D5A73FFB9C9EABABB363D2", hash_generated_method = "034171051563EC70A3DF5A3A6C52E0F4")
    
static void writeXmlPreferences(File xmlFile, Properties properties) throws IOException {
        File parent = xmlFile.getParentFile();
        File temporaryForWriting = new File(parent, "prefs-" + UUID.randomUUID() + ".xml.tmp");

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(temporaryForWriting), "UTF-8"));
            out.write(HEADER);
            out.newLine();
            out.write(FILE_PREFS);
            out.newLine();
            String[] keys = properties.keySet().toArray(new String[properties.size()]);
            int length = keys.length;
            String[] values = new String[length];
            for (int i = 0; i < length; i++) {
                values[i] = properties.getProperty(keys[i]);
            }
            exportEntries(keys, values, out);
            out.close();
            if (!temporaryForWriting.renameTo(xmlFile)) {
                throw new IOException("Failed to write preferences to " + xmlFile);
            }
        } finally {
            IoUtils.closeQuietly(out);
            temporaryForWriting.delete(); // no-op unless something failed
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.437 -0400", hash_original_method = "588DF928B022592B272AD09BCF76CBB6", hash_generated_method = "6D710E39FECE033E3B6A1FE91F416AD8")
    
private XMLParser() {// empty constructor
    }
}
