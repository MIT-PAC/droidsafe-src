package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler implements ScanHandler, XMLReader, LexicalHandler {

	// Private clone of Boolean.valueOf that is guaranteed to return
	// Boolean.TRUE or Boolean.FALSE
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.368 -0500", hash_original_method = "DEEA9127C75CA41B923A3DC43D204756", hash_generated_method = "DDB8999269F7CA4EC20D2B8504360235")
	
private static Boolean truthValue(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
		}

	// If the String is quoted, trim the quotes.
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.489 -0500", hash_original_method = "BDA9D8383AE12BFC0EDAC6BE30379C57", hash_generated_method = "7218B177F9828568680D5B4B7EB7D328")
	
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

	// Split the supplied String into words or phrases seperated by spaces.
	// Recognises quotes around a phrase and doesn't split it.
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.492 -0500", hash_original_method = "DAD7677F193C354C030B27974A1BBCD1", hash_generated_method = "206D9B2DD2DA383725DEB0661C09406E")
	
private static String[] split(String val) throws IllegalArgumentException {
		val = val.trim();
		if (val.length() == 0) {
			return new String[0];
			}
		else {
			ArrayList l = new ArrayList();
			int s = 0;
			int e = 0;
			boolean sq = false;	// single quote
			boolean dq = false;	// double quote
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.255 -0500", hash_original_field = "9211B479AEDD558B364C67B71B9A375D", hash_generated_field = "8C65D693E4988ED7894951639899EFA7")

	private static boolean DEFAULT_NAMESPACES = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.258 -0500", hash_original_field = "043D54F98AE5B993BC434E85D0697789", hash_generated_field = "95CB3BC4361BA9B6FF9E9F70A90DAD03")

	private static boolean DEFAULT_IGNORE_BOGONS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.260 -0500", hash_original_field = "D1389286EDD514C679EF8A2137490281", hash_generated_field = "C1B97603EF870B3B0E60C4840424A571")

	private static boolean DEFAULT_BOGONS_EMPTY = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.262 -0500", hash_original_field = "E21C49DC1280010F0A0D1D09A1DC97CA", hash_generated_field = "7DFA3CA9505571283CB90D1D2363FF9B")

        private static boolean DEFAULT_ROOT_BOGONS = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.265 -0500", hash_original_field = "1A478220959566A0D8E00D0BC17613F7", hash_generated_field = "C52EF402C6C7D6C4E13363F89BA4C9CC")

	private static boolean DEFAULT_DEFAULT_ATTRIBUTES = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.267 -0500", hash_original_field = "E2889B1F73BF58ADBBB9D66E62DA21D2", hash_generated_field = "8EA188B97877D5C056C8FFECB4A916D5")

	private static boolean DEFAULT_TRANSLATE_COLONS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.269 -0500", hash_original_field = "324E380A6D3F45920DF77EA1BD649A8D", hash_generated_field = "23FE955BFE2713EF46107ED432FA524F")

	private static boolean DEFAULT_RESTART_ELEMENTS = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.272 -0500", hash_original_field = "AD22B8E0182972F1901230E26EB9AE3B", hash_generated_field = "FD9FE242EBAEBB21389F3374291F0873")

	private static boolean DEFAULT_IGNORABLE_WHITESPACE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.274 -0500", hash_original_field = "00957F8AE2C3904E48D57BA7ADEB8C2C", hash_generated_field = "CD35A69CF70628A1FE7FC19224E80910")

	private static boolean DEFAULT_CDATA_ELEMENTS = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.297 -0500", hash_original_field = "1D26CE12E19D3EB1EC408C47DDD9DA27", hash_generated_field = "F3EBD8EB0AAB95778649118E621BDF3A")

	public final static String namespacesFeature =
		"http://xml.org/sax/features/namespaces";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.299 -0500", hash_original_field = "17653486D9B76832321FAE82D2C0D66D", hash_generated_field = "E7FEE848C76AD7E3496C4E630A78BB81")

	public final static String namespacePrefixesFeature =
		"http://xml.org/sax/features/namespace-prefixes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.302 -0500", hash_original_field = "559FF524E4366C32BD88182D155D90EA", hash_generated_field = "4960CE938280E09CACB47773B253189A")

	public final static String externalGeneralEntitiesFeature =
		"http://xml.org/sax/features/external-general-entities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.304 -0500", hash_original_field = "F7FF6B6B273113C3EA69A0A6A868DB4D", hash_generated_field = "645AC9F0D99476599CC2C5D420FBCEF2")

	public final static String externalParameterEntitiesFeature =
		"http://xml.org/sax/features/external-parameter-entities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.307 -0500", hash_original_field = "1BD5B721CD8235E5076F83F7A254F2B8", hash_generated_field = "98E16839D8A858A412C6507FCFC65238")

	public final static String isStandaloneFeature =
		"http://xml.org/sax/features/is-standalone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.309 -0500", hash_original_field = "0B017A68FEC4EB80B7B979E018ABC630", hash_generated_field = "59F9AF3A3A0609C6E2AD94D8503C5DB8")

	public final static String lexicalHandlerParameterEntitiesFeature =
		"http://xml.org/sax/features/lexical-handler/parameter-entities";

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.365 -0500", hash_original_field = "C78C643B09CA7913EEBB0BB6584C8A97", hash_generated_field = "8611D6C2559174015F7B124314C5A0C3")

	// entries are maintained separately from the initial values of
	// the corresponding instance variables, but care must be taken
	// to keep them in sync.

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.313 -0500", hash_original_field = "DC63B87CA3BFB0F43C38647973E02660", hash_generated_field = "E4001DA9C670BFD243A4A5A5AFD7B06A")

	public final static String resolveDTDURIsFeature =
		"http://xml.org/sax/features/resolve-dtd-uris";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.315 -0500", hash_original_field = "9BFA956D68B9C270E4D08DCA890B9F37", hash_generated_field = "779F7448C8785232BD7DFD5A67948D0A")

	public final static String stringInterningFeature =
		"http://xml.org/sax/features/string-interning";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.318 -0500", hash_original_field = "1F8E35D5961830FEACA37E76CCDE5E7A", hash_generated_field = "FAAA57EA66A4B1C99F05BEE9CC5BC5C0")

	public final static String useAttributes2Feature =
		"http://xml.org/sax/features/use-attributes2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.320 -0500", hash_original_field = "5B6F7CCB2CAA297365019B36FED78096", hash_generated_field = "73D5341F2654195F0D7797F0A3BD736C")

	public final static String useLocator2Feature =
		"http://xml.org/sax/features/use-locator2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.323 -0500", hash_original_field = "89DE122EDEAFF1A95489A29B783B30E9", hash_generated_field = "E57D37F2ED0F4BEDDBE77B9CD1285626")

	public final static String useEntityResolver2Feature =
		"http://xml.org/sax/features/use-entity-resolver2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.325 -0500", hash_original_field = "6B0941D498CA4F2726AC0154369B10EA", hash_generated_field = "AE045FBF898962BE8139B1301F2E291D")

	public final static String validationFeature =
		"http://xml.org/sax/features/validation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.327 -0500", hash_original_field = "8464165B4C090F4D764DA306C405C098", hash_generated_field = "FFF09C3BD393A94D09CA8784BA24B96C")

	public final static String unicodeNormalizationCheckingFeature =
"http://xml.org/sax/features/unicode-normalization-checking";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.330 -0500", hash_original_field = "72EE2389074D2ACD094799B337312633", hash_generated_field = "70DBEF739EE1118B51EF01363B966D8D")

	public final static String xmlnsURIsFeature =
		"http://xml.org/sax/features/xmlns-uris";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.332 -0500", hash_original_field = "C351C93255D88C287DAE3ED946BE226F", hash_generated_field = "5488477B90537AA19EE8E80FB08A056E")

	public final static String XML11Feature =
		"http://xml.org/sax/features/xml-1.1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.335 -0500", hash_original_field = "4BB0F0A711FC6E2A6310DA9529459354", hash_generated_field = "DF8EFD4BEA7B3EC8130EE8349D424963")

	public final static String ignoreBogonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.337 -0500", hash_original_field = "2CEF73F0A3B190AA6EE52B4AB9E987F4", hash_generated_field = "32DC43A44181D8F10A0C6982CE0B6386")

	public final static String bogonsEmptyFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/bogons-empty";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.340 -0500", hash_original_field = "107402D035589ABEF883DBB9F6010BD5", hash_generated_field = "3A5CBA372BE7A2473B1668328C41DB6A")

	public final static String rootBogonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/root-bogons";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.342 -0500", hash_original_field = "AEA25088BA91972E081FEFDC58088893", hash_generated_field = "DEB6886124B5BC7131E5CC87524A695D")

	public final static String defaultAttributesFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/default-attributes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.345 -0500", hash_original_field = "5CE3E0A096C262EC5C1CA8B39BFBB608", hash_generated_field = "1DC8012EA98D5A5A9DA782EFE46C2147")

	public final static String translateColonsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/translate-colons";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.348 -0500", hash_original_field = "02F6DDE978012FD5EDA3C198F211C532", hash_generated_field = "1772BBD7B67CE6A02034F6A6306E4FA9")

	public final static String restartElementsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/restart-elements";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.351 -0500", hash_original_field = "D116F5A38A8F2D972ACB0C31E6B3F75C", hash_generated_field = "1D5F6B2A86BD9224BC22C54DF3AFC220")

	public final static String ignorableWhitespaceFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.353 -0500", hash_original_field = "01D665761F586D672DCE3979C9551B36", hash_generated_field = "A2B4D8B75BBD10B44AC6D98553F23134")

	public final static String CDATAElementsFeature =
		"http://www.ccil.org/~cowan/tagsoup/features/cdata-elements";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.356 -0500", hash_original_field = "51E0DBF5BB656132B780968C61B28687", hash_generated_field = "8A5D5A73966E1FD73F6F608DF4773448")

	public final static String lexicalHandlerProperty =
		"http://xml.org/sax/properties/lexical-handler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.358 -0500", hash_original_field = "70EAE647642189168EF81F45C6CDAC18", hash_generated_field = "E3DE5D25612341B98A05128F19EC757A")

	public final static String scannerProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/scanner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.361 -0500", hash_original_field = "64EAE64C66CC74DF53D6E6E983518378", hash_generated_field = "BD853C15AC79E307C4DD428564DA6936")

	public final static String schemaProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/schema";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.363 -0500", hash_original_field = "AD1D01768BA7B554285632CF7DAEC872", hash_generated_field = "E5BF44D1D2EEF754BB72858FBBA9AE93")

	public final static String autoDetectorProperty =
		"http://www.ccil.org/~cowan/tagsoup/properties/auto-detector";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.459 -0500", hash_original_field = "6A5006467E0BAFBA5A031138163DDC22", hash_generated_field = "F9A296D96DE887875437F32B036C0ACB")

	private static char[] etagchars = {'<', '/', '>'};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.494 -0500", hash_original_field = "851E1051E6D40941E485416A968F1220", hash_generated_field = "E6F625E3403F0099E2C98CB06235CCBA")

	private static String legal =
		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.238 -0500", hash_original_field = "F86BCC24AB2B3CB2335E91E2E05B1356", hash_generated_field = "4F44CE27A3793F7751E9A2BE62EDA28B")

	private ContentHandler theContentHandler = this;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.240 -0500", hash_original_field = "23045B7A8985E3CE20DC0CE44BFC55C2", hash_generated_field = "157ADCC7E3B0E4B62A86EF5B1464D34C")

	private LexicalHandler theLexicalHandler = this;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.242 -0500", hash_original_field = "7625A14750C43A1235A792B6AD85BEDE", hash_generated_field = "0250A3E49B4EA1CD2D0A995FF5246D28")

	private DTDHandler theDTDHandler = this;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.244 -0500", hash_original_field = "F862645B4BD5FD1D6B6FC58B39EFFCA7", hash_generated_field = "5096464DD0A69980B0EFE4F51A07D7A0")

	private ErrorHandler theErrorHandler = this;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.247 -0500", hash_original_field = "E8032D3BA32EF80F9EDE27BF3590729C", hash_generated_field = "1DF35A9855CF0F5158EC878850EAD218")

	private EntityResolver theEntityResolver = this;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.249 -0500", hash_original_field = "28AB313AF53C2A1BC66B7A4934DF6012", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

	private Schema theSchema;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.251 -0500", hash_original_field = "88EA34148CF12076BD8A2F3064191AC6", hash_generated_field = "4E761DBCC8A2988ECAB555C68CB8DEB1")

	private Scanner theScanner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.253 -0500", hash_original_field = "3B499C9888EC99172B0F0F2A51F2A646", hash_generated_field = "996675C96C2397ADFF11AC882B20B3F5")

	private AutoDetector theAutoDetector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.276 -0500", hash_original_field = "DBCD2AABAE5E8CBC837971C2BC5BB3D3", hash_generated_field = "22AE333EFBA532959473DE818E24D5BF")

	private boolean namespaces = DEFAULT_NAMESPACES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.278 -0500", hash_original_field = "73469DEDA91FD5B590B9B02013DD3F06", hash_generated_field = "41E62687D64F8450440F589FD8B2C7D2")

	private boolean ignoreBogons = DEFAULT_IGNORE_BOGONS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.281 -0500", hash_original_field = "870639C554612CC87584006BD2CFC76A", hash_generated_field = "E4FAEC9CF3158B00C3F5BBDEDAC38D80")

	private boolean bogonsEmpty = DEFAULT_BOGONS_EMPTY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.284 -0500", hash_original_field = "2BD60540D65284DB64285D66EA3792A3", hash_generated_field = "A54F1F17D7ADCFC60A15857E1F85FF45")

        private boolean rootBogons = DEFAULT_ROOT_BOGONS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.286 -0500", hash_original_field = "4E0763544AA3A930195F9E454004C119", hash_generated_field = "7E383F84EDB4881461124E7E7AB52091")

	private boolean defaultAttributes = DEFAULT_DEFAULT_ATTRIBUTES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.288 -0500", hash_original_field = "200B4C4281D0E30DB46368371216F025", hash_generated_field = "54CF914E3DF3C6BA59447DE81000C1D8")

	private boolean translateColons = DEFAULT_TRANSLATE_COLONS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.290 -0500", hash_original_field = "E9181488749B8838FC38A22DD75C8EE8", hash_generated_field = "B712CFA3553BE13E45826B673C86681F")

	private boolean restartElements = DEFAULT_RESTART_ELEMENTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.293 -0500", hash_original_field = "76E613E50B8D4CF4C2905FD21396E8E6", hash_generated_field = "78FB9F9549B57ED6D280AA8E51B31437")

	private boolean ignorableWhitespace = DEFAULT_IGNORABLE_WHITESPACE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.295 -0500", hash_original_field = "AE3D16F7200370085252AB4D8DAC63EC", hash_generated_field = "6315C4913628D4F5D0A650689FEE53F5")

	private boolean CDATAElements = DEFAULT_CDATA_ELEMENTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.414 -0500", hash_original_field = "D81F97CC16E3F14DD4ACBEF8EF4CBAC7", hash_generated_field = "21E32FFA161A85FC32FF7F6350176F21")

	// ScanHandler implementation

	private Element theNewElement = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.417 -0500", hash_original_field = "2C44A760A3324EC4E4A7F7B6316651FA", hash_generated_field = "3971348F960D66262BE9AAD85DDDAD51")

	private String theAttributeName = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.419 -0500", hash_original_field = "70C2593DFF4BE446BC5C8E3D17A65152", hash_generated_field = "16F18AE13D1847204B3580570C01FD87")

	private boolean theDoctypeIsPresent = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.421 -0500", hash_original_field = "7C62B74904B5CEE4FDD42C4D60E46794", hash_generated_field = "94C2B01EF19C224943FE0663341AF33A")

	private String theDoctypePublicId = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.424 -0500", hash_original_field = "BB3E211EC9120C1D164FE5826F8339FE", hash_generated_field = "0B8C1584143BEE93C46504097391530E")

	private String theDoctypeSystemId = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.426 -0500", hash_original_field = "889CF9A9A279A491221EC5F54C69DDE0", hash_generated_field = "247F70B5D7C6F8B059A348D2387FBC13")

	private String theDoctypeName = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.428 -0500", hash_original_field = "36D3DC91D6C70EF6049787C61BD98940", hash_generated_field = "080BFB2033564D1CB69BD1F7C08184D6")

	private String thePITarget = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.431 -0500", hash_original_field = "F49F928C6007C746CFD89D15EC3CC921", hash_generated_field = "43C38F93E7447D1ED933F58636348D3D")

	private Element theStack = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.433 -0500", hash_original_field = "CC3DE74901D5BF0A40ECE6F10EFACC18", hash_generated_field = "C6DD2154E4DDD283E34159243942ADBC")

	private Element theSaved = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.435 -0500", hash_original_field = "FCC005CBAD3B259BAC630F06331004F6", hash_generated_field = "697A580E609D0A168C8A8EB97FAF20FE")

	private Element thePCDATA = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.437 -0500", hash_original_field = "7F540E908F1C11E1A5B7477B652FCDD2", hash_generated_field = "15E2820171C06161A279611A152EA754")

	private int theEntity = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.476 -0500", hash_original_field = "2CCC900FBE70F3C90437CC82D6271AB5", hash_generated_field = "C5A55747785458B1F50A346028B62596")

	private boolean virginStack = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.517 -0500", hash_original_field = "D50197896911C5826364F0EB5474A273", hash_generated_field = "36FBB60F8B3CE9EA610621F518B77851")

	private char[] theCommentBuffer = new char[2000];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.148 -0400", hash_original_method = "42CBDDB53A445ABDFB908116E235FAA0", hash_generated_method = "42CBDDB53A445ABDFB908116E235FAA0")
    public Parser ()
    {
        //Synthesized constructor
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.371 -0500", hash_original_method = "FDD541AC7ACF46AD908991FDB1EF4671", hash_generated_method = "2DCE1667D7452BCBE091253447287411")
	
public boolean getFeature (String name)
		throws SAXNotRecognizedException, SAXNotSupportedException {
		Boolean b = (Boolean)theFeatures.get(name);
		if (b == null) {
			throw new SAXNotRecognizedException("Unknown feature " + name);
			}
		return b.booleanValue();
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.373 -0500", hash_original_method = "DD81CF03E95A92E28D68E44755507EB5", hash_generated_method = "5679219DE607BBEE435014600ED00451")
	
public void setFeature (String name, boolean value)
	throws SAXNotRecognizedException, SAXNotSupportedException {
		Boolean b = (Boolean)theFeatures.get(name);
		if (b == null) {
			throw new SAXNotRecognizedException("Unknown feature " + name);
			}
		if (value) theFeatures.put(name, Boolean.TRUE);
		else theFeatures.put(name, Boolean.FALSE);

		if (name.equals(namespacesFeature)) namespaces = value;
		else if (name.equals(ignoreBogonsFeature)) ignoreBogons = value;
		else if (name.equals(bogonsEmptyFeature)) bogonsEmpty = value;
		else if (name.equals(rootBogonsFeature)) rootBogons = value;
		else if (name.equals(defaultAttributesFeature)) defaultAttributes = value;
		else if (name.equals(translateColonsFeature)) translateColons = value;
		else if (name.equals(restartElementsFeature)) restartElements = value;
		else if (name.equals(ignorableWhitespaceFeature)) ignorableWhitespace = value;
		else if (name.equals(CDATAElementsFeature)) CDATAElements = value;
		}

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.376 -0500", hash_original_method = "F750AD287EF0AB9FAAF84C1118421011", hash_generated_method = "AF0C5B36B2B426457099C57F26E384DC")
	
public Object getProperty (String name)
	throws SAXNotRecognizedException, SAXNotSupportedException {
		if (name.equals(lexicalHandlerProperty)) {
			return theLexicalHandler == this ? null : theLexicalHandler;
			}
		else if (name.equals(scannerProperty)) {
			return theScanner;
			}
		else if (name.equals(schemaProperty)) {
			return theSchema;
			}
		else if (name.equals(autoDetectorProperty)) {
			return theAutoDetector;
			}
		else {
			throw new SAXNotRecognizedException("Unknown property " + name);
			}
		}

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.379 -0500", hash_original_method = "A91E5B1E97A27DD267128DBDD8DC4544", hash_generated_method = "A8DA2CF6E54D4DEC9C1D5DDCD2B0BC17")
	
public void setProperty (String name, Object value)
	throws SAXNotRecognizedException, SAXNotSupportedException {
		if (name.equals(lexicalHandlerProperty)) {
			if (value == null) {
				theLexicalHandler = this;
				}
			else if (value instanceof LexicalHandler) {
				theLexicalHandler = (LexicalHandler)value;
				}
			else {
				throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
				}
			}
		else if (name.equals(scannerProperty)) {
			if (value instanceof Scanner) {
				theScanner = (Scanner)value;
				}
			else {
				throw new SAXNotSupportedException("Your scanner is not a Scanner");
				}
			}
		else if (name.equals(schemaProperty)) {
			if (value instanceof Schema) {
				theSchema = (Schema)value;
				}
			else {
				 throw new SAXNotSupportedException("Your schema is not a Schema");
				}
			}
		else if (name.equals(autoDetectorProperty)) {
			if (value instanceof AutoDetector) {
				theAutoDetector = (AutoDetector)value;
				}
			else {
				throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
				}
			}
		else {
			throw new SAXNotRecognizedException("Unknown property " + name);
			}
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.381 -0500", hash_original_method = "A546AE41DB77A7324A8896ECCFDC28F7", hash_generated_method = "29C5FEB4ECB5974BA22E97BEE490F871")
	
public void setEntityResolver (EntityResolver resolver) {
		theEntityResolver = (resolver == null) ? this : resolver;
		}

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.384 -0500", hash_original_method = "4B11F09BEC63C73E852BF6819D5E17A6", hash_generated_method = "F874356932E7CE3C31553FC22A586F39")
	
public EntityResolver getEntityResolver () {
		return (theEntityResolver == this) ? null : theEntityResolver;
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.386 -0500", hash_original_method = "2A1D8AFABC32A2E0B1A4A173104FD709", hash_generated_method = "AA1225CA2A0D0FC81D3F38913122E6B3")
	
public void setDTDHandler (DTDHandler handler) {
		theDTDHandler = (handler == null) ? this : handler;
		}

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.388 -0500", hash_original_method = "338D21F6A8224B73088A08444EBB70F8", hash_generated_method = "2DD6CB2E7E0ABFF870070BBDDFD4BCFE")
	
public DTDHandler getDTDHandler () {
		return (theDTDHandler == this) ? null : theDTDHandler;
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.390 -0500", hash_original_method = "F2917252F8D6F02CF50CD455848B7CDD", hash_generated_method = "77232A9B4C222200D3DBD7D1FD7654CA")
	
public void setContentHandler (ContentHandler handler) {
		theContentHandler = (handler == null) ? this : handler;
		}

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.393 -0500", hash_original_method = "E2D49645B9897F446183B1EC842A5B8C", hash_generated_method = "354352E113E11CBB448AD196C7A9156F")
	
public ContentHandler getContentHandler () {
		return (theContentHandler == this) ? null : theContentHandler;
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.395 -0500", hash_original_method = "4FC35E4E9BBEBB25DC834EFC47A653D4", hash_generated_method = "E9EF91FCBC58CE97BC4C1FA9083BD346")
	
public void setErrorHandler (ErrorHandler handler) {
		theErrorHandler = (handler == null) ? this : handler;
		}

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.397 -0500", hash_original_method = "662542919C9F3C78B54F5CA00EE88FD5", hash_generated_method = "A422E5865F4B44C8B09F9AA279A5E6E6")
	
public ErrorHandler getErrorHandler () {
		return (theErrorHandler == this) ? null : theErrorHandler;
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.399 -0500", hash_original_method = "5995949AA97E47EEEF7CCC54B7A2CDFD", hash_generated_method = "8CE2CEF32F97502EA67DD142013B9FFF")
	
public void parse (InputSource input) throws IOException, SAXException {
		setup();
		Reader r = getReader(input);
		theContentHandler.startDocument();
		theScanner.resetDocumentLocator(input.getPublicId(), input.getSystemId());
		if (theScanner instanceof Locator) {
			theContentHandler.setDocumentLocator((Locator)theScanner);
			}
		if (!(theSchema.getURI().equals("")))
			theContentHandler.startPrefixMapping(theSchema.getPrefix(),
				theSchema.getURI());
		theScanner.scan(r, this);
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.402 -0500", hash_original_method = "84CD70DF516C08D97CF2D35EEDEEB169", hash_generated_method = "E808A0522D046274BC6B48D12E4D3F0D")
	
public void parse (String systemid) throws IOException, SAXException {
		parse(new InputSource(systemid));
		}

	// Sets up instance variables that haven't been set by setFeature
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.407 -0500", hash_original_method = "4BDCB9FDB6AA49AD5AB8549244541048", hash_generated_method = "128A4F55CE7690B3D7D971683C96D224")
	
private void setup() {
		if (theSchema == null) theSchema = new HTMLSchema();
		if (theScanner == null) theScanner = new HTMLScanner();
		if (theAutoDetector == null) {
			theAutoDetector = new AutoDetector() {
				public Reader autoDetectingReader(InputStream i) {
					return new InputStreamReader(i);
					}
				};
			}
		theStack = new Element(theSchema.getElementType("<root>"), defaultAttributes);
		thePCDATA = new Element(theSchema.getElementType("<pcdata>"), defaultAttributes);
		theNewElement = null;
		theAttributeName = null;
		thePITarget = null;
		theSaved = null;
		theEntity = 0;
		virginStack = true;
                theDoctypeName = theDoctypePublicId = theDoctypeSystemId = null;
		}

	// Return a Reader based on the contents of an InputSource
	// Buffer both the InputStream and the Reader
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.410 -0500", hash_original_method = "0FC12B7CFED0DCE2629E4B14587480A6", hash_generated_method = "F8C16F4EB8D66AAA1F2676CD0A051C40")
	
private Reader getReader(InputSource s) throws SAXException, IOException {
		Reader r = s.getCharacterStream();
		InputStream i = s.getByteStream();
		String encoding = s.getEncoding();
		String publicid = s.getPublicId();
		String systemid = s.getSystemId();
		if (r == null) {
			if (i == null) i = getInputStream(publicid, systemid);
//			i = new BufferedInputStream(i);
			if (encoding == null) {
				r = theAutoDetector.autoDetectingReader(i);
				}
			else {
				try {
					r = new InputStreamReader(i, encoding);
					}
				catch (UnsupportedEncodingException e) {
					r = new InputStreamReader(i);
					}
				}
			}
//		r = new BufferedReader(r);
		return r;
		}

	// Get an InputStream based on a publicid and a systemid
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.412 -0500", hash_original_method = "CDC68ACD7694626FF67B6B6D163E3BB7", hash_generated_method = "B9525A38C6B7B12975D2088BC866603A")
	
private InputStream getInputStream(String publicid, String systemid) throws IOException, SAXException {
		URL basis = new URL("file", "", System.getProperty("user.dir") + "/.");
		URL url = new URL(basis, systemid);
		URLConnection c = url.openConnection();
		return c.getInputStream();
		}	// needs to support chars past U+FFFF

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.439 -0500", hash_original_method = "35040F07E07C8DEC63311B713CED1F9F", hash_generated_method = "5BAA25B217C75B858B869524A97C989F")
	
public void adup(char[] buff, int offset, int length) throws SAXException {
		if (theNewElement == null || theAttributeName == null) return;
		theNewElement.setAttribute(theAttributeName, null, theAttributeName);
		theAttributeName = null;
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.441 -0500", hash_original_method = "C9FB1DE82C24B4094C9FB21723BCABB8", hash_generated_method = "CDDEBC44C1CBE777C7FA625A5F864A84")
	
public void aname(char[] buff, int offset, int length) throws SAXException {
		if (theNewElement == null) return;
		// Currently we don't rely on Schema to canonicalize
		// attribute names.
		theAttributeName = makeName(buff, offset, length).toLowerCase();
//		System.err.println("%% Attribute name " + theAttributeName);
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.443 -0500", hash_original_method = "B00CA1167B22D91DBB3A58CD90B87CBC", hash_generated_method = "13125B006BB9869106A866157BE5ECCA")
	
public void aval(char[] buff, int offset, int length) throws SAXException {
		if (theNewElement == null || theAttributeName == null) return;
		String value = new String(buff, offset, length);
//		System.err.println("%% Attribute value [" + value + "]");
		value = expandEntities(value);
		theNewElement.setAttribute(theAttributeName, null, value);
		theAttributeName = null;
//		System.err.println("%% Aval done");
		}

	// Expand entity references in attribute values selectively.
	// Currently we expand a reference iff it is properly terminated
	// with a semicolon.
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.447 -0500", hash_original_method = "BD88D393D059FDFF1FEBA4E80D3AAF56", hash_generated_method = "FD4B10672D2DFCBCBCE18A4060968428")
	
private String expandEntities(String src) {
		int refStart = -1;
		int len = src.length();
		char[] dst = new char[len];
		int dstlen = 0;
		for (int i = 0; i < len; i++) {
			char ch = src.charAt(i);
			dst[dstlen++] = ch;
//			System.err.print("i = " + i + ", d = " + dstlen + ", ch = [" + ch + "] ");
			if (ch == '&' && refStart == -1) {
				// start of a ref excluding &
				refStart = dstlen;
//				System.err.println("start of ref");
				}
			else if (refStart == -1) {
				// not in a ref
//				System.err.println("not in ref");
				}
			else if (Character.isLetter(ch) ||
					Character.isDigit(ch) ||
					ch == '#') {
				// valid entity char
//				System.err.println("valid");
				}
			else if (ch == ';') {
				// properly terminated ref
//				System.err.print("got [" + new String(dst, refStart, dstlen-refStart-1) + "]");
				int ent = lookupEntity(dst, refStart, dstlen - refStart - 1);
//				System.err.println(" = " + ent);
				if (ent > 0xFFFF) {
					ent -= 0x10000;
					dst[refStart - 1] = (char)((ent>>10) + 0xD800);
					dst[refStart] = (char)((ent&0x3FF) + 0xDC00);
					dstlen = refStart + 1;
					}
				else if (ent != 0) {
					dst[refStart - 1] = (char)ent;
					dstlen = refStart;
					}
				refStart = -1;
				}
			else {
				// improperly terminated ref
//				System.err.println("end of ref");
				refStart = -1;
				}
			}
		return new String(dst, 0, dstlen);
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.449 -0500", hash_original_method = "38A8EAE3BE9C6B2369CA0ABEFF20DED1", hash_generated_method = "BAEFB7563FC6955A54EC1A1410BA7AAA")
	
public void entity(char[] buff, int offset, int length) throws SAXException {
		theEntity = lookupEntity(buff, offset, length);
		}

	// Process numeric character references,
	// deferring to the schema for named ones.
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.452 -0500", hash_original_method = "9575B162D435E8F9BEA7F0ECC81D324A", hash_generated_method = "71DA8E87A02104DD491874959339F5C0")
	
private int lookupEntity(char[] buff, int offset, int length) {
		int result = 0;
		if (length < 1) return result;
//		System.err.println("%% Entity at " + offset + " " + length);
//		System.err.println("%% Got entity [" + new String(buff, offset, length) + "]");
		if (buff[offset] == '#') {
                        if (length > 1 && (buff[offset+1] == 'x'
                                        || buff[offset+1] == 'X')) {
                                try {
                                        return Integer.parseInt(new String(buff, offset + 2, length - 2), 16);
                                        }
                                catch (NumberFormatException e) { return 0; }
                                }
                        try {
                                return Integer.parseInt(new String(buff, offset + 1, length - 1), 10);
                                }
                        catch (NumberFormatException e) { return 0; }
                        }
		return theSchema.getEntity(new String(buff, offset, length));
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.455 -0500", hash_original_method = "0A8BABE6DCD2F294E63CAA7BFD276118", hash_generated_method = "35DB48322BC130C807B70FAE10C1AF41")
	
public void eof(char[] buff, int offset, int length) throws SAXException {
		if (virginStack) rectify(thePCDATA);
		while (theStack.next() != null) {
			pop();
			}
		if (!(theSchema.getURI().equals("")))
			theContentHandler.endPrefixMapping(theSchema.getPrefix());
		theContentHandler.endDocument();
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.457 -0500", hash_original_method = "551A0AD1D8D7CCFDEAB6F03D7C2481C3", hash_generated_method = "F01391A1BCDA9F229321517D0F8305D7")
	
public void etag(char[] buff, int offset, int length) throws SAXException {
		if (etag_cdata(buff, offset, length)) return;
		etag_basic(buff, offset, length);
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.462 -0500", hash_original_method = "C9023F984BCCCBD84980442CF55120FA", hash_generated_method = "5E76E4E52FB9F10EFF69430785A9F2CA")
	
public boolean etag_cdata(char[] buff, int offset, int length) throws SAXException {
		String currentName = theStack.name();
		// If this is a CDATA element and the tag doesn't match,
		// or isn't properly formed (junk after the name),
		// restart CDATA mode and process the tag as characters.
		if (CDATAElements && (theStack.flags() & Schema.F_CDATA) != 0) {
			boolean realTag = (length == currentName.length());
			if (realTag) {
				for (int i = 0; i < length; i++) {
					if (Character.toLowerCase(buff[offset + i]) != Character.toLowerCase(currentName.charAt(i))) {
						realTag = false;
						break;
						}
					}
				}
			if (!realTag) {
				theContentHandler.characters(etagchars, 0, 2);
				theContentHandler.characters(buff, offset, length);
				theContentHandler.characters(etagchars, 2, 1);
				theScanner.startCDATA();
				return true;
				}
			}
		return false;
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.465 -0500", hash_original_method = "F1F8115795B982079B234CC2192B7DDB", hash_generated_method = "B0546FD398D87165A38E8EB61E35AA26")
	
public void etag_basic(char[] buff, int offset, int length) throws SAXException {
		theNewElement = null;
		String name;
		if (length != 0) {
			// Canonicalize case of name
			name = makeName(buff, offset, length);
//			System.err.println("got etag [" + name + "]");
			ElementType type = theSchema.getElementType(name);
			if (type == null) return;	// mysterious end-tag
			name = type.name();
			}
		else {
			name = theStack.name();
			}
//		System.err.println("%% Got end of " + name);

		Element sp;
		boolean inNoforce = false;
		for (sp = theStack; sp != null; sp = sp.next()) {
			if (sp.name().equals(name)) break;
			if ((sp.flags() & Schema.F_NOFORCE) != 0) inNoforce = true;
			}

		if (sp == null) return;		// Ignore unknown etags
		if (sp.next() == null || sp.next().next() == null) return;
		if (inNoforce) {		// inside an F_NOFORCE element?
			sp.preclose();		// preclose the matching element
			}
		else {			// restartably pop everything above us
			while (theStack != sp) {
				restartablyPop();
				}
			pop();
			}
		// pop any preclosed elements now at the top
		while (theStack.isPreclosed()) {
			pop();
			}
		restart(null);
		}

	// Push restartables on the stack if possible
	// e is the next element to be started, if we know what it is
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.468 -0500", hash_original_method = "B330A365C16A276F019BF46E61F37EA8", hash_generated_method = "C94055E14789F3D4B4005D8A2E2C6A9F")
	
private void restart(Element e) throws SAXException {
		while (theSaved != null && theStack.canContain(theSaved) &&
				(e == null || theSaved.canContain(e))) {
			Element next = theSaved.next();
			push(theSaved);
			theSaved = next;
			}
		}

	// Pop the stack irrevocably
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.471 -0500", hash_original_method = "C52776A5281CF0A097BB6E08724FB3A1", hash_generated_method = "54B1BF5D19956C534F2E337C7AC539A2")
	
private void pop() throws SAXException {
		if (theStack == null) return;		// empty stack
		String name = theStack.name();
		String localName = theStack.localName();
		String namespace = theStack.namespace();
		String prefix = prefixOf(name);

//		System.err.println("%% Popping " + name);
		if (!namespaces) namespace = localName = "";
		theContentHandler.endElement(namespace, localName, name);
		if (foreign(prefix, namespace)) {
			theContentHandler.endPrefixMapping(prefix);
//			System.err.println("%% Unmapping [" + prefix + "] for elements to " + namespace);
			}
		Attributes atts = theStack.atts();
		for (int i = atts.getLength() - 1; i >= 0; i--) {
			String attNamespace = atts.getURI(i);
			String attPrefix = prefixOf(atts.getQName(i));
			if (foreign(attPrefix, attNamespace)) {
				theContentHandler.endPrefixMapping(attPrefix);
//			System.err.println("%% Unmapping [" + attPrefix + "] for attributes to " + attNamespace);
				}
			}
		theStack = theStack.next();
		}

	// Pop the stack restartably
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.473 -0500", hash_original_method = "C8A2C1B1941DD99452371A15DDB14C88", hash_generated_method = "BD3C8BE7B2DD000A556512EEEE0E226A")
	
private void restartablyPop() throws SAXException {
		Element popped = theStack;
		pop();
		if (restartElements && (popped.flags() & Schema.F_RESTART) != 0) {
			popped.anonymize();
			popped.setNext(theSaved);
			theSaved = popped;
			}
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.478 -0500", hash_original_method = "CEB0923649F562E1C47AECBE0F37237A", hash_generated_method = "F8D319B8DFAB4F7C272231877CEB3231")
	
private void push(Element e) throws SAXException {
		String name = e.name();
		String localName = e.localName();
		String namespace = e.namespace();
		String prefix = prefixOf(name);

//		System.err.println("%% Pushing " + name);
		e.clean();
		if (!namespaces) namespace = localName = "";
                if (virginStack && localName.equalsIgnoreCase(theDoctypeName)) {
                    try {
                        theEntityResolver.resolveEntity(theDoctypePublicId, theDoctypeSystemId);
                    } catch (IOException ew) { }   // Can't be thrown for root I believe.
                }
		if (foreign(prefix, namespace)) {
			theContentHandler.startPrefixMapping(prefix, namespace);
//			System.err.println("%% Mapping [" + prefix + "] for elements to " + namespace);
			}
		Attributes atts = e.atts();
		int len = atts.getLength();
		for (int i = 0; i < len; i++) {
			String attNamespace = atts.getURI(i);
			String attPrefix = prefixOf(atts.getQName(i));
			if (foreign(attPrefix, attNamespace)) {
				theContentHandler.startPrefixMapping(attPrefix, attNamespace);
//				System.err.println("%% Mapping [" + attPrefix + "] for attributes to " + attNamespace);
				}
			}
		theContentHandler.startElement(namespace, localName, name, e.atts());
		e.setNext(theStack);
		theStack = e;
		virginStack = false;
		if (CDATAElements && (theStack.flags() & Schema.F_CDATA) != 0) {
			theScanner.startCDATA();
			}
		}

	// Get the prefix from a QName
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.481 -0500", hash_original_method = "EBD18CEBBA646E39DB7BD8DC690DDED7", hash_generated_method = "9D5F572A96271648363680F006A20732")
	
private String prefixOf(String name) {
		int i = name.indexOf(':');
		String prefix = "";
		if (i != -1) prefix = name.substring(0, i);
//		System.err.println("%% " + prefix + " is prefix of " + name);
		return prefix;
		}

	// Return true if we have a foreign name
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.483 -0500", hash_original_method = "761321F4D2C89C49E6A94969107BF018", hash_generated_method = "D455C227E6289797BD96598D48715321")
	
private boolean foreign(String prefix, String namespace) {
//		System.err.print("%% Testing " + prefix + " and " + namespace + " for foreignness -- ");
		boolean foreign = !(prefix.equals("") || namespace.equals("") ||
			namespace.equals(theSchema.getURI()));
//		System.err.println(foreign);
		return foreign;
		}

        /**
         * Parsing the complete XML Document Type Definition is way too complex,
         * but for many simple cases we can extract something useful from it.
         *
         * doctypedecl  ::= '<!DOCTYPE' S Name (S ExternalID)? S? ('[' intSubset ']' S?)? '>'
         *  DeclSep     ::= PEReference | S
         *  intSubset   ::= (markupdecl | DeclSep)*
         *  markupdecl  ::= elementdecl | AttlistDecl | EntityDecl | NotationDecl | PI | Comment
         *  ExternalID  ::= 'SYSTEM' S SystemLiteral | 'PUBLIC' S PubidLiteral S SystemLiteral
         */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.486 -0500", hash_original_method = "1C2CEC982271DB04AB7A74A00D860FDA", hash_generated_method = "8930E9D2EF04805BC5DDA8A8F8D4F259")
	
public void decl(char[] buff, int offset, int length) throws SAXException {
		String s = new String(buff, offset, length);
		String name = null;
		String systemid = null;
		String publicid = null;
		String[] v = split(s);
		if (v.length > 0 && "DOCTYPE".equals(v[0])) {
			if (theDoctypeIsPresent) return;		// one doctype only!
			theDoctypeIsPresent = true;
			if (v.length > 1) {
				name = v[1];
				if (v.length>3 && "SYSTEM".equals(v[2])) {
				systemid = v[3];
				}
			else if (v.length > 3 && "PUBLIC".equals(v[2])) {
				publicid = v[3];
				if (v.length > 4) {
					systemid = v[4];
					}
				else {
					systemid = "";
					}
                    }
                }
            }
		publicid = trimquotes(publicid);
		systemid = trimquotes(systemid);
		if (name != null) {
			publicid = cleanPublicid(publicid);
			theLexicalHandler.startDTD(name, publicid, systemid);
			theLexicalHandler.endDTD();
			theDoctypeName = name;
			theDoctypePublicId = publicid;
		if (theScanner instanceof Locator) {    // Must resolve systemid
                    theDoctypeSystemId  = ((Locator)theScanner).getSystemId();
                    try {
                        theDoctypeSystemId = new URL(new URL(theDoctypeSystemId), systemid).toString();
                    } catch (Exception e) {}
                }
            }
        }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.498 -0500", hash_original_method = "92ECD15FFBF9920D383290E17881F5A3", hash_generated_method = "7369990E1790A764920FC6A5232A9E26")
	
private String cleanPublicid(String src) {
		if (src == null) return null;
		int len = src.length();
		StringBuffer dst = new StringBuffer(len);
		boolean suppressSpace = true;
		for (int i = 0; i < len; i++) {
			char ch = src.charAt(i);
			if (legal.indexOf(ch) != -1) { 	// legal but not whitespace
				dst.append(ch);
				suppressSpace = false;
				}
			else if (suppressSpace) {	// normalizable whitespace or junk
				;
				}
			else {
				dst.append(' ');
				suppressSpace = true;
				}
			}
//		System.err.println("%% Publicid [" + dst.toString().trim() + "]");
		return dst.toString().trim();	// trim any final junk whitespace
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.500 -0500", hash_original_method = "7EEA5677E99A2C9EF1241E44C92259AC", hash_generated_method = "A09418BCE283FD5D304C01E24EEC0A07")
	
public void gi(char[] buff, int offset, int length) throws SAXException {
		if (theNewElement != null) return;
		String name = makeName(buff, offset, length);
		if (name == null) return;
		ElementType type = theSchema.getElementType(name);
		if (type == null) {
			// Suppress unknown elements if ignore-bogons is on
			if (ignoreBogons) return;
			int bogonModel = bogonsEmpty ? Schema.M_EMPTY : Schema.M_ANY;
			int bogonMemberOf = rootBogons ? Schema.M_ANY : (Schema.M_ANY & ~ Schema.M_ROOT);
			theSchema.elementType(name, bogonModel, bogonMemberOf, 0);
			if (!rootBogons) theSchema.parent(name, theSchema.rootElementType().name());
			type = theSchema.getElementType(name);
			}

		theNewElement = new Element(type, defaultAttributes);
//		System.err.println("%% Got GI " + theNewElement.name());
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.503 -0500", hash_original_method = "A6AFE17C00CB0D2270FAE1159A108399", hash_generated_method = "C28812C2E8B4C24A42127E159A8BF641")
	
public void cdsect(char[] buff, int offset, int length) throws SAXException {
		theLexicalHandler.startCDATA();
		pcdata(buff, offset, length);
		theLexicalHandler.endCDATA();
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.505 -0500", hash_original_method = "087E39444EA30ADF63D8EEFEFF8A4B70", hash_generated_method = "9C229AB0526E7DFCEF41062F3552F7B1")
	
public void pcdata(char[] buff, int offset, int length) throws SAXException {
		if (length == 0) return;
		boolean allWhite = true;
		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(buff[offset+i])) {
				allWhite = false;
				}
			}
		if (allWhite && !theStack.canContain(thePCDATA)) {
			if (ignorableWhitespace) {
				theContentHandler.ignorableWhitespace(buff, offset, length);
				}
			}
		else {
			rectify(thePCDATA);
			theContentHandler.characters(buff, offset, length);
			}
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.507 -0500", hash_original_method = "10DA4877B62CBC6E2AF531E70FE25E21", hash_generated_method = "0B787657194752EF39A2F3489347493C")
	
public void pitarget(char[] buff, int offset, int length) throws SAXException {
		if (theNewElement != null) return;
		thePITarget = makeName(buff, offset, length).replace(':', '_');
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.510 -0500", hash_original_method = "373E8AB8CB624AD49A96496DDC7BD596", hash_generated_method = "D4167E8ABF3D70D6EEE3D25141115C67")
	
public void pi(char[] buff, int offset, int length) throws SAXException {
		if (theNewElement != null || thePITarget == null) return;
		if ("xml".equalsIgnoreCase(thePITarget)) return;
//		if (length > 0 && buff[length - 1] == '?') System.err.println("%% Removing ? from PI");
		if (length > 0 && buff[length - 1] == '?') length--;	// remove trailing ?
		theContentHandler.processingInstruction(thePITarget,
			new String(buff, offset, length));
		thePITarget = null;
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.512 -0500", hash_original_method = "E16C8825C4BEC5864699E25FFFCA21E7", hash_generated_method = "EE840103ADA0F88CCB5448BF47383D68")
	
public void stagc(char[] buff, int offset, int length) throws SAXException {
//		System.err.println("%% Start-tag");
		if (theNewElement == null) return;
		rectify(theNewElement);
		if (theStack.model() == Schema.M_EMPTY) {
			// Force an immediate end tag
			etag_basic(buff, offset, length);
			}
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.515 -0500", hash_original_method = "0E3563E6FA953D38A95EC3A2105DD410", hash_generated_method = "C14B78976D5F0170B64431BAC5373EFB")
	
public void stage(char[] buff, int offset, int length) throws SAXException {
//		System.err.println("%% Empty-tag");
		if (theNewElement == null) return;
		rectify(theNewElement);
		// Force an immediate end tag
		etag_basic(buff, offset, length);
		}
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.519 -0500", hash_original_method = "A603B5B2E591802383EBFF92F8BBF095", hash_generated_method = "A1B110DDF5694C9D7727F83F3D056C3D")
	
public void cmnt(char[] buff, int offset, int length) throws SAXException {
		theLexicalHandler.comment(buff, offset, length);
		}

	// Rectify the stack, pushing and popping as needed
	// so that the argument can be safely pushed
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.522 -0500", hash_original_method = "37597577D17F3DB30561754D63AF952D", hash_generated_method = "A7EE80275DC171DFF2F4303EF721218C")
	
private void rectify(Element e) throws SAXException {
		Element sp;
		while (true) {
			for (sp = theStack; sp != null; sp = sp.next()) {
				if (sp.canContain(e)) break;
				}
			if (sp != null) break;
			ElementType parentType = e.parent();
			if (parentType == null) break;
			Element parent = new Element(parentType, defaultAttributes);
//			System.err.println("%% Ascending from " + e.name() + " to " + parent.name());
			parent.setNext(e);
			e = parent;
			}
		if (sp == null) return;		// don't know what to do
		while (theStack != sp) {
			if (theStack == null || theStack.next() == null ||
				theStack.next().next() == null) break;
			restartablyPop();
			}
		while (e != null) {
			Element nexte = e.next();
			if (!e.name().equals("<pcdata>")) push(e);
			e = nexte;
			restart(e);
			}
		theNewElement = null;
		}

	@DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.524 -0500", hash_original_method = "7F354BAD0D4521AB4E9BA9D90015CEBE", hash_generated_method = "9EBC038850B0A7321D3CD57E7025995F")
	
public int getEntity() {
		return theEntity;
		}

	// Return the argument as a valid XML name
	// This no longer lowercases the result: we depend on Schema to
	// canonicalize case.
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.526 -0500", hash_original_method = "C657524A51A66CA45344D36C0B6F5C26", hash_generated_method = "A4C1980F2EF0C9354EA6FC4AB4E1FEB0")
	
private String makeName(char[] buff, int offset, int length) {
		StringBuffer dst = new StringBuffer(length + 2);
		boolean seenColon = false;
		boolean start = true;
//		String src = new String(buff, offset, length); // DEBUG
		for (; length-- > 0; offset++) {
			char ch = buff[offset];
			if (Character.isLetter(ch) || ch == '_') {
				start = false;
				dst.append(ch);
				}
			else if (Character.isDigit(ch) || ch == '-' || ch == '.') {
				if (start) dst.append('_');
				start = false;
				dst.append(ch);
				}
			else if (ch == ':' && !seenColon) {
				seenColon = true;
				if (start) dst.append('_');
				start = true;
				dst.append(translateColons ? '_' : ch);
				}
			}
		int dstLength = dst.length();
		if (dstLength == 0 || dst.charAt(dstLength - 1) == ':') dst.append('_');
//		System.err.println("Made name \"" + dst + "\" from \"" + src + "\"");
		return dst.toString().intern();
		}

	// Default LexicalHandler implementation

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.529 -0500", hash_original_method = "213183511FA9CBC21D458599F3954E65", hash_generated_method = "BA5E147159E36DDBB2E14A23437EDC56")
	
public void comment(char[] ch, int start, int length) throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.531 -0500", hash_original_method = "B026A18FCF4D46E60EDFCDEA2654D91E", hash_generated_method = "5436D7E012C1BB7651D047DE2AC3E706")
	
public void endCDATA() throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.533 -0500", hash_original_method = "3D36862B53F533617A1DD5C66B985713", hash_generated_method = "9481DC6C7665CC2EE67A168AF6997592")
	
public void endDTD() throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.535 -0500", hash_original_method = "A799CD2136F4389F2AB6AC2E97C1C7E3", hash_generated_method = "9E4C022B93F86FA2501718917A3E8660")
	
public void endEntity(String name) throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.537 -0500", hash_original_method = "E4BBD9A45ED517D6BA1A0F40E8CDD7AD", hash_generated_method = "4424B19DE8198582589012365F320887")
	
public void startCDATA() throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.540 -0500", hash_original_method = "6BDC1CD16BCB1071C2A9E7A68AA16026", hash_generated_method = "9B8088AFE1CCE287EECE3DD83ED5B76B")
	
public void startDTD(String name, String publicid, String systemid) throws SAXException { }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:46.542 -0500", hash_original_method = "DCC3E349AFEA1A7195E89C47AA33A3E4", hash_generated_method = "B61B8BDA3EE5CD516ADAEFA172F35910")
	
public void startEntity(String name) throws SAXException { }
}

