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
import android.os.Handler;
import android.util.SparseArray;
import android.view.Display;

import java.util.ArrayList;

/**
 * Manages the properties of attached displays.
 * <p>
 * Get an instance of this class by calling
 * {@link android.content.Context#getSystemService(java.lang.String)
 * Context.getSystemService()} with the argument
 * {@link android.content.Context#DISPLAY_SERVICE}.
 * </p>
 */
public final class DisplayManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.883 -0500", hash_original_field = "F2EE8995718B12C0E28488FE3CE7BF32", hash_generated_field = "1D95E96D263D8B110E1E39A38436743A")

    private static final String TAG = "DisplayManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.887 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.910 -0500", hash_original_field = "2688BEEE99219F197237DA838B2AA2E7", hash_generated_field = "27C2FB3ABC4BB1EA54608EBED5D1E446")

    public static final String ACTION_WIFI_DISPLAY_STATUS_CHANGED =
            "android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.913 -0500", hash_original_field = "42861C0B200B596E1A8A6BB6BD988259", hash_generated_field = "12150D7B4E5F54674BC9DF4487573C75")

    public static final String EXTRA_WIFI_DISPLAY_STATUS =
            "android.hardware.display.extra.WIFI_DISPLAY_STATUS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.916 -0500", hash_original_field = "3F896DAA089785905823DA076BCB7DC5", hash_generated_field = "350F5D837391F9A44E77C2F869455E89")

    public static final String DISPLAY_CATEGORY_PRESENTATION =
            "android.hardware.display.category.PRESENTATION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.889 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.892 -0500", hash_original_field = "2CC68F96F934EA3E15BF4794DB3DE566", hash_generated_field = "A9921A4E062A258F54A69A5DF5AAB9C1")

    private  DisplayManagerGlobal mGlobal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.895 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")


    private final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.902 -0500", hash_original_field = "B00A3026F5234AF7ABD5E573AB12C298", hash_generated_field = "60D45257E3B0DDEF0044C24C8554CECD")

    private final SparseArray<Display> mDisplays = new SparseArray<Display>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.905 -0500", hash_original_field = "2E696C2CBA94376ED9E68D7B7E69843B", hash_generated_field = "74CC84EA7CCF3EC091CABB380B804F63")


    private final ArrayList<Display> mTempDisplays = new ArrayList<Display>();

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.919 -0500", hash_original_method = "1ADC5EF22708D434AD26635E19AECA7B", hash_generated_method = "532859A87541F633227C34D08B0D408D")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public DisplayManager(Context context) {
        mContext = context;
        mGlobal = DisplayManagerGlobal.getInstance();
    }

    /**
     * Gets information about a logical display.
     *
     * The display metrics may be adjusted to provide compatibility
     * for legacy applications.
     *
     * @param displayId The logical display id.
     * @return The display object, or null if there is no valid display with the given id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.922 -0500", hash_original_method = "9C6696F40BAED9738B374734AEDB247B", hash_generated_method = "08D3B8906602132564E5330963DEE82C")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public Display getDisplay(int displayId) {
        synchronized (mLock) {
            return getOrCreateDisplayLocked(displayId, false /*assumeValid*/);
        }
    }

    /**
     * Gets all currently valid logical displays.
     *
     * @return An array containing all displays.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.925 -0500", hash_original_method = "A2CB2CDF038D38A398FABC12369D1AB5", hash_generated_method = "9C20F6CC060FF2858B9B1AAB380FAB5E")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public Display[] getDisplays() {
        return getDisplays(null);
    }

    /**
     * Gets all currently valid logical displays of the specified category.
     * <p>
     * When there are multiple displays in a category the returned displays are sorted
     * of preference.  For example, if the requested category is
     * {@link #DISPLAY_CATEGORY_PRESENTATION} and there are multiple presentation displays
     * then the displays are sorted so that the first display in the returned array
     * is the most preferred presentation display.  The application may simply
     * use the first display or allow the user to choose.
     * </p>
     *
     * @param category The requested display category or null to return all displays.
     * @return An array containing all displays sorted by order of preference.
     *
     * @see #DISPLAY_CATEGORY_PRESENTATION
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.930 -0500", hash_original_method = "6C06E5C8451B49B10C00F3A9AD582CF7", hash_generated_method = "284ABF02CF15A4126183B588A2A6C405")
    
public Display[] getDisplays(String category) {
        final int[] displayIds = mGlobal.getDisplayIds();
        synchronized (mLock) {
            try {
                if (category == null) {
                    addMatchingDisplaysLocked(mTempDisplays, displayIds, -1);
                } else if (category.equals(DISPLAY_CATEGORY_PRESENTATION)) {
                    addMatchingDisplaysLocked(mTempDisplays, displayIds, Display.TYPE_WIFI);
                    addMatchingDisplaysLocked(mTempDisplays, displayIds, Display.TYPE_HDMI);
                    addMatchingDisplaysLocked(mTempDisplays, displayIds, Display.TYPE_OVERLAY);
                }
                return mTempDisplays.toArray(new Display[mTempDisplays.size()]);
            } finally {
                mTempDisplays.clear();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.935 -0500", hash_original_method = "C26E5E1662A772E18A5E511C86D1C233", hash_generated_method = "AE16C378E95708E86EAF9773FC8F0B1E")
    
private void addMatchingDisplaysLocked(
            ArrayList<Display> displays, int[] displayIds, int matchType) {
        for (int i = 0; i < displayIds.length; i++) {
            Display display = getOrCreateDisplayLocked(displayIds[i], true /*assumeValid*/);
            if (display != null) {
                displays.add(display);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.939 -0500", hash_original_method = "D8261C245C60E01132941F3490A05100", hash_generated_method = "B58B1422118AE735B83B4E9CEC5E30ED")
    
private Display getOrCreateDisplayLocked(int displayId, boolean assumeValid) {
        Display display = mDisplays.get(displayId);
        
        if (display == null) {
            display = mGlobal.getCompatibleDisplay(displayId,
                    mContext.getCompatibilityInfo(displayId));
            if (display != null) {
                mDisplays.put(displayId, display);
            }
        } else if (!assumeValid) { 
            display = null;
        }
        return display;
    }

    /**
     * Registers an display listener to receive notifications about when
     * displays are added, removed or changed.
     *
     * @param listener The listener to register.
     * @param handler The handler on which the listener should be invoked, or null
     * if the listener should be invoked on the calling thread's looper.
     *
     * @see #unregisterDisplayListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.942 -0500", hash_original_method = "2DC5F18EA2822A91E5FAFDB6F8D5D1E5", hash_generated_method = "2DB916E7FDD4C78C09936669B8922B2D")
    @DSVerified("callback modeled")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void registerDisplayListener(DisplayListener listener, Handler handler) {
        mGlobal.registerDisplayListener(listener, handler);
    }

    /**
     * Unregisters an input device listener.
     *
     * @param listener The listener to unregister.
     *
     * @see #registerDisplayListener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.944 -0500", hash_original_method = "26AEEFDD9505FAD4EAE2A40C64F47366", hash_generated_method = "6B7DC3ACB380DB6B608913F68EB43044")
    
public void unregisterDisplayListener(DisplayListener listener) {
        mGlobal.unregisterDisplayListener(listener);
    }

    /**
     * Initiates a fresh scan of availble Wifi displays.
     * The results are sent as a {@link #ACTION_WIFI_DISPLAY_STATUS_CHANGED} broadcast.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.946 -0500", hash_original_method = "FC9A09096DA0137E50E65DCBB27B06E4", hash_generated_method = "47A4BEA2C272A353C055495309589FAC")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)

public void scanWifiDisplays() {
        mGlobal.scanWifiDisplays();
    }

    /**
     * Connects to a Wifi display.
     * The results are sent as a {@link #ACTION_WIFI_DISPLAY_STATUS_CHANGED} broadcast.
     * <p>
     * Automatically remembers the display after a successful connection, if not
     * already remembered.
     * </p><p>
     * Requires {@link android.Manifest.permission#CONFIGURE_WIFI_DISPLAY} to connect
     * to unknown displays.  No permissions are required to connect to already known displays.
     * </p>
     *
     * @param deviceAddress The MAC address of the device to which we should connect.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.949 -0500", hash_original_method = "B319AA70FBCEEFF3EDB570ECF34E6323", hash_generated_method = "D1BC37915C03CC0AAC00D2D1D4685415")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)

public void connectWifiDisplay(String deviceAddress) {
        mGlobal.connectWifiDisplay(deviceAddress);
    }

    /**
     * Disconnects from the current Wifi display.
     * The results are sent as a {@link #ACTION_WIFI_DISPLAY_STATUS_CHANGED} broadcast.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.951 -0500", hash_original_method = "13B0723AEEE37C72B756EFA83497714E", hash_generated_method = "F5E380FE40F406C17E653F7AFE097E1D")
    
public void disconnectWifiDisplay() {
        mGlobal.disconnectWifiDisplay();
    }

    /**
     * Renames a Wifi display.
     * <p>
     * The display must already be remembered for this call to succeed.  In other words,
     * we must already have successfully connected to the display at least once and then
     * not forgotten it.
     * </p><p>
     * Requires {@link android.Manifest.permission#CONFIGURE_WIFI_DISPLAY}.
     * </p>
     *
     * @param deviceAddress The MAC address of the device to rename.
     * @param alias The alias name by which to remember the device, or null
     * or empty if no alias should be used.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.953 -0500", hash_original_method = "B485F0A48A6DE5A9031828577A940F24", hash_generated_method = "7540D76D1480808DCDD587009FFE29AE")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void renameWifiDisplay(String deviceAddress, String alias) {
        mGlobal.renameWifiDisplay(deviceAddress, alias);
    }

    /**
     * Forgets a previously remembered Wifi display.
     * <p>
     * Automatically disconnects from the display if currently connected to it.
     * </p><p>
     * Requires {@link android.Manifest.permission#CONFIGURE_WIFI_DISPLAY}.
     * </p>
     *
     * @param deviceAddress The MAC address of the device to forget.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.956 -0500", hash_original_method = "D5CEF10FB4CD0A5237470102374899A6", hash_generated_method = "3F9DFFD9ADE946C129699A087F7C8364")
    
public void forgetWifiDisplay(String deviceAddress) {
        mGlobal.forgetWifiDisplay(deviceAddress);
    }

    /**
     * Gets the current Wifi display status.
     * Watch for changes in the status by registering a broadcast receiver for
     * {@link #ACTION_WIFI_DISPLAY_STATUS_CHANGED}.
     *
     * @return The current Wifi display status.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:20:07.959 -0500", hash_original_method = "12FD3BEAC91E673EBB7F301651B9E98C", hash_generated_method = "FD157040FA2FFC296AE6B665F639850F")
    
public WifiDisplayStatus getWifiDisplayStatus() {
        return mGlobal.getWifiDisplayStatus();
    }

    /**
     * Listens for changes in available display devices.
     */
    public interface DisplayListener {
        /**
         * Called whenever a logical display has been added to the system.
         * Use {@link DisplayManager#getDisplay} to get more information about
         * the display.
         *
         * @param displayId The id of the logical display that was added.
         */
        void onDisplayAdded(int displayId);

        /**
         * Called whenever a logical display has been removed from the system.
         *
         * @param displayId The id of the logical display that was removed.
         */
        void onDisplayRemoved(int displayId);

        /**
         * Called whenever the properties of a logical display have changed.
         *
         * @param displayId The id of the logical display that changed.
         */
        void onDisplayChanged(int displayId);
    }
}
