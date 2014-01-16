package android.support.v4.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;

public class IntentCompat {

    /**
     * Create an intent to launch the main (root) activity of a task.  This
     * is the Intent that is started when the application's is launched from
     * Home.  For anything else that wants to launch an application in the
     * same way, it is important that they use an Intent structured the same
     * way, and can use this function to ensure this is the case.
     *
     * <p>The returned Intent has the given Activity component as its explicit
     * component, {@link Intent#ACTION_MAIN ACTION_MAIN} as its action, and includes the
     * category {@link Intent#CATEGORY_LAUNCHER CATEGORY_LAUNCHER}.  This does <em>not</em> have
     * {@link Intent#FLAG_ACTIVITY_NEW_TASK FLAG_ACTIVITY_NEW_TASK} set,
     * though typically you will want to do that through {@link Intent#addFlags(int) addFlags(int)}
     * on the returned Intent.
     *
     * @param mainActivity The main activity component that this Intent will
     * launch.
     * @return Returns a newly created Intent that can be used to launch the
     * activity as a main application entry.
     *
     * @see Intent#setClass
     * @see Intent#setComponent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.542 -0500", hash_original_method = "528748BF23D0899AD4CB079D5A067295", hash_generated_method = "31F798B67D7EBEBB8FE2A3413DF24E66")
    
public static Intent makeMainActivity(ComponentName mainActivity) {
        return IMPL.makeMainActivity(mainActivity);
    }

    /**
     * Make an Intent for the main activity of an application, without
     * specifying a specific activity to run but giving a selector to find
     * the activity.  This results in a final Intent that is structured
     * the same as when the application is launched from
     * Home.  For anything else that wants to launch an application in the
     * same way, it is important that they use an Intent structured the same
     * way, and can use this function to ensure this is the case.
     *
     * <p>The returned Intent has {@link Intent#ACTION_MAIN} as its action, and includes the
     * category {@link Intent#CATEGORY_LAUNCHER}.  This does <em>not</em> have
     * {@link Intent#FLAG_ACTIVITY_NEW_TASK} set, though typically you will want
     * to do that through {@link Intent#addFlags(int)} on the returned Intent.
     *
     * @param selectorAction The action name of the Intent's selector.
     * @param selectorCategory The name of a category to add to the Intent's
     * selector.
     * @return Returns a newly created Intent that can be used to launch the
     * activity as a main application entry.
     *
     * @see #setSelector(Intent)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.545 -0500", hash_original_method = "CEEFEB0CB342545AEDF5ED8CC15598BE", hash_generated_method = "56492F04E904606AC59AE7540E5AC5C6")
    
public static Intent makeMainSelectorActivity(String selectorAction,
            String selectorCategory) {
        return IMPL.makeMainSelectorActivity(selectorAction, selectorCategory);
    }

    /**
     * Make an Intent that can be used to re-launch an application's task
     * in its base state.  This is like {@link #makeMainActivity(ComponentName)},
     * but also sets the flags {@link Intent#FLAG_ACTIVITY_NEW_TASK} and
     * {@link IntentCompat#FLAG_ACTIVITY_CLEAR_TASK}.
     *
     * @param mainActivity The activity component that is the root of the
     * task; this is the activity that has been published in the application's
     * manifest as the main launcher icon.
     *
     * @return Returns a newly created Intent that can be used to relaunch the
     * activity's task in its root state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.547 -0500", hash_original_method = "2A0A0C4A78FBAF5853F18397F930AD9E", hash_generated_method = "9350EFF4C8AA75AA106969D889D2D052")
    
public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        return IMPL.makeRestartActivityTask(mainActivity);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.520 -0500", hash_original_field = "0E02DC6B9E12C5D7B4BB1726F7A60CD7", hash_generated_field = "983CC0C3417D6E0A1FAC8FCDBFFB9087")

    private static  IntentCompatImpl IMPL;
    
    static class IntentCompatImplBase implements IntentCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.831 -0400", hash_original_method = "6D338D1BF47181449ED1EB8AE28F9864", hash_generated_method = "6D338D1BF47181449ED1EB8AE28F9864")
        public IntentCompatImplBase ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.497 -0500", hash_original_method = "4B98301A7E59A155B150C46D4BE1C0A7", hash_generated_method = "762E7B13AB746A9C1A635A5EFE32DA0F")
        
@Override
        public Intent makeMainActivity(ComponentName componentName) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(componentName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            return intent;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.500 -0500", hash_original_method = "C2ED66B58A361F10BA817EED5E34E61E", hash_generated_method = "EFCA63ED1212FDC11B765F42F7AE1B45")
        
@Override
        public Intent makeMainSelectorActivity(String selectorAction,
                String selectorCategory) {
            // Before api 15 you couldn't set a selector intent.
            // Fall back and just return an intent with the requested action/category,
            // even though it won't be a proper "main" intent.
            Intent intent = new Intent(selectorAction);
            intent.addCategory(selectorCategory);
            return intent;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.503 -0500", hash_original_method = "F82489D0D61AED6A92FA7B650E973F8B", hash_generated_method = "412868DEB2B7318C8CC4DB0D52893C25")
        
@Override
        public Intent makeRestartActivityTask(ComponentName mainActivity) {
            Intent intent = makeMainActivity(mainActivity);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            return intent;
        }
        
    }
    
    static class IntentCompatImplHC extends IntentCompatImplBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.833 -0400", hash_original_method = "771759B32AFF7941C560E51066B77792", hash_generated_method = "771759B32AFF7941C560E51066B77792")
        public IntentCompatImplHC ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.507 -0500", hash_original_method = "7AEF38C337C1A4B268D6BF228A89F2D2", hash_generated_method = "BB3C58AA692CFC57291C1DAB6F1AD969")
        
@Override
        public Intent makeMainActivity(ComponentName componentName) {
            return IntentCompatHoneycomb.makeMainActivity(componentName);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.510 -0500", hash_original_method = "9C5B324D72EEDCECCD1591039BA9002E", hash_generated_method = "0ADAEBBC0F683A3166F5FAB5C45B68FD")
        
@Override
        public Intent makeRestartActivityTask(ComponentName componentName) {
            return IntentCompatHoneycomb.makeRestartActivityTask(componentName);
        }
        
    }
    
    static class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.834 -0400", hash_original_method = "26768481DD7BD2C237C8D66F6E165213", hash_generated_method = "26768481DD7BD2C237C8D66F6E165213")
        public IntentCompatImplIcsMr1 ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.515 -0500", hash_original_method = "273E6CE96758BF678EE6C7070C39071C", hash_generated_method = "EE1C3D1BCB81ABA4D9D7F211C02FC25D")
        
@Override
        public Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
            return IntentCompatIcsMr1.makeMainSelectorActivity(selectorAction, selectorCategory);
        }
        
    }
    
    interface IntentCompatImpl {
        Intent makeMainActivity(ComponentName componentName);
        Intent makeMainSelectorActivity(String selectorAction, String selectorCategory);
        Intent makeRestartActivityTask(ComponentName mainActivity);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.525 -0500", hash_original_field = "B79625E19F4E2F1BD5E45C4B3667954F", hash_generated_field = "9FA64A1EB1F4C37DEEE5D6D1F18DD57D")

    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    static {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 15) {
            IMPL = new IntentCompatImplIcsMr1();
        } else if (version >= 11) {
            IMPL = new IntentCompatImplHC();
        } else {
            IMPL = new IntentCompatImplBase();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.527 -0500", hash_original_field = "D7D623359205B1CA800A25BACAE86819", hash_generated_field = "3E7846193CBF25B93CF188C41A992203")

    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.530 -0500", hash_original_field = "094D2080F87F58C3A626EB3CF998E8F2", hash_generated_field = "9F6BB52BB136081B0B5B704137151D62")

    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.532 -0500", hash_original_field = "12452D95F908A28143BE566A06E08C95", hash_generated_field = "0A835C4E438F2FB3E3F07E556FA3173A")

    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.534 -0500", hash_original_field = "41E48B982CAB9FB2A0F81D1106890277", hash_generated_field = "00DBF73919CCC616A45EAD8387F83366")

    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.537 -0500", hash_original_field = "B1EB038D974B316E32B18AD21CC5EA00", hash_generated_field = "7558FCD0B35D01D87929988F4317BDB9")

    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0x00004000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.540 -0500", hash_original_field = "D6ECC68ECE65692CE732DD9FA6C1FF91", hash_generated_field = "B1F0B26869A519954A6704E71E1CB972")

    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0x00008000;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:28.523 -0500", hash_original_method = "83FA4EBC7BDF0C9600DF4B8A1228BD78", hash_generated_method = "88640CF7E61565B7DF98CA749CEE2E71")
    
private IntentCompat() {
        /* Hide constructor */
    }
}

