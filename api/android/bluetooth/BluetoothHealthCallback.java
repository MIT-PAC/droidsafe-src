package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.ParcelFileDescriptor;
import android.util.Log;

public abstract class BluetoothHealthCallback {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.205 -0400", hash_original_method = "248F99D825023B041C440E742D314E3D", hash_generated_method = "248F99D825023B041C440E742D314E3D")
    public BluetoothHealthCallback ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.206 -0400", hash_original_method = "E5722E3313A7E9ED90B679A7B4C5AF2F", hash_generated_method = "6AA17B8B53A9CF042C811F2746EC24C0")
    public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration config,
            int status) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(status);
        addTaint(config.getTaint());
        Log.d(TAG, "onHealthAppConfigurationStatusChange: " + config + "Status: " + status);
        // ---------- Original Method ----------
        //Log.d(TAG, "onHealthAppConfigurationStatusChange: " + config + "Status: " + status);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.206 -0400", hash_original_method = "C3B7CE27D41B26760CE03C19222744F6", hash_generated_method = "FF37D655B3CF9DD43847CF9F98C84BCB")
    public void onHealthChannelStateChange(BluetoothHealthAppConfiguration config,
            BluetoothDevice device, int prevState, int newState, ParcelFileDescriptor fd,
            int channelId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(channelId);
        addTaint(fd.getTaint());
        addTaint(newState);
        addTaint(prevState);
        addTaint(device.getTaint());
        addTaint(config.getTaint());
        Log.d(TAG, "onHealthChannelStateChange: " + config + "Device: " + device +
              "prevState:" + prevState + "newState:" + newState + "ParcelFd:" + fd +
              "ChannelId:" + channelId);
        // ---------- Original Method ----------
        //Log.d(TAG, "onHealthChannelStateChange: " + config + "Device: " + device +
              //"prevState:" + prevState + "newState:" + newState + "ParcelFd:" + fd +
              //"ChannelId:" + channelId);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.207 -0400", hash_original_field = "03548F479690C14AC4F3FCED488F3399", hash_generated_field = "382730F49298B348E501E4E6F20F9E07")

    private static final String TAG = "BluetoothHealthCallback";
}

