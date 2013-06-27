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
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.spi.SelectorProvider;
import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

final class PipeImpl extends Pipe {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.864 -0400", hash_original_field = "F6E041176F8CC2998F9465EDE0DFEEB1", hash_generated_field = "4B05C0563C4559C55245EBA97183BE45")

    private PipeSinkChannel sink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.864 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "5AC7FC0F0A270782C58B430F892F7E4D")

    private PipeSourceChannel source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.870 -0400", hash_original_method = "9FBC1B65DC8611548C416344C4B3828B", hash_generated_method = "EC59D5A7A6FE1168DB350357A4001730")
    public  PipeImpl() throws IOException {
        try 
        {
            FileDescriptor[] fds;
            fds = Libcore.os.pipe();
            this.sink = new PipeSinkChannel(fds[1]);
            this.source = new PipeSourceChannel(fds[0]);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        // ---------- Original Method ----------
        //try {
            //FileDescriptor[] fds = Libcore.os.pipe();
            //this.sink = new PipeSinkChannel(fds[1]);
            //this.source = new PipeSourceChannel(fds[0]);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.870 -0400", hash_original_method = "C0C603D3286C71D643834A21D35D5621", hash_generated_method = "7037AFAA854721971337BE34565AC629")
    @Override
    public SinkChannel sink() {
        SinkChannel varB4EAC82CA7396A68D541C85D26508E83_79698899 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_79698899 = sink;
        varB4EAC82CA7396A68D541C85D26508E83_79698899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_79698899;
        // ---------- Original Method ----------
        //return sink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.874 -0400", hash_original_method = "06051B335F1A44C7022D361E395E201A", hash_generated_method = "65725C29FD5C13E40E9A7D2949DE28D0")
    @Override
    public SourceChannel source() {
        SourceChannel varB4EAC82CA7396A68D541C85D26508E83_1734649083 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1734649083 = source;
        varB4EAC82CA7396A68D541C85D26508E83_1734649083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1734649083;
        // ---------- Original Method ----------
        //return source;
    }

    
    private static class FdCloser implements Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.874 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.874 -0400", hash_original_method = "86C415C3CB1DC768FC064168AEB16626", hash_generated_method = "848D3F377F277155D9207132A062928F")
        private  FdCloser(FileDescriptor fd) {
            this.fd = fd;
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.874 -0400", hash_original_method = "086A2D08812022B74CB094B0E86783F6", hash_generated_method = "6B149A865F845EB3A84DA324127301FE")
        public void close() throws IOException {
            IoUtils.close(fd);
            // ---------- Original Method ----------
            //IoUtils.close(fd);
        }

        
    }


    
    private class PipeSourceChannel extends Pipe.SourceChannel implements FileDescriptorChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.874 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.875 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.875 -0400", hash_original_method = "33BC96484154D3DFFF55B74BB77FE001", hash_generated_method = "CF2E4873AF17A736C3A570CA5370A831")
        private  PipeSourceChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.896 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.917 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "D4B50053DE38190A68AA23F197AE5AC8")
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            IoUtils.setBlocking(getFD(), blocking);
            addTaint(blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.917 -0400", hash_original_method = "330EC47CD6DC6EBB9C85D6C0A0075684", hash_generated_method = "9A67EEA1B655E3D5FBE9D51620F44170")
        public int read(ByteBuffer buffer) throws IOException {
            int varE3E35279DE06D3BF89BF188DDFC075CE_1535247919 = (channel.read(buffer));
            addTaint(buffer.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046360143 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046360143;
            // ---------- Original Method ----------
            //return channel.read(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.917 -0400", hash_original_method = "D5B21F29648A2C207C81CB15F85267EB", hash_generated_method = "F366527D78F652A1A1E0D9494B68DD5E")
        public long read(ByteBuffer[] buffers) throws IOException {
            long varA77F9A05BBAB362B7AAE3A8BB458A7E0_920505185 = (channel.read(buffers));
            addTaint(buffers[0].getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_780129856 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_780129856;
            // ---------- Original Method ----------
            //return channel.read(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.918 -0400", hash_original_method = "C267B10FDAD89EFE496B4C3C55F1ACFC", hash_generated_method = "4739A7B9700BF6B95411EAEF8BEA47E4")
        public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
            long var69C5C67BBEF406E6BB2B9DB456FCE818_1640791421 = (channel.read(buffers, offset, length));
            addTaint(buffers[0].getTaint());
            addTaint(offset);
            addTaint(length);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1377877857 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1377877857;
            // ---------- Original Method ----------
            //return channel.read(buffers, offset, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.918 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "4F56AA80BD3045C42B68CE0F7CA6EBFB")
        public FileDescriptor getFD() {
            FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1827519391 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1827519391 = fd;
            varB4EAC82CA7396A68D541C85D26508E83_1827519391.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1827519391;
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
    private class PipeSinkChannel extends Pipe.SinkChannel implements FileDescriptorChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.918 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.918 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.919 -0400", hash_original_method = "5C836BA555A80855D7261ED27E4E73AE", hash_generated_method = "CA76B97680A2E3296B5941EA1C350CBD")
        private  PipeSinkChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.919 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.919 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "D4B50053DE38190A68AA23F197AE5AC8")
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            IoUtils.setBlocking(getFD(), blocking);
            addTaint(blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.919 -0400", hash_original_method = "9BC03C30CAC8AF5ED6AA22DAB8C2126F", hash_generated_method = "DD10AEB1EBD2FAB6675377DF7CB3E41E")
        public int write(ByteBuffer buffer) throws IOException {
            int varD33C625308AE43F89BB8311DD34CF6A5_80357448 = (channel.write(buffer));
            addTaint(buffer.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_405092377 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_405092377;
            // ---------- Original Method ----------
            //return channel.write(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.920 -0400", hash_original_method = "E4E8C5CCE7619931C84A953E614C424A", hash_generated_method = "33819E9572C483BF32BA1B92C986BF38")
        public long write(ByteBuffer[] buffers) throws IOException {
            long var8CC22DCE6BAAE02F2205631F6A2FBFF6_1782771087 = (channel.write(buffers));
            addTaint(buffers[0].getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_567430046 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_567430046;
            // ---------- Original Method ----------
            //return channel.write(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.920 -0400", hash_original_method = "99500A3AB82F453FF24AFFE3A364E51F", hash_generated_method = "637D924F207C0CE6CE98810F4E62EB42")
        public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
            long var27867189103625C08564386E99E9E826_1304124348 = (channel.write(buffers, offset, length));
            addTaint(buffers[0].getTaint());
            addTaint(offset);
            addTaint(length);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_524274536 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_524274536;
            // ---------- Original Method ----------
            //return channel.write(buffers, offset, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.920 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "F623422263A1485913D004D6F0C9EEBD")
        public FileDescriptor getFD() {
            FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1251193643 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1251193643 = fd;
            varB4EAC82CA7396A68D541C85D26508E83_1251193643.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1251193643;
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
}

