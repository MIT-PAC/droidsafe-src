package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

public class UiModeManager {
    private IUiModeManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.067 -0400", hash_original_method = "885E2DF97B9D4497B2AC3BA2EAEC628B", hash_generated_method = "056F639D47467015E4958DFADC7377FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     UiModeManager() {
        mService = IUiModeManager.Stub.asInterface(
                ServiceManager.getService(Context.UI_MODE_SERVICE));
        // ---------- Original Method ----------
        //mService = IUiModeManager.Stub.asInterface(
                //ServiceManager.getService(Context.UI_MODE_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.068 -0400", hash_original_method = "A4DA8672EE11B64C720877911E862CCA", hash_generated_method = "99B011B71197B71B9C4756485A980B17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableCarMode(int flags) {
        dsTaint.addTaint(flags);
        {
            try 
            {
                mService.enableCarMode(flags);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.enableCarMode(flags);
            //} catch (RemoteException e) {
                //Log.e(TAG, "disableCarMode: RemoteException", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.069 -0400", hash_original_method = "3F662D74C7F5FA5E21AD89C24E03313D", hash_generated_method = "78E7AFADDD9A048EF0D5AD1E08834F66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableCarMode(int flags) {
        dsTaint.addTaint(flags);
        {
            try 
            {
                mService.disableCarMode(flags);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.disableCarMode(flags);
            //} catch (RemoteException e) {
                //Log.e(TAG, "disableCarMode: RemoteException", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.070 -0400", hash_original_method = "0CD456741A85C32EF5CC7E71365FBB20", hash_generated_method = "DF96C624B28520643D037EDC4CF83BFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCurrentModeType() {
        {
            try 
            {
                int var29ABCCF4A3C40C4AD9C9FABB6311381C_799543127 = (mService.getCurrentModeType());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getCurrentModeType();
            //} catch (RemoteException e) {
                //Log.e(TAG, "getCurrentModeType: RemoteException", e);
            //}
        //}
        //return Configuration.UI_MODE_TYPE_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.072 -0400", hash_original_method = "D2225F0EDD53710765C544C38EED4B1C", hash_generated_method = "D91C599042B942093CABAFC0EB95D3B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNightMode(int mode) {
        dsTaint.addTaint(mode);
        {
            try 
            {
                mService.setNightMode(mode);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setNightMode(mode);
            //} catch (RemoteException e) {
                //Log.e(TAG, "setNightMode: RemoteException", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.073 -0400", hash_original_method = "9AFE4882A5DD35A0B7234D31EDC0BDFC", hash_generated_method = "2E794B98AD75C40C25E83BF7DA2D1A4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNightMode() {
        {
            try 
            {
                int var3C287D9906731F02DF673BDD06743A15_1620129169 = (mService.getNightMode());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getNightMode();
            //} catch (RemoteException e) {
                //Log.e(TAG, "getNightMode: RemoteException", e);
            //}
        //}
        //return -1;
    }

    
    private static final String TAG = "UiModeManager";
    public static String ACTION_ENTER_CAR_MODE = "android.app.action.ENTER_CAR_MODE";
    public static String ACTION_EXIT_CAR_MODE = "android.app.action.EXIT_CAR_MODE";
    public static String ACTION_ENTER_DESK_MODE = "android.app.action.ENTER_DESK_MODE";
    public static String ACTION_EXIT_DESK_MODE = "android.app.action.EXIT_DESK_MODE";
    public static final int MODE_NIGHT_AUTO = Configuration.UI_MODE_NIGHT_UNDEFINED >> 4;
    public static final int MODE_NIGHT_NO = Configuration.UI_MODE_NIGHT_NO >> 4;
    public static final int MODE_NIGHT_YES = Configuration.UI_MODE_NIGHT_YES >> 4;
    public static final int ENABLE_CAR_MODE_GO_CAR_HOME = 0x0001;
    public static final int DISABLE_CAR_MODE_GO_HOME = 0x0001;
}

