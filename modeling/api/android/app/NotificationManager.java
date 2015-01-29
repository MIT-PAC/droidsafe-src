package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;

public class NotificationManager {

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.189 -0500", hash_original_method = "8C9794E934F900D55FFF5E23F579E814", hash_generated_method = "F053B00216AF2D6058566E132404B134")
    
static public INotificationManager getService()
    {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService("notification");
        sService = INotificationManager.Stub.asInterface(b);
        return sService;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.182 -0500", hash_original_field = "0ADEB47A6D1D722171F15D4FD8E851A5", hash_generated_field = "27F682BF44532AE8AD1AFBABEE87F231")

    private static String TAG = "NotificationManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.185 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.187 -0500", hash_original_field = "2143D8EEECB82E176C0D26D54E4D19A4", hash_generated_field = "F81A4B790E53712C35BD5EDD5A7B2761")

    private static INotificationManager sService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.205 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.192 -0500", hash_original_method = "10DBF11C8E724C226D878C7C01FAA245", hash_generated_method = "10DBF11C8E724C226D878C7C01FAA245")
    
NotificationManager(Context context, Handler handler)
    {
        mContext = context;
    }
    
    public NotificationManager(Context context) {
        //addTaint(context.getTaint());
        mContext = context;
    }

    /**
     * Post a notification to be shown in the status bar. If a notification with
     * the same id has already been posted by your application and has not yet been canceled, it
     * will be replaced by the updated information.
     *
     * @param id An identifier for this notification unique within your
     *        application.
     * @param notification A {@link Notification} object describing what to show the user. Must not
     *        be null.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.194 -0500", hash_original_method = "8A4CA4E7E43847BF1836AE50422D1EC2", hash_generated_method = "11BB02842F74EFA0B750E0E2DC061F0E")
    
public void notify(int id, Notification notification)
    {
        notify(null, id, notification);
    }

    /**
     * Post a notification to be shown in the status bar. If a notification with
     * the same tag and id has already been posted by your application and has not yet been
     * canceled, it will be replaced by the updated information.
     *
     * @param tag A string identifier for this notification.  May be {@code null}.
     * @param id An identifier for this notification.  The pair (tag, id) must be unique
     *        within your application.
     * @param notification A {@link Notification} object describing what to
     *        show the user. Must not be null.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.196 -0500", hash_original_method = "825D6C1D97F576BD7D887B295C793809", hash_generated_method = "285DCA988B4614C883FFF0F662B28DF3")
    
public void notify(String tag, int id, Notification notification)
    {
        int[] idOut = new int[1];
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        if (localLOGV) Log.v(TAG, pkg + ": notify(" + id + ", " + notification + ")");
        try {
            service.enqueueNotificationWithTag(pkg, tag, id, notification, idOut);
            if (id != idOut[0]) {
                Log.w(TAG, "notify: id corrupted: sent " + id + ", got back " + idOut[0]);
            }
        } catch (RemoteException e) {
        }
    }

    /**
     * Cancel a previously shown notification.  If it's transient, the view
     * will be hidden.  If it's persistent, it will be removed from the status
     * bar.
     */
    @DSComment("Notification can only go to screen")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.198 -0500", hash_original_method = "C3E2CA3977B6A0DFE40EA0B5D969CEEE", hash_generated_method = "90EF31815973B3B19C436849AC0958EC")
    
public void cancel(int id)
    {
        cancel(null, id);
    }

    /**
     * Cancel a previously shown notification.  If it's transient, the view
     * will be hidden.  If it's persistent, it will be removed from the status
     * bar.
     */
    @DSComment("Notification can only go to screen")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.200 -0500", hash_original_method = "40D57D78EF425D9AA1571205DDC7CF63", hash_generated_method = "A0E0DC88E05BABDCC3A25F5F9F730F35")
    
public void cancel(String tag, int id)
    {
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        if (localLOGV) Log.v(TAG, pkg + ": cancel(" + id + ")");
        try {
            service.cancelNotificationWithTag(pkg, tag, id);
        } catch (RemoteException e) {
        }
    }

    /**
     * Cancel all previously shown notifications. See {@link #cancel} for the
     * detailed behavior.
     */
    @DSComment("Notification can only go to screen")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:55.203 -0500", hash_original_method = "755B5F96474649FA97E86F2D74D1F0A8", hash_generated_method = "2717E11980BDDD051D19092201B56ACE")
    
public void cancelAll()
    {
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        if (localLOGV) Log.v(TAG, pkg + ": cancelAll()");
        try {
            service.cancelAllNotifications(pkg);
        } catch (RemoteException e) {
        }
    }
}

