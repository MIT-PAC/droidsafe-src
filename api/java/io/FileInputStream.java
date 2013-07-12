package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.CloseGuard;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.Streams;
import static libcore.io.OsConstants.*;

public class FileInputStream extends InputStream implements Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.497 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.497 -0400", hash_original_field = "B9CEC40C2FA6FEB503BDD2E3E1AC4947", hash_generated_field = "84D2D8F04948CA1C168D3A3584462F87")

    private boolean shouldClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.499 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.500 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.503 -0400", hash_original_method = "1BD49D518996D312C80F5CC2297619D7", hash_generated_method = "25034926B973A6EC580C1144B3A30E67")
    public  FileInputStream(File file) throws FileNotFoundException {
    if(file == null)        
        {
            NullPointerException var34C654CB6A962C169433BF5C5405377F_361410960 = new NullPointerException("file == null");
            var34C654CB6A962C169433BF5C5405377F_361410960.addTaint(taint);
            throw var34C654CB6A962C169433BF5C5405377F_361410960;
        } //End block
        this.fd = IoBridge.open(file.getAbsolutePath(), O_RDONLY);
        this.shouldClose = true;
        guard.open("close");
        // ---------- Original Method ----------
        //if (file == null) {
            //throw new NullPointerException("file == null");
        //}
        //this.fd = IoBridge.open(file.getAbsolutePath(), O_RDONLY);
        //this.shouldClose = true;
        //guard.open("close");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.507 -0400", hash_original_method = "9A99F3F0C17344BC7A4198604236E89C", hash_generated_method = "7BCBC989486DE76C74DF9DDD8C471B10")
    public  FileInputStream(FileDescriptor fd) {
    if(fd == null)        
        {
            NullPointerException var80E87090A64E83D6A9C06DE7A777A91D_1968879422 = new NullPointerException("fd == null");
            var80E87090A64E83D6A9C06DE7A777A91D_1968879422.addTaint(taint);
            throw var80E87090A64E83D6A9C06DE7A777A91D_1968879422;
        } //End block
        this.fd = fd;
        this.shouldClose = false;
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new NullPointerException("fd == null");
        //}
        //this.fd = fd;
        //this.shouldClose = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.509 -0400", hash_original_method = "3B135756B4C06BFF0359EE9E41EEDC20", hash_generated_method = "09BF0DBCFC9F6A5C54384ECD46733983")
    public  FileInputStream(String path) throws FileNotFoundException {
        this(new File(path));
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.510 -0400", hash_original_method = "EBD7B964937B6AA7FA3657DA1AAC30BC", hash_generated_method = "CC4544BE3ACF885123DF615FA56A13D6")
    @Override
    public int available() throws IOException {
        int var16B823D9AF3F941AD9DE567252E43371_1602863299 = (IoBridge.available(fd));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445221367 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445221367;
        // ---------- Original Method ----------
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.513 -0400", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "EE9AE9D010385501F5824C8DC6CF7D6A")
    @Override
    public void close() throws IOException {
        guard.close();
        synchronized
(this)        {
    if(channel != null)            
            {
                channel.close();
            } //End block
    if(shouldClose)            
            {
                IoUtils.close(fd);
            } //End block
            else
            {
                fd = new FileDescriptor();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //guard.close();
        //synchronized (this) {
            //if (channel != null) {
                //channel.close();
            //}
            //if (shouldClose) {
                //IoUtils.close(fd);
            //} else {
                //fd = new FileDescriptor();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.515 -0400", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "D7244B69F516A68F662CA7C442760966")
    @Override
    protected void finalize() throws IOException {
        try 
        {
    if(guard != null)            
            {
                guard.warnIfOpen();
            } //End block
            close();
        } //End block
        finally 
        {
            try 
            {
                super.finalize();
            } //End block
            catch (Throwable t)
            {
                AssertionError var31F1143F51E5C3306DAC550F61AF5CBA_1336648816 = new AssertionError(t);
                var31F1143F51E5C3306DAC550F61AF5CBA_1336648816.addTaint(taint);
                throw var31F1143F51E5C3306DAC550F61AF5CBA_1336648816;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
            //close();
        //} finally {
            //try {
                //super.finalize();
            //} catch (Throwable t) {
                //throw new AssertionError(t);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.517 -0400", hash_original_method = "BB4E25A77FBA5E31003F6019B5643EE2", hash_generated_method = "BC13D0109EA585BA2287E511E1723A66")
    public FileChannel getChannel() {
        synchronized
(this)        {
    if(channel == null)            
            {
                channel = NioUtils.newFileChannel(this, fd, O_RDONLY);
            } //End block
FileChannel var99BA3483FD74E36EACD435CEE6BD5D6F_2094131984 =             channel;
            var99BA3483FD74E36EACD435CEE6BD5D6F_2094131984.addTaint(taint);
            return var99BA3483FD74E36EACD435CEE6BD5D6F_2094131984;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (channel == null) {
                //channel = NioUtils.newFileChannel(this, fd, O_RDONLY);
            //}
            //return channel;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.532 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "58F8F3E966E5C2D88F89F2E42B7977EC")
    public final FileDescriptor getFD() throws IOException {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_356304009 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_356304009.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_356304009;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.534 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "BADA7F56BEE562FD6AC780931F58F058")
    @Override
    public int read() throws IOException {
        int varC29A5AE95A30EE64395CAB97F32FA4B0_407337043 = (Streams.readSingleByte(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540330470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540330470;
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.535 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "20B1D60063D6F3E129EADD288AA8AF7E")
    @Override
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(buffer[0]);
        int var515005EC72FBFD1EBFD0E3FF9751DEEE_1483295023 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840822963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840822963;
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.562 -0400", hash_original_method = "4138A4F75DA401A9AB2AB0F0CF384113", hash_generated_method = "51C3FF9E5C8EB451F17462B58A03CE88")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
    if(byteCount < 0)        
        {
            IOException var699EC234BBF7CDB70D5AF4C45D3292A3_1322921350 = new IOException("byteCount < 0: " + byteCount);
            var699EC234BBF7CDB70D5AF4C45D3292A3_1322921350.addTaint(taint);
            throw var699EC234BBF7CDB70D5AF4C45D3292A3_1322921350;
        } //End block
        try 
        {
            Libcore.os.lseek(fd, byteCount, SEEK_CUR);
            long varA43EF6D60A83013EA1A61A23BDB16029_939651769 = (byteCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_403169090 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_403169090;
        } //End block
        catch (ErrnoException errnoException)
        {
    if(errnoException.errno == ESPIPE)            
            {
                long var6E87E28E05EBB2DB86625D385B569E85_1490756816 = (super.skip(byteCount));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1219362103 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1219362103;
            } //End block
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_694154134 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_694154134.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_694154134;
        } //End block
        // ---------- Original Method ----------
        //if (byteCount < 0) {
            //throw new IOException("byteCount < 0: " + byteCount);
        //}
        //try {
            //Libcore.os.lseek(fd, byteCount, SEEK_CUR);
            //return byteCount;
        //} catch (ErrnoException errnoException) {
            //if (errnoException.errno == ESPIPE) {
                //return super.skip(byteCount);
            //}
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
}

