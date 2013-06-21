package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Slog;
import android.view.View;
import com.android.internal.statusbar.IStatusBarService;

public class StatusBarManager {
    private Context mContext;
    private IStatusBarService mService;
    private IBinder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.047 -0400", hash_original_method = "3CFEC728F9006821D55520F81F0C151A", hash_generated_method = "DDB2E5C579F75AEE694965A47E0B5796")
    @DSModeled(DSC.SAFE)
     StatusBarManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.047 -0400", hash_original_method = "1D3FF7F9C7208A1463AE69512DB03B53", hash_generated_method = "838E34166CB3ADD3CF36D45A1F44ED91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized IStatusBarService getService() {
        {
            mService = IStatusBarService.Stub.asInterface(
                    ServiceManager.getService(Context.STATUS_BAR_SERVICE));
        } //End block
        return (IStatusBarService)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mService == null) {
            //mService = IStatusBarService.Stub.asInterface(
                    //ServiceManager.getService(Context.STATUS_BAR_SERVICE));
            //if (mService == null) {
                //Slog.w("StatusBarManager", "warning: no STATUS_BAR_SERVICE");
            //}
        //}
        //return mService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.048 -0400", hash_original_method = "C0418D4EF5E5492E87411EACA6ADF7F3", hash_generated_method = "92985988F7D29D6E5ED2198C3476307B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disable(int what) {
        dsTaint.addTaint(what);
        try 
        {
            IStatusBarService svc;
            svc = getService();
            {
                svc.disable(what, mToken, mContext.getPackageName());
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //final IStatusBarService svc = getService();
            //if (svc != null) {
                //svc.disable(what, mToken, mContext.getPackageName());
            //}
        //} catch (RemoteException ex) {
            //throw new RuntimeException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.048 -0400", hash_original_method = "5BF2BF9E6EAB3A672A6E4C279ED476B8", hash_generated_method = "BDBE56C48898C173826751040E2B7F64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void expand() {
        try 
        {
            IStatusBarService svc;
            svc = getService();
            {
                svc.expand();
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //final IStatusBarService svc = getService();
            //if (svc != null) {
                //svc.expand();
            //}
        //} catch (RemoteException ex) {
            //throw new RuntimeException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.049 -0400", hash_original_method = "E2C83593B12AFE0B35E16B01E1A7A647", hash_generated_method = "6EA1612DDA4F65B03E9350FC5F6F8BB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void collapse() {
        try 
        {
            IStatusBarService svc;
            svc = getService();
            {
                svc.collapse();
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //final IStatusBarService svc = getService();
            //if (svc != null) {
                //svc.collapse();
            //}
        //} catch (RemoteException ex) {
            //throw new RuntimeException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.049 -0400", hash_original_method = "8A330421DEC3E061C169D87595A7D18D", hash_generated_method = "AF6F0C43855986214495E1C98E5147DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(String slot, int iconId, int iconLevel, String contentDescription) {
        dsTaint.addTaint(contentDescription);
        dsTaint.addTaint(iconLevel);
        dsTaint.addTaint(iconId);
        dsTaint.addTaint(slot);
        try 
        {
            IStatusBarService svc;
            svc = getService();
            {
                svc.setIcon(slot, mContext.getPackageName(), iconId, iconLevel,
                    contentDescription);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //final IStatusBarService svc = getService();
            //if (svc != null) {
                //svc.setIcon(slot, mContext.getPackageName(), iconId, iconLevel,
                    //contentDescription);
            //}
        //} catch (RemoteException ex) {
            //throw new RuntimeException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.050 -0400", hash_original_method = "D02D0B03CC45E73478507B52DB06904B", hash_generated_method = "6A9FB29F44224316EBE11BE1F4F9045D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeIcon(String slot) {
        dsTaint.addTaint(slot);
        try 
        {
            IStatusBarService svc;
            svc = getService();
            {
                svc.removeIcon(slot);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //final IStatusBarService svc = getService();
            //if (svc != null) {
                //svc.removeIcon(slot);
            //}
        //} catch (RemoteException ex) {
            //throw new RuntimeException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.050 -0400", hash_original_method = "59E45760864584BE81198BD1AADB01C2", hash_generated_method = "06D219F0D1C25B16113F3769919CD13F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIconVisibility(String slot, boolean visible) {
        dsTaint.addTaint(visible);
        dsTaint.addTaint(slot);
        try 
        {
            IStatusBarService svc;
            svc = getService();
            {
                svc.setIconVisibility(slot, visible);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        //try {
            //final IStatusBarService svc = getService();
            //if (svc != null) {
                //svc.setIconVisibility(slot, visible);
            //}
        //} catch (RemoteException ex) {
            //throw new RuntimeException(ex);
        //}
    }

    
    public static final int DISABLE_EXPAND = View.STATUS_BAR_DISABLE_EXPAND;
    public static final int DISABLE_NOTIFICATION_ICONS = View.STATUS_BAR_DISABLE_NOTIFICATION_ICONS;
    public static final int DISABLE_NOTIFICATION_ALERTS
            = View.STATUS_BAR_DISABLE_NOTIFICATION_ALERTS;
    public static final int DISABLE_NOTIFICATION_TICKER
            = View.STATUS_BAR_DISABLE_NOTIFICATION_TICKER;
    public static final int DISABLE_SYSTEM_INFO = View.STATUS_BAR_DISABLE_SYSTEM_INFO;
    public static final int DISABLE_HOME = View.STATUS_BAR_DISABLE_HOME;
    public static final int DISABLE_RECENT = View.STATUS_BAR_DISABLE_RECENT;
    public static final int DISABLE_BACK = View.STATUS_BAR_DISABLE_BACK;
    public static final int DISABLE_CLOCK = View.STATUS_BAR_DISABLE_CLOCK;
    @Deprecated public static final int DISABLE_NAVIGATION = 
            View.STATUS_BAR_DISABLE_HOME | View.STATUS_BAR_DISABLE_RECENT;
    public static final int DISABLE_NONE = 0x00000000;
    public static final int DISABLE_MASK = DISABLE_EXPAND | DISABLE_NOTIFICATION_ICONS
            | DISABLE_NOTIFICATION_ALERTS | DISABLE_NOTIFICATION_TICKER
            | DISABLE_SYSTEM_INFO | DISABLE_RECENT | DISABLE_HOME | DISABLE_BACK | DISABLE_CLOCK;
}

