package org.apache.harmony.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.500 -0400", hash_original_field = "B795440B9ADE4378FEF3486B241378BC", hash_generated_field = "4A9121F2D482493F3BEB1C30E72C76AA")

    private boolean coalescing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.500 -0400", hash_original_field = "EABB965CB8BE873142A4DA0189C06FD8", hash_generated_field = "923D10729FC72A63D7530A13EDC17701")

    private EntityResolver entityResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.500 -0400", hash_original_field = "F56352FA359A5F4533A25E5F29D527F4", hash_generated_field = "754BD707F8949F8FC6D5E6C0F6EACB6F")

    private ErrorHandler errorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.500 -0400", hash_original_field = "805C7D6D9D5924ED581B31411F041DA0", hash_generated_field = "833EEF27C45F7AD04FCDBA4B464FF80B")

    private boolean ignoreComments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.500 -0400", hash_original_field = "E7B529A53B13854C58873F69431FFFE7", hash_generated_field = "936EEB5781DB0070979C36A276CB0F01")

    private boolean ignoreElementContentWhitespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.500 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "9718A1E7D4348F4ADD16E4057036B4E2")

    private boolean namespaceAware;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.500 -0400", hash_original_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58", hash_generated_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58")
    public DocumentBuilderImpl ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.501 -0400", hash_original_method = "EFC1F1695F664AAB80C061E3A6039A89", hash_generated_method = "2B12757C3AD4171FDB951A90F0F6F6B8")
    @Override
    public void reset() {
        coalescing = false;
        entityResolver = null;
        errorHandler = null;
        ignoreComments = false;
        ignoreElementContentWhitespace = false;
        namespaceAware = false;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.502 -0400", hash_original_method = "18E3291D22CB922EEB4EFC42536C583A", hash_generated_method = "7F01A4E23115B63CA5EEFAC0FB3321FF")
    @Override
    public DOMImplementation getDOMImplementation() {
        DOMImplementation varB4EAC82CA7396A68D541C85D26508E83_898069866 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_898069866 = dom;
        varB4EAC82CA7396A68D541C85D26508E83_898069866.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_898069866;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.502 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "6BE237057BF653AAD05CA3EB0B2D6D46")
    @Override
    public boolean isNamespaceAware() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118423027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_118423027;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.502 -0400", hash_original_method = "BC62268279A4D4DB4B44A495D4290EBF", hash_generated_method = "8EDBB29E81FDCC0AC0895EE0524231B3")
    @Override
    public boolean isValidating() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644572574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_644572574;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.503 -0400", hash_original_method = "F8DF5811CFC2B33C1997BC6906E28600", hash_generated_method = "67109A0FD8CE9465AFD594E3709FBCDA")
    @Override
    public Document newDocument() {
        Document varB4EAC82CA7396A68D541C85D26508E83_1061310967 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1061310967 = dom.createDocument(null, null, null);
        varB4EAC82CA7396A68D541C85D26508E83_1061310967.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1061310967;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.504 -0400", hash_original_method = "3B90C04D8401BDC844BD72B6E8D6BA23", hash_generated_method = "6819F4CFD00191A96596B05595C09E19")
    @Override
    public Document parse(InputSource source) throws SAXException, IOException {
        Document varB4EAC82CA7396A68D541C85D26508E83_139995197 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("source == null");
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
        try 
        {
            parser.keepNamespaceAttributes();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, namespaceAware);
            {
                boolean var45B9619077E7C327BDD82162D674A755_1211996607 = (source.getByteStream() != null);
                {
                    parser.setInput(source.getByteStream(), inputEncoding);
                } 
                {
                    boolean var7AB697A79B7393D5EF9E6AEAFD85169F_145541501 = (source.getCharacterStream() != null);
                    {
                        parser.setInput(source.getCharacterStream());
                    } 
                    {
                        URL url = new URL(systemId);
                        URLConnection urlConnection = url.openConnection();
                        urlConnection.connect();
                        parser.setInput(urlConnection.getInputStream(), inputEncoding);
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SAXParseException("InputSource needs a stream, reader or URI", null);
                    } 
                } 
            } 
            {
                boolean varEAD05A11C770B3EFF79E03A034089BCF_1862310213 = (parser.nextToken() == XmlPullParser.END_DOCUMENT);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXParseException("Unexpected end of document", null);
                } 
            } 
            parse(parser, document, document, XmlPullParser.END_DOCUMENT);
            parser.require(XmlPullParser.END_DOCUMENT, null, null);
        } 
        catch (XmlPullParserException ex)
        {
            {
                boolean var24F2D0F8A01780561886272373FD6823_898635286 = (ex.getDetail() instanceof IOException);
                {
                    if (DroidSafeAndroidRuntime.control) throw (IOException) ex.getDetail();
                } 
            } 
            {
                boolean varD30FE066CB866F151572500F478C75EB_1772075914 = (ex.getDetail() instanceof RuntimeException);
                {
                    if (DroidSafeAndroidRuntime.control) throw (RuntimeException) ex.getDetail();
                } 
            } 
            LocatorImpl locator = new LocatorImpl();
            locator.setPublicId(source.getPublicId());
            locator.setSystemId(systemId);
            locator.setLineNumber(ex.getLineNumber());
            locator.setColumnNumber(ex.getColumnNumber());
            SAXParseException newEx = new SAXParseException(ex.getMessage(), locator);
            {
                errorHandler.error(newEx);
            } 
            if (DroidSafeAndroidRuntime.control) throw newEx;
        } 
        finally 
        {
            IoUtils.closeQuietly(parser);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_139995197 = document;
        addTaint(source.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_139995197.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_139995197;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.506 -0400", hash_original_method = "608502985E1CF48EAA100E44A7EF5256", hash_generated_method = "81EC189D76CC44E195066956CB2CA92A")
    private void parse(KXmlParser parser, DocumentImpl document, Node node,
            int endToken) throws XmlPullParserException, IOException {
        int token = parser.getEventType();
        {
            {
                String text = parser.getText();
                int dot = text.indexOf(' ');
                String target = (dot != -1 ? text.substring(0, dot) : text);
                String data = (dot != -1 ? text.substring(dot + 1) : "");
                node.appendChild(document.createProcessingInstruction(target,
                        data));
            } 
            {
                String name = parser.getRootElementName();
                String publicId = parser.getPublicId();
                String systemId = parser.getSystemId();
                document.appendChild(new DocumentTypeImpl(document, name, publicId, systemId));
            } 
            {
                {
                    node.appendChild(document.createComment(parser.getText()));
                } 
            } 
            {
                {
                    appendText(document, node, token, parser.getText());
                } 
            } 
            {
                appendText(document, node, token, parser.getText());
            } 
            {
                String entity = parser.getName();
                String resolved = resolvePredefinedOrCharacterEntity(entity);
                {
                    appendText(document, node, token, resolved);
                } 
                {
                    node.appendChild(document.createEntityReference(entity));
                } 
            } 
            {
                {
                    String namespace = parser.getNamespace();
                    String name = parser.getName();
                    String prefix = parser.getPrefix();
                    {
                        boolean var78669934DC257E1D2EC9215AF2E9B8C1_512354529 = ("".equals(namespace));
                        {
                            namespace = null;
                        } 
                    } 
                    Element element = document.createElementNS(namespace, name);
                    element.setPrefix(prefix);
                    node.appendChild(element);
                    {
                        int i = 0;
                        boolean varD7EE2FA98AE285133A4732F15E348264_409696222 = (i < parser.getAttributeCount());
                        {
                            String attrNamespace = parser.getAttributeNamespace(i);
                            String attrPrefix = parser.getAttributePrefix(i);
                            String attrName = parser.getAttributeName(i);
                            String attrValue = parser.getAttributeValue(i);
                            {
                                boolean var6F39FB2995FC1D7A728146662B623363_2029182226 = ("".equals(attrNamespace));
                                {
                                    attrNamespace = null;
                                } 
                            } 
                            Attr attr = document.createAttributeNS(attrNamespace, attrName);
                            attr.setPrefix(attrPrefix);
                            attr.setValue(attrValue);
                            element.setAttributeNodeNS(attr);
                        } 
                    } 
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);
                    parser.require(XmlPullParser.END_TAG, namespace, name);
                } 
                {
                    String name = parser.getName();
                    Element element = document.createElement(name);
                    node.appendChild(element);
                    {
                        int i = 0;
                        boolean varD7EE2FA98AE285133A4732F15E348264_883202214 = (i < parser.getAttributeCount());
                        {
                            String attrName = parser.getAttributeName(i);
                            String attrValue = parser.getAttributeValue(i);
                            Attr attr = document.createAttribute(attrName);
                            attr.setValue(attrValue);
                            element.setAttributeNode(attr);
                        } 
                    } 
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);
                    parser.require(XmlPullParser.END_TAG, "", name);
                } 
            } 
            token = parser.nextToken();
        } 
        addTaint(parser.getTaint());
        addTaint(document.getTaint());
        addTaint(node.getTaint());
        addTaint(endToken);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.507 -0400", hash_original_method = "691ECF0A6ABC696CF83421ACD1A425FF", hash_generated_method = "CDC9AF1436F0BED1DCC243F21FCEB4C3")
    private void appendText(DocumentImpl document, Node parent, int token, String text) {
        {
            boolean var5B0A39854B01FA4376A4EFDC172E49AE_810873703 = (text.isEmpty());
        } 
        {
            Node lastChild = parent.getLastChild();
            {
                boolean varB47EFE5E900B55C0BF9ECD8829BEDEDD_1614810107 = (lastChild != null && lastChild.getNodeType() == Node.TEXT_NODE);
                {
                    Text textNode = (Text) lastChild;
                    textNode.appendData(text);
                } 
            } 
        } 
        parent.appendChild(token == XmlPullParser.CDSECT
                ? new CDATASectionImpl(document, text)
                : new TextImpl(document, text));
        addTaint(document.getTaint());
        addTaint(parent.getTaint());
        addTaint(token);
        addTaint(text.getTaint());
        
        
            
        
        
            
            
                
                
                
            
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.508 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "F6C937BA9FB5D557A5996E2A79EB5DEF")
    @Override
    public void setEntityResolver(EntityResolver resolver) {
        entityResolver = resolver;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.508 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "11AEE823D94AC8C9400608C1180478AB")
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandler = handler;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.508 -0400", hash_original_method = "1DD135B57BB0EB96EC13DA0D7BA611DF", hash_generated_method = "05B80D9CDF2B77D1BB0F88AEFBE01DEB")
    public void setIgnoreComments(boolean value) {
        ignoreComments = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.508 -0400", hash_original_method = "2E9B1D166C3D3A81908F8020FAC250A6", hash_generated_method = "A6D6A159EF8C25563FDBAB7ED388A0B6")
    public void setCoalescing(boolean value) {
        coalescing = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.509 -0400", hash_original_method = "9500E8ECEFA6BF93266530CE7C837D66", hash_generated_method = "20E4D2800982DC5C649D9C7E0B8BCEB7")
    public void setIgnoreElementContentWhitespace(boolean value) {
        ignoreElementContentWhitespace = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.509 -0400", hash_original_method = "16455E0CEE4216C1E1A45B9ED8EFF729", hash_generated_method = "51CE5D3FAA2FC8C2C7E38867B04EB554")
    public void setNamespaceAware(boolean value) {
        namespaceAware = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.510 -0400", hash_original_method = "73F7C79343F86EF391295D82FA5B5401", hash_generated_method = "5C84744C1F9E9A2B6CB6EA847AEF34A4")
    private String resolvePredefinedOrCharacterEntity(String entityName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1858887693 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1531425955 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_703076245 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1543845371 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_87914732 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1820689621 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1854442280 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2110959256 = null; 
        {
            boolean var5E9541BCC7A289362EE4C3AE04E2B345_1477507983 = (entityName.startsWith("#x"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1858887693 = resolveCharacterReference(entityName.substring(2), 16);
            } 
            {
                boolean var3B1D1470C1227B32126068B7381617C2_572244042 = (entityName.startsWith("#"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1531425955 = resolveCharacterReference(entityName.substring(1), 10);
                } 
            } 
        } 
        {
            boolean var035E02B36B37C7465FCB51F3669FE998_374576837 = ("lt".equals(entityName));
            {
                varB4EAC82CA7396A68D541C85D26508E83_703076245 = "<";
            } 
            {
                boolean varC654BFE8E8A7FDDD1701D244905C1F59_2082687121 = ("gt".equals(entityName));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1543845371 = ">";
                } 
                {
                    boolean var99FC03628CEC89ABFD06DBC54D1F84AD_1976617258 = ("amp".equals(entityName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_87914732 = "&";
                    } 
                    {
                        boolean var89BC7D2645BF887F17E0544529CA9CBC_140375919 = ("apos".equals(entityName));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1820689621 = "'";
                        } 
                        {
                            boolean varB01636C20C19F22F40F678A48E58C05A_1514095847 = ("quot".equals(entityName));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1854442280 = "\"";
                            } 
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_2110959256 = null;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(entityName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1332492471; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_1858887693;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_1531425955;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_703076245;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_1543845371;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_87914732;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_1820689621;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_1854442280;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1332492471 = varB4EAC82CA7396A68D541C85D26508E83_2110959256;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1332492471.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1332492471;
        
        
            
        
            
        
        
            
        
            
        
            
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.510 -0400", hash_original_method = "F0F9BC1451B812F6B38C0D286F9C9978", hash_generated_method = "050D49B051A75F57FA3DE99762C64446")
    private String resolveCharacterReference(String value, int base) {
        String varB4EAC82CA7396A68D541C85D26508E83_806815119 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_357030425 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1489350800 = null; 
        try 
        {
            int ch = Integer.parseInt(value, base);
            {
                varB4EAC82CA7396A68D541C85D26508E83_806815119 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_357030425 = String.valueOf((char) ch);
        } 
        catch (NumberFormatException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1489350800 = null;
        } 
        addTaint(value.getTaint());
        addTaint(base);
        String varA7E53CE21691AB073D9660D615818899_1767237604; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1767237604 = varB4EAC82CA7396A68D541C85D26508E83_806815119;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1767237604 = varB4EAC82CA7396A68D541C85D26508E83_357030425;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1767237604 = varB4EAC82CA7396A68D541C85D26508E83_1489350800;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1767237604.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1767237604;
        
        
            
            
                
            
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.511 -0400", hash_original_field = "553C5188DE8D4AA3A6B8001F5E5B85C6", hash_generated_field = "512771BF3B10ACB6843471120D35250C")

    private static DOMImplementationImpl dom = DOMImplementationImpl.getInstance();
}

