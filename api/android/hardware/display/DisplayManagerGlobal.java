/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.hardware.display;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.util.SparseArray;
import android.view.CompatibilityInfoHolder;
import android.view.Display;
import android.view.DisplayInfo;

import java.util.ArrayList;

/**
 * Manager communication with the display manager service on behalf of
 * an application process.  You're probably looking for {@link DisplayManager}.
 *
 * @hide
 */
public final class DisplayManagerGlobal {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.789 -0500", hash_original_field = "F2EE8995718B12C0E28488FE3CE7BF32", hash_generated_field = "1D95E96D263D8B110E1E39A38436743A")

    private static final String TAG = "DisplayManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.791 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.793 -0500", hash_original_field = "07458AD7D4B0757961B31F370D0673DD", hash_generated_field = "2F02348A84516837E224164C5B63A160")

    //
    // FIXME: The cache is currently disabled because it's unclear whether we have the
    // necessary guarantees that the caches will always be flushed before clients
    // attempt to observe their new state.  For example, depending on the order
    // in which the binder transactions take place, we might have a problem where
    // an application could start processing a configuration change due to a display
    // orientation change before the display info cache has actually been invalidated.
    private static final boolean USE_CACHE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.795 -0500", hash_original_field = "74EA4FCC072BFA7BB93368AA3F2BD3C5", hash_generated_field = "2B6F13EBEB2F547B6101E69203D7A154")

    public static final int EVENT_DISPLAY_ADDED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.797 -0500", hash_original_field = "63C64DE2D70E1D058154728ED5214DCC", hash_generated_field = "BE97FE48F8DD5346E5A69305E60A5E14")

    public static final int EVENT_DISPLAY_CHANGED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.799 -0500", hash_original_field = "E3C799A8E5A14195E5DC6A54AE4C2D69", hash_generated_field = "AC0F6A52678AE271D168E6091FF31D7C")

    public static final int EVENT_DISPLAY_REMOVED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.801 -0500", hash_original_field = "981287867F628CB13A8DE50D782D49FB", hash_generated_field = "9937810F50139C375F005A5D443261EC")

    private static DisplayManagerGlobal sInstance;

    /**
     * Gets an instance of the display manager global singleton.
     *
     * @return The display manager instance, may be null early in system startup
     * before the display manager has been fully initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.815 -0500", hash_original_method = "4C02E34F5083EA6BE1702184A9AEC56D", hash_generated_method = "FCEA16B87BD2A480809EFDDDE3E7E6B2")
    
public static DisplayManagerGlobal getInstance() {
        synchronized (DisplayManagerGlobal.class) {
            if (sInstance == null) {
                IBinder b = ServiceManager.getService(Context.DISPLAY_SERVICE);
                if (b != null) {
                    sInstance = new DisplayManagerGlobal(IDisplayManager.Stub.asInterface(b));
                }
            }
            return sInstance;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.803 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.805 -0500", hash_original_field = "9409ADEE56CE8D79A6721E369C1DB7BD", hash_generated_field = "01730059E534D7D39601788492B3D674")

    private  IDisplayManager mDm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.806 -0500", hash_original_field = "31EC7A891F0642B692733C03DA33A1D1", hash_generated_field = "8CF5DB6BFB361184B0285E5FDF09B75A")

    private DisplayManagerCallback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.808 -0500", hash_original_field = "F5ECCA389BA40FCD17897E4E1A03E936", hash_generated_field = "700A6D5AD49105AA37D08AAAC0761D95")

    private final ArrayList<DisplayListenerDelegate> mDisplayListeners =
            new ArrayList<DisplayListenerDelegate>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.810 -0500", hash_original_field = "64A3041904684602A14A01EFE3805C58", hash_generated_field = "A20FD6EDDE6483602DE445CF4D1AD565")

    private final SparseArray<DisplayInfo> mDisplayInfoCache = new SparseArray<DisplayInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.812 -0500", hash_original_field = "68205E3AA3D1446A13014794146ADBF1", hash_generated_field = "C1B49A6936EC8E8FC7035AA2DEE85250")

    private int[] mDisplayIdCache;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.813 -0500", hash_original_method = "FA037E0DBADC1BE4658CB7F9F9BC1BF7", hash_generated_method = "9923825E219F29BF4D983BB8D06B90F5")
    
private DisplayManagerGlobal(IDisplayManager dm) {
        mDm = dm;
    }

    /**
     * Get information about a particular logical display.
     *
     * @param displayId The logical display id.
     * @return Information about the specified display, or null if it does not exist.
     * This object belongs to an internal cache and should be treated as if it were immutable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.818 -0500", hash_original_method = "44C8C7D343D2F29F525152AAF95AE985", hash_generated_method = "09BBBC4AF6D26E27D4AB598FD791CD81")
    
public DisplayInfo getDisplayInfo(int displayId) {
        try {
            synchronized (mLock) {
                DisplayInfo info;
                if (USE_CACHE) {
                    info = mDisplayInfoCache.get(displayId);
                    if (info != null) {
                        return info;
                    }
                }

                info = mDm.getDisplayInfo(displayId);
                if (info == null) {
                    return null;
                }

                if (USE_CACHE) {
                    mDisplayInfoCache.put(displayId, info);
                }
                registerCallbackIfNeededLocked();

                if (DEBUG) {
                    Log.d(TAG, "getDisplayInfo: displayId=" + displayId + ", info=" + info);
                }
                return info;
            }
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not get display information from display manager.", ex);
            return null;
        }
    }

    /**
     * Gets all currently valid logical display ids.
     *
     * @return An array containing all display ids.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.819 -0500", hash_original_method = "420444AB91D2B127727053BD7A8F26F8", hash_generated_method = "F3C3A813263F2827F661277C4745D6CC")
    
public int[] getDisplayIds() {
        try {
            synchronized (mLock) {
                if (USE_CACHE) {
                    if (mDisplayIdCache != null) {
                        return mDisplayIdCache;
                    }
                }

                int[] displayIds = mDm.getDisplayIds();
                if (USE_CACHE) {
                    mDisplayIdCache = displayIds;
                }
                registerCallbackIfNeededLocked();
                return displayIds;
            }
        } catch (RemoteException ex) {
            Log.e(TAG, "Could not get display ids from display manager.", ex);
            return new int[] { Display.DEFAULT_DISPLAY };
        }
    }

    /**
     * Gets information about a logical display.
     *
     * The display metrics may be adjusted to provide compatibility
     * for legacy applications.
     *
     * @param displayId The logical display id.
     * @param cih The compatibility info, or null if none is required.
     * @return The display object, or null if there is no display with the given id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.822 -0500", hash_original_method = "6641E7B62058E28DABE3E1C01F72894D", hash_generated_method = "26E27BA31AC995C5956DAEAD0C577D63")
    
public Display getCompatibleDisplay(int displayId, CompatibilityInfoHolder cih) {
        DisplayInfo displayInfo = getDisplayInfo(displayId);
        if (displayInfo == null) {
            return null;
        }
        //return new Display(this, displayId, displayInfo, cih);
        return new Display(DSOnlyType.DONTCARE);
    }

    /**
     * Gets information about a logical display without applying any compatibility metrics.
     *
     * @param displayId The logical display id.
     * @return The display object, or null if there is no display with the given id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.823 -0500", hash_original_method = "9B4B57BE85EF3383C4EFA97860CB91F2", hash_generated_method = "6870AAB86E2CF9F4B38EB66176EE4D99")
    
public Display getRealDisplay(int displayId) {
        return getCompatibleDisplay(displayId, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.825 -0500", hash_original_method = "528977F643B616295DD3D4838EDF741F", hash_generated_method = "B6F47B2B2240D762F1C41CDEA22820B6")
    @DSVerified("callback modeled")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void registerDisplayListener(DisplayListener listener, Handler handler) {
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }

        synchronized (mLock) {
            int index = findDisplayListenerLocked(listener);
            if (index < 0) {
                mDisplayListeners.add(new DisplayListenerDelegate(listener, handler));
                registerCallbackIfNeededLocked();
            }
        }
        if (listener != null) {
            listener.onDisplayAdded(DSUtils.FAKE_INT);
            listener.onDisplayChanged(DSUtils.FAKE_INT);
            listener.onDisplayRemoved(DSUtils.FAKE_INT);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.827 -0500", hash_original_method = "3AADB9BB5B90DCC39B12C6388720BB9A", hash_generated_method = "1D4D03F43DE59A16CFDD7405FC4BE03C")
    
public void unregisterDisplayListener(DisplayListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener must not be null");
        }

        synchronized (mLock) {
            int index = findDisplayListenerLocked(listener);
            if (index >= 0) {
                DisplayListenerDelegate d = mDisplayListeners.get(index);
                d.clearEvents();
                mDisplayListeners.remove(index);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.829 -0500", hash_original_method = "BAE54CA513ABE7E3F67F0ABDCD474879", hash_generated_method = "5F33F1A0DEB91158AAEF6370E475D3E6")
    
private int findDisplayListenerLocked(DisplayListener listener) {
        final int numListeners = mDisplayListeners.size();
        for (int i = 0; i < numListeners; i++) {
            if (mDisplayListeners.get(i).mListener == listener) {
                return i;
            }
        }
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.831 -0500", hash_original_method = "F65C8EB4AEF77E9BF78F832CCB111D41", hash_generated_method = "F3D89FE887E42D9BE06ED5199CB6BB9D")
    
private void registerCallbackIfNeededLocked() {
        if (mCallback == null) {
            mCallback = new DisplayManagerCallback();
            try {
                mDm.registerCallback(mCallback);
            } catch (RemoteException ex) {
                Log.e(TAG, "Failed to register callback with display manager service.", ex);
                mCallback = null;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.833 -0500", hash_original_method = "B1FC9AD57A082E3321A2FFD8F310F479", hash_generated_method = "D15535EB5D53A291BAF496D59D7FA1AD")
    
private void handleDisplayEvent(int displayId, int event) {
        synchronized (mLock) {
            if (USE_CACHE) {
                mDisplayInfoCache.remove(displayId);

                if (event == EVENT_DISPLAY_ADDED || event == EVENT_DISPLAY_REMOVED) {
                    mDisplayIdCache = null;
                }
            }

            final int numListeners = mDisplayListeners.size();
            for (int i = 0; i < numListeners; i++) {
                mDisplayListeners.get(i).sendDisplayEvent(displayId, event);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.835 -0500", hash_original_method = "18F0CA9E7389157AC7AB5D123852EC34", hash_generated_method = "4BB71A0BF01DECE2D93809108C1F27D3")
    
public void scanWifiDisplays() {
        try {
            mDm.scanWifiDisplays();
        } catch (RemoteException ex) {
            Log.e(TAG, "Failed to scan for Wifi displays.", ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.837 -0500", hash_original_method = "F020B320CF59F315E29A2E34A8723F6B", hash_generated_method = "5C3905167D60C1D095BEBBC296864ADC")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
 
public void connectWifiDisplay(String deviceAddress) {
        if (deviceAddress == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }

        try {
            mDm.connectWifiDisplay(deviceAddress);
        } catch (RemoteException ex) {
            Log.e(TAG, "Failed to connect to Wifi display " + deviceAddress + ".", ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.838 -0500", hash_original_method = "03D6AE1B584E7452E8B85AF00F2BC16F", hash_generated_method = "55C6D4A82DB0D9F565BBFC01C70FC940")
    
public void disconnectWifiDisplay() {
        try {
            mDm.disconnectWifiDisplay();
        } catch (RemoteException ex) {
            Log.e(TAG, "Failed to disconnect from Wifi display.", ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.840 -0500", hash_original_method = "D6607E10F2E4198257A5C0C9D00DC6FD", hash_generated_method = "23326BCE8678E3266D74E0D716F061B9")
    
public void renameWifiDisplay(String deviceAddress, String alias) {
        if (deviceAddress == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }

        try {
            mDm.renameWifiDisplay(deviceAddress, alias);
        } catch (RemoteException ex) {
            Log.e(TAG, "Failed to rename Wifi display " + deviceAddress
                    + " with alias " + alias + ".", ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.841 -0500", hash_original_method = "A6E806822256B78A7A684E1E3A0C752A", hash_generated_method = "4633E142124D4C786A04A499C426E356")
    
public void forgetWifiDisplay(String deviceAddress) {
        if (deviceAddress == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }

        try {
            mDm.forgetWifiDisplay(deviceAddress);
        } catch (RemoteException ex) {
            Log.e(TAG, "Failed to forget Wifi display.", ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.843 -0500", hash_original_method = "B6113EA7D211084986C8C3C4C769C747", hash_generated_method = "12AF3524E2EF9BDF7A44D50CE47E5ECE")
    
public WifiDisplayStatus getWifiDisplayStatus() {
        try {
            return mDm.getWifiDisplayStatus();
        } catch (RemoteException ex) {
            Log.e(TAG, "Failed to get Wifi display status.", ex);
            return new WifiDisplayStatus();
        }
    }

    private final class DisplayManagerCallback extends IDisplayManagerCallback.Stub {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.846 -0500", hash_original_method = "E404ECF5C83D35709F7FD483B2A936BB", hash_generated_method = "F2814D1FE3D42F96AF3E787F2D7A3AD9")
        
@Override
        public void onDisplayEvent(int displayId, int event) {
            if (DEBUG) {
                Log.d(TAG, "onDisplayEvent: displayId=" + displayId + ", event=" + event);
            }
            handleDisplayEvent(displayId, event);
        }
    }

    private static final class DisplayListenerDelegate extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.849 -0500", hash_original_field = "ADD98BC49F5B0E7287D1D5129EFBDBA1", hash_generated_field = "A7F508277D693CFC6E35AB0D2304A402")

        public  DisplayListener mListener;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.851 -0500", hash_original_method = "F533F49E4FD821139396811E1B2C228B", hash_generated_method = "C0AD6A74EE60E258D7633C4898389F18")
        
public DisplayListenerDelegate(DisplayListener listener, Handler handler) {
            //super(handler != null ? handler.getLooper() : Looper.myLooper(), null, true /*async*/);
            mListener = listener;
            if (listener != null) {
                listener.onDisplayAdded(DSUtils.FAKE_INT);
                listener.onDisplayChanged(DSUtils.FAKE_INT);
                listener.onDisplayRemoved(DSUtils.FAKE_INT);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.853 -0500", hash_original_method = "3BA989A7F9CD8ADB157792D3977629FC", hash_generated_method = "ADA277D14597984FFF9CE30B8A545D68")
        
public void sendDisplayEvent(int displayId, int event) {
            Message msg = obtainMessage(event, displayId, 0);
            sendMessage(msg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.855 -0500", hash_original_method = "8D8F2DBBD0D510D7A010B41B4B154780", hash_generated_method = "A60AAFD67BA4A1C50024843F0CFE8535")
        
public void clearEvents() {
            removeCallbacksAndMessages(null);
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.857 -0500", hash_original_method = "40FD96142E58D5B8E6192BAD39A83962", hash_generated_method = "DFDA8C0A2A0D18AAC169836EF5DE13D4")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case EVENT_DISPLAY_ADDED:
                    mListener.onDisplayAdded(msg.arg1);
                    break;
                case EVENT_DISPLAY_CHANGED:
                    mListener.onDisplayChanged(msg.arg1);
                    break;
                case EVENT_DISPLAY_REMOVED:
                    mListener.onDisplayRemoved(msg.arg1);
                    break;
            }
        }
    }
}
