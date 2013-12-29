package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Slog;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.View;

import com.android.internal.statusbar.IStatusBarService;






public class StatusBarManager {


    //Added by manual modeling 
    @DSModeled(DSC.BAN)
    public static StatusBarManager createInstance(Context context){
        return new StatusBarManager(context);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.987 -0500", hash_original_field = "1E7B0AF5EE05CF7F4EA04E219656EAE8", hash_generated_field = "ED6D876020D65A11D924082E2D3D9A2F")


    public static final int DISABLE_EXPAND = View.STATUS_BAR_DISABLE_EXPAND;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.988 -0500", hash_original_field = "F79639D736D9D3D8C0F8D35484355F0A", hash_generated_field = "144723B1FB4111EFB8C8DA494C628BBB")

    public static final int DISABLE_NOTIFICATION_ICONS = View.STATUS_BAR_DISABLE_NOTIFICATION_ICONS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.988 -0500", hash_original_field = "23B926F7AE5317F250EE516011472E76", hash_generated_field = "3504992CCD371EC28B2EF6A54230C739")

    public static final int DISABLE_NOTIFICATION_ALERTS
            = View.STATUS_BAR_DISABLE_NOTIFICATION_ALERTS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.989 -0500", hash_original_field = "19BD56FD33C119D3FC24C26A8C5DC2C3", hash_generated_field = "3C9290F2430D36B9DB4CB8030C769A26")

    public static final int DISABLE_NOTIFICATION_TICKER
            = View.STATUS_BAR_DISABLE_NOTIFICATION_TICKER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.990 -0500", hash_original_field = "5599D450A85731CC56D455AF825C96C0", hash_generated_field = "E5D3C62775EC9DC2E12532216213C5CD")

    public static final int DISABLE_SYSTEM_INFO = View.STATUS_BAR_DISABLE_SYSTEM_INFO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.991 -0500", hash_original_field = "F5A643C2BF6A415FE3EA9F099E629990", hash_generated_field = "DD595A01A3003108B3BBEA51B10AC24F")

    public static final int DISABLE_HOME = View.STATUS_BAR_DISABLE_HOME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.992 -0500", hash_original_field = "DA54A9103A732743043711707C93A714", hash_generated_field = "E81C9622136F1FB34126A72995268089")

    public static final int DISABLE_RECENT = View.STATUS_BAR_DISABLE_RECENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.993 -0500", hash_original_field = "B0A1BDB9ABD1015B7E16833CEA8F65FE", hash_generated_field = "531F15D86A214033C16B773122E4FFFF")

    public static final int DISABLE_BACK = View.STATUS_BAR_DISABLE_BACK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.994 -0500", hash_original_field = "0F741B7C6DFBC22B42D8600CF3553DC5", hash_generated_field = "3DE19478E05865EFCB51C247544C2B18")

    public static final int DISABLE_CLOCK = View.STATUS_BAR_DISABLE_CLOCK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.995 -0500", hash_original_field = "0B5A92B3AF37913AA310B2B857E31137", hash_generated_field = "2E3FBA2AC061C8F289A78D50D9952B40")


    @Deprecated
    public static final int DISABLE_NAVIGATION = 
            View.STATUS_BAR_DISABLE_HOME | View.STATUS_BAR_DISABLE_RECENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.996 -0500", hash_original_field = "3FDD3C38791C7F2E43113D115AEEC83A", hash_generated_field = "F4C5DD292330500DE56B01C9CEE3B21B")


    public static final int DISABLE_NONE = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.996 -0500", hash_original_field = "67121E4C41A38D817A1286C58FF21A60", hash_generated_field = "E156F5490D81F8761417909C13031904")


    public static final int DISABLE_MASK = DISABLE_EXPAND | DISABLE_NOTIFICATION_ICONS
            | DISABLE_NOTIFICATION_ALERTS | DISABLE_NOTIFICATION_TICKER
            | DISABLE_SYSTEM_INFO | DISABLE_RECENT | DISABLE_HOME | DISABLE_BACK | DISABLE_CLOCK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.997 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.998 -0500", hash_original_field = "F8B3788AC50C66F6D1F2CB5AD0C04432", hash_generated_field = "1E58C5C0CCB7FC88A86AEBA18390C9AC")

    private IStatusBarService mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:16.999 -0500", hash_original_field = "0DA9108D2E2A711522F589279D2F355A", hash_generated_field = "0A3D50E0763C2392A4FD5877627E0D78")

    private IBinder mToken = new Binder();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.000 -0500", hash_original_method = "3CFEC728F9006821D55520F81F0C151A", hash_generated_method = "3CFEC728F9006821D55520F81F0C151A")
    StatusBarManager(Context context) {
        mContext = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.001 -0500", hash_original_method = "1D3FF7F9C7208A1463AE69512DB03B53", hash_generated_method = "87DB02937D830238B0360F8AD32E01CB")
    private synchronized IStatusBarService getService() {
        if (mService == null) {
            mService = IStatusBarService.Stub.asInterface(
                    ServiceManager.getService(Context.STATUS_BAR_SERVICE));
            if (mService == null) {
                Slog.w("StatusBarManager", "warning: no STATUS_BAR_SERVICE");
            }
        }
        return mService;
    }

    /**
     * Disable some features in the status bar.  Pass the bitwise-or of the DISABLE_* flags.
     * To re-enable everything, pass {@link #DISABLE_NONE}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.002 -0500", hash_original_method = "C0418D4EF5E5492E87411EACA6ADF7F3", hash_generated_method = "85B53B4916033EBD077D6C2595438B86")
    public void disable(int what) {
        try {
            final IStatusBarService svc = getService();
            if (svc != null) {
                svc.disable(what, mToken, mContext.getPackageName());
            }
        } catch (RemoteException ex) {
            // system process is dead anyway.
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Expand the status bar.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.003 -0500", hash_original_method = "5BF2BF9E6EAB3A672A6E4C279ED476B8", hash_generated_method = "3C20053C0BADAEBF831FEE2F33201756")
    public void expand() {
        try {
            final IStatusBarService svc = getService();
            if (svc != null) {
                svc.expand();
            }
        } catch (RemoteException ex) {
            // system process is dead anyway.
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Collapse the status bar.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.004 -0500", hash_original_method = "E2C83593B12AFE0B35E16B01E1A7A647", hash_generated_method = "5698C90270243D8A16BF15908D9AEEFF")
    public void collapse() {
        try {
            final IStatusBarService svc = getService();
            if (svc != null) {
                svc.collapse();
            }
        } catch (RemoteException ex) {
            // system process is dead anyway.
            throw new RuntimeException(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.005 -0500", hash_original_method = "8A330421DEC3E061C169D87595A7D18D", hash_generated_method = "7D07FBDB98B51F61C0AA6807EBCB495A")
    public void setIcon(String slot, int iconId, int iconLevel, String contentDescription) {
        try {
            final IStatusBarService svc = getService();
            if (svc != null) {
                svc.setIcon(slot, mContext.getPackageName(), iconId, iconLevel,
                    contentDescription);
            }
        } catch (RemoteException ex) {
            // system process is dead anyway.
            throw new RuntimeException(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.006 -0500", hash_original_method = "D02D0B03CC45E73478507B52DB06904B", hash_generated_method = "ADAE172372C21D1690DD9CF8386A49B3")
    public void removeIcon(String slot) {
        try {
            final IStatusBarService svc = getService();
            if (svc != null) {
                svc.removeIcon(slot);
            }
        } catch (RemoteException ex) {
            // system process is dead anyway.
            throw new RuntimeException(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:17.007 -0500", hash_original_method = "59E45760864584BE81198BD1AADB01C2", hash_generated_method = "4CBA87B69B2EC49F2E6F870C831644ED")
    public void setIconVisibility(String slot, boolean visible) {
        try {
            final IStatusBarService svc = getService();
            if (svc != null) {
                svc.setIconVisibility(slot, visible);
            }
        } catch (RemoteException ex) {
            // system process is dead anyway.
            throw new RuntimeException(ex);
        }
    }
}

