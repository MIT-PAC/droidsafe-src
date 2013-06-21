package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.IccCardStatus.PinState;

public class IccCardApplication {
    public AppType        app_type;
    public AppState       app_state;
    public PersoSubState  perso_substate;
    public String         aid;
    public String         app_label;
    public int            pin1_replaced;
    public PinState            pin1;
    public PinState            pin2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.285 -0400", hash_original_method = "3B25A620E1148BFBD35766488061DDD5", hash_generated_method = "3B25A620E1148BFBD35766488061DDD5")
        public IccCardApplication ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.286 -0400", hash_original_method = "1116744B87B74A8B1F94F0BFA362A158", hash_generated_method = "5C81EF5D96D4F4EFB342FDCD2FA3F372")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AppType AppTypeFromRILInt(int type) {
        dsTaint.addTaint(type);
        AppType newType;
        //Begin case 0 
        newType = AppType.APPTYPE_UNKNOWN;
        //End case 0 
        //Begin case 1 
        newType = AppType.APPTYPE_SIM;
        //End case 1 
        //Begin case 2 
        newType = AppType.APPTYPE_USIM;
        //End case 2 
        //Begin case 3 
        newType = AppType.APPTYPE_RUIM;
        //End case 3 
        //Begin case 4 
        newType = AppType.APPTYPE_CSIM;
        //End case 4 
        //Begin case 5 
        newType = AppType.APPTYPE_ISIM;
        //End case 5 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_AppType: " +type);
        //End case default 
        return (AppType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AppType newType;
        //switch(type) {
            //case 0: newType = AppType.APPTYPE_UNKNOWN; break;
            //case 1: newType = AppType.APPTYPE_SIM;     break;
            //case 2: newType = AppType.APPTYPE_USIM;    break;
            //case 3: newType = AppType.APPTYPE_RUIM;    break;
            //case 4: newType = AppType.APPTYPE_CSIM;    break;
            //case 5: newType = AppType.APPTYPE_ISIM;    break;
            //default:
                //throw new RuntimeException(
                            //"Unrecognized RIL_AppType: " +type);
        //}
        //return newType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.286 -0400", hash_original_method = "9534088223FA9637F4929B2D2CEDDB5A", hash_generated_method = "9D80038A5282A4C5218F632141BC1143")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AppState AppStateFromRILInt(int state) {
        dsTaint.addTaint(state);
        AppState newState;
        //Begin case 0 
        newState = AppState.APPSTATE_UNKNOWN;
        //End case 0 
        //Begin case 1 
        newState = AppState.APPSTATE_DETECTED;
        //End case 1 
        //Begin case 2 
        newState = AppState.APPSTATE_PIN;
        //End case 2 
        //Begin case 3 
        newState = AppState.APPSTATE_PUK;
        //End case 3 
        //Begin case 4 
        newState = AppState.APPSTATE_SUBSCRIPTION_PERSO;
        //End case 4 
        //Begin case 5 
        newState = AppState.APPSTATE_READY;
        //End case 5 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_AppState: " +state);
        //End case default 
        return (AppState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AppState newState;
        //switch(state) {
            //case 0: newState = AppState.APPSTATE_UNKNOWN;  break;
            //case 1: newState = AppState.APPSTATE_DETECTED; break;
            //case 2: newState = AppState.APPSTATE_PIN; break;
            //case 3: newState = AppState.APPSTATE_PUK; break;
            //case 4: newState = AppState.APPSTATE_SUBSCRIPTION_PERSO; break;
            //case 5: newState = AppState.APPSTATE_READY; break;
            //default:
                //throw new RuntimeException(
                            //"Unrecognized RIL_AppState: " +state);
        //}
        //return newState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.287 -0400", hash_original_method = "17A43E5E3170BC2C3023BB14299D6F08", hash_generated_method = "327853F17CBCB60A7F2D86BFD2C3ACAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PersoSubState PersoSubstateFromRILInt(int substate) {
        dsTaint.addTaint(substate);
        PersoSubState newSubState;
        //Begin case 0 
        newSubState = PersoSubState.PERSOSUBSTATE_UNKNOWN;
        //End case 0 
        //Begin case 1 
        newSubState = PersoSubState.PERSOSUBSTATE_IN_PROGRESS;
        //End case 1 
        //Begin case 2 
        newSubState = PersoSubState.PERSOSUBSTATE_READY;
        //End case 2 
        //Begin case 3 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK;
        //End case 3 
        //Begin case 4 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET;
        //End case 4 
        //Begin case 5 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE;
        //End case 5 
        //Begin case 6 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER;
        //End case 6 
        //Begin case 7 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM;
        //End case 7 
        //Begin case 8 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_PUK;
        //End case 8 
        //Begin case 9 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK;
        //End case 9 
        //Begin case 10 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE_PUK;
        //End case 10 
        //Begin case 11 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK;
        //End case 11 
        //Begin case 12 
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM_PUK;
        //End case 12 
        //Begin case 13 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1;
        //End case 13 
        //Begin case 14 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2;
        //End case 14 
        //Begin case 15 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD;
        //End case 15 
        //Begin case 16 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE;
        //End case 16 
        //Begin case 17 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER;
        //End case 17 
        //Begin case 18 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM;
        //End case 18 
        //Begin case 19 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1_PUK;
        //End case 19 
        //Begin case 20 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2_PUK;
        //End case 20 
        //Begin case 21 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD_PUK;
        //End case 21 
        //Begin case 22 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE_PUK;
        //End case 22 
        //Begin case 23 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK;
        //End case 23 
        //Begin case 24 
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM_PUK;
        //End case 24 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_PersoSubstate: " +substate);
        //End case default 
        return (PersoSubState)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.287 -0400", hash_original_method = "691AF073265032051E58110F3AF07370", hash_generated_method = "6335F5C3656BCCF70F55C92DD0302B23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PinState PinStateFromRILInt(int state) {
        dsTaint.addTaint(state);
        PinState newPinState;
        //Begin case 0 
        newPinState = PinState.PINSTATE_UNKNOWN;
        //End case 0 
        //Begin case 1 
        newPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
        //End case 1 
        //Begin case 2 
        newPinState = PinState.PINSTATE_ENABLED_VERIFIED;
        //End case 2 
        //Begin case 3 
        newPinState = PinState.PINSTATE_DISABLED;
        //End case 3 
        //Begin case 4 
        newPinState = PinState.PINSTATE_ENABLED_BLOCKED;
        //End case 4 
        //Begin case 5 
        newPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
        //End case 5 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized RIL_PinState: " + state);
        //End case default 
        return (PinState)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.288 -0400", hash_original_method = "B7A3E528A56EA330AD359B5362903D13", hash_generated_method = "FBB673866096C7EE4EDE867D00E040B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("{").append(app_type).append(",").append(app_state);
        {
            sb.append(",").append(perso_substate);
        } //End block
        {
            sb.append(",pin1=").append(pin1);
            sb.append(",pin2=").append(pin2);
        } //End block
        sb.append("}");
        String var806458D832AB974D230FEE4CBBDBD390_1851431710 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("{").append(app_type).append(",").append(app_state);
        //if (app_state == AppState.APPSTATE_SUBSCRIPTION_PERSO) {
            //sb.append(",").append(perso_substate);
        //}
        //if (app_type == AppType.APPTYPE_CSIM ||
                //app_type == AppType.APPTYPE_USIM ||
                //app_type == AppType.APPTYPE_ISIM) {
            //sb.append(",pin1=").append(pin1);
            //sb.append(",pin2=").append(pin2);
        //}
        //sb.append("}");
        //return sb.toString();
    }

    
    public enum AppType{
        APPTYPE_UNKNOWN,
        APPTYPE_SIM,
        APPTYPE_USIM,
        APPTYPE_RUIM,
        APPTYPE_CSIM,
        APPTYPE_ISIM
    }

    
    public enum AppState{
        APPSTATE_UNKNOWN,
        APPSTATE_DETECTED,
        APPSTATE_PIN,
        APPSTATE_PUK,
        APPSTATE_SUBSCRIPTION_PERSO,
        APPSTATE_READY;
        boolean isPinRequired() {
            return this == APPSTATE_PIN;
        }
        boolean isPukRequired() {
            return this == APPSTATE_PUK;
        }
        boolean isSubscriptionPersoEnabled() {
            return this == APPSTATE_SUBSCRIPTION_PERSO;
        }
        boolean isAppReady() {
            return this == APPSTATE_READY;
        }
        boolean isAppNotReady() {
            return this == APPSTATE_UNKNOWN  ||
                   this == APPSTATE_DETECTED;
        }
    }

    
    public enum PersoSubState{
        PERSOSUBSTATE_UNKNOWN,
        PERSOSUBSTATE_IN_PROGRESS,
        PERSOSUBSTATE_READY,
        PERSOSUBSTATE_SIM_NETWORK,
        PERSOSUBSTATE_SIM_NETWORK_SUBSET,
        PERSOSUBSTATE_SIM_CORPORATE,
        PERSOSUBSTATE_SIM_SERVICE_PROVIDER,
        PERSOSUBSTATE_SIM_SIM,
        PERSOSUBSTATE_SIM_NETWORK_PUK,
        PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK,
        PERSOSUBSTATE_SIM_CORPORATE_PUK,
        PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK,
        PERSOSUBSTATE_SIM_SIM_PUK,
        PERSOSUBSTATE_RUIM_NETWORK1,
        PERSOSUBSTATE_RUIM_NETWORK2,
        PERSOSUBSTATE_RUIM_HRPD,
        PERSOSUBSTATE_RUIM_CORPORATE,
        PERSOSUBSTATE_RUIM_SERVICE_PROVIDER,
        PERSOSUBSTATE_RUIM_RUIM,
        PERSOSUBSTATE_RUIM_NETWORK1_PUK,
        PERSOSUBSTATE_RUIM_NETWORK2_PUK,
        PERSOSUBSTATE_RUIM_HRPD_PUK,
        PERSOSUBSTATE_RUIM_CORPORATE_PUK,
        PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK,
        PERSOSUBSTATE_RUIM_RUIM_PUK;
        boolean isPersoSubStateUnknown() {
            return this == PERSOSUBSTATE_UNKNOWN;
        }
    }

    
}

