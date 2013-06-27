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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.662 -0400", hash_original_method = "D511206E864FFF32983F1CF5D1263F8B", hash_generated_method = "A993F64614FEC88056E2A7A803A65A51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.666 -0400", hash_original_method = "8E4DE1903A24C15F73A151ACA155A108", hash_generated_method = "ED16BD9217E0E1C9750C925EEB9F2C13")
    private  TelephonyManager() {
        // ---------- Original Method ----------
    }

    
        public static TelephonyManager getDefault() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.684 -0400", hash_original_method = "CBA2DB54A66B89F7737C894703CB092B", hash_generated_method = "AF5390A735DBCBFEC2F5E2CAD0D68647")
    public String getDeviceSoftwareVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_733900161 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1493403372 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_322227862 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_733900161 = getSubscriberInfo().getDeviceSvn();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1493403372 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_322227862 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_2046993925; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2046993925 = varB4EAC82CA7396A68D541C85D26508E83_733900161;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2046993925 = varB4EAC82CA7396A68D541C85D26508E83_1493403372;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2046993925 = varB4EAC82CA7396A68D541C85D26508E83_322227862;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2046993925.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2046993925;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceSvn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.686 -0400", hash_original_method = "D15182A782B2311FD9923C2371701B25", hash_generated_method = "4BE3BC6B3D8D53F3F750CDCAB72E3A2C")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1166873676 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_60386375 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1685371925 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1166873676 = getSubscriberInfo().getDeviceId();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_60386375 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1685371925 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1426331852; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1426331852 = varB4EAC82CA7396A68D541C85D26508E83_1166873676;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1426331852 = varB4EAC82CA7396A68D541C85D26508E83_60386375;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1426331852 = varB4EAC82CA7396A68D541C85D26508E83_1685371925;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1426331852.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1426331852;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getDeviceId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.706 -0400", hash_original_method = "5E61A73DD3A54D24C69E0825B273DC95", hash_generated_method = "A0902090AA0B1465C53425EFA51DAD85")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_856238998 = null; //Variable for return #1
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1584037459 = null; //Variable for return #2
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_476440280 = null; //Variable for return #3
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_781438857 = null; //Variable for return #4
        try 
        {
            Bundle bundle;
            bundle = getITelephony().getCellLocation();
            CellLocation cl;
            cl = CellLocation.newFromBundle(bundle);
            {
                boolean var317C3CB3784625A6460A4542B041B297_1869163467 = (cl.isEmpty());
                varB4EAC82CA7396A68D541C85D26508E83_856238998 = null;
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1584037459 = cl;
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_476440280 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_781438857 = null;
        } //End block
        CellLocation varA7E53CE21691AB073D9660D615818899_755966451; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_755966451 = varB4EAC82CA7396A68D541C85D26508E83_856238998;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_755966451 = varB4EAC82CA7396A68D541C85D26508E83_1584037459;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_755966451 = varB4EAC82CA7396A68D541C85D26508E83_476440280;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_755966451 = varB4EAC82CA7396A68D541C85D26508E83_781438857;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_755966451.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_755966451;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.706 -0400", hash_original_method = "6D04BBFB8BC88B77ECB40D44848A65EA", hash_generated_method = "458D6743E4F46BB3AC3E4ACD477D329D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.707 -0400", hash_original_method = "3CD4D10099672E02B38D45C520AD59E4", hash_generated_method = "E013BCD17D1EA9C72A6B60AE740DB771")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.708 -0400", hash_original_method = "1B24CD9B4799B0CFE847058C4CF4C5E3", hash_generated_method = "93B88BE4CF2BCBE9A50C80651BCDCEEA")
    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_1019267669 = null; //Variable for return #1
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_1376100 = null; //Variable for return #2
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_783667178 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1019267669 = getITelephony().getNeighboringCellInfo();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1376100 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_783667178 = null;
        } //End block
        List<NeighboringCellInfo> varA7E53CE21691AB073D9660D615818899_985128330; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_985128330 = varB4EAC82CA7396A68D541C85D26508E83_1019267669;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_985128330 = varB4EAC82CA7396A68D541C85D26508E83_1376100;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_985128330 = varB4EAC82CA7396A68D541C85D26508E83_783667178;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_985128330.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_985128330;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getNeighboringCellInfo();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.709 -0400", hash_original_method = "7EF6D35F0DE2C86E385132A28BC64E8B", hash_generated_method = "B3D8A2F15C376884096233D1C895386C")
    public int getCurrentPhoneType() {
        try 
        {
            ITelephony telephony;
            telephony = getITelephony();
            {
                int var02112D65AFB7DC116D2A52A0D60D8BE5_45606715 = (telephony.getActivePhoneType());
            } //End block
            {
                int var59B2E48460729F59E7A28157BAB50763_1227633631 = (getPhoneTypeFromProperty());
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_2110430323 = (getPhoneTypeFromProperty());
        } //End block
        catch (NullPointerException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_966857691 = (getPhoneTypeFromProperty());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365963956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365963956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.710 -0400", hash_original_method = "0A507D7BB3876FB6AE8B7F4B411CB7D0", hash_generated_method = "9E190AB51BFA27F7D5023FF5CEB20846")
    public int getPhoneType() {
        {
            boolean var3F3CAC2823D51C3CFDE7D9F95AC1D73E_986253996 = (!isVoiceCapable());
        } //End collapsed parenthetic
        int varE671F9CAE03ACF5F8C18BEA23599BB43_748276658 = (getCurrentPhoneType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001812714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001812714;
        // ---------- Original Method ----------
        //if (!isVoiceCapable()) {
            //return PHONE_TYPE_NONE;
        //}
        //return getCurrentPhoneType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.720 -0400", hash_original_method = "AFA495B3EA5295146DEDE68ACDCEDE97", hash_generated_method = "6D9EC0EA0A5EF91E32B587470DA4DB1E")
    private int getPhoneTypeFromProperty() {
        int type;
        type = SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    getPhoneTypeFromNetworkType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422763193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422763193;
        // ---------- Original Method ----------
        //int type =
            //SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    //getPhoneTypeFromNetworkType());
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.720 -0400", hash_original_method = "64BB8AD229481F016ED315B563697438", hash_generated_method = "04082F21A31ED204C183E17AA1F62746")
    private int getPhoneTypeFromNetworkType() {
        int mode;
        mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        int varF8BEC291204F8330EC3241AB87D680C0_1702801871 = (PhoneFactory.getPhoneType(mode));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637913533 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637913533;
        // ---------- Original Method ----------
        //int mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        //if (mode == -1)
            //return PHONE_TYPE_NONE;
        //return PhoneFactory.getPhoneType(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.721 -0400", hash_original_method = "832612984320BCC9B2F167CB90709724", hash_generated_method = "8BE948F73EBA78F97B8C17E84CF10785")
    public String getNetworkOperatorName() {
        String varB4EAC82CA7396A68D541C85D26508E83_992283951 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_992283951 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
        varB4EAC82CA7396A68D541C85D26508E83_992283951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_992283951;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.722 -0400", hash_original_method = "C6C0AA4A9611C88887AD0284C9B9779A", hash_generated_method = "36FC7FF0B344928263DB586417B31659")
    public String getNetworkOperator() {
        String varB4EAC82CA7396A68D541C85D26508E83_1949934256 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1949934256 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
        varB4EAC82CA7396A68D541C85D26508E83_1949934256.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1949934256;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.737 -0400", hash_original_method = "B6A17594C3960A6046C8BF4D54C6D185", hash_generated_method = "CD98644E0BF2D9F4B99AC607BF7A4472")
    public boolean isNetworkRoaming() {
        boolean var7CCC8BA33120747ECAA380992352D963_310491483 = ("true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333235297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333235297;
        // ---------- Original Method ----------
        //return "true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.739 -0400", hash_original_method = "DDFD7BDCC0E0CF0AD038335E60C4F613", hash_generated_method = "995B4E3A6B68F368A5E0ECDC21EBC2B5")
    public String getNetworkCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_531733027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_531733027 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
        varB4EAC82CA7396A68D541C85D26508E83_531733027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_531733027;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.747 -0400", hash_original_method = "E55284324A887F7771FC58B52617EFF6", hash_generated_method = "D69EC90CCA307E9109C5BC143CF5095B")
    public int getNetworkType() {
        try 
        {
            ITelephony telephony;
            telephony = getITelephony();
            {
                int varBB3E4B10AC2DDE47109944FAD74ADA38_1813009683 = (telephony.getNetworkType());
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079660482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079660482;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.769 -0400", hash_original_method = "2CF054408BF0643DB5F15627D9964227", hash_generated_method = "17BF1655B61E3D8D88BF77C8932C6680")
    public String getNetworkTypeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1439246798 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1439246798 = getNetworkTypeName(getNetworkType());
        varB4EAC82CA7396A68D541C85D26508E83_1439246798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1439246798;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.772 -0400", hash_original_method = "B54BEBEEDA1D514B6ED30035D8F7A17F", hash_generated_method = "63F7360B4BBC4463DD90582BC2CAEE1F")
    public boolean hasIccCard() {
        try 
        {
            boolean var74498D7060EADCB8C4F6CF6D6BE7A0FF_1857597876 = (getITelephony().hasIccCard());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856472874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_856472874;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().hasIccCard();
        //} catch (RemoteException ex) {
            //return false;
        //} catch (NullPointerException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.772 -0400", hash_original_method = "09E0380F50AC76521F62251E25C950EA", hash_generated_method = "E65D32C21406961EACB5AF41E2402F8D")
    public int getSimState() {
        String prop;
        prop = SystemProperties.get(TelephonyProperties.PROPERTY_SIM_STATE);
        {
            boolean var656939FEF7D866D03F6ED0F92EBF27D3_793629833 = ("ABSENT".equals(prop));
            {
                boolean var70CB33CEB8F4069C6140C5CFEA6752B7_1956442113 = ("PIN_REQUIRED".equals(prop));
                {
                    boolean var90FBEC75DFA1A3628B25A46F0B119AA1_431497696 = ("PUK_REQUIRED".equals(prop));
                    {
                        boolean var5209DF38776E48B1D29ED96972A531A2_1587808811 = ("NETWORK_LOCKED".equals(prop));
                        {
                            boolean var9FFEABD8A87C0F145C76AB31A340E57B_1219961714 = ("READY".equals(prop));
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227591947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227591947;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.773 -0400", hash_original_method = "31C6D14DB3E72FC3C1A0B120DB42F405", hash_generated_method = "67336AB39F529AF7B9913E3DB3C02BFD")
    public String getSimOperator() {
        String varB4EAC82CA7396A68D541C85D26508E83_975424327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_975424327 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
        varB4EAC82CA7396A68D541C85D26508E83_975424327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_975424327;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.780 -0400", hash_original_method = "FF7B2BB8165B4DA3F4CA04B0E402231E", hash_generated_method = "B6290AF943A1864790C676145682A138")
    public String getSimOperatorName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1469194749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469194749 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
        varB4EAC82CA7396A68D541C85D26508E83_1469194749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469194749;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.798 -0400", hash_original_method = "86E21142AD28646E6483CDE3D9BD89F9", hash_generated_method = "32AAC2C53AD57B7BAE85CC8F184CB2F6")
    public String getSimCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_390729900 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_390729900 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
        varB4EAC82CA7396A68D541C85D26508E83_390729900.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_390729900;
        // ---------- Original Method ----------
        //return SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.799 -0400", hash_original_method = "2017CBA66707D72E2F76A9954FAEDD18", hash_generated_method = "F433795D87ED0643702C9ED463B90820")
    public String getSimSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_660675465 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_253677752 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1765783900 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_660675465 = getSubscriberInfo().getIccSerialNumber();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_253677752 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1765783900 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_343950364; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_343950364 = varB4EAC82CA7396A68D541C85D26508E83_660675465;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_343950364 = varB4EAC82CA7396A68D541C85D26508E83_253677752;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_343950364 = varB4EAC82CA7396A68D541C85D26508E83_1765783900;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_343950364.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_343950364;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIccSerialNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.804 -0400", hash_original_method = "EA3A591F5FC8CB370CDC207E1A4A9D6A", hash_generated_method = "F48B7B1AC89EBF4F46B6E265FD1AAA1F")
    public int getLteOnCdmaMode() {
        try 
        {
            int var29B7AA8EB74FFF815EDF62F09C7A13DE_337944272 = (getITelephony().getLteOnCdmaMode());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188589118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188589118;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getLteOnCdmaMode();
        //} catch (RemoteException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //} catch (NullPointerException ex) {
            //return Phone.LTE_ON_CDMA_UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.806 -0400", hash_original_method = "E78B911A34E3B997234FCD2FE0581326", hash_generated_method = "749F1AC9689F554B509AEB838D0408C6")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1599331592 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1986550268 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1125416870 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1599331592 = getSubscriberInfo().getSubscriberId();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1986550268 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1125416870 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_855249277; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_855249277 = varB4EAC82CA7396A68D541C85D26508E83_1599331592;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_855249277 = varB4EAC82CA7396A68D541C85D26508E83_1986550268;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_855249277 = varB4EAC82CA7396A68D541C85D26508E83_1125416870;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_855249277.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_855249277;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getSubscriberId();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.820 -0400", hash_original_method = "EE92449D081C56B70CB6173E1BAAB538", hash_generated_method = "D9CB622CBA7470D3166AA6E57F118165")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_204609089 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2038073811 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1046112165 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_204609089 = getSubscriberInfo().getLine1Number();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2038073811 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1046112165 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_316346614; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_316346614 = varB4EAC82CA7396A68D541C85D26508E83_204609089;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_316346614 = varB4EAC82CA7396A68D541C85D26508E83_2038073811;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_316346614 = varB4EAC82CA7396A68D541C85D26508E83_1046112165;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_316346614.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_316346614;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1Number();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.822 -0400", hash_original_method = "7B70034F9FC00AD85A334A6B1881279C", hash_generated_method = "8B0695C939D7E35D2C234A157CE08B86")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_152414394 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1460423046 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_531139644 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_152414394 = getSubscriberInfo().getLine1AlphaTag();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1460423046 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_531139644 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_993327842; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_993327842 = varB4EAC82CA7396A68D541C85D26508E83_152414394;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_993327842 = varB4EAC82CA7396A68D541C85D26508E83_1460423046;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_993327842 = varB4EAC82CA7396A68D541C85D26508E83_531139644;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_993327842.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_993327842;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getLine1AlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.823 -0400", hash_original_method = "FE1089A80F0C63E9B1494FCF93B412E1", hash_generated_method = "1DAF961C5A7A6D60CA1D3E07B32C8612")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1455269945 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2060212293 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1742914091 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1455269945 = getSubscriberInfo().getMsisdn();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2060212293 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1742914091 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1158883161; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1158883161 = varB4EAC82CA7396A68D541C85D26508E83_1455269945;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1158883161 = varB4EAC82CA7396A68D541C85D26508E83_2060212293;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1158883161 = varB4EAC82CA7396A68D541C85D26508E83_1742914091;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1158883161.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1158883161;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getMsisdn();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.827 -0400", hash_original_method = "8E528B053F49E44E27934FB8B1D79754", hash_generated_method = "372F81D3439E771089D57BBC97BD5B2E")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_713755283 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1794267634 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1675984256 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_713755283 = getSubscriberInfo().getVoiceMailNumber();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1794267634 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1675984256 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_236918842; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_236918842 = varB4EAC82CA7396A68D541C85D26508E83_713755283;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_236918842 = varB4EAC82CA7396A68D541C85D26508E83_1794267634;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_236918842 = varB4EAC82CA7396A68D541C85D26508E83_1675984256;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_236918842.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_236918842;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.835 -0400", hash_original_method = "6E4CD5DF61F1B6B4D99C4D48EBD42C25", hash_generated_method = "C969A695CE8E18B4E482647C6DB7D4A9")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1160312061 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1819809919 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1406897471 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1160312061 = getSubscriberInfo().getCompleteVoiceMailNumber();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1819809919 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1406897471 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_308149651; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_308149651 = varB4EAC82CA7396A68D541C85D26508E83_1160312061;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_308149651 = varB4EAC82CA7396A68D541C85D26508E83_1819809919;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_308149651 = varB4EAC82CA7396A68D541C85D26508E83_1406897471;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_308149651.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_308149651;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getCompleteVoiceMailNumber();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.836 -0400", hash_original_method = "8799C29F83D6241F3339A57C480A2568", hash_generated_method = "44EAF06D27028EAE2ABFBDE5A9ED48A1")
    public int getVoiceMessageCount() {
        try 
        {
            int var597A31B7365C84A57CFAEE70B622FC99_1591817001 = (getITelephony().getVoiceMessageCount());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443365116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443365116;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getVoiceMessageCount();
        //} catch (RemoteException ex) {
            //return 0;
        //} catch (NullPointerException ex) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.853 -0400", hash_original_method = "FCB9C7AA008FFD71198739B23DB8A42C", hash_generated_method = "3F764B4877C12F3EF502F51F23730AE2")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1683190325 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_764009357 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1387568889 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1683190325 = getSubscriberInfo().getVoiceMailAlphaTag();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_764009357 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1387568889 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_2064471389; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2064471389 = varB4EAC82CA7396A68D541C85D26508E83_1683190325;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2064471389 = varB4EAC82CA7396A68D541C85D26508E83_764009357;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2064471389 = varB4EAC82CA7396A68D541C85D26508E83_1387568889;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2064471389.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2064471389;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getVoiceMailAlphaTag();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.861 -0400", hash_original_method = "2827FC9BCC152817C9894DF874687A19", hash_generated_method = "CD257D438213C6CE946ADB823A782F64")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_1682188524 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_434811485 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_445957508 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1682188524 = getSubscriberInfo().getIsimImpi();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_434811485 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_445957508 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_167826148; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_167826148 = varB4EAC82CA7396A68D541C85D26508E83_1682188524;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_167826148 = varB4EAC82CA7396A68D541C85D26508E83_434811485;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_167826148 = varB4EAC82CA7396A68D541C85D26508E83_445957508;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_167826148.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_167826148;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpi();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.865 -0400", hash_original_method = "F4F2A7557A78EB2E07FE0C129F86CDF8", hash_generated_method = "006D21156D0E7B89EDE461EB1ABDACF6")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_879227637 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_26027388 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1759585376 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_879227637 = getSubscriberInfo().getIsimDomain();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_26027388 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1759585376 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_813212370; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_813212370 = varB4EAC82CA7396A68D541C85D26508E83_879227637;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_813212370 = varB4EAC82CA7396A68D541C85D26508E83_26027388;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_813212370 = varB4EAC82CA7396A68D541C85D26508E83_1759585376;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_813212370.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_813212370;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimDomain();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.881 -0400", hash_original_method = "87EA21FFDB592BB220CD2250977D3D81", hash_generated_method = "8832C913393E796B210D35B29D449E13")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1836518917 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_547266024 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_982422297 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1836518917 = getSubscriberInfo().getIsimImpu();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_547266024 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_982422297 = null;
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_1578413900; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1578413900 = varB4EAC82CA7396A68D541C85D26508E83_1836518917;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1578413900 = varB4EAC82CA7396A68D541C85D26508E83_547266024;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1578413900 = varB4EAC82CA7396A68D541C85D26508E83_982422297;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1578413900.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1578413900;
        // ---------- Original Method ----------
        //try {
            //return getSubscriberInfo().getIsimImpu();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.882 -0400", hash_original_method = "0499CDF49B310038A9BEEA0F802EAB63", hash_generated_method = "6D291A69637AE26A849DE9A30B3B131B")
    private IPhoneSubInfo getSubscriberInfo() {
        IPhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_2031550655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2031550655 = IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
        varB4EAC82CA7396A68D541C85D26508E83_2031550655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2031550655;
        // ---------- Original Method ----------
        //return IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.883 -0400", hash_original_method = "74E55F6F5CD1551C04A2C40DCD1EBD15", hash_generated_method = "EE706573427ED29CA13A6CE91393F760")
    public int getCallState() {
        try 
        {
            int var11FDA2929718CED1A97BBEADDCB6295E_236206651 = (getITelephony().getCallState());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840558047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840558047;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCallState();
        //} catch (RemoteException ex) {
            //return CALL_STATE_IDLE;
        //} catch (NullPointerException ex) {
          //return CALL_STATE_IDLE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.883 -0400", hash_original_method = "59E4B9880A04B49AB5E7CF82F18425E1", hash_generated_method = "0074EF905F9D34D3CA006E5A0C9BA5EB")
    public int getDataActivity() {
        try 
        {
            int var942CC87DE49A18402BCD05EEE3CD1C3D_217898108 = (getITelephony().getDataActivity());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461085436 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461085436;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataActivity();
        //} catch (RemoteException ex) {
            //return DATA_ACTIVITY_NONE;
        //} catch (NullPointerException ex) {
          //return DATA_ACTIVITY_NONE;
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.884 -0400", hash_original_method = "37205A4CB7441E0871F6B86EF9BDA019", hash_generated_method = "0D5C0BBCF56F9B3FAE340880FB84BC03")
    public int getDataState() {
        try 
        {
            int var914C29C6BEDE622C1C17EC919700D468_170803296 = (getITelephony().getDataState());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136711332 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136711332;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getDataState();
        //} catch (RemoteException ex) {
            //return DATA_DISCONNECTED;
        //} catch (NullPointerException ex) {
            //return DATA_DISCONNECTED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.892 -0400", hash_original_method = "7D101ED42BB684AED8CB9AC1B352231C", hash_generated_method = "EF069FBAE50931E716E202426D8CBF92")
    private ITelephony getITelephony() {
        ITelephony varB4EAC82CA7396A68D541C85D26508E83_997570023 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_997570023 = ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
        varB4EAC82CA7396A68D541C85D26508E83_997570023.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_997570023;
        // ---------- Original Method ----------
        //return ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.896 -0400", hash_original_method = "DC9C0A2F940DF23145CA1F74B7CF66E6", hash_generated_method = "F2B5BE907C66107E9AD4C06CB53AF0D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.900 -0400", hash_original_method = "94E639A6342206A666A9E9E564D3D41F", hash_generated_method = "FDFD1E4E0E174CB9DB33B0D4E109D9A4")
    public int getCdmaEriIconIndex() {
        try 
        {
            int var0DE1842BE7731F45B9E40B3EAE1DF080_1055257853 = (getITelephony().getCdmaEriIconIndex());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215686973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215686973;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconIndex();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.900 -0400", hash_original_method = "6E310C99A0183EA336ABBF86E9A26569", hash_generated_method = "45123B973BC6CF8969BB13268E9C9235")
    public int getCdmaEriIconMode() {
        try 
        {
            int var2E431383FA9B43BC42A9105446DC5E3E_593448411 = (getITelephony().getCdmaEriIconMode());
        } //End block
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924357186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924357186;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriIconMode();
        //} catch (RemoteException ex) {
            //return -1;
        //} catch (NullPointerException ex) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.911 -0400", hash_original_method = "70A8AFAFA7F0416F83BF728E9A3EFD1C", hash_generated_method = "ECADFA232490071A4301AFFB9B3F9139")
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_727062983 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1209975695 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_234466105 = null; //Variable for return #3
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_727062983 = getITelephony().getCdmaEriText();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1209975695 = null;
        } //End block
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_234466105 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_245932058; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_245932058 = varB4EAC82CA7396A68D541C85D26508E83_727062983;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_245932058 = varB4EAC82CA7396A68D541C85D26508E83_1209975695;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_245932058 = varB4EAC82CA7396A68D541C85D26508E83_234466105;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_245932058.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_245932058;
        // ---------- Original Method ----------
        //try {
            //return getITelephony().getCdmaEriText();
        //} catch (RemoteException ex) {
            //return null;
        //} catch (NullPointerException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.919 -0400", hash_original_method = "691764E468F6F648007F4B86271FE09B", hash_generated_method = "2DFB5414278A305C16F4022F1BC65710")
    public boolean isVoiceCapable() {
        boolean var2A02B989ADE5F351F5FC8A1EAED6F4D2_208779259 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196993169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196993169;
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_voice_capable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_method = "FA08C86737C7918898577956B7BAC60B", hash_generated_method = "33D13F2565FB43863D21E967B91A3029")
    public boolean isSmsCapable() {
        boolean var0F7ADAF88B8AB318218711339F43AFAA_7561826 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_sms_capable));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516139793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516139793;
        // ---------- Original Method ----------
        //if (sContext == null) return true;
        //return sContext.getResources().getBoolean(
                //com.android.internal.R.bool.config_sms_capable);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "E3A7492ADBD5D50FD2FD50813176DBDB", hash_generated_field = "892D0BCF313C867FAEA4FA4F98555EBD")

    private static String TAG = "TelephonyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "85E80EF1450B10017E4C79B6BDDE7990", hash_generated_field = "BB35128711B5DD286691A47454B04C39")

    private static Context sContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "AE4E730B47E7BAEAD5E5F31F32DF8F13", hash_generated_field = "582B8A11F267D0FC2F0A8BFE9E1B0E41")

    private static ITelephonyRegistry sRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "1586C7FD75CB36E072FB3C9CD55792C0", hash_generated_field = "255012CF538DDDD1C9746B5789864EE9")

    private static TelephonyManager sInstance = new TelephonyManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "607038FF7C7E9CF82E8EFF28D6EDCDB8", hash_generated_field = "94B958DD14B16242F602AC68B5B35D9B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PHONE_STATE_CHANGED =
            "android.intent.action.PHONE_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "42AF28D9501DF41B20B267FAD0E7F890", hash_generated_field = "ECA9CAE1305E7DD998C16171D7CBF2B3")

    public static final String EXTRA_STATE = Phone.STATE_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "B3B718BADBBF83619D359C67CAD58C7E", hash_generated_field = "644A2D46020DA7007B4595269AC70D14")

    public static final String EXTRA_STATE_IDLE = Phone.State.IDLE.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "5F83F81503133C654D45EA0EBB27BCBA", hash_generated_field = "5BA124B52973008E7CC271EAC7C7A168")

    public static final String EXTRA_STATE_RINGING = Phone.State.RINGING.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "A798F19AF8276E88814A96F47AFA8C8A", hash_generated_field = "AB0B945EFBEE7E5F54BE15055E7F173C")

    public static final String EXTRA_STATE_OFFHOOK = Phone.State.OFFHOOK.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.928 -0400", hash_original_field = "D6B17D5D61F6724D02C2153B1F3B1843", hash_generated_field = "A350D7682844B18DAE260769F2227CF5")

    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "4D1E695B0B0E12571331956AD39E7FFB", hash_generated_field = "78804DFF38A537862AA01355F9EAEE2D")

    public static final int PHONE_TYPE_NONE = Phone.PHONE_TYPE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "3DAA11A54CC0CD1C5DFE91C5B9068C5B", hash_generated_field = "D056262BD19D9D2B6080E6C65F89AAFE")

    public static final int PHONE_TYPE_GSM = Phone.PHONE_TYPE_GSM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "C73F0D264479302DB3A47B11C96F110C", hash_generated_field = "CA3A5930619F40D3AB8D9ED99A87151C")

    public static final int PHONE_TYPE_CDMA = Phone.PHONE_TYPE_CDMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "A40B9F4209BEDDD305F37BAEFDA2CCC9", hash_generated_field = "4B9088F6BA66C5DDA4BF5641DA27C4CE")

    public static final int PHONE_TYPE_SIP = Phone.PHONE_TYPE_SIP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "A55875FC41C2547C7109F2F532B60AE3", hash_generated_field = "3ADBC2EDBBFD9CFE0BB915AD0B7AB259")

    public static final int NETWORK_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "E55225DA6655F9FB6EB9C024BF82A8DF", hash_generated_field = "DF4F111D7D9CAFAE4BFDC86FEE1390B0")

    public static final int NETWORK_TYPE_GPRS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "61F14B9586D6398BD5127055E810F00F", hash_generated_field = "AFA157BE025D28F2633E52B67F5FF45D")

    public static final int NETWORK_TYPE_EDGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "575357F0A7A6BFAA052AAA853F582333", hash_generated_field = "4EE60A58FF3A6A827BAE8B3660FDDBEA")

    public static final int NETWORK_TYPE_UMTS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "775CF0D51734EB8CEF3507FCF5BFBADD", hash_generated_field = "17247A089138DB194E3C3689EB8D2C09")

    public static final int NETWORK_TYPE_CDMA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "0CABA5186481D2F15240B3C94724ABC9", hash_generated_field = "7059F2E3BF3949FC65A081A768BD3451")

    public static final int NETWORK_TYPE_EVDO_0 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "E6A1388F9B185090C006778CDA2CFDBF", hash_generated_field = "7F0F0403315A2164D626A0BC52B06414")

    public static final int NETWORK_TYPE_EVDO_A = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "F7A7D202F73482C4EC61E01D06110249", hash_generated_field = "CB357E9EDD52F69601CAE2082846D5E3")

    public static final int NETWORK_TYPE_1xRTT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "E48A9DF10A677149F085C7B5F7C0718A", hash_generated_field = "89CA7CBDC236075D3DF613C9FF78C239")

    public static final int NETWORK_TYPE_HSDPA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "44A7156A1F878A6DB346BA47A36E7211", hash_generated_field = "A2B013A8B7DBC1B768FDA8801DD88687")

    public static final int NETWORK_TYPE_HSUPA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "FC87D1554FFB7BB46BF08D1CEF629C48", hash_generated_field = "685F9ECE7B6483CF2B967E0CA7312169")

    public static final int NETWORK_TYPE_HSPA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "0E43EEEAE6BB6EF300DED0D70E98FF2B", hash_generated_field = "60079AE9B8FCBC7ADE140290C5E3832B")

    public static final int NETWORK_TYPE_IDEN = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.929 -0400", hash_original_field = "A24D35860A01193C134EBD0E9D0C0C23", hash_generated_field = "05A463A291C68559D8A2DA4399EC93B8")

    public static final int NETWORK_TYPE_EVDO_B = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "65B2C3B7993C2021079087462ABF4B64", hash_generated_field = "897972FB0146052AF9FE6A13C387063A")

    public static final int NETWORK_TYPE_LTE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "017ABDECFAA1C908D4E5E8EF5DF39C91", hash_generated_field = "3B80988B27EA0BE6E633061C7CF1BE85")

    public static final int NETWORK_TYPE_EHRPD = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "BD0E2321565D24AC2CD0A61F089767CF", hash_generated_field = "BD0BA401891F25C620F3110BD2DB15BC")

    public static final int NETWORK_TYPE_HSPAP = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "CE5C5B0F4B6E3C6B2AFC7C1B72C483E8", hash_generated_field = "7C7BEF03A11ED6F5B236D02E3AC76BB3")

    public static final int NETWORK_CLASS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "A87627CC53B5FFC7D1821690AF23B4BD", hash_generated_field = "952EAD66C73882790E8632EBDE3D0EEB")

    public static final int NETWORK_CLASS_2_G = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "FB0F44C286C43C6A6F3E8528A93D82B0", hash_generated_field = "16C334B31519B49DB6ACD1DE6C14E392")

    public static final int NETWORK_CLASS_3_G = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "FDD83C94EEE3D14F9B73E95BF24E3929", hash_generated_field = "0D5564D633DC921137687C883E4D0F99")

    public static final int NETWORK_CLASS_4_G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "4803464CC31FE860623B640A8F9C9181", hash_generated_field = "F1630542E3838A7ADD00A0BE8722AACE")

    public static final int SIM_STATE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "7B251AECF4F4E9032236E44C8AE417BA", hash_generated_field = "FE661F33A2994BC3BF316C87CD05115C")

    public static final int SIM_STATE_ABSENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.930 -0400", hash_original_field = "FA0C649B35BA21805999CC2832FEB1D2", hash_generated_field = "6C48EE683A7E78D23C00B92717DE5A22")

    public static final int SIM_STATE_PIN_REQUIRED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "997E1F0E8B724D2A61B435253EC3AEBB", hash_generated_field = "ABE24381CD34E62691DD2C4E93ED4A19")

    public static final int SIM_STATE_PUK_REQUIRED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "5FEA14412EFEF16CAF853FEAAD8F7412", hash_generated_field = "6EE0D9233BAFEC27F9B3BFDB79237527")

    public static final int SIM_STATE_NETWORK_LOCKED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "8F7C0EC531C2914B7B63A605E10BF111", hash_generated_field = "52957824F7E9EFEE70E933C4483F3560")

    public static final int SIM_STATE_READY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "3355B07218C1AAEDA389C55F2E4D4903", hash_generated_field = "880051CE2B272E830BA1E1C9C8EDFDAD")

    public static final int CALL_STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "0AB9BD5B9E7529913E150CF5786D7451", hash_generated_field = "EBF7E79274B936572A44F5AC97C350E9")

    public static final int CALL_STATE_RINGING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "DC1251E603711B7D70A8A4DDDF0D3DFA", hash_generated_field = "F1553B4E51E8E01AAC1228FBFF50DED7")

    public static final int CALL_STATE_OFFHOOK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "F512487C19B4E4DF3A0394C80D07E275", hash_generated_field = "6303BB7C9E2B830338C1836586DB6697")

    public static final int DATA_ACTIVITY_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "50E2E026EC9C664DC24FF36D29AD2CE8", hash_generated_field = "AC92BAFF5B1AACED092C2AF469A8CBD3")

    public static final int DATA_ACTIVITY_IN = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "3D515F46C6B9C8715B613648A4C421E3", hash_generated_field = "63CF83921BA898885E2AD57DC2D97303")

    public static final int DATA_ACTIVITY_OUT = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "A8505CE9C7C3D8B2A208A367E9F8017E", hash_generated_field = "E7682DD7C56FD243525F5233E80F53E4")

    public static final int DATA_ACTIVITY_INOUT = DATA_ACTIVITY_IN | DATA_ACTIVITY_OUT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.942 -0400", hash_original_field = "ED16AA52E2AD8783C5663A67E8494382", hash_generated_field = "0A134B76AF6D9DF50656A5FE58BE98FF")

    public static final int DATA_ACTIVITY_DORMANT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.943 -0400", hash_original_field = "39D416CC671EA6C04286C6438AC4DA0F", hash_generated_field = "FF8D51C8FEAAD0B22B077E1A375AC594")

    public static final int DATA_UNKNOWN        = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.943 -0400", hash_original_field = "EC19C258779D833C3D52C3F786F5890C", hash_generated_field = "C4C0880CDDF6725DBFD4E7B67714DE9B")

    public static final int DATA_DISCONNECTED   = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.943 -0400", hash_original_field = "48FF8856F44C088A8CE7CFDF5B291B4D", hash_generated_field = "FF9CE223A769E6D3636143EA9AC19C2B")

    public static final int DATA_CONNECTING     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.943 -0400", hash_original_field = "F415667E2FC38B9FD7C9BEFFCEF8C733", hash_generated_field = "794BB976A412F225595FC4181FE3FC75")

    public static final int DATA_CONNECTED      = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.943 -0400", hash_original_field = "8D70D003B5C75608EE7DA82B0BA5E330", hash_generated_field = "DC6EB947ED9360ECC33AC98BE7B1AAB6")

    public static final int DATA_SUSPENDED      = 3;
}

