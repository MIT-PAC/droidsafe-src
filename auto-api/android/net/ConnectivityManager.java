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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.401 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "91FD67C0243C9CAC51474C01D9540196")

    private IConnectivityManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.402 -0400", hash_original_method = "6A60C197741333EAEC6E0EA679C6387D", hash_generated_method = "9748824EC9A278AAE7881447974F69D5")
    public  ConnectivityManager(IConnectivityManager service) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.417 -0400", hash_original_method = "20C5B9DE2E49D07D506F0D5479D46C57", hash_generated_method = "65CD6590F85C9337A8EAA19D2342435B")
    public void setNetworkPreference(int preference) {
        try 
        {
            mService.setNetworkPreference(preference);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(preference);
        // ---------- Original Method ----------
        //try {
            //mService.setNetworkPreference(preference);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.418 -0400", hash_original_method = "900E5DCCFD12B740A82ADA5294C949B0", hash_generated_method = "6D0AB8051C68630D0DCC004A9B942DF7")
    public int getNetworkPreference() {
        try 
        {
            int varDA1D38E7DB125563E94987FCB57D1292_880983215 = (mService.getNetworkPreference());
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609745765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609745765;
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkPreference();
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.429 -0400", hash_original_method = "5E96294DED8896A900AADA5BAA807536", hash_generated_method = "9F69343FE6EE47F7767213CC47108CBB")
    public NetworkInfo getActiveNetworkInfo() {
        NetworkInfo varB4EAC82CA7396A68D541C85D26508E83_1321974787 = null; //Variable for return #1
        NetworkInfo varB4EAC82CA7396A68D541C85D26508E83_387640923 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1321974787 = mService.getActiveNetworkInfo();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_387640923 = null;
        } //End block
        NetworkInfo varA7E53CE21691AB073D9660D615818899_1080684872; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1080684872 = varB4EAC82CA7396A68D541C85D26508E83_1321974787;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1080684872 = varB4EAC82CA7396A68D541C85D26508E83_387640923;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1080684872.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1080684872;
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.434 -0400", hash_original_method = "EA020BF9EC9A5FD5A107F43E91D20C3E", hash_generated_method = "5B03649A8C9C43EDEC1950B5F4F1D19B")
    public NetworkInfo getActiveNetworkInfoForUid(int uid) {
        NetworkInfo varB4EAC82CA7396A68D541C85D26508E83_1538379626 = null; //Variable for return #1
        NetworkInfo varB4EAC82CA7396A68D541C85D26508E83_1356219079 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1538379626 = mService.getActiveNetworkInfoForUid(uid);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1356219079 = null;
        } //End block
        addTaint(uid);
        NetworkInfo varA7E53CE21691AB073D9660D615818899_436082443; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_436082443 = varB4EAC82CA7396A68D541C85D26508E83_1538379626;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_436082443 = varB4EAC82CA7396A68D541C85D26508E83_1356219079;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_436082443.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_436082443;
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkInfoForUid(uid);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.434 -0400", hash_original_method = "96564B6A49DFD6F7048AD1538B907A96", hash_generated_method = "EBAF63AAFD7716C49FF4C0926A6DBF80")
    public NetworkInfo getNetworkInfo(int networkType) {
        NetworkInfo varB4EAC82CA7396A68D541C85D26508E83_1351245273 = null; //Variable for return #1
        NetworkInfo varB4EAC82CA7396A68D541C85D26508E83_1972009791 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1351245273 = mService.getNetworkInfo(networkType);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1972009791 = null;
        } //End block
        addTaint(networkType);
        NetworkInfo varA7E53CE21691AB073D9660D615818899_802198323; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_802198323 = varB4EAC82CA7396A68D541C85D26508E83_1351245273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_802198323 = varB4EAC82CA7396A68D541C85D26508E83_1972009791;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_802198323.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_802198323;
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkInfo(networkType);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.435 -0400", hash_original_method = "394CF6797F6D312CB8F1ED596C180D8F", hash_generated_method = "4822DFC10B8433BBA541F50C39992D64")
    public NetworkInfo[] getAllNetworkInfo() {
        NetworkInfo[] varB4EAC82CA7396A68D541C85D26508E83_1806381917 = null; //Variable for return #1
        NetworkInfo[] varB4EAC82CA7396A68D541C85D26508E83_1303966692 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1806381917 = mService.getAllNetworkInfo();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1303966692 = null;
        } //End block
        NetworkInfo[] varA7E53CE21691AB073D9660D615818899_95124026; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_95124026 = varB4EAC82CA7396A68D541C85D26508E83_1806381917;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_95124026 = varB4EAC82CA7396A68D541C85D26508E83_1303966692;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_95124026.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_95124026;
        // ---------- Original Method ----------
        //try {
            //return mService.getAllNetworkInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.436 -0400", hash_original_method = "D6D4DA92D9064C06A48DA2C5EB8FF9D2", hash_generated_method = "5F51BEDEF4736D61AF13ABE655BCF312")
    public LinkProperties getActiveLinkProperties() {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1087112842 = null; //Variable for return #1
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1908124777 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1087112842 = mService.getActiveLinkProperties();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1908124777 = null;
        } //End block
        LinkProperties varA7E53CE21691AB073D9660D615818899_405588271; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_405588271 = varB4EAC82CA7396A68D541C85D26508E83_1087112842;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_405588271 = varB4EAC82CA7396A68D541C85D26508E83_1908124777;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_405588271.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_405588271;
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveLinkProperties();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.437 -0400", hash_original_method = "C7AAA0ED9F7BD2D04E30B8A62557C00D", hash_generated_method = "104AD636840133C895740D9FDDDFB53C")
    public LinkProperties getLinkProperties(int networkType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1792137248 = null; //Variable for return #1
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1496560982 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1792137248 = mService.getLinkProperties(networkType);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1496560982 = null;
        } //End block
        addTaint(networkType);
        LinkProperties varA7E53CE21691AB073D9660D615818899_1087672387; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1087672387 = varB4EAC82CA7396A68D541C85D26508E83_1792137248;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1087672387 = varB4EAC82CA7396A68D541C85D26508E83_1496560982;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1087672387.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1087672387;
        // ---------- Original Method ----------
        //try {
            //return mService.getLinkProperties(networkType);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.446 -0400", hash_original_method = "8773F3976862F74C7E8795673CF57A3F", hash_generated_method = "6571E2E1B6DCFA9FAD10BBB08D386F52")
    public boolean setRadios(boolean turnOn) {
        try 
        {
            boolean varEC5731E70BA489403D1161FA321CE762_801865568 = (mService.setRadios(turnOn));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(turnOn);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967054923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967054923;
        // ---------- Original Method ----------
        //try {
            //return mService.setRadios(turnOn);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.447 -0400", hash_original_method = "F4DEFED01E737220B0A84C9B3C165EA1", hash_generated_method = "238E5F086DBB9397132306A37B0BF81D")
    public boolean setRadio(int networkType, boolean turnOn) {
        try 
        {
            boolean var93B5FB08593ED9DC45F0421EB7F2C6BE_359933075 = (mService.setRadio(networkType, turnOn));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(networkType);
        addTaint(turnOn);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562003822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562003822;
        // ---------- Original Method ----------
        //try {
            //return mService.setRadio(networkType, turnOn);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.447 -0400", hash_original_method = "709E7052A14C2A0D29C9219C00073F31", hash_generated_method = "2B21A85A500BEFBCA53E8425ADB10284")
    public int startUsingNetworkFeature(int networkType, String feature) {
        try 
        {
            int var39E3E968BB82C84038568CECB8F010F0_1314539268 = (mService.startUsingNetworkFeature(networkType, feature,
                    new Binder()));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(networkType);
        addTaint(feature.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529757937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529757937;
        // ---------- Original Method ----------
        //try {
            //return mService.startUsingNetworkFeature(networkType, feature,
                    //new Binder());
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.448 -0400", hash_original_method = "60EB71F5D3B7B41111FE02ED36065292", hash_generated_method = "B9FED98347BF55FAD4B2721D9E85E1E6")
    public int stopUsingNetworkFeature(int networkType, String feature) {
        try 
        {
            int var1F50AAD17CF9029F9ABD191CD5412163_1495923477 = (mService.stopUsingNetworkFeature(networkType, feature));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(networkType);
        addTaint(feature.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898548746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898548746;
        // ---------- Original Method ----------
        //try {
            //return mService.stopUsingNetworkFeature(networkType, feature);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.452 -0400", hash_original_method = "C11FA4279C0A187DA118461D9F53788F", hash_generated_method = "CB3D4C4BA92CAF8860A5A9D72088AAFB")
    public boolean requestRouteToHost(int networkType, int hostAddress) {
        InetAddress inetAddress;
        inetAddress = NetworkUtils.intToInetAddress(hostAddress);
        boolean varDAE0526518EE420ACEF3DD7CDC55B247_696468824 = (requestRouteToHostAddress(networkType, inetAddress));
        addTaint(networkType);
        addTaint(hostAddress);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835288718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835288718;
        // ---------- Original Method ----------
        //InetAddress inetAddress = NetworkUtils.intToInetAddress(hostAddress);
        //if (inetAddress == null) {
            //return false;
        //}
        //return requestRouteToHostAddress(networkType, inetAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.453 -0400", hash_original_method = "EFA83347B3FFE38EB6FE081BBE35835E", hash_generated_method = "B6405DE3398AEE48D89A92A919DE5C10")
    public boolean requestRouteToHostAddress(int networkType, InetAddress hostAddress) {
        byte[] address;
        address = hostAddress.getAddress();
        try 
        {
            boolean var658A0FCBDE4C320CB783AD20768859A4_1282654429 = (mService.requestRouteToHostAddress(networkType, address));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(networkType);
        addTaint(hostAddress.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_503881978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_503881978;
        // ---------- Original Method ----------
        //byte[] address = hostAddress.getAddress();
        //try {
            //return mService.requestRouteToHostAddress(networkType, address);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.454 -0400", hash_original_method = "6498894EA2E4C7DBE6A13B3BD05F6504", hash_generated_method = "49F90448DB43023577BEB619190BBD85")
    @Deprecated
    public boolean getBackgroundDataSetting() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202100721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202100721;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.454 -0400", hash_original_method = "C7D66D7319A6F772837F5FAC4582BCF2", hash_generated_method = "DD5713BFAEAD7937DCF087E006B8A5CE")
    @Deprecated
    public void setBackgroundDataSetting(boolean allowBackgroundData) {
        addTaint(allowBackgroundData);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.473 -0400", hash_original_method = "2A17F1CC768C6D56971308D1A367AB75", hash_generated_method = "8B768D12BCB350072A38E92E3962F083")
    public NetworkQuotaInfo getActiveNetworkQuotaInfo() {
        NetworkQuotaInfo varB4EAC82CA7396A68D541C85D26508E83_1387569523 = null; //Variable for return #1
        NetworkQuotaInfo varB4EAC82CA7396A68D541C85D26508E83_1067093171 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1387569523 = mService.getActiveNetworkQuotaInfo();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1067093171 = null;
        } //End block
        NetworkQuotaInfo varA7E53CE21691AB073D9660D615818899_1852083957; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1852083957 = varB4EAC82CA7396A68D541C85D26508E83_1387569523;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1852083957 = varB4EAC82CA7396A68D541C85D26508E83_1067093171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1852083957.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1852083957;
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkQuotaInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.476 -0400", hash_original_method = "4787FEDAB977985506F4394396606391", hash_generated_method = "0A5C3ACE2B804323770D32CB89CE8907")
    public boolean getMobileDataEnabled() {
        try 
        {
            boolean var714A244F14429DE5B56D768589A3543B_1042899512 = (mService.getMobileDataEnabled());
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264845422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_264845422;
        // ---------- Original Method ----------
        //try {
            //return mService.getMobileDataEnabled();
        //} catch (RemoteException e) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.479 -0400", hash_original_method = "03BF638942F758314C38E6E89D590F06", hash_generated_method = "5524DB0CC5B22E8BEC31DE087911A4F0")
    public void setMobileDataEnabled(boolean enabled) {
        try 
        {
            mService.setMobileDataEnabled(enabled);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(enabled);
        // ---------- Original Method ----------
        //try {
            //mService.setMobileDataEnabled(enabled);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.482 -0400", hash_original_method = "65586E40689502E42674D85C93789ED5", hash_generated_method = "5DDA3633BE03E157B1D1A24BD2AE387F")
    public String[] getTetherableIfaces() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_533354984 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_297645080 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_533354984 = mService.getTetherableIfaces();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_297645080 = new String[0];
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_1624578180; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1624578180 = varB4EAC82CA7396A68D541C85D26508E83_533354984;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1624578180 = varB4EAC82CA7396A68D541C85D26508E83_297645080;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1624578180.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1624578180;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.498 -0400", hash_original_method = "1A1AB0AA8E53EB2A72A3BB78A36F79E1", hash_generated_method = "BC8C3006DEBC0B2D2301131B1FAE4CAC")
    public String[] getTetheredIfaces() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1281484493 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1643269303 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1281484493 = mService.getTetheredIfaces();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1643269303 = new String[0];
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_995728807; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_995728807 = varB4EAC82CA7396A68D541C85D26508E83_1281484493;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_995728807 = varB4EAC82CA7396A68D541C85D26508E83_1643269303;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_995728807.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_995728807;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetheredIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.499 -0400", hash_original_method = "B4F0365B2F0B873A76FA3BA63C88578F", hash_generated_method = "FF0AAB06484A7F677F3D03340BA0455D")
    public String[] getTetheringErroredIfaces() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_960810878 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1128346092 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_960810878 = mService.getTetheringErroredIfaces();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1128346092 = new String[0];
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_22322937; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_22322937 = varB4EAC82CA7396A68D541C85D26508E83_960810878;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_22322937 = varB4EAC82CA7396A68D541C85D26508E83_1128346092;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_22322937.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_22322937;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetheringErroredIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.500 -0400", hash_original_method = "88DA982A0D8C00E6CF08BAB9F849E24F", hash_generated_method = "87F754B69D197AE0D327286C613EA5A4")
    public int tether(String iface) {
        try 
        {
            int var03FB9F4C7AD544143B1AE8487E7B7E6A_949883850 = (mService.tether(iface));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754183065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754183065;
        // ---------- Original Method ----------
        //try {
            //return mService.tether(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.500 -0400", hash_original_method = "A16CE7410015543313DA1C15EBE8B863", hash_generated_method = "C84209E55649C30AA932D3ADF5E5E3CC")
    public int untether(String iface) {
        try 
        {
            int varBFA9A01DFAF51932FADB2E68671C2BC1_1686732478 = (mService.untether(iface));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585270180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585270180;
        // ---------- Original Method ----------
        //try {
            //return mService.untether(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.501 -0400", hash_original_method = "457F62D672DCD1BF7CAF2342EBCF7BE3", hash_generated_method = "5584B250F62AB5BF7424191B5561E225")
    public boolean isTetheringSupported() {
        try 
        {
            boolean var6C5950EB3A2190DB9BFABB3C83C14388_346285549 = (mService.isTetheringSupported());
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781126704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781126704;
        // ---------- Original Method ----------
        //try {
            //return mService.isTetheringSupported();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.521 -0400", hash_original_method = "DC0367A904D99268D94A314F1CB55B9B", hash_generated_method = "B6B5FFAF0653680C71EF424EC4E65D8A")
    public String[] getTetherableUsbRegexs() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1067407045 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_305176879 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1067407045 = mService.getTetherableUsbRegexs();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_305176879 = new String[0];
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_200478925; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_200478925 = varB4EAC82CA7396A68D541C85D26508E83_1067407045;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_200478925 = varB4EAC82CA7396A68D541C85D26508E83_305176879;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_200478925.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_200478925;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableUsbRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.523 -0400", hash_original_method = "8DD288EE3D6933895D6454F488DECB73", hash_generated_method = "BF7E8818DA1C54DC185350B087367781")
    public String[] getTetherableWifiRegexs() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_528516972 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_750348733 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_528516972 = mService.getTetherableWifiRegexs();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_750348733 = new String[0];
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_190833567; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_190833567 = varB4EAC82CA7396A68D541C85D26508E83_528516972;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_190833567 = varB4EAC82CA7396A68D541C85D26508E83_750348733;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_190833567.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_190833567;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableWifiRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.570 -0400", hash_original_method = "83E2E43D24B9648666006A701F93D599", hash_generated_method = "50C79502778503E9CE20ED24B0659C2B")
    public String[] getTetherableBluetoothRegexs() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1058318395 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_974545326 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1058318395 = mService.getTetherableBluetoothRegexs();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_974545326 = new String[0];
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_1857784262; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1857784262 = varB4EAC82CA7396A68D541C85D26508E83_1058318395;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1857784262 = varB4EAC82CA7396A68D541C85D26508E83_974545326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1857784262.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1857784262;
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableBluetoothRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.571 -0400", hash_original_method = "952ADB6A2A3AEF46E275F5FA17E284ED", hash_generated_method = "E2B9465DF27561610DF66632E9D8C370")
    public int setUsbTethering(boolean enable) {
        try 
        {
            int var743BE6F957ADCD1D6C1FB098A46C5C90_1397586696 = (mService.setUsbTethering(enable));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(enable);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927753193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927753193;
        // ---------- Original Method ----------
        //try {
            //return mService.setUsbTethering(enable);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.579 -0400", hash_original_method = "A91E88C74DCBFDB505B1B5012FAE30D1", hash_generated_method = "86983CA6AF85FEADDBF23B7B5802C8E2")
    public int getLastTetherError(String iface) {
        try 
        {
            int var262D51C3C390381089B6EEB0B45A0991_2087602536 = (mService.getLastTetherError(iface));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621726380 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621726380;
        // ---------- Original Method ----------
        //try {
            //return mService.getLastTetherError(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.580 -0400", hash_original_method = "400BD091D4CACB3FCA76B3A275DD11D5", hash_generated_method = "6FADB90ECDC371CB554F21A4E66A297E")
    public boolean requestNetworkTransitionWakelock(String forWhom) {
        try 
        {
            mService.requestNetworkTransitionWakelock(forWhom);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(forWhom.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1299540891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1299540891;
        // ---------- Original Method ----------
        //try {
            //mService.requestNetworkTransitionWakelock(forWhom);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.580 -0400", hash_original_method = "37DB5DE823B5870FA290320C99B5BB07", hash_generated_method = "23692885BCAF934FB96A69641817EE84")
    public void reportInetCondition(int networkType, int percentage) {
        try 
        {
            mService.reportInetCondition(networkType, percentage);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(networkType);
        addTaint(percentage);
        // ---------- Original Method ----------
        //try {
            //mService.reportInetCondition(networkType, percentage);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.594 -0400", hash_original_method = "0F41E571577973AB5A169120A0CDA859", hash_generated_method = "BCACB903F0EEABCA1CA1F29A912FDE6D")
    public void setGlobalProxy(ProxyProperties p) {
        try 
        {
            mService.setGlobalProxy(p);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.setGlobalProxy(p);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.596 -0400", hash_original_method = "7F5BD964F39855F539616DAFB8170A5C", hash_generated_method = "EAFB67A8F23E9593020CC918D837EB46")
    public ProxyProperties getGlobalProxy() {
        ProxyProperties varB4EAC82CA7396A68D541C85D26508E83_974640497 = null; //Variable for return #1
        ProxyProperties varB4EAC82CA7396A68D541C85D26508E83_764862088 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_974640497 = mService.getGlobalProxy();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_764862088 = null;
        } //End block
        ProxyProperties varA7E53CE21691AB073D9660D615818899_44399047; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_44399047 = varB4EAC82CA7396A68D541C85D26508E83_974640497;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_44399047 = varB4EAC82CA7396A68D541C85D26508E83_764862088;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_44399047.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_44399047;
        // ---------- Original Method ----------
        //try {
            //return mService.getGlobalProxy();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.601 -0400", hash_original_method = "C61C105C2967FBAB6E5B43A96F13A0DE", hash_generated_method = "93346D8F41884D1D7A2FE0DB72D2BB33")
    public ProxyProperties getProxy() {
        ProxyProperties varB4EAC82CA7396A68D541C85D26508E83_1112928784 = null; //Variable for return #1
        ProxyProperties varB4EAC82CA7396A68D541C85D26508E83_2141519093 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1112928784 = mService.getProxy();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2141519093 = null;
        } //End block
        ProxyProperties varA7E53CE21691AB073D9660D615818899_1846663587; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1846663587 = varB4EAC82CA7396A68D541C85D26508E83_1112928784;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1846663587 = varB4EAC82CA7396A68D541C85D26508E83_2141519093;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1846663587.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1846663587;
        // ---------- Original Method ----------
        //try {
            //return mService.getProxy();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.601 -0400", hash_original_method = "9D2F7B8AE7DD2651562BD08E17F617DF", hash_generated_method = "EA4558048AF716E6C9B9302F537783EF")
    public void setDataDependency(int networkType, boolean met) {
        try 
        {
            mService.setDataDependency(networkType, met);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(networkType);
        addTaint(met);
        // ---------- Original Method ----------
        //try {
            //mService.setDataDependency(networkType, met);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.604 -0400", hash_original_method = "A6B9FE53FCB83D066C3DAD2A2CD2AA6D", hash_generated_method = "682FD9058F9140F58521AB9A86A16446")
    public boolean isNetworkSupported(int networkType) {
        try 
        {
            boolean var1A30801D3631F278BFFEEDA18658A3F5_293290077 = (mService.isNetworkSupported(networkType));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(networkType);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143329362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_143329362;
        // ---------- Original Method ----------
        //try {
            //return mService.isNetworkSupported(networkType);
        //} catch (RemoteException e) {}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.604 -0400", hash_original_field = "E3416443F8154D4F28ABC689636932D3", hash_generated_field = "462E98E49DD1D85193FCE1DB16C7B920")

    private static String TAG = "ConnectivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "E18783678EA8907F4F740E9C103235E1", hash_generated_field = "D74478E2CAA048320F4ED7DCDC0267DE")

    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "58684C387F7472905903FDF03C02746A", hash_generated_field = "0C9BA7409106298885F98D4DB9A7BA61")

    public static final String CONNECTIVITY_ACTION_IMMEDIATE =
            "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "ACAA90A79946019658CF4D2C0E90FC45", hash_generated_field = "5C154E9E8533DCDF3E6DC4E5322ABCE1")

    @Deprecated
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "802EF07B65F2884495D6E969E0C88D66", hash_generated_field = "B68430B9EDED794774E47F6FA9FA85E8")

    public static final String EXTRA_IS_FAILOVER = "isFailover";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "09C2C7F358EEA8EE156BEE6102C6CB70", hash_generated_field = "38491437E03D8F52518B778972D56CD8")

    public static final String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "C03F14926EB919E467AF7936AE818188", hash_generated_field = "BF4C8084C31E77ECEC6D5E1A7C4B100F")

    public static final String EXTRA_NO_CONNECTIVITY = "noConnectivity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "3BA15662B0A0123D9208EFD88ABE81BD", hash_generated_field = "F4AF3469CA1920E05896824A0F13F189")

    public static final String EXTRA_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.605 -0400", hash_original_field = "F55DD0E4BCD20A1D747CDC4B055D22CE", hash_generated_field = "C2A1F543AB7E1673850281E0F6B73AA4")

    public static final String EXTRA_EXTRA_INFO = "extraInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "0E0F8AE6EE9BB45C3785EAE3A50351D4", hash_generated_field = "84A4E2B243A3B918B60966208E2EF600")

    public static final String EXTRA_INET_CONDITION = "inetCondition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "C7FF2C85F01D02DC43889B78A3046DC0", hash_generated_field = "7CC0C8005490856A2BC847B1E0AA4532")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BACKGROUND_DATA_SETTING_CHANGED =
            "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "4D03FACF839E85AAE81E416BFF0B2F03", hash_generated_field = "929E54EDEA98710E57039E6175F5F1AB")

    public static final String INET_CONDITION_ACTION =
            "android.net.conn.INET_CONDITION_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "CF9664535E91B15C6BC45651EDE4FD7C", hash_generated_field = "15608AF081DDD375FA2123C2469F75CE")

    public static final String ACTION_TETHER_STATE_CHANGED =
            "android.net.conn.TETHER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "654793663B4638ED02186244D06103D5", hash_generated_field = "5FD0830638BAEF1B21B12EF8569D3DFD")

    public static final String EXTRA_AVAILABLE_TETHER = "availableArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "A7A0C89549BF96C667EA6B857AECE418", hash_generated_field = "F15A2DC595B40FF3DA55E3CB05B0C76E")

    public static final String EXTRA_ACTIVE_TETHER = "activeArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "41B36775ABA15157AF080E707349CD53", hash_generated_field = "C4FB23C86207DA0754B9BB6EA60CB4E1")

    public static final String EXTRA_ERRORED_TETHER = "erroredArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "BA32C5D767FE9C9B50CE422A729C6F55", hash_generated_field = "93641F6D636E423068CBD0F7A429454B")

    public static final int TYPE_NONE        = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.606 -0400", hash_original_field = "562DD92D67E2C376ECAC9C7FE33E774D", hash_generated_field = "C9C37D3486815251D1CD39C5BE1F3D12")

    public static final int TYPE_MOBILE      = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.607 -0400", hash_original_field = "FAF7153C206F8A855D3926191101974F", hash_generated_field = "AC65BD7D5FC33F670E90ACDF591214B3")

    public static final int TYPE_WIFI        = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.635 -0400", hash_original_field = "A777107098EAD4C966407C3D16CAC458", hash_generated_field = "CFFD550B064A8A8F08DFF2A1CA39B65C")

    public static final int TYPE_MOBILE_MMS  = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.635 -0400", hash_original_field = "F52011C1686E4F3CD9759D6CC94E24DD", hash_generated_field = "9F57AC6327FA6A9B5FA8D268FA065E2F")

    public static final int TYPE_MOBILE_SUPL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.635 -0400", hash_original_field = "8E9B1BBAD76A87F265EEE3509913DA05", hash_generated_field = "E58E8F46709C4195B87AD88D79419D50")

    public static final int TYPE_MOBILE_DUN  = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.635 -0400", hash_original_field = "1C0EDB729ABB9A93A438D5ACA75108C2", hash_generated_field = "0621333417ED999CFE5293A09D2BECCB")

    public static final int TYPE_MOBILE_HIPRI = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.636 -0400", hash_original_field = "AC4DA46AF4A33194000B377B5FBBCBD5", hash_generated_field = "BAA1818BB1192483D8B52B8F786077C0")

    public static final int TYPE_WIMAX       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.636 -0400", hash_original_field = "53D91812C028FF9CD8DDF841FC6A910E", hash_generated_field = "CD355E6AC2221CCE2CCDAE49A283C8ED")

    public static final int TYPE_BLUETOOTH   = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.636 -0400", hash_original_field = "AF2901506BAE70BD83B4050A46E2BD52", hash_generated_field = "ABE0A738884F28B1356F01138B1EB213")

    public static final int TYPE_DUMMY       = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.636 -0400", hash_original_field = "1765D5FB922544A865701915DD1D3747", hash_generated_field = "ACFC541BB1EF72643D27FBCAC2F80E92")

    public static final int TYPE_ETHERNET    = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.636 -0400", hash_original_field = "C1FFA41D0FCE77257B41D4941D7E28C7", hash_generated_field = "C217790CC7405EE35B93FDCCBB7C8140")

    public static final int TYPE_MOBILE_FOTA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.645 -0400", hash_original_field = "7DC8FCC532633F1CC616125CE7A9ED71", hash_generated_field = "6D9B79B5DD49C3171F158817B3061CDF")

    public static final int TYPE_MOBILE_IMS  = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.645 -0400", hash_original_field = "94B34D197D8C9575A21DA4E6ED0973D6", hash_generated_field = "70BC4329B6D7C6986B2212F6DB3B92A0")

    public static final int TYPE_MOBILE_CBS  = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.645 -0400", hash_original_field = "4A26070CDA8366EDBF53AF48F9F8C66E", hash_generated_field = "92581ADB158A1116848D6CC3361396A8")

    public static final int TYPE_WIFI_P2P    = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.645 -0400", hash_original_field = "BBB4907FF99ED01DB65C34C97B36DBAA", hash_generated_field = "EFA11F2732F8BA0E99360E32BB64687E")

    public static final int MAX_RADIO_TYPE   = TYPE_WIFI_P2P;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.645 -0400", hash_original_field = "A4710F917416CD1A4DDBF2CBF9B78242", hash_generated_field = "1E3DEA2E494B778E3E4DC09D24507EBC")

    public static final int MAX_NETWORK_TYPE = TYPE_WIFI_P2P;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "09668E6C6D8A3966598A16113343EDE8", hash_generated_field = "693728286830CEC17980B2770B246B92")

    public static final int DEFAULT_NETWORK_PREFERENCE = TYPE_WIFI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "594EE2342EC63E82194DA3F121F16201", hash_generated_field = "27C649E4F5C0896362843DA1D4CCC9B3")

    public static final int TETHER_ERROR_NO_ERROR           = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "1E235120E5BB78D91FD44C27F6AC18FF", hash_generated_field = "07524C9E5C0A6E14423C5AA3A0BCF933")

    public static final int TETHER_ERROR_UNKNOWN_IFACE      = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "475D56B8E540E5A35CE3894648DE5FA9", hash_generated_field = "6A20D3B74D9781CEFE362C2F0E6C1ACB")

    public static final int TETHER_ERROR_SERVICE_UNAVAIL    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "461FD932F3282955F1EB893D9309096B", hash_generated_field = "6DBA0A44F83AE28B03C80500322E7C88")

    public static final int TETHER_ERROR_UNSUPPORTED        = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "763F5DEE712955BE78209F2BF7BBF491", hash_generated_field = "39FD0B36B98E04AAD8EEAF19046A06B2")

    public static final int TETHER_ERROR_UNAVAIL_IFACE      = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "BF0FC9BD69BB1852E21E9E7CD41679F8", hash_generated_field = "5A077B24861F547F9496BEBC8EFA8136")

    public static final int TETHER_ERROR_MASTER_ERROR       = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "FA48AEE6B0189CFD993EC1DB6FBDF8BD", hash_generated_field = "FFAEC6C250B0EF0B5C941FCD72B78F03")

    public static final int TETHER_ERROR_TETHER_IFACE_ERROR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "4CA9F39A76FFAE657179FC8A52521263", hash_generated_field = "E28AFC063D621B0867BDDEB59FAF30D1")

    public static final int TETHER_ERROR_UNTETHER_IFACE_ERROR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "AC906D4C683762A78E92D36758198069", hash_generated_field = "F6682A4AE0D5B2CE3CDD81FB1BE1FF0F")

    public static final int TETHER_ERROR_ENABLE_NAT_ERROR     = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.646 -0400", hash_original_field = "5BA53DF68BF9F14D6726E5CB2025E104", hash_generated_field = "8F0E5817C52CE45A45E797BAE8358F6C")

    public static final int TETHER_ERROR_DISABLE_NAT_ERROR    = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.647 -0400", hash_original_field = "6E6315DC94CB292B1090EA7B848E3804", hash_generated_field = "6F017CF59453C65348D1F7CD3994589B")

    public static final int TETHER_ERROR_IFACE_CFG_ERROR      = 10;
}

