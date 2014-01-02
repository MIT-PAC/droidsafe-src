package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Closeable;
import java.io.IOException;

import android.os.Handler;





public final class BluetoothServerSocket implements Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.462 -0500", hash_original_field = "F88CEEEA2A0982472DB6E6356FAA58B9", hash_generated_field = "F88CEEEA2A0982472DB6E6356FAA58B9")
  BluetoothSocket mSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.464 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.466 -0500", hash_original_field = "9802E873B8EA5717EE98A2015B837325", hash_generated_field = "1FE65A8128C6191D245A8659A7CE6614")

    private int mMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.468 -0500", hash_original_field = "C4C8CE475840A7BBCC20161145D629A0", hash_generated_field = "87038AB4E5E932A1B60D55D89B2F688A")

    private  int mChannel;

    /**
     * Construct a socket for incoming connections.
     * @param type    type of socket
     * @param auth    require the remote device to be authenticated
     * @param encrypt require the connection to be encrypted
     * @param port    remote port
     * @throws IOException On error, for example Bluetooth not available, or
     *                     insufficient privileges
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.470 -0500", hash_original_method = "60B9AE2C87715653387DA9AC24F555A4", hash_generated_method = "60B9AE2C87715653387DA9AC24F555A4")
    
BluetoothServerSocket(int type, boolean auth, boolean encrypt, int port)
            throws IOException {
        mChannel = port;
        mSocket = new BluetoothSocket(type, -1, auth, encrypt, null, port, null);
    }

    /**
     * Block until a connection is established.
     * <p>Returns a connected {@link BluetoothSocket} on successful connection.
     * <p>Once this call returns, it can be called again to accept subsequent
     * incoming connections.
     * <p>{@link #close} can be used to abort this call from another thread.
     * @return a connected {@link BluetoothSocket}
     * @throws IOException on error, for example this call was aborted, or
     *                     timeout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.472 -0500", hash_original_method = "AD3A35A4BC06FDD4538EB43EE5EE87FA", hash_generated_method = "197C236F770D6E98404EE85B970C11D1")
    
public BluetoothSocket accept() throws IOException {
        return accept(-1);
    }

    /**
     * Block until a connection is established, with timeout.
     * <p>Returns a connected {@link BluetoothSocket} on successful connection.
     * <p>Once this call returns, it can be called again to accept subsequent
     * incoming connections.
     * <p>{@link #close} can be used to abort this call from another thread.
     * @return a connected {@link BluetoothSocket}
     * @throws IOException on error, for example this call was aborted, or
     *                     timeout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.475 -0500", hash_original_method = "A8FFD99A49FD9FF66AB961B93E165703", hash_generated_method = "A7964776620DA5218CBCD1FA7A9454F5")
    
public BluetoothSocket accept(int timeout) throws IOException {
        return mSocket.accept(timeout);
    }

    /**
     * Immediately close this socket, and release all associated resources.
     * <p>Causes blocked calls on this socket in other threads to immediately
     * throw an IOException.
     * <p>Closing the {@link BluetoothServerSocket} will <em>not</em>
     * close any {@link BluetoothSocket} received from {@link #accept()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.477 -0500", hash_original_method = "12F414D50BEA43C33E7778E55DB19BE7", hash_generated_method = "94EA0C5C48630102553B8E5810FF7517")
    
public void close() throws IOException {
        synchronized (this) {
            if (mHandler != null) {
                mHandler.obtainMessage(mMessage).sendToTarget();
            }
        }
        mSocket.close();
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.479 -0500", hash_original_method = "4ADEDE7D6DD2772B3D707BC6D3A1D1F8", hash_generated_method = "51252CAAFD1F322718E441C0D7250A91")
    
synchronized void setCloseHandler(Handler handler, int message) {
        mHandler = handler;
        mMessage = message;
    }

    /**
     * Returns the channel on which this socket is bound.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:30.481 -0500", hash_original_method = "87CE95BB5407CF3970CFD04437A2E7B9", hash_generated_method = "47B062176DB2E16DC3E4790A1FB6C83E")
    
public int getChannel() {
        return mChannel;
    }

    
}

