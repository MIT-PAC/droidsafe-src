package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class ShareCompatICS {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.163 -0400", hash_original_method = "3660F8695EEB98A5E585F179E60ADEF2", hash_generated_method = "3660F8695EEB98A5E585F179E60ADEF2")
    public ShareCompatICS ()
    {
        //Synthesized constructor
    }


        public static void configureMenuItem(MenuItem item, Activity callingActivity, Intent intent) {
        ActionProvider itemProvider = item.getActionProvider();
        ShareActionProvider provider = null;
        if (!(itemProvider instanceof ShareActionProvider)) {
            provider = new ShareActionProvider(callingActivity);
        } else {
            provider = (ShareActionProvider) itemProvider;
        }
        provider.setShareHistoryFileName(HISTORY_FILENAME_PREFIX +
                callingActivity.getClass().getName());
        provider.setShareIntent(intent);
        item.setActionProvider(provider);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.164 -0400", hash_original_field = "C557956304C0C74F10FAA1BDDC10CF76", hash_generated_field = "DD396DFA385513809889E97FE41352F5")

    private static String HISTORY_FILENAME_PREFIX = ".sharecompat_";
}

