package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_field = "647ED90A988F1C0B81C4839B3C8E833A", hash_generated_field = "5E7BC4B7A0E4B0267814CE95DA4CE493")

    private final char[] mText = new char[BUFFER_LEN];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_field = "A8470CE6E0050B0E832FDE52720C7250", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_field = "497C65F1D23B4FA8053AFA36BCF69100", hash_generated_field = "43DF8FED0AB3E82A21BAF8454C91DA12")

    private Writer mWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_field = "7D82C7E576FE00FBAD310016B0E82A46", hash_generated_field = "55417565DD3006A9600CB708A96EDA0C")

    private OutputStream mOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_field = "72CD8B47CBDE50A23C6025D18B698226", hash_generated_field = "7AD13F175ACC49B2AFF8D253EE3A496C")

    private CharsetEncoder mCharset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_field = "D967587C6622EC0564253D27D889A05D", hash_generated_field = "48B6C689C33353333CE187E3FF0FA34D")

    private ByteBuffer mBytes = ByteBuffer.allocate(BUFFER_LEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_field = "782DC1AB40D36CE6D2E382035836D20D", hash_generated_field = "EF3E29BFAF7BB3B897FCD2054D06CB59")

    private boolean mInTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.692 -0400", hash_original_method = "14D217AC288267AE1031A94F745E4E30", hash_generated_method = "14D217AC288267AE1031A94F745E4E30")
    public FastXmlSerializer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.693 -0400", hash_original_method = "7F8A4FBBB421106585A40A4ABA627D34", hash_generated_method = "42E01B6AFF000A2F3503C799476FCDD5")
    private void append(char c) throws IOException {
        int pos = mPos;
    if(pos >= (BUFFER_LEN-1))        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.694 -0400", hash_original_method = "FE048AE8183F447BAD2B7EF704E010CC", hash_generated_method = "4AEE68BC14561202C92F242E36D49377")
    private void append(String str, int i, final int length) throws IOException {
        addTaint(i);
        addTaint(str.getTaint());
    if(length > BUFFER_LEN)        
        {
            final int end = i + length;
            while
(i < end)            
            {
                int next = i + BUFFER_LEN;
                append(str, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            } //End block
            return;
        } //End block
        int pos = mPos;
    if((pos+length) > BUFFER_LEN)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.696 -0400", hash_original_method = "A84A951371BFD4434741842D4AA34429", hash_generated_method = "B52B7588BCF49FB67E997EA9E3687164")
    private void append(char[] buf, int i, final int length) throws IOException {
        addTaint(i);
        addTaint(buf[0]);
    if(length > BUFFER_LEN)        
        {
            final int end = i + length;
            while
(i < end)            
            {
                int next = i + BUFFER_LEN;
                append(buf, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            } //End block
            return;
        } //End block
        int pos = mPos;
    if((pos+length) > BUFFER_LEN)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.698 -0400", hash_original_method = "E6E865A25D7068974BFDA6B3F14B9E04", hash_generated_method = "581E6423C228B35538735EFEA5DCFE16")
    private void append(String str) throws IOException {
        addTaint(str.getTaint());
        append(str, 0, str.length());
        // ---------- Original Method ----------
        //append(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.701 -0400", hash_original_method = "685D23784A67F08835F67CA0A97F5B9B", hash_generated_method = "41AF799BA3D260F846310A7A4E01A1DA")
    private void escapeAndAppendString(final String string) throws IOException {
        addTaint(string.getTaint());
        final int N = string.length();
        final char NE = (char)ESCAPE_TABLE.length;
        final String[] escapes = ESCAPE_TABLE;
        int lastPos = 0;
        int pos;
for(pos=0;pos<N;pos++)
        {
            char c = string.charAt(pos);
    if(c >= NE)            
            continue;
            String escape = escapes[c];
    if(escape == null)            
            continue;
    if(lastPos < pos)            
            append(string, lastPos, pos-lastPos);
            lastPos = pos + 1;
            append(escape);
        } //End block
    if(lastPos < pos)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.702 -0400", hash_original_method = "9EEFDA601F6AD1629A39B78C5EDBBF73", hash_generated_method = "1C8287A0EB398EEA00D1810F2B27DCDF")
    private void escapeAndAppendString(char[] buf, int start, int len) throws IOException {
        addTaint(len);
        addTaint(start);
        addTaint(buf[0]);
        final char NE = (char)ESCAPE_TABLE.length;
        final String[] escapes = ESCAPE_TABLE;
        int end = start+len;
        int lastPos = start;
        int pos;
for(pos=start;pos<end;pos++)
        {
            char c = buf[pos];
    if(c >= NE)            
            continue;
            String escape = escapes[c];
    if(escape == null)            
            continue;
    if(lastPos < pos)            
            append(buf, lastPos, pos-lastPos);
            lastPos = pos + 1;
            append(escape);
        } //End block
    if(lastPos < pos)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.703 -0400", hash_original_method = "7E5AB062E349C3088BFBC8393DC59A5F", hash_generated_method = "99E2DFFDDD8F1DAB3BB65D39C59231A0")
    public XmlSerializer attribute(String namespace, String name, String value) throws IOException,
            IllegalArgumentException, IllegalStateException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        addTaint(namespace.getTaint());
        append(' ');
    if(namespace != null)        
        {
            append(namespace);
            append(':');
        } //End block
        append(name);
        append("=\"");
        escapeAndAppendString(value);
        append('"');
XmlSerializer var72A74007B2BE62B849F475C7BDA4658B_1159230304 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1159230304.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1159230304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.703 -0400", hash_original_method = "F172E1D42CC08E9B544FD2567DB97884", hash_generated_method = "1E06DE1851029B930F710D5A9AD15CD8")
    public void cdsect(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        addTaint(text.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1991076578 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1991076578.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1991076578;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.703 -0400", hash_original_method = "E109160ABCFAB770C18CF7CC0F2B8829", hash_generated_method = "BDC69CCB873F3549165771CEA03B7732")
    public void comment(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        addTaint(text.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1568548819 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1568548819.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1568548819;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.704 -0400", hash_original_method = "11FAE83A37D776002915A948C64CD63F", hash_generated_method = "C9862A9536D5442127CAE6E14A56372D")
    public void docdecl(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        addTaint(text.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1414198134 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1414198134.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1414198134;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.704 -0400", hash_original_method = "1B99F1BEFCF86F47AB36CD07598B151B", hash_generated_method = "BF20983D9077DC4EE2ECB5B538CCC3C3")
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
        // ---------- Original Method ----------
        //flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.705 -0400", hash_original_method = "8586CBBE84EF5F3F7F367B466316141A", hash_generated_method = "325DD8E0516D7B99F5D438933767658E")
    public XmlSerializer endTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        addTaint(name.getTaint());
        addTaint(namespace.getTaint());
    if(mInTag)        
        {
            append(" />\n");
        } //End block
        else
        {
            append("</");
    if(namespace != null)            
            {
                append(namespace);
                append(':');
            } //End block
            append(name);
            append(">\n");
        } //End block
        mInTag = false;
XmlSerializer var72A74007B2BE62B849F475C7BDA4658B_1125315279 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1125315279.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1125315279;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.705 -0400", hash_original_method = "E509685A6C63D2EAA11B8F86DFCB8A1B", hash_generated_method = "2BB9E251E0175C17216FFB89ADF3657D")
    public void entityRef(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        addTaint(text.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1804039279 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1804039279.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1804039279;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.706 -0400", hash_original_method = "8B5DC0C8EFBE829D5900DCFC0D2617F4", hash_generated_method = "E7CB072C3A0DB8B774049FA78497C8F6")
    private void flushBytes() throws IOException {
        int position;
    if((position = mBytes.position()) > 0)        
        {
            mBytes.flip();
            mOutputStream.write(mBytes.array(), 0, position);
            mBytes.clear();
        } //End block
        // ---------- Original Method ----------
        //int position;
        //if ((position = mBytes.position()) > 0) {
            //mBytes.flip();
            //mOutputStream.write(mBytes.array(), 0, position);
            //mBytes.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.706 -0400", hash_original_method = "D60A1C44513D9E8C5B891F5551C5FBBA", hash_generated_method = "23F5E3627B5CCAD5F219517E54CE27E4")
    public void flush() throws IOException {
    if(mPos > 0)        
        {
    if(mOutputStream != null)            
            {
                CharBuffer charBuffer = CharBuffer.wrap(mText, 0, mPos);
                CoderResult result = mCharset.encode(charBuffer, mBytes, true);
                while
(true)                
                {
    if(result.isError())                    
                    {
                        IOException varDAA51430864010737E8EC2F8A3A5A24C_510188149 = new IOException(result.toString());
                        varDAA51430864010737E8EC2F8A3A5A24C_510188149.addTaint(taint);
                        throw varDAA51430864010737E8EC2F8A3A5A24C_510188149;
                    } //End block
                    else
    if(result.isOverflow())                    
                    {
                        flushBytes();
                        result = mCharset.encode(charBuffer, mBytes, true);
                        continue;
                    } //End block
                    break;
                } //End block
                flushBytes();
                mOutputStream.flush();
            } //End block
            else
            {
                mWriter.write(mText, 0, mPos);
                mWriter.flush();
            } //End block
            mPos = 0;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.707 -0400", hash_original_method = "06A4B22AA2E8AAA8ED4F22B001D0D1FC", hash_generated_method = "9F51ABBAFB79DDEBA3A6A61427D805E5")
    public int getDepth() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_163599635 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_163599635.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_163599635;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.707 -0400", hash_original_method = "A938A921621E94044F2CFA3DC31C9E8C", hash_generated_method = "ACC35A9C3A08B6D12A13A0C86D2275DE")
    public boolean getFeature(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1919735735 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1919735735.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1919735735;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.708 -0400", hash_original_method = "6A642C9EEC23AC32ED606658DA110E38", hash_generated_method = "F119E24C733A3076D0BE6D9BFE63AC9C")
    public String getName() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_406289805 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_406289805.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_406289805;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.708 -0400", hash_original_method = "8F74E2B7FCD796BC320C8C37775EA11E", hash_generated_method = "9BF9729D3BB5823223A1092A323E1FF2")
    public String getNamespace() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_36122781 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_36122781.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_36122781;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.708 -0400", hash_original_method = "1ADA26C4B32C10D168CE4DC5A8DC35EC", hash_generated_method = "B0070D9598602DD20BDFE1DFBB2DD91E")
    public String getPrefix(String namespace, boolean generatePrefix) throws IllegalArgumentException {
        addTaint(generatePrefix);
        addTaint(namespace.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_745375975 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_745375975.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_745375975;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.708 -0400", hash_original_method = "DA8A49250701B8FD4E3C9A3CEF97A891", hash_generated_method = "DF2927E18DB7AE6EBCBE190BB5253697")
    public Object getProperty(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1459461242 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1459461242.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1459461242;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.709 -0400", hash_original_method = "3EA2D897BB6C3BC43607B7AF9CA20B7F", hash_generated_method = "5675CC4FB77D3EA221237097F1795F4E")
    public void ignorableWhitespace(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        addTaint(text.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_492367252 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_492367252.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_492367252;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.709 -0400", hash_original_method = "7E88F58557263ECFFAB9D7472E34A31A", hash_generated_method = "153485E24F16BA97A1C30663F90008D7")
    public void processingInstruction(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        addTaint(text.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1299745156 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1299745156.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1299745156;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.709 -0400", hash_original_method = "5124EC4444894C7656E2A35FD8B594F3", hash_generated_method = "F057594F131058D5E6101A0B8974CDE9")
    public void setFeature(String name, boolean state) throws IllegalArgumentException,
            IllegalStateException {
        addTaint(state);
        addTaint(name.getTaint());
    if(name.equals("http://xmlpull.org/v1/doc/features.html#indent-output"))        
        {
            return;
        } //End block
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_362460158 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_362460158.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_362460158;
        // ---------- Original Method ----------
        //if (name.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            //return;
        //}
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.710 -0400", hash_original_method = "13E00C790126A70B4466C6B565B1D4E5", hash_generated_method = "DF3834BC76D2E95165A5E885F9732835")
    public void setOutput(OutputStream os, String encoding) throws IOException,
            IllegalArgumentException, IllegalStateException {
    if(os == null)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_581941411 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_581941411.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_581941411;
        }
    if(true)        
        {
            try 
            {
                mCharset = Charset.forName(encoding).newEncoder();
            } //End block
            catch (IllegalCharsetNameException e)
            {
                UnsupportedEncodingException var2BA2B3056B09BF95A7A1AAD1688C8331_80895125 = (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        encoding).initCause(e));
                var2BA2B3056B09BF95A7A1AAD1688C8331_80895125.addTaint(taint);
                throw var2BA2B3056B09BF95A7A1AAD1688C8331_80895125;
            } //End block
            catch (UnsupportedCharsetException e)
            {
                UnsupportedEncodingException var2BA2B3056B09BF95A7A1AAD1688C8331_432475321 = (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        encoding).initCause(e));
                var2BA2B3056B09BF95A7A1AAD1688C8331_432475321.addTaint(taint);
                throw var2BA2B3056B09BF95A7A1AAD1688C8331_432475321;
            } //End block
            mOutputStream = os;
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.710 -0400", hash_original_method = "66C59149F26C5606D1058F17E91C2E36", hash_generated_method = "19FF5C74DB405E85A6CA055D58E4DA60")
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException,
            IllegalStateException {
        mWriter = writer;
        // ---------- Original Method ----------
        //mWriter = writer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.711 -0400", hash_original_method = "202C0F3DB21954078DC527D4BA1F5AD5", hash_generated_method = "2680CF54E9E1BB558DAEF21813C29708")
    public void setPrefix(String prefix, String namespace) throws IOException,
            IllegalArgumentException, IllegalStateException {
        addTaint(namespace.getTaint());
        addTaint(prefix.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_758439695 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_758439695.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_758439695;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.711 -0400", hash_original_method = "C7E5AAECD061448068B655F2A9283D67", hash_generated_method = "E795A65D283E01C396A5705843A20DAD")
    public void setProperty(String name, Object value) throws IllegalArgumentException,
            IllegalStateException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1726075065 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1726075065.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1726075065;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.711 -0400", hash_original_method = "00343745042AD39FAACA3392E54AE598", hash_generated_method = "E79D7D5321446D6124180C4D601329BD")
    public void startDocument(String encoding, Boolean standalone) throws IOException,
            IllegalArgumentException, IllegalStateException {
        addTaint(standalone.getTaint());
        addTaint(encoding.getTaint());
        append("<?xml version='1.0' encoding='utf-8' standalone='"
                + (standalone ? "yes" : "no") + "' ?>\n");
        // ---------- Original Method ----------
        //append("<?xml version='1.0' encoding='utf-8' standalone='"
                //+ (standalone ? "yes" : "no") + "' ?>\n");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.711 -0400", hash_original_method = "68622A1CFABB0F79BB6AD105FC0B8924", hash_generated_method = "D643764479F2D8FF2D2C66F685025F6F")
    public XmlSerializer startTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        addTaint(name.getTaint());
        addTaint(namespace.getTaint());
    if(mInTag)        
        {
            append(">\n");
        } //End block
        append('<');
    if(namespace != null)        
        {
            append(namespace);
            append(':');
        } //End block
        append(name);
        mInTag = true;
XmlSerializer var72A74007B2BE62B849F475C7BDA4658B_506236498 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_506236498.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_506236498;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.712 -0400", hash_original_method = "970D088B7C9B3DFA080857980C9C58B4", hash_generated_method = "9EAA9CA62AF0F87149F09D690156E16D")
    public XmlSerializer text(char[] buf, int start, int len) throws IOException,
            IllegalArgumentException, IllegalStateException {
        addTaint(len);
        addTaint(start);
        addTaint(buf[0]);
    if(mInTag)        
        {
            append(">");
            mInTag = false;
        } //End block
        escapeAndAppendString(buf, start, len);
XmlSerializer var72A74007B2BE62B849F475C7BDA4658B_1944993046 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1944993046.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1944993046;
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(">");
            //mInTag = false;
        //}
        //escapeAndAppendString(buf, start, len);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.712 -0400", hash_original_method = "CC58EC59F0344E947C053701B4F98937", hash_generated_method = "19DB103D3258C0002EB8893B379AF7DE")
    public XmlSerializer text(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        addTaint(text.getTaint());
    if(mInTag)        
        {
            append(">");
            mInTag = false;
        } //End block
        escapeAndAppendString(text);
XmlSerializer var72A74007B2BE62B849F475C7BDA4658B_496039208 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_496039208.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_496039208;
        // ---------- Original Method ----------
        //if (mInTag) {
            //append(">");
            //mInTag = false;
        //}
        //escapeAndAppendString(text);
        //return this;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.712 -0400", hash_original_field = "03620A30EC5528C866EBA1EE2D6FF7F8", hash_generated_field = "CCB993A2E3DB7640A0C69D08BAC36477")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.713 -0400", hash_original_field = "019A412F8F4585379F03F103828346EC", hash_generated_field = "87B505129A889694149659B3C7493691")

    private static final int BUFFER_LEN = 8192;
}

