package android.bluetooth;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import android.os.ParcelUuid;
import android.os.RemoteException;





public final class BluetoothSocket implements Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.676 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.676 -0400", hash_original_field = "E34C72FF56A1DC3BE5FEA16F9D3434DA", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

    private BluetoothDevice mDevice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.676 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "C679AE506A0300BA50CA43522D6BE5D0")

    private String mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.676 -0400", hash_original_field = "C48407536C7F199FC620DD2118C5A84A", hash_generated_field = "3191C0AB3DB2584DC3613597E5CC982E")

    private boolean mAuth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.676 -0400", hash_original_field = "B2804E3D56E4FE942721CA5EFD2591CE", hash_generated_field = "78F0639AC30C19DE7E3FFDD893FC121E")

    private boolean mEncrypt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.676 -0400", hash_original_field = "AC8BA05A72AEC18F12DD0E8C012B9FFC", hash_generated_field = "CFA2E3DEB76A0C58A983BED8E519769D")

    private BluetoothInputStream mInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.677 -0400", hash_original_field = "7D82C7E576FE00FBAD310016B0E82A46", hash_generated_field = "5697305473443548518B8EDC71076FD9")

    private BluetoothOutputStream mOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.677 -0400", hash_original_field = "71FD4980F43C341D41A22B09CE85EDC1", hash_generated_field = "335A7AC3DAD293A1D4FCB57CB69A2BE2")

    private SdpHelper mSdp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.677 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.677 -0400", hash_original_field = "45397C00BD936ACD719ECB0215AC84B3", hash_generated_field = "562C7965DFEE94A8FAD805D0C3C61AE8")

    private SocketState mSocketState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.677 -0400", hash_original_field = "D99C4DF571068C060F9624A3098FE796", hash_generated_field = "84894B859EFD3A6EA8E631834B51FE53")

    private ReentrantReadWriteLock mLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.677 -0400", hash_original_field = "9B8B433F35F983C54562F3D730DD2ED1", hash_generated_field = "B0D39A1385C12695E9EDF4334C6BEECE")

    private int mSocketData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.680 -0400", hash_original_method = "68735DD1EF1ADFA6D7D03EB1187FF72F", hash_generated_method = "823D75323C4F90EC6B292EEB2FF8A389")
      BluetoothSocket(int type, int fd, boolean auth, boolean encrypt,
            BluetoothDevice device, int port, ParcelUuid uuid) throws IOException {
        addTaint(fd);
        if(type == BluetoothSocket.TYPE_RFCOMM && uuid == null && fd == -1)        
        {
            if(port < 1 || port > MAX_RFCOMM_CHANNEL)            
            {
                IOException varCE675CAF7DE9635BFA2C625A8BD4C1DD_1741996866 = new IOException("Invalid RFCOMM channel: " + port);
                varCE675CAF7DE9635BFA2C625A8BD4C1DD_1741996866.addTaint(taint);
                throw varCE675CAF7DE9635BFA2C625A8BD4C1DD_1741996866;
            } //End block
        } //End block
        if(uuid == null)        
        {
            mPort = port;
            mSdp = null;
        } //End block
        else
        {
            mSdp = new SdpHelper(device, uuid);
            mPort = -1;
        } //End block
        mType = type;
        mAuth = auth;
        mEncrypt = encrypt;
        mDevice = device;
        if(device == null)        
        {
            mAddress = null;
        } //End block
        else
        {
            mAddress = device.getAddress();
        } //End block
        if(fd == -1)        
        {
            initSocketNative();
        } //End block
        else
        {
            initSocketFromFdNative(fd);
        } //End block
        mInputStream = new BluetoothInputStream(this);
        mOutputStream = new BluetoothOutputStream(this);
        mSocketState = SocketState.INIT;
        mLock = new ReentrantReadWriteLock();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.681 -0400", hash_original_method = "C8329D18FDDAB97E8C009C3EF70FA11B", hash_generated_method = "C7D802D148BA1741340B08B559B6DA2B")
    private  BluetoothSocket(int type, int fd, boolean auth, boolean encrypt, String address,
            int port) throws IOException {
        this(type, fd, auth, encrypt, new BluetoothDevice(address), port, null);
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(encrypt);
        addTaint(auth);
        addTaint(fd);
        addTaint(type);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.681 -0400", hash_original_method = "6187FAF262C27B43BD19556B133B66CD", hash_generated_method = "BCF7108A8E63404F27A6C9EAB9DDD65C")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            close();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //close();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.682 -0400", hash_original_method = "35545D04908740DE675063D7F1E138DB", hash_generated_method = "90371FA1D91794BD6F5B6FC386CAE7A4")
    public void connect() throws IOException {
        mLock.readLock().lock();
        try 
        {
            if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_1017325482 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_1017325482.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_1017325482;
            }
            if(mSdp != null)            
            {
                mPort = mSdp.doSdp();
            } //End block
            connectNative();
            mSocketState = SocketState.CONNECTED;
        } //End block
        finally 
        {
            mLock.readLock().unlock();
        } //End block
        // ---------- Original Method ----------
        //mLock.readLock().lock();
        //try {
            //if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            //if (mSdp != null) {
                //mPort = mSdp.doSdp();  
            //}
            //connectNative();  
            //mSocketState = SocketState.CONNECTED;
        //} finally {
            //mLock.readLock().unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.684 -0400", hash_original_method = "83CCB2B87AD744C98E63B0BB2187BAC7", hash_generated_method = "A7979D6CC3D386600AE152255ABB0766")
    public void close() throws IOException {
        mLock.readLock().lock();
        try 
        {
            if(mSocketState == SocketState.CLOSED)            
            return;
            if(mSdp != null)            
            {
                mSdp.cancel();
            } //End block
            abortNative();
        } //End block
        finally 
        {
            mLock.readLock().unlock();
        } //End block
        mLock.writeLock().lock();
        try 
        {
            mSocketState = SocketState.CLOSED;
            destroyNative();
        } //End block
        finally 
        {
            mLock.writeLock().unlock();
        } //End block
        // ---------- Original Method ----------
        //mLock.readLock().lock();
        //try {
            //if (mSocketState == SocketState.CLOSED) return;
            //if (mSdp != null) {
                //mSdp.cancel();
            //}
            //abortNative();
        //} finally {
            //mLock.readLock().unlock();
        //}
        //mLock.writeLock().lock();
        //try {
            //mSocketState = SocketState.CLOSED;
            //destroyNative();
        //} finally {
            //mLock.writeLock().unlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.684 -0400", hash_original_method = "B5CADD9AEDAFC7D30E54D77C9BCE6C15", hash_generated_method = "5CE56CFC16969FC89C18FEB8A5076DF7")
    public BluetoothDevice getRemoteDevice() {
BluetoothDevice var7230C8D7620F29F2A427B4C63F6F2324_1161313018 =         mDevice;
        var7230C8D7620F29F2A427B4C63F6F2324_1161313018.addTaint(taint);
        return var7230C8D7620F29F2A427B4C63F6F2324_1161313018;
        // ---------- Original Method ----------
        //return mDevice;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.685 -0400", hash_original_method = "3F2C344C79BB6AAED73F7DEF9A9B7E79", hash_generated_method = "027D4D1EC66CAE17EC4653277EACD7A6")
    public InputStream getInputStream() throws IOException {
InputStream var2E675DC7F4D82075BA9D940E3D1423A3_1488082151 =         mInputStream;
        var2E675DC7F4D82075BA9D940E3D1423A3_1488082151.addTaint(taint);
        return var2E675DC7F4D82075BA9D940E3D1423A3_1488082151;
        // ---------- Original Method ----------
        //return mInputStream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.686 -0400", hash_original_method = "650B33031816EC89B8DA91268C4339E3", hash_generated_method = "1DA6514E839FAB77769ACC0A89DA4D74")
    public OutputStream getOutputStream() throws IOException {
OutputStream var0F13CE399ED1997A5DFE53E1C74E6AED_2053294400 =         mOutputStream;
        var0F13CE399ED1997A5DFE53E1C74E6AED_2053294400.addTaint(taint);
        return var0F13CE399ED1997A5DFE53E1C74E6AED_2053294400;
        // ---------- Original Method ----------
        //return mOutputStream;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.687 -0400", hash_original_method = "1C0993C098E9F3E04F29E582E3A28E0E", hash_generated_method = "5FAA209F1130F6BBD04FA129857D91DB")
    public boolean isConnected() {
        boolean var46C0E0AD40483C5E79A4855A7310A2DB_1563024548 = ((mSocketState == SocketState.CONNECTED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655688284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655688284;
        // ---------- Original Method ----------
        //return (mSocketState == SocketState.CONNECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.688 -0400", hash_original_method = "97BD6115DD834EB0EC7AFA10582FE230", hash_generated_method = "C5DEE559339A707C854FC069F6DF2274")
     int bindListen() {
        mLock.readLock().lock();
        try 
        {
            if(mSocketState == SocketState.CLOSED)            
            {
            int varB88AA46DD635C30D03C606B8DB60B21F_1733344760 = (EBADFD);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345828028 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345828028;
            }
            int varFB770D3941E3020DDC64D67CFD72AD4B_259721937 = (bindListenNative());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587203737 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587203737;
        } //End block
        finally 
        {
            mLock.readLock().unlock();
        } //End block
        // ---------- Original Method ----------
        //mLock.readLock().lock();
        //try {
            //if (mSocketState == SocketState.CLOSED) return EBADFD;
            //return bindListenNative();
        //} finally {
            //mLock.readLock().unlock();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.691 -0400", hash_original_method = "7D6884496E175BC1959E5AD456C9EDAE", hash_generated_method = "304E287C3C91C5F7B4AD218E0F392313")
     BluetoothSocket accept(int timeout) throws IOException {
        addTaint(timeout);
        mLock.readLock().lock();
        try 
        {
            if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_1539876151 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_1539876151.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_1539876151;
            }
            BluetoothSocket acceptedSocket = acceptNative(timeout);
            mSocketState = SocketState.CONNECTED;
BluetoothSocket var211C1FCD7297DDAEC6DAF11FD440B9FF_1911228897 =             acceptedSocket;
            var211C1FCD7297DDAEC6DAF11FD440B9FF_1911228897.addTaint(taint);
            return var211C1FCD7297DDAEC6DAF11FD440B9FF_1911228897;
        } //End block
        finally 
        {
            mLock.readLock().unlock();
        } //End block
        // ---------- Original Method ----------
        //mLock.readLock().lock();
        //try {
            //if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            //BluetoothSocket acceptedSocket = acceptNative(timeout);
            //mSocketState = SocketState.CONNECTED;
            //return acceptedSocket;
        //} finally {
            //mLock.readLock().unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.692 -0400", hash_original_method = "4C29CF966E12F8C06463E0440971AA79", hash_generated_method = "028659A02EDC4CB67827192217492DB5")
     int available() throws IOException {
        mLock.readLock().lock();
        try 
        {
            if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_865296497 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_865296497.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_865296497;
            }
            int var6C0761548C872FF7B51791564A7FE752_597599038 = (availableNative());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242214485 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242214485;
        } //End block
        finally 
        {
            mLock.readLock().unlock();
        } //End block
        // ---------- Original Method ----------
        //mLock.readLock().lock();
        //try {
            //if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            //return availableNative();
        //} finally {
            //mLock.readLock().unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.694 -0400", hash_original_method = "C322A846AEBBCF22FFE9BDEB0ACD620E", hash_generated_method = "D300EAB7D02403E54EC17C869924460A")
     int read(byte[] b, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(b[0]);
        mLock.readLock().lock();
        try 
        {
            if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_1480483608 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_1480483608.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_1480483608;
            }
            int varC18D89DD41C9D536263C311965FCD12E_1400112891 = (readNative(b, offset, length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274951673 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274951673;
        } //End block
        finally 
        {
            mLock.readLock().unlock();
        } //End block
        // ---------- Original Method ----------
        //mLock.readLock().lock();
        //try {
            //if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            //return readNative(b, offset, length);
        //} finally {
            //mLock.readLock().unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.696 -0400", hash_original_method = "330129C8F189154F9ACBAE0208663791", hash_generated_method = "E411AFAECFF12D7D957E0262E3B86A20")
     int write(byte[] b, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(b[0]);
        mLock.readLock().lock();
        try 
        {
            if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_191492542 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_191492542.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_191492542;
            }
            int varFBABBA8EFF1901408DA0123BD6C1FFAC_1148868605 = (writeNative(b, offset, length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085156590 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085156590;
        } //End block
        finally 
        {
            mLock.readLock().unlock();
        } //End block
        // ---------- Original Method ----------
        //mLock.readLock().lock();
        //try {
            //if (mSocketState == SocketState.CLOSED) throw new IOException("socket closed");
            //return writeNative(b, offset, length);
        //} finally {
            //mLock.readLock().unlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.698 -0400", hash_original_method = "6BAFDED46378133C3A0BF44C4CFE6B9F", hash_generated_method = "5A9B472869C707AA51680B96D15C2E28")
    private void initSocketNative() throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.699 -0400", hash_original_method = "BF4307AC129B0F742AF14FA776C3AE92", hash_generated_method = "9B36C39229FAC424E672E8A35FE6956B")
    private void initSocketFromFdNative(int fd) throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.699 -0400", hash_original_method = "A190E917AF0426307B588F8F262C0530", hash_generated_method = "8F1DCF1C336367E66E46DF6AC76828BB")
    private void connectNative() throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.699 -0400", hash_original_method = "FBE8044CF5F70E438EC9FC22860EE6EE", hash_generated_method = "EFBF635200FC28BA944B525B1B5F4AAE")
    private int bindListenNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245573076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245573076;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.393 -0400", hash_original_method = "CC0EA693249E8BA7FE7333002DBC9497", hash_generated_method = "8710BA099487CF3CAC9E26508C1C065E")
    private BluetoothSocket acceptNative(int timeout) throws IOException {
    	BluetoothSocket other = new BluetoothSocket(getTaintInt(), getTaintInt(), mAuth, mEncrypt, mDevice, getTaintInt(), null);
    	return other;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.700 -0400", hash_original_method = "C51A35C76C1A11634A799600122FA541", hash_generated_method = "2B20D157216457152C44D91185A83C63")
    private int availableNative() throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408689383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408689383;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.700 -0400", hash_original_method = "E48C37FA2C3BB9EE05DC3ABFEA76998A", hash_generated_method = "8ACCAA2EA58F8CC1BDD12B269D0E272C")
    private int readNative(byte[] b, int offset, int length) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030125727 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1030125727;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.701 -0400", hash_original_method = "9C6D3B57E023222AFF04F9EC86966DB6", hash_generated_method = "3AE4EFE5CA3CFA8C0B47D9089B16FC8F")
    private int writeNative(byte[] b, int offset, int length) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097872348 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097872348;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.701 -0400", hash_original_method = "C1A11630BFE880D237827EBCB744C990", hash_generated_method = "38759B59BA1DBCA41689D75A5FC492B1")
    private void abortNative() throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.701 -0400", hash_original_method = "43A11E63B187B9E286C0B07FFFF02B2D", hash_generated_method = "6F954C75FD63E481CA955CA14599A369")
    private void destroyNative() throws IOException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.701 -0400", hash_original_method = "9145588604B9732E698BF5C8CCFBB561", hash_generated_method = "8B9BBFB3A2534E92E169969ECF6CAAFD")
     void throwErrnoNative(int errno) throws IOException {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.702 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "777D5925CD79734350BBCD8B6382CA12")

        private IBluetooth service;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.702 -0400", hash_original_field = "EF7C876F00F3ACDDD00FA671F52D0B1F", hash_generated_field = "F32BA6E8D1D3C47A781FAC74785F3420")

        private ParcelUuid uuid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.702 -0400", hash_original_field = "913F9C49DCB544E2087CEE284F4A00B7", hash_generated_field = "4C4BD2B84D38DC063EEBF65002BEBC41")

        private BluetoothDevice device;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.702 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "1FD4E0B0003E577BCD17E3FFC6049A8B")

        private int channel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.702 -0400", hash_original_field = "D5C39A1D9ACED393F835F334A1FB9206", hash_generated_field = "DD493CC1743AFC9726752FE92F51F964")

        private boolean canceled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.703 -0400", hash_original_method = "A51868EBA6894DA595209823B1E999DD", hash_generated_method = "4DA5AF61E1C15AD348A4FC40DC73CE73")
        public  SdpHelper(BluetoothDevice device, ParcelUuid uuid) {
            service = BluetoothDevice.getService();
            this.device = device;
            this.uuid = uuid;
            canceled = false;
            // ---------- Original Method ----------
            //service = BluetoothDevice.getService();
            //this.device = device;
            //this.uuid = uuid;
            //canceled = false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.705 -0400", hash_original_method = "ABBE2955D2E93EEDCAEE1A70196B3E98", hash_generated_method = "BBC8B3DAD75489C89A8990E3043D4382")
        public synchronized int doSdp() throws IOException {
            if(canceled)            
            {
            IOException var95EFEBCE13E175CD6CC876DC80AC1A40_545140019 = new IOException("Service discovery canceled");
            var95EFEBCE13E175CD6CC876DC80AC1A40_545140019.addTaint(taint);
            throw var95EFEBCE13E175CD6CC876DC80AC1A40_545140019;
            }
            channel = -1;
            boolean inProgress = false;
            try 
            {
                inProgress = service.fetchRemoteUuids(device.getAddress(), uuid, this);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            if(!inProgress)            
            {
            IOException var565D8297581F7CA3C2C462D823AF65DF_1451357395 = new IOException("Unable to start Service Discovery");
            var565D8297581F7CA3C2C462D823AF65DF_1451357395.addTaint(taint);
            throw var565D8297581F7CA3C2C462D823AF65DF_1451357395;
            }
            try 
            {
                wait(12000);
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            if(canceled)            
            {
            IOException var95EFEBCE13E175CD6CC876DC80AC1A40_991142596 = new IOException("Service discovery canceled");
            var95EFEBCE13E175CD6CC876DC80AC1A40_991142596.addTaint(taint);
            throw var95EFEBCE13E175CD6CC876DC80AC1A40_991142596;
            }
            if(channel < 1)            
            {
            IOException varC68A32FA2E14420852A57C9DE65862B7_426341141 = new IOException("Service discovery failed");
            varC68A32FA2E14420852A57C9DE65862B7_426341141.addTaint(taint);
            throw varC68A32FA2E14420852A57C9DE65862B7_426341141;
            }
            int varC485D2ED5CC4CE64FCCCCA710C7A0BB7_334909067 = (channel);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150782908 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150782908;
            // ---------- Original Method ----------
            //if (canceled) throw new IOException("Service discovery canceled");
            //channel = -1;
            //boolean inProgress = false;
            //try {
                //inProgress = service.fetchRemoteUuids(device.getAddress(), uuid, this);
            //} catch (RemoteException e) {Log.e(TAG, "", e);}
            //if (!inProgress) throw new IOException("Unable to start Service Discovery");
            //try {
                //wait(12000);   
            //} catch (InterruptedException e) {}
            //if (canceled) throw new IOException("Service discovery canceled");
            //if (channel < 1) throw new IOException("Service discovery failed");
            //return channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.707 -0400", hash_original_method = "FEF65BEF127D0A814D93AD3A68812808", hash_generated_method = "21B604C4817E2C7C60EA16124B33803B")
        public synchronized void cancel() {
            if(!canceled)            
            {
                canceled = true;
                channel = -1;
                notifyAll();
            } //End block
            // ---------- Original Method ----------
            //if (!canceled) {
                //canceled = true;
                //channel = -1;
                //notifyAll();  
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.708 -0400", hash_original_method = "45AB23969E32C0B63DE906F14FED1852", hash_generated_method = "3AAC7AEA596AE02E5D787D2877934B42")
        public synchronized void onRfcommChannelFound(int channel) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if(!canceled)            
            {
                this.channel = channel;
                notifyAll();
            } //End block
            // ---------- Original Method ----------
            //if (!canceled) {
                //this.channel = channel;
                //notifyAll();  
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.708 -0400", hash_original_field = "5FA5584BC173ED96A2B87CE0CD05432B", hash_generated_field = "89C25C510E23215A46B2622E15238245")

    private static final String TAG = "BluetoothSocket";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.708 -0400", hash_original_field = "03884BD4F3B7F3EC34F7E0051C8E6105", hash_generated_field = "3B505C742D3D14A81E1CE77DB1482AEE")

    public static final int MAX_RFCOMM_CHANNEL = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.708 -0400", hash_original_field = "D6D8E44030B24C40E3FDBE4D198B4939", hash_generated_field = "D4D7ADE392144BC9F0AF79DBDD8D648B")

    static final int TYPE_RFCOMM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.709 -0400", hash_original_field = "279A480710BC076CAE480EF4C708F51D", hash_generated_field = "E80E9DDE1F4C968B13811BF0AF8A0F68")

    static final int TYPE_SCO = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.709 -0400", hash_original_field = "7252DEB771BF3A6E2887B342453E414B", hash_generated_field = "864753ED889F60CCED855A92B96BE675")

    static final int TYPE_L2CAP = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.709 -0400", hash_original_field = "7327F8FD844C58EA7DF25B11FC691137", hash_generated_field = "47330EEC00DC2AAFAF55CE6B030A50D3")

    static final int EBADFD = 77;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.709 -0400", hash_original_field = "CA09AB9F89EA35E9639830D9F1A12F1A", hash_generated_field = "E130AC1DA9B3F4409D90AD8F068B757A")

    static final int EADDRINUSE = 98;
}

