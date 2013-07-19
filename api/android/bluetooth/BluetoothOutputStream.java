package android.bluetooth;

// Droidsafe Imports
import java.io.IOException;
import java.io.OutputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class BluetoothOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.560 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "F41529E7146F039F8982FD61509E896F")

    private BluetoothSocket mSocket;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.562 -0400", hash_original_method = "6B802CCB266833E5725B115B8F18B649", hash_generated_method = "0A5737DCA899319336946825E00B057E")
      BluetoothOutputStream(BluetoothSocket s) {
        mSocket = s;
        // ---------- Original Method ----------
        //mSocket = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.563 -0400", hash_original_method = "1323B57D07CB6385C2F8CE9373488A22", hash_generated_method = "FD4CC8D718C262BFF2A44C717A5A00BB")
    public void close() throws IOException {
        mSocket.close();
        // ---------- Original Method ----------
        //mSocket.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.565 -0400", hash_original_method = "B2E185518772C6191E25665E6AAA6FD5", hash_generated_method = "DB7D3D348BD69B0B7267AB6966C95701")
    public void write(int oneByte) throws IOException {
        addTaint(oneByte);
        byte b[] = new byte[1];
        b[0] = (byte)oneByte;
        mSocket.write(b, 0, 1);
        // ---------- Original Method ----------
        //byte b[] = new byte[1];
        //b[0] = (byte)oneByte;
        //mSocket.write(b, 0, 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.566 -0400", hash_original_method = "DFA6C29609C7324702E3356FC466F21E", hash_generated_method = "5EE4EFCE06D4A71690600266B069FD77")
    public void write(byte[] b, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(b[0]);
        if(b == null)        
        {
            NullPointerException var7FDB72E8E87DACDDA631EAE3D97D35EE_1500423063 = new NullPointerException("buffer is null");
            var7FDB72E8E87DACDDA631EAE3D97D35EE_1500423063.addTaint(taint);
            throw var7FDB72E8E87DACDDA631EAE3D97D35EE_1500423063;
        } //End block
        if((offset | count) < 0 || count > b.length - offset)        
        {
            IndexOutOfBoundsException varB360A176C8915EA1DA2BBA07F3D5CB2B_1367700056 = new IndexOutOfBoundsException("invalid offset or length");
            varB360A176C8915EA1DA2BBA07F3D5CB2B_1367700056.addTaint(taint);
            throw varB360A176C8915EA1DA2BBA07F3D5CB2B_1367700056;
        } //End block
        mSocket.write(b, offset, count);
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new NullPointerException("buffer is null");
        //}
        //if ((offset | count) < 0 || count > b.length - offset) {
            //throw new IndexOutOfBoundsException("invalid offset or length");
        //}
        //mSocket.write(b, offset, count);
    }

    
}

