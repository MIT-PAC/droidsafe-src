package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ext.LexicalHandler;

public class Parser extends DefaultHandler implements ScanHandler, XMLReader, LexicalHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "E14ACAA95F0ECE7CA53A254FD0FCEE26", hash_generated_field = "4F44CE27A3793F7751E9A2BE62EDA28B")

    private ContentHandler theContentHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "EEA5C4C914011D6FF7FEF9691FD2DE4F", hash_generated_field = "157ADCC7E3B0E4B62A86EF5B1464D34C")

    private LexicalHandler theLexicalHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "339C5D0C3EB24FAAA4930D9ECE8DE761", hash_generated_field = "0250A3E49B4EA1CD2D0A995FF5246D28")

    private DTDHandler theDTDHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "352A6506BD0383F0B38ED5037A15FDB2", hash_generated_field = "5096464DD0A69980B0EFE4F51A07D7A0")

    private ErrorHandler theErrorHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "E8D20D7217E7893F63ECAAD895343E33", hash_generated_field = "1DF35A9855CF0F5158EC878850EAD218")

    private EntityResolver theEntityResolver = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "107D6A6C40AD2744AB6BBBE303D4ACFB", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

    private Schema theSchema;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "B2BDB1731B79F924A65430D31A6CF9EE", hash_generated_field = "4E761DBCC8A2988ECAB555C68CB8DEB1")

    private Scanner theScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "44886C30A8A3125C88734F69BA48C0D1", hash_generated_field = "996675C96C2397ADFF11AC882B20B3F5")

    private AutoDetector theAutoDetector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "136D76008DD364C60C97C06548516C6B", hash_generated_field = "22AE333EFBA532959473DE818E24D5BF")

    private boolean namespaces = DEFAULT_NAMESPACES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "B8969EB270970487395879B1791569E5", hash_generated_field = "41E62687D64F8450440F589FD8B2C7D2")

    private boolean ignoreBogons = DEFAULT_IGNORE_BOGONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.318 -0400", hash_original_field = "F3F0E47E9E32971F9497C16BCA9AFDD2", hash_generated_field = "E4FAEC9CF3158B00C3F5BBDEDAC38D80")

    private boolean bogonsEmpty = DEFAULT_BOGONS_EMPTY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "6850604F609C324B81A85ADDF0D7E059", hash_generated_field = "A54F1F17D7ADCFC60A15857E1F85FF45")

    private boolean rootBogons = DEFAULT_ROOT_BOGONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "A21DB2DBAD01F7F074D614EF627C1A33", hash_generated_field = "7E383F84EDB4881461124E7E7AB52091")

    private boolean defaultAttributes = DEFAULT_DEFAULT_ATTRIBUTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "BA9B87A15B95466220E3570EA9662C82", hash_generated_field = "54CF914E3DF3C6BA59447DE81000C1D8")

    private boolean translateColons = DEFAULT_TRANSLATE_COLONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "306B4CE43758B73F2FC233095E71EF22", hash_generated_field = "B712CFA3553BE13E45826B673C86681F")

    private boolean restartElements = DEFAULT_RESTART_ELEMENTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "025256159E2BABE1BC18E52DAE46AF57", hash_generated_field = "78FB9F9549B57ED6D280AA8E51B31437")

    private boolean ignorableWhitespace = DEFAULT_IGNORABLE_WHITESPACE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "8A07730721F622E2BE6D01635DEEC33C", hash_generated_field = "6315C4913628D4F5D0A650689FEE53F5")

    private boolean CDATAElements = DEFAULT_CDATA_ELEMENTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "982778EB7D40A5EDFE53E3024952EF4C", hash_generated_field = "914C35307726F423CC214D5F05BD1792")

    private HashMap theFeatures = new HashMap();
    {
		theFeatures.put(namespacesFeature, truthValue(DEFAULT_NAMESPACES));
		theFeatures.put(namespacePrefixesFeature, Boolean.FALSE);
		theFeatures.put(externalGeneralEntitiesFeature, Boolean.FALSE);
		theFeatures.put(externalParameterEntitiesFeature, Boolean.FALSE);
		theFeatures.put(isStandaloneFeature, Boolean.FALSE);
		theFeatures.put(lexicalHandlerParameterEntitiesFeature,
			Boolean.FALSE);
		theFeatures.put(resolveDTDURIsFeature, Boolean.TRUE);
		theFeatures.put(stringInterningFeature, Boolean.TRUE);
		theFeatures.put(useAttributes2Feature, Boolean.FALSE);
		theFeatures.put(useLocator2Feature, Boolean.FALSE);
		theFeatures.put(useEntityResolver2Feature, Boolean.FALSE);
		theFeatures.put(validationFeature, Boolean.FALSE);
		theFeatures.put(xmlnsURIsFeature, Boolean.FALSE);
		theFeatures.put(xmlnsURIsFeature, Boolean.FALSE);
		theFeatures.put(XML11Feature, Boolean.FALSE);
		theFeatures.put(ignoreBogonsFeature, truthValue(DEFAULT_IGNORE_BOGONS));
		theFeatures.put(bogonsEmptyFeature, truthValue(DEFAULT_BOGONS_EMPTY));
		theFeatures.put(rootBogonsFeature, truthValue(DEFAULT_ROOT_BOGONS));
		theFeatures.put(defaultAttributesFeature, truthValue(DEFAULT_DEFAULT_ATTRIBUTES));
		theFeatures.put(translateColonsFeature, truthValue(DEFAULT_TRANSLATE_COLONS));
		theFeatures.put(restartElementsFeature, truthValue(DEFAULT_RESTART_ELEMENTS));
		theFeatures.put(ignorableWhitespaceFeature, truthValue(DEFAULT_IGNORABLE_WHITESPACE));
		theFeatures.put(CDATAElementsFeature, truthValue(DEFAULT_CDATA_ELEMENTS));
		}
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "FEE896B51F9EA9C3A6A2CACA78327B0B", hash_generated_field = "F665FAD1114786BD257F52AD4EA88050")

    private Element theNewElement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "B6EC96894CDD9EABA41D9A85987A021F", hash_generated_field = "3971348F960D66262BE9AAD85DDDAD51")

    private String theAttributeName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "4BE6E9F25C27D2D7A70C3064273D8021", hash_generated_field = "16F18AE13D1847204B3580570C01FD87")

    private boolean theDoctypeIsPresent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "C34118D8631D4E0CBDC1F27A585914B6", hash_generated_field = "94C2B01EF19C224943FE0663341AF33A")

    private String theDoctypePublicId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "4C917A66C9A4161093180E54D763151C", hash_generated_field = "0B8C1584143BEE93C46504097391530E")

    private String theDoctypeSystemId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "CE0F52CFB2F54C4AD7E9126D01BD5B60", hash_generated_field = "247F70B5D7C6F8B059A348D2387FBC13")

    private String theDoctypeName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "15E4A39D4B3ED29C59EB47338F66FF11", hash_generated_field = "080BFB2033564D1CB69BD1F7C08184D6")

    private String thePITarget = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "8CCAE25BBDA5BC0AF71EFBA782D14594", hash_generated_field = "43C38F93E7447D1ED933F58636348D3D")

    private Element theStack = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "2F5CD5EF76ECA64E8FF917FDFE4D715C", hash_generated_field = "C6DD2154E4DDD283E34159243942ADBC")

    private Element theSaved = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.319 -0400", hash_original_field = "F10E624D97E7893D5B1AB4FA6E197997", hash_generated_field = "697A580E609D0A168C8A8EB97FAF20FE")

    private Element thePCDATA = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.320 -0400", hash_original_field = "BF8C9B53F357D8AF6BEEE753391E3CBC", hash_generated_field = "15E2820171C06161A279611A152EA754")

    private int theEntity = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.320 -0400", hash_original_field = "E5F3558DE98E5F834B93385EBD5FF568", hash_generated_field = "C5A55747785458B1F50A346028B62596")

    private boolean virginStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.320 -0400", hash_original_field = "281067624171488397F98EDFDC0B72F1", hash_generated_field = "36FBB60F8B3CE9EA610621F518B77851")

    private char[] theCommentBuffer = new char[2000];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.320 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
    private static Boolean truthValue(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.320 -0400", hash_original_method = "FDD541AC7ACF46AD908991FDB1EF4671", hash_generated_method = "F5BC7982C8717D792A6525AFA98D577F")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
        Boolean b = (Boolean)theFeatures.get(name);
    if(b == null)        
        {
            SAXNotRecognizedException var6EBAA7E3A3D2D808547E798D5F69D94F_1940682742 = new SAXNotRecognizedException("Unknown feature " + name);
            var6EBAA7E3A3D2D808547E798D5F69D94F_1940682742.addTaint(taint);
            throw var6EBAA7E3A3D2D808547E798D5F69D94F_1940682742;
        } //End block
        boolean varF4FFBE63F5E4C35F6F0DDAF736B6497E_923301044 = (b.booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043935321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043935321;
        // ---------- Original Method ----------
        //Boolean b = (Boolean)theFeatures.get(name);
        //if (b == null) {
			//throw new SAXNotRecognizedException("Unknown feature " + name);
			//}
        //return b.booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.322 -0400", hash_original_method = "DD81CF03E95A92E28D68E44755507EB5", hash_generated_method = "3E315AE6DFB633C92C8D9828008DA381")
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
        Boolean b = (Boolean)theFeatures.get(name);
    if(b == null)        
        {
            SAXNotRecognizedException var6EBAA7E3A3D2D808547E798D5F69D94F_71035713 = new SAXNotRecognizedException("Unknown feature " + name);
            var6EBAA7E3A3D2D808547E798D5F69D94F_71035713.addTaint(taint);
            throw var6EBAA7E3A3D2D808547E798D5F69D94F_71035713;
        } //End block
    if(value)        
        theFeatures.put(name, Boolean.TRUE);
        else
        theFeatures.put(name, Boolean.FALSE);
    if(name.equals(namespacesFeature))        
        namespaces = value;
        else
    if(name.equals(ignoreBogonsFeature))        
        ignoreBogons = value;
        else
    if(name.equals(bogonsEmptyFeature))        
        bogonsEmpty = value;
        else
    if(name.equals(rootBogonsFeature))        
        rootBogons = value;
        else
    if(name.equals(defaultAttributesFeature))        
        defaultAttributes = value;
        else
    if(name.equals(translateColonsFeature))        
        translateColons = value;
        else
    if(name.equals(restartElementsFeature))        
        restartElements = value;
        else
    if(name.equals(ignorableWhitespaceFeature))        
        ignorableWhitespace = value;
        else
    if(name.equals(CDATAElementsFeature))        
        CDATAElements = value;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.323 -0400", hash_original_method = "F750AD287EF0AB9FAAF84C1118421011", hash_generated_method = "23404C5AB1D832E22C104900463273BC")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name.equals(lexicalHandlerProperty))        
        {
Object var331F1C3E763B7295E167363A73999C53_1538943712 =             theLexicalHandler == this ? null : theLexicalHandler;
            var331F1C3E763B7295E167363A73999C53_1538943712.addTaint(taint);
            return var331F1C3E763B7295E167363A73999C53_1538943712;
        } //End block
        else
    if(name.equals(scannerProperty))        
        {
Object var3239B8F0F7F40412BBD926FC0D39D94F_648450403 =             theScanner;
            var3239B8F0F7F40412BBD926FC0D39D94F_648450403.addTaint(taint);
            return var3239B8F0F7F40412BBD926FC0D39D94F_648450403;
        } //End block
        else
    if(name.equals(schemaProperty))        
        {
Object varF1B5508E6B3CF9213428E6D6136C1D0E_85310847 =             theSchema;
            varF1B5508E6B3CF9213428E6D6136C1D0E_85310847.addTaint(taint);
            return varF1B5508E6B3CF9213428E6D6136C1D0E_85310847;
        } //End block
        else
    if(name.equals(autoDetectorProperty))        
        {
Object varD4054F34FCEDCED3102672B633AE76D0_189718781 =             theAutoDetector;
            varD4054F34FCEDCED3102672B633AE76D0_189718781.addTaint(taint);
            return varD4054F34FCEDCED3102672B633AE76D0_189718781;
        } //End block
        else
        {
            SAXNotRecognizedException var3F84AAC3A4C6C6F40D35C717D02A61A6_913574043 = new SAXNotRecognizedException("Unknown property " + name);
            var3F84AAC3A4C6C6F40D35C717D02A61A6_913574043.addTaint(taint);
            throw var3F84AAC3A4C6C6F40D35C717D02A61A6_913574043;
        } //End block
        // ---------- Original Method ----------
        //if (name.equals(lexicalHandlerProperty)) {
			//return theLexicalHandler == this ? null : theLexicalHandler;
			//}
		//else if (name.equals(scannerProperty)) {
			//return theScanner;
			//}
		//else if (name.equals(schemaProperty)) {
			//return theSchema;
			//}
		//else if (name.equals(autoDetectorProperty)) {
			//return theAutoDetector;
			//}
		//else {
			//throw new SAXNotRecognizedException("Unknown property " + name);
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.324 -0400", hash_original_method = "A91E5B1E97A27DD267128DBDD8DC4544", hash_generated_method = "882EB417FE8DE93641EE414E85097EAD")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name.equals(lexicalHandlerProperty))        
        {
    if(value == null)            
            {
                theLexicalHandler = this;
            } //End block
            else
    if(value instanceof LexicalHandler)            
            {
                theLexicalHandler = (LexicalHandler)value;
            } //End block
            else
            {
                SAXNotSupportedException var773F0C932D998A5EAE4EF456DB656E73_561388948 = new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
                var773F0C932D998A5EAE4EF456DB656E73_561388948.addTaint(taint);
                throw var773F0C932D998A5EAE4EF456DB656E73_561388948;
            } //End block
        } //End block
        else
    if(name.equals(scannerProperty))        
        {
    if(value instanceof Scanner)            
            {
                theScanner = (Scanner)value;
            } //End block
            else
            {
                SAXNotSupportedException var7FFA431932179A1CF96DF7EC76E97C59_116355191 = new SAXNotSupportedException("Your scanner is not a Scanner");
                var7FFA431932179A1CF96DF7EC76E97C59_116355191.addTaint(taint);
                throw var7FFA431932179A1CF96DF7EC76E97C59_116355191;
            } //End block
        } //End block
        else
    if(name.equals(schemaProperty))        
        {
    if(value instanceof Schema)            
            {
                theSchema = (Schema)value;
            } //End block
            else
            {
                SAXNotSupportedException varB42580954B833013B5D43EA6B937C9E3_1847859248 = new SAXNotSupportedException("Your schema is not a Schema");
                varB42580954B833013B5D43EA6B937C9E3_1847859248.addTaint(taint);
                throw varB42580954B833013B5D43EA6B937C9E3_1847859248;
            } //End block
        } //End block
        else
    if(name.equals(autoDetectorProperty))        
        {
    if(value instanceof AutoDetector)            
            {
                theAutoDetector = (AutoDetector)value;
            } //End block
            else
            {
                SAXNotSupportedException varA6C494E69E017E1711E412AF3C1788FC_1555791267 = new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
                varA6C494E69E017E1711E412AF3C1788FC_1555791267.addTaint(taint);
                throw varA6C494E69E017E1711E412AF3C1788FC_1555791267;
            } //End block
        } //End block
        else
        {
            SAXNotRecognizedException var3F84AAC3A4C6C6F40D35C717D02A61A6_1000228463 = new SAXNotRecognizedException("Unknown property " + name);
            var3F84AAC3A4C6C6F40D35C717D02A61A6_1000228463.addTaint(taint);
            throw var3F84AAC3A4C6C6F40D35C717D02A61A6_1000228463;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.325 -0400", hash_original_method = "A546AE41DB77A7324A8896ECCFDC28F7", hash_generated_method = "A8E69E6385944504A37F5388E7A83FAB")
    public void setEntityResolver(EntityResolver resolver) {
        theEntityResolver = (resolver == null) ? this : resolver;
        // ---------- Original Method ----------
        //theEntityResolver = (resolver == null) ? this : resolver;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.325 -0400", hash_original_method = "4B11F09BEC63C73E852BF6819D5E17A6", hash_generated_method = "0FB2331BEFA27096F1FC4D554F3036E7")
    public EntityResolver getEntityResolver() {
EntityResolver varBD53ACB74004475A0777DD230301F12B_974886532 =         (theEntityResolver == this) ? null : theEntityResolver;
        varBD53ACB74004475A0777DD230301F12B_974886532.addTaint(taint);
        return varBD53ACB74004475A0777DD230301F12B_974886532;
        // ---------- Original Method ----------
        //return (theEntityResolver == this) ? null : theEntityResolver;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.325 -0400", hash_original_method = "2A1D8AFABC32A2E0B1A4A173104FD709", hash_generated_method = "3683677B0F46E370F6EB575FDBECDF36")
    public void setDTDHandler(DTDHandler handler) {
        theDTDHandler = (handler == null) ? this : handler;
        // ---------- Original Method ----------
        //theDTDHandler = (handler == null) ? this : handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.326 -0400", hash_original_method = "338D21F6A8224B73088A08444EBB70F8", hash_generated_method = "4A42B74E82CDD5BD4E935037816525E7")
    public DTDHandler getDTDHandler() {
DTDHandler var80673DDBC08143F3A720028FA39E4C2A_61135582 =         (theDTDHandler == this) ? null : theDTDHandler;
        var80673DDBC08143F3A720028FA39E4C2A_61135582.addTaint(taint);
        return var80673DDBC08143F3A720028FA39E4C2A_61135582;
        // ---------- Original Method ----------
        //return (theDTDHandler == this) ? null : theDTDHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.326 -0400", hash_original_method = "F2917252F8D6F02CF50CD455848B7CDD", hash_generated_method = "ACB9649AEA4D4CF5ABBC38AFBB15C07D")
    public void setContentHandler(ContentHandler handler) {
        theContentHandler = (handler == null) ? this : handler;
        // ---------- Original Method ----------
        //theContentHandler = (handler == null) ? this : handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.326 -0400", hash_original_method = "E2D49645B9897F446183B1EC842A5B8C", hash_generated_method = "CA592A4E53A5C1EF588EE83EB8F902A6")
    public ContentHandler getContentHandler() {
ContentHandler var7F70CD60B5ABB72552769F33F070C12F_1416241983 =         (theContentHandler == this) ? null : theContentHandler;
        var7F70CD60B5ABB72552769F33F070C12F_1416241983.addTaint(taint);
        return var7F70CD60B5ABB72552769F33F070C12F_1416241983;
        // ---------- Original Method ----------
        //return (theContentHandler == this) ? null : theContentHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.327 -0400", hash_original_method = "4FC35E4E9BBEBB25DC834EFC47A653D4", hash_generated_method = "8B0B4CCC460D0E90458738C6876CF2B6")
    public void setErrorHandler(ErrorHandler handler) {
        theErrorHandler = (handler == null) ? this : handler;
        // ---------- Original Method ----------
        //theErrorHandler = (handler == null) ? this : handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.327 -0400", hash_original_method = "662542919C9F3C78B54F5CA00EE88FD5", hash_generated_method = "88D9B28262D3D0127CBA67F98F245EBA")
    public ErrorHandler getErrorHandler() {
ErrorHandler varF30FCC774C37D18FDA65D270F88B540B_1579925329 =         (theErrorHandler == this) ? null : theErrorHandler;
        varF30FCC774C37D18FDA65D270F88B540B_1579925329.addTaint(taint);
        return varF30FCC774C37D18FDA65D270F88B540B_1579925329;
        // ---------- Original Method ----------
        //return (theErrorHandler == this) ? null : theErrorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.327 -0400", hash_original_method = "5995949AA97E47EEEF7CCC54B7A2CDFD", hash_generated_method = "4F868F0CB6A1B70FB87DDCC4F4F04C53")
    public void parse(InputSource input) throws IOException, SAXException {
        addTaint(input.getTaint());
        setup();
        Reader r = getReader(input);
        theContentHandler.startDocument();
        theScanner.resetDocumentLocator(input.getPublicId(), input.getSystemId());
    if(theScanner instanceof Locator)        
        {
            theContentHandler.setDocumentLocator((Locator)theScanner);
        } //End block
    if(!(theSchema.getURI().equals("")))        
        theContentHandler.startPrefixMapping(theSchema.getPrefix(),
				theSchema.getURI());
        theScanner.scan(r, this);
        // ---------- Original Method ----------
        //setup();
        //Reader r = getReader(input);
        //theContentHandler.startDocument();
        //theScanner.resetDocumentLocator(input.getPublicId(), input.getSystemId());
        //if (theScanner instanceof Locator) {
			//theContentHandler.setDocumentLocator((Locator)theScanner);
			//}
        //if (!(theSchema.getURI().equals("")))
			//theContentHandler.startPrefixMapping(theSchema.getPrefix(),
				//theSchema.getURI());
        //theScanner.scan(r, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.327 -0400", hash_original_method = "84CD70DF516C08D97CF2D35EEDEEB169", hash_generated_method = "EA2B9D9CD7F2D7BB4C4396AD6FB433B0")
    public void parse(String systemid) throws IOException, SAXException {
        addTaint(systemid.getTaint());
        parse(new InputSource(systemid));
        // ---------- Original Method ----------
        //parse(new InputSource(systemid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.329 -0400", hash_original_method = "4BDCB9FDB6AA49AD5AB8549244541048", hash_generated_method = "DBB8B8A584F1A11C08E216D8AE90BA96")
    private void setup() {
    if(theSchema == null)        
        theSchema = new HTMLSchema();
    if(theScanner == null)        
        theScanner = new HTMLScanner();
    if(theAutoDetector == null)        
        {
            theAutoDetector = new AutoDetector() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.328 -0400", hash_original_method = "85BE25D56154FC2B6F5EE396BFE70BBC", hash_generated_method = "9A812CBC844E792AAA55886E6E312A53")
        public Reader autoDetectingReader(InputStream i) {
            addTaint(i.getTaint());
Reader varF54C85E2A8BED917566CC9AA4C9DA4E1_1570583928 =             new InputStreamReader(i);
            varF54C85E2A8BED917566CC9AA4C9DA4E1_1570583928.addTaint(taint);
            return varF54C85E2A8BED917566CC9AA4C9DA4E1_1570583928;
            // ---------- Original Method ----------
            //return new InputStreamReader(i);
        }
};
        } //End block
        theStack = new Element(theSchema.getElementType("<root>"), defaultAttributes);
        thePCDATA = new Element(theSchema.getElementType("<pcdata>"), defaultAttributes);
        theNewElement = null;
        theAttributeName = null;
        thePITarget = null;
        theSaved = null;
        theEntity = 0;
        virginStack = true;
        theDoctypeName = theDoctypePublicId = theDoctypeSystemId = null;
        // ---------- Original Method ----------
        //if (theSchema == null) theSchema = new HTMLSchema();
        //if (theScanner == null) theScanner = new HTMLScanner();
        //if (theAutoDetector == null) {
			//theAutoDetector = new AutoDetector() {
				//public Reader autoDetectingReader(InputStream i) {
					//return new InputStreamReader(i);
					//}
				//};
			//}
        //theStack = new Element(theSchema.getElementType("<root>"), defaultAttributes);
        //thePCDATA = new Element(theSchema.getElementType("<pcdata>"), defaultAttributes);
        //theNewElement = null;
        //theAttributeName = null;
        //thePITarget = null;
        //theSaved = null;
        //theEntity = 0;
        //virginStack = true;
        //theDoctypeName = theDoctypePublicId = theDoctypeSystemId = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.330 -0400", hash_original_method = "0FC12B7CFED0DCE2629E4B14587480A6", hash_generated_method = "6600BE2A8E3DD471BDF50592558E1795")
    private Reader getReader(InputSource s) throws SAXException, IOException {
        addTaint(s.getTaint());
        Reader r = s.getCharacterStream();
        InputStream i = s.getByteStream();
        String encoding = s.getEncoding();
        String publicid = s.getPublicId();
        String systemid = s.getSystemId();
    if(r == null)        
        {
    if(i == null)            
            i = getInputStream(publicid, systemid);
    if(encoding == null)            
            {
                r = theAutoDetector.autoDetectingReader(i);
            } //End block
            else
            {
                try 
                {
                    r = new InputStreamReader(i, encoding);
                } //End block
                catch (UnsupportedEncodingException e)
                {
                    r = new InputStreamReader(i);
                } //End block
            } //End block
        } //End block
Reader var4C1F3C86A0E56B6E375080F5F710547E_2041328104 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_2041328104.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_2041328104;
        // ---------- Original Method ----------
        //Reader r = s.getCharacterStream();
        //InputStream i = s.getByteStream();
        //String encoding = s.getEncoding();
        //String publicid = s.getPublicId();
        //String systemid = s.getSystemId();
        //if (r == null) {
			//if (i == null) i = getInputStream(publicid, systemid);
			//if (encoding == null) {
				//r = theAutoDetector.autoDetectingReader(i);
				//}
			//else {
				//try {
					//r = new InputStreamReader(i, encoding);
					//}
				//catch (UnsupportedEncodingException e) {
					//r = new InputStreamReader(i);
					//}
				//}
			//}
        //return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.330 -0400", hash_original_method = "CDC68ACD7694626FF67B6B6D163E3BB7", hash_generated_method = "2099841978EA251769019B2CF8C7125A")
    private InputStream getInputStream(String publicid, String systemid) throws IOException, SAXException {
        addTaint(systemid.getTaint());
        addTaint(publicid.getTaint());
        URL basis = new URL("file", "", System.getProperty("user.dir") + "/.");
        URL url = new URL(basis, systemid);
        URLConnection c = url.openConnection();
InputStream var7664B8C02B25A9FAFA87FEC0231321BC_1978791562 =         c.getInputStream();
        var7664B8C02B25A9FAFA87FEC0231321BC_1978791562.addTaint(taint);
        return var7664B8C02B25A9FAFA87FEC0231321BC_1978791562;
        // ---------- Original Method ----------
        //URL basis = new URL("file", "", System.getProperty("user.dir") + "/.");
        //URL url = new URL(basis, systemid);
        //URLConnection c = url.openConnection();
        //return c.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.330 -0400", hash_original_method = "35040F07E07C8DEC63311B713CED1F9F", hash_generated_method = "D8EAF365A3862A7E83AB03DF6E77FF12")
    public void adup(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(theNewElement == null || theAttributeName == null)        
        return;
        theNewElement.setAttribute(theAttributeName, null, theAttributeName);
        theAttributeName = null;
        // ---------- Original Method ----------
        //if (theNewElement == null || theAttributeName == null) return;
        //theNewElement.setAttribute(theAttributeName, null, theAttributeName);
        //theAttributeName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.330 -0400", hash_original_method = "C9FB1DE82C24B4094C9FB21723BCABB8", hash_generated_method = "568F4189FB79348FE1244D85783FC8B5")
    public void aname(char[] buff, int offset, int length) throws SAXException {
    if(theNewElement == null)        
        return;
        theAttributeName = makeName(buff, offset, length).toLowerCase();
        // ---------- Original Method ----------
        //if (theNewElement == null) return;
        //theAttributeName = makeName(buff, offset, length).toLowerCase();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.331 -0400", hash_original_method = "B00CA1167B22D91DBB3A58CD90B87CBC", hash_generated_method = "5AF586FA5AF4420C9899DC2E1388B18A")
    public void aval(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(theNewElement == null || theAttributeName == null)        
        return;
        String value = new String(buff, offset, length);
        value = expandEntities(value);
        theNewElement.setAttribute(theAttributeName, null, value);
        theAttributeName = null;
        // ---------- Original Method ----------
        //if (theNewElement == null || theAttributeName == null) return;
        //String value = new String(buff, offset, length);
        //value = expandEntities(value);
        //theNewElement.setAttribute(theAttributeName, null, value);
        //theAttributeName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.332 -0400", hash_original_method = "BD88D393D059FDFF1FEBA4E80D3AAF56", hash_generated_method = "5187D0EAC45751E54885DBB6DA669D7A")
    private String expandEntities(String src) {
        addTaint(src.getTaint());
        int refStart = -1;
        int len = src.length();
        char[] dst = new char[len];
        int dstlen = 0;
for(int i = 0;i < len;i++)
        {
            char ch = src.charAt(i);
            dst[dstlen++] = ch;
    if(ch == '&' && refStart == -1)            
            {
                refStart = dstlen;
            } //End block
            else
    if(refStart == -1)            
            {
            } //End block
            else
    if(Character.isLetter(ch) ||
					Character.isDigit(ch) ||
					ch == '#')            
            {
            } //End block
            else
    if(ch == ';')            
            {
                int ent = lookupEntity(dst, refStart, dstlen - refStart - 1);
    if(ent > 0xFFFF)                
                {
                    ent -= 0x10000;
                    dst[refStart - 1] = (char)((ent>>10) + 0xD800);
                    dst[refStart] = (char)((ent&0x3FF) + 0xDC00);
                    dstlen = refStart + 1;
                } //End block
                else
    if(ent != 0)                
                {
                    dst[refStart - 1] = (char)ent;
                    dstlen = refStart;
                } //End block
                refStart = -1;
            } //End block
            else
            {
                refStart = -1;
            } //End block
        } //End block
String var066172BAF3274369BB7672D02BD9C593_674155256 =         new String(dst, 0, dstlen);
        var066172BAF3274369BB7672D02BD9C593_674155256.addTaint(taint);
        return var066172BAF3274369BB7672D02BD9C593_674155256;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.333 -0400", hash_original_method = "38A8EAE3BE9C6B2369CA0ABEFF20DED1", hash_generated_method = "46345302BE4543B332C8C9596818D864")
    public void entity(char[] buff, int offset, int length) throws SAXException {
        theEntity = lookupEntity(buff, offset, length);
        // ---------- Original Method ----------
        //theEntity = lookupEntity(buff, offset, length);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.334 -0400", hash_original_method = "9575B162D435E8F9BEA7F0ECC81D324A", hash_generated_method = "CE2EA42D42CE287C7EF27A8B3B644AC0")
    private int lookupEntity(char[] buff, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        int result = 0;
    if(length < 1)        
        {
        int varB4A88417B3D0170D754C647C30B7216A_1728673623 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408417790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408417790;
        }
    if(buff[offset] == '#')        
        {
    if(length > 1 && (buff[offset+1] == 'x'
                                        || buff[offset+1] == 'X'))            
            {
                try 
                {
                    int var7D90ED498BB46987BD83CED80000FBEC_1468770599 = (Integer.parseInt(new String(buff, offset + 2, length - 2), 16));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137961663 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137961663;
                } //End block
                catch (NumberFormatException e)
                {
                    int varCFCD208495D565EF66E7DFF9F98764DA_1371134001 = (0);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330736283 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1330736283;
                } //End block
            } //End block
            try 
            {
                int var052B65AF507E4786A255B3B035904D47_1529831224 = (Integer.parseInt(new String(buff, offset + 1, length - 1), 10));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236424568 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1236424568;
            } //End block
            catch (NumberFormatException e)
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_615501898 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807969213 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807969213;
            } //End block
        } //End block
        int varE1F60BE4A5378C4697DE9CC0D9BBDF73_1178071215 = (theSchema.getEntity(new String(buff, offset, length)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802107049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802107049;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.335 -0400", hash_original_method = "0A8BABE6DCD2F294E63CAA7BFD276118", hash_generated_method = "56876500EA4C9C1AAB924589BFF2AB68")
    public void eof(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(virginStack)        
        rectify(thePCDATA);
        while
(theStack.next() != null)        
        {
            pop();
        } //End block
    if(!(theSchema.getURI().equals("")))        
        theContentHandler.endPrefixMapping(theSchema.getPrefix());
        theContentHandler.endDocument();
        // ---------- Original Method ----------
        //if (virginStack) rectify(thePCDATA);
        //while (theStack.next() != null) {
			//pop();
			//}
        //if (!(theSchema.getURI().equals("")))
			//theContentHandler.endPrefixMapping(theSchema.getPrefix());
        //theContentHandler.endDocument();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.335 -0400", hash_original_method = "551A0AD1D8D7CCFDEAB6F03D7C2481C3", hash_generated_method = "5EC52ADE5B9B0DDD9B8446A33C9B6D93")
    public void etag(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(etag_cdata(buff, offset, length))        
        return;
        etag_basic(buff, offset, length);
        // ---------- Original Method ----------
        //if (etag_cdata(buff, offset, length)) return;
        //etag_basic(buff, offset, length);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.336 -0400", hash_original_method = "C9023F984BCCCBD84980442CF55120FA", hash_generated_method = "CE64339A070BC782C2975C39CB1547E9")
    public boolean etag_cdata(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        String currentName = theStack.name();
    if(CDATAElements && (theStack.flags() & Schema.F_CDATA) != 0)        
        {
            boolean realTag = (length == currentName.length());
    if(realTag)            
            {
for(int i = 0;i < length;i++)
                {
    if(Character.toLowerCase(buff[offset + i]) != Character.toLowerCase(currentName.charAt(i)))                    
                    {
                        realTag = false;
                        break;
                    } //End block
                } //End block
            } //End block
    if(!realTag)            
            {
                theContentHandler.characters(etagchars, 0, 2);
                theContentHandler.characters(buff, offset, length);
                theContentHandler.characters(etagchars, 2, 1);
                theScanner.startCDATA();
                boolean varB326B5062B2F0E69046810717534CB09_1728841862 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963589648 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_963589648;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1777508093 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769460576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769460576;
        // ---------- Original Method ----------
        //String currentName = theStack.name();
        //if (CDATAElements && (theStack.flags() & Schema.F_CDATA) != 0) {
			//boolean realTag = (length == currentName.length());
			//if (realTag) {
				//for (int i = 0; i < length; i++) {
					//if (Character.toLowerCase(buff[offset + i]) != Character.toLowerCase(currentName.charAt(i))) {
						//realTag = false;
						//break;
						//}
					//}
				//}
			//if (!realTag) {
				//theContentHandler.characters(etagchars, 0, 2);
				//theContentHandler.characters(buff, offset, length);
				//theContentHandler.characters(etagchars, 2, 1);
				//theScanner.startCDATA();
				//return true;
				//}
			//}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.337 -0400", hash_original_method = "F1F8115795B982079B234CC2192B7DDB", hash_generated_method = "DC05BF5A14CD5354F22F448C188E8282")
    public void etag_basic(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theNewElement = null;
        String name;
    if(length != 0)        
        {
            name = makeName(buff, offset, length);
            ElementType type = theSchema.getElementType(name);
    if(type == null)            
            return;
            name = type.name();
        } //End block
        else
        {
            name = theStack.name();
        } //End block
        Element sp;
        boolean inNoforce = false;
for(sp = theStack;sp != null;sp = sp.next())
        {
    if(sp.name().equals(name))            
            break;
    if((sp.flags() & Schema.F_NOFORCE) != 0)            
            inNoforce = true;
        } //End block
    if(sp == null)        
        return;
    if(sp.next() == null || sp.next().next() == null)        
        return;
    if(inNoforce)        
        {
            sp.preclose();
        } //End block
        else
        {
            while
(theStack != sp)            
            {
                restartablyPop();
            } //End block
            pop();
        } //End block
        while
(theStack.isPreclosed())        
        {
            pop();
        } //End block
        restart(null);
        // ---------- Original Method ----------
        //theNewElement = null;
        //String name;
        //if (length != 0) {
			//name = makeName(buff, offset, length);
			//ElementType type = theSchema.getElementType(name);
			//if (type == null) return;	
			//name = type.name();
			//}
		//else {
			//name = theStack.name();
			//}
        //Element sp;
        //boolean inNoforce = false;
        //for (sp = theStack; sp != null; sp = sp.next()) {
			//if (sp.name().equals(name)) break;
			//if ((sp.flags() & Schema.F_NOFORCE) != 0) inNoforce = true;
			//}
        //if (sp == null) return;
        //if (sp.next() == null || sp.next().next() == null) return;
        //if (inNoforce) {		
			//sp.preclose();		
			//}
		//else {			
			//while (theStack != sp) {
				//restartablyPop();
				//}
			//pop();
			//}
        //while (theStack.isPreclosed()) {
			//pop();
			//}
        //restart(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.338 -0400", hash_original_method = "B330A365C16A276F019BF46E61F37EA8", hash_generated_method = "01FCC8C24C7DE5958327497B782EF039")
    private void restart(Element e) throws SAXException {
        addTaint(e.getTaint());
        while
(theSaved != null && theStack.canContain(theSaved) &&
				(e == null || theSaved.canContain(e)))        
        {
            Element next = theSaved.next();
            push(theSaved);
            theSaved = next;
        } //End block
        // ---------- Original Method ----------
        //while (theSaved != null && theStack.canContain(theSaved) &&
				//(e == null || theSaved.canContain(e))) {
			//Element next = theSaved.next();
			//push(theSaved);
			//theSaved = next;
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.338 -0400", hash_original_method = "C52776A5281CF0A097BB6E08724FB3A1", hash_generated_method = "BCE6F8ABEC3816D0132B422D3936AA3C")
    private void pop() throws SAXException {
    if(theStack == null)        
        return;
        String name = theStack.name();
        String localName = theStack.localName();
        String namespace = theStack.namespace();
        String prefix = prefixOf(name);
    if(!namespaces)        
        namespace = localName = "";
        theContentHandler.endElement(namespace, localName, name);
    if(foreign(prefix, namespace))        
        {
            theContentHandler.endPrefixMapping(prefix);
        } //End block
        Attributes atts = theStack.atts();
for(int i = atts.getLength() - 1;i >= 0;i--)
        {
            String attNamespace = atts.getURI(i);
            String attPrefix = prefixOf(atts.getQName(i));
    if(foreign(attPrefix, attNamespace))            
            {
                theContentHandler.endPrefixMapping(attPrefix);
            } //End block
        } //End block
        theStack = theStack.next();
        // ---------- Original Method ----------
        //if (theStack == null) return;
        //String name = theStack.name();
        //String localName = theStack.localName();
        //String namespace = theStack.namespace();
        //String prefix = prefixOf(name);
        //if (!namespaces) namespace = localName = "";
        //theContentHandler.endElement(namespace, localName, name);
        //if (foreign(prefix, namespace)) {
			//theContentHandler.endPrefixMapping(prefix);
			//}
        //Attributes atts = theStack.atts();
        //for (int i = atts.getLength() - 1; i >= 0; i--) {
			//String attNamespace = atts.getURI(i);
			//String attPrefix = prefixOf(atts.getQName(i));
			//if (foreign(attPrefix, attNamespace)) {
				//theContentHandler.endPrefixMapping(attPrefix);
				//}
			//}
        //theStack = theStack.next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.339 -0400", hash_original_method = "C8A2C1B1941DD99452371A15DDB14C88", hash_generated_method = "FFC0103F54A6C22AA2A930BF9D2A62B7")
    private void restartablyPop() throws SAXException {
        Element popped = theStack;
        pop();
    if(restartElements && (popped.flags() & Schema.F_RESTART) != 0)        
        {
            popped.anonymize();
            popped.setNext(theSaved);
            theSaved = popped;
        } //End block
        // ---------- Original Method ----------
        //Element popped = theStack;
        //pop();
        //if (restartElements && (popped.flags() & Schema.F_RESTART) != 0) {
			//popped.anonymize();
			//popped.setNext(theSaved);
			//theSaved = popped;
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.339 -0400", hash_original_method = "CEB0923649F562E1C47AECBE0F37237A", hash_generated_method = "669FBF71B8DF6DF50054CBA137482FFA")
    private void push(Element e) throws SAXException {
        String name = e.name();
        String localName = e.localName();
        String namespace = e.namespace();
        String prefix = prefixOf(name);
        e.clean();
    if(!namespaces)        
        namespace = localName = "";
    if(virginStack && localName.equalsIgnoreCase(theDoctypeName))        
        {
            try 
            {
                theEntityResolver.resolveEntity(theDoctypePublicId, theDoctypeSystemId);
            } //End block
            catch (IOException ew)
            {
            } //End block
        } //End block
    if(foreign(prefix, namespace))        
        {
            theContentHandler.startPrefixMapping(prefix, namespace);
        } //End block
        Attributes atts = e.atts();
        int len = atts.getLength();
for(int i = 0;i < len;i++)
        {
            String attNamespace = atts.getURI(i);
            String attPrefix = prefixOf(atts.getQName(i));
    if(foreign(attPrefix, attNamespace))            
            {
                theContentHandler.startPrefixMapping(attPrefix, attNamespace);
            } //End block
        } //End block
        theContentHandler.startElement(namespace, localName, name, e.atts());
        e.setNext(theStack);
        theStack = e;
        virginStack = false;
    if(CDATAElements && (theStack.flags() & Schema.F_CDATA) != 0)        
        {
            theScanner.startCDATA();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.340 -0400", hash_original_method = "EBD18CEBBA646E39DB7BD8DC690DDED7", hash_generated_method = "186A46A6FABC39CA05473306A3047897")
    private String prefixOf(String name) {
        addTaint(name.getTaint());
        int i = name.indexOf(':');
        String prefix = "";
    if(i != -1)        
        prefix = name.substring(0, i);
String varA4C254BE9F2C23429A8ED0933F20FF43_649572844 =         prefix;
        varA4C254BE9F2C23429A8ED0933F20FF43_649572844.addTaint(taint);
        return varA4C254BE9F2C23429A8ED0933F20FF43_649572844;
        // ---------- Original Method ----------
        //int i = name.indexOf(':');
        //String prefix = "";
        //if (i != -1) prefix = name.substring(0, i);
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.340 -0400", hash_original_method = "761321F4D2C89C49E6A94969107BF018", hash_generated_method = "E77DEE4BE97CC56F23088F481576A6F7")
    private boolean foreign(String prefix, String namespace) {
        addTaint(namespace.getTaint());
        addTaint(prefix.getTaint());
        boolean foreign = !(prefix.equals("") || namespace.equals("") ||
			namespace.equals(theSchema.getURI()));
        boolean var684A72E08F24F55B1138EDD5A7C2B53E_1168346179 = (foreign);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993391108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_993391108;
        // ---------- Original Method ----------
        //boolean foreign = !(prefix.equals("") || namespace.equals("") ||
			//namespace.equals(theSchema.getURI()));
        //return foreign;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.342 -0400", hash_original_method = "1C2CEC982271DB04AB7A74A00D860FDA", hash_generated_method = "0ADFE06C58CE52172B3E0222D1BE2C92")
    public void decl(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        String s = new String(buff, offset, length);
        String name = null;
        String systemid = null;
        String publicid = null;
        String[] v = split(s);
    if(v.length > 0 && "DOCTYPE".equals(v[0]))        
        {
    if(theDoctypeIsPresent)            
            return;
            theDoctypeIsPresent = true;
    if(v.length > 1)            
            {
                name = v[1];
    if(v.length>3 && "SYSTEM".equals(v[2]))                
                {
                    systemid = v[3];
                } //End block
                else
    if(v.length > 3 && "PUBLIC".equals(v[2]))                
                {
                    publicid = v[3];
    if(v.length > 4)                    
                    {
                        systemid = v[4];
                    } //End block
                    else
                    {
                        systemid = "";
                    } //End block
                } //End block
            } //End block
        } //End block
        publicid = trimquotes(publicid);
        systemid = trimquotes(systemid);
    if(name != null)        
        {
            publicid = cleanPublicid(publicid);
            theLexicalHandler.startDTD(name, publicid, systemid);
            theLexicalHandler.endDTD();
            theDoctypeName = name;
            theDoctypePublicId = publicid;
    if(theScanner instanceof Locator)            
            {
                theDoctypeSystemId  = ((Locator)theScanner).getSystemId();
                try 
                {
                    theDoctypeSystemId = new URL(new URL(theDoctypeSystemId), systemid).toString();
                } //End block
                catch (Exception e)
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static String trimquotes(String in) {
        if (in == null) return in;
        int length = in.length();
        if (length == 0) return in;
        char s = in.charAt(0);
        char e = in.charAt(length - 1);
        if (s == e && (s == '\'' || s == '"')) {
			in = in.substring(1, in.length() - 1);
			}
        return in;
    }

    
        private static String[] split(String val) throws IllegalArgumentException {
        val = val.trim();
        if (val.length() == 0) {
			return new String[0];
			}
		else {
			ArrayList l = new ArrayList();
			int s = 0;
			int e = 0;
			boolean sq = false;	
			boolean dq = false;	
			char lastc = 0;
			int len = val.length();
			for (e=0; e < len; e++) {
				char c = val.charAt(e);
				if (!dq && c == '\'' && lastc != '\\') {
				sq = !sq;
				if (s < 0) s = e;
				}
			else if (!sq && c == '\"' && lastc != '\\') {
				dq = !dq;
				if (s < 0) s = e;
				}
			else if (!sq && !dq) {
				if (Character.isWhitespace(c)) {
					if (s >= 0) l.add(val.substring(s, e));
					s = -1;
					}
				else if (s < 0 && c != ' ') {
					s = e;
					}
				}
			lastc = c;
			}
		l.add(val.substring(s, e));
		return (String[])l.toArray(new String[0]);
		}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.343 -0400", hash_original_method = "92ECD15FFBF9920D383290E17881F5A3", hash_generated_method = "8A969C098E4677128F549FF50F7C0572")
    private String cleanPublicid(String src) {
        addTaint(src.getTaint());
    if(src == null)        
        {
String var540C13E9E156B687226421B24F2DF178_181291008 =         null;
        var540C13E9E156B687226421B24F2DF178_181291008.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_181291008;
        }
        int len = src.length();
        StringBuffer dst = new StringBuffer(len);
        boolean suppressSpace = true;
for(int i = 0;i < len;i++)
        {
            char ch = src.charAt(i);
    if(legal.indexOf(ch) != -1)            
            {
                dst.append(ch);
                suppressSpace = false;
            } //End block
            else
    if(suppressSpace)            
            {
                ;
            } //End block
            else
            {
                dst.append(' ');
                suppressSpace = true;
            } //End block
        } //End block
String var17F296EBBF7F1F875B1A9BB868D8F4B3_1167068337 =         dst.toString().trim();
        var17F296EBBF7F1F875B1A9BB868D8F4B3_1167068337.addTaint(taint);
        return var17F296EBBF7F1F875B1A9BB868D8F4B3_1167068337;
        // ---------- Original Method ----------
        //if (src == null) return null;
        //int len = src.length();
        //StringBuffer dst = new StringBuffer(len);
        //boolean suppressSpace = true;
        //for (int i = 0; i < len; i++) {
			//char ch = src.charAt(i);
			//if (legal.indexOf(ch) != -1) { 	
				//dst.append(ch);
				//suppressSpace = false;
				//}
			//else if (suppressSpace) {	
				//;
				//}
			//else {
				//dst.append(' ');
				//suppressSpace = true;
				//}
			//}
        //return dst.toString().trim();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.344 -0400", hash_original_method = "7EEA5677E99A2C9EF1241E44C92259AC", hash_generated_method = "52F7778B89F9D862616ECE43354D333C")
    public void gi(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(theNewElement != null)        
        return;
        String name = makeName(buff, offset, length);
    if(name == null)        
        return;
        ElementType type = theSchema.getElementType(name);
    if(type == null)        
        {
    if(ignoreBogons)            
            return;
            int bogonModel = bogonsEmpty ? Schema.M_EMPTY : Schema.M_ANY;
            int bogonMemberOf = rootBogons ? Schema.M_ANY : (Schema.M_ANY & ~ Schema.M_ROOT);
            theSchema.elementType(name, bogonModel, bogonMemberOf, 0);
    if(!rootBogons)            
            theSchema.parent(name, theSchema.rootElementType().name());
            type = theSchema.getElementType(name);
        } //End block
        theNewElement = new Element(type, defaultAttributes);
        // ---------- Original Method ----------
        //if (theNewElement != null) return;
        //String name = makeName(buff, offset, length);
        //if (name == null) return;
        //ElementType type = theSchema.getElementType(name);
        //if (type == null) {
			//if (ignoreBogons) return;
			//int bogonModel = bogonsEmpty ? Schema.M_EMPTY : Schema.M_ANY;
			//int bogonMemberOf = rootBogons ? Schema.M_ANY : (Schema.M_ANY & ~ Schema.M_ROOT);
			//theSchema.elementType(name, bogonModel, bogonMemberOf, 0);
			//if (!rootBogons) theSchema.parent(name, theSchema.rootElementType().name());
			//type = theSchema.getElementType(name);
			//}
        //theNewElement = new Element(type, defaultAttributes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.344 -0400", hash_original_method = "A6AFE17C00CB0D2270FAE1159A108399", hash_generated_method = "007288F33DA15611C9AD0C7A70F09471")
    public void cdsect(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theLexicalHandler.startCDATA();
        pcdata(buff, offset, length);
        theLexicalHandler.endCDATA();
        // ---------- Original Method ----------
        //theLexicalHandler.startCDATA();
        //pcdata(buff, offset, length);
        //theLexicalHandler.endCDATA();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.345 -0400", hash_original_method = "087E39444EA30ADF63D8EEFEFF8A4B70", hash_generated_method = "0220B9AAE5955192EB6BC1996DB51010")
    public void pcdata(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(length == 0)        
        return;
        boolean allWhite = true;
for(int i = 0;i < length;i++)
        {
    if(!Character.isWhitespace(buff[offset+i]))            
            {
                allWhite = false;
            } //End block
        } //End block
    if(allWhite && !theStack.canContain(thePCDATA))        
        {
    if(ignorableWhitespace)            
            {
                theContentHandler.ignorableWhitespace(buff, offset, length);
            } //End block
        } //End block
        else
        {
            rectify(thePCDATA);
            theContentHandler.characters(buff, offset, length);
        } //End block
        // ---------- Original Method ----------
        //if (length == 0) return;
        //boolean allWhite = true;
        //for (int i = 0; i < length; i++) {
			//if (!Character.isWhitespace(buff[offset+i])) {
				//allWhite = false;
				//}
			//}
        //if (allWhite && !theStack.canContain(thePCDATA)) {
			//if (ignorableWhitespace) {
				//theContentHandler.ignorableWhitespace(buff, offset, length);
				//}
			//}
		//else {
			//rectify(thePCDATA);
			//theContentHandler.characters(buff, offset, length);
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.346 -0400", hash_original_method = "10DA4877B62CBC6E2AF531E70FE25E21", hash_generated_method = "294CB36D1F5BBA62BC66BF4274168DE0")
    public void pitarget(char[] buff, int offset, int length) throws SAXException {
    if(theNewElement != null)        
        return;
        thePITarget = makeName(buff, offset, length).replace(':', '_');
        // ---------- Original Method ----------
        //if (theNewElement != null) return;
        //thePITarget = makeName(buff, offset, length).replace(':', '_');
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.346 -0400", hash_original_method = "373E8AB8CB624AD49A96496DDC7BD596", hash_generated_method = "FB3633235A53377577D848C8A9FBA0CD")
    public void pi(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(theNewElement != null || thePITarget == null)        
        return;
    if("xml".equalsIgnoreCase(thePITarget))        
        return;
    if(length > 0 && buff[length - 1] == '?')        
        length--;
        theContentHandler.processingInstruction(thePITarget,
			new String(buff, offset, length));
        thePITarget = null;
        // ---------- Original Method ----------
        //if (theNewElement != null || thePITarget == null) return;
        //if ("xml".equalsIgnoreCase(thePITarget)) return;
        //if (length > 0 && buff[length - 1] == '?') length--;
        //theContentHandler.processingInstruction(thePITarget,
			//new String(buff, offset, length));
        //thePITarget = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.346 -0400", hash_original_method = "E16C8825C4BEC5864699E25FFFCA21E7", hash_generated_method = "81000967EDB101985F2DAF1EB5B25DC5")
    public void stagc(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(theNewElement == null)        
        return;
        rectify(theNewElement);
    if(theStack.model() == Schema.M_EMPTY)        
        {
            etag_basic(buff, offset, length);
        } //End block
        // ---------- Original Method ----------
        //if (theNewElement == null) return;
        //rectify(theNewElement);
        //if (theStack.model() == Schema.M_EMPTY) {
			//etag_basic(buff, offset, length);
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.347 -0400", hash_original_method = "0E3563E6FA953D38A95EC3A2105DD410", hash_generated_method = "4911940EE4EDD4E0D943CF9269263979")
    public void stage(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
    if(theNewElement == null)        
        return;
        rectify(theNewElement);
        etag_basic(buff, offset, length);
        // ---------- Original Method ----------
        //if (theNewElement == null) return;
        //rectify(theNewElement);
        //etag_basic(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.347 -0400", hash_original_method = "A603B5B2E591802383EBFF92F8BBF095", hash_generated_method = "0EA4C7C84A9B4768AC08E2170A07F31D")
    public void cmnt(char[] buff, int offset, int length) throws SAXException {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        theLexicalHandler.comment(buff, offset, length);
        // ---------- Original Method ----------
        //theLexicalHandler.comment(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.348 -0400", hash_original_method = "37597577D17F3DB30561754D63AF952D", hash_generated_method = "C39A9BAC2EC4BBB87D138E4B7181DF62")
    private void rectify(Element e) throws SAXException {
        addTaint(e.getTaint());
        Element sp;
        while
(true)        
        {
for(sp = theStack;sp != null;sp = sp.next())
            {
    if(sp.canContain(e))                
                break;
            } //End block
    if(sp != null)            
            break;
            ElementType parentType = e.parent();
    if(parentType == null)            
            break;
            Element parent = new Element(parentType, defaultAttributes);
            parent.setNext(e);
            e = parent;
        } //End block
    if(sp == null)        
        return;
        while
(theStack != sp)        
        {
    if(theStack == null || theStack.next() == null ||
				theStack.next().next() == null)            
            break;
            restartablyPop();
        } //End block
        while
(e != null)        
        {
            Element nexte = e.next();
    if(!e.name().equals("<pcdata>"))            
            push(e);
            e = nexte;
            restart(e);
        } //End block
        theNewElement = null;
        // ---------- Original Method ----------
        //Element sp;
        //while (true) {
			//for (sp = theStack; sp != null; sp = sp.next()) {
				//if (sp.canContain(e)) break;
				//}
			//if (sp != null) break;
			//ElementType parentType = e.parent();
			//if (parentType == null) break;
			//Element parent = new Element(parentType, defaultAttributes);
			//parent.setNext(e);
			//e = parent;
			//}
        //if (sp == null) return;
        //while (theStack != sp) {
			//if (theStack == null || theStack.next() == null ||
				//theStack.next().next() == null) break;
			//restartablyPop();
			//}
        //while (e != null) {
			//Element nexte = e.next();
			//if (!e.name().equals("<pcdata>")) push(e);
			//e = nexte;
			//restart(e);
			//}
        //theNewElement = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.348 -0400", hash_original_method = "7F354BAD0D4521AB4E9BA9D90015CEBE", hash_generated_method = "520582FDB89E4EFFF34C0D4983CA504B")
    public int getEntity() {
        int varFB6B2EC6D1990574C8030142DDD5ACD0_835980961 = (theEntity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374279184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374279184;
        // ---------- Original Method ----------
        //return theEntity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.349 -0400", hash_original_method = "C657524A51A66CA45344D36C0B6F5C26", hash_generated_method = "8FC278D2C1C1371DE534582056E465A8")
    private String makeName(char[] buff, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(buff[0]);
        StringBuffer dst = new StringBuffer(length + 2);
        boolean seenColon = false;
        boolean start = true;
for(;length-- > 0;offset++)
        {
            char ch = buff[offset];
    if(Character.isLetter(ch) || ch == '_')            
            {
                start = false;
                dst.append(ch);
            } //End block
            else
    if(Character.isDigit(ch) || ch == '-' || ch == '.')            
            {
    if(start)                
                dst.append('_');
                start = false;
                dst.append(ch);
            } //End block
            else
    if(ch == ':' && !seenColon)            
            {
                seenColon = true;
    if(start)                
                dst.append('_');
                start = true;
                dst.append(translateColons ? '_' : ch);
            } //End block
        } //End block
        int dstLength = dst.length();
    if(dstLength == 0 || dst.charAt(dstLength - 1) == ':')        
        dst.append('_');
String var88E982745ADCD76FA64A8EF43E020057_48811248 =         dst.toString().intern();
        var88E982745ADCD76FA64A8EF43E020057_48811248.addTaint(taint);
        return var88E982745ADCD76FA64A8EF43E020057_48811248;
        // ---------- Original Method ----------
        //StringBuffer dst = new StringBuffer(length + 2);
        //boolean seenColon = false;
        //boolean start = true;
        //for (; length-- > 0; offset++) {
			//char ch = buff[offset];
			//if (Character.isLetter(ch) || ch == '_') {
				//start = false;
				//dst.append(ch);
				//}
			//else if (Character.isDigit(ch) || ch == '-' || ch == '.') {
				//if (start) dst.append('_');
				//start = false;
				//dst.append(ch);
				//}
			//else if (ch == ':' && !seenColon) {
				//seenColon = true;
				//if (start) dst.append('_');
				//start = true;
				//dst.append(translateColons ? '_' : ch);
				//}
			//}
        //int dstLength = dst.length();
        //if (dstLength == 0 || dst.charAt(dstLength - 1) == ':') dst.append('_');
        //return dst.toString().intern();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.350 -0400", hash_original_method = "213183511FA9CBC21D458599F3954E65", hash_generated_method = "A571046559E9FE76248D4925C76926B1")
    public void comment(char[] ch, int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.350 -0400", hash_original_method = "B026A18FCF4D46E60EDFCDEA2654D91E", hash_generated_method = "B842EEA0DE9052ECF61866BD9EB9FFB0")
    public void endCDATA() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.350 -0400", hash_original_method = "3D36862B53F533617A1DD5C66B985713", hash_generated_method = "84D215898BE9C8AA399821A662E8380F")
    public void endDTD() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.350 -0400", hash_original_method = "A799CD2136F4389F2AB6AC2E97C1C7E3", hash_generated_method = "2EAC67D67612A09592B6D4AE3BE5EB34")
    public void endEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.351 -0400", hash_original_method = "E4BBD9A45ED517D6BA1A0F40E8CDD7AD", hash_generated_method = "1EFEFFE32283B3B2E0EFBC09815C5A15")
    public void startCDATA() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.351 -0400", hash_original_method = "6BDC1CD16BCB1071C2A9E7A68AA16026", hash_generated_method = "1695C65D06956AC82C1CCC632491C06C")
    public void startDTD(String name, String publicid, String systemid) throws SAXException {
        addTaint(systemid.getTaint());
        addTaint(publicid.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.351 -0400", hash_original_method = "DCC3E349AFEA1A7195E89C47AA33A3E4", hash_generated_method = "CD87BEA40ED554D51CC2691C961E2B5E")
    public void startEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.351 -0400", hash_original_field = "FDA472C43B89F365E9A1461DF76B0BF8", hash_generated_field = "8C65D693E4988ED7894951639899EFA7")

    private static boolean DEFAULT_NAMESPACES = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.351 -0400", hash_original_field = "39E57165115180217AF8B1E683D6E8FE", hash_generated_field = "95CB3BC4361BA9B6FF9E9F70A90DAD03")

    private static boolean DEFAULT_IGNORE_BOGONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.351 -0400", hash_original_field = "27F78B48D8365726EA3D40BB67514F33", hash_generated_field = "C1B97603EF870B3B0E60C4840424A571")

    private static boolean DEFAULT_BOGONS_EMPTY = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.351 -0400", hash_original_field = "2A2B8A2692D9DAEFBF7912E5BD12FE44", hash_generated_field = "7DFA3CA9505571283CB90D1D2363FF9B")

    private static boolean DEFAULT_ROOT_BOGONS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "7E26D3CF232F33D0ECB2B2C9F99CC948", hash_generated_field = "C52EF402C6C7D6C4E13363F89BA4C9CC")

    private static boolean DEFAULT_DEFAULT_ATTRIBUTES = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "028C99841C24DC81B01699E1CD9C1E3C", hash_generated_field = "8EA188B97877D5C056C8FFECB4A916D5")

    private static boolean DEFAULT_TRANSLATE_COLONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "2C205E5EF348CD21E92F2D0D8C31A9D8", hash_generated_field = "23FE955BFE2713EF46107ED432FA524F")

    private static boolean DEFAULT_RESTART_ELEMENTS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "A19D57FECC021D957A9D6367282963D5", hash_generated_field = "FD9FE242EBAEBB21389F3374291F0873")

    private static boolean DEFAULT_IGNORABLE_WHITESPACE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "8BDBC02EA15AC1F310DA84A0BF5B7B03", hash_generated_field = "CD35A69CF70628A1FE7FC19224E80910")

    private static boolean DEFAULT_CDATA_ELEMENTS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "CBE203F05B2CA0B9371F29AA84B6482F", hash_generated_field = "F3EBD8EB0AAB95778649118E621BDF3A")

    public final static String namespacesFeature =
		"http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "D52935676D6A9AF09FB45CBC2935E9B7", hash_generated_field = "E7FEE848C76AD7E3496C4E630A78BB81")

    public final static String namespacePrefixesFeature =
		"http://xml.org/sax/features/namespace-prefixes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "5C95C514F70C3F068B0BE5AF15A2A43F", hash_generated_field = "4960CE938280E09CACB47773B253189A")

    public final static String externalGeneralEntitiesFeature =
		"http://xml.org/sax/features/external-general-entities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "658D44BC5BB1EB6645D7C1FCBB48C990", hash_generated_field = "645AC9F0D99476599CC2C5D420FBCEF2")

    public final static String externalParameterEntitiesFeature =
		"http://xml.org/sax/features/external-parameter-entities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "AB2109BB983DF49644BC4D38FD8908C3", hash_generated_field = "98E16839D8A858A412C6507FCFC65238")

    public final static String isStandaloneFeature =
		"http://xml.org/sax/features/is-standalone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "6640AE650FB683FAD5F8EB264C24716D", hash_generated_field = "59F9AF3A3A0609C6E2AD94D8503C5DB8")

    public final static String lexicalHandlerParameterEntitiesFeature =
		"http://xml.org/sax/features/lexical-handler/parameter-entities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "AD8D2FDDED245AE266062C0C77225B37", hash_generated_field = "E4001DA9C670BFD243A4A5A5AFD7B06A")

    public final static String resolveDTDURIsFeature =
		"http://xml.org/sax/features/resolve-dtd-uris";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "1CD45B6030C3D627272D2296E150A430", hash_generated_field = "779F7448C8785232BD7DFD5A67948D0A")

    public final static String stringInterningFeature =
		"http://xml.org/sax/features/string-interning";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "B6829CB37B8188614BF3D51C497DD9B9", hash_generated_field = "FAAA57EA66A4B1C99F05BEE9CC5BC5C0")

    public final static String useAttributes2Feature =
		"http://xml.org/sax/features/use-attributes2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "BF59322658E588694685DEC393C54C29", hash_generated_field = "73D5341F2654195F0D7797F0A3BD736C")

    public final static String useLocator2Feature =
		"http://xml.org/sax/features/use-locator2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.352 -0400", hash_original_field = "A09EE879154FBE7DE4002FFF3345A098", hash_generated_field = "E57D37F2ED0F4BEDDBE77B9CD1285626")

    public final static String useEntityResolver2Feature =
		"http://xml.org/sax/features/use-entity-resolver2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "307E98EB62A5312313099D983C796AE7", hash_generated_field = "AE045FBF898962BE8139B1301F2E291D")

    public final static String validationFeature =
		"http://xml.org/sax/features/validation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "3A13710096A3DBE64F7756CF5085C100", hash_generated_field = "FFF09C3BD393A94D09CA8784BA24B96C")

    public final static String unicodeNormalizationCheckingFeature =
"http://xml.org/sax/features/unicode-normalization-checking";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "F3C5D1101AD8D4F65202FCFB19C36456", hash_generated_field = "70DBEF739EE1118B51EF01363B966D8D")

    public final static String xmlnsURIsFeature =
		"http://xml.org/sax/features/xmlns-uris";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "650B79A67222EA6D3341B9716ABC3053", hash_generated_field = "5488477B90537AA19EE8E80FB08A056E")

    public final static String XML11Feature =
		"http://xml.org/sax/features/xml-1.1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "AC49918E1F05210FC8C9B4FF14E040B4", hash_generated_field = "DF8EFD4BEA7B3EC8130EE8349D424963")

    public final static String ignoreBogonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "DA6F693FB41999A038B5B419D3409E22", hash_generated_field = "32DC43A44181D8F10A0C6982CE0B6386")

    public final static String bogonsEmptyFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/bogons-empty";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "5627ACA9985707513D6A14B3EC7BCB86", hash_generated_field = "3A5CBA372BE7A2473B1668328C41DB6A")

    public final static String rootBogonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/root-bogons";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "779DB4AA891EDB9E144B97279DA416F9", hash_generated_field = "DEB6886124B5BC7131E5CC87524A695D")

    public final static String defaultAttributesFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/default-attributes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "0256698EF168C5D444E14E4E4699E8FD", hash_generated_field = "1DC8012EA98D5A5A9DA782EFE46C2147")

    public final static String translateColonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/translate-colons";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "AD512555C6D37698B7A26DAEDBE0A71F", hash_generated_field = "1772BBD7B67CE6A02034F6A6306E4FA9")

    public final static String restartElementsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/restart-elements";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "D7FF58AEB0D1D5C5D0FBCFD8B72F5097", hash_generated_field = "1D5F6B2A86BD9224BC22C54DF3AFC220")

    public final static String ignorableWhitespaceFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "8C4850F356F09C1E1817199AF1BA9412", hash_generated_field = "A2B4D8B75BBD10B44AC6D98553F23134")

    public final static String CDATAElementsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/cdata-elements";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "864E435C8FE2D34CA924515B58974FE1", hash_generated_field = "8A5D5A73966E1FD73F6F608DF4773448")

    public final static String lexicalHandlerProperty =
		"http://xml.org/sax/properties/lexical-handler";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "0E8265968446AAB70E17960A3862DDBB", hash_generated_field = "E3DE5D25612341B98A05128F19EC757A")

    public final static String scannerProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/scanner";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "DF9D81FCF7F6977891C1CCF56A6713A1", hash_generated_field = "BD853C15AC79E307C4DD428564DA6936")

    public final static String schemaProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/schema";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "8AB20749254B8DAAD61D5EABC4084D6C", hash_generated_field = "E5BF44D1D2EEF754BB72858FBBA9AE93")

    public final static String autoDetectorProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/auto-detector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "9B12556EA7AF013C13C37CC02AC04398", hash_generated_field = "F9A296D96DE887875437F32B036C0ACB")

    private static char[] etagchars = {'<', '/', '>'};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.353 -0400", hash_original_field = "3DA2D60427A86A5D373A3D66A4F04CA8", hash_generated_field = "E6F625E3403F0099E2C98CB06235CCBA")

    private static String legal = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
}

