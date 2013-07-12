package android.net;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.878 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "91FD67C0243C9CAC51474C01D9540196")

    private IConnectivityManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.878 -0400", hash_original_method = "6A60C197741333EAEC6E0EA679C6387D", hash_generated_method = "9748824EC9A278AAE7881447974F69D5")
    public  ConnectivityManager(IConnectivityManager service) {
        mService = checkNotNull(service, "missing IConnectivityManager");
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.880 -0400", hash_original_method = "20C5B9DE2E49D07D506F0D5479D46C57", hash_generated_method = "548A77776A813E5CF616D63EA1C17827")
    public void setNetworkPreference(int preference) {
        addTaint(preference);
        try 
        {
            mService.setNetworkPreference(preference);
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.881 -0400", hash_original_method = "900E5DCCFD12B740A82ADA5294C949B0", hash_generated_method = "2B5EEA6EE8136DEA5A944DCAE31FCB63")
    public int getNetworkPreference() {
        try 
        {
            int var19A3790390823FE4079A20780D0EE00C_1568977901 = (mService.getNetworkPreference());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973777536 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1973777536;
        } 
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_165178221 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207190412 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207190412;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.881 -0400", hash_original_method = "5E96294DED8896A900AADA5BAA807536", hash_generated_method = "2F5954282E516D4C2E1DE17EC55AFA63")
    public NetworkInfo getActiveNetworkInfo() {
        try 
        {
NetworkInfo var71037231270A581C4BC2348D12DBB752_941288640 =             mService.getActiveNetworkInfo();
            var71037231270A581C4BC2348D12DBB752_941288640.addTaint(taint);
            return var71037231270A581C4BC2348D12DBB752_941288640;
        } 
        catch (RemoteException e)
        {
NetworkInfo var540C13E9E156B687226421B24F2DF178_729401278 =             null;
            var540C13E9E156B687226421B24F2DF178_729401278.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_729401278;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.882 -0400", hash_original_method = "EA020BF9EC9A5FD5A107F43E91D20C3E", hash_generated_method = "56A3C2B20E44F875171A65A61F98EC6B")
    public NetworkInfo getActiveNetworkInfoForUid(int uid) {
        addTaint(uid);
        try 
        {
NetworkInfo var716369D49A4FE5B98EE868B69EA92A1E_1035764706 =             mService.getActiveNetworkInfoForUid(uid);
            var716369D49A4FE5B98EE868B69EA92A1E_1035764706.addTaint(taint);
            return var716369D49A4FE5B98EE868B69EA92A1E_1035764706;
        } 
        catch (RemoteException e)
        {
NetworkInfo var540C13E9E156B687226421B24F2DF178_846321807 =             null;
            var540C13E9E156B687226421B24F2DF178_846321807.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_846321807;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.883 -0400", hash_original_method = "96564B6A49DFD6F7048AD1538B907A96", hash_generated_method = "B6C687E0DDCCE3CF7F7FA207FC8DF751")
    public NetworkInfo getNetworkInfo(int networkType) {
        addTaint(networkType);
        try 
        {
NetworkInfo var3FB1D95655254021728BF247DB3F0249_1759328042 =             mService.getNetworkInfo(networkType);
            var3FB1D95655254021728BF247DB3F0249_1759328042.addTaint(taint);
            return var3FB1D95655254021728BF247DB3F0249_1759328042;
        } 
        catch (RemoteException e)
        {
NetworkInfo var540C13E9E156B687226421B24F2DF178_2067442848 =             null;
            var540C13E9E156B687226421B24F2DF178_2067442848.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2067442848;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.884 -0400", hash_original_method = "394CF6797F6D312CB8F1ED596C180D8F", hash_generated_method = "73849219F593D6E54804C31CC4A17D8C")
    public NetworkInfo[] getAllNetworkInfo() {
        try 
        {
NetworkInfo[] var70CFDC0136921D96C056C2A1EB42D810_1476364664 =             mService.getAllNetworkInfo();
            var70CFDC0136921D96C056C2A1EB42D810_1476364664.addTaint(taint);
            return var70CFDC0136921D96C056C2A1EB42D810_1476364664;
        } 
        catch (RemoteException e)
        {
NetworkInfo[] var540C13E9E156B687226421B24F2DF178_988028398 =             null;
            var540C13E9E156B687226421B24F2DF178_988028398.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_988028398;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.885 -0400", hash_original_method = "D6D4DA92D9064C06A48DA2C5EB8FF9D2", hash_generated_method = "30BFFBFBCB741A1077E7CEF73B4989C4")
    public LinkProperties getActiveLinkProperties() {
        try 
        {
LinkProperties varBA28DAB2FB296D0CC5A82CF84CEA5F30_1238914621 =             mService.getActiveLinkProperties();
            varBA28DAB2FB296D0CC5A82CF84CEA5F30_1238914621.addTaint(taint);
            return varBA28DAB2FB296D0CC5A82CF84CEA5F30_1238914621;
        } 
        catch (RemoteException e)
        {
LinkProperties var540C13E9E156B687226421B24F2DF178_984019170 =             null;
            var540C13E9E156B687226421B24F2DF178_984019170.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_984019170;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.886 -0400", hash_original_method = "C7AAA0ED9F7BD2D04E30B8A62557C00D", hash_generated_method = "C0D658987DC9A40DE8127EEBE199BDB1")
    public LinkProperties getLinkProperties(int networkType) {
        addTaint(networkType);
        try 
        {
LinkProperties varCB694E0F083E3A04EA3638584A69852B_686633924 =             mService.getLinkProperties(networkType);
            varCB694E0F083E3A04EA3638584A69852B_686633924.addTaint(taint);
            return varCB694E0F083E3A04EA3638584A69852B_686633924;
        } 
        catch (RemoteException e)
        {
LinkProperties var540C13E9E156B687226421B24F2DF178_1006263053 =             null;
            var540C13E9E156B687226421B24F2DF178_1006263053.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1006263053;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.886 -0400", hash_original_method = "8773F3976862F74C7E8795673CF57A3F", hash_generated_method = "0AACCD33C6167CF1342FDC3FD912A2A4")
    public boolean setRadios(boolean turnOn) {
        addTaint(turnOn);
        try 
        {
            boolean varD09A4D6511E647D79E7FB3BE2F8B26E6_1403816826 = (mService.setRadios(turnOn));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920872152 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_920872152;
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1789017394 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568678398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_568678398;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.887 -0400", hash_original_method = "F4DEFED01E737220B0A84C9B3C165EA1", hash_generated_method = "2F8961CED576F9EB91CD3F4EB4C3837F")
    public boolean setRadio(int networkType, boolean turnOn) {
        addTaint(turnOn);
        addTaint(networkType);
        try 
        {
            boolean var32495EF67E52304E6220286C24BA7911_404490731 = (mService.setRadio(networkType, turnOn));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296961521 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296961521;
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1425788197 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238355572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238355572;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.887 -0400", hash_original_method = "709E7052A14C2A0D29C9219C00073F31", hash_generated_method = "17D4EC001945897A212C13D3DF5725EE")
    public int startUsingNetworkFeature(int networkType, String feature) {
        addTaint(feature.getTaint());
        addTaint(networkType);
        try 
        {
            int varBC6446D5F9F3C6B3BA6886925D6C1D19_218449205 = (mService.startUsingNetworkFeature(networkType, feature,
                    new Binder()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668006883 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668006883;
        } 
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1579838511 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_560348509 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_560348509;
        } 
        
        
            
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.888 -0400", hash_original_method = "60EB71F5D3B7B41111FE02ED36065292", hash_generated_method = "9E482C6AE22B8206C127EB9015BAE443")
    public int stopUsingNetworkFeature(int networkType, String feature) {
        addTaint(feature.getTaint());
        addTaint(networkType);
        try 
        {
            int var908FAFA2FE48FDE6EA53EBB333658A21_590536184 = (mService.stopUsingNetworkFeature(networkType, feature));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404373918 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404373918;
        } 
        catch (RemoteException e)
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_39455224 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282116079 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282116079;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.889 -0400", hash_original_method = "C11FA4279C0A187DA118461D9F53788F", hash_generated_method = "B9D3999B9838710A93DD1F578C1C0101")
    public boolean requestRouteToHost(int networkType, int hostAddress) {
        addTaint(hostAddress);
        addTaint(networkType);
        InetAddress inetAddress = NetworkUtils.intToInetAddress(hostAddress);
    if(inetAddress == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_310958398 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68929344 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_68929344;
        } 
        boolean varC1317118DA63ED4EE5A4EA03701A9C38_1489114894 = (requestRouteToHostAddress(networkType, inetAddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865900094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_865900094;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.889 -0400", hash_original_method = "EFA83347B3FFE38EB6FE081BBE35835E", hash_generated_method = "AB42DEEB2BF0BEF8B7D7E7C0702716CD")
    public boolean requestRouteToHostAddress(int networkType, InetAddress hostAddress) {
        addTaint(hostAddress.getTaint());
        addTaint(networkType);
        byte[] address = hostAddress.getAddress();
        try 
        {
            boolean var0AFF5DF071EDC728B4E87E4CC9407A65_1840674554 = (mService.requestRouteToHostAddress(networkType, address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572660248 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_572660248;
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1092285976 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903739450 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_903739450;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.889 -0400", hash_original_method = "6498894EA2E4C7DBE6A13B3BD05F6504", hash_generated_method = "FE813DBC143B3FE92D50CDECE2106F3D")
    @Deprecated
    public boolean getBackgroundDataSetting() {
        boolean varB326B5062B2F0E69046810717534CB09_747191804 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769023181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769023181;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.890 -0400", hash_original_method = "C7D66D7319A6F772837F5FAC4582BCF2", hash_generated_method = "DD5713BFAEAD7937DCF087E006B8A5CE")
    @Deprecated
    public void setBackgroundDataSetting(boolean allowBackgroundData) {
        addTaint(allowBackgroundData);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.890 -0400", hash_original_method = "2A17F1CC768C6D56971308D1A367AB75", hash_generated_method = "05FF1086A76098039A8A645385A41BC4")
    public NetworkQuotaInfo getActiveNetworkQuotaInfo() {
        try 
        {
NetworkQuotaInfo var2C6D2C827838090203CD1E15C5DF8B8F_1876897530 =             mService.getActiveNetworkQuotaInfo();
            var2C6D2C827838090203CD1E15C5DF8B8F_1876897530.addTaint(taint);
            return var2C6D2C827838090203CD1E15C5DF8B8F_1876897530;
        } 
        catch (RemoteException e)
        {
NetworkQuotaInfo var540C13E9E156B687226421B24F2DF178_2172322 =             null;
            var540C13E9E156B687226421B24F2DF178_2172322.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2172322;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.891 -0400", hash_original_method = "4787FEDAB977985506F4394396606391", hash_generated_method = "9E1EA5DBB8051E1FE58FAC7734B6FC6F")
    public boolean getMobileDataEnabled() {
        try 
        {
            boolean varB458843D81D2B3075744C73F266D7A2C_1917348918 = (mService.getMobileDataEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557154678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557154678;
        } 
        catch (RemoteException e)
        {
            boolean varB326B5062B2F0E69046810717534CB09_230910424 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303149336 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303149336;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.891 -0400", hash_original_method = "03BF638942F758314C38E6E89D590F06", hash_generated_method = "8C7040F05C00E42F43910B521E4E4743")
    public void setMobileDataEnabled(boolean enabled) {
        addTaint(enabled);
        try 
        {
            mService.setMobileDataEnabled(enabled);
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.891 -0400", hash_original_method = "65586E40689502E42674D85C93789ED5", hash_generated_method = "A23E748A80B2D2E49405E39C2FCF8079")
    public String[] getTetherableIfaces() {
        try 
        {
String[] var74024E2BFB98559A6111021EA7992D3F_738380640 =             mService.getTetherableIfaces();
            var74024E2BFB98559A6111021EA7992D3F_738380640.addTaint(taint);
            return var74024E2BFB98559A6111021EA7992D3F_738380640;
        } 
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1642710082 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1642710082.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1642710082;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.892 -0400", hash_original_method = "1A1AB0AA8E53EB2A72A3BB78A36F79E1", hash_generated_method = "B355AA56F97A26E61D612254AD52217C")
    public String[] getTetheredIfaces() {
        try 
        {
String[] var9B4335AB68A75F3AE5F7A851BC933C3D_1952750379 =             mService.getTetheredIfaces();
            var9B4335AB68A75F3AE5F7A851BC933C3D_1952750379.addTaint(taint);
            return var9B4335AB68A75F3AE5F7A851BC933C3D_1952750379;
        } 
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1590803600 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1590803600.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1590803600;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.892 -0400", hash_original_method = "B4F0365B2F0B873A76FA3BA63C88578F", hash_generated_method = "F415089AF1FBA7F8E13CB6F578B2869B")
    public String[] getTetheringErroredIfaces() {
        try 
        {
String[] varCB858A8AEA35BBB091CA19C8F620CC00_1138359736 =             mService.getTetheringErroredIfaces();
            varCB858A8AEA35BBB091CA19C8F620CC00_1138359736.addTaint(taint);
            return varCB858A8AEA35BBB091CA19C8F620CC00_1138359736;
        } 
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_710638234 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_710638234.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_710638234;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.893 -0400", hash_original_method = "88DA982A0D8C00E6CF08BAB9F849E24F", hash_generated_method = "0DB09DD15FDB39C5CE5EBF4F5989E1E1")
    public int tether(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            int var1D4AF5D11C4A903069F1C114E73F4A9F_295876757 = (mService.tether(iface));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43693992 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43693992;
        } 
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_1660049580 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557869896 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557869896;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.893 -0400", hash_original_method = "A16CE7410015543313DA1C15EBE8B863", hash_generated_method = "61B47574FE2517880ADA1BE76DBBA9EB")
    public int untether(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            int var5B82BA8E8DD0B942DDAE4754B7562770_281964132 = (mService.untether(iface));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108969404 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108969404;
        } 
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_485221707 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960366060 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960366060;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.894 -0400", hash_original_method = "457F62D672DCD1BF7CAF2342EBCF7BE3", hash_generated_method = "949835D5080F9179F81C29CD18543C5B")
    public boolean isTetheringSupported() {
        try 
        {
            boolean var1814E5587EF425295177A903081E6EE1_719248920 = (mService.isTetheringSupported());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81592171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_81592171;
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_589731449 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315368869 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315368869;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.894 -0400", hash_original_method = "DC0367A904D99268D94A314F1CB55B9B", hash_generated_method = "CD9BDADC044366AEBF2F52721EB9B0FE")
    public String[] getTetherableUsbRegexs() {
        try 
        {
String[] var18382B048E6AE48852E65DB6AAA5EAD0_1570720885 =             mService.getTetherableUsbRegexs();
            var18382B048E6AE48852E65DB6AAA5EAD0_1570720885.addTaint(taint);
            return var18382B048E6AE48852E65DB6AAA5EAD0_1570720885;
        } 
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1462106886 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1462106886.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1462106886;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.895 -0400", hash_original_method = "8DD288EE3D6933895D6454F488DECB73", hash_generated_method = "1B762A5F0C793B1C2A2EBDCCE2C9F5F7")
    public String[] getTetherableWifiRegexs() {
        try 
        {
String[] varE6D299C14A46E7068C0D9D2AE29FFBB7_794479475 =             mService.getTetherableWifiRegexs();
            varE6D299C14A46E7068C0D9D2AE29FFBB7_794479475.addTaint(taint);
            return varE6D299C14A46E7068C0D9D2AE29FFBB7_794479475;
        } 
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_1449546339 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_1449546339.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_1449546339;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.895 -0400", hash_original_method = "83E2E43D24B9648666006A701F93D599", hash_generated_method = "A9A357B313F049E98F0B13D6012F3F85")
    public String[] getTetherableBluetoothRegexs() {
        try 
        {
String[] var8C1BF787D9A26A56A43A1294212A5EA6_553253686 =             mService.getTetherableBluetoothRegexs();
            var8C1BF787D9A26A56A43A1294212A5EA6_553253686.addTaint(taint);
            return var8C1BF787D9A26A56A43A1294212A5EA6_553253686;
        } 
        catch (RemoteException e)
        {
String[] var93992EED3A5738F23A3CAF5AB8E5B9F1_451063784 =             new String[0];
            var93992EED3A5738F23A3CAF5AB8E5B9F1_451063784.addTaint(taint);
            return var93992EED3A5738F23A3CAF5AB8E5B9F1_451063784;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.896 -0400", hash_original_method = "952ADB6A2A3AEF46E275F5FA17E284ED", hash_generated_method = "8374AA019484392C1F59EDD7E23F8974")
    public int setUsbTethering(boolean enable) {
        addTaint(enable);
        try 
        {
            int varB4C6BADBC3FE30C5AE139BE353835FAF_552202674 = (mService.setUsbTethering(enable));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691345115 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691345115;
        } 
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_553975736 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500928003 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500928003;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.896 -0400", hash_original_method = "A91E88C74DCBFDB505B1B5012FAE30D1", hash_generated_method = "D5513EE797736F5AE827DD5D889BF02E")
    public int getLastTetherError(String iface) {
        addTaint(iface.getTaint());
        try 
        {
            int var191E4B382B7503278B8565A1DC8456AB_1090575485 = (mService.getLastTetherError(iface));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103692746 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103692746;
        } 
        catch (RemoteException e)
        {
            int varF5619E86E20DFE886240F33BFE9271F1_2107907378 = (TETHER_ERROR_SERVICE_UNAVAIL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379045367 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379045367;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.897 -0400", hash_original_method = "400BD091D4CACB3FCA76B3A275DD11D5", hash_generated_method = "67B2FA9768A81AA35A70413A17315E34")
    public boolean requestNetworkTransitionWakelock(String forWhom) {
        addTaint(forWhom.getTaint());
        try 
        {
            mService.requestNetworkTransitionWakelock(forWhom);
            boolean varB326B5062B2F0E69046810717534CB09_989684777 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972549773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972549773;
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1466580629 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309767313 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_309767313;
        } 
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.897 -0400", hash_original_method = "37DB5DE823B5870FA290320C99B5BB07", hash_generated_method = "89B0E2A036C6A7716FACFA7DA36F0C1F")
    public void reportInetCondition(int networkType, int percentage) {
        addTaint(percentage);
        addTaint(networkType);
        try 
        {
            mService.reportInetCondition(networkType, percentage);
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.897 -0400", hash_original_method = "0F41E571577973AB5A169120A0CDA859", hash_generated_method = "726511FC235987EF6B59F3FD23FF463D")
    public void setGlobalProxy(ProxyProperties p) {
        addTaint(p.getTaint());
        try 
        {
            mService.setGlobalProxy(p);
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.898 -0400", hash_original_method = "7F5BD964F39855F539616DAFB8170A5C", hash_generated_method = "2DE5EFADF152053F25BF87CCA2D5E950")
    public ProxyProperties getGlobalProxy() {
        try 
        {
ProxyProperties varC8A152E0F06A06977A2C52FB090F4830_45093719 =             mService.getGlobalProxy();
            varC8A152E0F06A06977A2C52FB090F4830_45093719.addTaint(taint);
            return varC8A152E0F06A06977A2C52FB090F4830_45093719;
        } 
        catch (RemoteException e)
        {
ProxyProperties var540C13E9E156B687226421B24F2DF178_335575286 =             null;
            var540C13E9E156B687226421B24F2DF178_335575286.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_335575286;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.898 -0400", hash_original_method = "C61C105C2967FBAB6E5B43A96F13A0DE", hash_generated_method = "001261905B7C3813F48333E0252BB47D")
    public ProxyProperties getProxy() {
        try 
        {
ProxyProperties varF9A83677CD54FBE1BA647420C68E1B7F_817200808 =             mService.getProxy();
            varF9A83677CD54FBE1BA647420C68E1B7F_817200808.addTaint(taint);
            return varF9A83677CD54FBE1BA647420C68E1B7F_817200808;
        } 
        catch (RemoteException e)
        {
ProxyProperties var540C13E9E156B687226421B24F2DF178_354828075 =             null;
            var540C13E9E156B687226421B24F2DF178_354828075.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_354828075;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.899 -0400", hash_original_method = "9D2F7B8AE7DD2651562BD08E17F617DF", hash_generated_method = "938BBEE696104355AB187E6B5D6E040A")
    public void setDataDependency(int networkType, boolean met) {
        addTaint(met);
        addTaint(networkType);
        try 
        {
            mService.setDataDependency(networkType, met);
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.899 -0400", hash_original_method = "A6B9FE53FCB83D066C3DAD2A2CD2AA6D", hash_generated_method = "4D8CC7D13291A4A7C56AD63C9B3F722F")
    public boolean isNetworkSupported(int networkType) {
        addTaint(networkType);
        try 
        {
            boolean var88D9C5576C1212BE5027394109B0F368_361585339 = (mService.isNetworkSupported(networkType));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370975161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_370975161;
        } 
        catch (RemoteException e)
        {
        } 
        boolean var68934A3E9455FA72420237EB05902327_1667997952 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621619142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_621619142;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.899 -0400", hash_original_field = "E3416443F8154D4F28ABC689636932D3", hash_generated_field = "F201A0F81F13052259E82D44CCBC8735")

    private static final String TAG = "ConnectivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "E18783678EA8907F4F740E9C103235E1", hash_generated_field = "D74478E2CAA048320F4ED7DCDC0267DE")

    public static final String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "58684C387F7472905903FDF03C02746A", hash_generated_field = "0C9BA7409106298885F98D4DB9A7BA61")

    public static final String CONNECTIVITY_ACTION_IMMEDIATE =
            "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "ACAA90A79946019658CF4D2C0E90FC45", hash_generated_field = "5C154E9E8533DCDF3E6DC4E5322ABCE1")

    @Deprecated
    public static final String EXTRA_NETWORK_INFO = "networkInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "802EF07B65F2884495D6E969E0C88D66", hash_generated_field = "B68430B9EDED794774E47F6FA9FA85E8")

    public static final String EXTRA_IS_FAILOVER = "isFailover";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "09C2C7F358EEA8EE156BEE6102C6CB70", hash_generated_field = "38491437E03D8F52518B778972D56CD8")

    public static final String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "C03F14926EB919E467AF7936AE818188", hash_generated_field = "BF4C8084C31E77ECEC6D5E1A7C4B100F")

    public static final String EXTRA_NO_CONNECTIVITY = "noConnectivity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "3BA15662B0A0123D9208EFD88ABE81BD", hash_generated_field = "F4AF3469CA1920E05896824A0F13F189")

    public static final String EXTRA_REASON = "reason";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "F55DD0E4BCD20A1D747CDC4B055D22CE", hash_generated_field = "C2A1F543AB7E1673850281E0F6B73AA4")

    public static final String EXTRA_EXTRA_INFO = "extraInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "0E0F8AE6EE9BB45C3785EAE3A50351D4", hash_generated_field = "84A4E2B243A3B918B60966208E2EF600")

    public static final String EXTRA_INET_CONDITION = "inetCondition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "C7FF2C85F01D02DC43889B78A3046DC0", hash_generated_field = "7CC0C8005490856A2BC847B1E0AA4532")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_BACKGROUND_DATA_SETTING_CHANGED =
            "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "4D03FACF839E85AAE81E416BFF0B2F03", hash_generated_field = "929E54EDEA98710E57039E6175F5F1AB")

    public static final String INET_CONDITION_ACTION =
            "android.net.conn.INET_CONDITION_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "CF9664535E91B15C6BC45651EDE4FD7C", hash_generated_field = "15608AF081DDD375FA2123C2469F75CE")

    public static final String ACTION_TETHER_STATE_CHANGED =
            "android.net.conn.TETHER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "654793663B4638ED02186244D06103D5", hash_generated_field = "5FD0830638BAEF1B21B12EF8569D3DFD")

    public static final String EXTRA_AVAILABLE_TETHER = "availableArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "A7A0C89549BF96C667EA6B857AECE418", hash_generated_field = "F15A2DC595B40FF3DA55E3CB05B0C76E")

    public static final String EXTRA_ACTIVE_TETHER = "activeArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "41B36775ABA15157AF080E707349CD53", hash_generated_field = "C4FB23C86207DA0754B9BB6EA60CB4E1")

    public static final String EXTRA_ERRORED_TETHER = "erroredArray";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.900 -0400", hash_original_field = "BA32C5D767FE9C9B50CE422A729C6F55", hash_generated_field = "93641F6D636E423068CBD0F7A429454B")

    public static final int TYPE_NONE        = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "562DD92D67E2C376ECAC9C7FE33E774D", hash_generated_field = "C9C37D3486815251D1CD39C5BE1F3D12")

    public static final int TYPE_MOBILE      = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "FAF7153C206F8A855D3926191101974F", hash_generated_field = "AC65BD7D5FC33F670E90ACDF591214B3")

    public static final int TYPE_WIFI        = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "A777107098EAD4C966407C3D16CAC458", hash_generated_field = "CFFD550B064A8A8F08DFF2A1CA39B65C")

    public static final int TYPE_MOBILE_MMS  = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "F52011C1686E4F3CD9759D6CC94E24DD", hash_generated_field = "9F57AC6327FA6A9B5FA8D268FA065E2F")

    public static final int TYPE_MOBILE_SUPL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "8E9B1BBAD76A87F265EEE3509913DA05", hash_generated_field = "E58E8F46709C4195B87AD88D79419D50")

    public static final int TYPE_MOBILE_DUN  = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "1C0EDB729ABB9A93A438D5ACA75108C2", hash_generated_field = "0621333417ED999CFE5293A09D2BECCB")

    public static final int TYPE_MOBILE_HIPRI = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "AC4DA46AF4A33194000B377B5FBBCBD5", hash_generated_field = "BAA1818BB1192483D8B52B8F786077C0")

    public static final int TYPE_WIMAX       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "53D91812C028FF9CD8DDF841FC6A910E", hash_generated_field = "CD355E6AC2221CCE2CCDAE49A283C8ED")

    public static final int TYPE_BLUETOOTH   = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "AF2901506BAE70BD83B4050A46E2BD52", hash_generated_field = "ABE0A738884F28B1356F01138B1EB213")

    public static final int TYPE_DUMMY       = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "1765D5FB922544A865701915DD1D3747", hash_generated_field = "ACFC541BB1EF72643D27FBCAC2F80E92")

    public static final int TYPE_ETHERNET    = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "C1FFA41D0FCE77257B41D4941D7E28C7", hash_generated_field = "C217790CC7405EE35B93FDCCBB7C8140")

    public static final int TYPE_MOBILE_FOTA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "7DC8FCC532633F1CC616125CE7A9ED71", hash_generated_field = "6D9B79B5DD49C3171F158817B3061CDF")

    public static final int TYPE_MOBILE_IMS  = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "94B34D197D8C9575A21DA4E6ED0973D6", hash_generated_field = "70BC4329B6D7C6986B2212F6DB3B92A0")

    public static final int TYPE_MOBILE_CBS  = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.901 -0400", hash_original_field = "4A26070CDA8366EDBF53AF48F9F8C66E", hash_generated_field = "92581ADB158A1116848D6CC3361396A8")

    public static final int TYPE_WIFI_P2P    = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "BBB4907FF99ED01DB65C34C97B36DBAA", hash_generated_field = "EFA11F2732F8BA0E99360E32BB64687E")

    public static final int MAX_RADIO_TYPE   = TYPE_WIFI_P2P;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "A4710F917416CD1A4DDBF2CBF9B78242", hash_generated_field = "1E3DEA2E494B778E3E4DC09D24507EBC")

    public static final int MAX_NETWORK_TYPE = TYPE_WIFI_P2P;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "09668E6C6D8A3966598A16113343EDE8", hash_generated_field = "693728286830CEC17980B2770B246B92")

    public static final int DEFAULT_NETWORK_PREFERENCE = TYPE_WIFI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "594EE2342EC63E82194DA3F121F16201", hash_generated_field = "27C649E4F5C0896362843DA1D4CCC9B3")

    public static final int TETHER_ERROR_NO_ERROR           = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "1E235120E5BB78D91FD44C27F6AC18FF", hash_generated_field = "07524C9E5C0A6E14423C5AA3A0BCF933")

    public static final int TETHER_ERROR_UNKNOWN_IFACE      = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "475D56B8E540E5A35CE3894648DE5FA9", hash_generated_field = "6A20D3B74D9781CEFE362C2F0E6C1ACB")

    public static final int TETHER_ERROR_SERVICE_UNAVAIL    = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "461FD932F3282955F1EB893D9309096B", hash_generated_field = "6DBA0A44F83AE28B03C80500322E7C88")

    public static final int TETHER_ERROR_UNSUPPORTED        = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "763F5DEE712955BE78209F2BF7BBF491", hash_generated_field = "39FD0B36B98E04AAD8EEAF19046A06B2")

    public static final int TETHER_ERROR_UNAVAIL_IFACE      = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "BF0FC9BD69BB1852E21E9E7CD41679F8", hash_generated_field = "5A077B24861F547F9496BEBC8EFA8136")

    public static final int TETHER_ERROR_MASTER_ERROR       = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "FA48AEE6B0189CFD993EC1DB6FBDF8BD", hash_generated_field = "FFAEC6C250B0EF0B5C941FCD72B78F03")

    public static final int TETHER_ERROR_TETHER_IFACE_ERROR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "4CA9F39A76FFAE657179FC8A52521263", hash_generated_field = "E28AFC063D621B0867BDDEB59FAF30D1")

    public static final int TETHER_ERROR_UNTETHER_IFACE_ERROR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "AC906D4C683762A78E92D36758198069", hash_generated_field = "F6682A4AE0D5B2CE3CDD81FB1BE1FF0F")

    public static final int TETHER_ERROR_ENABLE_NAT_ERROR     = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "5BA53DF68BF9F14D6726E5CB2025E104", hash_generated_field = "8F0E5817C52CE45A45E797BAE8358F6C")

    public static final int TETHER_ERROR_DISABLE_NAT_ERROR    = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.902 -0400", hash_original_field = "6E6315DC94CB292B1090EA7B848E3804", hash_generated_field = "6F017CF59453C65348D1F7CD3994589B")

    public static final int TETHER_ERROR_IFACE_CFG_ERROR      = 10;
}

