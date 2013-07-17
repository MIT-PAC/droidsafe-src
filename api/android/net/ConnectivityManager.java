package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import static com.android.internal.util.Preconditions.checkNotNull;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.os.Binder;
import android.os.Build.VERSION_CODES;
import android.os.RemoteException;
import android.provider.Settings;
import java.net.InetAddress;

public class ConnectivityManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.384 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "91FD67C0243C9CAC51474C01D9540196")

    private IConnectivityManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.385 -0400", hash_original_method = "6A60C197741333EAEC6E0EA679C6387D", hash_generated_method = "9748824EC9A278AAE7881447974F69D5")
    public  ConnectivityManager(IConnectivityManager service) {
        mService = checkNotNull(service, "missing IConnectivityManager");
        // ---------- Original Method ----------
        //mService = checkNotNull(service, "missing IConnectivityManager");
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.388 -0400", hash_original_method = "20C5B9DE2E49D07D506F0D5479D46C57", hash_generated_method = "548A77776A813E5CF616D63EA1C17827")
    public void setNetworkPreference(int preference) {
        addTaint(preference);
        try 
        {
            mService.setNetworkPreference(preference);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setNetworkPreference(preference);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.389 -0400", hash_original_method = "900E5DCCFD12B740A82ADA5294C949B0", hash_generated_method = "34D458E07777009B9523985920E9D457")
    public int getNetworkPreference() {
        try 
        {
            int var19A3790390823FE4079A20780D0EE00C_1364815639 = (mService.getNetworkPreference());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656377496 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656377496;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1031340129 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815797052 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815797052;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkPreference();
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.390 -0400", hash_original_method = "5E96294DED8896A900AADA5BAA807536", hash_generated_method = "F2F1F90AD3F47479F493BA2B5341DFF2")
    public NetworkInfo getActiveNetworkInfo() {
        try 
        {
NetworkInfo var71037231270A581C4BC2348D12DBB752_52481736 =             mService.getActiveNetworkInfo();
            var71037231270A581C4BC2348D12DBB752_52481736.addTaint(taint);
            return var71037231270A581C4BC2348D12DBB752_52481736;
        } //End block
        catch (RemoteException e)
        {
NetworkInfo var540C13E9E156B687226421B24F2DF178_895888217 =             null;
            var540C13E9E156B687226421B24F2DF178_895888217.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_895888217;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.391 -0400", hash_original_method = "EA020BF9EC9A5FD5A107F43E91D20C3E", hash_generated_method = "EC2809AA83A2EA59602F064C66F75A55")
    public NetworkInfo getActiveNetworkInfoForUid(int uid) {
        addTaint(uid);
        try 
        {
NetworkInfo var716369D49A4FE5B98EE868B69EA92A1E_306266038 =             mService.getActiveNetworkInfoForUid(uid);
            var716369D49A4FE5B98EE868B69EA92A1E_306266038.addTaint(taint);
            return var716369D49A4FE5B98EE868B69EA92A1E_306266038;
        } //End block
        catch (RemoteException e)
        {
NetworkInfo var540C13E9E156B687226421B24F2DF178_53972309 =             null;
            var540C13E9E156B687226421B24F2DF178_53972309.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_53972309;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkInfoForUid(uid);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.391 -0400", hash_original_method = "96564B6A49DFD6F7048AD1538B907A96", hash_generated_method = "FDEBCF224075DABB10B6B6C56BF5B7D8")
    public NetworkInfo getNetworkInfo(int networkType) {
        addTaint(networkType);
        try 
        {
NetworkInfo var3FB1D95655254021728BF247DB3F0249_290413639 =             mService.getNetworkInfo(networkType);
            var3FB1D95655254021728BF247DB3F0249_290413639.addTaint(taint);
            return var3FB1D95655254021728BF247DB3F0249_290413639;
        } //End block
        catch (RemoteException e)
        {
NetworkInfo var540C13E9E156B687226421B24F2DF178_579467055 =             null;
            var540C13E9E156B687226421B24F2DF178_579467055.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_579467055;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkInfo(networkType);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.393 -0400", hash_original_method = "394CF6797F6D312CB8F1ED596C180D8F", hash_generated_method = "A102EB852764CBF13B66E2E21E2AB9EC")
    public NetworkInfo[] getAllNetworkInfo() {
        try 
        {
NetworkInfo[] var70CFDC0136921D96C056C2A1EB42D810_1054485247 =             mService.getAllNetworkInfo();
            var70CFDC0136921D96C056C2A1EB42D810_1054485247.addTaint(taint);
            return var70CFDC0136921D96C056C2A1EB42D810_1054485247;
        } //End block
        catch (RemoteException e)
        {
NetworkInfo[] var540C13E9E156B687226421B24F2DF178_354435853 =             null;
            var540C13E9E156B687226421B24F2DF178_354435853.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_354435853;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getAllNetworkInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.394 -0400", hash_original_method = "D6D4DA92D9064C06A48DA2C5EB8FF9D2", hash_generated_method = "2C33A607607498B54F4C51CD23BF7103")
    public LinkProperties getActiveLinkProperties() {
        try 
        {
LinkProperties varBA28DAB2FB296D0CC5A82CF84CEA5F30_242558046 =             mService.getActiveLinkProperties();
            varBA28DAB2FB296D0CC5A82CF84CEA5F30_242558046.addTaint(taint);
            return varBA28DAB2FB296D0CC5A82CF84CEA5F30_242558046;
        } //End block
        catch (RemoteException e)
        {
LinkProperties var540C13E9E156B687226421B24F2DF178_2138275556 =             null;
            var540C13E9E156B687226421B24F2DF178_2138275556.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2138275556;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveLinkProperties();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.394 -0400", hash_original_method = "C7AAA0ED9F7BD2D04E30B8A62557C00D", hash_generated_method = "F82FD5C57891D5E034A2B192FC627B2D")
    public LinkProperties getLinkProperties(int networkType) {
        addTaint(networkType);
        try 
        {
LinkProperties varCB694E0F083E3A04EA3638584A69852B_1097828791 =             mService.getLinkProperties(networkType);
            varCB694E0F083E3A04EA3638584A69852B_1097828791.addTaint(taint);
            return varCB694E0F083E3A04EA3638584A69852B_1097828791;
        } //End block
        catch (RemoteException e)
        {
LinkProperties var540C13E9E156B687226421B24F2DF178_1478821864 =             null;
            var540C13E9E156B687226421B24F2DF178_1478821864.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1478821864;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getLinkProperties(networkType);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.395 -0400", hash_original_method = "8773F3976862F74C7E8795673CF57A3F", hash_generated_method = "FC7CFEB3FA498D6BCF1EB22379744117")
    public boolean setRadios(boolean turnOn) {
        addTaint(turnOn);
        try 
        {
            boolean varD09A4D6511E647D79E7FB3BE2F8B26E6_1627574537 = (mService.setRadios(turnOn));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176805310 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_176805310;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1505452462 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536845516 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_536845516;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.setRadios(turnOn);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.395 -0400", hash_original_method = "F4DEFED01E737220B0A84C9B3C165EA1", hash_generated_method = "F177FCC84E0D796098C6758FB2EAB9DE")
    public boolean setRadio(int networkType, boolean turnOn) {
        addTaint(turnOn);
        addTaint(networkType);
        try 
        {
            boolean var32495EF67E52304E6220286C24BA7911_1036532745 = (mService.setRadio(networkType, turnOn));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1092798764 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1092798764;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1616188536 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827727878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827727878;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.setRadio(networkType, turnOn);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.396 -0400", hash_original_method = "709E7052A14C2A0D29C9219C00073F31", hash_generated_method = "427148BDEB1F005FF20C10B72357177B")
    public int startUsingNetworkFeature(int networkType, String feature) {
        addTaint(feature.getTaint());
        addTaint(networkType);
        try 
        {
            int varBC6446D5F9F3C6B3BA6886925D6C1D19_949406808 = (mService.startUsingNetworkFeature(networkType, feature,
                    new Binder()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729520896 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729520896;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1225891136 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219572224 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219572224;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.startUsingNetworkFeature(networkType, feature,
                    //new Binder());
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.397 -0400", hash_original_method = "60EB71F5D3B7B41111FE02ED36065292", hash_generated_method = "C1D7DC76AB16B2D5E1F4C61838445E7D")
    public int stopUsingNetworkFeature(int networkType, String feature) {
        addTaint(feature.getTaint());
        addTaint(networkType);
        try 
        {
            int var908FAFA2FE48FDE6EA53EBB333658A21_848845065 = (mService.stopUsingNetworkFeature(networkType, feature));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867727309 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867727309;
        } //End block
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1527423425 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427880167 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427880167;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.stopUsingNetworkFeature(networkType, feature);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.398 -0400", hash_original_method = "C11FA4279C0A187DA118461D9F53788F", hash_generated_method = "364A6C8610AAC9FC36B7B92256E65860")
    public boolean requestRouteToHost(int networkType, int hostAddress) {
        addTaint(hostAddress);
        addTaint(networkType);
        InetAddress inetAddress = NetworkUtils.intToInetAddress(hostAddress);
        if(inetAddress == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1325265012 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721620468 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_721620468;
        } //End block
        boolean varC1317118DA63ED4EE5A4EA03701A9C38_261255764 = (requestRouteToHostAddress(networkType, inetAddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013912718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013912718;
        // ---------- Original Method ----------
        //InetAddress inetAddress = NetworkUtils.intToInetAddress(hostAddress);
        //if (inetAddress == null) {
            //return false;
        //}
        //return requestRouteToHostAddress(networkType, inetAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.398 -0400", hash_original_method = "EFA83347B3FFE38EB6FE081BBE35835E", hash_generated_method = "04A9A022B601A179BE252BC3553442CB")
    public boolean requestRouteToHostAddress(int networkType, InetAddress hostAddress) {
        addTaint(hostAddress.getTaint());
        addTaint(networkType);
        byte[] address = hostAddress.getAddress();
        try 
        {
            boolean var0AFF5DF071EDC728B4E87E4CC9407A65_312914883 = (mService.requestRouteToHostAddress(networkType, address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698927067 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698927067;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_575940908 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899341678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_899341678;
        } //End block
        // ---------- Original Method ----------
        //byte[] address = hostAddress.getAddress();
        //try {
            //return mService.requestRouteToHostAddress(networkType, address);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.399 -0400", hash_original_method = "6498894EA2E4C7DBE6A13B3BD05F6504", hash_generated_method = "332B7F08650586E57084439279237694")
    @Deprecated
    public boolean getBackgroundDataSetting() {
        boolean varB326B5062B2F0E69046810717534CB09_1936804699 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819906467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819906467;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.399 -0400", hash_original_method = "C7D66D7319A6F772837F5FAC4582BCF2", hash_generated_method = "DD5713BFAEAD7937DCF087E006B8A5CE")
    @Deprecated
    public void setBackgroundDataSetting(boolean allowBackgroundData) {
        addTaint(allowBackgroundData);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.399 -0400", hash_original_method = "2A17F1CC768C6D56971308D1A367AB75", hash_generated_method = "1C94882A3F4CAA44ED0E0BA0BC774B91")
    public NetworkQuotaInfo getActiveNetworkQuotaInfo() {
        try 
        {
NetworkQuotaInfo var2C6D2C827838090203CD1E15C5DF8B8F_1167975957 =             mService.getActiveNetworkQuotaInfo();
            var2C6D2C827838090203CD1E15C5DF8B8F_1167975957.addTaint(taint);
            return var2C6D2C827838090203CD1E15C5DF8B8F_1167975957;
        } //End block
        catch (RemoteException e)
        {
NetworkQuotaInfo var540C13E9E156B687226421B24F2DF178_76733763 =             null;
            var540C13E9E156B687226421B24F2DF178_76733763.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_76733763;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getActiveNetworkQuotaInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.400 -0400", hash_original_method = "4787FEDAB977985506F4394396606391", hash_generated_method = "EA1141DA6DC0C57E2326BE1B4F0D4B57")
    public boolean getMobileDataEnabled() {
        try 
        {
            boolean varB458843D81D2B3075744C73F266D7A2C_1095678691 = (mService.getMobileDataEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1953704912 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1953704912;
        } //End block
        catch (RemoteException e)
        {
            boolean varB326B5062B2F0E69046810717534CB09_136810823 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067777105 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067777105;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getMobileDataEnabled();
        //} catch (RemoteException e) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.401 -0400", hash_original_method = "03BF638942F758314C38E6E89D590F06", hash_generated_method = "8C7040F05C00E42F43910B521E4E4743")
    public void setMobileDataEnabled(boolean enabled) {
        addTaint(enabled);
        try 
        {
            mService.setMobileDataEnabled(enabled);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setMobileDataEnabled(enabled);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.402 -0400", hash_original_method = "65586E40689502E42674D85C93789ED5", hash_generated_method = "FD519C2A85FD44ECC6CBB5D6549F655D")
    public String[] getTetherableIfaces() {
        try 
        {
String[] var74024E2BFB98559A6111021EA7992D3F_1383700964 =             mService.getTetherableIfaces();
            var74024E2BFB98559A6111021EA7992D3F_1383700964.addTaint(taint);
            return var74024E2BFB98559A6111021EA7992D3F_1383700964;
        } //End block
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1857727811 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1857727811.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1857727811;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.403 -0400", hash_original_method = "1A1AB0AA8E53EB2A72A3BB78A36F79E1", hash_generated_method = "77F6D44F2ABE0BCBCC8D69E5B6A28FAF")
    public String[] getTetheredIfaces() {
        try 
        {
String[] var9B4335AB68A75F3AE5F7A851BC933C3D_491818053 =             mService.getTetheredIfaces();
            var9B4335AB68A75F3AE5F7A851BC933C3D_491818053.addTaint(taint);
            return var9B4335AB68A75F3AE5F7A851BC933C3D_491818053;
        } //End block
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1961157562 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1961157562.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1961157562;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getTetheredIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.404 -0400", hash_original_method = "B4F0365B2F0B873A76FA3BA63C88578F", hash_generated_method = "A408D8CE9DD478B004A91AB1C6C693AA")
    public String[] getTetheringErroredIfaces() {
        try 
        {
String[] varCB858A8AEA35BBB091CA19C8F620CC00_770084914 =             mService.getTetheringErroredIfaces();
            varCB858A8AEA35BBB091CA19C8F620CC00_770084914.addTaint(taint);
            return varCB858A8AEA35BBB091CA19C8F620CC00_770084914;
        } //End block
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_419703303 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_419703303.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_419703303;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getTetheringErroredIfaces();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.404 -0400", hash_original_method = "88DA982A0D8C00E6CF08BAB9F849E24F", hash_generated_method = "EE1CBDF256F0317603ADE53FBE44C65B")
    public int tether(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            int var1D4AF5D11C4A903069F1C114E73F4A9F_1082941755 = (mService.tether(iface));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187715086 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1187715086;
        } //End block
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_989942693 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658593424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658593424;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.tether(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.406 -0400", hash_original_method = "A16CE7410015543313DA1C15EBE8B863", hash_generated_method = "E2879C9835DF3A9E8FD47F41241A260F")
    public int untether(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            int var5B82BA8E8DD0B942DDAE4754B7562770_1294319095 = (mService.untether(iface));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038510059 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038510059;
        } //End block
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_556358248 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654785244 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654785244;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.untether(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.407 -0400", hash_original_method = "457F62D672DCD1BF7CAF2342EBCF7BE3", hash_generated_method = "85982A6ED657A4AB09F5EE61202E1FC8")
    public boolean isTetheringSupported() {
        try 
        {
            boolean var1814E5587EF425295177A903081E6EE1_73121293 = (mService.isTetheringSupported());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502231328 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502231328;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_783744955 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122925556 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122925556;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.isTetheringSupported();
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.409 -0400", hash_original_method = "DC0367A904D99268D94A314F1CB55B9B", hash_generated_method = "07FE563D9D51FF54882FA25C93B5BBC5")
    public String[] getTetherableUsbRegexs() {
        try 
        {
String[] var18382B048E6AE48852E65DB6AAA5EAD0_595162929 =             mService.getTetherableUsbRegexs();
            var18382B048E6AE48852E65DB6AAA5EAD0_595162929.addTaint(taint);
            return var18382B048E6AE48852E65DB6AAA5EAD0_595162929;
        } //End block
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1105548221 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1105548221.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1105548221;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableUsbRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.410 -0400", hash_original_method = "8DD288EE3D6933895D6454F488DECB73", hash_generated_method = "1919012EF32C847A236FC338D0B2D49F")
    public String[] getTetherableWifiRegexs() {
        try 
        {
String[] varE6D299C14A46E7068C0D9D2AE29FFBB7_1095796610 =             mService.getTetherableWifiRegexs();
            varE6D299C14A46E7068C0D9D2AE29FFBB7_1095796610.addTaint(taint);
            return varE6D299C14A46E7068C0D9D2AE29FFBB7_1095796610;
        } //End block
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_384352562 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_384352562.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_384352562;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableWifiRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.410 -0400", hash_original_method = "83E2E43D24B9648666006A701F93D599", hash_generated_method = "8CD990F8ADEC75E912242CF02AAEF078")
    public String[] getTetherableBluetoothRegexs() {
        try 
        {
String[] var8C1BF787D9A26A56A43A1294212A5EA6_2147075513 =             mService.getTetherableBluetoothRegexs();
            var8C1BF787D9A26A56A43A1294212A5EA6_2147075513.addTaint(taint);
            return var8C1BF787D9A26A56A43A1294212A5EA6_2147075513;
        } //End block
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1018378364 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1018378364.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1018378364;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getTetherableBluetoothRegexs();
        //} catch (RemoteException e) {
            //return new String[0];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.411 -0400", hash_original_method = "952ADB6A2A3AEF46E275F5FA17E284ED", hash_generated_method = "008CBCC1B91B6483073F7C7DE055ACE4")
    public int setUsbTethering(boolean enable) {
        addTaint(enable);
        try 
        {
            int varB4C6BADBC3FE30C5AE139BE353835FAF_2066116583 = (mService.setUsbTethering(enable));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104666786 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104666786;
        } //End block
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_345627033 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115989274 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115989274;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.setUsbTethering(enable);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.412 -0400", hash_original_method = "A91E88C74DCBFDB505B1B5012FAE30D1", hash_generated_method = "24C01995C724F5DB167A3375526BD6A5")
    public int getLastTetherError(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            int var191E4B382B7503278B8565A1DC8456AB_1961652406 = (mService.getLastTetherError(iface));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493253355 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493253355;
        } //End block
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_413501721 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113192028 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113192028;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getLastTetherError(iface);
        //} catch (RemoteException e) {
            //return TETHER_ERROR_SERVICE_UNAVAIL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.412 -0400", hash_original_method = "400BD091D4CACB3FCA76B3A275DD11D5", hash_generated_method = "A8B7D0C7D232E725238F7741A584FC4F")
    public boolean requestNetworkTransitionWakelock(String forWhom) {
        addTaint(forWhom.getTaint());
        try 
        {
            mService.requestNetworkTransitionWakelock(forWhom);
            boolean varB326B5062B2F0E69046810717534CB09_412072543 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_15918736 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_15918736;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1045849401 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256789591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256789591;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.requestNetworkTransitionWakelock(forWhom);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.413 -0400", hash_original_method = "37DB5DE823B5870FA290320C99B5BB07", hash_generated_method = "89B0E2A036C6A7716FACFA7DA36F0C1F")
    public void reportInetCondition(int networkType, int percentage) {
        addTaint(percentage);
        addTaint(networkType);
        try 
        {
            mService.reportInetCondition(networkType, percentage);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.reportInetCondition(networkType, percentage);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.413 -0400", hash_original_method = "0F41E571577973AB5A169120A0CDA859", hash_generated_method = "726511FC235987EF6B59F3FD23FF463D")
    public void setGlobalProxy(ProxyProperties p) {
        addTaint(p.getTaint());
        try 
        {
            mService.setGlobalProxy(p);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setGlobalProxy(p);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.414 -0400", hash_original_method = "7F5BD964F39855F539616DAFB8170A5C", hash_generated_method = "CBB0FFAE605F28089EF667F609DA760E")
    public ProxyProperties getGlobalProxy() {
        try 
        {
ProxyProperties varC8A152E0F06A06977A2C52FB090F4830_1438307085 =             mService.getGlobalProxy();
            varC8A152E0F06A06977A2C52FB090F4830_1438307085.addTaint(taint);
            return varC8A152E0F06A06977A2C52FB090F4830_1438307085;
        } //End block
        catch (RemoteException e)
        {
ProxyProperties var540C13E9E156B687226421B24F2DF178_1127966349 =             null;
            var540C13E9E156B687226421B24F2DF178_1127966349.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1127966349;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getGlobalProxy();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.414 -0400", hash_original_method = "C61C105C2967FBAB6E5B43A96F13A0DE", hash_generated_method = "FDC2AF7023868B7875BF70FED79F153A")
    public ProxyProperties getProxy() {
        try 
        {
ProxyProperties varF9A83677CD54FBE1BA647420C68E1B7F_1806449326 =             mService.getProxy();
            varF9A83677CD54FBE1BA647420C68E1B7F_1806449326.addTaint(taint);
            return varF9A83677CD54FBE1BA647420C68E1B7F_1806449326;
        } //End block
        catch (RemoteException e)
        {
ProxyProperties var540C13E9E156B687226421B24F2DF178_68776989 =             null;
            var540C13E9E156B687226421B24F2DF178_68776989.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_68776989;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getProxy();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.415 -0400", hash_original_method = "9D2F7B8AE7DD2651562BD08E17F617DF", hash_generated_method = "938BBEE696104355AB187E6B5D6E040A")
    public void setDataDependency(int networkType, boolean met) {
        addTaint(met);
        addTaint(networkType);
        try 
        {
            mService.setDataDependency(networkType, met);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setDataDependency(networkType, met);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.416 -0400", hash_original_method = "A6B9FE53FCB83D066C3DAD2A2CD2AA6D", hash_generated_method = "E2A603DC35DBB694D6B11962F67DC5EA")
    public boolean isNetworkSupported(int networkType) {
        addTaint(networkType);
        try 
        {
            boolean var88D9C5576C1212BE5027394109B0F368_1494331639 = (mService.isNetworkSupported(networkType));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1002079899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1002079899;
        } //End block
        catch (RemoteException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1990521145 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578303717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578303717;
        // ---------- Original Method ----------
        //try {
            //return mService.isNetworkSupported(networkType);
        //} catch (RemoteException e) {}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.416 -0400", hash_original_field = "E3416443F8154D4F28ABC689636932D3", hash_generated_field = "F201A0F81F13052259E82D44CCBC8735")

    private static final String TAG = "ConnectivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.416 -0400", hash_original_field = "E18783678EA8907F4F740E9C103235E1", hash_generated_field = "D74478E2CAA048320F4ED7DCDC0267DE")

    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.416 -0400", hash_original_field = "58684C387F7472905903FDF03C02746A", hash_generated_field = "0C9BA7409106298885F98D4DB9A7BA61")

    public static final String CONNECTIVITY_ACTION_IMMEDIATE =
            "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.416 -0400", hash_original_field = "ACAA90A79946019658CF4D2C0E90FC45", hash_generated_field = "5C154E9E8533DCDF3E6DC4E5322ABCE1")

    @Deprecated
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "802EF07B65F2884495D6E969E0C88D66", hash_generated_field = "B68430B9EDED794774E47F6FA9FA85E8")

    public static final String EXTRA_IS_FAILOVER = "isFailover";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "09C2C7F358EEA8EE156BEE6102C6CB70", hash_generated_field = "38491437E03D8F52518B778972D56CD8")

    public static final String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "C03F14926EB919E467AF7936AE818188", hash_generated_field = "BF4C8084C31E77ECEC6D5E1A7C4B100F")

    public static final String EXTRA_NO_CONNECTIVITY = "noConnectivity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "3BA15662B0A0123D9208EFD88ABE81BD", hash_generated_field = "F4AF3469CA1920E05896824A0F13F189")

    public static final String EXTRA_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "F55DD0E4BCD20A1D747CDC4B055D22CE", hash_generated_field = "C2A1F543AB7E1673850281E0F6B73AA4")

    public static final String EXTRA_EXTRA_INFO = "extraInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "0E0F8AE6EE9BB45C3785EAE3A50351D4", hash_generated_field = "84A4E2B243A3B918B60966208E2EF600")

    public static final String EXTRA_INET_CONDITION = "inetCondition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "C7FF2C85F01D02DC43889B78A3046DC0", hash_generated_field = "7CC0C8005490856A2BC847B1E0AA4532")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BACKGROUND_DATA_SETTING_CHANGED =
            "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "4D03FACF839E85AAE81E416BFF0B2F03", hash_generated_field = "929E54EDEA98710E57039E6175F5F1AB")

    public static final String INET_CONDITION_ACTION =
            "android.net.conn.INET_CONDITION_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "CF9664535E91B15C6BC45651EDE4FD7C", hash_generated_field = "15608AF081DDD375FA2123C2469F75CE")

    public static final String ACTION_TETHER_STATE_CHANGED =
            "android.net.conn.TETHER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "654793663B4638ED02186244D06103D5", hash_generated_field = "5FD0830638BAEF1B21B12EF8569D3DFD")

    public static final String EXTRA_AVAILABLE_TETHER = "availableArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "A7A0C89549BF96C667EA6B857AECE418", hash_generated_field = "F15A2DC595B40FF3DA55E3CB05B0C76E")

    public static final String EXTRA_ACTIVE_TETHER = "activeArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "41B36775ABA15157AF080E707349CD53", hash_generated_field = "C4FB23C86207DA0754B9BB6EA60CB4E1")

    public static final String EXTRA_ERRORED_TETHER = "erroredArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "BA32C5D767FE9C9B50CE422A729C6F55", hash_generated_field = "93641F6D636E423068CBD0F7A429454B")

    public static final int TYPE_NONE        = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "562DD92D67E2C376ECAC9C7FE33E774D", hash_generated_field = "C9C37D3486815251D1CD39C5BE1F3D12")

    public static final int TYPE_MOBILE      = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "FAF7153C206F8A855D3926191101974F", hash_generated_field = "AC65BD7D5FC33F670E90ACDF591214B3")

    public static final int TYPE_WIFI        = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.417 -0400", hash_original_field = "A777107098EAD4C966407C3D16CAC458", hash_generated_field = "CFFD550B064A8A8F08DFF2A1CA39B65C")

    public static final int TYPE_MOBILE_MMS  = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "F52011C1686E4F3CD9759D6CC94E24DD", hash_generated_field = "9F57AC6327FA6A9B5FA8D268FA065E2F")

    public static final int TYPE_MOBILE_SUPL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "8E9B1BBAD76A87F265EEE3509913DA05", hash_generated_field = "E58E8F46709C4195B87AD88D79419D50")

    public static final int TYPE_MOBILE_DUN  = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "1C0EDB729ABB9A93A438D5ACA75108C2", hash_generated_field = "0621333417ED999CFE5293A09D2BECCB")

    public static final int TYPE_MOBILE_HIPRI = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "AC4DA46AF4A33194000B377B5FBBCBD5", hash_generated_field = "BAA1818BB1192483D8B52B8F786077C0")

    public static final int TYPE_WIMAX       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "53D91812C028FF9CD8DDF841FC6A910E", hash_generated_field = "CD355E6AC2221CCE2CCDAE49A283C8ED")

    public static final int TYPE_BLUETOOTH   = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "AF2901506BAE70BD83B4050A46E2BD52", hash_generated_field = "ABE0A738884F28B1356F01138B1EB213")

    public static final int TYPE_DUMMY       = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "1765D5FB922544A865701915DD1D3747", hash_generated_field = "ACFC541BB1EF72643D27FBCAC2F80E92")

    public static final int TYPE_ETHERNET    = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "C1FFA41D0FCE77257B41D4941D7E28C7", hash_generated_field = "C217790CC7405EE35B93FDCCBB7C8140")

    public static final int TYPE_MOBILE_FOTA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "7DC8FCC532633F1CC616125CE7A9ED71", hash_generated_field = "6D9B79B5DD49C3171F158817B3061CDF")

    public static final int TYPE_MOBILE_IMS  = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "94B34D197D8C9575A21DA4E6ED0973D6", hash_generated_field = "70BC4329B6D7C6986B2212F6DB3B92A0")

    public static final int TYPE_MOBILE_CBS  = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "4A26070CDA8366EDBF53AF48F9F8C66E", hash_generated_field = "92581ADB158A1116848D6CC3361396A8")

    public static final int TYPE_WIFI_P2P    = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "BBB4907FF99ED01DB65C34C97B36DBAA", hash_generated_field = "EFA11F2732F8BA0E99360E32BB64687E")

    public static final int MAX_RADIO_TYPE   = TYPE_WIFI_P2P;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "A4710F917416CD1A4DDBF2CBF9B78242", hash_generated_field = "1E3DEA2E494B778E3E4DC09D24507EBC")

    public static final int MAX_NETWORK_TYPE = TYPE_WIFI_P2P;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.418 -0400", hash_original_field = "09668E6C6D8A3966598A16113343EDE8", hash_generated_field = "693728286830CEC17980B2770B246B92")

    public static final int DEFAULT_NETWORK_PREFERENCE = TYPE_WIFI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "594EE2342EC63E82194DA3F121F16201", hash_generated_field = "27C649E4F5C0896362843DA1D4CCC9B3")

    public static final int TETHER_ERROR_NO_ERROR           = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "1E235120E5BB78D91FD44C27F6AC18FF", hash_generated_field = "07524C9E5C0A6E14423C5AA3A0BCF933")

    public static final int TETHER_ERROR_UNKNOWN_IFACE      = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "475D56B8E540E5A35CE3894648DE5FA9", hash_generated_field = "6A20D3B74D9781CEFE362C2F0E6C1ACB")

    public static final int TETHER_ERROR_SERVICE_UNAVAIL    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "461FD932F3282955F1EB893D9309096B", hash_generated_field = "6DBA0A44F83AE28B03C80500322E7C88")

    public static final int TETHER_ERROR_UNSUPPORTED        = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "763F5DEE712955BE78209F2BF7BBF491", hash_generated_field = "39FD0B36B98E04AAD8EEAF19046A06B2")

    public static final int TETHER_ERROR_UNAVAIL_IFACE      = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "BF0FC9BD69BB1852E21E9E7CD41679F8", hash_generated_field = "5A077B24861F547F9496BEBC8EFA8136")

    public static final int TETHER_ERROR_MASTER_ERROR       = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "FA48AEE6B0189CFD993EC1DB6FBDF8BD", hash_generated_field = "FFAEC6C250B0EF0B5C941FCD72B78F03")

    public static final int TETHER_ERROR_TETHER_IFACE_ERROR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "4CA9F39A76FFAE657179FC8A52521263", hash_generated_field = "E28AFC063D621B0867BDDEB59FAF30D1")

    public static final int TETHER_ERROR_UNTETHER_IFACE_ERROR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "AC906D4C683762A78E92D36758198069", hash_generated_field = "F6682A4AE0D5B2CE3CDD81FB1BE1FF0F")

    public static final int TETHER_ERROR_ENABLE_NAT_ERROR     = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.419 -0400", hash_original_field = "5BA53DF68BF9F14D6726E5CB2025E104", hash_generated_field = "8F0E5817C52CE45A45E797BAE8358F6C")

    public static final int TETHER_ERROR_DISABLE_NAT_ERROR    = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.420 -0400", hash_original_field = "6E6315DC94CB292B1090EA7B848E3804", hash_generated_field = "6F017CF59453C65348D1F7CD3994589B")

    public static final int TETHER_ERROR_IFACE_CFG_ERROR      = 10;
}

