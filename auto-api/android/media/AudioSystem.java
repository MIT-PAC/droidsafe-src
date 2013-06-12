package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.DSUB;


public class AudioSystem {
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.924 -0400", hash_original_method = "2786D5971392BD395FA0BE76E8A7A088", hash_generated_method = "1E0EA87DE076318BBA62FD552AF198AF")
    public static final int getNumStreamTypes() {
        return NUM_STREAM_TYPES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.924 -0400", hash_original_method = "9B367D44E432667F677BF9DA77CD3DC8", hash_generated_method = "513DD37FD9D11545E83B303399426B0F")
    public static int muteMicrophone(boolean on) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.924 -0400", hash_original_method = "78CAA40A5D3305ABB8CC9315DD6A1A0F", hash_generated_method = "32DF80D4A1C63036FDE9FF913AD7F36D")
    public static boolean isMicrophoneMuted() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.924 -0400", hash_original_method = "F9FCCB5C78039856A76BE46A19DC6257", hash_generated_method = "E038BE109E16E41D43A6F0430464BF74")
    public static boolean isStreamActive(int stream, int inPastMs) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.924 -0400", hash_original_method = "B4D9641C4DE1BD706701A70F792CD414", hash_generated_method = "354A900A5A6B8B0E1E5128994F81FCCE")
    public static int setParameters(String keyValuePairs) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "1DDC7C8B3FBB92CC1679C9BEFD0B4D94", hash_generated_method = "1117DD3AC0934ED5EB7C407441EED993")
    public static String getParameters(String keys) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "E189F7630680D99C2D21D38897424B6B", hash_generated_method = "3F5A3211613D3E315ADB185C7C493B9E")
    public static void setErrorCallback(ErrorCallback cb) {
        synchronized (AudioSystem.class) {
            mErrorCallback = cb;
        }
        isMicrophoneMuted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "973BE0015415252B34DA0228955CD5FD", hash_generated_method = "FDAAE420C8896F6DDF7FA17E9F3B29FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "B588BC795A43C92A2189B78C749E11FA", hash_generated_method = "57A2EFEB34A07CD320F7086F6555B0E7")
    public static int setDeviceConnectionState(int device, int state, String device_address) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "C71EB513E6DC0FA637C898F2D527812F", hash_generated_method = "4D0D00E3CC5504732C87FF9F9B531410")
    public static int getDeviceConnectionState(int device, String device_address) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
        //DSFIXME:  CODE0009: Possible callback target function detected
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "4F0EFC1C327123DE77AFF255F32ED36A", hash_generated_method = "3713E8D9D3050244D2957DEBBAE90C27")
    public static int setPhoneState(int state) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "CA94792F0528B1913BAD0546E5A7F391", hash_generated_method = "AB3C62FC650D66B7DC823042D96086E9")
    public static int setRingerMode(int mode, int mask) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "30845462432E271ADA9D3D48895F88AC", hash_generated_method = "828D3EE113883F321AED9B6B99C22187")
    public static int setForceUse(int usage, int config) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "A95280F2839AACA9EE925BE52AAA2E92", hash_generated_method = "51B4945C9852B0A715FAA0EFB4B7A0D3")
    public static int getForceUse(int usage) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "DF1017BEC98550D75172F84C23E125CA", hash_generated_method = "C6D19C8914292485E8ADB93FE337499F")
    public static int initStreamVolume(int stream, int indexMin, int indexMax) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "E54CECFDDBBE7A1A6A9AFEB5356288C1", hash_generated_method = "F8028736EE05B76E2700532262146D1F")
    public static int setStreamVolumeIndex(int stream, int index) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.925 -0400", hash_original_method = "84BEE882EE4B7FA204FE13E677902DAA", hash_generated_method = "F16C311D62ABEB56D9CB5AB40CDDFADD")
    public static int getStreamVolumeIndex(int stream) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.926 -0400", hash_original_method = "47D4874FC1F89D18AA24FE9201154C0A", hash_generated_method = "8C9805C7ADBE7FA5F7C59CAEAD89E871")
    public static int getDevicesForStream(int stream) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    public interface ErrorCallback
    {
        
        void onError(int error);
    }
    
}


