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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.889 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.889 -0400", hash_original_field = "B9CEC40C2FA6FEB503BDD2E3E1AC4947", hash_generated_field = "84D2D8F04948CA1C168D3A3584462F87")

    private boolean shouldClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.890 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.890 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.891 -0400", hash_original_method = "1BD49D518996D312C80F5CC2297619D7", hash_generated_method = "1688066ADDF39930EC631186217A93F4")
    public  FileInputStream(File file) throws FileNotFoundException {
        if(file == null)        
        {
            NullPointerException var34C654CB6A962C169433BF5C5405377F_2780283 = new NullPointerException("file == null");
            var34C654CB6A962C169433BF5C5405377F_2780283.addTaint(taint);
            throw var34C654CB6A962C169433BF5C5405377F_2780283;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.892 -0400", hash_original_method = "9A99F3F0C17344BC7A4198604236E89C", hash_generated_method = "9146399E1525CADD857D4B6A9DC0DDA6")
    public  FileInputStream(FileDescriptor fd) {
        if(fd == null)        
        {
            NullPointerException var80E87090A64E83D6A9C06DE7A777A91D_2111454816 = new NullPointerException("fd == null");
            var80E87090A64E83D6A9C06DE7A777A91D_2111454816.addTaint(taint);
            throw var80E87090A64E83D6A9C06DE7A777A91D_2111454816;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.892 -0400", hash_original_method = "3B135756B4C06BFF0359EE9E41EEDC20", hash_generated_method = "09BF0DBCFC9F6A5C54384ECD46733983")
    public  FileInputStream(String path) throws FileNotFoundException {
        this(new File(path));
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.892 -0400", hash_original_method = "EBD7B964937B6AA7FA3657DA1AAC30BC", hash_generated_method = "DD520337530E5AD7C59986226E7508D1")
    @Override
    public int available() throws IOException {
        int var16B823D9AF3F941AD9DE567252E43371_597024880 = (IoBridge.available(fd));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739780759 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739780759;
        // ---------- Original Method ----------
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.893 -0400", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "EE9AE9D010385501F5824C8DC6CF7D6A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.894 -0400", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "B74A01965EB118AEAC5EAF26718DFEFF")
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
                AssertionError var31F1143F51E5C3306DAC550F61AF5CBA_383193568 = new AssertionError(t);
                var31F1143F51E5C3306DAC550F61AF5CBA_383193568.addTaint(taint);
                throw var31F1143F51E5C3306DAC550F61AF5CBA_383193568;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.895 -0400", hash_original_method = "BB4E25A77FBA5E31003F6019B5643EE2", hash_generated_method = "6F9F67560B99B6CC8AD79BB2F1AF841C")
    public FileChannel getChannel() {
        synchronized
(this)        {
            if(channel == null)            
            {
                channel = NioUtils.newFileChannel(this, fd, O_RDONLY);
            } //End block
FileChannel var99BA3483FD74E36EACD435CEE6BD5D6F_1602828262 =             channel;
            var99BA3483FD74E36EACD435CEE6BD5D6F_1602828262.addTaint(taint);
            return var99BA3483FD74E36EACD435CEE6BD5D6F_1602828262;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (channel == null) {
                //channel = NioUtils.newFileChannel(this, fd, O_RDONLY);
            //}
            //return channel;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.895 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "B7D7CBBAB64426EFDEE666C395F6C9E1")
    public final FileDescriptor getFD() throws IOException {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1259137338 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_1259137338.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_1259137338;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.896 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "90D2B1BDDBE7177D622D311DE2058054")
    @Override
    public int read() throws IOException {
        int varC29A5AE95A30EE64395CAB97F32FA4B0_903900132 = (Streams.readSingleByte(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460147112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460147112;
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.897 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "FC89F46A1F4AE6BE548DA72760B10C3B")
    @Override
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(buffer[0]);
        int var515005EC72FBFD1EBFD0E3FF9751DEEE_103680190 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120160735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120160735;
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.911 -0400", hash_original_method = "4138A4F75DA401A9AB2AB0F0CF384113", hash_generated_method = "87444899228FC9E93D297C4427357CBA")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
        if(byteCount < 0)        
        {
            IOException var699EC234BBF7CDB70D5AF4C45D3292A3_1458678235 = new IOException("byteCount < 0: " + byteCount);
            var699EC234BBF7CDB70D5AF4C45D3292A3_1458678235.addTaint(taint);
            throw var699EC234BBF7CDB70D5AF4C45D3292A3_1458678235;
        } //End block
        try 
        {
            Libcore.os.lseek(fd, byteCount, SEEK_CUR);
            long varA43EF6D60A83013EA1A61A23BDB16029_285651227 = (byteCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_966361374 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_966361374;
        } //End block
        catch (ErrnoException errnoException)
        {
            if(errnoException.errno == ESPIPE)            
            {
                long var6E87E28E05EBB2DB86625D385B569E85_1970399993 = (super.skip(byteCount));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1109013779 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1109013779;
            } //End block
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_2137576813 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_2137576813.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_2137576813;
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

