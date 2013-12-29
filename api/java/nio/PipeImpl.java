package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.O_WRONLY;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.spi.SelectorProvider;

import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;





final class PipeImpl extends Pipe {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.560 -0500", hash_original_field = "328AD54C4998361CC714AC1C2831E090", hash_generated_field = "4B05C0563C4559C55245EBA97183BE45")

    private  PipeSinkChannel sink;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.561 -0500", hash_original_field = "696E4B5B69112119D3493D5B13B57D41", hash_generated_field = "5AC7FC0F0A270782C58B430F892F7E4D")

    private  PipeSourceChannel source;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.562 -0500", hash_original_method = "9FBC1B65DC8611548C416344C4B3828B", hash_generated_method = "83CBB9A1E2C73E3B207317EF44483184")
    public PipeImpl() throws IOException {
        try {
            FileDescriptor[] fds = Libcore.os.pipe();
            // Which fd is used for which channel is important. Unix pipes are only guaranteed to be
            // unidirectional, and indeed are only unidirectional on Linux.
            this.sink = new PipeSinkChannel(fds[1]);
            this.source = new PipeSourceChannel(fds[0]);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.563 -0500", hash_original_method = "C0C603D3286C71D643834A21D35D5621", hash_generated_method = "DEB969B4838E34E4D0C3D0D5572E498F")
    @Override
public SinkChannel sink() {
        return sink;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.564 -0500", hash_original_method = "06051B335F1A44C7022D361E395E201A", hash_generated_method = "58733D0E40ABCDF4F4A4A3D3FDD0C6E7")
    @Override
public SourceChannel source() {
        return source;
    }

    
    private static class FdCloser implements Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.565 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private  FileDescriptor fd;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.566 -0500", hash_original_method = "86C415C3CB1DC768FC064168AEB16626", hash_generated_method = "6D79B65C4B5AEF7634F6921E34A4AC64")
        private FdCloser(FileDescriptor fd) {
            this.fd = fd;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.567 -0500", hash_original_method = "086A2D08812022B74CB094B0E86783F6", hash_generated_method = "5DF46B8BB272C1F28F0E5FC3E72691A6")
        public void close() throws IOException {
            IoUtils.close(fd);
        }

        
    }


    
    private class PipeSourceChannel extends Pipe.SourceChannel implements FileDescriptorChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.568 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private  FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.569 -0500", hash_original_field = "606E91E177C017AB22115E5BAB9B1D1A", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private  FileChannel channel;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.571 -0500", hash_original_method = "33BC96484154D3DFFF55B74BB77FE001", hash_generated_method = "E3B31EB70019AC45EAAF31246260F8DC")
        private PipeSourceChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.572 -0500", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "74F630CAFF0C96E57B65F410986EB2FA")
        @Override
protected void implCloseSelectableChannel() throws IOException {
            channel.close();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.572 -0500", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "EFDF174215474F39F598E2892C137CCD")
        @Override
protected void implConfigureBlocking(boolean blocking) throws IOException {
            IoUtils.setBlocking(getFD(), blocking);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.573 -0500", hash_original_method = "330EC47CD6DC6EBB9C85D6C0A0075684", hash_generated_method = "4939ADC91FAFF328D02F14DFA3CA1CB4")
        public int read(ByteBuffer buffer) throws IOException {
            return channel.read(buffer);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.574 -0500", hash_original_method = "D5B21F29648A2C207C81CB15F85267EB", hash_generated_method = "74BA919E42CB21EA02BA8D8C852111EE")
        public long read(ByteBuffer[] buffers) throws IOException {
            return channel.read(buffers);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.576 -0500", hash_original_method = "C267B10FDAD89EFE496B4C3C55F1ACFC", hash_generated_method = "5F8D05604439997B81413914043C600E")
        public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
            return channel.read(buffers, offset, length);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.576 -0500", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "8F9C1BA6B62D105E8F557BE8D56765AF")
        public FileDescriptor getFD() {
            return fd;
        }

        
    }


    
    private class PipeSinkChannel extends Pipe.SinkChannel implements FileDescriptorChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.578 -0500", hash_original_field = "DC35B29CA7114A0CAB311A30B93CBE5F", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private  FileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.579 -0500", hash_original_field = "606E91E177C017AB22115E5BAB9B1D1A", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private  FileChannel channel;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.580 -0500", hash_original_method = "5C836BA555A80855D7261ED27E4E73AE", hash_generated_method = "91E3D20C1F243F122C5D57D29CA99B32")
        private PipeSinkChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.581 -0500", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "74F630CAFF0C96E57B65F410986EB2FA")
        @Override
protected void implCloseSelectableChannel() throws IOException {
            channel.close();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.582 -0500", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "EFDF174215474F39F598E2892C137CCD")
        @Override
protected void implConfigureBlocking(boolean blocking) throws IOException {
            IoUtils.setBlocking(getFD(), blocking);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.582 -0500", hash_original_method = "9BC03C30CAC8AF5ED6AA22DAB8C2126F", hash_generated_method = "2EC8E2959DE631A84FD0A6D37F43F586")
        public int write(ByteBuffer buffer) throws IOException {
            return channel.write(buffer);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.583 -0500", hash_original_method = "E4E8C5CCE7619931C84A953E614C424A", hash_generated_method = "90F3DEF6DC0B3BB2D2E0B8044E925278")
        public long write(ByteBuffer[] buffers) throws IOException {
            return channel.write(buffers);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.584 -0500", hash_original_method = "99500A3AB82F453FF24AFFE3A364E51F", hash_generated_method = "E4CEF99586D5EB3575D82A406ABE1C42")
        public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
            return channel.write(buffers, offset, length);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:38.585 -0500", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "8F9C1BA6B62D105E8F557BE8D56765AF")
        public FileDescriptor getFD() {
            return fd;
        }

        
    }


    
}

