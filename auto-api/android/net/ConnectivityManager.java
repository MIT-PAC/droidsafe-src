package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static com.android.internal.util.Preconditions.checkNotNull;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.os.Binder;
import android.os.Build.VERSION_CODES;
import android.os.RemoteException;
import android.provider.Settings;
import java.net.InetAddress;

public class ConnectivityManager {
    private IConnectivityManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.459 -0400", hash_original_method = "6A60C197741333EAEC6E0EA679C6387D", hash_generated_method = "CA76CF14270E75CF6544F6D6B27C0026")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConnectivityManager(IConnectivityManager service) {
        dsTaint.addTaint(service.dsTaint);
        mService = checkNotNull(service, "missing IConnectivityManager");
        // ---------- Original Method ----------
        //mService = checkNotNull(service, "missing IConnectivityManager");
    }

    
        public static boolean isNetworkTypeValid(int networkType) {
        return networkType >= 0 && networkType <= MAX_NETWORK_TYPE;
    }

    
        public static String getNetworkTypeName(int type) {
        switch (type) {
            case TYPE_MOBILE:
                return "MOBILE";
            case TYPE_WIFI:
                return "WIFI";
            case TYPE_MOBILE_MMS:
                return "MOBILE_MMS";
            case TYPE_MOBILE_SUPL:
                return "MOBILE_SUPL";
            case TYPE_MOBILE_DUN:
                return "MOBILE_DUN";
            case TYPE_MOBILE_HIPRI:
                return "MOBILE_HIPRI";
            case TYPE_WIMAX:
                return "WIMAX";
            case TYPE_BLUETOOTH:
                return "BLUETOOTH";
            case TYPE_DUMMY:
                return "DUMMY";
            case TYPE_ETHERNET:
                return "ETHERNET";
            case TYPE_MOBILE_FOTA:
                return "MOBILE_FOTA";
            case TYPE_MOBILE_IMS:
                return "MOBILE_IMS";
            case TYPE_MOBILE_CBS:
                return "MOBILE_CBS";
            case TYPE_WIFI_P2P:
                return "WIFI_P2P";
            default:
                return Integer.toString(type);
        }
    }

    
        public static boolean isNetworkTypeMobile(int networkType) {
        switch (networkType) {
            case TYPE_MOBILE:
            case TYPE_MOBILE_MMS:
            case TYPE_MOBILE_SUPL:
            case TYPE_MOBILE_DUN:
            case TYPE_MOBILE_HIPRI:
            case TYPE_MOBILE_FOTA:
            case TYPE_MOBILE_IMS:
            case TYPE_MOBILE_CBS:
                return true;
            default:
                return false;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.461 -0400", hash_original_method = "20C5B9DE2E49D07D506F0D5479D46C57", hash_generated_method = "554BEC639D98DE189AE85F74622BF89C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkPreference(int preference) {
        dsTaint.addTaint(preference);
        try 
        {
            mService.setNetworkPreference(preference);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setNetworkPreference(preference);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.462 -0400", hash_original_method = "900E5DCCFD12B740A82ADA5294C949B0", hash_generated_method = "762D9257989E1CC8ADD4BD2D02BEFBE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNetworkPreference() {
        try 
        {
            int varDA1D38E7DB125563E94987FCB57D1292_1165358979 = (mService.getNetworkPreference());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkPreference();
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.463 -0400", hash_original_method = "5E96294DED8896A900AADA5BAA807536", hash_generated_method = "891903DF700053C61D1EBC409E25E629")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkInfo getActiveNetworkInfo() {
        try 
        {
            NetworkInfo var9A0E3510AE74458C6D69DA70445E64DE_467850611 = (mService.getActiveNetworkInfo());
        } //End block
        catch (RemoteException e)
        { }
        return (NetworkInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.464 -0400", hash_original_method = "EA020BF9EC9A5FD5A107F43E91D20C3E", hash_generated_method = "3B39C7349091DF8ACEBBB156D426F731")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkInfo getActiveNetworkInfoForUid(int uid) {
        dsTaint.addTaint(uid);
        try 
        {
            NetworkInfo var0FB446ECC23CD883983F3A2E20AAC567_1878362611 = (mService.getActiveNetworkInfoForUid(uid));
        } //End block
        catch (RemoteException e)
        { }
        return (NetworkInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkInfoForUid(uid);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.464 -0400", hash_original_method = "96564B6A49DFD6F7048AD1538B907A96", hash_generated_method = "559AD027F945CBBB58A7138E37A6D4DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkInfo getNetworkInfo(int networkType) {
        dsTaint.addTaint(networkType);
        try 
        {
            NetworkInfo var4C96E0C479FE9F4FE42811540D0E7EDE_1375036504 = (mService.getNetworkInfo(networkType));
        } //End block
        catch (RemoteException e)
        { }
        return (NetworkInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkInfo(networkType);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.464 -0400", hash_original_method = "394CF6797F6D312CB8F1ED596C180D8F", hash_generated_method = "C6E1F01625865EC1822A03820E88A3E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkInfo[] getAllNetworkInfo() {
        try 
        {
            NetworkInfo[] varFBE9ADBB0B5B92BAE6E5EC0B20EF2E1D_273203203 = (mService.getAllNetworkInfo());
        } //End block
        catch (RemoteException e)
        { }
        return (NetworkInfo[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getAllNetworkInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.464 -0400", hash_original_method = "D6D4DA92D9064C06A48DA2C5EB8FF9D2", hash_generated_method = "D17864AC013D0E0BDFA2E4AE3C697132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties getActiveLinkProperties() {
        try 
        {
            LinkProperties var3D47D7807472A58780842F6B735A214E_1477621593 = (mService.getActiveLinkProperties());
        } //End block
        catch (RemoteException e)
        { }
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveLinkProperties();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.465 -0400", hash_original_method = "C7AAA0ED9F7BD2D04E30B8A62557C00D", hash_generated_method = "FD81F3F0D10FAD815606BB92D85B9258")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties getLinkProperties(int networkType) {
        dsTaint.addTaint(networkType);
        try 
        {
            LinkProperties varD17FA52ED87BC30035CE10E3AEC8B924_168331374 = (mService.getLinkProperties(networkType));
        } //End block
        catch (RemoteException e)
        { }
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getLinkProperties(networkType);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.465 -0400", hash_original_method = "8773F3976862F74C7E8795673CF57A3F", hash_generated_method = "9196150B472C77C50AE37747A23E64F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setRadios(boolean turnOn) {
        dsTaint.addTaint(turnOn);
        try 
        {
            boolean varEC5731E70BA489403D1161FA321CE762_807592356 = (mService.setRadios(turnOn));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.setRadios(turnOn);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.465 -0400", hash_original_method = "F4DEFED01E737220B0A84C9B3C165EA1", hash_generated_method = "65203A3E648454984C1FDF913A62ECBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setRadio(int networkType, boolean turnOn) {
        dsTaint.addTaint(networkType);
        dsTaint.addTaint(turnOn);
        try 
        {
            boolean var93B5FB08593ED9DC45F0421EB7F2C6BE_944918852 = (mService.setRadio(networkType, turnOn));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.setRadio(networkType, turnOn);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.466 -0400", hash_original_method = "709E7052A14C2A0D29C9219C00073F31", hash_generated_method = "8E69F6FFA6CC2826E739C93EECDEE465")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int startUsingNetworkFeature(int networkType, String feature) {
        dsTaint.addTaint(networkType);
        dsTaint.addTaint(feature);
        try 
        {
            int var39E3E968BB82C84038568CECB8F010F0_1084732547 = (mService.startUsingNetworkFeature(networkType, feature,
                    new Binder()));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.startUsingNetworkFeature(networkType, feature,
                    //new Binder());
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.466 -0400", hash_original_method = "60EB71F5D3B7B41111FE02ED36065292", hash_generated_method = "CE73368DA021846C54C37DC8572AA9D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int stopUsingNetworkFeature(int networkType, String feature) {
        dsTaint.addTaint(networkType);
        dsTaint.addTaint(feature);
        try 
        {
            int var1F50AAD17CF9029F9ABD191CD5412163_1779924127 = (mService.stopUsingNetworkFeature(networkType, feature));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.stopUsingNetworkFeature(networkType, feature);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.466 -0400", hash_original_method = "C11FA4279C0A187DA118461D9F53788F", hash_generated_method = "69554B77039910C39480377E567C964E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestRouteToHost(int networkType, int hostAddress) {
        dsTaint.addTaint(networkType);
        dsTaint.addTaint(hostAddress);
        InetAddress inetAddress;
        inetAddress = NetworkUtils.intToInetAddress(hostAddress);
        boolean varDAE0526518EE420ACEF3DD7CDC55B247_743641734 = (requestRouteToHostAddress(networkType, inetAddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //InetAddress inetAddress = NetworkUtils.intToInetAddress(hostAddress);
        //if (inetAddress == null) {
            //return false;
        //}
        //return requestRouteToHostAddress(networkType, inetAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.467 -0400", hash_original_method = "EFA83347B3FFE38EB6FE081BBE35835E", hash_generated_method = "C91AC85D068BC287769AE7E78CA57689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestRouteToHostAddress(int networkType, InetAddress hostAddress) {
        dsTaint.addTaint(networkType);
        dsTaint.addTaint(hostAddress.dsTaint);
        byte[] address;
        address = hostAddress.getAddress();
        try 
        {
            boolean var658A0FCBDE4C320CB783AD20768859A4_383445978 = (mService.requestRouteToHostAddress(networkType, address));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //byte[] address = hostAddress.getAddress();
        //try {
            //return mService.requestRouteToHostAddress(networkType, address);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.467 -0400", hash_original_method = "6498894EA2E4C7DBE6A13B3BD05F6504", hash_generated_method = "A00680BF75684D22B9D98870AC249E37")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean getBackgroundDataSetting() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.467 -0400", hash_original_method = "C7D66D7319A6F772837F5FAC4582BCF2", hash_generated_method = "A72326AEB59C4DCD37F6CC683AF3AFD6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setBackgroundDataSetting(boolean allowBackgroundData) {
        dsTaint.addTaint(allowBackgroundData);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.467 -0400", hash_original_method = "2A17F1CC768C6D56971308D1A367AB75", hash_generated_method = "A1A5D2589CA69524F0B5910160058D84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkQuotaInfo getActiveNetworkQuotaInfo() {
        try 
        {
            NetworkQuotaInfo var3F291341A273EFB1C1FE9E59E9BE3F14_1225542156 = (mService.getActiveNetworkQuotaInfo());
        } //End block
        catch (RemoteException e)
        { }
        return (NetworkQuotaInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkQuotaInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.489 -0400", hash_original_method = "4787FEDAB977985506F4394396606391", hash_generated_method = "AE17572C16B92A8333E3DD81396C4588")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMobileDataEnabled() {
        try 
        {
            boolean var714A244F14429DE5B56D768589A3543B_597119599 = (mService.getMobileDataEnabled());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.getMobileDataEnabled();
        //} catch (RemoteException e) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.498 -0400", hash_original_method = "03BF638942F758314C38E6E89D590F06", hash_generated_method = "1995FF05D7039F85BB9541A034BAD90E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMobileDataEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        try 
        {
            mService.setMobileDataEnabled(enabled);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setMobileDataEnabled(enabled);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.498 -0400", hash_original_method = "65586E40689502E42674D85C93789ED5", hash_generated_method = "4922BB00C33444741EE7D716A56C4AB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getTetherableIfaces() {
        try 
        {
            String[] varD26CB940C88E7DD93702EBB33F5F83C3_1411269826 = (mService.getTetherableIfaces());
        } //End block
        catch (RemoteException e)
        {
            String[] varD024AF3EB720E5F76AF9BFDF855FE192_440331120 = (new String[0]);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.499 -0400", hash_original_method = "1A1AB0AA8E53EB2A72A3BB78A36F79E1", hash_generated_method = "4FDFB27DA9F0C3F9A1B1210D058F530D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getTetheredIfaces() {
        try 
        {
            String[] var66FDD0EE35B84CFB23746DE155958884_1011562552 = (mService.getTetheredIfaces());
        } //End block
        catch (RemoteException e)
        {
            String[] varD024AF3EB720E5F76AF9BFDF855FE192_165484199 = (new String[0]);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetheredIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.499 -0400", hash_original_method = "B4F0365B2F0B873A76FA3BA63C88578F", hash_generated_method = "815AE235633FAECE9D431F617E697358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getTetheringErroredIfaces() {
        try 
        {
            String[] varA7E03C9D2A431E4250334777E87FE31F_278894985 = (mService.getTetheringErroredIfaces());
        } //End block
        catch (RemoteException e)
        {
            String[] varD024AF3EB720E5F76AF9BFDF855FE192_1068676031 = (new String[0]);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetheringErroredIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.499 -0400", hash_original_method = "88DA982A0D8C00E6CF08BAB9F849E24F", hash_generated_method = "611A0F8173666635E702E3372F635497")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int tether(String iface) {
        dsTaint.addTaint(iface);
        try 
        {
            int var03FB9F4C7AD544143B1AE8487E7B7E6A_689858470 = (mService.tether(iface));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.tether(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.499 -0400", hash_original_method = "A16CE7410015543313DA1C15EBE8B863", hash_generated_method = "6F43F545F689BDE6FA4D03AE63D7FF30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int untether(String iface) {
        dsTaint.addTaint(iface);
        try 
        {
            int varBFA9A01DFAF51932FADB2E68671C2BC1_2005456054 = (mService.untether(iface));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.untether(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.500 -0400", hash_original_method = "457F62D672DCD1BF7CAF2342EBCF7BE3", hash_generated_method = "58C0982289E1139799A22FAFBDE1DA0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTetheringSupported() {
        try 
        {
            boolean var6C5950EB3A2190DB9BFABB3C83C14388_73812746 = (mService.isTetheringSupported());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.isTetheringSupported();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.509 -0400", hash_original_method = "DC0367A904D99268D94A314F1CB55B9B", hash_generated_method = "F3FF7CE2FD232538D59DA2EAB9DF6265")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getTetherableUsbRegexs() {
        try 
        {
            String[] varEAAED7B6701F4D0858E0BFC27F2C18D6_374512448 = (mService.getTetherableUsbRegexs());
        } //End block
        catch (RemoteException e)
        {
            String[] varD024AF3EB720E5F76AF9BFDF855FE192_938555360 = (new String[0]);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableUsbRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.510 -0400", hash_original_method = "8DD288EE3D6933895D6454F488DECB73", hash_generated_method = "31F0CDB525F8D318DA2BFE6E6B1ED793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getTetherableWifiRegexs() {
        try 
        {
            String[] varD1C9DF0549872EE2CA612851AC0A0A9D_2141046435 = (mService.getTetherableWifiRegexs());
        } //End block
        catch (RemoteException e)
        {
            String[] varD024AF3EB720E5F76AF9BFDF855FE192_1191843975 = (new String[0]);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableWifiRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.512 -0400", hash_original_method = "83E2E43D24B9648666006A701F93D599", hash_generated_method = "C2A7A00621D5368F6710E19AB46DAD3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getTetherableBluetoothRegexs() {
        try 
        {
            String[] varBB20EC86A1898A04244BA1AF2A374E09_931570832 = (mService.getTetherableBluetoothRegexs());
        } //End block
        catch (RemoteException e)
        {
            String[] varD024AF3EB720E5F76AF9BFDF855FE192_1907013552 = (new String[0]);
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableBluetoothRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.513 -0400", hash_original_method = "952ADB6A2A3AEF46E275F5FA17E284ED", hash_generated_method = "F460FD6DC617FAB332AD3983FAD68791")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int setUsbTethering(boolean enable) {
        dsTaint.addTaint(enable);
        try 
        {
            int var743BE6F957ADCD1D6C1FB098A46C5C90_2071150000 = (mService.setUsbTethering(enable));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.setUsbTethering(enable);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.514 -0400", hash_original_method = "A91E88C74DCBFDB505B1B5012FAE30D1", hash_generated_method = "A5CA57F705E99A6C55233EF3E63B18E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLastTetherError(String iface) {
        dsTaint.addTaint(iface);
        try 
        {
            int var262D51C3C390381089B6EEB0B45A0991_2134536227 = (mService.getLastTetherError(iface));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getLastTetherError(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.514 -0400", hash_original_method = "400BD091D4CACB3FCA76B3A275DD11D5", hash_generated_method = "CD202495B0432C6A1232F6C73E616339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean requestNetworkTransitionWakelock(String forWhom) {
        dsTaint.addTaint(forWhom);
        try 
        {
            mService.requestNetworkTransitionWakelock(forWhom);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mService.requestNetworkTransitionWakelock(forWhom);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.514 -0400", hash_original_method = "37DB5DE823B5870FA290320C99B5BB07", hash_generated_method = "339F52CADC5CDB48151399A58D2505F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reportInetCondition(int networkType, int percentage) {
        dsTaint.addTaint(networkType);
        dsTaint.addTaint(percentage);
        try 
        {
            mService.reportInetCondition(networkType, percentage);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.reportInetCondition(networkType, percentage);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.514 -0400", hash_original_method = "0F41E571577973AB5A169120A0CDA859", hash_generated_method = "B185D930687B6F9ACD4CD098FDF1C7C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGlobalProxy(ProxyProperties p) {
        dsTaint.addTaint(p.dsTaint);
        try 
        {
            mService.setGlobalProxy(p);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setGlobalProxy(p);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.515 -0400", hash_original_method = "7F5BD964F39855F539616DAFB8170A5C", hash_generated_method = "25896C617EFA1CE516B2B4733A05BA7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyProperties getGlobalProxy() {
        try 
        {
            ProxyProperties var948252F7AC2D496355EB149B7B62EB20_1886782559 = (mService.getGlobalProxy());
        } //End block
        catch (RemoteException e)
        { }
        return (ProxyProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getGlobalProxy();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.515 -0400", hash_original_method = "C61C105C2967FBAB6E5B43A96F13A0DE", hash_generated_method = "F4B4EE745FCCD3B369A8B59134B59569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyProperties getProxy() {
        try 
        {
            ProxyProperties var8CE5C2DF98A37DC558C87009A2CB217E_1892511507 = (mService.getProxy());
        } //End block
        catch (RemoteException e)
        { }
        return (ProxyProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getProxy();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.515 -0400", hash_original_method = "9D2F7B8AE7DD2651562BD08E17F617DF", hash_generated_method = "8B1C12E5BCD1554BA418C74C900DBAAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataDependency(int networkType, boolean met) {
        dsTaint.addTaint(met);
        dsTaint.addTaint(networkType);
        try 
        {
            mService.setDataDependency(networkType, met);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setDataDependency(networkType, met);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.516 -0400", hash_original_method = "A6B9FE53FCB83D066C3DAD2A2CD2AA6D", hash_generated_method = "DA9956E9488047984A3C85D2C4015347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNetworkSupported(int networkType) {
        dsTaint.addTaint(networkType);
        try 
        {
            boolean var1A30801D3631F278BFFEEDA18658A3F5_201056589 = (mService.isNetworkSupported(networkType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return mService.isNetworkSupported(networkType);
        //} catch (RemoteException e) {}
        //return false;
    }

    
    private static final String TAG = "ConnectivityManager";
    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String CONNECTIVITY_ACTION_IMMEDIATE =
            "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";
    @Deprecated public static final String EXTRA_NETWORK_INFO = "networkInfo";
    public static final String EXTRA_IS_FAILOVER = "isFailover";
    public static final String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";
    public static final String EXTRA_NO_CONNECTIVITY = "noConnectivity";
    public static final String EXTRA_REASON = "reason";
    public static final String EXTRA_EXTRA_INFO = "extraInfo";
    public static final String EXTRA_INET_CONDITION = "inetCondition";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_BACKGROUND_DATA_SETTING_CHANGED =
            "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";
    public static final String INET_CONDITION_ACTION =
            "android.net.conn.INET_CONDITION_ACTION";
    public static final String ACTION_TETHER_STATE_CHANGED =
            "android.net.conn.TETHER_STATE_CHANGED";
    public static final String EXTRA_AVAILABLE_TETHER = "availableArray";
    public static final String EXTRA_ACTIVE_TETHER = "activeArray";
    public static final String EXTRA_ERRORED_TETHER = "erroredArray";
    public static final int TYPE_NONE        = -1;
    public static final int TYPE_MOBILE      = 0;
    public static final int TYPE_WIFI        = 1;
    public static final int TYPE_MOBILE_MMS  = 2;
    public static final int TYPE_MOBILE_SUPL = 3;
    public static final int TYPE_MOBILE_DUN  = 4;
    public static final int TYPE_MOBILE_HIPRI = 5;
    public static final int TYPE_WIMAX       = 6;
    public static final int TYPE_BLUETOOTH   = 7;
    public static final int TYPE_DUMMY       = 8;
    public static final int TYPE_ETHERNET    = 9;
    public static final int TYPE_MOBILE_FOTA = 10;
    public static final int TYPE_MOBILE_IMS  = 11;
    public static final int TYPE_MOBILE_CBS  = 12;
    public static final int TYPE_WIFI_P2P    = 13;
    public static final int MAX_RADIO_TYPE   = TYPE_WIFI_P2P;
    public static final int MAX_NETWORK_TYPE = TYPE_WIFI_P2P;
    public static final int DEFAULT_NETWORK_PREFERENCE = TYPE_WIFI;
    public static final int TETHER_ERROR_NO_ERROR           = 0;
    public static final int TETHER_ERROR_UNKNOWN_IFACE      = 1;
    public static final int TETHER_ERROR_SERVICE_UNAVAIL    = 2;
    public static final int TETHER_ERROR_UNSUPPORTED        = 3;
    public static final int TETHER_ERROR_UNAVAIL_IFACE      = 4;
    public static final int TETHER_ERROR_MASTER_ERROR       = 5;
    public static final int TETHER_ERROR_TETHER_IFACE_ERROR = 6;
    public static final int TETHER_ERROR_UNTETHER_IFACE_ERROR = 7;
    public static final int TETHER_ERROR_ENABLE_NAT_ERROR     = 8;
    public static final int TETHER_ERROR_DISABLE_NAT_ERROR    = 9;
    public static final int TETHER_ERROR_IFACE_CFG_ERROR      = 10;
}

