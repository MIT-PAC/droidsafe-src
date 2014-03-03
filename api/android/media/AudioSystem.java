package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class AudioSystem {
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.744 -0500", hash_original_method = "2786D5971392BD395FA0BE76E8A7A088", hash_generated_method = "1E0EA87DE076318BBA62FD552AF198AF")
    
public static final int getNumStreamTypes() { return NUM_STREAM_TYPES; }
    
    public static int muteMicrophone(boolean on) {
        int tmp = on? 0: 1;
        return tmp;
    }
    
    public static boolean isMicrophoneMuted() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177342172 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_177342172;
    }
    
    public static boolean isStreamActive(int stream, int inPastMs) {
        return (stream > inPastMs);
    }
    
    public static int setParameters(String keyValuePairs) {
        return keyValuePairs.getTaintInt();
    }
    
    public static String getParameters(String keys) {
    	return new String();
    }

    /*
     * Registers a callback to be invoked when an error occurs.
     * @param cb the callback to run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.818 -0500", hash_original_method = "E189F7630680D99C2D21D38897424B6B", hash_generated_method = "6D9186B1DF2B6D27035DF19CE1A4D285")
    
public static void setErrorCallback(ErrorCallback cb)
    {
        synchronized (AudioSystem.class) {
            mErrorCallback = cb;
        }
        // Calling a method on AudioFlinger here makes sure that we bind to IAudioFlinger
        // binder interface death. Not doing that would result in not being notified of
        // media_server process death if no other method is called on AudioSystem that reaches
        // to AudioFlinger.
        isMicrophoneMuted();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.822 -0500", hash_original_method = "973BE0015415252B34DA0228955CD5FD", hash_generated_method = "FDAAE420C8896F6DDF7FA17E9F3B29FD")
    
private static void errorCallbackFromNative(int error)
    {
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
        return (device + state + device_address.getTaintInt());                
    }
    
    public static int getDeviceConnectionState(int device, String device_address) {
        return (device + device_address.getTaintInt());                
    }
    
    public static int setPhoneState(int state) {
        return state;
    }
    
    public static int setRingerMode(int mode, int mask) {
        return (mode + mask);
    }
    
    public static int setForceUse(int usage, int config) {
                return (usage + config);
    }
    
    public static int getForceUse(int usage) {
        return usage;
    }
    
    public static int initStreamVolume(int stream, int indexMin, int indexMax) {
        return (stream + indexMin + indexMax);
    }
    
    public static int setStreamVolumeIndex(int stream, int index) {
        return stream + index;
    }
    
    public static int getStreamVolumeIndex(int stream) {
        return stream;
    }
    
    public static int getDevicesForStream(int stream) {
        return stream;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.712 -0500", hash_original_field = "A6B9CAE819C8928B0B4F12E0E2A67209", hash_generated_field = "510AC64E3D8878D1E4E4A84AF2CB48F5")

    /*
     * If these are modified, please also update Settings.System.VOLUME_SETTINGS
     * and attrs.xml and AudioManager.java.
     */
    /* The audio stream for phone calls */
    public static final int STREAM_VOICE_CALL = 0;
    
    public interface ErrorCallback
    {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onError(int error);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.715 -0500", hash_original_field = "6311951090DC1223C48D9C5DB55C8FFD", hash_generated_field = "CF5F7FF83468A22B18D53E798BDAD312")

    public static final int STREAM_SYSTEM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.718 -0500", hash_original_field = "66A484CD0EA55F726655E1629B5C3EA7", hash_generated_field = "4F486983B65A65E525B7A932F8DF9CC0")

    public static final int STREAM_RING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.720 -0500", hash_original_field = "8A37DA3E4E40BCD980849A7B950B6EF6", hash_generated_field = "69F4A368501E64D6CAD9F12A3845AD27")

    public static final int STREAM_MUSIC = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.723 -0500", hash_original_field = "26D1528B9A9C081F09666AC97B46C939", hash_generated_field = "7E7D6F55FF3EF182D4BDE09F3A251DAD")

    public static final int STREAM_ALARM = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.725 -0500", hash_original_field = "541BC752E680A49E80E58AB343C92AAA", hash_generated_field = "C46A8EB1C212D9F7873518917272CA27")

    public static final int STREAM_NOTIFICATION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.728 -0500", hash_original_field = "717331D94737B7D37B056BBFEEF116F8", hash_generated_field = "13C7B8943EE135FAF6DEA536DD992F3E")

    public static final int STREAM_BLUETOOTH_SCO = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.731 -0500", hash_original_field = "39894F86231C1193EFA87C236D3ED3CC", hash_generated_field = "9D8D93FACA8D7E05C8360BB2BE26342C")

    public static final int STREAM_SYSTEM_ENFORCED = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.733 -0500", hash_original_field = "104CBA10B0E4D6772D29B644555B04FA", hash_generated_field = "97A3B968F12F88051CD79CD800292953")

    public static final int STREAM_DTMF = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.736 -0500", hash_original_field = "BBEBD5ED2FA39C29EEFA896444E8706F", hash_generated_field = "F9B2A6886F769385637216CF80DF08B2")

    public static final int STREAM_TTS = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.739 -0500", hash_original_field = "8494C3521F9EDE0A7B570D8C17895A02", hash_generated_field = "A9324FF4B2DECA628AE162ED36D5EF46")

    public static final int NUM_STREAMS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.741 -0500", hash_original_field = "B0FC1BFF5F2FC6B50982F73473F964FE", hash_generated_field = "8F386D54707ED4C650141F8C123BDAEB")

    private static final int NUM_STREAM_TYPES = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.755 -0500", hash_original_field = "04DD491B7A0EB1D0D633FA69AFF9D9D0", hash_generated_field = "CB067CE0D78DA21EC3ABE4A682836FE3")

    public static final int MODE_INVALID            = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.758 -0500", hash_original_field = "C698C851E3A2D5D82F900FE75BE06F47", hash_generated_field = "D41F10CDEE8C2D10D2C446365D07A27B")

    public static final int MODE_CURRENT            = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.760 -0500", hash_original_field = "A65A69A2ACF32E03502670189C23328B", hash_generated_field = "3DEED3F3E236ECDEF49ABC73C5FEF55B")

    public static final int MODE_NORMAL             = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.763 -0500", hash_original_field = "73A3C665634B11C310E8F92DB1AC30B3", hash_generated_field = "9985A2DD579C49F7C4B3A0AD7B9DBD3B")

    public static final int MODE_RINGTONE           = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.765 -0500", hash_original_field = "30406B8C4E8BCC3CE5FE0805308D0D29", hash_generated_field = "C2828592B3FF5DD54A87BF70C5A4C46F")

    public static final int MODE_IN_CALL            = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.768 -0500", hash_original_field = "1004ACE4A444735AB5DF1B3ACF217669", hash_generated_field = "ECF0DB42CAA5DAF63E9DFA4CBAC7614E")

    public static final int MODE_IN_COMMUNICATION   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.770 -0500", hash_original_field = "A416BE7061C70F02D4CACE24895DE8CF", hash_generated_field = "E43E869A6DF34F8030C98810E0594860")

    public static final int NUM_MODES               = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.773 -0500", hash_original_field = "29C9942B131694ED48379FCECB0218AB", hash_generated_field = "CFBC07A8F47B8971AFB8CA6CF232C62B")

    /** @deprecated */
    @Deprecated public static final int ROUTE_EARPIECE          = (1 << 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.776 -0500", hash_original_field = "1E2CE710DD1F493C9FDC68618BD2E4FD", hash_generated_field = "81D76342551CC40C5088F0176B2EFFC3")

    @Deprecated public static final int ROUTE_SPEAKER           = (1 << 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.779 -0500", hash_original_field = "5D7F761BACFF2D0C5DB88BF0FBC9FF02", hash_generated_field = "92640DFBB885F024C9E35666F8ACBF77")

    @Deprecated public static final int ROUTE_BLUETOOTH = (1 << 2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.782 -0500", hash_original_field = "BB730BFBE5D93D83976ACFF9F3D00B9B", hash_generated_field = "E17B661970D4FCF610648776E3AEBA2F")

    @Deprecated public static final int ROUTE_BLUETOOTH_SCO     = (1 << 2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.785 -0500", hash_original_field = "58986152F1132A6A091681824D5A3495", hash_generated_field = "FE7E21C259F1770DBA90F9A18273644B")

    @Deprecated public static final int ROUTE_HEADSET           = (1 << 3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.788 -0500", hash_original_field = "F034942BEABF0F98EE70860EE38B9243", hash_generated_field = "D221147BDF20A36B0E8E24EC704288D5")

    @Deprecated public static final int ROUTE_BLUETOOTH_A2DP    = (1 << 4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.791 -0500", hash_original_field = "5FF5ADA052864312ACC7FF0C16600434", hash_generated_field = "567C69A932118D9385BAE9BE40E086BB")

    @Deprecated public static final int ROUTE_ALL               = 0xFFFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.807 -0500", hash_original_field = "58FAB259E264A705B466940DFC46B12D", hash_generated_field = "0C60638DF987DFC7DCECB7935D5EA670")

    /* Command sucessful or Media server restarted. see ErrorCallback */
    public static final int AUDIO_STATUS_OK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.809 -0500", hash_original_field = "5A2AC413F63E11B4B03A5E47CE55D4E7", hash_generated_field = "35F626CEB9314977E8710CFB84BFD4B5")

    public static final int AUDIO_STATUS_ERROR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.811 -0500", hash_original_field = "897251ECAC3B01991B8FE2D29B8AEC55", hash_generated_field = "0D41C5B466D312262C33677695C84BA0")

    public static final int AUDIO_STATUS_SERVER_DIED = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.814 -0500", hash_original_field = "9675E0D45065C18F07BE6D8299914033", hash_generated_field = "04DD76D9C83EA526A955FFA1C319E553")

    private static ErrorCallback mErrorCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.825 -0500", hash_original_field = "4FD03E87EEEA3D4DBD058586B9BF6D6E", hash_generated_field = "B6FA6F190527A2F2163A5841A5D7B7D7")

    // output devices, be sure to update AudioManager.java also
    public static final int DEVICE_OUT_EARPIECE = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.827 -0500", hash_original_field = "83F41FF1D3542DFEA93FCC8026D9E5A8", hash_generated_field = "602BF6A217C2AC374E46AA49B69405E6")

    public static final int DEVICE_OUT_SPEAKER = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.830 -0500", hash_original_field = "1A217E35537B444ADB465A6FF60C67E8", hash_generated_field = "D108C8BC9B89E652415C25D2F3AE3F8F")

    public static final int DEVICE_OUT_WIRED_HEADSET = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.833 -0500", hash_original_field = "20FE30E136458B73D28E989CD36566F7", hash_generated_field = "92D223E861BA34AC143DFA9E62078F64")

    public static final int DEVICE_OUT_WIRED_HEADPHONE = 0x8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.835 -0500", hash_original_field = "95F740F3C80857E769B3C61150356F66", hash_generated_field = "9A4781E37B6CA711D096783B2D5D8463")

    public static final int DEVICE_OUT_BLUETOOTH_SCO = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.838 -0500", hash_original_field = "E3C36A46E26F02CD21FB67E7FA3C9B78", hash_generated_field = "44038CB306252BFE489FB68E5EF51672")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.840 -0500", hash_original_field = "B8A701F09C0F757E5C7BDBE04F0D2059", hash_generated_field = "1FACA09D0D15E7285102C700DC03EF01")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.843 -0500", hash_original_field = "941EE47EAAC9699C2D41FC48F78FBC13", hash_generated_field = "5F42FA860C916E35D2F3D438DA599BB6")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.845 -0500", hash_original_field = "E34966C9EC931A3987CAE6163CDE7871", hash_generated_field = "AB6FC4D9DCD428893F6BCE5AC0F52D89")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.848 -0500", hash_original_field = "1627E8535B7882EB3BC032C1D7DDDBA8", hash_generated_field = "74D5CDD223D3A30695075C661328A2D6")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.851 -0500", hash_original_field = "D48EE158E3572CE78901E5FC98649670", hash_generated_field = "73A5CE5D98CB439231D28B9C184E2E61")

    public static final int DEVICE_OUT_AUX_DIGITAL = 0x400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.854 -0500", hash_original_field = "FAE022ECB8807263054DD758B46C9A39", hash_generated_field = "86D6F477BF51FC7E965AF69A073AA970")

    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = 0x800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.856 -0500", hash_original_field = "1C68260D5079322D8FA2F7BC20DD7C2C", hash_generated_field = "C651F4CC2E182B5F0FFCF1A59D364A1E")

    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.859 -0500", hash_original_field = "D3C70922A0F18E6115BDAA9723949234", hash_generated_field = "FBFCB0898D89EE6E9317CE4456B28CA7")

    public static final int DEVICE_OUT_DEFAULT = 0x8000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.861 -0500", hash_original_field = "CC8D1D68B01A53A81CD2518D21572D7B", hash_generated_field = "955EBAE4BB6B7F9D2A0F84FD96A3BF7F")

    public static final int DEVICE_IN_COMMUNICATION = 0x10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.863 -0500", hash_original_field = "8B8481B7DDBA3EB696F11C46ECFE3CB6", hash_generated_field = "6C36AD2F7E7100700BFD7F9EA5EED8AD")

    public static final int DEVICE_IN_AMBIENT = 0x20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.867 -0500", hash_original_field = "1127CB2E7FD26A663B766E32E4D97F64", hash_generated_field = "8DF3B47481AA2AF62C4314C7D85927E7")

    public static final int DEVICE_IN_BUILTIN_MIC1 = 0x40000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.869 -0500", hash_original_field = "84AFC62B3EE6BEF51FCA614BF6218EA3", hash_generated_field = "8163D159BF9D50661681D090D82A722A")

    public static final int DEVICE_IN_BUILTIN_MIC2 = 0x80000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.872 -0500", hash_original_field = "A96C807AEB778433CEAA6C23743C8C70", hash_generated_field = "AF85D1256B5058722A9C3C4B06088813")

    public static final int DEVICE_IN_MIC_ARRAY = 0x100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.874 -0500", hash_original_field = "58A100416C195D403E843578660F0467", hash_generated_field = "E0A48656C9582B9C00F04DD718C8798B")

    public static final int DEVICE_IN_BLUETOOTH_SCO_HEADSET = 0x200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.877 -0500", hash_original_field = "0C0428087A86257CA757A4932E546BBA", hash_generated_field = "594FA7E65BA2FBDC53CCE3D97AE77D64")

    public static final int DEVICE_IN_WIRED_HEADSET = 0x400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.880 -0500", hash_original_field = "C12937086B65A4BDD24900E8CF2FE686", hash_generated_field = "4ED16C2332BDF59B6028C66860A84E54")

    public static final int DEVICE_IN_AUX_DIGITAL = 0x800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.882 -0500", hash_original_field = "D9A96018B4F5718F49F6262D7784E6C2", hash_generated_field = "08B385A486E1873BE5B13E7000661022")

    public static final int DEVICE_IN_DEFAULT = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.885 -0500", hash_original_field = "282500C2402507B9DC1294A711CEE85D", hash_generated_field = "9343FA98254A683896C06332332B2D3D")

    public static final int DEVICE_STATE_UNAVAILABLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.887 -0500", hash_original_field = "7EFFE212DCD48BF54281D6EEE75C8870", hash_generated_field = "FE8B3E6A860FBB7B6ACCE2C9B575AD18")

    public static final int DEVICE_STATE_AVAILABLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.890 -0500", hash_original_field = "7580BD711D7CB52B8FF74BAE50597B6D", hash_generated_field = "0D1EAFE3CEB3AE0DB528655DC4E7C181")

    private static final int NUM_DEVICE_STATES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.893 -0500", hash_original_field = "9251BE95BB3CAED8E1E48BA18757453A", hash_generated_field = "7168029A72B8A9744C8483ED3C29CC48")

    public static final int PHONE_STATE_OFFCALL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.896 -0500", hash_original_field = "8D8740FBABCCE23C341F58717A7FAAB2", hash_generated_field = "6235238C44FC957C417ACAD3F42800D5")

    public static final int PHONE_STATE_RINGING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.898 -0500", hash_original_field = "9C1E2BE9317400ABB986C9C059F292F3", hash_generated_field = "0B4914FB5279AE8A7BFC9BBC4849C2FA")

    public static final int PHONE_STATE_INCALL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.901 -0500", hash_original_field = "8529E6AF99B9C22F3C3C17759CA4FEA7", hash_generated_field = "854B22AE7A5861F66679C9C265020AB1")

    public static final int FORCE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.903 -0500", hash_original_field = "14D1181A566CDAF4D2219F68B39ECB25", hash_generated_field = "2B26C8C5E6AAF11428F73F835800944D")

    public static final int FORCE_SPEAKER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.905 -0500", hash_original_field = "01F28909FDDCA9E8A30049D3B51BF812", hash_generated_field = "6675A3D8E680E1119A3CDD38313D0695")

    public static final int FORCE_HEADPHONES = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.908 -0500", hash_original_field = "B05C901BD52E268264C81068CB4611E6", hash_generated_field = "473683EA00DA68601F1DE1012FAB98AE")

    public static final int FORCE_BT_SCO = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.911 -0500", hash_original_field = "CDFD41E161C9F586C9CF7B06A19E7731", hash_generated_field = "4EE32669A42A8152690BEC11A1504E51")

    public static final int FORCE_BT_A2DP = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.913 -0500", hash_original_field = "AF9E6A9893DF28C6AB9DC08E20E9528E", hash_generated_field = "BC298A70C15613152A65C199C40BF5F6")

    public static final int FORCE_WIRED_ACCESSORY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.916 -0500", hash_original_field = "1D2A17651982EECC33246244EF287ED3", hash_generated_field = "2196F336876B0F842E77F8C94AE309C6")

    public static final int FORCE_BT_CAR_DOCK = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.919 -0500", hash_original_field = "5FC201FC52A1264A8F454CC4A1414F35", hash_generated_field = "7768E6EB3B1462B19502F2BF3489A13D")

    public static final int FORCE_BT_DESK_DOCK = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.921 -0500", hash_original_field = "E3D16BF7AF3D3C9B2B4CB87B8D9D6EB7", hash_generated_field = "0AB4DD390152688A0AA7EBD5F6E992D2")

    public static final int FORCE_ANALOG_DOCK = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.926 -0500", hash_original_field = "6F47C7820299DEE4CCF6AD1BDBC1CDDE", hash_generated_field = "A80B1C27254EF0E3B8CFA096BB4AD8B5")

    public static final int FORCE_DIGITAL_DOCK = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.930 -0500", hash_original_field = "9E0F9C7B93C351B080B3611EEA4A40BD", hash_generated_field = "14ED48452B3F831D3D57413E301F7F2B")

    private static final int NUM_FORCE_CONFIG = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.932 -0500", hash_original_field = "571D55788AE77A68895C799151F1450C", hash_generated_field = "B9832F568281A57229EFDE3CBE82FFD4")

    public static final int FORCE_DEFAULT = FORCE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.935 -0500", hash_original_field = "DDDBF7704D110F18692A63EA8D16815F", hash_generated_field = "66A1B811ACBD73880C3AB14B7AABE4F9")

    public static final int FOR_COMMUNICATION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.937 -0500", hash_original_field = "D8A260F77D101E5E232AF4396111F542", hash_generated_field = "841AD0B48CD7E0BA128F4F4A33A31807")

    public static final int FOR_MEDIA = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.940 -0500", hash_original_field = "6A8A722B89A16448ABF3AE92D6675986", hash_generated_field = "A9CFD7A15BD4CBA65EAD531B2B8450CC")

    public static final int FOR_RECORD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.943 -0500", hash_original_field = "265649C9608947AB142319166E536307", hash_generated_field = "EA8F8CC7B133D4AED4341CEDFBE01874")

    public static final int FOR_DOCK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.945 -0500", hash_original_field = "81E75FF9A0AAC1DC0CF06B1C359DE48D", hash_generated_field = "A9C4B6ECB431CC0BA4B1FB582D61742C")

    private static final int NUM_FORCE_USE = 4;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.078 -0400", hash_original_method = "54895CB2BF1D5A08CFD79D31582209F6", hash_generated_method = "54895CB2BF1D5A08CFD79D31582209F6")
    public AudioSystem ()
    {
        //Synthesized constructor
    }
}

