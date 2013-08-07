package android.support.v4.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;





public class NavUtils {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.691 -0400", hash_original_method = "E75D43BE6A1853BDB1330AA34521ED0F", hash_generated_method = "40223732185F53587003CD833DE7D091")
    private  NavUtils() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean shouldUpRecreateTask(Activity sourceActivity, Intent targetIntent) {
        String action = sourceActivity.getIntent().getAction();
        return action != null && !action.equals(Intent.ACTION_MAIN);
    }

    
    public static void navigateUpFromSameTask(Activity sourceActivity) {
        Intent upIntent = getParentActivityIntent(sourceActivity);
        if (upIntent == null) {
            throw new IllegalArgumentException("Activity " +
                    sourceActivity.getClass().getSimpleName() +
                    " does not have a parent activity name specified." +
                    " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " +
                    " element in your manifest?)");
        }
        navigateUpTo(sourceActivity, upIntent);
    }

    
    @DSModeled(DSC.SPEC)
    public static void navigateUpTo(Activity sourceActivity, Intent upIntent) {
        upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        sourceActivity.startActivity(upIntent);
        sourceActivity.finish();
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent getParentActivityIntent(Activity sourceActivity) {
        String parentActivity = getParentActivityName(sourceActivity);
        if (parentActivity == null) return null;
        return new Intent(Intent.ACTION_MAIN).setClassName(sourceActivity, parentActivity);
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent getParentActivityIntent(Context context, Class<?> sourceActivityClass) throws NameNotFoundException {
        String parentActivity = getParentActivityName(context,
                new ComponentName(context, sourceActivityClass));
        if (parentActivity == null) return null;
        return new Intent(Intent.ACTION_MAIN).setClassName(context, parentActivity);
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws NameNotFoundException {
        String parentActivity = getParentActivityName(context, componentName);
        if (parentActivity == null) return null;
        if (parentActivity.charAt(0) == '.') {
            parentActivity = context.getPackageName() + parentActivity;
        }
        return new Intent(Intent.ACTION_MAIN).setClassName(context, parentActivity);
    }

    
    @DSModeled(DSC.SPEC)
    public static String getParentActivityName(Activity sourceActivity) {
        try {
            return getParentActivityName(sourceActivity, sourceActivity.getComponentName());
        } catch (NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    
    public static String getParentActivityName(Context context, ComponentName componentName) throws NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        ActivityInfo info = pm.getActivityInfo(componentName, PackageManager.GET_META_DATA);
        if (info.metaData == null) return null;
        String parentActivity = info.metaData.getString(PARENT_ACTIVITY);
        if (parentActivity == null) return null;
        if (parentActivity.charAt(0) == '.') {
            parentActivity = context.getPackageName() + parentActivity;
        }
        return parentActivity;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.692 -0400", hash_original_field = "0B2F296F20FC0F50F9875C1922FC874A", hash_generated_field = "E417B6C891271FCB16EE938B8A1D32B3")

    private static final String TAG = "NavUtils";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.692 -0400", hash_original_field = "7979D442068287A3411C320AE3F54D54", hash_generated_field = "28AFCA35319A9218F8E9B29ABAC120B0")

    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
}

