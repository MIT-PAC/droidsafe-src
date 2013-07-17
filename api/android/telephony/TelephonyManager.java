package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.154 -0400", hash_original_method = "D511206E864FFF32983F1CF5D1263F8B", hash_generated_method = "671A04B5F81D083472AEAA5971BF0DB9")
    public  TelephonyManager(Context context) {
        addTaint(context.getTaint());
        if(sContext == null)        
        {
            Context appContext = context.getApplicationContext();
            if(appContext != null)            
            {
                sContext = appContext;
            } //End block
            else
            {
                sContext = context;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.154 -0400", hash_original_method = "8E4DE1903A24C15F73A151ACA155A108", hash_generated_method = "ED16BD9217E0E1C9750C925EEB9F2C13")
    private  TelephonyManager() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static TelephonyManager getDefault() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.154 -0400", hash_original_method = "CBA2DB54A66B89F7737C894703CB092B", hash_generated_method = "DF0720F0BB233A020213FEC02F66AF15")
    public String getDeviceSoftwareVersion() {
        try 
        {
String var92E11FB3A5ACDBA36DC262A645834C01_888468870 =             getSubscriberInfo().getDeviceSvn();
            var92E11FB3A5ACDBA36DC262A645834C01_888468870.addTaint(taint);
            return var92E11FB3A5ACDBA36DC262A645834C01_888468870;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_120095014 =             null;
            var540C13E9E156B687226421B24F2DF178_120095014.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_120095014;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1581335539 =             null;
            var540C13E9E156B687226421B24F2DF178_1581335539.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1581335539;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceSvn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.154 -0400", hash_original_method = "D15182A782B2311FD9923C2371701B25", hash_generated_method = "2F82F9E46C7C9249809F5735E42DC3A0")
    public String getDeviceId() {
        try 
        {
String var258DFF02E73F62A381FDA0D0FEF65321_974448682 =             getSubscriberInfo().getDeviceId();
            var258DFF02E73F62A381FDA0D0FEF65321_974448682.addTaint(taint);
            return var258DFF02E73F62A381FDA0D0FEF65321_974448682;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1687592787 =             null;
            var540C13E9E156B687226421B24F2DF178_1687592787.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1687592787;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1238630440 =             null;
            var540C13E9E156B687226421B24F2DF178_1238630440.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1238630440;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.154 -0400", hash_original_method = "5E61A73DD3A54D24C69E0825B273DC95", hash_generated_method = "E6B565049975B705BEFB37634AF165E9")
    public CellLocation getCellLocation() {
        try 
        {
            Bundle bundle = getITelephony().getCellLocation();
            CellLocation cl = CellLocation.newFromBundle(bundle);
            if(cl.isEmpty())            
            {
CellLocation var540C13E9E156B687226421B24F2DF178_1955402202 =             null;
            var540C13E9E156B687226421B24F2DF178_1955402202.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1955402202;
            }
CellLocation var8C6A66A89969D061B1ECE468EDE00B0A_447985444 =             cl;
            var8C6A66A89969D061B1ECE468EDE00B0A_447985444.addTaint(taint);
            return var8C6A66A89969D061B1ECE468EDE00B0A_447985444;
        } //End block
        catch (RemoteException ex)
        {
CellLocation var540C13E9E156B687226421B24F2DF178_692618711 =             null;
            var540C13E9E156B687226421B24F2DF178_692618711.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_692618711;
        } //End block
        catch (NullPointerException ex)
        {
CellLocation var540C13E9E156B687226421B24F2DF178_1364971876 =             null;
            var540C13E9E156B687226421B24F2DF178_1364971876.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1364971876;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.154 -0400", hash_original_method = "6D04BBFB8BC88B77ECB40D44848A65EA", hash_generated_method = "AEF5BF399653C75F15EA0BA852EC07C8")
    public void enableLocationUpdates() {
        try 
        {
            getITelephony().enableLocationUpdates();
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        catch (NullPointerException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //getITelephony().enableLocationUpdates();
        //} catch (RemoteException ex) {
        //} catch (NullPointerException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.155 -0400", hash_original_method = "3CD4D10099672E02B38D45C520AD59E4", hash_generated_method = "9245D8C58546D0D45F85A5A33D96A37C")
    public void disableLocationUpdates() {
        try 
        {
            getITelephony().disableLocationUpdates();
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        catch (NullPointerException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //getITelephony().disableLocationUpdates();
        //} catch (RemoteException ex) {
        //} catch (NullPointerException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.155 -0400", hash_original_method = "1B24CD9B4799B0CFE847058C4CF4C5E3", hash_generated_method = "2F2E1D1FC92ED7E11207A24677230B56")
    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        try 
        {
List<NeighboringCellInfo> var5A9F94DE5778407204A51AFEA855C7DC_1866206928 =             getITelephony().getNeighboringCellInfo();
            var5A9F94DE5778407204A51AFEA855C7DC_1866206928.addTaint(taint);
            return var5A9F94DE5778407204A51AFEA855C7DC_1866206928;
        } //End block
        catch (RemoteException ex)
        {
List<NeighboringCellInfo> var540C13E9E156B687226421B24F2DF178_1958093242 =             null;
            var540C13E9E156B687226421B24F2DF178_1958093242.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1958093242;
        } //End block
        catch (NullPointerException ex)
        {
List<NeighboringCellInfo> var540C13E9E156B687226421B24F2DF178_1568041383 =             null;
            var540C13E9E156B687226421B24F2DF178_1568041383.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1568041383;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getNeighboringCellInfo();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.155 -0400", hash_original_method = "7EF6D35F0DE2C86E385132A28BC64E8B", hash_generated_method = "E169B0E41078CDC23FED1BBDCCA5BC4B")
    public int getCurrentPhoneType() {
        try 
        {
            ITelephony telephony = getITelephony();
            if(telephony != null)            
            {
                int var207C7D40C8911F113054424D1DF5069F_1420603690 = (telephony.getActivePhoneType());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058758926 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058758926;
            } //End block
            else
            {
                int var5BBA19BD841898DA2F7C5FCD1995F1E4_382690156 = (getPhoneTypeFromProperty());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892633123 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892633123;
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            int var5BBA19BD841898DA2F7C5FCD1995F1E4_1823978013 = (getPhoneTypeFromProperty());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265754371 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265754371;
        } //End block
        catch (NullPointerException ex)
        {
            int var5BBA19BD841898DA2F7C5FCD1995F1E4_791372169 = (getPhoneTypeFromProperty());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212330428 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212330428;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.155 -0400", hash_original_method = "0A507D7BB3876FB6AE8B7F4B411CB7D0", hash_generated_method = "9B8F28BC528FD34B08B06ACD429E0E71")
    public int getPhoneType() {
        if(!isVoiceCapable())        
        {
            int var933A3EEBF382A8DB3F7AE8DB1A497E51_514395085 = (PHONE_TYPE_NONE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284892807 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284892807;
        } //End block
        int varFFB10A25E36ACDE8671CA3C5A340AF1F_1862108443 = (getCurrentPhoneType());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289846845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289846845;
        // ---------- Original Method ----------
        //if (!isVoiceCapable()) {
            //return PHONE_TYPE_NONE;
        //}
        //return getCurrentPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.155 -0400", hash_original_method = "AFA495B3EA5295146DEDE68ACDCEDE97", hash_generated_method = "7957B7A7545D9308F3A972188495D9F0")
    private int getPhoneTypeFromProperty() {
        int type = SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    getPhoneTypeFromNetworkType());
        int var599DCCE2998A6B40B1E38E8C6006CB0A_1563579172 = (type);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153055548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153055548;
        // ---------- Original Method ----------
        //int type =
            //SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    //getPhoneTypeFromNetworkType());
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.155 -0400", hash_original_method = "64BB8AD229481F016ED315B563697438", hash_generated_method = "3B225ED48B4CB6EF92B4FB2936321C8C")
    private int getPhoneTypeFromNetworkType() {
        int mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        if(mode == -1)        
        {
        int var933A3EEBF382A8DB3F7AE8DB1A497E51_494110244 = (PHONE_TYPE_NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462124625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_462124625;
        }
        int varCC211E12A4E547D75008B3BFB24C1145_335148941 = (PhoneFactory.getPhoneType(mode));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333612818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333612818;
        // ---------- Original Method ----------
        //int mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        //if (mode == -1)
            //return PHONE_TYPE_NONE;
        //return PhoneFactory.getPhoneType(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.155 -0400", hash_original_method = "832612984320BCC9B2F167CB90709724", hash_generated_method = "5BEA032E43555BD380F25E43E9E251D0")
    public String getNetworkOperatorName() {
String var73871D1FF3E9D719EECB3335948F1CDC_1619887314 =         SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
        var73871D1FF3E9D719EECB3335948F1CDC_1619887314.addTaint(taint);
        return var73871D1FF3E9D719EECB3335948F1CDC_1619887314;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.156 -0400", hash_original_method = "C6C0AA4A9611C88887AD0284C9B9779A", hash_generated_method = "1E55AFC0F3D2BA370890537AAAB67C81")
    public String getNetworkOperator() {
String var94807E458B4F9DA7EDF532B6F1F6CC70_1594677364 =         SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
        var94807E458B4F9DA7EDF532B6F1F6CC70_1594677364.addTaint(taint);
        return var94807E458B4F9DA7EDF532B6F1F6CC70_1594677364;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.156 -0400", hash_original_method = "B6A17594C3960A6046C8BF4D54C6D185", hash_generated_method = "47B66A678ECCCF5C75A557666E632760")
    public boolean isNetworkRoaming() {
        boolean varDC2EE143E8D8E20973281D90126C9E6B_1610347991 = ("true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637264320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_637264320;
        // ---------- Original Method ----------
        //return "true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.156 -0400", hash_original_method = "DDFD7BDCC0E0CF0AD038335E60C4F613", hash_generated_method = "7F1C296832E670833E3999C803665730")
    public String getNetworkCountryIso() {
String var8CFF43696043E49880EFA10219C0A265_1897502486 =         SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
        var8CFF43696043E49880EFA10219C0A265_1897502486.addTaint(taint);
        return var8CFF43696043E49880EFA10219C0A265_1897502486;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.156 -0400", hash_original_method = "E55284324A887F7771FC58B52617EFF6", hash_generated_method = "61905D2DE1E9BF90424E3BDC55BC0646")
    public int getNetworkType() {
        try 
        {
            ITelephony telephony = getITelephony();
            if(telephony != null)            
            {
                int varC3F1D1F3FD401BD68E763D59BF81C9D4_565500016 = (telephony.getNetworkType());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137223473 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137223473;
            } //End block
            else
            {
                int var6D35B307BC3AEF80DFCB303E8C106287_71286128 = (NETWORK_TYPE_UNKNOWN);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947182383 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947182383;
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            int var6D35B307BC3AEF80DFCB303E8C106287_1328080325 = (NETWORK_TYPE_UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920079438 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920079438;
        } //End block
        catch (NullPointerException ex)
        {
            int var6D35B307BC3AEF80DFCB303E8C106287_256084658 = (NETWORK_TYPE_UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943509036 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943509036;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.156 -0400", hash_original_method = "2CF054408BF0643DB5F15627D9964227", hash_generated_method = "9916AB880BE4C52D2FDF290D0146C238")
    public String getNetworkTypeName() {
String var92831851986B8D91B76559793762AEFE_1096516752 =         getNetworkTypeName(getNetworkType());
        var92831851986B8D91B76559793762AEFE_1096516752.addTaint(taint);
        return var92831851986B8D91B76559793762AEFE_1096516752;
        // ---------- Original Method ----------
        //return getNetworkTypeName(getNetworkType());
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.157 -0400", hash_original_method = "B54BEBEEDA1D514B6ED30035D8F7A17F", hash_generated_method = "EE30375A85E5A705C460D66A2458BAFC")
    public boolean hasIccCard() {
        try 
        {
            boolean varF83DB46E6BE3F596A2204CF762E5714B_2037119971 = (getITelephony().hasIccCard());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110305868 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110305868;
        } //End block
        catch (RemoteException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_258100093 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052964250 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052964250;
        } //End block
        catch (NullPointerException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1334999329 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009654960 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009654960;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().hasIccCard();
        //} catch (RemoteException ex) {
            //return false;
        //} catch (NullPointerException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.157 -0400", hash_original_method = "09E0380F50AC76521F62251E25C950EA", hash_generated_method = "9A49B78C5A29104BAD090C7D812BC8FF")
    public int getSimState() {
        String prop = SystemProperties.get(TelephonyProperties.PROPERTY_SIM_STATE);
        if("ABSENT".equals(prop))        
        {
            int var310859A914E1FF7D8D3B6DCF9FEC27D5_1547702956 = (SIM_STATE_ABSENT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691863854 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691863854;
        } //End block
        else
        if("PIN_REQUIRED".equals(prop))        
        {
            int varEAAA7869D7A4FDD6E0D342001CDB3F78_1057877097 = (SIM_STATE_PIN_REQUIRED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448572837 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_448572837;
        } //End block
        else
        if("PUK_REQUIRED".equals(prop))        
        {
            int var33EAD433ED01A985171371F88F25466E_1280998019 = (SIM_STATE_PUK_REQUIRED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927939413 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927939413;
        } //End block
        else
        if("NETWORK_LOCKED".equals(prop))        
        {
            int var61C51B26F8E195647CE4265C60EE96AD_2028501915 = (SIM_STATE_NETWORK_LOCKED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1872610121 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1872610121;
        } //End block
        else
        if("READY".equals(prop))        
        {
            int var68898ABDFAF17764D66A814C17D4CA91_1221528132 = (SIM_STATE_READY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749858362 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749858362;
        } //End block
        else
        {
            int var4E0AE99BC80B48CCA9518F22A8A64586_665104639 = (SIM_STATE_UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855284419 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855284419;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.157 -0400", hash_original_method = "31C6D14DB3E72FC3C1A0B120DB42F405", hash_generated_method = "8C791C32057FBCC9B94C7F9D29CF5719")
    public String getSimOperator() {
String varE0D8DCFEB481C5F1DA67FE16D1AE487D_278225242 =         SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
        varE0D8DCFEB481C5F1DA67FE16D1AE487D_278225242.addTaint(taint);
        return varE0D8DCFEB481C5F1DA67FE16D1AE487D_278225242;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.157 -0400", hash_original_method = "FF7B2BB8165B4DA3F4CA04B0E402231E", hash_generated_method = "01518760ACC38F6D35B19266C84483A9")
    public String getSimOperatorName() {
String varAAD94F657014223D99B4CB3AB4E39386_2119626498 =         SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
        varAAD94F657014223D99B4CB3AB4E39386_2119626498.addTaint(taint);
        return varAAD94F657014223D99B4CB3AB4E39386_2119626498;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.157 -0400", hash_original_method = "86E21142AD28646E6483CDE3D9BD89F9", hash_generated_method = "81D4AD001B8F02A5A259B8B8D8139F49")
    public String getSimCountryIso() {
String var1D4558181D427765E58D96BCE70EB4D2_1913292237 =         SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
        var1D4558181D427765E58D96BCE70EB4D2_1913292237.addTaint(taint);
        return var1D4558181D427765E58D96BCE70EB4D2_1913292237;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.157 -0400", hash_original_method = "2017CBA66707D72E2F76A9954FAEDD18", hash_generated_method = "B7D5E2E6898EADDA80A82F154E7DD1E3")
    public String getSimSerialNumber() {
        try 
        {
String varC07CA9B8ACF6FBB55A1905C372F44A2C_1628442498 =             getSubscriberInfo().getIccSerialNumber();
            varC07CA9B8ACF6FBB55A1905C372F44A2C_1628442498.addTaint(taint);
            return varC07CA9B8ACF6FBB55A1905C372F44A2C_1628442498;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1975523386 =             null;
            var540C13E9E156B687226421B24F2DF178_1975523386.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1975523386;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1788220485 =             null;
            var540C13E9E156B687226421B24F2DF178_1788220485.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1788220485;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIccSerialNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.157 -0400", hash_original_method = "EA3A591F5FC8CB370CDC207E1A4A9D6A", hash_generated_method = "E35C68D3DE7BB063D4BA261527A96E72")
    public int getLteOnCdmaMode() {
        try 
        {
            int var8D5C79ED7FDF1504D237906C08876124_1074984674 = (getITelephony().getLteOnCdmaMode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584141525 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584141525;
        } //End block
        catch (RemoteException ex)
        {
            int var85561970C7F35EF1CB0B14D4B853BD1F_591288804 = (Phone.LTE_ON_CDMA_UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1770933889 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1770933889;
        } //End block
        catch (NullPointerException ex)
        {
            int var85561970C7F35EF1CB0B14D4B853BD1F_1500020608 = (Phone.LTE_ON_CDMA_UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982746028 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982746028;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getLteOnCdmaMode();
        //} catch (RemoteException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //} catch (NullPointerException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.158 -0400", hash_original_method = "E78B911A34E3B997234FCD2FE0581326", hash_generated_method = "A4EB60070F0EC0F2E78BB6DE0076A258")
    public String getSubscriberId() {
        try 
        {
String varB158F957286FF2E581DA89AD3BAA5EA6_1987642099 =             getSubscriberInfo().getSubscriberId();
            varB158F957286FF2E581DA89AD3BAA5EA6_1987642099.addTaint(taint);
            return varB158F957286FF2E581DA89AD3BAA5EA6_1987642099;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1350518250 =             null;
            var540C13E9E156B687226421B24F2DF178_1350518250.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1350518250;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1781857336 =             null;
            var540C13E9E156B687226421B24F2DF178_1781857336.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1781857336;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getSubscriberId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.158 -0400", hash_original_method = "EE92449D081C56B70CB6173E1BAAB538", hash_generated_method = "76EC47955AB418FDC529A0CA1AA07CEB")
    public String getLine1Number() {
        try 
        {
String var983498833C06A525878EEFCDB264A0CB_1592295250 =             getSubscriberInfo().getLine1Number();
            var983498833C06A525878EEFCDB264A0CB_1592295250.addTaint(taint);
            return var983498833C06A525878EEFCDB264A0CB_1592295250;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_63730682 =             null;
            var540C13E9E156B687226421B24F2DF178_63730682.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_63730682;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1827927206 =             null;
            var540C13E9E156B687226421B24F2DF178_1827927206.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1827927206;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1Number();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.158 -0400", hash_original_method = "7B70034F9FC00AD85A334A6B1881279C", hash_generated_method = "A96F32B60E09E5C04344B60C3B612117")
    public String getLine1AlphaTag() {
        try 
        {
String var5DB8D4BD6E6FC520259D22B155656688_419849976 =             getSubscriberInfo().getLine1AlphaTag();
            var5DB8D4BD6E6FC520259D22B155656688_419849976.addTaint(taint);
            return var5DB8D4BD6E6FC520259D22B155656688_419849976;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_771688235 =             null;
            var540C13E9E156B687226421B24F2DF178_771688235.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_771688235;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_903857518 =             null;
            var540C13E9E156B687226421B24F2DF178_903857518.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_903857518;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1AlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.158 -0400", hash_original_method = "FE1089A80F0C63E9B1494FCF93B412E1", hash_generated_method = "E5B16BD4F17C4CFF692A6E5979C040C2")
    public String getMsisdn() {
        try 
        {
String var28DE8B75CFEF55CC92B40A66094DEA13_308394645 =             getSubscriberInfo().getMsisdn();
            var28DE8B75CFEF55CC92B40A66094DEA13_308394645.addTaint(taint);
            return var28DE8B75CFEF55CC92B40A66094DEA13_308394645;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_2040346268 =             null;
            var540C13E9E156B687226421B24F2DF178_2040346268.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2040346268;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_930274120 =             null;
            var540C13E9E156B687226421B24F2DF178_930274120.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_930274120;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getMsisdn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.158 -0400", hash_original_method = "8E528B053F49E44E27934FB8B1D79754", hash_generated_method = "0E24DDC9562A703EF624BE7FD4065598")
    public String getVoiceMailNumber() {
        try 
        {
String varEEDDBA2EC557565748B47A89CA9CD41F_932842500 =             getSubscriberInfo().getVoiceMailNumber();
            varEEDDBA2EC557565748B47A89CA9CD41F_932842500.addTaint(taint);
            return varEEDDBA2EC557565748B47A89CA9CD41F_932842500;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_2107470187 =             null;
            var540C13E9E156B687226421B24F2DF178_2107470187.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2107470187;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_580310475 =             null;
            var540C13E9E156B687226421B24F2DF178_580310475.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_580310475;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.158 -0400", hash_original_method = "6E4CD5DF61F1B6B4D99C4D48EBD42C25", hash_generated_method = "4F3F5E9645FC20644D1F833BB017F60B")
    public String getCompleteVoiceMailNumber() {
        try 
        {
String varAC9D7B026F058803907DA664ED69D865_1612410472 =             getSubscriberInfo().getCompleteVoiceMailNumber();
            varAC9D7B026F058803907DA664ED69D865_1612410472.addTaint(taint);
            return varAC9D7B026F058803907DA664ED69D865_1612410472;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_93980360 =             null;
            var540C13E9E156B687226421B24F2DF178_93980360.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_93980360;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1452042339 =             null;
            var540C13E9E156B687226421B24F2DF178_1452042339.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1452042339;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getCompleteVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.159 -0400", hash_original_method = "8799C29F83D6241F3339A57C480A2568", hash_generated_method = "32DC9AB0EF4E945A2FF9C67574726B49")
    public int getVoiceMessageCount() {
        try 
        {
            int var78722B9D5687BE8E31F3703D63503553_1262938341 = (getITelephony().getVoiceMessageCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119450408 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119450408;
        } //End block
        catch (RemoteException ex)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_241888514 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960362355 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960362355;
        } //End block
        catch (NullPointerException ex)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_456760714 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222918624 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222918624;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getVoiceMessageCount();
        //} catch (RemoteException ex) {
            //return 0;
        //} catch (NullPointerException ex) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.159 -0400", hash_original_method = "FCB9C7AA008FFD71198739B23DB8A42C", hash_generated_method = "0C52EE42C15013B7EF3A8B43465F0B07")
    public String getVoiceMailAlphaTag() {
        try 
        {
String var60728D46261C57D7990E1218012D2E2A_973864519 =             getSubscriberInfo().getVoiceMailAlphaTag();
            var60728D46261C57D7990E1218012D2E2A_973864519.addTaint(taint);
            return var60728D46261C57D7990E1218012D2E2A_973864519;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_582756728 =             null;
            var540C13E9E156B687226421B24F2DF178_582756728.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_582756728;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_746235509 =             null;
            var540C13E9E156B687226421B24F2DF178_746235509.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_746235509;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailAlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.159 -0400", hash_original_method = "2827FC9BCC152817C9894DF874687A19", hash_generated_method = "AC74764C77884531AA1450A56DE60E7C")
    public String getIsimImpi() {
        try 
        {
String var5DCEABE210E09D0767D02AEADC198C7C_235240832 =             getSubscriberInfo().getIsimImpi();
            var5DCEABE210E09D0767D02AEADC198C7C_235240832.addTaint(taint);
            return var5DCEABE210E09D0767D02AEADC198C7C_235240832;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1856885956 =             null;
            var540C13E9E156B687226421B24F2DF178_1856885956.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1856885956;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_238201485 =             null;
            var540C13E9E156B687226421B24F2DF178_238201485.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_238201485;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpi();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.159 -0400", hash_original_method = "F4F2A7557A78EB2E07FE0C129F86CDF8", hash_generated_method = "AEDAB5BE9285C0390074B50972C068CE")
    public String getIsimDomain() {
        try 
        {
String var75CFD427E781BA29EF05EB9A61BBC625_1931476914 =             getSubscriberInfo().getIsimDomain();
            var75CFD427E781BA29EF05EB9A61BBC625_1931476914.addTaint(taint);
            return var75CFD427E781BA29EF05EB9A61BBC625_1931476914;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_393076060 =             null;
            var540C13E9E156B687226421B24F2DF178_393076060.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_393076060;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1777130515 =             null;
            var540C13E9E156B687226421B24F2DF178_1777130515.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1777130515;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimDomain();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.159 -0400", hash_original_method = "87EA21FFDB592BB220CD2250977D3D81", hash_generated_method = "D7D95AF3015D9ACB18A2F35F01E31C2E")
    public String[] getIsimImpu() {
        try 
        {
String[] varF954435B24638BDFE068699A047A39D8_804685393 =             getSubscriberInfo().getIsimImpu();
            varF954435B24638BDFE068699A047A39D8_804685393.addTaint(taint);
            return varF954435B24638BDFE068699A047A39D8_804685393;
        } //End block
        catch (RemoteException ex)
        {
String[] var540C13E9E156B687226421B24F2DF178_183317316 =             null;
            var540C13E9E156B687226421B24F2DF178_183317316.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_183317316;
        } //End block
        catch (NullPointerException ex)
        {
String[] var540C13E9E156B687226421B24F2DF178_947123212 =             null;
            var540C13E9E156B687226421B24F2DF178_947123212.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_947123212;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpu();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.159 -0400", hash_original_method = "0499CDF49B310038A9BEEA0F802EAB63", hash_generated_method = "CE4318304934E223EC300CD6C639A3EB")
    private IPhoneSubInfo getSubscriberInfo() {
IPhoneSubInfo var7BACB97921B95FA085BBBBACC7480C10_2041120783 =         IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
        var7BACB97921B95FA085BBBBACC7480C10_2041120783.addTaint(taint);
        return var7BACB97921B95FA085BBBBACC7480C10_2041120783;
        // ---------- Original Method ----------
        //return IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.160 -0400", hash_original_method = "74E55F6F5CD1551C04A2C40DCD1EBD15", hash_generated_method = "233F20884F1D2766EE7558F909FCBBB8")
    public int getCallState() {
        try 
        {
            int var0533A309AC0CCC3C1518BAC766974296_395642826 = (getITelephony().getCallState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025907682 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025907682;
        } //End block
        catch (RemoteException ex)
        {
            int varACD5DB586FA3C193894F7E999ECE3BDC_566709527 = (CALL_STATE_IDLE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861508024 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861508024;
        } //End block
        catch (NullPointerException ex)
        {
            int varACD5DB586FA3C193894F7E999ECE3BDC_270228833 = (CALL_STATE_IDLE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411809188 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411809188;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCallState();
        //} catch (RemoteException ex) {
            //return CALL_STATE_IDLE;
        //} catch (NullPointerException ex) {
          //return CALL_STATE_IDLE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.160 -0400", hash_original_method = "59E4B9880A04B49AB5E7CF82F18425E1", hash_generated_method = "9AE6BB10940838AE67B85EFF7DECD000")
    public int getDataActivity() {
        try 
        {
            int varE198B3E0B8F7EB8111E1E325E736D999_1486403737 = (getITelephony().getDataActivity());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047602006 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047602006;
        } //End block
        catch (RemoteException ex)
        {
            int varF280D694AF4929CB77F11E46920F2BC7_1110902039 = (DATA_ACTIVITY_NONE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317231188 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317231188;
        } //End block
        catch (NullPointerException ex)
        {
            int varF280D694AF4929CB77F11E46920F2BC7_70974397 = (DATA_ACTIVITY_NONE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147424541 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147424541;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataActivity();
        //} catch (RemoteException ex) {
            //return DATA_ACTIVITY_NONE;
        //} catch (NullPointerException ex) {
          //return DATA_ACTIVITY_NONE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.160 -0400", hash_original_method = "37205A4CB7441E0871F6B86EF9BDA019", hash_generated_method = "473D50B437AAACB10EB7468B30DED3F9")
    public int getDataState() {
        try 
        {
            int var05DEB0811BD07FD65D630D2271C9E705_1924256703 = (getITelephony().getDataState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843645813 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843645813;
        } //End block
        catch (RemoteException ex)
        {
            int var29171A006551A2ED0D5825353A5B1E74_1309400053 = (DATA_DISCONNECTED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_97004754 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_97004754;
        } //End block
        catch (NullPointerException ex)
        {
            int var29171A006551A2ED0D5825353A5B1E74_2109999996 = (DATA_DISCONNECTED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594950776 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594950776;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataState();
        //} catch (RemoteException ex) {
            //return DATA_DISCONNECTED;
        //} catch (NullPointerException ex) {
            //return DATA_DISCONNECTED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.160 -0400", hash_original_method = "7D101ED42BB684AED8CB9AC1B352231C", hash_generated_method = "13061B12B730A09A9C563083579DEC4A")
    private ITelephony getITelephony() {
ITelephony varE24CC4A0FD54521112B71EDFD4C7944D_2061092476 =         ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
        varE24CC4A0FD54521112B71EDFD4C7944D_2061092476.addTaint(taint);
        return varE24CC4A0FD54521112B71EDFD4C7944D_2061092476;
        // ---------- Original Method ----------
        //return ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.160 -0400", hash_original_method = "DC9C0A2F940DF23145CA1F74B7CF66E6", hash_generated_method = "8DDE087C804E4873D07D1117F4FA7262")
    public void listen(PhoneStateListener listener, int events) {
        addTaint(events);
        addTaint(listener.getTaint());
        String pkgForDebug = sContext != null ? sContext.getPackageName() : "<unknown>";
        try 
        {
            Boolean notifyNow = (getITelephony() != null);
            sRegistry.listen(pkgForDebug, listener.callback, events, notifyNow);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        catch (NullPointerException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //String pkgForDebug = sContext != null ? sContext.getPackageName() : "<unknown>";
        //try {
            //Boolean notifyNow = (getITelephony() != null);
            //sRegistry.listen(pkgForDebug, listener.callback, events, notifyNow);
        //} catch (RemoteException ex) {
        //} catch (NullPointerException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.161 -0400", hash_original_method = "94E639A6342206A666A9E9E564D3D41F", hash_generated_method = "FFF3EADCBDDA39C42E727B124D1788B5")
    public int getCdmaEriIconIndex() {
        try 
        {
            int varCA2A48CD0337F08156258F3B047734F6_1751689717 = (getITelephony().getCdmaEriIconIndex());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939387534 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939387534;
        } //End block
        catch (RemoteException ex)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1137404192 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866696343 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866696343;
        } //End block
        catch (NullPointerException ex)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1708641070 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142173187 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142173187;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconIndex();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.161 -0400", hash_original_method = "6E310C99A0183EA336ABBF86E9A26569", hash_generated_method = "A96A5C26537AF4AA02BA58540EBCBBE2")
    public int getCdmaEriIconMode() {
        try 
        {
            int varBFA19FD509DB7D6C9AE52A8F6879FE87_339821979 = (getITelephony().getCdmaEriIconMode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108446579 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108446579;
        } //End block
        catch (RemoteException ex)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2093613818 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861570904 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861570904;
        } //End block
        catch (NullPointerException ex)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1592604918 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931731393 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931731393;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconMode();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.161 -0400", hash_original_method = "70A8AFAFA7F0416F83BF728E9A3EFD1C", hash_generated_method = "AA95BAA4EA98F862E1617FEC638EEDF0")
    public String getCdmaEriText() {
        try 
        {
String varDA840479D06986C73A4D036E8023EF9C_885078369 =             getITelephony().getCdmaEriText();
            varDA840479D06986C73A4D036E8023EF9C_885078369.addTaint(taint);
            return varDA840479D06986C73A4D036E8023EF9C_885078369;
        } //End block
        catch (RemoteException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1653021870 =             null;
            var540C13E9E156B687226421B24F2DF178_1653021870.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1653021870;
        } //End block
        catch (NullPointerException ex)
        {
String var540C13E9E156B687226421B24F2DF178_456995830 =             null;
            var540C13E9E156B687226421B24F2DF178_456995830.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_456995830;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriText();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.161 -0400", hash_original_method = "691764E468F6F648007F4B86271FE09B", hash_generated_method = "2D5DEE9C8EA180C20A777918B4F10CAF")
    public boolean isVoiceCapable() {
        if(sContext == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_236320996 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1319395919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1319395919;
        }
        boolean var5CBF7DFB0D7CDC928BA8514D8452CAC1_217737605 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1777402505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1777402505;
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_voice_capable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_method = "FA08C86737C7918898577956B7BAC60B", hash_generated_method = "CFD6F4991BE05A13ADF429F88F8053A7")
    public boolean isSmsCapable() {
        if(sContext == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_432619712 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711204505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711204505;
        }
        boolean var19F4646A3887161BF6FDCC3319AEC214_1856623376 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_sms_capable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551558473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551558473;
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_sms_capable);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "E3A7492ADBD5D50FD2FD50813176DBDB", hash_generated_field = "FED661308A0D1EFA713B1ED05D1D257D")

    private static final String TAG = "TelephonyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "85E80EF1450B10017E4C79B6BDDE7990", hash_generated_field = "BB35128711B5DD286691A47454B04C39")

    private static Context sContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "AE4E730B47E7BAEAD5E5F31F32DF8F13", hash_generated_field = "582B8A11F267D0FC2F0A8BFE9E1B0E41")

    private static ITelephonyRegistry sRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "1586C7FD75CB36E072FB3C9CD55792C0", hash_generated_field = "255012CF538DDDD1C9746B5789864EE9")

    private static TelephonyManager sInstance = new TelephonyManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "607038FF7C7E9CF82E8EFF28D6EDCDB8", hash_generated_field = "94B958DD14B16242F602AC68B5B35D9B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PHONE_STATE_CHANGED =
            "android.intent.action.PHONE_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "42AF28D9501DF41B20B267FAD0E7F890", hash_generated_field = "ECA9CAE1305E7DD998C16171D7CBF2B3")

    public static final String EXTRA_STATE = Phone.STATE_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "B3B718BADBBF83619D359C67CAD58C7E", hash_generated_field = "644A2D46020DA7007B4595269AC70D14")

    public static final String EXTRA_STATE_IDLE = Phone.State.IDLE.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "5F83F81503133C654D45EA0EBB27BCBA", hash_generated_field = "5BA124B52973008E7CC271EAC7C7A168")

    public static final String EXTRA_STATE_RINGING = Phone.State.RINGING.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "A798F19AF8276E88814A96F47AFA8C8A", hash_generated_field = "AB0B945EFBEE7E5F54BE15055E7F173C")

    public static final String EXTRA_STATE_OFFHOOK = Phone.State.OFFHOOK.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "D6B17D5D61F6724D02C2153B1F3B1843", hash_generated_field = "A350D7682844B18DAE260769F2227CF5")

    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.162 -0400", hash_original_field = "4D1E695B0B0E12571331956AD39E7FFB", hash_generated_field = "78804DFF38A537862AA01355F9EAEE2D")

    public static final int PHONE_TYPE_NONE = Phone.PHONE_TYPE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "3DAA11A54CC0CD1C5DFE91C5B9068C5B", hash_generated_field = "D056262BD19D9D2B6080E6C65F89AAFE")

    public static final int PHONE_TYPE_GSM = Phone.PHONE_TYPE_GSM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "C73F0D264479302DB3A47B11C96F110C", hash_generated_field = "CA3A5930619F40D3AB8D9ED99A87151C")

    public static final int PHONE_TYPE_CDMA = Phone.PHONE_TYPE_CDMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "A40B9F4209BEDDD305F37BAEFDA2CCC9", hash_generated_field = "4B9088F6BA66C5DDA4BF5641DA27C4CE")

    public static final int PHONE_TYPE_SIP = Phone.PHONE_TYPE_SIP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "A55875FC41C2547C7109F2F532B60AE3", hash_generated_field = "3ADBC2EDBBFD9CFE0BB915AD0B7AB259")

    public static final int NETWORK_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "E55225DA6655F9FB6EB9C024BF82A8DF", hash_generated_field = "DF4F111D7D9CAFAE4BFDC86FEE1390B0")

    public static final int NETWORK_TYPE_GPRS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "61F14B9586D6398BD5127055E810F00F", hash_generated_field = "AFA157BE025D28F2633E52B67F5FF45D")

    public static final int NETWORK_TYPE_EDGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "575357F0A7A6BFAA052AAA853F582333", hash_generated_field = "4EE60A58FF3A6A827BAE8B3660FDDBEA")

    public static final int NETWORK_TYPE_UMTS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "775CF0D51734EB8CEF3507FCF5BFBADD", hash_generated_field = "17247A089138DB194E3C3689EB8D2C09")

    public static final int NETWORK_TYPE_CDMA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "0CABA5186481D2F15240B3C94724ABC9", hash_generated_field = "7059F2E3BF3949FC65A081A768BD3451")

    public static final int NETWORK_TYPE_EVDO_0 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "E6A1388F9B185090C006778CDA2CFDBF", hash_generated_field = "7F0F0403315A2164D626A0BC52B06414")

    public static final int NETWORK_TYPE_EVDO_A = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "F7A7D202F73482C4EC61E01D06110249", hash_generated_field = "CB357E9EDD52F69601CAE2082846D5E3")

    public static final int NETWORK_TYPE_1xRTT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "E48A9DF10A677149F085C7B5F7C0718A", hash_generated_field = "89CA7CBDC236075D3DF613C9FF78C239")

    public static final int NETWORK_TYPE_HSDPA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "44A7156A1F878A6DB346BA47A36E7211", hash_generated_field = "A2B013A8B7DBC1B768FDA8801DD88687")

    public static final int NETWORK_TYPE_HSUPA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "FC87D1554FFB7BB46BF08D1CEF629C48", hash_generated_field = "685F9ECE7B6483CF2B967E0CA7312169")

    public static final int NETWORK_TYPE_HSPA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "0E43EEEAE6BB6EF300DED0D70E98FF2B", hash_generated_field = "60079AE9B8FCBC7ADE140290C5E3832B")

    public static final int NETWORK_TYPE_IDEN = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "A24D35860A01193C134EBD0E9D0C0C23", hash_generated_field = "05A463A291C68559D8A2DA4399EC93B8")

    public static final int NETWORK_TYPE_EVDO_B = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "65B2C3B7993C2021079087462ABF4B64", hash_generated_field = "897972FB0146052AF9FE6A13C387063A")

    public static final int NETWORK_TYPE_LTE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "017ABDECFAA1C908D4E5E8EF5DF39C91", hash_generated_field = "3B80988B27EA0BE6E633061C7CF1BE85")

    public static final int NETWORK_TYPE_EHRPD = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "BD0E2321565D24AC2CD0A61F089767CF", hash_generated_field = "BD0BA401891F25C620F3110BD2DB15BC")

    public static final int NETWORK_TYPE_HSPAP = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "CE5C5B0F4B6E3C6B2AFC7C1B72C483E8", hash_generated_field = "7C7BEF03A11ED6F5B236D02E3AC76BB3")

    public static final int NETWORK_CLASS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.163 -0400", hash_original_field = "A87627CC53B5FFC7D1821690AF23B4BD", hash_generated_field = "952EAD66C73882790E8632EBDE3D0EEB")

    public static final int NETWORK_CLASS_2_G = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "FB0F44C286C43C6A6F3E8528A93D82B0", hash_generated_field = "16C334B31519B49DB6ACD1DE6C14E392")

    public static final int NETWORK_CLASS_3_G = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "FDD83C94EEE3D14F9B73E95BF24E3929", hash_generated_field = "0D5564D633DC921137687C883E4D0F99")

    public static final int NETWORK_CLASS_4_G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "4803464CC31FE860623B640A8F9C9181", hash_generated_field = "F1630542E3838A7ADD00A0BE8722AACE")

    public static final int SIM_STATE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "7B251AECF4F4E9032236E44C8AE417BA", hash_generated_field = "FE661F33A2994BC3BF316C87CD05115C")

    public static final int SIM_STATE_ABSENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "FA0C649B35BA21805999CC2832FEB1D2", hash_generated_field = "6C48EE683A7E78D23C00B92717DE5A22")

    public static final int SIM_STATE_PIN_REQUIRED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "997E1F0E8B724D2A61B435253EC3AEBB", hash_generated_field = "ABE24381CD34E62691DD2C4E93ED4A19")

    public static final int SIM_STATE_PUK_REQUIRED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "5FEA14412EFEF16CAF853FEAAD8F7412", hash_generated_field = "6EE0D9233BAFEC27F9B3BFDB79237527")

    public static final int SIM_STATE_NETWORK_LOCKED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "8F7C0EC531C2914B7B63A605E10BF111", hash_generated_field = "52957824F7E9EFEE70E933C4483F3560")

    public static final int SIM_STATE_READY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "3355B07218C1AAEDA389C55F2E4D4903", hash_generated_field = "880051CE2B272E830BA1E1C9C8EDFDAD")

    public static final int CALL_STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "0AB9BD5B9E7529913E150CF5786D7451", hash_generated_field = "EBF7E79274B936572A44F5AC97C350E9")

    public static final int CALL_STATE_RINGING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "DC1251E603711B7D70A8A4DDDF0D3DFA", hash_generated_field = "F1553B4E51E8E01AAC1228FBFF50DED7")

    public static final int CALL_STATE_OFFHOOK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "F512487C19B4E4DF3A0394C80D07E275", hash_generated_field = "6303BB7C9E2B830338C1836586DB6697")

    public static final int DATA_ACTIVITY_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "50E2E026EC9C664DC24FF36D29AD2CE8", hash_generated_field = "AC92BAFF5B1AACED092C2AF469A8CBD3")

    public static final int DATA_ACTIVITY_IN = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "3D515F46C6B9C8715B613648A4C421E3", hash_generated_field = "63CF83921BA898885E2AD57DC2D97303")

    public static final int DATA_ACTIVITY_OUT = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.164 -0400", hash_original_field = "A8505CE9C7C3D8B2A208A367E9F8017E", hash_generated_field = "E7682DD7C56FD243525F5233E80F53E4")

    public static final int DATA_ACTIVITY_INOUT = DATA_ACTIVITY_IN | DATA_ACTIVITY_OUT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.165 -0400", hash_original_field = "ED16AA52E2AD8783C5663A67E8494382", hash_generated_field = "0A134B76AF6D9DF50656A5FE58BE98FF")

    public static final int DATA_ACTIVITY_DORMANT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.165 -0400", hash_original_field = "39D416CC671EA6C04286C6438AC4DA0F", hash_generated_field = "FF8D51C8FEAAD0B22B077E1A375AC594")

    public static final int DATA_UNKNOWN        = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.165 -0400", hash_original_field = "EC19C258779D833C3D52C3F786F5890C", hash_generated_field = "C4C0880CDDF6725DBFD4E7B67714DE9B")

    public static final int DATA_DISCONNECTED   = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.165 -0400", hash_original_field = "48FF8856F44C088A8CE7CFDF5B291B4D", hash_generated_field = "FF9CE223A769E6D3636143EA9AC19C2B")

    public static final int DATA_CONNECTING     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.165 -0400", hash_original_field = "F415667E2FC38B9FD7C9BEFFCEF8C733", hash_generated_field = "794BB976A412F225595FC4181FE3FC75")

    public static final int DATA_CONNECTED      = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.165 -0400", hash_original_field = "8D70D003B5C75608EE7DA82B0BA5E330", hash_generated_field = "DC6EB947ED9360ECC33AC98BE7B1AAB6")

    public static final int DATA_SUSPENDED      = 3;
}

