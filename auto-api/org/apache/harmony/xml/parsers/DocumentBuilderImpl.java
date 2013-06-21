package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private boolean coalescing;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private boolean ignoreComments;
    private boolean ignoreElementContentWhitespace;
    private boolean namespaceAware;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.477 -0400", hash_original_method = "17E6B1DC9AD2D8F6C253B783E503961C", hash_generated_method = "17E6B1DC9AD2D8F6C253B783E503961C")
        public DocumentBuilderImpl ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.477 -0400", hash_original_method = "EFC1F1695F664AAB80C061E3A6039A89", hash_generated_method = "2B12757C3AD4171FDB951A90F0F6F6B8")
    @DSModeled(DSC.SAFE)
    @Override
    public void reset() {
        coalescing = false;
        entityResolver = null;
        errorHandler = null;
        ignoreComments = false;
        ignoreElementContentWhitespace = false;
        namespaceAware = false;
        // ---------- Original Method ----------
        //coalescing = false;
        //entityResolver = null;
        //errorHandler = null;
        //ignoreComments = false;
        //ignoreElementContentWhitespace = false;
        //namespaceAware = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.478 -0400", hash_original_method = "18E3291D22CB922EEB4EFC42536C583A", hash_generated_method = "CD0A24CC686889042399E18A3BA5A611")
    @DSModeled(DSC.SAFE)
    @Override
    public DOMImplementation getDOMImplementation() {
        return (DOMImplementation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.478 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "A4DA791732C893AAC8070A975E6C8CED")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isNamespaceAware() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return namespaceAware;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.478 -0400", hash_original_method = "BC62268279A4D4DB4B44A495D4290EBF", hash_generated_method = "50060E7199009E0C3303E80C57469355")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isValidating() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.478 -0400", hash_original_method = "F8DF5811CFC2B33C1997BC6906E28600", hash_generated_method = "CB1067B2421BAF040A0F204B5678CB33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Document newDocument() {
        Document var77905B5BD5420528B90D3A48AFA5178A_749259331 = (dom.createDocument(null, null, null));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dom.createDocument(null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.479 -0400", hash_original_method = "3B90C04D8401BDC844BD72B6E8D6BA23", hash_generated_method = "4ECEAF2C0E7D9D2B399D50E207CD566B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Document parse(InputSource source) throws SAXException, IOException {
        dsTaint.addTaint(source.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("source == null");
        } //End block
        String namespaceURI;
        namespaceURI = null;
        String qualifiedName;
        qualifiedName = null;
        DocumentType doctype;
        doctype = null;
        String inputEncoding;
        inputEncoding = source.getEncoding();
        String systemId;
        systemId = source.getSystemId();
        DocumentImpl document;
        document = new DocumentImpl(
                dom, namespaceURI, qualifiedName, doctype, inputEncoding);
        document.setDocumentURI(systemId);
        KXmlParser parser;
        parser = new KXmlParser();
        try 
        {
            parser.keepNamespaceAttributes();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, namespaceAware);
            {
                boolean var45B9619077E7C327BDD82162D674A755_2127255161 = (source.getByteStream() != null);
                {
                    parser.setInput(source.getByteStream(), inputEncoding);
                } //End block
                {
                    boolean var7AB697A79B7393D5EF9E6AEAFD85169F_1908221795 = (source.getCharacterStream() != null);
                    {
                        parser.setInput(source.getCharacterStream());
                    } //End block
                    {
                        URL url;
                        url = new URL(systemId);
                        URLConnection urlConnection;
                        urlConnection = url.openConnection();
                        urlConnection.connect();
                        parser.setInput(urlConnection.getInputStream(), inputEncoding);
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SAXParseException("InputSource needs a stream, reader or URI", null);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean varEAD05A11C770B3EFF79E03A034089BCF_1602795488 = (parser.nextToken() == XmlPullParser.END_DOCUMENT);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXParseException("Unexpected end of document", null);
                } //End block
            } //End collapsed parenthetic
            parse(parser, document, document, XmlPullParser.END_DOCUMENT);
            parser.require(XmlPullParser.END_DOCUMENT, null, null);
        } //End block
        catch (XmlPullParserException ex)
        {
            {
                boolean var24F2D0F8A01780561886272373FD6823_1024971950 = (ex.getDetail() instanceof IOException);
                {
                    if (DroidSafeAndroidRuntime.control) throw (IOException) ex.getDetail();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD30FE066CB866F151572500F478C75EB_329778465 = (ex.getDetail() instanceof RuntimeException);
                {
                    if (DroidSafeAndroidRuntime.control) throw (RuntimeException) ex.getDetail();
                } //End block
            } //End collapsed parenthetic
            LocatorImpl locator;
            locator = new LocatorImpl();
            locator.setPublicId(source.getPublicId());
            locator.setSystemId(systemId);
            locator.setLineNumber(ex.getLineNumber());
            locator.setColumnNumber(ex.getColumnNumber());
            SAXParseException newEx;
            newEx = new SAXParseException(ex.getMessage(), locator);
            {
                errorHandler.error(newEx);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw newEx;
        } //End block
        finally 
        {
            IoUtils.closeQuietly(parser);
        } //End block
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.481 -0400", hash_original_method = "608502985E1CF48EAA100E44A7EF5256", hash_generated_method = "48502287EA1657C1C92FA833BE437603")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parse(KXmlParser parser, DocumentImpl document, Node node,
            int endToken) throws XmlPullParserException, IOException {
        dsTaint.addTaint(node.dsTaint);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(endToken);
        dsTaint.addTaint(parser.dsTaint);
        int token;
        token = parser.getEventType();
        {
            {
                String text;
                text = parser.getText();
                int dot;
                dot = text.indexOf(' ');
                String target;
                target = (dot != -1 ? text.substring(0, dot) : text);//DSFIXME:  CODE0008: Nested ternary operator in expression
                String data;
                data = (dot != -1 ? text.substring(dot + 1) : "");//DSFIXME:  CODE0008: Nested ternary operator in expression
                node.appendChild(document.createProcessingInstruction(target,
                        data));
            } //End block
            {
                String name;
                name = parser.getRootElementName();
                String publicId;
                publicId = parser.getPublicId();
                String systemId;
                systemId = parser.getSystemId();
                document.appendChild(new DocumentTypeImpl(document, name, publicId, systemId));
            } //End block
            {
                {
                    node.appendChild(document.createComment(parser.getText()));
                } //End block
            } //End block
            {
                {
                    appendText(document, node, token, parser.getText());
                } //End block
            } //End block
            {
                appendText(document, node, token, parser.getText());
            } //End block
            {
                String entity;
                entity = parser.getName();
                String resolved;
                resolved = resolvePredefinedOrCharacterEntity(entity);
                {
                    appendText(document, node, token, resolved);
                } //End block
                {
                    node.appendChild(document.createEntityReference(entity));
                } //End block
            } //End block
            {
                {
                    String namespace;
                    namespace = parser.getNamespace();
                    String name;
                    name = parser.getName();
                    String prefix;
                    prefix = parser.getPrefix();
                    {
                        boolean var78669934DC257E1D2EC9215AF2E9B8C1_752490795 = ("".equals(namespace));
                        {
                            namespace = null;
                        } //End block
                    } //End collapsed parenthetic
                    Element element;
                    element = document.createElementNS(namespace, name);
                    element.setPrefix(prefix);
                    node.appendChild(element);
                    {
                        int i;
                        i = 0;
                        boolean varD7EE2FA98AE285133A4732F15E348264_1818003500 = (i < parser.getAttributeCount());
                        {
                            String attrNamespace;
                            attrNamespace = parser.getAttributeNamespace(i);
                            String attrPrefix;
                            attrPrefix = parser.getAttributePrefix(i);
                            String attrName;
                            attrName = parser.getAttributeName(i);
                            String attrValue;
                            attrValue = parser.getAttributeValue(i);
                            {
                                boolean var6F39FB2995FC1D7A728146662B623363_56809851 = ("".equals(attrNamespace));
                                {
                                    attrNamespace = null;
                                } //End block
                            } //End collapsed parenthetic
                            Attr attr;
                            attr = document.createAttributeNS(attrNamespace, attrName);
                            attr.setPrefix(attrPrefix);
                            attr.setValue(attrValue);
                            element.setAttributeNodeNS(attr);
                        } //End block
                    } //End collapsed parenthetic
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);
                    parser.require(XmlPullParser.END_TAG, namespace, name);
                } //End block
                {
                    String name;
                    name = parser.getName();
                    Element element;
                    element = document.createElement(name);
                    node.appendChild(element);
                    {
                        int i;
                        i = 0;
                        boolean varD7EE2FA98AE285133A4732F15E348264_472385932 = (i < parser.getAttributeCount());
                        {
                            String attrName;
                            attrName = parser.getAttributeName(i);
                            String attrValue;
                            attrValue = parser.getAttributeValue(i);
                            Attr attr;
                            attr = document.createAttribute(attrName);
                            attr.setValue(attrValue);
                            element.setAttributeNode(attr);
                        } //End block
                    } //End collapsed parenthetic
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);
                    parser.require(XmlPullParser.END_TAG, "", name);
                } //End block
            } //End block
            token = parser.nextToken();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.482 -0400", hash_original_method = "691ECF0A6ABC696CF83421ACD1A425FF", hash_generated_method = "91E47AABB67B9BA9F9A10BE41A45741E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendText(DocumentImpl document, Node parent, int token, String text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(token);
        dsTaint.addTaint(parent.dsTaint);
        {
            boolean var5B0A39854B01FA4376A4EFDC172E49AE_1213702510 = (text.isEmpty());
        } //End collapsed parenthetic
        {
            Node lastChild;
            lastChild = parent.getLastChild();
            {
                boolean varB47EFE5E900B55C0BF9ECD8829BEDEDD_34202791 = (lastChild != null && lastChild.getNodeType() == Node.TEXT_NODE);
                {
                    Text textNode;
                    textNode = (Text) lastChild;
                    textNode.appendData(text);
                } //End block
            } //End collapsed parenthetic
        } //End block
        parent.appendChild(token == XmlPullParser.CDSECT
                ? new CDATASectionImpl(document, text)
                : new TextImpl(document, text));
        // ---------- Original Method ----------
        //if (text.isEmpty()) {
            //return;
        //}
        //if (coalescing || token != XmlPullParser.CDSECT) {
            //Node lastChild = parent.getLastChild();
            //if (lastChild != null && lastChild.getNodeType() == Node.TEXT_NODE) {
                //Text textNode = (Text) lastChild;
                //textNode.appendData(text);
                //return;
            //}
        //}
        //parent.appendChild(token == XmlPullParser.CDSECT
                //? new CDATASectionImpl(document, text)
                //: new TextImpl(document, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.482 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "BCACA17BEBBF74C24133CBB067C1AE04")
    @DSModeled(DSC.SAFE)
    @Override
    public void setEntityResolver(EntityResolver resolver) {
        dsTaint.addTaint(resolver.dsTaint);
        // ---------- Original Method ----------
        //entityResolver = resolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.482 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "AA2CCBF58B23F5579C033E8EBCA6C7AB")
    @DSModeled(DSC.SAFE)
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //errorHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.482 -0400", hash_original_method = "1DD135B57BB0EB96EC13DA0D7BA611DF", hash_generated_method = "D3B3AD153AAE21320AABDFEF4667BE60")
    @DSModeled(DSC.SAFE)
    public void setIgnoreComments(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //ignoreComments = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.483 -0400", hash_original_method = "2E9B1D166C3D3A81908F8020FAC250A6", hash_generated_method = "A4917278F4E492B9428C82D35FABB693")
    @DSModeled(DSC.SAFE)
    public void setCoalescing(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //coalescing = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.483 -0400", hash_original_method = "9500E8ECEFA6BF93266530CE7C837D66", hash_generated_method = "E895C6BCF1FA205F1E17CD5EA6501441")
    @DSModeled(DSC.SAFE)
    public void setIgnoreElementContentWhitespace(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //ignoreElementContentWhitespace = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.483 -0400", hash_original_method = "16455E0CEE4216C1E1A45B9ED8EFF729", hash_generated_method = "771CAB15F3B8588C91EFD90B9F9BD6DE")
    @DSModeled(DSC.SAFE)
    public void setNamespaceAware(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //namespaceAware = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.484 -0400", hash_original_method = "73F7C79343F86EF391295D82FA5B5401", hash_generated_method = "BC104FC8A9872D8E13C1F131559C0556")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String resolvePredefinedOrCharacterEntity(String entityName) {
        dsTaint.addTaint(entityName);
        {
            boolean var5E9541BCC7A289362EE4C3AE04E2B345_281081967 = (entityName.startsWith("#x"));
            {
                String varEEE0FB95C92FC1005A8970425272EACB_868688522 = (resolveCharacterReference(entityName.substring(2), 16));
            } //End block
            {
                boolean var3B1D1470C1227B32126068B7381617C2_1963083490 = (entityName.startsWith("#"));
                {
                    String var32AF8DBFC2A0C25F69878E57476870EF_425513230 = (resolveCharacterReference(entityName.substring(1), 10));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var035E02B36B37C7465FCB51F3669FE998_2046719857 = ("lt".equals(entityName));
            {
                boolean varC654BFE8E8A7FDDD1701D244905C1F59_448575928 = ("gt".equals(entityName));
                {
                    boolean var99FC03628CEC89ABFD06DBC54D1F84AD_1335302603 = ("amp".equals(entityName));
                    {
                        boolean var89BC7D2645BF887F17E0544529CA9CBC_1221902522 = ("apos".equals(entityName));
                        {
                            boolean varB01636C20C19F22F40F678A48E58C05A_1415125573 = ("quot".equals(entityName));
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (entityName.startsWith("#x")) {
            //return resolveCharacterReference(entityName.substring(2), 16);
        //} else if (entityName.startsWith("#")) {
            //return resolveCharacterReference(entityName.substring(1), 10);
        //}
        //if ("lt".equals(entityName)) {
            //return "<";
        //} else if ("gt".equals(entityName)) {
            //return ">";
        //} else if ("amp".equals(entityName)) {
            //return "&";
        //} else if ("apos".equals(entityName)) {
            //return "'";
        //} else if ("quot".equals(entityName)) {
            //return "\"";
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.484 -0400", hash_original_method = "F0F9BC1451B812F6B38C0D286F9C9978", hash_generated_method = "58187BD68CE380ECE53BE67F1AE10DB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String resolveCharacterReference(String value, int base) {
        dsTaint.addTaint(base);
        dsTaint.addTaint(value);
        try 
        {
            int ch;
            ch = Integer.parseInt(value, base);
            String var90D2E5873364E57A13927CFE0C904D85_2109782530 = (String.valueOf((char) ch));
        } //End block
        catch (NumberFormatException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //int ch = Integer.parseInt(value, base);
            //if (ch < 0 || ch > Character.MAX_VALUE) {
                //return null;
            //}
            //return String.valueOf((char) ch);
        //} catch (NumberFormatException ex) {
            //return null;
        //}
    }

    
    private static DOMImplementationImpl dom = DOMImplementationImpl.getInstance();
}

