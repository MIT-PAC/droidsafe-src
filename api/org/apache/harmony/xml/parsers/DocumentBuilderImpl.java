package org.apache.harmony.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.999 -0400", hash_original_field = "B795440B9ADE4378FEF3486B241378BC", hash_generated_field = "4A9121F2D482493F3BEB1C30E72C76AA")

    private boolean coalescing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.999 -0400", hash_original_field = "EABB965CB8BE873142A4DA0189C06FD8", hash_generated_field = "923D10729FC72A63D7530A13EDC17701")

    private EntityResolver entityResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.999 -0400", hash_original_field = "F56352FA359A5F4533A25E5F29D527F4", hash_generated_field = "754BD707F8949F8FC6D5E6C0F6EACB6F")

    private ErrorHandler errorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.999 -0400", hash_original_field = "805C7D6D9D5924ED581B31411F041DA0", hash_generated_field = "833EEF27C45F7AD04FCDBA4B464FF80B")

    private boolean ignoreComments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.999 -0400", hash_original_field = "E7B529A53B13854C58873F69431FFFE7", hash_generated_field = "936EEB5781DB0070979C36A276CB0F01")

    private boolean ignoreElementContentWhitespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.000 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "9718A1E7D4348F4ADD16E4057036B4E2")

    private boolean namespaceAware;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.000 -0400", hash_original_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58", hash_generated_method = "6E36B4A4B3486B5FCAD4EDE2EA40AC58")
    public DocumentBuilderImpl ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.000 -0400", hash_original_method = "EFC1F1695F664AAB80C061E3A6039A89", hash_generated_method = "2B12757C3AD4171FDB951A90F0F6F6B8")
    @Override
    public void reset() {
        coalescing = false;
        entityResolver = null;
        errorHandler = null;
        ignoreComments = false;
        ignoreElementContentWhitespace = false;
        namespaceAware = false;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.001 -0400", hash_original_method = "18E3291D22CB922EEB4EFC42536C583A", hash_generated_method = "CE1A1594ADA554EE68AE3F943A6441AF")
    @Override
    public DOMImplementation getDOMImplementation() {
DOMImplementation var5DFBF8B654BC99F3F31723F0CC90EE38_190798871 =         dom;
        var5DFBF8B654BC99F3F31723F0CC90EE38_190798871.addTaint(taint);
        return var5DFBF8B654BC99F3F31723F0CC90EE38_190798871;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.001 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "F2FFF9A61DE576CE0EC1A35597426F20")
    @Override
    public boolean isNamespaceAware() {
        boolean varCEC00E48144CD3C5B0000055F3D7FF26_2103347867 = (namespaceAware);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053833912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053833912;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.001 -0400", hash_original_method = "BC62268279A4D4DB4B44A495D4290EBF", hash_generated_method = "A74A167AFE8D098F03FE9731E1CD17A3")
    @Override
    public boolean isValidating() {
        boolean var68934A3E9455FA72420237EB05902327_569988209 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102868885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102868885;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.001 -0400", hash_original_method = "F8DF5811CFC2B33C1997BC6906E28600", hash_generated_method = "652577779BF5394ABDA1275B7454AA31")
    @Override
    public Document newDocument() {
Document varF44D68D8F95CBC444332B4C985935738_510464844 =         dom.createDocument(null, null, null);
        varF44D68D8F95CBC444332B4C985935738_510464844.addTaint(taint);
        return varF44D68D8F95CBC444332B4C985935738_510464844;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.002 -0400", hash_original_method = "3B90C04D8401BDC844BD72B6E8D6BA23", hash_generated_method = "EC5EEEDF23FE3DFA65B6305318FE2803")
    @Override
    public Document parse(InputSource source) throws SAXException, IOException {
        addTaint(source.getTaint());
    if(source == null)        
        {
            IllegalArgumentException varD115AB7186F1128F9A6BDD81A6077D65_1483527819 = new IllegalArgumentException("source == null");
            varD115AB7186F1128F9A6BDD81A6077D65_1483527819.addTaint(taint);
            throw varD115AB7186F1128F9A6BDD81A6077D65_1483527819;
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
    if(source.getByteStream() != null)            
            {
                parser.setInput(source.getByteStream(), inputEncoding);
            } 
            else
    if(source.getCharacterStream() != null)            
            {
                parser.setInput(source.getCharacterStream());
            } 
            else
    if(systemId != null)            
            {
                URL url = new URL(systemId);
                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();
                parser.setInput(urlConnection.getInputStream(), inputEncoding);
            } 
            else
            {
                SAXParseException varAA8C4A669968FD0BEF874D289E0D35A2_1292639240 = new SAXParseException("InputSource needs a stream, reader or URI", null);
                varAA8C4A669968FD0BEF874D289E0D35A2_1292639240.addTaint(taint);
                throw varAA8C4A669968FD0BEF874D289E0D35A2_1292639240;
            } 
    if(parser.nextToken() == XmlPullParser.END_DOCUMENT)            
            {
                SAXParseException varDDD21E329AD526950CE949056BA8DE7E_1489972127 = new SAXParseException("Unexpected end of document", null);
                varDDD21E329AD526950CE949056BA8DE7E_1489972127.addTaint(taint);
                throw varDDD21E329AD526950CE949056BA8DE7E_1489972127;
            } 
            parse(parser, document, document, XmlPullParser.END_DOCUMENT);
            parser.require(XmlPullParser.END_DOCUMENT, null, null);
        } 
        catch (XmlPullParserException ex)
        {
    if(ex.getDetail() instanceof IOException)            
            {
                IOException var2C6D98702E9F6DCE3C06CEA30FE12330_1910545417 = (IOException) ex.getDetail();
                var2C6D98702E9F6DCE3C06CEA30FE12330_1910545417.addTaint(taint);
                throw var2C6D98702E9F6DCE3C06CEA30FE12330_1910545417;
            } 
    if(ex.getDetail() instanceof RuntimeException)            
            {
                RuntimeException varABC8D2EED39B022091FEA77507B6E96B_1081061296 = (RuntimeException) ex.getDetail();
                varABC8D2EED39B022091FEA77507B6E96B_1081061296.addTaint(taint);
                throw varABC8D2EED39B022091FEA77507B6E96B_1081061296;
            } 
            LocatorImpl locator = new LocatorImpl();
            locator.setPublicId(source.getPublicId());
            locator.setSystemId(systemId);
            locator.setLineNumber(ex.getLineNumber());
            locator.setColumnNumber(ex.getColumnNumber());
            SAXParseException newEx = new SAXParseException(ex.getMessage(), locator);
    if(errorHandler != null)            
            {
                errorHandler.error(newEx);
            } 
            newEx.addTaint(taint);
            throw newEx;
        } 
        finally 
        {
            IoUtils.closeQuietly(parser);
        } 
Document var9F9AB3CBBE8887A0E88ED511758C258B_799268738 =         document;
        var9F9AB3CBBE8887A0E88ED511758C258B_799268738.addTaint(taint);
        return var9F9AB3CBBE8887A0E88ED511758C258B_799268738;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.004 -0400", hash_original_method = "608502985E1CF48EAA100E44A7EF5256", hash_generated_method = "F0444D0A9DF121854727C26191B61C8F")
    private void parse(KXmlParser parser, DocumentImpl document, Node node,
            int endToken) throws XmlPullParserException, IOException {
        addTaint(endToken);
        addTaint(node.getTaint());
        addTaint(document.getTaint());
        addTaint(parser.getTaint());
        int token = parser.getEventType();
        while
(token != endToken && token != XmlPullParser.END_DOCUMENT)        
        {
    if(token == XmlPullParser.PROCESSING_INSTRUCTION)            
            {
                String text = parser.getText();
                int dot = text.indexOf(' ');
                String target = (dot != -1 ? text.substring(0, dot) : text);
                String data = (dot != -1 ? text.substring(dot + 1) : "");
                node.appendChild(document.createProcessingInstruction(target,
                        data));
            } 
            else
    if(token == XmlPullParser.DOCDECL)            
            {
                String name = parser.getRootElementName();
                String publicId = parser.getPublicId();
                String systemId = parser.getSystemId();
                document.appendChild(new DocumentTypeImpl(document, name, publicId, systemId));
            } 
            else
    if(token == XmlPullParser.COMMENT)            
            {
    if(!ignoreComments)                
                {
                    node.appendChild(document.createComment(parser.getText()));
                } 
            } 
            else
    if(token == XmlPullParser.IGNORABLE_WHITESPACE)            
            {
    if(!ignoreElementContentWhitespace && document != node)                
                {
                    appendText(document, node, token, parser.getText());
                } 
            } 
            else
    if(token == XmlPullParser.TEXT || token == XmlPullParser.CDSECT)            
            {
                appendText(document, node, token, parser.getText());
            } 
            else
    if(token == XmlPullParser.ENTITY_REF)            
            {
                String entity = parser.getName();
    if(entityResolver != null)                
                {
                } 
                String resolved = resolvePredefinedOrCharacterEntity(entity);
    if(resolved != null)                
                {
                    appendText(document, node, token, resolved);
                } 
                else
                {
                    node.appendChild(document.createEntityReference(entity));
                } 
            } 
            else
    if(token == XmlPullParser.START_TAG)            
            {
    if(namespaceAware)                
                {
                    String namespace = parser.getNamespace();
                    String name = parser.getName();
                    String prefix = parser.getPrefix();
    if("".equals(namespace))                    
                    {
                        namespace = null;
                    } 
                    Element element = document.createElementNS(namespace, name);
                    element.setPrefix(prefix);
                    node.appendChild(element);
for(int i = 0;i < parser.getAttributeCount();i++)
                    {
                        String attrNamespace = parser.getAttributeNamespace(i);
                        String attrPrefix = parser.getAttributePrefix(i);
                        String attrName = parser.getAttributeName(i);
                        String attrValue = parser.getAttributeValue(i);
    if("".equals(attrNamespace))                        
                        {
                            attrNamespace = null;
                        } 
                        Attr attr = document.createAttributeNS(attrNamespace, attrName);
                        attr.setPrefix(attrPrefix);
                        attr.setValue(attrValue);
                        element.setAttributeNodeNS(attr);
                    } 
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);
                    parser.require(XmlPullParser.END_TAG, namespace, name);
                } 
                else
                {
                    String name = parser.getName();
                    Element element = document.createElement(name);
                    node.appendChild(element);
for(int i = 0;i < parser.getAttributeCount();i++)
                    {
                        String attrName = parser.getAttributeName(i);
                        String attrValue = parser.getAttributeValue(i);
                        Attr attr = document.createAttribute(attrName);
                        attr.setValue(attrValue);
                        element.setAttributeNode(attr);
                    } 
                    token = parser.nextToken();
                    parse(parser, document, element, XmlPullParser.END_TAG);
                    parser.require(XmlPullParser.END_TAG, "", name);
                } 
            } 
            token = parser.nextToken();
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.006 -0400", hash_original_method = "691ECF0A6ABC696CF83421ACD1A425FF", hash_generated_method = "9EF31ABECB655827FA78C6FB54438805")
    private void appendText(DocumentImpl document, Node parent, int token, String text) {
        addTaint(text.getTaint());
        addTaint(token);
        addTaint(parent.getTaint());
        addTaint(document.getTaint());
    if(text.isEmpty())        
        {
            return;
        } 
    if(coalescing || token != XmlPullParser.CDSECT)        
        {
            Node lastChild = parent.getLastChild();
    if(lastChild != null && lastChild.getNodeType() == Node.TEXT_NODE)            
            {
                Text textNode = (Text) lastChild;
                textNode.appendData(text);
                return;
            } 
        } 
        parent.appendChild(token == XmlPullParser.CDSECT
                ? new CDATASectionImpl(document, text)
                : new TextImpl(document, text));
        
        
            
        
        
            
            
                
                
                
            
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.006 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "F6C937BA9FB5D557A5996E2A79EB5DEF")
    @Override
    public void setEntityResolver(EntityResolver resolver) {
        entityResolver = resolver;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.007 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "11AEE823D94AC8C9400608C1180478AB")
    @Override
    public void setErrorHandler(ErrorHandler handler) {
        errorHandler = handler;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.007 -0400", hash_original_method = "1DD135B57BB0EB96EC13DA0D7BA611DF", hash_generated_method = "05B80D9CDF2B77D1BB0F88AEFBE01DEB")
    public void setIgnoreComments(boolean value) {
        ignoreComments = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.007 -0400", hash_original_method = "2E9B1D166C3D3A81908F8020FAC250A6", hash_generated_method = "A6D6A159EF8C25563FDBAB7ED388A0B6")
    public void setCoalescing(boolean value) {
        coalescing = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.008 -0400", hash_original_method = "9500E8ECEFA6BF93266530CE7C837D66", hash_generated_method = "20E4D2800982DC5C649D9C7E0B8BCEB7")
    public void setIgnoreElementContentWhitespace(boolean value) {
        ignoreElementContentWhitespace = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.008 -0400", hash_original_method = "16455E0CEE4216C1E1A45B9ED8EFF729", hash_generated_method = "51CE5D3FAA2FC8C2C7E38867B04EB554")
    public void setNamespaceAware(boolean value) {
        namespaceAware = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.008 -0400", hash_original_method = "73F7C79343F86EF391295D82FA5B5401", hash_generated_method = "D016FE2D669D8F54DC2699A4158A91B1")
    private String resolvePredefinedOrCharacterEntity(String entityName) {
        addTaint(entityName.getTaint());
    if(entityName.startsWith("#x"))        
        {
String varC875A48F841B9C6FC99175AA488199C1_1914194054 =             resolveCharacterReference(entityName.substring(2), 16);
            varC875A48F841B9C6FC99175AA488199C1_1914194054.addTaint(taint);
            return varC875A48F841B9C6FC99175AA488199C1_1914194054;
        } 
        else
    if(entityName.startsWith("#"))        
        {
String var6007954AA5497BB300AB744945EEE3BF_1634142265 =             resolveCharacterReference(entityName.substring(1), 10);
            var6007954AA5497BB300AB744945EEE3BF_1634142265.addTaint(taint);
            return var6007954AA5497BB300AB744945EEE3BF_1634142265;
        } 
    if("lt".equals(entityName))        
        {
String var80EDCEC5150250F95C4E48977E297D2E_2079362600 =             "<";
            var80EDCEC5150250F95C4E48977E297D2E_2079362600.addTaint(taint);
            return var80EDCEC5150250F95C4E48977E297D2E_2079362600;
        } 
        else
    if("gt".equals(entityName))        
        {
String var4A12A3ACBB035E6CC8779CB618AFF4D1_996480929 =             ">";
            var4A12A3ACBB035E6CC8779CB618AFF4D1_996480929.addTaint(taint);
            return var4A12A3ACBB035E6CC8779CB618AFF4D1_996480929;
        } 
        else
    if("amp".equals(entityName))        
        {
String var6F697D4D38B4356D91DED8C0B512789D_15495271 =             "&";
            var6F697D4D38B4356D91DED8C0B512789D_15495271.addTaint(taint);
            return var6F697D4D38B4356D91DED8C0B512789D_15495271;
        } 
        else
    if("apos".equals(entityName))        
        {
String varB7F3758FE18EE0147E8BEE7D59DE5FCF_831800929 =             "'";
            varB7F3758FE18EE0147E8BEE7D59DE5FCF_831800929.addTaint(taint);
            return varB7F3758FE18EE0147E8BEE7D59DE5FCF_831800929;
        } 
        else
    if("quot".equals(entityName))        
        {
String varA3552CC110718C18BAE0F697B199A196_2083154071 =             "\"";
            varA3552CC110718C18BAE0F697B199A196_2083154071.addTaint(taint);
            return varA3552CC110718C18BAE0F697B199A196_2083154071;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_989008363 =             null;
            var540C13E9E156B687226421B24F2DF178_989008363.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_989008363;
        } 
        
        
            
        
            
        
        
            
        
            
        
            
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.009 -0400", hash_original_method = "F0F9BC1451B812F6B38C0D286F9C9978", hash_generated_method = "667EA23259CF996912074F957AB56F12")
    private String resolveCharacterReference(String value, int base) {
        addTaint(base);
        addTaint(value.getTaint());
        try 
        {
            int ch = Integer.parseInt(value, base);
    if(ch < 0 || ch > Character.MAX_VALUE)            
            {
String var540C13E9E156B687226421B24F2DF178_881212074 =                 null;
                var540C13E9E156B687226421B24F2DF178_881212074.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_881212074;
            } 
String var139E29CB19E851A0CF712817E4697D18_187951647 =             String.valueOf((char) ch);
            var139E29CB19E851A0CF712817E4697D18_187951647.addTaint(taint);
            return var139E29CB19E851A0CF712817E4697D18_187951647;
        } 
        catch (NumberFormatException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1317169947 =             null;
            var540C13E9E156B687226421B24F2DF178_1317169947.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1317169947;
        } 
        
        
            
            
                
            
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.010 -0400", hash_original_field = "553C5188DE8D4AA3A6B8001F5E5B85C6", hash_generated_field = "512771BF3B10ACB6843471120D35250C")

    private static DOMImplementationImpl dom = DOMImplementationImpl.getInstance();
}

