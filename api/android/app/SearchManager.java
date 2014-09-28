package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

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

public class SearchManager implements DialogInterface.OnDismissListener, DialogInterface.OnCancelListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.412 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.414 -0500", hash_original_field = "EC590F4189897A1A0426B9BED7D50C77", hash_generated_field = "98C0772E1BD537CBFF8890EF0E8B5925")

    private static final String TAG = "SearchManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.417 -0500", hash_original_field = "2A718FF5E926635CD66C3F0DF6D26FE2", hash_generated_field = "6A8EF1344374530F0CC83766CC357C7F")

    public final static char MENU_KEY = 's';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.419 -0500", hash_original_field = "5D457F231F754EB337AE5DE1321577D8", hash_generated_field = "AB402987676139B693A67D1F6E8B08E6")

    public final static int MENU_KEYCODE = KeyEvent.KEYCODE_S;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.421 -0500", hash_original_field = "A973C6A881D51091815AA2E1EB8D05BB", hash_generated_field = "DA2BC7FD5EEE2F8ED75F388D1182DD62")

    public final static String QUERY = "query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.424 -0500", hash_original_field = "8F3BEEDADF1B8502EF3ED124E65BFD62", hash_generated_field = "0DA85A7F9E196BAFECDE08197B7CBD74")

    public final static String USER_QUERY = "user_query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.426 -0500", hash_original_field = "D261BBD1D9B9DF3C94F198EB2E2B77FA", hash_generated_field = "6C10EC3D2AC012F0FC0378D1B845CDB6")

    public final static String APP_DATA = "app_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.428 -0500", hash_original_field = "5BCC6A926D8CA7AA6131978C1F5A65CE", hash_generated_field = "E8BD4BF89D45446680C308150E6C7CA4")

    public final static String SEARCH_MODE = "search_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.431 -0500", hash_original_field = "BCF5FEC061711981C7B16D96BF86A9A3", hash_generated_field = "B3C481B56C06FC02C05BFD045C22E71F")

    public final static String ACTION_KEY = "action_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.433 -0500", hash_original_field = "562AAC830EE85C2BD77E125AED54F1F2", hash_generated_field = "513619AFFA7FD54880C474CCCFFFB09F")

    public final static String EXTRA_DATA_KEY = "intent_extra_data_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.435 -0500", hash_original_field = "156FBEA81CDE94BD45C984638AC3AFE6", hash_generated_field = "98D46B678386F431AF9D8507703A6BB0")

    public final static String EXTRA_SELECT_QUERY = "select_query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.437 -0500", hash_original_field = "D9413292E0FA52B7FD752A44F7FEABF5", hash_generated_field = "701CF8BE929057B0B7DC76A4107BF942")

    public final static String EXTRA_NEW_SEARCH = "new_search";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.440 -0500", hash_original_field = "563057056026D3F5B4FCE7A98CFF7DF5", hash_generated_field = "38710F744DB0569FE1FAAB0B781F14F7")

    public static final String EXTRA_WEB_SEARCH_PENDINGINTENT = "web_search_pendingintent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.442 -0500", hash_original_field = "A6CDF8B3968E9FD6D2A0E5AB7BCEDA00", hash_generated_field = "34D86458E5E413670449333BD0B356BE")

    public final static String CURSOR_EXTRA_KEY_IN_PROGRESS = "in_progress";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.444 -0500", hash_original_field = "CBC750FC3707EB3B2F5B995F930073E5", hash_generated_field = "A41EE9480DB530F333EA3EEDCC02D88F")

    public final static String ACTION_MSG = "action_msg";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.447 -0500", hash_original_field = "8B308D49D552CB89A86908DB181768EC", hash_generated_field = "445ECDFF72243EA4D9DDCBB69C6EA19E")

    public final static int FLAG_QUERY_REFINEMENT = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.449 -0500", hash_original_field = "178AFBB78538FCCAD585827FD3A218B4", hash_generated_field = "00A35FE0566FA4ACE21CCC96B7905A5E")

    public final static String SUGGEST_URI_PATH_QUERY = "search_suggest_query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.452 -0500", hash_original_field = "C7772CE9EA7883FBCEBA315B19D96D51", hash_generated_field = "0D0FDBC50154DF96510679E37FF6DC8D")

    public final static String SUGGEST_MIME_TYPE =
            "vnd.android.cursor.dir/vnd.android.search.suggest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.455 -0500", hash_original_field = "9357FE3DE8CF800F13F26811E35D7DEC", hash_generated_field = "A6E14EEEFFEC02E3E4CCCE4596BEC345")

    public final static String SUGGEST_URI_PATH_SHORTCUT = "search_suggest_shortcut";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.457 -0500", hash_original_field = "71CB6DAB2CBADCC569C9F50F0C41C9F9", hash_generated_field = "0BCD9772E06E18112651FC1C046153A7")

    public final static String SHORTCUT_MIME_TYPE =
            "vnd.android.cursor.item/vnd.android.search.suggest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.460 -0500", hash_original_field = "BC431B3CD194ED13829948591DC67841", hash_generated_field = "AEC68FB0FC60526D59B2FC65C0B0001A")

    public final static String SUGGEST_COLUMN_FORMAT = "suggest_format";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.463 -0500", hash_original_field = "D9AEAFBD9E17F90A28BFEB37269707A8", hash_generated_field = "659CB0D36B5570117518FBA7DC237393")

    public final static String SUGGEST_COLUMN_TEXT_1 = "suggest_text_1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.465 -0500", hash_original_field = "7F2C8270345017AB6193A72CF9FA3275", hash_generated_field = "9975BE3D7D195A4B03287638D8163C43")

    public final static String SUGGEST_COLUMN_TEXT_2 = "suggest_text_2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.467 -0500", hash_original_field = "1B08DA242BAF69D8142A42A05FA1F1D9", hash_generated_field = "E9420A73BA6409538B7B842CCE47C95C")

    public final static String SUGGEST_COLUMN_TEXT_2_URL = "suggest_text_2_url";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.470 -0500", hash_original_field = "C3B1D13B57424A9459E59251F9603893", hash_generated_field = "C9F1D1B59C31CC4CEBE55A88FB67FE47")

    public final static String SUGGEST_COLUMN_ICON_1 = "suggest_icon_1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.472 -0500", hash_original_field = "097B05FF3EDD917E9AF5C967019C2AD9", hash_generated_field = "2508AA2CC6815F08FDE48C6DB316521B")

    public final static String SUGGEST_COLUMN_ICON_2 = "suggest_icon_2";
    
    public interface OnDismissListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onDismiss();
    }
    
    public interface OnCancelListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onCancel();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.475 -0500", hash_original_field = "4907EDF000CAA815231D95F4F1E2E2A7", hash_generated_field = "ABC428E73F300198BAFB5CA25EDD54D5")

    public final static String SUGGEST_COLUMN_INTENT_ACTION = "suggest_intent_action";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.477 -0500", hash_original_field = "15A744732CD436CD6902D962960D1FA0", hash_generated_field = "27CA1EA72103B7D283C75B90C686978F")

    public final static String SUGGEST_COLUMN_INTENT_DATA = "suggest_intent_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.480 -0500", hash_original_field = "7D8B44432824EBC3FEDAB004BACE3BBE", hash_generated_field = "C929C796235C8EF386B4610F30D9924A")

    public final static String SUGGEST_COLUMN_INTENT_EXTRA_DATA = "suggest_intent_extra_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.482 -0500", hash_original_field = "C7B792B3722BE8F178500CECC82D93ED", hash_generated_field = "EB444B421D95E311EEFB9312382F6861")

    public final static String SUGGEST_COLUMN_INTENT_DATA_ID = "suggest_intent_data_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.484 -0500", hash_original_field = "783907F5ABF8CBC69A8A9E4751D9B91F", hash_generated_field = "E278F68F6D4B4F689F230D22AEFB4DE6")

    public final static String SUGGEST_COLUMN_QUERY = "suggest_intent_query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.487 -0500", hash_original_field = "234D707205DFE2F9FE30913B08BD3F1A", hash_generated_field = "B189045F56AA5C5EF5522604E1BEB378")

    public final static String SUGGEST_COLUMN_SHORTCUT_ID = "suggest_shortcut_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.489 -0500", hash_original_field = "3E944BE95495263392549B3435DCA437", hash_generated_field = "F1D87A1003C427958F0659488FDC6390")

    public final static String SUGGEST_COLUMN_SPINNER_WHILE_REFRESHING =
            "suggest_spinner_while_refreshing";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.492 -0500", hash_original_field = "0D0B4DF187AD9293021BE86803C3FBF1", hash_generated_field = "A9F939B64DF136370B79A6F04B0437D7")

    public final static String SUGGEST_COLUMN_FLAGS = "suggest_flags";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.495 -0500", hash_original_field = "F558374A817E7945D90E162F36F845AE", hash_generated_field = "CD1B40B21A18883CB9728A4C38A48A26")

    public final static String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.497 -0500", hash_original_field = "0DFFE090BCA1C994D29B50D4378A42DE", hash_generated_field = "0C9EE03C85702025918EEB6DEB2682F1")

    public final static String SUGGEST_NEVER_MAKE_SHORTCUT = "_-1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.499 -0500", hash_original_field = "4A1708562B1BB900537C0A23E7563105", hash_generated_field = "F82A95521C9A30972DEEBF16134B6891")

    public final static String SUGGEST_PARAMETER_LIMIT = "limit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.501 -0500", hash_original_field = "CB0F95B33ACECA2814C62BC8E5AE0436", hash_generated_field = "A9C57219A2FF3C95E84D87BA6A76D882")

    public final static String INTENT_ACTION_GLOBAL_SEARCH
            = "android.search.action.GLOBAL_SEARCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.504 -0500", hash_original_field = "5521D62628CA5BACAA53CB5B9C791909", hash_generated_field = "FE0D7AD4B2E2653FEDBA2AE95C1982D7")

    public final static String INTENT_ACTION_SEARCH_SETTINGS
            = "android.search.action.SEARCH_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.507 -0500", hash_original_field = "B809D867BEC92D6500FA6B5D51ED83A2", hash_generated_field = "AB523D99F9BF1A52B69BCA38836606C1")

    public final static String INTENT_ACTION_WEB_SEARCH_SETTINGS
            = "android.search.action.WEB_SEARCH_SETTINGS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.509 -0500", hash_original_field = "286C77059214031CFE3918934157A891", hash_generated_field = "6B099326522966AFE91FEADCBF17FFE6")

    public final static String INTENT_ACTION_SEARCHABLES_CHANGED
            = "android.search.action.SEARCHABLES_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.512 -0500", hash_original_field = "0AB7766E85F69F3220851308F98B3357", hash_generated_field = "DF412C661DD9A12B5FA8815315979AA7")

    public final static String INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED
            = "android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.515 -0500", hash_original_field = "8F4E49E1E3945F83EC2FF64579A485B8", hash_generated_field = "970288170E4371A4B6322E468B18023C")

    public final static String INTENT_ACTION_SEARCH_SETTINGS_CHANGED
            = "android.search.action.SETTINGS_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.517 -0500", hash_original_field = "894F900E831AE69E8117166A0184EDB3", hash_generated_field = "663DFC88F0FDE0085806A635CD6A059A")

    public final static String CONTEXT_IS_VOICE = "android.search.CONTEXT_IS_VOICE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.520 -0500", hash_original_field = "A4E7DF35F9AFABC00A710197B39D40A2", hash_generated_field = "A8F1CB36A318F7285CF4BA4C09590428")

    public final static String DISABLE_VOICE_SEARCH
            = "android.search.DISABLE_VOICE_SEARCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.522 -0500", hash_original_field = "358A5AD424B06ADB96914E81F0985E35", hash_generated_field = "54AF07A923E4BFDD485986A50C78BE96")

    private static ISearchManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.524 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.526 -0500", hash_original_field = "34442E2B955F925176D13B350E91112C", hash_generated_field = "E59E6E4A97DB236DE3DC575FA608E392")

    private String mAssociatedPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.528 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "D5A3F3493CA23C592A9EF4DFF10E8B9E")

    /* package */  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.530 -0500", hash_original_field = "37AE510189390F5EDCE0C931287B058E", hash_generated_field = "37AE510189390F5EDCE0C931287B058E")
 OnDismissListener mDismissListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.532 -0500", hash_original_field = "C21FFD1A2D31B4F8C0343E8367F7F155", hash_generated_field = "C21FFD1A2D31B4F8C0343E8367F7F155")
 OnCancelListener mCancelListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.534 -0500", hash_original_field = "B93D728F11520F5ED9A8F4EC523DF611", hash_generated_field = "247F9D3B324680CEDDC332FCA6608926")

    private SearchDialog mSearchDialog;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.537 -0500", hash_original_method = "A1F4172E8F505D7306645B5F1AC929D8", hash_generated_method = "A1F4172E8F505D7306645B5F1AC929D8")
    
SearchManager(Context context, Handler handler)  {
        mContext = context;
        mHandler = handler;
        mService = ISearchManager.Stub.asInterface(
                ServiceManager.getService(Context.SEARCH_SERVICE));
    }
    
    // Manually added
    
    public SearchManager(Context context) {
        mContext = context;
        addTaint(context.getTaint());

    }

    /**
     * Launch search UI.
     *
     * <p>The search manager will open a search widget in an overlapping
     * window, and the underlying activity may be obscured.  The search
     * entry state will remain in effect until one of the following events:
     * <ul>
     * <li>The user completes the search.  In most cases this will launch
     * a search intent.</li>
     * <li>The user uses the back, home, or other keys to exit the search.</li>
     * <li>The application calls the {@link #stopSearch}
     * method, which will hide the search window and return focus to the
     * activity from which it was launched.</li>
     *
     * <p>Most applications will <i>not</i> use this interface to invoke search.
     * The primary method for invoking search is to call
     * {@link android.app.Activity#onSearchRequested Activity.onSearchRequested()} or
     * {@link android.app.Activity#startSearch Activity.startSearch()}.
     *
     * @param initialQuery A search string can be pre-entered here, but this
     * is typically null or empty.
     * @param selectInitialQuery If true, the intial query will be preselected, which means that
     * any further typing will replace it.  This is useful for cases where an entire pre-formed
     * query is being inserted.  If false, the selection point will be placed at the end of the
     * inserted query.  This is useful when the inserted query is text that the user entered,
     * and the user would expect to be able to keep typing.  <i>This parameter is only meaningful
     * if initialQuery is a non-empty string.</i>
     * @param launchActivity The ComponentName of the activity that has launched this search.
     * @param appSearchData An application can insert application-specific
     * context here, in order to improve quality or specificity of its own
     * searches.  This data will be returned with SEARCH intent(s).  Null if
     * no extra data is required.
     * @param globalSearch If false, this will only launch the search that has been specifically
     * defined by the application (which is usually defined as a local search).  If no default
     * search is defined in the current application or activity, global search will be launched.
     * If true, this will always launch a platform-global (e.g. web-based) search instead.
     *
     * @see android.app.Activity#onSearchRequested
     * @see #stopSearch
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.539 -0500", hash_original_method = "A99B2740D078AE52E51C31205C7D1808", hash_generated_method = "A7C16716E4CF8DFC1749C19EB9862C5A")
    
public void startSearch(String initialQuery,
                            boolean selectInitialQuery,
                            ComponentName launchActivity,
                            Bundle appSearchData,
                            boolean globalSearch) {
        startSearch(initialQuery, selectInitialQuery, launchActivity,
                appSearchData, globalSearch, null);
    }

    /**
     * As {@link #startSearch(String, boolean, ComponentName, Bundle, boolean)} but including
     * source bounds for the global search intent.
     *
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.542 -0500", hash_original_method = "DA3F20917B57D7E33A815871BCDB23BC", hash_generated_method = "D25455AD659058EDE70278DEE5598F12")
    
public void startSearch(String initialQuery,
                            boolean selectInitialQuery,
                            ComponentName launchActivity,
                            Bundle appSearchData,
                            boolean globalSearch,
                            Rect sourceBounds) {
        if (globalSearch) {
            startGlobalSearch(initialQuery, selectInitialQuery, appSearchData, sourceBounds);
            return;
        }

        ensureSearchDialog();

        mSearchDialog.show(initialQuery, selectInitialQuery, launchActivity, appSearchData);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.545 -0500", hash_original_method = "69AA3000988676CA7D95377F664F088F", hash_generated_method = "0E71652007B9C63AB13538CC00185526")
    
private void ensureSearchDialog() {
        if (mSearchDialog == null) {
            mSearchDialog = new SearchDialog(mContext, this);
            mSearchDialog.setOnCancelListener(this);
            mSearchDialog.setOnDismissListener(this);
        }
    }

    /**
     * Starts the global search activity.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.547 -0500", hash_original_method = "665629AEED9E4B619C9A8F98A6E670F8", hash_generated_method = "9667A5DFF6E153D9414F2665C36C0D94")
    
void startGlobalSearch(String initialQuery, boolean selectInitialQuery,
            Bundle appSearchData, Rect sourceBounds) {
        ComponentName globalSearchActivity = getGlobalSearchActivity();
        if (globalSearchActivity == null) {
            Log.w(TAG, "No global search activity found.");
            return;
        }
        Intent intent = new Intent(INTENT_ACTION_GLOBAL_SEARCH);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(globalSearchActivity);
        // Make sure that we have a Bundle to put source in
        if (appSearchData == null) {
            appSearchData = new Bundle();
        } else {
            appSearchData = new Bundle(appSearchData);
        }
        // Set source to package name of app that starts global search, if not set already.
        if (!appSearchData.containsKey("source")) {
            appSearchData.putString("source", mContext.getPackageName());
        }
        intent.putExtra(APP_DATA, appSearchData);
        if (!TextUtils.isEmpty(initialQuery)) {
            intent.putExtra(QUERY, initialQuery);
        }
        if (selectInitialQuery) {
            intent.putExtra(EXTRA_SELECT_QUERY, selectInitialQuery);
        }
        intent.setSourceBounds(sourceBounds);
        try {
            if (DBG) Log.d(TAG, "Starting global search: " + intent.toUri(0));
            mContext.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Log.e(TAG, "Global search activity not found: " + globalSearchActivity);
        }
    }

    /**
     * Returns a list of installed apps that handle the global search
     * intent.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.550 -0500", hash_original_method = "C1495B155CB6927BC4386A7FC3D8EFF9", hash_generated_method = "DB4D3219FC41AF33B55F6ADC0B5CAF94")
    
public List<ResolveInfo> getGlobalSearchActivities() {
        try {
            return mService.getGlobalSearchActivities();
        } catch (RemoteException ex) {
            Log.e(TAG, "getGlobalSearchActivities() failed: " + ex);
            return null;
        }
    }

    /**
     * Gets the name of the global search activity.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.552 -0500", hash_original_method = "375B46C6B18E608C61AB732BC7ABBFF0", hash_generated_method = "911E93BB9734C43B09BD1541465D5BBB")
    
public ComponentName getGlobalSearchActivity() {
        try {
            return mService.getGlobalSearchActivity();
        } catch (RemoteException ex) {
            Log.e(TAG, "getGlobalSearchActivity() failed: " + ex);
            return null;
        }
    }

    /**
     * Gets the name of the web search activity.
     *
     * @return The name of the default activity for web searches. This activity
     *         can be used to get web search suggestions. Returns {@code null} if
     *         there is no default web search activity.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.554 -0500", hash_original_method = "B76C058C1256501309C0E936D28D0087", hash_generated_method = "4F5871C4AEDB3C5562043852E2B4BE8E")
    
public ComponentName getWebSearchActivity() {
        try {
            return mService.getWebSearchActivity();
        } catch (RemoteException ex) {
            Log.e(TAG, "getWebSearchActivity() failed: " + ex);
            return null;
        }
    }

    /**
     * Similar to {@link #startSearch} but actually fires off the search query after invoking
     * the search dialog.  Made available for testing purposes.
     *
     * @param query The query to trigger.  If empty, request will be ignored.
     * @param launchActivity The ComponentName of the activity that has launched this search.
     * @param appSearchData An application can insert application-specific
     * context here, in order to improve quality or specificity of its own
     * searches.  This data will be returned with SEARCH intent(s).  Null if
     * no extra data is required.
     *
     * @see #startSearch
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.557 -0500", hash_original_method = "DFA0F52B0EB2C924C24B76A319C2D2A5", hash_generated_method = "D2399AC977803B2C6953C30222A5BBBE")
    
public void triggerSearch(String query,
                              ComponentName launchActivity,
                              Bundle appSearchData) {
        if (!mAssociatedPackage.equals(launchActivity.getPackageName())) {
            throw new IllegalArgumentException("invoking app search on a different package " +
                    "not associated with this search manager");
        }
        if (query == null || TextUtils.getTrimmedLength(query) == 0) {
            Log.w(TAG, "triggerSearch called with empty query, ignoring.");
            return;
        }
        startSearch(query, false, launchActivity, appSearchData, false);
        mSearchDialog.launchQuerySearch();
    }

    /**
     * Terminate search UI.
     *
     * <p>Typically the user will terminate the search UI by launching a
     * search or by canceling.  This function allows the underlying application
     * or activity to cancel the search prematurely (for any reason).
     *
     * <p>This function can be safely called at any time (even if no search is active.)
     *
     * @see #startSearch
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.559 -0500", hash_original_method = "2F7F67ABA80342A48040CFA5F163FF23", hash_generated_method = "FD81FA840FA965970A420AB40183F00C")
    
public void stopSearch() {
        if (mSearchDialog != null) {
            mSearchDialog.cancel();
        }
    }

    /**
     * Determine if the Search UI is currently displayed.
     *
     * This is provided primarily for application test purposes.
     *
     * @return Returns true if the search UI is currently displayed.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.561 -0500", hash_original_method = "DBEBE34FE7AB0A40BB7E886EA7BCCC44", hash_generated_method = "061E2D3E8099A893150DED4DABE5470A")
    
public boolean isVisible() {
        return mSearchDialog == null? false : mSearchDialog.isShowing();
    }

    /**
     * Set or clear the callback that will be invoked whenever the search UI is dismissed.
     *
     * @param listener The {@link OnDismissListener} to use, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.568 -0500", hash_original_method = "168ADC282E12956DAABD30E8715DF8C4", hash_generated_method = "F22EA7FCF0BE63EA388FAE0E97B91BC9")
    
public void setOnDismissListener(final OnDismissListener listener) {
        mDismissListener = listener;
    }

    /**
     * Set or clear the callback that will be invoked whenever the search UI is canceled.
     *
     * @param listener The {@link OnCancelListener} to use, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.570 -0500", hash_original_method = "E54B891234FF1D09C5FE1330F548AE5B", hash_generated_method = "9F93FC98117686AD18CA2313E3382479")
    
public void setOnCancelListener(OnCancelListener listener) {
        mCancelListener = listener;
    }

    /**
     * @deprecated This method is an obsolete internal implementation detail. Do not use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.572 -0500", hash_original_method = "FD32FDBC83426B134794541111A0C683", hash_generated_method = "D7C51277EDB7E754D76E5D0058A4CF56")
    
@Deprecated
    public void onCancel(DialogInterface dialog) {
        if (mCancelListener != null) {
            mCancelListener.onCancel();
        }
    }

    /**
     * @deprecated This method is an obsolete internal implementation detail. Do not use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.574 -0500", hash_original_method = "832CAC02C422B9B1DA3F12954DC922BF", hash_generated_method = "C4136A6B95FBBA9E401718F7B18B08C3")
    
@Deprecated
    public void onDismiss(DialogInterface dialog) {
        if (mDismissListener != null) {
            mDismissListener.onDismiss();
        }
    }

    /**
     * Gets information about a searchable activity.
     *
     * @param componentName The activity to get searchable information for.
     * @return Searchable information, or <code>null</code> if the activity does not
     *         exist, or is not searchable.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.REMOTE_APP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.576 -0500", hash_original_method = "BECD96EDDDF4DA2CCA14D2ABA4ED0EE3", hash_generated_method = "0A2930B9F3A3D87660C73C288FF26183")
    
public SearchableInfo getSearchableInfo(ComponentName componentName) {
        try {
            return mService.getSearchableInfo(componentName);
        } catch (RemoteException ex) {
            Log.e(TAG, "getSearchableInfo() failed: " + ex);
            return null;
        }
    }

    /**
     * Gets a cursor with search suggestions.
     *
     * @param searchable Information about how to get the suggestions.
     * @param query The search text entered (so far).
     * @return a cursor with suggestions, or <code>null</null> the suggestion query failed.
     *
     * @hide because SearchableInfo is not part of the API.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.578 -0500", hash_original_method = "8998A0F3078F1A486029D8083CC723D6", hash_generated_method = "CFAD615B6C154A9633115783582DB708")
    
public Cursor getSuggestions(SearchableInfo searchable, String query) {
        return getSuggestions(searchable, query, -1);
    }

    /**
     * Gets a cursor with search suggestions.
     *
     * @param searchable Information about how to get the suggestions.
     * @param query The search text entered (so far).
     * @param limit The query limit to pass to the suggestion provider. This is advisory,
     *        the returned cursor may contain more rows. Pass {@code -1} for no limit.
     * @return a cursor with suggestions, or <code>null</null> the suggestion query failed.
     *
     * @hide because SearchableInfo is not part of the API.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.582 -0500", hash_original_method = "E15CCFC152F5A7E151DA9EBD5A00EC08", hash_generated_method = "124202710E5CB091192B2F7D7FD9040B")
    
public Cursor getSuggestions(SearchableInfo searchable, String query, int limit) {
        if (searchable == null) {
            return null;
        }

        String authority = searchable.getSuggestAuthority();
        if (authority == null) {
            return null;
        }

        Uri.Builder uriBuilder = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_CONTENT)
                .authority(authority)
                .query("")  // TODO: Remove, workaround for a bug in Uri.writeToParcel()
                .fragment("");  // TODO: Remove, workaround for a bug in Uri.writeToParcel()

        // if content path provided, insert it now
        final String contentPath = searchable.getSuggestPath();
        if (contentPath != null) {
            uriBuilder.appendEncodedPath(contentPath);
        }

        // append standard suggestion query path
        uriBuilder.appendPath(SearchManager.SUGGEST_URI_PATH_QUERY);

        // get the query selection, may be null
        String selection = searchable.getSuggestSelection();
        // inject query, either as selection args or inline
        String[] selArgs = null;
        if (selection != null) {    // use selection if provided
            selArgs = new String[] { query };
        } else {                    // no selection, use REST pattern
            uriBuilder.appendPath(query);
        }

        if (limit > 0) {
            uriBuilder.appendQueryParameter(SUGGEST_PARAMETER_LIMIT, String.valueOf(limit));
        }

        Uri uri = uriBuilder.build();

        // finally, make the query
        return mContext.getContentResolver().query(uri, null, selection, selArgs, null);
    }

    /**
     * Returns a list of the searchable activities that can be included in global search.
     *
     * @return a list containing searchable information for all searchable activities
     *         that have the <code>android:includeInGlobalSearch</code> attribute set
     *         in their searchable meta-data.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.584 -0500", hash_original_method = "1D69522720A8D25D6502045F710E48DA", hash_generated_method = "614E75FC6E7339B3DE2A2EEE6EF87599")
    
public List<SearchableInfo> getSearchablesInGlobalSearch() {
        try {
            return mService.getSearchablesInGlobalSearch();
        } catch (RemoteException e) {
            Log.e(TAG, "getSearchablesInGlobalSearch() failed: " + e);
            return null;
        }
    }
}

