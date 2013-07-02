package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.268 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "6DF85966286B5A79BC125BD24D7FC97F")

    private Object stream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.268 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.268 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.268 -0400", hash_original_field = "6534500F3CBE19A8D61109391469B658", hash_generated_field = "41CABECFE29C1BC14C56B2F0C987CEF1")

    private final SortedSet<FileLock> locks = new TreeSet<FileLock>(LOCK_COMPARATOR);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.268 -0400", hash_original_method = "2735A1029D285B5D3DE10DB0E230E666", hash_generated_method = "F6F44BF98254D27848329B7C58999156")
    public  FileChannelImpl(Object stream, FileDescriptor fd, int mode) {
        this.fd = fd;
        this.stream = stream;
        this.mode = mode;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.269 -0400", hash_original_method = "6E6D3E88914C52E71D3EAF93EC51DF72", hash_generated_method = "B2B0F3650E338E383628A2DFAD2B5BAA")
    private void checkOpen() throws ClosedChannelException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_2089883908 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.269 -0400", hash_original_method = "48C6D0CA0A11D20CF44BD79CC21BDD35", hash_generated_method = "9FD441856307A26D07CEC64A4C68174B")
    private void checkReadable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NonReadableChannelException();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.269 -0400", hash_original_method = "B5384AE1DC067BB9B7371F695174CE9F", hash_generated_method = "23A7CC7E90B45014537B712989CB83D0")
    private void checkWritable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NonWritableChannelException();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.269 -0400", hash_original_method = "906DDDB64CDCD744F2CC12CE5FEEB0F8", hash_generated_method = "44E5E9D76C63AC678003B5513904037A")
    protected void implCloseChannel() throws IOException {
        {
            ((Closeable) stream).close();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.270 -0400", hash_original_method = "7E2D5FC994D104072ED63DC91E4C8FE1", hash_generated_method = "A34C0B27B0BF1A41D820A8C63BEB64CE")
    private FileLock basicLock(long position, long size, boolean shared, boolean wait) throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_557984100 = null; 
        int accessMode = (mode & O_ACCMODE);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NonWritableChannelException();
            } 
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NonReadableChannelException();
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " size=" + size);
        } 
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
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } 
        finally 
        {
            {
                removeLock(pendingLock);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_557984100 = success ? pendingLock : null;
        addTaint(position);
        addTaint(size);
        addTaint(shared);
        addTaint(wait);
        varB4EAC82CA7396A68D541C85D26508E83_557984100.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_557984100;
        
        
    }

    
    private static long translateLockLength(long byteCount) {
        return (byteCount == Long.MAX_VALUE) ? 0 : byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.271 -0400", hash_original_method = "2D9781ECA7693E91068070ABFFE1E1EC", hash_generated_method = "3351D62246A803AF3CC68FB8C58878E5")
    public final FileLock lock(long position, long size, boolean shared) throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_631525924 = null; 
        checkOpen();
        FileLock resultLock = null;
        {
            boolean completed = false;
            try 
            {
                begin();
                resultLock = basicLock(position, size, shared, true);
                completed = true;
            } 
            finally 
            {
                end(completed);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_631525924 = resultLock;
        addTaint(position);
        addTaint(size);
        addTaint(shared);
        varB4EAC82CA7396A68D541C85D26508E83_631525924.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_631525924;
        
        
        
        
            
            
                
                
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.272 -0400", hash_original_method = "EEB7B11B25906F0628185BB3DA938264", hash_generated_method = "7508EF05D9A9A30C0D0A1A75223CFFEE")
    public final FileLock tryLock(long position, long size, boolean shared) throws IOException {
        FileLock varB4EAC82CA7396A68D541C85D26508E83_188824987 = null; 
        checkOpen();
        varB4EAC82CA7396A68D541C85D26508E83_188824987 = basicLock(position, size, shared, false);
        addTaint(position);
        addTaint(size);
        addTaint(shared);
        varB4EAC82CA7396A68D541C85D26508E83_188824987.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_188824987;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.272 -0400", hash_original_method = "62214805062DB6ECE1A1C9B69D272F36", hash_generated_method = "74A493043DCF5E21C2462874E9D3617A")
    public void release(FileLock lock) throws IOException {
        checkOpen();
        StructFlock flock = new StructFlock();
        flock.l_type = (short) F_UNLCK;
        flock.l_whence = (short) SEEK_SET;
        flock.l_start = lock.position();
        flock.l_len = translateLockLength(lock.size());
        try 
        {
            Libcore.os.fcntlFlock(fd, F_SETLKW64, flock);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } 
        removeLock(lock);
        addTaint(lock.getTaint());
        
        
        
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.273 -0400", hash_original_method = "66F727B932913E59560F8F92301E4A0B", hash_generated_method = "0B5BE715AC9EE99FD6C1A7CAAC89BB55")
    public void force(boolean metadata) throws IOException {
        checkOpen();
        {
            try 
            {
                {
                    Libcore.os.fsync(fd);
                } 
                {
                    Libcore.os.fdatasync(fd);
                } 
            } 
            catch (ErrnoException errnoException)
            {
                if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
            } 
        } 
        addTaint(metadata);
        
        
        
            
                
                    
                
                    
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.274 -0400", hash_original_method = "5452C18A8AEE816635F14172EC065A87", hash_generated_method = "E7277E2A3757367795C398081C66B504")
    public final MappedByteBuffer map(MapMode mapMode, long position, long size) throws IOException {
        MappedByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1288004032 = null; 
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mapMode == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " size=" + size);
        } 
        int accessMode = (mode & O_ACCMODE);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NonWritableChannelException();
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NonReadableChannelException();
        } 
        {
            boolean var88B0C7780075C53660F1421ECF91608E_1878507120 = (position + size > size());
            {
                try 
                {
                    Libcore.os.ftruncate(fd, position + size);
                } 
                catch (ErrnoException errnoException)
                {
                    if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                } 
            } 
        } 
        long alignment = position - position % Libcore.os.sysconf(_SC_PAGE_SIZE);
        int offset = (int) (position - alignment);
        MemoryBlock block = MemoryBlock.mmap(fd, alignment, size + offset, mapMode);
        varB4EAC82CA7396A68D541C85D26508E83_1288004032 = new MappedByteBufferAdapter(block, (int) size, offset, mapMode);
        addTaint(mapMode.getTaint());
        addTaint(position);
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_1288004032.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1288004032;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.274 -0400", hash_original_method = "2294C6BEF1501D1EBDDF8CC0BA1CBE45", hash_generated_method = "476AEDCF6EF646BE76A1336973BF434F")
    public long position() throws IOException {
        checkOpen();
        try 
        {
            long varF0C05ECAF241A024A616B548A1469DB9_410381436 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1247526973 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1247526973;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.275 -0400", hash_original_method = "38E87DF17F47600879F85DE74B488325", hash_generated_method = "7357D183AD79AA50ED4DB4444CA573AC")
    public FileChannel position(long newPosition) throws IOException {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_875860083 = null; 
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + newPosition);
        } 
        try 
        {
            Libcore.os.lseek(fd, newPosition, SEEK_SET);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_875860083 = this;
        addTaint(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_875860083.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_875860083;
        
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.276 -0400", hash_original_method = "CBC403D41CEC137F7E33592DD6647C43", hash_generated_method = "28C102B5EB6145CDCEC426AF06692496")
    public int read(ByteBuffer buffer, long position) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + position);
        } 
        int varC8FBA86077E74EB96A8306D213234DFF_278923901 = (readImpl(buffer, position));
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762449710 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762449710;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.278 -0400", hash_original_method = "5BE7BADF8838BD61276F9CD3980F7CA7", hash_generated_method = "A32D1EFB221C0FA3C91C65BD31F51E3E")
    public int read(ByteBuffer buffer) throws IOException {
        int var50E5072F55F0FD552B497AE53AA217B8_1497848087 = (readImpl(buffer, -1));
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260731067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260731067;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.280 -0400", hash_original_method = "B09A36EC89FDAA97AACE4894ACCEC4C2", hash_generated_method = "F25F0FFBDE4090FB62B028C38F1F699C")
    private int readImpl(ByteBuffer buffer, long position) throws IOException {
        buffer.checkWritable();
        checkOpen();
        checkReadable();
        {
            boolean var0E78D70DC6563093DEFA99F93708571E_645380804 = (!buffer.hasRemaining());
        } 
        int bytesRead = 0;
        boolean completed = false;
        try 
        {
            begin();
            try 
            {
                {
                    bytesRead = Libcore.os.read(fd, buffer);
                } 
                {
                    bytesRead = Libcore.os.pread(fd, buffer, position);
                } 
                {
                    bytesRead = -1;
                } 
            } 
            catch (ErrnoException errnoException)
            {
                {
                    bytesRead = 0;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                } 
            } 
            completed = true;
        } 
        finally 
        {
            end(completed && bytesRead >= 0);
        } 
        {
            buffer.position(buffer.position() + bytesRead);
        } 
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854814684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854814684;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.282 -0400", hash_original_method = "4AF9CF697EB56447960A29F46F724C12", hash_generated_method = "38F2F1623BC6AF0FB4489B2D22D371A8")
    private int transferIoVec(IoVec ioVec) throws IOException {
        {
            boolean var5FBA10013EC452D05E58830F20688B44_288603871 = (ioVec.init() == 0);
        } 
        int bytesTransferred = 0;
        boolean completed = false;
        try 
        {
            begin();
            bytesTransferred = ioVec.doTransfer(fd);
            completed = true;
        } 
        finally 
        {
            end(completed);
        } 
        ioVec.didTransfer(bytesTransferred);
        addTaint(ioVec.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572606184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572606184;
        
        
            
        
        
        
        
            
            
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.283 -0400", hash_original_method = "C19453CFF2AA37841406A95ED2CF0809", hash_generated_method = "92C724F356CBDD38360629D440EB260A")
    public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkReadable();
        long var61DFF2F81C7264FB8A559E2B07968B87_1833123406 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.READV)));
        addTaint(buffers[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2145654599 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2145654599;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.283 -0400", hash_original_method = "BF0F3D7AEFAA2AFACA7A21CBB184DE89", hash_generated_method = "97179C675A2122FA47C7FD6AB0CC5F89")
    public long size() throws IOException {
        checkOpen();
        try 
        {
            long var2D9D0231F90D97A868E782013621466D_872265768 = (Libcore.os.fstat(fd).st_size);
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_871048657 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_871048657;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.285 -0400", hash_original_method = "80C3AD203B1B9D1C1064C9E60FE9152A", hash_generated_method = "80050DB98B1323DF63DC7B47B27A0890")
    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        checkOpen();
        {
            boolean varF23B30E846ED685E8A7E6FEA343CC099_1164194370 = (!src.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } 
        } 
        checkWritable();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " count=" + count);
        } 
        {
            boolean var2CD6C7979F5AB659D2F593D023E7DA49_1244231625 = (position > size());
        } 
        {
            FileChannel fileSrc = (FileChannel) src;
            long size = fileSrc.size();
            long filePosition = fileSrc.position();
            count = Math.min(count, size - filePosition);
            ByteBuffer buffer = fileSrc.map(MapMode.READ_ONLY, filePosition, count);
            try 
            {
                fileSrc.position(filePosition + count);
                long var6A4AAB19F104CB854DDCC8B03A438627_1472564181 = (write(buffer, position));
            } 
            finally 
            {
                NioUtils.freeDirectBuffer(buffer);
            } 
        } 
        ByteBuffer buffer = ByteBuffer.allocate((int) count);
        src.read(buffer);
        buffer.flip();
        long var96E69A084CA658E2471F1D799328A275_2131180953 = (write(buffer, position));
        addTaint(src.getTaint());
        addTaint(position);
        addTaint(count);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1402008224 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1402008224;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.287 -0400", hash_original_method = "66697B5A4B32B4AD2132D8B7D53DF0CD", hash_generated_method = "C64D927B2F703A633F61159DAD0971F0")
    public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        checkOpen();
        {
            boolean var950F8A95B861E9638CA19C9DE447BAD5_236875797 = (!target.isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } 
        } 
        checkReadable();
        {
            ((FileChannelImpl) target).checkWritable();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position=" + position + " count=" + count);
        } 
        {
            boolean var50ED1CD0B79B3926EEAFAADB94127E2A_1391886761 = (count == 0 || position >= size());
        } 
        count = Math.min(count, size() - position);
        boolean completed = false;
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
                } 
                catch (ErrnoException errnoException)
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                    } 
                } 
            } 
            finally 
            {
                end(completed);
            } 
        } 
        ByteBuffer buffer = null;
        try 
        {
            buffer = map(MapMode.READ_ONLY, position, count);
            long var95400C0A68C0E584C17EE42C83DC2755_307766995 = (target.write(buffer));
        } 
        finally 
        {
            NioUtils.freeDirectBuffer(buffer);
        } 
        addTaint(position);
        addTaint(count);
        addTaint(target.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_773610344 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_773610344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.288 -0400", hash_original_method = "062BFFD7E484D8312E945E8E43437F48", hash_generated_method = "0FC621CF03F383ABF1B98333A6881B0C")
    public FileChannel truncate(long size) throws IOException {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_1419144770 = null; 
        checkOpen();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size: " + size);
        } 
        checkWritable();
        {
            boolean var4D7F81A5607B883D07B09D0F1D9F39DE_506062009 = (size < size());
            {
                try 
                {
                    Libcore.os.ftruncate(fd, size);
                } 
                catch (ErrnoException errnoException)
                {
                    if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1419144770 = this;
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_1419144770.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1419144770;
        
        
        
            
        
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.289 -0400", hash_original_method = "D694A533B6DF57B5FA961A08FD2C2C8C", hash_generated_method = "98F619A0E41CCD91B6DBCC8170364764")
    public int write(ByteBuffer buffer, long position) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("position: " + position);
        } 
        int varBE3582525B9D79C935C27EAFAB1594AA_354987297 = (writeImpl(buffer, position));
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_97437901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_97437901;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.289 -0400", hash_original_method = "50D91170AD5AAA80BF5888A2631505BE", hash_generated_method = "732F4D979CBE728862FCA3022CC33120")
    public int write(ByteBuffer buffer) throws IOException {
        int var6F7B4F4AB0EC6E9CBB45E23292A8E94C_1908498535 = (writeImpl(buffer, -1));
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029616426 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029616426;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.290 -0400", hash_original_method = "B7C7E18920DBBA232C5F1428FFA4A3EB", hash_generated_method = "0C5F051E30C54837647A5270F909997D")
    private int writeImpl(ByteBuffer buffer, long position) throws IOException {
        checkOpen();
        checkWritable();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } 
        {
            boolean var0E78D70DC6563093DEFA99F93708571E_496532590 = (!buffer.hasRemaining());
        } 
        int bytesWritten = 0;
        boolean completed = false;
        try 
        {
            begin();
            try 
            {
                {
                    bytesWritten = Libcore.os.write(fd, buffer);
                } 
                {
                    bytesWritten = Libcore.os.pwrite(fd, buffer, position);
                } 
            } 
            catch (ErrnoException errnoException)
            {
                if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
            } 
            completed = true;
        } 
        finally 
        {
            end(completed);
        } 
        {
            buffer.position(buffer.position() + bytesWritten);
        } 
        addTaint(buffer.getTaint());
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626355056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626355056;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.290 -0400", hash_original_method = "066AEC24C5D5FCB3A90F301EFD66C198", hash_generated_method = "1A4D284C313BD562F4899CDC47E44134")
    public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffers.length, offset, length);
        checkOpen();
        checkWritable();
        long var9B6E3BBDE0B52650514B28B2E2435980_1413012757 = (transferIoVec(new IoVec(buffers, offset, length, IoVec.Direction.WRITEV)));
        addTaint(buffers[0].getTaint());
        addTaint(offset);
        addTaint(length);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1933793428 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1933793428;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.291 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "4A8F7204D34A1935309932D385ADBB14")
    public FileDescriptor getFD() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1406524811 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1406524811 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1406524811.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1406524811;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.296 -0400", hash_original_method = "F902144182B3E2AF28D0016B48F7903B", hash_generated_method = "649BC42855048CDD68E2BCC060DE18FE")
    private synchronized void addLock(FileLock lock) throws OverlappingFileLockException {
        long lockEnd = lock.position() + lock.size();
        {
            Iterator<FileLock> var1B4F03C46BF7C2A350988A93F8A6C177_1251110879 = (locks).iterator();
            var1B4F03C46BF7C2A350988A93F8A6C177_1251110879.hasNext();
            FileLock existingLock = var1B4F03C46BF7C2A350988A93F8A6C177_1251110879.next();
            {
                {
                    boolean var6C88C86743E4FCDC495F2959E8364F37_746587241 = (existingLock.position() > lockEnd);
                } 
                {
                    boolean var84A341423D5A52E93BB79252C5A60BE1_1270539978 = (existingLock.overlaps(lock.position(), lock.size()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new OverlappingFileLockException();
                    } 
                } 
            } 
        } 
        locks.add(lock);
        addTaint(lock.getTaint());
        
        
        
            
                
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.296 -0400", hash_original_method = "AE9E3F40D0EE8D3948C9955DBE0083E8", hash_generated_method = "45A60E7E58A4F09BCC8FAF756A093153")
    private synchronized void removeLock(FileLock lock) {
        locks.remove(lock);
        addTaint(lock.getTaint());
        
        
    }

    
    private static final class FileLockImpl extends FileLock {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.296 -0400", hash_original_field = "54A67E24EC9ED4A409BC3E533D36FB19", hash_generated_field = "4E02554B0BEBB8127D76AE5D5E6B5FAD")

        private boolean isReleased = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.297 -0400", hash_original_method = "DBB23F8476AE80F00EB4C7CF229EA4B9", hash_generated_method = "9ACAC724FFC3D3DF8DD4061D85A04AD6")
        public  FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
            super(channel, position, size, shared);
            addTaint(channel.getTaint());
            addTaint(position);
            addTaint(size);
            addTaint(shared);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.297 -0400", hash_original_method = "AAE954E5885EFA2B8D6D7679145B1DEF", hash_generated_method = "3016F9A2CB63BAE584E425CD9AE55133")
        public boolean isValid() {
            boolean varAFEB083609C9546DA785CB8359B712FC_1592431627 = (!isReleased && channel().isOpen());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260269201 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260269201;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.297 -0400", hash_original_method = "7DF971FEA31B34CE257DD1638735950E", hash_generated_method = "E2184DCE262C109E6317680DCC936556")
        public void release() throws IOException {
            {
                boolean var557F822D36CAEDF3BF03949648F26F96_1578207758 = (!channel().isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
                } 
            } 
            {
                ((FileChannelImpl) channel()).release(this);
                isReleased = true;
            } 
            
            
                
            
            
                
                
            
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

