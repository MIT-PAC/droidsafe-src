package android.support.v4.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class IntentCompat {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.288 -0400", hash_original_method = "83FA4EBC7BDF0C9600DF4B8A1228BD78", hash_generated_method = "16347C92B7A5F44FF250E58B89036E6B")
    private  IntentCompat() {
        // ---------- Original Method ----------
    }

    
        public static Intent makeMainActivity(ComponentName mainActivity) {
        return IMPL.makeMainActivity(mainActivity);
    }

    
        public static Intent makeMainSelectorActivity(String selectorAction,
            String selectorCategory) {
        return IMPL.makeMainSelectorActivity(selectorAction, selectorCategory);
    }

    
        public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        return IMPL.makeRestartActivityTask(mainActivity);
    }

    
    static class IntentCompatImplBase implements IntentCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.289 -0400", hash_original_method = "6D338D1BF47181449ED1EB8AE28F9864", hash_generated_method = "6D338D1BF47181449ED1EB8AE28F9864")
        public IntentCompatImplBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.289 -0400", hash_original_method = "4B98301A7E59A155B150C46D4BE1C0A7", hash_generated_method = "477FB65C0A529EB2CBF8428296FFD00D")
        @Override
        public Intent makeMainActivity(ComponentName componentName) {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1459222229 = null; //Variable for return #1
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(componentName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            varB4EAC82CA7396A68D541C85D26508E83_1459222229 = intent;
            addTaint(componentName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1459222229.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1459222229;
            // ---------- Original Method ----------
            //Intent intent = new Intent(Intent.ACTION_MAIN);
            //intent.setComponent(componentName);
            //intent.addCategory(Intent.CATEGORY_LAUNCHER);
            //return intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.290 -0400", hash_original_method = "C2ED66B58A361F10BA817EED5E34E61E", hash_generated_method = "849F915F243F9DE1307E45B2F965C975")
        @Override
        public Intent makeMainSelectorActivity(String selectorAction,
                String selectorCategory) {
            Intent varB4EAC82CA7396A68D541C85D26508E83_53766305 = null; //Variable for return #1
            Intent intent = new Intent(selectorAction);
            intent.addCategory(selectorCategory);
            varB4EAC82CA7396A68D541C85D26508E83_53766305 = intent;
            addTaint(selectorAction.getTaint());
            addTaint(selectorCategory.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_53766305.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_53766305;
            // ---------- Original Method ----------
            //Intent intent = new Intent(selectorAction);
            //intent.addCategory(selectorCategory);
            //return intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.290 -0400", hash_original_method = "F82489D0D61AED6A92FA7B650E973F8B", hash_generated_method = "00F441C25C248C3DB802431E511DDAEF")
        @Override
        public Intent makeRestartActivityTask(ComponentName mainActivity) {
            Intent varB4EAC82CA7396A68D541C85D26508E83_391633741 = null; //Variable for return #1
            Intent intent = makeMainActivity(mainActivity);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            varB4EAC82CA7396A68D541C85D26508E83_391633741 = intent;
            addTaint(mainActivity.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_391633741.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_391633741;
            // ---------- Original Method ----------
            //Intent intent = makeMainActivity(mainActivity);
            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    //| IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            //return intent;
        }

        
    }


    
    static class IntentCompatImplHC extends IntentCompatImplBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.290 -0400", hash_original_method = "771759B32AFF7941C560E51066B77792", hash_generated_method = "771759B32AFF7941C560E51066B77792")
        public IntentCompatImplHC ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.291 -0400", hash_original_method = "7AEF38C337C1A4B268D6BF228A89F2D2", hash_generated_method = "755695776DDBB1A35BAAC44AAFB3B8F5")
        @Override
        public Intent makeMainActivity(ComponentName componentName) {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1972850138 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1972850138 = IntentCompatHoneycomb.makeMainActivity(componentName);
            addTaint(componentName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1972850138.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1972850138;
            // ---------- Original Method ----------
            //return IntentCompatHoneycomb.makeMainActivity(componentName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.292 -0400", hash_original_method = "9C5B324D72EEDCECCD1591039BA9002E", hash_generated_method = "D7DAB0C59FBAEC14370CFA58AC26E115")
        @Override
        public Intent makeRestartActivityTask(ComponentName componentName) {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1541815130 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1541815130 = IntentCompatHoneycomb.makeRestartActivityTask(componentName);
            addTaint(componentName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1541815130.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1541815130;
            // ---------- Original Method ----------
            //return IntentCompatHoneycomb.makeRestartActivityTask(componentName);
        }

        
    }


    
    static class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.292 -0400", hash_original_method = "26768481DD7BD2C237C8D66F6E165213", hash_generated_method = "26768481DD7BD2C237C8D66F6E165213")
        public IntentCompatImplIcsMr1 ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.292 -0400", hash_original_method = "273E6CE96758BF678EE6C7070C39071C", hash_generated_method = "DBC0730561CBE2370C66609A3BB23714")
        @Override
        public Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
            Intent varB4EAC82CA7396A68D541C85D26508E83_1574541815 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1574541815 = IntentCompatIcsMr1.makeMainSelectorActivity(selectorAction, selectorCategory);
            addTaint(selectorAction.getTaint());
            addTaint(selectorCategory.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1574541815.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1574541815;
            // ---------- Original Method ----------
            //return IntentCompatIcsMr1.makeMainSelectorActivity(selectorAction, selectorCategory);
        }

        
    }


    
    interface IntentCompatImpl {
        Intent makeMainActivity(ComponentName componentName);
        Intent makeMainSelectorActivity(String selectorAction, String selectorCategory);
        Intent makeRestartActivityTask(ComponentName mainActivity);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "983CC0C3417D6E0A1FAC8FCDBFFB9087")

    private static IntentCompatImpl IMPL;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "3FBD18E81715442BDEE658474C5629E5", hash_generated_field = "9FA64A1EB1F4C37DEEE5D6D1F18DD57D")

    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "79BBB6392C89883A34F60A67157B8582", hash_generated_field = "3E7846193CBF25B93CF188C41A992203")

    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "FDA69BBD39712C3E27E462661D93CE75", hash_generated_field = "9F6BB52BB136081B0B5B704137151D62")

    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "5B90A66309396174E4747C13B353BAE4", hash_generated_field = "0A835C4E438F2FB3E3F07E556FA3173A")

    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "EE24B2A5F107CF81BEAC6E72A1F6EBFB", hash_generated_field = "00DBF73919CCC616A45EAD8387F83366")

    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "29E1F22C6F9260071914A0D5EFE7D56D", hash_generated_field = "7558FCD0B35D01D87929988F4317BDB9")

    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.293 -0400", hash_original_field = "7B9632362C9B3566CAC2B7239D8D438A", hash_generated_field = "B1F0B26869A519954A6704E71E1CB972")

    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0x00008000;
}

