package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class ShareCompatICS {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.220 -0400", hash_original_method = "3660F8695EEB98A5E585F179E60ADEF2", hash_generated_method = "3660F8695EEB98A5E585F179E60ADEF2")
    public ShareCompatICS ()
    {
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.220 -0400", hash_original_field = "C557956304C0C74F10FAA1BDDC10CF76", hash_generated_field = "95DACE398CE3A9191D58C77F0410A924")

    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
}

