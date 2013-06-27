package org.kxml2.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "D5189DE027922F81005951E6EFE0EFD5", hash_generated_field = "CE74502D5DD419367E637D11E946AE48")

    private String location;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "B9C33225233D273951C807AA4A997C84")

    private String version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "083A7D1EBF6F499AF0C1B1BB489B4941", hash_generated_field = "F545B366D95421A9D0545B064DF3FA15")

    private Boolean standalone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "DFC84309889AC09133BB4E87BE34F708", hash_generated_field = "22BD78252C1771E229BD8814989F89D7")

    private String rootElementName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "61D7C74417362A394394F7DA60F28955", hash_generated_field = "6545B566A550C532A7353AE3BD57F4A5")

    private boolean processDocDecl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "09024CE37019EE47CD92BC3C6111FC3E", hash_generated_field = "769EB7E2763BBF503944F860A1BF2B53")

    private boolean processNsp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "81F32BE24A2A62FC472CC43EDC97E65B", hash_generated_field = "56D1CD4D0FE519DF4F93CCF1C262BFDF")

    private boolean relaxed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "C97F5F3194C1ED85A46851DB7EBD742D", hash_generated_field = "7273BF2007F6D9DA572D2E585776EE5B")

    private boolean keepNamespaceAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "B8BE629C2D9B6F6F9BBC8E2DF0B8DFE2", hash_generated_field = "7C254A9FE7EB03488648DE590A70B1E8")

    private StringBuilder bufferCapture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "22CADEBBDFDF70204FCDA053244BDAB4", hash_generated_field = "5EE5BD02D72D06CAAF4EF8E2D19E1135")

    private Map<String, char[]> documentEntities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "62676B93D1C3D8404C9C812ADC5F1C3A", hash_generated_field = "E290D91FC5BAFD29B00A44E1145FC9FB")

    private Map<String, Map<String, String>> defaultAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.819 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "55B1FBA4550114B730EDDC57888D99A6", hash_generated_field = "C38C16C38A66AC817AFDEB16F3AB2C79")

    private String[] elementStack = new String[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "74016F2E2E7F384872DF74677FF1C217", hash_generated_field = "9D1B39E20FB88BB665BD0F6B05D41FA2")

    private String[] nspStack = new String[8];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "59CAFBB511BF3C5D3EDE905B12C326C7", hash_generated_field = "167B18033DE59DDC6FAA031548884DC7")

    private int[] nspCounts = new int[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private Reader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "5AEFC22A591C854AAB5F4A44DD63608F", hash_generated_field = "B7F81B9E6E384492F57E569C80E0DE3A")

    private ContentSource nextContentSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "C7730CCE178204102E6E99312BA48AE2", hash_generated_field = "577EC909B068680E25766CC68FC4E0C4")

    private char[] buffer = new char[8192];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

    private int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "8D564E87D9CDB569F6C0D82D1566729D", hash_generated_field = "00F405BC8E12348750DA51A45F66E092")

    private int limit = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "197691A1D824E6BF0A4FDB37CD42DFBF", hash_generated_field = "ABCC56A72A2BAE75E77EB925AA857BA4")

    private int bufferStartLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "77D3912721282C90863775372B432626", hash_generated_field = "322559720B3F732E76842B5632DA7E78")

    private int bufferStartColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "FDBE2C32DE81904D31506233605042C8", hash_generated_field = "002F5A5E90D73E291F33E6C6294E8D20")

    private boolean isWhitespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "89801E9E98979062E84647433A8ED3E9", hash_generated_field = "E3760D072DB711CCBCD48E45C2700E12")

    private String namespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "41E5137359BCC159984E1D58F1F76D16", hash_generated_field = "DBB8A6C14E3796CA3A469826B313EF12")

    private boolean degenerated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "BB16AB716A8B7609C0ECC6FB65BADCBC", hash_generated_field = "269E5A2AA1CB94A01698B537489DA5D4")

    private int attributeCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "DD7CEF9E81CAE57B34B30FA66B74E598", hash_generated_field = "569C94B11664DECEEFD3830A5970E18C")

    private String[] attributes = new String[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "5A2A9A2BD7181810539A763573C1D6FB")

    private String error;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "8B371F13D7DE4300703DDB9173F6E8E6", hash_generated_field = "3CE0322C00553A852949CE941813EC46")

    private boolean unresolved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_field = "5D197505CD7E19C50091B8A2B5C9E1D2", hash_generated_field = "D8AE365EBB0770870B307A3669CA40C2")

    public StringPool stringPool = new StringPool();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.820 -0400", hash_original_method = "010DAC0EB3331EDC25D05B4FF02298A9", hash_generated_method = "010DAC0EB3331EDC25D05B4FF02298A9")
    public KXmlParser ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.821 -0400", hash_original_method = "A527DEDBB8977F1D947B829D15DAACC5", hash_generated_method = "1634D7B912087B274B9C21F12413F3E3")
    public void keepNamespaceAttributes() {
        this.keepNamespaceAttributes = true;
        // ---------- Original Method ----------
        //this.keepNamespaceAttributes = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.823 -0400", hash_original_method = "F08928441827C23946744248151D18D9", hash_generated_method = "E57A1DD4407AA7ECBF3F2C4651CF01DA")
    private boolean adjustNsp() throws XmlPullParserException {
        boolean any;
        any = false;
        {
            int i;
            i = 0;
            i += 4;
            {
                String attrName;
                attrName = attributes[i + 2];
                int cut;
                cut = attrName.indexOf(':');
                String prefix;
                {
                    prefix = attrName.substring(0, cut);
                    attrName = attrName.substring(cut + 1);
                } //End block
                {
                    boolean varE8E99AA812A31FBE0E19EAB21AA5408E_525688689 = (attrName.equals("xmlns"));
                    {
                        prefix = attrName;
                        attrName = null;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var946560EAC9A71101396E7CF7B5CB85AE_1928611281 = (!prefix.equals("xmlns"));
                    {
                        any = true;
                    } //End block
                    {
                        int j;
                        j = (nspCounts[depth]++) << 1;
                        nspStack = ensureCapacity(nspStack, j + 2);
                        nspStack[j] = attrName;
                        nspStack[j + 1] = attributes[i + 3];
                        {
                            boolean varB788F9FC33ABF51F2A4A741D8D605EA1_758214271 = (attrName != null && attributes[i + 3].isEmpty());
                            {
                                checkRelaxed("illegal empty namespace");
                            } //End block
                        } //End collapsed parenthetic
                        {
                            attributes[i] = "http://www.w3.org/2000/xmlns/";
                            any = true;
                        } //End block
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
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                int i;
                i = (attributeCount << 2) - 4;
                i -= 4;
                {
                    String attrName;
                    attrName = attributes[i + 2];
                    int cut;
                    cut = attrName.indexOf(':');
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "illegal attribute name: " + attrName + " at " + this);
                    } //End block
                    {
                        String attrPrefix;
                        attrPrefix = attrName.substring(0, cut);
                        attrName = attrName.substring(cut + 1);
                        String attrNs;
                        attrNs = getNamespace(attrPrefix);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Undefined Prefix: " + attrPrefix + " in " + this);
                        } //End block
                        attributes[i] = attrNs;
                        attributes[i + 1] = attrPrefix;
                        attributes[i + 2] = attrName;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        int cut;
        cut = name.indexOf(':');
        {
            checkRelaxed("illegal tag name: " + name);
        } //End block
        {
            prefix = name.substring(0, cut);
            name = name.substring(cut + 1);
        } //End block
        this.namespace = getNamespace(prefix);
        {
            {
                checkRelaxed("undefined prefix: " + prefix);
            } //End block
            this.namespace = NO_NAMESPACE;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226989986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226989986;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.824 -0400", hash_original_method = "49B8B44C0E7574021385F3D8BD03186C", hash_generated_method = "E3B64890939626E5F50F880104112BB7")
    private String[] ensureCapacity(String[] arr, int required) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1033322849 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1174341855 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1033322849 = arr;
        } //End block
        String[] bigger;
        bigger = new String[required + 16];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
        varB4EAC82CA7396A68D541C85D26508E83_1174341855 = bigger;
        addTaint(arr[0].getTaint());
        addTaint(required);
        String[] varA7E53CE21691AB073D9660D615818899_1598577080; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1598577080 = varB4EAC82CA7396A68D541C85D26508E83_1033322849;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1598577080 = varB4EAC82CA7396A68D541C85D26508E83_1174341855;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1598577080.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1598577080;
        // ---------- Original Method ----------
        //if (arr.length >= required) {
            //return arr;
        //}
        //String[] bigger = new String[required + 16];
        //System.arraycopy(arr, 0, bigger, 0, arr.length);
        //return bigger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.824 -0400", hash_original_method = "4A7BCCF6DFE9CB9D8E85D47BF7F54B1D", hash_generated_method = "9397C0C707F50F637448195E17EE2480")
    private void checkRelaxed(String errorMessage) throws XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(errorMessage, this, null);
        } //End block
        {
            error = "Error: " + errorMessage;
        } //End block
        // ---------- Original Method ----------
        //if (!relaxed) {
            //throw new XmlPullParserException(errorMessage, this, null);
        //}
        //if (error == null) {
            //error = "Error: " + errorMessage;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.824 -0400", hash_original_method = "76E82C4E283B430F3EE1381EBB2709F7", hash_generated_method = "E3126A5651DEF19539EF6DEDC67AEDB9")
    public int next() throws XmlPullParserException, IOException {
        int var7CB2833143510FA64D55226A9FF36AA2_1182439538 = (next(false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510217957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510217957;
        // ---------- Original Method ----------
        //return next(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.825 -0400", hash_original_method = "B3A65F7F837C14F73BB928D8BDFE9D91", hash_generated_method = "FA1A7CD7DFDF67C05D42CB927F6654C2")
    public int nextToken() throws XmlPullParserException, IOException {
        int var217D6B4D8CC59251F9E88B712D4C8A6D_1060713559 = (next(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617196857 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617196857;
        // ---------- Original Method ----------
        //return next(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.899 -0400", hash_original_method = "55251A1079E5B9F4E3B9F053CFE6FD44", hash_generated_method = "E74633D6C0AF08974226C46C2E6608DC")
    private int next(boolean justOneToken) throws IOException, XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() must be called first.", this, null);
        } //End block
        {
            degenerated = false;
            type = END_TAG;
        } //End block
        {
            {
                text = error;
                type = COMMENT;
                error = null;
            } //End block
            {
                error = null;
            } //End block
        } //End block
        type = peekType(false);
        {
            readXmlDeclaration();
            type = peekType(false);
        } //End block
        text = null;
        isWhitespace = true;
        prefix = null;
        name = null;
        namespace = null;
        attributeCount = -1;
        boolean throwOnResolveFailure;
        throwOnResolveFailure = !justOneToken;
        {
            //Begin case START_TAG 
            parseStartTag(false, throwOnResolveFailure);
            //End case START_TAG 
            //Begin case END_TAG 
            readEndTag();
            //End case END_TAG 
            //Begin case ENTITY_REF 
            {
                StringBuilder entityTextBuilder;
                entityTextBuilder = new StringBuilder();
                readEntity(entityTextBuilder, true, throwOnResolveFailure, ValueContext.TEXT);
                text = entityTextBuilder.toString();
            } //End block
            //End case ENTITY_REF 
            //Begin case TEXT 
            text = readValue('<', !justOneToken, throwOnResolveFailure, ValueContext.TEXT);
            //End case TEXT 
            //Begin case TEXT 
            {
                type = IGNORABLE_WHITESPACE;
            } //End block
            //End case TEXT 
            //Begin case CDSECT 
            read(START_CDATA);
            //End case CDSECT 
            //Begin case CDSECT 
            text = readUntil(END_CDATA, true);
            //End case CDSECT 
            //Begin case COMMENT 
            String commentText;
            commentText = readComment(justOneToken);
            //End case COMMENT 
            //Begin case COMMENT 
            {
                text = commentText;
            } //End block
            //End case COMMENT 
            //Begin case PROCESSING_INSTRUCTION 
            read(START_PROCESSING_INSTRUCTION);
            //End case PROCESSING_INSTRUCTION 
            //Begin case PROCESSING_INSTRUCTION 
            String processingInstruction;
            processingInstruction = readUntil(END_PROCESSING_INSTRUCTION, justOneToken);
            //End case PROCESSING_INSTRUCTION 
            //Begin case PROCESSING_INSTRUCTION 
            {
                text = processingInstruction;
            } //End block
            //End case PROCESSING_INSTRUCTION 
            //Begin case DOCDECL 
            readDoctype(justOneToken);
            //End case DOCDECL 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unexpected token", this, null);
            //End case default 
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unexpected token", this, null);
            } //End block
            {
                text = null;
            } //End block
            int peek;
            peek = peekType(false);
            {
                boolean varFA88C9D54C78329BBC9730AF33B2F91B_153148878 = (text != null && !text.isEmpty() && peek < TEXT);
                {
                    type = TEXT;
                } //End block
            } //End collapsed parenthetic
            type = peek;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613252610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613252610;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.902 -0400", hash_original_method = "C492543C28BFA45A4A603454FE30EBBB", hash_generated_method = "BA9FB51A68A1BA17621F289671EBEF87")
    private String readUntil(char[] delimiter, boolean returnText) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_22057823 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_821263228 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_461225220 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1274152811 = null; //Variable for return #4
        int start;
        start = position;
        StringBuilder result;
        result = null;
        {
            result = new StringBuilder();
            result.append(text);
        } //End block
        {
            {
                {
                    {
                        result = new StringBuilder();
                    } //End block
                    result.append(buffer, start, position - start);
                } //End block
                {
                    boolean var6A57E9353FD53082715EEF7D5328480F_1435444050 = (!fillBuffer(delimiter.length));
                    {
                        checkRelaxed(UNEXPECTED_EOF);
                        type = COMMENT;
                        varB4EAC82CA7396A68D541C85D26508E83_22057823 = null;
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        int end;
        end = position;
        position += delimiter.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_821263228 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_461225220 = stringPool.get(buffer, start, end - start);
        } //End block
        {
            result.append(buffer, start, end - start);
            varB4EAC82CA7396A68D541C85D26508E83_1274152811 = result.toString();
        } //End block
        addTaint(returnText);
        String varA7E53CE21691AB073D9660D615818899_1340403075; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1340403075 = varB4EAC82CA7396A68D541C85D26508E83_22057823;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1340403075 = varB4EAC82CA7396A68D541C85D26508E83_821263228;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1340403075 = varB4EAC82CA7396A68D541C85D26508E83_461225220;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1340403075 = varB4EAC82CA7396A68D541C85D26508E83_1274152811;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1340403075.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1340403075;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.903 -0400", hash_original_method = "79737DD70253BC976180BA8757B427A8", hash_generated_method = "4B3159486694DFC9F9EC8A667BE98271")
    private void readXmlDeclaration() throws IOException, XmlPullParserException {
        {
            checkRelaxed("processing instructions must not start with xml");
        } //End block
        read(START_PROCESSING_INSTRUCTION);
        parseStartTag(true, true);
        {
            boolean var581268841B2EE653D75D3B9B477E8682_1286125782 = (attributeCount < 1 || !"version".equals(attributes[2]));
            {
                checkRelaxed("version expected");
            } //End block
        } //End collapsed parenthetic
        version = attributes[3];
        int pos;
        pos = 1;
        {
            boolean var61BDCB47DC4581E06BB552238A25D6ED_825996953 = (pos < attributeCount && "encoding".equals(attributes[2 + 4]));
            {
                encoding = attributes[3 + 4];
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4D353DE97B84BC869440DBFEAB2495D7_2049586166 = (pos < attributeCount && "standalone".equals(attributes[4 * pos + 2]));
            {
                String st;
                st = attributes[3 + 4 * pos];
                {
                    boolean varFE7CCC805D774FAAB9193F9EB670EDC7_1800887192 = ("yes".equals(st));
                    {
                        standalone = Boolean.TRUE;
                    } //End block
                    {
                        boolean varFB2DD01E2CB481BE2D08953AF4F2267B_1724699116 = ("no".equals(st));
                        {
                            standalone = Boolean.FALSE;
                        } //End block
                        {
                            checkRelaxed("illegal standalone value: " + st);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            checkRelaxed("unexpected attributes in XML declaration");
        } //End block
        isWhitespace = true;
        text = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.905 -0400", hash_original_method = "15C58CE8BC29A2518B63BEC83A754E2C", hash_generated_method = "596164F0A509DAC0AD97B06A4258249E")
    private String readComment(boolean returnText) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_619430593 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1506193176 = null; //Variable for return #2
        read(START_COMMENT);
        {
            varB4EAC82CA7396A68D541C85D26508E83_619430593 = readUntil(END_COMMENT, returnText);
        } //End block
        String commentText;
        commentText = readUntil(COMMENT_DOUBLE_DASH, returnText);
        {
            boolean varDEDEA312818AD0583FC7EE9661E09825_1407827238 = (peekCharacter() != '>');
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Comments may not contain --", this, null);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1506193176 = commentText;
        addTaint(returnText);
        String varA7E53CE21691AB073D9660D615818899_248240180; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_248240180 = varB4EAC82CA7396A68D541C85D26508E83_619430593;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_248240180 = varB4EAC82CA7396A68D541C85D26508E83_1506193176;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_248240180.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_248240180;
        // ---------- Original Method ----------
        //read(START_COMMENT);
        //if (relaxed) {
            //return readUntil(END_COMMENT, returnText);
        //}
        //String commentText = readUntil(COMMENT_DOUBLE_DASH, returnText);
        //if (peekCharacter() != '>') {
            //throw new XmlPullParserException("Comments may not contain --", this, null);
        //}
        //position++;
        //return commentText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.906 -0400", hash_original_method = "39B79927E64E599404174E0314CB7C82", hash_generated_method = "86047347C386878AF41BB651615F438E")
    private void readDoctype(boolean saveDtdText) throws IOException, XmlPullParserException {
        read(START_DOCTYPE);
        int startPosition;
        startPosition = -1;
        {
            bufferCapture = new StringBuilder();
            startPosition = position;
        } //End block
        try 
        {
            skip();
            rootElementName = readName();
            readExternalId(true, true);
            skip();
            {
                boolean varF62C1FC69328E5AC0EE954FE80231020_1933409778 = (peekCharacter() == '[');
                {
                    readInternalSubset();
                } //End block
            } //End collapsed parenthetic
            skip();
        } //End block
        finally 
        {
            {
                bufferCapture.append(buffer, 0, position);
                bufferCapture.delete(0, startPosition);
                text = bufferCapture.toString();
                bufferCapture = null;
            } //End block
        } //End block
        read('>');
        addTaint(saveDtdText);
        // ---------- Original Method ----------
        //read(START_DOCTYPE);
        //int startPosition = -1;
        //if (saveDtdText) {
            //bufferCapture = new StringBuilder();
            //startPosition = position;
        //}
        //try {
            //skip();
            //rootElementName = readName();
            //readExternalId(true, true);
            //skip();
            //if (peekCharacter() == '[') {
                //readInternalSubset();
            //}
            //skip();
        //} finally {
            //if (saveDtdText) {
                //bufferCapture.append(buffer, 0, position);
                //bufferCapture.delete(0, startPosition);
                //text = bufferCapture.toString();
                //bufferCapture = null;
            //}
        //}
        //read('>');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.907 -0400", hash_original_method = "5A46FF78EB6898EF0CABAC45E530C34E", hash_generated_method = "9770A231221E8DB6D3089F82998DC94D")
    private boolean readExternalId(boolean requireSystemName, boolean assignFields) throws IOException, XmlPullParserException {
        skip();
        int c;
        c = peekCharacter();
        {
            read(SYSTEM);
        } //End block
        {
            read(PUBLIC);
            skip();
            {
                publicId = readQuotedId(true);
            } //End block
            {
                readQuotedId(false);
            } //End block
        } //End block
        skip();
        {
            int delimiter;
            delimiter = peekCharacter();
        } //End block
        {
            systemId = readQuotedId(true);
        } //End block
        {
            readQuotedId(false);
        } //End block
        addTaint(requireSystemName);
        addTaint(assignFields);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_609171279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_609171279;
        // ---------- Original Method ----------
        //skip();
        //int c = peekCharacter();
        //if (c == 'S') {
            //read(SYSTEM);
        //} else if (c == 'P') {
            //read(PUBLIC);
            //skip();
            //if (assignFields) {
                //publicId = readQuotedId(true);
            //} else {
                //readQuotedId(false);
            //}
        //} else {
            //return false;
        //}
        //skip();
        //if (!requireSystemName) {
            //int delimiter = peekCharacter();
            //if (delimiter != '"' && delimiter != '\'') {
                //return true; 
            //}
        //}
        //if (assignFields) {
            //systemId = readQuotedId(true);
        //} else {
            //readQuotedId(false);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.908 -0400", hash_original_method = "4B3A97D73E48F79754EA5A86D4C2409D", hash_generated_method = "6E4944C03D9122EBF1C5B7DACD1BA811")
    private String readQuotedId(boolean returnText) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_1022370346 = null; //Variable for return #1
        int quote;
        quote = peekCharacter();
        char[] delimiter;
        {
            delimiter = DOUBLE_QUOTE;
        } //End block
        {
            delimiter = SINGLE_QUOTE;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Expected a quoted string", this, null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1022370346 = readUntil(delimiter, returnText);
        addTaint(returnText);
        varB4EAC82CA7396A68D541C85D26508E83_1022370346.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1022370346;
        // ---------- Original Method ----------
        //int quote = peekCharacter();
        //char[] delimiter;
        //if (quote == '"') {
            //delimiter = DOUBLE_QUOTE;
        //} else if (quote == '\'') {
            //delimiter = SINGLE_QUOTE;
        //} else {
            //throw new XmlPullParserException("Expected a quoted string", this, null);
        //}
        //position++;
        //return readUntil(delimiter, returnText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.912 -0400", hash_original_method = "065EAF2A999BF53AAEE6E5D55221F190", hash_generated_method = "2C4A13E3DCBA16A09E5A12EE5AEC6020")
    private void readInternalSubset() throws IOException, XmlPullParserException {
        read('[');
        {
            skip();
            {
                boolean var6B07AFB8162EBC207136B3E0CBF1DCA1_339850585 = (peekCharacter() == ']');
            } //End collapsed parenthetic
            int declarationType;
            declarationType = peekType(true);
            //Begin case ELEMENTDECL 
            readElementDeclaration();
            //End case ELEMENTDECL 
            //Begin case ATTLISTDECL 
            readAttributeListDeclaration();
            //End case ATTLISTDECL 
            //Begin case ENTITYDECL 
            readEntityDeclaration();
            //End case ENTITYDECL 
            //Begin case NOTATIONDECL 
            readNotationDeclaration();
            //End case NOTATIONDECL 
            //Begin case PROCESSING_INSTRUCTION 
            read(START_PROCESSING_INSTRUCTION);
            //End case PROCESSING_INSTRUCTION 
            //Begin case PROCESSING_INSTRUCTION 
            readUntil(END_PROCESSING_INSTRUCTION, false);
            //End case PROCESSING_INSTRUCTION 
            //Begin case COMMENT 
            readComment(false);
            //End case COMMENT 
            //Begin case PARAMETER_ENTITY_REF 
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Parameter entity references are not supported", this, null);
            //End case PARAMETER_ENTITY_REF 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unexpected token", this, null);
            //End case default 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.912 -0400", hash_original_method = "E2914311E18C41738022F5D7A73FEC8A", hash_generated_method = "B007A3013AF59F7ED63C93EACA164CDF")
    private void readElementDeclaration() throws IOException, XmlPullParserException {
        read(START_ELEMENT);
        skip();
        readName();
        readContentSpec();
        skip();
        read('>');
        // ---------- Original Method ----------
        //read(START_ELEMENT);
        //skip();
        //readName();
        //readContentSpec();
        //skip();
        //read('>');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.921 -0400", hash_original_method = "A45115A32F8DEBE95546FC38EF8925EC", hash_generated_method = "329BE952B9C4399B0E2EB1C72B2324A3")
    private void readContentSpec() throws IOException, XmlPullParserException {
        skip();
        int c;
        c = peekCharacter();
        {
            int depth;
            depth = 0;
            {
                c = peekCharacter();
            } //End block
        } //End block
        {
            read(EMPTY);
        } //End block
        {
            read(ANY);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Expected element content spec", this, null);
        } //End block
        // ---------- Original Method ----------
        //skip();
        //int c = peekCharacter();
        //if (c == '(') {
            //int depth = 0;
            //do {
                //if (c == '(') {
                    //depth++;
                //} else if (c == ')') {
                    //depth--;
                //}
                //position++;
                //c = peekCharacter();
            //} while (depth > 0);
            //if (c == '*' || c == '?' || c == '+') {
                //position++;
            //}
        //} else if (c == EMPTY[0]) {
            //read(EMPTY);
        //} else if (c == ANY[0]) {
            //read(ANY);
        //} else {
            //throw new XmlPullParserException("Expected element content spec", this, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.925 -0400", hash_original_method = "04CF7BEB7F762D6DB023733A3E9A3C83", hash_generated_method = "1278414097B9A1E836DCE4C4A3295CCC")
    private void readAttributeListDeclaration() throws IOException, XmlPullParserException {
        read(START_ATTLIST);
        skip();
        String elementName;
        elementName = readName();
        {
            skip();
            int c;
            c = peekCharacter();
            String attributeName;
            attributeName = readName();
            skip();
            {
                boolean var3C74D199C82A09DCA88FADF6B9606194_1240517021 = (position + 1 >= limit && !fillBuffer(2));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Malformed attribute list", this, null);
                } //End block
            } //End collapsed parenthetic
            {
                read(NOTATION);
                skip();
            } //End block
            c = peekCharacter();
            {
                {
                    skip();
                    readName();
                    skip();
                    c = peekCharacter();
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Malformed attribute type", this, null);
                    } //End block
                } //End block
            } //End block
            {
                readName();
            } //End block
            skip();
            c = peekCharacter();
            {
                c = peekCharacter();
                {
                    read(REQUIRED);
                } //End block
                {
                    read(IMPLIED);
                } //End block
                {
                    read(FIXED);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Malformed attribute type", this, null);
                } //End block
                skip();
                c = peekCharacter();
            } //End block
            {
                String value;
                value = readValue((char) c, true, true, ValueContext.ATTRIBUTE);
                defineAttributeDefault(elementName, attributeName, value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.927 -0400", hash_original_method = "CFB39B3ED48D8CD145E96E2E6FC1A186", hash_generated_method = "774641BBB3F90DFA31D64EFA6E53F4A4")
    private void defineAttributeDefault(String elementName, String attributeName, String value) {
        {
            defaultAttributes = new HashMap<String, Map<String, String>>();
        } //End block
        Map<String, String> elementAttributes;
        elementAttributes = defaultAttributes.get(elementName);
        {
            elementAttributes = new HashMap<String, String>();
            defaultAttributes.put(elementName, elementAttributes);
        } //End block
        elementAttributes.put(attributeName, value);
        addTaint(elementName.getTaint());
        addTaint(attributeName.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (defaultAttributes == null) {
            //defaultAttributes = new HashMap<String, Map<String, String>>();
        //}
        //Map<String, String> elementAttributes = defaultAttributes.get(elementName);
        //if (elementAttributes == null) {
            //elementAttributes = new HashMap<String, String>();
            //defaultAttributes.put(elementName, elementAttributes);
        //}
        //elementAttributes.put(attributeName, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.928 -0400", hash_original_method = "3ECF3BA7E150644C3EFC98E620B12B73", hash_generated_method = "39AC7DBA996B455D90ECC1067C42D839")
    private void readEntityDeclaration() throws IOException, XmlPullParserException {
        read(START_ENTITY);
        boolean generalEntity;
        generalEntity = true;
        skip();
        {
            boolean varA3E57F3EA9CA6DD721B84564E023B708_1328958330 = (peekCharacter() == '%');
            {
                generalEntity = false;
                skip();
            } //End block
        } //End collapsed parenthetic
        String name;
        name = readName();
        skip();
        int quote;
        quote = peekCharacter();
        String entityValue;
        {
            entityValue = readValue((char) quote, true, false, ValueContext.ENTITY_DECLARATION);
        } //End block
        {
            boolean var62304E14A0621CCB5A3B27C088EC2811_211350811 = (readExternalId(true, false));
            {
                entityValue = "";
                skip();
                {
                    boolean varB155190189F97133258877F1A9544A2B_2141046896 = (peekCharacter() == NDATA[0]);
                    {
                        read(NDATA);
                        skip();
                        readName();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Expected entity value or external ID", this, null);
            } //End block
        } //End collapsed parenthetic
        {
            {
                documentEntities = new HashMap<String, char[]>();
            } //End block
            documentEntities.put(name, entityValue.toCharArray());
        } //End block
        skip();
        read('>');
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.929 -0400", hash_original_method = "0A96EF478D2162A2E48AFFA05F705C17", hash_generated_method = "A67C40612518FB92A324059D08A69C05")
    private void readNotationDeclaration() throws IOException, XmlPullParserException {
        read(START_NOTATION);
        skip();
        readName();
        {
            boolean var54889F641C80FD666AF09F21AFB2466E_371858460 = (!readExternalId(false, false));
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "Expected external ID or public ID for notation", this, null);
            } //End block
        } //End collapsed parenthetic
        skip();
        read('>');
        // ---------- Original Method ----------
        //read(START_NOTATION);
        //skip();
        //readName();
        //if (!readExternalId(false, false)) {
            //throw new XmlPullParserException(
                    //"Expected external ID or public ID for notation", this, null);
        //}
        //skip();
        //read('>');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.931 -0400", hash_original_method = "8099A7EBC5B0B16E684058778DE6A29B", hash_generated_method = "887BFB4FEA4D81A5C321283168AA7B4C")
    private void readEndTag() throws IOException, XmlPullParserException {
        read('<');
        read('/');
        name = readName();
        skip();
        read('>');
        int sp;
        sp = (depth - 1) * 4;
        {
            checkRelaxed("read end tag " + name + " with no tags open");
            type = COMMENT;
        } //End block
        {
            boolean var8E76959AB88DB3EF43C8D0E037D778E4_1617884395 = (name.equals(elementStack[sp + 3]));
            {
                namespace = elementStack[sp];
                prefix = elementStack[sp + 1];
                name = elementStack[sp + 2];
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "expected: /" + elementStack[sp + 3] + " read: " + name, this, null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //read('<');
        //read('/');
        //name = readName();
        //skip();
        //read('>');
        //int sp = (depth - 1) * 4;
        //if (depth == 0) {
            //checkRelaxed("read end tag " + name + " with no tags open");
            //type = COMMENT;
            //return;
        //}
        //if (name.equals(elementStack[sp + 3])) {
            //namespace = elementStack[sp];
            //prefix = elementStack[sp + 1];
            //name = elementStack[sp + 2];
        //} else if (!relaxed) {
            //throw new XmlPullParserException(
                    //"expected: /" + elementStack[sp + 3] + " read: " + name, this, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.934 -0400", hash_original_method = "06A44958C70A8BD5DE7481C49C8C3731", hash_generated_method = "CECE6CB4DE2390DC8A08750BCFD2DEE8")
    private int peekType(boolean inDeclaration) throws IOException, XmlPullParserException {
        {
            boolean var5AB75DCE4678778E9ADB41C89957E4BF_1335669365 = (position >= limit && !fillBuffer(1));
        } //End collapsed parenthetic
        //Begin case '<' 
        {
            boolean var30933827E7DDA57720354AD908DB062A_1475513452 = (position + 3 >= limit && !fillBuffer(4));
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Dangling <", this, null);
            } //End block
        } //End collapsed parenthetic
        //End case '<' 
        //Begin case '<' 
        //Begin case '?' 
        {
            boolean var00D7AD3906D2C618F2C2332E5E32D79F_419502070 = ((position + 5 < limit || fillBuffer(6))
                        && (buffer[position + 2] == 'x' || buffer[position + 2] == 'X')
                        && (buffer[position + 3] == 'm' || buffer[position + 3] == 'M')
                        && (buffer[position + 4] == 'l' || buffer[position + 4] == 'L')
                        && (buffer[position + 5] == ' '));
        } //End collapsed parenthetic
        //End case '?' 
        //Begin case '!' 
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unexpected <!", this, null);
        //End case '!' 
        //End case '<' 
        addTaint(inDeclaration);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139893376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139893376;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.056 -0400", hash_original_method = "2D33E593F3270AF80057D4A47B14E7B9", hash_generated_method = "5CAF8EF6C06DE34451C4B16F2E1EC5B7")
    private void parseStartTag(boolean xmldecl, boolean throwOnResolveFailure) throws IOException, XmlPullParserException {
        {
            read('<');
        } //End block
        name = readName();
        attributeCount = 0;
        {
            skip();
            {
                boolean var6F89AB896FA639129948E99AFBABDE77_904010824 = (position >= limit && !fillBuffer(1));
                {
                    checkRelaxed(UNEXPECTED_EOF);
                } //End block
            } //End collapsed parenthetic
            int c;
            c = buffer[position];
            {
                {
                    read('>');
                } //End block
            } //End block
            {
                {
                    degenerated = true;
                    skip();
                    read('>');
                } //End block
            } //End block
            String attrName;
            attrName = readName();
            int i;
            i = (attributeCount++) * 4;
            attributes = ensureCapacity(attributes, i + 4);
            attributes[i] = "";
            attributes[i + 1] = null;
            attributes[i + 2] = attrName;
            skip();
            {
                boolean var6F89AB896FA639129948E99AFBABDE77_1825729357 = (position >= limit && !fillBuffer(1));
                {
                    checkRelaxed(UNEXPECTED_EOF);
                } //End block
            } //End collapsed parenthetic
            {
                skip();
                {
                    boolean var910B70164E5991D8BBB1C8DDE5598762_1980367392 = (position >= limit && !fillBuffer(1));
                    {
                        checkRelaxed(UNEXPECTED_EOF);
                    } //End block
                } //End collapsed parenthetic
                char delimiter;
                delimiter = buffer[position];
                {
                    delimiter = ' ';
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("attr value delimiter missing!", this, null);
                } //End block
                attributes[i + 3] = readValue(delimiter, true, throwOnResolveFailure,
                        ValueContext.ATTRIBUTE);
            } //End block
            {
                attributes[i + 3] = attrName;
            } //End block
            {
                checkRelaxed("Attr.value missing f. " + attrName);
                attributes[i + 3] = attrName;
            } //End block
        } //End block
        int sp;
        sp = depth++ * 4;
        elementStack = ensureCapacity(elementStack, sp + 4);
        elementStack[sp + 3] = name;
        {
            int[] bigger;
            bigger = new int[depth + 4];
            System.arraycopy(nspCounts, 0, bigger, 0, nspCounts.length);
            nspCounts = bigger;
        } //End block
        nspCounts[depth] = nspCounts[depth - 1];
        {
            adjustNsp();
        } //End block
        {
            namespace = "";
        } //End block
        {
            Map<String, String> elementDefaultAttributes;
            elementDefaultAttributes = defaultAttributes.get(name);
            {
                {
                    Iterator<Map.Entry<String, String>> varF45E3F423B1D11A0BDD5925D2CFF679F_1152529577 = (elementDefaultAttributes.entrySet()).iterator();
                    varF45E3F423B1D11A0BDD5925D2CFF679F_1152529577.hasNext();
                    Map.Entry<String, String> entry = varF45E3F423B1D11A0BDD5925D2CFF679F_1152529577.next();
                    {
                        {
                            boolean var2B1ECF93F7854BA095E104AF20F9C785_809103361 = (getAttributeValue(null, entry.getKey()) != null);
                        } //End collapsed parenthetic
                        int i;
                        i = (attributeCount++) * 4;
                        attributes = ensureCapacity(attributes, i + 4);
                        attributes[i] = "";
                        attributes[i + 1] = null;
                        attributes[i + 2] = entry.getKey();
                        attributes[i + 3] = entry.getValue();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        elementStack[sp] = namespace;
        elementStack[sp + 1] = prefix;
        elementStack[sp + 2] = name;
        addTaint(xmldecl);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.080 -0400", hash_original_method = "C79463E087C57C46760693ABFA80BBC0", hash_generated_method = "E65E993D0369696E0583BAB8C20ED2D2")
    private void readEntity(StringBuilder out, boolean isEntityToken, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        int start;
        start = out.length();
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        out.append('&');
        {
            int c;
            c = peekCharacter();
            {
                out.append(';');
            } //End block
            {
                out.append((char) c);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("unterminated entity ref", this, null);
            } //End block
        } //End block
        String code;
        code = out.substring(start + 1, out.length() - 1);
        {
            name = code;
        } //End block
        {
            boolean varA99400345BFEEBA43EB55687A9AEA725_19380111 = (code.startsWith("#"));
            {
                try 
                {
                    int c;
                    boolean var58B0B78C684DF351B34A140D544263D1_950516991 = (code.startsWith("#x"));
                    c = Integer.parseInt(code.substring(2), 16);
                    c = Integer.parseInt(code.substring(1));
                    out.delete(start, out.length());
                    out.appendCodePoint(c);
                    unresolved = false;
                } //End block
                catch (NumberFormatException notANumber)
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Invalid character reference: &" + code);
                } //End block
                catch (IllegalArgumentException invalidCodePoint)
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Invalid character reference: &" + code);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String defaultEntity;
        defaultEntity = DEFAULT_ENTITIES.get(code);
        {
            out.delete(start, out.length());
            unresolved = false;
            out.append(defaultEntity);
        } //End block
        char[] resolved;
        {
            boolean var29EC81D908DBE184458A11C03BDBC90E_1442868976 = (documentEntities != null && (resolved = documentEntities.get(code)) != null);
            {
                out.delete(start, out.length());
                unresolved = false;
                {
                    pushContentSource(resolved);
                } //End block
                {
                    out.append(resolved);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            out.delete(start, out.length());
        } //End block
        unresolved = true;
        {
            checkRelaxed("unresolved: &" + code + ";");
        } //End block
        addTaint(out.getTaint());
        addTaint(isEntityToken);
        addTaint(throwOnResolveFailure);
        addTaint(valueContext.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.096 -0400", hash_original_method = "645533039846ABF2603AD0F9C774FE0D", hash_generated_method = "E3D639193FF9B53B2C4ECA61A2763D46")
    private String readValue(char delimiter, boolean resolveEntities, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_1844962772 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1586210731 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_655536940 = null; //Variable for return #3
        int start;
        start = position;
        StringBuilder result;
        result = null;
        {
            result = new StringBuilder();
            result.append(text);
        } //End block
        {
            {
                {
                    {
                        result = new StringBuilder();
                    } //End block
                    result.append(buffer, start, position - start);
                } //End block
                {
                    boolean varAA43907C5091E8F318632E4887CAA271_1033722009 = (!fillBuffer(1));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1844962772 = result != null ? result.toString() : "";
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            char c;
            c = buffer[position];
            {
                isWhitespace &= (c <= ' ');
            } //End block
            {
                result = new StringBuilder();
            } //End block
            result.append(buffer, start, position - start);
            {
                {
                    boolean varB70DE06ED34E6674DB3722520CE86044_357522508 = ((position + 1 < limit || fillBuffer(2)) && buffer[position + 1] == '\n');
                } //End collapsed parenthetic
                c = (valueContext == ValueContext.ATTRIBUTE) ? ' ' : '\n';
            } //End block
            {
                c = ' ';
            } //End block
            {
                isWhitespace = false;
                readEntity(result, false, throwOnResolveFailure, valueContext);
                start = position;
            } //End block
            {
                {
                    checkRelaxed("Illegal: \"<\" inside attribute value");
                } //End block
                isWhitespace = false;
            } //End block
            {
                {
                    boolean varBA78E9D6F2E1941F7D37C98C4AF2F15C_1096107998 = ((position + 2 < limit || fillBuffer(3))
                        && buffer[position + 1] == ']' && buffer[position + 2] == '>');
                    {
                        checkRelaxed("Illegal: \"]]>\" outside CDATA section");
                    } //End block
                } //End collapsed parenthetic
                isWhitespace = false;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("This parser doesn't support parameter entities",
                        this, null);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            result.append(c);
            start = position;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1586210731 = stringPool.get(buffer, start, position - start);
        } //End block
        {
            result.append(buffer, start, position - start);
            varB4EAC82CA7396A68D541C85D26508E83_655536940 = result.toString();
        } //End block
        addTaint(delimiter);
        addTaint(resolveEntities);
        addTaint(throwOnResolveFailure);
        addTaint(valueContext.getTaint());
        String varA7E53CE21691AB073D9660D615818899_984173669; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_984173669 = varB4EAC82CA7396A68D541C85D26508E83_1844962772;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_984173669 = varB4EAC82CA7396A68D541C85D26508E83_1586210731;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_984173669 = varB4EAC82CA7396A68D541C85D26508E83_655536940;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_984173669.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_984173669;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.097 -0400", hash_original_method = "3B69F4FA17F01509E096A0868A2528ED", hash_generated_method = "61FAEC25A10B06E65155BB93B301D93A")
    private void read(char expected) throws IOException, XmlPullParserException {
        int c;
        c = peekCharacter();
        {
            checkRelaxed("expected: '" + expected + "' actual: '" + ((char) c) + "'");
        } //End block
        addTaint(expected);
        // ---------- Original Method ----------
        //int c = peekCharacter();
        //if (c != expected) {
            //checkRelaxed("expected: '" + expected + "' actual: '" + ((char) c) + "'");
        //}
        //position++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.098 -0400", hash_original_method = "A7E267F0C0CB0F12A0F03D9AFED00521", hash_generated_method = "3CD63FAD679D290FE94F579AE88817EB")
    private void read(char[] chars) throws IOException, XmlPullParserException {
        {
            boolean varF0C73BB22A111A22F22F5EA6FB28FE41_1110357186 = (position + chars.length >= limit && !fillBuffer(chars.length));
            {
                checkRelaxed("expected: '" + new String(chars) + "' but was EOF");
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            {
                {
                    checkRelaxed("expected: \"" + new String(chars) + "\" but was \""
                        + new String(buffer, position, chars.length) + "...\"");
                } //End block
            } //End block
        } //End collapsed parenthetic
        position += chars.length;
        // ---------- Original Method ----------
        //if (position + chars.length >= limit && !fillBuffer(chars.length)) {
            //checkRelaxed("expected: '" + new String(chars) + "' but was EOF");
            //return;
        //}
        //for (int i = 0; i < chars.length; i++) {
            //if (buffer[position + i] != chars[i]) {
                //checkRelaxed("expected: \"" + new String(chars) + "\" but was \""
                        //+ new String(buffer, position, chars.length) + "...\"");
            //}
        //}
        //position += chars.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.098 -0400", hash_original_method = "902B3F7EB34CE06CF1D7162085CB95DC", hash_generated_method = "058E3D81836B5F64A107A7F1D796A713")
    private int peekCharacter() throws IOException, XmlPullParserException {
        {
            boolean varD13F14E52E697416613A9489283EE2CE_1679320035 = (position < limit || fillBuffer(1));
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179545766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179545766;
        // ---------- Original Method ----------
        //if (position < limit || fillBuffer(1)) {
            //return buffer[position];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.120 -0400", hash_original_method = "DC49987172506F0F8D59FF3F96E536A7", hash_generated_method = "4011B013C98FB03E9A4F1A8FF0301383")
    private boolean fillBuffer(int minimum) throws IOException, XmlPullParserException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unbalanced entity!", this, null);
            } //End block
            popContentSource();
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    bufferStartColumn = 0;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            bufferCapture.append(buffer, 0, position);
        } //End block
        {
            limit -= position;
            System.arraycopy(buffer, position, buffer, 0, limit);
        } //End block
        {
            limit = 0;
        } //End block
        position = 0;
        int total;
        {
            boolean var02F2209A5C0A570219740A85F11A9E73_951043474 = ((total = reader.read(buffer, limit, buffer.length - limit)) != -1);
            {
                limit += total;
            } //End block
        } //End collapsed parenthetic
        addTaint(minimum);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326452717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_326452717;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.133 -0400", hash_original_method = "35E0733B1286860BF21842013F8FFA5F", hash_generated_method = "7480D6BDA8453A96003453247F41E2BE")
    private String readName() throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_1943575071 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1136054588 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_131523045 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1927183479 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_2070012021 = null; //Variable for return #5
        {
            boolean var5AB75DCE4678778E9ADB41C89957E4BF_1478417021 = (position >= limit && !fillBuffer(1));
            {
                checkRelaxed("name expected");
                varB4EAC82CA7396A68D541C85D26508E83_1943575071 = "";
            } //End block
        } //End collapsed parenthetic
        int start;
        start = position;
        StringBuilder result;
        result = null;
        char c;
        c = buffer[position];
        {
            checkRelaxed("name expected");
            varB4EAC82CA7396A68D541C85D26508E83_1136054588 = "";
        } //End block
        {
            {
                {
                    result = new StringBuilder();
                } //End block
                result.append(buffer, start, position - start);
                {
                    boolean varAA43907C5091E8F318632E4887CAA271_524234422 = (!fillBuffer(1));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_131523045 = result.toString();
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            c = buffer[position];
            {
                varB4EAC82CA7396A68D541C85D26508E83_1927183479 = stringPool.get(buffer, start, position - start);
            } //End block
            {
                result.append(buffer, start, position - start);
                varB4EAC82CA7396A68D541C85D26508E83_2070012021 = result.toString();
            } //End block
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1527458395; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1527458395 = varB4EAC82CA7396A68D541C85D26508E83_1943575071;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1527458395 = varB4EAC82CA7396A68D541C85D26508E83_1136054588;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1527458395 = varB4EAC82CA7396A68D541C85D26508E83_131523045;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1527458395 = varB4EAC82CA7396A68D541C85D26508E83_1927183479;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1527458395 = varB4EAC82CA7396A68D541C85D26508E83_2070012021;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1527458395.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1527458395;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.141 -0400", hash_original_method = "7FC6A162788F62EDDD44981BAC207FA9", hash_generated_method = "AC4668E2C0E83F7F757095B50BFB9904")
    private void skip() throws IOException, XmlPullParserException {
        {
            boolean varD13F14E52E697416613A9489283EE2CE_1114403075 = (position < limit || fillBuffer(1));
            {
                int c;
                c = buffer[position];
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (position < limit || fillBuffer(1)) {
            //int c = buffer[position];
            //if (c > ' ') {
                //break;
            //}
            //position++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.159 -0400", hash_original_method = "46D251D7075E8F175BB5AD72794934F4", hash_generated_method = "4C430773194920E5CA624BD915A0A8AA")
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
        position = 0;
        limit = 0;
        bufferStartLine = 0;
        bufferStartColumn = 0;
        depth = 0;
        documentEntities = null;
        // ---------- Original Method ----------
        //this.reader = reader;
        //type = START_DOCUMENT;
        //name = null;
        //namespace = null;
        //degenerated = false;
        //attributeCount = -1;
        //encoding = null;
        //version = null;
        //standalone = null;
        //if (reader == null) {
            //return;
        //}
        //position = 0;
        //limit = 0;
        //bufferStartLine = 0;
        //bufferStartColumn = 0;
        //depth = 0;
        //documentEntities = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.164 -0400", hash_original_method = "EE8E194EE4DCB71C2C4B627C026D6CE3", hash_generated_method = "450AD43CBE2AB9288A1CE02B56B736E2")
    public void setInput(InputStream is, String charset) throws XmlPullParserException {
        position = 0;
        limit = 0;
        boolean detectCharset;
        detectCharset = (charset == null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        try 
        {
            {
                int firstFourBytes;
                firstFourBytes = 0;
                {
                    int i;
                    i = is.read();
                    firstFourBytes = (firstFourBytes << 8) | i;
                    buffer[limit++] = (char) i;
                } //End block
                {
                    //Begin case 0x00000FEFF 
                    charset = "UTF-32BE";
                    //End case 0x00000FEFF 
                    //Begin case 0x00000FEFF 
                    limit = 0;
                    //End case 0x00000FEFF 
                    //Begin case 0x0FFFE0000 
                    charset = "UTF-32LE";
                    //End case 0x0FFFE0000 
                    //Begin case 0x0FFFE0000 
                    limit = 0;
                    //End case 0x0FFFE0000 
                    //Begin case 0x0000003c 
                    charset = "UTF-32BE";
                    //End case 0x0000003c 
                    //Begin case 0x0000003c 
                    buffer[0] = '<';
                    //End case 0x0000003c 
                    //Begin case 0x0000003c 
                    limit = 1;
                    //End case 0x0000003c 
                    //Begin case 0x03c000000 
                    charset = "UTF-32LE";
                    //End case 0x03c000000 
                    //Begin case 0x03c000000 
                    buffer[0] = '<';
                    //End case 0x03c000000 
                    //Begin case 0x03c000000 
                    limit = 1;
                    //End case 0x03c000000 
                    //Begin case 0x0003c003f 
                    charset = "UTF-16BE";
                    //End case 0x0003c003f 
                    //Begin case 0x0003c003f 
                    buffer[0] = '<';
                    //End case 0x0003c003f 
                    //Begin case 0x0003c003f 
                    buffer[1] = '?';
                    //End case 0x0003c003f 
                    //Begin case 0x0003c003f 
                    limit = 2;
                    //End case 0x0003c003f 
                    //Begin case 0x03c003f00 
                    charset = "UTF-16LE";
                    //End case 0x03c003f00 
                    //Begin case 0x03c003f00 
                    buffer[0] = '<';
                    //End case 0x03c003f00 
                    //Begin case 0x03c003f00 
                    buffer[1] = '?';
                    //End case 0x03c003f00 
                    //Begin case 0x03c003f00 
                    limit = 2;
                    //End case 0x03c003f00 
                    //Begin case 0x03c3f786d 
                    {
                        int i;
                        i = is.read();
                        buffer[limit++] = (char) i;
                        {
                            String s;
                            s = new String(buffer, 0, limit);
                            int i0;
                            i0 = s.indexOf("encoding");
                            {
                                {
                                    boolean var04641ED6560813F64D7639A6D959AB94_557381239 = (s.charAt(i0) != '"' && s.charAt(i0) != '\'');
                                } //End collapsed parenthetic
                                char deli;
                                deli = s.charAt(i0++);
                                int i1;
                                i1 = s.indexOf(deli, i0);
                                charset = s.substring(i0, i1);
                            } //End block
                        } //End block
                    } //End block
                    //End case 0x03c3f786d 
                    //Begin case default 
                    {
                        charset = "UTF-16BE";
                        buffer[0] = (char) ((buffer[2] << 8) | buffer[3]);
                        limit = 1;
                    } //End block
                    {
                        charset = "UTF-16LE";
                        buffer[0] = (char) ((buffer[3] << 8) | buffer[2]);
                        limit = 1;
                    } //End block
                    {
                        charset = "UTF-8";
                        buffer[0] = buffer[3];
                        limit = 1;
                    } //End block
                    //End case default 
                } //End block
            } //End block
            {
                charset = "UTF-8";
            } //End block
            int savedLimit;
            savedLimit = limit;
            setInput(new InputStreamReader(is, charset));
            encoding = charset;
            limit = savedLimit;
            {
                boolean varAF965EEEE2C7D4A402FB6EA7B231688A_1536435199 = (!detectCharset && peekCharacter() == 0xfeff);
                {
                    System.arraycopy(buffer, 1, buffer, 0, limit);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Invalid stream or encoding: " + e, this, e);
        } //End block
        addTaint(is.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.169 -0400", hash_original_method = "7002CA433E430A52F3D361978C362AC4", hash_generated_method = "4F95296BF072C1901ACD47EA776B581F")
    public void close() throws IOException {
        {
            reader.close();
        } //End block
        // ---------- Original Method ----------
        //if (reader != null) {
            //reader.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.171 -0400", hash_original_method = "905F7B8816C5E28E92971A4DABCE5B48", hash_generated_method = "827F812BC74CFBEE92A07E8BE6216B13")
    public boolean getFeature(String feature) {
        {
            boolean var9760162B3F7AA5CCC8B91136021ACF54_373522622 = (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature));
            {
                boolean var019EFC6BD95914F8E676F56D5FDEF185_1224041840 = (FEATURE_RELAXED.equals(feature));
                {
                    boolean var824A1E488EAFEF118CCD0F5F4D56A2F4_1875127013 = (FEATURE_PROCESS_DOCDECL.equals(feature));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(feature.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930869717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930869717;
        // ---------- Original Method ----------
        //if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            //return processNsp;
        //} else if (FEATURE_RELAXED.equals(feature)) {
            //return relaxed;
        //} else if (FEATURE_PROCESS_DOCDECL.equals(feature)) {
            //return processDocDecl;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.172 -0400", hash_original_method = "A279F06C875438B49B8D4A1047D2C8F6", hash_generated_method = "BDBFB31EB38A8FAF27783773BFF8CFDF")
    public String getInputEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1720898191 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1720898191 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_1720898191.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1720898191;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.189 -0400", hash_original_method = "139FEB1FB1AC644E29BB2080E735DCAB", hash_generated_method = "2D419DAF154C6FB9FA633EA0D070C6D3")
    public void defineEntityReplacementText(String entity, String value) throws XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Entity replacement text may not be defined with DOCTYPE processing enabled.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Entity replacement text must be defined after setInput()");
        } //End block
        {
            documentEntities = new HashMap<String, char[]>();
        } //End block
        documentEntities.put(entity, value.toCharArray());
        addTaint(entity.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (processDocDecl) {
            //throw new IllegalStateException(
                    //"Entity replacement text may not be defined with DOCTYPE processing enabled.");
        //}
        //if (reader == null) {
            //throw new IllegalStateException(
                    //"Entity replacement text must be defined after setInput()");
        //}
        //if (documentEntities == null) {
            //documentEntities = new HashMap<String, char[]>();
        //}
        //documentEntities.put(entity, value.toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.191 -0400", hash_original_method = "88B98FA49BAB9563CCFD697035E35769", hash_generated_method = "BAEC6878120C26E7A38627308E4A81E7")
    public Object getProperty(String property) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1304626342 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1092050020 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1453051450 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_1241734007 = null; //Variable for return #4
        {
            boolean var2920F0278EE964B54E63A722B25AD531_318535878 = (property.equals(PROPERTY_XMLDECL_VERSION));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1304626342 = version;
            } //End block
            {
                boolean var01C081004E61C93BA248DD27C2FE455D_644886004 = (property.equals(PROPERTY_XMLDECL_STANDALONE));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1092050020 = standalone;
                } //End block
                {
                    boolean var784BDB95B83DBD8BBC0FD2155AD4BFDB_1094514244 = (property.equals(PROPERTY_LOCATION));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1453051450 = location != null ? location : reader.toString();
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1241734007 = null;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(property.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1146868780; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1146868780 = varB4EAC82CA7396A68D541C85D26508E83_1304626342;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1146868780 = varB4EAC82CA7396A68D541C85D26508E83_1092050020;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1146868780 = varB4EAC82CA7396A68D541C85D26508E83_1453051450;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1146868780 = varB4EAC82CA7396A68D541C85D26508E83_1241734007;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1146868780.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1146868780;
        // ---------- Original Method ----------
        //if (property.equals(PROPERTY_XMLDECL_VERSION)) {
            //return version;
        //} else if (property.equals(PROPERTY_XMLDECL_STANDALONE)) {
            //return standalone;
        //} else if (property.equals(PROPERTY_LOCATION)) {
            //return location != null ? location : reader.toString();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.192 -0400", hash_original_method = "9C3E6BF1FDA5FCF82C61137F91620CE9", hash_generated_method = "C7B256B9F701A0A585C8D132437C6282")
    public String getRootElementName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1102386158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1102386158 = rootElementName;
        varB4EAC82CA7396A68D541C85D26508E83_1102386158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1102386158;
        // ---------- Original Method ----------
        //return rootElementName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.193 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "34ADBD8441896992CE63BC4B9BE985D1")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1492114244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1492114244 = systemId;
        varB4EAC82CA7396A68D541C85D26508E83_1492114244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492114244;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.194 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "6F293A95A277C06EC65ADD94E08B4435")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_511179247 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_511179247 = publicId;
        varB4EAC82CA7396A68D541C85D26508E83_511179247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_511179247;
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.194 -0400", hash_original_method = "2B7C16F8E90DF968275251B3375CC301", hash_generated_method = "FDC7B5D30B2117B96C16A6DB2DDCBA11")
    public int getNamespaceCount(int depth) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(depth);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284767642 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284767642;
        // ---------- Original Method ----------
        //if (depth > this.depth) {
            //throw new IndexOutOfBoundsException();
        //}
        //return nspCounts[depth];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.194 -0400", hash_original_method = "DA805E6BD1FA77EA77FFD933A59A1A79", hash_generated_method = "5A091460938DF15ECB2D61CD126F8745")
    public String getNamespacePrefix(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_372215785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_372215785 = nspStack[pos * 2];
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_372215785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_372215785;
        // ---------- Original Method ----------
        //return nspStack[pos * 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.195 -0400", hash_original_method = "BEA3C6D36DAA76218F10B33482B7D86B", hash_generated_method = "000184C76E1399E0126D8680F5CF8D9A")
    public String getNamespaceUri(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_827957582 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_827957582 = nspStack[(pos * 2) + 1];
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_827957582.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_827957582;
        // ---------- Original Method ----------
        //return nspStack[(pos * 2) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.199 -0400", hash_original_method = "40F39B6FC2CBEA065A6E595C0C377D56", hash_generated_method = "DE3B52D0FF181E1B56760572B0A5D1F1")
    public String getNamespace(String prefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_185984230 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_217085254 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_74541746 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_360983790 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1213193280 = null; //Variable for return #5
        {
            boolean var56127411105EF3D71B9CCE5F0E40D652_1987452567 = ("xml".equals(prefix));
            {
                varB4EAC82CA7396A68D541C85D26508E83_185984230 = "http://www.w3.org/XML/1998/namespace";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var329E1608DCF39A88065813BCF90D4AD7_973381030 = ("xmlns".equals(prefix));
            {
                varB4EAC82CA7396A68D541C85D26508E83_217085254 = "http://www.w3.org/2000/xmlns/";
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = (getNamespaceCount(depth) << 1) - 2;
            i -= 2;
            {
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_74541746 = nspStack[i + 1];
                    } //End block
                } //End block
                {
                    boolean var19919B58D04B466754D10E3F26461086_1837310634 = (prefix.equals(nspStack[i]));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_360983790 = nspStack[i + 1];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1213193280 = null;
        addTaint(prefix.getTaint());
        String varA7E53CE21691AB073D9660D615818899_182257180; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_182257180 = varB4EAC82CA7396A68D541C85D26508E83_185984230;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_182257180 = varB4EAC82CA7396A68D541C85D26508E83_217085254;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_182257180 = varB4EAC82CA7396A68D541C85D26508E83_74541746;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_182257180 = varB4EAC82CA7396A68D541C85D26508E83_360983790;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_182257180 = varB4EAC82CA7396A68D541C85D26508E83_1213193280;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_182257180.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_182257180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.200 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "6B5D6E3EE103C5B3586D48FAE35B8CCD")
    public int getDepth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994689864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994689864;
        // ---------- Original Method ----------
        //return depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.201 -0400", hash_original_method = "B71BFE480A942DC6AFBA741559BFFBE0", hash_generated_method = "CAB2BA9A837995CF4E72CD09AD08E542")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_294078550 = null; //Variable for return #1
        StringBuilder buf;
        buf = new StringBuilder(type < TYPES.length ? TYPES[type] : "unknown");//DSFIXME:  CODE0008: Nested ternary operator in expression
        buf.append(' ');
        {
            {
                buf.append("(empty) ");
            } //End block
            buf.append('<');
            {
                buf.append('/');
            } //End block
            {
                buf.append("{" + namespace + "}" + prefix + ":");
            } //End block
            buf.append(name);
            int cnt;
            cnt = attributeCount * 4;
            {
                int i;
                i = 0;
                i += 4;
                {
                    buf.append(' ');
                    {
                        buf.append("{" + attributes[i] + "}" + attributes[i + 1] + ":");
                    } //End block
                    buf.append(attributes[i + 2] + "='" + attributes[i + 3] + "'");
                } //End block
            } //End collapsed parenthetic
            buf.append('>');
        } //End block
        {
            ;
        } //End block
        {
            buf.append(getText());
        } //End block
        {
            buf.append("(whitespace)");
        } //End block
        {
            String text;
            text = getText();
            {
                boolean varDAA30F2CB16032AE96BE08E6F6C22995_1439338409 = (text.length() > 16);
                {
                    text = text.substring(0, 16) + "...";
                } //End block
            } //End collapsed parenthetic
            buf.append(text);
        } //End block
        buf.append("@" + getLineNumber() + ":" + getColumnNumber());
        {
            buf.append(" in ");
            buf.append(location);
        } //End block
        {
            buf.append(" in ");
            buf.append(reader.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_294078550 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_294078550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_294078550;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.210 -0400", hash_original_method = "114340E3BA1FFC2D8A54D30C75AB06FF", hash_generated_method = "111426F9D8FF5D692033B24D31124AEB")
    public int getLineNumber() {
        int result;
        result = bufferStartLine;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733936903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733936903;
        // ---------- Original Method ----------
        //int result = bufferStartLine;
        //for (int i = 0; i < position; i++) {
            //if (buffer[i] == '\n') {
                //result++;
            //}
        //}
        //return result + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.214 -0400", hash_original_method = "C138C40AD0ECD6D56D342D21687BD452", hash_generated_method = "4F3893A9481F7D24D7ADF0C18CB487C7")
    public int getColumnNumber() {
        int result;
        result = bufferStartColumn;
        {
            int i;
            i = 0;
            {
                {
                    result = 0;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027952556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027952556;
        // ---------- Original Method ----------
        //int result = bufferStartColumn;
        //for (int i = 0; i < position; i++) {
            //if (buffer[i] == '\n') {
                //result = 0;
            //} else {
                //result++;
            //}
        //}
        //return result + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.220 -0400", hash_original_method = "152BCFAF579D72B6DEF962950FEC2A17", hash_generated_method = "43819F1E251734C2F3EEF408D952B3DD")
    public boolean isWhitespace() throws XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253698536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253698536;
        // ---------- Original Method ----------
        //if (type != TEXT && type != IGNORABLE_WHITESPACE && type != CDSECT) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return isWhitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.229 -0400", hash_original_method = "96BD4C193A5C47E4BA7EA81CE7C395CC", hash_generated_method = "3A3B23422724AA0B189D9F23B32C11BA")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_785216977 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1601424875 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1685553205 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_785216977 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1601424875 = "";
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1685553205 = text;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_919326560; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_919326560 = varB4EAC82CA7396A68D541C85D26508E83_785216977;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_919326560 = varB4EAC82CA7396A68D541C85D26508E83_1601424875;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_919326560 = varB4EAC82CA7396A68D541C85D26508E83_1685553205;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_919326560.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_919326560;
        // ---------- Original Method ----------
        //if (type < TEXT || (type == ENTITY_REF && unresolved)) {
            //return null;
        //} else if (text == null) {
            //return "";
        //} else {
            //return text;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.235 -0400", hash_original_method = "17ADAF2C34EC5E5726D60154CDE0E31A", hash_generated_method = "369D50BC2F13328F34A86018F4898888")
    public char[] getTextCharacters(int[] poslen) {
        String text;
        text = getText();
        {
            poslen[0] = -1;
            poslen[1] = -1;
        } //End block
        char[] result;
        result = text.toCharArray();
        poslen[0] = 0;
        poslen[1] = result.length;
        addTaint(poslen[0]);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1979431598 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1979431598;
        // ---------- Original Method ----------
        //String text = getText();
        //if (text == null) {
            //poslen[0] = -1;
            //poslen[1] = -1;
            //return null;
        //}
        //char[] result = text.toCharArray();
        //poslen[0] = 0;
        //poslen[1] = result.length;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.236 -0400", hash_original_method = "A99E1DDB500E37E7767EA602F963D96D", hash_generated_method = "A32C7D5F7C572892D72E98601E164962")
    public String getNamespace() {
        String varB4EAC82CA7396A68D541C85D26508E83_1710279825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1710279825 = namespace;
        varB4EAC82CA7396A68D541C85D26508E83_1710279825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1710279825;
        // ---------- Original Method ----------
        //return namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.236 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "218924669B160FF6D17342EDF8CE14F6")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_135793304 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_135793304 = name;
        varB4EAC82CA7396A68D541C85D26508E83_135793304.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_135793304;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.243 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "33BD58E9EADB3AD6608F0BDEDC03D994")
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_234848037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_234848037 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_234848037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234848037;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.244 -0400", hash_original_method = "BB5C193EDDCF2188F64023D36680FCC7", hash_generated_method = "E5A0511909BA746894CE5EF7FE97F654")
    public boolean isEmptyElementTag() throws XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779945350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779945350;
        // ---------- Original Method ----------
        //if (type != START_TAG) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return degenerated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.245 -0400", hash_original_method = "E7902A71CF05159AEACA5707956D2FB0", hash_generated_method = "983C773A5EC91BA191BFC91E37287E5E")
    public int getAttributeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014933871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014933871;
        // ---------- Original Method ----------
        //return attributeCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.245 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "2E01D9DCB4D55A5BE4DEDC58FEC6CA58")
    public String getAttributeType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_698157399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_698157399 = "CDATA";
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_698157399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_698157399;
        // ---------- Original Method ----------
        //return "CDATA";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.247 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "88D9F175E1F5F5760D741906A9CA0675")
    public boolean isAttributeDefault(int index) {
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999112651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999112651;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.248 -0400", hash_original_method = "1DC23C46494192E0CB67B725251C6942", hash_generated_method = "083BDF05239E7F6246FB2BFDFE46498A")
    public String getAttributeNamespace(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1879623954 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1879623954 = attributes[index * 4];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1879623954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1879623954;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[index * 4];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.256 -0400", hash_original_method = "07BD775DFF4E9B04837F88C1E2748FE1", hash_generated_method = "551F9839AF07C1681824E590DF87306C")
    public String getAttributeName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_752652285 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_752652285 = attributes[(index * 4) + 2];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_752652285.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752652285;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.256 -0400", hash_original_method = "C689E94E86EA5FE91ACCD87E01866231", hash_generated_method = "8F9BB7682BC70B98DFCD940266713355")
    public String getAttributePrefix(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1955130004 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1955130004 = attributes[(index * 4) + 1];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1955130004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1955130004;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.264 -0400", hash_original_method = "BF5E04E32ADD7672259D8C86F2C8D631", hash_generated_method = "621D21C4CB410A4ECF0599CC58B12078")
    public String getAttributeValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1462765178 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1462765178 = attributes[(index * 4) + 3];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1462765178.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1462765178;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 3];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.332 -0400", hash_original_method = "D0AC7DE2A29C82DADA1B505288DAC27D", hash_generated_method = "D544971F136C27D739437CBF8B06CE20")
    public String getAttributeValue(String namespace, String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1968547909 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2017280365 = null; //Variable for return #2
        {
            int i;
            i = (attributeCount * 4) - 4;
            i -= 4;
            {
                {
                    boolean var47349E615B9664FECFB917121CFA114F_2035892052 = (attributes[i + 2].equals(name)
                    && (namespace == null || attributes[i].equals(namespace)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1968547909 = attributes[i + 3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2017280365 = null;
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_81959467; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_81959467 = varB4EAC82CA7396A68D541C85D26508E83_1968547909;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_81959467 = varB4EAC82CA7396A68D541C85D26508E83_2017280365;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_81959467.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_81959467;
        // ---------- Original Method ----------
        //for (int i = (attributeCount * 4) - 4; i >= 0; i -= 4) {
            //if (attributes[i + 2].equals(name)
                    //&& (namespace == null || attributes[i].equals(namespace))) {
                //return attributes[i + 3];
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.333 -0400", hash_original_method = "0457ED08CBFC1348E0AAA3CE0D692605", hash_generated_method = "0DC1E48A4F55F6DC35E67CD7672EDC02")
    public int getEventType() throws XmlPullParserException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_976255338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_976255338;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.333 -0400", hash_original_method = "53E7D5238284732F8540E3833F26B112", hash_generated_method = "34DF3071F7FC8B1E57AB35B11DF2ADBE")
    public int nextTag() throws XmlPullParserException, IOException {
        next();
        {
            next();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("unexpected type", this, null);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104788414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104788414;
        // ---------- Original Method ----------
        //next();
        //if (type == TEXT && isWhitespace) {
            //next();
        //}
        //if (type != END_TAG && type != START_TAG) {
            //throw new XmlPullParserException("unexpected type", this, null);
        //}
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.334 -0400", hash_original_method = "C4BF1BB4C255F6013F5858579D851AD3", hash_generated_method = "61DA458528B1973D5C3248628345BF3D")
    public void require(int type, String namespace, String name) throws XmlPullParserException, IOException {
        {
            boolean varC944AD0162EFA3375CCB269661747DD7_1907835102 = (type != this.type
                || (namespace != null && !namespace.equals(getNamespace()))
                || (name != null && !name.equals(getName())));
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "expected: " + TYPES[type] + " {" + namespace + "}" + name, this, null);
            } //End block
        } //End collapsed parenthetic
        addTaint(type);
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (type != this.type
                //|| (namespace != null && !namespace.equals(getNamespace()))
                //|| (name != null && !name.equals(getName()))) {
            //throw new XmlPullParserException(
                    //"expected: " + TYPES[type] + " {" + namespace + "}" + name, this, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.336 -0400", hash_original_method = "102A6610D1A439DBBB62D3798FEF6670", hash_generated_method = "6FF058DA982069A7810FEE6E5D9A99B1")
    public String nextText() throws XmlPullParserException, IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_552929321 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("precondition: START_TAG", this, null);
        } //End block
        next();
        String result;
        {
            result = getText();
            next();
        } //End block
        {
            result = "";
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("END_TAG expected", this, null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_552929321 = result;
        varB4EAC82CA7396A68D541C85D26508E83_552929321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_552929321;
        // ---------- Original Method ----------
        //if (type != START_TAG) {
            //throw new XmlPullParserException("precondition: START_TAG", this, null);
        //}
        //next();
        //String result;
        //if (type == TEXT) {
            //result = getText();
            //next();
        //} else {
            //result = "";
        //}
        //if (type != END_TAG) {
            //throw new XmlPullParserException("END_TAG expected", this, null);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.337 -0400", hash_original_method = "DD2B8D14469BF5F6853E930DFF62942D", hash_generated_method = "E208FE3DD8AA3B9DBB16880176E11D35")
    public void setFeature(String feature, boolean value) throws XmlPullParserException {
        {
            boolean var9760162B3F7AA5CCC8B91136021ACF54_1569733726 = (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature));
            {
                processNsp = value;
            } //End block
            {
                boolean varDAAE59AD80DC7E8FB2D89FCF61BDADCB_892663048 = (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(feature));
                {
                    processDocDecl = value;
                } //End block
                {
                    boolean varA1DC7E273DEAF4169FD3F94A9162735F_1762899708 = (FEATURE_RELAXED.equals(feature));
                    {
                        relaxed = value;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("unsupported feature: " + feature, this, null);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(feature.getTaint());
        // ---------- Original Method ----------
        //if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            //processNsp = value;
        //} else if (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(feature)) {
            //processDocDecl = value;
        //} else if (FEATURE_RELAXED.equals(feature)) {
            //relaxed = value;
        //} else {
            //throw new XmlPullParserException("unsupported feature: " + feature, this, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.345 -0400", hash_original_method = "BB78C28304FA5EA99DAD361D5123F3A6", hash_generated_method = "336BAEDBD6F41FBB2EC961F88B10BCF2")
    public void setProperty(String property, Object value) throws XmlPullParserException {
        {
            boolean varDDBF2C6AF46A27BDBAB0C7C42C7E43D3_377369835 = (property.equals(PROPERTY_LOCATION));
            {
                location = String.valueOf(value);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("unsupported property: " + property);
            } //End block
        } //End collapsed parenthetic
        addTaint(property.getTaint());
        // ---------- Original Method ----------
        //if (property.equals(PROPERTY_LOCATION)) {
            //location = String.valueOf(value);
        //} else {
            //throw new XmlPullParserException("unsupported property: " + property);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.346 -0400", hash_original_method = "8F280A3CDA5A3533C9FB5C99B2A6A6C2", hash_generated_method = "1875E14C2FF645B516B31839CE1AE2FD")
    private void pushContentSource(char[] newBuffer) {
        nextContentSource = new ContentSource(nextContentSource, buffer, position, limit);
        buffer = newBuffer;
        position = 0;
        limit = newBuffer.length;
        // ---------- Original Method ----------
        //nextContentSource = new ContentSource(nextContentSource, buffer, position, limit);
        //buffer = newBuffer;
        //position = 0;
        //limit = newBuffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.346 -0400", hash_original_method = "E5A180E871F653CC9F75C9B7A9F73687", hash_generated_method = "AB3CB35729064AF57103D5354FFFA23D")
    private void popContentSource() {
        buffer = nextContentSource.buffer;
        position = nextContentSource.position;
        limit = nextContentSource.limit;
        nextContentSource = nextContentSource.next;
        // ---------- Original Method ----------
        //buffer = nextContentSource.buffer;
        //position = nextContentSource.position;
        //limit = nextContentSource.limit;
        //nextContentSource = nextContentSource.next;
    }

    
    enum ValueContext {
        ATTRIBUTE,
        TEXT,
        ENTITY_DECLARATION
    }

    
    static class ContentSource {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.356 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "7D21AAFF4A726AE51AF8BEE306E3B202")

        private ContentSource next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.356 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

        private char[] buffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.357 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

        private int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.357 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

        private int limit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_method = "BC47C2124096A91C278868E0B05F486C", hash_generated_method = "09A7E76D7B92EC6645E7074B8EFBBAF1")
          ContentSource(ContentSource next, char[] buffer, int position, int limit) {
            this.next = next;
            this.buffer = buffer;
            this.position = position;
            this.limit = limit;
            // ---------- Original Method ----------
            //this.next = next;
            //this.buffer = buffer;
            //this.position = position;
            //this.limit = limit;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "27B6834E590614C67E1B47148C9A08A7", hash_generated_field = "B77D37109485762C37B2AD4513811A3D")

    private static String PROPERTY_XMLDECL_VERSION = "http://xmlpull.org/v1/doc/properties.html#xmldecl-version";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "5768BD6E60DAB0B2B728E0D499DB1599", hash_generated_field = "B12A6931549E324D5A15EA06EC493667")

    private static String PROPERTY_XMLDECL_STANDALONE = "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "884227814336854467D95B8B62864403", hash_generated_field = "10F284890658971328530F30C84DFCE1")

    private static String PROPERTY_LOCATION = "http://xmlpull.org/v1/doc/properties.html#location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "34C1F6B518B9248A65D50F5DA60C6C55", hash_generated_field = "B839FFF90FBF920E1CAC10B7202F5567")

    private static String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "92D38954A36A7A130944D347C51A4750", hash_generated_field = "ABEEEE06D85CEC33469F6B0408F72632")

    private static Map<String, String> DEFAULT_ENTITIES = new HashMap<String, String>();
    static {
        DEFAULT_ENTITIES.put("lt", "<");
        DEFAULT_ENTITIES.put("gt", ">");
        DEFAULT_ENTITIES.put("amp", "&");
        DEFAULT_ENTITIES.put("apos", "'");
        DEFAULT_ENTITIES.put("quot", "\"");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "35DC4AA981D49C40AF5D8EB7E9F1117A", hash_generated_field = "BA4EF4273B87EA1C0E72E835DBC233EF")

    private static int ELEMENTDECL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "C8E8F601E56036BF41DED88DC4266A8D", hash_generated_field = "B660EDF09D90AF8F545C7394208AAE63")

    private static int ENTITYDECL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "FC717574941501F4302EC29D3B65C1FF", hash_generated_field = "1485DD470F73C055E1209A341547BAB6")

    private static int ATTLISTDECL = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "6AA28C8E65834B07CFDECC56CC10645C", hash_generated_field = "770071E452AADA03AA57C62CB7B09AE4")

    private static int NOTATIONDECL = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "FE0875DD4DD3CE989B0A3D90742E5A5E", hash_generated_field = "F8900D906F8F53018E604AC78C8CBB2D")

    private static int PARAMETER_ENTITY_REF = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.358 -0400", hash_original_field = "E7BD4BF0DD03ED7F0C2CE63D25C4F342", hash_generated_field = "7C356378E790258869C3BD674900FE61")

    private static char[] START_COMMENT = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "B022889C19E08B210036EBAFDCF3BF96", hash_generated_field = "618342BD1FE61363BA65EFB14334AF50")

    private static char[] END_COMMENT = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "53D1CB8EB2CA2E3A088A616EE99463E8", hash_generated_field = "0AF33D6222668C8AB8F3712105BD713D")

    private static char[] COMMENT_DOUBLE_DASH = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "C0A15B2F83065A1DFC9027CE36A09E2D", hash_generated_field = "416D922208DE262C00D73E18D9F845B7")

    private static char[] START_CDATA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "9187F94234DDBD50920C4C920C0BC3D1", hash_generated_field = "B2D69C0F7909CFB0B867F8AA3278BC81")

    private static char[] END_CDATA = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "0057C89060DC30A0D3BCAD97306A9EA4", hash_generated_field = "64C84E7F7F2C0ECE9BE41A232D0EEEB0")

    private static char[] START_PROCESSING_INSTRUCTION = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "DA4C6A74263B1C7667F633E7F0A84E50", hash_generated_field = "D09A484CC0D4FB9EE6547DEA6FE2161E")

    private static char[] END_PROCESSING_INSTRUCTION = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "8A17DA7EFA39ACED7446B7874A7EC2A2", hash_generated_field = "9CCE9676345E7465534A09172D1000AC")

    private static char[] START_DOCTYPE = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "38C3FB49D52D4A290C10B9F798EC30A0", hash_generated_field = "C0BBBCC63939C330A95B542980435971")

    private static char[] SYSTEM = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "2438362FD4A140D2147FEB110B4A6E5F", hash_generated_field = "C94B8CC25AE230F126C52E926146734A")

    private static char[] PUBLIC = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "D68A738A9EA3A1C42717AF4857C99B99", hash_generated_field = "8C9A03EE8E678B65B6DB7C8F2836194B")

    private static char[] START_ELEMENT = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "727399FD752E37162EF939B0657F7D60", hash_generated_field = "2131426D6F4FE00461E1FC2DEFECEA3F")

    private static char[] START_ATTLIST = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "FA7B87FB313821079B341C73E6B33C55", hash_generated_field = "C8CD50A7A0466C767A091CE7EA21A84E")

    private static char[] START_ENTITY = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "CC3F4B8257AABBE89D84580F3628DEC1", hash_generated_field = "90C54631F9D48D78E01F699C4E935BF5")

    private static char[] START_NOTATION = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "1D4BBC963EF8009B5C27B42A1BACB865", hash_generated_field = "6725A6111037E6FDFFAB17A25D4DE3D7")

    private static char[] EMPTY = new char[] { 'E', 'M', 'P', 'T', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "03F8F742493275DA0383F42B3966CFE9", hash_generated_field = "256F4807CC16AD5A7975F2E6B5502D1A")

    private static char[] ANY = new char[]{ 'A', 'N', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "2CBBE1148D5985E9C125F13280475FEA", hash_generated_field = "5740E4206AB3B72F944C48941674EED8")

    private static char[] NDATA = new char[]{ 'N', 'D', 'A', 'T', 'A' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "5399D5CD75FA12874AFE811CC79AACC9", hash_generated_field = "8B2D8AA39FFA5F16B9332C1ECFD79B8A")

    private static char[] NOTATION = new char[]{ 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "7E6290A430CA851B556ABC7D34D8AD24", hash_generated_field = "FE76A5F24A7383C686F764D84246583D")

    private static char[] REQUIRED = new char[] { 'R', 'E', 'Q', 'U', 'I', 'R', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.359 -0400", hash_original_field = "81F7575472B843CF7EA57A03A43E8109", hash_generated_field = "F3682F7A7D0B7AA0F8958B4DA940AC7E")

    private static char[] IMPLIED = new char[] { 'I', 'M', 'P', 'L', 'I', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.360 -0400", hash_original_field = "97889E011D3E83DBDEE52D4845C143AD", hash_generated_field = "38FAF05A6E858C6B6C912C6E908F31FE")

    private static char[] FIXED = new char[] { 'F', 'I', 'X', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.360 -0400", hash_original_field = "E20CB809E09D45606B87A49E30F6A337", hash_generated_field = "0BDF5CB6BE890378B6A4B642ED78D1F1")

    static private String UNEXPECTED_EOF = "Unexpected EOF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.360 -0400", hash_original_field = "A39FC8F3BE9A750F49E5AC875DA0254A", hash_generated_field = "6B8BBCF1B2373A27CA3AA17B2747FF1D")

    static private String ILLEGAL_TYPE = "Wrong event type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.360 -0400", hash_original_field = "EE3EB445BB65E61F6C1827B6103FB153", hash_generated_field = "C07C91568A8D678929322E23DEBC3977")

    static private int XML_DECLARATION = 998;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.360 -0400", hash_original_field = "22D831D51410F2BFA15997AC55164E91", hash_generated_field = "E41D2D35D27A9F7B7322B59CC1615C54")

    private static char[] SINGLE_QUOTE = new char[] { '\'' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.360 -0400", hash_original_field = "98068AEE409DFDA084FFD71A3B03132A", hash_generated_field = "B61A3E417AB312CC38FBCD85D6A97146")

    private static char[] DOUBLE_QUOTE = new char[] { '"' };
}

