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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.913 -0400", hash_original_field = "C912DD9B833D125CB4248BE9D582C46D", hash_generated_field = "6ABB97B7E5704DAE089E4AEB36CEB9EE")

    private int buff_size = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.914 -0400", hash_original_field = "7E9E292FBE4FFD0168C2F5F9F1DB2FC0", hash_generated_field = "ECE066EAF80B851FA09366F66474CB4F")

    private int inc_buff_size = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.917 -0400", hash_original_field = "940CE39600E5E7080CFEAD2403914895", hash_generated_field = "59FE230D060C5F66646B4FE7F4893504")

    private byte[] buffer = new byte[buff_size];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.917 -0400", hash_original_field = "B92B5E19F83F631BC914FCA5A884D74B", hash_generated_field = "EA9B3A76326F890C67C38EEB6FEB8AF9")

    private int read_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.918 -0400", hash_original_field = "FF4C9C4B982DED2F74B68139F427F08D", hash_generated_field = "27AC92782C57CF0B819B2420AE5376F7")

    private int marked_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.925 -0400", hash_original_field = "20D41F889DBECBC396FA4C40FD2E9FD7", hash_generated_field = "FF0EA6FB8503DBFADF3AE0199C37EA3B")

    private int read_pos_end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.925 -0400", hash_original_field = "2F3A60B180AD3CB3DB40437E6D5B8577", hash_generated_field = "2A42DC8A8123A01E2D1E9FEB5459A439")

    private int write_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.925 -0400", hash_original_field = "4128F67544D6312811E1F8C637C8EA26", hash_generated_field = "AD1DFD6760C62CD5DA5F016A95D625DE")

    private int write_pos_beg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.926 -0400", hash_original_method = "C3B776612EB17DF4F4BD48A7062A61E9", hash_generated_method = "0B674141A27031106468BE1CF6DD8582")
    public  HandshakeIODataStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.926 -0400", hash_original_method = "BF4923D33B65FF9EACCA5F4B8319A955", hash_generated_method = "FB12C8067056893B9A040E7F6EE66206")
    @Override
    public int available() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328131026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328131026;
        // ---------- Original Method ----------
        //return read_pos_end - read_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.926 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "495CA2D7D663BE03ED9EE493460A3A80")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753156454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753156454;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.927 -0400", hash_original_method = "AA335ECE90F2C0243759B4C2341DEAEB", hash_generated_method = "E057F33B0026174143B2D26EE0FD981B")
    @Override
    public void mark(int limit) {
        marked_pos = read_pos;
        addTaint(limit);
        // ---------- Original Method ----------
        //marked_pos = read_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.927 -0400", hash_original_method = "B5D6E2F2B60CF54FA8B6A301921FACA9", hash_generated_method = "8E66598714AB5518D80D85962020F8D6")
    public void mark() {
        marked_pos = read_pos;
        // ---------- Original Method ----------
        //marked_pos = read_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.930 -0400", hash_original_method = "A27E7E8C3D531E39801BBCF5B4CC5B78", hash_generated_method = "693420C1CA7DDBF7BF7CBA32F5E0D8E9")
    @Override
    public void reset() {
        read_pos = marked_pos;
        // ---------- Original Method ----------
        //read_pos = marked_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.930 -0400", hash_original_method = "86BACF12AABDF1D79A57ADD37C52BB94", hash_generated_method = "933DD4A682E7CABF050D3BCA5C001EEF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.930 -0400", hash_original_method = "0824C344C7EF76E18DAFC5A0824644C2", hash_generated_method = "67B0F773C2C94161DD682BD1C6C6BABD")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new EndOfBufferException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144227218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144227218;
        // ---------- Original Method ----------
        //if (read_pos == read_pos_end) {
            //throw new EndOfBufferException();
        //}
        //return buffer[read_pos++] & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.935 -0400", hash_original_method = "91CEDBDE7A81F4DCE85242430A46DCF1", hash_generated_method = "D9322AFC266E1BE372705BD1A199A849")
    @Override
    public byte[] read(int length) throws IOException {
        {
            boolean varD5AB384333E0D6377074E84EED846BEE_1032245034 = (length > available());
            {
                if (DroidSafeAndroidRuntime.control) throw new EndOfBufferException();
            } //End block
        } //End collapsed parenthetic
        byte[] res;
        res = new byte[length];
        System.arraycopy(buffer, read_pos, res, 0, length);
        read_pos = read_pos + length;
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_241829785 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_241829785;
        // ---------- Original Method ----------
        //if (length > available()) {
            //throw new EndOfBufferException();
        //}
        //byte[] res = new byte[length];
        //System.arraycopy(buffer, read_pos, res, 0, length);
        //read_pos = read_pos + length;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.936 -0400", hash_original_method = "2AC89109B1F5C21FC0020B1393568717", hash_generated_method = "B1CE41F1AAEDDD841B1CDF99E5AD3CA9")
    @Override
    public int read(byte[] dst, int offset, int length) throws IOException {
        {
            boolean varD5AB384333E0D6377074E84EED846BEE_687437449 = (length > available());
            {
                if (DroidSafeAndroidRuntime.control) throw new EndOfBufferException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(buffer, read_pos, dst, offset, length);
        read_pos = read_pos + length;
        addTaint(dst[0]);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955515001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955515001;
        // ---------- Original Method ----------
        //if (length > available()) {
            //throw new EndOfBufferException();
        //}
        //System.arraycopy(buffer, read_pos, dst, offset, length);
        //read_pos = read_pos + length;
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.937 -0400", hash_original_method = "AF6CB8DBEC021FC7528B8ED3F8431D0F", hash_generated_method = "3FC41192D7335178D30298DAD57687FD")
    public void append(byte[] src) {
        append(src, 0, src.length);
        addTaint(src[0]);
        // ---------- Original Method ----------
        //append(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.939 -0400", hash_original_method = "2AF2E557DF862B37CD8412561C90BA0E", hash_generated_method = "9EF92D2C3C35A2178D9874D694A63C05")
    private void append(byte[] src, int from, int length) {
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
        read_pos_end += length;
        addTaint(src[0]);
        addTaint(from);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.941 -0400", hash_original_method = "7D810597598BCFC529CACE9B428759B7", hash_generated_method = "283864ACEA109D7A69C721A9F898B508")
    private void enlargeBuffer(int size) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.941 -0400", hash_original_method = "B556221995277C3C7246E0F0C5588CBB", hash_generated_method = "BCBCCE972316FCF6E3ED61C98EDA9548")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.965 -0400", hash_original_method = "5D32524C92EB4CDA6DDBF787AA4026BF", hash_generated_method = "ADAA1EC7768C0E0F09C135AA7C7F5905")
    private void check(int length) {
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
        addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.965 -0400", hash_original_method = "585ADF2190C2ED18E311DC7717079D3E", hash_generated_method = "50E8F06F9B2EC6BE2FD6E36ABAB0E9B3")
    public void write(byte b) {
        check(1);
        buffer[write_pos++] = b;
        // ---------- Original Method ----------
        //check(1);
        //buffer[write_pos++] = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.967 -0400", hash_original_method = "D10825FCC1F6D574D203B7119B0DE21D", hash_generated_method = "746FA1D852B4462B02D4B11DE4F038B2")
    public void writeUint8(long n) {
        check(1);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(1);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.968 -0400", hash_original_method = "BC95F3A9D20B746C785DDB55CCD0B371", hash_generated_method = "5866BECFA5BEC5BCACD7708A89B8E0C2")
    public void writeUint16(long n) {
        check(2);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(2);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.972 -0400", hash_original_method = "5F803054AD541DA3DFDDE2CF3FE59841", hash_generated_method = "B27E2A86274DAC461A04AD89C4AE2BC0")
    public void writeUint24(long n) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.973 -0400", hash_original_method = "F5CBF84A3DE853E04B44967F882D7399", hash_generated_method = "9F56E6BFB9DCC5E8C9071586A6904FDB")
    public void writeUint32(long n) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.976 -0400", hash_original_method = "9B394B4CCC83FB2B8DCA345D732654D8", hash_generated_method = "C9F7F02983D8E0AD1829D109FA43876B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.987 -0400", hash_original_method = "E2E038DF81C8876BEF1DC650925A08F9", hash_generated_method = "62CE06DF1672F4376F05B684697D9A29")
    public void write(byte[] vector) {
        check(vector.length);
        System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        write_pos += vector.length;
        // ---------- Original Method ----------
        //check(vector.length);
        //System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        //write_pos += vector.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.988 -0400", hash_original_method = "8D64F0C3C5F38A8BA7A92E3DA10323F4", hash_generated_method = "34FAF1716B0BAABBF297DD0166DE4FA3")
    public boolean hasData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476731794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476731794;
        // ---------- Original Method ----------
        //return (write_pos > write_pos_beg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.988 -0400", hash_original_method = "E6D2A8CE9FA7080A42A1984AB4D903A3", hash_generated_method = "9306780EA47CA4B5D648F834D408CD09")
    public byte[] getData(int length) {
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
            write_pos_beg += length;
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1625027302 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1625027302;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.988 -0400", hash_original_method = "9B1F555F297B463533438E17CA1DA8BA", hash_generated_method = "082451B6168EC22B31CB9613B00B93A4")
    protected byte[] getDigestMD5() {
        {
            int len;
            len = read_pos_end;
            len = write_pos;
            md5.update(buffer, 0, len);
            byte[] var1D3111E25AF9DE89D67F97455370AD7C_431912088 = (md5.digest());
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1775634409 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1775634409;
        // ---------- Original Method ----------
        //synchronized (md5) {
            //int len = (read_pos_end > write_pos)
                //? read_pos_end
                //: write_pos;
            //md5.update(buffer, 0, len);
            //return md5.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.993 -0400", hash_original_method = "74B8780B4340381F62E79DEE30B1C1C3", hash_generated_method = "BB02780EED9FA4246BD601EB0A7FD48A")
    protected byte[] getDigestSHA() {
        {
            int len;
            len = read_pos_end;
            len = write_pos;
            sha.update(buffer, 0, len);
            byte[] var8CA8D806D5A9557EC0C3C75D02975E01_1071624176 = (sha.digest());
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_113230860 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_113230860;
        // ---------- Original Method ----------
        //synchronized (sha) {
            //int len = (read_pos_end > write_pos)
                //? read_pos_end
                //: write_pos;
            //sha.update(buffer, 0, len);
            //return sha.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.996 -0400", hash_original_method = "DDBF067C5B2E3F42A7068CF9EE336859", hash_generated_method = "31BF82F41A015E240CD1C9F6D22E15F6")
    protected byte[] getDigestMD5withoutLast() {
        {
            md5.update(buffer, 0, marked_pos);
            byte[] var1D3111E25AF9DE89D67F97455370AD7C_557005657 = (md5.digest());
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1440989919 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1440989919;
        // ---------- Original Method ----------
        //synchronized (md5) {
            //md5.update(buffer, 0, marked_pos);
            //return md5.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.996 -0400", hash_original_method = "BE851090505272B625E52E095FDF236D", hash_generated_method = "96B69C7BDD7D9D440E4799FF84E1A4F7")
    protected byte[] getDigestSHAwithoutLast() {
        {
            sha.update(buffer, 0, marked_pos);
            byte[] var8CA8D806D5A9557EC0C3C75D02975E01_962373991 = (sha.digest());
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1508840931 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1508840931;
        // ---------- Original Method ----------
        //synchronized (sha) {
            //sha.update(buffer, 0, marked_pos);
            //return sha.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.005 -0400", hash_original_method = "B51805E12EB2284C59279E2C362DB00D", hash_generated_method = "5C6EE9581AE3024EAFDB7EA9C24415BE")
    protected byte[] getMessages() {
        int len;
        len = read_pos_end;
        len = write_pos;
        byte[] res;
        res = new byte[len];
        System.arraycopy(buffer, 0, res, 0, len);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1270263211 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1270263211;
        // ---------- Original Method ----------
        //int len = (read_pos_end > write_pos) ? read_pos_end : write_pos;
        //byte[] res = new byte[len];
        //System.arraycopy(buffer, 0, res, 0, len);
        //return res;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.005 -0400", hash_original_field = "1BC29B36F623BA82AAF6724FD3B16718", hash_generated_field = "17962FC0CAF6059B3EB6A90549C3E142")

    private static MessageDigest md5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.005 -0400", hash_original_field = "CA794FB2D950ACF25C964ECC35F2D7E2", hash_generated_field = "A133435596333D642AF59DA1AC707533")

    private static MessageDigest sha;
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

