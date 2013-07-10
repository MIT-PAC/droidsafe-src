package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import static android.content.pm.PackageManager.GET_SIGNATURES;
import static android.text.format.Time.MONTH_DAY;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.text.format.Time;
import com.google.android.collect.Sets;
import java.io.PrintWriter;
import java.util.HashSet;

public class NetworkPolicyManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.426 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "99D41184207358A72CF865D27CF56B99")

    private INetworkPolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.427 -0400", hash_original_method = "BE20EED3085F3645396D71EF01AFD2C0", hash_generated_method = "8147234F295E452C1A833AA9B188EAB4")
    public  NetworkPolicyManager(INetworkPolicyManager service) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("missing INetworkPolicyManager");
        } 
        mService = service;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static NetworkPolicyManager getSystemService(Context context) {
        return (NetworkPolicyManager) context.getSystemService(Context.NETWORK_POLICY_SERVICE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.427 -0400", hash_original_method = "6C9718C45778137F76C2603939413095", hash_generated_method = "CAB9DC37DE9BEA0CC66D1DE07A242AB9")
    public void setNetworkPolicies(NetworkPolicy[] policies) {
        try 
        {
            mService.setNetworkPolicies(policies);
        } 
        catch (RemoteException e)
        { }
        addTaint(policies[0].getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.428 -0400", hash_original_method = "025521C078EE07825554E8E10F94F333", hash_generated_method = "C171D49E1732F3E8FE3AB8FB6878752B")
    public NetworkPolicy[] getNetworkPolicies() {
        NetworkPolicy[] varB4EAC82CA7396A68D541C85D26508E83_426770256 = null; 
        NetworkPolicy[] varB4EAC82CA7396A68D541C85D26508E83_247341331 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_426770256 = mService.getNetworkPolicies();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_247341331 = null;
        } 
        NetworkPolicy[] varA7E53CE21691AB073D9660D615818899_484307121; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_484307121 = varB4EAC82CA7396A68D541C85D26508E83_426770256;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_484307121 = varB4EAC82CA7396A68D541C85D26508E83_247341331;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_484307121.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_484307121;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.429 -0400", hash_original_method = "A06EA8E312C1B7FA5C4AC7FF7B993ED4", hash_generated_method = "6A5841D3BC023CEBF662D4648F87A3AA")
    public void setUidPolicy(int uid, int policy) {
        try 
        {
            mService.setUidPolicy(uid, policy);
        } 
        catch (RemoteException e)
        { }
        addTaint(uid);
        addTaint(policy);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.429 -0400", hash_original_method = "7AF3F24A0466D6FB5C5D518CC41F56AD", hash_generated_method = "3092AACA5B9741CD2DD4DB80698E835D")
    public int getUidPolicy(int uid) {
        try 
        {
            int var2EFE4EBC09097CC24DA539A1E8DCD3CE_1431173586 = (mService.getUidPolicy(uid));
        } 
        catch (RemoteException e)
        { }
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579514837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579514837;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.430 -0400", hash_original_method = "14080C9EBE421CBAA0CC7A85DC8AF1A5", hash_generated_method = "F8F2B172F98C25CEE95E5E1A7E12475E")
    public void registerListener(INetworkPolicyListener listener) {
        
        try 
        {
            mService.registerListener(listener);
        } 
        catch (RemoteException e)
        { }
        addTaint(listener.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.431 -0400", hash_original_method = "35702F276EA8A80B200FDB5306DFD41E", hash_generated_method = "51C036CBD170D6512891CB5207B01BDC")
    public void unregisterListener(INetworkPolicyListener listener) {
        try 
        {
            mService.unregisterListener(listener);
        } 
        catch (RemoteException e)
        { }
        addTaint(listener.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static long computeLastCycleBoundary(long currentTime, NetworkPolicy policy) {
        final Time now = new Time(Time.TIMEZONE_UTC);
        now.set(currentTime);
        final Time cycle = new Time(now);
        cycle.hour = cycle.minute = cycle.second = 0;
        snapToCycleDay(cycle, policy.cycleDay);
        if (Time.compare(cycle, now) >= 0) {
            final Time lastMonth = new Time(now);
            lastMonth.hour = lastMonth.minute = lastMonth.second = 0;
            lastMonth.monthDay = 1;
            lastMonth.month -= 1;
            lastMonth.normalize(true);
            cycle.set(lastMonth);
            snapToCycleDay(cycle, policy.cycleDay);
        }
        return cycle.toMillis(true);
    }

    
    @DSModeled(DSC.SAFE)
    public static long computeNextCycleBoundary(long currentTime, NetworkPolicy policy) {
        final Time now = new Time(Time.TIMEZONE_UTC);
        now.set(currentTime);
        final Time cycle = new Time(now);
        cycle.hour = cycle.minute = cycle.second = 0;
        snapToCycleDay(cycle, policy.cycleDay);
        if (Time.compare(cycle, now) <= 0) {
            final Time nextMonth = new Time(now);
            nextMonth.hour = nextMonth.minute = nextMonth.second = 0;
            nextMonth.monthDay = 1;
            nextMonth.month += 1;
            nextMonth.normalize(true);
            cycle.set(nextMonth);
            snapToCycleDay(cycle, policy.cycleDay);
        }
        return cycle.toMillis(true);
    }

    
    @DSModeled(DSC.SAFE)
    public static void snapToCycleDay(Time time, int cycleDay) {
        if (cycleDay > time.getActualMaximum(MONTH_DAY)) {
            time.month += 1;
            time.monthDay = 1;
            time.second = -1;
        } else {
            time.monthDay = cycleDay;
        }
        time.normalize(true);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isUidValidForPolicy(Context context, int uid) {
        if (uid < android.os.Process.FIRST_APPLICATION_UID
                || uid > android.os.Process.LAST_APPLICATION_UID) {
            return false;
        }
        if (!ALLOW_PLATFORM_APP_POLICY) {
            final PackageManager pm = context.getPackageManager();
            final HashSet<Signature> systemSignature;
            try {
                systemSignature = Sets.newHashSet(
                        pm.getPackageInfo("android", GET_SIGNATURES).signatures);
            } catch (NameNotFoundException e) {
                throw new RuntimeException("problem finding system signature", e);
            }
            try {
                for (String packageName : pm.getPackagesForUid(uid)) {
                    final HashSet<Signature> packageSignature = Sets.newHashSet(
                            pm.getPackageInfo(packageName, GET_SIGNATURES).signatures);
                    if (packageSignature.containsAll(systemSignature)) {
                        return false;
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static void dumpPolicy(PrintWriter fout, int policy) {
        fout.write("[");
        if ((policy & POLICY_REJECT_METERED_BACKGROUND) != 0) {
            fout.write("REJECT_METERED_BACKGROUND");
        }
        fout.write("]");
    }

    
    @DSModeled(DSC.SAFE)
    public static void dumpRules(PrintWriter fout, int rules) {
        fout.write("[");
        if ((rules & RULE_REJECT_METERED) != 0) {
            fout.write("REJECT_METERED");
        }
        fout.write("]");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.432 -0400", hash_original_field = "5F01DF1EC1C676246E73BF9B11F16961", hash_generated_field = "A3BDE024BE500201404672CCC1FA302A")

    public static final int POLICY_NONE = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.432 -0400", hash_original_field = "508212C4E68E17ADFD3CAD6DF2535DF4", hash_generated_field = "1AA83347B7872B2E30E521C1406805D2")

    public static final int POLICY_REJECT_METERED_BACKGROUND = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.432 -0400", hash_original_field = "E10817514635957436609E1FAB8975E1", hash_generated_field = "1275F8E08B26E334FD55FCC008B3124E")

    public static final int RULE_ALLOW_ALL = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.432 -0400", hash_original_field = "E2A0D322ABD6E5AA243E226C00F05628", hash_generated_field = "4356C8F4B6AFE9AC655D4B421139074C")

    public static final int RULE_REJECT_METERED = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.432 -0400", hash_original_field = "75F62DC6D048838CBD4FC2C088798D84", hash_generated_field = "F1EAF378337BFA0CCC51503439EDE9BF")

    private static final boolean ALLOW_PLATFORM_APP_POLICY = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.432 -0400", hash_original_field = "FB2642AC3EF8E7EAC32618880485B684", hash_generated_field = "7320E001215B3C746B3AE684FAAEC5AC")

    public static final String EXTRA_NETWORK_TEMPLATE = "android.net.NETWORK_TEMPLATE";
}

