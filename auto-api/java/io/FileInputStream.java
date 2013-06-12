package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final boolean shouldClose;
    private FileChannel channel;
    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.452 -0400", hash_original_method = "1BD49D518996D312C80F5CC2297619D7", hash_generated_method = "A746B8E131F428E87B4EC0616B3FC9B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileInputStream(File file) throws FileNotFoundException {
        dsTaint.addTaint(file.dsTaint);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException("file == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "9A99F3F0C17344BC7A4198604236E89C", hash_generated_method = "57899219421C01F99EC05F73D648BBE3")
    @DSModeled(DSC.SAFE)
    public FileInputStream(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException("fd == null");
        } //End block
        this.shouldClose = false;
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new NullPointerException("fd == null");
        //}
        //this.fd = fd;
        //this.shouldClose = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "3B135756B4C06BFF0359EE9E41EEDC20", hash_generated_method = "A2E4A0FD3BFCEF26196876741D2C90C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileInputStream(String path) throws FileNotFoundException {
        this(new File(path));
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "EBD7B964937B6AA7FA3657DA1AAC30BC", hash_generated_method = "A81DF088EC088DC380310EFFAB79761A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        int var9C891A36C646640680B2116257EF3205_624469651 = (IoBridge.available(fd));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return IoBridge.available(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "1CC7D26A4F0EE263E12B684B6C157B53")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "C0BCF3B286A2315D59F9F0828713B8A2")
    @DSModeled(DSC.SAFE)
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
                throw new AssertionError(t);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "BB4E25A77FBA5E31003F6019B5643EE2", hash_generated_method = "D2AB08197D9D9FDD55E9755828BDE580")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "5EEBEE949DA2AB28C9F4160248A81D9F")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFD() throws IOException {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "C2B81109798C7DEA75911EFCD1C62396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int var5941BF1153E2E81479FC3BECE4E461FF_1517565138 = (Streams.readSingleByte(this));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "573BAF99D35207A68492447566EF9E7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(byteCount);
        int varA119A82C704C62A3513B82F79810D9CB_267947955 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.453 -0400", hash_original_method = "4138A4F75DA401A9AB2AB0F0CF384113", hash_generated_method = "7722A2A35F36C5E58548345FEE27CF22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        if(DroidSafeAndroidRuntime.control) {
            throw new IOException("byteCount < 0: " + byteCount);
        } //End block
        try 
        {
            Libcore.os.lseek(fd, byteCount, SEEK_CUR);
        } //End block
        catch (ErrnoException errnoException)
        {
            {
                long var4A2E40941A54551A3C4ADC5C3F68F40B_553843137 = (super.skip(byteCount));
            } //End block
            throw errnoException.rethrowAsIOException();
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


