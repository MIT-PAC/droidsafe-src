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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.106 -0400", hash_original_field = "B795440B9ADE4378FEF3486B241378BC", hash_generated_field = "4A9121F2D482493F3BEB1C30E72C76AA")

    private boolean coalescing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.106 -0400", hash_original_field = "EABB965CB8BE873142A4DA0189C06FD8", hash_generated_field = "923D10729FC72A63D7530A13EDC17701")

    private EntityResolver entityResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.106 -0400", hash_original_field = "F56352FA359A5F4533A25E5F29D527F4", hash_generated_field = "754BD707F8949F8FC6D5E6C0F6EACB6F")

    private ErrorHandler errorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.106 -0400", hash_original_field = "805C7D6D9D5924ED581B31411F041DA0", hash_generated_field = "833EEF27C45F7AD04FCDBA4B464FF80B")

    private boolean ignoreComments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.106 -0400", hash_original_field = "E7B529A53B13854C58873F69431FFFE7", hash_generated_field = "936EEB5781DB0070979C36A276CB0F01")

    private boolean ignoreElementContentWhitespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.106 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "9718A1E7D4348F4ADD16E4057036B4E2")

    private boolean namespaceAware;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.106 -0400", hash_original_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58", hash_generated_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58")
    public DocumentBuilderImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.118 -0400", hash_original_method = "EFC1F1695F664AAB80C061E3A6039A89", hash_generated_method = "2B12757C3AD4171FDB951A90F0F6F6B8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.119 -0400", hash_original_method = "18E3291D22CB922EEB4EFC42536C583A", hash_generated_method = "613F5B6FCB906D32FD5C2795B868CB4E")
    @Override
    public DOMImplementation getDOMImplementation() {
        DOMImplementation varB4EAC82CA7396A68D541C85D26508E83_1301921982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1301921982 = dom;
        varB4EAC82CA7396A68D541C85D26508E83_1301921982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1301921982;
        // ---------- Original Method ----------
        //return dom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.119 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "6976657B3128E688420EAF75050DABA1")
    @Override
    public boolean isNamespaceAware() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94514417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94514417;
        // ---------- Original Method ----------
        //return namespaceAware;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.120 -0400", hash_original_method = "BC62268279A4D4DB4B44A495D4290EBF", hash_generated_method = "3DC7D55A3A7501E7A10F1B867B9BC193")
    @Override
    public boolean isValidating() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085289838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085289838;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.121 -0400", hash_original_method = "F8DF5811CFC2B33C1997BC6906E28600", hash_generated_method = "CE28FA4F8EDB799CC0F989965C754E7F")
    @Override
    public Document newDocument() {
        Document varB4EAC82CA7396A68D541C85D26508E83_104007001 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_104007001 = dom.createDocument(null, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_104007001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104007001;
        // ---------- Original Method ----------
        //return dom.createDocument(null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.131 -0400", hash_original_method = "3B90C04D8401BDC844BD72B6E8D6BA23", hash_generated_method = "8A6B4DBEBBACD40F90930A7C33788A56")
    @Override
    public Document parse(InputSource source) throws SAXException, IOException {
        Document varB4EAC82CA7396A68D541C85D26508E83_1125866076 = null; //Variable for return #1
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
                boolean var45B9619077E7C327BDD82162D674A755_225925564 = (source.getByteStream() != null);
                {
                    parser.setInput(source.getByteStream(), inputEncoding);
                } //End block
                {
                    boolean var7AB697A79B7393D5EF9E6AEAFD85169F_955842355 = (source.getCharacterStream() != null);
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
                boolean varEAD05A11C770B3EFF79E03A034089BCF_1402702798 = (parser.nextToken() == XmlPullParser.END_DOCUMENT);
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
                boolean var24F2D0F8A01780561886272373FD6823_1120614044 = (ex.getDetail() instanceof IOException);
                {
                    if (DroidSafeAndroidRuntime.control) throw (IOException) ex.getDetail();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD30FE066CB866F151572500F478C75EB_997269551 = (ex.getDetail() instanceof RuntimeException);
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
        varB4EAC82CA7396A68D541C85D26508E83_1125866076 = document;
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1125866076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1125866076;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.145 -0400", hash_original_method = "608502985E1CF48EAA100E44A7EF5256", hash_generated_method = "29D513D624D6A4C33AA4C40D060E107D")
    private void parse(KXmlParser parser, DocumentImpl document, Node node,
            int endToken) throws XmlPullParserException, IOException {
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
                        boolean var78669934DC257E1D2EC9215AF2E9B8C1_1832543057 = ("".equals(namespace));
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
                        boolean varD7EE2FA98AE285133A4732F15E348264_1294110009 = (i < parser.getAttributeCount());
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
                                boolean var6F39FB2995FC1D7A728146662B623363_1773317616 = ("".equals(attrNamespace));
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
                        boolean varD7EE2FA98AE285133A4732F15E348264_1527556823 = (i < parser.getAttributeCount());
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
        addTaint(parser.getTaint());
        addTaint(document.getTaint());
        addTaint(node.getTaint());
        addTaint(endToken);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.152 -0400", hash_original_method = "691ECF0A6ABC696CF83421ACD1A425FF", hash_generated_method = "AD547311CF3BA755E7D04F84F8782280")
    private void appendText(DocumentImpl document, Node parent, int token, String text) {
        {
            boolean var5B0A39854B01FA4376A4EFDC172E49AE_140439116 = (text.isEmpty());
        } //End collapsed parenthetic
        {
            Node lastChild;
            lastChild = parent.getLastChild();
            {
                boolean varB47EFE5E900B55C0BF9ECD8829BEDEDD_1066202134 = (lastChild != null && lastChild.getNodeType() == Node.TEXT_NODE);
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
        addTaint(document.getTaint());
        addTaint(parent.getTaint());
        addTaint(token);
        addTaint(text.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.152 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "F6C937BA9FB5D557A5996E2A79EB5DEF")
    @Override
    public void setEntityResolver(EntityResolver resolver) {
        entityResolver = resolver;
        // ---------- Original Method ----------
        //entityResolver = resolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.156 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "11AEE823D94AC8C9400608C1180478AB")
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandler = handler;
        // ---------- Original Method ----------
        //errorHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.157 -0400", hash_original_method = "1DD135B57BB0EB96EC13DA0D7BA611DF", hash_generated_method = "05B80D9CDF2B77D1BB0F88AEFBE01DEB")
    public void setIgnoreComments(boolean value) {
        ignoreComments = value;
        // ---------- Original Method ----------
        //ignoreComments = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.161 -0400", hash_original_method = "2E9B1D166C3D3A81908F8020FAC250A6", hash_generated_method = "A6D6A159EF8C25563FDBAB7ED388A0B6")
    public void setCoalescing(boolean value) {
        coalescing = value;
        // ---------- Original Method ----------
        //coalescing = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.163 -0400", hash_original_method = "9500E8ECEFA6BF93266530CE7C837D66", hash_generated_method = "20E4D2800982DC5C649D9C7E0B8BCEB7")
    public void setIgnoreElementContentWhitespace(boolean value) {
        ignoreElementContentWhitespace = value;
        // ---------- Original Method ----------
        //ignoreElementContentWhitespace = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.163 -0400", hash_original_method = "16455E0CEE4216C1E1A45B9ED8EFF729", hash_generated_method = "51CE5D3FAA2FC8C2C7E38867B04EB554")
    public void setNamespaceAware(boolean value) {
        namespaceAware = value;
        // ---------- Original Method ----------
        //namespaceAware = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.168 -0400", hash_original_method = "73F7C79343F86EF391295D82FA5B5401", hash_generated_method = "1B9CBE2EA7F854623304E01B864DEBDF")
    private String resolvePredefinedOrCharacterEntity(String entityName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1212245945 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1443442885 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_761509634 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_491884616 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_155480349 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_1885683982 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_2145616440 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_118566679 = null; //Variable for return #8
        {
            boolean var5E9541BCC7A289362EE4C3AE04E2B345_510155546 = (entityName.startsWith("#x"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1212245945 = resolveCharacterReference(entityName.substring(2), 16);
            } //End block
            {
                boolean var3B1D1470C1227B32126068B7381617C2_533779023 = (entityName.startsWith("#"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1443442885 = resolveCharacterReference(entityName.substring(1), 10);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var035E02B36B37C7465FCB51F3669FE998_20933758 = ("lt".equals(entityName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_761509634 = "<";
            } //End block
            {
                boolean varC654BFE8E8A7FDDD1701D244905C1F59_1751529524 = ("gt".equals(entityName));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_491884616 = ">";
                } //End block
                {
                    boolean var99FC03628CEC89ABFD06DBC54D1F84AD_397948834 = ("amp".equals(entityName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_155480349 = "&";
                    } //End block
                    {
                        boolean var89BC7D2645BF887F17E0544529CA9CBC_80933945 = ("apos".equals(entityName));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1885683982 = "'";
                        } //End block
                        {
                            boolean varB01636C20C19F22F40F678A48E58C05A_162291074 = ("quot".equals(entityName));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_2145616440 = "\"";
                            } //End block
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_118566679 = null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(entityName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1255765819; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_1212245945;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_1443442885;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_761509634;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_491884616;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_155480349;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_1885683982;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_2145616440;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1255765819 = varB4EAC82CA7396A68D541C85D26508E83_118566679;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1255765819.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1255765819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.170 -0400", hash_original_method = "F0F9BC1451B812F6B38C0D286F9C9978", hash_generated_method = "FCB1964A88B790AA33452C1EA7ACDB53")
    private String resolveCharacterReference(String value, int base) {
        String varB4EAC82CA7396A68D541C85D26508E83_216426113 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_635121755 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1185725358 = null; //Variable for return #3
        try 
        {
            int ch;
            ch = Integer.parseInt(value, base);
            {
                varB4EAC82CA7396A68D541C85D26508E83_216426113 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_635121755 = String.valueOf((char) ch);
        } //End block
        catch (NumberFormatException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1185725358 = null;
        } //End block
        addTaint(value.getTaint());
        addTaint(base);
        String varA7E53CE21691AB073D9660D615818899_209695567; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_209695567 = varB4EAC82CA7396A68D541C85D26508E83_216426113;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_209695567 = varB4EAC82CA7396A68D541C85D26508E83_635121755;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_209695567 = varB4EAC82CA7396A68D541C85D26508E83_1185725358;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_209695567.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_209695567;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.170 -0400", hash_original_field = "553C5188DE8D4AA3A6B8001F5E5B85C6", hash_generated_field = "512771BF3B10ACB6843471120D35250C")

    private static DOMImplementationImpl dom = DOMImplementationImpl.getInstance();
}

