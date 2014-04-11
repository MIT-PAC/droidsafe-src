package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

import org.xmlpull.v1.XmlSerializer;

public class FastXmlSerializer implements XmlSerializer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.896 -0500", hash_original_field = "F5DC598791BF8B4F60F09293CF2C8060", hash_generated_field = "0DD90CFC5DE7761A0055893813D05AEB")

    private static final String ESCAPE_TABLE[] = new String[] {
        null,     null,     null,     null,     null,     null,     null,     null,  // 0-7
        null,     null,     null,     null,     null,     null,     null,     null,  // 8-15
        null,     null,     null,     null,     null,     null,     null,     null,  // 16-23
        null,     null,     null,     null,     null,     null,     null,     null,  // 24-31
        null,     null,     "&quot;", null,     null,     null,     "&amp;",  null,  // 32-39
        null,     null,     null,     null,     null,     null,     null,     null,  // 40-47
        null,     null,     null,     null,     null,     null,     null,     null,  // 48-55
        null,     null,     null,     null,     "&lt;",   null,     "&gt;",   null,  // 56-63
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.899 -0500", hash_original_field = "A553C82762327F5371F732A66649DACF", hash_generated_field = "87B505129A889694149659B3C7493691")

    private static final int BUFFER_LEN = 8192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.901 -0500", hash_original_field = "741D1F4A31B01ABB1488411D7243B1C1", hash_generated_field = "5E7BC4B7A0E4B0267814CE95DA4CE493")

    private final char[] mText = new char[BUFFER_LEN];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.903 -0500", hash_original_field = "25A5DEAC26D49039381CEC3AC02D8D8E", hash_generated_field = "649CC94BF1D5A5FECFE4D2F006B35728")

    private int mPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.905 -0500", hash_original_field = "350034FEA94499CFE745BA9E56E8A320", hash_generated_field = "43DF8FED0AB3E82A21BAF8454C91DA12")

    private Writer mWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.907 -0500", hash_original_field = "73A4A3989B1458C88FDAFF3AF49183EC", hash_generated_field = "55417565DD3006A9600CB708A96EDA0C")

    private OutputStream mOutputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.910 -0500", hash_original_field = "5B8E3F0856E05AF3901853F33B659751", hash_generated_field = "7AD13F175ACC49B2AFF8D253EE3A496C")

    private CharsetEncoder mCharset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.912 -0500", hash_original_field = "4D5D7AD6921B946A154EDDAA4B83B989", hash_generated_field = "48B6C689C33353333CE187E3FF0FA34D")

    private ByteBuffer mBytes = ByteBuffer.allocate(BUFFER_LEN);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.915 -0500", hash_original_field = "1068FB7D0463ECB09F33F060A8F23290", hash_generated_field = "EF3E29BFAF7BB3B897FCD2054D06CB59")

    private boolean mInTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.714 -0400", hash_original_method = "14D217AC288267AE1031A94F745E4E30", hash_generated_method = "14D217AC288267AE1031A94F745E4E30")
    public FastXmlSerializer ()
    {
        //Synthesized constructor
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.918 -0500", hash_original_method = "7F8A4FBBB421106585A40A4ABA627D34", hash_generated_method = "4A3C5650EA1F76EDA495476C30DB9DDF")
    
private void append(char c) throws IOException {
        int pos = mPos;
        if (pos >= (BUFFER_LEN-1)) {
            flush();
            pos = mPos;
        }
        mText[pos] = c;
        mPos = pos+1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.920 -0500", hash_original_method = "FE048AE8183F447BAD2B7EF704E010CC", hash_generated_method = "8AD597E053D29924127BF39F649E5C9F")
    
private void append(String str, int i, final int length) throws IOException {
        if (length > BUFFER_LEN) {
            final int end = i + length;
            while (i < end) {
                int next = i + BUFFER_LEN;
                append(str, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            }
            return;
        }
        int pos = mPos;
        if ((pos+length) > BUFFER_LEN) {
            flush();
            pos = mPos;
        }
        str.getChars(i, i+length, mText, pos);
        mPos = pos + length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.923 -0500", hash_original_method = "A84A951371BFD4434741842D4AA34429", hash_generated_method = "9A85D6D65CA44AE6EACCD4D9B27F169B")
    
private void append(char[] buf, int i, final int length) throws IOException {
        if (length > BUFFER_LEN) {
            final int end = i + length;
            while (i < end) {
                int next = i + BUFFER_LEN;
                append(buf, i, next<end ? BUFFER_LEN : (end-i));
                i = next;
            }
            return;
        }
        int pos = mPos;
        if ((pos+length) > BUFFER_LEN) {
            flush();
            pos = mPos;
        }
        System.arraycopy(buf, i, mText, pos, length);
        mPos = pos + length;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.925 -0500", hash_original_method = "E6E865A25D7068974BFDA6B3F14B9E04", hash_generated_method = "93F6B0896169EEDFA9756C79319E399A")
    
private void append(String str) throws IOException {
        append(str, 0, str.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.929 -0500", hash_original_method = "685D23784A67F08835F67CA0A97F5B9B", hash_generated_method = "A946929EB2CEE43C5DFF01286D12805D")
    
private void escapeAndAppendString(final String string) throws IOException {
        final int N = string.length();
        final char NE = (char)ESCAPE_TABLE.length;
        final String[] escapes = ESCAPE_TABLE;
        int lastPos = 0;
        int pos;
        for (pos=0; pos<N; pos++) {
            char c = string.charAt(pos);
            if (c >= NE) continue;
            String escape = escapes[c];
            if (escape == null) continue;
            if (lastPos < pos) append(string, lastPos, pos-lastPos);
            lastPos = pos + 1;
            append(escape);
        }
        if (lastPos < pos) append(string, lastPos, pos-lastPos);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.932 -0500", hash_original_method = "9EEFDA601F6AD1629A39B78C5EDBBF73", hash_generated_method = "DCBB865E98F35A4B7FDC188361040BCE")
    
private void escapeAndAppendString(char[] buf, int start, int len) throws IOException {
        final char NE = (char)ESCAPE_TABLE.length;
        final String[] escapes = ESCAPE_TABLE;
        int end = start+len;
        int lastPos = start;
        int pos;
        for (pos=start; pos<end; pos++) {
            char c = buf[pos];
            if (c >= NE) continue;
            String escape = escapes[c];
            if (escape == null) continue;
            if (lastPos < pos) append(buf, lastPos, pos-lastPos);
            lastPos = pos + 1;
            append(escape);
        }
        if (lastPos < pos) append(buf, lastPos, pos-lastPos);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.935 -0500", hash_original_method = "7E5AB062E349C3088BFBC8393DC59A5F", hash_generated_method = "2692C2AF001202648CC95B2A1BB29D8D")
    
public XmlSerializer attribute(String namespace, String name, String value) throws IOException,
            IllegalArgumentException, IllegalStateException {
        append(' ');
        if (namespace != null) {
            append(namespace);
            append(':');
        }
        append(name);
        append("=\"");

        escapeAndAppendString(value);
        append('"');
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.937 -0500", hash_original_method = "F172E1D42CC08E9B544FD2567DB97884", hash_generated_method = "1BCD0729A2BBA1F3720187A062EB89EB")
    
public void cdsect(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.939 -0500", hash_original_method = "E109160ABCFAB770C18CF7CC0F2B8829", hash_generated_method = "0AC00248E274B3E8BFE966A7983EED59")
    
public void comment(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.941 -0500", hash_original_method = "11FAE83A37D776002915A948C64CD63F", hash_generated_method = "D32C00656D648EDE3E33B36E97DF924E")
    
public void docdecl(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.944 -0500", hash_original_method = "1B99F1BEFCF86F47AB36CD07598B151B", hash_generated_method = "E490113F6EF397D40A4A38C98B6CA0CA")
    
public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.946 -0500", hash_original_method = "8586CBBE84EF5F3F7F367B466316141A", hash_generated_method = "51E2D992A1522C705FEC7145A00CA2AD")
    
public XmlSerializer endTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        if (mInTag) {
            append(" />\n");
        } else {
            append("</");
            if (namespace != null) {
                append(namespace);
                append(':');
            }
            append(name);
            append(">\n");
        }
        mInTag = false;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.949 -0500", hash_original_method = "E509685A6C63D2EAA11B8F86DFCB8A1B", hash_generated_method = "159177CD1698F4B7FCA0908D38231D48")
    
public void entityRef(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.951 -0500", hash_original_method = "8B5DC0C8EFBE829D5900DCFC0D2617F4", hash_generated_method = "1B3CC163C0972C7FDB52EFBAD5F500CD")
    
private void flushBytes() throws IOException {
        int position;
        if ((position = mBytes.position()) > 0) {
            mBytes.flip();
            mOutputStream.write(mBytes.array(), 0, position);
            mBytes.clear();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.953 -0500", hash_original_method = "D60A1C44513D9E8C5B891F5551C5FBBA", hash_generated_method = "4D16825F79309DDAD78617A0F64E4A56")
    
public void flush() throws IOException {
        //Log.i("PackageManager", "flush mPos=" + mPos);
        if (mPos > 0) {
            if (mOutputStream != null) {
                CharBuffer charBuffer = CharBuffer.wrap(mText, 0, mPos);
                CoderResult result = mCharset.encode(charBuffer, mBytes, true);
                while (true) {
                    if (result.isError()) {
                        throw new IOException(result.toString());
                    } else if (result.isOverflow()) {
                        flushBytes();
                        result = mCharset.encode(charBuffer, mBytes, true);
                        continue;
                    }
                    break;
                }
                flushBytes();
                mOutputStream.flush();
            } else {
                mWriter.write(mText, 0, mPos);
                mWriter.flush();
            }
            mPos = 0;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.956 -0500", hash_original_method = "06A4B22AA2E8AAA8ED4F22B001D0D1FC", hash_generated_method = "AD1977A95A92321CD3381376A1D9747F")
    
public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.958 -0500", hash_original_method = "A938A921621E94044F2CFA3DC31C9E8C", hash_generated_method = "F4730AF77592338665CC759C16070DC7")
    
public boolean getFeature(String name) {
        throw new UnsupportedOperationException();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.960 -0500", hash_original_method = "6A642C9EEC23AC32ED606658DA110E38", hash_generated_method = "8E60C110A76AD76E4BB807BBEC76B8C2")
    
public String getName() {
        throw new UnsupportedOperationException();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.963 -0500", hash_original_method = "8F74E2B7FCD796BC320C8C37775EA11E", hash_generated_method = "CAC7F68CA509D5D9B9EC7821A14D85B3")
    
public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.965 -0500", hash_original_method = "1ADA26C4B32C10D168CE4DC5A8DC35EC", hash_generated_method = "7029907997E81993C4095770C0BDD6ED")
    
public String getPrefix(String namespace, boolean generatePrefix)
            throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.968 -0500", hash_original_method = "DA8A49250701B8FD4E3C9A3CEF97A891", hash_generated_method = "91167A8B9249FDB989D95C065C15ECAD")
    
public Object getProperty(String name) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.970 -0500", hash_original_method = "3EA2D897BB6C3BC43607B7AF9CA20B7F", hash_generated_method = "7C990D018D6CB89C1590A6016A21E876")
    
public void ignorableWhitespace(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.972 -0500", hash_original_method = "7E88F58557263ECFFAB9D7472E34A31A", hash_generated_method = "5B78EFA792306CE07568FD9B787BDFF3")
    
public void processingInstruction(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.725 -0400", hash_original_method = "5124EC4444894C7656E2A35FD8B594F3", hash_generated_method = "80085EF16FCED32BD4AE180445602D71")
    public void setFeature(String name, boolean state) throws IllegalArgumentException,
            IllegalStateException {
        addTaint(state);
        addTaint(name.getTaint());
        if(name.equals("http://xmlpull.org/v1/doc/features.html#indent-output"))        
        {
            return;
        } //End block
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1513226464 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1513226464.addTaint(getTaint());
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1513226464;
        // ---------- Original Method ----------
        //if (name.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            //return;
        //}
        //throw new UnsupportedOperationException();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.982 -0500", hash_original_method = "13E00C790126A70B4466C6B565B1D4E5", hash_generated_method = "106EF766B12A18B9F13C17D752E71FE4")
    
public void setOutput(OutputStream os, String encoding) throws IOException,
            IllegalArgumentException, IllegalStateException {
        if (os == null)
            throw new IllegalArgumentException();
        if (true) {
            try {
                mCharset = Charset.forName(encoding).newEncoder();
            } catch (IllegalCharsetNameException e) {
                throw (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        encoding).initCause(e));
            } catch (UnsupportedCharsetException e) {
                throw (UnsupportedEncodingException) (new UnsupportedEncodingException(
                        encoding).initCause(e));
            }
            mOutputStream = os;
        } else {
            setOutput(
                encoding == null
                    ? new OutputStreamWriter(os)
                    : new OutputStreamWriter(os, encoding));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.984 -0500", hash_original_method = "66C59149F26C5606D1058F17E91C2E36", hash_generated_method = "DA2D40C157C1CE916EE811964C7BFFC0")
    
public void setOutput(Writer writer) throws IOException, IllegalArgumentException,
            IllegalStateException {
        mWriter = writer;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.986 -0500", hash_original_method = "202C0F3DB21954078DC527D4BA1F5AD5", hash_generated_method = "419950AA9551BB80A1FCF919A85C0843")
    
public void setPrefix(String prefix, String namespace) throws IOException,
            IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.989 -0500", hash_original_method = "C7E5AAECD061448068B655F2A9283D67", hash_generated_method = "83A4EF7FAF51B168AADCC3C30A955C03")
    
public void setProperty(String name, Object value) throws IllegalArgumentException,
            IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.991 -0500", hash_original_method = "00343745042AD39FAACA3392E54AE598", hash_generated_method = "1AA6FFDC7A661031EB8DA7F49D2CB706")
    
public void startDocument(String encoding, Boolean standalone) throws IOException,
            IllegalArgumentException, IllegalStateException {
        append("<?xml version='1.0' encoding='utf-8' standalone='"
                + (standalone ? "yes" : "no") + "' ?>\n");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.993 -0500", hash_original_method = "68622A1CFABB0F79BB6AD105FC0B8924", hash_generated_method = "E490155492998F2625274D719FAE7741")
    
public XmlSerializer startTag(String namespace, String name) throws IOException,
            IllegalArgumentException, IllegalStateException {
        if (mInTag) {
            append(">\n");
        }
        append('<');
        if (namespace != null) {
            append(namespace);
            append(':');
        }
        append(name);
        mInTag = true;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.996 -0500", hash_original_method = "970D088B7C9B3DFA080857980C9C58B4", hash_generated_method = "E2A47AF4DDEA6945D00235599C2C1D1D")
    
public XmlSerializer text(char[] buf, int start, int len) throws IOException,
            IllegalArgumentException, IllegalStateException {
        if (mInTag) {
            append(">");
            mInTag = false;
        }
        escapeAndAppendString(buf, start, len);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.999 -0500", hash_original_method = "CC58EC59F0344E947C053701B4F98937", hash_generated_method = "15E26605C290E567C4E548909E74FCBC")
    
public XmlSerializer text(String text) throws IOException, IllegalArgumentException,
            IllegalStateException {
        if (mInTag) {
            append(">");
            mInTag = false;
        }
        escapeAndAppendString(text);
        return this;
    }
}

