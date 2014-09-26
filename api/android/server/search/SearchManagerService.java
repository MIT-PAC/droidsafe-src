/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.server.search;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.android.internal.content.PackageMonitor;

import android.app.ISearchManager;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;

import java.util.List;

/**
 * The search manager service handles the search UI, and maintains a registry of searchable
 * activities.
 */
public class SearchManagerService extends ISearchManager.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.366 -0400", hash_original_field = "8192A9281DF65ABBCBC1050A0BD9DC1D", hash_generated_field = "F3C928A61EB0DE96B0C7A1F978CBC35E")

    private static final String TAG = "SearchManagerService";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.368 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.369 -0400", hash_original_field = "ECA8E9577FB5CC4BDB7AB90394D6B335", hash_generated_field = "36987120E92621D67E8CF00831824257")

    private Searchables mSearchables;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.370 -0400", hash_original_field = "103F5FAAFCA2FDAADAD828024F70C190", hash_generated_field = "97116B63A07BEC0CD27D392293B305CA")

    private ContentObserver mGlobalSearchObserver;

    /**
     * Initializes the Search Manager service in the provided system context.
     * Only one instance of this object should be created!
     *
     * @param context to use for accessing DB, window manager, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.372 -0400", hash_original_method = "550CADED4EF1A579D5D85D9CA296B9C2", hash_generated_method = "8146ACF559DADAB22DC9A8EC08CC5F7E")
    
public SearchManagerService(Context context)  {
        mContext = context;
        mContext.registerReceiver(new BootCompletedReceiver(),
                new IntentFilter(Intent.ACTION_BOOT_COMPLETED));
        mGlobalSearchObserver = new GlobalSearchProviderObserver(
                mContext.getContentResolver());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.374 -0400", hash_original_method = "6E490D8726D2686495CF0572155F762C", hash_generated_method = "A74668524AB5326E89E096BE1E265423")
    
private synchronized Searchables getSearchables() {
        if (mSearchables == null) {
            Log.i(TAG, "Building list of searchable activities");
            new MyPackageMonitor().register(mContext, true);
            mSearchables = new Searchables(mContext);
            mSearchables.buildSearchableList();
        }
        return mSearchables;
    }

    /**
     * Creates the initial searchables list after boot.
     */
    private final class BootCompletedReceiver extends BroadcastReceiver {
        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.379 -0400", hash_original_method = "708609F1C0510A1A79E61DD1A21667D8", hash_generated_method = "A16EDB71F0E618458316D623BFFD46F7")
        
@Override
        public void onReceive(Context context, Intent intent) {
            new Thread() {
                @DSSpec(DSCat.SPEC_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:03.406 -0400", hash_original_method = "A6B285513DBDE31BA65BADB3DAF15E48", hash_generated_method = "A0E2DCDCC284A493779E80D421A9B7EC")
                
@Override
                public void run() {
                    Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                    mContext.unregisterReceiver(BootCompletedReceiver.this);
                    getSearchables();
                }
            }.start();
        }
    }

    /**
     * Refreshes the "searchables" list when packages are added/removed.
     */
    class MyPackageMonitor extends PackageMonitor {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.382 -0400", hash_original_method = "7C32794DFBAFE8631BC7412353A07775", hash_generated_method = "6AEAEC3674E0285D94647CCB93009322")
        
@Override
        public void onSomePackagesChanged() {
            updateSearchables();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.383 -0400", hash_original_method = "8247B52488B5FB442CEF2D9A3305AAF6", hash_generated_method = "D17E022B83A154729483944A4E1ACA93")
        
@Override
        public void onPackageModified(String pkg) {
            updateSearchables();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.384 -0400", hash_original_method = "385CDB28BCFD4EC58FDC069EC3E53045", hash_generated_method = "C5EFFAD1EBD467361F58B802E22AB384")
        
private void updateSearchables() {
            // Update list of searchable activities
            getSearchables().buildSearchableList();
            // Inform all listeners that the list of searchables has been updated.
            Intent intent = new Intent(SearchManager.INTENT_ACTION_SEARCHABLES_CHANGED);
            intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
            mContext.sendBroadcast(intent);
        }
    }

    class GlobalSearchProviderObserver extends ContentObserver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.387 -0400", hash_original_field = "D9EFC53032006A099035E3EBF749F453", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

        private  ContentResolver mResolver;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.389 -0400", hash_original_method = "B88C48C1012EFA48A35A3E0D2B2BD248", hash_generated_method = "DD8338B03A47F8A9AADA299589BC3D16")
        
public GlobalSearchProviderObserver(ContentResolver resolver) {
            super(null);
            mResolver = resolver;
            mResolver.registerContentObserver(
                    Settings.Secure.getUriFor(Settings.Secure.SEARCH_GLOBAL_SEARCH_ACTIVITY),
                    false /* notifyDescendants */,
                    this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.391 -0400", hash_original_method = "ECD23EB12D9C33B2A9A184A6C90F8C93", hash_generated_method = "AF704C6577993FE52AC5CD3266DC5D8A")
        
@Override
        public void onChange(boolean selfChange) {
            getSearchables().buildSearchableList();
            Intent intent = new Intent(SearchManager.INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED);
            intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
            mContext.sendBroadcast(intent);
        }

    }

    //
    // Searchable activities API
    //

    /**
     * Returns the SearchableInfo for a given activity.
     *
     * @param launchActivity The activity from which we're launching this search.
     * @return Returns a SearchableInfo record describing the parameters of the search,
     * or null if no searchable metadata was available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.393 -0400", hash_original_method = "C65C8BA72F184DCE2CF121FF6B47649C", hash_generated_method = "3AAE546A4B95D4D81519D76C0D76E481")
    
public SearchableInfo getSearchableInfo(final ComponentName launchActivity) {
        if (launchActivity == null) {
            Log.e(TAG, "getSearchableInfo(), activity == null");
            return null;
        }
        return getSearchables().getSearchableInfo(launchActivity);
    }

    /**
     * Returns a list of the searchable activities that can be included in global search.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.394 -0400", hash_original_method = "FDB545BEB5CC2DF3DAD97F98F094CF09", hash_generated_method = "A1CE1165977D86D82A52ABD92AF5C34B")
    
public List<SearchableInfo> getSearchablesInGlobalSearch() {
        return getSearchables().getSearchablesInGlobalSearchList();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.396 -0400", hash_original_method = "E6C7C3252283B077286234713C79931F", hash_generated_method = "2EB2C8ABAB3EECC2519349D3993AABAF")
    
public List<ResolveInfo> getGlobalSearchActivities() {
        return getSearchables().getGlobalSearchActivities();
    }

    /**
     * Gets the name of the global search activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.397 -0400", hash_original_method = "E4888072BEB766A8C1E9FDE200848F6C", hash_generated_method = "980EA87CEAABD0DEA8679557E4C07E0A")
    
public ComponentName getGlobalSearchActivity() {
        return getSearchables().getGlobalSearchActivity();
    }

    /**
     * Gets the name of the web search activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.398 -0400", hash_original_method = "CCD1927BE84C848B872D910D542F47A8", hash_generated_method = "3BA8D268B0876E23D4646DCB5E5DD82B")
    
public ComponentName getWebSearchActivity() {
        return getSearchables().getWebSearchActivity();
    }

}
