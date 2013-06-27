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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.274 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.275 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "1E58C5C0CCB7FC88A86AEBA18390C9AC")

    private IStatusBarService mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.275 -0400", hash_original_field = "0483E306D297FF9F10FBB2053BA4F86A", hash_generated_field = "0A3D50E0763C2392A4FD5877627E0D78")

    private IBinder mToken = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.295 -0400", hash_original_method = "3CFEC728F9006821D55520F81F0C151A", hash_generated_method = "AA88790BF74B94A758B0908E6E9AD026")
      StatusBarManager(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.311 -0400", hash_original_method = "1D3FF7F9C7208A1463AE69512DB03B53", hash_generated_method = "2CA23D510F2CE257C817E1F828DF8C60")
    private synchronized IStatusBarService getService() {
        IStatusBarService varB4EAC82CA7396A68D541C85D26508E83_941522464 = null; //Variable for return #1
        {
            mService = IStatusBarService.Stub.asInterface(
                    ServiceManager.getService(Context.STATUS_BAR_SERVICE));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_941522464 = mService;
        varB4EAC82CA7396A68D541C85D26508E83_941522464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_941522464;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.321 -0400", hash_original_method = "C0418D4EF5E5492E87411EACA6ADF7F3", hash_generated_method = "B0A3F92C36B13A3DE535C4F838000F91")
    public void disable(int what) {
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
        addTaint(what);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.341 -0400", hash_original_method = "5BF2BF9E6EAB3A672A6E4C279ED476B8", hash_generated_method = "BDBE56C48898C173826751040E2B7F64")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.354 -0400", hash_original_method = "E2C83593B12AFE0B35E16B01E1A7A647", hash_generated_method = "6EA1612DDA4F65B03E9350FC5F6F8BB2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.359 -0400", hash_original_method = "8A330421DEC3E061C169D87595A7D18D", hash_generated_method = "501B9979881F09D566571CC0D6C58F35")
    public void setIcon(String slot, int iconId, int iconLevel, String contentDescription) {
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
        addTaint(slot.getTaint());
        addTaint(iconId);
        addTaint(iconLevel);
        addTaint(contentDescription.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.393 -0400", hash_original_method = "D02D0B03CC45E73478507B52DB06904B", hash_generated_method = "D7FD1497CB78D1928C3871DBF3C8F0A3")
    public void removeIcon(String slot) {
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
        addTaint(slot.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.404 -0400", hash_original_method = "59E45760864584BE81198BD1AADB01C2", hash_generated_method = "E1D9A72F90B1952A8AC095BE82227C50")
    public void setIconVisibility(String slot, boolean visible) {
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
        addTaint(slot.getTaint());
        addTaint(visible);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.405 -0400", hash_original_field = "FE692455C0A4C131472310E721ED1921", hash_generated_field = "ED6D876020D65A11D924082E2D3D9A2F")

    public static final int DISABLE_EXPAND = View.STATUS_BAR_DISABLE_EXPAND;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.405 -0400", hash_original_field = "6C4C5A7C5D8981FBFA45A24A6448C04E", hash_generated_field = "144723B1FB4111EFB8C8DA494C628BBB")

    public static final int DISABLE_NOTIFICATION_ICONS = View.STATUS_BAR_DISABLE_NOTIFICATION_ICONS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.406 -0400", hash_original_field = "8519783300764D70AC767E82C6CC1F74", hash_generated_field = "3504992CCD371EC28B2EF6A54230C739")

    public static final int DISABLE_NOTIFICATION_ALERTS
            = View.STATUS_BAR_DISABLE_NOTIFICATION_ALERTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.406 -0400", hash_original_field = "6A2D36B205DBBFFDF0E10CB51120DF61", hash_generated_field = "3C9290F2430D36B9DB4CB8030C769A26")

    public static final int DISABLE_NOTIFICATION_TICKER
            = View.STATUS_BAR_DISABLE_NOTIFICATION_TICKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.424 -0400", hash_original_field = "21A6F2DEA271015C68B85081691FC434", hash_generated_field = "E5D3C62775EC9DC2E12532216213C5CD")

    public static final int DISABLE_SYSTEM_INFO = View.STATUS_BAR_DISABLE_SYSTEM_INFO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.425 -0400", hash_original_field = "DC17009FC2CB057DD8624654F5B43FFA", hash_generated_field = "DD595A01A3003108B3BBEA51B10AC24F")

    public static final int DISABLE_HOME = View.STATUS_BAR_DISABLE_HOME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.427 -0400", hash_original_field = "26FAEE4A860B98F864B37AB439ADE7DE", hash_generated_field = "E81C9622136F1FB34126A72995268089")

    public static final int DISABLE_RECENT = View.STATUS_BAR_DISABLE_RECENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.439 -0400", hash_original_field = "2C3A1A468F39B2A09FEE08B079F6E646", hash_generated_field = "531F15D86A214033C16B773122E4FFFF")

    public static final int DISABLE_BACK = View.STATUS_BAR_DISABLE_BACK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.440 -0400", hash_original_field = "C2DBE2B4AC75B79133074199DC7631DC", hash_generated_field = "3DE19478E05865EFCB51C247544C2B18")

    public static final int DISABLE_CLOCK = View.STATUS_BAR_DISABLE_CLOCK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.440 -0400", hash_original_field = "7B4D160DD8D76ED4285E2B92DB68C775", hash_generated_field = "2E3FBA2AC061C8F289A78D50D9952B40")

    @Deprecated
    public static final int DISABLE_NAVIGATION = 
            View.STATUS_BAR_DISABLE_HOME | View.STATUS_BAR_DISABLE_RECENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.441 -0400", hash_original_field = "65F40BB88C9ADE4DACA82F4BF86DC775", hash_generated_field = "F4C5DD292330500DE56B01C9CEE3B21B")

    public static final int DISABLE_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.458 -0400", hash_original_field = "089BE30AE13E86FE76460CED4D5B5E70", hash_generated_field = "E156F5490D81F8761417909C13031904")

    public static final int DISABLE_MASK = DISABLE_EXPAND | DISABLE_NOTIFICATION_ICONS
            | DISABLE_NOTIFICATION_ALERTS | DISABLE_NOTIFICATION_TICKER
            | DISABLE_SYSTEM_INFO | DISABLE_RECENT | DISABLE_HOME | DISABLE_BACK | DISABLE_CLOCK;
}

