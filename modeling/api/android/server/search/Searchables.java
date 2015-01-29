/*
 * Copyright (C) 2009 The Android Open Source Project
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
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * This class maintains the information about all searchable activities.
 */
public class Searchables {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.584 -0400", hash_original_field = "A4C27AE69C6BA44C6EA956DAF68BEC63", hash_generated_field = "8F50C782791B023E7B600BB6A8E6CC9B")

    private static final String LOG_TAG = "Searchables";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.586 -0400", hash_original_field = "C5E3DF0222AC5D17E252D4F9F395AFF8", hash_generated_field = "8DB2EFD96704F13F9FFCFF6BA531F17F")

    // TODO how should these be documented for the developer, in a more structured way than
    // the current long wordy javadoc in SearchManager.java ?
    private static final String MD_LABEL_DEFAULT_SEARCHABLE = "android.app.default_searchable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.588 -0400", hash_original_field = "0720EF2C5940859D44F14EDE1BA0355D", hash_generated_field = "1F308C91F169B10498BAE1D2DC6970B6")

    private static final String MD_SEARCHABLE_SYSTEM_SEARCH = "*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.599 -0400", hash_original_field = "1E5D0BEEE3311EB0C6C6C1AC5DD96EEF", hash_generated_field = "89FEC8B05FFD18F66084ECEBC2E1833F")

    public static String GOOGLE_SEARCH_COMPONENT_NAME =
            "com.android.googlesearch/.GoogleSearch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.601 -0400", hash_original_field = "F2E6E2E595CC0C27AF569945F1455433", hash_generated_field = "205C7BBEFDC7183EB111D867987F7795")

    public static String ENHANCED_GOOGLE_SEARCH_COMPONENT_NAME =
            "com.google.android.providers.enhancedgooglesearch/.Launcher";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.618 -0400", hash_original_field = "7299A541AAC0FB2C2EB20A22B20454F5", hash_generated_field = "2A4DEC6F0C5C8A2103C2D59692BDE837")

    private static final Comparator<ResolveInfo> GLOBAL_SEARCH_RANKER =
            new Comparator<ResolveInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 13:07:03.655 -0400", hash_original_method = "26D20733A8DE4D481F25CE3E94815CA5", hash_generated_method = "C332F7794F47016C7764BFB8553B1F50")
        
@Override
        public int compare(ResolveInfo lhs, ResolveInfo rhs) {
            if (lhs == rhs) {
                return 0;
            }
            boolean lhsSystem = isSystemApp(lhs);
            boolean rhsSystem = isSystemApp(rhs);

            if (lhsSystem && !rhsSystem) {
                return -1;
            } else if (rhsSystem && !lhsSystem) {
                return 1;
            } else {
                // Either both system engines, or both non system
                // engines.
                //
                // Note, this isn't a typo. Higher priority numbers imply
                // higher priority, but are "lower" in the sort order.
                return rhs.priority - lhs.priority;
            }
        }
    };

    /**
     * @return true iff. the resolve info corresponds to a system application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.619 -0400", hash_original_method = "281C1AFD7151DD693EA2B0E414D222A6", hash_generated_method = "3D3777AC20A846B6E06797E1399AA196")
    
private static final boolean isSystemApp(ResolveInfo res) {
        return (res.activityInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.589 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.591 -0400", hash_original_field = "544398133346FF8E11A46A31117F8507", hash_generated_field = "C1528430A953FA2F034BED242DDCC204")

    private HashMap<ComponentName, SearchableInfo> mSearchablesMap = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.592 -0400", hash_original_field = "D14430D57FCE619074172AE088B102D0", hash_generated_field = "243894196228599EB558AECB3DD9ECD5")

    private ArrayList<SearchableInfo> mSearchablesList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.594 -0400", hash_original_field = "7FE191D32C6741015666C7CDCC0A5055", hash_generated_field = "A3EAFBFD94ED6CBB4E649D4D56B7D9D3")

    private ArrayList<SearchableInfo> mSearchablesInGlobalSearchList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.595 -0400", hash_original_field = "A747F74C6B5761DED1BE312C92DAE57F", hash_generated_field = "4DF9ABB64C8E80A86F1B4C6AAEA1E884")

    // intent.
    private List<ResolveInfo> mGlobalSearchActivities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.596 -0400", hash_original_field = "7CDC6C13EB7126FDBBC75F43145B9BCA", hash_generated_field = "27E9B64C5412735C37E07CCC8060507F")

    private ComponentName mCurrentGlobalSearchActivity = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.598 -0400", hash_original_field = "4278E1514ECA99A28744E50908C3B2B4", hash_generated_field = "F96AC0B677CA162F48A05DBFB14177DA")

    private ComponentName mWebSearchActivity = null;

    /**
     *
     * @param context Context to use for looking up activities etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.602 -0400", hash_original_method = "B9411ADDBC00A0EF842DBD3C66D9E1F5", hash_generated_method = "6AF020B258BC839CE557B616FEA48D24")
    
public Searchables (Context context) {
        mContext = context;
    }

    /**
     * Look up, or construct, based on the activity.
     *
     * The activities fall into three cases, based on meta-data found in
     * the manifest entry:
     * <ol>
     * <li>The activity itself implements search.  This is indicated by the
     * presence of a "android.app.searchable" meta-data attribute.
     * The value is a reference to an XML file containing search information.</li>
     * <li>A related activity implements search.  This is indicated by the
     * presence of a "android.app.default_searchable" meta-data attribute.
     * The value is a string naming the activity implementing search.  In this
     * case the factory will "redirect" and return the searchable data.</li>
     * <li>No searchability data is provided.  We return null here and other
     * code will insert the "default" (e.g. contacts) search.
     *
     * TODO: cache the result in the map, and check the map first.
     * TODO: it might make sense to implement the searchable reference as
     * an application meta-data entry.  This way we don't have to pepper each
     * and every activity.
     * TODO: can we skip the constructor step if it's a non-searchable?
     * TODO: does it make sense to plug the default into a slot here for
     * automatic return?  Probably not, but it's one way to do it.
     *
     * @param activity The name of the current activity, or null if the
     * activity does not define any explicit searchable metadata.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.605 -0400", hash_original_method = "8FD9C7DD76BF412A3FE0863422AA710B", hash_generated_method = "E1707507713BE3B5DEB895B689D209E2")
    
public SearchableInfo getSearchableInfo(ComponentName activity) {
        // Step 1.  Is the result already hashed?  (case 1)
        SearchableInfo result;
        synchronized (this) {
            result = mSearchablesMap.get(activity);
            if (result != null) return result;
        }

        // Step 2.  See if the current activity references a searchable.
        // Note:  Conceptually, this could be a while(true) loop, but there's
        // no point in implementing reference chaining here and risking a loop.
        // References must point directly to searchable activities.

        ActivityInfo ai = null;
        try {
            ai = mContext.getPackageManager().
                       getActivityInfo(activity, PackageManager.GET_META_DATA );
            String refActivityName = null;

            // First look for activity-specific reference
            Bundle md = ai.metaData;
            if (md != null) {
                refActivityName = md.getString(MD_LABEL_DEFAULT_SEARCHABLE);
            }
            // If not found, try for app-wide reference
            if (refActivityName == null) {
                md = ai.applicationInfo.metaData;
                if (md != null) {
                    refActivityName = md.getString(MD_LABEL_DEFAULT_SEARCHABLE);
                }
            }

            // Irrespective of source, if a reference was found, follow it.
            if (refActivityName != null)
            {
                // This value is deprecated, return null
                if (refActivityName.equals(MD_SEARCHABLE_SYSTEM_SEARCH)) {
                    return null;
                }
                String pkg = activity.getPackageName();
                ComponentName referredActivity;
                if (refActivityName.charAt(0) == '.') {
                    referredActivity = new ComponentName(pkg, pkg + refActivityName);
                } else {
                    referredActivity = new ComponentName(pkg, refActivityName);
                }

                // Now try the referred activity, and if found, cache
                // it against the original name so we can skip the check
                synchronized (this) {
                    result = mSearchablesMap.get(referredActivity);
                    if (result != null) {
                        mSearchablesMap.put(activity, result);
                        return result;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            // case 3: no metadata
        }

        // Step 3.  None found. Return null.
        return null;

    }

    /**
     * Builds an entire list (suitable for display) of
     * activities that are searchable, by iterating the entire set of
     * ACTION_SEARCH & ACTION_WEB_SEARCH intents.
     *
     * Also clears the hash of all activities -> searches which will
     * refill as the user clicks "search".
     *
     * This should only be done at startup and again if we know that the
     * list has changed.
     *
     * TODO: every activity that provides a ACTION_SEARCH intent should
     * also provide searchability meta-data.  There are a bunch of checks here
     * that, if data is not found, silently skip to the next activity.  This
     * won't help a developer trying to figure out why their activity isn't
     * showing up in the list, but an exception here is too rough.  I would
     * like to find a better notification mechanism.
     *
     * TODO: sort the list somehow?  UI choice.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.608 -0400", hash_original_method = "65EB69FC29F1EADADCBEB67EAE7AC562", hash_generated_method = "E1D1D12DB1EFFE38BCB85989125300E3")
    
public void buildSearchableList() {
        // These will become the new values at the end of the method
        HashMap<ComponentName, SearchableInfo> newSearchablesMap
                                = new HashMap<ComponentName, SearchableInfo>();
        ArrayList<SearchableInfo> newSearchablesList
                                = new ArrayList<SearchableInfo>();
        ArrayList<SearchableInfo> newSearchablesInGlobalSearchList
                                = new ArrayList<SearchableInfo>();

        final PackageManager pm = mContext.getPackageManager();

        // Use intent resolver to generate list of ACTION_SEARCH & ACTION_WEB_SEARCH receivers.
        List<ResolveInfo> searchList;
        final Intent intent = new Intent(Intent.ACTION_SEARCH);
        searchList = pm.queryIntentActivities(intent, PackageManager.GET_META_DATA);

        List<ResolveInfo> webSearchInfoList;
        final Intent webSearchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
        webSearchInfoList = pm.queryIntentActivities(webSearchIntent, PackageManager.GET_META_DATA);

        // analyze each one, generate a Searchables record, and record
        if (searchList != null || webSearchInfoList != null) {
            int search_count = (searchList == null ? 0 : searchList.size());
            int web_search_count = (webSearchInfoList == null ? 0 : webSearchInfoList.size());
            int count = search_count + web_search_count;
            for (int ii = 0; ii < count; ii++) {
                // for each component, try to find metadata
                ResolveInfo info = (ii < search_count)
                        ? searchList.get(ii)
                        : webSearchInfoList.get(ii - search_count);
                ActivityInfo ai = info.activityInfo;
                // Check first to avoid duplicate entries.
                if (newSearchablesMap.get(new ComponentName(ai.packageName, ai.name)) == null) {
                    SearchableInfo searchable = SearchableInfo.getActivityMetaData(mContext, ai);
                    if (searchable != null) {
                        newSearchablesList.add(searchable);
                        newSearchablesMap.put(searchable.getSearchActivity(), searchable);
                        if (searchable.shouldIncludeInGlobalSearch()) {
                            newSearchablesInGlobalSearchList.add(searchable);
                        }
                    }
                }
            }
        }

        List<ResolveInfo> newGlobalSearchActivities = findGlobalSearchActivities();

        // Find the global search activity
        ComponentName newGlobalSearchActivity = findGlobalSearchActivity(
                newGlobalSearchActivities);

        // Find the web search activity
        ComponentName newWebSearchActivity = findWebSearchActivity(newGlobalSearchActivity);

        // Store a consistent set of new values
        synchronized (this) {
            mSearchablesMap = newSearchablesMap;
            mSearchablesList = newSearchablesList;
            mSearchablesInGlobalSearchList = newSearchablesInGlobalSearchList;
            mGlobalSearchActivities = newGlobalSearchActivities;
            mCurrentGlobalSearchActivity = newGlobalSearchActivity;
            mWebSearchActivity = newWebSearchActivity;
        }
    }
    /**
     * Returns a sorted list of installed search providers as per
     * the following heuristics:
     *
     * (a) System apps are given priority over non system apps.
     * (b) Among system apps and non system apps, the relative ordering
     * is defined by their declared priority.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.610 -0400", hash_original_method = "73B8AD9875B828074FB8FD23336E0644", hash_generated_method = "E233A70058E71C3276865825FB30D958")
    
private List<ResolveInfo> findGlobalSearchActivities() {
        // Step 1 : Query the package manager for a list
        // of activities that can handle the GLOBAL_SEARCH intent.
        Intent intent = new Intent(SearchManager.INTENT_ACTION_GLOBAL_SEARCH);
        PackageManager pm = mContext.getPackageManager();
        List<ResolveInfo> activities =
                pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        if (activities != null && !activities.isEmpty()) {
            // Step 2: Rank matching activities according to our heuristics.
            Collections.sort(activities, GLOBAL_SEARCH_RANKER);
        }

        return activities;
    }

    /**
     * Finds the global search activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.612 -0400", hash_original_method = "B2A2FB2D59D49F2302A18DA7A32E8FAE", hash_generated_method = "4C2C8B4ED69AD1AE231597F16F5C37CA")
    
private ComponentName findGlobalSearchActivity(List<ResolveInfo> installed) {
        // Fetch the global search provider from the system settings,
        // and if it's still installed, return it.
        final String searchProviderSetting = getGlobalSearchProviderSetting();
        if (!TextUtils.isEmpty(searchProviderSetting)) {
            final ComponentName globalSearchComponent = ComponentName.unflattenFromString(
                    searchProviderSetting);
            if (globalSearchComponent != null && isInstalled(globalSearchComponent)) {
                return globalSearchComponent;
            }
        }

        return getDefaultGlobalSearchProvider(installed);
    }

    /**
     * Checks whether the global search provider with a given
     * component name is installed on the system or not. This deals with
     * cases such as the removal of an installed provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.613 -0400", hash_original_method = "03180C88152D7B1BF2E65C6D596D2C44", hash_generated_method = "3310DFD00EBD0DB7DF7EC802984DE9D5")
    
private boolean isInstalled(ComponentName globalSearch) {
        Intent intent = new Intent(SearchManager.INTENT_ACTION_GLOBAL_SEARCH);
        intent.setComponent(globalSearch);

        PackageManager pm = mContext.getPackageManager();
        List<ResolveInfo> activities =
                pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        if (activities != null && !activities.isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * Returns the highest ranked search provider as per the
     * ranking defined in {@link #getGlobalSearchActivities()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.621 -0400", hash_original_method = "7F5B0BA805F8ABFF12199B5429CACFA5", hash_generated_method = "17D56C552BFE50F44E8D7201DB2FC317")
    
private ComponentName getDefaultGlobalSearchProvider(List<ResolveInfo> providerList) {
        if (providerList != null && !providerList.isEmpty()) {
            ActivityInfo ai = providerList.get(0).activityInfo;
            return new ComponentName(ai.packageName, ai.name);
        }

        Log.w(LOG_TAG, "No global search activity found");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.622 -0400", hash_original_method = "0C6BD4B71FE4B3BDD8683A1C705D8E3D", hash_generated_method = "418B8C284AFB785217F7B0DC6E39A2FE")
    
private String getGlobalSearchProviderSetting() {
        return Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.SEARCH_GLOBAL_SEARCH_ACTIVITY);
    }

    /**
     * Finds the web search activity.
     *
     * Only looks in the package of the global search activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.623 -0400", hash_original_method = "20D8B14B6BFC4FB4889A48E862B05983", hash_generated_method = "1E5FB026A49F9A9BED08F52829AB6E2E")
    
private ComponentName findWebSearchActivity(ComponentName globalSearchActivity) {
        if (globalSearchActivity == null) {
            return null;
        }
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.setPackage(globalSearchActivity.getPackageName());
        PackageManager pm = mContext.getPackageManager();
        List<ResolveInfo> activities =
                pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        if (activities != null && !activities.isEmpty()) {
            ActivityInfo ai = activities.get(0).activityInfo;
            // TODO: do some sanity checks here?
            return new ComponentName(ai.packageName, ai.name);
        }
        Log.w(LOG_TAG, "No web search activity found");
        return null;
    }

    /**
     * Returns the list of searchable activities.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.626 -0400", hash_original_method = "B27C8CE4D4E2D97872FB04243976B56B", hash_generated_method = "8E77F7F68B624D5B11E7FACA093B2C68")
    
public synchronized ArrayList<SearchableInfo> getSearchablesList() {
        ArrayList<SearchableInfo> result = new ArrayList<SearchableInfo>(mSearchablesList);
        return result;
    }

    /**
     * Returns a list of the searchable activities that can be included in global search.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.627 -0400", hash_original_method = "CCBDCA9023F3F8F28DA0A439A06B2EC6", hash_generated_method = "E86BD1F8CE7CFD6B049A0CA2AFC82613")
    
public synchronized ArrayList<SearchableInfo> getSearchablesInGlobalSearchList() {
        return new ArrayList<SearchableInfo>(mSearchablesInGlobalSearchList);
    }

    /**
     * Returns a list of activities that handle the global search intent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.629 -0400", hash_original_method = "F194C9B620B9EADA286D7C7E65A247EE", hash_generated_method = "2E9C657BF6564C3C02397013F1F5F42C")
    
public synchronized ArrayList<ResolveInfo> getGlobalSearchActivities() {
        return new ArrayList<ResolveInfo>(mGlobalSearchActivities);
    }

    /**
     * Gets the name of the global search activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.630 -0400", hash_original_method = "D9BB1CA123B20068DC8A30A603BC1044", hash_generated_method = "E2B92228C5D57E738BB5CC05AD5F99F1")
    
public synchronized ComponentName getGlobalSearchActivity() {
        return mCurrentGlobalSearchActivity;
    }

    /**
     * Gets the name of the web search activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:27.631 -0400", hash_original_method = "8C1295754928A17AC46CA2F9026CD8E3", hash_generated_method = "5B56DD1FA57D5C369DFBCF1FADD4AF18")
    
public synchronized ComponentName getWebSearchActivity() {
        return mWebSearchActivity;
    }
}
