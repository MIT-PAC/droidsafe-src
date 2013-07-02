package org.xml.sax.helpers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "98AEDCDD6727BD81632D9F9CB201EE47", hash_generated_field = "E45249B9729220F661033FE0273CAECE")
	private NamespaceSupport nsSupport;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "8E7E1A4BC0AA1454679F0E7EEA5531E9", hash_generated_field = "995A52C4CFBC84030E5C3B84FDD67C5A")
	private AttributeListAdapter attAdapter;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "5F5944B82735B9CF51523BBC1223615E", hash_generated_field = "B2B6F03C3323CC2E5DF880878C6AD064")
	private boolean parsing = false;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "16F80F22BCD24DC823FEEA455EDB94D1", hash_generated_field = "9D06BBFBDDCCC6F79C4828C391273388")
	private String nameParts[] = new String[3];
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "311E305FB0D751192221DEAFF834950C", hash_generated_field = "C1941098165849B9BB09C918699765BA")
	private Parser parser = null;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "8F2051083EF5F7D90FAE9F582E10ED23", hash_generated_field = "1C437322B74865B450A5CD9EA125241E")
	private AttributesImpl atts = null;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "312A8D34A10A42AF3135F707FD689CB4", hash_generated_field = "F2647CFF1692834895465A43B4FBE112")
	private boolean namespaces = true;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "466ECE05D09617567128504C4EB72E25", hash_generated_field = "3042A72B16E92F646AF269C47B7B0A4D")
	private boolean prefixes = false;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "1DFAA5C26271A267921178B52CA9F647", hash_generated_field = "96E23C17D2742D7559D0E0D31EA42D80")
	private boolean uris = false;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "AB1E07F86CA37C6521CC1969EE2AC6C9", hash_generated_field = "ACD7A3294F45ACE61F205E17A82EF3B3")
	Locator locator;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "CB1E9F728CE46E75CD080A7B0788AA70", hash_generated_field = "85A3C4DFDDC2E8B053733750B1AEDE7A")
	EntityResolver entityResolver = null;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "4243CF9A597D079587D3CDAC53C40C0A", hash_generated_field = "36C16184E94517BCEA93A1000BB15E7B")
	DTDHandler dtdHandler = null;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "B71FDAA881F7A0E3499DF3E064B2C5EC", hash_generated_field = "F44EFA80D2ED728EA2AFD1A415E0F220")
	ContentHandler contentHandler = null;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.996 -0400", hash_original_field = "A94D9C6596FCF433C6EEF597B5778A9C", hash_generated_field = "B6B9BEC6A9AF54860C9708100871418D")
	ErrorHandler errorHandler = null;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.997 -0400", hash_original_method = "6A3B211FACF5438B3BC1ECD3BFD1BA43", hash_generated_method = "3211C3FD1288DE1420C8D7583BD8DB45")
	public ParserAdapter() throws SAXException {
		String driver = System.getProperty("org.xml.sax.parser");
		try {
			setup(ParserFactory.makeParser());
		} 
		catch (ClassNotFoundException e1) {
			if (DroidSafeAndroidRuntime.control)
				throw new SAXException("Cannot find SAX1 driver class " + driver, e1);
		} 
		catch (IllegalAccessException e2) {
			if (DroidSafeAndroidRuntime.control)
				throw new SAXException("SAX1 driver class " + driver + " found but cannot be loaded", e2);
		} 
		catch (InstantiationException e3) {
			if (DroidSafeAndroidRuntime.control)
				throw new SAXException("SAX1 driver class " + driver + " loaded but cannot be instantiated", e3);
		} 
		catch (ClassCastException e4) {
			if (DroidSafeAndroidRuntime.control)
				throw new SAXException("SAX1 driver class " + driver + " does not implement org.xml.sax.Parser");
		} 
		catch (NullPointerException e5) {
			if (DroidSafeAndroidRuntime.control)
				throw new SAXException("System property org.xml.sax.parser not specified");
		} 
			
			
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.997 -0400", hash_original_method = "4DBB6701F2EF3CA3BC7975B2574ABC06", hash_generated_method = "66E527D7B281C1219E9D257BFDB4DE20")
	public ParserAdapter(Parser parser) {
		setup(parser);
		addTaint(parser.getTaint());
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.998 -0400", hash_original_method = "9AA60727AB1204C604E2657D93003A43", hash_generated_method = "BEDFB709822D2685EB21C08432C6E611")
	private void setup(Parser parser) {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new NullPointerException("Parser argument must not be null");
		} 
		this.parser = parser;
		atts = new AttributesImpl();
		nsSupport = new NamespaceSupport();
		attAdapter = new AttributeListAdapter();
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.998 -0400", hash_original_method = "A3A2E58BF53A687D411A2644B8AA8600", hash_generated_method = "93D605811CECA958D0BDF218EE1AF211")
	public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
		{
			boolean varA8AE3CDBC337136FCE698D887F3BB132_684017774 = (name.equals(NAMESPACES));
			{
				checkNotParsing("feature", name);
				namespaces = value;
				{
					prefixes = true;
				} 
			} 
			{
				boolean var9778CF62FC558BEC33CA1AB7CC445FA1_150727752 = (name.equals(NAMESPACE_PREFIXES));
				{
					checkNotParsing("feature", name);
					prefixes = value;
					{
						namespaces = true;
					} 
				} 
				{
					boolean var61306608BD21C37169931CE569F81C64_1574457868 = (name.equals(XMLNS_URIs));
					{
						checkNotParsing("feature", name);
						uris = value;
					} 
					{
						if (DroidSafeAndroidRuntime.control)
							throw new SAXNotRecognizedException("Feature: " + name);
					} 
				} 
			} 
		} 
		addTaint(name.getTaint());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.999 -0400", hash_original_method = "894FAC8B5FEFDB9322A454DD3740A469", hash_generated_method = "07F9403CA7C7447FDF24C5D8B72C3C44")
	public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
		{
			boolean varA8AE3CDBC337136FCE698D887F3BB132_1886290096 = (name.equals(NAMESPACES));
			{
				boolean var9778CF62FC558BEC33CA1AB7CC445FA1_1943689960 = (name.equals(NAMESPACE_PREFIXES));
				{
					boolean var61306608BD21C37169931CE569F81C64_1223668457 = (name.equals(XMLNS_URIs));
					{
						if (DroidSafeAndroidRuntime.control)
							throw new SAXNotRecognizedException("Feature: " + name);
					} 
				} 
			} 
		} 
		addTaint(name.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145741300 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145741300;
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.999 -0400", hash_original_method = "EE8A541C22360A747253892239DA9935", hash_generated_method = "BCFEF00C32C22FE1A573F22ECEE0B1D0")
	public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
		if (DroidSafeAndroidRuntime.control)
			throw new SAXNotRecognizedException("Property: " + name);
		addTaint(name.getTaint());
		addTaint(value.getTaint());
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.000 -0400", hash_original_method = "C44A70A290987077F2BE17BCA485ED98", hash_generated_method = "4EEA4E3217A4E62B208725EFC8A4A5BD")
	public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
		throw new SAXNotRecognizedException("Property: " + name);

		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.001 -0400", hash_original_method = "EF3844DB5418C4CB611313F3BE9E31B8", hash_generated_method = "82A21E5D6439DF297D3DDA5C9F15C57B")
	public void setEntityResolver(EntityResolver resolver) {
		entityResolver = resolver;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.002 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "ACEB560CC1624F0D1B508FABD7E58545")
	public EntityResolver getEntityResolver() {
		EntityResolver varB4EAC82CA7396A68D541C85D26508E83_73151369 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_73151369 = entityResolver;
		varB4EAC82CA7396A68D541C85D26508E83_73151369.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_73151369;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.002 -0400", hash_original_method = "119A8AEB4875146983459E145CF644BE", hash_generated_method = "FAA2A53872CCD36AFCB158CD655074B2")
	public void setDTDHandler(DTDHandler handler) {
		dtdHandler = handler;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.002 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "89B94A2BE111DDCCC8D435E3BCA4DEAC")
	public DTDHandler getDTDHandler() {
		DTDHandler varB4EAC82CA7396A68D541C85D26508E83_2140345342 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_2140345342 = dtdHandler;
		varB4EAC82CA7396A68D541C85D26508E83_2140345342.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_2140345342;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.003 -0400", hash_original_method = "D8A0D6D3310208C2BEAFD8789BB430C2", hash_generated_method = "3B6BB5CD628919FBC0C763FB80D35E5E")
	public void setContentHandler(ContentHandler handler) {
		contentHandler = handler;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.003 -0400", hash_original_method = "0648A0EF88EB44B7C03930DFF59893AE", hash_generated_method = "92192CDE35A378FBB10828D5A5137755")
	public ContentHandler getContentHandler() {
		ContentHandler varB4EAC82CA7396A68D541C85D26508E83_345975788 = null; 
																				
																				
																				
		varB4EAC82CA7396A68D541C85D26508E83_345975788 = contentHandler;
		varB4EAC82CA7396A68D541C85D26508E83_345975788.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_345975788;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.003 -0400", hash_original_method = "2F1C93DC349F4C532F80AB43A58B1D4F", hash_generated_method = "E6625B96D2BEDE434929849AF18BADF6")
	public void setErrorHandler(ErrorHandler handler) {
		errorHandler = handler;
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.004 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "6C8B46C50747C4969A443217E64B07ED")
	public ErrorHandler getErrorHandler() {
		ErrorHandler varB4EAC82CA7396A68D541C85D26508E83_1841469320 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_1841469320 = errorHandler;
		varB4EAC82CA7396A68D541C85D26508E83_1841469320.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1841469320;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.004 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "7C46E33FDC82E8D9EBC2B1667B1FD4B6")
	public void parse(String systemId) throws IOException, SAXException {
		parse(new InputSource(systemId));
		addTaint(systemId.getTaint());
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.004 -0400", hash_original_method = "8D1EDF001F7865BC335C47DEAA91DF87", hash_generated_method = "1223902E7BEAF9311E055CDC616F5B58")
	public void parse(InputSource input) throws IOException, SAXException {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new SAXException("Parser is already in use");
		} 
		setupParser();
		parsing = true;
		try {
			parser.parse(input);
		} 
		finally {
			parsing = false;
		} 
		parsing = false;
		addTaint(input.getTaint());
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.005 -0400", hash_original_method = "88280AABBB79C1920DB5BD8874CDE919", hash_generated_method = "EFA3F4DDF2C5DF769B3CAA705F7211C2")
	public void setDocumentLocator(Locator locator) {
		this.locator = locator;
		{
			contentHandler.setDocumentLocator(locator);
		} 
			
			
			
			
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.006 -0400", hash_original_method = "37B6C1FF254D8E50BAF9132487F1B989", hash_generated_method = "190FFA064D26551F673D4DE17E0F4DD6")
	public void startDocument() throws SAXException {
		{
			contentHandler.startDocument();
		} 
			
			
			
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.006 -0400", hash_original_method = "B39D6D1260080244B44CBF7BC9D51D96", hash_generated_method = "81E91320538B41CBB1E06BDD5F1867D3")
	public void endDocument() throws SAXException {
		{
			contentHandler.endDocument();
		} 
			
			
			
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.027 -0400", hash_original_method = "41EBA2EAF373C2E18FF1DC39DB5B0A24", hash_generated_method = "D7EB412B4F4BF40A913A55389EE64E43")
	public void startElement(String qName, AttributeList qAtts) throws SAXException {
		ArrayList<SAXParseException> exceptions = null;
		{
			{
				attAdapter.setAttributeList(qAtts);
				contentHandler.startElement("", "", qName.intern(), attAdapter);
			} 
		} 
		nsSupport.pushContext();
		int length = qAtts.getLength();
		{
			int i = 0;
			{
				String attQName = qAtts.getName(i);
				{
					boolean var66481A3EA056E3438D97B8AEFE0A5D64_445289877 = (!attQName.startsWith("xmlns"));
				} 
				String prefix;
				int n = attQName.indexOf(':');
				{
					boolean var0D527FE2FAF9E405A8BE80B87E481320_1115342649 = (n == -1 && attQName.length() == 5);
					{
						prefix = "";
					} 
					prefix = attQName.substring(n + 1);
				} 
				String value = qAtts.getValue(i);
				{
					boolean var8249EA357DE18E6CB4DAAF538C100257_1499305864 = (!nsSupport.declarePrefix(prefix, value));
					{
						reportError("Illegal Namespace prefix: " + prefix);
					} 
				} 
				contentHandler.startPrefixMapping(prefix, value);
			} 
		} 
		atts.clear();
		{
			int i = 0;
			{
				String attQName = qAtts.getName(i);
				String type = qAtts.getType(i);
				String value = qAtts.getValue(i);
				{
					boolean var1379EA0145545930F593C0164FF520F7_379030381 = (attQName.startsWith("xmlns"));
					{
						String prefix;
						int n = attQName.indexOf(':');
						{
							boolean var502A678EB9E6ADBB52537AE7CD55E53E_2100839143 = (n == -1 && attQName.length() == 5);
							{
								prefix = "";
							} 
							{
								prefix = null;
							} 
							{
								prefix = attQName.substring(6);
							} 
						} 
						{
							{
								atts.addAttribute(nsSupport.XMLNS, prefix, attQName.intern(), type, value);
								atts.addAttribute("", "", attQName.intern(), type, value);
							} 
						} 
					} 
				} 
				try {
					String attName[] = processName(attQName, true, true);
					atts.addAttribute(attName[0], attName[1], attName[2], type, value);
				} 
				catch (SAXException e) {
					{
						exceptions = new ArrayList<SAXParseException>();
					} 
					exceptions.add((SAXParseException) e);
					atts.addAttribute("", attQName, attQName, type, value);
				} 
			} 
		} 
		{
			{
				Iterator<SAXParseException> varAA07C29773F3EE28B897516093F89E03_235203180 = (exceptions).iterator();
				varAA07C29773F3EE28B897516093F89E03_235203180.hasNext();
				SAXParseException ex = varAA07C29773F3EE28B897516093F89E03_235203180.next();
				{
					errorHandler.error(ex);
				} 
			} 
		} 
		{
			String name[] = processName(qName, false, false);
			contentHandler.startElement(name[0], name[1], name[2], atts);
		} 
		addTaint(qName.getTaint());
		addTaint(qAtts.getTaint());
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.028 -0400", hash_original_method = "85074EE9682A2A9BF13F64A0DA58B9BC", hash_generated_method = "0CC7E8E14863B624AAAF98682AA97181")
	public void endElement(String qName) throws SAXException {
		{
			{
				contentHandler.endElement("", "", qName.intern());
			} 
		} 
		String names[] = processName(qName, false, false);
		{
			contentHandler.endElement(names[0], names[1], names[2]);
			Enumeration prefixes = nsSupport.getDeclaredPrefixes();
			{
				boolean var53D5B1DEBA81D6A12DC629F14E13F948_1299366353 = (prefixes.hasMoreElements());
				{
					String prefix = (String) prefixes.nextElement();
					contentHandler.endPrefixMapping(prefix);
				} 
			} 
		} 
		nsSupport.popContext();
		addTaint(qName.getTaint());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.028 -0400", hash_original_method = "C666B3AD5E916677AE6610DC5A0840E2", hash_generated_method = "D339D004666C5DE3BF1D742FBCA93343")
	public void characters(char ch[], int start, int length) throws SAXException {
		{
			contentHandler.characters(ch, start, length);
		} 
		addTaint(ch[0]);
		addTaint(start);
		addTaint(length);
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.029 -0400", hash_original_method = "89B5E71C200F956D34BEB259DC06F56D", hash_generated_method = "23A8C1FF36E4E478AA5E1BB698D5802C")
	public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
		{
			contentHandler.ignorableWhitespace(ch, start, length);
		} 
		addTaint(ch[0]);
		addTaint(start);
		addTaint(length);
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.029 -0400", hash_original_method = "A537A06A51D1B98674021AAB895861DD", hash_generated_method = "DA57D77F0A582846D363C3D5913E1CDB")
	public void processingInstruction(String target, String data) throws SAXException {
		{
			contentHandler.processingInstruction(target, data);
		} 
		addTaint(target.getTaint());
		addTaint(data.getTaint());
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.030 -0400", hash_original_method = "43648C78921975CBE3898500F19AF8D8", hash_generated_method = "CC6DF6D5DE4176F8D9708396EF597B2A")
	private void setupParser() {
		if (DroidSafeAndroidRuntime.control)
			throw new IllegalStateException();
		nsSupport.reset();
		nsSupport.setNamespaceDeclUris(true);
		{
			parser.setEntityResolver(entityResolver);
		} 
		{
			parser.setDTDHandler(dtdHandler);
		} 
		{
			parser.setErrorHandler(errorHandler);
		} 
		parser.setDocumentHandler(this);
		locator = null;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.031 -0400", hash_original_method = "295B884B2E4E1E5DF2659FCF14AB7437", hash_generated_method = "3D5A787E54E9F21F254FCF6CF2CFDF45")
	private String[] processName(String qName, boolean isAttribute, boolean useException) throws SAXException {
		String[] varB4EAC82CA7396A68D541C85D26508E83_1131037370 = null; 
																		
																		
																		
		String parts[] = nsSupport.processName(qName, nameParts, isAttribute);
		{
			if (DroidSafeAndroidRuntime.control)
				throw makeException("Undeclared prefix: " + qName);
			reportError("Undeclared prefix: " + qName);
			parts = new String[3];
			parts[0] = parts[1] = "";
			parts[2] = qName.intern();
		} 
		varB4EAC82CA7396A68D541C85D26508E83_1131037370 = parts;
		addTaint(qName.getTaint());
		addTaint(isAttribute);
		addTaint(useException);
		varB4EAC82CA7396A68D541C85D26508E83_1131037370.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1131037370;
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.031 -0400", hash_original_method = "FBBB3C346433F99D88D798BC2E1AE3CE", hash_generated_method = "E30491B49044401E1793F35D1A8C0572")
	void reportError(String message) throws SAXException {
		errorHandler.error(makeException(message));
		addTaint(message.getTaint());
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.032 -0400", hash_original_method = "E1E473BD4A5E19C1B1699A01EEA95F9A", hash_generated_method = "B92060D0521EA0CB31C10567D2F21ED2")
	private SAXParseException makeException(String message) {
		SAXParseException varB4EAC82CA7396A68D541C85D26508E83_1265589934 = null; 
																					
																					
																					
		SAXParseException varB4EAC82CA7396A68D541C85D26508E83_1572932317 = null; 
																					
																					
																					
		{
			varB4EAC82CA7396A68D541C85D26508E83_1265589934 = new SAXParseException(message, locator);
		} 
		{
			varB4EAC82CA7396A68D541C85D26508E83_1572932317 = new SAXParseException(message, null, null, -1, -1);
		} 
		addTaint(message.getTaint());
		SAXParseException varA7E53CE21691AB073D9660D615818899_722053433; 
																			
																			
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: 
			varA7E53CE21691AB073D9660D615818899_722053433 = varB4EAC82CA7396A68D541C85D26508E83_1265589934;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_722053433 = varB4EAC82CA7396A68D541C85D26508E83_1572932317;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_722053433.addTaint(getTaint()); 
																			
																			
																			
		return varA7E53CE21691AB073D9660D615818899_722053433;
		
		
		
		
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.033 -0400", hash_original_method = "2915748C93DEC7F425A1836D3BEC9D20", hash_generated_method = "D1C76488449591699D612CA4CE5044E7")
	private void checkNotParsing(String type, String name) throws SAXNotSupportedException {
		{
			if (DroidSafeAndroidRuntime.control)
				throw new SAXNotSupportedException("Cannot change " + type + ' ' + name + " while parsing");
		} 
		addTaint(type.getTaint());
		addTaint(name.getTaint());
		
		
		
		
		
		
	}

	final class AttributeListAdapter implements Attributes {
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.033 -0400", hash_original_field = "5B2902A6669F7164A98A2AABBBA7007B", hash_generated_field = "05A4A4B78CD79FD60575BA538F5EFA68")
		private AttributeList qAtts;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.034 -0400", hash_original_method = "C1264636A1B4EA8B9B687011C8022954", hash_generated_method = "27F4154408AA678EEA2C403DF40F80CC")
		AttributeListAdapter() {
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.035 -0400", hash_original_method = "5931F172E3791972ECDA205EAC9CCB14", hash_generated_method = "21260D7331F1562A9DF84A94008BBDC7")
		void setAttributeList(AttributeList qAtts) {
			this.qAtts = qAtts;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.035 -0400", hash_original_method = "B156048BB95084F4BF5D28EF31B66C03", hash_generated_method = "FA40ECF37B12452A343ED4709D554EC1")
		public int getLength() {
			int varD76DF4418194B916F6E20B153E04BB14_1305710128 = (qAtts.getLength());
			int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456386124 = getTaintInt();
			return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456386124;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.038 -0400", hash_original_method = "20CEB246971EBBCECBF2ACA441CBBECD", hash_generated_method = "7DAF40CF34F2D3D46F550198A8F30F77")
		public String getURI(int i) {
			String varB4EAC82CA7396A68D541C85D26508E83_608484543 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_608484543 = "";
			addTaint(i);
			varB4EAC82CA7396A68D541C85D26508E83_608484543.addTaint(getTaint()); 
																				
																				
																				
			return varB4EAC82CA7396A68D541C85D26508E83_608484543;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.041 -0400", hash_original_method = "FEDFFD9A667A49103BC32EE7ED61A0BB", hash_generated_method = "492C998D318F99575FC232466C7BE712")
		public String getLocalName(int i) {
			String varB4EAC82CA7396A68D541C85D26508E83_1297229145 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_1297229145 = "";
			addTaint(i);
			varB4EAC82CA7396A68D541C85D26508E83_1297229145.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_1297229145;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.043 -0400", hash_original_method = "A764D8ED68137C2EBCBCEF1CD153F6C1", hash_generated_method = "2FD7A9212AED852A75FF6462FCFDD015")
		public String getQName(int i) {
			String varB4EAC82CA7396A68D541C85D26508E83_1586448909 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_1586448909 = qAtts.getName(i).intern();
			addTaint(i);
			varB4EAC82CA7396A68D541C85D26508E83_1586448909.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_1586448909;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.044 -0400", hash_original_method = "27E76BA5C0D6AD663690DDCFFED2A8A3", hash_generated_method = "D1B8E3F7C333C069A3DFD723CC842665")
		public String getType(int i) {
			String varB4EAC82CA7396A68D541C85D26508E83_1060657036 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_1060657036 = qAtts.getType(i).intern();
			addTaint(i);
			varB4EAC82CA7396A68D541C85D26508E83_1060657036.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_1060657036;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.045 -0400", hash_original_method = "F0679796EDFA7C65CB4AD5C7F9CBE1FC", hash_generated_method = "94F009408235D1BC0E29651340575EB0")
		public String getValue(int i) {
			String varB4EAC82CA7396A68D541C85D26508E83_1961736757 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_1961736757 = qAtts.getValue(i);
			addTaint(i);
			varB4EAC82CA7396A68D541C85D26508E83_1961736757.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_1961736757;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.046 -0400", hash_original_method = "696F42D8785320084719A8378B03A3E8", hash_generated_method = "6E27E60AD1529B2FFDC7C5BCDD157D27")
		public int getIndex(String uri, String localName) {
			addTaint(uri.getTaint());
			addTaint(localName.getTaint());
			int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730438740 = getTaintInt();
			return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_730438740;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.047 -0400", hash_original_method = "9B76649071044C2724A0BCBC3CC4F1FF", hash_generated_method = "400E5C29EFCD0634A240518C3A820889")
		public int getIndex(String qName) {
			int max = atts.getLength();
			{
				int i = 0;
				{
					{
						boolean varE315FB12CDCA66D13110B50B7AC158F1_1249763399 = (qAtts.getName(i).equals(qName));
					} 
				} 
			} 
			addTaint(qName.getTaint());
			int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102819808 = getTaintInt();
			return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102819808;
			
			
			
			
			
			
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.048 -0400", hash_original_method = "DB45F41F9C44849C439912CF28FC6F39", hash_generated_method = "6D7577A3EC98B303E177BB040591D48A")
		public String getType(String uri, String localName) {
			String varB4EAC82CA7396A68D541C85D26508E83_1713367158 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_1713367158 = null;
			addTaint(uri.getTaint());
			addTaint(localName.getTaint());
			varB4EAC82CA7396A68D541C85D26508E83_1713367158.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_1713367158;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.049 -0400", hash_original_method = "20D0A7881E2746A3B90C82673591E46C", hash_generated_method = "3503788A251E834FF11B32AD26300E75")
		public String getType(String qName) {
			String varB4EAC82CA7396A68D541C85D26508E83_2107678593 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_2107678593 = qAtts.getType(qName).intern();
			addTaint(qName.getTaint());
			varB4EAC82CA7396A68D541C85D26508E83_2107678593.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_2107678593;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.050 -0400", hash_original_method = "A923F17E07DEE910B88DBEE5B2421501", hash_generated_method = "96CE96B4504B358E88DA0E8CFB3B6344")
		public String getValue(String uri, String localName) {
			String varB4EAC82CA7396A68D541C85D26508E83_2136672805 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_2136672805 = null;
			addTaint(uri.getTaint());
			addTaint(localName.getTaint());
			varB4EAC82CA7396A68D541C85D26508E83_2136672805.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_2136672805;
			
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.050 -0400", hash_original_method = "E305D94D7DAD816250B349D4183FD8D8", hash_generated_method = "15E757A9899D67C9ED381A2FC40157BE")
		public String getValue(String qName) {
			String varB4EAC82CA7396A68D541C85D26508E83_1725185900 = null; 
																			
																			
																			
			varB4EAC82CA7396A68D541C85D26508E83_1725185900 = qAtts.getValue(qName);
			addTaint(qName.getTaint());
			varB4EAC82CA7396A68D541C85D26508E83_1725185900.addTaint(getTaint()); 
																					
																					
																					
			return varB4EAC82CA7396A68D541C85D26508E83_1725185900;
			
			
		}

	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.050 -0400", hash_original_field = "279943BC4B6CA67AC945E5EEEAE61ADF", hash_generated_field = "7F6C469D4D388241307D7C119B45A94C")
	private static final String FEATURES = "http://xml.org/sax/features/";
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.050 -0400", hash_original_field = "93DBCD05F838664E2E8E2122A2491302", hash_generated_field = "01CA2984D11D1EEDC7EEEBDF3608A189")
	private static final String NAMESPACES = FEATURES + "namespaces";
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.050 -0400", hash_original_field = "1C9ED1AA9E7A3DA8DA63B036DF702F8F", hash_generated_field = "1DB4D9F63D53A2D85BBF1DD847F0B1EE")
	private static final String NAMESPACE_PREFIXES = FEATURES + "namespace-prefixes";
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.050 -0400", hash_original_field = "61F527C036AF5AE3ABE7A1DDC88AEA80", hash_generated_field = "117F3EAB9BE6F30784F4A30F1BDC845B")
	private static final String XMLNS_URIs = FEATURES + "xmlns-uris";
}
