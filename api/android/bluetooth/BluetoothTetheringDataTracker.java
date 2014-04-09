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
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfoInternal;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkStateTracker;
import android.net.NetworkUtils;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class tracks the data connection associated with Bluetooth
 * reverse tethering. This is a singleton class and an instance will be
 * created by ConnectivityService. BluetoothService will call into this
 * when a reverse tethered connection needs to be activated.
 *
 * @hide
 */
public class BluetoothTetheringDataTracker implements NetworkStateTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.903 -0400", hash_original_field = "1F66109021389965FDC89FA6AC25BE54", hash_generated_field = "9F4E3D619A35E41476EACE2F29CF208E")

    private static final String NETWORKTYPE = "BLUETOOTH_TETHER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.905 -0400", hash_original_field = "8E8317EABBFDFCA493123F7A902C9779", hash_generated_field = "D8999902566300E6307743AB193E27A9")

    private static final String TAG = "BluetoothTethering";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.930 -0400", hash_original_field = "C6509AE7C2783D6AD6BC51D8BEE05945", hash_generated_field = "7F61F459987B17A837AF314BA491C250")

    private static String mIface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.937 -0400", hash_original_field = "C50E83BA3FF3727F9EFDA7BFE2DF6B6C", hash_generated_field = "D73060604D1C4B91BC07A75197383A49")

    public static BluetoothTetheringDataTracker sInstance;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.942 -0400", hash_original_method = "D23DDA37A1D29D1179E70AF8D0930C4C", hash_generated_method = "562AD593BF2F125E0650C93AB0D0F245")
    
public static synchronized BluetoothTetheringDataTracker getInstance() {
        if (sInstance == null) sInstance = new BluetoothTetheringDataTracker();
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.908 -0400", hash_original_field = "6541C6711D6BE05C9C021C8620DD0C06", hash_generated_field = "4EA0249F3CB1F25DEEB7A2D599960CCF")


    private AtomicBoolean mTeardownRequested = new AtomicBoolean(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.911 -0400", hash_original_field = "0CBE9DA0B72CF8A774EFC63D7BE3C8AE", hash_generated_field = "3C2E61E069E7AE1880AD97C845BB54D0")

    private AtomicBoolean mPrivateDnsRouteSet = new AtomicBoolean(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.913 -0400", hash_original_field = "F3DC3AF4C6083777A8B0A22B46E832EF", hash_generated_field = "77891CDD70B546A75E94EE258F5C0118")

    private AtomicInteger mDefaultGatewayAddr = new AtomicInteger(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.915 -0400", hash_original_field = "3E6340621CFBC7E1396DDE1259E9EBC1", hash_generated_field = "0AC9B49D737A7C50ADBC5B6C671FAD41")

    private AtomicBoolean mDefaultRouteSet = new AtomicBoolean(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.917 -0400", hash_original_field = "3AC154B48A5E86BD2F0F7B931CFF2258", hash_generated_field = "9F649FE3D9C6025A8AFED4B89BAD6B4C")


    private LinkProperties mLinkProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.920 -0400", hash_original_field = "1351E512E27F9F6433090E613107A8FA", hash_generated_field = "A9452502E20D0089CC2F2695F26B7137")

    private LinkCapabilities mLinkCapabilities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.922 -0400", hash_original_field = "C9189F8BA4BB4B9FD0E4D078ECB6D143", hash_generated_field = "A7526E3936575521473E104690BBA591")

    private NetworkInfo mNetworkInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.924 -0400", hash_original_field = "B9CD495C4335B9BDF4D3DF44104103AC", hash_generated_field = "88E222EF7AC6D17D41069DC9735DDE20")


    private BluetoothPan mBluetoothPan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.926 -0400", hash_original_field = "793253818BA6C7B0BA0EE44002B9EC24", hash_generated_field = "E4571726F4118D3C8C7A8AF1D003C1BF")

    private BluetoothDevice mDevice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.932 -0400", hash_original_field = "30DCB7449EFBA9914255FB5D23E522F5", hash_generated_field = "953BDDD9DAE5C25C054C68C7A9AA2F80")

    private Handler mCsHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.934 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.959 -0400", hash_original_field = "A37954B7ACFD41DCB2A95B39A75A2A3C", hash_generated_field = "C48754FEB28FB5513A32BE302F1420F4")


    private BluetoothProfile.ServiceListener mProfileServiceListener =
        new BluetoothProfile.ServiceListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.207 -0400", hash_original_method = "75162FF2FC33BE2B6B1325F8645EBC1B", hash_generated_method = "62B9848B231BCD5BD54662E15F361A76")
        
public void onServiceConnected(int profile, BluetoothProfile proxy) {
            mBluetoothPan = (BluetoothPan) proxy;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.208 -0400", hash_original_method = "689B408215CC2E7D996339AADB82B7E0", hash_generated_method = "CC689E3E9ADB93B7F6C7EBB3962A4117")
        
public void onServiceDisconnected(int profile) {
            mBluetoothPan = null;
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.939 -0400", hash_original_method = "E333130020C6323F086A67DCFD787729", hash_generated_method = "3E84013271C4A314948B37E023E57403")
    
private BluetoothTetheringDataTracker() {
        mNetworkInfo = new NetworkInfo(ConnectivityManager.TYPE_BLUETOOTH, 0, NETWORKTYPE, "");
        mLinkProperties = new LinkProperties();
        mLinkCapabilities = new LinkCapabilities();

        mNetworkInfo.setIsAvailable(false);
        setTeardownRequested(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.944 -0400", hash_original_method = "072F051A7084E87F8651CDFD0E06C4FB", hash_generated_method = "1D5A6E986E4F7873AFC8DB71C5A7F33F")
    
public Object Clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.946 -0400", hash_original_method = "CC22EDC9B67962F7EB440A3242F1EA96", hash_generated_method = "36BBBA7F0BC53D2F1576C72218F09FD4")
    
public void setTeardownRequested(boolean isRequested) {
        mTeardownRequested.set(isRequested);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.948 -0400", hash_original_method = "3FC0A0521EF6B3CA03CB3284A49CE72A", hash_generated_method = "DB4662F3ADA76CECF0F3B3E8EE6D3CE2")
    
public boolean isTeardownRequested() {
        return mTeardownRequested.get();
    }

    /**
     * Begin monitoring connectivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.950 -0400", hash_original_method = "6035C9CB1BC41BE82E57FED6332D139D", hash_generated_method = "4BD2DF9B7737E1EFC4AA0007C5528CC5")
    
public void startMonitoring(Context context, Handler target) {
        mContext = context;
        mCsHandler = target;
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter != null) {
            adapter.getProfileProxy(mContext, mProfileServiceListener, BluetoothProfile.PAN);
        }
    }

    /**
     * Disable connectivity to a network
     * TODO: do away with return value after making MobileDataStateTracker async
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.962 -0400", hash_original_method = "AC04C3F2A8A265A20CDE9BDBC5B444F5", hash_generated_method = "6C6D344EE07D512A5AFBA2828C86AE1A")
    
public boolean teardown() {
        mTeardownRequested.set(true);
        if (mBluetoothPan != null) {
            for (BluetoothDevice device: mBluetoothPan.getConnectedDevices()) {
                mBluetoothPan.disconnect(device);
            }
        }
        return true;
    }

    /**
     * Re-enable connectivity to a network after a {@link #teardown()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.964 -0400", hash_original_method = "ABFC29EED8974DF0E4A534CEDEBC4370", hash_generated_method = "AE3987FD7B199F7291BB9C8D800AC66F")
    
public boolean reconnect() {
        mTeardownRequested.set(false);
        //Ignore
        return true;
    }

    /**
     * Turn the wireless radio off for a network.
     * @param turnOn {@code true} to turn the radio on, {@code false}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.966 -0400", hash_original_method = "06DC2878FFED08F240EE9F20DD66C2BD", hash_generated_method = "7AC833BD658D591C57CB8E6C795DCD99")
    
public boolean setRadio(boolean turnOn) {
        return true;
    }

    /**
     * @return true - If are we currently tethered with another device.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.968 -0400", hash_original_method = "B8ACFEF571A41A685CADA9636F3B7A52", hash_generated_method = "939E807616973546ACBAE8C6AAC1D9B1")
    
public synchronized boolean isAvailable() {
        return mNetworkInfo.isAvailable();
    }

    /**
     * Tells the underlying networking system that the caller wants to
     * begin using the named feature. The interpretation of {@code feature}
     * is completely up to each networking implementation.
     * @param feature the name of the feature to be used
     * @param callingPid the process ID of the process that is issuing this request
     * @param callingUid the user ID of the process that is issuing this request
     * @return an integer value representing the outcome of the request.
     * The interpretation of this value is specific to each networking
     * implementation+feature combination, except that the value {@code -1}
     * always indicates failure.
     * TODO: needs to go away
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.970 -0400", hash_original_method = "1C55D7B5F804FCED35DF5C3AC73F06A1", hash_generated_method = "7925219F7162D0A18FD7FD757C940D0A")
    
public int startUsingNetworkFeature(String feature, int callingPid, int callingUid) {
        return -1;
    }

    /**
     * Tells the underlying networking system that the caller is finished
     * using the named feature. The interpretation of {@code feature}
     * is completely up to each networking implementation.
     * @param feature the name of the feature that is no longer needed.
     * @param callingPid the process ID of the process that is issuing this request
     * @param callingUid the user ID of the process that is issuing this request
     * @return an integer value representing the outcome of the request.
     * The interpretation of this value is specific to each networking
     * implementation+feature combination, except that the value {@code -1}
     * always indicates failure.
     * TODO: needs to go away
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.973 -0400", hash_original_method = "4490367383D360C4A9AF67AB96F6559E", hash_generated_method = "A6B4B162458F4E3554DF823B7569228E")
    
public int stopUsingNetworkFeature(String feature, int callingPid, int callingUid) {
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.975 -0400", hash_original_method = "C3E966C81798980C28A54EA8D78B11AD", hash_generated_method = "EB42D4BFB72A5E3E239C3BDA7CAB9A03")
    
@Override
    public void setUserDataEnable(boolean enabled) {
        Log.w(TAG, "ignoring setUserDataEnable(" + enabled + ")");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.977 -0400", hash_original_method = "8E72506631B6273F72B36AC5C6478073", hash_generated_method = "9DB4B64D4E268DF49CCEC21EA864A6E0")
    
@Override
    public void setPolicyDataEnable(boolean enabled) {
        Log.w(TAG, "ignoring setPolicyDataEnable(" + enabled + ")");
    }

    /**
     * Check if private DNS route is set for the network
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.980 -0400", hash_original_method = "45A0E2A435B55A4376C3E3C34A986F78", hash_generated_method = "160A8598D1E8D7F819C939488C64657F")
    
public boolean isPrivateDnsRouteSet() {
        return mPrivateDnsRouteSet.get();
    }

    /**
     * Set a flag indicating private DNS route is set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.982 -0400", hash_original_method = "7CD50638E3A6C827E205E4831BBA3EC2", hash_generated_method = "3C35CFBB2706F52557662120CAEE67C5")
    
public void privateDnsRouteSet(boolean enabled) {
        mPrivateDnsRouteSet.set(enabled);
    }

    /**
     * Fetch NetworkInfo for the network
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.985 -0400", hash_original_method = "F51E2BBE5399CD9C2800B34B70D18211", hash_generated_method = "137E3F2E573B8970859745D948485776")
    
public synchronized NetworkInfo getNetworkInfo() {
        return mNetworkInfo;
    }

    /**
     * Fetch LinkProperties for the network
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.987 -0400", hash_original_method = "B4FF63F4C76F0FFF333C37BA30CB2C0D", hash_generated_method = "75A54BD5CA6E9CE6AA5CFB52C0A17D1F")
    
public synchronized LinkProperties getLinkProperties() {
        return new LinkProperties(mLinkProperties);
    }

   /**
     * A capability is an Integer/String pair, the capabilities
     * are defined in the class LinkSocket#Key.
     *
     * @return a copy of this connections capabilities, may be empty but never null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.989 -0400", hash_original_method = "96D540D62D4D1D309EBAE00292357DBA", hash_generated_method = "C2CF889D13F84433CD506E051654913A")
    
public LinkCapabilities getLinkCapabilities() {
        return new LinkCapabilities(mLinkCapabilities);
    }

    /**
     * Fetch default gateway address for the network
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.991 -0400", hash_original_method = "0760A2BFD862DDE09EAF4A7B45A1EE42", hash_generated_method = "D43047DC065539DA44A939CD13A06C86")
    
public int getDefaultGatewayAddr() {
        return mDefaultGatewayAddr.get();
    }

    /**
     * Check if default route is set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.993 -0400", hash_original_method = "35C9CBE5101C777B4EADABC10088A8AB", hash_generated_method = "804A354FC075BF45DF30348B6C2C8C9C")
    
public boolean isDefaultRouteSet() {
        return mDefaultRouteSet.get();
    }

    /**
     * Set a flag indicating default route is set for the network
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.995 -0400", hash_original_method = "55A4228DA4C3FEF05B3C611B8D880567", hash_generated_method = "8BDE2BB18D773931E3CCC8AFDA2C01FB")
    
public void defaultRouteSet(boolean enabled) {
        mDefaultRouteSet.set(enabled);
    }

    /**
     * Return the system properties name associated with the tcp buffer sizes
     * for this network.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:11.998 -0400", hash_original_method = "E8D16751ECB8086BEB1E03D0C0993047", hash_generated_method = "D10CC3409F4C3C15B4EB66E42DBD64AD")
    
public String getTcpBufferSizesPropName() {
        return "net.tcp.buffersize.wifi";
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:12.006 -0400", hash_original_method = "6D2EE25D5E1C8FDE216F03246F7F479B", hash_generated_method = "09FB26A549076303A3868E905BC5AA40")
    
public synchronized void startReverseTether(String iface, BluetoothDevice device) {
        mIface = iface;
        mDevice = device;
        Thread dhcpThread = new Thread(new Runnable() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:17.235 -0400", hash_original_method = "FB9174C1B530D0751959C1927D66B916", hash_generated_method = "A090132B26E855C3B521526C20C665B8")
            
public void run() {
                //TODO(): Add callbacks for failure and success case.
                //Currently this thread runs independently.
                DhcpInfoInternal dhcpInfoInternal = new DhcpInfoInternal();
                if (!NetworkUtils.runDhcp(mIface, dhcpInfoInternal)) {
                    Log.e(TAG, "DHCP request error:" + NetworkUtils.getDhcpError());
                    return;
                }
                mLinkProperties = dhcpInfoInternal.makeLinkProperties();
                mLinkProperties.setInterfaceName(mIface);

                mNetworkInfo.setIsAvailable(true);
                mNetworkInfo.setDetailedState(DetailedState.CONNECTED, null, null);

                Message msg = mCsHandler.obtainMessage(EVENT_CONFIGURATION_CHANGED, mNetworkInfo);
                msg.sendToTarget();

                msg = mCsHandler.obtainMessage(EVENT_STATE_CHANGED, mNetworkInfo);
                msg.sendToTarget();
            }
        });
        dhcpThread.start();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:12.009 -0400", hash_original_method = "D696E6F06B1EAC82CFF28792193FF0DD", hash_generated_method = "8D8E0CC7D80A30CA1BF9A6A94EBD074C")
    
public synchronized void stopReverseTether(String iface) {
        NetworkUtils.stopDhcp(iface);

        mLinkProperties.clear();
        mNetworkInfo.setIsAvailable(false);
        mNetworkInfo.setDetailedState(DetailedState.DISCONNECTED, null, null);

        Message msg = mCsHandler.obtainMessage(EVENT_CONFIGURATION_CHANGED, mNetworkInfo);
        msg.sendToTarget();

        msg = mCsHandler.obtainMessage(EVENT_STATE_CHANGED, mNetworkInfo);
        msg.sendToTarget();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:12.011 -0400", hash_original_method = "E641D443226437284B4A7BBC21603ED2", hash_generated_method = "859A17420831D90CE65AB5900AA3431A")
    
public void setDependencyMet(boolean met) {
        // not supported on this network
    }
}
