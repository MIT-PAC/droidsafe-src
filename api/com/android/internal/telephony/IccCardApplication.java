package com.android.internal.telephony;

// Droidsafe Imports
import com.android.internal.telephony.IccCardStatus.PinState;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class IccCardApplication {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "DAFA1D6A0E85051DEC222617BBED6E45", hash_generated_field = "47D78C1AB52244F57090C85D69289E76")

    public AppType app_type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "35F1F75D96553093953B906A3299C59A", hash_generated_field = "D6FD5E302DD93A741A4A2C8F944FB4B8")

    public AppState app_state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "726B1EC6734D8EB97CF6E86F6C9DD0C2", hash_generated_field = "F6947369300AACC14A8C15A941199F8B")

    public PersoSubState perso_substate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "B99EB09924D437DBD445A146AF8C210A", hash_generated_field = "69AACDBD897395F7281C96A5B387BF26")

    public String aid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "95833BB66C8FB79A2DFA3C51CB822FFA", hash_generated_field = "303AB67C284933C802A1515B0E391E83")

    public String app_label;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "AA99B1E544B90BA3C452F9B48F9AE2C2", hash_generated_field = "59893490E117577C680150A765F6F72D")

    public int pin1_replaced;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "7C1890779D5DDA9BBB157EB3AFCFDB26", hash_generated_field = "7F505812D44B04DDE37A77ABBF13CD96")

    public PinState pin1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_field = "1CE8F9C8C598A33E655651C0899EF7BC", hash_generated_field = "63EED535159D554E4C526C446FD3803B")

    public PinState pin2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_method = "988872E45A8DACD07B268FFABAB213D3", hash_generated_method = "988872E45A8DACD07B268FFABAB213D3")
    public IccCardApplication ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.985 -0400", hash_original_method = "1116744B87B74A8B1F94F0BFA362A158", hash_generated_method = "CCF75F7879D7B3D30BD9D1C43A7882F2")
     AppType AppTypeFromRILInt(int type) {
        addTaint(type);
        AppType newType;
switch(type){
        case 0:
        newType = AppType.APPTYPE_UNKNOWN;
        break;
        case 1:
        newType = AppType.APPTYPE_SIM;
        break;
        case 2:
        newType = AppType.APPTYPE_USIM;
        break;
        case 3:
        newType = AppType.APPTYPE_RUIM;
        break;
        case 4:
        newType = AppType.APPTYPE_CSIM;
        break;
        case 5:
        newType = AppType.APPTYPE_ISIM;
        break;
        default:
        RuntimeException var8F4BCDEE62E038927B0490C9190DF84F_1871685412 = new RuntimeException(
                            "Unrecognized RIL_AppType: " +type);
        var8F4BCDEE62E038927B0490C9190DF84F_1871685412.addTaint(taint);
        throw var8F4BCDEE62E038927B0490C9190DF84F_1871685412;
}AppType var8E2188952A7BCB9378EAD1CB3B12F354_1935619760 =         newType;
        var8E2188952A7BCB9378EAD1CB3B12F354_1935619760.addTaint(taint);
        return var8E2188952A7BCB9378EAD1CB3B12F354_1935619760;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.987 -0400", hash_original_method = "9534088223FA9637F4929B2D2CEDDB5A", hash_generated_method = "A8F06C4E6AAA5DF12999CF29F6C22C51")
     AppState AppStateFromRILInt(int state) {
        addTaint(state);
        AppState newState;
switch(state){
        case 0:
        newState = AppState.APPSTATE_UNKNOWN;
        break;
        case 1:
        newState = AppState.APPSTATE_DETECTED;
        break;
        case 2:
        newState = AppState.APPSTATE_PIN;
        break;
        case 3:
        newState = AppState.APPSTATE_PUK;
        break;
        case 4:
        newState = AppState.APPSTATE_SUBSCRIPTION_PERSO;
        break;
        case 5:
        newState = AppState.APPSTATE_READY;
        break;
        default:
        RuntimeException var82073CE8806FDFC447C32F2517220592_13204954 = new RuntimeException(
                            "Unrecognized RIL_AppState: " +state);
        var82073CE8806FDFC447C32F2517220592_13204954.addTaint(taint);
        throw var82073CE8806FDFC447C32F2517220592_13204954;
}AppState var31EB68C9B68454C3598B329347109187_1067986115 =         newState;
        var31EB68C9B68454C3598B329347109187_1067986115.addTaint(taint);
        return var31EB68C9B68454C3598B329347109187_1067986115;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.990 -0400", hash_original_method = "17A43E5E3170BC2C3023BB14299D6F08", hash_generated_method = "2D9CB52C83676EFCB8528F1FFE74871D")
     PersoSubState PersoSubstateFromRILInt(int substate) {
        addTaint(substate);
        PersoSubState newSubState;
switch(substate){
        case 0:
        newSubState = PersoSubState.PERSOSUBSTATE_UNKNOWN;
        break;
        case 1:
        newSubState = PersoSubState.PERSOSUBSTATE_IN_PROGRESS;
        break;
        case 2:
        newSubState = PersoSubState.PERSOSUBSTATE_READY;
        break;
        case 3:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK;
        break;
        case 4:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET;
        break;
        case 5:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE;
        break;
        case 6:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER;
        break;
        case 7:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM;
        break;
        case 8:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_PUK;
        break;
        case 9:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK;
        break;
        case 10:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE_PUK;
        break;
        case 11:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK;
        break;
        case 12:
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM_PUK;
        break;
        case 13:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1;
        break;
        case 14:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2;
        break;
        case 15:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD;
        break;
        case 16:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE;
        break;
        case 17:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER;
        break;
        case 18:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM;
        break;
        case 19:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1_PUK;
        break;
        case 20:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2_PUK;
        break;
        case 21:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD_PUK;
        break;
        case 22:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE_PUK;
        break;
        case 23:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK;
        break;
        case 24:
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM_PUK;
        break;
        default:
        RuntimeException var05189B83529D8B7A1BB7A58C84C3B9DA_442739671 = new RuntimeException(
                            "Unrecognized RIL_PersoSubstate: " +substate);
        var05189B83529D8B7A1BB7A58C84C3B9DA_442739671.addTaint(taint);
        throw var05189B83529D8B7A1BB7A58C84C3B9DA_442739671;
}PersoSubState varE34FE27A163408B374DCA10F14961DC6_1059207069 =         newSubState;
        varE34FE27A163408B374DCA10F14961DC6_1059207069.addTaint(taint);
        return varE34FE27A163408B374DCA10F14961DC6_1059207069;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.993 -0400", hash_original_method = "691AF073265032051E58110F3AF07370", hash_generated_method = "C6E4B6D29C47307719C65E4575F3C7C4")
     PinState PinStateFromRILInt(int state) {
        addTaint(state);
        PinState newPinState;
switch(state){
        case 0:
        newPinState = PinState.PINSTATE_UNKNOWN;
        break;
        case 1:
        newPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
        break;
        case 2:
        newPinState = PinState.PINSTATE_ENABLED_VERIFIED;
        break;
        case 3:
        newPinState = PinState.PINSTATE_DISABLED;
        break;
        case 4:
        newPinState = PinState.PINSTATE_ENABLED_BLOCKED;
        break;
        case 5:
        newPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
        break;
        default:
        RuntimeException varC268DAB217193013B5F1193A23F2A03C_450616448 = new RuntimeException("Unrecognized RIL_PinState: " + state);
        varC268DAB217193013B5F1193A23F2A03C_450616448.addTaint(taint);
        throw varC268DAB217193013B5F1193A23F2A03C_450616448;
}PinState var5071417210D5BE9B29FEA26318D07CF1_1055279600 =         newPinState;
        var5071417210D5BE9B29FEA26318D07CF1_1055279600.addTaint(taint);
        return var5071417210D5BE9B29FEA26318D07CF1_1055279600;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.994 -0400", hash_original_method = "B7A3E528A56EA330AD359B5362903D13", hash_generated_method = "14906F776C5E3E26841EC03685F70F3B")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(app_type).append(",").append(app_state);
        if(app_state == AppState.APPSTATE_SUBSCRIPTION_PERSO)        
        {
            sb.append(",").append(perso_substate);
        } //End block
        if(app_type == AppType.APPTYPE_CSIM ||
                app_type == AppType.APPTYPE_USIM ||
                app_type == AppType.APPTYPE_ISIM)        
        {
            sb.append(",pin1=").append(pin1);
            sb.append(",pin2=").append(pin2);
        } //End block
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_32480758 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_32480758.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_32480758;
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
        @DSModeled(DSC.SAFE)
        boolean isPinRequired() {
            return this == APPSTATE_PIN;
        }
        @DSModeled(DSC.SAFE)
        boolean isPukRequired() {
            return this == APPSTATE_PUK;
        }
        @DSModeled(DSC.SAFE)
        boolean isSubscriptionPersoEnabled() {
            return this == APPSTATE_SUBSCRIPTION_PERSO;
        }
        @DSModeled(DSC.SAFE)
        boolean isAppReady() {
            return this == APPSTATE_READY;
        }
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
        boolean isPersoSubStateUnknown() {
            return this == PERSOSUBSTATE_UNKNOWN;
        }
    }

    
}

