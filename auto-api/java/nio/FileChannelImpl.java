package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.600 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "6DF85966286B5A79BC125BD24D7FC97F")

    private Object stream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.600 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.600 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.600 -0400", hash_original_field = "6534500F3CBE19A8D61109391469B658", hash_generated_field = "C638AA4272113BB7504205818C055229")

    private SortedSet<FileLock> locks = new TreeSet<FileLock>(LOCK_COMPARATOR);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.600 -0400", hash_original_method = "2735A1029D285B5D3DE10DB0E230E666", hash_generated_method = "F6F44BF98254D27848329B7C58999156")
    public  FileChannelImpl(Object stream, FileDescriptor fd, int mode) {
        this.fd = fd;
        this.stream = stream;
        this.mode = mode;
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.stream = stream;
        //this.mode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.610 -0400", hash_original_method = "6E6D3E88914C52E71D3EAF93EC51DF72", hash_generated_method = "8020C7A66E8A98784EFCB78527E67AE8")
    private void checkOpen() throws ClosedChannelException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1057124461 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.617 -0400", hash_original_method = "48C6D0CA0A11D20CF44BD79CC21BDD35", hash_generated_method = "9FD441856307A26D07CEC64A4C68174B")
    private void checkReadable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NonReadableChannelException();
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_WRONLY) {
            //throw new NonReadableChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.618 -0400", hash_original_method = "B5384AE1DC067BB9B7371F695174CE9F", hash_generated_method = "23A7CC7E90B45014537B712989CB83D0")
    private void checkWritable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NonWritableChannelException();
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_RDONLY) {
            //throw new NonWritableChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.618 -0400", hash_original_method = "906DDDB64CDCD744F2CC12CE5FEEB0F8", hash_generated_method = "44E5E9D76C63AC678003B5513904037A")
    protected void implCloseChannel() throws IOException {
        {
            ((Closeable) stream).close();
        } //End block
        // ---------- Original Method ----------
        //if (stream instanceof Closeable) {
            //((Closeable) stream).close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.619 -0400", hash_original_method = "7E2D5FC994D104072ED63DC91E4C8FE1", hash_generated_method = "3259442676B2414990800CDA2CA820F1")
    private FileLock basicLock(long position, long size, boolean shared, boolean wait) throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_969982429 = null; //Variable for return #1
        int accessMode;
        accessMode = (mode & O_ACCMODE);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NonWritableChannelException();
            } //End block
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NonReadableChannelException();
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " size=" + size);
        } //End block
        FileLock pendingLock;
        pendingLock = new FileLockImpl(this, position, size, shared);
        addLock(pendingLock);
        StructFlock flock;
        flock = new StructFlock();
        flock.l_type = (short) (shared ? F_RDLCK : F_WRLCK);
        flock.l_whence = (short) SEEK_SET;
        flock.l_start = position;
        flock.l_len = translateLockLength(size);
        boolean success;
        success = false;
        try 
        {
            success = (Libcore.os.fcntlFlock(fd, wait ? F_SETLKW64 : F_SETLK64, flock) != -1);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        finally 
        {
            {
                removeLock(pendingLock);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_969982429 = success ? pendingLock : null;
        addTaint(position);
        addTaint(size);
        addTaint(shared);
        addTaint(wait);
        varB4EAC82CA7396A68D541C85D26508E83_969982429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_969982429;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static long translateLockLength(long byteCount) {
        return (byteCount == Long.MAX_VALUE) ? 0 : byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.634 -0400", hash_original_method = "2D9781ECA7693E91068070ABFFE1E1EC", hash_generated_method = "0BE2343CA59BE59BD95E77CE46CAE312")
    public final FileLock lock(long position, long size, boolean shared) throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_873059040 = null; //Variable for return #1
        checkOpen();
        FileLock resultLock;
        resultLock = null;
        {
            boolean completed;
            completed = false;
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
        varB4EAC82CA7396A68D541C85D26508E83_873059040 = resultLock;
        addTaint(position);
        addTaint(size);
        addTaint(shared);
        varB4EAC82CA7396A68D541C85D26508E83_873059040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873059040;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.635 -0400", hash_original_method = "EEB7B11B25906F0628185BB3DA938264", hash_generated_method = "4B7CF3499BA5C0021A4FCCE73F7BAB6A")
    public final FileLock tryLock(long position, long size, boolean shared) throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_151095029 = null; //Variable for return #1
        checkOpen();
        varB4EAC82CA7396A68D541C85D26508E83_151095029 = basicLock(position, size, shared, false);
        addTaint(position);
        addTaint(size);
        addTaint(shared);
        varB4EAC82CA7396A68D541C85D26508E83_151095029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_151095029;
        // ---------- Original Method ----------
        //checkOpen();
        //return basicLock(position, size, shared, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.639 -0400", hash_original_method = "62214805062DB6ECE1A1C9B69D272F36", hash_generated_method = "279E799C31F9ADD1EB15F728F0533924")
    public void release(FileLock lock) throws IOException {
        checkOpen();
        StructFlock flock;
        flock = new StructFlock();
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
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        removeLock(lock);
        addTaint(lock.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.640 -0400", hash_original_method = "66F727B932913E59560F8F92301E4A0B", hash_generated_method = "0B5BE715AC9EE99FD6C1A7CAAC89BB55")
    public void force(boolean metadata) throws IOException {
        checkOpen();
        {
            try 
            {
                {
                    Libcore.os.fsync(fd);
                } //End block
                {
                    Libcore.os.fdatasync(fd);
                } //End block
            } //End block
            catch (ErrnoException errnoException)
            {
                if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
            } //End block
        } //End block
        addTaint(metadata);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.650 -0400", hash_original_method = "5452C18A8AEE816635F14172EC065A87", hash_generated_method = "345808BA901311FF566642D1C9C73878")
    public final MappedByteBuffer map(MapMode mapMode, long position, long size) throws IOException {
        MappedByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1283454461 = null; //Variable for return #1
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mapMode == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " size=" + size);
        } //End block
        int accessMode;
        accessMode = (mode & O_ACCMODE);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NonWritableChannelException();
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NonReadableChannelException();
        } //End block
        {
            boolean var88B0C7780075C53660F1421ECF91608E_778896746 = (position + size > size());
            {
                try 
                {
                    Libcore.os.ftruncate(fd, position + size);
                } //End block
                catch (ErrnoException errnoException)
                {
                    if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        long alignment;
        alignment = position - position % Libcore.os.sysconf(_SC_PAGE_SIZE);
        int offset;
        offset = (int) (position - alignment);
        MemoryBlock block;
        block = MemoryBlock.mmap(fd, alignment, size + offset, mapMode);
        varB4EAC82CA7396A68D541C85D26508E83_1283454461 = new MappedByteBufferAdapter(block, (int) size, offset, mapMode);
        addTaint(mapMode.getTaint());
        addTaint(position);
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_1283454461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1283454461;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.654 -0400", hash_original_method = "2294C6BEF1501D1EBDDF8CC0BA1CBE45", hash_generated_method = "BD4E69765F6FC0185D5CDB1017ACF591")
    public long position() throws IOException {
        checkOpen();
        try 
        {
            long varF0C05ECAF241A024A616B548A1469DB9_2067456703 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1596111199 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1596111199;
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.660 -0400", hash_original_method = "38E87DF17F47600879F85DE74B488325", hash_generated_method = "925A69306B3ABD9441ED644E8F69E8F8")
    public FileChannel position(long newPosition) throws IOException {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_1141363351 = null; //Variable for return #1
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + newPosition);
        } //End block
        try 
        {
            Libcore.os.lseek(fd, newPosition, SEEK_SET);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1141363351 = this;
        addTaint(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_1141363351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1141363351;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.660 -0400", hash_original_method = "CBC403D41CEC137F7E33592DD6647C43", hash_generated_method = "8115C2C8BEE40E04B0367DA93806EE76")
    public int read(ByteBuffer buffer, long position) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + position);
        } //End block
        int varC8FBA86077E74EB96A8306D213234DFF_728150244 = (readImpl(buffer, position));
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625826558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625826558;
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return readImpl(buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.666 -0400", hash_original_method = "5BE7BADF8838BD61276F9CD3980F7CA7", hash_generated_method = "F0ED51B8116A4D67195D56F89E9C7C28")
    public int read(ByteBuffer buffer) throws IOException {
        int var50E5072F55F0FD552B497AE53AA217B8_1199918606 = (readImpl(buffer, -1));
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972651999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972651999;
        // ---------- Original Method ----------
        //return readImpl(buffer, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.679 -0400", hash_original_method = "B09A36EC89FDAA97AACE4894ACCEC4C2", hash_generated_method = "854B25952C77C7D0BCECA3C54E12896D")
    private int readImpl(ByteBuffer buffer, long position) throws IOException {
        buffer.checkWritable();
        checkOpen();
        checkReadable();
        {
            boolean var0E78D70DC6563093DEFA99F93708571E_1084809824 = (!buffer.hasRemaining());
        } //End collapsed parenthetic
        int bytesRead;
        bytesRead = 0;
        boolean completed;
        completed = false;
        try 
        {
            begin();
            try 
            {
                {
                    bytesRead = Libcore.os.read(fd, buffer);
                } //End block
                {
                    bytesRead = Libcore.os.pread(fd, buffer, position);
                } //End block
                {
                    bytesRead = -1;
                } //End block
            } //End block
            catch (ErrnoException errnoException)
            {
                {
                    bytesRead = 0;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                } //End block
            } //End block
            completed = true;
        } //End block
        finally 
        {
            end(completed && bytesRead >= 0);
        } //End block
        {
            buffer.position(buffer.position() + bytesRead);
        } //End block
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579841517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579841517;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.680 -0400", hash_original_method = "4AF9CF697EB56447960A29F46F724C12", hash_generated_method = "190A08F4B8797922ED1721C8163C1729")
    private int transferIoVec(IoVec ioVec) throws IOException {
        {
            boolean var5FBA10013EC452D05E58830F20688B44_1356758353 = (ioVec.init() == 0);
        } //End collapsed parenthetic
        int bytesTransferred;
        bytesTransferred = 0;
        boolean completed;
        completed = false;
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
        addTaint(ioVec.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162409762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162409762;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.680 -0400", hash_original_method = "C19453CFF2AA37841406A95ED2CF0809", hash_generated_method = "7A4A21368ACAE3BBF5D46DB15BAFBDA8")
    public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkReadable();
        long var61DFF2F81C7264FB8A559E2B07968B87_2014754135 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV)));
        addTaint(buffers[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1751998630 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1751998630;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffers.length, offset, length);
        //checkOpen();
        //checkReadable();
        //return transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.681 -0400", hash_original_method = "BF0F3D7AEFAA2AFACA7A21CBB184DE89", hash_generated_method = "0BCA674A4DF8B0FFBB365FE73489831C")
    public long size() throws IOException {
        checkOpen();
        try 
        {
            long var2D9D0231F90D97A868E782013621466D_603995255 = (Libcore.os.fstat(fd).st_size);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_910173757 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_910173757;
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.684 -0400", hash_original_method = "80C3AD203B1B9D1C1064C9E60FE9152A", hash_generated_method = "729DFE8F867EC1A9726CBF482CB5E480")
    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        checkOpen();
        {
            boolean varF23B30E846ED685E8A7E6FEA343CC099_704793232 = (!src.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        checkWritable();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " count=" + count);
        } //End block
        {
            boolean var2CD6C7979F5AB659D2F593D023E7DA49_1669114100 = (position > size());
        } //End collapsed parenthetic
        {
            FileChannel fileSrc;
            fileSrc = (FileChannel) src;
            long size;
            size = fileSrc.size();
            long filePosition;
            filePosition = fileSrc.position();
            count = Math.min(count, size - filePosition);
            ByteBuffer buffer;
            buffer = fileSrc.map(MapMode.READ_ONLY, filePosition, count);
            try 
            {
                fileSrc.position(filePosition + count);
                long var6A4AAB19F104CB854DDCC8B03A438627_1479968330 = (write(buffer, position));
            } //End block
            finally 
            {
                NioUtils.freeDirectBuffer(buffer);
            } //End block
        } //End block
        ByteBuffer buffer;
        buffer = ByteBuffer.allocate((int) count);
        src.read(buffer);
        buffer.flip();
        long var96E69A084CA658E2471F1D799328A275_990161720 = (write(buffer, position));
        addTaint(src.getTaint());
        addTaint(position);
        addTaint(count);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1200451092 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1200451092;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.687 -0400", hash_original_method = "66697B5A4B32B4AD2132D8B7D53DF0CD", hash_generated_method = "DB9103D0D4241369BD00E49BF2A176C9")
    public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        checkOpen();
        {
            boolean var950F8A95B861E9638CA19C9DE447BAD5_1511360857 = (!target.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        checkReadable();
        {
            ((FileChannelImpl) target).checkWritable();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " count=" + count);
        } //End block
        {
            boolean var50ED1CD0B79B3926EEAFAADB94127E2A_886762319 = (count == 0 || position >= size());
        } //End collapsed parenthetic
        count = Math.min(count, size() - position);
        boolean completed;
        completed = false;
        {
            FileDescriptor outFd;
            outFd = ((SocketChannelImpl) target).getFD();
            try 
            {
                begin();
                try 
                {
                    MutableLong offset;
                    offset = new MutableLong(position);
                    long rc;
                    rc = Libcore.os.sendfile(outFd, fd, offset, count);
                    completed = true;
                } //End block
                catch (ErrnoException errnoException)
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                    } //End block
                } //End block
            } //End block
            finally 
            {
                end(completed);
            } //End block
        } //End block
        ByteBuffer buffer;
        buffer = null;
        try 
        {
            buffer = map(MapMode.READ_ONLY, position, count);
            long var95400C0A68C0E584C17EE42C83DC2755_456654526 = (target.write(buffer));
        } //End block
        finally 
        {
            NioUtils.freeDirectBuffer(buffer);
        } //End block
        addTaint(position);
        addTaint(count);
        addTaint(target.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_118165519 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_118165519;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.688 -0400", hash_original_method = "062BFFD7E484D8312E945E8E43437F48", hash_generated_method = "5ACB60E46151E8AB7610AEDB52D9D27D")
    public FileChannel truncate(long size) throws IOException {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_1432666791 = null; //Variable for return #1
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size: " + size);
        } //End block
        checkWritable();
        {
            boolean var4D7F81A5607B883D07B09D0F1D9F39DE_1103488143 = (size < size());
            {
                try 
                {
                    Libcore.os.ftruncate(fd, size);
                } //End block
                catch (ErrnoException errnoException)
                {
                    if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1432666791 = this;
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_1432666791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432666791;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.707 -0400", hash_original_method = "D694A533B6DF57B5FA961A08FD2C2C8C", hash_generated_method = "886C255D1485A1C11136C8EC7A149F7D")
    public int write(ByteBuffer buffer, long position) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + position);
        } //End block
        int varBE3582525B9D79C935C27EAFAB1594AA_1850102098 = (writeImpl(buffer, position));
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315684697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315684697;
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return writeImpl(buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.708 -0400", hash_original_method = "50D91170AD5AAA80BF5888A2631505BE", hash_generated_method = "D01CC53B787731B13AB6107DC60E26D4")
    public int write(ByteBuffer buffer) throws IOException {
        int var6F7B4F4AB0EC6E9CBB45E23292A8E94C_182219851 = (writeImpl(buffer, -1));
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555215175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555215175;
        // ---------- Original Method ----------
        //return writeImpl(buffer, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.708 -0400", hash_original_method = "B7C7E18920DBBA232C5F1428FFA4A3EB", hash_generated_method = "9638666D5824B06CCBD528A14B9DFD56")
    private int writeImpl(ByteBuffer buffer, long position) throws IOException {
        checkOpen();
        checkWritable();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } //End block
        {
            boolean var0E78D70DC6563093DEFA99F93708571E_403217342 = (!buffer.hasRemaining());
        } //End collapsed parenthetic
        int bytesWritten;
        bytesWritten = 0;
        boolean completed;
        completed = false;
        try 
        {
            begin();
            try 
            {
                {
                    bytesWritten = Libcore.os.write(fd, buffer);
                } //End block
                {
                    bytesWritten = Libcore.os.pwrite(fd, buffer, position);
                } //End block
            } //End block
            catch (ErrnoException errnoException)
            {
                if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
            } //End block
            completed = true;
        } //End block
        finally 
        {
            end(completed);
        } //End block
        {
            buffer.position(buffer.position() + bytesWritten);
        } //End block
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600045162 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600045162;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.709 -0400", hash_original_method = "066AEC24C5D5FCB3A90F301EFD66C198", hash_generated_method = "D58B5FBDD3BEE319491DD75040B3CAE9")
    public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkWritable();
        long var9B6E3BBDE0B52650514B28B2E2435980_1395929485 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.WRITEV)));
        addTaint(buffers[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1770494051 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1770494051;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.709 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "38D953AFD3B99B7619EA1054C4C6C3D0")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_914093501 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_914093501 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_914093501.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_914093501;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.785 -0400", hash_original_method = "F902144182B3E2AF28D0016B48F7903B", hash_generated_method = "3DE3B0209C5E1F901DC01946B56F4492")
    private synchronized void addLock(FileLock lock) throws OverlappingFileLockException {
        long lockEnd;
        lockEnd = lock.position() + lock.size();
        {
            Iterator<FileLock> var1B4F03C46BF7C2A350988A93F8A6C177_703459641 = (locks).iterator();
            var1B4F03C46BF7C2A350988A93F8A6C177_703459641.hasNext();
            FileLock existingLock = var1B4F03C46BF7C2A350988A93F8A6C177_703459641.next();
            {
                {
                    boolean var6C88C86743E4FCDC495F2959E8364F37_403682590 = (existingLock.position() > lockEnd);
                } //End collapsed parenthetic
                {
                    boolean var84A341423D5A52E93BB79252C5A60BE1_1070005983 = (existingLock.overlaps(lock.position(), lock.size()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new OverlappingFileLockException();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        locks.add(lock);
        addTaint(lock.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.785 -0400", hash_original_method = "AE9E3F40D0EE8D3948C9955DBE0083E8", hash_generated_method = "45A60E7E58A4F09BCC8FAF756A093153")
    private synchronized void removeLock(FileLock lock) {
        locks.remove(lock);
        addTaint(lock.getTaint());
        // ---------- Original Method ----------
        //locks.remove(lock);
    }

    
    private static final class FileLockImpl extends FileLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.785 -0400", hash_original_field = "54A67E24EC9ED4A409BC3E533D36FB19", hash_generated_field = "4E02554B0BEBB8127D76AE5D5E6B5FAD")

        private boolean isReleased = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.786 -0400", hash_original_method = "DBB23F8476AE80F00EB4C7CF229EA4B9", hash_generated_method = "9ACAC724FFC3D3DF8DD4061D85A04AD6")
        public  FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
            super(channel, position, size, shared);
            addTaint(channel.getTaint());
            addTaint(position);
            addTaint(size);
            addTaint(shared);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.786 -0400", hash_original_method = "AAE954E5885EFA2B8D6D7679145B1DEF", hash_generated_method = "61EA8F8C27B9051E2BCBC5AC7F9FF657")
        public boolean isValid() {
            boolean varAFEB083609C9546DA785CB8359B712FC_960425040 = (!isReleased && channel().isOpen());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737256764 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_737256764;
            // ---------- Original Method ----------
            //return !isReleased && channel().isOpen();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.789 -0400", hash_original_method = "7DF971FEA31B34CE257DD1638735950E", hash_generated_method = "191476B419BB219B6FA88A30E28F78EF")
        public void release() throws IOException {
            {
                boolean var557F822D36CAEDF3BF03949648F26F96_1853924879 = (!channel().isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
                } //End block
            } //End collapsed parenthetic
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.790 -0400", hash_original_field = "214EF2C30F414C8FDB98024F4777CF3E", hash_generated_field = "250E927A0CFF5283EEBB835A6537D476")

    private static Comparator<FileLock> LOCK_COMPARATOR = new Comparator<FileLock>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.790 -0400", hash_original_method = "BAD31C1963B2F965BA94839291F4C17C", hash_generated_method = "E61563FDDBB2FDBA83587486F5B925B2")
        public int compare(FileLock lock1, FileLock lock2) {
            long position1;
            position1 = lock1.position();
            long position2;
            position2 = lock2.position();
            addTaint(lock1.getTaint());
            addTaint(lock2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656197984 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656197984;
            // ---------- Original Method ----------
            //long position1 = lock1.position();
            //long position2 = lock2.position();
            //return position1 > position2 ? 1 : (position1 < position2 ? -1 : 0);
        }

        
};
}

