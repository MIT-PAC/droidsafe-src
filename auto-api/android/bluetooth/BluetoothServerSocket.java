package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;
import java.io.Closeable;
import java.io.IOException;

public final class BluetoothServerSocket implements Closeable {
    BluetoothSocket mSocket;
    private Handler mHandler;
    private int mMessage;
    private int mChannel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:12:37.985 -0400", hash_original_method = "60B9AE2C87715653387DA9AC24F555A4", hash_generated_method = "55F1EED07CD64B93B633423CF205AF14")
    @DSModeled(DSC.SAFE)
     BluetoothServerSocket(int type, boolean auth, boolean encrypt, int port) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(encrypt);
        dsTaint.addTaint(type);
        dsTaint.addTaint(auth);
        mSocket = new BluetoothSocket(type, -1, auth, encrypt, null, port, null);
        // ---------- Original Method ----------
        //mChannel = port;
        //mSocket = new BluetoothSocket(type, -1, auth, encrypt, null, port, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:12:37.998 -0400", hash_original_method = "AD3A35A4BC06FDD4538EB43EE5EE87FA", hash_generated_method = "D61D47D5F35EFC3FFCCD46ABFFDB0B52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BluetoothSocket accept() throws IOException {
        BluetoothSocket var220BB3767BC2281FDB88F4B123425BC7_1174798434 = (accept(-1));
        return (BluetoothSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return accept(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:12:38.014 -0400", hash_original_method = "A8FFD99A49FD9FF66AB961B93E165703", hash_generated_method = "3D51CDF91F75993681E93BCE8667E414")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BluetoothSocket accept(int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        BluetoothSocket varD82E40C9FD2C77EB95F986EF235EA558_736433409 = (mSocket.accept(timeout));
        return (BluetoothSocket)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSocket.accept(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:12:38.071 -0400", hash_original_method = "12F414D50BEA43C33E7778E55DB19BE7", hash_generated_method = "B49716FFAC48DF03314C24FE50253DF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:12:38.083 -0400", hash_original_method = "4ADEDE7D6DD2772B3D707BC6D3A1D1F8", hash_generated_method = "5F3B04127DADCC25614599020898826C")
    @DSModeled(DSC.SAFE)
    synchronized void setCloseHandler(Handler handler, int message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mHandler = handler;
        //mMessage = message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 14:12:38.097 -0400", hash_original_method = "87CE95BB5407CF3970CFD04437A2E7B9", hash_generated_method = "A95D8E593BA83E2E49AA1DD0B081C86B")
    @DSModeled(DSC.SAFE)
    public int getChannel() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChannel;
    }

    
}


