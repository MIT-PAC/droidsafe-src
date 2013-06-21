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
    private IThrottleManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.476 -0400", hash_original_method = "A34F832700CA864903AE32FE53CD267E", hash_generated_method = "3F4BC6E2219D8CDC47CEDF2CEA3212F6")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings({"UnusedDeclaration"})
    private ThrottleManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.477 -0400", hash_original_method = "1E8483A92A1408237E2885FBEDD54340", hash_generated_method = "C85426D8034A22A21B74FAB24D76A9BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThrottleManager(IThrottleManager service) {
        dsTaint.addTaint(service.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "ThrottleManager() cannot be constructed with null service");
        } //End block
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new IllegalArgumentException(
                //"ThrottleManager() cannot be constructed with null service");
        //}
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.477 -0400", hash_original_method = "2AA7855A594B5700D93ECFB7D9A7B7C4", hash_generated_method = "5AF9E94BB3734D049BF788B7852A4DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getResetTime(String iface) {
        dsTaint.addTaint(iface);
        try 
        {
            long var204217EC59A9D04F93D6FDBD469F9D59_1817774160 = (mService.getResetTime(iface));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return mService.getResetTime(iface);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.486 -0400", hash_original_method = "71ECD56B8A0A75240BCCEB36337D3BA2", hash_generated_method = "5FB19382E610AF057FB9B60518688E76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getPeriodStartTime(String iface) {
        dsTaint.addTaint(iface);
        try 
        {
            long var41F2168021DDC7A88D402A7B46B6D14A_863687196 = (mService.getPeriodStartTime(iface));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return mService.getPeriodStartTime(iface);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.487 -0400", hash_original_method = "8241A155E8F913EC462AEA4A2F5ED1F8", hash_generated_method = "B8C2C320DCABDB9161EB6F9BEF0EC5F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getByteCount(String iface, int direction, int period, int ago) {
        dsTaint.addTaint(iface);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(period);
        dsTaint.addTaint(ago);
        try 
        {
            long var30378541F1303B54C3A8D606E1FBC18A_811574863 = (mService.getByteCount(iface, direction, period, ago));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return mService.getByteCount(iface, direction, period, ago);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.487 -0400", hash_original_method = "1E5CE1E6E971F0A1DB09E08194D8A23E", hash_generated_method = "EA2EFCF17B41E7BA5A9EC70EEEA31396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCliffThreshold(String iface, int cliff) {
        dsTaint.addTaint(iface);
        dsTaint.addTaint(cliff);
        try 
        {
            long varAB9EEDBAB9E22E2A16A7FBF573F9D420_1389342529 = (mService.getCliffThreshold(iface, cliff));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return mService.getCliffThreshold(iface, cliff);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.487 -0400", hash_original_method = "1E0667CC63B486C17ACE24556BBA89F5", hash_generated_method = "BBEABD86AB02DFA38591F1805D2560B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCliffLevel(String iface, int cliff) {
        dsTaint.addTaint(iface);
        dsTaint.addTaint(cliff);
        try 
        {
            int varCBBABF44689050DB88F0F7777EEC0438_1597266566 = (mService.getCliffLevel(iface, cliff));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.getCliffLevel(iface, cliff);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.488 -0400", hash_original_method = "BE6DD87215E82DDA8E4A2908333DC9D4", hash_generated_method = "091E270D1BA4F368CC25526C5702C10B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHelpUri() {
        try 
        {
            String varD62F9485C0BCA95CE25F24AD19CC4BF2_1151353771 = (mService.getHelpUri());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return mService.getHelpUri();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    public static final String THROTTLE_POLL_ACTION = "android.net.thrott.POLL_ACTION";
    public static final String EXTRA_CYCLE_READ = "cycleRead";
    public static final String EXTRA_CYCLE_WRITE = "cycleWrite";
    public static final String EXTRA_CYCLE_START = "cycleStart";
    public static final String EXTRA_CYCLE_END = "cycleEnd";
    public static final String THROTTLE_ACTION = "android.net.thrott.THROTTLE_ACTION";
    public static final String EXTRA_THROTTLE_LEVEL = "level";
    public static final String POLICY_CHANGED_ACTION = "android.net.thrott.POLICY_CHANGED_ACTION";
    public static final int DIRECTION_TX = 0;
    public static final int DIRECTION_RX = 1;
    public static final int PERIOD_CYCLE  = 0;
    public static final int PERIOD_YEAR   = 1;
    public static final int PERIOD_MONTH  = 2;
    public static final int PERIOD_WEEK   = 3;
    public static final int PERIOD_7DAY   = 4;
    public static final int PERIOD_DAY    = 5;
    public static final int PERIOD_24HOUR = 6;
    public static final int PERIOD_HOUR   = 7;
    public static final int PERIOD_60MIN  = 8;
    public static final int PERIOD_MINUTE = 9;
    public static final int PERIOD_60SEC  = 10;
    public static final int PERIOD_SECOND = 11;
}

