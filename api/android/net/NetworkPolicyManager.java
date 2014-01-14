package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.930 -0500", hash_original_method = "77147AB7B145CCCACC82E7FF3DD90629", hash_generated_method = "44F2D97812042A9A8E4208CD21B7BEEA")
    
public static NetworkPolicyManager getSystemService(Context context) {
        return (NetworkPolicyManager) context.getSystemService(Context.NETWORK_POLICY_SERVICE);
    }

    /**
     * Compute the last cycle boundary for the given {@link NetworkPolicy}. For
     * example, if cycle day is 20th, and today is June 15th, it will return May
     * 20th. When cycle day doesn't exist in current month, it snaps to the 1st
     * of following month.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.947 -0500", hash_original_method = "CBFD2FDBFDFB4EFA099581BCEB3F98CA", hash_generated_method = "DBBC21F33A5E90AF42C16BFD9569FBE9")
    
public static long computeLastCycleBoundary(long currentTime, NetworkPolicy policy) {
        final Time now = new Time(Time.TIMEZONE_UTC);
        now.set(currentTime);

        // first, find cycle boundary for current month
        final Time cycle = new Time(now);
        cycle.hour = cycle.minute = cycle.second = 0;
        snapToCycleDay(cycle, policy.cycleDay);

        if (Time.compare(cycle, now) >= 0) {
            // cycle boundary is beyond now, use last cycle boundary; start by
            // pushing ourselves squarely into last month.
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

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.949 -0500", hash_original_method = "58D6599320C3CC8F75660ECB99865F1C", hash_generated_method = "D16F8CF340EEB741DE09FCD341171787")
    
public static long computeNextCycleBoundary(long currentTime, NetworkPolicy policy) {
        final Time now = new Time(Time.TIMEZONE_UTC);
        now.set(currentTime);

        // first, find cycle boundary for current month
        final Time cycle = new Time(now);
        cycle.hour = cycle.minute = cycle.second = 0;
        snapToCycleDay(cycle, policy.cycleDay);

        if (Time.compare(cycle, now) <= 0) {
            // cycle boundary is before now, use next cycle boundary; start by
            // pushing ourselves squarely into next month.
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

    /**
     * Snap to the cycle day for the current month given; when cycle day doesn't
     * exist, it snaps to 1st of following month.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.951 -0500", hash_original_method = "AF3AE9DC0CDAD307E486533822C2C506", hash_generated_method = "3C49423376453313A9A85C8A313C60F2")
    
public static void snapToCycleDay(Time time, int cycleDay) {
        if (cycleDay > time.getActualMaximum(MONTH_DAY)) {
            // cycle day isn't valid this month; snap to last second of month
            time.month += 1;
            time.monthDay = 1;
            time.second = -1;
        } else {
            time.monthDay = cycleDay;
        }
        time.normalize(true);
    }

    /**
     * Check if given UID can have a {@link #setUidPolicy(int, int)} defined,
     * usually to protect critical system services.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.954 -0500", hash_original_method = "D97474B2F32E60D03C1CF9EBD8F6BF9F", hash_generated_method = "F8FBFF6C711E7BDB3CC296F0AAA914B0")
    
public static boolean isUidValidForPolicy(Context context, int uid) {
        // first, quick-reject non-applications
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
                // reject apps signed with platform cert
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

        // nothing found above; we can apply policy to UID
        return true;
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.956 -0500", hash_original_method = "64C841EF684DDADDA6A529DC5E8012DB", hash_generated_method = "5500157C22825FA908EB1BE03CBEE898")
    
public static void dumpPolicy(PrintWriter fout, int policy) {
        fout.write("[");
        if ((policy & POLICY_REJECT_METERED_BACKGROUND) != 0) {
            fout.write("REJECT_METERED_BACKGROUND");
        }
        fout.write("]");
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.958 -0500", hash_original_method = "269C05485FD7D1D78F1E3993D65117B4", hash_generated_method = "A455FDDD9D5FDF220961A1555F7AECE9")
    
public static void dumpRules(PrintWriter fout, int rules) {
        fout.write("[");
        if ((rules & RULE_REJECT_METERED) != 0) {
            fout.write("REJECT_METERED");
        }
        fout.write("]");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.911 -0500", hash_original_field = "39749134FD5124806341DF6CECF747FE", hash_generated_field = "A3BDE024BE500201404672CCC1FA302A")

    public static final int POLICY_NONE = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.913 -0500", hash_original_field = "2B7C81618AEAE489F3905D8EA1755A81", hash_generated_field = "1AA83347B7872B2E30E521C1406805D2")

    public static final int POLICY_REJECT_METERED_BACKGROUND = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.916 -0500", hash_original_field = "1D29BCE1FAE097CA15C8D098E86BF362", hash_generated_field = "1275F8E08B26E334FD55FCC008B3124E")

    public static final int RULE_ALLOW_ALL = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.918 -0500", hash_original_field = "1CB10C040C7DA9D7E0B17A93B38567B6", hash_generated_field = "4356C8F4B6AFE9AC655D4B421139074C")

    public static final int RULE_REJECT_METERED = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.921 -0500", hash_original_field = "5776EC97A2E83F4CD8DD81625B380713", hash_generated_field = "F1EAF378337BFA0CCC51503439EDE9BF")

    private static final boolean ALLOW_PLATFORM_APP_POLICY = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.924 -0500", hash_original_field = "97DF16BECF25B69E02C72123DAFA1CF4", hash_generated_field = "7320E001215B3C746B3AE684FAAEC5AC")

    public static final String EXTRA_NETWORK_TEMPLATE = "android.net.NETWORK_TEMPLATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.926 -0500", hash_original_field = "90B1346F33E413533394FD996E7514F3", hash_generated_field = "99D41184207358A72CF865D27CF56B99")

    private INetworkPolicyManager mService;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.928 -0500", hash_original_method = "BE20EED3085F3645396D71EF01AFD2C0", hash_generated_method = "7ADB0661C9CD2D5C8E516B6C1F86E55F")
    
public NetworkPolicyManager(INetworkPolicyManager service) {
        if (service == null) {
            throw new IllegalArgumentException("missing INetworkPolicyManager");
        }
        mService = service;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.493 -0400", hash_original_method = "BE20EED3085F3645396D71EF01AFD2C0", hash_generated_method = "D38E2F3C6BBCF7701EB83058FEF1E0DC")
    public  NetworkPolicyManager() {
    }

    /** {@hide} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.933 -0500", hash_original_method = "6C9718C45778137F76C2603939413095", hash_generated_method = "19F3AF4D19ABDB345C0834A328796127")
    
public void setNetworkPolicies(NetworkPolicy[] policies) {
        try {
            mService.setNetworkPolicies(policies);
        } catch (RemoteException e) {
        }
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.935 -0500", hash_original_method = "025521C078EE07825554E8E10F94F333", hash_generated_method = "A44435FCB6185608A5F722FE4A1B05ED")
    
public NetworkPolicy[] getNetworkPolicies() {
        try {
            return mService.getNetworkPolicies();
        } catch (RemoteException e) {
            return null;
        }
    }

    /**
     * Set policy flags for specific UID.
     *
     * @param policy {@link #POLICY_NONE} or combination of flags like
     *            {@link #POLICY_REJECT_METERED_BACKGROUND}.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.937 -0500", hash_original_method = "A06EA8E312C1B7FA5C4AC7FF7B993ED4", hash_generated_method = "3F0CBF10B537FF703B9F9E71A619BCFB")
    
public void setUidPolicy(int uid, int policy) {
        try {
            mService.setUidPolicy(uid, policy);
        } catch (RemoteException e) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.939 -0500", hash_original_method = "7AF3F24A0466D6FB5C5D518CC41F56AD", hash_generated_method = "F6E15D18BE3FD28ACAC69E0BB3285AFE")
    
public int getUidPolicy(int uid) {
        try {
            return mService.getUidPolicy(uid);
        } catch (RemoteException e) {
            return POLICY_NONE;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.941 -0500", hash_original_method = "14080C9EBE421CBAA0CC7A85DC8AF1A5", hash_generated_method = "B9E7E4C917D11A5741B5E8D6A0CEB6D9")
    
public void registerListener(INetworkPolicyListener listener) {
        try {
            mService.registerListener(listener);
        } catch (RemoteException e) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:20.944 -0500", hash_original_method = "35702F276EA8A80B200FDB5306DFD41E", hash_generated_method = "9763E4A6F58B8D67219B80A0FB9039C8")
    
public void unregisterListener(INetworkPolicyListener listener) {
        try {
            mService.unregisterListener(listener);
        } catch (RemoteException e) {
        }
    }
}

