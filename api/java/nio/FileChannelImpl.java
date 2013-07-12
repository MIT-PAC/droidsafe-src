package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.StructFlock;
import libcore.util.MutableLong;
import static libcore.io.OsConstants.*;

final class FileChannelImpl extends FileChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.344 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "6DF85966286B5A79BC125BD24D7FC97F")

    private Object stream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.344 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.344 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.344 -0400", hash_original_field = "6534500F3CBE19A8D61109391469B658", hash_generated_field = "41CABECFE29C1BC14C56B2F0C987CEF1")

    private final SortedSet<FileLock> locks = new TreeSet<FileLock>(LOCK_COMPARATOR);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.345 -0400", hash_original_method = "2735A1029D285B5D3DE10DB0E230E666", hash_generated_method = "F6F44BF98254D27848329B7C58999156")
    public  FileChannelImpl(Object stream, FileDescriptor fd, int mode) {
        this.fd = fd;
        this.stream = stream;
        this.mode = mode;
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.stream = stream;
        //this.mode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.345 -0400", hash_original_method = "6E6D3E88914C52E71D3EAF93EC51DF72", hash_generated_method = "7F1069953BCBAED92619E164B6D50D1F")
    private void checkOpen() throws ClosedChannelException {
    if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_430965500 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_430965500.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_430965500;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.346 -0400", hash_original_method = "48C6D0CA0A11D20CF44BD79CC21BDD35", hash_generated_method = "F8BFDFE162A27494F66DAF99358570FC")
    private void checkReadable() {
    if((mode & O_ACCMODE) == O_WRONLY)        
        {
            NonReadableChannelException var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1563907409 = new NonReadableChannelException();
            var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1563907409.addTaint(taint);
            throw var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1563907409;
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_WRONLY) {
            //throw new NonReadableChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.346 -0400", hash_original_method = "B5384AE1DC067BB9B7371F695174CE9F", hash_generated_method = "426F2AE03CCED3DF77B7E5B60060090B")
    private void checkWritable() {
    if((mode & O_ACCMODE) == O_RDONLY)        
        {
            NonWritableChannelException var15CCC24BBCA9E1CFEF326F26183D5D87_1570211633 = new NonWritableChannelException();
            var15CCC24BBCA9E1CFEF326F26183D5D87_1570211633.addTaint(taint);
            throw var15CCC24BBCA9E1CFEF326F26183D5D87_1570211633;
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_RDONLY) {
            //throw new NonWritableChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.347 -0400", hash_original_method = "906DDDB64CDCD744F2CC12CE5FEEB0F8", hash_generated_method = "6EB05301FCB33E7A57707386F9D29587")
    protected void implCloseChannel() throws IOException {
    if(stream instanceof Closeable)        
        {
            ((Closeable) stream).close();
        } //End block
        // ---------- Original Method ----------
        //if (stream instanceof Closeable) {
            //((Closeable) stream).close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.364 -0400", hash_original_method = "7E2D5FC994D104072ED63DC91E4C8FE1", hash_generated_method = "45FC64394FA5DAED033E277FF18595C8")
    private FileLock basicLock(long position, long size, boolean shared, boolean wait) throws IOException {
        addTaint(wait);
        addTaint(shared);
        addTaint(size);
        addTaint(position);
        int accessMode = (mode & O_ACCMODE);
    if(accessMode == O_RDONLY)        
        {
    if(!shared)            
            {
                NonWritableChannelException var15CCC24BBCA9E1CFEF326F26183D5D87_1371025875 = new NonWritableChannelException();
                var15CCC24BBCA9E1CFEF326F26183D5D87_1371025875.addTaint(taint);
                throw var15CCC24BBCA9E1CFEF326F26183D5D87_1371025875;
            } //End block
        } //End block
        else
    if(accessMode == O_WRONLY)        
        {
    if(shared)            
            {
                NonReadableChannelException var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1738227805 = new NonReadableChannelException();
                var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1738227805.addTaint(taint);
                throw var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1738227805;
            } //End block
        } //End block
    if(position < 0 || size < 0)        
        {
            IllegalArgumentException varA7BF545D69BE95E752F6432B3D51C98F_2093966272 = new IllegalArgumentException("position=" + position + " size=" + size);
            varA7BF545D69BE95E752F6432B3D51C98F_2093966272.addTaint(taint);
            throw varA7BF545D69BE95E752F6432B3D51C98F_2093966272;
        } //End block
        FileLock pendingLock = new FileLockImpl(this, position, size, shared);
        addLock(pendingLock);
        StructFlock flock = new StructFlock();
        flock.l_type = (short) (shared ? F_RDLCK : F_WRLCK);
        flock.l_whence = (short) SEEK_SET;
        flock.l_start = position;
        flock.l_len = translateLockLength(size);
        boolean success = false;
        try 
        {
            success = (Libcore.os.fcntlFlock(fd, wait ? F_SETLKW64 : F_SETLK64, flock) != -1);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_232404416 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_232404416.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_232404416;
        } //End block
        finally 
        {
    if(!success)            
            {
                removeLock(pendingLock);
            } //End block
        } //End block
FileLock var049A21A38D12A7336D7F2DB1250835F9_700653710 =         success ? pendingLock : null;
        var049A21A38D12A7336D7F2DB1250835F9_700653710.addTaint(taint);
        return var049A21A38D12A7336D7F2DB1250835F9_700653710;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static long translateLockLength(long byteCount) {
        return (byteCount == Long.MAX_VALUE) ? 0 : byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.365 -0400", hash_original_method = "2D9781ECA7693E91068070ABFFE1E1EC", hash_generated_method = "C1953DD7DE100BA4B84A3AE67B031A04")
    public final FileLock lock(long position, long size, boolean shared) throws IOException {
        addTaint(shared);
        addTaint(size);
        addTaint(position);
        checkOpen();
        FileLock resultLock = null;
        {
            boolean completed = false;
            try 
            {
                begin();
                resultLock = basicLock(position, size, shared, true);
                completed = true;
            } //End block
            finally 
            {
                end(completed);
            } //End block
        } //End block
FileLock varE16DDA8EC42666DE89700F0F1309BBA6_1607956475 =         resultLock;
        varE16DDA8EC42666DE89700F0F1309BBA6_1607956475.addTaint(taint);
        return varE16DDA8EC42666DE89700F0F1309BBA6_1607956475;
        // ---------- Original Method ----------
        //checkOpen();
        //FileLock resultLock = null;
        //{
            //boolean completed = false;
            //try {
                //begin();
                //resultLock = basicLock(position, size, shared, true);
                //completed = true;
            //} finally {
                //end(completed);
            //}
        //}
        //return resultLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.366 -0400", hash_original_method = "EEB7B11B25906F0628185BB3DA938264", hash_generated_method = "9B8692D87E0357C41DD2E5CE6C500A05")
    public final FileLock tryLock(long position, long size, boolean shared) throws IOException {
        addTaint(shared);
        addTaint(size);
        addTaint(position);
        checkOpen();
FileLock var65AFB6040D93DB11DD2DD18B4F112230_731354049 =         basicLock(position, size, shared, false);
        var65AFB6040D93DB11DD2DD18B4F112230_731354049.addTaint(taint);
        return var65AFB6040D93DB11DD2DD18B4F112230_731354049;
        // ---------- Original Method ----------
        //checkOpen();
        //return basicLock(position, size, shared, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.372 -0400", hash_original_method = "62214805062DB6ECE1A1C9B69D272F36", hash_generated_method = "37D51D83871C431DCDD196AF51C5A59C")
    public void release(FileLock lock) throws IOException {
        addTaint(lock.getTaint());
        checkOpen();
        StructFlock flock = new StructFlock();
        flock.l_type = (short) F_UNLCK;
        flock.l_whence = (short) SEEK_SET;
        flock.l_start = lock.position();
        flock.l_len = translateLockLength(lock.size());
        try 
        {
            Libcore.os.fcntlFlock(fd, F_SETLKW64, flock);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_2113109728 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_2113109728.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_2113109728;
        } //End block
        removeLock(lock);
        // ---------- Original Method ----------
        //checkOpen();
        //StructFlock flock = new StructFlock();
        //flock.l_type = (short) F_UNLCK;
        //flock.l_whence = (short) SEEK_SET;
        //flock.l_start = lock.position();
        //flock.l_len = translateLockLength(lock.size());
        //try {
            //Libcore.os.fcntlFlock(fd, F_SETLKW64, flock);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
        //removeLock(lock);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.385 -0400", hash_original_method = "66F727B932913E59560F8F92301E4A0B", hash_generated_method = "353B814C5B9A14E456E12C86FF2B2F50")
    public void force(boolean metadata) throws IOException {
        addTaint(metadata);
        checkOpen();
    if((mode & O_ACCMODE) != O_RDONLY)        
        {
            try 
            {
    if(metadata)                
                {
                    Libcore.os.fsync(fd);
                } //End block
                else
                {
                    Libcore.os.fdatasync(fd);
                } //End block
            } //End block
            catch (ErrnoException errnoException)
            {
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1413631711 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_1413631711.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_1413631711;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //if ((mode & O_ACCMODE) != O_RDONLY) {
            //try {
                //if (metadata) {
                    //Libcore.os.fsync(fd);
                //} else {
                    //Libcore.os.fdatasync(fd);
                //}
            //} catch (ErrnoException errnoException) {
                //throw errnoException.rethrowAsIOException();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.404 -0400", hash_original_method = "5452C18A8AEE816635F14172EC065A87", hash_generated_method = "1FFBBB3EAC3A6B99752683B338C4412B")
    public final MappedByteBuffer map(MapMode mapMode, long position, long size) throws IOException {
        addTaint(size);
        addTaint(position);
        addTaint(mapMode.getTaint());
        checkOpen();
    if(mapMode == null)        
        {
            NullPointerException var1E9244F8EEBC147307D3B593C8F4EB52_1259306807 = new NullPointerException("mapMode == null");
            var1E9244F8EEBC147307D3B593C8F4EB52_1259306807.addTaint(taint);
            throw var1E9244F8EEBC147307D3B593C8F4EB52_1259306807;
        } //End block
    if(position < 0 || size < 0 || size > Integer.MAX_VALUE)        
        {
            IllegalArgumentException varA7BF545D69BE95E752F6432B3D51C98F_641385701 = new IllegalArgumentException("position=" + position + " size=" + size);
            varA7BF545D69BE95E752F6432B3D51C98F_641385701.addTaint(taint);
            throw varA7BF545D69BE95E752F6432B3D51C98F_641385701;
        } //End block
        int accessMode = (mode & O_ACCMODE);
    if(accessMode == O_RDONLY)        
        {
    if(mapMode != MapMode.READ_ONLY)            
            {
                NonWritableChannelException var15CCC24BBCA9E1CFEF326F26183D5D87_1947820512 = new NonWritableChannelException();
                var15CCC24BBCA9E1CFEF326F26183D5D87_1947820512.addTaint(taint);
                throw var15CCC24BBCA9E1CFEF326F26183D5D87_1947820512;
            } //End block
        } //End block
        else
    if(accessMode == O_WRONLY)        
        {
            NonReadableChannelException var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1839324143 = new NonReadableChannelException();
            var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1839324143.addTaint(taint);
            throw var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1839324143;
        } //End block
    if(position + size > size())        
        {
            try 
            {
                Libcore.os.ftruncate(fd, position + size);
            } //End block
            catch (ErrnoException errnoException)
            {
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_732191323 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_732191323.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_732191323;
            } //End block
        } //End block
        long alignment = position - position % Libcore.os.sysconf(_SC_PAGE_SIZE);
        int offset = (int) (position - alignment);
        MemoryBlock block = MemoryBlock.mmap(fd, alignment, size + offset, mapMode);
MappedByteBuffer var4EBBFE48E7946B1E3B7FC7E668B1DB18_1927321008 =         new MappedByteBufferAdapter(block, (int) size, offset, mapMode);
        var4EBBFE48E7946B1E3B7FC7E668B1DB18_1927321008.addTaint(taint);
        return var4EBBFE48E7946B1E3B7FC7E668B1DB18_1927321008;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.409 -0400", hash_original_method = "2294C6BEF1501D1EBDDF8CC0BA1CBE45", hash_generated_method = "FE8D0C24A5E9C134ECA8B5281C09E1DF")
    public long position() throws IOException {
        checkOpen();
        try 
        {
            long var7BC510F6F7CB14449C552BCB6CAF281B_1276732860 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2003140111 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2003140111;
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_570103502 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_570103502.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_570103502;
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.414 -0400", hash_original_method = "38E87DF17F47600879F85DE74B488325", hash_generated_method = "ADA7A61DCF6D3C5AFEADFD6D0F673289")
    public FileChannel position(long newPosition) throws IOException {
        addTaint(newPosition);
        checkOpen();
    if(newPosition < 0)        
        {
            IllegalArgumentException varDCDBC3E8A498F7C4D6C283675CCE8AB3_1487672092 = new IllegalArgumentException("position: " + newPosition);
            varDCDBC3E8A498F7C4D6C283675CCE8AB3_1487672092.addTaint(taint);
            throw varDCDBC3E8A498F7C4D6C283675CCE8AB3_1487672092;
        } //End block
        try 
        {
            Libcore.os.lseek(fd, newPosition, SEEK_SET);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1747352050 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1747352050.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1747352050;
        } //End block
FileChannel var72A74007B2BE62B849F475C7BDA4658B_154166187 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_154166187.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_154166187;
        // ---------- Original Method ----------
        //checkOpen();
        //if (newPosition < 0) {
            //throw new IllegalArgumentException("position: " + newPosition);
        //}
        //try {
            //Libcore.os.lseek(fd, newPosition, SEEK_SET);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.415 -0400", hash_original_method = "CBC403D41CEC137F7E33592DD6647C43", hash_generated_method = "26DAD9CE592BDDF3376EFA77CFF2C533")
    public int read(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
    if(position < 0)        
        {
            IllegalArgumentException var6116670AA73B0429FDB8C9E658F70CE6_1653905319 = new IllegalArgumentException("position: " + position);
            var6116670AA73B0429FDB8C9E658F70CE6_1653905319.addTaint(taint);
            throw var6116670AA73B0429FDB8C9E658F70CE6_1653905319;
        } //End block
        int varB7AA9A6C39A70493B4F9DDFBDCA0190E_1807286928 = (readImpl(buffer, position));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289530469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289530469;
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return readImpl(buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.415 -0400", hash_original_method = "5BE7BADF8838BD61276F9CD3980F7CA7", hash_generated_method = "F9BDB9ADD3836ABE09E9F2F4CF4DFFA5")
    public int read(ByteBuffer buffer) throws IOException {
        addTaint(buffer.getTaint());
        int var1D00D2835DD568FE7223BE7C062139E4_1523047542 = (readImpl(buffer, -1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159328090 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159328090;
        // ---------- Original Method ----------
        //return readImpl(buffer, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.431 -0400", hash_original_method = "B09A36EC89FDAA97AACE4894ACCEC4C2", hash_generated_method = "FF48E9FC663BBC4F3B959AB011717E9C")
    private int readImpl(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
        buffer.checkWritable();
        checkOpen();
        checkReadable();
    if(!buffer.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1059951131 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459399156 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459399156;
        } //End block
        int bytesRead = 0;
        boolean completed = false;
        try 
        {
            begin();
            try 
            {
    if(position == -1)                
                {
                    bytesRead = Libcore.os.read(fd, buffer);
                } //End block
                else
                {
                    bytesRead = Libcore.os.pread(fd, buffer, position);
                } //End block
    if(bytesRead == 0)                
                {
                    bytesRead = -1;
                } //End block
            } //End block
            catch (ErrnoException errnoException)
            {
    if(errnoException.errno == EAGAIN)                
                {
                    bytesRead = 0;
                } //End block
                else
                {
                    java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_683302934 = errnoException.rethrowAsIOException();
                    var533DBF3F7D78874DC97ED285C3BC3B22_683302934.addTaint(taint);
                    throw var533DBF3F7D78874DC97ED285C3BC3B22_683302934;
                } //End block
            } //End block
            completed = true;
        } //End block
        finally 
        {
            end(completed && bytesRead >= 0);
        } //End block
    if(bytesRead > 0)        
        {
            buffer.position(buffer.position() + bytesRead);
        } //End block
        int varD871906E18D7E876E6494103DA4BEEBD_1193696098 = (bytesRead);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779847841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779847841;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.432 -0400", hash_original_method = "4AF9CF697EB56447960A29F46F724C12", hash_generated_method = "FEAEE3BF498ECD65B6E1194CDD992829")
    private int transferIoVec(IoVec ioVec) throws IOException {
        addTaint(ioVec.getTaint());
    if(ioVec.init() == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_992558233 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345240942 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345240942;
        } //End block
        int bytesTransferred = 0;
        boolean completed = false;
        try 
        {
            begin();
            bytesTransferred = ioVec.doTransfer(fd);
            completed = true;
        } //End block
        finally 
        {
            end(completed);
        } //End block
        ioVec.didTransfer(bytesTransferred);
        int var3CB7FB76A0EEB1CC4DE9CC54B28CCAB8_1898292257 = (bytesTransferred);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52065843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52065843;
        // ---------- Original Method ----------
        //if (ioVec.init() == 0) {
            //return 0;
        //}
        //int bytesTransferred = 0;
        //boolean completed = false;
        //try {
            //begin();
            //bytesTransferred = ioVec.doTransfer(fd);
            //completed = true;
        //} finally {
            //end(completed);
        //}
        //ioVec.didTransfer(bytesTransferred);
        //return bytesTransferred;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.433 -0400", hash_original_method = "C19453CFF2AA37841406A95ED2CF0809", hash_generated_method = "9BE124ED106B7B4CC5B6F26DB6BB89C4")
    public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffers[0].getTaint());
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkReadable();
        long var865979E7AB3B60E0843D300F5C1AE69E_27723585 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV)));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1310705112 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1310705112;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffers.length, offset, length);
        //checkOpen();
        //checkReadable();
        //return transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.438 -0400", hash_original_method = "BF0F3D7AEFAA2AFACA7A21CBB184DE89", hash_generated_method = "876F2D6F0B8868B2A0ADB8D91CF176A3")
    public long size() throws IOException {
        checkOpen();
        try 
        {
            long varE497182731DBBCFBFD01D5C3B5A54B92_1369847155 = (Libcore.os.fstat(fd).st_size);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2066828306 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2066828306;
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_888489619 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_888489619.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_888489619;
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.439 -0400", hash_original_method = "80C3AD203B1B9D1C1064C9E60FE9152A", hash_generated_method = "EDE15E573AECF4ACB329D8D5ABEFB0CF")
    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        addTaint(count);
        addTaint(position);
        addTaint(src.getTaint());
        checkOpen();
    if(!src.isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_178157247 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_178157247.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_178157247;
        } //End block
        checkWritable();
    if(position < 0 || count < 0 || count > Integer.MAX_VALUE)        
        {
            IllegalArgumentException varCC671663C7B1C7D1D6AA9D691A1AECC2_764833489 = new IllegalArgumentException("position=" + position + " count=" + count);
            varCC671663C7B1C7D1D6AA9D691A1AECC2_764833489.addTaint(taint);
            throw varCC671663C7B1C7D1D6AA9D691A1AECC2_764833489;
        } //End block
    if(position > size())        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_21554992 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_351503500 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_351503500;
        } //End block
    if(src instanceof FileChannel)        
        {
            FileChannel fileSrc = (FileChannel) src;
            long size = fileSrc.size();
            long filePosition = fileSrc.position();
            count = Math.min(count, size - filePosition);
            ByteBuffer buffer = fileSrc.map(MapMode.READ_ONLY, filePosition, count);
            try 
            {
                fileSrc.position(filePosition + count);
                long var5777F80E5FF8A0EA8D673AFD2E535293_626389940 = (write(buffer, position));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1404816690 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1404816690;
            } //End block
            finally 
            {
                NioUtils.freeDirectBuffer(buffer);
            } //End block
        } //End block
        ByteBuffer buffer = ByteBuffer.allocate((int) count);
        src.read(buffer);
        buffer.flip();
        long var5777F80E5FF8A0EA8D673AFD2E535293_875239791 = (write(buffer, position));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1979222761 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1979222761;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.459 -0400", hash_original_method = "66697B5A4B32B4AD2132D8B7D53DF0CD", hash_generated_method = "01C2FC0DBC6E5794820F0931191D4843")
    public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        addTaint(target.getTaint());
        addTaint(count);
        addTaint(position);
        checkOpen();
    if(!target.isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_149051206 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_149051206.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_149051206;
        } //End block
        checkReadable();
    if(target instanceof FileChannelImpl)        
        {
            ((FileChannelImpl) target).checkWritable();
        } //End block
    if(position < 0 || count < 0)        
        {
            IllegalArgumentException varCC671663C7B1C7D1D6AA9D691A1AECC2_252758057 = new IllegalArgumentException("position=" + position + " count=" + count);
            varCC671663C7B1C7D1D6AA9D691A1AECC2_252758057.addTaint(taint);
            throw varCC671663C7B1C7D1D6AA9D691A1AECC2_252758057;
        } //End block
    if(count == 0 || position >= size())        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1346033400 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_879312534 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_879312534;
        } //End block
        count = Math.min(count, size() - position);
        boolean completed = false;
    if(target instanceof SocketChannelImpl)        
        {
            FileDescriptor outFd = ((SocketChannelImpl) target).getFD();
            try 
            {
                begin();
                try 
                {
                    MutableLong offset = new MutableLong(position);
                    long rc = Libcore.os.sendfile(outFd, fd, offset, count);
                    completed = true;
                    long varFF78648BE52A4E79513F4E70B266C62A_257471438 = (rc);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_672380875 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_672380875;
                } //End block
                catch (ErrnoException errnoException)
                {
    if(errnoException.errno != ENOSYS && errnoException.errno != EINVAL)                    
                    {
                        java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_159122745 = errnoException.rethrowAsIOException();
                        var533DBF3F7D78874DC97ED285C3BC3B22_159122745.addTaint(taint);
                        throw var533DBF3F7D78874DC97ED285C3BC3B22_159122745;
                    } //End block
                } //End block
            } //End block
            finally 
            {
                end(completed);
            } //End block
        } //End block
        ByteBuffer buffer = null;
        try 
        {
            buffer = map(MapMode.READ_ONLY, position, count);
            long varD3B96EE17DC3534845E4FB68676CB62D_1099410022 = (target.write(buffer));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_859080895 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_859080895;
        } //End block
        finally 
        {
            NioUtils.freeDirectBuffer(buffer);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.470 -0400", hash_original_method = "062BFFD7E484D8312E945E8E43437F48", hash_generated_method = "1DAE3FE049D398E7F8A9B895069F1832")
    public FileChannel truncate(long size) throws IOException {
        addTaint(size);
        checkOpen();
    if(size < 0)        
        {
            IllegalArgumentException var20154F838DC7F2C22FC90A835CD4F108_1305029093 = new IllegalArgumentException("size: " + size);
            var20154F838DC7F2C22FC90A835CD4F108_1305029093.addTaint(taint);
            throw var20154F838DC7F2C22FC90A835CD4F108_1305029093;
        } //End block
        checkWritable();
    if(size < size())        
        {
            try 
            {
                Libcore.os.ftruncate(fd, size);
            } //End block
            catch (ErrnoException errnoException)
            {
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_113686582 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_113686582.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_113686582;
            } //End block
        } //End block
FileChannel var72A74007B2BE62B849F475C7BDA4658B_1876276793 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1876276793.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1876276793;
        // ---------- Original Method ----------
        //checkOpen();
        //if (size < 0) {
            //throw new IllegalArgumentException("size: " + size);
        //}
        //checkWritable();
        //if (size < size()) {
            //try {
                //Libcore.os.ftruncate(fd, size);
            //} catch (ErrnoException errnoException) {
                //throw errnoException.rethrowAsIOException();
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.471 -0400", hash_original_method = "D694A533B6DF57B5FA961A08FD2C2C8C", hash_generated_method = "708A8F84E6343B7AE6C79F77CAB517C5")
    public int write(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
    if(position < 0)        
        {
            IllegalArgumentException var6116670AA73B0429FDB8C9E658F70CE6_355563545 = new IllegalArgumentException("position: " + position);
            var6116670AA73B0429FDB8C9E658F70CE6_355563545.addTaint(taint);
            throw var6116670AA73B0429FDB8C9E658F70CE6_355563545;
        } //End block
        int var073BB21C1CCA02EF8918FBD1E5A22510_1365071308 = (writeImpl(buffer, position));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818534746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818534746;
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return writeImpl(buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.471 -0400", hash_original_method = "50D91170AD5AAA80BF5888A2631505BE", hash_generated_method = "703DB3A7C405A4D8EB9C68301C9C9B4D")
    public int write(ByteBuffer buffer) throws IOException {
        addTaint(buffer.getTaint());
        int var858811FB21BD232E6AC0BEA84831881E_1085106757 = (writeImpl(buffer, -1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327452894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327452894;
        // ---------- Original Method ----------
        //return writeImpl(buffer, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.484 -0400", hash_original_method = "B7C7E18920DBBA232C5F1428FFA4A3EB", hash_generated_method = "B33BA536D5E6BA85976D87F1FD3A9A54")
    private int writeImpl(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
        checkOpen();
        checkWritable();
    if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_299275131 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_299275131.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_299275131;
        } //End block
    if(!buffer.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_605101314 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977828717 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977828717;
        } //End block
        int bytesWritten = 0;
        boolean completed = false;
        try 
        {
            begin();
            try 
            {
    if(position == -1)                
                {
                    bytesWritten = Libcore.os.write(fd, buffer);
                } //End block
                else
                {
                    bytesWritten = Libcore.os.pwrite(fd, buffer, position);
                } //End block
            } //End block
            catch (ErrnoException errnoException)
            {
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_2059884746 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_2059884746.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_2059884746;
            } //End block
            completed = true;
        } //End block
        finally 
        {
            end(completed);
        } //End block
    if(bytesWritten > 0)        
        {
            buffer.position(buffer.position() + bytesWritten);
        } //End block
        int varAE887C29C29F5CA22060DCB00E0FB057_1851905403 = (bytesWritten);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651503545 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651503545;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.485 -0400", hash_original_method = "066AEC24C5D5FCB3A90F301EFD66C198", hash_generated_method = "46412568CDF1B3A8C2380D3ECDDE92C0")
    public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffers[0].getTaint());
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkWritable();
        long var6EE2D1EA75CCFC01E2882598D1F8AF78_711539906 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.WRITEV)));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1167438022 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1167438022;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffers.length, offset, length);
        //checkOpen();
        //checkWritable();
        //return transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.WRITEV));
    }

    
        static int calculateTotalRemaining(ByteBuffer[] buffers, int offset, int length, boolean copyingIn) {
        int count = 0;
        for (int i = offset; i < offset + length; ++i) {
            count += buffers[i].remaining();
            if (copyingIn) {
                buffers[i].checkWritable();
            }
        }
        return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.486 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "42D83A2A3DD4C15D5CA4E4012CA6889D")
    public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1126675568 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_1126675568.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_1126675568;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.487 -0400", hash_original_method = "F902144182B3E2AF28D0016B48F7903B", hash_generated_method = "6748B72EF67C614DB54A8C992AB922A5")
    private synchronized void addLock(FileLock lock) throws OverlappingFileLockException {
        addTaint(lock.getTaint());
        long lockEnd = lock.position() + lock.size();
for(FileLock existingLock : locks)
        {
    if(existingLock.position() > lockEnd)            
            {
                break;
            } //End block
    if(existingLock.overlaps(lock.position(), lock.size()))            
            {
                OverlappingFileLockException varBBCC2444149A97B60460B69FEA70806D_1330427635 = new OverlappingFileLockException();
                varBBCC2444149A97B60460B69FEA70806D_1330427635.addTaint(taint);
                throw varBBCC2444149A97B60460B69FEA70806D_1330427635;
            } //End block
        } //End block
        locks.add(lock);
        // ---------- Original Method ----------
        //long lockEnd = lock.position() + lock.size();
        //for (FileLock existingLock : locks) {
            //if (existingLock.position() > lockEnd) {
                //break;
            //}
            //if (existingLock.overlaps(lock.position(), lock.size())) {
                //throw new OverlappingFileLockException();
            //}
        //}
        //locks.add(lock);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.487 -0400", hash_original_method = "AE9E3F40D0EE8D3948C9955DBE0083E8", hash_generated_method = "89395557843AF8F624E2E77B4F1639FE")
    private synchronized void removeLock(FileLock lock) {
        addTaint(lock.getTaint());
        locks.remove(lock);
        // ---------- Original Method ----------
        //locks.remove(lock);
    }

    
    private static final class FileLockImpl extends FileLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.487 -0400", hash_original_field = "54A67E24EC9ED4A409BC3E533D36FB19", hash_generated_field = "4E02554B0BEBB8127D76AE5D5E6B5FAD")

        private boolean isReleased = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.488 -0400", hash_original_method = "DBB23F8476AE80F00EB4C7CF229EA4B9", hash_generated_method = "70C66EA4F38E83A5CFA92D920F720393")
        public  FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
            super(channel, position, size, shared);
            addTaint(shared);
            addTaint(size);
            addTaint(position);
            addTaint(channel.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.488 -0400", hash_original_method = "AAE954E5885EFA2B8D6D7679145B1DEF", hash_generated_method = "4652F894A690F9444F922E6329268D3E")
        public boolean isValid() {
            boolean var51F46452F2C2981ED17B7318FDFFA3F5_480221059 = (!isReleased && channel().isOpen());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_906271527 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_906271527;
            // ---------- Original Method ----------
            //return !isReleased && channel().isOpen();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.488 -0400", hash_original_method = "7DF971FEA31B34CE257DD1638735950E", hash_generated_method = "980978D564AF623D0E7EE0294F3218BA")
        public void release() throws IOException {
    if(!channel().isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1522242649 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_1522242649.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1522242649;
            } //End block
    if(!isReleased)            
            {
                ((FileChannelImpl) channel()).release(this);
                isReleased = true;
            } //End block
            // ---------- Original Method ----------
            //if (!channel().isOpen()) {
                //throw new ClosedChannelException();
            //}
            //if (!isReleased) {
                //((FileChannelImpl) channel()).release(this);
                //isReleased = true;
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.298 -0400", hash_original_field = "214EF2C30F414C8FDB98024F4777CF3E", hash_generated_field = "B942C76CBADD07E46C36C598F3CE8A93")

    private static final Comparator<FileLock> LOCK_COMPARATOR = new Comparator<FileLock>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.298 -0400", hash_original_method = "BAD31C1963B2F965BA94839291F4C17C", hash_generated_method = "09544778190497FCE22242F527472A85")
        public int compare(FileLock lock1, FileLock lock2) {
            long position1 = lock1.position();
            long position2 = lock2.position();
            addTaint(lock1.getTaint());
            addTaint(lock2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230991941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230991941;
            
            
            
            
        }

        
};
}

