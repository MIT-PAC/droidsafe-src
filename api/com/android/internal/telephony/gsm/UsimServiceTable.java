package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import com.android.internal.telephony.IccServiceTable;





public final class UsimServiceTable extends IccServiceTable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.003 -0400", hash_original_method = "817BD5CF49BC23E6643D1124A4E1BE41", hash_generated_method = "6D7E057B1FC8F501ED71E554CCC54EE8")
    public  UsimServiceTable(byte[] table) {
        super(table);
        addTaint(table[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.004 -0400", hash_original_method = "DBA3BE1184DAC743D00CD4A8E44903BD", hash_generated_method = "9B177E920D221B77E4F5942BB224A596")
    public boolean isAvailable(UsimService service) {
        addTaint(service.getTaint());
        boolean var2EDD1F513AFE4DE46B928F411AF48E9D_962484819 = (super.isAvailable(service.ordinal()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618439212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618439212;
        // ---------- Original Method ----------
        //return super.isAvailable(service.ordinal());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.004 -0400", hash_original_method = "E87A72CCD83C43A988523404C93A686A", hash_generated_method = "AA72CE65F7035B518D9449AAFF990DFC")
    @Override
    protected String getTag() {
String var577DBB8C3CC289BB3D816ABEFC0282D3_2084780740 =         "UsimServiceTable";
        var577DBB8C3CC289BB3D816ABEFC0282D3_2084780740.addTaint(taint);
        return var577DBB8C3CC289BB3D816ABEFC0282D3_2084780740;
        // ---------- Original Method ----------
        //return "UsimServiceTable";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.004 -0400", hash_original_method = "5896C19C7C6B06EFB443A2DEA834E8BC", hash_generated_method = "0049935081E1C70776E2F72AADBE9E48")
    @Override
    protected Object[] getValues() {
Object[] var74892C36FDC595431098BEF14C91C82B_659460213 =         UsimService.values();
        var74892C36FDC595431098BEF14C91C82B_659460213.addTaint(taint);
        return var74892C36FDC595431098BEF14C91C82B_659460213;
        // ---------- Original Method ----------
        //return UsimService.values();
    }

    
    public enum UsimService {
        PHONEBOOK,
        FDN,                                
        FDN_EXTENSION,                      
        SDN,                                
        SDN_EXTENSION,                      
        BDN,                                
        BDN_EXTENSION,                      
        OUTGOING_CALL_INFO,
        INCOMING_CALL_INFO,
        SM_STORAGE,
        SM_STATUS_REPORTS,
        SM_SERVICE_PARAMS,
        ADVICE_OF_CHARGE,
        CAP_CONFIG_PARAMS_2,
        CB_MESSAGE_ID,
        CB_MESSAGE_ID_RANGES,
        GROUP_ID_LEVEL_1,
        GROUP_ID_LEVEL_2,
        SPN,                                
        USER_PLMN_SELECT,
        MSISDN,
        IMAGE,
        LOCALISED_SERVICE_AREAS,
        EMLPP,                              
        EMLPP_AUTO_ANSWER,
        RFU,
        GSM_ACCESS,
        DATA_DL_VIA_SMS_PP,
        DATA_DL_VIA_SMS_CB,
        CALL_CONTROL_BY_USIM,
        MO_SMS_CONTROL_BY_USIM,
        RUN_AT_COMMAND,
        IGNORED_1,
        ENABLED_SERVICES_TABLE,
        APN_CONTROL_LIST,
        DEPERSONALISATION_CONTROL_KEYS,
        COOPERATIVE_NETWORK_LIST,
        GSM_SECURITY_CONTEXT,
        CPBCCH_INFO,
        INVESTIGATION_SCAN,
        MEXE,
        OPERATOR_PLMN_SELECT,
        HPLMN_SELECT,
        EXTENSION_5,                        
        PLMN_NETWORK_NAME,
        OPERATOR_PLMN_LIST,
        MBDN,                               
        MWI_STATUS,                         
        CFI_STATUS,                         
        IGNORED_2,
        SERVICE_PROVIDER_DISPLAY_INFO,
        MMS_NOTIFICATION,
        MMS_NOTIFICATION_EXTENSION,         
        GPRS_CALL_CONTROL_BY_USIM,
        MMS_CONNECTIVITY_PARAMS,
        NETWORK_INDICATION_OF_ALERTING,
        VGCS_GROUP_ID_LIST,
        VBS_GROUP_ID_LIST,
        PSEUDONYM,
        IWLAN_USER_PLMN_SELECT,
        IWLAN_OPERATOR_PLMN_SELECT,
        USER_WSID_LIST,
        OPERATOR_WSID_LIST,
        VGCS_SECURITY,
        VBS_SECURITY,
        WLAN_REAUTH_IDENTITY,
        MM_STORAGE,
        GBA,                                
        MBMS_SECURITY,
        DATA_DL_VIA_USSD,
        EQUIVALENT_HPLMN,
        TERMINAL_PROFILE_AFTER_UICC_ACTIVATION,
        EQUIVALENT_HPLMN_PRESENTATION,
        LAST_RPLMN_SELECTION_INDICATION,
        OMA_BCAST_PROFILE,
        GBA_LOCAL_KEY_ESTABLISHMENT,
        TERMINAL_APPLICATIONS,
        SPN_ICON,
        PLMN_NETWORK_NAME_ICON,
        USIM_IP_CONNECTION_PARAMS,
        IWLAN_HOME_ID_LIST,
        IWLAN_EQUIVALENT_HPLMN_PRESENTATION,
        IWLAN_HPLMN_PRIORITY_INDICATION,
        IWLAN_LAST_REGISTERED_PLMN,
        EPS_MOBILITY_MANAGEMENT_INFO,
        ALLOWED_CSG_LISTS_AND_INDICATIONS,
        CALL_CONTROL_ON_EPS_PDN_CONNECTION_BY_USIM,
        HPLMN_DIRECT_ACCESS,
        ECALL_DATA,
        OPERATOR_CSG_LISTS_AND_INDICATIONS,
        SM_OVER_IP,
        CSG_DISPLAY_CONTROL,
        IMS_COMMUNICATION_CONTROL_BY_USIM,
        EXTENDED_TERMINAL_APPLICATIONS,
        UICC_ACCESS_TO_IMS,
        NAS_CONFIG_BY_USIM
    }

    
}

