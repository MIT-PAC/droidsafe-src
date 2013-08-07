package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.Configuration;
import android.os.RemoteException;
import android.os.ServiceManager;



public class UiModeManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.316 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "AC5296BC9334BAEB9DDA5E503BF7ECAF")

    private IUiModeManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.317 -0400", hash_original_method = "885E2DF97B9D4497B2AC3BA2EAEC628B", hash_generated_method = "056F639D47467015E4958DFADC7377FD")
      UiModeManager() {
        mService = IUiModeManager.Stub.asInterface(
                ServiceManager.getService(Context.UI_MODE_SERVICE));
        // ---------- Original Method ----------
        //mService = IUiModeManager.Stub.asInterface(
                //ServiceManager.getService(Context.UI_MODE_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.317 -0400", hash_original_method = "A4DA8672EE11B64C720877911E862CCA", hash_generated_method = "DF6E2F7CE23B29B7B3639E99B124472F")
    public void enableCarMode(int flags) {
        addTaint(flags);
        if(mService != null)        
        {
            try 
            {
                mService.enableCarMode(flags);
            } //End block
            catch (RemoteException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.318 -0400", hash_original_method = "3F662D74C7F5FA5E21AD89C24E03313D", hash_generated_method = "97F837358B28E4909B7BE505CAAF5430")
    public void disableCarMode(int flags) {
        addTaint(flags);
        if(mService != null)        
        {
            try 
            {
                mService.disableCarMode(flags);
            } //End block
            catch (RemoteException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.319 -0400", hash_original_method = "0CD456741A85C32EF5CC7E71365FBB20", hash_generated_method = "863F4A83F51E3F65CDC08FC7A056033F")
    public int getCurrentModeType() {
        if(mService != null)        
        {
            try 
            {
                int varE219EC66418E44F08D99AF6653852EED_686255948 = (mService.getCurrentModeType());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587809326 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587809326;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varB0B5851D8D0FE3A7BD00C32F6053A667_1223377461 = (Configuration.UI_MODE_TYPE_NORMAL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137654547 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137654547;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.319 -0400", hash_original_method = "D2225F0EDD53710765C544C38EED4B1C", hash_generated_method = "C382CE2D1CFD940D2F313BEA1186E674")
    public void setNightMode(int mode) {
        addTaint(mode);
        if(mService != null)        
        {
            try 
            {
                mService.setNightMode(mode);
            } //End block
            catch (RemoteException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.320 -0400", hash_original_method = "9AFE4882A5DD35A0B7234D31EDC0BDFC", hash_generated_method = "0621C930969FED0D3090FDF4E7B9CBE9")
    public int getNightMode() {
        if(mService != null)        
        {
            try 
            {
                int var89B2AB289C9BBE2E6DC5362B4B3C525C_1395173549 = (mService.getNightMode());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247833279 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1247833279;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_406346610 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904181196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904181196;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.320 -0400", hash_original_field = "DF9ADE9656BBECC1AE55D2E833605EF5", hash_generated_field = "42AEB3165E3850F68716AA3C8DD21F5E")

    private static final String TAG = "UiModeManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.320 -0400", hash_original_field = "47DAFC65C6B5A4E9E4DE5C92E6184028", hash_generated_field = "A618402524A4F62B1AEC90708DB85E4F")

    public static String ACTION_ENTER_CAR_MODE = "android.app.action.ENTER_CAR_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.321 -0400", hash_original_field = "0D50F200031F7037930EF7B00C102DCD", hash_generated_field = "D1C75F61989ABB3CDE4B02448AB2AD42")

    public static String ACTION_EXIT_CAR_MODE = "android.app.action.EXIT_CAR_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.321 -0400", hash_original_field = "37C77B8A742E1913197F1A3BCD0170CF", hash_generated_field = "E3F23ADBC25ACC014B784BBB3ED89735")

    public static String ACTION_ENTER_DESK_MODE = "android.app.action.ENTER_DESK_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.321 -0400", hash_original_field = "4C5E384476032224FE4811314BCE583A", hash_generated_field = "E3165410905E198B86B1C6717699B49B")

    public static String ACTION_EXIT_DESK_MODE = "android.app.action.EXIT_DESK_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.321 -0400", hash_original_field = "D1151118F91E4212473617024EED365F", hash_generated_field = "A1D9AB7CECA1407C5BE4EB516D55B5EC")

    public static final int MODE_NIGHT_AUTO = Configuration.UI_MODE_NIGHT_UNDEFINED >> 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.321 -0400", hash_original_field = "CE64F002459C0BA3117D27CCBB9135BA", hash_generated_field = "B75E7784F32F2033B89925385DE5345B")

    public static final int MODE_NIGHT_NO = Configuration.UI_MODE_NIGHT_NO >> 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.321 -0400", hash_original_field = "38792BEA1EDA8DE2684D70A2961FD27C", hash_generated_field = "3931D8B47FB51C2F74C8DDC6A19D3575")

    public static final int MODE_NIGHT_YES = Configuration.UI_MODE_NIGHT_YES >> 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.321 -0400", hash_original_field = "EE4397CE577B711245AF6EE9C736247B", hash_generated_field = "21526DD4B745D2A0684339F4E92B6778")

    public static final int ENABLE_CAR_MODE_GO_CAR_HOME = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.322 -0400", hash_original_field = "2B66F4DC9990FE7494EE3D7DA554FC54", hash_generated_field = "3102F0ECF4ACF19F31C99EDCA6C607E8")

    public static final int DISABLE_CAR_MODE_GO_HOME = 0x0001;
}

