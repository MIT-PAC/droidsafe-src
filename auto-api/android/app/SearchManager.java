package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class SearchManager implements DialogInterface.OnDismissListener, DialogInterface.OnCancelListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.628 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.628 -0400", hash_original_field = "60ECEEB680467214D78F7BB0224875FA", hash_generated_field = "E59E6E4A97DB236DE3DC575FA608E392")

    private String mAssociatedPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.629 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.629 -0400", hash_original_field = "AC90AE050C7031D19687EC42F21BB44F", hash_generated_field = "37AE510189390F5EDCE0C931287B058E")

    OnDismissListener mDismissListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.630 -0400", hash_original_field = "E25E1108E80CE30F71148C7E84BF0500", hash_generated_field = "C21FFD1A2D31B4F8C0343E8367F7F155")

    OnCancelListener mCancelListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.644 -0400", hash_original_field = "07AB93C86DCF2727B3D7686803B97F37", hash_generated_field = "247F9D3B324680CEDDC332FCA6608926")

    private SearchDialog mSearchDialog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.647 -0400", hash_original_method = "A1F4172E8F505D7306645B5F1AC929D8", hash_generated_method = "F05F150BE019641B04039B46F0EE369B")
      SearchManager(Context context, Handler handler) {
        mContext = context;
        mHandler = handler;
        mService = ISearchManager.Stub.asInterface(
                ServiceManager.getService(Context.SEARCH_SERVICE));
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
        //mService = ISearchManager.Stub.asInterface(
                //ServiceManager.getService(Context.SEARCH_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.671 -0400", hash_original_method = "A99B2740D078AE52E51C31205C7D1808", hash_generated_method = "73E690470D69F427AD033F1FD4559E39")
    public void startSearch(String initialQuery,
                            boolean selectInitialQuery,
                            ComponentName launchActivity,
                            Bundle appSearchData,
                            boolean globalSearch) {
        startSearch(initialQuery, selectInitialQuery, launchActivity,
                appSearchData, globalSearch, null);
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(launchActivity.getTaint());
        addTaint(appSearchData.getTaint());
        addTaint(globalSearch);
        // ---------- Original Method ----------
        //startSearch(initialQuery, selectInitialQuery, launchActivity,
                //appSearchData, globalSearch, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.682 -0400", hash_original_method = "DA3F20917B57D7E33A815871BCDB23BC", hash_generated_method = "497D8A3940547C6D0073FC252205D9E9")
    public void startSearch(String initialQuery,
                            boolean selectInitialQuery,
                            ComponentName launchActivity,
                            Bundle appSearchData,
                            boolean globalSearch,
                            Rect sourceBounds) {
        {
            startGlobalSearch(initialQuery, selectInitialQuery, appSearchData, sourceBounds);
        } //End block
        ensureSearchDialog();
        mSearchDialog.show(initialQuery, selectInitialQuery, launchActivity, appSearchData);
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(launchActivity.getTaint());
        addTaint(appSearchData.getTaint());
        addTaint(globalSearch);
        addTaint(sourceBounds.getTaint());
        // ---------- Original Method ----------
        //if (globalSearch) {
            //startGlobalSearch(initialQuery, selectInitialQuery, appSearchData, sourceBounds);
            //return;
        //}
        //ensureSearchDialog();
        //mSearchDialog.show(initialQuery, selectInitialQuery, launchActivity, appSearchData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.702 -0400", hash_original_method = "69AA3000988676CA7D95377F664F088F", hash_generated_method = "F6A09244588EDDD1D04D8EC011310F75")
    private void ensureSearchDialog() {
        {
            mSearchDialog = new SearchDialog(mContext, this);
            mSearchDialog.setOnCancelListener(this);
            mSearchDialog.setOnDismissListener(this);
        } //End block
        // ---------- Original Method ----------
        //if (mSearchDialog == null) {
            //mSearchDialog = new SearchDialog(mContext, this);
            //mSearchDialog.setOnCancelListener(this);
            //mSearchDialog.setOnDismissListener(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.721 -0400", hash_original_method = "665629AEED9E4B619C9A8F98A6E670F8", hash_generated_method = "8E186A963E70E44678BB32A0BF67AE71")
     void startGlobalSearch(String initialQuery, boolean selectInitialQuery,
            Bundle appSearchData, Rect sourceBounds) {
        ComponentName globalSearchActivity;
        globalSearchActivity = getGlobalSearchActivity();
        Intent intent;
        intent = new Intent(INTENT_ACTION_GLOBAL_SEARCH);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(globalSearchActivity);
        {
            appSearchData = new Bundle();
        } //End block
        {
            appSearchData = new Bundle(appSearchData);
        } //End block
        {
            boolean var10A0DC8AF7B837921F2947865537DC8D_1052393938 = (!appSearchData.containsKey("source"));
            {
                appSearchData.putString("source", mContext.getPackageName());
            } //End block
        } //End collapsed parenthetic
        intent.putExtra(APP_DATA, appSearchData);
        {
            boolean varE3CA76AADF92382138D264810F53FC4F_1460570175 = (!TextUtils.isEmpty(initialQuery));
            {
                intent.putExtra(QUERY, initialQuery);
            } //End block
        } //End collapsed parenthetic
        {
            intent.putExtra(EXTRA_SELECT_QUERY, selectInitialQuery);
        } //End block
        intent.setSourceBounds(sourceBounds);
        try 
        {
            Log.d(TAG, "Starting global search: " + intent.toUri(0));
            mContext.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException ex)
        { }
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(appSearchData.getTaint());
        addTaint(sourceBounds.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.736 -0400", hash_original_method = "C1495B155CB6927BC4386A7FC3D8EFF9", hash_generated_method = "4C0E272DD836773201E52434BE03C6B0")
    public List<ResolveInfo> getGlobalSearchActivities() {
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_1986417115 = null; //Variable for return #1
        List<ResolveInfo> varB4EAC82CA7396A68D541C85D26508E83_274527537 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1986417115 = mService.getGlobalSearchActivities();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_274527537 = null;
        } //End block
        List<ResolveInfo> varA7E53CE21691AB073D9660D615818899_595062751; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_595062751 = varB4EAC82CA7396A68D541C85D26508E83_1986417115;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_595062751 = varB4EAC82CA7396A68D541C85D26508E83_274527537;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_595062751.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_595062751;
        // ---------- Original Method ----------
        //try {
            //return mService.getGlobalSearchActivities();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getGlobalSearchActivities() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.755 -0400", hash_original_method = "375B46C6B18E608C61AB732BC7ABBFF0", hash_generated_method = "3A54A6FC40B4AC606F44E09F6F580DD7")
    public ComponentName getGlobalSearchActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_346204690 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_375528893 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_346204690 = mService.getGlobalSearchActivity();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_375528893 = null;
        } //End block
        ComponentName varA7E53CE21691AB073D9660D615818899_1789980703; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1789980703 = varB4EAC82CA7396A68D541C85D26508E83_346204690;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1789980703 = varB4EAC82CA7396A68D541C85D26508E83_375528893;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1789980703.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1789980703;
        // ---------- Original Method ----------
        //try {
            //return mService.getGlobalSearchActivity();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getGlobalSearchActivity() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.769 -0400", hash_original_method = "B76C058C1256501309C0E936D28D0087", hash_generated_method = "749FCE5EC23F6F201AAAD290E3EB4852")
    public ComponentName getWebSearchActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1855332846 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1851162564 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1855332846 = mService.getWebSearchActivity();
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1851162564 = null;
        } //End block
        ComponentName varA7E53CE21691AB073D9660D615818899_2140547066; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2140547066 = varB4EAC82CA7396A68D541C85D26508E83_1855332846;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2140547066 = varB4EAC82CA7396A68D541C85D26508E83_1851162564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2140547066.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2140547066;
        // ---------- Original Method ----------
        //try {
            //return mService.getWebSearchActivity();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getWebSearchActivity() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.780 -0400", hash_original_method = "DFA0F52B0EB2C924C24B76A319C2D2A5", hash_generated_method = "447E9362B1A6513A631262965C7CD3BF")
    public void triggerSearch(String query,
                              ComponentName launchActivity,
                              Bundle appSearchData) {
        {
            boolean var7466BBCFAEAAA91B3F06D691B172825F_118024318 = (!mAssociatedPackage.equals(launchActivity.getPackageName()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invoking app search on a different package " +
                    "not associated with this search manager");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD89BCBA31628E825208427C7DCE18216_1190980112 = (query == null || TextUtils.getTrimmedLength(query) == 0);
        } //End collapsed parenthetic
        startSearch(query, false, launchActivity, appSearchData, false);
        mSearchDialog.launchQuerySearch();
        addTaint(query.getTaint());
        addTaint(launchActivity.getTaint());
        addTaint(appSearchData.getTaint());
        // ---------- Original Method ----------
        //if (!mAssociatedPackage.equals(launchActivity.getPackageName())) {
            //throw new IllegalArgumentException("invoking app search on a different package " +
                    //"not associated with this search manager");
        //}
        //if (query == null || TextUtils.getTrimmedLength(query) == 0) {
            //Log.w(TAG, "triggerSearch called with empty query, ignoring.");
            //return;
        //}
        //startSearch(query, false, launchActivity, appSearchData, false);
        //mSearchDialog.launchQuerySearch();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.788 -0400", hash_original_method = "2F7F67ABA80342A48040CFA5F163FF23", hash_generated_method = "AF18F420EDDF294FE45AD621A014B9D3")
    public void stopSearch() {
        {
            mSearchDialog.cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mSearchDialog != null) {
            //mSearchDialog.cancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.810 -0400", hash_original_method = "DBEBE34FE7AB0A40BB7E886EA7BCCC44", hash_generated_method = "718C02BB7D87E65BB03ACBD3579CA1AA")
    public boolean isVisible() {
        {
            Object var34EE0F15CA6D20FF3CF863C5B2F3C28B_2131523907 = (mSearchDialog.isShowing());
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090582738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090582738;
        // ---------- Original Method ----------
        //return mSearchDialog == null? false : mSearchDialog.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.826 -0400", hash_original_method = "168ADC282E12956DAABD30E8715DF8C4", hash_generated_method = "79E8DA41ECA9F62975CE1CB5E8F87DDC")
    public void setOnDismissListener(final OnDismissListener listener) {
        mDismissListener = listener;
        // ---------- Original Method ----------
        //mDismissListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.830 -0400", hash_original_method = "E54B891234FF1D09C5FE1330F548AE5B", hash_generated_method = "66950EACE6D061F936B065FB53D5C0FB")
    public void setOnCancelListener(OnCancelListener listener) {
        mCancelListener = listener;
        // ---------- Original Method ----------
        //mCancelListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.832 -0400", hash_original_method = "FD32FDBC83426B134794541111A0C683", hash_generated_method = "B76D7D7D67448C545F6D0013959BEB4F")
    @Deprecated
    public void onCancel(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mCancelListener.onCancel();
        } //End block
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //if (mCancelListener != null) {
            //mCancelListener.onCancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.842 -0400", hash_original_method = "832CAC02C422B9B1DA3F12954DC922BF", hash_generated_method = "B28234E04B581E36EBC90EACCA9F1854")
    @Deprecated
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mDismissListener.onDismiss();
        } //End block
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //if (mDismissListener != null) {
            //mDismissListener.onDismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.867 -0400", hash_original_method = "BECD96EDDDF4DA2CCA14D2ABA4ED0EE3", hash_generated_method = "149BD6B60B31A58F8FCD156451C1292F")
    public SearchableInfo getSearchableInfo(ComponentName componentName) {
        SearchableInfo varB4EAC82CA7396A68D541C85D26508E83_760076188 = null; //Variable for return #1
        SearchableInfo varB4EAC82CA7396A68D541C85D26508E83_1118768522 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_760076188 = mService.getSearchableInfo(componentName);
        } //End block
        catch (RemoteException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1118768522 = null;
        } //End block
        addTaint(componentName.getTaint());
        SearchableInfo varA7E53CE21691AB073D9660D615818899_960994517; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_960994517 = varB4EAC82CA7396A68D541C85D26508E83_760076188;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_960994517 = varB4EAC82CA7396A68D541C85D26508E83_1118768522;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_960994517.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_960994517;
        // ---------- Original Method ----------
        //try {
            //return mService.getSearchableInfo(componentName);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getSearchableInfo() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.882 -0400", hash_original_method = "8998A0F3078F1A486029D8083CC723D6", hash_generated_method = "0DCB6D9E6D4C76EC4A7E21C0A0A6A7ED")
    public Cursor getSuggestions(SearchableInfo searchable, String query) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_2086723703 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2086723703 = getSuggestions(searchable, query, -1);
        addTaint(searchable.getTaint());
        addTaint(query.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2086723703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2086723703;
        // ---------- Original Method ----------
        //return getSuggestions(searchable, query, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.903 -0400", hash_original_method = "E15CCFC152F5A7E151DA9EBD5A00EC08", hash_generated_method = "73319A0B3B0D72475DDE3EE4F27FD0DD")
    public Cursor getSuggestions(SearchableInfo searchable, String query, int limit) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_949915888 = null; //Variable for return #1
        Cursor varB4EAC82CA7396A68D541C85D26508E83_568739408 = null; //Variable for return #2
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1122215195 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_949915888 = null;
        } //End block
        String authority;
        authority = searchable.getSuggestAuthority();
        {
            varB4EAC82CA7396A68D541C85D26508E83_568739408 = null;
        } //End block
        Uri.Builder uriBuilder;
        uriBuilder = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(authority)
                .query("")  
                .fragment("");
        String contentPath;
        contentPath = searchable.getSuggestPath();
        {
            uriBuilder.appendEncodedPath(contentPath);
        } //End block
        uriBuilder.appendPath(SearchManager.SUGGEST_URI_PATH_QUERY);
        String selection;
        selection = searchable.getSuggestSelection();
        String[] selArgs;
        selArgs = null;
        {
            selArgs = new String[] { query };
        } //End block
        {
            uriBuilder.appendPath(query);
        } //End block
        {
            uriBuilder.appendQueryParameter(SUGGEST_PARAMETER_LIMIT, String.valueOf(limit));
        } //End block
        Uri uri;
        uri = uriBuilder.build();
        varB4EAC82CA7396A68D541C85D26508E83_1122215195 = mContext.getContentResolver().query(uri, null, selection, selArgs, null);
        addTaint(searchable.getTaint());
        addTaint(query.getTaint());
        addTaint(limit);
        Cursor varA7E53CE21691AB073D9660D615818899_1404343828; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1404343828 = varB4EAC82CA7396A68D541C85D26508E83_949915888;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1404343828 = varB4EAC82CA7396A68D541C85D26508E83_568739408;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1404343828 = varB4EAC82CA7396A68D541C85D26508E83_1122215195;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1404343828.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1404343828;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.928 -0400", hash_original_method = "1D69522720A8D25D6502045F710E48DA", hash_generated_method = "D790339A0A0ADE5E91FA948D652225D7")
    public List<SearchableInfo> getSearchablesInGlobalSearch() {
        List<SearchableInfo> varB4EAC82CA7396A68D541C85D26508E83_1721939579 = null; //Variable for return #1
        List<SearchableInfo> varB4EAC82CA7396A68D541C85D26508E83_917249314 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1721939579 = mService.getSearchablesInGlobalSearch();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_917249314 = null;
        } //End block
        List<SearchableInfo> varA7E53CE21691AB073D9660D615818899_1643584070; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1643584070 = varB4EAC82CA7396A68D541C85D26508E83_1721939579;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1643584070 = varB4EAC82CA7396A68D541C85D26508E83_917249314;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1643584070.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1643584070;
        // ---------- Original Method ----------
        //try {
            //return mService.getSearchablesInGlobalSearch();
        //} catch (RemoteException e) {
            //Log.e(TAG, "getSearchablesInGlobalSearch() failed: " + e);
            //return null;
        //}
    }

    
    public interface OnDismissListener {
        
        public void onDismiss();
    }
    
    public interface OnCancelListener {
        
        public void onCancel();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.928 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.929 -0400", hash_original_field = "610E5BE04BD6BF12D1D6AF8712803397", hash_generated_field = "C3AE63012D607A5600EDC09F0E38608D")

    private static String TAG = "SearchManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.929 -0400", hash_original_field = "4DB0058242872D14B42ECCF60E4BD40C", hash_generated_field = "6A8EF1344374530F0CC83766CC357C7F")

    public final static char MENU_KEY = 's';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.939 -0400", hash_original_field = "139304461A5752B148F70212BC242861", hash_generated_field = "AB402987676139B693A67D1F6E8B08E6")

    public final static int MENU_KEYCODE = KeyEvent.KEYCODE_S;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.940 -0400", hash_original_field = "E9573A331B8428DA480FB44E27613F57", hash_generated_field = "DA2BC7FD5EEE2F8ED75F388D1182DD62")

    public final static String QUERY = "query";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.940 -0400", hash_original_field = "8B7ED0FD58EE8FFE735E988216C17193", hash_generated_field = "0DA85A7F9E196BAFECDE08197B7CBD74")

    public final static String USER_QUERY = "user_query";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.941 -0400", hash_original_field = "5781C6526251EBD8993C7B0D19EAF439", hash_generated_field = "6C10EC3D2AC012F0FC0378D1B845CDB6")

    public final static String APP_DATA = "app_data";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.941 -0400", hash_original_field = "C02A6AA4F10228915535EABFC782DA14", hash_generated_field = "E8BD4BF89D45446680C308150E6C7CA4")

    public final static String SEARCH_MODE = "search_mode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.953 -0400", hash_original_field = "047E644E9580994C2666FAC6CB3FE76D", hash_generated_field = "B3C481B56C06FC02C05BFD045C22E71F")

    public final static String ACTION_KEY = "action_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.954 -0400", hash_original_field = "D1B4DDDB9BC574CE3F6C363000B97249", hash_generated_field = "513619AFFA7FD54880C474CCCFFFB09F")

    public final static String EXTRA_DATA_KEY = "intent_extra_data_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.954 -0400", hash_original_field = "24DBE9D3FA0775ED50601F2FD64D83F5", hash_generated_field = "98D46B678386F431AF9D8507703A6BB0")

    public final static String EXTRA_SELECT_QUERY = "select_query";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.955 -0400", hash_original_field = "EC184C2EC580C6DBC29F7E731A9FF3BA", hash_generated_field = "701CF8BE929057B0B7DC76A4107BF942")

    public final static String EXTRA_NEW_SEARCH = "new_search";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.966 -0400", hash_original_field = "5A8514B21F4E48C95EF8CE26508A2971", hash_generated_field = "38710F744DB0569FE1FAAB0B781F14F7")

    public static final String EXTRA_WEB_SEARCH_PENDINGINTENT = "web_search_pendingintent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.967 -0400", hash_original_field = "432CCFD61A02B14874ACDC1128149C8B", hash_generated_field = "34D86458E5E413670449333BD0B356BE")

    public final static String CURSOR_EXTRA_KEY_IN_PROGRESS = "in_progress";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.967 -0400", hash_original_field = "E25B42B2A375BA6517E7F1EE16722371", hash_generated_field = "A41EE9480DB530F333EA3EEDCC02D88F")

    public final static String ACTION_MSG = "action_msg";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.968 -0400", hash_original_field = "A78D4B79F173F101B81E37247F8552F1", hash_generated_field = "445ECDFF72243EA4D9DDCBB69C6EA19E")

    public final static int FLAG_QUERY_REFINEMENT = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.969 -0400", hash_original_field = "481EB4224DA0CE4AD72CE14AAD5AD626", hash_generated_field = "00A35FE0566FA4ACE21CCC96B7905A5E")

    public final static String SUGGEST_URI_PATH_QUERY = "search_suggest_query";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.983 -0400", hash_original_field = "DD4F04B09C99F529304D8728F78D04F5", hash_generated_field = "0D0FDBC50154DF96510679E37FF6DC8D")

    public final static String SUGGEST_MIME_TYPE =
            "vnd.android.cursor.dir/vnd.android.search.suggest";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.983 -0400", hash_original_field = "271AEA08BE7AC8A848FF20127E64333F", hash_generated_field = "A6E14EEEFFEC02E3E4CCCE4596BEC345")

    public final static String SUGGEST_URI_PATH_SHORTCUT = "search_suggest_shortcut";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.984 -0400", hash_original_field = "97AA7F173D7B998D267A96ABEB260276", hash_generated_field = "0BCD9772E06E18112651FC1C046153A7")

    public final static String SHORTCUT_MIME_TYPE =
            "vnd.android.cursor.item/vnd.android.search.suggest";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.984 -0400", hash_original_field = "E6DC4ACB7F68C89EDD5E817767AE8C63", hash_generated_field = "AEC68FB0FC60526D59B2FC65C0B0001A")

    public final static String SUGGEST_COLUMN_FORMAT = "suggest_format";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.994 -0400", hash_original_field = "977C854CA31AF27334632F10FE9DDCCB", hash_generated_field = "659CB0D36B5570117518FBA7DC237393")

    public final static String SUGGEST_COLUMN_TEXT_1 = "suggest_text_1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.995 -0400", hash_original_field = "A43268616ABC59D7A59377AAE912EF87", hash_generated_field = "9975BE3D7D195A4B03287638D8163C43")

    public final static String SUGGEST_COLUMN_TEXT_2 = "suggest_text_2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.995 -0400", hash_original_field = "0E6C801AAD82AE9832FEDDB0BC7E34FB", hash_generated_field = "E9420A73BA6409538B7B842CCE47C95C")

    public final static String SUGGEST_COLUMN_TEXT_2_URL = "suggest_text_2_url";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.996 -0400", hash_original_field = "0C91E5981ACE4AD55EB76699CDB8EFDD", hash_generated_field = "C9F1D1B59C31CC4CEBE55A88FB67FE47")

    public final static String SUGGEST_COLUMN_ICON_1 = "suggest_icon_1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.997 -0400", hash_original_field = "20B55448CE92423B7844CEB1B8D46742", hash_generated_field = "2508AA2CC6815F08FDE48C6DB316521B")

    public final static String SUGGEST_COLUMN_ICON_2 = "suggest_icon_2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.014 -0400", hash_original_field = "930F82424F512383855CD57671DCBE5B", hash_generated_field = "ABC428E73F300198BAFB5CA25EDD54D5")

    public final static String SUGGEST_COLUMN_INTENT_ACTION = "suggest_intent_action";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.015 -0400", hash_original_field = "80CF43E44E8DAF9CEDBFBEE50FDFF0F9", hash_generated_field = "27CA1EA72103B7D283C75B90C686978F")

    public final static String SUGGEST_COLUMN_INTENT_DATA = "suggest_intent_data";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.015 -0400", hash_original_field = "497930899A6BB131EE897BEB3E375336", hash_generated_field = "C929C796235C8EF386B4610F30D9924A")

    public final static String SUGGEST_COLUMN_INTENT_EXTRA_DATA = "suggest_intent_extra_data";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.016 -0400", hash_original_field = "72F43EE22FFBE24382A66D1D8B73F6E1", hash_generated_field = "EB444B421D95E311EEFB9312382F6861")

    public final static String SUGGEST_COLUMN_INTENT_DATA_ID = "suggest_intent_data_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.022 -0400", hash_original_field = "4650B4B74772A8292E871DE99C0618C4", hash_generated_field = "E278F68F6D4B4F689F230D22AEFB4DE6")

    public final static String SUGGEST_COLUMN_QUERY = "suggest_intent_query";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.023 -0400", hash_original_field = "F4A905950BA4E163A94E14D9D4326D99", hash_generated_field = "B189045F56AA5C5EF5522604E1BEB378")

    public final static String SUGGEST_COLUMN_SHORTCUT_ID = "suggest_shortcut_id";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.023 -0400", hash_original_field = "26369DCA4BF8CF161705F19277908B7D", hash_generated_field = "F1D87A1003C427958F0659488FDC6390")

    public final static String SUGGEST_COLUMN_SPINNER_WHILE_REFRESHING =
            "suggest_spinner_while_refreshing";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.029 -0400", hash_original_field = "3CD74C742B7C696040A3020191FD9DC2", hash_generated_field = "A9F939B64DF136370B79A6F04B0437D7")

    public final static String SUGGEST_COLUMN_FLAGS = "suggest_flags";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.030 -0400", hash_original_field = "8420A4B43FA4A0E770B498C6A21FA796", hash_generated_field = "CD1B40B21A18883CB9728A4C38A48A26")

    public final static String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.031 -0400", hash_original_field = "C5C94985A638C2C9BF59CF765A816F4A", hash_generated_field = "0C9EE03C85702025918EEB6DEB2682F1")

    public final static String SUGGEST_NEVER_MAKE_SHORTCUT = "_-1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.032 -0400", hash_original_field = "836908B5CCFEBD9A022E9041A82683A4", hash_generated_field = "F82A95521C9A30972DEEBF16134B6891")

    public final static String SUGGEST_PARAMETER_LIMIT = "limit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.166 -0400", hash_original_field = "4A921A787730F22AACABE7C1BE624D62", hash_generated_field = "A9C57219A2FF3C95E84D87BA6A76D882")

    public final static String INTENT_ACTION_GLOBAL_SEARCH
            = "android.search.action.GLOBAL_SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.166 -0400", hash_original_field = "227E3B70EBED9AC5B7C13A717BABDBAF", hash_generated_field = "FE0D7AD4B2E2653FEDBA2AE95C1982D7")

    public final static String INTENT_ACTION_SEARCH_SETTINGS
            = "android.search.action.SEARCH_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.167 -0400", hash_original_field = "F3C16DD3E9C563DF96236F69184AEFBF", hash_generated_field = "AB523D99F9BF1A52B69BCA38836606C1")

    public final static String INTENT_ACTION_WEB_SEARCH_SETTINGS
            = "android.search.action.WEB_SEARCH_SETTINGS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.167 -0400", hash_original_field = "914601D74FF6890A635C1A1049FC6696", hash_generated_field = "6B099326522966AFE91FEADCBF17FFE6")

    public final static String INTENT_ACTION_SEARCHABLES_CHANGED
            = "android.search.action.SEARCHABLES_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.177 -0400", hash_original_field = "582A169CE3B647644F304A9DF59A24E4", hash_generated_field = "DF412C661DD9A12B5FA8815315979AA7")

    public final static String INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED
            = "android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.177 -0400", hash_original_field = "555EE46CFA6ADB44544B971E8D45E5C2", hash_generated_field = "970288170E4371A4B6322E468B18023C")

    public final static String INTENT_ACTION_SEARCH_SETTINGS_CHANGED
            = "android.search.action.SETTINGS_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.178 -0400", hash_original_field = "59BFDFA20344037D6216DB75ABD6AFD3", hash_generated_field = "663DFC88F0FDE0085806A635CD6A059A")

    public final static String CONTEXT_IS_VOICE = "android.search.CONTEXT_IS_VOICE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.178 -0400", hash_original_field = "7341D36930505A24104A0DCB67E0BDE3", hash_generated_field = "A8F1CB36A318F7285CF4BA4C09590428")

    public final static String DISABLE_VOICE_SEARCH
            = "android.search.DISABLE_VOICE_SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.189 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "54AF07A923E4BFDD485986A50C78BE96")

    private static ISearchManager mService;
}

