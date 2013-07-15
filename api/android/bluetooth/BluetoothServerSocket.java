package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;
import java.io.Closeable;
import java.io.IOException;

public final class BluetoothServerSocket implements Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.332 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "F88CEEEA2A0982472DB6E6356FAA58B9")

    BluetoothSocket mSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.332 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.333 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "1FE65A8128C6191D245A8659A7CE6614")

    private int mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.333 -0400", hash_original_field = "8E934369C1BCE6316A2C1FFFF8C383AB", hash_generated_field = "87038AB4E5E932A1B60D55D89B2F688A")

    private int mChannel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.334 -0400", hash_original_method = "60B9AE2C87715653387DA9AC24F555A4", hash_generated_method = "6C8C8D20FE0625413B5F63B106FE8636")
      BluetoothServerSocket(int type, boolean auth, boolean encrypt, int port) throws IOException {
        mChannel = port;
        mSocket = new BluetoothSocket(type, -1, auth, encrypt, null, port, null);
        // ---------- Original Method ----------
        //mChannel = port;
        //mSocket = new BluetoothSocket(type, -1, auth, encrypt, null, port, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.334 -0400", hash_original_method = "AD3A35A4BC06FDD4538EB43EE5EE87FA", hash_generated_method = "EF917F87E71DA1AC877C8F15796D09F1")
    public BluetoothSocket accept() throws IOException {
BluetoothSocket var56B5E835905C724ABB44F3A2DE80B2CA_894002955 =         accept(-1);
        var56B5E835905C724ABB44F3A2DE80B2CA_894002955.addTaint(taint);
        return var56B5E835905C724ABB44F3A2DE80B2CA_894002955;
        // ---------- Original Method ----------
        //return accept(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.335 -0400", hash_original_method = "A8FFD99A49FD9FF66AB961B93E165703", hash_generated_method = "9CDC5E462F0D0DDCD0EBD5E30FFC6CDD")
    public BluetoothSocket accept(int timeout) throws IOException {
        addTaint(timeout);
BluetoothSocket var0E890385DCEFB41350BE22388B55AC0F_1945940108 =         mSocket.accept(timeout);
        var0E890385DCEFB41350BE22388B55AC0F_1945940108.addTaint(taint);
        return var0E890385DCEFB41350BE22388B55AC0F_1945940108;
        // ---------- Original Method ----------
        //return mSocket.accept(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.335 -0400", hash_original_method = "12F414D50BEA43C33E7778E55DB19BE7", hash_generated_method = "CE7596B108FC72E36D7852D5DD5BFB2E")
    public void close() throws IOException {
        synchronized
(this)        {
    if(mHandler != null)            
            {
                mHandler.obtainMessage(mMessage).sendToTarget();
            } //End block
        } //End block
        mSocket.close();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mHandler != null) {
                //mHandler.obtainMessage(mMessage).sendToTarget();
            //}
        //}
        //mSocket.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.336 -0400", hash_original_method = "4ADEDE7D6DD2772B3D707BC6D3A1D1F8", hash_generated_method = "00355F8C990DA5278853A6B70D6772D6")
    synchronized void setCloseHandler(Handler handler, int message) {
        mHandler = handler;
        mMessage = message;
        // ---------- Original Method ----------
        //mHandler = handler;
        //mMessage = message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.336 -0400", hash_original_method = "87CE95BB5407CF3970CFD04437A2E7B9", hash_generated_method = "AC1A8D340CCC10387ACB0A43B16B3226")
    public int getChannel() {
        int var8E934369C1BCE6316A2C1FFFF8C383AB_510543900 = (mChannel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547804338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547804338;
        // ---------- Original Method ----------
        //return mChannel;
    }

    
}

