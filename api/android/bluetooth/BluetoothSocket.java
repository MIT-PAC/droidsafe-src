package android.bluetooth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.bluetooth.IBluetoothCallback;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BluetoothSocket implements Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.377 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.377 -0400", hash_original_field = "E34C72FF56A1DC3BE5FEA16F9D3434DA", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

    private BluetoothDevice mDevice;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.377 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "C679AE506A0300BA50CA43522D6BE5D0")

    private String mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.377 -0400", hash_original_field = "C48407536C7F199FC620DD2118C5A84A", hash_generated_field = "3191C0AB3DB2584DC3613597E5CC982E")

    private boolean mAuth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "B2804E3D56E4FE942721CA5EFD2591CE", hash_generated_field = "78F0639AC30C19DE7E3FFDD893FC121E")

    private boolean mEncrypt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "AC8BA05A72AEC18F12DD0E8C012B9FFC", hash_generated_field = "CFA2E3DEB76A0C58A983BED8E519769D")

    private BluetoothInputStream mInputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "7D82C7E576FE00FBAD310016B0E82A46", hash_generated_field = "5697305473443548518B8EDC71076FD9")

    private BluetoothOutputStream mOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "71FD4980F43C341D41A22B09CE85EDC1", hash_generated_field = "335A7AC3DAD293A1D4FCB57CB69A2BE2")

    private SdpHelper mSdp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "45397C00BD936ACD719ECB0215AC84B3", hash_generated_field = "562C7965DFEE94A8FAD805D0C3C61AE8")

    private SocketState mSocketState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "D99C4DF571068C060F9624A3098FE796", hash_generated_field = "84894B859EFD3A6EA8E631834B51FE53")

    private ReentrantReadWriteLock mLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.378 -0400", hash_original_field = "9B8B433F35F983C54562F3D730DD2ED1", hash_generated_field = "B0D39A1385C12695E9EDF4334C6BEECE")

    private int mSocketData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.382 -0400", hash_original_method = "68735DD1EF1ADFA6D7D03EB1187FF72F", hash_generated_method = "87B65270384B05A02D8EAEF6356746B7")
      BluetoothSocket(int type, int fd, boolean auth, boolean encrypt,
            BluetoothDevice device, int port, ParcelUuid uuid) throws IOException {
        addTaint(fd);
    if(type == BluetoothSocket.TYPE_RFCOMM && uuid == null && fd == -1)        
        {
    if(port < 1 || port > MAX_RFCOMM_CHANNEL)            
            {
                IOException varCE675CAF7DE9635BFA2C625A8BD4C1DD_1016359902 = new IOException("Invalid RFCOMM channel: " + port);
                varCE675CAF7DE9635BFA2C625A8BD4C1DD_1016359902.addTaint(taint);
                throw varCE675CAF7DE9635BFA2C625A8BD4C1DD_1016359902;
            } 
        } 
    if(uuid == null)        
        {
            mPort = port;
            mSdp = null;
        } 
        else
        {
            mSdp = new SdpHelper(device, uuid);
            mPort = -1;
        } 
        mType = type;
        mAuth = auth;
        mEncrypt = encrypt;
        mDevice = device;
    if(device == null)        
        {
            mAddress = null;
        } 
        else
        {
            mAddress = device.getAddress();
        } 
    if(fd == -1)        
        {
            initSocketNative();
        } 
        else
        {
            initSocketFromFdNative(fd);
        } 
        mInputStream = new BluetoothInputStream(this);
        mOutputStream = new BluetoothOutputStream(this);
        mSocketState = SocketState.INIT;
        mLock = new ReentrantReadWriteLock();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.383 -0400", hash_original_method = "C8329D18FDDAB97E8C009C3EF70FA11B", hash_generated_method = "C7D802D148BA1741340B08B559B6DA2B")
    private  BluetoothSocket(int type, int fd, boolean auth, boolean encrypt, String address,
            int port) throws IOException {
        this(type, fd, auth, encrypt, new BluetoothDevice(address), port, null);
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(encrypt);
        addTaint(auth);
        addTaint(fd);
        addTaint(type);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.384 -0400", hash_original_method = "6187FAF262C27B43BD19556B133B66CD", hash_generated_method = "BCF7108A8E63404F27A6C9EAB9DDD65C")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            close();
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.384 -0400", hash_original_method = "35545D04908740DE675063D7F1E138DB", hash_generated_method = "B0D7891C2BAC245976616CB966D7C451")
    public void connect() throws IOException {
        mLock.readLock().lock();
        try 
        {
    if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_1503715817 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_1503715817.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_1503715817;
            }
    if(mSdp != null)            
            {
                mPort = mSdp.doSdp();
            } 
            connectNative();
            mSocketState = SocketState.CONNECTED;
        } 
        finally 
        {
            mLock.readLock().unlock();
        } 
        
        
        
            
            
                
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.385 -0400", hash_original_method = "83CCB2B87AD744C98E63B0BB2187BAC7", hash_generated_method = "A7979D6CC3D386600AE152255ABB0766")
    public void close() throws IOException {
        mLock.readLock().lock();
        try 
        {
    if(mSocketState == SocketState.CLOSED)            
            return;
    if(mSdp != null)            
            {
                mSdp.cancel();
            } 
            abortNative();
        } 
        finally 
        {
            mLock.readLock().unlock();
        } 
        mLock.writeLock().lock();
        try 
        {
            mSocketState = SocketState.CLOSED;
            destroyNative();
        } 
        finally 
        {
            mLock.writeLock().unlock();
        } 
        
        
        
            
            
                
            
            
        
            
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.386 -0400", hash_original_method = "B5CADD9AEDAFC7D30E54D77C9BCE6C15", hash_generated_method = "ACC30C4AF254B7EA87762B388B97B905")
    public BluetoothDevice getRemoteDevice() {
BluetoothDevice var7230C8D7620F29F2A427B4C63F6F2324_2136406366 =         mDevice;
        var7230C8D7620F29F2A427B4C63F6F2324_2136406366.addTaint(taint);
        return var7230C8D7620F29F2A427B4C63F6F2324_2136406366;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.386 -0400", hash_original_method = "3F2C344C79BB6AAED73F7DEF9A9B7E79", hash_generated_method = "5871AD75F4E87DC2296E3F9014A83D76")
    public InputStream getInputStream() throws IOException {
InputStream var2E675DC7F4D82075BA9D940E3D1423A3_1871249442 =         mInputStream;
        var2E675DC7F4D82075BA9D940E3D1423A3_1871249442.addTaint(taint);
        return var2E675DC7F4D82075BA9D940E3D1423A3_1871249442;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.386 -0400", hash_original_method = "650B33031816EC89B8DA91268C4339E3", hash_generated_method = "8F2AFC145B44817B9F65F7D128C7FF8E")
    public OutputStream getOutputStream() throws IOException {
OutputStream var0F13CE399ED1997A5DFE53E1C74E6AED_69062262 =         mOutputStream;
        var0F13CE399ED1997A5DFE53E1C74E6AED_69062262.addTaint(taint);
        return var0F13CE399ED1997A5DFE53E1C74E6AED_69062262;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.387 -0400", hash_original_method = "1C0993C098E9F3E04F29E582E3A28E0E", hash_generated_method = "9CBD043237F74A841AA5CDD96C4BC3F8")
    public boolean isConnected() {
        boolean var46C0E0AD40483C5E79A4855A7310A2DB_2071130150 = ((mSocketState == SocketState.CONNECTED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875005537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_875005537;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.387 -0400", hash_original_method = "97BD6115DD834EB0EC7AFA10582FE230", hash_generated_method = "C22133C5BF13CDC036C679781FDF76AC")
     int bindListen() {
        mLock.readLock().lock();
        try 
        {
    if(mSocketState == SocketState.CLOSED)            
            {
            int varB88AA46DD635C30D03C606B8DB60B21F_2014468685 = (EBADFD);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645163958 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645163958;
            }
            int varFB770D3941E3020DDC64D67CFD72AD4B_75345623 = (bindListenNative());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345910488 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345910488;
        } 
        finally 
        {
            mLock.readLock().unlock();
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.388 -0400", hash_original_method = "7D6884496E175BC1959E5AD456C9EDAE", hash_generated_method = "64664A2F6CF593339F3CAA613C6CBDBD")
     BluetoothSocket accept(int timeout) throws IOException {
        addTaint(timeout);
        mLock.readLock().lock();
        try 
        {
    if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_1272371200 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_1272371200.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_1272371200;
            }
            BluetoothSocket acceptedSocket = acceptNative(timeout);
            mSocketState = SocketState.CONNECTED;
BluetoothSocket var211C1FCD7297DDAEC6DAF11FD440B9FF_1789648003 =             acceptedSocket;
            var211C1FCD7297DDAEC6DAF11FD440B9FF_1789648003.addTaint(taint);
            return var211C1FCD7297DDAEC6DAF11FD440B9FF_1789648003;
        } 
        finally 
        {
            mLock.readLock().unlock();
        } 
        
        
        
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.388 -0400", hash_original_method = "4C29CF966E12F8C06463E0440971AA79", hash_generated_method = "7045920E338CF3479928F35EF262F39F")
     int available() throws IOException {
        mLock.readLock().lock();
        try 
        {
    if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_899685936 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_899685936.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_899685936;
            }
            int var6C0761548C872FF7B51791564A7FE752_1295728590 = (availableNative());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013851455 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013851455;
        } 
        finally 
        {
            mLock.readLock().unlock();
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.389 -0400", hash_original_method = "C322A846AEBBCF22FFE9BDEB0ACD620E", hash_generated_method = "500C38A706C2CD05B8C33D2D63EF938F")
     int read(byte[] b, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(b[0]);
        mLock.readLock().lock();
        try 
        {
    if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_1904133342 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_1904133342.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_1904133342;
            }
            int varC18D89DD41C9D536263C311965FCD12E_1717959484 = (readNative(b, offset, length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573608846 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573608846;
        } 
        finally 
        {
            mLock.readLock().unlock();
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.390 -0400", hash_original_method = "330129C8F189154F9ACBAE0208663791", hash_generated_method = "C7F3503132B45E51DF1E5337F081FC26")
     int write(byte[] b, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(b[0]);
        mLock.readLock().lock();
        try 
        {
    if(mSocketState == SocketState.CLOSED)            
            {
            IOException var5459B998E5CC9DF81A064696FBF5CD9C_1964070381 = new IOException("socket closed");
            var5459B998E5CC9DF81A064696FBF5CD9C_1964070381.addTaint(taint);
            throw var5459B998E5CC9DF81A064696FBF5CD9C_1964070381;
            }
            int varFBABBA8EFF1901408DA0123BD6C1FFAC_1439729716 = (writeNative(b, offset, length));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584458567 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584458567;
        } 
        finally 
        {
            mLock.readLock().unlock();
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.391 -0400", hash_original_method = "6BAFDED46378133C3A0BF44C4CFE6B9F", hash_generated_method = "5A9B472869C707AA51680B96D15C2E28")
    private void initSocketNative() throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.391 -0400", hash_original_method = "BF4307AC129B0F742AF14FA776C3AE92", hash_generated_method = "9B36C39229FAC424E672E8A35FE6956B")
    private void initSocketFromFdNative(int fd) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.392 -0400", hash_original_method = "A190E917AF0426307B588F8F262C0530", hash_generated_method = "8F1DCF1C336367E66E46DF6AC76828BB")
    private void connectNative() throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.392 -0400", hash_original_method = "FBE8044CF5F70E438EC9FC22860EE6EE", hash_generated_method = "F21A27188FBFB26171FC1A5486A6D58E")
    private int bindListenNative() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938161575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938161575;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.393 -0400", hash_original_method = "CC0EA693249E8BA7FE7333002DBC9497", hash_generated_method = "8710BA099487CF3CAC9E26508C1C065E")
    private BluetoothSocket acceptNative(int timeout) throws IOException {
    	BluetoothSocket other = new BluetoothSocket(getTaintInt(), getTaintInt(), mAuth, mEncrypt, mDevice, getTaintInt(), null);
    	return other;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.393 -0400", hash_original_method = "C51A35C76C1A11634A799600122FA541", hash_generated_method = "FA349C21A3C5F83BD2F1C2F1B83285FF")
    private int availableNative() throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071106016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071106016;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.394 -0400", hash_original_method = "E48C37FA2C3BB9EE05DC3ABFEA76998A", hash_generated_method = "99627AB1DD53760827EB168934A397EA")
    private int readNative(byte[] b, int offset, int length) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691624180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691624180;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.394 -0400", hash_original_method = "9C6D3B57E023222AFF04F9EC86966DB6", hash_generated_method = "B4268C1221B6ECA02E4E3EF570668212")
    private int writeNative(byte[] b, int offset, int length) throws IOException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671713724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671713724;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.395 -0400", hash_original_method = "C1A11630BFE880D237827EBCB744C990", hash_generated_method = "38759B59BA1DBCA41689D75A5FC492B1")
    private void abortNative() throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.395 -0400", hash_original_method = "43A11E63B187B9E286C0B07FFFF02B2D", hash_generated_method = "6F954C75FD63E481CA955CA14599A369")
    private void destroyNative() throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.395 -0400", hash_original_method = "9145588604B9732E698BF5C8CCFBB561", hash_generated_method = "8B9BBFB3A2534E92E169969ECF6CAAFD")
     void throwErrnoNative(int errno) throws IOException {
    }

    
    private enum SocketState {
        INIT,
        CONNECTED,
        CLOSED
    }

    
    private static class SdpHelper extends IBluetoothCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.395 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "777D5925CD79734350BBCD8B6382CA12")

        private IBluetooth service;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.396 -0400", hash_original_field = "EF7C876F00F3ACDDD00FA671F52D0B1F", hash_generated_field = "F32BA6E8D1D3C47A781FAC74785F3420")

        private ParcelUuid uuid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.396 -0400", hash_original_field = "913F9C49DCB544E2087CEE284F4A00B7", hash_generated_field = "4C4BD2B84D38DC063EEBF65002BEBC41")

        private BluetoothDevice device;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.396 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "1FD4E0B0003E577BCD17E3FFC6049A8B")

        private int channel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.396 -0400", hash_original_field = "D5C39A1D9ACED393F835F334A1FB9206", hash_generated_field = "DD493CC1743AFC9726752FE92F51F964")

        private boolean canceled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.397 -0400", hash_original_method = "A51868EBA6894DA595209823B1E999DD", hash_generated_method = "4DA5AF61E1C15AD348A4FC40DC73CE73")
        public  SdpHelper(BluetoothDevice device, ParcelUuid uuid) {
            service = BluetoothDevice.getService();
            this.device = device;
            this.uuid = uuid;
            canceled = false;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.398 -0400", hash_original_method = "ABBE2955D2E93EEDCAEE1A70196B3E98", hash_generated_method = "974EF1DE7431A2C8289D418D0A391111")
        public synchronized int doSdp() throws IOException {
    if(canceled)            
            {
            IOException var95EFEBCE13E175CD6CC876DC80AC1A40_1150126008 = new IOException("Service discovery canceled");
            var95EFEBCE13E175CD6CC876DC80AC1A40_1150126008.addTaint(taint);
            throw var95EFEBCE13E175CD6CC876DC80AC1A40_1150126008;
            }
            channel = -1;
            boolean inProgress = false;
            try 
            {
                inProgress = service.fetchRemoteUuids(device.getAddress(), uuid, this);
            } 
            catch (RemoteException e)
            {
            } 
    if(!inProgress)            
            {
            IOException var565D8297581F7CA3C2C462D823AF65DF_691630808 = new IOException("Unable to start Service Discovery");
            var565D8297581F7CA3C2C462D823AF65DF_691630808.addTaint(taint);
            throw var565D8297581F7CA3C2C462D823AF65DF_691630808;
            }
            try 
            {
                wait(12000);
            } 
            catch (InterruptedException e)
            {
            } 
    if(canceled)            
            {
            IOException var95EFEBCE13E175CD6CC876DC80AC1A40_2136541538 = new IOException("Service discovery canceled");
            var95EFEBCE13E175CD6CC876DC80AC1A40_2136541538.addTaint(taint);
            throw var95EFEBCE13E175CD6CC876DC80AC1A40_2136541538;
            }
    if(channel < 1)            
            {
            IOException varC68A32FA2E14420852A57C9DE65862B7_506374438 = new IOException("Service discovery failed");
            varC68A32FA2E14420852A57C9DE65862B7_506374438.addTaint(taint);
            throw varC68A32FA2E14420852A57C9DE65862B7_506374438;
            }
            int varC485D2ED5CC4CE64FCCCCA710C7A0BB7_531533253 = (channel);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1245398108 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1245398108;
            
            
            
            
            
                
            
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.399 -0400", hash_original_method = "FEF65BEF127D0A814D93AD3A68812808", hash_generated_method = "21B604C4817E2C7C60EA16124B33803B")
        public synchronized void cancel() {
    if(!canceled)            
            {
                canceled = true;
                channel = -1;
                notifyAll();
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.400 -0400", hash_original_method = "45AB23969E32C0B63DE906F14FED1852", hash_generated_method = "3AAC7AEA596AE02E5D787D2877934B42")
        public synchronized void onRfcommChannelFound(int channel) {
            
    if(!canceled)            
            {
                this.channel = channel;
                notifyAll();
            } 
            
            
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.401 -0400", hash_original_field = "5FA5584BC173ED96A2B87CE0CD05432B", hash_generated_field = "89C25C510E23215A46B2622E15238245")

    private static final String TAG = "BluetoothSocket";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.401 -0400", hash_original_field = "03884BD4F3B7F3EC34F7E0051C8E6105", hash_generated_field = "3B505C742D3D14A81E1CE77DB1482AEE")

    public static final int MAX_RFCOMM_CHANNEL = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.402 -0400", hash_original_field = "D6D8E44030B24C40E3FDBE4D198B4939", hash_generated_field = "D4D7ADE392144BC9F0AF79DBDD8D648B")

    static final int TYPE_RFCOMM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.402 -0400", hash_original_field = "279A480710BC076CAE480EF4C708F51D", hash_generated_field = "E80E9DDE1F4C968B13811BF0AF8A0F68")

    static final int TYPE_SCO = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.402 -0400", hash_original_field = "7252DEB771BF3A6E2887B342453E414B", hash_generated_field = "864753ED889F60CCED855A92B96BE675")

    static final int TYPE_L2CAP = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.403 -0400", hash_original_field = "7327F8FD844C58EA7DF25B11FC691137", hash_generated_field = "47330EEC00DC2AAFAF55CE6B030A50D3")

    static final int EBADFD = 77;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.403 -0400", hash_original_field = "CA09AB9F89EA35E9639830D9F1A12F1A", hash_generated_field = "E130AC1DA9B3F4409D90AD8F068B757A")

    static final int EADDRINUSE = 98;
}

