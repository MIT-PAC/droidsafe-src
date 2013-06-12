package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final boolean DBG = false;
    private static final String TAG = "SearchManager";
    public final static char MENU_KEY = 's';
    public final static int MENU_KEYCODE = KeyEvent.KEYCODE_S;
    public final static String QUERY = "query";
    public final static String USER_QUERY = "user_query";
    public final static String APP_DATA = "app_data";
    public final static String SEARCH_MODE = "search_mode";
    public final static String ACTION_KEY = "action_key";
    public final static String EXTRA_DATA_KEY = "intent_extra_data_key";
    public final static String EXTRA_SELECT_QUERY = "select_query";
    public final static String EXTRA_NEW_SEARCH = "new_search";
    public static final String EXTRA_WEB_SEARCH_PENDINGINTENT = "web_search_pendingintent";
    public final static String CURSOR_EXTRA_KEY_IN_PROGRESS = "in_progress";
    public final static String ACTION_MSG = "action_msg";
    public final static int FLAG_QUERY_REFINEMENT = 1 << 0;
    public final static String SUGGEST_URI_PATH_QUERY = "search_suggest_query";
    public final static String SUGGEST_MIME_TYPE =
            "vnd.android.cursor.dir/vnd.android.search.suggest";
    public final static String SUGGEST_URI_PATH_SHORTCUT = "search_suggest_shortcut";
    public final static String SHORTCUT_MIME_TYPE =
            "vnd.android.cursor.item/vnd.android.search.suggest";
    public final static String SUGGEST_COLUMN_FORMAT = "suggest_format";
    public final static String SUGGEST_COLUMN_TEXT_1 = "suggest_text_1";
    public final static String SUGGEST_COLUMN_TEXT_2 = "suggest_text_2";
    public final static String SUGGEST_COLUMN_TEXT_2_URL = "suggest_text_2_url";
    public final static String SUGGEST_COLUMN_ICON_1 = "suggest_icon_1";
    public final static String SUGGEST_COLUMN_ICON_2 = "suggest_icon_2";
    public final static String SUGGEST_COLUMN_INTENT_ACTION = "suggest_intent_action";
    public final static String SUGGEST_COLUMN_INTENT_DATA = "suggest_intent_data";
    public final static String SUGGEST_COLUMN_INTENT_EXTRA_DATA = "suggest_intent_extra_data";
    public final static String SUGGEST_COLUMN_INTENT_DATA_ID = "suggest_intent_data_id";
    public final static String SUGGEST_COLUMN_QUERY = "suggest_intent_query";
    public final static String SUGGEST_COLUMN_SHORTCUT_ID = "suggest_shortcut_id";
    public final static String SUGGEST_COLUMN_SPINNER_WHILE_REFRESHING =
            "suggest_spinner_while_refreshing";
    public final static String SUGGEST_COLUMN_FLAGS = "suggest_flags";
    public final static String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";
    public final static String SUGGEST_NEVER_MAKE_SHORTCUT = "_-1";
    public final static String SUGGEST_PARAMETER_LIMIT = "limit";
    public final static String INTENT_ACTION_GLOBAL_SEARCH
            = "android.search.action.GLOBAL_SEARCH";
    public final static String INTENT_ACTION_SEARCH_SETTINGS
            = "android.search.action.SEARCH_SETTINGS";
    public final static String INTENT_ACTION_WEB_SEARCH_SETTINGS
            = "android.search.action.WEB_SEARCH_SETTINGS";
    public final static String INTENT_ACTION_SEARCHABLES_CHANGED
            = "android.search.action.SEARCHABLES_CHANGED";
    public final static String INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED
            = "android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED";
    public final static String INTENT_ACTION_SEARCH_SETTINGS_CHANGED
            = "android.search.action.SETTINGS_CHANGED";
    public final static String CONTEXT_IS_VOICE = "android.search.CONTEXT_IS_VOICE";
    public final static String DISABLE_VOICE_SEARCH
            = "android.search.DISABLE_VOICE_SEARCH";
    private static ISearchManager mService;
    private final Context mContext;
    private String mAssociatedPackage;
    final Handler mHandler;
    OnDismissListener mDismissListener = null;
    OnCancelListener mCancelListener = null;
    private SearchDialog mSearchDialog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.016 -0400", hash_original_method = "A1F4172E8F505D7306645B5F1AC929D8", hash_generated_method = "A920999F11B7D08409FBC3E4F865962B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SearchManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        mHandler = handler;
        mContext = context;
        mService = ISearchManager.Stub.asInterface(
                ServiceManager.getService(Context.SEARCH_SERVICE));
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = handler;
        //mService = ISearchManager.Stub.asInterface(
                //ServiceManager.getService(Context.SEARCH_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.016 -0400", hash_original_method = "A99B2740D078AE52E51C31205C7D1808", hash_generated_method = "09095AD25982B282E27E72ADBF9F764E")
    @DSModeled(DSC.SAFE)
    public void startSearch(String initialQuery,
                            boolean selectInitialQuery,
                            ComponentName launchActivity,
                            Bundle appSearchData,
                            boolean globalSearch) {
        dsTaint.addTaint(globalSearch);
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(launchActivity.dsTaint);
        dsTaint.addTaint(selectInitialQuery);
        dsTaint.addTaint(initialQuery);
        startSearch(initialQuery, selectInitialQuery, launchActivity,
                appSearchData, globalSearch, null);
        // ---------- Original Method ----------
        //startSearch(initialQuery, selectInitialQuery, launchActivity,
                //appSearchData, globalSearch, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.016 -0400", hash_original_method = "DA3F20917B57D7E33A815871BCDB23BC", hash_generated_method = "79CB555358371BE4BC393870C483FE66")
    @DSModeled(DSC.SAFE)
    public void startSearch(String initialQuery,
                            boolean selectInitialQuery,
                            ComponentName launchActivity,
                            Bundle appSearchData,
                            boolean globalSearch,
                            Rect sourceBounds) {
        dsTaint.addTaint(globalSearch);
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(launchActivity.dsTaint);
        dsTaint.addTaint(selectInitialQuery);
        dsTaint.addTaint(initialQuery);
        dsTaint.addTaint(sourceBounds.dsTaint);
        {
            startGlobalSearch(initialQuery, selectInitialQuery, appSearchData, sourceBounds);
        } //End block
        ensureSearchDialog();
        mSearchDialog.show(initialQuery, selectInitialQuery, launchActivity, appSearchData);
        // ---------- Original Method ----------
        //if (globalSearch) {
            //startGlobalSearch(initialQuery, selectInitialQuery, appSearchData, sourceBounds);
            //return;
        //}
        //ensureSearchDialog();
        //mSearchDialog.show(initialQuery, selectInitialQuery, launchActivity, appSearchData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.017 -0400", hash_original_method = "69AA3000988676CA7D95377F664F088F", hash_generated_method = "8CF55C33F61CA456F0B676241D7208B0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.017 -0400", hash_original_method = "665629AEED9E4B619C9A8F98A6E670F8", hash_generated_method = "C352359E79D4C40C2FDF98BB7B2A30C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startGlobalSearch(String initialQuery, boolean selectInitialQuery,
            Bundle appSearchData, Rect sourceBounds) {
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(selectInitialQuery);
        dsTaint.addTaint(initialQuery);
        dsTaint.addTaint(sourceBounds.dsTaint);
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
            boolean var10A0DC8AF7B837921F2947865537DC8D_1441497609 = (!appSearchData.containsKey("source"));
            {
                appSearchData.putString("source", mContext.getPackageName());
            } //End block
        } //End collapsed parenthetic
        intent.putExtra(APP_DATA, appSearchData);
        {
            boolean varE3CA76AADF92382138D264810F53FC4F_1998138703 = (!TextUtils.isEmpty(initialQuery));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.018 -0400", hash_original_method = "C1495B155CB6927BC4386A7FC3D8EFF9", hash_generated_method = "01932B725B43DADD2EA4210FBC2E2889")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ResolveInfo> getGlobalSearchActivities() {
        try 
        {
            List<ResolveInfo> var06F574A5D57A5DCC0FFA6AF09D63AB06_764515552 = (mService.getGlobalSearchActivities());
        } //End block
        catch (RemoteException ex)
        { }
        return (List<ResolveInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getGlobalSearchActivities();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getGlobalSearchActivities() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.018 -0400", hash_original_method = "375B46C6B18E608C61AB732BC7ABBFF0", hash_generated_method = "DE6F53D5CEB39C5C89792A276E535549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getGlobalSearchActivity() {
        try 
        {
            ComponentName var193D0ECA7C8DC8833B3D2BE46ACCA44B_341343798 = (mService.getGlobalSearchActivity());
        } //End block
        catch (RemoteException ex)
        { }
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getGlobalSearchActivity();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getGlobalSearchActivity() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.018 -0400", hash_original_method = "B76C058C1256501309C0E936D28D0087", hash_generated_method = "D2AB1B67BA0103BFA4502387085C85DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getWebSearchActivity() {
        try 
        {
            ComponentName varF5E4A6C434B08F56981EBEEFE10E8E94_1313043362 = (mService.getWebSearchActivity());
        } //End block
        catch (RemoteException ex)
        { }
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getWebSearchActivity();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getWebSearchActivity() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.019 -0400", hash_original_method = "DFA0F52B0EB2C924C24B76A319C2D2A5", hash_generated_method = "E0FDDA280728099130A08FB11CCB030E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void triggerSearch(String query,
                              ComponentName launchActivity,
                              Bundle appSearchData) {
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(query);
        dsTaint.addTaint(launchActivity.dsTaint);
        {
            boolean var7466BBCFAEAAA91B3F06D691B172825F_2125802999 = (!mAssociatedPackage.equals(launchActivity.getPackageName()));
            {
            	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invoking app search on a different package " +
                    "not associated with this search manager");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD89BCBA31628E825208427C7DCE18216_1399992772 = (query == null || TextUtils.getTrimmedLength(query) == 0);
        } //End collapsed parenthetic
        startSearch(query, false, launchActivity, appSearchData, false);
        mSearchDialog.launchQuerySearch();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.019 -0400", hash_original_method = "2F7F67ABA80342A48040CFA5F163FF23", hash_generated_method = "BF29C39ED48133759B483CDDE6178C9B")
    @DSModeled(DSC.SAFE)
    public void stopSearch() {
        {
            mSearchDialog.cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mSearchDialog != null) {
            //mSearchDialog.cancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.019 -0400", hash_original_method = "DBEBE34FE7AB0A40BB7E886EA7BCCC44", hash_generated_method = "D69686D26A2042405AFBF52A3D0768F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isVisible() {
        {
            Object var34EE0F15CA6D20FF3CF863C5B2F3C28B_1532646785 = (mSearchDialog.isShowing());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSearchDialog == null? false : mSearchDialog.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.020 -0400", hash_original_method = "168ADC282E12956DAABD30E8715DF8C4", hash_generated_method = "B9D350B1DC6080295AC8A3AA139722F3")
    @DSModeled(DSC.SAFE)
    public void setOnDismissListener(final OnDismissListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mDismissListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.020 -0400", hash_original_method = "E54B891234FF1D09C5FE1330F548AE5B", hash_generated_method = "E62BE57A4797D810085DD390A5FD2047")
    @DSModeled(DSC.SAFE)
    public void setOnCancelListener(OnCancelListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mCancelListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.020 -0400", hash_original_method = "FD32FDBC83426B134794541111A0C683", hash_generated_method = "E0D42C194E7AB99DA4FDA55DD3736A49")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onCancel(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(dialog.dsTaint);
        {
            mCancelListener.onCancel();
        } //End block
        // ---------- Original Method ----------
        //if (mCancelListener != null) {
            //mCancelListener.onCancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.021 -0400", hash_original_method = "832CAC02C422B9B1DA3F12954DC922BF", hash_generated_method = "14A565413D58AA70C575C318607206E6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(dialog.dsTaint);
        {
            mDismissListener.onDismiss();
        } //End block
        // ---------- Original Method ----------
        //if (mDismissListener != null) {
            //mDismissListener.onDismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.021 -0400", hash_original_method = "BECD96EDDDF4DA2CCA14D2ABA4ED0EE3", hash_generated_method = "4C72C4B9DEDC9DA2A3C444BBA58DE43D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SearchableInfo getSearchableInfo(ComponentName componentName) {
        dsTaint.addTaint(componentName.dsTaint);
        try 
        {
            SearchableInfo var3456E2DBF0D6E22557BD9026EE16DB07_451794164 = (mService.getSearchableInfo(componentName));
        } //End block
        catch (RemoteException ex)
        { }
        return (SearchableInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return mService.getSearchableInfo(componentName);
        //} catch (RemoteException ex) {
            //Log.e(TAG, "getSearchableInfo() failed: " + ex);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.021 -0400", hash_original_method = "8998A0F3078F1A486029D8083CC723D6", hash_generated_method = "171825F50F9686105FEF2021BAE3D6AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor getSuggestions(SearchableInfo searchable, String query) {
        dsTaint.addTaint(query);
        dsTaint.addTaint(searchable.dsTaint);
        Cursor var06C4B102839F85A1A47A69F9755C5DF5_1611655263 = (getSuggestions(searchable, query, -1));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getSuggestions(searchable, query, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.022 -0400", hash_original_method = "E15CCFC152F5A7E151DA9EBD5A00EC08", hash_generated_method = "0ED0115432B1BEB312691204A03E8827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor getSuggestions(SearchableInfo searchable, String query, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(query);
        dsTaint.addTaint(searchable.dsTaint);
        String authority;
        authority = searchable.getSuggestAuthority();
        Uri.Builder uriBuilder;
        uriBuilder = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(authority)
                .query("")  
                .fragment("");
        final String contentPath;
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
        Cursor var90D57C95D0EAA8941B9F60F68581C280_2107226508 = (mContext.getContentResolver().query(uri, null, selection, selArgs, null));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.022 -0400", hash_original_method = "1D69522720A8D25D6502045F710E48DA", hash_generated_method = "1B1D1BCBA5479D85F0157EB07F17160D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<SearchableInfo> getSearchablesInGlobalSearch() {
        try 
        {
            List<SearchableInfo> var0290418A075A60220E694E1646B76CA5_1890344757 = (mService.getSearchablesInGlobalSearch());
        } //End block
        catch (RemoteException e)
        { }
        return (List<SearchableInfo>)dsTaint.getTaint();
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
    
}


