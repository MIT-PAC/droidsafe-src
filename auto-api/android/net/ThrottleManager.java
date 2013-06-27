package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.os.Binder;
import android.os.RemoteException;

public class ThrottleManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.360 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6BB94C28B991564A2654192146B5BDD6")

    private IThrottleManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.370 -0400", hash_original_method = "A34F832700CA864903AE32FE53CD267E", hash_generated_method = "3F4BC6E2219D8CDC47CEDF2CEA3212F6")
    @SuppressWarnings({"UnusedDeclaration"})
    private  ThrottleManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.371 -0400", hash_original_method = "1E8483A92A1408237E2885FBEDD54340", hash_generated_method = "B103BB6A992F9A3587666360FC87373A")
    public  ThrottleManager(IThrottleManager service) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "ThrottleManager() cannot be constructed with null service");
        } //End block
        mService = service;
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new IllegalArgumentException(
                //"ThrottleManager() cannot be constructed with null service");
        //}
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.372 -0400", hash_original_method = "2AA7855A594B5700D93ECFB7D9A7B7C4", hash_generated_method = "D191D03CBDB0CA8C1172DC528E893658")
    public long getResetTime(String iface) {
        try 
        {
            long var204217EC59A9D04F93D6FDBD469F9D59_1099126061 = (mService.getResetTime(iface));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1710295805 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1710295805;
        // ---------- Original Method ----------
        //try {
            //return mService.getResetTime(iface);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.373 -0400", hash_original_method = "71ECD56B8A0A75240BCCEB36337D3BA2", hash_generated_method = "BFA58277F6B2FE89362EECF944A19EC9")
    public long getPeriodStartTime(String iface) {
        try 
        {
            long var41F2168021DDC7A88D402A7B46B6D14A_1452219770 = (mService.getPeriodStartTime(iface));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1231547817 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1231547817;
        // ---------- Original Method ----------
        //try {
            //return mService.getPeriodStartTime(iface);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.373 -0400", hash_original_method = "8241A155E8F913EC462AEA4A2F5ED1F8", hash_generated_method = "DCF1C431C161B478BD4765503D3BE1C5")
    public long getByteCount(String iface, int direction, int period, int ago) {
        try 
        {
            long var30378541F1303B54C3A8D606E1FBC18A_1518901191 = (mService.getByteCount(iface, direction, period, ago));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        addTaint(direction);
        addTaint(period);
        addTaint(ago);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_584236825 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_584236825;
        // ---------- Original Method ----------
        //try {
            //return mService.getByteCount(iface, direction, period, ago);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.398 -0400", hash_original_method = "1E5CE1E6E971F0A1DB09E08194D8A23E", hash_generated_method = "1DBA17CD8C763794D2626E00EDEEA2B5")
    public long getCliffThreshold(String iface, int cliff) {
        try 
        {
            long varAB9EEDBAB9E22E2A16A7FBF573F9D420_410076726 = (mService.getCliffThreshold(iface, cliff));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        addTaint(cliff);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1857229039 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1857229039;
        // ---------- Original Method ----------
        //try {
            //return mService.getCliffThreshold(iface, cliff);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.400 -0400", hash_original_method = "1E0667CC63B486C17ACE24556BBA89F5", hash_generated_method = "965E8C444E33F9BD1F05CCAB348A9762")
    public int getCliffLevel(String iface, int cliff) {
        try 
        {
            int varCBBABF44689050DB88F0F7777EEC0438_1182107230 = (mService.getCliffLevel(iface, cliff));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(iface.getTaint());
        addTaint(cliff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981129971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981129971;
        // ---------- Original Method ----------
        //try {
            //return mService.getCliffLevel(iface, cliff);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.400 -0400", hash_original_method = "BE6DD87215E82DDA8E4A2908333DC9D4", hash_generated_method = "2DF203E33178291ABFCF03E4B223906C")
    public String getHelpUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_1744481150 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1880325281 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1744481150 = mService.getHelpUri();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1880325281 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_248177416; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_248177416 = varB4EAC82CA7396A68D541C85D26508E83_1744481150;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_248177416 = varB4EAC82CA7396A68D541C85D26508E83_1880325281;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_248177416.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_248177416;
        // ---------- Original Method ----------
        //try {
            //return mService.getHelpUri();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "E9D69712E7BD9375036DE9821C2D19DA", hash_generated_field = "6898D21EE81972732398F7476E57A4E5")

    public static final String THROTTLE_POLL_ACTION = "android.net.thrott.POLL_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "45DF59F8529C3039D220FA9A81B7DE53", hash_generated_field = "C60D73AECC3BBEBC845B460B2C0FC207")

    public static final String EXTRA_CYCLE_READ = "cycleRead";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "CA2C178B5867009B1D9948449EEB4B60", hash_generated_field = "614D6C44EC9F28B2D5FB5646A9D9B2A1")

    public static final String EXTRA_CYCLE_WRITE = "cycleWrite";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "8B307471FC2FDB8B0241A3005FD30F39", hash_generated_field = "B0C2C07165B22D87786F95B5CF4A95EC")

    public static final String EXTRA_CYCLE_START = "cycleStart";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "77A13DCB1FC5A1BCAFBEBD72C218E5DB", hash_generated_field = "915B8CD3CA64A3EEA22D5D810E05B311")

    public static final String EXTRA_CYCLE_END = "cycleEnd";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "43D8C343C4660ECEEB34D2608D0694C2", hash_generated_field = "ED12FBB3FB48078997AB63E809995555")

    public static final String THROTTLE_ACTION = "android.net.thrott.THROTTLE_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "0744B50E5CE685401A4B17EA53DBC041", hash_generated_field = "122B5A88AD4F5DA97CF614FC9CB7112B")

    public static final String EXTRA_THROTTLE_LEVEL = "level";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.401 -0400", hash_original_field = "6DD887D9924C025779C4436D9C4E493A", hash_generated_field = "FB3DCC9354DA96058DD89B592250B71F")

    public static final String POLICY_CHANGED_ACTION = "android.net.thrott.POLICY_CHANGED_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "7C81C04C5B7BF8E649135D77EF16EBFA", hash_generated_field = "07E577AB923A1F0E031C2D3766146C02")

    public static final int DIRECTION_TX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "A266203E9BDE616672C5DBE29DA2B690", hash_generated_field = "834CDF39C9CC543B48AE086B421ECA77")

    public static final int DIRECTION_RX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "780622D25A9EEB18DB77E0E9941A55AA", hash_generated_field = "87522BCD580B6A5AFD35F6902B2D1E21")

    public static final int PERIOD_CYCLE  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "48F80B54C34B64ED0DC206F654FB4AD8", hash_generated_field = "E8BFFBAA705E3AF3D0A7C53DEE7C7008")

    public static final int PERIOD_YEAR   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "B2A32047683D7BE4A79A7185CAD3BCFC", hash_generated_field = "08FFC80FB898CB6A4543FB0922959EFB")

    public static final int PERIOD_MONTH  = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "17F496D35701D7BB7BE1E1D7079312D9", hash_generated_field = "32735A8A4863C7888B70468A911092C3")

    public static final int PERIOD_WEEK   = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "6BC136E64CC12071F89E082D061A2E2E", hash_generated_field = "C6E0E63CC773D681BAE66CBD36FD943C")

    public static final int PERIOD_7DAY   = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.402 -0400", hash_original_field = "4B521D604C2763135D3E2D7812A3B20F", hash_generated_field = "7F5C827CE30965E88157F824EED66B89")

    public static final int PERIOD_DAY    = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.403 -0400", hash_original_field = "2FE213A4131D9CB13C10A0E7C508B5D2", hash_generated_field = "93FC7C33BAAB08F424FB1D467A0AF63A")

    public static final int PERIOD_24HOUR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.403 -0400", hash_original_field = "79C5F9E65EE9F3A233677000A4E7750D", hash_generated_field = "8564FC078F4F6D5F682451C9CA7511B0")

    public static final int PERIOD_HOUR   = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.403 -0400", hash_original_field = "BD57BB81BAF388CBB2BB491F08B3F3DA", hash_generated_field = "DEB645AC680C218CA74E35EE0F48291C")

    public static final int PERIOD_60MIN  = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.403 -0400", hash_original_field = "15C7210CA8C1F826393F8A54D5B6ED5B", hash_generated_field = "F93352F76A6EE829F15E2FF62662F7EC")

    public static final int PERIOD_MINUTE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.403 -0400", hash_original_field = "059D0AD6CA74A705C1B0E696BC076009", hash_generated_field = "9399D0B1B6AB08F0D2EF7457960FA4E0")

    public static final int PERIOD_60SEC  = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:20.404 -0400", hash_original_field = "FE59F7E5D092060C00CD5A4E372D73F3", hash_generated_field = "8BD9177938B69E4736C243116A5F85CB")

    public static final int PERIOD_SECOND = 11;
}

