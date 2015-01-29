package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AndroidException;
import android.util.DisplayMetrics;

public abstract class PackageManager {

    /**
     * Checks to see if the user id is the same for the two uids, i.e., they belong to the same
     * user.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.780 -0500", hash_original_method = "C886A1F4AC1BEA7F445F1AC60A095F6B", hash_generated_method = "747D4FECDA5081F50BA85A7F0D4DE332")
    
public static boolean isSameUser(int uid1, int uid2) {
        return 1 == (getUserId(uid1) + getUserId(uid2));
    }

    /**
     * Returns the user id for a given uid.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.783 -0500", hash_original_method = "A84CBDAF203E04C37517B2B049D94324", hash_generated_method = "D2325F46628B29CBA677598D94A5C588")
    
public static int getUserId(int uid) {
        return uid / PER_USER_RANGE;
    }

    /**
     * Returns the uid that is composed from the userId and the appId.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.785 -0500", hash_original_method = "4C3A46A3FD3C2F319FC729999FF73ED4", hash_generated_method = "038F21D5B375C0A0BD5391702E1E366F")
    
public static int getUid(int userId, int appId) {
        return userId * PER_USER_RANGE + (appId % PER_USER_RANGE);
    }

    /**
     * Returns the app id (or base uid) for a given uid, stripping out the user id from it.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.787 -0500", hash_original_method = "B1083B466D22A889839A58AF9FE9DF65", hash_generated_method = "4634241AF1FCC7FC78418BBA9F8EAE0C")
    
public static int getAppId(int uid) {
        return uid % PER_USER_RANGE;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.253 -0500", hash_original_field = "D789F6AF2C76511A90A42D7C916C9593", hash_generated_field = "8835CBE4CE0B754883D72C73052F7340")

    public static final int GET_ACTIVITIES              = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.256 -0500", hash_original_field = "7826A28F1CDD9FFC632CFA45ADC8A0AD", hash_generated_field = "B56AAA9B031EB606FF7E6C87942F5617")

    public static final int GET_RECEIVERS               = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.258 -0500", hash_original_field = "048DD7B6B0920E7166BBF11A9B9879D0", hash_generated_field = "7749562F77593827C12B144952B7B1D1")

    public static final int GET_SERVICES                = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.261 -0500", hash_original_field = "3CD11D2B8FC355C7A78AE9796D27F421", hash_generated_field = "2ADE93E0E1D3795BA5B3CB2C54142808")

    public static final int GET_PROVIDERS               = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.263 -0500", hash_original_field = "30EEAB9C3750ACAAFEB31B3D0C49C454", hash_generated_field = "8A2E0D6696D0FD634C8E785FA5E75ECA")

    public static final int GET_INSTRUMENTATION         = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.265 -0500", hash_original_field = "9E88097F0EF891D227AA0DF36A5682B0", hash_generated_field = "28B8705AF671D4DC8D12514CA019DD0A")

    public static final int GET_INTENT_FILTERS          = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.267 -0500", hash_original_field = "F6CFCA7BD52C832596024442C6491C52", hash_generated_field = "AF42ACE4DCC03A4B37A4A567D706A18D")

    public static final int GET_SIGNATURES          = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.269 -0500", hash_original_field = "820596FC73E070955B6A0EF5D6261D99", hash_generated_field = "6DDF54A31666DE64251AF204B2AA6258")

    public static final int GET_RESOLVED_FILTER         = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.272 -0500", hash_original_field = "ACB1E56B7ADA3D013EC4B7019869941E", hash_generated_field = "66064721BF12B0315455979FF1300A94")

    public static final int GET_META_DATA               = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.275 -0500", hash_original_field = "ECB280D32058E26C05240BC26F6A16F6", hash_generated_field = "B1283A740C142DB27865E7F5436847EA")

    public static final int GET_GIDS                    = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.278 -0500", hash_original_field = "F6B5D520F7B9786F2E61029BE43A20D6", hash_generated_field = "06AF2F3D6CFCE9ECA35522021C2DE22A")

    public static final int GET_DISABLED_COMPONENTS     = 0x00000200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.280 -0500", hash_original_field = "240916412FF087D37B9344C2DB3E3813", hash_generated_field = "7D0EBBA6244EB83212355F98FCAA0F55")

    public static final int GET_SHARED_LIBRARY_FILES    = 0x00000400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.283 -0500", hash_original_field = "60EE2663CA097E96BA71C6DAFA83B33E", hash_generated_field = "A7322E230AB00161DC815F03D7A201B0")

    public static final int GET_URI_PERMISSION_PATTERNS  = 0x00000800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.285 -0500", hash_original_field = "BC1420BDC81AF24028F7CFFD3D02AC34", hash_generated_field = "782F84C837524047813E86F68A3CBD94")

    public static final int GET_PERMISSIONS               = 0x00001000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.287 -0500", hash_original_field = "068AFE25DB1C8707299A8D7DFAFC6922", hash_generated_field = "309C0FBBBFA8EF19181AE069151AB441")

    public static final int GET_UNINSTALLED_PACKAGES = 0x00002000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.290 -0500", hash_original_field = "448F8DCDB7C52EFF78657E10C208B1B4", hash_generated_field = "5C4F1708189F9DB7CF8C36799A9EB0DC")

    public static final int GET_CONFIGURATIONS = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.292 -0500", hash_original_field = "D1632C52B728721E90C3FED9079F17FB", hash_generated_field = "09E41AAC66CFA9D776BBA98350692A92")

    public static final int MATCH_DEFAULT_ONLY   = 0x00010000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.294 -0500", hash_original_field = "30D6044C6CC228AC13FA8052242EF4CC", hash_generated_field = "988CB1C84138636A2341ED6D4C04F9CE")

    public static final int PERMISSION_GRANTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.297 -0500", hash_original_field = "4FF37FF922FAD9DA1763881700929C65", hash_generated_field = "37A1C5811F9D199DCB56EEFBC8B7C4D2")

    public static final int PERMISSION_DENIED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.299 -0500", hash_original_field = "AF0E3891A4345838304AEF6F6BDB3A82", hash_generated_field = "374E488B974AD69BC95B2D0DFDCAE230")

    public static final int SIGNATURE_MATCH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.301 -0500", hash_original_field = "F88296322B8140879B57A24E8C0D0CEC", hash_generated_field = "30A037B660A5F83E54D18BE8401D85FB")

    public static final int SIGNATURE_NEITHER_SIGNED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.304 -0500", hash_original_field = "083B5BCC0C0DAF72D9CA87B572EF212D", hash_generated_field = "93903F2EE521757BFE482886534B59CB")

    public static final int SIGNATURE_FIRST_NOT_SIGNED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.307 -0500", hash_original_field = "39CA7449ACE5B304086A4F068BE06D0C", hash_generated_field = "FE021ADD6CC79476525AD74C4CDB759E")

    public static final int SIGNATURE_SECOND_NOT_SIGNED = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.309 -0500", hash_original_field = "BEDB3CC28A46D9C6DCFD535904E5BCCC", hash_generated_field = "6E9202516DB101D5B8E2793DC5B76280")

    public static final int SIGNATURE_NO_MATCH = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.311 -0500", hash_original_field = "87B6DBA5074F24559EC1EB3B0315917C", hash_generated_field = "1B9E62FD34D478215EFCE4AABFB46830")

    public static final int SIGNATURE_UNKNOWN_PACKAGE = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.313 -0500", hash_original_field = "9B9E27D3D8D7CE2F31A941FDCE68AF5B", hash_generated_field = "72DB62D09405617653662EFE3FEA3110")

    public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.316 -0500", hash_original_field = "8A7C6D87084A7A0F98E861C0AA554754", hash_generated_field = "76E65EB7818872A36A30E103241A0479")

    public static final int COMPONENT_ENABLED_STATE_ENABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.319 -0500", hash_original_field = "EC8D1193F4324CF65FC3ADEADBC36E50", hash_generated_field = "CE4F48389F97C7C47624D919814D1E00")

    public static final int COMPONENT_ENABLED_STATE_DISABLED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.322 -0500", hash_original_field = "BA7311CF465F373F08C4B0B5C746323C", hash_generated_field = "6BB463E712BD6BD23A569CF03E4F870B")

    public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.324 -0500", hash_original_field = "25090300ED094CB91779F2311BD680BA", hash_generated_field = "53998F446B97520BCBB4EE0F9378E627")

    public static final int INSTALL_FORWARD_LOCK = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.326 -0500", hash_original_field = "CD243D6AA12A37A787AA24D5D7EDEF6F", hash_generated_field = "20FDE9811765D69AB2965C00136B8789")

    public static final int INSTALL_REPLACE_EXISTING = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.328 -0500", hash_original_field = "92CBC1AF9F8EFC18C54BCED11DD430CA", hash_generated_field = "7EBFA62E2137E293FB91AA00D096DA03")

    public static final int INSTALL_ALLOW_TEST = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.331 -0500", hash_original_field = "BE25E26D0EE7A75F4870FBA83BBAF5D2", hash_generated_field = "E39C569C6D9E6A2F8A237A22B6B11F94")

    public static final int INSTALL_EXTERNAL = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.333 -0500", hash_original_field = "854E697138FA4CE70013517BC25C4B51", hash_generated_field = "5766A98F12F79E80073889BC9A9B89E0")

    public static final int INSTALL_INTERNAL = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.336 -0500", hash_original_field = "5A6202B2919949C83C1B2AE9874C8C6F", hash_generated_field = "A8D5C996562F61731EC5A89E902A606F")

    public static final int INSTALL_FROM_ADB = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.338 -0500", hash_original_field = "FE4A3CB402B4F6C1013573EC7255F8E1", hash_generated_field = "017976232B1A2FA8B515853213E669F5")

    public static final int DONT_KILL_APP = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.341 -0500", hash_original_field = "34CBD7561F4CED241D141FE6328BD7EA", hash_generated_field = "BB69D3C367BA41FA0137D2D68BB6EDB1")

    public static final int INSTALL_SUCCEEDED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.343 -0500", hash_original_field = "07C3B53DACDABE9948F78ABB54C692A9", hash_generated_field = "BB002B25BA9F008244A674D5CD097465")

    public static final int INSTALL_FAILED_ALREADY_EXISTS = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.346 -0500", hash_original_field = "0EF6D59509993C15C40590FDCB8FA1B6", hash_generated_field = "32ADCBE30B6713F77BB7D4CBB3BF9331")

    public static final int INSTALL_FAILED_INVALID_APK = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.349 -0500", hash_original_field = "9AD0A7556516A0A10102C0EBD4EE3C40", hash_generated_field = "0FB73805AF4C859A2F4D548856CEADF4")

    public static final int INSTALL_FAILED_INVALID_URI = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.352 -0500", hash_original_field = "5D60347B63FD8175681D77898338F593", hash_generated_field = "783A1EE276B467AFD25E85C442212E8B")

    public static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.354 -0500", hash_original_field = "620923B12F61DD3376E761DE71AB8272", hash_generated_field = "DEED5A5820F59FA8CA2B2ECD92FD55D3")

    public static final int INSTALL_FAILED_DUPLICATE_PACKAGE = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.357 -0500", hash_original_field = "C3E1DB8155129D84C012EA9BA1EF91BA", hash_generated_field = "707BB77C14F03CE7C097E70005742033")

    public static final int INSTALL_FAILED_NO_SHARED_USER = -6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.359 -0500", hash_original_field = "5402F037F34D9AF08D481BBBB18A5486", hash_generated_field = "60B83E53186015B2A9825FA18656DA92")

    public static final int INSTALL_FAILED_UPDATE_INCOMPATIBLE = -7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.361 -0500", hash_original_field = "F16F7BD17A50C99EA7B8321C1B16B113", hash_generated_field = "A10BF18CEFC09CCD50B8FC5EDA9D1382")

    public static final int INSTALL_FAILED_SHARED_USER_INCOMPATIBLE = -8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.363 -0500", hash_original_field = "9EE0CD843FDB1290B345C58E3C84FC66", hash_generated_field = "07096244FD68D8287EDED484DE04A175")

    public static final int INSTALL_FAILED_MISSING_SHARED_LIBRARY = -9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.366 -0500", hash_original_field = "256AE825FF148D17D79289E9589BA899", hash_generated_field = "C4AB282024E7E7CD3A2100AFE8454CB0")

    public static final int INSTALL_FAILED_REPLACE_COULDNT_DELETE = -10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.369 -0500", hash_original_field = "DB01C8664208248DAF6C0A69F7167A19", hash_generated_field = "8FE02745A657F089401D722E273A9EB1")

    public static final int INSTALL_FAILED_DEXOPT = -11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.371 -0500", hash_original_field = "7DC298EDD6F9319092E2F58D264E9CEC", hash_generated_field = "296DD98FB4EBE40DF71AAB8363792B1C")

    public static final int INSTALL_FAILED_OLDER_SDK = -12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.373 -0500", hash_original_field = "036CFC12F25D04A2C99705CC0A742FE6", hash_generated_field = "10FD2B841F28F975C4F98674C290F51E")

    public static final int INSTALL_FAILED_CONFLICTING_PROVIDER = -13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.376 -0500", hash_original_field = "FE0E99E72CE0C7983F763B0E07040646", hash_generated_field = "77490BB5B251CE3C1A27AF55D0B188D4")

    public static final int INSTALL_FAILED_NEWER_SDK = -14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.378 -0500", hash_original_field = "E868F4369AC6AA72FD5E9BDDA28DA6EE", hash_generated_field = "8D305CE1383E37873D4D1BD5A4B7E8E6")

    public static final int INSTALL_FAILED_TEST_ONLY = -15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.380 -0500", hash_original_field = "5BA9EB2F44372C4B0A400B1B262B1526", hash_generated_field = "96DEA7F6DFB814D87AFCE6EA666BD00A")

    public static final int INSTALL_FAILED_CPU_ABI_INCOMPATIBLE = -16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.383 -0500", hash_original_field = "7899872663C8048852AAF6BD00B58844", hash_generated_field = "5BB31230331D8F3C9D5C02CFEF95722C")

    public static final int INSTALL_FAILED_MISSING_FEATURE = -17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.385 -0500", hash_original_field = "5B3916D8921407F8120B4D01F6975655", hash_generated_field = "7983C2021939A6E25207267486FED5E3")

    /**
     * Installation return code: this is passed to the {@link IPackageInstallObserver} by
     * {@link #installPackage(android.net.Uri, IPackageInstallObserver, int)} if
     * a secure container mount point couldn't be accessed on external media.
     * @hide
     */
    public static final int INSTALL_FAILED_CONTAINER_ERROR = -18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.388 -0500", hash_original_field = "56F8A30BDF7B2D177C8B15A3DF23153F", hash_generated_field = "4BE142C3D62FB54C919846B431203706")

    public static final int INSTALL_FAILED_INVALID_INSTALL_LOCATION = -19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.390 -0500", hash_original_field = "7312491273B159771266200F47D0A1A8", hash_generated_field = "AD98C675AA9F8BCA928FD21EECF51815")

    public static final int INSTALL_FAILED_MEDIA_UNAVAILABLE = -20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.392 -0500", hash_original_field = "936F8B09C75D4D529CB2CC8E2A08A0DB", hash_generated_field = "D7F60DA01815774353AA878046B6C75C")

    public static final int INSTALL_FAILED_VERIFICATION_TIMEOUT = -21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.395 -0500", hash_original_field = "81FBADC876BE3B9A39051E3B816A64B5", hash_generated_field = "7CCDB7584449904BF693046A069200BA")

    public static final int INSTALL_FAILED_VERIFICATION_FAILURE = -22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.397 -0500", hash_original_field = "C2CA53692975350CD9BDCF2270982C77", hash_generated_field = "E56D811927BC429506BC4E78E921FC57")

    public static final int INSTALL_FAILED_PACKAGE_CHANGED = -23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.400 -0500", hash_original_field = "EF8A0D969BD1FED62F5C9B9B9DDF878B", hash_generated_field = "6DFA98FEEEC950C10623AE20798D84EA")

    public static final int INSTALL_PARSE_FAILED_NOT_APK = -100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.402 -0500", hash_original_field = "A82B96E9CB136BB29E1F5E6E7EFF4A75", hash_generated_field = "B6A3E8C1ACB331579BCBE41909E79354")

    public static final int INSTALL_PARSE_FAILED_BAD_MANIFEST = -101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.404 -0500", hash_original_field = "EE62F7DE46B8358C02EB9329D7FFB588", hash_generated_field = "80CA3A85070074E65A0B64A8C6C69F67")

    public static final int INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION = -102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.407 -0500", hash_original_field = "C1FF445873FD02BCCD007DB81F29A8EE", hash_generated_field = "CBD2AA9EB6E1CFF6B67E573A35221C66")

    public static final int INSTALL_PARSE_FAILED_NO_CERTIFICATES = -103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.411 -0500", hash_original_field = "8EEBF9E614A79BC1E13D9DEC6BD3A391", hash_generated_field = "8346AF74F58CE04F687258995BA281EE")

    public static final int INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES = -104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.413 -0500", hash_original_field = "285927728C159CE29C826AF2AF70C30B", hash_generated_field = "BE348BE8284E1726D7F1AB80DCC2918C")

    public static final int INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING = -105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.416 -0500", hash_original_field = "150A328068672977368CE7823AFC9A2F", hash_generated_field = "F10E5708AC29C48BC33EBBF09F712A32")

    public static final int INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME = -106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.418 -0500", hash_original_field = "ED9EF3800876E0FE3EDB8A7E89A77837", hash_generated_field = "E6968AD576EC18FB322655D174551AB6")

    public static final int INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID = -107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.421 -0500", hash_original_field = "8FC838F2DFA824E419F708C2E38E209B", hash_generated_field = "BD24EADBCA7980C6DFE0E13CC54A80FC")

    public static final int INSTALL_PARSE_FAILED_MANIFEST_MALFORMED = -108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.423 -0500", hash_original_field = "88FAE8D37687B33032D9D7734735C857", hash_generated_field = "B9F24DFB13FCF835F1A03078B5ACBAD3")

    public static final int INSTALL_PARSE_FAILED_MANIFEST_EMPTY = -109;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.426 -0500", hash_original_field = "5AB1CD7501C21E3E5EE99C9539768364", hash_generated_field = "A60C7F324C871F5772B06A2E6FFC7DA5")

    public static final int INSTALL_FAILED_INTERNAL_ERROR = -110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.428 -0500", hash_original_field = "71CC95D89D9A71BFE6A30E63167DC338", hash_generated_field = "71C388D2290D7462D3B4449437F0426A")

    public static final int DONT_DELETE_DATA = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.430 -0500", hash_original_field = "C631616A66259B3E4DCCBED54893A97A", hash_generated_field = "8E16A0EF46BE9D68C9483C709B30CE43")

    public static final int DELETE_SUCCEEDED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.433 -0500", hash_original_field = "56BF8CE6096C64171B55355E6D65589D", hash_generated_field = "6DF469509659AC3E527E2FC62F559BC4")

    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.435 -0500", hash_original_field = "6A4A5833C4C101FF544DA4F8CF729E0D", hash_generated_field = "CB8C61D9898E72762977ECE6BB93CFAB")

    public static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.438 -0500", hash_original_field = "BC0006C35E61557F45FE9FF2B71FE169", hash_generated_field = "460CFF44C0D25B86D8AA467B86A32473")

    public static final int MOVE_SUCCEEDED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.441 -0500", hash_original_field = "96BC904DF305D2FF355DE3FC84A47860", hash_generated_field = "339FEBE6E44E2F8C8BDF1A89864C95B7")

    public static final int MOVE_FAILED_INSUFFICIENT_STORAGE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.443 -0500", hash_original_field = "B819F6183764D2995714838DBAD382C4", hash_generated_field = "BE5F3F1F7CD5063D5F1519F2892D74BE")

    public static final int MOVE_FAILED_DOESNT_EXIST = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.445 -0500", hash_original_field = "CFFF0B78775FF94970C76954EE5FC742", hash_generated_field = "73120951BD5FCB046885911A5DFF6513")

    public static final int MOVE_FAILED_SYSTEM_PACKAGE = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.447 -0500", hash_original_field = "6629B8689F15AF957902766459A77B1C", hash_generated_field = "72296DA6AACAFCB8200B0736E31BD0D4")

    public static final int MOVE_FAILED_FORWARD_LOCKED = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.450 -0500", hash_original_field = "37CB1DFE7CC6074EEF079EB473B01511", hash_generated_field = "783B646465A77C663C30697C00F1383E")

    public static final int MOVE_FAILED_INVALID_LOCATION = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.452 -0500", hash_original_field = "0BD56A76587C4712059692F0B0F94DB1", hash_generated_field = "E7D221D0CF0E9F725AC8E4F4E07D3DDD")

    public static final int MOVE_FAILED_INTERNAL_ERROR = -6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.455 -0500", hash_original_field = "BA2FFB282E55A6C8594D9959A818C6C7", hash_generated_field = "3E4D6CFB76A16893C4E0D1E164ABD472")

    public static final int MOVE_FAILED_OPERATION_PENDING = -7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.457 -0500", hash_original_field = "6ED0F9CB85C77636BEA7210C363BC6E2", hash_generated_field = "A2C7D052C499D0CE8F0A041637001867")

    public static final int MOVE_INTERNAL = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.460 -0500", hash_original_field = "FA85C00B81216FA997D55A88CBBF482C", hash_generated_field = "7ADFF79D0D7A5C61C74022EC785CF907")

    public static final int MOVE_EXTERNAL_MEDIA = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.463 -0500", hash_original_field = "9D8C65A65DFB11EB5F1C8D95F9EBB76C", hash_generated_field = "02264E29EDDF21634896C526056CF6FC")

    public static final int VERIFICATION_ALLOW_WITHOUT_SUFFICIENT = 2;
    
    public static class NameNotFoundException extends AndroidException {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.247 -0500", hash_original_method = "4C893FF4D2386A2E528254CA81C36065", hash_generated_method = "A4B7D83CF9C65DC78B0AB4E6C5EB168F")
        
public NameNotFoundException() {
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.249 -0500", hash_original_method = "16889A22D22FB47C54F1114D13EC0BEF", hash_generated_method = "760C31BBFB8A023298D668787D4A5572")
        
public NameNotFoundException(String name) {
            super(name);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.465 -0500", hash_original_field = "CCFBFC745ABB7C2724340B47DF729BDB", hash_generated_field = "AFA7425051348D7B510D3069205362D3")

    public static final int VERIFICATION_ALLOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.468 -0500", hash_original_field = "6558B68A14E1DECAD8CA05DA46932DAE", hash_generated_field = "34022DE70A515DE4E329D81B6A827921")

    public static final int VERIFICATION_REJECT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.470 -0500", hash_original_field = "D58C30E435680D13EABC3D5C4B2EC833", hash_generated_field = "19760B1BECBE8AE0DA1CE2892D69E575")

    public static final int PER_USER_RANGE = 100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.473 -0500", hash_original_field = "6763B2CCB654567ADF362807937C7AEB", hash_generated_field = "F40B0809226B8F7AEA4E1DAE11074436")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_AUDIO_LOW_LATENCY = "android.hardware.audio.low_latency";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.475 -0500", hash_original_field = "335F3BA8B582592A2DCF16B562CD612D", hash_generated_field = "F5A51502F5DB395E72A791DF4F735D96")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_BLUETOOTH = "android.hardware.bluetooth";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.478 -0500", hash_original_field = "8FD94FAF6C0C6B354BF0A4AE2EC744B1", hash_generated_field = "42B0DBE805FF3AC221E9672A762B046B")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA = "android.hardware.camera";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.481 -0500", hash_original_field = "B834B578FEE817D19BF3924B4F528D17", hash_generated_field = "BED499DEFED78F4C8FD8943786D054A8")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_AUTOFOCUS = "android.hardware.camera.autofocus";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.483 -0500", hash_original_field = "25FA1BBA377A8B4F35029FF96B1718EC", hash_generated_field = "62631D1D6A02DDFEBB65BB5E9BD73D85")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_FLASH = "android.hardware.camera.flash";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.487 -0500", hash_original_field = "A58C7D98A45ABF44E462D02C5CAA3380", hash_generated_field = "784FE6850077DA6773335CAB7A0E760D")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_CAMERA_FRONT = "android.hardware.camera.front";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.489 -0500", hash_original_field = "7609B2981644A1ECB63F4D3215957FFE", hash_generated_field = "8E53B107D4D4A913E383CB2D0959190A")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION = "android.hardware.location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.491 -0500", hash_original_field = "DB597A4AFDFC868187A777A46DC239FA", hash_generated_field = "6C4B204FEAC342C33AD72C7930C23585")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION_GPS = "android.hardware.location.gps";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.494 -0500", hash_original_field = "72D2C47A540C4FC84BB74601D126CC78", hash_generated_field = "DC5C66C537E3A36FCA787E0212D112EF")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LOCATION_NETWORK = "android.hardware.location.network";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.496 -0500", hash_original_field = "6FDCD82E5B2C776A2E301B2B50EE0D41", hash_generated_field = "57F91AEF7408C53E177AE25D9A29ADA5")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_MICROPHONE = "android.hardware.microphone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.499 -0500", hash_original_field = "5B117A1410BA03B95C143F3162C621BC", hash_generated_field = "33C4CBEC7879D5C75921F891C63CE04D")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_NFC = "android.hardware.nfc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.503 -0500", hash_original_field = "8EBDF55843C93AABA1F91CC6D72DD6A2", hash_generated_field = "09476C5655DA997309C7629BC6D1A0E6")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_ACCELEROMETER = "android.hardware.sensor.accelerometer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.505 -0500", hash_original_field = "61265DB02ECD9D6A135C2664B3CA662A", hash_generated_field = "EABA27C9173195374946E1287734CDA3")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_BAROMETER = "android.hardware.sensor.barometer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.508 -0500", hash_original_field = "9CC88334C8B12185DEBE79DA061AB660", hash_generated_field = "00F40A894817B83CFBF02E6A4E8B4E02")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_COMPASS = "android.hardware.sensor.compass";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.511 -0500", hash_original_field = "D9C6BD70CFD4C3D598571B8336E0CCDB", hash_generated_field = "D45DB7C02694E66D636978A92BBB9F62")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_GYROSCOPE = "android.hardware.sensor.gyroscope";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.513 -0500", hash_original_field = "5F7F6308B16A03535320D879B7E12B54", hash_generated_field = "EE2C09358A1A9CF2A5CD70F7C4410659")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_LIGHT = "android.hardware.sensor.light";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.516 -0500", hash_original_field = "CADA194B8AC2A88309C368D8CADCF08F", hash_generated_field = "0986040350A19CDFE3651682ACDFC155")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SENSOR_PROXIMITY = "android.hardware.sensor.proximity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.518 -0500", hash_original_field = "904D647EA7C6C16688C1199566D4DEB5", hash_generated_field = "8C7C0DEBAEE0BC7A1541D8E57DA7B677")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY = "android.hardware.telephony";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.521 -0500", hash_original_field = "AEBB0E361871E246754F5726ECBD0396", hash_generated_field = "6FCFF0F1D79DF2AD142C1169F4524C50")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY_CDMA = "android.hardware.telephony.cdma";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.524 -0500", hash_original_field = "583AA4064D5F455FB6F9C34A806BDB5A", hash_generated_field = "6CA858BFCA7CE3C2D19BD76A4C3DA848")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TELEPHONY_GSM = "android.hardware.telephony.gsm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.527 -0500", hash_original_field = "2251199B33CF5AC89CD617D6BAA6F7D9", hash_generated_field = "1540D489C05587B09BDBD2231F30D55F")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_USB_HOST = "android.hardware.usb.host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.529 -0500", hash_original_field = "CE2D242993459880D25816A8589AC36A", hash_generated_field = "D29ABD8F1A0DF54A87C1055FB6B26617")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_USB_ACCESSORY = "android.hardware.usb.accessory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.533 -0500", hash_original_field = "DA79C7ACBBD8F934C007DDAEE6148E83", hash_generated_field = "73049EDBF32790E3F15FFD54316557BE")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SIP = "android.software.sip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.535 -0500", hash_original_field = "7D2A2925B3BB882756484E19E506CB0F", hash_generated_field = "9CE43AEA56A1EB553D5858563BF8301F")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SIP_VOIP = "android.software.sip.voip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.538 -0500", hash_original_field = "C338D845C45AE1F137727C4B6521A628", hash_generated_field = "B095009CD34BCB3913B8F021EA976502")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN = "android.hardware.touchscreen";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.540 -0500", hash_original_field = "66E4A94E94302ED71966F2C8EA65189D", hash_generated_field = "F13B5B25F96611ED5C487ED4442DC358")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH = "android.hardware.touchscreen.multitouch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.543 -0500", hash_original_field = "A35DE34A1D0CEEE30211009BDFE25682", hash_generated_field = "49EA9E47D554029311506C87939C6E6A")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT = "android.hardware.touchscreen.multitouch.distinct";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.546 -0500", hash_original_field = "1EA80D4BFCD927588474342D9098CF28", hash_generated_field = "2E604502D06002FA0A006E54E38052B1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND = "android.hardware.touchscreen.multitouch.jazzhand";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.549 -0500", hash_original_field = "EA68ABD4D83E5CECD55DF318B448EC40", hash_generated_field = "AB101B8A57280A45FCCC8B3D7FE1F818")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH = "android.hardware.faketouch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.551 -0500", hash_original_field = "12E93CB609CB3F1D2F393BF7663A4EDC", hash_generated_field = "FA3843B0F5F7B1C8095F7620269AEE88")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT = "android.hardware.faketouch.multitouch.distinct";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.554 -0500", hash_original_field = "8DCD530BEAF6B2F30DBAAF61FD4E19D8", hash_generated_field = "AC438248E673B1BC914D9064C9B90FB1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND = "android.hardware.faketouch.multitouch.jazzhand";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.556 -0500", hash_original_field = "AF6CF90C73ABDF53FB736B669B89D11A", hash_generated_field = "4A85280867222369BAC4637CFFFE4AA1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SCREEN_PORTRAIT = "android.hardware.screen.portrait";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.559 -0500", hash_original_field = "87E6977C109B572DBDAE181F15645066", hash_generated_field = "7B548C708A6F113B02369CFB72671041")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_SCREEN_LANDSCAPE = "android.hardware.screen.landscape";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.561 -0500", hash_original_field = "25B4323F4A423B50C6EBC04786554677", hash_generated_field = "4E5D7446ED2EEFB03F87289F4E8A59A3")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.564 -0500", hash_original_field = "0559FB0FED04D6B20A248AFFBA8BA215", hash_generated_field = "4A12F73B6CCB099C057FA92A1AA2D3A1")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_WIFI = "android.hardware.wifi";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.567 -0500", hash_original_field = "2696E1219BB0487DCD9DC0E9930F6A94", hash_generated_field = "162D9E10FB0EF1F5EFA0DFA74D97C901")

    @SdkConstant(SdkConstantType.FEATURE)
    public static final String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.569 -0500", hash_original_field = "0060584C8D741E063FBED2AFE79BAE14", hash_generated_field = "B3378E76ACD49C759DC0A0736DA0650F")

    public static final String ACTION_CLEAN_EXTERNAL_STORAGE
            = "android.content.pm.CLEAN_EXTERNAL_STORAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.572 -0500", hash_original_field = "876217AFFCB958A99EDC227AB20F736F", hash_generated_field = "0C2A0E29ECC22F682DDDBE71BA68E9B7")

    public static final String EXTRA_VERIFICATION_URI = "android.content.pm.extra.VERIFICATION_URI";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.574 -0500", hash_original_field = "9572257A6994865FD0F38C4D8863950F", hash_generated_field = "B39EF1BF2B6E12B88AB8D3031C594D47")

    public static final String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.577 -0500", hash_original_field = "CB03CE24EE474713445CF13AAA6FFA25", hash_generated_field = "C4A1EDF80F08B62CA31478C5A1CF2BA7")

    public static final String EXTRA_VERIFICATION_INSTALLER_PACKAGE
            = "android.content.pm.extra.VERIFICATION_INSTALLER_PACKAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.580 -0500", hash_original_field = "55CBBDF73456A99DFABA2DD53D36D21F", hash_generated_field = "5F2373ECD55441BF328AD51E76A531A6")

    public static final String EXTRA_VERIFICATION_INSTALL_FLAGS
            = "android.content.pm.extra.VERIFICATION_INSTALL_FLAGS";
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.294 -0400", hash_original_method = "5D24F7B229838E6C5BA06DA6570E4474", hash_generated_method = "5D24F7B229838E6C5BA06DA6570E4474")
    public PackageManager ()
    {
        //Synthesized constructor
    }

    /**
     * Retrieve overall information about an application package that is
     * installed on the system.
     * <p>
     * Throws {@link NameNotFoundException} if a package with the given name can
     * not be found on the system.
     *
     * @param packageName The full name (i.e. com.google.apps.contacts) of the
     *            desired package.
     * @param flags Additional option flags. Use any combination of
     *            {@link #GET_ACTIVITIES}, {@link #GET_GIDS},
     *            {@link #GET_CONFIGURATIONS}, {@link #GET_INSTRUMENTATION},
     *            {@link #GET_PERMISSIONS}, {@link #GET_PROVIDERS},
     *            {@link #GET_RECEIVERS}, {@link #GET_SERVICES},
     *            {@link #GET_SIGNATURES}, {@link #GET_UNINSTALLED_PACKAGES} to
     *            modify the data returned.
     * @return Returns a PackageInfo object containing information about the
     *         package. If flag GET_UNINSTALLED_PACKAGES is set and if the
     *         package is not found in the list of installed applications, the
     *         package information is retrieved from the list of uninstalled
     *         applications(which includes installed applications as well as
     *         applications with data directory ie applications which had been
     *         deleted with DONT_DELTE_DATA flag set).
     * @see #GET_ACTIVITIES
     * @see #GET_GIDS
     * @see #GET_CONFIGURATIONS
     * @see #GET_INSTRUMENTATION
     * @see #GET_PERMISSIONS
     * @see #GET_PROVIDERS
     * @see #GET_RECEIVERS
     * @see #GET_SERVICES
     * @see #GET_SIGNATURES
     * @see #GET_UNINSTALLED_PACKAGES
     */
    
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.582 -0500", hash_original_method = "464828FC1398C3C4C0BF897023D8D8AE", hash_generated_method = "C85FB643A0DD80923535E9820CD8A70B")
    
public abstract PackageInfo getPackageInfo(String packageName, int flags)
            throws NameNotFoundException;

    /**
     * Map from the current package names in use on the device to whatever
     * the current canonical name of that package is.
     * @param names Array of current names to be mapped.
     * @return Returns an array of the same size as the original, containing
     * the canonical name for each package.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.584 -0500", hash_original_method = "40E482A385ABCFD4B46767A6FE231F3A", hash_generated_method = "13F475471DFA6966C9EDF46C86868D94")
    
public abstract String[] currentToCanonicalPackageNames(String[] names);

    /**
     * Map from a packages canonical name to the current name in use on the device.
     * @param names Array of new names to be mapped.
     * @return Returns an array of the same size as the original, containing
     * the current name for each package.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.587 -0500", hash_original_method = "7FB323C2080331F859FC69164657CB31", hash_generated_method = "5A227D5C1091770DB7404B094430AE5F")
    
public abstract String[] canonicalToCurrentPackageNames(String[] names);

    /**
     * Return a "good" intent to launch a front-door activity in a package,
     * for use for example to implement an "open" button when browsing through
     * packages.  The current implementation will look first for a main
     * activity in the category {@link Intent#CATEGORY_INFO}, next for a
     * main activity in the category {@link Intent#CATEGORY_LAUNCHER}, or return
     * null if neither are found.
     *
     * <p>Throws {@link NameNotFoundException} if a package with the given
     * name can not be found on the system.
     *
     * @param packageName The name of the package to inspect.
     *
     * @return Returns either a fully-qualified Intent that can be used to
     * launch the main activity in the package, or null if the package does
     * not contain such an activity.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.589 -0500", hash_original_method = "07F7FE66BB206735CBFC91A8823FB1EC", hash_generated_method = "47B75D25608218FCC91632E08A6529BB")
    
public abstract Intent getLaunchIntentForPackage(String packageName);

    /**
     * Return an array of all of the secondary group-ids that have been
     * assigned to a package.
     *
     * <p>Throws {@link NameNotFoundException} if a package with the given
     * name can not be found on the system.
     *
     * @param packageName The full name (i.e. com.google.apps.contacts) of the
     *                    desired package.
     *
     * @return Returns an int array of the assigned gids, or null if there
     * are none.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.592 -0500", hash_original_method = "20B39F12EB02CD88861BBEBDDC9E54AF", hash_generated_method = "22ED33F20311FAA5A1B331A04F8374C1")
    
public abstract int[] getPackageGids(String packageName)
            throws NameNotFoundException;

    /**
     * Retrieve all of the information we know about a particular permission.
     *
     * <p>Throws {@link NameNotFoundException} if a permission with the given
     * name can not be found on the system.
     *
     * @param name The fully qualified name (i.e. com.google.permission.LOGIN)
     *             of the permission you are interested in.
     * @param flags Additional option flags.  Use {@link #GET_META_DATA} to
     * retrieve any meta-data associated with the permission.
     *
     * @return Returns a {@link PermissionInfo} containing information about the
     *         permission.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.594 -0500", hash_original_method = "FEE7B3AE6E33D87F7EC44197CD14A839", hash_generated_method = "EF8B02B62865ADA41229A23FD7E794ED")
    
public abstract PermissionInfo getPermissionInfo(String name, int flags)
            throws NameNotFoundException;

    /**
     * Query for all of the permissions associated with a particular group.
     *
     * <p>Throws {@link NameNotFoundException} if the given group does not
     * exist.
     *
     * @param group The fully qualified name (i.e. com.google.permission.LOGIN)
     *             of the permission group you are interested in.  Use null to
     *             find all of the permissions not associated with a group.
     * @param flags Additional option flags.  Use {@link #GET_META_DATA} to
     * retrieve any meta-data associated with the permissions.
     *
     * @return Returns a list of {@link PermissionInfo} containing information
     * about all of the permissions in the given group.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.596 -0500", hash_original_method = "0316ECB73F5082827581A2B7371502C6", hash_generated_method = "EBC0F49C8D19D80C7E4E18F49927EBCC")
    
public abstract List<PermissionInfo> queryPermissionsByGroup(String group,
            int flags) throws NameNotFoundException;

    /**
     * Retrieve all of the information we know about a particular group of
     * permissions.
     *
     * <p>Throws {@link NameNotFoundException} if a permission group with the given
     * name can not be found on the system.
     *
     * @param name The fully qualified name (i.e. com.google.permission_group.APPS)
     *             of the permission you are interested in.
     * @param flags Additional option flags.  Use {@link #GET_META_DATA} to
     * retrieve any meta-data associated with the permission group.
     *
     * @return Returns a {@link PermissionGroupInfo} containing information
     * about the permission.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.599 -0500", hash_original_method = "95144F3187894013851BD62BBAD6E39A", hash_generated_method = "E97F5EF6C34C18B3951ABF75142AB0CA")
    
public abstract PermissionGroupInfo getPermissionGroupInfo(String name,
            int flags) throws NameNotFoundException;

    /**
     * Retrieve all of the known permission groups in the system.
     *
     * @param flags Additional option flags.  Use {@link #GET_META_DATA} to
     * retrieve any meta-data associated with the permission group.
     *
     * @return Returns a list of {@link PermissionGroupInfo} containing
     * information about all of the known permission groups.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.601 -0500", hash_original_method = "66EB9AE89969D01469B8F04791424156", hash_generated_method = "7E2D55A054F0E5EA86C1817E821B73A3")
    
public abstract List<PermissionGroupInfo> getAllPermissionGroups(int flags);

    /**
     * Retrieve all of the information we know about a particular
     * package/application.
     *
     * <p>Throws {@link NameNotFoundException} if an application with the given
     * package name can not be found on the system.
     *
     * @param packageName The full name (i.e. com.google.apps.contacts) of an
     *                    application.
     * @param flags Additional option flags. Use any combination of
     * {@link #GET_META_DATA}, {@link #GET_SHARED_LIBRARY_FILES},
     * {@link #GET_UNINSTALLED_PACKAGES} to modify the data returned.
     *
     * @return  {@link ApplicationInfo} Returns ApplicationInfo object containing
     *         information about the package.
     *         If flag GET_UNINSTALLED_PACKAGES is set and  if the package is not
     *         found in the list of installed applications,
     *         the application information is retrieved from the
     *         list of uninstalled applications(which includes
     *         installed applications as well as applications
     *         with data directory ie applications which had been
     *         deleted with DONT_DELTE_DATA flag set).
     *
     * @see #GET_META_DATA
     * @see #GET_SHARED_LIBRARY_FILES
     * @see #GET_UNINSTALLED_PACKAGES
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.604 -0500", hash_original_method = "BC9AFAA827FACCD234420D43BFB9185C", hash_generated_method = "DD1EE427C72C068D4C9362CB17337762")
    
public abstract ApplicationInfo getApplicationInfo(String packageName,
            int flags) throws NameNotFoundException;

    /**
     * Retrieve all of the information we know about a particular activity
     * class.
     *
     * <p>Throws {@link NameNotFoundException} if an activity with the given
     * class name can not be found on the system.
     *
     * @param component The full component name (i.e.
     * com.google.apps.contacts/com.google.apps.contacts.ContactsList) of an Activity
     * class.
     * @param flags Additional option flags. Use any combination of
     * {@link #GET_META_DATA}, {@link #GET_SHARED_LIBRARY_FILES},
     * to modify the data (in ApplicationInfo) returned.
     *
     * @return {@link ActivityInfo} containing information about the activity.
     *
     * @see #GET_INTENT_FILTERS
     * @see #GET_META_DATA
     * @see #GET_SHARED_LIBRARY_FILES
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.606 -0500", hash_original_method = "A7A64DAF504027462A462281F2A57199", hash_generated_method = "5D6C6A69E2318B84E7D342B9CA736A86")
    
public abstract ActivityInfo getActivityInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    /**
     * Retrieve all of the information we know about a particular receiver
     * class.
     *
     * <p>Throws {@link NameNotFoundException} if a receiver with the given
     * class name can not be found on the system.
     *
     * @param component The full component name (i.e.
     * com.google.apps.calendar/com.google.apps.calendar.CalendarAlarm) of a Receiver
     * class.
     * @param flags Additional option flags.  Use any combination of
     * {@link #GET_META_DATA}, {@link #GET_SHARED_LIBRARY_FILES},
     * to modify the data returned.
     *
     * @return {@link ActivityInfo} containing information about the receiver.
     *
     * @see #GET_INTENT_FILTERS
     * @see #GET_META_DATA
     * @see #GET_SHARED_LIBRARY_FILES
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.608 -0500", hash_original_method = "AC7597D9AF7B23F2C69CB3E0E4C5F422", hash_generated_method = "53D61C52E89C1A31BA42D85832A47C6E")
    
public abstract ActivityInfo getReceiverInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    /**
     * Retrieve all of the information we know about a particular service
     * class.
     *
     * <p>Throws {@link NameNotFoundException} if a service with the given
     * class name can not be found on the system.
     *
     * @param component The full component name (i.e.
     * com.google.apps.media/com.google.apps.media.BackgroundPlayback) of a Service
     * class.
     * @param flags Additional option flags.  Use any combination of
     * {@link #GET_META_DATA}, {@link #GET_SHARED_LIBRARY_FILES},
     * to modify the data returned.
     *
     * @return ServiceInfo containing information about the service.
     *
     * @see #GET_META_DATA
     * @see #GET_SHARED_LIBRARY_FILES
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.611 -0500", hash_original_method = "51B70C394F99AB2554FB7F50EDD6FC7D", hash_generated_method = "58EF05F3B0EED574AE384173E8D6B3E1")
    
public abstract ServiceInfo getServiceInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    /**
     * Retrieve all of the information we know about a particular content
     * provider class.
     *
     * <p>Throws {@link NameNotFoundException} if a provider with the given
     * class name can not be found on the system.
     *
     * @param component The full component name (i.e.
     * com.google.providers.media/com.google.providers.media.MediaProvider) of a
     * ContentProvider class.
     * @param flags Additional option flags.  Use any combination of
     * {@link #GET_META_DATA}, {@link #GET_SHARED_LIBRARY_FILES},
     * to modify the data returned.
     *
     * @return ProviderInfo containing information about the service.
     *
     * @see #GET_META_DATA
     * @see #GET_SHARED_LIBRARY_FILES
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.613 -0500", hash_original_method = "E1F8B9B4DB6E851EC444CC154E66DF8D", hash_generated_method = "BB45482B5C05580A318672DC04358A30")
    
public abstract ProviderInfo getProviderInfo(ComponentName component,
            int flags) throws NameNotFoundException;

    /**
     * Return a List of all packages that are installed
     * on the device.
     *
     * @param flags Additional option flags. Use any combination of
     * {@link #GET_ACTIVITIES},
     * {@link #GET_GIDS},
     * {@link #GET_CONFIGURATIONS},
     * {@link #GET_INSTRUMENTATION},
     * {@link #GET_PERMISSIONS},
     * {@link #GET_PROVIDERS},
     * {@link #GET_RECEIVERS},
     * {@link #GET_SERVICES},
     * {@link #GET_SIGNATURES},
     * {@link #GET_UNINSTALLED_PACKAGES} to modify the data returned.
     *
     * @return A List of PackageInfo objects, one for each package that is
     *         installed on the device.  In the unlikely case of there being no
     *         installed packages, an empty list is returned.
     *         If flag GET_UNINSTALLED_PACKAGES is set, a list of all
     *         applications including those deleted with DONT_DELETE_DATA
     *         (partially installed apps with data directory) will be returned.
     *
     * @see #GET_ACTIVITIES
     * @see #GET_GIDS
     * @see #GET_CONFIGURATIONS
     * @see #GET_INSTRUMENTATION
     * @see #GET_PERMISSIONS
     * @see #GET_PROVIDERS
     * @see #GET_RECEIVERS
     * @see #GET_SERVICES
     * @see #GET_SIGNATURES
     * @see #GET_UNINSTALLED_PACKAGES
     *
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.616 -0500", hash_original_method = "FA1B431E409D0CEBDA67D49CD96B6226", hash_generated_method = "FF5C1A475B9D4AB3AE6455D48622DBCA")
    
public abstract List<PackageInfo> getInstalledPackages(int flags);

    /**
     * Check whether a particular package has been granted a particular
     * permission.
     *
     * @param permName The name of the permission you are checking for,
     * @param pkgName The name of the package you are checking against.
     *
     * @return If the package has the permission, PERMISSION_GRANTED is
     * returned.  If it does not have the permission, PERMISSION_DENIED
     * is returned.
     *
     * @see #PERMISSION_GRANTED
     * @see #PERMISSION_DENIED
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.618 -0500", hash_original_method = "9659944527425B7E4E76627324F8B63F", hash_generated_method = "B8A0E9AC8CCCB43AB8F26ADC6F6D2E18")
    
public abstract int checkPermission(String permName, String pkgName);

    /**
     * Add a new dynamic permission to the system.  For this to work, your
     * package must have defined a permission tree through the
     * {@link android.R.styleable#AndroidManifestPermissionTree
     * &lt;permission-tree&gt;} tag in its manifest.  A package can only add
     * permissions to trees that were defined by either its own package or
     * another with the same user id; a permission is in a tree if it
     * matches the name of the permission tree + ".": for example,
     * "com.foo.bar" is a member of the permission tree "com.foo".
     *
     * <p>It is good to make your permission tree name descriptive, because you
     * are taking possession of that entire set of permission names.  Thus, it
     * must be under a domain you control, with a suffix that will not match
     * any normal permissions that may be declared in any applications that
     * are part of that domain.
     *
     * <p>New permissions must be added before
     * any .apks are installed that use those permissions.  Permissions you
     * add through this method are remembered across reboots of the device.
     * If the given permission already exists, the info you supply here
     * will be used to update it.
     *
     * @param info Description of the permission to be added.
     *
     * @return Returns true if a new permission was created, false if an
     * existing one was updated.
     *
     * @throws SecurityException if you are not allowed to add the
     * given permission name.
     *
     * @see #removePermission(String)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.621 -0500", hash_original_method = "FA6A333031C77CE7AFCC33565A281E64", hash_generated_method = "CFDBF8FD9DFB2F11959AE70A6CD59D68")
    
public abstract boolean addPermission(PermissionInfo info);

    /**
     * Like {@link #addPermission(PermissionInfo)} but asynchronously
     * persists the package manager state after returning from the call,
     * allowing it to return quicker and batch a series of adds at the
     * expense of no guarantee the added permission will be retained if
     * the device is rebooted before it is written.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.623 -0500", hash_original_method = "CB8871520B91B62D4F5F8711C4930FC1", hash_generated_method = "BB9AFEF6676BDAC0327C0864A15CAC26")
    
public abstract boolean addPermissionAsync(PermissionInfo info);

    /**
     * Removes a permission that was previously added with
     * {@link #addPermission(PermissionInfo)}.  The same ownership rules apply
     * -- you are only allowed to remove permissions that you are allowed
     * to add.
     *
     * @param name The name of the permission to remove.
     *
     * @throws SecurityException if you are not allowed to remove the
     * given permission name.
     *
     * @see #addPermission(PermissionInfo)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.625 -0500", hash_original_method = "2CA179CDD29D82844C39706789C70562", hash_generated_method = "5001FCA8B9197641E5945B5C7F16A5E9")
    
public abstract void removePermission(String name);

    /**
     * Compare the signatures of two packages to determine if the same
     * signature appears in both of them.  If they do contain the same
     * signature, then they are allowed special privileges when working
     * with each other: they can share the same user-id, run instrumentation
     * against each other, etc.
     *
     * @param pkg1 First package name whose signature will be compared.
     * @param pkg2 Second package name whose signature will be compared.
     *
     * @return Returns an integer indicating whether all signatures on the
     * two packages match. The value is >= 0 ({@link #SIGNATURE_MATCH}) if
     * all signatures match or < 0 if there is not a match ({@link
     * #SIGNATURE_NO_MATCH} or {@link #SIGNATURE_UNKNOWN_PACKAGE}).
     *
     * @see #checkSignatures(int, int)
     * @see #SIGNATURE_MATCH
     * @see #SIGNATURE_NO_MATCH
     * @see #SIGNATURE_UNKNOWN_PACKAGE
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.627 -0500", hash_original_method = "9C8BA2B70C1B863F626B7E37E68813D9", hash_generated_method = "C035B87733B7ABC8003D96AB202A5A78")
    
public abstract int checkSignatures(String pkg1, String pkg2);

    /**
     * Like {@link #checkSignatures(String, String)}, but takes UIDs of
     * the two packages to be checked.  This can be useful, for example,
     * when doing the check in an IPC, where the UID is the only identity
     * available.  It is functionally identical to determining the package
     * associated with the UIDs and checking their signatures.
     *
     * @param uid1 First UID whose signature will be compared.
     * @param uid2 Second UID whose signature will be compared.
     *
     * @return Returns an integer indicating whether all signatures on the
     * two packages match. The value is >= 0 ({@link #SIGNATURE_MATCH}) if
     * all signatures match or < 0 if there is not a match ({@link
     * #SIGNATURE_NO_MATCH} or {@link #SIGNATURE_UNKNOWN_PACKAGE}).
     *
     * @see #checkSignatures(String, String)
     * @see #SIGNATURE_MATCH
     * @see #SIGNATURE_NO_MATCH
     * @see #SIGNATURE_UNKNOWN_PACKAGE
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.629 -0500", hash_original_method = "2DFB2958AD9FD0ECB174B577C5D43B25", hash_generated_method = "2E76A396DAE4325A7896E66EA37DD684")
    
public abstract int checkSignatures(int uid1, int uid2);

    /**
     * Retrieve the names of all packages that are associated with a particular
     * user id.  In most cases, this will be a single package name, the package
     * that has been assigned that user id.  Where there are multiple packages
     * sharing the same user id through the "sharedUserId" mechanism, all
     * packages with that id will be returned.
     *
     * @param uid The user id for which you would like to retrieve the
     * associated packages.
     *
     * @return Returns an array of one or more packages assigned to the user
     * id, or null if there are no known packages with the given id.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.631 -0500", hash_original_method = "FBF5DCDA76A13D456CBE8F7D4CE9606E", hash_generated_method = "EE782B19013D9795425A64880C5DC15D")
    
public abstract String[] getPackagesForUid(int uid);

    /**
     * Retrieve the official name associated with a user id.  This name is
     * guaranteed to never change, though it is possibly for the underlying
     * user id to be changed.  That is, if you are storing information about
     * user ids in persistent storage, you should use the string returned
     * by this function instead of the raw user-id.
     *
     * @param uid The user id for which you would like to retrieve a name.
     * @return Returns a unique name for the given user id, or null if the
     * user id is not currently assigned.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.633 -0500", hash_original_method = "76F4B3C4C222D4E270653772B5E099C9", hash_generated_method = "6F4F22FB3D445681D27C4605C1BDFC65")
    
public abstract String getNameForUid(int uid);

    /**
     * Return the user id associated with a shared user name. Multiple
     * applications can specify a shared user name in their manifest and thus
     * end up using a common uid. This might be used for new applications
     * that use an existing shared user name and need to know the uid of the
     * shared user.
     *
     * @param sharedUserName The shared user name whose uid is to be retrieved.
     * @return Returns the uid associated with the shared user, or  NameNotFoundException
     * if the shared user name is not being used by any installed packages
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.636 -0500", hash_original_method = "8384C35279C1FEDB5A59618761271C88", hash_generated_method = "A31FFD796D5F4C323B57DBB22A419E05")
    
public abstract int getUidForSharedUser(String sharedUserName)
            throws NameNotFoundException;

    /**
     * Return a List of all application packages that are installed on the
     * device. If flag GET_UNINSTALLED_PACKAGES has been set, a list of all
     * applications including those deleted with DONT_DELETE_DATA(partially
     * installed apps with data directory) will be returned.
     *
     * @param flags Additional option flags. Use any combination of
     * {@link #GET_META_DATA}, {@link #GET_SHARED_LIBRARY_FILES},
     * {link #GET_UNINSTALLED_PACKAGES} to modify the data returned.
     *
     * @return A List of ApplicationInfo objects, one for each application that
     *         is installed on the device.  In the unlikely case of there being
     *         no installed applications, an empty list is returned.
     *         If flag GET_UNINSTALLED_PACKAGES is set, a list of all
     *         applications including those deleted with DONT_DELETE_DATA
     *         (partially installed apps with data directory) will be returned.
     *
     * @see #GET_META_DATA
     * @see #GET_SHARED_LIBRARY_FILES
     * @see #GET_UNINSTALLED_PACKAGES
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.639 -0500", hash_original_method = "0EF671D59959154E932606B082795085", hash_generated_method = "AB25EF080EDD746CC72BE67538DB52F0")
    
public abstract List<ApplicationInfo> getInstalledApplications(int flags);

    /**
     * Get a list of shared libraries that are available on the
     * system.
     *
     * @return An array of shared library names that are
     * available on the system, or null if none are installed.
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.641 -0500", hash_original_method = "1C4A03E666ED349FFDD8D7A2DE7F52B4", hash_generated_method = "92A0F52A3049AE4B122C4381BC7F39E8")
    
public abstract String[] getSystemSharedLibraryNames();

    /**
     * Get a list of features that are available on the
     * system.
     *
     * @return An array of FeatureInfo classes describing the features
     * that are available on the system, or null if there are none(!!).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.644 -0500", hash_original_method = "1A135122F2266DC4FB2AD5D2189DFCF9", hash_generated_method = "95EFBFEF5CA59C671F314745A36C8BF8")
    
public abstract FeatureInfo[] getSystemAvailableFeatures();

    /**
     * Check whether the given feature name is one of the available
     * features as returned by {@link #getSystemAvailableFeatures()}.
     *
     * @return Returns true if the devices supports the feature, else
     * false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.646 -0500", hash_original_method = "3F5FA907E64458BDAFAB8FAA52A8060B", hash_generated_method = "1E5DF90F32E531BB12B17463418AFB39")
    
public abstract boolean hasSystemFeature(String name);

    /**
     * Determine the best action to perform for a given Intent.  This is how
     * {@link Intent#resolveActivity} finds an activity if a class has not
     * been explicitly specified.
     *
     * <p><em>Note:</em> if using an implicit Intent (without an explicit ComponentName
     * specified), be sure to consider whether to set the {@link #MATCH_DEFAULT_ONLY}
     * only flag.  You need to do so to resolve the activity in the same way
     * that {@link android.content.Context#startActivity(Intent)} and
     * {@link android.content.Intent#resolveActivity(PackageManager)
     * Intent.resolveActivity(PackageManager)} do.</p>
     *
     * @param intent An intent containing all of the desired specification
     *               (action, data, type, category, and/or component).
     * @param flags Additional option flags.  The most important is
     * {@link #MATCH_DEFAULT_ONLY}, to limit the resolution to only
     * those activities that support the {@link android.content.Intent#CATEGORY_DEFAULT}.
     *
     * @return Returns a ResolveInfo containing the final activity intent that
     *         was determined to be the best action.  Returns null if no
     *         matching activity was found. If multiple matching activities are
     *         found and there is no default set, returns a ResolveInfo
     *         containing something else, such as the activity resolver.
     *
     * @see #MATCH_DEFAULT_ONLY
     * @see #GET_INTENT_FILTERS
     * @see #GET_RESOLVED_FILTER
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.648 -0500", hash_original_method = "F6A86927E121727A272A21E3DCB3FFA7", hash_generated_method = "24F8D6ED87140E52CAC24061BD991ACF")
    
public abstract ResolveInfo resolveActivity(Intent intent, int flags);

    /**
     * Retrieve all activities that can be performed for the given intent.
     *
     * @param intent The desired intent as per resolveActivity().
     * @param flags Additional option flags.  The most important is
     * {@link #MATCH_DEFAULT_ONLY}, to limit the resolution to only
     * those activities that support the {@link android.content.Intent#CATEGORY_DEFAULT}.
     *
     * @return A List&lt;ResolveInfo&gt; containing one entry for each matching
     *         Activity. These are ordered from best to worst match -- that
     *         is, the first item in the list is what is returned by
     *         {@link #resolveActivity}.  If there are no matching activities, an empty
     *         list is returned.
     *
     * @see #MATCH_DEFAULT_ONLY
     * @see #GET_INTENT_FILTERS
     * @see #GET_RESOLVED_FILTER
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.651 -0500", hash_original_method = "AC20BF243DC1E97601026E9C98F03F62", hash_generated_method = "C4F29DC65152E729E3C95F54803E2EAD")
    
public abstract List<ResolveInfo> queryIntentActivities(Intent intent,
            int flags);

    /**
     * Retrieve a set of activities that should be presented to the user as
     * similar options.  This is like {@link #queryIntentActivities}, except it
     * also allows you to supply a list of more explicit Intents that you would
     * like to resolve to particular options, and takes care of returning the
     * final ResolveInfo list in a reasonable order, with no duplicates, based
     * on those inputs.
     *
     * @param caller The class name of the activity that is making the
     *               request.  This activity will never appear in the output
     *               list.  Can be null.
     * @param specifics An array of Intents that should be resolved to the
     *                  first specific results.  Can be null.
     * @param intent The desired intent as per resolveActivity().
     * @param flags Additional option flags.  The most important is
     * {@link #MATCH_DEFAULT_ONLY}, to limit the resolution to only
     * those activities that support the {@link android.content.Intent#CATEGORY_DEFAULT}.
     *
     * @return A List&lt;ResolveInfo&gt; containing one entry for each matching
     *         Activity. These are ordered first by all of the intents resolved
     *         in <var>specifics</var> and then any additional activities that
     *         can handle <var>intent</var> but did not get included by one of
     *         the <var>specifics</var> intents.  If there are no matching
     *         activities, an empty list is returned.
     *
     * @see #MATCH_DEFAULT_ONLY
     * @see #GET_INTENT_FILTERS
     * @see #GET_RESOLVED_FILTER
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.653 -0500", hash_original_method = "099B8C4BBE89493F7A2B2E31EEAEAC98", hash_generated_method = "19A8CF45393648CDF25A2ECB49123DD1")
    
public abstract List<ResolveInfo> queryIntentActivityOptions(
            ComponentName caller, Intent[] specifics, Intent intent, int flags);

    /**
     * Retrieve all receivers that can handle a broadcast of the given intent.
     *
     * @param intent The desired intent as per resolveActivity().
     * @param flags Additional option flags.
     *
     * @return A List&lt;ResolveInfo&gt; containing one entry for each matching
     *         Receiver. These are ordered from first to last in priority.  If
     *         there are no matching receivers, an empty list is returned.
     *
     * @see #MATCH_DEFAULT_ONLY
     * @see #GET_INTENT_FILTERS
     * @see #GET_RESOLVED_FILTER
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.656 -0500", hash_original_method = "C9789E62C2B0ECACDA7566685357EDFA", hash_generated_method = "E4D896A1CCA98D8A619A8D0BD53A0BEA")
    
public abstract List<ResolveInfo> queryBroadcastReceivers(Intent intent,
            int flags);

    /**
     * Determine the best service to handle for a given Intent.
     *
     * @param intent An intent containing all of the desired specification
     *               (action, data, type, category, and/or component).
     * @param flags Additional option flags.
     *
     * @return Returns a ResolveInfo containing the final service intent that
     *         was determined to be the best action.  Returns null if no
     *         matching service was found.
     *
     * @see #GET_INTENT_FILTERS
     * @see #GET_RESOLVED_FILTER
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.658 -0500", hash_original_method = "2CBFF23D0F9B001B71931AB33C3E5BB7", hash_generated_method = "D0CBF4510D7AC8C20C6C406EBD76D957")
    
public abstract ResolveInfo resolveService(Intent intent, int flags);

    /**
     * Retrieve all services that can match the given intent.
     *
     * @param intent The desired intent as per resolveService().
     * @param flags Additional option flags.
     *
     * @return A List&lt;ResolveInfo&gt; containing one entry for each matching
     *         ServiceInfo. These are ordered from best to worst match -- that
     *         is, the first item in the list is what is returned by
     *         resolveService().  If there are no matching services, an empty
     *         list is returned.
     *
     * @see #GET_INTENT_FILTERS
     * @see #GET_RESOLVED_FILTER
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.660 -0500", hash_original_method = "6046BD374D0552ADD26D23F3BAFC67FA", hash_generated_method = "9793BAA82160C6E08F5D0DE99F42FDC0")
    
public abstract List<ResolveInfo> queryIntentServices(Intent intent,
            int flags);

    /**
     * Find a single content provider by its base path name.
     *
     * @param name The name of the provider to find.
     * @param flags Additional option flags.  Currently should always be 0.
     *
     * @return ContentProviderInfo Information about the provider, if found,
     *         else null.
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.662 -0500", hash_original_method = "CFE5D064AFA538A646FC7253CD52DEB8", hash_generated_method = "2213BA79A107BB9936D3476AEF3743A0")
    
public abstract ProviderInfo resolveContentProvider(String name,
            int flags);

    /**
     * Retrieve content provider information.
     *
     * <p><em>Note: unlike most other methods, an empty result set is indicated
     * by a null return instead of an empty list.</em>
     *
     * @param processName If non-null, limits the returned providers to only
     *                    those that are hosted by the given process.  If null,
     *                    all content providers are returned.
     * @param uid If <var>processName</var> is non-null, this is the required
     *        uid owning the requested content providers.
     * @param flags Additional option flags.  Currently should always be 0.
     *
     * @return A List&lt;ContentProviderInfo&gt; containing one entry for each
     *         content provider either patching <var>processName</var> or, if
     *         <var>processName</var> is null, all known content providers.
     *         <em>If there are no matching providers, null is returned.</em>
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.664 -0500", hash_original_method = "50A98EED0117A55F02704642E22B2893", hash_generated_method = "7E95451EE887E8D8BC2ECB2E3AB37866")
    
public abstract List<ProviderInfo> queryContentProviders(
            String processName, int uid, int flags);

    /**
     * Retrieve all of the information we know about a particular
     * instrumentation class.
     *
     * <p>Throws {@link NameNotFoundException} if instrumentation with the
     * given class name can not be found on the system.
     *
     * @param className The full name (i.e.
     *                  com.google.apps.contacts.InstrumentList) of an
     *                  Instrumentation class.
     * @param flags Additional option flags.  Currently should always be 0.
     *
     * @return InstrumentationInfo containing information about the
     *         instrumentation.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.667 -0500", hash_original_method = "3E4AC386B4DBA53436B7EA672BF69684", hash_generated_method = "A9D33F6E023B90B1D31701E1A10C4438")
    
public abstract InstrumentationInfo getInstrumentationInfo(
            ComponentName className, int flags) throws NameNotFoundException;

    /**
     * Retrieve information about available instrumentation code.  May be used
     * to retrieve either all instrumentation code, or only the code targeting
     * a particular package.
     *
     * @param targetPackage If null, all instrumentation is returned; only the
     *                      instrumentation targeting this package name is
     *                      returned.
     * @param flags Additional option flags.  Currently should always be 0.
     *
     * @return A List&lt;InstrumentationInfo&gt; containing one entry for each
     *         matching available Instrumentation.  Returns an empty list if
     *         there is no instrumentation available for the given package.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.669 -0500", hash_original_method = "EEADB4419C6799ACE020F6FEB6DA8006", hash_generated_method = "4081782E6534DEA40F968F9EEFA124CF")
    
public abstract List<InstrumentationInfo> queryInstrumentation(
            String targetPackage, int flags);

    /**
     * Retrieve an image from a package.  This is a low-level API used by
     * the various package manager info structures (such as
     * {@link ComponentInfo} to implement retrieval of their associated
     * icon.
     *
     * @param packageName The name of the package that this icon is coming from.
     * Can not be null.
     * @param resid The resource identifier of the desired image.  Can not be 0.
     * @param appInfo Overall information about <var>packageName</var>.  This
     * may be null, in which case the application information will be retrieved
     * for you if needed; if you already have this information around, it can
     * be much more efficient to supply it here.
     *
     * @return Returns a Drawable holding the requested image.  Returns null if
     * an image could not be found for any reason.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.672 -0500", hash_original_method = "6C074435B2C70261B1D6C3BAAF3582B2", hash_generated_method = "ED8415D8AFFBB032C35CE22DBFD13ECB")
    
public abstract Drawable getDrawable(String packageName, int resid,
            ApplicationInfo appInfo);

    /**
     * Retrieve the icon associated with an activity.  Given the full name of
     * an activity, retrieves the information about it and calls
     * {@link ComponentInfo#loadIcon ComponentInfo.loadIcon()} to return its icon.
     * If the activity can not be found, NameNotFoundException is thrown.
     *
     * @param activityName Name of the activity whose icon is to be retrieved.
     *
     * @return Returns the image of the icon, or the default activity icon if
     * it could not be found.  Does not return null.
     * @throws NameNotFoundException Thrown if the resources for the given
     * activity could not be loaded.
     *
     * @see #getActivityIcon(Intent)
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.674 -0500", hash_original_method = "EA2EDB5C6BA981BD61C45ACED3124C72", hash_generated_method = "8CCFA0CD700316E0128637C662938FB1")
    
public abstract Drawable getActivityIcon(ComponentName activityName)
            throws NameNotFoundException;

    /**
     * Retrieve the icon associated with an Intent.  If intent.getClassName() is
     * set, this simply returns the result of
     * getActivityIcon(intent.getClassName()).  Otherwise it resolves the intent's
     * component and returns the icon associated with the resolved component.
     * If intent.getClassName() can not be found or the Intent can not be resolved
     * to a component, NameNotFoundException is thrown.
     *
     * @param intent The intent for which you would like to retrieve an icon.
     *
     * @return Returns the image of the icon, or the default activity icon if
     * it could not be found.  Does not return null.
     * @throws NameNotFoundException Thrown if the resources for application
     * matching the given intent could not be loaded.
     *
     * @see #getActivityIcon(ComponentName)
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.676 -0500", hash_original_method = "E1E7DF7C8539E8DF9184DF5DB8C2CD90", hash_generated_method = "D17E962D94EAC8BBB20FBDAA903C3D48")
    
public abstract Drawable getActivityIcon(Intent intent)
            throws NameNotFoundException;

    /**
     * Return the generic icon for an activity that is used when no specific
     * icon is defined.
     *
     * @return Drawable Image of the icon.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.678 -0500", hash_original_method = "BE5EF8DB4CA27EC3DDD7AD05114C9B4A", hash_generated_method = "F8A4DAE03232D4BD6F12834B52841613")
    
public abstract Drawable getDefaultActivityIcon();

    /**
     * Retrieve the icon associated with an application.  If it has not defined
     * an icon, the default app icon is returned.  Does not return null.
     *
     * @param info Information about application being queried.
     *
     * @return Returns the image of the icon, or the default application icon
     * if it could not be found.
     *
     * @see #getApplicationIcon(String)
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.681 -0500", hash_original_method = "FE6B9FADCBE1C0A097A550756025ECA1", hash_generated_method = "A0A8CD23D402AE385224882A18EDD4A2")
    
public abstract Drawable getApplicationIcon(ApplicationInfo info);

    /**
     * Retrieve the icon associated with an application.  Given the name of the
     * application's package, retrieves the information about it and calls
     * getApplicationIcon() to return its icon. If the application can not be
     * found, NameNotFoundException is thrown.
     *
     * @param packageName Name of the package whose application icon is to be
     *                    retrieved.
     *
     * @return Returns the image of the icon, or the default application icon
     * if it could not be found.  Does not return null.
     * @throws NameNotFoundException Thrown if the resources for the given
     * application could not be loaded.
     *
     * @see #getApplicationIcon(ApplicationInfo)
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.683 -0500", hash_original_method = "EE5F31B7588978F62B92A22FA544772B", hash_generated_method = "3924CFBDD036383EE621CCED3E85ACEE")
    
public abstract Drawable getApplicationIcon(String packageName)
            throws NameNotFoundException;

    /**
     * Retrieve the logo associated with an activity.  Given the full name of
     * an activity, retrieves the information about it and calls
     * {@link ComponentInfo#loadLogo ComponentInfo.loadLogo()} to return its logo.
     * If the activity can not be found, NameNotFoundException is thrown.
     *
     * @param activityName Name of the activity whose logo is to be retrieved.
     *
     * @return Returns the image of the logo or null if the activity has no
     * logo specified.
     *
     * @throws NameNotFoundException Thrown if the resources for the given
     * activity could not be loaded.
     *
     * @see #getActivityLogo(Intent)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.685 -0500", hash_original_method = "72D3EAA688209A6C3C5E937519CB7B0F", hash_generated_method = "9382884CF2E513573715BE86B21B024F")
    
public abstract Drawable getActivityLogo(ComponentName activityName)
            throws NameNotFoundException;

    /**
     * Retrieve the logo associated with an Intent.  If intent.getClassName() is
     * set, this simply returns the result of
     * getActivityLogo(intent.getClassName()).  Otherwise it resolves the intent's
     * component and returns the logo associated with the resolved component.
     * If intent.getClassName() can not be found or the Intent can not be resolved
     * to a component, NameNotFoundException is thrown.
     *
     * @param intent The intent for which you would like to retrieve a logo.
     *
     * @return Returns the image of the logo, or null if the activity has no
     * logo specified.
     *
     * @throws NameNotFoundException Thrown if the resources for application
     * matching the given intent could not be loaded.
     *
     * @see #getActivityLogo(ComponentName)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.688 -0500", hash_original_method = "B7D8101E24D24E0DE8225D266C3A23D4", hash_generated_method = "60F30CDA35B11C73FA1DBCC225C486CB")
    
public abstract Drawable getActivityLogo(Intent intent)
            throws NameNotFoundException;

    /**
     * Retrieve the logo associated with an application.  If it has not specified
     * a logo, this method returns null.
     *
     * @param info Information about application being queried.
     *
     * @return Returns the image of the logo, or null if no logo is specified
     * by the application.
     *
     * @see #getApplicationLogo(String)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.690 -0500", hash_original_method = "B35E97D218FE21A0E4D7B47E4E99E17F", hash_generated_method = "4E49CA9452A0082688B6D5B7C2A5C74B")
    
public abstract Drawable getApplicationLogo(ApplicationInfo info);

    /**
     * Retrieve the logo associated with an application.  Given the name of the
     * application's package, retrieves the information about it and calls
     * getApplicationLogo() to return its logo. If the application can not be
     * found, NameNotFoundException is thrown.
     *
     * @param packageName Name of the package whose application logo is to be
     *                    retrieved.
     *
     * @return Returns the image of the logo, or null if no application logo
     * has been specified.
     *
     * @throws NameNotFoundException Thrown if the resources for the given
     * application could not be loaded.
     *
     * @see #getApplicationLogo(ApplicationInfo)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.692 -0500", hash_original_method = "876E1868BEAF1914F1315F896CAB6D9A", hash_generated_method = "9734B608CBCC32E8DCD2828BD7D459BC")
    
public abstract Drawable getApplicationLogo(String packageName)
            throws NameNotFoundException;

    /**
     * Retrieve text from a package.  This is a low-level API used by
     * the various package manager info structures (such as
     * {@link ComponentInfo} to implement retrieval of their associated
     * labels and other text.
     *
     * @param packageName The name of the package that this text is coming from.
     * Can not be null.
     * @param resid The resource identifier of the desired text.  Can not be 0.
     * @param appInfo Overall information about <var>packageName</var>.  This
     * may be null, in which case the application information will be retrieved
     * for you if needed; if you already have this information around, it can
     * be much more efficient to supply it here.
     *
     * @return Returns a CharSequence holding the requested text.  Returns null
     * if the text could not be found for any reason.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.695 -0500", hash_original_method = "2A7BFB311C84FD8E4EF4C01B6D5EB947", hash_generated_method = "CB94C4436B9E158F57F46560137383C6")
    
public abstract CharSequence getText(String packageName, int resid,
            ApplicationInfo appInfo);

    /**
     * Retrieve an XML file from a package.  This is a low-level API used to
     * retrieve XML meta data.
     *
     * @param packageName The name of the package that this xml is coming from.
     * Can not be null.
     * @param resid The resource identifier of the desired xml.  Can not be 0.
     * @param appInfo Overall information about <var>packageName</var>.  This
     * may be null, in which case the application information will be retrieved
     * for you if needed; if you already have this information around, it can
     * be much more efficient to supply it here.
     *
     * @return Returns an XmlPullParser allowing you to parse out the XML
     * data.  Returns null if the xml resource could not be found for any
     * reason.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.698 -0500", hash_original_method = "363B4E594512153F665761A5BBDE48A6", hash_generated_method = "B983602750EEA130A5F26EE5F9C47085")
    
public abstract XmlResourceParser getXml(String packageName, int resid,
            ApplicationInfo appInfo);

    /**
     * Return the label to use for this application.
     *
     * @return Returns the label associated with this application, or null if
     * it could not be found for any reason.
     * @param info The application to get the label of
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.700 -0500", hash_original_method = "9CBEA3BF0AE7CFAA4440ABBDDD974B55", hash_generated_method = "5E9D06E583A54C2826BDD24E952441E9")
    
public abstract CharSequence getApplicationLabel(ApplicationInfo info);

    /**
     * Retrieve the resources associated with an activity.  Given the full
     * name of an activity, retrieves the information about it and calls
     * getResources() to return its application's resources.  If the activity
     * can not be found, NameNotFoundException is thrown.
     *
     * @param activityName Name of the activity whose resources are to be
     *                     retrieved.
     *
     * @return Returns the application's Resources.
     * @throws NameNotFoundException Thrown if the resources for the given
     * application could not be loaded.
     *
     * @see #getResourcesForApplication(ApplicationInfo)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.702 -0500", hash_original_method = "D49D40A04F8C7046F914E9C140CB6B15", hash_generated_method = "68EB057F6EEA359BC643ADA91A690301")
    
public abstract Resources getResourcesForActivity(ComponentName activityName)
            throws NameNotFoundException;

    /**
     * Retrieve the resources for an application.  Throws NameNotFoundException
     * if the package is no longer installed.
     *
     * @param app Information about the desired application.
     *
     * @return Returns the application's Resources.
     * @throws NameNotFoundException Thrown if the resources for the given
     * application could not be loaded (most likely because it was uninstalled).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.704 -0500", hash_original_method = "93B4F6A2202CAD660BD1E4C6E0AA08F5", hash_generated_method = "C8F2769D83C3197F160C64AE27A03E3B")
    
public abstract Resources getResourcesForApplication(ApplicationInfo app)
            throws NameNotFoundException;

    /**
     * Retrieve the resources associated with an application.  Given the full
     * package name of an application, retrieves the information about it and
     * calls getResources() to return its application's resources.  If the
     * appPackageName can not be found, NameNotFoundException is thrown.
     *
     * @param appPackageName Package name of the application whose resources
     *                       are to be retrieved.
     *
     * @return Returns the application's Resources.
     * @throws NameNotFoundException Thrown if the resources for the given
     * application could not be loaded.
     *
     * @see #getResourcesForApplication(ApplicationInfo)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.706 -0500", hash_original_method = "5F950A6C45FA4057F16F5D92101FE41D", hash_generated_method = "DFB1B9C9D3AC3D7C36DAADB67654C692")
    
public abstract Resources getResourcesForApplication(String appPackageName)
            throws NameNotFoundException;

    /**
     * Retrieve overall information about an application package defined
     * in a package archive file
     *
     * @param archiveFilePath The path to the archive file
     * @param flags Additional option flags. Use any combination of
     * {@link #GET_ACTIVITIES},
     * {@link #GET_GIDS},
     * {@link #GET_CONFIGURATIONS},
     * {@link #GET_INSTRUMENTATION},
     * {@link #GET_PERMISSIONS},
     * {@link #GET_PROVIDERS},
     * {@link #GET_RECEIVERS},
     * {@link #GET_SERVICES},
     * {@link #GET_SIGNATURES}, to modify the data returned.
     *
     * @return Returns the information about the package. Returns
     * null if the package could not be successfully parsed.
     *
     * @see #GET_ACTIVITIES
     * @see #GET_GIDS
     * @see #GET_CONFIGURATIONS
     * @see #GET_INSTRUMENTATION
     * @see #GET_PERMISSIONS
     * @see #GET_PROVIDERS
     * @see #GET_RECEIVERS
     * @see #GET_SERVICES
     * @see #GET_SIGNATURES
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.709 -0500", hash_original_method = "DBC2C646566E0B22A2FF91F44F8D10B2", hash_generated_method = "EE2A120389E314C8CE9A5487ED80AEB5")
    
public PackageInfo getPackageArchiveInfo(String archiveFilePath, int flags) {
        PackageParser packageParser = new PackageParser(archiveFilePath);
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.setToDefaults();
        final File sourceFile = new File(archiveFilePath);
        PackageParser.Package pkg = packageParser.parsePackage(
                sourceFile, archiveFilePath, metrics, 0);
        if (pkg == null) {
            return null;
        }
        if ((flags & GET_SIGNATURES) != 0) {
            packageParser.collectCertificates(pkg, 0);
        }
        return PackageParser.generatePackageInfo(pkg, null, flags, 0, 0);
    }

    /**
     * @hide
     *
     * Install a package. Since this may take a little while, the result will
     * be posted back to the given observer.  An installation will fail if the calling context
     * lacks the {@link android.Manifest.permission#INSTALL_PACKAGES} permission, if the
     * package named in the package file's manifest is already installed, or if there's no space
     * available on the device.
     *
     * @param packageURI The location of the package file to install.  This can be a 'file:' or a
     * 'content:' URI.
     * @param observer An observer callback to get notified when the package installation is
     * complete. {@link IPackageInstallObserver#packageInstalled(String, int)} will be
     * called when that happens.  observer may be null to indicate that no callback is desired.
     * @param flags - possible values: {@link #INSTALL_FORWARD_LOCK},
     * {@link #INSTALL_REPLACE_EXISTING}, {@link #INSTALL_ALLOW_TEST}.
     * @param installerPackageName Optional package name of the application that is performing the
     * installation. This identifies which market the package came from.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.711 -0500", hash_original_method = "8D73316549FCE69B062278B1485922EA", hash_generated_method = "3CB2D9FD2F71DD43AA11097FF06CE1F5")
    
public abstract void installPackage(
            Uri packageURI, IPackageInstallObserver observer, int flags,
            String installerPackageName);

    /**
     * Similar to
     * {@link #installPackage(Uri, IPackageInstallObserver, int, String)} but
     * with an extra verification file provided.
     *
     * @param packageURI The location of the package file to install. This can
     *            be a 'file:' or a 'content:' URI.
     * @param observer An observer callback to get notified when the package
     *            installation is complete.
     *            {@link IPackageInstallObserver#packageInstalled(String, int)}
     *            will be called when that happens. observer may be null to
     *            indicate that no callback is desired.
     * @param flags - possible values: {@link #INSTALL_FORWARD_LOCK},
     *            {@link #INSTALL_REPLACE_EXISTING}, {@link #INSTALL_ALLOW_TEST}
     *            .
     * @param installerPackageName Optional package name of the application that
     *            is performing the installation. This identifies which market
     *            the package came from.
     * @param verificationURI The location of the supplementary verification
     *            file. This can be a 'file:' or a 'content:' URI.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.713 -0500", hash_original_method = "F5463B1B76FDFFB125958D605BAE53C0", hash_generated_method = "8AEBF1DA5680BE1293DA45C1FEC7BEA3")
    
public abstract void installPackageWithVerification(Uri packageURI,
            IPackageInstallObserver observer, int flags, String installerPackageName,
            Uri verificationURI, ManifestDigest manifestDigest);

    /**
     * Allows a package listening to the
     * {@link Intent#ACTION_PACKAGE_NEEDS_VERIFICATION package verification
     * broadcast} to respond to the package manager. The response must include
     * the {@code verificationCode} which is one of
     * {@link PackageManager#VERIFICATION_ALLOW} or
     * {@link PackageManager#VERIFICATION_REJECT}.
     *
     * @param id pending package identifier as passed via the
     *            {@link PackageManager#EXTRA_VERIFICATION_ID} Intent extra
     * @param verificationCode either {@link PackageManager#VERIFICATION_ALLOW}
     *            or {@link PackageManager#VERIFICATION_REJECT}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.715 -0500", hash_original_method = "07AE0750ECEB06BED8C2106631AF1BC6", hash_generated_method = "7D0F10C9B6535CA25E6FC9AFE2BF1244")
    
public abstract void verifyPendingInstall(int id, int verificationCode);

    /**
     * Change the installer associated with a given package.  There are limitations
     * on how the installer package can be changed; in particular:
     * <ul>
     * <li> A SecurityException will be thrown if <var>installerPackageName</var>
     * is not signed with the same certificate as the calling application.
     * <li> A SecurityException will be thrown if <var>targetPackage</var> already
     * has an installer package, and that installer package is not signed with
     * the same certificate as the calling application.
     * </ul>
     *
     * @param targetPackage The installed package whose installer will be changed.
     * @param installerPackageName The package name of the new installer.  May be
     * null to clear the association.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.718 -0500", hash_original_method = "2102DDB8238163D944D0FE67C0534BAE", hash_generated_method = "2D86404888E4BE25F3D6C6164A5686D2")
    
public abstract void setInstallerPackageName(String targetPackage,
            String installerPackageName);

    /**
     * Attempts to delete a package.  Since this may take a little while, the result will
     * be posted back to the given observer.  A deletion will fail if the calling context
     * lacks the {@link android.Manifest.permission#DELETE_PACKAGES} permission, if the
     * named package cannot be found, or if the named package is a "system package".
     * (TODO: include pointer to documentation on "system packages")
     *
     * @param packageName The name of the package to delete
     * @param observer An observer callback to get notified when the package deletion is
     * complete. {@link android.content.pm.IPackageDeleteObserver#packageDeleted(boolean)} will be
     * called when that happens.  observer may be null to indicate that no callback is desired.
     * @param flags - possible values: {@link #DONT_DELETE_DATA}
     *
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.721 -0500", hash_original_method = "D8F259449BDB1043901BBB27CD67E236", hash_generated_method = "F7E22F688F4FEE47EC499D406935B11C")
    
public abstract void deletePackage(
            String packageName, IPackageDeleteObserver observer, int flags);

    /**
     * Retrieve the package name of the application that installed a package. This identifies
     * which market the package came from.
     *
     * @param packageName The name of the package to query
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.723 -0500", hash_original_method = "D13E43B26F3F2B0FE2A1C295646D8E7D", hash_generated_method = "BD3CD52B65ADA33A4C3E661768696693")
    
public abstract String getInstallerPackageName(String packageName);

    /**
     * Attempts to clear the user data directory of an application.
     * Since this may take a little while, the result will
     * be posted back to the given observer.  A deletion will fail if the
     * named package cannot be found, or if the named package is a "system package".
     *
     * @param packageName The name of the package
     * @param observer An observer callback to get notified when the operation is finished
     * {@link android.content.pm.IPackageDataObserver#onRemoveCompleted(String, boolean)}
     * will be called when that happens.  observer may be null to indicate that
     * no callback is desired.
     *
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.726 -0500", hash_original_method = "2ED1536C94574239586AD7BECE72C573", hash_generated_method = "2BB9BC43C5C5C8919C33DA9E9634FAA0")
    
public abstract void clearApplicationUserData(String packageName,
            IPackageDataObserver observer);
    /**
     * Attempts to delete the cache files associated with an application.
     * Since this may take a little while, the result will
     * be posted back to the given observer.  A deletion will fail if the calling context
     * lacks the {@link android.Manifest.permission#DELETE_CACHE_FILES} permission, if the
     * named package cannot be found, or if the named package is a "system package".
     *
     * @param packageName The name of the package to delete
     * @param observer An observer callback to get notified when the cache file deletion
     * is complete.
     * {@link android.content.pm.IPackageDataObserver#onRemoveCompleted(String, boolean)}
     * will be called when that happens.  observer may be null to indicate that
     * no callback is desired.
     *
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.728 -0500", hash_original_method = "42C1B75E296233E02ABB321D14C0D666", hash_generated_method = "7E7FB8B1AA84F0A8CCC6A7DBD4BBB878")
    
public abstract void deleteApplicationCacheFiles(String packageName,
            IPackageDataObserver observer);

    /**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param observer call back used to notify when
     * the operation is completed
     *
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.730 -0500", hash_original_method = "70C6CE78D1494DC97AED71D06F3F0744", hash_generated_method = "133628A0981A794E9E0DDEE34B803F38")
    
public abstract void freeStorageAndNotify(long freeStorageSize, IPackageDataObserver observer);

    /**
     * Free storage by deleting LRU sorted list of cache files across
     * all applications. If the currently available free storage
     * on the device is greater than or equal to the requested
     * free storage, no cache files are cleared. If the currently
     * available storage on the device is less than the requested
     * free storage, some or all of the cache files across
     * all applications are deleted (based on last accessed time)
     * to increase the free storage space on the device to
     * the requested value. There is no guarantee that clearing all
     * the cache files from all applications will clear up
     * enough storage to achieve the desired value.
     * @param freeStorageSize The number of bytes of storage to be
     * freed by the system. Say if freeStorageSize is XX,
     * and the current free storage is YY,
     * if XX is less than YY, just return. if not free XX-YY number
     * of bytes if possible.
     * @param pi IntentSender call back used to
     * notify when the operation is completed.May be null
     * to indicate that no call back is desired.
     *
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.733 -0500", hash_original_method = "7AF5EAB847888004783925D000370524", hash_generated_method = "5CAAC20E6626AC5969918AFBECB5C911")
    
public abstract void freeStorage(long freeStorageSize, IntentSender pi);

    /**
     * Retrieve the size information for a package.
     * Since this may take a little while, the result will
     * be posted back to the given observer.  The calling context
     * should have the {@link android.Manifest.permission#GET_PACKAGE_SIZE} permission.
     *
     * @param packageName The name of the package whose size information is to be retrieved
     * @param observer An observer callback to get notified when the operation
     * is complete.
     * {@link android.content.pm.IPackageStatsObserver#onGetStatsCompleted(PackageStats, boolean)}
     * The observer's callback is invoked with a PackageStats object(containing the
     * code, data and cache sizes of the package) and a boolean value representing
     * the status of the operation. observer may be null to indicate that
     * no callback is desired.
     *
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.735 -0500", hash_original_method = "A38939ED73318CA6F17E3B37317BE946", hash_generated_method = "86C2BCA14B7A84F49DE215D13AAF3C1D")
    
public abstract void getPackageSizeInfo(String packageName,
            IPackageStatsObserver observer);

    /**
     * @deprecated This function no longer does anything; it was an old
     * approach to managing preferred activities, which has been superceeded
     * (and conflicts with) the modern activity-based preferences.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.738 -0500", hash_original_method = "B4F265716AD3B7028018546284F8F0D3", hash_generated_method = "D2CCFEC40720846A449D0AB3E179EBF2")
    
@Deprecated
    public abstract void addPackageToPreferred(String packageName);

    /**
     * @deprecated This function no longer does anything; it was an old
     * approach to managing preferred activities, which has been superceeded
     * (and conflicts with) the modern activity-based preferences.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.741 -0500", hash_original_method = "17ECEF108F5AC81C96FA84D9CE714B90", hash_generated_method = "EA5B3BE94C2841CCB01650BDBD50C943")
    
@Deprecated
    public abstract void removePackageFromPreferred(String packageName);

    /**
     * Retrieve the list of all currently configured preferred packages.  The
     * first package on the list is the most preferred, the last is the
     * least preferred.
     *
     * @param flags Additional option flags. Use any combination of
     * {@link #GET_ACTIVITIES},
     * {@link #GET_GIDS},
     * {@link #GET_CONFIGURATIONS},
     * {@link #GET_INSTRUMENTATION},
     * {@link #GET_PERMISSIONS},
     * {@link #GET_PROVIDERS},
     * {@link #GET_RECEIVERS},
     * {@link #GET_SERVICES},
     * {@link #GET_SIGNATURES}, to modify the data returned.
     *
     * @return Returns a list of PackageInfo objects describing each
     * preferred application, in order of preference.
     *
     * @see #GET_ACTIVITIES
     * @see #GET_GIDS
     * @see #GET_CONFIGURATIONS
     * @see #GET_INSTRUMENTATION
     * @see #GET_PERMISSIONS
     * @see #GET_PROVIDERS
     * @see #GET_RECEIVERS
     * @see #GET_SERVICES
     * @see #GET_SIGNATURES
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.743 -0500", hash_original_method = "DBBC93CCDE0FC3BEBD8CD9650BD958CB", hash_generated_method = "80986AAE801E3B8DE2E7758104D71C4E")
    
public abstract List<PackageInfo> getPreferredPackages(int flags);

    /**
     * @deprecated This is a protected API that should not have been available
     * to third party applications.  It is the platform's responsibility for
     * assigning preferred activities and this can not be directly modified.
     *
     * Add a new preferred activity mapping to the system.  This will be used
     * to automatically select the given activity component when
     * {@link Context#startActivity(Intent) Context.startActivity()} finds
     * multiple matching activities and also matches the given filter.
     *
     * @param filter The set of intents under which this activity will be
     * made preferred.
     * @param match The IntentFilter match category that this preference
     * applies to.
     * @param set The set of activities that the user was picking from when
     * this preference was made.
     * @param activity The component name of the activity that is to be
     * preferred.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.745 -0500", hash_original_method = "B562DC2B56E29A1D49255B4F37519597", hash_generated_method = "2055802C7ABC55D78A8E69444262FF61")
    
@Deprecated
    public abstract void addPreferredActivity(IntentFilter filter, int match,
            ComponentName[] set, ComponentName activity);

    /**
     * @deprecated This is a protected API that should not have been available
     * to third party applications.  It is the platform's responsibility for
     * assigning preferred activities and this can not be directly modified.
     *
     * Replaces an existing preferred activity mapping to the system, and if that were not present
     * adds a new preferred activity.  This will be used
     * to automatically select the given activity component when
     * {@link Context#startActivity(Intent) Context.startActivity()} finds
     * multiple matching activities and also matches the given filter.
     *
     * @param filter The set of intents under which this activity will be
     * made preferred.
     * @param match The IntentFilter match category that this preference
     * applies to.
     * @param set The set of activities that the user was picking from when
     * this preference was made.
     * @param activity The component name of the activity that is to be
     * preferred.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.747 -0500", hash_original_method = "C4BA0EA2FDE6FBD8FA36D2B15A29AD9B", hash_generated_method = "007047C01186ACBE413B1FAD38EF7687")
    
@Deprecated
    public abstract void replacePreferredActivity(IntentFilter filter, int match,
            ComponentName[] set, ComponentName activity);

    /**
     * Remove all preferred activity mappings, previously added with
     * {@link #addPreferredActivity}, from the
     * system whose activities are implemented in the given package name.
     * An application can only clear its own package(s).
     *
     * @param packageName The name of the package whose preferred activity
     * mappings are to be removed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.749 -0500", hash_original_method = "7A7AC2431DD49E7557BECE681AD91CD4", hash_generated_method = "D6847F5EE90CA07B3A99F2CC5F62F650")
    
public abstract void clearPackagePreferredActivities(String packageName);

    /**
     * Retrieve all preferred activities, previously added with
     * {@link #addPreferredActivity}, that are
     * currently registered with the system.
     *
     * @param outFilters A list in which to place the filters of all of the
     * preferred activities, or null for none.
     * @param outActivities A list in which to place the component names of
     * all of the preferred activities, or null for none.
     * @param packageName An option package in which you would like to limit
     * the list.  If null, all activities will be returned; if non-null, only
     * those activities in the given package are returned.
     *
     * @return Returns the total number of registered preferred activities
     * (the number of distinct IntentFilter records, not the number of unique
     * activity components) that were found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.752 -0500", hash_original_method = "D06DEDAA9D6E674724231D1FB1756EEF", hash_generated_method = "77693F3D6B99A0988D01C8F7BD19DA2A")
    
public abstract int getPreferredActivities(List<IntentFilter> outFilters,
            List<ComponentName> outActivities, String packageName);

    /**
     * Set the enabled setting for a package component (activity, receiver, service, provider).
     * This setting will override any enabled state which may have been set by the component in its
     * manifest.
     *
     * @param componentName The component to enable
     * @param newState The new enabled state for the component.  The legal values for this state
     *                 are:
     *                   {@link #COMPONENT_ENABLED_STATE_ENABLED},
     *                   {@link #COMPONENT_ENABLED_STATE_DISABLED}
     *                   and
     *                   {@link #COMPONENT_ENABLED_STATE_DEFAULT}
     *                 The last one removes the setting, thereby restoring the component's state to
     *                 whatever was set in it's manifest (or enabled, by default).
     * @param flags Optional behavior flags: {@link #DONT_KILL_APP} or 0.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.754 -0500", hash_original_method = "66AA009103186E72165D0D729D621664", hash_generated_method = "DCE099311250D0226A7819B73DA59F90")
    
public abstract void setComponentEnabledSetting(ComponentName componentName,
            int newState, int flags);

    /**
     * Return the the enabled setting for a package component (activity,
     * receiver, service, provider).  This returns the last value set by
     * {@link #setComponentEnabledSetting(ComponentName, int, int)}; in most
     * cases this value will be {@link #COMPONENT_ENABLED_STATE_DEFAULT} since
     * the value originally specified in the manifest has not been modified.
     *
     * @param componentName The component to retrieve.
     * @return Returns the current enabled state for the component.  May
     * be one of {@link #COMPONENT_ENABLED_STATE_ENABLED},
     * {@link #COMPONENT_ENABLED_STATE_DISABLED}, or
     * {@link #COMPONENT_ENABLED_STATE_DEFAULT}.  The last one means the
     * component's enabled state is based on the original information in
     * the manifest as found in {@link ComponentInfo}.
     */
    @DSSource({DSSourceKind.IPC})
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.757 -0500", hash_original_method = "3762197D2621EC32C809039570FBAAF6", hash_generated_method = "EC95D4D7CBDCAEB7C1637EC583EBF611")
    
public abstract int getComponentEnabledSetting(ComponentName componentName);

    /**
     * Set the enabled setting for an application
     * This setting will override any enabled state which may have been set by the application in
     * its manifest.  It also overrides the enabled state set in the manifest for any of the
     * application's components.  It does not override any enabled state set by
     * {@link #setComponentEnabledSetting} for any of the application's components.
     *
     * @param packageName The package name of the application to enable
     * @param newState The new enabled state for the component.  The legal values for this state
     *                 are:
     *                   {@link #COMPONENT_ENABLED_STATE_ENABLED},
     *                   {@link #COMPONENT_ENABLED_STATE_DISABLED}
     *                   and
     *                   {@link #COMPONENT_ENABLED_STATE_DEFAULT}
     *                 The last one removes the setting, thereby restoring the applications's state to
     *                 whatever was set in its manifest (or enabled, by default).
     * @param flags Optional behavior flags: {@link #DONT_KILL_APP} or 0.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.759 -0500", hash_original_method = "0E474187E3B756B104FA0E075A724683", hash_generated_method = "52FCA3237E2357346F5394F2F0CEC9DA")
    
public abstract void setApplicationEnabledSetting(String packageName,
            int newState, int flags);

    /**
     * Return the the enabled setting for an application.  This returns
     * the last value set by
     * {@link #setApplicationEnabledSetting(String, int, int)}; in most
     * cases this value will be {@link #COMPONENT_ENABLED_STATE_DEFAULT} since
     * the value originally specified in the manifest has not been modified.
     *
     * @param packageName The component to retrieve.
     * @return Returns the current enabled state for the component.  May
     * be one of {@link #COMPONENT_ENABLED_STATE_ENABLED},
     * {@link #COMPONENT_ENABLED_STATE_DISABLED}, or
     * {@link #COMPONENT_ENABLED_STATE_DEFAULT}.  The last one means the
     * application's enabled state is based on the original information in
     * the manifest as found in {@link ComponentInfo}.
     * @throws IllegalArgumentException if the named package does not exist.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.761 -0500", hash_original_method = "A916373DCE1953E8DD9CAD868A077EA1", hash_generated_method = "854A599E6263A8AC3D70B7BACD465E06")
    
public abstract int getApplicationEnabledSetting(String packageName);

    /**
     * Return whether the device has been booted into safe mode.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.765 -0500", hash_original_method = "55D460E736B9D51B38361B7E8AD479B0", hash_generated_method = "B1FB96FD756A2E9F6A73E27758DC18CD")
    
public abstract boolean isSafeMode();

    /**
     * Attempts to move package resources from internal to external media or vice versa.
     * Since this may take a little while, the result will
     * be posted back to the given observer.   This call may fail if the calling context
     * lacks the {@link android.Manifest.permission#MOVE_PACKAGE} permission, if the
     * named package cannot be found, or if the named package is a "system package".
     *
     * @param packageName The name of the package to delete
     * @param observer An observer callback to get notified when the package move is
     * complete. {@link android.content.pm.IPackageMoveObserver#packageMoved(boolean)} will be
     * called when that happens.  observer may be null to indicate that no callback is desired.
     * @param flags To indicate install location {@link #MOVE_INTERNAL} or
     * {@link #MOVE_EXTERNAL_MEDIA}
     *
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.767 -0500", hash_original_method = "17EA4518846C9799A9276EE499C7BAE4", hash_generated_method = "F9BC1616F3523AB29B68212688ECB440")
    
public abstract void movePackage(
            String packageName, IPackageMoveObserver observer, int flags);

    /**
     * Creates a user with the specified name and options.
     *
     * @param name the user's name
     * @param flags flags that identify the type of user and other properties.
     * @see UserInfo
     *
     * @return the UserInfo object for the created user, or null if the user could not be created.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.769 -0500", hash_original_method = "673B3BA3C765E0E82274705B84D853CC", hash_generated_method = "DE3008CF5303C26E587AC290B6439274")
    
public abstract UserInfo createUser(String name, int flags);

    /**
     * @return the list of users that were created
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.771 -0500", hash_original_method = "E4FD4CBFB2842D7042DC01BD58E0DB6E", hash_generated_method = "EB962344D83BAC5F8958F6E8CAFB1D01")
    
public abstract List<UserInfo> getUsers();

    /**
     * @param id the ID of the user, where 0 is the primary user.
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.774 -0500", hash_original_method = "55D7EC8C15A93FCE3F7F45375C7ECD8A", hash_generated_method = "13D8A5B2C8109B34C7AD5FFA90872AA1")
    
public abstract boolean removeUser(int id);

    /**
     * Updates the user's name.
     *
     * @param id the user's id
     * @param name the new name for the user
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.776 -0500", hash_original_method = "9AFC22FCFCF2B94CCDE1C78E677E4D0D", hash_generated_method = "AFF1BC36E31FF22089C0A33C49927F6F")
    
public abstract void updateUserName(int id, String name);

    /**
     * Changes the user's properties specified by the flags.
     *
     * @param id the user's id
     * @param flags the new flags for the user
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.778 -0500", hash_original_method = "21DA0A4DFFD71D8D80F09C07EB9A325B", hash_generated_method = "D40F097B2A3FB98EE3E4E901F2FFBCB8")
    
public abstract void updateUserFlags(int id, int flags);

    /**
     * Returns the device identity that verifiers can use to associate their
     * scheme to a particular device. This should not be used by anything other
     * than a package verifier.
     *
     * @return identity that uniquely identifies current device
     * @hide
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:57.789 -0500", hash_original_method = "6C21FAF20525C0E9D5555329FC7F8BD4", hash_generated_method = "660E0C7FEB35CFA68CB1315734CA0C4F")
    
public abstract VerifierDeviceIdentity getVerifierDeviceIdentity();
}

