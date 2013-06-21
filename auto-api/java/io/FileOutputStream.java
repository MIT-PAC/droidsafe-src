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
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import static libcore.io.OsConstants.*;

public class FileOutputStream extends OutputStream implements Closeable {
    private FileDescriptor fd;
    private boolean shouldClose;
    private FileChannel channel;
    private int mode;
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.776 -0400", hash_original_method = "FCD724AE92A53995D4248A6FA35A6403", hash_generated_method = "8B3260CE5C4BE1BB490B06CEB13B2D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.777 -0400", hash_original_method = "E1E823059D628A64A7C3F0D9FD132483", hash_generated_method = "1F5B1CF78EF48BF50CEF6EE33B6C3043")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream(File file, boolean append) throws FileNotFoundException {
        dsTaint.addTaint(append);
        dsTaint.addTaint(file.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("file == null");
        } //End block
        this.mode = O_WRONLY | O_CREAT | (append ? O_APPEND : O_TRUNC);
        this.fd = IoBridge.open(file.getAbsolutePath(), mode);
        this.shouldClose = true;
        this.guard.open("close");
        // ---------- Original Method ----------
        //if (file == null) {
            //throw new NullPointerException("file == null");
        //}
        //this.mode = O_WRONLY | O_CREAT | (append ? O_APPEND : O_TRUNC);
        //this.fd = IoBridge.open(file.getAbsolutePath(), mode);
        //this.shouldClose = true;
        //this.guard.open("close");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.777 -0400", hash_original_method = "CA1AE4948CB074C25B5079F997384B75", hash_generated_method = "47F2E3D2F89B68585B976CCC283172CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("fd == null");
        } //End block
        this.shouldClose = false;
        this.mode = O_WRONLY;
        this.channel = NioUtils.newFileChannel(this, fd, mode);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new NullPointerException("fd == null");
        //}
        //this.fd = fd;
        //this.shouldClose = false;
        //this.mode = O_WRONLY;
        //this.channel = NioUtils.newFileChannel(this, fd, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.777 -0400", hash_original_method = "ACD65E09F20B5B610F80054FC06EAD01", hash_generated_method = "C2B5C629C784C698B1065872E35A0B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream(String path) throws FileNotFoundException {
        this(path, false);
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.778 -0400", hash_original_method = "2C15450100DC44A70908DD69335AD0CF", hash_generated_method = "578872E36377555D30442D2F29B884D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream(String path, boolean append) throws FileNotFoundException {
        this(new File(path), append);
        dsTaint.addTaint(append);
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.778 -0400", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "CA7B11D8D9D676C2D46C3747A0F9596F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.778 -0400", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "65066866CC4C814D801C4B4403AC35AE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.778 -0400", hash_original_method = "ED8CC62185555A958270FAF77C7A0E38", hash_generated_method = "E2C7112DA4008D1E96EDCAF535129D4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileChannel getChannel() {
        {
            {
                channel = NioUtils.newFileChannel(this, fd, mode);
            } //End block
        } //End block
        return (FileChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (channel == null) {
                //channel = NioUtils.newFileChannel(this, fd, mode);
            //}
            //return channel;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.779 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "8A875069024AA7167BD98A27CFD5212E")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFD() throws IOException {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.779 -0400", hash_original_method = "F915AF116DBABF662C85674FE9C75DD1", hash_generated_method = "45EB619523A759E8E0146EDC2734B18A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        IoBridge.write(fd, buffer, byteOffset, byteCount);
        // ---------- Original Method ----------
        //IoBridge.write(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.779 -0400", hash_original_method = "36E798E1E7EB95F42CDB9DAEDA0C8547", hash_generated_method = "406A0B2BDBCC73BEED7AA55DB89869DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(int oneByte) throws IOException {
        dsTaint.addTaint(oneByte);
        write(new byte[] { (byte) oneByte }, 0, 1);
        // ---------- Original Method ----------
        //write(new byte[] { (byte) oneByte }, 0, 1);
    }

    
}

