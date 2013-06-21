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
    private char[] mText = new char[BUFFER_LEN];
    private int mPos;
    private Writer mWriter;
    private OutputStream mOutputStream;
    private CharsetEncoder mCharset;
    private ByteBuffer mBytes = ByteBuffer.allocate(BUFFER_LEN);
    private boolean mInTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.670 -0400", hash_original_method = "27CE058980A21830E70084C8451D97F4", hash_generated_method = "27CE058980A21830E70084C8451D97F4")
        public FastXmlSerializer ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.671 -0400", hash_original_method = "7F8A4FBBB421106585A40A4ABA627D34", hash_generated_method = "E156946D3FE1D6539DFA4A0001A88BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void append(char c) throws IOException {
        dsTaint.addTaint(c);
        int pos;
        pos = mPos;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.671 -0400", hash_original_method = "FE048AE8183F447BAD2B7EF704E010CC", hash_generated_method = "1DF2A946F554603C34BA449A872953A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void append(String str, int i, final int length) throws IOException {
        dsTaint.addTaint(str);
        dsTaint.addTaint(length);
        dsTaint.addTaint(i);
        {
            int end;
            end = i + length;
            {
                int next;
                next = i + BUFFER_LEN;
                append(str, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            } //End block
        } //End block
        int pos;
        pos = mPos;
        {
            flush();
            pos = mPos;
        } //End block
        str.getChars(i, i+length, mText, pos);
        mPos = pos + length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.671 -0400", hash_original_method = "A84A951371BFD4434741842D4AA34429", hash_generated_method = "EB1FD1E7D84FB9E2418E812288920857")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void append(char[] buf, int i, final int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(buf[0]);
        dsTaint.addTaint(i);
        {
            int end;
            end = i + length;
            {
                int next;
                next = i + BUFFER_LEN;
                append(buf, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            } //End block
        } //End block
        int pos;
        pos = mPos;
        {
            flush();
            pos = mPos;
        } //End block
        System.arraycopy(buf, i, mText, pos, length);
        mPos = pos + length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.672 -0400", hash_original_method = "E6E865A25D7068974BFDA6B3F14B9E04", hash_generated_method = "70BE8745F7DAFF9CC8330216602CA168")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void append(String str) throws IOException {
        dsTaint.addTaint(str);
        append(str, 0, str.length());
        // ---------- Original Method ----------
        //append(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.672 -0400", hash_original_method = "685D23784A67F08835F67CA0A97F5B9B", hash_generated_method = "2CD63907AE54004EA2E70B5BD567E5AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void escapeAndAppendString(final String string) throws IOException {
        dsTaint.addTaint(string);
        int N;
        N = string.length();
        char NE;
        NE = (char)ESCAPE_TABLE.length;
        String[] escapes;
        escapes = ESCAPE_TABLE;
        int lastPos;
        lastPos = 0;
        int pos;
        {
            pos=0;
            {
                char c;
                c = string.charAt(pos);
                String escape;
                escape = escapes[c];
                append(string, lastPos, pos-lastPos);
                lastPos = pos + 1;
                append(escape);
            } //End block
        } //End collapsed parenthetic
        append(string, lastPos, pos-lastPos);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.672 -0400", hash_original_method = "9EEFDA601F6AD1629A39B78C5EDBBF73", hash_generated_method = "9C1B89AF871A7DC43973273C5C544742")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void escapeAndAppendString(char[] buf, int start, int len) throws IOException {
        dsTaint.addTaint(start);
        dsTaint.addTaint(len);
        dsTaint.addTaint(buf[0]);
        char NE;
        NE = (char)ESCAPE_TABLE.length;
        String[] escapes;
        escapes = ESCAPE_TABLE;
        int end;
        end = start+len;
        int lastPos;
        lastPos = start;
        int pos;
        {
            pos=start;
            {
                char c;
                c = buf[pos];
                String escape;
                escape = escapes[c];
                append(buf, lastPos, pos-lastPos);
                lastPos = pos + 1;
                append(escape);
            } //End block
        } //End collapsed parenthetic
        append(buf, lastPos, pos-lastPos);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.673 -0400", hash_original_method = "7E5AB062E349C3088BFBC8393DC59A5F", hash_generated_method = "E1959CEF5816017F66E15A589631FAE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlSerializer attribute(String namespace, String name, String value) throws IOException,
            IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        dsTaint.addTaint(namespace);
        append(' ');
        {
            append(namespace);
            append(':');
        } //End block
        append(name);
        append("=\"");
        escapeAndAppendString(value);
        append('"');
        return (XmlSerializer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.673 -0400", hash_original_method = "F172E1D42CC08E9B544FD2567DB97884", hash_generated_method = "75737A2569A7FC1A75F3D02898CABED8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cdsect(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(text);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.673 -0400", hash_original_method = "E109160ABCFAB770C18CF7CC0F2B8829", hash_generated_method = "32FCA59C3F27AC73E2FEEA53088DAC13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void comment(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(text);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.673 -0400", hash_original_method = "11FAE83A37D776002915A948C64CD63F", hash_generated_method = "4790DA680B8F41A81439E1B81B408D68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void docdecl(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(text);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.674 -0400", hash_original_method = "1B99F1BEFCF86F47AB36CD07598B151B", hash_generated_method = "BF20983D9077DC4EE2ECB5B538CCC3C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
        // ---------- Original Method ----------
        //flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.674 -0400", hash_original_method = "8586CBBE84EF5F3F7F367B466316141A", hash_generated_method = "A32CE71EF695FD53094FDAC2A9C5B383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlSerializer endTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(namespace);
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
        return (XmlSerializer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.674 -0400", hash_original_method = "E509685A6C63D2EAA11B8F86DFCB8A1B", hash_generated_method = "686C510A408EDF73C3077391A09219D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void entityRef(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(text);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.674 -0400", hash_original_method = "8B5DC0C8EFBE829D5900DCFC0D2617F4", hash_generated_method = "C62488F9093510CF54555EE5FF835CE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flushBytes() throws IOException {
        int position;
        {
            boolean var3E2D24EA3EA04F9938C91FDB950DB38F_268351060 = ((position = mBytes.position()) > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.675 -0400", hash_original_method = "D60A1C44513D9E8C5B891F5551C5FBBA", hash_generated_method = "23016293AAAEDDD50159C5E0F9D27D58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void flush() throws IOException {
        {
            {
                CharBuffer charBuffer;
                charBuffer = CharBuffer.wrap(mText, 0, mPos);
                CoderResult result;
                result = mCharset.encode(charBuffer, mBytes, true);
                {
                    {
                        boolean var75B0C16DF10B35C8B57E80930C8BC933_2016015272 = (result.isError());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException(result.toString());
                        } //End block
                        {
                            boolean var04B428D94E563FD2907D1DF20A1DDE98_1224312324 = (result.isOverflow());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.675 -0400", hash_original_method = "06A4B22AA2E8AAA8ED4F22B001D0D1FC", hash_generated_method = "59E0279C513B4D6D823F41DDFE22543A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDepth() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.675 -0400", hash_original_method = "A938A921621E94044F2CFA3DC31C9E8C", hash_generated_method = "525923E3D038982F3E4470E3EA27464E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFeature(String name) {
        dsTaint.addTaint(name);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.675 -0400", hash_original_method = "6A642C9EEC23AC32ED606658DA110E38", hash_generated_method = "D8E2B207138A1B41DFFEB3ECF9B690A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.676 -0400", hash_original_method = "8F74E2B7FCD796BC320C8C37775EA11E", hash_generated_method = "3980B31D361E8785AE496D4281CE2242")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNamespace() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.676 -0400", hash_original_method = "1ADA26C4B32C10D168CE4DC5A8DC35EC", hash_generated_method = "40EA5332B2997B0A598B9269A3C08A4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPrefix(String namespace, boolean generatePrefix) throws IllegalArgumentException {
        dsTaint.addTaint(generatePrefix);
        dsTaint.addTaint(namespace);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.676 -0400", hash_original_method = "DA8A49250701B8FD4E3C9A3CEF97A891", hash_generated_method = "B2968E79572E8AA5B1E1B9351525DEBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getProperty(String name) {
        dsTaint.addTaint(name);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.676 -0400", hash_original_method = "3EA2D897BB6C3BC43607B7AF9CA20B7F", hash_generated_method = "3E8EC21059D4C74024C9DD13042BE2DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void ignorableWhitespace(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(text);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.677 -0400", hash_original_method = "7E88F58557263ECFFAB9D7472E34A31A", hash_generated_method = "53E84F3556EB2D39D1D18D9327AA20DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void processingInstruction(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(text);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.677 -0400", hash_original_method = "5124EC4444894C7656E2A35FD8B594F3", hash_generated_method = "AC4783DF029B7AA3CFB5029868F5581F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFeature(String name, boolean state) throws IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(state);
        {
            boolean varBFD803D33F5D5A09992C9ED98F06B7DE_937289890 = (name.equals("http://xmlpull.org/v1/doc/features.html#indent-output"));
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //if (name.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            //return;
        //}
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.686 -0400", hash_original_method = "13E00C790126A70B4466C6B565B1D4E5", hash_generated_method = "CCEE8027632D442E1CB2BBFA168BF7E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOutput(OutputStream os, String encoding) throws IOException,
            IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(encoding);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.689 -0400", hash_original_method = "66C59149F26C5606D1058F17E91C2E36", hash_generated_method = "E55B6D3FAADE68E69963624B51F76FBC")
    @DSModeled(DSC.SAFE)
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(writer.dsTaint);
        // ---------- Original Method ----------
        //mWriter = writer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.691 -0400", hash_original_method = "202C0F3DB21954078DC527D4BA1F5AD5", hash_generated_method = "13EEDCA7BA6A28263A1D245144769152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPrefix(String prefix, String namespace) throws IOException,
            IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(namespace);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.692 -0400", hash_original_method = "C7E5AAECD061448068B655F2A9283D67", hash_generated_method = "FF70D06F0F3CE400BCAE67BE2D70C6B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProperty(String name, Object value) throws IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.693 -0400", hash_original_method = "00343745042AD39FAACA3392E54AE598", hash_generated_method = "C1FF462C444B5E6579CB0EBE1C189589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDocument(String encoding, Boolean standalone) throws IOException,
            IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(standalone.dsTaint);
        append("<?xml version='1.0' encoding='utf-8' standalone='"
                + (standalone ? "yes" : "no") + "' ?>\n");
        // ---------- Original Method ----------
        //append("<?xml version='1.0' encoding='utf-8' standalone='"
                //+ (standalone ? "yes" : "no") + "' ?>\n");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.694 -0400", hash_original_method = "68622A1CFABB0F79BB6AD105FC0B8924", hash_generated_method = "4DC286A6C948510BBB3AF25341AB809F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlSerializer startTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(namespace);
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
        return (XmlSerializer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.695 -0400", hash_original_method = "970D088B7C9B3DFA080857980C9C58B4", hash_generated_method = "C50E41E1FEAECE44253C756DFFE5E2CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlSerializer text(char[] buf, int start, int len) throws IOException,
            IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(start);
        dsTaint.addTaint(len);
        dsTaint.addTaint(buf[0]);
        {
            append(">");
            mInTag = false;
        } //End block
        escapeAndAppendString(buf, start, len);
        return (XmlSerializer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(">");
            //mInTag = false;
        //}
        //escapeAndAppendString(buf, start, len);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.696 -0400", hash_original_method = "CC58EC59F0344E947C053701B4F98937", hash_generated_method = "B730826AFCC6F913683841675360DCDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlSerializer text(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        dsTaint.addTaint(text);
        {
            append(">");
            mInTag = false;
        } //End block
        escapeAndAppendString(text);
        return (XmlSerializer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(">");
            //mInTag = false;
        //}
        //escapeAndAppendString(text);
        //return this;
    }

    
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
    private static final int BUFFER_LEN = 8192;
}

