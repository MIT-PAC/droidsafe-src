package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface SmsCbConstants {
    
    public static final int MESSAGE_ID_PWS_FIRST_IDENTIFIER = 0x1100;

    
    public static final int MESSAGE_ID_ETWS_TYPE_MASK       = 0xFFF8;

    
    public static final int MESSAGE_ID_ETWS_TYPE            = 0x1100;

    
    public static final int MESSAGE_ID_ETWS_EARTHQUAKE_WARNING      = 0x1100;

    
    public static final int MESSAGE_ID_ETWS_TSUNAMI_WARNING         = 0x1101;

    
    public static final int MESSAGE_ID_ETWS_EARTHQUAKE_AND_TSUNAMI_WARNING  = 0x1102;

    
    public static final int MESSAGE_ID_ETWS_TEST_MESSAGE            = 0x1103;

    
    public static final int MESSAGE_ID_ETWS_OTHER_EMERGENCY_TYPE    = 0x1104;

    
    public static final int MESSAGE_ID_CMAS_FIRST_IDENTIFIER                = 0x1112;

    
    public static final int MESSAGE_ID_CMAS_ALERT_PRESIDENTIAL_LEVEL        = 0x1112;

    
    public static final int MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_OBSERVED = 0x1113;

    
    public static final int MESSAGE_ID_CMAS_ALERT_EXTREME_IMMEDIATE_LIKELY  = 0x1114;

    
    public static final int MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_OBSERVED = 0x1115;

    
    public static final int MESSAGE_ID_CMAS_ALERT_EXTREME_EXPECTED_LIKELY   = 0x1116;

    
    public static final int MESSAGE_ID_CMAS_ALERT_SEVERE_IMMEDIATE_OBSERVED = 0x1117;

    
    public static final int MESSAGE_ID_CMAS_ALERT_SEVERE_IMMEDIATE_LIKELY   = 0x1118;

    
    public static final int MESSAGE_ID_CMAS_ALERT_SEVERE_EXPECTED_OBSERVED  = 0x1119;

    
    public static final int MESSAGE_ID_CMAS_ALERT_SEVERE_EXPECTED_LIKELY    = 0x111A;

    
    public static final int MESSAGE_ID_CMAS_ALERT_CHILD_ABDUCTION_EMERGENCY = 0x111B;

    
    public static final int MESSAGE_ID_CMAS_ALERT_REQUIRED_MONTHLY_TEST     = 0x111C;

    
    public static final int MESSAGE_ID_CMAS_ALERT_EXERCISE                  = 0x111D;

    
    public static final int MESSAGE_ID_CMAS_ALERT_OPERATOR_DEFINED_USE      = 0x111E;

    
    public static final int MESSAGE_ID_CMAS_LAST_IDENTIFIER                 = 0x112F;

    
    public static final int MESSAGE_ID_PWS_LAST_IDENTIFIER                  = 0x18FF;

    
    public static final int MESSAGE_CODE_ETWS_ACTIVATE_POPUP                = 0x100;

    
    public static final int MESSAGE_CODE_ETWS_EMERGENCY_USER_ALERT          = 0x200;

    
    public static final int ETWS_WARNING_TYPE_EARTHQUAKE                    = 0x00;

    
    public static final int ETWS_WARNING_TYPE_TSUNAMI                       = 0x01;

    
    public static final int ETWS_WARNING_TYPE_EARTHQUAKE_AND_TSUNAMI        = 0x02;

    
    public static final int ETWS_WARNING_TYPE_TEST                          = 0x03;

    
    public static final int ETWS_WARNING_TYPE_OTHER                         = 0x04;
}
