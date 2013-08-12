package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.928 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "6A9FD930739602076044D5E8A08C62AF")

    private ServerSocketAdapter socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.928 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private SocketImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.928 -0400", hash_original_field = "1EA05BED8F3F3741889B40C4407A936D", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.928 -0400", hash_original_field = "09B41F28A47510F64B0C05A1E76FE064", hash_generated_field = "867B564705311576908006F0E51C1B9C")

    private final Object acceptLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.929 -0400", hash_original_method = "073E2905C9482C63193DCF1A83313D92", hash_generated_method = "E7B472EFB12A08B1E141312D61AC89D8")
    public  ServerSocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        addTaint(sp.getTaint());
        this.socket = new ServerSocketAdapter(this);
        this.impl = socket.getImpl$();
        // ---------- Original Method ----------
        //this.socket = new ServerSocketAdapter(this);
        //this.impl = socket.getImpl$();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.929 -0400", hash_original_method = "0B1D553D9DA92AA497AE372DB2D8B920", hash_generated_method = "02E8615CFE888658AD3F7AB1CC26AFAD")
    @Override
    public ServerSocket socket() {
ServerSocket varA63412D4E099639C1BBCBDC8D705186B_2045354879 =         socket;
        varA63412D4E099639C1BBCBDC8D705186B_2045354879.addTaint(taint);
        return varA63412D4E099639C1BBCBDC8D705186B_2045354879;
        // ---------- Original Method ----------
        //return socket;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.930 -0400", hash_original_method = "B7A0B638220973E2E0E163125709103A", hash_generated_method = "FC11EC07A639F96FFD437DB3947547FF")
    @Override
    public SocketChannel accept() throws IOException {
        if(!isOpen())        
        {
            ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_2092460041 = new ClosedChannelException();
            var553E3C0ED28F94CE76A7A8061DFFDCF3_2092460041.addTaint(taint);
            throw var553E3C0ED28F94CE76A7A8061DFFDCF3_2092460041;
        } //End block
        if(!isBound)        
        {
            NotYetBoundException var9E326ACC1B827FDE883AA64C52B6FE89_1883500531 = new NotYetBoundException();
            var9E326ACC1B827FDE883AA64C52B6FE89_1883500531.addTaint(taint);
            throw var9E326ACC1B827FDE883AA64C52B6FE89_1883500531;
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
SocketChannel var83808169FC036D96931985AC221ACF88_141833379 =         result.socket().isConnected() ? result : null;
        var83808169FC036D96931985AC221ACF88_141833379.addTaint(taint);
        return var83808169FC036D96931985AC221ACF88_141833379;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.930 -0400", hash_original_method = "691B92594A92F5155DBD81F8E2ED268A", hash_generated_method = "40C55F0AA6DB229F28FD13D7E44CA7B4")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.931 -0400", hash_original_method = "1ADA3F28F78BF67A471F8136E0D07F3B", hash_generated_method = "C8ADF6D5BD1FD757E041D15E3D954B46")
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.931 -0400", hash_original_method = "6D4849F20A76F796E10F0B815FB14502", hash_generated_method = "52E255CA8CAAE37254929CE00ECA9AB4")
    public FileDescriptor getFD() {
FileDescriptor var5DC950DEDC84238CDC96D57B56A98593_404011950 =         impl.getFD$();
        var5DC950DEDC84238CDC96D57B56A98593_404011950.addTaint(taint);
        return var5DC950DEDC84238CDC96D57B56A98593_404011950;
        // ---------- Original Method ----------
        //return impl.getFD$();
    }

    
    private static class ServerSocketAdapter extends ServerSocket {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.931 -0400", hash_original_field = "32CC750E4B8FCA138B4D6BCBE118C5DB", hash_generated_field = "4409938A65C53F969FE8732C261D10D0")

        private ServerSocketChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.932 -0400", hash_original_method = "01F94E3226EECA786EFC49C8330A8199", hash_generated_method = "5321552FFAD79EAB3F4957EEB1F59589")
          ServerSocketAdapter(ServerSocketChannelImpl aChannelImpl) throws IOException {
            this.channelImpl = aChannelImpl;
            // ---------- Original Method ----------
            //this.channelImpl = aChannelImpl;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.932 -0400", hash_original_method = "BBE5EDFC9B689589BC654E0B103C84FF", hash_generated_method = "74367E40AE0D91FC9C6F3F071132D89A")
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

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.932 -0400", hash_original_method = "FFAB0B1226A929FA42E5D3CF52806643", hash_generated_method = "EC01246CE6CE6B54B4EA7E495BA3C321")
        @Override
        public Socket accept() throws IOException {
            if(!channelImpl.isBound)            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1385428548 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1385428548.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1385428548;
            } //End block
            SocketChannel sc = channelImpl.accept();
            if(sc == null)            
            {
                IllegalBlockingModeException var18B57A4F8FA8BFBB84FC533EE882297F_1895767870 = new IllegalBlockingModeException();
                var18B57A4F8FA8BFBB84FC533EE882297F_1895767870.addTaint(taint);
                throw var18B57A4F8FA8BFBB84FC533EE882297F_1895767870;
            } //End block
Socket varCC68DF7C317A3F2B830E8FA297B72459_386868451 =             sc.socket();
            varCC68DF7C317A3F2B830E8FA297B72459_386868451.addTaint(taint);
            return varCC68DF7C317A3F2B830E8FA297B72459_386868451;
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

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.933 -0400", hash_original_method = "65367E3BCE6469B06918214294C7E857", hash_generated_method = "A8C35A0C935FD2ACA963F3B7C5549F18")
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
Socket var2ABF8459F634772BF8BCAE09C5ECEEB2_2079058864 =             clientSocket;
            var2ABF8459F634772BF8BCAE09C5ECEEB2_2079058864.addTaint(taint);
            return var2ABF8459F634772BF8BCAE09C5ECEEB2_2079058864;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.933 -0400", hash_original_method = "9062324EB68516522A00021BE06AA12D", hash_generated_method = "02B0C264343682DE691D8C82FA0757C8")
        @Override
        public ServerSocketChannel getChannel() {
ServerSocketChannel var11782E095BD1B72C89449FBEBF7A0AC8_1581996953 =             channelImpl;
            var11782E095BD1B72C89449FBEBF7A0AC8_1581996953.addTaint(taint);
            return var11782E095BD1B72C89449FBEBF7A0AC8_1581996953;
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.934 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "8A2457A317EFAD07A873C7FEDD5A7A92")
        @Override
        public boolean isBound() {
            boolean var4CD2AC3855DA1D125443CED5137DEAA0_1992694024 = (channelImpl.isBound);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68738550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_68738550;
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.934 -0400", hash_original_method = "67582FB1AEE3F050543A066EF39FFBDB", hash_generated_method = "748E59BD8F46DCF8F3AD9F102A411F12")
        @Override
        public void bind(SocketAddress localAddress) throws IOException {
            addTaint(localAddress.getTaint());
            super.bind(localAddress);
            channelImpl.isBound = true;
            // ---------- Original Method ----------
            //super.bind(localAddress);
            //channelImpl.isBound = true;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.935 -0400", hash_original_method = "7BB2E5C011080F2650E0866A01912B69", hash_generated_method = "181FD2060A9C4AFD475472EEF782212E")
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

