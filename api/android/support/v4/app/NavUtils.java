package android.support.v4.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class NavUtils {

    /**
     * Returns true if sourceActivity should recreate the task when navigating 'up'
     * by using targetIntent.
     *
     * <p>If this method returns false the app can trivially call
     * {@link #navigateUpTo(Activity, Intent)} using the same parameters to correctly perform
     * up navigation. If this method returns false, the app should synthesize a new task stack
     * by using {@link TaskStackBuilder} or another similar mechanism to perform up navigation.</p>
     *
     * @param sourceActivity The current activity from which the user is attempting to navigate up
     * @param targetIntent An intent representing the target destination for up navigation
     * @return true if navigating up should recreate a new task stack, false if the same task
     *         should be used for the destination
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.415 -0500", hash_original_method = "9DD950E6545A66E64C68C25E21AEF114", hash_generated_method = "A1DE030C7093ADFB6081A9D537D728DE")
    
public static boolean shouldUpRecreateTask(Activity sourceActivity, Intent targetIntent) {
        String action = sourceActivity.getIntent().getAction();
        return action != null && !action.equals(Intent.ACTION_MAIN);
    }

    /**
     * Convenience method that is equivalent to calling
     * <code>{@link #navigateUpTo(Activity, Intent) navigateUpTo}(sourceActivity,
     * {@link #getParentActivityIntent(Activity) getParentActivityIntent} (sourceActivity))</code>.
     * sourceActivity will be finished by this call.
     *
     * <p><em>Note:</em> This method should only be used when sourceActivity and the corresponding
     * parent are within the same task. If up navigation should cross tasks in some cases, see
     * {@link #shouldUpRecreateTask(Activity, Intent)}.</p>
     *
     * @param sourceActivity The current activity from which the user is attempting to navigate up
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.418 -0500", hash_original_method = "CA98FAED7B046D519D09066602946AD2", hash_generated_method = "7C264CDA5F8697E7AA775B32DE714F84")
    
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

    /**
     * Navigate from sourceActivity to the activity specified by upIntent, finishing sourceActivity
     * in the process. upIntent will have the flag {@link Intent#FLAG_ACTIVITY_CLEAR_TOP} set
     * by this method, along with any others required for proper up navigation as outlined
     * in the Android Design Guide.
     *
     * <p>This method should be used when performing up navigation from within the same task
     * as the destination. If up navigation should cross tasks in some cases, see
     * {@link #shouldUpRecreateTask(Activity, Intent)}.</p>
     *
     * @param sourceActivity The current activity from which the user is attempting to navigate up
     * @param upIntent An intent representing the target destination for up navigation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.420 -0500", hash_original_method = "83D387966084C04AE269F97601437941", hash_generated_method = "1ED4EEA361FD740D10AB1D07600D651B")
    
public static void navigateUpTo(Activity sourceActivity, Intent upIntent) {
        upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        sourceActivity.startActivity(upIntent);
        sourceActivity.finish();
    }

    /**
     * Obtain an {@link Intent} that will launch {@link Intent#ACTION_MAIN} with an explicit
     * target activity specified by sourceActivity's {@link #PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest.
     *
     * @param sourceActivity Activity to fetch a parent intent for
     * @return a new Intent targeting the defined parent activity of sourceActivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.424 -0500", hash_original_method = "F08790C64CD7241E24C17C868EE430F0", hash_generated_method = "52BC7FABF55E99FCC75B96020EDDF046")
    
public static Intent getParentActivityIntent(Activity sourceActivity) {
        String parentActivity = getParentActivityName(sourceActivity);
        if (parentActivity == null) return null;
        return new Intent(Intent.ACTION_MAIN).setClassName(sourceActivity, parentActivity);
    }

    /**
     * Obtain an {@link Intent} that will launch {@link Intent#ACTION_MAIN} with an explicit
     * target activity specified by sourceActivityClass's {@link #PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest.
     *
     * @param context Context for looking up the activity component for sourceActivityClass
     * @param sourceActivityClass {@link java.lang.Class} object for an Activity class
     * @return a new Intent targeting the defined parent activity of sourceActivity
     * @throws NameNotFoundException if the ComponentName for sourceActivityClass is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.426 -0500", hash_original_method = "52C3CE258E86B05948F5527711355C4F", hash_generated_method = "6041BF304E5EC828486BFCBB88989F03")
    
public static Intent getParentActivityIntent(Context context, Class<?> sourceActivityClass)
            throws NameNotFoundException {
        String parentActivity = getParentActivityName(context,
                new ComponentName(context, sourceActivityClass));
        if (parentActivity == null) return null;
        return new Intent(Intent.ACTION_MAIN).setClassName(context, parentActivity);
    }

    /**
     * Obtain an {@link Intent} that will launch {@link Intent#ACTION_MAIN} with an explicit
     * target activity specified by sourceActivityClass's {@link #PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest.
     *
     * @param context Context for looking up the activity component for the source activity
     * @param componentName ComponentName for the source Activity
     * @return a new Intent targeting the defined parent activity of sourceActivity
     * @throws NameNotFoundException if the ComponentName for sourceActivityClass is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.428 -0500", hash_original_method = "8FB8BE110A26F7FD89AC52562F36577B", hash_generated_method = "59EC80D74698B6F5E1E13869ECDB0105")
    
public static Intent getParentActivityIntent(Context context, ComponentName componentName)
            throws NameNotFoundException {
        String parentActivity = getParentActivityName(context, componentName);
        if (parentActivity == null) return null;
        if (parentActivity.charAt(0) == '.') {
            parentActivity = context.getPackageName() + parentActivity;
        }
        return new Intent(Intent.ACTION_MAIN).setClassName(context, parentActivity);
    }

    /**
     * Return the fully qualified class name of sourceActivity's parent activity as specified by
     * a {@link #PARENT_ACTIVITY} &lt;meta-data&gt; element within the activity element in
     * the application's manifest.
     *
     * @param sourceActivity Activity to fetch a parent class name for
     * @return The fully qualified class name of sourceActivity's parent activity or null if
     *         it was not specified
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.431 -0500", hash_original_method = "922476F31426D85F4B2D25305741BC34", hash_generated_method = "4C6D380D72A75E89C92FCE8078B650A3")
    
public static String getParentActivityName(Activity sourceActivity) {
        try {
            return getParentActivityName(sourceActivity, sourceActivity.getComponentName());
        } catch (NameNotFoundException e) {
            // Component name of supplied activity does not exist...?
            throw new IllegalArgumentException(e);
        }
    }
    /**
     * Return the fully qualified class name of a source activity's parent activity as specified by
     * a {@link #PARENT_ACTIVITY} &lt;meta-data&gt; element within the activity element in
     * the application's manifest. The source activity is provided by componentName.
     *
     * @param context Context for looking up the activity component for the source activity
     * @param componentName ComponentName for the source Activity
     * @return The fully qualified class name of sourceActivity's parent activity or null if
     *         it was not specified
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.434 -0500", hash_original_method = "76DADE3956C91CAB284E34A2514FD57C", hash_generated_method = "969B5BE1710647A6176FAFEB11516E6F")
    
public static String getParentActivityName(Context context, ComponentName componentName)
            throws NameNotFoundException {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.410 -0500", hash_original_field = "2B3B53F66B0D832C3C83688F265ED44C", hash_generated_field = "E417B6C891271FCB16EE938B8A1D32B3")

    private static final String TAG = "NavUtils";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.413 -0500", hash_original_field = "323608CCBE6E8FE486946BE33B358388", hash_generated_field = "28AFCA35319A9218F8E9B29ABAC120B0")

    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";

    /** No instances! */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.436 -0500", hash_original_method = "E75D43BE6A1853BDB1330AA34521ED0F", hash_generated_method = "ABB99A4CD397AD199325D202C7A52973")
    
private NavUtils() {
    }
}

