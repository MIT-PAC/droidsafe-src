package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private FileDescriptor fd;
    private boolean shouldClose;
    private FileChannel channel;
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.764 -0400", hash_original_method = "1BD49D518996D312C80F5CC2297619D7", hash_generated_method = "A02D5CBA8D2D341C63FDD0741282A53E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileInputStream(File file) throws FileNotFoundException {
        dsTaint.addTaint(file.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("file == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.765 -0400", hash_original_method = "9A99F3F0C17344BC7A4198604236E89C", hash_generated_method = "82F7BBC73466DFEF6ADD015645676E51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileInputStream(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("fd == null");
        } //End block
        this.shouldClose = false;
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new NullPointerException("fd == null");
        //}
        //this.fd = fd;
        //this.shouldClose = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.765 -0400", hash_original_method = "3B135756B4C06BFF0359EE9E41EEDC20", hash_generated_method = "0CF0490879DDF9D09886F21172D9AAF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileInputStream(String path) throws FileNotFoundException {
        this(new File(path));
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.765 -0400", hash_original_method = "EBD7B964937B6AA7FA3657DA1AAC30BC", hash_generated_method = "AF8D6FFD26E14E9587C28CF55386AE2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        int var9C891A36C646640680B2116257EF3205_276520214 = (IoBridge.available(fd));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.765 -0400", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "CA7B11D8D9D676C2D46C3747A0F9596F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        guard.close();
        {
            {
                channel.close();
            } //End block
            {
                IoUtils.close(fd);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.766 -0400", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "65066866CC4C814D801C4B4403AC35AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws IOException {
        try 
        {
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
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(t);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.766 -0400", hash_original_method = "BB4E25A77FBA5E31003F6019B5643EE2", hash_generated_method = "AC3247DE01B3ADBA517676ECE0DA316F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileChannel getChannel() {
        {
            {
                channel = NioUtils.newFileChannel(this, fd, O_RDONLY);
            } //End block
        } //End block
        return (FileChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (channel == null) {
                //channel = NioUtils.newFileChannel(this, fd, O_RDONLY);
            //}
            //return channel;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.766 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "8A875069024AA7167BD98A27CFD5212E")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFD() throws IOException {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.767 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "D636E2C342E32D0CC58B3DC3EC446F6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int var5941BF1153E2E81479FC3BECE4E461FF_177610283 = (Streams.readSingleByte(this));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.767 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "8541CBDA1734EA8EC6B65FDC7D4FEAEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        int varA119A82C704C62A3513B82F79810D9CB_502637980 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.767 -0400", hash_original_method = "4138A4F75DA401A9AB2AB0F0CF384113", hash_generated_method = "0EA11DEB23E33DAA45E702192F03E521")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("byteCount < 0: " + byteCount);
        } //End block
        try 
        {
            Libcore.os.lseek(fd, byteCount, SEEK_CUR);
        } //End block
        catch (ErrnoException errnoException)
        {
            {
                long var4A2E40941A54551A3C4ADC5C3F68F40B_1448408250 = (super.skip(byteCount));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintLong();
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

