package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

public interface BluetoothProfile {

    
    public static final String EXTRA_STATE = "android.bluetooth.profile.extra.STATE";

    
    public static final String EXTRA_PREVIOUS_STATE =
        "android.bluetooth.profile.extra.PREVIOUS_STATE";

    
    public static final int STATE_DISCONNECTED  = 0;
    
    public static final int STATE_CONNECTING    = 1;
    
    public static final int STATE_CONNECTED     = 2;
    
    public static final int STATE_DISCONNECTING = 3;

    
    public static final int HEADSET = 1;

    
    public static final int A2DP = 2;

    
    public static final int HEALTH = 3;

    
    public static final int INPUT_DEVICE = 4;

    
    public static final int PAN = 5;

    
    public static final int PBAP = 6;

    
    public static final int PRIORITY_AUTO_CONNECT = 1000;

    
    public static final int PRIORITY_ON = 100;

    
    public static final int PRIORITY_OFF = 0;

    
    public static final int PRIORITY_UNDEFINED = -1;

    
    public List<BluetoothDevice> getConnectedDevices();

    
    public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states);

    
    public int getConnectionState(BluetoothDevice device);

    
    public interface ServiceListener {
        
        public void onServiceConnected(int profile, BluetoothProfile proxy);

        
        public void onServiceDisconnected(int profile);
    }
}
