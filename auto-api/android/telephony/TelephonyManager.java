package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import com.android.internal.telephony.IPhoneSubInfo;
import com.android.internal.telephony.ITelephony;
import com.android.internal.telephony.ITelephonyRegistry;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.TelephonyProperties;
import java.util.List;

public class TelephonyManager {
    private static final String TAG = "TelephonyManager";
    private static Context sContext;
    private static ITelephonyRegistry sRegistry;
    private static TelephonyManager sInstance = new TelephonyManager();
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PHONE_STATE_CHANGED =
            "android.intent.action.PHONE_STATE";
    public static final String EXTRA_STATE = Phone.STATE_KEY;
    public static final String EXTRA_STATE_IDLE = Phone.State.IDLE.toString();
    public static final String EXTRA_STATE_RINGING = Phone.State.RINGING.toString();
    public static final String EXTRA_STATE_OFFHOOK = Phone.State.OFFHOOK.toString();
    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    public static final int PHONE_TYPE_NONE = Phone.PHONE_TYPE_NONE;
    public static final int PHONE_TYPE_GSM = Phone.PHONE_TYPE_GSM;
    public static final int PHONE_TYPE_CDMA = Phone.PHONE_TYPE_CDMA;
    public static final int PHONE_TYPE_SIP = Phone.PHONE_TYPE_SIP;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int SIM_STATE_UNKNOWN = 0;
    public static final int SIM_STATE_ABSENT = 1;
    public static final int SIM_STATE_PIN_REQUIRED = 2;
    public static final int SIM_STATE_PUK_REQUIRED = 3;
    public static final int SIM_STATE_NETWORK_LOCKED = 4;
    public static final int SIM_STATE_READY = 5;
    public static final int CALL_STATE_IDLE = 0;
    public static final int CALL_STATE_RINGING = 1;
    public static final int CALL_STATE_OFFHOOK = 2;
    public static final int DATA_ACTIVITY_NONE = 0x00000000;
    public static final int DATA_ACTIVITY_IN = 0x00000001;
    public static final int DATA_ACTIVITY_OUT = 0x00000002;
    public static final int DATA_ACTIVITY_INOUT = DATA_ACTIVITY_IN | DATA_ACTIVITY_OUT;
    public static final int DATA_ACTIVITY_DORMANT = 0x00000004;
    public static final int DATA_UNKNOWN        = -1;
    public static final int DATA_DISCONNECTED   = 0;
    public static final int DATA_CONNECTING     = 1;
    public static final int DATA_CONNECTED      = 2;
    public static final int DATA_SUSPENDED      = 3;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.857 -0400", hash_original_method = "D511206E864FFF32983F1CF5D1263F8B", hash_generated_method = "FAAAE969FD6E41CF7D572FA85F46935F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TelephonyManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        {
            Context appContext;
            appContext = context.getApplicationContext();
            {
                sContext = appContext;
            } //End block
            sRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
        } //End block
        // ---------- Original Method ----------
        //if (sContext == null) {
            //Context appContext = context.getApplicationContext();
            //if (appContext != null) {
                //sContext = appContext;
            //} else {
                //sContext = context;
            //}
            //sRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    //"telephony.registry"));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.857 -0400", hash_original_method = "8E4DE1903A24C15F73A151ACA155A108", hash_generated_method = "321F59299C080CCEE5E78538DAA6E881")
    @DSModeled(DSC.SAFE)
    private TelephonyManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.857 -0400", hash_original_method = "4756E71C626071838F541663B9D55856", hash_generated_method = "A0AD3490DD42A596900C87367D4C9808")
    public static TelephonyManager getDefault() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.857 -0400", hash_original_method = "CBA2DB54A66B89F7737C894703CB092B", hash_generated_method = "E1FCB911E2B442C0ADED50FCDF373B63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceSoftwareVersion() {
        try 
        {
            String varE81E12BF35239DB3B1BBC358B90FC87B_336224939 = (getSubscriberInfo().getDeviceSvn());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceSvn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "D15182A782B2311FD9923C2371701B25", hash_generated_method = "8E34DC007F836636B449963D82930637")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceId() {
        try 
        {
            String var6BFC05F7A707D74AFCA4C8BDAE17659C_1909454099 = (getSubscriberInfo().getDeviceId());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "5E61A73DD3A54D24C69E0825B273DC95", hash_generated_method = "4AE50D129E1584ECA5157AEE95F08BD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CellLocation getCellLocation() {
        try 
        {
            Bundle bundle;
            bundle = getITelephony().getCellLocation();
            CellLocation cl;
            cl = CellLocation.newFromBundle(bundle);
            {
                boolean var317C3CB3784625A6460A4542B041B297_1185795693 = (cl.isEmpty());
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return (CellLocation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //Bundle bundle = getITelephony().getCellLocation();
            //CellLocation cl = CellLocation.newFromBundle(bundle);
            //if (cl.isEmpty())
                //return null;
            //return cl;
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "6D04BBFB8BC88B77ECB40D44848A65EA", hash_generated_method = "D640335F23A4C5190CE943422EF3F78D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            getITelephony().enableLocationUpdates();
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //getITelephony().enableLocationUpdates();
        //} catch (RemoteException ex) {
        //} catch (NullPointerException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "3CD4D10099672E02B38D45C520AD59E4", hash_generated_method = "1481A0171F95075DA8150F4282555C48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            getITelephony().disableLocationUpdates();
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //getITelephony().disableLocationUpdates();
        //} catch (RemoteException ex) {
        //} catch (NullPointerException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "1B24CD9B4799B0CFE847058C4CF4C5E3", hash_generated_method = "BFEDBD260ACB7FCC468C0DC5A227F55E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        try 
        {
            List<NeighboringCellInfo> var29B9E450C857731E2C63A3F98BFFA32A_1972414174 = (getITelephony().getNeighboringCellInfo());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return (List<NeighboringCellInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getNeighboringCellInfo();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "7EF6D35F0DE2C86E385132A28BC64E8B", hash_generated_method = "FC7E57E910E9C7DBD97BFE7E18C5A7C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCurrentPhoneType() {
        try 
        {
            ITelephony telephony;
            telephony = getITelephony();
            {
                int var02112D65AFB7DC116D2A52A0D60D8BE5_1406443051 = (telephony.getActivePhoneType());
            } //End block
            {
                int var59B2E48460729F59E7A28157BAB50763_1618109353 = (getPhoneTypeFromProperty());
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_368985156 = (getPhoneTypeFromProperty());
        } //End block
        catch (NullPointerException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_1488497314 = (getPhoneTypeFromProperty());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try{
            //ITelephony telephony = getITelephony();
            //if (telephony != null) {
                //return telephony.getActivePhoneType();
            //} else {
                //return getPhoneTypeFromProperty();
            //}
        //} catch (RemoteException ex) {
            //return getPhoneTypeFromProperty();
        //} catch (NullPointerException ex) {
            //return getPhoneTypeFromProperty();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "0A507D7BB3876FB6AE8B7F4B411CB7D0", hash_generated_method = "333B0CA1F0880AFC06E4933841AA48B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPhoneType() {
        {
            boolean var3F3CAC2823D51C3CFDE7D9F95AC1D73E_1518264709 = (!isVoiceCapable());
        } //End collapsed parenthetic
        int varE671F9CAE03ACF5F8C18BEA23599BB43_347906853 = (getCurrentPhoneType());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!isVoiceCapable()) {
            //return PHONE_TYPE_NONE;
        //}
        //return getCurrentPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.858 -0400", hash_original_method = "AFA495B3EA5295146DEDE68ACDCEDE97", hash_generated_method = "3AA09AFD9CEB419C5EC1C751A3FD53FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getPhoneTypeFromProperty() {
        int type;
        type = SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    getPhoneTypeFromNetworkType());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int type =
            //SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    //getPhoneTypeFromNetworkType());
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "64BB8AD229481F016ED315B563697438", hash_generated_method = "C0FC4EDEB3B9713025273B1A8CB74023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getPhoneTypeFromNetworkType() {
        int mode;
        mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        int varF8BEC291204F8330EC3241AB87D680C0_338939923 = (PhoneFactory.getPhoneType(mode));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        //if (mode == -1)
            //return PHONE_TYPE_NONE;
        //return PhoneFactory.getPhoneType(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "832612984320BCC9B2F167CB90709724", hash_generated_method = "802E01343412EFC207D04319A7BCD00B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNetworkOperatorName() {
        String var0B1E20CE2FB2393B8360C9B5ABA3AEB4_1896611692 = (SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "C6C0AA4A9611C88887AD0284C9B9779A", hash_generated_method = "8C32990B6F0FC2FAE4146BAF7A15D451")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNetworkOperator() {
        String varA4A0280FCD86CA624B7C9F78C464E989_385479054 = (SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "B6A17594C3960A6046C8BF4D54C6D185", hash_generated_method = "32D9C2DE66F2D13DF98425072008BF89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNetworkRoaming() {
        boolean var7CCC8BA33120747ECAA380992352D963_2129343158 = ("true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return "true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "DDFD7BDCC0E0CF0AD038335E60C4F613", hash_generated_method = "912D7E1CD75C4BD1EA2AB4319A4EA91F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNetworkCountryIso() {
        String varCCD49C60776C83D3852F0FED84364355_580712005 = (SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "E55284324A887F7771FC58B52617EFF6", hash_generated_method = "9A86EB43062E597D658DEDCFC4F65130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNetworkType() {
        try 
        {
            ITelephony telephony;
            telephony = getITelephony();
            {
                int varBB3E4B10AC2DDE47109944FAD74ADA38_1269456182 = (telephony.getNetworkType());
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try{
            //ITelephony telephony = getITelephony();
            //if (telephony != null) {
                //return telephony.getNetworkType();
            //} else {
                //return NETWORK_TYPE_UNKNOWN;
            //}
        //} catch(RemoteException ex) {
            //return NETWORK_TYPE_UNKNOWN;
        //} catch (NullPointerException ex) {
            //return NETWORK_TYPE_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "FF9AEE5B15128D984AF27D921556D2E2", hash_generated_method = "6595A990C2739F8F18B3F0F0727B267C")
    public static int getNetworkClass(int networkType) {
        switch (networkType) {
            case NETWORK_TYPE_GPRS:
            case NETWORK_TYPE_EDGE:
            case NETWORK_TYPE_CDMA:
            case NETWORK_TYPE_1xRTT:
            case NETWORK_TYPE_IDEN:
                return NETWORK_CLASS_2_G;
            case NETWORK_TYPE_UMTS:
            case NETWORK_TYPE_EVDO_0:
            case NETWORK_TYPE_EVDO_A:
            case NETWORK_TYPE_HSDPA:
            case NETWORK_TYPE_HSUPA:
            case NETWORK_TYPE_HSPA:
            case NETWORK_TYPE_EVDO_B:
            case NETWORK_TYPE_EHRPD:
            case NETWORK_TYPE_HSPAP:
                return NETWORK_CLASS_3_G;
            case NETWORK_TYPE_LTE:
                return NETWORK_CLASS_4_G;
            default:
                return NETWORK_CLASS_UNKNOWN;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "2CF054408BF0643DB5F15627D9964227", hash_generated_method = "E8ED02D9150C73C225C553B9CF96E2D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNetworkTypeName() {
        String var31C5D27A2C2A2A9EDFF1D607A6783CF2_1031784887 = (getNetworkTypeName(getNetworkType()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getNetworkTypeName(getNetworkType());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.859 -0400", hash_original_method = "16F509F126A872299A1C262559222D5E", hash_generated_method = "A6761E784015C0E03C3DD0D41D1E2EED")
    public static String getNetworkTypeName(int type) {
        switch (type) {
            case NETWORK_TYPE_GPRS:
                return "GPRS";
            case NETWORK_TYPE_EDGE:
                return "EDGE";
            case NETWORK_TYPE_UMTS:
                return "UMTS";
            case NETWORK_TYPE_HSDPA:
                return "HSDPA";
            case NETWORK_TYPE_HSUPA:
                return "HSUPA";
            case NETWORK_TYPE_HSPA:
                return "HSPA";
            case NETWORK_TYPE_CDMA:
                return "CDMA";
            case NETWORK_TYPE_EVDO_0:
                return "CDMA - EvDo rev. 0";
            case NETWORK_TYPE_EVDO_A:
                return "CDMA - EvDo rev. A";
            case NETWORK_TYPE_EVDO_B:
                return "CDMA - EvDo rev. B";
            case NETWORK_TYPE_1xRTT:
                return "CDMA - 1xRTT";
            case NETWORK_TYPE_LTE:
                return "LTE";
            case NETWORK_TYPE_EHRPD:
                return "CDMA - eHRPD";
            case NETWORK_TYPE_IDEN:
                return "iDEN";
            case NETWORK_TYPE_HSPAP:
                return "HSPA+";
            default:
                return "UNKNOWN";
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "B54BEBEEDA1D514B6ED30035D8F7A17F", hash_generated_method = "349739DE4927D512A3AB2A3C9DB5B90D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasIccCard() {
        try 
        {
            boolean var74498D7060EADCB8C4F6CF6D6BE7A0FF_700904240 = (getITelephony().hasIccCard());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().hasIccCard();
        //} catch (RemoteException ex) {
            //return false;
        //} catch (NullPointerException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "09E0380F50AC76521F62251E25C950EA", hash_generated_method = "5458F0F140423B834E77047038BF8EE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSimState() {
        String prop;
        prop = SystemProperties.get(TelephonyProperties.PROPERTY_SIM_STATE);
        {
            boolean var656939FEF7D866D03F6ED0F92EBF27D3_1442197331 = ("ABSENT".equals(prop));
            {
                boolean var70CB33CEB8F4069C6140C5CFEA6752B7_1704732372 = ("PIN_REQUIRED".equals(prop));
                {
                    boolean var90FBEC75DFA1A3628B25A46F0B119AA1_2053029813 = ("PUK_REQUIRED".equals(prop));
                    {
                        boolean var5209DF38776E48B1D29ED96972A531A2_2139895855 = ("NETWORK_LOCKED".equals(prop));
                        {
                            boolean var9FFEABD8A87C0F145C76AB31A340E57B_218240202 = ("READY".equals(prop));
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //String prop = SystemProperties.get(TelephonyProperties.PROPERTY_SIM_STATE);
        //if ("ABSENT".equals(prop)) {
            //return SIM_STATE_ABSENT;
        //}
        //else if ("PIN_REQUIRED".equals(prop)) {
            //return SIM_STATE_PIN_REQUIRED;
        //}
        //else if ("PUK_REQUIRED".equals(prop)) {
            //return SIM_STATE_PUK_REQUIRED;
        //}
        //else if ("NETWORK_LOCKED".equals(prop)) {
            //return SIM_STATE_NETWORK_LOCKED;
        //}
        //else if ("READY".equals(prop)) {
            //return SIM_STATE_READY;
        //}
        //else {
            //return SIM_STATE_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "31C6D14DB3E72FC3C1A0B120DB42F405", hash_generated_method = "D05D6D8C0F66C2E93ED64C9D594EF800")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSimOperator() {
        String var8A625CF966D18ADEA183035E7E0873BE_106557658 = (SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "FF7B2BB8165B4DA3F4CA04B0E402231E", hash_generated_method = "B9B6FA10252D3616B34F21B4BC912E74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSimOperatorName() {
        String var8CD9D538CD280BE4462FC81843AAB3CA_1881096860 = (SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "86E21142AD28646E6483CDE3D9BD89F9", hash_generated_method = "27F1E2067584364DB700DF99C94B6555")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSimCountryIso() {
        String varF182A847E6E2DED73C605B5632D80B84_2110736843 = (SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "2017CBA66707D72E2F76A9954FAEDD18", hash_generated_method = "A87EB91DD96CF924F9AF74970970FDAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSimSerialNumber() {
        try 
        {
            String varDA33D15963BFC452F88C21F90E8E9AFA_111232436 = (getSubscriberInfo().getIccSerialNumber());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIccSerialNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "EA3A591F5FC8CB370CDC207E1A4A9D6A", hash_generated_method = "5B08A409EFDD75D284284475EC3C3AAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLteOnCdmaMode() {
        try 
        {
            int var29B7AA8EB74FFF815EDF62F09C7A13DE_174506023 = (getITelephony().getLteOnCdmaMode());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getLteOnCdmaMode();
        //} catch (RemoteException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //} catch (NullPointerException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.860 -0400", hash_original_method = "E78B911A34E3B997234FCD2FE0581326", hash_generated_method = "52C78644F071E55E54CC0386EF9206C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        try 
        {
            String varB54CF45EEE4F3929EE0452AA133CFC8D_273790184 = (getSubscriberInfo().getSubscriberId());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getSubscriberId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "EE92449D081C56B70CB6173E1BAAB538", hash_generated_method = "29E7043B1410C18EBECE555D17902D5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        try 
        {
            String var9E0A9817C5681D19C988636B223EF11C_665426297 = (getSubscriberInfo().getLine1Number());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1Number();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "7B70034F9FC00AD85A334A6B1881279C", hash_generated_method = "E9E736FC532C6EA202CB772AFD302EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1AlphaTag() {
        try 
        {
            String var59C227E5418090773228B489C261897B_755431977 = (getSubscriberInfo().getLine1AlphaTag());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1AlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "FE1089A80F0C63E9B1494FCF93B412E1", hash_generated_method = "E8ACF5456CA1613FF16245253EF1114D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMsisdn() {
        try 
        {
            String var445C3495149D1A10530D39CE54717529_2091406054 = (getSubscriberInfo().getMsisdn());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getMsisdn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "8E528B053F49E44E27934FB8B1D79754", hash_generated_method = "F5887BC5A5E800F25E9D261D5D82F72C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        try 
        {
            String varC86B41263907FB0C20A5C0072D995633_810110187 = (getSubscriberInfo().getVoiceMailNumber());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "6E4CD5DF61F1B6B4D99C4D48EBD42C25", hash_generated_method = "5B7F72A0398077B103E06DACB5844149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCompleteVoiceMailNumber() {
        try 
        {
            String var6297632288FB4DD2D98A4D9100FFAF39_1781099168 = (getSubscriberInfo().getCompleteVoiceMailNumber());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getCompleteVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "8799C29F83D6241F3339A57C480A2568", hash_generated_method = "EB9CA41905EC6E1A0E82392E1F06C08A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVoiceMessageCount() {
        try 
        {
            int var597A31B7365C84A57CFAEE70B622FC99_1275528186 = (getITelephony().getVoiceMessageCount());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getVoiceMessageCount();
        //} catch (RemoteException ex) {
            //return 0;
        //} catch (NullPointerException ex) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "FCB9C7AA008FFD71198739B23DB8A42C", hash_generated_method = "4C5AF003A62A7C90B918909D399F8F80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        try 
        {
            String varD3C3A7097F27920CF264F2F6C37F3E09_328760093 = (getSubscriberInfo().getVoiceMailAlphaTag());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailAlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "2827FC9BCC152817C9894DF874687A19", hash_generated_method = "15145EB199FB332E752665F821501F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsimImpi() {
        try 
        {
            String var88477F30E6639256CA6E148EBC56EB0F_100217872 = (getSubscriberInfo().getIsimImpi());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpi();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.861 -0400", hash_original_method = "F4F2A7557A78EB2E07FE0C129F86CDF8", hash_generated_method = "466D6F229937597426383E473DD443F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsimDomain() {
        try 
        {
            String varB6572D5345DBE2B6D92EA89AB3EA6E5E_378052573 = (getSubscriberInfo().getIsimDomain());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimDomain();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "87EA21FFDB592BB220CD2250977D3D81", hash_generated_method = "E29ADC9E8FF3B80136D01319C7DB7726")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getIsimImpu() {
        try 
        {
            String[] varC299A9BBB7B8D0B2A91CF84CCA98183F_795443378 = (getSubscriberInfo().getIsimImpu());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpu();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "0499CDF49B310038A9BEEA0F802EAB63", hash_generated_method = "4BEB9C3161950038A13DA9729E4B93B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IPhoneSubInfo getSubscriberInfo() {
        IPhoneSubInfo varCE80783B6EBC7B17FF73129C5B2A95F5_501561592 = (IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo")));
        return (IPhoneSubInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "74E55F6F5CD1551C04A2C40DCD1EBD15", hash_generated_method = "F62451C84C80CE4133FA7BC8EEB9E4C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCallState() {
        try 
        {
            int var11FDA2929718CED1A97BBEADDCB6295E_1885380150 = (getITelephony().getCallState());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCallState();
        //} catch (RemoteException ex) {
            //return CALL_STATE_IDLE;
        //} catch (NullPointerException ex) {
          //return CALL_STATE_IDLE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "59E4B9880A04B49AB5E7CF82F18425E1", hash_generated_method = "B6F444D61855CAE77BFAEEAEC0E3D5D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDataActivity() {
        try 
        {
            int var942CC87DE49A18402BCD05EEE3CD1C3D_457136696 = (getITelephony().getDataActivity());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataActivity();
        //} catch (RemoteException ex) {
            //return DATA_ACTIVITY_NONE;
        //} catch (NullPointerException ex) {
          //return DATA_ACTIVITY_NONE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "37205A4CB7441E0871F6B86EF9BDA019", hash_generated_method = "CC03D2F7E50F572707CE2EE2432402F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDataState() {
        try 
        {
            int var914C29C6BEDE622C1C17EC919700D468_811116147 = (getITelephony().getDataState());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataState();
        //} catch (RemoteException ex) {
            //return DATA_DISCONNECTED;
        //} catch (NullPointerException ex) {
            //return DATA_DISCONNECTED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "7D101ED42BB684AED8CB9AC1B352231C", hash_generated_method = "E7153BE664FB8BE398F3A84DC179CA55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ITelephony getITelephony() {
        ITelephony var8F913E9DB9D5FA49FBA69AC926C02B9F_1347628544 = (ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE)));
        return (ITelephony)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "DC9C0A2F940DF23145CA1F74B7CF66E6", hash_generated_method = "A8DAC40330CEC4C420220FCBE87FDDE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void listen(PhoneStateListener listener, int events) {
        dsTaint.addTaint(events);
        dsTaint.addTaint(listener.dsTaint);
        String pkgForDebug;
        pkgForDebug = sContext.getPackageName();
        pkgForDebug = "<unknown>";
        try 
        {
            Boolean notifyNow;
            notifyNow = (getITelephony() != null);
            sRegistry.listen(pkgForDebug, listener.callback, events, notifyNow);
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        // ---------- Original Method ----------
        //String pkgForDebug = sContext != null ? sContext.getPackageName() : "<unknown>";
        //try {
            //Boolean notifyNow = (getITelephony() != null);
            //sRegistry.listen(pkgForDebug, listener.callback, events, notifyNow);
        //} catch (RemoteException ex) {
        //} catch (NullPointerException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.862 -0400", hash_original_method = "94E639A6342206A666A9E9E564D3D41F", hash_generated_method = "258C4EEBF96628140CFDA728CC9918DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconIndex() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            int var0DE1842BE7731F45B9E40B3EAE1DF080_1167194308 = (getITelephony().getCdmaEriIconIndex());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconIndex();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.863 -0400", hash_original_method = "6E310C99A0183EA336ABBF86E9A26569", hash_generated_method = "F28582115B54F816757F0C64159B82B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCdmaEriIconMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        try 
        {
            int var2E431383FA9B43BC42A9105446DC5E3E_585542806 = (getITelephony().getCdmaEriIconMode());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconMode();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.863 -0400", hash_original_method = "70A8AFAFA7F0416F83BF728E9A3EFD1C", hash_generated_method = "215177CE939C5F10EB37AA90094C9E0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaEriText() {
        try 
        {
            String var4F1D125AC6D46978093F0747A5C379BA_819006874 = (getITelephony().getCdmaEriText());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriText();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.863 -0400", hash_original_method = "691764E468F6F648007F4B86271FE09B", hash_generated_method = "4C044DB21AE7088BFC2580C153745C7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isVoiceCapable() {
        boolean var2A02B989ADE5F351F5FC8A1EAED6F4D2_1937215372 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_voice_capable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.863 -0400", hash_original_method = "FA08C86737C7918898577956B7BAC60B", hash_generated_method = "C2A8C90288F90232181D90FEEDFA4B71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSmsCapable() {
        boolean var0F7ADAF88B8AB318218711339F43AFAA_1597200490 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_sms_capable));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_sms_capable);
    }

    
}


