package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.net.ssl.SSLHandshakeException;

public class HandshakeIODataStream extends SSLInputStream implements org.apache.harmony.xnet.provider.jsse.Appendable, DataStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.371 -0500", hash_original_field = "7CC4ADADCF5B81E1EEBC5F8C930336A6", hash_generated_field = "BD1BCB7BF1C44FE529E5F55EB4873757")

    // during the handshake phase
    private static  MessageDigest md5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.373 -0500", hash_original_field = "592D6316376DEACF69E66590DC353E6F", hash_generated_field = "A133435596333D642AF59DA1AC707533")

    private static  MessageDigest sha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.379 -0500", hash_original_field = "4F58C640167DDFD403178B202B0FDAD5", hash_generated_field = "6ABB97B7E5704DAE089E4AEB36CEB9EE")

    private int buff_size = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.382 -0500", hash_original_field = "CD0753681B0045F9E53D503E39CAE04C", hash_generated_field = "ECE066EAF80B851FA09366F66474CB4F")

    private int inc_buff_size = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.384 -0500", hash_original_field = "B46F5E13523DFB1146F1455B814A6A14", hash_generated_field = "59FE230D060C5F66646B4FE7F4893504")

    private byte[] buffer = new byte[buff_size];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.386 -0500", hash_original_field = "B44B513F7513D01C85BAD454F81E6997", hash_generated_field = "3723889C9DF91DF516DBD9F68532380B")

    // position of the next byte to read
    private int read_pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.388 -0500", hash_original_field = "1721C61D21E2B39C66264FC8044ED7BD", hash_generated_field = "27AC92782C57CF0B819B2420AE5376F7")

    private int marked_pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.390 -0500", hash_original_field = "D9A8656BD75C0DD1FB1870FB2AF4B044", hash_generated_field = "FF0EA6FB8503DBFADF3AE0199C37EA3B")

    private int read_pos_end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.424 -0500", hash_original_field = "7C9CC79F0E03280A2531A49A058EF4F4", hash_generated_field = "FD92541B7DDFA167E4A40EB132AF1B49")

    // position in the buffer available for write
    private int write_pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.426 -0500", hash_original_field = "D4720586F93FABA1AC37259DD34F504A", hash_generated_field = "AD1DFD6760C62CD5DA5F016A95D625DE")

    private int write_pos_beg;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.377 -0500", hash_original_method = "C3B776612EB17DF4F4BD48A7062A61E9", hash_generated_method = "A85DFED1B2178607730CA20A4B83210B")
    
public HandshakeIODataStream() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.393 -0500", hash_original_method = "BF4923D33B65FF9EACCA5F4B8319A955", hash_generated_method = "B343CC093869961D5F2EEA9FC78C3A5F")
    
@Override
    public int available() {
        return read_pos_end - read_pos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.395 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
    
@Override
    public boolean markSupported() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.397 -0500", hash_original_method = "AA335ECE90F2C0243759B4C2341DEAEB", hash_generated_method = "D50D2E497F16B89E92554C77B69BBD94")
    
@Override
    public void mark(int limit) {
        marked_pos = read_pos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.399 -0500", hash_original_method = "B5D6E2F2B60CF54FA8B6A301921FACA9", hash_generated_method = "D5F72E0C2D6C9DA0206DE3356BD370FC")
    
public void mark() {
        marked_pos = read_pos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.402 -0500", hash_original_method = "A27E7E8C3D531E39801BBCF5B4CC5B78", hash_generated_method = "F3F1DA2C198F045C183C24D5908BA5F8")
    
@Override
    public void reset() {
        read_pos = marked_pos;
    }

    /**
     * Removes the data from the marked position to
     * the current read position. The method is usefull when it is needed
     * to delete one message from the internal buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.405 -0500", hash_original_method = "86BACF12AABDF1D79A57ADD37C52BB94", hash_generated_method = "7D783B9D180F8C52920A38D45A9105E9")
    
protected void removeFromMarkedPosition() {
        System.arraycopy(buffer, read_pos,
                buffer, marked_pos, read_pos_end - read_pos);
        read_pos_end -= (read_pos - marked_pos);
        read_pos = marked_pos;
    }

    /**
     * read an opaque value;
     * @param   byte:   byte
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.407 -0500", hash_original_method = "0824C344C7EF76E18DAFC5A0824644C2", hash_generated_method = "CCA7BFC992325F2BC11A6217EE625B3B")
    
@Override
    public int read() throws IOException {
        if (read_pos == read_pos_end) {
            //return -1;
            throw new EndOfBufferException();
        }
        return buffer[read_pos++] & 0xFF;
    }

    /**
     * reads vector of opaque values
     * @param   new:    long
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.410 -0500", hash_original_method = "91CEDBDE7A81F4DCE85242430A46DCF1", hash_generated_method = "E43FE0F770A94438D408F0C9100BE8BD")
    
@Override
    public byte[] read(int length) throws IOException {
        if (length > available()) {
            throw new EndOfBufferException();
        }
        byte[] res = new byte[length];
        System.arraycopy(buffer, read_pos, res, 0, length);
        read_pos = read_pos + length;
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.412 -0500", hash_original_method = "2AC89109B1F5C21FC0020B1393568717", hash_generated_method = "D1A2B2FB771DA6CAF9365495AFF59508")
    
@Override
    public int read(byte[] dst, int offset, int length) throws IOException {
        if (length > available()) {
            throw new EndOfBufferException();
        }
        System.arraycopy(buffer, read_pos, dst, offset, length);
        read_pos = read_pos + length;
        return length;
    }

    // ------------------- Extending of the input data ---------------------

    /**
     * Appends the income data to be read by handshake protocol.
     * The attempts to overflow the buffer by means of this methods
     * seem to be futile because of:
     * 1. The SSL protocol specifies the maximum size of the record
     * and record protocol does not pass huge messages.
     * (see TLS v1 specification http://www.ietf.org/rfc/rfc2246.txt ,
     * p 6.2)
     * 2. After each call of this method, handshake protocol should
     * start (and starts) the operations on received data and recognize
     * the fake data if such was provided (to check the size of certificate
     * for example).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.414 -0500", hash_original_method = "AF6CB8DBEC021FC7528B8ED3F8431D0F", hash_generated_method = "3F30D4B06EC9993AD7D54869C3336761")
    
public void append(byte[] src) {
        append(src, 0, src.length);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.417 -0500", hash_original_method = "2AF2E557DF862B37CD8412561C90BA0E", hash_generated_method = "8E7F1A864996AA09FAAF41C2CC960BC0")
    
private void append(byte[] src, int from, int length) {
        if (read_pos == read_pos_end) {
            // start reading state after writing
            if (write_pos_beg != write_pos) {
                // error: outboud handshake data was not sent,
                // but inbound handshake data has been received.
                throw new AlertException(
                    AlertProtocol.UNEXPECTED_MESSAGE,
                    new SSLHandshakeException(
                        "Handshake message has been received before "
                        + "the last oubound message had been sent."));
            }
            if (read_pos < write_pos) {
                read_pos = write_pos;
                read_pos_end = read_pos;
            }
        }
        if (read_pos_end + length > buff_size) {
            enlargeBuffer(read_pos_end+length-buff_size);
        }
        System.arraycopy(src, from, buffer, read_pos_end, length);
        read_pos_end += length;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.419 -0500", hash_original_method = "7D810597598BCFC529CACE9B428759B7", hash_generated_method = "ED52B2AAA3E59CD36732124900BBF7CE")
    
private void enlargeBuffer(int size) {
        buff_size = (size < inc_buff_size)
            ? buff_size + inc_buff_size
            : buff_size + size;
        byte[] new_buff = new byte[buff_size];
        System.arraycopy(buffer, 0, new_buff, 0, buffer.length);
        buffer = new_buff;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.421 -0500", hash_original_method = "B556221995277C3C7246E0F0C5588CBB", hash_generated_method = "9F385F12683FD8FB0777D0C2D4BB21B7")
    
protected void clearBuffer() {
        read_pos = 0;
        marked_pos = 0;
        read_pos_end = 0;
        write_pos = 0;
        write_pos_beg = 0;
        Arrays.fill(buffer, (byte) 0);
    }

    // checks if the data can be written in the buffer
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.428 -0500", hash_original_method = "5D32524C92EB4CDA6DDBF787AA4026BF", hash_generated_method = "7D68D2D148332D739A350A55C2B9B609")
    
private void check(int length) {
        // (write_pos == write_pos_beg) iff:
        // 1. there were not write operations yet
        // 2. all written data was demanded by getData methods
        if (write_pos == write_pos_beg) {
            // just started to write after the reading
            if (read_pos != read_pos_end) {
                // error: attempt to write outbound data into the stream before
                // all the inbound handshake data had been read
                throw new AlertException(
                        AlertProtocol.INTERNAL_ERROR,
                        new SSLHandshakeException("Data was not fully read: "
                        + read_pos + " " + read_pos_end));
            }
            // set up the write positions
            if (write_pos_beg < read_pos_end) {
                write_pos_beg = read_pos_end;
                write_pos = write_pos_beg;
            }
        }
        // if there is not enought free space in the buffer - enlarge it:
        if (write_pos + length >= buff_size) {
            enlargeBuffer(length);
        }
    }

    /**
     * Writes an opaque value
     * @param   byte:   byte
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.431 -0500", hash_original_method = "585ADF2190C2ED18E311DC7717079D3E", hash_generated_method = "89143747988B5330C7BED4FDB86F4326")
    
public void write(byte b) {
        check(1);
        buffer[write_pos++] = b;
    }

    /**
     * Writes Uint8 value
     * @param long: the value to be written (last byte)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.434 -0500", hash_original_method = "D10825FCC1F6D574D203B7119B0DE21D", hash_generated_method = "D32709D4990037470D7B2A06E09FBEA3")
    
public void writeUint8(long n) {
        check(1);
        buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    /**
     * Writes Uint16 value
     * @param long: the value to be written (last 2 bytes)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.436 -0500", hash_original_method = "BC95F3A9D20B746C785DDB55CCD0B371", hash_generated_method = "85C2B2ECFC4DCB63D3CA2AF4A0B3A150")
    
public void writeUint16(long n) {
        check(2);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    /**
     * Writes Uint24 value
     * @param long: the value to be written (last 3 bytes)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.438 -0500", hash_original_method = "5F803054AD541DA3DFDDE2CF3FE59841", hash_generated_method = "C205F7B0BD653321927F39C3C6CDDBD5")
    
public void writeUint24(long n) {
        check(3);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    /**
     * Writes Uint32 value
     * @param long: the value to be written (last 4 bytes)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.440 -0500", hash_original_method = "F5CBF84A3DE853E04B44967F882D7399", hash_generated_method = "CA29B005DF8237EBD1379937A892AB35")
    
public void writeUint32(long n) {
        check(4);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    /**
     * Writes Uint64 value
     * @param long: the value to be written
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.443 -0500", hash_original_method = "9B394B4CCC83FB2B8DCA345D732654D8", hash_generated_method = "817653ACEE23234CBFBBD53F68C3A2D9")
    
public void writeUint64(long n) {
        check(8);
        buffer[write_pos++] = (byte) ((n & 0x00ff00000000000000L) >> 56);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000000000L) >> 48);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000000000L) >> 40);
        buffer[write_pos++] = (byte) ((n & 0x00ff00000000L) >> 32);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    /**
     * writes vector of opaque values
     * @param  vector the vector to be written
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.445 -0500", hash_original_method = "E2E038DF81C8876BEF1DC650925A08F9", hash_generated_method = "64087033E04A614553C34B8F59B74AC2")
    
public void write(byte[] vector) {
        check(vector.length);
        System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        write_pos += vector.length;
    }

    // ------------------- Retrieve the written bytes ----------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.448 -0500", hash_original_method = "8D64F0C3C5F38A8BA7A92E3DA10323F4", hash_generated_method = "293E25F7ABFDC5F090E97F8A13F800D1")
    
public boolean hasData() {
        return (write_pos > write_pos_beg);
    }

    /**
     * returns the chunk of stored data with the length no more than specified.
     * @param   length: int
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.450 -0500", hash_original_method = "E6D2A8CE9FA7080A42A1984AB4D903A3", hash_generated_method = "E8A72FF6E6ED35CC96D217AC0467E4A0")
    
public byte[] getData(int length) {
        byte[] res;
        if (write_pos - write_pos_beg < length) {
            res = new byte[write_pos - write_pos_beg];
            System.arraycopy(buffer, write_pos_beg,
                    res, 0, write_pos-write_pos_beg);
            write_pos_beg = write_pos;
        } else {
            res = new byte[length];
            System.arraycopy(buffer, write_pos_beg, res, 0, length);
            write_pos_beg += length;
        }
        return res;
    }

    // ---------------------- Message Digest Functionality ----------------

    /**
     * Returns the MD5 digest of the data passed throught the stream
     * @return MD5 digest
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.452 -0500", hash_original_method = "9B1F555F297B463533438E17CA1DA8BA", hash_generated_method = "11655AC8DF3624148C8D3CE61B7397D3")
    
protected byte[] getDigestMD5() {
        synchronized (md5) {
            int len = (read_pos_end > write_pos)
                ? read_pos_end
                : write_pos;
            md5.update(buffer, 0, len);
            return md5.digest();
        }
    }

    /**
     * Returns the SHA-1 digest of the data passed throught the stream
     * @return SHA-1 digest
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.455 -0500", hash_original_method = "74B8780B4340381F62E79DEE30B1C1C3", hash_generated_method = "4B33D838D16F92375073E508CB3E8540")
    
protected byte[] getDigestSHA() {
        synchronized (sha) {
            int len = (read_pos_end > write_pos)
                ? read_pos_end
                : write_pos;
            sha.update(buffer, 0, len);
            return sha.digest();
        }
    }

    /**
     * Returns the MD5 digest of the data passed throught the stream
     * except last message
     * @return MD5 digest
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.457 -0500", hash_original_method = "DDBF067C5B2E3F42A7068CF9EE336859", hash_generated_method = "4934288DA3A7A5B17526178A66DD209F")
    
protected byte[] getDigestMD5withoutLast() {
        synchronized (md5) {
            md5.update(buffer, 0, marked_pos);
            return md5.digest();
        }
    }

    /**
     * Returns the SHA-1 digest of the data passed throught the stream
     * except last message
     * @return SHA-1 digest
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.459 -0500", hash_original_method = "BE851090505272B625E52E095FDF236D", hash_generated_method = "926537779BC4D855D1E43BE7E48CB244")
    
protected byte[] getDigestSHAwithoutLast() {
        synchronized (sha) {
            sha.update(buffer, 0, marked_pos);
            return sha.digest();
        }
    }

    /**
     * Returns all the data passed throught the stream
     * @return all the data passed throught the stream at the moment
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.461 -0500", hash_original_method = "B51805E12EB2284C59279E2C362DB00D", hash_generated_method = "2BC8CC20EEE33EEDE53FB16B96FB6AAA")
    
protected byte[] getMessages() {
        int len = (read_pos_end > write_pos) ? read_pos_end : write_pos;
        byte[] res = new byte[len];
        System.arraycopy(buffer, 0, res, 0, len);
        return res;
    }
    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
            sha = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Could not initialize the Digest Algorithms.");
        }
    }
    
}

