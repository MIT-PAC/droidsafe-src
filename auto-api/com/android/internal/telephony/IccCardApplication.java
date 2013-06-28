package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.IccCardStatus.PinState;

public class IccCardApplication {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "DAFA1D6A0E85051DEC222617BBED6E45", hash_generated_field = "47D78C1AB52244F57090C85D69289E76")

    public AppType app_type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "35F1F75D96553093953B906A3299C59A", hash_generated_field = "D6FD5E302DD93A741A4A2C8F944FB4B8")

    public AppState app_state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "726B1EC6734D8EB97CF6E86F6C9DD0C2", hash_generated_field = "F6947369300AACC14A8C15A941199F8B")

    public PersoSubState perso_substate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "B99EB09924D437DBD445A146AF8C210A", hash_generated_field = "69AACDBD897395F7281C96A5B387BF26")

    public String aid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "95833BB66C8FB79A2DFA3C51CB822FFA", hash_generated_field = "303AB67C284933C802A1515B0E391E83")

    public String app_label;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "AA99B1E544B90BA3C452F9B48F9AE2C2", hash_generated_field = "59893490E117577C680150A765F6F72D")

    public int pin1_replaced;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "7C1890779D5DDA9BBB157EB3AFCFDB26", hash_generated_field = "7F505812D44B04DDE37A77ABBF13CD96")

    public PinState pin1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_field = "1CE8F9C8C598A33E655651C0899EF7BC", hash_generated_field = "63EED535159D554E4C526C446FD3803B")

    public PinState pin2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.787 -0400", hash_original_method = "988872E45A8DACD07B268FFABAB213D3", hash_generated_method = "988872E45A8DACD07B268FFABAB213D3")
    public IccCardApplication ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.789 -0400", hash_original_method = "1116744B87B74A8B1F94F0BFA362A158", hash_generated_method = "4C8EBD5BE2B857B361F76F17190A89CA")
     AppType AppTypeFromRILInt(int type) {
        AppType varB4EAC82CA7396A68D541C85D26508E83_1307602209 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1307602209 = newType;
        addTaint(type);
        varB4EAC82CA7396A68D541C85D26508E83_1307602209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307602209;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.793 -0400", hash_original_method = "9534088223FA9637F4929B2D2CEDDB5A", hash_generated_method = "11EFD85AF1152C32AE5651E27CEFE473")
     AppState AppStateFromRILInt(int state) {
        AppState varB4EAC82CA7396A68D541C85D26508E83_886776595 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_886776595 = newState;
        addTaint(state);
        varB4EAC82CA7396A68D541C85D26508E83_886776595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886776595;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.795 -0400", hash_original_method = "17A43E5E3170BC2C3023BB14299D6F08", hash_generated_method = "E63429FB5632F5D59D50721AB33C853F")
     PersoSubState PersoSubstateFromRILInt(int substate) {
        PersoSubState varB4EAC82CA7396A68D541C85D26508E83_827872112 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_827872112 = newSubState;
        addTaint(substate);
        varB4EAC82CA7396A68D541C85D26508E83_827872112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_827872112;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.797 -0400", hash_original_method = "691AF073265032051E58110F3AF07370", hash_generated_method = "8450FD8F8D87952424D89495A757EA66")
     PinState PinStateFromRILInt(int state) {
        PinState varB4EAC82CA7396A68D541C85D26508E83_490455229 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_490455229 = newPinState;
        addTaint(state);
        varB4EAC82CA7396A68D541C85D26508E83_490455229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_490455229;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.798 -0400", hash_original_method = "B7A3E528A56EA330AD359B5362903D13", hash_generated_method = "562EACAD51BFC268DDDE79ED70219919")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1086599293 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(app_type).append(",").append(app_state);
        {
            sb.append(",").append(perso_substate);
        } //End block
        {
            sb.append(",pin1=").append(pin1);
            sb.append(",pin2=").append(pin2);
        } //End block
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1086599293 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1086599293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1086599293;
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

