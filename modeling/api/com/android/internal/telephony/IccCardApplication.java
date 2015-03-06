/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.telephony.IccCardStatus.PinState;

public class IccCardApplication {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.169 -0500", hash_original_field = "89FE741B258C985E1314B428A9F949A8", hash_generated_field = "47D78C1AB52244F57090C85D69289E76")

    public AppType        app_type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.171 -0500", hash_original_field = "B0F0924A203A6481753FB7FEE92E263F", hash_generated_field = "D6FD5E302DD93A741A4A2C8F944FB4B8")

    public AppState       app_state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.173 -0500", hash_original_field = "653753E7032A71534C9A63542AD28521", hash_generated_field = "F6947369300AACC14A8C15A941199F8B")

    public PersoSubState  perso_substate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.175 -0500", hash_original_field = "F5A5D5912ABD3FC1CFE753B13648FE53", hash_generated_field = "69AACDBD897395F7281C96A5B387BF26")

    public String         aid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.178 -0500", hash_original_field = "64B084A20FC040547CC485D64B9D5ABD", hash_generated_field = "303AB67C284933C802A1515B0E391E83")

    public String         app_label;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.180 -0500", hash_original_field = "115834CBAFFFDBE6958D6F14BFB2A8F6", hash_generated_field = "59893490E117577C680150A765F6F72D")

    public int            pin1_replaced;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.182 -0500", hash_original_field = "3B52B615B76B44701F54ACC0D8FC940C", hash_generated_field = "7F505812D44B04DDE37A77ABBF13CD96")

    public PinState            pin1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.184 -0500", hash_original_field = "FB9B7FB481C594E032A97686393F322B", hash_generated_field = "63EED535159D554E4C526C446FD3803B")

    public PinState            pin2;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.984 -0400", hash_original_method = "988872E45A8DACD07B268FFABAB213D3", hash_generated_method = "988872E45A8DACD07B268FFABAB213D3")
    public IccCardApplication ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.187 -0500", hash_original_method = "1116744B87B74A8B1F94F0BFA362A158", hash_generated_method = "C1D25D6C420B7257D1B02E366679F956")
    
AppType AppTypeFromRILInt(int type) {
        AppType newType;
        /* RIL_AppType ril.h */
        switch(type) {
            case 0: newType = AppType.APPTYPE_UNKNOWN; break;
            case 1: newType = AppType.APPTYPE_SIM;     break;
            case 2: newType = AppType.APPTYPE_USIM;    break;
            case 3: newType = AppType.APPTYPE_RUIM;    break;
            case 4: newType = AppType.APPTYPE_CSIM;    break;
            case 5: newType = AppType.APPTYPE_ISIM;    break;
            default:
                throw new RuntimeException(
                            "Unrecognized RIL_AppType: " +type);
        }
        return newType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.190 -0500", hash_original_method = "9534088223FA9637F4929B2D2CEDDB5A", hash_generated_method = "2A323CFB968322038DC00D2CF87AD145")
    
AppState AppStateFromRILInt(int state) {
        AppState newState;
        /* RIL_AppState ril.h */
        switch(state) {
            case 0: newState = AppState.APPSTATE_UNKNOWN;  break;
            case 1: newState = AppState.APPSTATE_DETECTED; break;
            case 2: newState = AppState.APPSTATE_PIN; break;
            case 3: newState = AppState.APPSTATE_PUK; break;
            case 4: newState = AppState.APPSTATE_SUBSCRIPTION_PERSO; break;
            case 5: newState = AppState.APPSTATE_READY; break;
            default:
                throw new RuntimeException(
                            "Unrecognized RIL_AppState: " +state);
        }
        return newState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.193 -0500", hash_original_method = "17A43E5E3170BC2C3023BB14299D6F08", hash_generated_method = "2582E20B2AE2FF10E42D93AF798052C6")
    
PersoSubState PersoSubstateFromRILInt(int substate) {
        PersoSubState newSubState;
        /* RIL_PeroSubstate ril.h */
        switch(substate) {
            case 0:  newSubState = PersoSubState.PERSOSUBSTATE_UNKNOWN;  break;
            case 1:  newSubState = PersoSubState.PERSOSUBSTATE_IN_PROGRESS; break;
            case 2:  newSubState = PersoSubState.PERSOSUBSTATE_READY; break;
            case 3:  newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK; break;
            case 4:  newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET; break;
            case 5:  newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE; break;
            case 6:  newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER; break;
            case 7:  newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM;  break;
            case 8:  newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_PUK; break;
            case 9:  newSubState = PersoSubState.PERSOSUBSTATE_SIM_NETWORK_SUBSET_PUK; break;
            case 10: newSubState = PersoSubState.PERSOSUBSTATE_SIM_CORPORATE_PUK; break;
            case 11: newSubState = PersoSubState.PERSOSUBSTATE_SIM_SERVICE_PROVIDER_PUK; break;
            case 12: newSubState = PersoSubState.PERSOSUBSTATE_SIM_SIM_PUK; break;
            case 13: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1; break;
            case 14: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2; break;
            case 15: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD; break;
            case 16: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE; break;
            case 17: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER; break;
            case 18: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM; break;
            case 19: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK1_PUK; break;
            case 20: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_NETWORK2_PUK; break;
            case 21: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_HRPD_PUK ; break;
            case 22: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_CORPORATE_PUK; break;
            case 23: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_SERVICE_PROVIDER_PUK; break;
            case 24: newSubState = PersoSubState.PERSOSUBSTATE_RUIM_RUIM_PUK; break;
            default:
                throw new RuntimeException(
                            "Unrecognized RIL_PersoSubstate: " +substate);
        }
        return newSubState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.196 -0500", hash_original_method = "691AF073265032051E58110F3AF07370", hash_generated_method = "691AF073265032051E58110F3AF07370")
    
PinState PinStateFromRILInt(int state) {
        PinState newPinState;
        switch(state) {
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
                throw new RuntimeException("Unrecognized RIL_PinState: " + state);
        }
        return newPinState;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.198 -0500", hash_original_method = "B7A3E528A56EA330AD359B5362903D13", hash_generated_method = "596343BF45EF1C82CA18BEB071345D76")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{").append(app_type).append(",").append(app_state);
        if (app_state == AppState.APPSTATE_SUBSCRIPTION_PERSO) {
            sb.append(",").append(perso_substate);
        }
        if (app_type == AppType.APPTYPE_CSIM ||
                app_type == AppType.APPTYPE_USIM ||
                app_type == AppType.APPTYPE_ISIM) {
            sb.append(",pin1=").append(pin1);
            sb.append(",pin2=").append(pin2);
        }
        sb.append("}");
        return sb.toString();
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

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.152 -0500", hash_original_method = "2E6B69DE72FA4C9BD23004C1BF4BEA60", hash_generated_method = "2E6B69DE72FA4C9BD23004C1BF4BEA60")
            
boolean isPinRequired() {
            return this == APPSTATE_PIN;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.154 -0500", hash_original_method = "4DBCBD17869052A33CDEC13C582680B8", hash_generated_method = "4DBCBD17869052A33CDEC13C582680B8")
            
boolean isPukRequired() {
            return this == APPSTATE_PUK;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.156 -0500", hash_original_method = "285D6BC14CD1BBE21D829C0F15FFA0AC", hash_generated_method = "285D6BC14CD1BBE21D829C0F15FFA0AC")
            
boolean isSubscriptionPersoEnabled() {
            return this == APPSTATE_SUBSCRIPTION_PERSO;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.158 -0500", hash_original_method = "68C3E9D5343F7F67C611D19661C13C3D", hash_generated_method = "68C3E9D5343F7F67C611D19661C13C3D")
            
boolean isAppReady() {
            return this == APPSTATE_READY;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.160 -0500", hash_original_method = "89AC63621BEA206B932952C5477BDE27", hash_generated_method = "89AC63621BEA206B932952C5477BDE27")
            
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

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.164 -0500", hash_original_method = "E00A6ACB825F604CFE3801927570E3CD", hash_generated_method = "E00A6ACB825F604CFE3801927570E3CD")
            
boolean isPersoSubStateUnknown() {
            return this == PERSOSUBSTATE_UNKNOWN;
        }
    }
    
}

