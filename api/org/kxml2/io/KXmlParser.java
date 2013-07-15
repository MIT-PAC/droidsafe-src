package org.kxml2.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "D5189DE027922F81005951E6EFE0EFD5", hash_generated_field = "CE74502D5DD419367E637D11E946AE48")

    private String location;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "B9C33225233D273951C807AA4A997C84")

    private String version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "083A7D1EBF6F499AF0C1B1BB489B4941", hash_generated_field = "F545B366D95421A9D0545B064DF3FA15")

    private Boolean standalone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "DFC84309889AC09133BB4E87BE34F708", hash_generated_field = "22BD78252C1771E229BD8814989F89D7")

    private String rootElementName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "61D7C74417362A394394F7DA60F28955", hash_generated_field = "6545B566A550C532A7353AE3BD57F4A5")

    private boolean processDocDecl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "09024CE37019EE47CD92BC3C6111FC3E", hash_generated_field = "769EB7E2763BBF503944F860A1BF2B53")

    private boolean processNsp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "81F32BE24A2A62FC472CC43EDC97E65B", hash_generated_field = "56D1CD4D0FE519DF4F93CCF1C262BFDF")

    private boolean relaxed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.008 -0400", hash_original_field = "C97F5F3194C1ED85A46851DB7EBD742D", hash_generated_field = "7273BF2007F6D9DA572D2E585776EE5B")

    private boolean keepNamespaceAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "B8BE629C2D9B6F6F9BBC8E2DF0B8DFE2", hash_generated_field = "7C254A9FE7EB03488648DE590A70B1E8")

    private StringBuilder bufferCapture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "22CADEBBDFDF70204FCDA053244BDAB4", hash_generated_field = "5EE5BD02D72D06CAAF4EF8E2D19E1135")

    private Map<String, char[]> documentEntities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "62676B93D1C3D8404C9C812ADC5F1C3A", hash_generated_field = "E290D91FC5BAFD29B00A44E1145FC9FB")

    private Map<String, Map<String, String>> defaultAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "55B1FBA4550114B730EDDC57888D99A6", hash_generated_field = "C38C16C38A66AC817AFDEB16F3AB2C79")

    private String[] elementStack = new String[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "74016F2E2E7F384872DF74677FF1C217", hash_generated_field = "9D1B39E20FB88BB665BD0F6B05D41FA2")

    private String[] nspStack = new String[8];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "59CAFBB511BF3C5D3EDE905B12C326C7", hash_generated_field = "167B18033DE59DDC6FAA031548884DC7")

    private int[] nspCounts = new int[4];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private Reader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "5AEFC22A591C854AAB5F4A44DD63608F", hash_generated_field = "B7F81B9E6E384492F57E569C80E0DE3A")

    private ContentSource nextContentSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "C7730CCE178204102E6E99312BA48AE2", hash_generated_field = "577EC909B068680E25766CC68FC4E0C4")

    private char[] buffer = new char[8192];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

    private int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "8D564E87D9CDB569F6C0D82D1566729D", hash_generated_field = "00F405BC8E12348750DA51A45F66E092")

    private int limit = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "197691A1D824E6BF0A4FDB37CD42DFBF", hash_generated_field = "ABCC56A72A2BAE75E77EB925AA857BA4")

    private int bufferStartLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "77D3912721282C90863775372B432626", hash_generated_field = "322559720B3F732E76842B5632DA7E78")

    private int bufferStartColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.009 -0400", hash_original_field = "FDBE2C32DE81904D31506233605042C8", hash_generated_field = "002F5A5E90D73E291F33E6C6294E8D20")

    private boolean isWhitespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "89801E9E98979062E84647433A8ED3E9", hash_generated_field = "E3760D072DB711CCBCD48E45C2700E12")

    private String namespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "7A9E06645D5CFC78D3F278D7A0157945")

    private String text;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "41E5137359BCC159984E1D58F1F76D16", hash_generated_field = "DBB8A6C14E3796CA3A469826B313EF12")

    private boolean degenerated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "BB16AB716A8B7609C0ECC6FB65BADCBC", hash_generated_field = "269E5A2AA1CB94A01698B537489DA5D4")

    private int attributeCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "DD7CEF9E81CAE57B34B30FA66B74E598", hash_generated_field = "569C94B11664DECEEFD3830A5970E18C")

    private String[] attributes = new String[16];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "CB5E100E5A9A3E7F6D1FD97512215282", hash_generated_field = "5A2A9A2BD7181810539A763573C1D6FB")

    private String error;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "8B371F13D7DE4300703DDB9173F6E8E6", hash_generated_field = "3CE0322C00553A852949CE941813EC46")

    private boolean unresolved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_field = "5D197505CD7E19C50091B8A2B5C9E1D2", hash_generated_field = "E6746676D26EF55819E689A7D8CBC54D")

    public final StringPool stringPool = new StringPool();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.010 -0400", hash_original_method = "010DAC0EB3331EDC25D05B4FF02298A9", hash_generated_method = "010DAC0EB3331EDC25D05B4FF02298A9")
    public KXmlParser ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.011 -0400", hash_original_method = "A527DEDBB8977F1D947B829D15DAACC5", hash_generated_method = "1634D7B912087B274B9C21F12413F3E3")
    public void keepNamespaceAttributes() {
        this.keepNamespaceAttributes = true;
        // ---------- Original Method ----------
        //this.keepNamespaceAttributes = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.013 -0400", hash_original_method = "F08928441827C23946744248151D18D9", hash_generated_method = "211EF4522C01DA71BD0B15A20A7E3534")
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
                    RuntimeException varED97AAB5843948CA47DCBF2C58EC51F0_1257266409 = new RuntimeException(
                            "illegal attribute name: " + attrName + " at " + this);
                    varED97AAB5843948CA47DCBF2C58EC51F0_1257266409.addTaint(taint);
                    throw varED97AAB5843948CA47DCBF2C58EC51F0_1257266409;
                } //End block
                else
    if(cut != -1)                
                {
                    String attrPrefix = attrName.substring(0, cut);
                    attrName = attrName.substring(cut + 1);
                    String attrNs = getNamespace(attrPrefix);
    if(attrNs == null && !relaxed)                    
                    {
                        RuntimeException varB9AFB5BE9C6FD0ABD6B99FD1168B2524_1709049132 = new RuntimeException(
                                "Undefined Prefix: " + attrPrefix + " in " + this);
                        varB9AFB5BE9C6FD0ABD6B99FD1168B2524_1709049132.addTaint(taint);
                        throw varB9AFB5BE9C6FD0ABD6B99FD1168B2524_1709049132;
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
        boolean var100B8CAD7CF2A56F6DF78F171F97A1EC_1005649565 = (any);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560883510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560883510;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.014 -0400", hash_original_method = "49B8B44C0E7574021385F3D8BD03186C", hash_generated_method = "73C2898B0D7A90C6D4AA8F87CE489F36")
    private String[] ensureCapacity(String[] arr, int required) {
        addTaint(required);
        addTaint(arr[0].getTaint());
    if(arr.length >= required)        
        {
String[] var9AD71BA773C278799FE3A7FBD26098B3_1388737501 =             arr;
            var9AD71BA773C278799FE3A7FBD26098B3_1388737501.addTaint(taint);
            return var9AD71BA773C278799FE3A7FBD26098B3_1388737501;
        } //End block
        String[] bigger = new String[required + 16];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
String[] varDA86C97D19AAB90DE46D3E10F1791C1F_2104226254 =         bigger;
        varDA86C97D19AAB90DE46D3E10F1791C1F_2104226254.addTaint(taint);
        return varDA86C97D19AAB90DE46D3E10F1791C1F_2104226254;
        // ---------- Original Method ----------
        //if (arr.length >= required) {
            //return arr;
        //}
        //String[] bigger = new String[required + 16];
        //System.arraycopy(arr, 0, bigger, 0, arr.length);
        //return bigger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.015 -0400", hash_original_method = "4A7BCCF6DFE9CB9D8E85D47BF7F54B1D", hash_generated_method = "3FC55F660F05A22148EE091F1D56FFA0")
    private void checkRelaxed(String errorMessage) throws XmlPullParserException {
    if(!relaxed)        
        {
            XmlPullParserException varF7F90359353F211275A8867F31AB1A82_261161522 = new XmlPullParserException(errorMessage, this, null);
            varF7F90359353F211275A8867F31AB1A82_261161522.addTaint(taint);
            throw varF7F90359353F211275A8867F31AB1A82_261161522;
        } //End block
    if(error == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.016 -0400", hash_original_method = "76E82C4E283B430F3EE1381EBB2709F7", hash_generated_method = "CDA2CA67502D29EE045BA81B9B1E4EAC")
    public int next() throws XmlPullParserException, IOException {
        int varC0EE87846FC78145B4BC7514BFB544D2_891028178 = (next(false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440558054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440558054;
        // ---------- Original Method ----------
        //return next(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.016 -0400", hash_original_method = "B3A65F7F837C14F73BB928D8BDFE9D91", hash_generated_method = "EBC455EF05F23B43C93232BD41553FB1")
    public int nextToken() throws XmlPullParserException, IOException {
        int varC0DF60F8FB8FC082186698EDB84E0827_201135285 = (next(true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135486227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_135486227;
        // ---------- Original Method ----------
        //return next(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.019 -0400", hash_original_method = "55251A1079E5B9F4E3B9F053CFE6FD44", hash_generated_method = "6AF000803E605A8682943475700A3B9B")
    private int next(boolean justOneToken) throws IOException, XmlPullParserException {
    if(reader == null)        
        {
            XmlPullParserException var4CF0DAF003AB8E43B9866AA41ADA04C7_147332196 = new XmlPullParserException("setInput() must be called first.", this, null);
            var4CF0DAF003AB8E43B9866AA41ADA04C7_147332196.addTaint(taint);
            throw var4CF0DAF003AB8E43B9866AA41ADA04C7_147332196;
        } //End block
    if(type == END_TAG)        
        {
            depth--;
        } //End block
    if(degenerated)        
        {
            degenerated = false;
            type = END_TAG;
            int var599DCCE2998A6B40B1E38E8C6006CB0A_1624240821 = (type);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927318969 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927318969;
        } //End block
    if(error != null)        
        {
    if(justOneToken)            
            {
                text = error;
                type = COMMENT;
                error = null;
                int var599DCCE2998A6B40B1E38E8C6006CB0A_147524887 = (type);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691767951 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691767951;
            } //End block
            else
            {
                error = null;
            } //End block
        } //End block
        type = peekType(false);
    if(type == XML_DECLARATION)        
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
        while
(true)        
        {
switch(type){
            case START_TAG:
            parseStartTag(false, throwOnResolveFailure);
            int var599DCCE2998A6B40B1E38E8C6006CB0A_239023267 = (type);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517102390 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517102390;
            case END_TAG:
            readEndTag();
            int var599DCCE2998A6B40B1E38E8C6006CB0A_558214901 = (type);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083285993 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083285993;
            case END_DOCUMENT:
            int var599DCCE2998A6B40B1E38E8C6006CB0A_1439378481 = (type);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439925179 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439925179;
            case ENTITY_REF:
    if(justOneToken)            
            {
                StringBuilder entityTextBuilder = new StringBuilder();
                readEntity(entityTextBuilder, true, throwOnResolveFailure, ValueContext.TEXT);
                text = entityTextBuilder.toString();
                break;
            } //End block
            case TEXT:
            text = readValue('<', !justOneToken, throwOnResolveFailure, ValueContext.TEXT);
    if(depth == 0 && isWhitespace)            
            {
                type = IGNORABLE_WHITESPACE;
            } //End block
            break;
            case CDSECT:
            read(START_CDATA);
            text = readUntil(END_CDATA, true);
            break;
            case COMMENT:
            String commentText = readComment(justOneToken);
    if(justOneToken)            
            {
                text = commentText;
            } //End block
            break;
            case PROCESSING_INSTRUCTION:
            read(START_PROCESSING_INSTRUCTION);
            String processingInstruction = readUntil(END_PROCESSING_INSTRUCTION, justOneToken);
    if(justOneToken)            
            {
                text = processingInstruction;
            } //End block
            break;
            case DOCDECL:
            readDoctype(justOneToken);
            break;
            default:
            XmlPullParserException var6568179198AC1CED0517BEE7BC41907C_74005436 = new XmlPullParserException("Unexpected token", this, null);
            var6568179198AC1CED0517BEE7BC41907C_74005436.addTaint(taint);
            throw var6568179198AC1CED0517BEE7BC41907C_74005436;
}    if(depth == 0 && (type == ENTITY_REF || type == TEXT || type == CDSECT))            
            {
                XmlPullParserException var6568179198AC1CED0517BEE7BC41907C_959932220 = new XmlPullParserException("Unexpected token", this, null);
                var6568179198AC1CED0517BEE7BC41907C_959932220.addTaint(taint);
                throw var6568179198AC1CED0517BEE7BC41907C_959932220;
            } //End block
    if(justOneToken)            
            {
                int var599DCCE2998A6B40B1E38E8C6006CB0A_1328743358 = (type);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139197815 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139197815;
            } //End block
    if(type == IGNORABLE_WHITESPACE)            
            {
                text = null;
            } //End block
            int peek = peekType(false);
    if(text != null && !text.isEmpty() && peek < TEXT)            
            {
                type = TEXT;
                int var599DCCE2998A6B40B1E38E8C6006CB0A_1013639660 = (type);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288655640 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288655640;
            } //End block
            type = peek;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.021 -0400", hash_original_method = "C492543C28BFA45A4A603454FE30EBBB", hash_generated_method = "3E5A3CB5022B537F77701C5B6E3E9174")
    private String readUntil(char[] delimiter, boolean returnText) throws IOException, XmlPullParserException {
        addTaint(returnText);
        int start = position;
        StringBuilder result = null;
    if(returnText && text != null)        
        {
            result = new StringBuilder();
            result.append(text);
        } //End block
    search        :
        while
(true)        
        {
    if(position + delimiter.length >= limit)            
            {
    if(start < position && returnText)                
                {
    if(result == null)                    
                    {
                        result = new StringBuilder();
                    } //End block
                    result.append(buffer, start, position - start);
                } //End block
    if(!fillBuffer(delimiter.length))                
                {
                    checkRelaxed(UNEXPECTED_EOF);
                    type = COMMENT;
String var540C13E9E156B687226421B24F2DF178_796900099 =                     null;
                    var540C13E9E156B687226421B24F2DF178_796900099.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_796900099;
                } //End block
                start = position;
            } //End block
for(int i = 0;i < delimiter.length;i++)
            {
    if(buffer[position + i] != delimiter[i])                
                {
                    position++;
                    continue search;
                } //End block
            } //End block
            break;
        } //End block
        int end = position;
        position += delimiter.length;
    if(!returnText)        
        {
String var540C13E9E156B687226421B24F2DF178_1502153014 =             null;
            var540C13E9E156B687226421B24F2DF178_1502153014.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1502153014;
        } //End block
        else
    if(result == null)        
        {
String varBBF641BD706477AE0FC4DD5EE67F18D3_220729326 =             stringPool.get(buffer, start, end - start);
            varBBF641BD706477AE0FC4DD5EE67F18D3_220729326.addTaint(taint);
            return varBBF641BD706477AE0FC4DD5EE67F18D3_220729326;
        } //End block
        else
        {
            result.append(buffer, start, end - start);
String varE65B3A02759122992CB82C0E651AD408_1741463049 =             result.toString();
            varE65B3A02759122992CB82C0E651AD408_1741463049.addTaint(taint);
            return varE65B3A02759122992CB82C0E651AD408_1741463049;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.022 -0400", hash_original_method = "79737DD70253BC976180BA8757B427A8", hash_generated_method = "61031D594469041A856CFF09E84624AA")
    private void readXmlDeclaration() throws IOException, XmlPullParserException {
    if(bufferStartLine != 0 || bufferStartColumn != 0 || position != 0)        
        {
            checkRelaxed("processing instructions must not start with xml");
        } //End block
        read(START_PROCESSING_INSTRUCTION);
        parseStartTag(true, true);
    if(attributeCount < 1 || !"version".equals(attributes[2]))        
        {
            checkRelaxed("version expected");
        } //End block
        version = attributes[3];
        int pos = 1;
    if(pos < attributeCount && "encoding".equals(attributes[2 + 4]))        
        {
            encoding = attributes[3 + 4];
            pos++;
        } //End block
    if(pos < attributeCount && "standalone".equals(attributes[4 * pos + 2]))        
        {
            String st = attributes[3 + 4 * pos];
    if("yes".equals(st))            
            {
                standalone = Boolean.TRUE;
            } //End block
            else
    if("no".equals(st))            
            {
                standalone = Boolean.FALSE;
            } //End block
            else
            {
                checkRelaxed("illegal standalone value: " + st);
            } //End block
            pos++;
        } //End block
    if(pos != attributeCount)        
        {
            checkRelaxed("unexpected attributes in XML declaration");
        } //End block
        isWhitespace = true;
        text = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.022 -0400", hash_original_method = "15C58CE8BC29A2518B63BEC83A754E2C", hash_generated_method = "0770F803744ADDF40B931175D7F0D21A")
    private String readComment(boolean returnText) throws IOException, XmlPullParserException {
        addTaint(returnText);
        read(START_COMMENT);
    if(relaxed)        
        {
String var00CC6E8910B870D548D0A77501AD6071_582262677 =             readUntil(END_COMMENT, returnText);
            var00CC6E8910B870D548D0A77501AD6071_582262677.addTaint(taint);
            return var00CC6E8910B870D548D0A77501AD6071_582262677;
        } //End block
        String commentText = readUntil(COMMENT_DOUBLE_DASH, returnText);
    if(peekCharacter() != '>')        
        {
            XmlPullParserException var3610F7DF0EB2F92D8BFAAAE51489E465_1643782436 = new XmlPullParserException("Comments may not contain --", this, null);
            var3610F7DF0EB2F92D8BFAAAE51489E465_1643782436.addTaint(taint);
            throw var3610F7DF0EB2F92D8BFAAAE51489E465_1643782436;
        } //End block
        position++;
String varE26F82105FF0C27B3E7345DB912CF13C_1103722027 =         commentText;
        varE26F82105FF0C27B3E7345DB912CF13C_1103722027.addTaint(taint);
        return varE26F82105FF0C27B3E7345DB912CF13C_1103722027;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.022 -0400", hash_original_method = "39B79927E64E599404174E0314CB7C82", hash_generated_method = "F41F536FD5EE3EC03341A915D8D502E9")
    private void readDoctype(boolean saveDtdText) throws IOException, XmlPullParserException {
        addTaint(saveDtdText);
        read(START_DOCTYPE);
        int startPosition = -1;
    if(saveDtdText)        
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
    if(peekCharacter() == '[')            
            {
                readInternalSubset();
            } //End block
            skip();
        } //End block
        finally 
        {
    if(saveDtdText)            
            {
                bufferCapture.append(buffer, 0, position);
                bufferCapture.delete(0, startPosition);
                text = bufferCapture.toString();
                bufferCapture = null;
            } //End block
        } //End block
        read('>');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.023 -0400", hash_original_method = "5A46FF78EB6898EF0CABAC45E530C34E", hash_generated_method = "B45F833D91C700E58DA8D109AD22EA2A")
    private boolean readExternalId(boolean requireSystemName, boolean assignFields) throws IOException, XmlPullParserException {
        addTaint(assignFields);
        addTaint(requireSystemName);
        skip();
        int c = peekCharacter();
    if(c == 'S')        
        {
            read(SYSTEM);
        } //End block
        else
    if(c == 'P')        
        {
            read(PUBLIC);
            skip();
    if(assignFields)            
            {
                publicId = readQuotedId(true);
            } //End block
            else
            {
                readQuotedId(false);
            } //End block
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1019323197 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785484713 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_785484713;
        } //End block
        skip();
    if(!requireSystemName)        
        {
            int delimiter = peekCharacter();
    if(delimiter != '"' && delimiter != '\'')            
            {
                boolean varB326B5062B2F0E69046810717534CB09_429721075 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439040698 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_439040698;
            } //End block
        } //End block
    if(assignFields)        
        {
            systemId = readQuotedId(true);
        } //End block
        else
        {
            readQuotedId(false);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1311631973 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647101174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647101174;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.023 -0400", hash_original_method = "4B3A97D73E48F79754EA5A86D4C2409D", hash_generated_method = "D1DC4193F9F0DF51C411F2010D28FAA0")
    private String readQuotedId(boolean returnText) throws IOException, XmlPullParserException {
        addTaint(returnText);
        int quote = peekCharacter();
        char[] delimiter;
    if(quote == '"')        
        {
            delimiter = DOUBLE_QUOTE;
        } //End block
        else
    if(quote == '\'')        
        {
            delimiter = SINGLE_QUOTE;
        } //End block
        else
        {
            XmlPullParserException var9958E51E6EA0EC4500213F257AE7D963_43555743 = new XmlPullParserException("Expected a quoted string", this, null);
            var9958E51E6EA0EC4500213F257AE7D963_43555743.addTaint(taint);
            throw var9958E51E6EA0EC4500213F257AE7D963_43555743;
        } //End block
        position++;
String varA5E0B5AD4D45D338445123EC5807E7E2_371238369 =         readUntil(delimiter, returnText);
        varA5E0B5AD4D45D338445123EC5807E7E2_371238369.addTaint(taint);
        return varA5E0B5AD4D45D338445123EC5807E7E2_371238369;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.023 -0400", hash_original_method = "065EAF2A999BF53AAEE6E5D55221F190", hash_generated_method = "660DB3B63EE7812DFBAAF2DFAF78D52B")
    private void readInternalSubset() throws IOException, XmlPullParserException {
        read('[');
        while
(true)        
        {
            skip();
    if(peekCharacter() == ']')            
            {
                position++;
                return;
            } //End block
            int declarationType = peekType(true);
switch(declarationType){
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
            XmlPullParserException varBD558B5E67DF3EEE9886DF18E457980F_143942969 = new XmlPullParserException(
                        "Parameter entity references are not supported", this, null);
            varBD558B5E67DF3EEE9886DF18E457980F_143942969.addTaint(taint);
            throw varBD558B5E67DF3EEE9886DF18E457980F_143942969;
            default:
            XmlPullParserException var6568179198AC1CED0517BEE7BC41907C_1162167142 = new XmlPullParserException("Unexpected token", this, null);
            var6568179198AC1CED0517BEE7BC41907C_1162167142.addTaint(taint);
            throw var6568179198AC1CED0517BEE7BC41907C_1162167142;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.023 -0400", hash_original_method = "E2914311E18C41738022F5D7A73FEC8A", hash_generated_method = "B007A3013AF59F7ED63C93EACA164CDF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.024 -0400", hash_original_method = "A45115A32F8DEBE95546FC38EF8925EC", hash_generated_method = "A95FDC38F471B6DE50D0A00DCF9D7F91")
    private void readContentSpec() throws IOException, XmlPullParserException {
        skip();
        int c = peekCharacter();
    if(c == '(')        
        {
            int depth = 0;
            do {
                {
    if(c == '(')                    
                    {
                        depth++;
                    } //End block
                    else
    if(c == ')')                    
                    {
                        depth--;
                    } //End block
                    position++;
                    c = peekCharacter();
                } //End block
} while (depth > 0);
    if(c == '*' || c == '?' || c == '+')            
            {
                position++;
            } //End block
        } //End block
        else
    if(c == EMPTY[0])        
        {
            read(EMPTY);
        } //End block
        else
    if(c == ANY[0])        
        {
            read(ANY);
        } //End block
        else
        {
            XmlPullParserException var0902E2A75BDFF4C07E24B65B174DABCB_387418687 = new XmlPullParserException("Expected element content spec", this, null);
            var0902E2A75BDFF4C07E24B65B174DABCB_387418687.addTaint(taint);
            throw var0902E2A75BDFF4C07E24B65B174DABCB_387418687;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.024 -0400", hash_original_method = "04CF7BEB7F762D6DB023733A3E9A3C83", hash_generated_method = "378887496B46E7FE1D4AC8617F3008D4")
    private void readAttributeListDeclaration() throws IOException, XmlPullParserException {
        read(START_ATTLIST);
        skip();
        String elementName = readName();
        while
(true)        
        {
            skip();
            int c = peekCharacter();
    if(c == '>')            
            {
                position++;
                return;
            } //End block
            String attributeName = readName();
            skip();
    if(position + 1 >= limit && !fillBuffer(2))            
            {
                XmlPullParserException varDFFB3FEA2AE02DD0180081583451C756_919468866 = new XmlPullParserException("Malformed attribute list", this, null);
                varDFFB3FEA2AE02DD0180081583451C756_919468866.addTaint(taint);
                throw varDFFB3FEA2AE02DD0180081583451C756_919468866;
            } //End block
    if(buffer[position] == NOTATION[0] && buffer[position + 1] == NOTATION[1])            
            {
                read(NOTATION);
                skip();
            } //End block
            c = peekCharacter();
    if(c == '(')            
            {
                position++;
                while
(true)                
                {
                    skip();
                    readName();
                    skip();
                    c = peekCharacter();
    if(c == ')')                    
                    {
                        position++;
                        break;
                    } //End block
                    else
    if(c == '|')                    
                    {
                        position++;
                    } //End block
                    else
                    {
                        XmlPullParserException var582CCDF2D68C7942DB58B35263B317FE_1191387508 = new XmlPullParserException("Malformed attribute type", this, null);
                        var582CCDF2D68C7942DB58B35263B317FE_1191387508.addTaint(taint);
                        throw var582CCDF2D68C7942DB58B35263B317FE_1191387508;
                    } //End block
                } //End block
            } //End block
            else
            {
                readName();
            } //End block
            skip();
            c = peekCharacter();
    if(c == '#')            
            {
                position++;
                c = peekCharacter();
    if(c == 'R')                
                {
                    read(REQUIRED);
                } //End block
                else
    if(c == 'I')                
                {
                    read(IMPLIED);
                } //End block
                else
    if(c == 'F')                
                {
                    read(FIXED);
                } //End block
                else
                {
                    XmlPullParserException var582CCDF2D68C7942DB58B35263B317FE_619348833 = new XmlPullParserException("Malformed attribute type", this, null);
                    var582CCDF2D68C7942DB58B35263B317FE_619348833.addTaint(taint);
                    throw var582CCDF2D68C7942DB58B35263B317FE_619348833;
                } //End block
                skip();
                c = peekCharacter();
            } //End block
    if(c == '"' || c == '\'')            
            {
                position++;
                String value = readValue((char) c, true, true, ValueContext.ATTRIBUTE);
                position++;
                defineAttributeDefault(elementName, attributeName, value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.025 -0400", hash_original_method = "CFB39B3ED48D8CD145E96E2E6FC1A186", hash_generated_method = "08B83FD8739A4555F12625400DB45B51")
    private void defineAttributeDefault(String elementName, String attributeName, String value) {
        addTaint(value.getTaint());
        addTaint(attributeName.getTaint());
        addTaint(elementName.getTaint());
    if(defaultAttributes == null)        
        {
            defaultAttributes = new HashMap<String, Map<String, String>>();
        } //End block
        Map<String, String> elementAttributes = defaultAttributes.get(elementName);
    if(elementAttributes == null)        
        {
            elementAttributes = new HashMap<String, String>();
            defaultAttributes.put(elementName, elementAttributes);
        } //End block
        elementAttributes.put(attributeName, value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.026 -0400", hash_original_method = "3ECF3BA7E150644C3EFC98E620B12B73", hash_generated_method = "EA434DC44C3A1390D674ADDE8C76296E")
    private void readEntityDeclaration() throws IOException, XmlPullParserException {
        read(START_ENTITY);
        boolean generalEntity = true;
        skip();
    if(peekCharacter() == '%')        
        {
            generalEntity = false;
            position++;
            skip();
        } //End block
        String name = readName();
        skip();
        int quote = peekCharacter();
        String entityValue;
    if(quote == '"' || quote == '\'')        
        {
            position++;
            entityValue = readValue((char) quote, true, false, ValueContext.ENTITY_DECLARATION);
            position++;
        } //End block
        else
    if(readExternalId(true, false))        
        {
            entityValue = "";
            skip();
    if(peekCharacter() == NDATA[0])            
            {
                read(NDATA);
                skip();
                readName();
            } //End block
        } //End block
        else
        {
            XmlPullParserException var97FE2DE75BA38352C45B5BAD5DDCF17C_1180593895 = new XmlPullParserException("Expected entity value or external ID", this, null);
            var97FE2DE75BA38352C45B5BAD5DDCF17C_1180593895.addTaint(taint);
            throw var97FE2DE75BA38352C45B5BAD5DDCF17C_1180593895;
        } //End block
    if(generalEntity && processDocDecl)        
        {
    if(documentEntities == null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.026 -0400", hash_original_method = "0A96EF478D2162A2E48AFFA05F705C17", hash_generated_method = "CD00CEA108B610113CF7194BD9C634CB")
    private void readNotationDeclaration() throws IOException, XmlPullParserException {
        read(START_NOTATION);
        skip();
        readName();
    if(!readExternalId(false, false))        
        {
            XmlPullParserException varDD7666CD6F88637B3702BD58D2E225DF_94804057 = new XmlPullParserException(
                    "Expected external ID or public ID for notation", this, null);
            varDD7666CD6F88637B3702BD58D2E225DF_94804057.addTaint(taint);
            throw varDD7666CD6F88637B3702BD58D2E225DF_94804057;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.027 -0400", hash_original_method = "8099A7EBC5B0B16E684058778DE6A29B", hash_generated_method = "8E0CB8C7452FF2A548E0A66952970A13")
    private void readEndTag() throws IOException, XmlPullParserException {
        read('<');
        read('/');
        name = readName();
        skip();
        read('>');
        int sp = (depth - 1) * 4;
    if(depth == 0)        
        {
            checkRelaxed("read end tag " + name + " with no tags open");
            type = COMMENT;
            return;
        } //End block
    if(name.equals(elementStack[sp + 3]))        
        {
            namespace = elementStack[sp];
            prefix = elementStack[sp + 1];
            name = elementStack[sp + 2];
        } //End block
        else
    if(!relaxed)        
        {
            XmlPullParserException var74E19E0F273201E17E5C777053489DFA_2080432125 = new XmlPullParserException(
                    "expected: /" + elementStack[sp + 3] + " read: " + name, this, null);
            var74E19E0F273201E17E5C777053489DFA_2080432125.addTaint(taint);
            throw var74E19E0F273201E17E5C777053489DFA_2080432125;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.027 -0400", hash_original_method = "06A44958C70A8BD5DE7481C49C8C3731", hash_generated_method = "1A75E335FE6D05FF66CBCFECC0390C02")
    private int peekType(boolean inDeclaration) throws IOException, XmlPullParserException {
        addTaint(inDeclaration);
    if(position >= limit && !fillBuffer(1))        
        {
            int var4620EC92A1E599503D1824B7D72639A9_1112487056 = (END_DOCUMENT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339945340 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339945340;
        } //End block
switch(buffer[position]){
        case '&':
        int var77EB38A526F13B944BE9FFA37C0D5C6A_965488086 = (ENTITY_REF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60684314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60684314;
        case '<':
    if(position + 3 >= limit && !fillBuffer(4))        
        {
            XmlPullParserException var3DFB54749ACACF9DD48E3182FCAC485A_189389433 = new XmlPullParserException("Dangling <", this, null);
            var3DFB54749ACACF9DD48E3182FCAC485A_189389433.addTaint(taint);
            throw var3DFB54749ACACF9DD48E3182FCAC485A_189389433;
        } //End block
switch(buffer[position + 1]){
        case '/':
        int varE4525DD614186FFA3EEBD69C3B4CC14E_236868025 = (END_TAG);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999028037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999028037;
        case '?':
    if((position + 5 < limit || fillBuffer(6))
                        && (buffer[position + 2] == 'x' || buffer[position + 2] == 'X')
                        && (buffer[position + 3] == 'm' || buffer[position + 3] == 'M')
                        && (buffer[position + 4] == 'l' || buffer[position + 4] == 'L')
                        && (buffer[position + 5] == ' '))        
        {
            int var2EC6BCD132BB17876F851855A88A4941_1291125691 = (XML_DECLARATION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329124395 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_329124395;
        } //End block
        else
        {
            int var5156999A1C0B07BE533189D5F7C5A86C_1356034151 = (PROCESSING_INSTRUCTION);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801756638 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801756638;
        } //End block
        case '!':
switch(buffer[position + 2]){
        case 'D':
        int varACD180C5343B2A605235BDB1C7A069EB_163284564 = (DOCDECL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699714993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699714993;
        case '[':
        int var7635479CC9F4D4758D7ED8055C312A7E_773510340 = (CDSECT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869910486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869910486;
        case '-':
        int varF2CD320B55767434DD48D81B165EA956_1430790788 = (COMMENT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645208228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645208228;
        case 'E':
switch(buffer[position + 3]){
        case 'L':
        int varBE8697966751F7F4D6FFEE2F907C1C81_2125135132 = (ELEMENTDECL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067392131 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067392131;
        case 'N':
        int var013B03788C6CF3E3D138B3C206B0F56F_489447598 = (ENTITYDECL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118521222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118521222;
}        break;
        case 'A':
        int varA9B539F846F1043BCE1BE4953F2B600A_277300402 = (ATTLISTDECL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386569216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386569216;
        case 'N':
        int var11B6D9B3CD4DC678645C4319DB375C4C_1988530752 = (NOTATIONDECL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134410736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134410736;
}        XmlPullParserException var48C2AA5CC9BAFB8BB35B95D2B58BB2AD_152815820 = new XmlPullParserException("Unexpected <!", this, null);
        var48C2AA5CC9BAFB8BB35B95D2B58BB2AD_152815820.addTaint(taint);
        throw var48C2AA5CC9BAFB8BB35B95D2B58BB2AD_152815820;
        default:
        int varCDD081A60D34AB12A59C7F1B56A2E485_1639161122 = (START_TAG);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282795457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282795457;
}        case '%':
        int varDB89C5251EFD661E2FD8A82EF1F30F88_47093329 = (inDeclaration ? PARAMETER_ENTITY_REF : TEXT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109764222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109764222;
        default:
        int var61A96FFCB251BB9BF0ABF8FEC19D0EA8_251045693 = (TEXT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533397404 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_533397404;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.029 -0400", hash_original_method = "2D33E593F3270AF80057D4A47B14E7B9", hash_generated_method = "E4DB1B5E5C3C101F48FF578468F46D0F")
    private void parseStartTag(boolean xmldecl, boolean throwOnResolveFailure) throws IOException, XmlPullParserException {
        addTaint(xmldecl);
    if(!xmldecl)        
        {
            read('<');
        } //End block
        name = readName();
        attributeCount = 0;
        while
(true)        
        {
            skip();
    if(position >= limit && !fillBuffer(1))            
            {
                checkRelaxed(UNEXPECTED_EOF);
                return;
            } //End block
            int c = buffer[position];
    if(xmldecl)            
            {
    if(c == '?')                
                {
                    position++;
                    read('>');
                    return;
                } //End block
            } //End block
            else
            {
    if(c == '/')                
                {
                    degenerated = true;
                    position++;
                    skip();
                    read('>');
                    break;
                } //End block
                else
    if(c == '>')                
                {
                    position++;
                    break;
                } //End block
            } //End block
            String attrName = readName();
            int i = (attributeCount++) * 4;
            attributes = ensureCapacity(attributes, i + 4);
            attributes[i] = "";
            attributes[i + 1] = null;
            attributes[i + 2] = attrName;
            skip();
    if(position >= limit && !fillBuffer(1))            
            {
                checkRelaxed(UNEXPECTED_EOF);
                return;
            } //End block
    if(buffer[position] == '=')            
            {
                position++;
                skip();
    if(position >= limit && !fillBuffer(1))                
                {
                    checkRelaxed(UNEXPECTED_EOF);
                    return;
                } //End block
                char delimiter = buffer[position];
    if(delimiter == '\'' || delimiter == '"')                
                {
                    position++;
                } //End block
                else
    if(relaxed)                
                {
                    delimiter = ' ';
                } //End block
                else
                {
                    XmlPullParserException var1392FFD2A9C3E00300A14C932038F2B8_2080811389 = new XmlPullParserException("attr value delimiter missing!", this, null);
                    var1392FFD2A9C3E00300A14C932038F2B8_2080811389.addTaint(taint);
                    throw var1392FFD2A9C3E00300A14C932038F2B8_2080811389;
                } //End block
                attributes[i + 3] = readValue(delimiter, true, throwOnResolveFailure,
                        ValueContext.ATTRIBUTE);
    if(delimiter != ' ')                
                {
                    position++;
                } //End block
            } //End block
            else
    if(relaxed)            
            {
                attributes[i + 3] = attrName;
            } //End block
            else
            {
                checkRelaxed("Attr.value missing f. " + attrName);
                attributes[i + 3] = attrName;
            } //End block
        } //End block
        int sp = depth++ * 4;
        elementStack = ensureCapacity(elementStack, sp + 4);
        elementStack[sp + 3] = name;
    if(depth >= nspCounts.length)        
        {
            int[] bigger = new int[depth + 4];
            System.arraycopy(nspCounts, 0, bigger, 0, nspCounts.length);
            nspCounts = bigger;
        } //End block
        nspCounts[depth] = nspCounts[depth - 1];
    if(processNsp)        
        {
            adjustNsp();
        } //End block
        else
        {
            namespace = "";
        } //End block
    if(defaultAttributes != null)        
        {
            Map<String, String> elementDefaultAttributes = defaultAttributes.get(name);
    if(elementDefaultAttributes != null)            
            {
for(Map.Entry<String, String> entry : elementDefaultAttributes.entrySet())
                {
    if(getAttributeValue(null, entry.getKey()) != null)                    
                    {
                        continue;
                    } //End block
                    int i = (attributeCount++) * 4;
                    attributes = ensureCapacity(attributes, i + 4);
                    attributes[i] = "";
                    attributes[i + 1] = null;
                    attributes[i + 2] = entry.getKey();
                    attributes[i + 3] = entry.getValue();
                } //End block
            } //End block
        } //End block
        elementStack[sp] = namespace;
        elementStack[sp + 1] = prefix;
        elementStack[sp + 2] = name;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.031 -0400", hash_original_method = "C79463E087C57C46760693ABFA80BBC0", hash_generated_method = "D36EFB71855490F6C8A3CB2506626AF0")
    private void readEntity(StringBuilder out, boolean isEntityToken, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        addTaint(valueContext.getTaint());
        addTaint(throwOnResolveFailure);
        addTaint(isEntityToken);
        addTaint(out.getTaint());
        int start = out.length();
    if(buffer[position++] != '&')        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1561056958 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1561056958.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1561056958;
        } //End block
        out.append('&');
        while
(true)        
        {
            int c = peekCharacter();
    if(c == ';')            
            {
                out.append(';');
                position++;
                break;
            } //End block
            else
    if(c >= 128
                    || (c >= '0' && c <= '9')
                    || (c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || c == '_'
                    || c == '-'
                    || c == '#')            
            {
                position++;
                out.append((char) c);
            } //End block
            else
    if(relaxed)            
            {
                return;
            } //End block
            else
            {
                XmlPullParserException varAB6FA04EF629B3C4ED1F39725CB5C59A_890455574 = new XmlPullParserException("unterminated entity ref", this, null);
                varAB6FA04EF629B3C4ED1F39725CB5C59A_890455574.addTaint(taint);
                throw varAB6FA04EF629B3C4ED1F39725CB5C59A_890455574;
            } //End block
        } //End block
        String code = out.substring(start + 1, out.length() - 1);
    if(isEntityToken)        
        {
            name = code;
        } //End block
    if(code.startsWith("#"))        
        {
            try 
            {
                int c = code.startsWith("#x")
                        ? Integer.parseInt(code.substring(2), 16)
                        : Integer.parseInt(code.substring(1));
                out.delete(start, out.length());
                out.appendCodePoint(c);
                unresolved = false;
                return;
            } //End block
            catch (NumberFormatException notANumber)
            {
                XmlPullParserException var11F315A97541D485B88EE83C2381B42D_1861350482 = new XmlPullParserException("Invalid character reference: &" + code);
                var11F315A97541D485B88EE83C2381B42D_1861350482.addTaint(taint);
                throw var11F315A97541D485B88EE83C2381B42D_1861350482;
            } //End block
            catch (IllegalArgumentException invalidCodePoint)
            {
                XmlPullParserException var11F315A97541D485B88EE83C2381B42D_49253060 = new XmlPullParserException("Invalid character reference: &" + code);
                var11F315A97541D485B88EE83C2381B42D_49253060.addTaint(taint);
                throw var11F315A97541D485B88EE83C2381B42D_49253060;
            } //End block
        } //End block
    if(valueContext == ValueContext.ENTITY_DECLARATION)        
        {
            return;
        } //End block
        String defaultEntity = DEFAULT_ENTITIES.get(code);
    if(defaultEntity != null)        
        {
            out.delete(start, out.length());
            unresolved = false;
            out.append(defaultEntity);
            return;
        } //End block
        char[] resolved;
    if(documentEntities != null && (resolved = documentEntities.get(code)) != null)        
        {
            out.delete(start, out.length());
            unresolved = false;
    if(processDocDecl)            
            {
                pushContentSource(resolved);
            } //End block
            else
            {
                out.append(resolved);
            } //End block
            return;
        } //End block
    if(systemId != null)        
        {
            out.delete(start, out.length());
            return;
        } //End block
        unresolved = true;
    if(throwOnResolveFailure)        
        {
            checkRelaxed("unresolved: &" + code + ";");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.032 -0400", hash_original_method = "645533039846ABF2603AD0F9C774FE0D", hash_generated_method = "3E8E26D5D6D740160A4D8F091B7ED47E")
    private String readValue(char delimiter, boolean resolveEntities, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        addTaint(valueContext.getTaint());
        addTaint(throwOnResolveFailure);
        addTaint(resolveEntities);
        addTaint(delimiter);
        int start = position;
        StringBuilder result = null;
    if(valueContext == ValueContext.TEXT && text != null)        
        {
            result = new StringBuilder();
            result.append(text);
        } //End block
        while
(true)        
        {
    if(position >= limit)            
            {
    if(start < position)                
                {
    if(result == null)                    
                    {
                        result = new StringBuilder();
                    } //End block
                    result.append(buffer, start, position - start);
                } //End block
    if(!fillBuffer(1))                
                {
String varB3E8B857398D63B539DB3DAF908624D5_77085470 =                     result != null ? result.toString() : "";
                    varB3E8B857398D63B539DB3DAF908624D5_77085470.addTaint(taint);
                    return varB3E8B857398D63B539DB3DAF908624D5_77085470;
                } //End block
                start = position;
            } //End block
            char c = buffer[position];
    if(c == delimiter
                    || (delimiter == ' ' && (c <= ' ' || c == '>'))
                    || c == '&' && !resolveEntities)            
            {
                break;
            } //End block
    if(c != '\r'
                    && (c != '\n' || valueContext != ValueContext.ATTRIBUTE)
                    && c != '&'
                    && c != '<'
                    && (c != ']' || valueContext != ValueContext.TEXT)
                    && (c != '%' || valueContext != ValueContext.ENTITY_DECLARATION))            
            {
                isWhitespace &= (c <= ' ');
                position++;
                continue;
            } //End block
    if(result == null)            
            {
                result = new StringBuilder();
            } //End block
            result.append(buffer, start, position - start);
    if(c == '\r')            
            {
    if((position + 1 < limit || fillBuffer(2)) && buffer[position + 1] == '\n')                
                {
                    position++;
                } //End block
                c = (valueContext == ValueContext.ATTRIBUTE) ? ' ' : '\n';
            } //End block
            else
    if(c == '\n')            
            {
                c = ' ';
            } //End block
            else
    if(c == '&')            
            {
                isWhitespace = false;
                readEntity(result, false, throwOnResolveFailure, valueContext);
                start = position;
                continue;
            } //End block
            else
    if(c == '<')            
            {
    if(valueContext == ValueContext.ATTRIBUTE)                
                {
                    checkRelaxed("Illegal: \"<\" inside attribute value");
                } //End block
                isWhitespace = false;
            } //End block
            else
    if(c == ']')            
            {
    if((position + 2 < limit || fillBuffer(3))
                        && buffer[position + 1] == ']' && buffer[position + 2] == '>')                
                {
                    checkRelaxed("Illegal: \"]]>\" outside CDATA section");
                } //End block
                isWhitespace = false;
            } //End block
            else
    if(c == '%')            
            {
                XmlPullParserException varCFB8CD41BB68E41ACD16317507A00885_1972455671 = new XmlPullParserException("This parser doesn't support parameter entities",
                        this, null);
                varCFB8CD41BB68E41ACD16317507A00885_1972455671.addTaint(taint);
                throw varCFB8CD41BB68E41ACD16317507A00885_1972455671;
            } //End block
            else
            {
                AssertionError varA81442E36297E737EB908877E58260E8_663471216 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_663471216.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_663471216;
            } //End block
            position++;
            result.append(c);
            start = position;
        } //End block
    if(result == null)        
        {
String var71E646E551E14CBAFAEFFF0085BD89CB_394122856 =             stringPool.get(buffer, start, position - start);
            var71E646E551E14CBAFAEFFF0085BD89CB_394122856.addTaint(taint);
            return var71E646E551E14CBAFAEFFF0085BD89CB_394122856;
        } //End block
        else
        {
            result.append(buffer, start, position - start);
String varE65B3A02759122992CB82C0E651AD408_1607249982 =             result.toString();
            varE65B3A02759122992CB82C0E651AD408_1607249982.addTaint(taint);
            return varE65B3A02759122992CB82C0E651AD408_1607249982;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.033 -0400", hash_original_method = "3B69F4FA17F01509E096A0868A2528ED", hash_generated_method = "A9EF75823E082D4A1604DF904C2F3187")
    private void read(char expected) throws IOException, XmlPullParserException {
        addTaint(expected);
        int c = peekCharacter();
    if(c != expected)        
        {
            checkRelaxed("expected: '" + expected + "' actual: '" + ((char) c) + "'");
        } //End block
        position++;
        // ---------- Original Method ----------
        //int c = peekCharacter();
        //if (c != expected) {
            //checkRelaxed("expected: '" + expected + "' actual: '" + ((char) c) + "'");
        //}
        //position++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.033 -0400", hash_original_method = "A7E267F0C0CB0F12A0F03D9AFED00521", hash_generated_method = "3A1D8EA9D7D4C423DE4EA39E63098311")
    private void read(char[] chars) throws IOException, XmlPullParserException {
    if(position + chars.length >= limit && !fillBuffer(chars.length))        
        {
            checkRelaxed("expected: '" + new String(chars) + "' but was EOF");
            return;
        } //End block
for(int i = 0;i < chars.length;i++)
        {
    if(buffer[position + i] != chars[i])            
            {
                checkRelaxed("expected: \"" + new String(chars) + "\" but was \""
                        + new String(buffer, position, chars.length) + "...\"");
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.033 -0400", hash_original_method = "902B3F7EB34CE06CF1D7162085CB95DC", hash_generated_method = "91D30B726AFF484547D06C82F649780D")
    private int peekCharacter() throws IOException, XmlPullParserException {
    if(position < limit || fillBuffer(1))        
        {
            int varC10F61EE85ECF5D0D12BB992411DA83D_591318793 = (buffer[position]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055255130 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055255130;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_334354574 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936332274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936332274;
        // ---------- Original Method ----------
        //if (position < limit || fillBuffer(1)) {
            //return buffer[position];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.034 -0400", hash_original_method = "DC49987172506F0F8D59FF3F96E536A7", hash_generated_method = "AE6ECC1A5A1EFC73ECB1A1362A530A80")
    private boolean fillBuffer(int minimum) throws IOException, XmlPullParserException {
        addTaint(minimum);
        while
(nextContentSource != null)        
        {
    if(position < limit)            
            {
                XmlPullParserException var6DCA400C07A1C497A37665E832C66BCE_1620997478 = new XmlPullParserException("Unbalanced entity!", this, null);
                var6DCA400C07A1C497A37665E832C66BCE_1620997478.addTaint(taint);
                throw var6DCA400C07A1C497A37665E832C66BCE_1620997478;
            } //End block
            popContentSource();
    if(limit - position >= minimum)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_238090468 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_165431797 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_165431797;
            } //End block
        } //End block
for(int i = 0;i < position;i++)
        {
    if(buffer[i] == '\n')            
            {
                bufferStartLine++;
                bufferStartColumn = 0;
            } //End block
            else
            {
                bufferStartColumn++;
            } //End block
        } //End block
    if(bufferCapture != null)        
        {
            bufferCapture.append(buffer, 0, position);
        } //End block
    if(limit != position)        
        {
            limit -= position;
            System.arraycopy(buffer, position, buffer, 0, limit);
        } //End block
        else
        {
            limit = 0;
        } //End block
        position = 0;
        int total;
        while
((total = reader.read(buffer, limit, buffer.length - limit)) != -1)        
        {
            limit += total;
    if(limit >= minimum)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1635887862 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773181299 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773181299;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1467799907 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1762093906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1762093906;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.035 -0400", hash_original_method = "35E0733B1286860BF21842013F8FFA5F", hash_generated_method = "EB4869A10E80304669A37306B3E13865")
    private String readName() throws IOException, XmlPullParserException {
    if(position >= limit && !fillBuffer(1))        
        {
            checkRelaxed("name expected");
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1658643557 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1658643557.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1658643557;
        } //End block
        int start = position;
        StringBuilder result = null;
        char c = buffer[position];
    if((c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')
                || c == '_'
                || c == ':'
                || c >= '\u00c0' 
                || relaxed)        
        {
            position++;
        } //End block
        else
        {
            checkRelaxed("name expected");
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_557832359 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_557832359.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_557832359;
        } //End block
        while
(true)        
        {
    if(position >= limit)            
            {
    if(result == null)                
                {
                    result = new StringBuilder();
                } //End block
                result.append(buffer, start, position - start);
    if(!fillBuffer(1))                
                {
String varE65B3A02759122992CB82C0E651AD408_759842393 =                     result.toString();
                    varE65B3A02759122992CB82C0E651AD408_759842393.addTaint(taint);
                    return varE65B3A02759122992CB82C0E651AD408_759842393;
                } //End block
                start = position;
            } //End block
            c = buffer[position];
    if((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
                    || c == '_'
                    || c == '-'
                    || c == ':'
                    || c == '.'
                    || c >= '\u00b7')            
            {
                position++;
                continue;
            } //End block
    if(result == null)            
            {
String var71E646E551E14CBAFAEFFF0085BD89CB_1343851758 =                 stringPool.get(buffer, start, position - start);
                var71E646E551E14CBAFAEFFF0085BD89CB_1343851758.addTaint(taint);
                return var71E646E551E14CBAFAEFFF0085BD89CB_1343851758;
            } //End block
            else
            {
                result.append(buffer, start, position - start);
String varE65B3A02759122992CB82C0E651AD408_283578567 =                 result.toString();
                varE65B3A02759122992CB82C0E651AD408_283578567.addTaint(taint);
                return varE65B3A02759122992CB82C0E651AD408_283578567;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.035 -0400", hash_original_method = "7FC6A162788F62EDDD44981BAC207FA9", hash_generated_method = "8876F0C598145F0C5EF9046CFF874628")
    private void skip() throws IOException, XmlPullParserException {
        while
(position < limit || fillBuffer(1))        
        {
            int c = buffer[position];
    if(c > ' ')            
            {
                break;
            } //End block
            position++;
        } //End block
        // ---------- Original Method ----------
        //while (position < limit || fillBuffer(1)) {
            //int c = buffer[position];
            //if (c > ' ') {
                //break;
            //}
            //position++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.036 -0400", hash_original_method = "46D251D7075E8F175BB5AD72794934F4", hash_generated_method = "7263440324760450D6FF789C509F096B")
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
    if(reader == null)        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.037 -0400", hash_original_method = "EE8E194EE4DCB71C2C4B627C026D6CE3", hash_generated_method = "FB87AB07195E6B8E4C199ADA80D5BC59")
    public void setInput(InputStream is, String charset) throws XmlPullParserException {
        addTaint(is.getTaint());
        position = 0;
        limit = 0;
        boolean detectCharset = (charset == null);
    if(is == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_42003105 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_42003105.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_42003105;
        } //End block
        try 
        {
    if(detectCharset)            
            {
                int firstFourBytes = 0;
                while
(limit < 4)                
                {
                    int i = is.read();
    if(i == -1)                    
                    {
                        break;
                    } //End block
                    firstFourBytes = (firstFourBytes << 8) | i;
                    buffer[limit++] = (char) i;
                } //End block
    if(limit == 4)                
                {
switch(firstFourBytes){
                    case 0x00000FEFF:
                    charset = "UTF-32BE";
                    limit = 0;
                    break;
                    case 0x0FFFE0000:
                    charset = "UTF-32LE";
                    limit = 0;
                    break;
                    case 0x0000003c:
                    charset = "UTF-32BE";
                    buffer[0] = '<';
                    limit = 1;
                    break;
                    case 0x03c000000:
                    charset = "UTF-32LE";
                    buffer[0] = '<';
                    limit = 1;
                    break;
                    case 0x0003c003f:
                    charset = "UTF-16BE";
                    buffer[0] = '<';
                    buffer[1] = '?';
                    limit = 2;
                    break;
                    case 0x03c003f00:
                    charset = "UTF-16LE";
                    buffer[0] = '<';
                    buffer[1] = '?';
                    limit = 2;
                    break;
                    case 0x03c3f786d:
                    while
(true)                    
                    {
                        int i = is.read();
    if(i == -1)                        
                        {
                            break;
                        } //End block
                        buffer[limit++] = (char) i;
    if(i == '>')                        
                        {
                            String s = new String(buffer, 0, limit);
                            int i0 = s.indexOf("encoding");
    if(i0 != -1)                            
                            {
                                while
(s.charAt(i0) != '"' && s.charAt(i0) != '\'')                                
                                {
                                    i0++;
                                } //End block
                                char deli = s.charAt(i0++);
                                int i1 = s.indexOf(deli, i0);
                                charset = s.substring(i0, i1);
                            } //End block
                            break;
                        } //End block
                    } //End block
                    break;
                    default:
    if((firstFourBytes & 0x0ffff0000) == 0x0feff0000)                    
                    {
                        charset = "UTF-16BE";
                        buffer[0] = (char) ((buffer[2] << 8) | buffer[3]);
                        limit = 1;
                    } //End block
                    else
    if((firstFourBytes & 0x0ffff0000) == 0x0fffe0000)                    
                    {
                        charset = "UTF-16LE";
                        buffer[0] = (char) ((buffer[3] << 8) | buffer[2]);
                        limit = 1;
                    } //End block
                    else
    if((firstFourBytes & 0x0ffffff00) == 0x0efbbbf00)                    
                    {
                        charset = "UTF-8";
                        buffer[0] = buffer[3];
                        limit = 1;
                    } //End block
}
                } //End block
            } //End block
    if(charset == null)            
            {
                charset = "UTF-8";
            } //End block
            int savedLimit = limit;
            setInput(new InputStreamReader(is, charset));
            encoding = charset;
            limit = savedLimit;
    if(!detectCharset && peekCharacter() == 0xfeff)            
            {
                limit--;
                System.arraycopy(buffer, 1, buffer, 0, limit);
            } //End block
        } //End block
        catch (Exception e)
        {
            XmlPullParserException var5115E6D99501005DD169C20F2FC34568_202632366 = new XmlPullParserException("Invalid stream or encoding: " + e, this, e);
            var5115E6D99501005DD169C20F2FC34568_202632366.addTaint(taint);
            throw var5115E6D99501005DD169C20F2FC34568_202632366;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.038 -0400", hash_original_method = "7002CA433E430A52F3D361978C362AC4", hash_generated_method = "D148927CB23E349D078977E02C4EE53A")
    public void close() throws IOException {
    if(reader != null)        
        {
            reader.close();
        } //End block
        // ---------- Original Method ----------
        //if (reader != null) {
            //reader.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.038 -0400", hash_original_method = "905F7B8816C5E28E92971A4DABCE5B48", hash_generated_method = "A8D7B80EDFC2CACD1E34599757A4689D")
    public boolean getFeature(String feature) {
        addTaint(feature.getTaint());
    if(XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature))        
        {
            boolean var09024CE37019EE47CD92BC3C6111FC3E_1121513538 = (processNsp);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1727032816 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1727032816;
        } //End block
        else
    if(FEATURE_RELAXED.equals(feature))        
        {
            boolean var81F32BE24A2A62FC472CC43EDC97E65B_1389527403 = (relaxed);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573762744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_573762744;
        } //End block
        else
    if(FEATURE_PROCESS_DOCDECL.equals(feature))        
        {
            boolean var61D7C74417362A394394F7DA60F28955_911517181 = (processDocDecl);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676381929 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_676381929;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1224432952 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394126119 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394126119;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.038 -0400", hash_original_method = "A279F06C875438B49B8D4A1047D2C8F6", hash_generated_method = "A0B37AB5E18FD13F29E051A23642F2C8")
    public String getInputEncoding() {
String varE424DD5E6E58EB63E1272B71B5A81966_1325654914 =         encoding;
        varE424DD5E6E58EB63E1272B71B5A81966_1325654914.addTaint(taint);
        return varE424DD5E6E58EB63E1272B71B5A81966_1325654914;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.039 -0400", hash_original_method = "139FEB1FB1AC644E29BB2080E735DCAB", hash_generated_method = "B9D33CFD21A2ADCBF5ABC35159474074")
    public void defineEntityReplacementText(String entity, String value) throws XmlPullParserException {
        addTaint(value.getTaint());
        addTaint(entity.getTaint());
    if(processDocDecl)        
        {
            IllegalStateException var4CC0DDC3E31B5D70BD0EC7E6B6D64CF1_814345312 = new IllegalStateException(
                    "Entity replacement text may not be defined with DOCTYPE processing enabled.");
            var4CC0DDC3E31B5D70BD0EC7E6B6D64CF1_814345312.addTaint(taint);
            throw var4CC0DDC3E31B5D70BD0EC7E6B6D64CF1_814345312;
        } //End block
    if(reader == null)        
        {
            IllegalStateException var612298139D745C579CB4AF9E1D11E154_1065194536 = new IllegalStateException(
                    "Entity replacement text must be defined after setInput()");
            var612298139D745C579CB4AF9E1D11E154_1065194536.addTaint(taint);
            throw var612298139D745C579CB4AF9E1D11E154_1065194536;
        } //End block
    if(documentEntities == null)        
        {
            documentEntities = new HashMap<String, char[]>();
        } //End block
        documentEntities.put(entity, value.toCharArray());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.039 -0400", hash_original_method = "88B98FA49BAB9563CCFD697035E35769", hash_generated_method = "A713039817CF13FFADF1318B2858CDF2")
    public Object getProperty(String property) {
        addTaint(property.getTaint());
    if(property.equals(PROPERTY_XMLDECL_VERSION))        
        {
Object varE87BEFBC04DA371DFA5B07C77A4407CB_409025344 =             version;
            varE87BEFBC04DA371DFA5B07C77A4407CB_409025344.addTaint(taint);
            return varE87BEFBC04DA371DFA5B07C77A4407CB_409025344;
        } //End block
        else
    if(property.equals(PROPERTY_XMLDECL_STANDALONE))        
        {
Object var0A92F512F6C388B59F324CF6065C09B7_227671636 =             standalone;
            var0A92F512F6C388B59F324CF6065C09B7_227671636.addTaint(taint);
            return var0A92F512F6C388B59F324CF6065C09B7_227671636;
        } //End block
        else
    if(property.equals(PROPERTY_LOCATION))        
        {
Object var6A827605B4DF9F7656BD024AEBD8048A_933334601 =             location != null ? location : reader.toString();
            var6A827605B4DF9F7656BD024AEBD8048A_933334601.addTaint(taint);
            return var6A827605B4DF9F7656BD024AEBD8048A_933334601;
        } //End block
        else
        {
Object var540C13E9E156B687226421B24F2DF178_1940929005 =             null;
            var540C13E9E156B687226421B24F2DF178_1940929005.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1940929005;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.039 -0400", hash_original_method = "9C3E6BF1FDA5FCF82C61137F91620CE9", hash_generated_method = "A4571504006C487C0EBDA26861C2605E")
    public String getRootElementName() {
String var6D4B8E852BD53E9EF524EDC454541154_113058373 =         rootElementName;
        var6D4B8E852BD53E9EF524EDC454541154_113058373.addTaint(taint);
        return var6D4B8E852BD53E9EF524EDC454541154_113058373;
        // ---------- Original Method ----------
        //return rootElementName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.039 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "27D6E5A543D17F0E0101F9062EF15649")
    public String getSystemId() {
String varB7D0727ACC7388EA86587212DD1C6E9F_803900981 =         systemId;
        varB7D0727ACC7388EA86587212DD1C6E9F_803900981.addTaint(taint);
        return varB7D0727ACC7388EA86587212DD1C6E9F_803900981;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.039 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "32684470E7AE6FA56824D4FDEB230548")
    public String getPublicId() {
String var76991CCBEF027A0871CF61642EBA53AB_1862987416 =         publicId;
        var76991CCBEF027A0871CF61642EBA53AB_1862987416.addTaint(taint);
        return var76991CCBEF027A0871CF61642EBA53AB_1862987416;
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.039 -0400", hash_original_method = "2B7C16F8E90DF968275251B3375CC301", hash_generated_method = "99C6C8A2B9D975F4FAADCF60B091B003")
    public int getNamespaceCount(int depth) {
        addTaint(depth);
    if(depth > this.depth)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_369571677 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_369571677.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_369571677;
        } //End block
        int varD4EAE5957398257BA2774804216EDCA8_515507764 = (nspCounts[depth]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445529385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445529385;
        // ---------- Original Method ----------
        //if (depth > this.depth) {
            //throw new IndexOutOfBoundsException();
        //}
        //return nspCounts[depth];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.040 -0400", hash_original_method = "DA805E6BD1FA77EA77FFD933A59A1A79", hash_generated_method = "CA888D0EC1D9A2AAAE02FC7E67C49040")
    public String getNamespacePrefix(int pos) {
        addTaint(pos);
String var28DD094C4A269FA6BE7EA94910B6C125_217693388 =         nspStack[pos * 2];
        var28DD094C4A269FA6BE7EA94910B6C125_217693388.addTaint(taint);
        return var28DD094C4A269FA6BE7EA94910B6C125_217693388;
        // ---------- Original Method ----------
        //return nspStack[pos * 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.040 -0400", hash_original_method = "BEA3C6D36DAA76218F10B33482B7D86B", hash_generated_method = "E9C702ECEA7DE9774DBC18BAB0238DBA")
    public String getNamespaceUri(int pos) {
        addTaint(pos);
String var2ED7D22F6ECDAFD296AE1EE24D673F78_1057050671 =         nspStack[(pos * 2) + 1];
        var2ED7D22F6ECDAFD296AE1EE24D673F78_1057050671.addTaint(taint);
        return var2ED7D22F6ECDAFD296AE1EE24D673F78_1057050671;
        // ---------- Original Method ----------
        //return nspStack[(pos * 2) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.040 -0400", hash_original_method = "40F39B6FC2CBEA065A6E595C0C377D56", hash_generated_method = "F80A7DEA309EEC1672DB681813418C80")
    public String getNamespace(String prefix) {
        addTaint(prefix.getTaint());
    if("xml".equals(prefix))        
        {
String varB42E997512DFFB350471AB44C36A387C_9676325 =             "http://www.w3.org/XML/1998/namespace";
            varB42E997512DFFB350471AB44C36A387C_9676325.addTaint(taint);
            return varB42E997512DFFB350471AB44C36A387C_9676325;
        } //End block
    if("xmlns".equals(prefix))        
        {
String var9D449F1D53C2C64B85A7AEF148BB8C58_507613724 =             "http://www.w3.org/2000/xmlns/";
            var9D449F1D53C2C64B85A7AEF148BB8C58_507613724.addTaint(taint);
            return var9D449F1D53C2C64B85A7AEF148BB8C58_507613724;
        } //End block
for(int i = (getNamespaceCount(depth) << 1) - 2;i >= 0;i -= 2)
        {
    if(prefix == null)            
            {
    if(nspStack[i] == null)                
                {
String var7C146870E87A0CC7077FCAFD76B21B23_2100871539 =                     nspStack[i + 1];
                    var7C146870E87A0CC7077FCAFD76B21B23_2100871539.addTaint(taint);
                    return var7C146870E87A0CC7077FCAFD76B21B23_2100871539;
                } //End block
            } //End block
            else
    if(prefix.equals(nspStack[i]))            
            {
String var7C146870E87A0CC7077FCAFD76B21B23_2063854833 =                 nspStack[i + 1];
                var7C146870E87A0CC7077FCAFD76B21B23_2063854833.addTaint(taint);
                return var7C146870E87A0CC7077FCAFD76B21B23_2063854833;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1691216939 =         null;
        var540C13E9E156B687226421B24F2DF178_1691216939.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1691216939;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.040 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "BF33394417587346694684C48911DE97")
    public int getDepth() {
        int var12A055BF01A31369FE81AC35D85C7BC1_1204056171 = (depth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157285785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157285785;
        // ---------- Original Method ----------
        //return depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.041 -0400", hash_original_method = "B71BFE480A942DC6AFBA741559BFFBE0", hash_generated_method = "2814772166184A50FD24CBD83BB105C6")
    public String getPositionDescription() {
        StringBuilder buf = new StringBuilder(type < TYPES.length ? TYPES[type] : "unknown");
        buf.append(' ');
    if(type == START_TAG || type == END_TAG)        
        {
    if(degenerated)            
            {
                buf.append("(empty) ");
            } //End block
            buf.append('<');
    if(type == END_TAG)            
            {
                buf.append('/');
            } //End block
    if(prefix != null)            
            {
                buf.append("{" + namespace + "}" + prefix + ":");
            } //End block
            buf.append(name);
            int cnt = attributeCount * 4;
for(int i = 0;i < cnt;i += 4)
            {
                buf.append(' ');
    if(attributes[i + 1] != null)                
                {
                    buf.append("{" + attributes[i] + "}" + attributes[i + 1] + ":");
                } //End block
                buf.append(attributes[i + 2] + "='" + attributes[i + 3] + "'");
            } //End block
            buf.append('>');
        } //End block
        else
    if(type == IGNORABLE_WHITESPACE)        
        {
            ;
        } //End block
        else
    if(type != TEXT)        
        {
            buf.append(getText());
        } //End block
        else
    if(isWhitespace)        
        {
            buf.append("(whitespace)");
        } //End block
        else
        {
            String text = getText();
    if(text.length() > 16)            
            {
                text = text.substring(0, 16) + "...";
            } //End block
            buf.append(text);
        } //End block
        buf.append("@" + getLineNumber() + ":" + getColumnNumber());
    if(location != null)        
        {
            buf.append(" in ");
            buf.append(location);
        } //End block
        else
    if(reader != null)        
        {
            buf.append(" in ");
            buf.append(reader.toString());
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_514329275 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_514329275.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_514329275;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.042 -0400", hash_original_method = "114340E3BA1FFC2D8A54D30C75AB06FF", hash_generated_method = "1B951B6D4921C629A167460DF101F7EF")
    public int getLineNumber() {
        int result = bufferStartLine;
for(int i = 0;i < position;i++)
        {
    if(buffer[i] == '\n')            
            {
                result++;
            } //End block
        } //End block
        int varF64046F266CBAF40120066872DBDD441_928717163 = (result + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415896314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415896314;
        // ---------- Original Method ----------
        //int result = bufferStartLine;
        //for (int i = 0; i < position; i++) {
            //if (buffer[i] == '\n') {
                //result++;
            //}
        //}
        //return result + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.042 -0400", hash_original_method = "C138C40AD0ECD6D56D342D21687BD452", hash_generated_method = "E928D5313B60DA3A88D6A6624FA9981C")
    public int getColumnNumber() {
        int result = bufferStartColumn;
for(int i = 0;i < position;i++)
        {
    if(buffer[i] == '\n')            
            {
                result = 0;
            } //End block
            else
            {
                result++;
            } //End block
        } //End block
        int varF64046F266CBAF40120066872DBDD441_33740728 = (result + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011175593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011175593;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.042 -0400", hash_original_method = "152BCFAF579D72B6DEF962950FEC2A17", hash_generated_method = "16850E6278660ABB63BD9C73AB49415E")
    public boolean isWhitespace() throws XmlPullParserException {
    if(type != TEXT && type != IGNORABLE_WHITESPACE && type != CDSECT)        
        {
            XmlPullParserException var0E39FCFE316D256922D5404E03912988_74683087 = new XmlPullParserException(ILLEGAL_TYPE, this, null);
            var0E39FCFE316D256922D5404E03912988_74683087.addTaint(taint);
            throw var0E39FCFE316D256922D5404E03912988_74683087;
        } //End block
        boolean varFDBE2C32DE81904D31506233605042C8_848086744 = (isWhitespace);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8672736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_8672736;
        // ---------- Original Method ----------
        //if (type != TEXT && type != IGNORABLE_WHITESPACE && type != CDSECT) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return isWhitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.043 -0400", hash_original_method = "96BD4C193A5C47E4BA7EA81CE7C395CC", hash_generated_method = "D1F997C721703916CD51DD64349FA37F")
    public String getText() {
    if(type < TEXT || (type == ENTITY_REF && unresolved))        
        {
String var540C13E9E156B687226421B24F2DF178_1685251767 =             null;
            var540C13E9E156B687226421B24F2DF178_1685251767.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1685251767;
        } //End block
        else
    if(text == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_224208652 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_224208652.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_224208652;
        } //End block
        else
        {
String var79CC641C1148018540A26F7ADC424893_555240264 =             text;
            var79CC641C1148018540A26F7ADC424893_555240264.addTaint(taint);
            return var79CC641C1148018540A26F7ADC424893_555240264;
        } //End block
        // ---------- Original Method ----------
        //if (type < TEXT || (type == ENTITY_REF && unresolved)) {
            //return null;
        //} else if (text == null) {
            //return "";
        //} else {
            //return text;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.043 -0400", hash_original_method = "17ADAF2C34EC5E5726D60154CDE0E31A", hash_generated_method = "23326A22E63F7B17FFAAB5A0FFF29E0A")
    public char[] getTextCharacters(int[] poslen) {
        addTaint(poslen[0]);
        String text = getText();
    if(text == null)        
        {
            poslen[0] = -1;
            poslen[1] = -1;
            char[] var37A6259CC0C1DAE299A7866489DFF0BD_828324824 = (null);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1818300053 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1818300053;
        } //End block
        char[] result = text.toCharArray();
        poslen[0] = 0;
        poslen[1] = result.length;
        char[] varB4A88417B3D0170D754C647C30B7216A_639331234 = (result);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_559955950 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_559955950;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.044 -0400", hash_original_method = "A99E1DDB500E37E7767EA602F963D96D", hash_generated_method = "53A4E2EF3F50285EE6CDAD8B266EC90A")
    public String getNamespace() {
String varF28472CCCF41AB611991133D8001D83B_927876154 =         namespace;
        varF28472CCCF41AB611991133D8001D83B_927876154.addTaint(taint);
        return varF28472CCCF41AB611991133D8001D83B_927876154;
        // ---------- Original Method ----------
        //return namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.046 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "5737165CF45FA5B4373B8466E5A5B087")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_878701076 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_878701076.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_878701076;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.046 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "71971FC2E0DE382C7E0E706EDBA98144")
    public String getPrefix() {
String varA4C254BE9F2C23429A8ED0933F20FF43_1594018441 =         prefix;
        varA4C254BE9F2C23429A8ED0933F20FF43_1594018441.addTaint(taint);
        return varA4C254BE9F2C23429A8ED0933F20FF43_1594018441;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.046 -0400", hash_original_method = "BB5C193EDDCF2188F64023D36680FCC7", hash_generated_method = "95DDB86A5A6A7BAC6AB7CBDD44104FE2")
    public boolean isEmptyElementTag() throws XmlPullParserException {
    if(type != START_TAG)        
        {
            XmlPullParserException var0E39FCFE316D256922D5404E03912988_1060632957 = new XmlPullParserException(ILLEGAL_TYPE, this, null);
            var0E39FCFE316D256922D5404E03912988_1060632957.addTaint(taint);
            throw var0E39FCFE316D256922D5404E03912988_1060632957;
        } //End block
        boolean var41E5137359BCC159984E1D58F1F76D16_399278947 = (degenerated);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045215062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045215062;
        // ---------- Original Method ----------
        //if (type != START_TAG) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return degenerated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.046 -0400", hash_original_method = "E7902A71CF05159AEACA5707956D2FB0", hash_generated_method = "24B346735E0891A51FDBF3650E1A89C8")
    public int getAttributeCount() {
        int varBB16AB716A8B7609C0ECC6FB65BADCBC_1569060428 = (attributeCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958822911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958822911;
        // ---------- Original Method ----------
        //return attributeCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.046 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "E44BDDE8484A55E054A7929A4686EDC8")
    public String getAttributeType(int index) {
        addTaint(index);
String var51FC5D2EB0F14BB856F2382E944EB3B9_408440467 =         "CDATA";
        var51FC5D2EB0F14BB856F2382E944EB3B9_408440467.addTaint(taint);
        return var51FC5D2EB0F14BB856F2382E944EB3B9_408440467;
        // ---------- Original Method ----------
        //return "CDATA";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.047 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "3BB6598A8A89AC568C567B500627E754")
    public boolean isAttributeDefault(int index) {
        addTaint(index);
        boolean var68934A3E9455FA72420237EB05902327_102713829 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1532136594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1532136594;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.047 -0400", hash_original_method = "1DC23C46494192E0CB67B725251C6942", hash_generated_method = "60A29DB844F669C2236977F561F5F0A4")
    public String getAttributeNamespace(int index) {
        addTaint(index);
    if(index >= attributeCount)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_2038918463 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_2038918463.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_2038918463;
        } //End block
String varFD8AF74A04190B1E28D4241B313BABB3_72137902 =         attributes[index * 4];
        varFD8AF74A04190B1E28D4241B313BABB3_72137902.addTaint(taint);
        return varFD8AF74A04190B1E28D4241B313BABB3_72137902;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[index * 4];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.047 -0400", hash_original_method = "07BD775DFF4E9B04837F88C1E2748FE1", hash_generated_method = "646053C7C8F15D80C710200C699D4755")
    public String getAttributeName(int index) {
        addTaint(index);
    if(index >= attributeCount)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_170016369 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_170016369.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_170016369;
        } //End block
String var41D414F922460E1F53D03833DEC045A1_2115571807 =         attributes[(index * 4) + 2];
        var41D414F922460E1F53D03833DEC045A1_2115571807.addTaint(taint);
        return var41D414F922460E1F53D03833DEC045A1_2115571807;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.047 -0400", hash_original_method = "C689E94E86EA5FE91ACCD87E01866231", hash_generated_method = "F18609D33050567809437E93D8CAED9D")
    public String getAttributePrefix(int index) {
        addTaint(index);
    if(index >= attributeCount)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_24626285 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_24626285.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_24626285;
        } //End block
String var9190C8629103C195F5830FB51A9DF1AD_163522217 =         attributes[(index * 4) + 1];
        var9190C8629103C195F5830FB51A9DF1AD_163522217.addTaint(taint);
        return var9190C8629103C195F5830FB51A9DF1AD_163522217;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.048 -0400", hash_original_method = "BF5E04E32ADD7672259D8C86F2C8D631", hash_generated_method = "7EB2DE2C28475D5A5B52995304E09624")
    public String getAttributeValue(int index) {
        addTaint(index);
    if(index >= attributeCount)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1157783168 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1157783168.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1157783168;
        } //End block
String varDAA352E3F1F9CFE8C08DAA579A0C75EE_1586524108 =         attributes[(index * 4) + 3];
        varDAA352E3F1F9CFE8C08DAA579A0C75EE_1586524108.addTaint(taint);
        return varDAA352E3F1F9CFE8C08DAA579A0C75EE_1586524108;
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 3];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.048 -0400", hash_original_method = "D0AC7DE2A29C82DADA1B505288DAC27D", hash_generated_method = "2FD0F8B57A757312B2640F5ABFD5D946")
    public String getAttributeValue(String namespace, String name) {
        addTaint(name.getTaint());
        addTaint(namespace.getTaint());
for(int i = (attributeCount * 4) - 4;i >= 0;i -= 4)
        {
    if(attributes[i + 2].equals(name)
                    && (namespace == null || attributes[i].equals(namespace)))            
            {
String var49AEFA578E1E8F419A6718675760D2B5_119968512 =                 attributes[i + 3];
                var49AEFA578E1E8F419A6718675760D2B5_119968512.addTaint(taint);
                return var49AEFA578E1E8F419A6718675760D2B5_119968512;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_286912116 =         null;
        var540C13E9E156B687226421B24F2DF178_286912116.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_286912116;
        // ---------- Original Method ----------
        //for (int i = (attributeCount * 4) - 4; i >= 0; i -= 4) {
            //if (attributes[i + 2].equals(name)
                    //&& (namespace == null || attributes[i].equals(namespace))) {
                //return attributes[i + 3];
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.048 -0400", hash_original_method = "0457ED08CBFC1348E0AAA3CE0D692605", hash_generated_method = "E7B79515DD448069D804982B4A163CAA")
    public int getEventType() throws XmlPullParserException {
        int var599DCCE2998A6B40B1E38E8C6006CB0A_425378497 = (type);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314706142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314706142;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.049 -0400", hash_original_method = "53E7D5238284732F8540E3833F26B112", hash_generated_method = "359A7159B492322E907C88CCC87AE8B6")
    public int nextTag() throws XmlPullParserException, IOException {
        next();
    if(type == TEXT && isWhitespace)        
        {
            next();
        } //End block
    if(type != END_TAG && type != START_TAG)        
        {
            XmlPullParserException var4FB2E3745E0E1B121B0F5C2C50CDA3DE_906863116 = new XmlPullParserException("unexpected type", this, null);
            var4FB2E3745E0E1B121B0F5C2C50CDA3DE_906863116.addTaint(taint);
            throw var4FB2E3745E0E1B121B0F5C2C50CDA3DE_906863116;
        } //End block
        int var599DCCE2998A6B40B1E38E8C6006CB0A_1129457008 = (type);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769345537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769345537;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.049 -0400", hash_original_method = "C4BF1BB4C255F6013F5858579D851AD3", hash_generated_method = "0ED20D72AB47A318A063C05F98CF0442")
    public void require(int type, String namespace, String name) throws XmlPullParserException, IOException {
        addTaint(name.getTaint());
        addTaint(namespace.getTaint());
        addTaint(type);
    if(type != this.type
                || (namespace != null && !namespace.equals(getNamespace()))
                || (name != null && !name.equals(getName())))        
        {
            XmlPullParserException var36B64AF4BC95700D426ABC3010D26FD5_530199894 = new XmlPullParserException(
                    "expected: " + TYPES[type] + " {" + namespace + "}" + name, this, null);
            var36B64AF4BC95700D426ABC3010D26FD5_530199894.addTaint(taint);
            throw var36B64AF4BC95700D426ABC3010D26FD5_530199894;
        } //End block
        // ---------- Original Method ----------
        //if (type != this.type
                //|| (namespace != null && !namespace.equals(getNamespace()))
                //|| (name != null && !name.equals(getName()))) {
            //throw new XmlPullParserException(
                    //"expected: " + TYPES[type] + " {" + namespace + "}" + name, this, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.049 -0400", hash_original_method = "102A6610D1A439DBBB62D3798FEF6670", hash_generated_method = "E9A97B2A2191344D625C36A479957DB2")
    public String nextText() throws XmlPullParserException, IOException {
    if(type != START_TAG)        
        {
            XmlPullParserException varA0906E3B6E3ABABB2B627A16BC707250_2031205985 = new XmlPullParserException("precondition: START_TAG", this, null);
            varA0906E3B6E3ABABB2B627A16BC707250_2031205985.addTaint(taint);
            throw varA0906E3B6E3ABABB2B627A16BC707250_2031205985;
        } //End block
        next();
        String result;
    if(type == TEXT)        
        {
            result = getText();
            next();
        } //End block
        else
        {
            result = "";
        } //End block
    if(type != END_TAG)        
        {
            XmlPullParserException varA3E37C0C1EFF20DD4A8E615260CDC2A9_930072989 = new XmlPullParserException("END_TAG expected", this, null);
            varA3E37C0C1EFF20DD4A8E615260CDC2A9_930072989.addTaint(taint);
            throw varA3E37C0C1EFF20DD4A8E615260CDC2A9_930072989;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_757820824 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_757820824.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_757820824;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.059 -0400", hash_original_method = "DD2B8D14469BF5F6853E930DFF62942D", hash_generated_method = "5B20B5C3921BC94579ACB52858CDF8CA")
    public void setFeature(String feature, boolean value) throws XmlPullParserException {
        addTaint(feature.getTaint());
    if(XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature))        
        {
            processNsp = value;
        } //End block
        else
    if(XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(feature))        
        {
            processDocDecl = value;
        } //End block
        else
    if(FEATURE_RELAXED.equals(feature))        
        {
            relaxed = value;
        } //End block
        else
        {
            XmlPullParserException var81E6717CF1B869AC866C4996999889A4_1092648562 = new XmlPullParserException("unsupported feature: " + feature, this, null);
            var81E6717CF1B869AC866C4996999889A4_1092648562.addTaint(taint);
            throw var81E6717CF1B869AC866C4996999889A4_1092648562;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.060 -0400", hash_original_method = "BB78C28304FA5EA99DAD361D5123F3A6", hash_generated_method = "3A85EA49044B7F600AD4D8D42DFF8D85")
    public void setProperty(String property, Object value) throws XmlPullParserException {
        addTaint(property.getTaint());
    if(property.equals(PROPERTY_LOCATION))        
        {
            location = String.valueOf(value);
        } //End block
        else
        {
            XmlPullParserException varB468B3442E1126E27A432EF95994AE35_926441178 = new XmlPullParserException("unsupported property: " + property);
            varB468B3442E1126E27A432EF95994AE35_926441178.addTaint(taint);
            throw varB468B3442E1126E27A432EF95994AE35_926441178;
        } //End block
        // ---------- Original Method ----------
        //if (property.equals(PROPERTY_LOCATION)) {
            //location = String.valueOf(value);
        //} else {
            //throw new XmlPullParserException("unsupported property: " + property);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.061 -0400", hash_original_method = "8F280A3CDA5A3533C9FB5C99B2A6A6C2", hash_generated_method = "1875E14C2FF645B516B31839CE1AE2FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.061 -0400", hash_original_method = "E5A180E871F653CC9F75C9B7A9F73687", hash_generated_method = "AB3CB35729064AF57103D5354FFFA23D")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "7D21AAFF4A726AE51AF8BEE306E3B202")

        private ContentSource next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

        private char[] buffer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "312206EA2404526B7BBC621459C87A80")

        private int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

        private int limit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_method = "BC47C2124096A91C278868E0B05F486C", hash_generated_method = "09A7E76D7B92EC6645E7074B8EFBBAF1")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "27B6834E590614C67E1B47148C9A08A7", hash_generated_field = "A55120855D0EB510239B6C4441F51AAE")

    private static final String PROPERTY_XMLDECL_VERSION = "http://xmlpull.org/v1/doc/properties.html#xmldecl-version";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "5768BD6E60DAB0B2B728E0D499DB1599", hash_generated_field = "6D51E873AB83378675CBD979DE182EFE")

    private static final String PROPERTY_XMLDECL_STANDALONE = "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "884227814336854467D95B8B62864403", hash_generated_field = "E4463FE3DABC66E04C600BDAC16EE7C5")

    private static final String PROPERTY_LOCATION = "http://xmlpull.org/v1/doc/properties.html#location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "34C1F6B518B9248A65D50F5DA60C6C55", hash_generated_field = "268A61AB07F8975416D95A6108614DB4")

    private static final String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "92D38954A36A7A130944D347C51A4750", hash_generated_field = "6DD1487BA02DCE058EBB56C6D00845DA")

    private static final Map<String, String> DEFAULT_ENTITIES = new HashMap<String, String>();
    static {
        DEFAULT_ENTITIES.put("lt", "<");
        DEFAULT_ENTITIES.put("gt", ">");
        DEFAULT_ENTITIES.put("amp", "&");
        DEFAULT_ENTITIES.put("apos", "'");
        DEFAULT_ENTITIES.put("quot", "\"");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "35DC4AA981D49C40AF5D8EB7E9F1117A", hash_generated_field = "9E004EC37549D77F0649D4ADE1AD1D11")

    private static final int ELEMENTDECL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "C8E8F601E56036BF41DED88DC4266A8D", hash_generated_field = "54F59956AE951C536E4F8B77591DDCD1")

    private static final int ENTITYDECL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "FC717574941501F4302EC29D3B65C1FF", hash_generated_field = "BC43E0FAC920F03CBC3B97B7F68A505D")

    private static final int ATTLISTDECL = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.062 -0400", hash_original_field = "6AA28C8E65834B07CFDECC56CC10645C", hash_generated_field = "72B9346B282549C68EFF4F9A4488493B")

    private static final int NOTATIONDECL = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "FE0875DD4DD3CE989B0A3D90742E5A5E", hash_generated_field = "4A097A0AA45CC4E364F7B6FC29BC31E4")

    private static final int PARAMETER_ENTITY_REF = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "E7BD4BF0DD03ED7F0C2CE63D25C4F342", hash_generated_field = "AE91905FCADB2F5F070BC3120FB7DF2B")

    private static final char[] START_COMMENT = { '<', '!', '-', '-' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "B022889C19E08B210036EBAFDCF3BF96", hash_generated_field = "B9C01DA88191BDFD088979E680871860")

    private static final char[] END_COMMENT = { '-', '-', '>' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "53D1CB8EB2CA2E3A088A616EE99463E8", hash_generated_field = "FF8AF1A2AC00395530E1421E331D4C1E")

    private static final char[] COMMENT_DOUBLE_DASH = { '-', '-' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "C0A15B2F83065A1DFC9027CE36A09E2D", hash_generated_field = "1F00DF0F8140B30091CAFD05256D4255")

    private static final char[] START_CDATA = { '<', '!', '[', 'C', 'D', 'A', 'T', 'A', '[' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "9187F94234DDBD50920C4C920C0BC3D1", hash_generated_field = "7E6AC8710E7F89251559D1CEBDE35997")

    private static final char[] END_CDATA = { ']', ']', '>' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "0057C89060DC30A0D3BCAD97306A9EA4", hash_generated_field = "DB90089C944C238022A155399F6C9774")

    private static final char[] START_PROCESSING_INSTRUCTION = { '<', '?' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "DA4C6A74263B1C7667F633E7F0A84E50", hash_generated_field = "E589BDD6193F766F275FA9034F35F5BD")

    private static final char[] END_PROCESSING_INSTRUCTION = { '?', '>' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "8A17DA7EFA39ACED7446B7874A7EC2A2", hash_generated_field = "EC707F57B4AC804FDD91FEAE1CA48143")

    private static final char[] START_DOCTYPE = { '<', '!', 'D', 'O', 'C', 'T', 'Y', 'P', 'E' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "38C3FB49D52D4A290C10B9F798EC30A0", hash_generated_field = "1953AEE3F130CEDFCF173BC749E8D74C")

    private static final char[] SYSTEM = { 'S', 'Y', 'S', 'T', 'E', 'M' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "2438362FD4A140D2147FEB110B4A6E5F", hash_generated_field = "1B9EE2198CFA65978EDAD9837C2D98E4")

    private static final char[] PUBLIC = { 'P', 'U', 'B', 'L', 'I', 'C' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "D68A738A9EA3A1C42717AF4857C99B99", hash_generated_field = "1E07434ACF3BAEC92793981CB62A1257")

    private static final char[] START_ELEMENT = { '<', '!', 'E', 'L', 'E', 'M', 'E', 'N', 'T' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "727399FD752E37162EF939B0657F7D60", hash_generated_field = "93647CCB1C4A3560B5811642ACC808E1")

    private static final char[] START_ATTLIST = { '<', '!', 'A', 'T', 'T', 'L', 'I', 'S', 'T' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "FA7B87FB313821079B341C73E6B33C55", hash_generated_field = "C13600C3B78CBE3E04176024A982C019")

    private static final char[] START_ENTITY = { '<', '!', 'E', 'N', 'T', 'I', 'T', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "CC3F4B8257AABBE89D84580F3628DEC1", hash_generated_field = "26DEA7BBC851381E3B051A614341C3A5")

    private static final char[] START_NOTATION = { '<', '!', 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.063 -0400", hash_original_field = "1D4BBC963EF8009B5C27B42A1BACB865", hash_generated_field = "CE5BBCD42C3BCD0FA21C3D08DE5E6A76")

    private static final char[] EMPTY = new char[] { 'E', 'M', 'P', 'T', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "03F8F742493275DA0383F42B3966CFE9", hash_generated_field = "8084EC1AE9BBB77E8C4CE487BFA97E84")

    private static final char[] ANY = new char[]{ 'A', 'N', 'Y' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "2CBBE1148D5985E9C125F13280475FEA", hash_generated_field = "4DEDC0055F8730628487DF60C24AE644")

    private static final char[] NDATA = new char[]{ 'N', 'D', 'A', 'T', 'A' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "5399D5CD75FA12874AFE811CC79AACC9", hash_generated_field = "F8F98D147E42E5C73D61223E22989674")

    private static final char[] NOTATION = new char[]{ 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "7E6290A430CA851B556ABC7D34D8AD24", hash_generated_field = "36F47AE4877D288517520A35D94C23D0")

    private static final char[] REQUIRED = new char[] { 'R', 'E', 'Q', 'U', 'I', 'R', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "81F7575472B843CF7EA57A03A43E8109", hash_generated_field = "D9FA6B2501522578811C97ACB8DA0B4A")

    private static final char[] IMPLIED = new char[] { 'I', 'M', 'P', 'L', 'I', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "97889E011D3E83DBDEE52D4845C143AD", hash_generated_field = "D77E8DBC383CA9965DF66F0E9CBC458F")

    private static final char[] FIXED = new char[] { 'F', 'I', 'X', 'E', 'D' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "E20CB809E09D45606B87A49E30F6A337", hash_generated_field = "1DABD35C32510824D283D1E8D34D1E30")

    static final private String UNEXPECTED_EOF = "Unexpected EOF";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "A39FC8F3BE9A750F49E5AC875DA0254A", hash_generated_field = "1DACE964DB2B3286A1F2AD099EF50C87")

    static final private String ILLEGAL_TYPE = "Wrong event type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "EE3EB445BB65E61F6C1827B6103FB153", hash_generated_field = "08E26EE9AE32DEA74B8044C2977B0BF5")

    static final private int XML_DECLARATION = 998;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "22D831D51410F2BFA15997AC55164E91", hash_generated_field = "FDBEB59450D649476077B2C45FE302BE")

    private static final char[] SINGLE_QUOTE = new char[] { '\'' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.064 -0400", hash_original_field = "98068AEE409DFDA084FFD71A3B03132A", hash_generated_field = "57CA247B64F06AAD2642685314F137D4")

    private static final char[] DOUBLE_QUOTE = new char[] { '"' };
}

