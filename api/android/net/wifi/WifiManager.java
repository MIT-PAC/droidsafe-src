package android.net.wifi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.net.DhcpInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.WorkSource;

import com.android.internal.util.AsyncChannel;

public class WifiManager {

    /**
     * Calculates the level of the signal. This should be used any time a signal
     * is being shown.
     *
     * @param rssi The power of the signal measured in RSSI.
     * @param numLevels The number of levels to consider in the calculated
     *            level.
     * @return A level of the signal, given in the range of 0 to numLevels-1
     *         (both inclusive).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.350 -0500", hash_original_method = "EC5E9CE8FA57602393C1D5810AE2C351", hash_generated_method = "847260701FB52388FF90DC2C4169A50B")
    
public static int calculateSignalLevel(int rssi, int numLevels) {
        if (rssi <= MIN_RSSI) {
            return 0;
        } else if (rssi >= MAX_RSSI) {
            return numLevels - 1;
        } else {
            float inputRange = (MAX_RSSI - MIN_RSSI);
            float outputRange = (numLevels - 1);
            return (int)((float)(rssi - MIN_RSSI) * outputRange / inputRange);
        }
    }

    /**
     * Compares two signal strengths.
     *
     * @param rssiA The power of the first signal measured in RSSI.
     * @param rssiB The power of the second signal measured in RSSI.
     * @return Returns <0 if the first signal is weaker than the second signal,
     *         0 if the two signals have the same strength, and >0 if the first
     *         signal is stronger than the second signal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.352 -0500", hash_original_method = "AC2D0644B70FE8C5B0B7836FC70F62E4", hash_generated_method = "9E8A2CC6A73F339F1823EB99E6F99432")
    
public static int compareSignalLevel(int rssiA, int rssiB) {
        return rssiA - rssiB;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.158 -0500", hash_original_field = "0E7BE8B8C07D7F42164342C08A624C5E", hash_generated_field = "FEF480C5F42E34F59BB853DC7A49B600")

    /**
     * The error code if there was a problem authenticating.
     */
    public static final int ERROR_AUTHENTICATING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.161 -0500", hash_original_field = "D10649A6EB2B2874582A6A34B247466B", hash_generated_field = "9799DA49B75F0D0576BFFBB0C76088EE")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String WIFI_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.164 -0500", hash_original_field = "DB6DF99232B0749E17FB41C0F5377238", hash_generated_field = "46567CB4BEB3DFB368FE4F8E475FB949")

    public static final String EXTRA_WIFI_STATE = "wifi_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.167 -0500", hash_original_field = "4E5289F3DD02D221A109EEFAC320284A", hash_generated_field = "D54DDD27C0FABD3E72B4463F8467DD8F")

    public static final String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.169 -0500", hash_original_field = "88758AF19B3B26C995F9B5868E7FAA23", hash_generated_field = "FE60C14FEA4D57BF2093A689913470B9")

    public static final int WIFI_STATE_DISABLING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.172 -0500", hash_original_field = "114EA4F241C04F0B8DCA5ABBFABC4F5A", hash_generated_field = "6A5366DF6585701D33781E3066B4AFA8")

    public static final int WIFI_STATE_DISABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.174 -0500", hash_original_field = "04EF4FF47C34CD82A45FF7E30013C675", hash_generated_field = "F2ADABF7F2992B3ED65D27E20283D1F6")

    public static final int WIFI_STATE_ENABLING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.176 -0500", hash_original_field = "8B38742B9F8A4D05F6073597FA3ABF6D", hash_generated_field = "06DDD34F33E45C8F663664CD911FF5AB")

    public static final int WIFI_STATE_ENABLED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.178 -0500", hash_original_field = "1418EB5D0CD52ED80C1423F5346D7489", hash_generated_field = "E8AFD6E713201D2BE9CCD062C6A47AEA")

    public static final int WIFI_STATE_UNKNOWN = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.181 -0500", hash_original_field = "93E88FFB006579D78BB723A8A66A6377", hash_generated_field = "705EDD303DB61EC718572FA5275D3C5A")

    public static final String WIFI_AP_STATE_CHANGED_ACTION =
        "android.net.wifi.WIFI_AP_STATE_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.184 -0500", hash_original_field = "EF54BCA18D3B6FC98CFB333FB8E26153", hash_generated_field = "92AFA518C48CABAA417E28328E2D9063")

    public static final String EXTRA_WIFI_AP_STATE = "wifi_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.186 -0500", hash_original_field = "95992E8D92D262707CEFFC947C667FC3", hash_generated_field = "7C2F550793EA245C07443AC5F1ED3AF6")

    public static final String EXTRA_PREVIOUS_WIFI_AP_STATE = "previous_wifi_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.188 -0500", hash_original_field = "FE133964E13731DEDD7E17AAEB63EE77", hash_generated_field = "209F5C5C2CDCF7B6F64BD4ED77AD042C")

    public static final int WIFI_AP_STATE_DISABLING = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.191 -0500", hash_original_field = "B6661DE80070F2CC978BEC42DFBA6A34", hash_generated_field = "3A49281391657B7405283CBCE0E99B88")

    public static final int WIFI_AP_STATE_DISABLED = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.193 -0500", hash_original_field = "5061FF9251C11F242B57E5F6DD7E1788", hash_generated_field = "43E8773A0C034F3EDE7247F857A9B19E")

    public static final int WIFI_AP_STATE_ENABLING = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.195 -0500", hash_original_field = "87B2452A80CD46F97F0FFB19F2D3A4EF", hash_generated_field = "597700F8A65905DB8E975F1D1E5F3DA6")

    public static final int WIFI_AP_STATE_ENABLED = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.198 -0500", hash_original_field = "AC8C653B0C3D941475E88EBE8AA1F24B", hash_generated_field = "A8488BD2ECBA6883D2DB38AE89ACE4F5")

    public static final int WIFI_AP_STATE_FAILED = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.200 -0500", hash_original_field = "52699548F694804441E4712C7DAA2EE0", hash_generated_field = "C77032707377A2B11B3B6B5DEFFE1311")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_CONNECTION_CHANGE_ACTION =
        "android.net.wifi.supplicant.CONNECTION_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.202 -0500", hash_original_field = "B1BD9B7BAD361722532E31E0E0AB5F7D", hash_generated_field = "CDBC8B7CF4D0CA98D9425D824E922C3A")

    public static final String EXTRA_SUPPLICANT_CONNECTED = "connected";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.205 -0500", hash_original_field = "DD23E340BA1D94D1692B58817141FBC8", hash_generated_field = "B8648E4BFBAEF813252FD594CC108B4D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.207 -0500", hash_original_field = "921B5A99469139AF646DB6EF6429D0F0", hash_generated_field = "422031D57C1A9E39521E008A0CBF3B3C")

    public static final String EXTRA_NETWORK_INFO = "networkInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.210 -0500", hash_original_field = "FE7249C9E356FF81FC204DF9DFC6E316", hash_generated_field = "BF57671FDC2B9ABDFAF5D8AEA7BAA947")

    public static final String EXTRA_BSSID = "bssid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.213 -0500", hash_original_field = "97C2DA9075F6807215CDA8A6FFFEFB59", hash_generated_field = "53C2244BE022BE4A381D06DA518EB76B")

    public static final String EXTRA_WIFI_INFO = "wifiInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.216 -0500", hash_original_field = "BDD8649E7C7F751D540C19BC1BC0E68D", hash_generated_field = "D73D816A0B7FCFD432AA984E977AC22C")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SUPPLICANT_STATE_CHANGED_ACTION =
        "android.net.wifi.supplicant.STATE_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.218 -0500", hash_original_field = "E238734F5811186B7EBAA1433A701754", hash_generated_field = "34AA826E3AF97AB38DB470F1C5654E68")

    public static final String EXTRA_NEW_STATE = "newState";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.220 -0500", hash_original_field = "BC46CBEE72650129386FEF9561C81F49", hash_generated_field = "DE620C91519E2A376661E1B4006EAACA")

    public static final String EXTRA_SUPPLICANT_ERROR = "supplicantError";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.223 -0500", hash_original_field = "4A49B7C4B03FA0645CED57E86308F955", hash_generated_field = "8B73608A4EF89D78B6901DFA0665D165")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ERROR_ACTION = "android.net.wifi.ERROR";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.225 -0500", hash_original_field = "B45711644288FCCE80CA7102F5ACC935", hash_generated_field = "FA40DA21A3D0B77445C4852C84BE80AE")

    public static final String EXTRA_ERROR_CODE = "errorCode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.228 -0500", hash_original_field = "83C69A7DDB3F34E3295B443A6F1ECD6A", hash_generated_field = "2784A14BBCACF543186CCAAD68AC111C")

    public static final int WPS_OVERLAP_ERROR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.230 -0500", hash_original_field = "72494526E74306C575091DA9F01D9CD0", hash_generated_field = "3DEB0A15DB5D2EDEE13E62DA3FC221C7")

    public static final String CONFIGURED_NETWORKS_CHANGED_ACTION =
        "android.net.wifi.CONFIGURED_NETWORKS_CHANGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.233 -0500", hash_original_field = "3F8C5D6CD0733164ABEB9F9B640BFD1D", hash_generated_field = "FB9CA3626A316B66033D491508ED5D88")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.235 -0500", hash_original_field = "7228848023BED8C98639748FE4AC3083", hash_generated_field = "C71F973F8B385841B02BE2C761218AEF")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.237 -0500", hash_original_field = "87384A1A1F1CF6A136DA247F08E5E2BD", hash_generated_field = "F6576C7FACD2AA843A12F433031DB417")

    public static final String EXTRA_NEW_RSSI = "newRssi";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.240 -0500", hash_original_field = "0FF4547663189E2FC07F32F095144152", hash_generated_field = "4236F79C5A13A06E052A218C87FCD7AA")

    public static final String LINK_CONFIGURATION_CHANGED_ACTION =
        "android.net.wifi.LINK_CONFIGURATION_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.242 -0500", hash_original_field = "A9484BF33753D4C57F8ADB53299E0F23", hash_generated_field = "B2AF7393288899F9C62599EE162CC59A")

    public static final String EXTRA_LINK_PROPERTIES = "linkProperties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.244 -0500", hash_original_field = "F53FDD402EE015BC952A768B8006B5EF", hash_generated_field = "2EE887A583B9775AF34213DD8E61A00E")

    public static final String EXTRA_LINK_CAPABILITIES = "linkCapabilities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.247 -0500", hash_original_field = "CB716785A042041D24144A93F2BC83B7", hash_generated_field = "0325C95FCCE4B351CA7FEB67F6B7BA12")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.249 -0500", hash_original_field = "C2FCBAEEFAFE891FE370C5D4F2D4FBDA", hash_generated_field = "55C17055111CE4074EEDA5CECF2B3757")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.251 -0500", hash_original_field = "CC48E9B697D2E60214415BE405F344BF", hash_generated_field = "165D11A1ECFD913E5C1ECF94299A477E")

    public static final int WIFI_MODE_FULL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.254 -0500", hash_original_field = "3126FF402E0109219FA1621865A5AEA0", hash_generated_field = "94C5D29C1CE510F135890C372BE94396")

    public static final int WIFI_MODE_SCAN_ONLY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.257 -0500", hash_original_field = "7D137C045337902FA320937044D33491", hash_generated_field = "F3AB5F19FC3DF915800D3B2F6E33706C")

    public static final int WIFI_MODE_FULL_HIGH_PERF = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.259 -0500", hash_original_field = "DC714128DEA9E7083B3507675C3541F1", hash_generated_field = "9F9088C65BD4F1789D8C8FDAB77015A8")

    private static final int MIN_RSSI = -100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.261 -0500", hash_original_field = "1EAE24073F5A7F3E04FCB664A4087B6F", hash_generated_field = "7DF91D8D2EC01CB1BE1AE4CAFCD0F309")

    private static final int MAX_RSSI = -55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.264 -0500", hash_original_field = "C3339301F7DCB9D32FC02E60CAAC6C82", hash_generated_field = "B84D769DCD709B183890B60DF3C274DA")

    public static final int WIFI_FREQUENCY_BAND_AUTO = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.266 -0500", hash_original_field = "62D332FE8EF381A9D2CE5C9EB391BD38", hash_generated_field = "F498C8314733151CD8E82921B0C4E22C")

    public static final int WIFI_FREQUENCY_BAND_5GHZ = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.268 -0500", hash_original_field = "3C4657374C5AB8BE305230296E51CC86", hash_generated_field = "6A1155A1B59CAD32A0FAC3FE219F29D2")

    public static final int WIFI_FREQUENCY_BAND_2GHZ = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.270 -0500", hash_original_field = "043D7FC55A54395865CC8BCA8D514959", hash_generated_field = "9B58465EB0D92245EC9CA4D811AEC5DD")

    public static final int DATA_ACTIVITY_NOTIFICATION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.273 -0500", hash_original_field = "6E29AB440892886CE0F1090FD8856511", hash_generated_field = "CE3E3C76C8A320C9568632390F328B6F")

    //bit indicates data transmitted
    /** @hide */
    public static final int DATA_ACTIVITY_NONE         = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.275 -0500", hash_original_field = "D4E73FEDAEEB3718398DE22198981E5C", hash_generated_field = "B4DF8C490A9544C3C8D4B30926E0CD7E")

    public static final int DATA_ACTIVITY_IN           = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.277 -0500", hash_original_field = "580AE35A0C6711D1280C9C4296517E2B", hash_generated_field = "E3EC39EDBEEB9E8C0DC13BD46CB864BE")

    public static final int DATA_ACTIVITY_OUT          = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.280 -0500", hash_original_field = "69FAA77310F5D16D98D43B77E19860F1", hash_generated_field = "08F2BE8A202C8F8B111FD96D48B71285")

    public static final int DATA_ACTIVITY_INOUT        = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.286 -0500", hash_original_field = "7D2AD53D35B80CFFCE9D25E6844C5C7F", hash_generated_field = "A46B2DFFFC241E78B7C771A4BAE78A6E")

    private static final int MAX_ACTIVE_LOCKS = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.375 -0500", hash_original_field = "D2E7AA4C1DE07278F9743993333163B0", hash_generated_field = "AC2600E803D42BB76239F5A2CD70602F")

    /* Commands to WifiService */
    /** @hide */
    public static final int CMD_CONNECT_NETWORK             = 1;
    
    public class WifiLock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.410 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.413 -0500", hash_original_field = "C1C60EEEFE20A124392A660BAB916B64", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private  IBinder mBinder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.415 -0500", hash_original_field = "10901FC32DF7F71F9F354DE920A6F5B1", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.417 -0500", hash_original_field = "3AD78D1D4CE6492B77426188DE5C8EB6", hash_generated_field = "3AD78D1D4CE6492B77426188DE5C8EB6")

        int mLockType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.419 -0500", hash_original_field = "6387FBE27FDCBD71F0303F9770322717", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.421 -0500", hash_original_field = "E7CCAAED285F3EE33E0FED69E9F95147", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.423 -0500", hash_original_field = "842B61DB21B58291FC09444F5B6363D6", hash_generated_field = "C5BF497580D66C18B0028C0F7134DDF3")

        private WorkSource mWorkSource;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.426 -0500", hash_original_method = "044CDC682150D26B37DC0497B735DA49", hash_generated_method = "00A94C4A1B57EA7FAF54672A42E9BCDD")
        
private WifiLock(int lockType, String tag) {
            mTag = tag;
            mLockType = lockType;
            mBinder = new Binder();
            mRefCount = 0;
            mRefCounted = true;
            mHeld = false;
        }

        /**
         * Locks the Wi-Fi radio on until {@link #release} is called.
         *
         * If this WifiLock is reference-counted, each call to {@code acquire} will increment the
         * reference count, and the radio will remain locked as long as the reference count is
         * above zero.
         *
         * If this WifiLock is not reference-counted, the first call to {@code acquire} will lock
         * the radio, but subsequent calls will be ignored.  Only one call to {@link #release}
         * will be required, regardless of the number of times that {@code acquire} is called.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.429 -0500", hash_original_method = "208DCD1288F5AC0918E067B51EC18B17", hash_generated_method = "15F5DE8DE56310EC55EE30AB20985170")
        
public void acquire() {
            synchronized (mBinder) {
                if (mRefCounted ? (++mRefCount > 0) : (!mHeld)) {
                    try {
                        mService.acquireWifiLock(mBinder, mLockType, mTag, mWorkSource);
                        synchronized (WifiManager.this) {
                            if (mActiveLockCount >= MAX_ACTIVE_LOCKS) {
                                mService.releaseWifiLock(mBinder);
                                throw new UnsupportedOperationException(
                                            "Exceeded maximum number of wifi locks");
                            }
                            mActiveLockCount++;
                        }
                    } catch (RemoteException ignore) {
                    }
                    mHeld = true;
                }
            }
        }

        /**
         * Unlocks the Wi-Fi radio, allowing it to turn off when the device is idle.
         *
         * If this WifiLock is reference-counted, each call to {@code release} will decrement the
         * reference count, and the radio will be unlocked only when the reference count reaches
         * zero.  If the reference count goes below zero (that is, if {@code release} is called
         * a greater number of times than {@link #acquire}), an exception is thrown.
         *
         * If this WifiLock is not reference-counted, the first call to {@code release} (after
         * the radio was locked using {@link #acquire}) will unlock the radio, and subsequent
         * calls will be ignored.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.432 -0500", hash_original_method = "EEC110369AFED5315DDFD7D45F992208", hash_generated_method = "CE7CADFF513AFC914EDF1BF71D2F33BE")
        
public void release() {
            synchronized (mBinder) {
                if (mRefCounted ? (--mRefCount == 0) : (mHeld)) {
                    try {
                        mService.releaseWifiLock(mBinder);
                        synchronized (WifiManager.this) {
                            mActiveLockCount--;
                        }
                    } catch (RemoteException ignore) {
                    }
                    mHeld = false;
                }
                if (mRefCount < 0) {
                    throw new RuntimeException("WifiLock under-locked " + mTag);
                }
            }
        }

        /**
         * Controls whether this is a reference-counted or non-reference-counted WifiLock.
         *
         * Reference-counted WifiLocks keep track of the number of calls to {@link #acquire} and
         * {@link #release}, and only allow the radio to sleep when every call to {@link #acquire}
         * has been balanced with a call to {@link #release}.  Non-reference-counted WifiLocks
         * lock the radio whenever {@link #acquire} is called and it is unlocked, and unlock the
         * radio whenever {@link #release} is called and it is locked.
         *
         * @param refCounted true if this WifiLock should keep a reference count
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.434 -0500", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "347CADF6CB8B38FFFEC1DBC4B7CD3754")
        
public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
        }

        /**
         * Checks whether this WifiLock is currently held.
         *
         * @return true if this WifiLock is held, false otherwise
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.437 -0500", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "6E5AE3C21361B5E024A600F344792BD5")
        
public boolean isHeld() {
            synchronized (mBinder) {
                return mHeld;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.439 -0500", hash_original_method = "7C62BA62C0C3A7C1DC2FB1EDC51DE805", hash_generated_method = "7211CCA761244AE87149532644361626")
        
public void setWorkSource(WorkSource ws) {
            synchronized (mBinder) {
                if (ws != null && ws.size() == 0) {
                    ws = null;
                }
                boolean changed = true;
                if (ws == null) {
                    mWorkSource = null;
                } else if (mWorkSource == null) {
                    changed = mWorkSource != null;
                    mWorkSource = new WorkSource(ws);
                } else {
                    changed = mWorkSource.diff(ws);
                    if (changed) {
                        mWorkSource.set(ws);
                    }
                }
                if (changed && mHeld) {
                    try {
                        mService.updateWifiLockWorkSource(mBinder, mWorkSource);
                    } catch (RemoteException e) {
                    }
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.441 -0500", hash_original_method = "30E303CA91E967AFDBED5B1FC9CE8E64", hash_generated_method = "D8F56B03EE182D345F75848ED4C264D0")
        
public String toString() {
            String s1, s2, s3;
            synchronized (mBinder) {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                if (mRefCounted) {
                    s3 = "refcounted: refcount = " + mRefCount;
                } else {
                    s3 = "not refcounted";
                }
                return "WifiLock{ " + s1 + "; " + s2 + s3 + " }";
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.444 -0500", hash_original_method = "CDAA53D98D74A433929787E6E7DF605C", hash_generated_method = "10A675A85C6DFC01A0077684FFE54BD8")
        
@Override
        protected void finalize() throws Throwable {
            super.finalize();
            synchronized (mBinder) {
                if (mHeld) {
                    try {
                        mService.releaseWifiLock(mBinder);
                        synchronized (WifiManager.this) {
                            mActiveLockCount--;
                        }
                    } catch (RemoteException ignore) {
                    }
                }
            }
        }
        
    }
    
    public class MulticastLock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.456 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

        private String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.458 -0500", hash_original_field = "C1C60EEEFE20A124392A660BAB916B64", hash_generated_field = "A726660A8F3C406901F3D212C617E404")

        private  IBinder mBinder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.461 -0500", hash_original_field = "10901FC32DF7F71F9F354DE920A6F5B1", hash_generated_field = "66F3E0510779BE4D1B59CDAC387E6C47")

        private int mRefCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.463 -0500", hash_original_field = "6387FBE27FDCBD71F0303F9770322717", hash_generated_field = "EEB06CC18CFEB1CEBC8608AACD58D0B5")

        private boolean mRefCounted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.465 -0500", hash_original_field = "E7CCAAED285F3EE33E0FED69E9F95147", hash_generated_field = "CC6ABDC2865C3E48C44DCFBA12BDB07C")

        private boolean mHeld;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.468 -0500", hash_original_method = "DEAA1CCFF83554B98BCA4D411D463199", hash_generated_method = "5F88CA8CDD628FD1DC08813E04D07777")
        
private MulticastLock(String tag) {
            mTag = tag;
            mBinder = new Binder();
            mRefCount = 0;
            mRefCounted = true;
            mHeld = false;
        }

        /**
         * Locks Wifi Multicast on until {@link #release} is called.
         *
         * If this MulticastLock is reference-counted each call to
         * {@code acquire} will increment the reference count, and the
         * wifi interface will receive multicast packets as long as the
         * reference count is above zero.
         *
         * If this MulticastLock is not reference-counted, the first call to
         * {@code acquire} will turn on the multicast packets, but subsequent
         * calls will be ignored.  Only one call to {@link #release} will
         * be required, regardless of the number of times that {@code acquire}
         * is called.
         *
         * Note that other applications may also lock Wifi Multicast on.
         * Only they can relinquish their lock.
         *
         * Also note that applications cannot leave Multicast locked on.
         * When an app exits or crashes, any Multicast locks will be released.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.471 -0500", hash_original_method = "130A969831975A68066B20EB1F9033A3", hash_generated_method = "953949F6966190661FDE39011980842E")
        
public void acquire() {
            synchronized (mBinder) {
                if (mRefCounted ? (++mRefCount > 0) : (!mHeld)) {
                    try {
                        mService.acquireMulticastLock(mBinder, mTag);
                        synchronized (WifiManager.this) {
                            if (mActiveLockCount >= MAX_ACTIVE_LOCKS) {
                                mService.releaseMulticastLock();
                                throw new UnsupportedOperationException(
                                        "Exceeded maximum number of wifi locks");
                            }
                            mActiveLockCount++;
                        }
                    } catch (RemoteException ignore) {
                    }
                    mHeld = true;
                }
            }
        }

        /**
         * Unlocks Wifi Multicast, restoring the filter of packets
         * not addressed specifically to this device and saving power.
         *
         * If this MulticastLock is reference-counted, each call to
         * {@code release} will decrement the reference count, and the
         * multicast packets will only stop being received when the reference
         * count reaches zero.  If the reference count goes below zero (that
         * is, if {@code release} is called a greater number of times than
         * {@link #acquire}), an exception is thrown.
         *
         * If this MulticastLock is not reference-counted, the first call to
         * {@code release} (after the radio was multicast locked using
         * {@link #acquire}) will unlock the multicast, and subsequent calls
         * will be ignored.
         *
         * Note that if any other Wifi Multicast Locks are still outstanding
         * this {@code release} call will not have an immediate effect.  Only
         * when all applications have released all their Multicast Locks will
         * the Multicast filter be turned back on.
         *
         * Also note that when an app exits or crashes all of its Multicast
         * Locks will be automatically released.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.473 -0500", hash_original_method = "325730E7689E55EAB909A58356E01384", hash_generated_method = "BAFF42A96F0373DC5B88CA25EF09309A")
        
public void release() {
            synchronized (mBinder) {
                if (mRefCounted ? (--mRefCount == 0) : (mHeld)) {
                    try {
                        mService.releaseMulticastLock();
                        synchronized (WifiManager.this) {
                            mActiveLockCount--;
                        }
                    } catch (RemoteException ignore) {
                    }
                    mHeld = false;
                }
                if (mRefCount < 0) {
                    throw new RuntimeException("MulticastLock under-locked "
                            + mTag);
                }
            }
        }

        /**
         * Controls whether this is a reference-counted or non-reference-
         * counted MulticastLock.
         *
         * Reference-counted MulticastLocks keep track of the number of calls
         * to {@link #acquire} and {@link #release}, and only stop the
         * reception of multicast packets when every call to {@link #acquire}
         * has been balanced with a call to {@link #release}.  Non-reference-
         * counted MulticastLocks allow the reception of multicast packets
         * whenever {@link #acquire} is called and stop accepting multicast
         * packets whenever {@link #release} is called.
         *
         * @param refCounted true if this MulticastLock should keep a reference
         * count
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.475 -0500", hash_original_method = "792BAAC8BC5216CF4F7CAEC0A7A38B7F", hash_generated_method = "347CADF6CB8B38FFFEC1DBC4B7CD3754")
        
public void setReferenceCounted(boolean refCounted) {
            mRefCounted = refCounted;
        }

        /**
         * Checks whether this MulticastLock is currently held.
         *
         * @return true if this MulticastLock is held, false otherwise
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.477 -0500", hash_original_method = "D7CEEF49E1A909FEFC04FBB22CAEF31F", hash_generated_method = "6E5AE3C21361B5E024A600F344792BD5")
        
public boolean isHeld() {
            synchronized (mBinder) {
                return mHeld;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.480 -0500", hash_original_method = "98C6FF6ECD72200F1F4D177BCA8A2AA1", hash_generated_method = "4E4B766F164C2D0B9FC12BD796074839")
        
public String toString() {
            String s1, s2, s3;
            synchronized (mBinder) {
                s1 = Integer.toHexString(System.identityHashCode(this));
                s2 = mHeld ? "held; " : "";
                if (mRefCounted) {
                    s3 = "refcounted: refcount = " + mRefCount;
                } else {
                    s3 = "not refcounted";
                }
                return "MulticastLock{ " + s1 + "; " + s2 + s3 + " }";
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.483 -0500", hash_original_method = "EEB5ECA4A52575C705D77F616153B22D", hash_generated_method = "38EDACD42580ED7731F789586685C8E1")
        
@Override
        protected void finalize() throws Throwable {
            super.finalize();
            setReferenceCounted(false);
            release();
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.377 -0500", hash_original_field = "0D4DF752316BB23DC15632EF9D8F5A87", hash_generated_field = "46529F28CB12A06C7F56C09018C641A0")

    public static final int CMD_FORGET_NETWORK              = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.379 -0500", hash_original_field = "ECF70D3F81CE50659DC1C713CA045621", hash_generated_field = "6B8553C6C496218E9F37E094D517F7E5")

    public static final int CMD_SAVE_NETWORK                = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.381 -0500", hash_original_field = "33009B6CA5EC1E088BDA2757F7EFFEB7", hash_generated_field = "3FB85837ABE02F19E22F86C7FD9A7CB9")

    public static final int CMD_START_WPS                   = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.384 -0500", hash_original_field = "C796AD6965A31A460CD88558DB2831B6", hash_generated_field = "5A520D736A3DF8FA576C9E8034E02305")

    public static final int CMD_DISABLE_NETWORK             = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.386 -0500", hash_original_field = "8DC950F8449745AB459DA43DFD679593", hash_generated_field = "62AD7103C171F6715CF717F79DF2F8D9")

    /** @hide */
    public static final int CMD_WPS_COMPLETED               = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.388 -0500", hash_original_field = "702386F2DF70F2E016D8AF3599A0897D", hash_generated_field = "0CDE94E407CA2548C4A32F3D4E19CA7A")

    /** @hide */
    public static final int CMD_ENABLE_TRAFFIC_STATS_POLL   = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.391 -0500", hash_original_field = "2358EAECE8BA8B8FE2DE6D855A234474", hash_generated_field = "7A5F8E8BF9878485F2FEE42B8FB5E475")

    public static final int CMD_TRAFFIC_STATS_POLL          = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.282 -0500", hash_original_field = "DB1464CA9C87828D9D93BD784121DA8C", hash_generated_field = "DB1464CA9C87828D9D93BD784121DA8C")

    IWifiManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.284 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.289 -0500", hash_original_field = "1C1A5A3F531A9D5359DCA1FC0BB146A3", hash_generated_field = "D601BE33010BF0FF8F79216654DBC58D")

    private int mActiveLockCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.291 -0500", hash_original_field = "11B13DCB577224551B564ED453CFACC6", hash_generated_field = "C8DF611874A1503E325C16431857C1F2")

    private AsyncChannel mAsyncChannel = new AsyncChannel();

    /**
     * Create a new WifiManager instance.
     * Applications will almost always want to use
     * {@link android.content.Context#getSystemService Context.getSystemService()} to retrieve
     * the standard {@link android.content.Context#WIFI_SERVICE Context.WIFI_SERVICE}.
     * @param service the Binder interface
     * @param handler target for messages
     * @hide - hide this because it takes in a parameter of type IWifiManager, which
     * is a system private class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.293 -0500", hash_original_method = "45AC664258FD08C08C588B627CDDFFBC", hash_generated_method = "723D594B116872B21174AFD88F6F0A73")
    
public WifiManager(IWifiManager service, Handler handler) {
        mService = service;
        mHandler = handler;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.418 -0400", hash_original_method = "45AC664258FD08C08C588B627CDDFFBC", hash_generated_method = "B4F1E9EA15C43234D8FE3A9CE9AF5CBA")
    public  WifiManager() {
        // ---------- Original Method ----------
        //mService = service;
        //mHandler = handler;
    }

    /**
     * Return a list of all the networks configured in the supplicant.
     * Not all fields of WifiConfiguration are returned. Only the following
     * fields are filled in:
     * <ul>
     * <li>networkId</li>
     * <li>SSID</li>
     * <li>BSSID</li>
     * <li>priority</li>
     * <li>allowedProtocols</li>
     * <li>allowedKeyManagement</li>
     * <li>allowedAuthAlgorithms</li>
     * <li>allowedPairwiseCiphers</li>
     * <li>allowedGroupCiphers</li>
     * </ul>
     * @return a list of network configurations in the form of a list
     * of {@link WifiConfiguration} objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.295 -0500", hash_original_method = "7B7EDD72C806D0E7DC8642CC316AA722", hash_generated_method = "2972D3BD198B6B1632E78F6CE3F43BE5")
    
public List<WifiConfiguration> getConfiguredNetworks() {
        try {
            return mService.getConfiguredNetworks();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Add a new network description to the set of configured networks.
     * The {@code networkId} field of the supplied configuration object
     * is ignored.
     * <p/>
     * The new network will be marked DISABLED by default. To enable it,
     * called {@link #enableNetwork}.
     *
     * @param config the set of variables that describe the configuration,
     *            contained in a {@link WifiConfiguration} object.
     * @return the ID of the newly created network description. This is used in
     *         other operations to specified the network to be acted upon.
     *         Returns {@code -1} on failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.297 -0500", hash_original_method = "FC0AD51F5109F6EE6B896159A6BE091E", hash_generated_method = "5C2222EB6FB354B06ED147929A5CAFE2")
    
public int addNetwork(WifiConfiguration config) {
        if (config == null) {
            return -1;
        }
        config.networkId = -1;
        return addOrUpdateNetwork(config);
    }

    /**
     * Update the network description of an existing configured network.
     *
     * @param config the set of variables that describe the configuration,
     *            contained in a {@link WifiConfiguration} object. It may
     *            be sparse, so that only the items that are being changed
     *            are non-<code>null</code>. The {@code networkId} field
     *            must be set to the ID of the existing network being updated.
     * @return Returns the {@code networkId} of the supplied
     *         {@code WifiConfiguration} on success.
     *         <br/>
     *         Returns {@code -1} on failure, including when the {@code networkId}
     *         field of the {@code WifiConfiguration} does not refer to an
     *         existing network.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.300 -0500", hash_original_method = "BAE559B7BC959F87E1981FBD6EC47DF5", hash_generated_method = "377DD85131999AE19481B91ABB7D40E4")
    
public int updateNetwork(WifiConfiguration config) {
        if (config == null || config.networkId < 0) {
            return -1;
        }
        return addOrUpdateNetwork(config);
    }

    /**
     * Internal method for doing the RPC that creates a new network description
     * or updates an existing one.
     *
     * @param config The possibly sparse object containing the variables that
     *         are to set or updated in the network description.
     * @return the ID of the network on success, {@code -1} on failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.302 -0500", hash_original_method = "E64504FDFA81026BF4EAE79A420D3010", hash_generated_method = "93138780AA183F7F543C2CE5B8DA3BEA")
    
private int addOrUpdateNetwork(WifiConfiguration config) {
        try {
            return mService.addOrUpdateNetwork(config);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * Remove the specified network from the list of configured networks.
     * This may result in the asynchronous delivery of state change
     * events.
     * @param netId the integer that identifies the network configuration
     * to the supplicant
     * @return {@code true} if the operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.304 -0500", hash_original_method = "C55861B25E581745B3C6351405363685", hash_generated_method = "52E9B106CCE0D358D6536E73B2D2D055")
    
public boolean removeNetwork(int netId) {
        try {
            return mService.removeNetwork(netId);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Allow a previously configured network to be associated with. If
     * <code>disableOthers</code> is true, then all other configured
     * networks are disabled, and an attempt to connect to the selected
     * network is initiated. This may result in the asynchronous delivery
     * of state change events.
     * @param netId the ID of the network in the list of configured networks
     * @param disableOthers if true, disable all other networks. The way to
     * select a particular network to connect to is specify {@code true}
     * for this parameter.
     * @return {@code true} if the operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.306 -0500", hash_original_method = "A063D2F3A1A45A8B2BB20D41F98AEB1B", hash_generated_method = "5589CB694139C3927BD03E556015C3E5")
    
public boolean enableNetwork(int netId, boolean disableOthers) {
        try {
            return mService.enableNetwork(netId, disableOthers);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Disable a configured network. The specified network will not be
     * a candidate for associating. This may result in the asynchronous
     * delivery of state change events.
     * @param netId the ID of the network as returned by {@link #addNetwork}.
     * @return {@code true} if the operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.308 -0500", hash_original_method = "630BE7480BA2E95DA9CEC1F52BBE219A", hash_generated_method = "77542B059D3E982AEC0DAA518F06E8CB")
    
public boolean disableNetwork(int netId) {
        try {
            return mService.disableNetwork(netId);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Disable a configured network asynchronously.  This call is for abnormal network
     * events, and the user may be notified of network change, if they recently attempted
     * to connect to the specified network.
     * @param netId the ID of the network as returned by {@link #addNetwork}.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.310 -0500", hash_original_method = "4C2FCF871904470A4665E52D44D62875", hash_generated_method = "D931D99D7A7E06878979263386640E8D")
    
public void disableNetwork(int netId, int reason) {
        mAsyncChannel.sendMessage(CMD_DISABLE_NETWORK, netId, reason);
    }

    /**
     * Disassociate from the currently active access point. This may result
     * in the asynchronous delivery of state change events.
     * @return {@code true} if the operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.312 -0500", hash_original_method = "13D7026BA6E2310038D9CCEC7D1F5CA4", hash_generated_method = "68D6939781BFBE3ABBF2F3F61C7E9CDE")
    
public boolean disconnect() {
        try {
            mService.disconnect();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Reconnect to the currently active access point, if we are currently
     * disconnected. This may result in the asynchronous delivery of state
     * change events.
     * @return {@code true} if the operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.314 -0500", hash_original_method = "AD9DD9C3B4130EB49C99A6BF92BCA383", hash_generated_method = "77CCB71F17073013C1ADA1E87119797F")
    
public boolean reconnect() {
        try {
            mService.reconnect();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Reconnect to the currently active access point, even if we are already
     * connected. This may result in the asynchronous delivery of state
     * change events.
     * @return {@code true} if the operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.317 -0500", hash_original_method = "4462A23EEF44DC4F050ECB7EA4566A65", hash_generated_method = "EABBD524FFC32EC10FC20FCC2FE824B4")
    
public boolean reassociate() {
        try {
            mService.reassociate();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Check that the supplicant daemon is responding to requests.
     * @return {@code true} if we were able to communicate with the supplicant and
     * it returned the expected response to the PING message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.319 -0500", hash_original_method = "44FE7083E78F583BB16CDAFA3EBE6F36", hash_generated_method = "B3F0B9BDC6AF20544881CD9CD426063E")
    
public boolean pingSupplicant() {
        if (mService == null)
            return false;
        try {
            return mService.pingSupplicant();
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Request a scan for access points. Returns immediately. The availability
     * of the results is made known later by means of an asynchronous event sent
     * on completion of the scan.
     * @return {@code true} if the operation succeeded, i.e., the scan was initiated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.322 -0500", hash_original_method = "F8088016DD577DAE90193BD2B16E77E5", hash_generated_method = "C6E6D263C7E7F070386825C9F4C9A388")
    
public boolean startScan() {
        try {
            mService.startScan(false);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Request a scan for access points. Returns immediately. The availability
     * of the results is made known later by means of an asynchronous event sent
     * on completion of the scan.
     * This is a variant of startScan that forces an active scan, even if passive
     * scans are the current default
     * @return {@code true} if the operation succeeded, i.e., the scan was initiated
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.324 -0500", hash_original_method = "1BECDA97215EAB893F9C0F926E7877B4", hash_generated_method = "64FB3B23E4B608915AFCC88012E2AD53")
    
public boolean startScanActive() {
        try {
            mService.startScan(true);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Return dynamic information about the current Wi-Fi connection, if any is active.
     * @return the Wi-Fi information, contained in {@link WifiInfo}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.326 -0500", hash_original_method = "8E854EE6D7B979BB188C54EFD6BB6717", hash_generated_method = "BACD07F224066A26A350E7EE166370CC")
    
public WifiInfo getConnectionInfo() {
        try {
            return mService.getConnectionInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Return the results of the latest access point scan.
     * @return the list of access points found in the most recent scan.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.328 -0500", hash_original_method = "ADD60A4DA3445A3E968EB713F725E5F1", hash_generated_method = "AEC55E2ABA1887606E01EC0E53450CF4")
    
public List<ScanResult> getScanResults() {
        try {
            return mService.getScanResults();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Tell the supplicant to persist the current list of configured networks.
     * <p>
     * Note: It is possible for this method to change the network IDs of
     * existing networks. You should assume the network IDs can be different
     * after calling this method.
     *
     * @return {@code true} if the operation succeeded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.330 -0500", hash_original_method = "D1E32319AD181FF60DD93B5B2DB831F1", hash_generated_method = "1DA1A834FB6AFB8AE93CF220DEA6178C")
    
public boolean saveConfiguration() {
        try {
            return mService.saveConfiguration();
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Set the country code.
     * @param countryCode country code in ISO 3166 format.
     * @param persist {@code true} if this needs to be remembered
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.332 -0500", hash_original_method = "9549A9F9433914F9E55F5CC34183554C", hash_generated_method = "48DE8E76CF7664D9D8EDCCD82D598160")
    
public void setCountryCode(String country, boolean persist) {
        try {
            mService.setCountryCode(country, persist);
        } catch (RemoteException e) { }
    }

    /**
     * Set the operational frequency band.
     * @param band  One of
     *     {@link #WIFI_FREQUENCY_BAND_AUTO},
     *     {@link #WIFI_FREQUENCY_BAND_5GHZ},
     *     {@link #WIFI_FREQUENCY_BAND_2GHZ},
     * @param persist {@code true} if this needs to be remembered
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.334 -0500", hash_original_method = "4B6C5827C7D51FB40ECD8DD67D760E19", hash_generated_method = "135AE46AE78A33A8B1EA8E2116600E0C")
    
public void setFrequencyBand(int band, boolean persist) {
        try {
            mService.setFrequencyBand(band, persist);
        } catch (RemoteException e) { }
    }

    /**
     * Get the operational frequency band.
     * @return One of
     *     {@link #WIFI_FREQUENCY_BAND_AUTO},
     *     {@link #WIFI_FREQUENCY_BAND_5GHZ},
     *     {@link #WIFI_FREQUENCY_BAND_2GHZ} or
     *     {@code -1} on failure.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.337 -0500", hash_original_method = "481BDDBC9D497285776974614BBC7D82", hash_generated_method = "04053C7CC2F55838307435A1788B8D36")
    
public int getFrequencyBand() {
        try {
            return mService.getFrequencyBand();
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * Check if the chipset supports dual frequency band (2.4 GHz and 5 GHz)
     * @return {@code true} if supported, {@code false} otherwise.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.339 -0500", hash_original_method = "F73D127A0D43FAD1AD9DBA6A689AC70A", hash_generated_method = "D1D8F5B7AC287DAF0E66B8DB9E17BBCD")
    
public boolean isDualBandSupported() {
        try {
            return mService.isDualBandSupported();
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Return the DHCP-assigned addresses from the last successful DHCP request,
     * if any.
     * @return the DHCP information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.341 -0500", hash_original_method = "711DEA09870DB7E049F72B7F8BEBC0A1", hash_generated_method = "7E4E74EA6FA5BC303296784B3C9F1971")
    
public DhcpInfo getDhcpInfo() {
        try {
            return mService.getDhcpInfo();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Enable or disable Wi-Fi.
     * @param enabled {@code true} to enable, {@code false} to disable.
     * @return {@code true} if the operation succeeds (or if the existing state
     *         is the same as the requested state).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.343 -0500", hash_original_method = "B9430AD639DDE3004B577A4BF40EB18B", hash_generated_method = "6C2F829AF169DACAFAEEDD10ED44992C")
    
public boolean setWifiEnabled(boolean enabled) {
        try {
            return mService.setWifiEnabled(enabled);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Gets the Wi-Fi enabled state.
     * @return One of {@link #WIFI_STATE_DISABLED},
     *         {@link #WIFI_STATE_DISABLING}, {@link #WIFI_STATE_ENABLED},
     *         {@link #WIFI_STATE_ENABLING}, {@link #WIFI_STATE_UNKNOWN}
     * @see #isWifiEnabled()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.345 -0500", hash_original_method = "661FA885AE58B8C5231BF7DCF436505F", hash_generated_method = "0B5E55BEB69AF7D54D6ACFBCC094A048")
    
public int getWifiState() {
        try {
            return mService.getWifiEnabledState();
        } catch (RemoteException e) {
            return WIFI_STATE_UNKNOWN;
        }
    }

    /**
     * Return whether Wi-Fi is enabled or disabled.
     * @return {@code true} if Wi-Fi is enabled
     * @see #getWifiState()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.347 -0500", hash_original_method = "D7F0AFD1306EBF22F34F7E014A2C9B11", hash_generated_method = "F3D7FB4B1B4B8151872D04C5B84B09C5")
    
public boolean isWifiEnabled() {
        return getWifiState() == WIFI_STATE_ENABLED;
    }

    /**
     * Start AccessPoint mode with the specified
     * configuration. If the radio is already running in
     * AP mode, update the new configuration
     * Note that starting in access point mode disables station
     * mode operation
     * @param wifiConfig SSID, security and channel details as
     *        part of WifiConfiguration
     * @return {@code true} if the operation succeeds, {@code false} otherwise
     *
     * @hide Dont open up yet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.354 -0500", hash_original_method = "2BFE81971E8D979C3ECBD7F543427F67", hash_generated_method = "83130F171399B11404AC6D0DF2E60C00")
    
public boolean setWifiApEnabled(WifiConfiguration wifiConfig, boolean enabled) {
        try {
            mService.setWifiApEnabled(wifiConfig, enabled);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Gets the Wi-Fi enabled state.
     * @return One of {@link #WIFI_AP_STATE_DISABLED},
     *         {@link #WIFI_AP_STATE_DISABLING}, {@link #WIFI_AP_STATE_ENABLED},
     *         {@link #WIFI_AP_STATE_ENABLING}, {@link #WIFI_AP_STATE_FAILED}
     * @see #isWifiApEnabled()
     *
     * @hide Dont open yet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.356 -0500", hash_original_method = "B0BA72D208162E33734DF133F2E7F6AA", hash_generated_method = "5BA4CEE0E3538E92F0EF3710195F7D78")
    
public int getWifiApState() {
        try {
            return mService.getWifiApEnabledState();
        } catch (RemoteException e) {
            return WIFI_AP_STATE_FAILED;
        }
    }

    /**
     * Return whether Wi-Fi AP is enabled or disabled.
     * @return {@code true} if Wi-Fi AP is enabled
     * @see #getWifiApState()
     *
     * @hide Dont open yet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.358 -0500", hash_original_method = "657EB8B0A945E7FD7BA91E2539A322BE", hash_generated_method = "8ACDFC143C5D1CC9C09DF9B505B2415F")
    
public boolean isWifiApEnabled() {
        return getWifiApState() == WIFI_AP_STATE_ENABLED;
    }

    /**
     * Gets the Wi-Fi AP Configuration.
     * @return AP details in WifiConfiguration
     *
     * @hide Dont open yet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.361 -0500", hash_original_method = "99407E6898AC76390D3E229EC6CF35C4", hash_generated_method = "35049D917064A3DE3F998087FB518C89")
    
public WifiConfiguration getWifiApConfiguration() {
        try {
            return mService.getWifiApConfiguration();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Sets the Wi-Fi AP Configuration.
     * @return {@code true} if the operation succeeded, {@code false} otherwise
     *
     * @hide Dont open yet
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.363 -0500", hash_original_method = "32645F13A37CD40BEF3F9464116D1367", hash_generated_method = "63A13804EC2784E5DEC50D7C508747FA")
    
public boolean setWifiApConfiguration(WifiConfiguration wifiConfig) {
        try {
            mService.setWifiApConfiguration(wifiConfig);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

   /**
     * Start the driver and connect to network.
     *
     * This function will over-ride WifiLock and device idle status. For example,
     * even if the device is idle or there is only a scan-only lock held,
     * a start wifi would mean that wifi connection is kept active until
     * a stopWifi() is sent.
     *
     * This API is used by WifiStateTracker
     *
     * @return {@code true} if the operation succeeds else {@code false}
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.365 -0500", hash_original_method = "F505CF72442DFA261366294723957A53", hash_generated_method = "2DF82D557CA317A548AA78057765CD2E")
    
public boolean startWifi() {
        try {
            mService.startWifi();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Disconnect from a network (if any) and stop the driver.
     *
     * This function will over-ride WifiLock and device idle status. Wi-Fi
     * stays inactive until a startWifi() is issued.
     *
     * This API is used by WifiStateTracker
     *
     * @return {@code true} if the operation succeeds else {@code false}
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.367 -0500", hash_original_method = "F7F977701F133D0F59F048A53A2C698B", hash_generated_method = "ABBB6CDA68601FC7EFCC3D71377FC446")
    
public boolean stopWifi() {
        try {
            mService.stopWifi();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Add a bssid to the supplicant blacklist
     *
     * This API is used by WifiWatchdogService
     *
     * @return {@code true} if the operation succeeds else {@code false}
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.369 -0500", hash_original_method = "6E01C15F4CA49AC218CA465537508537", hash_generated_method = "B762F6FFED7C81D37A76594E0C90C97F")
    
public boolean addToBlacklist(String bssid) {
        try {
            mService.addToBlacklist(bssid);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Clear the supplicant blacklist
     *
     * This API is used by WifiWatchdogService
     *
     * @return {@code true} if the operation succeeds else {@code false}
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.372 -0500", hash_original_method = "614FAF75AF873709E1677408EE18D7B6", hash_generated_method = "C183834A8960AE30ED8ABDDEA347E16E")
    
public boolean clearBlacklist() {
        try {
            mService.clearBlacklist();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Initiate an asynchronous channel connection setup
     * @param srcContext is the context of the source
     * @param srcHandler is the handler on which the source receives messages
     * @hide
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.393 -0500", hash_original_method = "F93FD4BCC6C0F6B375A42EEFE25B9408", hash_generated_method = "A63D90834E46605F01C8E0E058E7A7BF")
    
public void asyncConnect(Context srcContext, Handler srcHandler) {
        mAsyncChannel.connect(srcContext, srcHandler, getMessenger());
     }

    /**
     * Connect to a network with the given configuration. The network also
     * gets added to the supplicant configuration.
     *
     * For a new network, this function is used instead of a
     * sequence of addNetwork(), enableNetwork(), saveConfiguration() and
     * reconnect()
     *
     * @param config the set of variables that describe the configuration,
     *            contained in a {@link WifiConfiguration} object.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.395 -0500", hash_original_method = "B69D8EEDABB0031125B40805CA5F91D8", hash_generated_method = "E69DB7567A3875675125CAD289244A42")
    
public void connectNetwork(WifiConfiguration config) {
        if (config == null) {
            return;
        }
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, config);
    }

    /**
     * Connect to a network with the given networkId.
     *
     * This function is used instead of a enableNetwork(), saveConfiguration() and
     * reconnect()
     *
     * @param networkId the network id identifiying the network in the
     *                supplicant configuration list
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.397 -0500", hash_original_method = "9464671A8FCBA7A99848867493116AAD", hash_generated_method = "B435B22C3DC043BEFA6480ED095FD9A9")
    
public void connectNetwork(int networkId) {
        if (networkId < 0) {
            return;
        }
        mAsyncChannel.sendMessage(CMD_CONNECT_NETWORK, networkId);
    }

    /**
     * Save the given network in the supplicant config. If the network already
     * exists, the configuration is updated. A new network is enabled
     * by default.
     *
     * For a new network, this function is used instead of a
     * sequence of addNetwork(), enableNetwork() and saveConfiguration().
     *
     * For an existing network, it accomplishes the task of updateNetwork()
     * and saveConfiguration()
     *
     * @param config the set of variables that describe the configuration,
     *            contained in a {@link WifiConfiguration} object.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.399 -0500", hash_original_method = "210177ED8E63F9C12E442B1614E4B9E7", hash_generated_method = "6662BB250D52E98445DC59FE85C8FA31")
    
public void saveNetwork(WifiConfiguration config) {
        if (config == null) {
            return;
        }

        mAsyncChannel.sendMessage(CMD_SAVE_NETWORK, config);
    }

    /**
     * Delete the network in the supplicant config.
     *
     * This function is used instead of a sequence of removeNetwork()
     * and saveConfiguration().
     *
     * @param config the set of variables that describe the configuration,
     *            contained in a {@link WifiConfiguration} object.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.401 -0500", hash_original_method = "A04E73224B607EFF8F851CD080EF29BA", hash_generated_method = "5CE2B7BA080B12D1AE1BE498248A895F")
    
public void forgetNetwork(int netId) {
        if (netId < 0) {
            return;
        }

        mAsyncChannel.sendMessage(CMD_FORGET_NETWORK, netId);
    }

    /**
     * Start Wi-fi Protected Setup
     *
     * @param config WPS configuration
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.403 -0500", hash_original_method = "CB69F89B2E3E5728AFF3169858F2154E", hash_generated_method = "857E7991EAD75DEDA36FF25D925F7A65")
    
public void startWps(WpsInfo config) {
        if (config == null) {
            return;
        }

        mAsyncChannel.sendMessage(CMD_START_WPS, config);
    }

    /**
     * Get a reference to WifiService handler. This is used by a client to establish
     * an AsyncChannel communication with WifiService
     *
     * @return Messenger pointing to the WifiService handler
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.406 -0500", hash_original_method = "A358F8361C96DABE1A63B04B5804B3F5", hash_generated_method = "DA6144D34D1ABFD0D2380EC6E44B953A")
    
public Messenger getMessenger() {
        try {
            return mService.getMessenger();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Returns the file in which IP and proxy configuration data is stored
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.408 -0500", hash_original_method = "F47F46BF01C13AECFB0A8E0A7BCA30AB", hash_generated_method = "0EEF0277E1EF24BD942F97C28A062DDB")
    
public String getConfigFile() {
        try {
            return mService.getConfigFile();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Creates a new WifiLock.
     *
     * @param lockType the type of lock to create. See {@link #WIFI_MODE_FULL},
     * {@link #WIFI_MODE_FULL_HIGH_PERF} and {@link #WIFI_MODE_SCAN_ONLY} for
     * descriptions of the types of Wi-Fi locks.
     * @param tag a tag for the WifiLock to identify it in debugging messages.  This string is
     *            never shown to the user under normal conditions, but should be descriptive
     *            enough to identify your application and the specific WifiLock within it, if it
     *            holds multiple WifiLocks.
     *
     * @return a new, unacquired WifiLock with the given tag.
     *
     * @see WifiLock
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.448 -0500", hash_original_method = "77C6D00CEFBA51FBEDF42525D5CAF8B4", hash_generated_method = "0017863403E4329B16521F9204F2257A")
    
public WifiLock createWifiLock(int lockType, String tag) {
        return new WifiLock(lockType, tag);
    }

    /**
     * Creates a new WifiLock.
     *
     * @param tag a tag for the WifiLock to identify it in debugging messages.  This string is
     *            never shown to the user under normal conditions, but should be descriptive
     *            enough to identify your application and the specific WifiLock within it, if it
     *            holds multiple WifiLocks.
     *
     * @return a new, unacquired WifiLock with the given tag.
     *
     * @see WifiLock
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.451 -0500", hash_original_method = "F25A7BAA745FE3E1539A4ACAD2E402AC", hash_generated_method = "273F4FF9E160AB67701DDADFDFA75CDD")
    
public WifiLock createWifiLock(String tag) {
        return new WifiLock(WIFI_MODE_FULL, tag);
    }

    /**
     * Create a new MulticastLock
     *
     * @param tag a tag for the MulticastLock to identify it in debugging
     *            messages.  This string is never shown to the user under
     *            normal conditions, but should be descriptive enough to
     *            identify your application and the specific MulticastLock
     *            within it, if it holds multiple MulticastLocks.
     *
     * @return a new, unacquired MulticastLock with the given tag.
     *
     * @see MulticastLock
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.453 -0500", hash_original_method = "90BF24DBA9F26B31ED84B0CABBF9287E", hash_generated_method = "44ED1D34D5A2181B0D15F63F3B719EC5")
    
public MulticastLock createMulticastLock(String tag) {
        return new MulticastLock(tag);
    }

    /**
     * Check multicast filter status.
     *
     * @return true if multicast packets are allowed.
     *
     * @hide pending API council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.488 -0500", hash_original_method = "36EA363278EADF8446AD30BF262D8211", hash_generated_method = "E2F4212D7AF6C9562AED52895CA91EA6")
    
public boolean isMulticastEnabled() {
        try {
            return mService.isMulticastEnabled();
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * Initialize the multicast filtering to 'on'
     * @hide no intent to publish
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:05.490 -0500", hash_original_method = "03CE776E3230E83E55C388557E1A9516", hash_generated_method = "08C306E2B08338F1F176FE99F997CDA4")
    
public boolean initializeMulticastFiltering() {
        try {
            mService.initializeMulticastFiltering();
            return true;
        } catch (RemoteException e) {
             return false;
        }
    }
}

