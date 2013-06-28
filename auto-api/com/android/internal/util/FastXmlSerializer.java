package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public class FastXmlSerializer implements XmlSerializer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_field = "647ED90A988F1C0B81C4839B3C8E833A", hash_generated_field = "5E7BC4B7A0E4B0267814CE95DA4CE493")

    private final char[] mText = new char[BUFFER_LEN];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_field = "497C65F1D23B4FA8053AFA36BCF69100", hash_generated_field = "43DF8FED0AB3E82A21BAF8454C91DA12")

    private Writer mWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_field = "7D82C7E576FE00FBAD310016B0E82A46", hash_generated_field = "55417565DD3006A9600CB708A96EDA0C")

    private OutputStream mOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_field = "72CD8B47CBDE50A23C6025D18B698226", hash_generated_field = "7AD13F175ACC49B2AFF8D253EE3A496C")

    private CharsetEncoder mCharset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_field = "D967587C6622EC0564253D27D889A05D", hash_generated_field = "48B6C689C33353333CE187E3FF0FA34D")

    private ByteBuffer mBytes = ByteBuffer.allocate(BUFFER_LEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_field = "782DC1AB40D36CE6D2E382035836D20D", hash_generated_field = "EF3E29BFAF7BB3B897FCD2054D06CB59")

    private boolean mInTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.672 -0400", hash_original_method = "14D217AC288267AE1031A94F745E4E30", hash_generated_method = "14D217AC288267AE1031A94F745E4E30")
    public FastXmlSerializer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.673 -0400", hash_original_method = "7F8A4FBBB421106585A40A4ABA627D34", hash_generated_method = "2908E37A1837F43CC53ED2B966DC32FE")
    private void append(char c) throws IOException {
        int pos = mPos;
        {
            flush();
            pos = mPos;
        } //End block
        mText[pos] = c;
        mPos = pos+1;
        // ---------- Original Method ----------
        //int pos = mPos;
        //if (pos >= (BUFFER_LEN-1)) {
            //flush();
            //pos = mPos;
        //}
        //mText[pos] = c;
        //mPos = pos+1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.673 -0400", hash_original_method = "FE048AE8183F447BAD2B7EF704E010CC", hash_generated_method = "2C63C7630215439126EA4243651E072E")
    private void append(String str, int i, final int length) throws IOException {
        {
            final int end = i + length;
            {
                int next = i + BUFFER_LEN;
                append(str, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            } //End block
        } //End block
        int pos = mPos;
        {
            flush();
            pos = mPos;
        } //End block
        str.getChars(i, i+length, mText, pos);
        mPos = pos + length;
        addTaint(str.getTaint());
        addTaint(i);
        // ---------- Original Method ----------
        //if (length > BUFFER_LEN) {
            //final int end = i + length;
            //while (i < end) {
                //int next = i + BUFFER_LEN;
                //append(str, i, next<end ? BUFFER_LEN : (end-i));
                //i = next;
            //}
            //return;
        //}
        //int pos = mPos;
        //if ((pos+length) > BUFFER_LEN) {
            //flush();
            //pos = mPos;
        //}
        //str.getChars(i, i+length, mText, pos);
        //mPos = pos + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.674 -0400", hash_original_method = "A84A951371BFD4434741842D4AA34429", hash_generated_method = "54AA370C065FEB6B9BB00BC833E372DA")
    private void append(char[] buf, int i, final int length) throws IOException {
        {
            final int end = i + length;
            {
                int next = i + BUFFER_LEN;
                append(buf, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            } //End block
        } //End block
        int pos = mPos;
        {
            flush();
            pos = mPos;
        } //End block
        System.arraycopy(buf, i, mText, pos, length);
        mPos = pos + length;
        addTaint(buf[0]);
        addTaint(i);
        // ---------- Original Method ----------
        //if (length > BUFFER_LEN) {
            //final int end = i + length;
            //while (i < end) {
                //int next = i + BUFFER_LEN;
                //append(buf, i, next<end ? BUFFER_LEN : (end-i));
                //i = next;
            //}
            //return;
        //}
        //int pos = mPos;
        //if ((pos+length) > BUFFER_LEN) {
            //flush();
            //pos = mPos;
        //}
        //System.arraycopy(buf, i, mText, pos, length);
        //mPos = pos + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.674 -0400", hash_original_method = "E6E865A25D7068974BFDA6B3F14B9E04", hash_generated_method = "B80615D5C0CE0A0837164C88A15F3503")
    private void append(String str) throws IOException {
        append(str, 0, str.length());
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //append(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.674 -0400", hash_original_method = "685D23784A67F08835F67CA0A97F5B9B", hash_generated_method = "599D5CE0A1C23BCC289F3B58FE34E7E6")
    private void escapeAndAppendString(final String string) throws IOException {
        final int N = string.length();
        final char NE = (char)ESCAPE_TABLE.length;
        final String[] escapes = ESCAPE_TABLE;
        int lastPos = 0;
        int pos;
        {
            pos=0;
            {
                char c = string.charAt(pos);
                String escape = escapes[c];
                append(string, lastPos, pos-lastPos);
                lastPos = pos + 1;
                append(escape);
            } //End block
        } //End collapsed parenthetic
        append(string, lastPos, pos-lastPos);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
        //final int N = string.length();
        //final char NE = (char)ESCAPE_TABLE.length;
        //final String[] escapes = ESCAPE_TABLE;
        //int lastPos = 0;
        //int pos;
        //for (pos=0; pos<N; pos++) {
            //char c = string.charAt(pos);
            //if (c >= NE) continue;
            //String escape = escapes[c];
            //if (escape == null) continue;
            //if (lastPos < pos) append(string, lastPos, pos-lastPos);
            //lastPos = pos + 1;
            //append(escape);
        //}
        //if (lastPos < pos) append(string, lastPos, pos-lastPos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.675 -0400", hash_original_method = "9EEFDA601F6AD1629A39B78C5EDBBF73", hash_generated_method = "0064B3362AEA92C04EDD233025CE5EC1")
    private void escapeAndAppendString(char[] buf, int start, int len) throws IOException {
        final char NE = (char)ESCAPE_TABLE.length;
        final String[] escapes = ESCAPE_TABLE;
        int end = start+len;
        int lastPos = start;
        int pos;
        {
            pos=start;
            {
                char c = buf[pos];
                String escape = escapes[c];
                append(buf, lastPos, pos-lastPos);
                lastPos = pos + 1;
                append(escape);
            } //End block
        } //End collapsed parenthetic
        append(buf, lastPos, pos-lastPos);
        addTaint(buf[0]);
        addTaint(start);
        addTaint(len);
        // ---------- Original Method ----------
        //final char NE = (char)ESCAPE_TABLE.length;
        //final String[] escapes = ESCAPE_TABLE;
        //int end = start+len;
        //int lastPos = start;
        //int pos;
        //for (pos=start; pos<end; pos++) {
            //char c = buf[pos];
            //if (c >= NE) continue;
            //String escape = escapes[c];
            //if (escape == null) continue;
            //if (lastPos < pos) append(buf, lastPos, pos-lastPos);
            //lastPos = pos + 1;
            //append(escape);
        //}
        //if (lastPos < pos) append(buf, lastPos, pos-lastPos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.676 -0400", hash_original_method = "7E5AB062E349C3088BFBC8393DC59A5F", hash_generated_method = "30651B5D90F1343252B9FDA50A5A3340")
    public XmlSerializer attribute(String namespace, String name, String value) throws IOException,
            IllegalArgumentException, IllegalStateException {
        XmlSerializer varB4EAC82CA7396A68D541C85D26508E83_2093470642 = null; //Variable for return #1
        append(' ');
        {
            append(namespace);
            append(':');
        } //End block
        append(name);
        append("=\"");
        escapeAndAppendString(value);
        append('"');
        varB4EAC82CA7396A68D541C85D26508E83_2093470642 = this;
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2093470642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2093470642;
        // ---------- Original Method ----------
        //append(' ');
        //if (namespace != null) {
            //append(namespace);
            //append(':');
        //}
        //append(name);
        //append("=\"");
        //escapeAndAppendString(value);
        //append('"');
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.677 -0400", hash_original_method = "F172E1D42CC08E9B544FD2567DB97884", hash_generated_method = "E377482BC37EF22FC68797039168C810")
    public void cdsect(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.678 -0400", hash_original_method = "E109160ABCFAB770C18CF7CC0F2B8829", hash_generated_method = "4CF57A56295095A8219820CB346D8F69")
    public void comment(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.678 -0400", hash_original_method = "11FAE83A37D776002915A948C64CD63F", hash_generated_method = "0912D491B4967466F27D2D933599E778")
    public void docdecl(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.678 -0400", hash_original_method = "1B99F1BEFCF86F47AB36CD07598B151B", hash_generated_method = "BF20983D9077DC4EE2ECB5B538CCC3C3")
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
        // ---------- Original Method ----------
        //flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.679 -0400", hash_original_method = "8586CBBE84EF5F3F7F367B466316141A", hash_generated_method = "4D9C91FE83BDFA2F54EE7181F5819ED1")
    public XmlSerializer endTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        XmlSerializer varB4EAC82CA7396A68D541C85D26508E83_1857057812 = null; //Variable for return #1
        {
            append(" />\n");
        } //End block
        {
            append("</");
            {
                append(namespace);
                append(':');
            } //End block
            append(name);
            append(">\n");
        } //End block
        mInTag = false;
        varB4EAC82CA7396A68D541C85D26508E83_1857057812 = this;
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1857057812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1857057812;
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(" />\n");
        //} else {
            //append("</");
            //if (namespace != null) {
                //append(namespace);
                //append(':');
            //}
            //append(name);
            //append(">\n");
        //}
        //mInTag = false;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.679 -0400", hash_original_method = "E509685A6C63D2EAA11B8F86DFCB8A1B", hash_generated_method = "7BBC721F6C47FB443A2F0FD4C61A546D")
    public void entityRef(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.679 -0400", hash_original_method = "8B5DC0C8EFBE829D5900DCFC0D2617F4", hash_generated_method = "2BD46E0D5A2D9977C4439029CC38196C")
    private void flushBytes() throws IOException {
        int position;
        {
            boolean var3E2D24EA3EA04F9938C91FDB950DB38F_1406359828 = ((position = mBytes.position()) > 0);
            {
                mBytes.flip();
                mOutputStream.write(mBytes.array(), 0, position);
                mBytes.clear();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int position;
        //if ((position = mBytes.position()) > 0) {
            //mBytes.flip();
            //mOutputStream.write(mBytes.array(), 0, position);
            //mBytes.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.680 -0400", hash_original_method = "D60A1C44513D9E8C5B891F5551C5FBBA", hash_generated_method = "5E9C7204E357A3674338AD6FA4E55E22")
    public void flush() throws IOException {
        {
            {
                CharBuffer charBuffer = CharBuffer.wrap(mText, 0, mPos);
                CoderResult result = mCharset.encode(charBuffer, mBytes, true);
                {
                    {
                        boolean var75B0C16DF10B35C8B57E80930C8BC933_778963049 = (result.isError());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException(result.toString());
                        } //End block
                        {
                            boolean var04B428D94E563FD2907D1DF20A1DDE98_1446938011 = (result.isOverflow());
                            {
                                flushBytes();
                                result = mCharset.encode(charBuffer, mBytes, true);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                flushBytes();
                mOutputStream.flush();
            } //End block
            {
                mWriter.write(mText, 0, mPos);
                mWriter.flush();
            } //End block
            mPos = 0;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.680 -0400", hash_original_method = "06A4B22AA2E8AAA8ED4F22B001D0D1FC", hash_generated_method = "76BA736BD74CB0655230B649DF0737E4")
    public int getDepth() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188840632 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1188840632;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.681 -0400", hash_original_method = "A938A921621E94044F2CFA3DC31C9E8C", hash_generated_method = "5BE244DC4C6120899CEDB7173EEE1702")
    public boolean getFeature(String name) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964712714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_964712714;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.681 -0400", hash_original_method = "6A642C9EEC23AC32ED606658DA110E38", hash_generated_method = "9F6BA6B6F80DB39C1FBA96C0289B4A59")
    public String getName() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.681 -0400", hash_original_method = "8F74E2B7FCD796BC320C8C37775EA11E", hash_generated_method = "70604486E0CC1301AEA1D29B2BE6FA92")
    public String getNamespace() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.682 -0400", hash_original_method = "1ADA26C4B32C10D168CE4DC5A8DC35EC", hash_generated_method = "4B631B1407B13363356B402AA22C28F2")
    public String getPrefix(String namespace, boolean generatePrefix) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(namespace.getTaint());
        addTaint(generatePrefix);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.682 -0400", hash_original_method = "DA8A49250701B8FD4E3C9A3CEF97A891", hash_generated_method = "2C46EC45D861F1CE98B9BA0DED8B783D")
    public Object getProperty(String name) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.682 -0400", hash_original_method = "3EA2D897BB6C3BC43607B7AF9CA20B7F", hash_generated_method = "8AF1F13D1BC3BE82C2AB20D78244CB61")
    public void ignorableWhitespace(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.683 -0400", hash_original_method = "7E88F58557263ECFFAB9D7472E34A31A", hash_generated_method = "2BE49AA39051918EB095984DDE17E190")
    public void processingInstruction(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.683 -0400", hash_original_method = "5124EC4444894C7656E2A35FD8B594F3", hash_generated_method = "3DFF0604714AE35E39CB9249F549DCB2")
    public void setFeature(String name, boolean state) throws IllegalArgumentException,
            IllegalStateException {
        {
            boolean varBFD803D33F5D5A09992C9ED98F06B7DE_2097748812 = (name.equals("http://xmlpull.org/v1/doc/features.html#indent-output"));
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(name.getTaint());
        addTaint(state);
        // ---------- Original Method ----------
        //if (name.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            //return;
        //}
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.683 -0400", hash_original_method = "13E00C790126A70B4466C6B565B1D4E5", hash_generated_method = "9BAFFF5ED73AAC75AD73887EA2A9AB1C")
    public void setOutput(OutputStream os, String encoding) throws IOException,
            IllegalArgumentException, IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        {
            try 
            {
                mCharset = Charset.forName(encoding).newEncoder();
            } //End block
            catch (IllegalCharsetNameException e)
            {
                if (DroidSafeAndroidRuntime.control) throw (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        encoding).initCause(e));
            } //End block
            catch (UnsupportedCharsetException e)
            {
                if (DroidSafeAndroidRuntime.control) throw (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        encoding).initCause(e));
            } //End block
            mOutputStream = os;
        } //End block
        {
            setOutput(
                encoding == null
                    ? new OutputStreamWriter(os)
                    : new OutputStreamWriter(os, encoding));
        } //End block
        // ---------- Original Method ----------
        //if (os == null)
            //throw new IllegalArgumentException();
        //if (true) {
            //try {
                //mCharset = Charset.forName(encoding).newEncoder();
            //} catch (IllegalCharsetNameException e) {
                //throw (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        //encoding).initCause(e));
            //} catch (UnsupportedCharsetException e) {
                //throw (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        //encoding).initCause(e));
            //}
            //mOutputStream = os;
        //} else {
            //setOutput(
                //encoding == null
                    //? new OutputStreamWriter(os)
                    //: new OutputStreamWriter(os, encoding));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.684 -0400", hash_original_method = "66C59149F26C5606D1058F17E91C2E36", hash_generated_method = "19FF5C74DB405E85A6CA055D58E4DA60")
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException,
            IllegalStateException {
        mWriter = writer;
        // ---------- Original Method ----------
        //mWriter = writer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.684 -0400", hash_original_method = "202C0F3DB21954078DC527D4BA1F5AD5", hash_generated_method = "73B4777E5EAFFF2862E1F310AD664B24")
    public void setPrefix(String prefix, String namespace) throws IOException,
            IllegalArgumentException, IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(prefix.getTaint());
        addTaint(namespace.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.684 -0400", hash_original_method = "C7E5AAECD061448068B655F2A9283D67", hash_generated_method = "1D5A7A18FD880E68DFDBD460B5654DFC")
    public void setProperty(String name, Object value) throws IllegalArgumentException,
            IllegalStateException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.684 -0400", hash_original_method = "00343745042AD39FAACA3392E54AE598", hash_generated_method = "CDD98FC01DD406E476A696FB9A64C6A7")
    public void startDocument(String encoding, Boolean standalone) throws IOException,
            IllegalArgumentException, IllegalStateException {
        append("<?xml version='1.0' encoding='utf-8' standalone='"
                + (standalone ? "yes" : "no") + "' ?>\n");
        addTaint(encoding.getTaint());
        addTaint(standalone.getTaint());
        // ---------- Original Method ----------
        //append("<?xml version='1.0' encoding='utf-8' standalone='"
                //+ (standalone ? "yes" : "no") + "' ?>\n");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.685 -0400", hash_original_method = "68622A1CFABB0F79BB6AD105FC0B8924", hash_generated_method = "09248A0979CB00EFF23F2D7EC19AD02D")
    public XmlSerializer startTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        XmlSerializer varB4EAC82CA7396A68D541C85D26508E83_748768765 = null; //Variable for return #1
        {
            append(">\n");
        } //End block
        append('<');
        {
            append(namespace);
            append(':');
        } //End block
        append(name);
        mInTag = true;
        varB4EAC82CA7396A68D541C85D26508E83_748768765 = this;
        addTaint(namespace.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_748768765.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_748768765;
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(">\n");
        //}
        //append('<');
        //if (namespace != null) {
            //append(namespace);
            //append(':');
        //}
        //append(name);
        //mInTag = true;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.686 -0400", hash_original_method = "970D088B7C9B3DFA080857980C9C58B4", hash_generated_method = "2C3C2F55796567DA17A7F864485B5D30")
    public XmlSerializer text(char[] buf, int start, int len) throws IOException,
            IllegalArgumentException, IllegalStateException {
        XmlSerializer varB4EAC82CA7396A68D541C85D26508E83_1345747864 = null; //Variable for return #1
        {
            append(">");
            mInTag = false;
        } //End block
        escapeAndAppendString(buf, start, len);
        varB4EAC82CA7396A68D541C85D26508E83_1345747864 = this;
        addTaint(buf[0]);
        addTaint(start);
        addTaint(len);
        varB4EAC82CA7396A68D541C85D26508E83_1345747864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1345747864;
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(">");
            //mInTag = false;
        //}
        //escapeAndAppendString(buf, start, len);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.687 -0400", hash_original_method = "CC58EC59F0344E947C053701B4F98937", hash_generated_method = "AE667424F9849506980F41961B483133")
    public XmlSerializer text(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        XmlSerializer varB4EAC82CA7396A68D541C85D26508E83_617591508 = null; //Variable for return #1
        {
            append(">");
            mInTag = false;
        } //End block
        escapeAndAppendString(text);
        varB4EAC82CA7396A68D541C85D26508E83_617591508 = this;
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_617591508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_617591508;
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(">");
            //mInTag = false;
        //}
        //escapeAndAppendString(text);
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.709 -0400", hash_original_field = "03620A30EC5528C866EBA1EE2D6FF7F8", hash_generated_field = "CCB993A2E3DB7640A0C69D08BAC36477")

    private static final String ESCAPE_TABLE[] = new String[] {
        null,     null,     null,     null,     null,     null,     null,     null,  
        null,     null,     null,     null,     null,     null,     null,     null,  
        null,     null,     null,     null,     null,     null,     null,     null,  
        null,     null,     null,     null,     null,     null,     null,     null,  
        null,     null,     "&quot;", null,     null,     null,     "&amp;",  null,  
        null,     null,     null,     null,     null,     null,     null,     null,  
        null,     null,     null,     null,     null,     null,     null,     null,  
        null,     null,     null,     null,     "&lt;",   null,     "&gt;",   null,  
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.709 -0400", hash_original_field = "019A412F8F4585379F03F103828346EC", hash_generated_field = "87B505129A889694149659B3C7493691")

    private static final int BUFFER_LEN = 8192;
}

