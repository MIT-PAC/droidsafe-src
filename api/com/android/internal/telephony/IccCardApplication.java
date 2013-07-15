package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.IccCardStatus.PinState;

public class IccCardApplication {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "DAFA1D6A0E85051DEC222617BBED6E45", hash_generated_field = "47D78C1AB52244F57090C85D69289E76")

    public AppType app_type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "35F1F75D96553093953B906A3299C59A", hash_generated_field = "D6FD5E302DD93A741A4A2C8F944FB4B8")

    public AppState app_state;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "726B1EC6734D8EB97CF6E86F6C9DD0C2", hash_generated_field = "F6947369300AACC14A8C15A941199F8B")

    public PersoSubState perso_substate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "B99EB09924D437DBD445A146AF8C210A", hash_generated_field = "69AACDBD897395F7281C96A5B387BF26")

    public String aid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "95833BB66C8FB79A2DFA3C51CB822FFA", hash_generated_field = "303AB67C284933C802A1515B0E391E83")

    public String app_label;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "AA99B1E544B90BA3C452F9B48F9AE2C2", hash_generated_field = "59893490E117577C680150A765F6F72D")

    public int pin1_replaced;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "7C1890779D5DDA9BBB157EB3AFCFDB26", hash_generated_field = "7F505812D44B04DDE37A77ABBF13CD96")

    public PinState pin1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_field = "1CE8F9C8C598A33E655651C0899EF7BC", hash_generated_field = "63EED535159D554E4C526C446FD3803B")

    public PinState pin2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.409 -0400", hash_original_method = "988872E45A8DACD07B268FFABAB213D3", hash_generated_method = "988872E45A8DACD07B268FFABAB213D3")
    public IccCardApplication ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.410 -0400", hash_original_method = "1116744B87B74A8B1F94F0BFA362A158", hash_generated_method = "A7CC678E039FDE49B91D361FB87368BE")
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
        RuntimeException var8F4BCDEE62E038927B0490C9190DF84F_1453112985 = new RuntimeException(
                            "Unrecognized RIL_AppType: " +type);
        var8F4BCDEE62E038927B0490C9190DF84F_1453112985.addTaint(taint);
        throw var8F4BCDEE62E038927B0490C9190DF84F_1453112985;
}AppType var8E2188952A7BCB9378EAD1CB3B12F354_960278151 =         newType;
        var8E2188952A7BCB9378EAD1CB3B12F354_960278151.addTaint(taint);
        return var8E2188952A7BCB9378EAD1CB3B12F354_960278151;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.411 -0400", hash_original_method = "9534088223FA9637F4929B2D2CEDDB5A", hash_generated_method = "42216E22F9A777D9F97CFFA4567699BC")
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
        RuntimeException var82073CE8806FDFC447C32F2517220592_1165406761 = new RuntimeException(
                            "Unrecognized RIL_AppState: " +state);
        var82073CE8806FDFC447C32F2517220592_1165406761.addTaint(taint);
        throw var82073CE8806FDFC447C32F2517220592_1165406761;
}AppState var31EB68C9B68454C3598B329347109187_1682418677 =         newState;
        var31EB68C9B68454C3598B329347109187_1682418677.addTaint(taint);
        return var31EB68C9B68454C3598B329347109187_1682418677;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.414 -0400", hash_original_method = "17A43E5E3170BC2C3023BB14299D6F08", hash_generated_method = "F08293A8EA656C73BF0C2E153FDB7F97")
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
        RuntimeException var05189B83529D8B7A1BB7A58C84C3B9DA_1511621454 = new RuntimeException(
                            "Unrecognized RIL_PersoSubstate: " +substate);
        var05189B83529D8B7A1BB7A58C84C3B9DA_1511621454.addTaint(taint);
        throw var05189B83529D8B7A1BB7A58C84C3B9DA_1511621454;
}PersoSubState varE34FE27A163408B374DCA10F14961DC6_2052475586 =         newSubState;
        varE34FE27A163408B374DCA10F14961DC6_2052475586.addTaint(taint);
        return varE34FE27A163408B374DCA10F14961DC6_2052475586;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.415 -0400", hash_original_method = "691AF073265032051E58110F3AF07370", hash_generated_method = "94EF584EE0528D9E8859277D0086044F")
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
        RuntimeException varC268DAB217193013B5F1193A23F2A03C_118691981 = new RuntimeException("Unrecognized RIL_PinState: " + state);
        varC268DAB217193013B5F1193A23F2A03C_118691981.addTaint(taint);
        throw varC268DAB217193013B5F1193A23F2A03C_118691981;
}PinState var5071417210D5BE9B29FEA26318D07CF1_1893297361 =         newPinState;
        var5071417210D5BE9B29FEA26318D07CF1_1893297361.addTaint(taint);
        return var5071417210D5BE9B29FEA26318D07CF1_1893297361;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.415 -0400", hash_original_method = "B7A3E528A56EA330AD359B5362903D13", hash_generated_method = "AABCE080AA10F4BB10366961CA3D4B29")
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
String var2460B846747F8B22185AD8BE722266A5_741263392 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_741263392.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_741263392;
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

