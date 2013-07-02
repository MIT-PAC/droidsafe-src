package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.os.Handler;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;

public class NotificationManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.844 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.845 -0400", hash_original_method = "10DBF11C8E724C226D878C7C01FAA245", hash_generated_method = "6289F873941ED50FFDAC103DBA48290D")
      NotificationManager(Context context, Handler handler) {
        mContext = context;
        addTaint(handler.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static public INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService("notification");
        sService = INotificationManager.Stub.asInterface(b);
        return sService;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.846 -0400", hash_original_method = "8A4CA4E7E43847BF1836AE50422D1EC2", hash_generated_method = "50B2FE1186CF8101034F9FCF8FC6A32F")
    public void notify(int id, Notification notification) {
        notify(null, id, notification);
        addTaint(id);
        addTaint(notification.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.847 -0400", hash_original_method = "825D6C1D97F576BD7D887B295C793809", hash_generated_method = "D500007E9D1FBCD71CF484D8CA0B17D6")
    public void notify(String tag, int id, Notification notification) {
        int[] idOut = new int[1];
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        try 
        {
            service.enqueueNotificationWithTag(pkg, tag, id, notification, idOut);
        } 
        catch (RemoteException e)
        { }
        addTaint(tag.getTaint());
        addTaint(id);
        addTaint(notification.getTaint());
        
        
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.847 -0400", hash_original_method = "C3E2CA3977B6A0DFE40EA0B5D969CEEE", hash_generated_method = "E602EE1A45929109937348BE796AF928")
    public void cancel(int id) {
        cancel(null, id);
        addTaint(id);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.848 -0400", hash_original_method = "40D57D78EF425D9AA1571205DDC7CF63", hash_generated_method = "4EC0E3074AA7ADDC8BE8A4EFF12C16BC")
    public void cancel(String tag, int id) {
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        try 
        {
            service.cancelNotificationWithTag(pkg, tag, id);
        } 
        catch (RemoteException e)
        { }
        addTaint(tag.getTaint());
        addTaint(id);
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.849 -0400", hash_original_method = "755B5F96474649FA97E86F2D74D1F0A8", hash_generated_method = "EA6899A922EFF2BFA4C8DC28DE68FB3D")
    public void cancelAll() {
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        try 
        {
            service.cancelAllNotifications(pkg);
        } 
        catch (RemoteException e)
        { }
        
        
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.849 -0400", hash_original_field = "C197B56EB13B668CA4D120F6F963B27C", hash_generated_field = "27F682BF44532AE8AD1AFBABEE87F231")

    private static String TAG = "NotificationManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.849 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.849 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "F81A4B790E53712C35BD5EDD5A7B2761")

    private static INotificationManager sService;
}

