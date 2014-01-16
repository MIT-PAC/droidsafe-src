package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;

import libcore.io.IoUtils;

import org.apache.harmony.xml.dom.CDATASectionImpl;
import org.apache.harmony.xml.dom.DOMImplementationImpl;
import org.apache.harmony.xml.dom.DocumentImpl;
import org.apache.harmony.xml.dom.DocumentTypeImpl;
import org.apache.harmony.xml.dom.TextImpl;
import org.kxml2.io.KXmlParser;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.LocatorImpl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class DocumentBuilderImpl extends DocumentBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.531 -0500", hash_original_field = "0102F1A49F8E316D8FD2897170D47D13", hash_generated_field = "512771BF3B10ACB6843471120D35250C")

    private static DOMImplementationImpl dom = DOMImplementationImpl.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.533 -0500", hash_original_field = "61B02D1FC4FDC4DF74DBAFF8FF38BA22", hash_generated_field = "4A9121F2D482493F3BEB1C30E72C76AA")

    private boolean coalescing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.535 -0500", hash_original_field = "0F20E0B3BF6506A85F7C0D2D3D40FE9D", hash_generated_field = "923D10729FC72A63D7530A13EDC17701")

    private EntityResolver entityResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.538 -0500", hash_original_field = "D1E7497C7DFC94EB56211895742439AB", hash_generated_field = "754BD707F8949F8FC6D5E6C0F6EACB6F")

    private ErrorHandler errorHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.540 -0500", hash_original_field = "DEE8C0B92045B7C1CBD357178376AFE3", hash_generated_field = "833EEF27C45F7AD04FCDBA4B464FF80B")

    private boolean ignoreComments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.542 -0500", hash_original_field = "3B5F4C5DDBFADB3E97105BFEDB41049C", hash_generated_field = "936EEB5781DB0070979C36A276CB0F01")

    private boolean ignoreElementContentWhitespace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.544 -0500", hash_original_field = "6DED3D0909D027805E22F95BA58508AE", hash_generated_field = "9718A1E7D4348F4ADD16E4057036B4E2")

    private boolean namespaceAware;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.766 -0400", hash_original_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58", hash_generated_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58")
    public DocumentBuilderImpl ()
    {
        //Synthesized constructor
    }
    // adding a new field? don't forget to update reset().

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.546 -0500", hash_original_method = "EFC1F1695F664AAB80C061E3A6039A89", hash_generated_method = "132C43B121F65C615C1E3CB9F7D20E72")
    
@Override public void reset() {
        coalescing = false;
        entityResolver = null;
        errorHandler = null;
        ignoreComments = false;
        ignoreElementContentWhitespace = false;
        namespaceAware = false;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.549 -0500", hash_original_method = "18E3291D22CB922EEB4EFC42536C583A", hash_generated_method = "CE3A709CF5F906BDFA69FE3E3C90941E")
    
@Override
    public DOMImplementation getDOMImplementation() {
        return dom;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.551 -0500", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "6F3C61E1218AD1F1A5F3328FB64459B6")
    
@Override
    public boolean isNamespaceAware() {
        return namespaceAware;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.553 -0500", hash_original_method = "BC62268279A4D4DB4B44A495D4290EBF", hash_generated_method = "521D4F41CD5F8C10A9AEB994B00B3678")
    
@Override
    public boolean isValidating() {
        return false;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.556 -0500", hash_original_method = "F8DF5811CFC2B33C1997BC6906E28600", hash_generated_method = "16602D19C7704B69970676F8A06EF9AB")
    
@Override
    public Document newDocument() {
        return dom.createDocument(null, null, null);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.560 -0500", hash_original_method = "3B90C04D8401BDC844BD72B6E8D6BA23", hash_generated_method = "F316879D365ECE09EF888752D05DFA3F")
    
@Override
    public Document parse(InputSource source) throws SAXException, IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }

        String namespaceURI = null;
        String qualifiedName = null;
        DocumentType doctype = null;
        String inputEncoding = source.getEncoding();
        String systemId = source.getSystemId();
        DocumentImpl document = new DocumentImpl(
                dom, namespaceURI, qualifiedName, doctype, inputEncoding);
        document.setDocumentURI(systemId);

        KXmlParser parser = new KXmlParser();
        try {
            parser.keepNamespaceAttributes();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, namespaceAware);

            if (source.getByteStream() != null) {
                parser.setInput(source.getByteStream(), inputEncoding);
            } else if (source.getCharacterStream() != null) {
                parser.setInput(source.getCharacterStream());
            } else if (systemId != null) {
                URL url = new URL(systemId);
                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();
                // TODO: if null, extract the inputEncoding from the Content-Type header?
                parser.setInput(urlConnection.getInputStream(), inputEncoding);
            } else {
                throw new SAXParseException("InputSource needs a stream, reader or URI", null);
            }

            if (parser.nextToken() == XmlPullParser.END_DOCUMENT) {
                throw new SAXParseException("Unexpected end of document", null);
            }

            parse(parser, document, document, XmlPullParser.END_DOCUMENT);

            parser.require(XmlPullParser.END_DOCUMENT, null, null);
        } catch (XmlPullParserException ex) {
            if (ex.getDetail() instanceof IOException) {
                throw (IOException) ex.getDetail();
            }
            if (ex.getDetail() instanceof RuntimeException) {
                throw (RuntimeException) ex.getDetail();
            }

            LocatorImpl locator = new LocatorImpl();

            locator.setPublicId(source.getPublicId());
            locator.setSystemId(systemId);
            locator.setLineNumber(ex.getLineNumber());
            locator.setColumnNumber(ex.getColumnNumber());

            SAXParseException newEx = new SAXParseException(ex.getMessage(), locator);

            if (errorHandler != null) {
                errorHandler.error(newEx);
            }

            throw newEx;
        } finally {
            IoUtils.closeQuietly(parser);
        }

        return document;
    }

    /**
     * Implements the whole parsing of the XML document. The XML pull parser is
     * actually more of a tokenizer, and we are doing a classical recursive
     * descent parsing (the method invokes itself for XML elements). Our
     * approach to parsing does accept some illegal documents (more than one
     * root element, for example). The assumption is that the DOM implementation
     * throws the proper exceptions in these cases.
     *
     * @param parser The XML pull parser we're reading from.
     * @param document The document we're building.
     * @param node The node we're currently on (initially the document itself).
     * @param endToken The token that will end this recursive call. Either
     *        XmlPullParser.END_DOCUMENT or XmlPullParser.END_TAG.
     *
     * @throws XmlPullParserException If a parsing error occurs.
     * @throws IOException If a general IO error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.565 -0500", hash_original_method = "608502985E1CF48EAA100E44A7EF5256", hash_generated_method = "284C2C48A2187BEAE0F200C9428307C6")
    
private void parse(KXmlParser parser, DocumentImpl document, Node node,
            int endToken) throws XmlPullParserException, IOException {

        int token = parser.getEventType();

        /*
         * The main parsing loop. The precondition is that we are already on the
         * token to be processed. This holds for each iteration of the loop, so
         * the inner statements have to ensure that (in particular the recursive
         * call).
         */
        while (token != endToken && token != XmlPullParser.END_DOCUMENT) {
            if (token == XmlPullParser.PROCESSING_INSTRUCTION) {
                /*
                 * Found a processing instructions. We need to split the token
                 * text at the first whitespace character.
                 */
                String text = parser.getText();

                int dot = text.indexOf(' ');

                String target = (dot != -1 ? text.substring(0, dot) : text);
                String data = (dot != -1 ? text.substring(dot + 1) : "");

                node.appendChild(document.createProcessingInstruction(target,
                        data));
            } else if (token == XmlPullParser.DOCDECL) {
                String name = parser.getRootElementName();
                String publicId = parser.getPublicId();
                String systemId = parser.getSystemId();
                document.appendChild(new DocumentTypeImpl(document, name, publicId, systemId));

            } else if (token == XmlPullParser.COMMENT) {
                /*
                 * Found a comment. We simply take the token text, but we only
                 * create a node if the client wants to see comments at all.
                 */
                if (!ignoreComments) {
                    node.appendChild(document.createComment(parser.getText()));
                }
            } else if (token == XmlPullParser.IGNORABLE_WHITESPACE) {
                /*
                 * Found some ignorable whitespace. We only add it if the client
                 * wants to see whitespace. Whitespace before and after the
                 * document element is always ignored.
                 */
                if (!ignoreElementContentWhitespace && document != node) {
                    appendText(document, node, token, parser.getText());
                }
            } else if (token == XmlPullParser.TEXT || token == XmlPullParser.CDSECT) {
                /*
                 * Found a piece of text (possibly encoded as a CDATA section).
                 * That's the easiest case. We simply take it and create a new text node,
                 * or merge with an adjacent text node.
                 */
                appendText(document, node, token, parser.getText());
            } else if (token == XmlPullParser.ENTITY_REF) {
                /*
                 * Found an entity reference. If an entity resolver is
                 * installed, we replace it by text (if possible). Otherwise we
                 * add an entity reference node.
                 */
                String entity = parser.getName();

                if (entityResolver != null) {
                    // TODO Implement this...
                }

                String resolved = resolvePredefinedOrCharacterEntity(entity);
                if (resolved != null) {
                    appendText(document, node, token, resolved);
                } else {
                    node.appendChild(document.createEntityReference(entity));
                }
            } else if (token == XmlPullParser.START_TAG) {
                /*
                 * Found an element start tag. We create an element node with
                 * the proper info and attributes. We then invoke parse()
                 * recursively to handle the next level of nesting. When we
                 * return from this call, we check that we are on the proper
                 * element end tag. The whole handling differs somewhat
                 * depending on whether the parser is namespace-aware or not.
                 */
                if (namespaceAware) {
                    // Collect info for element node
                    String namespace = parser.getNamespace();
                    String name = parser.getName();
                    String prefix = parser.getPrefix();

                    if ("".equals(namespace)) {
                        namespace = null;
                    }

                    // Create element node and wire it correctly
                    Element element = document.createElementNS(namespace, name);
                    element.setPrefix(prefix);
                    node.appendChild(element);

                    for (int i = 0; i < parser.getAttributeCount(); i++) {
                        // Collect info for a single attribute node
                        String attrNamespace = parser.getAttributeNamespace(i);
                        String attrPrefix = parser.getAttributePrefix(i);
                        String attrName = parser.getAttributeName(i);
                        String attrValue = parser.getAttributeValue(i);

                        if ("".equals(attrNamespace)) {
                            attrNamespace = null;
                        }

                        // Create attribute node and wire it correctly
                        Attr attr = document.createAttributeNS(attrNamespace, attrName);
                        attr.setPrefix(attrPrefix);
                        attr.setValue(attrValue);
                        element.setAttributeNodeNS(attr);
                    }

                    // Recursive descent
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);

                    // Expect the element's end tag here
                    parser.require(XmlPullParser.END_TAG, namespace, name);

                } else {
                    // Collect info for element node
                    String name = parser.getName();

                    // Create element node and wire it correctly
                    Element element = document.createElement(name);
                    node.appendChild(element);

                    for (int i = 0; i < parser.getAttributeCount(); i++) {
                        // Collect info for a single attribute node
                        String attrName = parser.getAttributeName(i);
                        String attrValue = parser.getAttributeValue(i);

                        // Create attribute node and wire it correctly
                        Attr attr = document.createAttribute(attrName);
                        attr.setValue(attrValue);
                        element.setAttributeNode(attr);
                    }

                    // Recursive descent
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);

                    // Expect the element's end tag here
                    parser.require(XmlPullParser.END_TAG, "", name);
                }
            }

            token = parser.nextToken();
        }
    }

    /**
     * @param token the XML pull parser token type, such as XmlPullParser.CDSECT
     *      or XmlPullParser.ENTITY_REF.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.568 -0500", hash_original_method = "691ECF0A6ABC696CF83421ACD1A425FF", hash_generated_method = "DE036DF73644CE95D47CC7DD2A73D8B6")
    
private void appendText(DocumentImpl document, Node parent, int token, String text) {
        // Ignore empty runs.
        if (text.isEmpty()) {
            return;
        }
        // Merge with any previous text node if possible.
        if (coalescing || token != XmlPullParser.CDSECT) {
            Node lastChild = parent.getLastChild();
            if (lastChild != null && lastChild.getNodeType() == Node.TEXT_NODE) {
                Text textNode = (Text) lastChild;
                textNode.appendData(text);
                return;
            }
        }
        // Okay, we really do need a new text node
        parent.appendChild(token == XmlPullParser.CDSECT
                ? new CDATASectionImpl(document, text)
                : new TextImpl(document, text));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.570 -0500", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "84212E9A55845D30CADEA0CB7746633B")
    
@Override
    public void setEntityResolver(EntityResolver resolver) {
        entityResolver = resolver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.572 -0500", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "B6E87A5B83E46356A6779E6312686FC4")
    
@Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandler = handler;
    }

    /**
     * Controls whether this DocumentBuilder ignores comments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.574 -0500", hash_original_method = "1DD135B57BB0EB96EC13DA0D7BA611DF", hash_generated_method = "E43E148BF4CD6297A3B3D3D27DB0BBCE")
    
public void setIgnoreComments(boolean value) {
        ignoreComments = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.576 -0500", hash_original_method = "2E9B1D166C3D3A81908F8020FAC250A6", hash_generated_method = "73B6BAA6D0266D857916C488CBE0249B")
    
public void setCoalescing(boolean value) {
        coalescing = value;
    }

    /**
     * Controls whether this DocumentBuilder ignores element content whitespace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.578 -0500", hash_original_method = "9500E8ECEFA6BF93266530CE7C837D66", hash_generated_method = "4391D19726159E1C4473EAFB52587BE4")
    
public void setIgnoreElementContentWhitespace(boolean value) {
        ignoreElementContentWhitespace = value;
    }

    /**
     * Controls whether this DocumentBuilder is namespace-aware.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.581 -0500", hash_original_method = "16455E0CEE4216C1E1A45B9ED8EFF729", hash_generated_method = "CF4639D8C4B4515B879812D099FC0798")
    
public void setNamespaceAware(boolean value) {
        namespaceAware = value;
    }

    /**
     * Returns the replacement text or null if {@code entity} isn't predefined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.583 -0500", hash_original_method = "73F7C79343F86EF391295D82FA5B5401", hash_generated_method = "09AE160C200BD1185C0583064FD3ED4F")
    
private String resolvePredefinedOrCharacterEntity(String entityName) {
        // Character references, section 4.1 of the XML specification.
        if (entityName.startsWith("#x")) {
            return resolveCharacterReference(entityName.substring(2), 16);
        } else if (entityName.startsWith("#")) {
            return resolveCharacterReference(entityName.substring(1), 10);
        }
        // Predefined entities, section 4.6 of the XML specification.
        if ("lt".equals(entityName)) {
            return "<";
        } else if ("gt".equals(entityName)) {
            return ">";
        } else if ("amp".equals(entityName)) {
            return "&";
        } else if ("apos".equals(entityName)) {
            return "'";
        } else if ("quot".equals(entityName)) {
            return "\"";
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.586 -0500", hash_original_method = "F0F9BC1451B812F6B38C0D286F9C9978", hash_generated_method = "1A2235C363C3AC8E9929364D0B219835")
    
private String resolveCharacterReference(String value, int base) {
        try {
            int ch = Integer.parseInt(value, base);
            if (ch < 0 || ch > Character.MAX_VALUE) {
                return null;
            }
            return String.valueOf((char) ch);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}

