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
    private Object stream;
    private FileDescriptor fd;
    private int mode;
    private SortedSet<FileLock> locks = new TreeSet<FileLock>(LOCK_COMPARATOR);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.686 -0400", hash_original_method = "2735A1029D285B5D3DE10DB0E230E666", hash_generated_method = "40BCFE065C17B1CE7F580EE43FD9FABC")
    @DSModeled(DSC.SAFE)
    public FileChannelImpl(Object stream, FileDescriptor fd, int mode) {
        dsTaint.addTaint(stream.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //this.fd = fd;
        //this.stream = stream;
        //this.mode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.686 -0400", hash_original_method = "6E6D3E88914C52E71D3EAF93EC51DF72", hash_generated_method = "A54CF5E80C1B6F00CA76EF4D68F88CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpen() throws ClosedChannelException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1870522044 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //throw new ClosedChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.686 -0400", hash_original_method = "48C6D0CA0A11D20CF44BD79CC21BDD35", hash_generated_method = "9FD441856307A26D07CEC64A4C68174B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkReadable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NonReadableChannelException();
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_WRONLY) {
            //throw new NonReadableChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.686 -0400", hash_original_method = "B5384AE1DC067BB9B7371F695174CE9F", hash_generated_method = "23A7CC7E90B45014537B712989CB83D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkWritable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NonWritableChannelException();
        } //End block
        // ---------- Original Method ----------
        //if ((mode & O_ACCMODE) == O_RDONLY) {
            //throw new NonWritableChannelException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.686 -0400", hash_original_method = "906DDDB64CDCD744F2CC12CE5FEEB0F8", hash_generated_method = "44E5E9D76C63AC678003B5513904037A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void implCloseChannel() throws IOException {
        {
            ((Closeable) stream).close();
        } //End block
        // ---------- Original Method ----------
        //if (stream instanceof Closeable) {
            //((Closeable) stream).close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.687 -0400", hash_original_method = "7E2D5FC994D104072ED63DC91E4C8FE1", hash_generated_method = "DEB24C8ECF91A6ACC4C99EAD97829D86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FileLock basicLock(long position, long size, boolean shared, boolean wait) throws IOException {
        dsTaint.addTaint(shared);
        dsTaint.addTaint(position);
        dsTaint.addTaint(wait);
        dsTaint.addTaint(size);
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
        return (FileLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static long translateLockLength(long byteCount) {
        return (byteCount == Long.MAX_VALUE) ? 0 : byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.687 -0400", hash_original_method = "2D9781ECA7693E91068070ABFFE1E1EC", hash_generated_method = "5D95FC2B148C4E0B5D0D18011355A041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final FileLock lock(long position, long size, boolean shared) throws IOException {
        dsTaint.addTaint(shared);
        dsTaint.addTaint(position);
        dsTaint.addTaint(size);
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
        return (FileLock)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.688 -0400", hash_original_method = "EEB7B11B25906F0628185BB3DA938264", hash_generated_method = "63F83F0402DD999E180FBFD78AA27439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final FileLock tryLock(long position, long size, boolean shared) throws IOException {
        dsTaint.addTaint(shared);
        dsTaint.addTaint(position);
        dsTaint.addTaint(size);
        checkOpen();
        FileLock var3881A73B311F1151B3A2842BE2DD0A1C_908549173 = (basicLock(position, size, shared, false));
        return (FileLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpen();
        //return basicLock(position, size, shared, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.688 -0400", hash_original_method = "62214805062DB6ECE1A1C9B69D272F36", hash_generated_method = "568FCC3867D4165507858D744EB18C6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release(FileLock lock) throws IOException {
        dsTaint.addTaint(lock.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.688 -0400", hash_original_method = "66F727B932913E59560F8F92301E4A0B", hash_generated_method = "5024EC38F2713CF58C574637815CCDD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void force(boolean metadata) throws IOException {
        dsTaint.addTaint(metadata);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.689 -0400", hash_original_method = "5452C18A8AEE816635F14172EC065A87", hash_generated_method = "3E47F20B38822621E1D788831692E3A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final MappedByteBuffer map(MapMode mapMode, long position, long size) throws IOException {
        dsTaint.addTaint(position);
        dsTaint.addTaint(mapMode.dsTaint);
        dsTaint.addTaint(size);
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
            boolean var88B0C7780075C53660F1421ECF91608E_1614602375 = (position + size > size());
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
        MappedByteBuffer varDF1A88A36245584178EA42975C7876A5_432490336 = (new MappedByteBufferAdapter(block, (int) size, offset, mapMode));
        return (MappedByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.689 -0400", hash_original_method = "2294C6BEF1501D1EBDDF8CC0BA1CBE45", hash_generated_method = "D6120996021D64EE137B496A2A607B77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long position() throws IOException {
        checkOpen();
        try 
        {
            long varF0C05ECAF241A024A616B548A1469DB9_830454024 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.689 -0400", hash_original_method = "38E87DF17F47600879F85DE74B488325", hash_generated_method = "692B2F3976B772A502D52684BB8ECC34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileChannel position(long newPosition) throws IOException {
        dsTaint.addTaint(newPosition);
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
        return (FileChannel)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.689 -0400", hash_original_method = "CBC403D41CEC137F7E33592DD6647C43", hash_generated_method = "3BB9D5B26E8C78210F565C0B68E8DBED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(ByteBuffer buffer, long position) throws IOException {
        dsTaint.addTaint(position);
        dsTaint.addTaint(buffer.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + position);
        } //End block
        int varC8FBA86077E74EB96A8306D213234DFF_1951725382 = (readImpl(buffer, position));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return readImpl(buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.690 -0400", hash_original_method = "5BE7BADF8838BD61276F9CD3980F7CA7", hash_generated_method = "ADBC4A6083FD4FBD79F02E1C29A30EAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(ByteBuffer buffer) throws IOException {
        dsTaint.addTaint(buffer.dsTaint);
        int var50E5072F55F0FD552B497AE53AA217B8_1305407921 = (readImpl(buffer, -1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return readImpl(buffer, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.690 -0400", hash_original_method = "B09A36EC89FDAA97AACE4894ACCEC4C2", hash_generated_method = "83F1E006C67A6622E57AECB84FEC10DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readImpl(ByteBuffer buffer, long position) throws IOException {
        dsTaint.addTaint(position);
        dsTaint.addTaint(buffer.dsTaint);
        buffer.checkWritable();
        checkOpen();
        checkReadable();
        {
            boolean var0E78D70DC6563093DEFA99F93708571E_1703990114 = (!buffer.hasRemaining());
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.691 -0400", hash_original_method = "4AF9CF697EB56447960A29F46F724C12", hash_generated_method = "617CAA066C49BD6D8C588EFE76F66FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int transferIoVec(IoVec ioVec) throws IOException {
        dsTaint.addTaint(ioVec.dsTaint);
        {
            boolean var5FBA10013EC452D05E58830F20688B44_745147800 = (ioVec.init() == 0);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.691 -0400", hash_original_method = "C19453CFF2AA37841406A95ED2CF0809", hash_generated_method = "2448F6A4B2026FCBF24158F10D7C7050")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkReadable();
        long var61DFF2F81C7264FB8A559E2B07968B87_1398464758 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV)));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffers.length, offset, length);
        //checkOpen();
        //checkReadable();
        //return transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.691 -0400", hash_original_method = "BF0F3D7AEFAA2AFACA7A21CBB184DE89", hash_generated_method = "8B4DD4E673375A65DB9B8C46C9560BE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long size() throws IOException {
        checkOpen();
        try 
        {
            long var2D9D0231F90D97A868E782013621466D_543231455 = (Libcore.os.fstat(fd).st_size);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkOpen();
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.692 -0400", hash_original_method = "80C3AD203B1B9D1C1064C9E60FE9152A", hash_generated_method = "FEED24EB8239CDF42B2C3E09C195B482")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        dsTaint.addTaint(position);
        dsTaint.addTaint(count);
        dsTaint.addTaint(src.dsTaint);
        checkOpen();
        {
            boolean varF23B30E846ED685E8A7E6FEA343CC099_1539879183 = (!src.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        checkWritable();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " count=" + count);
        } //End block
        {
            boolean var2CD6C7979F5AB659D2F593D023E7DA49_1298363069 = (position > size());
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
                long var6A4AAB19F104CB854DDCC8B03A438627_352039935 = (write(buffer, position));
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
        long var96E69A084CA658E2471F1D799328A275_1769742944 = (write(buffer, position));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.692 -0400", hash_original_method = "66697B5A4B32B4AD2132D8B7D53DF0CD", hash_generated_method = "CF5B827B262C956BEE300DFC074911A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        dsTaint.addTaint(position);
        dsTaint.addTaint(count);
        dsTaint.addTaint(target.dsTaint);
        checkOpen();
        {
            boolean var950F8A95B861E9638CA19C9DE447BAD5_728697975 = (!target.isOpen());
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
            boolean var50ED1CD0B79B3926EEAFAADB94127E2A_734866170 = (count == 0 || position >= size());
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
            long var95400C0A68C0E584C17EE42C83DC2755_582406077 = (target.write(buffer));
        } //End block
        finally 
        {
            NioUtils.freeDirectBuffer(buffer);
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.693 -0400", hash_original_method = "062BFFD7E484D8312E945E8E43437F48", hash_generated_method = "8F1312F6A72F81255DA4E8CDDE4DEF87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileChannel truncate(long size) throws IOException {
        dsTaint.addTaint(size);
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size: " + size);
        } //End block
        checkWritable();
        {
            boolean var4D7F81A5607B883D07B09D0F1D9F39DE_1405309221 = (size < size());
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
        return (FileChannel)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.693 -0400", hash_original_method = "D694A533B6DF57B5FA961A08FD2C2C8C", hash_generated_method = "84467D782221CF7683481A53BD6B0203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int write(ByteBuffer buffer, long position) throws IOException {
        dsTaint.addTaint(position);
        dsTaint.addTaint(buffer.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + position);
        } //End block
        int varBE3582525B9D79C935C27EAFAB1594AA_2006911785 = (writeImpl(buffer, position));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (position < 0) {
            //throw new IllegalArgumentException("position: " + position);
        //}
        //return writeImpl(buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.693 -0400", hash_original_method = "50D91170AD5AAA80BF5888A2631505BE", hash_generated_method = "A8CFE0F9F81234C184488077E83599FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int write(ByteBuffer buffer) throws IOException {
        dsTaint.addTaint(buffer.dsTaint);
        int var6F7B4F4AB0EC6E9CBB45E23292A8E94C_787858680 = (writeImpl(buffer, -1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return writeImpl(buffer, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.694 -0400", hash_original_method = "B7C7E18920DBBA232C5F1428FFA4A3EB", hash_generated_method = "81DB7FC4BDA5F00F71C8D7D04C1A3D4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeImpl(ByteBuffer buffer, long position) throws IOException {
        dsTaint.addTaint(position);
        dsTaint.addTaint(buffer.dsTaint);
        checkOpen();
        checkWritable();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } //End block
        {
            boolean var0E78D70DC6563093DEFA99F93708571E_303026095 = (!buffer.hasRemaining());
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.694 -0400", hash_original_method = "066AEC24C5D5FCB3A90F301EFD66C198", hash_generated_method = "C11E2E4D18D7472631B6DEDEAA22497C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkWritable();
        long var9B6E3BBDE0B52650514B28B2E2435980_767518146 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.WRITEV)));
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.694 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "60A88A21D094E8421E3812E611B5557E")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFD() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.699 -0400", hash_original_method = "F902144182B3E2AF28D0016B48F7903B", hash_generated_method = "92DB2FF8E79A45519003221D0C4CAF78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void addLock(FileLock lock) throws OverlappingFileLockException {
        dsTaint.addTaint(lock.dsTaint);
        long lockEnd;
        lockEnd = lock.position() + lock.size();
        {
            Iterator<FileLock> var1B4F03C46BF7C2A350988A93F8A6C177_1450533010 = (locks).iterator();
            var1B4F03C46BF7C2A350988A93F8A6C177_1450533010.hasNext();
            FileLock existingLock = var1B4F03C46BF7C2A350988A93F8A6C177_1450533010.next();
            {
                {
                    boolean var6C88C86743E4FCDC495F2959E8364F37_475724130 = (existingLock.position() > lockEnd);
                } //End collapsed parenthetic
                {
                    boolean var84A341423D5A52E93BB79252C5A60BE1_242412470 = (existingLock.overlaps(lock.position(), lock.size()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new OverlappingFileLockException();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.699 -0400", hash_original_method = "AE9E3F40D0EE8D3948C9955DBE0083E8", hash_generated_method = "02DD21AB6B14A17095907953EA91B2BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void removeLock(FileLock lock) {
        dsTaint.addTaint(lock.dsTaint);
        locks.remove(lock);
        // ---------- Original Method ----------
        //locks.remove(lock);
    }

    
    private static final class FileLockImpl extends FileLock {
        private boolean isReleased = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.700 -0400", hash_original_method = "DBB23F8476AE80F00EB4C7CF229EA4B9", hash_generated_method = "E203D9F7E86E62BC77064B6FB5182A13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
            super(channel, position, size, shared);
            dsTaint.addTaint(shared);
            dsTaint.addTaint(position);
            dsTaint.addTaint(channel.dsTaint);
            dsTaint.addTaint(size);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.700 -0400", hash_original_method = "AAE954E5885EFA2B8D6D7679145B1DEF", hash_generated_method = "974572FF17B47E211BBDD3098472C978")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isValid() {
            boolean varAFEB083609C9546DA785CB8359B712FC_1325188328 = (!isReleased && channel().isOpen());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return !isReleased && channel().isOpen();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.700 -0400", hash_original_method = "7DF971FEA31B34CE257DD1638735950E", hash_generated_method = "A789BBFEEB67C7D697ADEB3E793A531A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void release() throws IOException {
            {
                boolean var557F822D36CAEDF3BF03949648F26F96_169132464 = (!channel().isOpen());
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


    
    private static final Comparator<FileLock> LOCK_COMPARATOR = new Comparator<FileLock>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.701 -0400", hash_original_method = "BAD31C1963B2F965BA94839291F4C17C", hash_generated_method = "96F9E4A87B7302B2FA987213818A07D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(FileLock lock1, FileLock lock2) {
            dsTaint.addTaint(lock2.dsTaint);
            dsTaint.addTaint(lock1.dsTaint);
            long position1;
            position1 = lock1.position();
            long position2;
            position2 = lock2.position();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //long position1 = lock1.position();
            //long position2 = lock2.position();
            //return position1 > position2 ? 1 : (position1 < position2 ? -1 : 0);
        }

        
}; //Transformed anonymous class
}

