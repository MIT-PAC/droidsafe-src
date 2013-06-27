package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AudioSystem {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.506 -0400", hash_original_method = "54895CB2BF1D5A08CFD79D31582209F6", hash_generated_method = "54895CB2BF1D5A08CFD79D31582209F6")
    public AudioSystem ()
    {
        //Synthesized constructor
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
        //DSFIXME:  CODE0012: Native static method requires manual modeling
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.596 -0400", hash_original_field = "20E6A513D498351194B1625ED7B6BF0A", hash_generated_field = "C711B92ACD8ED25A60574B5621E8FA1F")

    public static final int STREAM_VOICE_CALL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.596 -0400", hash_original_field = "1DBBF074DE7E28716842E0B41A087200", hash_generated_field = "CF5F7FF83468A22B18D53E798BDAD312")

    public static final int STREAM_SYSTEM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.596 -0400", hash_original_field = "2AC4F49FE4AEB812DF4E272F5CB22197", hash_generated_field = "4F486983B65A65E525B7A932F8DF9CC0")

    public static final int STREAM_RING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.596 -0400", hash_original_field = "24374D1611CDFE009B319C80160A8BF4", hash_generated_field = "69F4A368501E64D6CAD9F12A3845AD27")

    public static final int STREAM_MUSIC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "E75BF42E3ED726CB5A530DD7C4E6D107", hash_generated_field = "7E7D6F55FF3EF182D4BDE09F3A251DAD")

    public static final int STREAM_ALARM = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "08311EBB93566B11B953690C209299C0", hash_generated_field = "C46A8EB1C212D9F7873518917272CA27")

    public static final int STREAM_NOTIFICATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "81C74AF89BC8AE5B5DC9A75045B4961A", hash_generated_field = "13C7B8943EE135FAF6DEA536DD992F3E")

    public static final int STREAM_BLUETOOTH_SCO = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "F807973E45D9613A7B59D197A4310E21", hash_generated_field = "9D8D93FACA8D7E05C8360BB2BE26342C")

    public static final int STREAM_SYSTEM_ENFORCED = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "1455C86426A205B10DD26D245D013C6A", hash_generated_field = "97A3B968F12F88051CD79CD800292953")

    public static final int STREAM_DTMF = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "2FF3C9C30371F58BE5DD9D706D822FA7", hash_generated_field = "F9B2A6886F769385637216CF80DF08B2")

    public static final int STREAM_TTS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "1B2504C154D3AA15109BC6DCF4533924", hash_generated_field = "A9324FF4B2DECA628AE162ED36D5EF46")

    public static final int NUM_STREAMS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.597 -0400", hash_original_field = "F839AAAE8BAEF7F14075D4BE2001630B", hash_generated_field = "2C9F0DE52241235534FE946EDF7D661B")

    private static int NUM_STREAM_TYPES = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "6421090994C51E127E9DAA63D907A21B", hash_generated_field = "CB067CE0D78DA21EC3ABE4A682836FE3")

    public static final int MODE_INVALID            = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "8182ED3B5E6DADE429D9F305A4CEF968", hash_generated_field = "D41F10CDEE8C2D10D2C446365D07A27B")

    public static final int MODE_CURRENT            = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "E418210C7EF9D38349B407A10538481B", hash_generated_field = "3DEED3F3E236ECDEF49ABC73C5FEF55B")

    public static final int MODE_NORMAL             = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "6B9BFFAEBF333BBCED03B7DEB399F6B1", hash_generated_field = "9985A2DD579C49F7C4B3A0AD7B9DBD3B")

    public static final int MODE_RINGTONE           = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "833280C5205ECE3E44B45719371EA388", hash_generated_field = "C2828592B3FF5DD54A87BF70C5A4C46F")

    public static final int MODE_IN_CALL            = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "F35B09D4E77F70BAFE6D3496FBEBCDEA", hash_generated_field = "ECF0DB42CAA5DAF63E9DFA4CBAC7614E")

    public static final int MODE_IN_COMMUNICATION   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "DE244EACAC3BF0609947360AFFB7E0D7", hash_generated_field = "E43E869A6DF34F8030C98810E0594860")

    public static final int NUM_MODES               = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "21182D75CAEA416BBDB65E028EF3A213", hash_generated_field = "6CD4EAA0583022B5698209C850009A94")

    @Deprecated public static final int ROUTE_EARPIECE          = (1 << 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.598 -0400", hash_original_field = "4B22F2DDCEB9905D956883980A9A17F6", hash_generated_field = "81D76342551CC40C5088F0176B2EFFC3")

    @Deprecated public static final int ROUTE_SPEAKER           = (1 << 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "C5696A719F6DB8761D5BB9C3131933EC", hash_generated_field = "92640DFBB885F024C9E35666F8ACBF77")

    @Deprecated public static final int ROUTE_BLUETOOTH = (1 << 2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "8904D2796ED4D6D15F705C8EE2AA5CAF", hash_generated_field = "E17B661970D4FCF610648776E3AEBA2F")

    @Deprecated public static final int ROUTE_BLUETOOTH_SCO     = (1 << 2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "EA2FBAAB435BCF472C7DDB418404BE78", hash_generated_field = "FE7E21C259F1770DBA90F9A18273644B")

    @Deprecated public static final int ROUTE_HEADSET           = (1 << 3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "4D1931926E9A64C8FC464865B2318668", hash_generated_field = "D221147BDF20A36B0E8E24EC704288D5")

    @Deprecated public static final int ROUTE_BLUETOOTH_A2DP    = (1 << 4);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "ED92FB12BFE48C4E0DEF30B0543C0A84", hash_generated_field = "567C69A932118D9385BAE9BE40E086BB")

    @Deprecated public static final int ROUTE_ALL               = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "ABABC028949D290817D875308615351E", hash_generated_field = "B7FF6BB9C04E295CB9607152748C7CBA")

    public static final int AUDIO_STATUS_OK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "83286BCDEBA7C1BC2842A5B052FD9E3E", hash_generated_field = "35F626CEB9314977E8710CFB84BFD4B5")

    public static final int AUDIO_STATUS_ERROR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "63BAFD47938207B1DBBE2A13FE8A8105", hash_generated_field = "0D41C5B466D312262C33677695C84BA0")

    public static final int AUDIO_STATUS_SERVER_DIED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.599 -0400", hash_original_field = "A2AED1B3A262AF1E8391B7FFF1C1D98F", hash_generated_field = "04DD76D9C83EA526A955FFA1C319E553")

    private static ErrorCallback mErrorCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "7DBE621C6107D26D49A3C6FE2395B8AA", hash_generated_field = "1B8F566B60147010408A519FE67400EA")

    public static final int DEVICE_OUT_EARPIECE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "8C163C40E8166AB7B26D4BA514EEA5C4", hash_generated_field = "602BF6A217C2AC374E46AA49B69405E6")

    public static final int DEVICE_OUT_SPEAKER = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "FE5FFE45C4081342F800FF6F28BD059D", hash_generated_field = "D108C8BC9B89E652415C25D2F3AE3F8F")

    public static final int DEVICE_OUT_WIRED_HEADSET = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "25CCFFADB0D31377CBEDB9B9DD390BC0", hash_generated_field = "92D223E861BA34AC143DFA9E62078F64")

    public static final int DEVICE_OUT_WIRED_HEADPHONE = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "6C76474F372E8B01DD50C7536590E432", hash_generated_field = "9A4781E37B6CA711D096783B2D5D8463")

    public static final int DEVICE_OUT_BLUETOOTH_SCO = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "99ADEBDBDFCF66CAC651A4BD0D079525", hash_generated_field = "44038CB306252BFE489FB68E5EF51672")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "3B8D0D3CC099D404E5B98AB7E8ECC448", hash_generated_field = "1FACA09D0D15E7285102C700DC03EF01")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.600 -0400", hash_original_field = "208614F8463D76C178F9F3F13B09E8AE", hash_generated_field = "5F42FA860C916E35D2F3D438DA599BB6")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "BC2FE6BFD0675D261A3688CD35056FB6", hash_generated_field = "AB6FC4D9DCD428893F6BCE5AC0F52D89")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "D7906CAB3AA1B3D5BE6BE3197C01E0C7", hash_generated_field = "74D5CDD223D3A30695075C661328A2D6")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "8FDC24855D6600B1B2255CBBA8631CD7", hash_generated_field = "73A5CE5D98CB439231D28B9C184E2E61")

    public static final int DEVICE_OUT_AUX_DIGITAL = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "9E47F71EE054FE612CBB1FC7F42706F1", hash_generated_field = "86D6F477BF51FC7E965AF69A073AA970")

    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "8FB99842D751456D4F631D871B096734", hash_generated_field = "C651F4CC2E182B5F0FFCF1A59D364A1E")

    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "45737FF64A0349F3A777854A7DFF7885", hash_generated_field = "FBFCB0898D89EE6E9317CE4456B28CA7")

    public static final int DEVICE_OUT_DEFAULT = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "D973D7DCF0A6821141D2EEA46F13CDED", hash_generated_field = "955EBAE4BB6B7F9D2A0F84FD96A3BF7F")

    public static final int DEVICE_IN_COMMUNICATION = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "F206899F6E958C905EF9DB3A04CA88A1", hash_generated_field = "6C36AD2F7E7100700BFD7F9EA5EED8AD")

    public static final int DEVICE_IN_AMBIENT = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "A6569243C1793539CB1DF45877D956F4", hash_generated_field = "8DF3B47481AA2AF62C4314C7D85927E7")

    public static final int DEVICE_IN_BUILTIN_MIC1 = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.601 -0400", hash_original_field = "97A56ED00609A9998E831B1FB2F45E6F", hash_generated_field = "8163D159BF9D50661681D090D82A722A")

    public static final int DEVICE_IN_BUILTIN_MIC2 = 0x80000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "1718B0EE69120D71C0DF12AF7483DF79", hash_generated_field = "AF85D1256B5058722A9C3C4B06088813")

    public static final int DEVICE_IN_MIC_ARRAY = 0x100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "4BBC660CCEC48E626D5253984C7FA868", hash_generated_field = "E0A48656C9582B9C00F04DD718C8798B")

    public static final int DEVICE_IN_BLUETOOTH_SCO_HEADSET = 0x200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "CEC818A58E29FAE326619F9F9B87D1E3", hash_generated_field = "594FA7E65BA2FBDC53CCE3D97AE77D64")

    public static final int DEVICE_IN_WIRED_HEADSET = 0x400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "855E7F2AF43271DC9213BA8062DEC4B2", hash_generated_field = "4ED16C2332BDF59B6028C66860A84E54")

    public static final int DEVICE_IN_AUX_DIGITAL = 0x800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "41CBBE45E89F17D0351376D303A48495", hash_generated_field = "08B385A486E1873BE5B13E7000661022")

    public static final int DEVICE_IN_DEFAULT = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "44C04D3E63A95A15414141449928E042", hash_generated_field = "9343FA98254A683896C06332332B2D3D")

    public static final int DEVICE_STATE_UNAVAILABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "339B1D44F54FFF0171F38C1D12A7E576", hash_generated_field = "FE8B3E6A860FBB7B6ACCE2C9B575AD18")

    public static final int DEVICE_STATE_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "B8124ED939CDDBCC53CB16F4FECD1283", hash_generated_field = "779519868BEF428635869D23874B2311")

    private static int NUM_DEVICE_STATES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.602 -0400", hash_original_field = "4C1851915D89139AED8E22901F08B6DB", hash_generated_field = "7168029A72B8A9744C8483ED3C29CC48")

    public static final int PHONE_STATE_OFFCALL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "64A0B36008A2A08292C6CBAA004498C2", hash_generated_field = "6235238C44FC957C417ACAD3F42800D5")

    public static final int PHONE_STATE_RINGING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "E0DF9F5EE3AB867EEDC61F3A28FF3F06", hash_generated_field = "0B4914FB5279AE8A7BFC9BBC4849C2FA")

    public static final int PHONE_STATE_INCALL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "BACF10511C3687CB5028CF55616633E7", hash_generated_field = "854B22AE7A5861F66679C9C265020AB1")

    public static final int FORCE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "8C12F9E58976A897B01A26378F3C47BF", hash_generated_field = "2B26C8C5E6AAF11428F73F835800944D")

    public static final int FORCE_SPEAKER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "4F5718DBBF82480E113ABF35D0DFE254", hash_generated_field = "6675A3D8E680E1119A3CDD38313D0695")

    public static final int FORCE_HEADPHONES = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "31CCF4C33502C6CDF3739029A9EA7422", hash_generated_field = "473683EA00DA68601F1DE1012FAB98AE")

    public static final int FORCE_BT_SCO = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "650831D5662B005A2C5090E0122CE9AE", hash_generated_field = "4EE32669A42A8152690BEC11A1504E51")

    public static final int FORCE_BT_A2DP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "E974DD091F775736EA96D939EDCF7227", hash_generated_field = "BC298A70C15613152A65C199C40BF5F6")

    public static final int FORCE_WIRED_ACCESSORY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.603 -0400", hash_original_field = "D3F6144EEA4020EB4E8413982CE8C685", hash_generated_field = "2196F336876B0F842E77F8C94AE309C6")

    public static final int FORCE_BT_CAR_DOCK = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "6895BE2BC2C7169B6890951931C4674C", hash_generated_field = "7768E6EB3B1462B19502F2BF3489A13D")

    public static final int FORCE_BT_DESK_DOCK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "94952E17F98479DCD1C7E57E73F45799", hash_generated_field = "0AB4DD390152688A0AA7EBD5F6E992D2")

    public static final int FORCE_ANALOG_DOCK = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "A71BE23342B518AE0E29AD7EA0BC55C1", hash_generated_field = "A80B1C27254EF0E3B8CFA096BB4AD8B5")

    public static final int FORCE_DIGITAL_DOCK = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "12799A79898FA3F357579F10E9EF5E49", hash_generated_field = "B3103B08F7798CD95DA80B8243A19651")

    private static int NUM_FORCE_CONFIG = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "75C4D5D0DF6BC4E14B746F2EC1A42EF5", hash_generated_field = "B9832F568281A57229EFDE3CBE82FFD4")

    public static final int FORCE_DEFAULT = FORCE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "DBC86D3E4A3A08D64EC6373B6800AA98", hash_generated_field = "66A1B811ACBD73880C3AB14B7AABE4F9")

    public static final int FOR_COMMUNICATION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "37C72165BB2AB7C0D6E060DD36854CEE", hash_generated_field = "841AD0B48CD7E0BA128F4F4A33A31807")

    public static final int FOR_MEDIA = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "4C6CEF448DFA1F06E8A2E1DA462C9918", hash_generated_field = "A9CFD7A15BD4CBA65EAD531B2B8450CC")

    public static final int FOR_RECORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.604 -0400", hash_original_field = "80769A4CC8F4BD906D35B778103ACDE7", hash_generated_field = "EA8F8CC7B133D4AED4341CEDFBE01874")

    public static final int FOR_DOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:17.605 -0400", hash_original_field = "395367294DFB4F4F47C5B7856B59D6DA", hash_generated_field = "BB304CC8396AF02942E3EDA273A707D3")

    private static int NUM_FORCE_USE = 4;
}

