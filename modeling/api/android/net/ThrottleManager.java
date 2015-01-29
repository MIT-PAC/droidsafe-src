package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.RemoteException;

public class ThrottleManager {

    //Added by manual modeling
    
    public static ThrottleManager createInstance() {
        return new ThrottleManager();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.183 -0500", hash_original_field = "4BBBB1329BFF74B72F277432E46813D0", hash_generated_field = "6898D21EE81972732398F7476E57A4E5")

    public static final String THROTTLE_POLL_ACTION = "android.net.thrott.POLL_ACTION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.186 -0500", hash_original_field = "B7EB4D2A51F41E5B52B94219B6EB9A1B", hash_generated_field = "C60D73AECC3BBEBC845B460B2C0FC207")

    public static final String EXTRA_CYCLE_READ = "cycleRead";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.188 -0500", hash_original_field = "0F0F7F250F0284FCA8A614DD91843508", hash_generated_field = "614D6C44EC9F28B2D5FB5646A9D9B2A1")

    public static final String EXTRA_CYCLE_WRITE = "cycleWrite";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.190 -0500", hash_original_field = "850CBEC0ABDA9612B39A141CB37EFB82", hash_generated_field = "B0C2C07165B22D87786F95B5CF4A95EC")

    public static final String EXTRA_CYCLE_START = "cycleStart";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.193 -0500", hash_original_field = "A8B9F420F803834A701FA0FF692DDCFB", hash_generated_field = "915B8CD3CA64A3EEA22D5D810E05B311")

    public static final String EXTRA_CYCLE_END = "cycleEnd";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.195 -0500", hash_original_field = "3EF14749C72A3D5FFA99CDDAD8A60767", hash_generated_field = "ED12FBB3FB48078997AB63E809995555")

    public static final String THROTTLE_ACTION = "android.net.thrott.THROTTLE_ACTION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.198 -0500", hash_original_field = "5D11040DC954569783732621C9F743E6", hash_generated_field = "122B5A88AD4F5DA97CF614FC9CB7112B")

    public static final String EXTRA_THROTTLE_LEVEL = "level";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.200 -0500", hash_original_field = "3D04F8D276C36259739C5C5CB39BB8D7", hash_generated_field = "FB3DCC9354DA96058DD89B592250B71F")

    public static final String POLICY_CHANGED_ACTION = "android.net.thrott.POLICY_CHANGED_ACTION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.202 -0500", hash_original_field = "3B17078965A3B41E0AA8AEB11876077A", hash_generated_field = "07E577AB923A1F0E031C2D3766146C02")

    public static final int DIRECTION_TX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.204 -0500", hash_original_field = "FB45C4C2D0A32827639B8C7CC6B19E3A", hash_generated_field = "834CDF39C9CC543B48AE086B421ECA77")

    public static final int DIRECTION_RX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.206 -0500", hash_original_field = "1A435F01276D7C905BE6BD31AAC577DE", hash_generated_field = "87522BCD580B6A5AFD35F6902B2D1E21")

    public static final int PERIOD_CYCLE  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.208 -0500", hash_original_field = "367CBA676664EA516CA72C8292C2C615", hash_generated_field = "E8BFFBAA705E3AF3D0A7C53DEE7C7008")

    public static final int PERIOD_YEAR   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.211 -0500", hash_original_field = "E04CDCD0DDDD9987EB8B8BE51DF8190D", hash_generated_field = "08FFC80FB898CB6A4543FB0922959EFB")

    public static final int PERIOD_MONTH  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.213 -0500", hash_original_field = "E773A33AC13241042242045B80328D7B", hash_generated_field = "32735A8A4863C7888B70468A911092C3")

    public static final int PERIOD_WEEK   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.216 -0500", hash_original_field = "EBBFC3A9ABE5C74E840013A5806D8066", hash_generated_field = "C6E0E63CC773D681BAE66CBD36FD943C")

    public static final int PERIOD_7DAY   = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.218 -0500", hash_original_field = "113D0D24092DEE751E61084B1347999A", hash_generated_field = "7F5C827CE30965E88157F824EED66B89")

    public static final int PERIOD_DAY    = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.220 -0500", hash_original_field = "D33C057DF159F434A030587598EAC494", hash_generated_field = "93FC7C33BAAB08F424FB1D467A0AF63A")

    public static final int PERIOD_24HOUR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.223 -0500", hash_original_field = "49E0B189D9C1A07E51E649F11F4F173A", hash_generated_field = "8564FC078F4F6D5F682451C9CA7511B0")

    public static final int PERIOD_HOUR   = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.225 -0500", hash_original_field = "719A68C2EFFE6628EE2E797EA60215D7", hash_generated_field = "DEB645AC680C218CA74E35EE0F48291C")

    public static final int PERIOD_60MIN  = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.227 -0500", hash_original_field = "6FD8960C450E39C63FD7B9ED97CD3232", hash_generated_field = "F93352F76A6EE829F15E2FF62662F7EC")

    public static final int PERIOD_MINUTE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.230 -0500", hash_original_field = "7EBB86E0DA05AA496E13B9125C0DFAE1", hash_generated_field = "9399D0B1B6AB08F0D2EF7457960FA4E0")

    public static final int PERIOD_60SEC  = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.232 -0500", hash_original_field = "31C34B103F3483F57E85034FD18412A8", hash_generated_field = "8BD9177938B69E4736C243116A5F85CB")

    public static final int PERIOD_SECOND = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.248 -0500", hash_original_field = "144DFAD723DAE5AAE3DBC8C584C31AD6", hash_generated_field = "6BB94C28B991564A2654192146B5BDD6")

    private IThrottleManager mService;

    /**
     * Don't allow use of default constructor.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.250 -0500", hash_original_method = "A34F832700CA864903AE32FE53CD267E", hash_generated_method = "1EC501785D26517D9A94FD011D80C280")
    
@SuppressWarnings({"UnusedDeclaration"})
    private ThrottleManager() {
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.252 -0500", hash_original_method = "1E8483A92A1408237E2885FBEDD54340", hash_generated_method = "E20C79BB0F36B70C00019A4019AD4563")
    
public ThrottleManager(IThrottleManager service) {
        if (service == null) {
            throw new IllegalArgumentException(
                "ThrottleManager() cannot be constructed with null service");
        }
        mService = service;
    }

    /**
     * returns a long of the ms from the epoch to the time the current cycle ends for the
     * named interface
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.234 -0500", hash_original_method = "2AA7855A594B5700D93ECFB7D9A7B7C4", hash_generated_method = "00AAF153CAD6F43142CCD48B660EE6E1")
    
public long getResetTime(String iface) {
        try {
            return mService.getResetTime(iface);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * returns a long of the ms from the epoch to the time the current cycle started for the
     * named interface
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.236 -0500", hash_original_method = "71ECD56B8A0A75240BCCEB36337D3BA2", hash_generated_method = "27004AEAC6536CCC806B5A1DD6876C00")
    
public long getPeriodStartTime(String iface) {
        try {
            return mService.getPeriodStartTime(iface);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * returns a long of the byte count either read or written on the named interface
     * for the period described.  Direction is either DIRECTION_RX or DIRECTION_TX and
     * period may only be PERIOD_CYCLE for the current cycle (other periods may be supported
     * in the future).  Ago indicates the number of periods in the past to lookup - 0 means
     * the current period, 1 is the last one, 2 was two periods ago..
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.238 -0500", hash_original_method = "8241A155E8F913EC462AEA4A2F5ED1F8", hash_generated_method = "9B2499667709BB9044812486E9C40A0B")
    
public long getByteCount(String iface, int direction, int period, int ago) {
        try {
            return mService.getByteCount(iface, direction, period, ago);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * returns the number of bytes read+written after which a particular cliff
     * takes effect on the named iface.  Currently only cliff #1 is supported (1 step)
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.241 -0500", hash_original_method = "1E5CE1E6E971F0A1DB09E08194D8A23E", hash_generated_method = "777A471138E20BADC0B90CD9134D1836")
    
public long getCliffThreshold(String iface, int cliff) {
        try {
            return mService.getCliffThreshold(iface, cliff);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * returns the thottling bandwidth (bps) for a given cliff # on the named iface.
     * only cliff #1 is currently supported.
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.243 -0500", hash_original_method = "1E0667CC63B486C17ACE24556BBA89F5", hash_generated_method = "0E60E67229A17D7C53E20A54366AD866")
    
public int getCliffLevel(String iface, int cliff) {
        try {
            return mService.getCliffLevel(iface, cliff);
        } catch (RemoteException e) {
            return -1;
        }
    }

    /**
     * returns the help URI for throttling
     * {@hide}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.245 -0500", hash_original_method = "BE6DD87215E82DDA8E4A2908333DC9D4", hash_generated_method = "F171CDEF41A927211228DE1BFF74934F")
    
public String getHelpUri() {
        try {
            return mService.getHelpUri();
        } catch (RemoteException e) {
            return null;
        }
    }
}

