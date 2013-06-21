package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private ServerSocketAdapter socket;
    private SocketImpl impl;
    private boolean isBound = false;
    private Object acceptLock = new Object();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.013 -0400", hash_original_method = "073E2905C9482C63193DCF1A83313D92", hash_generated_method = "1BD385E6F69142E305DFDD26DCE78196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        dsTaint.addTaint(sp.dsTaint);
        this.socket = new ServerSocketAdapter(this);
        this.impl = socket.getImpl$();
        // ---------- Original Method ----------
        //this.socket = new ServerSocketAdapter(this);
        //this.impl = socket.getImpl$();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.013 -0400", hash_original_method = "0B1D553D9DA92AA497AE372DB2D8B920", hash_generated_method = "AC966B1419A0E75BF76AF8FD30AA8CC0")
    @DSModeled(DSC.SAFE)
    @Override
    public ServerSocket socket() {
        return (ServerSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return socket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.014 -0400", hash_original_method = "B7A0B638220973E2E0E163125709103A", hash_generated_method = "9C772CA77E269B81ED7A69B1B46C7353")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SocketChannel accept() throws IOException {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_409248115 = (!isOpen());
            {
                if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NotYetBoundException();
        } //End block
        SocketChannelImpl result;
        result = new SocketChannelImpl(provider(), false);
        boolean connected;
        connected = false;
        try 
        {
            begin();
            {
                {
                    Object var33E828BB1AE54859E7CEF26AF86CF91F_1626680276 = (blockingLock());
                    {
                        {
                            try 
                            {
                                socket.implAccept(result);
                            } //End block
                            catch (SocketTimeoutException e)
                            { }
                        } //End block
                        {
                            boolean var0B927209D6F467F43EA9730294067322_1119683411 = (isBlocking());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            end(result.socket().isConnected());
        } //End block
        {
            boolean var47372FBA0E0559890E4D0FE7727CA3CA_22969091 = (result.socket().isConnected());
        } //End flattened ternary
        return (SocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.014 -0400", hash_original_method = "691B92594A92F5155DBD81F8E2ED268A", hash_generated_method = "96BBD6594797B067B0B657606F34610E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void implConfigureBlocking(boolean blocking) throws IOException {
        dsTaint.addTaint(blocking);
        {
            Object var964C97B960BB46676C47DA572AAFDDC9_568689868 = (blockingLock());
            {
                IoUtils.setBlocking(impl.getFD$(), blocking);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (blockingLock()) {
            //IoUtils.setBlocking(impl.getFD$(), blocking);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.014 -0400", hash_original_method = "1ADA3F28F78BF67A471F8136E0D07F3B", hash_generated_method = "F12AFEED4160B42FDDA3701D8D92E808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized protected void implCloseSelectableChannel() throws IOException {
        {
            boolean varD46A2716AEC08881570CED6916EA1310_162926920 = (!socket.isClosed());
            {
                socket.close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!socket.isClosed()) {
            //socket.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.014 -0400", hash_original_method = "6D4849F20A76F796E10F0B815FB14502", hash_generated_method = "30649CE9EBEF2BF786455AF006C02C06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor getFD() {
        FileDescriptor var5B3B45D85D19C81E95B50FED760E0C01_427996206 = (impl.getFD$());
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return impl.getFD$();
    }

    
    private static class ServerSocketAdapter extends ServerSocket {
        private ServerSocketChannelImpl channelImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.015 -0400", hash_original_method = "01F94E3226EECA786EFC49C8330A8199", hash_generated_method = "1799F9BA37E4E9216DB1FB9108553F31")
        @DSModeled(DSC.SAFE)
         ServerSocketAdapter(ServerSocketChannelImpl aChannelImpl) throws IOException {
            dsTaint.addTaint(aChannelImpl.dsTaint);
            // ---------- Original Method ----------
            //this.channelImpl = aChannelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.015 -0400", hash_original_method = "BBE5EDFC9B689589BC654E0B103C84FF", hash_generated_method = "E737283050E9B3351A14F2594EAC9D8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void bind(SocketAddress localAddress, int backlog) throws IOException {
            dsTaint.addTaint(backlog);
            dsTaint.addTaint(localAddress.dsTaint);
            super.bind(localAddress, backlog);
            channelImpl.isBound = true;
            // ---------- Original Method ----------
            //super.bind(localAddress, backlog);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.015 -0400", hash_original_method = "FFAB0B1226A929FA42E5D3CF52806643", hash_generated_method = "187FE40FB880FDDD95D3233C75D6868A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Socket accept() throws IOException {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } //End block
            SocketChannel sc;
            sc = channelImpl.accept();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalBlockingModeException();
            } //End block
            Socket var3D47F8A2EAC4A02A38AB5324C23E77FA_2080593693 = (sc.socket());
            return (Socket)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.015 -0400", hash_original_method = "65367E3BCE6469B06918214294C7E857", hash_generated_method = "BD4263D028D627D9A4A9F427C118F711")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Socket implAccept(SocketChannelImpl clientSocketChannel) throws IOException {
            dsTaint.addTaint(clientSocketChannel.dsTaint);
            Socket clientSocket;
            clientSocket = clientSocketChannel.socket();
            boolean connectOK;
            connectOK = false;
            try 
            {
                {
                    super.implAccept(clientSocket);
                    clientSocketChannel.setConnected();
                    clientSocketChannel.setBound(true);
                    clientSocketChannel.finishAccept();
                } //End block
                connectOK = true;
            } //End block
            finally 
            {
                {
                    clientSocket.close();
                } //End block
            } //End block
            return (Socket)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.015 -0400", hash_original_method = "9062324EB68516522A00021BE06AA12D", hash_generated_method = "3C6B2C797BF5F038D4A2A23489489F84")
        @DSModeled(DSC.SAFE)
        @Override
        public ServerSocketChannel getChannel() {
            return (ServerSocketChannel)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return channelImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.016 -0400", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "F9604CA7FC2BFEB8A1CAA1ED15A821FF")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isBound() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return channelImpl.isBound;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.016 -0400", hash_original_method = "67582FB1AEE3F050543A066EF39FFBDB", hash_generated_method = "BC45BAA4B3A8BA3424A9A8EC6920BF52")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void bind(SocketAddress localAddress) throws IOException {
            dsTaint.addTaint(localAddress.dsTaint);
            super.bind(localAddress);
            channelImpl.isBound = true;
            // ---------- Original Method ----------
            //super.bind(localAddress);
            //channelImpl.isBound = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.016 -0400", hash_original_method = "7BB2E5C011080F2650E0866A01912B69", hash_generated_method = "3C748D009F4F0E4048452F21DD2C3CC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            {
                {
                    boolean var732C27B9F7BFDC492915355DF0E33D1C_443064518 = (channelImpl.isOpen());
                    {
                        channelImpl.close();
                    } //End block
                    {
                        super.close();
                    } //End block
                } //End collapsed parenthetic
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

