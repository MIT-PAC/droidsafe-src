package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Locale;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public class XMLReaderAdapter implements Parser, ContentHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.573 -0400", hash_original_field = "DF703C2D84F1FAD52D3A9BD1A6B25FFE", hash_generated_field = "44EF69C8F1F45C928EC7CB20788E9F99")

    XMLReader xmlReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.573 -0400", hash_original_field = "F52BDEE8DD5CF0F9EEB75FE7D6BE559F", hash_generated_field = "C1D38A44C2BDD7CFC6D4A25FFD145E34")

    DocumentHandler documentHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.573 -0400", hash_original_field = "5B2902A6669F7164A98A2AABBBA7007B", hash_generated_field = "73705B24ED28379A26291F89BCC792AC")

    AttributesAdapter qAtts;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.574 -0400", hash_original_method = "76BB97F012769A161CBA88EA8A2E4EBA", hash_generated_method = "ACE6CAC3BCC79737302ED6D2560D7BCC")
    public  XMLReaderAdapter() throws SAXException {
        setup(XMLReaderFactory.createXMLReader());
        // ---------- Original Method ----------
        //setup(XMLReaderFactory.createXMLReader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.574 -0400", hash_original_method = "8B041FBF651D4DFB0C8BE59922C68E87", hash_generated_method = "68236319045C333DDA2C63ABA6A00A6E")
    public  XMLReaderAdapter(XMLReader xmlReader) {
        addTaint(xmlReader.getTaint());
        setup(xmlReader);
        // ---------- Original Method ----------
        //setup(xmlReader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.574 -0400", hash_original_method = "E177ACAABE14FBF113725220BFCC127D", hash_generated_method = "F814BBD75BFFED9613BE2787CF10D549")
    private void setup(XMLReader xmlReader) {
    if(xmlReader == null)        
        {
            NullPointerException var132C8432BDD011DD7E9C2E2174C2B9F3_1099322180 = new NullPointerException("XMLReader must not be null");
            var132C8432BDD011DD7E9C2E2174C2B9F3_1099322180.addTaint(taint);
            throw var132C8432BDD011DD7E9C2E2174C2B9F3_1099322180;
        } //End block
        this.xmlReader = xmlReader;
        qAtts = new AttributesAdapter();
        // ---------- Original Method ----------
        //if (xmlReader == null) {
        //throw new NullPointerException("XMLReader must not be null");
    //}
        //this.xmlReader = xmlReader;
        //qAtts = new AttributesAdapter();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.575 -0400", hash_original_method = "6F3F2251FC8DF5A2BC76DADBD382AD55", hash_generated_method = "FE3D5976C1036574A017999CA0AE2B80")
    public void setLocale(Locale locale) throws SAXException {
        addTaint(locale.getTaint());
        SAXNotSupportedException var4EB729013FC6081584201FCF4557393A_1827235375 = new SAXNotSupportedException("setLocale not supported");
        var4EB729013FC6081584201FCF4557393A_1827235375.addTaint(taint);
        throw var4EB729013FC6081584201FCF4557393A_1827235375;
        // ---------- Original Method ----------
        //throw new SAXNotSupportedException("setLocale not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.575 -0400", hash_original_method = "4AE4FF8425B7CD5477DB299D2E768007", hash_generated_method = "6A7DC052A1CDF85E6C55241582AB4591")
    public void setEntityResolver(EntityResolver resolver) {
        addTaint(resolver.getTaint());
        xmlReader.setEntityResolver(resolver);
        // ---------- Original Method ----------
        //xmlReader.setEntityResolver(resolver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.575 -0400", hash_original_method = "88C10864FC45C96400C579FA2D97330E", hash_generated_method = "15D425542C5D7FB6C1A94A40E6518DF7")
    public void setDTDHandler(DTDHandler handler) {
        addTaint(handler.getTaint());
        xmlReader.setDTDHandler(handler);
        // ---------- Original Method ----------
        //xmlReader.setDTDHandler(handler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.576 -0400", hash_original_method = "066AA0855CEAF16F5A4DD1498A9898AE", hash_generated_method = "0F2ADD0F92A8C507A348EECB68D8069E")
    public void setDocumentHandler(DocumentHandler handler) {
        documentHandler = handler;
        // ---------- Original Method ----------
        //documentHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.576 -0400", hash_original_method = "72DE679535A20097297B12B846F37162", hash_generated_method = "6B56BD84A7CD1A51E5DEB00740286C1C")
    public void setErrorHandler(ErrorHandler handler) {
        addTaint(handler.getTaint());
        xmlReader.setErrorHandler(handler);
        // ---------- Original Method ----------
        //xmlReader.setErrorHandler(handler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.576 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "17B1436177E4DE56B91CAF4A0F73B451")
    public void parse(String systemId) throws IOException, SAXException {
        addTaint(systemId.getTaint());
        parse(new InputSource(systemId));
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.576 -0400", hash_original_method = "16241BDA797C9EF94AA818BE003DDED6", hash_generated_method = "BAF16683D2A3E904B6B3C7831EDDEAE4")
    public void parse(InputSource input) throws IOException, SAXException {
        addTaint(input.getTaint());
        setupXMLReader();
        xmlReader.parse(input);
        // ---------- Original Method ----------
        //setupXMLReader();
        //xmlReader.parse(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.577 -0400", hash_original_method = "996AF21F9D794D58D80CF95A8864356D", hash_generated_method = "119DA054CAB6D2BE1AE12489C76320FE")
    private void setupXMLReader() throws SAXException {
        xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        try 
        {
            xmlReader.setFeature("http://xml.org/sax/features/namespaces",
                             false);
        } //End block
        catch (SAXException e)
        {
        } //End block
        xmlReader.setContentHandler(this);
        // ---------- Original Method ----------
        //xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        //try {
        //xmlReader.setFeature("http://xml.org/sax/features/namespaces",
                             //false);
    //} catch (SAXException e) {
    //}
        //xmlReader.setContentHandler(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.577 -0400", hash_original_method = "3CAE4C302EA4B3C24003E67187B52764", hash_generated_method = "53808CE1292164DF4F2C0DEFF480E5D8")
    public void setDocumentLocator(Locator locator) {
        addTaint(locator.getTaint());
    if(documentHandler != null)        
        documentHandler.setDocumentLocator(locator);
        // ---------- Original Method ----------
        //if (documentHandler != null)
        //documentHandler.setDocumentLocator(locator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.577 -0400", hash_original_method = "32BB697A91610539031004A9D01C7415", hash_generated_method = "A885E37BCC4F9F9864D6924DF41A4991")
    public void startDocument() throws SAXException {
    if(documentHandler != null)        
        documentHandler.startDocument();
        // ---------- Original Method ----------
        //if (documentHandler != null)
        //documentHandler.startDocument();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.577 -0400", hash_original_method = "1ABAE35BE3091AD40FC1FECAC80B863E", hash_generated_method = "A07C315E9EAAE9095823EDE97401D0E2")
    public void endDocument() throws SAXException {
    if(documentHandler != null)        
        documentHandler.endDocument();
        // ---------- Original Method ----------
        //if (documentHandler != null)
        //documentHandler.endDocument();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.578 -0400", hash_original_method = "A4FE8368A0813DB39B9B2D62745BDC50", hash_generated_method = "8FDC55F9D464E2D689D2B0B5CDBBC246")
    public void startPrefixMapping(String prefix, String uri) {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.578 -0400", hash_original_method = "6288457D9104DBA73FF5F77796A5069B", hash_generated_method = "398A8D091F972C52779202B902D2C498")
    public void endPrefixMapping(String prefix) {
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.578 -0400", hash_original_method = "19EEF6F7A6D3ECB16FB052F6607F9998", hash_generated_method = "8E48A42E7883B421EC89944C7059B215")
    public void startElement(String uri, String localName,
                  String qName, Attributes atts) throws SAXException {
        addTaint(atts.getTaint());
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
    if(documentHandler != null)        
        {
            qAtts.setAttributes(atts);
            documentHandler.startElement(qName, qAtts);
        } //End block
        // ---------- Original Method ----------
        //if (documentHandler != null) {
        //qAtts.setAttributes(atts);
        //documentHandler.startElement(qName, qAtts);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.578 -0400", hash_original_method = "931F7A2FD2648B2A1C28EDF8D67E709D", hash_generated_method = "92BF34C58EDE960AF6CE2595BD0C34B5")
    public void endElement(String uri, String localName,
                String qName) throws SAXException {
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
    if(documentHandler != null)        
        documentHandler.endElement(qName);
        // ---------- Original Method ----------
        //if (documentHandler != null)
        //documentHandler.endElement(qName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.579 -0400", hash_original_method = "1F709B7946BD47BE5374DFAB95B97284", hash_generated_method = "EA672DECBE41344FC3148DF75FD6331D")
    public void characters(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
    if(documentHandler != null)        
        documentHandler.characters(ch, start, length);
        // ---------- Original Method ----------
        //if (documentHandler != null)
        //documentHandler.characters(ch, start, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.579 -0400", hash_original_method = "8F77A2CC8A8F4FEA0C562F269098A504", hash_generated_method = "1F2281D0BCAF69C75FA31522F0054B87")
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
    if(documentHandler != null)        
        documentHandler.ignorableWhitespace(ch, start, length);
        // ---------- Original Method ----------
        //if (documentHandler != null)
        //documentHandler.ignorableWhitespace(ch, start, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.579 -0400", hash_original_method = "01B4469A7119F79BBDA4CF4D6616EEC2", hash_generated_method = "0CB8AE81DF9A3474166F68D34BEED378")
    public void processingInstruction(String target, String data) throws SAXException {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
    if(documentHandler != null)        
        documentHandler.processingInstruction(target, data);
        // ---------- Original Method ----------
        //if (documentHandler != null)
        //documentHandler.processingInstruction(target, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.580 -0400", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "78177C3306D49108B776A6C694C380AB")
    public void skippedEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    static final class AttributesAdapter implements AttributeList {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.580 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "B58329F5904269DD97B6B42BAA3B838E")

        private Attributes attributes;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.580 -0400", hash_original_method = "E50C9A4E371E1BB1DB8AD3C2D41905DA", hash_generated_method = "6DD45A539CB2C54185009851E7F4E171")
          AttributesAdapter() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.581 -0400", hash_original_method = "53FC4E3BB2217D6659CB21AA159A3250", hash_generated_method = "7A0F98D55CE81AA31A2B8414CFC871B3")
         void setAttributes(Attributes attributes) {
            this.attributes = attributes;
            // ---------- Original Method ----------
            //this.attributes = attributes;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.581 -0400", hash_original_method = "91D9ED6BC44066DC74ACDFE2397CD717", hash_generated_method = "9DE7434789E3286BB882A57EF226E996")
        public int getLength() {
            int var88709B1969FAA074A8AF53DE81D847BB_1151960463 = (attributes.getLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060711790 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060711790;
            // ---------- Original Method ----------
            //return attributes.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.581 -0400", hash_original_method = "ED147CDF790A0CCB36C14BED3C6421FF", hash_generated_method = "943F273EEE8CA9E830DA9933E3DE65C0")
        public String getName(int i) {
            addTaint(i);
String varD3C415BCDC7E1755014BC06AE2F77294_1116798341 =             attributes.getQName(i);
            varD3C415BCDC7E1755014BC06AE2F77294_1116798341.addTaint(taint);
            return varD3C415BCDC7E1755014BC06AE2F77294_1116798341;
            // ---------- Original Method ----------
            //return attributes.getQName(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.581 -0400", hash_original_method = "CD7B0B2A6AEED3EE82C9A05E49CD2219", hash_generated_method = "2E004F55C54F8B134B3B86739A42A099")
        public String getType(int i) {
            addTaint(i);
String var3818F318EC5F073B13DD78EF162E343C_1348390820 =             attributes.getType(i);
            var3818F318EC5F073B13DD78EF162E343C_1348390820.addTaint(taint);
            return var3818F318EC5F073B13DD78EF162E343C_1348390820;
            // ---------- Original Method ----------
            //return attributes.getType(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.582 -0400", hash_original_method = "985A31734C2AABCE7CE9E7B351282D4B", hash_generated_method = "250ADD00AEAFCC35F47D4252BC312351")
        public String getValue(int i) {
            addTaint(i);
String varAAEFE96E9C44A0217652CF0D167CC709_186473975 =             attributes.getValue(i);
            varAAEFE96E9C44A0217652CF0D167CC709_186473975.addTaint(taint);
            return varAAEFE96E9C44A0217652CF0D167CC709_186473975;
            // ---------- Original Method ----------
            //return attributes.getValue(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.582 -0400", hash_original_method = "8A6442FB647EA21090E4FC03D1B47FA4", hash_generated_method = "F95DF89093563E18CBCF886BC7EC3D15")
        public String getType(String qName) {
            addTaint(qName.getTaint());
String varD43747F64DB59BD3B1BAF20BB8E1CFE0_1672162981 =             attributes.getType(qName);
            varD43747F64DB59BD3B1BAF20BB8E1CFE0_1672162981.addTaint(taint);
            return varD43747F64DB59BD3B1BAF20BB8E1CFE0_1672162981;
            // ---------- Original Method ----------
            //return attributes.getType(qName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.582 -0400", hash_original_method = "4A5F2D731504040B76231CFBA75E49A7", hash_generated_method = "2C312FE13A34C1938BA47C3CA4809852")
        public String getValue(String qName) {
            addTaint(qName.getTaint());
String varDF2956FE705B1355F49D307CB14564B0_1342504650 =             attributes.getValue(qName);
            varDF2956FE705B1355F49D307CB14564B0_1342504650.addTaint(taint);
            return varDF2956FE705B1355F49D307CB14564B0_1342504650;
            // ---------- Original Method ----------
            //return attributes.getValue(qName);
        }

        
    }


    
}

