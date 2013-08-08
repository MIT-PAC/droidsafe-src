package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.EAGAIN;
import static libcore.io.OsConstants.EINVAL;
import static libcore.io.OsConstants.ENOSYS;
import static libcore.io.OsConstants.F_RDLCK;
import static libcore.io.OsConstants.F_SETLK64;
import static libcore.io.OsConstants.F_SETLKW64;
import static libcore.io.OsConstants.F_UNLCK;
import static libcore.io.OsConstants.F_WRLCK;
import static libcore.io.OsConstants.O_ACCMODE;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.O_WRONLY;
import static libcore.io.OsConstants.SEEK_CUR;
import static libcore.io.OsConstants.SEEK_SET;
import static libcore.io.OsConstants._SC_PAGE_SIZE;

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
import libcore.io.Libcore;
import libcore.io.StructFlock;
import libcore.util.MutableLong;





final class FileChannelImpl extends FileChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.717 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "6DF85966286B5A79BC125BD24D7FC97F")

    private Object stream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.717 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.717 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.717 -0400", hash_original_field = "6534500F3CBE19A8D61109391469B658", hash_generated_field = "41CABECFE29C1BC14C56B2F0C987CEF1")

    private final SortedSet<FileLock> locks = new TreeSet<FileLock>(LOCK_COMPARATOR);
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.717 -0400", hash_original_method = "2735A1029D285B5D3DE10DB0E230E666", hash_generated_method = "F6F44BF98254D27848329B7C58999156")
    public  FileChannelImpl(Object stream, FileDescriptor fd, int mode) {
        this.fd = fd;
        this.stream = stream;
        this.mode = mode;
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.stream = stream;
        //this.mode = mode;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.718 -0400", hash_original_method = "6E6D3E88914C52E71D3EAF93EC51DF72", hash_generated_method = "0D7F97E60BF6E6A0A21E47C571C2F41D")
    private void checkOpen() throws ClosedChannelException {
        if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_429070106 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_429070106.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_429070106;
        } //End block
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.718 -0400", hash_original_method = "48C6D0CA0A11D20CF44BD79CC21BDD35", hash_generated_method = "0980FE734D235194CA03944D40240997")
    private void checkReadable() {
        if((mode & O_ACCMODE) == O_WRONLY)        
        {
            NonReadableChannelException var0514EC2D1DF01A7C0FEA2CC12F9B10D5_818451141 = new NonReadableChannelException();
            var0514EC2D1DF01A7C0FEA2CC12F9B10D5_818451141.addTaint(taint);
            throw var0514EC2D1DF01A7C0FEA2CC12F9B10D5_818451141;
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_WRONLY) {
            //throw new NonReadableChannelException();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.719 -0400", hash_original_method = "B5384AE1DC067BB9B7371F695174CE9F", hash_generated_method = "0DE8AEFAC0E498417518C26A82283D08")
    private void checkWritable() {
        if((mode & O_ACCMODE) == O_RDONLY)        
        {
            NonWritableChannelException var15CCC24BBCA9E1CFEF326F26183D5D87_1267418274 = new NonWritableChannelException();
            var15CCC24BBCA9E1CFEF326F26183D5D87_1267418274.addTaint(taint);
            throw var15CCC24BBCA9E1CFEF326F26183D5D87_1267418274;
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_RDONLY) {
            //throw new NonWritableChannelException();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.719 -0400", hash_original_method = "906DDDB64CDCD744F2CC12CE5FEEB0F8", hash_generated_method = "6EB05301FCB33E7A57707386F9D29587")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.743 -0400", hash_original_method = "7E2D5FC994D104072ED63DC91E4C8FE1", hash_generated_method = "479266149936620AC722BC83B00A0873")
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
                NonWritableChannelException var15CCC24BBCA9E1CFEF326F26183D5D87_1991434143 = new NonWritableChannelException();
                var15CCC24BBCA9E1CFEF326F26183D5D87_1991434143.addTaint(taint);
                throw var15CCC24BBCA9E1CFEF326F26183D5D87_1991434143;
            } //End block
        } //End block
        else
        if(accessMode == O_WRONLY)        
        {
            if(shared)            
            {
                NonReadableChannelException var0514EC2D1DF01A7C0FEA2CC12F9B10D5_162345958 = new NonReadableChannelException();
                var0514EC2D1DF01A7C0FEA2CC12F9B10D5_162345958.addTaint(taint);
                throw var0514EC2D1DF01A7C0FEA2CC12F9B10D5_162345958;
            } //End block
        } //End block
        if(position < 0 || size < 0)        
        {
            IllegalArgumentException varA7BF545D69BE95E752F6432B3D51C98F_328210296 = new IllegalArgumentException("position=" + position + " size=" + size);
            varA7BF545D69BE95E752F6432B3D51C98F_328210296.addTaint(taint);
            throw varA7BF545D69BE95E752F6432B3D51C98F_328210296;
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
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_2135244781 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_2135244781.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_2135244781;
        } //End block
        finally 
        {
            if(!success)            
            {
                removeLock(pendingLock);
            } //End block
        } //End block
FileLock var049A21A38D12A7336D7F2DB1250835F9_1067829065 =         success ? pendingLock : null;
        var049A21A38D12A7336D7F2DB1250835F9_1067829065.addTaint(taint);
        return var049A21A38D12A7336D7F2DB1250835F9_1067829065;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static long translateLockLength(long byteCount) {
        return (byteCount == Long.MAX_VALUE) ? 0 : byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.745 -0400", hash_original_method = "2D9781ECA7693E91068070ABFFE1E1EC", hash_generated_method = "7A179B2ED2F87B17ABB93B7340B1CB2C")
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
FileLock varE16DDA8EC42666DE89700F0F1309BBA6_1204898008 =         resultLock;
        varE16DDA8EC42666DE89700F0F1309BBA6_1204898008.addTaint(taint);
        return varE16DDA8EC42666DE89700F0F1309BBA6_1204898008;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.746 -0400", hash_original_method = "EEB7B11B25906F0628185BB3DA938264", hash_generated_method = "9EFE36D9C13E83E5186D2D9598EAD655")
    public final FileLock tryLock(long position, long size, boolean shared) throws IOException {
        addTaint(shared);
        addTaint(size);
        addTaint(position);
        checkOpen();
FileLock var65AFB6040D93DB11DD2DD18B4F112230_1594879659 =         basicLock(position, size, shared, false);
        var65AFB6040D93DB11DD2DD18B4F112230_1594879659.addTaint(taint);
        return var65AFB6040D93DB11DD2DD18B4F112230_1594879659;
        // ---------- Original Method ----------
        //checkOpen();
        //return basicLock(position, size, shared, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.754 -0400", hash_original_method = "62214805062DB6ECE1A1C9B69D272F36", hash_generated_method = "BF1A9BD8AFDC3721CAA208BD4151B9C4")
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
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1095319587 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1095319587.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1095319587;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.761 -0400", hash_original_method = "66F727B932913E59560F8F92301E4A0B", hash_generated_method = "B081E061EE54D1873EFA179B83C3F8B5")
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
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1477346553 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_1477346553.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_1477346553;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.782 -0400", hash_original_method = "5452C18A8AEE816635F14172EC065A87", hash_generated_method = "ACB2E77DC927ACDC24325E27A67144A2")
    public final MappedByteBuffer map(MapMode mapMode, long position, long size) throws IOException {
        addTaint(size);
        addTaint(position);
        addTaint(mapMode.getTaint());
        checkOpen();
        if(mapMode == null)        
        {
            NullPointerException var1E9244F8EEBC147307D3B593C8F4EB52_1262189641 = new NullPointerException("mapMode == null");
            var1E9244F8EEBC147307D3B593C8F4EB52_1262189641.addTaint(taint);
            throw var1E9244F8EEBC147307D3B593C8F4EB52_1262189641;
        } //End block
        if(position < 0 || size < 0 || size > Integer.MAX_VALUE)        
        {
            IllegalArgumentException varA7BF545D69BE95E752F6432B3D51C98F_61393239 = new IllegalArgumentException("position=" + position + " size=" + size);
            varA7BF545D69BE95E752F6432B3D51C98F_61393239.addTaint(taint);
            throw varA7BF545D69BE95E752F6432B3D51C98F_61393239;
        } //End block
        int accessMode = (mode & O_ACCMODE);
        if(accessMode == O_RDONLY)        
        {
            if(mapMode != MapMode.READ_ONLY)            
            {
                NonWritableChannelException var15CCC24BBCA9E1CFEF326F26183D5D87_528802188 = new NonWritableChannelException();
                var15CCC24BBCA9E1CFEF326F26183D5D87_528802188.addTaint(taint);
                throw var15CCC24BBCA9E1CFEF326F26183D5D87_528802188;
            } //End block
        } //End block
        else
        if(accessMode == O_WRONLY)        
        {
            NonReadableChannelException var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1372603539 = new NonReadableChannelException();
            var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1372603539.addTaint(taint);
            throw var0514EC2D1DF01A7C0FEA2CC12F9B10D5_1372603539;
        } //End block
        if(position + size > size())        
        {
            try 
            {
                Libcore.os.ftruncate(fd, position + size);
            } //End block
            catch (ErrnoException errnoException)
            {
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_86534857 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_86534857.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_86534857;
            } //End block
        } //End block
        long alignment = position - position % Libcore.os.sysconf(_SC_PAGE_SIZE);
        int offset = (int) (position - alignment);
        MemoryBlock block = MemoryBlock.mmap(fd, alignment, size + offset, mapMode);
MappedByteBuffer var4EBBFE48E7946B1E3B7FC7E668B1DB18_2009894487 =         new MappedByteBufferAdapter(block, (int) size, offset, mapMode);
        var4EBBFE48E7946B1E3B7FC7E668B1DB18_2009894487.addTaint(taint);
        return var4EBBFE48E7946B1E3B7FC7E668B1DB18_2009894487;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.791 -0400", hash_original_method = "2294C6BEF1501D1EBDDF8CC0BA1CBE45", hash_generated_method = "CFADCA10DC4559B81020430898ED2BB7")
    public long position() throws IOException {
        checkOpen();
        try 
        {
            long var7BC510F6F7CB14449C552BCB6CAF281B_341371826 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_719019986 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_719019986;
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_919056349 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_919056349.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_919056349;
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.804 -0400", hash_original_method = "38E87DF17F47600879F85DE74B488325", hash_generated_method = "3211136606ED7A6794F43698531A8E83")
    public FileChannel position(long newPosition) throws IOException {
        addTaint(newPosition);
        checkOpen();
        if(newPosition < 0)        
        {
            IllegalArgumentException varDCDBC3E8A498F7C4D6C283675CCE8AB3_54311975 = new IllegalArgumentException("position: " + newPosition);
            varDCDBC3E8A498F7C4D6C283675CCE8AB3_54311975.addTaint(taint);
            throw varDCDBC3E8A498F7C4D6C283675CCE8AB3_54311975;
        } //End block
        try 
        {
            Libcore.os.lseek(fd, newPosition, SEEK_SET);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_814667920 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_814667920.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_814667920;
        } //End block
FileChannel var72A74007B2BE62B849F475C7BDA4658B_1620352505 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1620352505.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1620352505;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.806 -0400", hash_original_method = "CBC403D41CEC137F7E33592DD6647C43", hash_generated_method = "51A3929A3556F24B3D9704922EF7C778")
    public int read(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
        if(position < 0)        
        {
            IllegalArgumentException var6116670AA73B0429FDB8C9E658F70CE6_1223579628 = new IllegalArgumentException("position: " + position);
            var6116670AA73B0429FDB8C9E658F70CE6_1223579628.addTaint(taint);
            throw var6116670AA73B0429FDB8C9E658F70CE6_1223579628;
        } //End block
        int varB7AA9A6C39A70493B4F9DDFBDCA0190E_697467658 = (readImpl(buffer, position));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801425053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801425053;
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return readImpl(buffer, position);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.806 -0400", hash_original_method = "5BE7BADF8838BD61276F9CD3980F7CA7", hash_generated_method = "288BF19C9C6B43DBE4A85D4DD0963929")
    public int read(ByteBuffer buffer) throws IOException {
        addTaint(buffer.getTaint());
        int var1D00D2835DD568FE7223BE7C062139E4_859992106 = (readImpl(buffer, -1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768734323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768734323;
        // ---------- Original Method ----------
        //return readImpl(buffer, -1);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.831 -0400", hash_original_method = "B09A36EC89FDAA97AACE4894ACCEC4C2", hash_generated_method = "73E96C143967799820FFFB0F0E53D029")
    private int readImpl(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
        buffer.checkWritable();
        checkOpen();
        checkReadable();
        if(!buffer.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1479211016 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730240024 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730240024;
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
                    java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1167126514 = errnoException.rethrowAsIOException();
                    var533DBF3F7D78874DC97ED285C3BC3B22_1167126514.addTaint(taint);
                    throw var533DBF3F7D78874DC97ED285C3BC3B22_1167126514;
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
        int varD871906E18D7E876E6494103DA4BEEBD_654223146 = (bytesRead);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065686967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1065686967;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.832 -0400", hash_original_method = "4AF9CF697EB56447960A29F46F724C12", hash_generated_method = "19C94A956AE5997EA3D93A0EAA8C0217")
    private int transferIoVec(IoVec ioVec) throws IOException {
        addTaint(ioVec.getTaint());
        if(ioVec.init() == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_197034634 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489926480 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489926480;
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
        int var3CB7FB76A0EEB1CC4DE9CC54B28CCAB8_1773145694 = (bytesTransferred);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064425802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064425802;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.833 -0400", hash_original_method = "C19453CFF2AA37841406A95ED2CF0809", hash_generated_method = "1DA78A78C2826A427A3FBD2BF3EE9B98")
    public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffers[0].getTaint());
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkReadable();
        long var865979E7AB3B60E0843D300F5C1AE69E_1213180939 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV)));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1753905531 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1753905531;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffers.length, offset, length);
        //checkOpen();
        //checkReadable();
        //return transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.848 -0400", hash_original_method = "BF0F3D7AEFAA2AFACA7A21CBB184DE89", hash_generated_method = "62C110368A464477F27B26F0923AA0A2")
    public long size() throws IOException {
        checkOpen();
        try 
        {
            long varE497182731DBBCFBFD01D5C3B5A54B92_1543055177 = (Libcore.os.fstat(fd).st_size);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_639668228 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_639668228;
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1446505432 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1446505432.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1446505432;
        } //End block
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.849 -0400", hash_original_method = "80C3AD203B1B9D1C1064C9E60FE9152A", hash_generated_method = "026BC26C45D75F32A9B42E31F010AC75")
    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        addTaint(count);
        addTaint(position);
        addTaint(src.getTaint());
        checkOpen();
        if(!src.isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1516464572 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1516464572.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1516464572;
        } //End block
        checkWritable();
        if(position < 0 || count < 0 || count > Integer.MAX_VALUE)        
        {
            IllegalArgumentException varCC671663C7B1C7D1D6AA9D691A1AECC2_202088733 = new IllegalArgumentException("position=" + position + " count=" + count);
            varCC671663C7B1C7D1D6AA9D691A1AECC2_202088733.addTaint(taint);
            throw varCC671663C7B1C7D1D6AA9D691A1AECC2_202088733;
        } //End block
        if(position > size())        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1327392332 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1618357947 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1618357947;
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
                long var5777F80E5FF8A0EA8D673AFD2E535293_1930049772 = (write(buffer, position));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_243846649 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_243846649;
            } //End block
            finally 
            {
                NioUtils.freeDirectBuffer(buffer);
            } //End block
        } //End block
        ByteBuffer buffer = ByteBuffer.allocate((int) count);
        src.read(buffer);
        buffer.flip();
        long var5777F80E5FF8A0EA8D673AFD2E535293_1310986876 = (write(buffer, position));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1638006176 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1638006176;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.872 -0400", hash_original_method = "66697B5A4B32B4AD2132D8B7D53DF0CD", hash_generated_method = "CA7E1B62E80010BC3B868E8D0C8FD751")
    public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        addTaint(target.getTaint());
        addTaint(count);
        addTaint(position);
        checkOpen();
        if(!target.isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1259427890 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_1259427890.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1259427890;
        } //End block
        checkReadable();
        if(target instanceof FileChannelImpl)        
        {
            ((FileChannelImpl) target).checkWritable();
        } //End block
        if(position < 0 || count < 0)        
        {
            IllegalArgumentException varCC671663C7B1C7D1D6AA9D691A1AECC2_1783530590 = new IllegalArgumentException("position=" + position + " count=" + count);
            varCC671663C7B1C7D1D6AA9D691A1AECC2_1783530590.addTaint(taint);
            throw varCC671663C7B1C7D1D6AA9D691A1AECC2_1783530590;
        } //End block
        if(count == 0 || position >= size())        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1785150125 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_5105255 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_5105255;
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
                    long varFF78648BE52A4E79513F4E70B266C62A_338733460 = (rc);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2022366064 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_2022366064;
                } //End block
                catch (ErrnoException errnoException)
                {
                    if(errnoException.errno != ENOSYS && errnoException.errno != EINVAL)                    
                    {
                        java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1916322329 = errnoException.rethrowAsIOException();
                        var533DBF3F7D78874DC97ED285C3BC3B22_1916322329.addTaint(taint);
                        throw var533DBF3F7D78874DC97ED285C3BC3B22_1916322329;
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
            long varD3B96EE17DC3534845E4FB68676CB62D_1127767188 = (target.write(buffer));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1922682200 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1922682200;
        } //End block
        finally 
        {
            NioUtils.freeDirectBuffer(buffer);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.882 -0400", hash_original_method = "062BFFD7E484D8312E945E8E43437F48", hash_generated_method = "7896C88A96333FFB486F7508B73A49F6")
    public FileChannel truncate(long size) throws IOException {
        addTaint(size);
        checkOpen();
        if(size < 0)        
        {
            IllegalArgumentException var20154F838DC7F2C22FC90A835CD4F108_2126827134 = new IllegalArgumentException("size: " + size);
            var20154F838DC7F2C22FC90A835CD4F108_2126827134.addTaint(taint);
            throw var20154F838DC7F2C22FC90A835CD4F108_2126827134;
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
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1976227078 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_1976227078.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_1976227078;
            } //End block
        } //End block
FileChannel var72A74007B2BE62B849F475C7BDA4658B_1031436473 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1031436473.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1031436473;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.883 -0400", hash_original_method = "D694A533B6DF57B5FA961A08FD2C2C8C", hash_generated_method = "82FE3EC1290DB6BDDC88F9A790436025")
    public int write(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
        if(position < 0)        
        {
            IllegalArgumentException var6116670AA73B0429FDB8C9E658F70CE6_1238847576 = new IllegalArgumentException("position: " + position);
            var6116670AA73B0429FDB8C9E658F70CE6_1238847576.addTaint(taint);
            throw var6116670AA73B0429FDB8C9E658F70CE6_1238847576;
        } //End block
        int var073BB21C1CCA02EF8918FBD1E5A22510_155597392 = (writeImpl(buffer, position));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186182172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186182172;
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return writeImpl(buffer, position);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.884 -0400", hash_original_method = "50D91170AD5AAA80BF5888A2631505BE", hash_generated_method = "507C35A9E1E5CF79054DF229FF93CF7B")
    public int write(ByteBuffer buffer) throws IOException {
        addTaint(buffer.getTaint());
        int var858811FB21BD232E6AC0BEA84831881E_247741788 = (writeImpl(buffer, -1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643066033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643066033;
        // ---------- Original Method ----------
        //return writeImpl(buffer, -1);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.926 -0400", hash_original_method = "B7C7E18920DBBA232C5F1428FFA4A3EB", hash_generated_method = "A832C54A4E09C5F8838E86FBE1003426")
    private int writeImpl(ByteBuffer buffer, long position) throws IOException {
        addTaint(position);
        addTaint(buffer.getTaint());
        checkOpen();
        checkWritable();
        if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_213467399 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_213467399.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_213467399;
        } //End block
        if(!buffer.hasRemaining())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1957604109 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228468808 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1228468808;
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
                java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1497082657 = errnoException.rethrowAsIOException();
                var533DBF3F7D78874DC97ED285C3BC3B22_1497082657.addTaint(taint);
                throw var533DBF3F7D78874DC97ED285C3BC3B22_1497082657;
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
        int varAE887C29C29F5CA22060DCB00E0FB057_1690483398 = (bytesWritten);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315746316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315746316;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.931 -0400", hash_original_method = "066AEC24C5D5FCB3A90F301EFD66C198", hash_generated_method = "D81FA7EB5AA27AC80030DE5A7312C72E")
    public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffers[0].getTaint());
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkWritable();
        long var6EE2D1EA75CCFC01E2882598D1F8AF78_1998695572 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.WRITEV)));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1241964012 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1241964012;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.936 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "67C03669644FCF3D671426E216BB934B")
    public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_2091354658 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_2091354658.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_2091354658;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.936 -0400", hash_original_method = "F902144182B3E2AF28D0016B48F7903B", hash_generated_method = "88F2E43FA9CF8352726F6AA181CAFD75")
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
                OverlappingFileLockException varBBCC2444149A97B60460B69FEA70806D_143024632 = new OverlappingFileLockException();
                varBBCC2444149A97B60460B69FEA70806D_143024632.addTaint(taint);
                throw varBBCC2444149A97B60460B69FEA70806D_143024632;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.941 -0400", hash_original_method = "AE9E3F40D0EE8D3948C9955DBE0083E8", hash_generated_method = "89395557843AF8F624E2E77B4F1639FE")
    private synchronized void removeLock(FileLock lock) {
        addTaint(lock.getTaint());
        locks.remove(lock);
        // ---------- Original Method ----------
        //locks.remove(lock);
    }

    
    private static final class FileLockImpl extends FileLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.944 -0400", hash_original_field = "54A67E24EC9ED4A409BC3E533D36FB19", hash_generated_field = "4E02554B0BEBB8127D76AE5D5E6B5FAD")

        private boolean isReleased = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.944 -0400", hash_original_method = "DBB23F8476AE80F00EB4C7CF229EA4B9", hash_generated_method = "70C66EA4F38E83A5CFA92D920F720393")
        public  FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
            super(channel, position, size, shared);
            addTaint(shared);
            addTaint(size);
            addTaint(position);
            addTaint(channel.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.949 -0400", hash_original_method = "AAE954E5885EFA2B8D6D7679145B1DEF", hash_generated_method = "2CDA7E909247EE34861B805F5EC75935")
        public boolean isValid() {
            boolean var51F46452F2C2981ED17B7318FDFFA3F5_1634387947 = (!isReleased && channel().isOpen());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993889031 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_993889031;
            // ---------- Original Method ----------
            //return !isReleased && channel().isOpen();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.951 -0400", hash_original_method = "7DF971FEA31B34CE257DD1638735950E", hash_generated_method = "983F3C3A7B8D5DE9543913D483F99E4E")
        public void release() throws IOException {
            if(!channel().isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1288112523 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_1288112523.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1288112523;
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

