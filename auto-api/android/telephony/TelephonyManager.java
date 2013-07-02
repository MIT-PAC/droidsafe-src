package android.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.351 -0400", hash_original_method = "D511206E864FFF32983F1CF5D1263F8B", hash_generated_method = "E825486FE422BE2B1F2A5736E1E2C75A")
    public  TelephonyManager(Context context) {
        {
            Context appContext = context.getApplicationContext();
            {
                sContext = appContext;
            } 
            {
                sContext = context;
            } 
            sRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
        } 
        addTaint(context.getTaint());
        
        
            
            
                
            
                
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.352 -0400", hash_original_method = "8E4DE1903A24C15F73A151ACA155A108", hash_generated_method = "ED16BD9217E0E1C9750C925EEB9F2C13")
    private  TelephonyManager() {
        
    }

    
    public static TelephonyManager getDefault() {
        return sInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.353 -0400", hash_original_method = "CBA2DB54A66B89F7737C894703CB092B", hash_generated_method = "5F446A0028B6E2D163E8514F971C11B4")
    public String getDeviceSoftwareVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_495847579 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_521342252 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1537465922 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_495847579 = getSubscriberInfo().getDeviceSvn();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_521342252 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1537465922 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1743005763; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1743005763 = varB4EAC82CA7396A68D541C85D26508E83_495847579;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1743005763 = varB4EAC82CA7396A68D541C85D26508E83_521342252;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1743005763 = varB4EAC82CA7396A68D541C85D26508E83_1537465922;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1743005763.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1743005763;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.354 -0400", hash_original_method = "D15182A782B2311FD9923C2371701B25", hash_generated_method = "0AF4A3292944458A588081AFB1928439")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_745541266 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_669149007 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1015712356 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_745541266 = getSubscriberInfo().getDeviceId();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_669149007 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1015712356 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_791927408; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_791927408 = varB4EAC82CA7396A68D541C85D26508E83_745541266;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_791927408 = varB4EAC82CA7396A68D541C85D26508E83_669149007;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_791927408 = varB4EAC82CA7396A68D541C85D26508E83_1015712356;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_791927408.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_791927408;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.355 -0400", hash_original_method = "5E61A73DD3A54D24C69E0825B273DC95", hash_generated_method = "D73BE8AA07A65AFDF70A71889B3FF488")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_2066523333 = null; 
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_301043953 = null; 
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_819431653 = null; 
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1144755143 = null; 
        try 
        {
            Bundle bundle = getITelephony().getCellLocation();
            CellLocation cl = CellLocation.newFromBundle(bundle);
            {
                boolean var317C3CB3784625A6460A4542B041B297_158832936 = (cl.isEmpty());
                varB4EAC82CA7396A68D541C85D26508E83_2066523333 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_301043953 = cl;
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_819431653 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1144755143 = null;
        } 
        CellLocation varA7E53CE21691AB073D9660D615818899_1096089330; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1096089330 = varB4EAC82CA7396A68D541C85D26508E83_2066523333;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1096089330 = varB4EAC82CA7396A68D541C85D26508E83_301043953;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1096089330 = varB4EAC82CA7396A68D541C85D26508E83_819431653;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1096089330 = varB4EAC82CA7396A68D541C85D26508E83_1144755143;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1096089330.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1096089330;
        
        
            
            
            
                
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.355 -0400", hash_original_method = "6D04BBFB8BC88B77ECB40D44848A65EA", hash_generated_method = "458D6743E4F46BB3AC3E4ACD477D329D")
    public void enableLocationUpdates() {
        try 
        {
            getITelephony().enableLocationUpdates();
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.356 -0400", hash_original_method = "3CD4D10099672E02B38D45C520AD59E4", hash_generated_method = "E013BCD17D1EA9C72A6B60AE740DB771")
    public void disableLocationUpdates() {
        try 
        {
            getITelephony().disableLocationUpdates();
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.356 -0400", hash_original_method = "1B24CD9B4799B0CFE847058C4CF4C5E3", hash_generated_method = "A367C14212A4DE8F1C968DB59ECE45BF")
    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_1191098115 = null; 
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_2077706522 = null; 
        List<NeighboringCellInfo> varB4EAC82CA7396A68D541C85D26508E83_1284315628 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1191098115 = getITelephony().getNeighboringCellInfo();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2077706522 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1284315628 = null;
        } 
        List<NeighboringCellInfo> varA7E53CE21691AB073D9660D615818899_1421144257; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1421144257 = varB4EAC82CA7396A68D541C85D26508E83_1191098115;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1421144257 = varB4EAC82CA7396A68D541C85D26508E83_2077706522;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1421144257 = varB4EAC82CA7396A68D541C85D26508E83_1284315628;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1421144257.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1421144257;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.357 -0400", hash_original_method = "7EF6D35F0DE2C86E385132A28BC64E8B", hash_generated_method = "202CB83705E8D686DBA014E974E0126F")
    public int getCurrentPhoneType() {
        try 
        {
            ITelephony telephony = getITelephony();
            {
                int var02112D65AFB7DC116D2A52A0D60D8BE5_1955833662 = (telephony.getActivePhoneType());
            } 
            {
                int var59B2E48460729F59E7A28157BAB50763_403437237 = (getPhoneTypeFromProperty());
            } 
        } 
        catch (RemoteException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_1279209662 = (getPhoneTypeFromProperty());
        } 
        catch (NullPointerException ex)
        {
            int var043A9E2EE87127705D7D4D34431A9F8F_1130440266 = (getPhoneTypeFromProperty());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829128166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829128166;
        
        
            
            
                
            
                
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.357 -0400", hash_original_method = "0A507D7BB3876FB6AE8B7F4B411CB7D0", hash_generated_method = "DC3F0F533D1808F847043121EAE326BA")
    public int getPhoneType() {
        {
            boolean var3F3CAC2823D51C3CFDE7D9F95AC1D73E_1519593669 = (!isVoiceCapable());
        } 
        int varE671F9CAE03ACF5F8C18BEA23599BB43_1777390850 = (getCurrentPhoneType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_775500540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_775500540;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.358 -0400", hash_original_method = "AFA495B3EA5295146DEDE68ACDCEDE97", hash_generated_method = "7745BD75FE8B49DF252BCFA9C5FCC4FA")
    private int getPhoneTypeFromProperty() {
        int type = SystemProperties.getInt(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                    getPhoneTypeFromNetworkType());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693185601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693185601;
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.358 -0400", hash_original_method = "64BB8AD229481F016ED315B563697438", hash_generated_method = "E3E2C42E4E3EC9F79583693DFAA47DBC")
    private int getPhoneTypeFromNetworkType() {
        int mode = SystemProperties.getInt("ro.telephony.default_network", -1);
        int varF8BEC291204F8330EC3241AB87D680C0_1434979868 = (PhoneFactory.getPhoneType(mode));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469214284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469214284;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.358 -0400", hash_original_method = "832612984320BCC9B2F167CB90709724", hash_generated_method = "E5DB0F351BE458099AC2B2FFC923ED19")
    public String getNetworkOperatorName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1132929105 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1132929105 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ALPHA);
        varB4EAC82CA7396A68D541C85D26508E83_1132929105.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1132929105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.359 -0400", hash_original_method = "C6C0AA4A9611C88887AD0284C9B9779A", hash_generated_method = "47FC68331E2D2562B3C1A3C55EED665C")
    public String getNetworkOperator() {
        String varB4EAC82CA7396A68D541C85D26508E83_1708112435 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1708112435 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
        varB4EAC82CA7396A68D541C85D26508E83_1708112435.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1708112435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.359 -0400", hash_original_method = "B6A17594C3960A6046C8BF4D54C6D185", hash_generated_method = "591B126779F9892E882C967CB3CD4F4E")
    public boolean isNetworkRoaming() {
        boolean var7CCC8BA33120747ECAA380992352D963_1765938235 = ("true".equals(SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071068118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071068118;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.360 -0400", hash_original_method = "DDFD7BDCC0E0CF0AD038335E60C4F613", hash_generated_method = "A7D5996BB128B655F578CE2AB7588103")
    public String getNetworkCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_1480909559 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1480909559 = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
        varB4EAC82CA7396A68D541C85D26508E83_1480909559.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1480909559;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.360 -0400", hash_original_method = "E55284324A887F7771FC58B52617EFF6", hash_generated_method = "91DEA030B784C896F942E5B65C2853EB")
    public int getNetworkType() {
        try 
        {
            ITelephony telephony = getITelephony();
            {
                int varBB3E4B10AC2DDE47109944FAD74ADA38_1064080140 = (telephony.getNetworkType());
            } 
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707381427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707381427;
        
        
            
            
                
            
                
            
        
            
        
            
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.361 -0400", hash_original_method = "2CF054408BF0643DB5F15627D9964227", hash_generated_method = "77D9C9B5DCB12C486144504791C88473")
    public String getNetworkTypeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2043782015 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2043782015 = getNetworkTypeName(getNetworkType());
        varB4EAC82CA7396A68D541C85D26508E83_2043782015.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2043782015;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.361 -0400", hash_original_method = "B54BEBEEDA1D514B6ED30035D8F7A17F", hash_generated_method = "4FC8357F520430BFBFCDC3213C8B395F")
    public boolean hasIccCard() {
        try 
        {
            boolean var74498D7060EADCB8C4F6CF6D6BE7A0FF_1335424343 = (getITelephony().hasIccCard());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084696318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084696318;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.362 -0400", hash_original_method = "09E0380F50AC76521F62251E25C950EA", hash_generated_method = "A776E1B2F9D5340E2E0101B7F3834DBE")
    public int getSimState() {
        String prop = SystemProperties.get(TelephonyProperties.PROPERTY_SIM_STATE);
        {
            boolean var656939FEF7D866D03F6ED0F92EBF27D3_592245822 = ("ABSENT".equals(prop));
            {
                boolean var70CB33CEB8F4069C6140C5CFEA6752B7_1752667159 = ("PIN_REQUIRED".equals(prop));
                {
                    boolean var90FBEC75DFA1A3628B25A46F0B119AA1_120033231 = ("PUK_REQUIRED".equals(prop));
                    {
                        boolean var5209DF38776E48B1D29ED96972A531A2_219078825 = ("NETWORK_LOCKED".equals(prop));
                        {
                            boolean var9FFEABD8A87C0F145C76AB31A340E57B_1695796124 = ("READY".equals(prop));
                        } 
                    } 
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971602253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971602253;
        
        
        
            
        
        
            
        
        
            
        
        
            
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.363 -0400", hash_original_method = "31C6D14DB3E72FC3C1A0B120DB42F405", hash_generated_method = "B30A5C308DA75DA2B765A9943BB31249")
    public String getSimOperator() {
        String varB4EAC82CA7396A68D541C85D26508E83_755545306 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_755545306 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC);
        varB4EAC82CA7396A68D541C85D26508E83_755545306.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_755545306;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.364 -0400", hash_original_method = "FF7B2BB8165B4DA3F4CA04B0E402231E", hash_generated_method = "979AF69922E86AF419FE3B6A24CAA2AD")
    public String getSimOperatorName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1462883806 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1462883806 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA);
        varB4EAC82CA7396A68D541C85D26508E83_1462883806.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1462883806;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.367 -0400", hash_original_method = "86E21142AD28646E6483CDE3D9BD89F9", hash_generated_method = "AE9BC8F60B9FAEEF9496536F30A1112E")
    public String getSimCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_432352722 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_432352722 = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY);
        varB4EAC82CA7396A68D541C85D26508E83_432352722.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_432352722;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.368 -0400", hash_original_method = "2017CBA66707D72E2F76A9954FAEDD18", hash_generated_method = "D7DF7AB1550637F413474267666739BF")
    public String getSimSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_594992168 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1136004036 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_379878179 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_594992168 = getSubscriberInfo().getIccSerialNumber();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1136004036 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_379878179 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_642959957; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_642959957 = varB4EAC82CA7396A68D541C85D26508E83_594992168;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_642959957 = varB4EAC82CA7396A68D541C85D26508E83_1136004036;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_642959957 = varB4EAC82CA7396A68D541C85D26508E83_379878179;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_642959957.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_642959957;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.369 -0400", hash_original_method = "EA3A591F5FC8CB370CDC207E1A4A9D6A", hash_generated_method = "72FCA7E860383E71FA7E7B15C924D151")
    public int getLteOnCdmaMode() {
        try 
        {
            int var29B7AA8EB74FFF815EDF62F09C7A13DE_1434749703 = (getITelephony().getLteOnCdmaMode());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1488296028 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1488296028;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.369 -0400", hash_original_method = "E78B911A34E3B997234FCD2FE0581326", hash_generated_method = "76D992C8A8B0CB6E1D746C77EE54A6DC")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1938225334 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2042507383 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1007581078 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1938225334 = getSubscriberInfo().getSubscriberId();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2042507383 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1007581078 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_139741246; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_139741246 = varB4EAC82CA7396A68D541C85D26508E83_1938225334;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_139741246 = varB4EAC82CA7396A68D541C85D26508E83_2042507383;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_139741246 = varB4EAC82CA7396A68D541C85D26508E83_1007581078;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_139741246.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_139741246;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.370 -0400", hash_original_method = "EE92449D081C56B70CB6173E1BAAB538", hash_generated_method = "14252048AFB4F6FA73DF127E7C89AFFD")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_326222782 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1839827400 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_994641146 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_326222782 = getSubscriberInfo().getLine1Number();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1839827400 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_994641146 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_555574179; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_555574179 = varB4EAC82CA7396A68D541C85D26508E83_326222782;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_555574179 = varB4EAC82CA7396A68D541C85D26508E83_1839827400;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_555574179 = varB4EAC82CA7396A68D541C85D26508E83_994641146;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_555574179.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_555574179;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.371 -0400", hash_original_method = "7B70034F9FC00AD85A334A6B1881279C", hash_generated_method = "2DB9841CCFB12F8259828155616393BB")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1796231366 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1003516572 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1958982600 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1796231366 = getSubscriberInfo().getLine1AlphaTag();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1003516572 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1958982600 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1781979349; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1781979349 = varB4EAC82CA7396A68D541C85D26508E83_1796231366;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1781979349 = varB4EAC82CA7396A68D541C85D26508E83_1003516572;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1781979349 = varB4EAC82CA7396A68D541C85D26508E83_1958982600;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1781979349.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1781979349;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.372 -0400", hash_original_method = "FE1089A80F0C63E9B1494FCF93B412E1", hash_generated_method = "CDAF89D518FA58D5C4A0172C4F1EC25D")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_928615085 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_784915963 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_515964965 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_928615085 = getSubscriberInfo().getMsisdn();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_784915963 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_515964965 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_2005453874; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2005453874 = varB4EAC82CA7396A68D541C85D26508E83_928615085;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2005453874 = varB4EAC82CA7396A68D541C85D26508E83_784915963;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2005453874 = varB4EAC82CA7396A68D541C85D26508E83_515964965;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2005453874.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2005453874;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.372 -0400", hash_original_method = "8E528B053F49E44E27934FB8B1D79754", hash_generated_method = "BE18D59ED8AED7D326175FD74747577B")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_493131882 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1311179765 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_295815015 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_493131882 = getSubscriberInfo().getVoiceMailNumber();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1311179765 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_295815015 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1125285010; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1125285010 = varB4EAC82CA7396A68D541C85D26508E83_493131882;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1125285010 = varB4EAC82CA7396A68D541C85D26508E83_1311179765;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1125285010 = varB4EAC82CA7396A68D541C85D26508E83_295815015;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1125285010.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1125285010;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.373 -0400", hash_original_method = "6E4CD5DF61F1B6B4D99C4D48EBD42C25", hash_generated_method = "9EA960E09173EDB89BFF0E0F71E4563D")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_943377881 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_333300433 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_334860110 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_943377881 = getSubscriberInfo().getCompleteVoiceMailNumber();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_333300433 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_334860110 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_429604125; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_429604125 = varB4EAC82CA7396A68D541C85D26508E83_943377881;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_429604125 = varB4EAC82CA7396A68D541C85D26508E83_333300433;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_429604125 = varB4EAC82CA7396A68D541C85D26508E83_334860110;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_429604125.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_429604125;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.374 -0400", hash_original_method = "8799C29F83D6241F3339A57C480A2568", hash_generated_method = "0314264AACB1C8FA18F8D5B6B084297F")
    public int getVoiceMessageCount() {
        try 
        {
            int var597A31B7365C84A57CFAEE70B622FC99_1556849339 = (getITelephony().getVoiceMessageCount());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718733323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718733323;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.374 -0400", hash_original_method = "FCB9C7AA008FFD71198739B23DB8A42C", hash_generated_method = "D1081101187B27190E53655C4AC595A6")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_267532466 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_675855755 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1475144263 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_267532466 = getSubscriberInfo().getVoiceMailAlphaTag();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_675855755 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1475144263 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1390986301; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1390986301 = varB4EAC82CA7396A68D541C85D26508E83_267532466;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1390986301 = varB4EAC82CA7396A68D541C85D26508E83_675855755;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1390986301 = varB4EAC82CA7396A68D541C85D26508E83_1475144263;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1390986301.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1390986301;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.376 -0400", hash_original_method = "2827FC9BCC152817C9894DF874687A19", hash_generated_method = "3D5DCD2FF2F603ACB13F9378349594E5")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_2045314102 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1290964214 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_998819321 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2045314102 = getSubscriberInfo().getIsimImpi();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1290964214 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_998819321 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_895667345; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_895667345 = varB4EAC82CA7396A68D541C85D26508E83_2045314102;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_895667345 = varB4EAC82CA7396A68D541C85D26508E83_1290964214;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_895667345 = varB4EAC82CA7396A68D541C85D26508E83_998819321;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_895667345.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_895667345;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.377 -0400", hash_original_method = "F4F2A7557A78EB2E07FE0C129F86CDF8", hash_generated_method = "6626DD70964F8C8F19FDAF2DDDD6182D")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1842854905 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_856695724 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_327205739 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1842854905 = getSubscriberInfo().getIsimDomain();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_856695724 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_327205739 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_490758783; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_490758783 = varB4EAC82CA7396A68D541C85D26508E83_1842854905;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_490758783 = varB4EAC82CA7396A68D541C85D26508E83_856695724;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_490758783 = varB4EAC82CA7396A68D541C85D26508E83_327205739;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_490758783.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_490758783;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.378 -0400", hash_original_method = "87EA21FFDB592BB220CD2250977D3D81", hash_generated_method = "7E001261A15C66C909C8743E212B337C")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_935130852 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1961095887 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1495526378 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_935130852 = getSubscriberInfo().getIsimImpu();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1961095887 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1495526378 = null;
        } 
        String[] varA7E53CE21691AB073D9660D615818899_755529233; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_755529233 = varB4EAC82CA7396A68D541C85D26508E83_935130852;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_755529233 = varB4EAC82CA7396A68D541C85D26508E83_1961095887;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_755529233 = varB4EAC82CA7396A68D541C85D26508E83_1495526378;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_755529233.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_755529233;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.379 -0400", hash_original_method = "0499CDF49B310038A9BEEA0F802EAB63", hash_generated_method = "DC6FBC1788C6DB9EBCEA2A47048FC90E")
    private IPhoneSubInfo getSubscriberInfo() {
        IPhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_1039557155 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1039557155 = IPhoneSubInfo.Stub.asInterface(ServiceManager.getService("iphonesubinfo"));
        varB4EAC82CA7396A68D541C85D26508E83_1039557155.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1039557155;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.380 -0400", hash_original_method = "74E55F6F5CD1551C04A2C40DCD1EBD15", hash_generated_method = "49E4F0F2CEA3C4CB9C3CD8FCFB80F5B9")
    public int getCallState() {
        try 
        {
            int var11FDA2929718CED1A97BBEADDCB6295E_146584920 = (getITelephony().getCallState());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753884156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753884156;
        
        
            
        
            
        
          
      
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.380 -0400", hash_original_method = "59E4B9880A04B49AB5E7CF82F18425E1", hash_generated_method = "CB1C4063E61328BF87369835438F25DF")
    public int getDataActivity() {
        try 
        {
            int var942CC87DE49A18402BCD05EEE3CD1C3D_1844223602 = (getITelephony().getDataActivity());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122026210 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122026210;
        
        
            
        
            
        
          
      
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.380 -0400", hash_original_method = "37205A4CB7441E0871F6B86EF9BDA019", hash_generated_method = "1112E656F7923D9DCDE224A6D094F1CE")
    public int getDataState() {
        try 
        {
            int var914C29C6BEDE622C1C17EC919700D468_2012459683 = (getITelephony().getDataState());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312450505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312450505;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.381 -0400", hash_original_method = "7D101ED42BB684AED8CB9AC1B352231C", hash_generated_method = "86E68BB4878665D832A0944A686F741B")
    private ITelephony getITelephony() {
        ITelephony varB4EAC82CA7396A68D541C85D26508E83_1087617491 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1087617491 = ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
        varB4EAC82CA7396A68D541C85D26508E83_1087617491.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1087617491;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.381 -0400", hash_original_method = "DC9C0A2F940DF23145CA1F74B7CF66E6", hash_generated_method = "848A6BFBEA8677F0A1B49D5A9C03BFA3")
    public void listen(PhoneStateListener listener, int events) {
        String pkgForDebug;
        pkgForDebug = sContext.getPackageName();
        pkgForDebug = "<unknown>";
        try 
        {
            Boolean notifyNow = (getITelephony() != null);
            sRegistry.listen(pkgForDebug, listener.callback, events, notifyNow);
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        addTaint(listener.getTaint());
        addTaint(events);
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.382 -0400", hash_original_method = "94E639A6342206A666A9E9E564D3D41F", hash_generated_method = "60935EF36E9F236B4D068403A1B3669B")
    public int getCdmaEriIconIndex() {
        try 
        {
            int var0DE1842BE7731F45B9E40B3EAE1DF080_578611415 = (getITelephony().getCdmaEriIconIndex());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129544598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129544598;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.382 -0400", hash_original_method = "6E310C99A0183EA336ABBF86E9A26569", hash_generated_method = "2E33DF126409EB58189FD225D79294E6")
    public int getCdmaEriIconMode() {
        try 
        {
            int var2E431383FA9B43BC42A9105446DC5E3E_458943053 = (getITelephony().getCdmaEriIconMode());
        } 
        catch (RemoteException ex)
        { }
        catch (NullPointerException ex)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853782037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_853782037;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.383 -0400", hash_original_method = "70A8AFAFA7F0416F83BF728E9A3EFD1C", hash_generated_method = "BEE2B6DE9185DC81F1816F20816A6DD1")
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_182627055 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1404063971 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1415856576 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_182627055 = getITelephony().getCdmaEriText();
        } 
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1404063971 = null;
        } 
        catch (NullPointerException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1415856576 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_136455898; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_136455898 = varB4EAC82CA7396A68D541C85D26508E83_182627055;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_136455898 = varB4EAC82CA7396A68D541C85D26508E83_1404063971;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_136455898 = varB4EAC82CA7396A68D541C85D26508E83_1415856576;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_136455898.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_136455898;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.383 -0400", hash_original_method = "691764E468F6F648007F4B86271FE09B", hash_generated_method = "1BCAF50505A3EC23EA137E39A5FB2436")
    public boolean isVoiceCapable() {
        boolean var2A02B989ADE5F351F5FC8A1EAED6F4D2_1414819992 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537822069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_537822069;
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_method = "FA08C86737C7918898577956B7BAC60B", hash_generated_method = "CF802C3B8C8C155BD16F73DA54C10BDA")
    public boolean isSmsCapable() {
        boolean var0F7ADAF88B8AB318218711339F43AFAA_1967851568 = (sContext.getResources().getBoolean(
                com.android.internal.R.bool.config_sms_capable));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476002552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476002552;
        
        
        
                
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "E3A7492ADBD5D50FD2FD50813176DBDB", hash_generated_field = "FED661308A0D1EFA713B1ED05D1D257D")

    private static final String TAG = "TelephonyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "85E80EF1450B10017E4C79B6BDDE7990", hash_generated_field = "BB35128711B5DD286691A47454B04C39")

    private static Context sContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "AE4E730B47E7BAEAD5E5F31F32DF8F13", hash_generated_field = "582B8A11F267D0FC2F0A8BFE9E1B0E41")

    private static ITelephonyRegistry sRegistry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "1586C7FD75CB36E072FB3C9CD55792C0", hash_generated_field = "255012CF538DDDD1C9746B5789864EE9")

    private static TelephonyManager sInstance = new TelephonyManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "607038FF7C7E9CF82E8EFF28D6EDCDB8", hash_generated_field = "94B958DD14B16242F602AC68B5B35D9B")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PHONE_STATE_CHANGED =
            "android.intent.action.PHONE_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "42AF28D9501DF41B20B267FAD0E7F890", hash_generated_field = "ECA9CAE1305E7DD998C16171D7CBF2B3")

    public static final String EXTRA_STATE = Phone.STATE_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "B3B718BADBBF83619D359C67CAD58C7E", hash_generated_field = "644A2D46020DA7007B4595269AC70D14")

    public static final String EXTRA_STATE_IDLE = Phone.State.IDLE.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "5F83F81503133C654D45EA0EBB27BCBA", hash_generated_field = "5BA124B52973008E7CC271EAC7C7A168")

    public static final String EXTRA_STATE_RINGING = Phone.State.RINGING.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "A798F19AF8276E88814A96F47AFA8C8A", hash_generated_field = "AB0B945EFBEE7E5F54BE15055E7F173C")

    public static final String EXTRA_STATE_OFFHOOK = Phone.State.OFFHOOK.toString();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "D6B17D5D61F6724D02C2153B1F3B1843", hash_generated_field = "A350D7682844B18DAE260769F2227CF5")

    public static final String EXTRA_INCOMING_NUMBER = "incoming_number";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "4D1E695B0B0E12571331956AD39E7FFB", hash_generated_field = "78804DFF38A537862AA01355F9EAEE2D")

    public static final int PHONE_TYPE_NONE = Phone.PHONE_TYPE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "3DAA11A54CC0CD1C5DFE91C5B9068C5B", hash_generated_field = "D056262BD19D9D2B6080E6C65F89AAFE")

    public static final int PHONE_TYPE_GSM = Phone.PHONE_TYPE_GSM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "C73F0D264479302DB3A47B11C96F110C", hash_generated_field = "CA3A5930619F40D3AB8D9ED99A87151C")

    public static final int PHONE_TYPE_CDMA = Phone.PHONE_TYPE_CDMA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "A40B9F4209BEDDD305F37BAEFDA2CCC9", hash_generated_field = "4B9088F6BA66C5DDA4BF5641DA27C4CE")

    public static final int PHONE_TYPE_SIP = Phone.PHONE_TYPE_SIP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "A55875FC41C2547C7109F2F532B60AE3", hash_generated_field = "3ADBC2EDBBFD9CFE0BB915AD0B7AB259")

    public static final int NETWORK_TYPE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "E55225DA6655F9FB6EB9C024BF82A8DF", hash_generated_field = "DF4F111D7D9CAFAE4BFDC86FEE1390B0")

    public static final int NETWORK_TYPE_GPRS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "61F14B9586D6398BD5127055E810F00F", hash_generated_field = "AFA157BE025D28F2633E52B67F5FF45D")

    public static final int NETWORK_TYPE_EDGE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "575357F0A7A6BFAA052AAA853F582333", hash_generated_field = "4EE60A58FF3A6A827BAE8B3660FDDBEA")

    public static final int NETWORK_TYPE_UMTS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "775CF0D51734EB8CEF3507FCF5BFBADD", hash_generated_field = "17247A089138DB194E3C3689EB8D2C09")

    public static final int NETWORK_TYPE_CDMA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "0CABA5186481D2F15240B3C94724ABC9", hash_generated_field = "7059F2E3BF3949FC65A081A768BD3451")

    public static final int NETWORK_TYPE_EVDO_0 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "E6A1388F9B185090C006778CDA2CFDBF", hash_generated_field = "7F0F0403315A2164D626A0BC52B06414")

    public static final int NETWORK_TYPE_EVDO_A = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "F7A7D202F73482C4EC61E01D06110249", hash_generated_field = "CB357E9EDD52F69601CAE2082846D5E3")

    public static final int NETWORK_TYPE_1xRTT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "E48A9DF10A677149F085C7B5F7C0718A", hash_generated_field = "89CA7CBDC236075D3DF613C9FF78C239")

    public static final int NETWORK_TYPE_HSDPA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "44A7156A1F878A6DB346BA47A36E7211", hash_generated_field = "A2B013A8B7DBC1B768FDA8801DD88687")

    public static final int NETWORK_TYPE_HSUPA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "FC87D1554FFB7BB46BF08D1CEF629C48", hash_generated_field = "685F9ECE7B6483CF2B967E0CA7312169")

    public static final int NETWORK_TYPE_HSPA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "0E43EEEAE6BB6EF300DED0D70E98FF2B", hash_generated_field = "60079AE9B8FCBC7ADE140290C5E3832B")

    public static final int NETWORK_TYPE_IDEN = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "A24D35860A01193C134EBD0E9D0C0C23", hash_generated_field = "05A463A291C68559D8A2DA4399EC93B8")

    public static final int NETWORK_TYPE_EVDO_B = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "65B2C3B7993C2021079087462ABF4B64", hash_generated_field = "897972FB0146052AF9FE6A13C387063A")

    public static final int NETWORK_TYPE_LTE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "017ABDECFAA1C908D4E5E8EF5DF39C91", hash_generated_field = "3B80988B27EA0BE6E633061C7CF1BE85")

    public static final int NETWORK_TYPE_EHRPD = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "BD0E2321565D24AC2CD0A61F089767CF", hash_generated_field = "BD0BA401891F25C620F3110BD2DB15BC")

    public static final int NETWORK_TYPE_HSPAP = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "CE5C5B0F4B6E3C6B2AFC7C1B72C483E8", hash_generated_field = "7C7BEF03A11ED6F5B236D02E3AC76BB3")

    public static final int NETWORK_CLASS_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "A87627CC53B5FFC7D1821690AF23B4BD", hash_generated_field = "952EAD66C73882790E8632EBDE3D0EEB")

    public static final int NETWORK_CLASS_2_G = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "FB0F44C286C43C6A6F3E8528A93D82B0", hash_generated_field = "16C334B31519B49DB6ACD1DE6C14E392")

    public static final int NETWORK_CLASS_3_G = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "FDD83C94EEE3D14F9B73E95BF24E3929", hash_generated_field = "0D5564D633DC921137687C883E4D0F99")

    public static final int NETWORK_CLASS_4_G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "4803464CC31FE860623B640A8F9C9181", hash_generated_field = "F1630542E3838A7ADD00A0BE8722AACE")

    public static final int SIM_STATE_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.384 -0400", hash_original_field = "7B251AECF4F4E9032236E44C8AE417BA", hash_generated_field = "FE661F33A2994BC3BF316C87CD05115C")

    public static final int SIM_STATE_ABSENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "FA0C649B35BA21805999CC2832FEB1D2", hash_generated_field = "6C48EE683A7E78D23C00B92717DE5A22")

    public static final int SIM_STATE_PIN_REQUIRED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "997E1F0E8B724D2A61B435253EC3AEBB", hash_generated_field = "ABE24381CD34E62691DD2C4E93ED4A19")

    public static final int SIM_STATE_PUK_REQUIRED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "5FEA14412EFEF16CAF853FEAAD8F7412", hash_generated_field = "6EE0D9233BAFEC27F9B3BFDB79237527")

    public static final int SIM_STATE_NETWORK_LOCKED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "8F7C0EC531C2914B7B63A605E10BF111", hash_generated_field = "52957824F7E9EFEE70E933C4483F3560")

    public static final int SIM_STATE_READY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "3355B07218C1AAEDA389C55F2E4D4903", hash_generated_field = "880051CE2B272E830BA1E1C9C8EDFDAD")

    public static final int CALL_STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "0AB9BD5B9E7529913E150CF5786D7451", hash_generated_field = "EBF7E79274B936572A44F5AC97C350E9")

    public static final int CALL_STATE_RINGING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "DC1251E603711B7D70A8A4DDDF0D3DFA", hash_generated_field = "F1553B4E51E8E01AAC1228FBFF50DED7")

    public static final int CALL_STATE_OFFHOOK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "F512487C19B4E4DF3A0394C80D07E275", hash_generated_field = "6303BB7C9E2B830338C1836586DB6697")

    public static final int DATA_ACTIVITY_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "50E2E026EC9C664DC24FF36D29AD2CE8", hash_generated_field = "AC92BAFF5B1AACED092C2AF469A8CBD3")

    public static final int DATA_ACTIVITY_IN = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "3D515F46C6B9C8715B613648A4C421E3", hash_generated_field = "63CF83921BA898885E2AD57DC2D97303")

    public static final int DATA_ACTIVITY_OUT = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "A8505CE9C7C3D8B2A208A367E9F8017E", hash_generated_field = "E7682DD7C56FD243525F5233E80F53E4")

    public static final int DATA_ACTIVITY_INOUT = DATA_ACTIVITY_IN | DATA_ACTIVITY_OUT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "ED16AA52E2AD8783C5663A67E8494382", hash_generated_field = "0A134B76AF6D9DF50656A5FE58BE98FF")

    public static final int DATA_ACTIVITY_DORMANT = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "39D416CC671EA6C04286C6438AC4DA0F", hash_generated_field = "FF8D51C8FEAAD0B22B077E1A375AC594")

    public static final int DATA_UNKNOWN        = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "EC19C258779D833C3D52C3F786F5890C", hash_generated_field = "C4C0880CDDF6725DBFD4E7B67714DE9B")

    public static final int DATA_DISCONNECTED   = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "48FF8856F44C088A8CE7CFDF5B291B4D", hash_generated_field = "FF9CE223A769E6D3636143EA9AC19C2B")

    public static final int DATA_CONNECTING     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "F415667E2FC38B9FD7C9BEFFCEF8C733", hash_generated_field = "794BB976A412F225595FC4181FE3FC75")

    public static final int DATA_CONNECTED      = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.385 -0400", hash_original_field = "8D70D003B5C75608EE7DA82B0BA5E330", hash_generated_field = "DC6EB947ED9360ECC33AC98BE7B1AAB6")

    public static final int DATA_SUSPENDED      = 3;
}

