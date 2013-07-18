package org.xml.sax.helpers;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ParserAdapter implements XMLReader, DocumentHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.456 -0400", hash_original_field = "98AEDCDD6727BD81632D9F9CB201EE47", hash_generated_field = "E45249B9729220F661033FE0273CAECE")

    private NamespaceSupport nsSupport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.456 -0400", hash_original_field = "8E7E1A4BC0AA1454679F0E7EEA5531E9", hash_generated_field = "995A52C4CFBC84030E5C3B84FDD67C5A")

    private AttributeListAdapter attAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.456 -0400", hash_original_field = "5F5944B82735B9CF51523BBC1223615E", hash_generated_field = "B2B6F03C3323CC2E5DF880878C6AD064")

    private boolean parsing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.456 -0400", hash_original_field = "16F80F22BCD24DC823FEEA455EDB94D1", hash_generated_field = "9D06BBFBDDCCC6F79C4828C391273388")

    private String nameParts[] = new String[3];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.456 -0400", hash_original_field = "311E305FB0D751192221DEAFF834950C", hash_generated_field = "C1941098165849B9BB09C918699765BA")

    private Parser parser = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.456 -0400", hash_original_field = "8F2051083EF5F7D90FAE9F582E10ED23", hash_generated_field = "1C437322B74865B450A5CD9EA125241E")

    private AttributesImpl atts = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "312A8D34A10A42AF3135F707FD689CB4", hash_generated_field = "F2647CFF1692834895465A43B4FBE112")

    private boolean namespaces = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "466ECE05D09617567128504C4EB72E25", hash_generated_field = "3042A72B16E92F646AF269C47B7B0A4D")

    private boolean prefixes = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "1DFAA5C26271A267921178B52CA9F647", hash_generated_field = "96E23C17D2742D7559D0E0D31EA42D80")

    private boolean uris = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "AB1E07F86CA37C6521CC1969EE2AC6C9", hash_generated_field = "ACD7A3294F45ACE61F205E17A82EF3B3")

    Locator locator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "CB1E9F728CE46E75CD080A7B0788AA70", hash_generated_field = "85A3C4DFDDC2E8B053733750B1AEDE7A")

    EntityResolver entityResolver = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "4243CF9A597D079587D3CDAC53C40C0A", hash_generated_field = "36C16184E94517BCEA93A1000BB15E7B")

    DTDHandler dtdHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "B71FDAA881F7A0E3499DF3E064B2C5EC", hash_generated_field = "F44EFA80D2ED728EA2AFD1A415E0F220")

    ContentHandler contentHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_field = "A94D9C6596FCF433C6EEF597B5778A9C", hash_generated_field = "B6B9BEC6A9AF54860C9708100871418D")

    ErrorHandler errorHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.457 -0400", hash_original_method = "6A3B211FACF5438B3BC1ECD3BFD1BA43", hash_generated_method = "87DE6F3A0A862DE0DA27628E53F46676")
    public  ParserAdapter() throws SAXException {
        String driver = System.getProperty("org.xml.sax.parser");
        try 
        {
            setup(ParserFactory.makeParser());
        } //End block
        catch (ClassNotFoundException e1)
        {
            SAXException var32AA5AAF24504140370900E99D55554E_593505883 = new
        SAXException("Cannot find SAX1 driver class " +
                 driver, e1);
            var32AA5AAF24504140370900E99D55554E_593505883.addTaint(taint);
            throw var32AA5AAF24504140370900E99D55554E_593505883;
        } //End block
        catch (IllegalAccessException e2)
        {
            SAXException var0D6F9FF58A1EC2BB7449B15F0E07B5C5_1308619561 = new
        SAXException("SAX1 driver class " +
                 driver +
                 " found but cannot be loaded", e2);
            var0D6F9FF58A1EC2BB7449B15F0E07B5C5_1308619561.addTaint(taint);
            throw var0D6F9FF58A1EC2BB7449B15F0E07B5C5_1308619561;
        } //End block
        catch (InstantiationException e3)
        {
            SAXException var65044A69D1146CA706699FFA8866D0DD_1929655852 = new
        SAXException("SAX1 driver class " +
                 driver +
                 " loaded but cannot be instantiated", e3);
            var65044A69D1146CA706699FFA8866D0DD_1929655852.addTaint(taint);
            throw var65044A69D1146CA706699FFA8866D0DD_1929655852;
        } //End block
        catch (ClassCastException e4)
        {
            SAXException var04087AD61216E6C172BC51D83A8A8014_65480248 = new
        SAXException("SAX1 driver class " +
                 driver +
                 " does not implement org.xml.sax.Parser");
            var04087AD61216E6C172BC51D83A8A8014_65480248.addTaint(taint);
            throw var04087AD61216E6C172BC51D83A8A8014_65480248;
        } //End block
        catch (NullPointerException e5)
        {
            SAXException varAF40C69085E3E17FCB2CA1482DB74A32_1070907107 = new
        SAXException("System property org.xml.sax.parser not specified");
            varAF40C69085E3E17FCB2CA1482DB74A32_1070907107.addTaint(taint);
            throw varAF40C69085E3E17FCB2CA1482DB74A32_1070907107;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.458 -0400", hash_original_method = "4DBB6701F2EF3CA3BC7975B2574ABC06", hash_generated_method = "14B26D3E15032A126487D810C6ED10C5")
    public  ParserAdapter(Parser parser) {
        addTaint(parser.getTaint());
        setup(parser);
        // ---------- Original Method ----------
        //setup(parser);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.459 -0400", hash_original_method = "9AA60727AB1204C604E2657D93003A43", hash_generated_method = "F593B3CF7ED67221BDE3E10BAD85546F")
    private void setup(Parser parser) {
        if(parser == null)        
        {
            NullPointerException var70F65CFA6BBF6FCA3AE4FF616452D979_1014921602 = new
        NullPointerException("Parser argument must not be null");
            var70F65CFA6BBF6FCA3AE4FF616452D979_1014921602.addTaint(taint);
            throw var70F65CFA6BBF6FCA3AE4FF616452D979_1014921602;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.460 -0400", hash_original_method = "A3A2E58BF53A687D411A2644B8AA8600", hash_generated_method = "A5A6D70DD5FFB1E8719F2D4F83DD3018")
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
            SAXNotRecognizedException varA089E49DFCE7CCAC8AA43F2560A25520_974539771 = new SAXNotRecognizedException("Feature: " + name);
            varA089E49DFCE7CCAC8AA43F2560A25520_974539771.addTaint(taint);
            throw varA089E49DFCE7CCAC8AA43F2560A25520_974539771;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.461 -0400", hash_original_method = "894FAC8B5FEFDB9322A454DD3740A469", hash_generated_method = "0F8D42C5384B95C1A7688EE06C4B3727")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
        if(name.equals(NAMESPACES))        
        {
            boolean var3D322AF70BC106A52679F1EB72F98AE6_1291159098 = (namespaces);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216176859 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216176859;
        } //End block
        else
        if(name.equals(NAMESPACE_PREFIXES))        
        {
            boolean var735E5189FAD047C92AC9F292E73ED303_173226388 = (prefixes);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097456231 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097456231;
        } //End block
        else
        if(name.equals(XMLNS_URIs))        
        {
            boolean var7B09EE9A35BA33DA533A4D7CECA76160_714919768 = (uris);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052490019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052490019;
        } //End block
        else
        {
            SAXNotRecognizedException varA089E49DFCE7CCAC8AA43F2560A25520_1192138560 = new SAXNotRecognizedException("Feature: " + name);
            varA089E49DFCE7CCAC8AA43F2560A25520_1192138560.addTaint(taint);
            throw varA089E49DFCE7CCAC8AA43F2560A25520_1192138560;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.462 -0400", hash_original_method = "EE8A541C22360A747253892239DA9935", hash_generated_method = "26FEA8D938557A692F60F759F3EAC959")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        SAXNotRecognizedException var6728249AD760647635DFCCD62459D7C5_1121742602 = new SAXNotRecognizedException("Property: " + name);
        var6728249AD760647635DFCCD62459D7C5_1121742602.addTaint(taint);
        throw var6728249AD760647635DFCCD62459D7C5_1121742602;
        // ---------- Original Method ----------
        //throw new SAXNotRecognizedException("Property: " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.463 -0400", hash_original_method = "C44A70A290987077F2BE17BCA485ED98", hash_generated_method = "06251C92C62DA07281D8D4993D2DEF09")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
        SAXNotRecognizedException var6728249AD760647635DFCCD62459D7C5_1140150806 = new SAXNotRecognizedException("Property: " + name);
        var6728249AD760647635DFCCD62459D7C5_1140150806.addTaint(taint);
        throw var6728249AD760647635DFCCD62459D7C5_1140150806;
        // ---------- Original Method ----------
        //throw new SAXNotRecognizedException("Property: " + name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.469 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "82A21E5D6439DF297D3DDA5C9F15C57B")
    public void setEntityResolver(EntityResolver resolver) {
        entityResolver = resolver;
        // ---------- Original Method ----------
        //entityResolver = resolver;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "539A1153BD5A1E3F866A67932AD01062")
    public EntityResolver getEntityResolver() {
EntityResolver varB87C3AFF5DDB8AE3D0CC56605478B984_437091039 =         entityResolver;
        varB87C3AFF5DDB8AE3D0CC56605478B984_437091039.addTaint(taint);
        return varB87C3AFF5DDB8AE3D0CC56605478B984_437091039;
        // ---------- Original Method ----------
        //return entityResolver;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "119A8AEB4875146983459E145CF644BE", hash_generated_method = "FAA2A53872CCD36AFCB158CD655074B2")
    public void setDTDHandler(DTDHandler handler) {
        dtdHandler = handler;
        // ---------- Original Method ----------
        //dtdHandler = handler;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "9B654820D0F689CC57C439EFE3C74315")
    public DTDHandler getDTDHandler() {
DTDHandler varA6420E370A0D0E7B2C08F2BBD64CCBA1_938965769 =         dtdHandler;
        varA6420E370A0D0E7B2C08F2BBD64CCBA1_938965769.addTaint(taint);
        return varA6420E370A0D0E7B2C08F2BBD64CCBA1_938965769;
        // ---------- Original Method ----------
        //return dtdHandler;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "D8A0D6D3310208C2BEAFD8789BB430C2", hash_generated_method = "3B6BB5CD628919FBC0C763FB80D35E5E")
    public void setContentHandler(ContentHandler handler) {
        contentHandler = handler;
        // ---------- Original Method ----------
        //contentHandler = handler;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "0648A0EF88EB44B7C03930DFF59893AE", hash_generated_method = "67BB08D45807369A4B438AF6FE138D71")
    public ContentHandler getContentHandler() {
ContentHandler var9811A50DDAAFB5183DEF735850A275E7_367592089 =         contentHandler;
        var9811A50DDAAFB5183DEF735850A275E7_367592089.addTaint(taint);
        return var9811A50DDAAFB5183DEF735850A275E7_367592089;
        // ---------- Original Method ----------
        //return contentHandler;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "E6625B96D2BEDE434929849AF18BADF6")
    public void setErrorHandler(ErrorHandler handler) {
        errorHandler = handler;
        // ---------- Original Method ----------
        //errorHandler = handler;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "6EB548EAA931152469DC5E0610F9852C")
    public ErrorHandler getErrorHandler() {
ErrorHandler var814E1CB3DFFE2674E65471BBF7C52ECD_1698778810 =         errorHandler;
        var814E1CB3DFFE2674E65471BBF7C52ECD_1698778810.addTaint(taint);
        return var814E1CB3DFFE2674E65471BBF7C52ECD_1698778810;
        // ---------- Original Method ----------
        //return errorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.470 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "17B1436177E4DE56B91CAF4A0F73B451")
    public void parse(String systemId) throws IOException, SAXException {
        addTaint(systemId.getTaint());
        parse(new InputSource(systemId));
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.471 -0400", hash_original_method = "8D1EDF001F7865BC335C47DEAA91DF87", hash_generated_method = "17091238622D9AB39CFDD2F118E8C493")
    public void parse(InputSource input) throws IOException, SAXException {
        addTaint(input.getTaint());
        if(parsing)        
        {
            SAXException var3C0E4D0DD07B1683AC1481C9109F01E0_1402205356 = new SAXException("Parser is already in use");
            var3C0E4D0DD07B1683AC1481C9109F01E0_1402205356.addTaint(taint);
            throw var3C0E4D0DD07B1683AC1481C9109F01E0_1402205356;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.471 -0400", hash_original_method = "88280AABBB79C1920DB5BD8874CDE919", hash_generated_method = "22207F6F6BD10F58E52B020983AF3365")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.471 -0400", hash_original_method = "37B6C1FF254D8E50BAF9132487F1B989", hash_generated_method = "949316BA2419799150C9E05929EE5A17")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.471 -0400", hash_original_method = "B39D6D1260080244B44CBF7BC9D51D96", hash_generated_method = "83FCC356CC66A9AE6C6FC709463CAD60")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.472 -0400", hash_original_method = "41EBA2EAF373C2E18FF1DC39DB5B0A24", hash_generated_method = "7C5F5D33B68D57462B2F7F9F628ECEB5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.472 -0400", hash_original_method = "85074EE9682A2A9BF13F64A0DA58B9BC", hash_generated_method = "6C61CF59DE0A1B8FA326F42071DFCC2F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.472 -0400", hash_original_method = "C666B3AD5E916677AE6610DC5A0840E2", hash_generated_method = "7C4743A88A26CA5CB6FE5806FE3C8266")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.472 -0400", hash_original_method = "89B5E71C200F956D34BEB259DC06F56D", hash_generated_method = "512492DF26545AD44766418F2A3A5C25")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.472 -0400", hash_original_method = "A537A06A51D1B98674021AAB895861DD", hash_generated_method = "4F16DF654657D38D7D1E20673C9D102C")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.473 -0400", hash_original_method = "43648C78921975CBE3898500F19AF8D8", hash_generated_method = "C5F35A113D9586A8452E68E4F864D336")
    private void setupParser() {
        if(!prefixes && !namespaces)        
        {
        IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1268651880 = new IllegalStateException ();
        varC311A989A119B96A6232C22ABFE87C25_1268651880.addTaint(taint);
        throw varC311A989A119B96A6232C22ABFE87C25_1268651880;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.476 -0400", hash_original_method = "FBBB3C346433F99D88D798BC2E1AE3CE", hash_generated_method = "26207B5932662170530D27CE0BD6E390")
     void reportError(String message) throws SAXException {
        addTaint(message.getTaint());
        if(errorHandler != null)        
        errorHandler.error(makeException(message));
        // ---------- Original Method ----------
        //if (errorHandler != null)
        //errorHandler.error(makeException(message));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.476 -0400", hash_original_method = "E1E473BD4A5E19C1B1699A01EEA95F9A", hash_generated_method = "C0FBD2105D04EADE05B1B2DB25B78E50")
    private SAXParseException makeException(String message) {
        addTaint(message.getTaint());
        if(locator != null)        
        {
SAXParseException var8CDB669EE7D22003AB805652B5D47507_1814605581 =             new SAXParseException(message, locator);
            var8CDB669EE7D22003AB805652B5D47507_1814605581.addTaint(taint);
            return var8CDB669EE7D22003AB805652B5D47507_1814605581;
        } //End block
        else
        {
SAXParseException var20635D848D8DF8DDB7580E516CF29899_421282511 =             new SAXParseException(message, null, null, -1, -1);
            var20635D848D8DF8DDB7580E516CF29899_421282511.addTaint(taint);
            return var20635D848D8DF8DDB7580E516CF29899_421282511;
        } //End block
        // ---------- Original Method ----------
        //if (locator != null) {
        //return new SAXParseException(message, locator);
    //} else {
        //return new SAXParseException(message, null, null, -1, -1);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "2915748C93DEC7F425A1836D3BEC9D20", hash_generated_method = "0EACF1D69B56D90EF1935D58FE787729")
    private void checkNotParsing(String type, String name) throws SAXNotSupportedException {
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        if(parsing)        
        {
            SAXNotSupportedException varC6565BB19F2D29A7B48343F459C158A6_543734531 = new SAXNotSupportedException("Cannot change " +
                           type + ' ' +
                           name + " while parsing");
            varC6565BB19F2D29A7B48343F459C158A6_543734531.addTaint(taint);
            throw varC6565BB19F2D29A7B48343F459C158A6_543734531;
        } //End block
        // ---------- Original Method ----------
        //if (parsing) {
        //throw new SAXNotSupportedException("Cannot change " +
                           //type + ' ' +
                           //name + " while parsing");
    //}
    }

    
    final class AttributeListAdapter implements Attributes {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_field = "5B2902A6669F7164A98A2AABBBA7007B", hash_generated_field = "05A4A4B78CD79FD60575BA538F5EFA68")

        private AttributeList qAtts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "C1264636A1B4EA8B9B687011C8022954", hash_generated_method = "27F4154408AA678EEA2C403DF40F80CC")
          AttributeListAdapter() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "5931F172E3791972ECDA205EAC9CCB14", hash_generated_method = "21260D7331F1562A9DF84A94008BBDC7")
         void setAttributeList(AttributeList qAtts) {
            this.qAtts = qAtts;
            // ---------- Original Method ----------
            //this.qAtts = qAtts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "B156048BB95084F4BF5D28EF31B66C03", hash_generated_method = "43C1D32C0B7F2D096E73757C734072DD")
        public int getLength() {
            int var903215EE1AEBF6712655753DFF3924BD_1174925360 = (qAtts.getLength());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288506781 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288506781;
            // ---------- Original Method ----------
            //return qAtts.getLength();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "20CEB246971EBBCECBF2ACA441CBBECD", hash_generated_method = "AE939BCA804C06932238CBFB031D5B5D")
        public String getURI(int i) {
            addTaint(i);
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1525024413 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1525024413.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1525024413;
            // ---------- Original Method ----------
            //return "";
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "FEDFFD9A667A49103BC32EE7ED61A0BB", hash_generated_method = "8EDDC5B081A9F10ECA0FF6E41D5F95EA")
        public String getLocalName(int i) {
            addTaint(i);
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_242102743 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_242102743.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_242102743;
            // ---------- Original Method ----------
            //return "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "A764D8ED68137C2EBCBCEF1CD153F6C1", hash_generated_method = "E41F132B05B391005DAA83A1ADA91B49")
        public String getQName(int i) {
            addTaint(i);
String var326F608EE381881DD382CCFC4BA3C38B_2064187832 =             qAtts.getName(i).intern();
            var326F608EE381881DD382CCFC4BA3C38B_2064187832.addTaint(taint);
            return var326F608EE381881DD382CCFC4BA3C38B_2064187832;
            // ---------- Original Method ----------
            //return qAtts.getName(i).intern();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "27E76BA5C0D6AD663690DDCFFED2A8A3", hash_generated_method = "E35A465187429E9AEF2BEC74139EC484")
        public String getType(int i) {
            addTaint(i);
String var3EC68ADF900B77AAFC4E9695CBE42043_452155855 =             qAtts.getType(i).intern();
            var3EC68ADF900B77AAFC4E9695CBE42043_452155855.addTaint(taint);
            return var3EC68ADF900B77AAFC4E9695CBE42043_452155855;
            // ---------- Original Method ----------
            //return qAtts.getType(i).intern();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.477 -0400", hash_original_method = "F0679796EDFA7C65CB4AD5C7F9CBE1FC", hash_generated_method = "DBB39014ECF739CB0DC4A2C0C9DC1A20")
        public String getValue(int i) {
            addTaint(i);
String varC52A2AA5D53B1B5DC3D9E351EA9DC5AF_1627275245 =             qAtts.getValue(i);
            varC52A2AA5D53B1B5DC3D9E351EA9DC5AF_1627275245.addTaint(taint);
            return varC52A2AA5D53B1B5DC3D9E351EA9DC5AF_1627275245;
            // ---------- Original Method ----------
            //return qAtts.getValue(i);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_method = "696F42D8785320084719A8378B03A3E8", hash_generated_method = "B6EC0BDDB5CC04363038EECF5C205295")
        public int getIndex(String uri, String localName) {
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1389920013 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129488303 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129488303;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_method = "9B76649071044C2724A0BCBC3CC4F1FF", hash_generated_method = "5C24469FEF2C1E0344E157B12944460E")
        public int getIndex(String qName) {
            addTaint(qName.getTaint());
            int max = atts.getLength();
for(int i = 0;i < max;i++)
            {
                if(qAtts.getName(i).equals(qName))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_258344520 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267051721 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267051721;
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_326825282 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105835793 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105835793;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_method = "DB45F41F9C44849C439912CF28FC6F39", hash_generated_method = "34A1AC88037AEAD529E7D1E39BA418CE")
        public String getType(String uri, String localName) {
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
String var540C13E9E156B687226421B24F2DF178_48247969 =             null;
            var540C13E9E156B687226421B24F2DF178_48247969.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_48247969;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_method = "20D0A7881E2746A3B90C82673591E46C", hash_generated_method = "CA3CC3F4995E10C9A0FB5F72A223DE60")
        public String getType(String qName) {
            addTaint(qName.getTaint());
String var6312CAB38553BB28C21F18ED3F47128A_399278568 =             qAtts.getType(qName).intern();
            var6312CAB38553BB28C21F18ED3F47128A_399278568.addTaint(taint);
            return var6312CAB38553BB28C21F18ED3F47128A_399278568;
            // ---------- Original Method ----------
            //return qAtts.getType(qName).intern();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_method = "A923F17E07DEE910B88DBEE5B2421501", hash_generated_method = "34C3D66B67ADCD1C9BEC9E4C36EE1ED7")
        public String getValue(String uri, String localName) {
            addTaint(localName.getTaint());
            addTaint(uri.getTaint());
String var540C13E9E156B687226421B24F2DF178_1214281514 =             null;
            var540C13E9E156B687226421B24F2DF178_1214281514.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1214281514;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_method = "E305D94D7DAD816250B349D4183FD8D8", hash_generated_method = "671A2D7FD2C91CB8F5619B6AA341FFED")
        public String getValue(String qName) {
            addTaint(qName.getTaint());
String var5E410604179DF5E80E22B6E7D28E329B_35237220 =             qAtts.getValue(qName);
            var5E410604179DF5E80E22B6E7D28E329B_35237220.addTaint(taint);
            return var5E410604179DF5E80E22B6E7D28E329B_35237220;
            // ---------- Original Method ----------
            //return qAtts.getValue(qName);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_field = "279943BC4B6CA67AC945E5EEEAE61ADF", hash_generated_field = "7F6C469D4D388241307D7C119B45A94C")

    private static final String FEATURES = "http://xml.org/sax/features/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_field = "93DBCD05F838664E2E8E2122A2491302", hash_generated_field = "01CA2984D11D1EEDC7EEEBDF3608A189")

    private static final String NAMESPACES = FEATURES + "namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_field = "1C9ED1AA9E7A3DA8DA63B036DF702F8F", hash_generated_field = "1DB4D9F63D53A2D85BBF1DD847F0B1EE")

    private static final String NAMESPACE_PREFIXES = FEATURES + "namespace-prefixes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.478 -0400", hash_original_field = "61F527C036AF5AE3ABE7A1DDC88AEA80", hash_generated_field = "117F3EAB9BE6F30784F4A30F1BDC845B")

    private static final String XMLNS_URIs = FEATURES + "xmlns-uris";
}

