package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "98AEDCDD6727BD81632D9F9CB201EE47", hash_generated_field = "E45249B9729220F661033FE0273CAECE")

    private NamespaceSupport nsSupport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "8E7E1A4BC0AA1454679F0E7EEA5531E9", hash_generated_field = "995A52C4CFBC84030E5C3B84FDD67C5A")

    private AttributeListAdapter attAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "5F5944B82735B9CF51523BBC1223615E", hash_generated_field = "B2B6F03C3323CC2E5DF880878C6AD064")

    private boolean parsing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "16F80F22BCD24DC823FEEA455EDB94D1", hash_generated_field = "9D06BBFBDDCCC6F79C4828C391273388")

    private String nameParts[] = new String[3];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "311E305FB0D751192221DEAFF834950C", hash_generated_field = "C1941098165849B9BB09C918699765BA")

    private Parser parser = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "8F2051083EF5F7D90FAE9F582E10ED23", hash_generated_field = "1C437322B74865B450A5CD9EA125241E")

    private AttributesImpl atts = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "312A8D34A10A42AF3135F707FD689CB4", hash_generated_field = "F2647CFF1692834895465A43B4FBE112")

    private boolean namespaces = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "466ECE05D09617567128504C4EB72E25", hash_generated_field = "3042A72B16E92F646AF269C47B7B0A4D")

    private boolean prefixes = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "1DFAA5C26271A267921178B52CA9F647", hash_generated_field = "96E23C17D2742D7559D0E0D31EA42D80")

    private boolean uris = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "AB1E07F86CA37C6521CC1969EE2AC6C9", hash_generated_field = "ACD7A3294F45ACE61F205E17A82EF3B3")

    Locator locator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_field = "CB1E9F728CE46E75CD080A7B0788AA70", hash_generated_field = "85A3C4DFDDC2E8B053733750B1AEDE7A")

    EntityResolver entityResolver = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.171 -0400", hash_original_field = "4243CF9A597D079587D3CDAC53C40C0A", hash_generated_field = "36C16184E94517BCEA93A1000BB15E7B")

    DTDHandler dtdHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.171 -0400", hash_original_field = "B71FDAA881F7A0E3499DF3E064B2C5EC", hash_generated_field = "F44EFA80D2ED728EA2AFD1A415E0F220")

    ContentHandler contentHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.171 -0400", hash_original_field = "A94D9C6596FCF433C6EEF597B5778A9C", hash_generated_field = "B6B9BEC6A9AF54860C9708100871418D")

    ErrorHandler errorHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.172 -0400", hash_original_method = "6A3B211FACF5438B3BC1ECD3BFD1BA43", hash_generated_method = "8210E3990B0B2792A5A0CEBFC6CF9C89")
    public  ParserAdapter() throws SAXException {
        String driver;
        driver = System.getProperty("org.xml.sax.parser");
        try 
        {
            setup(ParserFactory.makeParser());
        } //End block
        catch (ClassNotFoundException e1)
        {
            if (DroidSafeAndroidRuntime.control) throw new
        SAXException("Cannot find SAX1 driver class " +
                 driver, e1);
        } //End block
        catch (IllegalAccessException e2)
        {
            if (DroidSafeAndroidRuntime.control) throw new
        SAXException("SAX1 driver class " +
                 driver +
                 " found but cannot be loaded", e2);
        } //End block
        catch (InstantiationException e3)
        {
            if (DroidSafeAndroidRuntime.control) throw new
        SAXException("SAX1 driver class " +
                 driver +
                 " loaded but cannot be instantiated", e3);
        } //End block
        catch (ClassCastException e4)
        {
            if (DroidSafeAndroidRuntime.control) throw new
        SAXException("SAX1 driver class " +
                 driver +
                 " does not implement org.xml.sax.Parser");
        } //End block
        catch (NullPointerException e5)
        {
            if (DroidSafeAndroidRuntime.control) throw new
        SAXException("System property org.xml.sax.parser not specified");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.174 -0400", hash_original_method = "4DBB6701F2EF3CA3BC7975B2574ABC06", hash_generated_method = "66E527D7B281C1219E9D257BFDB4DE20")
    public  ParserAdapter(Parser parser) {
        setup(parser);
        addTaint(parser.getTaint());
        // ---------- Original Method ----------
        //setup(parser);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.175 -0400", hash_original_method = "9AA60727AB1204C604E2657D93003A43", hash_generated_method = "BEDFB709822D2685EB21C08432C6E611")
    private void setup(Parser parser) {
        {
            if (DroidSafeAndroidRuntime.control) throw new
        NullPointerException("Parser argument must not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.176 -0400", hash_original_method = "A3A2E58BF53A687D411A2644B8AA8600", hash_generated_method = "C52C48FBEBAAF5D2B548145AA79DF242")
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            boolean varA8AE3CDBC337136FCE698D887F3BB132_1099637047 = (name.equals(NAMESPACES));
            {
                checkNotParsing("feature", name);
                namespaces = value;
                {
                    prefixes = true;
                } //End block
            } //End block
            {
                boolean var9778CF62FC558BEC33CA1AB7CC445FA1_1736801338 = (name.equals(NAMESPACE_PREFIXES));
                {
                    checkNotParsing("feature", name);
                    prefixes = value;
                    {
                        namespaces = true;
                    } //End block
                } //End block
                {
                    boolean var61306608BD21C37169931CE569F81C64_1560202767 = (name.equals(XMLNS_URIs));
                    {
                        checkNotParsing("feature", name);
                        uris = value;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Feature: " + name);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.177 -0400", hash_original_method = "894FAC8B5FEFDB9322A454DD3740A469", hash_generated_method = "A1E5E53F15451861FD2A335D1AF428FA")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            boolean varA8AE3CDBC337136FCE698D887F3BB132_788532544 = (name.equals(NAMESPACES));
            {
                boolean var9778CF62FC558BEC33CA1AB7CC445FA1_297617738 = (name.equals(NAMESPACE_PREFIXES));
                {
                    boolean var61306608BD21C37169931CE569F81C64_50292013 = (name.equals(XMLNS_URIs));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Feature: " + name);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158023591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158023591;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.177 -0400", hash_original_method = "EE8A541C22360A747253892239DA9935", hash_generated_method = "BCFEF00C32C22FE1A573F22ECEE0B1D0")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Property: " + name);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new SAXNotRecognizedException("Property: " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.177 -0400", hash_original_method = "C44A70A290987077F2BE17BCA485ED98", hash_generated_method = "4EEA4E3217A4E62B208725EFC8A4A5BD")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Property: " + name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //throw new SAXNotRecognizedException("Property: " + name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.181 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "82A21E5D6439DF297D3DDA5C9F15C57B")
    public void setEntityResolver(EntityResolver resolver) {
        entityResolver = resolver;
        // ---------- Original Method ----------
        //entityResolver = resolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.182 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "EFB709969656DA05F779EEBA5FBCB2E7")
    public EntityResolver getEntityResolver() {
        EntityResolver varB4EAC82CA7396A68D541C85D26508E83_1385211714 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1385211714 = entityResolver;
        varB4EAC82CA7396A68D541C85D26508E83_1385211714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385211714;
        // ---------- Original Method ----------
        //return entityResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.196 -0400", hash_original_method = "119A8AEB4875146983459E145CF644BE", hash_generated_method = "FAA2A53872CCD36AFCB158CD655074B2")
    public void setDTDHandler(DTDHandler handler) {
        dtdHandler = handler;
        // ---------- Original Method ----------
        //dtdHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.199 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "26A3AE6CF1DE63250358AE3F02012D00")
    public DTDHandler getDTDHandler() {
        DTDHandler varB4EAC82CA7396A68D541C85D26508E83_1880703272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1880703272 = dtdHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1880703272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880703272;
        // ---------- Original Method ----------
        //return dtdHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.199 -0400", hash_original_method = "D8A0D6D3310208C2BEAFD8789BB430C2", hash_generated_method = "3B6BB5CD628919FBC0C763FB80D35E5E")
    public void setContentHandler(ContentHandler handler) {
        contentHandler = handler;
        // ---------- Original Method ----------
        //contentHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.200 -0400", hash_original_method = "0648A0EF88EB44B7C03930DFF59893AE", hash_generated_method = "7CF29B8A7FDC834560B9155563AA8412")
    public ContentHandler getContentHandler() {
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_494110699 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_494110699 = contentHandler;
        varB4EAC82CA7396A68D541C85D26508E83_494110699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_494110699;
        // ---------- Original Method ----------
        //return contentHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.200 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "E6625B96D2BEDE434929849AF18BADF6")
    public void setErrorHandler(ErrorHandler handler) {
        errorHandler = handler;
        // ---------- Original Method ----------
        //errorHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.200 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "28C2E82A6EF9499BD3272F8CE99B8D95")
    public ErrorHandler getErrorHandler() {
        ErrorHandler varB4EAC82CA7396A68D541C85D26508E83_1249345771 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1249345771 = errorHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1249345771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1249345771;
        // ---------- Original Method ----------
        //return errorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.200 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "7C46E33FDC82E8D9EBC2B1667B1FD4B6")
    public void parse(String systemId) throws IOException, SAXException {
        parse(new InputSource(systemId));
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.205 -0400", hash_original_method = "8D1EDF001F7865BC335C47DEAA91DF87", hash_generated_method = "1223902E7BEAF9311E055CDC616F5B58")
    public void parse(InputSource input) throws IOException, SAXException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXException("Parser is already in use");
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
        addTaint(input.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.206 -0400", hash_original_method = "88280AABBB79C1920DB5BD8874CDE919", hash_generated_method = "EFA3F4DDF2C5DF769B3CAA705F7211C2")
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
        {
            contentHandler.setDocumentLocator(locator);
        } //End block
        // ---------- Original Method ----------
        //this.locator = locator;
        //if (contentHandler != null) {
        //contentHandler.setDocumentLocator(locator);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.206 -0400", hash_original_method = "37B6C1FF254D8E50BAF9132487F1B989", hash_generated_method = "190FFA064D26551F673D4DE17E0F4DD6")
    public void startDocument() throws SAXException {
        {
            contentHandler.startDocument();
        } //End block
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.startDocument();
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.206 -0400", hash_original_method = "B39D6D1260080244B44CBF7BC9D51D96", hash_generated_method = "81E91320538B41CBB1E06BDD5F1867D3")
    public void endDocument() throws SAXException {
        {
            contentHandler.endDocument();
        } //End block
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.endDocument();
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.336 -0400", hash_original_method = "41EBA2EAF373C2E18FF1DC39DB5B0A24", hash_generated_method = "1B5D2AB14D0A56915DCE9B38B429C2CA")
    public void startElement(String qName, AttributeList qAtts) throws SAXException {
        ArrayList<SAXParseException> exceptions;
        exceptions = null;
        {
            {
                attAdapter.setAttributeList(qAtts);
                contentHandler.startElement("", "", qName.intern(),
                        attAdapter);
            } //End block
        } //End block
        nsSupport.pushContext();
        int length;
        length = qAtts.getLength();
        {
            int i;
            i = 0;
            {
                String attQName;
                attQName = qAtts.getName(i);
                {
                    boolean var66481A3EA056E3438D97B8AEFE0A5D64_409905933 = (!attQName.startsWith("xmlns"));
                } //End collapsed parenthetic
                String prefix;
                int n;
                n = attQName.indexOf(':');
                {
                    boolean var0D527FE2FAF9E405A8BE80B87E481320_1957867433 = (n == -1 && attQName.length () == 5);
                    {
                        prefix = "";
                    } //End block
                    prefix = attQName.substring(n+1);
                } //End collapsed parenthetic
                String value;
                value = qAtts.getValue(i);
                {
                    boolean var8249EA357DE18E6CB4DAAF538C100257_1548161772 = (!nsSupport.declarePrefix(prefix, value));
                    {
                        reportError("Illegal Namespace prefix: " + prefix);
                    } //End block
                } //End collapsed parenthetic
                contentHandler.startPrefixMapping(prefix, value);
            } //End block
        } //End collapsed parenthetic
        atts.clear();
        {
            int i;
            i = 0;
            {
                String attQName;
                attQName = qAtts.getName(i);
                String type;
                type = qAtts.getType(i);
                String value;
                value = qAtts.getValue(i);
                {
                    boolean var1379EA0145545930F593C0164FF520F7_1432690783 = (attQName.startsWith("xmlns"));
                    {
                        String prefix;
                        int n;
                        n = attQName.indexOf(':');
                        {
                            boolean var502A678EB9E6ADBB52537AE7CD55E53E_161873847 = (n == -1 && attQName.length () == 5);
                            {
                                prefix = "";
                            } //End block
                            {
                                prefix = null;
                            } //End block
                            {
                                prefix = attQName.substring(6);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            {
                                atts.addAttribute (nsSupport.XMLNS, prefix,
                    attQName.intern(), type, value);
                                atts.addAttribute ("", "",
                    attQName.intern(), type, value);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                try 
                {
                    String attName[];
                    attName = processName(attQName, true, true);
                    atts.addAttribute(attName[0], attName[1], attName[2],
                  type, value);
                } //End block
                catch (SAXException e)
                {
                    {
                        exceptions = new ArrayList<SAXParseException>();
                    } //End block
                    exceptions.add((SAXParseException) e);
                    atts.addAttribute("", attQName, attQName, type, value);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                Iterator<SAXParseException> varAA07C29773F3EE28B897516093F89E03_1721328314 = (exceptions).iterator();
                varAA07C29773F3EE28B897516093F89E03_1721328314.hasNext();
                SAXParseException ex = varAA07C29773F3EE28B897516093F89E03_1721328314.next();
                {
                    errorHandler.error(ex);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            String name[];
            name = processName(qName, false, false);
            contentHandler.startElement(name[0], name[1], name[2], atts);
        } //End block
        addTaint(qName.getTaint());
        addTaint(qAtts.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.340 -0400", hash_original_method = "85074EE9682A2A9BF13F64A0DA58B9BC", hash_generated_method = "89FF0398D67A7BE6EF7D06F172BD3098")
    public void endElement(String qName) throws SAXException {
        {
            {
                contentHandler.endElement("", "", qName.intern());
            } //End block
        } //End block
        String names[];
        names = processName(qName, false, false);
        {
            contentHandler.endElement(names[0], names[1], names[2]);
            Enumeration prefixes;
            prefixes = nsSupport.getDeclaredPrefixes();
            {
                boolean var53D5B1DEBA81D6A12DC629F14E13F948_610580554 = (prefixes.hasMoreElements());
                {
                    String prefix;
                    prefix = (String)prefixes.nextElement();
                    contentHandler.endPrefixMapping(prefix);
                } //End block
            } //End collapsed parenthetic
        } //End block
        nsSupport.popContext();
        addTaint(qName.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.340 -0400", hash_original_method = "C666B3AD5E916677AE6610DC5A0840E2", hash_generated_method = "EBCF8F6AACE2B2E313833B988F7557BD")
    public void characters(char ch[], int start, int length) throws SAXException {
        {
            contentHandler.characters(ch, start, length);
        } //End block
        addTaint(ch);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.characters(ch, start, length);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.345 -0400", hash_original_method = "89B5E71C200F956D34BEB259DC06F56D", hash_generated_method = "3B2CBB81B0EF8711C89B9782E7F690D0")
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
        {
            contentHandler.ignorableWhitespace(ch, start, length);
        } //End block
        addTaint(ch);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.ignorableWhitespace(ch, start, length);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.346 -0400", hash_original_method = "A537A06A51D1B98674021AAB895861DD", hash_generated_method = "DA57D77F0A582846D363C3D5913E1CDB")
    public void processingInstruction(String target, String data) throws SAXException {
        {
            contentHandler.processingInstruction(target, data);
        } //End block
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //if (contentHandler != null) {
        //contentHandler.processingInstruction(target, data);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.352 -0400", hash_original_method = "43648C78921975CBE3898500F19AF8D8", hash_generated_method = "CC6DF6D5DE4176F8D9708396EF597B2A")
    private void setupParser() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException ();
        nsSupport.reset();
        nsSupport.setNamespaceDeclUris (true);
        {
            parser.setEntityResolver(entityResolver);
        } //End block
        {
            parser.setDTDHandler(dtdHandler);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.356 -0400", hash_original_method = "295B884B2E4E1E5DF2659FCF14AB7437", hash_generated_method = "62AB8110CCBEA81B2DE3BE9AA8037A78")
    private String [] processName(String qName, boolean isAttribute,
                   boolean useException) throws SAXException {
        String [] varB4EAC82CA7396A68D541C85D26508E83_273716008 = null; //Variable for return #1
        String parts[];
        parts = nsSupport.processName(qName, nameParts,
                           isAttribute);
        {
            if (DroidSafeAndroidRuntime.control) throw makeException("Undeclared prefix: " + qName);
            reportError("Undeclared prefix: " + qName);
            parts = new String[3];
            parts[0] = parts[1] = "";
            parts[2] = qName.intern();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_273716008 = parts;
        addTaint(qName.getTaint());
        addTaint(isAttribute);
        addTaint(useException);
        varB4EAC82CA7396A68D541C85D26508E83_273716008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_273716008;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.357 -0400", hash_original_method = "FBBB3C346433F99D88D798BC2E1AE3CE", hash_generated_method = "E30491B49044401E1793F35D1A8C0572")
     void reportError(String message) throws SAXException {
        errorHandler.error(makeException(message));
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //if (errorHandler != null)
        //errorHandler.error(makeException(message));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.364 -0400", hash_original_method = "E1E473BD4A5E19C1B1699A01EEA95F9A", hash_generated_method = "5D05DF9F11DFC9ADA1D28E010FFC842C")
    private SAXParseException makeException(String message) {
        SAXParseException varB4EAC82CA7396A68D541C85D26508E83_1824948407 = null; //Variable for return #1
        SAXParseException varB4EAC82CA7396A68D541C85D26508E83_1695583839 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1824948407 = new SAXParseException(message, locator);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1695583839 = new SAXParseException(message, null, null, -1, -1);
        } //End block
        addTaint(message.getTaint());
        SAXParseException varA7E53CE21691AB073D9660D615818899_780935415; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_780935415 = varB4EAC82CA7396A68D541C85D26508E83_1824948407;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_780935415 = varB4EAC82CA7396A68D541C85D26508E83_1695583839;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_780935415.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_780935415;
        // ---------- Original Method ----------
        //if (locator != null) {
        //return new SAXParseException(message, locator);
    //} else {
        //return new SAXParseException(message, null, null, -1, -1);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.368 -0400", hash_original_method = "2915748C93DEC7F425A1836D3BEC9D20", hash_generated_method = "D1C76488449591699D612CA4CE5044E7")
    private void checkNotParsing(String type, String name) throws SAXNotSupportedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Cannot change " +
                           type + ' ' +
                           name + " while parsing");
        } //End block
        addTaint(type.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (parsing) {
        //throw new SAXNotSupportedException("Cannot change " +
                           //type + ' ' +
                           //name + " while parsing");
    //}
    }

    
    final class AttributeListAdapter implements Attributes {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.377 -0400", hash_original_field = "5B2902A6669F7164A98A2AABBBA7007B", hash_generated_field = "05A4A4B78CD79FD60575BA538F5EFA68")

        private AttributeList qAtts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.377 -0400", hash_original_method = "C1264636A1B4EA8B9B687011C8022954", hash_generated_method = "27F4154408AA678EEA2C403DF40F80CC")
          AttributeListAdapter() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.378 -0400", hash_original_method = "5931F172E3791972ECDA205EAC9CCB14", hash_generated_method = "21260D7331F1562A9DF84A94008BBDC7")
         void setAttributeList(AttributeList qAtts) {
            this.qAtts = qAtts;
            // ---------- Original Method ----------
            //this.qAtts = qAtts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.378 -0400", hash_original_method = "B156048BB95084F4BF5D28EF31B66C03", hash_generated_method = "7D149650D6B050E500E5E9087D872062")
        public int getLength() {
            int varD76DF4418194B916F6E20B153E04BB14_866410939 = (qAtts.getLength());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705635175 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705635175;
            // ---------- Original Method ----------
            //return qAtts.getLength();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.378 -0400", hash_original_method = "20CEB246971EBBCECBF2ACA441CBBECD", hash_generated_method = "0633E7EA7F12AA2B819C44DE8E79C207")
        public String getURI(int i) {
            String varB4EAC82CA7396A68D541C85D26508E83_697222928 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_697222928 = "";
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_697222928.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_697222928;
            // ---------- Original Method ----------
            //return "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.379 -0400", hash_original_method = "FEDFFD9A667A49103BC32EE7ED61A0BB", hash_generated_method = "8961114B24086B0B9A497F0626D52691")
        public String getLocalName(int i) {
            String varB4EAC82CA7396A68D541C85D26508E83_437858582 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_437858582 = "";
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_437858582.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_437858582;
            // ---------- Original Method ----------
            //return "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.379 -0400", hash_original_method = "A764D8ED68137C2EBCBCEF1CD153F6C1", hash_generated_method = "18781BCE68F45AABF06E412A23D3CCA3")
        public String getQName(int i) {
            String varB4EAC82CA7396A68D541C85D26508E83_1455005335 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1455005335 = qAtts.getName(i).intern();
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_1455005335.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1455005335;
            // ---------- Original Method ----------
            //return qAtts.getName(i).intern();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.381 -0400", hash_original_method = "27E76BA5C0D6AD663690DDCFFED2A8A3", hash_generated_method = "7BE4EBF915F9C4319729FD1483B97994")
        public String getType(int i) {
            String varB4EAC82CA7396A68D541C85D26508E83_1887892815 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1887892815 = qAtts.getType(i).intern();
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_1887892815.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1887892815;
            // ---------- Original Method ----------
            //return qAtts.getType(i).intern();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.383 -0400", hash_original_method = "F0679796EDFA7C65CB4AD5C7F9CBE1FC", hash_generated_method = "25ED85452CD8D1FDB0D1598604D6385E")
        public String getValue(int i) {
            String varB4EAC82CA7396A68D541C85D26508E83_1935974656 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1935974656 = qAtts.getValue(i);
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_1935974656.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1935974656;
            // ---------- Original Method ----------
            //return qAtts.getValue(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.383 -0400", hash_original_method = "696F42D8785320084719A8378B03A3E8", hash_generated_method = "9F976898A87E850D8F0426A2B521575F")
        public int getIndex(String uri, String localName) {
            addTaint(uri.getTaint());
            addTaint(localName.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129437247 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129437247;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.383 -0400", hash_original_method = "9B76649071044C2724A0BCBC3CC4F1FF", hash_generated_method = "72A8C02654F9193EEE5781D7BE030AA2")
        public int getIndex(String qName) {
            int max;
            max = atts.getLength();
            {
                int i;
                i = 0;
                {
                    {
                        boolean varE315FB12CDCA66D13110B50B7AC158F1_770994872 = (qAtts.getName(i).equals(qName));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(qName.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654342916 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654342916;
            // ---------- Original Method ----------
            //int max = atts.getLength();
            //for (int i = 0; i < max; i++) {
        //if (qAtts.getName(i).equals(qName)) {
            //return i;
        //}
        //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.384 -0400", hash_original_method = "DB45F41F9C44849C439912CF28FC6F39", hash_generated_method = "F8FEC5C3C5368A2A17E3AC3E570F7CDE")
        public String getType(String uri, String localName) {
            String varB4EAC82CA7396A68D541C85D26508E83_23857254 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_23857254 = null;
            addTaint(uri.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_23857254.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_23857254;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.385 -0400", hash_original_method = "20D0A7881E2746A3B90C82673591E46C", hash_generated_method = "4DFBF2B8D634AEFC88EFA822644D815F")
        public String getType(String qName) {
            String varB4EAC82CA7396A68D541C85D26508E83_757419355 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_757419355 = qAtts.getType(qName).intern();
            addTaint(qName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_757419355.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_757419355;
            // ---------- Original Method ----------
            //return qAtts.getType(qName).intern();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.385 -0400", hash_original_method = "A923F17E07DEE910B88DBEE5B2421501", hash_generated_method = "0E90B5298D565B0B94A3C0A240F9BA3E")
        public String getValue(String uri, String localName) {
            String varB4EAC82CA7396A68D541C85D26508E83_1546392294 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1546392294 = null;
            addTaint(uri.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1546392294.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1546392294;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.386 -0400", hash_original_method = "E305D94D7DAD816250B349D4183FD8D8", hash_generated_method = "0E37A42F260356D4BA21C45639721E4A")
        public String getValue(String qName) {
            String varB4EAC82CA7396A68D541C85D26508E83_293129292 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_293129292 = qAtts.getValue(qName);
            addTaint(qName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_293129292.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_293129292;
            // ---------- Original Method ----------
            //return qAtts.getValue(qName);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.386 -0400", hash_original_field = "279943BC4B6CA67AC945E5EEEAE61ADF", hash_generated_field = "3D49FFA4708DD1CD0DEC882511BDA509")

    private static String FEATURES = "http://xml.org/sax/features/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.386 -0400", hash_original_field = "93DBCD05F838664E2E8E2122A2491302", hash_generated_field = "8F2E25C8BAB2F51406971087AA0E8265")

    private static String NAMESPACES = FEATURES + "namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.386 -0400", hash_original_field = "1C9ED1AA9E7A3DA8DA63B036DF702F8F", hash_generated_field = "2CE5D05560BA946B8628BF26DFAFDDE6")

    private static String NAMESPACE_PREFIXES = FEATURES + "namespace-prefixes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.386 -0400", hash_original_field = "61F527C036AF5AE3ABE7A1DDC88AEA80", hash_generated_field = "FA11507761121A39A58B2107A1756689")

    private static String XMLNS_URIs = FEATURES + "xmlns-uris";
}

