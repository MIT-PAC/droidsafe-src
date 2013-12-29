package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.Configuration;
import android.os.RemoteException;
import android.os.ServiceManager;



public class UiModeManager {
    
    @DSModeled(DSC.BAN)
    public static UiModeManager createInstance() {
        return new UiModeManager();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.511 -0500", hash_original_field = "1AB3DCE86D7AC083B86A8FE454EA6A07", hash_generated_field = "42AEB3165E3850F68716AA3C8DD21F5E")

    private static final String TAG = "UiModeManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.512 -0500", hash_original_field = "158612309DBF3540F25E881CADC29F1D", hash_generated_field = "A618402524A4F62B1AEC90708DB85E4F")

    public static String ACTION_ENTER_CAR_MODE = "android.app.action.ENTER_CAR_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.513 -0500", hash_original_field = "9296D1735B4392EB03C0000F0FCC7084", hash_generated_field = "D1C75F61989ABB3CDE4B02448AB2AD42")

    public static String ACTION_EXIT_CAR_MODE = "android.app.action.EXIT_CAR_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.514 -0500", hash_original_field = "7497095F4E718ECFD71D149E18D3999B", hash_generated_field = "E3F23ADBC25ACC014B784BBB3ED89735")

    public static String ACTION_ENTER_DESK_MODE = "android.app.action.ENTER_DESK_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.515 -0500", hash_original_field = "DFAF05980A85DCEA3EA468923DAC8C66", hash_generated_field = "E3165410905E198B86B1C6717699B49B")

    public static String ACTION_EXIT_DESK_MODE = "android.app.action.EXIT_DESK_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.516 -0500", hash_original_field = "E6C020FD92124EB405C275148C5B0CF7", hash_generated_field = "A1D9AB7CECA1407C5BE4EB516D55B5EC")

    public static final int MODE_NIGHT_AUTO = Configuration.UI_MODE_NIGHT_UNDEFINED >> 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.517 -0500", hash_original_field = "0780A494998054CF8E840FED96A47759", hash_generated_field = "B75E7784F32F2033B89925385DE5345B")

    public static final int MODE_NIGHT_NO = Configuration.UI_MODE_NIGHT_NO >> 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.517 -0500", hash_original_field = "CCC988F697B1D081C96F88DABE894E91", hash_generated_field = "3931D8B47FB51C2F74C8DDC6A19D3575")

    public static final int MODE_NIGHT_YES = Configuration.UI_MODE_NIGHT_YES >> 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.520 -0500", hash_original_field = "FC2534792F92DC445655F8075218C9C5", hash_generated_field = "21526DD4B745D2A0684339F4E92B6778")

    public static final int ENABLE_CAR_MODE_GO_CAR_HOME = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.522 -0500", hash_original_field = "E125C7929B94AEA169DE223C125F80E3", hash_generated_field = "3102F0ECF4ACF19F31C99EDCA6C607E8")

    public static final int DISABLE_CAR_MODE_GO_HOME = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.518 -0500", hash_original_field = "375F4CDB96C235DF550526331454121A", hash_generated_field = "AC5296BC9334BAEB9DDA5E503BF7ECAF")


    private IUiModeManager mService;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.317 -0400", hash_original_method = "885E2DF97B9D4497B2AC3BA2EAEC628B", hash_generated_method = "056F639D47467015E4958DFADC7377FD")
      UiModeManager() {
        /*
        mService = IUiModeManager.Stub.asInterface(
                ServiceManager.getService(Context.UI_MODE_SERVICE));
        */
        // ---------- Original Method ----------
        //mService = IUiModeManager.Stub.asInterface(
                //ServiceManager.getService(Context.UI_MODE_SERVICE));
    }
    
    /**
     * Force device into car mode, like it had been placed in the car dock.
     * This will cause the device to switch to the car home UI as part of
     * the mode switch.
     * @param flags Must be 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.521 -0500", hash_original_method = "A4DA8672EE11B64C720877911E862CCA", hash_generated_method = "DD466E571F8813B6A90B31373C9D4E21")
    public void enableCarMode(int flags) {
        if (mService != null) {
            try {
                mService.enableCarMode(flags);
            } catch (RemoteException e) {
                Log.e(TAG, "disableCarMode: RemoteException", e);
            }
        }
    }
    
    /**
     * Turn off special mode if currently in car mode.
     * @param flags May be 0 or {@link #DISABLE_CAR_MODE_GO_HOME}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.523 -0500", hash_original_method = "3F662D74C7F5FA5E21AD89C24E03313D", hash_generated_method = "76B33845503C0C8B0DD07E34FE5BC6C0")
    public void disableCarMode(int flags) {
        if (mService != null) {
            try {
                mService.disableCarMode(flags);
            } catch (RemoteException e) {
                Log.e(TAG, "disableCarMode: RemoteException", e);
            }
        }
    }

    /**
     * Return the current running mode type.  May be one of
     * {@link Configuration#UI_MODE_TYPE_NORMAL Configuration.UI_MODE_TYPE_NORMAL},
     * {@link Configuration#UI_MODE_TYPE_DESK Configuration.UI_MODE_TYPE_DESK}, or
     * {@link Configuration#UI_MODE_TYPE_CAR Configuration.UI_MODE_TYPE_CAR}, or
     * {@link Configuration#UI_MODE_TYPE_TELEVISION Configuration.UI_MODE_TYPE_TV}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.523 -0500", hash_original_method = "0CD456741A85C32EF5CC7E71365FBB20", hash_generated_method = "D4DE81443170D2B9821E2F6BCEEA8330")
    public int getCurrentModeType() {
        if (mService != null) {
            try {
                return mService.getCurrentModeType();
            } catch (RemoteException e) {
                Log.e(TAG, "getCurrentModeType: RemoteException", e);
            }
        }
        return Configuration.UI_MODE_TYPE_NORMAL;
    }

    /**
     * Sets the night mode.  Changes to the night mode are only effective when
     * the car or desk mode is enabled on a device.
     *
     * <p>The mode can be one of:
     * <ul>
     *   <li><em>{@link #MODE_NIGHT_NO}<em> - sets the device into notnight
     *       mode.</li>
     *   <li><em>{@link #MODE_NIGHT_YES}</em> - sets the device into night mode.
     *   </li>
     *   <li><em>{@link #MODE_NIGHT_AUTO}</em> - automatic night/notnight switching
     *       depending on the location and certain other sensors.</li>
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.524 -0500", hash_original_method = "D2225F0EDD53710765C544C38EED4B1C", hash_generated_method = "42638A30BD8F188BC6646A1676028C8E")
    public void setNightMode(int mode) {
        if (mService != null) {
            try {
                mService.setNightMode(mode);
            } catch (RemoteException e) {
                Log.e(TAG, "setNightMode: RemoteException", e);
            }
        }
    }

    /**
     * Returns the currently configured night mode.
     *
     * @return {@link #MODE_NIGHT_NO}, {@link #MODE_NIGHT_YES}, or
     *  {@link #MODE_NIGHT_AUTO}.  When an error occurred -1 is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:12.525 -0500", hash_original_method = "9AFE4882A5DD35A0B7234D31EDC0BDFC", hash_generated_method = "1959474A613E71E942C1471438107391")
    public int getNightMode() {
        if (mService != null) {
            try {
                return mService.getNightMode();
            } catch (RemoteException e) {
                Log.e(TAG, "getNightMode: RemoteException", e);
            }
        }
        return -1;
    }
}

