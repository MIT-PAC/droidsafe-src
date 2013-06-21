package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import javax.net.ssl.SSLHandshakeException;

public class HandshakeIODataStream extends SSLInputStream implements org.apache.harmony.xnet.provider.jsse.Appendable, DataStream {
    private int buff_size = 1024;
    private int inc_buff_size = 1024;
    private byte[] buffer = new byte[buff_size];
    private int read_pos;
    private int marked_pos;
    private int read_pos_end;
    private int write_pos;
    private int write_pos_beg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.775 -0400", hash_original_method = "C3B776612EB17DF4F4BD48A7062A61E9", hash_generated_method = "0B674141A27031106468BE1CF6DD8582")
    @DSModeled(DSC.SAFE)
    public HandshakeIODataStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.776 -0400", hash_original_method = "BF4923D33B65FF9EACCA5F4B8319A955", hash_generated_method = "9E2630828C80C2D1C622248CAF498AB5")
    @DSModeled(DSC.SAFE)
    @Override
    public int available() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return read_pos_end - read_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.776 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "4C8BC0E845541479E10014C1D7864553")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.776 -0400", hash_original_method = "AA335ECE90F2C0243759B4C2341DEAEB", hash_generated_method = "8546FD3CDB3B791C8DF81730C4875DF1")
    @DSModeled(DSC.SAFE)
    @Override
    public void mark(int limit) {
        dsTaint.addTaint(limit);
        marked_pos = read_pos;
        // ---------- Original Method ----------
        //marked_pos = read_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.776 -0400", hash_original_method = "B5D6E2F2B60CF54FA8B6A301921FACA9", hash_generated_method = "8E66598714AB5518D80D85962020F8D6")
    @DSModeled(DSC.SAFE)
    public void mark() {
        marked_pos = read_pos;
        // ---------- Original Method ----------
        //marked_pos = read_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.776 -0400", hash_original_method = "A27E7E8C3D531E39801BBCF5B4CC5B78", hash_generated_method = "693420C1CA7DDBF7BF7CBA32F5E0D8E9")
    @DSModeled(DSC.SAFE)
    @Override
    public void reset() {
        read_pos = marked_pos;
        // ---------- Original Method ----------
        //read_pos = marked_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.776 -0400", hash_original_method = "86BACF12AABDF1D79A57ADD37C52BB94", hash_generated_method = "933DD4A682E7CABF050D3BCA5C001EEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void removeFromMarkedPosition() {
        System.arraycopy(buffer, read_pos,
                buffer, marked_pos, read_pos_end - read_pos);
        read_pos_end -= (read_pos - marked_pos);
        read_pos = marked_pos;
        // ---------- Original Method ----------
        //System.arraycopy(buffer, read_pos,
                //buffer, marked_pos, read_pos_end - read_pos);
        //read_pos_end -= (read_pos - marked_pos);
        //read_pos = marked_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.777 -0400", hash_original_method = "0824C344C7EF76E18DAFC5A0824644C2", hash_generated_method = "EAA73D2306AC92A802010F16CDC5CF40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new EndOfBufferException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (read_pos == read_pos_end) {
            //throw new EndOfBufferException();
        //}
        //return buffer[read_pos++] & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.777 -0400", hash_original_method = "91CEDBDE7A81F4DCE85242430A46DCF1", hash_generated_method = "3A38466202425BCEE4712AB0A04FFB0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] read(int length) throws IOException {
        dsTaint.addTaint(length);
        {
            boolean varD5AB384333E0D6377074E84EED846BEE_1088561452 = (length > available());
            {
                if (DroidSafeAndroidRuntime.control) throw new EndOfBufferException();
            } //End block
        } //End collapsed parenthetic
        byte[] res;
        res = new byte[length];
        System.arraycopy(buffer, read_pos, res, 0, length);
        read_pos = read_pos + length;
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (length > available()) {
            //throw new EndOfBufferException();
        //}
        //byte[] res = new byte[length];
        //System.arraycopy(buffer, read_pos, res, 0, length);
        //read_pos = read_pos + length;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.777 -0400", hash_original_method = "2AC89109B1F5C21FC0020B1393568717", hash_generated_method = "28ABE1660B739BFEB23A845FA8CDABAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] dst, int offset, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        {
            boolean varD5AB384333E0D6377074E84EED846BEE_346131478 = (length > available());
            {
                if (DroidSafeAndroidRuntime.control) throw new EndOfBufferException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(buffer, read_pos, dst, offset, length);
        read_pos = read_pos + length;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (length > available()) {
            //throw new EndOfBufferException();
        //}
        //System.arraycopy(buffer, read_pos, dst, offset, length);
        //read_pos = read_pos + length;
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.777 -0400", hash_original_method = "AF6CB8DBEC021FC7528B8ED3F8431D0F", hash_generated_method = "79051B8352F23E15F163A0383AA8D15C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void append(byte[] src) {
        dsTaint.addTaint(src[0]);
        append(src, 0, src.length);
        // ---------- Original Method ----------
        //append(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.778 -0400", hash_original_method = "2AF2E557DF862B37CD8412561C90BA0E", hash_generated_method = "2DFA7A954998D229C732C9E48DA83FEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void append(byte[] src, int from, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(from);
        dsTaint.addTaint(src[0]);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new AlertException(
                    AlertProtocol.UNEXPECTED_MESSAGE,
                    new SSLHandshakeException(
                        "Handshake message has been received before "
                        + "the last oubound message had been sent."));
            } //End block
            {
                read_pos = write_pos;
                read_pos_end = read_pos;
            } //End block
        } //End block
        {
            enlargeBuffer(read_pos_end+length-buff_size);
        } //End block
        System.arraycopy(src, from, buffer, read_pos_end, length);
        // ---------- Original Method ----------
        //if (read_pos == read_pos_end) {
            //if (write_pos_beg != write_pos) {
                //throw new AlertException(
                    //AlertProtocol.UNEXPECTED_MESSAGE,
                    //new SSLHandshakeException(
                        //"Handshake message has been received before "
                        //+ "the last oubound message had been sent."));
            //}
            //if (read_pos < write_pos) {
                //read_pos = write_pos;
                //read_pos_end = read_pos;
            //}
        //}
        //if (read_pos_end + length > buff_size) {
            //enlargeBuffer(read_pos_end+length-buff_size);
        //}
        //System.arraycopy(src, from, buffer, read_pos_end, length);
        //read_pos_end += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.778 -0400", hash_original_method = "7D810597598BCFC529CACE9B428759B7", hash_generated_method = "AB39FB83E44D36A0593DE54BA42B26C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enlargeBuffer(int size) {
        dsTaint.addTaint(size);
        buff_size = (size < inc_buff_size)
            ? buff_size + inc_buff_size
            : buff_size + size;
        byte[] new_buff;
        new_buff = new byte[buff_size];
        System.arraycopy(buffer, 0, new_buff, 0, buffer.length);
        buffer = new_buff;
        // ---------- Original Method ----------
        //buff_size = (size < inc_buff_size)
            //? buff_size + inc_buff_size
            //: buff_size + size;
        //byte[] new_buff = new byte[buff_size];
        //System.arraycopy(buffer, 0, new_buff, 0, buffer.length);
        //buffer = new_buff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.778 -0400", hash_original_method = "B556221995277C3C7246E0F0C5588CBB", hash_generated_method = "BCBCCE972316FCF6E3ED61C98EDA9548")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void clearBuffer() {
        read_pos = 0;
        marked_pos = 0;
        read_pos_end = 0;
        write_pos = 0;
        write_pos_beg = 0;
        Arrays.fill(buffer, (byte) 0);
        // ---------- Original Method ----------
        //read_pos = 0;
        //marked_pos = 0;
        //read_pos_end = 0;
        //write_pos = 0;
        //write_pos_beg = 0;
        //Arrays.fill(buffer, (byte) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.778 -0400", hash_original_method = "5D32524C92EB4CDA6DDBF787AA4026BF", hash_generated_method = "82816057FF48FCCE9B1E386D3695A17B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void check(int length) {
        dsTaint.addTaint(length);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new AlertException(
                        AlertProtocol.INTERNAL_ERROR,
                        new SSLHandshakeException("Data was not fully read: "
                        + read_pos + " " + read_pos_end));
            } //End block
            {
                write_pos_beg = read_pos_end;
                write_pos = write_pos_beg;
            } //End block
        } //End block
        {
            enlargeBuffer(length);
        } //End block
        // ---------- Original Method ----------
        //if (write_pos == write_pos_beg) {
            //if (read_pos != read_pos_end) {
                //throw new AlertException(
                        //AlertProtocol.INTERNAL_ERROR,
                        //new SSLHandshakeException("Data was not fully read: "
                        //+ read_pos + " " + read_pos_end));
            //}
            //if (write_pos_beg < read_pos_end) {
                //write_pos_beg = read_pos_end;
                //write_pos = write_pos_beg;
            //}
        //}
        //if (write_pos + length >= buff_size) {
            //enlargeBuffer(length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.779 -0400", hash_original_method = "585ADF2190C2ED18E311DC7717079D3E", hash_generated_method = "B51D3C29479D294B2BF9C8FFC483ADA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte b) {
        dsTaint.addTaint(b);
        check(1);
        buffer[write_pos++] = b;
        // ---------- Original Method ----------
        //check(1);
        //buffer[write_pos++] = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.779 -0400", hash_original_method = "D10825FCC1F6D574D203B7119B0DE21D", hash_generated_method = "08B53E27D426D48B0E6405CB0C385F37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeUint8(long n) {
        dsTaint.addTaint(n);
        check(1);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(1);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.779 -0400", hash_original_method = "BC95F3A9D20B746C785DDB55CCD0B371", hash_generated_method = "D54B836C624AD259834E295C5EA09888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeUint16(long n) {
        dsTaint.addTaint(n);
        check(2);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(2);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.779 -0400", hash_original_method = "5F803054AD541DA3DFDDE2CF3FE59841", hash_generated_method = "FCC12BE9CC4436FE13EA2C424EE79DF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeUint24(long n) {
        dsTaint.addTaint(n);
        check(3);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(3);
        //buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.780 -0400", hash_original_method = "F5CBF84A3DE853E04B44967F882D7399", hash_generated_method = "9A9BD0E358DC136CD8D5FA380039003C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeUint32(long n) {
        dsTaint.addTaint(n);
        check(4);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(4);
        //buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        //buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.780 -0400", hash_original_method = "9B394B4CCC83FB2B8DCA345D732654D8", hash_generated_method = "FBC6C2444B26968AD2EA2A4D5C9FD792")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeUint64(long n) {
        dsTaint.addTaint(n);
        check(8);
        buffer[write_pos++] = (byte) ((n & 0x00ff00000000000000L) >> 56);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000000000L) >> 48);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000000000L) >> 40);
        buffer[write_pos++] = (byte) ((n & 0x00ff00000000L) >> 32);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(8);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00000000000000L) >> 56);
        //buffer[write_pos++] = (byte) ((n & 0x00ff000000000000L) >> 48);
        //buffer[write_pos++] = (byte) ((n & 0x00ff0000000000L) >> 40);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00000000L) >> 32);
        //buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        //buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.781 -0400", hash_original_method = "E2E038DF81C8876BEF1DC650925A08F9", hash_generated_method = "321F710A4990A3D605D8F9F1B4AD15BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] vector) {
        dsTaint.addTaint(vector[0]);
        check(vector.length);
        System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        write_pos += vector.length;
        // ---------- Original Method ----------
        //check(vector.length);
        //System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        //write_pos += vector.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.781 -0400", hash_original_method = "8D64F0C3C5F38A8BA7A92E3DA10323F4", hash_generated_method = "4EAA0E681175544E1C1EF977099C084F")
    @DSModeled(DSC.SAFE)
    public boolean hasData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (write_pos > write_pos_beg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.781 -0400", hash_original_method = "E6D2A8CE9FA7080A42A1984AB4D903A3", hash_generated_method = "CF84BF6750A2660EE341C8DEB1D7138B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getData(int length) {
        dsTaint.addTaint(length);
        byte[] res;
        {
            res = new byte[write_pos - write_pos_beg];
            System.arraycopy(buffer, write_pos_beg,
                    res, 0, write_pos-write_pos_beg);
            write_pos_beg = write_pos;
        } //End block
        {
            res = new byte[length];
            System.arraycopy(buffer, write_pos_beg, res, 0, length);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] res;
        //if (write_pos - write_pos_beg < length) {
            //res = new byte[write_pos - write_pos_beg];
            //System.arraycopy(buffer, write_pos_beg,
                    //res, 0, write_pos-write_pos_beg);
            //write_pos_beg = write_pos;
        //} else {
            //res = new byte[length];
            //System.arraycopy(buffer, write_pos_beg, res, 0, length);
            //write_pos_beg += length;
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.781 -0400", hash_original_method = "9B1F555F297B463533438E17CA1DA8BA", hash_generated_method = "935A4D0CBB94215FE11105D4E231E762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] getDigestMD5() {
        {
            int len;
            len = read_pos_end;
            len = write_pos;
            md5.update(buffer, 0, len);
            byte[] var1D3111E25AF9DE89D67F97455370AD7C_1883764395 = (md5.digest());
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //synchronized (md5) {
            //int len = (read_pos_end > write_pos)
                //? read_pos_end
                //: write_pos;
            //md5.update(buffer, 0, len);
            //return md5.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.782 -0400", hash_original_method = "74B8780B4340381F62E79DEE30B1C1C3", hash_generated_method = "86D641624329681212CE6F17FE39EA17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] getDigestSHA() {
        {
            int len;
            len = read_pos_end;
            len = write_pos;
            sha.update(buffer, 0, len);
            byte[] var8CA8D806D5A9557EC0C3C75D02975E01_1165571075 = (sha.digest());
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //synchronized (sha) {
            //int len = (read_pos_end > write_pos)
                //? read_pos_end
                //: write_pos;
            //sha.update(buffer, 0, len);
            //return sha.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.782 -0400", hash_original_method = "DDBF067C5B2E3F42A7068CF9EE336859", hash_generated_method = "EE78431149C591B056B6A59AAE5E8AB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] getDigestMD5withoutLast() {
        {
            md5.update(buffer, 0, marked_pos);
            byte[] var1D3111E25AF9DE89D67F97455370AD7C_1774848401 = (md5.digest());
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //synchronized (md5) {
            //md5.update(buffer, 0, marked_pos);
            //return md5.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.782 -0400", hash_original_method = "BE851090505272B625E52E095FDF236D", hash_generated_method = "314E7C8E251104F52761C76504F896B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] getDigestSHAwithoutLast() {
        {
            sha.update(buffer, 0, marked_pos);
            byte[] var8CA8D806D5A9557EC0C3C75D02975E01_1055567080 = (sha.digest());
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //synchronized (sha) {
            //sha.update(buffer, 0, marked_pos);
            //return sha.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.782 -0400", hash_original_method = "B51805E12EB2284C59279E2C362DB00D", hash_generated_method = "13025E8EE0998ADC20D26A38BA765D4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] getMessages() {
        int len;
        len = read_pos_end;
        len = write_pos;
        byte[] res;
        res = new byte[len];
        System.arraycopy(buffer, 0, res, 0, len);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //int len = (read_pos_end > write_pos) ? read_pos_end : write_pos;
        //byte[] res = new byte[len];
        //System.arraycopy(buffer, 0, res, 0, len);
        //return res;
    }

    
    private static final MessageDigest md5;
    private static final MessageDigest sha;
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

