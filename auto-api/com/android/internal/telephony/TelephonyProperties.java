package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface TelephonyProperties
{
    

    
    

    
    static final String PROPERTY_BASEBAND_VERSION = "gsm.version.baseband";

    
    static final String PROPERTY_RIL_IMPL = "gsm.version.ril-impl";

    

    
    static final String PROPERTY_OPERATOR_ALPHA = "gsm.operator.alpha";
    

    
    static final String PROPERTY_OPERATOR_NUMERIC = "gsm.operator.numeric";

    
    static final String PROPERTY_OPERATOR_ISMANUAL = "operator.ismanual";

    
    static final String PROPERTY_OPERATOR_ISROAMING = "gsm.operator.isroaming";

    
    static final String PROPERTY_OPERATOR_ISO_COUNTRY = "gsm.operator.iso-country";

    
    static final String PROPERTY_LTE_ON_CDMA_PRODUCT_TYPE = "telephony.lteOnCdmaProductType";

    
    static final String PROPERTY_LTE_ON_CDMA_DEVICE = "telephony.lteOnCdmaDevice";

    static final String CURRENT_ACTIVE_PHONE = "gsm.current.phone-type";

    
    
    static String PROPERTY_SIM_STATE = "gsm.sim.state";

    
    static String PROPERTY_ICC_OPERATOR_NUMERIC = "gsm.sim.operator.numeric";

    
    static String PROPERTY_ICC_OPERATOR_ALPHA = "gsm.sim.operator.alpha";

    
    static String PROPERTY_ICC_OPERATOR_ISO_COUNTRY = "gsm.sim.operator.iso-country";

    
    static String PROPERTY_DATA_NETWORK_TYPE = "gsm.network.type";

    
    static final String PROPERTY_INECM_MODE = "ril.cdma.inecmmode";

    
    static final String PROPERTY_ECM_EXIT_TIMER = "ro.cdma.ecmexittimer";

    
    static final String PROPERTY_IDP_STRING = "ro.cdma.idpstring";

    
    static final String PROPERTY_OTASP_NUM_SCHEMA = "ro.cdma.otaspnumschema";

    
    static final String PROPERTY_DISABLE_CALL = "ro.telephony.disable-call";

    
    static final String PROPERTY_RIL_SENDS_MULTIPLE_CALL_RING =
        "ro.telephony.call_ring.multiple";

    
    static final String PROPERTY_CALL_RING_DELAY = "ro.telephony.call_ring.delay";

    
    static final String PROPERTY_CDMA_MSG_ID = "persist.radio.cdma.msgid";

    
    static final String PROPERTY_WAKE_LOCK_TIMEOUT = "ro.ril.wake_lock_timeout";

    
    static final String PROPERTY_RESET_ON_RADIO_TECH_CHANGE = "persist.radio.reset_on_switch";

    
    static final String PROPERTY_SMS_RECEIVE = "telephony.sms.receive";

    
    static final String PROPERTY_SMS_SEND = "telephony.sms.send";

    
    static final String PROPERTY_TEST_CSIM = "persist.radio.test-csim";
}

