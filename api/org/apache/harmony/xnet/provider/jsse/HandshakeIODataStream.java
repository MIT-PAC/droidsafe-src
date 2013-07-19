package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.net.ssl.SSLHandshakeException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HandshakeIODataStream extends SSLInputStream implements org.apache.harmony.xnet.provider.jsse.Appendable, DataStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.583 -0400", hash_original_field = "C912DD9B833D125CB4248BE9D582C46D", hash_generated_field = "6ABB97B7E5704DAE089E4AEB36CEB9EE")

    private int buff_size = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.583 -0400", hash_original_field = "7E9E292FBE4FFD0168C2F5F9F1DB2FC0", hash_generated_field = "ECE066EAF80B851FA09366F66474CB4F")

    private int inc_buff_size = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.583 -0400", hash_original_field = "940CE39600E5E7080CFEAD2403914895", hash_generated_field = "59FE230D060C5F66646B4FE7F4893504")

    private byte[] buffer = new byte[buff_size];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.583 -0400", hash_original_field = "B92B5E19F83F631BC914FCA5A884D74B", hash_generated_field = "EA9B3A76326F890C67C38EEB6FEB8AF9")

    private int read_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.583 -0400", hash_original_field = "FF4C9C4B982DED2F74B68139F427F08D", hash_generated_field = "27AC92782C57CF0B819B2420AE5376F7")

    private int marked_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.584 -0400", hash_original_field = "20D41F889DBECBC396FA4C40FD2E9FD7", hash_generated_field = "FF0EA6FB8503DBFADF3AE0199C37EA3B")

    private int read_pos_end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.584 -0400", hash_original_field = "2F3A60B180AD3CB3DB40437E6D5B8577", hash_generated_field = "2A42DC8A8123A01E2D1E9FEB5459A439")

    private int write_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.584 -0400", hash_original_field = "4128F67544D6312811E1F8C637C8EA26", hash_generated_field = "AD1DFD6760C62CD5DA5F016A95D625DE")

    private int write_pos_beg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.584 -0400", hash_original_method = "C3B776612EB17DF4F4BD48A7062A61E9", hash_generated_method = "0B674141A27031106468BE1CF6DD8582")
    public  HandshakeIODataStream() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.584 -0400", hash_original_method = "BF4923D33B65FF9EACCA5F4B8319A955", hash_generated_method = "E2E84B1B13DF2DF4C0048BE914301E61")
    @Override
    public int available() {
        int varA36AAC7BFD2F648D2B18EC61BBDBFF9E_1524802405 = (read_pos_end - read_pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735653432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735653432;
        // ---------- Original Method ----------
        //return read_pos_end - read_pos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.585 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "AEB2CE451502A4CEF9E80B59D20D77D1")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_73524005 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1380147369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1380147369;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.585 -0400", hash_original_method = "AA335ECE90F2C0243759B4C2341DEAEB", hash_generated_method = "6FC75D596CA3592ABDB6452257C64698")
    @Override
    public void mark(int limit) {
        addTaint(limit);
        marked_pos = read_pos;
        // ---------- Original Method ----------
        //marked_pos = read_pos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.585 -0400", hash_original_method = "B5D6E2F2B60CF54FA8B6A301921FACA9", hash_generated_method = "8E66598714AB5518D80D85962020F8D6")
    public void mark() {
        marked_pos = read_pos;
        // ---------- Original Method ----------
        //marked_pos = read_pos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.586 -0400", hash_original_method = "A27E7E8C3D531E39801BBCF5B4CC5B78", hash_generated_method = "693420C1CA7DDBF7BF7CBA32F5E0D8E9")
    @Override
    public void reset() {
        read_pos = marked_pos;
        // ---------- Original Method ----------
        //read_pos = marked_pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.586 -0400", hash_original_method = "86BACF12AABDF1D79A57ADD37C52BB94", hash_generated_method = "933DD4A682E7CABF050D3BCA5C001EEF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.586 -0400", hash_original_method = "0824C344C7EF76E18DAFC5A0824644C2", hash_generated_method = "5ECBAF2284737D8BCFFB957389C1C791")
    @Override
    public int read() throws IOException {
        if(read_pos == read_pos_end)        
        {
            EndOfBufferException var2FD9D9218EBC95DE1840304BBDFC9EB5_722922719 = new EndOfBufferException();
            var2FD9D9218EBC95DE1840304BBDFC9EB5_722922719.addTaint(taint);
            throw var2FD9D9218EBC95DE1840304BBDFC9EB5_722922719;
        } //End block
        int varEDF9E7723DD041BD87E6398AEACEFB95_585569913 = (buffer[read_pos++] & 0xFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768031841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768031841;
        // ---------- Original Method ----------
        //if (read_pos == read_pos_end) {
            //throw new EndOfBufferException();
        //}
        //return buffer[read_pos++] & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.587 -0400", hash_original_method = "91CEDBDE7A81F4DCE85242430A46DCF1", hash_generated_method = "2F0832E4C9E8D1E6DA24572D9070C2D6")
    @Override
    public byte[] read(int length) throws IOException {
        if(length > available())        
        {
            EndOfBufferException var2FD9D9218EBC95DE1840304BBDFC9EB5_868563886 = new EndOfBufferException();
            var2FD9D9218EBC95DE1840304BBDFC9EB5_868563886.addTaint(taint);
            throw var2FD9D9218EBC95DE1840304BBDFC9EB5_868563886;
        } //End block
        byte[] res = new byte[length];
        System.arraycopy(buffer, read_pos, res, 0, length);
        read_pos = read_pos + length;
        byte[] var9B207167E5381C47682C6B4F58A623FB_34852804 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_93202910 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_93202910;
        // ---------- Original Method ----------
        //if (length > available()) {
            //throw new EndOfBufferException();
        //}
        //byte[] res = new byte[length];
        //System.arraycopy(buffer, read_pos, res, 0, length);
        //read_pos = read_pos + length;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.588 -0400", hash_original_method = "2AC89109B1F5C21FC0020B1393568717", hash_generated_method = "AE68D7BD920D175F3AD30AF6C67BAD36")
    @Override
    public int read(byte[] dst, int offset, int length) throws IOException {
        addTaint(offset);
        addTaint(dst[0]);
        if(length > available())        
        {
            EndOfBufferException var2FD9D9218EBC95DE1840304BBDFC9EB5_370087207 = new EndOfBufferException();
            var2FD9D9218EBC95DE1840304BBDFC9EB5_370087207.addTaint(taint);
            throw var2FD9D9218EBC95DE1840304BBDFC9EB5_370087207;
        } //End block
        System.arraycopy(buffer, read_pos, dst, offset, length);
        read_pos = read_pos + length;
        int var2FA47F7C65FEC19CC163B195725E3844_1004138138 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914082422 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914082422;
        // ---------- Original Method ----------
        //if (length > available()) {
            //throw new EndOfBufferException();
        //}
        //System.arraycopy(buffer, read_pos, dst, offset, length);
        //read_pos = read_pos + length;
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.588 -0400", hash_original_method = "AF6CB8DBEC021FC7528B8ED3F8431D0F", hash_generated_method = "2ACDA3F035E3A9FC3DD5633D9B6E6743")
    public void append(byte[] src) {
        addTaint(src[0]);
        append(src, 0, src.length);
        // ---------- Original Method ----------
        //append(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.589 -0400", hash_original_method = "2AF2E557DF862B37CD8412561C90BA0E", hash_generated_method = "60D02C2432505DDA3CAC748FCDCD4B8C")
    private void append(byte[] src, int from, int length) {
        addTaint(from);
        addTaint(src[0]);
        if(read_pos == read_pos_end)        
        {
            if(write_pos_beg != write_pos)            
            {
                AlertException var62753D7B68B46D335DC288F6CA6B8280_94547369 = new AlertException(
                    AlertProtocol.UNEXPECTED_MESSAGE,
                    new SSLHandshakeException(
                        "Handshake message has been received before "
                        + "the last oubound message had been sent."));
                var62753D7B68B46D335DC288F6CA6B8280_94547369.addTaint(taint);
                throw var62753D7B68B46D335DC288F6CA6B8280_94547369;
            } //End block
            if(read_pos < write_pos)            
            {
                read_pos = write_pos;
                read_pos_end = read_pos;
            } //End block
        } //End block
        if(read_pos_end + length > buff_size)        
        {
            enlargeBuffer(read_pos_end+length-buff_size);
        } //End block
        System.arraycopy(src, from, buffer, read_pos_end, length);
        read_pos_end += length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.590 -0400", hash_original_method = "7D810597598BCFC529CACE9B428759B7", hash_generated_method = "F10C7007A5E34FDD773FDB6E4B15CED8")
    private void enlargeBuffer(int size) {
        buff_size = (size < inc_buff_size)
            ? buff_size + inc_buff_size
            : buff_size + size;
        byte[] new_buff = new byte[buff_size];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.591 -0400", hash_original_method = "B556221995277C3C7246E0F0C5588CBB", hash_generated_method = "BCBCCE972316FCF6E3ED61C98EDA9548")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.593 -0400", hash_original_method = "5D32524C92EB4CDA6DDBF787AA4026BF", hash_generated_method = "E8E46D6030E7897E18219248C0BE459C")
    private void check(int length) {
        addTaint(length);
        if(write_pos == write_pos_beg)        
        {
            if(read_pos != read_pos_end)            
            {
                AlertException varAF5D10BB12840AE996AC8724BF063613_1111155871 = new AlertException(
                        AlertProtocol.INTERNAL_ERROR,
                        new SSLHandshakeException("Data was not fully read: "
                        + read_pos + " " + read_pos_end));
                varAF5D10BB12840AE996AC8724BF063613_1111155871.addTaint(taint);
                throw varAF5D10BB12840AE996AC8724BF063613_1111155871;
            } //End block
            if(write_pos_beg < read_pos_end)            
            {
                write_pos_beg = read_pos_end;
                write_pos = write_pos_beg;
            } //End block
        } //End block
        if(write_pos + length >= buff_size)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.593 -0400", hash_original_method = "585ADF2190C2ED18E311DC7717079D3E", hash_generated_method = "50E8F06F9B2EC6BE2FD6E36ABAB0E9B3")
    public void write(byte b) {
        check(1);
        buffer[write_pos++] = b;
        // ---------- Original Method ----------
        //check(1);
        //buffer[write_pos++] = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.594 -0400", hash_original_method = "D10825FCC1F6D574D203B7119B0DE21D", hash_generated_method = "746FA1D852B4462B02D4B11DE4F038B2")
    public void writeUint8(long n) {
        check(1);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(1);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.594 -0400", hash_original_method = "BC95F3A9D20B746C785DDB55CCD0B371", hash_generated_method = "5866BECFA5BEC5BCACD7708A89B8E0C2")
    public void writeUint16(long n) {
        check(2);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        // ---------- Original Method ----------
        //check(2);
        //buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        //buffer[write_pos++] = (byte) (n & 0x00ff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.595 -0400", hash_original_method = "5F803054AD541DA3DFDDE2CF3FE59841", hash_generated_method = "B27E2A86274DAC461A04AD89C4AE2BC0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.595 -0400", hash_original_method = "F5CBF84A3DE853E04B44967F882D7399", hash_generated_method = "9F56E6BFB9DCC5E8C9071586A6904FDB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.596 -0400", hash_original_method = "9B394B4CCC83FB2B8DCA345D732654D8", hash_generated_method = "C9F7F02983D8E0AD1829D109FA43876B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.596 -0400", hash_original_method = "E2E038DF81C8876BEF1DC650925A08F9", hash_generated_method = "62CE06DF1672F4376F05B684697D9A29")
    public void write(byte[] vector) {
        check(vector.length);
        System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        write_pos += vector.length;
        // ---------- Original Method ----------
        //check(vector.length);
        //System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        //write_pos += vector.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.596 -0400", hash_original_method = "8D64F0C3C5F38A8BA7A92E3DA10323F4", hash_generated_method = "22C5B78B25DB0BF5453050AC13D58060")
    public boolean hasData() {
        boolean varFC0938447DDB3704EEEB90CDB9306E91_1754014859 = ((write_pos > write_pos_beg));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719957132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719957132;
        // ---------- Original Method ----------
        //return (write_pos > write_pos_beg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_method = "E6D2A8CE9FA7080A42A1984AB4D903A3", hash_generated_method = "A22F270A9ECC3F00593DBBE6BF9FA8A9")
    public byte[] getData(int length) {
        byte[] res;
        if(write_pos - write_pos_beg < length)        
        {
            res = new byte[write_pos - write_pos_beg];
            System.arraycopy(buffer, write_pos_beg,
                    res, 0, write_pos-write_pos_beg);
            write_pos_beg = write_pos;
        } //End block
        else
        {
            res = new byte[length];
            System.arraycopy(buffer, write_pos_beg, res, 0, length);
            write_pos_beg += length;
        } //End block
        byte[] var9B207167E5381C47682C6B4F58A623FB_185468902 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_158399894 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_158399894;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_method = "9B1F555F297B463533438E17CA1DA8BA", hash_generated_method = "7A501DD19EDEEAFA07CB761167D2C0D6")
    protected byte[] getDigestMD5() {
        synchronized
(md5)        {
            int len = (read_pos_end > write_pos)
                ? read_pos_end
                : write_pos;
            md5.update(buffer, 0, len);
            byte[] var1B356D866D0E3D52F9E5A877448C2565_130160220 = (md5.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1276489839 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1276489839;
        } //End block
        // ---------- Original Method ----------
        //synchronized (md5) {
            //int len = (read_pos_end > write_pos)
                //? read_pos_end
                //: write_pos;
            //md5.update(buffer, 0, len);
            //return md5.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_method = "74B8780B4340381F62E79DEE30B1C1C3", hash_generated_method = "2F9444675C465294EBFAFA5453214FAC")
    protected byte[] getDigestSHA() {
        synchronized
(sha)        {
            int len = (read_pos_end > write_pos)
                ? read_pos_end
                : write_pos;
            sha.update(buffer, 0, len);
            byte[] varF7A2BE41696CC35E0BB9AD20C75DEF7C_159749017 = (sha.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_154217975 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_154217975;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sha) {
            //int len = (read_pos_end > write_pos)
                //? read_pos_end
                //: write_pos;
            //sha.update(buffer, 0, len);
            //return sha.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_method = "DDBF067C5B2E3F42A7068CF9EE336859", hash_generated_method = "6F518251EF25EFF7B7DE605C5AC85F14")
    protected byte[] getDigestMD5withoutLast() {
        synchronized
(md5)        {
            md5.update(buffer, 0, marked_pos);
            byte[] var1B356D866D0E3D52F9E5A877448C2565_713278994 = (md5.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_927342423 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_927342423;
        } //End block
        // ---------- Original Method ----------
        //synchronized (md5) {
            //md5.update(buffer, 0, marked_pos);
            //return md5.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_method = "BE851090505272B625E52E095FDF236D", hash_generated_method = "2CCF85B1D897B909B27E6D4FC82C393A")
    protected byte[] getDigestSHAwithoutLast() {
        synchronized
(sha)        {
            sha.update(buffer, 0, marked_pos);
            byte[] varF7A2BE41696CC35E0BB9AD20C75DEF7C_2142077697 = (sha.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_356591143 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_356591143;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sha) {
            //sha.update(buffer, 0, marked_pos);
            //return sha.digest();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_method = "B51805E12EB2284C59279E2C362DB00D", hash_generated_method = "8C68ED1B7E8EB4F7DE27E6363CB4D273")
    protected byte[] getMessages() {
        int len = (read_pos_end > write_pos) ? read_pos_end : write_pos;
        byte[] res = new byte[len];
        System.arraycopy(buffer, 0, res, 0, len);
        byte[] var9B207167E5381C47682C6B4F58A623FB_163053533 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1882591566 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1882591566;
        // ---------- Original Method ----------
        //int len = (read_pos_end > write_pos) ? read_pos_end : write_pos;
        //byte[] res = new byte[len];
        //System.arraycopy(buffer, 0, res, 0, len);
        //return res;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_field = "1BC29B36F623BA82AAF6724FD3B16718", hash_generated_field = "17962FC0CAF6059B3EB6A90549C3E142")

    private static MessageDigest md5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.597 -0400", hash_original_field = "CA794FB2D950ACF25C964ECC35F2D7E2", hash_generated_field = "A133435596333D642AF59DA1AC707533")

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

