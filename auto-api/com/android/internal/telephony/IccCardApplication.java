package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.789 -0400", hash_original_method = "1116744B87B74A8B1F94F0BFA362A158", hash_generated_method = "4C8EBD5BE2B857B361F76F17190A89CA")
     AppType AppTypeFromRILInt(int type) {
        AppType varB4EAC82CA7396A68D541C85D26508E83_1307602209 = null; 
        AppType newType;
        
        newType = AppType.APPTYPE_UNKNOWN;
        
        
        newType = AppType.APPTYPE_SIM;
        
        
        newType = AppType.APPTYPE_USIM;
        
        
        newType = AppType.APPTYPE_RUIM;
        
        
        newType = AppType.APPTYPE_CSIM;
        
        
        newType = AppType.APPTYPE_ISIM;
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_AppType: " +type);
        
        varB4EAC82CA7396A68D541C85D26508E83_1307602209 = newType;
        addTaint(type);
        varB4EAC82CA7396A68D541C85D26508E83_1307602209.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1307602209;
        
        
        
            
            
            
            
            
            
            
                
                            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.793 -0400", hash_original_method = "9534088223FA9637F4929B2D2CEDDB5A", hash_generated_method = "11EFD85AF1152C32AE5651E27CEFE473")
     AppState AppStateFromRILInt(int state) {
        AppState varB4EAC82CA7396A68D541C85D26508E83_886776595 = null; 
        AppState newState;
        
        newState = AppState.APPSTATE_UNKNOWN;
        
        
        newState = AppState.APPSTATE_DETECTED;
        
        
        newState = AppState.APPSTATE_PIN;
        
        
        newState = AppState.APPSTATE_PUK;
        
        
        newState = AppState.APPSTATE_SUBSCRIPTION_PERSO;
        
        
        newState = AppState.APPSTATE_READY;
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_AppState: " +state);
        
        varB4EAC82CA7396A68D541C85D26508E83_886776595 = newState;
        addTaint(state);
        varB4EAC82CA7396A68D541C85D26508E83_886776595.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_886776595;
        
        
        
            
            
            
            
            
            
            
                
                            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.795 -0400", hash_original_method = "17A43E5E3170BC2C3023BB14299D6F08", hash_generated_method = "E63429FB5632F5D59D50721AB33C853F")
     PersoSubState PersoSubstateFromRILInt(int substate) {
        PersoSubState varB4EAC82CA7396A68D541C85D26508E83_827872112 = null; 
        PersoSubState newSubState;
        
        newSubState = PersoSubState.PERSOSUBSTATE_UNKNOWN;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_IN_PROGRESS;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_READY;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK;
        
        
        newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM_PUK;
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unrecognized RIL_PersoSubstate: " +substate);
        
        varB4EAC82CA7396A68D541C85D26508E83_827872112 = newSubState;
        addTaint(substate);
        varB4EAC82CA7396A68D541C85D26508E83_827872112.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_827872112;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.797 -0400", hash_original_method = "691AF073265032051E58110F3AF07370", hash_generated_method = "8450FD8F8D87952424D89495A757EA66")
     PinState PinStateFromRILInt(int state) {
        PinState varB4EAC82CA7396A68D541C85D26508E83_490455229 = null; 
        PinState newPinState;
        
        newPinState = PinState.PINSTATE_UNKNOWN;
        
        
        newPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
        
        
        newPinState = PinState.PINSTATE_ENABLED_VERIFIED;
        
        
        newPinState = PinState.PINSTATE_DISABLED;
        
        
        newPinState = PinState.PINSTATE_ENABLED_BLOCKED;
        
        
        newPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized RIL_PinState: " + state);
        
        varB4EAC82CA7396A68D541C85D26508E83_490455229 = newPinState;
        addTaint(state);
        varB4EAC82CA7396A68D541C85D26508E83_490455229.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_490455229;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.798 -0400", hash_original_method = "B7A3E528A56EA330AD359B5362903D13", hash_generated_method = "562EACAD51BFC268DDDE79ED70219919")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1086599293 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(app_type).append(",").append(app_state);
        {
            sb.append(",").append(perso_substate);
        } 
        {
            sb.append(",pin1=").append(pin1);
            sb.append(",pin2=").append(pin2);
        } 
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1086599293 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1086599293.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1086599293;
        
        
        
        
            
        
        
                
                
            
            
        
        
        
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

