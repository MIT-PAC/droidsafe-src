package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private INetworkPolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.119 -0400", hash_original_method = "BE20EED3085F3645396D71EF01AFD2C0", hash_generated_method = "392A7EBD5A98EAF9A28CAD76A9339612")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkPolicyManager(INetworkPolicyManager service) {
        dsTaint.addTaint(service.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("missing INetworkPolicyManager");
        } //End block
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new IllegalArgumentException("missing INetworkPolicyManager");
        //}
        //mService = service;
    }

    
        public static NetworkPolicyManager getSystemService(Context context) {
        return (NetworkPolicyManager) context.getSystemService(Context.NETWORK_POLICY_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.120 -0400", hash_original_method = "6C9718C45778137F76C2603939413095", hash_generated_method = "F49434DFDB360D869976AA5FE0B27F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkPolicies(NetworkPolicy[] policies) {
        dsTaint.addTaint(policies[0].dsTaint);
        try 
        {
            mService.setNetworkPolicies(policies);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setNetworkPolicies(policies);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.121 -0400", hash_original_method = "025521C078EE07825554E8E10F94F333", hash_generated_method = "C97AE0A78CA9565698FB19BE808CAD58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkPolicy[] getNetworkPolicies() {
        try 
        {
            NetworkPolicy[] var2B96B04762E19EC191DCCEB0C1B28F5B_535952419 = (mService.getNetworkPolicies());
        } //End block
        catch (RemoteException e)
        { }
        return (NetworkPolicy[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getNetworkPolicies();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.121 -0400", hash_original_method = "A06EA8E312C1B7FA5C4AC7FF7B993ED4", hash_generated_method = "789A44771EFE029BB48334A385B3E1B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUidPolicy(int uid, int policy) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(policy);
        try 
        {
            mService.setUidPolicy(uid, policy);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setUidPolicy(uid, policy);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.122 -0400", hash_original_method = "7AF3F24A0466D6FB5C5D518CC41F56AD", hash_generated_method = "C724EAA1B0D029D406695898EB98D7AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getUidPolicy(int uid) {
        dsTaint.addTaint(uid);
        try 
        {
            int var2EFE4EBC09097CC24DA539A1E8DCD3CE_2086222448 = (mService.getUidPolicy(uid));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getUidPolicy(uid);
        //} catch (RemoteException e) {
            //return POLICY_NONE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.122 -0400", hash_original_method = "14080C9EBE421CBAA0CC7A85DC8AF1A5", hash_generated_method = "CCEAC2FD2773086C1B746706DCD11095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerListener(INetworkPolicyListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        try 
        {
            mService.registerListener(listener);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.registerListener(listener);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.122 -0400", hash_original_method = "35702F276EA8A80B200FDB5306DFD41E", hash_generated_method = "CCE2F3860E9F0F2AF1390EF0C9AB2C4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterListener(INetworkPolicyListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        try 
        {
            mService.unregisterListener(listener);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.unregisterListener(listener);
        //} catch (RemoteException e) {
        //}
    }

    
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

    
        public static void dumpPolicy(PrintWriter fout, int policy) {
        fout.write("[");
        if ((policy & POLICY_REJECT_METERED_BACKGROUND) != 0) {
            fout.write("REJECT_METERED_BACKGROUND");
        }
        fout.write("]");
    }

    
        public static void dumpRules(PrintWriter fout, int rules) {
        fout.write("[");
        if ((rules & RULE_REJECT_METERED) != 0) {
            fout.write("REJECT_METERED");
        }
        fout.write("]");
    }

    
    public static final int POLICY_NONE = 0x0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 0x1;
    public static final int RULE_ALLOW_ALL = 0x0;
    public static final int RULE_REJECT_METERED = 0x1;
    private static final boolean ALLOW_PLATFORM_APP_POLICY = true;
    public static final String EXTRA_NETWORK_TEMPLATE = "android.net.NETWORK_TEMPLATE";
}

