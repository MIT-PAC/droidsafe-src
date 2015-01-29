package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.857 -0500", hash_original_field = "B9326D07C7CCEC3D3BE5D47F067FF85C", hash_generated_field = "6A9FD930739602076044D5E8A08C62AF")

    private  ServerSocketAdapter socket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.860 -0500", hash_original_field = "76382137C184A183F2BF2D8583A90AEC", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private  SocketImpl impl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.862 -0500", hash_original_field = "F9AB7682F64A4F93F6F4A7A435A5AA53", hash_generated_field = "AD4F2B698EC37BEC9EEE873CE57E921D")

    private boolean isBound = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.864 -0500", hash_original_field = "FE9DA13376C8E122CBD408138D03A83A", hash_generated_field = "867B564705311576908006F0E51C1B9C")

    private final Object acceptLock = new Object();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.867 -0500", hash_original_method = "073E2905C9482C63193DCF1A83313D92", hash_generated_method = "D124815A8043018D8E4A22E012A87AC3")
    
public ServerSocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.socket = new ServerSocketAdapter(this);
        this.impl = socket.getImpl$();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.869 -0500", hash_original_method = "0B1D553D9DA92AA497AE372DB2D8B920", hash_generated_method = "68C160F63D94FCCDA2C27B0EBE0C8E9F")
    
@Override public ServerSocket socket() {
        return socket;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.872 -0500", hash_original_method = "B7A0B638220973E2E0E163125709103A", hash_generated_method = "F4AACB29823F37ACB944C160C6F44F3E")
    
@Override public SocketChannel accept() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        if (!isBound) {
            throw new NotYetBoundException();
        }

        // Create an empty socket channel. This will be populated by ServerSocketAdapter.accept.
        SocketChannelImpl result = new SocketChannelImpl(provider(), false);
        boolean connected = false;
        try {
            begin();
            synchronized (acceptLock) {
                synchronized (blockingLock()) {
                    do {
                        try {
                            socket.implAccept(result);
                            // select successfully, break out immediately.
                            break;
                        } catch (SocketTimeoutException e) {
                            // continue to accept if the channel is in blocking mode.
                            // TODO: does this make sense? why does blocking imply no timeouts?
                        }
                    } while (isBlocking());
                }
            }
        } finally {
            end(result.socket().isConnected());
        }
        return result.socket().isConnected() ? result : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.875 -0500", hash_original_method = "691B92594A92F5155DBD81F8E2ED268A", hash_generated_method = "A9D4FCB8A96C640F4CC14B3D3183DD7C")
    
@Override protected void implConfigureBlocking(boolean blocking) throws IOException {
        synchronized (blockingLock()) {
            IoUtils.setBlocking(impl.getFD$(), blocking);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.877 -0500", hash_original_method = "1ADA3F28F78BF67A471F8136E0D07F3B", hash_generated_method = "D9ABD9394A82222F80A00D0F7304A973")
    
synchronized protected void implCloseSelectableChannel() throws IOException {
        if (!socket.isClosed()) {
            socket.close();
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.880 -0500", hash_original_method = "6D4849F20A76F796E10F0B815FB14502", hash_generated_method = "1CB94873602BD4448AD10C4D54C431E7")
    
public FileDescriptor getFD() {
        return impl.getFD$();
    }
    
    private static class ServerSocketAdapter extends ServerSocket {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.883 -0500", hash_original_field = "C548543758C2853BFD2557E575767A3A", hash_generated_field = "4409938A65C53F969FE8732C261D10D0")

        private  ServerSocketChannelImpl channelImpl;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.886 -0500", hash_original_method = "01F94E3226EECA786EFC49C8330A8199", hash_generated_method = "01F94E3226EECA786EFC49C8330A8199")
        
ServerSocketAdapter(ServerSocketChannelImpl aChannelImpl) throws IOException {
            this.channelImpl = aChannelImpl;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.888 -0500", hash_original_method = "BBE5EDFC9B689589BC654E0B103C84FF", hash_generated_method = "6472E83582D11020EDED4E443A0844E9")
        
@Override public void bind(SocketAddress localAddress, int backlog) throws IOException {
            super.bind(localAddress, backlog);
            channelImpl.isBound = true;
        }

        @DSSpec(DSCat.INTERNET)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.891 -0500", hash_original_method = "FFAB0B1226A929FA42E5D3CF52806643", hash_generated_method = "293F7FEEDA4C3BC2516C104E6D67C9E5")
        
@Override public Socket accept() throws IOException {
            if (!channelImpl.isBound) {
                throw new IllegalBlockingModeException();
            }
            SocketChannel sc = channelImpl.accept();
            if (sc == null) {
                throw new IllegalBlockingModeException();
            }
            return sc.socket();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.894 -0500", hash_original_method = "65367E3BCE6469B06918214294C7E857", hash_generated_method = "7377020180C9A3684EC7201610ABE9E7")
        
public Socket implAccept(SocketChannelImpl clientSocketChannel) throws IOException {
            Socket clientSocket = clientSocketChannel.socket();
            boolean connectOK = false;
            try {
                synchronized (this) {
                    super.implAccept(clientSocket);
                    clientSocketChannel.setConnected();
                    clientSocketChannel.setBound(true);
                    clientSocketChannel.finishAccept();
                }
                connectOK = true;
            } finally {
                if (!connectOK) {
                    clientSocket.close();
                }
            }
            return clientSocket;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.897 -0500", hash_original_method = "9062324EB68516522A00021BE06AA12D", hash_generated_method = "4980814ED7F3FC6EF04272E197591CD0")
        
@Override public ServerSocketChannel getChannel() {
            return channelImpl;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.900 -0500", hash_original_method = "F11CC1C6B1751A820DF0839300E56C28", hash_generated_method = "C9EA9BB263A8AADCFFEACA24BE2CB395")
        
@Override public boolean isBound() {
            return channelImpl.isBound;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.902 -0500", hash_original_method = "67582FB1AEE3F050543A066EF39FFBDB", hash_generated_method = "F85C03ACA27C169AA390BCAC4E84C4F8")
        
@Override public void bind(SocketAddress localAddress) throws IOException {
            super.bind(localAddress);
            channelImpl.isBound = true;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.905 -0500", hash_original_method = "7BB2E5C011080F2650E0866A01912B69", hash_generated_method = "045B461B82495F5B7AF98EFB1528CB1F")
        
@Override public void close() throws IOException {
            synchronized (channelImpl) {
                if (channelImpl.isOpen()) {
                    channelImpl.close();
                } else {
                    super.close();
                }
            }
        }
        
    }
    
}

