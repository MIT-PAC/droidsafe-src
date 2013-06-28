package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SipErrorCode {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.012 -0400", hash_original_method = "298DBB0089D5BDD0947985D624D66502", hash_generated_method = "A393C2CD781F4E1A7DF9F09461968B5C")
    private  SipErrorCode() {
        // ---------- Original Method ----------
    }

    
    public static String toString(int errorCode) {
        switch (errorCode) {
            case NO_ERROR:
                return "NO_ERROR";
            case SOCKET_ERROR:
                return "SOCKET_ERROR";
            case SERVER_ERROR:
                return "SERVER_ERROR";
            case TRANSACTION_TERMINTED:
                return "TRANSACTION_TERMINTED";
            case CLIENT_ERROR:
                return "CLIENT_ERROR";
            case TIME_OUT:
                return "TIME_OUT";
            case INVALID_REMOTE_URI:
                return "INVALID_REMOTE_URI";
            case PEER_NOT_REACHABLE:
                return "PEER_NOT_REACHABLE";
            case INVALID_CREDENTIALS:
                return "INVALID_CREDENTIALS";
            case IN_PROGRESS:
                return "IN_PROGRESS";
            case DATA_CONNECTION_LOST:
                return "DATA_CONNECTION_LOST";
            case CROSS_DOMAIN_AUTHENTICATION:
                return "CROSS_DOMAIN_AUTHENTICATION";
            case SERVER_UNREACHABLE:
                return "SERVER_UNREACHABLE";
            default:
                return "UNKNOWN";
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "1B1949A508D4DA61D498C0A487C31F8F", hash_generated_field = "B8303B3F0D63DDF614BF107FEB77E81A")

    public static final int NO_ERROR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "9B0DBAD00BA51E554AF313A8F76262DB", hash_generated_field = "3FE643A93687B79CE239885C0B039B3C")

    public static final int SOCKET_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "0D7C2E6C21C9C126A1224C37844FC868", hash_generated_field = "5942F1332FFC86CC3D93376E7AB29235")

    public static final int SERVER_ERROR = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "2DCB7859CD112B0DA7CC1CAB99FF2AD0", hash_generated_field = "B9761118F4CEC715AAD861A4CEC9700D")

    public static final int TRANSACTION_TERMINTED = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "FF370CCBDF22C5B6C4A76BD596B5A57E", hash_generated_field = "38C40191FF07615E5787E2AAD16ABBAC")

    public static final int CLIENT_ERROR = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "10051C16276423F0806D1E60DD2BFC95", hash_generated_field = "BFAA93BD971FB59C7F2E5A426DFB0872")

    public static final int TIME_OUT = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "654E6CB6F13B5B34E328E78D2EBBF969", hash_generated_field = "67AD595ABEB7CE4EA0455FB2C74C0D7C")

    public static final int INVALID_REMOTE_URI = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "2013EFB5C88DCEDD2EA1F5E647603C2F", hash_generated_field = "590AC2FC9A168726A854CA96CA9634F6")

    public static final int PEER_NOT_REACHABLE = -7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "463A40F496F05DDA693BFEE72B013C44", hash_generated_field = "CC7636B075E6496DC1A61A8AAA978EE6")

    public static final int INVALID_CREDENTIALS = -8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "FB28C1B29F84AD67FA249A7516AEB73E", hash_generated_field = "29D02A663E324073BD3BBC3D3A49E0E5")

    public static final int IN_PROGRESS = -9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "62495157DB2007CEC8B5E5EA0899C7F4", hash_generated_field = "181D182287340C7AF7B39DC638DFE7D5")

    public static final int DATA_CONNECTION_LOST = -10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "BA20A44100D6BE4348516E5C01AD20A6", hash_generated_field = "1ACA4BB723D6D9F1FDFEFC0CABD7AF64")

    public static final int CROSS_DOMAIN_AUTHENTICATION = -11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.013 -0400", hash_original_field = "6871FDBA39050FF795A879E20CD3053F", hash_generated_field = "A9745BBC56423EAFF521CF9C37D85FE5")

    public static final int SERVER_UNREACHABLE = -12;
}

