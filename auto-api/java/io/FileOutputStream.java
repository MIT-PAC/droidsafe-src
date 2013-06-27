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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.869 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.869 -0400", hash_original_field = "B9CEC40C2FA6FEB503BDD2E3E1AC4947", hash_generated_field = "84D2D8F04948CA1C168D3A3584462F87")

    private boolean shouldClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.869 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.869 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.869 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.869 -0400", hash_original_method = "FCD724AE92A53995D4248A6FA35A6403", hash_generated_method = "5BC13460BCE7F696D8C05C5257E17B0F")
    public  FileOutputStream(File file) throws FileNotFoundException {
        this(file, false);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.885 -0400", hash_original_method = "E1E823059D628A64A7C3F0D9FD132483", hash_generated_method = "218EEEB03A5CB696DA3C9C255924C16C")
    public  FileOutputStream(File file, boolean append) throws FileNotFoundException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.886 -0400", hash_original_method = "CA1AE4948CB074C25B5079F997384B75", hash_generated_method = "3B73F4B71EC59315F0A79400AC6ADEB7")
    public  FileOutputStream(FileDescriptor fd) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("fd == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.886 -0400", hash_original_method = "ACD65E09F20B5B610F80054FC06EAD01", hash_generated_method = "A42E8E67FC696567AEE1206B2018034C")
    public  FileOutputStream(String path) throws FileNotFoundException {
        this(path, false);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.887 -0400", hash_original_method = "2C15450100DC44A70908DD69335AD0CF", hash_generated_method = "FBD46324562409D9628B348A3F1C2E7E")
    public  FileOutputStream(String path, boolean append) throws FileNotFoundException {
        this(new File(path), append);
        addTaint(path.getTaint());
        addTaint(append);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.887 -0400", hash_original_method = "F8E8B4DFEA301034B0C9D2DA47B66D8A", hash_generated_method = "CA7B11D8D9D676C2D46C3747A0F9596F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.888 -0400", hash_original_method = "5577B21C22C8702738A871739D038C15", hash_generated_method = "65066866CC4C814D801C4B4403AC35AE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.888 -0400", hash_original_method = "ED8CC62185555A958270FAF77C7A0E38", hash_generated_method = "7FDC6D1CFB73598244F29E76D3B64DB8")
    public FileChannel getChannel() {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_1305969199 = null; //Variable for return #1
        {
            {
                channel = NioUtils.newFileChannel(this, fd, mode);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1305969199 = channel;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1305969199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305969199;
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (channel == null) {
                //channel = NioUtils.newFileChannel(this, fd, mode);
            //}
            //return channel;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.894 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "6807D522052DCDD175282AFA51474890")
    public final FileDescriptor getFD() throws IOException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1905936146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1905936146 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1905936146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1905936146;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.894 -0400", hash_original_method = "F915AF116DBABF662C85674FE9C75DD1", hash_generated_method = "DF77112F0FCF68E7EB1DE9508D1392A9")
    @Override
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        IoBridge.write(fd, buffer, byteOffset, byteCount);
        addTaint(buffer[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //IoBridge.write(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.895 -0400", hash_original_method = "36E798E1E7EB95F42CDB9DAEDA0C8547", hash_generated_method = "836704451161594A41E76E7E68924F92")
    @Override
    public void write(int oneByte) throws IOException {
        write(new byte[] { (byte) oneByte }, 0, 1);
        addTaint(oneByte);
        // ---------- Original Method ----------
        //write(new byte[] { (byte) oneByte }, 0, 1);
    }

    
}

