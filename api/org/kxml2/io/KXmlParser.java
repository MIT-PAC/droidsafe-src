package org.kxml2.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import libcore.internal.StringPool;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KXmlParser implements XmlPullParser, Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.889 -0500", hash_original_field = "B6C30B07108E7461E8E5E317076147B9", hash_generated_field = "A55120855D0EB510239B6C4441F51AAE")

    private static final String PROPERTY_XMLDECL_VERSION
            = "http://xmlpull.org/v1/doc/properties.html#xmldecl-version";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.891 -0500", hash_original_field = "B45EAF7F44AC90EC51369D73FC6A4CDA", hash_generated_field = "6D51E873AB83378675CBD979DE182EFE")

    private static final String PROPERTY_XMLDECL_STANDALONE
            = "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.894 -0500", hash_original_field = "0417DA3D355DFAF375A9F73C68069668", hash_generated_field = "E4463FE3DABC66E04C600BDAC16EE7C5")

    private static final String PROPERTY_LOCATION = "http://xmlpull.org/v1/doc/properties.html#location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.897 -0500", hash_original_field = "AC931071D95E82345B9DC68F28085490", hash_generated_field = "268A61AB07F8975416D95A6108614DB4")

    private static final String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.899 -0500", hash_original_field = "7FEC1D9AEB09C65472CDBB8B82B0755C", hash_generated_field = "6DD1487BA02DCE058EBB56C6D00845DA")

    private static final Map<String, String> DEFAULT_ENTITIES = new HashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.902 -0500", hash_original_field = "A5CE4019640D8291AA5F62C2FDB1F8E2", hash_generated_field = "9E004EC37549D77F0649D4ADE1AD1D11")

    private static final int ELEMENTDECL = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.905 -0500", hash_original_field = "BC748E776E075F47D04688DC16AFABF5", hash_generated_field = "54F59956AE951C536E4F8B77591DDCD1")

    private static final int ENTITYDECL = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.907 -0500", hash_original_field = "4B38F3FCA5189F81E6F49065A84A0E31", hash_generated_field = "BC43E0FAC920F03CBC3B97B7F68A505D")

    private static final int ATTLISTDECL = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.910 -0500", hash_original_field = "30167C48C0752930BA843FF7EDEF65D7", hash_generated_field = "72B9346B282549C68EFF4F9A4488493B")

    private static final int NOTATIONDECL = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.913 -0500", hash_original_field = "EDAAF3F8F782F8CA2554B2FC45301902", hash_generated_field = "4A097A0AA45CC4E364F7B6FC29BC31E4")

    private static final int PARAMETER_ENTITY_REF = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.916 -0500", hash_original_field = "55DB3DAB944F49B1EDF9B74A3EAF6ACA", hash_generated_field = "AE91905FCADB2F5F070BC3120FB7DF2B")

    private static final char[] START_COMMENT = { '<', '!', '-', '-' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.918 -0500", hash_original_field = "57EA90875CA1479B04F50E5CEF747A82", hash_generated_field = "B9C01DA88191BDFD088979E680871860")

    private static final char[] END_COMMENT = { '-', '-', '>' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.920 -0500", hash_original_field = "2B392F64F58893184CD3B19079B4AF5D", hash_generated_field = "FF8AF1A2AC00395530E1421E331D4C1E")

    private static final char[] COMMENT_DOUBLE_DASH = { '-', '-' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.923 -0500", hash_original_field = "BAC2E30431D01FE0A3DF3C3EA444336B", hash_generated_field = "1F00DF0F8140B30091CAFD05256D4255")

    private static final char[] START_CDATA = { '<', '!', '[', 'C', 'D', 'A', 'T', 'A', '[' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.925 -0500", hash_original_field = "D5817AF234827B7A8A0289DD2BC7FCC9", hash_generated_field = "7E6AC8710E7F89251559D1CEBDE35997")

    private static final char[] END_CDATA = { ']', ']', '>' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.928 -0500", hash_original_field = "4CDD37636B97A186B9C3EFB4AB879470", hash_generated_field = "DB90089C944C238022A155399F6C9774")

    private static final char[] START_PROCESSING_INSTRUCTION = { '<', '?' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.931 -0500", hash_original_field = "4B586A6475D196510F01FA40378CF60F", hash_generated_field = "E589BDD6193F766F275FA9034F35F5BD")

    private static final char[] END_PROCESSING_INSTRUCTION = { '?', '>' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.934 -0500", hash_original_field = "75C2BE730254EDAE955EFF7F12D60D22", hash_generated_field = "EC707F57B4AC804FDD91FEAE1CA48143")

    private static final char[] START_DOCTYPE = { '<', '!', 'D', 'O', 'C', 'T', 'Y', 'P', 'E' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.937 -0500", hash_original_field = "63ABF5590A02A3F8F42675A2BA3683DA", hash_generated_field = "1953AEE3F130CEDFCF173BC749E8D74C")

    private static final char[] SYSTEM = { 'S', 'Y', 'S', 'T', 'E', 'M' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.940 -0500", hash_original_field = "903B90FABB4E60FAC6A5991DEC294F4C", hash_generated_field = "1B9EE2198CFA65978EDAD9837C2D98E4")

    private static final char[] PUBLIC = { 'P', 'U', 'B', 'L', 'I', 'C' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.942 -0500", hash_original_field = "A68B7733ECEFCE393F8E7434E43C98C6", hash_generated_field = "1E07434ACF3BAEC92793981CB62A1257")

    private static final char[] START_ELEMENT = { '<', '!', 'E', 'L', 'E', 'M', 'E', 'N', 'T' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.945 -0500", hash_original_field = "C022116132AEFF12CF11600CEC07592E", hash_generated_field = "93647CCB1C4A3560B5811642ACC808E1")

    private static final char[] START_ATTLIST = { '<', '!', 'A', 'T', 'T', 'L', 'I', 'S', 'T' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.947 -0500", hash_original_field = "912EF03306C53BE0A8255D3CC5D09026", hash_generated_field = "C13600C3B78CBE3E04176024A982C019")

    private static final char[] START_ENTITY = { '<', '!', 'E', 'N', 'T', 'I', 'T', 'Y' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.950 -0500", hash_original_field = "CCF2953C8B5A2E1769891C886B34897D", hash_generated_field = "26DEA7BBC851381E3B051A614341C3A5")

    private static final char[] START_NOTATION = { '<', '!', 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.953 -0500", hash_original_field = "89C334EEAB4E9CB2ECD5EE17593EEE7A", hash_generated_field = "CE5BBCD42C3BCD0FA21C3D08DE5E6A76")

    private static final char[] EMPTY = new char[] { 'E', 'M', 'P', 'T', 'Y' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.955 -0500", hash_original_field = "8EFD2FC0944FE7276B8713144177F141", hash_generated_field = "8084EC1AE9BBB77E8C4CE487BFA97E84")

    private static final char[] ANY = new char[]{ 'A', 'N', 'Y' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.958 -0500", hash_original_field = "BB1D3338DE997E0DB3F1F91DA15C8420", hash_generated_field = "4DEDC0055F8730628487DF60C24AE644")

    private static final char[] NDATA = new char[]{ 'N', 'D', 'A', 'T', 'A' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.961 -0500", hash_original_field = "50165677882FA31C522D493830BC9B7F", hash_generated_field = "F8F98D147E42E5C73D61223E22989674")

    private static final char[] NOTATION = new char[]{ 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.964 -0500", hash_original_field = "1DAE8AF338F02466E97BF0841F9F7B85", hash_generated_field = "36F47AE4877D288517520A35D94C23D0")

    private static final char[] REQUIRED = new char[] { 'R', 'E', 'Q', 'U', 'I', 'R', 'E', 'D' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.967 -0500", hash_original_field = "7594876C148D5867867CC979430EDA94", hash_generated_field = "D9FA6B2501522578811C97ACB8DA0B4A")

    private static final char[] IMPLIED = new char[] { 'I', 'M', 'P', 'L', 'I', 'E', 'D' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.969 -0500", hash_original_field = "B821C33435A4B0F583727FD6C719FC8B", hash_generated_field = "D77E8DBC383CA9965DF66F0E9CBC458F")

    private static final char[] FIXED = new char[] { 'F', 'I', 'X', 'E', 'D' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.972 -0500", hash_original_field = "84802BA220928BF77B9E4B9ED85BF6B9", hash_generated_field = "1DABD35C32510824D283D1E8D34D1E30")

    static final private String UNEXPECTED_EOF = "Unexpected EOF";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.974 -0500", hash_original_field = "C48886D45C326E67A4F80FC8738CB1B2", hash_generated_field = "1DACE964DB2B3286A1F2AD099EF50C87")

    static final private String ILLEGAL_TYPE = "Wrong event type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.977 -0500", hash_original_field = "A9FAAAEDECBD01A290DC27E4B0609821", hash_generated_field = "08E26EE9AE32DEA74B8044C2977B0BF5")

    static final private int XML_DECLARATION = 998;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.103 -0500", hash_original_field = "DA9055C371F2212EF584F2D76F3328B2", hash_generated_field = "FDBEB59450D649476077B2C45FE302BE")

    private static final char[] SINGLE_QUOTE = new char[] { '\'' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.106 -0500", hash_original_field = "78DC207A49937CCFD694D71D085C8DA7", hash_generated_field = "57CA247B64F06AAD2642685314F137D4")

    private static final char[] DOUBLE_QUOTE = new char[] { '"' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.980 -0500", hash_original_field = "4B5743C8685C2D199755623CB9DF3317", hash_generated_field = "CE74502D5DD419367E637D11E946AE48")

    private String location;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.982 -0500", hash_original_field = "E7C7F9C42A2A22D94FED803CEAE19197", hash_generated_field = "B9C33225233D273951C807AA4A997C84")

    private String version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.984 -0500", hash_original_field = "21579C48DFBFBD465BCD4B2881A6F78C", hash_generated_field = "F545B366D95421A9D0545B064DF3FA15")

    private Boolean standalone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.987 -0500", hash_original_field = "090E468FF5523B8C486EC5B418B3FD0E", hash_generated_field = "22BD78252C1771E229BD8814989F89D7")

    private String rootElementName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.989 -0500", hash_original_field = "EA33D5D9FADC1DE12A306FAB26B3A5DA", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.991 -0500", hash_original_field = "A787D4782D28CB658656F9CEA39140B8", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.993 -0500", hash_original_field = "1C6FA486402CC8B00C0447B00AD9E384", hash_generated_field = "6545B566A550C532A7353AE3BD57F4A5")

    private boolean processDocDecl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.996 -0500", hash_original_field = "D8EC437729E41B3A6077FA06D5E17FC1", hash_generated_field = "769EB7E2763BBF503944F860A1BF2B53")

    private boolean processNsp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:08.999 -0500", hash_original_field = "63019E0D9FEBEFFBC78DF613067F6FF0", hash_generated_field = "56D1CD4D0FE519DF4F93CCF1C262BFDF")

    private boolean relaxed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.001 -0500", hash_original_field = "B15737C3F0793C7B4B47FF5DDC56BCF3", hash_generated_field = "7273BF2007F6D9DA572D2E585776EE5B")

    private boolean keepNamespaceAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.004 -0500", hash_original_field = "29025818642562243930CF06B632680E", hash_generated_field = "7C254A9FE7EB03488648DE590A70B1E8")

    private StringBuilder bufferCapture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.006 -0500", hash_original_field = "136CAFD05C06C74294051D7F349B8005", hash_generated_field = "5EE5BD02D72D06CAAF4EF8E2D19E1135")

    private Map<String, char[]> documentEntities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.008 -0500", hash_original_field = "EEDB4D54BDBE8BF0D3DF53DCC889410F", hash_generated_field = "E290D91FC5BAFD29B00A44E1145FC9FB")

    private Map<String, Map<String, String>> defaultAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.011 -0500", hash_original_field = "C1588B2CF4C1B54961548959E16213DF", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.013 -0500", hash_original_field = "38990E4CEA8D76D1592FFA02FC2EF7CF", hash_generated_field = "C38C16C38A66AC817AFDEB16F3AB2C79")

    private String[] elementStack = new String[16];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.016 -0500", hash_original_field = "8EA4A0A9B4FE19234EE113C97B53D859", hash_generated_field = "9D1B39E20FB88BB665BD0F6B05D41FA2")

    private String[] nspStack = new String[8];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.018 -0500", hash_original_field = "A80BC3B9F534A39518995400BFC23758", hash_generated_field = "167B18033DE59DDC6FAA031548884DC7")

    private int[] nspCounts = new int[4];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.021 -0500", hash_original_field = "359C2477A0D4C46A46237360E9D6E3E1", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private Reader reader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.024 -0500", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.026 -0500", hash_original_field = "E7CEE445610DEC6EAC532927A160BD27", hash_generated_field = "B7F81B9E6E384492F57E569C80E0DE3A")

    private ContentSource nextContentSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.028 -0500", hash_original_field = "68FF650A3AD4940FE5AFAAB2745D1D24", hash_generated_field = "577EC909B068680E25766CC68FC4E0C4")

    private char[] buffer = new char[8192];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.031 -0500", hash_original_field = "B0CD1B3F8E4067A68C294939F6EB1E36", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

    private int position = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.033 -0500", hash_original_field = "F602A8CF90B83389FBF2F8BAA69F1FC4", hash_generated_field = "00F405BC8E12348750DA51A45F66E092")

    private int limit = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.035 -0500", hash_original_field = "04F85F3AA198A1A84C10A1A5F1BAC0C1", hash_generated_field = "ABCC56A72A2BAE75E77EB925AA857BA4")

    private int bufferStartLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.037 -0500", hash_original_field = "9BF81C3A36BD07A1A61AC5A0B9BB4188", hash_generated_field = "322559720B3F732E76842B5632DA7E78")

    private int bufferStartColumn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.040 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.042 -0500", hash_original_field = "8B20809ECF6512A9964FA742E2DD1B67", hash_generated_field = "002F5A5E90D73E291F33E6C6294E8D20")

    private boolean isWhitespace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.044 -0500", hash_original_field = "B2ACBE152D6DAD1E8751FB2F01EE46C3", hash_generated_field = "E3760D072DB711CCBCD48E45C2700E12")

    private String namespace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.047 -0500", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.049 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.052 -0500", hash_original_field = "9EF4B8A5DE4B8BD37EE465C3BB62CC6C", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.054 -0500", hash_original_field = "C0C8E49643B01DE796B2F6BF4C42F496", hash_generated_field = "DBB8A6C14E3796CA3A469826B313EF12")

    private boolean degenerated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.056 -0500", hash_original_field = "17984B13C42D8625B58D1105020D20EF", hash_generated_field = "269E5A2AA1CB94A01698B537489DA5D4")

    private int attributeCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.059 -0500", hash_original_field = "A2C79C652FF74DF726BF6C73D8AD8FCC", hash_generated_field = "569C94B11664DECEEFD3830A5970E18C")

    private String[] attributes = new String[16];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.061 -0500", hash_original_field = "0D30CB179838970E213CB4B387147117", hash_generated_field = "5A2A9A2BD7181810539A763573C1D6FB")

    private String error;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.063 -0500", hash_original_field = "1265BD6A83FE3C6DE6BDF9066F32BFBC", hash_generated_field = "3CE0322C00553A852949CE941813EC46")

    private boolean unresolved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.066 -0500", hash_original_field = "5064578541FC4C3433253A286EE1A409", hash_generated_field = "E6746676D26EF55819E689A7D8CBC54D")

    public final StringPool stringPool = new StringPool();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.002 -0400", hash_original_method = "010DAC0EB3331EDC25D05B4FF02298A9", hash_generated_method = "010DAC0EB3331EDC25D05B4FF02298A9")
    public KXmlParser ()
    {
        //Synthesized constructor
    }

    /**
     * Retains namespace attributes like {@code xmlns="http://foo"} or {@code xmlns:foo="http:foo"}
     * in pulled elements. Most applications will only be interested in the effective namespaces of
     * their elements, so these attributes aren't useful. But for structure preserving wrappers like
     * DOM, it is necessary to keep the namespace data around.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.068 -0500", hash_original_method = "A527DEDBB8977F1D947B829D15DAACC5", hash_generated_method = "78C46E6363438B7817DC5676978626F8")
    
public void keepNamespaceAttributes() {
        this.keepNamespaceAttributes = true;
    }
        
@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.005 -0400", hash_original_method = "F08928441827C23946744248151D18D9", hash_generated_method = "873EFD7690BD62772E8E3CF4ECA9E465")
    private boolean adjustNsp() throws XmlPullParserException {
        boolean any = false;
for(int i = 0;i < attributeCount << 2;i += 4)
        {
            String attrName = attributes[i + 2];
            int cut = attrName.indexOf(':');
            String prefix;
            if(cut != -1)            
            {
                prefix = attrName.substring(0, cut);
                attrName = attrName.substring(cut + 1);
            } //End block
            else
            if(attrName.equals("xmlns"))            
            {
                prefix = attrName;
                attrName = null;
            } //End block
            else
            {
                continue;
            } //End block
            if(!prefix.equals("xmlns"))            
            {
                any = true;
            } //End block
            else
            {
                int j = (nspCounts[depth]++) << 1;
                nspStack = ensureCapacity(nspStack, j + 2);
                nspStack[j] = attrName;
                nspStack[j + 1] = attributes[i + 3];
                if(attrName != null && attributes[i + 3].isEmpty())                
                {
                    checkRelaxed("illegal empty namespace");
                } //End block
                if(keepNamespaceAttributes)                
                {
                    attributes[i] = "http://www.w3.org/2000/xmlns/";
                    any = true;
                } //End block
                else
                {
                    System.arraycopy(
                            attributes,
                            i + 4,
                            attributes,
                            i,
                            ((--attributeCount) << 2) - i);
                    i -= 4;
                } //End block
            } //End block
        } //End block
        if(any)        
        {
for(int i = (attributeCount << 2) - 4;i >= 0;i -= 4)
            {
                String attrName = attributes[i + 2];
                int cut = attrName.indexOf(':');
                if(cut == 0 && !relaxed)                
                {
                    RuntimeException varED97AAB5843948CA47DCBF2C58EC51F0_1764040438 = new RuntimeException(
                            "illegal attribute name: " + attrName + " at " + this);
                    varED97AAB5843948CA47DCBF2C58EC51F0_1764040438.addTaint(getTaint());
                    throw varED97AAB5843948CA47DCBF2C58EC51F0_1764040438;
                } //End block
                else
                if(cut != -1)                
                {
                    String attrPrefix = attrName.substring(0, cut);
                    attrName = attrName.substring(cut + 1);
                    String attrNs = getNamespace(attrPrefix);
                    if(attrNs == null && !relaxed)                    
                    {
                        RuntimeException varB9AFB5BE9C6FD0ABD6B99FD1168B2524_568875178 = new RuntimeException(
                                "Undefined Prefix: " + attrPrefix + " in " + this);
                        varB9AFB5BE9C6FD0ABD6B99FD1168B2524_568875178.addTaint(getTaint());
                        throw varB9AFB5BE9C6FD0ABD6B99FD1168B2524_568875178;
                    } //End block
                    attributes[i] = attrNs;
                    attributes[i + 1] = attrPrefix;
                    attributes[i + 2] = attrName;
                } //End block
            } //End block
        } //End block
        int cut = name.indexOf(':');
        if(cut == 0)        
        {
            checkRelaxed("illegal tag name: " + name);
        } //End block
        if(cut != -1)        
        {
            prefix = name.substring(0, cut);
            name = name.substring(cut + 1);
        } //End block
        this.namespace = getNamespace(prefix);
        if(this.namespace == null)        
        {
            if(prefix != null)            
            {
                checkRelaxed("undefined prefix: " + prefix);
            } //End block
            this.namespace = NO_NAMESPACE;
        } //End block
        boolean var100B8CAD7CF2A56F6DF78F171F97A1EC_758100014 = (any);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741192703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741192703;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.075 -0500", hash_original_method = "49B8B44C0E7574021385F3D8BD03186C", hash_generated_method = "79E7724D85DC13D1988F89D143BC4A06")
    
private String[] ensureCapacity(String[] arr, int required) {
        if (arr.length >= required) {
            return arr;
        }
        String[] bigger = new String[required + 16];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
        return bigger;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.077 -0500", hash_original_method = "4A7BCCF6DFE9CB9D8E85D47BF7F54B1D", hash_generated_method = "D04A99BE7FD7E0CF094DBD2A451BE2C5")
    
private void checkRelaxed(String errorMessage) throws XmlPullParserException {
        if (!relaxed) {
            throw new XmlPullParserException(errorMessage, this, null);
        }
        if (error == null) {
            error = "Error: " + errorMessage;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.079 -0500", hash_original_method = "76E82C4E283B430F3EE1381EBB2709F7", hash_generated_method = "6AA522232FDA969A272AF4F0D4FAA953")
    
public int next() throws XmlPullParserException, IOException {
        return next(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.082 -0500", hash_original_method = "B3A65F7F837C14F73BB928D8BDFE9D91", hash_generated_method = "8621D80C8D674E0E598CA49C50346B8E")
    
public int nextToken() throws XmlPullParserException, IOException {
        return next(true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.086 -0500", hash_original_method = "55251A1079E5B9F4E3B9F053CFE6FD44", hash_generated_method = "9A5E6D108F7B1BFAB4B3993625CD7EBD")
    
private int next(boolean justOneToken) throws IOException, XmlPullParserException {
        if (reader == null) {
            throw new XmlPullParserException("setInput() must be called first.", this, null);
        }

        if (type == END_TAG) {
            depth--;
        }

        // degenerated needs to be handled before error because of possible
        // processor expectations(!)

        if (degenerated) {
            degenerated = false;
            type = END_TAG;
            return type;
        }

        if (error != null) {
            if (justOneToken) {
                text = error;
                type = COMMENT;
                error = null;
                return type;
            } else {
                error = null;
            }
        }

        type = peekType(false);

        if (type == XML_DECLARATION) {
            readXmlDeclaration();
            type = peekType(false);
        }

        text = null;
        isWhitespace = true;
        prefix = null;
        name = null;
        namespace = null;
        attributeCount = -1;
        boolean throwOnResolveFailure = !justOneToken;

        while (true) {
            switch (type) {

            /*
             * Return immediately after encountering a start tag, end tag, or
             * the end of the document.
             */
            case START_TAG:
                parseStartTag(false, throwOnResolveFailure);
                return type;
            case END_TAG:
                readEndTag();
                return type;
            case END_DOCUMENT:
                return type;

            /*
             * Return after any text token when we're looking for a single
             * token. Otherwise concatenate all text between tags.
             */
            case ENTITY_REF:
                if (justOneToken) {
                    StringBuilder entityTextBuilder = new StringBuilder();
                    readEntity(entityTextBuilder, true, throwOnResolveFailure, ValueContext.TEXT);
                    text = entityTextBuilder.toString();
                    break;
                }
                // fall-through
            case TEXT:
                text = readValue('<', !justOneToken, throwOnResolveFailure, ValueContext.TEXT);
                if (depth == 0 && isWhitespace) {
                    type = IGNORABLE_WHITESPACE;
                }
                break;
            case CDSECT:
                read(START_CDATA);
                text = readUntil(END_CDATA, true);
                break;

            /*
             * Comments, processing instructions and declarations are returned
             * when we're looking for a single token. Otherwise they're skipped.
             */
            case COMMENT:
                String commentText = readComment(justOneToken);
                if (justOneToken) {
                    text = commentText;
                }
                break;
            case PROCESSING_INSTRUCTION:
                read(START_PROCESSING_INSTRUCTION);
                String processingInstruction = readUntil(END_PROCESSING_INSTRUCTION, justOneToken);
                if (justOneToken) {
                    text = processingInstruction;
                }
                break;
            case DOCDECL:
                readDoctype(justOneToken);
                break;

            default:
                throw new XmlPullParserException("Unexpected token", this, null);
            }

            if (depth == 0 && (type == ENTITY_REF || type == TEXT || type == CDSECT)) {
                throw new XmlPullParserException("Unexpected token", this, null);
            }

            if (justOneToken) {
                return type;
            }

            if (type == IGNORABLE_WHITESPACE) {
                text = null;
            }

            /*
             * We've read all that we can of a non-empty text block. Always
             * report this as text, even if it was a CDATA block or entity
             * reference.
             */
            int peek = peekType(false);
            if (text != null && !text.isEmpty() && peek < TEXT) {
                type = TEXT;
                return type;
            }

            type = peek;
        }
    }

    /**
     * Reads text until the specified delimiter is encountered. Consumes the
     * text and the delimiter.
     *
     * @param returnText true to return the read text excluding the delimiter;
     *     false to return null.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.090 -0500", hash_original_method = "C492543C28BFA45A4A603454FE30EBBB", hash_generated_method = "406E91A8533F3B594944B702203E858F")
    
private String readUntil(char[] delimiter, boolean returnText)
            throws IOException, XmlPullParserException {
        int start = position;
        StringBuilder result = null;

        if (returnText && text != null) {
            result = new StringBuilder();
            result.append(text);
        }

        search:
        while (true) {
            if (position + delimiter.length >= limit) {
                if (start < position && returnText) {
                    if (result == null) {
                        result = new StringBuilder();
                    }
                    result.append(buffer, start, position - start);
                }
                if (!fillBuffer(delimiter.length)) {
                    checkRelaxed(UNEXPECTED_EOF);
                    type = COMMENT;
                    return null;
                }
                start = position;
            }

            // TODO: replace with Arrays.equals(buffer, position, delimiter, 0, delimiter.length)
            // when the VM has better method inlining
            for (int i = 0; i < delimiter.length; i++) {
                if (buffer[position + i] != delimiter[i]) {
                    position++;
                    continue search;
                }
            }

            break;
        }

        int end = position;
        position += delimiter.length;

        if (!returnText) {
            return null;
        } else if (result == null) {
            return stringPool.get(buffer, start, end - start);
        } else {
            result.append(buffer, start, end - start);
            return result.toString();
        }
    }

    /**
     * Returns true if an XML declaration was read.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.093 -0500", hash_original_method = "79737DD70253BC976180BA8757B427A8", hash_generated_method = "E35A39FA6BB3D486C0447A61818648A7")
    
private void readXmlDeclaration() throws IOException, XmlPullParserException {
        if (bufferStartLine != 0 || bufferStartColumn != 0 || position != 0) {
            checkRelaxed("processing instructions must not start with xml");
        }

        read(START_PROCESSING_INSTRUCTION);
        parseStartTag(true, true);

        if (attributeCount < 1 || !"version".equals(attributes[2])) {
            checkRelaxed("version expected");
        }

        version = attributes[3];

        int pos = 1;

        if (pos < attributeCount && "encoding".equals(attributes[2 + 4])) {
            encoding = attributes[3 + 4];
            pos++;
        }

        if (pos < attributeCount && "standalone".equals(attributes[4 * pos + 2])) {
            String st = attributes[3 + 4 * pos];
            if ("yes".equals(st)) {
                standalone = Boolean.TRUE;
            } else if ("no".equals(st)) {
                standalone = Boolean.FALSE;
            } else {
                checkRelaxed("illegal standalone value: " + st);
            }
            pos++;
        }

        if (pos != attributeCount) {
            checkRelaxed("unexpected attributes in XML declaration");
        }

        isWhitespace = true;
        text = null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.095 -0500", hash_original_method = "15C58CE8BC29A2518B63BEC83A754E2C", hash_generated_method = "0D4634C17CD8754ABC0714C9115D5024")
    
private String readComment(boolean returnText) throws IOException, XmlPullParserException {
        read(START_COMMENT);

        if (relaxed) {
            return readUntil(END_COMMENT, returnText);
        }

        String commentText = readUntil(COMMENT_DOUBLE_DASH, returnText);
        if (peekCharacter() != '>') {
            throw new XmlPullParserException("Comments may not contain --", this, null);
        }
        position++;
        return commentText;
    }

    /**
     * Read the document's DTD. Although this parser is non-validating, the DTD
     * must be parsed to capture entity values and default attribute values.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.098 -0500", hash_original_method = "39B79927E64E599404174E0314CB7C82", hash_generated_method = "14898573EFB01349EBEEEB94E8FF6811")
    
private void readDoctype(boolean saveDtdText) throws IOException, XmlPullParserException {
        read(START_DOCTYPE);

        int startPosition = -1;
        if (saveDtdText) {
            bufferCapture = new StringBuilder();
            startPosition = position;
        }
        try {
            skip();
            rootElementName = readName();
            readExternalId(true, true);
            skip();
            if (peekCharacter() == '[') {
                readInternalSubset();
            }
            skip();
        } finally {
            if (saveDtdText) {
                bufferCapture.append(buffer, 0, position);
                bufferCapture.delete(0, startPosition);
                text = bufferCapture.toString();
                bufferCapture = null;
            }
        }

        read('>');
    }

    /**
     * Reads an external ID of one of these two forms:
     *   SYSTEM "quoted system name"
     *   PUBLIC "quoted public id" "quoted system name"
     *
     * If the system name is not required, this also supports lone public IDs of
     * this form:
     *   PUBLIC "quoted public id"
     *
     * Returns true if any ID was read.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.101 -0500", hash_original_method = "5A46FF78EB6898EF0CABAC45E530C34E", hash_generated_method = "94A775708A149FBFAB5E574EC9E989E8")
    
private boolean readExternalId(boolean requireSystemName, boolean assignFields)
            throws IOException, XmlPullParserException {
        skip();
        int c = peekCharacter();

        if (c == 'S') {
            read(SYSTEM);
        } else if (c == 'P') {
            read(PUBLIC);
            skip();
            if (assignFields) {
                publicId = readQuotedId(true);
            } else {
                readQuotedId(false);
            }
        } else {
            return false;
        }

        skip();

        if (!requireSystemName) {
            int delimiter = peekCharacter();
            if (delimiter != '"' && delimiter != '\'') {
                return true; // no system name!
            }
        }

        if (assignFields) {
            systemId = readQuotedId(true);
        } else {
            readQuotedId(false);
        }
        return true;
    }

    /**
     * Reads a quoted string, performing no entity escaping of the contents.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.108 -0500", hash_original_method = "4B3A97D73E48F79754EA5A86D4C2409D", hash_generated_method = "E8E025740DE214A84E53AA7057D82F38")
    
private String readQuotedId(boolean returnText) throws IOException, XmlPullParserException {
        int quote = peekCharacter();
        char[] delimiter;
        if (quote == '"') {
            delimiter = DOUBLE_QUOTE;
        } else if (quote == '\'') {
            delimiter = SINGLE_QUOTE;
        } else {
            throw new XmlPullParserException("Expected a quoted string", this, null);
        }
        position++;
        return readUntil(delimiter, returnText);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.112 -0500", hash_original_method = "065EAF2A999BF53AAEE6E5D55221F190", hash_generated_method = "7DA0A653A084C1C9049B04BCADA77FFE")
    
private void readInternalSubset() throws IOException, XmlPullParserException {
        read('[');

        while (true) {
            skip();
            if (peekCharacter() == ']') {
                position++;
                return;
            }

            int declarationType = peekType(true);
            switch (declarationType) {
            case ELEMENTDECL:
                readElementDeclaration();
                break;

            case ATTLISTDECL:
                readAttributeListDeclaration();
                break;

            case ENTITYDECL:
                readEntityDeclaration();
                break;

            case NOTATIONDECL:
                readNotationDeclaration();
                break;

            case PROCESSING_INSTRUCTION:
                read(START_PROCESSING_INSTRUCTION);
                readUntil(END_PROCESSING_INSTRUCTION, false);
                break;

            case COMMENT:
                readComment(false);
                break;

            case PARAMETER_ENTITY_REF:
                throw new XmlPullParserException(
                        "Parameter entity references are not supported", this, null);

            default:
                throw new XmlPullParserException("Unexpected token", this, null);
            }
        }
    }

    /**
     * Read an element declaration. This contains a name and a content spec.
     *   <!ELEMENT foo EMPTY >
     *   <!ELEMENT foo (bar?,(baz|quux)) >
     *   <!ELEMENT foo (#PCDATA|bar)* >
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.115 -0500", hash_original_method = "E2914311E18C41738022F5D7A73FEC8A", hash_generated_method = "6F752AA4232CE3D0BF9CC57A1B3B6A57")
    
private void readElementDeclaration() throws IOException, XmlPullParserException {
        read(START_ELEMENT);
        skip();
        readName();
        readContentSpec();
        skip();
        read('>');
    }

    /**
     * Read an element content spec. This is a regular expression-like pattern
     * of names or other content specs. The following operators are supported:
     *   sequence:    (a,b,c)
     *   choice:      (a|b|c)
     *   optional:    a?
     *   one or more: a+
     *   any number:  a*
     *
     * The special name '#PCDATA' is permitted but only if it is the first
     * element of the first group:
     *   (#PCDATA|a|b)
     *
     * The top-level element must be either a choice, a sequence, or one of the
     * special names EMPTY and ANY.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.118 -0500", hash_original_method = "A45115A32F8DEBE95546FC38EF8925EC", hash_generated_method = "1570FD12AEB4D29F4D58F624DC257169")
    
private void readContentSpec() throws IOException, XmlPullParserException {
        // this implementation is very lenient; it scans for balanced parens only
        skip();
        int c = peekCharacter();
        if (c == '(') {
            int depth = 0;
            do {
                if (c == '(') {
                    depth++;
                } else if (c == ')') {
                    depth--;
                }
                position++;
                c = peekCharacter();
            } while (depth > 0);

            if (c == '*' || c == '?' || c == '+') {
                position++;
            }
        } else if (c == EMPTY[0]) {
            read(EMPTY);
        } else if (c == ANY[0]) {
            read(ANY);
        } else {
            throw new XmlPullParserException("Expected element content spec", this, null);
        }
    }

    /**
     * Reads an attribute list declaration such as the following:
     *   <!ATTLIST foo
     *       bar CDATA #IMPLIED
     *       quux (a|b|c) "c"
     *       baz NOTATION (a|b|c) #FIXED "c">
     *
     * Each attribute has a name, type and default.
     *
     * Types are one of the built-in types (CDATA, ID, IDREF, IDREFS, ENTITY,
     * ENTITIES, NMTOKEN, or NMTOKENS), an enumerated type "(list|of|options)"
     * or NOTATION followed by an enumerated type.
     *
     * The default is either #REQUIRED, #IMPLIED, #FIXED, a quoted value, or
     * #FIXED with a quoted value.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.121 -0500", hash_original_method = "04CF7BEB7F762D6DB023733A3E9A3C83", hash_generated_method = "E38AB502E23B20B2B1798D00F04FB994")
    
private void readAttributeListDeclaration() throws IOException, XmlPullParserException {
        read(START_ATTLIST);
        skip();
        String elementName = readName();

        while (true) {
            skip();
            int c = peekCharacter();
            if (c == '>') {
                position++;
                return;
            }

            // attribute name
            String attributeName = readName();

            // attribute type
            skip();
            if (position + 1 >= limit && !fillBuffer(2)) {
                throw new XmlPullParserException("Malformed attribute list", this, null);
            }
            if (buffer[position] == NOTATION[0] && buffer[position + 1] == NOTATION[1]) {
                read(NOTATION);
                skip();
            }
            c = peekCharacter();
            if (c == '(') {
                position++;
                while (true) {
                    skip();
                    readName();
                    skip();
                    c = peekCharacter();
                    if (c == ')') {
                        position++;
                        break;
                    } else if (c == '|') {
                        position++;
                    } else {
                        throw new XmlPullParserException("Malformed attribute type", this, null);
                    }
                }
            } else {
                readName();
            }

            // default value
            skip();
            c = peekCharacter();
            if (c == '#') {
                position++;
                c = peekCharacter();
                if (c == 'R') {
                    read(REQUIRED);
                } else if (c == 'I') {
                    read(IMPLIED);
                } else if (c == 'F') {
                    read(FIXED);
                } else {
                    throw new XmlPullParserException("Malformed attribute type", this, null);
                }
                skip();
                c = peekCharacter();
            }
            if (c == '"' || c == '\'') {
                position++;
                // TODO: does this do escaping correctly?
                String value = readValue((char) c, true, true, ValueContext.ATTRIBUTE);
                position++;
                defineAttributeDefault(elementName, attributeName, value);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.124 -0500", hash_original_method = "CFB39B3ED48D8CD145E96E2E6FC1A186", hash_generated_method = "C32D664677458783E4A5A1EACDCCAB8F")
    
private void defineAttributeDefault(String elementName, String attributeName, String value) {
        if (defaultAttributes == null) {
            defaultAttributes = new HashMap<String, Map<String, String>>();
        }
        Map<String, String> elementAttributes = defaultAttributes.get(elementName);
        if (elementAttributes == null) {
            elementAttributes = new HashMap<String, String>();
            defaultAttributes.put(elementName, elementAttributes);
        }
        elementAttributes.put(attributeName, value);
    }

    /**
     * Read an entity declaration. The value of internal entities are inline:
     *   <!ENTITY foo "bar">
     *
     * The values of external entities must be retrieved by URL or path:
     *   <!ENTITY foo SYSTEM "http://host/file">
     *   <!ENTITY foo PUBLIC "-//Android//Foo//EN" "http://host/file">
     *   <!ENTITY foo SYSTEM "../file.png" NDATA png>
     *
     * Entities may be general or parameterized. Parameterized entities are
     * marked by a percent sign. Such entities may only be used in the DTD:
     *   <!ENTITY % foo "bar">
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.127 -0500", hash_original_method = "3ECF3BA7E150644C3EFC98E620B12B73", hash_generated_method = "BDE185F16C00F265DD04B71A3ED3CA39")
    
private void readEntityDeclaration() throws IOException, XmlPullParserException {
        read(START_ENTITY);
        boolean generalEntity = true;

        skip();
        if (peekCharacter() == '%') {
            generalEntity = false;
            position++;
            skip();
        }

        String name = readName();

        skip();
        int quote = peekCharacter();
        String entityValue;
        if (quote == '"' || quote == '\'') {
            position++;
            entityValue = readValue((char) quote, true, false, ValueContext.ENTITY_DECLARATION);
            position++;
        } else if (readExternalId(true, false)) {
            /*
             * Map external entities to the empty string. This is dishonest,
             * but it's consistent with Android's Expat pull parser.
             */
            entityValue = "";
            skip();
            if (peekCharacter() == NDATA[0]) {
                read(NDATA);
                skip();
                readName();
            }
        } else {
            throw new XmlPullParserException("Expected entity value or external ID", this, null);
        }

        if (generalEntity && processDocDecl) {
            if (documentEntities == null) {
                documentEntities = new HashMap<String, char[]>();
            }
            documentEntities.put(name, entityValue.toCharArray());
        }

        skip();
        read('>');
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.131 -0500", hash_original_method = "0A96EF478D2162A2E48AFFA05F705C17", hash_generated_method = "241A4FFD284F6A4661203FE4D22D9352")
    
private void readNotationDeclaration() throws IOException, XmlPullParserException {
        read(START_NOTATION);
        skip();
        readName();
        if (!readExternalId(false, false)) {
            throw new XmlPullParserException(
                    "Expected external ID or public ID for notation", this, null);
        }
        skip();
        read('>');
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.136 -0500", hash_original_method = "8099A7EBC5B0B16E684058778DE6A29B", hash_generated_method = "EA9FEEF8E95272B720AA8323AB316FBC")
    
private void readEndTag() throws IOException, XmlPullParserException {
        read('<');
        read('/');
        name = readName(); // TODO: pass the expected name in as a hint?
        skip();
        read('>');

        int sp = (depth - 1) * 4;

        if (depth == 0) {
            checkRelaxed("read end tag " + name + " with no tags open");
            type = COMMENT;
            return;
        }

        if (name.equals(elementStack[sp + 3])) {
            namespace = elementStack[sp];
            prefix = elementStack[sp + 1];
            name = elementStack[sp + 2];
        } else if (!relaxed) {
            throw new XmlPullParserException(
                    "expected: /" + elementStack[sp + 3] + " read: " + name, this, null);
        }
    }

    /**
     * Returns the type of the next token.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.139 -0500", hash_original_method = "06A44958C70A8BD5DE7481C49C8C3731", hash_generated_method = "26D03B2C4B8F57D7342AC8DE6B9B6539")
    
private int peekType(boolean inDeclaration) throws IOException, XmlPullParserException {
        if (position >= limit && !fillBuffer(1)) {
            return END_DOCUMENT;
        }

        switch (buffer[position]) {
        case '&':
            return ENTITY_REF; // &
        case '<':
            if (position + 3 >= limit && !fillBuffer(4)) {
                throw new XmlPullParserException("Dangling <", this, null);
            }

            switch (buffer[position + 1]) {
            case '/':
                return END_TAG; // </
            case '?':
                // we're looking for "<?xml " with case insensitivity
                if ((position + 5 < limit || fillBuffer(6))
                        && (buffer[position + 2] == 'x' || buffer[position + 2] == 'X')
                        && (buffer[position + 3] == 'm' || buffer[position + 3] == 'M')
                        && (buffer[position + 4] == 'l' || buffer[position + 4] == 'L')
                        && (buffer[position + 5] == ' ')) {
                    return XML_DECLARATION; // <?xml
                } else {
                    return PROCESSING_INSTRUCTION; // <?
                }
            case '!':
                switch (buffer[position + 2]) {
                case 'D':
                    return DOCDECL; // <!D
                case '[':
                    return CDSECT; // <![
                case '-':
                    return COMMENT; // <!-
                case 'E':
                    switch (buffer[position + 3]) {
                    case 'L':
                        return ELEMENTDECL; // <!EL
                    case 'N':
                        return ENTITYDECL; // <!EN
                    }
                    break;
                case 'A':
                    return ATTLISTDECL;  // <!A
                case 'N':
                    return NOTATIONDECL; // <!N
                }
                throw new XmlPullParserException("Unexpected <!", this, null);
            default:
                return START_TAG; // <
            }
        case '%':
            return inDeclaration ? PARAMETER_ENTITY_REF : TEXT;
        default:
            return TEXT;
        }
    }

    /**
     * Sets name and attributes
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.144 -0500", hash_original_method = "2D33E593F3270AF80057D4A47B14E7B9", hash_generated_method = "B8B6BDE68E0BEF60E1ED70C98BD2A809")
    
private void parseStartTag(boolean xmldecl, boolean throwOnResolveFailure)
            throws IOException, XmlPullParserException {
        if (!xmldecl) {
            read('<');
        }
        name = readName();
        attributeCount = 0;

        while (true) {
            skip();

            if (position >= limit && !fillBuffer(1)) {
                checkRelaxed(UNEXPECTED_EOF);
                return;
            }

            int c = buffer[position];

            if (xmldecl) {
                if (c == '?') {
                    position++;
                    read('>');
                    return;
                }
            } else {
                if (c == '/') {
                    degenerated = true;
                    position++;
                    skip();
                    read('>');
                    break;
                } else if (c == '>') {
                    position++;
                    break;
                }
            }

            String attrName = readName();

            int i = (attributeCount++) * 4;
            attributes = ensureCapacity(attributes, i + 4);
            attributes[i] = "";
            attributes[i + 1] = null;
            attributes[i + 2] = attrName;

            skip();
            if (position >= limit && !fillBuffer(1)) {
                checkRelaxed(UNEXPECTED_EOF);
                return;
            }

            if (buffer[position] == '=') {
                position++;

                skip();
                if (position >= limit && !fillBuffer(1)) {
                    checkRelaxed(UNEXPECTED_EOF);
                    return;
                }
                char delimiter = buffer[position];

                if (delimiter == '\'' || delimiter == '"') {
                    position++;
                } else if (relaxed) {
                    delimiter = ' ';
                } else {
                    throw new XmlPullParserException("attr value delimiter missing!", this, null);
                }

                attributes[i + 3] = readValue(delimiter, true, throwOnResolveFailure,
                        ValueContext.ATTRIBUTE);

                if (delimiter != ' ') {
                    position++; // end quote
                }
            } else if (relaxed) {
                attributes[i + 3] = attrName;
            } else {
                checkRelaxed("Attr.value missing f. " + attrName);
                attributes[i + 3] = attrName;
            }
        }

        int sp = depth++ * 4;
        elementStack = ensureCapacity(elementStack, sp + 4);
        elementStack[sp + 3] = name;

        if (depth >= nspCounts.length) {
            int[] bigger = new int[depth + 4];
            System.arraycopy(nspCounts, 0, bigger, 0, nspCounts.length);
            nspCounts = bigger;
        }

        nspCounts[depth] = nspCounts[depth - 1];

        if (processNsp) {
            adjustNsp();
        } else {
            namespace = "";
        }

        // For consistency with Expat, add default attributes after fixing namespaces.
        if (defaultAttributes != null) {
            Map<String, String> elementDefaultAttributes = defaultAttributes.get(name);
            if (elementDefaultAttributes != null) {
                for (Map.Entry<String, String> entry : elementDefaultAttributes.entrySet()) {
                    if (getAttributeValue(null, entry.getKey()) != null) {
                        continue; // an explicit value overrides the default
                    }

                    int i = (attributeCount++) * 4;
                    attributes = ensureCapacity(attributes, i + 4);
                    attributes[i] = "";
                    attributes[i + 1] = null;
                    attributes[i + 2] = entry.getKey();
                    attributes[i + 3] = entry.getValue();
                }
            }
        }

        elementStack[sp] = namespace;
        elementStack[sp + 1] = prefix;
        elementStack[sp + 2] = name;
    }

    /**
     * Reads an entity reference from the buffer, resolves it, and writes the
     * resolved entity to {@code out}. If the entity cannot be read or resolved,
     * {@code out} will contain the partial entity reference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.148 -0500", hash_original_method = "C79463E087C57C46760693ABFA80BBC0", hash_generated_method = "CA48AE69E92B0B0B0066650DAD61A27D")
    
private void readEntity(StringBuilder out, boolean isEntityToken, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        int start = out.length();

        if (buffer[position++] != '&') {
            throw new AssertionError();
        }

        out.append('&');

        while (true) {
            int c = peekCharacter();

            if (c == ';') {
                out.append(';');
                position++;
                break;

            } else if (c >= 128
                    || (c >= '0' && c <= '9')
                    || (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || c == '_'
                    || c == '-'
                    || c == '#') {
                position++;
                out.append((char) c);

            } else if (relaxed) {
                // intentionally leave the partial reference in 'out'
                return;

            } else {
                throw new XmlPullParserException("unterminated entity ref", this, null);
            }
        }

        String code = out.substring(start + 1, out.length() - 1);

        if (isEntityToken) {
            name = code;
        }

        if (code.startsWith("#")) {
            try {
                int c = code.startsWith("#x")
                        ? Integer.parseInt(code.substring(2), 16)
                        : Integer.parseInt(code.substring(1));
                out.delete(start, out.length());
                out.appendCodePoint(c);
                unresolved = false;
                return;
            } catch (NumberFormatException notANumber) {
                throw new XmlPullParserException("Invalid character reference: &" + code);
            } catch (IllegalArgumentException invalidCodePoint) {
                throw new XmlPullParserException("Invalid character reference: &" + code);
            }
        }

        if (valueContext == ValueContext.ENTITY_DECLARATION) {
            // keep the unresolved &code; in the text to resolve later
            return;
        }

        String defaultEntity = DEFAULT_ENTITIES.get(code);
        if (defaultEntity != null) {
            out.delete(start, out.length());
            unresolved = false;
            out.append(defaultEntity);
            return;
        }

        char[] resolved;
        if (documentEntities != null && (resolved = documentEntities.get(code)) != null) {
            out.delete(start, out.length());
            unresolved = false;
            if (processDocDecl) {
                pushContentSource(resolved); // parse the entity as XML
            } else {
                out.append(resolved); // include the entity value as text
            }
            return;
        }

        /*
         * The parser skipped an external DTD, and now we've encountered an
         * unknown entity that could have been declared there. Map it to the
         * empty string. This is dishonest, but it's consistent with Android's
         * old ExpatPullParser.
         */
        if (systemId != null) {
            out.delete(start, out.length());
            return;
        }

        // keep the unresolved entity "&code;" in the text for relaxed clients
        unresolved = true;
        if (throwOnResolveFailure) {
            checkRelaxed("unresolved: &" + code + ";");
        }
    }

    /**
     * Returns the current text or attribute value. This also has the side
     * effect of setting isWhitespace to false if a non-whitespace character is
     * encountered.
     *
     * @param delimiter {@code <} for text, {@code "} and {@code '} for quoted
     *     attributes, or a space for unquoted attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.156 -0500", hash_original_method = "645533039846ABF2603AD0F9C774FE0D", hash_generated_method = "31D62C83A5D564DE072E4EB5EACBF9D8")
    
private String readValue(char delimiter, boolean resolveEntities, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {

        /*
         * This method returns all of the characters from the current position
         * through to an appropriate delimiter.
         *
         * If we're lucky (which we usually are), we'll return a single slice of
         * the buffer. This fast path avoids allocating a string builder.
         *
         * There are 6 unlucky characters we could encounter:
         *  - "&":  entities must be resolved.
         *  - "%":  parameter entities are unsupported in entity values.
         *  - "<":  this isn't permitted in attributes unless relaxed.
         *  - "]":  this requires a lookahead to defend against the forbidden
         *          CDATA section delimiter "]]>".
         *  - "\r": If a "\r" is followed by a "\n", we discard the "\r". If it
         *          isn't followed by "\n", we replace "\r" with either a "\n"
         *          in text nodes or a space in attribute values.
         *  - "\n": In attribute values, "\n" must be replaced with a space.
         *
         * We could also get unlucky by needing to refill the buffer midway
         * through the text.
         */

        int start = position;
        StringBuilder result = null;

        // if a text section was already started, prefix the start
        if (valueContext == ValueContext.TEXT && text != null) {
            result = new StringBuilder();
            result.append(text);
        }

        while (true) {

            /*
             * Make sure we have at least a single character to read from the
             * buffer. This mutates the buffer, so save the partial result
             * to the slow path string builder first.
             */
            if (position >= limit) {
                if (start < position) {
                    if (result == null) {
                        result = new StringBuilder();
                    }
                    result.append(buffer, start, position - start);
                }
                if (!fillBuffer(1)) {
                    return result != null ? result.toString() : "";
                }
                start = position;
            }

            char c = buffer[position];

            if (c == delimiter
                    || (delimiter == ' ' && (c <= ' ' || c == '>'))
                    || c == '&' && !resolveEntities) {
                break;
            }

            if (c != '\r'
                    && (c != '\n' || valueContext != ValueContext.ATTRIBUTE)
                    && c != '&'
                    && c != '<'
                    && (c != ']' || valueContext != ValueContext.TEXT)
                    && (c != '%' || valueContext != ValueContext.ENTITY_DECLARATION)) {
                isWhitespace &= (c <= ' ');
                position++;
                continue;
            }

            /*
             * We've encountered an unlucky character! Convert from fast
             * path to slow path if we haven't done so already.
             */
            if (result == null) {
                result = new StringBuilder();
            }
            result.append(buffer, start, position - start);

            if (c == '\r') {
                if ((position + 1 < limit || fillBuffer(2)) && buffer[position + 1] == '\n') {
                    position++;
                }
                c = (valueContext == ValueContext.ATTRIBUTE) ? ' ' : '\n';

            } else if (c == '\n') {
                c = ' ';

            } else if (c == '&') {
                isWhitespace = false; // TODO: what if the entity resolves to whitespace?
                readEntity(result, false, throwOnResolveFailure, valueContext);
                start = position;
                continue;

            } else if (c == '<') {
                if (valueContext == ValueContext.ATTRIBUTE) {
                    checkRelaxed("Illegal: \"<\" inside attribute value");
                }
                isWhitespace = false;

            } else if (c == ']') {
                if ((position + 2 < limit || fillBuffer(3))
                        && buffer[position + 1] == ']' && buffer[position + 2] == '>') {
                    checkRelaxed("Illegal: \"]]>\" outside CDATA section");
                }
                isWhitespace = false;

            } else if (c == '%') {
                throw new XmlPullParserException("This parser doesn't support parameter entities",
                        this, null);

            } else {
                throw new AssertionError();
            }

            position++;
            result.append(c);
            start = position;
        }

        if (result == null) {
            return stringPool.get(buffer, start, position - start);
        } else {
            result.append(buffer, start, position - start);
            return result.toString();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.159 -0500", hash_original_method = "3B69F4FA17F01509E096A0868A2528ED", hash_generated_method = "7983357308118E99306B6F7473F200EC")
    
private void read(char expected) throws IOException, XmlPullParserException {
        int c = peekCharacter();
        if (c != expected) {
            checkRelaxed("expected: '" + expected + "' actual: '" + ((char) c) + "'");
        }
        position++;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.162 -0500", hash_original_method = "A7E267F0C0CB0F12A0F03D9AFED00521", hash_generated_method = "1C147730B7E07CDBAF17A59B69323077")
    
private void read(char[] chars) throws IOException, XmlPullParserException {
        if (position + chars.length >= limit && !fillBuffer(chars.length)) {
            checkRelaxed("expected: '" + new String(chars) + "' but was EOF");
            return;
        }

        // TODO: replace with Arrays.equals(buffer, position, delimiter, 0, delimiter.length)
        // when the VM has better method inlining
        for (int i = 0; i < chars.length; i++) {
            if (buffer[position + i] != chars[i]) {
                checkRelaxed("expected: \"" + new String(chars) + "\" but was \""
                        + new String(buffer, position, chars.length) + "...\"");
            }
        }

        position += chars.length;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.165 -0500", hash_original_method = "902B3F7EB34CE06CF1D7162085CB95DC", hash_generated_method = "65FE0444BD3E119179A01824080B1849")
    
private int peekCharacter() throws IOException, XmlPullParserException {
        if (position < limit || fillBuffer(1)) {
            return buffer[position];
        }
        return -1;
    }

    /**
     * Returns true once {@code limit - position >= minimum}. If the data is
     * exhausted before that many characters are available, this returns
     * false.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.168 -0500", hash_original_method = "DC49987172506F0F8D59FF3F96E536A7", hash_generated_method = "EB4B6169024DF08B9241F616BBE870B2")
    
private boolean fillBuffer(int minimum) throws IOException, XmlPullParserException {
        // If we've exhausted the current content source, remove it
        while (nextContentSource != null) {
            if (position < limit) {
                throw new XmlPullParserException("Unbalanced entity!", this, null);
            }
            popContentSource();
            if (limit - position >= minimum) {
                return true;
            }
        }

        // Before clobbering the old characters, update where buffer starts
        for (int i = 0; i < position; i++) {
            if (buffer[i] == '\n') {
                bufferStartLine++;
                bufferStartColumn = 0;
            } else {
                bufferStartColumn++;
            }
        }

        if (bufferCapture != null) {
            bufferCapture.append(buffer, 0, position);
        }

        if (limit != position) {
            limit -= position;
            System.arraycopy(buffer, position, buffer, 0, limit);
        } else {
            limit = 0;
        }

        position = 0;
        int total;
        while ((total = reader.read(buffer, limit, buffer.length - limit)) != -1) {
            limit += total;
            if (limit >= minimum) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an element or attribute name. This is always non-empty for
     * non-relaxed parsers.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.171 -0500", hash_original_method = "35E0733B1286860BF21842013F8FFA5F", hash_generated_method = "74ED8BFECD329202BD9A7991EB86B847")
    
private String readName() throws IOException, XmlPullParserException {
        if (position >= limit && !fillBuffer(1)) {
            checkRelaxed("name expected");
            return "";
        }

        int start = position;
        StringBuilder result = null;

        // read the first character
        char c = buffer[position];
        if ((c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')
                || c == '_'
                || c == ':'
                || c >= '\u00c0' // TODO: check the XML spec
                || relaxed) {
            position++;
        } else {
            checkRelaxed("name expected");
            return "";
        }

        while (true) {
            /*
             * Make sure we have at least a single character to read from the
             * buffer. This mutates the buffer, so save the partial result
             * to the slow path string builder first.
             */
            if (position >= limit) {
                if (result == null) {
                    result = new StringBuilder();
                }
                result.append(buffer, start, position - start);
                if (!fillBuffer(1)) {
                    return result.toString();
                }
                start = position;
            }

            // read another character
            c = buffer[position];
            if ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
                    || c == '_'
                    || c == '-'
                    || c == ':'
                    || c == '.'
                    || c >= '\u00b7') {  // TODO: check the XML spec
                position++;
                continue;
            }

            // we encountered a non-name character. done!
            if (result == null) {
                return stringPool.get(buffer, start, position - start);
            } else {
                result.append(buffer, start, position - start);
                return result.toString();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.174 -0500", hash_original_method = "7FC6A162788F62EDDD44981BAC207FA9", hash_generated_method = "0B4C033899BBF03E352F823A24F064F5")
    
private void skip() throws IOException, XmlPullParserException {
        while (position < limit || fillBuffer(1)) {
            int c = buffer[position];
            if (c > ' ') {
                break;
            }
            position++;
        }
    }

    //  public part starts here...

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.176 -0500", hash_original_method = "46D251D7075E8F175BB5AD72794934F4", hash_generated_method = "FA49D134C1ABF23C14600FE13476AB74")
    
public void setInput(Reader reader) throws XmlPullParserException {
        this.reader = reader;

        type = START_DOCUMENT;
        name = null;
        namespace = null;
        degenerated = false;
        attributeCount = -1;
        encoding = null;
        version = null;
        standalone = null;

        if (reader == null) {
            return;
        }

        position = 0;
        limit = 0;
        bufferStartLine = 0;
        bufferStartColumn = 0;
        depth = 0;
        documentEntities = null;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.181 -0500", hash_original_method = "EE8E194EE4DCB71C2C4B627C026D6CE3", hash_generated_method = "A3A1925DFD4A268A0E852F1DBF58501D")
    
public void setInput(InputStream is, String charset) throws XmlPullParserException {
        position = 0;
        limit = 0;
        boolean detectCharset = (charset == null);

        if (is == null) {
            throw new IllegalArgumentException();
        }

        try {
            if (detectCharset) {
                // read the four bytes looking for an indication of the encoding in use
                int firstFourBytes = 0;
                while (limit < 4) {
                    int i = is.read();
                    if (i == -1) {
                        break;
                    }
                    firstFourBytes = (firstFourBytes << 8) | i;
                    buffer[limit++] = (char) i;
                }

                if (limit == 4) {
                    switch (firstFourBytes) {
                    case 0x00000FEFF: // UTF-32BE BOM
                        charset = "UTF-32BE";
                        limit = 0;
                        break;

                    case 0x0FFFE0000: // UTF-32LE BOM
                        charset = "UTF-32LE";
                        limit = 0;
                        break;

                    case 0x0000003c: // '<' in UTF-32BE
                        charset = "UTF-32BE";
                        buffer[0] = '<';
                        limit = 1;
                        break;

                    case 0x03c000000: // '<' in UTF-32LE
                        charset = "UTF-32LE";
                        buffer[0] = '<';
                        limit = 1;
                        break;

                    case 0x0003c003f: // "<?" in UTF-16BE
                        charset = "UTF-16BE";
                        buffer[0] = '<';
                        buffer[1] = '?';
                        limit = 2;
                        break;

                    case 0x03c003f00: // "<?" in UTF-16LE
                        charset = "UTF-16LE";
                        buffer[0] = '<';
                        buffer[1] = '?';
                        limit = 2;
                        break;

                    case 0x03c3f786d: // "<?xm" in ASCII etc.
                        while (true) {
                            int i = is.read();
                            if (i == -1) {
                                break;
                            }
                            buffer[limit++] = (char) i;
                            if (i == '>') {
                                String s = new String(buffer, 0, limit);
                                int i0 = s.indexOf("encoding");
                                if (i0 != -1) {
                                    while (s.charAt(i0) != '"' && s.charAt(i0) != '\'') {
                                        i0++;
                                    }
                                    char deli = s.charAt(i0++);
                                    int i1 = s.indexOf(deli, i0);
                                    charset = s.substring(i0, i1);
                                }
                                break;
                            }
                        }
                        break;

                    default:
                        // handle a byte order mark followed by something other than <?
                        if ((firstFourBytes & 0x0ffff0000) == 0x0feff0000) {
                            charset = "UTF-16BE";
                            buffer[0] = (char) ((buffer[2] << 8) | buffer[3]);
                            limit = 1;
                        } else if ((firstFourBytes & 0x0ffff0000) == 0x0fffe0000) {
                            charset = "UTF-16LE";
                            buffer[0] = (char) ((buffer[3] << 8) | buffer[2]);
                            limit = 1;
                        } else if ((firstFourBytes & 0x0ffffff00) == 0x0efbbbf00) {
                            charset = "UTF-8";
                            buffer[0] = buffer[3];
                            limit = 1;
                        }
                    }
                }
            }

            if (charset == null) {
                charset = "UTF-8";
            }

            int savedLimit = limit;
            setInput(new InputStreamReader(is, charset));
            encoding = charset;
            limit = savedLimit;

            /*
             * Skip the optional BOM if we didn't above. This decrements limit
             * rather than incrementing position so that <?xml version='1.0'?>
             * is still at character 0.
             */
            if (!detectCharset && peekCharacter() == 0xfeff) {
                limit--;
                System.arraycopy(buffer, 1, buffer, 0, limit);
            }
        } catch (Exception e) {
            throw new XmlPullParserException("Invalid stream or encoding: " + e, this, e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.184 -0500", hash_original_method = "7002CA433E430A52F3D361978C362AC4", hash_generated_method = "EFB48E0DE7AC8A4B85F95E019F6DA799")
    
public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.187 -0500", hash_original_method = "905F7B8816C5E28E92971A4DABCE5B48", hash_generated_method = "85F2E9EF965E89CF8522FD27158FD11D")
    
public boolean getFeature(String feature) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            return processNsp;
        } else if (FEATURE_RELAXED.equals(feature)) {
            return relaxed;
        } else if (FEATURE_PROCESS_DOCDECL.equals(feature)) {
            return processDocDecl;
        } else {
            return false;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.189 -0500", hash_original_method = "A279F06C875438B49B8D4A1047D2C8F6", hash_generated_method = "57ADE80FB57BFBA8F11F2FC5B22E5FA1")
    
public String getInputEncoding() {
        return encoding;
    }
    
    enum ValueContext {
        ATTRIBUTE,
        TEXT,
        ENTITY_DECLARATION
    }
    
    static class ContentSource {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.276 -0500", hash_original_field = "7878977A44FFB1631EDA4764249DB51F", hash_generated_field = "7D21AAFF4A726AE51AF8BEE306E3B202")

        private  ContentSource next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.278 -0500", hash_original_field = "AF37951EAE101F357ACAF48FB7E85D88", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

        private  char[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.280 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

        private  int position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.283 -0500", hash_original_field = "136FDC88CA742E83C109AD31983DA2BF", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

        private  int limit;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.285 -0500", hash_original_method = "BC47C2124096A91C278868E0B05F486C", hash_generated_method = "BC47C2124096A91C278868E0B05F486C")
        
ContentSource(ContentSource next, char[] buffer, int position, int limit) {
            this.next = next;
            this.buffer = buffer;
            this.position = position;
            this.limit = limit;
        }
        
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.191 -0500", hash_original_method = "139FEB1FB1AC644E29BB2080E735DCAB", hash_generated_method = "2C00835AFAC73D063F4EA288159CB6BA")
    
public void defineEntityReplacementText(String entity, String value)
            throws XmlPullParserException {
        if (processDocDecl) {
            throw new IllegalStateException(
                    "Entity replacement text may not be defined with DOCTYPE processing enabled.");
        }
        if (reader == null) {
            throw new IllegalStateException(
                    "Entity replacement text must be defined after setInput()");
        }
        if (documentEntities == null) {
            documentEntities = new HashMap<String, char[]>();
        }
        documentEntities.put(entity, value.toCharArray());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.193 -0500", hash_original_method = "88B98FA49BAB9563CCFD697035E35769", hash_generated_method = "E49DEAEB9FA9B81EEE3BF99D9F216FE2")
    
public Object getProperty(String property) {
        if (property.equals(PROPERTY_XMLDECL_VERSION)) {
            return version;
        } else if (property.equals(PROPERTY_XMLDECL_STANDALONE)) {
            return standalone;
        } else if (property.equals(PROPERTY_LOCATION)) {
            return location != null ? location : reader.toString();
        } else {
            return null;
        }
    }

    /**
     * Returns the root element's name if it was declared in the DTD. This
     * equals the first tag's name for valid documents.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.196 -0500", hash_original_method = "9C3E6BF1FDA5FCF82C61137F91620CE9", hash_generated_method = "024EDB005D677ABCF2E2DA763DA3FD39")
    
public String getRootElementName() {
        return rootElementName;
    }

    /**
     * Returns the document's system ID if it was declared. This is typically a
     * string like {@code http://www.w3.org/TR/html4/strict.dtd}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.198 -0500", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6A03DC8D49FB90AC37FD320CD622E272")
    
public String getSystemId() {
        return systemId;
    }

    /**
     * Returns the document's public ID if it was declared. This is typically a
     * string like {@code -//W3C//DTD HTML 4.01//EN}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.201 -0500", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "C2B64346C205A83C958059FEF62D1E97")
    
public String getPublicId() {
        return publicId;
    }
    static {
        DEFAULT_ENTITIES.put("lt", "<");
        DEFAULT_ENTITIES.put("gt", ">");
        DEFAULT_ENTITIES.put("amp", "&");
        DEFAULT_ENTITIES.put("apos", "'");
        DEFAULT_ENTITIES.put("quot", "\"");
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.203 -0500", hash_original_method = "2B7C16F8E90DF968275251B3375CC301", hash_generated_method = "67B25D573FB355465AF790109A2D87B7")
    
public int getNamespaceCount(int depth) {
        if (depth > this.depth) {
            throw new IndexOutOfBoundsException();
        }
        return nspCounts[depth];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.205 -0500", hash_original_method = "DA805E6BD1FA77EA77FFD933A59A1A79", hash_generated_method = "7A1C07826244CEE911578BBE6371E5EB")
    
public String getNamespacePrefix(int pos) {
        return nspStack[pos * 2];
    }

    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.208 -0500", hash_original_method = "BEA3C6D36DAA76218F10B33482B7D86B", hash_generated_method = "0217D2D0DA38004AF2D520D996962F37")
    
public String getNamespaceUri(int pos) {
        return nspStack[(pos * 2) + 1];
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.051 -0400", hash_original_method = "40F39B6FC2CBEA065A6E595C0C377D56", hash_generated_method = "593F1915C33C9A8D4B05A7F5E44A72AC")
    public String getNamespace(String prefix) {
        addTaint(prefix.getTaint());
        if("xml".equals(prefix))        
        {
String varB42E997512DFFB350471AB44C36A387C_1067348118 =             "http://www.w3.org/XML/1998/namespace";
            varB42E997512DFFB350471AB44C36A387C_1067348118.addTaint(getTaint());
            return varB42E997512DFFB350471AB44C36A387C_1067348118;
        } //End block
        if("xmlns".equals(prefix))        
        {
String var9D449F1D53C2C64B85A7AEF148BB8C58_1902710790 =             "http://www.w3.org/2000/xmlns/";
            var9D449F1D53C2C64B85A7AEF148BB8C58_1902710790.addTaint(getTaint());
            return var9D449F1D53C2C64B85A7AEF148BB8C58_1902710790;
        } //End block
for(int i = (getNamespaceCount(depth) << 1) - 2;i >= 0;i -= 2)
        {
            if(prefix == null)            
            {
                if(nspStack[i] == null)                
                {
String var7C146870E87A0CC7077FCAFD76B21B23_1502014471 =                     nspStack[i + 1];
                    var7C146870E87A0CC7077FCAFD76B21B23_1502014471.addTaint(getTaint());
                    return var7C146870E87A0CC7077FCAFD76B21B23_1502014471;
                } //End block
            } //End block
            else
            if(prefix.equals(nspStack[i]))            
            {
String var7C146870E87A0CC7077FCAFD76B21B23_120227909 =                 nspStack[i + 1];
                var7C146870E87A0CC7077FCAFD76B21B23_120227909.addTaint(getTaint());
                return var7C146870E87A0CC7077FCAFD76B21B23_120227909;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_472639323 =         null;
        var540C13E9E156B687226421B24F2DF178_472639323.addTaint(getTaint());
        return var540C13E9E156B687226421B24F2DF178_472639323;
        // ---------- Original Method ----------
        //if ("xml".equals(prefix)) {
            //return "http://www.w3.org/XML/1998/namespace";
        //}
        //if ("xmlns".equals(prefix)) {
            //return "http://www.w3.org/2000/xmlns/";
        //}
        //for (int i = (getNamespaceCount(depth) << 1) - 2; i >= 0; i -= 2) {
            //if (prefix == null) {
                //if (nspStack[i] == null) {
                    //return nspStack[i + 1];
                //}
            //} else if (prefix.equals(nspStack[i])) {
                //return nspStack[i + 1];
            //}
        //}
        //return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.213 -0500", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "6ED96C446AA91DED02D62E1E51123207")
    
public int getDepth() {
        return depth;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.216 -0500", hash_original_method = "B71BFE480A942DC6AFBA741559BFFBE0", hash_generated_method = "58EDA81DA56F46D7740426BA8118069C")
    
public String getPositionDescription() {
        StringBuilder buf = new StringBuilder(type < TYPES.length ? TYPES[type] : "unknown");
        buf.append(' ');

        if (type == START_TAG || type == END_TAG) {
            if (degenerated) {
                buf.append("(empty) ");
            }
            buf.append('<');
            if (type == END_TAG) {
                buf.append('/');
            }

            if (prefix != null) {
                buf.append("{" + namespace + "}" + prefix + ":");
            }
            buf.append(name);

            int cnt = attributeCount * 4;
            for (int i = 0; i < cnt; i += 4) {
                buf.append(' ');
                if (attributes[i + 1] != null) {
                    buf.append("{" + attributes[i] + "}" + attributes[i + 1] + ":");
                }
                buf.append(attributes[i + 2] + "='" + attributes[i + 3] + "'");
            }

            buf.append('>');
        } else if (type == IGNORABLE_WHITESPACE) {
            ;
        } else if (type != TEXT) {
            buf.append(getText());
        } else if (isWhitespace) {
            buf.append("(whitespace)");
        } else {
            String text = getText();
            if (text.length() > 16) {
                text = text.substring(0, 16) + "...";
            }
            buf.append(text);
        }

        buf.append("@" + getLineNumber() + ":" + getColumnNumber());
        if (location != null) {
            buf.append(" in ");
            buf.append(location);
        } else if (reader != null) {
            buf.append(" in ");
            buf.append(reader.toString());
        }
        return buf.toString();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.218 -0500", hash_original_method = "114340E3BA1FFC2D8A54D30C75AB06FF", hash_generated_method = "32EA0FAC854FD91C4B50C6E5FA193A62")
    
public int getLineNumber() {
        int result = bufferStartLine;
        for (int i = 0; i < position; i++) {
            if (buffer[i] == '\n') {
                result++;
            }
        }
        return result + 1; // the first line is '1'
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.220 -0500", hash_original_method = "C138C40AD0ECD6D56D342D21687BD452", hash_generated_method = "7465A07E38ABFE2787559BBD17C6C936")
    
public int getColumnNumber() {
        int result = bufferStartColumn;
        for (int i = 0; i < position; i++) {
            if (buffer[i] == '\n') {
                result = 0;
            } else {
                result++;
            }
        }
        return result + 1; // the first column is '1'
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.223 -0500", hash_original_method = "152BCFAF579D72B6DEF962950FEC2A17", hash_generated_method = "EA69FD9D415E3FED8312BB6705CABF23")
    
public boolean isWhitespace() throws XmlPullParserException {
        if (type != TEXT && type != IGNORABLE_WHITESPACE && type != CDSECT) {
            throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        }
        return isWhitespace;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.226 -0500", hash_original_method = "96BD4C193A5C47E4BA7EA81CE7C395CC", hash_generated_method = "C53792931294A5CC21BDD3B9161DD2F2")
    
public String getText() {
        if (type < TEXT || (type == ENTITY_REF && unresolved)) {
            return null;
        } else if (text == null) {
            return "";
        } else {
            return text;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.228 -0500", hash_original_method = "17ADAF2C34EC5E5726D60154CDE0E31A", hash_generated_method = "3AA8CAFCB7970AACF61C348539CAFA93")
    
public char[] getTextCharacters(int[] poslen) {
        String text = getText();
        if (text == null) {
            poslen[0] = -1;
            poslen[1] = -1;
            return null;
        }
        char[] result = text.toCharArray();
        poslen[0] = 0;
        poslen[1] = result.length;
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.231 -0500", hash_original_method = "A99E1DDB500E37E7767EA602F963D96D", hash_generated_method = "CB56B42C53FDC85610C72FB3A61ADB7C")
    
public String getNamespace() {
        return namespace;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.233 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.235 -0500", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "BCB543CB7953F72CF1378E75FDF367AA")
    
public String getPrefix() {
        return prefix;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.238 -0500", hash_original_method = "BB5C193EDDCF2188F64023D36680FCC7", hash_generated_method = "C39320A9F9B37AE36D02D68A1CB30293")
    
public boolean isEmptyElementTag() throws XmlPullParserException {
        if (type != START_TAG) {
            throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        }
        return degenerated;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.240 -0500", hash_original_method = "E7902A71CF05159AEACA5707956D2FB0", hash_generated_method = "E6A365002F0379E0689750CB9CFB0978")
    
public int getAttributeCount() {
        return attributeCount;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.242 -0500", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "7C8FF293943A670ABF6F2AFD6D3199E0")
    
public String getAttributeType(int index) {
        return "CDATA";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.244 -0500", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "2FB0D2D586DF51D33C0DF05BD780E580")
    
public boolean isAttributeDefault(int index) {
        return false;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.247 -0500", hash_original_method = "1DC23C46494192E0CB67B725251C6942", hash_generated_method = "8EC224485ADED7CF211328F6F513D985")
    
public String getAttributeNamespace(int index) {
        if (index >= attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[index * 4];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.249 -0500", hash_original_method = "07BD775DFF4E9B04837F88C1E2748FE1", hash_generated_method = "C6B469A11126E1D5DECD96DF798376DF")
    
public String getAttributeName(int index) {
        if (index >= attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[(index * 4) + 2];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.252 -0500", hash_original_method = "C689E94E86EA5FE91ACCD87E01866231", hash_generated_method = "9030EB2C92B4DD500C015F5AC3776ED7")
    
public String getAttributePrefix(int index) {
        if (index >= attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[(index * 4) + 1];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.254 -0500", hash_original_method = "BF5E04E32ADD7672259D8C86F2C8D631", hash_generated_method = "67CA7B9F6BAB7F10786007FEEE676C89")
    
public String getAttributeValue(int index) {
        if (index >= attributeCount) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[(index * 4) + 3];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.257 -0500", hash_original_method = "D0AC7DE2A29C82DADA1B505288DAC27D", hash_generated_method = "949826E1DE9E7C68264D5BF4541C2D24")
    
public String getAttributeValue(String namespace, String name) {
        for (int i = (attributeCount * 4) - 4; i >= 0; i -= 4) {
            if (attributes[i + 2].equals(name)
                    && (namespace == null || attributes[i].equals(namespace))) {
                return attributes[i + 3];
            }
        }

        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.259 -0500", hash_original_method = "0457ED08CBFC1348E0AAA3CE0D692605", hash_generated_method = "83781172F515FE1F816BDB8E8219762C")
    
public int getEventType() throws XmlPullParserException {
        return type;
    }

    // utility methods to make XML parsing easier ...

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.261 -0500", hash_original_method = "53E7D5238284732F8540E3833F26B112", hash_generated_method = "1A5B98DC07E8EADF1AC27E38A9D00E81")
    
public int nextTag() throws XmlPullParserException, IOException {
        next();
        if (type == TEXT && isWhitespace) {
            next();
        }

        if (type != END_TAG && type != START_TAG) {
            throw new XmlPullParserException("unexpected type", this, null);
        }

        return type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.264 -0500", hash_original_method = "C4BF1BB4C255F6013F5858579D851AD3", hash_generated_method = "1B44603BD22C31009DEBFDBD857DA01B")
    
public void require(int type, String namespace, String name)
            throws XmlPullParserException, IOException {
        if (type != this.type
                || (namespace != null && !namespace.equals(getNamespace()))
                || (name != null && !name.equals(getName()))) {
            throw new XmlPullParserException(
                    "expected: " + TYPES[type] + " {" + namespace + "}" + name, this, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.267 -0500", hash_original_method = "102A6610D1A439DBBB62D3798FEF6670", hash_generated_method = "F61032EE80EBB645A26A2DA6ADCAF3D2")
    
public String nextText() throws XmlPullParserException, IOException {
        if (type != START_TAG) {
            throw new XmlPullParserException("precondition: START_TAG", this, null);
        }

        next();

        String result;
        if (type == TEXT) {
            result = getText();
            next();
        } else {
            result = "";
        }

        if (type != END_TAG) {
            throw new XmlPullParserException("END_TAG expected", this, null);
        }

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.269 -0500", hash_original_method = "DD2B8D14469BF5F6853E930DFF62942D", hash_generated_method = "8E9237256326E2AE27DDD9F8D98B6C00")
    
public void setFeature(String feature, boolean value) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            processNsp = value;
        } else if (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(feature)) {
            processDocDecl = value;
        } else if (FEATURE_RELAXED.equals(feature)) {
            relaxed = value;
        } else {
            throw new XmlPullParserException("unsupported feature: " + feature, this, null);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.272 -0500", hash_original_method = "BB78C28304FA5EA99DAD361D5123F3A6", hash_generated_method = "EDDB40FDA61D6E06E84F7B6D343EDE8A")
    
public void setProperty(String property, Object value) throws XmlPullParserException {
        if (property.equals(PROPERTY_LOCATION)) {
            location = String.valueOf(value);
        } else {
            throw new XmlPullParserException("unsupported property: " + property);
        }
    }

    /**
     * Prepends the characters of {@code newBuffer} to be read before the
     * current buffer.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.289 -0500", hash_original_method = "8F280A3CDA5A3533C9FB5C99B2A6A6C2", hash_generated_method = "C04E22E18A3AA541ECF2FD023C8DCC27")
    
private void pushContentSource(char[] newBuffer) {
        nextContentSource = new ContentSource(nextContentSource, buffer, position, limit);
        buffer = newBuffer;
        position = 0;
        limit = newBuffer.length;
    }

    /**
     * Replaces the current exhausted buffer with the next buffer in the chain.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:09.292 -0500", hash_original_method = "E5A180E871F653CC9F75C9B7A9F73687", hash_generated_method = "E9ECC5A4FCBE9E8D108B5888B61B27A2")
    
private void popContentSource() {
        buffer = nextContentSource.buffer;
        position = nextContentSource.position;
        limit = nextContentSource.limit;
        nextContentSource = nextContentSource.next;
    }
}

