package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class ParserAdapter implements XMLReader, DocumentHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.521 -0400", hash_original_field = "98AEDCDD6727BD81632D9F9CB201EE47", hash_generated_field = "E45249B9729220F661033FE0273CAECE")

    private NamespaceSupport nsSupport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.521 -0400", hash_original_field = "8E7E1A4BC0AA1454679F0E7EEA5531E9", hash_generated_field = "995A52C4CFBC84030E5C3B84FDD67C5A")

    private AttributeListAdapter attAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.521 -0400", hash_original_field = "5F5944B82735B9CF51523BBC1223615E", hash_generated_field = "B2B6F03C3323CC2E5DF880878C6AD064")

    private boolean parsing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.521 -0400", hash_original_field = "16F80F22BCD24DC823FEEA455EDB94D1", hash_generated_field = "9D06BBFBDDCCC6F79C4828C391273388")

    private String nameParts[] = new String[3];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "311E305FB0D751192221DEAFF834950C", hash_generated_field = "C1941098165849B9BB09C918699765BA")

    private Parser parser = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "8F2051083EF5F7D90FAE9F582E10ED23", hash_generated_field = "1C437322B74865B450A5CD9EA125241E")

    private AttributesImpl atts = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "312A8D34A10A42AF3135F707FD689CB4", hash_generated_field = "F2647CFF1692834895465A43B4FBE112")

    private boolean namespaces = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "466ECE05D09617567128504C4EB72E25", hash_generated_field = "3042A72B16E92F646AF269C47B7B0A4D")

    private boolean prefixes = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "1DFAA5C26271A267921178B52CA9F647", hash_generated_field = "96E23C17D2742D7559D0E0D31EA42D80")

    private boolean uris = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "AB1E07F86CA37C6521CC1969EE2AC6C9", hash_generated_field = "ACD7A3294F45ACE61F205E17A82EF3B3")

    Locator locator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "CB1E9F728CE46E75CD080A7B0788AA70", hash_generated_field = "85A3C4DFDDC2E8B053733750B1AEDE7A")

    EntityResolver entityResolver = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "4243CF9A597D079587D3CDAC53C40C0A", hash_generated_field = "36C16184E94517BCEA93A1000BB15E7B")

    DTDHandler dtdHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "B71FDAA881F7A0E3499DF3E064B2C5EC", hash_generated_field = "F44EFA80D2ED728EA2AFD1A415E0F220")

    ContentHandler contentHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_field = "A94D9C6596FCF433C6EEF597B5778A9C", hash_generated_field = "B6B9BEC6A9AF54860C9708100871418D")

    ErrorHandler errorHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.522 -0400", hash_original_method = "6A3B211FACF5438B3BC1ECD3BFD1BA43", hash_generated_method = "8BB8BEA86CF577909CBA90CA66641A09")
    public  ParserAdapter() throws SAXException {
        String driver = System.getProperty("org.xml.sax.parser");
        try 
        {
            setup(ParserFactory.makeParser());
        } //End block
        catch (ClassNotFoundException e1)
        {
            SAXException var32AA5AAF24504140370900E99D55554E_1475826556 = new
        SAXException("Cannot find SAX1 driver class " +
                 driver, e1);
            var32AA5AAF24504140370900E99D55554E_1475826556.addTaint(taint);
            throw var32AA5AAF24504140370900E99D55554E_1475826556;
        } //End block
        catch (IllegalAccessException e2)
        {
            SAXException var0D6F9FF58A1EC2BB7449B15F0E07B5C5_1336300294 = new
        SAXException("SAX1 driver class " +
                 driver +
                 " found but cannot be loaded", e2);
            var0D6F9FF58A1EC2BB7449B15F0E07B5C5_1336300294.addTaint(taint);
            throw var0D6F9FF58A1EC2BB7449B15F0E07B5C5_1336300294;
        } //End block
        catch (InstantiationException e3)
        {
            SAXException var65044A69D1146CA706699FFA8866D0DD_1142779580 = new
        SAXException("SAX1 driver class " +
                 driver +
                 " loaded but cannot be instantiated", e3);
            var65044A69D1146CA706699FFA8866D0DD_1142779580.addTaint(taint);
            throw var65044A69D1146CA706699FFA8866D0DD_1142779580;
        } //End block
        catch (ClassCastException e4)
        {
            SAXException var04087AD61216E6C172BC51D83A8A8014_1804867645 = new
        SAXException("SAX1 driver class " +
                 driver +
                 " does not implement org.xml.sax.Parser");
            var04087AD61216E6C172BC51D83A8A8014_1804867645.addTaint(taint);
            throw var04087AD61216E6C172BC51D83A8A8014_1804867645;
        } //End block
        catch (NullPointerException e5)
        {
            SAXException varAF40C69085E3E17FCB2CA1482DB74A32_1447726498 = new
        SAXException("System property org.xml.sax.parser not specified");
            varAF40C69085E3E17FCB2CA1482DB74A32_1447726498.addTaint(taint);
            throw varAF40C69085E3E17FCB2CA1482DB74A32_1447726498;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.523 -0400", hash_original_method = "4DBB6701F2EF3CA3BC7975B2574ABC06", hash_generated_method = "14B26D3E15032A126487D810C6ED10C5")
    public  ParserAdapter(Parser parser) {
        addTaint(parser.getTaint());
        setup(parser);
        // ---------- Original Method ----------
        //setup(parser);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.524 -0400", hash_original_method = "9AA60727AB1204C604E2657D93003A43", hash_generated_method = "324865595ECA46BA457E838B2A787B66")
    private void setup(Parser parser) {
    if(parser == null)        
        {
            NullPointerException var70F65CFA6BBF6FCA3AE4FF616452D979_125696081 = new
        NullPointerException("Parser argument must not be null");
            var70F65CFA6BBF6FCA3AE4FF616452D979_125696081.addTaint(taint);
            throw var70F65CFA6BBF6FCA3AE4FF616452D979_125696081;
        } //End block
        this.parser = parser;
        atts = new AttributesImpl();
        nsSupport = new NamespaceSupport();
        attAdapter = new AttributeListAdapter();
        // ---------- Original Method ----------
        //if (parser == null) {
        //throw new
        //NullPointerException("Parser argument must not be null");
    //}
        //this.parser = parser;
        //atts = new AttributesImpl();
        //nsSupport = new NamespaceSupport();
        //attAdapter = new AttributeListAdapter();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.525 -0400", hash_original_method = "A3A2E58BF53A687D411A2644B8AA8600", hash_generated_method = "AB3E87303D1E10119DFF6AF03DEFE4E2")
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name.equals(NAMESPACES))        
        {
            checkNotParsing("feature", name);
            namespaces = value;
    if(!namespaces && !prefixes)            
            {
                prefixes = true;
            } //End block
        } //End block
        else
    if(name.equals(NAMESPACE_PREFIXES))        
        {
            checkNotParsing("feature", name);
            prefixes = value;
    if(!prefixes && !namespaces)            
            {
                namespaces = true;
            } //End block
        } //End block
        else
    if(name.equals(XMLNS_URIs))        
        {
            checkNotParsing("feature", name);
            uris = value;
        } //End block
        else
        {
            SAXNotRecognizedException varA089E49DFCE7CCAC8AA43F2560A25520_151969178 = new SAXNotRecognizedException("Feature: " + name);
            varA089E49DFCE7CCAC8AA43F2560A25520_151969178.addTaint(taint);
            throw varA089E49DFCE7CCAC8AA43F2560A25520_151969178;
        } //End block
        // ---------- Original Method ----------
        //if (name.equals(NAMESPACES)) {
        //checkNotParsing("feature", name);
        //namespaces = value;
        //if (!namespaces && !prefixes) {
        //prefixes = true;
        //}
    //} else if (name.equals(NAMESPACE_PREFIXES)) {
        //checkNotParsing("feature", name);
        //prefixes = value;
        //if (!prefixes && !namespaces) {
        //namespaces = true;
        //}
    //} else if (name.equals(XMLNS_URIs)) {
        //checkNotParsing("feature", name);
        //uris = value;
    //} else {
        //throw new SAXNotRecognizedException("Feature: " + name);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.526 -0400", hash_original_method = "894FAC8B5FEFDB9322A454DD3740A469", hash_generated_method = "E174504CA722C6DE31C7EBEB781F6788")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name.equals(NAMESPACES))        
        {
            boolean var3D322AF70BC106A52679F1EB72F98AE6_1598853904 = (namespaces);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223580734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_223580734;
        } //End block
        else
    if(name.equals(NAMESPACE_PREFIXES))        
        {
            boolean var735E5189FAD047C92AC9F292E73ED303_1186759692 = (prefixes);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910090874 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910090874;
        } //End block
        else
    if(name.equals(XMLNS_URIs))        
        {
            boolean var7B09EE9A35BA33DA533A4D7CECA76160_839988647 = (uris);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1917886399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1917886399;
        } //End block
        else
        {
            SAXNotRecognizedException varA089E49DFCE7CCAC8AA43F2560A25520_1386635259 = new SAXNotRecognizedException("Feature: " + name);
            varA089E49DFCE7CCAC8AA43F2560A25520_1386635259.addTaint(taint);
            throw varA089E49DFCE7CCAC8AA43F2560A25520_1386635259;
        } //End block
        // ---------- Original Method ----------
        //if (name.equals(NAMESPACES)) {
        //return namespaces;
    //} else if (name.equals(NAMESPACE_PREFIXES)) {
        //return prefixes;
    //} else if (name.equals(XMLNS_URIs)) {
        //return uris;
    //} else {
        //throw new SAXNotRecognizedException("Feature: " + name);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.527 -0400", hash_original_method = "EE8A541C22360A747253892239DA9935", hash_generated_method = "0D26289F823A95AD3AB240FBED850A0F")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        SAXNotRecognizedException var6728249AD760647635DFCCD62459D7C5_720214049 = new SAXNotRecognizedException("Property: " + name);
        var6728249AD760647635DFCCD62459D7C5_720214049.addTaint(taint);
        throw var6728249AD760647635DFCCD62459D7C5_720214049;
        // ---------- Original Method ----------
        //throw new SAXNotRecognizedException("Property: " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.527 -0400", hash_original_method = "C44A70A290987077F2BE17BCA485ED98", hash_generated_method = "06E435BD2260DE654206B114794511E2")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
        SAXNotRecognizedException var6728249AD760647635DFCCD62459D7C5_854892663 = new SAXNotRecognizedException("Property: " + name);
        var6728249AD760647635DFCCD62459D7C5_854892663.addTaint(taint);
        throw var6728249AD760647635DFCCD62459D7C5_854892663;
        // ---------- Original Method ----------
        //throw new SAXNotRecognizedException("Property: " + name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.528 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "82A21E5D6439DF297D3DDA5C9F15C57B")
    public void setEntityResolver(EntityResolver resolver) {
        entityResolver = resolver;
        // ---------- Original Method ----------
        //entityResolver = resolver;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.528 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "D660054D0287C555906F11165553E82D")
    public EntityResolver getEntityResolver() {
EntityResolver varB87C3AFF5DDB8AE3D0CC56605478B984_696202695 =         entityResolver;
        varB87C3AFF5DDB8AE3D0CC56605478B984_696202695.addTaint(taint);
        return varB87C3AFF5DDB8AE3D0CC56605478B984_696202695;
        // ---------- Original Method ----------
        //return entityResolver;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.528 -0400", hash_original_method = "119A8AEB4875146983459E145CF644BE", hash_generated_method = "FAA2A53872CCD36AFCB158CD655074B2")
    public void setDTDHandler(DTDHandler handler) {
        dtdHandler = handler;
        // ---------- Original Method ----------
        //dtdHandler = handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.528 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "171CFBF93E440A16D17C59110F91FF68")
    public DTDHandler getDTDHandler() {
DTDHandler varA6420E370A0D0E7B2C08F2BBD64CCBA1_1897428410 =         dtdHandler;
        varA6420E370A0D0E7B2C08F2BBD64CCBA1_1897428410.addTaint(taint);
        return varA6420E370A0D0E7B2C08F2BBD64CCBA1_1897428410;
        // ---------- Original Method ----------
        //return dtdHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.529 -0400", hash_original_method = "D8A0D6D3310208C2BEAFD8789BB430C2", hash_generated_method = "3B6BB5CD628919FBC0C763FB80D35E5E")
    public void setContentHandler(ContentHandler handler) {
        contentHandler = handler;
        // ---------- Original Method ----------
        //contentHandler = handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.529 -0400", hash_original_method = "0648A0EF88EB44B7C03930DFF59893AE", hash_generated_method = "1D5BD7A87AA698F6AE6D516E8F82620D")
    public ContentHandler getContentHandler() {
ContentHandler var9811A50DDAAFB5183DEF735850A275E7_1528737389 =         contentHandler;
        var9811A50DDAAFB5183DEF735850A275E7_1528737389.addTaint(taint);
        return var9811A50DDAAFB5183DEF735850A275E7_1528737389;
        // ---------- Original Method ----------
        //return contentHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.529 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "E6625B96D2BEDE434929849AF18BADF6")
    public void setErrorHandler(ErrorHandler handler) {
        errorHandler = handler;
        // ---------- Original Method ----------
        //errorHandler = handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.529 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "6EE199BEB83730D6873D915D455DFDEE")
    public ErrorHandler getErrorHandler() {
ErrorHandler var814E1CB3DFFE2674E65471BBF7C52ECD_626979424 =         errorHandler;
        var814E1CB3DFFE2674E65471BBF7C52ECD_626979424.addTaint(taint);
        return var814E1CB3DFFE2674E65471BBF7C52ECD_626979424;
        // ---------- Original Method ----------
        //return errorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.529 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "17B1436177E4DE56B91CAF4A0F73B451")
    public void parse(String systemId) throws IOException, SAXException {
        addTaint(systemId.getTaint());
        parse(new InputSource(systemId));
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.530 -0400", hash_original_method = "8D1EDF001F7865BC335C47DEAA91DF87", hash_generated_method = "F7BF5C4B8C9CF784BB010D5914CBA60C")
    public void parse(InputSource input) throws IOException, SAXException {
        addTaint(input.getTaint());
    if(parsing)        
        {
            SAXException var3C0E4D0DD07B1683AC1481C9109F01E0_367336841 = new SAXException("Parser is already in use");
            var3C0E4D0DD07B1683AC1481C9109F01E0_367336841.addTaint(taint);
            throw var3C0E4D0DD07B1683AC1481C9109F01E0_367336841;
        } //End block
        setupParser();
        parsing = true;
        try 
        {
            parser.parse(input);
        } //End block
        finally 
        {
            parsing = false;
        } //End block
        parsing = false;
        // ---------- Original Method ----------
        //if (parsing) {
        //throw new SAXException("Parser is already in use");
    //}
        //setupParser();
        //parsing = true;
        //try {
        //parser.parse(input);
    //} finally {
        //parsing = false;
    //}
        //parsing = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.531 -0400", hash_original_method = "88280AABBB79C1920DB5BD8874CDE919", hash_generated_method = "22207F6F6BD10F58E52B020983AF3365")
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    if(contentHandler != null)        
        {
            contentHandler.setDocumentLocator(locator);
        } //End block
        // ---------- Original Method ----------
        //this.locator = locator;
        //if (contentHandler != null) {
        //contentHandler.setDocumentLocator(locator);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.531 -0400", hash_original_method = "37B6C1FF254D8E50BAF9132487F1B989", hash_generated_method = "949316BA2419799150C9E05929EE5A17")
    public void startDocument() throws SAXException {
    if(contentHandler != null)        
        {
            contentHandler.startDocument();
        } //End block
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.startDocument();
    //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.531 -0400", hash_original_method = "B39D6D1260080244B44CBF7BC9D51D96", hash_generated_method = "83FCC356CC66A9AE6C6FC709463CAD60")
    public void endDocument() throws SAXException {
    if(contentHandler != null)        
        {
            contentHandler.endDocument();
        } //End block
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.endDocument();
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.532 -0400", hash_original_method = "41EBA2EAF373C2E18FF1DC39DB5B0A24", hash_generated_method = "7C5F5D33B68D57462B2F7F9F628ECEB5")
    public void startElement(String qName, AttributeList qAtts) throws SAXException {
        addTaint(qAtts.getTaint());
        addTaint(qName.getTaint());
        ArrayList<SAXParseException> exceptions = null;
    if(!namespaces)        
        {
    if(contentHandler != null)            
            {
                attAdapter.setAttributeList(qAtts);
                contentHandler.startElement("", "", qName.intern(),
                        attAdapter);
            } //End block
            return;
        } //End block
        nsSupport.pushContext();
        int length = qAtts.getLength();
for(int i = 0;i < length;i++)
        {
            String attQName = qAtts.getName(i);
    if(!attQName.startsWith("xmlns"))            
            continue;
            String prefix;
            int n = attQName.indexOf(':');
    if(n == -1 && attQName.length () == 5)            
            {
                prefix = "";
            } //End block
            else
    if(n != 5)            
            {
                continue;
            } //End block
            else
            prefix = attQName.substring(n+1);
            String value = qAtts.getValue(i);
    if(!nsSupport.declarePrefix(prefix, value))            
            {
                reportError("Illegal Namespace prefix: " + prefix);
                continue;
            } //End block
    if(contentHandler != null)            
            contentHandler.startPrefixMapping(prefix, value);
        } //End block
        atts.clear();
for(int i = 0;i < length;i++)
        {
            String attQName = qAtts.getName(i);
            String type = qAtts.getType(i);
            String value = qAtts.getValue(i);
    if(attQName.startsWith("xmlns"))            
            {
                String prefix;
                int n = attQName.indexOf(':');
    if(n == -1 && attQName.length () == 5)                
                {
                    prefix = "";
                } //End block
                else
    if(n != 5)                
                {
                    prefix = null;
                } //End block
                else
                {
                    prefix = attQName.substring(6);
                } //End block
    if(prefix != null)                
                {
    if(prefixes)                    
                    {
    if(uris)                        
                        atts.addAttribute (nsSupport.XMLNS, prefix,
                    attQName.intern(), type, value);
                        else
                        atts.addAttribute ("", "",
                    attQName.intern(), type, value);
                    } //End block
                    continue;
                } //End block
            } //End block
            try 
            {
                String attName[] = processName(attQName, true, true);
                atts.addAttribute(attName[0], attName[1], attName[2],
                  type, value);
            } //End block
            catch (SAXException e)
            {
    if(exceptions == null)                
                {
                    exceptions = new ArrayList<SAXParseException>();
                } //End block
                exceptions.add((SAXParseException) e);
                atts.addAttribute("", attQName, attQName, type, value);
            } //End block
        } //End block
    if(exceptions != null && errorHandler != null)        
        {
for(SAXParseException ex : exceptions)
            {
                errorHandler.error(ex);
            } //End block
        } //End block
    if(contentHandler != null)        
        {
            String name[] = processName(qName, false, false);
            contentHandler.startElement(name[0], name[1], name[2], atts);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.534 -0400", hash_original_method = "85074EE9682A2A9BF13F64A0DA58B9BC", hash_generated_method = "6C61CF59DE0A1B8FA326F42071DFCC2F")
    public void endElement(String qName) throws SAXException {
        addTaint(qName.getTaint());
    if(!namespaces)        
        {
    if(contentHandler != null)            
            {
                contentHandler.endElement("", "", qName.intern());
            } //End block
            return;
        } //End block
        String names[] = processName(qName, false, false);
    if(contentHandler != null)        
        {
            contentHandler.endElement(names[0], names[1], names[2]);
            Enumeration prefixes = nsSupport.getDeclaredPrefixes();
            while
(prefixes.hasMoreElements())            
            {
                String prefix = (String)prefixes.nextElement();
                contentHandler.endPrefixMapping(prefix);
            } //End block
        } //End block
        nsSupport.popContext();
        // ---------- Original Method ----------
        //if (!namespaces) {
        //if (contentHandler != null) {
        //contentHandler.endElement("", "", qName.intern());
        //}
        //return;
    //}
        //String names[] = processName(qName, false, false);
        //if (contentHandler != null) {
        //contentHandler.endElement(names[0], names[1], names[2]);
        //Enumeration prefixes = nsSupport.getDeclaredPrefixes();
        //while (prefixes.hasMoreElements()) {
        //String prefix = (String)prefixes.nextElement();
        //contentHandler.endPrefixMapping(prefix);
        //}
    //}
        //nsSupport.popContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.535 -0400", hash_original_method = "C666B3AD5E916677AE6610DC5A0840E2", hash_generated_method = "7C4743A88A26CA5CB6FE5806FE3C8266")
    public void characters(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
    if(contentHandler != null)        
        {
            contentHandler.characters(ch, start, length);
        } //End block
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.characters(ch, start, length);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.535 -0400", hash_original_method = "89B5E71C200F956D34BEB259DC06F56D", hash_generated_method = "512492DF26545AD44766418F2A3A5C25")
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
    if(contentHandler != null)        
        {
            contentHandler.ignorableWhitespace(ch, start, length);
        } //End block
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.ignorableWhitespace(ch, start, length);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.536 -0400", hash_original_method = "A537A06A51D1B98674021AAB895861DD", hash_generated_method = "4F16DF654657D38D7D1E20673C9D102C")
    public void processingInstruction(String target, String data) throws SAXException {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
    if(contentHandler != null)        
        {
            contentHandler.processingInstruction(target, data);
        } //End block
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.processingInstruction(target, data);
    //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.536 -0400", hash_original_method = "43648C78921975CBE3898500F19AF8D8", hash_generated_method = "55CD42B2EBE15E5D11FD1310D86F35BE")
    private void setupParser() {
    if(!prefixes && !namespaces)        
        {
        IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1410694527 = new IllegalStateException ();
        varC311A989A119B96A6232C22ABFE87C25_1410694527.addTaint(taint);
        throw varC311A989A119B96A6232C22ABFE87C25_1410694527;
        }
        nsSupport.reset();
    if(uris)        
        nsSupport.setNamespaceDeclUris (true);
    if(entityResolver != null)        
        {
            parser.setEntityResolver(entityResolver);
        } //End block
    if(dtdHandler != null)        
        {
            parser.setDTDHandler(dtdHandler);
        } //End block
    if(errorHandler != null)        
        {
            parser.setErrorHandler(errorHandler);
        } //End block
        parser.setDocumentHandler(this);
        locator = null;
        // ---------- Original Method ----------
        //if (!prefixes && !namespaces)
        //throw new IllegalStateException ();
        //nsSupport.reset();
        //if (uris)
        //nsSupport.setNamespaceDeclUris (true);
        //if (entityResolver != null) {
        //parser.setEntityResolver(entityResolver);
    //}
        //if (dtdHandler != null) {
        //parser.setDTDHandler(dtdHandler);
    //}
        //if (errorHandler != null) {
        //parser.setErrorHandler(errorHandler);
    //}
        //parser.setDocumentHandler(this);
        //locator = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.544 -0400", hash_original_method = "295B884B2E4E1E5DF2659FCF14AB7437", hash_generated_method = "A63E40ABA0ADB07D109396D7430691CA")
    private String [] processName(String qName, boolean isAttribute,
                   boolean useException) throws SAXException {
        addTaint(useException);
        addTaint(isAttribute);
        addTaint(qName.getTaint());
        String parts[] = nsSupport.processName(qName, nameParts,
                           isAttribute);
    if(parts == null)        
        {
    if(useException)            
            {
            SAXParseException var854AD97C008FC0C49293EF8835D8E041_564975120 = makeException("Undeclared prefix: " + qName);
            var854AD97C008FC0C49293EF8835D8E041_564975120.addTaint(taint);
            throw var854AD97C008FC0C49293EF8835D8E041_564975120;
            }
            reportError("Undeclared prefix: " + qName);
            parts = new String[3];
            parts[0] = parts[1] = "";
            parts[2] = qName.intern();
        } //End block
String [] var6651EAC2994005EE903B8D00ACB7442E_128503195 =         parts;
        var6651EAC2994005EE903B8D00ACB7442E_128503195.addTaint(taint);
        return var6651EAC2994005EE903B8D00ACB7442E_128503195;
        // ---------- Original Method ----------
        //String parts[] = nsSupport.processName(qName, nameParts,
                           //isAttribute);
        //if (parts == null) {
        //if (useException)
        //throw makeException("Undeclared prefix: " + qName);
        //reportError("Undeclared prefix: " + qName);
        //parts = new String[3];
        //parts[0] = parts[1] = "";
        //parts[2] = qName.intern();
    //}
        //return parts;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.544 -0400", hash_original_method = "FBBB3C346433F99D88D798BC2E1AE3CE", hash_generated_method = "26207B5932662170530D27CE0BD6E390")
     void reportError(String message) throws SAXException {
        addTaint(message.getTaint());
    if(errorHandler != null)        
        errorHandler.error(makeException(message));
        // ---------- Original Method ----------
        //if (errorHandler != null)
        //errorHandler.error(makeException(message));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.545 -0400", hash_original_method = "E1E473BD4A5E19C1B1699A01EEA95F9A", hash_generated_method = "BAA1797E7210BF7350047F4687113DF6")
    private SAXParseException makeException(String message) {
        addTaint(message.getTaint());
    if(locator != null)        
        {
SAXParseException var8CDB669EE7D22003AB805652B5D47507_1813674659 =             new SAXParseException(message, locator);
            var8CDB669EE7D22003AB805652B5D47507_1813674659.addTaint(taint);
            return var8CDB669EE7D22003AB805652B5D47507_1813674659;
        } //End block
        else
        {
SAXParseException var20635D848D8DF8DDB7580E516CF29899_684458615 =             new SAXParseException(message, null, null, -1, -1);
            var20635D848D8DF8DDB7580E516CF29899_684458615.addTaint(taint);
            return var20635D848D8DF8DDB7580E516CF29899_684458615;
        } //End block
        // ---------- Original Method ----------
        //if (locator != null) {
        //return new SAXParseException(message, locator);
    //} else {
        //return new SAXParseException(message, null, null, -1, -1);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.545 -0400", hash_original_method = "2915748C93DEC7F425A1836D3BEC9D20", hash_generated_method = "DB4F45D34B2CA7BC20BC23821FBE4764")
    private void checkNotParsing(String type, String name) throws SAXNotSupportedException {
        addTaint(name.getTaint());
        addTaint(type.getTaint());
    if(parsing)        
        {
            SAXNotSupportedException varC6565BB19F2D29A7B48343F459C158A6_2076304944 = new SAXNotSupportedException("Cannot change " +
                           type + ' ' +
                           name + " while parsing");
            varC6565BB19F2D29A7B48343F459C158A6_2076304944.addTaint(taint);
            throw varC6565BB19F2D29A7B48343F459C158A6_2076304944;
        } //End block
        // ---------- Original Method ----------
        //if (parsing) {
        //throw new SAXNotSupportedException("Cannot change " +
                           //type + ' ' +
                           //name + " while parsing");
    //}
    }

    
    final class AttributeListAdapter implements Attributes {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.545 -0400", hash_original_field = "5B2902A6669F7164A98A2AABBBA7007B", hash_generated_field = "05A4A4B78CD79FD60575BA538F5EFA68")

        private AttributeList qAtts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.546 -0400", hash_original_method = "C1264636A1B4EA8B9B687011C8022954", hash_generated_method = "27F4154408AA678EEA2C403DF40F80CC")
          AttributeListAdapter() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.546 -0400", hash_original_method = "5931F172E3791972ECDA205EAC9CCB14", hash_generated_method = "21260D7331F1562A9DF84A94008BBDC7")
         void setAttributeList(AttributeList qAtts) {
            this.qAtts = qAtts;
            // ---------- Original Method ----------
            //this.qAtts = qAtts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.546 -0400", hash_original_method = "B156048BB95084F4BF5D28EF31B66C03", hash_generated_method = "1D911A4320A7A0FA3643408FF46257C7")
        public int getLength() {
            int var903215EE1AEBF6712655753DFF3924BD_352177178 = (qAtts.getLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498950107 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498950107;
            // ---------- Original Method ----------
            //return qAtts.getLength();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.546 -0400", hash_original_method = "20CEB246971EBBCECBF2ACA441CBBECD", hash_generated_method = "2AADC537EFCD995289FE4C76DE8BBB4F")
        public String getURI(int i) {
            addTaint(i);
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_559636946 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_559636946.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_559636946;
            // ---------- Original Method ----------
            //return "";
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.547 -0400", hash_original_method = "FEDFFD9A667A49103BC32EE7ED61A0BB", hash_generated_method = "3AA38FFBAAD8800696A99FB6274D9541")
        public String getLocalName(int i) {
            addTaint(i);
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_76690995 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_76690995.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_76690995;
            // ---------- Original Method ----------
            //return "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.547 -0400", hash_original_method = "A764D8ED68137C2EBCBCEF1CD153F6C1", hash_generated_method = "E1DE738DDC184734028B3135A17482B0")
        public String getQName(int i) {
            addTaint(i);
String var326F608EE381881DD382CCFC4BA3C38B_1165462159 =             qAtts.getName(i).intern();
            var326F608EE381881DD382CCFC4BA3C38B_1165462159.addTaint(taint);
            return var326F608EE381881DD382CCFC4BA3C38B_1165462159;
            // ---------- Original Method ----------
            //return qAtts.getName(i).intern();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.547 -0400", hash_original_method = "27E76BA5C0D6AD663690DDCFFED2A8A3", hash_generated_method = "F4679AE30E2632325C59BCE68DFE4ACB")
        public String getType(int i) {
            addTaint(i);
String var3EC68ADF900B77AAFC4E9695CBE42043_1072759564 =             qAtts.getType(i).intern();
            var3EC68ADF900B77AAFC4E9695CBE42043_1072759564.addTaint(taint);
            return var3EC68ADF900B77AAFC4E9695CBE42043_1072759564;
            // ---------- Original Method ----------
            //return qAtts.getType(i).intern();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.548 -0400", hash_original_method = "F0679796EDFA7C65CB4AD5C7F9CBE1FC", hash_generated_method = "C9E9F5A9C7A7D791AF0E24E156B28BF1")
        public String getValue(int i) {
            addTaint(i);
String varC52A2AA5D53B1B5DC3D9E351EA9DC5AF_1194706710 =             qAtts.getValue(i);
            varC52A2AA5D53B1B5DC3D9E351EA9DC5AF_1194706710.addTaint(taint);
            return varC52A2AA5D53B1B5DC3D9E351EA9DC5AF_1194706710;
            // ---------- Original Method ----------
            //return qAtts.getValue(i);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.548 -0400", hash_original_method = "696F42D8785320084719A8378B03A3E8", hash_generated_method = "DE876E263161905D0AF2CA6296F4DC7C")
        public int getIndex(String uri, String localName) {
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2028133761 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142134655 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142134655;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.548 -0400", hash_original_method = "9B76649071044C2724A0BCBC3CC4F1FF", hash_generated_method = "3FD4AA88BD2D4D7BD6B23175F1330A4F")
        public int getIndex(String qName) {
            addTaint(qName.getTaint());
            int max = atts.getLength();
for(int i = 0;i < max;i++)
            {
    if(qAtts.getName(i).equals(qName))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_120867721 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345655129 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345655129;
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_410581369 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672348526 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672348526;
            // ---------- Original Method ----------
            //int max = atts.getLength();
            //for (int i = 0; i < max; i++) {
        //if (qAtts.getName(i).equals(qName)) {
            //return i;
        //}
        //}
            //return -1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.548 -0400", hash_original_method = "DB45F41F9C44849C439912CF28FC6F39", hash_generated_method = "1C7EB2383659EA7CD1B980177A6BE734")
        public String getType(String uri, String localName) {
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
String var540C13E9E156B687226421B24F2DF178_500365068 =             null;
            var540C13E9E156B687226421B24F2DF178_500365068.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_500365068;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.549 -0400", hash_original_method = "20D0A7881E2746A3B90C82673591E46C", hash_generated_method = "D4F69DE37DA70E5AB5649A43C960E086")
        public String getType(String qName) {
            addTaint(qName.getTaint());
String var6312CAB38553BB28C21F18ED3F47128A_386497452 =             qAtts.getType(qName).intern();
            var6312CAB38553BB28C21F18ED3F47128A_386497452.addTaint(taint);
            return var6312CAB38553BB28C21F18ED3F47128A_386497452;
            // ---------- Original Method ----------
            //return qAtts.getType(qName).intern();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.549 -0400", hash_original_method = "A923F17E07DEE910B88DBEE5B2421501", hash_generated_method = "65A327C5989364591B9C115F800FC721")
        public String getValue(String uri, String localName) {
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
String var540C13E9E156B687226421B24F2DF178_2104136913 =             null;
            var540C13E9E156B687226421B24F2DF178_2104136913.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2104136913;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.549 -0400", hash_original_method = "E305D94D7DAD816250B349D4183FD8D8", hash_generated_method = "C3E6150802021213BC4DAAF71E5564A7")
        public String getValue(String qName) {
            addTaint(qName.getTaint());
String var5E410604179DF5E80E22B6E7D28E329B_680167240 =             qAtts.getValue(qName);
            var5E410604179DF5E80E22B6E7D28E329B_680167240.addTaint(taint);
            return var5E410604179DF5E80E22B6E7D28E329B_680167240;
            // ---------- Original Method ----------
            //return qAtts.getValue(qName);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.549 -0400", hash_original_field = "279943BC4B6CA67AC945E5EEEAE61ADF", hash_generated_field = "7F6C469D4D388241307D7C119B45A94C")

    private static final String FEATURES = "http://xml.org/sax/features/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.549 -0400", hash_original_field = "93DBCD05F838664E2E8E2122A2491302", hash_generated_field = "01CA2984D11D1EEDC7EEEBDF3608A189")

    private static final String NAMESPACES = FEATURES + "namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.549 -0400", hash_original_field = "1C9ED1AA9E7A3DA8DA63B036DF702F8F", hash_generated_field = "1DB4D9F63D53A2D85BBF1DD847F0B1EE")

    private static final String NAMESPACE_PREFIXES = FEATURES + "namespace-prefixes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.549 -0400", hash_original_field = "61F527C036AF5AE3ABE7A1DDC88AEA80", hash_generated_field = "117F3EAB9BE6F30784F4A30F1BDC845B")

    private static final String XMLNS_URIs = FEATURES + "xmlns-uris";
}

