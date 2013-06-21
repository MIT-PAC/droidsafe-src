package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AudioSystem {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.063 -0400", hash_original_method = "6FD862A4A7340EEA0DC0B02E90C01D14", hash_generated_method = "6FD862A4A7340EEA0DC0B02E90C01D14")
        public AudioSystem ()
    {
    }


        public static final int getNumStreamTypes() {
        return NUM_STREAM_TYPES;
    }

    
        public static int muteMicrophone(boolean on) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static boolean isMicrophoneMuted() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isStreamActive(int stream, int inPastMs) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static int setParameters(String keyValuePairs) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static String getParameters(String keys) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static void setErrorCallback(ErrorCallback cb) {
        synchronized (AudioSystem.class) {
            mErrorCallback = cb;
        }
        isMicrophoneMuted();
    }

    
        private static void errorCallbackFromNative(int error) {
        ErrorCallback errorCallback = null;
        synchronized (AudioSystem.class) {
            if (mErrorCallback != null) {
                errorCallback = mErrorCallback;
            }
        }
        if (errorCallback != null) {
            errorCallback.onError(error);
        }
    }

    
        public static int setDeviceConnectionState(int device, int state, String device_address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getDeviceConnectionState(int device, String device_address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int setPhoneState(int state) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int setRingerMode(int mode, int mask) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int setForceUse(int usage, int config) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getForceUse(int usage) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int initStreamVolume(int stream, int indexMin, int indexMax) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int setStreamVolumeIndex(int stream, int index) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getStreamVolumeIndex(int stream) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getDevicesForStream(int stream) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public interface ErrorCallback
    {
        
        void onError(int error);
    }
    
    public static final int STREAM_VOICE_CALL = 0;
    public static final int STREAM_SYSTEM = 1;
    public static final int STREAM_RING = 2;
    public static final int STREAM_MUSIC = 3;
    public static final int STREAM_ALARM = 4;
    public static final int STREAM_NOTIFICATION = 5;
    public static final int STREAM_BLUETOOTH_SCO = 6;
    public static final int STREAM_SYSTEM_ENFORCED = 7;
    public static final int STREAM_DTMF = 8;
    public static final int STREAM_TTS = 9;
    public static final int NUM_STREAMS = 5;
    private static final int NUM_STREAM_TYPES = 10;
    public static final int MODE_INVALID            = -2;
    public static final int MODE_CURRENT            = -1;
    public static final int MODE_NORMAL             = 0;
    public static final int MODE_RINGTONE           = 1;
    public static final int MODE_IN_CALL            = 2;
    public static final int MODE_IN_COMMUNICATION   = 3;
    public static final int NUM_MODES               = 4;
    @Deprecated public static final int ROUTE_EARPIECE          = (1 << 0);
    @Deprecated public static final int ROUTE_SPEAKER           = (1 << 1);
    @Deprecated public static final int ROUTE_BLUETOOTH = (1 << 2);
    @Deprecated public static final int ROUTE_BLUETOOTH_SCO     = (1 << 2);
    @Deprecated public static final int ROUTE_HEADSET           = (1 << 3);
    @Deprecated public static final int ROUTE_BLUETOOTH_A2DP    = (1 << 4);
    @Deprecated public static final int ROUTE_ALL               = 0xFFFFFFFF;
    public static final int AUDIO_STATUS_OK = 0;
    public static final int AUDIO_STATUS_ERROR = 1;
    public static final int AUDIO_STATUS_SERVER_DIED = 100;
    private static ErrorCallback mErrorCallback;
    public static final int DEVICE_OUT_EARPIECE = 0x1;
    public static final int DEVICE_OUT_SPEAKER = 0x2;
    public static final int DEVICE_OUT_WIRED_HEADSET = 0x4;
    public static final int DEVICE_OUT_WIRED_HEADPHONE = 0x8;
    public static final int DEVICE_OUT_BLUETOOTH_SCO = 0x10;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 0x20;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 0x40;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP = 0x80;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 0x100;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 0x200;
    public static final int DEVICE_OUT_AUX_DIGITAL = 0x400;
    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = 0x800;
    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = 0x1000;
    public static final int DEVICE_OUT_DEFAULT = 0x8000;
    public static final int DEVICE_IN_COMMUNICATION = 0x10000;
    public static final int DEVICE_IN_AMBIENT = 0x20000;
    public static final int DEVICE_IN_BUILTIN_MIC1 = 0x40000;
    public static final int DEVICE_IN_BUILTIN_MIC2 = 0x80000;
    public static final int DEVICE_IN_MIC_ARRAY = 0x100000;
    public static final int DEVICE_IN_BLUETOOTH_SCO_HEADSET = 0x200000;
    public static final int DEVICE_IN_WIRED_HEADSET = 0x400000;
    public static final int DEVICE_IN_AUX_DIGITAL = 0x800000;
    public static final int DEVICE_IN_DEFAULT = 0x80000000;
    public static final int DEVICE_STATE_UNAVAILABLE = 0;
    public static final int DEVICE_STATE_AVAILABLE = 1;
    private static final int NUM_DEVICE_STATES = 1;
    public static final int PHONE_STATE_OFFCALL = 0;
    public static final int PHONE_STATE_RINGING = 1;
    public static final int PHONE_STATE_INCALL = 2;
    public static final int FORCE_NONE = 0;
    public static final int FORCE_SPEAKER = 1;
    public static final int FORCE_HEADPHONES = 2;
    public static final int FORCE_BT_SCO = 3;
    public static final int FORCE_BT_A2DP = 4;
    public static final int FORCE_WIRED_ACCESSORY = 5;
    public static final int FORCE_BT_CAR_DOCK = 6;
    public static final int FORCE_BT_DESK_DOCK = 7;
    public static final int FORCE_ANALOG_DOCK = 8;
    public static final int FORCE_DIGITAL_DOCK = 9;
    private static final int NUM_FORCE_CONFIG = 10;
    public static final int FORCE_DEFAULT = FORCE_NONE;
    public static final int FOR_COMMUNICATION = 0;
    public static final int FOR_MEDIA = 1;
    public static final int FOR_RECORD = 2;
    public static final int FOR_DOCK = 3;
    private static final int NUM_FORCE_USE = 4;
}

