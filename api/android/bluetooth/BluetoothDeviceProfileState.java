/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.bluetooth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.bluetooth.BluetoothAdapter;
import android.os.PowerManager;
import android.server.BluetoothA2dpService;
import android.server.BluetoothService;
import android.util.Log;
import android.util.Pair;

import com.android.internal.util.State;
import com.android.internal.util.StateMachine;

import java.util.Set;

/**
 * This class is the Profile connection state machine associated with a remote
 * device. When the device bonds an instance of this class is created.
 * This tracks incoming and outgoing connections of all the profiles. Incoming
 * connections are preferred over outgoing connections and HFP preferred over
 * A2DP. When the device is unbonded, the instance is removed.
 *
 * States:
 * {@link BondedDevice}: This state represents a bonded device. When in this
 * state none of the profiles are in transition states.
 *
 * {@link OutgoingHandsfree}: Handsfree profile connection is in a transition
 * state because of a outgoing Connect or Disconnect.
 *
 * {@link IncomingHandsfree}: Handsfree profile connection is in a transition
 * state because of a incoming Connect or Disconnect.
 *
 * {@link IncomingA2dp}: A2dp profile connection is in a transition
 * state because of a incoming Connect or Disconnect.
 *
 * {@link OutgoingA2dp}: A2dp profile connection is in a transition
 * state because of a outgoing Connect or Disconnect.
 *
 * Todo(): Write tests for this class, when the Android Mock support is completed.
 * @hide
 */
public final class BluetoothDeviceProfileState extends StateMachine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.184 -0400", hash_original_field = "16D072CC23F8A76AB905B91F962501AC", hash_generated_field = "352619152438F11B0E6E0D7EAFB9BB3E")

    private static final String TAG = "BluetoothDeviceProfileState";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.187 -0400", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.190 -0400", hash_original_field = "F55205A5AAD5795DF9F220396417234D", hash_generated_field = "9323CF5E25BB69380BB03168CD563393")

    public static final int CONNECT_HFP_OUTGOING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.195 -0400", hash_original_field = "4B7323482CF9593AED21D5C1110DB122", hash_generated_field = "DB27D00CF4DDB35523190CF568F73025")

    public static final int CONNECT_HFP_INCOMING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.199 -0400", hash_original_field = "6899D8CDA97707C02766BBADC21FE778", hash_generated_field = "8100224FECEE3CEC9A22555EEC102D76")

    public static final int CONNECT_A2DP_OUTGOING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.202 -0400", hash_original_field = "3DF9084E1C2C4A1802474622D521ADF8", hash_generated_field = "FAE08661BA4CE7BF8BC3EF295515E466")

    public static final int CONNECT_A2DP_INCOMING = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.205 -0400", hash_original_field = "55F63F4FC01F4011F4F7534FD413B052", hash_generated_field = "44917DDE79F4771139BB03D64E0F912B")

    public static final int CONNECT_HID_OUTGOING = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.208 -0400", hash_original_field = "ADE2A908BA729FABCFCAE266532E1602", hash_generated_field = "80C813B0129EAAEF59A67DBA334F71FC")

    public static final int CONNECT_HID_INCOMING = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.212 -0400", hash_original_field = "77AFD9249CDC3E77EA514955DCC0C0E1", hash_generated_field = "10F2613A09F34CB4AF417CFE30C2BA5C")

    public static final int DISCONNECT_HFP_OUTGOING = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.215 -0400", hash_original_field = "649DFBE6A7412FC63783AE2D9DDB16CA", hash_generated_field = "731993E63A95D40FAA1E1AC8FF32D9A8")

    private static final int DISCONNECT_HFP_INCOMING = 51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.218 -0400", hash_original_field = "39DF7F50DEF992F78DF075D693F4E499", hash_generated_field = "1787356413E750DFC6BB6F0274421ACA")

    public static final int DISCONNECT_A2DP_OUTGOING = 52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.222 -0400", hash_original_field = "A78215D183ED020E0EC32EDC47722B9B", hash_generated_field = "7EE807401AE879CEE7B6C34780B77013")

    public static final int DISCONNECT_A2DP_INCOMING = 53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.225 -0400", hash_original_field = "1A7AC5988A2C9017AB74C4DB0B4C59A4", hash_generated_field = "861190AA816D4CF99EF1EFEF85784024")

    public static final int DISCONNECT_HID_OUTGOING = 54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.228 -0400", hash_original_field = "887A749630410D3D2C48077E02D0A69E", hash_generated_field = "C372C5F1784A59DA566178B29D98192C")

    public static final int DISCONNECT_HID_INCOMING = 55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.231 -0400", hash_original_field = "C744046E099FE232212F2C81FD0984D2", hash_generated_field = "7949FC4F24F3030D7594595C4A233E5B")

    public static final int DISCONNECT_PBAP_OUTGOING = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.235 -0400", hash_original_field = "210B3F1DB356B4F48006EBB5E1F2BFED", hash_generated_field = "F5FC3340F935DFAEFF588895DEE97D0F")

    public static final int UNPAIR = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.239 -0400", hash_original_field = "0D211D77297EB694C009ADD2B6FE1E71", hash_generated_field = "09E0D578719FB7E4C0E02411549B6B90")

    public static final int AUTO_CONNECT_PROFILES = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.243 -0400", hash_original_field = "806E36A421679FE7613B907D2316F357", hash_generated_field = "8DACFAFC2D694D66518A46173ECC14D5")

    public static final int TRANSITION_TO_STABLE = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.246 -0400", hash_original_field = "BC510571ADEC3339E6016F67E5FA2F2C", hash_generated_field = "14305D70B23D26DE77E2D4D0001CDC26")

    public static final int CONNECT_OTHER_PROFILES = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.249 -0400", hash_original_field = "7C4A5C51A3CC63906470B775A4BE1FED", hash_generated_field = "12F37207DECC23B934F113D390926CA9")

    private static final int CONNECTION_ACCESS_REQUEST_REPLY = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.252 -0400", hash_original_field = "9EFC69A89BCA809AB4922069F97EDF06", hash_generated_field = "D2C668C94DAEB6DB96518302FF602F36")

    private static final int CONNECTION_ACCESS_REQUEST_EXPIRY = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.256 -0400", hash_original_field = "9E4A63EAFECE8974E78D34CA43AD3707", hash_generated_field = "8BFEBF0452D88AAAD1C89AF43EE55B4C")

    public static final int CONNECT_OTHER_PROFILES_DELAY = 4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.259 -0400", hash_original_field = "B605CAC5DF3F082C7D4234CFFD97B36D", hash_generated_field = "C66C269C9B9C85660913253331AD536A")

    private static final int CONNECTION_ACCESS_REQUEST_EXPIRY_TIMEOUT = 7000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.262 -0400", hash_original_field = "425931D3B9E845FD95E23780918D67FF", hash_generated_field = "66563681D71CEE47289DC4C7F37B08B7")

    private static final int CONNECTION_ACCESS_UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.266 -0400", hash_original_field = "7FF92B9DF2BCB30B4BFB1ACA4D627799", hash_generated_field = "23E6625141A7D9855F450BF43D23B4F3")

    private static final long INIT_INCOMING_REJECT_TIMER = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.270 -0400", hash_original_field = "454AC59F82FE6E4D134582F9952B185F", hash_generated_field = "45DBBAD97C420B459D61DFA171C06BA2")

    private static final long MAX_INCOMING_REJECT_TIMER = 3600 * 1000 * 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.273 -0400", hash_original_field = "B0573C9FFAC5920B3F70D357C265520F", hash_generated_field = "A0F098EDD1001670315162D339E3D702")

    private static final String ACCESS_AUTHORITY_PACKAGE = "com.android.settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.276 -0400", hash_original_field = "4A04F613287255A28195D5C46D84B0D3", hash_generated_field = "A6967B6666D02BD7992DC90A06C28391")

    private static final String ACCESS_AUTHORITY_CLASS =
        "com.android.settings.bluetooth.BluetoothPermissionRequest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.326 -0400", hash_original_field = "4DF5D31E376F27F1ED153009F2B9E52D", hash_generated_field = "A458E8B2DE444E0F35989DFD935DFB5E")

    private static final String BLUETOOTH_ADMIN_PERM = android.Manifest.permission.BLUETOOTH_ADMIN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.279 -0400", hash_original_field = "76A711C1D6E10D897DBF89DCCC4F22EA", hash_generated_field = "F95EB0CD58FF772FD7C2302889E33FB5")

    private BondedDevice mBondedDevice = new BondedDevice();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.281 -0400", hash_original_field = "B879780AF2A21177781FEBF5E13B2C85", hash_generated_field = "6C9219221E5AEE1FA83A71796D9BE408")

    private OutgoingHandsfree mOutgoingHandsfree = new OutgoingHandsfree();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.285 -0400", hash_original_field = "98AF925C51C57DF38B9F4205880D9548", hash_generated_field = "809E27FAC2118E8F89D0B0ED21BE2254")

    private IncomingHandsfree mIncomingHandsfree = new IncomingHandsfree();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.287 -0400", hash_original_field = "51B1E70B3E0D3E34F08BBA8052C442B0", hash_generated_field = "19D8FA56859025BD2CAFA7DB4B77F0A6")

    private IncomingA2dp mIncomingA2dp = new IncomingA2dp();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.291 -0400", hash_original_field = "7114828BB2E8D7338DCCC2EFCA7897E4", hash_generated_field = "068FABB545C7C126562427DDAE74B005")

    private OutgoingA2dp mOutgoingA2dp = new OutgoingA2dp();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.294 -0400", hash_original_field = "F82595970D21D336BC5120425D29DF58", hash_generated_field = "3E75C7D6E41EC17B5EDAEB758A4AE917")

    private OutgoingHid mOutgoingHid = new OutgoingHid();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.297 -0400", hash_original_field = "23A40562DBA44448AC01B59F3D5A7C7F", hash_generated_field = "83C64D10DE5D1F5F08F777717318E749")

    private IncomingHid mIncomingHid = new IncomingHid();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.299 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.302 -0400", hash_original_field = "F41AE71D622FDCA6BB622192685F5E5F", hash_generated_field = "595579B9977CA2238E14150EEB2A2C75")

    private BluetoothService mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.305 -0400", hash_original_field = "B5BD79CF80C7A45A3C622D6A1147302E", hash_generated_field = "21F689A0EBD699248DAD2BA6FCD0BC59")

    private BluetoothA2dpService mA2dpService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.307 -0400", hash_original_field = "8CB23415134FD9310A0D3C5965C8FBBB", hash_generated_field = "1EE56908A5916914150FF10716D3B52D")

    private BluetoothHeadset  mHeadsetService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.310 -0400", hash_original_field = "065D128D0FC75CAA5C358891D3D07B7B", hash_generated_field = "BA3D5E206E9348167295F8CADA1116EE")

    private BluetoothPbap     mPbapService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.314 -0400", hash_original_field = "D547438FA97A2C500CC00BCBA032017C", hash_generated_field = "E9E83C193E63F4BC52060B62EFE2E54F")

    private PbapServiceListener mPbap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.317 -0400", hash_original_field = "367F0BC6BC216C571A7E906A286477DF", hash_generated_field = "6EAF57CC559AB78B0231BFFF469261B9")

    private BluetoothAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.320 -0400", hash_original_field = "695CA30C0431C39950EC9C08AF3865A6", hash_generated_field = "FA340CB891AF823EB2E84B701DAB5981")

    private boolean mPbapServiceConnected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.322 -0400", hash_original_field = "BB9B5DB79A678E7D3CB4CC516EDDB054", hash_generated_field = "B122F72A6A4F483614D2776F8A6CBCB2")

    private boolean mAutoConnectionPending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.329 -0400", hash_original_field = "793253818BA6C7B0BA0EE44002B9EC24", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

    private BluetoothDevice mDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.331 -0400", hash_original_field = "51B2A75250C391DB4F23E9B102133C08", hash_generated_field = "04607C6F7F56BE935F2BF060E49E7458")

    private int mHeadsetState = BluetoothProfile.STATE_DISCONNECTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.334 -0400", hash_original_field = "078FF0C881DAE6799549FD33891E1E0C", hash_generated_field = "DAA67C8C1A587262E105E683428D56D1")

    private int mA2dpState = BluetoothProfile.STATE_DISCONNECTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.337 -0400", hash_original_field = "3888383F2131126E7C04466E1A5D4BE1", hash_generated_field = "6375F44150E400BFD5D477008A8670A9")

    private long mIncomingRejectTimer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.341 -0400", hash_original_field = "C823BEC20985960F6E45FC26430F7F26", hash_generated_field = "C55625EE51305E755CAA793C9B9CD4E5")

    private boolean mConnectionAccessReplyReceived = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.343 -0400", hash_original_field = "7CDE3C34F55C10AE42FF4A94E8A4B7AE", hash_generated_field = "08D577B1DA138A2B9130B3D326AE6BD3")

    private Pair<Integer, String> mIncomingConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.346 -0400", hash_original_field = "87068C2348540A5517D7F6F40E0F6E43", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.349 -0400", hash_original_field = "AE9C7C49DB568DF15B12F481B3602630", hash_generated_field = "C0ABFDE975E218E90A8E9AECD9B1F45A")

    private PowerManager mPowerManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.352 -0400", hash_original_field = "E473802201F7009D9DDC944BF9C6BD70", hash_generated_field = "DE06F1611C347EF9C423D0143D668006")

    private boolean mPairingRequestRcvd = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.362 -0400", hash_original_field = "D34D5C82B07BF3635A0932C5C5412256", hash_generated_field = "0B0C487DE2F9DF00ADD779CD888DCC1A")

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:14.246 -0400", hash_original_method = "68502EFA9DC722C0870F4958CDF61986", hash_generated_method = "D60BBAABDA4DB7790270A9890FAB305C")
        
@Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (device == null || !device.equals(mDevice)) return;

            if (action.equals(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED)) {
                int newState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, 0);
                int oldState = intent.getIntExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, 0);
                // We trust this device now
                if (newState == BluetoothHeadset.STATE_CONNECTED) {
                    setTrust(BluetoothDevice.CONNECTION_ACCESS_YES);
                }
                mA2dpState = newState;
                if (oldState == BluetoothA2dp.STATE_CONNECTED &&
                    newState == BluetoothA2dp.STATE_DISCONNECTED) {
                    sendMessage(DISCONNECT_A2DP_INCOMING);
                }
                if (newState == BluetoothProfile.STATE_CONNECTED ||
                    newState == BluetoothProfile.STATE_DISCONNECTED) {
                    sendMessage(TRANSITION_TO_STABLE);
                }
            } else if (action.equals(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED)) {
                int newState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, 0);
                int oldState = intent.getIntExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, 0);
                // We trust this device now
                if (newState == BluetoothHeadset.STATE_CONNECTED) {
                    setTrust(BluetoothDevice.CONNECTION_ACCESS_YES);
                }
                mHeadsetState = newState;
                if (oldState == BluetoothHeadset.STATE_CONNECTED &&
                    newState == BluetoothHeadset.STATE_DISCONNECTED) {
                    sendMessage(DISCONNECT_HFP_INCOMING);
                }
                if (newState == BluetoothProfile.STATE_CONNECTED ||
                    newState == BluetoothProfile.STATE_DISCONNECTED) {
                    sendMessage(TRANSITION_TO_STABLE);
                }
            } else if (action.equals(BluetoothInputDevice.ACTION_CONNECTION_STATE_CHANGED)) {
                int newState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, 0);
                int oldState =
                    intent.getIntExtra(BluetoothProfile.EXTRA_PREVIOUS_STATE, 0);
                // We trust this device now
                if (newState == BluetoothHeadset.STATE_CONNECTED) {
                    setTrust(BluetoothDevice.CONNECTION_ACCESS_YES);
                }
                if (oldState == BluetoothProfile.STATE_CONNECTED &&
                    newState == BluetoothProfile.STATE_DISCONNECTED) {
                    sendMessage(DISCONNECT_HID_INCOMING);
                }
                if (newState == BluetoothProfile.STATE_CONNECTED ||
                    newState == BluetoothProfile.STATE_DISCONNECTED) {
                    sendMessage(TRANSITION_TO_STABLE);
                }
            } else if (action.equals(BluetoothDevice.ACTION_ACL_DISCONNECTED)) {
                // This is technically not needed, but we can get stuck sometimes.
                // For example, if incoming A2DP fails, we are not informed by Bluez
                sendMessage(TRANSITION_TO_STABLE);
            } else if (action.equals(BluetoothDevice.ACTION_CONNECTION_ACCESS_REPLY)) {
                mWakeLock.release();
                int val = intent.getIntExtra(BluetoothDevice.EXTRA_CONNECTION_ACCESS_RESULT,
                                             BluetoothDevice.CONNECTION_ACCESS_NO);
                Message msg = obtainMessage(CONNECTION_ACCESS_REQUEST_REPLY);
                msg.arg1 = val;
                sendMessage(msg);
            } else if (action.equals(BluetoothDevice.ACTION_PAIRING_REQUEST)) {
                mPairingRequestRcvd = true;
            } else if (action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)) {
                int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE,
                        BluetoothDevice.ERROR);
                if (state == BluetoothDevice.BOND_BONDED && mPairingRequestRcvd) {
                    setTrust(BluetoothDevice.CONNECTION_ACCESS_YES);
                    mPairingRequestRcvd = false;
                } else if (state == BluetoothDevice.BOND_NONE) {
                    mPairingRequestRcvd = false;
                }
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.379 -0400", hash_original_field = "CFC11DA48D71FF5891CD95ECDBC9993F", hash_generated_field = "019AD8F116682EA36D010B17F5792A83")

    private BluetoothProfile.ServiceListener mBluetoothProfileServiceListener =
        new BluetoothProfile.ServiceListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:14.261 -0400", hash_original_method = "EC5B2D2B1234ED3BB90F13463938E49B", hash_generated_method = "5CAB5AAB9628894CE09D91F42BCDB158")
        
public void onServiceConnected(int profile, BluetoothProfile proxy) {
            synchronized(BluetoothDeviceProfileState.this) {
                mHeadsetService = (BluetoothHeadset) proxy;
                if (mAutoConnectionPending) {
                    sendMessage(AUTO_CONNECT_PROFILES);
                    mAutoConnectionPending = false;
                }
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:14.264 -0400", hash_original_method = "6F896B2BC65B96C7E3DEBF6D6C2A1678", hash_generated_method = "5974E538723CBF15F64FD6D790208504")
        
public void onServiceDisconnected(int profile) {
            synchronized(BluetoothDeviceProfileState.this) {
                mHeadsetService = null;
            }
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.369 -0400", hash_original_method = "29B9E9C225CBEBEE972B10033F9FDF53", hash_generated_method = "AB058DC1C96F9B25DF825C2460759CF4")
    
public BluetoothDeviceProfileState(Context context, String address,
          BluetoothService service, BluetoothA2dpService a2dpService, boolean setTrust) {
        super(address);
        mContext = context;
        mDevice = new BluetoothDevice(address);
        mService = service;
        mA2dpService = a2dpService;

        addState(mBondedDevice);
        addState(mOutgoingHandsfree);
        addState(mIncomingHandsfree);
        addState(mIncomingA2dp);
        addState(mOutgoingA2dp);
        addState(mOutgoingHid);
        addState(mIncomingHid);
        setInitialState(mBondedDevice);

        IntentFilter filter = new IntentFilter();
        // Fine-grained state broadcasts
        filter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        filter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED);
        filter.addAction(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
        filter.addAction(BluetoothInputDevice.ACTION_CONNECTION_STATE_CHANGED);
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        filter.addAction(BluetoothDevice.ACTION_CONNECTION_ACCESS_REPLY);
        filter.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);

        mContext.registerReceiver(mBroadcastReceiver, filter);

        mAdapter = BluetoothAdapter.getDefaultAdapter();
        mAdapter.getProfileProxy(mContext, mBluetoothProfileServiceListener,
                                BluetoothProfile.HEADSET);
        // TODO(): Convert PBAP to the new Profile APIs.
        mPbap = new PbapServiceListener();

        mIncomingConnections = mService.getIncomingState(address);
        mIncomingRejectTimer = readTimerValue();
        mPowerManager = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK |
                                              PowerManager.ACQUIRE_CAUSES_WAKEUP |
                                              PowerManager.ON_AFTER_RELEASE, TAG);
        mWakeLock.setReferenceCounted(false);

        if (setTrust) {
            setTrust(BluetoothDevice.CONNECTION_ACCESS_YES);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.365 -0400", hash_original_method = "76A9834C9DCE44B6DB37962982B769A8", hash_generated_method = "2F71DD525EA4DF84CA9C33878BE36C96")
    
private boolean isPhoneDocked(BluetoothDevice autoConnectDevice) {
        // This works only because these broadcast intents are "sticky"
        Intent i = mContext.registerReceiver(null, new IntentFilter(Intent.ACTION_DOCK_EVENT));
        if (i != null) {
            int state = i.getIntExtra(Intent.EXTRA_DOCK_STATE, Intent.EXTRA_DOCK_STATE_UNDOCKED);
            if (state != Intent.EXTRA_DOCK_STATE_UNDOCKED) {
                BluetoothDevice device = i.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device != null && autoConnectDevice.equals(device)) {
                    return true;
                }
            }
        }
        return false;
    }

    private class PbapServiceListener implements BluetoothPbap.ServiceListener {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.383 -0400", hash_original_method = "530973F309EF65278FE085ACD31CC6CC", hash_generated_method = "D1DDEC38A785FBCD2F0DFB1D0C32E682")
        
public PbapServiceListener() {
            mPbapService = new BluetoothPbap(mContext, this);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.386 -0400", hash_original_method = "4A5728C4C5FB114E75EC359695442D04", hash_generated_method = "34BF0A5C4A00E2645B931F249D94C3E0")
        
public void onServiceConnected() {
            synchronized(BluetoothDeviceProfileState.this) {
                mPbapServiceConnected = true;
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.389 -0400", hash_original_method = "CD4B0D1848BF66FA3DCEB477AABCD63E", hash_generated_method = "A7FD39BB41200679C84ECCC367F1CC9C")
        
public void onServiceDisconnected() {
            synchronized(BluetoothDeviceProfileState.this) {
                mPbapServiceConnected = false;
            }
        }
    }

    private class BondedDevice extends State {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.394 -0400", hash_original_method = "1B94331CB40C28C4DD6B31166BF5FBCE", hash_generated_method = "6A5C39D42A7EDEE8519E8A86523B1B8A")
        
@Override
        public void enter() {
            Log.i(TAG, "Entering ACL Connected state with: " + getCurrentMessage().what);
            Message m = new Message();
            m.copyFrom(getCurrentMessage());
            sendMessageAtFrontOfQueue(m);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.399 -0400", hash_original_method = "A5B960F43A9E1B7F6EAD2E019AAE8D4D", hash_generated_method = "683A3968F3D7BC3EC053E6F44D2C1B09")
        
@Override
        public boolean processMessage(Message message) {
            log("ACL Connected State -> Processing Message: " + message.what);
            switch(message.what) {
                case CONNECT_HFP_OUTGOING:
                case DISCONNECT_HFP_OUTGOING:
                    transitionTo(mOutgoingHandsfree);
                    break;
                case CONNECT_HFP_INCOMING:
                    transitionTo(mIncomingHandsfree);
                    break;
                case DISCONNECT_HFP_INCOMING:
                    transitionTo(mIncomingHandsfree);
                    break;
                case CONNECT_A2DP_OUTGOING:
                case DISCONNECT_A2DP_OUTGOING:
                    transitionTo(mOutgoingA2dp);
                    break;
                case CONNECT_A2DP_INCOMING:
                case DISCONNECT_A2DP_INCOMING:
                    transitionTo(mIncomingA2dp);
                    break;
                case CONNECT_HID_OUTGOING:
                case DISCONNECT_HID_OUTGOING:
                    transitionTo(mOutgoingHid);
                    break;
                case CONNECT_HID_INCOMING:
                case DISCONNECT_HID_INCOMING:
                    transitionTo(mIncomingHid);
                    break;
                case DISCONNECT_PBAP_OUTGOING:
                    processCommand(DISCONNECT_PBAP_OUTGOING);
                    break;
                case UNPAIR:
                    if (mHeadsetState != BluetoothHeadset.STATE_DISCONNECTED) {
                        sendMessage(DISCONNECT_HFP_OUTGOING);
                        deferMessage(message);
                        break;
                    } else if (mA2dpState != BluetoothA2dp.STATE_DISCONNECTED) {
                        sendMessage(DISCONNECT_A2DP_OUTGOING);
                        deferMessage(message);
                        break;
                    } else if (mService.getInputDeviceConnectionState(mDevice) !=
                            BluetoothInputDevice.STATE_DISCONNECTED) {
                        sendMessage(DISCONNECT_HID_OUTGOING);
                        deferMessage(message);
                        break;
                    }
                    processCommand(UNPAIR);
                    break;
                case AUTO_CONNECT_PROFILES:
                    if (isPhoneDocked(mDevice)) {
                        // Don't auto connect to docks.
                        break;
                    } else {
                        if (mHeadsetService == null) {
                              mAutoConnectionPending = true;
                        } else if (mHeadsetService.getPriority(mDevice) ==
                              BluetoothHeadset.PRIORITY_AUTO_CONNECT &&
                              mHeadsetService.getDevicesMatchingConnectionStates(
                                  new int[] {BluetoothProfile.STATE_CONNECTED,
                                             BluetoothProfile.STATE_CONNECTING,
                                             BluetoothProfile.STATE_DISCONNECTING}).size() == 0) {
                            mHeadsetService.connect(mDevice);
                        }
                        if (mA2dpService != null &&
                              mA2dpService.getPriority(mDevice) ==
                              BluetoothA2dp.PRIORITY_AUTO_CONNECT &&
                              mA2dpService.getDevicesMatchingConnectionStates(
                                  new int[] {BluetoothA2dp.STATE_CONNECTED,
                                             BluetoothProfile.STATE_CONNECTING,
                                             BluetoothProfile.STATE_DISCONNECTING}).size() == 0) {
                            mA2dpService.connect(mDevice);
                        }
                        if (mService.getInputDevicePriority(mDevice) ==
                              BluetoothInputDevice.PRIORITY_AUTO_CONNECT) {
                            mService.connectInputDevice(mDevice);
                        }
                    }
                    break;
                case CONNECT_OTHER_PROFILES:
                    if (isPhoneDocked(mDevice)) {
                       break;
                    }
                    if (message.arg1 == CONNECT_A2DP_OUTGOING) {
                        if (mA2dpService != null &&
                            mA2dpService.getConnectedDevices().size() == 0) {
                            Log.i(TAG, "A2dp:Connect Other Profiles");
                            mA2dpService.connect(mDevice);
                        }
                    } else if (message.arg1 == CONNECT_HFP_OUTGOING) {
                        if (mHeadsetService == null) {
                            deferMessage(message);
                        } else {
                            if (mHeadsetService.getConnectedDevices().size() == 0) {
                                Log.i(TAG, "Headset:Connect Other Profiles");
                                mHeadsetService.connect(mDevice);
                            }
                        }
                    }
                    break;
                case TRANSITION_TO_STABLE:
                    // ignore.
                    break;
                case SM_QUIT_CMD:
                    mContext.unregisterReceiver(mBroadcastReceiver);
                    mBroadcastReceiver = null;
                    mAdapter.closeProfileProxy(BluetoothProfile.HEADSET, mHeadsetService);
                    mBluetoothProfileServiceListener = null;
                    mOutgoingHandsfree = null;
                    mPbap = null;
                    mPbapService.close();
                    mPbapService = null;
                    mIncomingHid = null;
                    mOutgoingHid = null;
                    mIncomingHandsfree = null;
                    mOutgoingHandsfree = null;
                    mIncomingA2dp = null;
                    mOutgoingA2dp = null;
                    mBondedDevice = null;
                    // There is a problem in the State Machine code
                    // where things are not cleaned up properly, when quit message
                    // is handled so return NOT_HANDLED as a workaround.
                    return NOT_HANDLED;
                default:
                    return NOT_HANDLED;
            }
            return HANDLED;
        }
    }

    private class OutgoingHandsfree extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.406 -0400", hash_original_field = "3FAE308DA947D3D413A8D279D3D753BF", hash_generated_field = "3A218CE6B4AD3ADBEE0C2B1F8DC6D76B")

        private boolean mStatus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.410 -0400", hash_original_field = "2F175E88AE074D5006E1484402CDDE3D", hash_generated_field = "7E474BB103E3D6468E4A1624A89441E7")

        private int mCommand;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.413 -0400", hash_original_method = "4408D1BC541FE9F30A13EA273326DBE5", hash_generated_method = "CCF58F88137D2366BF4F0C5C566FAAA1")
        
@Override
        public void enter() {
            Log.i(TAG, "Entering OutgoingHandsfree state with: " + getCurrentMessage().what);
            mCommand = getCurrentMessage().what;
            if (mCommand != CONNECT_HFP_OUTGOING &&
                mCommand != DISCONNECT_HFP_OUTGOING) {
                Log.e(TAG, "Error: OutgoingHandsfree state with command:" + mCommand);
            }
            mStatus = processCommand(mCommand);
            if (!mStatus) {
                sendMessage(TRANSITION_TO_STABLE);
                mService.sendProfileStateMessage(BluetoothProfileState.HFP,
                                                 BluetoothProfileState.TRANSITION_TO_STABLE);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.418 -0400", hash_original_method = "141DDC9B324B36CCCCEDFC185D3484E4", hash_generated_method = "BB6DB68D0972067913F476C713B7F2E7")
        
@Override
        public boolean processMessage(Message message) {
            log("OutgoingHandsfree State -> Processing Message: " + message.what);
            Message deferMsg = new Message();
            int command = message.what;
            switch(command) {
                case CONNECT_HFP_OUTGOING:
                    if (command != mCommand) {
                        // Disconnect followed by a connect - defer
                        deferMessage(message);
                    }
                    break;
                case CONNECT_HFP_INCOMING:
                    if (mCommand == CONNECT_HFP_OUTGOING) {
                        // Cancel outgoing connect, accept incoming
                        cancelCommand(CONNECT_HFP_OUTGOING);
                        transitionTo(mIncomingHandsfree);
                    } else {
                        // We have done the disconnect but we are not
                        // sure which state we are in at this point.
                        deferMessage(message);
                    }
                    break;
                case CONNECT_A2DP_INCOMING:
                    // accept incoming A2DP, retry HFP_OUTGOING
                    transitionTo(mIncomingA2dp);

                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case CONNECT_A2DP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_HFP_OUTGOING:
                    if (mCommand == CONNECT_HFP_OUTGOING) {
                        // Cancel outgoing connect
                        cancelCommand(CONNECT_HFP_OUTGOING);
                        processCommand(DISCONNECT_HFP_OUTGOING);
                    }
                    // else ignore
                    break;
                case DISCONNECT_HFP_INCOMING:
                    // When this happens the socket would be closed and the headset
                    // state moved to DISCONNECTED, cancel the outgoing thread.
                    // if it still is in CONNECTING state
                    cancelCommand(CONNECT_HFP_OUTGOING);
                    break;
                case DISCONNECT_A2DP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_A2DP_INCOMING:
                    // Bluez will handle the disconnect. If because of this the outgoing
                    // handsfree connection has failed, then retry.
                    if (mStatus) {
                       deferMsg.what = mCommand;
                       deferMessage(deferMsg);
                    }
                    break;
                case CONNECT_HID_OUTGOING:
                case DISCONNECT_HID_OUTGOING:
                    deferMessage(message);
                    break;
                case CONNECT_HID_INCOMING:
                    transitionTo(mIncomingHid);
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case DISCONNECT_HID_INCOMING:
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break; // ignore
                case DISCONNECT_PBAP_OUTGOING:
                case UNPAIR:
                case AUTO_CONNECT_PROFILES:
                case CONNECT_OTHER_PROFILES:
                    deferMessage(message);
                    break;
                case TRANSITION_TO_STABLE:
                    transitionTo(mBondedDevice);
                    break;
                default:
                    return NOT_HANDLED;
            }
            return HANDLED;
        }
    }

    private class IncomingHandsfree extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.424 -0400", hash_original_field = "3FAE308DA947D3D413A8D279D3D753BF", hash_generated_field = "3A218CE6B4AD3ADBEE0C2B1F8DC6D76B")

        private boolean mStatus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.427 -0400", hash_original_field = "2F175E88AE074D5006E1484402CDDE3D", hash_generated_field = "7E474BB103E3D6468E4A1624A89441E7")

        private int mCommand;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.430 -0400", hash_original_method = "0B147DF7E07D14924F5FD0358164D799", hash_generated_method = "E40BBD98FCC8BAA8A7226115F370EF6C")
        
@Override
        public void enter() {
            Log.i(TAG, "Entering IncomingHandsfree state with: " + getCurrentMessage().what);
            mCommand = getCurrentMessage().what;
            if (mCommand != CONNECT_HFP_INCOMING &&
                mCommand != DISCONNECT_HFP_INCOMING) {
                Log.e(TAG, "Error: IncomingHandsfree state with command:" + mCommand);
            }
            mStatus = processCommand(mCommand);
            if (!mStatus) {
                sendMessage(TRANSITION_TO_STABLE);
                mService.sendProfileStateMessage(BluetoothProfileState.HFP,
                                                 BluetoothProfileState.TRANSITION_TO_STABLE);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.434 -0400", hash_original_method = "292CB95BA18BF21B16DFF1ED647458AC", hash_generated_method = "5593AA8482679A0F5578C527D152F783")
        
@Override
        public boolean processMessage(Message message) {
            log("IncomingHandsfree State -> Processing Message: " + message.what);
            switch(message.what) {
                case CONNECT_HFP_OUTGOING:
                    deferMessage(message);
                    break;
                case CONNECT_HFP_INCOMING:
                    // Ignore
                    Log.e(TAG, "Error: Incoming connection with a pending incoming connection");
                    break;
                case CONNECTION_ACCESS_REQUEST_REPLY:
                    int val = message.arg1;
                    mConnectionAccessReplyReceived = true;
                    boolean value = false;
                    if (val == BluetoothDevice.CONNECTION_ACCESS_YES) {
                        value = true;
                    }
                    setTrust(val);

                    handleIncomingConnection(CONNECT_HFP_INCOMING, value);
                    break;
                case CONNECTION_ACCESS_REQUEST_EXPIRY:
                    if (!mConnectionAccessReplyReceived) {
                        handleIncomingConnection(CONNECT_HFP_INCOMING, false);
                        sendConnectionAccessRemovalIntent();
                        sendMessage(TRANSITION_TO_STABLE);
                    }
                    break;
                case CONNECT_A2DP_INCOMING:
                    // Serialize the commands.
                    deferMessage(message);
                    break;
                case CONNECT_A2DP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_HFP_OUTGOING:
                    // We don't know at what state we are in the incoming HFP connection state.
                    // We can be changing from DISCONNECTED to CONNECTING, or
                    // from CONNECTING to CONNECTED, so serializing this command is
                    // the safest option.
                    deferMessage(message);
                    break;
                case DISCONNECT_HFP_INCOMING:
                    // Nothing to do here, we will already be DISCONNECTED
                    // by this point.
                    break;
                case DISCONNECT_A2DP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_A2DP_INCOMING:
                    // Bluez handles incoming A2DP disconnect.
                    // If this causes incoming HFP to fail, it is more of a headset problem
                    // since both connections are incoming ones.
                    break;
                case CONNECT_HID_OUTGOING:
                case DISCONNECT_HID_OUTGOING:
                    deferMessage(message);
                    break;
                case CONNECT_HID_INCOMING:
                case DISCONNECT_HID_INCOMING:
                     break; // ignore
                case DISCONNECT_PBAP_OUTGOING:
                case UNPAIR:
                case AUTO_CONNECT_PROFILES:
                case CONNECT_OTHER_PROFILES:
                    deferMessage(message);
                    break;
                case TRANSITION_TO_STABLE:
                    transitionTo(mBondedDevice);
                    break;
                default:
                    return NOT_HANDLED;
            }
            return HANDLED;
        }
    }

    private class OutgoingA2dp extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.441 -0400", hash_original_field = "3FAE308DA947D3D413A8D279D3D753BF", hash_generated_field = "3A218CE6B4AD3ADBEE0C2B1F8DC6D76B")

        private boolean mStatus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.444 -0400", hash_original_field = "2F175E88AE074D5006E1484402CDDE3D", hash_generated_field = "7E474BB103E3D6468E4A1624A89441E7")

        private int mCommand;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.447 -0400", hash_original_method = "4295CF0F0CB23263A00B4320F28BCA19", hash_generated_method = "110F4EB78863D287DA5282D1BCBDEFCB")
        
@Override
        public void enter() {
            Log.i(TAG, "Entering OutgoingA2dp state with: " + getCurrentMessage().what);
            mCommand = getCurrentMessage().what;
            if (mCommand != CONNECT_A2DP_OUTGOING &&
                mCommand != DISCONNECT_A2DP_OUTGOING) {
                Log.e(TAG, "Error: OutgoingA2DP state with command:" + mCommand);
            }
            mStatus = processCommand(mCommand);
            if (!mStatus) {
                sendMessage(TRANSITION_TO_STABLE);
                mService.sendProfileStateMessage(BluetoothProfileState.A2DP,
                                                 BluetoothProfileState.TRANSITION_TO_STABLE);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.451 -0400", hash_original_method = "BC5FD2BC812548AED72459BFA65AAF49", hash_generated_method = "EF38F108EB33D0A175F0F614796B98AB")
        
@Override
        public boolean processMessage(Message message) {
            log("OutgoingA2dp State->Processing Message: " + message.what);
            Message deferMsg = new Message();
            switch(message.what) {
                case CONNECT_HFP_OUTGOING:
                    processCommand(CONNECT_HFP_OUTGOING);

                    // Don't cancel A2DP outgoing as there is no guarantee it
                    // will get canceled.
                    // It might already be connected but we might not have got the
                    // A2DP_SINK_STATE_CHANGE. Hence, no point disconnecting here.
                    // The worst case, the connection will fail, retry.
                    // The same applies to Disconnecting an A2DP connection.
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case CONNECT_HFP_INCOMING:
                    processCommand(CONNECT_HFP_INCOMING);

                    // Don't cancel A2DP outgoing as there is no guarantee
                    // it will get canceled.
                    // The worst case, the connection will fail, retry.
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case CONNECT_A2DP_INCOMING:
                    // Bluez will take care of conflicts between incoming and outgoing
                    // connections.
                    transitionTo(mIncomingA2dp);
                    break;
                case CONNECT_A2DP_OUTGOING:
                    // Ignore
                    break;
                case DISCONNECT_HFP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_HFP_INCOMING:
                    // At this point, we are already disconnected
                    // with HFP. Sometimes A2DP connection can
                    // fail due to the disconnection of HFP. So add a retry
                    // for the A2DP.
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case DISCONNECT_A2DP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_A2DP_INCOMING:
                    // Ignore, will be handled by Bluez
                    break;
                case CONNECT_HID_OUTGOING:
                case DISCONNECT_HID_OUTGOING:
                    deferMessage(message);
                    break;
                case CONNECT_HID_INCOMING:
                    transitionTo(mIncomingHid);
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case DISCONNECT_HID_INCOMING:
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break; // ignore
                case DISCONNECT_PBAP_OUTGOING:
                case UNPAIR:
                case AUTO_CONNECT_PROFILES:
                case CONNECT_OTHER_PROFILES:
                    deferMessage(message);
                    break;
                case TRANSITION_TO_STABLE:
                    transitionTo(mBondedDevice);
                    break;
                default:
                    return NOT_HANDLED;
            }
            return HANDLED;
        }
    }

    private class IncomingA2dp extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.458 -0400", hash_original_field = "3FAE308DA947D3D413A8D279D3D753BF", hash_generated_field = "3A218CE6B4AD3ADBEE0C2B1F8DC6D76B")

        private boolean mStatus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.460 -0400", hash_original_field = "2F175E88AE074D5006E1484402CDDE3D", hash_generated_field = "7E474BB103E3D6468E4A1624A89441E7")

        private int mCommand;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.464 -0400", hash_original_method = "A299281F20DF8C2E3B2EEAF783F0F14D", hash_generated_method = "F990C9BA51A5E9B96933EFEBF05C06C2")
        
@Override
        public void enter() {
            Log.i(TAG, "Entering IncomingA2dp state with: " + getCurrentMessage().what);
            mCommand = getCurrentMessage().what;
            if (mCommand != CONNECT_A2DP_INCOMING &&
                mCommand != DISCONNECT_A2DP_INCOMING) {
                Log.e(TAG, "Error: IncomingA2DP state with command:" + mCommand);
            }
            mStatus = processCommand(mCommand);
            if (!mStatus) {
                sendMessage(TRANSITION_TO_STABLE);
                mService.sendProfileStateMessage(BluetoothProfileState.A2DP,
                                                 BluetoothProfileState.TRANSITION_TO_STABLE);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.468 -0400", hash_original_method = "333D844CC3AB67E9464AEEB662D62AD1", hash_generated_method = "D75DC75AD6018891B54A096B6AAE889F")
        
@Override
        public boolean processMessage(Message message) {
            log("IncomingA2dp State->Processing Message: " + message.what);
            switch(message.what) {
                case CONNECT_HFP_OUTGOING:
                    deferMessage(message);
                    break;
                case CONNECT_HFP_INCOMING:
                    // Shouldn't happen, but serialize the commands.
                    deferMessage(message);
                    break;
                case CONNECT_A2DP_INCOMING:
                    // ignore
                    break;
                case CONNECTION_ACCESS_REQUEST_REPLY:
                    int val = message.arg1;
                    mConnectionAccessReplyReceived = true;
                    boolean value = false;
                    if (val == BluetoothDevice.CONNECTION_ACCESS_YES) {
                        value = true;
                    }
                    setTrust(val);
                    handleIncomingConnection(CONNECT_A2DP_INCOMING, value);
                    break;
                case CONNECTION_ACCESS_REQUEST_EXPIRY:
                    // The check protects the race condition between REQUEST_REPLY
                    // and the timer expiry.
                    if (!mConnectionAccessReplyReceived) {
                        handleIncomingConnection(CONNECT_A2DP_INCOMING, false);
                        sendConnectionAccessRemovalIntent();
                        sendMessage(TRANSITION_TO_STABLE);
                    }
                    break;
                case CONNECT_A2DP_OUTGOING:
                    // Defer message and retry
                    deferMessage(message);
                    break;
                case DISCONNECT_HFP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_HFP_INCOMING:
                    // Shouldn't happen but if does, we can handle it.
                    // Depends if the headset can handle it.
                    // Incoming A2DP will be handled by Bluez, Disconnect HFP
                    // the socket would have already been closed.
                    // ignore
                    break;
                case DISCONNECT_A2DP_OUTGOING:
                    deferMessage(message);
                    break;
                case DISCONNECT_A2DP_INCOMING:
                    // Ignore, will be handled by Bluez
                    break;
                case CONNECT_HID_OUTGOING:
                case DISCONNECT_HID_OUTGOING:
                    deferMessage(message);
                    break;
                case CONNECT_HID_INCOMING:
                case DISCONNECT_HID_INCOMING:
                     break; // ignore
                case DISCONNECT_PBAP_OUTGOING:
                case UNPAIR:
                case AUTO_CONNECT_PROFILES:
                case CONNECT_OTHER_PROFILES:
                    deferMessage(message);
                    break;
                case TRANSITION_TO_STABLE:
                    transitionTo(mBondedDevice);
                    break;
                default:
                    return NOT_HANDLED;
            }
            return HANDLED;
        }
    }

    private class OutgoingHid extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.475 -0400", hash_original_field = "3FAE308DA947D3D413A8D279D3D753BF", hash_generated_field = "3A218CE6B4AD3ADBEE0C2B1F8DC6D76B")

        private boolean mStatus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.478 -0400", hash_original_field = "2F175E88AE074D5006E1484402CDDE3D", hash_generated_field = "7E474BB103E3D6468E4A1624A89441E7")

        private int mCommand;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.481 -0400", hash_original_method = "0C1F3B6CE638BB43A1364523CC24BAD6", hash_generated_method = "B68DB350C7D0DDC6DBCFDD6030AB841B")
        
@Override
        public void enter() {
            log("Entering OutgoingHid state with: " + getCurrentMessage().what);
            mCommand = getCurrentMessage().what;
            if (mCommand != CONNECT_HID_OUTGOING &&
                mCommand != DISCONNECT_HID_OUTGOING) {
                Log.e(TAG, "Error: OutgoingHid state with command:" + mCommand);
            }
            mStatus = processCommand(mCommand);
            if (!mStatus) sendMessage(TRANSITION_TO_STABLE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.485 -0400", hash_original_method = "B70D83C64C5EFF1089615EFD6CDC27BC", hash_generated_method = "83F1250650B942CA9A70B7F09E0988CA")
        
@Override
        public boolean processMessage(Message message) {
            log("OutgoingHid State->Processing Message: " + message.what);
            Message deferMsg = new Message();
            switch(message.what) {
                // defer all outgoing messages
                case CONNECT_HFP_OUTGOING:
                case CONNECT_A2DP_OUTGOING:
                case CONNECT_HID_OUTGOING:
                case DISCONNECT_HFP_OUTGOING:
                case DISCONNECT_A2DP_OUTGOING:
                case DISCONNECT_HID_OUTGOING:
                    deferMessage(message);
                    break;

                case CONNECT_HFP_INCOMING:
                    transitionTo(mIncomingHandsfree);
                    break;
                case CONNECT_A2DP_INCOMING:
                    transitionTo(mIncomingA2dp);

                    // Don't cancel HID outgoing as there is no guarantee it
                    // will get canceled.
                    // It might already be connected but we might not have got the
                    // INPUT_DEVICE_STATE_CHANGE. Hence, no point disconnecting here.
                    // The worst case, the connection will fail, retry.
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case CONNECT_HID_INCOMING:
                  // Bluez will take care of the conflicts
                    transitionTo(mIncomingHid);
                    break;

                case DISCONNECT_HFP_INCOMING:
                case DISCONNECT_A2DP_INCOMING:
                    // At this point, we are already disconnected
                    // with HFP. Sometimes HID connection can
                    // fail due to the disconnection of HFP. So add a retry
                    // for the HID.
                    if (mStatus) {
                        deferMsg.what = mCommand;
                        deferMessage(deferMsg);
                    }
                    break;
                case DISCONNECT_HID_INCOMING:
                    // Ignore, will be handled by Bluez
                    break;
                case DISCONNECT_PBAP_OUTGOING:
                case UNPAIR:
                case AUTO_CONNECT_PROFILES:
                    deferMessage(message);
                    break;
                case TRANSITION_TO_STABLE:
                    transitionTo(mBondedDevice);
                    break;
                default:
                    return NOT_HANDLED;
            }
            return HANDLED;
        }
    }

  private class IncomingHid extends State {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.493 -0400", hash_original_field = "3FAE308DA947D3D413A8D279D3D753BF", hash_generated_field = "3A218CE6B4AD3ADBEE0C2B1F8DC6D76B")

      private boolean mStatus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.497 -0400", hash_original_field = "2F175E88AE074D5006E1484402CDDE3D", hash_generated_field = "7E474BB103E3D6468E4A1624A89441E7")

      private int mCommand;

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.500 -0400", hash_original_method = "43CE8D553564F5CF3A322CAC138647D1", hash_generated_method = "E63507CF315A8E7933EA8077F236F3AB")
        
@Override
    public void enter() {
          log("Entering IncomingHid state with: " + getCurrentMessage().what);
          mCommand = getCurrentMessage().what;
          if (mCommand != CONNECT_HID_INCOMING &&
              mCommand != DISCONNECT_HID_INCOMING) {
              Log.e(TAG, "Error: IncomingHid state with command:" + mCommand);
          }
          mStatus = processCommand(mCommand);
          if (!mStatus) sendMessage(TRANSITION_TO_STABLE);
      }

      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.505 -0400", hash_original_method = "5B50565F385B8682036708D6BAB77FA8", hash_generated_method = "2A6DF42B71B6BF1611B5DC636CBB4B76")
        
@Override
    public boolean processMessage(Message message) {
          log("IncomingHid State->Processing Message: " + message.what);
          Message deferMsg = new Message();
          switch(message.what) {
              case CONNECT_HFP_OUTGOING:
              case CONNECT_HFP_INCOMING:
              case DISCONNECT_HFP_OUTGOING:
              case CONNECT_A2DP_INCOMING:
              case CONNECT_A2DP_OUTGOING:
              case DISCONNECT_A2DP_OUTGOING:
              case CONNECT_HID_OUTGOING:
              case CONNECT_HID_INCOMING:
              case DISCONNECT_HID_OUTGOING:
                  deferMessage(message);
                  break;
              case CONNECTION_ACCESS_REQUEST_REPLY:
                  mConnectionAccessReplyReceived = true;
                  int val = message.arg1;
                  setTrust(val);
                  handleIncomingConnection(CONNECT_HID_INCOMING,
                      val == BluetoothDevice.CONNECTION_ACCESS_YES);
                  break;
              case CONNECTION_ACCESS_REQUEST_EXPIRY:
                  if (!mConnectionAccessReplyReceived) {
                      handleIncomingConnection(CONNECT_HID_INCOMING, false);
                      sendConnectionAccessRemovalIntent();
                      sendMessage(TRANSITION_TO_STABLE);
                  }
                  break;
              case DISCONNECT_HFP_INCOMING:
                  // Shouldn't happen but if does, we can handle it.
                  // Depends if the headset can handle it.
                  // Incoming HID will be handled by Bluez, Disconnect HFP
                  // the socket would have already been closed.
                  // ignore
                  break;
              case DISCONNECT_HID_INCOMING:
              case DISCONNECT_A2DP_INCOMING:
                  // Ignore, will be handled by Bluez
                  break;
              case DISCONNECT_PBAP_OUTGOING:
              case UNPAIR:
              case AUTO_CONNECT_PROFILES:
                  deferMessage(message);
                  break;
              case TRANSITION_TO_STABLE:
                  transitionTo(mBondedDevice);
                  break;
              default:
                  return NOT_HANDLED;
          }
          return HANDLED;
      }
  }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.511 -0400", hash_original_method = "CE9B9EE9E9C6D29C9C3B8009F1D8AA7D", hash_generated_method = "D49F49930293F05AC868A1E4CAC4F097")
    
synchronized void cancelCommand(int command) {
        if (command == CONNECT_HFP_OUTGOING ) {
            // Cancel the outgoing thread.
            if (mHeadsetService != null) {
                mHeadsetService.cancelConnectThread();
            }
            // HeadsetService is down. Phone process most likely crashed.
            // The thread would have got killed.
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.514 -0400", hash_original_method = "D0E96B18DA4BDE4BDCAE9613CE40C9B2", hash_generated_method = "40016734EDF286D6C299697148FDA8FD")
    
synchronized void deferProfileServiceMessage(int command) {
        Message msg = new Message();
        msg.what = command;
        deferMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.517 -0400", hash_original_method = "4EB670BB0E3E4D3C84DFA00F6E1C2F0D", hash_generated_method = "1C709394C812191E697521481FF12E57")
    
private void updateIncomingAllowedTimer() {
        // Not doing a perfect exponential backoff because
        // we want two different rates. For all practical
        // purposes, this is good enough.
        if (mIncomingRejectTimer == 0) mIncomingRejectTimer = INIT_INCOMING_REJECT_TIMER;

        mIncomingRejectTimer *= 5;
        if (mIncomingRejectTimer > MAX_INCOMING_REJECT_TIMER) {
            mIncomingRejectTimer = MAX_INCOMING_REJECT_TIMER;
        }
        writeTimerValue(mIncomingRejectTimer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.520 -0400", hash_original_method = "79393F4F458EC66E37D5A118E106660C", hash_generated_method = "3C96ECE3CA99E33358044C69C3AF3421")
    
private boolean handleIncomingConnection(int command, boolean accept) {
        boolean ret = false;
        Log.i(TAG, "handleIncomingConnection:" + command + ":" + accept);
        switch (command) {
            case CONNECT_HFP_INCOMING:
                if (!accept) {
                    ret = mHeadsetService.rejectIncomingConnect(mDevice);
                    sendMessage(TRANSITION_TO_STABLE);
                    updateIncomingAllowedTimer();
                } else if (mHeadsetState == BluetoothHeadset.STATE_CONNECTING) {
                    writeTimerValue(0);
                    ret =  mHeadsetService.acceptIncomingConnect(mDevice);
                } else if (mHeadsetState == BluetoothHeadset.STATE_DISCONNECTED) {
                    writeTimerValue(0);
                    handleConnectionOfOtherProfiles(command);
                    ret = mHeadsetService.createIncomingConnect(mDevice);
                }
                break;
            case CONNECT_A2DP_INCOMING:
                if (!accept) {
                    ret = mA2dpService.allowIncomingConnect(mDevice, false);
                    sendMessage(TRANSITION_TO_STABLE);
                    updateIncomingAllowedTimer();
                } else {
                    writeTimerValue(0);
                    ret = mA2dpService.allowIncomingConnect(mDevice, true);
                    handleConnectionOfOtherProfiles(command);
                }
                break;
            case CONNECT_HID_INCOMING:
                if (!accept) {
                    ret = mService.allowIncomingProfileConnect(mDevice, false);
                    sendMessage(TRANSITION_TO_STABLE);
                    updateIncomingAllowedTimer();
                } else {
                    writeTimerValue(0);
                    ret = mService.allowIncomingProfileConnect(mDevice, true);
                }
                break;
            default:
                Log.e(TAG, "Waiting for incoming connection but state changed to:" + command);
                break;
       }
       return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.523 -0400", hash_original_method = "AD5E75CFCE41683F5C89EEB893E4519A", hash_generated_method = "A9CE9760C9F56881B8BFFA92B4E412B8")
    
private void sendConnectionAccessIntent() {
        mConnectionAccessReplyReceived = false;

        if (!mPowerManager.isScreenOn()) mWakeLock.acquire();

        Intent intent = new Intent(BluetoothDevice.ACTION_CONNECTION_ACCESS_REQUEST);
        intent.setClassName(ACCESS_AUTHORITY_PACKAGE, ACCESS_AUTHORITY_CLASS);
        intent.putExtra(BluetoothDevice.EXTRA_ACCESS_REQUEST_TYPE,
                        BluetoothDevice.REQUEST_TYPE_PROFILE_CONNECTION);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, mDevice);
        mContext.sendBroadcast(intent, BLUETOOTH_ADMIN_PERM);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.527 -0400", hash_original_method = "7EE52E07D12C9776B98924015A5AF685", hash_generated_method = "BAEA67F4A23C74932F70961EE40E2E27")
    
private void sendConnectionAccessRemovalIntent() {
        mWakeLock.release();
        Intent intent = new Intent(BluetoothDevice.ACTION_CONNECTION_ACCESS_CANCEL);
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, mDevice);
        mContext.sendBroadcast(intent, BLUETOOTH_ADMIN_PERM);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.530 -0400", hash_original_method = "EABD78D7D4F333E9DBF309DD3E328ABC", hash_generated_method = "C63B23C025207D4DA5C3F0CB6D26FFEC")
    
private int getTrust() {
        String address = mDevice.getAddress();
        if (mIncomingConnections != null) return mIncomingConnections.first;
        return CONNECTION_ACCESS_UNDEFINED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.533 -0400", hash_original_method = "CEC6A6DC2B482A10B09FF61C4AE23F1F", hash_generated_method = "7C64951DF8CBBE748E3720E05F248719")
    
private String getStringValue(long value) {
        StringBuilder sbr = new StringBuilder();
        sbr.append(Long.toString(System.currentTimeMillis()));
        sbr.append("-");
        sbr.append(Long.toString(value));
        return sbr.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.535 -0400", hash_original_method = "3F32C5F73F335FF0997EB1B2A6D8897B", hash_generated_method = "CE5310BF6DFD8E8F33E9993FD4AC6AA2")
    
private void setTrust(int value) {
        String second;
        if (mIncomingConnections == null) {
            second = getStringValue(INIT_INCOMING_REJECT_TIMER);
        } else {
            second = mIncomingConnections.second;
        }

        mIncomingConnections = new Pair(value, second);
        mService.writeIncomingConnectionState(mDevice.getAddress(), mIncomingConnections);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.538 -0400", hash_original_method = "CA424A981140B134D70F6DB926C56649", hash_generated_method = "AA874459478D3C52BFBD83B2DF864A10")
    
private void writeTimerValue(long value) {
        Integer first;
        if (mIncomingConnections == null) {
            first = CONNECTION_ACCESS_UNDEFINED;
        } else {
            first = mIncomingConnections.first;
        }
        mIncomingConnections = new Pair(first, getStringValue(value));
        mService.writeIncomingConnectionState(mDevice.getAddress(), mIncomingConnections);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.541 -0400", hash_original_method = "064955D9CC25F8AC722DA69C1B53B66E", hash_generated_method = "14504FA74C0972AB9BF5AD50019C658F")
    
private long readTimerValue() {
        if (mIncomingConnections == null)
            return 0;
        String value = mIncomingConnections.second;
        String[] splits = value.split("-");
        if (splits != null && splits.length == 2) {
            return Long.parseLong(splits[1]);
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.545 -0400", hash_original_method = "55F50A121DB6C02B9D79A4AE05EE971F", hash_generated_method = "75FC7509EE4668A3ADBD4D04CA26D6B4")
    
private boolean readIncomingAllowedValue() {
        if (readTimerValue() == 0) return true;
        String value = mIncomingConnections.second;
        String[] splits = value.split("-");
        if (splits != null && splits.length == 2) {
            long val1 = Long.parseLong(splits[0]);
            long val2 = Long.parseLong(splits[1]);
            if (val1 + val2 <= System.currentTimeMillis()) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.549 -0400", hash_original_method = "555A5F66AF736B2767B159F93C91428E", hash_generated_method = "8F389BE76E8EB415B49FCAE2A362CBFD")
    
synchronized boolean processCommand(int command) {
        log("Processing command:" + command);
        switch(command) {
            case  CONNECT_HFP_OUTGOING:
                if (mHeadsetService == null) {
                    deferProfileServiceMessage(command);
                } else {
                    return mHeadsetService.connectHeadsetInternal(mDevice);
                }
                break;
            case CONNECT_HFP_INCOMING:
                if (mHeadsetService == null) {
                    deferProfileServiceMessage(command);
                } else {
                    processIncomingConnectCommand(command);
                    return true;
                }
                break;
            case CONNECT_A2DP_OUTGOING:
                if (mA2dpService != null) {
                    return mA2dpService.connectSinkInternal(mDevice);
                }
                break;
            case CONNECT_A2DP_INCOMING:
                processIncomingConnectCommand(command);
                return true;
            case CONNECT_HID_OUTGOING:
                return mService.connectInputDeviceInternal(mDevice);
            case CONNECT_HID_INCOMING:
                processIncomingConnectCommand(command);
                return true;
            case DISCONNECT_HFP_OUTGOING:
                if (mHeadsetService == null) {
                    deferProfileServiceMessage(command);
                } else {
                    // Disconnect PBAP
                    // TODO(): Add PBAP to the state machine.
                    Message m = new Message();
                    m.what = DISCONNECT_PBAP_OUTGOING;
                    deferMessage(m);
                    if (mHeadsetService.getPriority(mDevice) ==
                        BluetoothHeadset.PRIORITY_AUTO_CONNECT) {
                        mHeadsetService.setPriority(mDevice, BluetoothHeadset.PRIORITY_ON);
                    }
                    return mHeadsetService.disconnectHeadsetInternal(mDevice);
                }
                break;
            case DISCONNECT_HFP_INCOMING:
                // ignore
                return true;
            case DISCONNECT_A2DP_INCOMING:
                // ignore
                return true;
            case DISCONNECT_A2DP_OUTGOING:
                if (mA2dpService != null) {
                    if (mA2dpService.getPriority(mDevice) ==
                        BluetoothA2dp.PRIORITY_AUTO_CONNECT) {
                        mA2dpService.setPriority(mDevice, BluetoothHeadset.PRIORITY_ON);
                    }
                    return mA2dpService.disconnectSinkInternal(mDevice);
                }
                break;
            case DISCONNECT_HID_INCOMING:
                // ignore
                return true;
            case DISCONNECT_HID_OUTGOING:
                if (mService.getInputDevicePriority(mDevice) ==
                    BluetoothInputDevice.PRIORITY_AUTO_CONNECT) {
                    mService.setInputDevicePriority(mDevice, BluetoothInputDevice.PRIORITY_ON);
                }
                return mService.disconnectInputDeviceInternal(mDevice);
            case DISCONNECT_PBAP_OUTGOING:
                if (!mPbapServiceConnected) {
                    deferProfileServiceMessage(command);
                } else {
                    return mPbapService.disconnect();
                }
                break;
            case UNPAIR:
                writeTimerValue(INIT_INCOMING_REJECT_TIMER);
                setTrust(CONNECTION_ACCESS_UNDEFINED);
                return mService.removeBondInternal(mDevice.getAddress());
            default:
                Log.e(TAG, "Error: Unknown Command");
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.552 -0400", hash_original_method = "66C9F6DB178E385D1574563A398CD213", hash_generated_method = "71E3DC5D4D4BB6A465AE6CCE4B2D6F06")
    
private void processIncomingConnectCommand(int command) {
        // Check if device is already trusted
        int access = getTrust();
        if (access == BluetoothDevice.CONNECTION_ACCESS_YES) {
            handleIncomingConnection(command, true);
        } else if (access == BluetoothDevice.CONNECTION_ACCESS_NO &&
                   !readIncomingAllowedValue()) {
            handleIncomingConnection(command, false);
        } else {
            sendConnectionAccessIntent();
            Message msg = obtainMessage(CONNECTION_ACCESS_REQUEST_EXPIRY);
            sendMessageDelayed(msg,
                               CONNECTION_ACCESS_REQUEST_EXPIRY_TIMEOUT);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.556 -0400", hash_original_method = "80C80CC738C3CF44411124DD37C2261C", hash_generated_method = "C13657886B394DDCB2E7D8589BF122BC")
    
private void handleConnectionOfOtherProfiles(int command) {
        // The white paper recommendations mentions that when there is a
        // link loss, it is the responsibility of the remote device to connect.
        // Many connect only 1 profile - and they connect the second profile on
        // some user action (like play being pressed) and so we need this code.
        // Auto Connect code only connects to the last connected device - which
        // is useful in cases like when the phone reboots. But consider the
        // following case:
        // User is connected to the car's phone and  A2DP profile.
        // User comes to the desk  and places the phone in the dock
        // (or any speaker or music system or even another headset) and thus
        // gets connected to the A2DP profile.  User goes back to the car.
        // Ideally the car's system is supposed to send incoming connections
        // from both Handsfree and A2DP profile. But they don't. The Auto
        // connect code, will not work here because we only auto connect to the
        // last connected device for that profile which in this case is the dock.
        // Now suppose a user is using 2 headsets simultaneously, one for the
        // phone profile one for the A2DP profile. If this is the use case, we
        // expect the user to use the preference to turn off the A2DP profile in
        // the Settings screen for the first headset. Else, after link loss,
        // there can be an incoming connection from the first headset which
        // might result in the connection of the A2DP profile (if the second
        // headset is slower) and thus the A2DP profile on the second headset
        // will never get connected.
        //
        // TODO(): Handle other profiles here.
        switch (command) {
            case CONNECT_HFP_INCOMING:
                // Connect A2DP if there is no incoming connection
                // If the priority is OFF - don't auto connect.
                if (mA2dpService.getPriority(mDevice) == BluetoothProfile.PRIORITY_ON ||
                        mA2dpService.getPriority(mDevice) ==
                            BluetoothProfile.PRIORITY_AUTO_CONNECT) {
                    Message msg = new Message();
                    msg.what = CONNECT_OTHER_PROFILES;
                    msg.arg1 = CONNECT_A2DP_OUTGOING;
                    sendMessageDelayed(msg, CONNECT_OTHER_PROFILES_DELAY);
                }
                break;
            case CONNECT_A2DP_INCOMING:
                // This is again against spec. HFP incoming connections should be made
                // before A2DP, so we should not hit this case. But many devices
                // don't follow this.
                if (mHeadsetService != null &&
                    (mHeadsetService.getPriority(mDevice) == BluetoothProfile.PRIORITY_ON ||
                        mHeadsetService.getPriority(mDevice) ==
                            BluetoothProfile.PRIORITY_AUTO_CONNECT)) {
                    Message msg = new Message();
                    msg.what = CONNECT_OTHER_PROFILES;
                    msg.arg1 = CONNECT_HFP_OUTGOING;
                    sendMessageDelayed(msg, CONNECT_OTHER_PROFILES_DELAY);
                }
                break;
            default:
                break;
        }

    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.559 -0400", hash_original_method = "B0090999831176D6860CB733B4946A22", hash_generated_method = "B0090999831176D6860CB733B4946A22")
    
BluetoothDevice getDevice() {
        return mDevice;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:06.562 -0400", hash_original_method = "99AA4B3370948214654854546E56B3E9", hash_generated_method = "C95D330D38FDE2355A81E8B2EA193823")
    
private void log(String message) {
        if (DBG) {
            Log.i(TAG, "Device:" + mDevice + " Message:" + message);
        }
    }
}
