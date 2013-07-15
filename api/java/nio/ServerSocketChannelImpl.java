package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.PlainServerSocketImpl;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.SocketTimeoutException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import libcore.io.IoUtils;

final class ServerSocketChannelImpl extends ServerSocketChannel implements FileDescriptorChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.297 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "6A9FD930739602076044D5E8A08C62AF")

    private ServerSocketAdapter socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.297 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.297 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.297 -0400", hash_original_field = "09B41F28A47510F64B0C05A1E76FE064", hash_generated_field = "867B564705311576908006F0E51C1B9C")

    private final Object acceptLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.298 -0400", hash_original_method = "073E2905C9482C63193DCF1A83313D92", hash_generated_method = "E7B472EFB12A08B1E141312D61AC89D8")
    public  ServerSocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        addTaint(sp.getTaint());
        this.socket = new ServerSocketAdapter(this);
        this.impl = socket.getImpl$();
        // ---------- Original Method ----------
        //this.socket = new ServerSocketAdapter(this);
        //this.impl = socket.getImpl$();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.298 -0400", hash_original_method = "0B1D553D9DA92AA497AE372DB2D8B920", hash_generated_method = "E76FD85DC3838393934288B9D8BEDCEC")
    @Override
    public ServerSocket socket() {
ServerSocket varA63412D4E099639C1BBCBDC8D705186B_182213043 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_182213043.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_182213043;
        // ---------- Original Method ----------
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.299 -0400", hash_original_method = "B7A0B638220973E2E0E163125709103A", hash_generated_method = "B5BF172A49040FC77BC42E1E2B578C8B")
    @Override
    public SocketChannel accept() throws IOException {
    if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_871004457 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_871004457.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_871004457;
        } //End block
    if(!isBound)        
        {
            NotYetBoundException var9E326ACC1B827FDE883AA64C52B6FE89_511034441 = new NotYetBoundException();
            var9E326ACC1B827FDE883AA64C52B6FE89_511034441.addTaint(taint);
            throw var9E326ACC1B827FDE883AA64C52B6FE89_511034441;
        } //End block
        SocketChannelImpl result = new SocketChannelImpl(provider(), false);
        boolean connected = false;
        try 
        {
            begin();
            synchronized
(acceptLock)            {
                synchronized
(blockingLock())                {
                    do {
                        {
                            try 
                            {
                                socket.implAccept(result);
                                break;
                            } //End block
                            catch (SocketTimeoutException e)
                            {
                            } //End block
                        } //End block
} while (isBlocking());
                } //End block
            } //End block
        } //End block
        finally 
        {
            end(result.socket().isConnected());
        } //End block
SocketChannel var83808169FC036D96931985AC221ACF88_1525865434 =         result.socket().isConnected() ? result : null;
        var83808169FC036D96931985AC221ACF88_1525865434.addTaint(taint);
        return var83808169FC036D96931985AC221ACF88_1525865434;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.299 -0400", hash_original_method = "691B92594A92F5155DBD81F8E2ED268A", hash_generated_method = "40C55F0AA6DB229F28FD13D7E44CA7B4")
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        addTaint(blocking);
        synchronized
(blockingLock())        {
            IoUtils.setBlocking(impl.getFD$(), blocking);
        } //End block
        // ---------- Original Method ----------
        //synchronized (blockingLock()) {
            //IoUtils.setBlocking(impl.getFD$(), blocking);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.299 -0400", hash_original_method = "1ADA3F28F78BF67A471F8136E0D07F3B", hash_generated_method = "C8ADF6D5BD1FD757E041D15E3D954B46")
    synchronized protected void implCloseSelectableChannel() throws IOException {
    if(!socket.isClosed())        
        {
            socket.close();
        } //End block
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //socket.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.300 -0400", hash_original_method = "6D4849F20A76F796E10F0B815FB14502", hash_generated_method = "C9C5D3CCDB16ABE10A09A4D717A279B0")
    public FileDescriptor getFD() {
FileDescriptor var5DC950DEDC84238CDC96D57B56A98593_1932269415 =         impl.getFD$();
        var5DC950DEDC84238CDC96D57B56A98593_1932269415.addTaint(taint);
        return var5DC950DEDC84238CDC96D57B56A98593_1932269415;
        // ---------- Original Method ----------
        //return impl.getFD$();
    }

    
    private static class ServerSocketAdapter extends ServerSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.300 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "4409938A65C53F969FE8732C261D10D0")

        private ServerSocketChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.300 -0400", hash_original_method = "01F94E3226EECA786EFC49C8330A8199", hash_generated_method = "5321552FFAD79EAB3F4957EEB1F59589")
          ServerSocketAdapter(ServerSocketChannelImpl aChannelImpl) throws IOException {
            this.channelImpl = aChannelImpl;
            // ---------- Original Method ----------
            //this.channelImpl = aChannelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.301 -0400", hash_original_method = "BBE5EDFC9B689589BC654E0B103C84FF", hash_generated_method = "74367E40AE0D91FC9C6F3F071132D89A")
        @Override
        public void bind(SocketAddress localAddress, int backlog) throws IOException {
            addTaint(backlog);
            addTaint(localAddress.getTaint());
            super.bind(localAddress, backlog);
            channelImpl.isBound = true;
            // ---------- Original Method ----------
            //super.bind(localAddress, backlog);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.301 -0400", hash_original_method = "FFAB0B1226A929FA42E5D3CF52806643", hash_generated_method = "731BF9E6FAC2E3B4DADC5D048B8F4A67")
        @Override
        public Socket accept() throws IOException {
    if(!channelImpl.isBound)            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1829070072 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1829070072.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1829070072;
            } //End block
            SocketChannel sc = channelImpl.accept();
    if(sc == null)            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1959355548 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1959355548.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1959355548;
            } //End block
Socket varCC68DF7C317A3F2B830E8FA297B72459_1065124781 =             sc.socket();
            varCC68DF7C317A3F2B830E8FA297B72459_1065124781.addTaint(taint);
            return varCC68DF7C317A3F2B830E8FA297B72459_1065124781;
            // ---------- Original Method ----------
            //if (!channelImpl.isBound) {
                //throw new IllegalBlockingModeException();
            //}
            //SocketChannel sc = channelImpl.accept();
            //if (sc == null) {
                //throw new IllegalBlockingModeException();
            //}
            //return sc.socket();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.302 -0400", hash_original_method = "65367E3BCE6469B06918214294C7E857", hash_generated_method = "5C12EAFE8B37BC840863FC3F40BAA540")
        public Socket implAccept(SocketChannelImpl clientSocketChannel) throws IOException {
            addTaint(clientSocketChannel.getTaint());
            Socket clientSocket = clientSocketChannel.socket();
            boolean connectOK = false;
            try 
            {
                synchronized
(this)                {
                    super.implAccept(clientSocket);
                    clientSocketChannel.setConnected();
                    clientSocketChannel.setBound(true);
                    clientSocketChannel.finishAccept();
                } //End block
                connectOK = true;
            } //End block
            finally 
            {
    if(!connectOK)                
                {
                    clientSocket.close();
                } //End block
            } //End block
Socket var2ABF8459F634772BF8BCAE09C5ECEEB2_275051985 =             clientSocket;
            var2ABF8459F634772BF8BCAE09C5ECEEB2_275051985.addTaint(taint);
            return var2ABF8459F634772BF8BCAE09C5ECEEB2_275051985;
            // ---------- Original Method ----------
            //Socket clientSocket = clientSocketChannel.socket();
            //boolean connectOK = false;
            //try {
                //synchronized (this) {
                    //super.implAccept(clientSocket);
                    //clientSocketChannel.setConnected();
                    //clientSocketChannel.setBound(true);
                    //clientSocketChannel.finishAccept();
                //}
                //connectOK = true;
            //} finally {
                //if (!connectOK) {
                    //clientSocket.close();
                //}
            //}
            //return clientSocket;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.302 -0400", hash_original_method = "9062324EB68516522A00021BE06AA12D", hash_generated_method = "5B54B88A6353015EAAF59F3147A51F28")
        @Override
        public ServerSocketChannel getChannel() {
ServerSocketChannel var11782E095BD1B72C89449FBEBF7A0AC8_8431249 =             channelImpl;
            var11782E095BD1B72C89449FBEBF7A0AC8_8431249.addTaint(taint);
            return var11782E095BD1B72C89449FBEBF7A0AC8_8431249;
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.303 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "E9844AD95A41D05C90C37743D2484AA9")
        @Override
        public boolean isBound() {
            boolean var4CD2AC3855DA1D125443CED5137DEAA0_1963337509 = (channelImpl.isBound);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254167132 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_254167132;
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.303 -0400", hash_original_method = "67582FB1AEE3F050543A066EF39FFBDB", hash_generated_method = "748E59BD8F46DCF8F3AD9F102A411F12")
        @Override
        public void bind(SocketAddress localAddress) throws IOException {
            addTaint(localAddress.getTaint());
            super.bind(localAddress);
            channelImpl.isBound = true;
            // ---------- Original Method ----------
            //super.bind(localAddress);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.303 -0400", hash_original_method = "7BB2E5C011080F2650E0866A01912B69", hash_generated_method = "181FD2060A9C4AFD475472EEF782212E")
        @Override
        public void close() throws IOException {
            synchronized
(channelImpl)            {
    if(channelImpl.isOpen())                
                {
                    channelImpl.close();
                } //End block
                else
                {
                    super.close();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (channelImpl) {
                //if (channelImpl.isOpen()) {
                    //channelImpl.close();
                //} else {
                    //super.close();
                //}
            //}
        }

        
    }


    
}

