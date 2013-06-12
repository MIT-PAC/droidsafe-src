package org.kxml2.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String PROPERTY_XMLDECL_VERSION
            = "http://xmlpull.org/v1/doc/properties.html#xmldecl-version";
    private static final String PROPERTY_XMLDECL_STANDALONE
            = "http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone";
    private static final String PROPERTY_LOCATION = "http://xmlpull.org/v1/doc/properties.html#location";
    private static final String FEATURE_RELAXED = "http://xmlpull.org/v1/doc/features.html#relaxed";
    private static final Map<String, String> DEFAULT_ENTITIES = new HashMap<String, String>();
    private static final int ELEMENTDECL = 11;
    private static final int ENTITYDECL = 12;
    private static final int ATTLISTDECL = 13;
    private static final int NOTATIONDECL = 14;
    private static final int PARAMETER_ENTITY_REF = 15;
    private static final char[] START_COMMENT = { '<', '!', '-', '-' };
    private static final char[] END_COMMENT = { '-', '-', '>' };
    private static final char[] COMMENT_DOUBLE_DASH = { '-', '-' };
    private static final char[] START_CDATA = { '<', '!', '[', 'C', 'D', 'A', 'T', 'A', '[' };
    private static final char[] END_CDATA = { ']', ']', '>' };
    private static final char[] START_PROCESSING_INSTRUCTION = { '<', '?' };
    private static final char[] END_PROCESSING_INSTRUCTION = { '?', '>' };
    private static final char[] START_DOCTYPE = { '<', '!', 'D', 'O', 'C', 'T', 'Y', 'P', 'E' };
    private static final char[] SYSTEM = { 'S', 'Y', 'S', 'T', 'E', 'M' };
    private static final char[] PUBLIC = { 'P', 'U', 'B', 'L', 'I', 'C' };
    private static final char[] START_ELEMENT = { '<', '!', 'E', 'L', 'E', 'M', 'E', 'N', 'T' };
    private static final char[] START_ATTLIST = { '<', '!', 'A', 'T', 'T', 'L', 'I', 'S', 'T' };
    private static final char[] START_ENTITY = { '<', '!', 'E', 'N', 'T', 'I', 'T', 'Y' };
    private static final char[] START_NOTATION = { '<', '!', 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
    private static final char[] EMPTY = new char[] { 'E', 'M', 'P', 'T', 'Y' };
    private static final char[] ANY = new char[]{ 'A', 'N', 'Y' };
    private static final char[] NDATA = new char[]{ 'N', 'D', 'A', 'T', 'A' };
    private static final char[] NOTATION = new char[]{ 'N', 'O', 'T', 'A', 'T', 'I', 'O', 'N' };
    private static final char[] REQUIRED = new char[] { 'R', 'E', 'Q', 'U', 'I', 'R', 'E', 'D' };
    private static final char[] IMPLIED = new char[] { 'I', 'M', 'P', 'L', 'I', 'E', 'D' };
    private static final char[] FIXED = new char[] { 'F', 'I', 'X', 'E', 'D' };
    static final private String UNEXPECTED_EOF = "Unexpected EOF";
    static final private String ILLEGAL_TYPE = "Wrong event type";
    static final private int XML_DECLARATION = 998;
    private String location;
    private String version;
    private Boolean standalone;
    private String rootElementName;
    private String systemId;
    private String publicId;
    private boolean processDocDecl;
    private boolean processNsp;
    private boolean relaxed;
    private boolean keepNamespaceAttributes;
    private StringBuilder bufferCapture;
    private Map<String, char[]> documentEntities;
    private Map<String, Map<String, String>> defaultAttributes;
    private int depth;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private Reader reader;
    private String encoding;
    private ContentSource nextContentSource;
    private char[] buffer = new char[8192];
    private int position = 0;
    private int limit = 0;
    private int bufferStartLine;
    private int bufferStartColumn;
    private int type;
    private boolean isWhitespace;
    private String namespace;
    private String prefix;
    private String name;
    private String text;
    private boolean degenerated;
    private int attributeCount;
    private String[] attributes = new String[16];
    private String error;
    private boolean unresolved;
    public final StringPool stringPool = new StringPool();
    private static final char[] SINGLE_QUOTE = new char[] { '\'' };
    private static final char[] DOUBLE_QUOTE = new char[] { '"' };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.122 -0400", hash_original_method = "A527DEDBB8977F1D947B829D15DAACC5", hash_generated_method = "37F861FE011A5462105E264716A3459A")
    @DSModeled(DSC.SAFE)
    public void keepNamespaceAttributes() {
        this.keepNamespaceAttributes = true;
        // ---------- Original Method ----------
        //this.keepNamespaceAttributes = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.123 -0400", hash_original_method = "F08928441827C23946744248151D18D9", hash_generated_method = "5F98CBF8DFB94AF18C1B8903B95AE1D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean varE8E99AA812A31FBE0E19EAB21AA5408E_1168781397 = (attrName.equals("xmlns"));
                    {
                        prefix = attrName;
                        attrName = null;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var946560EAC9A71101396E7CF7B5CB85AE_94756010 = (!prefix.equals("xmlns"));
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
                            boolean varB788F9FC33ABF51F2A4A741D8D605EA1_99303371 = (attrName != null && attributes[i + 3].isEmpty());
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.123 -0400", hash_original_method = "49B8B44C0E7574021385F3D8BD03186C", hash_generated_method = "5A85FAE2CCBC9DE3C9E1EB6539CA0D84")
    @DSModeled(DSC.SAFE)
    private String[] ensureCapacity(String[] arr, int required) {
        dsTaint.addTaint(arr);
        dsTaint.addTaint(required);
        String[] bigger;
        bigger = new String[required + 16];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (arr.length >= required) {
            //return arr;
        //}
        //String[] bigger = new String[required + 16];
        //System.arraycopy(arr, 0, bigger, 0, arr.length);
        //return bigger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.123 -0400", hash_original_method = "4A7BCCF6DFE9CB9D8E85D47BF7F54B1D", hash_generated_method = "D08E26803350C03DDD14FA0F28A632C3")
    @DSModeled(DSC.SAFE)
    private void checkRelaxed(String errorMessage) throws XmlPullParserException {
        dsTaint.addTaint(errorMessage);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.123 -0400", hash_original_method = "76E82C4E283B430F3EE1381EBB2709F7", hash_generated_method = "1F6E7BAD2F6FBE59BCA18D7EF0BF5E85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next() throws XmlPullParserException, IOException {
        int var7CB2833143510FA64D55226A9FF36AA2_1964930379 = (next(false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return next(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.123 -0400", hash_original_method = "B3A65F7F837C14F73BB928D8BDFE9D91", hash_generated_method = "ACB363EBCBA8D618E3CC643DC09A0AA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextToken() throws XmlPullParserException, IOException {
        int var217D6B4D8CC59251F9E88B712D4C8A6D_549329028 = (next(true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return next(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.124 -0400", hash_original_method = "55251A1079E5B9F4E3B9F053CFE6FD44", hash_generated_method = "CC120EB323F128E5281C91FBC56CD1BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int next(boolean justOneToken) throws IOException, XmlPullParserException {
        dsTaint.addTaint(justOneToken);
        {
        	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("setInput() must be called first.", this, null);
        } //End block
        {
            depth--;
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
                boolean varFA88C9D54C78329BBC9730AF33B2F91B_206271892 = (text != null && !text.isEmpty() && peek < TEXT);
                {
                    type = TEXT;
                } //End block
            } //End collapsed parenthetic
            type = peek;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.124 -0400", hash_original_method = "C492543C28BFA45A4A603454FE30EBBB", hash_generated_method = "EFA10FDD2A82C8A222349CD45941318A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readUntil(char[] delimiter, boolean returnText) throws IOException, XmlPullParserException {
        dsTaint.addTaint(delimiter);
        dsTaint.addTaint(returnText);
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
                    boolean var6A57E9353FD53082715EEF7D5328480F_1232102659 = (!fillBuffer(delimiter.length));
                    {
                        checkRelaxed(UNEXPECTED_EOF);
                        type = COMMENT;
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            {
                int i;
                i = 0;
                {
                    {
                        position++;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        int end;
        end = position;
        position += delimiter.length;
        {
            String varCA47EC7680535AE97CEB39F83D2D5983_696571235 = (stringPool.get(buffer, start, end - start));
        } //End block
        {
            result.append(buffer, start, end - start);
            String varEC2CAD6F4392C35EA2158E6C5520B613_147713952 = (result.toString());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.125 -0400", hash_original_method = "79737DD70253BC976180BA8757B427A8", hash_generated_method = "06C5ADF515FF4D760546BF40404C6AFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readXmlDeclaration() throws IOException, XmlPullParserException {
        {
            checkRelaxed("processing instructions must not start with xml");
        } //End block
        read(START_PROCESSING_INSTRUCTION);
        parseStartTag(true, true);
        {
            boolean var581268841B2EE653D75D3B9B477E8682_668301166 = (attributeCount < 1 || !"version".equals(attributes[2]));
            {
                checkRelaxed("version expected");
            } //End block
        } //End collapsed parenthetic
        version = attributes[3];
        int pos;
        pos = 1;
        {
            boolean var61BDCB47DC4581E06BB552238A25D6ED_976625049 = (pos < attributeCount && "encoding".equals(attributes[2 + 4]));
            {
                encoding = attributes[3 + 4];
                pos++;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4D353DE97B84BC869440DBFEAB2495D7_923898644 = (pos < attributeCount && "standalone".equals(attributes[4 * pos + 2]));
            {
                String st;
                st = attributes[3 + 4 * pos];
                {
                    boolean varFE7CCC805D774FAAB9193F9EB670EDC7_284461080 = ("yes".equals(st));
                    {
                        standalone = Boolean.TRUE;
                    } //End block
                    {
                        boolean varFB2DD01E2CB481BE2D08953AF4F2267B_1467620733 = ("no".equals(st));
                        {
                            standalone = Boolean.FALSE;
                        } //End block
                        {
                            checkRelaxed("illegal standalone value: " + st);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                pos++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.125 -0400", hash_original_method = "15C58CE8BC29A2518B63BEC83A754E2C", hash_generated_method = "9DCCBB93EEF908FF28F80459D54F6394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readComment(boolean returnText) throws IOException, XmlPullParserException {
        dsTaint.addTaint(returnText);
        read(START_COMMENT);
        {
            String var687E017CED4714F528FA1BB1D97D4F8A_72311532 = (readUntil(END_COMMENT, returnText));
        } //End block
        String commentText;
        commentText = readUntil(COMMENT_DOUBLE_DASH, returnText);
        {
            boolean varDEDEA312818AD0583FC7EE9661E09825_957875370 = (peekCharacter() != '>');
            {
            	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Comments may not contain --", this, null);
            } //End block
        } //End collapsed parenthetic
        position++;
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.125 -0400", hash_original_method = "39B79927E64E599404174E0314CB7C82", hash_generated_method = "022F51163A93A6728ED5B8FB689EB83F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readDoctype(boolean saveDtdText) throws IOException, XmlPullParserException {
        dsTaint.addTaint(saveDtdText);
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
                boolean varF62C1FC69328E5AC0EE954FE80231020_1505318956 = (peekCharacter() == '[');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.125 -0400", hash_original_method = "5A46FF78EB6898EF0CABAC45E530C34E", hash_generated_method = "B2705F9202C48197BCD119A6521F62BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean readExternalId(boolean requireSystemName, boolean assignFields) throws IOException, XmlPullParserException {
        dsTaint.addTaint(assignFields);
        dsTaint.addTaint(requireSystemName);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.125 -0400", hash_original_method = "4B3A97D73E48F79754EA5A86D4C2409D", hash_generated_method = "582A9CD228AC969FA1CA718DD637B70C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readQuotedId(boolean returnText) throws IOException, XmlPullParserException {
        dsTaint.addTaint(returnText);
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
        position++;
        String varBFE6449E52EE8F8EA816321563FBB5AE_710724427 = (readUntil(delimiter, returnText));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.125 -0400", hash_original_method = "065EAF2A999BF53AAEE6E5D55221F190", hash_generated_method = "CD4612A405408C600A1E9244233611E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readInternalSubset() throws IOException, XmlPullParserException {
        read('[');
        {
            skip();
            {
                boolean var6B07AFB8162EBC207136B3E0CBF1DCA1_1489498892 = (peekCharacter() == ']');
                {
                    position++;
                } //End block
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
            throw new XmlPullParserException("Unexpected token", this, null);
            //End case default 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.126 -0400", hash_original_method = "E2914311E18C41738022F5D7A73FEC8A", hash_generated_method = "E9D22D79BF5F4FBE33F00A3B4261ADD6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.126 -0400", hash_original_method = "A45115A32F8DEBE95546FC38EF8925EC", hash_generated_method = "4675F0CBDEA01E93CF499856DA1D9741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readContentSpec() throws IOException, XmlPullParserException {
        skip();
        int c;
        c = peekCharacter();
        {
            int depth;
            depth = 0;
            {
                {
                    depth++;
                } //End block
                {
                    depth--;
                } //End block
                position++;
                c = peekCharacter();
            } //End block
            {
                position++;
            } //End block
        } //End block
        {
            read(EMPTY);
        } //End block
        {
            read(ANY);
        } //End block
        {
            throw new XmlPullParserException("Expected element content spec", this, null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.126 -0400", hash_original_method = "04CF7BEB7F762D6DB023733A3E9A3C83", hash_generated_method = "C49543F29E8FB59313E971BDCD81A7AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readAttributeListDeclaration() throws IOException, XmlPullParserException {
        read(START_ATTLIST);
        skip();
        String elementName;
        elementName = readName();
        {
            skip();
            int c;
            c = peekCharacter();
            {
                position++;
            } //End block
            String attributeName;
            attributeName = readName();
            skip();
            {
                boolean var3C74D199C82A09DCA88FADF6B9606194_1888250905 = (position + 1 >= limit && !fillBuffer(2));
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
                position++;
                {
                    skip();
                    readName();
                    skip();
                    c = peekCharacter();
                    {
                        position++;
                    } //End block
                    {
                        position++;
                    } //End block
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
                position++;
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
                position++;
                String value;
                value = readValue((char) c, true, true, ValueContext.ATTRIBUTE);
                position++;
                defineAttributeDefault(elementName, attributeName, value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.126 -0400", hash_original_method = "CFB39B3ED48D8CD145E96E2E6FC1A186", hash_generated_method = "A865E25E38A8B028DFE18C75F242FD36")
    @DSModeled(DSC.SAFE)
    private void defineAttributeDefault(String elementName, String attributeName, String value) {
        dsTaint.addTaint(attributeName);
        dsTaint.addTaint(elementName);
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.127 -0400", hash_original_method = "3ECF3BA7E150644C3EFC98E620B12B73", hash_generated_method = "4FD297A06006BE2ED0CA322A450718E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readEntityDeclaration() throws IOException, XmlPullParserException {
        read(START_ENTITY);
        boolean generalEntity;
        generalEntity = true;
        skip();
        {
            boolean varA3E57F3EA9CA6DD721B84564E023B708_752878468 = (peekCharacter() == '%');
            {
                generalEntity = false;
                position++;
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
            position++;
            entityValue = readValue((char) quote, true, false, ValueContext.ENTITY_DECLARATION);
            position++;
        } //End block
        {
            boolean var62304E14A0621CCB5A3B27C088EC2811_78568215 = (readExternalId(true, false));
            {
                entityValue = "";
                skip();
                {
                    boolean varB155190189F97133258877F1A9544A2B_1188587747 = (peekCharacter() == NDATA[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.127 -0400", hash_original_method = "0A96EF478D2162A2E48AFFA05F705C17", hash_generated_method = "CB66BA4D4E47F7CE22F389D6F8A548E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readNotationDeclaration() throws IOException, XmlPullParserException {
        read(START_NOTATION);
        skip();
        readName();
        {
            boolean var54889F641C80FD666AF09F21AFB2466E_605669708 = (!readExternalId(false, false));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.127 -0400", hash_original_method = "8099A7EBC5B0B16E684058778DE6A29B", hash_generated_method = "FA3411628059CF6609EDAE9B2FD1F4DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            boolean var8E76959AB88DB3EF43C8D0E037D778E4_572266833 = (name.equals(elementStack[sp + 3]));
            {
                namespace = elementStack[sp];
                prefix = elementStack[sp + 1];
                name = elementStack[sp + 2];
            } //End block
            {
                throw new XmlPullParserException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.127 -0400", hash_original_method = "06A44958C70A8BD5DE7481C49C8C3731", hash_generated_method = "71ADA248A0915EFBAB907AAAD3F5E237")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int peekType(boolean inDeclaration) throws IOException, XmlPullParserException {
        dsTaint.addTaint(inDeclaration);
        {
            boolean var5AB75DCE4678778E9ADB41C89957E4BF_2113950260 = (position >= limit && !fillBuffer(1));
        } //End collapsed parenthetic
        //Begin case '<' 
        {
            boolean var30933827E7DDA57720354AD908DB062A_411210532 = (position + 3 >= limit && !fillBuffer(4));
            {
            	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Dangling <", this, null);
            } //End block
        } //End collapsed parenthetic
        //End case '<' 
        //Begin case '<' 
        //Begin case '?' 
        {
            boolean var00D7AD3906D2C618F2C2332E5E32D79F_1669837512 = ((position + 5 < limit || fillBuffer(6))
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.128 -0400", hash_original_method = "2D33E593F3270AF80057D4A47B14E7B9", hash_generated_method = "37DD19F1C58CF97D2CA7A72CE2C96379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseStartTag(boolean xmldecl, boolean throwOnResolveFailure) throws IOException, XmlPullParserException {
        dsTaint.addTaint(throwOnResolveFailure);
        dsTaint.addTaint(xmldecl);
        {
            read('<');
        } //End block
        name = readName();
        attributeCount = 0;
        {
            skip();
            {
                boolean var6F89AB896FA639129948E99AFBABDE77_1100040765 = (position >= limit && !fillBuffer(1));
                {
                    checkRelaxed(UNEXPECTED_EOF);
                } //End block
            } //End collapsed parenthetic
            int c;
            c = buffer[position];
            {
                {
                    position++;
                    read('>');
                } //End block
            } //End block
            {
                {
                    degenerated = true;
                    position++;
                    skip();
                    read('>');
                } //End block
                {
                    position++;
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
                boolean var6F89AB896FA639129948E99AFBABDE77_513462111 = (position >= limit && !fillBuffer(1));
                {
                    checkRelaxed(UNEXPECTED_EOF);
                } //End block
            } //End collapsed parenthetic
            {
                position++;
                skip();
                {
                    boolean var910B70164E5991D8BBB1C8DDE5598762_1930173616 = (position >= limit && !fillBuffer(1));
                    {
                        checkRelaxed(UNEXPECTED_EOF);
                    } //End block
                } //End collapsed parenthetic
                char delimiter;
                delimiter = buffer[position];
                {
                    position++;
                } //End block
                {
                    delimiter = ' ';
                } //End block
                {
                	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("attr value delimiter missing!", this, null);
                } //End block
                attributes[i + 3] = readValue(delimiter, true, throwOnResolveFailure,
                        ValueContext.ATTRIBUTE);
                {
                    position++;
                } //End block
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
                    Iterator<Map.Entry<String, String>> seatecAstronomy42 = elementDefaultAttributes.entrySet().iterator();
                    seatecAstronomy42.hasNext();
                    Map.Entry<String, String> entry = seatecAstronomy42.next();
                    {
                        {
                            boolean var2B1ECF93F7854BA095E104AF20F9C785_1568912493 = (getAttributeValue(null, entry.getKey()) != null);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.129 -0400", hash_original_method = "C79463E087C57C46760693ABFA80BBC0", hash_generated_method = "C98C91D39A9F3BEFB93FCDA1797AACCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readEntity(StringBuilder out, boolean isEntityToken, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        dsTaint.addTaint(throwOnResolveFailure);
        dsTaint.addTaint(isEntityToken);
        dsTaint.addTaint(out.dsTaint);
        dsTaint.addTaint(valueContext.dsTaint);
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
                position++;
            } //End block
            {
                position++;
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
            boolean varA99400345BFEEBA43EB55687A9AEA725_622227181 = (code.startsWith("#"));
            {
                try 
                {
                    int c;
                    boolean var58B0B78C684DF351B34A140D544263D1_1407347441 = (code.startsWith("#x"));
                    c = Integer.parseInt(code.substring(2), 16);
                    c = Integer.parseInt(code.substring(1));
                    out.delete(start, out.length());
                    out.appendCodePoint(c);
                    unresolved = false;
                } //End block
                catch (NumberFormatException notANumber)
                {
                    throw new XmlPullParserException("Invalid character reference: &" + code);
                } //End block
                catch (IllegalArgumentException invalidCodePoint)
                {
                    throw new XmlPullParserException("Invalid character reference: &" + code);
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
        char[] resolved = {'a'};
        {
            boolean var29EC81D908DBE184458A11C03BDBC90E_1839724764 = (documentEntities != null && (resolved = documentEntities.get(code)) != null);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.129 -0400", hash_original_method = "645533039846ABF2603AD0F9C774FE0D", hash_generated_method = "32368E9490F6D6A8948508FD909A074D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readValue(char delimiter, boolean resolveEntities, boolean throwOnResolveFailure,
            ValueContext valueContext) throws IOException, XmlPullParserException {
        dsTaint.addTaint(delimiter);
        dsTaint.addTaint(throwOnResolveFailure);
        dsTaint.addTaint(resolveEntities);
        dsTaint.addTaint(valueContext.dsTaint);
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
                    boolean varAA43907C5091E8F318632E4887CAA271_1357567114 = (!fillBuffer(1));
                    {
                        {
                            Object varC1032D8E10FF8C1780E71B7B4F2BB762_126502354 = (result.toString());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            char c;
            c = buffer[position];
            {
                isWhitespace &= (c <= ' ');
                position++;
            } //End block
            {
                result = new StringBuilder();
            } //End block
            result.append(buffer, start, position - start);
            {
                {
                    boolean varB70DE06ED34E6674DB3722520CE86044_260820581 = ((position + 1 < limit || fillBuffer(2)) && buffer[position + 1] == '\n');
                    {
                        position++;
                    } //End block
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
                    boolean varBA78E9D6F2E1941F7D37C98C4AF2F15C_263660882 = ((position + 2 < limit || fillBuffer(3))
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
            position++;
            result.append(c);
            start = position;
        } //End block
        {
            String var96767ECEA9A0CB58154F2DD98F8176EA_954410114 = (stringPool.get(buffer, start, position - start));
        } //End block
        {
            result.append(buffer, start, position - start);
            String varEC2CAD6F4392C35EA2158E6C5520B613_1859684957 = (result.toString());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.130 -0400", hash_original_method = "3B69F4FA17F01509E096A0868A2528ED", hash_generated_method = "C2084F57306B6493143680607F613DB1")
    @DSModeled(DSC.SAFE)
    private void read(char expected) throws IOException, XmlPullParserException {
        dsTaint.addTaint(expected);
        int c;
        c = peekCharacter();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.130 -0400", hash_original_method = "A7E267F0C0CB0F12A0F03D9AFED00521", hash_generated_method = "F351D38FA497B9FAE56D7F9A69841168")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void read(char[] chars) throws IOException, XmlPullParserException {
        dsTaint.addTaint(chars);
        {
            boolean varF0C73BB22A111A22F22F5EA6FB28FE41_497879533 = (position + chars.length >= limit && !fillBuffer(chars.length));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.130 -0400", hash_original_method = "902B3F7EB34CE06CF1D7162085CB95DC", hash_generated_method = "E096844E8887A3CC5EB1010470207FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int peekCharacter() throws IOException, XmlPullParserException {
        {
            boolean varD13F14E52E697416613A9489283EE2CE_533810828 = (position < limit || fillBuffer(1));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (position < limit || fillBuffer(1)) {
            //return buffer[position];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.130 -0400", hash_original_method = "DC49987172506F0F8D59FF3F96E536A7", hash_generated_method = "5A67F77A88E7D003C7F496D5CB5F6203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean fillBuffer(int minimum) throws IOException, XmlPullParserException {
        dsTaint.addTaint(minimum);
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
                    bufferStartLine++;
                    bufferStartColumn = 0;
                } //End block
                {
                    bufferStartColumn++;
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
            boolean var02F2209A5C0A570219740A85F11A9E73_815056981 = ((total = reader.read(buffer, limit, buffer.length - limit)) != -1);
            {
                limit += total;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.130 -0400", hash_original_method = "35E0733B1286860BF21842013F8FFA5F", hash_generated_method = "8A8D38D96E2E537AE955296ECE96F3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readName() throws IOException, XmlPullParserException {
        {
            boolean var5AB75DCE4678778E9ADB41C89957E4BF_981131309 = (position >= limit && !fillBuffer(1));
            {
                checkRelaxed("name expected");
            } //End block
        } //End collapsed parenthetic
        int start;
        start = position;
        StringBuilder result;
        result = null;
        char c;
        c = buffer[position];
        {
            position++;
        } //End block
        {
            checkRelaxed("name expected");
        } //End block
        {
            {
                {
                    result = new StringBuilder();
                } //End block
                result.append(buffer, start, position - start);
                {
                    boolean varAA43907C5091E8F318632E4887CAA271_235923890 = (!fillBuffer(1));
                    {
                        String var8EF4496AB0064774A8CF7EDEB4D5DB38_1917782845 = (result.toString());
                    } //End block
                } //End collapsed parenthetic
                start = position;
            } //End block
            c = buffer[position];
            {
                position++;
            } //End block
            {
                String var6AEC02BE7254FD8CD640E13F48B42447_1630512249 = (stringPool.get(buffer, start, position - start));
            } //End block
            {
                result.append(buffer, start, position - start);
                String varE23155153E525759C514C129CA381379_547868963 = (result.toString());
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.131 -0400", hash_original_method = "7FC6A162788F62EDDD44981BAC207FA9", hash_generated_method = "01A0431F52A4B3E36C9AD8D9F22927D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void skip() throws IOException, XmlPullParserException {
        {
            boolean varD13F14E52E697416613A9489283EE2CE_2081635462 = (position < limit || fillBuffer(1));
            {
                int c;
                c = buffer[position];
                position++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.131 -0400", hash_original_method = "46D251D7075E8F175BB5AD72794934F4", hash_generated_method = "B2D03D3AD2F5383CD4AFA1D18D3FF961")
    @DSModeled(DSC.SAFE)
    public void setInput(Reader reader) throws XmlPullParserException {
        dsTaint.addTaint(reader.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "EE8E194EE4DCB71C2C4B627C026D6CE3", hash_generated_method = "F7AD4EF8D4A7A9D21B7C300AEC0EA9A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInput(InputStream is, String charset) throws XmlPullParserException {
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(charset);
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
                                    boolean var04641ED6560813F64D7639A6D959AB94_1537778447 = (s.charAt(i0) != '"' && s.charAt(i0) != '\'');
                                    {
                                        i0++;
                                    } //End block
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
            limit = savedLimit;
            {
                boolean varAF965EEEE2C7D4A402FB6EA7B231688A_131396571 = (!detectCharset && peekCharacter() == 0xfeff);
                {
                    limit--;
                    System.arraycopy(buffer, 1, buffer, 0, limit);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (Exception e)
        {
            throw new XmlPullParserException("Invalid stream or encoding: " + e, this, e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "7002CA433E430A52F3D361978C362AC4", hash_generated_method = "E0C2DC2BCC3CA3A3C43CFA974EF8ECDF")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        {
            reader.close();
        } //End block
        // ---------- Original Method ----------
        //if (reader != null) {
            //reader.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "905F7B8816C5E28E92971A4DABCE5B48", hash_generated_method = "134DA254D9BBFA11550C79F6889BE27E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFeature(String feature) {
        dsTaint.addTaint(feature);
        {
            boolean var9760162B3F7AA5CCC8B91136021ACF54_424995198 = (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature));
            {
                boolean var019EFC6BD95914F8E676F56D5FDEF185_1392998202 = (FEATURE_RELAXED.equals(feature));
                {
                    boolean var824A1E488EAFEF118CCD0F5F4D56A2F4_1012110058 = (FEATURE_PROCESS_DOCDECL.equals(feature));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "A279F06C875438B49B8D4A1047D2C8F6", hash_generated_method = "7C971B165ED60716B39931B83154F05A")
    @DSModeled(DSC.SAFE)
    public String getInputEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "139FEB1FB1AC644E29BB2080E735DCAB", hash_generated_method = "55EBCCB43AB2D3872C857F881E176B3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void defineEntityReplacementText(String entity, String value) throws XmlPullParserException {
        dsTaint.addTaint(entity);
        dsTaint.addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "88B98FA49BAB9563CCFD697035E35769", hash_generated_method = "1EF0D80E0C5ECB2F71CCF46D311EAC25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getProperty(String property) {
        dsTaint.addTaint(property);
        {
            boolean var2920F0278EE964B54E63A722B25AD531_1712938268 = (property.equals(PROPERTY_XMLDECL_VERSION));
            {
                boolean var01C081004E61C93BA248DD27C2FE455D_1857626167 = (property.equals(PROPERTY_XMLDECL_STANDALONE));
                {
                    boolean var784BDB95B83DBD8BBC0FD2155AD4BFDB_1798524280 = (property.equals(PROPERTY_LOCATION));
                    {
                        {
                            Object var9303A400A6F4CEA0D89DEA68FC79F932_1384011627 = (reader.toString());
                        } //End flattened ternary
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "9C3E6BF1FDA5FCF82C61137F91620CE9", hash_generated_method = "D3CECDDFA2DED2AA8304FDD2C4F6D2E6")
    @DSModeled(DSC.SAFE)
    public String getRootElementName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return rootElementName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6EF27482968D634EC06A5CE842D09947")
    @DSModeled(DSC.SAFE)
    public String getSystemId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "7C29F0C6DC4E298965F868DC34008C67")
    @DSModeled(DSC.SAFE)
    public String getPublicId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "2B7C16F8E90DF968275251B3375CC301", hash_generated_method = "42BF38C80F983ECC6F5CFFA2FC925D1A")
    @DSModeled(DSC.SAFE)
    public int getNamespaceCount(int depth) {
        dsTaint.addTaint(depth);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (depth > this.depth) {
            //throw new IndexOutOfBoundsException();
        //}
        //return nspCounts[depth];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "DA805E6BD1FA77EA77FFD933A59A1A79", hash_generated_method = "14B826E5E325555B60C23D856AE77E97")
    @DSModeled(DSC.SAFE)
    public String getNamespacePrefix(int pos) {
        dsTaint.addTaint(pos);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return nspStack[pos * 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.132 -0400", hash_original_method = "BEA3C6D36DAA76218F10B33482B7D86B", hash_generated_method = "0A80C24FB675B38675B5B78AB84F450D")
    @DSModeled(DSC.SAFE)
    public String getNamespaceUri(int pos) {
        dsTaint.addTaint(pos);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return nspStack[(pos * 2) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "40F39B6FC2CBEA065A6E595C0C377D56", hash_generated_method = "C7542659005D927CDF9A82F60327D865")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNamespace(String prefix) {
        dsTaint.addTaint(prefix);
        {
            boolean var56127411105EF3D71B9CCE5F0E40D652_813557074 = ("xml".equals(prefix));
        } //End collapsed parenthetic
        {
            boolean var329E1608DCF39A88065813BCF90D4AD7_1986935475 = ("xmlns".equals(prefix));
        } //End collapsed parenthetic
        {
            int i;
            i = (getNamespaceCount(depth) << 1) - 2;
            i -= 2;
            {
                {
                    boolean var19919B58D04B466754D10E3F26461086_664317090 = (prefix.equals(nspStack[i]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "2727D3DF61FA7A382DF1D1BE4E6D35FA")
    @DSModeled(DSC.SAFE)
    public int getDepth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "B71BFE480A942DC6AFBA741559BFFBE0", hash_generated_method = "F264035ED154B18A3E728ADAEC6F3CCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositionDescription() {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                boolean varDAA30F2CB16032AE96BE08E6F6C22995_581148391 = (text.length() > 16);
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
        String var0C174602EFE4BFBCB80A7056CFA680FB_1159806342 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "114340E3BA1FFC2D8A54D30C75AB06FF", hash_generated_method = "D7FB65063C10E6BD8F5035D115A57402")
    @DSModeled(DSC.SAFE)
    public int getLineNumber() {
        int result;
        result = bufferStartLine;
        {
            int i;
            i = 0;
            {
                {
                    result++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = bufferStartLine;
        //for (int i = 0; i < position; i++) {
            //if (buffer[i] == '\n') {
                //result++;
            //}
        //}
        //return result + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "C138C40AD0ECD6D56D342D21687BD452", hash_generated_method = "9BA10C175E7EAE63D15CB1B4A30219A2")
    @DSModeled(DSC.SAFE)
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
                {
                    result++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "152BCFAF579D72B6DEF962950FEC2A17", hash_generated_method = "0EF08387FE71CF904DFC9ADC24269CA0")
    @DSModeled(DSC.SAFE)
    public boolean isWhitespace() throws XmlPullParserException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (type != TEXT && type != IGNORABLE_WHITESPACE && type != CDSECT) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return isWhitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "96BD4C193A5C47E4BA7EA81CE7C395CC", hash_generated_method = "BD93BC7CA05B0C21290E10DF7B37560B")
    @DSModeled(DSC.SAFE)
    public String getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (type < TEXT || (type == ENTITY_REF && unresolved)) {
            //return null;
        //} else if (text == null) {
            //return "";
        //} else {
            //return text;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.133 -0400", hash_original_method = "17ADAF2C34EC5E5726D60154CDE0E31A", hash_generated_method = "960E27C7B3ABAC871F658194269B5DD4")
    @DSModeled(DSC.SAFE)
    public char[] getTextCharacters(int[] poslen) {
        dsTaint.addTaint(poslen);
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
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "A99E1DDB500E37E7767EA602F963D96D", hash_generated_method = "34E80EF6E0F69C26CDF71A617F34161D")
    @DSModeled(DSC.SAFE)
    public String getNamespace() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return namespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "1E51036783D3EFB4EF70571BDF972FC8")
    @DSModeled(DSC.SAFE)
    public String getPrefix() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "BB5C193EDDCF2188F64023D36680FCC7", hash_generated_method = "755E36D5891D092A02E8A11FB46FA504")
    @DSModeled(DSC.SAFE)
    public boolean isEmptyElementTag() throws XmlPullParserException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (type != START_TAG) {
            //throw new XmlPullParserException(ILLEGAL_TYPE, this, null);
        //}
        //return degenerated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "E7902A71CF05159AEACA5707956D2FB0", hash_generated_method = "256DB44ABE9900F58CD3D73EC0EC0E9A")
    @DSModeled(DSC.SAFE)
    public int getAttributeCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return attributeCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "D075B222334138AA51A395211AD5E8BA", hash_generated_method = "16E131B7F489670E54E5FA51F190E05A")
    @DSModeled(DSC.SAFE)
    public String getAttributeType(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "CDATA";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "506EE66AC609639C08948796E644B012", hash_generated_method = "7B25D2FBE95B58B6E35609FEBAD9C8A4")
    @DSModeled(DSC.SAFE)
    public boolean isAttributeDefault(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "1DC23C46494192E0CB67B725251C6942", hash_generated_method = "3BD8E2ED141974913321385034691E86")
    @DSModeled(DSC.SAFE)
    public String getAttributeNamespace(int index) {
        dsTaint.addTaint(index);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[index * 4];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "07BD775DFF4E9B04837F88C1E2748FE1", hash_generated_method = "6B53E4806FBF1F081701BEE86F5C444D")
    @DSModeled(DSC.SAFE)
    public String getAttributeName(int index) {
        dsTaint.addTaint(index);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 2];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "C689E94E86EA5FE91ACCD87E01866231", hash_generated_method = "840A4C505DCF3AF1776DF2C1E1F142BE")
    @DSModeled(DSC.SAFE)
    public String getAttributePrefix(int index) {
        dsTaint.addTaint(index);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "BF5E04E32ADD7672259D8C86F2C8D631", hash_generated_method = "8A4DA6E393875945E9F6AF599585F6DF")
    @DSModeled(DSC.SAFE)
    public String getAttributeValue(int index) {
        dsTaint.addTaint(index);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (index >= attributeCount) {
            //throw new IndexOutOfBoundsException();
        //}
        //return attributes[(index * 4) + 3];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "D0AC7DE2A29C82DADA1B505288DAC27D", hash_generated_method = "A1589ADD37A771B5F965FF9B5C8267F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAttributeValue(String namespace, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(namespace);
        {
            int i;
            i = (attributeCount * 4) - 4;
            i -= 4;
            {
                {
                    boolean var47349E615B9664FECFB917121CFA114F_1522212892 = (attributes[i + 2].equals(name)
                    && (namespace == null || attributes[i].equals(namespace)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //for (int i = (attributeCount * 4) - 4; i >= 0; i -= 4) {
            //if (attributes[i + 2].equals(name)
                    //&& (namespace == null || attributes[i].equals(namespace))) {
                //return attributes[i + 3];
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "0457ED08CBFC1348E0AAA3CE0D692605", hash_generated_method = "B0A935FB73914640BAB8E9F9DCBF080A")
    @DSModeled(DSC.SAFE)
    public int getEventType() throws XmlPullParserException {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "53E7D5238284732F8540E3833F26B112", hash_generated_method = "928440BDB9531552C77BCD351BDA1DE1")
    @DSModeled(DSC.SAFE)
    public int nextTag() throws XmlPullParserException, IOException {
        next();
        {
            next();
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("unexpected type", this, null);
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.134 -0400", hash_original_method = "C4BF1BB4C255F6013F5858579D851AD3", hash_generated_method = "DA1BAA8EEA39AD20081E11AF4C6B5BB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void require(int type, String namespace, String name) throws XmlPullParserException, IOException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(type);
        dsTaint.addTaint(namespace);
        {
            boolean varC944AD0162EFA3375CCB269661747DD7_1411185955 = (type != this.type
                || (namespace != null && !namespace.equals(getNamespace()))
                || (name != null && !name.equals(getName())));
            {
                throw new XmlPullParserException(
                    "expected: " + TYPES[type] + " {" + namespace + "}" + name, this, null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (type != this.type
                //|| (namespace != null && !namespace.equals(getNamespace()))
                //|| (name != null && !name.equals(getName()))) {
            //throw new XmlPullParserException(
                    //"expected: " + TYPES[type] + " {" + namespace + "}" + name, this, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.135 -0400", hash_original_method = "102A6610D1A439DBBB62D3798FEF6670", hash_generated_method = "75F2633702A3F10EACF73548D038FBE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextText() throws XmlPullParserException, IOException {
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.135 -0400", hash_original_method = "DD2B8D14469BF5F6853E930DFF62942D", hash_generated_method = "525ABB71A315F3D88C771F020802CACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFeature(String feature, boolean value) throws XmlPullParserException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(feature);
        {
            boolean var9760162B3F7AA5CCC8B91136021ACF54_1430954968 = (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature));
            {
                boolean varDAAE59AD80DC7E8FB2D89FCF61BDADCB_574787612 = (XmlPullParser.FEATURE_PROCESS_DOCDECL.equals(feature));
                {
                    boolean varA1DC7E273DEAF4169FD3F94A9162735F_1738607050 = (FEATURE_RELAXED.equals(feature));
                    {
                        throw new XmlPullParserException("unsupported feature: " + feature, this, null);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.135 -0400", hash_original_method = "BB78C28304FA5EA99DAD361D5123F3A6", hash_generated_method = "12ED1EBDC3B3706C79A477719E824C59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProperty(String property, Object value) throws XmlPullParserException {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(property);
        {
            boolean varDDBF2C6AF46A27BDBAB0C7C42C7E43D3_590881600 = (property.equals(PROPERTY_LOCATION));
            {
                location = String.valueOf(value);
            } //End block
            {
                throw new XmlPullParserException("unsupported property: " + property);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (property.equals(PROPERTY_LOCATION)) {
            //location = String.valueOf(value);
        //} else {
            //throw new XmlPullParserException("unsupported property: " + property);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.135 -0400", hash_original_method = "8F280A3CDA5A3533C9FB5C99B2A6A6C2", hash_generated_method = "4668F322760DC121A639448CD233D493")
    @DSModeled(DSC.SAFE)
    private void pushContentSource(char[] newBuffer) {
        dsTaint.addTaint(newBuffer);
        nextContentSource = new ContentSource(nextContentSource, buffer, position, limit);
        position = 0;
        limit = newBuffer.length;
        // ---------- Original Method ----------
        //nextContentSource = new ContentSource(nextContentSource, buffer, position, limit);
        //buffer = newBuffer;
        //position = 0;
        //limit = newBuffer.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.135 -0400", hash_original_method = "E5A180E871F653CC9F75C9B7A9F73687", hash_generated_method = "D1A4D7FD7A5C5A994E10764F66362914")
    @DSModeled(DSC.SAFE)
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
        private final ContentSource next;
        private final char[] buffer;
        private final int position;
        private final int limit;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.135 -0400", hash_original_method = "BC47C2124096A91C278868E0B05F486C", hash_generated_method = "01CE21D7EC849CB82EF4E9BCCA3428AB")
        @DSModeled(DSC.SAFE)
         ContentSource(ContentSource next, char[] buffer, int position, int limit) {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(position);
            dsTaint.addTaint(limit);
            dsTaint.addTaint(next.dsTaint);
            this.limit = limit;
            this.position = position;
            this.next = next;
            this.buffer = buffer;
            // ---------- Original Method ----------
            //this.next = next;
            //this.buffer = buffer;
            //this.position = position;
            //this.limit = limit;
        }

        
    }


    
    static {
        DEFAULT_ENTITIES.put("lt", "<");
        DEFAULT_ENTITIES.put("gt", ">");
        DEFAULT_ENTITIES.put("amp", "&");
        DEFAULT_ENTITIES.put("apos", "'");
        DEFAULT_ENTITIES.put("quot", "\"");
    }
    
}


