package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.ParcelFileDescriptor;
import android.util.Log;



public abstract class BluetoothHealthCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:20.015 -0500", hash_original_field = "642BDE9D66CC618D4867D292C96D4AE8", hash_generated_field = "382730F49298B348E501E4E6F20F9E07")

    private static final String TAG = "BluetoothHealthCallback";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.475 -0400", hash_original_method = "248F99D825023B041C440E742D314E3D", hash_generated_method = "248F99D825023B041C440E742D314E3D")
    public BluetoothHealthCallback ()
    {
        //Synthesized constructor
    }

    /**
     * Callback to inform change in registration state of the health
     * application.
     * <p> This callback is called on the binder thread (not on the UI thread)
     *
     * @param config Bluetooth Health app configuration
     * @param status Success or failure of the registration or unregistration
     *            calls. Can be one of
     *            {@link BluetoothHealth#APP_CONFIG_REGISTRATION_SUCCESS} or
     *            {@link BluetoothHealth#APP_CONFIG_REGISTRATION_FAILURE} or
     *            {@link BluetoothHealth#APP_CONFIG_UNREGISTRATION_SUCCESS} or
     *            {@link BluetoothHealth#APP_CONFIG_UNREGISTRATION_FAILURE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:20.016 -0500", hash_original_method = "E5722E3313A7E9ED90B679A7B4C5AF2F", hash_generated_method = "08DB39347D00CD0ACECDA317DC22500C")
    public void onHealthAppConfigurationStatusChange(BluetoothHealthAppConfiguration config,
            int status) {
        Log.d(TAG, "onHealthAppConfigurationStatusChange: " + config + "Status: " + status);
    }

    /**
     * Callback to inform change in channel state.
     * <p> Its the responsibility of the implementor of this callback to close the
     * parcel file descriptor when done. This callback is called on the Binder
     * thread (not the UI thread)
     *
     * @param config The Health app configutation
     * @param device The Bluetooth Device
     * @param prevState The previous state of the channel
     * @param newState The new state of the channel.
     * @param fd The Parcel File Descriptor when the channel state is connected.
     * @param channelId The id associated with the channel. This id will be used
     *            in future calls like when disconnecting the channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:20.017 -0500", hash_original_method = "C3B7CE27D41B26760CE03C19222744F6", hash_generated_method = "CC2054EA2845F5679CED0538D6BAC037")
    public void onHealthChannelStateChange(BluetoothHealthAppConfiguration config,
            BluetoothDevice device, int prevState, int newState, ParcelFileDescriptor fd,
            int channelId) {
        Log.d(TAG, "onHealthChannelStateChange: " + config + "Device: " + device +
              "prevState:" + prevState + "newState:" + newState + "ParcelFd:" + fd +
              "ChannelId:" + channelId);
    }
}

