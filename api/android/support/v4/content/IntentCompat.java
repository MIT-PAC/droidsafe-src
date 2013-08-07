package android.support.v4.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;



public class IntentCompat {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.828 -0400", hash_original_method = "83FA4EBC7BDF0C9600DF4B8A1228BD78", hash_generated_method = "16347C92B7A5F44FF250E58B89036E6B")
    private  IntentCompat() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent makeMainActivity(ComponentName mainActivity) {
        return IMPL.makeMainActivity(mainActivity);
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent makeMainSelectorActivity(String selectorAction,
            String selectorCategory) {
        return IMPL.makeMainSelectorActivity(selectorAction, selectorCategory);
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        return IMPL.makeRestartActivityTask(mainActivity);
    }

    
    static class IntentCompatImplBase implements IntentCompatImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.831 -0400", hash_original_method = "6D338D1BF47181449ED1EB8AE28F9864", hash_generated_method = "6D338D1BF47181449ED1EB8AE28F9864")
        public IntentCompatImplBase ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.832 -0400", hash_original_method = "4B98301A7E59A155B150C46D4BE1C0A7", hash_generated_method = "3E4AAE1DCC0F1E141B1D68E8877D09EE")
        @Override
        public Intent makeMainActivity(ComponentName componentName) {
            addTaint(componentName.getTaint());
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(componentName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
Intent var095937E5B36214360A2644916BF0E8DF_663335548 =             intent;
            var095937E5B36214360A2644916BF0E8DF_663335548.addTaint(taint);
            return var095937E5B36214360A2644916BF0E8DF_663335548;
            // ---------- Original Method ----------
            //Intent intent = new Intent(Intent.ACTION_MAIN);
            //intent.setComponent(componentName);
            //intent.addCategory(Intent.CATEGORY_LAUNCHER);
            //return intent;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.832 -0400", hash_original_method = "C2ED66B58A361F10BA817EED5E34E61E", hash_generated_method = "3DEFD8E7A5360659D029D4D6FDD5EFE2")
        @Override
        public Intent makeMainSelectorActivity(String selectorAction,
                String selectorCategory) {
            addTaint(selectorCategory.getTaint());
            addTaint(selectorAction.getTaint());
            Intent intent = new Intent(selectorAction);
            intent.addCategory(selectorCategory);
Intent var095937E5B36214360A2644916BF0E8DF_1555284856 =             intent;
            var095937E5B36214360A2644916BF0E8DF_1555284856.addTaint(taint);
            return var095937E5B36214360A2644916BF0E8DF_1555284856;
            // ---------- Original Method ----------
            //Intent intent = new Intent(selectorAction);
            //intent.addCategory(selectorCategory);
            //return intent;
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.833 -0400", hash_original_method = "F82489D0D61AED6A92FA7B650E973F8B", hash_generated_method = "05D2280F3EC5909E406E2D6857AC0A4A")
        @Override
        public Intent makeRestartActivityTask(ComponentName mainActivity) {
            addTaint(mainActivity.getTaint());
            Intent intent = makeMainActivity(mainActivity);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
Intent var095937E5B36214360A2644916BF0E8DF_286079698 =             intent;
            var095937E5B36214360A2644916BF0E8DF_286079698.addTaint(taint);
            return var095937E5B36214360A2644916BF0E8DF_286079698;
            // ---------- Original Method ----------
            //Intent intent = makeMainActivity(mainActivity);
            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    //| IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            //return intent;
        }

        
    }


    
    static class IntentCompatImplHC extends IntentCompatImplBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.833 -0400", hash_original_method = "771759B32AFF7941C560E51066B77792", hash_generated_method = "771759B32AFF7941C560E51066B77792")
        public IntentCompatImplHC ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.834 -0400", hash_original_method = "7AEF38C337C1A4B268D6BF228A89F2D2", hash_generated_method = "97B15510C5BE96712D577CD15A21FFE5")
        @Override
        public Intent makeMainActivity(ComponentName componentName) {
            addTaint(componentName.getTaint());
Intent var794116B7ABB37746D51F28497CB0A71E_91000539 =             IntentCompatHoneycomb.makeMainActivity(componentName);
            var794116B7ABB37746D51F28497CB0A71E_91000539.addTaint(taint);
            return var794116B7ABB37746D51F28497CB0A71E_91000539;
            // ---------- Original Method ----------
            //return IntentCompatHoneycomb.makeMainActivity(componentName);
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.834 -0400", hash_original_method = "9C5B324D72EEDCECCD1591039BA9002E", hash_generated_method = "A43CCFABCB29EDA07E5696521EF0E65D")
        @Override
        public Intent makeRestartActivityTask(ComponentName componentName) {
            addTaint(componentName.getTaint());
Intent var0DF19734A7165BB16E7A28B8E7E316CC_1804808759 =             IntentCompatHoneycomb.makeRestartActivityTask(componentName);
            var0DF19734A7165BB16E7A28B8E7E316CC_1804808759.addTaint(taint);
            return var0DF19734A7165BB16E7A28B8E7E316CC_1804808759;
            // ---------- Original Method ----------
            //return IntentCompatHoneycomb.makeRestartActivityTask(componentName);
        }

        
    }


    
    static class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.834 -0400", hash_original_method = "26768481DD7BD2C237C8D66F6E165213", hash_generated_method = "26768481DD7BD2C237C8D66F6E165213")
        public IntentCompatImplIcsMr1 ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_method = "273E6CE96758BF678EE6C7070C39071C", hash_generated_method = "33B00DCB8BA4E91AECB4139C769933CA")
        @Override
        public Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
            addTaint(selectorCategory.getTaint());
            addTaint(selectorAction.getTaint());
Intent var00B60DE45C0C785AE3844E3463BF8647_1719043814 =             IntentCompatIcsMr1.makeMainSelectorActivity(selectorAction, selectorCategory);
            var00B60DE45C0C785AE3844E3463BF8647_1719043814.addTaint(taint);
            return var00B60DE45C0C785AE3844E3463BF8647_1719043814;
            // ---------- Original Method ----------
            //return IntentCompatIcsMr1.makeMainSelectorActivity(selectorAction, selectorCategory);
        }

        
    }


    
    interface IntentCompatImpl {
        Intent makeMainActivity(ComponentName componentName);
        Intent makeMainSelectorActivity(String selectorAction, String selectorCategory);
        Intent makeRestartActivityTask(ComponentName mainActivity);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "983CC0C3417D6E0A1FAC8FCDBFFB9087")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "3FBD18E81715442BDEE658474C5629E5", hash_generated_field = "9FA64A1EB1F4C37DEEE5D6D1F18DD57D")

    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "79BBB6392C89883A34F60A67157B8582", hash_generated_field = "3E7846193CBF25B93CF188C41A992203")

    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
        "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "FDA69BBD39712C3E27E462661D93CE75", hash_generated_field = "9F6BB52BB136081B0B5B704137151D62")

    public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "5B90A66309396174E4747C13B353BAE4", hash_generated_field = "0A835C4E438F2FB3E3F07E556FA3173A")

    public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "EE24B2A5F107CF81BEAC6E72A1F6EBFB", hash_generated_field = "00DBF73919CCC616A45EAD8387F83366")

    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "29E1F22C6F9260071914A0D5EFE7D56D", hash_generated_field = "7558FCD0B35D01D87929988F4317BDB9")

    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.835 -0400", hash_original_field = "7B9632362C9B3566CAC2B7239D8D438A", hash_generated_field = "B1F0B26869A519954A6704E71E1CB972")

    public static final int FLAG_ACTIVITY_CLEAR_TASK = 0x00008000;
}

