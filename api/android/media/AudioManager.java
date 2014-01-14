package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.HashMap;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.VolumePanel;

public class AudioManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.020 -0500", hash_original_method = "4C7645D232D763BA4F570538A2273FAB", hash_generated_method = "167786996F36B4A84FAE42E57D8CB72B")
    
private static IAudioService getService()
    {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService(Context.AUDIO_SERVICE);
        sService = IAudioService.Stub.asInterface(b);
        return sService;
    }

    /**
     * Checks valid ringer mode values.
     *
     * @return true if the ringer mode indicated is valid, false otherwise.
     *
     * @see #setRingerMode(int)
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.042 -0500", hash_original_method = "4B024812601ACB96446509B5DCB48917", hash_generated_method = "D90CE8491E4EB06E7577E1CBF5DD7410")
    
public static boolean isValidRingerMode(int ringerMode) {
        if (ringerMode < 0 || ringerMode > RINGER_MODE_MAX) {
            return false;
        }
        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.891 -0500", hash_original_field = "76B326C2FA713E4ACCF42ADAADED1297", hash_generated_field = "EA464CE610E64C107F0AE63BEF486884")

    private static String TAG = "AudioManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.894 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.897 -0500", hash_original_field = "1F1FD828EDBFFFBEEC6A141DEE5DCB21", hash_generated_field = "3B419F3B582C47DDFE050BC2915123CA")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AUDIO_BECOMING_NOISY = "android.media.AUDIO_BECOMING_NOISY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.899 -0500", hash_original_field = "45093D3BFC6AB1CFAE44F56E7640077D", hash_generated_field = "82FD8649C65A8CF3532DA13370F1BA7D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RINGER_MODE_CHANGED_ACTION = "android.media.RINGER_MODE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.902 -0500", hash_original_field = "966881877483E9DC19A9C5D69F24BC3C", hash_generated_field = "224A6B231CEB60121D4D26857CDB53A5")

    public static final String EXTRA_RINGER_MODE = "android.media.EXTRA_RINGER_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.905 -0500", hash_original_field = "F813E430AC18EF641A01761AFE4FD893", hash_generated_field = "CACD1A5245F7950B257F0D4DBC5F7355")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String VIBRATE_SETTING_CHANGED_ACTION = "android.media.VIBRATE_SETTING_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.909 -0500", hash_original_field = "91A78D327A0D87E71FE4DB49C86B9A37", hash_generated_field = "BC5B119582962733F44A97FF95D9FFE5")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.912 -0500", hash_original_field = "86A10310EACA8BE5648FC1BD618E31C1", hash_generated_field = "51E87800B3F480A44745265DB1A8B0A3")

    public static final String EXTRA_VIBRATE_SETTING = "android.media.EXTRA_VIBRATE_SETTING";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.915 -0500", hash_original_field = "D29231D3EA3B364CD73BFEA97D957EF7", hash_generated_field = "A915326453E39AE5D00D8FC37F9C4409")

    public static final String EXTRA_VIBRATE_TYPE = "android.media.EXTRA_VIBRATE_TYPE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.918 -0500", hash_original_field = "AF707EFA938DA85F3B54517A8CBCD1DA", hash_generated_field = "9FD0D907F0CD51DF1DB106EECBD6E9C3")

    public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.921 -0500", hash_original_field = "1A459366D4F9C29695CDB84FDC0DF061", hash_generated_field = "9349DEF2B660FADDEEF1B5E130A7E048")

    public static final String EXTRA_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_VOLUME_STREAM_VALUE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.923 -0500", hash_original_field = "D99DA54F5A6A7B5F4E0EBD9F7011EB8C", hash_generated_field = "526505C0CAFCE5C52F34243604D6DCFA")

    public static final String EXTRA_PREV_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.926 -0500", hash_original_field = "1D2D4D49E8D3672238F44D0913F79481", hash_generated_field = "31DA6CA9D350A5C1500EAB368D53C36E")

    public static final int STREAM_VOICE_CALL = AudioSystem.STREAM_VOICE_CALL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.928 -0500", hash_original_field = "3F804C821C86672F8C2E85458C02927A", hash_generated_field = "4E6B4BD7DB17D08DD4B7DA5B936BD4D4")

    public static final int STREAM_SYSTEM = AudioSystem.STREAM_SYSTEM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.931 -0500", hash_original_field = "DF0D70E93026DA58A04C9A9D732627F3", hash_generated_field = "7E52EEF3A9F3F78B8DB4024C9ABD30A9")

    public static final int STREAM_RING = AudioSystem.STREAM_RING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.933 -0500", hash_original_field = "4CCD385554E18CBD5EC8BA17D1000584", hash_generated_field = "EED8B59EA13FC4896CC2F9343483263F")

    public static final int STREAM_MUSIC = AudioSystem.STREAM_MUSIC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.937 -0500", hash_original_field = "C8DF92C6D839EE209B34F6F5F5434537", hash_generated_field = "E333B8A140BD1179FF221381CD837DFE")

    public static final int STREAM_ALARM = AudioSystem.STREAM_ALARM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.939 -0500", hash_original_field = "53BF47D54F7AE0E10345E41F9926908F", hash_generated_field = "71EF53B6668807C856EFBEF9825ECFA0")

    public static final int STREAM_NOTIFICATION = AudioSystem.STREAM_NOTIFICATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.942 -0500", hash_original_field = "4031EAA8DDB46FE30E8E58B020686C9E", hash_generated_field = "D735EBDC384DC7A926CBC88947191DB1")

    public static final int STREAM_BLUETOOTH_SCO = AudioSystem.STREAM_BLUETOOTH_SCO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.945 -0500", hash_original_field = "5E384C3887A1808F880BAB43F329044B", hash_generated_field = "915B268BBDC4A53AC54878DC5E88D5A3")

    public static final int STREAM_SYSTEM_ENFORCED = AudioSystem.STREAM_SYSTEM_ENFORCED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.947 -0500", hash_original_field = "58693995FAE1D7993AE13E8CF621FBD8", hash_generated_field = "50AD1DD144B476A92BCF3C54F214BBF7")

    public static final int STREAM_DTMF = AudioSystem.STREAM_DTMF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.951 -0500", hash_original_field = "DFEF0B470643738D73EB4AA51B385E57", hash_generated_field = "0367B1DD22E5CBAA04B4868362ADCDD8")

    public static final int STREAM_TTS = AudioSystem.STREAM_TTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.954 -0500", hash_original_field = "E4B921A6CE64BBCB83A0B28E5A476253", hash_generated_field = "440316A902236E35B90E99C5D0D1DAFD")

    /**
     * @deprecated Use AudioSystem.getNumStreamTypes() instead
     */
    @Deprecated public static final int NUM_STREAMS = AudioSystem.NUM_STREAMS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.957 -0500", hash_original_field = "C59889BF945D84E08E998AC6D36F49AE", hash_generated_field = "47D176F8C1A6A7583FD8D7733DE0E7C1")

    public static final int[] DEFAULT_STREAM_VOLUME = new int[] {
        4,  // STREAM_VOICE_CALL
        7,  // STREAM_SYSTEM
        5,  // STREAM_RING
        11, // STREAM_MUSIC
        6,  // STREAM_ALARM
        5,  // STREAM_NOTIFICATION
        7,  // STREAM_BLUETOOTH_SCO
        7,  // STREAM_SYSTEM_ENFORCED
        11, // STREAM_DTMF
        11  // STREAM_TTS
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.959 -0500", hash_original_field = "96E13BCD6DBD3329195C774F5F6D6310", hash_generated_field = "39E2EEE47548F14D86DF84B8B634D67C")

    public static final int ADJUST_RAISE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.962 -0500", hash_original_field = "33F555481DA94DA816DB760BD53A289B", hash_generated_field = "06BE000BF1CE74FF300973D26EDD9CCC")

    public static final int ADJUST_LOWER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.965 -0500", hash_original_field = "A05401969FF1636C720CA71D275737A7", hash_generated_field = "790B73E28F46DC84449E1CC5892A2D1D")

    public static final int ADJUST_SAME = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.968 -0500", hash_original_field = "65A6FAEF45CB5B7A6A305A380ECEF2AE", hash_generated_field = "83E150229CC16679B413CA217F76E27E")

    /**
     * Show a toast containing the current volume.
     *
     * @see #adjustStreamVolume(int, int, int)
     * @see #adjustVolume(int, int)
     * @see #setStreamVolume(int, int, int)
     * @see #setRingerMode(int)
     */
    public static final int FLAG_SHOW_UI = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.970 -0500", hash_original_field = "E03B74A61C1637E538B7CDD60E24FFB4", hash_generated_field = "EDBE1C6A970E116625702809E63BF00C")

    public static final int FLAG_ALLOW_RINGER_MODES = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.973 -0500", hash_original_field = "90533DCB23DBDFD91F866DBCA2185C70", hash_generated_field = "1D52CF8A5130FFDCD6B413FE5A64D5C4")

    public static final int FLAG_PLAY_SOUND = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.976 -0500", hash_original_field = "09B54B029873AA7DFB3750822DD58C0C", hash_generated_field = "FD125539FD3EE63843F3520B6EE0274B")

    public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.980 -0500", hash_original_field = "FC0B86D8C9D6DD1D3F9556D296543A4A", hash_generated_field = "2B2FC04AD3CAEDF49651FD851423D6C4")

    public static final int FLAG_VIBRATE = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.983 -0500", hash_original_field = "1AC1903165BFDF6029F1E1AED2BC57F0", hash_generated_field = "45725751A8AF13B150CECD05C3003DC1")

    public static final int FLAG_FORCE_STREAM = 1 << 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.986 -0500", hash_original_field = "57EC8B1A490F57898D6B1CDC5CA6F5F4", hash_generated_field = "168D021BDAA46D07A61D7B1EBCDDB53C")

    public static final int RINGER_MODE_SILENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.988 -0500", hash_original_field = "30E87B3034605AB53D0686CC5805DF36", hash_generated_field = "F3C65C70B216A9A16710313BAFE6E5BB")

    public static final int RINGER_MODE_VIBRATE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.991 -0500", hash_original_field = "ED5672B53A297720D04A40A49A2C15EE", hash_generated_field = "91CA816E423F22422D47B3B82C943A68")

    public static final int RINGER_MODE_NORMAL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.995 -0500", hash_original_field = "FBEAC2EFB2A9A4F595BEA10121022A62", hash_generated_field = "46620B2E8AE72554737A1DFE483BB5C5")

    private static final int RINGER_MODE_MAX = RINGER_MODE_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.998 -0500", hash_original_field = "805132074A04CED0A5B113317F19F7A0", hash_generated_field = "A7E9F8C96B6DB2781912159B457B77B2")

    public static final int VIBRATE_TYPE_RINGER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.001 -0500", hash_original_field = "F0404C1B215D8B3F00F22F5BBE34368F", hash_generated_field = "E39C772C4AD66D76048A1561BA2537C0")

    public static final int VIBRATE_TYPE_NOTIFICATION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.003 -0500", hash_original_field = "04A656230FFD7AD4B9123841721688FC", hash_generated_field = "97CBF0237199BFD95F4B3796B121DB7A")

    public static final int VIBRATE_SETTING_OFF = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.006 -0500", hash_original_field = "03BF0C4F136953CBA7399656FF4D09EC", hash_generated_field = "36A1A77239700641916E355FAE6C05CC")

    public static final int VIBRATE_SETTING_ON = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.009 -0500", hash_original_field = "CD618068C07B5BE0B1257C01E94DD2C5", hash_generated_field = "49863BA7BB9B018EBD15616831E16BF7")

    public static final int VIBRATE_SETTING_ONLY_SILENT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.011 -0500", hash_original_field = "6F214C7BD93C5D7C6C46497A904BD4D6", hash_generated_field = "07C5C486F2A741CB9A37D58EAD3271C6")

    public static final int USE_DEFAULT_STREAM_TYPE = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.014 -0500", hash_original_field = "84E547D659D421C1515D62D6E0D7BBA4", hash_generated_field = "7D19457E3AE9FEB13C4F40FE79C55E2E")

    private static IAudioService sService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.083 -0500", hash_original_field = "45646E4FB1E10F2893DE0CE3D75B0BCA", hash_generated_field = "0B475D305F4267613131ACEDF7B1C2B5")

    // Bluetooth SCO control
    /**
     * Sticky broadcast intent action indicating that the bluetoooth SCO audio
     * connection state has changed. The intent contains on extra {@link #EXTRA_SCO_AUDIO_STATE}
     * indicating the new state which is either {@link #SCO_AUDIO_STATE_DISCONNECTED}
     * or {@link #SCO_AUDIO_STATE_CONNECTED}
     *
     * @see #startBluetoothSco()
     * @deprecated Use  {@link #ACTION_SCO_AUDIO_STATE_UPDATED} instead
     */
    @Deprecated
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCO_AUDIO_STATE_CHANGED =
            "android.media.SCO_AUDIO_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.087 -0500", hash_original_field = "F2605B30A3088C0CFCED9BC14B597BB9", hash_generated_field = "F3166319F9207DF19FD2E9CFDAAA5A72")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCO_AUDIO_STATE_UPDATED =
            "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.089 -0500", hash_original_field = "586A66D3AFA5848387A35C95DA1CF0C4", hash_generated_field = "32FA7228E6E3D4D2E77A75BF18A610E6")

    public static final String EXTRA_SCO_AUDIO_STATE =
            "android.media.extra.SCO_AUDIO_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.092 -0500", hash_original_field = "2B41A33D9474DBCB64DD22524D045008", hash_generated_field = "0622BB79817581AD352373308DBDB593")

    public static final String EXTRA_SCO_AUDIO_PREVIOUS_STATE =
            "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.095 -0500", hash_original_field = "20699E1FFE5CAD97CEA1D9CDBE205D05", hash_generated_field = "5E74ACBB33EE191822BB57DF0F81B6B2")

    public static final int SCO_AUDIO_STATE_DISCONNECTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.098 -0500", hash_original_field = "7C6C839A6F84598EC8257E289773DFBE", hash_generated_field = "AE5318710A7CFA0C1F39C3D317710563")

    public static final int SCO_AUDIO_STATE_CONNECTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.101 -0500", hash_original_field = "71682F07188D46C221F113E733589C98", hash_generated_field = "304672883C84724BF04B4DA579DFE5FC")

    public static final int SCO_AUDIO_STATE_CONNECTING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.104 -0500", hash_original_field = "E59ACCDA90135852BE17B8B28FDEA37F", hash_generated_field = "F47DB376AA7C1FD07279222484B48ABF")

    public static final int SCO_AUDIO_STATE_ERROR = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.157 -0500", hash_original_field = "F1FA63ABE3C9A251E3804BEC23A892A4", hash_generated_field = "0630A2BD056EB6414DD81D20D41A12A5")

    /**
     * Audio harware modes.
     */
    /**
     * Invalid audio mode.
     */
    public static final int MODE_INVALID            = AudioSystem.MODE_INVALID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.163 -0500", hash_original_field = "6928F45C00E2A4E3512CEB00B887CD9A", hash_generated_field = "259EA8BFEB6837EF7E97885CAC8959D1")

    public static final int MODE_CURRENT            = AudioSystem.MODE_CURRENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.166 -0500", hash_original_field = "1B19ED011F150A9E7B0D30607EBCAD52", hash_generated_field = "E42A9AACEEEF54C680DA2CB0F408B1AB")

    public static final int MODE_NORMAL             = AudioSystem.MODE_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.171 -0500", hash_original_field = "B0CF00CDC055FB02424BF6576FBC04A1", hash_generated_field = "EE90B81F058177AB332C6C3C562A5933")

    public static final int MODE_RINGTONE           = AudioSystem.MODE_RINGTONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.174 -0500", hash_original_field = "7CBA31AE38442B6936C547937B2AD714", hash_generated_field = "4CF349F6E441825259B2E10E96F041E3")

    public static final int MODE_IN_CALL            = AudioSystem.MODE_IN_CALL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.177 -0500", hash_original_field = "F92EE0E9E00FA42C4A4A35E918A60B88", hash_generated_field = "434899DAA6585E4FD846D710E77D536B")

    public static final int MODE_IN_COMMUNICATION   = AudioSystem.MODE_IN_COMMUNICATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.180 -0500", hash_original_field = "875B19BEBEB32100060D6464DE0E64C9", hash_generated_field = "9261F9B3963BA3E9041E60EB5E328736")

    /**
     * Routing audio output to earpiece
     * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
     * setBluetoothScoOn() methods instead.
     */
    @Deprecated public static final int ROUTE_EARPIECE          = AudioSystem.ROUTE_EARPIECE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.182 -0500", hash_original_field = "3DC79AF255275E87F82E183029E7B794", hash_generated_field = "E2FDF0262BFAC843B291B6443B31346A")

    @Deprecated public static final int ROUTE_SPEAKER           = AudioSystem.ROUTE_SPEAKER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.185 -0500", hash_original_field = "65E8209C3824FE554EA1144F9B6BB4D6", hash_generated_field = "E9BBBA7FC483766285967936E5E858BE")

    @Deprecated public static final int ROUTE_BLUETOOTH = AudioSystem.ROUTE_BLUETOOTH_SCO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.188 -0500", hash_original_field = "121AB299AE7C4A6410FA368A4EBD61A9", hash_generated_field = "3C9DBD8E86562E2D420F48D99E3AF6C7")

    @Deprecated public static final int ROUTE_BLUETOOTH_SCO     = AudioSystem.ROUTE_BLUETOOTH_SCO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.191 -0500", hash_original_field = "1DCD574101AC76BD19D65A7CEF1D6EA0", hash_generated_field = "9A404516ED0F3D498C08B7D46BA009B8")

    @Deprecated public static final int ROUTE_HEADSET           = AudioSystem.ROUTE_HEADSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.194 -0500", hash_original_field = "2D662280910A62C201F7BD038AA26CAB", hash_generated_field = "1083E9F1E7B36963C23113631B1A07AE")

    @Deprecated public static final int ROUTE_BLUETOOTH_A2DP    = AudioSystem.ROUTE_BLUETOOTH_A2DP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.197 -0500", hash_original_field = "B80C216E17FFBE5B251B115486267AD7", hash_generated_field = "A433F5AE2654D66600E8F02A7060BE7D")

    @Deprecated public static final int ROUTE_ALL               = AudioSystem.ROUTE_ALL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.216 -0500", hash_original_field = "AA788071F38509157C707B55D3F63DC5", hash_generated_field = "201D3F60D3E079B9EAD1B107E50E36FB")

    /**
     * Keyboard and direction pad click sound
     * @see #playSoundEffect(int)
     */
    public static final int FX_KEY_CLICK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.219 -0500", hash_original_field = "15B7DAA0722422C60572115BAC47C92C", hash_generated_field = "9B1C422735AA23C6564D3A25E067CCCD")

    public static final int FX_FOCUS_NAVIGATION_UP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.222 -0500", hash_original_field = "67DF229ED4940BE851A7CF5402F0E43E", hash_generated_field = "236FF916CEC7EE68DAA532ED561496C7")

    public static final int FX_FOCUS_NAVIGATION_DOWN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.225 -0500", hash_original_field = "3DD787F356794BB3F69EB1D9861EED76", hash_generated_field = "CAA9DED10A96B1789EB8A05BCEA06EC3")

    public static final int FX_FOCUS_NAVIGATION_LEFT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.227 -0500", hash_original_field = "EFB39A75C72D6CC70D9607106A011F1F", hash_generated_field = "507E5ACB5A3B0B2C1461339C057377B4")

    public static final int FX_FOCUS_NAVIGATION_RIGHT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.230 -0500", hash_original_field = "EAABCD13A1815C6078EF99531B2D0377", hash_generated_field = "F5ED1ACF7069D4ADA865EA192688F916")

    public static final int FX_KEYPRESS_STANDARD = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.233 -0500", hash_original_field = "EC95AFE262ECBCFBB840091A32F1A83C", hash_generated_field = "7F35EE68E6EF23414295B81D6D5519E8")

    public static final int FX_KEYPRESS_SPACEBAR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.236 -0500", hash_original_field = "432FCA8B8C830B836E103662824873C2", hash_generated_field = "7F15B1B0A87277F3E076311AB3C08BE4")

    public static final int FX_KEYPRESS_DELETE = 7;
    
    private class FocusEventHandlerDelegate {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.291 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private  Handler mHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.297 -0500", hash_original_method = "655176F98C4DE876C8B3DFC6C8BC6CB4", hash_generated_method = "25C45B588ED68CF159888002E253CF87")
        
FocusEventHandlerDelegate() {
            Looper looper;
            if ((looper = Looper.myLooper()) == null) {
                looper = Looper.getMainLooper();
            }

            if (looper != null) {
                // implement the event handler delegate to receive audio focus events
                mHandler = new Handler(looper) {
                    @Override
                    public void handleMessage(Message msg) {
                        OnAudioFocusChangeListener listener = null;
                        synchronized(mFocusListenerLock) {
                            listener = findFocusListener((String)msg.obj);
                        }
                        if (listener != null) {
                            listener.onAudioFocusChange(msg.what);
                        }
                    }
                };
            } else {
                mHandler = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.300 -0500", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "10E7D4FA7AE5C5A4DFE91478AE111D01")
        
Handler getHandler() {
            return mHandler;
        }
        
    }
    
    public interface OnAudioFocusChangeListener {
        
        public void onAudioFocusChange(int focusChange);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.239 -0500", hash_original_field = "A38E8ADE6B42DFF11CBDA454A3C9FD74", hash_generated_field = "C665DE812B57F58CB0283896A6829103")

    public static final int FX_KEYPRESS_RETURN = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.242 -0500", hash_original_field = "EDD78E30167710D4FF6B4106DFFCBD75", hash_generated_field = "64E2DFA9698F8C924F1476F0A0C29567")

    public static final int NUM_SOUND_EFFECTS = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.260 -0500", hash_original_field = "42E99C962239F2E87F628A70876C3CF7", hash_generated_field = "322B7C042AB9183F8D195E48CE22838E")

    public static final int AUDIOFOCUS_GAIN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.263 -0500", hash_original_field = "07327AD11AE49EAFF9ADD9AA63AF06F8", hash_generated_field = "BB6569D7168A2B68AC704A047DCB1B3D")

    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.266 -0500", hash_original_field = "9A2C357FAEE16E449A7617700348DE37", hash_generated_field = "261801A1158E5414AFF80E5C998CDA23")

    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.269 -0500", hash_original_field = "192BB54EF104EB5D859B73B73D2DB335", hash_generated_field = "1FDFD24111A3D8158394B4436A3323CC")

    public static final int AUDIOFOCUS_LOSS = -1 * AUDIOFOCUS_GAIN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.271 -0500", hash_original_field = "FA6B99C4BE12B06232762E8E6E280012", hash_generated_field = "7CC773DE0572889733DA498CCA178236")

    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -1 * AUDIOFOCUS_GAIN_TRANSIENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.274 -0500", hash_original_field = "B3AC4E2770C2EFFD08B939CADE9CBAEF", hash_generated_field = "9CC322B2833D90555FD6EC3A873AF969")

    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK =
            -1 * AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.318 -0500", hash_original_field = "6DAD848B18EBF12D1C34FB986B26AC4B", hash_generated_field = "D8A159EEDAE6693D921247329EA8C396")

    public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.321 -0500", hash_original_field = "35B7612D355E1E45C3266AA5513E029F", hash_generated_field = "1FD5D2DAD8907D4E83DD8E910708874E")

    public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.355 -0500", hash_original_field = "49849AEF01B473DD29CDF32F57AB9F8A", hash_generated_field = "74A5DD8ECDEB388FBA150380057C74C5")

    /**
     * @hide
     * Broadcast intent action indicating that the displays on the remote controls
     * should be updated because a new remote control client is now active. If there is no
     * {@link #EXTRA_REMOTE_CONTROL_CLIENT}, the remote control display should be cleared
     * because there is no valid client to supply it with information.
     *
     * @see #EXTRA_REMOTE_CONTROL_CLIENT
     */
    public static final String REMOTE_CONTROL_CLIENT_CHANGED =
            "android.media.REMOTE_CONTROL_CLIENT_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.358 -0500", hash_original_field = "4530E0710722E0A32C6C28C18319641E", hash_generated_field = "CFCAB3D7AB5FE3707D925A6CA1F2C039")

    /**
     * @hide
     * The IRemoteControlClientDispatcher monotonically increasing generation counter.
     *
     * @see #REMOTE_CONTROL_CLIENT_CHANGED_ACTION
     */
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_GENERATION =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_GENERATION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.361 -0500", hash_original_field = "829080AE109D110E97D474679EC97086", hash_generated_field = "06AE6832067621EFA6435EF8D2F5D70D")

    /**
     * @hide
     * The name of the RemoteControlClient.
     * This String is passed as the client name when calling methods from the
     * IRemoteControlClientDispatcher interface.
     *
     * @see #REMOTE_CONTROL_CLIENT_CHANGED_ACTION
     */
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_NAME =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.363 -0500", hash_original_field = "9B1021D6E75C74D92C4831E4651E1541", hash_generated_field = "5CBF89E31DBFCB9EB046F2DABA864DC3")

    /**
     * @hide
     * The media button event receiver associated with the RemoteControlClient.
     * The {@link android.content.ComponentName} value of the event receiver can be retrieved with
     * {@link android.content.ComponentName#unflattenFromString(String)}
     *
     * @see #REMOTE_CONTROL_CLIENT_CHANGED_ACTION
     */
    public static final String EXTRA_REMOTE_CONTROL_EVENT_RECEIVER =
            "android.media.EXTRA_REMOTE_CONTROL_EVENT_RECEIVER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.366 -0500", hash_original_field = "A93BFDC9B39FCF6C37A71D5E0D2F63EB", hash_generated_field = "63F4A633FE565979F3787F5731A75F1A")

    /**
     * @hide
     * The flags describing what information has changed in the current remote control client.
     *
     * @see #REMOTE_CONTROL_CLIENT_CHANGED_ACTION
     */
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.377 -0500", hash_original_field = "6BBA56D643BC8F5655AB36064801F1BE", hash_generated_field = "90D4811DBF409F12DE19DA9A4EB52CA6")

    // class is not used by other parts of the framework, which instead use definitions and methods
    // from AudioManager. AudioSystem is an internal class used by AudioManager and AudioService.

    /** {@hide} The audio output device code for the small speaker at the front of the device used
     *  when placing calls.  Does not refer to an in-ear headphone without attached microphone,
     *  such as earbuds, earphones, or in-ear monitors (IEM). Those would be handled as a
     *  {@link #DEVICE_OUT_WIRED_HEADPHONE}.
     */
    public static final int DEVICE_OUT_EARPIECE = AudioSystem.DEVICE_OUT_EARPIECE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.380 -0500", hash_original_field = "266917980A7EDFA25668AABC0A7987C8", hash_generated_field = "D6227080EB7A997BCE1FA46E8B968DD8")

    public static final int DEVICE_OUT_SPEAKER = AudioSystem.DEVICE_OUT_SPEAKER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.382 -0500", hash_original_field = "0C1D85FF69D188118A92F2B0DB53634A", hash_generated_field = "55E7491E06DE5E01ED3B33ABA5AD336F")

    public static final int DEVICE_OUT_WIRED_HEADSET = AudioSystem.DEVICE_OUT_WIRED_HEADSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.385 -0500", hash_original_field = "99822B624E7A9886C54CD8DEA861017E", hash_generated_field = "1B89915F1B98545F2783E803858F696C")

    public static final int DEVICE_OUT_WIRED_HEADPHONE = AudioSystem.DEVICE_OUT_WIRED_HEADPHONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.388 -0500", hash_original_field = "884873656308F55BE54B0E4392AC14DD", hash_generated_field = "CE4CF86E062571787BAB33CD873F9233")

    public static final int DEVICE_OUT_BLUETOOTH_SCO = AudioSystem.DEVICE_OUT_BLUETOOTH_SCO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.391 -0500", hash_original_field = "C04B5674764350A7E03A1CC252717CBA", hash_generated_field = "EEC370A857A75EAA819FF7441AFA8414")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_HEADSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.394 -0500", hash_original_field = "FB61DF11010ECD961458989FBCE2C909", hash_generated_field = "6220ACBA4790166A2A6FE5A9A1526D27")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_CARKIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.397 -0500", hash_original_field = "515C305BF089774BEBFF07056DFA72D5", hash_generated_field = "93F1DA1DBC6FA9F31FD9460CBB32E624")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP = AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.399 -0500", hash_original_field = "23170B607A1B897575C768BF1ABDCD45", hash_generated_field = "56A1F5C12B7E16CCC85E48AAE7D99AB9")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.403 -0500", hash_original_field = "00DF06E5C4039080D8C62E788EFBBFC8", hash_generated_field = "FC91812C450C9B07D2EBFCD6DE58B3B4")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.405 -0500", hash_original_field = "3A204CBAE8747960D7E5B62DE7101879", hash_generated_field = "337695F485738D53E0DA0ED866F46B0F")

    public static final int DEVICE_OUT_AUX_DIGITAL = AudioSystem.DEVICE_OUT_AUX_DIGITAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.408 -0500", hash_original_field = "55BD3E187E0080658F7C8A662BC96789", hash_generated_field = "16C5FBEE95A069FA4DED88AC7221272C")

    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.410 -0500", hash_original_field = "52C2634E8A555E93A991B55ED412CDB3", hash_generated_field = "53732908F8993B64E8D515F061714ED0")

    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.413 -0500", hash_original_field = "95F2DABC7278161366D3D4B932681A04", hash_generated_field = "98E3296F457805159505EB36AB5F258D")

    public static final int DEVICE_OUT_DEFAULT = AudioSystem.DEVICE_OUT_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.882 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.884 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.887 -0500", hash_original_field = "E635F242C3A7489A23055F971812FA8E", hash_generated_field = "5A0BAF05F67CAB3B2C4D272BECF49076")

    private long mVolumeKeyUpTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:21.889 -0500", hash_original_field = "FE051F745EE7679A61A1FBC5B4BBE9E9", hash_generated_field = "AB49906111B3804858E19BBFBE77F9B2")

    private int  mVolumeControlStream = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.279 -0500", hash_original_field = "D192CBAB8B241E7DD6F9B9BE2F9682EC", hash_generated_field = "55E428528E5E7A11729F2BB805880E0B")

    private HashMap<String, OnAudioFocusChangeListener> mAudioFocusIdListenerMap =
            new HashMap<String, OnAudioFocusChangeListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.283 -0500", hash_original_field = "1D7607ADB1C778DF6F749755B425D37B", hash_generated_field = "94B4DBA462511DBB55ED9EA27E7B7245")

    private final Object mFocusListenerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.288 -0500", hash_original_field = "3D8AA7D716248963A53A4D548569E4B4", hash_generated_field = "B50AA15FB2D552CBF712655325DCFDE6")

    private FocusEventHandlerDelegate mAudioFocusEventHandlerDelegate =
            new FocusEventHandlerDelegate();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.987 -0400", hash_original_field = "A0F7F05A34E84AB7313662AF35BB555F", hash_generated_field = "308C8A66E7A89D62F744DA6B62C1EE85")

    private IAudioFocusDispatcher mAudioFocusDispatcher = new IAudioFocusDispatcher.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.987 -0400", hash_original_method = "D05EBA6AEC20F9D8CACE6E9B169AF75D", hash_generated_method = "812F9AC3246FC9072EFFC96531C82079")
        public void dispatchAudioFocusChange(int focusChange, String id) {
            Message m = mAudioFocusEventHandlerDelegate.getHandler().obtainMessage(focusChange, id);
            mAudioFocusEventHandlerDelegate.getHandler().sendMessage(m);
            addTaint(focusChange);
            addTaint(id.getTaint());
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.371 -0500", hash_original_field = "CE687D84F2945E95EFC9DBCEBF93B198", hash_generated_field = "F0463229CC92165D569BCDFE5CB835D0")

     private IBinder mICallBack = new Binder();

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.017 -0500", hash_original_method = "42BDED457A05AA4B5FB652FAAB5F6EE7", hash_generated_method = "71EBCB14977F8F0ED8D81DB04462C351")
    
public AudioManager(Context context) {
        mContext = context;
        mHandler = new Handler(context.getMainLooper());
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.023 -0500", hash_original_method = "F1E14361B214327A2A0E751697355D64", hash_generated_method = "92E81E6D04F40E83D15443557F52B3F2")
    
public void preDispatchKeyEvent(int keyCode, int stream) {
        /*
         * If the user hits another key within the play sound delay, then
         * cancel the sound
         */
        if (keyCode != KeyEvent.KEYCODE_VOLUME_DOWN && keyCode != KeyEvent.KEYCODE_VOLUME_UP
                && keyCode != KeyEvent.KEYCODE_VOLUME_MUTE
                && mVolumeKeyUpTime + VolumePanel.PLAY_SOUND_DELAY
                        > SystemClock.uptimeMillis()) {
            /*
             * The user has hit another key during the delay (e.g., 300ms)
             * since the last volume key up, so cancel any sounds.
             */
            adjustSuggestedStreamVolume(AudioManager.ADJUST_SAME,
                        stream, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.026 -0500", hash_original_method = "CE7E2CE8B01D9CBEAD319BD036F134E9", hash_generated_method = "F7AB3F1A1B5CB4F5F7F3F29E1DBB6B3B")
    
public void handleKeyDown(int keyCode, int stream) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                /*
                 * Adjust the volume in on key down since it is more
                 * responsive to the user.
                 */
                int flags = FLAG_SHOW_UI | FLAG_VIBRATE;
                if (mVolumeControlStream != -1) {
                    stream = mVolumeControlStream;
                    flags |= FLAG_FORCE_STREAM;
                }
                adjustSuggestedStreamVolume(
                        keyCode == KeyEvent.KEYCODE_VOLUME_UP
                                ? ADJUST_RAISE
                                : ADJUST_LOWER,
                        stream,
                        flags);
                break;
            case KeyEvent.KEYCODE_VOLUME_MUTE:
                // TODO: Actually handle MUTE.
                break;
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.028 -0500", hash_original_method = "4690E566A0F7A4762BD0C4814376C399", hash_generated_method = "566F41B65BB1551A7C8BED1809C4EDF9")
    
public void handleKeyUp(int keyCode, int stream) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                /*
                 * Play a sound. This is done on key up since we don't want the
                 * sound to play when a user holds down volume down to mute.
                 */
                int flags = FLAG_PLAY_SOUND;
                if (mVolumeControlStream != -1) {
                    stream = mVolumeControlStream;
                    flags |= FLAG_FORCE_STREAM;
                }
                adjustSuggestedStreamVolume(
                        ADJUST_SAME,
                        stream,
                        flags);

                mVolumeKeyUpTime = SystemClock.uptimeMillis();
                break;
            case KeyEvent.KEYCODE_VOLUME_MUTE:
                // TODO: Actually handle MUTE.
                break;
        }
    }

    /**
     * Adjusts the volume of a particular stream by one step in a direction.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param streamType The stream type to adjust. One of {@link #STREAM_VOICE_CALL},
     * {@link #STREAM_SYSTEM}, {@link #STREAM_RING}, {@link #STREAM_MUSIC} or
     * {@link #STREAM_ALARM}
     * @param direction The direction to adjust the volume. One of
     *            {@link #ADJUST_LOWER}, {@link #ADJUST_RAISE}, or
     *            {@link #ADJUST_SAME}.
     * @param flags One or more flags.
     * @see #adjustVolume(int, int)
     * @see #setStreamVolume(int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.031 -0500", hash_original_method = "C38595EDF7BD63128B5AA309C4B33E8C", hash_generated_method = "F218032D9C73953150E5E16C58158160")
    
public void adjustStreamVolume(int streamType, int direction, int flags) {
        IAudioService service = getService();
        try {
            service.adjustStreamVolume(streamType, direction, flags);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in adjustStreamVolume", e);
        }
    }

    /**
     * Adjusts the volume of the most relevant stream. For example, if a call is
     * active, it will have the highest priority regardless of if the in-call
     * screen is showing. Another example, if music is playing in the background
     * and a call is not active, the music stream will be adjusted.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param direction The direction to adjust the volume. One of
     *            {@link #ADJUST_LOWER}, {@link #ADJUST_RAISE}, or
     *            {@link #ADJUST_SAME}.
     * @param flags One or more flags.
     * @see #adjustSuggestedStreamVolume(int, int, int)
     * @see #adjustStreamVolume(int, int, int)
     * @see #setStreamVolume(int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.034 -0500", hash_original_method = "C22839B58F1A4FE03A5B8DC3C5604E6D", hash_generated_method = "54690F2E10A8222DFF0C2E7A26CB5DC9")
    
public void adjustVolume(int direction, int flags) {
        IAudioService service = getService();
        try {
            service.adjustVolume(direction, flags);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in adjustVolume", e);
        }
    }

    /**
     * Adjusts the volume of the most relevant stream, or the given fallback
     * stream.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param direction The direction to adjust the volume. One of
     *            {@link #ADJUST_LOWER}, {@link #ADJUST_RAISE}, or
     *            {@link #ADJUST_SAME}.
     * @param suggestedStreamType The stream type that will be used if there
     *            isn't a relevant stream. {@link #USE_DEFAULT_STREAM_TYPE} is valid here.
     * @param flags One or more flags.
     * @see #adjustVolume(int, int)
     * @see #adjustStreamVolume(int, int, int)
     * @see #setStreamVolume(int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.036 -0500", hash_original_method = "A437B9342B9C9807FDB6D5AE81B79F65", hash_generated_method = "452BECE7C0C73A86FB7DAAF7F7B99C32")
    
public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) {
        IAudioService service = getService();
        try {
            service.adjustSuggestedStreamVolume(direction, suggestedStreamType, flags);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in adjustVolume", e);
        }
    }

    /**
     * Returns the current ringtone mode.
     *
     * @return The current ringtone mode, one of {@link #RINGER_MODE_NORMAL},
     *         {@link #RINGER_MODE_SILENT}, or {@link #RINGER_MODE_VIBRATE}.
     * @see #setRingerMode(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.039 -0500", hash_original_method = "A5416468537A862277C3CD80415076F6", hash_generated_method = "5508A15A9CD18629BD82A5D09E2BE0FC")
    
public int getRingerMode() {
        IAudioService service = getService();
        try {
            return service.getRingerMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getRingerMode", e);
            return RINGER_MODE_NORMAL;
        }
    }

    /**
     * Returns the maximum volume index for a particular stream.
     *
     * @param streamType The stream type whose maximum volume index is returned.
     * @return The maximum valid volume index for the stream.
     * @see #getStreamVolume(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.044 -0500", hash_original_method = "87CF12BF10581D3FEA634AA8128A64C7", hash_generated_method = "D1A410D383D783C0D9ECE5ABB503CCAC")
    
public int getStreamMaxVolume(int streamType) {
        IAudioService service = getService();
        try {
            return service.getStreamMaxVolume(streamType);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getStreamMaxVolume", e);
            return 0;
        }
    }

    /**
     * Returns the current volume index for a particular stream.
     *
     * @param streamType The stream type whose volume index is returned.
     * @return The current volume index for the stream.
     * @see #getStreamMaxVolume(int)
     * @see #setStreamVolume(int, int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.047 -0500", hash_original_method = "E78E6899167FF196E0675E8746CEB32F", hash_generated_method = "E3E7BF2BF3BF4D619324530229989FA7")
    
public int getStreamVolume(int streamType) {
        IAudioService service = getService();
        try {
            return service.getStreamVolume(streamType);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getStreamVolume", e);
            return 0;
        }
    }

    /**
     * Get last audible volume before stream was muted.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.049 -0500", hash_original_method = "16B6103C3931EF2B68A7F288EB86CE17", hash_generated_method = "F8414039E19C3249B75280A911E5EA4D")
    
public int getLastAudibleStreamVolume(int streamType) {
        IAudioService service = getService();
        try {
            return service.getLastAudibleStreamVolume(streamType);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getLastAudibleStreamVolume", e);
            return 0;
        }
    }

    /**
     * Sets the ringer mode.
     * <p>
     * Silent mode will mute the volume and will not vibrate. Vibrate mode will
     * mute the volume and vibrate. Normal mode will be audible and may vibrate
     * according to user settings.
     *
     * @param ringerMode The ringer mode, one of {@link #RINGER_MODE_NORMAL},
     *            {@link #RINGER_MODE_SILENT}, or {@link #RINGER_MODE_VIBRATE}.
     * @see #getRingerMode()
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.052 -0500", hash_original_method = "3C2FC6CE4E6D1CA9BA044809D37E86F6", hash_generated_method = "4FE4A71AD9B3F5C6EAF6698ABA966799")
    
public void setRingerMode(int ringerMode) {
        if (!isValidRingerMode(ringerMode)) {
            return;
        }
        IAudioService service = getService();
        try {
            service.setRingerMode(ringerMode);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setRingerMode", e);
        }
    }

    /**
     * Sets the volume index for a particular stream.
     *
     * @param streamType The stream whose volume index should be set.
     * @param index The volume index to set. See
     *            {@link #getStreamMaxVolume(int)} for the largest valid value.
     * @param flags One or more flags.
     * @see #getStreamMaxVolume(int)
     * @see #getStreamVolume(int)
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.055 -0500", hash_original_method = "3749020B5128F4562E7A795FA2ED06F0", hash_generated_method = "E0E11CD3E1CBD290ADC87872A152CFE6")
    
public void setStreamVolume(int streamType, int index, int flags) {
        IAudioService service = getService();
        try {
            service.setStreamVolume(streamType, index, flags);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setStreamVolume", e);
        }
    }

    /**
     * Solo or unsolo a particular stream. All other streams are muted.
     * <p>
     * The solo command is protected against client process death: if a process
     * with an active solo request on a stream dies, all streams that were muted
     * because of this request will be unmuted automatically.
     * <p>
     * The solo requests for a given stream are cumulative: the AudioManager
     * can receive several solo requests from one or more clients and the stream
     * will be unsoloed only when the same number of unsolo requests are received.
     * <p>
     * For a better user experience, applications MUST unsolo a soloed stream
     * in onPause() and solo is again in onResume() if appropriate.
     *
     * @param streamType The stream to be soloed/unsoloed.
     * @param state The required solo state: true for solo ON, false for solo OFF
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.058 -0500", hash_original_method = "68979401C5E5A9876842A31A718D3CC1", hash_generated_method = "99B7183570C5B98772F75EA5FDDFE9E0")
    
public void setStreamSolo(int streamType, boolean state) {
        IAudioService service = getService();
        try {
            service.setStreamSolo(streamType, state, mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setStreamSolo", e);
        }
    }

    /**
     * Mute or unmute an audio stream.
     * <p>
     * The mute command is protected against client process death: if a process
     * with an active mute request on a stream dies, this stream will be unmuted
     * automatically.
     * <p>
     * The mute requests for a given stream are cumulative: the AudioManager
     * can receive several mute requests from one or more clients and the stream
     * will be unmuted only when the same number of unmute requests are received.
     * <p>
     * For a better user experience, applications MUST unmute a muted stream
     * in onPause() and mute is again in onResume() if appropriate.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param streamType The stream to be muted/unmuted.
     * @param state The required mute state: true for mute ON, false for mute OFF
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.060 -0500", hash_original_method = "D5FC01CA83C5AD93EBE0673BD699E427", hash_generated_method = "2AC3B35A5984620F11972D93563B9F92")
    
public void setStreamMute(int streamType, boolean state) {
        IAudioService service = getService();
        try {
            service.setStreamMute(streamType, state, mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setStreamMute", e);
        }
    }

    /**
     * get stream mute state.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.063 -0500", hash_original_method = "740B30F7577C3CCB183F4420A2F982C5", hash_generated_method = "AD2CC4C2E8AF024A7FDDC2D159843172")
    
public boolean isStreamMute(int streamType) {
        IAudioService service = getService();
        try {
            return service.isStreamMute(streamType);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isStreamMute", e);
            return false;
        }
    }

    /**
     * forces the stream controlled by hard volume keys
     * specifying streamType == -1 releases control to the
     * logic.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.065 -0500", hash_original_method = "7B6A5349C22F082B0BD2BFA86A0EB11D", hash_generated_method = "BD98F9AA9A584707283ADAEDD9C8580C")
    
public void forceVolumeControlStream(int streamType) {
        mVolumeControlStream = streamType;
    }

    /**
     * Returns whether a particular type should vibrate according to user
     * settings and the current ringer mode.
     * <p>
     * This shouldn't be needed by most clients that use notifications to
     * vibrate. The notification manager will not vibrate if the policy doesn't
     * allow it, so the client should always set a vibrate pattern and let the
     * notification manager control whether or not to actually vibrate.
     *
     * @param vibrateType The type of vibrate. One of
     *            {@link #VIBRATE_TYPE_NOTIFICATION} or
     *            {@link #VIBRATE_TYPE_RINGER}.
     * @return Whether the type should vibrate at the instant this method is
     *         called.
     * @see #setVibrateSetting(int, int)
     * @see #getVibrateSetting(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.068 -0500", hash_original_method = "F2CA732281E7EDA686D9C1A3A9E04423", hash_generated_method = "B036A0B25F288CF0CB0F0960BE635FA8")
    
public boolean shouldVibrate(int vibrateType) {
        IAudioService service = getService();
        try {
            return service.shouldVibrate(vibrateType);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in shouldVibrate", e);
            return false;
        }
    }

    /**
     * Returns whether the user's vibrate setting for a vibrate type.
     * <p>
     * This shouldn't be needed by most clients that want to vibrate, instead
     * see {@link #shouldVibrate(int)}.
     *
     * @param vibrateType The type of vibrate. One of
     *            {@link #VIBRATE_TYPE_NOTIFICATION} or
     *            {@link #VIBRATE_TYPE_RINGER}.
     * @return The vibrate setting, one of {@link #VIBRATE_SETTING_ON},
     *         {@link #VIBRATE_SETTING_OFF}, or
     *         {@link #VIBRATE_SETTING_ONLY_SILENT}.
     * @see #setVibrateSetting(int, int)
     * @see #shouldVibrate(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.071 -0500", hash_original_method = "8D15AC5DC8AF10C8514FCDAE7CA188DE", hash_generated_method = "7C4DCB2CA5105643EB611B5B1EC0F03D")
    
public int getVibrateSetting(int vibrateType) {
        IAudioService service = getService();
        try {
            return service.getVibrateSetting(vibrateType);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getVibrateSetting", e);
            return VIBRATE_SETTING_OFF;
        }
    }

    /**
     * Sets the setting for when the vibrate type should vibrate.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param vibrateType The type of vibrate. One of
     *            {@link #VIBRATE_TYPE_NOTIFICATION} or
     *            {@link #VIBRATE_TYPE_RINGER}.
     * @param vibrateSetting The vibrate setting, one of
     *            {@link #VIBRATE_SETTING_ON},
     *            {@link #VIBRATE_SETTING_OFF}, or
     *            {@link #VIBRATE_SETTING_ONLY_SILENT}.
     * @see #getVibrateSetting(int)
     * @see #shouldVibrate(int)
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.074 -0500", hash_original_method = "1BAA841F73A90E0BDF1DD9E6546FAE92", hash_generated_method = "1F5F1271B636AE869F7D5F8E5CA394F6")
    
public void setVibrateSetting(int vibrateType, int vibrateSetting) {
        IAudioService service = getService();
        try {
            service.setVibrateSetting(vibrateType, vibrateSetting);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setVibrateSetting", e);
        }
    }

    /**
     * Sets the speakerphone on or off.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param on set <var>true</var> to turn on speakerphone;
     *           <var>false</var> to turn it off
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.076 -0500", hash_original_method = "4CC8C4119BF3E8CF0A2DBE18005271BE", hash_generated_method = "ACD83D7B9DEB910D0556879B545A0EC3")
    
public void setSpeakerphoneOn(boolean on){
        IAudioService service = getService();
        try {
            service.setSpeakerphoneOn(on);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setSpeakerphoneOn", e);
        }
    }

    /**
     * Checks whether the speakerphone is on or off.
     *
     * @return true if speakerphone is on, false if it's off
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.079 -0500", hash_original_method = "87629A828DADB356D60EBD8A4600C927", hash_generated_method = "D077C518E4BDB4122F836C65B703F4BC")
    
public boolean isSpeakerphoneOn() {
        IAudioService service = getService();
        try {
            return service.isSpeakerphoneOn();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isSpeakerphoneOn", e);
            return false;
        }
     }

    /**
     * Indicates if current platform supports use of SCO for off call use cases.
     * Application wanted to use bluetooth SCO audio when the phone is not in call
     * must first call thsi method to make sure that the platform supports this
     * feature.
     * @return true if bluetooth SCO can be used for audio when not in call
     *         false otherwise
     * @see #startBluetoothSco()
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.107 -0500", hash_original_method = "AE17A85066353D3FDC3B454F62E84055", hash_generated_method = "CC31CD823B135F68DAC3C39E9BA57D81")
    
public boolean isBluetoothScoAvailableOffCall() {
        return mContext.getResources().getBoolean(
               com.android.internal.R.bool.config_bluetooth_sco_off_call);
    }

    /**
     * Start bluetooth SCO audio connection.
     * <p>Requires Permission:
     *   {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}.
     * <p>This method can be used by applications wanting to send and received audio
     * to/from a bluetooth SCO headset while the phone is not in call.
     * <p>As the SCO connection establishment can take several seconds,
     * applications should not rely on the connection to be available when the method
     * returns but instead register to receive the intent {@link #ACTION_SCO_AUDIO_STATE_UPDATED}
     * and wait for the state to be {@link #SCO_AUDIO_STATE_CONNECTED}.
     * <p>As the ACTION_SCO_AUDIO_STATE_UPDATED intent is sticky, the application can check the SCO
     * audio state before calling startBluetoothSco() by reading the intent returned by the receiver
     * registration. If the state is already CONNECTED, no state change will be received via the
     * intent after calling startBluetoothSco(). It is however useful to call startBluetoothSco()
     * so that the connection stays active in case the current initiator stops the connection.
     * <p>Unless the connection is already active as described above, the state will always
     * transition from DISCONNECTED to CONNECTING and then either to CONNECTED if the connection
     * succeeds or back to DISCONNECTED if the connection fails (e.g no headset is connected).
     * <p>When finished with the SCO connection or if the establishment fails, the application must
     * call {@link #stopBluetoothSco()} to clear the request and turn down the bluetooth connection.
     * <p>Even if a SCO connection is established, the following restrictions apply on audio
     * output streams so that they can be routed to SCO headset:
     * <ul>
     *   <li> the stream type must be {@link #STREAM_VOICE_CALL} </li>
     *   <li> the format must be mono </li>
     *   <li> the sampling must be 16kHz or 8kHz </li>
     * </ul>
     * <p>The following restrictions apply on input streams:
     * <ul>
     *   <li> the format must be mono </li>
     *   <li> the sampling must be 8kHz </li>
     * </ul>
     * <p>Note that the phone application always has the priority on the usage of the SCO
     * connection for telephony. If this method is called while the phone is in call
     * it will be ignored. Similarly, if a call is received or sent while an application
     * is using the SCO connection, the connection will be lost for the application and NOT
     * returned automatically when the call ends.
     * @see #stopBluetoothSco()
     * @see #ACTION_SCO_AUDIO_STATE_UPDATED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.110 -0500", hash_original_method = "7A79304FA4E978214D78F6217FAAF967", hash_generated_method = "2628B2ECE41E7726BD4C27D7D81398BF")
    
public void startBluetoothSco(){
        IAudioService service = getService();
        try {
            service.startBluetoothSco(mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in startBluetoothSco", e);
        }
    }

    /**
     * Stop bluetooth SCO audio connection.
     * <p>Requires Permission:
     *   {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}.
     * <p>This method must be called by applications having requested the use of
     * bluetooth SCO audio with {@link #startBluetoothSco()}
     * when finished with the SCO connection or if connection fails.
     * @see #startBluetoothSco()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.113 -0500", hash_original_method = "CADB6B26FDAB5A2B15E67AB780A2BFA8", hash_generated_method = "5B7B8553BC2B78CA5F9D41F30B4B2F65")
    
public void stopBluetoothSco(){
        IAudioService service = getService();
        try {
            service.stopBluetoothSco(mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in stopBluetoothSco", e);
        }
    }

    /**
     * Request use of Bluetooth SCO headset for communications.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param on set <var>true</var> to use bluetooth SCO for communications;
     *               <var>false</var> to not use bluetooth SCO for communications
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.116 -0500", hash_original_method = "606F2494E176D702B95CCB0A4567DEDE", hash_generated_method = "191F72459DB23E24CCD4BB0FAD06BA9A")
    
public void setBluetoothScoOn(boolean on){
        IAudioService service = getService();
        try {
            service.setBluetoothScoOn(on);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setBluetoothScoOn", e);
        }
    }

    /**
     * Checks whether communications use Bluetooth SCO.
     *
     * @return true if SCO is used for communications;
     *         false if otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.119 -0500", hash_original_method = "F2AF5947C2E51F8D76A34ACBB4A97B98", hash_generated_method = "58AD9CFDE6A3BBD405926CD1354CB40F")
    
public boolean isBluetoothScoOn() {
        IAudioService service = getService();
        try {
            return service.isBluetoothScoOn();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in isBluetoothScoOn", e);
            return false;
        }
    }

    /**
     * @param on set <var>true</var> to route A2DP audio to/from Bluetooth
     *           headset; <var>false</var> disable A2DP audio
     * @deprecated Do not use.
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.122 -0500", hash_original_method = "6E721A6BE84D0B991FC9D97F8410EE50", hash_generated_method = "1F2A41A31F689E43D60C1C6FB5A16B32")
    
@Deprecated public void setBluetoothA2dpOn(boolean on){
    }

    /**
     * Checks whether A2DP audio routing to the Bluetooth headset is on or off.
     *
     * @return true if A2DP audio is being routed to/from Bluetooth headset;
     *         false if otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.124 -0500", hash_original_method = "61CE342F240529F54025E3EC55BEFF02", hash_generated_method = "04156A819F09A72B9F265424EBD8F6C6")
    
public boolean isBluetoothA2dpOn() {
        if (AudioSystem.getDeviceConnectionState(DEVICE_OUT_BLUETOOTH_A2DP,"")
            == AudioSystem.DEVICE_STATE_UNAVAILABLE) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sets audio routing to the wired headset on or off.
     *
     * @param on set <var>true</var> to route audio to/from wired
     *           headset; <var>false</var> disable wired headset audio
     * @deprecated Do not use.
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.128 -0500", hash_original_method = "9CDD23DC97597F87B0409849BA69DD8F", hash_generated_method = "A24CF4EE215A501ADA40C929B9F4254A")
    
@Deprecated public void setWiredHeadsetOn(boolean on){
    }

    /**
     * Checks whether a wired headset is connected or not.
     * <p>This is not a valid indication that audio playback is
     * actually over the wired headset as audio routing depends on other conditions.
     *
     * @return true if a wired headset is connected.
     *         false if otherwise
     * @deprecated Use only to check is a headset is connected or not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.132 -0500", hash_original_method = "602A1375ADE38071033B07AD6C9212C8", hash_generated_method = "369BD7EA15C82661233D042DE965F1B5")
    
public boolean isWiredHeadsetOn() {
        if (AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADSET,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE &&
            AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADPHONE,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sets the microphone mute on or off.
     * <p>
     * This method should only be used by applications that replace the platform-wide
     * management of audio settings or the main telephony application.
     *
     * @param on set <var>true</var> to mute the microphone;
     *           <var>false</var> to turn mute off
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.136 -0500", hash_original_method = "5FCC6D659A56B470BF76AF68D12DD9BE", hash_generated_method = "8840E668EFF3FC76AD6E4F7CA0453893")
    
public void setMicrophoneMute(boolean on){
        AudioSystem.muteMicrophone(on);
    }

    /**
     * Checks whether the microphone mute is on or off.
     *
     * @return true if microphone is muted, false if it's not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.140 -0500", hash_original_method = "82EFB94D4DB567BF9AF21B9F2B827F69", hash_generated_method = "3B8CA7A03DE36C7844164E70C7E27715")
    
public boolean isMicrophoneMute() {
        return AudioSystem.isMicrophoneMuted();
    }

    /**
     * Sets the audio mode.
     * <p>
     * The audio mode encompasses audio routing AND the behavior of
     * the telephony layer. Therefore this method should only be used by applications that
     * replace the platform-wide management of audio settings or the main telephony application.
     * In particular, the {@link #MODE_IN_CALL} mode should only be used by the telephony
     * application when it places a phone call, as it will cause signals from the radio layer
     * to feed the platform mixer.
     *
     * @param mode  the requested audio mode ({@link #MODE_NORMAL}, {@link #MODE_RINGTONE},
     *              {@link #MODE_IN_CALL} or {@link #MODE_IN_COMMUNICATION}).
     *              Informs the HAL about the current audio state so that
     *              it can route the audio appropriately.
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.144 -0500", hash_original_method = "FB0F50379150B9BD346003DA9FF4B8A5", hash_generated_method = "55E83D2F7F0E9E2B2B08EBD375909C08")
    
public void setMode(int mode) {
        IAudioService service = getService();
        try {
            service.setMode(mode, mICallBack);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setMode", e);
        }
    }

    /**
     * Returns the current audio mode.
     *
     * @return      the current audio mode ({@link #MODE_NORMAL}, {@link #MODE_RINGTONE},
     *              {@link #MODE_IN_CALL} or {@link #MODE_IN_COMMUNICATION}).
     *              Returns the current current audio state from the HAL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.149 -0500", hash_original_method = "F6FC0C8FF20094842E05491DBD00A26F", hash_generated_method = "E888A19FEC2A5C84E6E8B23167B4189A")
    
public int getMode() {
        IAudioService service = getService();
        try {
            return service.getMode();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in getMode", e);
            return MODE_INVALID;
        }
    }

    /**
     * Sets the audio routing for a specified mode
     *
     * @param mode   audio mode to change route. E.g., MODE_RINGTONE.
     * @param routes bit vector of routes requested, created from one or
     *               more of ROUTE_xxx types. Set bits indicate that route should be on
     * @param mask   bit vector of routes to change, created from one or more of
     * ROUTE_xxx types. Unset bits indicate the route should be left unchanged
     *
     * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
     * setBluetoothScoOn() methods instead.
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.200 -0500", hash_original_method = "646817F3B93E4871A7A7D1BE098C87AE", hash_generated_method = "7CB172CD813C7EB894FCD13056B35D52")
    
@Deprecated
    public void setRouting(int mode, int routes, int mask) {
    }

    /**
     * Returns the current audio routing bit vector for a specified mode.
     *
     * @param mode audio mode to get route (e.g., MODE_RINGTONE)
     * @return an audio route bit vector that can be compared with ROUTE_xxx
     * bits
     * @deprecated   Do not query audio routing directly, use isSpeakerphoneOn(),
     * isBluetoothScoOn(), isBluetoothA2dpOn() and isWiredHeadsetOn() methods instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.203 -0500", hash_original_method = "6C4959DBE0B2C4B0BA15108AAD8EE45D", hash_generated_method = "B42A0EAEB2162061F1B63BDCBF19275A")
    
@Deprecated
    public int getRouting(int mode) {
        return -1;
    }

    /**
     * Checks whether any music is active.
     *
     * @return true if any music tracks are active.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.206 -0500", hash_original_method = "AF4716567EA0644FB4FB307583193A2C", hash_generated_method = "4517CA27CFD8EF82FE32EB42CBB9AF39")
    
public boolean isMusicActive() {
        return AudioSystem.isStreamActive(STREAM_MUSIC, 0);
    }

    /*
     * Sets a generic audio configuration parameter. The use of these parameters
     * are platform dependant, see libaudio
     *
     * ** Temporary interface - DO NOT USE
     *
     * TODO: Replace with a more generic key:value get/set mechanism
     *
     * param key   name of parameter to set. Must not be null.
     * param value value of parameter. Must not be null.
     */
    /**
     * @hide
     * @deprecated Use {@link #setPrameters(String)} instead
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.208 -0500", hash_original_method = "FB00D8D09EE0A42D5615E8AEAC323753", hash_generated_method = "FE7D713FB68EC1C32BEBFFDD433534AF")
    
@Deprecated public void setParameter(String key, String value) {
        setParameters(key+"="+value);
    }

    /**
     * Sets a variable number of parameter values to audio hardware.
     *
     * @param keyValuePairs list of parameters key value pairs in the form:
     *    key1=value1;key2=value2;...
     *
     */
    @DSSink({DSSinkKind.AUDIO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.211 -0500", hash_original_method = "18224FDA7DBAF634E3113700EF6FFA3D", hash_generated_method = "0D0A2C5AD4B9060D1787C06F6753D7CE")
    
public void setParameters(String keyValuePairs) {
        AudioSystem.setParameters(keyValuePairs);
    }

    /**
     * Sets a varaible number of parameter values to audio hardware.
     *
     * @param keys list of parameters
     * @return list of parameters key value pairs in the form:
     *    key1=value1;key2=value2;...
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.213 -0500", hash_original_method = "9B4E69B0951CD7555E74053B3F2A7F5E", hash_generated_method = "8DB2EFAC6FD3C2DFB5450609F9EFCE50")
    
public String getParameters(String keys) {
        return AudioSystem.getParameters(keys);
    }

    /**
     * Plays a sound effect (Key clicks, lid open/close...)
     * @param effectType The type of sound effect. One of
     *            {@link #FX_KEY_CLICK},
     *            {@link #FX_FOCUS_NAVIGATION_UP},
     *            {@link #FX_FOCUS_NAVIGATION_DOWN},
     *            {@link #FX_FOCUS_NAVIGATION_LEFT},
     *            {@link #FX_FOCUS_NAVIGATION_RIGHT},
     *            {@link #FX_KEYPRESS_STANDARD},
     *            {@link #FX_KEYPRESS_SPACEBAR},
     *            {@link #FX_KEYPRESS_DELETE},
     *            {@link #FX_KEYPRESS_RETURN},
     * NOTE: This version uses the UI settings to determine
     * whether sounds are heard or not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.244 -0500", hash_original_method = "68694F707C94BF6E0AD2DC63190ED9B5", hash_generated_method = "9782A52E95C5FAC91CC631A1430BE71C")
    
public void  playSoundEffect(int effectType) {
        if (effectType < 0 || effectType >= NUM_SOUND_EFFECTS) {
            return;
        }

        if (!querySoundEffectsEnabled()) {
            return;
        }

        IAudioService service = getService();
        try {
            service.playSoundEffect(effectType);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in playSoundEffect"+e);
        }
    }

    /**
     * Plays a sound effect (Key clicks, lid open/close...)
     * @param effectType The type of sound effect. One of
     *            {@link #FX_KEY_CLICK},
     *            {@link #FX_FOCUS_NAVIGATION_UP},
     *            {@link #FX_FOCUS_NAVIGATION_DOWN},
     *            {@link #FX_FOCUS_NAVIGATION_LEFT},
     *            {@link #FX_FOCUS_NAVIGATION_RIGHT},
     *            {@link #FX_KEYPRESS_STANDARD},
     *            {@link #FX_KEYPRESS_SPACEBAR},
     *            {@link #FX_KEYPRESS_DELETE},
     *            {@link #FX_KEYPRESS_RETURN},
     * @param volume Sound effect volume.
     * The volume value is a raw scalar so UI controls should be scaled logarithmically.
     * If a volume of -1 is specified, the AudioManager.STREAM_MUSIC stream volume minus 3dB will be used.
     * NOTE: This version is for applications that have their own
     * settings panel for enabling and controlling volume.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.247 -0500", hash_original_method = "F681C40806C862BA65FB1368E5E3540A", hash_generated_method = "66DE4E31642FF1CA8D8B5946EC2DAA9E")
    
public void  playSoundEffect(int effectType, float volume) {
        if (effectType < 0 || effectType >= NUM_SOUND_EFFECTS) {
            return;
        }

        IAudioService service = getService();
        try {
            service.playSoundEffectVolume(effectType, volume);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in playSoundEffect"+e);
        }
    }

    /**
     * Settings has an in memory cache, so this is fast.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.251 -0500", hash_original_method = "91B9C921984750C333F4A3D84250AE14", hash_generated_method = "9464959B0D7FB3B0DB402DD5E8E57C5B")
    
private boolean querySoundEffectsEnabled() {
        return Settings.System.getInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0) != 0;
    }

    /**
     *  Load Sound effects.
     *  This method must be called when sound effects are enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.254 -0500", hash_original_method = "A7E0D93492C6E9A5A55D1B76418A0B14", hash_generated_method = "FFC712F5F91AE12CD344CD720BE3507F")
    
public void loadSoundEffects() {
        IAudioService service = getService();
        try {
            service.loadSoundEffects();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in loadSoundEffects"+e);
        }
    }

    /**
     *  Unload Sound effects.
     *  This method can be called to free some memory when
     *  sound effects are disabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.257 -0500", hash_original_method = "43A5029AD1D52804D92188712F1A67B5", hash_generated_method = "4EB3C83ADB0A9753356167BADD99E889")
    
public void unloadSoundEffects() {
        IAudioService service = getService();
        try {
            service.unloadSoundEffects();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in unloadSoundEffects"+e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.285 -0500", hash_original_method = "19FA7B2AF0BC01FED1DAA16E011C492D", hash_generated_method = "994DCE6748BC36ECA0536A8470818A68")
    
private OnAudioFocusChangeListener findFocusListener(String id) {
        return mAudioFocusIdListenerMap.get(id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.311 -0500", hash_original_method = "F0553D3D8E69373BA6CE7B065E0EBE95", hash_generated_method = "AABE0F01F378642F0F953D3EEFBF1A74")
    
private String getIdForAudioFocusListener(OnAudioFocusChangeListener l) {
        if (l == null) {
            return new String(this.toString());
        } else {
            return new String(this.toString() + l.toString());
        }
    }

    /**
     * @hide
     * Registers a listener to be called when audio focus changes. Calling this method is optional
     * before calling {@link #requestAudioFocus(OnAudioFocusChangeListener, int, int)}, as it
     * will register the listener as well if it wasn't registered already.
     * @param l the listener to be notified of audio focus changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.313 -0500", hash_original_method = "C22DD0E9B28263E867F443548BB38A4B", hash_generated_method = "ED45871B08142B196B82E18951ED9447")
    
public void registerAudioFocusListener(OnAudioFocusChangeListener l) {
        synchronized(mFocusListenerLock) {
            if (mAudioFocusIdListenerMap.containsKey(getIdForAudioFocusListener(l))) {
                return;
            }
            mAudioFocusIdListenerMap.put(getIdForAudioFocusListener(l), l);
        }
    }

    /**
     * @hide
     * Causes the specified listener to not be called anymore when focus is gained or lost.
     * @param l the listener to unregister.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.316 -0500", hash_original_method = "A69B5FF5652C2B6DCC8DE23DBE317A35", hash_generated_method = "B7FE34296B4F9F0D69F818C752D126F2")
    
public void unregisterAudioFocusListener(OnAudioFocusChangeListener l) {

        // remove locally
        synchronized(mFocusListenerLock) {
            mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(l));
        }
    }

    /**
     *  Request audio focus.
     *  Send a request to obtain the audio focus
     *  @param l the listener to be notified of audio focus changes
     *  @param streamType the main audio stream type affected by the focus request
     *  @param durationHint use {@link #AUDIOFOCUS_GAIN_TRANSIENT} to indicate this focus request
     *      is temporary, and focus will be abandonned shortly. Examples of transient requests are
     *      for the playback of driving directions, or notifications sounds.
     *      Use {@link #AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK} to indicate also that it's ok for
     *      the previous focus owner to keep playing if it ducks its audio output.
     *      Use {@link #AUDIOFOCUS_GAIN} for a focus request of unknown duration such
     *      as the playback of a song or a video.
     *  @return {@link #AUDIOFOCUS_REQUEST_FAILED} or {@link #AUDIOFOCUS_REQUEST_GRANTED}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.324 -0500", hash_original_method = "15F0A18D8B83DF0E5C3CD27FFCEED082", hash_generated_method = "6E143F48E05EFC7863B60522E85BB683")
    
public int requestAudioFocus(OnAudioFocusChangeListener l, int streamType, int durationHint) {
        int status = AUDIOFOCUS_REQUEST_FAILED;
        if ((durationHint < AUDIOFOCUS_GAIN) || (durationHint > AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK))
        {
            Log.e(TAG, "Invalid duration hint, audio focus request denied");
            return status;
        }
        registerAudioFocusListener(l);
        //TODO protect request by permission check?
        IAudioService service = getService();
        try {
            status = service.requestAudioFocus(streamType, durationHint, mICallBack,
                    mAudioFocusDispatcher, getIdForAudioFocusListener(l),
                    mContext.getPackageName() /* package name */);
        } catch (RemoteException e) {
            Log.e(TAG, "Can't call requestAudioFocus() from AudioService due to "+e);
        }
        return status;
    }

    /**
     *  Abandon audio focus. Causes the previous focus owner, if any, to receive focus.
     *  @param l the listener with which focus was requested.
     *  @return {@link #AUDIOFOCUS_REQUEST_FAILED} or {@link #AUDIOFOCUS_REQUEST_GRANTED}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.327 -0500", hash_original_method = "32D2590B7FC8AFB5DC09D66E2CA73EB1", hash_generated_method = "21579358F332629CF31E0E350183F580")
    
public int abandonAudioFocus(OnAudioFocusChangeListener l) {
        int status = AUDIOFOCUS_REQUEST_FAILED;
        unregisterAudioFocusListener(l);
        IAudioService service = getService();
        try {
            status = service.abandonAudioFocus(mAudioFocusDispatcher,
                    getIdForAudioFocusListener(l));
        } catch (RemoteException e) {
            Log.e(TAG, "Can't call abandonAudioFocus() from AudioService due to "+e);
        }
        return status;
    }

    //====================================================================
    // Remote Control
    /**
     * Register a component to be the sole receiver of MEDIA_BUTTON intents.
     * @param eventReceiver identifier of a {@link android.content.BroadcastReceiver}
     *      that will receive the media button intent. This broadcast receiver must be declared
     *      in the application manifest. The package of the component must match that of
     *      the context you're registering from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.330 -0500", hash_original_method = "50EC2C592ADEFE7D217B837E9C2D3748", hash_generated_method = "FF871B2A83C34CECCD452A175FD29C2D")
    
public void registerMediaButtonEventReceiver(ComponentName eventReceiver) {
        if (eventReceiver == null) {
            return;
        }
        if (!eventReceiver.getPackageName().equals(mContext.getPackageName())) {
            Log.e(TAG, "registerMediaButtonEventReceiver() error: " +
                    "receiver and context package names don't match");
            return;
        }
        // construct a PendingIntent for the media button and register it
        Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        //     the associated intent will be handled by the component being registered
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi = PendingIntent.getBroadcast(mContext,
                0/*requestCode, ignored*/, mediaButtonIntent, 0/*flags*/);
        registerMediaButtonIntent(pi, eventReceiver);
    }

    /**
     * @hide
     * no-op if (pi == null) or (eventReceiver == null)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.333 -0500", hash_original_method = "F3457417B719B94CC07450473FCEA34B", hash_generated_method = "6A45D7D70E73CACF95825B982E8CFCC5")
    
public void registerMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        if ((pi == null) || (eventReceiver == null)) {
            Log.e(TAG, "Cannot call registerMediaButtonIntent() with a null parameter");
            return;
        }
        IAudioService service = getService();
        try {
            // pi != null
            service.registerMediaButtonIntent(pi, eventReceiver);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in registerMediaButtonIntent"+e);
        }
    }

    /**
     * Unregister the receiver of MEDIA_BUTTON intents.
     * @param eventReceiver identifier of a {@link android.content.BroadcastReceiver}
     *      that was registered with {@link #registerMediaButtonEventReceiver(ComponentName)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.335 -0500", hash_original_method = "50FCC009A55C4B527D3EADAFCCF926C2", hash_generated_method = "B08E5578BA52F57410A395515F4F1E33")
    
public void unregisterMediaButtonEventReceiver(ComponentName eventReceiver) {
        if (eventReceiver == null) {
            return;
        }
        // construct a PendingIntent for the media button and unregister it
        Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        //     the associated intent will be handled by the component being registered
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi = PendingIntent.getBroadcast(mContext,
                0/*requestCode, ignored*/, mediaButtonIntent, 0/*flags*/);
        unregisterMediaButtonIntent(pi, eventReceiver);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.338 -0500", hash_original_method = "FD1680BE817579074A9AB3657CE1A622", hash_generated_method = "8FE3B48BD4FAC414A2E607965A64BFA2")
    
public void unregisterMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        IAudioService service = getService();
        try {
            service.unregisterMediaButtonIntent(pi, eventReceiver);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in unregisterMediaButtonIntent"+e);
        }
    }

    /**
     * Registers the remote control client for providing information to display on the remote
     * controls.
     * @param rcClient The remote control client from which remote controls will receive
     *      information to display.
     * @see RemoteControlClient
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.341 -0500", hash_original_method = "226F7C4DEEA463C35DD22DDAE8FCA983", hash_generated_method = "43A97832DAC05830FE6AB0698A3BDBFF")
    
public void registerRemoteControlClient(RemoteControlClient rcClient) {
        if ((rcClient == null) || (rcClient.getRcMediaIntent() == null)) {
            return;
        }
        IAudioService service = getService();
        try {
            service.registerRemoteControlClient(rcClient.getRcMediaIntent(),   /* mediaIntent   */
                    rcClient.getIRemoteControlClient(),                        /* rcClient      */
                    // used to match media button event receiver and audio focus
                    mContext.getPackageName());                                /* packageName   */
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in registerRemoteControlClient"+e);
        }
    }

    /**
     * Unregisters the remote control client that was providing information to display on the
     * remote controls.
     * @param rcClient The remote control client to unregister.
     * @see #registerRemoteControlClient(RemoteControlClient)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.343 -0500", hash_original_method = "61965062F9C113F5A501568B9F9D00FE", hash_generated_method = "F3B68DDCB4B5D644E2811C9E0FD270CB")
    
public void unregisterRemoteControlClient(RemoteControlClient rcClient) {
        if ((rcClient == null) || (rcClient.getRcMediaIntent() == null)) {
            return;
        }
        IAudioService service = getService();
        try {
            service.unregisterRemoteControlClient(rcClient.getRcMediaIntent(), /* mediaIntent   */
                    rcClient.getIRemoteControlClient());                       /* rcClient      */
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in unregisterRemoteControlClient"+e);
        }
    }

    /**
     * @hide
     * Registers a remote control display that will be sent information by remote control clients.
     * @param rcd
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.346 -0500", hash_original_method = "F5BDE54913D135C31C9BD838A5D1535F", hash_generated_method = "1E6ECE083F1E2B8297B47BDAE91DEF7D")
    
public void registerRemoteControlDisplay(IRemoteControlDisplay rcd) {
        if (rcd == null) {
            return;
        }
        IAudioService service = getService();
        try {
            service.registerRemoteControlDisplay(rcd);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in registerRemoteControlDisplay " + e);
        }
    }

    /**
     * @hide
     * Unregisters a remote control display that was sent information by remote control clients.
     * @param rcd
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.349 -0500", hash_original_method = "0BDA4E172FD98A7582B88621FA3E6CCD", hash_generated_method = "E7032A5718323801B078AF250207FAE8")
    
public void unregisterRemoteControlDisplay(IRemoteControlDisplay rcd) {
        if (rcd == null) {
            return;
        }
        IAudioService service = getService();
        try {
            service.unregisterRemoteControlDisplay(rcd);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in unregisterRemoteControlDisplay " + e);
        }
    }

    /**
     * @hide
     * Sets the artwork size a remote control display expects when receiving bitmaps.
     * @param rcd
     * @param w the maximum width of the expected bitmap. Negative values indicate it is
     *   useless to send artwork.
     * @param h the maximum height of the expected bitmap. Negative values indicate it is
     *   useless to send artwork.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.352 -0500", hash_original_method = "2551461E9D10B148584E49E52F82D704", hash_generated_method = "80BA9C0A0706F2A348A22C03B5135219")
    
public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay rcd, int w, int h) {
        if (rcd == null) {
            return;
        }
        IAudioService service = getService();
        try {
            service.remoteControlDisplayUsesBitmapSize(rcd, w, h);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in remoteControlDisplayUsesBitmapSize " + e);
        }
    }

    /**
     *  @hide
     *  Reload audio settings. This method is called by Settings backup
     *  agent when audio settings are restored and causes the AudioService
     *  to read and apply restored settings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.368 -0500", hash_original_method = "CCB01AEEA7F61A25F19F08696D9B58D5", hash_generated_method = "0D13B15D47627A68B306CC9FD713DDD1")
    
public void reloadAudioSettings() {
        IAudioService service = getService();
        try {
            service.reloadAudioSettings();
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in reloadAudioSettings"+e);
        }
    }

    /**
     * Checks whether the phone is in silent mode, with or without vibrate.
     *
     * @return true if phone is in silent mode, with or without vibrate.
     *
     * @see #getRingerMode()
     *
     * @hide pending API Council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.374 -0500", hash_original_method = "0E7D5155727C2E176622AABD0BAF6345", hash_generated_method = "C803C03A8CD1EED08B66648A5D51B3EF")
    
public boolean isSilentMode() {
        int ringerMode = getRingerMode();
        boolean silentMode =
            (ringerMode == RINGER_MODE_SILENT) ||
            (ringerMode == RINGER_MODE_VIBRATE);
        return silentMode;
    }

    /**
     * Return the enabled devices for the specified output stream type.
     *
     * @param streamType The stream type to query. One of
     *            {@link #STREAM_VOICE_CALL},
     *            {@link #STREAM_SYSTEM},
     *            {@link #STREAM_RING},
     *            {@link #STREAM_MUSIC},
     *            {@link #STREAM_ALARM},
     *            {@link #STREAM_NOTIFICATION},
     *            {@link #STREAM_DTMF}.
     *
     * @return The bit-mask "or" of audio output device codes for all enabled devices on this
     *         stream. Zero or more of
     *            {@link #DEVICE_OUT_EARPIECE},
     *            {@link #DEVICE_OUT_SPEAKER},
     *            {@link #DEVICE_OUT_WIRED_HEADSET},
     *            {@link #DEVICE_OUT_WIRED_HEADPHONE},
     *            {@link #DEVICE_OUT_BLUETOOTH_SCO},
     *            {@link #DEVICE_OUT_BLUETOOTH_SCO_HEADSET},
     *            {@link #DEVICE_OUT_BLUETOOTH_SCO_CARKIT},
     *            {@link #DEVICE_OUT_BLUETOOTH_A2DP},
     *            {@link #DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES},
     *            {@link #DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER},
     *            {@link #DEVICE_OUT_AUX_DIGITAL},
     *            {@link #DEVICE_OUT_ANLG_DOCK_HEADSET},
     *            {@link #DEVICE_OUT_DGTL_DOCK_HEADSET}.
     *            {@link #DEVICE_OUT_DEFAULT} is not used here.
     *
     * The implementation may support additional device codes beyond those listed, so
     * the application should ignore any bits which it does not recognize.
     * Note that the information may be imprecise when the implementation
     * cannot distinguish whether a particular device is enabled.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:22.416 -0500", hash_original_method = "039E984EE545D8462E074EC6768B62D9", hash_generated_method = "10A5D5FCC997CCA92895D4640CEB8888")
    
public int getDevicesForStream(int streamType) {
        switch (streamType) {
        case STREAM_VOICE_CALL:
        case STREAM_SYSTEM:
        case STREAM_RING:
        case STREAM_MUSIC:
        case STREAM_ALARM:
        case STREAM_NOTIFICATION:
        case STREAM_DTMF:
            return AudioSystem.getDevicesForStream(streamType);
        default:
            return 0;
        }
    }
}

