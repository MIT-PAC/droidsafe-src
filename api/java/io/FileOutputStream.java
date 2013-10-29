package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.O_APPEND;
import static libcore.io.OsConstants.O_CREAT;
import static libcore.io.OsConstants.O_TRUNC;
import static libcore.io.OsConstants.O_WRONLY;

import java.nio.NioUtils;
import java.nio.channels.FileChannel;

import libcore.io.IoBridge;
import libcore.io.IoUtils;
import dalvik.system.CloseGuard;





public class FileOutputStream extends OutputStream implements Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.936 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.936 -0400", hash_original_field = "B9CEC40C2FA6FEB503BDD2E3E1AC4947", hash_generated_field = "84D2D8F04948CA1C168D3A3584462F87")

    private boolean shouldClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.936 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.936 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.936 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.936 -0400", hash_original_method = "FCD724AE92A53995D4248A6FA35A6403", hash_generated_method = "5BC13460BCE7F696D8C05C5257E17B0F")
    @DSModeled(DSC.SAFE)
    public  FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.937 -0400", hash_original_method = "E1E823059D628A64A7C3F0D9FD132483", hash_generated_method = "CC862847CCED2113201E5B34B1515DAA")
    @DSModeled(DSC.SAFE)
    public  FileOutputStream(File file, boolean append) throws FileNotFoundException {
        if(file == null)        
        {
            NullPointerException var34C654CB6A962C169433BF5C5405377F_1141392389 = new NullPointerException("file == null");
            var34C654CB6A962C169433BF5C5405377F_1141392389.addTaint(taint);
            throw var34C654CB6A962C169433BF5C5405377F_1141392389;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.938 -0400", hash_original_method = "CA1AE4948CB074C25B5079F997384B75", hash_generated_method = "B081409E7B6F330938DE0DA36651F832")
    @DSModeled(DSC.SAFE)
    public  FileOutputStream(FileDescriptor fd) {
        if(fd == null)        
        {
            NullPointerException var80E87090A64E83D6A9C06DE7A777A91D_658648225 = new NullPointerException("fd == null");
            var80E87090A64E83D6A9C06DE7A777A91D_658648225.addTaint(taint);
            throw var80E87090A64E83D6A9C06DE7A777A91D_658648225;
        } //End block
        this.fd = fd;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.938 -0400", hash_original_method = "ACD65E09F20B5B610F80054FC06EAD01", hash_generated_method = "A42E8E67FC696567AEE1206B2018034C")
    @DSModeled(DSC.SAFE)
    public  FileOutputStream(String path) throws FileNotFoundException {
        this(path, false);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.939 -0400", hash_original_method = "2C15450100DC44A70908DD69335AD0CF", hash_generated_method = "31A84825CA145146F705BC29D99B658C")
    @DSModeled(DSC.SAFE)
    public  FileOutputStream(String path, boolean append) throws FileNotFoundException {
        this(new File(path), append);
        addTaint(append);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.940 -0400", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "EE9AE9D010385501F5824C8DC6CF7D6A")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.940 -0400", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "AF5D6864536F164147F198AB1577B99D")
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
                AssertionError var31F1143F51E5C3306DAC550F61AF5CBA_970385726 = new AssertionError(t);
                var31F1143F51E5C3306DAC550F61AF5CBA_970385726.addTaint(taint);
                throw var31F1143F51E5C3306DAC550F61AF5CBA_970385726;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.941 -0400", hash_original_method = "ED8CC62185555A958270FAF77C7A0E38", hash_generated_method = "6CCFC568537EF1BECA0491D6685C4D5E")
    public FileChannel getChannel() {
        synchronized
(this)        {
            if(channel == null)            
            {
                channel = NioUtils.newFileChannel(this, fd, mode);
            } //End block
FileChannel var99BA3483FD74E36EACD435CEE6BD5D6F_242697572 =             channel;
            var99BA3483FD74E36EACD435CEE6BD5D6F_242697572.addTaint(taint);
            return var99BA3483FD74E36EACD435CEE6BD5D6F_242697572;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (channel == null) {
                //channel = NioUtils.newFileChannel(this, fd, mode);
            //}
            //return channel;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.942 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "486019EE0AA1048DD80AB0FDDD04754D")
    public final FileDescriptor getFD() throws IOException {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_659266388 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_659266388.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_659266388;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.943 -0400", hash_original_method = "F915AF116DBABF662C85674FE9C75DD1", hash_generated_method = "B0100B8D6811E035B621357EE70ED51B")
    @Override
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(buffer[0]);
        IoBridge.write(fd, buffer, byteOffset, byteCount);
        // ---------- Original Method ----------
        //IoBridge.write(fd, buffer, byteOffset, byteCount);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.943 -0400", hash_original_method = "36E798E1E7EB95F42CDB9DAEDA0C8547", hash_generated_method = "138B1D0EC92A8994ADF13D7A3C31A154")
    @Override
    public void write(int oneByte) throws IOException {
        addTaint(oneByte);
        write(new byte[] { (byte) oneByte }, 0, 1);
        // ---------- Original Method ----------
        //write(new byte[] { (byte) oneByte }, 0, 1);
    }

    
}

