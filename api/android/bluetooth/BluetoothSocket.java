package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import android.os.ParcelUuid;
import android.os.RemoteException;





public final class BluetoothSocket implements Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.609 -0500", hash_original_field = "F78B3EFC9E6672FD90BC1F5D134AF764", hash_generated_field = "89C25C510E23215A46B2622E15238245")

    private static final String TAG = "BluetoothSocket";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.612 -0500", hash_original_field = "854581A020E7E1BD18EEBDDB10F6E246", hash_generated_field = "3B505C742D3D14A81E1CE77DB1482AEE")

    public static final int MAX_RFCOMM_CHANNEL = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.614 -0500", hash_original_field = "AC2797A589090C030FA685BAF05703D4", hash_generated_field = "2FDF5EB95B0218EB68DF428C74EC09CC")

    /*package*/ static final int TYPE_RFCOMM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.616 -0500", hash_original_field = "28E26BB9EE66E34250398116541E84BA", hash_generated_field = "E80E9DDE1F4C968B13811BF0AF8A0F68")
 static final int TYPE_SCO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.619 -0500", hash_original_field = "8D90DBD8E4C66E2D57F99A74E91EFE19", hash_generated_field = "864753ED889F60CCED855A92B96BE675")
 static final int TYPE_L2CAP = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.621 -0500", hash_original_field = "490E7CCADC37F9BBC22E39A79C3B6F60", hash_generated_field = "47330EEC00DC2AAFAF55CE6B030A50D3")
 static final int EBADFD = 77;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.623 -0500", hash_original_field = "9ADC59C0F71E48BE7702150CC1EE7737", hash_generated_field = "E130AC1DA9B3F4409D90AD8F068B757A")
 static final int EADDRINUSE = 98;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.625 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")


    private  int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.627 -0500", hash_original_field = "793253818BA6C7B0BA0EE44002B9EC24", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

    private  BluetoothDevice mDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.629 -0500", hash_original_field = "64574F15B680D9134BA948BCFB67DAB8", hash_generated_field = "C679AE506A0300BA50CA43522D6BE5D0")

    private  String mAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.631 -0500", hash_original_field = "9F67C5638107895C103D21F29576D5E4", hash_generated_field = "3191C0AB3DB2584DC3613597E5CC982E")

    private  boolean mAuth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.633 -0500", hash_original_field = "51F6E8274608E11C5D7E838B21A127E3", hash_generated_field = "78F0639AC30C19DE7E3FFDD893FC121E")

    private  boolean mEncrypt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.636 -0500", hash_original_field = "1D6749799A28170BF32A766EBE0B8FE6", hash_generated_field = "CFA2E3DEB76A0C58A983BED8E519769D")

    private  BluetoothInputStream mInputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.638 -0500", hash_original_field = "8708C4B82F949AEEDFFA0224CF7239AB", hash_generated_field = "5697305473443548518B8EDC71076FD9")

    private  BluetoothOutputStream mOutputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.641 -0500", hash_original_field = "6F42F67CD91B4E5F5E41791DF1034F32", hash_generated_field = "335A7AC3DAD293A1D4FCB57CB69A2BE2")

    private  SdpHelper mSdp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.643 -0500", hash_original_field = "AAAF8A3C293EA5711E38C28140852BDE", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")


    private int mPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.647 -0500", hash_original_field = "3BBE1F641B3BAE5FA9B727FD419D433A", hash_generated_field = "562C7965DFEE94A8FAD805D0C3C61AE8")

    private SocketState mSocketState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.649 -0500", hash_original_field = "DE0546144C0231F79F781CD0682B6564", hash_generated_field = "84894B859EFD3A6EA8E631834B51FE53")

    private  ReentrantReadWriteLock mLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.652 -0500", hash_original_field = "2715B93DB0461FA918DE0009D6DCFCB9", hash_generated_field = "B0D39A1385C12695E9EDF4334C6BEECE")

    private int mSocketData;

    /**
     * Construct a BluetoothSocket.
     * @param type    type of socket
     * @param fd      fd to use for connected socket, or -1 for a new socket
     * @param auth    require the remote device to be authenticated
     * @param encrypt require the connection to be encrypted
     * @param device  remote device that this socket can connect to
     * @param port    remote port
     * @param uuid    SDP uuid
     * @throws IOException On error, for example Bluetooth not available, or
     *                     insufficient privileges
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.654 -0500", hash_original_method = "68735DD1EF1ADFA6D7D03EB1187FF72F", hash_generated_method = "68735DD1EF1ADFA6D7D03EB1187FF72F")
    
BluetoothSocket(int type, int fd, boolean auth, boolean encrypt,
            BluetoothDevice device, int port, ParcelUuid uuid) throws IOException {
        if (type == BluetoothSocket.TYPE_RFCOMM && uuid == null && fd == -1) {
            if (port < 1 || port > MAX_RFCOMM_CHANNEL) {
                throw new IOException("Invalid RFCOMM channel: " + port);
            }
        }
        if (uuid == null) {
            mPort = port;
            mSdp = null;
        } else {
            mSdp = new SdpHelper(device, uuid);
            mPort = -1;
        }
        mType = type;
        mAuth = auth;
        mEncrypt = encrypt;
        mDevice = device;
        if (device == null) {
            mAddress = null;
        } else {
            mAddress = device.getAddress();
        }
        if (fd == -1) {
            initSocketNative();
        } else {
            initSocketFromFdNative(fd);
        }
        mInputStream = new BluetoothInputStream(this);
        mOutputStream = new BluetoothOutputStream(this);
        mSocketState = SocketState.INIT;
        mLock = new ReentrantReadWriteLock();
    }

    /**
     * Construct a BluetoothSocket from address. Used by native code.
     * @param type    type of socket
     * @param fd      fd to use for connected socket, or -1 for a new socket
     * @param auth    require the remote device to be authenticated
     * @param encrypt require the connection to be encrypted
     * @param address remote device that this socket can connect to
     * @param port    remote port
     * @throws IOException On error, for example Bluetooth not available, or
     *                     insufficient privileges
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.657 -0500", hash_original_method = "C8329D18FDDAB97E8C009C3EF70FA11B", hash_generated_method = "CFB8030739B97BA355CC33540D3F7220")
    
private BluetoothSocket(int type, int fd, boolean auth, boolean encrypt, String address,
            int port) throws IOException {
        this(type, fd, auth, encrypt, new BluetoothDevice(address), port, null);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.659 -0500", hash_original_method = "6187FAF262C27B43BD19556B133B66CD", hash_generated_method = "E10B829342B17230830F7B1D41F4DD00")
    
@Override
    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /**
     * Attempt to connect to a remote device.
     * <p>This method will block until a connection is made or the connection
     * fails. If this method returns without an exception then this socket
     * is now connected.
     * <p>Creating new connections to
     * remote Bluetooth devices should not be attempted while device discovery
     * is in progress. Device discovery is a heavyweight procedure on the
     * Bluetooth adapter and will significantly slow a device connection.
     * Use {@link BluetoothAdapter#cancelDiscovery()} to cancel an ongoing
     * discovery. Discovery is not managed by the Activity,
     * but is run as a system service, so an application should always call
     * {@link BluetoothAdapter#cancelDiscovery()} even if it
     * did not directly request a discovery, just to be sure.
     * <p>{@link #close} can be used to abort this call from another thread.
     * @throws IOException on error, for example connection failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.661 -0500", hash_original_method = "35545D04908740DE675063D7F1E138DB", hash_generated_method = "93EBAC2A87C975A356B5B20873931D02")
    
public void connect() throws IOException {
        mLock.readLock().lock();
        try {
            if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");

            if (mSdp != null) {
                mPort = mSdp.doSdp();  // blocks
            }

            connectNative();  // blocks
            mSocketState = SocketState.CONNECTED;
        } finally {
            mLock.readLock().unlock();
        }
    }

    /**
     * Immediately close this socket, and release all associated resources.
     * <p>Causes blocked calls on this socket in other threads to immediately
     * throw an IOException.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.663 -0500", hash_original_method = "83CCB2B87AD744C98E63B0BB2187BAC7", hash_generated_method = "710794DFEA4563F61213BB68AAAF0AAA")
    
public void close() throws IOException {
        // abort blocking operations on the socket
        mLock.readLock().lock();
        try {
            if (mSocketState == SocketState.CLOSED) return;
            if (mSdp != null) {
                mSdp.cancel();
            }
            abortNative();
        } finally {
            mLock.readLock().unlock();
        }

        // all native calls are guaranteed to immediately return after
        // abortNative(), so this lock should immediately acquire
        mLock.writeLock().lock();
        try {
            mSocketState = SocketState.CLOSED;
            destroyNative();
        } finally {
            mLock.writeLock().unlock();
        }
    }

    /**
     * Get the remote device this socket is connecting, or connected, to.
     * @return remote device
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.666 -0500", hash_original_method = "B5CADD9AEDAFC7D30E54D77C9BCE6C15", hash_generated_method = "2DA2BB7F6FA41B5740E2FEDAC863C333")
    
public BluetoothDevice getRemoteDevice() {
        return mDevice;
    }

    /**
     * Get the input stream associated with this socket.
     * <p>The input stream will be returned even if the socket is not yet
     * connected, but operations on that stream will throw IOException until
     * the associated socket is connected.
     * @return InputStream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.668 -0500", hash_original_method = "3F2C344C79BB6AAED73F7DEF9A9B7E79", hash_generated_method = "FF8D6E9A010C0CA34745F6CB0FCC8D8D")
    
public InputStream getInputStream() throws IOException {
        return mInputStream;
    }

    /**
     * Get the output stream associated with this socket.
     * <p>The output stream will be returned even if the socket is not yet
     * connected, but operations on that stream will throw IOException until
     * the associated socket is connected.
     * @return OutputStream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.670 -0500", hash_original_method = "650B33031816EC89B8DA91268C4339E3", hash_generated_method = "25C899671F89D3D1A419C73ABBD6875A")
    
public OutputStream getOutputStream() throws IOException {
        return mOutputStream;
    }

    /**
     * Get the connection status of this socket, ie, whether there is an active connection with
     * remote device.
     * @return true if connected
     *         false if not connected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.672 -0500", hash_original_method = "1C0993C098E9F3E04F29E582E3A28E0E", hash_generated_method = "32CB958E44C866934BC578A28B4E816D")
    
public boolean isConnected() {
        return (mSocketState == SocketState.CONNECTED);
    }

    /**
     * Currently returns unix errno instead of throwing IOException,
     * so that BluetoothAdapter can check the error code for EADDRINUSE
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.674 -0500", hash_original_method = "97BD6115DD834EB0EC7AFA10582FE230", hash_generated_method = "97BD6115DD834EB0EC7AFA10582FE230")
    
int bindListen() {
        mLock.readLock().lock();
        try {
            if (mSocketState == SocketState.CLOSED) return EBADFD;
            return bindListenNative();
        } finally {
            mLock.readLock().unlock();
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.677 -0500", hash_original_method = "7D6884496E175BC1959E5AD456C9EDAE", hash_generated_method = "7D6884496E175BC1959E5AD456C9EDAE")
    
BluetoothSocket accept(int timeout) throws IOException {
        mLock.readLock().lock();
        try {
            if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");

            BluetoothSocket acceptedSocket = acceptNative(timeout);
            mSocketState = SocketState.CONNECTED;
            return acceptedSocket;
        } finally {
            mLock.readLock().unlock();
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.679 -0500", hash_original_method = "4C29CF966E12F8C06463E0440971AA79", hash_generated_method = "4C29CF966E12F8C06463E0440971AA79")
    
int available() throws IOException {
        mLock.readLock().lock();
        try {
            if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            return availableNative();
        } finally {
            mLock.readLock().unlock();
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.681 -0500", hash_original_method = "C322A846AEBBCF22FFE9BDEB0ACD620E", hash_generated_method = "C322A846AEBBCF22FFE9BDEB0ACD620E")
    
int read(byte[] b, int offset, int length) throws IOException {
        mLock.readLock().lock();
        try {
            if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            return readNative(b, offset, length);
        } finally {
            mLock.readLock().unlock();
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.684 -0500", hash_original_method = "330129C8F189154F9ACBAE0208663791", hash_generated_method = "330129C8F189154F9ACBAE0208663791")
    
int write(byte[] b, int offset, int length) throws IOException {
        mLock.readLock().lock();
        try {
            if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            return writeNative(b, offset, length);
        } finally {
            mLock.readLock().unlock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.687 -0500", hash_original_method = "6BAFDED46378133C3A0BF44C4CFE6B9F", hash_generated_method = "B3B7A9808C7A903F679A6732B2DFD46F")
    
    private void initSocketNative() throws IOException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.691 -0500", hash_original_method = "BF4307AC129B0F742AF14FA776C3AE92", hash_generated_method = "D4354584EB2F99B01578B92F535A9B56")
    
    private void initSocketFromFdNative(int fd) throws IOException{
    	//Formerly a native method
    	addTaint(fd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.694 -0500", hash_original_method = "A190E917AF0426307B588F8F262C0530", hash_generated_method = "386448654273C48F888727B1858BA821")
    
    private void connectNative() throws IOException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.698 -0500", hash_original_method = "FBE8044CF5F70E438EC9FC22860EE6EE", hash_generated_method = "32B3706F36C9D2DCD61B35A1274F915C")
    
    private int bindListenNative(){
    	//Formerly a native method
    	return getTaintInt();
    }


    
    private enum SocketState {
        INIT,
        CONNECTED,
        CLOSED;
        
        @DSModeled(DSC.SAFE)
        SocketState() {
        	
        }
    }

    
    private static class SdpHelper extends IBluetoothCallback.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.726 -0500", hash_original_field = "C66BA6443CBBC9D8DFC16F6C3ABD613F", hash_generated_field = "777D5925CD79734350BBCD8B6382CA12")

        private  IBluetooth service;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.729 -0500", hash_original_field = "909B4BF5511C2B48F96F643F8DCE297C", hash_generated_field = "F32BA6E8D1D3C47A781FAC74785F3420")

        private  ParcelUuid uuid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.731 -0500", hash_original_field = "E54C64FB9153A23B7A9A367369D80BC9", hash_generated_field = "4C4BD2B84D38DC063EEBF65002BEBC41")

        private  BluetoothDevice device;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.733 -0500", hash_original_field = "74EA75C555F6A2D54ADE0DE703DE590E", hash_generated_field = "1FD4E0B0003E577BCD17E3FFC6049A8B")

        private int channel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.735 -0500", hash_original_field = "25337299D7080CA84F8C8D9A5A2CD0C8", hash_generated_field = "DD493CC1743AFC9726752FE92F51F964")

        private boolean canceled;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.738 -0500", hash_original_method = "A51868EBA6894DA595209823B1E999DD", hash_generated_method = "5A3CFA104A72C42E88A8C9BC3EA29266")
        
public SdpHelper(BluetoothDevice device, ParcelUuid uuid) {
            service = BluetoothDevice.getService();
            this.device = device;
            this.uuid = uuid;
            canceled = false;
        }
        /**
         * Returns the RFCOMM channel for the UUID, or throws IOException
         * on failure.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.741 -0500", hash_original_method = "ABBE2955D2E93EEDCAEE1A70196B3E98", hash_generated_method = "AED426329FC184C648E215B74940863F")
        
public synchronized int doSdp() throws IOException {
            if (canceled) throw new IOException("Service discovery canceled");
            channel = -1;

            boolean inProgress = false;
            try {
                inProgress = service.fetchRemoteUuids(device.getAddress(), uuid, this);
            } catch (RemoteException e) {Log.e(TAG, "", e);}

            if (!inProgress) throw new IOException("Unable to start Service Discovery");

            try {
                /* 12 second timeout as a precaution - onRfcommChannelFound
                 * should always occur before the timeout */
                wait(12000);   // block

            } catch (InterruptedException e) {}

            if (canceled) throw new IOException("Service discovery canceled");
            if (channel < 1) throw new IOException("Service discovery failed");

            return channel;
        }
        /** Object cannot be re-used after calling cancel() */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.743 -0500", hash_original_method = "FEF65BEF127D0A814D93AD3A68812808", hash_generated_method = "E431DC0AB951D2DD9443754584959F05")
        
public synchronized void cancel() {
            if (!canceled) {
                canceled = true;
                channel = -1;
                notifyAll();  // unblock
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.745 -0500", hash_original_method = "45AB23969E32C0B63DE906F14FED1852", hash_generated_method = "08C095058C1F43DC01E5CE9D57F70A92")
        
public synchronized void onRfcommChannelFound(int channel) {
            if (!canceled) {
                this.channel = channel;
                notifyAll();  // unblock
            }
        }

        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.393 -0400", hash_original_method = "CC0EA693249E8BA7FE7333002DBC9497", hash_generated_method = "8710BA099487CF3CAC9E26508C1C065E")
    private BluetoothSocket acceptNative(int timeout) throws IOException {
    	BluetoothSocket other = new BluetoothSocket(getTaintInt(), getTaintInt(), mAuth, mEncrypt, mDevice, getTaintInt(), null);
    	return other;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.705 -0500", hash_original_method = "C51A35C76C1A11634A799600122FA541", hash_generated_method = "BEBDE46472D59239DDC373B2FB4BD396")
    
    private int availableNative() throws IOException{
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.708 -0500", hash_original_method = "E48C37FA2C3BB9EE05DC3ABFEA76998A", hash_generated_method = "4E5DC766902C2E01B48698C17B636E43")
    
    private int readNative(byte[] b, int offset, int length) throws IOException{
    	//Formerly a native method
    	addTaint(b[0]);
    	addTaint(offset);
    	addTaint(length);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.712 -0500", hash_original_method = "9C6D3B57E023222AFF04F9EC86966DB6", hash_generated_method = "4374EFD3242C00EABC79B9F658FFFAA1")
    
    private int writeNative(byte[] b, int offset, int length) throws IOException{
    	//Formerly a native method
    	addTaint(b[0]);
    	addTaint(offset);
    	addTaint(length);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.717 -0500", hash_original_method = "C1A11630BFE880D237827EBCB744C990", hash_generated_method = "C13D3B90B210DC473EAF0EEBC0B92F2A")
    
    private void abortNative() throws IOException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.720 -0500", hash_original_method = "43A11E63B187B9E286C0B07FFFF02B2D", hash_generated_method = "482B9FD611E950FA751819EA62ACC0AD")
    
    private void destroyNative() throws IOException{
    	//Formerly a native method
    }

    /**
     * Throws an IOException for given posix errno. Done natively so we can
     * use strerr to convert to string error.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.723 -0500", hash_original_method = "9145588604B9732E698BF5C8CCFBB561", hash_generated_method = "8903B5B8FD3CB27D7411DF82194974D2")
    
    void throwErrnoNative(int errno) throws IOException{
    	//Formerly a native method
    	addTaint(errno);
    }

}

