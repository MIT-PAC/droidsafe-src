package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import static android.content.pm.PackageManager.GET_SIGNATURES;
import static android.text.format.Time.MONTH_DAY;

import java.io.PrintWriter;
import java.util.HashSet;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.text.format.Time;

import com.google.android.collect.Sets;






public class NetworkPolicyManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.493 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "99D41184207358A72CF865D27CF56B99")

    private INetworkPolicyManager mService;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.493 -0400", hash_original_method = "BE20EED3085F3645396D71EF01AFD2C0", hash_generated_method = "D38E2F3C6BBCF7701EB83058FEF1E0DC")
    public  NetworkPolicyManager(INetworkPolicyManager service) {
        if(service == null)        
        {
            IllegalArgumentException varDD4E4A1C469E87CD701596C87D20B2A2_321822331 = new IllegalArgumentException("missing INetworkPolicyManager");
            varDD4E4A1C469E87CD701596C87D20B2A2_321822331.addTaint(taint);
            throw varDD4E4A1C469E87CD701596C87D20B2A2_321822331;
        } //End block
        mService = service;
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new IllegalArgumentException("missing INetworkPolicyManager");
        //}
        //mService = service;
    }

    
    @DSModeled(DSC.BAN)
    public static NetworkPolicyManager getSystemService(Context context) {
        return (NetworkPolicyManager) context.getSystemService(Context.NETWORK_POLICY_SERVICE);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.494 -0400", hash_original_method = "6C9718C45778137F76C2603939413095", hash_generated_method = "DEC24C933533BB9E9D99BEA6719D6B8F")
    public void setNetworkPolicies(NetworkPolicy[] policies) {
        addTaint(policies[0].getTaint());
        try 
        {
            mService.setNetworkPolicies(policies);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setNetworkPolicies(policies);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.494 -0400", hash_original_method = "025521C078EE07825554E8E10F94F333", hash_generated_method = "9313056A3B1B8CAD324B4B39B73E841F")
    public NetworkPolicy[] getNetworkPolicies() {
        try 
        {
NetworkPolicy[] var4F047D404EBF980DA3870796EB824A12_51225970 =             mService.getNetworkPolicies();
            var4F047D404EBF980DA3870796EB824A12_51225970.addTaint(taint);
            return var4F047D404EBF980DA3870796EB824A12_51225970;
        } //End block
        catch (RemoteException e)
        {
NetworkPolicy[] var540C13E9E156B687226421B24F2DF178_877191296 =             null;
            var540C13E9E156B687226421B24F2DF178_877191296.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_877191296;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkPolicies();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.495 -0400", hash_original_method = "A06EA8E312C1B7FA5C4AC7FF7B993ED4", hash_generated_method = "F31C0CED39263F9AD2CCEAAEFEC79384")
    public void setUidPolicy(int uid, int policy) {
        addTaint(policy);
        addTaint(uid);
        try 
        {
            mService.setUidPolicy(uid, policy);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setUidPolicy(uid, policy);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.495 -0400", hash_original_method = "7AF3F24A0466D6FB5C5D518CC41F56AD", hash_generated_method = "613C0453D92E692AEBB980A6819530DA")
    public int getUidPolicy(int uid) {
        addTaint(uid);
        try 
        {
            int var9C634B2AB7B4EA717CAA76618B318108_671241900 = (mService.getUidPolicy(uid));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260642583 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260642583;
        } //End block
        catch (RemoteException e)
        {
            int var951D17BFE6AE91F8E390B7432D760639_813319729 = (POLICY_NONE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577934988 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577934988;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mService.getUidPolicy(uid);
        //} catch (RemoteException e) {
            //return POLICY_NONE;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.495 -0400", hash_original_method = "14080C9EBE421CBAA0CC7A85DC8AF1A5", hash_generated_method = "C24CEFF6E15A1744700711AE690AB1B2")
    public void registerListener(INetworkPolicyListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(listener.getTaint());
        try 
        {
            mService.registerListener(listener);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.registerListener(listener);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.496 -0400", hash_original_method = "35702F276EA8A80B200FDB5306DFD41E", hash_generated_method = "371523183CC19B92A10C034B5B6EDD56")
    public void unregisterListener(INetworkPolicyListener listener) {
        addTaint(listener.getTaint());
        try 
        {
            mService.unregisterListener(listener);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.unregisterListener(listener);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    public static void dumpPolicy(PrintWriter fout, int policy) {
        fout.write("[");
        if ((policy & POLICY_REJECT_METERED_BACKGROUND) != 0) {
            fout.write("REJECT_METERED_BACKGROUND");
        }
        fout.write("]");
    }

    
    @DSModeled(DSC.BAN)
    public static void dumpRules(PrintWriter fout, int rules) {
        fout.write("[");
        if ((rules & RULE_REJECT_METERED) != 0) {
            fout.write("REJECT_METERED");
        }
        fout.write("]");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.498 -0400", hash_original_field = "5F01DF1EC1C676246E73BF9B11F16961", hash_generated_field = "A3BDE024BE500201404672CCC1FA302A")

    public static final int POLICY_NONE = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.498 -0400", hash_original_field = "508212C4E68E17ADFD3CAD6DF2535DF4", hash_generated_field = "1AA83347B7872B2E30E521C1406805D2")

    public static final int POLICY_REJECT_METERED_BACKGROUND = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.498 -0400", hash_original_field = "E10817514635957436609E1FAB8975E1", hash_generated_field = "1275F8E08B26E334FD55FCC008B3124E")

    public static final int RULE_ALLOW_ALL = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.498 -0400", hash_original_field = "E2A0D322ABD6E5AA243E226C00F05628", hash_generated_field = "4356C8F4B6AFE9AC655D4B421139074C")

    public static final int RULE_REJECT_METERED = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.498 -0400", hash_original_field = "75F62DC6D048838CBD4FC2C088798D84", hash_generated_field = "F1EAF378337BFA0CCC51503439EDE9BF")

    private static final boolean ALLOW_PLATFORM_APP_POLICY = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.498 -0400", hash_original_field = "FB2642AC3EF8E7EAC32618880485B684", hash_generated_field = "7320E001215B3C746B3AE684FAAEC5AC")

    public static final String EXTRA_NETWORK_TEMPLATE = "android.net.NETWORK_TEMPLATE";
}

