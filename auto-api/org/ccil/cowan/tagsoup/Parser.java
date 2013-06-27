package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ext.LexicalHandler;

public class Parser extends DefaultHandler implements ScanHandler, XMLReader, LexicalHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "E14ACAA95F0ECE7CA53A254FD0FCEE26", hash_generated_field = "4F44CE27A3793F7751E9A2BE62EDA28B")

    private ContentHandler theContentHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "EEA5C4C914011D6FF7FEF9691FD2DE4F", hash_generated_field = "157ADCC7E3B0E4B62A86EF5B1464D34C")

    private LexicalHandler theLexicalHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "339C5D0C3EB24FAAA4930D9ECE8DE761", hash_generated_field = "0250A3E49B4EA1CD2D0A995FF5246D28")

    private DTDHandler theDTDHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "352A6506BD0383F0B38ED5037A15FDB2", hash_generated_field = "5096464DD0A69980B0EFE4F51A07D7A0")

    private ErrorHandler theErrorHandler = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "E8D20D7217E7893F63ECAAD895343E33", hash_generated_field = "1DF35A9855CF0F5158EC878850EAD218")

    private EntityResolver theEntityResolver = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "107D6A6C40AD2744AB6BBBE303D4ACFB", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

    private Schema theSchema;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "B2BDB1731B79F924A65430D31A6CF9EE", hash_generated_field = "4E761DBCC8A2988ECAB555C68CB8DEB1")

    private Scanner theScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "44886C30A8A3125C88734F69BA48C0D1", hash_generated_field = "996675C96C2397ADFF11AC882B20B3F5")

    private AutoDetector theAutoDetector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "136D76008DD364C60C97C06548516C6B", hash_generated_field = "22AE333EFBA532959473DE818E24D5BF")

    private boolean namespaces = DEFAULT_NAMESPACES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "B8969EB270970487395879B1791569E5", hash_generated_field = "41E62687D64F8450440F589FD8B2C7D2")

    private boolean ignoreBogons = DEFAULT_IGNORE_BOGONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.599 -0400", hash_original_field = "F3F0E47E9E32971F9497C16BCA9AFDD2", hash_generated_field = "E4FAEC9CF3158B00C3F5BBDEDAC38D80")

    private boolean bogonsEmpty = DEFAULT_BOGONS_EMPTY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.600 -0400", hash_original_field = "6850604F609C324B81A85ADDF0D7E059", hash_generated_field = "A54F1F17D7ADCFC60A15857E1F85FF45")

    private boolean rootBogons = DEFAULT_ROOT_BOGONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.601 -0400", hash_original_field = "A21DB2DBAD01F7F074D614EF627C1A33", hash_generated_field = "7E383F84EDB4881461124E7E7AB52091")

    private boolean defaultAttributes = DEFAULT_DEFAULT_ATTRIBUTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.601 -0400", hash_original_field = "BA9B87A15B95466220E3570EA9662C82", hash_generated_field = "54CF914E3DF3C6BA59447DE81000C1D8")

    private boolean translateColons = DEFAULT_TRANSLATE_COLONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.601 -0400", hash_original_field = "306B4CE43758B73F2FC233095E71EF22", hash_generated_field = "B712CFA3553BE13E45826B673C86681F")

    private boolean restartElements = DEFAULT_RESTART_ELEMENTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.602 -0400", hash_original_field = "025256159E2BABE1BC18E52DAE46AF57", hash_generated_field = "78FB9F9549B57ED6D280AA8E51B31437")

    private boolean ignorableWhitespace = DEFAULT_IGNORABLE_WHITESPACE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.602 -0400", hash_original_field = "8A07730721F622E2BE6D01635DEEC33C", hash_generated_field = "6315C4913628D4F5D0A650689FEE53F5")

    private boolean CDATAElements = DEFAULT_CDATA_ELEMENTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.602 -0400", hash_original_field = "982778EB7D40A5EDFE53E3024952EF4C", hash_generated_field = "914C35307726F423CC214D5F05BD1792")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.602 -0400", hash_original_field = "FEE896B51F9EA9C3A6A2CACA78327B0B", hash_generated_field = "F665FAD1114786BD257F52AD4EA88050")

    private Element theNewElement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.602 -0400", hash_original_field = "B6EC96894CDD9EABA41D9A85987A021F", hash_generated_field = "3971348F960D66262BE9AAD85DDDAD51")

    private String theAttributeName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.603 -0400", hash_original_field = "4BE6E9F25C27D2D7A70C3064273D8021", hash_generated_field = "16F18AE13D1847204B3580570C01FD87")

    private boolean theDoctypeIsPresent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.604 -0400", hash_original_field = "C34118D8631D4E0CBDC1F27A585914B6", hash_generated_field = "94C2B01EF19C224943FE0663341AF33A")

    private String theDoctypePublicId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.604 -0400", hash_original_field = "4C917A66C9A4161093180E54D763151C", hash_generated_field = "0B8C1584143BEE93C46504097391530E")

    private String theDoctypeSystemId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.604 -0400", hash_original_field = "CE0F52CFB2F54C4AD7E9126D01BD5B60", hash_generated_field = "247F70B5D7C6F8B059A348D2387FBC13")

    private String theDoctypeName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_field = "15E4A39D4B3ED29C59EB47338F66FF11", hash_generated_field = "080BFB2033564D1CB69BD1F7C08184D6")

    private String thePITarget = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_field = "8CCAE25BBDA5BC0AF71EFBA782D14594", hash_generated_field = "43C38F93E7447D1ED933F58636348D3D")

    private Element theStack = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_field = "2F5CD5EF76ECA64E8FF917FDFE4D715C", hash_generated_field = "C6DD2154E4DDD283E34159243942ADBC")

    private Element theSaved = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_field = "F10E624D97E7893D5B1AB4FA6E197997", hash_generated_field = "697A580E609D0A168C8A8EB97FAF20FE")

    private Element thePCDATA = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_field = "BF8C9B53F357D8AF6BEEE753391E3CBC", hash_generated_field = "15E2820171C06161A279611A152EA754")

    private int theEntity = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_field = "E5F3558DE98E5F834B93385EBD5FF568", hash_generated_field = "C5A55747785458B1F50A346028B62596")

    private boolean virginStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_field = "281067624171488397F98EDFDC0B72F1", hash_generated_field = "36FBB60F8B3CE9EA610621F518B77851")

    private char[] theCommentBuffer = new char[2000];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.605 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }


        private static Boolean truthValue(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.606 -0400", hash_original_method = "FDD541AC7ACF46AD908991FDB1EF4671", hash_generated_method = "AD21DD3B9987D9ECC67FDEDA2E3F7A66")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        Boolean b;
        b = (Boolean)theFeatures.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Unknown feature " + name);
        } //End block
        boolean var0EBB926AE3B165BBD4C68847EB79C92D_1289416462 = (b.booleanValue());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089074286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089074286;
        // ---------- Original Method ----------
        //Boolean b = (Boolean)theFeatures.get(name);
        //if (b == null) {
			//throw new SAXNotRecognizedException("Unknown feature " + name);
			//}
        //return b.booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.614 -0400", hash_original_method = "DD81CF03E95A92E28D68E44755507EB5", hash_generated_method = "19E1EBD5B9A31465E1E51383E2AF2E75")
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        Boolean b;
        b = (Boolean)theFeatures.get(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Unknown feature " + name);
        } //End block
        theFeatures.put(name, Boolean.TRUE);
        theFeatures.put(name, Boolean.FALSE);
        {
            boolean varB999438CA29B9A53D014E8568589A176_328084907 = (name.equals(namespacesFeature));
            namespaces = value;
            {
                boolean var45BCA65926F55945A8ADBC7B5842EDCE_1846492181 = (name.equals(ignoreBogonsFeature));
                ignoreBogons = value;
                {
                    boolean varE7B32758FBF194E0A94DA052294E583D_1620060015 = (name.equals(bogonsEmptyFeature));
                    bogonsEmpty = value;
                    {
                        boolean varA00C2A13BAC03EBE200CC56CCB844E82_245093362 = (name.equals(rootBogonsFeature));
                        rootBogons = value;
                        {
                            boolean varBB6B465A8216FD529A6A8982BD55DC75_128607831 = (name.equals(defaultAttributesFeature));
                            defaultAttributes = value;
                            {
                                boolean varDBED31F5EA459E5A8BD23ED2F02340A6_923788295 = (name.equals(translateColonsFeature));
                                translateColons = value;
                                {
                                    boolean varC10543478DF11910C8B92E7ECFD2784A_1629174334 = (name.equals(restartElementsFeature));
                                    restartElements = value;
                                    {
                                        boolean var738001F266E3BDE2C47CA637B9303D4D_1438354746 = (name.equals(ignorableWhitespaceFeature));
                                        ignorableWhitespace = value;
                                        {
                                            boolean var500CCF21E5E297BBBF5E3790A095172C_1031594937 = (name.equals(CDATAElementsFeature));
                                            CDATAElements = value;
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.616 -0400", hash_original_method = "F750AD287EF0AB9FAAF84C1118421011", hash_generated_method = "D15100A7103B5305CC845612318A49C2")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_875881049 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_2058616579 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_66525098 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_739084000 = null; //Variable for return #4
        {
            boolean varC6FE91F9C962C9DBE79B7BD73AD8CA2E_71492997 = (name.equals(lexicalHandlerProperty));
            {
                varB4EAC82CA7396A68D541C85D26508E83_875881049 = theLexicalHandler == this ? null : theLexicalHandler;
            } //End block
            {
                boolean var40A5273AAD7FE4391718F8D798E2673F_120935109 = (name.equals(scannerProperty));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2058616579 = theScanner;
                } //End block
                {
                    boolean var7EE9960D443D1E1FDC6D8992E4B1768D_261632657 = (name.equals(schemaProperty));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_66525098 = theSchema;
                    } //End block
                    {
                        boolean varEC519B9C85DD3F03C6D0545EECF99487_1077873718 = (name.equals(autoDetectorProperty));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_739084000 = theAutoDetector;
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Unknown property " + name);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_304186797; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_304186797 = varB4EAC82CA7396A68D541C85D26508E83_875881049;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_304186797 = varB4EAC82CA7396A68D541C85D26508E83_2058616579;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_304186797 = varB4EAC82CA7396A68D541C85D26508E83_66525098;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_304186797 = varB4EAC82CA7396A68D541C85D26508E83_739084000;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_304186797.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_304186797;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.667 -0400", hash_original_method = "A91E5B1E97A27DD267128DBDD8DC4544", hash_generated_method = "4DCBABD2BEA0A6793F617AB343944A20")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            boolean varC6FE91F9C962C9DBE79B7BD73AD8CA2E_1574458719 = (name.equals(lexicalHandlerProperty));
            {
                {
                    theLexicalHandler = this;
                } //End block
                {
                    theLexicalHandler = (LexicalHandler)value;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
                } //End block
            } //End block
            {
                boolean var40A5273AAD7FE4391718F8D798E2673F_817128752 = (name.equals(scannerProperty));
                {
                    {
                        theScanner = (Scanner)value;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Your scanner is not a Scanner");
                    } //End block
                } //End block
                {
                    boolean var7EE9960D443D1E1FDC6D8992E4B1768D_638965166 = (name.equals(schemaProperty));
                    {
                        {
                            theSchema = (Schema)value;
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Your schema is not a Schema");
                        } //End block
                    } //End block
                    {
                        boolean varEC519B9C85DD3F03C6D0545EECF99487_1790648255 = (name.equals(autoDetectorProperty));
                        {
                            {
                                theAutoDetector = (AutoDetector)value;
                            } //End block
                            {
                                if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
                            } //End block
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException("Unknown property " + name);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.668 -0400", hash_original_method = "A546AE41DB77A7324A8896ECCFDC28F7", hash_generated_method = "A8E69E6385944504A37F5388E7A83FAB")
    public void setEntityResolver(EntityResolver resolver) {
        theEntityResolver = (resolver == null) ? this : resolver;
        // ---------- Original Method ----------
        //theEntityResolver = (resolver == null) ? this : resolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.668 -0400", hash_original_method = "4B11F09BEC63C73E852BF6819D5E17A6", hash_generated_method = "7D7776B349171F7A0991230E55434B7E")
    public EntityResolver getEntityResolver() {
        EntityResolver varB4EAC82CA7396A68D541C85D26508E83_1930556920 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1930556920 = (theEntityResolver == this) ? null : theEntityResolver;
        varB4EAC82CA7396A68D541C85D26508E83_1930556920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1930556920;
        // ---------- Original Method ----------
        //return (theEntityResolver == this) ? null : theEntityResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.669 -0400", hash_original_method = "2A1D8AFABC32A2E0B1A4A173104FD709", hash_generated_method = "3683677B0F46E370F6EB575FDBECDF36")
    public void setDTDHandler(DTDHandler handler) {
        theDTDHandler = (handler == null) ? this : handler;
        // ---------- Original Method ----------
        //theDTDHandler = (handler == null) ? this : handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.673 -0400", hash_original_method = "338D21F6A8224B73088A08444EBB70F8", hash_generated_method = "9A805D8FC38D4ED0A573AB5E704B3649")
    public DTDHandler getDTDHandler() {
        DTDHandler varB4EAC82CA7396A68D541C85D26508E83_1180338724 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1180338724 = (theDTDHandler == this) ? null : theDTDHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1180338724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1180338724;
        // ---------- Original Method ----------
        //return (theDTDHandler == this) ? null : theDTDHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.676 -0400", hash_original_method = "F2917252F8D6F02CF50CD455848B7CDD", hash_generated_method = "ACB9649AEA4D4CF5ABBC38AFBB15C07D")
    public void setContentHandler(ContentHandler handler) {
        theContentHandler = (handler == null) ? this : handler;
        // ---------- Original Method ----------
        //theContentHandler = (handler == null) ? this : handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.677 -0400", hash_original_method = "E2D49645B9897F446183B1EC842A5B8C", hash_generated_method = "29C206F5834B886345DF98DFADC9D425")
    public ContentHandler getContentHandler() {
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_1010091392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1010091392 = (theContentHandler == this) ? null : theContentHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1010091392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1010091392;
        // ---------- Original Method ----------
        //return (theContentHandler == this) ? null : theContentHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.678 -0400", hash_original_method = "4FC35E4E9BBEBB25DC834EFC47A653D4", hash_generated_method = "8B0B4CCC460D0E90458738C6876CF2B6")
    public void setErrorHandler(ErrorHandler handler) {
        theErrorHandler = (handler == null) ? this : handler;
        // ---------- Original Method ----------
        //theErrorHandler = (handler == null) ? this : handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.678 -0400", hash_original_method = "662542919C9F3C78B54F5CA00EE88FD5", hash_generated_method = "1E139E3AE76BE7706D49B194E60BD055")
    public ErrorHandler getErrorHandler() {
        ErrorHandler varB4EAC82CA7396A68D541C85D26508E83_2106310027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2106310027 = (theErrorHandler == this) ? null : theErrorHandler;
        varB4EAC82CA7396A68D541C85D26508E83_2106310027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2106310027;
        // ---------- Original Method ----------
        //return (theErrorHandler == this) ? null : theErrorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.682 -0400", hash_original_method = "5995949AA97E47EEEF7CCC54B7A2CDFD", hash_generated_method = "1DC2AFC0282BF6170D47009F96694998")
    public void parse(InputSource input) throws IOException, SAXException {
        setup();
        Reader r;
        r = getReader(input);
        theContentHandler.startDocument();
        theScanner.resetDocumentLocator(input.getPublicId(), input.getSystemId());
        {
            theContentHandler.setDocumentLocator((Locator)theScanner);
        } //End block
        {
            boolean varE091D9C85AB3E845E67A10E80BF3F82B_826114649 = (!(theSchema.getURI().equals("")));
            theContentHandler.startPrefixMapping(theSchema.getPrefix(),
				theSchema.getURI());
        } //End collapsed parenthetic
        theScanner.scan(r, this);
        addTaint(input.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.696 -0400", hash_original_method = "84CD70DF516C08D97CF2D35EEDEEB169", hash_generated_method = "F284056506E2AEFC2E7DD82D66669ABF")
    public void parse(String systemid) throws IOException, SAXException {
        parse(new InputSource(systemid));
        addTaint(systemid.getTaint());
        // ---------- Original Method ----------
        //parse(new InputSource(systemid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.726 -0400", hash_original_method = "4BDCB9FDB6AA49AD5AB8549244541048", hash_generated_method = "533C3C877F3D2F6037710A0B358D8954")
    private void setup() {
        theSchema = new HTMLSchema();
        theScanner = new HTMLScanner();
        {
            theAutoDetector = new AutoDetector() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.698 -0400", hash_original_method = "85BE25D56154FC2B6F5EE396BFE70BBC", hash_generated_method = "2A38E47ACD54277C11340AC198294D4A")
                public Reader autoDetectingReader(InputStream i) {
                    Reader varB4EAC82CA7396A68D541C85D26508E83_1944158523 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1944158523 = new InputStreamReader(i);
                    addTaint(i.getTaint());
                    varB4EAC82CA7396A68D541C85D26508E83_1944158523.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1944158523;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.727 -0400", hash_original_method = "0FC12B7CFED0DCE2629E4B14587480A6", hash_generated_method = "6556D7415500B6F92F36991BFC1C0C99")
    private Reader getReader(InputSource s) throws SAXException, IOException {
        Reader varB4EAC82CA7396A68D541C85D26508E83_946972427 = null; //Variable for return #1
        Reader r;
        r = s.getCharacterStream();
        InputStream i;
        i = s.getByteStream();
        String encoding;
        encoding = s.getEncoding();
        String publicid;
        publicid = s.getPublicId();
        String systemid;
        systemid = s.getSystemId();
        {
            i = getInputStream(publicid, systemid);
            {
                r = theAutoDetector.autoDetectingReader(i);
            } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_946972427 = r;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_946972427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946972427;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.728 -0400", hash_original_method = "CDC68ACD7694626FF67B6B6D163E3BB7", hash_generated_method = "F8AE3907CFCEB4A1C2272BFC9A63DFA3")
    private InputStream getInputStream(String publicid, String systemid) throws IOException, SAXException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1640638433 = null; //Variable for return #1
        URL basis;
        basis = new URL("file", "", System.getProperty("user.dir") + "/.");
        URL url;
        url = new URL(basis, systemid);
        URLConnection c;
        c = url.openConnection();
        varB4EAC82CA7396A68D541C85D26508E83_1640638433 = c.getInputStream();
        addTaint(publicid.getTaint());
        addTaint(systemid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1640638433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1640638433;
        // ---------- Original Method ----------
        //URL basis = new URL("file", "", System.getProperty("user.dir") + "/.");
        //URL url = new URL(basis, systemid);
        //URLConnection c = url.openConnection();
        //return c.getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.729 -0400", hash_original_method = "35040F07E07C8DEC63311B713CED1F9F", hash_generated_method = "00B0C6C6C8D43E361AC312BCCD4FAB00")
    public void adup(char[] buff, int offset, int length) throws SAXException {
        theNewElement.setAttribute(theAttributeName, null, theAttributeName);
        theAttributeName = null;
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (theNewElement == null || theAttributeName == null) return;
        //theNewElement.setAttribute(theAttributeName, null, theAttributeName);
        //theAttributeName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.729 -0400", hash_original_method = "C9FB1DE82C24B4094C9FB21723BCABB8", hash_generated_method = "A2E0851E98889B9D4F85864E085B3650")
    public void aname(char[] buff, int offset, int length) throws SAXException {
        theAttributeName = makeName(buff, offset, length).toLowerCase();
        // ---------- Original Method ----------
        //if (theNewElement == null) return;
        //theAttributeName = makeName(buff, offset, length).toLowerCase();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.744 -0400", hash_original_method = "B00CA1167B22D91DBB3A58CD90B87CBC", hash_generated_method = "E96DEF7AD083EAF85BE71145814DC2D9")
    public void aval(char[] buff, int offset, int length) throws SAXException {
        String value;
        value = new String(buff, offset, length);
        value = expandEntities(value);
        theNewElement.setAttribute(theAttributeName, null, value);
        theAttributeName = null;
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (theNewElement == null || theAttributeName == null) return;
        //String value = new String(buff, offset, length);
        //value = expandEntities(value);
        //theNewElement.setAttribute(theAttributeName, null, value);
        //theAttributeName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.746 -0400", hash_original_method = "BD88D393D059FDFF1FEBA4E80D3AAF56", hash_generated_method = "DBC7217EE194AFAC125C4776DBD31D83")
    private String expandEntities(String src) {
        String varB4EAC82CA7396A68D541C85D26508E83_542923168 = null; //Variable for return #1
        int refStart;
        refStart = -1;
        int len;
        len = src.length();
        char[] dst;
        dst = new char[len];
        int dstlen;
        dstlen = 0;
        {
            int i;
            i = 0;
            {
                char ch;
                ch = src.charAt(i);
                dst[dstlen++] = ch;
                {
                    refStart = dstlen;
                } //End block
                {
                    boolean var3439DE9FA874E8269F5A3EB942EC5A1F_2083287907 = (Character.isLetter(ch) ||
					Character.isDigit(ch) ||
					ch == '#');
                    {
                        int ent;
                        ent = lookupEntity(dst, refStart, dstlen - refStart - 1);
                        {
                            ent -= 0x10000;
                            dst[refStart - 1] = (char)((ent>>10) + 0xD800);
                            dst[refStart] = (char)((ent&0x3FF) + 0xDC00);
                            dstlen = refStart + 1;
                        } //End block
                        {
                            dst[refStart - 1] = (char)ent;
                            dstlen = refStart;
                        } //End block
                        refStart = -1;
                    } //End block
                    {
                        refStart = -1;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_542923168 = new String(dst, 0, dstlen);
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_542923168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_542923168;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.747 -0400", hash_original_method = "38A8EAE3BE9C6B2369CA0ABEFF20DED1", hash_generated_method = "46345302BE4543B332C8C9596818D864")
    public void entity(char[] buff, int offset, int length) throws SAXException {
        theEntity = lookupEntity(buff, offset, length);
        // ---------- Original Method ----------
        //theEntity = lookupEntity(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.747 -0400", hash_original_method = "9575B162D435E8F9BEA7F0ECC81D324A", hash_generated_method = "D52603E463C954B838E6F85E07834CE1")
    private int lookupEntity(char[] buff, int offset, int length) {
        int result;
        result = 0;
        {
            {
                try 
                {
                    int var978E107AE58287C6EB509CA43C6C8191_1996982978 = (Integer.parseInt(new String(buff, offset + 2, length - 2), 16));
                } //End block
                catch (NumberFormatException e)
                { }
            } //End block
            try 
            {
                int varA2809DC60E6E1CA26DD7A94A40FE2658_1334446637 = (Integer.parseInt(new String(buff, offset + 1, length - 1), 10));
            } //End block
            catch (NumberFormatException e)
            { }
        } //End block
        int var6F145E2B791DA99A9D06E3ECA1D97221_1318349998 = (theSchema.getEntity(new String(buff, offset, length)));
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_50440193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_50440193;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.751 -0400", hash_original_method = "0A8BABE6DCD2F294E63CAA7BFD276118", hash_generated_method = "D1C40F0E3D197B684601F23CB00D247F")
    public void eof(char[] buff, int offset, int length) throws SAXException {
        rectify(thePCDATA);
        {
            boolean var540615383CF63E86727721DC9B9EC95E_124392361 = (theStack.next() != null);
            {
                pop();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE091D9C85AB3E845E67A10E80BF3F82B_1825046622 = (!(theSchema.getURI().equals("")));
            theContentHandler.endPrefixMapping(theSchema.getPrefix());
        } //End collapsed parenthetic
        theContentHandler.endDocument();
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (virginStack) rectify(thePCDATA);
        //while (theStack.next() != null) {
			//pop();
			//}
        //if (!(theSchema.getURI().equals("")))
			//theContentHandler.endPrefixMapping(theSchema.getPrefix());
        //theContentHandler.endDocument();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.751 -0400", hash_original_method = "551A0AD1D8D7CCFDEAB6F03D7C2481C3", hash_generated_method = "DB8CF295889DCD058474B2714235CEF1")
    public void etag(char[] buff, int offset, int length) throws SAXException {
        {
            boolean var27573E21D4E95AF1335D7E5D8FA0B439_1344802850 = (etag_cdata(buff, offset, length));
        } //End collapsed parenthetic
        etag_basic(buff, offset, length);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (etag_cdata(buff, offset, length)) return;
        //etag_basic(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.769 -0400", hash_original_method = "C9023F984BCCCBD84980442CF55120FA", hash_generated_method = "7E9574536570763756ADEF9CD6EABC51")
    public boolean etag_cdata(char[] buff, int offset, int length) throws SAXException {
        String currentName;
        currentName = theStack.name();
        {
            boolean var4A54C3D6E5F1F3C9CD776D759FBF5C23_851555263 = (CDATAElements && (theStack.flags() & Schema.F_CDATA) != 0);
            {
                boolean realTag;
                realTag = (length == currentName.length());
                {
                    {
                        int i;
                        i = 0;
                        {
                            {
                                boolean varE668B308935F7BF754EA8ADA3DEFA594_1162964175 = (Character.toLowerCase(buff[offset + i]) != Character.toLowerCase(currentName.charAt(i)));
                                {
                                    realTag = false;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    theContentHandler.characters(etagchars, 0, 2);
                    theContentHandler.characters(buff, offset, length);
                    theContentHandler.characters(etagchars, 2, 1);
                    theScanner.startCDATA();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710270259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710270259;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.771 -0400", hash_original_method = "F1F8115795B982079B234CC2192B7DDB", hash_generated_method = "5E8B9BED1DC0AD2CA01EFF80FA59AB2F")
    public void etag_basic(char[] buff, int offset, int length) throws SAXException {
        theNewElement = null;
        String name;
        {
            name = makeName(buff, offset, length);
            ElementType type;
            type = theSchema.getElementType(name);
            name = type.name();
        } //End block
        {
            name = theStack.name();
        } //End block
        Element sp;
        boolean inNoforce;
        inNoforce = false;
        {
            sp = theStack;
            sp = sp.next();
            {
                {
                    boolean varDD8CED7D01E09EA4F3056EEC41CDF1AC_513203867 = (sp.name().equals(name));
                } //End collapsed parenthetic
                {
                    boolean varB26043DD670127809B211106B02F9301_1788995930 = ((sp.flags() & Schema.F_NOFORCE) != 0);
                    inNoforce = true;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE49DFC10C5107F76D7AFA8763EE35D9A_193915206 = (sp.next() == null || sp.next().next() == null);
        } //End collapsed parenthetic
        {
            sp.preclose();
        } //End block
        {
            {
                restartablyPop();
            } //End block
            pop();
        } //End block
        {
            boolean varD7D0FBA9F7F09E992A0834D149252723_1153274568 = (theStack.isPreclosed());
            {
                pop();
            } //End block
        } //End collapsed parenthetic
        restart(null);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.772 -0400", hash_original_method = "B330A365C16A276F019BF46E61F37EA8", hash_generated_method = "F76C10BE29445E093C2F9FABFBB34310")
    private void restart(Element e) throws SAXException {
        {
            boolean varFE9EA13F9B03EC40490D16DDC14ACE53_1627800385 = (theSaved != null && theStack.canContain(theSaved) &&
				(e == null || theSaved.canContain(e)));
            {
                Element next;
                next = theSaved.next();
                push(theSaved);
                theSaved = next;
            } //End block
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //while (theSaved != null && theStack.canContain(theSaved) &&
				//(e == null || theSaved.canContain(e))) {
			//Element next = theSaved.next();
			//push(theSaved);
			//theSaved = next;
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.782 -0400", hash_original_method = "C52776A5281CF0A097BB6E08724FB3A1", hash_generated_method = "4F4552341016593B7688190098C46945")
    private void pop() throws SAXException {
        String name;
        name = theStack.name();
        String localName;
        localName = theStack.localName();
        String namespace;
        namespace = theStack.namespace();
        String prefix;
        prefix = prefixOf(name);
        namespace = localName = "";
        theContentHandler.endElement(namespace, localName, name);
        {
            boolean var8D6AA35B85DAC44A4D21AC077A0E9C2E_1236827660 = (foreign(prefix, namespace));
            {
                theContentHandler.endPrefixMapping(prefix);
            } //End block
        } //End collapsed parenthetic
        Attributes atts;
        atts = theStack.atts();
        {
            int i;
            i = atts.getLength() - 1;
            {
                String attNamespace;
                attNamespace = atts.getURI(i);
                String attPrefix;
                attPrefix = prefixOf(atts.getQName(i));
                {
                    boolean varAE27E5C3644440F3D4AD37A9239FF41B_1489307295 = (foreign(attPrefix, attNamespace));
                    {
                        theContentHandler.endPrefixMapping(attPrefix);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.787 -0400", hash_original_method = "C8A2C1B1941DD99452371A15DDB14C88", hash_generated_method = "1D7638C9A7A3D733BC235596055E8B8B")
    private void restartablyPop() throws SAXException {
        Element popped;
        popped = theStack;
        pop();
        {
            boolean varA77178E00DFDBC22F747B947126CBB1F_499295212 = (restartElements && (popped.flags() & Schema.F_RESTART) != 0);
            {
                popped.anonymize();
                popped.setNext(theSaved);
                theSaved = popped;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Element popped = theStack;
        //pop();
        //if (restartElements && (popped.flags() & Schema.F_RESTART) != 0) {
			//popped.anonymize();
			//popped.setNext(theSaved);
			//theSaved = popped;
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.789 -0400", hash_original_method = "CEB0923649F562E1C47AECBE0F37237A", hash_generated_method = "5AE42F5EAE81D1D18889A4A88132E215")
    private void push(Element e) throws SAXException {
        String name;
        name = e.name();
        String localName;
        localName = e.localName();
        String namespace;
        namespace = e.namespace();
        String prefix;
        prefix = prefixOf(name);
        e.clean();
        namespace = localName = "";
        {
            boolean varCD72DC1C41F748C6AC1C7D077D495E92_1434136532 = (virginStack && localName.equalsIgnoreCase(theDoctypeName));
            {
                try 
                {
                    theEntityResolver.resolveEntity(theDoctypePublicId, theDoctypeSystemId);
                } //End block
                catch (IOException ew)
                { }
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8D6AA35B85DAC44A4D21AC077A0E9C2E_1995773377 = (foreign(prefix, namespace));
            {
                theContentHandler.startPrefixMapping(prefix, namespace);
            } //End block
        } //End collapsed parenthetic
        Attributes atts;
        atts = e.atts();
        int len;
        len = atts.getLength();
        {
            int i;
            i = 0;
            {
                String attNamespace;
                attNamespace = atts.getURI(i);
                String attPrefix;
                attPrefix = prefixOf(atts.getQName(i));
                {
                    boolean varAE27E5C3644440F3D4AD37A9239FF41B_76322238 = (foreign(attPrefix, attNamespace));
                    {
                        theContentHandler.startPrefixMapping(attPrefix, attNamespace);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        theContentHandler.startElement(namespace, localName, name, e.atts());
        e.setNext(theStack);
        theStack = e;
        virginStack = false;
        {
            boolean var4A54C3D6E5F1F3C9CD776D759FBF5C23_439076064 = (CDATAElements && (theStack.flags() & Schema.F_CDATA) != 0);
            {
                theScanner.startCDATA();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.797 -0400", hash_original_method = "EBD18CEBBA646E39DB7BD8DC690DDED7", hash_generated_method = "C2E1D5C501CF5F2698C8187DC6C30CDC")
    private String prefixOf(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_289270010 = null; //Variable for return #1
        int i;
        i = name.indexOf(':');
        String prefix;
        prefix = "";
        prefix = name.substring(0, i);
        varB4EAC82CA7396A68D541C85D26508E83_289270010 = prefix;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_289270010.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289270010;
        // ---------- Original Method ----------
        //int i = name.indexOf(':');
        //String prefix = "";
        //if (i != -1) prefix = name.substring(0, i);
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.801 -0400", hash_original_method = "761321F4D2C89C49E6A94969107BF018", hash_generated_method = "254ED61782E5FC6D23CF126FB7B18261")
    private boolean foreign(String prefix, String namespace) {
        boolean foreign;
        foreign = !(prefix.equals("") || namespace.equals("") ||
			namespace.equals(theSchema.getURI()));
        addTaint(prefix.getTaint());
        addTaint(namespace.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1787820499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1787820499;
        // ---------- Original Method ----------
        //boolean foreign = !(prefix.equals("") || namespace.equals("") ||
			//namespace.equals(theSchema.getURI()));
        //return foreign;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.803 -0400", hash_original_method = "1C2CEC982271DB04AB7A74A00D860FDA", hash_generated_method = "A9D1F2C738BD2CD94E4FE871E087633A")
    public void decl(char[] buff, int offset, int length) throws SAXException {
        String s;
        s = new String(buff, offset, length);
        String name;
        name = null;
        String systemid;
        systemid = null;
        String publicid;
        publicid = null;
        String[] v;
        v = split(s);
        {
            boolean var966282C7DC8188EACED7AD95BB900082_649807961 = (v.length > 0 && "DOCTYPE".equals(v[0]));
            {
                theDoctypeIsPresent = true;
                {
                    name = v[1];
                    {
                        boolean var2048EF9E9F87D79E725C2B3B97924664_1751772703 = (v.length>3 && "SYSTEM".equals(v[2]));
                        {
                            systemid = v[3];
                        } //End block
                        {
                            boolean varE9C2DDE808F75B54D652F4AABEB02F00_203888658 = (v.length > 3 && "PUBLIC".equals(v[2]));
                            {
                                publicid = v[3];
                                {
                                    systemid = v[4];
                                } //End block
                                {
                                    systemid = "";
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        publicid = trimquotes(publicid);
        systemid = trimquotes(systemid);
        {
            publicid = cleanPublicid(publicid);
            theLexicalHandler.startDTD(name, publicid, systemid);
            theLexicalHandler.endDTD();
            theDoctypeName = name;
            theDoctypePublicId = publicid;
            {
                theDoctypeSystemId  = ((Locator)theScanner).getSystemId();
                try 
                {
                    theDoctypeSystemId = new URL(new URL(theDoctypeSystemId), systemid).toString();
                } //End block
                catch (Exception e)
                { }
            } //End block
        } //End block
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.809 -0400", hash_original_method = "92ECD15FFBF9920D383290E17881F5A3", hash_generated_method = "CC2CE9B9BBAEAC5E36158B9C75082A19")
    private String cleanPublicid(String src) {
        String varB4EAC82CA7396A68D541C85D26508E83_1473061171 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1853403045 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1473061171 = null;
        int len;
        len = src.length();
        StringBuffer dst;
        dst = new StringBuffer(len);
        boolean suppressSpace;
        suppressSpace = true;
        {
            int i;
            i = 0;
            {
                char ch;
                ch = src.charAt(i);
                {
                    boolean var098D2C842CCD9AA14BB0DB58D76C0099_1910001899 = (legal.indexOf(ch) != -1);
                    {
                        dst.append(ch);
                        suppressSpace = false;
                    } //End block
                    {
                        ;
                    } //End block
                    {
                        dst.append(' ');
                        suppressSpace = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1853403045 = dst.toString().trim();
        addTaint(src.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1186719073; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1186719073 = varB4EAC82CA7396A68D541C85D26508E83_1473061171;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1186719073 = varB4EAC82CA7396A68D541C85D26508E83_1853403045;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1186719073.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1186719073;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.815 -0400", hash_original_method = "7EEA5677E99A2C9EF1241E44C92259AC", hash_generated_method = "2C682844D8F3ED27E72892F0FABADB55")
    public void gi(char[] buff, int offset, int length) throws SAXException {
        String name;
        name = makeName(buff, offset, length);
        ElementType type;
        type = theSchema.getElementType(name);
        {
            int bogonModel;
            bogonModel = Schema.M_EMPTY;
            bogonModel = Schema.M_ANY;
            int bogonMemberOf;
            bogonMemberOf = Schema.M_ANY;
            bogonMemberOf = (Schema.M_ANY & ~ Schema.M_ROOT);
            theSchema.elementType(name, bogonModel, bogonMemberOf, 0);
            theSchema.parent(name, theSchema.rootElementType().name());
            type = theSchema.getElementType(name);
        } //End block
        theNewElement = new Element(type, defaultAttributes);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.816 -0400", hash_original_method = "A6AFE17C00CB0D2270FAE1159A108399", hash_generated_method = "7169A40CA0ECD17415203D0FE0F4E2D7")
    public void cdsect(char[] buff, int offset, int length) throws SAXException {
        theLexicalHandler.startCDATA();
        pcdata(buff, offset, length);
        theLexicalHandler.endCDATA();
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theLexicalHandler.startCDATA();
        //pcdata(buff, offset, length);
        //theLexicalHandler.endCDATA();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.817 -0400", hash_original_method = "087E39444EA30ADF63D8EEFEFF8A4B70", hash_generated_method = "35305B06D92A222BDCCCDC24732A8793")
    public void pcdata(char[] buff, int offset, int length) throws SAXException {
        boolean allWhite;
        allWhite = true;
        {
            int i;
            i = 0;
            {
                {
                    boolean varDEAB6B620E632B386459C840650E770E_1957865210 = (!Character.isWhitespace(buff[offset+i]));
                    {
                        allWhite = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var985799DBB24B57561D1A24D5F6DCF155_1348935451 = (allWhite && !theStack.canContain(thePCDATA));
            {
                {
                    theContentHandler.ignorableWhitespace(buff, offset, length);
                } //End block
            } //End block
            {
                rectify(thePCDATA);
                theContentHandler.characters(buff, offset, length);
            } //End block
        } //End collapsed parenthetic
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.826 -0400", hash_original_method = "10DA4877B62CBC6E2AF531E70FE25E21", hash_generated_method = "1399878BBD73C99DEEE173AC2CA47076")
    public void pitarget(char[] buff, int offset, int length) throws SAXException {
        thePITarget = makeName(buff, offset, length).replace(':', '_');
        // ---------- Original Method ----------
        //if (theNewElement != null) return;
        //thePITarget = makeName(buff, offset, length).replace(':', '_');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.827 -0400", hash_original_method = "373E8AB8CB624AD49A96496DDC7BD596", hash_generated_method = "DAB71A5BC699C86A81FE1F2B72233BAA")
    public void pi(char[] buff, int offset, int length) throws SAXException {
        {
            boolean varAC9AD1201C65CACF79991F27475BF75F_2058512762 = ("xml".equalsIgnoreCase(thePITarget));
        } //End collapsed parenthetic
        theContentHandler.processingInstruction(thePITarget,
			new String(buff, offset, length));
        thePITarget = null;
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (theNewElement != null || thePITarget == null) return;
        //if ("xml".equalsIgnoreCase(thePITarget)) return;
        //if (length > 0 && buff[length - 1] == '?') length--;
        //theContentHandler.processingInstruction(thePITarget,
			//new String(buff, offset, length));
        //thePITarget = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.828 -0400", hash_original_method = "E16C8825C4BEC5864699E25FFFCA21E7", hash_generated_method = "BD8BFD352E20308207F5F9CDF2967B0A")
    public void stagc(char[] buff, int offset, int length) throws SAXException {
        rectify(theNewElement);
        {
            boolean var5A1A48D5F9473E18DAFD7DC5BEAD1BE0_1145528694 = (theStack.model() == Schema.M_EMPTY);
            {
                etag_basic(buff, offset, length);
            } //End block
        } //End collapsed parenthetic
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (theNewElement == null) return;
        //rectify(theNewElement);
        //if (theStack.model() == Schema.M_EMPTY) {
			//etag_basic(buff, offset, length);
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.830 -0400", hash_original_method = "0E3563E6FA953D38A95EC3A2105DD410", hash_generated_method = "9BE98ABFDD4E3CB00CEA9E04AA45D45F")
    public void stage(char[] buff, int offset, int length) throws SAXException {
        rectify(theNewElement);
        etag_basic(buff, offset, length);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //if (theNewElement == null) return;
        //rectify(theNewElement);
        //etag_basic(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.830 -0400", hash_original_method = "A603B5B2E591802383EBFF92F8BBF095", hash_generated_method = "C97BEFD80A41F5282FAB74420703F3A2")
    public void cmnt(char[] buff, int offset, int length) throws SAXException {
        theLexicalHandler.comment(buff, offset, length);
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //theLexicalHandler.comment(buff, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.841 -0400", hash_original_method = "37597577D17F3DB30561754D63AF952D", hash_generated_method = "25C5E7E4BF4AA562D7A5482E1D98F662")
    private void rectify(Element e) throws SAXException {
        Element sp;
        {
            {
                sp = theStack;
                sp = sp.next();
                {
                    {
                        boolean varC459A258EF87F22AB929970DD408ED60_1929111365 = (sp.canContain(e));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ElementType parentType;
            parentType = e.parent();
            Element parent;
            parent = new Element(parentType, defaultAttributes);
            parent.setNext(e);
            e = parent;
        } //End block
        {
            {
                boolean varADA7763A75BF33CA7DF1288ADFDE388C_72607334 = (theStack == null || theStack.next() == null ||
				theStack.next().next() == null);
            } //End collapsed parenthetic
            restartablyPop();
        } //End block
        {
            Element nexte;
            nexte = e.next();
            {
                boolean varFC5A7FCCC0DA00A12E794F6368D1B4AA_23172916 = (!e.name().equals("<pcdata>"));
                push(e);
            } //End collapsed parenthetic
            e = nexte;
            restart(e);
        } //End block
        theNewElement = null;
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.842 -0400", hash_original_method = "7F354BAD0D4521AB4E9BA9D90015CEBE", hash_generated_method = "E68FC68D51D3B59D9EC9EAA50F837BA8")
    public int getEntity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775964577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1775964577;
        // ---------- Original Method ----------
        //return theEntity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.843 -0400", hash_original_method = "C657524A51A66CA45344D36C0B6F5C26", hash_generated_method = "9ED51D202243846C5ECACC72A5340411")
    private String makeName(char[] buff, int offset, int length) {
        String varB4EAC82CA7396A68D541C85D26508E83_184027730 = null; //Variable for return #1
        StringBuffer dst;
        dst = new StringBuffer(length + 2);
        boolean seenColon;
        seenColon = false;
        boolean start;
        start = true;
        {
            char ch;
            ch = buff[offset];
            {
                boolean var3C030E0C8CCC2E51E0D321F5388102E2_1027169534 = (Character.isLetter(ch) || ch == '_');
                {
                    start = false;
                    dst.append(ch);
                } //End block
                {
                    boolean varB125B7BA77A109AC5D5887E4FD63725D_204412047 = (Character.isDigit(ch) || ch == '-' || ch == '.');
                    {
                        dst.append('_');
                        start = false;
                        dst.append(ch);
                    } //End block
                    {
                        seenColon = true;
                        dst.append('_');
                        start = true;
                        dst.append(translateColons ? '_' : ch);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        int dstLength;
        dstLength = dst.length();
        {
            boolean var822F6507ECD5E25DD0E6EB7B5C4634A1_2128919137 = (dstLength == 0 || dst.charAt(dstLength - 1) == ':');
            dst.append('_');
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_184027730 = dst.toString().intern();
        addTaint(buff[0]);
        addTaint(offset);
        addTaint(length);
        varB4EAC82CA7396A68D541C85D26508E83_184027730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_184027730;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.844 -0400", hash_original_method = "213183511FA9CBC21D458599F3954E65", hash_generated_method = "238AE675C70E2F3A007C7608D3C0BBD1")
    public void comment(char[] ch, int start, int length) throws SAXException {
        addTaint(ch[0]);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.844 -0400", hash_original_method = "B026A18FCF4D46E60EDFCDEA2654D91E", hash_generated_method = "B842EEA0DE9052ECF61866BD9EB9FFB0")
    public void endCDATA() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.844 -0400", hash_original_method = "3D36862B53F533617A1DD5C66B985713", hash_generated_method = "84D215898BE9C8AA399821A662E8380F")
    public void endDTD() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.845 -0400", hash_original_method = "A799CD2136F4389F2AB6AC2E97C1C7E3", hash_generated_method = "2EAC67D67612A09592B6D4AE3BE5EB34")
    public void endEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.846 -0400", hash_original_method = "E4BBD9A45ED517D6BA1A0F40E8CDD7AD", hash_generated_method = "1EFEFFE32283B3B2E0EFBC09815C5A15")
    public void startCDATA() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.846 -0400", hash_original_method = "6BDC1CD16BCB1071C2A9E7A68AA16026", hash_generated_method = "9E1C7F9CCC47C9DEF5B5F67A9DD19AEF")
    public void startDTD(String name, String publicid, String systemid) throws SAXException {
        addTaint(name.getTaint());
        addTaint(publicid.getTaint());
        addTaint(systemid.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.846 -0400", hash_original_method = "DCC3E349AFEA1A7195E89C47AA33A3E4", hash_generated_method = "CD87BEA40ED554D51CC2691C961E2B5E")
    public void startEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.847 -0400", hash_original_field = "FDA472C43B89F365E9A1461DF76B0BF8", hash_generated_field = "8C65D693E4988ED7894951639899EFA7")

    private static boolean DEFAULT_NAMESPACES = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.847 -0400", hash_original_field = "39E57165115180217AF8B1E683D6E8FE", hash_generated_field = "95CB3BC4361BA9B6FF9E9F70A90DAD03")

    private static boolean DEFAULT_IGNORE_BOGONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.847 -0400", hash_original_field = "27F78B48D8365726EA3D40BB67514F33", hash_generated_field = "C1B97603EF870B3B0E60C4840424A571")

    private static boolean DEFAULT_BOGONS_EMPTY = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "2A2B8A2692D9DAEFBF7912E5BD12FE44", hash_generated_field = "7DFA3CA9505571283CB90D1D2363FF9B")

    private static boolean DEFAULT_ROOT_BOGONS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "7E26D3CF232F33D0ECB2B2C9F99CC948", hash_generated_field = "C52EF402C6C7D6C4E13363F89BA4C9CC")

    private static boolean DEFAULT_DEFAULT_ATTRIBUTES = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "028C99841C24DC81B01699E1CD9C1E3C", hash_generated_field = "8EA188B97877D5C056C8FFECB4A916D5")

    private static boolean DEFAULT_TRANSLATE_COLONS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "2C205E5EF348CD21E92F2D0D8C31A9D8", hash_generated_field = "23FE955BFE2713EF46107ED432FA524F")

    private static boolean DEFAULT_RESTART_ELEMENTS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "A19D57FECC021D957A9D6367282963D5", hash_generated_field = "FD9FE242EBAEBB21389F3374291F0873")

    private static boolean DEFAULT_IGNORABLE_WHITESPACE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "8BDBC02EA15AC1F310DA84A0BF5B7B03", hash_generated_field = "CD35A69CF70628A1FE7FC19224E80910")

    private static boolean DEFAULT_CDATA_ELEMENTS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "CBE203F05B2CA0B9371F29AA84B6482F", hash_generated_field = "F3EBD8EB0AAB95778649118E621BDF3A")

    public final static String namespacesFeature =
		"http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "D52935676D6A9AF09FB45CBC2935E9B7", hash_generated_field = "E7FEE848C76AD7E3496C4E630A78BB81")

    public final static String namespacePrefixesFeature =
		"http://xml.org/sax/features/namespace-prefixes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "5C95C514F70C3F068B0BE5AF15A2A43F", hash_generated_field = "4960CE938280E09CACB47773B253189A")

    public final static String externalGeneralEntitiesFeature =
		"http://xml.org/sax/features/external-general-entities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "658D44BC5BB1EB6645D7C1FCBB48C990", hash_generated_field = "645AC9F0D99476599CC2C5D420FBCEF2")

    public final static String externalParameterEntitiesFeature =
		"http://xml.org/sax/features/external-parameter-entities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "AB2109BB983DF49644BC4D38FD8908C3", hash_generated_field = "98E16839D8A858A412C6507FCFC65238")

    public final static String isStandaloneFeature =
		"http://xml.org/sax/features/is-standalone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "6640AE650FB683FAD5F8EB264C24716D", hash_generated_field = "59F9AF3A3A0609C6E2AD94D8503C5DB8")

    public final static String lexicalHandlerParameterEntitiesFeature =
		"http://xml.org/sax/features/lexical-handler/parameter-entities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "AD8D2FDDED245AE266062C0C77225B37", hash_generated_field = "E4001DA9C670BFD243A4A5A5AFD7B06A")

    public final static String resolveDTDURIsFeature =
		"http://xml.org/sax/features/resolve-dtd-uris";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "1CD45B6030C3D627272D2296E150A430", hash_generated_field = "779F7448C8785232BD7DFD5A67948D0A")

    public final static String stringInterningFeature =
		"http://xml.org/sax/features/string-interning";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "B6829CB37B8188614BF3D51C497DD9B9", hash_generated_field = "FAAA57EA66A4B1C99F05BEE9CC5BC5C0")

    public final static String useAttributes2Feature =
		"http://xml.org/sax/features/use-attributes2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "BF59322658E588694685DEC393C54C29", hash_generated_field = "73D5341F2654195F0D7797F0A3BD736C")

    public final static String useLocator2Feature =
		"http://xml.org/sax/features/use-locator2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "A09EE879154FBE7DE4002FFF3345A098", hash_generated_field = "E57D37F2ED0F4BEDDBE77B9CD1285626")

    public final static String useEntityResolver2Feature =
		"http://xml.org/sax/features/use-entity-resolver2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "307E98EB62A5312313099D983C796AE7", hash_generated_field = "AE045FBF898962BE8139B1301F2E291D")

    public final static String validationFeature =
		"http://xml.org/sax/features/validation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "3A13710096A3DBE64F7756CF5085C100", hash_generated_field = "FFF09C3BD393A94D09CA8784BA24B96C")

    public final static String unicodeNormalizationCheckingFeature =
"http://xml.org/sax/features/unicode-normalization-checking";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "F3C5D1101AD8D4F65202FCFB19C36456", hash_generated_field = "70DBEF739EE1118B51EF01363B966D8D")

    public final static String xmlnsURIsFeature =
		"http://xml.org/sax/features/xmlns-uris";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.850 -0400", hash_original_field = "650B79A67222EA6D3341B9716ABC3053", hash_generated_field = "5488477B90537AA19EE8E80FB08A056E")

    public final static String XML11Feature =
		"http://xml.org/sax/features/xml-1.1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "AC49918E1F05210FC8C9B4FF14E040B4", hash_generated_field = "DF8EFD4BEA7B3EC8130EE8349D424963")

    public final static String ignoreBogonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "DA6F693FB41999A038B5B419D3409E22", hash_generated_field = "32DC43A44181D8F10A0C6982CE0B6386")

    public final static String bogonsEmptyFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/bogons-empty";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "5627ACA9985707513D6A14B3EC7BCB86", hash_generated_field = "3A5CBA372BE7A2473B1668328C41DB6A")

    public final static String rootBogonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/root-bogons";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "779DB4AA891EDB9E144B97279DA416F9", hash_generated_field = "DEB6886124B5BC7131E5CC87524A695D")

    public final static String defaultAttributesFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/default-attributes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "0256698EF168C5D444E14E4E4699E8FD", hash_generated_field = "1DC8012EA98D5A5A9DA782EFE46C2147")

    public final static String translateColonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/translate-colons";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "AD512555C6D37698B7A26DAEDBE0A71F", hash_generated_field = "1772BBD7B67CE6A02034F6A6306E4FA9")

    public final static String restartElementsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/restart-elements";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "D7FF58AEB0D1D5C5D0FBCFD8B72F5097", hash_generated_field = "1D5F6B2A86BD9224BC22C54DF3AFC220")

    public final static String ignorableWhitespaceFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "8C4850F356F09C1E1817199AF1BA9412", hash_generated_field = "A2B4D8B75BBD10B44AC6D98553F23134")

    public final static String CDATAElementsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/cdata-elements";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "864E435C8FE2D34CA924515B58974FE1", hash_generated_field = "8A5D5A73966E1FD73F6F608DF4773448")

    public final static String lexicalHandlerProperty =
		"http://xml.org/sax/properties/lexical-handler";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "0E8265968446AAB70E17960A3862DDBB", hash_generated_field = "E3DE5D25612341B98A05128F19EC757A")

    public final static String scannerProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/scanner";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "DF9D81FCF7F6977891C1CCF56A6713A1", hash_generated_field = "BD853C15AC79E307C4DD428564DA6936")

    public final static String schemaProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/schema";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "8AB20749254B8DAAD61D5EABC4084D6C", hash_generated_field = "E5BF44D1D2EEF754BB72858FBBA9AE93")

    public final static String autoDetectorProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/auto-detector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "9B12556EA7AF013C13C37CC02AC04398", hash_generated_field = "EF6DE92013DA8F47E1626B2433517AA2")

    private static char[] etagchars = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.851 -0400", hash_original_field = "3DA2D60427A86A5D373A3D66A4F04CA8", hash_generated_field = "E6F625E3403F0099E2C98CB06235CCBA")

    private static String legal = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
}

