package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.285 -0400", hash_original_method = "D511206E864FFF32983F1CF5D1263F8B", hash_generated_method = "A993F64614FEC88056E2A7A803A65A51")
    public  TelephonyManager(Context context) {
        {
            Context appContext;
            appContext = context.getApplicationContext();
            {
                sContext = appContext;
            } //End block
            {
                sContext = context;
            } //End block
            sRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
        } //End block
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.295 -0400", hash_original_method = "8E4DE1903A24C15F73A151ACA155A108", hash_generated_method = "ED16BD9217E0E1C9750C925EEB9F2C13")
    private  TelephonyManager() {
        // ---------- Original Method ----------
    }

    
        public static TelephonyManager getDefault() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.297 -0400", hash_original_method = "CBA2DB54A66B89F7737C894703CB092B", hash_generated_method = "C8E8B6F60733F73217CE0DE823E040BC")
    public String getDeviceSoftwareVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1453748606 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_694885344 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_460443000 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1453748606 = getSubscriberInfo().getDeviceSvn();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_694885344 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_460443000 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_597804919; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_597804919 = varB4EAC82CA7396A68D541C85D26508E83_1453748606;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_597804919 = varB4EAC82CA7396A68D541C85D26508E83_694885344;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_597804919 = varB4EAC82CA7396A68D541C85D26508E83_460443000;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_597804919.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_597804919;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceSvn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.299 -0400", hash_original_method = "D15182A782B2311FD9923C2371701B25", hash_generated_method = "8417E6BAE1AA3FDD1BD736066738066F")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1734923100 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_606088508 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1318048423 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1734923100 = getSubscriberInfo().getDeviceId();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_606088508 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1318048423 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_550221928; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_550221928 = varB4EAC82CA7396A68D541C85D26508E83_1734923100;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_550221928 = varB4EAC82CA7396A68D541C85D26508E83_606088508;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_550221928 = varB4EAC82CA7396A68D541C85D26508E83_1318048423;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_550221928.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_550221928;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.320 -0400", hash_original_method = "5E61A73DD3A54D24C69E0825B273DC95", hash_generated_method = "2D83F19F4100C15ECE5256D8C54B6B40")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_451823777 = null; //Variable for return #1
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_377551693 = null; //Variable for return #2
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_358059355 = null; //Variable for return #3
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_656826081 = null; //Variable for return #4
        try 
        {
            Bundle bundle;
            bundle = getITelephony().getCellLocation();
            CellLocation cl;
            cl = CellLocation.newFromBundle(bundle);
            {
                boolean var317C3CB3784625A6460A4542B041B297_725612683 = (cl.isEmpty());
                varB4EAC82CA7396A68D541C85D26508E83_451823777 = null;
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_377551693 = cl;
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_358059355 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_656826081 = null;
        } //End block
        CellLocation varA7E53CE21691AB073D9660D615818899_416306497; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_416306497 = varB4EAC82CA7396A68D541C85D26508E83_451823777;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_416306497 = varB4EAC82CA7396A68D541C85D26508E83_377551693;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_416306497 = varB4EAC82CA7396A68D541C85D26508E83_358059355;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_416306497 = varB4EAC82CA7396A68D541C85D26508E83_656826081;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_416306497.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_416306497;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.321 -0400", hash_original_method = "6D04BBFB8BC88B77ECB40D44848A65EA", hash_generated_method = "458D6743E4F46BB3AC3E4ACD477D329D")
    public void enableLocationUpdates() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.322 -0400", hash_original_method = "3CD4D10099672E02B38D45C520AD59E4", hash_generated_method = "E013BCD17D1EA9C72A6B60AE740DB771")
    public void disableLocationUpdates() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.323 -0400", hash_original_method = "1B24CD9B4799B0CFE847058C4CF4C5E3", hash_generated_method = "53B4D010CA7F783D5CFF5694876CABBD")
    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_1588714272 = null; //Variable for return #1
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_2006740750 = null; //Variable for return #2
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_1017857187 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1588714272 = getITelephony().getNeighboringCellInfo();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2006740750 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1017857187 = null;
        } //End block
        List<NeighboringCellInfo> varA7E53CE21691AB073D9660D615818899_171967402; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_171967402 = varB4EAC82CA7396A68D541C85D26508E83_1588714272;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_171967402 = varB4EAC82CA7396A68D541C85D26508E83_2006740750;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_171967402 = varB4EAC82CA7396A68D541C85D26508E83_1017857187;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_171967402.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_171967402;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getNeighboringCellInfo();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.324 -0400", hash_original_method = "7EF6D35F0DE2C86E385132A28BC64E8B", hash_generated_method = "B6A4FB6BAD3FE030932CDB0C8A06228E")
    public int getCurrentPhoneType() {
        try 
        {
            ITelephony telephony;
            telephony = getITelephony();
            {
                int var02112D65AFB7DC116D2A52A0D60D8BE5_1109356604 = (telephony.getActivePhoneType());
            } //End block
            {
                int var59B2E48460729F59E7A28157BAB50763_498962421 = (getPhoneTypeFromProperty());
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_799434727 = (getPhoneTypeFromProperty());
        } //End block
        catch (NullPointerException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_1107749390 = (getPhoneTypeFromProperty());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311350467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311350467;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.324 -0400", hash_original_method = "0A507D7BB3876FB6AE8B7F4B411CB7D0", hash_generated_method = "B77540487F54121D8387E518CEE525C0")
    public int getPhoneType() {
        {
            boolean var3F3CAC2823D51C3CFDE7D9F95AC1D73E_1425958617 = (!isVoiceCapable());
        } //End collapsed parenthetic
        int varE671F9CAE03ACF5F8C18BEA23599BB43_1509869462 = (getCurrentPhoneType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394458640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394458640;
        // ---------- Original Method ----------
        //if (!isVoiceCapable()) {
            //return PHONE_TYPE_NONE;
        //}
        //return getCurrentPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.345 -0400", hash_original_method = "AFA495B3EA5295146DEDE68ACDCEDE97", hash_generated_method = "93994E198249EF5F965B2EE31251D98B")
    private int getPhoneTypeFromProperty() {
        int type;
        type = SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    getPhoneTypeFromNetworkType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474039949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474039949;
        // ---------- Original Method ----------
        //int type =
            //SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    //getPhoneTypeFromNetworkType());
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.346 -0400", hash_original_method = "64BB8AD229481F016ED315B563697438", hash_generated_method = "4BF7B3567B38E675BD71EBEBD9F5BB37")
    private int getPhoneTypeFromNetworkType() {
        int mode;
        mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        int varF8BEC291204F8330EC3241AB87D680C0_342734110 = (PhoneFactory.getPhoneType(mode));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754186079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754186079;
        // ---------- Original Method ----------
        //int mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        //if (mode == -1)
            //return PHONE_TYPE_NONE;
        //return PhoneFactory.getPhoneType(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.349 -0400", hash_original_method = "832612984320BCC9B2F167CB90709724", hash_generated_method = "8090F363CD6AEB5B66C540FB39D823C3")
    public String getNetworkOperatorName() {
        String varB4EAC82CA7396A68D541C85D26508E83_431522991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_431522991 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
        varB4EAC82CA7396A68D541C85D26508E83_431522991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_431522991;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.354 -0400", hash_original_method = "C6C0AA4A9611C88887AD0284C9B9779A", hash_generated_method = "E91278A10A6ADFA267A0054CBE4C4076")
    public String getNetworkOperator() {
        String varB4EAC82CA7396A68D541C85D26508E83_1709324300 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1709324300 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
        varB4EAC82CA7396A68D541C85D26508E83_1709324300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1709324300;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.359 -0400", hash_original_method = "B6A17594C3960A6046C8BF4D54C6D185", hash_generated_method = "4C5112EC1C94F7985E43236AC5EAF45D")
    public boolean isNetworkRoaming() {
        boolean var7CCC8BA33120747ECAA380992352D963_2099292064 = ("true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1182732868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1182732868;
        // ---------- Original Method ----------
        //return "true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.359 -0400", hash_original_method = "DDFD7BDCC0E0CF0AD038335E60C4F613", hash_generated_method = "9B7BDD5DB60D85DC45EFEC56BE6D6335")
    public String getNetworkCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_1430580162 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1430580162 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
        varB4EAC82CA7396A68D541C85D26508E83_1430580162.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1430580162;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.373 -0400", hash_original_method = "E55284324A887F7771FC58B52617EFF6", hash_generated_method = "B9C635899E4F4C1387D752D05C579F12")
    public int getNetworkType() {
        try 
        {
            ITelephony telephony;
            telephony = getITelephony();
            {
                int varBB3E4B10AC2DDE47109944FAD74ADA38_2099739349 = (telephony.getNetworkType());
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331280511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331280511;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.389 -0400", hash_original_method = "2CF054408BF0643DB5F15627D9964227", hash_generated_method = "BA51A84849E4AD85D395B56167E6A2EA")
    public String getNetworkTypeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1287556391 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1287556391 = getNetworkTypeName(getNetworkType());
        varB4EAC82CA7396A68D541C85D26508E83_1287556391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1287556391;
        // ---------- Original Method ----------
        //return getNetworkTypeName(getNetworkType());
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.391 -0400", hash_original_method = "B54BEBEEDA1D514B6ED30035D8F7A17F", hash_generated_method = "7F0F082E807E1C90B9D99990EFDAF525")
    public boolean hasIccCard() {
        try 
        {
            boolean var74498D7060EADCB8C4F6CF6D6BE7A0FF_1507405501 = (getITelephony().hasIccCard());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630813306 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630813306;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().hasIccCard();
        //} catch (RemoteException ex) {
            //return false;
        //} catch (NullPointerException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.392 -0400", hash_original_method = "09E0380F50AC76521F62251E25C950EA", hash_generated_method = "DB506174D1D22EA55256117C322DCD34")
    public int getSimState() {
        String prop;
        prop = SystemProperties.get(TelephonyProperties.PROPERTY_SIM_STATE);
        {
            boolean var656939FEF7D866D03F6ED0F92EBF27D3_119540022 = ("ABSENT".equals(prop));
            {
                boolean var70CB33CEB8F4069C6140C5CFEA6752B7_1700519181 = ("PIN_REQUIRED".equals(prop));
                {
                    boolean var90FBEC75DFA1A3628B25A46F0B119AA1_871611990 = ("PUK_REQUIRED".equals(prop));
                    {
                        boolean var5209DF38776E48B1D29ED96972A531A2_953549438 = ("NETWORK_LOCKED".equals(prop));
                        {
                            boolean var9FFEABD8A87C0F145C76AB31A340E57B_610912177 = ("READY".equals(prop));
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861904509 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861904509;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.393 -0400", hash_original_method = "31C6D14DB3E72FC3C1A0B120DB42F405", hash_generated_method = "A1863E8A27FBC98E9FE9A07A43CD4567")
    public String getSimOperator() {
        String varB4EAC82CA7396A68D541C85D26508E83_745286663 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_745286663 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
        varB4EAC82CA7396A68D541C85D26508E83_745286663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_745286663;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.413 -0400", hash_original_method = "FF7B2BB8165B4DA3F4CA04B0E402231E", hash_generated_method = "0B2242251DC61173F0DEE13C4FEF3711")
    public String getSimOperatorName() {
        String varB4EAC82CA7396A68D541C85D26508E83_893574600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_893574600 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
        varB4EAC82CA7396A68D541C85D26508E83_893574600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_893574600;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.414 -0400", hash_original_method = "86E21142AD28646E6483CDE3D9BD89F9", hash_generated_method = "C8A92DC0961C18FF4E1BE85DFDD16750")
    public String getSimCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_39499497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_39499497 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
        varB4EAC82CA7396A68D541C85D26508E83_39499497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_39499497;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.415 -0400", hash_original_method = "2017CBA66707D72E2F76A9954FAEDD18", hash_generated_method = "E86F99BF96FE64E61C7794FD1B727265")
    public String getSimSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_2070427726 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1708693985 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1767717310 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2070427726 = getSubscriberInfo().getIccSerialNumber();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1708693985 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1767717310 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_519385579; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_519385579 = varB4EAC82CA7396A68D541C85D26508E83_2070427726;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_519385579 = varB4EAC82CA7396A68D541C85D26508E83_1708693985;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_519385579 = varB4EAC82CA7396A68D541C85D26508E83_1767717310;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_519385579.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_519385579;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIccSerialNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.416 -0400", hash_original_method = "EA3A591F5FC8CB370CDC207E1A4A9D6A", hash_generated_method = "005918925CFE24F63BC533E0FB5BF83A")
    public int getLteOnCdmaMode() {
        try 
        {
            int var29B7AA8EB74FFF815EDF62F09C7A13DE_285571794 = (getITelephony().getLteOnCdmaMode());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029979858 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029979858;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getLteOnCdmaMode();
        //} catch (RemoteException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //} catch (NullPointerException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.417 -0400", hash_original_method = "E78B911A34E3B997234FCD2FE0581326", hash_generated_method = "1BCEC2A36332977E010F0DABF5CC0717")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_138958283 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_643867398 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_269173109 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_138958283 = getSubscriberInfo().getSubscriberId();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_643867398 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_269173109 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1916845601; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1916845601 = varB4EAC82CA7396A68D541C85D26508E83_138958283;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1916845601 = varB4EAC82CA7396A68D541C85D26508E83_643867398;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1916845601 = varB4EAC82CA7396A68D541C85D26508E83_269173109;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1916845601.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1916845601;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getSubscriberId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.421 -0400", hash_original_method = "EE92449D081C56B70CB6173E1BAAB538", hash_generated_method = "B5C052CABBB8F3893A6CBA72DF8927D3")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_542478842 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1940701844 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1847065327 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_542478842 = getSubscriberInfo().getLine1Number();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1940701844 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1847065327 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1265289880; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1265289880 = varB4EAC82CA7396A68D541C85D26508E83_542478842;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1265289880 = varB4EAC82CA7396A68D541C85D26508E83_1940701844;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1265289880 = varB4EAC82CA7396A68D541C85D26508E83_1847065327;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1265289880.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1265289880;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1Number();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.441 -0400", hash_original_method = "7B70034F9FC00AD85A334A6B1881279C", hash_generated_method = "2B63525E1EF21C6A82D3DD0686C8A558")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_68032657 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_170846801 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1740876886 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_68032657 = getSubscriberInfo().getLine1AlphaTag();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_170846801 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1740876886 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1262171148; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1262171148 = varB4EAC82CA7396A68D541C85D26508E83_68032657;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1262171148 = varB4EAC82CA7396A68D541C85D26508E83_170846801;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1262171148 = varB4EAC82CA7396A68D541C85D26508E83_1740876886;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1262171148.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1262171148;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1AlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.442 -0400", hash_original_method = "FE1089A80F0C63E9B1494FCF93B412E1", hash_generated_method = "A3CA6F22D76BC0AEE5AB2F87E8782CCE")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1781883474 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_477860134 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1375927928 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1781883474 = getSubscriberInfo().getMsisdn();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_477860134 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1375927928 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1401156886; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1401156886 = varB4EAC82CA7396A68D541C85D26508E83_1781883474;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1401156886 = varB4EAC82CA7396A68D541C85D26508E83_477860134;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1401156886 = varB4EAC82CA7396A68D541C85D26508E83_1375927928;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1401156886.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1401156886;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getMsisdn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.443 -0400", hash_original_method = "8E528B053F49E44E27934FB8B1D79754", hash_generated_method = "D69C55C317961DE9DE953397D6236061")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_901223121 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_119809936 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1731529942 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_901223121 = getSubscriberInfo().getVoiceMailNumber();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_119809936 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1731529942 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1129729743; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1129729743 = varB4EAC82CA7396A68D541C85D26508E83_901223121;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1129729743 = varB4EAC82CA7396A68D541C85D26508E83_119809936;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1129729743 = varB4EAC82CA7396A68D541C85D26508E83_1731529942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1129729743.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1129729743;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.443 -0400", hash_original_method = "6E4CD5DF61F1B6B4D99C4D48EBD42C25", hash_generated_method = "C1FC622B10908C9FA0C5BA244612FF0C")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_799405554 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1446820566 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_555588860 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_799405554 = getSubscriberInfo().getCompleteVoiceMailNumber();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1446820566 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_555588860 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1608405362; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1608405362 = varB4EAC82CA7396A68D541C85D26508E83_799405554;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1608405362 = varB4EAC82CA7396A68D541C85D26508E83_1446820566;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1608405362 = varB4EAC82CA7396A68D541C85D26508E83_555588860;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1608405362.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1608405362;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getCompleteVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.447 -0400", hash_original_method = "8799C29F83D6241F3339A57C480A2568", hash_generated_method = "2267A7D4FD4E6AF36EC6DFBE9C0D7459")
    public int getVoiceMessageCount() {
        try 
        {
            int var597A31B7365C84A57CFAEE70B622FC99_2001979489 = (getITelephony().getVoiceMessageCount());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874793217 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874793217;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getVoiceMessageCount();
        //} catch (RemoteException ex) {
            //return 0;
        //} catch (NullPointerException ex) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.470 -0400", hash_original_method = "FCB9C7AA008FFD71198739B23DB8A42C", hash_generated_method = "1AFDC1CC41C92DBD69E3D10171FD8888")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_2141300233 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1243933447 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1089428189 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2141300233 = getSubscriberInfo().getVoiceMailAlphaTag();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1243933447 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1089428189 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1725808899; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1725808899 = varB4EAC82CA7396A68D541C85D26508E83_2141300233;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1725808899 = varB4EAC82CA7396A68D541C85D26508E83_1243933447;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1725808899 = varB4EAC82CA7396A68D541C85D26508E83_1089428189;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1725808899.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1725808899;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailAlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.471 -0400", hash_original_method = "2827FC9BCC152817C9894DF874687A19", hash_generated_method = "11267C881D0ECF889B039C708C4C54EB")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_870640796 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1649447477 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2133644838 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_870640796 = getSubscriberInfo().getIsimImpi();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1649447477 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2133644838 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_380417652; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_380417652 = varB4EAC82CA7396A68D541C85D26508E83_870640796;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_380417652 = varB4EAC82CA7396A68D541C85D26508E83_1649447477;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_380417652 = varB4EAC82CA7396A68D541C85D26508E83_2133644838;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_380417652.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_380417652;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpi();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.472 -0400", hash_original_method = "F4F2A7557A78EB2E07FE0C129F86CDF8", hash_generated_method = "A1646F15B4A23CACF6E3AF1E3CEAFE7A")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1341930065 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1668873606 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_8192222 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1341930065 = getSubscriberInfo().getIsimDomain();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1668873606 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_8192222 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1226221279; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1226221279 = varB4EAC82CA7396A68D541C85D26508E83_1341930065;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1226221279 = varB4EAC82CA7396A68D541C85D26508E83_1668873606;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1226221279 = varB4EAC82CA7396A68D541C85D26508E83_8192222;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1226221279.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1226221279;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimDomain();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.485 -0400", hash_original_method = "87EA21FFDB592BB220CD2250977D3D81", hash_generated_method = "8144984972E5A09AF6E5FE663AC66E82")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1803626448 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1615313822 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_710406993 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1803626448 = getSubscriberInfo().getIsimImpu();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1615313822 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_710406993 = null;
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_94082266; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_94082266 = varB4EAC82CA7396A68D541C85D26508E83_1803626448;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_94082266 = varB4EAC82CA7396A68D541C85D26508E83_1615313822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_94082266 = varB4EAC82CA7396A68D541C85D26508E83_710406993;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_94082266.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_94082266;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpu();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.486 -0400", hash_original_method = "0499CDF49B310038A9BEEA0F802EAB63", hash_generated_method = "019DFA2E173F2197B68DEFED42430F3F")
    private IPhoneSubInfo getSubscriberInfo() {
        IPhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_1835439131 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1835439131 = IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
        varB4EAC82CA7396A68D541C85D26508E83_1835439131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1835439131;
        // ---------- Original Method ----------
        //return IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.487 -0400", hash_original_method = "74E55F6F5CD1551C04A2C40DCD1EBD15", hash_generated_method = "1E2A39B18738ACA361B650BF083C54CB")
    public int getCallState() {
        try 
        {
            int var11FDA2929718CED1A97BBEADDCB6295E_1458685848 = (getITelephony().getCallState());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634149847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1634149847;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCallState();
        //} catch (RemoteException ex) {
            //return CALL_STATE_IDLE;
        //} catch (NullPointerException ex) {
          //return CALL_STATE_IDLE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.487 -0400", hash_original_method = "59E4B9880A04B49AB5E7CF82F18425E1", hash_generated_method = "659CCAAE11A202B20D9CB38315BDB402")
    public int getDataActivity() {
        try 
        {
            int var942CC87DE49A18402BCD05EEE3CD1C3D_977753992 = (getITelephony().getDataActivity());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442559227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442559227;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataActivity();
        //} catch (RemoteException ex) {
            //return DATA_ACTIVITY_NONE;
        //} catch (NullPointerException ex) {
          //return DATA_ACTIVITY_NONE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.504 -0400", hash_original_method = "37205A4CB7441E0871F6B86EF9BDA019", hash_generated_method = "9A7966B454CC3B5AF8102CDD6F325B1C")
    public int getDataState() {
        try 
        {
            int var914C29C6BEDE622C1C17EC919700D468_622488653 = (getITelephony().getDataState());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466638729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466638729;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataState();
        //} catch (RemoteException ex) {
            //return DATA_DISCONNECTED;
        //} catch (NullPointerException ex) {
            //return DATA_DISCONNECTED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.505 -0400", hash_original_method = "7D101ED42BB684AED8CB9AC1B352231C", hash_generated_method = "837266377CD5B5411AFFF50D50C9B4F3")
    private ITelephony getITelephony() {
        ITelephony varB4EAC82CA7396A68D541C85D26508E83_841440012 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_841440012 = ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
        varB4EAC82CA7396A68D541C85D26508E83_841440012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_841440012;
        // ---------- Original Method ----------
        //return ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.506 -0400", hash_original_method = "DC9C0A2F940DF23145CA1F74B7CF66E6", hash_generated_method = "F2B5BE907C66107E9AD4C06CB53AF0D4")
    public void listen(PhoneStateListener listener, int events) {
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
        addTaint(listener.getTaint());
        addTaint(events);
        // ---------- Original Method ----------
        //String pkgForDebug = sContext != null ? sContext.getPackageName() : "<unknown>";
        //try {
            //Boolean notifyNow = (getITelephony() != null);
            //sRegistry.listen(pkgForDebug, listener.callback, events, notifyNow);
        //} catch (RemoteException ex) {
        //} catch (NullPointerException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.506 -0400", hash_original_method = "94E639A6342206A666A9E9E564D3D41F", hash_generated_method = "FD9708E075FBBB44B3CF8024B5334067")
    public int getCdmaEriIconIndex() {
        try 
        {
            int var0DE1842BE7731F45B9E40B3EAE1DF080_1751745908 = (getITelephony().getCdmaEriIconIndex());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8717620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8717620;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconIndex();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.507 -0400", hash_original_method = "6E310C99A0183EA336ABBF86E9A26569", hash_generated_method = "56EC0BCE09DBAE659115338693DB75C7")
    public int getCdmaEriIconMode() {
        try 
        {
            int var2E431383FA9B43BC42A9105446DC5E3E_51039337 = (getITelephony().getCdmaEriIconMode());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333603441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333603441;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconMode();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.508 -0400", hash_original_method = "70A8AFAFA7F0416F83BF728E9A3EFD1C", hash_generated_method = "82780ED52F184A3CA27368C9F59B7A60")
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_538516616 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_466568122 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1339503502 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_538516616 = getITelephony().getCdmaEriText();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_466568122 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1339503502 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1666105278; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1666105278 = varB4EAC82CA7396A68D541C85D26508E83_538516616;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1666105278 = varB4EAC82CA7396A68D541C85D26508E83_466568122;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1666105278 = varB4EAC82CA7396A68D541C85D26508E83_1339503502;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1666105278.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1666105278;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriText();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.517 -0400", hash_original_method = "691764E468F6F648007F4B86271FE09B", hash_generated_method = "EF68066D0219D0305E562AEC9C43791B")
    public boolean isVoiceCapable() {
        boolean var2A02B989ADE5F351F5FC8A1EAED6F4D2_3995114 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667185674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667185674;
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_voice_capable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_method = "FA08C86737C7918898577956B7BAC60B", hash_generated_method = "70B5E67C8AE076F4959AC9D5653AC1E0")
    public boolean isSmsCapable() {
        boolean var0F7ADAF88B8AB318218711339F43AFAA_1110821933 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_sms_capable));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634589367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_634589367;
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_sms_capable);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "E3A7492ADBD5D50FD2FD50813176DBDB", hash_generated_field = "892D0BCF313C867FAEA4FA4F98555EBD")

    private static String TAG = "TelephonyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "85E80EF1450B10017E4C79B6BDDE7990", hash_generated_field = "BB35128711B5DD286691A47454B04C39")

    private static Context sContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "AE4E730B47E7BAEAD5E5F31F32DF8F13", hash_generated_field = "582B8A11F267D0FC2F0A8BFE9E1B0E41")

    private static ITelephonyRegistry sRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "1586C7FD75CB36E072FB3C9CD55792C0", hash_generated_field = "255012CF538DDDD1C9746B5789864EE9")

    private static TelephonyManager sInstance = new TelephonyManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "607038FF7C7E9CF82E8EFF28D6EDCDB8", hash_generated_field = "94B958DD14B16242F602AC68B5B35D9B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PHONE_STATE_CHANGED =
            "android.intent.action.PHONE_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "42AF28D9501DF41B20B267FAD0E7F890", hash_generated_field = "ECA9CAE1305E7DD998C16171D7CBF2B3")

    public static final String EXTRA_STATE = Phone.STATE_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "B3B718BADBBF83619D359C67CAD58C7E", hash_generated_field = "644A2D46020DA7007B4595269AC70D14")

    public static final String EXTRA_STATE_IDLE = Phone.State.IDLE.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "5F83F81503133C654D45EA0EBB27BCBA", hash_generated_field = "5BA124B52973008E7CC271EAC7C7A168")

    public static final String EXTRA_STATE_RINGING = Phone.State.RINGING.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.518 -0400", hash_original_field = "A798F19AF8276E88814A96F47AFA8C8A", hash_generated_field = "AB0B945EFBEE7E5F54BE15055E7F173C")

    public static final String EXTRA_STATE_OFFHOOK = Phone.State.OFFHOOK.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.519 -0400", hash_original_field = "D6B17D5D61F6724D02C2153B1F3B1843", hash_generated_field = "A350D7682844B18DAE260769F2227CF5")

    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.519 -0400", hash_original_field = "4D1E695B0B0E12571331956AD39E7FFB", hash_generated_field = "78804DFF38A537862AA01355F9EAEE2D")

    public static final int PHONE_TYPE_NONE = Phone.PHONE_TYPE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.519 -0400", hash_original_field = "3DAA11A54CC0CD1C5DFE91C5B9068C5B", hash_generated_field = "D056262BD19D9D2B6080E6C65F89AAFE")

    public static final int PHONE_TYPE_GSM = Phone.PHONE_TYPE_GSM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.519 -0400", hash_original_field = "C73F0D264479302DB3A47B11C96F110C", hash_generated_field = "CA3A5930619F40D3AB8D9ED99A87151C")

    public static final int PHONE_TYPE_CDMA = Phone.PHONE_TYPE_CDMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.519 -0400", hash_original_field = "A40B9F4209BEDDD305F37BAEFDA2CCC9", hash_generated_field = "4B9088F6BA66C5DDA4BF5641DA27C4CE")

    public static final int PHONE_TYPE_SIP = Phone.PHONE_TYPE_SIP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.519 -0400", hash_original_field = "A55875FC41C2547C7109F2F532B60AE3", hash_generated_field = "3ADBC2EDBBFD9CFE0BB915AD0B7AB259")

    public static final int NETWORK_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.519 -0400", hash_original_field = "E55225DA6655F9FB6EB9C024BF82A8DF", hash_generated_field = "DF4F111D7D9CAFAE4BFDC86FEE1390B0")

    public static final int NETWORK_TYPE_GPRS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.520 -0400", hash_original_field = "61F14B9586D6398BD5127055E810F00F", hash_generated_field = "AFA157BE025D28F2633E52B67F5FF45D")

    public static final int NETWORK_TYPE_EDGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.520 -0400", hash_original_field = "575357F0A7A6BFAA052AAA853F582333", hash_generated_field = "4EE60A58FF3A6A827BAE8B3660FDDBEA")

    public static final int NETWORK_TYPE_UMTS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "775CF0D51734EB8CEF3507FCF5BFBADD", hash_generated_field = "17247A089138DB194E3C3689EB8D2C09")

    public static final int NETWORK_TYPE_CDMA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "0CABA5186481D2F15240B3C94724ABC9", hash_generated_field = "7059F2E3BF3949FC65A081A768BD3451")

    public static final int NETWORK_TYPE_EVDO_0 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "E6A1388F9B185090C006778CDA2CFDBF", hash_generated_field = "7F0F0403315A2164D626A0BC52B06414")

    public static final int NETWORK_TYPE_EVDO_A = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "F7A7D202F73482C4EC61E01D06110249", hash_generated_field = "CB357E9EDD52F69601CAE2082846D5E3")

    public static final int NETWORK_TYPE_1xRTT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "E48A9DF10A677149F085C7B5F7C0718A", hash_generated_field = "89CA7CBDC236075D3DF613C9FF78C239")

    public static final int NETWORK_TYPE_HSDPA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "44A7156A1F878A6DB346BA47A36E7211", hash_generated_field = "A2B013A8B7DBC1B768FDA8801DD88687")

    public static final int NETWORK_TYPE_HSUPA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "FC87D1554FFB7BB46BF08D1CEF629C48", hash_generated_field = "685F9ECE7B6483CF2B967E0CA7312169")

    public static final int NETWORK_TYPE_HSPA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "0E43EEEAE6BB6EF300DED0D70E98FF2B", hash_generated_field = "60079AE9B8FCBC7ADE140290C5E3832B")

    public static final int NETWORK_TYPE_IDEN = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "A24D35860A01193C134EBD0E9D0C0C23", hash_generated_field = "05A463A291C68559D8A2DA4399EC93B8")

    public static final int NETWORK_TYPE_EVDO_B = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "65B2C3B7993C2021079087462ABF4B64", hash_generated_field = "897972FB0146052AF9FE6A13C387063A")

    public static final int NETWORK_TYPE_LTE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "017ABDECFAA1C908D4E5E8EF5DF39C91", hash_generated_field = "3B80988B27EA0BE6E633061C7CF1BE85")

    public static final int NETWORK_TYPE_EHRPD = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "BD0E2321565D24AC2CD0A61F089767CF", hash_generated_field = "BD0BA401891F25C620F3110BD2DB15BC")

    public static final int NETWORK_TYPE_HSPAP = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "CE5C5B0F4B6E3C6B2AFC7C1B72C483E8", hash_generated_field = "7C7BEF03A11ED6F5B236D02E3AC76BB3")

    public static final int NETWORK_CLASS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "A87627CC53B5FFC7D1821690AF23B4BD", hash_generated_field = "952EAD66C73882790E8632EBDE3D0EEB")

    public static final int NETWORK_CLASS_2_G = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "FB0F44C286C43C6A6F3E8528A93D82B0", hash_generated_field = "16C334B31519B49DB6ACD1DE6C14E392")

    public static final int NETWORK_CLASS_3_G = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.540 -0400", hash_original_field = "FDD83C94EEE3D14F9B73E95BF24E3929", hash_generated_field = "0D5564D633DC921137687C883E4D0F99")

    public static final int NETWORK_CLASS_4_G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "4803464CC31FE860623B640A8F9C9181", hash_generated_field = "F1630542E3838A7ADD00A0BE8722AACE")

    public static final int SIM_STATE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "7B251AECF4F4E9032236E44C8AE417BA", hash_generated_field = "FE661F33A2994BC3BF316C87CD05115C")

    public static final int SIM_STATE_ABSENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "FA0C649B35BA21805999CC2832FEB1D2", hash_generated_field = "6C48EE683A7E78D23C00B92717DE5A22")

    public static final int SIM_STATE_PIN_REQUIRED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "997E1F0E8B724D2A61B435253EC3AEBB", hash_generated_field = "ABE24381CD34E62691DD2C4E93ED4A19")

    public static final int SIM_STATE_PUK_REQUIRED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "5FEA14412EFEF16CAF853FEAAD8F7412", hash_generated_field = "6EE0D9233BAFEC27F9B3BFDB79237527")

    public static final int SIM_STATE_NETWORK_LOCKED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "8F7C0EC531C2914B7B63A605E10BF111", hash_generated_field = "52957824F7E9EFEE70E933C4483F3560")

    public static final int SIM_STATE_READY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "3355B07218C1AAEDA389C55F2E4D4903", hash_generated_field = "880051CE2B272E830BA1E1C9C8EDFDAD")

    public static final int CALL_STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "0AB9BD5B9E7529913E150CF5786D7451", hash_generated_field = "EBF7E79274B936572A44F5AC97C350E9")

    public static final int CALL_STATE_RINGING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "DC1251E603711B7D70A8A4DDDF0D3DFA", hash_generated_field = "F1553B4E51E8E01AAC1228FBFF50DED7")

    public static final int CALL_STATE_OFFHOOK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "F512487C19B4E4DF3A0394C80D07E275", hash_generated_field = "6303BB7C9E2B830338C1836586DB6697")

    public static final int DATA_ACTIVITY_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "50E2E026EC9C664DC24FF36D29AD2CE8", hash_generated_field = "AC92BAFF5B1AACED092C2AF469A8CBD3")

    public static final int DATA_ACTIVITY_IN = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "3D515F46C6B9C8715B613648A4C421E3", hash_generated_field = "63CF83921BA898885E2AD57DC2D97303")

    public static final int DATA_ACTIVITY_OUT = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "A8505CE9C7C3D8B2A208A367E9F8017E", hash_generated_field = "E7682DD7C56FD243525F5233E80F53E4")

    public static final int DATA_ACTIVITY_INOUT = DATA_ACTIVITY_IN | DATA_ACTIVITY_OUT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "ED16AA52E2AD8783C5663A67E8494382", hash_generated_field = "0A134B76AF6D9DF50656A5FE58BE98FF")

    public static final int DATA_ACTIVITY_DORMANT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "39D416CC671EA6C04286C6438AC4DA0F", hash_generated_field = "FF8D51C8FEAAD0B22B077E1A375AC594")

    public static final int DATA_UNKNOWN        = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "EC19C258779D833C3D52C3F786F5890C", hash_generated_field = "C4C0880CDDF6725DBFD4E7B67714DE9B")

    public static final int DATA_DISCONNECTED   = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "48FF8856F44C088A8CE7CFDF5B291B4D", hash_generated_field = "FF9CE223A769E6D3636143EA9AC19C2B")

    public static final int DATA_CONNECTING     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.541 -0400", hash_original_field = "F415667E2FC38B9FD7C9BEFFCEF8C733", hash_generated_field = "794BB976A412F225595FC4181FE3FC75")

    public static final int DATA_CONNECTED      = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.542 -0400", hash_original_field = "8D70D003B5C75608EE7DA82B0BA5E330", hash_generated_field = "DC6EB947ED9360ECC33AC98BE7B1AAB6")

    public static final int DATA_SUSPENDED      = 3;
}

