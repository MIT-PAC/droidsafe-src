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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.569 -0400", hash_original_field = "D5189DE027922F81005951E6EFE0EFD5", hash_generated_field = "CE74502D5DD419367E637D11E946AE48")

    private String location;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.569 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "B9C33225233D273951C807AA4A997C84")

    private String version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.569 -0400", hash_original_field = "083A7D1EBF6F499AF0C1B1BB489B4941", hash_generated_field = "F545B366D95421A9D0545B064DF3FA15")

    private Boolean standalone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.569 -0400", hash_original_field = "DFC84309889AC09133BB4E87BE34F708", hash_generated_field = "22BD78252C1771E229BD8814989F89D7")

    private String rootElementName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.569 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "61D7C74417362A394394F7DA60F28955", hash_generated_field = "6545B566A550C532A7353AE3BD57F4A5")

    private boolean processDocDecl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "09024CE37019EE47CD92BC3C6111FC3E", hash_generated_field = "769EB7E2763BBF503944F860A1BF2B53")

    private boolean processNsp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "81F32BE24A2A62FC472CC43EDC97E65B", hash_generated_field = "56D1CD4D0FE519DF4F93CCF1C262BFDF")

    private boolean relaxed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "C97F5F3194C1ED85A46851DB7EBD742D", hash_generated_field = "7273BF2007F6D9DA572D2E585776EE5B")

    private boolean keepNamespaceAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "B8BE629C2D9B6F6F9BBC8E2DF0B8DFE2", hash_generated_field = "7C254A9FE7EB03488648DE590A70B1E8")

    private StringBuilder bufferCapture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "22CADEBBDFDF70204FCDA053244BDAB4", hash_generated_field = "5EE5BD02D72D06CAAF4EF8E2D19E1135")

    private Map<String, char[]> documentEntities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "62676B93D1C3D8404C9C812ADC5F1C3A", hash_generated_field = "E290D91FC5BAFD29B00A44E1145FC9FB")

    private Map<String, Map<String, String>> defaultAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "55B1FBA4550114B730EDDC57888D99A6", hash_generated_field = "C38C16C38A66AC817AFDEB16F3AB2C79")

    private String[] elementStack = new String[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "74016F2E2E7F384872DF74677FF1C217", hash_generated_field = "9D1B39E20FB88BB665BD0F6B05D41FA2")

    private String[] nspStack = new String[8];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "59CAFBB511BF3C5D3EDE905B12C326C7", hash_generated_field = "167B18033DE59DDC6FAA031548884DC7")

    private int[] nspCounts = new int[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private Reader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "5AEFC22A591C854AAB5F4A44DD63608F", hash_generated_field = "B7F81B9E6E384492F57E569C80E0DE3A")

    private ContentSource nextContentSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "C7730CCE178204102E6E99312BA48AE2", hash_generated_field = "577EC909B068680E25766CC68FC4E0C4")

    private char[] buffer = new char[8192];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

    private int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "8D564E87D9CDB569F6C0D82D1566729D", hash_generated_field = "00F405BC8E12348750DA51A45F66E092")

    private int limit = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "197691A1D824E6BF0A4FDB37CD42DFBF", hash_generated_field = "ABCC56A72A2BAE75E77EB925AA857BA4")

    private int bufferStartLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "77D3912721282C90863775372B432626", hash_generated_field = "322559720B3F732E76842B5632DA7E78")

    private int bufferStartColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "FDBE2C32DE81904D31506233605042C8", hash_generated_field = "002F5A5E90D73E291F33E6C6294E8D20")

    private boolean isWhitespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "89801E9E98979062E84647433A8ED3E9", hash_generated_field = "E3760D072DB711CCBCD48E45C2700E12")

    private String namespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "41E5137359BCC159984E1D58F1F76D16", hash_generated_field = "DBB8A6C14E3796CA3A469826B313EF12")

    private boolean degenerated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "BB16AB716A8B7609C0ECC6FB65BADCBC", hash_generated_field = "269E5A2AA1CB94A01698B537489DA5D4")

    private int attributeCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "DD7CEF9E81CAE57B34B30FA66B74E598", hash_generated_field = "569C94B11664DECEEFD3830A5970E18C")

    private String[] attributes = new String[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "5A2A9A2BD7181810539A763573C1D6FB")

    private String error;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "8B371F13D7DE4300703DDB9173F6E8E6", hash_generated_field = "3CE0322C00553A852949CE941813EC46")

    private boolean unresolved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_field = "5D197505CD7E19C50091B8A2B5C9E1D2", hash_generated_field = "E6746676D26EF55819E689A7D8CBC54D")

    public final StringPool stringPool = new StringPool();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_method = "010DAC0EB3331EDC25D05B4FF02298A9", hash_generated_method = "010DAC0EB3331EDC25D05B4FF02298A9")
    public KXmlParser ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.570 -0400", hash_original_method = "A527DEDBB8977F1D947B829D15DAACC5", hash_generated_method = "1634D7B912087B274B9C21F12413F3E3")
    public void keepNamespaceAttributes() {
        this.keepNamespaceAttributes = true;
        // ---------- Original Method ----------
        //this.keepNamespaceAttributes = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.572 -0400", hash_original_method = "F08928441827C23946744248151D18D9", hash_generated_method = "48A7554AD9B5B133D2A3820A95A037E6")
    private boolean adjustNsp() throws XmlPullParserException {
        boolean any = false;
        {
            int i = 0;
            i += 4;
            {
                String attrName = attributes[i + 2];
                int cut = attrName.indexOf(':');
                String prefix;
                {
                    prefix = attrName.substring(0, cut);
                    attrName = attrName.substring(cut + 1);
                } //End block
                {
                    boolean varE8E99AA812A31FBE0E19EAB21AA5408E_65370338 = (attrName.equals("xmlns"));
                    {
                        prefix = attrName;
                        attrName = null;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var946560EAC9A71101396E7CF7B5CB85AE_2039982024 = (!prefix.equals("xmlns"));
                    {
                        any = true;
                    } //End block
                    {
                        int j = (nspCounts[depth]++) << 1;
                        nspStack = ensureCapacity(nspStack, j + 2);
                        nspStack[j] = attrName;
                        nspStack[j + 1] = attributes[i + 3];
                        {
                            boolean varB788F9FC33ABF51F2A4A741D8D605EA1_316436094 = (attrName != null && attributes[i + 3].isEmpty());
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
                int i = (attributeCount << 2) - 4;
                i -= 4;
                {
                    String attrName = attributes[i + 2];
                    int cut = attrName.indexOf(':');
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "illegal attribute name: " + attrName + " at " + this);
                    } //End block
                    {
                        String attrPrefix = attrName.substring(0, cut);
                        attrName = attrName.substring(cut + 1);
                        String attrNs = getNamespace(attrPrefix);
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
        int cut = name.indexOf(':');
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389253916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389253916;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.573 -0400", hash_original_method = "49B8B44C0E7574021385F3D8BD03186C", hash_generated_method = "CF22B02A21CEEF3C853B61FE5DCED562")
    private String[] ensureCapacity(String[] arr, int required) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1740762099 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1171222059 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1740762099 = arr;
        } //End block
        String[] bigger = new String[required + 16];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
        varB4EAC82CA7396A68D541C85D26508E83_1171222059 = bigger;
        addTaint(arr[0].getTaint());
        addTaint(required);
        String[] varA7E53CE21691AB073D9660D615818899_1880407594; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1880407594 = varB4EAC82CA7396A68D541C85D26508E83_1740762099;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1880407594 = varB4EAC82CA7396A68D541C85D26508E83_1171222059;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1880407594.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1880407594;
        // ---------- Original Method ----------
        //if (arr.length >= required) {
            //return arr;
        //}
        //String[] bigger = new String[required + 16];
        //System.arraycopy(arr, 0, bigger, 0, arr.length);
        //return bigger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.573 -0400", hash_original_method = "4A7BCCF6DFE9CB9D8E85D47BF7F54B1D", hash_generated_method = "9397C0C707F50F637448195E17EE2480")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.574 -0400", hash_original_method = "76E82C4E283B430F3EE1381EBB2709F7", hash_generated_method = "2DAB85421646611CA2CB6BAFADE7E6D4")
    public int next() throws XmlPullParserException, IOException {
        int var7CB2833143510FA64D55226A9FF36AA2_2081051924 = (next(false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055763419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055763419;
        // ---------- Original Method ----------
        //return next(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.574 -0400", hash_original_method = "B3A65F7F837C14F73BB928D8BDFE9D91", hash_generated_method = "06389471D74B55BE705577CC9EEC094A")
    public int nextToken() throws XmlPullParserException, IOException {
        int var217D6B4D8CC59251F9E88B712D4C8A6D_1186214590 = (next(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457215326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457215326;
        // ---------- Original Method ----------
        //return next(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.575 -0400", hash_original_method = "55251A1079E5B9F4E3B9F053CFE6FD44", hash_generated_method = "85169B4B9A9EB6A39B858C5077B2C39A")
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
        boolean throwOnResolveFailure = !justOneToken;
        {
            //Begin case START_TAG 
            parseStartTag(false, throwOnResolveFailure);
            //End case START_TAG 
            //Begin case END_TAG 
            readEndTag();
            //End case END_TAG 
            //Begin case ENTITY_REF 
            {
                StringBuilder entityTextBuilder = new StringBuilder();
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
            String commentText = readComment(justOneToken);
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
            String processingInstruction = readUntil(END_PROCESSING_INSTRUCTION, justOneToken);
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
            int peek = peekType(false);
            {
                boolean varFA88C9D54C78329BBC9730AF33B2F91B_518471004 = (text != null && !text.isEmpty() && peek < TEXT);
                {
                    type = TEXT;
                } //End block
            } //End collapsed parenthetic
            type = peek;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663581647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663581647;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.577 -0400", hash_original_method = "C492543C28BFA45A4A603454FE30EBBB", hash_generated_method = "FB0746DEFA10863EC22398ED7B10FE64")
    private String readUntil(char[] delimiter, boolean returnText) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_301207978 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1380982111 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1728584156 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1336355243 = null; //Variable for return #4
        int start = position;
        StringBuilder result = null;
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
                    boolean var6A57E9353FD53082715EEF7D5328480F_493526087 = (!fillBuffer(delimiter.length));
                    {
                        checkRelaxed(UNEXPECTED_EOF);
                        type = COMMENT;
                        varB4EAC82CA7396A68D541C85D26508E83_301207978 = null;
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            {
                int i = 0;
            } //End collapsed parenthetic
        } //End block
        int end = position;
        position += delimiter.length;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1380982111 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1728584156 = stringPool.get(buffer, start, end - start);
        } //End block
        {
            result.append(buffer, start, end - start);
            varB4EAC82CA7396A68D541C85D26508E83_1336355243 = result.toString();
        } //End block
        addTaint(returnText);
        String varA7E53CE21691AB073D9660D615818899_463421858; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_463421858 = varB4EAC82CA7396A68D541C85D26508E83_301207978;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_463421858 = varB4EAC82CA7396A68D541C85D26508E83_1380982111;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_463421858 = varB4EAC82CA7396A68D541C85D26508E83_1728584156;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_463421858 = varB4EAC82CA7396A68D541C85D26508E83_1336355243;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_463421858.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_463421858;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.578 -0400", hash_original_method = "79737DD70253BC976180BA8757B427A8", hash_generated_method = "D2EBA9ADFF3A9B7B99F7F35E574887BF")
    private void readXmlDeclaration() throws IOException, XmlPullParserException {
        {
            checkRelaxed("processing instructions must not start with xml");
        } //End block
        read(START_PROCESSING_INSTRUCTION);
        parseStartTag(true, true);
        {
            boolean var581268841B2EE653D75D3B9B477E8682_1814857750 = (attributeCount < 1 || !"version".equals(attributes[2]));
            {
                checkRelaxed("version expected");
            } //End block
        } //End collapsed parenthetic
        version = attributes[3];
        int pos = 1;
        {
            boolean var61BDCB47DC4581E06BB552238A25D6ED_550065763 = (pos < attributeCount && "encoding".equals(attributes[2 + 4]));
            {
                encoding = attributes[3 + 4];
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4D353DE97B84BC869440DBFEAB2495D7_1640692265 = (pos < attributeCount && "standalone".equals(attributes[4 * pos + 2]));
            {
                String st = attributes[3 + 4 * pos];
                {
                    boolean varFE7CCC805D774FAAB9193F9EB670EDC7_1761132430 = ("yes".equals(st));
                    {
                        standalone = Boolean.TRUE;
                    } //End block
                    {
                        boolean varFB2DD01E2CB481BE2D08953AF4F2267B_970874498 = ("no".equals(st));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.579 -0400", hash_original_method = "15C58CE8BC29A2518B63BEC83A754E2C", hash_generated_method = "F95F5FB434996733857F630A5B502C41")
    private String readComment(boolean returnText) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_625339757 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1450377249 = null; //Variable for return #2
        read(START_COMMENT);
        {
            varB4EAC82CA7396A68D541C85D26508E83_625339757 = readUntil(END_COMMENT, returnText);
        } //End block
        String commentText = readUntil(COMMENT_DOUBLE_DASH, returnText);
        {
            boolean varDEDEA312818AD0583FC7EE9661E09825_1428882551 = (peekCharacter() != '>');
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Comments may not contain --", this, null);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1450377249 = commentText;
        addTaint(returnText);
        String varA7E53CE21691AB073D9660D615818899_843734748; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_843734748 = varB4EAC82CA7396A68D541C85D26508E83_625339757;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_843734748 = varB4EAC82CA7396A68D541C85D26508E83_1450377249;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_843734748.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_843734748;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.579 -0400", hash_original_method = "39B79927E64E599404174E0314CB7C82", hash_generated_method = "DDEED7A01B20533C85C881162B1547AB")
    private void readDoctype(boolean saveDtdText) throws IOException, XmlPullParserException {
        read(START_DOCTYPE);
        int startPosition = -1;
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
                boolean varF62C1FC69328E5AC0EE954FE80231020_265335654 = (peekCharacter() == '[');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.580 -0400", hash_original_method = "5A46FF78EB6898EF0CABAC45E530C34E", hash_generated_method = "60CB7A76F7812C1CE383FAB86DBFA368")
    private boolean readExternalId(boolean requireSystemName, boolean assignFields) throws IOException, XmlPullParserException {
        skip();
        int c = peekCharacter();
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
            int delimiter = peekCharacter();
        } //End block
        {
            systemId = readQuotedId(true);
        } //End block
        {
            readQuotedId(false);
        } //End block
        addTaint(requireSystemName);
        addTaint(assignFields);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167414228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167414228;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.581 -0400", hash_original_method = "4B3A97D73E48F79754EA5A86D4C2409D", hash_generated_method = "39B8ACFCBC87EBE6D7598E862EB6B5FC")
    private String readQuotedId(boolean returnText) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_1103605042 = null; //Variable for return #1
        int quote = peekCharacter();
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
        varB4EAC82CA7396A68D541C85D26508E83_1103605042 = readUntil(delimiter, returnText);
        addTaint(returnText);
        varB4EAC82CA7396A68D541C85D26508E83_1103605042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1103605042;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.582 -0400", hash_original_method = "065EAF2A999BF53AAEE6E5D55221F190", hash_generated_method = "BF12BBA807369652735FF1E62420E215")
    private void readInternalSubset() throws IOException, XmlPullParserException {
        read('[');
        {
            skip();
            {
                boolean var6B07AFB8162EBC207136B3E0CBF1DCA1_780308636 = (peekCharacter() == ']');
            } //End collapsed parenthetic
            int declarationType = peekType(true);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.583 -0400", hash_original_method = "E2914311E18C41738022F5D7A73FEC8A", hash_generated_method = "B007A3013AF59F7ED63C93EACA164CDF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.584 -0400", hash_original_method = "A45115A32F8DEBE95546FC38EF8925EC", hash_generated_method = "2B3E24F87E159996A6DCC4628D090341")
    private void readContentSpec() throws IOException, XmlPullParserException {
        skip();
        int c = peekCharacter();
        {
            int depth = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.586 -0400", hash_original_method = "04CF7BEB7F762D6DB023733A3E9A3C83", hash_generated_method = "A5781235E2024AEB620155E6230742D1")
    private void readAttributeListDeclaration() throws IOException, XmlPullParserException {
        read(START_ATTLIST);
        skip();
        String elementName = readName();
        {
            skip();
            int c = peekCharacter();
            String attributeName = readName();
            skip();
            {
                boolean var3C74D199C82A09DCA88FADF6B9606194_1309896509 = (position + 1 >= limit && !fillBuffer(2));
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
                String value = readValue((char) c, true, true, ValueContext.ATTRIBUTE);
                defineAttributeDefault(elementName, attributeName, value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.589 -0400", hash_original_method = "CFB39B3ED48D8CD145E96E2E6FC1A186", hash_generated_method = "777670A84E6D6176489A28AC80148448")
    private void defineAttributeDefault(String elementName, String attributeName, String value) {
        {
            defaultAttributes = new HashMap<String, Map<String, String>>();
        } //End block
        Map<String, String> elementAttributes = defaultAttributes.get(elementName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.590 -0400", hash_original_method = "3ECF3BA7E150644C3EFC98E620B12B73", hash_generated_method = "0652AAA28A83706B40BC9FA21EA886D3")
    private void readEntityDeclaration() throws IOException, XmlPullParserException {
        read(START_ENTITY);
        boolean generalEntity = true;
        skip();
        {
            boolean varA3E57F3EA9CA6DD721B84564E023B708_1077493640 = (peekCharacter() == '%');
            {
                generalEntity = false;
                skip();
            } //End block
        } //End collapsed parenthetic
        String name = readName();
        skip();
        int quote = peekCharacter();
        String entityValue;
        {
            entityValue = readValue((char) quote, true, false, ValueContext.ENTITY_DECLARATION);
        } //End block
        {
            boolean var62304E14A0621CCB5A3B27C088EC2811_1616221074 = (readExternalId(true, false));
            {
                entityValue = "";
                skip();
                {
                    boolean varB155190189F97133258877F1A9544A2B_272793445 = (peekCharacter() == NDATA[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.591 -0400", hash_original_method = "0A96EF478D2162A2E48AFFA05F705C17", hash_generated_method = "BD6E8CD709909443732E496F844DEBFD")
    private void readNotationDeclaration() throws IOException, XmlPullParserException {
        read(START_NOTATION);
        skip();
        readName();
        {
            boolean var54889F641C80FD666AF09F21AFB2466E_1025602525 = (!readExternalId(false, false));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.592 -0400", hash_original_method = "8099A7EBC5B0B16E684058778DE6A29B", hash_generated_method = "3410BCE2AF38A996577AACC1400676B8")
    private void readEndTag() throws IOException, XmlPullParserException {
        read('<');
        read('/');
        name = readName();
        skip();
        read('>');
        int sp = (depth - 1) * 4;
        {
            checkRelaxed("read end tag " + name + " with no tags open");
            type = COMMENT;
        } //End block
        {
            boolean var8E76959AB88DB3EF43C8D0E037D778E4_358017098 = (name.equals(elementStack[sp + 3]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.593 -0400", hash_original_method = "06A44958C70A8BD5DE7481C49C8C3731", hash_generated_method = "81701726DA39DAFDF58CC76E5B0CB34C")
    private int peekType(boolean inDeclaration) throws IOException, XmlPullParserException {
        {
            boolean var5AB75DCE4678778E9ADB41C89957E4BF_2096412817 = (position >= limit && !fillBuffer(1));
        } //End collapsed parenthetic
        //Begin case '<' 
        {
            boolean var30933827E7DDA57720354AD908DB062A_1335241577 = (position + 3 >= limit && !fillBuffer(4));
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Dangling <", this, null);
            } //End block
        } //End collapsed parenthetic
        //End case '<' 
        //Begin case '<' 
        //Begin case '?' 
        {
            boolean var00D7AD3906D2C618F2C2332E5E32D79F_706299948 = ((position + 5 < limit || fillBuffer(6))
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961425338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961425338;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.616 -0400", hash_original_method = "2D33E593F3270AF80057D4A47B14E7B9", hash_generated_method = "CA5389DB856612BAA5224F47952D26D0")
    private void parseStartTag(boolean xmldecl, boolean throwOnResolveFailure) throws IOException, XmlPullParserException {
        {
            read('<');
        } //End block
        name = readName();
        attributeCount = 0;
        {
            skip();
            {
                boolean var6F89AB896FA639129948E99AFBABDE77_2130118742 = (position >= limit && !fillBuffer(1));
                {
                    checkRelaxed(UNEXPECTED_EOF);
                } //End block
            } //End collapsed parenthetic
            int c = buffer[position];
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
            String attrName = readName();
            int i = (attributeCount++) * 4;
            attributes = ensureCapacity(attributes, i + 4);
            attributes[i] = "";
            attributes[i + 1] = null;
            attributes[i + 2] = attrName;
            skip();
            {
                boolean var6F89AB896FA639129948E99AFBABDE77_592780299 = (position >= limit && !fillBuffer(1));
                {
                    checkRelaxed(UNEXPECTED_EOF);
                } //End block
            } //End collapsed parenthetic
            {
                skip();
                {
                    boolean var910B70164E5991D8BBB1C8DDE5598762_314638820 = (position >= limit && !fillBuffer(1));
                    {
                        checkRelaxed(UNEXPECTED_EOF);
                    } //End block
                } //End collapsed parenthetic
                char delimiter = buffer[position];
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
        int sp = depth++ * 4;
        elementStack = ensureCapacity(elementStack, sp + 4);
        elementStack[sp + 3] = name;
        {
            int[] bigger = new int[depth + 4];
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
            Map<String, String> elementDefaultAttributes = defaultAttributes.get(name);
            {
                {
                    Iterator<Map.Entry<String, String>> varF45E3F423B1D11A0BDD5925D2CFF679F_1834490942 = (elementDefaultAttributes.entrySet()).iterator();
                    varF45E3F423B1D11A0BDD5925D2CFF679F_1834490942.hasNext();
                    Map.Entry<String, String> entry = varF45E3F423B1D11A0BDD5925D2CFF679F_1834490942.next();
                    {
                        {
                            boolean var2B1ECF93F7854BA095E104AF20F9C785_1888861154 = (getAttributeValue(null, entry.getKey()) != null);
                        } //End collapsed parenthetic
                        int i = (attributeCount++) * 4;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.617 -0400", hash_original_method = "C79463E087C57C46760693ABFA80BBC0", hash_generated_method = "24FF71B7B8740807D408D26EEDF6D01A")
    private void readEntity(StringBuilder out, boolean isEntityToken, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        int start = out.length();
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        out.append('&');
        {
            int c = peekCharacter();
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
        String code = out.substring(start + 1, out.length() - 1);
        {
            name = code;
        } //End block
        {
            boolean varA99400345BFEEBA43EB55687A9AEA725_1298757829 = (code.startsWith("#"));
            {
                try 
                {
                    int c;
                    boolean var58B0B78C684DF351B34A140D544263D1_2003816525 = (code.startsWith("#x"));
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
        String defaultEntity = DEFAULT_ENTITIES.get(code);
        {
            out.delete(start, out.length());
            unresolved = false;
            out.append(defaultEntity);
        } //End block
        char[] resolved = null;
        {
            boolean var29EC81D908DBE184458A11C03BDBC90E_701732516 = (documentEntities != null && (resolved = documentEntities.get(code)) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.619 -0400", hash_original_method = "645533039846ABF2603AD0F9C774FE0D", hash_generated_method = "A7DC7FD921401E2BF5461F3F78DE6997")
    private String readValue(char delimiter, boolean resolveEntities, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_1803998986 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1358253131 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_812807162 = null; //Variable for return #3
        int start = position;
        StringBuilder result = null;
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
                    boolean varAA43907C5091E8F318632E4887CAA271_697051593 = (!fillBuffer(1));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1803998986 = result != null ? result.toString() : "";
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            char c = buffer[position];
            {
                isWhitespace &= (c <= ' ');
            } //End block
            {
                result = new StringBuilder();
            } //End block
            result.append(buffer, start, position - start);
            {
                {
                    boolean varB70DE06ED34E6674DB3722520CE86044_2106860499 = ((position + 1 < limit || fillBuffer(2)) && buffer[position + 1] == '\n');
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
                    boolean varBA78E9D6F2E1941F7D37C98C4AF2F15C_619075056 = ((position + 2 < limit || fillBuffer(3))
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
            varB4EAC82CA7396A68D541C85D26508E83_1358253131 = stringPool.get(buffer, start, position - start);
        } //End block
        {
            result.append(buffer, start, position - start);
            varB4EAC82CA7396A68D541C85D26508E83_812807162 = result.toString();
        } //End block
        addTaint(delimiter);
        addTaint(resolveEntities);
        addTaint(throwOnResolveFailure);
        addTaint(valueContext.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1756395231; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1756395231 = varB4EAC82CA7396A68D541C85D26508E83_1803998986;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1756395231 = varB4EAC82CA7396A68D541C85D26508E83_1358253131;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1756395231 = varB4EAC82CA7396A68D541C85D26508E83_812807162;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1756395231.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1756395231;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.620 -0400", hash_original_method = "3B69F4FA17F01509E096A0868A2528ED", hash_generated_method = "4046C5BB65956A087F14BE86B1E111AE")
    private void read(char expected) throws IOException, XmlPullParserException {
        int c = peekCharacter();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.620 -0400", hash_original_method = "A7E267F0C0CB0F12A0F03D9AFED00521", hash_generated_method = "2AA2E2E5AB11504EB6A6FAF4DDA3CF1D")
    private void read(char[] chars) throws IOException, XmlPullParserException {
        {
            boolean varF0C73BB22A111A22F22F5EA6FB28FE41_1455084334 = (position + chars.length >= limit && !fillBuffer(chars.length));
            {
                checkRelaxed("expected: '" + new String(chars) + "' but was EOF");
            } //End block
        } //End collapsed parenthetic
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.621 -0400", hash_original_method = "902B3F7EB34CE06CF1D7162085CB95DC", hash_generated_method = "382A235797F44898AA6487E514AB5506")
    private int peekCharacter() throws IOException, XmlPullParserException {
        {
            boolean varD13F14E52E697416613A9489283EE2CE_1971711562 = (position < limit || fillBuffer(1));
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672154441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672154441;
        // ---------- Original Method ----------
        //if (position < limit || fillBuffer(1)) {
            //return buffer[position];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.622 -0400", hash_original_method = "DC49987172506F0F8D59FF3F96E536A7", hash_generated_method = "176088E23BC5E99F5DBBB918F9AC7C4E")
    private boolean fillBuffer(int minimum) throws IOException, XmlPullParserException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Unbalanced entity!", this, null);
            } //End block
            popContentSource();
        } //End block
        {
            int i = 0;
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
            boolean var02F2209A5C0A570219740A85F11A9E73_1996366332 = ((total = reader.read(buffer, limit, buffer.length - limit)) != -1);
            {
                limit += total;
            } //End block
        } //End collapsed parenthetic
        addTaint(minimum);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766568424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766568424;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.624 -0400", hash_original_method = "35E0733B1286860BF21842013F8FFA5F", hash_generated_method = "873494AB71659A4111074A5E8AC3067B")
    private String readName() throws IOException, XmlPullParserException {
        String varB4EAC82CA7396A68D541C85D26508E83_148457987 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2126625807 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_664000813 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1701388021 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1642878642 = null; //Variable for return #5
        {
            boolean var5AB75DCE4678778E9ADB41C89957E4BF_1257975223 = (position >= limit && !fillBuffer(1));
            {
                checkRelaxed("name expected");
                varB4EAC82CA7396A68D541C85D26508E83_148457987 = "";
            } //End block
        } //End collapsed parenthetic
        int start = position;
        StringBuilder result = null;
        char c = buffer[position];
        {
            checkRelaxed("name expected");
            varB4EAC82CA7396A68D541C85D26508E83_2126625807 = "";
        } //End block
        {
            {
                {
                    result = new StringBuilder();
                } //End block
                result.append(buffer, start, position - start);
                {
                    boolean varAA43907C5091E8F318632E4887CAA271_930426411 = (!fillBuffer(1));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_664000813 = result.toString();
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            c = buffer[position];
            {
                varB4EAC82CA7396A68D541C85D26508E83_1701388021 = stringPool.get(buffer, start, position - start);
            } //End block
            {
                result.append(buffer, start, position - start);
                varB4EAC82CA7396A68D541C85D26508E83_1642878642 = result.toString();
            } //End block
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1830362584; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1830362584 = varB4EAC82CA7396A68D541C85D26508E83_148457987;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1830362584 = varB4EAC82CA7396A68D541C85D26508E83_2126625807;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1830362584 = varB4EAC82CA7396A68D541C85D26508E83_664000813;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1830362584 = varB4EAC82CA7396A68D541C85D26508E83_1701388021;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1830362584 = varB4EAC82CA7396A68D541C85D26508E83_1642878642;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1830362584.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1830362584;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.624 -0400", hash_original_method = "7FC6A162788F62EDDD44981BAC207FA9", hash_generated_method = "9786EFCBA4FAC87EDEB2CA21F02F76C8")
    private void skip() throws IOException, XmlPullParserException {
        {
            boolean varD13F14E52E697416613A9489283EE2CE_1162109047 = (position < limit || fillBuffer(1));
            {
                int c = buffer[position];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.625 -0400", hash_original_method = "46D251D7075E8F175BB5AD72794934F4", hash_generated_method = "4C430773194920E5CA624BD915A0A8AA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.626 -0400", hash_original_method = "EE8E194EE4DCB71C2C4B627C026D6CE3", hash_generated_method = "22E1EC58DD94904DE6F6129DF439700B")
    public void setInput(InputStream is, String charset) throws XmlPullParserException {
        position = 0;
        limit = 0;
        boolean detectCharset = (charset == null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        try 
        {
            {
                int firstFourBytes = 0;
                {
                    int i = is.read();
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
                        int i = is.read();
                        buffer[limit++] = (char) i;
                        {
                            String s = new String(buffer, 0, limit);
                            int i0 = s.indexOf("encoding");
                            {
                                {
                                    boolean var04641ED6560813F64D7639A6D959AB94_215623510 = (s.charAt(i0) != '"' && s.charAt(i0) != '\'');
                                } //End collapsed parenthetic
                                char deli = s.charAt(i0++);
                                int i1 = s.indexOf(deli, i0);
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
            int savedLimit = limit;
            setInput(new InputStreamReader(is, charset));
            encoding = charset;
            limit = savedLimit;
            {
                boolean varAF965EEEE2C7D4A402FB6EA7B231688A_735997764 = (!detectCharset && peekCharacter() == 0xfeff);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.627 -0400", hash_original_method = "7002CA433E430A52F3D361978C362AC4", hash_generated_method = "4F95296BF072C1901ACD47EA776B581F")
    public void close() throws IOException {
        {
            reader.close();
        } //End block
        // ---------- Original Method ----------
        //if (reader != null) {
            //reader.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.627 -0400", hash_original_method = "905F7B8816C5E28E92971A4DABCE5B48", hash_generated_method = "098B389075591B1D12FD897FE25E277E")
    public boolean getFeature(String feature) {
        {
            boolean var9760162B3F7AA5CCC8B91136021ACF54_780040206 = (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature));
            {
                boolean var019EFC6BD95914F8E676F56D5FDEF185_2125722643 = (FEATURE_RELAXED.equals(feature));
                {
                    boolean var824A1E488EAFEF118CCD0F5F4D56A2F4_2131057353 = (FEATURE_PROCESS_DOCDECL.equals(feature));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(feature.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472342750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472342750;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.627 -0400", hash_original_method = "A279F06C875438B49B8D4A1047D2C8F6", hash_generated_method = "5E9504F4C2A8643BEF3882A8752A78C8")
    public String getInputEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_873967183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_873967183 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_873967183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873967183;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.646 -0400", hash_original_method = "139FEB1FB1AC644E29BB2080E735DCAB", hash_generated_method = "2D419DAF154C6FB9FA633EA0D070C6D3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.647 -0400", hash_original_method = "88B98FA49BAB9563CCFD697035E35769", hash_generated_method = "88ABE4EA97B9D124CE28ED3BBF70479C")
    public Object getProperty(String property) {
        Object varB4EAC82CA7396A68D541C85D26508E83_502703979 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1918285356 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_792042245 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_715694573 = null; //Variable for return #4
        {
            boolean var2920F0278EE964B54E63A722B25AD531_127169773 = (property.equals(PROPERTY_XMLDECL_VERSION));
            {
                varB4EAC82CA7396A68D541C85D26508E83_502703979 = version;
            } //End block
            {
                boolean var01C081004E61C93BA248DD27C2FE455D_1768216352 = (property.equals(PROPERTY_XMLDECL_STANDALONE));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1918285356 = standalone;
                } //End block
                {
                    boolean var784BDB95B83DBD8BBC0FD2155AD4BFDB_1586118369 = (property.equals(PROPERTY_LOCATION));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_792042245 = location != null ? location : reader.toString();
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_715694573 = null;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(property.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1420008105; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1420008105 = varB4EAC82CA7396A68D541C85D26508E83_502703979;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1420008105 = varB4EAC82CA7396A68D541C85D26508E83_1918285356;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1420008105 = varB4EAC82CA7396A68D541C85D26508E83_792042245;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1420008105 = varB4EAC82CA7396A68D541C85D26508E83_715694573;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1420008105.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1420008105;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.647 -0400", hash_original_method = "9C3E6BF1FDA5FCF82C61137F91620CE9", hash_generated_method = "F134E496552B614A972C87617CDC2148")
    public String getRootElementName() {
        String varB4EAC82CA7396A68D541C85D26508E83_692600536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_692600536 = rootElementName;
        varB4EAC82CA7396A68D541C85D26508E83_692600536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_692600536;
        // ---------- Original Method ----------
        //return rootElementName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.648 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "B175E38C7FE4C56364B2AA91FE8873AB")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_518818713 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_518818713 = systemId;
        varB4EAC82CA7396A68D541C85D26508E83_518818713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_518818713;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.648 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "3CAC1ACD58DCE81553A10F819D01A1F8")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1388515415 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1388515415 = publicId;
        varB4EAC82CA7396A68D541C85D26508E83_1388515415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388515415;
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.649 -0400", hash_original_method = "2B7C16F8E90DF968275251B3375CC301", hash_generated_method = "FABCC1FF08C80DE2CD530D45143A7CC5")
    public int getNamespaceCount(int depth) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(depth);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400425312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400425312;
        // ---------- Original Method ----------
        //if (depth > this.depth) {
            //throw new IndexOutOfBoundsException();
        //}
        //return nspCounts[depth];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.649 -0400", hash_original_method = "DA805E6BD1FA77EA77FFD933A59A1A79", hash_generated_method = "19281228EB017388D91D4A5CD1AB2E75")
    public String getNamespacePrefix(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_368859048 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_368859048 = nspStack[pos * 2];
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_368859048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_368859048;
        // ---------- Original Method ----------
        //return nspStack[pos * 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.650 -0400", hash_original_method = "BEA3C6D36DAA76218F10B33482B7D86B", hash_generated_method = "74E47DFBD30E244519DBC86737CAD1EC")
    public String getNamespaceUri(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_577257655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_577257655 = nspStack[(pos * 2) + 1];
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_577257655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_577257655;
        // ---------- Original Method ----------
        //return nspStack[(pos * 2) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.650 -0400", hash_original_method = "40F39B6FC2CBEA065A6E595C0C377D56", hash_generated_method = "CA53CB27F8BB2605734A3F02213619D7")
    public String getNamespace(String prefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_973682807 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1480124096 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1904853807 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1303777549 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1574357960 = null; //Variable for return #5
        {
            boolean var56127411105EF3D71B9CCE5F0E40D652_1749257769 = ("xml".equals(prefix));
            {
                varB4EAC82CA7396A68D541C85D26508E83_973682807 = "http://www.w3.org/XML/1998/namespace";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var329E1608DCF39A88065813BCF90D4AD7_421605130 = ("xmlns".equals(prefix));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1480124096 = "http://www.w3.org/2000/xmlns/";
            } //End block
        } //End collapsed parenthetic
        {
            int i = (getNamespaceCount(depth) << 1) - 2;
            i -= 2;
            {
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1904853807 = nspStack[i + 1];
                    } //End block
                } //End block
                {
                    boolean var19919B58D04B466754D10E3F26461086_1158016303 = (prefix.equals(nspStack[i]));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1303777549 = nspStack[i + 1];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1574357960 = null;
        addTaint(prefix.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1408239221; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1408239221 = varB4EAC82CA7396A68D541C85D26508E83_973682807;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1408239221 = varB4EAC82CA7396A68D541C85D26508E83_1480124096;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1408239221 = varB4EAC82CA7396A68D541C85D26508E83_1904853807;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1408239221 = varB4EAC82CA7396A68D541C85D26508E83_1303777549;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1408239221 = varB4EAC82CA7396A68D541C85D26508E83_1574357960;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1408239221.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1408239221;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.651 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "62DC1984DE85DFA2C7552B3EE6AA3C42")
    public int getDepth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096995044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096995044;
        // ---------- Original Method ----------
        //return depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.652 -0400", hash_original_method = "B71BFE480A942DC6AFBA741559BFFBE0", hash_generated_method = "3147B287604421904361999DD07B83F5")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_959014245 = null; //Variable for return #1
        StringBuilder buf = new StringBuilder(type < TYPES.length ? TYPES[type] : "unknown");//DSFIXME:  CODE0008: Nested ternary operator in expression
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
            int cnt = attributeCount * 4;
            {
                int i = 0;
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
            String text = getText();
            {
                boolean varDAA30F2CB16032AE96BE08E6F6C22995_22265912 = (text.length() > 16);
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
        varB4EAC82CA7396A68D541C85D26508E83_959014245 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_959014245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_959014245;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.652 -0400", hash_original_method = "114340E3BA1FFC2D8A54D30C75AB06FF", hash_generated_method = "430115A31AA8EA70F2241DA84DCB8C1B")
    public int getLineNumber() {
        int result = bufferStartLine;
        {
            int i = 0;
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361579435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361579435;
        // ---------- Original Method ----------
        //int result = bufferStartLine;
        //for (int i = 0; i < position; i++) {
            //if (buffer[i] == '\n') {
                //result++;
            //}
        //}
        //return result + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.653 -0400", hash_original_method = "C138C40AD0ECD6D56D342D21687BD452", hash_generated_method = "03C726AD52DFFC6732370759A3E6E7EC")
    public int getColumnNumber() {
        int result = bufferStartColumn;
        {
            int i = 0;
            {
                {
                    result = 0;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829294301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829294301;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.653 -0400", hash_original_method = "152BCFAF579D72B6DEF962950FEC2A17", hash_generated_method = "F41BE299F0C794EE05DB8CC022B7BD45")
    public boolean isWhitespace() throws XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432262289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432262289;
        // ---------- Original Method ----------
        //if (type != TEXT && type != IGNORABLE_WHITESPACE && type != CDSECT) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return isWhitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.654 -0400", hash_original_method = "96BD4C193A5C47E4BA7EA81CE7C395CC", hash_generated_method = "C9DEAD4D80F076B73329F01B0091306B")
    public String getText() {
        String varB4EAC82CA7396A68D541C85D26508E83_1994209001 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1890919389 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1002754237 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1994209001 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1890919389 = "";
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1002754237 = text;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1718846556; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1718846556 = varB4EAC82CA7396A68D541C85D26508E83_1994209001;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1718846556 = varB4EAC82CA7396A68D541C85D26508E83_1890919389;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1718846556 = varB4EAC82CA7396A68D541C85D26508E83_1002754237;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1718846556.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1718846556;
        // ---------- Original Method ----------
        //if (type < TEXT || (type == ENTITY_REF && unresolved)) {
            //return null;
        //} else if (text == null) {
            //return "";
        //} else {
            //return text;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.654 -0400", hash_original_method = "17ADAF2C34EC5E5726D60154CDE0E31A", hash_generated_method = "A6B08FAB30E83DA2AFF339DB5F8E6EA7")
    public char[] getTextCharacters(int[] poslen) {
        String text = getText();
        {
            poslen[0] = -1;
            poslen[1] = -1;
        } //End block
        char[] result = text.toCharArray();
        poslen[0] = 0;
        poslen[1] = result.length;
        addTaint(poslen[0]);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_375379171 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_375379171;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.655 -0400", hash_original_method = "A99E1DDB500E37E7767EA602F963D96D", hash_generated_method = "859322EEDF0A508C20962CEE839E94BB")
    public String getNamespace() {
        String varB4EAC82CA7396A68D541C85D26508E83_375595497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_375595497 = namespace;
        varB4EAC82CA7396A68D541C85D26508E83_375595497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_375595497;
        // ---------- Original Method ----------
        //return namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.655 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "1F3247989C26D0BDF921317C3CC0EBF2")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1959632986 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1959632986 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1959632986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1959632986;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.655 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "6FC70EFA72859F95BE4B327C6522DF7A")
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_12069969 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_12069969 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_12069969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_12069969;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.656 -0400", hash_original_method = "BB5C193EDDCF2188F64023D36680FCC7", hash_generated_method = "DB6AD92208F74984A24C165E32A2CD4F")
    public boolean isEmptyElementTag() throws XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178910819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178910819;
        // ---------- Original Method ----------
        //if (type != START_TAG) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return degenerated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.656 -0400", hash_original_method = "E7902A71CF05159AEACA5707956D2FB0", hash_generated_method = "6A9FCE80A806BD91FB71B4B63756C8B8")
    public int getAttributeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980137345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980137345;
        // ---------- Original Method ----------
        //return attributeCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.656 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "2F870EA8A35ECA2293D878EE9A8004C7")
    public String getAttributeType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1655990737 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1655990737 = "CDATA";
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1655990737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1655990737;
        // ---------- Original Method ----------
        //return "CDATA";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.657 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "BA94413737696D24042C35DE0A666FAD")
    public boolean isAttributeDefault(int index) {
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436942390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436942390;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.657 -0400", hash_original_method = "1DC23C46494192E0CB67B725251C6942", hash_generated_method = "912559ABE5C9CC284344D2482724C841")
    public String getAttributeNamespace(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_747845998 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_747845998 = attributes[index * 4];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_747845998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_747845998;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[index * 4];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.658 -0400", hash_original_method = "07BD775DFF4E9B04837F88C1E2748FE1", hash_generated_method = "2AB60B88DA1016F5EA39E02C40953AD8")
    public String getAttributeName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1053898428 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1053898428 = attributes[(index * 4) + 2];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1053898428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053898428;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.658 -0400", hash_original_method = "C689E94E86EA5FE91ACCD87E01866231", hash_generated_method = "02CA41976578C492BE85DD51FA54FB66")
    public String getAttributePrefix(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1738071811 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1738071811 = attributes[(index * 4) + 1];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1738071811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1738071811;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.659 -0400", hash_original_method = "BF5E04E32ADD7672259D8C86F2C8D631", hash_generated_method = "C79843091E1F928A727705DB3174DB81")
    public String getAttributeValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1217563428 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1217563428 = attributes[(index * 4) + 3];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1217563428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217563428;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 3];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.660 -0400", hash_original_method = "D0AC7DE2A29C82DADA1B505288DAC27D", hash_generated_method = "2B5FA570D6291AF3F5D26BC0EDB1E929")
    public String getAttributeValue(String namespace, String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_356182318 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1594539869 = null; //Variable for return #2
        {
            int i = (attributeCount * 4) - 4;
            i -= 4;
            {
                {
                    boolean var47349E615B9664FECFB917121CFA114F_233657565 = (attributes[i + 2].equals(name)
                    && (namespace == null || attributes[i].equals(namespace)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_356182318 = attributes[i + 3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1594539869 = null;
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1018228318; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1018228318 = varB4EAC82CA7396A68D541C85D26508E83_356182318;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1018228318 = varB4EAC82CA7396A68D541C85D26508E83_1594539869;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1018228318.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1018228318;
        // ---------- Original Method ----------
        //for (int i = (attributeCount * 4) - 4; i >= 0; i -= 4) {
            //if (attributes[i + 2].equals(name)
                    //&& (namespace == null || attributes[i].equals(namespace))) {
                //return attributes[i + 3];
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.660 -0400", hash_original_method = "0457ED08CBFC1348E0AAA3CE0D692605", hash_generated_method = "DE4B2A3512D98AD967BF3BE654B4AC55")
    public int getEventType() throws XmlPullParserException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209694238 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209694238;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.661 -0400", hash_original_method = "53E7D5238284732F8540E3833F26B112", hash_generated_method = "96AAB8CDB6B84417935BB49B947B1037")
    public int nextTag() throws XmlPullParserException, IOException {
        next();
        {
            next();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("unexpected type", this, null);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540190203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540190203;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.662 -0400", hash_original_method = "C4BF1BB4C255F6013F5858579D851AD3", hash_generated_method = "995D617275784BA282903221DDF29525")
    public void require(int type, String namespace, String name) throws XmlPullParserException, IOException {
        {
            boolean varC944AD0162EFA3375CCB269661747DD7_806230026 = (type != this.type
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.662 -0400", hash_original_method = "102A6610D1A439DBBB62D3798FEF6670", hash_generated_method = "4AA558C84B9C54ED694A927AAD111731")
    public String nextText() throws XmlPullParserException, IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1030923458 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1030923458 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1030923458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1030923458;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.663 -0400", hash_original_method = "DD2B8D14469BF5F6853E930DFF62942D", hash_generated_method = "7A177963F1EF1EC055BECC9C80715A8B")
    public void setFeature(String feature, boolean value) throws XmlPullParserException {
        {
            boolean var9760162B3F7AA5CCC8B91136021ACF54_641083908 = (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature));
            {
                processNsp = value;
            } //End block
            {
                boolean varDAAE59AD80DC7E8FB2D89FCF61BDADCB_794465362 = (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(feature));
                {
                    processDocDecl = value;
                } //End block
                {
                    boolean varA1DC7E273DEAF4169FD3F94A9162735F_2144862114 = (FEATURE_RELAXED.equals(feature));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.663 -0400", hash_original_method = "BB78C28304FA5EA99DAD361D5123F3A6", hash_generated_method = "29386D0ED1763F1703926F3DE178414F")
    public void setProperty(String property, Object value) throws XmlPullParserException {
        {
            boolean varDDBF2C6AF46A27BDBAB0C7C42C7E43D3_453766351 = (property.equals(PROPERTY_LOCATION));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.664 -0400", hash_original_method = "8F280A3CDA5A3533C9FB5C99B2A6A6C2", hash_generated_method = "1875E14C2FF645B516B31839CE1AE2FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.664 -0400", hash_original_method = "E5A180E871F653CC9F75C9B7A9F73687", hash_generated_method = "AB3CB35729064AF57103D5354FFFA23D")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.664 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "7D21AAFF4A726AE51AF8BEE306E3B202")

        private ContentSource next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.664 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

        private char[] buffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.664 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

        private int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.664 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

        private int limit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_method = "BC47C2124096A91C278868E0B05F486C", hash_generated_method = "09A7E76D7B92EC6645E7074B8EFBBAF1")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "27B6834E590614C67E1B47148C9A08A7", hash_generated_field = "A55120855D0EB510239B6C4441F51AAE")

    private static final String PROPERTY_XMLDECL_VERSION = "http://xmlpull.org/v1/doc/properties.html#xmldecl-version";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "5768BD6E60DAB0B2B728E0D499DB1599", hash_generated_field = "6D51E873AB83378675CBD979DE182EFE")

    private static final String PROPERTY_XMLDECL_STANDALONE = "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "884227814336854467D95B8B62864403", hash_generated_field = "E4463FE3DABC66E04C600BDAC16EE7C5")

    private static final String PROPERTY_LOCATION = "http://xmlpull.org/v1/doc/properties.html#location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "34C1F6B518B9248A65D50F5DA60C6C55", hash_generated_field = "268A61AB07F8975416D95A6108614DB4")

    private static final String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "92D38954A36A7A130944D347C51A4750", hash_generated_field = "6DD1487BA02DCE058EBB56C6D00845DA")

    private static final Map<String, String> DEFAULT_ENTITIES = new HashMap<String, String>();
    static {
        DEFAULT_ENTITIES.put("lt", "<");
        DEFAULT_ENTITIES.put("gt", ">");
        DEFAULT_ENTITIES.put("amp", "&");
        DEFAULT_ENTITIES.put("apos", "'");
        DEFAULT_ENTITIES.put("quot", "\"");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "35DC4AA981D49C40AF5D8EB7E9F1117A", hash_generated_field = "9E004EC37549D77F0649D4ADE1AD1D11")

    private static final int ELEMENTDECL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "C8E8F601E56036BF41DED88DC4266A8D", hash_generated_field = "54F59956AE951C536E4F8B77591DDCD1")

    private static final int ENTITYDECL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "FC717574941501F4302EC29D3B65C1FF", hash_generated_field = "BC43E0FAC920F03CBC3B97B7F68A505D")

    private static final int ATTLISTDECL = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "6AA28C8E65834B07CFDECC56CC10645C", hash_generated_field = "72B9346B282549C68EFF4F9A4488493B")

    private static final int NOTATIONDECL = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "FE0875DD4DD3CE989B0A3D90742E5A5E", hash_generated_field = "4A097A0AA45CC4E364F7B6FC29BC31E4")

    private static final int PARAMETER_ENTITY_REF = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "E7BD4BF0DD03ED7F0C2CE63D25C4F342", hash_generated_field = "AE91905FCADB2F5F070BC3120FB7DF2B")

    private static final char[] START_COMMENT = { '<', '!', '-', '-' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "B022889C19E08B210036EBAFDCF3BF96", hash_generated_field = "B9C01DA88191BDFD088979E680871860")

    private static final char[] END_COMMENT = { '-', '-', '>' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "53D1CB8EB2CA2E3A088A616EE99463E8", hash_generated_field = "FF8AF1A2AC00395530E1421E331D4C1E")

    private static final char[] COMMENT_DOUBLE_DASH = { '-', '-' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "C0A15B2F83065A1DFC9027CE36A09E2D", hash_generated_field = "1F00DF0F8140B30091CAFD05256D4255")

    private static final char[] START_CDATA = { '<', '!', '[', 'C', 'D', 'A', 'T', 'A', '[' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "9187F94234DDBD50920C4C920C0BC3D1", hash_generated_field = "7E6AC8710E7F89251559D1CEBDE35997")

    private static final char[] END_CDATA = { ']', ']', '>' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "0057C89060DC30A0D3BCAD97306A9EA4", hash_generated_field = "DB90089C944C238022A155399F6C9774")

    private static final char[] START_PROCESSING_INSTRUCTION = { '<', '?' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "DA4C6A74263B1C7667F633E7F0A84E50", hash_generated_field = "E589BDD6193F766F275FA9034F35F5BD")

    private static final char[] END_PROCESSING_INSTRUCTION = { '?', '>' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "8A17DA7EFA39ACED7446B7874A7EC2A2", hash_generated_field = "EC707F57B4AC804FDD91FEAE1CA48143")

    private static final char[] START_DOCTYPE = { '<', '!', 'D', 'O', 'C', 'T', 'Y', 'P', 'E' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "38C3FB49D52D4A290C10B9F798EC30A0", hash_generated_field = "1953AEE3F130CEDFCF173BC749E8D74C")

    private static final char[] SYSTEM = { 'S', 'Y', 'S', 'T', 'E', 'M' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "2438362FD4A140D2147FEB110B4A6E5F", hash_generated_field = "1B9EE2198CFA65978EDAD9837C2D98E4")

    private static final char[] PUBLIC = { 'P', 'U', 'B', 'L', 'I', 'C' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "D68A738A9EA3A1C42717AF4857C99B99", hash_generated_field = "1E07434ACF3BAEC92793981CB62A1257")

    private static final char[] START_ELEMENT = { '<', '!', 'E', 'L', 'E', 'M', 'E', 'N', 'T' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "727399FD752E37162EF939B0657F7D60", hash_generated_field = "93647CCB1C4A3560B5811642ACC808E1")

    private static final char[] START_ATTLIST = { '<', '!', 'A', 'T', 'T', 'L', 'I', 'S', 'T' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "FA7B87FB313821079B341C73E6B33C55", hash_generated_field = "C13600C3B78CBE3E04176024A982C019")

    private static final char[] START_ENTITY = { '<', '!', 'E', 'N', 'T', 'I', 'T', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "CC3F4B8257AABBE89D84580F3628DEC1", hash_generated_field = "26DEA7BBC851381E3B051A614341C3A5")

    private static final char[] START_NOTATION = { '<', '!', 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "1D4BBC963EF8009B5C27B42A1BACB865", hash_generated_field = "CE5BBCD42C3BCD0FA21C3D08DE5E6A76")

    private static final char[] EMPTY = new char[] { 'E', 'M', 'P', 'T', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "03F8F742493275DA0383F42B3966CFE9", hash_generated_field = "8084EC1AE9BBB77E8C4CE487BFA97E84")

    private static final char[] ANY = new char[]{ 'A', 'N', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.665 -0400", hash_original_field = "2CBBE1148D5985E9C125F13280475FEA", hash_generated_field = "4DEDC0055F8730628487DF60C24AE644")

    private static final char[] NDATA = new char[]{ 'N', 'D', 'A', 'T', 'A' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "5399D5CD75FA12874AFE811CC79AACC9", hash_generated_field = "F8F98D147E42E5C73D61223E22989674")

    private static final char[] NOTATION = new char[]{ 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "7E6290A430CA851B556ABC7D34D8AD24", hash_generated_field = "36F47AE4877D288517520A35D94C23D0")

    private static final char[] REQUIRED = new char[] { 'R', 'E', 'Q', 'U', 'I', 'R', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "81F7575472B843CF7EA57A03A43E8109", hash_generated_field = "D9FA6B2501522578811C97ACB8DA0B4A")

    private static final char[] IMPLIED = new char[] { 'I', 'M', 'P', 'L', 'I', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "97889E011D3E83DBDEE52D4845C143AD", hash_generated_field = "D77E8DBC383CA9965DF66F0E9CBC458F")

    private static final char[] FIXED = new char[] { 'F', 'I', 'X', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "E20CB809E09D45606B87A49E30F6A337", hash_generated_field = "1DABD35C32510824D283D1E8D34D1E30")

    static final private String UNEXPECTED_EOF = "Unexpected EOF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "A39FC8F3BE9A750F49E5AC875DA0254A", hash_generated_field = "1DACE964DB2B3286A1F2AD099EF50C87")

    static final private String ILLEGAL_TYPE = "Wrong event type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "EE3EB445BB65E61F6C1827B6103FB153", hash_generated_field = "08E26EE9AE32DEA74B8044C2977B0BF5")

    static final private int XML_DECLARATION = 998;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "22D831D51410F2BFA15997AC55164E91", hash_generated_field = "FDBEB59450D649476077B2C45FE302BE")

    private static final char[] SINGLE_QUOTE = new char[] { '\'' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.666 -0400", hash_original_field = "98068AEE409DFDA084FFD71A3B03132A", hash_generated_field = "57CA247B64F06AAD2642685314F137D4")

    private static final char[] DOUBLE_QUOTE = new char[] { '"' };
}

